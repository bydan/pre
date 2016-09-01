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
package com.bydan.erp.importaciones.util;

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


import com.bydan.erp.importaciones.util.PedidoCompraImporConstantesFunciones;
import com.bydan.erp.importaciones.util.PedidoCompraImporParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.PedidoCompraImporParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.importaciones.business.dataaccess.*;
//import com.bydan.erp.importaciones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PedidoCompraImporConstantesFunciones extends PedidoCompraImporConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PedidoCompraImpor";
	public static final String SPATHOPCION="Importaciones";	
	public static final String SPATHMODULO="importaciones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PedidoCompraImpor"+PedidoCompraImporConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PedidoCompraImporHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PedidoCompraImporHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PedidoCompraImporConstantesFunciones.SCHEMA+"_"+PedidoCompraImporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PedidoCompraImporHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PedidoCompraImporConstantesFunciones.SCHEMA+"_"+PedidoCompraImporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PedidoCompraImporConstantesFunciones.SCHEMA+"_"+PedidoCompraImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PedidoCompraImporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PedidoCompraImporConstantesFunciones.SCHEMA+"_"+PedidoCompraImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoCompraImporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PedidoCompraImporHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoCompraImporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoCompraImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PedidoCompraImporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoCompraImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PedidoCompraImporConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PedidoCompraImporConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PedidoCompraImporConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PedidoCompraImporConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Pedido Compras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Pedido Compra";
	public static final String SCLASSWEBTITULO_LOWER="Pedido Compra Impor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PedidoCompraImpor";
	public static final String OBJECTNAME="pedidocompraimpor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_IMPORTACIONES;	
	public static final String TABLENAME="pedido_compra_impor";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select pedidocompraimpor from "+PedidoCompraImporConstantesFunciones.SPERSISTENCENAME+" pedidocompraimpor";
	public static String QUERYSELECTNATIVE="select "+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".version_row,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_empresa,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_sucursal,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_modulo,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_ejercicio,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_periodo,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_pais,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_cliente,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_cliente_proveedor,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_empleado,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_usuario,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_tipo_cambio,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_moneda,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_tipo_prorrateo_impor,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_embarcador,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_tipo_via_transporte,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_puerto,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_puerto_destino,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_tipo_terminos_impor,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_estado_pedido_compra,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".forma_pago,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".numero_dui,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".secuencial,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".numero_orden,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".uso_en,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".responsable,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".orden_compra,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".lugar_entrega,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".descripcion,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".fecha,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".fecha_emision,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".fecha_entrega,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".fecha_entrega_cliente,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".nombre_seguro,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".nombre_consignatario,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".precios,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".flete,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".seguro,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".gastos,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".cfr,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".cif,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".total,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_formato,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_anio,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_mes from "+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME;//+" as "+PedidoCompraImporConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected PedidoCompraImporConstantesFuncionesAdditional pedidocompraimporConstantesFuncionesAdditional=null;
	
	public PedidoCompraImporConstantesFuncionesAdditional getPedidoCompraImporConstantesFuncionesAdditional() {
		return this.pedidocompraimporConstantesFuncionesAdditional;
	}
	
	public void setPedidoCompraImporConstantesFuncionesAdditional(PedidoCompraImporConstantesFuncionesAdditional pedidocompraimporConstantesFuncionesAdditional) {
		try {
			this.pedidocompraimporConstantesFuncionesAdditional=pedidocompraimporConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDMODULO= "id_modulo";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDPAIS= "id_pais";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDCLIENTEPROVEEDOR= "id_cliente_proveedor";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDTIPOCAMBIO= "id_tipo_cambio";
    public static final String IDMONEDA= "id_moneda";
    public static final String IDTIPOPRORRATEOIMPOR= "id_tipo_prorrateo_impor";
    public static final String IDEMBARCADOR= "id_embarcador";
    public static final String IDTIPOVIATRANSPORTE= "id_tipo_via_transporte";
    public static final String IDPUERTO= "id_puerto";
    public static final String IDPUERTODESTINO= "id_puerto_destino";
    public static final String IDTIPOTERMINOSIMPOR= "id_tipo_terminos_impor";
    public static final String IDESTADOPEDIDOCOMPRA= "id_estado_pedido_compra";
    public static final String FORMAPAGO= "forma_pago";
    public static final String NUMERODUI= "numero_dui";
    public static final String SECUENCIAL= "secuencial";
    public static final String NUMEROORDEN= "numero_orden";
    public static final String USOEN= "uso_en";
    public static final String RESPONSABLE= "responsable";
    public static final String ORDENCOMPRA= "orden_compra";
    public static final String LUGARENTREGA= "lugar_entrega";
    public static final String DESCRIPCION= "descripcion";
    public static final String FECHA= "fecha";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAENTREGA= "fecha_entrega";
    public static final String FECHAENTREGACLIENTE= "fecha_entrega_cliente";
    public static final String NOMBRESEGURO= "nombre_seguro";
    public static final String NOMBRECONSIGNATARIO= "nombre_consignatario";
    public static final String PRECIOS= "precios";
    public static final String FLETE= "flete";
    public static final String SEGURO= "seguro";
    public static final String GASTOS= "gastos";
    public static final String CFR= "cfr";
    public static final String CIF= "cif";
    public static final String TOTAL= "total";
    public static final String IDFORMATO= "id_formato";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDCLIENTEPROVEEDOR= "Cliente Proveedor";
		public static final String LABEL_IDCLIENTEPROVEEDOR_LOWER= "Cliente Proveedor";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDTIPOCAMBIO= "Tipo Cambio";
		public static final String LABEL_IDTIPOCAMBIO_LOWER= "Tipo Cambio";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_IDTIPOPRORRATEOIMPOR= "Tipo Prorrateo Impor";
		public static final String LABEL_IDTIPOPRORRATEOIMPOR_LOWER= "Tipo Prorrateo Impor";
    	public static final String LABEL_IDEMBARCADOR= "Embarcador";
		public static final String LABEL_IDEMBARCADOR_LOWER= "Embarcador";
    	public static final String LABEL_IDTIPOVIATRANSPORTE= "Tipo Via Transporte";
		public static final String LABEL_IDTIPOVIATRANSPORTE_LOWER= "Tipo Via Transporte";
    	public static final String LABEL_IDPUERTO= "Puerto";
		public static final String LABEL_IDPUERTO_LOWER= "Puerto";
    	public static final String LABEL_IDPUERTODESTINO= "Puerto Destino";
		public static final String LABEL_IDPUERTODESTINO_LOWER= "Puerto Destino";
    	public static final String LABEL_IDTIPOTERMINOSIMPOR= "Tipo Terminos Impor";
		public static final String LABEL_IDTIPOTERMINOSIMPOR_LOWER= "Tipo Terminos Impor";
    	public static final String LABEL_IDESTADOPEDIDOCOMPRA= "Estado Pedo Compra";
		public static final String LABEL_IDESTADOPEDIDOCOMPRA_LOWER= "Estado Pedido Compra";
    	public static final String LABEL_FORMAPAGO= "Forma Pago";
		public static final String LABEL_FORMAPAGO_LOWER= "Forma Pago";
    	public static final String LABEL_NUMERODUI= "Numero Dui";
		public static final String LABEL_NUMERODUI_LOWER= "Numero Dui";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_NUMEROORDEN= "Numero Orden";
		public static final String LABEL_NUMEROORDEN_LOWER= "Numero Orden";
    	public static final String LABEL_USOEN= "Uso En";
		public static final String LABEL_USOEN_LOWER= "Uso En";
    	public static final String LABEL_RESPONSABLE= "Responsable";
		public static final String LABEL_RESPONSABLE_LOWER= "Responsable";
    	public static final String LABEL_ORDENCOMPRA= "Orden Compra";
		public static final String LABEL_ORDENCOMPRA_LOWER= "Orden Compra";
    	public static final String LABEL_LUGARENTREGA= "Lugar Entrega";
		public static final String LABEL_LUGARENTREGA_LOWER= "Lugar Entrega";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAENTREGA= "Fecha Entrega";
		public static final String LABEL_FECHAENTREGA_LOWER= "Fecha Entrega";
    	public static final String LABEL_FECHAENTREGACLIENTE= "Fecha Entrega Cliente";
		public static final String LABEL_FECHAENTREGACLIENTE_LOWER= "Fecha Entrega Cliente";
    	public static final String LABEL_NOMBRESEGURO= "Nombre Seguro";
		public static final String LABEL_NOMBRESEGURO_LOWER= "Nombre Seguro";
    	public static final String LABEL_NOMBRECONSIGNATARIO= "Nombre Consignatario";
		public static final String LABEL_NOMBRECONSIGNATARIO_LOWER= "Nombre Consignatario";
    	public static final String LABEL_PRECIOS= "Precios";
		public static final String LABEL_PRECIOS_LOWER= "Precios";
    	public static final String LABEL_FLETE= "Flete";
		public static final String LABEL_FLETE_LOWER= "Flete";
    	public static final String LABEL_SEGURO= "Seguro";
		public static final String LABEL_SEGURO_LOWER= "Seguro";
    	public static final String LABEL_GASTOS= "Gastos";
		public static final String LABEL_GASTOS_LOWER= "Gastos";
    	public static final String LABEL_CFR= "Cfr";
		public static final String LABEL_CFR_LOWER= "Cfr";
    	public static final String LABEL_CIF= "Cif";
		public static final String LABEL_CIF_LOWER= "Cif";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXFORMA_PAGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXFORMA_PAGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_DUI=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_DUI=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXUSO_EN=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXUSO_EN=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRESPONSABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRESPONSABLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXORDEN_COMPRA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXORDEN_COMPRA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXLUGAR_ENTREGA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLUGAR_ENTREGA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXNOMBRE_SEGURO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_SEGURO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CONSIGNATARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CONSIGNATARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXPRECIOS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPRECIOS=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
	
	public static String getPedidoCompraImporLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.IDEMPRESA)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.IDMODULO)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.IDEJERCICIO)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.IDPERIODO)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.IDPAIS)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.IDCLIENTE)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.IDCLIENTEPROVEEDOR)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_IDCLIENTEPROVEEDOR;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.IDEMPLEADO)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.IDUSUARIO)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.IDTIPOCAMBIO)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_IDTIPOCAMBIO;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.IDMONEDA)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.IDTIPOPRORRATEOIMPOR)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_IDTIPOPRORRATEOIMPOR;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.IDEMBARCADOR)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_IDEMBARCADOR;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.IDTIPOVIATRANSPORTE)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.IDPUERTO)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_IDPUERTO;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.IDPUERTODESTINO)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_IDPUERTODESTINO;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.IDTIPOTERMINOSIMPOR)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_IDTIPOTERMINOSIMPOR;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.IDESTADOPEDIDOCOMPRA)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_IDESTADOPEDIDOCOMPRA;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.FORMAPAGO)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_FORMAPAGO;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.NUMERODUI)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_NUMERODUI;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.SECUENCIAL)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.NUMEROORDEN)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_NUMEROORDEN;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.USOEN)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_USOEN;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.RESPONSABLE)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_RESPONSABLE;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.ORDENCOMPRA)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_ORDENCOMPRA;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.LUGARENTREGA)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_LUGARENTREGA;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.DESCRIPCION)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.FECHA)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.FECHAEMISION)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.FECHAENTREGA)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_FECHAENTREGA;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.FECHAENTREGACLIENTE)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_FECHAENTREGACLIENTE;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.NOMBRESEGURO)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_NOMBRESEGURO;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.NOMBRECONSIGNATARIO)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_NOMBRECONSIGNATARIO;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.PRECIOS)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_PRECIOS;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.FLETE)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.SEGURO)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_SEGURO;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.GASTOS)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_GASTOS;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.CFR)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_CFR;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.CIF)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_CIF;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.TOTAL)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.IDFORMATO)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.IDANIO)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(PedidoCompraImporConstantesFunciones.IDMES)) {sLabelColumna=PedidoCompraImporConstantesFunciones.LABEL_IDMES;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPedidoCompraImporDescripcion(PedidoCompraImpor pedidocompraimpor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(pedidocompraimpor !=null/* && pedidocompraimpor.getId()!=0*/) {
			if(pedidocompraimpor.getId()!=null) {
				sDescripcion=pedidocompraimpor.getId().toString();
			}//pedidocompraimporpedidocompraimpor.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPedidoCompraImporDescripcionDetallado(PedidoCompraImpor pedidocompraimpor) {
		String sDescripcion="";
			
		sDescripcion+=PedidoCompraImporConstantesFunciones.ID+"=";
		sDescripcion+=pedidocompraimpor.getId().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=pedidocompraimpor.getVersionRow().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=pedidocompraimpor.getid_empresa().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=pedidocompraimpor.getid_sucursal().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.IDMODULO+"=";
		sDescripcion+=pedidocompraimpor.getid_modulo().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=pedidocompraimpor.getid_ejercicio().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=pedidocompraimpor.getid_periodo().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.IDPAIS+"=";
		sDescripcion+=pedidocompraimpor.getid_pais().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=pedidocompraimpor.getid_cliente().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.IDCLIENTEPROVEEDOR+"=";
		sDescripcion+=pedidocompraimpor.getid_cliente_proveedor().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=pedidocompraimpor.getid_empleado().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=pedidocompraimpor.getid_usuario().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.IDTIPOCAMBIO+"=";
		sDescripcion+=pedidocompraimpor.getid_tipo_cambio().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=pedidocompraimpor.getid_moneda().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.IDTIPOPRORRATEOIMPOR+"=";
		sDescripcion+=pedidocompraimpor.getid_tipo_prorrateo_impor().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.IDEMBARCADOR+"=";
		sDescripcion+=pedidocompraimpor.getid_embarcador().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.IDTIPOVIATRANSPORTE+"=";
		sDescripcion+=pedidocompraimpor.getid_tipo_via_transporte().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.IDPUERTO+"=";
		sDescripcion+=pedidocompraimpor.getid_puerto().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.IDPUERTODESTINO+"=";
		sDescripcion+=pedidocompraimpor.getid_puerto_destino().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.IDTIPOTERMINOSIMPOR+"=";
		sDescripcion+=pedidocompraimpor.getid_tipo_terminos_impor().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.IDESTADOPEDIDOCOMPRA+"=";
		sDescripcion+=pedidocompraimpor.getid_estado_pedido_compra().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.FORMAPAGO+"=";
		sDescripcion+=pedidocompraimpor.getforma_pago()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.NUMERODUI+"=";
		sDescripcion+=pedidocompraimpor.getnumero_dui()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=pedidocompraimpor.getsecuencial()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.NUMEROORDEN+"=";
		sDescripcion+=pedidocompraimpor.getnumero_orden().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.USOEN+"=";
		sDescripcion+=pedidocompraimpor.getuso_en()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.RESPONSABLE+"=";
		sDescripcion+=pedidocompraimpor.getresponsable()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.ORDENCOMPRA+"=";
		sDescripcion+=pedidocompraimpor.getorden_compra()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.LUGARENTREGA+"=";
		sDescripcion+=pedidocompraimpor.getlugar_entrega()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=pedidocompraimpor.getdescripcion()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.FECHA+"=";
		sDescripcion+=pedidocompraimpor.getfecha().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=pedidocompraimpor.getfecha_emision().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.FECHAENTREGA+"=";
		sDescripcion+=pedidocompraimpor.getfecha_entrega().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.FECHAENTREGACLIENTE+"=";
		sDescripcion+=pedidocompraimpor.getfecha_entrega_cliente().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.NOMBRESEGURO+"=";
		sDescripcion+=pedidocompraimpor.getnombre_seguro()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.NOMBRECONSIGNATARIO+"=";
		sDescripcion+=pedidocompraimpor.getnombre_consignatario()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.PRECIOS+"=";
		sDescripcion+=pedidocompraimpor.getprecios()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.FLETE+"=";
		sDescripcion+=pedidocompraimpor.getflete().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.SEGURO+"=";
		sDescripcion+=pedidocompraimpor.getseguro().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.GASTOS+"=";
		sDescripcion+=pedidocompraimpor.getgastos().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.CFR+"=";
		sDescripcion+=pedidocompraimpor.getcfr().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.CIF+"=";
		sDescripcion+=pedidocompraimpor.getcif().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.TOTAL+"=";
		sDescripcion+=pedidocompraimpor.gettotal().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=pedidocompraimpor.getid_formato().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.IDANIO+"=";
		sDescripcion+=pedidocompraimpor.getid_anio().toString()+",";
		sDescripcion+=PedidoCompraImporConstantesFunciones.IDMES+"=";
		sDescripcion+=pedidocompraimpor.getid_mes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPedidoCompraImporDescripcion(PedidoCompraImpor pedidocompraimpor,String sValor) throws Exception {			
		if(pedidocompraimpor !=null) {
			//pedidocompraimporpedidocompraimpor.getId().toString();
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

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
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

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
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

	public static String getClienteProveedorDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
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

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
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

	public static String getMonedaDescripcion(Moneda moneda) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(moneda!=null/*&&moneda.getId()>0*/) {
			sDescripcion=MonedaConstantesFunciones.getMonedaDescripcion(moneda);
		}

		return sDescripcion;
	}

	public static String getTipoProrrateoImporDescripcion(TipoProrrateoImpor tipoprorrateoimpor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoprorrateoimpor!=null/*&&tipoprorrateoimpor.getId()>0*/) {
			sDescripcion=TipoProrrateoImporConstantesFunciones.getTipoProrrateoImporDescripcion(tipoprorrateoimpor);
		}

		return sDescripcion;
	}

	public static String getEmbarcadorDescripcion(Embarcador embarcador) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(embarcador!=null/*&&embarcador.getId()>0*/) {
			sDescripcion=EmbarcadorConstantesFunciones.getEmbarcadorDescripcion(embarcador);
		}

		return sDescripcion;
	}

	public static String getTipoViaTransporteDescripcion(TipoViaTransporte tipoviatransporte) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoviatransporte!=null/*&&tipoviatransporte.getId()>0*/) {
			sDescripcion=TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcion(tipoviatransporte);
		}

		return sDescripcion;
	}

	public static String getPuertoDescripcion(Puerto puerto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(puerto!=null/*&&puerto.getId()>0*/) {
			sDescripcion=PuertoConstantesFunciones.getPuertoDescripcion(puerto);
		}

		return sDescripcion;
	}

	public static String getPuertoDestinoDescripcion(Puerto puerto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(puerto!=null/*&&puerto.getId()>0*/) {
			sDescripcion=PuertoConstantesFunciones.getPuertoDescripcion(puerto);
		}

		return sDescripcion;
	}

	public static String getTipoTerminosImporDescripcion(TipoTerminosImpor tipoterminosimpor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoterminosimpor!=null/*&&tipoterminosimpor.getId()>0*/) {
			sDescripcion=TipoTerminosImporConstantesFunciones.getTipoTerminosImporDescripcion(tipoterminosimpor);
		}

		return sDescripcion;
	}

	public static String getEstadoPedidoCompraDescripcion(EstadoPedidoCompra estadopedidocompra) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadopedidocompra!=null/*&&estadopedidocompra.getId()>0*/) {
			sDescripcion=EstadoPedidoCompraConstantesFunciones.getEstadoPedidoCompraDescripcion(estadopedidocompra);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdClienteProveedor")) {
			sNombreIndice="Tipo=  Por Cliente Proveedor";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmbarcador")) {
			sNombreIndice="Tipo=  Por Embarcador";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoPedidoCompraEstadoPedoCompra")) {
			sNombreIndice="Tipo=  Por Estado Pedo Compra";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdPuerto")) {
			sNombreIndice="Tipo=  Por Puerto";
		} else if(sNombreIndice.equals("FK_IdPuertoDestino")) {
			sNombreIndice="Tipo=  Por Puerto Destino";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCambio")) {
			sNombreIndice="Tipo=  Por Tipo Cambio";
		} else if(sNombreIndice.equals("FK_IdTipoProrrateoImpor")) {
			sNombreIndice="Tipo=  Por Tipo Prorrateo Impor";
		} else if(sNombreIndice.equals("FK_IdTipoTerminosImpor")) {
			sNombreIndice="Tipo=  Por Tipo Terminos Impor";
		} else if(sNombreIndice.equals("FK_IdTipoViaTransporte")) {
			sNombreIndice="Tipo=  Por Tipo Via Transporte";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
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

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdClienteProveedor(Long id_cliente_proveedor) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente_proveedor!=null) {sDetalleIndice+=" Codigo Unico De Cliente Proveedor="+id_cliente_proveedor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmbarcador(Long id_embarcador) {
		String sDetalleIndice=" Parametros->";
		if(id_embarcador!=null) {sDetalleIndice+=" Codigo Unico De Embarcador="+id_embarcador.toString();} 

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

	public static String getDetalleIndiceFK_IdEstadoPedidoCompraEstadoPedoCompra(Long id_estado_pedido_compra) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_pedido_compra!=null) {sDetalleIndice+=" Codigo Unico De Estado Pedo Compra="+id_estado_pedido_compra.toString();} 

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

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMoneda(Long id_moneda) {
		String sDetalleIndice=" Parametros->";
		if(id_moneda!=null) {sDetalleIndice+=" Codigo Unico De Moneda="+id_moneda.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPuerto(Long id_puerto) {
		String sDetalleIndice=" Parametros->";
		if(id_puerto!=null) {sDetalleIndice+=" Codigo Unico De Puerto="+id_puerto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPuertoDestino(Long id_puerto_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_puerto_destino!=null) {sDetalleIndice+=" Codigo Unico De Puerto Destino="+id_puerto_destino.toString();} 

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

	public static String getDetalleIndiceFK_IdTipoProrrateoImpor(Long id_tipo_prorrateo_impor) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_prorrateo_impor!=null) {sDetalleIndice+=" Codigo Unico De Tipo Prorrateo Impor="+id_tipo_prorrateo_impor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTerminosImpor(Long id_tipo_terminos_impor) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_terminos_impor!=null) {sDetalleIndice+=" Codigo Unico De Tipo Terminos Impor="+id_tipo_terminos_impor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoViaTransporte(Long id_tipo_via_transporte) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_via_transporte!=null) {sDetalleIndice+=" Codigo Unico De Tipo Via Transporte="+id_tipo_via_transporte.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPedidoCompraImpor(PedidoCompraImpor pedidocompraimpor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pedidocompraimpor.setforma_pago(pedidocompraimpor.getforma_pago().trim());
		pedidocompraimpor.setnumero_dui(pedidocompraimpor.getnumero_dui().trim());
		pedidocompraimpor.setsecuencial(pedidocompraimpor.getsecuencial().trim());
		pedidocompraimpor.setuso_en(pedidocompraimpor.getuso_en().trim());
		pedidocompraimpor.setresponsable(pedidocompraimpor.getresponsable().trim());
		pedidocompraimpor.setorden_compra(pedidocompraimpor.getorden_compra().trim());
		pedidocompraimpor.setlugar_entrega(pedidocompraimpor.getlugar_entrega().trim());
		pedidocompraimpor.setdescripcion(pedidocompraimpor.getdescripcion().trim());
		pedidocompraimpor.setnombre_seguro(pedidocompraimpor.getnombre_seguro().trim());
		pedidocompraimpor.setnombre_consignatario(pedidocompraimpor.getnombre_consignatario().trim());
		pedidocompraimpor.setprecios(pedidocompraimpor.getprecios().trim());
	}
	
	public static void quitarEspaciosPedidoCompraImpors(List<PedidoCompraImpor> pedidocompraimpors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PedidoCompraImpor pedidocompraimpor: pedidocompraimpors) {
			pedidocompraimpor.setforma_pago(pedidocompraimpor.getforma_pago().trim());
			pedidocompraimpor.setnumero_dui(pedidocompraimpor.getnumero_dui().trim());
			pedidocompraimpor.setsecuencial(pedidocompraimpor.getsecuencial().trim());
			pedidocompraimpor.setuso_en(pedidocompraimpor.getuso_en().trim());
			pedidocompraimpor.setresponsable(pedidocompraimpor.getresponsable().trim());
			pedidocompraimpor.setorden_compra(pedidocompraimpor.getorden_compra().trim());
			pedidocompraimpor.setlugar_entrega(pedidocompraimpor.getlugar_entrega().trim());
			pedidocompraimpor.setdescripcion(pedidocompraimpor.getdescripcion().trim());
			pedidocompraimpor.setnombre_seguro(pedidocompraimpor.getnombre_seguro().trim());
			pedidocompraimpor.setnombre_consignatario(pedidocompraimpor.getnombre_consignatario().trim());
			pedidocompraimpor.setprecios(pedidocompraimpor.getprecios().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPedidoCompraImpor(PedidoCompraImpor pedidocompraimpor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && pedidocompraimpor.getConCambioAuxiliar()) {
			pedidocompraimpor.setIsDeleted(pedidocompraimpor.getIsDeletedAuxiliar());	
			pedidocompraimpor.setIsNew(pedidocompraimpor.getIsNewAuxiliar());	
			pedidocompraimpor.setIsChanged(pedidocompraimpor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			pedidocompraimpor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			pedidocompraimpor.setIsDeletedAuxiliar(false);	
			pedidocompraimpor.setIsNewAuxiliar(false);	
			pedidocompraimpor.setIsChangedAuxiliar(false);
			
			pedidocompraimpor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPedidoCompraImpors(List<PedidoCompraImpor> pedidocompraimpors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PedidoCompraImpor pedidocompraimpor : pedidocompraimpors) {
			if(conAsignarBase && pedidocompraimpor.getConCambioAuxiliar()) {
				pedidocompraimpor.setIsDeleted(pedidocompraimpor.getIsDeletedAuxiliar());	
				pedidocompraimpor.setIsNew(pedidocompraimpor.getIsNewAuxiliar());	
				pedidocompraimpor.setIsChanged(pedidocompraimpor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				pedidocompraimpor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				pedidocompraimpor.setIsDeletedAuxiliar(false);	
				pedidocompraimpor.setIsNewAuxiliar(false);	
				pedidocompraimpor.setIsChangedAuxiliar(false);
				
				pedidocompraimpor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPedidoCompraImpor(PedidoCompraImpor pedidocompraimpor,Boolean conEnteros) throws Exception  {
		pedidocompraimpor.setflete(0.0);
		pedidocompraimpor.setseguro(0.0);
		pedidocompraimpor.setgastos(0.0);
		pedidocompraimpor.setcfr(0.0);
		pedidocompraimpor.setcif(0.0);
		pedidocompraimpor.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			pedidocompraimpor.setnumero_orden(0);
		}
	}		
	
	public static void InicializarValoresPedidoCompraImpors(List<PedidoCompraImpor> pedidocompraimpors,Boolean conEnteros) throws Exception  {
		
		for(PedidoCompraImpor pedidocompraimpor: pedidocompraimpors) {
			pedidocompraimpor.setflete(0.0);
			pedidocompraimpor.setseguro(0.0);
			pedidocompraimpor.setgastos(0.0);
			pedidocompraimpor.setcfr(0.0);
			pedidocompraimpor.setcif(0.0);
			pedidocompraimpor.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				pedidocompraimpor.setnumero_orden(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaPedidoCompraImpor(List<PedidoCompraImpor> pedidocompraimpors,PedidoCompraImpor pedidocompraimporAux) throws Exception  {
		PedidoCompraImporConstantesFunciones.InicializarValoresPedidoCompraImpor(pedidocompraimporAux,true);
		
		for(PedidoCompraImpor pedidocompraimpor: pedidocompraimpors) {
			if(pedidocompraimpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			pedidocompraimporAux.setnumero_orden(pedidocompraimporAux.getnumero_orden()+pedidocompraimpor.getnumero_orden());			
			pedidocompraimporAux.setflete(pedidocompraimporAux.getflete()+pedidocompraimpor.getflete());			
			pedidocompraimporAux.setseguro(pedidocompraimporAux.getseguro()+pedidocompraimpor.getseguro());			
			pedidocompraimporAux.setgastos(pedidocompraimporAux.getgastos()+pedidocompraimpor.getgastos());			
			pedidocompraimporAux.setcfr(pedidocompraimporAux.getcfr()+pedidocompraimpor.getcfr());			
			pedidocompraimporAux.setcif(pedidocompraimporAux.getcif()+pedidocompraimpor.getcif());			
			pedidocompraimporAux.settotal(pedidocompraimporAux.gettotal()+pedidocompraimpor.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPedidoCompraImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PedidoCompraImporConstantesFunciones.getArrayColumnasGlobalesPedidoCompraImpor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPedidoCompraImpor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoCompraImporConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoCompraImporConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoCompraImporConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoCompraImporConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoCompraImporConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoCompraImporConstantesFunciones.IDMODULO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoCompraImporConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoCompraImporConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoCompraImporConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoCompraImporConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoCompraImporConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoCompraImporConstantesFunciones.IDUSUARIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoCompraImporConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoCompraImporConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPedidoCompraImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PedidoCompraImpor> pedidocompraimpors,PedidoCompraImpor pedidocompraimpor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PedidoCompraImpor pedidocompraimporAux: pedidocompraimpors) {
			if(pedidocompraimporAux!=null && pedidocompraimpor!=null) {
				if((pedidocompraimporAux.getId()==null && pedidocompraimpor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(pedidocompraimporAux.getId()!=null && pedidocompraimpor.getId()!=null){
					if(pedidocompraimporAux.getId().equals(pedidocompraimpor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPedidoCompraImpor(List<PedidoCompraImpor> pedidocompraimpors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double fleteTotal=0.0;
		Double seguroTotal=0.0;
		Double gastosTotal=0.0;
		Double cfrTotal=0.0;
		Double cifTotal=0.0;
		Double totalTotal=0.0;
	
		for(PedidoCompraImpor pedidocompraimpor: pedidocompraimpors) {			
			if(pedidocompraimpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			fleteTotal+=pedidocompraimpor.getflete();
			seguroTotal+=pedidocompraimpor.getseguro();
			gastosTotal+=pedidocompraimpor.getgastos();
			cfrTotal+=pedidocompraimpor.getcfr();
			cifTotal+=pedidocompraimpor.getcif();
			totalTotal+=pedidocompraimpor.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoCompraImporConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoCompraImporConstantesFunciones.SEGURO);
		datoGeneral.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_SEGURO);
		datoGeneral.setdValorDouble(seguroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoCompraImporConstantesFunciones.GASTOS);
		datoGeneral.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_GASTOS);
		datoGeneral.setdValorDouble(gastosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoCompraImporConstantesFunciones.CFR);
		datoGeneral.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_CFR);
		datoGeneral.setdValorDouble(cfrTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoCompraImporConstantesFunciones.CIF);
		datoGeneral.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_CIF);
		datoGeneral.setdValorDouble(cifTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoCompraImporConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPedidoCompraImpor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_ID, PedidoCompraImporConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_VERSIONROW, PedidoCompraImporConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_IDEMPRESA, PedidoCompraImporConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_IDSUCURSAL, PedidoCompraImporConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_IDMODULO, PedidoCompraImporConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_IDEJERCICIO, PedidoCompraImporConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_IDPERIODO, PedidoCompraImporConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_IDPAIS, PedidoCompraImporConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_IDCLIENTE, PedidoCompraImporConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_IDCLIENTEPROVEEDOR, PedidoCompraImporConstantesFunciones.IDCLIENTEPROVEEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_IDEMPLEADO, PedidoCompraImporConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_IDUSUARIO, PedidoCompraImporConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_IDTIPOCAMBIO, PedidoCompraImporConstantesFunciones.IDTIPOCAMBIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_IDMONEDA, PedidoCompraImporConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_IDTIPOPRORRATEOIMPOR, PedidoCompraImporConstantesFunciones.IDTIPOPRORRATEOIMPOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_IDEMBARCADOR, PedidoCompraImporConstantesFunciones.IDEMBARCADOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE, PedidoCompraImporConstantesFunciones.IDTIPOVIATRANSPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_IDPUERTO, PedidoCompraImporConstantesFunciones.IDPUERTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_IDPUERTODESTINO, PedidoCompraImporConstantesFunciones.IDPUERTODESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_IDTIPOTERMINOSIMPOR, PedidoCompraImporConstantesFunciones.IDTIPOTERMINOSIMPOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_IDESTADOPEDIDOCOMPRA, PedidoCompraImporConstantesFunciones.IDESTADOPEDIDOCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_FORMAPAGO, PedidoCompraImporConstantesFunciones.FORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_NUMERODUI, PedidoCompraImporConstantesFunciones.NUMERODUI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_SECUENCIAL, PedidoCompraImporConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_NUMEROORDEN, PedidoCompraImporConstantesFunciones.NUMEROORDEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_USOEN, PedidoCompraImporConstantesFunciones.USOEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_RESPONSABLE, PedidoCompraImporConstantesFunciones.RESPONSABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_ORDENCOMPRA, PedidoCompraImporConstantesFunciones.ORDENCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_LUGARENTREGA, PedidoCompraImporConstantesFunciones.LUGARENTREGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_DESCRIPCION, PedidoCompraImporConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_FECHA, PedidoCompraImporConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_FECHAEMISION, PedidoCompraImporConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_FECHAENTREGA, PedidoCompraImporConstantesFunciones.FECHAENTREGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_FECHAENTREGACLIENTE, PedidoCompraImporConstantesFunciones.FECHAENTREGACLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_NOMBRESEGURO, PedidoCompraImporConstantesFunciones.NOMBRESEGURO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_NOMBRECONSIGNATARIO, PedidoCompraImporConstantesFunciones.NOMBRECONSIGNATARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_PRECIOS, PedidoCompraImporConstantesFunciones.PRECIOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_FLETE, PedidoCompraImporConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_SEGURO, PedidoCompraImporConstantesFunciones.SEGURO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_GASTOS, PedidoCompraImporConstantesFunciones.GASTOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_CFR, PedidoCompraImporConstantesFunciones.CFR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_CIF, PedidoCompraImporConstantesFunciones.CIF,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_TOTAL, PedidoCompraImporConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_IDFORMATO, PedidoCompraImporConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_IDANIO, PedidoCompraImporConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraImporConstantesFunciones.LABEL_IDMES, PedidoCompraImporConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPedidoCompraImpor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.IDCLIENTEPROVEEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.IDTIPOCAMBIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.IDTIPOPRORRATEOIMPOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.IDEMBARCADOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.IDTIPOVIATRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.IDPUERTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.IDPUERTODESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.IDTIPOTERMINOSIMPOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.IDESTADOPEDIDOCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.FORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.NUMERODUI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.NUMEROORDEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.USOEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.RESPONSABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.ORDENCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.LUGARENTREGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.FECHAENTREGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.FECHAENTREGACLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.NOMBRESEGURO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.NOMBRECONSIGNATARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.PRECIOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.SEGURO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.GASTOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.CFR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.CIF;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraImporConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidoCompraImpor() throws Exception  {
		return PedidoCompraImporConstantesFunciones.getTiposSeleccionarPedidoCompraImpor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidoCompraImpor(Boolean conFk) throws Exception  {
		return PedidoCompraImporConstantesFunciones.getTiposSeleccionarPedidoCompraImpor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidoCompraImpor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_IDCLIENTEPROVEEDOR);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_IDCLIENTEPROVEEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_IDTIPOCAMBIO);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_IDTIPOCAMBIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_IDTIPOPRORRATEOIMPOR);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_IDTIPOPRORRATEOIMPOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_IDEMBARCADOR);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_IDEMBARCADOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_IDPUERTO);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_IDPUERTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_IDPUERTODESTINO);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_IDPUERTODESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_IDTIPOTERMINOSIMPOR);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_IDTIPOTERMINOSIMPOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_IDESTADOPEDIDOCOMPRA);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_IDESTADOPEDIDOCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_FORMAPAGO);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_FORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_NUMERODUI);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_NUMERODUI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_NUMEROORDEN);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_NUMEROORDEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_USOEN);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_USOEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_RESPONSABLE);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_RESPONSABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_ORDENCOMPRA);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_ORDENCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_LUGARENTREGA);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_LUGARENTREGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_FECHAENTREGA);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_FECHAENTREGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_FECHAENTREGACLIENTE);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_FECHAENTREGACLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_NOMBRESEGURO);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_NOMBRESEGURO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_NOMBRECONSIGNATARIO);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_NOMBRECONSIGNATARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_PRECIOS);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_PRECIOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_SEGURO);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_SEGURO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_GASTOS);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_GASTOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_CFR);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_CFR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_CIF);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_CIF);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraImporConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPedidoCompraImpor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPedidoCompraImpor(PedidoCompraImpor pedidocompraimporAux) throws Exception {
		
			pedidocompraimporAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pedidocompraimporAux.getEmpresa()));
			pedidocompraimporAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(pedidocompraimporAux.getSucursal()));
			pedidocompraimporAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(pedidocompraimporAux.getModulo()));
			pedidocompraimporAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(pedidocompraimporAux.getEjercicio()));
			pedidocompraimporAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(pedidocompraimporAux.getPeriodo()));
			pedidocompraimporAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(pedidocompraimporAux.getPais()));
			pedidocompraimporAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(pedidocompraimporAux.getCliente()));
			pedidocompraimporAux.setclienteproveedor_descripcion(ClienteConstantesFunciones.getClienteDescripcion(pedidocompraimporAux.getClienteProveedor()));
			pedidocompraimporAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(pedidocompraimporAux.getEmpleado()));
			pedidocompraimporAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(pedidocompraimporAux.getUsuario()));
			pedidocompraimporAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(pedidocompraimporAux.getTipoCambio()));
			pedidocompraimporAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(pedidocompraimporAux.getMoneda()));
			pedidocompraimporAux.settipoprorrateoimpor_descripcion(TipoProrrateoImporConstantesFunciones.getTipoProrrateoImporDescripcion(pedidocompraimporAux.getTipoProrrateoImpor()));
			pedidocompraimporAux.setembarcador_descripcion(EmbarcadorConstantesFunciones.getEmbarcadorDescripcion(pedidocompraimporAux.getEmbarcador()));
			pedidocompraimporAux.settipoviatransporte_descripcion(TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcion(pedidocompraimporAux.getTipoViaTransporte()));
			pedidocompraimporAux.setpuerto_descripcion(PuertoConstantesFunciones.getPuertoDescripcion(pedidocompraimporAux.getPuerto()));
			pedidocompraimporAux.setpuertodestino_descripcion(PuertoConstantesFunciones.getPuertoDescripcion(pedidocompraimporAux.getPuertoDestino()));
			pedidocompraimporAux.settipoterminosimpor_descripcion(TipoTerminosImporConstantesFunciones.getTipoTerminosImporDescripcion(pedidocompraimporAux.getTipoTerminosImpor()));
			pedidocompraimporAux.setestadopedidocompra_descripcion(EstadoPedidoCompraConstantesFunciones.getEstadoPedidoCompraDescripcion(pedidocompraimporAux.getEstadoPedidoCompra()));
			pedidocompraimporAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(pedidocompraimporAux.getFormato()));
			pedidocompraimporAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(pedidocompraimporAux.getAnio()));
			pedidocompraimporAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(pedidocompraimporAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPedidoCompraImpor(List<PedidoCompraImpor> pedidocompraimporsTemp) throws Exception {
		for(PedidoCompraImpor pedidocompraimporAux:pedidocompraimporsTemp) {
			
			pedidocompraimporAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pedidocompraimporAux.getEmpresa()));
			pedidocompraimporAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(pedidocompraimporAux.getSucursal()));
			pedidocompraimporAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(pedidocompraimporAux.getModulo()));
			pedidocompraimporAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(pedidocompraimporAux.getEjercicio()));
			pedidocompraimporAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(pedidocompraimporAux.getPeriodo()));
			pedidocompraimporAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(pedidocompraimporAux.getPais()));
			pedidocompraimporAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(pedidocompraimporAux.getCliente()));
			pedidocompraimporAux.setclienteproveedor_descripcion(ClienteConstantesFunciones.getClienteDescripcion(pedidocompraimporAux.getClienteProveedor()));
			pedidocompraimporAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(pedidocompraimporAux.getEmpleado()));
			pedidocompraimporAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(pedidocompraimporAux.getUsuario()));
			pedidocompraimporAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(pedidocompraimporAux.getTipoCambio()));
			pedidocompraimporAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(pedidocompraimporAux.getMoneda()));
			pedidocompraimporAux.settipoprorrateoimpor_descripcion(TipoProrrateoImporConstantesFunciones.getTipoProrrateoImporDescripcion(pedidocompraimporAux.getTipoProrrateoImpor()));
			pedidocompraimporAux.setembarcador_descripcion(EmbarcadorConstantesFunciones.getEmbarcadorDescripcion(pedidocompraimporAux.getEmbarcador()));
			pedidocompraimporAux.settipoviatransporte_descripcion(TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcion(pedidocompraimporAux.getTipoViaTransporte()));
			pedidocompraimporAux.setpuerto_descripcion(PuertoConstantesFunciones.getPuertoDescripcion(pedidocompraimporAux.getPuerto()));
			pedidocompraimporAux.setpuertodestino_descripcion(PuertoConstantesFunciones.getPuertoDescripcion(pedidocompraimporAux.getPuertoDestino()));
			pedidocompraimporAux.settipoterminosimpor_descripcion(TipoTerminosImporConstantesFunciones.getTipoTerminosImporDescripcion(pedidocompraimporAux.getTipoTerminosImpor()));
			pedidocompraimporAux.setestadopedidocompra_descripcion(EstadoPedidoCompraConstantesFunciones.getEstadoPedidoCompraDescripcion(pedidocompraimporAux.getEstadoPedidoCompra()));
			pedidocompraimporAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(pedidocompraimporAux.getFormato()));
			pedidocompraimporAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(pedidocompraimporAux.getAnio()));
			pedidocompraimporAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(pedidocompraimporAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPedidoCompraImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(TipoCambio.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(TipoProrrateoImpor.class));
				classes.add(new Classe(Embarcador.class));
				classes.add(new Classe(TipoViaTransporte.class));
				classes.add(new Classe(Puerto.class));
				classes.add(new Classe(Puerto.class));
				classes.add(new Classe(TipoTerminosImpor.class));
				classes.add(new Classe(EstadoPedidoCompra.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
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
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
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
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
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
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCambio.class)) {
						classes.add(new Classe(TipoCambio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoProrrateoImpor.class)) {
						classes.add(new Classe(TipoProrrateoImpor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Embarcador.class)) {
						classes.add(new Classe(Embarcador.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoViaTransporte.class)) {
						classes.add(new Classe(TipoViaTransporte.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Puerto.class)) {
						classes.add(new Classe(Puerto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Puerto.class)) {
						classes.add(new Classe(Puerto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTerminosImpor.class)) {
						classes.add(new Classe(TipoTerminosImpor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoPedidoCompra.class)) {
						classes.add(new Classe(EstadoPedidoCompra.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPedidoCompraImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(TipoProrrateoImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProrrateoImpor.class)); continue;
					}

					if(Embarcador.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Embarcador.class)); continue;
					}

					if(TipoViaTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoViaTransporte.class)); continue;
					}

					if(Puerto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Puerto.class)); continue;
					}

					if(Puerto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Puerto.class)); continue;
					}

					if(TipoTerminosImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTerminosImpor.class)); continue;
					}

					if(EstadoPedidoCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedidoCompra.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(TipoProrrateoImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProrrateoImpor.class)); continue;
					}

					if(Embarcador.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Embarcador.class)); continue;
					}

					if(TipoViaTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoViaTransporte.class)); continue;
					}

					if(Puerto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Puerto.class)); continue;
					}

					if(Puerto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Puerto.class)); continue;
					}

					if(TipoTerminosImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTerminosImpor.class)); continue;
					}

					if(EstadoPedidoCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedidoCompra.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedidoCompraImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PedidoCompraImporConstantesFunciones.getClassesRelationshipsOfPedidoCompraImpor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedidoCompraImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetallePedidoCompraImpor.class));
				classes.add(new Classe(LiquidacionImpuestoImpor.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetallePedidoCompraImpor.class)) {
						classes.add(new Classe(DetallePedidoCompraImpor.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(LiquidacionImpuestoImpor.class)) {
						classes.add(new Classe(LiquidacionImpuestoImpor.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPedidoCompraImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PedidoCompraImporConstantesFunciones.getClassesRelationshipsFromStringsOfPedidoCompraImpor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPedidoCompraImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetallePedidoCompraImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetallePedidoCompraImpor.class)); continue;
					}

					if(LiquidacionImpuestoImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(LiquidacionImpuestoImpor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetallePedidoCompraImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetallePedidoCompraImpor.class)); continue;
					}

					if(LiquidacionImpuestoImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(LiquidacionImpuestoImpor.class)); continue;
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
	public static void actualizarLista(PedidoCompraImpor pedidocompraimpor,List<PedidoCompraImpor> pedidocompraimpors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PedidoCompraImpor pedidocompraimporEncontrado=null;
			
			for(PedidoCompraImpor pedidocompraimporLocal:pedidocompraimpors) {
				if(pedidocompraimporLocal.getId().equals(pedidocompraimpor.getId())) {
					pedidocompraimporEncontrado=pedidocompraimporLocal;
					
					pedidocompraimporLocal.setIsChanged(pedidocompraimpor.getIsChanged());
					pedidocompraimporLocal.setIsNew(pedidocompraimpor.getIsNew());
					pedidocompraimporLocal.setIsDeleted(pedidocompraimpor.getIsDeleted());
					
					pedidocompraimporLocal.setGeneralEntityOriginal(pedidocompraimpor.getGeneralEntityOriginal());
					
					pedidocompraimporLocal.setId(pedidocompraimpor.getId());	
					pedidocompraimporLocal.setVersionRow(pedidocompraimpor.getVersionRow());	
					pedidocompraimporLocal.setid_empresa(pedidocompraimpor.getid_empresa());	
					pedidocompraimporLocal.setid_sucursal(pedidocompraimpor.getid_sucursal());	
					pedidocompraimporLocal.setid_modulo(pedidocompraimpor.getid_modulo());	
					pedidocompraimporLocal.setid_ejercicio(pedidocompraimpor.getid_ejercicio());	
					pedidocompraimporLocal.setid_periodo(pedidocompraimpor.getid_periodo());	
					pedidocompraimporLocal.setid_pais(pedidocompraimpor.getid_pais());	
					pedidocompraimporLocal.setid_cliente(pedidocompraimpor.getid_cliente());	
					pedidocompraimporLocal.setid_cliente_proveedor(pedidocompraimpor.getid_cliente_proveedor());	
					pedidocompraimporLocal.setid_empleado(pedidocompraimpor.getid_empleado());	
					pedidocompraimporLocal.setid_usuario(pedidocompraimpor.getid_usuario());	
					pedidocompraimporLocal.setid_tipo_cambio(pedidocompraimpor.getid_tipo_cambio());	
					pedidocompraimporLocal.setid_moneda(pedidocompraimpor.getid_moneda());	
					pedidocompraimporLocal.setid_tipo_prorrateo_impor(pedidocompraimpor.getid_tipo_prorrateo_impor());	
					pedidocompraimporLocal.setid_embarcador(pedidocompraimpor.getid_embarcador());	
					pedidocompraimporLocal.setid_tipo_via_transporte(pedidocompraimpor.getid_tipo_via_transporte());	
					pedidocompraimporLocal.setid_puerto(pedidocompraimpor.getid_puerto());	
					pedidocompraimporLocal.setid_puerto_destino(pedidocompraimpor.getid_puerto_destino());	
					pedidocompraimporLocal.setid_tipo_terminos_impor(pedidocompraimpor.getid_tipo_terminos_impor());	
					pedidocompraimporLocal.setid_estado_pedido_compra(pedidocompraimpor.getid_estado_pedido_compra());	
					pedidocompraimporLocal.setforma_pago(pedidocompraimpor.getforma_pago());	
					pedidocompraimporLocal.setnumero_dui(pedidocompraimpor.getnumero_dui());	
					pedidocompraimporLocal.setsecuencial(pedidocompraimpor.getsecuencial());	
					pedidocompraimporLocal.setnumero_orden(pedidocompraimpor.getnumero_orden());	
					pedidocompraimporLocal.setuso_en(pedidocompraimpor.getuso_en());	
					pedidocompraimporLocal.setresponsable(pedidocompraimpor.getresponsable());	
					pedidocompraimporLocal.setorden_compra(pedidocompraimpor.getorden_compra());	
					pedidocompraimporLocal.setlugar_entrega(pedidocompraimpor.getlugar_entrega());	
					pedidocompraimporLocal.setdescripcion(pedidocompraimpor.getdescripcion());	
					pedidocompraimporLocal.setfecha(pedidocompraimpor.getfecha());	
					pedidocompraimporLocal.setfecha_emision(pedidocompraimpor.getfecha_emision());	
					pedidocompraimporLocal.setfecha_entrega(pedidocompraimpor.getfecha_entrega());	
					pedidocompraimporLocal.setfecha_entrega_cliente(pedidocompraimpor.getfecha_entrega_cliente());	
					pedidocompraimporLocal.setnombre_seguro(pedidocompraimpor.getnombre_seguro());	
					pedidocompraimporLocal.setnombre_consignatario(pedidocompraimpor.getnombre_consignatario());	
					pedidocompraimporLocal.setprecios(pedidocompraimpor.getprecios());	
					pedidocompraimporLocal.setflete(pedidocompraimpor.getflete());	
					pedidocompraimporLocal.setseguro(pedidocompraimpor.getseguro());	
					pedidocompraimporLocal.setgastos(pedidocompraimpor.getgastos());	
					pedidocompraimporLocal.setcfr(pedidocompraimpor.getcfr());	
					pedidocompraimporLocal.setcif(pedidocompraimpor.getcif());	
					pedidocompraimporLocal.settotal(pedidocompraimpor.gettotal());	
					pedidocompraimporLocal.setid_formato(pedidocompraimpor.getid_formato());	
					pedidocompraimporLocal.setid_anio(pedidocompraimpor.getid_anio());	
					pedidocompraimporLocal.setid_mes(pedidocompraimpor.getid_mes());	
					
					
					pedidocompraimporLocal.setDetallePedidoCompraImpors(pedidocompraimpor.getDetallePedidoCompraImpors());
					pedidocompraimporLocal.setLiquidacionImpuestoImpors(pedidocompraimpor.getLiquidacionImpuestoImpors());
					
					existe=true;
					break;
				}
			}
			
			if(!pedidocompraimpor.getIsDeleted()) {
				if(!existe) {
					pedidocompraimpors.add(pedidocompraimpor);
				}
			} else {
				if(pedidocompraimporEncontrado!=null && permiteQuitar)  {
					pedidocompraimpors.remove(pedidocompraimporEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PedidoCompraImpor pedidocompraimpor,List<PedidoCompraImpor> pedidocompraimpors) throws Exception {
		try	{			
			for(PedidoCompraImpor pedidocompraimporLocal:pedidocompraimpors) {
				if(pedidocompraimporLocal.getId().equals(pedidocompraimpor.getId())) {
					pedidocompraimporLocal.setIsSelected(pedidocompraimpor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPedidoCompraImpor(List<PedidoCompraImpor> pedidocompraimporsAux) throws Exception {
		//this.pedidocompraimporsAux=pedidocompraimporsAux;
		
		for(PedidoCompraImpor pedidocompraimporAux:pedidocompraimporsAux) {
			if(pedidocompraimporAux.getIsChanged()) {
				pedidocompraimporAux.setIsChanged(false);
			}		
			
			if(pedidocompraimporAux.getIsNew()) {
				pedidocompraimporAux.setIsNew(false);
			}	
			
			if(pedidocompraimporAux.getIsDeleted()) {
				pedidocompraimporAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPedidoCompraImpor(PedidoCompraImpor pedidocompraimporAux) throws Exception {
		//this.pedidocompraimporAux=pedidocompraimporAux;
		
			if(pedidocompraimporAux.getIsChanged()) {
				pedidocompraimporAux.setIsChanged(false);
			}		
			
			if(pedidocompraimporAux.getIsNew()) {
				pedidocompraimporAux.setIsNew(false);
			}	
			
			if(pedidocompraimporAux.getIsDeleted()) {
				pedidocompraimporAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PedidoCompraImpor pedidocompraimporAsignar,PedidoCompraImpor pedidocompraimpor) throws Exception {
		pedidocompraimporAsignar.setId(pedidocompraimpor.getId());	
		pedidocompraimporAsignar.setVersionRow(pedidocompraimpor.getVersionRow());	
		pedidocompraimporAsignar.setid_empresa(pedidocompraimpor.getid_empresa());
		pedidocompraimporAsignar.setempresa_descripcion(pedidocompraimpor.getempresa_descripcion());	
		pedidocompraimporAsignar.setid_sucursal(pedidocompraimpor.getid_sucursal());
		pedidocompraimporAsignar.setsucursal_descripcion(pedidocompraimpor.getsucursal_descripcion());	
		pedidocompraimporAsignar.setid_modulo(pedidocompraimpor.getid_modulo());
		pedidocompraimporAsignar.setmodulo_descripcion(pedidocompraimpor.getmodulo_descripcion());	
		pedidocompraimporAsignar.setid_ejercicio(pedidocompraimpor.getid_ejercicio());
		pedidocompraimporAsignar.setejercicio_descripcion(pedidocompraimpor.getejercicio_descripcion());	
		pedidocompraimporAsignar.setid_periodo(pedidocompraimpor.getid_periodo());
		pedidocompraimporAsignar.setperiodo_descripcion(pedidocompraimpor.getperiodo_descripcion());	
		pedidocompraimporAsignar.setid_pais(pedidocompraimpor.getid_pais());
		pedidocompraimporAsignar.setpais_descripcion(pedidocompraimpor.getpais_descripcion());	
		pedidocompraimporAsignar.setid_cliente(pedidocompraimpor.getid_cliente());
		pedidocompraimporAsignar.setcliente_descripcion(pedidocompraimpor.getcliente_descripcion());	
		pedidocompraimporAsignar.setid_cliente_proveedor(pedidocompraimpor.getid_cliente_proveedor());
		pedidocompraimporAsignar.setclienteproveedor_descripcion(pedidocompraimpor.getclienteproveedor_descripcion());	
		pedidocompraimporAsignar.setid_empleado(pedidocompraimpor.getid_empleado());
		pedidocompraimporAsignar.setempleado_descripcion(pedidocompraimpor.getempleado_descripcion());	
		pedidocompraimporAsignar.setid_usuario(pedidocompraimpor.getid_usuario());
		pedidocompraimporAsignar.setusuario_descripcion(pedidocompraimpor.getusuario_descripcion());	
		pedidocompraimporAsignar.setid_tipo_cambio(pedidocompraimpor.getid_tipo_cambio());
		pedidocompraimporAsignar.settipocambio_descripcion(pedidocompraimpor.gettipocambio_descripcion());	
		pedidocompraimporAsignar.setid_moneda(pedidocompraimpor.getid_moneda());
		pedidocompraimporAsignar.setmoneda_descripcion(pedidocompraimpor.getmoneda_descripcion());	
		pedidocompraimporAsignar.setid_tipo_prorrateo_impor(pedidocompraimpor.getid_tipo_prorrateo_impor());
		pedidocompraimporAsignar.settipoprorrateoimpor_descripcion(pedidocompraimpor.gettipoprorrateoimpor_descripcion());	
		pedidocompraimporAsignar.setid_embarcador(pedidocompraimpor.getid_embarcador());
		pedidocompraimporAsignar.setembarcador_descripcion(pedidocompraimpor.getembarcador_descripcion());	
		pedidocompraimporAsignar.setid_tipo_via_transporte(pedidocompraimpor.getid_tipo_via_transporte());
		pedidocompraimporAsignar.settipoviatransporte_descripcion(pedidocompraimpor.gettipoviatransporte_descripcion());	
		pedidocompraimporAsignar.setid_puerto(pedidocompraimpor.getid_puerto());
		pedidocompraimporAsignar.setpuerto_descripcion(pedidocompraimpor.getpuerto_descripcion());	
		pedidocompraimporAsignar.setid_puerto_destino(pedidocompraimpor.getid_puerto_destino());
		pedidocompraimporAsignar.setpuertodestino_descripcion(pedidocompraimpor.getpuertodestino_descripcion());	
		pedidocompraimporAsignar.setid_tipo_terminos_impor(pedidocompraimpor.getid_tipo_terminos_impor());
		pedidocompraimporAsignar.settipoterminosimpor_descripcion(pedidocompraimpor.gettipoterminosimpor_descripcion());	
		pedidocompraimporAsignar.setid_estado_pedido_compra(pedidocompraimpor.getid_estado_pedido_compra());
		pedidocompraimporAsignar.setestadopedidocompra_descripcion(pedidocompraimpor.getestadopedidocompra_descripcion());	
		pedidocompraimporAsignar.setforma_pago(pedidocompraimpor.getforma_pago());	
		pedidocompraimporAsignar.setnumero_dui(pedidocompraimpor.getnumero_dui());	
		pedidocompraimporAsignar.setsecuencial(pedidocompraimpor.getsecuencial());	
		pedidocompraimporAsignar.setnumero_orden(pedidocompraimpor.getnumero_orden());	
		pedidocompraimporAsignar.setuso_en(pedidocompraimpor.getuso_en());	
		pedidocompraimporAsignar.setresponsable(pedidocompraimpor.getresponsable());	
		pedidocompraimporAsignar.setorden_compra(pedidocompraimpor.getorden_compra());	
		pedidocompraimporAsignar.setlugar_entrega(pedidocompraimpor.getlugar_entrega());	
		pedidocompraimporAsignar.setdescripcion(pedidocompraimpor.getdescripcion());	
		pedidocompraimporAsignar.setfecha(pedidocompraimpor.getfecha());	
		pedidocompraimporAsignar.setfecha_emision(pedidocompraimpor.getfecha_emision());	
		pedidocompraimporAsignar.setfecha_entrega(pedidocompraimpor.getfecha_entrega());	
		pedidocompraimporAsignar.setfecha_entrega_cliente(pedidocompraimpor.getfecha_entrega_cliente());	
		pedidocompraimporAsignar.setnombre_seguro(pedidocompraimpor.getnombre_seguro());	
		pedidocompraimporAsignar.setnombre_consignatario(pedidocompraimpor.getnombre_consignatario());	
		pedidocompraimporAsignar.setprecios(pedidocompraimpor.getprecios());	
		pedidocompraimporAsignar.setflete(pedidocompraimpor.getflete());	
		pedidocompraimporAsignar.setseguro(pedidocompraimpor.getseguro());	
		pedidocompraimporAsignar.setgastos(pedidocompraimpor.getgastos());	
		pedidocompraimporAsignar.setcfr(pedidocompraimpor.getcfr());	
		pedidocompraimporAsignar.setcif(pedidocompraimpor.getcif());	
		pedidocompraimporAsignar.settotal(pedidocompraimpor.gettotal());	
		pedidocompraimporAsignar.setid_formato(pedidocompraimpor.getid_formato());
		pedidocompraimporAsignar.setformato_descripcion(pedidocompraimpor.getformato_descripcion());	
		pedidocompraimporAsignar.setid_anio(pedidocompraimpor.getid_anio());
		pedidocompraimporAsignar.setanio_descripcion(pedidocompraimpor.getanio_descripcion());	
		pedidocompraimporAsignar.setid_mes(pedidocompraimpor.getid_mes());
		pedidocompraimporAsignar.setmes_descripcion(pedidocompraimpor.getmes_descripcion());	
	}
	
	public static void inicializarPedidoCompraImpor(PedidoCompraImpor pedidocompraimpor) throws Exception {
		try {
				pedidocompraimpor.setId(0L);	
					
				pedidocompraimpor.setid_empresa(-1L);	
				pedidocompraimpor.setid_sucursal(-1L);	
				pedidocompraimpor.setid_modulo(-1L);	
				pedidocompraimpor.setid_ejercicio(-1L);	
				pedidocompraimpor.setid_periodo(-1L);	
				pedidocompraimpor.setid_pais(-1L);	
				pedidocompraimpor.setid_cliente(-1L);	
				pedidocompraimpor.setid_cliente_proveedor(-1L);	
				pedidocompraimpor.setid_empleado(-1L);	
				pedidocompraimpor.setid_usuario(-1L);	
				pedidocompraimpor.setid_tipo_cambio(null);	
				pedidocompraimpor.setid_moneda(-1L);	
				pedidocompraimpor.setid_tipo_prorrateo_impor(-1L);	
				pedidocompraimpor.setid_embarcador(-1L);	
				pedidocompraimpor.setid_tipo_via_transporte(-1L);	
				pedidocompraimpor.setid_puerto(-1L);	
				pedidocompraimpor.setid_puerto_destino(-1L);	
				pedidocompraimpor.setid_tipo_terminos_impor(-1L);	
				pedidocompraimpor.setid_estado_pedido_compra(-1L);	
				pedidocompraimpor.setforma_pago("");	
				pedidocompraimpor.setnumero_dui("");	
				pedidocompraimpor.setsecuencial("");	
				pedidocompraimpor.setnumero_orden(0);	
				pedidocompraimpor.setuso_en("");	
				pedidocompraimpor.setresponsable("");	
				pedidocompraimpor.setorden_compra("");	
				pedidocompraimpor.setlugar_entrega("");	
				pedidocompraimpor.setdescripcion("");	
				pedidocompraimpor.setfecha(new Date());	
				pedidocompraimpor.setfecha_emision(new Date());	
				pedidocompraimpor.setfecha_entrega(new Date());	
				pedidocompraimpor.setfecha_entrega_cliente(new Date());	
				pedidocompraimpor.setnombre_seguro("");	
				pedidocompraimpor.setnombre_consignatario("");	
				pedidocompraimpor.setprecios("");	
				pedidocompraimpor.setflete(0.0);	
				pedidocompraimpor.setseguro(0.0);	
				pedidocompraimpor.setgastos(0.0);	
				pedidocompraimpor.setcfr(0.0);	
				pedidocompraimpor.setcif(0.0);	
				pedidocompraimpor.settotal(0.0);	
				pedidocompraimpor.setid_formato(-1L);	
				pedidocompraimpor.setid_anio(null);	
				pedidocompraimpor.setid_mes(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPedidoCompraImpor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_IDCLIENTEPROVEEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_IDTIPOCAMBIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_IDTIPOPRORRATEOIMPOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_IDEMBARCADOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_IDPUERTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_IDPUERTODESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_IDTIPOTERMINOSIMPOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_IDESTADOPEDIDOCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_FORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_NUMERODUI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_NUMEROORDEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_USOEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_RESPONSABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_ORDENCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_LUGARENTREGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_FECHAENTREGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_FECHAENTREGACLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_NOMBRESEGURO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_NOMBRECONSIGNATARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_PRECIOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_SEGURO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_GASTOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_CFR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_CIF);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraImporConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPedidoCompraImpor(String sTipo,Row row,Workbook workbook,PedidoCompraImpor pedidocompraimpor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getclienteproveedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.gettipocambio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.gettipoprorrateoimpor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getembarcador_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.gettipoviatransporte_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getpuerto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getpuertodestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.gettipoterminosimpor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getestadopedidocompra_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getforma_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getnumero_dui());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getnumero_orden());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getuso_en());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getresponsable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getorden_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getlugar_entrega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getfecha_entrega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getfecha_entrega_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getnombre_seguro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getnombre_consignatario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getprecios());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getseguro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getgastos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getcfr());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getcif());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompraimpor.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPedidoCompraImpor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPedidoCompraImpor() {
		return this.sFinalQueryPedidoCompraImpor;
	}
	
	public void setsFinalQueryPedidoCompraImpor(String sFinalQueryPedidoCompraImpor) {
		this.sFinalQueryPedidoCompraImpor= sFinalQueryPedidoCompraImpor;
	}
	
	public Border resaltarSeleccionarPedidoCompraImpor=null;
	
	public Border setResaltarSeleccionarPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPedidoCompraImpor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPedidoCompraImpor() {
		return this.resaltarSeleccionarPedidoCompraImpor;
	}
	
	public void setResaltarSeleccionarPedidoCompraImpor(Border borderResaltarSeleccionarPedidoCompraImpor) {
		this.resaltarSeleccionarPedidoCompraImpor= borderResaltarSeleccionarPedidoCompraImpor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPedidoCompraImpor=null;
	public Boolean mostraridPedidoCompraImpor=true;
	public Boolean activaridPedidoCompraImpor=true;

	public Border resaltarid_empresaPedidoCompraImpor=null;
	public Boolean mostrarid_empresaPedidoCompraImpor=true;
	public Boolean activarid_empresaPedidoCompraImpor=true;
	public Boolean cargarid_empresaPedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_sucursalPedidoCompraImpor=null;
	public Boolean mostrarid_sucursalPedidoCompraImpor=true;
	public Boolean activarid_sucursalPedidoCompraImpor=true;
	public Boolean cargarid_sucursalPedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_moduloPedidoCompraImpor=null;
	public Boolean mostrarid_moduloPedidoCompraImpor=true;
	public Boolean activarid_moduloPedidoCompraImpor=true;
	public Boolean cargarid_moduloPedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloPedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_ejercicioPedidoCompraImpor=null;
	public Boolean mostrarid_ejercicioPedidoCompraImpor=true;
	public Boolean activarid_ejercicioPedidoCompraImpor=true;
	public Boolean cargarid_ejercicioPedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioPedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_periodoPedidoCompraImpor=null;
	public Boolean mostrarid_periodoPedidoCompraImpor=true;
	public Boolean activarid_periodoPedidoCompraImpor=true;
	public Boolean cargarid_periodoPedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoPedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_paisPedidoCompraImpor=null;
	public Boolean mostrarid_paisPedidoCompraImpor=true;
	public Boolean activarid_paisPedidoCompraImpor=true;
	public Boolean cargarid_paisPedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisPedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_clientePedidoCompraImpor=null;
	public Boolean mostrarid_clientePedidoCompraImpor=true;
	public Boolean activarid_clientePedidoCompraImpor=true;
	public Boolean cargarid_clientePedidoCompraImpor=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clientePedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_cliente_proveedorPedidoCompraImpor=null;
	public Boolean mostrarid_cliente_proveedorPedidoCompraImpor=true;
	public Boolean activarid_cliente_proveedorPedidoCompraImpor=true;
	public Boolean cargarid_cliente_proveedorPedidoCompraImpor=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cliente_proveedorPedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_empleadoPedidoCompraImpor=null;
	public Boolean mostrarid_empleadoPedidoCompraImpor=true;
	public Boolean activarid_empleadoPedidoCompraImpor=true;
	public Boolean cargarid_empleadoPedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoPedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_usuarioPedidoCompraImpor=null;
	public Boolean mostrarid_usuarioPedidoCompraImpor=true;
	public Boolean activarid_usuarioPedidoCompraImpor=true;
	public Boolean cargarid_usuarioPedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioPedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_tipo_cambioPedidoCompraImpor=null;
	public Boolean mostrarid_tipo_cambioPedidoCompraImpor=true;
	public Boolean activarid_tipo_cambioPedidoCompraImpor=true;
	public Boolean cargarid_tipo_cambioPedidoCompraImpor=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cambioPedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_monedaPedidoCompraImpor=null;
	public Boolean mostrarid_monedaPedidoCompraImpor=true;
	public Boolean activarid_monedaPedidoCompraImpor=true;
	public Boolean cargarid_monedaPedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaPedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_tipo_prorrateo_imporPedidoCompraImpor=null;
	public Boolean mostrarid_tipo_prorrateo_imporPedidoCompraImpor=true;
	public Boolean activarid_tipo_prorrateo_imporPedidoCompraImpor=true;
	public Boolean cargarid_tipo_prorrateo_imporPedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_prorrateo_imporPedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_embarcadorPedidoCompraImpor=null;
	public Boolean mostrarid_embarcadorPedidoCompraImpor=true;
	public Boolean activarid_embarcadorPedidoCompraImpor=true;
	public Boolean cargarid_embarcadorPedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_embarcadorPedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_tipo_via_transportePedidoCompraImpor=null;
	public Boolean mostrarid_tipo_via_transportePedidoCompraImpor=true;
	public Boolean activarid_tipo_via_transportePedidoCompraImpor=true;
	public Boolean cargarid_tipo_via_transportePedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_via_transportePedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_puertoPedidoCompraImpor=null;
	public Boolean mostrarid_puertoPedidoCompraImpor=true;
	public Boolean activarid_puertoPedidoCompraImpor=true;
	public Boolean cargarid_puertoPedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_puertoPedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_puerto_destinoPedidoCompraImpor=null;
	public Boolean mostrarid_puerto_destinoPedidoCompraImpor=true;
	public Boolean activarid_puerto_destinoPedidoCompraImpor=true;
	public Boolean cargarid_puerto_destinoPedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_puerto_destinoPedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_tipo_terminos_imporPedidoCompraImpor=null;
	public Boolean mostrarid_tipo_terminos_imporPedidoCompraImpor=true;
	public Boolean activarid_tipo_terminos_imporPedidoCompraImpor=true;
	public Boolean cargarid_tipo_terminos_imporPedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_terminos_imporPedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_estado_pedido_compraPedidoCompraImpor=null;
	public Boolean mostrarid_estado_pedido_compraPedidoCompraImpor=true;
	public Boolean activarid_estado_pedido_compraPedidoCompraImpor=true;
	public Boolean cargarid_estado_pedido_compraPedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_pedido_compraPedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarforma_pagoPedidoCompraImpor=null;
	public Boolean mostrarforma_pagoPedidoCompraImpor=true;
	public Boolean activarforma_pagoPedidoCompraImpor=true;

	public Border resaltarnumero_duiPedidoCompraImpor=null;
	public Boolean mostrarnumero_duiPedidoCompraImpor=true;
	public Boolean activarnumero_duiPedidoCompraImpor=true;

	public Border resaltarsecuencialPedidoCompraImpor=null;
	public Boolean mostrarsecuencialPedidoCompraImpor=true;
	public Boolean activarsecuencialPedidoCompraImpor=true;

	public Border resaltarnumero_ordenPedidoCompraImpor=null;
	public Boolean mostrarnumero_ordenPedidoCompraImpor=true;
	public Boolean activarnumero_ordenPedidoCompraImpor=true;

	public Border resaltaruso_enPedidoCompraImpor=null;
	public Boolean mostraruso_enPedidoCompraImpor=true;
	public Boolean activaruso_enPedidoCompraImpor=true;

	public Border resaltarresponsablePedidoCompraImpor=null;
	public Boolean mostrarresponsablePedidoCompraImpor=true;
	public Boolean activarresponsablePedidoCompraImpor=true;

	public Border resaltarorden_compraPedidoCompraImpor=null;
	public Boolean mostrarorden_compraPedidoCompraImpor=true;
	public Boolean activarorden_compraPedidoCompraImpor=true;

	public Border resaltarlugar_entregaPedidoCompraImpor=null;
	public Boolean mostrarlugar_entregaPedidoCompraImpor=true;
	public Boolean activarlugar_entregaPedidoCompraImpor=true;

	public Border resaltardescripcionPedidoCompraImpor=null;
	public Boolean mostrardescripcionPedidoCompraImpor=true;
	public Boolean activardescripcionPedidoCompraImpor=true;

	public Border resaltarfechaPedidoCompraImpor=null;
	public Boolean mostrarfechaPedidoCompraImpor=true;
	public Boolean activarfechaPedidoCompraImpor=false;

	public Border resaltarfecha_emisionPedidoCompraImpor=null;
	public Boolean mostrarfecha_emisionPedidoCompraImpor=true;
	public Boolean activarfecha_emisionPedidoCompraImpor=false;

	public Border resaltarfecha_entregaPedidoCompraImpor=null;
	public Boolean mostrarfecha_entregaPedidoCompraImpor=true;
	public Boolean activarfecha_entregaPedidoCompraImpor=false;

	public Border resaltarfecha_entrega_clientePedidoCompraImpor=null;
	public Boolean mostrarfecha_entrega_clientePedidoCompraImpor=true;
	public Boolean activarfecha_entrega_clientePedidoCompraImpor=false;

	public Border resaltarnombre_seguroPedidoCompraImpor=null;
	public Boolean mostrarnombre_seguroPedidoCompraImpor=true;
	public Boolean activarnombre_seguroPedidoCompraImpor=true;

	public Border resaltarnombre_consignatarioPedidoCompraImpor=null;
	public Boolean mostrarnombre_consignatarioPedidoCompraImpor=true;
	public Boolean activarnombre_consignatarioPedidoCompraImpor=true;

	public Border resaltarpreciosPedidoCompraImpor=null;
	public Boolean mostrarpreciosPedidoCompraImpor=true;
	public Boolean activarpreciosPedidoCompraImpor=true;

	public Border resaltarfletePedidoCompraImpor=null;
	public Boolean mostrarfletePedidoCompraImpor=true;
	public Boolean activarfletePedidoCompraImpor=true;

	public Border resaltarseguroPedidoCompraImpor=null;
	public Boolean mostrarseguroPedidoCompraImpor=true;
	public Boolean activarseguroPedidoCompraImpor=true;

	public Border resaltargastosPedidoCompraImpor=null;
	public Boolean mostrargastosPedidoCompraImpor=true;
	public Boolean activargastosPedidoCompraImpor=true;

	public Border resaltarcfrPedidoCompraImpor=null;
	public Boolean mostrarcfrPedidoCompraImpor=true;
	public Boolean activarcfrPedidoCompraImpor=true;

	public Border resaltarcifPedidoCompraImpor=null;
	public Boolean mostrarcifPedidoCompraImpor=true;
	public Boolean activarcifPedidoCompraImpor=true;

	public Border resaltartotalPedidoCompraImpor=null;
	public Boolean mostrartotalPedidoCompraImpor=true;
	public Boolean activartotalPedidoCompraImpor=true;

	public Border resaltarid_formatoPedidoCompraImpor=null;
	public Boolean mostrarid_formatoPedidoCompraImpor=true;
	public Boolean activarid_formatoPedidoCompraImpor=true;
	public Boolean cargarid_formatoPedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoPedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_anioPedidoCompraImpor=null;
	public Boolean mostrarid_anioPedidoCompraImpor=true;
	public Boolean activarid_anioPedidoCompraImpor=false;
	public Boolean cargarid_anioPedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioPedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_mesPedidoCompraImpor=null;
	public Boolean mostrarid_mesPedidoCompraImpor=true;
	public Boolean activarid_mesPedidoCompraImpor=false;
	public Boolean cargarid_mesPedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesPedidoCompraImpor=false;//ConEventDepend=true

	
	

	public Border setResaltaridPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltaridPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPedidoCompraImpor() {
		return this.resaltaridPedidoCompraImpor;
	}

	public void setResaltaridPedidoCompraImpor(Border borderResaltar) {
		this.resaltaridPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostraridPedidoCompraImpor() {
		return this.mostraridPedidoCompraImpor;
	}

	public void setMostraridPedidoCompraImpor(Boolean mostraridPedidoCompraImpor) {
		this.mostraridPedidoCompraImpor= mostraridPedidoCompraImpor;
	}

	public Boolean getActivaridPedidoCompraImpor() {
		return this.activaridPedidoCompraImpor;
	}

	public void setActivaridPedidoCompraImpor(Boolean activaridPedidoCompraImpor) {
		this.activaridPedidoCompraImpor= activaridPedidoCompraImpor;
	}

	public Border setResaltarid_empresaPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_empresaPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPedidoCompraImpor() {
		return this.resaltarid_empresaPedidoCompraImpor;
	}

	public void setResaltarid_empresaPedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_empresaPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_empresaPedidoCompraImpor() {
		return this.mostrarid_empresaPedidoCompraImpor;
	}

	public void setMostrarid_empresaPedidoCompraImpor(Boolean mostrarid_empresaPedidoCompraImpor) {
		this.mostrarid_empresaPedidoCompraImpor= mostrarid_empresaPedidoCompraImpor;
	}

	public Boolean getActivarid_empresaPedidoCompraImpor() {
		return this.activarid_empresaPedidoCompraImpor;
	}

	public void setActivarid_empresaPedidoCompraImpor(Boolean activarid_empresaPedidoCompraImpor) {
		this.activarid_empresaPedidoCompraImpor= activarid_empresaPedidoCompraImpor;
	}

	public Boolean getCargarid_empresaPedidoCompraImpor() {
		return this.cargarid_empresaPedidoCompraImpor;
	}

	public void setCargarid_empresaPedidoCompraImpor(Boolean cargarid_empresaPedidoCompraImpor) {
		this.cargarid_empresaPedidoCompraImpor= cargarid_empresaPedidoCompraImpor;
	}

	public Border setResaltarid_sucursalPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPedidoCompraImpor() {
		return this.resaltarid_sucursalPedidoCompraImpor;
	}

	public void setResaltarid_sucursalPedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_sucursalPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPedidoCompraImpor() {
		return this.mostrarid_sucursalPedidoCompraImpor;
	}

	public void setMostrarid_sucursalPedidoCompraImpor(Boolean mostrarid_sucursalPedidoCompraImpor) {
		this.mostrarid_sucursalPedidoCompraImpor= mostrarid_sucursalPedidoCompraImpor;
	}

	public Boolean getActivarid_sucursalPedidoCompraImpor() {
		return this.activarid_sucursalPedidoCompraImpor;
	}

	public void setActivarid_sucursalPedidoCompraImpor(Boolean activarid_sucursalPedidoCompraImpor) {
		this.activarid_sucursalPedidoCompraImpor= activarid_sucursalPedidoCompraImpor;
	}

	public Boolean getCargarid_sucursalPedidoCompraImpor() {
		return this.cargarid_sucursalPedidoCompraImpor;
	}

	public void setCargarid_sucursalPedidoCompraImpor(Boolean cargarid_sucursalPedidoCompraImpor) {
		this.cargarid_sucursalPedidoCompraImpor= cargarid_sucursalPedidoCompraImpor;
	}

	public Border setResaltarid_moduloPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_moduloPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloPedidoCompraImpor() {
		return this.resaltarid_moduloPedidoCompraImpor;
	}

	public void setResaltarid_moduloPedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_moduloPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_moduloPedidoCompraImpor() {
		return this.mostrarid_moduloPedidoCompraImpor;
	}

	public void setMostrarid_moduloPedidoCompraImpor(Boolean mostrarid_moduloPedidoCompraImpor) {
		this.mostrarid_moduloPedidoCompraImpor= mostrarid_moduloPedidoCompraImpor;
	}

	public Boolean getActivarid_moduloPedidoCompraImpor() {
		return this.activarid_moduloPedidoCompraImpor;
	}

	public void setActivarid_moduloPedidoCompraImpor(Boolean activarid_moduloPedidoCompraImpor) {
		this.activarid_moduloPedidoCompraImpor= activarid_moduloPedidoCompraImpor;
	}

	public Boolean getCargarid_moduloPedidoCompraImpor() {
		return this.cargarid_moduloPedidoCompraImpor;
	}

	public void setCargarid_moduloPedidoCompraImpor(Boolean cargarid_moduloPedidoCompraImpor) {
		this.cargarid_moduloPedidoCompraImpor= cargarid_moduloPedidoCompraImpor;
	}

	public Border setResaltarid_ejercicioPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioPedidoCompraImpor() {
		return this.resaltarid_ejercicioPedidoCompraImpor;
	}

	public void setResaltarid_ejercicioPedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_ejercicioPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioPedidoCompraImpor() {
		return this.mostrarid_ejercicioPedidoCompraImpor;
	}

	public void setMostrarid_ejercicioPedidoCompraImpor(Boolean mostrarid_ejercicioPedidoCompraImpor) {
		this.mostrarid_ejercicioPedidoCompraImpor= mostrarid_ejercicioPedidoCompraImpor;
	}

	public Boolean getActivarid_ejercicioPedidoCompraImpor() {
		return this.activarid_ejercicioPedidoCompraImpor;
	}

	public void setActivarid_ejercicioPedidoCompraImpor(Boolean activarid_ejercicioPedidoCompraImpor) {
		this.activarid_ejercicioPedidoCompraImpor= activarid_ejercicioPedidoCompraImpor;
	}

	public Boolean getCargarid_ejercicioPedidoCompraImpor() {
		return this.cargarid_ejercicioPedidoCompraImpor;
	}

	public void setCargarid_ejercicioPedidoCompraImpor(Boolean cargarid_ejercicioPedidoCompraImpor) {
		this.cargarid_ejercicioPedidoCompraImpor= cargarid_ejercicioPedidoCompraImpor;
	}

	public Border setResaltarid_periodoPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_periodoPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoPedidoCompraImpor() {
		return this.resaltarid_periodoPedidoCompraImpor;
	}

	public void setResaltarid_periodoPedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_periodoPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_periodoPedidoCompraImpor() {
		return this.mostrarid_periodoPedidoCompraImpor;
	}

	public void setMostrarid_periodoPedidoCompraImpor(Boolean mostrarid_periodoPedidoCompraImpor) {
		this.mostrarid_periodoPedidoCompraImpor= mostrarid_periodoPedidoCompraImpor;
	}

	public Boolean getActivarid_periodoPedidoCompraImpor() {
		return this.activarid_periodoPedidoCompraImpor;
	}

	public void setActivarid_periodoPedidoCompraImpor(Boolean activarid_periodoPedidoCompraImpor) {
		this.activarid_periodoPedidoCompraImpor= activarid_periodoPedidoCompraImpor;
	}

	public Boolean getCargarid_periodoPedidoCompraImpor() {
		return this.cargarid_periodoPedidoCompraImpor;
	}

	public void setCargarid_periodoPedidoCompraImpor(Boolean cargarid_periodoPedidoCompraImpor) {
		this.cargarid_periodoPedidoCompraImpor= cargarid_periodoPedidoCompraImpor;
	}

	public Border setResaltarid_paisPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_paisPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisPedidoCompraImpor() {
		return this.resaltarid_paisPedidoCompraImpor;
	}

	public void setResaltarid_paisPedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_paisPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_paisPedidoCompraImpor() {
		return this.mostrarid_paisPedidoCompraImpor;
	}

	public void setMostrarid_paisPedidoCompraImpor(Boolean mostrarid_paisPedidoCompraImpor) {
		this.mostrarid_paisPedidoCompraImpor= mostrarid_paisPedidoCompraImpor;
	}

	public Boolean getActivarid_paisPedidoCompraImpor() {
		return this.activarid_paisPedidoCompraImpor;
	}

	public void setActivarid_paisPedidoCompraImpor(Boolean activarid_paisPedidoCompraImpor) {
		this.activarid_paisPedidoCompraImpor= activarid_paisPedidoCompraImpor;
	}

	public Boolean getCargarid_paisPedidoCompraImpor() {
		return this.cargarid_paisPedidoCompraImpor;
	}

	public void setCargarid_paisPedidoCompraImpor(Boolean cargarid_paisPedidoCompraImpor) {
		this.cargarid_paisPedidoCompraImpor= cargarid_paisPedidoCompraImpor;
	}

	public Border setResaltarid_clientePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_clientePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clientePedidoCompraImpor() {
		return this.resaltarid_clientePedidoCompraImpor;
	}

	public void setResaltarid_clientePedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_clientePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_clientePedidoCompraImpor() {
		return this.mostrarid_clientePedidoCompraImpor;
	}

	public void setMostrarid_clientePedidoCompraImpor(Boolean mostrarid_clientePedidoCompraImpor) {
		this.mostrarid_clientePedidoCompraImpor= mostrarid_clientePedidoCompraImpor;
	}

	public Boolean getActivarid_clientePedidoCompraImpor() {
		return this.activarid_clientePedidoCompraImpor;
	}

	public void setActivarid_clientePedidoCompraImpor(Boolean activarid_clientePedidoCompraImpor) {
		this.activarid_clientePedidoCompraImpor= activarid_clientePedidoCompraImpor;
	}

	public Boolean getCargarid_clientePedidoCompraImpor() {
		return this.cargarid_clientePedidoCompraImpor;
	}

	public void setCargarid_clientePedidoCompraImpor(Boolean cargarid_clientePedidoCompraImpor) {
		this.cargarid_clientePedidoCompraImpor= cargarid_clientePedidoCompraImpor;
	}

	public Border setResaltarid_cliente_proveedorPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_cliente_proveedorPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cliente_proveedorPedidoCompraImpor() {
		return this.resaltarid_cliente_proveedorPedidoCompraImpor;
	}

	public void setResaltarid_cliente_proveedorPedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_cliente_proveedorPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_cliente_proveedorPedidoCompraImpor() {
		return this.mostrarid_cliente_proveedorPedidoCompraImpor;
	}

	public void setMostrarid_cliente_proveedorPedidoCompraImpor(Boolean mostrarid_cliente_proveedorPedidoCompraImpor) {
		this.mostrarid_cliente_proveedorPedidoCompraImpor= mostrarid_cliente_proveedorPedidoCompraImpor;
	}

	public Boolean getActivarid_cliente_proveedorPedidoCompraImpor() {
		return this.activarid_cliente_proveedorPedidoCompraImpor;
	}

	public void setActivarid_cliente_proveedorPedidoCompraImpor(Boolean activarid_cliente_proveedorPedidoCompraImpor) {
		this.activarid_cliente_proveedorPedidoCompraImpor= activarid_cliente_proveedorPedidoCompraImpor;
	}

	public Boolean getCargarid_cliente_proveedorPedidoCompraImpor() {
		return this.cargarid_cliente_proveedorPedidoCompraImpor;
	}

	public void setCargarid_cliente_proveedorPedidoCompraImpor(Boolean cargarid_cliente_proveedorPedidoCompraImpor) {
		this.cargarid_cliente_proveedorPedidoCompraImpor= cargarid_cliente_proveedorPedidoCompraImpor;
	}

	public Border setResaltarid_empleadoPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_empleadoPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoPedidoCompraImpor() {
		return this.resaltarid_empleadoPedidoCompraImpor;
	}

	public void setResaltarid_empleadoPedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_empleadoPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_empleadoPedidoCompraImpor() {
		return this.mostrarid_empleadoPedidoCompraImpor;
	}

	public void setMostrarid_empleadoPedidoCompraImpor(Boolean mostrarid_empleadoPedidoCompraImpor) {
		this.mostrarid_empleadoPedidoCompraImpor= mostrarid_empleadoPedidoCompraImpor;
	}

	public Boolean getActivarid_empleadoPedidoCompraImpor() {
		return this.activarid_empleadoPedidoCompraImpor;
	}

	public void setActivarid_empleadoPedidoCompraImpor(Boolean activarid_empleadoPedidoCompraImpor) {
		this.activarid_empleadoPedidoCompraImpor= activarid_empleadoPedidoCompraImpor;
	}

	public Boolean getCargarid_empleadoPedidoCompraImpor() {
		return this.cargarid_empleadoPedidoCompraImpor;
	}

	public void setCargarid_empleadoPedidoCompraImpor(Boolean cargarid_empleadoPedidoCompraImpor) {
		this.cargarid_empleadoPedidoCompraImpor= cargarid_empleadoPedidoCompraImpor;
	}

	public Border setResaltarid_usuarioPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_usuarioPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioPedidoCompraImpor() {
		return this.resaltarid_usuarioPedidoCompraImpor;
	}

	public void setResaltarid_usuarioPedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_usuarioPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_usuarioPedidoCompraImpor() {
		return this.mostrarid_usuarioPedidoCompraImpor;
	}

	public void setMostrarid_usuarioPedidoCompraImpor(Boolean mostrarid_usuarioPedidoCompraImpor) {
		this.mostrarid_usuarioPedidoCompraImpor= mostrarid_usuarioPedidoCompraImpor;
	}

	public Boolean getActivarid_usuarioPedidoCompraImpor() {
		return this.activarid_usuarioPedidoCompraImpor;
	}

	public void setActivarid_usuarioPedidoCompraImpor(Boolean activarid_usuarioPedidoCompraImpor) {
		this.activarid_usuarioPedidoCompraImpor= activarid_usuarioPedidoCompraImpor;
	}

	public Boolean getCargarid_usuarioPedidoCompraImpor() {
		return this.cargarid_usuarioPedidoCompraImpor;
	}

	public void setCargarid_usuarioPedidoCompraImpor(Boolean cargarid_usuarioPedidoCompraImpor) {
		this.cargarid_usuarioPedidoCompraImpor= cargarid_usuarioPedidoCompraImpor;
	}

	public Border setResaltarid_tipo_cambioPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cambioPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cambioPedidoCompraImpor() {
		return this.resaltarid_tipo_cambioPedidoCompraImpor;
	}

	public void setResaltarid_tipo_cambioPedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_tipo_cambioPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cambioPedidoCompraImpor() {
		return this.mostrarid_tipo_cambioPedidoCompraImpor;
	}

	public void setMostrarid_tipo_cambioPedidoCompraImpor(Boolean mostrarid_tipo_cambioPedidoCompraImpor) {
		this.mostrarid_tipo_cambioPedidoCompraImpor= mostrarid_tipo_cambioPedidoCompraImpor;
	}

	public Boolean getActivarid_tipo_cambioPedidoCompraImpor() {
		return this.activarid_tipo_cambioPedidoCompraImpor;
	}

	public void setActivarid_tipo_cambioPedidoCompraImpor(Boolean activarid_tipo_cambioPedidoCompraImpor) {
		this.activarid_tipo_cambioPedidoCompraImpor= activarid_tipo_cambioPedidoCompraImpor;
	}

	public Boolean getCargarid_tipo_cambioPedidoCompraImpor() {
		return this.cargarid_tipo_cambioPedidoCompraImpor;
	}

	public void setCargarid_tipo_cambioPedidoCompraImpor(Boolean cargarid_tipo_cambioPedidoCompraImpor) {
		this.cargarid_tipo_cambioPedidoCompraImpor= cargarid_tipo_cambioPedidoCompraImpor;
	}

	public Border setResaltarid_monedaPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_monedaPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaPedidoCompraImpor() {
		return this.resaltarid_monedaPedidoCompraImpor;
	}

	public void setResaltarid_monedaPedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_monedaPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_monedaPedidoCompraImpor() {
		return this.mostrarid_monedaPedidoCompraImpor;
	}

	public void setMostrarid_monedaPedidoCompraImpor(Boolean mostrarid_monedaPedidoCompraImpor) {
		this.mostrarid_monedaPedidoCompraImpor= mostrarid_monedaPedidoCompraImpor;
	}

	public Boolean getActivarid_monedaPedidoCompraImpor() {
		return this.activarid_monedaPedidoCompraImpor;
	}

	public void setActivarid_monedaPedidoCompraImpor(Boolean activarid_monedaPedidoCompraImpor) {
		this.activarid_monedaPedidoCompraImpor= activarid_monedaPedidoCompraImpor;
	}

	public Boolean getCargarid_monedaPedidoCompraImpor() {
		return this.cargarid_monedaPedidoCompraImpor;
	}

	public void setCargarid_monedaPedidoCompraImpor(Boolean cargarid_monedaPedidoCompraImpor) {
		this.cargarid_monedaPedidoCompraImpor= cargarid_monedaPedidoCompraImpor;
	}

	public Border setResaltarid_tipo_prorrateo_imporPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_tipo_prorrateo_imporPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_prorrateo_imporPedidoCompraImpor() {
		return this.resaltarid_tipo_prorrateo_imporPedidoCompraImpor;
	}

	public void setResaltarid_tipo_prorrateo_imporPedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_tipo_prorrateo_imporPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_tipo_prorrateo_imporPedidoCompraImpor() {
		return this.mostrarid_tipo_prorrateo_imporPedidoCompraImpor;
	}

	public void setMostrarid_tipo_prorrateo_imporPedidoCompraImpor(Boolean mostrarid_tipo_prorrateo_imporPedidoCompraImpor) {
		this.mostrarid_tipo_prorrateo_imporPedidoCompraImpor= mostrarid_tipo_prorrateo_imporPedidoCompraImpor;
	}

	public Boolean getActivarid_tipo_prorrateo_imporPedidoCompraImpor() {
		return this.activarid_tipo_prorrateo_imporPedidoCompraImpor;
	}

	public void setActivarid_tipo_prorrateo_imporPedidoCompraImpor(Boolean activarid_tipo_prorrateo_imporPedidoCompraImpor) {
		this.activarid_tipo_prorrateo_imporPedidoCompraImpor= activarid_tipo_prorrateo_imporPedidoCompraImpor;
	}

	public Boolean getCargarid_tipo_prorrateo_imporPedidoCompraImpor() {
		return this.cargarid_tipo_prorrateo_imporPedidoCompraImpor;
	}

	public void setCargarid_tipo_prorrateo_imporPedidoCompraImpor(Boolean cargarid_tipo_prorrateo_imporPedidoCompraImpor) {
		this.cargarid_tipo_prorrateo_imporPedidoCompraImpor= cargarid_tipo_prorrateo_imporPedidoCompraImpor;
	}

	public Border setResaltarid_embarcadorPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_embarcadorPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_embarcadorPedidoCompraImpor() {
		return this.resaltarid_embarcadorPedidoCompraImpor;
	}

	public void setResaltarid_embarcadorPedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_embarcadorPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_embarcadorPedidoCompraImpor() {
		return this.mostrarid_embarcadorPedidoCompraImpor;
	}

	public void setMostrarid_embarcadorPedidoCompraImpor(Boolean mostrarid_embarcadorPedidoCompraImpor) {
		this.mostrarid_embarcadorPedidoCompraImpor= mostrarid_embarcadorPedidoCompraImpor;
	}

	public Boolean getActivarid_embarcadorPedidoCompraImpor() {
		return this.activarid_embarcadorPedidoCompraImpor;
	}

	public void setActivarid_embarcadorPedidoCompraImpor(Boolean activarid_embarcadorPedidoCompraImpor) {
		this.activarid_embarcadorPedidoCompraImpor= activarid_embarcadorPedidoCompraImpor;
	}

	public Boolean getCargarid_embarcadorPedidoCompraImpor() {
		return this.cargarid_embarcadorPedidoCompraImpor;
	}

	public void setCargarid_embarcadorPedidoCompraImpor(Boolean cargarid_embarcadorPedidoCompraImpor) {
		this.cargarid_embarcadorPedidoCompraImpor= cargarid_embarcadorPedidoCompraImpor;
	}

	public Border setResaltarid_tipo_via_transportePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_tipo_via_transportePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_via_transportePedidoCompraImpor() {
		return this.resaltarid_tipo_via_transportePedidoCompraImpor;
	}

	public void setResaltarid_tipo_via_transportePedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_tipo_via_transportePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_tipo_via_transportePedidoCompraImpor() {
		return this.mostrarid_tipo_via_transportePedidoCompraImpor;
	}

	public void setMostrarid_tipo_via_transportePedidoCompraImpor(Boolean mostrarid_tipo_via_transportePedidoCompraImpor) {
		this.mostrarid_tipo_via_transportePedidoCompraImpor= mostrarid_tipo_via_transportePedidoCompraImpor;
	}

	public Boolean getActivarid_tipo_via_transportePedidoCompraImpor() {
		return this.activarid_tipo_via_transportePedidoCompraImpor;
	}

	public void setActivarid_tipo_via_transportePedidoCompraImpor(Boolean activarid_tipo_via_transportePedidoCompraImpor) {
		this.activarid_tipo_via_transportePedidoCompraImpor= activarid_tipo_via_transportePedidoCompraImpor;
	}

	public Boolean getCargarid_tipo_via_transportePedidoCompraImpor() {
		return this.cargarid_tipo_via_transportePedidoCompraImpor;
	}

	public void setCargarid_tipo_via_transportePedidoCompraImpor(Boolean cargarid_tipo_via_transportePedidoCompraImpor) {
		this.cargarid_tipo_via_transportePedidoCompraImpor= cargarid_tipo_via_transportePedidoCompraImpor;
	}

	public Border setResaltarid_puertoPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_puertoPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_puertoPedidoCompraImpor() {
		return this.resaltarid_puertoPedidoCompraImpor;
	}

	public void setResaltarid_puertoPedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_puertoPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_puertoPedidoCompraImpor() {
		return this.mostrarid_puertoPedidoCompraImpor;
	}

	public void setMostrarid_puertoPedidoCompraImpor(Boolean mostrarid_puertoPedidoCompraImpor) {
		this.mostrarid_puertoPedidoCompraImpor= mostrarid_puertoPedidoCompraImpor;
	}

	public Boolean getActivarid_puertoPedidoCompraImpor() {
		return this.activarid_puertoPedidoCompraImpor;
	}

	public void setActivarid_puertoPedidoCompraImpor(Boolean activarid_puertoPedidoCompraImpor) {
		this.activarid_puertoPedidoCompraImpor= activarid_puertoPedidoCompraImpor;
	}

	public Boolean getCargarid_puertoPedidoCompraImpor() {
		return this.cargarid_puertoPedidoCompraImpor;
	}

	public void setCargarid_puertoPedidoCompraImpor(Boolean cargarid_puertoPedidoCompraImpor) {
		this.cargarid_puertoPedidoCompraImpor= cargarid_puertoPedidoCompraImpor;
	}

	public Border setResaltarid_puerto_destinoPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_puerto_destinoPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_puerto_destinoPedidoCompraImpor() {
		return this.resaltarid_puerto_destinoPedidoCompraImpor;
	}

	public void setResaltarid_puerto_destinoPedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_puerto_destinoPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_puerto_destinoPedidoCompraImpor() {
		return this.mostrarid_puerto_destinoPedidoCompraImpor;
	}

	public void setMostrarid_puerto_destinoPedidoCompraImpor(Boolean mostrarid_puerto_destinoPedidoCompraImpor) {
		this.mostrarid_puerto_destinoPedidoCompraImpor= mostrarid_puerto_destinoPedidoCompraImpor;
	}

	public Boolean getActivarid_puerto_destinoPedidoCompraImpor() {
		return this.activarid_puerto_destinoPedidoCompraImpor;
	}

	public void setActivarid_puerto_destinoPedidoCompraImpor(Boolean activarid_puerto_destinoPedidoCompraImpor) {
		this.activarid_puerto_destinoPedidoCompraImpor= activarid_puerto_destinoPedidoCompraImpor;
	}

	public Boolean getCargarid_puerto_destinoPedidoCompraImpor() {
		return this.cargarid_puerto_destinoPedidoCompraImpor;
	}

	public void setCargarid_puerto_destinoPedidoCompraImpor(Boolean cargarid_puerto_destinoPedidoCompraImpor) {
		this.cargarid_puerto_destinoPedidoCompraImpor= cargarid_puerto_destinoPedidoCompraImpor;
	}

	public Border setResaltarid_tipo_terminos_imporPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_tipo_terminos_imporPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_terminos_imporPedidoCompraImpor() {
		return this.resaltarid_tipo_terminos_imporPedidoCompraImpor;
	}

	public void setResaltarid_tipo_terminos_imporPedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_tipo_terminos_imporPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_tipo_terminos_imporPedidoCompraImpor() {
		return this.mostrarid_tipo_terminos_imporPedidoCompraImpor;
	}

	public void setMostrarid_tipo_terminos_imporPedidoCompraImpor(Boolean mostrarid_tipo_terminos_imporPedidoCompraImpor) {
		this.mostrarid_tipo_terminos_imporPedidoCompraImpor= mostrarid_tipo_terminos_imporPedidoCompraImpor;
	}

	public Boolean getActivarid_tipo_terminos_imporPedidoCompraImpor() {
		return this.activarid_tipo_terminos_imporPedidoCompraImpor;
	}

	public void setActivarid_tipo_terminos_imporPedidoCompraImpor(Boolean activarid_tipo_terminos_imporPedidoCompraImpor) {
		this.activarid_tipo_terminos_imporPedidoCompraImpor= activarid_tipo_terminos_imporPedidoCompraImpor;
	}

	public Boolean getCargarid_tipo_terminos_imporPedidoCompraImpor() {
		return this.cargarid_tipo_terminos_imporPedidoCompraImpor;
	}

	public void setCargarid_tipo_terminos_imporPedidoCompraImpor(Boolean cargarid_tipo_terminos_imporPedidoCompraImpor) {
		this.cargarid_tipo_terminos_imporPedidoCompraImpor= cargarid_tipo_terminos_imporPedidoCompraImpor;
	}

	public Border setResaltarid_estado_pedido_compraPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_estado_pedido_compraPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_pedido_compraPedidoCompraImpor() {
		return this.resaltarid_estado_pedido_compraPedidoCompraImpor;
	}

	public void setResaltarid_estado_pedido_compraPedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_estado_pedido_compraPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_estado_pedido_compraPedidoCompraImpor() {
		return this.mostrarid_estado_pedido_compraPedidoCompraImpor;
	}

	public void setMostrarid_estado_pedido_compraPedidoCompraImpor(Boolean mostrarid_estado_pedido_compraPedidoCompraImpor) {
		this.mostrarid_estado_pedido_compraPedidoCompraImpor= mostrarid_estado_pedido_compraPedidoCompraImpor;
	}

	public Boolean getActivarid_estado_pedido_compraPedidoCompraImpor() {
		return this.activarid_estado_pedido_compraPedidoCompraImpor;
	}

	public void setActivarid_estado_pedido_compraPedidoCompraImpor(Boolean activarid_estado_pedido_compraPedidoCompraImpor) {
		this.activarid_estado_pedido_compraPedidoCompraImpor= activarid_estado_pedido_compraPedidoCompraImpor;
	}

	public Boolean getCargarid_estado_pedido_compraPedidoCompraImpor() {
		return this.cargarid_estado_pedido_compraPedidoCompraImpor;
	}

	public void setCargarid_estado_pedido_compraPedidoCompraImpor(Boolean cargarid_estado_pedido_compraPedidoCompraImpor) {
		this.cargarid_estado_pedido_compraPedidoCompraImpor= cargarid_estado_pedido_compraPedidoCompraImpor;
	}

	public Border setResaltarforma_pagoPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarforma_pagoPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarforma_pagoPedidoCompraImpor() {
		return this.resaltarforma_pagoPedidoCompraImpor;
	}

	public void setResaltarforma_pagoPedidoCompraImpor(Border borderResaltar) {
		this.resaltarforma_pagoPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarforma_pagoPedidoCompraImpor() {
		return this.mostrarforma_pagoPedidoCompraImpor;
	}

	public void setMostrarforma_pagoPedidoCompraImpor(Boolean mostrarforma_pagoPedidoCompraImpor) {
		this.mostrarforma_pagoPedidoCompraImpor= mostrarforma_pagoPedidoCompraImpor;
	}

	public Boolean getActivarforma_pagoPedidoCompraImpor() {
		return this.activarforma_pagoPedidoCompraImpor;
	}

	public void setActivarforma_pagoPedidoCompraImpor(Boolean activarforma_pagoPedidoCompraImpor) {
		this.activarforma_pagoPedidoCompraImpor= activarforma_pagoPedidoCompraImpor;
	}

	public Border setResaltarnumero_duiPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarnumero_duiPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_duiPedidoCompraImpor() {
		return this.resaltarnumero_duiPedidoCompraImpor;
	}

	public void setResaltarnumero_duiPedidoCompraImpor(Border borderResaltar) {
		this.resaltarnumero_duiPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarnumero_duiPedidoCompraImpor() {
		return this.mostrarnumero_duiPedidoCompraImpor;
	}

	public void setMostrarnumero_duiPedidoCompraImpor(Boolean mostrarnumero_duiPedidoCompraImpor) {
		this.mostrarnumero_duiPedidoCompraImpor= mostrarnumero_duiPedidoCompraImpor;
	}

	public Boolean getActivarnumero_duiPedidoCompraImpor() {
		return this.activarnumero_duiPedidoCompraImpor;
	}

	public void setActivarnumero_duiPedidoCompraImpor(Boolean activarnumero_duiPedidoCompraImpor) {
		this.activarnumero_duiPedidoCompraImpor= activarnumero_duiPedidoCompraImpor;
	}

	public Border setResaltarsecuencialPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarsecuencialPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialPedidoCompraImpor() {
		return this.resaltarsecuencialPedidoCompraImpor;
	}

	public void setResaltarsecuencialPedidoCompraImpor(Border borderResaltar) {
		this.resaltarsecuencialPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarsecuencialPedidoCompraImpor() {
		return this.mostrarsecuencialPedidoCompraImpor;
	}

	public void setMostrarsecuencialPedidoCompraImpor(Boolean mostrarsecuencialPedidoCompraImpor) {
		this.mostrarsecuencialPedidoCompraImpor= mostrarsecuencialPedidoCompraImpor;
	}

	public Boolean getActivarsecuencialPedidoCompraImpor() {
		return this.activarsecuencialPedidoCompraImpor;
	}

	public void setActivarsecuencialPedidoCompraImpor(Boolean activarsecuencialPedidoCompraImpor) {
		this.activarsecuencialPedidoCompraImpor= activarsecuencialPedidoCompraImpor;
	}

	public Border setResaltarnumero_ordenPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarnumero_ordenPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_ordenPedidoCompraImpor() {
		return this.resaltarnumero_ordenPedidoCompraImpor;
	}

	public void setResaltarnumero_ordenPedidoCompraImpor(Border borderResaltar) {
		this.resaltarnumero_ordenPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarnumero_ordenPedidoCompraImpor() {
		return this.mostrarnumero_ordenPedidoCompraImpor;
	}

	public void setMostrarnumero_ordenPedidoCompraImpor(Boolean mostrarnumero_ordenPedidoCompraImpor) {
		this.mostrarnumero_ordenPedidoCompraImpor= mostrarnumero_ordenPedidoCompraImpor;
	}

	public Boolean getActivarnumero_ordenPedidoCompraImpor() {
		return this.activarnumero_ordenPedidoCompraImpor;
	}

	public void setActivarnumero_ordenPedidoCompraImpor(Boolean activarnumero_ordenPedidoCompraImpor) {
		this.activarnumero_ordenPedidoCompraImpor= activarnumero_ordenPedidoCompraImpor;
	}

	public Border setResaltaruso_enPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltaruso_enPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaruso_enPedidoCompraImpor() {
		return this.resaltaruso_enPedidoCompraImpor;
	}

	public void setResaltaruso_enPedidoCompraImpor(Border borderResaltar) {
		this.resaltaruso_enPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostraruso_enPedidoCompraImpor() {
		return this.mostraruso_enPedidoCompraImpor;
	}

	public void setMostraruso_enPedidoCompraImpor(Boolean mostraruso_enPedidoCompraImpor) {
		this.mostraruso_enPedidoCompraImpor= mostraruso_enPedidoCompraImpor;
	}

	public Boolean getActivaruso_enPedidoCompraImpor() {
		return this.activaruso_enPedidoCompraImpor;
	}

	public void setActivaruso_enPedidoCompraImpor(Boolean activaruso_enPedidoCompraImpor) {
		this.activaruso_enPedidoCompraImpor= activaruso_enPedidoCompraImpor;
	}

	public Border setResaltarresponsablePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarresponsablePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarresponsablePedidoCompraImpor() {
		return this.resaltarresponsablePedidoCompraImpor;
	}

	public void setResaltarresponsablePedidoCompraImpor(Border borderResaltar) {
		this.resaltarresponsablePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarresponsablePedidoCompraImpor() {
		return this.mostrarresponsablePedidoCompraImpor;
	}

	public void setMostrarresponsablePedidoCompraImpor(Boolean mostrarresponsablePedidoCompraImpor) {
		this.mostrarresponsablePedidoCompraImpor= mostrarresponsablePedidoCompraImpor;
	}

	public Boolean getActivarresponsablePedidoCompraImpor() {
		return this.activarresponsablePedidoCompraImpor;
	}

	public void setActivarresponsablePedidoCompraImpor(Boolean activarresponsablePedidoCompraImpor) {
		this.activarresponsablePedidoCompraImpor= activarresponsablePedidoCompraImpor;
	}

	public Border setResaltarorden_compraPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarorden_compraPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarorden_compraPedidoCompraImpor() {
		return this.resaltarorden_compraPedidoCompraImpor;
	}

	public void setResaltarorden_compraPedidoCompraImpor(Border borderResaltar) {
		this.resaltarorden_compraPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarorden_compraPedidoCompraImpor() {
		return this.mostrarorden_compraPedidoCompraImpor;
	}

	public void setMostrarorden_compraPedidoCompraImpor(Boolean mostrarorden_compraPedidoCompraImpor) {
		this.mostrarorden_compraPedidoCompraImpor= mostrarorden_compraPedidoCompraImpor;
	}

	public Boolean getActivarorden_compraPedidoCompraImpor() {
		return this.activarorden_compraPedidoCompraImpor;
	}

	public void setActivarorden_compraPedidoCompraImpor(Boolean activarorden_compraPedidoCompraImpor) {
		this.activarorden_compraPedidoCompraImpor= activarorden_compraPedidoCompraImpor;
	}

	public Border setResaltarlugar_entregaPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarlugar_entregaPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarlugar_entregaPedidoCompraImpor() {
		return this.resaltarlugar_entregaPedidoCompraImpor;
	}

	public void setResaltarlugar_entregaPedidoCompraImpor(Border borderResaltar) {
		this.resaltarlugar_entregaPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarlugar_entregaPedidoCompraImpor() {
		return this.mostrarlugar_entregaPedidoCompraImpor;
	}

	public void setMostrarlugar_entregaPedidoCompraImpor(Boolean mostrarlugar_entregaPedidoCompraImpor) {
		this.mostrarlugar_entregaPedidoCompraImpor= mostrarlugar_entregaPedidoCompraImpor;
	}

	public Boolean getActivarlugar_entregaPedidoCompraImpor() {
		return this.activarlugar_entregaPedidoCompraImpor;
	}

	public void setActivarlugar_entregaPedidoCompraImpor(Boolean activarlugar_entregaPedidoCompraImpor) {
		this.activarlugar_entregaPedidoCompraImpor= activarlugar_entregaPedidoCompraImpor;
	}

	public Border setResaltardescripcionPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltardescripcionPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionPedidoCompraImpor() {
		return this.resaltardescripcionPedidoCompraImpor;
	}

	public void setResaltardescripcionPedidoCompraImpor(Border borderResaltar) {
		this.resaltardescripcionPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrardescripcionPedidoCompraImpor() {
		return this.mostrardescripcionPedidoCompraImpor;
	}

	public void setMostrardescripcionPedidoCompraImpor(Boolean mostrardescripcionPedidoCompraImpor) {
		this.mostrardescripcionPedidoCompraImpor= mostrardescripcionPedidoCompraImpor;
	}

	public Boolean getActivardescripcionPedidoCompraImpor() {
		return this.activardescripcionPedidoCompraImpor;
	}

	public void setActivardescripcionPedidoCompraImpor(Boolean activardescripcionPedidoCompraImpor) {
		this.activardescripcionPedidoCompraImpor= activardescripcionPedidoCompraImpor;
	}

	public Border setResaltarfechaPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarfechaPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaPedidoCompraImpor() {
		return this.resaltarfechaPedidoCompraImpor;
	}

	public void setResaltarfechaPedidoCompraImpor(Border borderResaltar) {
		this.resaltarfechaPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarfechaPedidoCompraImpor() {
		return this.mostrarfechaPedidoCompraImpor;
	}

	public void setMostrarfechaPedidoCompraImpor(Boolean mostrarfechaPedidoCompraImpor) {
		this.mostrarfechaPedidoCompraImpor= mostrarfechaPedidoCompraImpor;
	}

	public Boolean getActivarfechaPedidoCompraImpor() {
		return this.activarfechaPedidoCompraImpor;
	}

	public void setActivarfechaPedidoCompraImpor(Boolean activarfechaPedidoCompraImpor) {
		this.activarfechaPedidoCompraImpor= activarfechaPedidoCompraImpor;
	}

	public Border setResaltarfecha_emisionPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionPedidoCompraImpor() {
		return this.resaltarfecha_emisionPedidoCompraImpor;
	}

	public void setResaltarfecha_emisionPedidoCompraImpor(Border borderResaltar) {
		this.resaltarfecha_emisionPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionPedidoCompraImpor() {
		return this.mostrarfecha_emisionPedidoCompraImpor;
	}

	public void setMostrarfecha_emisionPedidoCompraImpor(Boolean mostrarfecha_emisionPedidoCompraImpor) {
		this.mostrarfecha_emisionPedidoCompraImpor= mostrarfecha_emisionPedidoCompraImpor;
	}

	public Boolean getActivarfecha_emisionPedidoCompraImpor() {
		return this.activarfecha_emisionPedidoCompraImpor;
	}

	public void setActivarfecha_emisionPedidoCompraImpor(Boolean activarfecha_emisionPedidoCompraImpor) {
		this.activarfecha_emisionPedidoCompraImpor= activarfecha_emisionPedidoCompraImpor;
	}

	public Border setResaltarfecha_entregaPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarfecha_entregaPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_entregaPedidoCompraImpor() {
		return this.resaltarfecha_entregaPedidoCompraImpor;
	}

	public void setResaltarfecha_entregaPedidoCompraImpor(Border borderResaltar) {
		this.resaltarfecha_entregaPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarfecha_entregaPedidoCompraImpor() {
		return this.mostrarfecha_entregaPedidoCompraImpor;
	}

	public void setMostrarfecha_entregaPedidoCompraImpor(Boolean mostrarfecha_entregaPedidoCompraImpor) {
		this.mostrarfecha_entregaPedidoCompraImpor= mostrarfecha_entregaPedidoCompraImpor;
	}

	public Boolean getActivarfecha_entregaPedidoCompraImpor() {
		return this.activarfecha_entregaPedidoCompraImpor;
	}

	public void setActivarfecha_entregaPedidoCompraImpor(Boolean activarfecha_entregaPedidoCompraImpor) {
		this.activarfecha_entregaPedidoCompraImpor= activarfecha_entregaPedidoCompraImpor;
	}

	public Border setResaltarfecha_entrega_clientePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarfecha_entrega_clientePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_entrega_clientePedidoCompraImpor() {
		return this.resaltarfecha_entrega_clientePedidoCompraImpor;
	}

	public void setResaltarfecha_entrega_clientePedidoCompraImpor(Border borderResaltar) {
		this.resaltarfecha_entrega_clientePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarfecha_entrega_clientePedidoCompraImpor() {
		return this.mostrarfecha_entrega_clientePedidoCompraImpor;
	}

	public void setMostrarfecha_entrega_clientePedidoCompraImpor(Boolean mostrarfecha_entrega_clientePedidoCompraImpor) {
		this.mostrarfecha_entrega_clientePedidoCompraImpor= mostrarfecha_entrega_clientePedidoCompraImpor;
	}

	public Boolean getActivarfecha_entrega_clientePedidoCompraImpor() {
		return this.activarfecha_entrega_clientePedidoCompraImpor;
	}

	public void setActivarfecha_entrega_clientePedidoCompraImpor(Boolean activarfecha_entrega_clientePedidoCompraImpor) {
		this.activarfecha_entrega_clientePedidoCompraImpor= activarfecha_entrega_clientePedidoCompraImpor;
	}

	public Border setResaltarnombre_seguroPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarnombre_seguroPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_seguroPedidoCompraImpor() {
		return this.resaltarnombre_seguroPedidoCompraImpor;
	}

	public void setResaltarnombre_seguroPedidoCompraImpor(Border borderResaltar) {
		this.resaltarnombre_seguroPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarnombre_seguroPedidoCompraImpor() {
		return this.mostrarnombre_seguroPedidoCompraImpor;
	}

	public void setMostrarnombre_seguroPedidoCompraImpor(Boolean mostrarnombre_seguroPedidoCompraImpor) {
		this.mostrarnombre_seguroPedidoCompraImpor= mostrarnombre_seguroPedidoCompraImpor;
	}

	public Boolean getActivarnombre_seguroPedidoCompraImpor() {
		return this.activarnombre_seguroPedidoCompraImpor;
	}

	public void setActivarnombre_seguroPedidoCompraImpor(Boolean activarnombre_seguroPedidoCompraImpor) {
		this.activarnombre_seguroPedidoCompraImpor= activarnombre_seguroPedidoCompraImpor;
	}

	public Border setResaltarnombre_consignatarioPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarnombre_consignatarioPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_consignatarioPedidoCompraImpor() {
		return this.resaltarnombre_consignatarioPedidoCompraImpor;
	}

	public void setResaltarnombre_consignatarioPedidoCompraImpor(Border borderResaltar) {
		this.resaltarnombre_consignatarioPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarnombre_consignatarioPedidoCompraImpor() {
		return this.mostrarnombre_consignatarioPedidoCompraImpor;
	}

	public void setMostrarnombre_consignatarioPedidoCompraImpor(Boolean mostrarnombre_consignatarioPedidoCompraImpor) {
		this.mostrarnombre_consignatarioPedidoCompraImpor= mostrarnombre_consignatarioPedidoCompraImpor;
	}

	public Boolean getActivarnombre_consignatarioPedidoCompraImpor() {
		return this.activarnombre_consignatarioPedidoCompraImpor;
	}

	public void setActivarnombre_consignatarioPedidoCompraImpor(Boolean activarnombre_consignatarioPedidoCompraImpor) {
		this.activarnombre_consignatarioPedidoCompraImpor= activarnombre_consignatarioPedidoCompraImpor;
	}

	public Border setResaltarpreciosPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarpreciosPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpreciosPedidoCompraImpor() {
		return this.resaltarpreciosPedidoCompraImpor;
	}

	public void setResaltarpreciosPedidoCompraImpor(Border borderResaltar) {
		this.resaltarpreciosPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarpreciosPedidoCompraImpor() {
		return this.mostrarpreciosPedidoCompraImpor;
	}

	public void setMostrarpreciosPedidoCompraImpor(Boolean mostrarpreciosPedidoCompraImpor) {
		this.mostrarpreciosPedidoCompraImpor= mostrarpreciosPedidoCompraImpor;
	}

	public Boolean getActivarpreciosPedidoCompraImpor() {
		return this.activarpreciosPedidoCompraImpor;
	}

	public void setActivarpreciosPedidoCompraImpor(Boolean activarpreciosPedidoCompraImpor) {
		this.activarpreciosPedidoCompraImpor= activarpreciosPedidoCompraImpor;
	}

	public Border setResaltarfletePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarfletePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfletePedidoCompraImpor() {
		return this.resaltarfletePedidoCompraImpor;
	}

	public void setResaltarfletePedidoCompraImpor(Border borderResaltar) {
		this.resaltarfletePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarfletePedidoCompraImpor() {
		return this.mostrarfletePedidoCompraImpor;
	}

	public void setMostrarfletePedidoCompraImpor(Boolean mostrarfletePedidoCompraImpor) {
		this.mostrarfletePedidoCompraImpor= mostrarfletePedidoCompraImpor;
	}

	public Boolean getActivarfletePedidoCompraImpor() {
		return this.activarfletePedidoCompraImpor;
	}

	public void setActivarfletePedidoCompraImpor(Boolean activarfletePedidoCompraImpor) {
		this.activarfletePedidoCompraImpor= activarfletePedidoCompraImpor;
	}

	public Border setResaltarseguroPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarseguroPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarseguroPedidoCompraImpor() {
		return this.resaltarseguroPedidoCompraImpor;
	}

	public void setResaltarseguroPedidoCompraImpor(Border borderResaltar) {
		this.resaltarseguroPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarseguroPedidoCompraImpor() {
		return this.mostrarseguroPedidoCompraImpor;
	}

	public void setMostrarseguroPedidoCompraImpor(Boolean mostrarseguroPedidoCompraImpor) {
		this.mostrarseguroPedidoCompraImpor= mostrarseguroPedidoCompraImpor;
	}

	public Boolean getActivarseguroPedidoCompraImpor() {
		return this.activarseguroPedidoCompraImpor;
	}

	public void setActivarseguroPedidoCompraImpor(Boolean activarseguroPedidoCompraImpor) {
		this.activarseguroPedidoCompraImpor= activarseguroPedidoCompraImpor;
	}

	public Border setResaltargastosPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltargastosPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargastosPedidoCompraImpor() {
		return this.resaltargastosPedidoCompraImpor;
	}

	public void setResaltargastosPedidoCompraImpor(Border borderResaltar) {
		this.resaltargastosPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrargastosPedidoCompraImpor() {
		return this.mostrargastosPedidoCompraImpor;
	}

	public void setMostrargastosPedidoCompraImpor(Boolean mostrargastosPedidoCompraImpor) {
		this.mostrargastosPedidoCompraImpor= mostrargastosPedidoCompraImpor;
	}

	public Boolean getActivargastosPedidoCompraImpor() {
		return this.activargastosPedidoCompraImpor;
	}

	public void setActivargastosPedidoCompraImpor(Boolean activargastosPedidoCompraImpor) {
		this.activargastosPedidoCompraImpor= activargastosPedidoCompraImpor;
	}

	public Border setResaltarcfrPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarcfrPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcfrPedidoCompraImpor() {
		return this.resaltarcfrPedidoCompraImpor;
	}

	public void setResaltarcfrPedidoCompraImpor(Border borderResaltar) {
		this.resaltarcfrPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarcfrPedidoCompraImpor() {
		return this.mostrarcfrPedidoCompraImpor;
	}

	public void setMostrarcfrPedidoCompraImpor(Boolean mostrarcfrPedidoCompraImpor) {
		this.mostrarcfrPedidoCompraImpor= mostrarcfrPedidoCompraImpor;
	}

	public Boolean getActivarcfrPedidoCompraImpor() {
		return this.activarcfrPedidoCompraImpor;
	}

	public void setActivarcfrPedidoCompraImpor(Boolean activarcfrPedidoCompraImpor) {
		this.activarcfrPedidoCompraImpor= activarcfrPedidoCompraImpor;
	}

	public Border setResaltarcifPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarcifPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcifPedidoCompraImpor() {
		return this.resaltarcifPedidoCompraImpor;
	}

	public void setResaltarcifPedidoCompraImpor(Border borderResaltar) {
		this.resaltarcifPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarcifPedidoCompraImpor() {
		return this.mostrarcifPedidoCompraImpor;
	}

	public void setMostrarcifPedidoCompraImpor(Boolean mostrarcifPedidoCompraImpor) {
		this.mostrarcifPedidoCompraImpor= mostrarcifPedidoCompraImpor;
	}

	public Boolean getActivarcifPedidoCompraImpor() {
		return this.activarcifPedidoCompraImpor;
	}

	public void setActivarcifPedidoCompraImpor(Boolean activarcifPedidoCompraImpor) {
		this.activarcifPedidoCompraImpor= activarcifPedidoCompraImpor;
	}

	public Border setResaltartotalPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltartotalPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalPedidoCompraImpor() {
		return this.resaltartotalPedidoCompraImpor;
	}

	public void setResaltartotalPedidoCompraImpor(Border borderResaltar) {
		this.resaltartotalPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrartotalPedidoCompraImpor() {
		return this.mostrartotalPedidoCompraImpor;
	}

	public void setMostrartotalPedidoCompraImpor(Boolean mostrartotalPedidoCompraImpor) {
		this.mostrartotalPedidoCompraImpor= mostrartotalPedidoCompraImpor;
	}

	public Boolean getActivartotalPedidoCompraImpor() {
		return this.activartotalPedidoCompraImpor;
	}

	public void setActivartotalPedidoCompraImpor(Boolean activartotalPedidoCompraImpor) {
		this.activartotalPedidoCompraImpor= activartotalPedidoCompraImpor;
	}

	public Border setResaltarid_formatoPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_formatoPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoPedidoCompraImpor() {
		return this.resaltarid_formatoPedidoCompraImpor;
	}

	public void setResaltarid_formatoPedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_formatoPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_formatoPedidoCompraImpor() {
		return this.mostrarid_formatoPedidoCompraImpor;
	}

	public void setMostrarid_formatoPedidoCompraImpor(Boolean mostrarid_formatoPedidoCompraImpor) {
		this.mostrarid_formatoPedidoCompraImpor= mostrarid_formatoPedidoCompraImpor;
	}

	public Boolean getActivarid_formatoPedidoCompraImpor() {
		return this.activarid_formatoPedidoCompraImpor;
	}

	public void setActivarid_formatoPedidoCompraImpor(Boolean activarid_formatoPedidoCompraImpor) {
		this.activarid_formatoPedidoCompraImpor= activarid_formatoPedidoCompraImpor;
	}

	public Boolean getCargarid_formatoPedidoCompraImpor() {
		return this.cargarid_formatoPedidoCompraImpor;
	}

	public void setCargarid_formatoPedidoCompraImpor(Boolean cargarid_formatoPedidoCompraImpor) {
		this.cargarid_formatoPedidoCompraImpor= cargarid_formatoPedidoCompraImpor;
	}

	public Border setResaltarid_anioPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_anioPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioPedidoCompraImpor() {
		return this.resaltarid_anioPedidoCompraImpor;
	}

	public void setResaltarid_anioPedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_anioPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_anioPedidoCompraImpor() {
		return this.mostrarid_anioPedidoCompraImpor;
	}

	public void setMostrarid_anioPedidoCompraImpor(Boolean mostrarid_anioPedidoCompraImpor) {
		this.mostrarid_anioPedidoCompraImpor= mostrarid_anioPedidoCompraImpor;
	}

	public Boolean getActivarid_anioPedidoCompraImpor() {
		return this.activarid_anioPedidoCompraImpor;
	}

	public void setActivarid_anioPedidoCompraImpor(Boolean activarid_anioPedidoCompraImpor) {
		this.activarid_anioPedidoCompraImpor= activarid_anioPedidoCompraImpor;
	}

	public Boolean getCargarid_anioPedidoCompraImpor() {
		return this.cargarid_anioPedidoCompraImpor;
	}

	public void setCargarid_anioPedidoCompraImpor(Boolean cargarid_anioPedidoCompraImpor) {
		this.cargarid_anioPedidoCompraImpor= cargarid_anioPedidoCompraImpor;
	}

	public Border setResaltarid_mesPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_mesPedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesPedidoCompraImpor() {
		return this.resaltarid_mesPedidoCompraImpor;
	}

	public void setResaltarid_mesPedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_mesPedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_mesPedidoCompraImpor() {
		return this.mostrarid_mesPedidoCompraImpor;
	}

	public void setMostrarid_mesPedidoCompraImpor(Boolean mostrarid_mesPedidoCompraImpor) {
		this.mostrarid_mesPedidoCompraImpor= mostrarid_mesPedidoCompraImpor;
	}

	public Boolean getActivarid_mesPedidoCompraImpor() {
		return this.activarid_mesPedidoCompraImpor;
	}

	public void setActivarid_mesPedidoCompraImpor(Boolean activarid_mesPedidoCompraImpor) {
		this.activarid_mesPedidoCompraImpor= activarid_mesPedidoCompraImpor;
	}

	public Boolean getCargarid_mesPedidoCompraImpor() {
		return this.cargarid_mesPedidoCompraImpor;
	}

	public void setCargarid_mesPedidoCompraImpor(Boolean cargarid_mesPedidoCompraImpor) {
		this.cargarid_mesPedidoCompraImpor= cargarid_mesPedidoCompraImpor;
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
		
		
		this.setMostraridPedidoCompraImpor(esInicial);
		this.setMostrarid_empresaPedidoCompraImpor(esInicial);
		this.setMostrarid_sucursalPedidoCompraImpor(esInicial);
		this.setMostrarid_moduloPedidoCompraImpor(esInicial);
		this.setMostrarid_ejercicioPedidoCompraImpor(esInicial);
		this.setMostrarid_periodoPedidoCompraImpor(esInicial);
		this.setMostrarid_paisPedidoCompraImpor(esInicial);
		this.setMostrarid_clientePedidoCompraImpor(esInicial);
		this.setMostrarid_cliente_proveedorPedidoCompraImpor(esInicial);
		this.setMostrarid_empleadoPedidoCompraImpor(esInicial);
		this.setMostrarid_usuarioPedidoCompraImpor(esInicial);
		this.setMostrarid_tipo_cambioPedidoCompraImpor(esInicial);
		this.setMostrarid_monedaPedidoCompraImpor(esInicial);
		this.setMostrarid_tipo_prorrateo_imporPedidoCompraImpor(esInicial);
		this.setMostrarid_embarcadorPedidoCompraImpor(esInicial);
		this.setMostrarid_tipo_via_transportePedidoCompraImpor(esInicial);
		this.setMostrarid_puertoPedidoCompraImpor(esInicial);
		this.setMostrarid_puerto_destinoPedidoCompraImpor(esInicial);
		this.setMostrarid_tipo_terminos_imporPedidoCompraImpor(esInicial);
		this.setMostrarid_estado_pedido_compraPedidoCompraImpor(esInicial);
		this.setMostrarforma_pagoPedidoCompraImpor(esInicial);
		this.setMostrarnumero_duiPedidoCompraImpor(esInicial);
		this.setMostrarsecuencialPedidoCompraImpor(esInicial);
		this.setMostrarnumero_ordenPedidoCompraImpor(esInicial);
		this.setMostraruso_enPedidoCompraImpor(esInicial);
		this.setMostrarresponsablePedidoCompraImpor(esInicial);
		this.setMostrarorden_compraPedidoCompraImpor(esInicial);
		this.setMostrarlugar_entregaPedidoCompraImpor(esInicial);
		this.setMostrardescripcionPedidoCompraImpor(esInicial);
		this.setMostrarfechaPedidoCompraImpor(esInicial);
		this.setMostrarfecha_emisionPedidoCompraImpor(esInicial);
		this.setMostrarfecha_entregaPedidoCompraImpor(esInicial);
		this.setMostrarfecha_entrega_clientePedidoCompraImpor(esInicial);
		this.setMostrarnombre_seguroPedidoCompraImpor(esInicial);
		this.setMostrarnombre_consignatarioPedidoCompraImpor(esInicial);
		this.setMostrarpreciosPedidoCompraImpor(esInicial);
		this.setMostrarfletePedidoCompraImpor(esInicial);
		this.setMostrarseguroPedidoCompraImpor(esInicial);
		this.setMostrargastosPedidoCompraImpor(esInicial);
		this.setMostrarcfrPedidoCompraImpor(esInicial);
		this.setMostrarcifPedidoCompraImpor(esInicial);
		this.setMostrartotalPedidoCompraImpor(esInicial);
		this.setMostrarid_formatoPedidoCompraImpor(esInicial);
		this.setMostrarid_anioPedidoCompraImpor(esInicial);
		this.setMostrarid_mesPedidoCompraImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.ID)) {
				this.setMostraridPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clientePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDCLIENTEPROVEEDOR)) {
				this.setMostrarid_cliente_proveedorPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDTIPOCAMBIO)) {
				this.setMostrarid_tipo_cambioPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDTIPOPRORRATEOIMPOR)) {
				this.setMostrarid_tipo_prorrateo_imporPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDEMBARCADOR)) {
				this.setMostrarid_embarcadorPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDTIPOVIATRANSPORTE)) {
				this.setMostrarid_tipo_via_transportePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDPUERTO)) {
				this.setMostrarid_puertoPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDPUERTODESTINO)) {
				this.setMostrarid_puerto_destinoPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDTIPOTERMINOSIMPOR)) {
				this.setMostrarid_tipo_terminos_imporPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDESTADOPEDIDOCOMPRA)) {
				this.setMostrarid_estado_pedido_compraPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.FORMAPAGO)) {
				this.setMostrarforma_pagoPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.NUMERODUI)) {
				this.setMostrarnumero_duiPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.NUMEROORDEN)) {
				this.setMostrarnumero_ordenPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.USOEN)) {
				this.setMostraruso_enPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.RESPONSABLE)) {
				this.setMostrarresponsablePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.ORDENCOMPRA)) {
				this.setMostrarorden_compraPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.LUGARENTREGA)) {
				this.setMostrarlugar_entregaPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.FECHA)) {
				this.setMostrarfechaPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.FECHAENTREGA)) {
				this.setMostrarfecha_entregaPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.FECHAENTREGACLIENTE)) {
				this.setMostrarfecha_entrega_clientePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.NOMBRESEGURO)) {
				this.setMostrarnombre_seguroPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.NOMBRECONSIGNATARIO)) {
				this.setMostrarnombre_consignatarioPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.PRECIOS)) {
				this.setMostrarpreciosPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.FLETE)) {
				this.setMostrarfletePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.SEGURO)) {
				this.setMostrarseguroPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.GASTOS)) {
				this.setMostrargastosPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.CFR)) {
				this.setMostrarcfrPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.CIF)) {
				this.setMostrarcifPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.TOTAL)) {
				this.setMostrartotalPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDMES)) {
				this.setMostrarid_mesPedidoCompraImpor(esAsigna);
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
		
		
		this.setActivaridPedidoCompraImpor(esInicial);
		this.setActivarid_empresaPedidoCompraImpor(esInicial);
		this.setActivarid_sucursalPedidoCompraImpor(esInicial);
		this.setActivarid_moduloPedidoCompraImpor(esInicial);
		this.setActivarid_ejercicioPedidoCompraImpor(esInicial);
		this.setActivarid_periodoPedidoCompraImpor(esInicial);
		this.setActivarid_paisPedidoCompraImpor(esInicial);
		this.setActivarid_clientePedidoCompraImpor(esInicial);
		this.setActivarid_cliente_proveedorPedidoCompraImpor(esInicial);
		this.setActivarid_empleadoPedidoCompraImpor(esInicial);
		this.setActivarid_usuarioPedidoCompraImpor(esInicial);
		this.setActivarid_tipo_cambioPedidoCompraImpor(esInicial);
		this.setActivarid_monedaPedidoCompraImpor(esInicial);
		this.setActivarid_tipo_prorrateo_imporPedidoCompraImpor(esInicial);
		this.setActivarid_embarcadorPedidoCompraImpor(esInicial);
		this.setActivarid_tipo_via_transportePedidoCompraImpor(esInicial);
		this.setActivarid_puertoPedidoCompraImpor(esInicial);
		this.setActivarid_puerto_destinoPedidoCompraImpor(esInicial);
		this.setActivarid_tipo_terminos_imporPedidoCompraImpor(esInicial);
		this.setActivarid_estado_pedido_compraPedidoCompraImpor(esInicial);
		this.setActivarforma_pagoPedidoCompraImpor(esInicial);
		this.setActivarnumero_duiPedidoCompraImpor(esInicial);
		this.setActivarsecuencialPedidoCompraImpor(esInicial);
		this.setActivarnumero_ordenPedidoCompraImpor(esInicial);
		this.setActivaruso_enPedidoCompraImpor(esInicial);
		this.setActivarresponsablePedidoCompraImpor(esInicial);
		this.setActivarorden_compraPedidoCompraImpor(esInicial);
		this.setActivarlugar_entregaPedidoCompraImpor(esInicial);
		this.setActivardescripcionPedidoCompraImpor(esInicial);
		this.setActivarfechaPedidoCompraImpor(esInicial);
		this.setActivarfecha_emisionPedidoCompraImpor(esInicial);
		this.setActivarfecha_entregaPedidoCompraImpor(esInicial);
		this.setActivarfecha_entrega_clientePedidoCompraImpor(esInicial);
		this.setActivarnombre_seguroPedidoCompraImpor(esInicial);
		this.setActivarnombre_consignatarioPedidoCompraImpor(esInicial);
		this.setActivarpreciosPedidoCompraImpor(esInicial);
		this.setActivarfletePedidoCompraImpor(esInicial);
		this.setActivarseguroPedidoCompraImpor(esInicial);
		this.setActivargastosPedidoCompraImpor(esInicial);
		this.setActivarcfrPedidoCompraImpor(esInicial);
		this.setActivarcifPedidoCompraImpor(esInicial);
		this.setActivartotalPedidoCompraImpor(esInicial);
		this.setActivarid_formatoPedidoCompraImpor(esInicial);
		this.setActivarid_anioPedidoCompraImpor(esInicial);
		this.setActivarid_mesPedidoCompraImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.ID)) {
				this.setActivaridPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clientePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDCLIENTEPROVEEDOR)) {
				this.setActivarid_cliente_proveedorPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDTIPOCAMBIO)) {
				this.setActivarid_tipo_cambioPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDTIPOPRORRATEOIMPOR)) {
				this.setActivarid_tipo_prorrateo_imporPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDEMBARCADOR)) {
				this.setActivarid_embarcadorPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDTIPOVIATRANSPORTE)) {
				this.setActivarid_tipo_via_transportePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDPUERTO)) {
				this.setActivarid_puertoPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDPUERTODESTINO)) {
				this.setActivarid_puerto_destinoPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDTIPOTERMINOSIMPOR)) {
				this.setActivarid_tipo_terminos_imporPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDESTADOPEDIDOCOMPRA)) {
				this.setActivarid_estado_pedido_compraPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.FORMAPAGO)) {
				this.setActivarforma_pagoPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.NUMERODUI)) {
				this.setActivarnumero_duiPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.NUMEROORDEN)) {
				this.setActivarnumero_ordenPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.USOEN)) {
				this.setActivaruso_enPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.RESPONSABLE)) {
				this.setActivarresponsablePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.ORDENCOMPRA)) {
				this.setActivarorden_compraPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.LUGARENTREGA)) {
				this.setActivarlugar_entregaPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.FECHA)) {
				this.setActivarfechaPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.FECHAENTREGA)) {
				this.setActivarfecha_entregaPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.FECHAENTREGACLIENTE)) {
				this.setActivarfecha_entrega_clientePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.NOMBRESEGURO)) {
				this.setActivarnombre_seguroPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.NOMBRECONSIGNATARIO)) {
				this.setActivarnombre_consignatarioPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.PRECIOS)) {
				this.setActivarpreciosPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.FLETE)) {
				this.setActivarfletePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.SEGURO)) {
				this.setActivarseguroPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.GASTOS)) {
				this.setActivargastosPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.CFR)) {
				this.setActivarcfrPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.CIF)) {
				this.setActivarcifPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.TOTAL)) {
				this.setActivartotalPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDANIO)) {
				this.setActivarid_anioPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDMES)) {
				this.setActivarid_mesPedidoCompraImpor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPedidoCompraImpor(esInicial);
		this.setResaltarid_empresaPedidoCompraImpor(esInicial);
		this.setResaltarid_sucursalPedidoCompraImpor(esInicial);
		this.setResaltarid_moduloPedidoCompraImpor(esInicial);
		this.setResaltarid_ejercicioPedidoCompraImpor(esInicial);
		this.setResaltarid_periodoPedidoCompraImpor(esInicial);
		this.setResaltarid_paisPedidoCompraImpor(esInicial);
		this.setResaltarid_clientePedidoCompraImpor(esInicial);
		this.setResaltarid_cliente_proveedorPedidoCompraImpor(esInicial);
		this.setResaltarid_empleadoPedidoCompraImpor(esInicial);
		this.setResaltarid_usuarioPedidoCompraImpor(esInicial);
		this.setResaltarid_tipo_cambioPedidoCompraImpor(esInicial);
		this.setResaltarid_monedaPedidoCompraImpor(esInicial);
		this.setResaltarid_tipo_prorrateo_imporPedidoCompraImpor(esInicial);
		this.setResaltarid_embarcadorPedidoCompraImpor(esInicial);
		this.setResaltarid_tipo_via_transportePedidoCompraImpor(esInicial);
		this.setResaltarid_puertoPedidoCompraImpor(esInicial);
		this.setResaltarid_puerto_destinoPedidoCompraImpor(esInicial);
		this.setResaltarid_tipo_terminos_imporPedidoCompraImpor(esInicial);
		this.setResaltarid_estado_pedido_compraPedidoCompraImpor(esInicial);
		this.setResaltarforma_pagoPedidoCompraImpor(esInicial);
		this.setResaltarnumero_duiPedidoCompraImpor(esInicial);
		this.setResaltarsecuencialPedidoCompraImpor(esInicial);
		this.setResaltarnumero_ordenPedidoCompraImpor(esInicial);
		this.setResaltaruso_enPedidoCompraImpor(esInicial);
		this.setResaltarresponsablePedidoCompraImpor(esInicial);
		this.setResaltarorden_compraPedidoCompraImpor(esInicial);
		this.setResaltarlugar_entregaPedidoCompraImpor(esInicial);
		this.setResaltardescripcionPedidoCompraImpor(esInicial);
		this.setResaltarfechaPedidoCompraImpor(esInicial);
		this.setResaltarfecha_emisionPedidoCompraImpor(esInicial);
		this.setResaltarfecha_entregaPedidoCompraImpor(esInicial);
		this.setResaltarfecha_entrega_clientePedidoCompraImpor(esInicial);
		this.setResaltarnombre_seguroPedidoCompraImpor(esInicial);
		this.setResaltarnombre_consignatarioPedidoCompraImpor(esInicial);
		this.setResaltarpreciosPedidoCompraImpor(esInicial);
		this.setResaltarfletePedidoCompraImpor(esInicial);
		this.setResaltarseguroPedidoCompraImpor(esInicial);
		this.setResaltargastosPedidoCompraImpor(esInicial);
		this.setResaltarcfrPedidoCompraImpor(esInicial);
		this.setResaltarcifPedidoCompraImpor(esInicial);
		this.setResaltartotalPedidoCompraImpor(esInicial);
		this.setResaltarid_formatoPedidoCompraImpor(esInicial);
		this.setResaltarid_anioPedidoCompraImpor(esInicial);
		this.setResaltarid_mesPedidoCompraImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.ID)) {
				this.setResaltaridPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clientePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDCLIENTEPROVEEDOR)) {
				this.setResaltarid_cliente_proveedorPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDTIPOCAMBIO)) {
				this.setResaltarid_tipo_cambioPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDTIPOPRORRATEOIMPOR)) {
				this.setResaltarid_tipo_prorrateo_imporPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDEMBARCADOR)) {
				this.setResaltarid_embarcadorPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDTIPOVIATRANSPORTE)) {
				this.setResaltarid_tipo_via_transportePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDPUERTO)) {
				this.setResaltarid_puertoPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDPUERTODESTINO)) {
				this.setResaltarid_puerto_destinoPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDTIPOTERMINOSIMPOR)) {
				this.setResaltarid_tipo_terminos_imporPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDESTADOPEDIDOCOMPRA)) {
				this.setResaltarid_estado_pedido_compraPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.FORMAPAGO)) {
				this.setResaltarforma_pagoPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.NUMERODUI)) {
				this.setResaltarnumero_duiPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.NUMEROORDEN)) {
				this.setResaltarnumero_ordenPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.USOEN)) {
				this.setResaltaruso_enPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.RESPONSABLE)) {
				this.setResaltarresponsablePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.ORDENCOMPRA)) {
				this.setResaltarorden_compraPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.LUGARENTREGA)) {
				this.setResaltarlugar_entregaPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.FECHA)) {
				this.setResaltarfechaPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.FECHAENTREGA)) {
				this.setResaltarfecha_entregaPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.FECHAENTREGACLIENTE)) {
				this.setResaltarfecha_entrega_clientePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.NOMBRESEGURO)) {
				this.setResaltarnombre_seguroPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.NOMBRECONSIGNATARIO)) {
				this.setResaltarnombre_consignatarioPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.PRECIOS)) {
				this.setResaltarpreciosPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.FLETE)) {
				this.setResaltarfletePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.SEGURO)) {
				this.setResaltarseguroPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.GASTOS)) {
				this.setResaltargastosPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.CFR)) {
				this.setResaltarcfrPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.CIF)) {
				this.setResaltarcifPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.TOTAL)) {
				this.setResaltartotalPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioPedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraImporConstantesFunciones.IDMES)) {
				this.setResaltarid_mesPedidoCompraImpor(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetallePedidoCompraImporPedidoCompraImpor=null;

	public Border getResaltarDetallePedidoCompraImporPedidoCompraImpor() {
		return this.resaltarDetallePedidoCompraImporPedidoCompraImpor;
	}

	public void setResaltarDetallePedidoCompraImporPedidoCompraImpor(Border borderResaltarDetallePedidoCompraImpor) {
		if(borderResaltarDetallePedidoCompraImpor!=null) {
			this.resaltarDetallePedidoCompraImporPedidoCompraImpor= borderResaltarDetallePedidoCompraImpor;
		}
	}

	public Border setResaltarDetallePedidoCompraImporPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltarDetallePedidoCompraImpor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltarDetallePedidoCompraImpor);
			
		this.resaltarDetallePedidoCompraImporPedidoCompraImpor= borderResaltarDetallePedidoCompraImpor;

		 return borderResaltarDetallePedidoCompraImpor;
	}



	public Boolean mostrarDetallePedidoCompraImporPedidoCompraImpor=true;

	public Boolean getMostrarDetallePedidoCompraImporPedidoCompraImpor() {
		return this.mostrarDetallePedidoCompraImporPedidoCompraImpor;
	}

	public void setMostrarDetallePedidoCompraImporPedidoCompraImpor(Boolean visibilidadResaltarDetallePedidoCompraImpor) {
		this.mostrarDetallePedidoCompraImporPedidoCompraImpor= visibilidadResaltarDetallePedidoCompraImpor;
	}



	public Boolean activarDetallePedidoCompraImporPedidoCompraImpor=true;

	public Boolean gethabilitarResaltarDetallePedidoCompraImporPedidoCompraImpor() {
		return this.activarDetallePedidoCompraImporPedidoCompraImpor;
	}

	public void setActivarDetallePedidoCompraImporPedidoCompraImpor(Boolean habilitarResaltarDetallePedidoCompraImpor) {
		this.activarDetallePedidoCompraImporPedidoCompraImpor= habilitarResaltarDetallePedidoCompraImpor;
	}


	public Border resaltarLiquidacionImpuestoImporPedidoCompraImpor=null;

	public Border getResaltarLiquidacionImpuestoImporPedidoCompraImpor() {
		return this.resaltarLiquidacionImpuestoImporPedidoCompraImpor;
	}

	public void setResaltarLiquidacionImpuestoImporPedidoCompraImpor(Border borderResaltarLiquidacionImpuestoImpor) {
		if(borderResaltarLiquidacionImpuestoImpor!=null) {
			this.resaltarLiquidacionImpuestoImporPedidoCompraImpor= borderResaltarLiquidacionImpuestoImpor;
		}
	}

	public Border setResaltarLiquidacionImpuestoImporPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltarLiquidacionImpuestoImpor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//pedidocompraimporBeanSwingJInternalFrame.jTtoolBarPedidoCompraImpor.setBorder(borderResaltarLiquidacionImpuestoImpor);
			
		this.resaltarLiquidacionImpuestoImporPedidoCompraImpor= borderResaltarLiquidacionImpuestoImpor;

		 return borderResaltarLiquidacionImpuestoImpor;
	}



	public Boolean mostrarLiquidacionImpuestoImporPedidoCompraImpor=true;

	public Boolean getMostrarLiquidacionImpuestoImporPedidoCompraImpor() {
		return this.mostrarLiquidacionImpuestoImporPedidoCompraImpor;
	}

	public void setMostrarLiquidacionImpuestoImporPedidoCompraImpor(Boolean visibilidadResaltarLiquidacionImpuestoImpor) {
		this.mostrarLiquidacionImpuestoImporPedidoCompraImpor= visibilidadResaltarLiquidacionImpuestoImpor;
	}



	public Boolean activarLiquidacionImpuestoImporPedidoCompraImpor=true;

	public Boolean gethabilitarResaltarLiquidacionImpuestoImporPedidoCompraImpor() {
		return this.activarLiquidacionImpuestoImporPedidoCompraImpor;
	}

	public void setActivarLiquidacionImpuestoImporPedidoCompraImpor(Boolean habilitarResaltarLiquidacionImpuestoImpor) {
		this.activarLiquidacionImpuestoImporPedidoCompraImpor= habilitarResaltarLiquidacionImpuestoImpor;
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

		this.setMostrarDetallePedidoCompraImporPedidoCompraImpor(esInicial);
		this.setMostrarLiquidacionImpuestoImporPedidoCompraImpor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetallePedidoCompraImpor.class)) {
				this.setMostrarDetallePedidoCompraImporPedidoCompraImpor(esAsigna);
				continue;
			}

			if(clase.clas.equals(LiquidacionImpuestoImpor.class)) {
				this.setMostrarLiquidacionImpuestoImporPedidoCompraImpor(esAsigna);
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

		this.setActivarDetallePedidoCompraImporPedidoCompraImpor(esInicial);
		this.setActivarLiquidacionImpuestoImporPedidoCompraImpor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetallePedidoCompraImpor.class)) {
				this.setActivarDetallePedidoCompraImporPedidoCompraImpor(esAsigna);
				continue;
			}

			if(clase.clas.equals(LiquidacionImpuestoImpor.class)) {
				this.setActivarLiquidacionImpuestoImporPedidoCompraImpor(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetallePedidoCompraImporPedidoCompraImpor(esInicial);
		this.setResaltarLiquidacionImpuestoImporPedidoCompraImpor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetallePedidoCompraImpor.class)) {
				this.setResaltarDetallePedidoCompraImporPedidoCompraImpor(esAsigna);
				continue;
			}

			if(clase.clas.equals(LiquidacionImpuestoImpor.class)) {
				this.setResaltarLiquidacionImpuestoImporPedidoCompraImpor(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdClientePedidoCompraImpor=true;

	public Boolean getMostrarFK_IdClientePedidoCompraImpor() {
		return this.mostrarFK_IdClientePedidoCompraImpor;
	}

	public void setMostrarFK_IdClientePedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClientePedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteProveedorPedidoCompraImpor=true;

	public Boolean getMostrarFK_IdClienteProveedorPedidoCompraImpor() {
		return this.mostrarFK_IdClienteProveedorPedidoCompraImpor;
	}

	public void setMostrarFK_IdClienteProveedorPedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteProveedorPedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioPedidoCompraImpor=true;

	public Boolean getMostrarFK_IdEjercicioPedidoCompraImpor() {
		return this.mostrarFK_IdEjercicioPedidoCompraImpor;
	}

	public void setMostrarFK_IdEjercicioPedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioPedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmbarcadorPedidoCompraImpor=true;

	public Boolean getMostrarFK_IdEmbarcadorPedidoCompraImpor() {
		return this.mostrarFK_IdEmbarcadorPedidoCompraImpor;
	}

	public void setMostrarFK_IdEmbarcadorPedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmbarcadorPedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoPedidoCompraImpor=true;

	public Boolean getMostrarFK_IdEmpleadoPedidoCompraImpor() {
		return this.mostrarFK_IdEmpleadoPedidoCompraImpor;
	}

	public void setMostrarFK_IdEmpleadoPedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoPedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPedidoCompraImpor=true;

	public Boolean getMostrarFK_IdEmpresaPedidoCompraImpor() {
		return this.mostrarFK_IdEmpresaPedidoCompraImpor;
	}

	public void setMostrarFK_IdEmpresaPedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompraImpor=true;

	public Boolean getMostrarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompraImpor() {
		return this.mostrarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompraImpor;
	}

	public void setMostrarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloPedidoCompraImpor=true;

	public Boolean getMostrarFK_IdModuloPedidoCompraImpor() {
		return this.mostrarFK_IdModuloPedidoCompraImpor;
	}

	public void setMostrarFK_IdModuloPedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloPedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisPedidoCompraImpor=true;

	public Boolean getMostrarFK_IdPaisPedidoCompraImpor() {
		return this.mostrarFK_IdPaisPedidoCompraImpor;
	}

	public void setMostrarFK_IdPaisPedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisPedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoPedidoCompraImpor=true;

	public Boolean getMostrarFK_IdPeriodoPedidoCompraImpor() {
		return this.mostrarFK_IdPeriodoPedidoCompraImpor;
	}

	public void setMostrarFK_IdPeriodoPedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoPedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPuertoPedidoCompraImpor=true;

	public Boolean getMostrarFK_IdPuertoPedidoCompraImpor() {
		return this.mostrarFK_IdPuertoPedidoCompraImpor;
	}

	public void setMostrarFK_IdPuertoPedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPuertoPedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPuertoDestinoPedidoCompraImpor=true;

	public Boolean getMostrarFK_IdPuertoDestinoPedidoCompraImpor() {
		return this.mostrarFK_IdPuertoDestinoPedidoCompraImpor;
	}

	public void setMostrarFK_IdPuertoDestinoPedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPuertoDestinoPedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalPedidoCompraImpor=true;

	public Boolean getMostrarFK_IdSucursalPedidoCompraImpor() {
		return this.mostrarFK_IdSucursalPedidoCompraImpor;
	}

	public void setMostrarFK_IdSucursalPedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalPedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProrrateoImporPedidoCompraImpor=true;

	public Boolean getMostrarFK_IdTipoProrrateoImporPedidoCompraImpor() {
		return this.mostrarFK_IdTipoProrrateoImporPedidoCompraImpor;
	}

	public void setMostrarFK_IdTipoProrrateoImporPedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProrrateoImporPedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTerminosImporPedidoCompraImpor=true;

	public Boolean getMostrarFK_IdTipoTerminosImporPedidoCompraImpor() {
		return this.mostrarFK_IdTipoTerminosImporPedidoCompraImpor;
	}

	public void setMostrarFK_IdTipoTerminosImporPedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTerminosImporPedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoViaTransportePedidoCompraImpor=true;

	public Boolean getMostrarFK_IdTipoViaTransportePedidoCompraImpor() {
		return this.mostrarFK_IdTipoViaTransportePedidoCompraImpor;
	}

	public void setMostrarFK_IdTipoViaTransportePedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoViaTransportePedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioPedidoCompraImpor=true;

	public Boolean getMostrarFK_IdUsuarioPedidoCompraImpor() {
		return this.mostrarFK_IdUsuarioPedidoCompraImpor;
	}

	public void setMostrarFK_IdUsuarioPedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioPedidoCompraImpor= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClientePedidoCompraImpor=true;

	public Boolean getActivarFK_IdClientePedidoCompraImpor() {
		return this.activarFK_IdClientePedidoCompraImpor;
	}

	public void setActivarFK_IdClientePedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdClientePedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteProveedorPedidoCompraImpor=true;

	public Boolean getActivarFK_IdClienteProveedorPedidoCompraImpor() {
		return this.activarFK_IdClienteProveedorPedidoCompraImpor;
	}

	public void setActivarFK_IdClienteProveedorPedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdClienteProveedorPedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioPedidoCompraImpor=true;

	public Boolean getActivarFK_IdEjercicioPedidoCompraImpor() {
		return this.activarFK_IdEjercicioPedidoCompraImpor;
	}

	public void setActivarFK_IdEjercicioPedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioPedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdEmbarcadorPedidoCompraImpor=true;

	public Boolean getActivarFK_IdEmbarcadorPedidoCompraImpor() {
		return this.activarFK_IdEmbarcadorPedidoCompraImpor;
	}

	public void setActivarFK_IdEmbarcadorPedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdEmbarcadorPedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoPedidoCompraImpor=true;

	public Boolean getActivarFK_IdEmpleadoPedidoCompraImpor() {
		return this.activarFK_IdEmpleadoPedidoCompraImpor;
	}

	public void setActivarFK_IdEmpleadoPedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoPedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPedidoCompraImpor=true;

	public Boolean getActivarFK_IdEmpresaPedidoCompraImpor() {
		return this.activarFK_IdEmpresaPedidoCompraImpor;
	}

	public void setActivarFK_IdEmpresaPedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompraImpor=true;

	public Boolean getActivarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompraImpor() {
		return this.activarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompraImpor;
	}

	public void setActivarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloPedidoCompraImpor=true;

	public Boolean getActivarFK_IdModuloPedidoCompraImpor() {
		return this.activarFK_IdModuloPedidoCompraImpor;
	}

	public void setActivarFK_IdModuloPedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdModuloPedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisPedidoCompraImpor=true;

	public Boolean getActivarFK_IdPaisPedidoCompraImpor() {
		return this.activarFK_IdPaisPedidoCompraImpor;
	}

	public void setActivarFK_IdPaisPedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdPaisPedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoPedidoCompraImpor=true;

	public Boolean getActivarFK_IdPeriodoPedidoCompraImpor() {
		return this.activarFK_IdPeriodoPedidoCompraImpor;
	}

	public void setActivarFK_IdPeriodoPedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoPedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdPuertoPedidoCompraImpor=true;

	public Boolean getActivarFK_IdPuertoPedidoCompraImpor() {
		return this.activarFK_IdPuertoPedidoCompraImpor;
	}

	public void setActivarFK_IdPuertoPedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdPuertoPedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdPuertoDestinoPedidoCompraImpor=true;

	public Boolean getActivarFK_IdPuertoDestinoPedidoCompraImpor() {
		return this.activarFK_IdPuertoDestinoPedidoCompraImpor;
	}

	public void setActivarFK_IdPuertoDestinoPedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdPuertoDestinoPedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalPedidoCompraImpor=true;

	public Boolean getActivarFK_IdSucursalPedidoCompraImpor() {
		return this.activarFK_IdSucursalPedidoCompraImpor;
	}

	public void setActivarFK_IdSucursalPedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalPedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProrrateoImporPedidoCompraImpor=true;

	public Boolean getActivarFK_IdTipoProrrateoImporPedidoCompraImpor() {
		return this.activarFK_IdTipoProrrateoImporPedidoCompraImpor;
	}

	public void setActivarFK_IdTipoProrrateoImporPedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProrrateoImporPedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTerminosImporPedidoCompraImpor=true;

	public Boolean getActivarFK_IdTipoTerminosImporPedidoCompraImpor() {
		return this.activarFK_IdTipoTerminosImporPedidoCompraImpor;
	}

	public void setActivarFK_IdTipoTerminosImporPedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTerminosImporPedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoViaTransportePedidoCompraImpor=true;

	public Boolean getActivarFK_IdTipoViaTransportePedidoCompraImpor() {
		return this.activarFK_IdTipoViaTransportePedidoCompraImpor;
	}

	public void setActivarFK_IdTipoViaTransportePedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdTipoViaTransportePedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioPedidoCompraImpor=true;

	public Boolean getActivarFK_IdUsuarioPedidoCompraImpor() {
		return this.activarFK_IdUsuarioPedidoCompraImpor;
	}

	public void setActivarFK_IdUsuarioPedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioPedidoCompraImpor= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClientePedidoCompraImpor=null;

	public Border getResaltarFK_IdClientePedidoCompraImpor() {
		return this.resaltarFK_IdClientePedidoCompraImpor;
	}

	public void setResaltarFK_IdClientePedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdClientePedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdClientePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClientePedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdClienteProveedorPedidoCompraImpor=null;

	public Border getResaltarFK_IdClienteProveedorPedidoCompraImpor() {
		return this.resaltarFK_IdClienteProveedorPedidoCompraImpor;
	}

	public void setResaltarFK_IdClienteProveedorPedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdClienteProveedorPedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdClienteProveedorPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteProveedorPedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioPedidoCompraImpor=null;

	public Border getResaltarFK_IdEjercicioPedidoCompraImpor() {
		return this.resaltarFK_IdEjercicioPedidoCompraImpor;
	}

	public void setResaltarFK_IdEjercicioPedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdEjercicioPedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioPedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdEmbarcadorPedidoCompraImpor=null;

	public Border getResaltarFK_IdEmbarcadorPedidoCompraImpor() {
		return this.resaltarFK_IdEmbarcadorPedidoCompraImpor;
	}

	public void setResaltarFK_IdEmbarcadorPedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdEmbarcadorPedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdEmbarcadorPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmbarcadorPedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoPedidoCompraImpor=null;

	public Border getResaltarFK_IdEmpleadoPedidoCompraImpor() {
		return this.resaltarFK_IdEmpleadoPedidoCompraImpor;
	}

	public void setResaltarFK_IdEmpleadoPedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoPedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoPedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPedidoCompraImpor=null;

	public Border getResaltarFK_IdEmpresaPedidoCompraImpor() {
		return this.resaltarFK_IdEmpresaPedidoCompraImpor;
	}

	public void setResaltarFK_IdEmpresaPedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompraImpor=null;

	public Border getResaltarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompraImpor() {
		return this.resaltarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompraImpor;
	}

	public void setResaltarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdModuloPedidoCompraImpor=null;

	public Border getResaltarFK_IdModuloPedidoCompraImpor() {
		return this.resaltarFK_IdModuloPedidoCompraImpor;
	}

	public void setResaltarFK_IdModuloPedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdModuloPedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdModuloPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloPedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdPaisPedidoCompraImpor=null;

	public Border getResaltarFK_IdPaisPedidoCompraImpor() {
		return this.resaltarFK_IdPaisPedidoCompraImpor;
	}

	public void setResaltarFK_IdPaisPedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdPaisPedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdPaisPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisPedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoPedidoCompraImpor=null;

	public Border getResaltarFK_IdPeriodoPedidoCompraImpor() {
		return this.resaltarFK_IdPeriodoPedidoCompraImpor;
	}

	public void setResaltarFK_IdPeriodoPedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdPeriodoPedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoPedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdPuertoPedidoCompraImpor=null;

	public Border getResaltarFK_IdPuertoPedidoCompraImpor() {
		return this.resaltarFK_IdPuertoPedidoCompraImpor;
	}

	public void setResaltarFK_IdPuertoPedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdPuertoPedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdPuertoPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPuertoPedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdPuertoDestinoPedidoCompraImpor=null;

	public Border getResaltarFK_IdPuertoDestinoPedidoCompraImpor() {
		return this.resaltarFK_IdPuertoDestinoPedidoCompraImpor;
	}

	public void setResaltarFK_IdPuertoDestinoPedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdPuertoDestinoPedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdPuertoDestinoPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPuertoDestinoPedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdSucursalPedidoCompraImpor=null;

	public Border getResaltarFK_IdSucursalPedidoCompraImpor() {
		return this.resaltarFK_IdSucursalPedidoCompraImpor;
	}

	public void setResaltarFK_IdSucursalPedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdSucursalPedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdSucursalPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalPedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdTipoProrrateoImporPedidoCompraImpor=null;

	public Border getResaltarFK_IdTipoProrrateoImporPedidoCompraImpor() {
		return this.resaltarFK_IdTipoProrrateoImporPedidoCompraImpor;
	}

	public void setResaltarFK_IdTipoProrrateoImporPedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdTipoProrrateoImporPedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdTipoProrrateoImporPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProrrateoImporPedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdTipoTerminosImporPedidoCompraImpor=null;

	public Border getResaltarFK_IdTipoTerminosImporPedidoCompraImpor() {
		return this.resaltarFK_IdTipoTerminosImporPedidoCompraImpor;
	}

	public void setResaltarFK_IdTipoTerminosImporPedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdTipoTerminosImporPedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdTipoTerminosImporPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTerminosImporPedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdTipoViaTransportePedidoCompraImpor=null;

	public Border getResaltarFK_IdTipoViaTransportePedidoCompraImpor() {
		return this.resaltarFK_IdTipoViaTransportePedidoCompraImpor;
	}

	public void setResaltarFK_IdTipoViaTransportePedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdTipoViaTransportePedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdTipoViaTransportePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoViaTransportePedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioPedidoCompraImpor=null;

	public Border getResaltarFK_IdUsuarioPedidoCompraImpor() {
		return this.resaltarFK_IdUsuarioPedidoCompraImpor;
	}

	public void setResaltarFK_IdUsuarioPedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdUsuarioPedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioPedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraImporBeanSwingJInternalFrame pedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioPedidoCompraImpor= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}