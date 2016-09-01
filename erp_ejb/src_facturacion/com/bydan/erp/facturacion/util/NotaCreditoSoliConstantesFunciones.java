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


import com.bydan.erp.facturacion.util.NotaCreditoSoliConstantesFunciones;
import com.bydan.erp.facturacion.util.NotaCreditoSoliParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.NotaCreditoSoliParameterGeneral;

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
final public class NotaCreditoSoliConstantesFunciones extends NotaCreditoSoliConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="NotaCreditoSoli";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="NotaCreditoSoli"+NotaCreditoSoliConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="NotaCreditoSoliHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="NotaCreditoSoliHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=NotaCreditoSoliConstantesFunciones.SCHEMA+"_"+NotaCreditoSoliConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/NotaCreditoSoliHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=NotaCreditoSoliConstantesFunciones.SCHEMA+"_"+NotaCreditoSoliConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=NotaCreditoSoliConstantesFunciones.SCHEMA+"_"+NotaCreditoSoliConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/NotaCreditoSoliHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=NotaCreditoSoliConstantesFunciones.SCHEMA+"_"+NotaCreditoSoliConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NotaCreditoSoliConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NotaCreditoSoliHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NotaCreditoSoliConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NotaCreditoSoliConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NotaCreditoSoliHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NotaCreditoSoliConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=NotaCreditoSoliConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+NotaCreditoSoliConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=NotaCreditoSoliConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+NotaCreditoSoliConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Solicitud Nota Creditos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Solicitud Nota Credito";
	public static final String SCLASSWEBTITULO_LOWER="Nota Credito Soli";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="NotaCreditoSoli";
	public static final String OBJECTNAME="notacreditosoli";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="nota_credito_soli";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select notacreditosoli from "+NotaCreditoSoliConstantesFunciones.SPERSISTENCENAME+" notacreditosoli";
	public static String QUERYSELECTNATIVE="select "+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".version_row,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_empresa,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_sucursal,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_ejercicio,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_periodo,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_anio,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_mes,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_usuario,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".codigo,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".numero,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".fecha_emision,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".numero_dias,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".fecha_vencimiento,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_moneda,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_empleado,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".cotizacion,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_formato,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_tipo_precio,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_cliente,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_factura,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".direccion,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".telefono,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".ruc,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_tipo_nota_credito_soli,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_responsable,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_estado_nota_credito,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".descripcion,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".penalizado,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".descuento_porcentaje,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".total_iva,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".suman,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".descuento_valor,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".total_sin_iva,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".descuento_general,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".flete,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".total,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".sub_total,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".otro,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".iva,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".financiamiento,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".otro_valor,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".retencion,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".ice,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".fecha,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_centro_costo,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_vendedor,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_tipo_cambio,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_transporte,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_transportista,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".fecha_cliente,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".fecha_autorizacion from "+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME;//+" as "+NotaCreditoSoliConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected NotaCreditoSoliConstantesFuncionesAdditional notacreditosoliConstantesFuncionesAdditional=null;
	
	public NotaCreditoSoliConstantesFuncionesAdditional getNotaCreditoSoliConstantesFuncionesAdditional() {
		return this.notacreditosoliConstantesFuncionesAdditional;
	}
	
	public void setNotaCreditoSoliConstantesFuncionesAdditional(NotaCreditoSoliConstantesFuncionesAdditional notacreditosoliConstantesFuncionesAdditional) {
		try {
			this.notacreditosoliConstantesFuncionesAdditional=notacreditosoliConstantesFuncionesAdditional;
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
    public static final String CODIGO= "codigo";
    public static final String NUMEROPREIMPRESO= "numero";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String NUMERODIAS= "numero_dias";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String IDMONEDA= "id_moneda";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String COTIZACION= "cotizacion";
    public static final String IDFORMATO= "id_formato";
    public static final String IDTIPOPRECIO= "id_tipo_precio";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDFACTURA= "id_factura";
    public static final String DIRECCION= "direccion";
    public static final String TELEFONO= "telefono";
    public static final String RUC= "ruc";
    public static final String IDTIPONOTACREDITOSOLI= "id_tipo_nota_credito_soli";
    public static final String IDRESPONSABLE= "id_responsable";
    public static final String IDESTADONOTACREDITOSOLI= "id_estado_nota_credito";
    public static final String DESCRIPCION= "descripcion";
    public static final String PENALIZADO= "penalizado";
    public static final String DESCUENTOPORCENTAJE= "descuento_porcentaje";
    public static final String TOTALIVA= "total_iva";
    public static final String SUMAN= "suman";
    public static final String DESCUENTOVALOR= "descuento_valor";
    public static final String TOTALSINIVA= "total_sin_iva";
    public static final String DESCUENTOGENERAL= "descuento_general";
    public static final String FLETE= "flete";
    public static final String TOTAL= "total";
    public static final String SUBTOTAL= "sub_total";
    public static final String OTRO= "otro";
    public static final String IVA= "iva";
    public static final String FINANCIAMIENTO= "financiamiento";
    public static final String OTROVALOR= "otro_valor";
    public static final String RETENCION= "retencion";
    public static final String ICE= "ice";
    public static final String FECHA= "fecha";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String IDTIPOCAMBIO= "id_tipo_cambio";
    public static final String IDTRANSPORTE= "id_transporte";
    public static final String IDTRANSPORTISTA= "id_transportista";
    public static final String FECHACLIENTE= "fecha_cliente";
    public static final String FECHAAUTORIZACION= "fecha_autorizacion";
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
    	public static final String LABEL_CODIGO= "Numero";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NUMEROPREIMPRESO= "Nro Preimpreso";
		public static final String LABEL_NUMEROPREIMPRESO_LOWER= "Numero Pre Impreso";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_NUMERODIAS= "Dias";
		public static final String LABEL_NUMERODIAS_LOWER= "Numero Dias";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_COTIZACION= "Cotizacion";
		public static final String LABEL_COTIZACION_LOWER= "Cotizacion";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_IDTIPOPRECIO= "Tipo Precio";
		public static final String LABEL_IDTIPOPRECIO_LOWER= "Tipo Precio";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_IDTIPONOTACREDITOSOLI= "Tipo";
		public static final String LABEL_IDTIPONOTACREDITOSOLI_LOWER= "Tipo Nota Credito Soli";
    	public static final String LABEL_IDRESPONSABLE= "Responsable";
		public static final String LABEL_IDRESPONSABLE_LOWER= "Responsable";
    	public static final String LABEL_IDESTADONOTACREDITOSOLI= "Estado";
		public static final String LABEL_IDESTADONOTACREDITOSOLI_LOWER= "Estado Nota Credito Soli";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_PENALIZADO= "Penalizado";
		public static final String LABEL_PENALIZADO_LOWER= "Penalizado";
    	public static final String LABEL_DESCUENTOPORCENTAJE= "Dscto %";
		public static final String LABEL_DESCUENTOPORCENTAJE_LOWER= "Descuento Porcentaje";
    	public static final String LABEL_TOTALIVA= "Monto Con Iva";
		public static final String LABEL_TOTALIVA_LOWER= "Total Iva";
    	public static final String LABEL_SUMAN= "Suman";
		public static final String LABEL_SUMAN_LOWER= "Suman";
    	public static final String LABEL_DESCUENTOVALOR= "Dsto Valor";
		public static final String LABEL_DESCUENTOVALOR_LOWER= "Descuento Valor";
    	public static final String LABEL_TOTALSINIVA= "Monto Sin Iva";
		public static final String LABEL_TOTALSINIVA_LOWER= "Total Sin Iva";
    	public static final String LABEL_DESCUENTOGENERAL= "Total Dscto General";
		public static final String LABEL_DESCUENTOGENERAL_LOWER= "Descuento General";
    	public static final String LABEL_FLETE= "Flete";
		public static final String LABEL_FLETE_LOWER= "Flete";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_SUBTOTAL= "Sub Total";
		public static final String LABEL_SUBTOTAL_LOWER= "Sub Total";
    	public static final String LABEL_OTRO= "Otro";
		public static final String LABEL_OTRO_LOWER= "Otro";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_FINANCIAMIENTO= "Financiamiento";
		public static final String LABEL_FINANCIAMIENTO_LOWER= "Financiamiento";
    	public static final String LABEL_OTROVALOR= "Otro Valor";
		public static final String LABEL_OTROVALOR_LOWER= "Otro Valor";
    	public static final String LABEL_RETENCION= "Retencion";
		public static final String LABEL_RETENCION_LOWER= "Retencion";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_IDTIPOCAMBIO= "Tipo Cambio";
		public static final String LABEL_IDTIPOCAMBIO_LOWER= "Tipo Cambio";
    	public static final String LABEL_IDTRANSPORTE= "Transporte";
		public static final String LABEL_IDTRANSPORTE_LOWER= "Transporte";
    	public static final String LABEL_IDTRANSPORTISTA= "Transportista";
		public static final String LABEL_IDTRANSPORTISTA_LOWER= "Transportista";
    	public static final String LABEL_FECHACLIENTE= "Fecha Cliente";
		public static final String LABEL_FECHACLIENTE_LOWER= "Fecha Cliente";
    	public static final String LABEL_FECHAAUTORIZACION= "Fecha Autorizacion";
		public static final String LABEL_FECHAAUTORIZACION_LOWER= "Fecha Autorizacion";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getNotaCreditoSoliLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.IDEMPRESA)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.IDSUCURSAL)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.IDEJERCICIO)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.IDPERIODO)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.IDANIO)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.IDMES)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.IDUSUARIO)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.CODIGO)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.NUMEROPREIMPRESO)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_NUMEROPREIMPRESO;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.FECHAEMISION)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.NUMERODIAS)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_NUMERODIAS;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.IDMONEDA)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.IDEMPLEADO)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.COTIZACION)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_COTIZACION;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.IDFORMATO)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.IDTIPOPRECIO)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_IDTIPOPRECIO;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.IDCLIENTE)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.IDFACTURA)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.DIRECCION)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.TELEFONO)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.RUC)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.IDTIPONOTACREDITOSOLI)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_IDTIPONOTACREDITOSOLI;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.IDRESPONSABLE)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_IDRESPONSABLE;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.IDESTADONOTACREDITOSOLI)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_IDESTADONOTACREDITOSOLI;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.DESCRIPCION)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.PENALIZADO)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_PENALIZADO;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.DESCUENTOPORCENTAJE)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_DESCUENTOPORCENTAJE;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.TOTALIVA)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_TOTALIVA;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.SUMAN)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_SUMAN;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.DESCUENTOVALOR)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_DESCUENTOVALOR;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.TOTALSINIVA)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_TOTALSINIVA;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.DESCUENTOGENERAL)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_DESCUENTOGENERAL;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.FLETE)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.TOTAL)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.SUBTOTAL)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.OTRO)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_OTRO;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.IVA)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.FINANCIAMIENTO)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_FINANCIAMIENTO;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.OTROVALOR)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_OTROVALOR;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.RETENCION)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_RETENCION;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.ICE)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.FECHA)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.IDVENDEDOR)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.IDTIPOCAMBIO)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_IDTIPOCAMBIO;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.IDTRANSPORTE)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_IDTRANSPORTE;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.IDTRANSPORTISTA)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_IDTRANSPORTISTA;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.FECHACLIENTE)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_FECHACLIENTE;}
		if(sNombreColumna.equals(NotaCreditoSoliConstantesFunciones.FECHAAUTORIZACION)) {sLabelColumna=NotaCreditoSoliConstantesFunciones.LABEL_FECHAAUTORIZACION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getpenalizadoDescripcion(NotaCreditoSoli notacreditosoli) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!notacreditosoli.getpenalizado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getpenalizadoHtmlDescripcion(NotaCreditoSoli notacreditosoli) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(notacreditosoli.getId(),notacreditosoli.getpenalizado());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getNotaCreditoSoliDescripcion(NotaCreditoSoli notacreditosoli) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(notacreditosoli !=null/* && notacreditosoli.getId()!=0*/) {
			sDescripcion=notacreditosoli.getcodigo();//notacreditosolinotacreditosoli.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getNotaCreditoSoliDescripcionDetallado(NotaCreditoSoli notacreditosoli) {
		String sDescripcion="";
			
		sDescripcion+=NotaCreditoSoliConstantesFunciones.ID+"=";
		sDescripcion+=notacreditosoli.getId().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=notacreditosoli.getVersionRow().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=notacreditosoli.getid_empresa().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=notacreditosoli.getid_sucursal().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=notacreditosoli.getid_ejercicio().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=notacreditosoli.getid_periodo().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.IDANIO+"=";
		sDescripcion+=notacreditosoli.getid_anio().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.IDMES+"=";
		sDescripcion+=notacreditosoli.getid_mes().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=notacreditosoli.getid_usuario().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.CODIGO+"=";
		sDescripcion+=notacreditosoli.getcodigo()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.NUMEROPREIMPRESO+"=";
		sDescripcion+=notacreditosoli.getnumero()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=notacreditosoli.getfecha_emision().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.NUMERODIAS+"=";
		sDescripcion+=notacreditosoli.getnumero_dias().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=notacreditosoli.getfecha_vencimiento().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=notacreditosoli.getid_moneda().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=notacreditosoli.getid_empleado().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.COTIZACION+"=";
		sDescripcion+=notacreditosoli.getcotizacion().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=notacreditosoli.getid_formato().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.IDTIPOPRECIO+"=";
		sDescripcion+=notacreditosoli.getid_tipo_precio().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=notacreditosoli.getid_cliente().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=notacreditosoli.getid_factura().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.DIRECCION+"=";
		sDescripcion+=notacreditosoli.getdireccion()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.TELEFONO+"=";
		sDescripcion+=notacreditosoli.gettelefono()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.RUC+"=";
		sDescripcion+=notacreditosoli.getruc()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.IDTIPONOTACREDITOSOLI+"=";
		sDescripcion+=notacreditosoli.getid_tipo_nota_credito_soli().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.IDRESPONSABLE+"=";
		sDescripcion+=notacreditosoli.getid_responsable().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.IDESTADONOTACREDITOSOLI+"=";
		sDescripcion+=notacreditosoli.getid_estado_nota_credito().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=notacreditosoli.getdescripcion()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.PENALIZADO+"=";
		sDescripcion+=notacreditosoli.getpenalizado().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.DESCUENTOPORCENTAJE+"=";
		sDescripcion+=notacreditosoli.getdescuento_porcentaje().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.TOTALIVA+"=";
		sDescripcion+=notacreditosoli.gettotal_iva().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.SUMAN+"=";
		sDescripcion+=notacreditosoli.getsuman().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.DESCUENTOVALOR+"=";
		sDescripcion+=notacreditosoli.getdescuento_valor().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.TOTALSINIVA+"=";
		sDescripcion+=notacreditosoli.gettotal_sin_iva().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.DESCUENTOGENERAL+"=";
		sDescripcion+=notacreditosoli.getdescuento_general().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.FLETE+"=";
		sDescripcion+=notacreditosoli.getflete().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.TOTAL+"=";
		sDescripcion+=notacreditosoli.gettotal().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=notacreditosoli.getsub_total().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.OTRO+"=";
		sDescripcion+=notacreditosoli.getotro().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.IVA+"=";
		sDescripcion+=notacreditosoli.getiva().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.FINANCIAMIENTO+"=";
		sDescripcion+=notacreditosoli.getfinanciamiento().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.OTROVALOR+"=";
		sDescripcion+=notacreditosoli.getotro_valor().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.RETENCION+"=";
		sDescripcion+=notacreditosoli.getretencion().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.ICE+"=";
		sDescripcion+=notacreditosoli.getice().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.FECHA+"=";
		sDescripcion+=notacreditosoli.getfecha().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=notacreditosoli.getid_centro_costo().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=notacreditosoli.getid_vendedor().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.IDTIPOCAMBIO+"=";
		sDescripcion+=notacreditosoli.getid_tipo_cambio().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.IDTRANSPORTE+"=";
		sDescripcion+=notacreditosoli.getid_transporte().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.IDTRANSPORTISTA+"=";
		sDescripcion+=notacreditosoli.getid_transportista().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.FECHACLIENTE+"=";
		sDescripcion+=notacreditosoli.getfecha_cliente().toString()+",";
		sDescripcion+=NotaCreditoSoliConstantesFunciones.FECHAAUTORIZACION+"=";
		sDescripcion+=notacreditosoli.getfecha_autorizacion().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setNotaCreditoSoliDescripcion(NotaCreditoSoli notacreditosoli,String sValor) throws Exception {			
		if(notacreditosoli !=null) {
			notacreditosoli.setcodigo(sValor);;//notacreditosolinotacreditosoli.getcodigo().trim();
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

	public static String getFormatoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
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

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getFacturaDescripcion(Factura factura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factura!=null/*&&factura.getId()>0*/) {
			sDescripcion=FacturaConstantesFunciones.getFacturaDescripcion(factura);
		}

		return sDescripcion;
	}

	public static String getTipoNotaCreditoSoliDescripcion(TipoNotaCreditoSoli tiponotacreditosoli) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiponotacreditosoli!=null/*&&tiponotacreditosoli.getId()>0*/) {
			sDescripcion=TipoNotaCreditoSoliConstantesFunciones.getTipoNotaCreditoSoliDescripcion(tiponotacreditosoli);
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

	public static String getEstadoNotaCreditoSoliDescripcion(EstadoNotaCredito estadonotacredito) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadonotacredito!=null/*&&estadonotacredito.getId()>0*/) {
			sDescripcion=EstadoNotaCreditoConstantesFunciones.getEstadoNotaCreditoDescripcion(estadonotacredito);
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

	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vendedor!=null/*&&vendedor.getId()>0*/) {
			sDescripcion=VendedorConstantesFunciones.getVendedorDescripcion(vendedor);
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

	public static String getTransporteDescripcion(Transporte transporte) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transporte!=null/*&&transporte.getId()>0*/) {
			sDescripcion=TransporteConstantesFunciones.getTransporteDescripcion(transporte);
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
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoNotaCreditoSoli")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdFactura")) {
			sNombreIndice="Tipo=  Por Factura";
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
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCambio")) {
			sNombreIndice="Tipo=  Por Tipo Cambio";
		} else if(sNombreIndice.equals("FK_IdTipoNotaCreditoSoli")) {
			sNombreIndice="Tipo=  Por Tipo";
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

	public static String getDetalleIndiceFK_IdEstadoNotaCreditoSoli(Long id_estado_nota_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_nota_credito!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_nota_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFactura(Long id_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_factura!=null) {sDetalleIndice+=" Codigo Unico De Factura="+id_factura.toString();} 

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

	public static String getDetalleIndiceFK_IdTipoNotaCreditoSoli(Long id_tipo_nota_credito_soli) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_nota_credito_soli!=null) {sDetalleIndice+=" Codigo Unico De Tipo="+id_tipo_nota_credito_soli.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosNotaCreditoSoli(NotaCreditoSoli notacreditosoli,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		notacreditosoli.setcodigo(notacreditosoli.getcodigo().trim());
		notacreditosoli.setnumero(notacreditosoli.getnumero().trim());
		notacreditosoli.setdireccion(notacreditosoli.getdireccion().trim());
		notacreditosoli.settelefono(notacreditosoli.gettelefono().trim());
		notacreditosoli.setruc(notacreditosoli.getruc().trim());
		notacreditosoli.setdescripcion(notacreditosoli.getdescripcion().trim());
	}
	
	public static void quitarEspaciosNotaCreditoSolis(List<NotaCreditoSoli> notacreditosolis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(NotaCreditoSoli notacreditosoli: notacreditosolis) {
			notacreditosoli.setcodigo(notacreditosoli.getcodigo().trim());
			notacreditosoli.setnumero(notacreditosoli.getnumero().trim());
			notacreditosoli.setdireccion(notacreditosoli.getdireccion().trim());
			notacreditosoli.settelefono(notacreditosoli.gettelefono().trim());
			notacreditosoli.setruc(notacreditosoli.getruc().trim());
			notacreditosoli.setdescripcion(notacreditosoli.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNotaCreditoSoli(NotaCreditoSoli notacreditosoli,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && notacreditosoli.getConCambioAuxiliar()) {
			notacreditosoli.setIsDeleted(notacreditosoli.getIsDeletedAuxiliar());	
			notacreditosoli.setIsNew(notacreditosoli.getIsNewAuxiliar());	
			notacreditosoli.setIsChanged(notacreditosoli.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			notacreditosoli.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			notacreditosoli.setIsDeletedAuxiliar(false);	
			notacreditosoli.setIsNewAuxiliar(false);	
			notacreditosoli.setIsChangedAuxiliar(false);
			
			notacreditosoli.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNotaCreditoSolis(List<NotaCreditoSoli> notacreditosolis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(NotaCreditoSoli notacreditosoli : notacreditosolis) {
			if(conAsignarBase && notacreditosoli.getConCambioAuxiliar()) {
				notacreditosoli.setIsDeleted(notacreditosoli.getIsDeletedAuxiliar());	
				notacreditosoli.setIsNew(notacreditosoli.getIsNewAuxiliar());	
				notacreditosoli.setIsChanged(notacreditosoli.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				notacreditosoli.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				notacreditosoli.setIsDeletedAuxiliar(false);	
				notacreditosoli.setIsNewAuxiliar(false);	
				notacreditosoli.setIsChangedAuxiliar(false);
				
				notacreditosoli.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresNotaCreditoSoli(NotaCreditoSoli notacreditosoli,Boolean conEnteros) throws Exception  {
		notacreditosoli.setcotizacion(0.0);
		notacreditosoli.setdescuento_porcentaje(0.0);
		notacreditosoli.settotal_iva(0.0);
		notacreditosoli.setsuman(0.0);
		notacreditosoli.setdescuento_valor(0.0);
		notacreditosoli.settotal_sin_iva(0.0);
		notacreditosoli.setdescuento_general(0.0);
		notacreditosoli.setflete(0.0);
		notacreditosoli.settotal(0.0);
		notacreditosoli.setsub_total(0.0);
		notacreditosoli.setotro(0.0);
		notacreditosoli.setiva(0.0);
		notacreditosoli.setfinanciamiento(0.0);
		notacreditosoli.setotro_valor(0.0);
		notacreditosoli.setretencion(0.0);
		notacreditosoli.setice(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			notacreditosoli.setnumero_dias(0);
		}
	}		
	
	public static void InicializarValoresNotaCreditoSolis(List<NotaCreditoSoli> notacreditosolis,Boolean conEnteros) throws Exception  {
		
		for(NotaCreditoSoli notacreditosoli: notacreditosolis) {
			notacreditosoli.setcotizacion(0.0);
			notacreditosoli.setdescuento_porcentaje(0.0);
			notacreditosoli.settotal_iva(0.0);
			notacreditosoli.setsuman(0.0);
			notacreditosoli.setdescuento_valor(0.0);
			notacreditosoli.settotal_sin_iva(0.0);
			notacreditosoli.setdescuento_general(0.0);
			notacreditosoli.setflete(0.0);
			notacreditosoli.settotal(0.0);
			notacreditosoli.setsub_total(0.0);
			notacreditosoli.setotro(0.0);
			notacreditosoli.setiva(0.0);
			notacreditosoli.setfinanciamiento(0.0);
			notacreditosoli.setotro_valor(0.0);
			notacreditosoli.setretencion(0.0);
			notacreditosoli.setice(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				notacreditosoli.setnumero_dias(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaNotaCreditoSoli(List<NotaCreditoSoli> notacreditosolis,NotaCreditoSoli notacreditosoliAux) throws Exception  {
		NotaCreditoSoliConstantesFunciones.InicializarValoresNotaCreditoSoli(notacreditosoliAux,true);
		
		for(NotaCreditoSoli notacreditosoli: notacreditosolis) {
			if(notacreditosoli.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			notacreditosoliAux.setnumero_dias(notacreditosoliAux.getnumero_dias()+notacreditosoli.getnumero_dias());			
			notacreditosoliAux.setcotizacion(notacreditosoliAux.getcotizacion()+notacreditosoli.getcotizacion());			
			notacreditosoliAux.setdescuento_porcentaje(notacreditosoliAux.getdescuento_porcentaje()+notacreditosoli.getdescuento_porcentaje());			
			notacreditosoliAux.settotal_iva(notacreditosoliAux.gettotal_iva()+notacreditosoli.gettotal_iva());			
			notacreditosoliAux.setsuman(notacreditosoliAux.getsuman()+notacreditosoli.getsuman());			
			notacreditosoliAux.setdescuento_valor(notacreditosoliAux.getdescuento_valor()+notacreditosoli.getdescuento_valor());			
			notacreditosoliAux.settotal_sin_iva(notacreditosoliAux.gettotal_sin_iva()+notacreditosoli.gettotal_sin_iva());			
			notacreditosoliAux.setdescuento_general(notacreditosoliAux.getdescuento_general()+notacreditosoli.getdescuento_general());			
			notacreditosoliAux.setflete(notacreditosoliAux.getflete()+notacreditosoli.getflete());			
			notacreditosoliAux.settotal(notacreditosoliAux.gettotal()+notacreditosoli.gettotal());			
			notacreditosoliAux.setsub_total(notacreditosoliAux.getsub_total()+notacreditosoli.getsub_total());			
			notacreditosoliAux.setotro(notacreditosoliAux.getotro()+notacreditosoli.getotro());			
			notacreditosoliAux.setiva(notacreditosoliAux.getiva()+notacreditosoli.getiva());			
			notacreditosoliAux.setfinanciamiento(notacreditosoliAux.getfinanciamiento()+notacreditosoli.getfinanciamiento());			
			notacreditosoliAux.setotro_valor(notacreditosoliAux.getotro_valor()+notacreditosoli.getotro_valor());			
			notacreditosoliAux.setretencion(notacreditosoliAux.getretencion()+notacreditosoli.getretencion());			
			notacreditosoliAux.setice(notacreditosoliAux.getice()+notacreditosoli.getice());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNotaCreditoSoli(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=NotaCreditoSoliConstantesFunciones.getArrayColumnasGlobalesNotaCreditoSoli(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesNotaCreditoSoli(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NotaCreditoSoliConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NotaCreditoSoliConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NotaCreditoSoliConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NotaCreditoSoliConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NotaCreditoSoliConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NotaCreditoSoliConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NotaCreditoSoliConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NotaCreditoSoliConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NotaCreditoSoliConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NotaCreditoSoliConstantesFunciones.IDUSUARIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NotaCreditoSoliConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NotaCreditoSoliConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoNotaCreditoSoli(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<NotaCreditoSoli> notacreditosolis,NotaCreditoSoli notacreditosoli,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(NotaCreditoSoli notacreditosoliAux: notacreditosolis) {
			if(notacreditosoliAux!=null && notacreditosoli!=null) {
				if((notacreditosoliAux.getId()==null && notacreditosoli.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(notacreditosoliAux.getId()!=null && notacreditosoli.getId()!=null){
					if(notacreditosoliAux.getId().equals(notacreditosoli.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaNotaCreditoSoli(List<NotaCreditoSoli> notacreditosolis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double cotizacionTotal=0.0;
		Double descuento_porcentajeTotal=0.0;
		Double total_ivaTotal=0.0;
		Double sumanTotal=0.0;
		Double descuento_valorTotal=0.0;
		Double total_sin_ivaTotal=0.0;
		Double descuento_generalTotal=0.0;
		Double fleteTotal=0.0;
		Double totalTotal=0.0;
		Double sub_totalTotal=0.0;
		Double otroTotal=0.0;
		Double ivaTotal=0.0;
		Double financiamientoTotal=0.0;
		Double otro_valorTotal=0.0;
		Double retencionTotal=0.0;
		Double iceTotal=0.0;
	
		for(NotaCreditoSoli notacreditosoli: notacreditosolis) {			
			if(notacreditosoli.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cotizacionTotal+=notacreditosoli.getcotizacion();
			descuento_porcentajeTotal+=notacreditosoli.getdescuento_porcentaje();
			total_ivaTotal+=notacreditosoli.gettotal_iva();
			sumanTotal+=notacreditosoli.getsuman();
			descuento_valorTotal+=notacreditosoli.getdescuento_valor();
			total_sin_ivaTotal+=notacreditosoli.gettotal_sin_iva();
			descuento_generalTotal+=notacreditosoli.getdescuento_general();
			fleteTotal+=notacreditosoli.getflete();
			totalTotal+=notacreditosoli.gettotal();
			sub_totalTotal+=notacreditosoli.getsub_total();
			otroTotal+=notacreditosoli.getotro();
			ivaTotal+=notacreditosoli.getiva();
			financiamientoTotal+=notacreditosoli.getfinanciamiento();
			otro_valorTotal+=notacreditosoli.getotro_valor();
			retencionTotal+=notacreditosoli.getretencion();
			iceTotal+=notacreditosoli.getice();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoSoliConstantesFunciones.COTIZACION);
		datoGeneral.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_COTIZACION);
		datoGeneral.setdValorDouble(cotizacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoSoliConstantesFunciones.DESCUENTOPORCENTAJE);
		datoGeneral.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
		datoGeneral.setdValorDouble(descuento_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoSoliConstantesFunciones.TOTALIVA);
		datoGeneral.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_TOTALIVA);
		datoGeneral.setdValorDouble(total_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoSoliConstantesFunciones.SUMAN);
		datoGeneral.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_SUMAN);
		datoGeneral.setdValorDouble(sumanTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoSoliConstantesFunciones.DESCUENTOVALOR);
		datoGeneral.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_DESCUENTOVALOR);
		datoGeneral.setdValorDouble(descuento_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoSoliConstantesFunciones.TOTALSINIVA);
		datoGeneral.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_TOTALSINIVA);
		datoGeneral.setdValorDouble(total_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoSoliConstantesFunciones.DESCUENTOGENERAL);
		datoGeneral.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_DESCUENTOGENERAL);
		datoGeneral.setdValorDouble(descuento_generalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoSoliConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoSoliConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoSoliConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoSoliConstantesFunciones.OTRO);
		datoGeneral.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_OTRO);
		datoGeneral.setdValorDouble(otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoSoliConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoSoliConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoSoliConstantesFunciones.OTROVALOR);
		datoGeneral.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_OTROVALOR);
		datoGeneral.setdValorDouble(otro_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoSoliConstantesFunciones.RETENCION);
		datoGeneral.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_RETENCION);
		datoGeneral.setdValorDouble(retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoSoliConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaNotaCreditoSoli() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_ID, NotaCreditoSoliConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_VERSIONROW, NotaCreditoSoliConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_IDEMPRESA, NotaCreditoSoliConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_IDSUCURSAL, NotaCreditoSoliConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_IDEJERCICIO, NotaCreditoSoliConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_IDPERIODO, NotaCreditoSoliConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_IDANIO, NotaCreditoSoliConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_IDMES, NotaCreditoSoliConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_IDUSUARIO, NotaCreditoSoliConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_CODIGO, NotaCreditoSoliConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_NUMEROPREIMPRESO, NotaCreditoSoliConstantesFunciones.NUMEROPREIMPRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_FECHAEMISION, NotaCreditoSoliConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_NUMERODIAS, NotaCreditoSoliConstantesFunciones.NUMERODIAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_FECHAVENCIMIENTO, NotaCreditoSoliConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_IDMONEDA, NotaCreditoSoliConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_IDEMPLEADO, NotaCreditoSoliConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_COTIZACION, NotaCreditoSoliConstantesFunciones.COTIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_IDFORMATO, NotaCreditoSoliConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_IDTIPOPRECIO, NotaCreditoSoliConstantesFunciones.IDTIPOPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_IDCLIENTE, NotaCreditoSoliConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_IDFACTURA, NotaCreditoSoliConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_DIRECCION, NotaCreditoSoliConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_TELEFONO, NotaCreditoSoliConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_RUC, NotaCreditoSoliConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_IDTIPONOTACREDITOSOLI, NotaCreditoSoliConstantesFunciones.IDTIPONOTACREDITOSOLI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_IDRESPONSABLE, NotaCreditoSoliConstantesFunciones.IDRESPONSABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_IDESTADONOTACREDITOSOLI, NotaCreditoSoliConstantesFunciones.IDESTADONOTACREDITOSOLI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_DESCRIPCION, NotaCreditoSoliConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_PENALIZADO, NotaCreditoSoliConstantesFunciones.PENALIZADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_DESCUENTOPORCENTAJE, NotaCreditoSoliConstantesFunciones.DESCUENTOPORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_TOTALIVA, NotaCreditoSoliConstantesFunciones.TOTALIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_SUMAN, NotaCreditoSoliConstantesFunciones.SUMAN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_DESCUENTOVALOR, NotaCreditoSoliConstantesFunciones.DESCUENTOVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_TOTALSINIVA, NotaCreditoSoliConstantesFunciones.TOTALSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_DESCUENTOGENERAL, NotaCreditoSoliConstantesFunciones.DESCUENTOGENERAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_FLETE, NotaCreditoSoliConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_TOTAL, NotaCreditoSoliConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_SUBTOTAL, NotaCreditoSoliConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_OTRO, NotaCreditoSoliConstantesFunciones.OTRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_IVA, NotaCreditoSoliConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_FINANCIAMIENTO, NotaCreditoSoliConstantesFunciones.FINANCIAMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_OTROVALOR, NotaCreditoSoliConstantesFunciones.OTROVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_RETENCION, NotaCreditoSoliConstantesFunciones.RETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_ICE, NotaCreditoSoliConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_FECHA, NotaCreditoSoliConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_IDCENTROCOSTO, NotaCreditoSoliConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_IDVENDEDOR, NotaCreditoSoliConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_IDTIPOCAMBIO, NotaCreditoSoliConstantesFunciones.IDTIPOCAMBIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_IDTRANSPORTE, NotaCreditoSoliConstantesFunciones.IDTRANSPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_IDTRANSPORTISTA, NotaCreditoSoliConstantesFunciones.IDTRANSPORTISTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_FECHACLIENTE, NotaCreditoSoliConstantesFunciones.FECHACLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoSoliConstantesFunciones.LABEL_FECHAAUTORIZACION, NotaCreditoSoliConstantesFunciones.FECHAAUTORIZACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasNotaCreditoSoli() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.NUMEROPREIMPRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.NUMERODIAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.COTIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.IDTIPOPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.IDTIPONOTACREDITOSOLI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.IDRESPONSABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.IDESTADONOTACREDITOSOLI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.PENALIZADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.DESCUENTOPORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.TOTALIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.SUMAN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.DESCUENTOVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.TOTALSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.DESCUENTOGENERAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.OTRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.FINANCIAMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.OTROVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.RETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.IDTIPOCAMBIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.IDTRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.IDTRANSPORTISTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.FECHACLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoSoliConstantesFunciones.FECHAAUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNotaCreditoSoli() throws Exception  {
		return NotaCreditoSoliConstantesFunciones.getTiposSeleccionarNotaCreditoSoli(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNotaCreditoSoli(Boolean conFk) throws Exception  {
		return NotaCreditoSoliConstantesFunciones.getTiposSeleccionarNotaCreditoSoli(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNotaCreditoSoli(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_NUMEROPREIMPRESO);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_NUMEROPREIMPRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_NUMERODIAS);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_NUMERODIAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_COTIZACION);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_COTIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_IDTIPOPRECIO);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IDTIPOPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_IDTIPONOTACREDITOSOLI);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IDTIPONOTACREDITOSOLI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_IDRESPONSABLE);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IDRESPONSABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_IDESTADONOTACREDITOSOLI);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IDESTADONOTACREDITOSOLI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_PENALIZADO);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_PENALIZADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_TOTALIVA);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_TOTALIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_SUMAN);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_SUMAN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_DESCUENTOVALOR);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_DESCUENTOVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_TOTALSINIVA);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_TOTALSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_DESCUENTOGENERAL);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_DESCUENTOGENERAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_OTRO);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_OTRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_FINANCIAMIENTO);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_FINANCIAMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_OTROVALOR);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_OTROVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_RETENCION);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_RETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_IDTIPOCAMBIO);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IDTIPOCAMBIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_IDTRANSPORTE);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IDTRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_IDTRANSPORTISTA);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_IDTRANSPORTISTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_FECHACLIENTE);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_FECHACLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoSoliConstantesFunciones.LABEL_FECHAAUTORIZACION);
			reporte.setsDescripcion(NotaCreditoSoliConstantesFunciones.LABEL_FECHAAUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesNotaCreditoSoli(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesNotaCreditoSoli(NotaCreditoSoli notacreditosoliAux) throws Exception {
		
			notacreditosoliAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(notacreditosoliAux.getEmpresa()));
			notacreditosoliAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(notacreditosoliAux.getSucursal()));
			notacreditosoliAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(notacreditosoliAux.getEjercicio()));
			notacreditosoliAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(notacreditosoliAux.getPeriodo()));
			notacreditosoliAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(notacreditosoliAux.getAnio()));
			notacreditosoliAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(notacreditosoliAux.getMes()));
			notacreditosoliAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(notacreditosoliAux.getUsuario()));
			notacreditosoliAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(notacreditosoliAux.getMoneda()));
			notacreditosoliAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(notacreditosoliAux.getEmpleado()));
			notacreditosoliAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(notacreditosoliAux.getFormato()));
			notacreditosoliAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(notacreditosoliAux.getTipoPrecio()));
			notacreditosoliAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(notacreditosoliAux.getCliente()));
			notacreditosoliAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(notacreditosoliAux.getFactura()));
			notacreditosoliAux.settiponotacreditosoli_descripcion(TipoNotaCreditoSoliConstantesFunciones.getTipoNotaCreditoSoliDescripcion(notacreditosoliAux.getTipoNotaCreditoSoli()));
			notacreditosoliAux.setresponsable_descripcion(ResponsableConstantesFunciones.getResponsableDescripcion(notacreditosoliAux.getResponsable()));
			notacreditosoliAux.setestadonotacreditosoli_descripcion(EstadoNotaCreditoConstantesFunciones.getEstadoNotaCreditoDescripcion(notacreditosoliAux.getEstadoNotaCreditoSoli()));
			notacreditosoliAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(notacreditosoliAux.getCentroCosto()));
			notacreditosoliAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(notacreditosoliAux.getVendedor()));
			notacreditosoliAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(notacreditosoliAux.getTipoCambio()));
			notacreditosoliAux.settransporte_descripcion(TransporteConstantesFunciones.getTransporteDescripcion(notacreditosoliAux.getTransporte()));
			notacreditosoliAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(notacreditosoliAux.getTransportista()));		
	}
	
	public static void refrescarForeignKeysDescripcionesNotaCreditoSoli(List<NotaCreditoSoli> notacreditosolisTemp) throws Exception {
		for(NotaCreditoSoli notacreditosoliAux:notacreditosolisTemp) {
			
			notacreditosoliAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(notacreditosoliAux.getEmpresa()));
			notacreditosoliAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(notacreditosoliAux.getSucursal()));
			notacreditosoliAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(notacreditosoliAux.getEjercicio()));
			notacreditosoliAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(notacreditosoliAux.getPeriodo()));
			notacreditosoliAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(notacreditosoliAux.getAnio()));
			notacreditosoliAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(notacreditosoliAux.getMes()));
			notacreditosoliAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(notacreditosoliAux.getUsuario()));
			notacreditosoliAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(notacreditosoliAux.getMoneda()));
			notacreditosoliAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(notacreditosoliAux.getEmpleado()));
			notacreditosoliAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(notacreditosoliAux.getFormato()));
			notacreditosoliAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(notacreditosoliAux.getTipoPrecio()));
			notacreditosoliAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(notacreditosoliAux.getCliente()));
			notacreditosoliAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(notacreditosoliAux.getFactura()));
			notacreditosoliAux.settiponotacreditosoli_descripcion(TipoNotaCreditoSoliConstantesFunciones.getTipoNotaCreditoSoliDescripcion(notacreditosoliAux.getTipoNotaCreditoSoli()));
			notacreditosoliAux.setresponsable_descripcion(ResponsableConstantesFunciones.getResponsableDescripcion(notacreditosoliAux.getResponsable()));
			notacreditosoliAux.setestadonotacreditosoli_descripcion(EstadoNotaCreditoConstantesFunciones.getEstadoNotaCreditoDescripcion(notacreditosoliAux.getEstadoNotaCreditoSoli()));
			notacreditosoliAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(notacreditosoliAux.getCentroCosto()));
			notacreditosoliAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(notacreditosoliAux.getVendedor()));
			notacreditosoliAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(notacreditosoliAux.getTipoCambio()));
			notacreditosoliAux.settransporte_descripcion(TransporteConstantesFunciones.getTransporteDescripcion(notacreditosoliAux.getTransporte()));
			notacreditosoliAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(notacreditosoliAux.getTransportista()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfNotaCreditoSoli(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(TipoPrecio.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(TipoNotaCreditoSoli.class));
				classes.add(new Classe(Responsable.class));
				classes.add(new Classe(EstadoNotaCredito.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(TipoCambio.class));
				classes.add(new Classe(Transporte.class));
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
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPrecio.class)) {
						classes.add(new Classe(TipoPrecio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoNotaCreditoSoli.class)) {
						classes.add(new Classe(TipoNotaCreditoSoli.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Responsable.class)) {
						classes.add(new Classe(Responsable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoNotaCredito.class)) {
						classes.add(new Classe(EstadoNotaCredito.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCambio.class)) {
						classes.add(new Classe(TipoCambio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transporte.class)) {
						classes.add(new Classe(Transporte.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfNotaCreditoSoli(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(TipoNotaCreditoSoli.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoNotaCreditoSoli.class)); continue;
					}

					if(Responsable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Responsable.class)); continue;
					}

					if(EstadoNotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoNotaCredito.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(Transporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transporte.class)); continue;
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

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(TipoNotaCreditoSoli.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoNotaCreditoSoli.class)); continue;
					}

					if(Responsable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Responsable.class)); continue;
					}

					if(EstadoNotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoNotaCredito.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(Transporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transporte.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfNotaCreditoSoli(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return NotaCreditoSoliConstantesFunciones.getClassesRelationshipsOfNotaCreditoSoli(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNotaCreditoSoli(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetaNotaCreditoSoli.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetaNotaCreditoSoli.class)) {
						classes.add(new Classe(DetaNotaCreditoSoli.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNotaCreditoSoli(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return NotaCreditoSoliConstantesFunciones.getClassesRelationshipsFromStringsOfNotaCreditoSoli(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNotaCreditoSoli(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetaNotaCreditoSoli.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaNotaCreditoSoli.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetaNotaCreditoSoli.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaNotaCreditoSoli.class)); continue;
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
	public static void actualizarLista(NotaCreditoSoli notacreditosoli,List<NotaCreditoSoli> notacreditosolis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			NotaCreditoSoli notacreditosoliEncontrado=null;
			
			for(NotaCreditoSoli notacreditosoliLocal:notacreditosolis) {
				if(notacreditosoliLocal.getId().equals(notacreditosoli.getId())) {
					notacreditosoliEncontrado=notacreditosoliLocal;
					
					notacreditosoliLocal.setIsChanged(notacreditosoli.getIsChanged());
					notacreditosoliLocal.setIsNew(notacreditosoli.getIsNew());
					notacreditosoliLocal.setIsDeleted(notacreditosoli.getIsDeleted());
					
					notacreditosoliLocal.setGeneralEntityOriginal(notacreditosoli.getGeneralEntityOriginal());
					
					notacreditosoliLocal.setId(notacreditosoli.getId());	
					notacreditosoliLocal.setVersionRow(notacreditosoli.getVersionRow());	
					notacreditosoliLocal.setid_empresa(notacreditosoli.getid_empresa());	
					notacreditosoliLocal.setid_sucursal(notacreditosoli.getid_sucursal());	
					notacreditosoliLocal.setid_ejercicio(notacreditosoli.getid_ejercicio());	
					notacreditosoliLocal.setid_periodo(notacreditosoli.getid_periodo());	
					notacreditosoliLocal.setid_anio(notacreditosoli.getid_anio());	
					notacreditosoliLocal.setid_mes(notacreditosoli.getid_mes());	
					notacreditosoliLocal.setid_usuario(notacreditosoli.getid_usuario());	
					notacreditosoliLocal.setcodigo(notacreditosoli.getcodigo());	
					notacreditosoliLocal.setnumero(notacreditosoli.getnumero());	
					notacreditosoliLocal.setfecha_emision(notacreditosoli.getfecha_emision());	
					notacreditosoliLocal.setnumero_dias(notacreditosoli.getnumero_dias());	
					notacreditosoliLocal.setfecha_vencimiento(notacreditosoli.getfecha_vencimiento());	
					notacreditosoliLocal.setid_moneda(notacreditosoli.getid_moneda());	
					notacreditosoliLocal.setid_empleado(notacreditosoli.getid_empleado());	
					notacreditosoliLocal.setcotizacion(notacreditosoli.getcotizacion());	
					notacreditosoliLocal.setid_formato(notacreditosoli.getid_formato());	
					notacreditosoliLocal.setid_tipo_precio(notacreditosoli.getid_tipo_precio());	
					notacreditosoliLocal.setid_cliente(notacreditosoli.getid_cliente());	
					notacreditosoliLocal.setid_factura(notacreditosoli.getid_factura());	
					notacreditosoliLocal.setdireccion(notacreditosoli.getdireccion());	
					notacreditosoliLocal.settelefono(notacreditosoli.gettelefono());	
					notacreditosoliLocal.setruc(notacreditosoli.getruc());	
					notacreditosoliLocal.setid_tipo_nota_credito_soli(notacreditosoli.getid_tipo_nota_credito_soli());	
					notacreditosoliLocal.setid_responsable(notacreditosoli.getid_responsable());	
					notacreditosoliLocal.setid_estado_nota_credito(notacreditosoli.getid_estado_nota_credito());	
					notacreditosoliLocal.setdescripcion(notacreditosoli.getdescripcion());	
					notacreditosoliLocal.setpenalizado(notacreditosoli.getpenalizado());	
					notacreditosoliLocal.setdescuento_porcentaje(notacreditosoli.getdescuento_porcentaje());	
					notacreditosoliLocal.settotal_iva(notacreditosoli.gettotal_iva());	
					notacreditosoliLocal.setsuman(notacreditosoli.getsuman());	
					notacreditosoliLocal.setdescuento_valor(notacreditosoli.getdescuento_valor());	
					notacreditosoliLocal.settotal_sin_iva(notacreditosoli.gettotal_sin_iva());	
					notacreditosoliLocal.setdescuento_general(notacreditosoli.getdescuento_general());	
					notacreditosoliLocal.setflete(notacreditosoli.getflete());	
					notacreditosoliLocal.settotal(notacreditosoli.gettotal());	
					notacreditosoliLocal.setsub_total(notacreditosoli.getsub_total());	
					notacreditosoliLocal.setotro(notacreditosoli.getotro());	
					notacreditosoliLocal.setiva(notacreditosoli.getiva());	
					notacreditosoliLocal.setfinanciamiento(notacreditosoli.getfinanciamiento());	
					notacreditosoliLocal.setotro_valor(notacreditosoli.getotro_valor());	
					notacreditosoliLocal.setretencion(notacreditosoli.getretencion());	
					notacreditosoliLocal.setice(notacreditosoli.getice());	
					notacreditosoliLocal.setfecha(notacreditosoli.getfecha());	
					notacreditosoliLocal.setid_centro_costo(notacreditosoli.getid_centro_costo());	
					notacreditosoliLocal.setid_vendedor(notacreditosoli.getid_vendedor());	
					notacreditosoliLocal.setid_tipo_cambio(notacreditosoli.getid_tipo_cambio());	
					notacreditosoliLocal.setid_transporte(notacreditosoli.getid_transporte());	
					notacreditosoliLocal.setid_transportista(notacreditosoli.getid_transportista());	
					notacreditosoliLocal.setfecha_cliente(notacreditosoli.getfecha_cliente());	
					notacreditosoliLocal.setfecha_autorizacion(notacreditosoli.getfecha_autorizacion());	
					
					
					notacreditosoliLocal.setDetaNotaCreditoSolis(notacreditosoli.getDetaNotaCreditoSolis());
					
					existe=true;
					break;
				}
			}
			
			if(!notacreditosoli.getIsDeleted()) {
				if(!existe) {
					notacreditosolis.add(notacreditosoli);
				}
			} else {
				if(notacreditosoliEncontrado!=null && permiteQuitar)  {
					notacreditosolis.remove(notacreditosoliEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(NotaCreditoSoli notacreditosoli,List<NotaCreditoSoli> notacreditosolis) throws Exception {
		try	{			
			for(NotaCreditoSoli notacreditosoliLocal:notacreditosolis) {
				if(notacreditosoliLocal.getId().equals(notacreditosoli.getId())) {
					notacreditosoliLocal.setIsSelected(notacreditosoli.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesNotaCreditoSoli(List<NotaCreditoSoli> notacreditosolisAux) throws Exception {
		//this.notacreditosolisAux=notacreditosolisAux;
		
		for(NotaCreditoSoli notacreditosoliAux:notacreditosolisAux) {
			if(notacreditosoliAux.getIsChanged()) {
				notacreditosoliAux.setIsChanged(false);
			}		
			
			if(notacreditosoliAux.getIsNew()) {
				notacreditosoliAux.setIsNew(false);
			}	
			
			if(notacreditosoliAux.getIsDeleted()) {
				notacreditosoliAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesNotaCreditoSoli(NotaCreditoSoli notacreditosoliAux) throws Exception {
		//this.notacreditosoliAux=notacreditosoliAux;
		
			if(notacreditosoliAux.getIsChanged()) {
				notacreditosoliAux.setIsChanged(false);
			}		
			
			if(notacreditosoliAux.getIsNew()) {
				notacreditosoliAux.setIsNew(false);
			}	
			
			if(notacreditosoliAux.getIsDeleted()) {
				notacreditosoliAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(NotaCreditoSoli notacreditosoliAsignar,NotaCreditoSoli notacreditosoli) throws Exception {
		notacreditosoliAsignar.setId(notacreditosoli.getId());	
		notacreditosoliAsignar.setVersionRow(notacreditosoli.getVersionRow());	
		notacreditosoliAsignar.setid_empresa(notacreditosoli.getid_empresa());
		notacreditosoliAsignar.setempresa_descripcion(notacreditosoli.getempresa_descripcion());	
		notacreditosoliAsignar.setid_sucursal(notacreditosoli.getid_sucursal());
		notacreditosoliAsignar.setsucursal_descripcion(notacreditosoli.getsucursal_descripcion());	
		notacreditosoliAsignar.setid_ejercicio(notacreditosoli.getid_ejercicio());
		notacreditosoliAsignar.setejercicio_descripcion(notacreditosoli.getejercicio_descripcion());	
		notacreditosoliAsignar.setid_periodo(notacreditosoli.getid_periodo());
		notacreditosoliAsignar.setperiodo_descripcion(notacreditosoli.getperiodo_descripcion());	
		notacreditosoliAsignar.setid_anio(notacreditosoli.getid_anio());
		notacreditosoliAsignar.setanio_descripcion(notacreditosoli.getanio_descripcion());	
		notacreditosoliAsignar.setid_mes(notacreditosoli.getid_mes());
		notacreditosoliAsignar.setmes_descripcion(notacreditosoli.getmes_descripcion());	
		notacreditosoliAsignar.setid_usuario(notacreditosoli.getid_usuario());
		notacreditosoliAsignar.setusuario_descripcion(notacreditosoli.getusuario_descripcion());	
		notacreditosoliAsignar.setcodigo(notacreditosoli.getcodigo());	
		notacreditosoliAsignar.setnumero(notacreditosoli.getnumero());	
		notacreditosoliAsignar.setfecha_emision(notacreditosoli.getfecha_emision());	
		notacreditosoliAsignar.setnumero_dias(notacreditosoli.getnumero_dias());	
		notacreditosoliAsignar.setfecha_vencimiento(notacreditosoli.getfecha_vencimiento());	
		notacreditosoliAsignar.setid_moneda(notacreditosoli.getid_moneda());
		notacreditosoliAsignar.setmoneda_descripcion(notacreditosoli.getmoneda_descripcion());	
		notacreditosoliAsignar.setid_empleado(notacreditosoli.getid_empleado());
		notacreditosoliAsignar.setempleado_descripcion(notacreditosoli.getempleado_descripcion());	
		notacreditosoliAsignar.setcotizacion(notacreditosoli.getcotizacion());	
		notacreditosoliAsignar.setid_formato(notacreditosoli.getid_formato());
		notacreditosoliAsignar.setformato_descripcion(notacreditosoli.getformato_descripcion());	
		notacreditosoliAsignar.setid_tipo_precio(notacreditosoli.getid_tipo_precio());
		notacreditosoliAsignar.settipoprecio_descripcion(notacreditosoli.gettipoprecio_descripcion());	
		notacreditosoliAsignar.setid_cliente(notacreditosoli.getid_cliente());
		notacreditosoliAsignar.setcliente_descripcion(notacreditosoli.getcliente_descripcion());	
		notacreditosoliAsignar.setid_factura(notacreditosoli.getid_factura());
		notacreditosoliAsignar.setfactura_descripcion(notacreditosoli.getfactura_descripcion());	
		notacreditosoliAsignar.setdireccion(notacreditosoli.getdireccion());	
		notacreditosoliAsignar.settelefono(notacreditosoli.gettelefono());	
		notacreditosoliAsignar.setruc(notacreditosoli.getruc());	
		notacreditosoliAsignar.setid_tipo_nota_credito_soli(notacreditosoli.getid_tipo_nota_credito_soli());
		notacreditosoliAsignar.settiponotacreditosoli_descripcion(notacreditosoli.gettiponotacreditosoli_descripcion());	
		notacreditosoliAsignar.setid_responsable(notacreditosoli.getid_responsable());
		notacreditosoliAsignar.setresponsable_descripcion(notacreditosoli.getresponsable_descripcion());	
		notacreditosoliAsignar.setid_estado_nota_credito(notacreditosoli.getid_estado_nota_credito());
		notacreditosoliAsignar.setestadonotacreditosoli_descripcion(notacreditosoli.getestadonotacreditosoli_descripcion());	
		notacreditosoliAsignar.setdescripcion(notacreditosoli.getdescripcion());	
		notacreditosoliAsignar.setpenalizado(notacreditosoli.getpenalizado());	
		notacreditosoliAsignar.setdescuento_porcentaje(notacreditosoli.getdescuento_porcentaje());	
		notacreditosoliAsignar.settotal_iva(notacreditosoli.gettotal_iva());	
		notacreditosoliAsignar.setsuman(notacreditosoli.getsuman());	
		notacreditosoliAsignar.setdescuento_valor(notacreditosoli.getdescuento_valor());	
		notacreditosoliAsignar.settotal_sin_iva(notacreditosoli.gettotal_sin_iva());	
		notacreditosoliAsignar.setdescuento_general(notacreditosoli.getdescuento_general());	
		notacreditosoliAsignar.setflete(notacreditosoli.getflete());	
		notacreditosoliAsignar.settotal(notacreditosoli.gettotal());	
		notacreditosoliAsignar.setsub_total(notacreditosoli.getsub_total());	
		notacreditosoliAsignar.setotro(notacreditosoli.getotro());	
		notacreditosoliAsignar.setiva(notacreditosoli.getiva());	
		notacreditosoliAsignar.setfinanciamiento(notacreditosoli.getfinanciamiento());	
		notacreditosoliAsignar.setotro_valor(notacreditosoli.getotro_valor());	
		notacreditosoliAsignar.setretencion(notacreditosoli.getretencion());	
		notacreditosoliAsignar.setice(notacreditosoli.getice());	
		notacreditosoliAsignar.setfecha(notacreditosoli.getfecha());	
		notacreditosoliAsignar.setid_centro_costo(notacreditosoli.getid_centro_costo());
		notacreditosoliAsignar.setcentrocosto_descripcion(notacreditosoli.getcentrocosto_descripcion());	
		notacreditosoliAsignar.setid_vendedor(notacreditosoli.getid_vendedor());
		notacreditosoliAsignar.setvendedor_descripcion(notacreditosoli.getvendedor_descripcion());	
		notacreditosoliAsignar.setid_tipo_cambio(notacreditosoli.getid_tipo_cambio());
		notacreditosoliAsignar.settipocambio_descripcion(notacreditosoli.gettipocambio_descripcion());	
		notacreditosoliAsignar.setid_transporte(notacreditosoli.getid_transporte());
		notacreditosoliAsignar.settransporte_descripcion(notacreditosoli.gettransporte_descripcion());	
		notacreditosoliAsignar.setid_transportista(notacreditosoli.getid_transportista());
		notacreditosoliAsignar.settransportista_descripcion(notacreditosoli.gettransportista_descripcion());	
		notacreditosoliAsignar.setfecha_cliente(notacreditosoli.getfecha_cliente());	
		notacreditosoliAsignar.setfecha_autorizacion(notacreditosoli.getfecha_autorizacion());	
	}
	
	public static void inicializarNotaCreditoSoli(NotaCreditoSoli notacreditosoli) throws Exception {
		try {
				notacreditosoli.setId(0L);	
					
				notacreditosoli.setid_empresa(-1L);	
				notacreditosoli.setid_sucursal(-1L);	
				notacreditosoli.setid_ejercicio(-1L);	
				notacreditosoli.setid_periodo(-1L);	
				notacreditosoli.setid_anio(null);	
				notacreditosoli.setid_mes(null);	
				notacreditosoli.setid_usuario(-1L);	
				notacreditosoli.setcodigo("");	
				notacreditosoli.setnumero("");	
				notacreditosoli.setfecha_emision(new Date());	
				notacreditosoli.setnumero_dias(0);	
				notacreditosoli.setfecha_vencimiento(new Date());	
				notacreditosoli.setid_moneda(-1L);	
				notacreditosoli.setid_empleado(-1L);	
				notacreditosoli.setcotizacion(0.0);	
				notacreditosoli.setid_formato(null);	
				notacreditosoli.setid_tipo_precio(-1L);	
				notacreditosoli.setid_cliente(-1L);	
				notacreditosoli.setid_factura(-1L);	
				notacreditosoli.setdireccion("");	
				notacreditosoli.settelefono("");	
				notacreditosoli.setruc("");	
				notacreditosoli.setid_tipo_nota_credito_soli(-1L);	
				notacreditosoli.setid_responsable(null);	
				notacreditosoli.setid_estado_nota_credito(-1L);	
				notacreditosoli.setdescripcion("");	
				notacreditosoli.setpenalizado(false);	
				notacreditosoli.setdescuento_porcentaje(0.0);	
				notacreditosoli.settotal_iva(0.0);	
				notacreditosoli.setsuman(0.0);	
				notacreditosoli.setdescuento_valor(0.0);	
				notacreditosoli.settotal_sin_iva(0.0);	
				notacreditosoli.setdescuento_general(0.0);	
				notacreditosoli.setflete(0.0);	
				notacreditosoli.settotal(0.0);	
				notacreditosoli.setsub_total(0.0);	
				notacreditosoli.setotro(0.0);	
				notacreditosoli.setiva(0.0);	
				notacreditosoli.setfinanciamiento(0.0);	
				notacreditosoli.setotro_valor(0.0);	
				notacreditosoli.setretencion(0.0);	
				notacreditosoli.setice(0.0);	
				notacreditosoli.setfecha(new Date());	
				notacreditosoli.setid_centro_costo(null);	
				notacreditosoli.setid_vendedor(null);	
				notacreditosoli.setid_tipo_cambio(null);	
				notacreditosoli.setid_transporte(null);	
				notacreditosoli.setid_transportista(null);	
				notacreditosoli.setfecha_cliente(new Date());	
				notacreditosoli.setfecha_autorizacion(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderNotaCreditoSoli(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_NUMEROPREIMPRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_NUMERODIAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_COTIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_IDTIPOPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_IDTIPONOTACREDITOSOLI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_IDRESPONSABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_IDESTADONOTACREDITOSOLI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_PENALIZADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_TOTALIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_SUMAN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_DESCUENTOVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_TOTALSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_DESCUENTOGENERAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_OTRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_FINANCIAMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_OTROVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_RETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_IDTIPOCAMBIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_IDTRANSPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_IDTRANSPORTISTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_FECHACLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoSoliConstantesFunciones.LABEL_FECHAAUTORIZACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataNotaCreditoSoli(String sTipo,Row row,Workbook workbook,NotaCreditoSoli notacreditosoli,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getnumero_dias());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getcotizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.gettipoprecio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.gettiponotacreditosoli_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getresponsable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getestadonotacreditosoli_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(notacreditosoli.getpenalizado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getdescuento_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.gettotal_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getsuman());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getdescuento_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.gettotal_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getdescuento_general());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getsub_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getotro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getfinanciamiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getotro_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getretencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.gettipocambio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.gettransporte_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.gettransportista_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getfecha_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacreditosoli.getfecha_autorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryNotaCreditoSoli=Constantes.SFINALQUERY;
	
	public String getsFinalQueryNotaCreditoSoli() {
		return this.sFinalQueryNotaCreditoSoli;
	}
	
	public void setsFinalQueryNotaCreditoSoli(String sFinalQueryNotaCreditoSoli) {
		this.sFinalQueryNotaCreditoSoli= sFinalQueryNotaCreditoSoli;
	}
	
	public Border resaltarSeleccionarNotaCreditoSoli=null;
	
	public Border setResaltarSeleccionarNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarSeleccionarNotaCreditoSoli= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarNotaCreditoSoli() {
		return this.resaltarSeleccionarNotaCreditoSoli;
	}
	
	public void setResaltarSeleccionarNotaCreditoSoli(Border borderResaltarSeleccionarNotaCreditoSoli) {
		this.resaltarSeleccionarNotaCreditoSoli= borderResaltarSeleccionarNotaCreditoSoli;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridNotaCreditoSoli=null;
	public Boolean mostraridNotaCreditoSoli=true;
	public Boolean activaridNotaCreditoSoli=true;

	public Border resaltarid_empresaNotaCreditoSoli=null;
	public Boolean mostrarid_empresaNotaCreditoSoli=true;
	public Boolean activarid_empresaNotaCreditoSoli=true;
	public Boolean cargarid_empresaNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_sucursalNotaCreditoSoli=null;
	public Boolean mostrarid_sucursalNotaCreditoSoli=true;
	public Boolean activarid_sucursalNotaCreditoSoli=true;
	public Boolean cargarid_sucursalNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_ejercicioNotaCreditoSoli=null;
	public Boolean mostrarid_ejercicioNotaCreditoSoli=true;
	public Boolean activarid_ejercicioNotaCreditoSoli=true;
	public Boolean cargarid_ejercicioNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_periodoNotaCreditoSoli=null;
	public Boolean mostrarid_periodoNotaCreditoSoli=true;
	public Boolean activarid_periodoNotaCreditoSoli=true;
	public Boolean cargarid_periodoNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_anioNotaCreditoSoli=null;
	public Boolean mostrarid_anioNotaCreditoSoli=true;
	public Boolean activarid_anioNotaCreditoSoli=false;
	public Boolean cargarid_anioNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_mesNotaCreditoSoli=null;
	public Boolean mostrarid_mesNotaCreditoSoli=true;
	public Boolean activarid_mesNotaCreditoSoli=false;
	public Boolean cargarid_mesNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_usuarioNotaCreditoSoli=null;
	public Boolean mostrarid_usuarioNotaCreditoSoli=true;
	public Boolean activarid_usuarioNotaCreditoSoli=true;
	public Boolean cargarid_usuarioNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarcodigoNotaCreditoSoli=null;
	public Boolean mostrarcodigoNotaCreditoSoli=true;
	public Boolean activarcodigoNotaCreditoSoli=true;

	public Border resaltarnumeroNotaCreditoSoli=null;
	public Boolean mostrarnumeroNotaCreditoSoli=true;
	public Boolean activarnumeroNotaCreditoSoli=true;

	public Border resaltarfecha_emisionNotaCreditoSoli=null;
	public Boolean mostrarfecha_emisionNotaCreditoSoli=true;
	public Boolean activarfecha_emisionNotaCreditoSoli=true;

	public Border resaltarnumero_diasNotaCreditoSoli=null;
	public Boolean mostrarnumero_diasNotaCreditoSoli=true;
	public Boolean activarnumero_diasNotaCreditoSoli=true;

	public Border resaltarfecha_vencimientoNotaCreditoSoli=null;
	public Boolean mostrarfecha_vencimientoNotaCreditoSoli=true;
	public Boolean activarfecha_vencimientoNotaCreditoSoli=true;

	public Border resaltarid_monedaNotaCreditoSoli=null;
	public Boolean mostrarid_monedaNotaCreditoSoli=true;
	public Boolean activarid_monedaNotaCreditoSoli=true;
	public Boolean cargarid_monedaNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_empleadoNotaCreditoSoli=null;
	public Boolean mostrarid_empleadoNotaCreditoSoli=true;
	public Boolean activarid_empleadoNotaCreditoSoli=true;
	public Boolean cargarid_empleadoNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarcotizacionNotaCreditoSoli=null;
	public Boolean mostrarcotizacionNotaCreditoSoli=true;
	public Boolean activarcotizacionNotaCreditoSoli=true;

	public Border resaltarid_formatoNotaCreditoSoli=null;
	public Boolean mostrarid_formatoNotaCreditoSoli=true;
	public Boolean activarid_formatoNotaCreditoSoli=true;
	public Boolean cargarid_formatoNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_tipo_precioNotaCreditoSoli=null;
	public Boolean mostrarid_tipo_precioNotaCreditoSoli=true;
	public Boolean activarid_tipo_precioNotaCreditoSoli=true;
	public Boolean cargarid_tipo_precioNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_precioNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_clienteNotaCreditoSoli=null;
	public Boolean mostrarid_clienteNotaCreditoSoli=true;
	public Boolean activarid_clienteNotaCreditoSoli=true;
	public Boolean cargarid_clienteNotaCreditoSoli=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_facturaNotaCreditoSoli=null;
	public Boolean mostrarid_facturaNotaCreditoSoli=true;
	public Boolean activarid_facturaNotaCreditoSoli=true;
	public Boolean cargarid_facturaNotaCreditoSoli=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltardireccionNotaCreditoSoli=null;
	public Boolean mostrardireccionNotaCreditoSoli=true;
	public Boolean activardireccionNotaCreditoSoli=true;

	public Border resaltartelefonoNotaCreditoSoli=null;
	public Boolean mostrartelefonoNotaCreditoSoli=true;
	public Boolean activartelefonoNotaCreditoSoli=true;

	public Border resaltarrucNotaCreditoSoli=null;
	public Boolean mostrarrucNotaCreditoSoli=true;
	public Boolean activarrucNotaCreditoSoli=true;

	public Border resaltarid_tipo_nota_credito_soliNotaCreditoSoli=null;
	public Boolean mostrarid_tipo_nota_credito_soliNotaCreditoSoli=true;
	public Boolean activarid_tipo_nota_credito_soliNotaCreditoSoli=true;
	public Boolean cargarid_tipo_nota_credito_soliNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_nota_credito_soliNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_responsableNotaCreditoSoli=null;
	public Boolean mostrarid_responsableNotaCreditoSoli=true;
	public Boolean activarid_responsableNotaCreditoSoli=true;
	public Boolean cargarid_responsableNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_responsableNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_estado_nota_creditoNotaCreditoSoli=null;
	public Boolean mostrarid_estado_nota_creditoNotaCreditoSoli=true;
	public Boolean activarid_estado_nota_creditoNotaCreditoSoli=true;
	public Boolean cargarid_estado_nota_creditoNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_nota_creditoNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltardescripcionNotaCreditoSoli=null;
	public Boolean mostrardescripcionNotaCreditoSoli=true;
	public Boolean activardescripcionNotaCreditoSoli=true;

	public Border resaltarpenalizadoNotaCreditoSoli=null;
	public Boolean mostrarpenalizadoNotaCreditoSoli=true;
	public Boolean activarpenalizadoNotaCreditoSoli=true;

	public Border resaltardescuento_porcentajeNotaCreditoSoli=null;
	public Boolean mostrardescuento_porcentajeNotaCreditoSoli=true;
	public Boolean activardescuento_porcentajeNotaCreditoSoli=true;

	public Border resaltartotal_ivaNotaCreditoSoli=null;
	public Boolean mostrartotal_ivaNotaCreditoSoli=true;
	public Boolean activartotal_ivaNotaCreditoSoli=true;

	public Border resaltarsumanNotaCreditoSoli=null;
	public Boolean mostrarsumanNotaCreditoSoli=true;
	public Boolean activarsumanNotaCreditoSoli=true;

	public Border resaltardescuento_valorNotaCreditoSoli=null;
	public Boolean mostrardescuento_valorNotaCreditoSoli=true;
	public Boolean activardescuento_valorNotaCreditoSoli=true;

	public Border resaltartotal_sin_ivaNotaCreditoSoli=null;
	public Boolean mostrartotal_sin_ivaNotaCreditoSoli=true;
	public Boolean activartotal_sin_ivaNotaCreditoSoli=true;

	public Border resaltardescuento_generalNotaCreditoSoli=null;
	public Boolean mostrardescuento_generalNotaCreditoSoli=true;
	public Boolean activardescuento_generalNotaCreditoSoli=true;

	public Border resaltarfleteNotaCreditoSoli=null;
	public Boolean mostrarfleteNotaCreditoSoli=true;
	public Boolean activarfleteNotaCreditoSoli=true;

	public Border resaltartotalNotaCreditoSoli=null;
	public Boolean mostrartotalNotaCreditoSoli=true;
	public Boolean activartotalNotaCreditoSoli=true;

	public Border resaltarsub_totalNotaCreditoSoli=null;
	public Boolean mostrarsub_totalNotaCreditoSoli=true;
	public Boolean activarsub_totalNotaCreditoSoli=true;

	public Border resaltarotroNotaCreditoSoli=null;
	public Boolean mostrarotroNotaCreditoSoli=true;
	public Boolean activarotroNotaCreditoSoli=true;

	public Border resaltarivaNotaCreditoSoli=null;
	public Boolean mostrarivaNotaCreditoSoli=true;
	public Boolean activarivaNotaCreditoSoli=true;

	public Border resaltarfinanciamientoNotaCreditoSoli=null;
	public Boolean mostrarfinanciamientoNotaCreditoSoli=true;
	public Boolean activarfinanciamientoNotaCreditoSoli=true;

	public Border resaltarotro_valorNotaCreditoSoli=null;
	public Boolean mostrarotro_valorNotaCreditoSoli=true;
	public Boolean activarotro_valorNotaCreditoSoli=true;

	public Border resaltarretencionNotaCreditoSoli=null;
	public Boolean mostrarretencionNotaCreditoSoli=true;
	public Boolean activarretencionNotaCreditoSoli=false;

	public Border resaltariceNotaCreditoSoli=null;
	public Boolean mostrariceNotaCreditoSoli=true;
	public Boolean activariceNotaCreditoSoli=false;

	public Border resaltarfechaNotaCreditoSoli=null;
	public Boolean mostrarfechaNotaCreditoSoli=true;
	public Boolean activarfechaNotaCreditoSoli=false;

	public Border resaltarid_centro_costoNotaCreditoSoli=null;
	public Boolean mostrarid_centro_costoNotaCreditoSoli=true;
	public Boolean activarid_centro_costoNotaCreditoSoli=false;
	public Boolean cargarid_centro_costoNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_vendedorNotaCreditoSoli=null;
	public Boolean mostrarid_vendedorNotaCreditoSoli=true;
	public Boolean activarid_vendedorNotaCreditoSoli=false;
	public Boolean cargarid_vendedorNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_tipo_cambioNotaCreditoSoli=null;
	public Boolean mostrarid_tipo_cambioNotaCreditoSoli=true;
	public Boolean activarid_tipo_cambioNotaCreditoSoli=false;
	public Boolean cargarid_tipo_cambioNotaCreditoSoli=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cambioNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_transporteNotaCreditoSoli=null;
	public Boolean mostrarid_transporteNotaCreditoSoli=true;
	public Boolean activarid_transporteNotaCreditoSoli=false;
	public Boolean cargarid_transporteNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transporteNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_transportistaNotaCreditoSoli=null;
	public Boolean mostrarid_transportistaNotaCreditoSoli=true;
	public Boolean activarid_transportistaNotaCreditoSoli=false;
	public Boolean cargarid_transportistaNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transportistaNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarfecha_clienteNotaCreditoSoli=null;
	public Boolean mostrarfecha_clienteNotaCreditoSoli=true;
	public Boolean activarfecha_clienteNotaCreditoSoli=false;

	public Border resaltarfecha_autorizacionNotaCreditoSoli=null;
	public Boolean mostrarfecha_autorizacionNotaCreditoSoli=true;
	public Boolean activarfecha_autorizacionNotaCreditoSoli=false;

	
	

	public Border setResaltaridNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltaridNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridNotaCreditoSoli() {
		return this.resaltaridNotaCreditoSoli;
	}

	public void setResaltaridNotaCreditoSoli(Border borderResaltar) {
		this.resaltaridNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostraridNotaCreditoSoli() {
		return this.mostraridNotaCreditoSoli;
	}

	public void setMostraridNotaCreditoSoli(Boolean mostraridNotaCreditoSoli) {
		this.mostraridNotaCreditoSoli= mostraridNotaCreditoSoli;
	}

	public Boolean getActivaridNotaCreditoSoli() {
		return this.activaridNotaCreditoSoli;
	}

	public void setActivaridNotaCreditoSoli(Boolean activaridNotaCreditoSoli) {
		this.activaridNotaCreditoSoli= activaridNotaCreditoSoli;
	}

	public Border setResaltarid_empresaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_empresaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaNotaCreditoSoli() {
		return this.resaltarid_empresaNotaCreditoSoli;
	}

	public void setResaltarid_empresaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_empresaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_empresaNotaCreditoSoli() {
		return this.mostrarid_empresaNotaCreditoSoli;
	}

	public void setMostrarid_empresaNotaCreditoSoli(Boolean mostrarid_empresaNotaCreditoSoli) {
		this.mostrarid_empresaNotaCreditoSoli= mostrarid_empresaNotaCreditoSoli;
	}

	public Boolean getActivarid_empresaNotaCreditoSoli() {
		return this.activarid_empresaNotaCreditoSoli;
	}

	public void setActivarid_empresaNotaCreditoSoli(Boolean activarid_empresaNotaCreditoSoli) {
		this.activarid_empresaNotaCreditoSoli= activarid_empresaNotaCreditoSoli;
	}

	public Boolean getCargarid_empresaNotaCreditoSoli() {
		return this.cargarid_empresaNotaCreditoSoli;
	}

	public void setCargarid_empresaNotaCreditoSoli(Boolean cargarid_empresaNotaCreditoSoli) {
		this.cargarid_empresaNotaCreditoSoli= cargarid_empresaNotaCreditoSoli;
	}

	public Border setResaltarid_sucursalNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_sucursalNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalNotaCreditoSoli() {
		return this.resaltarid_sucursalNotaCreditoSoli;
	}

	public void setResaltarid_sucursalNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_sucursalNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_sucursalNotaCreditoSoli() {
		return this.mostrarid_sucursalNotaCreditoSoli;
	}

	public void setMostrarid_sucursalNotaCreditoSoli(Boolean mostrarid_sucursalNotaCreditoSoli) {
		this.mostrarid_sucursalNotaCreditoSoli= mostrarid_sucursalNotaCreditoSoli;
	}

	public Boolean getActivarid_sucursalNotaCreditoSoli() {
		return this.activarid_sucursalNotaCreditoSoli;
	}

	public void setActivarid_sucursalNotaCreditoSoli(Boolean activarid_sucursalNotaCreditoSoli) {
		this.activarid_sucursalNotaCreditoSoli= activarid_sucursalNotaCreditoSoli;
	}

	public Boolean getCargarid_sucursalNotaCreditoSoli() {
		return this.cargarid_sucursalNotaCreditoSoli;
	}

	public void setCargarid_sucursalNotaCreditoSoli(Boolean cargarid_sucursalNotaCreditoSoli) {
		this.cargarid_sucursalNotaCreditoSoli= cargarid_sucursalNotaCreditoSoli;
	}

	public Border setResaltarid_ejercicioNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioNotaCreditoSoli() {
		return this.resaltarid_ejercicioNotaCreditoSoli;
	}

	public void setResaltarid_ejercicioNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_ejercicioNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioNotaCreditoSoli() {
		return this.mostrarid_ejercicioNotaCreditoSoli;
	}

	public void setMostrarid_ejercicioNotaCreditoSoli(Boolean mostrarid_ejercicioNotaCreditoSoli) {
		this.mostrarid_ejercicioNotaCreditoSoli= mostrarid_ejercicioNotaCreditoSoli;
	}

	public Boolean getActivarid_ejercicioNotaCreditoSoli() {
		return this.activarid_ejercicioNotaCreditoSoli;
	}

	public void setActivarid_ejercicioNotaCreditoSoli(Boolean activarid_ejercicioNotaCreditoSoli) {
		this.activarid_ejercicioNotaCreditoSoli= activarid_ejercicioNotaCreditoSoli;
	}

	public Boolean getCargarid_ejercicioNotaCreditoSoli() {
		return this.cargarid_ejercicioNotaCreditoSoli;
	}

	public void setCargarid_ejercicioNotaCreditoSoli(Boolean cargarid_ejercicioNotaCreditoSoli) {
		this.cargarid_ejercicioNotaCreditoSoli= cargarid_ejercicioNotaCreditoSoli;
	}

	public Border setResaltarid_periodoNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_periodoNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoNotaCreditoSoli() {
		return this.resaltarid_periodoNotaCreditoSoli;
	}

	public void setResaltarid_periodoNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_periodoNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_periodoNotaCreditoSoli() {
		return this.mostrarid_periodoNotaCreditoSoli;
	}

	public void setMostrarid_periodoNotaCreditoSoli(Boolean mostrarid_periodoNotaCreditoSoli) {
		this.mostrarid_periodoNotaCreditoSoli= mostrarid_periodoNotaCreditoSoli;
	}

	public Boolean getActivarid_periodoNotaCreditoSoli() {
		return this.activarid_periodoNotaCreditoSoli;
	}

	public void setActivarid_periodoNotaCreditoSoli(Boolean activarid_periodoNotaCreditoSoli) {
		this.activarid_periodoNotaCreditoSoli= activarid_periodoNotaCreditoSoli;
	}

	public Boolean getCargarid_periodoNotaCreditoSoli() {
		return this.cargarid_periodoNotaCreditoSoli;
	}

	public void setCargarid_periodoNotaCreditoSoli(Boolean cargarid_periodoNotaCreditoSoli) {
		this.cargarid_periodoNotaCreditoSoli= cargarid_periodoNotaCreditoSoli;
	}

	public Border setResaltarid_anioNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_anioNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioNotaCreditoSoli() {
		return this.resaltarid_anioNotaCreditoSoli;
	}

	public void setResaltarid_anioNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_anioNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_anioNotaCreditoSoli() {
		return this.mostrarid_anioNotaCreditoSoli;
	}

	public void setMostrarid_anioNotaCreditoSoli(Boolean mostrarid_anioNotaCreditoSoli) {
		this.mostrarid_anioNotaCreditoSoli= mostrarid_anioNotaCreditoSoli;
	}

	public Boolean getActivarid_anioNotaCreditoSoli() {
		return this.activarid_anioNotaCreditoSoli;
	}

	public void setActivarid_anioNotaCreditoSoli(Boolean activarid_anioNotaCreditoSoli) {
		this.activarid_anioNotaCreditoSoli= activarid_anioNotaCreditoSoli;
	}

	public Boolean getCargarid_anioNotaCreditoSoli() {
		return this.cargarid_anioNotaCreditoSoli;
	}

	public void setCargarid_anioNotaCreditoSoli(Boolean cargarid_anioNotaCreditoSoli) {
		this.cargarid_anioNotaCreditoSoli= cargarid_anioNotaCreditoSoli;
	}

	public Border setResaltarid_mesNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_mesNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesNotaCreditoSoli() {
		return this.resaltarid_mesNotaCreditoSoli;
	}

	public void setResaltarid_mesNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_mesNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_mesNotaCreditoSoli() {
		return this.mostrarid_mesNotaCreditoSoli;
	}

	public void setMostrarid_mesNotaCreditoSoli(Boolean mostrarid_mesNotaCreditoSoli) {
		this.mostrarid_mesNotaCreditoSoli= mostrarid_mesNotaCreditoSoli;
	}

	public Boolean getActivarid_mesNotaCreditoSoli() {
		return this.activarid_mesNotaCreditoSoli;
	}

	public void setActivarid_mesNotaCreditoSoli(Boolean activarid_mesNotaCreditoSoli) {
		this.activarid_mesNotaCreditoSoli= activarid_mesNotaCreditoSoli;
	}

	public Boolean getCargarid_mesNotaCreditoSoli() {
		return this.cargarid_mesNotaCreditoSoli;
	}

	public void setCargarid_mesNotaCreditoSoli(Boolean cargarid_mesNotaCreditoSoli) {
		this.cargarid_mesNotaCreditoSoli= cargarid_mesNotaCreditoSoli;
	}

	public Border setResaltarid_usuarioNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_usuarioNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioNotaCreditoSoli() {
		return this.resaltarid_usuarioNotaCreditoSoli;
	}

	public void setResaltarid_usuarioNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_usuarioNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_usuarioNotaCreditoSoli() {
		return this.mostrarid_usuarioNotaCreditoSoli;
	}

	public void setMostrarid_usuarioNotaCreditoSoli(Boolean mostrarid_usuarioNotaCreditoSoli) {
		this.mostrarid_usuarioNotaCreditoSoli= mostrarid_usuarioNotaCreditoSoli;
	}

	public Boolean getActivarid_usuarioNotaCreditoSoli() {
		return this.activarid_usuarioNotaCreditoSoli;
	}

	public void setActivarid_usuarioNotaCreditoSoli(Boolean activarid_usuarioNotaCreditoSoli) {
		this.activarid_usuarioNotaCreditoSoli= activarid_usuarioNotaCreditoSoli;
	}

	public Boolean getCargarid_usuarioNotaCreditoSoli() {
		return this.cargarid_usuarioNotaCreditoSoli;
	}

	public void setCargarid_usuarioNotaCreditoSoli(Boolean cargarid_usuarioNotaCreditoSoli) {
		this.cargarid_usuarioNotaCreditoSoli= cargarid_usuarioNotaCreditoSoli;
	}

	public Border setResaltarcodigoNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarcodigoNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoNotaCreditoSoli() {
		return this.resaltarcodigoNotaCreditoSoli;
	}

	public void setResaltarcodigoNotaCreditoSoli(Border borderResaltar) {
		this.resaltarcodigoNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarcodigoNotaCreditoSoli() {
		return this.mostrarcodigoNotaCreditoSoli;
	}

	public void setMostrarcodigoNotaCreditoSoli(Boolean mostrarcodigoNotaCreditoSoli) {
		this.mostrarcodigoNotaCreditoSoli= mostrarcodigoNotaCreditoSoli;
	}

	public Boolean getActivarcodigoNotaCreditoSoli() {
		return this.activarcodigoNotaCreditoSoli;
	}

	public void setActivarcodigoNotaCreditoSoli(Boolean activarcodigoNotaCreditoSoli) {
		this.activarcodigoNotaCreditoSoli= activarcodigoNotaCreditoSoli;
	}

	public Border setResaltarnumeroNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarnumeroNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroNotaCreditoSoli() {
		return this.resaltarnumeroNotaCreditoSoli;
	}

	public void setResaltarnumeroNotaCreditoSoli(Border borderResaltar) {
		this.resaltarnumeroNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarnumeroNotaCreditoSoli() {
		return this.mostrarnumeroNotaCreditoSoli;
	}

	public void setMostrarnumeroNotaCreditoSoli(Boolean mostrarnumeroNotaCreditoSoli) {
		this.mostrarnumeroNotaCreditoSoli= mostrarnumeroNotaCreditoSoli;
	}

	public Boolean getActivarnumeroNotaCreditoSoli() {
		return this.activarnumeroNotaCreditoSoli;
	}

	public void setActivarnumeroNotaCreditoSoli(Boolean activarnumeroNotaCreditoSoli) {
		this.activarnumeroNotaCreditoSoli= activarnumeroNotaCreditoSoli;
	}

	public Border setResaltarfecha_emisionNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionNotaCreditoSoli() {
		return this.resaltarfecha_emisionNotaCreditoSoli;
	}

	public void setResaltarfecha_emisionNotaCreditoSoli(Border borderResaltar) {
		this.resaltarfecha_emisionNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionNotaCreditoSoli() {
		return this.mostrarfecha_emisionNotaCreditoSoli;
	}

	public void setMostrarfecha_emisionNotaCreditoSoli(Boolean mostrarfecha_emisionNotaCreditoSoli) {
		this.mostrarfecha_emisionNotaCreditoSoli= mostrarfecha_emisionNotaCreditoSoli;
	}

	public Boolean getActivarfecha_emisionNotaCreditoSoli() {
		return this.activarfecha_emisionNotaCreditoSoli;
	}

	public void setActivarfecha_emisionNotaCreditoSoli(Boolean activarfecha_emisionNotaCreditoSoli) {
		this.activarfecha_emisionNotaCreditoSoli= activarfecha_emisionNotaCreditoSoli;
	}

	public Border setResaltarnumero_diasNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarnumero_diasNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_diasNotaCreditoSoli() {
		return this.resaltarnumero_diasNotaCreditoSoli;
	}

	public void setResaltarnumero_diasNotaCreditoSoli(Border borderResaltar) {
		this.resaltarnumero_diasNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarnumero_diasNotaCreditoSoli() {
		return this.mostrarnumero_diasNotaCreditoSoli;
	}

	public void setMostrarnumero_diasNotaCreditoSoli(Boolean mostrarnumero_diasNotaCreditoSoli) {
		this.mostrarnumero_diasNotaCreditoSoli= mostrarnumero_diasNotaCreditoSoli;
	}

	public Boolean getActivarnumero_diasNotaCreditoSoli() {
		return this.activarnumero_diasNotaCreditoSoli;
	}

	public void setActivarnumero_diasNotaCreditoSoli(Boolean activarnumero_diasNotaCreditoSoli) {
		this.activarnumero_diasNotaCreditoSoli= activarnumero_diasNotaCreditoSoli;
	}

	public Border setResaltarfecha_vencimientoNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoNotaCreditoSoli() {
		return this.resaltarfecha_vencimientoNotaCreditoSoli;
	}

	public void setResaltarfecha_vencimientoNotaCreditoSoli(Border borderResaltar) {
		this.resaltarfecha_vencimientoNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoNotaCreditoSoli() {
		return this.mostrarfecha_vencimientoNotaCreditoSoli;
	}

	public void setMostrarfecha_vencimientoNotaCreditoSoli(Boolean mostrarfecha_vencimientoNotaCreditoSoli) {
		this.mostrarfecha_vencimientoNotaCreditoSoli= mostrarfecha_vencimientoNotaCreditoSoli;
	}

	public Boolean getActivarfecha_vencimientoNotaCreditoSoli() {
		return this.activarfecha_vencimientoNotaCreditoSoli;
	}

	public void setActivarfecha_vencimientoNotaCreditoSoli(Boolean activarfecha_vencimientoNotaCreditoSoli) {
		this.activarfecha_vencimientoNotaCreditoSoli= activarfecha_vencimientoNotaCreditoSoli;
	}

	public Border setResaltarid_monedaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_monedaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaNotaCreditoSoli() {
		return this.resaltarid_monedaNotaCreditoSoli;
	}

	public void setResaltarid_monedaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_monedaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_monedaNotaCreditoSoli() {
		return this.mostrarid_monedaNotaCreditoSoli;
	}

	public void setMostrarid_monedaNotaCreditoSoli(Boolean mostrarid_monedaNotaCreditoSoli) {
		this.mostrarid_monedaNotaCreditoSoli= mostrarid_monedaNotaCreditoSoli;
	}

	public Boolean getActivarid_monedaNotaCreditoSoli() {
		return this.activarid_monedaNotaCreditoSoli;
	}

	public void setActivarid_monedaNotaCreditoSoli(Boolean activarid_monedaNotaCreditoSoli) {
		this.activarid_monedaNotaCreditoSoli= activarid_monedaNotaCreditoSoli;
	}

	public Boolean getCargarid_monedaNotaCreditoSoli() {
		return this.cargarid_monedaNotaCreditoSoli;
	}

	public void setCargarid_monedaNotaCreditoSoli(Boolean cargarid_monedaNotaCreditoSoli) {
		this.cargarid_monedaNotaCreditoSoli= cargarid_monedaNotaCreditoSoli;
	}

	public Border setResaltarid_empleadoNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_empleadoNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoNotaCreditoSoli() {
		return this.resaltarid_empleadoNotaCreditoSoli;
	}

	public void setResaltarid_empleadoNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_empleadoNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_empleadoNotaCreditoSoli() {
		return this.mostrarid_empleadoNotaCreditoSoli;
	}

	public void setMostrarid_empleadoNotaCreditoSoli(Boolean mostrarid_empleadoNotaCreditoSoli) {
		this.mostrarid_empleadoNotaCreditoSoli= mostrarid_empleadoNotaCreditoSoli;
	}

	public Boolean getActivarid_empleadoNotaCreditoSoli() {
		return this.activarid_empleadoNotaCreditoSoli;
	}

	public void setActivarid_empleadoNotaCreditoSoli(Boolean activarid_empleadoNotaCreditoSoli) {
		this.activarid_empleadoNotaCreditoSoli= activarid_empleadoNotaCreditoSoli;
	}

	public Boolean getCargarid_empleadoNotaCreditoSoli() {
		return this.cargarid_empleadoNotaCreditoSoli;
	}

	public void setCargarid_empleadoNotaCreditoSoli(Boolean cargarid_empleadoNotaCreditoSoli) {
		this.cargarid_empleadoNotaCreditoSoli= cargarid_empleadoNotaCreditoSoli;
	}

	public Border setResaltarcotizacionNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarcotizacionNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcotizacionNotaCreditoSoli() {
		return this.resaltarcotizacionNotaCreditoSoli;
	}

	public void setResaltarcotizacionNotaCreditoSoli(Border borderResaltar) {
		this.resaltarcotizacionNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarcotizacionNotaCreditoSoli() {
		return this.mostrarcotizacionNotaCreditoSoli;
	}

	public void setMostrarcotizacionNotaCreditoSoli(Boolean mostrarcotizacionNotaCreditoSoli) {
		this.mostrarcotizacionNotaCreditoSoli= mostrarcotizacionNotaCreditoSoli;
	}

	public Boolean getActivarcotizacionNotaCreditoSoli() {
		return this.activarcotizacionNotaCreditoSoli;
	}

	public void setActivarcotizacionNotaCreditoSoli(Boolean activarcotizacionNotaCreditoSoli) {
		this.activarcotizacionNotaCreditoSoli= activarcotizacionNotaCreditoSoli;
	}

	public Border setResaltarid_formatoNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_formatoNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoNotaCreditoSoli() {
		return this.resaltarid_formatoNotaCreditoSoli;
	}

	public void setResaltarid_formatoNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_formatoNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_formatoNotaCreditoSoli() {
		return this.mostrarid_formatoNotaCreditoSoli;
	}

	public void setMostrarid_formatoNotaCreditoSoli(Boolean mostrarid_formatoNotaCreditoSoli) {
		this.mostrarid_formatoNotaCreditoSoli= mostrarid_formatoNotaCreditoSoli;
	}

	public Boolean getActivarid_formatoNotaCreditoSoli() {
		return this.activarid_formatoNotaCreditoSoli;
	}

	public void setActivarid_formatoNotaCreditoSoli(Boolean activarid_formatoNotaCreditoSoli) {
		this.activarid_formatoNotaCreditoSoli= activarid_formatoNotaCreditoSoli;
	}

	public Boolean getCargarid_formatoNotaCreditoSoli() {
		return this.cargarid_formatoNotaCreditoSoli;
	}

	public void setCargarid_formatoNotaCreditoSoli(Boolean cargarid_formatoNotaCreditoSoli) {
		this.cargarid_formatoNotaCreditoSoli= cargarid_formatoNotaCreditoSoli;
	}

	public Border setResaltarid_tipo_precioNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_tipo_precioNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_precioNotaCreditoSoli() {
		return this.resaltarid_tipo_precioNotaCreditoSoli;
	}

	public void setResaltarid_tipo_precioNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_tipo_precioNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_tipo_precioNotaCreditoSoli() {
		return this.mostrarid_tipo_precioNotaCreditoSoli;
	}

	public void setMostrarid_tipo_precioNotaCreditoSoli(Boolean mostrarid_tipo_precioNotaCreditoSoli) {
		this.mostrarid_tipo_precioNotaCreditoSoli= mostrarid_tipo_precioNotaCreditoSoli;
	}

	public Boolean getActivarid_tipo_precioNotaCreditoSoli() {
		return this.activarid_tipo_precioNotaCreditoSoli;
	}

	public void setActivarid_tipo_precioNotaCreditoSoli(Boolean activarid_tipo_precioNotaCreditoSoli) {
		this.activarid_tipo_precioNotaCreditoSoli= activarid_tipo_precioNotaCreditoSoli;
	}

	public Boolean getCargarid_tipo_precioNotaCreditoSoli() {
		return this.cargarid_tipo_precioNotaCreditoSoli;
	}

	public void setCargarid_tipo_precioNotaCreditoSoli(Boolean cargarid_tipo_precioNotaCreditoSoli) {
		this.cargarid_tipo_precioNotaCreditoSoli= cargarid_tipo_precioNotaCreditoSoli;
	}

	public Border setResaltarid_clienteNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_clienteNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteNotaCreditoSoli() {
		return this.resaltarid_clienteNotaCreditoSoli;
	}

	public void setResaltarid_clienteNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_clienteNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_clienteNotaCreditoSoli() {
		return this.mostrarid_clienteNotaCreditoSoli;
	}

	public void setMostrarid_clienteNotaCreditoSoli(Boolean mostrarid_clienteNotaCreditoSoli) {
		this.mostrarid_clienteNotaCreditoSoli= mostrarid_clienteNotaCreditoSoli;
	}

	public Boolean getActivarid_clienteNotaCreditoSoli() {
		return this.activarid_clienteNotaCreditoSoli;
	}

	public void setActivarid_clienteNotaCreditoSoli(Boolean activarid_clienteNotaCreditoSoli) {
		this.activarid_clienteNotaCreditoSoli= activarid_clienteNotaCreditoSoli;
	}

	public Boolean getCargarid_clienteNotaCreditoSoli() {
		return this.cargarid_clienteNotaCreditoSoli;
	}

	public void setCargarid_clienteNotaCreditoSoli(Boolean cargarid_clienteNotaCreditoSoli) {
		this.cargarid_clienteNotaCreditoSoli= cargarid_clienteNotaCreditoSoli;
	}

	public Border setResaltarid_facturaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_facturaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaNotaCreditoSoli() {
		return this.resaltarid_facturaNotaCreditoSoli;
	}

	public void setResaltarid_facturaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_facturaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_facturaNotaCreditoSoli() {
		return this.mostrarid_facturaNotaCreditoSoli;
	}

	public void setMostrarid_facturaNotaCreditoSoli(Boolean mostrarid_facturaNotaCreditoSoli) {
		this.mostrarid_facturaNotaCreditoSoli= mostrarid_facturaNotaCreditoSoli;
	}

	public Boolean getActivarid_facturaNotaCreditoSoli() {
		return this.activarid_facturaNotaCreditoSoli;
	}

	public void setActivarid_facturaNotaCreditoSoli(Boolean activarid_facturaNotaCreditoSoli) {
		this.activarid_facturaNotaCreditoSoli= activarid_facturaNotaCreditoSoli;
	}

	public Boolean getCargarid_facturaNotaCreditoSoli() {
		return this.cargarid_facturaNotaCreditoSoli;
	}

	public void setCargarid_facturaNotaCreditoSoli(Boolean cargarid_facturaNotaCreditoSoli) {
		this.cargarid_facturaNotaCreditoSoli= cargarid_facturaNotaCreditoSoli;
	}

	public Border setResaltardireccionNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltardireccionNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionNotaCreditoSoli() {
		return this.resaltardireccionNotaCreditoSoli;
	}

	public void setResaltardireccionNotaCreditoSoli(Border borderResaltar) {
		this.resaltardireccionNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrardireccionNotaCreditoSoli() {
		return this.mostrardireccionNotaCreditoSoli;
	}

	public void setMostrardireccionNotaCreditoSoli(Boolean mostrardireccionNotaCreditoSoli) {
		this.mostrardireccionNotaCreditoSoli= mostrardireccionNotaCreditoSoli;
	}

	public Boolean getActivardireccionNotaCreditoSoli() {
		return this.activardireccionNotaCreditoSoli;
	}

	public void setActivardireccionNotaCreditoSoli(Boolean activardireccionNotaCreditoSoli) {
		this.activardireccionNotaCreditoSoli= activardireccionNotaCreditoSoli;
	}

	public Border setResaltartelefonoNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltartelefonoNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoNotaCreditoSoli() {
		return this.resaltartelefonoNotaCreditoSoli;
	}

	public void setResaltartelefonoNotaCreditoSoli(Border borderResaltar) {
		this.resaltartelefonoNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrartelefonoNotaCreditoSoli() {
		return this.mostrartelefonoNotaCreditoSoli;
	}

	public void setMostrartelefonoNotaCreditoSoli(Boolean mostrartelefonoNotaCreditoSoli) {
		this.mostrartelefonoNotaCreditoSoli= mostrartelefonoNotaCreditoSoli;
	}

	public Boolean getActivartelefonoNotaCreditoSoli() {
		return this.activartelefonoNotaCreditoSoli;
	}

	public void setActivartelefonoNotaCreditoSoli(Boolean activartelefonoNotaCreditoSoli) {
		this.activartelefonoNotaCreditoSoli= activartelefonoNotaCreditoSoli;
	}

	public Border setResaltarrucNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarrucNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucNotaCreditoSoli() {
		return this.resaltarrucNotaCreditoSoli;
	}

	public void setResaltarrucNotaCreditoSoli(Border borderResaltar) {
		this.resaltarrucNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarrucNotaCreditoSoli() {
		return this.mostrarrucNotaCreditoSoli;
	}

	public void setMostrarrucNotaCreditoSoli(Boolean mostrarrucNotaCreditoSoli) {
		this.mostrarrucNotaCreditoSoli= mostrarrucNotaCreditoSoli;
	}

	public Boolean getActivarrucNotaCreditoSoli() {
		return this.activarrucNotaCreditoSoli;
	}

	public void setActivarrucNotaCreditoSoli(Boolean activarrucNotaCreditoSoli) {
		this.activarrucNotaCreditoSoli= activarrucNotaCreditoSoli;
	}

	public Border setResaltarid_tipo_nota_credito_soliNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_tipo_nota_credito_soliNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_nota_credito_soliNotaCreditoSoli() {
		return this.resaltarid_tipo_nota_credito_soliNotaCreditoSoli;
	}

	public void setResaltarid_tipo_nota_credito_soliNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_tipo_nota_credito_soliNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_tipo_nota_credito_soliNotaCreditoSoli() {
		return this.mostrarid_tipo_nota_credito_soliNotaCreditoSoli;
	}

	public void setMostrarid_tipo_nota_credito_soliNotaCreditoSoli(Boolean mostrarid_tipo_nota_credito_soliNotaCreditoSoli) {
		this.mostrarid_tipo_nota_credito_soliNotaCreditoSoli= mostrarid_tipo_nota_credito_soliNotaCreditoSoli;
	}

	public Boolean getActivarid_tipo_nota_credito_soliNotaCreditoSoli() {
		return this.activarid_tipo_nota_credito_soliNotaCreditoSoli;
	}

	public void setActivarid_tipo_nota_credito_soliNotaCreditoSoli(Boolean activarid_tipo_nota_credito_soliNotaCreditoSoli) {
		this.activarid_tipo_nota_credito_soliNotaCreditoSoli= activarid_tipo_nota_credito_soliNotaCreditoSoli;
	}

	public Boolean getCargarid_tipo_nota_credito_soliNotaCreditoSoli() {
		return this.cargarid_tipo_nota_credito_soliNotaCreditoSoli;
	}

	public void setCargarid_tipo_nota_credito_soliNotaCreditoSoli(Boolean cargarid_tipo_nota_credito_soliNotaCreditoSoli) {
		this.cargarid_tipo_nota_credito_soliNotaCreditoSoli= cargarid_tipo_nota_credito_soliNotaCreditoSoli;
	}

	public Border setResaltarid_responsableNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_responsableNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_responsableNotaCreditoSoli() {
		return this.resaltarid_responsableNotaCreditoSoli;
	}

	public void setResaltarid_responsableNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_responsableNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_responsableNotaCreditoSoli() {
		return this.mostrarid_responsableNotaCreditoSoli;
	}

	public void setMostrarid_responsableNotaCreditoSoli(Boolean mostrarid_responsableNotaCreditoSoli) {
		this.mostrarid_responsableNotaCreditoSoli= mostrarid_responsableNotaCreditoSoli;
	}

	public Boolean getActivarid_responsableNotaCreditoSoli() {
		return this.activarid_responsableNotaCreditoSoli;
	}

	public void setActivarid_responsableNotaCreditoSoli(Boolean activarid_responsableNotaCreditoSoli) {
		this.activarid_responsableNotaCreditoSoli= activarid_responsableNotaCreditoSoli;
	}

	public Boolean getCargarid_responsableNotaCreditoSoli() {
		return this.cargarid_responsableNotaCreditoSoli;
	}

	public void setCargarid_responsableNotaCreditoSoli(Boolean cargarid_responsableNotaCreditoSoli) {
		this.cargarid_responsableNotaCreditoSoli= cargarid_responsableNotaCreditoSoli;
	}

	public Border setResaltarid_estado_nota_creditoNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_estado_nota_creditoNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_nota_creditoNotaCreditoSoli() {
		return this.resaltarid_estado_nota_creditoNotaCreditoSoli;
	}

	public void setResaltarid_estado_nota_creditoNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_estado_nota_creditoNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_estado_nota_creditoNotaCreditoSoli() {
		return this.mostrarid_estado_nota_creditoNotaCreditoSoli;
	}

	public void setMostrarid_estado_nota_creditoNotaCreditoSoli(Boolean mostrarid_estado_nota_creditoNotaCreditoSoli) {
		this.mostrarid_estado_nota_creditoNotaCreditoSoli= mostrarid_estado_nota_creditoNotaCreditoSoli;
	}

	public Boolean getActivarid_estado_nota_creditoNotaCreditoSoli() {
		return this.activarid_estado_nota_creditoNotaCreditoSoli;
	}

	public void setActivarid_estado_nota_creditoNotaCreditoSoli(Boolean activarid_estado_nota_creditoNotaCreditoSoli) {
		this.activarid_estado_nota_creditoNotaCreditoSoli= activarid_estado_nota_creditoNotaCreditoSoli;
	}

	public Boolean getCargarid_estado_nota_creditoNotaCreditoSoli() {
		return this.cargarid_estado_nota_creditoNotaCreditoSoli;
	}

	public void setCargarid_estado_nota_creditoNotaCreditoSoli(Boolean cargarid_estado_nota_creditoNotaCreditoSoli) {
		this.cargarid_estado_nota_creditoNotaCreditoSoli= cargarid_estado_nota_creditoNotaCreditoSoli;
	}

	public Border setResaltardescripcionNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltardescripcionNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionNotaCreditoSoli() {
		return this.resaltardescripcionNotaCreditoSoli;
	}

	public void setResaltardescripcionNotaCreditoSoli(Border borderResaltar) {
		this.resaltardescripcionNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrardescripcionNotaCreditoSoli() {
		return this.mostrardescripcionNotaCreditoSoli;
	}

	public void setMostrardescripcionNotaCreditoSoli(Boolean mostrardescripcionNotaCreditoSoli) {
		this.mostrardescripcionNotaCreditoSoli= mostrardescripcionNotaCreditoSoli;
	}

	public Boolean getActivardescripcionNotaCreditoSoli() {
		return this.activardescripcionNotaCreditoSoli;
	}

	public void setActivardescripcionNotaCreditoSoli(Boolean activardescripcionNotaCreditoSoli) {
		this.activardescripcionNotaCreditoSoli= activardescripcionNotaCreditoSoli;
	}

	public Border setResaltarpenalizadoNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarpenalizadoNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpenalizadoNotaCreditoSoli() {
		return this.resaltarpenalizadoNotaCreditoSoli;
	}

	public void setResaltarpenalizadoNotaCreditoSoli(Border borderResaltar) {
		this.resaltarpenalizadoNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarpenalizadoNotaCreditoSoli() {
		return this.mostrarpenalizadoNotaCreditoSoli;
	}

	public void setMostrarpenalizadoNotaCreditoSoli(Boolean mostrarpenalizadoNotaCreditoSoli) {
		this.mostrarpenalizadoNotaCreditoSoli= mostrarpenalizadoNotaCreditoSoli;
	}

	public Boolean getActivarpenalizadoNotaCreditoSoli() {
		return this.activarpenalizadoNotaCreditoSoli;
	}

	public void setActivarpenalizadoNotaCreditoSoli(Boolean activarpenalizadoNotaCreditoSoli) {
		this.activarpenalizadoNotaCreditoSoli= activarpenalizadoNotaCreditoSoli;
	}

	public Border setResaltardescuento_porcentajeNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltardescuento_porcentajeNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_porcentajeNotaCreditoSoli() {
		return this.resaltardescuento_porcentajeNotaCreditoSoli;
	}

	public void setResaltardescuento_porcentajeNotaCreditoSoli(Border borderResaltar) {
		this.resaltardescuento_porcentajeNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrardescuento_porcentajeNotaCreditoSoli() {
		return this.mostrardescuento_porcentajeNotaCreditoSoli;
	}

	public void setMostrardescuento_porcentajeNotaCreditoSoli(Boolean mostrardescuento_porcentajeNotaCreditoSoli) {
		this.mostrardescuento_porcentajeNotaCreditoSoli= mostrardescuento_porcentajeNotaCreditoSoli;
	}

	public Boolean getActivardescuento_porcentajeNotaCreditoSoli() {
		return this.activardescuento_porcentajeNotaCreditoSoli;
	}

	public void setActivardescuento_porcentajeNotaCreditoSoli(Boolean activardescuento_porcentajeNotaCreditoSoli) {
		this.activardescuento_porcentajeNotaCreditoSoli= activardescuento_porcentajeNotaCreditoSoli;
	}

	public Border setResaltartotal_ivaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltartotal_ivaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ivaNotaCreditoSoli() {
		return this.resaltartotal_ivaNotaCreditoSoli;
	}

	public void setResaltartotal_ivaNotaCreditoSoli(Border borderResaltar) {
		this.resaltartotal_ivaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrartotal_ivaNotaCreditoSoli() {
		return this.mostrartotal_ivaNotaCreditoSoli;
	}

	public void setMostrartotal_ivaNotaCreditoSoli(Boolean mostrartotal_ivaNotaCreditoSoli) {
		this.mostrartotal_ivaNotaCreditoSoli= mostrartotal_ivaNotaCreditoSoli;
	}

	public Boolean getActivartotal_ivaNotaCreditoSoli() {
		return this.activartotal_ivaNotaCreditoSoli;
	}

	public void setActivartotal_ivaNotaCreditoSoli(Boolean activartotal_ivaNotaCreditoSoli) {
		this.activartotal_ivaNotaCreditoSoli= activartotal_ivaNotaCreditoSoli;
	}

	public Border setResaltarsumanNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarsumanNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsumanNotaCreditoSoli() {
		return this.resaltarsumanNotaCreditoSoli;
	}

	public void setResaltarsumanNotaCreditoSoli(Border borderResaltar) {
		this.resaltarsumanNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarsumanNotaCreditoSoli() {
		return this.mostrarsumanNotaCreditoSoli;
	}

	public void setMostrarsumanNotaCreditoSoli(Boolean mostrarsumanNotaCreditoSoli) {
		this.mostrarsumanNotaCreditoSoli= mostrarsumanNotaCreditoSoli;
	}

	public Boolean getActivarsumanNotaCreditoSoli() {
		return this.activarsumanNotaCreditoSoli;
	}

	public void setActivarsumanNotaCreditoSoli(Boolean activarsumanNotaCreditoSoli) {
		this.activarsumanNotaCreditoSoli= activarsumanNotaCreditoSoli;
	}

	public Border setResaltardescuento_valorNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltardescuento_valorNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_valorNotaCreditoSoli() {
		return this.resaltardescuento_valorNotaCreditoSoli;
	}

	public void setResaltardescuento_valorNotaCreditoSoli(Border borderResaltar) {
		this.resaltardescuento_valorNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrardescuento_valorNotaCreditoSoli() {
		return this.mostrardescuento_valorNotaCreditoSoli;
	}

	public void setMostrardescuento_valorNotaCreditoSoli(Boolean mostrardescuento_valorNotaCreditoSoli) {
		this.mostrardescuento_valorNotaCreditoSoli= mostrardescuento_valorNotaCreditoSoli;
	}

	public Boolean getActivardescuento_valorNotaCreditoSoli() {
		return this.activardescuento_valorNotaCreditoSoli;
	}

	public void setActivardescuento_valorNotaCreditoSoli(Boolean activardescuento_valorNotaCreditoSoli) {
		this.activardescuento_valorNotaCreditoSoli= activardescuento_valorNotaCreditoSoli;
	}

	public Border setResaltartotal_sin_ivaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltartotal_sin_ivaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_sin_ivaNotaCreditoSoli() {
		return this.resaltartotal_sin_ivaNotaCreditoSoli;
	}

	public void setResaltartotal_sin_ivaNotaCreditoSoli(Border borderResaltar) {
		this.resaltartotal_sin_ivaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrartotal_sin_ivaNotaCreditoSoli() {
		return this.mostrartotal_sin_ivaNotaCreditoSoli;
	}

	public void setMostrartotal_sin_ivaNotaCreditoSoli(Boolean mostrartotal_sin_ivaNotaCreditoSoli) {
		this.mostrartotal_sin_ivaNotaCreditoSoli= mostrartotal_sin_ivaNotaCreditoSoli;
	}

	public Boolean getActivartotal_sin_ivaNotaCreditoSoli() {
		return this.activartotal_sin_ivaNotaCreditoSoli;
	}

	public void setActivartotal_sin_ivaNotaCreditoSoli(Boolean activartotal_sin_ivaNotaCreditoSoli) {
		this.activartotal_sin_ivaNotaCreditoSoli= activartotal_sin_ivaNotaCreditoSoli;
	}

	public Border setResaltardescuento_generalNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltardescuento_generalNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_generalNotaCreditoSoli() {
		return this.resaltardescuento_generalNotaCreditoSoli;
	}

	public void setResaltardescuento_generalNotaCreditoSoli(Border borderResaltar) {
		this.resaltardescuento_generalNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrardescuento_generalNotaCreditoSoli() {
		return this.mostrardescuento_generalNotaCreditoSoli;
	}

	public void setMostrardescuento_generalNotaCreditoSoli(Boolean mostrardescuento_generalNotaCreditoSoli) {
		this.mostrardescuento_generalNotaCreditoSoli= mostrardescuento_generalNotaCreditoSoli;
	}

	public Boolean getActivardescuento_generalNotaCreditoSoli() {
		return this.activardescuento_generalNotaCreditoSoli;
	}

	public void setActivardescuento_generalNotaCreditoSoli(Boolean activardescuento_generalNotaCreditoSoli) {
		this.activardescuento_generalNotaCreditoSoli= activardescuento_generalNotaCreditoSoli;
	}

	public Border setResaltarfleteNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarfleteNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfleteNotaCreditoSoli() {
		return this.resaltarfleteNotaCreditoSoli;
	}

	public void setResaltarfleteNotaCreditoSoli(Border borderResaltar) {
		this.resaltarfleteNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarfleteNotaCreditoSoli() {
		return this.mostrarfleteNotaCreditoSoli;
	}

	public void setMostrarfleteNotaCreditoSoli(Boolean mostrarfleteNotaCreditoSoli) {
		this.mostrarfleteNotaCreditoSoli= mostrarfleteNotaCreditoSoli;
	}

	public Boolean getActivarfleteNotaCreditoSoli() {
		return this.activarfleteNotaCreditoSoli;
	}

	public void setActivarfleteNotaCreditoSoli(Boolean activarfleteNotaCreditoSoli) {
		this.activarfleteNotaCreditoSoli= activarfleteNotaCreditoSoli;
	}

	public Border setResaltartotalNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltartotalNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalNotaCreditoSoli() {
		return this.resaltartotalNotaCreditoSoli;
	}

	public void setResaltartotalNotaCreditoSoli(Border borderResaltar) {
		this.resaltartotalNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrartotalNotaCreditoSoli() {
		return this.mostrartotalNotaCreditoSoli;
	}

	public void setMostrartotalNotaCreditoSoli(Boolean mostrartotalNotaCreditoSoli) {
		this.mostrartotalNotaCreditoSoli= mostrartotalNotaCreditoSoli;
	}

	public Boolean getActivartotalNotaCreditoSoli() {
		return this.activartotalNotaCreditoSoli;
	}

	public void setActivartotalNotaCreditoSoli(Boolean activartotalNotaCreditoSoli) {
		this.activartotalNotaCreditoSoli= activartotalNotaCreditoSoli;
	}

	public Border setResaltarsub_totalNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarsub_totalNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_totalNotaCreditoSoli() {
		return this.resaltarsub_totalNotaCreditoSoli;
	}

	public void setResaltarsub_totalNotaCreditoSoli(Border borderResaltar) {
		this.resaltarsub_totalNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarsub_totalNotaCreditoSoli() {
		return this.mostrarsub_totalNotaCreditoSoli;
	}

	public void setMostrarsub_totalNotaCreditoSoli(Boolean mostrarsub_totalNotaCreditoSoli) {
		this.mostrarsub_totalNotaCreditoSoli= mostrarsub_totalNotaCreditoSoli;
	}

	public Boolean getActivarsub_totalNotaCreditoSoli() {
		return this.activarsub_totalNotaCreditoSoli;
	}

	public void setActivarsub_totalNotaCreditoSoli(Boolean activarsub_totalNotaCreditoSoli) {
		this.activarsub_totalNotaCreditoSoli= activarsub_totalNotaCreditoSoli;
	}

	public Border setResaltarotroNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarotroNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotroNotaCreditoSoli() {
		return this.resaltarotroNotaCreditoSoli;
	}

	public void setResaltarotroNotaCreditoSoli(Border borderResaltar) {
		this.resaltarotroNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarotroNotaCreditoSoli() {
		return this.mostrarotroNotaCreditoSoli;
	}

	public void setMostrarotroNotaCreditoSoli(Boolean mostrarotroNotaCreditoSoli) {
		this.mostrarotroNotaCreditoSoli= mostrarotroNotaCreditoSoli;
	}

	public Boolean getActivarotroNotaCreditoSoli() {
		return this.activarotroNotaCreditoSoli;
	}

	public void setActivarotroNotaCreditoSoli(Boolean activarotroNotaCreditoSoli) {
		this.activarotroNotaCreditoSoli= activarotroNotaCreditoSoli;
	}

	public Border setResaltarivaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarivaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaNotaCreditoSoli() {
		return this.resaltarivaNotaCreditoSoli;
	}

	public void setResaltarivaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarivaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarivaNotaCreditoSoli() {
		return this.mostrarivaNotaCreditoSoli;
	}

	public void setMostrarivaNotaCreditoSoli(Boolean mostrarivaNotaCreditoSoli) {
		this.mostrarivaNotaCreditoSoli= mostrarivaNotaCreditoSoli;
	}

	public Boolean getActivarivaNotaCreditoSoli() {
		return this.activarivaNotaCreditoSoli;
	}

	public void setActivarivaNotaCreditoSoli(Boolean activarivaNotaCreditoSoli) {
		this.activarivaNotaCreditoSoli= activarivaNotaCreditoSoli;
	}

	public Border setResaltarfinanciamientoNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarfinanciamientoNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfinanciamientoNotaCreditoSoli() {
		return this.resaltarfinanciamientoNotaCreditoSoli;
	}

	public void setResaltarfinanciamientoNotaCreditoSoli(Border borderResaltar) {
		this.resaltarfinanciamientoNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarfinanciamientoNotaCreditoSoli() {
		return this.mostrarfinanciamientoNotaCreditoSoli;
	}

	public void setMostrarfinanciamientoNotaCreditoSoli(Boolean mostrarfinanciamientoNotaCreditoSoli) {
		this.mostrarfinanciamientoNotaCreditoSoli= mostrarfinanciamientoNotaCreditoSoli;
	}

	public Boolean getActivarfinanciamientoNotaCreditoSoli() {
		return this.activarfinanciamientoNotaCreditoSoli;
	}

	public void setActivarfinanciamientoNotaCreditoSoli(Boolean activarfinanciamientoNotaCreditoSoli) {
		this.activarfinanciamientoNotaCreditoSoli= activarfinanciamientoNotaCreditoSoli;
	}

	public Border setResaltarotro_valorNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarotro_valorNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotro_valorNotaCreditoSoli() {
		return this.resaltarotro_valorNotaCreditoSoli;
	}

	public void setResaltarotro_valorNotaCreditoSoli(Border borderResaltar) {
		this.resaltarotro_valorNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarotro_valorNotaCreditoSoli() {
		return this.mostrarotro_valorNotaCreditoSoli;
	}

	public void setMostrarotro_valorNotaCreditoSoli(Boolean mostrarotro_valorNotaCreditoSoli) {
		this.mostrarotro_valorNotaCreditoSoli= mostrarotro_valorNotaCreditoSoli;
	}

	public Boolean getActivarotro_valorNotaCreditoSoli() {
		return this.activarotro_valorNotaCreditoSoli;
	}

	public void setActivarotro_valorNotaCreditoSoli(Boolean activarotro_valorNotaCreditoSoli) {
		this.activarotro_valorNotaCreditoSoli= activarotro_valorNotaCreditoSoli;
	}

	public Border setResaltarretencionNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarretencionNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarretencionNotaCreditoSoli() {
		return this.resaltarretencionNotaCreditoSoli;
	}

	public void setResaltarretencionNotaCreditoSoli(Border borderResaltar) {
		this.resaltarretencionNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarretencionNotaCreditoSoli() {
		return this.mostrarretencionNotaCreditoSoli;
	}

	public void setMostrarretencionNotaCreditoSoli(Boolean mostrarretencionNotaCreditoSoli) {
		this.mostrarretencionNotaCreditoSoli= mostrarretencionNotaCreditoSoli;
	}

	public Boolean getActivarretencionNotaCreditoSoli() {
		return this.activarretencionNotaCreditoSoli;
	}

	public void setActivarretencionNotaCreditoSoli(Boolean activarretencionNotaCreditoSoli) {
		this.activarretencionNotaCreditoSoli= activarretencionNotaCreditoSoli;
	}

	public Border setResaltariceNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltariceNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceNotaCreditoSoli() {
		return this.resaltariceNotaCreditoSoli;
	}

	public void setResaltariceNotaCreditoSoli(Border borderResaltar) {
		this.resaltariceNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrariceNotaCreditoSoli() {
		return this.mostrariceNotaCreditoSoli;
	}

	public void setMostrariceNotaCreditoSoli(Boolean mostrariceNotaCreditoSoli) {
		this.mostrariceNotaCreditoSoli= mostrariceNotaCreditoSoli;
	}

	public Boolean getActivariceNotaCreditoSoli() {
		return this.activariceNotaCreditoSoli;
	}

	public void setActivariceNotaCreditoSoli(Boolean activariceNotaCreditoSoli) {
		this.activariceNotaCreditoSoli= activariceNotaCreditoSoli;
	}

	public Border setResaltarfechaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarfechaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaNotaCreditoSoli() {
		return this.resaltarfechaNotaCreditoSoli;
	}

	public void setResaltarfechaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarfechaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarfechaNotaCreditoSoli() {
		return this.mostrarfechaNotaCreditoSoli;
	}

	public void setMostrarfechaNotaCreditoSoli(Boolean mostrarfechaNotaCreditoSoli) {
		this.mostrarfechaNotaCreditoSoli= mostrarfechaNotaCreditoSoli;
	}

	public Boolean getActivarfechaNotaCreditoSoli() {
		return this.activarfechaNotaCreditoSoli;
	}

	public void setActivarfechaNotaCreditoSoli(Boolean activarfechaNotaCreditoSoli) {
		this.activarfechaNotaCreditoSoli= activarfechaNotaCreditoSoli;
	}

	public Border setResaltarid_centro_costoNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoNotaCreditoSoli() {
		return this.resaltarid_centro_costoNotaCreditoSoli;
	}

	public void setResaltarid_centro_costoNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_centro_costoNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoNotaCreditoSoli() {
		return this.mostrarid_centro_costoNotaCreditoSoli;
	}

	public void setMostrarid_centro_costoNotaCreditoSoli(Boolean mostrarid_centro_costoNotaCreditoSoli) {
		this.mostrarid_centro_costoNotaCreditoSoli= mostrarid_centro_costoNotaCreditoSoli;
	}

	public Boolean getActivarid_centro_costoNotaCreditoSoli() {
		return this.activarid_centro_costoNotaCreditoSoli;
	}

	public void setActivarid_centro_costoNotaCreditoSoli(Boolean activarid_centro_costoNotaCreditoSoli) {
		this.activarid_centro_costoNotaCreditoSoli= activarid_centro_costoNotaCreditoSoli;
	}

	public Boolean getCargarid_centro_costoNotaCreditoSoli() {
		return this.cargarid_centro_costoNotaCreditoSoli;
	}

	public void setCargarid_centro_costoNotaCreditoSoli(Boolean cargarid_centro_costoNotaCreditoSoli) {
		this.cargarid_centro_costoNotaCreditoSoli= cargarid_centro_costoNotaCreditoSoli;
	}

	public Border setResaltarid_vendedorNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_vendedorNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorNotaCreditoSoli() {
		return this.resaltarid_vendedorNotaCreditoSoli;
	}

	public void setResaltarid_vendedorNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_vendedorNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_vendedorNotaCreditoSoli() {
		return this.mostrarid_vendedorNotaCreditoSoli;
	}

	public void setMostrarid_vendedorNotaCreditoSoli(Boolean mostrarid_vendedorNotaCreditoSoli) {
		this.mostrarid_vendedorNotaCreditoSoli= mostrarid_vendedorNotaCreditoSoli;
	}

	public Boolean getActivarid_vendedorNotaCreditoSoli() {
		return this.activarid_vendedorNotaCreditoSoli;
	}

	public void setActivarid_vendedorNotaCreditoSoli(Boolean activarid_vendedorNotaCreditoSoli) {
		this.activarid_vendedorNotaCreditoSoli= activarid_vendedorNotaCreditoSoli;
	}

	public Boolean getCargarid_vendedorNotaCreditoSoli() {
		return this.cargarid_vendedorNotaCreditoSoli;
	}

	public void setCargarid_vendedorNotaCreditoSoli(Boolean cargarid_vendedorNotaCreditoSoli) {
		this.cargarid_vendedorNotaCreditoSoli= cargarid_vendedorNotaCreditoSoli;
	}

	public Border setResaltarid_tipo_cambioNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cambioNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cambioNotaCreditoSoli() {
		return this.resaltarid_tipo_cambioNotaCreditoSoli;
	}

	public void setResaltarid_tipo_cambioNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_tipo_cambioNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cambioNotaCreditoSoli() {
		return this.mostrarid_tipo_cambioNotaCreditoSoli;
	}

	public void setMostrarid_tipo_cambioNotaCreditoSoli(Boolean mostrarid_tipo_cambioNotaCreditoSoli) {
		this.mostrarid_tipo_cambioNotaCreditoSoli= mostrarid_tipo_cambioNotaCreditoSoli;
	}

	public Boolean getActivarid_tipo_cambioNotaCreditoSoli() {
		return this.activarid_tipo_cambioNotaCreditoSoli;
	}

	public void setActivarid_tipo_cambioNotaCreditoSoli(Boolean activarid_tipo_cambioNotaCreditoSoli) {
		this.activarid_tipo_cambioNotaCreditoSoli= activarid_tipo_cambioNotaCreditoSoli;
	}

	public Boolean getCargarid_tipo_cambioNotaCreditoSoli() {
		return this.cargarid_tipo_cambioNotaCreditoSoli;
	}

	public void setCargarid_tipo_cambioNotaCreditoSoli(Boolean cargarid_tipo_cambioNotaCreditoSoli) {
		this.cargarid_tipo_cambioNotaCreditoSoli= cargarid_tipo_cambioNotaCreditoSoli;
	}

	public Border setResaltarid_transporteNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_transporteNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transporteNotaCreditoSoli() {
		return this.resaltarid_transporteNotaCreditoSoli;
	}

	public void setResaltarid_transporteNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_transporteNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_transporteNotaCreditoSoli() {
		return this.mostrarid_transporteNotaCreditoSoli;
	}

	public void setMostrarid_transporteNotaCreditoSoli(Boolean mostrarid_transporteNotaCreditoSoli) {
		this.mostrarid_transporteNotaCreditoSoli= mostrarid_transporteNotaCreditoSoli;
	}

	public Boolean getActivarid_transporteNotaCreditoSoli() {
		return this.activarid_transporteNotaCreditoSoli;
	}

	public void setActivarid_transporteNotaCreditoSoli(Boolean activarid_transporteNotaCreditoSoli) {
		this.activarid_transporteNotaCreditoSoli= activarid_transporteNotaCreditoSoli;
	}

	public Boolean getCargarid_transporteNotaCreditoSoli() {
		return this.cargarid_transporteNotaCreditoSoli;
	}

	public void setCargarid_transporteNotaCreditoSoli(Boolean cargarid_transporteNotaCreditoSoli) {
		this.cargarid_transporteNotaCreditoSoli= cargarid_transporteNotaCreditoSoli;
	}

	public Border setResaltarid_transportistaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_transportistaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transportistaNotaCreditoSoli() {
		return this.resaltarid_transportistaNotaCreditoSoli;
	}

	public void setResaltarid_transportistaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_transportistaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_transportistaNotaCreditoSoli() {
		return this.mostrarid_transportistaNotaCreditoSoli;
	}

	public void setMostrarid_transportistaNotaCreditoSoli(Boolean mostrarid_transportistaNotaCreditoSoli) {
		this.mostrarid_transportistaNotaCreditoSoli= mostrarid_transportistaNotaCreditoSoli;
	}

	public Boolean getActivarid_transportistaNotaCreditoSoli() {
		return this.activarid_transportistaNotaCreditoSoli;
	}

	public void setActivarid_transportistaNotaCreditoSoli(Boolean activarid_transportistaNotaCreditoSoli) {
		this.activarid_transportistaNotaCreditoSoli= activarid_transportistaNotaCreditoSoli;
	}

	public Boolean getCargarid_transportistaNotaCreditoSoli() {
		return this.cargarid_transportistaNotaCreditoSoli;
	}

	public void setCargarid_transportistaNotaCreditoSoli(Boolean cargarid_transportistaNotaCreditoSoli) {
		this.cargarid_transportistaNotaCreditoSoli= cargarid_transportistaNotaCreditoSoli;
	}

	public Border setResaltarfecha_clienteNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarfecha_clienteNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_clienteNotaCreditoSoli() {
		return this.resaltarfecha_clienteNotaCreditoSoli;
	}

	public void setResaltarfecha_clienteNotaCreditoSoli(Border borderResaltar) {
		this.resaltarfecha_clienteNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarfecha_clienteNotaCreditoSoli() {
		return this.mostrarfecha_clienteNotaCreditoSoli;
	}

	public void setMostrarfecha_clienteNotaCreditoSoli(Boolean mostrarfecha_clienteNotaCreditoSoli) {
		this.mostrarfecha_clienteNotaCreditoSoli= mostrarfecha_clienteNotaCreditoSoli;
	}

	public Boolean getActivarfecha_clienteNotaCreditoSoli() {
		return this.activarfecha_clienteNotaCreditoSoli;
	}

	public void setActivarfecha_clienteNotaCreditoSoli(Boolean activarfecha_clienteNotaCreditoSoli) {
		this.activarfecha_clienteNotaCreditoSoli= activarfecha_clienteNotaCreditoSoli;
	}

	public Border setResaltarfecha_autorizacionNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarfecha_autorizacionNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_autorizacionNotaCreditoSoli() {
		return this.resaltarfecha_autorizacionNotaCreditoSoli;
	}

	public void setResaltarfecha_autorizacionNotaCreditoSoli(Border borderResaltar) {
		this.resaltarfecha_autorizacionNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarfecha_autorizacionNotaCreditoSoli() {
		return this.mostrarfecha_autorizacionNotaCreditoSoli;
	}

	public void setMostrarfecha_autorizacionNotaCreditoSoli(Boolean mostrarfecha_autorizacionNotaCreditoSoli) {
		this.mostrarfecha_autorizacionNotaCreditoSoli= mostrarfecha_autorizacionNotaCreditoSoli;
	}

	public Boolean getActivarfecha_autorizacionNotaCreditoSoli() {
		return this.activarfecha_autorizacionNotaCreditoSoli;
	}

	public void setActivarfecha_autorizacionNotaCreditoSoli(Boolean activarfecha_autorizacionNotaCreditoSoli) {
		this.activarfecha_autorizacionNotaCreditoSoli= activarfecha_autorizacionNotaCreditoSoli;
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
		
		
		this.setMostraridNotaCreditoSoli(esInicial);
		this.setMostrarid_empresaNotaCreditoSoli(esInicial);
		this.setMostrarid_sucursalNotaCreditoSoli(esInicial);
		this.setMostrarid_ejercicioNotaCreditoSoli(esInicial);
		this.setMostrarid_periodoNotaCreditoSoli(esInicial);
		this.setMostrarid_anioNotaCreditoSoli(esInicial);
		this.setMostrarid_mesNotaCreditoSoli(esInicial);
		this.setMostrarid_usuarioNotaCreditoSoli(esInicial);
		this.setMostrarcodigoNotaCreditoSoli(esInicial);
		this.setMostrarnumeroNotaCreditoSoli(esInicial);
		this.setMostrarfecha_emisionNotaCreditoSoli(esInicial);
		this.setMostrarnumero_diasNotaCreditoSoli(esInicial);
		this.setMostrarfecha_vencimientoNotaCreditoSoli(esInicial);
		this.setMostrarid_monedaNotaCreditoSoli(esInicial);
		this.setMostrarid_empleadoNotaCreditoSoli(esInicial);
		this.setMostrarcotizacionNotaCreditoSoli(esInicial);
		this.setMostrarid_formatoNotaCreditoSoli(esInicial);
		this.setMostrarid_tipo_precioNotaCreditoSoli(esInicial);
		this.setMostrarid_clienteNotaCreditoSoli(esInicial);
		this.setMostrarid_facturaNotaCreditoSoli(esInicial);
		this.setMostrardireccionNotaCreditoSoli(esInicial);
		this.setMostrartelefonoNotaCreditoSoli(esInicial);
		this.setMostrarrucNotaCreditoSoli(esInicial);
		this.setMostrarid_tipo_nota_credito_soliNotaCreditoSoli(esInicial);
		this.setMostrarid_responsableNotaCreditoSoli(esInicial);
		this.setMostrarid_estado_nota_creditoNotaCreditoSoli(esInicial);
		this.setMostrardescripcionNotaCreditoSoli(esInicial);
		this.setMostrarpenalizadoNotaCreditoSoli(esInicial);
		this.setMostrardescuento_porcentajeNotaCreditoSoli(esInicial);
		this.setMostrartotal_ivaNotaCreditoSoli(esInicial);
		this.setMostrarsumanNotaCreditoSoli(esInicial);
		this.setMostrardescuento_valorNotaCreditoSoli(esInicial);
		this.setMostrartotal_sin_ivaNotaCreditoSoli(esInicial);
		this.setMostrardescuento_generalNotaCreditoSoli(esInicial);
		this.setMostrarfleteNotaCreditoSoli(esInicial);
		this.setMostrartotalNotaCreditoSoli(esInicial);
		this.setMostrarsub_totalNotaCreditoSoli(esInicial);
		this.setMostrarotroNotaCreditoSoli(esInicial);
		this.setMostrarivaNotaCreditoSoli(esInicial);
		this.setMostrarfinanciamientoNotaCreditoSoli(esInicial);
		this.setMostrarotro_valorNotaCreditoSoli(esInicial);
		this.setMostrarretencionNotaCreditoSoli(esInicial);
		this.setMostrariceNotaCreditoSoli(esInicial);
		this.setMostrarfechaNotaCreditoSoli(esInicial);
		this.setMostrarid_centro_costoNotaCreditoSoli(esInicial);
		this.setMostrarid_vendedorNotaCreditoSoli(esInicial);
		this.setMostrarid_tipo_cambioNotaCreditoSoli(esInicial);
		this.setMostrarid_transporteNotaCreditoSoli(esInicial);
		this.setMostrarid_transportistaNotaCreditoSoli(esInicial);
		this.setMostrarfecha_clienteNotaCreditoSoli(esInicial);
		this.setMostrarfecha_autorizacionNotaCreditoSoli(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.ID)) {
				this.setMostraridNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDMES)) {
				this.setMostrarid_mesNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setMostrarnumeroNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.NUMERODIAS)) {
				this.setMostrarnumero_diasNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.COTIZACION)) {
				this.setMostrarcotizacionNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDTIPOPRECIO)) {
				this.setMostrarid_tipo_precioNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.RUC)) {
				this.setMostrarrucNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDTIPONOTACREDITOSOLI)) {
				this.setMostrarid_tipo_nota_credito_soliNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDRESPONSABLE)) {
				this.setMostrarid_responsableNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDESTADONOTACREDITOSOLI)) {
				this.setMostrarid_estado_nota_creditoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.PENALIZADO)) {
				this.setMostrarpenalizadoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setMostrardescuento_porcentajeNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.TOTALIVA)) {
				this.setMostrartotal_ivaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.SUMAN)) {
				this.setMostrarsumanNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.DESCUENTOVALOR)) {
				this.setMostrardescuento_valorNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.TOTALSINIVA)) {
				this.setMostrartotal_sin_ivaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.DESCUENTOGENERAL)) {
				this.setMostrardescuento_generalNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.FLETE)) {
				this.setMostrarfleteNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.TOTAL)) {
				this.setMostrartotalNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsub_totalNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.OTRO)) {
				this.setMostrarotroNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IVA)) {
				this.setMostrarivaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.FINANCIAMIENTO)) {
				this.setMostrarfinanciamientoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.OTROVALOR)) {
				this.setMostrarotro_valorNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.RETENCION)) {
				this.setMostrarretencionNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.ICE)) {
				this.setMostrariceNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.FECHA)) {
				this.setMostrarfechaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDTIPOCAMBIO)) {
				this.setMostrarid_tipo_cambioNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDTRANSPORTE)) {
				this.setMostrarid_transporteNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDTRANSPORTISTA)) {
				this.setMostrarid_transportistaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.FECHACLIENTE)) {
				this.setMostrarfecha_clienteNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.FECHAAUTORIZACION)) {
				this.setMostrarfecha_autorizacionNotaCreditoSoli(esAsigna);
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
		
		
		this.setActivaridNotaCreditoSoli(esInicial);
		this.setActivarid_empresaNotaCreditoSoli(esInicial);
		this.setActivarid_sucursalNotaCreditoSoli(esInicial);
		this.setActivarid_ejercicioNotaCreditoSoli(esInicial);
		this.setActivarid_periodoNotaCreditoSoli(esInicial);
		this.setActivarid_anioNotaCreditoSoli(esInicial);
		this.setActivarid_mesNotaCreditoSoli(esInicial);
		this.setActivarid_usuarioNotaCreditoSoli(esInicial);
		this.setActivarcodigoNotaCreditoSoli(esInicial);
		this.setActivarnumeroNotaCreditoSoli(esInicial);
		this.setActivarfecha_emisionNotaCreditoSoli(esInicial);
		this.setActivarnumero_diasNotaCreditoSoli(esInicial);
		this.setActivarfecha_vencimientoNotaCreditoSoli(esInicial);
		this.setActivarid_monedaNotaCreditoSoli(esInicial);
		this.setActivarid_empleadoNotaCreditoSoli(esInicial);
		this.setActivarcotizacionNotaCreditoSoli(esInicial);
		this.setActivarid_formatoNotaCreditoSoli(esInicial);
		this.setActivarid_tipo_precioNotaCreditoSoli(esInicial);
		this.setActivarid_clienteNotaCreditoSoli(esInicial);
		this.setActivarid_facturaNotaCreditoSoli(esInicial);
		this.setActivardireccionNotaCreditoSoli(esInicial);
		this.setActivartelefonoNotaCreditoSoli(esInicial);
		this.setActivarrucNotaCreditoSoli(esInicial);
		this.setActivarid_tipo_nota_credito_soliNotaCreditoSoli(esInicial);
		this.setActivarid_responsableNotaCreditoSoli(esInicial);
		this.setActivarid_estado_nota_creditoNotaCreditoSoli(esInicial);
		this.setActivardescripcionNotaCreditoSoli(esInicial);
		this.setActivarpenalizadoNotaCreditoSoli(esInicial);
		this.setActivardescuento_porcentajeNotaCreditoSoli(esInicial);
		this.setActivartotal_ivaNotaCreditoSoli(esInicial);
		this.setActivarsumanNotaCreditoSoli(esInicial);
		this.setActivardescuento_valorNotaCreditoSoli(esInicial);
		this.setActivartotal_sin_ivaNotaCreditoSoli(esInicial);
		this.setActivardescuento_generalNotaCreditoSoli(esInicial);
		this.setActivarfleteNotaCreditoSoli(esInicial);
		this.setActivartotalNotaCreditoSoli(esInicial);
		this.setActivarsub_totalNotaCreditoSoli(esInicial);
		this.setActivarotroNotaCreditoSoli(esInicial);
		this.setActivarivaNotaCreditoSoli(esInicial);
		this.setActivarfinanciamientoNotaCreditoSoli(esInicial);
		this.setActivarotro_valorNotaCreditoSoli(esInicial);
		this.setActivarretencionNotaCreditoSoli(esInicial);
		this.setActivariceNotaCreditoSoli(esInicial);
		this.setActivarfechaNotaCreditoSoli(esInicial);
		this.setActivarid_centro_costoNotaCreditoSoli(esInicial);
		this.setActivarid_vendedorNotaCreditoSoli(esInicial);
		this.setActivarid_tipo_cambioNotaCreditoSoli(esInicial);
		this.setActivarid_transporteNotaCreditoSoli(esInicial);
		this.setActivarid_transportistaNotaCreditoSoli(esInicial);
		this.setActivarfecha_clienteNotaCreditoSoli(esInicial);
		this.setActivarfecha_autorizacionNotaCreditoSoli(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.ID)) {
				this.setActivaridNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDANIO)) {
				this.setActivarid_anioNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDMES)) {
				this.setActivarid_mesNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.CODIGO)) {
				this.setActivarcodigoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setActivarnumeroNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.NUMERODIAS)) {
				this.setActivarnumero_diasNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.COTIZACION)) {
				this.setActivarcotizacionNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDTIPOPRECIO)) {
				this.setActivarid_tipo_precioNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.DIRECCION)) {
				this.setActivardireccionNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.RUC)) {
				this.setActivarrucNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDTIPONOTACREDITOSOLI)) {
				this.setActivarid_tipo_nota_credito_soliNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDRESPONSABLE)) {
				this.setActivarid_responsableNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDESTADONOTACREDITOSOLI)) {
				this.setActivarid_estado_nota_creditoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.PENALIZADO)) {
				this.setActivarpenalizadoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setActivardescuento_porcentajeNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.TOTALIVA)) {
				this.setActivartotal_ivaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.SUMAN)) {
				this.setActivarsumanNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.DESCUENTOVALOR)) {
				this.setActivardescuento_valorNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.TOTALSINIVA)) {
				this.setActivartotal_sin_ivaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.DESCUENTOGENERAL)) {
				this.setActivardescuento_generalNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.FLETE)) {
				this.setActivarfleteNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.TOTAL)) {
				this.setActivartotalNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.SUBTOTAL)) {
				this.setActivarsub_totalNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.OTRO)) {
				this.setActivarotroNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IVA)) {
				this.setActivarivaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.FINANCIAMIENTO)) {
				this.setActivarfinanciamientoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.OTROVALOR)) {
				this.setActivarotro_valorNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.RETENCION)) {
				this.setActivarretencionNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.ICE)) {
				this.setActivariceNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.FECHA)) {
				this.setActivarfechaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDTIPOCAMBIO)) {
				this.setActivarid_tipo_cambioNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDTRANSPORTE)) {
				this.setActivarid_transporteNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDTRANSPORTISTA)) {
				this.setActivarid_transportistaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.FECHACLIENTE)) {
				this.setActivarfecha_clienteNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.FECHAAUTORIZACION)) {
				this.setActivarfecha_autorizacionNotaCreditoSoli(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridNotaCreditoSoli(esInicial);
		this.setResaltarid_empresaNotaCreditoSoli(esInicial);
		this.setResaltarid_sucursalNotaCreditoSoli(esInicial);
		this.setResaltarid_ejercicioNotaCreditoSoli(esInicial);
		this.setResaltarid_periodoNotaCreditoSoli(esInicial);
		this.setResaltarid_anioNotaCreditoSoli(esInicial);
		this.setResaltarid_mesNotaCreditoSoli(esInicial);
		this.setResaltarid_usuarioNotaCreditoSoli(esInicial);
		this.setResaltarcodigoNotaCreditoSoli(esInicial);
		this.setResaltarnumeroNotaCreditoSoli(esInicial);
		this.setResaltarfecha_emisionNotaCreditoSoli(esInicial);
		this.setResaltarnumero_diasNotaCreditoSoli(esInicial);
		this.setResaltarfecha_vencimientoNotaCreditoSoli(esInicial);
		this.setResaltarid_monedaNotaCreditoSoli(esInicial);
		this.setResaltarid_empleadoNotaCreditoSoli(esInicial);
		this.setResaltarcotizacionNotaCreditoSoli(esInicial);
		this.setResaltarid_formatoNotaCreditoSoli(esInicial);
		this.setResaltarid_tipo_precioNotaCreditoSoli(esInicial);
		this.setResaltarid_clienteNotaCreditoSoli(esInicial);
		this.setResaltarid_facturaNotaCreditoSoli(esInicial);
		this.setResaltardireccionNotaCreditoSoli(esInicial);
		this.setResaltartelefonoNotaCreditoSoli(esInicial);
		this.setResaltarrucNotaCreditoSoli(esInicial);
		this.setResaltarid_tipo_nota_credito_soliNotaCreditoSoli(esInicial);
		this.setResaltarid_responsableNotaCreditoSoli(esInicial);
		this.setResaltarid_estado_nota_creditoNotaCreditoSoli(esInicial);
		this.setResaltardescripcionNotaCreditoSoli(esInicial);
		this.setResaltarpenalizadoNotaCreditoSoli(esInicial);
		this.setResaltardescuento_porcentajeNotaCreditoSoli(esInicial);
		this.setResaltartotal_ivaNotaCreditoSoli(esInicial);
		this.setResaltarsumanNotaCreditoSoli(esInicial);
		this.setResaltardescuento_valorNotaCreditoSoli(esInicial);
		this.setResaltartotal_sin_ivaNotaCreditoSoli(esInicial);
		this.setResaltardescuento_generalNotaCreditoSoli(esInicial);
		this.setResaltarfleteNotaCreditoSoli(esInicial);
		this.setResaltartotalNotaCreditoSoli(esInicial);
		this.setResaltarsub_totalNotaCreditoSoli(esInicial);
		this.setResaltarotroNotaCreditoSoli(esInicial);
		this.setResaltarivaNotaCreditoSoli(esInicial);
		this.setResaltarfinanciamientoNotaCreditoSoli(esInicial);
		this.setResaltarotro_valorNotaCreditoSoli(esInicial);
		this.setResaltarretencionNotaCreditoSoli(esInicial);
		this.setResaltariceNotaCreditoSoli(esInicial);
		this.setResaltarfechaNotaCreditoSoli(esInicial);
		this.setResaltarid_centro_costoNotaCreditoSoli(esInicial);
		this.setResaltarid_vendedorNotaCreditoSoli(esInicial);
		this.setResaltarid_tipo_cambioNotaCreditoSoli(esInicial);
		this.setResaltarid_transporteNotaCreditoSoli(esInicial);
		this.setResaltarid_transportistaNotaCreditoSoli(esInicial);
		this.setResaltarfecha_clienteNotaCreditoSoli(esInicial);
		this.setResaltarfecha_autorizacionNotaCreditoSoli(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.ID)) {
				this.setResaltaridNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDMES)) {
				this.setResaltarid_mesNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setResaltarnumeroNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.NUMERODIAS)) {
				this.setResaltarnumero_diasNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.COTIZACION)) {
				this.setResaltarcotizacionNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDTIPOPRECIO)) {
				this.setResaltarid_tipo_precioNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.RUC)) {
				this.setResaltarrucNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDTIPONOTACREDITOSOLI)) {
				this.setResaltarid_tipo_nota_credito_soliNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDRESPONSABLE)) {
				this.setResaltarid_responsableNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDESTADONOTACREDITOSOLI)) {
				this.setResaltarid_estado_nota_creditoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.PENALIZADO)) {
				this.setResaltarpenalizadoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setResaltardescuento_porcentajeNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.TOTALIVA)) {
				this.setResaltartotal_ivaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.SUMAN)) {
				this.setResaltarsumanNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.DESCUENTOVALOR)) {
				this.setResaltardescuento_valorNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.TOTALSINIVA)) {
				this.setResaltartotal_sin_ivaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.DESCUENTOGENERAL)) {
				this.setResaltardescuento_generalNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.FLETE)) {
				this.setResaltarfleteNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.TOTAL)) {
				this.setResaltartotalNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsub_totalNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.OTRO)) {
				this.setResaltarotroNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IVA)) {
				this.setResaltarivaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.FINANCIAMIENTO)) {
				this.setResaltarfinanciamientoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.OTROVALOR)) {
				this.setResaltarotro_valorNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.RETENCION)) {
				this.setResaltarretencionNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.ICE)) {
				this.setResaltariceNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.FECHA)) {
				this.setResaltarfechaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDTIPOCAMBIO)) {
				this.setResaltarid_tipo_cambioNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDTRANSPORTE)) {
				this.setResaltarid_transporteNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.IDTRANSPORTISTA)) {
				this.setResaltarid_transportistaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.FECHACLIENTE)) {
				this.setResaltarfecha_clienteNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoSoliConstantesFunciones.FECHAAUTORIZACION)) {
				this.setResaltarfecha_autorizacionNotaCreditoSoli(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetaNotaCreditoSoliNotaCreditoSoli=null;

	public Border getResaltarDetaNotaCreditoSoliNotaCreditoSoli() {
		return this.resaltarDetaNotaCreditoSoliNotaCreditoSoli;
	}

	public void setResaltarDetaNotaCreditoSoliNotaCreditoSoli(Border borderResaltarDetaNotaCreditoSoli) {
		if(borderResaltarDetaNotaCreditoSoli!=null) {
			this.resaltarDetaNotaCreditoSoliNotaCreditoSoli= borderResaltarDetaNotaCreditoSoli;
		}
	}

	public Border setResaltarDetaNotaCreditoSoliNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltarDetaNotaCreditoSoli=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//notacreditosoliBeanSwingJInternalFrame.jTtoolBarNotaCreditoSoli.setBorder(borderResaltarDetaNotaCreditoSoli);
			
		this.resaltarDetaNotaCreditoSoliNotaCreditoSoli= borderResaltarDetaNotaCreditoSoli;

		 return borderResaltarDetaNotaCreditoSoli;
	}



	public Boolean mostrarDetaNotaCreditoSoliNotaCreditoSoli=true;

	public Boolean getMostrarDetaNotaCreditoSoliNotaCreditoSoli() {
		return this.mostrarDetaNotaCreditoSoliNotaCreditoSoli;
	}

	public void setMostrarDetaNotaCreditoSoliNotaCreditoSoli(Boolean visibilidadResaltarDetaNotaCreditoSoli) {
		this.mostrarDetaNotaCreditoSoliNotaCreditoSoli= visibilidadResaltarDetaNotaCreditoSoli;
	}



	public Boolean activarDetaNotaCreditoSoliNotaCreditoSoli=true;

	public Boolean gethabilitarResaltarDetaNotaCreditoSoliNotaCreditoSoli() {
		return this.activarDetaNotaCreditoSoliNotaCreditoSoli;
	}

	public void setActivarDetaNotaCreditoSoliNotaCreditoSoli(Boolean habilitarResaltarDetaNotaCreditoSoli) {
		this.activarDetaNotaCreditoSoliNotaCreditoSoli= habilitarResaltarDetaNotaCreditoSoli;
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

		this.setMostrarDetaNotaCreditoSoliNotaCreditoSoli(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetaNotaCreditoSoli.class)) {
				this.setMostrarDetaNotaCreditoSoliNotaCreditoSoli(esAsigna);
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

		this.setActivarDetaNotaCreditoSoliNotaCreditoSoli(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetaNotaCreditoSoli.class)) {
				this.setActivarDetaNotaCreditoSoliNotaCreditoSoli(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetaNotaCreditoSoliNotaCreditoSoli(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetaNotaCreditoSoli.class)) {
				this.setResaltarDetaNotaCreditoSoliNotaCreditoSoli(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdClienteNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdClienteNotaCreditoSoli() {
		return this.mostrarFK_IdClienteNotaCreditoSoli;
	}

	public void setMostrarFK_IdClienteNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteNotaCreditoSoli= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdEjercicioNotaCreditoSoli() {
		return this.mostrarFK_IdEjercicioNotaCreditoSoli;
	}

	public void setMostrarFK_IdEjercicioNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioNotaCreditoSoli= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdEmpleadoNotaCreditoSoli() {
		return this.mostrarFK_IdEmpleadoNotaCreditoSoli;
	}

	public void setMostrarFK_IdEmpleadoNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoNotaCreditoSoli= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdEmpresaNotaCreditoSoli() {
		return this.mostrarFK_IdEmpresaNotaCreditoSoli;
	}

	public void setMostrarFK_IdEmpresaNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaNotaCreditoSoli= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoNotaCreditoSoliNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdEstadoNotaCreditoSoliNotaCreditoSoli() {
		return this.mostrarFK_IdEstadoNotaCreditoSoliNotaCreditoSoli;
	}

	public void setMostrarFK_IdEstadoNotaCreditoSoliNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoNotaCreditoSoliNotaCreditoSoli= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdFacturaNotaCreditoSoli() {
		return this.mostrarFK_IdFacturaNotaCreditoSoli;
	}

	public void setMostrarFK_IdFacturaNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaNotaCreditoSoli= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdPeriodoNotaCreditoSoli() {
		return this.mostrarFK_IdPeriodoNotaCreditoSoli;
	}

	public void setMostrarFK_IdPeriodoNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoNotaCreditoSoli= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdResponsableNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdResponsableNotaCreditoSoli() {
		return this.mostrarFK_IdResponsableNotaCreditoSoli;
	}

	public void setMostrarFK_IdResponsableNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdResponsableNotaCreditoSoli= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdSucursalNotaCreditoSoli() {
		return this.mostrarFK_IdSucursalNotaCreditoSoli;
	}

	public void setMostrarFK_IdSucursalNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalNotaCreditoSoli= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoNotaCreditoSoliNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdTipoNotaCreditoSoliNotaCreditoSoli() {
		return this.mostrarFK_IdTipoNotaCreditoSoliNotaCreditoSoli;
	}

	public void setMostrarFK_IdTipoNotaCreditoSoliNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoNotaCreditoSoliNotaCreditoSoli= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransportistaNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdTransportistaNotaCreditoSoli() {
		return this.mostrarFK_IdTransportistaNotaCreditoSoli;
	}

	public void setMostrarFK_IdTransportistaNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransportistaNotaCreditoSoli= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdUsuarioNotaCreditoSoli() {
		return this.mostrarFK_IdUsuarioNotaCreditoSoli;
	}

	public void setMostrarFK_IdUsuarioNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioNotaCreditoSoli= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdVendedorNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdVendedorNotaCreditoSoli() {
		return this.mostrarFK_IdVendedorNotaCreditoSoli;
	}

	public void setMostrarFK_IdVendedorNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdVendedorNotaCreditoSoli= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteNotaCreditoSoli=true;

	public Boolean getActivarFK_IdClienteNotaCreditoSoli() {
		return this.activarFK_IdClienteNotaCreditoSoli;
	}

	public void setActivarFK_IdClienteNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdClienteNotaCreditoSoli= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioNotaCreditoSoli=true;

	public Boolean getActivarFK_IdEjercicioNotaCreditoSoli() {
		return this.activarFK_IdEjercicioNotaCreditoSoli;
	}

	public void setActivarFK_IdEjercicioNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioNotaCreditoSoli= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoNotaCreditoSoli=true;

	public Boolean getActivarFK_IdEmpleadoNotaCreditoSoli() {
		return this.activarFK_IdEmpleadoNotaCreditoSoli;
	}

	public void setActivarFK_IdEmpleadoNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoNotaCreditoSoli= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaNotaCreditoSoli=true;

	public Boolean getActivarFK_IdEmpresaNotaCreditoSoli() {
		return this.activarFK_IdEmpresaNotaCreditoSoli;
	}

	public void setActivarFK_IdEmpresaNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaNotaCreditoSoli= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoNotaCreditoSoliNotaCreditoSoli=true;

	public Boolean getActivarFK_IdEstadoNotaCreditoSoliNotaCreditoSoli() {
		return this.activarFK_IdEstadoNotaCreditoSoliNotaCreditoSoli;
	}

	public void setActivarFK_IdEstadoNotaCreditoSoliNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoNotaCreditoSoliNotaCreditoSoli= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaNotaCreditoSoli=true;

	public Boolean getActivarFK_IdFacturaNotaCreditoSoli() {
		return this.activarFK_IdFacturaNotaCreditoSoli;
	}

	public void setActivarFK_IdFacturaNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaNotaCreditoSoli= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoNotaCreditoSoli=true;

	public Boolean getActivarFK_IdPeriodoNotaCreditoSoli() {
		return this.activarFK_IdPeriodoNotaCreditoSoli;
	}

	public void setActivarFK_IdPeriodoNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoNotaCreditoSoli= habilitarResaltar;
	}

	public Boolean activarFK_IdResponsableNotaCreditoSoli=true;

	public Boolean getActivarFK_IdResponsableNotaCreditoSoli() {
		return this.activarFK_IdResponsableNotaCreditoSoli;
	}

	public void setActivarFK_IdResponsableNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdResponsableNotaCreditoSoli= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalNotaCreditoSoli=true;

	public Boolean getActivarFK_IdSucursalNotaCreditoSoli() {
		return this.activarFK_IdSucursalNotaCreditoSoli;
	}

	public void setActivarFK_IdSucursalNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalNotaCreditoSoli= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoNotaCreditoSoliNotaCreditoSoli=true;

	public Boolean getActivarFK_IdTipoNotaCreditoSoliNotaCreditoSoli() {
		return this.activarFK_IdTipoNotaCreditoSoliNotaCreditoSoli;
	}

	public void setActivarFK_IdTipoNotaCreditoSoliNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdTipoNotaCreditoSoliNotaCreditoSoli= habilitarResaltar;
	}

	public Boolean activarFK_IdTransportistaNotaCreditoSoli=true;

	public Boolean getActivarFK_IdTransportistaNotaCreditoSoli() {
		return this.activarFK_IdTransportistaNotaCreditoSoli;
	}

	public void setActivarFK_IdTransportistaNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdTransportistaNotaCreditoSoli= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioNotaCreditoSoli=true;

	public Boolean getActivarFK_IdUsuarioNotaCreditoSoli() {
		return this.activarFK_IdUsuarioNotaCreditoSoli;
	}

	public void setActivarFK_IdUsuarioNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioNotaCreditoSoli= habilitarResaltar;
	}

	public Boolean activarFK_IdVendedorNotaCreditoSoli=true;

	public Boolean getActivarFK_IdVendedorNotaCreditoSoli() {
		return this.activarFK_IdVendedorNotaCreditoSoli;
	}

	public void setActivarFK_IdVendedorNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdVendedorNotaCreditoSoli= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteNotaCreditoSoli=null;

	public Border getResaltarFK_IdClienteNotaCreditoSoli() {
		return this.resaltarFK_IdClienteNotaCreditoSoli;
	}

	public void setResaltarFK_IdClienteNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdClienteNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdClienteNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteNotaCreditoSoli= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioNotaCreditoSoli=null;

	public Border getResaltarFK_IdEjercicioNotaCreditoSoli() {
		return this.resaltarFK_IdEjercicioNotaCreditoSoli;
	}

	public void setResaltarFK_IdEjercicioNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdEjercicioNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioNotaCreditoSoli= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoNotaCreditoSoli=null;

	public Border getResaltarFK_IdEmpleadoNotaCreditoSoli() {
		return this.resaltarFK_IdEmpleadoNotaCreditoSoli;
	}

	public void setResaltarFK_IdEmpleadoNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoNotaCreditoSoli= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaNotaCreditoSoli=null;

	public Border getResaltarFK_IdEmpresaNotaCreditoSoli() {
		return this.resaltarFK_IdEmpresaNotaCreditoSoli;
	}

	public void setResaltarFK_IdEmpresaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdEmpresaNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaNotaCreditoSoli= borderResaltar;
	}

	public Border resaltarFK_IdEstadoNotaCreditoSoliNotaCreditoSoli=null;

	public Border getResaltarFK_IdEstadoNotaCreditoSoliNotaCreditoSoli() {
		return this.resaltarFK_IdEstadoNotaCreditoSoliNotaCreditoSoli;
	}

	public void setResaltarFK_IdEstadoNotaCreditoSoliNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdEstadoNotaCreditoSoliNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdEstadoNotaCreditoSoliNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoNotaCreditoSoliNotaCreditoSoli= borderResaltar;
	}

	public Border resaltarFK_IdFacturaNotaCreditoSoli=null;

	public Border getResaltarFK_IdFacturaNotaCreditoSoli() {
		return this.resaltarFK_IdFacturaNotaCreditoSoli;
	}

	public void setResaltarFK_IdFacturaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdFacturaNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdFacturaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaNotaCreditoSoli= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoNotaCreditoSoli=null;

	public Border getResaltarFK_IdPeriodoNotaCreditoSoli() {
		return this.resaltarFK_IdPeriodoNotaCreditoSoli;
	}

	public void setResaltarFK_IdPeriodoNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdPeriodoNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoNotaCreditoSoli= borderResaltar;
	}

	public Border resaltarFK_IdResponsableNotaCreditoSoli=null;

	public Border getResaltarFK_IdResponsableNotaCreditoSoli() {
		return this.resaltarFK_IdResponsableNotaCreditoSoli;
	}

	public void setResaltarFK_IdResponsableNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdResponsableNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdResponsableNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdResponsableNotaCreditoSoli= borderResaltar;
	}

	public Border resaltarFK_IdSucursalNotaCreditoSoli=null;

	public Border getResaltarFK_IdSucursalNotaCreditoSoli() {
		return this.resaltarFK_IdSucursalNotaCreditoSoli;
	}

	public void setResaltarFK_IdSucursalNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdSucursalNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdSucursalNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalNotaCreditoSoli= borderResaltar;
	}

	public Border resaltarFK_IdTipoNotaCreditoSoliNotaCreditoSoli=null;

	public Border getResaltarFK_IdTipoNotaCreditoSoliNotaCreditoSoli() {
		return this.resaltarFK_IdTipoNotaCreditoSoliNotaCreditoSoli;
	}

	public void setResaltarFK_IdTipoNotaCreditoSoliNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdTipoNotaCreditoSoliNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdTipoNotaCreditoSoliNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoNotaCreditoSoliNotaCreditoSoli= borderResaltar;
	}

	public Border resaltarFK_IdTransportistaNotaCreditoSoli=null;

	public Border getResaltarFK_IdTransportistaNotaCreditoSoli() {
		return this.resaltarFK_IdTransportistaNotaCreditoSoli;
	}

	public void setResaltarFK_IdTransportistaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdTransportistaNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdTransportistaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransportistaNotaCreditoSoli= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioNotaCreditoSoli=null;

	public Border getResaltarFK_IdUsuarioNotaCreditoSoli() {
		return this.resaltarFK_IdUsuarioNotaCreditoSoli;
	}

	public void setResaltarFK_IdUsuarioNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdUsuarioNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioNotaCreditoSoli= borderResaltar;
	}

	public Border resaltarFK_IdVendedorNotaCreditoSoli=null;

	public Border getResaltarFK_IdVendedorNotaCreditoSoli() {
		return this.resaltarFK_IdVendedorNotaCreditoSoli;
	}

	public void setResaltarFK_IdVendedorNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdVendedorNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdVendedorNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoSoliBeanSwingJInternalFrame notacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdVendedorNotaCreditoSoli= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}