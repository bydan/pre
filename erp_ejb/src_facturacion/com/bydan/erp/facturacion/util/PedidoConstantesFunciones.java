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


import com.bydan.erp.facturacion.util.PedidoConstantesFunciones;
import com.bydan.erp.facturacion.util.PedidoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.PedidoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PedidoConstantesFunciones extends PedidoConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=260 + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
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
	public static final String SNOMBREOPCION="Pedido";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Pedido"+PedidoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PedidoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PedidoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PedidoConstantesFunciones.SCHEMA+"_"+PedidoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PedidoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PedidoConstantesFunciones.SCHEMA+"_"+PedidoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PedidoConstantesFunciones.SCHEMA+"_"+PedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PedidoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PedidoConstantesFunciones.SCHEMA+"_"+PedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PedidoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PedidoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PedidoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PedidoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PedidoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PedidoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Pedidos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Pedido";
	public static final String SCLASSWEBTITULO_LOWER="Pedido";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Pedido";
	public static final String OBJECTNAME="pedido";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="pedido";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select pedido from "+PedidoConstantesFunciones.SPERSISTENCENAME+" pedido";
	public static String QUERYSELECTNATIVE="select "+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".version_row,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_empresa,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_sucursal,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_ejercicio,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_periodo,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_anio,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_mes,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_usuario,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".numero,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".pre_impreso,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".fecha_emision,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".fecha_entrega,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_moneda,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".cotizacion,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_empleado,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_tipo_precio,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_formato,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".direccion,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_cliente,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".telefono,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".ruc,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_sub_cliente,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_vendedor,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_consultor,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".orden,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_responsable,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_estado_pedido,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_transporte,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_ruta_transporte,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".valor_ruta,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_tipo_llamada,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_transportista,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".hora_inicio,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".hora_fin,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".descripcion,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".cupo,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".saldo,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".pedidos,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".documentos,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".disponible,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".descuento_porcentaje,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".total_con_iva,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".suman,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".descuento_valor,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".total_sin_iva,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".descuento_total,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".flete,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".total,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".subtotal,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".otro,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".ultimo_costo,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".iva,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".financiamiento,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".margen_utilidad,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".otros_valores,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".anticipo,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_tipo_cambio,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_centro_costo,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_zona,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".fecha,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".numero_fue,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".fecha_servidor,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".monto_retencion,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".ice from "+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME;//+" as "+PedidoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected PedidoConstantesFuncionesAdditional pedidoConstantesFuncionesAdditional=null;
	
	public PedidoConstantesFuncionesAdditional getPedidoConstantesFuncionesAdditional() {
		return this.pedidoConstantesFuncionesAdditional;
	}
	
	public void setPedidoConstantesFuncionesAdditional(PedidoConstantesFuncionesAdditional pedidoConstantesFuncionesAdditional) {
		try {
			this.pedidoConstantesFuncionesAdditional=pedidoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDUSUARIO= "id_usuario";
    public static final String NUMERO= "numero";
    public static final String PREIMPRESO= "pre_impreso";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAENTREGA= "fecha_entrega";
    public static final String IDMONEDA= "id_moneda";
    public static final String COTIZACION= "cotizacion";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDTIPOPRECIO= "id_tipo_precio";
    public static final String IDFORMATO= "id_formato";
    public static final String DIRECCION= "direccion";
    public static final String IDCLIENTE= "id_cliente";
    public static final String TELEFONO= "telefono";
    public static final String RUC= "ruc";
    public static final String IDSUBCLIENTE= "id_sub_cliente";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String IDCONSULTOR= "id_consultor";
    public static final String ORDEN= "orden";
    public static final String IDRESPONSABLE= "id_responsable";
    public static final String IDESTADOPEDIDO= "id_estado_pedido";
    public static final String IDTRANSPORTE= "id_transporte";
    public static final String IDRUTATRANSPORTE= "id_ruta_transporte";
    public static final String VALORRUTA= "valor_ruta";
    public static final String IDTIPOLLAMADA= "id_tipo_llamada";
    public static final String IDTRANSPORTISTA= "id_transportista";
    public static final String HORAINICIO= "hora_inicio";
    public static final String HORAFIN= "hora_fin";
    public static final String DESCRIPCION= "descripcion";
    public static final String CUPO= "cupo";
    public static final String SALDO= "saldo";
    public static final String PEDIDOS= "pedidos";
    public static final String DOCUMENTOS= "documentos";
    public static final String DISPONIBLE= "disponible";
    public static final String DESCUENTOPORCENTAJE= "descuento_porcentaje";
    public static final String TOTALCONIVA= "total_con_iva";
    public static final String SUMAN= "suman";
    public static final String DESCUENTOVALOR= "descuento_valor";
    public static final String TOTALSINIVA= "total_sin_iva";
    public static final String DESCUENTOTOTAL= "descuento_total";
    public static final String FLETE= "flete";
    public static final String TOTAL= "total";
    public static final String SUBTOTAL= "subtotal";
    public static final String OTRO= "otro";
    public static final String ULTIMOCOSTO= "ultimo_costo";
    public static final String IVA= "iva";
    public static final String FINANCIAMIENTO= "financiamiento";
    public static final String MARGENUTILIDAD= "margen_utilidad";
    public static final String OTROSVALORES= "otros_valores";
    public static final String ANTICIPO= "anticipo";
    public static final String IDTIPOCAMBIO= "id_tipo_cambio";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDZONA= "id_zona";
    public static final String FECHA= "fecha";
    public static final String NUMEROFUE= "numero_fue";
    public static final String FECHASERVIDOR= "fecha_servidor";
    public static final String MONTORETENCION= "monto_retencion";
    public static final String ICE= "ice";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_PREIMPRESO= "Preimpreso";
		public static final String LABEL_PREIMPRESO_LOWER= "Pre Impreso";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAENTREGA= "Fecha Entrega";
		public static final String LABEL_FECHAENTREGA_LOWER= "Fecha Entrega";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_COTIZACION= "Cotizacion";
		public static final String LABEL_COTIZACION_LOWER= "Cotizacion";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDTIPOPRECIO= "Tipo Precio";
		public static final String LABEL_IDTIPOPRECIO_LOWER= "Tipo Precio";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_IDSUBCLIENTE= "Contacto";
		public static final String LABEL_IDSUBCLIENTE_LOWER= "Sub Cliente";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_IDCONSULTOR= "Consultor";
		public static final String LABEL_IDCONSULTOR_LOWER= "Consultor";
    	public static final String LABEL_ORDEN= "Orden";
		public static final String LABEL_ORDEN_LOWER= "Orden";
    	public static final String LABEL_IDRESPONSABLE= "Responsable";
		public static final String LABEL_IDRESPONSABLE_LOWER= "Responsable";
    	public static final String LABEL_IDESTADOPEDIDO= "Estado";
		public static final String LABEL_IDESTADOPEDIDO_LOWER= "Estado Pedido";
    	public static final String LABEL_IDTRANSPORTE= "Forma Envio";
		public static final String LABEL_IDTRANSPORTE_LOWER= "Transporte";
    	public static final String LABEL_IDRUTATRANSPORTE= "Ruta";
		public static final String LABEL_IDRUTATRANSPORTE_LOWER= "Ruta Transporte";
    	public static final String LABEL_VALORRUTA= "Valor Ruta";
		public static final String LABEL_VALORRUTA_LOWER= "Valor Ruta";
    	public static final String LABEL_IDTIPOLLAMADA= "Llamada";
		public static final String LABEL_IDTIPOLLAMADA_LOWER= "Tipo Llamada";
    	public static final String LABEL_IDTRANSPORTISTA= "Transportista";
		public static final String LABEL_IDTRANSPORTISTA_LOWER= "Transportista";
    	public static final String LABEL_HORAINICIO= "Hora Inicio";
		public static final String LABEL_HORAINICIO_LOWER= "Hora Inicio";
    	public static final String LABEL_HORAFIN= "Hora Fin";
		public static final String LABEL_HORAFIN_LOWER= "Hora Fin";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_CUPO= "Cupo";
		public static final String LABEL_CUPO_LOWER= "Cupo";
    	public static final String LABEL_SALDO= "Saldo";
		public static final String LABEL_SALDO_LOWER= "Saldo";
    	public static final String LABEL_PEDIDOS= "Pedidos";
		public static final String LABEL_PEDIDOS_LOWER= "Pedidos";
    	public static final String LABEL_DOCUMENTOS= "Documentos";
		public static final String LABEL_DOCUMENTOS_LOWER= "Documentos";
    	public static final String LABEL_DISPONIBLE= "Disponible";
		public static final String LABEL_DISPONIBLE_LOWER= "Disponible";
    	public static final String LABEL_DESCUENTOPORCENTAJE= "Dscto %";
		public static final String LABEL_DESCUENTOPORCENTAJE_LOWER= "Descuento %";
    	public static final String LABEL_TOTALCONIVA= "Monto Con Iva";
		public static final String LABEL_TOTALCONIVA_LOWER= "Total Con Iva";
    	public static final String LABEL_SUMAN= "Suman";
		public static final String LABEL_SUMAN_LOWER= "Suman";
    	public static final String LABEL_DESCUENTOVALOR= "Dscto Valor";
		public static final String LABEL_DESCUENTOVALOR_LOWER= "Descuento";
    	public static final String LABEL_TOTALSINIVA= "Total Sin Iva";
		public static final String LABEL_TOTALSINIVA_LOWER= "Total Sin Iva";
    	public static final String LABEL_DESCUENTOTOTAL= "Descuento Total";
		public static final String LABEL_DESCUENTOTOTAL_LOWER= "Descuento Total";
    	public static final String LABEL_FLETE= "Flete";
		public static final String LABEL_FLETE_LOWER= "Flete";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_SUBTOTAL= "Subtotal";
		public static final String LABEL_SUBTOTAL_LOWER= "Subtotal";
    	public static final String LABEL_OTRO= "Otros Cargos";
		public static final String LABEL_OTRO_LOWER= "Otro";
    	public static final String LABEL_ULTIMOCOSTO= "Ultimo Costo";
		public static final String LABEL_ULTIMOCOSTO_LOWER= "Ultimo Costo";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_FINANCIAMIENTO= "Financiamiento";
		public static final String LABEL_FINANCIAMIENTO_LOWER= "Financiamiento";
    	public static final String LABEL_MARGENUTILIDAD= "Margen Utilidad";
		public static final String LABEL_MARGENUTILIDAD_LOWER= "Margen Utilidad";
    	public static final String LABEL_OTROSVALORES= "Otros Valores";
		public static final String LABEL_OTROSVALORES_LOWER= "Otros Valores";
    	public static final String LABEL_ANTICIPO= "Anticipo";
		public static final String LABEL_ANTICIPO_LOWER= "Anticipo";
    	public static final String LABEL_IDTIPOCAMBIO= "Tipo Cambio";
		public static final String LABEL_IDTIPOCAMBIO_LOWER= "Tipo Cambio";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDZONA= "Zona";
		public static final String LABEL_IDZONA_LOWER= "Zona";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_NUMEROFUE= "Nro Fue";
		public static final String LABEL_NUMEROFUE_LOWER= "Numero Fue";
    	public static final String LABEL_FECHASERVIDOR= "Fecha Servidor";
		public static final String LABEL_FECHASERVIDOR_LOWER= "Fecha Servidor";
    	public static final String LABEL_MONTORETENCION= "Monto Retencion";
		public static final String LABEL_MONTORETENCION_LOWER= "Monto Reten";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXPRE_IMPRESO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPRE_IMPRESO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXORDEN=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXORDEN=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_FUE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FUE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getPedidoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDEMPRESA)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDPERIODO)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDANIO)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDMES)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDUSUARIO)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.NUMERO)) {sLabelColumna=PedidoConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.PREIMPRESO)) {sLabelColumna=PedidoConstantesFunciones.LABEL_PREIMPRESO;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.FECHAEMISION)) {sLabelColumna=PedidoConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.FECHAENTREGA)) {sLabelColumna=PedidoConstantesFunciones.LABEL_FECHAENTREGA;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDMONEDA)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.COTIZACION)) {sLabelColumna=PedidoConstantesFunciones.LABEL_COTIZACION;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDEMPLEADO)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDTIPOPRECIO)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDTIPOPRECIO;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDFORMATO)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.DIRECCION)) {sLabelColumna=PedidoConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDCLIENTE)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.TELEFONO)) {sLabelColumna=PedidoConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.RUC)) {sLabelColumna=PedidoConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDSUBCLIENTE)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDSUBCLIENTE;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDVENDEDOR)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDCONSULTOR)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDCONSULTOR;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.ORDEN)) {sLabelColumna=PedidoConstantesFunciones.LABEL_ORDEN;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDRESPONSABLE)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDRESPONSABLE;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDESTADOPEDIDO)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDESTADOPEDIDO;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDTRANSPORTE)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDTRANSPORTE;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDRUTATRANSPORTE)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDRUTATRANSPORTE;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.VALORRUTA)) {sLabelColumna=PedidoConstantesFunciones.LABEL_VALORRUTA;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDTIPOLLAMADA)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDTIPOLLAMADA;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDTRANSPORTISTA)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDTRANSPORTISTA;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.HORAINICIO)) {sLabelColumna=PedidoConstantesFunciones.LABEL_HORAINICIO;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.HORAFIN)) {sLabelColumna=PedidoConstantesFunciones.LABEL_HORAFIN;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.DESCRIPCION)) {sLabelColumna=PedidoConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.CUPO)) {sLabelColumna=PedidoConstantesFunciones.LABEL_CUPO;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.SALDO)) {sLabelColumna=PedidoConstantesFunciones.LABEL_SALDO;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.PEDIDOS)) {sLabelColumna=PedidoConstantesFunciones.LABEL_PEDIDOS;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.DOCUMENTOS)) {sLabelColumna=PedidoConstantesFunciones.LABEL_DOCUMENTOS;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.DISPONIBLE)) {sLabelColumna=PedidoConstantesFunciones.LABEL_DISPONIBLE;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.DESCUENTOPORCENTAJE)) {sLabelColumna=PedidoConstantesFunciones.LABEL_DESCUENTOPORCENTAJE;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.TOTALCONIVA)) {sLabelColumna=PedidoConstantesFunciones.LABEL_TOTALCONIVA;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.SUMAN)) {sLabelColumna=PedidoConstantesFunciones.LABEL_SUMAN;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.DESCUENTOVALOR)) {sLabelColumna=PedidoConstantesFunciones.LABEL_DESCUENTOVALOR;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.TOTALSINIVA)) {sLabelColumna=PedidoConstantesFunciones.LABEL_TOTALSINIVA;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.DESCUENTOTOTAL)) {sLabelColumna=PedidoConstantesFunciones.LABEL_DESCUENTOTOTAL;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.FLETE)) {sLabelColumna=PedidoConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.TOTAL)) {sLabelColumna=PedidoConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.SUBTOTAL)) {sLabelColumna=PedidoConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.OTRO)) {sLabelColumna=PedidoConstantesFunciones.LABEL_OTRO;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.ULTIMOCOSTO)) {sLabelColumna=PedidoConstantesFunciones.LABEL_ULTIMOCOSTO;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IVA)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.FINANCIAMIENTO)) {sLabelColumna=PedidoConstantesFunciones.LABEL_FINANCIAMIENTO;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.MARGENUTILIDAD)) {sLabelColumna=PedidoConstantesFunciones.LABEL_MARGENUTILIDAD;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.OTROSVALORES)) {sLabelColumna=PedidoConstantesFunciones.LABEL_OTROSVALORES;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.ANTICIPO)) {sLabelColumna=PedidoConstantesFunciones.LABEL_ANTICIPO;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDTIPOCAMBIO)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDTIPOCAMBIO;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.IDZONA)) {sLabelColumna=PedidoConstantesFunciones.LABEL_IDZONA;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.FECHA)) {sLabelColumna=PedidoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.NUMEROFUE)) {sLabelColumna=PedidoConstantesFunciones.LABEL_NUMEROFUE;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.FECHASERVIDOR)) {sLabelColumna=PedidoConstantesFunciones.LABEL_FECHASERVIDOR;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.MONTORETENCION)) {sLabelColumna=PedidoConstantesFunciones.LABEL_MONTORETENCION;}
		if(sNombreColumna.equals(PedidoConstantesFunciones.ICE)) {sLabelColumna=PedidoConstantesFunciones.LABEL_ICE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPedidoDescripcion(Pedido pedido) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(pedido !=null/* && pedido.getId()!=0*/) {
			if(pedido.getId()!=null) {
				sDescripcion=pedido.getId().toString();
			}//pedidopedido.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPedidoDescripcionDetallado(Pedido pedido) {
		String sDescripcion="";
			
		sDescripcion+=PedidoConstantesFunciones.ID+"=";
		sDescripcion+=pedido.getId().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=pedido.getVersionRow().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=pedido.getid_empresa().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=pedido.getid_sucursal().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=pedido.getid_ejercicio().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=pedido.getid_periodo().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.IDANIO+"=";
		sDescripcion+=pedido.getid_anio().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.IDMES+"=";
		sDescripcion+=pedido.getid_mes().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=pedido.getid_usuario().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.NUMERO+"=";
		sDescripcion+=pedido.getnumero()+",";
		sDescripcion+=PedidoConstantesFunciones.PREIMPRESO+"=";
		sDescripcion+=pedido.getpre_impreso()+",";
		sDescripcion+=PedidoConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=pedido.getfecha_emision().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.FECHAENTREGA+"=";
		sDescripcion+=pedido.getfecha_entrega().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=pedido.getid_moneda().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.COTIZACION+"=";
		sDescripcion+=pedido.getcotizacion().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=pedido.getid_empleado().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.IDTIPOPRECIO+"=";
		sDescripcion+=pedido.getid_tipo_precio().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=pedido.getid_formato().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.DIRECCION+"=";
		sDescripcion+=pedido.getdireccion()+",";
		sDescripcion+=PedidoConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=pedido.getid_cliente().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.TELEFONO+"=";
		sDescripcion+=pedido.gettelefono()+",";
		sDescripcion+=PedidoConstantesFunciones.RUC+"=";
		sDescripcion+=pedido.getruc()+",";
		sDescripcion+=PedidoConstantesFunciones.IDSUBCLIENTE+"=";
		sDescripcion+=pedido.getid_sub_cliente().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=pedido.getid_vendedor().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.IDCONSULTOR+"=";
		sDescripcion+=pedido.getid_consultor().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.ORDEN+"=";
		sDescripcion+=pedido.getorden()+",";
		sDescripcion+=PedidoConstantesFunciones.IDRESPONSABLE+"=";
		sDescripcion+=pedido.getid_responsable().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.IDESTADOPEDIDO+"=";
		sDescripcion+=pedido.getid_estado_pedido().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.IDTRANSPORTE+"=";
		sDescripcion+=pedido.getid_transporte().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.IDRUTATRANSPORTE+"=";
		sDescripcion+=pedido.getid_ruta_transporte().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.VALORRUTA+"=";
		sDescripcion+=pedido.getvalor_ruta().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.IDTIPOLLAMADA+"=";
		sDescripcion+=pedido.getid_tipo_llamada().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.IDTRANSPORTISTA+"=";
		sDescripcion+=pedido.getid_transportista().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.HORAINICIO+"=";
		sDescripcion+=pedido.gethora_inicio().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.HORAFIN+"=";
		sDescripcion+=pedido.gethora_fin().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=pedido.getdescripcion()+",";
		sDescripcion+=PedidoConstantesFunciones.CUPO+"=";
		sDescripcion+=pedido.getcupo().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.SALDO+"=";
		sDescripcion+=pedido.getsaldo().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.PEDIDOS+"=";
		sDescripcion+=pedido.getpedidos().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.DOCUMENTOS+"=";
		sDescripcion+=pedido.getdocumentos().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.DISPONIBLE+"=";
		sDescripcion+=pedido.getdisponible().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.DESCUENTOPORCENTAJE+"=";
		sDescripcion+=pedido.getdescuento_porcentaje().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.TOTALCONIVA+"=";
		sDescripcion+=pedido.gettotal_con_iva().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.SUMAN+"=";
		sDescripcion+=pedido.getsuman().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.DESCUENTOVALOR+"=";
		sDescripcion+=pedido.getdescuento_valor().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.TOTALSINIVA+"=";
		sDescripcion+=pedido.gettotal_sin_iva().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.DESCUENTOTOTAL+"=";
		sDescripcion+=pedido.getdescuento_total().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.FLETE+"=";
		sDescripcion+=pedido.getflete().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.TOTAL+"=";
		sDescripcion+=pedido.gettotal().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=pedido.getsubtotal().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.OTRO+"=";
		sDescripcion+=pedido.getotro().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.ULTIMOCOSTO+"=";
		sDescripcion+=pedido.getultimo_costo().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.IVA+"=";
		sDescripcion+=pedido.getiva().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.FINANCIAMIENTO+"=";
		sDescripcion+=pedido.getfinanciamiento().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.MARGENUTILIDAD+"=";
		sDescripcion+=pedido.getmargen_utilidad().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.OTROSVALORES+"=";
		sDescripcion+=pedido.getotros_valores().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.ANTICIPO+"=";
		sDescripcion+=pedido.getanticipo().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.IDTIPOCAMBIO+"=";
		sDescripcion+=pedido.getid_tipo_cambio().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=pedido.getid_centro_costo().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.IDZONA+"=";
		sDescripcion+=pedido.getid_zona().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.FECHA+"=";
		sDescripcion+=pedido.getfecha().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.NUMEROFUE+"=";
		sDescripcion+=pedido.getnumero_fue()+",";
		sDescripcion+=PedidoConstantesFunciones.FECHASERVIDOR+"=";
		sDescripcion+=pedido.getfecha_servidor().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.MONTORETENCION+"=";
		sDescripcion+=pedido.getmonto_retencion().toString()+",";
		sDescripcion+=PedidoConstantesFunciones.ICE+"=";
		sDescripcion+=pedido.getice().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPedidoDescripcion(Pedido pedido,String sValor) throws Exception {			
		if(pedido !=null) {
			//pedidopedido.getId().toString();
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

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
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

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getTipoPrecioDescripcion(TipoPrecio tipoprecio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoprecio!=null/*&&tipoprecio.getId()>0*/) {
			sDescripcion=TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(tipoprecio);
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

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getSubClienteDescripcion(SubCliente subcliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(subcliente!=null/*&&subcliente.getId()>0*/) {
			sDescripcion=SubClienteConstantesFunciones.getSubClienteDescripcion(subcliente);
		}

		return sDescripcion;
	}

	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vendedor!=null/*&&vendedor.getId()>0*/) {
			sDescripcion=VendedorConstantesFunciones.getVendedorDescripcion(vendedor);
		}

		return sDescripcion;
	}

	public static String getConsultorDescripcion(Consultor consultor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(consultor!=null/*&&consultor.getId()>0*/) {
			sDescripcion=ConsultorConstantesFunciones.getConsultorDescripcion(consultor);
		}

		return sDescripcion;
	}

	public static String getResponsableDescripcion(Responsable responsable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(responsable!=null/*&&responsable.getId()>0*/) {
			sDescripcion=ResponsableConstantesFunciones.getResponsableDescripcion(responsable);
		}

		return sDescripcion;
	}

	public static String getEstadoPedidoDescripcion(EstadoPedido estadopedido) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadopedido!=null/*&&estadopedido.getId()>0*/) {
			sDescripcion=EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(estadopedido);
		}

		return sDescripcion;
	}

	public static String getTransporteDescripcion(Transporte transporte) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transporte!=null/*&&transporte.getId()>0*/) {
			sDescripcion=TransporteConstantesFunciones.getTransporteDescripcion(transporte);
		}

		return sDescripcion;
	}

	public static String getRutaTransporteDescripcion(RutaTransporte rutatransporte) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(rutatransporte!=null/*&&rutatransporte.getId()>0*/) {
			sDescripcion=RutaTransporteConstantesFunciones.getRutaTransporteDescripcion(rutatransporte);
		}

		return sDescripcion;
	}

	public static String getTipoLlamadaDescripcion(TipoLlamada tipollamada) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipollamada!=null/*&&tipollamada.getId()>0*/) {
			sDescripcion=TipoLlamadaConstantesFunciones.getTipoLlamadaDescripcion(tipollamada);
		}

		return sDescripcion;
	}

	public static String getTransportistaDescripcion(Transportista transportista) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transportista!=null/*&&transportista.getId()>0*/) {
			sDescripcion=TransportistaConstantesFunciones.getTransportistaDescripcion(transportista);
		}

		return sDescripcion;
	}

	public static String getTipoCambioDescripcion(TipoCambio tipocambio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocambio!=null/*&&tipocambio.getId()>0*/) {
			sDescripcion=TipoCambioConstantesFunciones.getTipoCambioDescripcion(tipocambio);
		}

		return sDescripcion;
	}

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
		}

		return sDescripcion;
	}

	public static String getZonaDescripcion(Zona zona) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(zona!=null/*&&zona.getId()>0*/) {
			sDescripcion=ZonaConstantesFunciones.getZonaDescripcion(zona);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdConsultor")) {
			sNombreIndice="Tipo=  Por Consultor";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoPedido")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdResponsable")) {
			sNombreIndice="Tipo=  Por Responsable";
		} else if(sNombreIndice.equals("FK_IdRutaTransporte")) {
			sNombreIndice="Tipo=  Por Ruta";
		} else if(sNombreIndice.equals("FK_IdSubCliente")) {
			sNombreIndice="Tipo=  Por Contacto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCambio")) {
			sNombreIndice="Tipo=  Por Tipo Cambio";
		} else if(sNombreIndice.equals("FK_IdTipoLlamada")) {
			sNombreIndice="Tipo=  Por Llamada";
		} else if(sNombreIndice.equals("FK_IdTipoPrecio")) {
			sNombreIndice="Tipo=  Por Tipo Precio";
		} else if(sNombreIndice.equals("FK_IdTransporte")) {
			sNombreIndice="Tipo=  Por Forma Envio";
		} else if(sNombreIndice.equals("FK_IdTransportista")) {
			sNombreIndice="Tipo=  Por Transportista";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		} else if(sNombreIndice.equals("FK_IdVendedor")) {
			sNombreIndice="Tipo=  Por Vendedor";
		} else if(sNombreIndice.equals("FK_IdZona")) {
			sNombreIndice="Tipo=  Por Zona";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdConsultor(Long id_consultor) {
		String sDetalleIndice=" Parametros->";
		if(id_consultor!=null) {sDetalleIndice+=" Codigo Unico De Consultor="+id_consultor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoPedido(Long id_estado_pedido) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_pedido!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_pedido.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormato(Long id_formato) {
		String sDetalleIndice=" Parametros->";
		if(id_formato!=null) {sDetalleIndice+=" Codigo Unico De Formato="+id_formato.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMoneda(Long id_moneda) {
		String sDetalleIndice=" Parametros->";
		if(id_moneda!=null) {sDetalleIndice+=" Codigo Unico De Moneda="+id_moneda.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdResponsable(Long id_responsable) {
		String sDetalleIndice=" Parametros->";
		if(id_responsable!=null) {sDetalleIndice+=" Codigo Unico De Responsable="+id_responsable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdRutaTransporte(Long id_ruta_transporte) {
		String sDetalleIndice=" Parametros->";
		if(id_ruta_transporte!=null) {sDetalleIndice+=" Codigo Unico De Ruta="+id_ruta_transporte.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSubCliente(Long id_sub_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_sub_cliente!=null) {sDetalleIndice+=" Codigo Unico De Contacto="+id_sub_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCambio(Long id_tipo_cambio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_cambio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Cambio="+id_tipo_cambio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoLlamada(Long id_tipo_llamada) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_llamada!=null) {sDetalleIndice+=" Codigo Unico De Llamada="+id_tipo_llamada.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoPrecio(Long id_tipo_precio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_precio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Precio="+id_tipo_precio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransporte(Long id_transporte) {
		String sDetalleIndice=" Parametros->";
		if(id_transporte!=null) {sDetalleIndice+=" Codigo Unico De Forma Envio="+id_transporte.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransportista(Long id_transportista) {
		String sDetalleIndice=" Parametros->";
		if(id_transportista!=null) {sDetalleIndice+=" Codigo Unico De Transportista="+id_transportista.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdVendedor(Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdZona(Long id_zona) {
		String sDetalleIndice=" Parametros->";
		if(id_zona!=null) {sDetalleIndice+=" Codigo Unico De Zona="+id_zona.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPedido(Pedido pedido,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pedido.setnumero(pedido.getnumero().trim());
		pedido.setpre_impreso(pedido.getpre_impreso().trim());
		pedido.setdireccion(pedido.getdireccion().trim());
		pedido.settelefono(pedido.gettelefono().trim());
		pedido.setruc(pedido.getruc().trim());
		pedido.setorden(pedido.getorden().trim());
		pedido.setdescripcion(pedido.getdescripcion().trim());
		pedido.setnumero_fue(pedido.getnumero_fue().trim());
	}
	
	public static void quitarEspaciosPedidos(List<Pedido> pedidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Pedido pedido: pedidos) {
			pedido.setnumero(pedido.getnumero().trim());
			pedido.setpre_impreso(pedido.getpre_impreso().trim());
			pedido.setdireccion(pedido.getdireccion().trim());
			pedido.settelefono(pedido.gettelefono().trim());
			pedido.setruc(pedido.getruc().trim());
			pedido.setorden(pedido.getorden().trim());
			pedido.setdescripcion(pedido.getdescripcion().trim());
			pedido.setnumero_fue(pedido.getnumero_fue().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPedido(Pedido pedido,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && pedido.getConCambioAuxiliar()) {
			pedido.setIsDeleted(pedido.getIsDeletedAuxiliar());	
			pedido.setIsNew(pedido.getIsNewAuxiliar());	
			pedido.setIsChanged(pedido.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			pedido.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			pedido.setIsDeletedAuxiliar(false);	
			pedido.setIsNewAuxiliar(false);	
			pedido.setIsChangedAuxiliar(false);
			
			pedido.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPedidos(List<Pedido> pedidos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Pedido pedido : pedidos) {
			if(conAsignarBase && pedido.getConCambioAuxiliar()) {
				pedido.setIsDeleted(pedido.getIsDeletedAuxiliar());	
				pedido.setIsNew(pedido.getIsNewAuxiliar());	
				pedido.setIsChanged(pedido.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				pedido.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				pedido.setIsDeletedAuxiliar(false);	
				pedido.setIsNewAuxiliar(false);	
				pedido.setIsChangedAuxiliar(false);
				
				pedido.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPedido(Pedido pedido,Boolean conEnteros) throws Exception  {
		pedido.setcotizacion(0.0);
		pedido.setvalor_ruta(0.0);
		pedido.setcupo(0.0);
		pedido.setsaldo(0.0);
		pedido.setpedidos(0.0);
		pedido.setdocumentos(0.0);
		pedido.setdisponible(0.0);
		pedido.setdescuento_porcentaje(0.0);
		pedido.settotal_con_iva(0.0);
		pedido.setsuman(0.0);
		pedido.setdescuento_valor(0.0);
		pedido.settotal_sin_iva(0.0);
		pedido.setdescuento_total(0.0);
		pedido.setflete(0.0);
		pedido.settotal(0.0);
		pedido.setsubtotal(0.0);
		pedido.setotro(0.0);
		pedido.setultimo_costo(0.0);
		pedido.setiva(0.0);
		pedido.setfinanciamiento(0.0);
		pedido.setmargen_utilidad(0.0);
		pedido.setotros_valores(0.0);
		pedido.setanticipo(0.0);
		pedido.setmonto_retencion(0.0);
		pedido.setice(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPedidos(List<Pedido> pedidos,Boolean conEnteros) throws Exception  {
		
		for(Pedido pedido: pedidos) {
			pedido.setcotizacion(0.0);
			pedido.setvalor_ruta(0.0);
			pedido.setcupo(0.0);
			pedido.setsaldo(0.0);
			pedido.setpedidos(0.0);
			pedido.setdocumentos(0.0);
			pedido.setdisponible(0.0);
			pedido.setdescuento_porcentaje(0.0);
			pedido.settotal_con_iva(0.0);
			pedido.setsuman(0.0);
			pedido.setdescuento_valor(0.0);
			pedido.settotal_sin_iva(0.0);
			pedido.setdescuento_total(0.0);
			pedido.setflete(0.0);
			pedido.settotal(0.0);
			pedido.setsubtotal(0.0);
			pedido.setotro(0.0);
			pedido.setultimo_costo(0.0);
			pedido.setiva(0.0);
			pedido.setfinanciamiento(0.0);
			pedido.setmargen_utilidad(0.0);
			pedido.setotros_valores(0.0);
			pedido.setanticipo(0.0);
			pedido.setmonto_retencion(0.0);
			pedido.setice(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPedido(List<Pedido> pedidos,Pedido pedidoAux) throws Exception  {
		PedidoConstantesFunciones.InicializarValoresPedido(pedidoAux,true);
		
		for(Pedido pedido: pedidos) {
			if(pedido.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			pedidoAux.setcotizacion(pedidoAux.getcotizacion()+pedido.getcotizacion());			
			pedidoAux.setvalor_ruta(pedidoAux.getvalor_ruta()+pedido.getvalor_ruta());			
			pedidoAux.setcupo(pedidoAux.getcupo()+pedido.getcupo());			
			pedidoAux.setsaldo(pedidoAux.getsaldo()+pedido.getsaldo());			
			pedidoAux.setpedidos(pedidoAux.getpedidos()+pedido.getpedidos());			
			pedidoAux.setdocumentos(pedidoAux.getdocumentos()+pedido.getdocumentos());			
			pedidoAux.setdisponible(pedidoAux.getdisponible()+pedido.getdisponible());			
			pedidoAux.setdescuento_porcentaje(pedidoAux.getdescuento_porcentaje()+pedido.getdescuento_porcentaje());			
			pedidoAux.settotal_con_iva(pedidoAux.gettotal_con_iva()+pedido.gettotal_con_iva());			
			pedidoAux.setsuman(pedidoAux.getsuman()+pedido.getsuman());			
			pedidoAux.setdescuento_valor(pedidoAux.getdescuento_valor()+pedido.getdescuento_valor());			
			pedidoAux.settotal_sin_iva(pedidoAux.gettotal_sin_iva()+pedido.gettotal_sin_iva());			
			pedidoAux.setdescuento_total(pedidoAux.getdescuento_total()+pedido.getdescuento_total());			
			pedidoAux.setflete(pedidoAux.getflete()+pedido.getflete());			
			pedidoAux.settotal(pedidoAux.gettotal()+pedido.gettotal());			
			pedidoAux.setsubtotal(pedidoAux.getsubtotal()+pedido.getsubtotal());			
			pedidoAux.setotro(pedidoAux.getotro()+pedido.getotro());			
			pedidoAux.setultimo_costo(pedidoAux.getultimo_costo()+pedido.getultimo_costo());			
			pedidoAux.setiva(pedidoAux.getiva()+pedido.getiva());			
			pedidoAux.setfinanciamiento(pedidoAux.getfinanciamiento()+pedido.getfinanciamiento());			
			pedidoAux.setmargen_utilidad(pedidoAux.getmargen_utilidad()+pedido.getmargen_utilidad());			
			pedidoAux.setotros_valores(pedidoAux.getotros_valores()+pedido.getotros_valores());			
			pedidoAux.setanticipo(pedidoAux.getanticipo()+pedido.getanticipo());			
			pedidoAux.setmonto_retencion(pedidoAux.getmonto_retencion()+pedido.getmonto_retencion());			
			pedidoAux.setice(pedidoAux.getice()+pedido.getice());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPedido(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PedidoConstantesFunciones.getArrayColumnasGlobalesPedido(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPedido(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoConstantesFunciones.IDUSUARIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPedido(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Pedido> pedidos,Pedido pedido,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Pedido pedidoAux: pedidos) {
			if(pedidoAux!=null && pedido!=null) {
				if((pedidoAux.getId()==null && pedido.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(pedidoAux.getId()!=null && pedido.getId()!=null){
					if(pedidoAux.getId().equals(pedido.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPedido(List<Pedido> pedidos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double cotizacionTotal=0.0;
		Double valor_rutaTotal=0.0;
		Double cupoTotal=0.0;
		Double saldoTotal=0.0;
		Double pedidosTotal=0.0;
		Double documentosTotal=0.0;
		Double disponibleTotal=0.0;
		Double descuento_porcentajeTotal=0.0;
		Double total_con_ivaTotal=0.0;
		Double sumanTotal=0.0;
		Double descuento_valorTotal=0.0;
		Double total_sin_ivaTotal=0.0;
		Double descuento_totalTotal=0.0;
		Double fleteTotal=0.0;
		Double totalTotal=0.0;
		Double subtotalTotal=0.0;
		Double otroTotal=0.0;
		Double ultimo_costoTotal=0.0;
		Double ivaTotal=0.0;
		Double financiamientoTotal=0.0;
		Double margen_utilidadTotal=0.0;
		Double otros_valoresTotal=0.0;
		Double anticipoTotal=0.0;
		Double monto_retencionTotal=0.0;
		Double iceTotal=0.0;
	
		for(Pedido pedido: pedidos) {			
			if(pedido.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cotizacionTotal+=pedido.getcotizacion();
			valor_rutaTotal+=pedido.getvalor_ruta();
			cupoTotal+=pedido.getcupo();
			saldoTotal+=pedido.getsaldo();
			pedidosTotal+=pedido.getpedidos();
			documentosTotal+=pedido.getdocumentos();
			disponibleTotal+=pedido.getdisponible();
			descuento_porcentajeTotal+=pedido.getdescuento_porcentaje();
			total_con_ivaTotal+=pedido.gettotal_con_iva();
			sumanTotal+=pedido.getsuman();
			descuento_valorTotal+=pedido.getdescuento_valor();
			total_sin_ivaTotal+=pedido.gettotal_sin_iva();
			descuento_totalTotal+=pedido.getdescuento_total();
			fleteTotal+=pedido.getflete();
			totalTotal+=pedido.gettotal();
			subtotalTotal+=pedido.getsubtotal();
			otroTotal+=pedido.getotro();
			ultimo_costoTotal+=pedido.getultimo_costo();
			ivaTotal+=pedido.getiva();
			financiamientoTotal+=pedido.getfinanciamiento();
			margen_utilidadTotal+=pedido.getmargen_utilidad();
			otros_valoresTotal+=pedido.getotros_valores();
			anticipoTotal+=pedido.getanticipo();
			monto_retencionTotal+=pedido.getmonto_retencion();
			iceTotal+=pedido.getice();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.COTIZACION);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_COTIZACION);
		datoGeneral.setdValorDouble(cotizacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.VALORRUTA);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_VALORRUTA);
		datoGeneral.setdValorDouble(valor_rutaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.CUPO);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_CUPO);
		datoGeneral.setdValorDouble(cupoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.PEDIDOS);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_PEDIDOS);
		datoGeneral.setdValorDouble(pedidosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.DOCUMENTOS);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_DOCUMENTOS);
		datoGeneral.setdValorDouble(documentosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.DISPONIBLE);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_DISPONIBLE);
		datoGeneral.setdValorDouble(disponibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.DESCUENTOPORCENTAJE);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
		datoGeneral.setdValorDouble(descuento_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.TOTALCONIVA);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_TOTALCONIVA);
		datoGeneral.setdValorDouble(total_con_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.SUMAN);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_SUMAN);
		datoGeneral.setdValorDouble(sumanTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.DESCUENTOVALOR);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_DESCUENTOVALOR);
		datoGeneral.setdValorDouble(descuento_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.TOTALSINIVA);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_TOTALSINIVA);
		datoGeneral.setdValorDouble(total_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.DESCUENTOTOTAL);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_DESCUENTOTOTAL);
		datoGeneral.setdValorDouble(descuento_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(subtotalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.OTRO);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_OTRO);
		datoGeneral.setdValorDouble(otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.ULTIMOCOSTO);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_ULTIMOCOSTO);
		datoGeneral.setdValorDouble(ultimo_costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.MARGENUTILIDAD);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_MARGENUTILIDAD);
		datoGeneral.setdValorDouble(margen_utilidadTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.OTROSVALORES);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_OTROSVALORES);
		datoGeneral.setdValorDouble(otros_valoresTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.ANTICIPO);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_ANTICIPO);
		datoGeneral.setdValorDouble(anticipoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.MONTORETENCION);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_MONTORETENCION);
		datoGeneral.setdValorDouble(monto_retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(PedidoConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPedido() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_ID, PedidoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_VERSIONROW, PedidoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDEMPRESA, PedidoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDSUCURSAL, PedidoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDEJERCICIO, PedidoConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDPERIODO, PedidoConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDANIO, PedidoConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDMES, PedidoConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDUSUARIO, PedidoConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_NUMERO, PedidoConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_PREIMPRESO, PedidoConstantesFunciones.PREIMPRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_FECHAEMISION, PedidoConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_FECHAENTREGA, PedidoConstantesFunciones.FECHAENTREGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDMONEDA, PedidoConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_COTIZACION, PedidoConstantesFunciones.COTIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDEMPLEADO, PedidoConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDTIPOPRECIO, PedidoConstantesFunciones.IDTIPOPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDFORMATO, PedidoConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_DIRECCION, PedidoConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDCLIENTE, PedidoConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_TELEFONO, PedidoConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_RUC, PedidoConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDSUBCLIENTE, PedidoConstantesFunciones.IDSUBCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDVENDEDOR, PedidoConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDCONSULTOR, PedidoConstantesFunciones.IDCONSULTOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_ORDEN, PedidoConstantesFunciones.ORDEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDRESPONSABLE, PedidoConstantesFunciones.IDRESPONSABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDESTADOPEDIDO, PedidoConstantesFunciones.IDESTADOPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDTRANSPORTE, PedidoConstantesFunciones.IDTRANSPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDRUTATRANSPORTE, PedidoConstantesFunciones.IDRUTATRANSPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_VALORRUTA, PedidoConstantesFunciones.VALORRUTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDTIPOLLAMADA, PedidoConstantesFunciones.IDTIPOLLAMADA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDTRANSPORTISTA, PedidoConstantesFunciones.IDTRANSPORTISTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_HORAINICIO, PedidoConstantesFunciones.HORAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_HORAFIN, PedidoConstantesFunciones.HORAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_DESCRIPCION, PedidoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_CUPO, PedidoConstantesFunciones.CUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_SALDO, PedidoConstantesFunciones.SALDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_PEDIDOS, PedidoConstantesFunciones.PEDIDOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_DOCUMENTOS, PedidoConstantesFunciones.DOCUMENTOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_DISPONIBLE, PedidoConstantesFunciones.DISPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_DESCUENTOPORCENTAJE, PedidoConstantesFunciones.DESCUENTOPORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_TOTALCONIVA, PedidoConstantesFunciones.TOTALCONIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_SUMAN, PedidoConstantesFunciones.SUMAN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_DESCUENTOVALOR, PedidoConstantesFunciones.DESCUENTOVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_TOTALSINIVA, PedidoConstantesFunciones.TOTALSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_DESCUENTOTOTAL, PedidoConstantesFunciones.DESCUENTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_FLETE, PedidoConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_TOTAL, PedidoConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_SUBTOTAL, PedidoConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_OTRO, PedidoConstantesFunciones.OTRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_ULTIMOCOSTO, PedidoConstantesFunciones.ULTIMOCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IVA, PedidoConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_FINANCIAMIENTO, PedidoConstantesFunciones.FINANCIAMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_MARGENUTILIDAD, PedidoConstantesFunciones.MARGENUTILIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_OTROSVALORES, PedidoConstantesFunciones.OTROSVALORES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_ANTICIPO, PedidoConstantesFunciones.ANTICIPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDTIPOCAMBIO, PedidoConstantesFunciones.IDTIPOCAMBIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDCENTROCOSTO, PedidoConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_IDZONA, PedidoConstantesFunciones.IDZONA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_FECHA, PedidoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_NUMEROFUE, PedidoConstantesFunciones.NUMEROFUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_FECHASERVIDOR, PedidoConstantesFunciones.FECHASERVIDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_MONTORETENCION, PedidoConstantesFunciones.MONTORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoConstantesFunciones.LABEL_ICE, PedidoConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPedido() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.PREIMPRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.FECHAENTREGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.COTIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDTIPOPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDSUBCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDCONSULTOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.ORDEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDRESPONSABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDESTADOPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDTRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDRUTATRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.VALORRUTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDTIPOLLAMADA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDTRANSPORTISTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.HORAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.HORAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.CUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.SALDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.PEDIDOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.DOCUMENTOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.DISPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.DESCUENTOPORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.TOTALCONIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.SUMAN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.DESCUENTOVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.TOTALSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.DESCUENTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.OTRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.ULTIMOCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.FINANCIAMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.MARGENUTILIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.OTROSVALORES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.ANTICIPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDTIPOCAMBIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.IDZONA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.NUMEROFUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.FECHASERVIDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.MONTORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedido() throws Exception  {
		return PedidoConstantesFunciones.getTiposSeleccionarPedido(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedido(Boolean conFk) throws Exception  {
		return PedidoConstantesFunciones.getTiposSeleccionarPedido(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedido(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_PREIMPRESO);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_PREIMPRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_FECHAENTREGA);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_FECHAENTREGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_COTIZACION);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_COTIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDTIPOPRECIO);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDTIPOPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDSUBCLIENTE);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDSUBCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDCONSULTOR);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDCONSULTOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_ORDEN);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_ORDEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDRESPONSABLE);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDRESPONSABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDESTADOPEDIDO);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDESTADOPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDTRANSPORTE);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDTRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDRUTATRANSPORTE);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDRUTATRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_VALORRUTA);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_VALORRUTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDTIPOLLAMADA);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDTIPOLLAMADA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDTRANSPORTISTA);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDTRANSPORTISTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(PedidoConstantesFunciones.LABEL_HORAINICIO);
		reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_HORAINICIO);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(PedidoConstantesFunciones.LABEL_HORAFIN);
		reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_HORAFIN);

		arrTiposSeleccionarTodos.add(reporte);
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_CUPO);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_CUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_SALDO);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_SALDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_PEDIDOS);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_PEDIDOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_DOCUMENTOS);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_DOCUMENTOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_DISPONIBLE);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_DISPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_TOTALCONIVA);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_TOTALCONIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_SUMAN);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_SUMAN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_DESCUENTOVALOR);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_DESCUENTOVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_TOTALSINIVA);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_TOTALSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_DESCUENTOTOTAL);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_DESCUENTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_OTRO);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_OTRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_ULTIMOCOSTO);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_ULTIMOCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_FINANCIAMIENTO);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_FINANCIAMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_MARGENUTILIDAD);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_MARGENUTILIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_OTROSVALORES);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_OTROSVALORES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_ANTICIPO);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_ANTICIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDTIPOCAMBIO);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDTIPOCAMBIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_IDZONA);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_IDZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_NUMEROFUE);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_NUMEROFUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_FECHASERVIDOR);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_FECHASERVIDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_MONTORETENCION);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_MONTORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(PedidoConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPedido(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPedido(Pedido pedidoAux) throws Exception {
		
			pedidoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pedidoAux.getEmpresa()));
			pedidoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(pedidoAux.getSucursal()));
			pedidoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(pedidoAux.getEjercicio()));
			pedidoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(pedidoAux.getPeriodo()));
			pedidoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(pedidoAux.getAnio()));
			pedidoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(pedidoAux.getMes()));
			pedidoAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(pedidoAux.getUsuario()));
			pedidoAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(pedidoAux.getMoneda()));
			pedidoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(pedidoAux.getEmpleado()));
			pedidoAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(pedidoAux.getTipoPrecio()));
			pedidoAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(pedidoAux.getFormato()));
			pedidoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(pedidoAux.getCliente()));
			pedidoAux.setsubcliente_descripcion(SubClienteConstantesFunciones.getSubClienteDescripcion(pedidoAux.getSubCliente()));
			pedidoAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(pedidoAux.getVendedor()));
			pedidoAux.setconsultor_descripcion(ConsultorConstantesFunciones.getConsultorDescripcion(pedidoAux.getConsultor()));
			pedidoAux.setresponsable_descripcion(ResponsableConstantesFunciones.getResponsableDescripcion(pedidoAux.getResponsable()));
			pedidoAux.setestadopedido_descripcion(EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(pedidoAux.getEstadoPedido()));
			pedidoAux.settransporte_descripcion(TransporteConstantesFunciones.getTransporteDescripcion(pedidoAux.getTransporte()));
			pedidoAux.setrutatransporte_descripcion(RutaTransporteConstantesFunciones.getRutaTransporteDescripcion(pedidoAux.getRutaTransporte()));
			pedidoAux.settipollamada_descripcion(TipoLlamadaConstantesFunciones.getTipoLlamadaDescripcion(pedidoAux.getTipoLlamada()));
			pedidoAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(pedidoAux.getTransportista()));
			pedidoAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(pedidoAux.getTipoCambio()));
			pedidoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(pedidoAux.getCentroCosto()));
			pedidoAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(pedidoAux.getZona()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPedido(List<Pedido> pedidosTemp) throws Exception {
		for(Pedido pedidoAux:pedidosTemp) {
			
			pedidoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pedidoAux.getEmpresa()));
			pedidoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(pedidoAux.getSucursal()));
			pedidoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(pedidoAux.getEjercicio()));
			pedidoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(pedidoAux.getPeriodo()));
			pedidoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(pedidoAux.getAnio()));
			pedidoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(pedidoAux.getMes()));
			pedidoAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(pedidoAux.getUsuario()));
			pedidoAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(pedidoAux.getMoneda()));
			pedidoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(pedidoAux.getEmpleado()));
			pedidoAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(pedidoAux.getTipoPrecio()));
			pedidoAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(pedidoAux.getFormato()));
			pedidoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(pedidoAux.getCliente()));
			pedidoAux.setsubcliente_descripcion(SubClienteConstantesFunciones.getSubClienteDescripcion(pedidoAux.getSubCliente()));
			pedidoAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(pedidoAux.getVendedor()));
			pedidoAux.setconsultor_descripcion(ConsultorConstantesFunciones.getConsultorDescripcion(pedidoAux.getConsultor()));
			pedidoAux.setresponsable_descripcion(ResponsableConstantesFunciones.getResponsableDescripcion(pedidoAux.getResponsable()));
			pedidoAux.setestadopedido_descripcion(EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(pedidoAux.getEstadoPedido()));
			pedidoAux.settransporte_descripcion(TransporteConstantesFunciones.getTransporteDescripcion(pedidoAux.getTransporte()));
			pedidoAux.setrutatransporte_descripcion(RutaTransporteConstantesFunciones.getRutaTransporteDescripcion(pedidoAux.getRutaTransporte()));
			pedidoAux.settipollamada_descripcion(TipoLlamadaConstantesFunciones.getTipoLlamadaDescripcion(pedidoAux.getTipoLlamada()));
			pedidoAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(pedidoAux.getTransportista()));
			pedidoAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(pedidoAux.getTipoCambio()));
			pedidoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(pedidoAux.getCentroCosto()));
			pedidoAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(pedidoAux.getZona()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(TipoPrecio.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(SubCliente.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(Consultor.class));
				classes.add(new Classe(Responsable.class));
				classes.add(new Classe(EstadoPedido.class));
				classes.add(new Classe(Transporte.class));
				classes.add(new Classe(RutaTransporte.class));
				classes.add(new Classe(TipoLlamada.class));
				classes.add(new Classe(Transportista.class));
				classes.add(new Classe(TipoCambio.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(Zona.class));
				
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
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPrecio.class)) {
						classes.add(new Classe(TipoPrecio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SubCliente.class)) {
						classes.add(new Classe(SubCliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Consultor.class)) {
						classes.add(new Classe(Consultor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Responsable.class)) {
						classes.add(new Classe(Responsable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoPedido.class)) {
						classes.add(new Classe(EstadoPedido.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transporte.class)) {
						classes.add(new Classe(Transporte.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RutaTransporte.class)) {
						classes.add(new Classe(RutaTransporte.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoLlamada.class)) {
						classes.add(new Classe(TipoLlamada.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transportista.class)) {
						classes.add(new Classe(Transportista.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCambio.class)) {
						classes.add(new Classe(TipoCambio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Zona.class)) {
						classes.add(new Classe(Zona.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPedido(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Consultor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consultor.class)); continue;
					}

					if(Responsable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Responsable.class)); continue;
					}

					if(EstadoPedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedido.class)); continue;
					}

					if(Transporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transporte.class)); continue;
					}

					if(RutaTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RutaTransporte.class)); continue;
					}

					if(TipoLlamada.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoLlamada.class)); continue;
					}

					if(Transportista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transportista.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Consultor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consultor.class)); continue;
					}

					if(Responsable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Responsable.class)); continue;
					}

					if(EstadoPedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedido.class)); continue;
					}

					if(Transporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transporte.class)); continue;
					}

					if(RutaTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RutaTransporte.class)); continue;
					}

					if(TipoLlamada.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoLlamada.class)); continue;
					}

					if(Transportista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transportista.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PedidoConstantesFunciones.getClassesRelationshipsOfPedido(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Contenedor.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(DetallePedido.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Contenedor.class)) {
						classes.add(new Classe(Contenedor.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetallePedido.class)) {
						classes.add(new Classe(DetallePedido.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPedido(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PedidoConstantesFunciones.getClassesRelationshipsFromStringsOfPedido(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPedido(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Contenedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Contenedor.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(DetallePedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetallePedido.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Contenedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Contenedor.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(DetallePedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetallePedido.class)); continue;
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
	public static void actualizarLista(Pedido pedido,List<Pedido> pedidos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Pedido pedidoEncontrado=null;
			
			for(Pedido pedidoLocal:pedidos) {
				if(pedidoLocal.getId().equals(pedido.getId())) {
					pedidoEncontrado=pedidoLocal;
					
					pedidoLocal.setIsChanged(pedido.getIsChanged());
					pedidoLocal.setIsNew(pedido.getIsNew());
					pedidoLocal.setIsDeleted(pedido.getIsDeleted());
					
					pedidoLocal.setGeneralEntityOriginal(pedido.getGeneralEntityOriginal());
					
					pedidoLocal.setId(pedido.getId());	
					pedidoLocal.setVersionRow(pedido.getVersionRow());	
					pedidoLocal.setid_empresa(pedido.getid_empresa());	
					pedidoLocal.setid_sucursal(pedido.getid_sucursal());	
					pedidoLocal.setid_ejercicio(pedido.getid_ejercicio());	
					pedidoLocal.setid_periodo(pedido.getid_periodo());	
					pedidoLocal.setid_anio(pedido.getid_anio());	
					pedidoLocal.setid_mes(pedido.getid_mes());	
					pedidoLocal.setid_usuario(pedido.getid_usuario());	
					pedidoLocal.setnumero(pedido.getnumero());	
					pedidoLocal.setpre_impreso(pedido.getpre_impreso());	
					pedidoLocal.setfecha_emision(pedido.getfecha_emision());	
					pedidoLocal.setfecha_entrega(pedido.getfecha_entrega());	
					pedidoLocal.setid_moneda(pedido.getid_moneda());	
					pedidoLocal.setcotizacion(pedido.getcotizacion());	
					pedidoLocal.setid_empleado(pedido.getid_empleado());	
					pedidoLocal.setid_tipo_precio(pedido.getid_tipo_precio());	
					pedidoLocal.setid_formato(pedido.getid_formato());	
					pedidoLocal.setdireccion(pedido.getdireccion());	
					pedidoLocal.setid_cliente(pedido.getid_cliente());	
					pedidoLocal.settelefono(pedido.gettelefono());	
					pedidoLocal.setruc(pedido.getruc());	
					pedidoLocal.setid_sub_cliente(pedido.getid_sub_cliente());	
					pedidoLocal.setid_vendedor(pedido.getid_vendedor());	
					pedidoLocal.setid_consultor(pedido.getid_consultor());	
					pedidoLocal.setorden(pedido.getorden());	
					pedidoLocal.setid_responsable(pedido.getid_responsable());	
					pedidoLocal.setid_estado_pedido(pedido.getid_estado_pedido());	
					pedidoLocal.setid_transporte(pedido.getid_transporte());	
					pedidoLocal.setid_ruta_transporte(pedido.getid_ruta_transporte());	
					pedidoLocal.setvalor_ruta(pedido.getvalor_ruta());	
					pedidoLocal.setid_tipo_llamada(pedido.getid_tipo_llamada());	
					pedidoLocal.setid_transportista(pedido.getid_transportista());	
					pedidoLocal.sethora_inicio(pedido.gethora_inicio());	
					pedidoLocal.sethora_fin(pedido.gethora_fin());	
					pedidoLocal.setdescripcion(pedido.getdescripcion());	
					pedidoLocal.setcupo(pedido.getcupo());	
					pedidoLocal.setsaldo(pedido.getsaldo());	
					pedidoLocal.setpedidos(pedido.getpedidos());	
					pedidoLocal.setdocumentos(pedido.getdocumentos());	
					pedidoLocal.setdisponible(pedido.getdisponible());	
					pedidoLocal.setdescuento_porcentaje(pedido.getdescuento_porcentaje());	
					pedidoLocal.settotal_con_iva(pedido.gettotal_con_iva());	
					pedidoLocal.setsuman(pedido.getsuman());	
					pedidoLocal.setdescuento_valor(pedido.getdescuento_valor());	
					pedidoLocal.settotal_sin_iva(pedido.gettotal_sin_iva());	
					pedidoLocal.setdescuento_total(pedido.getdescuento_total());	
					pedidoLocal.setflete(pedido.getflete());	
					pedidoLocal.settotal(pedido.gettotal());	
					pedidoLocal.setsubtotal(pedido.getsubtotal());	
					pedidoLocal.setotro(pedido.getotro());	
					pedidoLocal.setultimo_costo(pedido.getultimo_costo());	
					pedidoLocal.setiva(pedido.getiva());	
					pedidoLocal.setfinanciamiento(pedido.getfinanciamiento());	
					pedidoLocal.setmargen_utilidad(pedido.getmargen_utilidad());	
					pedidoLocal.setotros_valores(pedido.getotros_valores());	
					pedidoLocal.setanticipo(pedido.getanticipo());	
					pedidoLocal.setid_tipo_cambio(pedido.getid_tipo_cambio());	
					pedidoLocal.setid_centro_costo(pedido.getid_centro_costo());	
					pedidoLocal.setid_zona(pedido.getid_zona());	
					pedidoLocal.setfecha(pedido.getfecha());	
					pedidoLocal.setnumero_fue(pedido.getnumero_fue());	
					pedidoLocal.setfecha_servidor(pedido.getfecha_servidor());	
					pedidoLocal.setmonto_retencion(pedido.getmonto_retencion());	
					pedidoLocal.setice(pedido.getice());	
					
					
					pedidoLocal.setDetallePedidos(pedido.getDetallePedidos());
					
					existe=true;
					break;
				}
			}
			
			if(!pedido.getIsDeleted()) {
				if(!existe) {
					pedidos.add(pedido);
				}
			} else {
				if(pedidoEncontrado!=null && permiteQuitar)  {
					pedidos.remove(pedidoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Pedido pedido,List<Pedido> pedidos) throws Exception {
		try	{			
			for(Pedido pedidoLocal:pedidos) {
				if(pedidoLocal.getId().equals(pedido.getId())) {
					pedidoLocal.setIsSelected(pedido.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPedido(List<Pedido> pedidosAux) throws Exception {
		//this.pedidosAux=pedidosAux;
		
		for(Pedido pedidoAux:pedidosAux) {
			if(pedidoAux.getIsChanged()) {
				pedidoAux.setIsChanged(false);
			}		
			
			if(pedidoAux.getIsNew()) {
				pedidoAux.setIsNew(false);
			}	
			
			if(pedidoAux.getIsDeleted()) {
				pedidoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPedido(Pedido pedidoAux) throws Exception {
		//this.pedidoAux=pedidoAux;
		
			if(pedidoAux.getIsChanged()) {
				pedidoAux.setIsChanged(false);
			}		
			
			if(pedidoAux.getIsNew()) {
				pedidoAux.setIsNew(false);
			}	
			
			if(pedidoAux.getIsDeleted()) {
				pedidoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Pedido pedidoAsignar,Pedido pedido) throws Exception {
		pedidoAsignar.setId(pedido.getId());	
		pedidoAsignar.setVersionRow(pedido.getVersionRow());	
		pedidoAsignar.setid_empresa(pedido.getid_empresa());
		pedidoAsignar.setempresa_descripcion(pedido.getempresa_descripcion());	
		pedidoAsignar.setid_sucursal(pedido.getid_sucursal());
		pedidoAsignar.setsucursal_descripcion(pedido.getsucursal_descripcion());	
		pedidoAsignar.setid_ejercicio(pedido.getid_ejercicio());
		pedidoAsignar.setejercicio_descripcion(pedido.getejercicio_descripcion());	
		pedidoAsignar.setid_periodo(pedido.getid_periodo());
		pedidoAsignar.setperiodo_descripcion(pedido.getperiodo_descripcion());	
		pedidoAsignar.setid_anio(pedido.getid_anio());
		pedidoAsignar.setanio_descripcion(pedido.getanio_descripcion());	
		pedidoAsignar.setid_mes(pedido.getid_mes());
		pedidoAsignar.setmes_descripcion(pedido.getmes_descripcion());	
		pedidoAsignar.setid_usuario(pedido.getid_usuario());
		pedidoAsignar.setusuario_descripcion(pedido.getusuario_descripcion());	
		pedidoAsignar.setnumero(pedido.getnumero());	
		pedidoAsignar.setpre_impreso(pedido.getpre_impreso());	
		pedidoAsignar.setfecha_emision(pedido.getfecha_emision());	
		pedidoAsignar.setfecha_entrega(pedido.getfecha_entrega());	
		pedidoAsignar.setid_moneda(pedido.getid_moneda());
		pedidoAsignar.setmoneda_descripcion(pedido.getmoneda_descripcion());	
		pedidoAsignar.setcotizacion(pedido.getcotizacion());	
		pedidoAsignar.setid_empleado(pedido.getid_empleado());
		pedidoAsignar.setempleado_descripcion(pedido.getempleado_descripcion());	
		pedidoAsignar.setid_tipo_precio(pedido.getid_tipo_precio());
		pedidoAsignar.settipoprecio_descripcion(pedido.gettipoprecio_descripcion());	
		pedidoAsignar.setid_formato(pedido.getid_formato());
		pedidoAsignar.setformato_descripcion(pedido.getformato_descripcion());	
		pedidoAsignar.setdireccion(pedido.getdireccion());	
		pedidoAsignar.setid_cliente(pedido.getid_cliente());
		pedidoAsignar.setcliente_descripcion(pedido.getcliente_descripcion());	
		pedidoAsignar.settelefono(pedido.gettelefono());	
		pedidoAsignar.setruc(pedido.getruc());	
		pedidoAsignar.setid_sub_cliente(pedido.getid_sub_cliente());
		pedidoAsignar.setsubcliente_descripcion(pedido.getsubcliente_descripcion());	
		pedidoAsignar.setid_vendedor(pedido.getid_vendedor());
		pedidoAsignar.setvendedor_descripcion(pedido.getvendedor_descripcion());	
		pedidoAsignar.setid_consultor(pedido.getid_consultor());
		pedidoAsignar.setconsultor_descripcion(pedido.getconsultor_descripcion());	
		pedidoAsignar.setorden(pedido.getorden());	
		pedidoAsignar.setid_responsable(pedido.getid_responsable());
		pedidoAsignar.setresponsable_descripcion(pedido.getresponsable_descripcion());	
		pedidoAsignar.setid_estado_pedido(pedido.getid_estado_pedido());
		pedidoAsignar.setestadopedido_descripcion(pedido.getestadopedido_descripcion());	
		pedidoAsignar.setid_transporte(pedido.getid_transporte());
		pedidoAsignar.settransporte_descripcion(pedido.gettransporte_descripcion());	
		pedidoAsignar.setid_ruta_transporte(pedido.getid_ruta_transporte());
		pedidoAsignar.setrutatransporte_descripcion(pedido.getrutatransporte_descripcion());	
		pedidoAsignar.setvalor_ruta(pedido.getvalor_ruta());	
		pedidoAsignar.setid_tipo_llamada(pedido.getid_tipo_llamada());
		pedidoAsignar.settipollamada_descripcion(pedido.gettipollamada_descripcion());	
		pedidoAsignar.setid_transportista(pedido.getid_transportista());
		pedidoAsignar.settransportista_descripcion(pedido.gettransportista_descripcion());	
		pedidoAsignar.sethora_inicio(pedido.gethora_inicio());	
		pedidoAsignar.sethora_fin(pedido.gethora_fin());	
		pedidoAsignar.setdescripcion(pedido.getdescripcion());	
		pedidoAsignar.setcupo(pedido.getcupo());	
		pedidoAsignar.setsaldo(pedido.getsaldo());	
		pedidoAsignar.setpedidos(pedido.getpedidos());	
		pedidoAsignar.setdocumentos(pedido.getdocumentos());	
		pedidoAsignar.setdisponible(pedido.getdisponible());	
		pedidoAsignar.setdescuento_porcentaje(pedido.getdescuento_porcentaje());	
		pedidoAsignar.settotal_con_iva(pedido.gettotal_con_iva());	
		pedidoAsignar.setsuman(pedido.getsuman());	
		pedidoAsignar.setdescuento_valor(pedido.getdescuento_valor());	
		pedidoAsignar.settotal_sin_iva(pedido.gettotal_sin_iva());	
		pedidoAsignar.setdescuento_total(pedido.getdescuento_total());	
		pedidoAsignar.setflete(pedido.getflete());	
		pedidoAsignar.settotal(pedido.gettotal());	
		pedidoAsignar.setsubtotal(pedido.getsubtotal());	
		pedidoAsignar.setotro(pedido.getotro());	
		pedidoAsignar.setultimo_costo(pedido.getultimo_costo());	
		pedidoAsignar.setiva(pedido.getiva());	
		pedidoAsignar.setfinanciamiento(pedido.getfinanciamiento());	
		pedidoAsignar.setmargen_utilidad(pedido.getmargen_utilidad());	
		pedidoAsignar.setotros_valores(pedido.getotros_valores());	
		pedidoAsignar.setanticipo(pedido.getanticipo());	
		pedidoAsignar.setid_tipo_cambio(pedido.getid_tipo_cambio());
		pedidoAsignar.settipocambio_descripcion(pedido.gettipocambio_descripcion());	
		pedidoAsignar.setid_centro_costo(pedido.getid_centro_costo());
		pedidoAsignar.setcentrocosto_descripcion(pedido.getcentrocosto_descripcion());	
		pedidoAsignar.setid_zona(pedido.getid_zona());
		pedidoAsignar.setzona_descripcion(pedido.getzona_descripcion());	
		pedidoAsignar.setfecha(pedido.getfecha());	
		pedidoAsignar.setnumero_fue(pedido.getnumero_fue());	
		pedidoAsignar.setfecha_servidor(pedido.getfecha_servidor());	
		pedidoAsignar.setmonto_retencion(pedido.getmonto_retencion());	
		pedidoAsignar.setice(pedido.getice());	
	}
	
	public static void inicializarPedido(Pedido pedido) throws Exception {
		try {
				pedido.setId(0L);	
					
				pedido.setid_empresa(-1L);	
				pedido.setid_sucursal(-1L);	
				pedido.setid_ejercicio(-1L);	
				pedido.setid_periodo(-1L);	
				pedido.setid_anio(null);	
				pedido.setid_mes(null);	
				pedido.setid_usuario(-1L);	
				pedido.setnumero("");	
				pedido.setpre_impreso("");	
				pedido.setfecha_emision(new Date());	
				pedido.setfecha_entrega(new Date());	
				pedido.setid_moneda(-1L);	
				pedido.setcotizacion(0.0);	
				pedido.setid_empleado(-1L);	
				pedido.setid_tipo_precio(-1L);	
				pedido.setid_formato(null);	
				pedido.setdireccion("");	
				pedido.setid_cliente(-1L);	
				pedido.settelefono("");	
				pedido.setruc("");	
				pedido.setid_sub_cliente(null);	
				pedido.setid_vendedor(null);	
				pedido.setid_consultor(null);	
				pedido.setorden("");	
				pedido.setid_responsable(null);	
				pedido.setid_estado_pedido(1L);	
				pedido.setid_transporte(null);	
				pedido.setid_ruta_transporte(null);	
				pedido.setvalor_ruta(0.0);	
				pedido.setid_tipo_llamada(null);	
				pedido.setid_transportista(null);	
				pedido.sethora_inicio(new Time((new Date()).getTime()));	
				pedido.sethora_fin(new Time((new Date()).getTime()));	
				pedido.setdescripcion("");	
				pedido.setcupo(0.0);	
				pedido.setsaldo(0.0);	
				pedido.setpedidos(0.0);	
				pedido.setdocumentos(0.0);	
				pedido.setdisponible(0.0);	
				pedido.setdescuento_porcentaje(0.0);	
				pedido.settotal_con_iva(0.0);	
				pedido.setsuman(0.0);	
				pedido.setdescuento_valor(0.0);	
				pedido.settotal_sin_iva(0.0);	
				pedido.setdescuento_total(0.0);	
				pedido.setflete(0.0);	
				pedido.settotal(0.0);	
				pedido.setsubtotal(0.0);	
				pedido.setotro(0.0);	
				pedido.setultimo_costo(0.0);	
				pedido.setiva(0.0);	
				pedido.setfinanciamiento(0.0);	
				pedido.setmargen_utilidad(0.0);	
				pedido.setotros_valores(0.0);	
				pedido.setanticipo(0.0);	
				pedido.setid_tipo_cambio(null);	
				pedido.setid_centro_costo(null);	
				pedido.setid_zona(null);	
				pedido.setfecha(new Date());	
				pedido.setnumero_fue("");	
				pedido.setfecha_servidor(new Date());	
				pedido.setmonto_retencion(0.0);	
				pedido.setice(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPedido(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_PREIMPRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_FECHAENTREGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_COTIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDTIPOPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDSUBCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDCONSULTOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_ORDEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDRESPONSABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDESTADOPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDTRANSPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDRUTATRANSPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_VALORRUTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDTIPOLLAMADA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDTRANSPORTISTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_HORAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_HORAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_CUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_SALDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_PEDIDOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_DOCUMENTOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_DISPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_TOTALCONIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_SUMAN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_DESCUENTOVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_TOTALSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_DESCUENTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_OTRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_ULTIMOCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_FINANCIAMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_MARGENUTILIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_OTROSVALORES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_ANTICIPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDTIPOCAMBIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_IDZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_NUMEROFUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_FECHASERVIDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_MONTORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPedido(String sTipo,Row row,Workbook workbook,Pedido pedido,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getpre_impreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getfecha_entrega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getcotizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.gettipoprecio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getsubcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getconsultor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getorden());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getresponsable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getestadopedido_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.gettransporte_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getrutatransporte_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getvalor_ruta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.gettipollamada_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.gettransportista_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.gethora_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.gethora_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getcupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getsaldo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getpedidos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getdocumentos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getdisponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getdescuento_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.gettotal_con_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getsuman());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getdescuento_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.gettotal_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getdescuento_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getsubtotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getotro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getultimo_costo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getfinanciamiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getmargen_utilidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getotros_valores());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getanticipo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.gettipocambio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getzona_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getnumero_fue());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getfecha_servidor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getmonto_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedido.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPedido=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPedido() {
		return this.sFinalQueryPedido;
	}
	
	public void setsFinalQueryPedido(String sFinalQueryPedido) {
		this.sFinalQueryPedido= sFinalQueryPedido;
	}
	
	public Border resaltarSeleccionarPedido=null;
	
	public Border setResaltarSeleccionarPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPedido= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPedido() {
		return this.resaltarSeleccionarPedido;
	}
	
	public void setResaltarSeleccionarPedido(Border borderResaltarSeleccionarPedido) {
		this.resaltarSeleccionarPedido= borderResaltarSeleccionarPedido;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPedido=null;
	public Boolean mostraridPedido=true;
	public Boolean activaridPedido=true;

	public Border resaltarid_empresaPedido=null;
	public Boolean mostrarid_empresaPedido=true;
	public Boolean activarid_empresaPedido=true;
	public Boolean cargarid_empresaPedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPedido=false;//ConEventDepend=true

	public Border resaltarid_sucursalPedido=null;
	public Boolean mostrarid_sucursalPedido=true;
	public Boolean activarid_sucursalPedido=true;
	public Boolean cargarid_sucursalPedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPedido=false;//ConEventDepend=true

	public Border resaltarid_ejercicioPedido=null;
	public Boolean mostrarid_ejercicioPedido=true;
	public Boolean activarid_ejercicioPedido=true;
	public Boolean cargarid_ejercicioPedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioPedido=false;//ConEventDepend=true

	public Border resaltarid_periodoPedido=null;
	public Boolean mostrarid_periodoPedido=true;
	public Boolean activarid_periodoPedido=true;
	public Boolean cargarid_periodoPedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoPedido=false;//ConEventDepend=true

	public Border resaltarid_anioPedido=null;
	public Boolean mostrarid_anioPedido=true;
	public Boolean activarid_anioPedido=false;
	public Boolean cargarid_anioPedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioPedido=false;//ConEventDepend=true

	public Border resaltarid_mesPedido=null;
	public Boolean mostrarid_mesPedido=true;
	public Boolean activarid_mesPedido=false;
	public Boolean cargarid_mesPedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesPedido=false;//ConEventDepend=true

	public Border resaltarid_usuarioPedido=null;
	public Boolean mostrarid_usuarioPedido=true;
	public Boolean activarid_usuarioPedido=true;
	public Boolean cargarid_usuarioPedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioPedido=false;//ConEventDepend=true

	public Border resaltarnumeroPedido=null;
	public Boolean mostrarnumeroPedido=true;
	public Boolean activarnumeroPedido=true;

	public Border resaltarpre_impresoPedido=null;
	public Boolean mostrarpre_impresoPedido=true;
	public Boolean activarpre_impresoPedido=true;

	public Border resaltarfecha_emisionPedido=null;
	public Boolean mostrarfecha_emisionPedido=true;
	public Boolean activarfecha_emisionPedido=true;

	public Border resaltarfecha_entregaPedido=null;
	public Boolean mostrarfecha_entregaPedido=true;
	public Boolean activarfecha_entregaPedido=true;

	public Border resaltarid_monedaPedido=null;
	public Boolean mostrarid_monedaPedido=true;
	public Boolean activarid_monedaPedido=true;
	public Boolean cargarid_monedaPedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaPedido=false;//ConEventDepend=true

	public Border resaltarcotizacionPedido=null;
	public Boolean mostrarcotizacionPedido=true;
	public Boolean activarcotizacionPedido=true;

	public Border resaltarid_empleadoPedido=null;
	public Boolean mostrarid_empleadoPedido=true;
	public Boolean activarid_empleadoPedido=true;
	public Boolean cargarid_empleadoPedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoPedido=false;//ConEventDepend=true

	public Border resaltarid_tipo_precioPedido=null;
	public Boolean mostrarid_tipo_precioPedido=true;
	public Boolean activarid_tipo_precioPedido=true;
	public Boolean cargarid_tipo_precioPedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_precioPedido=false;//ConEventDepend=true

	public Border resaltarid_formatoPedido=null;
	public Boolean mostrarid_formatoPedido=true;
	public Boolean activarid_formatoPedido=true;
	public Boolean cargarid_formatoPedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoPedido=false;//ConEventDepend=true

	public Border resaltardireccionPedido=null;
	public Boolean mostrardireccionPedido=true;
	public Boolean activardireccionPedido=true;

	public Border resaltarid_clientePedido=null;
	public Boolean mostrarid_clientePedido=true;
	public Boolean activarid_clientePedido=true;
	public Boolean cargarid_clientePedido=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clientePedido=false;//ConEventDepend=true

	public Border resaltartelefonoPedido=null;
	public Boolean mostrartelefonoPedido=true;
	public Boolean activartelefonoPedido=true;

	public Border resaltarrucPedido=null;
	public Boolean mostrarrucPedido=true;
	public Boolean activarrucPedido=true;

	public Border resaltarid_sub_clientePedido=null;
	public Boolean mostrarid_sub_clientePedido=true;
	public Boolean activarid_sub_clientePedido=true;
	public Boolean cargarid_sub_clientePedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sub_clientePedido=false;//ConEventDepend=true

	public Border resaltarid_vendedorPedido=null;
	public Boolean mostrarid_vendedorPedido=true;
	public Boolean activarid_vendedorPedido=true;
	public Boolean cargarid_vendedorPedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorPedido=false;//ConEventDepend=true

	public Border resaltarid_consultorPedido=null;
	public Boolean mostrarid_consultorPedido=true;
	public Boolean activarid_consultorPedido=true;
	public Boolean cargarid_consultorPedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_consultorPedido=false;//ConEventDepend=true

	public Border resaltarordenPedido=null;
	public Boolean mostrarordenPedido=true;
	public Boolean activarordenPedido=true;

	public Border resaltarid_responsablePedido=null;
	public Boolean mostrarid_responsablePedido=true;
	public Boolean activarid_responsablePedido=true;
	public Boolean cargarid_responsablePedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_responsablePedido=false;//ConEventDepend=true

	public Border resaltarid_estado_pedidoPedido=null;
	public Boolean mostrarid_estado_pedidoPedido=true;
	public Boolean activarid_estado_pedidoPedido=true;
	public Boolean cargarid_estado_pedidoPedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_pedidoPedido=false;//ConEventDepend=true

	public Border resaltarid_transportePedido=null;
	public Boolean mostrarid_transportePedido=true;
	public Boolean activarid_transportePedido=true;
	public Boolean cargarid_transportePedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transportePedido=false;//ConEventDepend=true

	public Border resaltarid_ruta_transportePedido=null;
	public Boolean mostrarid_ruta_transportePedido=true;
	public Boolean activarid_ruta_transportePedido=true;
	public Boolean cargarid_ruta_transportePedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ruta_transportePedido=false;//ConEventDepend=true

	public Border resaltarvalor_rutaPedido=null;
	public Boolean mostrarvalor_rutaPedido=true;
	public Boolean activarvalor_rutaPedido=true;

	public Border resaltarid_tipo_llamadaPedido=null;
	public Boolean mostrarid_tipo_llamadaPedido=true;
	public Boolean activarid_tipo_llamadaPedido=true;
	public Boolean cargarid_tipo_llamadaPedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_llamadaPedido=false;//ConEventDepend=true

	public Border resaltarid_transportistaPedido=null;
	public Boolean mostrarid_transportistaPedido=true;
	public Boolean activarid_transportistaPedido=true;
	public Boolean cargarid_transportistaPedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transportistaPedido=false;//ConEventDepend=true

	public Border resaltarhora_inicioPedido=null;
	public Boolean mostrarhora_inicioPedido=true;
	public Boolean activarhora_inicioPedido=true;

	public Border resaltarhora_finPedido=null;
	public Boolean mostrarhora_finPedido=true;
	public Boolean activarhora_finPedido=true;

	public Border resaltardescripcionPedido=null;
	public Boolean mostrardescripcionPedido=true;
	public Boolean activardescripcionPedido=true;

	public Border resaltarcupoPedido=null;
	public Boolean mostrarcupoPedido=true;
	public Boolean activarcupoPedido=true;

	public Border resaltarsaldoPedido=null;
	public Boolean mostrarsaldoPedido=true;
	public Boolean activarsaldoPedido=true;

	public Border resaltarpedidosPedido=null;
	public Boolean mostrarpedidosPedido=true;
	public Boolean activarpedidosPedido=true;

	public Border resaltardocumentosPedido=null;
	public Boolean mostrardocumentosPedido=true;
	public Boolean activardocumentosPedido=true;

	public Border resaltardisponiblePedido=null;
	public Boolean mostrardisponiblePedido=true;
	public Boolean activardisponiblePedido=true;

	public Border resaltardescuento_porcentajePedido=null;
	public Boolean mostrardescuento_porcentajePedido=true;
	public Boolean activardescuento_porcentajePedido=true;

	public Border resaltartotal_con_ivaPedido=null;
	public Boolean mostrartotal_con_ivaPedido=true;
	public Boolean activartotal_con_ivaPedido=true;

	public Border resaltarsumanPedido=null;
	public Boolean mostrarsumanPedido=true;
	public Boolean activarsumanPedido=true;

	public Border resaltardescuento_valorPedido=null;
	public Boolean mostrardescuento_valorPedido=true;
	public Boolean activardescuento_valorPedido=true;

	public Border resaltartotal_sin_ivaPedido=null;
	public Boolean mostrartotal_sin_ivaPedido=true;
	public Boolean activartotal_sin_ivaPedido=true;

	public Border resaltardescuento_totalPedido=null;
	public Boolean mostrardescuento_totalPedido=true;
	public Boolean activardescuento_totalPedido=true;

	public Border resaltarfletePedido=null;
	public Boolean mostrarfletePedido=true;
	public Boolean activarfletePedido=true;

	public Border resaltartotalPedido=null;
	public Boolean mostrartotalPedido=true;
	public Boolean activartotalPedido=true;

	public Border resaltarsubtotalPedido=null;
	public Boolean mostrarsubtotalPedido=true;
	public Boolean activarsubtotalPedido=true;

	public Border resaltarotroPedido=null;
	public Boolean mostrarotroPedido=true;
	public Boolean activarotroPedido=true;

	public Border resaltarultimo_costoPedido=null;
	public Boolean mostrarultimo_costoPedido=true;
	public Boolean activarultimo_costoPedido=true;

	public Border resaltarivaPedido=null;
	public Boolean mostrarivaPedido=true;
	public Boolean activarivaPedido=true;

	public Border resaltarfinanciamientoPedido=null;
	public Boolean mostrarfinanciamientoPedido=true;
	public Boolean activarfinanciamientoPedido=true;

	public Border resaltarmargen_utilidadPedido=null;
	public Boolean mostrarmargen_utilidadPedido=true;
	public Boolean activarmargen_utilidadPedido=true;

	public Border resaltarotros_valoresPedido=null;
	public Boolean mostrarotros_valoresPedido=true;
	public Boolean activarotros_valoresPedido=true;

	public Border resaltaranticipoPedido=null;
	public Boolean mostraranticipoPedido=true;
	public Boolean activaranticipoPedido=true;

	public Border resaltarid_tipo_cambioPedido=null;
	public Boolean mostrarid_tipo_cambioPedido=true;
	public Boolean activarid_tipo_cambioPedido=false;
	public Boolean cargarid_tipo_cambioPedido=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cambioPedido=false;//ConEventDepend=true

	public Border resaltarid_centro_costoPedido=null;
	public Boolean mostrarid_centro_costoPedido=true;
	public Boolean activarid_centro_costoPedido=false;
	public Boolean cargarid_centro_costoPedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoPedido=false;//ConEventDepend=true

	public Border resaltarid_zonaPedido=null;
	public Boolean mostrarid_zonaPedido=true;
	public Boolean activarid_zonaPedido=false;
	public Boolean cargarid_zonaPedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_zonaPedido=false;//ConEventDepend=true

	public Border resaltarfechaPedido=null;
	public Boolean mostrarfechaPedido=true;
	public Boolean activarfechaPedido=false;

	public Border resaltarnumero_fuePedido=null;
	public Boolean mostrarnumero_fuePedido=true;
	public Boolean activarnumero_fuePedido=false;

	public Border resaltarfecha_servidorPedido=null;
	public Boolean mostrarfecha_servidorPedido=true;
	public Boolean activarfecha_servidorPedido=false;

	public Border resaltarmonto_retencionPedido=null;
	public Boolean mostrarmonto_retencionPedido=true;
	public Boolean activarmonto_retencionPedido=false;

	public Border resaltaricePedido=null;
	public Boolean mostraricePedido=true;
	public Boolean activaricePedido=false;

	
	

	public Border setResaltaridPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltaridPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPedido() {
		return this.resaltaridPedido;
	}

	public void setResaltaridPedido(Border borderResaltar) {
		this.resaltaridPedido= borderResaltar;
	}

	public Boolean getMostraridPedido() {
		return this.mostraridPedido;
	}

	public void setMostraridPedido(Boolean mostraridPedido) {
		this.mostraridPedido= mostraridPedido;
	}

	public Boolean getActivaridPedido() {
		return this.activaridPedido;
	}

	public void setActivaridPedido(Boolean activaridPedido) {
		this.activaridPedido= activaridPedido;
	}

	public Border setResaltarid_empresaPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_empresaPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPedido() {
		return this.resaltarid_empresaPedido;
	}

	public void setResaltarid_empresaPedido(Border borderResaltar) {
		this.resaltarid_empresaPedido= borderResaltar;
	}

	public Boolean getMostrarid_empresaPedido() {
		return this.mostrarid_empresaPedido;
	}

	public void setMostrarid_empresaPedido(Boolean mostrarid_empresaPedido) {
		this.mostrarid_empresaPedido= mostrarid_empresaPedido;
	}

	public Boolean getActivarid_empresaPedido() {
		return this.activarid_empresaPedido;
	}

	public void setActivarid_empresaPedido(Boolean activarid_empresaPedido) {
		this.activarid_empresaPedido= activarid_empresaPedido;
	}

	public Boolean getCargarid_empresaPedido() {
		return this.cargarid_empresaPedido;
	}

	public void setCargarid_empresaPedido(Boolean cargarid_empresaPedido) {
		this.cargarid_empresaPedido= cargarid_empresaPedido;
	}

	public Border setResaltarid_sucursalPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPedido() {
		return this.resaltarid_sucursalPedido;
	}

	public void setResaltarid_sucursalPedido(Border borderResaltar) {
		this.resaltarid_sucursalPedido= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPedido() {
		return this.mostrarid_sucursalPedido;
	}

	public void setMostrarid_sucursalPedido(Boolean mostrarid_sucursalPedido) {
		this.mostrarid_sucursalPedido= mostrarid_sucursalPedido;
	}

	public Boolean getActivarid_sucursalPedido() {
		return this.activarid_sucursalPedido;
	}

	public void setActivarid_sucursalPedido(Boolean activarid_sucursalPedido) {
		this.activarid_sucursalPedido= activarid_sucursalPedido;
	}

	public Boolean getCargarid_sucursalPedido() {
		return this.cargarid_sucursalPedido;
	}

	public void setCargarid_sucursalPedido(Boolean cargarid_sucursalPedido) {
		this.cargarid_sucursalPedido= cargarid_sucursalPedido;
	}

	public Border setResaltarid_ejercicioPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioPedido() {
		return this.resaltarid_ejercicioPedido;
	}

	public void setResaltarid_ejercicioPedido(Border borderResaltar) {
		this.resaltarid_ejercicioPedido= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioPedido() {
		return this.mostrarid_ejercicioPedido;
	}

	public void setMostrarid_ejercicioPedido(Boolean mostrarid_ejercicioPedido) {
		this.mostrarid_ejercicioPedido= mostrarid_ejercicioPedido;
	}

	public Boolean getActivarid_ejercicioPedido() {
		return this.activarid_ejercicioPedido;
	}

	public void setActivarid_ejercicioPedido(Boolean activarid_ejercicioPedido) {
		this.activarid_ejercicioPedido= activarid_ejercicioPedido;
	}

	public Boolean getCargarid_ejercicioPedido() {
		return this.cargarid_ejercicioPedido;
	}

	public void setCargarid_ejercicioPedido(Boolean cargarid_ejercicioPedido) {
		this.cargarid_ejercicioPedido= cargarid_ejercicioPedido;
	}

	public Border setResaltarid_periodoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_periodoPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoPedido() {
		return this.resaltarid_periodoPedido;
	}

	public void setResaltarid_periodoPedido(Border borderResaltar) {
		this.resaltarid_periodoPedido= borderResaltar;
	}

	public Boolean getMostrarid_periodoPedido() {
		return this.mostrarid_periodoPedido;
	}

	public void setMostrarid_periodoPedido(Boolean mostrarid_periodoPedido) {
		this.mostrarid_periodoPedido= mostrarid_periodoPedido;
	}

	public Boolean getActivarid_periodoPedido() {
		return this.activarid_periodoPedido;
	}

	public void setActivarid_periodoPedido(Boolean activarid_periodoPedido) {
		this.activarid_periodoPedido= activarid_periodoPedido;
	}

	public Boolean getCargarid_periodoPedido() {
		return this.cargarid_periodoPedido;
	}

	public void setCargarid_periodoPedido(Boolean cargarid_periodoPedido) {
		this.cargarid_periodoPedido= cargarid_periodoPedido;
	}

	public Border setResaltarid_anioPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_anioPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioPedido() {
		return this.resaltarid_anioPedido;
	}

	public void setResaltarid_anioPedido(Border borderResaltar) {
		this.resaltarid_anioPedido= borderResaltar;
	}

	public Boolean getMostrarid_anioPedido() {
		return this.mostrarid_anioPedido;
	}

	public void setMostrarid_anioPedido(Boolean mostrarid_anioPedido) {
		this.mostrarid_anioPedido= mostrarid_anioPedido;
	}

	public Boolean getActivarid_anioPedido() {
		return this.activarid_anioPedido;
	}

	public void setActivarid_anioPedido(Boolean activarid_anioPedido) {
		this.activarid_anioPedido= activarid_anioPedido;
	}

	public Boolean getCargarid_anioPedido() {
		return this.cargarid_anioPedido;
	}

	public void setCargarid_anioPedido(Boolean cargarid_anioPedido) {
		this.cargarid_anioPedido= cargarid_anioPedido;
	}

	public Border setResaltarid_mesPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_mesPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesPedido() {
		return this.resaltarid_mesPedido;
	}

	public void setResaltarid_mesPedido(Border borderResaltar) {
		this.resaltarid_mesPedido= borderResaltar;
	}

	public Boolean getMostrarid_mesPedido() {
		return this.mostrarid_mesPedido;
	}

	public void setMostrarid_mesPedido(Boolean mostrarid_mesPedido) {
		this.mostrarid_mesPedido= mostrarid_mesPedido;
	}

	public Boolean getActivarid_mesPedido() {
		return this.activarid_mesPedido;
	}

	public void setActivarid_mesPedido(Boolean activarid_mesPedido) {
		this.activarid_mesPedido= activarid_mesPedido;
	}

	public Boolean getCargarid_mesPedido() {
		return this.cargarid_mesPedido;
	}

	public void setCargarid_mesPedido(Boolean cargarid_mesPedido) {
		this.cargarid_mesPedido= cargarid_mesPedido;
	}

	public Border setResaltarid_usuarioPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_usuarioPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioPedido() {
		return this.resaltarid_usuarioPedido;
	}

	public void setResaltarid_usuarioPedido(Border borderResaltar) {
		this.resaltarid_usuarioPedido= borderResaltar;
	}

	public Boolean getMostrarid_usuarioPedido() {
		return this.mostrarid_usuarioPedido;
	}

	public void setMostrarid_usuarioPedido(Boolean mostrarid_usuarioPedido) {
		this.mostrarid_usuarioPedido= mostrarid_usuarioPedido;
	}

	public Boolean getActivarid_usuarioPedido() {
		return this.activarid_usuarioPedido;
	}

	public void setActivarid_usuarioPedido(Boolean activarid_usuarioPedido) {
		this.activarid_usuarioPedido= activarid_usuarioPedido;
	}

	public Boolean getCargarid_usuarioPedido() {
		return this.cargarid_usuarioPedido;
	}

	public void setCargarid_usuarioPedido(Boolean cargarid_usuarioPedido) {
		this.cargarid_usuarioPedido= cargarid_usuarioPedido;
	}

	public Border setResaltarnumeroPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarnumeroPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroPedido() {
		return this.resaltarnumeroPedido;
	}

	public void setResaltarnumeroPedido(Border borderResaltar) {
		this.resaltarnumeroPedido= borderResaltar;
	}

	public Boolean getMostrarnumeroPedido() {
		return this.mostrarnumeroPedido;
	}

	public void setMostrarnumeroPedido(Boolean mostrarnumeroPedido) {
		this.mostrarnumeroPedido= mostrarnumeroPedido;
	}

	public Boolean getActivarnumeroPedido() {
		return this.activarnumeroPedido;
	}

	public void setActivarnumeroPedido(Boolean activarnumeroPedido) {
		this.activarnumeroPedido= activarnumeroPedido;
	}

	public Border setResaltarpre_impresoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarpre_impresoPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpre_impresoPedido() {
		return this.resaltarpre_impresoPedido;
	}

	public void setResaltarpre_impresoPedido(Border borderResaltar) {
		this.resaltarpre_impresoPedido= borderResaltar;
	}

	public Boolean getMostrarpre_impresoPedido() {
		return this.mostrarpre_impresoPedido;
	}

	public void setMostrarpre_impresoPedido(Boolean mostrarpre_impresoPedido) {
		this.mostrarpre_impresoPedido= mostrarpre_impresoPedido;
	}

	public Boolean getActivarpre_impresoPedido() {
		return this.activarpre_impresoPedido;
	}

	public void setActivarpre_impresoPedido(Boolean activarpre_impresoPedido) {
		this.activarpre_impresoPedido= activarpre_impresoPedido;
	}

	public Border setResaltarfecha_emisionPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionPedido() {
		return this.resaltarfecha_emisionPedido;
	}

	public void setResaltarfecha_emisionPedido(Border borderResaltar) {
		this.resaltarfecha_emisionPedido= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionPedido() {
		return this.mostrarfecha_emisionPedido;
	}

	public void setMostrarfecha_emisionPedido(Boolean mostrarfecha_emisionPedido) {
		this.mostrarfecha_emisionPedido= mostrarfecha_emisionPedido;
	}

	public Boolean getActivarfecha_emisionPedido() {
		return this.activarfecha_emisionPedido;
	}

	public void setActivarfecha_emisionPedido(Boolean activarfecha_emisionPedido) {
		this.activarfecha_emisionPedido= activarfecha_emisionPedido;
	}

	public Border setResaltarfecha_entregaPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarfecha_entregaPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_entregaPedido() {
		return this.resaltarfecha_entregaPedido;
	}

	public void setResaltarfecha_entregaPedido(Border borderResaltar) {
		this.resaltarfecha_entregaPedido= borderResaltar;
	}

	public Boolean getMostrarfecha_entregaPedido() {
		return this.mostrarfecha_entregaPedido;
	}

	public void setMostrarfecha_entregaPedido(Boolean mostrarfecha_entregaPedido) {
		this.mostrarfecha_entregaPedido= mostrarfecha_entregaPedido;
	}

	public Boolean getActivarfecha_entregaPedido() {
		return this.activarfecha_entregaPedido;
	}

	public void setActivarfecha_entregaPedido(Boolean activarfecha_entregaPedido) {
		this.activarfecha_entregaPedido= activarfecha_entregaPedido;
	}

	public Border setResaltarid_monedaPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_monedaPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaPedido() {
		return this.resaltarid_monedaPedido;
	}

	public void setResaltarid_monedaPedido(Border borderResaltar) {
		this.resaltarid_monedaPedido= borderResaltar;
	}

	public Boolean getMostrarid_monedaPedido() {
		return this.mostrarid_monedaPedido;
	}

	public void setMostrarid_monedaPedido(Boolean mostrarid_monedaPedido) {
		this.mostrarid_monedaPedido= mostrarid_monedaPedido;
	}

	public Boolean getActivarid_monedaPedido() {
		return this.activarid_monedaPedido;
	}

	public void setActivarid_monedaPedido(Boolean activarid_monedaPedido) {
		this.activarid_monedaPedido= activarid_monedaPedido;
	}

	public Boolean getCargarid_monedaPedido() {
		return this.cargarid_monedaPedido;
	}

	public void setCargarid_monedaPedido(Boolean cargarid_monedaPedido) {
		this.cargarid_monedaPedido= cargarid_monedaPedido;
	}

	public Border setResaltarcotizacionPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarcotizacionPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcotizacionPedido() {
		return this.resaltarcotizacionPedido;
	}

	public void setResaltarcotizacionPedido(Border borderResaltar) {
		this.resaltarcotizacionPedido= borderResaltar;
	}

	public Boolean getMostrarcotizacionPedido() {
		return this.mostrarcotizacionPedido;
	}

	public void setMostrarcotizacionPedido(Boolean mostrarcotizacionPedido) {
		this.mostrarcotizacionPedido= mostrarcotizacionPedido;
	}

	public Boolean getActivarcotizacionPedido() {
		return this.activarcotizacionPedido;
	}

	public void setActivarcotizacionPedido(Boolean activarcotizacionPedido) {
		this.activarcotizacionPedido= activarcotizacionPedido;
	}

	public Border setResaltarid_empleadoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_empleadoPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoPedido() {
		return this.resaltarid_empleadoPedido;
	}

	public void setResaltarid_empleadoPedido(Border borderResaltar) {
		this.resaltarid_empleadoPedido= borderResaltar;
	}

	public Boolean getMostrarid_empleadoPedido() {
		return this.mostrarid_empleadoPedido;
	}

	public void setMostrarid_empleadoPedido(Boolean mostrarid_empleadoPedido) {
		this.mostrarid_empleadoPedido= mostrarid_empleadoPedido;
	}

	public Boolean getActivarid_empleadoPedido() {
		return this.activarid_empleadoPedido;
	}

	public void setActivarid_empleadoPedido(Boolean activarid_empleadoPedido) {
		this.activarid_empleadoPedido= activarid_empleadoPedido;
	}

	public Boolean getCargarid_empleadoPedido() {
		return this.cargarid_empleadoPedido;
	}

	public void setCargarid_empleadoPedido(Boolean cargarid_empleadoPedido) {
		this.cargarid_empleadoPedido= cargarid_empleadoPedido;
	}

	public Border setResaltarid_tipo_precioPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_tipo_precioPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_precioPedido() {
		return this.resaltarid_tipo_precioPedido;
	}

	public void setResaltarid_tipo_precioPedido(Border borderResaltar) {
		this.resaltarid_tipo_precioPedido= borderResaltar;
	}

	public Boolean getMostrarid_tipo_precioPedido() {
		return this.mostrarid_tipo_precioPedido;
	}

	public void setMostrarid_tipo_precioPedido(Boolean mostrarid_tipo_precioPedido) {
		this.mostrarid_tipo_precioPedido= mostrarid_tipo_precioPedido;
	}

	public Boolean getActivarid_tipo_precioPedido() {
		return this.activarid_tipo_precioPedido;
	}

	public void setActivarid_tipo_precioPedido(Boolean activarid_tipo_precioPedido) {
		this.activarid_tipo_precioPedido= activarid_tipo_precioPedido;
	}

	public Boolean getCargarid_tipo_precioPedido() {
		return this.cargarid_tipo_precioPedido;
	}

	public void setCargarid_tipo_precioPedido(Boolean cargarid_tipo_precioPedido) {
		this.cargarid_tipo_precioPedido= cargarid_tipo_precioPedido;
	}

	public Border setResaltarid_formatoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_formatoPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoPedido() {
		return this.resaltarid_formatoPedido;
	}

	public void setResaltarid_formatoPedido(Border borderResaltar) {
		this.resaltarid_formatoPedido= borderResaltar;
	}

	public Boolean getMostrarid_formatoPedido() {
		return this.mostrarid_formatoPedido;
	}

	public void setMostrarid_formatoPedido(Boolean mostrarid_formatoPedido) {
		this.mostrarid_formatoPedido= mostrarid_formatoPedido;
	}

	public Boolean getActivarid_formatoPedido() {
		return this.activarid_formatoPedido;
	}

	public void setActivarid_formatoPedido(Boolean activarid_formatoPedido) {
		this.activarid_formatoPedido= activarid_formatoPedido;
	}

	public Boolean getCargarid_formatoPedido() {
		return this.cargarid_formatoPedido;
	}

	public void setCargarid_formatoPedido(Boolean cargarid_formatoPedido) {
		this.cargarid_formatoPedido= cargarid_formatoPedido;
	}

	public Border setResaltardireccionPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltardireccionPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionPedido() {
		return this.resaltardireccionPedido;
	}

	public void setResaltardireccionPedido(Border borderResaltar) {
		this.resaltardireccionPedido= borderResaltar;
	}

	public Boolean getMostrardireccionPedido() {
		return this.mostrardireccionPedido;
	}

	public void setMostrardireccionPedido(Boolean mostrardireccionPedido) {
		this.mostrardireccionPedido= mostrardireccionPedido;
	}

	public Boolean getActivardireccionPedido() {
		return this.activardireccionPedido;
	}

	public void setActivardireccionPedido(Boolean activardireccionPedido) {
		this.activardireccionPedido= activardireccionPedido;
	}

	public Border setResaltarid_clientePedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_clientePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clientePedido() {
		return this.resaltarid_clientePedido;
	}

	public void setResaltarid_clientePedido(Border borderResaltar) {
		this.resaltarid_clientePedido= borderResaltar;
	}

	public Boolean getMostrarid_clientePedido() {
		return this.mostrarid_clientePedido;
	}

	public void setMostrarid_clientePedido(Boolean mostrarid_clientePedido) {
		this.mostrarid_clientePedido= mostrarid_clientePedido;
	}

	public Boolean getActivarid_clientePedido() {
		return this.activarid_clientePedido;
	}

	public void setActivarid_clientePedido(Boolean activarid_clientePedido) {
		this.activarid_clientePedido= activarid_clientePedido;
	}

	public Boolean getCargarid_clientePedido() {
		return this.cargarid_clientePedido;
	}

	public void setCargarid_clientePedido(Boolean cargarid_clientePedido) {
		this.cargarid_clientePedido= cargarid_clientePedido;
	}

	public Border setResaltartelefonoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltartelefonoPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoPedido() {
		return this.resaltartelefonoPedido;
	}

	public void setResaltartelefonoPedido(Border borderResaltar) {
		this.resaltartelefonoPedido= borderResaltar;
	}

	public Boolean getMostrartelefonoPedido() {
		return this.mostrartelefonoPedido;
	}

	public void setMostrartelefonoPedido(Boolean mostrartelefonoPedido) {
		this.mostrartelefonoPedido= mostrartelefonoPedido;
	}

	public Boolean getActivartelefonoPedido() {
		return this.activartelefonoPedido;
	}

	public void setActivartelefonoPedido(Boolean activartelefonoPedido) {
		this.activartelefonoPedido= activartelefonoPedido;
	}

	public Border setResaltarrucPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarrucPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucPedido() {
		return this.resaltarrucPedido;
	}

	public void setResaltarrucPedido(Border borderResaltar) {
		this.resaltarrucPedido= borderResaltar;
	}

	public Boolean getMostrarrucPedido() {
		return this.mostrarrucPedido;
	}

	public void setMostrarrucPedido(Boolean mostrarrucPedido) {
		this.mostrarrucPedido= mostrarrucPedido;
	}

	public Boolean getActivarrucPedido() {
		return this.activarrucPedido;
	}

	public void setActivarrucPedido(Boolean activarrucPedido) {
		this.activarrucPedido= activarrucPedido;
	}

	public Border setResaltarid_sub_clientePedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_sub_clientePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sub_clientePedido() {
		return this.resaltarid_sub_clientePedido;
	}

	public void setResaltarid_sub_clientePedido(Border borderResaltar) {
		this.resaltarid_sub_clientePedido= borderResaltar;
	}

	public Boolean getMostrarid_sub_clientePedido() {
		return this.mostrarid_sub_clientePedido;
	}

	public void setMostrarid_sub_clientePedido(Boolean mostrarid_sub_clientePedido) {
		this.mostrarid_sub_clientePedido= mostrarid_sub_clientePedido;
	}

	public Boolean getActivarid_sub_clientePedido() {
		return this.activarid_sub_clientePedido;
	}

	public void setActivarid_sub_clientePedido(Boolean activarid_sub_clientePedido) {
		this.activarid_sub_clientePedido= activarid_sub_clientePedido;
	}

	public Boolean getCargarid_sub_clientePedido() {
		return this.cargarid_sub_clientePedido;
	}

	public void setCargarid_sub_clientePedido(Boolean cargarid_sub_clientePedido) {
		this.cargarid_sub_clientePedido= cargarid_sub_clientePedido;
	}

	public Border setResaltarid_vendedorPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_vendedorPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorPedido() {
		return this.resaltarid_vendedorPedido;
	}

	public void setResaltarid_vendedorPedido(Border borderResaltar) {
		this.resaltarid_vendedorPedido= borderResaltar;
	}

	public Boolean getMostrarid_vendedorPedido() {
		return this.mostrarid_vendedorPedido;
	}

	public void setMostrarid_vendedorPedido(Boolean mostrarid_vendedorPedido) {
		this.mostrarid_vendedorPedido= mostrarid_vendedorPedido;
	}

	public Boolean getActivarid_vendedorPedido() {
		return this.activarid_vendedorPedido;
	}

	public void setActivarid_vendedorPedido(Boolean activarid_vendedorPedido) {
		this.activarid_vendedorPedido= activarid_vendedorPedido;
	}

	public Boolean getCargarid_vendedorPedido() {
		return this.cargarid_vendedorPedido;
	}

	public void setCargarid_vendedorPedido(Boolean cargarid_vendedorPedido) {
		this.cargarid_vendedorPedido= cargarid_vendedorPedido;
	}

	public Border setResaltarid_consultorPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_consultorPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_consultorPedido() {
		return this.resaltarid_consultorPedido;
	}

	public void setResaltarid_consultorPedido(Border borderResaltar) {
		this.resaltarid_consultorPedido= borderResaltar;
	}

	public Boolean getMostrarid_consultorPedido() {
		return this.mostrarid_consultorPedido;
	}

	public void setMostrarid_consultorPedido(Boolean mostrarid_consultorPedido) {
		this.mostrarid_consultorPedido= mostrarid_consultorPedido;
	}

	public Boolean getActivarid_consultorPedido() {
		return this.activarid_consultorPedido;
	}

	public void setActivarid_consultorPedido(Boolean activarid_consultorPedido) {
		this.activarid_consultorPedido= activarid_consultorPedido;
	}

	public Boolean getCargarid_consultorPedido() {
		return this.cargarid_consultorPedido;
	}

	public void setCargarid_consultorPedido(Boolean cargarid_consultorPedido) {
		this.cargarid_consultorPedido= cargarid_consultorPedido;
	}

	public Border setResaltarordenPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarordenPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarordenPedido() {
		return this.resaltarordenPedido;
	}

	public void setResaltarordenPedido(Border borderResaltar) {
		this.resaltarordenPedido= borderResaltar;
	}

	public Boolean getMostrarordenPedido() {
		return this.mostrarordenPedido;
	}

	public void setMostrarordenPedido(Boolean mostrarordenPedido) {
		this.mostrarordenPedido= mostrarordenPedido;
	}

	public Boolean getActivarordenPedido() {
		return this.activarordenPedido;
	}

	public void setActivarordenPedido(Boolean activarordenPedido) {
		this.activarordenPedido= activarordenPedido;
	}

	public Border setResaltarid_responsablePedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_responsablePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_responsablePedido() {
		return this.resaltarid_responsablePedido;
	}

	public void setResaltarid_responsablePedido(Border borderResaltar) {
		this.resaltarid_responsablePedido= borderResaltar;
	}

	public Boolean getMostrarid_responsablePedido() {
		return this.mostrarid_responsablePedido;
	}

	public void setMostrarid_responsablePedido(Boolean mostrarid_responsablePedido) {
		this.mostrarid_responsablePedido= mostrarid_responsablePedido;
	}

	public Boolean getActivarid_responsablePedido() {
		return this.activarid_responsablePedido;
	}

	public void setActivarid_responsablePedido(Boolean activarid_responsablePedido) {
		this.activarid_responsablePedido= activarid_responsablePedido;
	}

	public Boolean getCargarid_responsablePedido() {
		return this.cargarid_responsablePedido;
	}

	public void setCargarid_responsablePedido(Boolean cargarid_responsablePedido) {
		this.cargarid_responsablePedido= cargarid_responsablePedido;
	}

	public Border setResaltarid_estado_pedidoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_estado_pedidoPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_pedidoPedido() {
		return this.resaltarid_estado_pedidoPedido;
	}

	public void setResaltarid_estado_pedidoPedido(Border borderResaltar) {
		this.resaltarid_estado_pedidoPedido= borderResaltar;
	}

	public Boolean getMostrarid_estado_pedidoPedido() {
		return this.mostrarid_estado_pedidoPedido;
	}

	public void setMostrarid_estado_pedidoPedido(Boolean mostrarid_estado_pedidoPedido) {
		this.mostrarid_estado_pedidoPedido= mostrarid_estado_pedidoPedido;
	}

	public Boolean getActivarid_estado_pedidoPedido() {
		return this.activarid_estado_pedidoPedido;
	}

	public void setActivarid_estado_pedidoPedido(Boolean activarid_estado_pedidoPedido) {
		this.activarid_estado_pedidoPedido= activarid_estado_pedidoPedido;
	}

	public Boolean getCargarid_estado_pedidoPedido() {
		return this.cargarid_estado_pedidoPedido;
	}

	public void setCargarid_estado_pedidoPedido(Boolean cargarid_estado_pedidoPedido) {
		this.cargarid_estado_pedidoPedido= cargarid_estado_pedidoPedido;
	}

	public Border setResaltarid_transportePedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_transportePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transportePedido() {
		return this.resaltarid_transportePedido;
	}

	public void setResaltarid_transportePedido(Border borderResaltar) {
		this.resaltarid_transportePedido= borderResaltar;
	}

	public Boolean getMostrarid_transportePedido() {
		return this.mostrarid_transportePedido;
	}

	public void setMostrarid_transportePedido(Boolean mostrarid_transportePedido) {
		this.mostrarid_transportePedido= mostrarid_transportePedido;
	}

	public Boolean getActivarid_transportePedido() {
		return this.activarid_transportePedido;
	}

	public void setActivarid_transportePedido(Boolean activarid_transportePedido) {
		this.activarid_transportePedido= activarid_transportePedido;
	}

	public Boolean getCargarid_transportePedido() {
		return this.cargarid_transportePedido;
	}

	public void setCargarid_transportePedido(Boolean cargarid_transportePedido) {
		this.cargarid_transportePedido= cargarid_transportePedido;
	}

	public Border setResaltarid_ruta_transportePedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_ruta_transportePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ruta_transportePedido() {
		return this.resaltarid_ruta_transportePedido;
	}

	public void setResaltarid_ruta_transportePedido(Border borderResaltar) {
		this.resaltarid_ruta_transportePedido= borderResaltar;
	}

	public Boolean getMostrarid_ruta_transportePedido() {
		return this.mostrarid_ruta_transportePedido;
	}

	public void setMostrarid_ruta_transportePedido(Boolean mostrarid_ruta_transportePedido) {
		this.mostrarid_ruta_transportePedido= mostrarid_ruta_transportePedido;
	}

	public Boolean getActivarid_ruta_transportePedido() {
		return this.activarid_ruta_transportePedido;
	}

	public void setActivarid_ruta_transportePedido(Boolean activarid_ruta_transportePedido) {
		this.activarid_ruta_transportePedido= activarid_ruta_transportePedido;
	}

	public Boolean getCargarid_ruta_transportePedido() {
		return this.cargarid_ruta_transportePedido;
	}

	public void setCargarid_ruta_transportePedido(Boolean cargarid_ruta_transportePedido) {
		this.cargarid_ruta_transportePedido= cargarid_ruta_transportePedido;
	}

	public Border setResaltarvalor_rutaPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarvalor_rutaPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_rutaPedido() {
		return this.resaltarvalor_rutaPedido;
	}

	public void setResaltarvalor_rutaPedido(Border borderResaltar) {
		this.resaltarvalor_rutaPedido= borderResaltar;
	}

	public Boolean getMostrarvalor_rutaPedido() {
		return this.mostrarvalor_rutaPedido;
	}

	public void setMostrarvalor_rutaPedido(Boolean mostrarvalor_rutaPedido) {
		this.mostrarvalor_rutaPedido= mostrarvalor_rutaPedido;
	}

	public Boolean getActivarvalor_rutaPedido() {
		return this.activarvalor_rutaPedido;
	}

	public void setActivarvalor_rutaPedido(Boolean activarvalor_rutaPedido) {
		this.activarvalor_rutaPedido= activarvalor_rutaPedido;
	}

	public Border setResaltarid_tipo_llamadaPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_tipo_llamadaPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_llamadaPedido() {
		return this.resaltarid_tipo_llamadaPedido;
	}

	public void setResaltarid_tipo_llamadaPedido(Border borderResaltar) {
		this.resaltarid_tipo_llamadaPedido= borderResaltar;
	}

	public Boolean getMostrarid_tipo_llamadaPedido() {
		return this.mostrarid_tipo_llamadaPedido;
	}

	public void setMostrarid_tipo_llamadaPedido(Boolean mostrarid_tipo_llamadaPedido) {
		this.mostrarid_tipo_llamadaPedido= mostrarid_tipo_llamadaPedido;
	}

	public Boolean getActivarid_tipo_llamadaPedido() {
		return this.activarid_tipo_llamadaPedido;
	}

	public void setActivarid_tipo_llamadaPedido(Boolean activarid_tipo_llamadaPedido) {
		this.activarid_tipo_llamadaPedido= activarid_tipo_llamadaPedido;
	}

	public Boolean getCargarid_tipo_llamadaPedido() {
		return this.cargarid_tipo_llamadaPedido;
	}

	public void setCargarid_tipo_llamadaPedido(Boolean cargarid_tipo_llamadaPedido) {
		this.cargarid_tipo_llamadaPedido= cargarid_tipo_llamadaPedido;
	}

	public Border setResaltarid_transportistaPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_transportistaPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transportistaPedido() {
		return this.resaltarid_transportistaPedido;
	}

	public void setResaltarid_transportistaPedido(Border borderResaltar) {
		this.resaltarid_transportistaPedido= borderResaltar;
	}

	public Boolean getMostrarid_transportistaPedido() {
		return this.mostrarid_transportistaPedido;
	}

	public void setMostrarid_transportistaPedido(Boolean mostrarid_transportistaPedido) {
		this.mostrarid_transportistaPedido= mostrarid_transportistaPedido;
	}

	public Boolean getActivarid_transportistaPedido() {
		return this.activarid_transportistaPedido;
	}

	public void setActivarid_transportistaPedido(Boolean activarid_transportistaPedido) {
		this.activarid_transportistaPedido= activarid_transportistaPedido;
	}

	public Boolean getCargarid_transportistaPedido() {
		return this.cargarid_transportistaPedido;
	}

	public void setCargarid_transportistaPedido(Boolean cargarid_transportistaPedido) {
		this.cargarid_transportistaPedido= cargarid_transportistaPedido;
	}

	public Border setResaltarhora_inicioPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarhora_inicioPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_inicioPedido() {
		return this.resaltarhora_inicioPedido;
	}

	public void setResaltarhora_inicioPedido(Border borderResaltar) {
		this.resaltarhora_inicioPedido= borderResaltar;
	}

	public Boolean getMostrarhora_inicioPedido() {
		return this.mostrarhora_inicioPedido;
	}

	public void setMostrarhora_inicioPedido(Boolean mostrarhora_inicioPedido) {
		this.mostrarhora_inicioPedido= mostrarhora_inicioPedido;
	}

	public Boolean getActivarhora_inicioPedido() {
		return this.activarhora_inicioPedido;
	}

	public void setActivarhora_inicioPedido(Boolean activarhora_inicioPedido) {
		this.activarhora_inicioPedido= activarhora_inicioPedido;
	}

	public Border setResaltarhora_finPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarhora_finPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_finPedido() {
		return this.resaltarhora_finPedido;
	}

	public void setResaltarhora_finPedido(Border borderResaltar) {
		this.resaltarhora_finPedido= borderResaltar;
	}

	public Boolean getMostrarhora_finPedido() {
		return this.mostrarhora_finPedido;
	}

	public void setMostrarhora_finPedido(Boolean mostrarhora_finPedido) {
		this.mostrarhora_finPedido= mostrarhora_finPedido;
	}

	public Boolean getActivarhora_finPedido() {
		return this.activarhora_finPedido;
	}

	public void setActivarhora_finPedido(Boolean activarhora_finPedido) {
		this.activarhora_finPedido= activarhora_finPedido;
	}

	public Border setResaltardescripcionPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltardescripcionPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionPedido() {
		return this.resaltardescripcionPedido;
	}

	public void setResaltardescripcionPedido(Border borderResaltar) {
		this.resaltardescripcionPedido= borderResaltar;
	}

	public Boolean getMostrardescripcionPedido() {
		return this.mostrardescripcionPedido;
	}

	public void setMostrardescripcionPedido(Boolean mostrardescripcionPedido) {
		this.mostrardescripcionPedido= mostrardescripcionPedido;
	}

	public Boolean getActivardescripcionPedido() {
		return this.activardescripcionPedido;
	}

	public void setActivardescripcionPedido(Boolean activardescripcionPedido) {
		this.activardescripcionPedido= activardescripcionPedido;
	}

	public Border setResaltarcupoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarcupoPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcupoPedido() {
		return this.resaltarcupoPedido;
	}

	public void setResaltarcupoPedido(Border borderResaltar) {
		this.resaltarcupoPedido= borderResaltar;
	}

	public Boolean getMostrarcupoPedido() {
		return this.mostrarcupoPedido;
	}

	public void setMostrarcupoPedido(Boolean mostrarcupoPedido) {
		this.mostrarcupoPedido= mostrarcupoPedido;
	}

	public Boolean getActivarcupoPedido() {
		return this.activarcupoPedido;
	}

	public void setActivarcupoPedido(Boolean activarcupoPedido) {
		this.activarcupoPedido= activarcupoPedido;
	}

	public Border setResaltarsaldoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarsaldoPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldoPedido() {
		return this.resaltarsaldoPedido;
	}

	public void setResaltarsaldoPedido(Border borderResaltar) {
		this.resaltarsaldoPedido= borderResaltar;
	}

	public Boolean getMostrarsaldoPedido() {
		return this.mostrarsaldoPedido;
	}

	public void setMostrarsaldoPedido(Boolean mostrarsaldoPedido) {
		this.mostrarsaldoPedido= mostrarsaldoPedido;
	}

	public Boolean getActivarsaldoPedido() {
		return this.activarsaldoPedido;
	}

	public void setActivarsaldoPedido(Boolean activarsaldoPedido) {
		this.activarsaldoPedido= activarsaldoPedido;
	}

	public Border setResaltarpedidosPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarpedidosPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpedidosPedido() {
		return this.resaltarpedidosPedido;
	}

	public void setResaltarpedidosPedido(Border borderResaltar) {
		this.resaltarpedidosPedido= borderResaltar;
	}

	public Boolean getMostrarpedidosPedido() {
		return this.mostrarpedidosPedido;
	}

	public void setMostrarpedidosPedido(Boolean mostrarpedidosPedido) {
		this.mostrarpedidosPedido= mostrarpedidosPedido;
	}

	public Boolean getActivarpedidosPedido() {
		return this.activarpedidosPedido;
	}

	public void setActivarpedidosPedido(Boolean activarpedidosPedido) {
		this.activarpedidosPedido= activarpedidosPedido;
	}

	public Border setResaltardocumentosPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltardocumentosPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardocumentosPedido() {
		return this.resaltardocumentosPedido;
	}

	public void setResaltardocumentosPedido(Border borderResaltar) {
		this.resaltardocumentosPedido= borderResaltar;
	}

	public Boolean getMostrardocumentosPedido() {
		return this.mostrardocumentosPedido;
	}

	public void setMostrardocumentosPedido(Boolean mostrardocumentosPedido) {
		this.mostrardocumentosPedido= mostrardocumentosPedido;
	}

	public Boolean getActivardocumentosPedido() {
		return this.activardocumentosPedido;
	}

	public void setActivardocumentosPedido(Boolean activardocumentosPedido) {
		this.activardocumentosPedido= activardocumentosPedido;
	}

	public Border setResaltardisponiblePedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltardisponiblePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardisponiblePedido() {
		return this.resaltardisponiblePedido;
	}

	public void setResaltardisponiblePedido(Border borderResaltar) {
		this.resaltardisponiblePedido= borderResaltar;
	}

	public Boolean getMostrardisponiblePedido() {
		return this.mostrardisponiblePedido;
	}

	public void setMostrardisponiblePedido(Boolean mostrardisponiblePedido) {
		this.mostrardisponiblePedido= mostrardisponiblePedido;
	}

	public Boolean getActivardisponiblePedido() {
		return this.activardisponiblePedido;
	}

	public void setActivardisponiblePedido(Boolean activardisponiblePedido) {
		this.activardisponiblePedido= activardisponiblePedido;
	}

	public Border setResaltardescuento_porcentajePedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltardescuento_porcentajePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_porcentajePedido() {
		return this.resaltardescuento_porcentajePedido;
	}

	public void setResaltardescuento_porcentajePedido(Border borderResaltar) {
		this.resaltardescuento_porcentajePedido= borderResaltar;
	}

	public Boolean getMostrardescuento_porcentajePedido() {
		return this.mostrardescuento_porcentajePedido;
	}

	public void setMostrardescuento_porcentajePedido(Boolean mostrardescuento_porcentajePedido) {
		this.mostrardescuento_porcentajePedido= mostrardescuento_porcentajePedido;
	}

	public Boolean getActivardescuento_porcentajePedido() {
		return this.activardescuento_porcentajePedido;
	}

	public void setActivardescuento_porcentajePedido(Boolean activardescuento_porcentajePedido) {
		this.activardescuento_porcentajePedido= activardescuento_porcentajePedido;
	}

	public Border setResaltartotal_con_ivaPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltartotal_con_ivaPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_con_ivaPedido() {
		return this.resaltartotal_con_ivaPedido;
	}

	public void setResaltartotal_con_ivaPedido(Border borderResaltar) {
		this.resaltartotal_con_ivaPedido= borderResaltar;
	}

	public Boolean getMostrartotal_con_ivaPedido() {
		return this.mostrartotal_con_ivaPedido;
	}

	public void setMostrartotal_con_ivaPedido(Boolean mostrartotal_con_ivaPedido) {
		this.mostrartotal_con_ivaPedido= mostrartotal_con_ivaPedido;
	}

	public Boolean getActivartotal_con_ivaPedido() {
		return this.activartotal_con_ivaPedido;
	}

	public void setActivartotal_con_ivaPedido(Boolean activartotal_con_ivaPedido) {
		this.activartotal_con_ivaPedido= activartotal_con_ivaPedido;
	}

	public Border setResaltarsumanPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarsumanPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsumanPedido() {
		return this.resaltarsumanPedido;
	}

	public void setResaltarsumanPedido(Border borderResaltar) {
		this.resaltarsumanPedido= borderResaltar;
	}

	public Boolean getMostrarsumanPedido() {
		return this.mostrarsumanPedido;
	}

	public void setMostrarsumanPedido(Boolean mostrarsumanPedido) {
		this.mostrarsumanPedido= mostrarsumanPedido;
	}

	public Boolean getActivarsumanPedido() {
		return this.activarsumanPedido;
	}

	public void setActivarsumanPedido(Boolean activarsumanPedido) {
		this.activarsumanPedido= activarsumanPedido;
	}

	public Border setResaltardescuento_valorPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltardescuento_valorPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_valorPedido() {
		return this.resaltardescuento_valorPedido;
	}

	public void setResaltardescuento_valorPedido(Border borderResaltar) {
		this.resaltardescuento_valorPedido= borderResaltar;
	}

	public Boolean getMostrardescuento_valorPedido() {
		return this.mostrardescuento_valorPedido;
	}

	public void setMostrardescuento_valorPedido(Boolean mostrardescuento_valorPedido) {
		this.mostrardescuento_valorPedido= mostrardescuento_valorPedido;
	}

	public Boolean getActivardescuento_valorPedido() {
		return this.activardescuento_valorPedido;
	}

	public void setActivardescuento_valorPedido(Boolean activardescuento_valorPedido) {
		this.activardescuento_valorPedido= activardescuento_valorPedido;
	}

	public Border setResaltartotal_sin_ivaPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltartotal_sin_ivaPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_sin_ivaPedido() {
		return this.resaltartotal_sin_ivaPedido;
	}

	public void setResaltartotal_sin_ivaPedido(Border borderResaltar) {
		this.resaltartotal_sin_ivaPedido= borderResaltar;
	}

	public Boolean getMostrartotal_sin_ivaPedido() {
		return this.mostrartotal_sin_ivaPedido;
	}

	public void setMostrartotal_sin_ivaPedido(Boolean mostrartotal_sin_ivaPedido) {
		this.mostrartotal_sin_ivaPedido= mostrartotal_sin_ivaPedido;
	}

	public Boolean getActivartotal_sin_ivaPedido() {
		return this.activartotal_sin_ivaPedido;
	}

	public void setActivartotal_sin_ivaPedido(Boolean activartotal_sin_ivaPedido) {
		this.activartotal_sin_ivaPedido= activartotal_sin_ivaPedido;
	}

	public Border setResaltardescuento_totalPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltardescuento_totalPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_totalPedido() {
		return this.resaltardescuento_totalPedido;
	}

	public void setResaltardescuento_totalPedido(Border borderResaltar) {
		this.resaltardescuento_totalPedido= borderResaltar;
	}

	public Boolean getMostrardescuento_totalPedido() {
		return this.mostrardescuento_totalPedido;
	}

	public void setMostrardescuento_totalPedido(Boolean mostrardescuento_totalPedido) {
		this.mostrardescuento_totalPedido= mostrardescuento_totalPedido;
	}

	public Boolean getActivardescuento_totalPedido() {
		return this.activardescuento_totalPedido;
	}

	public void setActivardescuento_totalPedido(Boolean activardescuento_totalPedido) {
		this.activardescuento_totalPedido= activardescuento_totalPedido;
	}

	public Border setResaltarfletePedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarfletePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfletePedido() {
		return this.resaltarfletePedido;
	}

	public void setResaltarfletePedido(Border borderResaltar) {
		this.resaltarfletePedido= borderResaltar;
	}

	public Boolean getMostrarfletePedido() {
		return this.mostrarfletePedido;
	}

	public void setMostrarfletePedido(Boolean mostrarfletePedido) {
		this.mostrarfletePedido= mostrarfletePedido;
	}

	public Boolean getActivarfletePedido() {
		return this.activarfletePedido;
	}

	public void setActivarfletePedido(Boolean activarfletePedido) {
		this.activarfletePedido= activarfletePedido;
	}

	public Border setResaltartotalPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltartotalPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalPedido() {
		return this.resaltartotalPedido;
	}

	public void setResaltartotalPedido(Border borderResaltar) {
		this.resaltartotalPedido= borderResaltar;
	}

	public Boolean getMostrartotalPedido() {
		return this.mostrartotalPedido;
	}

	public void setMostrartotalPedido(Boolean mostrartotalPedido) {
		this.mostrartotalPedido= mostrartotalPedido;
	}

	public Boolean getActivartotalPedido() {
		return this.activartotalPedido;
	}

	public void setActivartotalPedido(Boolean activartotalPedido) {
		this.activartotalPedido= activartotalPedido;
	}

	public Border setResaltarsubtotalPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarsubtotalPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsubtotalPedido() {
		return this.resaltarsubtotalPedido;
	}

	public void setResaltarsubtotalPedido(Border borderResaltar) {
		this.resaltarsubtotalPedido= borderResaltar;
	}

	public Boolean getMostrarsubtotalPedido() {
		return this.mostrarsubtotalPedido;
	}

	public void setMostrarsubtotalPedido(Boolean mostrarsubtotalPedido) {
		this.mostrarsubtotalPedido= mostrarsubtotalPedido;
	}

	public Boolean getActivarsubtotalPedido() {
		return this.activarsubtotalPedido;
	}

	public void setActivarsubtotalPedido(Boolean activarsubtotalPedido) {
		this.activarsubtotalPedido= activarsubtotalPedido;
	}

	public Border setResaltarotroPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarotroPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotroPedido() {
		return this.resaltarotroPedido;
	}

	public void setResaltarotroPedido(Border borderResaltar) {
		this.resaltarotroPedido= borderResaltar;
	}

	public Boolean getMostrarotroPedido() {
		return this.mostrarotroPedido;
	}

	public void setMostrarotroPedido(Boolean mostrarotroPedido) {
		this.mostrarotroPedido= mostrarotroPedido;
	}

	public Boolean getActivarotroPedido() {
		return this.activarotroPedido;
	}

	public void setActivarotroPedido(Boolean activarotroPedido) {
		this.activarotroPedido= activarotroPedido;
	}

	public Border setResaltarultimo_costoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarultimo_costoPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarultimo_costoPedido() {
		return this.resaltarultimo_costoPedido;
	}

	public void setResaltarultimo_costoPedido(Border borderResaltar) {
		this.resaltarultimo_costoPedido= borderResaltar;
	}

	public Boolean getMostrarultimo_costoPedido() {
		return this.mostrarultimo_costoPedido;
	}

	public void setMostrarultimo_costoPedido(Boolean mostrarultimo_costoPedido) {
		this.mostrarultimo_costoPedido= mostrarultimo_costoPedido;
	}

	public Boolean getActivarultimo_costoPedido() {
		return this.activarultimo_costoPedido;
	}

	public void setActivarultimo_costoPedido(Boolean activarultimo_costoPedido) {
		this.activarultimo_costoPedido= activarultimo_costoPedido;
	}

	public Border setResaltarivaPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarivaPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaPedido() {
		return this.resaltarivaPedido;
	}

	public void setResaltarivaPedido(Border borderResaltar) {
		this.resaltarivaPedido= borderResaltar;
	}

	public Boolean getMostrarivaPedido() {
		return this.mostrarivaPedido;
	}

	public void setMostrarivaPedido(Boolean mostrarivaPedido) {
		this.mostrarivaPedido= mostrarivaPedido;
	}

	public Boolean getActivarivaPedido() {
		return this.activarivaPedido;
	}

	public void setActivarivaPedido(Boolean activarivaPedido) {
		this.activarivaPedido= activarivaPedido;
	}

	public Border setResaltarfinanciamientoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarfinanciamientoPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfinanciamientoPedido() {
		return this.resaltarfinanciamientoPedido;
	}

	public void setResaltarfinanciamientoPedido(Border borderResaltar) {
		this.resaltarfinanciamientoPedido= borderResaltar;
	}

	public Boolean getMostrarfinanciamientoPedido() {
		return this.mostrarfinanciamientoPedido;
	}

	public void setMostrarfinanciamientoPedido(Boolean mostrarfinanciamientoPedido) {
		this.mostrarfinanciamientoPedido= mostrarfinanciamientoPedido;
	}

	public Boolean getActivarfinanciamientoPedido() {
		return this.activarfinanciamientoPedido;
	}

	public void setActivarfinanciamientoPedido(Boolean activarfinanciamientoPedido) {
		this.activarfinanciamientoPedido= activarfinanciamientoPedido;
	}

	public Border setResaltarmargen_utilidadPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarmargen_utilidadPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmargen_utilidadPedido() {
		return this.resaltarmargen_utilidadPedido;
	}

	public void setResaltarmargen_utilidadPedido(Border borderResaltar) {
		this.resaltarmargen_utilidadPedido= borderResaltar;
	}

	public Boolean getMostrarmargen_utilidadPedido() {
		return this.mostrarmargen_utilidadPedido;
	}

	public void setMostrarmargen_utilidadPedido(Boolean mostrarmargen_utilidadPedido) {
		this.mostrarmargen_utilidadPedido= mostrarmargen_utilidadPedido;
	}

	public Boolean getActivarmargen_utilidadPedido() {
		return this.activarmargen_utilidadPedido;
	}

	public void setActivarmargen_utilidadPedido(Boolean activarmargen_utilidadPedido) {
		this.activarmargen_utilidadPedido= activarmargen_utilidadPedido;
	}

	public Border setResaltarotros_valoresPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarotros_valoresPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotros_valoresPedido() {
		return this.resaltarotros_valoresPedido;
	}

	public void setResaltarotros_valoresPedido(Border borderResaltar) {
		this.resaltarotros_valoresPedido= borderResaltar;
	}

	public Boolean getMostrarotros_valoresPedido() {
		return this.mostrarotros_valoresPedido;
	}

	public void setMostrarotros_valoresPedido(Boolean mostrarotros_valoresPedido) {
		this.mostrarotros_valoresPedido= mostrarotros_valoresPedido;
	}

	public Boolean getActivarotros_valoresPedido() {
		return this.activarotros_valoresPedido;
	}

	public void setActivarotros_valoresPedido(Boolean activarotros_valoresPedido) {
		this.activarotros_valoresPedido= activarotros_valoresPedido;
	}

	public Border setResaltaranticipoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltaranticipoPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaranticipoPedido() {
		return this.resaltaranticipoPedido;
	}

	public void setResaltaranticipoPedido(Border borderResaltar) {
		this.resaltaranticipoPedido= borderResaltar;
	}

	public Boolean getMostraranticipoPedido() {
		return this.mostraranticipoPedido;
	}

	public void setMostraranticipoPedido(Boolean mostraranticipoPedido) {
		this.mostraranticipoPedido= mostraranticipoPedido;
	}

	public Boolean getActivaranticipoPedido() {
		return this.activaranticipoPedido;
	}

	public void setActivaranticipoPedido(Boolean activaranticipoPedido) {
		this.activaranticipoPedido= activaranticipoPedido;
	}

	public Border setResaltarid_tipo_cambioPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cambioPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cambioPedido() {
		return this.resaltarid_tipo_cambioPedido;
	}

	public void setResaltarid_tipo_cambioPedido(Border borderResaltar) {
		this.resaltarid_tipo_cambioPedido= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cambioPedido() {
		return this.mostrarid_tipo_cambioPedido;
	}

	public void setMostrarid_tipo_cambioPedido(Boolean mostrarid_tipo_cambioPedido) {
		this.mostrarid_tipo_cambioPedido= mostrarid_tipo_cambioPedido;
	}

	public Boolean getActivarid_tipo_cambioPedido() {
		return this.activarid_tipo_cambioPedido;
	}

	public void setActivarid_tipo_cambioPedido(Boolean activarid_tipo_cambioPedido) {
		this.activarid_tipo_cambioPedido= activarid_tipo_cambioPedido;
	}

	public Boolean getCargarid_tipo_cambioPedido() {
		return this.cargarid_tipo_cambioPedido;
	}

	public void setCargarid_tipo_cambioPedido(Boolean cargarid_tipo_cambioPedido) {
		this.cargarid_tipo_cambioPedido= cargarid_tipo_cambioPedido;
	}

	public Border setResaltarid_centro_costoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoPedido() {
		return this.resaltarid_centro_costoPedido;
	}

	public void setResaltarid_centro_costoPedido(Border borderResaltar) {
		this.resaltarid_centro_costoPedido= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoPedido() {
		return this.mostrarid_centro_costoPedido;
	}

	public void setMostrarid_centro_costoPedido(Boolean mostrarid_centro_costoPedido) {
		this.mostrarid_centro_costoPedido= mostrarid_centro_costoPedido;
	}

	public Boolean getActivarid_centro_costoPedido() {
		return this.activarid_centro_costoPedido;
	}

	public void setActivarid_centro_costoPedido(Boolean activarid_centro_costoPedido) {
		this.activarid_centro_costoPedido= activarid_centro_costoPedido;
	}

	public Boolean getCargarid_centro_costoPedido() {
		return this.cargarid_centro_costoPedido;
	}

	public void setCargarid_centro_costoPedido(Boolean cargarid_centro_costoPedido) {
		this.cargarid_centro_costoPedido= cargarid_centro_costoPedido;
	}

	public Border setResaltarid_zonaPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarid_zonaPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_zonaPedido() {
		return this.resaltarid_zonaPedido;
	}

	public void setResaltarid_zonaPedido(Border borderResaltar) {
		this.resaltarid_zonaPedido= borderResaltar;
	}

	public Boolean getMostrarid_zonaPedido() {
		return this.mostrarid_zonaPedido;
	}

	public void setMostrarid_zonaPedido(Boolean mostrarid_zonaPedido) {
		this.mostrarid_zonaPedido= mostrarid_zonaPedido;
	}

	public Boolean getActivarid_zonaPedido() {
		return this.activarid_zonaPedido;
	}

	public void setActivarid_zonaPedido(Boolean activarid_zonaPedido) {
		this.activarid_zonaPedido= activarid_zonaPedido;
	}

	public Boolean getCargarid_zonaPedido() {
		return this.cargarid_zonaPedido;
	}

	public void setCargarid_zonaPedido(Boolean cargarid_zonaPedido) {
		this.cargarid_zonaPedido= cargarid_zonaPedido;
	}

	public Border setResaltarfechaPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarfechaPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaPedido() {
		return this.resaltarfechaPedido;
	}

	public void setResaltarfechaPedido(Border borderResaltar) {
		this.resaltarfechaPedido= borderResaltar;
	}

	public Boolean getMostrarfechaPedido() {
		return this.mostrarfechaPedido;
	}

	public void setMostrarfechaPedido(Boolean mostrarfechaPedido) {
		this.mostrarfechaPedido= mostrarfechaPedido;
	}

	public Boolean getActivarfechaPedido() {
		return this.activarfechaPedido;
	}

	public void setActivarfechaPedido(Boolean activarfechaPedido) {
		this.activarfechaPedido= activarfechaPedido;
	}

	public Border setResaltarnumero_fuePedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarnumero_fuePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_fuePedido() {
		return this.resaltarnumero_fuePedido;
	}

	public void setResaltarnumero_fuePedido(Border borderResaltar) {
		this.resaltarnumero_fuePedido= borderResaltar;
	}

	public Boolean getMostrarnumero_fuePedido() {
		return this.mostrarnumero_fuePedido;
	}

	public void setMostrarnumero_fuePedido(Boolean mostrarnumero_fuePedido) {
		this.mostrarnumero_fuePedido= mostrarnumero_fuePedido;
	}

	public Boolean getActivarnumero_fuePedido() {
		return this.activarnumero_fuePedido;
	}

	public void setActivarnumero_fuePedido(Boolean activarnumero_fuePedido) {
		this.activarnumero_fuePedido= activarnumero_fuePedido;
	}

	public Border setResaltarfecha_servidorPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarfecha_servidorPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_servidorPedido() {
		return this.resaltarfecha_servidorPedido;
	}

	public void setResaltarfecha_servidorPedido(Border borderResaltar) {
		this.resaltarfecha_servidorPedido= borderResaltar;
	}

	public Boolean getMostrarfecha_servidorPedido() {
		return this.mostrarfecha_servidorPedido;
	}

	public void setMostrarfecha_servidorPedido(Boolean mostrarfecha_servidorPedido) {
		this.mostrarfecha_servidorPedido= mostrarfecha_servidorPedido;
	}

	public Boolean getActivarfecha_servidorPedido() {
		return this.activarfecha_servidorPedido;
	}

	public void setActivarfecha_servidorPedido(Boolean activarfecha_servidorPedido) {
		this.activarfecha_servidorPedido= activarfecha_servidorPedido;
	}

	public Border setResaltarmonto_retencionPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltarmonto_retencionPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_retencionPedido() {
		return this.resaltarmonto_retencionPedido;
	}

	public void setResaltarmonto_retencionPedido(Border borderResaltar) {
		this.resaltarmonto_retencionPedido= borderResaltar;
	}

	public Boolean getMostrarmonto_retencionPedido() {
		return this.mostrarmonto_retencionPedido;
	}

	public void setMostrarmonto_retencionPedido(Boolean mostrarmonto_retencionPedido) {
		this.mostrarmonto_retencionPedido= mostrarmonto_retencionPedido;
	}

	public Boolean getActivarmonto_retencionPedido() {
		return this.activarmonto_retencionPedido;
	}

	public void setActivarmonto_retencionPedido(Boolean activarmonto_retencionPedido) {
		this.activarmonto_retencionPedido= activarmonto_retencionPedido;
	}

	public Border setResaltaricePedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltar);
		
		this.resaltaricePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaricePedido() {
		return this.resaltaricePedido;
	}

	public void setResaltaricePedido(Border borderResaltar) {
		this.resaltaricePedido= borderResaltar;
	}

	public Boolean getMostraricePedido() {
		return this.mostraricePedido;
	}

	public void setMostraricePedido(Boolean mostraricePedido) {
		this.mostraricePedido= mostraricePedido;
	}

	public Boolean getActivaricePedido() {
		return this.activaricePedido;
	}

	public void setActivaricePedido(Boolean activaricePedido) {
		this.activaricePedido= activaricePedido;
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
		
		
		this.setMostraridPedido(esInicial);
		this.setMostrarid_empresaPedido(esInicial);
		this.setMostrarid_sucursalPedido(esInicial);
		this.setMostrarid_ejercicioPedido(esInicial);
		this.setMostrarid_periodoPedido(esInicial);
		this.setMostrarid_anioPedido(esInicial);
		this.setMostrarid_mesPedido(esInicial);
		this.setMostrarid_usuarioPedido(esInicial);
		this.setMostrarnumeroPedido(esInicial);
		this.setMostrarpre_impresoPedido(esInicial);
		this.setMostrarfecha_emisionPedido(esInicial);
		this.setMostrarfecha_entregaPedido(esInicial);
		this.setMostrarid_monedaPedido(esInicial);
		this.setMostrarcotizacionPedido(esInicial);
		this.setMostrarid_empleadoPedido(esInicial);
		this.setMostrarid_tipo_precioPedido(esInicial);
		this.setMostrarid_formatoPedido(esInicial);
		this.setMostrardireccionPedido(esInicial);
		this.setMostrarid_clientePedido(esInicial);
		this.setMostrartelefonoPedido(esInicial);
		this.setMostrarrucPedido(esInicial);
		this.setMostrarid_sub_clientePedido(esInicial);
		this.setMostrarid_vendedorPedido(esInicial);
		this.setMostrarid_consultorPedido(esInicial);
		this.setMostrarordenPedido(esInicial);
		this.setMostrarid_responsablePedido(esInicial);
		this.setMostrarid_estado_pedidoPedido(esInicial);
		this.setMostrarid_transportePedido(esInicial);
		this.setMostrarid_ruta_transportePedido(esInicial);
		this.setMostrarvalor_rutaPedido(esInicial);
		this.setMostrarid_tipo_llamadaPedido(esInicial);
		this.setMostrarid_transportistaPedido(esInicial);
		this.setMostrarhora_inicioPedido(esInicial);
		this.setMostrarhora_finPedido(esInicial);
		this.setMostrardescripcionPedido(esInicial);
		this.setMostrarcupoPedido(esInicial);
		this.setMostrarsaldoPedido(esInicial);
		this.setMostrarpedidosPedido(esInicial);
		this.setMostrardocumentosPedido(esInicial);
		this.setMostrardisponiblePedido(esInicial);
		this.setMostrardescuento_porcentajePedido(esInicial);
		this.setMostrartotal_con_ivaPedido(esInicial);
		this.setMostrarsumanPedido(esInicial);
		this.setMostrardescuento_valorPedido(esInicial);
		this.setMostrartotal_sin_ivaPedido(esInicial);
		this.setMostrardescuento_totalPedido(esInicial);
		this.setMostrarfletePedido(esInicial);
		this.setMostrartotalPedido(esInicial);
		this.setMostrarsubtotalPedido(esInicial);
		this.setMostrarotroPedido(esInicial);
		this.setMostrarultimo_costoPedido(esInicial);
		this.setMostrarivaPedido(esInicial);
		this.setMostrarfinanciamientoPedido(esInicial);
		this.setMostrarmargen_utilidadPedido(esInicial);
		this.setMostrarotros_valoresPedido(esInicial);
		this.setMostraranticipoPedido(esInicial);
		this.setMostrarid_tipo_cambioPedido(esInicial);
		this.setMostrarid_centro_costoPedido(esInicial);
		this.setMostrarid_zonaPedido(esInicial);
		this.setMostrarfechaPedido(esInicial);
		this.setMostrarnumero_fuePedido(esInicial);
		this.setMostrarfecha_servidorPedido(esInicial);
		this.setMostrarmonto_retencionPedido(esInicial);
		this.setMostraricePedido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidoConstantesFunciones.ID)) {
				this.setMostraridPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDMES)) {
				this.setMostrarid_mesPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.PREIMPRESO)) {
				this.setMostrarpre_impresoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.FECHAENTREGA)) {
				this.setMostrarfecha_entregaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.COTIZACION)) {
				this.setMostrarcotizacionPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDTIPOPRECIO)) {
				this.setMostrarid_tipo_precioPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clientePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.RUC)) {
				this.setMostrarrucPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDSUBCLIENTE)) {
				this.setMostrarid_sub_clientePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDCONSULTOR)) {
				this.setMostrarid_consultorPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.ORDEN)) {
				this.setMostrarordenPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDRESPONSABLE)) {
				this.setMostrarid_responsablePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDESTADOPEDIDO)) {
				this.setMostrarid_estado_pedidoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDTRANSPORTE)) {
				this.setMostrarid_transportePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDRUTATRANSPORTE)) {
				this.setMostrarid_ruta_transportePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.VALORRUTA)) {
				this.setMostrarvalor_rutaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDTIPOLLAMADA)) {
				this.setMostrarid_tipo_llamadaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDTRANSPORTISTA)) {
				this.setMostrarid_transportistaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.HORAINICIO)) {
				this.setMostrarhora_inicioPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.HORAFIN)) {
				this.setMostrarhora_finPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.CUPO)) {
				this.setMostrarcupoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.SALDO)) {
				this.setMostrarsaldoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.PEDIDOS)) {
				this.setMostrarpedidosPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.DOCUMENTOS)) {
				this.setMostrardocumentosPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.DISPONIBLE)) {
				this.setMostrardisponiblePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setMostrardescuento_porcentajePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.TOTALCONIVA)) {
				this.setMostrartotal_con_ivaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.SUMAN)) {
				this.setMostrarsumanPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.DESCUENTOVALOR)) {
				this.setMostrardescuento_valorPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.TOTALSINIVA)) {
				this.setMostrartotal_sin_ivaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.DESCUENTOTOTAL)) {
				this.setMostrardescuento_totalPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.FLETE)) {
				this.setMostrarfletePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.TOTAL)) {
				this.setMostrartotalPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsubtotalPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.OTRO)) {
				this.setMostrarotroPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.ULTIMOCOSTO)) {
				this.setMostrarultimo_costoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IVA)) {
				this.setMostrarivaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.FINANCIAMIENTO)) {
				this.setMostrarfinanciamientoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.MARGENUTILIDAD)) {
				this.setMostrarmargen_utilidadPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.OTROSVALORES)) {
				this.setMostrarotros_valoresPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.ANTICIPO)) {
				this.setMostraranticipoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDTIPOCAMBIO)) {
				this.setMostrarid_tipo_cambioPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDZONA)) {
				this.setMostrarid_zonaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.FECHA)) {
				this.setMostrarfechaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.NUMEROFUE)) {
				this.setMostrarnumero_fuePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.FECHASERVIDOR)) {
				this.setMostrarfecha_servidorPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.MONTORETENCION)) {
				this.setMostrarmonto_retencionPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.ICE)) {
				this.setMostraricePedido(esAsigna);
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
		
		
		this.setActivaridPedido(esInicial);
		this.setActivarid_empresaPedido(esInicial);
		this.setActivarid_sucursalPedido(esInicial);
		this.setActivarid_ejercicioPedido(esInicial);
		this.setActivarid_periodoPedido(esInicial);
		this.setActivarid_anioPedido(esInicial);
		this.setActivarid_mesPedido(esInicial);
		this.setActivarid_usuarioPedido(esInicial);
		this.setActivarnumeroPedido(esInicial);
		this.setActivarpre_impresoPedido(esInicial);
		this.setActivarfecha_emisionPedido(esInicial);
		this.setActivarfecha_entregaPedido(esInicial);
		this.setActivarid_monedaPedido(esInicial);
		this.setActivarcotizacionPedido(esInicial);
		this.setActivarid_empleadoPedido(esInicial);
		this.setActivarid_tipo_precioPedido(esInicial);
		this.setActivarid_formatoPedido(esInicial);
		this.setActivardireccionPedido(esInicial);
		this.setActivarid_clientePedido(esInicial);
		this.setActivartelefonoPedido(esInicial);
		this.setActivarrucPedido(esInicial);
		this.setActivarid_sub_clientePedido(esInicial);
		this.setActivarid_vendedorPedido(esInicial);
		this.setActivarid_consultorPedido(esInicial);
		this.setActivarordenPedido(esInicial);
		this.setActivarid_responsablePedido(esInicial);
		this.setActivarid_estado_pedidoPedido(esInicial);
		this.setActivarid_transportePedido(esInicial);
		this.setActivarid_ruta_transportePedido(esInicial);
		this.setActivarvalor_rutaPedido(esInicial);
		this.setActivarid_tipo_llamadaPedido(esInicial);
		this.setActivarid_transportistaPedido(esInicial);
		this.setActivarhora_inicioPedido(esInicial);
		this.setActivarhora_finPedido(esInicial);
		this.setActivardescripcionPedido(esInicial);
		this.setActivarcupoPedido(esInicial);
		this.setActivarsaldoPedido(esInicial);
		this.setActivarpedidosPedido(esInicial);
		this.setActivardocumentosPedido(esInicial);
		this.setActivardisponiblePedido(esInicial);
		this.setActivardescuento_porcentajePedido(esInicial);
		this.setActivartotal_con_ivaPedido(esInicial);
		this.setActivarsumanPedido(esInicial);
		this.setActivardescuento_valorPedido(esInicial);
		this.setActivartotal_sin_ivaPedido(esInicial);
		this.setActivardescuento_totalPedido(esInicial);
		this.setActivarfletePedido(esInicial);
		this.setActivartotalPedido(esInicial);
		this.setActivarsubtotalPedido(esInicial);
		this.setActivarotroPedido(esInicial);
		this.setActivarultimo_costoPedido(esInicial);
		this.setActivarivaPedido(esInicial);
		this.setActivarfinanciamientoPedido(esInicial);
		this.setActivarmargen_utilidadPedido(esInicial);
		this.setActivarotros_valoresPedido(esInicial);
		this.setActivaranticipoPedido(esInicial);
		this.setActivarid_tipo_cambioPedido(esInicial);
		this.setActivarid_centro_costoPedido(esInicial);
		this.setActivarid_zonaPedido(esInicial);
		this.setActivarfechaPedido(esInicial);
		this.setActivarnumero_fuePedido(esInicial);
		this.setActivarfecha_servidorPedido(esInicial);
		this.setActivarmonto_retencionPedido(esInicial);
		this.setActivaricePedido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidoConstantesFunciones.ID)) {
				this.setActivaridPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDANIO)) {
				this.setActivarid_anioPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDMES)) {
				this.setActivarid_mesPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.NUMERO)) {
				this.setActivarnumeroPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.PREIMPRESO)) {
				this.setActivarpre_impresoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.FECHAENTREGA)) {
				this.setActivarfecha_entregaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.COTIZACION)) {
				this.setActivarcotizacionPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDTIPOPRECIO)) {
				this.setActivarid_tipo_precioPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.DIRECCION)) {
				this.setActivardireccionPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clientePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.RUC)) {
				this.setActivarrucPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDSUBCLIENTE)) {
				this.setActivarid_sub_clientePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDCONSULTOR)) {
				this.setActivarid_consultorPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.ORDEN)) {
				this.setActivarordenPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDRESPONSABLE)) {
				this.setActivarid_responsablePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDESTADOPEDIDO)) {
				this.setActivarid_estado_pedidoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDTRANSPORTE)) {
				this.setActivarid_transportePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDRUTATRANSPORTE)) {
				this.setActivarid_ruta_transportePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.VALORRUTA)) {
				this.setActivarvalor_rutaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDTIPOLLAMADA)) {
				this.setActivarid_tipo_llamadaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDTRANSPORTISTA)) {
				this.setActivarid_transportistaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.HORAINICIO)) {
				this.setActivarhora_inicioPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.HORAFIN)) {
				this.setActivarhora_finPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.CUPO)) {
				this.setActivarcupoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.SALDO)) {
				this.setActivarsaldoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.PEDIDOS)) {
				this.setActivarpedidosPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.DOCUMENTOS)) {
				this.setActivardocumentosPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.DISPONIBLE)) {
				this.setActivardisponiblePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setActivardescuento_porcentajePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.TOTALCONIVA)) {
				this.setActivartotal_con_ivaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.SUMAN)) {
				this.setActivarsumanPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.DESCUENTOVALOR)) {
				this.setActivardescuento_valorPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.TOTALSINIVA)) {
				this.setActivartotal_sin_ivaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.DESCUENTOTOTAL)) {
				this.setActivardescuento_totalPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.FLETE)) {
				this.setActivarfletePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.TOTAL)) {
				this.setActivartotalPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.SUBTOTAL)) {
				this.setActivarsubtotalPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.OTRO)) {
				this.setActivarotroPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.ULTIMOCOSTO)) {
				this.setActivarultimo_costoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IVA)) {
				this.setActivarivaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.FINANCIAMIENTO)) {
				this.setActivarfinanciamientoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.MARGENUTILIDAD)) {
				this.setActivarmargen_utilidadPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.OTROSVALORES)) {
				this.setActivarotros_valoresPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.ANTICIPO)) {
				this.setActivaranticipoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDTIPOCAMBIO)) {
				this.setActivarid_tipo_cambioPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDZONA)) {
				this.setActivarid_zonaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.FECHA)) {
				this.setActivarfechaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.NUMEROFUE)) {
				this.setActivarnumero_fuePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.FECHASERVIDOR)) {
				this.setActivarfecha_servidorPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.MONTORETENCION)) {
				this.setActivarmonto_retencionPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.ICE)) {
				this.setActivaricePedido(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPedido(esInicial);
		this.setResaltarid_empresaPedido(esInicial);
		this.setResaltarid_sucursalPedido(esInicial);
		this.setResaltarid_ejercicioPedido(esInicial);
		this.setResaltarid_periodoPedido(esInicial);
		this.setResaltarid_anioPedido(esInicial);
		this.setResaltarid_mesPedido(esInicial);
		this.setResaltarid_usuarioPedido(esInicial);
		this.setResaltarnumeroPedido(esInicial);
		this.setResaltarpre_impresoPedido(esInicial);
		this.setResaltarfecha_emisionPedido(esInicial);
		this.setResaltarfecha_entregaPedido(esInicial);
		this.setResaltarid_monedaPedido(esInicial);
		this.setResaltarcotizacionPedido(esInicial);
		this.setResaltarid_empleadoPedido(esInicial);
		this.setResaltarid_tipo_precioPedido(esInicial);
		this.setResaltarid_formatoPedido(esInicial);
		this.setResaltardireccionPedido(esInicial);
		this.setResaltarid_clientePedido(esInicial);
		this.setResaltartelefonoPedido(esInicial);
		this.setResaltarrucPedido(esInicial);
		this.setResaltarid_sub_clientePedido(esInicial);
		this.setResaltarid_vendedorPedido(esInicial);
		this.setResaltarid_consultorPedido(esInicial);
		this.setResaltarordenPedido(esInicial);
		this.setResaltarid_responsablePedido(esInicial);
		this.setResaltarid_estado_pedidoPedido(esInicial);
		this.setResaltarid_transportePedido(esInicial);
		this.setResaltarid_ruta_transportePedido(esInicial);
		this.setResaltarvalor_rutaPedido(esInicial);
		this.setResaltarid_tipo_llamadaPedido(esInicial);
		this.setResaltarid_transportistaPedido(esInicial);
		this.setResaltarhora_inicioPedido(esInicial);
		this.setResaltarhora_finPedido(esInicial);
		this.setResaltardescripcionPedido(esInicial);
		this.setResaltarcupoPedido(esInicial);
		this.setResaltarsaldoPedido(esInicial);
		this.setResaltarpedidosPedido(esInicial);
		this.setResaltardocumentosPedido(esInicial);
		this.setResaltardisponiblePedido(esInicial);
		this.setResaltardescuento_porcentajePedido(esInicial);
		this.setResaltartotal_con_ivaPedido(esInicial);
		this.setResaltarsumanPedido(esInicial);
		this.setResaltardescuento_valorPedido(esInicial);
		this.setResaltartotal_sin_ivaPedido(esInicial);
		this.setResaltardescuento_totalPedido(esInicial);
		this.setResaltarfletePedido(esInicial);
		this.setResaltartotalPedido(esInicial);
		this.setResaltarsubtotalPedido(esInicial);
		this.setResaltarotroPedido(esInicial);
		this.setResaltarultimo_costoPedido(esInicial);
		this.setResaltarivaPedido(esInicial);
		this.setResaltarfinanciamientoPedido(esInicial);
		this.setResaltarmargen_utilidadPedido(esInicial);
		this.setResaltarotros_valoresPedido(esInicial);
		this.setResaltaranticipoPedido(esInicial);
		this.setResaltarid_tipo_cambioPedido(esInicial);
		this.setResaltarid_centro_costoPedido(esInicial);
		this.setResaltarid_zonaPedido(esInicial);
		this.setResaltarfechaPedido(esInicial);
		this.setResaltarnumero_fuePedido(esInicial);
		this.setResaltarfecha_servidorPedido(esInicial);
		this.setResaltarmonto_retencionPedido(esInicial);
		this.setResaltaricePedido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidoConstantesFunciones.ID)) {
				this.setResaltaridPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDMES)) {
				this.setResaltarid_mesPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.PREIMPRESO)) {
				this.setResaltarpre_impresoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.FECHAENTREGA)) {
				this.setResaltarfecha_entregaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.COTIZACION)) {
				this.setResaltarcotizacionPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDTIPOPRECIO)) {
				this.setResaltarid_tipo_precioPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clientePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.RUC)) {
				this.setResaltarrucPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDSUBCLIENTE)) {
				this.setResaltarid_sub_clientePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDCONSULTOR)) {
				this.setResaltarid_consultorPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.ORDEN)) {
				this.setResaltarordenPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDRESPONSABLE)) {
				this.setResaltarid_responsablePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDESTADOPEDIDO)) {
				this.setResaltarid_estado_pedidoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDTRANSPORTE)) {
				this.setResaltarid_transportePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDRUTATRANSPORTE)) {
				this.setResaltarid_ruta_transportePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.VALORRUTA)) {
				this.setResaltarvalor_rutaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDTIPOLLAMADA)) {
				this.setResaltarid_tipo_llamadaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDTRANSPORTISTA)) {
				this.setResaltarid_transportistaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.HORAINICIO)) {
				this.setResaltarhora_inicioPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.HORAFIN)) {
				this.setResaltarhora_finPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.CUPO)) {
				this.setResaltarcupoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.SALDO)) {
				this.setResaltarsaldoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.PEDIDOS)) {
				this.setResaltarpedidosPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.DOCUMENTOS)) {
				this.setResaltardocumentosPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.DISPONIBLE)) {
				this.setResaltardisponiblePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setResaltardescuento_porcentajePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.TOTALCONIVA)) {
				this.setResaltartotal_con_ivaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.SUMAN)) {
				this.setResaltarsumanPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.DESCUENTOVALOR)) {
				this.setResaltardescuento_valorPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.TOTALSINIVA)) {
				this.setResaltartotal_sin_ivaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.DESCUENTOTOTAL)) {
				this.setResaltardescuento_totalPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.FLETE)) {
				this.setResaltarfletePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.TOTAL)) {
				this.setResaltartotalPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsubtotalPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.OTRO)) {
				this.setResaltarotroPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.ULTIMOCOSTO)) {
				this.setResaltarultimo_costoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IVA)) {
				this.setResaltarivaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.FINANCIAMIENTO)) {
				this.setResaltarfinanciamientoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.MARGENUTILIDAD)) {
				this.setResaltarmargen_utilidadPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.OTROSVALORES)) {
				this.setResaltarotros_valoresPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.ANTICIPO)) {
				this.setResaltaranticipoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDTIPOCAMBIO)) {
				this.setResaltarid_tipo_cambioPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.IDZONA)) {
				this.setResaltarid_zonaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.FECHA)) {
				this.setResaltarfechaPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.NUMEROFUE)) {
				this.setResaltarnumero_fuePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.FECHASERVIDOR)) {
				this.setResaltarfecha_servidorPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.MONTORETENCION)) {
				this.setResaltarmonto_retencionPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoConstantesFunciones.ICE)) {
				this.setResaltaricePedido(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetallePedidoPedido=null;

	public Border getResaltarDetallePedidoPedido() {
		return this.resaltarDetallePedidoPedido;
	}

	public void setResaltarDetallePedidoPedido(Border borderResaltarDetallePedido) {
		if(borderResaltarDetallePedido!=null) {
			this.resaltarDetallePedidoPedido= borderResaltarDetallePedido;
		}
	}

	public Border setResaltarDetallePedidoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltarDetallePedido=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//pedidoBeanSwingJInternalFrame.jTtoolBarPedido.setBorder(borderResaltarDetallePedido);
			
		this.resaltarDetallePedidoPedido= borderResaltarDetallePedido;

		 return borderResaltarDetallePedido;
	}



	public Boolean mostrarDetallePedidoPedido=true;

	public Boolean getMostrarDetallePedidoPedido() {
		return this.mostrarDetallePedidoPedido;
	}

	public void setMostrarDetallePedidoPedido(Boolean visibilidadResaltarDetallePedido) {
		this.mostrarDetallePedidoPedido= visibilidadResaltarDetallePedido;
	}



	public Boolean activarDetallePedidoPedido=true;

	public Boolean gethabilitarResaltarDetallePedidoPedido() {
		return this.activarDetallePedidoPedido;
	}

	public void setActivarDetallePedidoPedido(Boolean habilitarResaltarDetallePedido) {
		this.activarDetallePedidoPedido= habilitarResaltarDetallePedido;
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

		this.setMostrarDetallePedidoPedido(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetallePedido.class)) {
				this.setMostrarDetallePedidoPedido(esAsigna);
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

		this.setActivarDetallePedidoPedido(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetallePedido.class)) {
				this.setActivarDetallePedidoPedido(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetallePedidoPedido(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetallePedido.class)) {
				this.setResaltarDetallePedidoPedido(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdCentroCostoPedido=true;

	public Boolean getMostrarFK_IdCentroCostoPedido() {
		return this.mostrarFK_IdCentroCostoPedido;
	}

	public void setMostrarFK_IdCentroCostoPedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoPedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClientePedido=true;

	public Boolean getMostrarFK_IdClientePedido() {
		return this.mostrarFK_IdClientePedido;
	}

	public void setMostrarFK_IdClientePedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClientePedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdConsultorPedido=true;

	public Boolean getMostrarFK_IdConsultorPedido() {
		return this.mostrarFK_IdConsultorPedido;
	}

	public void setMostrarFK_IdConsultorPedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdConsultorPedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioPedido=true;

	public Boolean getMostrarFK_IdEjercicioPedido() {
		return this.mostrarFK_IdEjercicioPedido;
	}

	public void setMostrarFK_IdEjercicioPedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioPedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoPedido=true;

	public Boolean getMostrarFK_IdEmpleadoPedido() {
		return this.mostrarFK_IdEmpleadoPedido;
	}

	public void setMostrarFK_IdEmpleadoPedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoPedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPedido=true;

	public Boolean getMostrarFK_IdEmpresaPedido() {
		return this.mostrarFK_IdEmpresaPedido;
	}

	public void setMostrarFK_IdEmpresaPedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoPedidoPedido=true;

	public Boolean getMostrarFK_IdEstadoPedidoPedido() {
		return this.mostrarFK_IdEstadoPedidoPedido;
	}

	public void setMostrarFK_IdEstadoPedidoPedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoPedidoPedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoPedido=true;

	public Boolean getMostrarFK_IdFormatoPedido() {
		return this.mostrarFK_IdFormatoPedido;
	}

	public void setMostrarFK_IdFormatoPedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoPedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMonedaPedido=true;

	public Boolean getMostrarFK_IdMonedaPedido() {
		return this.mostrarFK_IdMonedaPedido;
	}

	public void setMostrarFK_IdMonedaPedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMonedaPedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoPedido=true;

	public Boolean getMostrarFK_IdPeriodoPedido() {
		return this.mostrarFK_IdPeriodoPedido;
	}

	public void setMostrarFK_IdPeriodoPedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoPedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdResponsablePedido=true;

	public Boolean getMostrarFK_IdResponsablePedido() {
		return this.mostrarFK_IdResponsablePedido;
	}

	public void setMostrarFK_IdResponsablePedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdResponsablePedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdRutaTransportePedido=true;

	public Boolean getMostrarFK_IdRutaTransportePedido() {
		return this.mostrarFK_IdRutaTransportePedido;
	}

	public void setMostrarFK_IdRutaTransportePedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdRutaTransportePedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSubClientePedido=true;

	public Boolean getMostrarFK_IdSubClientePedido() {
		return this.mostrarFK_IdSubClientePedido;
	}

	public void setMostrarFK_IdSubClientePedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSubClientePedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalPedido=true;

	public Boolean getMostrarFK_IdSucursalPedido() {
		return this.mostrarFK_IdSucursalPedido;
	}

	public void setMostrarFK_IdSucursalPedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalPedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCambioPedido=true;

	public Boolean getMostrarFK_IdTipoCambioPedido() {
		return this.mostrarFK_IdTipoCambioPedido;
	}

	public void setMostrarFK_IdTipoCambioPedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCambioPedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoLlamadaPedido=true;

	public Boolean getMostrarFK_IdTipoLlamadaPedido() {
		return this.mostrarFK_IdTipoLlamadaPedido;
	}

	public void setMostrarFK_IdTipoLlamadaPedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoLlamadaPedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPrecioPedido=true;

	public Boolean getMostrarFK_IdTipoPrecioPedido() {
		return this.mostrarFK_IdTipoPrecioPedido;
	}

	public void setMostrarFK_IdTipoPrecioPedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPrecioPedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransportePedido=true;

	public Boolean getMostrarFK_IdTransportePedido() {
		return this.mostrarFK_IdTransportePedido;
	}

	public void setMostrarFK_IdTransportePedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransportePedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransportistaPedido=true;

	public Boolean getMostrarFK_IdTransportistaPedido() {
		return this.mostrarFK_IdTransportistaPedido;
	}

	public void setMostrarFK_IdTransportistaPedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransportistaPedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioPedido=true;

	public Boolean getMostrarFK_IdUsuarioPedido() {
		return this.mostrarFK_IdUsuarioPedido;
	}

	public void setMostrarFK_IdUsuarioPedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioPedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdVendedorPedido=true;

	public Boolean getMostrarFK_IdVendedorPedido() {
		return this.mostrarFK_IdVendedorPedido;
	}

	public void setMostrarFK_IdVendedorPedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdVendedorPedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdZonaPedido=true;

	public Boolean getMostrarFK_IdZonaPedido() {
		return this.mostrarFK_IdZonaPedido;
	}

	public void setMostrarFK_IdZonaPedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdZonaPedido= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCentroCostoPedido=true;

	public Boolean getActivarFK_IdCentroCostoPedido() {
		return this.activarFK_IdCentroCostoPedido;
	}

	public void setActivarFK_IdCentroCostoPedido(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoPedido= habilitarResaltar;
	}

	public Boolean activarFK_IdClientePedido=true;

	public Boolean getActivarFK_IdClientePedido() {
		return this.activarFK_IdClientePedido;
	}

	public void setActivarFK_IdClientePedido(Boolean habilitarResaltar) {
		this.activarFK_IdClientePedido= habilitarResaltar;
	}

	public Boolean activarFK_IdConsultorPedido=true;

	public Boolean getActivarFK_IdConsultorPedido() {
		return this.activarFK_IdConsultorPedido;
	}

	public void setActivarFK_IdConsultorPedido(Boolean habilitarResaltar) {
		this.activarFK_IdConsultorPedido= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioPedido=true;

	public Boolean getActivarFK_IdEjercicioPedido() {
		return this.activarFK_IdEjercicioPedido;
	}

	public void setActivarFK_IdEjercicioPedido(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioPedido= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoPedido=true;

	public Boolean getActivarFK_IdEmpleadoPedido() {
		return this.activarFK_IdEmpleadoPedido;
	}

	public void setActivarFK_IdEmpleadoPedido(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoPedido= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPedido=true;

	public Boolean getActivarFK_IdEmpresaPedido() {
		return this.activarFK_IdEmpresaPedido;
	}

	public void setActivarFK_IdEmpresaPedido(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPedido= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoPedidoPedido=true;

	public Boolean getActivarFK_IdEstadoPedidoPedido() {
		return this.activarFK_IdEstadoPedidoPedido;
	}

	public void setActivarFK_IdEstadoPedidoPedido(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoPedidoPedido= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoPedido=true;

	public Boolean getActivarFK_IdFormatoPedido() {
		return this.activarFK_IdFormatoPedido;
	}

	public void setActivarFK_IdFormatoPedido(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoPedido= habilitarResaltar;
	}

	public Boolean activarFK_IdMonedaPedido=true;

	public Boolean getActivarFK_IdMonedaPedido() {
		return this.activarFK_IdMonedaPedido;
	}

	public void setActivarFK_IdMonedaPedido(Boolean habilitarResaltar) {
		this.activarFK_IdMonedaPedido= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoPedido=true;

	public Boolean getActivarFK_IdPeriodoPedido() {
		return this.activarFK_IdPeriodoPedido;
	}

	public void setActivarFK_IdPeriodoPedido(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoPedido= habilitarResaltar;
	}

	public Boolean activarFK_IdResponsablePedido=true;

	public Boolean getActivarFK_IdResponsablePedido() {
		return this.activarFK_IdResponsablePedido;
	}

	public void setActivarFK_IdResponsablePedido(Boolean habilitarResaltar) {
		this.activarFK_IdResponsablePedido= habilitarResaltar;
	}

	public Boolean activarFK_IdRutaTransportePedido=true;

	public Boolean getActivarFK_IdRutaTransportePedido() {
		return this.activarFK_IdRutaTransportePedido;
	}

	public void setActivarFK_IdRutaTransportePedido(Boolean habilitarResaltar) {
		this.activarFK_IdRutaTransportePedido= habilitarResaltar;
	}

	public Boolean activarFK_IdSubClientePedido=true;

	public Boolean getActivarFK_IdSubClientePedido() {
		return this.activarFK_IdSubClientePedido;
	}

	public void setActivarFK_IdSubClientePedido(Boolean habilitarResaltar) {
		this.activarFK_IdSubClientePedido= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalPedido=true;

	public Boolean getActivarFK_IdSucursalPedido() {
		return this.activarFK_IdSucursalPedido;
	}

	public void setActivarFK_IdSucursalPedido(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalPedido= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCambioPedido=true;

	public Boolean getActivarFK_IdTipoCambioPedido() {
		return this.activarFK_IdTipoCambioPedido;
	}

	public void setActivarFK_IdTipoCambioPedido(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCambioPedido= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoLlamadaPedido=true;

	public Boolean getActivarFK_IdTipoLlamadaPedido() {
		return this.activarFK_IdTipoLlamadaPedido;
	}

	public void setActivarFK_IdTipoLlamadaPedido(Boolean habilitarResaltar) {
		this.activarFK_IdTipoLlamadaPedido= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPrecioPedido=true;

	public Boolean getActivarFK_IdTipoPrecioPedido() {
		return this.activarFK_IdTipoPrecioPedido;
	}

	public void setActivarFK_IdTipoPrecioPedido(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPrecioPedido= habilitarResaltar;
	}

	public Boolean activarFK_IdTransportePedido=true;

	public Boolean getActivarFK_IdTransportePedido() {
		return this.activarFK_IdTransportePedido;
	}

	public void setActivarFK_IdTransportePedido(Boolean habilitarResaltar) {
		this.activarFK_IdTransportePedido= habilitarResaltar;
	}

	public Boolean activarFK_IdTransportistaPedido=true;

	public Boolean getActivarFK_IdTransportistaPedido() {
		return this.activarFK_IdTransportistaPedido;
	}

	public void setActivarFK_IdTransportistaPedido(Boolean habilitarResaltar) {
		this.activarFK_IdTransportistaPedido= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioPedido=true;

	public Boolean getActivarFK_IdUsuarioPedido() {
		return this.activarFK_IdUsuarioPedido;
	}

	public void setActivarFK_IdUsuarioPedido(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioPedido= habilitarResaltar;
	}

	public Boolean activarFK_IdVendedorPedido=true;

	public Boolean getActivarFK_IdVendedorPedido() {
		return this.activarFK_IdVendedorPedido;
	}

	public void setActivarFK_IdVendedorPedido(Boolean habilitarResaltar) {
		this.activarFK_IdVendedorPedido= habilitarResaltar;
	}

	public Boolean activarFK_IdZonaPedido=true;

	public Boolean getActivarFK_IdZonaPedido() {
		return this.activarFK_IdZonaPedido;
	}

	public void setActivarFK_IdZonaPedido(Boolean habilitarResaltar) {
		this.activarFK_IdZonaPedido= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCentroCostoPedido=null;

	public Border getResaltarFK_IdCentroCostoPedido() {
		return this.resaltarFK_IdCentroCostoPedido;
	}

	public void setResaltarFK_IdCentroCostoPedido(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoPedido= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoPedido= borderResaltar;
	}

	public Border resaltarFK_IdClientePedido=null;

	public Border getResaltarFK_IdClientePedido() {
		return this.resaltarFK_IdClientePedido;
	}

	public void setResaltarFK_IdClientePedido(Border borderResaltar) {
		this.resaltarFK_IdClientePedido= borderResaltar;
	}

	public void setResaltarFK_IdClientePedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClientePedido= borderResaltar;
	}

	public Border resaltarFK_IdConsultorPedido=null;

	public Border getResaltarFK_IdConsultorPedido() {
		return this.resaltarFK_IdConsultorPedido;
	}

	public void setResaltarFK_IdConsultorPedido(Border borderResaltar) {
		this.resaltarFK_IdConsultorPedido= borderResaltar;
	}

	public void setResaltarFK_IdConsultorPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdConsultorPedido= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioPedido=null;

	public Border getResaltarFK_IdEjercicioPedido() {
		return this.resaltarFK_IdEjercicioPedido;
	}

	public void setResaltarFK_IdEjercicioPedido(Border borderResaltar) {
		this.resaltarFK_IdEjercicioPedido= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioPedido= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoPedido=null;

	public Border getResaltarFK_IdEmpleadoPedido() {
		return this.resaltarFK_IdEmpleadoPedido;
	}

	public void setResaltarFK_IdEmpleadoPedido(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoPedido= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoPedido= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPedido=null;

	public Border getResaltarFK_IdEmpresaPedido() {
		return this.resaltarFK_IdEmpresaPedido;
	}

	public void setResaltarFK_IdEmpresaPedido(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPedido= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPedido= borderResaltar;
	}

	public Border resaltarFK_IdEstadoPedidoPedido=null;

	public Border getResaltarFK_IdEstadoPedidoPedido() {
		return this.resaltarFK_IdEstadoPedidoPedido;
	}

	public void setResaltarFK_IdEstadoPedidoPedido(Border borderResaltar) {
		this.resaltarFK_IdEstadoPedidoPedido= borderResaltar;
	}

	public void setResaltarFK_IdEstadoPedidoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoPedidoPedido= borderResaltar;
	}

	public Border resaltarFK_IdFormatoPedido=null;

	public Border getResaltarFK_IdFormatoPedido() {
		return this.resaltarFK_IdFormatoPedido;
	}

	public void setResaltarFK_IdFormatoPedido(Border borderResaltar) {
		this.resaltarFK_IdFormatoPedido= borderResaltar;
	}

	public void setResaltarFK_IdFormatoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoPedido= borderResaltar;
	}

	public Border resaltarFK_IdMonedaPedido=null;

	public Border getResaltarFK_IdMonedaPedido() {
		return this.resaltarFK_IdMonedaPedido;
	}

	public void setResaltarFK_IdMonedaPedido(Border borderResaltar) {
		this.resaltarFK_IdMonedaPedido= borderResaltar;
	}

	public void setResaltarFK_IdMonedaPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMonedaPedido= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoPedido=null;

	public Border getResaltarFK_IdPeriodoPedido() {
		return this.resaltarFK_IdPeriodoPedido;
	}

	public void setResaltarFK_IdPeriodoPedido(Border borderResaltar) {
		this.resaltarFK_IdPeriodoPedido= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoPedido= borderResaltar;
	}

	public Border resaltarFK_IdResponsablePedido=null;

	public Border getResaltarFK_IdResponsablePedido() {
		return this.resaltarFK_IdResponsablePedido;
	}

	public void setResaltarFK_IdResponsablePedido(Border borderResaltar) {
		this.resaltarFK_IdResponsablePedido= borderResaltar;
	}

	public void setResaltarFK_IdResponsablePedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdResponsablePedido= borderResaltar;
	}

	public Border resaltarFK_IdRutaTransportePedido=null;

	public Border getResaltarFK_IdRutaTransportePedido() {
		return this.resaltarFK_IdRutaTransportePedido;
	}

	public void setResaltarFK_IdRutaTransportePedido(Border borderResaltar) {
		this.resaltarFK_IdRutaTransportePedido= borderResaltar;
	}

	public void setResaltarFK_IdRutaTransportePedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdRutaTransportePedido= borderResaltar;
	}

	public Border resaltarFK_IdSubClientePedido=null;

	public Border getResaltarFK_IdSubClientePedido() {
		return this.resaltarFK_IdSubClientePedido;
	}

	public void setResaltarFK_IdSubClientePedido(Border borderResaltar) {
		this.resaltarFK_IdSubClientePedido= borderResaltar;
	}

	public void setResaltarFK_IdSubClientePedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSubClientePedido= borderResaltar;
	}

	public Border resaltarFK_IdSucursalPedido=null;

	public Border getResaltarFK_IdSucursalPedido() {
		return this.resaltarFK_IdSucursalPedido;
	}

	public void setResaltarFK_IdSucursalPedido(Border borderResaltar) {
		this.resaltarFK_IdSucursalPedido= borderResaltar;
	}

	public void setResaltarFK_IdSucursalPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalPedido= borderResaltar;
	}

	public Border resaltarFK_IdTipoCambioPedido=null;

	public Border getResaltarFK_IdTipoCambioPedido() {
		return this.resaltarFK_IdTipoCambioPedido;
	}

	public void setResaltarFK_IdTipoCambioPedido(Border borderResaltar) {
		this.resaltarFK_IdTipoCambioPedido= borderResaltar;
	}

	public void setResaltarFK_IdTipoCambioPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCambioPedido= borderResaltar;
	}

	public Border resaltarFK_IdTipoLlamadaPedido=null;

	public Border getResaltarFK_IdTipoLlamadaPedido() {
		return this.resaltarFK_IdTipoLlamadaPedido;
	}

	public void setResaltarFK_IdTipoLlamadaPedido(Border borderResaltar) {
		this.resaltarFK_IdTipoLlamadaPedido= borderResaltar;
	}

	public void setResaltarFK_IdTipoLlamadaPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoLlamadaPedido= borderResaltar;
	}

	public Border resaltarFK_IdTipoPrecioPedido=null;

	public Border getResaltarFK_IdTipoPrecioPedido() {
		return this.resaltarFK_IdTipoPrecioPedido;
	}

	public void setResaltarFK_IdTipoPrecioPedido(Border borderResaltar) {
		this.resaltarFK_IdTipoPrecioPedido= borderResaltar;
	}

	public void setResaltarFK_IdTipoPrecioPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPrecioPedido= borderResaltar;
	}

	public Border resaltarFK_IdTransportePedido=null;

	public Border getResaltarFK_IdTransportePedido() {
		return this.resaltarFK_IdTransportePedido;
	}

	public void setResaltarFK_IdTransportePedido(Border borderResaltar) {
		this.resaltarFK_IdTransportePedido= borderResaltar;
	}

	public void setResaltarFK_IdTransportePedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransportePedido= borderResaltar;
	}

	public Border resaltarFK_IdTransportistaPedido=null;

	public Border getResaltarFK_IdTransportistaPedido() {
		return this.resaltarFK_IdTransportistaPedido;
	}

	public void setResaltarFK_IdTransportistaPedido(Border borderResaltar) {
		this.resaltarFK_IdTransportistaPedido= borderResaltar;
	}

	public void setResaltarFK_IdTransportistaPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransportistaPedido= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioPedido=null;

	public Border getResaltarFK_IdUsuarioPedido() {
		return this.resaltarFK_IdUsuarioPedido;
	}

	public void setResaltarFK_IdUsuarioPedido(Border borderResaltar) {
		this.resaltarFK_IdUsuarioPedido= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioPedido= borderResaltar;
	}

	public Border resaltarFK_IdVendedorPedido=null;

	public Border getResaltarFK_IdVendedorPedido() {
		return this.resaltarFK_IdVendedorPedido;
	}

	public void setResaltarFK_IdVendedorPedido(Border borderResaltar) {
		this.resaltarFK_IdVendedorPedido= borderResaltar;
	}

	public void setResaltarFK_IdVendedorPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdVendedorPedido= borderResaltar;
	}

	public Border resaltarFK_IdZonaPedido=null;

	public Border getResaltarFK_IdZonaPedido() {
		return this.resaltarFK_IdZonaPedido;
	}

	public void setResaltarFK_IdZonaPedido(Border borderResaltar) {
		this.resaltarFK_IdZonaPedido= borderResaltar;
	}

	public void setResaltarFK_IdZonaPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoBeanSwingJInternalFrame pedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdZonaPedido= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}