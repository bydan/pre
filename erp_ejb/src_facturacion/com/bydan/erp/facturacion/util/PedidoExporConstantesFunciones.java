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


import com.bydan.erp.facturacion.util.PedidoExporConstantesFunciones;
import com.bydan.erp.facturacion.util.PedidoExporParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.PedidoExporParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PedidoExporConstantesFunciones extends PedidoExporConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PedidoExpor";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PedidoExpor"+PedidoExporConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PedidoExporHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PedidoExporHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PedidoExporConstantesFunciones.SCHEMA+"_"+PedidoExporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PedidoExporHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PedidoExporConstantesFunciones.SCHEMA+"_"+PedidoExporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PedidoExporConstantesFunciones.SCHEMA+"_"+PedidoExporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PedidoExporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PedidoExporConstantesFunciones.SCHEMA+"_"+PedidoExporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoExporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PedidoExporHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoExporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoExporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PedidoExporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoExporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PedidoExporConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PedidoExporConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PedidoExporConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PedidoExporConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Pedido Exportacions";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Pedido Exportacion";
	public static final String SCLASSWEBTITULO_LOWER="Pedido Expor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PedidoExpor";
	public static final String OBJECTNAME="pedidoexpor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="pedido_expor";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select pedidoexpor from "+PedidoExporConstantesFunciones.SPERSISTENCENAME+" pedidoexpor";
	public static String QUERYSELECTNATIVE="select "+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".version_row,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_empresa,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_sucursal,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_ejercicio,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_periodo,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_anio,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_mes,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_usuario,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".numero,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".numero_preimpreso,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".fecha_emision,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".fecha_vencimiento,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_moneda,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".cotizacion,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_empleado,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_tipo_precio,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_formato,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".direccion,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_cliente,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".telefono,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".ruc,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_pais,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".lugar_entrega,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".embarque,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".negociacion,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_transporte,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_vendedor,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".forma_pago,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_sub_cliente,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_consignatario,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_consultor,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".orden,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_estado_pedido,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".descripcion,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".monto,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".saldo,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".disponible,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".descuento_porcentaje,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".total_con_iva,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".suman,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".descuento_valor,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".total_sin_iva,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".total_descuento,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".flete,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".total,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".subtotal,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".seguros,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".iva,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".financiamiento,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".monto_retencion,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".otro,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".ice,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".fecha,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".fecha_servidor,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_tipo_cambio,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".numero_fue,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_centro_costo,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_responsable,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".hora_inicio,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".hora_fin,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_transportista from "+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME;//+" as "+PedidoExporConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected PedidoExporConstantesFuncionesAdditional pedidoexporConstantesFuncionesAdditional=null;
	
	public PedidoExporConstantesFuncionesAdditional getPedidoExporConstantesFuncionesAdditional() {
		return this.pedidoexporConstantesFuncionesAdditional;
	}
	
	public void setPedidoExporConstantesFuncionesAdditional(PedidoExporConstantesFuncionesAdditional pedidoexporConstantesFuncionesAdditional) {
		try {
			this.pedidoexporConstantesFuncionesAdditional=pedidoexporConstantesFuncionesAdditional;
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
    public static final String NUMEROAUTORIZACION= "numero_preimpreso";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String IDMONEDA= "id_moneda";
    public static final String COTIZACION= "cotizacion";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDTIPOPRECIO= "id_tipo_precio";
    public static final String IDFORMATO= "id_formato";
    public static final String DIRECCION= "direccion";
    public static final String IDCLIENTE= "id_cliente";
    public static final String TELEFONO= "telefono";
    public static final String RUC= "ruc";
    public static final String IDPAIS= "id_pais";
    public static final String LUGARENTREGA= "lugar_entrega";
    public static final String EMBARQUE= "embarque";
    public static final String NEGOCIACION= "negociacion";
    public static final String IDTRANSPORTE= "id_transporte";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String FORMAPAGO= "forma_pago";
    public static final String IDSUBCLIENTE= "id_sub_cliente";
    public static final String IDCONSIGNATARIO= "id_consignatario";
    public static final String IDCONSULTOR= "id_consultor";
    public static final String ORDEN= "orden";
    public static final String IDESTADOPEDIDOEXPOR= "id_estado_pedido";
    public static final String DESCRIPCION= "descripcion";
    public static final String MONTO= "monto";
    public static final String SALDO= "saldo";
    public static final String DISPONIBLE= "disponible";
    public static final String DESCUENTOPORCENTAJE= "descuento_porcentaje";
    public static final String TOTALCONIVA= "total_con_iva";
    public static final String SUMAN= "suman";
    public static final String DESCUENTOVALOR= "descuento_valor";
    public static final String TOTALSINIVA= "total_sin_iva";
    public static final String TOTALDESCUENTO= "total_descuento";
    public static final String FLETE= "flete";
    public static final String TOTAL= "total";
    public static final String SUBTOTAL= "subtotal";
    public static final String SEGUROS= "seguros";
    public static final String IVA= "iva";
    public static final String FINANCIAMIENTO= "financiamiento";
    public static final String MONTORETENCION= "monto_retencion";
    public static final String OTRO= "otro";
    public static final String ICE= "ice";
    public static final String FECHA= "fecha";
    public static final String FECHASERVIDOR= "fecha_servidor";
    public static final String IDTIPOCAMBIO= "id_tipo_cambio";
    public static final String NUMEROFUE= "numero_fue";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDRESPONSABLE= "id_responsable";
    public static final String HORAINICIO= "hora_inicio";
    public static final String HORAFIN= "hora_fin";
    public static final String IDTRANSPORTISTA= "id_transportista";
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
    	public static final String LABEL_NUMEROAUTORIZACION= "Nro Preimpreso";
		public static final String LABEL_NUMEROAUTORIZACION_LOWER= "Numero Autorizacion";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
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
    	public static final String LABEL_IDPAIS= "Origen";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_LUGARENTREGA= "Lugar Entrega";
		public static final String LABEL_LUGARENTREGA_LOWER= "Lugar Entrega";
    	public static final String LABEL_EMBARQUE= "Embarque";
		public static final String LABEL_EMBARQUE_LOWER= "Embarque";
    	public static final String LABEL_NEGOCIACION= "Negociacion";
		public static final String LABEL_NEGOCIACION_LOWER= "Negociacion";
    	public static final String LABEL_IDTRANSPORTE= "Transporte";
		public static final String LABEL_IDTRANSPORTE_LOWER= "Transporte";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_FORMAPAGO= "Forma Pago";
		public static final String LABEL_FORMAPAGO_LOWER= "Forma Pago";
    	public static final String LABEL_IDSUBCLIENTE= "Contacto";
		public static final String LABEL_IDSUBCLIENTE_LOWER= "Sub Cliente";
    	public static final String LABEL_IDCONSIGNATARIO= "Consignatario";
		public static final String LABEL_IDCONSIGNATARIO_LOWER= "Consignatario";
    	public static final String LABEL_IDCONSULTOR= "Consultor";
		public static final String LABEL_IDCONSULTOR_LOWER= "Consultor";
    	public static final String LABEL_ORDEN= "Orden";
		public static final String LABEL_ORDEN_LOWER= "Orden";
    	public static final String LABEL_IDESTADOPEDIDOEXPOR= "Estado";
		public static final String LABEL_IDESTADOPEDIDOEXPOR_LOWER= "Estado Pedido Expor";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_MONTO= "Monto";
		public static final String LABEL_MONTO_LOWER= "Monto";
    	public static final String LABEL_SALDO= "Saldo";
		public static final String LABEL_SALDO_LOWER= "Saldo";
    	public static final String LABEL_DISPONIBLE= "Disponible";
		public static final String LABEL_DISPONIBLE_LOWER= "Disponible";
    	public static final String LABEL_DESCUENTOPORCENTAJE= "Dscto Porcentaje";
		public static final String LABEL_DESCUENTOPORCENTAJE_LOWER= "Dscto %";
    	public static final String LABEL_TOTALCONIVA= "Monto Con Iva";
		public static final String LABEL_TOTALCONIVA_LOWER= "Total Con Iva";
    	public static final String LABEL_SUMAN= "Suman";
		public static final String LABEL_SUMAN_LOWER= "Suman";
    	public static final String LABEL_DESCUENTOVALOR= "Dscto Valor";
		public static final String LABEL_DESCUENTOVALOR_LOWER= "Descuento";
    	public static final String LABEL_TOTALSINIVA= "Monto Sin Iva";
		public static final String LABEL_TOTALSINIVA_LOWER= "Total Sin Iva";
    	public static final String LABEL_TOTALDESCUENTO= "Total Dscto";
		public static final String LABEL_TOTALDESCUENTO_LOWER= "Total Descuento";
    	public static final String LABEL_FLETE= "Flete";
		public static final String LABEL_FLETE_LOWER= "Flete";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_SUBTOTAL= "Subtotal";
		public static final String LABEL_SUBTOTAL_LOWER= "Subtotal";
    	public static final String LABEL_SEGUROS= "Seguros";
		public static final String LABEL_SEGUROS_LOWER= "Seguros";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_FINANCIAMIENTO= "Financiamiento";
		public static final String LABEL_FINANCIAMIENTO_LOWER= "Financiamiento";
    	public static final String LABEL_MONTORETENCION= "Monto Retencion";
		public static final String LABEL_MONTORETENCION_LOWER= "Monto Reten";
    	public static final String LABEL_OTRO= "Otro";
		public static final String LABEL_OTRO_LOWER= "Otro";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_FECHASERVIDOR= "Fecha Servidor";
		public static final String LABEL_FECHASERVIDOR_LOWER= "Fecha Servidor";
    	public static final String LABEL_IDTIPOCAMBIO= "Tipo Cambio";
		public static final String LABEL_IDTIPOCAMBIO_LOWER= "Tipo Cambio";
    	public static final String LABEL_NUMEROFUE= "Numero Fue";
		public static final String LABEL_NUMEROFUE_LOWER= "Numero Fue";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDRESPONSABLE= "Responsable";
		public static final String LABEL_IDRESPONSABLE_LOWER= "Responsable";
    	public static final String LABEL_HORAINICIO= "Hora Inicio";
		public static final String LABEL_HORAINICIO_LOWER= "Hora Inicio";
    	public static final String LABEL_HORAFIN= "Hora Fin";
		public static final String LABEL_HORAFIN_LOWER= "Hora Fin";
    	public static final String LABEL_IDTRANSPORTISTA= "Transportista";
		public static final String LABEL_IDTRANSPORTISTA_LOWER= "Transportista";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_PREIMPRESO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PREIMPRESO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXLUGAR_ENTREGA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLUGAR_ENTREGA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXEMBARQUE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXEMBARQUE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNEGOCIACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNEGOCIACION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXFORMA_PAGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXFORMA_PAGO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXORDEN=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXORDEN=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_FUE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FUE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getPedidoExporLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDEMPRESA)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDEJERCICIO)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDPERIODO)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDANIO)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDMES)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDUSUARIO)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.NUMERO)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.NUMEROAUTORIZACION)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_NUMEROAUTORIZACION;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.FECHAEMISION)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDMONEDA)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.COTIZACION)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_COTIZACION;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDEMPLEADO)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDTIPOPRECIO)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDTIPOPRECIO;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDFORMATO)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.DIRECCION)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDCLIENTE)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.TELEFONO)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.RUC)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDPAIS)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.LUGARENTREGA)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_LUGARENTREGA;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.EMBARQUE)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_EMBARQUE;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.NEGOCIACION)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_NEGOCIACION;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDTRANSPORTE)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDTRANSPORTE;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDVENDEDOR)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.FORMAPAGO)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_FORMAPAGO;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDSUBCLIENTE)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDSUBCLIENTE;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDCONSIGNATARIO)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDCONSIGNATARIO;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDCONSULTOR)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDCONSULTOR;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.ORDEN)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_ORDEN;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDESTADOPEDIDOEXPOR)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDESTADOPEDIDOEXPOR;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.DESCRIPCION)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.MONTO)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_MONTO;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.SALDO)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_SALDO;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.DISPONIBLE)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_DISPONIBLE;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.DESCUENTOPORCENTAJE)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_DESCUENTOPORCENTAJE;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.TOTALCONIVA)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_TOTALCONIVA;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.SUMAN)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_SUMAN;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.DESCUENTOVALOR)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_DESCUENTOVALOR;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.TOTALSINIVA)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_TOTALSINIVA;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.TOTALDESCUENTO)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_TOTALDESCUENTO;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.FLETE)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.TOTAL)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.SUBTOTAL)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.SEGUROS)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_SEGUROS;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IVA)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.FINANCIAMIENTO)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_FINANCIAMIENTO;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.MONTORETENCION)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_MONTORETENCION;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.OTRO)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_OTRO;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.ICE)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.FECHA)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.FECHASERVIDOR)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_FECHASERVIDOR;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDTIPOCAMBIO)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDTIPOCAMBIO;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.NUMEROFUE)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_NUMEROFUE;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDRESPONSABLE)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDRESPONSABLE;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.HORAINICIO)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_HORAINICIO;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.HORAFIN)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_HORAFIN;}
		if(sNombreColumna.equals(PedidoExporConstantesFunciones.IDTRANSPORTISTA)) {sLabelColumna=PedidoExporConstantesFunciones.LABEL_IDTRANSPORTISTA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPedidoExporDescripcion(PedidoExpor pedidoexpor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(pedidoexpor !=null/* && pedidoexpor.getId()!=0*/) {
			if(pedidoexpor.getId()!=null) {
				sDescripcion=pedidoexpor.getId().toString();
			}//pedidoexporpedidoexpor.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPedidoExporDescripcionDetallado(PedidoExpor pedidoexpor) {
		String sDescripcion="";
			
		sDescripcion+=PedidoExporConstantesFunciones.ID+"=";
		sDescripcion+=pedidoexpor.getId().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=pedidoexpor.getVersionRow().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=pedidoexpor.getid_empresa().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=pedidoexpor.getid_sucursal().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=pedidoexpor.getid_ejercicio().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=pedidoexpor.getid_periodo().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDANIO+"=";
		sDescripcion+=pedidoexpor.getid_anio().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDMES+"=";
		sDescripcion+=pedidoexpor.getid_mes().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=pedidoexpor.getid_usuario().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.NUMERO+"=";
		sDescripcion+=pedidoexpor.getnumero()+",";
		sDescripcion+=PedidoExporConstantesFunciones.NUMEROAUTORIZACION+"=";
		sDescripcion+=pedidoexpor.getnumero_preimpreso()+",";
		sDescripcion+=PedidoExporConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=pedidoexpor.getfecha_emision().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=pedidoexpor.getfecha_vencimiento().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=pedidoexpor.getid_moneda().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.COTIZACION+"=";
		sDescripcion+=pedidoexpor.getcotizacion().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=pedidoexpor.getid_empleado().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDTIPOPRECIO+"=";
		sDescripcion+=pedidoexpor.getid_tipo_precio().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=pedidoexpor.getid_formato().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.DIRECCION+"=";
		sDescripcion+=pedidoexpor.getdireccion()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=pedidoexpor.getid_cliente().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.TELEFONO+"=";
		sDescripcion+=pedidoexpor.gettelefono()+",";
		sDescripcion+=PedidoExporConstantesFunciones.RUC+"=";
		sDescripcion+=pedidoexpor.getruc()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDPAIS+"=";
		sDescripcion+=pedidoexpor.getid_pais().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.LUGARENTREGA+"=";
		sDescripcion+=pedidoexpor.getlugar_entrega()+",";
		sDescripcion+=PedidoExporConstantesFunciones.EMBARQUE+"=";
		sDescripcion+=pedidoexpor.getembarque()+",";
		sDescripcion+=PedidoExporConstantesFunciones.NEGOCIACION+"=";
		sDescripcion+=pedidoexpor.getnegociacion()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDTRANSPORTE+"=";
		sDescripcion+=pedidoexpor.getid_transporte().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=pedidoexpor.getid_vendedor().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.FORMAPAGO+"=";
		sDescripcion+=pedidoexpor.getforma_pago()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDSUBCLIENTE+"=";
		sDescripcion+=pedidoexpor.getid_sub_cliente().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDCONSIGNATARIO+"=";
		sDescripcion+=pedidoexpor.getid_consignatario().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDCONSULTOR+"=";
		sDescripcion+=pedidoexpor.getid_consultor().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.ORDEN+"=";
		sDescripcion+=pedidoexpor.getorden()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDESTADOPEDIDOEXPOR+"=";
		sDescripcion+=pedidoexpor.getid_estado_pedido().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=pedidoexpor.getdescripcion()+",";
		sDescripcion+=PedidoExporConstantesFunciones.MONTO+"=";
		sDescripcion+=pedidoexpor.getmonto().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.SALDO+"=";
		sDescripcion+=pedidoexpor.getsaldo().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.DISPONIBLE+"=";
		sDescripcion+=pedidoexpor.getdisponible().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.DESCUENTOPORCENTAJE+"=";
		sDescripcion+=pedidoexpor.getdescuento_porcentaje().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.TOTALCONIVA+"=";
		sDescripcion+=pedidoexpor.gettotal_con_iva().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.SUMAN+"=";
		sDescripcion+=pedidoexpor.getsuman().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.DESCUENTOVALOR+"=";
		sDescripcion+=pedidoexpor.getdescuento_valor().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.TOTALSINIVA+"=";
		sDescripcion+=pedidoexpor.gettotal_sin_iva().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.TOTALDESCUENTO+"=";
		sDescripcion+=pedidoexpor.gettotal_descuento().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.FLETE+"=";
		sDescripcion+=pedidoexpor.getflete().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.TOTAL+"=";
		sDescripcion+=pedidoexpor.gettotal().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=pedidoexpor.getsubtotal().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.SEGUROS+"=";
		sDescripcion+=pedidoexpor.getseguros().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IVA+"=";
		sDescripcion+=pedidoexpor.getiva().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.FINANCIAMIENTO+"=";
		sDescripcion+=pedidoexpor.getfinanciamiento().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.MONTORETENCION+"=";
		sDescripcion+=pedidoexpor.getmonto_retencion().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.OTRO+"=";
		sDescripcion+=pedidoexpor.getotro().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.ICE+"=";
		sDescripcion+=pedidoexpor.getice().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.FECHA+"=";
		sDescripcion+=pedidoexpor.getfecha().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.FECHASERVIDOR+"=";
		sDescripcion+=pedidoexpor.getfecha_servidor().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDTIPOCAMBIO+"=";
		sDescripcion+=pedidoexpor.getid_tipo_cambio().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.NUMEROFUE+"=";
		sDescripcion+=pedidoexpor.getnumero_fue()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=pedidoexpor.getid_centro_costo().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDRESPONSABLE+"=";
		sDescripcion+=pedidoexpor.getid_responsable().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.HORAINICIO+"=";
		sDescripcion+=pedidoexpor.gethora_inicio().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.HORAFIN+"=";
		sDescripcion+=pedidoexpor.gethora_fin().toString()+",";
		sDescripcion+=PedidoExporConstantesFunciones.IDTRANSPORTISTA+"=";
		sDescripcion+=pedidoexpor.getid_transportista().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPedidoExporDescripcion(PedidoExpor pedidoexpor,String sValor) throws Exception {			
		if(pedidoexpor !=null) {
			//pedidoexporpedidoexpor.getId().toString();
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

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
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

	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vendedor!=null/*&&vendedor.getId()>0*/) {
			sDescripcion=VendedorConstantesFunciones.getVendedorDescripcion(vendedor);
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

	public static String getConsignatarioDescripcion(Consignatario consignatario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(consignatario!=null/*&&consignatario.getId()>0*/) {
			sDescripcion=ConsignatarioConstantesFunciones.getConsignatarioDescripcion(consignatario);
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

	public static String getEstadoPedidoExporDescripcion(EstadoPedido estadopedido) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadopedido!=null/*&&estadopedido.getId()>0*/) {
			sDescripcion=EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(estadopedido);
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

	public static String getResponsableDescripcion(Responsable responsable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(responsable!=null/*&&responsable.getId()>0*/) {
			sDescripcion=ResponsableConstantesFunciones.getResponsableDescripcion(responsable);
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
		} else if(sNombreIndice.equals("FK_IdConsignatario")) {
			sNombreIndice="Tipo=  Por Consignatario";
		} else if(sNombreIndice.equals("FK_IdConsultor")) {
			sNombreIndice="Tipo=  Por Consultor";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoPedidoExpor")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Origen";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdResponsable")) {
			sNombreIndice="Tipo=  Por Responsable";
		} else if(sNombreIndice.equals("FK_IdSubCliente")) {
			sNombreIndice="Tipo=  Por Contacto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCambio")) {
			sNombreIndice="Tipo=  Por Tipo Cambio";
		} else if(sNombreIndice.equals("FK_IdTipoPrecio")) {
			sNombreIndice="Tipo=  Por Tipo Precio";
		} else if(sNombreIndice.equals("FK_IdTransporte")) {
			sNombreIndice="Tipo=  Por Transporte";
		} else if(sNombreIndice.equals("FK_IdTransportista")) {
			sNombreIndice="Tipo=  Por Transportista";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		} else if(sNombreIndice.equals("FK_IdVendedor")) {
			sNombreIndice="Tipo=  Por Vendedor";
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

	public static String getDetalleIndiceFK_IdConsignatario(Long id_consignatario) {
		String sDetalleIndice=" Parametros->";
		if(id_consignatario!=null) {sDetalleIndice+=" Codigo Unico De Consignatario="+id_consignatario.toString();} 

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

	public static String getDetalleIndiceFK_IdEstadoPedidoExpor(Long id_estado_pedido) {
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

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Origen="+id_pais.toString();} 

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

	public static String getDetalleIndiceFK_IdTipoPrecio(Long id_tipo_precio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_precio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Precio="+id_tipo_precio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransporte(Long id_transporte) {
		String sDetalleIndice=" Parametros->";
		if(id_transporte!=null) {sDetalleIndice+=" Codigo Unico De Transporte="+id_transporte.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosPedidoExpor(PedidoExpor pedidoexpor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pedidoexpor.setnumero(pedidoexpor.getnumero().trim());
		pedidoexpor.setnumero_preimpreso(pedidoexpor.getnumero_preimpreso().trim());
		pedidoexpor.setdireccion(pedidoexpor.getdireccion().trim());
		pedidoexpor.settelefono(pedidoexpor.gettelefono().trim());
		pedidoexpor.setruc(pedidoexpor.getruc().trim());
		pedidoexpor.setlugar_entrega(pedidoexpor.getlugar_entrega().trim());
		pedidoexpor.setembarque(pedidoexpor.getembarque().trim());
		pedidoexpor.setnegociacion(pedidoexpor.getnegociacion().trim());
		pedidoexpor.setforma_pago(pedidoexpor.getforma_pago().trim());
		pedidoexpor.setorden(pedidoexpor.getorden().trim());
		pedidoexpor.setdescripcion(pedidoexpor.getdescripcion().trim());
		pedidoexpor.setnumero_fue(pedidoexpor.getnumero_fue().trim());
	}
	
	public static void quitarEspaciosPedidoExpors(List<PedidoExpor> pedidoexpors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PedidoExpor pedidoexpor: pedidoexpors) {
			pedidoexpor.setnumero(pedidoexpor.getnumero().trim());
			pedidoexpor.setnumero_preimpreso(pedidoexpor.getnumero_preimpreso().trim());
			pedidoexpor.setdireccion(pedidoexpor.getdireccion().trim());
			pedidoexpor.settelefono(pedidoexpor.gettelefono().trim());
			pedidoexpor.setruc(pedidoexpor.getruc().trim());
			pedidoexpor.setlugar_entrega(pedidoexpor.getlugar_entrega().trim());
			pedidoexpor.setembarque(pedidoexpor.getembarque().trim());
			pedidoexpor.setnegociacion(pedidoexpor.getnegociacion().trim());
			pedidoexpor.setforma_pago(pedidoexpor.getforma_pago().trim());
			pedidoexpor.setorden(pedidoexpor.getorden().trim());
			pedidoexpor.setdescripcion(pedidoexpor.getdescripcion().trim());
			pedidoexpor.setnumero_fue(pedidoexpor.getnumero_fue().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPedidoExpor(PedidoExpor pedidoexpor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && pedidoexpor.getConCambioAuxiliar()) {
			pedidoexpor.setIsDeleted(pedidoexpor.getIsDeletedAuxiliar());	
			pedidoexpor.setIsNew(pedidoexpor.getIsNewAuxiliar());	
			pedidoexpor.setIsChanged(pedidoexpor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			pedidoexpor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			pedidoexpor.setIsDeletedAuxiliar(false);	
			pedidoexpor.setIsNewAuxiliar(false);	
			pedidoexpor.setIsChangedAuxiliar(false);
			
			pedidoexpor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPedidoExpors(List<PedidoExpor> pedidoexpors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PedidoExpor pedidoexpor : pedidoexpors) {
			if(conAsignarBase && pedidoexpor.getConCambioAuxiliar()) {
				pedidoexpor.setIsDeleted(pedidoexpor.getIsDeletedAuxiliar());	
				pedidoexpor.setIsNew(pedidoexpor.getIsNewAuxiliar());	
				pedidoexpor.setIsChanged(pedidoexpor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				pedidoexpor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				pedidoexpor.setIsDeletedAuxiliar(false);	
				pedidoexpor.setIsNewAuxiliar(false);	
				pedidoexpor.setIsChangedAuxiliar(false);
				
				pedidoexpor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPedidoExpor(PedidoExpor pedidoexpor,Boolean conEnteros) throws Exception  {
		pedidoexpor.setcotizacion(0.0);
		pedidoexpor.setmonto(0.0);
		pedidoexpor.setsaldo(0.0);
		pedidoexpor.setdisponible(0.0);
		pedidoexpor.setdescuento_porcentaje(0.0);
		pedidoexpor.settotal_con_iva(0.0);
		pedidoexpor.setsuman(0.0);
		pedidoexpor.setdescuento_valor(0.0);
		pedidoexpor.settotal_sin_iva(0.0);
		pedidoexpor.settotal_descuento(0.0);
		pedidoexpor.setflete(0.0);
		pedidoexpor.settotal(0.0);
		pedidoexpor.setsubtotal(0.0);
		pedidoexpor.setseguros(0.0);
		pedidoexpor.setiva(0.0);
		pedidoexpor.setfinanciamiento(0.0);
		pedidoexpor.setmonto_retencion(0.0);
		pedidoexpor.setotro(0.0);
		pedidoexpor.setice(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPedidoExpors(List<PedidoExpor> pedidoexpors,Boolean conEnteros) throws Exception  {
		
		for(PedidoExpor pedidoexpor: pedidoexpors) {
			pedidoexpor.setcotizacion(0.0);
			pedidoexpor.setmonto(0.0);
			pedidoexpor.setsaldo(0.0);
			pedidoexpor.setdisponible(0.0);
			pedidoexpor.setdescuento_porcentaje(0.0);
			pedidoexpor.settotal_con_iva(0.0);
			pedidoexpor.setsuman(0.0);
			pedidoexpor.setdescuento_valor(0.0);
			pedidoexpor.settotal_sin_iva(0.0);
			pedidoexpor.settotal_descuento(0.0);
			pedidoexpor.setflete(0.0);
			pedidoexpor.settotal(0.0);
			pedidoexpor.setsubtotal(0.0);
			pedidoexpor.setseguros(0.0);
			pedidoexpor.setiva(0.0);
			pedidoexpor.setfinanciamiento(0.0);
			pedidoexpor.setmonto_retencion(0.0);
			pedidoexpor.setotro(0.0);
			pedidoexpor.setice(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPedidoExpor(List<PedidoExpor> pedidoexpors,PedidoExpor pedidoexporAux) throws Exception  {
		PedidoExporConstantesFunciones.InicializarValoresPedidoExpor(pedidoexporAux,true);
		
		for(PedidoExpor pedidoexpor: pedidoexpors) {
			if(pedidoexpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			pedidoexporAux.setcotizacion(pedidoexporAux.getcotizacion()+pedidoexpor.getcotizacion());			
			pedidoexporAux.setmonto(pedidoexporAux.getmonto()+pedidoexpor.getmonto());			
			pedidoexporAux.setsaldo(pedidoexporAux.getsaldo()+pedidoexpor.getsaldo());			
			pedidoexporAux.setdisponible(pedidoexporAux.getdisponible()+pedidoexpor.getdisponible());			
			pedidoexporAux.setdescuento_porcentaje(pedidoexporAux.getdescuento_porcentaje()+pedidoexpor.getdescuento_porcentaje());			
			pedidoexporAux.settotal_con_iva(pedidoexporAux.gettotal_con_iva()+pedidoexpor.gettotal_con_iva());			
			pedidoexporAux.setsuman(pedidoexporAux.getsuman()+pedidoexpor.getsuman());			
			pedidoexporAux.setdescuento_valor(pedidoexporAux.getdescuento_valor()+pedidoexpor.getdescuento_valor());			
			pedidoexporAux.settotal_sin_iva(pedidoexporAux.gettotal_sin_iva()+pedidoexpor.gettotal_sin_iva());			
			pedidoexporAux.settotal_descuento(pedidoexporAux.gettotal_descuento()+pedidoexpor.gettotal_descuento());			
			pedidoexporAux.setflete(pedidoexporAux.getflete()+pedidoexpor.getflete());			
			pedidoexporAux.settotal(pedidoexporAux.gettotal()+pedidoexpor.gettotal());			
			pedidoexporAux.setsubtotal(pedidoexporAux.getsubtotal()+pedidoexpor.getsubtotal());			
			pedidoexporAux.setseguros(pedidoexporAux.getseguros()+pedidoexpor.getseguros());			
			pedidoexporAux.setiva(pedidoexporAux.getiva()+pedidoexpor.getiva());			
			pedidoexporAux.setfinanciamiento(pedidoexporAux.getfinanciamiento()+pedidoexpor.getfinanciamiento());			
			pedidoexporAux.setmonto_retencion(pedidoexporAux.getmonto_retencion()+pedidoexpor.getmonto_retencion());			
			pedidoexporAux.setotro(pedidoexporAux.getotro()+pedidoexpor.getotro());			
			pedidoexporAux.setice(pedidoexporAux.getice()+pedidoexpor.getice());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPedidoExpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PedidoExporConstantesFunciones.getArrayColumnasGlobalesPedidoExpor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPedidoExpor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoExporConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoExporConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoExporConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoExporConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoExporConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoExporConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoExporConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoExporConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoExporConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoExporConstantesFunciones.IDUSUARIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoExporConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoExporConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPedidoExpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PedidoExpor> pedidoexpors,PedidoExpor pedidoexpor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PedidoExpor pedidoexporAux: pedidoexpors) {
			if(pedidoexporAux!=null && pedidoexpor!=null) {
				if((pedidoexporAux.getId()==null && pedidoexpor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(pedidoexporAux.getId()!=null && pedidoexpor.getId()!=null){
					if(pedidoexporAux.getId().equals(pedidoexpor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPedidoExpor(List<PedidoExpor> pedidoexpors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double cotizacionTotal=0.0;
		Double montoTotal=0.0;
		Double saldoTotal=0.0;
		Double disponibleTotal=0.0;
		Double descuento_porcentajeTotal=0.0;
		Double total_con_ivaTotal=0.0;
		Double sumanTotal=0.0;
		Double descuento_valorTotal=0.0;
		Double total_sin_ivaTotal=0.0;
		Double total_descuentoTotal=0.0;
		Double fleteTotal=0.0;
		Double totalTotal=0.0;
		Double subtotalTotal=0.0;
		Double segurosTotal=0.0;
		Double ivaTotal=0.0;
		Double financiamientoTotal=0.0;
		Double monto_retencionTotal=0.0;
		Double otroTotal=0.0;
		Double iceTotal=0.0;
	
		for(PedidoExpor pedidoexpor: pedidoexpors) {			
			if(pedidoexpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cotizacionTotal+=pedidoexpor.getcotizacion();
			montoTotal+=pedidoexpor.getmonto();
			saldoTotal+=pedidoexpor.getsaldo();
			disponibleTotal+=pedidoexpor.getdisponible();
			descuento_porcentajeTotal+=pedidoexpor.getdescuento_porcentaje();
			total_con_ivaTotal+=pedidoexpor.gettotal_con_iva();
			sumanTotal+=pedidoexpor.getsuman();
			descuento_valorTotal+=pedidoexpor.getdescuento_valor();
			total_sin_ivaTotal+=pedidoexpor.gettotal_sin_iva();
			total_descuentoTotal+=pedidoexpor.gettotal_descuento();
			fleteTotal+=pedidoexpor.getflete();
			totalTotal+=pedidoexpor.gettotal();
			subtotalTotal+=pedidoexpor.getsubtotal();
			segurosTotal+=pedidoexpor.getseguros();
			ivaTotal+=pedidoexpor.getiva();
			financiamientoTotal+=pedidoexpor.getfinanciamiento();
			monto_retencionTotal+=pedidoexpor.getmonto_retencion();
			otroTotal+=pedidoexpor.getotro();
			iceTotal+=pedidoexpor.getice();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoExporConstantesFunciones.COTIZACION);
		datoGeneral.setsDescripcion(PedidoExporConstantesFunciones.LABEL_COTIZACION);
		datoGeneral.setdValorDouble(cotizacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoExporConstantesFunciones.MONTO);
		datoGeneral.setsDescripcion(PedidoExporConstantesFunciones.LABEL_MONTO);
		datoGeneral.setdValorDouble(montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoExporConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(PedidoExporConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoExporConstantesFunciones.DISPONIBLE);
		datoGeneral.setsDescripcion(PedidoExporConstantesFunciones.LABEL_DISPONIBLE);
		datoGeneral.setdValorDouble(disponibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoExporConstantesFunciones.DESCUENTOPORCENTAJE);
		datoGeneral.setsDescripcion(PedidoExporConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
		datoGeneral.setdValorDouble(descuento_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoExporConstantesFunciones.TOTALCONIVA);
		datoGeneral.setsDescripcion(PedidoExporConstantesFunciones.LABEL_TOTALCONIVA);
		datoGeneral.setdValorDouble(total_con_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoExporConstantesFunciones.SUMAN);
		datoGeneral.setsDescripcion(PedidoExporConstantesFunciones.LABEL_SUMAN);
		datoGeneral.setdValorDouble(sumanTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoExporConstantesFunciones.DESCUENTOVALOR);
		datoGeneral.setsDescripcion(PedidoExporConstantesFunciones.LABEL_DESCUENTOVALOR);
		datoGeneral.setdValorDouble(descuento_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoExporConstantesFunciones.TOTALSINIVA);
		datoGeneral.setsDescripcion(PedidoExporConstantesFunciones.LABEL_TOTALSINIVA);
		datoGeneral.setdValorDouble(total_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoExporConstantesFunciones.TOTALDESCUENTO);
		datoGeneral.setsDescripcion(PedidoExporConstantesFunciones.LABEL_TOTALDESCUENTO);
		datoGeneral.setdValorDouble(total_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoExporConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(PedidoExporConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoExporConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(PedidoExporConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoExporConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(PedidoExporConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(subtotalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoExporConstantesFunciones.SEGUROS);
		datoGeneral.setsDescripcion(PedidoExporConstantesFunciones.LABEL_SEGUROS);
		datoGeneral.setdValorDouble(segurosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoExporConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoExporConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(PedidoExporConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoExporConstantesFunciones.MONTORETENCION);
		datoGeneral.setsDescripcion(PedidoExporConstantesFunciones.LABEL_MONTORETENCION);
		datoGeneral.setdValorDouble(monto_retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoExporConstantesFunciones.OTRO);
		datoGeneral.setsDescripcion(PedidoExporConstantesFunciones.LABEL_OTRO);
		datoGeneral.setdValorDouble(otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoExporConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(PedidoExporConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPedidoExpor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_ID, PedidoExporConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_VERSIONROW, PedidoExporConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDEMPRESA, PedidoExporConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDSUCURSAL, PedidoExporConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDEJERCICIO, PedidoExporConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDPERIODO, PedidoExporConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDANIO, PedidoExporConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDMES, PedidoExporConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDUSUARIO, PedidoExporConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_NUMERO, PedidoExporConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_NUMEROAUTORIZACION, PedidoExporConstantesFunciones.NUMEROAUTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_FECHAEMISION, PedidoExporConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_FECHAVENCIMIENTO, PedidoExporConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDMONEDA, PedidoExporConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_COTIZACION, PedidoExporConstantesFunciones.COTIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDEMPLEADO, PedidoExporConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDTIPOPRECIO, PedidoExporConstantesFunciones.IDTIPOPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDFORMATO, PedidoExporConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_DIRECCION, PedidoExporConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDCLIENTE, PedidoExporConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_TELEFONO, PedidoExporConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_RUC, PedidoExporConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDPAIS, PedidoExporConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_LUGARENTREGA, PedidoExporConstantesFunciones.LUGARENTREGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_EMBARQUE, PedidoExporConstantesFunciones.EMBARQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_NEGOCIACION, PedidoExporConstantesFunciones.NEGOCIACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDTRANSPORTE, PedidoExporConstantesFunciones.IDTRANSPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDVENDEDOR, PedidoExporConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_FORMAPAGO, PedidoExporConstantesFunciones.FORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDSUBCLIENTE, PedidoExporConstantesFunciones.IDSUBCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDCONSIGNATARIO, PedidoExporConstantesFunciones.IDCONSIGNATARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDCONSULTOR, PedidoExporConstantesFunciones.IDCONSULTOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_ORDEN, PedidoExporConstantesFunciones.ORDEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDESTADOPEDIDOEXPOR, PedidoExporConstantesFunciones.IDESTADOPEDIDOEXPOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_DESCRIPCION, PedidoExporConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_MONTO, PedidoExporConstantesFunciones.MONTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_SALDO, PedidoExporConstantesFunciones.SALDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_DISPONIBLE, PedidoExporConstantesFunciones.DISPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_DESCUENTOPORCENTAJE, PedidoExporConstantesFunciones.DESCUENTOPORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_TOTALCONIVA, PedidoExporConstantesFunciones.TOTALCONIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_SUMAN, PedidoExporConstantesFunciones.SUMAN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_DESCUENTOVALOR, PedidoExporConstantesFunciones.DESCUENTOVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_TOTALSINIVA, PedidoExporConstantesFunciones.TOTALSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_TOTALDESCUENTO, PedidoExporConstantesFunciones.TOTALDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_FLETE, PedidoExporConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_TOTAL, PedidoExporConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_SUBTOTAL, PedidoExporConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_SEGUROS, PedidoExporConstantesFunciones.SEGUROS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IVA, PedidoExporConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_FINANCIAMIENTO, PedidoExporConstantesFunciones.FINANCIAMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_MONTORETENCION, PedidoExporConstantesFunciones.MONTORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_OTRO, PedidoExporConstantesFunciones.OTRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_ICE, PedidoExporConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_FECHA, PedidoExporConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_FECHASERVIDOR, PedidoExporConstantesFunciones.FECHASERVIDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDTIPOCAMBIO, PedidoExporConstantesFunciones.IDTIPOCAMBIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_NUMEROFUE, PedidoExporConstantesFunciones.NUMEROFUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDCENTROCOSTO, PedidoExporConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDRESPONSABLE, PedidoExporConstantesFunciones.IDRESPONSABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_HORAINICIO, PedidoExporConstantesFunciones.HORAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_HORAFIN, PedidoExporConstantesFunciones.HORAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoExporConstantesFunciones.LABEL_IDTRANSPORTISTA, PedidoExporConstantesFunciones.IDTRANSPORTISTA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPedidoExpor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.NUMEROAUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.COTIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDTIPOPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.LUGARENTREGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.EMBARQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.NEGOCIACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDTRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.FORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDSUBCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDCONSIGNATARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDCONSULTOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.ORDEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDESTADOPEDIDOEXPOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.MONTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.SALDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.DISPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.DESCUENTOPORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.TOTALCONIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.SUMAN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.DESCUENTOVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.TOTALSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.TOTALDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.SEGUROS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.FINANCIAMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.MONTORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.OTRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.FECHASERVIDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDTIPOCAMBIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.NUMEROFUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDRESPONSABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.HORAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.HORAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoExporConstantesFunciones.IDTRANSPORTISTA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidoExpor() throws Exception  {
		return PedidoExporConstantesFunciones.getTiposSeleccionarPedidoExpor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidoExpor(Boolean conFk) throws Exception  {
		return PedidoExporConstantesFunciones.getTiposSeleccionarPedidoExpor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidoExpor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_NUMEROAUTORIZACION);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_NUMEROAUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_COTIZACION);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_COTIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDTIPOPRECIO);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDTIPOPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_LUGARENTREGA);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_LUGARENTREGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_EMBARQUE);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_EMBARQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_NEGOCIACION);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_NEGOCIACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDTRANSPORTE);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDTRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_FORMAPAGO);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_FORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDSUBCLIENTE);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDSUBCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDCONSIGNATARIO);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDCONSIGNATARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDCONSULTOR);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDCONSULTOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_ORDEN);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_ORDEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDESTADOPEDIDOEXPOR);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDESTADOPEDIDOEXPOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_MONTO);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_MONTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_SALDO);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_SALDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_DISPONIBLE);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_DISPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_TOTALCONIVA);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_TOTALCONIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_SUMAN);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_SUMAN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_DESCUENTOVALOR);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_DESCUENTOVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_TOTALSINIVA);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_TOTALSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_TOTALDESCUENTO);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_TOTALDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_SEGUROS);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_SEGUROS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_FINANCIAMIENTO);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_FINANCIAMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_MONTORETENCION);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_MONTORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_OTRO);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_OTRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_FECHASERVIDOR);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_FECHASERVIDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDTIPOCAMBIO);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDTIPOCAMBIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_NUMEROFUE);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_NUMEROFUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDRESPONSABLE);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDRESPONSABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_HORAINICIO);
		reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_HORAINICIO);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_HORAFIN);
		reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_HORAFIN);

		arrTiposSeleccionarTodos.add(reporte);
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoExporConstantesFunciones.LABEL_IDTRANSPORTISTA);
			reporte.setsDescripcion(PedidoExporConstantesFunciones.LABEL_IDTRANSPORTISTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPedidoExpor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPedidoExpor(PedidoExpor pedidoexporAux) throws Exception {
		
			pedidoexporAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pedidoexporAux.getEmpresa()));
			pedidoexporAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(pedidoexporAux.getSucursal()));
			pedidoexporAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(pedidoexporAux.getEjercicio()));
			pedidoexporAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(pedidoexporAux.getPeriodo()));
			pedidoexporAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(pedidoexporAux.getAnio()));
			pedidoexporAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(pedidoexporAux.getMes()));
			pedidoexporAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(pedidoexporAux.getUsuario()));
			pedidoexporAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(pedidoexporAux.getMoneda()));
			pedidoexporAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(pedidoexporAux.getEmpleado()));
			pedidoexporAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(pedidoexporAux.getTipoPrecio()));
			pedidoexporAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(pedidoexporAux.getFormato()));
			pedidoexporAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(pedidoexporAux.getCliente()));
			pedidoexporAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(pedidoexporAux.getPais()));
			pedidoexporAux.settransporte_descripcion(TransporteConstantesFunciones.getTransporteDescripcion(pedidoexporAux.getTransporte()));
			pedidoexporAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(pedidoexporAux.getVendedor()));
			pedidoexporAux.setsubcliente_descripcion(SubClienteConstantesFunciones.getSubClienteDescripcion(pedidoexporAux.getSubCliente()));
			pedidoexporAux.setconsignatario_descripcion(ConsignatarioConstantesFunciones.getConsignatarioDescripcion(pedidoexporAux.getConsignatario()));
			pedidoexporAux.setconsultor_descripcion(ConsultorConstantesFunciones.getConsultorDescripcion(pedidoexporAux.getConsultor()));
			pedidoexporAux.setestadopedidoexpor_descripcion(EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(pedidoexporAux.getEstadoPedidoExpor()));
			pedidoexporAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(pedidoexporAux.getTipoCambio()));
			pedidoexporAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(pedidoexporAux.getCentroCosto()));
			pedidoexporAux.setresponsable_descripcion(ResponsableConstantesFunciones.getResponsableDescripcion(pedidoexporAux.getResponsable()));
			pedidoexporAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(pedidoexporAux.getTransportista()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPedidoExpor(List<PedidoExpor> pedidoexporsTemp) throws Exception {
		for(PedidoExpor pedidoexporAux:pedidoexporsTemp) {
			
			pedidoexporAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pedidoexporAux.getEmpresa()));
			pedidoexporAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(pedidoexporAux.getSucursal()));
			pedidoexporAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(pedidoexporAux.getEjercicio()));
			pedidoexporAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(pedidoexporAux.getPeriodo()));
			pedidoexporAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(pedidoexporAux.getAnio()));
			pedidoexporAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(pedidoexporAux.getMes()));
			pedidoexporAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(pedidoexporAux.getUsuario()));
			pedidoexporAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(pedidoexporAux.getMoneda()));
			pedidoexporAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(pedidoexporAux.getEmpleado()));
			pedidoexporAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(pedidoexporAux.getTipoPrecio()));
			pedidoexporAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(pedidoexporAux.getFormato()));
			pedidoexporAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(pedidoexporAux.getCliente()));
			pedidoexporAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(pedidoexporAux.getPais()));
			pedidoexporAux.settransporte_descripcion(TransporteConstantesFunciones.getTransporteDescripcion(pedidoexporAux.getTransporte()));
			pedidoexporAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(pedidoexporAux.getVendedor()));
			pedidoexporAux.setsubcliente_descripcion(SubClienteConstantesFunciones.getSubClienteDescripcion(pedidoexporAux.getSubCliente()));
			pedidoexporAux.setconsignatario_descripcion(ConsignatarioConstantesFunciones.getConsignatarioDescripcion(pedidoexporAux.getConsignatario()));
			pedidoexporAux.setconsultor_descripcion(ConsultorConstantesFunciones.getConsultorDescripcion(pedidoexporAux.getConsultor()));
			pedidoexporAux.setestadopedidoexpor_descripcion(EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(pedidoexporAux.getEstadoPedidoExpor()));
			pedidoexporAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(pedidoexporAux.getTipoCambio()));
			pedidoexporAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(pedidoexporAux.getCentroCosto()));
			pedidoexporAux.setresponsable_descripcion(ResponsableConstantesFunciones.getResponsableDescripcion(pedidoexporAux.getResponsable()));
			pedidoexporAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(pedidoexporAux.getTransportista()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPedidoExpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Transporte.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(SubCliente.class));
				classes.add(new Classe(Consignatario.class));
				classes.add(new Classe(Consultor.class));
				classes.add(new Classe(EstadoPedido.class));
				classes.add(new Classe(TipoCambio.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(Responsable.class));
				classes.add(new Classe(Transportista.class));
				
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
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transporte.class)) {
						classes.add(new Classe(Transporte.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SubCliente.class)) {
						classes.add(new Classe(SubCliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Consignatario.class)) {
						classes.add(new Classe(Consignatario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Consultor.class)) {
						classes.add(new Classe(Consultor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoPedido.class)) {
						classes.add(new Classe(EstadoPedido.class));
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
					if(clas.clas.equals(Responsable.class)) {
						classes.add(new Classe(Responsable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transportista.class)) {
						classes.add(new Classe(Transportista.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPedidoExpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Transporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transporte.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(Consignatario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignatario.class)); continue;
					}

					if(Consultor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consultor.class)); continue;
					}

					if(EstadoPedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedido.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(Responsable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Responsable.class)); continue;
					}

					if(Transportista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transportista.class)); continue;
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

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Transporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transporte.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(Consignatario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignatario.class)); continue;
					}

					if(Consultor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consultor.class)); continue;
					}

					if(EstadoPedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedido.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(Responsable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Responsable.class)); continue;
					}

					if(Transportista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transportista.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedidoExpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PedidoExporConstantesFunciones.getClassesRelationshipsOfPedidoExpor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedidoExpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetallePedidoExpor.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetallePedidoExpor.class)) {
						classes.add(new Classe(DetallePedidoExpor.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPedidoExpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PedidoExporConstantesFunciones.getClassesRelationshipsFromStringsOfPedidoExpor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPedidoExpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetallePedidoExpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetallePedidoExpor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetallePedidoExpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetallePedidoExpor.class)); continue;
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
	public static void actualizarLista(PedidoExpor pedidoexpor,List<PedidoExpor> pedidoexpors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PedidoExpor pedidoexporEncontrado=null;
			
			for(PedidoExpor pedidoexporLocal:pedidoexpors) {
				if(pedidoexporLocal.getId().equals(pedidoexpor.getId())) {
					pedidoexporEncontrado=pedidoexporLocal;
					
					pedidoexporLocal.setIsChanged(pedidoexpor.getIsChanged());
					pedidoexporLocal.setIsNew(pedidoexpor.getIsNew());
					pedidoexporLocal.setIsDeleted(pedidoexpor.getIsDeleted());
					
					pedidoexporLocal.setGeneralEntityOriginal(pedidoexpor.getGeneralEntityOriginal());
					
					pedidoexporLocal.setId(pedidoexpor.getId());	
					pedidoexporLocal.setVersionRow(pedidoexpor.getVersionRow());	
					pedidoexporLocal.setid_empresa(pedidoexpor.getid_empresa());	
					pedidoexporLocal.setid_sucursal(pedidoexpor.getid_sucursal());	
					pedidoexporLocal.setid_ejercicio(pedidoexpor.getid_ejercicio());	
					pedidoexporLocal.setid_periodo(pedidoexpor.getid_periodo());	
					pedidoexporLocal.setid_anio(pedidoexpor.getid_anio());	
					pedidoexporLocal.setid_mes(pedidoexpor.getid_mes());	
					pedidoexporLocal.setid_usuario(pedidoexpor.getid_usuario());	
					pedidoexporLocal.setnumero(pedidoexpor.getnumero());	
					pedidoexporLocal.setnumero_preimpreso(pedidoexpor.getnumero_preimpreso());	
					pedidoexporLocal.setfecha_emision(pedidoexpor.getfecha_emision());	
					pedidoexporLocal.setfecha_vencimiento(pedidoexpor.getfecha_vencimiento());	
					pedidoexporLocal.setid_moneda(pedidoexpor.getid_moneda());	
					pedidoexporLocal.setcotizacion(pedidoexpor.getcotizacion());	
					pedidoexporLocal.setid_empleado(pedidoexpor.getid_empleado());	
					pedidoexporLocal.setid_tipo_precio(pedidoexpor.getid_tipo_precio());	
					pedidoexporLocal.setid_formato(pedidoexpor.getid_formato());	
					pedidoexporLocal.setdireccion(pedidoexpor.getdireccion());	
					pedidoexporLocal.setid_cliente(pedidoexpor.getid_cliente());	
					pedidoexporLocal.settelefono(pedidoexpor.gettelefono());	
					pedidoexporLocal.setruc(pedidoexpor.getruc());	
					pedidoexporLocal.setid_pais(pedidoexpor.getid_pais());	
					pedidoexporLocal.setlugar_entrega(pedidoexpor.getlugar_entrega());	
					pedidoexporLocal.setembarque(pedidoexpor.getembarque());	
					pedidoexporLocal.setnegociacion(pedidoexpor.getnegociacion());	
					pedidoexporLocal.setid_transporte(pedidoexpor.getid_transporte());	
					pedidoexporLocal.setid_vendedor(pedidoexpor.getid_vendedor());	
					pedidoexporLocal.setforma_pago(pedidoexpor.getforma_pago());	
					pedidoexporLocal.setid_sub_cliente(pedidoexpor.getid_sub_cliente());	
					pedidoexporLocal.setid_consignatario(pedidoexpor.getid_consignatario());	
					pedidoexporLocal.setid_consultor(pedidoexpor.getid_consultor());	
					pedidoexporLocal.setorden(pedidoexpor.getorden());	
					pedidoexporLocal.setid_estado_pedido(pedidoexpor.getid_estado_pedido());	
					pedidoexporLocal.setdescripcion(pedidoexpor.getdescripcion());	
					pedidoexporLocal.setmonto(pedidoexpor.getmonto());	
					pedidoexporLocal.setsaldo(pedidoexpor.getsaldo());	
					pedidoexporLocal.setdisponible(pedidoexpor.getdisponible());	
					pedidoexporLocal.setdescuento_porcentaje(pedidoexpor.getdescuento_porcentaje());	
					pedidoexporLocal.settotal_con_iva(pedidoexpor.gettotal_con_iva());	
					pedidoexporLocal.setsuman(pedidoexpor.getsuman());	
					pedidoexporLocal.setdescuento_valor(pedidoexpor.getdescuento_valor());	
					pedidoexporLocal.settotal_sin_iva(pedidoexpor.gettotal_sin_iva());	
					pedidoexporLocal.settotal_descuento(pedidoexpor.gettotal_descuento());	
					pedidoexporLocal.setflete(pedidoexpor.getflete());	
					pedidoexporLocal.settotal(pedidoexpor.gettotal());	
					pedidoexporLocal.setsubtotal(pedidoexpor.getsubtotal());	
					pedidoexporLocal.setseguros(pedidoexpor.getseguros());	
					pedidoexporLocal.setiva(pedidoexpor.getiva());	
					pedidoexporLocal.setfinanciamiento(pedidoexpor.getfinanciamiento());	
					pedidoexporLocal.setmonto_retencion(pedidoexpor.getmonto_retencion());	
					pedidoexporLocal.setotro(pedidoexpor.getotro());	
					pedidoexporLocal.setice(pedidoexpor.getice());	
					pedidoexporLocal.setfecha(pedidoexpor.getfecha());	
					pedidoexporLocal.setfecha_servidor(pedidoexpor.getfecha_servidor());	
					pedidoexporLocal.setid_tipo_cambio(pedidoexpor.getid_tipo_cambio());	
					pedidoexporLocal.setnumero_fue(pedidoexpor.getnumero_fue());	
					pedidoexporLocal.setid_centro_costo(pedidoexpor.getid_centro_costo());	
					pedidoexporLocal.setid_responsable(pedidoexpor.getid_responsable());	
					pedidoexporLocal.sethora_inicio(pedidoexpor.gethora_inicio());	
					pedidoexporLocal.sethora_fin(pedidoexpor.gethora_fin());	
					pedidoexporLocal.setid_transportista(pedidoexpor.getid_transportista());	
					
					
					pedidoexporLocal.setDetallePedidoExpors(pedidoexpor.getDetallePedidoExpors());
					
					existe=true;
					break;
				}
			}
			
			if(!pedidoexpor.getIsDeleted()) {
				if(!existe) {
					pedidoexpors.add(pedidoexpor);
				}
			} else {
				if(pedidoexporEncontrado!=null && permiteQuitar)  {
					pedidoexpors.remove(pedidoexporEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PedidoExpor pedidoexpor,List<PedidoExpor> pedidoexpors) throws Exception {
		try	{			
			for(PedidoExpor pedidoexporLocal:pedidoexpors) {
				if(pedidoexporLocal.getId().equals(pedidoexpor.getId())) {
					pedidoexporLocal.setIsSelected(pedidoexpor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPedidoExpor(List<PedidoExpor> pedidoexporsAux) throws Exception {
		//this.pedidoexporsAux=pedidoexporsAux;
		
		for(PedidoExpor pedidoexporAux:pedidoexporsAux) {
			if(pedidoexporAux.getIsChanged()) {
				pedidoexporAux.setIsChanged(false);
			}		
			
			if(pedidoexporAux.getIsNew()) {
				pedidoexporAux.setIsNew(false);
			}	
			
			if(pedidoexporAux.getIsDeleted()) {
				pedidoexporAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPedidoExpor(PedidoExpor pedidoexporAux) throws Exception {
		//this.pedidoexporAux=pedidoexporAux;
		
			if(pedidoexporAux.getIsChanged()) {
				pedidoexporAux.setIsChanged(false);
			}		
			
			if(pedidoexporAux.getIsNew()) {
				pedidoexporAux.setIsNew(false);
			}	
			
			if(pedidoexporAux.getIsDeleted()) {
				pedidoexporAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PedidoExpor pedidoexporAsignar,PedidoExpor pedidoexpor) throws Exception {
		pedidoexporAsignar.setId(pedidoexpor.getId());	
		pedidoexporAsignar.setVersionRow(pedidoexpor.getVersionRow());	
		pedidoexporAsignar.setid_empresa(pedidoexpor.getid_empresa());
		pedidoexporAsignar.setempresa_descripcion(pedidoexpor.getempresa_descripcion());	
		pedidoexporAsignar.setid_sucursal(pedidoexpor.getid_sucursal());
		pedidoexporAsignar.setsucursal_descripcion(pedidoexpor.getsucursal_descripcion());	
		pedidoexporAsignar.setid_ejercicio(pedidoexpor.getid_ejercicio());
		pedidoexporAsignar.setejercicio_descripcion(pedidoexpor.getejercicio_descripcion());	
		pedidoexporAsignar.setid_periodo(pedidoexpor.getid_periodo());
		pedidoexporAsignar.setperiodo_descripcion(pedidoexpor.getperiodo_descripcion());	
		pedidoexporAsignar.setid_anio(pedidoexpor.getid_anio());
		pedidoexporAsignar.setanio_descripcion(pedidoexpor.getanio_descripcion());	
		pedidoexporAsignar.setid_mes(pedidoexpor.getid_mes());
		pedidoexporAsignar.setmes_descripcion(pedidoexpor.getmes_descripcion());	
		pedidoexporAsignar.setid_usuario(pedidoexpor.getid_usuario());
		pedidoexporAsignar.setusuario_descripcion(pedidoexpor.getusuario_descripcion());	
		pedidoexporAsignar.setnumero(pedidoexpor.getnumero());	
		pedidoexporAsignar.setnumero_preimpreso(pedidoexpor.getnumero_preimpreso());	
		pedidoexporAsignar.setfecha_emision(pedidoexpor.getfecha_emision());	
		pedidoexporAsignar.setfecha_vencimiento(pedidoexpor.getfecha_vencimiento());	
		pedidoexporAsignar.setid_moneda(pedidoexpor.getid_moneda());
		pedidoexporAsignar.setmoneda_descripcion(pedidoexpor.getmoneda_descripcion());	
		pedidoexporAsignar.setcotizacion(pedidoexpor.getcotizacion());	
		pedidoexporAsignar.setid_empleado(pedidoexpor.getid_empleado());
		pedidoexporAsignar.setempleado_descripcion(pedidoexpor.getempleado_descripcion());	
		pedidoexporAsignar.setid_tipo_precio(pedidoexpor.getid_tipo_precio());
		pedidoexporAsignar.settipoprecio_descripcion(pedidoexpor.gettipoprecio_descripcion());	
		pedidoexporAsignar.setid_formato(pedidoexpor.getid_formato());
		pedidoexporAsignar.setformato_descripcion(pedidoexpor.getformato_descripcion());	
		pedidoexporAsignar.setdireccion(pedidoexpor.getdireccion());	
		pedidoexporAsignar.setid_cliente(pedidoexpor.getid_cliente());
		pedidoexporAsignar.setcliente_descripcion(pedidoexpor.getcliente_descripcion());	
		pedidoexporAsignar.settelefono(pedidoexpor.gettelefono());	
		pedidoexporAsignar.setruc(pedidoexpor.getruc());	
		pedidoexporAsignar.setid_pais(pedidoexpor.getid_pais());
		pedidoexporAsignar.setpais_descripcion(pedidoexpor.getpais_descripcion());	
		pedidoexporAsignar.setlugar_entrega(pedidoexpor.getlugar_entrega());	
		pedidoexporAsignar.setembarque(pedidoexpor.getembarque());	
		pedidoexporAsignar.setnegociacion(pedidoexpor.getnegociacion());	
		pedidoexporAsignar.setid_transporte(pedidoexpor.getid_transporte());
		pedidoexporAsignar.settransporte_descripcion(pedidoexpor.gettransporte_descripcion());	
		pedidoexporAsignar.setid_vendedor(pedidoexpor.getid_vendedor());
		pedidoexporAsignar.setvendedor_descripcion(pedidoexpor.getvendedor_descripcion());	
		pedidoexporAsignar.setforma_pago(pedidoexpor.getforma_pago());	
		pedidoexporAsignar.setid_sub_cliente(pedidoexpor.getid_sub_cliente());
		pedidoexporAsignar.setsubcliente_descripcion(pedidoexpor.getsubcliente_descripcion());	
		pedidoexporAsignar.setid_consignatario(pedidoexpor.getid_consignatario());
		pedidoexporAsignar.setconsignatario_descripcion(pedidoexpor.getconsignatario_descripcion());	
		pedidoexporAsignar.setid_consultor(pedidoexpor.getid_consultor());
		pedidoexporAsignar.setconsultor_descripcion(pedidoexpor.getconsultor_descripcion());	
		pedidoexporAsignar.setorden(pedidoexpor.getorden());	
		pedidoexporAsignar.setid_estado_pedido(pedidoexpor.getid_estado_pedido());
		pedidoexporAsignar.setestadopedidoexpor_descripcion(pedidoexpor.getestadopedidoexpor_descripcion());	
		pedidoexporAsignar.setdescripcion(pedidoexpor.getdescripcion());	
		pedidoexporAsignar.setmonto(pedidoexpor.getmonto());	
		pedidoexporAsignar.setsaldo(pedidoexpor.getsaldo());	
		pedidoexporAsignar.setdisponible(pedidoexpor.getdisponible());	
		pedidoexporAsignar.setdescuento_porcentaje(pedidoexpor.getdescuento_porcentaje());	
		pedidoexporAsignar.settotal_con_iva(pedidoexpor.gettotal_con_iva());	
		pedidoexporAsignar.setsuman(pedidoexpor.getsuman());	
		pedidoexporAsignar.setdescuento_valor(pedidoexpor.getdescuento_valor());	
		pedidoexporAsignar.settotal_sin_iva(pedidoexpor.gettotal_sin_iva());	
		pedidoexporAsignar.settotal_descuento(pedidoexpor.gettotal_descuento());	
		pedidoexporAsignar.setflete(pedidoexpor.getflete());	
		pedidoexporAsignar.settotal(pedidoexpor.gettotal());	
		pedidoexporAsignar.setsubtotal(pedidoexpor.getsubtotal());	
		pedidoexporAsignar.setseguros(pedidoexpor.getseguros());	
		pedidoexporAsignar.setiva(pedidoexpor.getiva());	
		pedidoexporAsignar.setfinanciamiento(pedidoexpor.getfinanciamiento());	
		pedidoexporAsignar.setmonto_retencion(pedidoexpor.getmonto_retencion());	
		pedidoexporAsignar.setotro(pedidoexpor.getotro());	
		pedidoexporAsignar.setice(pedidoexpor.getice());	
		pedidoexporAsignar.setfecha(pedidoexpor.getfecha());	
		pedidoexporAsignar.setfecha_servidor(pedidoexpor.getfecha_servidor());	
		pedidoexporAsignar.setid_tipo_cambio(pedidoexpor.getid_tipo_cambio());
		pedidoexporAsignar.settipocambio_descripcion(pedidoexpor.gettipocambio_descripcion());	
		pedidoexporAsignar.setnumero_fue(pedidoexpor.getnumero_fue());	
		pedidoexporAsignar.setid_centro_costo(pedidoexpor.getid_centro_costo());
		pedidoexporAsignar.setcentrocosto_descripcion(pedidoexpor.getcentrocosto_descripcion());	
		pedidoexporAsignar.setid_responsable(pedidoexpor.getid_responsable());
		pedidoexporAsignar.setresponsable_descripcion(pedidoexpor.getresponsable_descripcion());	
		pedidoexporAsignar.sethora_inicio(pedidoexpor.gethora_inicio());	
		pedidoexporAsignar.sethora_fin(pedidoexpor.gethora_fin());	
		pedidoexporAsignar.setid_transportista(pedidoexpor.getid_transportista());
		pedidoexporAsignar.settransportista_descripcion(pedidoexpor.gettransportista_descripcion());	
	}
	
	public static void inicializarPedidoExpor(PedidoExpor pedidoexpor) throws Exception {
		try {
				pedidoexpor.setId(0L);	
					
				pedidoexpor.setid_empresa(-1L);	
				pedidoexpor.setid_sucursal(-1L);	
				pedidoexpor.setid_ejercicio(-1L);	
				pedidoexpor.setid_periodo(-1L);	
				pedidoexpor.setid_anio(null);	
				pedidoexpor.setid_mes(null);	
				pedidoexpor.setid_usuario(-1L);	
				pedidoexpor.setnumero("");	
				pedidoexpor.setnumero_preimpreso("");	
				pedidoexpor.setfecha_emision(new Date());	
				pedidoexpor.setfecha_vencimiento(new Date());	
				pedidoexpor.setid_moneda(-1L);	
				pedidoexpor.setcotizacion(0.0);	
				pedidoexpor.setid_empleado(-1L);	
				pedidoexpor.setid_tipo_precio(-1L);	
				pedidoexpor.setid_formato(null);	
				pedidoexpor.setdireccion("");	
				pedidoexpor.setid_cliente(-1L);	
				pedidoexpor.settelefono("");	
				pedidoexpor.setruc("");	
				pedidoexpor.setid_pais(null);	
				pedidoexpor.setlugar_entrega("");	
				pedidoexpor.setembarque("");	
				pedidoexpor.setnegociacion("");	
				pedidoexpor.setid_transporte(null);	
				pedidoexpor.setid_vendedor(null);	
				pedidoexpor.setforma_pago("");	
				pedidoexpor.setid_sub_cliente(null);	
				pedidoexpor.setid_consignatario(null);	
				pedidoexpor.setid_consultor(null);	
				pedidoexpor.setorden("");	
				pedidoexpor.setid_estado_pedido(1L);	
				pedidoexpor.setdescripcion("");	
				pedidoexpor.setmonto(0.0);	
				pedidoexpor.setsaldo(0.0);	
				pedidoexpor.setdisponible(0.0);	
				pedidoexpor.setdescuento_porcentaje(0.0);	
				pedidoexpor.settotal_con_iva(0.0);	
				pedidoexpor.setsuman(0.0);	
				pedidoexpor.setdescuento_valor(0.0);	
				pedidoexpor.settotal_sin_iva(0.0);	
				pedidoexpor.settotal_descuento(0.0);	
				pedidoexpor.setflete(0.0);	
				pedidoexpor.settotal(0.0);	
				pedidoexpor.setsubtotal(0.0);	
				pedidoexpor.setseguros(0.0);	
				pedidoexpor.setiva(0.0);	
				pedidoexpor.setfinanciamiento(0.0);	
				pedidoexpor.setmonto_retencion(0.0);	
				pedidoexpor.setotro(0.0);	
				pedidoexpor.setice(0.0);	
				pedidoexpor.setfecha(new Date());	
				pedidoexpor.setfecha_servidor(new Date());	
				pedidoexpor.setid_tipo_cambio(null);	
				pedidoexpor.setnumero_fue("");	
				pedidoexpor.setid_centro_costo(null);	
				pedidoexpor.setid_responsable(-1L);	
				pedidoexpor.sethora_inicio(new Time((new Date()).getTime()));	
				pedidoexpor.sethora_fin(new Time((new Date()).getTime()));	
				pedidoexpor.setid_transportista(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPedidoExpor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_NUMEROAUTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_COTIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDTIPOPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_LUGARENTREGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_EMBARQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_NEGOCIACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDTRANSPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_FORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDSUBCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDCONSIGNATARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDCONSULTOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_ORDEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDESTADOPEDIDOEXPOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_MONTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_SALDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_DISPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_TOTALCONIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_SUMAN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_DESCUENTOVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_TOTALSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_TOTALDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_SEGUROS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_FINANCIAMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_MONTORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_OTRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_FECHASERVIDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDTIPOCAMBIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_NUMEROFUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDRESPONSABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_HORAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_HORAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoExporConstantesFunciones.LABEL_IDTRANSPORTISTA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPedidoExpor(String sTipo,Row row,Workbook workbook,PedidoExpor pedidoexpor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getnumero_preimpreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getcotizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.gettipoprecio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getlugar_entrega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getembarque());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getnegociacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.gettransporte_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getforma_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getsubcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getconsignatario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getconsultor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getorden());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getestadopedidoexpor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getmonto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getsaldo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getdisponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getdescuento_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.gettotal_con_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getsuman());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getdescuento_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.gettotal_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.gettotal_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getsubtotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getseguros());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getfinanciamiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getmonto_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getotro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getfecha_servidor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.gettipocambio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getnumero_fue());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.getresponsable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.gethora_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.gethora_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoexpor.gettransportista_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPedidoExpor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPedidoExpor() {
		return this.sFinalQueryPedidoExpor;
	}
	
	public void setsFinalQueryPedidoExpor(String sFinalQueryPedidoExpor) {
		this.sFinalQueryPedidoExpor= sFinalQueryPedidoExpor;
	}
	
	public Border resaltarSeleccionarPedidoExpor=null;
	
	public Border setResaltarSeleccionarPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPedidoExpor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPedidoExpor() {
		return this.resaltarSeleccionarPedidoExpor;
	}
	
	public void setResaltarSeleccionarPedidoExpor(Border borderResaltarSeleccionarPedidoExpor) {
		this.resaltarSeleccionarPedidoExpor= borderResaltarSeleccionarPedidoExpor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPedidoExpor=null;
	public Boolean mostraridPedidoExpor=true;
	public Boolean activaridPedidoExpor=true;

	public Border resaltarid_empresaPedidoExpor=null;
	public Boolean mostrarid_empresaPedidoExpor=true;
	public Boolean activarid_empresaPedidoExpor=true;
	public Boolean cargarid_empresaPedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPedidoExpor=false;//ConEventDepend=true

	public Border resaltarid_sucursalPedidoExpor=null;
	public Boolean mostrarid_sucursalPedidoExpor=true;
	public Boolean activarid_sucursalPedidoExpor=true;
	public Boolean cargarid_sucursalPedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPedidoExpor=false;//ConEventDepend=true

	public Border resaltarid_ejercicioPedidoExpor=null;
	public Boolean mostrarid_ejercicioPedidoExpor=true;
	public Boolean activarid_ejercicioPedidoExpor=true;
	public Boolean cargarid_ejercicioPedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioPedidoExpor=false;//ConEventDepend=true

	public Border resaltarid_periodoPedidoExpor=null;
	public Boolean mostrarid_periodoPedidoExpor=true;
	public Boolean activarid_periodoPedidoExpor=true;
	public Boolean cargarid_periodoPedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoPedidoExpor=false;//ConEventDepend=true

	public Border resaltarid_anioPedidoExpor=null;
	public Boolean mostrarid_anioPedidoExpor=true;
	public Boolean activarid_anioPedidoExpor=false;
	public Boolean cargarid_anioPedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioPedidoExpor=false;//ConEventDepend=true

	public Border resaltarid_mesPedidoExpor=null;
	public Boolean mostrarid_mesPedidoExpor=true;
	public Boolean activarid_mesPedidoExpor=false;
	public Boolean cargarid_mesPedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesPedidoExpor=false;//ConEventDepend=true

	public Border resaltarid_usuarioPedidoExpor=null;
	public Boolean mostrarid_usuarioPedidoExpor=true;
	public Boolean activarid_usuarioPedidoExpor=true;
	public Boolean cargarid_usuarioPedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioPedidoExpor=false;//ConEventDepend=true

	public Border resaltarnumeroPedidoExpor=null;
	public Boolean mostrarnumeroPedidoExpor=true;
	public Boolean activarnumeroPedidoExpor=true;

	public Border resaltarnumero_preimpresoPedidoExpor=null;
	public Boolean mostrarnumero_preimpresoPedidoExpor=true;
	public Boolean activarnumero_preimpresoPedidoExpor=true;

	public Border resaltarfecha_emisionPedidoExpor=null;
	public Boolean mostrarfecha_emisionPedidoExpor=true;
	public Boolean activarfecha_emisionPedidoExpor=true;

	public Border resaltarfecha_vencimientoPedidoExpor=null;
	public Boolean mostrarfecha_vencimientoPedidoExpor=true;
	public Boolean activarfecha_vencimientoPedidoExpor=true;

	public Border resaltarid_monedaPedidoExpor=null;
	public Boolean mostrarid_monedaPedidoExpor=true;
	public Boolean activarid_monedaPedidoExpor=true;
	public Boolean cargarid_monedaPedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaPedidoExpor=false;//ConEventDepend=true

	public Border resaltarcotizacionPedidoExpor=null;
	public Boolean mostrarcotizacionPedidoExpor=true;
	public Boolean activarcotizacionPedidoExpor=true;

	public Border resaltarid_empleadoPedidoExpor=null;
	public Boolean mostrarid_empleadoPedidoExpor=true;
	public Boolean activarid_empleadoPedidoExpor=true;
	public Boolean cargarid_empleadoPedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoPedidoExpor=false;//ConEventDepend=true

	public Border resaltarid_tipo_precioPedidoExpor=null;
	public Boolean mostrarid_tipo_precioPedidoExpor=true;
	public Boolean activarid_tipo_precioPedidoExpor=true;
	public Boolean cargarid_tipo_precioPedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_precioPedidoExpor=false;//ConEventDepend=true

	public Border resaltarid_formatoPedidoExpor=null;
	public Boolean mostrarid_formatoPedidoExpor=true;
	public Boolean activarid_formatoPedidoExpor=true;
	public Boolean cargarid_formatoPedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoPedidoExpor=false;//ConEventDepend=true

	public Border resaltardireccionPedidoExpor=null;
	public Boolean mostrardireccionPedidoExpor=true;
	public Boolean activardireccionPedidoExpor=true;

	public Border resaltarid_clientePedidoExpor=null;
	public Boolean mostrarid_clientePedidoExpor=true;
	public Boolean activarid_clientePedidoExpor=true;
	public Boolean cargarid_clientePedidoExpor=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clientePedidoExpor=false;//ConEventDepend=true

	public Border resaltartelefonoPedidoExpor=null;
	public Boolean mostrartelefonoPedidoExpor=true;
	public Boolean activartelefonoPedidoExpor=true;

	public Border resaltarrucPedidoExpor=null;
	public Boolean mostrarrucPedidoExpor=true;
	public Boolean activarrucPedidoExpor=true;

	public Border resaltarid_paisPedidoExpor=null;
	public Boolean mostrarid_paisPedidoExpor=true;
	public Boolean activarid_paisPedidoExpor=true;
	public Boolean cargarid_paisPedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisPedidoExpor=false;//ConEventDepend=true

	public Border resaltarlugar_entregaPedidoExpor=null;
	public Boolean mostrarlugar_entregaPedidoExpor=true;
	public Boolean activarlugar_entregaPedidoExpor=true;

	public Border resaltarembarquePedidoExpor=null;
	public Boolean mostrarembarquePedidoExpor=true;
	public Boolean activarembarquePedidoExpor=true;

	public Border resaltarnegociacionPedidoExpor=null;
	public Boolean mostrarnegociacionPedidoExpor=true;
	public Boolean activarnegociacionPedidoExpor=true;

	public Border resaltarid_transportePedidoExpor=null;
	public Boolean mostrarid_transportePedidoExpor=true;
	public Boolean activarid_transportePedidoExpor=true;
	public Boolean cargarid_transportePedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transportePedidoExpor=false;//ConEventDepend=true

	public Border resaltarid_vendedorPedidoExpor=null;
	public Boolean mostrarid_vendedorPedidoExpor=true;
	public Boolean activarid_vendedorPedidoExpor=true;
	public Boolean cargarid_vendedorPedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorPedidoExpor=false;//ConEventDepend=true

	public Border resaltarforma_pagoPedidoExpor=null;
	public Boolean mostrarforma_pagoPedidoExpor=true;
	public Boolean activarforma_pagoPedidoExpor=true;

	public Border resaltarid_sub_clientePedidoExpor=null;
	public Boolean mostrarid_sub_clientePedidoExpor=true;
	public Boolean activarid_sub_clientePedidoExpor=true;
	public Boolean cargarid_sub_clientePedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sub_clientePedidoExpor=false;//ConEventDepend=true

	public Border resaltarid_consignatarioPedidoExpor=null;
	public Boolean mostrarid_consignatarioPedidoExpor=true;
	public Boolean activarid_consignatarioPedidoExpor=true;
	public Boolean cargarid_consignatarioPedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_consignatarioPedidoExpor=false;//ConEventDepend=true

	public Border resaltarid_consultorPedidoExpor=null;
	public Boolean mostrarid_consultorPedidoExpor=true;
	public Boolean activarid_consultorPedidoExpor=true;
	public Boolean cargarid_consultorPedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_consultorPedidoExpor=false;//ConEventDepend=true

	public Border resaltarordenPedidoExpor=null;
	public Boolean mostrarordenPedidoExpor=true;
	public Boolean activarordenPedidoExpor=true;

	public Border resaltarid_estado_pedidoPedidoExpor=null;
	public Boolean mostrarid_estado_pedidoPedidoExpor=true;
	public Boolean activarid_estado_pedidoPedidoExpor=true;
	public Boolean cargarid_estado_pedidoPedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_pedidoPedidoExpor=false;//ConEventDepend=true

	public Border resaltardescripcionPedidoExpor=null;
	public Boolean mostrardescripcionPedidoExpor=true;
	public Boolean activardescripcionPedidoExpor=true;

	public Border resaltarmontoPedidoExpor=null;
	public Boolean mostrarmontoPedidoExpor=true;
	public Boolean activarmontoPedidoExpor=true;

	public Border resaltarsaldoPedidoExpor=null;
	public Boolean mostrarsaldoPedidoExpor=true;
	public Boolean activarsaldoPedidoExpor=true;

	public Border resaltardisponiblePedidoExpor=null;
	public Boolean mostrardisponiblePedidoExpor=true;
	public Boolean activardisponiblePedidoExpor=true;

	public Border resaltardescuento_porcentajePedidoExpor=null;
	public Boolean mostrardescuento_porcentajePedidoExpor=true;
	public Boolean activardescuento_porcentajePedidoExpor=true;

	public Border resaltartotal_con_ivaPedidoExpor=null;
	public Boolean mostrartotal_con_ivaPedidoExpor=true;
	public Boolean activartotal_con_ivaPedidoExpor=true;

	public Border resaltarsumanPedidoExpor=null;
	public Boolean mostrarsumanPedidoExpor=true;
	public Boolean activarsumanPedidoExpor=true;

	public Border resaltardescuento_valorPedidoExpor=null;
	public Boolean mostrardescuento_valorPedidoExpor=true;
	public Boolean activardescuento_valorPedidoExpor=true;

	public Border resaltartotal_sin_ivaPedidoExpor=null;
	public Boolean mostrartotal_sin_ivaPedidoExpor=true;
	public Boolean activartotal_sin_ivaPedidoExpor=true;

	public Border resaltartotal_descuentoPedidoExpor=null;
	public Boolean mostrartotal_descuentoPedidoExpor=true;
	public Boolean activartotal_descuentoPedidoExpor=true;

	public Border resaltarfletePedidoExpor=null;
	public Boolean mostrarfletePedidoExpor=true;
	public Boolean activarfletePedidoExpor=true;

	public Border resaltartotalPedidoExpor=null;
	public Boolean mostrartotalPedidoExpor=true;
	public Boolean activartotalPedidoExpor=true;

	public Border resaltarsubtotalPedidoExpor=null;
	public Boolean mostrarsubtotalPedidoExpor=true;
	public Boolean activarsubtotalPedidoExpor=true;

	public Border resaltarsegurosPedidoExpor=null;
	public Boolean mostrarsegurosPedidoExpor=true;
	public Boolean activarsegurosPedidoExpor=true;

	public Border resaltarivaPedidoExpor=null;
	public Boolean mostrarivaPedidoExpor=true;
	public Boolean activarivaPedidoExpor=true;

	public Border resaltarfinanciamientoPedidoExpor=null;
	public Boolean mostrarfinanciamientoPedidoExpor=true;
	public Boolean activarfinanciamientoPedidoExpor=true;

	public Border resaltarmonto_retencionPedidoExpor=null;
	public Boolean mostrarmonto_retencionPedidoExpor=true;
	public Boolean activarmonto_retencionPedidoExpor=false;

	public Border resaltarotroPedidoExpor=null;
	public Boolean mostrarotroPedidoExpor=true;
	public Boolean activarotroPedidoExpor=false;

	public Border resaltaricePedidoExpor=null;
	public Boolean mostraricePedidoExpor=true;
	public Boolean activaricePedidoExpor=false;

	public Border resaltarfechaPedidoExpor=null;
	public Boolean mostrarfechaPedidoExpor=true;
	public Boolean activarfechaPedidoExpor=false;

	public Border resaltarfecha_servidorPedidoExpor=null;
	public Boolean mostrarfecha_servidorPedidoExpor=true;
	public Boolean activarfecha_servidorPedidoExpor=false;

	public Border resaltarid_tipo_cambioPedidoExpor=null;
	public Boolean mostrarid_tipo_cambioPedidoExpor=true;
	public Boolean activarid_tipo_cambioPedidoExpor=false;
	public Boolean cargarid_tipo_cambioPedidoExpor=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cambioPedidoExpor=false;//ConEventDepend=true

	public Border resaltarnumero_fuePedidoExpor=null;
	public Boolean mostrarnumero_fuePedidoExpor=true;
	public Boolean activarnumero_fuePedidoExpor=false;

	public Border resaltarid_centro_costoPedidoExpor=null;
	public Boolean mostrarid_centro_costoPedidoExpor=true;
	public Boolean activarid_centro_costoPedidoExpor=false;
	public Boolean cargarid_centro_costoPedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoPedidoExpor=false;//ConEventDepend=true

	public Border resaltarid_responsablePedidoExpor=null;
	public Boolean mostrarid_responsablePedidoExpor=true;
	public Boolean activarid_responsablePedidoExpor=false;
	public Boolean cargarid_responsablePedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_responsablePedidoExpor=false;//ConEventDepend=true

	public Border resaltarhora_inicioPedidoExpor=null;
	public Boolean mostrarhora_inicioPedidoExpor=true;
	public Boolean activarhora_inicioPedidoExpor=false;

	public Border resaltarhora_finPedidoExpor=null;
	public Boolean mostrarhora_finPedidoExpor=true;
	public Boolean activarhora_finPedidoExpor=false;

	public Border resaltarid_transportistaPedidoExpor=null;
	public Boolean mostrarid_transportistaPedidoExpor=true;
	public Boolean activarid_transportistaPedidoExpor=false;
	public Boolean cargarid_transportistaPedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transportistaPedidoExpor=false;//ConEventDepend=true

	
	

	public Border setResaltaridPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltaridPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPedidoExpor() {
		return this.resaltaridPedidoExpor;
	}

	public void setResaltaridPedidoExpor(Border borderResaltar) {
		this.resaltaridPedidoExpor= borderResaltar;
	}

	public Boolean getMostraridPedidoExpor() {
		return this.mostraridPedidoExpor;
	}

	public void setMostraridPedidoExpor(Boolean mostraridPedidoExpor) {
		this.mostraridPedidoExpor= mostraridPedidoExpor;
	}

	public Boolean getActivaridPedidoExpor() {
		return this.activaridPedidoExpor;
	}

	public void setActivaridPedidoExpor(Boolean activaridPedidoExpor) {
		this.activaridPedidoExpor= activaridPedidoExpor;
	}

	public Border setResaltarid_empresaPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_empresaPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPedidoExpor() {
		return this.resaltarid_empresaPedidoExpor;
	}

	public void setResaltarid_empresaPedidoExpor(Border borderResaltar) {
		this.resaltarid_empresaPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_empresaPedidoExpor() {
		return this.mostrarid_empresaPedidoExpor;
	}

	public void setMostrarid_empresaPedidoExpor(Boolean mostrarid_empresaPedidoExpor) {
		this.mostrarid_empresaPedidoExpor= mostrarid_empresaPedidoExpor;
	}

	public Boolean getActivarid_empresaPedidoExpor() {
		return this.activarid_empresaPedidoExpor;
	}

	public void setActivarid_empresaPedidoExpor(Boolean activarid_empresaPedidoExpor) {
		this.activarid_empresaPedidoExpor= activarid_empresaPedidoExpor;
	}

	public Boolean getCargarid_empresaPedidoExpor() {
		return this.cargarid_empresaPedidoExpor;
	}

	public void setCargarid_empresaPedidoExpor(Boolean cargarid_empresaPedidoExpor) {
		this.cargarid_empresaPedidoExpor= cargarid_empresaPedidoExpor;
	}

	public Border setResaltarid_sucursalPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPedidoExpor() {
		return this.resaltarid_sucursalPedidoExpor;
	}

	public void setResaltarid_sucursalPedidoExpor(Border borderResaltar) {
		this.resaltarid_sucursalPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPedidoExpor() {
		return this.mostrarid_sucursalPedidoExpor;
	}

	public void setMostrarid_sucursalPedidoExpor(Boolean mostrarid_sucursalPedidoExpor) {
		this.mostrarid_sucursalPedidoExpor= mostrarid_sucursalPedidoExpor;
	}

	public Boolean getActivarid_sucursalPedidoExpor() {
		return this.activarid_sucursalPedidoExpor;
	}

	public void setActivarid_sucursalPedidoExpor(Boolean activarid_sucursalPedidoExpor) {
		this.activarid_sucursalPedidoExpor= activarid_sucursalPedidoExpor;
	}

	public Boolean getCargarid_sucursalPedidoExpor() {
		return this.cargarid_sucursalPedidoExpor;
	}

	public void setCargarid_sucursalPedidoExpor(Boolean cargarid_sucursalPedidoExpor) {
		this.cargarid_sucursalPedidoExpor= cargarid_sucursalPedidoExpor;
	}

	public Border setResaltarid_ejercicioPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioPedidoExpor() {
		return this.resaltarid_ejercicioPedidoExpor;
	}

	public void setResaltarid_ejercicioPedidoExpor(Border borderResaltar) {
		this.resaltarid_ejercicioPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioPedidoExpor() {
		return this.mostrarid_ejercicioPedidoExpor;
	}

	public void setMostrarid_ejercicioPedidoExpor(Boolean mostrarid_ejercicioPedidoExpor) {
		this.mostrarid_ejercicioPedidoExpor= mostrarid_ejercicioPedidoExpor;
	}

	public Boolean getActivarid_ejercicioPedidoExpor() {
		return this.activarid_ejercicioPedidoExpor;
	}

	public void setActivarid_ejercicioPedidoExpor(Boolean activarid_ejercicioPedidoExpor) {
		this.activarid_ejercicioPedidoExpor= activarid_ejercicioPedidoExpor;
	}

	public Boolean getCargarid_ejercicioPedidoExpor() {
		return this.cargarid_ejercicioPedidoExpor;
	}

	public void setCargarid_ejercicioPedidoExpor(Boolean cargarid_ejercicioPedidoExpor) {
		this.cargarid_ejercicioPedidoExpor= cargarid_ejercicioPedidoExpor;
	}

	public Border setResaltarid_periodoPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_periodoPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoPedidoExpor() {
		return this.resaltarid_periodoPedidoExpor;
	}

	public void setResaltarid_periodoPedidoExpor(Border borderResaltar) {
		this.resaltarid_periodoPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_periodoPedidoExpor() {
		return this.mostrarid_periodoPedidoExpor;
	}

	public void setMostrarid_periodoPedidoExpor(Boolean mostrarid_periodoPedidoExpor) {
		this.mostrarid_periodoPedidoExpor= mostrarid_periodoPedidoExpor;
	}

	public Boolean getActivarid_periodoPedidoExpor() {
		return this.activarid_periodoPedidoExpor;
	}

	public void setActivarid_periodoPedidoExpor(Boolean activarid_periodoPedidoExpor) {
		this.activarid_periodoPedidoExpor= activarid_periodoPedidoExpor;
	}

	public Boolean getCargarid_periodoPedidoExpor() {
		return this.cargarid_periodoPedidoExpor;
	}

	public void setCargarid_periodoPedidoExpor(Boolean cargarid_periodoPedidoExpor) {
		this.cargarid_periodoPedidoExpor= cargarid_periodoPedidoExpor;
	}

	public Border setResaltarid_anioPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_anioPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioPedidoExpor() {
		return this.resaltarid_anioPedidoExpor;
	}

	public void setResaltarid_anioPedidoExpor(Border borderResaltar) {
		this.resaltarid_anioPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_anioPedidoExpor() {
		return this.mostrarid_anioPedidoExpor;
	}

	public void setMostrarid_anioPedidoExpor(Boolean mostrarid_anioPedidoExpor) {
		this.mostrarid_anioPedidoExpor= mostrarid_anioPedidoExpor;
	}

	public Boolean getActivarid_anioPedidoExpor() {
		return this.activarid_anioPedidoExpor;
	}

	public void setActivarid_anioPedidoExpor(Boolean activarid_anioPedidoExpor) {
		this.activarid_anioPedidoExpor= activarid_anioPedidoExpor;
	}

	public Boolean getCargarid_anioPedidoExpor() {
		return this.cargarid_anioPedidoExpor;
	}

	public void setCargarid_anioPedidoExpor(Boolean cargarid_anioPedidoExpor) {
		this.cargarid_anioPedidoExpor= cargarid_anioPedidoExpor;
	}

	public Border setResaltarid_mesPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_mesPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesPedidoExpor() {
		return this.resaltarid_mesPedidoExpor;
	}

	public void setResaltarid_mesPedidoExpor(Border borderResaltar) {
		this.resaltarid_mesPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_mesPedidoExpor() {
		return this.mostrarid_mesPedidoExpor;
	}

	public void setMostrarid_mesPedidoExpor(Boolean mostrarid_mesPedidoExpor) {
		this.mostrarid_mesPedidoExpor= mostrarid_mesPedidoExpor;
	}

	public Boolean getActivarid_mesPedidoExpor() {
		return this.activarid_mesPedidoExpor;
	}

	public void setActivarid_mesPedidoExpor(Boolean activarid_mesPedidoExpor) {
		this.activarid_mesPedidoExpor= activarid_mesPedidoExpor;
	}

	public Boolean getCargarid_mesPedidoExpor() {
		return this.cargarid_mesPedidoExpor;
	}

	public void setCargarid_mesPedidoExpor(Boolean cargarid_mesPedidoExpor) {
		this.cargarid_mesPedidoExpor= cargarid_mesPedidoExpor;
	}

	public Border setResaltarid_usuarioPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_usuarioPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioPedidoExpor() {
		return this.resaltarid_usuarioPedidoExpor;
	}

	public void setResaltarid_usuarioPedidoExpor(Border borderResaltar) {
		this.resaltarid_usuarioPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_usuarioPedidoExpor() {
		return this.mostrarid_usuarioPedidoExpor;
	}

	public void setMostrarid_usuarioPedidoExpor(Boolean mostrarid_usuarioPedidoExpor) {
		this.mostrarid_usuarioPedidoExpor= mostrarid_usuarioPedidoExpor;
	}

	public Boolean getActivarid_usuarioPedidoExpor() {
		return this.activarid_usuarioPedidoExpor;
	}

	public void setActivarid_usuarioPedidoExpor(Boolean activarid_usuarioPedidoExpor) {
		this.activarid_usuarioPedidoExpor= activarid_usuarioPedidoExpor;
	}

	public Boolean getCargarid_usuarioPedidoExpor() {
		return this.cargarid_usuarioPedidoExpor;
	}

	public void setCargarid_usuarioPedidoExpor(Boolean cargarid_usuarioPedidoExpor) {
		this.cargarid_usuarioPedidoExpor= cargarid_usuarioPedidoExpor;
	}

	public Border setResaltarnumeroPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarnumeroPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroPedidoExpor() {
		return this.resaltarnumeroPedidoExpor;
	}

	public void setResaltarnumeroPedidoExpor(Border borderResaltar) {
		this.resaltarnumeroPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarnumeroPedidoExpor() {
		return this.mostrarnumeroPedidoExpor;
	}

	public void setMostrarnumeroPedidoExpor(Boolean mostrarnumeroPedidoExpor) {
		this.mostrarnumeroPedidoExpor= mostrarnumeroPedidoExpor;
	}

	public Boolean getActivarnumeroPedidoExpor() {
		return this.activarnumeroPedidoExpor;
	}

	public void setActivarnumeroPedidoExpor(Boolean activarnumeroPedidoExpor) {
		this.activarnumeroPedidoExpor= activarnumeroPedidoExpor;
	}

	public Border setResaltarnumero_preimpresoPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarnumero_preimpresoPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_preimpresoPedidoExpor() {
		return this.resaltarnumero_preimpresoPedidoExpor;
	}

	public void setResaltarnumero_preimpresoPedidoExpor(Border borderResaltar) {
		this.resaltarnumero_preimpresoPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarnumero_preimpresoPedidoExpor() {
		return this.mostrarnumero_preimpresoPedidoExpor;
	}

	public void setMostrarnumero_preimpresoPedidoExpor(Boolean mostrarnumero_preimpresoPedidoExpor) {
		this.mostrarnumero_preimpresoPedidoExpor= mostrarnumero_preimpresoPedidoExpor;
	}

	public Boolean getActivarnumero_preimpresoPedidoExpor() {
		return this.activarnumero_preimpresoPedidoExpor;
	}

	public void setActivarnumero_preimpresoPedidoExpor(Boolean activarnumero_preimpresoPedidoExpor) {
		this.activarnumero_preimpresoPedidoExpor= activarnumero_preimpresoPedidoExpor;
	}

	public Border setResaltarfecha_emisionPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionPedidoExpor() {
		return this.resaltarfecha_emisionPedidoExpor;
	}

	public void setResaltarfecha_emisionPedidoExpor(Border borderResaltar) {
		this.resaltarfecha_emisionPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionPedidoExpor() {
		return this.mostrarfecha_emisionPedidoExpor;
	}

	public void setMostrarfecha_emisionPedidoExpor(Boolean mostrarfecha_emisionPedidoExpor) {
		this.mostrarfecha_emisionPedidoExpor= mostrarfecha_emisionPedidoExpor;
	}

	public Boolean getActivarfecha_emisionPedidoExpor() {
		return this.activarfecha_emisionPedidoExpor;
	}

	public void setActivarfecha_emisionPedidoExpor(Boolean activarfecha_emisionPedidoExpor) {
		this.activarfecha_emisionPedidoExpor= activarfecha_emisionPedidoExpor;
	}

	public Border setResaltarfecha_vencimientoPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoPedidoExpor() {
		return this.resaltarfecha_vencimientoPedidoExpor;
	}

	public void setResaltarfecha_vencimientoPedidoExpor(Border borderResaltar) {
		this.resaltarfecha_vencimientoPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoPedidoExpor() {
		return this.mostrarfecha_vencimientoPedidoExpor;
	}

	public void setMostrarfecha_vencimientoPedidoExpor(Boolean mostrarfecha_vencimientoPedidoExpor) {
		this.mostrarfecha_vencimientoPedidoExpor= mostrarfecha_vencimientoPedidoExpor;
	}

	public Boolean getActivarfecha_vencimientoPedidoExpor() {
		return this.activarfecha_vencimientoPedidoExpor;
	}

	public void setActivarfecha_vencimientoPedidoExpor(Boolean activarfecha_vencimientoPedidoExpor) {
		this.activarfecha_vencimientoPedidoExpor= activarfecha_vencimientoPedidoExpor;
	}

	public Border setResaltarid_monedaPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_monedaPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaPedidoExpor() {
		return this.resaltarid_monedaPedidoExpor;
	}

	public void setResaltarid_monedaPedidoExpor(Border borderResaltar) {
		this.resaltarid_monedaPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_monedaPedidoExpor() {
		return this.mostrarid_monedaPedidoExpor;
	}

	public void setMostrarid_monedaPedidoExpor(Boolean mostrarid_monedaPedidoExpor) {
		this.mostrarid_monedaPedidoExpor= mostrarid_monedaPedidoExpor;
	}

	public Boolean getActivarid_monedaPedidoExpor() {
		return this.activarid_monedaPedidoExpor;
	}

	public void setActivarid_monedaPedidoExpor(Boolean activarid_monedaPedidoExpor) {
		this.activarid_monedaPedidoExpor= activarid_monedaPedidoExpor;
	}

	public Boolean getCargarid_monedaPedidoExpor() {
		return this.cargarid_monedaPedidoExpor;
	}

	public void setCargarid_monedaPedidoExpor(Boolean cargarid_monedaPedidoExpor) {
		this.cargarid_monedaPedidoExpor= cargarid_monedaPedidoExpor;
	}

	public Border setResaltarcotizacionPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarcotizacionPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcotizacionPedidoExpor() {
		return this.resaltarcotizacionPedidoExpor;
	}

	public void setResaltarcotizacionPedidoExpor(Border borderResaltar) {
		this.resaltarcotizacionPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarcotizacionPedidoExpor() {
		return this.mostrarcotizacionPedidoExpor;
	}

	public void setMostrarcotizacionPedidoExpor(Boolean mostrarcotizacionPedidoExpor) {
		this.mostrarcotizacionPedidoExpor= mostrarcotizacionPedidoExpor;
	}

	public Boolean getActivarcotizacionPedidoExpor() {
		return this.activarcotizacionPedidoExpor;
	}

	public void setActivarcotizacionPedidoExpor(Boolean activarcotizacionPedidoExpor) {
		this.activarcotizacionPedidoExpor= activarcotizacionPedidoExpor;
	}

	public Border setResaltarid_empleadoPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_empleadoPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoPedidoExpor() {
		return this.resaltarid_empleadoPedidoExpor;
	}

	public void setResaltarid_empleadoPedidoExpor(Border borderResaltar) {
		this.resaltarid_empleadoPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_empleadoPedidoExpor() {
		return this.mostrarid_empleadoPedidoExpor;
	}

	public void setMostrarid_empleadoPedidoExpor(Boolean mostrarid_empleadoPedidoExpor) {
		this.mostrarid_empleadoPedidoExpor= mostrarid_empleadoPedidoExpor;
	}

	public Boolean getActivarid_empleadoPedidoExpor() {
		return this.activarid_empleadoPedidoExpor;
	}

	public void setActivarid_empleadoPedidoExpor(Boolean activarid_empleadoPedidoExpor) {
		this.activarid_empleadoPedidoExpor= activarid_empleadoPedidoExpor;
	}

	public Boolean getCargarid_empleadoPedidoExpor() {
		return this.cargarid_empleadoPedidoExpor;
	}

	public void setCargarid_empleadoPedidoExpor(Boolean cargarid_empleadoPedidoExpor) {
		this.cargarid_empleadoPedidoExpor= cargarid_empleadoPedidoExpor;
	}

	public Border setResaltarid_tipo_precioPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_tipo_precioPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_precioPedidoExpor() {
		return this.resaltarid_tipo_precioPedidoExpor;
	}

	public void setResaltarid_tipo_precioPedidoExpor(Border borderResaltar) {
		this.resaltarid_tipo_precioPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_tipo_precioPedidoExpor() {
		return this.mostrarid_tipo_precioPedidoExpor;
	}

	public void setMostrarid_tipo_precioPedidoExpor(Boolean mostrarid_tipo_precioPedidoExpor) {
		this.mostrarid_tipo_precioPedidoExpor= mostrarid_tipo_precioPedidoExpor;
	}

	public Boolean getActivarid_tipo_precioPedidoExpor() {
		return this.activarid_tipo_precioPedidoExpor;
	}

	public void setActivarid_tipo_precioPedidoExpor(Boolean activarid_tipo_precioPedidoExpor) {
		this.activarid_tipo_precioPedidoExpor= activarid_tipo_precioPedidoExpor;
	}

	public Boolean getCargarid_tipo_precioPedidoExpor() {
		return this.cargarid_tipo_precioPedidoExpor;
	}

	public void setCargarid_tipo_precioPedidoExpor(Boolean cargarid_tipo_precioPedidoExpor) {
		this.cargarid_tipo_precioPedidoExpor= cargarid_tipo_precioPedidoExpor;
	}

	public Border setResaltarid_formatoPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_formatoPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoPedidoExpor() {
		return this.resaltarid_formatoPedidoExpor;
	}

	public void setResaltarid_formatoPedidoExpor(Border borderResaltar) {
		this.resaltarid_formatoPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_formatoPedidoExpor() {
		return this.mostrarid_formatoPedidoExpor;
	}

	public void setMostrarid_formatoPedidoExpor(Boolean mostrarid_formatoPedidoExpor) {
		this.mostrarid_formatoPedidoExpor= mostrarid_formatoPedidoExpor;
	}

	public Boolean getActivarid_formatoPedidoExpor() {
		return this.activarid_formatoPedidoExpor;
	}

	public void setActivarid_formatoPedidoExpor(Boolean activarid_formatoPedidoExpor) {
		this.activarid_formatoPedidoExpor= activarid_formatoPedidoExpor;
	}

	public Boolean getCargarid_formatoPedidoExpor() {
		return this.cargarid_formatoPedidoExpor;
	}

	public void setCargarid_formatoPedidoExpor(Boolean cargarid_formatoPedidoExpor) {
		this.cargarid_formatoPedidoExpor= cargarid_formatoPedidoExpor;
	}

	public Border setResaltardireccionPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltardireccionPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionPedidoExpor() {
		return this.resaltardireccionPedidoExpor;
	}

	public void setResaltardireccionPedidoExpor(Border borderResaltar) {
		this.resaltardireccionPedidoExpor= borderResaltar;
	}

	public Boolean getMostrardireccionPedidoExpor() {
		return this.mostrardireccionPedidoExpor;
	}

	public void setMostrardireccionPedidoExpor(Boolean mostrardireccionPedidoExpor) {
		this.mostrardireccionPedidoExpor= mostrardireccionPedidoExpor;
	}

	public Boolean getActivardireccionPedidoExpor() {
		return this.activardireccionPedidoExpor;
	}

	public void setActivardireccionPedidoExpor(Boolean activardireccionPedidoExpor) {
		this.activardireccionPedidoExpor= activardireccionPedidoExpor;
	}

	public Border setResaltarid_clientePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_clientePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clientePedidoExpor() {
		return this.resaltarid_clientePedidoExpor;
	}

	public void setResaltarid_clientePedidoExpor(Border borderResaltar) {
		this.resaltarid_clientePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_clientePedidoExpor() {
		return this.mostrarid_clientePedidoExpor;
	}

	public void setMostrarid_clientePedidoExpor(Boolean mostrarid_clientePedidoExpor) {
		this.mostrarid_clientePedidoExpor= mostrarid_clientePedidoExpor;
	}

	public Boolean getActivarid_clientePedidoExpor() {
		return this.activarid_clientePedidoExpor;
	}

	public void setActivarid_clientePedidoExpor(Boolean activarid_clientePedidoExpor) {
		this.activarid_clientePedidoExpor= activarid_clientePedidoExpor;
	}

	public Boolean getCargarid_clientePedidoExpor() {
		return this.cargarid_clientePedidoExpor;
	}

	public void setCargarid_clientePedidoExpor(Boolean cargarid_clientePedidoExpor) {
		this.cargarid_clientePedidoExpor= cargarid_clientePedidoExpor;
	}

	public Border setResaltartelefonoPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltartelefonoPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoPedidoExpor() {
		return this.resaltartelefonoPedidoExpor;
	}

	public void setResaltartelefonoPedidoExpor(Border borderResaltar) {
		this.resaltartelefonoPedidoExpor= borderResaltar;
	}

	public Boolean getMostrartelefonoPedidoExpor() {
		return this.mostrartelefonoPedidoExpor;
	}

	public void setMostrartelefonoPedidoExpor(Boolean mostrartelefonoPedidoExpor) {
		this.mostrartelefonoPedidoExpor= mostrartelefonoPedidoExpor;
	}

	public Boolean getActivartelefonoPedidoExpor() {
		return this.activartelefonoPedidoExpor;
	}

	public void setActivartelefonoPedidoExpor(Boolean activartelefonoPedidoExpor) {
		this.activartelefonoPedidoExpor= activartelefonoPedidoExpor;
	}

	public Border setResaltarrucPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarrucPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucPedidoExpor() {
		return this.resaltarrucPedidoExpor;
	}

	public void setResaltarrucPedidoExpor(Border borderResaltar) {
		this.resaltarrucPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarrucPedidoExpor() {
		return this.mostrarrucPedidoExpor;
	}

	public void setMostrarrucPedidoExpor(Boolean mostrarrucPedidoExpor) {
		this.mostrarrucPedidoExpor= mostrarrucPedidoExpor;
	}

	public Boolean getActivarrucPedidoExpor() {
		return this.activarrucPedidoExpor;
	}

	public void setActivarrucPedidoExpor(Boolean activarrucPedidoExpor) {
		this.activarrucPedidoExpor= activarrucPedidoExpor;
	}

	public Border setResaltarid_paisPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_paisPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisPedidoExpor() {
		return this.resaltarid_paisPedidoExpor;
	}

	public void setResaltarid_paisPedidoExpor(Border borderResaltar) {
		this.resaltarid_paisPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_paisPedidoExpor() {
		return this.mostrarid_paisPedidoExpor;
	}

	public void setMostrarid_paisPedidoExpor(Boolean mostrarid_paisPedidoExpor) {
		this.mostrarid_paisPedidoExpor= mostrarid_paisPedidoExpor;
	}

	public Boolean getActivarid_paisPedidoExpor() {
		return this.activarid_paisPedidoExpor;
	}

	public void setActivarid_paisPedidoExpor(Boolean activarid_paisPedidoExpor) {
		this.activarid_paisPedidoExpor= activarid_paisPedidoExpor;
	}

	public Boolean getCargarid_paisPedidoExpor() {
		return this.cargarid_paisPedidoExpor;
	}

	public void setCargarid_paisPedidoExpor(Boolean cargarid_paisPedidoExpor) {
		this.cargarid_paisPedidoExpor= cargarid_paisPedidoExpor;
	}

	public Border setResaltarlugar_entregaPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarlugar_entregaPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarlugar_entregaPedidoExpor() {
		return this.resaltarlugar_entregaPedidoExpor;
	}

	public void setResaltarlugar_entregaPedidoExpor(Border borderResaltar) {
		this.resaltarlugar_entregaPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarlugar_entregaPedidoExpor() {
		return this.mostrarlugar_entregaPedidoExpor;
	}

	public void setMostrarlugar_entregaPedidoExpor(Boolean mostrarlugar_entregaPedidoExpor) {
		this.mostrarlugar_entregaPedidoExpor= mostrarlugar_entregaPedidoExpor;
	}

	public Boolean getActivarlugar_entregaPedidoExpor() {
		return this.activarlugar_entregaPedidoExpor;
	}

	public void setActivarlugar_entregaPedidoExpor(Boolean activarlugar_entregaPedidoExpor) {
		this.activarlugar_entregaPedidoExpor= activarlugar_entregaPedidoExpor;
	}

	public Border setResaltarembarquePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarembarquePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarembarquePedidoExpor() {
		return this.resaltarembarquePedidoExpor;
	}

	public void setResaltarembarquePedidoExpor(Border borderResaltar) {
		this.resaltarembarquePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarembarquePedidoExpor() {
		return this.mostrarembarquePedidoExpor;
	}

	public void setMostrarembarquePedidoExpor(Boolean mostrarembarquePedidoExpor) {
		this.mostrarembarquePedidoExpor= mostrarembarquePedidoExpor;
	}

	public Boolean getActivarembarquePedidoExpor() {
		return this.activarembarquePedidoExpor;
	}

	public void setActivarembarquePedidoExpor(Boolean activarembarquePedidoExpor) {
		this.activarembarquePedidoExpor= activarembarquePedidoExpor;
	}

	public Border setResaltarnegociacionPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarnegociacionPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnegociacionPedidoExpor() {
		return this.resaltarnegociacionPedidoExpor;
	}

	public void setResaltarnegociacionPedidoExpor(Border borderResaltar) {
		this.resaltarnegociacionPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarnegociacionPedidoExpor() {
		return this.mostrarnegociacionPedidoExpor;
	}

	public void setMostrarnegociacionPedidoExpor(Boolean mostrarnegociacionPedidoExpor) {
		this.mostrarnegociacionPedidoExpor= mostrarnegociacionPedidoExpor;
	}

	public Boolean getActivarnegociacionPedidoExpor() {
		return this.activarnegociacionPedidoExpor;
	}

	public void setActivarnegociacionPedidoExpor(Boolean activarnegociacionPedidoExpor) {
		this.activarnegociacionPedidoExpor= activarnegociacionPedidoExpor;
	}

	public Border setResaltarid_transportePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_transportePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transportePedidoExpor() {
		return this.resaltarid_transportePedidoExpor;
	}

	public void setResaltarid_transportePedidoExpor(Border borderResaltar) {
		this.resaltarid_transportePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_transportePedidoExpor() {
		return this.mostrarid_transportePedidoExpor;
	}

	public void setMostrarid_transportePedidoExpor(Boolean mostrarid_transportePedidoExpor) {
		this.mostrarid_transportePedidoExpor= mostrarid_transportePedidoExpor;
	}

	public Boolean getActivarid_transportePedidoExpor() {
		return this.activarid_transportePedidoExpor;
	}

	public void setActivarid_transportePedidoExpor(Boolean activarid_transportePedidoExpor) {
		this.activarid_transportePedidoExpor= activarid_transportePedidoExpor;
	}

	public Boolean getCargarid_transportePedidoExpor() {
		return this.cargarid_transportePedidoExpor;
	}

	public void setCargarid_transportePedidoExpor(Boolean cargarid_transportePedidoExpor) {
		this.cargarid_transportePedidoExpor= cargarid_transportePedidoExpor;
	}

	public Border setResaltarid_vendedorPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_vendedorPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorPedidoExpor() {
		return this.resaltarid_vendedorPedidoExpor;
	}

	public void setResaltarid_vendedorPedidoExpor(Border borderResaltar) {
		this.resaltarid_vendedorPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_vendedorPedidoExpor() {
		return this.mostrarid_vendedorPedidoExpor;
	}

	public void setMostrarid_vendedorPedidoExpor(Boolean mostrarid_vendedorPedidoExpor) {
		this.mostrarid_vendedorPedidoExpor= mostrarid_vendedorPedidoExpor;
	}

	public Boolean getActivarid_vendedorPedidoExpor() {
		return this.activarid_vendedorPedidoExpor;
	}

	public void setActivarid_vendedorPedidoExpor(Boolean activarid_vendedorPedidoExpor) {
		this.activarid_vendedorPedidoExpor= activarid_vendedorPedidoExpor;
	}

	public Boolean getCargarid_vendedorPedidoExpor() {
		return this.cargarid_vendedorPedidoExpor;
	}

	public void setCargarid_vendedorPedidoExpor(Boolean cargarid_vendedorPedidoExpor) {
		this.cargarid_vendedorPedidoExpor= cargarid_vendedorPedidoExpor;
	}

	public Border setResaltarforma_pagoPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarforma_pagoPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarforma_pagoPedidoExpor() {
		return this.resaltarforma_pagoPedidoExpor;
	}

	public void setResaltarforma_pagoPedidoExpor(Border borderResaltar) {
		this.resaltarforma_pagoPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarforma_pagoPedidoExpor() {
		return this.mostrarforma_pagoPedidoExpor;
	}

	public void setMostrarforma_pagoPedidoExpor(Boolean mostrarforma_pagoPedidoExpor) {
		this.mostrarforma_pagoPedidoExpor= mostrarforma_pagoPedidoExpor;
	}

	public Boolean getActivarforma_pagoPedidoExpor() {
		return this.activarforma_pagoPedidoExpor;
	}

	public void setActivarforma_pagoPedidoExpor(Boolean activarforma_pagoPedidoExpor) {
		this.activarforma_pagoPedidoExpor= activarforma_pagoPedidoExpor;
	}

	public Border setResaltarid_sub_clientePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_sub_clientePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sub_clientePedidoExpor() {
		return this.resaltarid_sub_clientePedidoExpor;
	}

	public void setResaltarid_sub_clientePedidoExpor(Border borderResaltar) {
		this.resaltarid_sub_clientePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_sub_clientePedidoExpor() {
		return this.mostrarid_sub_clientePedidoExpor;
	}

	public void setMostrarid_sub_clientePedidoExpor(Boolean mostrarid_sub_clientePedidoExpor) {
		this.mostrarid_sub_clientePedidoExpor= mostrarid_sub_clientePedidoExpor;
	}

	public Boolean getActivarid_sub_clientePedidoExpor() {
		return this.activarid_sub_clientePedidoExpor;
	}

	public void setActivarid_sub_clientePedidoExpor(Boolean activarid_sub_clientePedidoExpor) {
		this.activarid_sub_clientePedidoExpor= activarid_sub_clientePedidoExpor;
	}

	public Boolean getCargarid_sub_clientePedidoExpor() {
		return this.cargarid_sub_clientePedidoExpor;
	}

	public void setCargarid_sub_clientePedidoExpor(Boolean cargarid_sub_clientePedidoExpor) {
		this.cargarid_sub_clientePedidoExpor= cargarid_sub_clientePedidoExpor;
	}

	public Border setResaltarid_consignatarioPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_consignatarioPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_consignatarioPedidoExpor() {
		return this.resaltarid_consignatarioPedidoExpor;
	}

	public void setResaltarid_consignatarioPedidoExpor(Border borderResaltar) {
		this.resaltarid_consignatarioPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_consignatarioPedidoExpor() {
		return this.mostrarid_consignatarioPedidoExpor;
	}

	public void setMostrarid_consignatarioPedidoExpor(Boolean mostrarid_consignatarioPedidoExpor) {
		this.mostrarid_consignatarioPedidoExpor= mostrarid_consignatarioPedidoExpor;
	}

	public Boolean getActivarid_consignatarioPedidoExpor() {
		return this.activarid_consignatarioPedidoExpor;
	}

	public void setActivarid_consignatarioPedidoExpor(Boolean activarid_consignatarioPedidoExpor) {
		this.activarid_consignatarioPedidoExpor= activarid_consignatarioPedidoExpor;
	}

	public Boolean getCargarid_consignatarioPedidoExpor() {
		return this.cargarid_consignatarioPedidoExpor;
	}

	public void setCargarid_consignatarioPedidoExpor(Boolean cargarid_consignatarioPedidoExpor) {
		this.cargarid_consignatarioPedidoExpor= cargarid_consignatarioPedidoExpor;
	}

	public Border setResaltarid_consultorPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_consultorPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_consultorPedidoExpor() {
		return this.resaltarid_consultorPedidoExpor;
	}

	public void setResaltarid_consultorPedidoExpor(Border borderResaltar) {
		this.resaltarid_consultorPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_consultorPedidoExpor() {
		return this.mostrarid_consultorPedidoExpor;
	}

	public void setMostrarid_consultorPedidoExpor(Boolean mostrarid_consultorPedidoExpor) {
		this.mostrarid_consultorPedidoExpor= mostrarid_consultorPedidoExpor;
	}

	public Boolean getActivarid_consultorPedidoExpor() {
		return this.activarid_consultorPedidoExpor;
	}

	public void setActivarid_consultorPedidoExpor(Boolean activarid_consultorPedidoExpor) {
		this.activarid_consultorPedidoExpor= activarid_consultorPedidoExpor;
	}

	public Boolean getCargarid_consultorPedidoExpor() {
		return this.cargarid_consultorPedidoExpor;
	}

	public void setCargarid_consultorPedidoExpor(Boolean cargarid_consultorPedidoExpor) {
		this.cargarid_consultorPedidoExpor= cargarid_consultorPedidoExpor;
	}

	public Border setResaltarordenPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarordenPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarordenPedidoExpor() {
		return this.resaltarordenPedidoExpor;
	}

	public void setResaltarordenPedidoExpor(Border borderResaltar) {
		this.resaltarordenPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarordenPedidoExpor() {
		return this.mostrarordenPedidoExpor;
	}

	public void setMostrarordenPedidoExpor(Boolean mostrarordenPedidoExpor) {
		this.mostrarordenPedidoExpor= mostrarordenPedidoExpor;
	}

	public Boolean getActivarordenPedidoExpor() {
		return this.activarordenPedidoExpor;
	}

	public void setActivarordenPedidoExpor(Boolean activarordenPedidoExpor) {
		this.activarordenPedidoExpor= activarordenPedidoExpor;
	}

	public Border setResaltarid_estado_pedidoPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_estado_pedidoPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_pedidoPedidoExpor() {
		return this.resaltarid_estado_pedidoPedidoExpor;
	}

	public void setResaltarid_estado_pedidoPedidoExpor(Border borderResaltar) {
		this.resaltarid_estado_pedidoPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_estado_pedidoPedidoExpor() {
		return this.mostrarid_estado_pedidoPedidoExpor;
	}

	public void setMostrarid_estado_pedidoPedidoExpor(Boolean mostrarid_estado_pedidoPedidoExpor) {
		this.mostrarid_estado_pedidoPedidoExpor= mostrarid_estado_pedidoPedidoExpor;
	}

	public Boolean getActivarid_estado_pedidoPedidoExpor() {
		return this.activarid_estado_pedidoPedidoExpor;
	}

	public void setActivarid_estado_pedidoPedidoExpor(Boolean activarid_estado_pedidoPedidoExpor) {
		this.activarid_estado_pedidoPedidoExpor= activarid_estado_pedidoPedidoExpor;
	}

	public Boolean getCargarid_estado_pedidoPedidoExpor() {
		return this.cargarid_estado_pedidoPedidoExpor;
	}

	public void setCargarid_estado_pedidoPedidoExpor(Boolean cargarid_estado_pedidoPedidoExpor) {
		this.cargarid_estado_pedidoPedidoExpor= cargarid_estado_pedidoPedidoExpor;
	}

	public Border setResaltardescripcionPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltardescripcionPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionPedidoExpor() {
		return this.resaltardescripcionPedidoExpor;
	}

	public void setResaltardescripcionPedidoExpor(Border borderResaltar) {
		this.resaltardescripcionPedidoExpor= borderResaltar;
	}

	public Boolean getMostrardescripcionPedidoExpor() {
		return this.mostrardescripcionPedidoExpor;
	}

	public void setMostrardescripcionPedidoExpor(Boolean mostrardescripcionPedidoExpor) {
		this.mostrardescripcionPedidoExpor= mostrardescripcionPedidoExpor;
	}

	public Boolean getActivardescripcionPedidoExpor() {
		return this.activardescripcionPedidoExpor;
	}

	public void setActivardescripcionPedidoExpor(Boolean activardescripcionPedidoExpor) {
		this.activardescripcionPedidoExpor= activardescripcionPedidoExpor;
	}

	public Border setResaltarmontoPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarmontoPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmontoPedidoExpor() {
		return this.resaltarmontoPedidoExpor;
	}

	public void setResaltarmontoPedidoExpor(Border borderResaltar) {
		this.resaltarmontoPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarmontoPedidoExpor() {
		return this.mostrarmontoPedidoExpor;
	}

	public void setMostrarmontoPedidoExpor(Boolean mostrarmontoPedidoExpor) {
		this.mostrarmontoPedidoExpor= mostrarmontoPedidoExpor;
	}

	public Boolean getActivarmontoPedidoExpor() {
		return this.activarmontoPedidoExpor;
	}

	public void setActivarmontoPedidoExpor(Boolean activarmontoPedidoExpor) {
		this.activarmontoPedidoExpor= activarmontoPedidoExpor;
	}

	public Border setResaltarsaldoPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarsaldoPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldoPedidoExpor() {
		return this.resaltarsaldoPedidoExpor;
	}

	public void setResaltarsaldoPedidoExpor(Border borderResaltar) {
		this.resaltarsaldoPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarsaldoPedidoExpor() {
		return this.mostrarsaldoPedidoExpor;
	}

	public void setMostrarsaldoPedidoExpor(Boolean mostrarsaldoPedidoExpor) {
		this.mostrarsaldoPedidoExpor= mostrarsaldoPedidoExpor;
	}

	public Boolean getActivarsaldoPedidoExpor() {
		return this.activarsaldoPedidoExpor;
	}

	public void setActivarsaldoPedidoExpor(Boolean activarsaldoPedidoExpor) {
		this.activarsaldoPedidoExpor= activarsaldoPedidoExpor;
	}

	public Border setResaltardisponiblePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltardisponiblePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardisponiblePedidoExpor() {
		return this.resaltardisponiblePedidoExpor;
	}

	public void setResaltardisponiblePedidoExpor(Border borderResaltar) {
		this.resaltardisponiblePedidoExpor= borderResaltar;
	}

	public Boolean getMostrardisponiblePedidoExpor() {
		return this.mostrardisponiblePedidoExpor;
	}

	public void setMostrardisponiblePedidoExpor(Boolean mostrardisponiblePedidoExpor) {
		this.mostrardisponiblePedidoExpor= mostrardisponiblePedidoExpor;
	}

	public Boolean getActivardisponiblePedidoExpor() {
		return this.activardisponiblePedidoExpor;
	}

	public void setActivardisponiblePedidoExpor(Boolean activardisponiblePedidoExpor) {
		this.activardisponiblePedidoExpor= activardisponiblePedidoExpor;
	}

	public Border setResaltardescuento_porcentajePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltardescuento_porcentajePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_porcentajePedidoExpor() {
		return this.resaltardescuento_porcentajePedidoExpor;
	}

	public void setResaltardescuento_porcentajePedidoExpor(Border borderResaltar) {
		this.resaltardescuento_porcentajePedidoExpor= borderResaltar;
	}

	public Boolean getMostrardescuento_porcentajePedidoExpor() {
		return this.mostrardescuento_porcentajePedidoExpor;
	}

	public void setMostrardescuento_porcentajePedidoExpor(Boolean mostrardescuento_porcentajePedidoExpor) {
		this.mostrardescuento_porcentajePedidoExpor= mostrardescuento_porcentajePedidoExpor;
	}

	public Boolean getActivardescuento_porcentajePedidoExpor() {
		return this.activardescuento_porcentajePedidoExpor;
	}

	public void setActivardescuento_porcentajePedidoExpor(Boolean activardescuento_porcentajePedidoExpor) {
		this.activardescuento_porcentajePedidoExpor= activardescuento_porcentajePedidoExpor;
	}

	public Border setResaltartotal_con_ivaPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltartotal_con_ivaPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_con_ivaPedidoExpor() {
		return this.resaltartotal_con_ivaPedidoExpor;
	}

	public void setResaltartotal_con_ivaPedidoExpor(Border borderResaltar) {
		this.resaltartotal_con_ivaPedidoExpor= borderResaltar;
	}

	public Boolean getMostrartotal_con_ivaPedidoExpor() {
		return this.mostrartotal_con_ivaPedidoExpor;
	}

	public void setMostrartotal_con_ivaPedidoExpor(Boolean mostrartotal_con_ivaPedidoExpor) {
		this.mostrartotal_con_ivaPedidoExpor= mostrartotal_con_ivaPedidoExpor;
	}

	public Boolean getActivartotal_con_ivaPedidoExpor() {
		return this.activartotal_con_ivaPedidoExpor;
	}

	public void setActivartotal_con_ivaPedidoExpor(Boolean activartotal_con_ivaPedidoExpor) {
		this.activartotal_con_ivaPedidoExpor= activartotal_con_ivaPedidoExpor;
	}

	public Border setResaltarsumanPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarsumanPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsumanPedidoExpor() {
		return this.resaltarsumanPedidoExpor;
	}

	public void setResaltarsumanPedidoExpor(Border borderResaltar) {
		this.resaltarsumanPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarsumanPedidoExpor() {
		return this.mostrarsumanPedidoExpor;
	}

	public void setMostrarsumanPedidoExpor(Boolean mostrarsumanPedidoExpor) {
		this.mostrarsumanPedidoExpor= mostrarsumanPedidoExpor;
	}

	public Boolean getActivarsumanPedidoExpor() {
		return this.activarsumanPedidoExpor;
	}

	public void setActivarsumanPedidoExpor(Boolean activarsumanPedidoExpor) {
		this.activarsumanPedidoExpor= activarsumanPedidoExpor;
	}

	public Border setResaltardescuento_valorPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltardescuento_valorPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_valorPedidoExpor() {
		return this.resaltardescuento_valorPedidoExpor;
	}

	public void setResaltardescuento_valorPedidoExpor(Border borderResaltar) {
		this.resaltardescuento_valorPedidoExpor= borderResaltar;
	}

	public Boolean getMostrardescuento_valorPedidoExpor() {
		return this.mostrardescuento_valorPedidoExpor;
	}

	public void setMostrardescuento_valorPedidoExpor(Boolean mostrardescuento_valorPedidoExpor) {
		this.mostrardescuento_valorPedidoExpor= mostrardescuento_valorPedidoExpor;
	}

	public Boolean getActivardescuento_valorPedidoExpor() {
		return this.activardescuento_valorPedidoExpor;
	}

	public void setActivardescuento_valorPedidoExpor(Boolean activardescuento_valorPedidoExpor) {
		this.activardescuento_valorPedidoExpor= activardescuento_valorPedidoExpor;
	}

	public Border setResaltartotal_sin_ivaPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltartotal_sin_ivaPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_sin_ivaPedidoExpor() {
		return this.resaltartotal_sin_ivaPedidoExpor;
	}

	public void setResaltartotal_sin_ivaPedidoExpor(Border borderResaltar) {
		this.resaltartotal_sin_ivaPedidoExpor= borderResaltar;
	}

	public Boolean getMostrartotal_sin_ivaPedidoExpor() {
		return this.mostrartotal_sin_ivaPedidoExpor;
	}

	public void setMostrartotal_sin_ivaPedidoExpor(Boolean mostrartotal_sin_ivaPedidoExpor) {
		this.mostrartotal_sin_ivaPedidoExpor= mostrartotal_sin_ivaPedidoExpor;
	}

	public Boolean getActivartotal_sin_ivaPedidoExpor() {
		return this.activartotal_sin_ivaPedidoExpor;
	}

	public void setActivartotal_sin_ivaPedidoExpor(Boolean activartotal_sin_ivaPedidoExpor) {
		this.activartotal_sin_ivaPedidoExpor= activartotal_sin_ivaPedidoExpor;
	}

	public Border setResaltartotal_descuentoPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltartotal_descuentoPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_descuentoPedidoExpor() {
		return this.resaltartotal_descuentoPedidoExpor;
	}

	public void setResaltartotal_descuentoPedidoExpor(Border borderResaltar) {
		this.resaltartotal_descuentoPedidoExpor= borderResaltar;
	}

	public Boolean getMostrartotal_descuentoPedidoExpor() {
		return this.mostrartotal_descuentoPedidoExpor;
	}

	public void setMostrartotal_descuentoPedidoExpor(Boolean mostrartotal_descuentoPedidoExpor) {
		this.mostrartotal_descuentoPedidoExpor= mostrartotal_descuentoPedidoExpor;
	}

	public Boolean getActivartotal_descuentoPedidoExpor() {
		return this.activartotal_descuentoPedidoExpor;
	}

	public void setActivartotal_descuentoPedidoExpor(Boolean activartotal_descuentoPedidoExpor) {
		this.activartotal_descuentoPedidoExpor= activartotal_descuentoPedidoExpor;
	}

	public Border setResaltarfletePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarfletePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfletePedidoExpor() {
		return this.resaltarfletePedidoExpor;
	}

	public void setResaltarfletePedidoExpor(Border borderResaltar) {
		this.resaltarfletePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarfletePedidoExpor() {
		return this.mostrarfletePedidoExpor;
	}

	public void setMostrarfletePedidoExpor(Boolean mostrarfletePedidoExpor) {
		this.mostrarfletePedidoExpor= mostrarfletePedidoExpor;
	}

	public Boolean getActivarfletePedidoExpor() {
		return this.activarfletePedidoExpor;
	}

	public void setActivarfletePedidoExpor(Boolean activarfletePedidoExpor) {
		this.activarfletePedidoExpor= activarfletePedidoExpor;
	}

	public Border setResaltartotalPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltartotalPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalPedidoExpor() {
		return this.resaltartotalPedidoExpor;
	}

	public void setResaltartotalPedidoExpor(Border borderResaltar) {
		this.resaltartotalPedidoExpor= borderResaltar;
	}

	public Boolean getMostrartotalPedidoExpor() {
		return this.mostrartotalPedidoExpor;
	}

	public void setMostrartotalPedidoExpor(Boolean mostrartotalPedidoExpor) {
		this.mostrartotalPedidoExpor= mostrartotalPedidoExpor;
	}

	public Boolean getActivartotalPedidoExpor() {
		return this.activartotalPedidoExpor;
	}

	public void setActivartotalPedidoExpor(Boolean activartotalPedidoExpor) {
		this.activartotalPedidoExpor= activartotalPedidoExpor;
	}

	public Border setResaltarsubtotalPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarsubtotalPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsubtotalPedidoExpor() {
		return this.resaltarsubtotalPedidoExpor;
	}

	public void setResaltarsubtotalPedidoExpor(Border borderResaltar) {
		this.resaltarsubtotalPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarsubtotalPedidoExpor() {
		return this.mostrarsubtotalPedidoExpor;
	}

	public void setMostrarsubtotalPedidoExpor(Boolean mostrarsubtotalPedidoExpor) {
		this.mostrarsubtotalPedidoExpor= mostrarsubtotalPedidoExpor;
	}

	public Boolean getActivarsubtotalPedidoExpor() {
		return this.activarsubtotalPedidoExpor;
	}

	public void setActivarsubtotalPedidoExpor(Boolean activarsubtotalPedidoExpor) {
		this.activarsubtotalPedidoExpor= activarsubtotalPedidoExpor;
	}

	public Border setResaltarsegurosPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarsegurosPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsegurosPedidoExpor() {
		return this.resaltarsegurosPedidoExpor;
	}

	public void setResaltarsegurosPedidoExpor(Border borderResaltar) {
		this.resaltarsegurosPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarsegurosPedidoExpor() {
		return this.mostrarsegurosPedidoExpor;
	}

	public void setMostrarsegurosPedidoExpor(Boolean mostrarsegurosPedidoExpor) {
		this.mostrarsegurosPedidoExpor= mostrarsegurosPedidoExpor;
	}

	public Boolean getActivarsegurosPedidoExpor() {
		return this.activarsegurosPedidoExpor;
	}

	public void setActivarsegurosPedidoExpor(Boolean activarsegurosPedidoExpor) {
		this.activarsegurosPedidoExpor= activarsegurosPedidoExpor;
	}

	public Border setResaltarivaPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarivaPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaPedidoExpor() {
		return this.resaltarivaPedidoExpor;
	}

	public void setResaltarivaPedidoExpor(Border borderResaltar) {
		this.resaltarivaPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarivaPedidoExpor() {
		return this.mostrarivaPedidoExpor;
	}

	public void setMostrarivaPedidoExpor(Boolean mostrarivaPedidoExpor) {
		this.mostrarivaPedidoExpor= mostrarivaPedidoExpor;
	}

	public Boolean getActivarivaPedidoExpor() {
		return this.activarivaPedidoExpor;
	}

	public void setActivarivaPedidoExpor(Boolean activarivaPedidoExpor) {
		this.activarivaPedidoExpor= activarivaPedidoExpor;
	}

	public Border setResaltarfinanciamientoPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarfinanciamientoPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfinanciamientoPedidoExpor() {
		return this.resaltarfinanciamientoPedidoExpor;
	}

	public void setResaltarfinanciamientoPedidoExpor(Border borderResaltar) {
		this.resaltarfinanciamientoPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarfinanciamientoPedidoExpor() {
		return this.mostrarfinanciamientoPedidoExpor;
	}

	public void setMostrarfinanciamientoPedidoExpor(Boolean mostrarfinanciamientoPedidoExpor) {
		this.mostrarfinanciamientoPedidoExpor= mostrarfinanciamientoPedidoExpor;
	}

	public Boolean getActivarfinanciamientoPedidoExpor() {
		return this.activarfinanciamientoPedidoExpor;
	}

	public void setActivarfinanciamientoPedidoExpor(Boolean activarfinanciamientoPedidoExpor) {
		this.activarfinanciamientoPedidoExpor= activarfinanciamientoPedidoExpor;
	}

	public Border setResaltarmonto_retencionPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarmonto_retencionPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_retencionPedidoExpor() {
		return this.resaltarmonto_retencionPedidoExpor;
	}

	public void setResaltarmonto_retencionPedidoExpor(Border borderResaltar) {
		this.resaltarmonto_retencionPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarmonto_retencionPedidoExpor() {
		return this.mostrarmonto_retencionPedidoExpor;
	}

	public void setMostrarmonto_retencionPedidoExpor(Boolean mostrarmonto_retencionPedidoExpor) {
		this.mostrarmonto_retencionPedidoExpor= mostrarmonto_retencionPedidoExpor;
	}

	public Boolean getActivarmonto_retencionPedidoExpor() {
		return this.activarmonto_retencionPedidoExpor;
	}

	public void setActivarmonto_retencionPedidoExpor(Boolean activarmonto_retencionPedidoExpor) {
		this.activarmonto_retencionPedidoExpor= activarmonto_retencionPedidoExpor;
	}

	public Border setResaltarotroPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarotroPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotroPedidoExpor() {
		return this.resaltarotroPedidoExpor;
	}

	public void setResaltarotroPedidoExpor(Border borderResaltar) {
		this.resaltarotroPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarotroPedidoExpor() {
		return this.mostrarotroPedidoExpor;
	}

	public void setMostrarotroPedidoExpor(Boolean mostrarotroPedidoExpor) {
		this.mostrarotroPedidoExpor= mostrarotroPedidoExpor;
	}

	public Boolean getActivarotroPedidoExpor() {
		return this.activarotroPedidoExpor;
	}

	public void setActivarotroPedidoExpor(Boolean activarotroPedidoExpor) {
		this.activarotroPedidoExpor= activarotroPedidoExpor;
	}

	public Border setResaltaricePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltaricePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaricePedidoExpor() {
		return this.resaltaricePedidoExpor;
	}

	public void setResaltaricePedidoExpor(Border borderResaltar) {
		this.resaltaricePedidoExpor= borderResaltar;
	}

	public Boolean getMostraricePedidoExpor() {
		return this.mostraricePedidoExpor;
	}

	public void setMostraricePedidoExpor(Boolean mostraricePedidoExpor) {
		this.mostraricePedidoExpor= mostraricePedidoExpor;
	}

	public Boolean getActivaricePedidoExpor() {
		return this.activaricePedidoExpor;
	}

	public void setActivaricePedidoExpor(Boolean activaricePedidoExpor) {
		this.activaricePedidoExpor= activaricePedidoExpor;
	}

	public Border setResaltarfechaPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarfechaPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaPedidoExpor() {
		return this.resaltarfechaPedidoExpor;
	}

	public void setResaltarfechaPedidoExpor(Border borderResaltar) {
		this.resaltarfechaPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarfechaPedidoExpor() {
		return this.mostrarfechaPedidoExpor;
	}

	public void setMostrarfechaPedidoExpor(Boolean mostrarfechaPedidoExpor) {
		this.mostrarfechaPedidoExpor= mostrarfechaPedidoExpor;
	}

	public Boolean getActivarfechaPedidoExpor() {
		return this.activarfechaPedidoExpor;
	}

	public void setActivarfechaPedidoExpor(Boolean activarfechaPedidoExpor) {
		this.activarfechaPedidoExpor= activarfechaPedidoExpor;
	}

	public Border setResaltarfecha_servidorPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarfecha_servidorPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_servidorPedidoExpor() {
		return this.resaltarfecha_servidorPedidoExpor;
	}

	public void setResaltarfecha_servidorPedidoExpor(Border borderResaltar) {
		this.resaltarfecha_servidorPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarfecha_servidorPedidoExpor() {
		return this.mostrarfecha_servidorPedidoExpor;
	}

	public void setMostrarfecha_servidorPedidoExpor(Boolean mostrarfecha_servidorPedidoExpor) {
		this.mostrarfecha_servidorPedidoExpor= mostrarfecha_servidorPedidoExpor;
	}

	public Boolean getActivarfecha_servidorPedidoExpor() {
		return this.activarfecha_servidorPedidoExpor;
	}

	public void setActivarfecha_servidorPedidoExpor(Boolean activarfecha_servidorPedidoExpor) {
		this.activarfecha_servidorPedidoExpor= activarfecha_servidorPedidoExpor;
	}

	public Border setResaltarid_tipo_cambioPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cambioPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cambioPedidoExpor() {
		return this.resaltarid_tipo_cambioPedidoExpor;
	}

	public void setResaltarid_tipo_cambioPedidoExpor(Border borderResaltar) {
		this.resaltarid_tipo_cambioPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cambioPedidoExpor() {
		return this.mostrarid_tipo_cambioPedidoExpor;
	}

	public void setMostrarid_tipo_cambioPedidoExpor(Boolean mostrarid_tipo_cambioPedidoExpor) {
		this.mostrarid_tipo_cambioPedidoExpor= mostrarid_tipo_cambioPedidoExpor;
	}

	public Boolean getActivarid_tipo_cambioPedidoExpor() {
		return this.activarid_tipo_cambioPedidoExpor;
	}

	public void setActivarid_tipo_cambioPedidoExpor(Boolean activarid_tipo_cambioPedidoExpor) {
		this.activarid_tipo_cambioPedidoExpor= activarid_tipo_cambioPedidoExpor;
	}

	public Boolean getCargarid_tipo_cambioPedidoExpor() {
		return this.cargarid_tipo_cambioPedidoExpor;
	}

	public void setCargarid_tipo_cambioPedidoExpor(Boolean cargarid_tipo_cambioPedidoExpor) {
		this.cargarid_tipo_cambioPedidoExpor= cargarid_tipo_cambioPedidoExpor;
	}

	public Border setResaltarnumero_fuePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarnumero_fuePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_fuePedidoExpor() {
		return this.resaltarnumero_fuePedidoExpor;
	}

	public void setResaltarnumero_fuePedidoExpor(Border borderResaltar) {
		this.resaltarnumero_fuePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarnumero_fuePedidoExpor() {
		return this.mostrarnumero_fuePedidoExpor;
	}

	public void setMostrarnumero_fuePedidoExpor(Boolean mostrarnumero_fuePedidoExpor) {
		this.mostrarnumero_fuePedidoExpor= mostrarnumero_fuePedidoExpor;
	}

	public Boolean getActivarnumero_fuePedidoExpor() {
		return this.activarnumero_fuePedidoExpor;
	}

	public void setActivarnumero_fuePedidoExpor(Boolean activarnumero_fuePedidoExpor) {
		this.activarnumero_fuePedidoExpor= activarnumero_fuePedidoExpor;
	}

	public Border setResaltarid_centro_costoPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoPedidoExpor() {
		return this.resaltarid_centro_costoPedidoExpor;
	}

	public void setResaltarid_centro_costoPedidoExpor(Border borderResaltar) {
		this.resaltarid_centro_costoPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoPedidoExpor() {
		return this.mostrarid_centro_costoPedidoExpor;
	}

	public void setMostrarid_centro_costoPedidoExpor(Boolean mostrarid_centro_costoPedidoExpor) {
		this.mostrarid_centro_costoPedidoExpor= mostrarid_centro_costoPedidoExpor;
	}

	public Boolean getActivarid_centro_costoPedidoExpor() {
		return this.activarid_centro_costoPedidoExpor;
	}

	public void setActivarid_centro_costoPedidoExpor(Boolean activarid_centro_costoPedidoExpor) {
		this.activarid_centro_costoPedidoExpor= activarid_centro_costoPedidoExpor;
	}

	public Boolean getCargarid_centro_costoPedidoExpor() {
		return this.cargarid_centro_costoPedidoExpor;
	}

	public void setCargarid_centro_costoPedidoExpor(Boolean cargarid_centro_costoPedidoExpor) {
		this.cargarid_centro_costoPedidoExpor= cargarid_centro_costoPedidoExpor;
	}

	public Border setResaltarid_responsablePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_responsablePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_responsablePedidoExpor() {
		return this.resaltarid_responsablePedidoExpor;
	}

	public void setResaltarid_responsablePedidoExpor(Border borderResaltar) {
		this.resaltarid_responsablePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_responsablePedidoExpor() {
		return this.mostrarid_responsablePedidoExpor;
	}

	public void setMostrarid_responsablePedidoExpor(Boolean mostrarid_responsablePedidoExpor) {
		this.mostrarid_responsablePedidoExpor= mostrarid_responsablePedidoExpor;
	}

	public Boolean getActivarid_responsablePedidoExpor() {
		return this.activarid_responsablePedidoExpor;
	}

	public void setActivarid_responsablePedidoExpor(Boolean activarid_responsablePedidoExpor) {
		this.activarid_responsablePedidoExpor= activarid_responsablePedidoExpor;
	}

	public Boolean getCargarid_responsablePedidoExpor() {
		return this.cargarid_responsablePedidoExpor;
	}

	public void setCargarid_responsablePedidoExpor(Boolean cargarid_responsablePedidoExpor) {
		this.cargarid_responsablePedidoExpor= cargarid_responsablePedidoExpor;
	}

	public Border setResaltarhora_inicioPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarhora_inicioPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_inicioPedidoExpor() {
		return this.resaltarhora_inicioPedidoExpor;
	}

	public void setResaltarhora_inicioPedidoExpor(Border borderResaltar) {
		this.resaltarhora_inicioPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarhora_inicioPedidoExpor() {
		return this.mostrarhora_inicioPedidoExpor;
	}

	public void setMostrarhora_inicioPedidoExpor(Boolean mostrarhora_inicioPedidoExpor) {
		this.mostrarhora_inicioPedidoExpor= mostrarhora_inicioPedidoExpor;
	}

	public Boolean getActivarhora_inicioPedidoExpor() {
		return this.activarhora_inicioPedidoExpor;
	}

	public void setActivarhora_inicioPedidoExpor(Boolean activarhora_inicioPedidoExpor) {
		this.activarhora_inicioPedidoExpor= activarhora_inicioPedidoExpor;
	}

	public Border setResaltarhora_finPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarhora_finPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_finPedidoExpor() {
		return this.resaltarhora_finPedidoExpor;
	}

	public void setResaltarhora_finPedidoExpor(Border borderResaltar) {
		this.resaltarhora_finPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarhora_finPedidoExpor() {
		return this.mostrarhora_finPedidoExpor;
	}

	public void setMostrarhora_finPedidoExpor(Boolean mostrarhora_finPedidoExpor) {
		this.mostrarhora_finPedidoExpor= mostrarhora_finPedidoExpor;
	}

	public Boolean getActivarhora_finPedidoExpor() {
		return this.activarhora_finPedidoExpor;
	}

	public void setActivarhora_finPedidoExpor(Boolean activarhora_finPedidoExpor) {
		this.activarhora_finPedidoExpor= activarhora_finPedidoExpor;
	}

	public Border setResaltarid_transportistaPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_transportistaPedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transportistaPedidoExpor() {
		return this.resaltarid_transportistaPedidoExpor;
	}

	public void setResaltarid_transportistaPedidoExpor(Border borderResaltar) {
		this.resaltarid_transportistaPedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_transportistaPedidoExpor() {
		return this.mostrarid_transportistaPedidoExpor;
	}

	public void setMostrarid_transportistaPedidoExpor(Boolean mostrarid_transportistaPedidoExpor) {
		this.mostrarid_transportistaPedidoExpor= mostrarid_transportistaPedidoExpor;
	}

	public Boolean getActivarid_transportistaPedidoExpor() {
		return this.activarid_transportistaPedidoExpor;
	}

	public void setActivarid_transportistaPedidoExpor(Boolean activarid_transportistaPedidoExpor) {
		this.activarid_transportistaPedidoExpor= activarid_transportistaPedidoExpor;
	}

	public Boolean getCargarid_transportistaPedidoExpor() {
		return this.cargarid_transportistaPedidoExpor;
	}

	public void setCargarid_transportistaPedidoExpor(Boolean cargarid_transportistaPedidoExpor) {
		this.cargarid_transportistaPedidoExpor= cargarid_transportistaPedidoExpor;
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
		
		
		this.setMostraridPedidoExpor(esInicial);
		this.setMostrarid_empresaPedidoExpor(esInicial);
		this.setMostrarid_sucursalPedidoExpor(esInicial);
		this.setMostrarid_ejercicioPedidoExpor(esInicial);
		this.setMostrarid_periodoPedidoExpor(esInicial);
		this.setMostrarid_anioPedidoExpor(esInicial);
		this.setMostrarid_mesPedidoExpor(esInicial);
		this.setMostrarid_usuarioPedidoExpor(esInicial);
		this.setMostrarnumeroPedidoExpor(esInicial);
		this.setMostrarnumero_preimpresoPedidoExpor(esInicial);
		this.setMostrarfecha_emisionPedidoExpor(esInicial);
		this.setMostrarfecha_vencimientoPedidoExpor(esInicial);
		this.setMostrarid_monedaPedidoExpor(esInicial);
		this.setMostrarcotizacionPedidoExpor(esInicial);
		this.setMostrarid_empleadoPedidoExpor(esInicial);
		this.setMostrarid_tipo_precioPedidoExpor(esInicial);
		this.setMostrarid_formatoPedidoExpor(esInicial);
		this.setMostrardireccionPedidoExpor(esInicial);
		this.setMostrarid_clientePedidoExpor(esInicial);
		this.setMostrartelefonoPedidoExpor(esInicial);
		this.setMostrarrucPedidoExpor(esInicial);
		this.setMostrarid_paisPedidoExpor(esInicial);
		this.setMostrarlugar_entregaPedidoExpor(esInicial);
		this.setMostrarembarquePedidoExpor(esInicial);
		this.setMostrarnegociacionPedidoExpor(esInicial);
		this.setMostrarid_transportePedidoExpor(esInicial);
		this.setMostrarid_vendedorPedidoExpor(esInicial);
		this.setMostrarforma_pagoPedidoExpor(esInicial);
		this.setMostrarid_sub_clientePedidoExpor(esInicial);
		this.setMostrarid_consignatarioPedidoExpor(esInicial);
		this.setMostrarid_consultorPedidoExpor(esInicial);
		this.setMostrarordenPedidoExpor(esInicial);
		this.setMostrarid_estado_pedidoPedidoExpor(esInicial);
		this.setMostrardescripcionPedidoExpor(esInicial);
		this.setMostrarmontoPedidoExpor(esInicial);
		this.setMostrarsaldoPedidoExpor(esInicial);
		this.setMostrardisponiblePedidoExpor(esInicial);
		this.setMostrardescuento_porcentajePedidoExpor(esInicial);
		this.setMostrartotal_con_ivaPedidoExpor(esInicial);
		this.setMostrarsumanPedidoExpor(esInicial);
		this.setMostrardescuento_valorPedidoExpor(esInicial);
		this.setMostrartotal_sin_ivaPedidoExpor(esInicial);
		this.setMostrartotal_descuentoPedidoExpor(esInicial);
		this.setMostrarfletePedidoExpor(esInicial);
		this.setMostrartotalPedidoExpor(esInicial);
		this.setMostrarsubtotalPedidoExpor(esInicial);
		this.setMostrarsegurosPedidoExpor(esInicial);
		this.setMostrarivaPedidoExpor(esInicial);
		this.setMostrarfinanciamientoPedidoExpor(esInicial);
		this.setMostrarmonto_retencionPedidoExpor(esInicial);
		this.setMostrarotroPedidoExpor(esInicial);
		this.setMostraricePedidoExpor(esInicial);
		this.setMostrarfechaPedidoExpor(esInicial);
		this.setMostrarfecha_servidorPedidoExpor(esInicial);
		this.setMostrarid_tipo_cambioPedidoExpor(esInicial);
		this.setMostrarnumero_fuePedidoExpor(esInicial);
		this.setMostrarid_centro_costoPedidoExpor(esInicial);
		this.setMostrarid_responsablePedidoExpor(esInicial);
		this.setMostrarhora_inicioPedidoExpor(esInicial);
		this.setMostrarhora_finPedidoExpor(esInicial);
		this.setMostrarid_transportistaPedidoExpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidoExporConstantesFunciones.ID)) {
				this.setMostraridPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDMES)) {
				this.setMostrarid_mesPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setMostrarnumero_preimpresoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.COTIZACION)) {
				this.setMostrarcotizacionPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDTIPOPRECIO)) {
				this.setMostrarid_tipo_precioPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clientePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.RUC)) {
				this.setMostrarrucPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.LUGARENTREGA)) {
				this.setMostrarlugar_entregaPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.EMBARQUE)) {
				this.setMostrarembarquePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.NEGOCIACION)) {
				this.setMostrarnegociacionPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDTRANSPORTE)) {
				this.setMostrarid_transportePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.FORMAPAGO)) {
				this.setMostrarforma_pagoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDSUBCLIENTE)) {
				this.setMostrarid_sub_clientePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDCONSIGNATARIO)) {
				this.setMostrarid_consignatarioPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDCONSULTOR)) {
				this.setMostrarid_consultorPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.ORDEN)) {
				this.setMostrarordenPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDESTADOPEDIDOEXPOR)) {
				this.setMostrarid_estado_pedidoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.MONTO)) {
				this.setMostrarmontoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.SALDO)) {
				this.setMostrarsaldoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.DISPONIBLE)) {
				this.setMostrardisponiblePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setMostrardescuento_porcentajePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.TOTALCONIVA)) {
				this.setMostrartotal_con_ivaPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.SUMAN)) {
				this.setMostrarsumanPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.DESCUENTOVALOR)) {
				this.setMostrardescuento_valorPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.TOTALSINIVA)) {
				this.setMostrartotal_sin_ivaPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.TOTALDESCUENTO)) {
				this.setMostrartotal_descuentoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.FLETE)) {
				this.setMostrarfletePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.TOTAL)) {
				this.setMostrartotalPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsubtotalPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.SEGUROS)) {
				this.setMostrarsegurosPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IVA)) {
				this.setMostrarivaPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.FINANCIAMIENTO)) {
				this.setMostrarfinanciamientoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.MONTORETENCION)) {
				this.setMostrarmonto_retencionPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.OTRO)) {
				this.setMostrarotroPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.ICE)) {
				this.setMostraricePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.FECHA)) {
				this.setMostrarfechaPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.FECHASERVIDOR)) {
				this.setMostrarfecha_servidorPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDTIPOCAMBIO)) {
				this.setMostrarid_tipo_cambioPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.NUMEROFUE)) {
				this.setMostrarnumero_fuePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDRESPONSABLE)) {
				this.setMostrarid_responsablePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.HORAINICIO)) {
				this.setMostrarhora_inicioPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.HORAFIN)) {
				this.setMostrarhora_finPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDTRANSPORTISTA)) {
				this.setMostrarid_transportistaPedidoExpor(esAsigna);
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
		
		
		this.setActivaridPedidoExpor(esInicial);
		this.setActivarid_empresaPedidoExpor(esInicial);
		this.setActivarid_sucursalPedidoExpor(esInicial);
		this.setActivarid_ejercicioPedidoExpor(esInicial);
		this.setActivarid_periodoPedidoExpor(esInicial);
		this.setActivarid_anioPedidoExpor(esInicial);
		this.setActivarid_mesPedidoExpor(esInicial);
		this.setActivarid_usuarioPedidoExpor(esInicial);
		this.setActivarnumeroPedidoExpor(esInicial);
		this.setActivarnumero_preimpresoPedidoExpor(esInicial);
		this.setActivarfecha_emisionPedidoExpor(esInicial);
		this.setActivarfecha_vencimientoPedidoExpor(esInicial);
		this.setActivarid_monedaPedidoExpor(esInicial);
		this.setActivarcotizacionPedidoExpor(esInicial);
		this.setActivarid_empleadoPedidoExpor(esInicial);
		this.setActivarid_tipo_precioPedidoExpor(esInicial);
		this.setActivarid_formatoPedidoExpor(esInicial);
		this.setActivardireccionPedidoExpor(esInicial);
		this.setActivarid_clientePedidoExpor(esInicial);
		this.setActivartelefonoPedidoExpor(esInicial);
		this.setActivarrucPedidoExpor(esInicial);
		this.setActivarid_paisPedidoExpor(esInicial);
		this.setActivarlugar_entregaPedidoExpor(esInicial);
		this.setActivarembarquePedidoExpor(esInicial);
		this.setActivarnegociacionPedidoExpor(esInicial);
		this.setActivarid_transportePedidoExpor(esInicial);
		this.setActivarid_vendedorPedidoExpor(esInicial);
		this.setActivarforma_pagoPedidoExpor(esInicial);
		this.setActivarid_sub_clientePedidoExpor(esInicial);
		this.setActivarid_consignatarioPedidoExpor(esInicial);
		this.setActivarid_consultorPedidoExpor(esInicial);
		this.setActivarordenPedidoExpor(esInicial);
		this.setActivarid_estado_pedidoPedidoExpor(esInicial);
		this.setActivardescripcionPedidoExpor(esInicial);
		this.setActivarmontoPedidoExpor(esInicial);
		this.setActivarsaldoPedidoExpor(esInicial);
		this.setActivardisponiblePedidoExpor(esInicial);
		this.setActivardescuento_porcentajePedidoExpor(esInicial);
		this.setActivartotal_con_ivaPedidoExpor(esInicial);
		this.setActivarsumanPedidoExpor(esInicial);
		this.setActivardescuento_valorPedidoExpor(esInicial);
		this.setActivartotal_sin_ivaPedidoExpor(esInicial);
		this.setActivartotal_descuentoPedidoExpor(esInicial);
		this.setActivarfletePedidoExpor(esInicial);
		this.setActivartotalPedidoExpor(esInicial);
		this.setActivarsubtotalPedidoExpor(esInicial);
		this.setActivarsegurosPedidoExpor(esInicial);
		this.setActivarivaPedidoExpor(esInicial);
		this.setActivarfinanciamientoPedidoExpor(esInicial);
		this.setActivarmonto_retencionPedidoExpor(esInicial);
		this.setActivarotroPedidoExpor(esInicial);
		this.setActivaricePedidoExpor(esInicial);
		this.setActivarfechaPedidoExpor(esInicial);
		this.setActivarfecha_servidorPedidoExpor(esInicial);
		this.setActivarid_tipo_cambioPedidoExpor(esInicial);
		this.setActivarnumero_fuePedidoExpor(esInicial);
		this.setActivarid_centro_costoPedidoExpor(esInicial);
		this.setActivarid_responsablePedidoExpor(esInicial);
		this.setActivarhora_inicioPedidoExpor(esInicial);
		this.setActivarhora_finPedidoExpor(esInicial);
		this.setActivarid_transportistaPedidoExpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidoExporConstantesFunciones.ID)) {
				this.setActivaridPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDANIO)) {
				this.setActivarid_anioPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDMES)) {
				this.setActivarid_mesPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.NUMERO)) {
				this.setActivarnumeroPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setActivarnumero_preimpresoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.COTIZACION)) {
				this.setActivarcotizacionPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDTIPOPRECIO)) {
				this.setActivarid_tipo_precioPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.DIRECCION)) {
				this.setActivardireccionPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clientePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.RUC)) {
				this.setActivarrucPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.LUGARENTREGA)) {
				this.setActivarlugar_entregaPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.EMBARQUE)) {
				this.setActivarembarquePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.NEGOCIACION)) {
				this.setActivarnegociacionPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDTRANSPORTE)) {
				this.setActivarid_transportePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.FORMAPAGO)) {
				this.setActivarforma_pagoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDSUBCLIENTE)) {
				this.setActivarid_sub_clientePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDCONSIGNATARIO)) {
				this.setActivarid_consignatarioPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDCONSULTOR)) {
				this.setActivarid_consultorPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.ORDEN)) {
				this.setActivarordenPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDESTADOPEDIDOEXPOR)) {
				this.setActivarid_estado_pedidoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.MONTO)) {
				this.setActivarmontoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.SALDO)) {
				this.setActivarsaldoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.DISPONIBLE)) {
				this.setActivardisponiblePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setActivardescuento_porcentajePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.TOTALCONIVA)) {
				this.setActivartotal_con_ivaPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.SUMAN)) {
				this.setActivarsumanPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.DESCUENTOVALOR)) {
				this.setActivardescuento_valorPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.TOTALSINIVA)) {
				this.setActivartotal_sin_ivaPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.TOTALDESCUENTO)) {
				this.setActivartotal_descuentoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.FLETE)) {
				this.setActivarfletePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.TOTAL)) {
				this.setActivartotalPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.SUBTOTAL)) {
				this.setActivarsubtotalPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.SEGUROS)) {
				this.setActivarsegurosPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IVA)) {
				this.setActivarivaPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.FINANCIAMIENTO)) {
				this.setActivarfinanciamientoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.MONTORETENCION)) {
				this.setActivarmonto_retencionPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.OTRO)) {
				this.setActivarotroPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.ICE)) {
				this.setActivaricePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.FECHA)) {
				this.setActivarfechaPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.FECHASERVIDOR)) {
				this.setActivarfecha_servidorPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDTIPOCAMBIO)) {
				this.setActivarid_tipo_cambioPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.NUMEROFUE)) {
				this.setActivarnumero_fuePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDRESPONSABLE)) {
				this.setActivarid_responsablePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.HORAINICIO)) {
				this.setActivarhora_inicioPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.HORAFIN)) {
				this.setActivarhora_finPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDTRANSPORTISTA)) {
				this.setActivarid_transportistaPedidoExpor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPedidoExpor(esInicial);
		this.setResaltarid_empresaPedidoExpor(esInicial);
		this.setResaltarid_sucursalPedidoExpor(esInicial);
		this.setResaltarid_ejercicioPedidoExpor(esInicial);
		this.setResaltarid_periodoPedidoExpor(esInicial);
		this.setResaltarid_anioPedidoExpor(esInicial);
		this.setResaltarid_mesPedidoExpor(esInicial);
		this.setResaltarid_usuarioPedidoExpor(esInicial);
		this.setResaltarnumeroPedidoExpor(esInicial);
		this.setResaltarnumero_preimpresoPedidoExpor(esInicial);
		this.setResaltarfecha_emisionPedidoExpor(esInicial);
		this.setResaltarfecha_vencimientoPedidoExpor(esInicial);
		this.setResaltarid_monedaPedidoExpor(esInicial);
		this.setResaltarcotizacionPedidoExpor(esInicial);
		this.setResaltarid_empleadoPedidoExpor(esInicial);
		this.setResaltarid_tipo_precioPedidoExpor(esInicial);
		this.setResaltarid_formatoPedidoExpor(esInicial);
		this.setResaltardireccionPedidoExpor(esInicial);
		this.setResaltarid_clientePedidoExpor(esInicial);
		this.setResaltartelefonoPedidoExpor(esInicial);
		this.setResaltarrucPedidoExpor(esInicial);
		this.setResaltarid_paisPedidoExpor(esInicial);
		this.setResaltarlugar_entregaPedidoExpor(esInicial);
		this.setResaltarembarquePedidoExpor(esInicial);
		this.setResaltarnegociacionPedidoExpor(esInicial);
		this.setResaltarid_transportePedidoExpor(esInicial);
		this.setResaltarid_vendedorPedidoExpor(esInicial);
		this.setResaltarforma_pagoPedidoExpor(esInicial);
		this.setResaltarid_sub_clientePedidoExpor(esInicial);
		this.setResaltarid_consignatarioPedidoExpor(esInicial);
		this.setResaltarid_consultorPedidoExpor(esInicial);
		this.setResaltarordenPedidoExpor(esInicial);
		this.setResaltarid_estado_pedidoPedidoExpor(esInicial);
		this.setResaltardescripcionPedidoExpor(esInicial);
		this.setResaltarmontoPedidoExpor(esInicial);
		this.setResaltarsaldoPedidoExpor(esInicial);
		this.setResaltardisponiblePedidoExpor(esInicial);
		this.setResaltardescuento_porcentajePedidoExpor(esInicial);
		this.setResaltartotal_con_ivaPedidoExpor(esInicial);
		this.setResaltarsumanPedidoExpor(esInicial);
		this.setResaltardescuento_valorPedidoExpor(esInicial);
		this.setResaltartotal_sin_ivaPedidoExpor(esInicial);
		this.setResaltartotal_descuentoPedidoExpor(esInicial);
		this.setResaltarfletePedidoExpor(esInicial);
		this.setResaltartotalPedidoExpor(esInicial);
		this.setResaltarsubtotalPedidoExpor(esInicial);
		this.setResaltarsegurosPedidoExpor(esInicial);
		this.setResaltarivaPedidoExpor(esInicial);
		this.setResaltarfinanciamientoPedidoExpor(esInicial);
		this.setResaltarmonto_retencionPedidoExpor(esInicial);
		this.setResaltarotroPedidoExpor(esInicial);
		this.setResaltaricePedidoExpor(esInicial);
		this.setResaltarfechaPedidoExpor(esInicial);
		this.setResaltarfecha_servidorPedidoExpor(esInicial);
		this.setResaltarid_tipo_cambioPedidoExpor(esInicial);
		this.setResaltarnumero_fuePedidoExpor(esInicial);
		this.setResaltarid_centro_costoPedidoExpor(esInicial);
		this.setResaltarid_responsablePedidoExpor(esInicial);
		this.setResaltarhora_inicioPedidoExpor(esInicial);
		this.setResaltarhora_finPedidoExpor(esInicial);
		this.setResaltarid_transportistaPedidoExpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidoExporConstantesFunciones.ID)) {
				this.setResaltaridPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDMES)) {
				this.setResaltarid_mesPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setResaltarnumero_preimpresoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.COTIZACION)) {
				this.setResaltarcotizacionPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDTIPOPRECIO)) {
				this.setResaltarid_tipo_precioPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clientePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.RUC)) {
				this.setResaltarrucPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.LUGARENTREGA)) {
				this.setResaltarlugar_entregaPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.EMBARQUE)) {
				this.setResaltarembarquePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.NEGOCIACION)) {
				this.setResaltarnegociacionPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDTRANSPORTE)) {
				this.setResaltarid_transportePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.FORMAPAGO)) {
				this.setResaltarforma_pagoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDSUBCLIENTE)) {
				this.setResaltarid_sub_clientePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDCONSIGNATARIO)) {
				this.setResaltarid_consignatarioPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDCONSULTOR)) {
				this.setResaltarid_consultorPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.ORDEN)) {
				this.setResaltarordenPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDESTADOPEDIDOEXPOR)) {
				this.setResaltarid_estado_pedidoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.MONTO)) {
				this.setResaltarmontoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.SALDO)) {
				this.setResaltarsaldoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.DISPONIBLE)) {
				this.setResaltardisponiblePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setResaltardescuento_porcentajePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.TOTALCONIVA)) {
				this.setResaltartotal_con_ivaPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.SUMAN)) {
				this.setResaltarsumanPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.DESCUENTOVALOR)) {
				this.setResaltardescuento_valorPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.TOTALSINIVA)) {
				this.setResaltartotal_sin_ivaPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.TOTALDESCUENTO)) {
				this.setResaltartotal_descuentoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.FLETE)) {
				this.setResaltarfletePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.TOTAL)) {
				this.setResaltartotalPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsubtotalPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.SEGUROS)) {
				this.setResaltarsegurosPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IVA)) {
				this.setResaltarivaPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.FINANCIAMIENTO)) {
				this.setResaltarfinanciamientoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.MONTORETENCION)) {
				this.setResaltarmonto_retencionPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.OTRO)) {
				this.setResaltarotroPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.ICE)) {
				this.setResaltaricePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.FECHA)) {
				this.setResaltarfechaPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.FECHASERVIDOR)) {
				this.setResaltarfecha_servidorPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDTIPOCAMBIO)) {
				this.setResaltarid_tipo_cambioPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.NUMEROFUE)) {
				this.setResaltarnumero_fuePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDRESPONSABLE)) {
				this.setResaltarid_responsablePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.HORAINICIO)) {
				this.setResaltarhora_inicioPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.HORAFIN)) {
				this.setResaltarhora_finPedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoExporConstantesFunciones.IDTRANSPORTISTA)) {
				this.setResaltarid_transportistaPedidoExpor(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetallePedidoExporPedidoExpor=null;

	public Border getResaltarDetallePedidoExporPedidoExpor() {
		return this.resaltarDetallePedidoExporPedidoExpor;
	}

	public void setResaltarDetallePedidoExporPedidoExpor(Border borderResaltarDetallePedidoExpor) {
		if(borderResaltarDetallePedidoExpor!=null) {
			this.resaltarDetallePedidoExporPedidoExpor= borderResaltarDetallePedidoExpor;
		}
	}

	public Border setResaltarDetallePedidoExporPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltarDetallePedidoExpor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//pedidoexporBeanSwingJInternalFrame.jTtoolBarPedidoExpor.setBorder(borderResaltarDetallePedidoExpor);
			
		this.resaltarDetallePedidoExporPedidoExpor= borderResaltarDetallePedidoExpor;

		 return borderResaltarDetallePedidoExpor;
	}



	public Boolean mostrarDetallePedidoExporPedidoExpor=true;

	public Boolean getMostrarDetallePedidoExporPedidoExpor() {
		return this.mostrarDetallePedidoExporPedidoExpor;
	}

	public void setMostrarDetallePedidoExporPedidoExpor(Boolean visibilidadResaltarDetallePedidoExpor) {
		this.mostrarDetallePedidoExporPedidoExpor= visibilidadResaltarDetallePedidoExpor;
	}



	public Boolean activarDetallePedidoExporPedidoExpor=true;

	public Boolean gethabilitarResaltarDetallePedidoExporPedidoExpor() {
		return this.activarDetallePedidoExporPedidoExpor;
	}

	public void setActivarDetallePedidoExporPedidoExpor(Boolean habilitarResaltarDetallePedidoExpor) {
		this.activarDetallePedidoExporPedidoExpor= habilitarResaltarDetallePedidoExpor;
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

		this.setMostrarDetallePedidoExporPedidoExpor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetallePedidoExpor.class)) {
				this.setMostrarDetallePedidoExporPedidoExpor(esAsigna);
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

		this.setActivarDetallePedidoExporPedidoExpor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetallePedidoExpor.class)) {
				this.setActivarDetallePedidoExporPedidoExpor(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetallePedidoExporPedidoExpor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetallePedidoExpor.class)) {
				this.setResaltarDetallePedidoExporPedidoExpor(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdCentroCostoPedidoExpor=true;

	public Boolean getMostrarFK_IdCentroCostoPedidoExpor() {
		return this.mostrarFK_IdCentroCostoPedidoExpor;
	}

	public void setMostrarFK_IdCentroCostoPedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoPedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClientePedidoExpor=true;

	public Boolean getMostrarFK_IdClientePedidoExpor() {
		return this.mostrarFK_IdClientePedidoExpor;
	}

	public void setMostrarFK_IdClientePedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClientePedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdConsignatarioPedidoExpor=true;

	public Boolean getMostrarFK_IdConsignatarioPedidoExpor() {
		return this.mostrarFK_IdConsignatarioPedidoExpor;
	}

	public void setMostrarFK_IdConsignatarioPedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdConsignatarioPedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdConsultorPedidoExpor=true;

	public Boolean getMostrarFK_IdConsultorPedidoExpor() {
		return this.mostrarFK_IdConsultorPedidoExpor;
	}

	public void setMostrarFK_IdConsultorPedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdConsultorPedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioPedidoExpor=true;

	public Boolean getMostrarFK_IdEjercicioPedidoExpor() {
		return this.mostrarFK_IdEjercicioPedidoExpor;
	}

	public void setMostrarFK_IdEjercicioPedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioPedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoPedidoExpor=true;

	public Boolean getMostrarFK_IdEmpleadoPedidoExpor() {
		return this.mostrarFK_IdEmpleadoPedidoExpor;
	}

	public void setMostrarFK_IdEmpleadoPedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoPedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPedidoExpor=true;

	public Boolean getMostrarFK_IdEmpresaPedidoExpor() {
		return this.mostrarFK_IdEmpresaPedidoExpor;
	}

	public void setMostrarFK_IdEmpresaPedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoPedidoExporPedidoExpor=true;

	public Boolean getMostrarFK_IdEstadoPedidoExporPedidoExpor() {
		return this.mostrarFK_IdEstadoPedidoExporPedidoExpor;
	}

	public void setMostrarFK_IdEstadoPedidoExporPedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoPedidoExporPedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoPedidoExpor=true;

	public Boolean getMostrarFK_IdFormatoPedidoExpor() {
		return this.mostrarFK_IdFormatoPedidoExpor;
	}

	public void setMostrarFK_IdFormatoPedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoPedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMonedaPedidoExpor=true;

	public Boolean getMostrarFK_IdMonedaPedidoExpor() {
		return this.mostrarFK_IdMonedaPedidoExpor;
	}

	public void setMostrarFK_IdMonedaPedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMonedaPedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisPedidoExpor=true;

	public Boolean getMostrarFK_IdPaisPedidoExpor() {
		return this.mostrarFK_IdPaisPedidoExpor;
	}

	public void setMostrarFK_IdPaisPedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisPedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoPedidoExpor=true;

	public Boolean getMostrarFK_IdPeriodoPedidoExpor() {
		return this.mostrarFK_IdPeriodoPedidoExpor;
	}

	public void setMostrarFK_IdPeriodoPedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoPedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdResponsablePedidoExpor=true;

	public Boolean getMostrarFK_IdResponsablePedidoExpor() {
		return this.mostrarFK_IdResponsablePedidoExpor;
	}

	public void setMostrarFK_IdResponsablePedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdResponsablePedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSubClientePedidoExpor=true;

	public Boolean getMostrarFK_IdSubClientePedidoExpor() {
		return this.mostrarFK_IdSubClientePedidoExpor;
	}

	public void setMostrarFK_IdSubClientePedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSubClientePedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalPedidoExpor=true;

	public Boolean getMostrarFK_IdSucursalPedidoExpor() {
		return this.mostrarFK_IdSucursalPedidoExpor;
	}

	public void setMostrarFK_IdSucursalPedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalPedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCambioPedidoExpor=true;

	public Boolean getMostrarFK_IdTipoCambioPedidoExpor() {
		return this.mostrarFK_IdTipoCambioPedidoExpor;
	}

	public void setMostrarFK_IdTipoCambioPedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCambioPedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPrecioPedidoExpor=true;

	public Boolean getMostrarFK_IdTipoPrecioPedidoExpor() {
		return this.mostrarFK_IdTipoPrecioPedidoExpor;
	}

	public void setMostrarFK_IdTipoPrecioPedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPrecioPedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransportePedidoExpor=true;

	public Boolean getMostrarFK_IdTransportePedidoExpor() {
		return this.mostrarFK_IdTransportePedidoExpor;
	}

	public void setMostrarFK_IdTransportePedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransportePedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransportistaPedidoExpor=true;

	public Boolean getMostrarFK_IdTransportistaPedidoExpor() {
		return this.mostrarFK_IdTransportistaPedidoExpor;
	}

	public void setMostrarFK_IdTransportistaPedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransportistaPedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioPedidoExpor=true;

	public Boolean getMostrarFK_IdUsuarioPedidoExpor() {
		return this.mostrarFK_IdUsuarioPedidoExpor;
	}

	public void setMostrarFK_IdUsuarioPedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioPedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdVendedorPedidoExpor=true;

	public Boolean getMostrarFK_IdVendedorPedidoExpor() {
		return this.mostrarFK_IdVendedorPedidoExpor;
	}

	public void setMostrarFK_IdVendedorPedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdVendedorPedidoExpor= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCentroCostoPedidoExpor=true;

	public Boolean getActivarFK_IdCentroCostoPedidoExpor() {
		return this.activarFK_IdCentroCostoPedidoExpor;
	}

	public void setActivarFK_IdCentroCostoPedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoPedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdClientePedidoExpor=true;

	public Boolean getActivarFK_IdClientePedidoExpor() {
		return this.activarFK_IdClientePedidoExpor;
	}

	public void setActivarFK_IdClientePedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdClientePedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdConsignatarioPedidoExpor=true;

	public Boolean getActivarFK_IdConsignatarioPedidoExpor() {
		return this.activarFK_IdConsignatarioPedidoExpor;
	}

	public void setActivarFK_IdConsignatarioPedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdConsignatarioPedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdConsultorPedidoExpor=true;

	public Boolean getActivarFK_IdConsultorPedidoExpor() {
		return this.activarFK_IdConsultorPedidoExpor;
	}

	public void setActivarFK_IdConsultorPedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdConsultorPedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioPedidoExpor=true;

	public Boolean getActivarFK_IdEjercicioPedidoExpor() {
		return this.activarFK_IdEjercicioPedidoExpor;
	}

	public void setActivarFK_IdEjercicioPedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioPedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoPedidoExpor=true;

	public Boolean getActivarFK_IdEmpleadoPedidoExpor() {
		return this.activarFK_IdEmpleadoPedidoExpor;
	}

	public void setActivarFK_IdEmpleadoPedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoPedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPedidoExpor=true;

	public Boolean getActivarFK_IdEmpresaPedidoExpor() {
		return this.activarFK_IdEmpresaPedidoExpor;
	}

	public void setActivarFK_IdEmpresaPedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoPedidoExporPedidoExpor=true;

	public Boolean getActivarFK_IdEstadoPedidoExporPedidoExpor() {
		return this.activarFK_IdEstadoPedidoExporPedidoExpor;
	}

	public void setActivarFK_IdEstadoPedidoExporPedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoPedidoExporPedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoPedidoExpor=true;

	public Boolean getActivarFK_IdFormatoPedidoExpor() {
		return this.activarFK_IdFormatoPedidoExpor;
	}

	public void setActivarFK_IdFormatoPedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoPedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdMonedaPedidoExpor=true;

	public Boolean getActivarFK_IdMonedaPedidoExpor() {
		return this.activarFK_IdMonedaPedidoExpor;
	}

	public void setActivarFK_IdMonedaPedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdMonedaPedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisPedidoExpor=true;

	public Boolean getActivarFK_IdPaisPedidoExpor() {
		return this.activarFK_IdPaisPedidoExpor;
	}

	public void setActivarFK_IdPaisPedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdPaisPedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoPedidoExpor=true;

	public Boolean getActivarFK_IdPeriodoPedidoExpor() {
		return this.activarFK_IdPeriodoPedidoExpor;
	}

	public void setActivarFK_IdPeriodoPedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoPedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdResponsablePedidoExpor=true;

	public Boolean getActivarFK_IdResponsablePedidoExpor() {
		return this.activarFK_IdResponsablePedidoExpor;
	}

	public void setActivarFK_IdResponsablePedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdResponsablePedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdSubClientePedidoExpor=true;

	public Boolean getActivarFK_IdSubClientePedidoExpor() {
		return this.activarFK_IdSubClientePedidoExpor;
	}

	public void setActivarFK_IdSubClientePedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdSubClientePedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalPedidoExpor=true;

	public Boolean getActivarFK_IdSucursalPedidoExpor() {
		return this.activarFK_IdSucursalPedidoExpor;
	}

	public void setActivarFK_IdSucursalPedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalPedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCambioPedidoExpor=true;

	public Boolean getActivarFK_IdTipoCambioPedidoExpor() {
		return this.activarFK_IdTipoCambioPedidoExpor;
	}

	public void setActivarFK_IdTipoCambioPedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCambioPedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPrecioPedidoExpor=true;

	public Boolean getActivarFK_IdTipoPrecioPedidoExpor() {
		return this.activarFK_IdTipoPrecioPedidoExpor;
	}

	public void setActivarFK_IdTipoPrecioPedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPrecioPedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdTransportePedidoExpor=true;

	public Boolean getActivarFK_IdTransportePedidoExpor() {
		return this.activarFK_IdTransportePedidoExpor;
	}

	public void setActivarFK_IdTransportePedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdTransportePedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdTransportistaPedidoExpor=true;

	public Boolean getActivarFK_IdTransportistaPedidoExpor() {
		return this.activarFK_IdTransportistaPedidoExpor;
	}

	public void setActivarFK_IdTransportistaPedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdTransportistaPedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioPedidoExpor=true;

	public Boolean getActivarFK_IdUsuarioPedidoExpor() {
		return this.activarFK_IdUsuarioPedidoExpor;
	}

	public void setActivarFK_IdUsuarioPedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioPedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdVendedorPedidoExpor=true;

	public Boolean getActivarFK_IdVendedorPedidoExpor() {
		return this.activarFK_IdVendedorPedidoExpor;
	}

	public void setActivarFK_IdVendedorPedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdVendedorPedidoExpor= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCentroCostoPedidoExpor=null;

	public Border getResaltarFK_IdCentroCostoPedidoExpor() {
		return this.resaltarFK_IdCentroCostoPedidoExpor;
	}

	public void setResaltarFK_IdCentroCostoPedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoPedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoPedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdClientePedidoExpor=null;

	public Border getResaltarFK_IdClientePedidoExpor() {
		return this.resaltarFK_IdClientePedidoExpor;
	}

	public void setResaltarFK_IdClientePedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdClientePedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdClientePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClientePedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdConsignatarioPedidoExpor=null;

	public Border getResaltarFK_IdConsignatarioPedidoExpor() {
		return this.resaltarFK_IdConsignatarioPedidoExpor;
	}

	public void setResaltarFK_IdConsignatarioPedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdConsignatarioPedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdConsignatarioPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdConsignatarioPedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdConsultorPedidoExpor=null;

	public Border getResaltarFK_IdConsultorPedidoExpor() {
		return this.resaltarFK_IdConsultorPedidoExpor;
	}

	public void setResaltarFK_IdConsultorPedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdConsultorPedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdConsultorPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdConsultorPedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioPedidoExpor=null;

	public Border getResaltarFK_IdEjercicioPedidoExpor() {
		return this.resaltarFK_IdEjercicioPedidoExpor;
	}

	public void setResaltarFK_IdEjercicioPedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdEjercicioPedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioPedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoPedidoExpor=null;

	public Border getResaltarFK_IdEmpleadoPedidoExpor() {
		return this.resaltarFK_IdEmpleadoPedidoExpor;
	}

	public void setResaltarFK_IdEmpleadoPedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoPedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoPedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPedidoExpor=null;

	public Border getResaltarFK_IdEmpresaPedidoExpor() {
		return this.resaltarFK_IdEmpresaPedidoExpor;
	}

	public void setResaltarFK_IdEmpresaPedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdEstadoPedidoExporPedidoExpor=null;

	public Border getResaltarFK_IdEstadoPedidoExporPedidoExpor() {
		return this.resaltarFK_IdEstadoPedidoExporPedidoExpor;
	}

	public void setResaltarFK_IdEstadoPedidoExporPedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdEstadoPedidoExporPedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdEstadoPedidoExporPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoPedidoExporPedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdFormatoPedidoExpor=null;

	public Border getResaltarFK_IdFormatoPedidoExpor() {
		return this.resaltarFK_IdFormatoPedidoExpor;
	}

	public void setResaltarFK_IdFormatoPedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdFormatoPedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdFormatoPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoPedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdMonedaPedidoExpor=null;

	public Border getResaltarFK_IdMonedaPedidoExpor() {
		return this.resaltarFK_IdMonedaPedidoExpor;
	}

	public void setResaltarFK_IdMonedaPedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdMonedaPedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdMonedaPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMonedaPedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdPaisPedidoExpor=null;

	public Border getResaltarFK_IdPaisPedidoExpor() {
		return this.resaltarFK_IdPaisPedidoExpor;
	}

	public void setResaltarFK_IdPaisPedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdPaisPedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdPaisPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisPedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoPedidoExpor=null;

	public Border getResaltarFK_IdPeriodoPedidoExpor() {
		return this.resaltarFK_IdPeriodoPedidoExpor;
	}

	public void setResaltarFK_IdPeriodoPedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdPeriodoPedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoPedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdResponsablePedidoExpor=null;

	public Border getResaltarFK_IdResponsablePedidoExpor() {
		return this.resaltarFK_IdResponsablePedidoExpor;
	}

	public void setResaltarFK_IdResponsablePedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdResponsablePedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdResponsablePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdResponsablePedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdSubClientePedidoExpor=null;

	public Border getResaltarFK_IdSubClientePedidoExpor() {
		return this.resaltarFK_IdSubClientePedidoExpor;
	}

	public void setResaltarFK_IdSubClientePedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdSubClientePedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdSubClientePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSubClientePedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdSucursalPedidoExpor=null;

	public Border getResaltarFK_IdSucursalPedidoExpor() {
		return this.resaltarFK_IdSucursalPedidoExpor;
	}

	public void setResaltarFK_IdSucursalPedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdSucursalPedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdSucursalPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalPedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdTipoCambioPedidoExpor=null;

	public Border getResaltarFK_IdTipoCambioPedidoExpor() {
		return this.resaltarFK_IdTipoCambioPedidoExpor;
	}

	public void setResaltarFK_IdTipoCambioPedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdTipoCambioPedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdTipoCambioPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCambioPedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdTipoPrecioPedidoExpor=null;

	public Border getResaltarFK_IdTipoPrecioPedidoExpor() {
		return this.resaltarFK_IdTipoPrecioPedidoExpor;
	}

	public void setResaltarFK_IdTipoPrecioPedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdTipoPrecioPedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdTipoPrecioPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPrecioPedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdTransportePedidoExpor=null;

	public Border getResaltarFK_IdTransportePedidoExpor() {
		return this.resaltarFK_IdTransportePedidoExpor;
	}

	public void setResaltarFK_IdTransportePedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdTransportePedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdTransportePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransportePedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdTransportistaPedidoExpor=null;

	public Border getResaltarFK_IdTransportistaPedidoExpor() {
		return this.resaltarFK_IdTransportistaPedidoExpor;
	}

	public void setResaltarFK_IdTransportistaPedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdTransportistaPedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdTransportistaPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransportistaPedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioPedidoExpor=null;

	public Border getResaltarFK_IdUsuarioPedidoExpor() {
		return this.resaltarFK_IdUsuarioPedidoExpor;
	}

	public void setResaltarFK_IdUsuarioPedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdUsuarioPedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioPedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdVendedorPedidoExpor=null;

	public Border getResaltarFK_IdVendedorPedidoExpor() {
		return this.resaltarFK_IdVendedorPedidoExpor;
	}

	public void setResaltarFK_IdVendedorPedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdVendedorPedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdVendedorPedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoExporBeanSwingJInternalFrame pedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdVendedorPedidoExpor= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}