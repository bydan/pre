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


import com.bydan.erp.facturacion.util.ParametroFactuPrincipalConstantesFunciones;
import com.bydan.erp.facturacion.util.ParametroFactuPrincipalParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ParametroFactuPrincipalParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroFactuPrincipalConstantesFunciones extends ParametroFactuPrincipalConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroFactuPrincipal";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroFactuPrincipal"+ParametroFactuPrincipalConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroFactuPrincipalHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroFactuPrincipalHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroFactuPrincipalConstantesFunciones.SCHEMA+"_"+ParametroFactuPrincipalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroFactuPrincipalHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroFactuPrincipalConstantesFunciones.SCHEMA+"_"+ParametroFactuPrincipalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroFactuPrincipalConstantesFunciones.SCHEMA+"_"+ParametroFactuPrincipalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroFactuPrincipalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroFactuPrincipalConstantesFunciones.SCHEMA+"_"+ParametroFactuPrincipalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFactuPrincipalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroFactuPrincipalHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFactuPrincipalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFactuPrincipalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroFactuPrincipalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFactuPrincipalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroFactuPrincipalConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroFactuPrincipalConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroFactuPrincipalConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroFactuPrincipalConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Principal s";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parametro Principal ";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Factu Principal";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroFactuPrincipal";
	public static final String OBJECTNAME="parametrofactuprincipal";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="parametro_factu_principal";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametrofactuprincipal from "+ParametroFactuPrincipalConstantesFunciones.SPERSISTENCENAME+" parametrofactuprincipal";
	public static String QUERYSELECTNATIVE="select "+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".version_row,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_empresa,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_tipo_param_factu_descuento,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_tipo_param_factu_listado_cliente,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_tipo_param_factu_secuencia_trabajo,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_tipo_documento_factura,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_tipo_documento_nota_credito,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_tipo_documento_nota_debito,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".en_linea,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_cuenta_tipo_cliente,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_cliente_impuesto,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_libro_contable,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_moneda,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_impresion,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_formato,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_secuencial_usuario,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_secuencial_editable,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_precio_por_cliente,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_modificar_precio,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_modificar_servicio,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_cambiar_unidad,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".numero_decimales_unidad,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_activar_serie,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_activar_lote,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_activar_multi_empresa,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_centro_costos,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_unidades,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_cupo_disponible,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_forma_pago,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_envio_mail,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_autorizar_proforma,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_bloqueo_pedido,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_control_anticipo,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_factura_auto,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_grabar_valor_cero,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_agregar_item,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".numero_copias,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".leyenda,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_sin_factura,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_cuenta_contable_flete_venta,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_cuenta_contable_otro_cargo,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_cuenta_contable_finan,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_cuenta_contable_boni,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_cuenta_contable_boni_devol,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_cuenta_contable_ice from "+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME;//+" as "+ParametroFactuPrincipalConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroFactuPrincipalConstantesFuncionesAdditional parametrofactuprincipalConstantesFuncionesAdditional=null;
	
	public ParametroFactuPrincipalConstantesFuncionesAdditional getParametroFactuPrincipalConstantesFuncionesAdditional() {
		return this.parametrofactuprincipalConstantesFuncionesAdditional;
	}
	
	public void setParametroFactuPrincipalConstantesFuncionesAdditional(ParametroFactuPrincipalConstantesFuncionesAdditional parametrofactuprincipalConstantesFuncionesAdditional) {
		try {
			this.parametrofactuprincipalConstantesFuncionesAdditional=parametrofactuprincipalConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDTIPOPARAMFACTUDESCUENTO= "id_tipo_param_factu_descuento";
    public static final String IDTIPOPARAMFACTULISTADOCLIENTE= "id_tipo_param_factu_listado_cliente";
    public static final String IDTIPOPARAMFACTUSECUENCIATRABAJO= "id_tipo_param_factu_secuencia_trabajo";
    public static final String IDTIPODOCUMENTOFACTURA= "id_tipo_documento_factura";
    public static final String IDTIPODOCUMENTONOTACREDITO= "id_tipo_documento_nota_credito";
    public static final String IDTIPODOCUMENTONOTADEBITO= "id_tipo_documento_nota_debito";
    public static final String ENLINEA= "en_linea";
    public static final String CONCUENTATIPOCLIENTE= "con_cuenta_tipo_cliente";
    public static final String CONCLIENTEIMPUESTO= "con_cliente_impuesto";
    public static final String IDLIBROCONTABLE= "id_libro_contable";
    public static final String IDMONEDA= "id_moneda";
    public static final String CONIMPRESION= "con_impresion";
    public static final String IDFORMATO= "id_formato";
    public static final String CONSECUENCIALUSUARIO= "con_secuencial_usuario";
    public static final String CONSECUENCIALEDITABLE= "con_secuencial_editable";
    public static final String CONPRECIOPORCLIENTE= "con_precio_por_cliente";
    public static final String CONMODIFICARPRECIO= "con_modificar_precio";
    public static final String CONMODIFICARSERVICIO= "con_modificar_servicio";
    public static final String CONCAMBIARUNIDAD= "con_cambiar_unidad";
    public static final String NUMERODECIMALESUNIDAD= "numero_decimales_unidad";
    public static final String CONACTIVARSERIE= "con_activar_serie";
    public static final String CONACTIVARLOTE= "con_activar_lote";
    public static final String CONACTIVARMULTIEMPRESA= "con_activar_multi_empresa";
    public static final String CONCENTROCOSTOS= "con_centro_costos";
    public static final String CONUNIDADES= "con_unidades";
    public static final String CONCUPODISPONIBLE= "con_cupo_disponible";
    public static final String CONFORMAPAGO= "con_forma_pago";
    public static final String CONENVIOMAIL= "con_envio_mail";
    public static final String CONAUTORIZARPROFORMA= "con_autorizar_proforma";
    public static final String CONBLOQUEOPEDIDO= "con_bloqueo_pedido";
    public static final String CONCONTROLANTICIPO= "con_control_anticipo";
    public static final String CONFACTURAAUTO= "con_factura_auto";
    public static final String CONGRABARVALORCERO= "con_grabar_valor_cero";
    public static final String CONAGREGARITEM= "con_agregar_item";
    public static final String NUMEROCOPIAS= "numero_copias";
    public static final String LEYENDA= "leyenda";
    public static final String CONSINFACTURA= "con_sin_factura";
    public static final String IDCUENTACONTABLEFLETEVENTA= "id_cuenta_contable_flete_venta";
    public static final String IDCUENTACONTABLEOTROCARGO= "id_cuenta_contable_otro_cargo";
    public static final String IDCUENTACONTABLEFINAN= "id_cuenta_contable_finan";
    public static final String IDCUENTACONTABLEBONI= "id_cuenta_contable_boni";
    public static final String IDCUENTACONTABLEBONIDEVOL= "id_cuenta_contable_boni_devol";
    public static final String IDCUENTACONTABLEICE= "id_cuenta_contable_ice";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDTIPOPARAMFACTUDESCUENTO= "T  Descuento General";
		public static final String LABEL_IDTIPOPARAMFACTUDESCUENTO_LOWER= "Tipo Param Factu Descuento";
    	public static final String LABEL_IDTIPOPARAMFACTULISTADOCLIENTE= "T  Listado Cliente/Prov";
		public static final String LABEL_IDTIPOPARAMFACTULISTADOCLIENTE_LOWER= "Tipo Param Factu Listado Cliente";
    	public static final String LABEL_IDTIPOPARAMFACTUSECUENCIATRABAJO= "T Secuencia De Trabajo";
		public static final String LABEL_IDTIPOPARAMFACTUSECUENCIATRABAJO_LOWER= "Tipo Param Factu Secuencia Trabajo";
    	public static final String LABEL_IDTIPODOCUMENTOFACTURA= "T Documento Factura";
		public static final String LABEL_IDTIPODOCUMENTOFACTURA_LOWER= "Tipo Documento Factura";
    	public static final String LABEL_IDTIPODOCUMENTONOTACREDITO= "T Doc Nota Credito";
		public static final String LABEL_IDTIPODOCUMENTONOTACREDITO_LOWER= "Tipo Documento Nota Credito";
    	public static final String LABEL_IDTIPODOCUMENTONOTADEBITO= "T Doc Nota Debito";
		public static final String LABEL_IDTIPODOCUMENTONOTADEBITO_LOWER= "Tipo Documento Nota Debito";
    	public static final String LABEL_ENLINEA= "Contabilizacion En Linea";
		public static final String LABEL_ENLINEA_LOWER= "En Linea";
    	public static final String LABEL_CONCUENTATIPOCLIENTE= "Cuenta Tipo Cliente";
		public static final String LABEL_CONCUENTATIPOCLIENTE_LOWER= "Con Cuenta Tipo Cliente";
    	public static final String LABEL_CONCLIENTEIMPUESTO= "Cliente Impuesto";
		public static final String LABEL_CONCLIENTEIMPUESTO_LOWER= "Con Cliente Impuesto";
    	public static final String LABEL_IDLIBROCONTABLE= "Libro Contable";
		public static final String LABEL_IDLIBROCONTABLE_LOWER= "Libro Contable";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_CONIMPRESION= "Impresion";
		public static final String LABEL_CONIMPRESION_LOWER= "Con Impresion";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_CONSECUENCIALUSUARIO= "Secuencial Usuario";
		public static final String LABEL_CONSECUENCIALUSUARIO_LOWER= "Con Secuencial Usuario";
    	public static final String LABEL_CONSECUENCIALEDITABLE= "Secuencial Editable";
		public static final String LABEL_CONSECUENCIALEDITABLE_LOWER= "Con Secuencial Editable";
    	public static final String LABEL_CONPRECIOPORCLIENTE= "Precio Por Cliente";
		public static final String LABEL_CONPRECIOPORCLIENTE_LOWER= "Con Precio Por Cliente";
    	public static final String LABEL_CONMODIFICARPRECIO= "Modificar Precio";
		public static final String LABEL_CONMODIFICARPRECIO_LOWER= "Con Modificar Precio";
    	public static final String LABEL_CONMODIFICARSERVICIO= "Modificar Servicio";
		public static final String LABEL_CONMODIFICARSERVICIO_LOWER= "Con Modificar Servicio";
    	public static final String LABEL_CONCAMBIARUNIDAD= "Cambiar Unidad";
		public static final String LABEL_CONCAMBIARUNIDAD_LOWER= "Con Cambiar Unidad";
    	public static final String LABEL_NUMERODECIMALESUNIDAD= "No Decimales Unidad";
		public static final String LABEL_NUMERODECIMALESUNIDAD_LOWER= "Numero Decimales Unidad";
    	public static final String LABEL_CONACTIVARSERIE= "Activar Serie";
		public static final String LABEL_CONACTIVARSERIE_LOWER= "Con Activar Serie";
    	public static final String LABEL_CONACTIVARLOTE= "Activar Lote";
		public static final String LABEL_CONACTIVARLOTE_LOWER= "Con Activar Lote";
    	public static final String LABEL_CONACTIVARMULTIEMPRESA= "Activar Multi Empresa";
		public static final String LABEL_CONACTIVARMULTIEMPRESA_LOWER= "Con Activar Multi Empresa";
    	public static final String LABEL_CONCENTROCOSTOS= "Centro Costos";
		public static final String LABEL_CONCENTROCOSTOS_LOWER= "Con Centro Costos";
    	public static final String LABEL_CONUNIDADES= "Convertir Unidades";
		public static final String LABEL_CONUNIDADES_LOWER= "Con Unidades";
    	public static final String LABEL_CONCUPODISPONIBLE= "Cupo Disponible";
		public static final String LABEL_CONCUPODISPONIBLE_LOWER= "Con Cupo Disponible";
    	public static final String LABEL_CONFORMAPAGO= "Activar Forma Pago";
		public static final String LABEL_CONFORMAPAGO_LOWER= "Con Forma Pago";
    	public static final String LABEL_CONENVIOMAIL= "Envio Mail";
		public static final String LABEL_CONENVIOMAIL_LOWER= "Con Envio Mail";
    	public static final String LABEL_CONAUTORIZARPROFORMA= "Autorizar Proforma";
		public static final String LABEL_CONAUTORIZARPROFORMA_LOWER= "Con Autorizar Proforma";
    	public static final String LABEL_CONBLOQUEOPEDIDO= "Bloqueo Pedido";
		public static final String LABEL_CONBLOQUEOPEDIDO_LOWER= "Con Bloqueo Pedido";
    	public static final String LABEL_CONCONTROLANTICIPO= "Control Anticipo";
		public static final String LABEL_CONCONTROLANTICIPO_LOWER= "Con Control Anticipo";
    	public static final String LABEL_CONFACTURAAUTO= "Facturacion Auto.";
		public static final String LABEL_CONFACTURAAUTO_LOWER= "Con Factura Auto";
    	public static final String LABEL_CONGRABARVALORCERO= "Grabar Valor 0";
		public static final String LABEL_CONGRABARVALORCERO_LOWER= "Con Grabar Valor Cero";
    	public static final String LABEL_CONAGREGARITEM= "Agregar Item";
		public static final String LABEL_CONAGREGARITEM_LOWER= "Con Agregar Item";
    	public static final String LABEL_NUMEROCOPIAS= "No Copias";
		public static final String LABEL_NUMEROCOPIAS_LOWER= "Numero Copias";
    	public static final String LABEL_LEYENDA= "Leyenda";
		public static final String LABEL_LEYENDA_LOWER= "Leyenda";
    	public static final String LABEL_CONSINFACTURA= "Sin Factura";
		public static final String LABEL_CONSINFACTURA_LOWER= "Con Sin Factura";
    	public static final String LABEL_IDCUENTACONTABLEFLETEVENTA= "C. C. Flete En  Venta";
		public static final String LABEL_IDCUENTACONTABLEFLETEVENTA_LOWER= "Cuenta Contable Flete Venta";
    	public static final String LABEL_IDCUENTACONTABLEOTROCARGO= "C C. Otros Cargos";
		public static final String LABEL_IDCUENTACONTABLEOTROCARGO_LOWER= "Cuenta Contable Otro Cargo";
    	public static final String LABEL_IDCUENTACONTABLEFINAN= "C.C.Financiamiento";
		public static final String LABEL_IDCUENTACONTABLEFINAN_LOWER= "Cuenta Contable Finan";
    	public static final String LABEL_IDCUENTACONTABLEBONI= "C. C. Bonificaciones";
		public static final String LABEL_IDCUENTACONTABLEBONI_LOWER= "Cuenta Contable Boni";
    	public static final String LABEL_IDCUENTACONTABLEBONIDEVOL= "C. C. Dev. Bonificaciones";
		public static final String LABEL_IDCUENTACONTABLEBONIDEVOL_LOWER= "Cuenta Contable Boni Devol";
    	public static final String LABEL_IDCUENTACONTABLEICE= "C Contable Ice";
		public static final String LABEL_IDCUENTACONTABLEICE_LOWER= "Cuenta Contable Ice";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXLEYENDA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLEYENDA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	
	public static String getParametroFactuPrincipalLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUDESCUENTO)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPOPARAMFACTUDESCUENTO;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTULISTADOCLIENTE)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPOPARAMFACTULISTADOCLIENTE;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUSECUENCIATRABAJO)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPOPARAMFACTUSECUENCIATRABAJO;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTOFACTURA)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPODOCUMENTOFACTURA;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTACREDITO)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPODOCUMENTONOTACREDITO;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTADEBITO)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPODOCUMENTONOTADEBITO;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.ENLINEA)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_ENLINEA;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONCUENTATIPOCLIENTE)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONCUENTATIPOCLIENTE;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONCLIENTEIMPUESTO)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONCLIENTEIMPUESTO;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.IDLIBROCONTABLE)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_IDLIBROCONTABLE;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.IDMONEDA)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONIMPRESION)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONIMPRESION;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.IDFORMATO)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONSECUENCIALUSUARIO)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONSECUENCIALUSUARIO;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONSECUENCIALEDITABLE)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONSECUENCIALEDITABLE;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONPRECIOPORCLIENTE)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONPRECIOPORCLIENTE;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONMODIFICARPRECIO)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONMODIFICARPRECIO;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONMODIFICARSERVICIO)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONMODIFICARSERVICIO;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONCAMBIARUNIDAD)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONCAMBIARUNIDAD;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.NUMERODECIMALESUNIDAD)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_NUMERODECIMALESUNIDAD;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONACTIVARSERIE)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONACTIVARSERIE;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONACTIVARLOTE)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONACTIVARLOTE;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONACTIVARMULTIEMPRESA)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONACTIVARMULTIEMPRESA;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONCENTROCOSTOS)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONCENTROCOSTOS;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONUNIDADES)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONUNIDADES;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONCUPODISPONIBLE)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONCUPODISPONIBLE;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONFORMAPAGO)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONFORMAPAGO;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONENVIOMAIL)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONENVIOMAIL;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONAUTORIZARPROFORMA)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONAUTORIZARPROFORMA;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONBLOQUEOPEDIDO)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONBLOQUEOPEDIDO;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONCONTROLANTICIPO)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONCONTROLANTICIPO;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONFACTURAAUTO)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONFACTURAAUTO;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONGRABARVALORCERO)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONGRABARVALORCERO;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONAGREGARITEM)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONAGREGARITEM;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.NUMEROCOPIAS)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_NUMEROCOPIAS;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.LEYENDA)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_LEYENDA;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.CONSINFACTURA)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_CONSINFACTURA;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFLETEVENTA)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEFLETEVENTA;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEOTROCARGO)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEOTROCARGO;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFINAN)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEFINAN;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONI)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEBONI;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONIDEVOL)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEBONIDEVOL;}
		if(sNombreColumna.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEICE)) {sLabelColumna=ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEICE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
		
	public static String geten_lineaDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.geten_linea()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String geten_lineaHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.geten_linea());

		return sDescripcion;
	}	
		
	public static String getcon_cuenta_tipo_clienteDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_cuenta_tipo_cliente()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_cuenta_tipo_clienteHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_cuenta_tipo_cliente());

		return sDescripcion;
	}	
		
	public static String getcon_cliente_impuestoDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_cliente_impuesto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_cliente_impuestoHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_cliente_impuesto());

		return sDescripcion;
	}	
			
			
		
	public static String getcon_impresionDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_impresion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_impresionHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_impresion());

		return sDescripcion;
	}	
			
		
	public static String getcon_secuencial_usuarioDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_secuencial_usuario()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_secuencial_usuarioHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_secuencial_usuario());

		return sDescripcion;
	}	
		
	public static String getcon_secuencial_editableDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_secuencial_editable()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_secuencial_editableHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_secuencial_editable());

		return sDescripcion;
	}	
		
	public static String getcon_precio_por_clienteDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_precio_por_cliente()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_precio_por_clienteHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_precio_por_cliente());

		return sDescripcion;
	}	
		
	public static String getcon_modificar_precioDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_modificar_precio()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_modificar_precioHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_modificar_precio());

		return sDescripcion;
	}	
		
	public static String getcon_modificar_servicioDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_modificar_servicio()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_modificar_servicioHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_modificar_servicio());

		return sDescripcion;
	}	
		
	public static String getcon_cambiar_unidadDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_cambiar_unidad()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_cambiar_unidadHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_cambiar_unidad());

		return sDescripcion;
	}	
			
		
	public static String getcon_activar_serieDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_activar_serie()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_activar_serieHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_activar_serie());

		return sDescripcion;
	}	
		
	public static String getcon_activar_loteDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_activar_lote()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_activar_loteHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_activar_lote());

		return sDescripcion;
	}	
		
	public static String getcon_activar_multi_empresaDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_activar_multi_empresa()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_activar_multi_empresaHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_activar_multi_empresa());

		return sDescripcion;
	}	
		
	public static String getcon_centro_costosDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_centro_costos()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_centro_costosHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_centro_costos());

		return sDescripcion;
	}	
		
	public static String getcon_unidadesDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_unidades()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_unidadesHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_unidades());

		return sDescripcion;
	}	
		
	public static String getcon_cupo_disponibleDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_cupo_disponible()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_cupo_disponibleHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_cupo_disponible());

		return sDescripcion;
	}	
		
	public static String getcon_forma_pagoDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_forma_pago()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_forma_pagoHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_forma_pago());

		return sDescripcion;
	}	
		
	public static String getcon_envio_mailDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_envio_mail()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_envio_mailHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_envio_mail());

		return sDescripcion;
	}	
		
	public static String getcon_autorizar_proformaDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_autorizar_proforma()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_autorizar_proformaHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_autorizar_proforma());

		return sDescripcion;
	}	
		
	public static String getcon_bloqueo_pedidoDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_bloqueo_pedido()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_bloqueo_pedidoHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_bloqueo_pedido());

		return sDescripcion;
	}	
		
	public static String getcon_control_anticipoDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_control_anticipo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_control_anticipoHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_control_anticipo());

		return sDescripcion;
	}	
		
	public static String getcon_factura_autoDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_factura_auto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_factura_autoHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_factura_auto());

		return sDescripcion;
	}	
		
	public static String getcon_grabar_valor_ceroDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_grabar_valor_cero()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_grabar_valor_ceroHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_grabar_valor_cero());

		return sDescripcion;
	}	
		
	public static String getcon_agregar_itemDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_agregar_item()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_agregar_itemHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_agregar_item());

		return sDescripcion;
	}	
			
			
		
	public static String getcon_sin_facturaDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuprincipal.getcon_sin_factura()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_sin_facturaHtmlDescripcion(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuprincipal.getId(),parametrofactuprincipal.getcon_sin_factura());

		return sDescripcion;
	}	
			
			
			
			
			
			
	
	public static String getParametroFactuPrincipalDescripcion(ParametroFactuPrincipal parametrofactuprincipal) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametrofactuprincipal !=null/* && parametrofactuprincipal.getId()!=0*/) {
			if(parametrofactuprincipal.getId()!=null) {
				sDescripcion=parametrofactuprincipal.getId().toString();
			}//parametrofactuprincipalparametrofactuprincipal.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroFactuPrincipalDescripcionDetallado(ParametroFactuPrincipal parametrofactuprincipal) {
		String sDescripcion="";
			
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.ID+"=";
		sDescripcion+=parametrofactuprincipal.getId().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametrofactuprincipal.getVersionRow().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametrofactuprincipal.getid_empresa().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=parametrofactuprincipal.getid_sucursal().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUDESCUENTO+"=";
		sDescripcion+=parametrofactuprincipal.getid_tipo_param_factu_descuento().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTULISTADOCLIENTE+"=";
		sDescripcion+=parametrofactuprincipal.getid_tipo_param_factu_listado_cliente().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUSECUENCIATRABAJO+"=";
		sDescripcion+=parametrofactuprincipal.getid_tipo_param_factu_secuencia_trabajo().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTOFACTURA+"=";
		sDescripcion+=parametrofactuprincipal.getid_tipo_documento_factura().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTACREDITO+"=";
		sDescripcion+=parametrofactuprincipal.getid_tipo_documento_nota_credito().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTADEBITO+"=";
		sDescripcion+=parametrofactuprincipal.getid_tipo_documento_nota_debito().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.ENLINEA+"=";
		sDescripcion+=parametrofactuprincipal.geten_linea().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONCUENTATIPOCLIENTE+"=";
		sDescripcion+=parametrofactuprincipal.getcon_cuenta_tipo_cliente().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONCLIENTEIMPUESTO+"=";
		sDescripcion+=parametrofactuprincipal.getcon_cliente_impuesto().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.IDLIBROCONTABLE+"=";
		sDescripcion+=parametrofactuprincipal.getid_libro_contable().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=parametrofactuprincipal.getid_moneda().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONIMPRESION+"=";
		sDescripcion+=parametrofactuprincipal.getcon_impresion().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=parametrofactuprincipal.getid_formato().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONSECUENCIALUSUARIO+"=";
		sDescripcion+=parametrofactuprincipal.getcon_secuencial_usuario().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONSECUENCIALEDITABLE+"=";
		sDescripcion+=parametrofactuprincipal.getcon_secuencial_editable().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONPRECIOPORCLIENTE+"=";
		sDescripcion+=parametrofactuprincipal.getcon_precio_por_cliente().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONMODIFICARPRECIO+"=";
		sDescripcion+=parametrofactuprincipal.getcon_modificar_precio().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONMODIFICARSERVICIO+"=";
		sDescripcion+=parametrofactuprincipal.getcon_modificar_servicio().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONCAMBIARUNIDAD+"=";
		sDescripcion+=parametrofactuprincipal.getcon_cambiar_unidad().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.NUMERODECIMALESUNIDAD+"=";
		sDescripcion+=parametrofactuprincipal.getnumero_decimales_unidad().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONACTIVARSERIE+"=";
		sDescripcion+=parametrofactuprincipal.getcon_activar_serie().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONACTIVARLOTE+"=";
		sDescripcion+=parametrofactuprincipal.getcon_activar_lote().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONACTIVARMULTIEMPRESA+"=";
		sDescripcion+=parametrofactuprincipal.getcon_activar_multi_empresa().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONCENTROCOSTOS+"=";
		sDescripcion+=parametrofactuprincipal.getcon_centro_costos().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONUNIDADES+"=";
		sDescripcion+=parametrofactuprincipal.getcon_unidades().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONCUPODISPONIBLE+"=";
		sDescripcion+=parametrofactuprincipal.getcon_cupo_disponible().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONFORMAPAGO+"=";
		sDescripcion+=parametrofactuprincipal.getcon_forma_pago().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONENVIOMAIL+"=";
		sDescripcion+=parametrofactuprincipal.getcon_envio_mail().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONAUTORIZARPROFORMA+"=";
		sDescripcion+=parametrofactuprincipal.getcon_autorizar_proforma().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONBLOQUEOPEDIDO+"=";
		sDescripcion+=parametrofactuprincipal.getcon_bloqueo_pedido().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONCONTROLANTICIPO+"=";
		sDescripcion+=parametrofactuprincipal.getcon_control_anticipo().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONFACTURAAUTO+"=";
		sDescripcion+=parametrofactuprincipal.getcon_factura_auto().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONGRABARVALORCERO+"=";
		sDescripcion+=parametrofactuprincipal.getcon_grabar_valor_cero().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONAGREGARITEM+"=";
		sDescripcion+=parametrofactuprincipal.getcon_agregar_item().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.NUMEROCOPIAS+"=";
		sDescripcion+=parametrofactuprincipal.getnumero_copias().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.LEYENDA+"=";
		sDescripcion+=parametrofactuprincipal.getleyenda()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.CONSINFACTURA+"=";
		sDescripcion+=parametrofactuprincipal.getcon_sin_factura().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFLETEVENTA+"=";
		sDescripcion+=parametrofactuprincipal.getid_cuenta_contable_flete_venta().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEOTROCARGO+"=";
		sDescripcion+=parametrofactuprincipal.getid_cuenta_contable_otro_cargo().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFINAN+"=";
		sDescripcion+=parametrofactuprincipal.getid_cuenta_contable_finan().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONI+"=";
		sDescripcion+=parametrofactuprincipal.getid_cuenta_contable_boni().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONIDEVOL+"=";
		sDescripcion+=parametrofactuprincipal.getid_cuenta_contable_boni_devol().toString()+",";
		sDescripcion+=ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEICE+"=";
		sDescripcion+=parametrofactuprincipal.getid_cuenta_contable_ice().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroFactuPrincipalDescripcion(ParametroFactuPrincipal parametrofactuprincipal,String sValor) throws Exception {			
		if(parametrofactuprincipal !=null) {
			//parametrofactuprincipalparametrofactuprincipal.getId().toString();
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

	public static String getTipoParamFactuDescuentoDescripcion(TipoParamFactuDescuento tipoparamfactudescuento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoparamfactudescuento!=null/*&&tipoparamfactudescuento.getId()>0*/) {
			sDescripcion=TipoParamFactuDescuentoConstantesFunciones.getTipoParamFactuDescuentoDescripcion(tipoparamfactudescuento);
		}

		return sDescripcion;
	}

	public static String getTipoParamFactuListadoClienteDescripcion(TipoParamFactuListadoCliente tipoparamfactulistadocliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoparamfactulistadocliente!=null/*&&tipoparamfactulistadocliente.getId()>0*/) {
			sDescripcion=TipoParamFactuListadoClienteConstantesFunciones.getTipoParamFactuListadoClienteDescripcion(tipoparamfactulistadocliente);
		}

		return sDescripcion;
	}

	public static String getTipoParamFactuSecuenciaTrabajoDescripcion(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoparamfactusecuenciatrabajo!=null/*&&tipoparamfactusecuenciatrabajo.getId()>0*/) {
			sDescripcion=TipoParamFactuSecuenciaTrabajoConstantesFunciones.getTipoParamFactuSecuenciaTrabajoDescripcion(tipoparamfactusecuenciatrabajo);
		}

		return sDescripcion;
	}

	public static String getTipoDocumentoFacturaDescripcion(TipoDocumento tipodocumento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodocumento!=null/*&&tipodocumento.getId()>0*/) {
			sDescripcion=TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(tipodocumento);
		}

		return sDescripcion;
	}

	public static String getTipoDocumentoNotaCreditoDescripcion(TipoDocumento tipodocumento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodocumento!=null/*&&tipodocumento.getId()>0*/) {
			sDescripcion=TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(tipodocumento);
		}

		return sDescripcion;
	}

	public static String getTipoDocumentoNotaDebitoDescripcion(TipoDocumento tipodocumento) {
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

	public static String getMonedaDescripcion(Moneda moneda) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(moneda!=null/*&&moneda.getId()>0*/) {
			sDescripcion=MonedaConstantesFunciones.getMonedaDescripcion(moneda);
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

	public static String getCuentaContableFleteVentaDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableOtroCargoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableFinanDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableBoniDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableBoniDevolDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableIceDescripcion(CuentaContable cuentacontable) {
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
		} else if(sNombreIndice.equals("FK_IdCuentaContableBoni")) {
			sNombreIndice="Tipo=  Por C. C. Bonificaciones";
		} else if(sNombreIndice.equals("FK_IdCuentaContableBoniDevol")) {
			sNombreIndice="Tipo=  Por C. C. Dev. Bonificaciones";
		} else if(sNombreIndice.equals("FK_IdCuentaContableFinan")) {
			sNombreIndice="Tipo=  Por C.C.Financiamiento";
		} else if(sNombreIndice.equals("FK_IdCuentaContableFleteVenta")) {
			sNombreIndice="Tipo=  Por C. C. Flete En  Venta";
		} else if(sNombreIndice.equals("FK_IdCuentaContableIce")) {
			sNombreIndice="Tipo=  Por C Contable Ice";
		} else if(sNombreIndice.equals("FK_IdCuentaContableOtroCargo")) {
			sNombreIndice="Tipo=  Por C C. Otros Cargos";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdLibroContable")) {
			sNombreIndice="Tipo=  Por Libro Contable";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoDocumentoFactura")) {
			sNombreIndice="Tipo=  Por T Documento Factura";
		} else if(sNombreIndice.equals("FK_IdTipoDocumentoNotaCredito")) {
			sNombreIndice="Tipo=  Por T Doc Nota Credito";
		} else if(sNombreIndice.equals("FK_IdTipoDocumentoNotaDebito")) {
			sNombreIndice="Tipo=  Por T Doc Nota Debito";
		} else if(sNombreIndice.equals("FK_IdTipoParamFactuDescuento")) {
			sNombreIndice="Tipo=  Por T  Descuento General";
		} else if(sNombreIndice.equals("FK_IdTipoParamFactuListadoCliente")) {
			sNombreIndice="Tipo=  Por T  Listado Cliente/Prov";
		} else if(sNombreIndice.equals("FK_IdTipoParamFactuSecuenciaTrabajo")) {
			sNombreIndice="Tipo=  Por T Secuencia De Trabajo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCuentaContableBoni(Long id_cuenta_contable_boni) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_boni!=null) {sDetalleIndice+=" Codigo Unico De C. C. Bonificaciones="+id_cuenta_contable_boni.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableBoniDevol(Long id_cuenta_contable_boni_devol) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_boni_devol!=null) {sDetalleIndice+=" Codigo Unico De C. C. Dev. Bonificaciones="+id_cuenta_contable_boni_devol.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableFinan(Long id_cuenta_contable_finan) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_finan!=null) {sDetalleIndice+=" Codigo Unico De C.C.Financiamiento="+id_cuenta_contable_finan.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableFleteVenta(Long id_cuenta_contable_flete_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_flete_venta!=null) {sDetalleIndice+=" Codigo Unico De C. C. Flete En  Venta="+id_cuenta_contable_flete_venta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableIce(Long id_cuenta_contable_ice) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_ice!=null) {sDetalleIndice+=" Codigo Unico De C Contable Ice="+id_cuenta_contable_ice.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableOtroCargo(Long id_cuenta_contable_otro_cargo) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_otro_cargo!=null) {sDetalleIndice+=" Codigo Unico De C C. Otros Cargos="+id_cuenta_contable_otro_cargo.toString();} 

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
		if(id_libro_contable!=null) {sDetalleIndice+=" Codigo Unico De Libro Contable="+id_libro_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMoneda(Long id_moneda) {
		String sDetalleIndice=" Parametros->";
		if(id_moneda!=null) {sDetalleIndice+=" Codigo Unico De Moneda="+id_moneda.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDocumentoFactura(Long id_tipo_documento_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento_factura!=null) {sDetalleIndice+=" Codigo Unico De T Documento Factura="+id_tipo_documento_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDocumentoNotaCredito(Long id_tipo_documento_nota_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento_nota_credito!=null) {sDetalleIndice+=" Codigo Unico De T Doc Nota Credito="+id_tipo_documento_nota_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDocumentoNotaDebito(Long id_tipo_documento_nota_debito) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento_nota_debito!=null) {sDetalleIndice+=" Codigo Unico De T Doc Nota Debito="+id_tipo_documento_nota_debito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoParamFactuDescuento(Long id_tipo_param_factu_descuento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_param_factu_descuento!=null) {sDetalleIndice+=" Codigo Unico De T  Descuento General="+id_tipo_param_factu_descuento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoParamFactuListadoCliente(Long id_tipo_param_factu_listado_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_param_factu_listado_cliente!=null) {sDetalleIndice+=" Codigo Unico De T  Listado Cliente/Prov="+id_tipo_param_factu_listado_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoParamFactuSecuenciaTrabajo(Long id_tipo_param_factu_secuencia_trabajo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_param_factu_secuencia_trabajo!=null) {sDetalleIndice+=" Codigo Unico De T Secuencia De Trabajo="+id_tipo_param_factu_secuencia_trabajo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroFactuPrincipal(ParametroFactuPrincipal parametrofactuprincipal,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		parametrofactuprincipal.setleyenda(parametrofactuprincipal.getleyenda().trim());
	}
	
	public static void quitarEspaciosParametroFactuPrincipals(List<ParametroFactuPrincipal> parametrofactuprincipals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroFactuPrincipal parametrofactuprincipal: parametrofactuprincipals) {
			parametrofactuprincipal.setleyenda(parametrofactuprincipal.getleyenda().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroFactuPrincipal(ParametroFactuPrincipal parametrofactuprincipal,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametrofactuprincipal.getConCambioAuxiliar()) {
			parametrofactuprincipal.setIsDeleted(parametrofactuprincipal.getIsDeletedAuxiliar());	
			parametrofactuprincipal.setIsNew(parametrofactuprincipal.getIsNewAuxiliar());	
			parametrofactuprincipal.setIsChanged(parametrofactuprincipal.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametrofactuprincipal.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametrofactuprincipal.setIsDeletedAuxiliar(false);	
			parametrofactuprincipal.setIsNewAuxiliar(false);	
			parametrofactuprincipal.setIsChangedAuxiliar(false);
			
			parametrofactuprincipal.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroFactuPrincipals(List<ParametroFactuPrincipal> parametrofactuprincipals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroFactuPrincipal parametrofactuprincipal : parametrofactuprincipals) {
			if(conAsignarBase && parametrofactuprincipal.getConCambioAuxiliar()) {
				parametrofactuprincipal.setIsDeleted(parametrofactuprincipal.getIsDeletedAuxiliar());	
				parametrofactuprincipal.setIsNew(parametrofactuprincipal.getIsNewAuxiliar());	
				parametrofactuprincipal.setIsChanged(parametrofactuprincipal.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametrofactuprincipal.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametrofactuprincipal.setIsDeletedAuxiliar(false);	
				parametrofactuprincipal.setIsNewAuxiliar(false);	
				parametrofactuprincipal.setIsChangedAuxiliar(false);
				
				parametrofactuprincipal.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroFactuPrincipal(ParametroFactuPrincipal parametrofactuprincipal,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			parametrofactuprincipal.setnumero_decimales_unidad(0);
			parametrofactuprincipal.setnumero_copias(0);
		}
	}		
	
	public static void InicializarValoresParametroFactuPrincipals(List<ParametroFactuPrincipal> parametrofactuprincipals,Boolean conEnteros) throws Exception  {
		
		for(ParametroFactuPrincipal parametrofactuprincipal: parametrofactuprincipals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				parametrofactuprincipal.setnumero_decimales_unidad(0);
				parametrofactuprincipal.setnumero_copias(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroFactuPrincipal(List<ParametroFactuPrincipal> parametrofactuprincipals,ParametroFactuPrincipal parametrofactuprincipalAux) throws Exception  {
		ParametroFactuPrincipalConstantesFunciones.InicializarValoresParametroFactuPrincipal(parametrofactuprincipalAux,true);
		
		for(ParametroFactuPrincipal parametrofactuprincipal: parametrofactuprincipals) {
			if(parametrofactuprincipal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			parametrofactuprincipalAux.setnumero_decimales_unidad(parametrofactuprincipalAux.getnumero_decimales_unidad()+parametrofactuprincipal.getnumero_decimales_unidad());			
			parametrofactuprincipalAux.setnumero_copias(parametrofactuprincipalAux.getnumero_copias()+parametrofactuprincipal.getnumero_copias());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroFactuPrincipal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroFactuPrincipalConstantesFunciones.getArrayColumnasGlobalesParametroFactuPrincipal(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroFactuPrincipal(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroFactuPrincipalConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroFactuPrincipalConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroFactuPrincipalConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroFactuPrincipalConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroFactuPrincipalConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroFactuPrincipalConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroFactuPrincipal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroFactuPrincipal> parametrofactuprincipals,ParametroFactuPrincipal parametrofactuprincipal,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroFactuPrincipal parametrofactuprincipalAux: parametrofactuprincipals) {
			if(parametrofactuprincipalAux!=null && parametrofactuprincipal!=null) {
				if((parametrofactuprincipalAux.getId()==null && parametrofactuprincipal.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametrofactuprincipalAux.getId()!=null && parametrofactuprincipal.getId()!=null){
					if(parametrofactuprincipalAux.getId().equals(parametrofactuprincipal.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroFactuPrincipal(List<ParametroFactuPrincipal> parametrofactuprincipals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroFactuPrincipal parametrofactuprincipal: parametrofactuprincipals) {			
			if(parametrofactuprincipal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroFactuPrincipal() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_ID, ParametroFactuPrincipalConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_VERSIONROW, ParametroFactuPrincipalConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_IDEMPRESA, ParametroFactuPrincipalConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_IDSUCURSAL, ParametroFactuPrincipalConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPOPARAMFACTUDESCUENTO, ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPOPARAMFACTULISTADOCLIENTE, ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTULISTADOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPOPARAMFACTUSECUENCIATRABAJO, ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUSECUENCIATRABAJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPODOCUMENTOFACTURA, ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTOFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPODOCUMENTONOTACREDITO, ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPODOCUMENTONOTADEBITO, ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTADEBITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_ENLINEA, ParametroFactuPrincipalConstantesFunciones.ENLINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONCUENTATIPOCLIENTE, ParametroFactuPrincipalConstantesFunciones.CONCUENTATIPOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONCLIENTEIMPUESTO, ParametroFactuPrincipalConstantesFunciones.CONCLIENTEIMPUESTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_IDLIBROCONTABLE, ParametroFactuPrincipalConstantesFunciones.IDLIBROCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_IDMONEDA, ParametroFactuPrincipalConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONIMPRESION, ParametroFactuPrincipalConstantesFunciones.CONIMPRESION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_IDFORMATO, ParametroFactuPrincipalConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONSECUENCIALUSUARIO, ParametroFactuPrincipalConstantesFunciones.CONSECUENCIALUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONSECUENCIALEDITABLE, ParametroFactuPrincipalConstantesFunciones.CONSECUENCIALEDITABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONPRECIOPORCLIENTE, ParametroFactuPrincipalConstantesFunciones.CONPRECIOPORCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONMODIFICARPRECIO, ParametroFactuPrincipalConstantesFunciones.CONMODIFICARPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONMODIFICARSERVICIO, ParametroFactuPrincipalConstantesFunciones.CONMODIFICARSERVICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONCAMBIARUNIDAD, ParametroFactuPrincipalConstantesFunciones.CONCAMBIARUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_NUMERODECIMALESUNIDAD, ParametroFactuPrincipalConstantesFunciones.NUMERODECIMALESUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONACTIVARSERIE, ParametroFactuPrincipalConstantesFunciones.CONACTIVARSERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONACTIVARLOTE, ParametroFactuPrincipalConstantesFunciones.CONACTIVARLOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONACTIVARMULTIEMPRESA, ParametroFactuPrincipalConstantesFunciones.CONACTIVARMULTIEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONCENTROCOSTOS, ParametroFactuPrincipalConstantesFunciones.CONCENTROCOSTOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONUNIDADES, ParametroFactuPrincipalConstantesFunciones.CONUNIDADES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONCUPODISPONIBLE, ParametroFactuPrincipalConstantesFunciones.CONCUPODISPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONFORMAPAGO, ParametroFactuPrincipalConstantesFunciones.CONFORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONENVIOMAIL, ParametroFactuPrincipalConstantesFunciones.CONENVIOMAIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONAUTORIZARPROFORMA, ParametroFactuPrincipalConstantesFunciones.CONAUTORIZARPROFORMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONBLOQUEOPEDIDO, ParametroFactuPrincipalConstantesFunciones.CONBLOQUEOPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONCONTROLANTICIPO, ParametroFactuPrincipalConstantesFunciones.CONCONTROLANTICIPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONFACTURAAUTO, ParametroFactuPrincipalConstantesFunciones.CONFACTURAAUTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONGRABARVALORCERO, ParametroFactuPrincipalConstantesFunciones.CONGRABARVALORCERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONAGREGARITEM, ParametroFactuPrincipalConstantesFunciones.CONAGREGARITEM,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_NUMEROCOPIAS, ParametroFactuPrincipalConstantesFunciones.NUMEROCOPIAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_LEYENDA, ParametroFactuPrincipalConstantesFunciones.LEYENDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_CONSINFACTURA, ParametroFactuPrincipalConstantesFunciones.CONSINFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEFLETEVENTA, ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFLETEVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEOTROCARGO, ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEOTROCARGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEFINAN, ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFINAN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEBONI, ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEBONIDEVOL, ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONIDEVOL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEICE, ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEICE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroFactuPrincipal() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTULISTADOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUSECUENCIATRABAJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTOFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTADEBITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.ENLINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONCUENTATIPOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONCLIENTEIMPUESTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.IDLIBROCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONIMPRESION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONSECUENCIALUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONSECUENCIALEDITABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONPRECIOPORCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONMODIFICARPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONMODIFICARSERVICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONCAMBIARUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.NUMERODECIMALESUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONACTIVARSERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONACTIVARLOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONACTIVARMULTIEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONCENTROCOSTOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONUNIDADES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONCUPODISPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONFORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONENVIOMAIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONAUTORIZARPROFORMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONBLOQUEOPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONCONTROLANTICIPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONFACTURAAUTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONGRABARVALORCERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONAGREGARITEM;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.NUMEROCOPIAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.LEYENDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.CONSINFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFLETEVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEOTROCARGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFINAN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONIDEVOL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEICE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFactuPrincipal() throws Exception  {
		return ParametroFactuPrincipalConstantesFunciones.getTiposSeleccionarParametroFactuPrincipal(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFactuPrincipal(Boolean conFk) throws Exception  {
		return ParametroFactuPrincipalConstantesFunciones.getTiposSeleccionarParametroFactuPrincipal(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFactuPrincipal(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPOPARAMFACTUDESCUENTO);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPOPARAMFACTUDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPOPARAMFACTULISTADOCLIENTE);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPOPARAMFACTULISTADOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPOPARAMFACTUSECUENCIATRABAJO);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPOPARAMFACTUSECUENCIATRABAJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPODOCUMENTOFACTURA);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPODOCUMENTOFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPODOCUMENTONOTACREDITO);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPODOCUMENTONOTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPODOCUMENTONOTADEBITO);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPODOCUMENTONOTADEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_ENLINEA);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_ENLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONCUENTATIPOCLIENTE);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONCUENTATIPOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONCLIENTEIMPUESTO);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONCLIENTEIMPUESTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_IDLIBROCONTABLE);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_IDLIBROCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONIMPRESION);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONIMPRESION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONSECUENCIALUSUARIO);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONSECUENCIALUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONSECUENCIALEDITABLE);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONSECUENCIALEDITABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONPRECIOPORCLIENTE);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONPRECIOPORCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONMODIFICARPRECIO);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONMODIFICARPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONMODIFICARSERVICIO);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONMODIFICARSERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONCAMBIARUNIDAD);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONCAMBIARUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_NUMERODECIMALESUNIDAD);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_NUMERODECIMALESUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONACTIVARSERIE);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONACTIVARSERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONACTIVARLOTE);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONACTIVARLOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONACTIVARMULTIEMPRESA);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONACTIVARMULTIEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONCENTROCOSTOS);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONCENTROCOSTOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONUNIDADES);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONUNIDADES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONCUPODISPONIBLE);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONCUPODISPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONFORMAPAGO);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONENVIOMAIL);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONENVIOMAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONAUTORIZARPROFORMA);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONAUTORIZARPROFORMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONBLOQUEOPEDIDO);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONBLOQUEOPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONCONTROLANTICIPO);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONCONTROLANTICIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONFACTURAAUTO);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONFACTURAAUTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONGRABARVALORCERO);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONGRABARVALORCERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONAGREGARITEM);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONAGREGARITEM);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_NUMEROCOPIAS);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_NUMEROCOPIAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_LEYENDA);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_LEYENDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_CONSINFACTURA);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_CONSINFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEFLETEVENTA);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEFLETEVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEOTROCARGO);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEOTROCARGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEFINAN);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEFINAN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEBONI);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEBONI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEBONIDEVOL);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEBONIDEVOL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEICE);
			reporte.setsDescripcion(ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroFactuPrincipal(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroFactuPrincipal(ParametroFactuPrincipal parametrofactuprincipalAux) throws Exception {
		
			parametrofactuprincipalAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrofactuprincipalAux.getEmpresa()));
			parametrofactuprincipalAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrofactuprincipalAux.getSucursal()));
			parametrofactuprincipalAux.settipoparamfactudescuento_descripcion(TipoParamFactuDescuentoConstantesFunciones.getTipoParamFactuDescuentoDescripcion(parametrofactuprincipalAux.getTipoParamFactuDescuento()));
			parametrofactuprincipalAux.settipoparamfactulistadocliente_descripcion(TipoParamFactuListadoClienteConstantesFunciones.getTipoParamFactuListadoClienteDescripcion(parametrofactuprincipalAux.getTipoParamFactuListadoCliente()));
			parametrofactuprincipalAux.settipoparamfactusecuenciatrabajo_descripcion(TipoParamFactuSecuenciaTrabajoConstantesFunciones.getTipoParamFactuSecuenciaTrabajoDescripcion(parametrofactuprincipalAux.getTipoParamFactuSecuenciaTrabajo()));
			parametrofactuprincipalAux.settipodocumentofactura_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(parametrofactuprincipalAux.getTipoDocumentoFactura()));
			parametrofactuprincipalAux.settipodocumentonotacredito_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(parametrofactuprincipalAux.getTipoDocumentoNotaCredito()));
			parametrofactuprincipalAux.settipodocumentonotadebito_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(parametrofactuprincipalAux.getTipoDocumentoNotaDebito()));
			parametrofactuprincipalAux.setlibrocontable_descripcion(LibroContableConstantesFunciones.getLibroContableDescripcion(parametrofactuprincipalAux.getLibroContable()));
			parametrofactuprincipalAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(parametrofactuprincipalAux.getMoneda()));
			parametrofactuprincipalAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrofactuprincipalAux.getFormato()));
			parametrofactuprincipalAux.setcuentacontablefleteventa_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrofactuprincipalAux.getCuentaContableFleteVenta()));
			parametrofactuprincipalAux.setcuentacontableotrocargo_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrofactuprincipalAux.getCuentaContableOtroCargo()));
			parametrofactuprincipalAux.setcuentacontablefinan_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrofactuprincipalAux.getCuentaContableFinan()));
			parametrofactuprincipalAux.setcuentacontableboni_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrofactuprincipalAux.getCuentaContableBoni()));
			parametrofactuprincipalAux.setcuentacontablebonidevol_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrofactuprincipalAux.getCuentaContableBoniDevol()));
			parametrofactuprincipalAux.setcuentacontableice_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrofactuprincipalAux.getCuentaContableIce()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroFactuPrincipal(List<ParametroFactuPrincipal> parametrofactuprincipalsTemp) throws Exception {
		for(ParametroFactuPrincipal parametrofactuprincipalAux:parametrofactuprincipalsTemp) {
			
			parametrofactuprincipalAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrofactuprincipalAux.getEmpresa()));
			parametrofactuprincipalAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrofactuprincipalAux.getSucursal()));
			parametrofactuprincipalAux.settipoparamfactudescuento_descripcion(TipoParamFactuDescuentoConstantesFunciones.getTipoParamFactuDescuentoDescripcion(parametrofactuprincipalAux.getTipoParamFactuDescuento()));
			parametrofactuprincipalAux.settipoparamfactulistadocliente_descripcion(TipoParamFactuListadoClienteConstantesFunciones.getTipoParamFactuListadoClienteDescripcion(parametrofactuprincipalAux.getTipoParamFactuListadoCliente()));
			parametrofactuprincipalAux.settipoparamfactusecuenciatrabajo_descripcion(TipoParamFactuSecuenciaTrabajoConstantesFunciones.getTipoParamFactuSecuenciaTrabajoDescripcion(parametrofactuprincipalAux.getTipoParamFactuSecuenciaTrabajo()));
			parametrofactuprincipalAux.settipodocumentofactura_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(parametrofactuprincipalAux.getTipoDocumentoFactura()));
			parametrofactuprincipalAux.settipodocumentonotacredito_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(parametrofactuprincipalAux.getTipoDocumentoNotaCredito()));
			parametrofactuprincipalAux.settipodocumentonotadebito_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(parametrofactuprincipalAux.getTipoDocumentoNotaDebito()));
			parametrofactuprincipalAux.setlibrocontable_descripcion(LibroContableConstantesFunciones.getLibroContableDescripcion(parametrofactuprincipalAux.getLibroContable()));
			parametrofactuprincipalAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(parametrofactuprincipalAux.getMoneda()));
			parametrofactuprincipalAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrofactuprincipalAux.getFormato()));
			parametrofactuprincipalAux.setcuentacontablefleteventa_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrofactuprincipalAux.getCuentaContableFleteVenta()));
			parametrofactuprincipalAux.setcuentacontableotrocargo_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrofactuprincipalAux.getCuentaContableOtroCargo()));
			parametrofactuprincipalAux.setcuentacontablefinan_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrofactuprincipalAux.getCuentaContableFinan()));
			parametrofactuprincipalAux.setcuentacontableboni_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrofactuprincipalAux.getCuentaContableBoni()));
			parametrofactuprincipalAux.setcuentacontablebonidevol_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrofactuprincipalAux.getCuentaContableBoniDevol()));
			parametrofactuprincipalAux.setcuentacontableice_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrofactuprincipalAux.getCuentaContableIce()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroFactuPrincipal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(TipoParamFactuDescuento.class));
				classes.add(new Classe(TipoParamFactuListadoCliente.class));
				classes.add(new Classe(TipoParamFactuSecuenciaTrabajo.class));
				classes.add(new Classe(TipoDocumento.class));
				classes.add(new Classe(TipoDocumento.class));
				classes.add(new Classe(TipoDocumento.class));
				classes.add(new Classe(LibroContable.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				
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
					if(clas.clas.equals(TipoParamFactuDescuento.class)) {
						classes.add(new Classe(TipoParamFactuDescuento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoParamFactuListadoCliente.class)) {
						classes.add(new Classe(TipoParamFactuListadoCliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoParamFactuSecuenciaTrabajo.class)) {
						classes.add(new Classe(TipoParamFactuSecuenciaTrabajo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDocumento.class)) {
						classes.add(new Classe(TipoDocumento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDocumento.class)) {
						classes.add(new Classe(TipoDocumento.class));
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
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroFactuPrincipal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoParamFactuDescuento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoParamFactuDescuento.class)); continue;
					}

					if(TipoParamFactuListadoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoParamFactuListadoCliente.class)); continue;
					}

					if(TipoParamFactuSecuenciaTrabajo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoParamFactuSecuenciaTrabajo.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(LibroContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(LibroContable.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(TipoParamFactuDescuento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoParamFactuDescuento.class)); continue;
					}

					if(TipoParamFactuListadoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoParamFactuListadoCliente.class)); continue;
					}

					if(TipoParamFactuSecuenciaTrabajo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoParamFactuSecuenciaTrabajo.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(LibroContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(LibroContable.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFactuPrincipal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroFactuPrincipalConstantesFunciones.getClassesRelationshipsOfParametroFactuPrincipal(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFactuPrincipal(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroFactuPrincipal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroFactuPrincipalConstantesFunciones.getClassesRelationshipsFromStringsOfParametroFactuPrincipal(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroFactuPrincipal(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParametroFactuPrincipal parametrofactuprincipal,List<ParametroFactuPrincipal> parametrofactuprincipals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroFactuPrincipal parametrofactuprincipalEncontrado=null;
			
			for(ParametroFactuPrincipal parametrofactuprincipalLocal:parametrofactuprincipals) {
				if(parametrofactuprincipalLocal.getId().equals(parametrofactuprincipal.getId())) {
					parametrofactuprincipalEncontrado=parametrofactuprincipalLocal;
					
					parametrofactuprincipalLocal.setIsChanged(parametrofactuprincipal.getIsChanged());
					parametrofactuprincipalLocal.setIsNew(parametrofactuprincipal.getIsNew());
					parametrofactuprincipalLocal.setIsDeleted(parametrofactuprincipal.getIsDeleted());
					
					parametrofactuprincipalLocal.setGeneralEntityOriginal(parametrofactuprincipal.getGeneralEntityOriginal());
					
					parametrofactuprincipalLocal.setId(parametrofactuprincipal.getId());	
					parametrofactuprincipalLocal.setVersionRow(parametrofactuprincipal.getVersionRow());	
					parametrofactuprincipalLocal.setid_empresa(parametrofactuprincipal.getid_empresa());	
					parametrofactuprincipalLocal.setid_sucursal(parametrofactuprincipal.getid_sucursal());	
					parametrofactuprincipalLocal.setid_tipo_param_factu_descuento(parametrofactuprincipal.getid_tipo_param_factu_descuento());	
					parametrofactuprincipalLocal.setid_tipo_param_factu_listado_cliente(parametrofactuprincipal.getid_tipo_param_factu_listado_cliente());	
					parametrofactuprincipalLocal.setid_tipo_param_factu_secuencia_trabajo(parametrofactuprincipal.getid_tipo_param_factu_secuencia_trabajo());	
					parametrofactuprincipalLocal.setid_tipo_documento_factura(parametrofactuprincipal.getid_tipo_documento_factura());	
					parametrofactuprincipalLocal.setid_tipo_documento_nota_credito(parametrofactuprincipal.getid_tipo_documento_nota_credito());	
					parametrofactuprincipalLocal.setid_tipo_documento_nota_debito(parametrofactuprincipal.getid_tipo_documento_nota_debito());	
					parametrofactuprincipalLocal.seten_linea(parametrofactuprincipal.geten_linea());	
					parametrofactuprincipalLocal.setcon_cuenta_tipo_cliente(parametrofactuprincipal.getcon_cuenta_tipo_cliente());	
					parametrofactuprincipalLocal.setcon_cliente_impuesto(parametrofactuprincipal.getcon_cliente_impuesto());	
					parametrofactuprincipalLocal.setid_libro_contable(parametrofactuprincipal.getid_libro_contable());	
					parametrofactuprincipalLocal.setid_moneda(parametrofactuprincipal.getid_moneda());	
					parametrofactuprincipalLocal.setcon_impresion(parametrofactuprincipal.getcon_impresion());	
					parametrofactuprincipalLocal.setid_formato(parametrofactuprincipal.getid_formato());	
					parametrofactuprincipalLocal.setcon_secuencial_usuario(parametrofactuprincipal.getcon_secuencial_usuario());	
					parametrofactuprincipalLocal.setcon_secuencial_editable(parametrofactuprincipal.getcon_secuencial_editable());	
					parametrofactuprincipalLocal.setcon_precio_por_cliente(parametrofactuprincipal.getcon_precio_por_cliente());	
					parametrofactuprincipalLocal.setcon_modificar_precio(parametrofactuprincipal.getcon_modificar_precio());	
					parametrofactuprincipalLocal.setcon_modificar_servicio(parametrofactuprincipal.getcon_modificar_servicio());	
					parametrofactuprincipalLocal.setcon_cambiar_unidad(parametrofactuprincipal.getcon_cambiar_unidad());	
					parametrofactuprincipalLocal.setnumero_decimales_unidad(parametrofactuprincipal.getnumero_decimales_unidad());	
					parametrofactuprincipalLocal.setcon_activar_serie(parametrofactuprincipal.getcon_activar_serie());	
					parametrofactuprincipalLocal.setcon_activar_lote(parametrofactuprincipal.getcon_activar_lote());	
					parametrofactuprincipalLocal.setcon_activar_multi_empresa(parametrofactuprincipal.getcon_activar_multi_empresa());	
					parametrofactuprincipalLocal.setcon_centro_costos(parametrofactuprincipal.getcon_centro_costos());	
					parametrofactuprincipalLocal.setcon_unidades(parametrofactuprincipal.getcon_unidades());	
					parametrofactuprincipalLocal.setcon_cupo_disponible(parametrofactuprincipal.getcon_cupo_disponible());	
					parametrofactuprincipalLocal.setcon_forma_pago(parametrofactuprincipal.getcon_forma_pago());	
					parametrofactuprincipalLocal.setcon_envio_mail(parametrofactuprincipal.getcon_envio_mail());	
					parametrofactuprincipalLocal.setcon_autorizar_proforma(parametrofactuprincipal.getcon_autorizar_proforma());	
					parametrofactuprincipalLocal.setcon_bloqueo_pedido(parametrofactuprincipal.getcon_bloqueo_pedido());	
					parametrofactuprincipalLocal.setcon_control_anticipo(parametrofactuprincipal.getcon_control_anticipo());	
					parametrofactuprincipalLocal.setcon_factura_auto(parametrofactuprincipal.getcon_factura_auto());	
					parametrofactuprincipalLocal.setcon_grabar_valor_cero(parametrofactuprincipal.getcon_grabar_valor_cero());	
					parametrofactuprincipalLocal.setcon_agregar_item(parametrofactuprincipal.getcon_agregar_item());	
					parametrofactuprincipalLocal.setnumero_copias(parametrofactuprincipal.getnumero_copias());	
					parametrofactuprincipalLocal.setleyenda(parametrofactuprincipal.getleyenda());	
					parametrofactuprincipalLocal.setcon_sin_factura(parametrofactuprincipal.getcon_sin_factura());	
					parametrofactuprincipalLocal.setid_cuenta_contable_flete_venta(parametrofactuprincipal.getid_cuenta_contable_flete_venta());	
					parametrofactuprincipalLocal.setid_cuenta_contable_otro_cargo(parametrofactuprincipal.getid_cuenta_contable_otro_cargo());	
					parametrofactuprincipalLocal.setid_cuenta_contable_finan(parametrofactuprincipal.getid_cuenta_contable_finan());	
					parametrofactuprincipalLocal.setid_cuenta_contable_boni(parametrofactuprincipal.getid_cuenta_contable_boni());	
					parametrofactuprincipalLocal.setid_cuenta_contable_boni_devol(parametrofactuprincipal.getid_cuenta_contable_boni_devol());	
					parametrofactuprincipalLocal.setid_cuenta_contable_ice(parametrofactuprincipal.getid_cuenta_contable_ice());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametrofactuprincipal.getIsDeleted()) {
				if(!existe) {
					parametrofactuprincipals.add(parametrofactuprincipal);
				}
			} else {
				if(parametrofactuprincipalEncontrado!=null && permiteQuitar)  {
					parametrofactuprincipals.remove(parametrofactuprincipalEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroFactuPrincipal parametrofactuprincipal,List<ParametroFactuPrincipal> parametrofactuprincipals) throws Exception {
		try	{			
			for(ParametroFactuPrincipal parametrofactuprincipalLocal:parametrofactuprincipals) {
				if(parametrofactuprincipalLocal.getId().equals(parametrofactuprincipal.getId())) {
					parametrofactuprincipalLocal.setIsSelected(parametrofactuprincipal.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroFactuPrincipal(List<ParametroFactuPrincipal> parametrofactuprincipalsAux) throws Exception {
		//this.parametrofactuprincipalsAux=parametrofactuprincipalsAux;
		
		for(ParametroFactuPrincipal parametrofactuprincipalAux:parametrofactuprincipalsAux) {
			if(parametrofactuprincipalAux.getIsChanged()) {
				parametrofactuprincipalAux.setIsChanged(false);
			}		
			
			if(parametrofactuprincipalAux.getIsNew()) {
				parametrofactuprincipalAux.setIsNew(false);
			}	
			
			if(parametrofactuprincipalAux.getIsDeleted()) {
				parametrofactuprincipalAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroFactuPrincipal(ParametroFactuPrincipal parametrofactuprincipalAux) throws Exception {
		//this.parametrofactuprincipalAux=parametrofactuprincipalAux;
		
			if(parametrofactuprincipalAux.getIsChanged()) {
				parametrofactuprincipalAux.setIsChanged(false);
			}		
			
			if(parametrofactuprincipalAux.getIsNew()) {
				parametrofactuprincipalAux.setIsNew(false);
			}	
			
			if(parametrofactuprincipalAux.getIsDeleted()) {
				parametrofactuprincipalAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroFactuPrincipal parametrofactuprincipalAsignar,ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		parametrofactuprincipalAsignar.setId(parametrofactuprincipal.getId());	
		parametrofactuprincipalAsignar.setVersionRow(parametrofactuprincipal.getVersionRow());	
		parametrofactuprincipalAsignar.setid_empresa(parametrofactuprincipal.getid_empresa());
		parametrofactuprincipalAsignar.setempresa_descripcion(parametrofactuprincipal.getempresa_descripcion());	
		parametrofactuprincipalAsignar.setid_sucursal(parametrofactuprincipal.getid_sucursal());
		parametrofactuprincipalAsignar.setsucursal_descripcion(parametrofactuprincipal.getsucursal_descripcion());	
		parametrofactuprincipalAsignar.setid_tipo_param_factu_descuento(parametrofactuprincipal.getid_tipo_param_factu_descuento());
		parametrofactuprincipalAsignar.settipoparamfactudescuento_descripcion(parametrofactuprincipal.gettipoparamfactudescuento_descripcion());	
		parametrofactuprincipalAsignar.setid_tipo_param_factu_listado_cliente(parametrofactuprincipal.getid_tipo_param_factu_listado_cliente());
		parametrofactuprincipalAsignar.settipoparamfactulistadocliente_descripcion(parametrofactuprincipal.gettipoparamfactulistadocliente_descripcion());	
		parametrofactuprincipalAsignar.setid_tipo_param_factu_secuencia_trabajo(parametrofactuprincipal.getid_tipo_param_factu_secuencia_trabajo());
		parametrofactuprincipalAsignar.settipoparamfactusecuenciatrabajo_descripcion(parametrofactuprincipal.gettipoparamfactusecuenciatrabajo_descripcion());	
		parametrofactuprincipalAsignar.setid_tipo_documento_factura(parametrofactuprincipal.getid_tipo_documento_factura());
		parametrofactuprincipalAsignar.settipodocumentofactura_descripcion(parametrofactuprincipal.gettipodocumentofactura_descripcion());	
		parametrofactuprincipalAsignar.setid_tipo_documento_nota_credito(parametrofactuprincipal.getid_tipo_documento_nota_credito());
		parametrofactuprincipalAsignar.settipodocumentonotacredito_descripcion(parametrofactuprincipal.gettipodocumentonotacredito_descripcion());	
		parametrofactuprincipalAsignar.setid_tipo_documento_nota_debito(parametrofactuprincipal.getid_tipo_documento_nota_debito());
		parametrofactuprincipalAsignar.settipodocumentonotadebito_descripcion(parametrofactuprincipal.gettipodocumentonotadebito_descripcion());	
		parametrofactuprincipalAsignar.seten_linea(parametrofactuprincipal.geten_linea());	
		parametrofactuprincipalAsignar.setcon_cuenta_tipo_cliente(parametrofactuprincipal.getcon_cuenta_tipo_cliente());	
		parametrofactuprincipalAsignar.setcon_cliente_impuesto(parametrofactuprincipal.getcon_cliente_impuesto());	
		parametrofactuprincipalAsignar.setid_libro_contable(parametrofactuprincipal.getid_libro_contable());
		parametrofactuprincipalAsignar.setlibrocontable_descripcion(parametrofactuprincipal.getlibrocontable_descripcion());	
		parametrofactuprincipalAsignar.setid_moneda(parametrofactuprincipal.getid_moneda());
		parametrofactuprincipalAsignar.setmoneda_descripcion(parametrofactuprincipal.getmoneda_descripcion());	
		parametrofactuprincipalAsignar.setcon_impresion(parametrofactuprincipal.getcon_impresion());	
		parametrofactuprincipalAsignar.setid_formato(parametrofactuprincipal.getid_formato());
		parametrofactuprincipalAsignar.setformato_descripcion(parametrofactuprincipal.getformato_descripcion());	
		parametrofactuprincipalAsignar.setcon_secuencial_usuario(parametrofactuprincipal.getcon_secuencial_usuario());	
		parametrofactuprincipalAsignar.setcon_secuencial_editable(parametrofactuprincipal.getcon_secuencial_editable());	
		parametrofactuprincipalAsignar.setcon_precio_por_cliente(parametrofactuprincipal.getcon_precio_por_cliente());	
		parametrofactuprincipalAsignar.setcon_modificar_precio(parametrofactuprincipal.getcon_modificar_precio());	
		parametrofactuprincipalAsignar.setcon_modificar_servicio(parametrofactuprincipal.getcon_modificar_servicio());	
		parametrofactuprincipalAsignar.setcon_cambiar_unidad(parametrofactuprincipal.getcon_cambiar_unidad());	
		parametrofactuprincipalAsignar.setnumero_decimales_unidad(parametrofactuprincipal.getnumero_decimales_unidad());	
		parametrofactuprincipalAsignar.setcon_activar_serie(parametrofactuprincipal.getcon_activar_serie());	
		parametrofactuprincipalAsignar.setcon_activar_lote(parametrofactuprincipal.getcon_activar_lote());	
		parametrofactuprincipalAsignar.setcon_activar_multi_empresa(parametrofactuprincipal.getcon_activar_multi_empresa());	
		parametrofactuprincipalAsignar.setcon_centro_costos(parametrofactuprincipal.getcon_centro_costos());	
		parametrofactuprincipalAsignar.setcon_unidades(parametrofactuprincipal.getcon_unidades());	
		parametrofactuprincipalAsignar.setcon_cupo_disponible(parametrofactuprincipal.getcon_cupo_disponible());	
		parametrofactuprincipalAsignar.setcon_forma_pago(parametrofactuprincipal.getcon_forma_pago());	
		parametrofactuprincipalAsignar.setcon_envio_mail(parametrofactuprincipal.getcon_envio_mail());	
		parametrofactuprincipalAsignar.setcon_autorizar_proforma(parametrofactuprincipal.getcon_autorizar_proforma());	
		parametrofactuprincipalAsignar.setcon_bloqueo_pedido(parametrofactuprincipal.getcon_bloqueo_pedido());	
		parametrofactuprincipalAsignar.setcon_control_anticipo(parametrofactuprincipal.getcon_control_anticipo());	
		parametrofactuprincipalAsignar.setcon_factura_auto(parametrofactuprincipal.getcon_factura_auto());	
		parametrofactuprincipalAsignar.setcon_grabar_valor_cero(parametrofactuprincipal.getcon_grabar_valor_cero());	
		parametrofactuprincipalAsignar.setcon_agregar_item(parametrofactuprincipal.getcon_agregar_item());	
		parametrofactuprincipalAsignar.setnumero_copias(parametrofactuprincipal.getnumero_copias());	
		parametrofactuprincipalAsignar.setleyenda(parametrofactuprincipal.getleyenda());	
		parametrofactuprincipalAsignar.setcon_sin_factura(parametrofactuprincipal.getcon_sin_factura());	
		parametrofactuprincipalAsignar.setid_cuenta_contable_flete_venta(parametrofactuprincipal.getid_cuenta_contable_flete_venta());
		parametrofactuprincipalAsignar.setcuentacontablefleteventa_descripcion(parametrofactuprincipal.getcuentacontablefleteventa_descripcion());	
		parametrofactuprincipalAsignar.setid_cuenta_contable_otro_cargo(parametrofactuprincipal.getid_cuenta_contable_otro_cargo());
		parametrofactuprincipalAsignar.setcuentacontableotrocargo_descripcion(parametrofactuprincipal.getcuentacontableotrocargo_descripcion());	
		parametrofactuprincipalAsignar.setid_cuenta_contable_finan(parametrofactuprincipal.getid_cuenta_contable_finan());
		parametrofactuprincipalAsignar.setcuentacontablefinan_descripcion(parametrofactuprincipal.getcuentacontablefinan_descripcion());	
		parametrofactuprincipalAsignar.setid_cuenta_contable_boni(parametrofactuprincipal.getid_cuenta_contable_boni());
		parametrofactuprincipalAsignar.setcuentacontableboni_descripcion(parametrofactuprincipal.getcuentacontableboni_descripcion());	
		parametrofactuprincipalAsignar.setid_cuenta_contable_boni_devol(parametrofactuprincipal.getid_cuenta_contable_boni_devol());
		parametrofactuprincipalAsignar.setcuentacontablebonidevol_descripcion(parametrofactuprincipal.getcuentacontablebonidevol_descripcion());	
		parametrofactuprincipalAsignar.setid_cuenta_contable_ice(parametrofactuprincipal.getid_cuenta_contable_ice());
		parametrofactuprincipalAsignar.setcuentacontableice_descripcion(parametrofactuprincipal.getcuentacontableice_descripcion());	
	}
	
	public static void inicializarParametroFactuPrincipal(ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		try {
				parametrofactuprincipal.setId(0L);	
					
				parametrofactuprincipal.setid_empresa(-1L);	
				parametrofactuprincipal.setid_sucursal(-1L);	
				parametrofactuprincipal.setid_tipo_param_factu_descuento(-1L);	
				parametrofactuprincipal.setid_tipo_param_factu_listado_cliente(-1L);	
				parametrofactuprincipal.setid_tipo_param_factu_secuencia_trabajo(-1L);	
				parametrofactuprincipal.setid_tipo_documento_factura(-1L);	
				parametrofactuprincipal.setid_tipo_documento_nota_credito(-1L);	
				parametrofactuprincipal.setid_tipo_documento_nota_debito(-1L);	
				parametrofactuprincipal.seten_linea(false);	
				parametrofactuprincipal.setcon_cuenta_tipo_cliente(false);	
				parametrofactuprincipal.setcon_cliente_impuesto(false);	
				parametrofactuprincipal.setid_libro_contable(-1L);	
				parametrofactuprincipal.setid_moneda(-1L);	
				parametrofactuprincipal.setcon_impresion(false);	
				parametrofactuprincipal.setid_formato(-1L);	
				parametrofactuprincipal.setcon_secuencial_usuario(false);	
				parametrofactuprincipal.setcon_secuencial_editable(false);	
				parametrofactuprincipal.setcon_precio_por_cliente(false);	
				parametrofactuprincipal.setcon_modificar_precio(false);	
				parametrofactuprincipal.setcon_modificar_servicio(false);	
				parametrofactuprincipal.setcon_cambiar_unidad(false);	
				parametrofactuprincipal.setnumero_decimales_unidad(0);	
				parametrofactuprincipal.setcon_activar_serie(false);	
				parametrofactuprincipal.setcon_activar_lote(false);	
				parametrofactuprincipal.setcon_activar_multi_empresa(false);	
				parametrofactuprincipal.setcon_centro_costos(false);	
				parametrofactuprincipal.setcon_unidades(false);	
				parametrofactuprincipal.setcon_cupo_disponible(false);	
				parametrofactuprincipal.setcon_forma_pago(false);	
				parametrofactuprincipal.setcon_envio_mail(false);	
				parametrofactuprincipal.setcon_autorizar_proforma(false);	
				parametrofactuprincipal.setcon_bloqueo_pedido(false);	
				parametrofactuprincipal.setcon_control_anticipo(false);	
				parametrofactuprincipal.setcon_factura_auto(false);	
				parametrofactuprincipal.setcon_grabar_valor_cero(false);	
				parametrofactuprincipal.setcon_agregar_item(false);	
				parametrofactuprincipal.setnumero_copias(0);	
				parametrofactuprincipal.setleyenda("");	
				parametrofactuprincipal.setcon_sin_factura(false);	
				parametrofactuprincipal.setid_cuenta_contable_flete_venta(-1L);	
				parametrofactuprincipal.setid_cuenta_contable_otro_cargo(-1L);	
				parametrofactuprincipal.setid_cuenta_contable_finan(-1L);	
				parametrofactuprincipal.setid_cuenta_contable_boni(-1L);	
				parametrofactuprincipal.setid_cuenta_contable_boni_devol(-1L);	
				parametrofactuprincipal.setid_cuenta_contable_ice(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroFactuPrincipal(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPOPARAMFACTUDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPOPARAMFACTULISTADOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPOPARAMFACTUSECUENCIATRABAJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPODOCUMENTOFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPODOCUMENTONOTACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_IDTIPODOCUMENTONOTADEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_ENLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONCUENTATIPOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONCLIENTEIMPUESTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_IDLIBROCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONIMPRESION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONSECUENCIALUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONSECUENCIALEDITABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONPRECIOPORCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONMODIFICARPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONMODIFICARSERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONCAMBIARUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_NUMERODECIMALESUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONACTIVARSERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONACTIVARLOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONACTIVARMULTIEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONCENTROCOSTOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONUNIDADES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONCUPODISPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONFORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONENVIOMAIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONAUTORIZARPROFORMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONBLOQUEOPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONCONTROLANTICIPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONFACTURAAUTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONGRABARVALORCERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONAGREGARITEM);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_NUMEROCOPIAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_LEYENDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_CONSINFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEFLETEVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEOTROCARGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEFINAN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEBONI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEBONIDEVOL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuPrincipalConstantesFunciones.LABEL_IDCUENTACONTABLEICE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroFactuPrincipal(String sTipo,Row row,Workbook workbook,ParametroFactuPrincipal parametrofactuprincipal,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuprincipal.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuprincipal.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuprincipal.gettipoparamfactudescuento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuprincipal.gettipoparamfactulistadocliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuprincipal.gettipoparamfactusecuenciatrabajo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuprincipal.gettipodocumentofactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuprincipal.gettipodocumentonotacredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuprincipal.gettipodocumentonotadebito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.geten_linea()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_cuenta_tipo_cliente()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_cliente_impuesto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuprincipal.getlibrocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuprincipal.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_impresion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuprincipal.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_secuencial_usuario()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_secuencial_editable()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_precio_por_cliente()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_modificar_precio()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_modificar_servicio()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_cambiar_unidad()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuprincipal.getnumero_decimales_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_activar_serie()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_activar_lote()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_activar_multi_empresa()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_centro_costos()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_unidades()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_cupo_disponible()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_forma_pago()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_envio_mail()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_autorizar_proforma()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_bloqueo_pedido()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_control_anticipo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_factura_auto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_grabar_valor_cero()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_agregar_item()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuprincipal.getnumero_copias());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuprincipal.getleyenda());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuprincipal.getcon_sin_factura()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuprincipal.getcuentacontablefleteventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuprincipal.getcuentacontableotrocargo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuprincipal.getcuentacontablefinan_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuprincipal.getcuentacontableboni_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuprincipal.getcuentacontablebonidevol_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuprincipal.getcuentacontableice_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroFactuPrincipal=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroFactuPrincipal() {
		return this.sFinalQueryParametroFactuPrincipal;
	}
	
	public void setsFinalQueryParametroFactuPrincipal(String sFinalQueryParametroFactuPrincipal) {
		this.sFinalQueryParametroFactuPrincipal= sFinalQueryParametroFactuPrincipal;
	}
	
	public Border resaltarSeleccionarParametroFactuPrincipal=null;
	
	public Border setResaltarSeleccionarParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroFactuPrincipal= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroFactuPrincipal() {
		return this.resaltarSeleccionarParametroFactuPrincipal;
	}
	
	public void setResaltarSeleccionarParametroFactuPrincipal(Border borderResaltarSeleccionarParametroFactuPrincipal) {
		this.resaltarSeleccionarParametroFactuPrincipal= borderResaltarSeleccionarParametroFactuPrincipal;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroFactuPrincipal=null;
	public Boolean mostraridParametroFactuPrincipal=true;
	public Boolean activaridParametroFactuPrincipal=true;

	public Border resaltarid_empresaParametroFactuPrincipal=null;
	public Boolean mostrarid_empresaParametroFactuPrincipal=true;
	public Boolean activarid_empresaParametroFactuPrincipal=true;
	public Boolean cargarid_empresaParametroFactuPrincipal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroFactuPrincipal=false;//ConEventDepend=true

	public Border resaltarid_sucursalParametroFactuPrincipal=null;
	public Boolean mostrarid_sucursalParametroFactuPrincipal=true;
	public Boolean activarid_sucursalParametroFactuPrincipal=true;
	public Boolean cargarid_sucursalParametroFactuPrincipal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalParametroFactuPrincipal=false;//ConEventDepend=true

	public Border resaltarid_tipo_param_factu_descuentoParametroFactuPrincipal=null;
	public Boolean mostrarid_tipo_param_factu_descuentoParametroFactuPrincipal=true;
	public Boolean activarid_tipo_param_factu_descuentoParametroFactuPrincipal=true;
	public Boolean cargarid_tipo_param_factu_descuentoParametroFactuPrincipal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_param_factu_descuentoParametroFactuPrincipal=false;//ConEventDepend=true

	public Border resaltarid_tipo_param_factu_listado_clienteParametroFactuPrincipal=null;
	public Boolean mostrarid_tipo_param_factu_listado_clienteParametroFactuPrincipal=true;
	public Boolean activarid_tipo_param_factu_listado_clienteParametroFactuPrincipal=true;
	public Boolean cargarid_tipo_param_factu_listado_clienteParametroFactuPrincipal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_param_factu_listado_clienteParametroFactuPrincipal=false;//ConEventDepend=true

	public Border resaltarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal=null;
	public Boolean mostrarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal=true;
	public Boolean activarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal=true;
	public Boolean cargarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal=false;//ConEventDepend=true

	public Border resaltarid_tipo_documento_facturaParametroFactuPrincipal=null;
	public Boolean mostrarid_tipo_documento_facturaParametroFactuPrincipal=true;
	public Boolean activarid_tipo_documento_facturaParametroFactuPrincipal=true;
	public Boolean cargarid_tipo_documento_facturaParametroFactuPrincipal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documento_facturaParametroFactuPrincipal=false;//ConEventDepend=true

	public Border resaltarid_tipo_documento_nota_creditoParametroFactuPrincipal=null;
	public Boolean mostrarid_tipo_documento_nota_creditoParametroFactuPrincipal=true;
	public Boolean activarid_tipo_documento_nota_creditoParametroFactuPrincipal=true;
	public Boolean cargarid_tipo_documento_nota_creditoParametroFactuPrincipal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documento_nota_creditoParametroFactuPrincipal=false;//ConEventDepend=true

	public Border resaltarid_tipo_documento_nota_debitoParametroFactuPrincipal=null;
	public Boolean mostrarid_tipo_documento_nota_debitoParametroFactuPrincipal=true;
	public Boolean activarid_tipo_documento_nota_debitoParametroFactuPrincipal=true;
	public Boolean cargarid_tipo_documento_nota_debitoParametroFactuPrincipal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documento_nota_debitoParametroFactuPrincipal=false;//ConEventDepend=true

	public Border resaltaren_lineaParametroFactuPrincipal=null;
	public Boolean mostraren_lineaParametroFactuPrincipal=true;
	public Boolean activaren_lineaParametroFactuPrincipal=true;

	public Border resaltarcon_cuenta_tipo_clienteParametroFactuPrincipal=null;
	public Boolean mostrarcon_cuenta_tipo_clienteParametroFactuPrincipal=true;
	public Boolean activarcon_cuenta_tipo_clienteParametroFactuPrincipal=true;

	public Border resaltarcon_cliente_impuestoParametroFactuPrincipal=null;
	public Boolean mostrarcon_cliente_impuestoParametroFactuPrincipal=true;
	public Boolean activarcon_cliente_impuestoParametroFactuPrincipal=true;

	public Border resaltarid_libro_contableParametroFactuPrincipal=null;
	public Boolean mostrarid_libro_contableParametroFactuPrincipal=true;
	public Boolean activarid_libro_contableParametroFactuPrincipal=true;
	public Boolean cargarid_libro_contableParametroFactuPrincipal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_libro_contableParametroFactuPrincipal=false;//ConEventDepend=true

	public Border resaltarid_monedaParametroFactuPrincipal=null;
	public Boolean mostrarid_monedaParametroFactuPrincipal=true;
	public Boolean activarid_monedaParametroFactuPrincipal=true;
	public Boolean cargarid_monedaParametroFactuPrincipal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaParametroFactuPrincipal=false;//ConEventDepend=true

	public Border resaltarcon_impresionParametroFactuPrincipal=null;
	public Boolean mostrarcon_impresionParametroFactuPrincipal=true;
	public Boolean activarcon_impresionParametroFactuPrincipal=true;

	public Border resaltarid_formatoParametroFactuPrincipal=null;
	public Boolean mostrarid_formatoParametroFactuPrincipal=true;
	public Boolean activarid_formatoParametroFactuPrincipal=true;
	public Boolean cargarid_formatoParametroFactuPrincipal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoParametroFactuPrincipal=false;//ConEventDepend=true

	public Border resaltarcon_secuencial_usuarioParametroFactuPrincipal=null;
	public Boolean mostrarcon_secuencial_usuarioParametroFactuPrincipal=true;
	public Boolean activarcon_secuencial_usuarioParametroFactuPrincipal=true;

	public Border resaltarcon_secuencial_editableParametroFactuPrincipal=null;
	public Boolean mostrarcon_secuencial_editableParametroFactuPrincipal=true;
	public Boolean activarcon_secuencial_editableParametroFactuPrincipal=true;

	public Border resaltarcon_precio_por_clienteParametroFactuPrincipal=null;
	public Boolean mostrarcon_precio_por_clienteParametroFactuPrincipal=true;
	public Boolean activarcon_precio_por_clienteParametroFactuPrincipal=true;

	public Border resaltarcon_modificar_precioParametroFactuPrincipal=null;
	public Boolean mostrarcon_modificar_precioParametroFactuPrincipal=true;
	public Boolean activarcon_modificar_precioParametroFactuPrincipal=true;

	public Border resaltarcon_modificar_servicioParametroFactuPrincipal=null;
	public Boolean mostrarcon_modificar_servicioParametroFactuPrincipal=true;
	public Boolean activarcon_modificar_servicioParametroFactuPrincipal=true;

	public Border resaltarcon_cambiar_unidadParametroFactuPrincipal=null;
	public Boolean mostrarcon_cambiar_unidadParametroFactuPrincipal=true;
	public Boolean activarcon_cambiar_unidadParametroFactuPrincipal=true;

	public Border resaltarnumero_decimales_unidadParametroFactuPrincipal=null;
	public Boolean mostrarnumero_decimales_unidadParametroFactuPrincipal=true;
	public Boolean activarnumero_decimales_unidadParametroFactuPrincipal=true;

	public Border resaltarcon_activar_serieParametroFactuPrincipal=null;
	public Boolean mostrarcon_activar_serieParametroFactuPrincipal=true;
	public Boolean activarcon_activar_serieParametroFactuPrincipal=true;

	public Border resaltarcon_activar_loteParametroFactuPrincipal=null;
	public Boolean mostrarcon_activar_loteParametroFactuPrincipal=true;
	public Boolean activarcon_activar_loteParametroFactuPrincipal=true;

	public Border resaltarcon_activar_multi_empresaParametroFactuPrincipal=null;
	public Boolean mostrarcon_activar_multi_empresaParametroFactuPrincipal=true;
	public Boolean activarcon_activar_multi_empresaParametroFactuPrincipal=true;

	public Border resaltarcon_centro_costosParametroFactuPrincipal=null;
	public Boolean mostrarcon_centro_costosParametroFactuPrincipal=true;
	public Boolean activarcon_centro_costosParametroFactuPrincipal=true;

	public Border resaltarcon_unidadesParametroFactuPrincipal=null;
	public Boolean mostrarcon_unidadesParametroFactuPrincipal=true;
	public Boolean activarcon_unidadesParametroFactuPrincipal=true;

	public Border resaltarcon_cupo_disponibleParametroFactuPrincipal=null;
	public Boolean mostrarcon_cupo_disponibleParametroFactuPrincipal=true;
	public Boolean activarcon_cupo_disponibleParametroFactuPrincipal=true;

	public Border resaltarcon_forma_pagoParametroFactuPrincipal=null;
	public Boolean mostrarcon_forma_pagoParametroFactuPrincipal=true;
	public Boolean activarcon_forma_pagoParametroFactuPrincipal=true;

	public Border resaltarcon_envio_mailParametroFactuPrincipal=null;
	public Boolean mostrarcon_envio_mailParametroFactuPrincipal=true;
	public Boolean activarcon_envio_mailParametroFactuPrincipal=true;

	public Border resaltarcon_autorizar_proformaParametroFactuPrincipal=null;
	public Boolean mostrarcon_autorizar_proformaParametroFactuPrincipal=true;
	public Boolean activarcon_autorizar_proformaParametroFactuPrincipal=true;

	public Border resaltarcon_bloqueo_pedidoParametroFactuPrincipal=null;
	public Boolean mostrarcon_bloqueo_pedidoParametroFactuPrincipal=true;
	public Boolean activarcon_bloqueo_pedidoParametroFactuPrincipal=true;

	public Border resaltarcon_control_anticipoParametroFactuPrincipal=null;
	public Boolean mostrarcon_control_anticipoParametroFactuPrincipal=true;
	public Boolean activarcon_control_anticipoParametroFactuPrincipal=true;

	public Border resaltarcon_factura_autoParametroFactuPrincipal=null;
	public Boolean mostrarcon_factura_autoParametroFactuPrincipal=true;
	public Boolean activarcon_factura_autoParametroFactuPrincipal=true;

	public Border resaltarcon_grabar_valor_ceroParametroFactuPrincipal=null;
	public Boolean mostrarcon_grabar_valor_ceroParametroFactuPrincipal=true;
	public Boolean activarcon_grabar_valor_ceroParametroFactuPrincipal=true;

	public Border resaltarcon_agregar_itemParametroFactuPrincipal=null;
	public Boolean mostrarcon_agregar_itemParametroFactuPrincipal=true;
	public Boolean activarcon_agregar_itemParametroFactuPrincipal=true;

	public Border resaltarnumero_copiasParametroFactuPrincipal=null;
	public Boolean mostrarnumero_copiasParametroFactuPrincipal=true;
	public Boolean activarnumero_copiasParametroFactuPrincipal=true;

	public Border resaltarleyendaParametroFactuPrincipal=null;
	public Boolean mostrarleyendaParametroFactuPrincipal=true;
	public Boolean activarleyendaParametroFactuPrincipal=true;

	public Border resaltarcon_sin_facturaParametroFactuPrincipal=null;
	public Boolean mostrarcon_sin_facturaParametroFactuPrincipal=true;
	public Boolean activarcon_sin_facturaParametroFactuPrincipal=true;

	public Border resaltarid_cuenta_contable_flete_ventaParametroFactuPrincipal=null;
	public Boolean mostrarid_cuenta_contable_flete_ventaParametroFactuPrincipal=true;
	public Boolean activarid_cuenta_contable_flete_ventaParametroFactuPrincipal=true;
	public Boolean cargarid_cuenta_contable_flete_ventaParametroFactuPrincipal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_flete_ventaParametroFactuPrincipal=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_otro_cargoParametroFactuPrincipal=null;
	public Boolean mostrarid_cuenta_contable_otro_cargoParametroFactuPrincipal=true;
	public Boolean activarid_cuenta_contable_otro_cargoParametroFactuPrincipal=true;
	public Boolean cargarid_cuenta_contable_otro_cargoParametroFactuPrincipal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_otro_cargoParametroFactuPrincipal=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_finanParametroFactuPrincipal=null;
	public Boolean mostrarid_cuenta_contable_finanParametroFactuPrincipal=true;
	public Boolean activarid_cuenta_contable_finanParametroFactuPrincipal=true;
	public Boolean cargarid_cuenta_contable_finanParametroFactuPrincipal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_finanParametroFactuPrincipal=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_boniParametroFactuPrincipal=null;
	public Boolean mostrarid_cuenta_contable_boniParametroFactuPrincipal=true;
	public Boolean activarid_cuenta_contable_boniParametroFactuPrincipal=true;
	public Boolean cargarid_cuenta_contable_boniParametroFactuPrincipal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_boniParametroFactuPrincipal=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_boni_devolParametroFactuPrincipal=null;
	public Boolean mostrarid_cuenta_contable_boni_devolParametroFactuPrincipal=true;
	public Boolean activarid_cuenta_contable_boni_devolParametroFactuPrincipal=true;
	public Boolean cargarid_cuenta_contable_boni_devolParametroFactuPrincipal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_boni_devolParametroFactuPrincipal=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_iceParametroFactuPrincipal=null;
	public Boolean mostrarid_cuenta_contable_iceParametroFactuPrincipal=true;
	public Boolean activarid_cuenta_contable_iceParametroFactuPrincipal=true;
	public Boolean cargarid_cuenta_contable_iceParametroFactuPrincipal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_iceParametroFactuPrincipal=false;//ConEventDepend=true

	
	

	public Border setResaltaridParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltaridParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroFactuPrincipal() {
		return this.resaltaridParametroFactuPrincipal;
	}

	public void setResaltaridParametroFactuPrincipal(Border borderResaltar) {
		this.resaltaridParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostraridParametroFactuPrincipal() {
		return this.mostraridParametroFactuPrincipal;
	}

	public void setMostraridParametroFactuPrincipal(Boolean mostraridParametroFactuPrincipal) {
		this.mostraridParametroFactuPrincipal= mostraridParametroFactuPrincipal;
	}

	public Boolean getActivaridParametroFactuPrincipal() {
		return this.activaridParametroFactuPrincipal;
	}

	public void setActivaridParametroFactuPrincipal(Boolean activaridParametroFactuPrincipal) {
		this.activaridParametroFactuPrincipal= activaridParametroFactuPrincipal;
	}

	public Border setResaltarid_empresaParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroFactuPrincipal() {
		return this.resaltarid_empresaParametroFactuPrincipal;
	}

	public void setResaltarid_empresaParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarid_empresaParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroFactuPrincipal() {
		return this.mostrarid_empresaParametroFactuPrincipal;
	}

	public void setMostrarid_empresaParametroFactuPrincipal(Boolean mostrarid_empresaParametroFactuPrincipal) {
		this.mostrarid_empresaParametroFactuPrincipal= mostrarid_empresaParametroFactuPrincipal;
	}

	public Boolean getActivarid_empresaParametroFactuPrincipal() {
		return this.activarid_empresaParametroFactuPrincipal;
	}

	public void setActivarid_empresaParametroFactuPrincipal(Boolean activarid_empresaParametroFactuPrincipal) {
		this.activarid_empresaParametroFactuPrincipal= activarid_empresaParametroFactuPrincipal;
	}

	public Boolean getCargarid_empresaParametroFactuPrincipal() {
		return this.cargarid_empresaParametroFactuPrincipal;
	}

	public void setCargarid_empresaParametroFactuPrincipal(Boolean cargarid_empresaParametroFactuPrincipal) {
		this.cargarid_empresaParametroFactuPrincipal= cargarid_empresaParametroFactuPrincipal;
	}

	public Border setResaltarid_sucursalParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarid_sucursalParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalParametroFactuPrincipal() {
		return this.resaltarid_sucursalParametroFactuPrincipal;
	}

	public void setResaltarid_sucursalParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarid_sucursalParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarid_sucursalParametroFactuPrincipal() {
		return this.mostrarid_sucursalParametroFactuPrincipal;
	}

	public void setMostrarid_sucursalParametroFactuPrincipal(Boolean mostrarid_sucursalParametroFactuPrincipal) {
		this.mostrarid_sucursalParametroFactuPrincipal= mostrarid_sucursalParametroFactuPrincipal;
	}

	public Boolean getActivarid_sucursalParametroFactuPrincipal() {
		return this.activarid_sucursalParametroFactuPrincipal;
	}

	public void setActivarid_sucursalParametroFactuPrincipal(Boolean activarid_sucursalParametroFactuPrincipal) {
		this.activarid_sucursalParametroFactuPrincipal= activarid_sucursalParametroFactuPrincipal;
	}

	public Boolean getCargarid_sucursalParametroFactuPrincipal() {
		return this.cargarid_sucursalParametroFactuPrincipal;
	}

	public void setCargarid_sucursalParametroFactuPrincipal(Boolean cargarid_sucursalParametroFactuPrincipal) {
		this.cargarid_sucursalParametroFactuPrincipal= cargarid_sucursalParametroFactuPrincipal;
	}

	public Border setResaltarid_tipo_param_factu_descuentoParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarid_tipo_param_factu_descuentoParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_param_factu_descuentoParametroFactuPrincipal() {
		return this.resaltarid_tipo_param_factu_descuentoParametroFactuPrincipal;
	}

	public void setResaltarid_tipo_param_factu_descuentoParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarid_tipo_param_factu_descuentoParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarid_tipo_param_factu_descuentoParametroFactuPrincipal() {
		return this.mostrarid_tipo_param_factu_descuentoParametroFactuPrincipal;
	}

	public void setMostrarid_tipo_param_factu_descuentoParametroFactuPrincipal(Boolean mostrarid_tipo_param_factu_descuentoParametroFactuPrincipal) {
		this.mostrarid_tipo_param_factu_descuentoParametroFactuPrincipal= mostrarid_tipo_param_factu_descuentoParametroFactuPrincipal;
	}

	public Boolean getActivarid_tipo_param_factu_descuentoParametroFactuPrincipal() {
		return this.activarid_tipo_param_factu_descuentoParametroFactuPrincipal;
	}

	public void setActivarid_tipo_param_factu_descuentoParametroFactuPrincipal(Boolean activarid_tipo_param_factu_descuentoParametroFactuPrincipal) {
		this.activarid_tipo_param_factu_descuentoParametroFactuPrincipal= activarid_tipo_param_factu_descuentoParametroFactuPrincipal;
	}

	public Boolean getCargarid_tipo_param_factu_descuentoParametroFactuPrincipal() {
		return this.cargarid_tipo_param_factu_descuentoParametroFactuPrincipal;
	}

	public void setCargarid_tipo_param_factu_descuentoParametroFactuPrincipal(Boolean cargarid_tipo_param_factu_descuentoParametroFactuPrincipal) {
		this.cargarid_tipo_param_factu_descuentoParametroFactuPrincipal= cargarid_tipo_param_factu_descuentoParametroFactuPrincipal;
	}

	public Border setResaltarid_tipo_param_factu_listado_clienteParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarid_tipo_param_factu_listado_clienteParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_param_factu_listado_clienteParametroFactuPrincipal() {
		return this.resaltarid_tipo_param_factu_listado_clienteParametroFactuPrincipal;
	}

	public void setResaltarid_tipo_param_factu_listado_clienteParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarid_tipo_param_factu_listado_clienteParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarid_tipo_param_factu_listado_clienteParametroFactuPrincipal() {
		return this.mostrarid_tipo_param_factu_listado_clienteParametroFactuPrincipal;
	}

	public void setMostrarid_tipo_param_factu_listado_clienteParametroFactuPrincipal(Boolean mostrarid_tipo_param_factu_listado_clienteParametroFactuPrincipal) {
		this.mostrarid_tipo_param_factu_listado_clienteParametroFactuPrincipal= mostrarid_tipo_param_factu_listado_clienteParametroFactuPrincipal;
	}

	public Boolean getActivarid_tipo_param_factu_listado_clienteParametroFactuPrincipal() {
		return this.activarid_tipo_param_factu_listado_clienteParametroFactuPrincipal;
	}

	public void setActivarid_tipo_param_factu_listado_clienteParametroFactuPrincipal(Boolean activarid_tipo_param_factu_listado_clienteParametroFactuPrincipal) {
		this.activarid_tipo_param_factu_listado_clienteParametroFactuPrincipal= activarid_tipo_param_factu_listado_clienteParametroFactuPrincipal;
	}

	public Boolean getCargarid_tipo_param_factu_listado_clienteParametroFactuPrincipal() {
		return this.cargarid_tipo_param_factu_listado_clienteParametroFactuPrincipal;
	}

	public void setCargarid_tipo_param_factu_listado_clienteParametroFactuPrincipal(Boolean cargarid_tipo_param_factu_listado_clienteParametroFactuPrincipal) {
		this.cargarid_tipo_param_factu_listado_clienteParametroFactuPrincipal= cargarid_tipo_param_factu_listado_clienteParametroFactuPrincipal;
	}

	public Border setResaltarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal() {
		return this.resaltarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal;
	}

	public void setResaltarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal() {
		return this.mostrarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal;
	}

	public void setMostrarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal(Boolean mostrarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal) {
		this.mostrarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal= mostrarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal;
	}

	public Boolean getActivarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal() {
		return this.activarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal;
	}

	public void setActivarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal(Boolean activarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal) {
		this.activarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal= activarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal;
	}

	public Boolean getCargarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal() {
		return this.cargarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal;
	}

	public void setCargarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal(Boolean cargarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal) {
		this.cargarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal= cargarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal;
	}

	public Border setResaltarid_tipo_documento_facturaParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documento_facturaParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documento_facturaParametroFactuPrincipal() {
		return this.resaltarid_tipo_documento_facturaParametroFactuPrincipal;
	}

	public void setResaltarid_tipo_documento_facturaParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarid_tipo_documento_facturaParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documento_facturaParametroFactuPrincipal() {
		return this.mostrarid_tipo_documento_facturaParametroFactuPrincipal;
	}

	public void setMostrarid_tipo_documento_facturaParametroFactuPrincipal(Boolean mostrarid_tipo_documento_facturaParametroFactuPrincipal) {
		this.mostrarid_tipo_documento_facturaParametroFactuPrincipal= mostrarid_tipo_documento_facturaParametroFactuPrincipal;
	}

	public Boolean getActivarid_tipo_documento_facturaParametroFactuPrincipal() {
		return this.activarid_tipo_documento_facturaParametroFactuPrincipal;
	}

	public void setActivarid_tipo_documento_facturaParametroFactuPrincipal(Boolean activarid_tipo_documento_facturaParametroFactuPrincipal) {
		this.activarid_tipo_documento_facturaParametroFactuPrincipal= activarid_tipo_documento_facturaParametroFactuPrincipal;
	}

	public Boolean getCargarid_tipo_documento_facturaParametroFactuPrincipal() {
		return this.cargarid_tipo_documento_facturaParametroFactuPrincipal;
	}

	public void setCargarid_tipo_documento_facturaParametroFactuPrincipal(Boolean cargarid_tipo_documento_facturaParametroFactuPrincipal) {
		this.cargarid_tipo_documento_facturaParametroFactuPrincipal= cargarid_tipo_documento_facturaParametroFactuPrincipal;
	}

	public Border setResaltarid_tipo_documento_nota_creditoParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documento_nota_creditoParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documento_nota_creditoParametroFactuPrincipal() {
		return this.resaltarid_tipo_documento_nota_creditoParametroFactuPrincipal;
	}

	public void setResaltarid_tipo_documento_nota_creditoParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarid_tipo_documento_nota_creditoParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documento_nota_creditoParametroFactuPrincipal() {
		return this.mostrarid_tipo_documento_nota_creditoParametroFactuPrincipal;
	}

	public void setMostrarid_tipo_documento_nota_creditoParametroFactuPrincipal(Boolean mostrarid_tipo_documento_nota_creditoParametroFactuPrincipal) {
		this.mostrarid_tipo_documento_nota_creditoParametroFactuPrincipal= mostrarid_tipo_documento_nota_creditoParametroFactuPrincipal;
	}

	public Boolean getActivarid_tipo_documento_nota_creditoParametroFactuPrincipal() {
		return this.activarid_tipo_documento_nota_creditoParametroFactuPrincipal;
	}

	public void setActivarid_tipo_documento_nota_creditoParametroFactuPrincipal(Boolean activarid_tipo_documento_nota_creditoParametroFactuPrincipal) {
		this.activarid_tipo_documento_nota_creditoParametroFactuPrincipal= activarid_tipo_documento_nota_creditoParametroFactuPrincipal;
	}

	public Boolean getCargarid_tipo_documento_nota_creditoParametroFactuPrincipal() {
		return this.cargarid_tipo_documento_nota_creditoParametroFactuPrincipal;
	}

	public void setCargarid_tipo_documento_nota_creditoParametroFactuPrincipal(Boolean cargarid_tipo_documento_nota_creditoParametroFactuPrincipal) {
		this.cargarid_tipo_documento_nota_creditoParametroFactuPrincipal= cargarid_tipo_documento_nota_creditoParametroFactuPrincipal;
	}

	public Border setResaltarid_tipo_documento_nota_debitoParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documento_nota_debitoParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documento_nota_debitoParametroFactuPrincipal() {
		return this.resaltarid_tipo_documento_nota_debitoParametroFactuPrincipal;
	}

	public void setResaltarid_tipo_documento_nota_debitoParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarid_tipo_documento_nota_debitoParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documento_nota_debitoParametroFactuPrincipal() {
		return this.mostrarid_tipo_documento_nota_debitoParametroFactuPrincipal;
	}

	public void setMostrarid_tipo_documento_nota_debitoParametroFactuPrincipal(Boolean mostrarid_tipo_documento_nota_debitoParametroFactuPrincipal) {
		this.mostrarid_tipo_documento_nota_debitoParametroFactuPrincipal= mostrarid_tipo_documento_nota_debitoParametroFactuPrincipal;
	}

	public Boolean getActivarid_tipo_documento_nota_debitoParametroFactuPrincipal() {
		return this.activarid_tipo_documento_nota_debitoParametroFactuPrincipal;
	}

	public void setActivarid_tipo_documento_nota_debitoParametroFactuPrincipal(Boolean activarid_tipo_documento_nota_debitoParametroFactuPrincipal) {
		this.activarid_tipo_documento_nota_debitoParametroFactuPrincipal= activarid_tipo_documento_nota_debitoParametroFactuPrincipal;
	}

	public Boolean getCargarid_tipo_documento_nota_debitoParametroFactuPrincipal() {
		return this.cargarid_tipo_documento_nota_debitoParametroFactuPrincipal;
	}

	public void setCargarid_tipo_documento_nota_debitoParametroFactuPrincipal(Boolean cargarid_tipo_documento_nota_debitoParametroFactuPrincipal) {
		this.cargarid_tipo_documento_nota_debitoParametroFactuPrincipal= cargarid_tipo_documento_nota_debitoParametroFactuPrincipal;
	}

	public Border setResaltaren_lineaParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltaren_lineaParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaren_lineaParametroFactuPrincipal() {
		return this.resaltaren_lineaParametroFactuPrincipal;
	}

	public void setResaltaren_lineaParametroFactuPrincipal(Border borderResaltar) {
		this.resaltaren_lineaParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostraren_lineaParametroFactuPrincipal() {
		return this.mostraren_lineaParametroFactuPrincipal;
	}

	public void setMostraren_lineaParametroFactuPrincipal(Boolean mostraren_lineaParametroFactuPrincipal) {
		this.mostraren_lineaParametroFactuPrincipal= mostraren_lineaParametroFactuPrincipal;
	}

	public Boolean getActivaren_lineaParametroFactuPrincipal() {
		return this.activaren_lineaParametroFactuPrincipal;
	}

	public void setActivaren_lineaParametroFactuPrincipal(Boolean activaren_lineaParametroFactuPrincipal) {
		this.activaren_lineaParametroFactuPrincipal= activaren_lineaParametroFactuPrincipal;
	}

	public Border setResaltarcon_cuenta_tipo_clienteParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_cuenta_tipo_clienteParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_cuenta_tipo_clienteParametroFactuPrincipal() {
		return this.resaltarcon_cuenta_tipo_clienteParametroFactuPrincipal;
	}

	public void setResaltarcon_cuenta_tipo_clienteParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_cuenta_tipo_clienteParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_cuenta_tipo_clienteParametroFactuPrincipal() {
		return this.mostrarcon_cuenta_tipo_clienteParametroFactuPrincipal;
	}

	public void setMostrarcon_cuenta_tipo_clienteParametroFactuPrincipal(Boolean mostrarcon_cuenta_tipo_clienteParametroFactuPrincipal) {
		this.mostrarcon_cuenta_tipo_clienteParametroFactuPrincipal= mostrarcon_cuenta_tipo_clienteParametroFactuPrincipal;
	}

	public Boolean getActivarcon_cuenta_tipo_clienteParametroFactuPrincipal() {
		return this.activarcon_cuenta_tipo_clienteParametroFactuPrincipal;
	}

	public void setActivarcon_cuenta_tipo_clienteParametroFactuPrincipal(Boolean activarcon_cuenta_tipo_clienteParametroFactuPrincipal) {
		this.activarcon_cuenta_tipo_clienteParametroFactuPrincipal= activarcon_cuenta_tipo_clienteParametroFactuPrincipal;
	}

	public Border setResaltarcon_cliente_impuestoParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_cliente_impuestoParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_cliente_impuestoParametroFactuPrincipal() {
		return this.resaltarcon_cliente_impuestoParametroFactuPrincipal;
	}

	public void setResaltarcon_cliente_impuestoParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_cliente_impuestoParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_cliente_impuestoParametroFactuPrincipal() {
		return this.mostrarcon_cliente_impuestoParametroFactuPrincipal;
	}

	public void setMostrarcon_cliente_impuestoParametroFactuPrincipal(Boolean mostrarcon_cliente_impuestoParametroFactuPrincipal) {
		this.mostrarcon_cliente_impuestoParametroFactuPrincipal= mostrarcon_cliente_impuestoParametroFactuPrincipal;
	}

	public Boolean getActivarcon_cliente_impuestoParametroFactuPrincipal() {
		return this.activarcon_cliente_impuestoParametroFactuPrincipal;
	}

	public void setActivarcon_cliente_impuestoParametroFactuPrincipal(Boolean activarcon_cliente_impuestoParametroFactuPrincipal) {
		this.activarcon_cliente_impuestoParametroFactuPrincipal= activarcon_cliente_impuestoParametroFactuPrincipal;
	}

	public Border setResaltarid_libro_contableParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarid_libro_contableParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_libro_contableParametroFactuPrincipal() {
		return this.resaltarid_libro_contableParametroFactuPrincipal;
	}

	public void setResaltarid_libro_contableParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarid_libro_contableParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarid_libro_contableParametroFactuPrincipal() {
		return this.mostrarid_libro_contableParametroFactuPrincipal;
	}

	public void setMostrarid_libro_contableParametroFactuPrincipal(Boolean mostrarid_libro_contableParametroFactuPrincipal) {
		this.mostrarid_libro_contableParametroFactuPrincipal= mostrarid_libro_contableParametroFactuPrincipal;
	}

	public Boolean getActivarid_libro_contableParametroFactuPrincipal() {
		return this.activarid_libro_contableParametroFactuPrincipal;
	}

	public void setActivarid_libro_contableParametroFactuPrincipal(Boolean activarid_libro_contableParametroFactuPrincipal) {
		this.activarid_libro_contableParametroFactuPrincipal= activarid_libro_contableParametroFactuPrincipal;
	}

	public Boolean getCargarid_libro_contableParametroFactuPrincipal() {
		return this.cargarid_libro_contableParametroFactuPrincipal;
	}

	public void setCargarid_libro_contableParametroFactuPrincipal(Boolean cargarid_libro_contableParametroFactuPrincipal) {
		this.cargarid_libro_contableParametroFactuPrincipal= cargarid_libro_contableParametroFactuPrincipal;
	}

	public Border setResaltarid_monedaParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarid_monedaParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaParametroFactuPrincipal() {
		return this.resaltarid_monedaParametroFactuPrincipal;
	}

	public void setResaltarid_monedaParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarid_monedaParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarid_monedaParametroFactuPrincipal() {
		return this.mostrarid_monedaParametroFactuPrincipal;
	}

	public void setMostrarid_monedaParametroFactuPrincipal(Boolean mostrarid_monedaParametroFactuPrincipal) {
		this.mostrarid_monedaParametroFactuPrincipal= mostrarid_monedaParametroFactuPrincipal;
	}

	public Boolean getActivarid_monedaParametroFactuPrincipal() {
		return this.activarid_monedaParametroFactuPrincipal;
	}

	public void setActivarid_monedaParametroFactuPrincipal(Boolean activarid_monedaParametroFactuPrincipal) {
		this.activarid_monedaParametroFactuPrincipal= activarid_monedaParametroFactuPrincipal;
	}

	public Boolean getCargarid_monedaParametroFactuPrincipal() {
		return this.cargarid_monedaParametroFactuPrincipal;
	}

	public void setCargarid_monedaParametroFactuPrincipal(Boolean cargarid_monedaParametroFactuPrincipal) {
		this.cargarid_monedaParametroFactuPrincipal= cargarid_monedaParametroFactuPrincipal;
	}

	public Border setResaltarcon_impresionParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_impresionParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_impresionParametroFactuPrincipal() {
		return this.resaltarcon_impresionParametroFactuPrincipal;
	}

	public void setResaltarcon_impresionParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_impresionParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_impresionParametroFactuPrincipal() {
		return this.mostrarcon_impresionParametroFactuPrincipal;
	}

	public void setMostrarcon_impresionParametroFactuPrincipal(Boolean mostrarcon_impresionParametroFactuPrincipal) {
		this.mostrarcon_impresionParametroFactuPrincipal= mostrarcon_impresionParametroFactuPrincipal;
	}

	public Boolean getActivarcon_impresionParametroFactuPrincipal() {
		return this.activarcon_impresionParametroFactuPrincipal;
	}

	public void setActivarcon_impresionParametroFactuPrincipal(Boolean activarcon_impresionParametroFactuPrincipal) {
		this.activarcon_impresionParametroFactuPrincipal= activarcon_impresionParametroFactuPrincipal;
	}

	public Border setResaltarid_formatoParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarid_formatoParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoParametroFactuPrincipal() {
		return this.resaltarid_formatoParametroFactuPrincipal;
	}

	public void setResaltarid_formatoParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarid_formatoParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarid_formatoParametroFactuPrincipal() {
		return this.mostrarid_formatoParametroFactuPrincipal;
	}

	public void setMostrarid_formatoParametroFactuPrincipal(Boolean mostrarid_formatoParametroFactuPrincipal) {
		this.mostrarid_formatoParametroFactuPrincipal= mostrarid_formatoParametroFactuPrincipal;
	}

	public Boolean getActivarid_formatoParametroFactuPrincipal() {
		return this.activarid_formatoParametroFactuPrincipal;
	}

	public void setActivarid_formatoParametroFactuPrincipal(Boolean activarid_formatoParametroFactuPrincipal) {
		this.activarid_formatoParametroFactuPrincipal= activarid_formatoParametroFactuPrincipal;
	}

	public Boolean getCargarid_formatoParametroFactuPrincipal() {
		return this.cargarid_formatoParametroFactuPrincipal;
	}

	public void setCargarid_formatoParametroFactuPrincipal(Boolean cargarid_formatoParametroFactuPrincipal) {
		this.cargarid_formatoParametroFactuPrincipal= cargarid_formatoParametroFactuPrincipal;
	}

	public Border setResaltarcon_secuencial_usuarioParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_secuencial_usuarioParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_secuencial_usuarioParametroFactuPrincipal() {
		return this.resaltarcon_secuencial_usuarioParametroFactuPrincipal;
	}

	public void setResaltarcon_secuencial_usuarioParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_secuencial_usuarioParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_secuencial_usuarioParametroFactuPrincipal() {
		return this.mostrarcon_secuencial_usuarioParametroFactuPrincipal;
	}

	public void setMostrarcon_secuencial_usuarioParametroFactuPrincipal(Boolean mostrarcon_secuencial_usuarioParametroFactuPrincipal) {
		this.mostrarcon_secuencial_usuarioParametroFactuPrincipal= mostrarcon_secuencial_usuarioParametroFactuPrincipal;
	}

	public Boolean getActivarcon_secuencial_usuarioParametroFactuPrincipal() {
		return this.activarcon_secuencial_usuarioParametroFactuPrincipal;
	}

	public void setActivarcon_secuencial_usuarioParametroFactuPrincipal(Boolean activarcon_secuencial_usuarioParametroFactuPrincipal) {
		this.activarcon_secuencial_usuarioParametroFactuPrincipal= activarcon_secuencial_usuarioParametroFactuPrincipal;
	}

	public Border setResaltarcon_secuencial_editableParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_secuencial_editableParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_secuencial_editableParametroFactuPrincipal() {
		return this.resaltarcon_secuencial_editableParametroFactuPrincipal;
	}

	public void setResaltarcon_secuencial_editableParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_secuencial_editableParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_secuencial_editableParametroFactuPrincipal() {
		return this.mostrarcon_secuencial_editableParametroFactuPrincipal;
	}

	public void setMostrarcon_secuencial_editableParametroFactuPrincipal(Boolean mostrarcon_secuencial_editableParametroFactuPrincipal) {
		this.mostrarcon_secuencial_editableParametroFactuPrincipal= mostrarcon_secuencial_editableParametroFactuPrincipal;
	}

	public Boolean getActivarcon_secuencial_editableParametroFactuPrincipal() {
		return this.activarcon_secuencial_editableParametroFactuPrincipal;
	}

	public void setActivarcon_secuencial_editableParametroFactuPrincipal(Boolean activarcon_secuencial_editableParametroFactuPrincipal) {
		this.activarcon_secuencial_editableParametroFactuPrincipal= activarcon_secuencial_editableParametroFactuPrincipal;
	}

	public Border setResaltarcon_precio_por_clienteParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_precio_por_clienteParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_precio_por_clienteParametroFactuPrincipal() {
		return this.resaltarcon_precio_por_clienteParametroFactuPrincipal;
	}

	public void setResaltarcon_precio_por_clienteParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_precio_por_clienteParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_precio_por_clienteParametroFactuPrincipal() {
		return this.mostrarcon_precio_por_clienteParametroFactuPrincipal;
	}

	public void setMostrarcon_precio_por_clienteParametroFactuPrincipal(Boolean mostrarcon_precio_por_clienteParametroFactuPrincipal) {
		this.mostrarcon_precio_por_clienteParametroFactuPrincipal= mostrarcon_precio_por_clienteParametroFactuPrincipal;
	}

	public Boolean getActivarcon_precio_por_clienteParametroFactuPrincipal() {
		return this.activarcon_precio_por_clienteParametroFactuPrincipal;
	}

	public void setActivarcon_precio_por_clienteParametroFactuPrincipal(Boolean activarcon_precio_por_clienteParametroFactuPrincipal) {
		this.activarcon_precio_por_clienteParametroFactuPrincipal= activarcon_precio_por_clienteParametroFactuPrincipal;
	}

	public Border setResaltarcon_modificar_precioParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_modificar_precioParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_modificar_precioParametroFactuPrincipal() {
		return this.resaltarcon_modificar_precioParametroFactuPrincipal;
	}

	public void setResaltarcon_modificar_precioParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_modificar_precioParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_modificar_precioParametroFactuPrincipal() {
		return this.mostrarcon_modificar_precioParametroFactuPrincipal;
	}

	public void setMostrarcon_modificar_precioParametroFactuPrincipal(Boolean mostrarcon_modificar_precioParametroFactuPrincipal) {
		this.mostrarcon_modificar_precioParametroFactuPrincipal= mostrarcon_modificar_precioParametroFactuPrincipal;
	}

	public Boolean getActivarcon_modificar_precioParametroFactuPrincipal() {
		return this.activarcon_modificar_precioParametroFactuPrincipal;
	}

	public void setActivarcon_modificar_precioParametroFactuPrincipal(Boolean activarcon_modificar_precioParametroFactuPrincipal) {
		this.activarcon_modificar_precioParametroFactuPrincipal= activarcon_modificar_precioParametroFactuPrincipal;
	}

	public Border setResaltarcon_modificar_servicioParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_modificar_servicioParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_modificar_servicioParametroFactuPrincipal() {
		return this.resaltarcon_modificar_servicioParametroFactuPrincipal;
	}

	public void setResaltarcon_modificar_servicioParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_modificar_servicioParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_modificar_servicioParametroFactuPrincipal() {
		return this.mostrarcon_modificar_servicioParametroFactuPrincipal;
	}

	public void setMostrarcon_modificar_servicioParametroFactuPrincipal(Boolean mostrarcon_modificar_servicioParametroFactuPrincipal) {
		this.mostrarcon_modificar_servicioParametroFactuPrincipal= mostrarcon_modificar_servicioParametroFactuPrincipal;
	}

	public Boolean getActivarcon_modificar_servicioParametroFactuPrincipal() {
		return this.activarcon_modificar_servicioParametroFactuPrincipal;
	}

	public void setActivarcon_modificar_servicioParametroFactuPrincipal(Boolean activarcon_modificar_servicioParametroFactuPrincipal) {
		this.activarcon_modificar_servicioParametroFactuPrincipal= activarcon_modificar_servicioParametroFactuPrincipal;
	}

	public Border setResaltarcon_cambiar_unidadParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_cambiar_unidadParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_cambiar_unidadParametroFactuPrincipal() {
		return this.resaltarcon_cambiar_unidadParametroFactuPrincipal;
	}

	public void setResaltarcon_cambiar_unidadParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_cambiar_unidadParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_cambiar_unidadParametroFactuPrincipal() {
		return this.mostrarcon_cambiar_unidadParametroFactuPrincipal;
	}

	public void setMostrarcon_cambiar_unidadParametroFactuPrincipal(Boolean mostrarcon_cambiar_unidadParametroFactuPrincipal) {
		this.mostrarcon_cambiar_unidadParametroFactuPrincipal= mostrarcon_cambiar_unidadParametroFactuPrincipal;
	}

	public Boolean getActivarcon_cambiar_unidadParametroFactuPrincipal() {
		return this.activarcon_cambiar_unidadParametroFactuPrincipal;
	}

	public void setActivarcon_cambiar_unidadParametroFactuPrincipal(Boolean activarcon_cambiar_unidadParametroFactuPrincipal) {
		this.activarcon_cambiar_unidadParametroFactuPrincipal= activarcon_cambiar_unidadParametroFactuPrincipal;
	}

	public Border setResaltarnumero_decimales_unidadParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarnumero_decimales_unidadParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_decimales_unidadParametroFactuPrincipal() {
		return this.resaltarnumero_decimales_unidadParametroFactuPrincipal;
	}

	public void setResaltarnumero_decimales_unidadParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarnumero_decimales_unidadParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarnumero_decimales_unidadParametroFactuPrincipal() {
		return this.mostrarnumero_decimales_unidadParametroFactuPrincipal;
	}

	public void setMostrarnumero_decimales_unidadParametroFactuPrincipal(Boolean mostrarnumero_decimales_unidadParametroFactuPrincipal) {
		this.mostrarnumero_decimales_unidadParametroFactuPrincipal= mostrarnumero_decimales_unidadParametroFactuPrincipal;
	}

	public Boolean getActivarnumero_decimales_unidadParametroFactuPrincipal() {
		return this.activarnumero_decimales_unidadParametroFactuPrincipal;
	}

	public void setActivarnumero_decimales_unidadParametroFactuPrincipal(Boolean activarnumero_decimales_unidadParametroFactuPrincipal) {
		this.activarnumero_decimales_unidadParametroFactuPrincipal= activarnumero_decimales_unidadParametroFactuPrincipal;
	}

	public Border setResaltarcon_activar_serieParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_activar_serieParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_activar_serieParametroFactuPrincipal() {
		return this.resaltarcon_activar_serieParametroFactuPrincipal;
	}

	public void setResaltarcon_activar_serieParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_activar_serieParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_activar_serieParametroFactuPrincipal() {
		return this.mostrarcon_activar_serieParametroFactuPrincipal;
	}

	public void setMostrarcon_activar_serieParametroFactuPrincipal(Boolean mostrarcon_activar_serieParametroFactuPrincipal) {
		this.mostrarcon_activar_serieParametroFactuPrincipal= mostrarcon_activar_serieParametroFactuPrincipal;
	}

	public Boolean getActivarcon_activar_serieParametroFactuPrincipal() {
		return this.activarcon_activar_serieParametroFactuPrincipal;
	}

	public void setActivarcon_activar_serieParametroFactuPrincipal(Boolean activarcon_activar_serieParametroFactuPrincipal) {
		this.activarcon_activar_serieParametroFactuPrincipal= activarcon_activar_serieParametroFactuPrincipal;
	}

	public Border setResaltarcon_activar_loteParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_activar_loteParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_activar_loteParametroFactuPrincipal() {
		return this.resaltarcon_activar_loteParametroFactuPrincipal;
	}

	public void setResaltarcon_activar_loteParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_activar_loteParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_activar_loteParametroFactuPrincipal() {
		return this.mostrarcon_activar_loteParametroFactuPrincipal;
	}

	public void setMostrarcon_activar_loteParametroFactuPrincipal(Boolean mostrarcon_activar_loteParametroFactuPrincipal) {
		this.mostrarcon_activar_loteParametroFactuPrincipal= mostrarcon_activar_loteParametroFactuPrincipal;
	}

	public Boolean getActivarcon_activar_loteParametroFactuPrincipal() {
		return this.activarcon_activar_loteParametroFactuPrincipal;
	}

	public void setActivarcon_activar_loteParametroFactuPrincipal(Boolean activarcon_activar_loteParametroFactuPrincipal) {
		this.activarcon_activar_loteParametroFactuPrincipal= activarcon_activar_loteParametroFactuPrincipal;
	}

	public Border setResaltarcon_activar_multi_empresaParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_activar_multi_empresaParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_activar_multi_empresaParametroFactuPrincipal() {
		return this.resaltarcon_activar_multi_empresaParametroFactuPrincipal;
	}

	public void setResaltarcon_activar_multi_empresaParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_activar_multi_empresaParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_activar_multi_empresaParametroFactuPrincipal() {
		return this.mostrarcon_activar_multi_empresaParametroFactuPrincipal;
	}

	public void setMostrarcon_activar_multi_empresaParametroFactuPrincipal(Boolean mostrarcon_activar_multi_empresaParametroFactuPrincipal) {
		this.mostrarcon_activar_multi_empresaParametroFactuPrincipal= mostrarcon_activar_multi_empresaParametroFactuPrincipal;
	}

	public Boolean getActivarcon_activar_multi_empresaParametroFactuPrincipal() {
		return this.activarcon_activar_multi_empresaParametroFactuPrincipal;
	}

	public void setActivarcon_activar_multi_empresaParametroFactuPrincipal(Boolean activarcon_activar_multi_empresaParametroFactuPrincipal) {
		this.activarcon_activar_multi_empresaParametroFactuPrincipal= activarcon_activar_multi_empresaParametroFactuPrincipal;
	}

	public Border setResaltarcon_centro_costosParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_centro_costosParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_centro_costosParametroFactuPrincipal() {
		return this.resaltarcon_centro_costosParametroFactuPrincipal;
	}

	public void setResaltarcon_centro_costosParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_centro_costosParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_centro_costosParametroFactuPrincipal() {
		return this.mostrarcon_centro_costosParametroFactuPrincipal;
	}

	public void setMostrarcon_centro_costosParametroFactuPrincipal(Boolean mostrarcon_centro_costosParametroFactuPrincipal) {
		this.mostrarcon_centro_costosParametroFactuPrincipal= mostrarcon_centro_costosParametroFactuPrincipal;
	}

	public Boolean getActivarcon_centro_costosParametroFactuPrincipal() {
		return this.activarcon_centro_costosParametroFactuPrincipal;
	}

	public void setActivarcon_centro_costosParametroFactuPrincipal(Boolean activarcon_centro_costosParametroFactuPrincipal) {
		this.activarcon_centro_costosParametroFactuPrincipal= activarcon_centro_costosParametroFactuPrincipal;
	}

	public Border setResaltarcon_unidadesParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_unidadesParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_unidadesParametroFactuPrincipal() {
		return this.resaltarcon_unidadesParametroFactuPrincipal;
	}

	public void setResaltarcon_unidadesParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_unidadesParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_unidadesParametroFactuPrincipal() {
		return this.mostrarcon_unidadesParametroFactuPrincipal;
	}

	public void setMostrarcon_unidadesParametroFactuPrincipal(Boolean mostrarcon_unidadesParametroFactuPrincipal) {
		this.mostrarcon_unidadesParametroFactuPrincipal= mostrarcon_unidadesParametroFactuPrincipal;
	}

	public Boolean getActivarcon_unidadesParametroFactuPrincipal() {
		return this.activarcon_unidadesParametroFactuPrincipal;
	}

	public void setActivarcon_unidadesParametroFactuPrincipal(Boolean activarcon_unidadesParametroFactuPrincipal) {
		this.activarcon_unidadesParametroFactuPrincipal= activarcon_unidadesParametroFactuPrincipal;
	}

	public Border setResaltarcon_cupo_disponibleParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_cupo_disponibleParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_cupo_disponibleParametroFactuPrincipal() {
		return this.resaltarcon_cupo_disponibleParametroFactuPrincipal;
	}

	public void setResaltarcon_cupo_disponibleParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_cupo_disponibleParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_cupo_disponibleParametroFactuPrincipal() {
		return this.mostrarcon_cupo_disponibleParametroFactuPrincipal;
	}

	public void setMostrarcon_cupo_disponibleParametroFactuPrincipal(Boolean mostrarcon_cupo_disponibleParametroFactuPrincipal) {
		this.mostrarcon_cupo_disponibleParametroFactuPrincipal= mostrarcon_cupo_disponibleParametroFactuPrincipal;
	}

	public Boolean getActivarcon_cupo_disponibleParametroFactuPrincipal() {
		return this.activarcon_cupo_disponibleParametroFactuPrincipal;
	}

	public void setActivarcon_cupo_disponibleParametroFactuPrincipal(Boolean activarcon_cupo_disponibleParametroFactuPrincipal) {
		this.activarcon_cupo_disponibleParametroFactuPrincipal= activarcon_cupo_disponibleParametroFactuPrincipal;
	}

	public Border setResaltarcon_forma_pagoParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_forma_pagoParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_forma_pagoParametroFactuPrincipal() {
		return this.resaltarcon_forma_pagoParametroFactuPrincipal;
	}

	public void setResaltarcon_forma_pagoParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_forma_pagoParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_forma_pagoParametroFactuPrincipal() {
		return this.mostrarcon_forma_pagoParametroFactuPrincipal;
	}

	public void setMostrarcon_forma_pagoParametroFactuPrincipal(Boolean mostrarcon_forma_pagoParametroFactuPrincipal) {
		this.mostrarcon_forma_pagoParametroFactuPrincipal= mostrarcon_forma_pagoParametroFactuPrincipal;
	}

	public Boolean getActivarcon_forma_pagoParametroFactuPrincipal() {
		return this.activarcon_forma_pagoParametroFactuPrincipal;
	}

	public void setActivarcon_forma_pagoParametroFactuPrincipal(Boolean activarcon_forma_pagoParametroFactuPrincipal) {
		this.activarcon_forma_pagoParametroFactuPrincipal= activarcon_forma_pagoParametroFactuPrincipal;
	}

	public Border setResaltarcon_envio_mailParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_envio_mailParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_envio_mailParametroFactuPrincipal() {
		return this.resaltarcon_envio_mailParametroFactuPrincipal;
	}

	public void setResaltarcon_envio_mailParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_envio_mailParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_envio_mailParametroFactuPrincipal() {
		return this.mostrarcon_envio_mailParametroFactuPrincipal;
	}

	public void setMostrarcon_envio_mailParametroFactuPrincipal(Boolean mostrarcon_envio_mailParametroFactuPrincipal) {
		this.mostrarcon_envio_mailParametroFactuPrincipal= mostrarcon_envio_mailParametroFactuPrincipal;
	}

	public Boolean getActivarcon_envio_mailParametroFactuPrincipal() {
		return this.activarcon_envio_mailParametroFactuPrincipal;
	}

	public void setActivarcon_envio_mailParametroFactuPrincipal(Boolean activarcon_envio_mailParametroFactuPrincipal) {
		this.activarcon_envio_mailParametroFactuPrincipal= activarcon_envio_mailParametroFactuPrincipal;
	}

	public Border setResaltarcon_autorizar_proformaParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_autorizar_proformaParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_autorizar_proformaParametroFactuPrincipal() {
		return this.resaltarcon_autorizar_proformaParametroFactuPrincipal;
	}

	public void setResaltarcon_autorizar_proformaParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_autorizar_proformaParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_autorizar_proformaParametroFactuPrincipal() {
		return this.mostrarcon_autorizar_proformaParametroFactuPrincipal;
	}

	public void setMostrarcon_autorizar_proformaParametroFactuPrincipal(Boolean mostrarcon_autorizar_proformaParametroFactuPrincipal) {
		this.mostrarcon_autorizar_proformaParametroFactuPrincipal= mostrarcon_autorizar_proformaParametroFactuPrincipal;
	}

	public Boolean getActivarcon_autorizar_proformaParametroFactuPrincipal() {
		return this.activarcon_autorizar_proformaParametroFactuPrincipal;
	}

	public void setActivarcon_autorizar_proformaParametroFactuPrincipal(Boolean activarcon_autorizar_proformaParametroFactuPrincipal) {
		this.activarcon_autorizar_proformaParametroFactuPrincipal= activarcon_autorizar_proformaParametroFactuPrincipal;
	}

	public Border setResaltarcon_bloqueo_pedidoParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_bloqueo_pedidoParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_bloqueo_pedidoParametroFactuPrincipal() {
		return this.resaltarcon_bloqueo_pedidoParametroFactuPrincipal;
	}

	public void setResaltarcon_bloqueo_pedidoParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_bloqueo_pedidoParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_bloqueo_pedidoParametroFactuPrincipal() {
		return this.mostrarcon_bloqueo_pedidoParametroFactuPrincipal;
	}

	public void setMostrarcon_bloqueo_pedidoParametroFactuPrincipal(Boolean mostrarcon_bloqueo_pedidoParametroFactuPrincipal) {
		this.mostrarcon_bloqueo_pedidoParametroFactuPrincipal= mostrarcon_bloqueo_pedidoParametroFactuPrincipal;
	}

	public Boolean getActivarcon_bloqueo_pedidoParametroFactuPrincipal() {
		return this.activarcon_bloqueo_pedidoParametroFactuPrincipal;
	}

	public void setActivarcon_bloqueo_pedidoParametroFactuPrincipal(Boolean activarcon_bloqueo_pedidoParametroFactuPrincipal) {
		this.activarcon_bloqueo_pedidoParametroFactuPrincipal= activarcon_bloqueo_pedidoParametroFactuPrincipal;
	}

	public Border setResaltarcon_control_anticipoParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_control_anticipoParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_control_anticipoParametroFactuPrincipal() {
		return this.resaltarcon_control_anticipoParametroFactuPrincipal;
	}

	public void setResaltarcon_control_anticipoParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_control_anticipoParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_control_anticipoParametroFactuPrincipal() {
		return this.mostrarcon_control_anticipoParametroFactuPrincipal;
	}

	public void setMostrarcon_control_anticipoParametroFactuPrincipal(Boolean mostrarcon_control_anticipoParametroFactuPrincipal) {
		this.mostrarcon_control_anticipoParametroFactuPrincipal= mostrarcon_control_anticipoParametroFactuPrincipal;
	}

	public Boolean getActivarcon_control_anticipoParametroFactuPrincipal() {
		return this.activarcon_control_anticipoParametroFactuPrincipal;
	}

	public void setActivarcon_control_anticipoParametroFactuPrincipal(Boolean activarcon_control_anticipoParametroFactuPrincipal) {
		this.activarcon_control_anticipoParametroFactuPrincipal= activarcon_control_anticipoParametroFactuPrincipal;
	}

	public Border setResaltarcon_factura_autoParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_factura_autoParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_factura_autoParametroFactuPrincipal() {
		return this.resaltarcon_factura_autoParametroFactuPrincipal;
	}

	public void setResaltarcon_factura_autoParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_factura_autoParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_factura_autoParametroFactuPrincipal() {
		return this.mostrarcon_factura_autoParametroFactuPrincipal;
	}

	public void setMostrarcon_factura_autoParametroFactuPrincipal(Boolean mostrarcon_factura_autoParametroFactuPrincipal) {
		this.mostrarcon_factura_autoParametroFactuPrincipal= mostrarcon_factura_autoParametroFactuPrincipal;
	}

	public Boolean getActivarcon_factura_autoParametroFactuPrincipal() {
		return this.activarcon_factura_autoParametroFactuPrincipal;
	}

	public void setActivarcon_factura_autoParametroFactuPrincipal(Boolean activarcon_factura_autoParametroFactuPrincipal) {
		this.activarcon_factura_autoParametroFactuPrincipal= activarcon_factura_autoParametroFactuPrincipal;
	}

	public Border setResaltarcon_grabar_valor_ceroParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_grabar_valor_ceroParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_grabar_valor_ceroParametroFactuPrincipal() {
		return this.resaltarcon_grabar_valor_ceroParametroFactuPrincipal;
	}

	public void setResaltarcon_grabar_valor_ceroParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_grabar_valor_ceroParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_grabar_valor_ceroParametroFactuPrincipal() {
		return this.mostrarcon_grabar_valor_ceroParametroFactuPrincipal;
	}

	public void setMostrarcon_grabar_valor_ceroParametroFactuPrincipal(Boolean mostrarcon_grabar_valor_ceroParametroFactuPrincipal) {
		this.mostrarcon_grabar_valor_ceroParametroFactuPrincipal= mostrarcon_grabar_valor_ceroParametroFactuPrincipal;
	}

	public Boolean getActivarcon_grabar_valor_ceroParametroFactuPrincipal() {
		return this.activarcon_grabar_valor_ceroParametroFactuPrincipal;
	}

	public void setActivarcon_grabar_valor_ceroParametroFactuPrincipal(Boolean activarcon_grabar_valor_ceroParametroFactuPrincipal) {
		this.activarcon_grabar_valor_ceroParametroFactuPrincipal= activarcon_grabar_valor_ceroParametroFactuPrincipal;
	}

	public Border setResaltarcon_agregar_itemParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_agregar_itemParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_agregar_itemParametroFactuPrincipal() {
		return this.resaltarcon_agregar_itemParametroFactuPrincipal;
	}

	public void setResaltarcon_agregar_itemParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_agregar_itemParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_agregar_itemParametroFactuPrincipal() {
		return this.mostrarcon_agregar_itemParametroFactuPrincipal;
	}

	public void setMostrarcon_agregar_itemParametroFactuPrincipal(Boolean mostrarcon_agregar_itemParametroFactuPrincipal) {
		this.mostrarcon_agregar_itemParametroFactuPrincipal= mostrarcon_agregar_itemParametroFactuPrincipal;
	}

	public Boolean getActivarcon_agregar_itemParametroFactuPrincipal() {
		return this.activarcon_agregar_itemParametroFactuPrincipal;
	}

	public void setActivarcon_agregar_itemParametroFactuPrincipal(Boolean activarcon_agregar_itemParametroFactuPrincipal) {
		this.activarcon_agregar_itemParametroFactuPrincipal= activarcon_agregar_itemParametroFactuPrincipal;
	}

	public Border setResaltarnumero_copiasParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarnumero_copiasParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_copiasParametroFactuPrincipal() {
		return this.resaltarnumero_copiasParametroFactuPrincipal;
	}

	public void setResaltarnumero_copiasParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarnumero_copiasParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarnumero_copiasParametroFactuPrincipal() {
		return this.mostrarnumero_copiasParametroFactuPrincipal;
	}

	public void setMostrarnumero_copiasParametroFactuPrincipal(Boolean mostrarnumero_copiasParametroFactuPrincipal) {
		this.mostrarnumero_copiasParametroFactuPrincipal= mostrarnumero_copiasParametroFactuPrincipal;
	}

	public Boolean getActivarnumero_copiasParametroFactuPrincipal() {
		return this.activarnumero_copiasParametroFactuPrincipal;
	}

	public void setActivarnumero_copiasParametroFactuPrincipal(Boolean activarnumero_copiasParametroFactuPrincipal) {
		this.activarnumero_copiasParametroFactuPrincipal= activarnumero_copiasParametroFactuPrincipal;
	}

	public Border setResaltarleyendaParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarleyendaParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarleyendaParametroFactuPrincipal() {
		return this.resaltarleyendaParametroFactuPrincipal;
	}

	public void setResaltarleyendaParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarleyendaParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarleyendaParametroFactuPrincipal() {
		return this.mostrarleyendaParametroFactuPrincipal;
	}

	public void setMostrarleyendaParametroFactuPrincipal(Boolean mostrarleyendaParametroFactuPrincipal) {
		this.mostrarleyendaParametroFactuPrincipal= mostrarleyendaParametroFactuPrincipal;
	}

	public Boolean getActivarleyendaParametroFactuPrincipal() {
		return this.activarleyendaParametroFactuPrincipal;
	}

	public void setActivarleyendaParametroFactuPrincipal(Boolean activarleyendaParametroFactuPrincipal) {
		this.activarleyendaParametroFactuPrincipal= activarleyendaParametroFactuPrincipal;
	}

	public Border setResaltarcon_sin_facturaParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarcon_sin_facturaParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_sin_facturaParametroFactuPrincipal() {
		return this.resaltarcon_sin_facturaParametroFactuPrincipal;
	}

	public void setResaltarcon_sin_facturaParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarcon_sin_facturaParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarcon_sin_facturaParametroFactuPrincipal() {
		return this.mostrarcon_sin_facturaParametroFactuPrincipal;
	}

	public void setMostrarcon_sin_facturaParametroFactuPrincipal(Boolean mostrarcon_sin_facturaParametroFactuPrincipal) {
		this.mostrarcon_sin_facturaParametroFactuPrincipal= mostrarcon_sin_facturaParametroFactuPrincipal;
	}

	public Boolean getActivarcon_sin_facturaParametroFactuPrincipal() {
		return this.activarcon_sin_facturaParametroFactuPrincipal;
	}

	public void setActivarcon_sin_facturaParametroFactuPrincipal(Boolean activarcon_sin_facturaParametroFactuPrincipal) {
		this.activarcon_sin_facturaParametroFactuPrincipal= activarcon_sin_facturaParametroFactuPrincipal;
	}

	public Border setResaltarid_cuenta_contable_flete_ventaParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_flete_ventaParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_flete_ventaParametroFactuPrincipal() {
		return this.resaltarid_cuenta_contable_flete_ventaParametroFactuPrincipal;
	}

	public void setResaltarid_cuenta_contable_flete_ventaParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarid_cuenta_contable_flete_ventaParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_flete_ventaParametroFactuPrincipal() {
		return this.mostrarid_cuenta_contable_flete_ventaParametroFactuPrincipal;
	}

	public void setMostrarid_cuenta_contable_flete_ventaParametroFactuPrincipal(Boolean mostrarid_cuenta_contable_flete_ventaParametroFactuPrincipal) {
		this.mostrarid_cuenta_contable_flete_ventaParametroFactuPrincipal= mostrarid_cuenta_contable_flete_ventaParametroFactuPrincipal;
	}

	public Boolean getActivarid_cuenta_contable_flete_ventaParametroFactuPrincipal() {
		return this.activarid_cuenta_contable_flete_ventaParametroFactuPrincipal;
	}

	public void setActivarid_cuenta_contable_flete_ventaParametroFactuPrincipal(Boolean activarid_cuenta_contable_flete_ventaParametroFactuPrincipal) {
		this.activarid_cuenta_contable_flete_ventaParametroFactuPrincipal= activarid_cuenta_contable_flete_ventaParametroFactuPrincipal;
	}

	public Boolean getCargarid_cuenta_contable_flete_ventaParametroFactuPrincipal() {
		return this.cargarid_cuenta_contable_flete_ventaParametroFactuPrincipal;
	}

	public void setCargarid_cuenta_contable_flete_ventaParametroFactuPrincipal(Boolean cargarid_cuenta_contable_flete_ventaParametroFactuPrincipal) {
		this.cargarid_cuenta_contable_flete_ventaParametroFactuPrincipal= cargarid_cuenta_contable_flete_ventaParametroFactuPrincipal;
	}

	public Border setResaltarid_cuenta_contable_otro_cargoParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_otro_cargoParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_otro_cargoParametroFactuPrincipal() {
		return this.resaltarid_cuenta_contable_otro_cargoParametroFactuPrincipal;
	}

	public void setResaltarid_cuenta_contable_otro_cargoParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarid_cuenta_contable_otro_cargoParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_otro_cargoParametroFactuPrincipal() {
		return this.mostrarid_cuenta_contable_otro_cargoParametroFactuPrincipal;
	}

	public void setMostrarid_cuenta_contable_otro_cargoParametroFactuPrincipal(Boolean mostrarid_cuenta_contable_otro_cargoParametroFactuPrincipal) {
		this.mostrarid_cuenta_contable_otro_cargoParametroFactuPrincipal= mostrarid_cuenta_contable_otro_cargoParametroFactuPrincipal;
	}

	public Boolean getActivarid_cuenta_contable_otro_cargoParametroFactuPrincipal() {
		return this.activarid_cuenta_contable_otro_cargoParametroFactuPrincipal;
	}

	public void setActivarid_cuenta_contable_otro_cargoParametroFactuPrincipal(Boolean activarid_cuenta_contable_otro_cargoParametroFactuPrincipal) {
		this.activarid_cuenta_contable_otro_cargoParametroFactuPrincipal= activarid_cuenta_contable_otro_cargoParametroFactuPrincipal;
	}

	public Boolean getCargarid_cuenta_contable_otro_cargoParametroFactuPrincipal() {
		return this.cargarid_cuenta_contable_otro_cargoParametroFactuPrincipal;
	}

	public void setCargarid_cuenta_contable_otro_cargoParametroFactuPrincipal(Boolean cargarid_cuenta_contable_otro_cargoParametroFactuPrincipal) {
		this.cargarid_cuenta_contable_otro_cargoParametroFactuPrincipal= cargarid_cuenta_contable_otro_cargoParametroFactuPrincipal;
	}

	public Border setResaltarid_cuenta_contable_finanParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_finanParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_finanParametroFactuPrincipal() {
		return this.resaltarid_cuenta_contable_finanParametroFactuPrincipal;
	}

	public void setResaltarid_cuenta_contable_finanParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarid_cuenta_contable_finanParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_finanParametroFactuPrincipal() {
		return this.mostrarid_cuenta_contable_finanParametroFactuPrincipal;
	}

	public void setMostrarid_cuenta_contable_finanParametroFactuPrincipal(Boolean mostrarid_cuenta_contable_finanParametroFactuPrincipal) {
		this.mostrarid_cuenta_contable_finanParametroFactuPrincipal= mostrarid_cuenta_contable_finanParametroFactuPrincipal;
	}

	public Boolean getActivarid_cuenta_contable_finanParametroFactuPrincipal() {
		return this.activarid_cuenta_contable_finanParametroFactuPrincipal;
	}

	public void setActivarid_cuenta_contable_finanParametroFactuPrincipal(Boolean activarid_cuenta_contable_finanParametroFactuPrincipal) {
		this.activarid_cuenta_contable_finanParametroFactuPrincipal= activarid_cuenta_contable_finanParametroFactuPrincipal;
	}

	public Boolean getCargarid_cuenta_contable_finanParametroFactuPrincipal() {
		return this.cargarid_cuenta_contable_finanParametroFactuPrincipal;
	}

	public void setCargarid_cuenta_contable_finanParametroFactuPrincipal(Boolean cargarid_cuenta_contable_finanParametroFactuPrincipal) {
		this.cargarid_cuenta_contable_finanParametroFactuPrincipal= cargarid_cuenta_contable_finanParametroFactuPrincipal;
	}

	public Border setResaltarid_cuenta_contable_boniParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_boniParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_boniParametroFactuPrincipal() {
		return this.resaltarid_cuenta_contable_boniParametroFactuPrincipal;
	}

	public void setResaltarid_cuenta_contable_boniParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarid_cuenta_contable_boniParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_boniParametroFactuPrincipal() {
		return this.mostrarid_cuenta_contable_boniParametroFactuPrincipal;
	}

	public void setMostrarid_cuenta_contable_boniParametroFactuPrincipal(Boolean mostrarid_cuenta_contable_boniParametroFactuPrincipal) {
		this.mostrarid_cuenta_contable_boniParametroFactuPrincipal= mostrarid_cuenta_contable_boniParametroFactuPrincipal;
	}

	public Boolean getActivarid_cuenta_contable_boniParametroFactuPrincipal() {
		return this.activarid_cuenta_contable_boniParametroFactuPrincipal;
	}

	public void setActivarid_cuenta_contable_boniParametroFactuPrincipal(Boolean activarid_cuenta_contable_boniParametroFactuPrincipal) {
		this.activarid_cuenta_contable_boniParametroFactuPrincipal= activarid_cuenta_contable_boniParametroFactuPrincipal;
	}

	public Boolean getCargarid_cuenta_contable_boniParametroFactuPrincipal() {
		return this.cargarid_cuenta_contable_boniParametroFactuPrincipal;
	}

	public void setCargarid_cuenta_contable_boniParametroFactuPrincipal(Boolean cargarid_cuenta_contable_boniParametroFactuPrincipal) {
		this.cargarid_cuenta_contable_boniParametroFactuPrincipal= cargarid_cuenta_contable_boniParametroFactuPrincipal;
	}

	public Border setResaltarid_cuenta_contable_boni_devolParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_boni_devolParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_boni_devolParametroFactuPrincipal() {
		return this.resaltarid_cuenta_contable_boni_devolParametroFactuPrincipal;
	}

	public void setResaltarid_cuenta_contable_boni_devolParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarid_cuenta_contable_boni_devolParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_boni_devolParametroFactuPrincipal() {
		return this.mostrarid_cuenta_contable_boni_devolParametroFactuPrincipal;
	}

	public void setMostrarid_cuenta_contable_boni_devolParametroFactuPrincipal(Boolean mostrarid_cuenta_contable_boni_devolParametroFactuPrincipal) {
		this.mostrarid_cuenta_contable_boni_devolParametroFactuPrincipal= mostrarid_cuenta_contable_boni_devolParametroFactuPrincipal;
	}

	public Boolean getActivarid_cuenta_contable_boni_devolParametroFactuPrincipal() {
		return this.activarid_cuenta_contable_boni_devolParametroFactuPrincipal;
	}

	public void setActivarid_cuenta_contable_boni_devolParametroFactuPrincipal(Boolean activarid_cuenta_contable_boni_devolParametroFactuPrincipal) {
		this.activarid_cuenta_contable_boni_devolParametroFactuPrincipal= activarid_cuenta_contable_boni_devolParametroFactuPrincipal;
	}

	public Boolean getCargarid_cuenta_contable_boni_devolParametroFactuPrincipal() {
		return this.cargarid_cuenta_contable_boni_devolParametroFactuPrincipal;
	}

	public void setCargarid_cuenta_contable_boni_devolParametroFactuPrincipal(Boolean cargarid_cuenta_contable_boni_devolParametroFactuPrincipal) {
		this.cargarid_cuenta_contable_boni_devolParametroFactuPrincipal= cargarid_cuenta_contable_boni_devolParametroFactuPrincipal;
	}

	public Border setResaltarid_cuenta_contable_iceParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuprincipalBeanSwingJInternalFrame.jTtoolBarParametroFactuPrincipal.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_iceParametroFactuPrincipal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_iceParametroFactuPrincipal() {
		return this.resaltarid_cuenta_contable_iceParametroFactuPrincipal;
	}

	public void setResaltarid_cuenta_contable_iceParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarid_cuenta_contable_iceParametroFactuPrincipal= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_iceParametroFactuPrincipal() {
		return this.mostrarid_cuenta_contable_iceParametroFactuPrincipal;
	}

	public void setMostrarid_cuenta_contable_iceParametroFactuPrincipal(Boolean mostrarid_cuenta_contable_iceParametroFactuPrincipal) {
		this.mostrarid_cuenta_contable_iceParametroFactuPrincipal= mostrarid_cuenta_contable_iceParametroFactuPrincipal;
	}

	public Boolean getActivarid_cuenta_contable_iceParametroFactuPrincipal() {
		return this.activarid_cuenta_contable_iceParametroFactuPrincipal;
	}

	public void setActivarid_cuenta_contable_iceParametroFactuPrincipal(Boolean activarid_cuenta_contable_iceParametroFactuPrincipal) {
		this.activarid_cuenta_contable_iceParametroFactuPrincipal= activarid_cuenta_contable_iceParametroFactuPrincipal;
	}

	public Boolean getCargarid_cuenta_contable_iceParametroFactuPrincipal() {
		return this.cargarid_cuenta_contable_iceParametroFactuPrincipal;
	}

	public void setCargarid_cuenta_contable_iceParametroFactuPrincipal(Boolean cargarid_cuenta_contable_iceParametroFactuPrincipal) {
		this.cargarid_cuenta_contable_iceParametroFactuPrincipal= cargarid_cuenta_contable_iceParametroFactuPrincipal;
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
		
		
		this.setMostraridParametroFactuPrincipal(esInicial);
		this.setMostrarid_empresaParametroFactuPrincipal(esInicial);
		this.setMostrarid_sucursalParametroFactuPrincipal(esInicial);
		this.setMostrarid_tipo_param_factu_descuentoParametroFactuPrincipal(esInicial);
		this.setMostrarid_tipo_param_factu_listado_clienteParametroFactuPrincipal(esInicial);
		this.setMostrarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal(esInicial);
		this.setMostrarid_tipo_documento_facturaParametroFactuPrincipal(esInicial);
		this.setMostrarid_tipo_documento_nota_creditoParametroFactuPrincipal(esInicial);
		this.setMostrarid_tipo_documento_nota_debitoParametroFactuPrincipal(esInicial);
		this.setMostraren_lineaParametroFactuPrincipal(esInicial);
		this.setMostrarcon_cuenta_tipo_clienteParametroFactuPrincipal(esInicial);
		this.setMostrarcon_cliente_impuestoParametroFactuPrincipal(esInicial);
		this.setMostrarid_libro_contableParametroFactuPrincipal(esInicial);
		this.setMostrarid_monedaParametroFactuPrincipal(esInicial);
		this.setMostrarcon_impresionParametroFactuPrincipal(esInicial);
		this.setMostrarid_formatoParametroFactuPrincipal(esInicial);
		this.setMostrarcon_secuencial_usuarioParametroFactuPrincipal(esInicial);
		this.setMostrarcon_secuencial_editableParametroFactuPrincipal(esInicial);
		this.setMostrarcon_precio_por_clienteParametroFactuPrincipal(esInicial);
		this.setMostrarcon_modificar_precioParametroFactuPrincipal(esInicial);
		this.setMostrarcon_modificar_servicioParametroFactuPrincipal(esInicial);
		this.setMostrarcon_cambiar_unidadParametroFactuPrincipal(esInicial);
		this.setMostrarnumero_decimales_unidadParametroFactuPrincipal(esInicial);
		this.setMostrarcon_activar_serieParametroFactuPrincipal(esInicial);
		this.setMostrarcon_activar_loteParametroFactuPrincipal(esInicial);
		this.setMostrarcon_activar_multi_empresaParametroFactuPrincipal(esInicial);
		this.setMostrarcon_centro_costosParametroFactuPrincipal(esInicial);
		this.setMostrarcon_unidadesParametroFactuPrincipal(esInicial);
		this.setMostrarcon_cupo_disponibleParametroFactuPrincipal(esInicial);
		this.setMostrarcon_forma_pagoParametroFactuPrincipal(esInicial);
		this.setMostrarcon_envio_mailParametroFactuPrincipal(esInicial);
		this.setMostrarcon_autorizar_proformaParametroFactuPrincipal(esInicial);
		this.setMostrarcon_bloqueo_pedidoParametroFactuPrincipal(esInicial);
		this.setMostrarcon_control_anticipoParametroFactuPrincipal(esInicial);
		this.setMostrarcon_factura_autoParametroFactuPrincipal(esInicial);
		this.setMostrarcon_grabar_valor_ceroParametroFactuPrincipal(esInicial);
		this.setMostrarcon_agregar_itemParametroFactuPrincipal(esInicial);
		this.setMostrarnumero_copiasParametroFactuPrincipal(esInicial);
		this.setMostrarleyendaParametroFactuPrincipal(esInicial);
		this.setMostrarcon_sin_facturaParametroFactuPrincipal(esInicial);
		this.setMostrarid_cuenta_contable_flete_ventaParametroFactuPrincipal(esInicial);
		this.setMostrarid_cuenta_contable_otro_cargoParametroFactuPrincipal(esInicial);
		this.setMostrarid_cuenta_contable_finanParametroFactuPrincipal(esInicial);
		this.setMostrarid_cuenta_contable_boniParametroFactuPrincipal(esInicial);
		this.setMostrarid_cuenta_contable_boni_devolParametroFactuPrincipal(esInicial);
		this.setMostrarid_cuenta_contable_iceParametroFactuPrincipal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.ID)) {
				this.setMostraridParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUDESCUENTO)) {
				this.setMostrarid_tipo_param_factu_descuentoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTULISTADOCLIENTE)) {
				this.setMostrarid_tipo_param_factu_listado_clienteParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUSECUENCIATRABAJO)) {
				this.setMostrarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTOFACTURA)) {
				this.setMostrarid_tipo_documento_facturaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTACREDITO)) {
				this.setMostrarid_tipo_documento_nota_creditoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTADEBITO)) {
				this.setMostrarid_tipo_documento_nota_debitoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.ENLINEA)) {
				this.setMostraren_lineaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONCUENTATIPOCLIENTE)) {
				this.setMostrarcon_cuenta_tipo_clienteParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONCLIENTEIMPUESTO)) {
				this.setMostrarcon_cliente_impuestoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDLIBROCONTABLE)) {
				this.setMostrarid_libro_contableParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONIMPRESION)) {
				this.setMostrarcon_impresionParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONSECUENCIALUSUARIO)) {
				this.setMostrarcon_secuencial_usuarioParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONSECUENCIALEDITABLE)) {
				this.setMostrarcon_secuencial_editableParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONPRECIOPORCLIENTE)) {
				this.setMostrarcon_precio_por_clienteParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONMODIFICARPRECIO)) {
				this.setMostrarcon_modificar_precioParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONMODIFICARSERVICIO)) {
				this.setMostrarcon_modificar_servicioParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONCAMBIARUNIDAD)) {
				this.setMostrarcon_cambiar_unidadParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.NUMERODECIMALESUNIDAD)) {
				this.setMostrarnumero_decimales_unidadParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONACTIVARSERIE)) {
				this.setMostrarcon_activar_serieParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONACTIVARLOTE)) {
				this.setMostrarcon_activar_loteParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONACTIVARMULTIEMPRESA)) {
				this.setMostrarcon_activar_multi_empresaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONCENTROCOSTOS)) {
				this.setMostrarcon_centro_costosParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONUNIDADES)) {
				this.setMostrarcon_unidadesParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONCUPODISPONIBLE)) {
				this.setMostrarcon_cupo_disponibleParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONFORMAPAGO)) {
				this.setMostrarcon_forma_pagoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONENVIOMAIL)) {
				this.setMostrarcon_envio_mailParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONAUTORIZARPROFORMA)) {
				this.setMostrarcon_autorizar_proformaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONBLOQUEOPEDIDO)) {
				this.setMostrarcon_bloqueo_pedidoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONCONTROLANTICIPO)) {
				this.setMostrarcon_control_anticipoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONFACTURAAUTO)) {
				this.setMostrarcon_factura_autoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONGRABARVALORCERO)) {
				this.setMostrarcon_grabar_valor_ceroParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONAGREGARITEM)) {
				this.setMostrarcon_agregar_itemParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.NUMEROCOPIAS)) {
				this.setMostrarnumero_copiasParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.LEYENDA)) {
				this.setMostrarleyendaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONSINFACTURA)) {
				this.setMostrarcon_sin_facturaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFLETEVENTA)) {
				this.setMostrarid_cuenta_contable_flete_ventaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEOTROCARGO)) {
				this.setMostrarid_cuenta_contable_otro_cargoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFINAN)) {
				this.setMostrarid_cuenta_contable_finanParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONI)) {
				this.setMostrarid_cuenta_contable_boniParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONIDEVOL)) {
				this.setMostrarid_cuenta_contable_boni_devolParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEICE)) {
				this.setMostrarid_cuenta_contable_iceParametroFactuPrincipal(esAsigna);
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
		
		
		this.setActivaridParametroFactuPrincipal(esInicial);
		this.setActivarid_empresaParametroFactuPrincipal(esInicial);
		this.setActivarid_sucursalParametroFactuPrincipal(esInicial);
		this.setActivarid_tipo_param_factu_descuentoParametroFactuPrincipal(esInicial);
		this.setActivarid_tipo_param_factu_listado_clienteParametroFactuPrincipal(esInicial);
		this.setActivarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal(esInicial);
		this.setActivarid_tipo_documento_facturaParametroFactuPrincipal(esInicial);
		this.setActivarid_tipo_documento_nota_creditoParametroFactuPrincipal(esInicial);
		this.setActivarid_tipo_documento_nota_debitoParametroFactuPrincipal(esInicial);
		this.setActivaren_lineaParametroFactuPrincipal(esInicial);
		this.setActivarcon_cuenta_tipo_clienteParametroFactuPrincipal(esInicial);
		this.setActivarcon_cliente_impuestoParametroFactuPrincipal(esInicial);
		this.setActivarid_libro_contableParametroFactuPrincipal(esInicial);
		this.setActivarid_monedaParametroFactuPrincipal(esInicial);
		this.setActivarcon_impresionParametroFactuPrincipal(esInicial);
		this.setActivarid_formatoParametroFactuPrincipal(esInicial);
		this.setActivarcon_secuencial_usuarioParametroFactuPrincipal(esInicial);
		this.setActivarcon_secuencial_editableParametroFactuPrincipal(esInicial);
		this.setActivarcon_precio_por_clienteParametroFactuPrincipal(esInicial);
		this.setActivarcon_modificar_precioParametroFactuPrincipal(esInicial);
		this.setActivarcon_modificar_servicioParametroFactuPrincipal(esInicial);
		this.setActivarcon_cambiar_unidadParametroFactuPrincipal(esInicial);
		this.setActivarnumero_decimales_unidadParametroFactuPrincipal(esInicial);
		this.setActivarcon_activar_serieParametroFactuPrincipal(esInicial);
		this.setActivarcon_activar_loteParametroFactuPrincipal(esInicial);
		this.setActivarcon_activar_multi_empresaParametroFactuPrincipal(esInicial);
		this.setActivarcon_centro_costosParametroFactuPrincipal(esInicial);
		this.setActivarcon_unidadesParametroFactuPrincipal(esInicial);
		this.setActivarcon_cupo_disponibleParametroFactuPrincipal(esInicial);
		this.setActivarcon_forma_pagoParametroFactuPrincipal(esInicial);
		this.setActivarcon_envio_mailParametroFactuPrincipal(esInicial);
		this.setActivarcon_autorizar_proformaParametroFactuPrincipal(esInicial);
		this.setActivarcon_bloqueo_pedidoParametroFactuPrincipal(esInicial);
		this.setActivarcon_control_anticipoParametroFactuPrincipal(esInicial);
		this.setActivarcon_factura_autoParametroFactuPrincipal(esInicial);
		this.setActivarcon_grabar_valor_ceroParametroFactuPrincipal(esInicial);
		this.setActivarcon_agregar_itemParametroFactuPrincipal(esInicial);
		this.setActivarnumero_copiasParametroFactuPrincipal(esInicial);
		this.setActivarleyendaParametroFactuPrincipal(esInicial);
		this.setActivarcon_sin_facturaParametroFactuPrincipal(esInicial);
		this.setActivarid_cuenta_contable_flete_ventaParametroFactuPrincipal(esInicial);
		this.setActivarid_cuenta_contable_otro_cargoParametroFactuPrincipal(esInicial);
		this.setActivarid_cuenta_contable_finanParametroFactuPrincipal(esInicial);
		this.setActivarid_cuenta_contable_boniParametroFactuPrincipal(esInicial);
		this.setActivarid_cuenta_contable_boni_devolParametroFactuPrincipal(esInicial);
		this.setActivarid_cuenta_contable_iceParametroFactuPrincipal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.ID)) {
				this.setActivaridParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUDESCUENTO)) {
				this.setActivarid_tipo_param_factu_descuentoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTULISTADOCLIENTE)) {
				this.setActivarid_tipo_param_factu_listado_clienteParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUSECUENCIATRABAJO)) {
				this.setActivarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTOFACTURA)) {
				this.setActivarid_tipo_documento_facturaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTACREDITO)) {
				this.setActivarid_tipo_documento_nota_creditoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTADEBITO)) {
				this.setActivarid_tipo_documento_nota_debitoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.ENLINEA)) {
				this.setActivaren_lineaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONCUENTATIPOCLIENTE)) {
				this.setActivarcon_cuenta_tipo_clienteParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONCLIENTEIMPUESTO)) {
				this.setActivarcon_cliente_impuestoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDLIBROCONTABLE)) {
				this.setActivarid_libro_contableParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONIMPRESION)) {
				this.setActivarcon_impresionParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONSECUENCIALUSUARIO)) {
				this.setActivarcon_secuencial_usuarioParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONSECUENCIALEDITABLE)) {
				this.setActivarcon_secuencial_editableParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONPRECIOPORCLIENTE)) {
				this.setActivarcon_precio_por_clienteParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONMODIFICARPRECIO)) {
				this.setActivarcon_modificar_precioParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONMODIFICARSERVICIO)) {
				this.setActivarcon_modificar_servicioParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONCAMBIARUNIDAD)) {
				this.setActivarcon_cambiar_unidadParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.NUMERODECIMALESUNIDAD)) {
				this.setActivarnumero_decimales_unidadParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONACTIVARSERIE)) {
				this.setActivarcon_activar_serieParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONACTIVARLOTE)) {
				this.setActivarcon_activar_loteParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONACTIVARMULTIEMPRESA)) {
				this.setActivarcon_activar_multi_empresaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONCENTROCOSTOS)) {
				this.setActivarcon_centro_costosParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONUNIDADES)) {
				this.setActivarcon_unidadesParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONCUPODISPONIBLE)) {
				this.setActivarcon_cupo_disponibleParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONFORMAPAGO)) {
				this.setActivarcon_forma_pagoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONENVIOMAIL)) {
				this.setActivarcon_envio_mailParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONAUTORIZARPROFORMA)) {
				this.setActivarcon_autorizar_proformaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONBLOQUEOPEDIDO)) {
				this.setActivarcon_bloqueo_pedidoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONCONTROLANTICIPO)) {
				this.setActivarcon_control_anticipoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONFACTURAAUTO)) {
				this.setActivarcon_factura_autoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONGRABARVALORCERO)) {
				this.setActivarcon_grabar_valor_ceroParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONAGREGARITEM)) {
				this.setActivarcon_agregar_itemParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.NUMEROCOPIAS)) {
				this.setActivarnumero_copiasParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.LEYENDA)) {
				this.setActivarleyendaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONSINFACTURA)) {
				this.setActivarcon_sin_facturaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFLETEVENTA)) {
				this.setActivarid_cuenta_contable_flete_ventaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEOTROCARGO)) {
				this.setActivarid_cuenta_contable_otro_cargoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFINAN)) {
				this.setActivarid_cuenta_contable_finanParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONI)) {
				this.setActivarid_cuenta_contable_boniParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONIDEVOL)) {
				this.setActivarid_cuenta_contable_boni_devolParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEICE)) {
				this.setActivarid_cuenta_contable_iceParametroFactuPrincipal(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroFactuPrincipal(esInicial);
		this.setResaltarid_empresaParametroFactuPrincipal(esInicial);
		this.setResaltarid_sucursalParametroFactuPrincipal(esInicial);
		this.setResaltarid_tipo_param_factu_descuentoParametroFactuPrincipal(esInicial);
		this.setResaltarid_tipo_param_factu_listado_clienteParametroFactuPrincipal(esInicial);
		this.setResaltarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal(esInicial);
		this.setResaltarid_tipo_documento_facturaParametroFactuPrincipal(esInicial);
		this.setResaltarid_tipo_documento_nota_creditoParametroFactuPrincipal(esInicial);
		this.setResaltarid_tipo_documento_nota_debitoParametroFactuPrincipal(esInicial);
		this.setResaltaren_lineaParametroFactuPrincipal(esInicial);
		this.setResaltarcon_cuenta_tipo_clienteParametroFactuPrincipal(esInicial);
		this.setResaltarcon_cliente_impuestoParametroFactuPrincipal(esInicial);
		this.setResaltarid_libro_contableParametroFactuPrincipal(esInicial);
		this.setResaltarid_monedaParametroFactuPrincipal(esInicial);
		this.setResaltarcon_impresionParametroFactuPrincipal(esInicial);
		this.setResaltarid_formatoParametroFactuPrincipal(esInicial);
		this.setResaltarcon_secuencial_usuarioParametroFactuPrincipal(esInicial);
		this.setResaltarcon_secuencial_editableParametroFactuPrincipal(esInicial);
		this.setResaltarcon_precio_por_clienteParametroFactuPrincipal(esInicial);
		this.setResaltarcon_modificar_precioParametroFactuPrincipal(esInicial);
		this.setResaltarcon_modificar_servicioParametroFactuPrincipal(esInicial);
		this.setResaltarcon_cambiar_unidadParametroFactuPrincipal(esInicial);
		this.setResaltarnumero_decimales_unidadParametroFactuPrincipal(esInicial);
		this.setResaltarcon_activar_serieParametroFactuPrincipal(esInicial);
		this.setResaltarcon_activar_loteParametroFactuPrincipal(esInicial);
		this.setResaltarcon_activar_multi_empresaParametroFactuPrincipal(esInicial);
		this.setResaltarcon_centro_costosParametroFactuPrincipal(esInicial);
		this.setResaltarcon_unidadesParametroFactuPrincipal(esInicial);
		this.setResaltarcon_cupo_disponibleParametroFactuPrincipal(esInicial);
		this.setResaltarcon_forma_pagoParametroFactuPrincipal(esInicial);
		this.setResaltarcon_envio_mailParametroFactuPrincipal(esInicial);
		this.setResaltarcon_autorizar_proformaParametroFactuPrincipal(esInicial);
		this.setResaltarcon_bloqueo_pedidoParametroFactuPrincipal(esInicial);
		this.setResaltarcon_control_anticipoParametroFactuPrincipal(esInicial);
		this.setResaltarcon_factura_autoParametroFactuPrincipal(esInicial);
		this.setResaltarcon_grabar_valor_ceroParametroFactuPrincipal(esInicial);
		this.setResaltarcon_agregar_itemParametroFactuPrincipal(esInicial);
		this.setResaltarnumero_copiasParametroFactuPrincipal(esInicial);
		this.setResaltarleyendaParametroFactuPrincipal(esInicial);
		this.setResaltarcon_sin_facturaParametroFactuPrincipal(esInicial);
		this.setResaltarid_cuenta_contable_flete_ventaParametroFactuPrincipal(esInicial);
		this.setResaltarid_cuenta_contable_otro_cargoParametroFactuPrincipal(esInicial);
		this.setResaltarid_cuenta_contable_finanParametroFactuPrincipal(esInicial);
		this.setResaltarid_cuenta_contable_boniParametroFactuPrincipal(esInicial);
		this.setResaltarid_cuenta_contable_boni_devolParametroFactuPrincipal(esInicial);
		this.setResaltarid_cuenta_contable_iceParametroFactuPrincipal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.ID)) {
				this.setResaltaridParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUDESCUENTO)) {
				this.setResaltarid_tipo_param_factu_descuentoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTULISTADOCLIENTE)) {
				this.setResaltarid_tipo_param_factu_listado_clienteParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUSECUENCIATRABAJO)) {
				this.setResaltarid_tipo_param_factu_secuencia_trabajoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTOFACTURA)) {
				this.setResaltarid_tipo_documento_facturaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTACREDITO)) {
				this.setResaltarid_tipo_documento_nota_creditoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTADEBITO)) {
				this.setResaltarid_tipo_documento_nota_debitoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.ENLINEA)) {
				this.setResaltaren_lineaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONCUENTATIPOCLIENTE)) {
				this.setResaltarcon_cuenta_tipo_clienteParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONCLIENTEIMPUESTO)) {
				this.setResaltarcon_cliente_impuestoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDLIBROCONTABLE)) {
				this.setResaltarid_libro_contableParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONIMPRESION)) {
				this.setResaltarcon_impresionParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONSECUENCIALUSUARIO)) {
				this.setResaltarcon_secuencial_usuarioParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONSECUENCIALEDITABLE)) {
				this.setResaltarcon_secuencial_editableParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONPRECIOPORCLIENTE)) {
				this.setResaltarcon_precio_por_clienteParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONMODIFICARPRECIO)) {
				this.setResaltarcon_modificar_precioParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONMODIFICARSERVICIO)) {
				this.setResaltarcon_modificar_servicioParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONCAMBIARUNIDAD)) {
				this.setResaltarcon_cambiar_unidadParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.NUMERODECIMALESUNIDAD)) {
				this.setResaltarnumero_decimales_unidadParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONACTIVARSERIE)) {
				this.setResaltarcon_activar_serieParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONACTIVARLOTE)) {
				this.setResaltarcon_activar_loteParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONACTIVARMULTIEMPRESA)) {
				this.setResaltarcon_activar_multi_empresaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONCENTROCOSTOS)) {
				this.setResaltarcon_centro_costosParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONUNIDADES)) {
				this.setResaltarcon_unidadesParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONCUPODISPONIBLE)) {
				this.setResaltarcon_cupo_disponibleParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONFORMAPAGO)) {
				this.setResaltarcon_forma_pagoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONENVIOMAIL)) {
				this.setResaltarcon_envio_mailParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONAUTORIZARPROFORMA)) {
				this.setResaltarcon_autorizar_proformaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONBLOQUEOPEDIDO)) {
				this.setResaltarcon_bloqueo_pedidoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONCONTROLANTICIPO)) {
				this.setResaltarcon_control_anticipoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONFACTURAAUTO)) {
				this.setResaltarcon_factura_autoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONGRABARVALORCERO)) {
				this.setResaltarcon_grabar_valor_ceroParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONAGREGARITEM)) {
				this.setResaltarcon_agregar_itemParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.NUMEROCOPIAS)) {
				this.setResaltarnumero_copiasParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.LEYENDA)) {
				this.setResaltarleyendaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.CONSINFACTURA)) {
				this.setResaltarcon_sin_facturaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFLETEVENTA)) {
				this.setResaltarid_cuenta_contable_flete_ventaParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEOTROCARGO)) {
				this.setResaltarid_cuenta_contable_otro_cargoParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFINAN)) {
				this.setResaltarid_cuenta_contable_finanParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONI)) {
				this.setResaltarid_cuenta_contable_boniParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONIDEVOL)) {
				this.setResaltarid_cuenta_contable_boni_devolParametroFactuPrincipal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEICE)) {
				this.setResaltarid_cuenta_contable_iceParametroFactuPrincipal(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCuentaContableBoniParametroFactuPrincipal=true;

	public Boolean getMostrarFK_IdCuentaContableBoniParametroFactuPrincipal() {
		return this.mostrarFK_IdCuentaContableBoniParametroFactuPrincipal;
	}

	public void setMostrarFK_IdCuentaContableBoniParametroFactuPrincipal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableBoniParametroFactuPrincipal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableBoniDevolParametroFactuPrincipal=true;

	public Boolean getMostrarFK_IdCuentaContableBoniDevolParametroFactuPrincipal() {
		return this.mostrarFK_IdCuentaContableBoniDevolParametroFactuPrincipal;
	}

	public void setMostrarFK_IdCuentaContableBoniDevolParametroFactuPrincipal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableBoniDevolParametroFactuPrincipal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableFinanParametroFactuPrincipal=true;

	public Boolean getMostrarFK_IdCuentaContableFinanParametroFactuPrincipal() {
		return this.mostrarFK_IdCuentaContableFinanParametroFactuPrincipal;
	}

	public void setMostrarFK_IdCuentaContableFinanParametroFactuPrincipal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableFinanParametroFactuPrincipal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableFleteVentaParametroFactuPrincipal=true;

	public Boolean getMostrarFK_IdCuentaContableFleteVentaParametroFactuPrincipal() {
		return this.mostrarFK_IdCuentaContableFleteVentaParametroFactuPrincipal;
	}

	public void setMostrarFK_IdCuentaContableFleteVentaParametroFactuPrincipal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableFleteVentaParametroFactuPrincipal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableIceParametroFactuPrincipal=true;

	public Boolean getMostrarFK_IdCuentaContableIceParametroFactuPrincipal() {
		return this.mostrarFK_IdCuentaContableIceParametroFactuPrincipal;
	}

	public void setMostrarFK_IdCuentaContableIceParametroFactuPrincipal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableIceParametroFactuPrincipal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableOtroCargoParametroFactuPrincipal=true;

	public Boolean getMostrarFK_IdCuentaContableOtroCargoParametroFactuPrincipal() {
		return this.mostrarFK_IdCuentaContableOtroCargoParametroFactuPrincipal;
	}

	public void setMostrarFK_IdCuentaContableOtroCargoParametroFactuPrincipal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableOtroCargoParametroFactuPrincipal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaParametroFactuPrincipal=true;

	public Boolean getMostrarFK_IdEmpresaParametroFactuPrincipal() {
		return this.mostrarFK_IdEmpresaParametroFactuPrincipal;
	}

	public void setMostrarFK_IdEmpresaParametroFactuPrincipal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroFactuPrincipal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoParametroFactuPrincipal=true;

	public Boolean getMostrarFK_IdFormatoParametroFactuPrincipal() {
		return this.mostrarFK_IdFormatoParametroFactuPrincipal;
	}

	public void setMostrarFK_IdFormatoParametroFactuPrincipal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoParametroFactuPrincipal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLibroContableParametroFactuPrincipal=true;

	public Boolean getMostrarFK_IdLibroContableParametroFactuPrincipal() {
		return this.mostrarFK_IdLibroContableParametroFactuPrincipal;
	}

	public void setMostrarFK_IdLibroContableParametroFactuPrincipal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLibroContableParametroFactuPrincipal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMonedaParametroFactuPrincipal=true;

	public Boolean getMostrarFK_IdMonedaParametroFactuPrincipal() {
		return this.mostrarFK_IdMonedaParametroFactuPrincipal;
	}

	public void setMostrarFK_IdMonedaParametroFactuPrincipal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMonedaParametroFactuPrincipal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalParametroFactuPrincipal=true;

	public Boolean getMostrarFK_IdSucursalParametroFactuPrincipal() {
		return this.mostrarFK_IdSucursalParametroFactuPrincipal;
	}

	public void setMostrarFK_IdSucursalParametroFactuPrincipal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalParametroFactuPrincipal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDocumentoFacturaParametroFactuPrincipal=true;

	public Boolean getMostrarFK_IdTipoDocumentoFacturaParametroFactuPrincipal() {
		return this.mostrarFK_IdTipoDocumentoFacturaParametroFactuPrincipal;
	}

	public void setMostrarFK_IdTipoDocumentoFacturaParametroFactuPrincipal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDocumentoFacturaParametroFactuPrincipal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDocumentoNotaCreditoParametroFactuPrincipal=true;

	public Boolean getMostrarFK_IdTipoDocumentoNotaCreditoParametroFactuPrincipal() {
		return this.mostrarFK_IdTipoDocumentoNotaCreditoParametroFactuPrincipal;
	}

	public void setMostrarFK_IdTipoDocumentoNotaCreditoParametroFactuPrincipal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDocumentoNotaCreditoParametroFactuPrincipal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDocumentoNotaDebitoParametroFactuPrincipal=true;

	public Boolean getMostrarFK_IdTipoDocumentoNotaDebitoParametroFactuPrincipal() {
		return this.mostrarFK_IdTipoDocumentoNotaDebitoParametroFactuPrincipal;
	}

	public void setMostrarFK_IdTipoDocumentoNotaDebitoParametroFactuPrincipal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDocumentoNotaDebitoParametroFactuPrincipal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoParamFactuDescuentoParametroFactuPrincipal=true;

	public Boolean getMostrarFK_IdTipoParamFactuDescuentoParametroFactuPrincipal() {
		return this.mostrarFK_IdTipoParamFactuDescuentoParametroFactuPrincipal;
	}

	public void setMostrarFK_IdTipoParamFactuDescuentoParametroFactuPrincipal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoParamFactuDescuentoParametroFactuPrincipal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoParamFactuListadoClienteParametroFactuPrincipal=true;

	public Boolean getMostrarFK_IdTipoParamFactuListadoClienteParametroFactuPrincipal() {
		return this.mostrarFK_IdTipoParamFactuListadoClienteParametroFactuPrincipal;
	}

	public void setMostrarFK_IdTipoParamFactuListadoClienteParametroFactuPrincipal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoParamFactuListadoClienteParametroFactuPrincipal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoParamFactuSecuenciaTrabajoParametroFactuPrincipal=true;

	public Boolean getMostrarFK_IdTipoParamFactuSecuenciaTrabajoParametroFactuPrincipal() {
		return this.mostrarFK_IdTipoParamFactuSecuenciaTrabajoParametroFactuPrincipal;
	}

	public void setMostrarFK_IdTipoParamFactuSecuenciaTrabajoParametroFactuPrincipal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoParamFactuSecuenciaTrabajoParametroFactuPrincipal= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContableBoniParametroFactuPrincipal=true;

	public Boolean getActivarFK_IdCuentaContableBoniParametroFactuPrincipal() {
		return this.activarFK_IdCuentaContableBoniParametroFactuPrincipal;
	}

	public void setActivarFK_IdCuentaContableBoniParametroFactuPrincipal(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableBoniParametroFactuPrincipal= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableBoniDevolParametroFactuPrincipal=true;

	public Boolean getActivarFK_IdCuentaContableBoniDevolParametroFactuPrincipal() {
		return this.activarFK_IdCuentaContableBoniDevolParametroFactuPrincipal;
	}

	public void setActivarFK_IdCuentaContableBoniDevolParametroFactuPrincipal(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableBoniDevolParametroFactuPrincipal= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableFinanParametroFactuPrincipal=true;

	public Boolean getActivarFK_IdCuentaContableFinanParametroFactuPrincipal() {
		return this.activarFK_IdCuentaContableFinanParametroFactuPrincipal;
	}

	public void setActivarFK_IdCuentaContableFinanParametroFactuPrincipal(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableFinanParametroFactuPrincipal= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableFleteVentaParametroFactuPrincipal=true;

	public Boolean getActivarFK_IdCuentaContableFleteVentaParametroFactuPrincipal() {
		return this.activarFK_IdCuentaContableFleteVentaParametroFactuPrincipal;
	}

	public void setActivarFK_IdCuentaContableFleteVentaParametroFactuPrincipal(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableFleteVentaParametroFactuPrincipal= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableIceParametroFactuPrincipal=true;

	public Boolean getActivarFK_IdCuentaContableIceParametroFactuPrincipal() {
		return this.activarFK_IdCuentaContableIceParametroFactuPrincipal;
	}

	public void setActivarFK_IdCuentaContableIceParametroFactuPrincipal(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableIceParametroFactuPrincipal= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableOtroCargoParametroFactuPrincipal=true;

	public Boolean getActivarFK_IdCuentaContableOtroCargoParametroFactuPrincipal() {
		return this.activarFK_IdCuentaContableOtroCargoParametroFactuPrincipal;
	}

	public void setActivarFK_IdCuentaContableOtroCargoParametroFactuPrincipal(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableOtroCargoParametroFactuPrincipal= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaParametroFactuPrincipal=true;

	public Boolean getActivarFK_IdEmpresaParametroFactuPrincipal() {
		return this.activarFK_IdEmpresaParametroFactuPrincipal;
	}

	public void setActivarFK_IdEmpresaParametroFactuPrincipal(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroFactuPrincipal= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoParametroFactuPrincipal=true;

	public Boolean getActivarFK_IdFormatoParametroFactuPrincipal() {
		return this.activarFK_IdFormatoParametroFactuPrincipal;
	}

	public void setActivarFK_IdFormatoParametroFactuPrincipal(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoParametroFactuPrincipal= habilitarResaltar;
	}

	public Boolean activarFK_IdLibroContableParametroFactuPrincipal=true;

	public Boolean getActivarFK_IdLibroContableParametroFactuPrincipal() {
		return this.activarFK_IdLibroContableParametroFactuPrincipal;
	}

	public void setActivarFK_IdLibroContableParametroFactuPrincipal(Boolean habilitarResaltar) {
		this.activarFK_IdLibroContableParametroFactuPrincipal= habilitarResaltar;
	}

	public Boolean activarFK_IdMonedaParametroFactuPrincipal=true;

	public Boolean getActivarFK_IdMonedaParametroFactuPrincipal() {
		return this.activarFK_IdMonedaParametroFactuPrincipal;
	}

	public void setActivarFK_IdMonedaParametroFactuPrincipal(Boolean habilitarResaltar) {
		this.activarFK_IdMonedaParametroFactuPrincipal= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalParametroFactuPrincipal=true;

	public Boolean getActivarFK_IdSucursalParametroFactuPrincipal() {
		return this.activarFK_IdSucursalParametroFactuPrincipal;
	}

	public void setActivarFK_IdSucursalParametroFactuPrincipal(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalParametroFactuPrincipal= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDocumentoFacturaParametroFactuPrincipal=true;

	public Boolean getActivarFK_IdTipoDocumentoFacturaParametroFactuPrincipal() {
		return this.activarFK_IdTipoDocumentoFacturaParametroFactuPrincipal;
	}

	public void setActivarFK_IdTipoDocumentoFacturaParametroFactuPrincipal(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDocumentoFacturaParametroFactuPrincipal= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDocumentoNotaCreditoParametroFactuPrincipal=true;

	public Boolean getActivarFK_IdTipoDocumentoNotaCreditoParametroFactuPrincipal() {
		return this.activarFK_IdTipoDocumentoNotaCreditoParametroFactuPrincipal;
	}

	public void setActivarFK_IdTipoDocumentoNotaCreditoParametroFactuPrincipal(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDocumentoNotaCreditoParametroFactuPrincipal= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDocumentoNotaDebitoParametroFactuPrincipal=true;

	public Boolean getActivarFK_IdTipoDocumentoNotaDebitoParametroFactuPrincipal() {
		return this.activarFK_IdTipoDocumentoNotaDebitoParametroFactuPrincipal;
	}

	public void setActivarFK_IdTipoDocumentoNotaDebitoParametroFactuPrincipal(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDocumentoNotaDebitoParametroFactuPrincipal= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoParamFactuDescuentoParametroFactuPrincipal=true;

	public Boolean getActivarFK_IdTipoParamFactuDescuentoParametroFactuPrincipal() {
		return this.activarFK_IdTipoParamFactuDescuentoParametroFactuPrincipal;
	}

	public void setActivarFK_IdTipoParamFactuDescuentoParametroFactuPrincipal(Boolean habilitarResaltar) {
		this.activarFK_IdTipoParamFactuDescuentoParametroFactuPrincipal= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoParamFactuListadoClienteParametroFactuPrincipal=true;

	public Boolean getActivarFK_IdTipoParamFactuListadoClienteParametroFactuPrincipal() {
		return this.activarFK_IdTipoParamFactuListadoClienteParametroFactuPrincipal;
	}

	public void setActivarFK_IdTipoParamFactuListadoClienteParametroFactuPrincipal(Boolean habilitarResaltar) {
		this.activarFK_IdTipoParamFactuListadoClienteParametroFactuPrincipal= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoParamFactuSecuenciaTrabajoParametroFactuPrincipal=true;

	public Boolean getActivarFK_IdTipoParamFactuSecuenciaTrabajoParametroFactuPrincipal() {
		return this.activarFK_IdTipoParamFactuSecuenciaTrabajoParametroFactuPrincipal;
	}

	public void setActivarFK_IdTipoParamFactuSecuenciaTrabajoParametroFactuPrincipal(Boolean habilitarResaltar) {
		this.activarFK_IdTipoParamFactuSecuenciaTrabajoParametroFactuPrincipal= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContableBoniParametroFactuPrincipal=null;

	public Border getResaltarFK_IdCuentaContableBoniParametroFactuPrincipal() {
		return this.resaltarFK_IdCuentaContableBoniParametroFactuPrincipal;
	}

	public void setResaltarFK_IdCuentaContableBoniParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableBoniParametroFactuPrincipal= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableBoniParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableBoniParametroFactuPrincipal= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableBoniDevolParametroFactuPrincipal=null;

	public Border getResaltarFK_IdCuentaContableBoniDevolParametroFactuPrincipal() {
		return this.resaltarFK_IdCuentaContableBoniDevolParametroFactuPrincipal;
	}

	public void setResaltarFK_IdCuentaContableBoniDevolParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableBoniDevolParametroFactuPrincipal= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableBoniDevolParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableBoniDevolParametroFactuPrincipal= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableFinanParametroFactuPrincipal=null;

	public Border getResaltarFK_IdCuentaContableFinanParametroFactuPrincipal() {
		return this.resaltarFK_IdCuentaContableFinanParametroFactuPrincipal;
	}

	public void setResaltarFK_IdCuentaContableFinanParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableFinanParametroFactuPrincipal= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableFinanParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableFinanParametroFactuPrincipal= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableFleteVentaParametroFactuPrincipal=null;

	public Border getResaltarFK_IdCuentaContableFleteVentaParametroFactuPrincipal() {
		return this.resaltarFK_IdCuentaContableFleteVentaParametroFactuPrincipal;
	}

	public void setResaltarFK_IdCuentaContableFleteVentaParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableFleteVentaParametroFactuPrincipal= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableFleteVentaParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableFleteVentaParametroFactuPrincipal= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableIceParametroFactuPrincipal=null;

	public Border getResaltarFK_IdCuentaContableIceParametroFactuPrincipal() {
		return this.resaltarFK_IdCuentaContableIceParametroFactuPrincipal;
	}

	public void setResaltarFK_IdCuentaContableIceParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableIceParametroFactuPrincipal= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableIceParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableIceParametroFactuPrincipal= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableOtroCargoParametroFactuPrincipal=null;

	public Border getResaltarFK_IdCuentaContableOtroCargoParametroFactuPrincipal() {
		return this.resaltarFK_IdCuentaContableOtroCargoParametroFactuPrincipal;
	}

	public void setResaltarFK_IdCuentaContableOtroCargoParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableOtroCargoParametroFactuPrincipal= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableOtroCargoParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableOtroCargoParametroFactuPrincipal= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaParametroFactuPrincipal=null;

	public Border getResaltarFK_IdEmpresaParametroFactuPrincipal() {
		return this.resaltarFK_IdEmpresaParametroFactuPrincipal;
	}

	public void setResaltarFK_IdEmpresaParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroFactuPrincipal= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroFactuPrincipal= borderResaltar;
	}

	public Border resaltarFK_IdFormatoParametroFactuPrincipal=null;

	public Border getResaltarFK_IdFormatoParametroFactuPrincipal() {
		return this.resaltarFK_IdFormatoParametroFactuPrincipal;
	}

	public void setResaltarFK_IdFormatoParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarFK_IdFormatoParametroFactuPrincipal= borderResaltar;
	}

	public void setResaltarFK_IdFormatoParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoParametroFactuPrincipal= borderResaltar;
	}

	public Border resaltarFK_IdLibroContableParametroFactuPrincipal=null;

	public Border getResaltarFK_IdLibroContableParametroFactuPrincipal() {
		return this.resaltarFK_IdLibroContableParametroFactuPrincipal;
	}

	public void setResaltarFK_IdLibroContableParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarFK_IdLibroContableParametroFactuPrincipal= borderResaltar;
	}

	public void setResaltarFK_IdLibroContableParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLibroContableParametroFactuPrincipal= borderResaltar;
	}

	public Border resaltarFK_IdMonedaParametroFactuPrincipal=null;

	public Border getResaltarFK_IdMonedaParametroFactuPrincipal() {
		return this.resaltarFK_IdMonedaParametroFactuPrincipal;
	}

	public void setResaltarFK_IdMonedaParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarFK_IdMonedaParametroFactuPrincipal= borderResaltar;
	}

	public void setResaltarFK_IdMonedaParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMonedaParametroFactuPrincipal= borderResaltar;
	}

	public Border resaltarFK_IdSucursalParametroFactuPrincipal=null;

	public Border getResaltarFK_IdSucursalParametroFactuPrincipal() {
		return this.resaltarFK_IdSucursalParametroFactuPrincipal;
	}

	public void setResaltarFK_IdSucursalParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarFK_IdSucursalParametroFactuPrincipal= borderResaltar;
	}

	public void setResaltarFK_IdSucursalParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalParametroFactuPrincipal= borderResaltar;
	}

	public Border resaltarFK_IdTipoDocumentoFacturaParametroFactuPrincipal=null;

	public Border getResaltarFK_IdTipoDocumentoFacturaParametroFactuPrincipal() {
		return this.resaltarFK_IdTipoDocumentoFacturaParametroFactuPrincipal;
	}

	public void setResaltarFK_IdTipoDocumentoFacturaParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarFK_IdTipoDocumentoFacturaParametroFactuPrincipal= borderResaltar;
	}

	public void setResaltarFK_IdTipoDocumentoFacturaParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDocumentoFacturaParametroFactuPrincipal= borderResaltar;
	}

	public Border resaltarFK_IdTipoDocumentoNotaCreditoParametroFactuPrincipal=null;

	public Border getResaltarFK_IdTipoDocumentoNotaCreditoParametroFactuPrincipal() {
		return this.resaltarFK_IdTipoDocumentoNotaCreditoParametroFactuPrincipal;
	}

	public void setResaltarFK_IdTipoDocumentoNotaCreditoParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarFK_IdTipoDocumentoNotaCreditoParametroFactuPrincipal= borderResaltar;
	}

	public void setResaltarFK_IdTipoDocumentoNotaCreditoParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDocumentoNotaCreditoParametroFactuPrincipal= borderResaltar;
	}

	public Border resaltarFK_IdTipoDocumentoNotaDebitoParametroFactuPrincipal=null;

	public Border getResaltarFK_IdTipoDocumentoNotaDebitoParametroFactuPrincipal() {
		return this.resaltarFK_IdTipoDocumentoNotaDebitoParametroFactuPrincipal;
	}

	public void setResaltarFK_IdTipoDocumentoNotaDebitoParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarFK_IdTipoDocumentoNotaDebitoParametroFactuPrincipal= borderResaltar;
	}

	public void setResaltarFK_IdTipoDocumentoNotaDebitoParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDocumentoNotaDebitoParametroFactuPrincipal= borderResaltar;
	}

	public Border resaltarFK_IdTipoParamFactuDescuentoParametroFactuPrincipal=null;

	public Border getResaltarFK_IdTipoParamFactuDescuentoParametroFactuPrincipal() {
		return this.resaltarFK_IdTipoParamFactuDescuentoParametroFactuPrincipal;
	}

	public void setResaltarFK_IdTipoParamFactuDescuentoParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarFK_IdTipoParamFactuDescuentoParametroFactuPrincipal= borderResaltar;
	}

	public void setResaltarFK_IdTipoParamFactuDescuentoParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoParamFactuDescuentoParametroFactuPrincipal= borderResaltar;
	}

	public Border resaltarFK_IdTipoParamFactuListadoClienteParametroFactuPrincipal=null;

	public Border getResaltarFK_IdTipoParamFactuListadoClienteParametroFactuPrincipal() {
		return this.resaltarFK_IdTipoParamFactuListadoClienteParametroFactuPrincipal;
	}

	public void setResaltarFK_IdTipoParamFactuListadoClienteParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarFK_IdTipoParamFactuListadoClienteParametroFactuPrincipal= borderResaltar;
	}

	public void setResaltarFK_IdTipoParamFactuListadoClienteParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoParamFactuListadoClienteParametroFactuPrincipal= borderResaltar;
	}

	public Border resaltarFK_IdTipoParamFactuSecuenciaTrabajoParametroFactuPrincipal=null;

	public Border getResaltarFK_IdTipoParamFactuSecuenciaTrabajoParametroFactuPrincipal() {
		return this.resaltarFK_IdTipoParamFactuSecuenciaTrabajoParametroFactuPrincipal;
	}

	public void setResaltarFK_IdTipoParamFactuSecuenciaTrabajoParametroFactuPrincipal(Border borderResaltar) {
		this.resaltarFK_IdTipoParamFactuSecuenciaTrabajoParametroFactuPrincipal= borderResaltar;
	}

	public void setResaltarFK_IdTipoParamFactuSecuenciaTrabajoParametroFactuPrincipal(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuPrincipalBeanSwingJInternalFrame parametrofactuprincipalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoParamFactuSecuenciaTrabajoParametroFactuPrincipal= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}