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


import com.bydan.erp.facturacion.util.ProformaConstantesFunciones;
import com.bydan.erp.facturacion.util.ProformaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ProformaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProformaConstantesFunciones extends ProformaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Proforma";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Proforma"+ProformaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProformaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProformaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProformaConstantesFunciones.SCHEMA+"_"+ProformaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProformaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProformaConstantesFunciones.SCHEMA+"_"+ProformaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProformaConstantesFunciones.SCHEMA+"_"+ProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProformaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProformaConstantesFunciones.SCHEMA+"_"+ProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProformaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProformaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProformaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProformaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProformaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProformaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProformaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProformaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proformas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Proforma";
	public static final String SCLASSWEBTITULO_LOWER="Proforma";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Proforma";
	public static final String OBJECTNAME="proforma";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="proforma";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select proforma from "+ProformaConstantesFunciones.SPERSISTENCENAME+" proforma";
	public static String QUERYSELECTNATIVE="select "+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".version_row,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_empresa,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_sucursal,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_usuario,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_ejercicio,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_periodo,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_anio,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_mes,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".numero_pre_impreso,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".fecha_emision,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".dias,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".fecha_vencimiento,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_moneda,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".cotizacion,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_empleado,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_formato,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_estado_proforma,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".direccion,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_cliente,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".ruc,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".es_oferta,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".telefono,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_tipo_precio,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_vendedor,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_sub_cliente,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_tipo_via_transporte,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_transporte,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_ruta_transporte,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".descripcion,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".descuento_porcentaje,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".monto_con_iva,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".suman,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".descuento_valor,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".monto_sin_iva,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".descuento_general,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".flete,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".ultimo_costo,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".subtotal,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".otros_cargos,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".margen_utilidad,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".iva,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".financiamiento,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".total,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".otros_valores,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".anticipo,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".ice,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".monto_retencion,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".fecha,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".fecha_servidor,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".hora_inicio,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".hora_fin,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_centro_costo,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_tipo_proforma,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_consignatario,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_tipo_cambio from "+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME;//+" as "+ProformaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected ProformaConstantesFuncionesAdditional proformaConstantesFuncionesAdditional=null;
	
	public ProformaConstantesFuncionesAdditional getProformaConstantesFuncionesAdditional() {
		return this.proformaConstantesFuncionesAdditional;
	}
	
	public void setProformaConstantesFuncionesAdditional(ProformaConstantesFuncionesAdditional proformaConstantesFuncionesAdditional) {
		try {
			this.proformaConstantesFuncionesAdditional=proformaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String NUMEROPREIMPRESO= "numero_pre_impreso";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String DIAS= "dias";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String IDMONEDA= "id_moneda";
    public static final String COTIZACION= "cotizacion";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDFORMATO= "id_formato";
    public static final String IDESTADOPROFORMA= "id_estado_proforma";
    public static final String DIRECCION= "direccion";
    public static final String IDCLIENTE= "id_cliente";
    public static final String RUC= "ruc";
    public static final String ESOFERTA= "es_oferta";
    public static final String TELEFONO= "telefono";
    public static final String IDTIPOPRECIO= "id_tipo_precio";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String IDSUBCLIENTE= "id_sub_cliente";
    public static final String IDTIPOVIATRANSPORTE= "id_tipo_via_transporte";
    public static final String IDTRANSPORTE= "id_transporte";
    public static final String IDRUTATRANSPORTE= "id_ruta_transporte";
    public static final String DESCRIPCION= "descripcion";
    public static final String DESCUENTOPORCENTAJE= "descuento_porcentaje";
    public static final String MONTOCONIVA= "monto_con_iva";
    public static final String SUMAN= "suman";
    public static final String DESCUENTOVALOR= "descuento_valor";
    public static final String MONTOSINIVA= "monto_sin_iva";
    public static final String DESCUENTOGENERAL= "descuento_general";
    public static final String FLETE= "flete";
    public static final String ULTIMOCOSTO= "ultimo_costo";
    public static final String SUBTOTAL= "subtotal";
    public static final String OTROSCARGOS= "otros_cargos";
    public static final String MARGENUTILIDAD= "margen_utilidad";
    public static final String IVA= "iva";
    public static final String FINANCIAMIENTO= "financiamiento";
    public static final String TOTAL= "total";
    public static final String OTROSVALORES= "otros_valores";
    public static final String ANTICIPO= "anticipo";
    public static final String ICE= "ice";
    public static final String MONTORETENCION= "monto_retencion";
    public static final String FECHA= "fecha";
    public static final String FECHASERVIDOR= "fecha_servidor";
    public static final String HORAINICIO= "hora_inicio";
    public static final String HORAFIN= "hora_fin";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDTIPOPROFORMA= "id_tipo_proforma";
    public static final String IDCONSIGNATARIO= "id_consignatario";
    public static final String IDTIPOCAMBIO= "id_tipo_cambio";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_NUMEROPREIMPRESO= "Nro PreImpreso";
		public static final String LABEL_NUMEROPREIMPRESO_LOWER= "Numero Pre Impreso";
    	public static final String LABEL_FECHAEMISION= "F Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_DIAS= "Nro Dias";
		public static final String LABEL_DIAS_LOWER= "Dias";
    	public static final String LABEL_FECHAVENCIMIENTO= "F Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_COTIZACION= "Cotizacion";
		public static final String LABEL_COTIZACION_LOWER= "Cotizacion";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_IDESTADOPROFORMA= "Estado";
		public static final String LABEL_IDESTADOPROFORMA_LOWER= "Estado Proforma";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_ESOFERTA= "Es Oferta";
		public static final String LABEL_ESOFERTA_LOWER= "Es Oferta";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_IDTIPOPRECIO= "Tipo Precio";
		public static final String LABEL_IDTIPOPRECIO_LOWER= "Tipo Precio";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_IDSUBCLIENTE= "Contacto";
		public static final String LABEL_IDSUBCLIENTE_LOWER= "Sub Cliente";
    	public static final String LABEL_IDTIPOVIATRANSPORTE= "Forma Envio";
		public static final String LABEL_IDTIPOVIATRANSPORTE_LOWER= "Tipo Via Transporte";
    	public static final String LABEL_IDTRANSPORTE= "Transporte";
		public static final String LABEL_IDTRANSPORTE_LOWER= "Transporte";
    	public static final String LABEL_IDRUTATRANSPORTE= "Ruta";
		public static final String LABEL_IDRUTATRANSPORTE_LOWER= "Ruta Transporte";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_DESCUENTOPORCENTAJE= "Dscto %";
		public static final String LABEL_DESCUENTOPORCENTAJE_LOWER= "Descuento Porcentaje";
    	public static final String LABEL_MONTOCONIVA= "Monto Con Iva";
		public static final String LABEL_MONTOCONIVA_LOWER= "Monto Con Iva";
    	public static final String LABEL_SUMAN= "Suman";
		public static final String LABEL_SUMAN_LOWER= "Suman";
    	public static final String LABEL_DESCUENTOVALOR= "Dscto Valor";
		public static final String LABEL_DESCUENTOVALOR_LOWER= "Descuento Valor";
    	public static final String LABEL_MONTOSINIVA= "Monto Sin Iva";
		public static final String LABEL_MONTOSINIVA_LOWER= "Monto Sin Iva";
    	public static final String LABEL_DESCUENTOGENERAL= "Dscto General";
		public static final String LABEL_DESCUENTOGENERAL_LOWER= "Descuento General";
    	public static final String LABEL_FLETE= "Flete";
		public static final String LABEL_FLETE_LOWER= "Flete";
    	public static final String LABEL_ULTIMOCOSTO= "Ultimo Costo";
		public static final String LABEL_ULTIMOCOSTO_LOWER= "Ultimo Costo";
    	public static final String LABEL_SUBTOTAL= "Subtotal";
		public static final String LABEL_SUBTOTAL_LOWER= "Subtotal";
    	public static final String LABEL_OTROSCARGOS= "Otros Cargos";
		public static final String LABEL_OTROSCARGOS_LOWER= "Otros Cargos";
    	public static final String LABEL_MARGENUTILIDAD= "Margen Utilidad";
		public static final String LABEL_MARGENUTILIDAD_LOWER= "Margen Utilidad";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_FINANCIAMIENTO= "Financiamiento";
		public static final String LABEL_FINANCIAMIENTO_LOWER= "Financiamiento";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_OTROSVALORES= "Otros Valores";
		public static final String LABEL_OTROSVALORES_LOWER= "Otros Valores";
    	public static final String LABEL_ANTICIPO= "Anticipo";
		public static final String LABEL_ANTICIPO_LOWER= "Anticipo";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_MONTORETENCION= "Monto Retencion";
		public static final String LABEL_MONTORETENCION_LOWER= "Monto Retencion";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_FECHASERVIDOR= "Fecha Servidor";
		public static final String LABEL_FECHASERVIDOR_LOWER= "Fecha Servidor";
    	public static final String LABEL_HORAINICIO= "Hora Inicio";
		public static final String LABEL_HORAINICIO_LOWER= "Hora Inicio";
    	public static final String LABEL_HORAFIN= "Hora Fin";
		public static final String LABEL_HORAFIN_LOWER= "Hora Fin";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDTIPOPROFORMA= "Tipo Proforma";
		public static final String LABEL_IDTIPOPROFORMA_LOWER= "Tipo Proforma";
    	public static final String LABEL_IDCONSIGNATARIO= "Consignatario";
		public static final String LABEL_IDCONSIGNATARIO_LOWER= "Consignatario";
    	public static final String LABEL_IDTIPOCAMBIO= "T. Cambio";
		public static final String LABEL_IDTIPOCAMBIO_LOWER= "Tipo Cambio";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getProformaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProformaConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.IDUSUARIO)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.IDEJERCICIO)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.IDPERIODO)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.IDANIO)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.IDMES)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.NUMEROPREIMPRESO)) {sLabelColumna=ProformaConstantesFunciones.LABEL_NUMEROPREIMPRESO;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.FECHAEMISION)) {sLabelColumna=ProformaConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.DIAS)) {sLabelColumna=ProformaConstantesFunciones.LABEL_DIAS;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=ProformaConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.IDMONEDA)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.COTIZACION)) {sLabelColumna=ProformaConstantesFunciones.LABEL_COTIZACION;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.IDEMPLEADO)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.IDFORMATO)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.IDESTADOPROFORMA)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IDESTADOPROFORMA;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.DIRECCION)) {sLabelColumna=ProformaConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.IDCLIENTE)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.RUC)) {sLabelColumna=ProformaConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.ESOFERTA)) {sLabelColumna=ProformaConstantesFunciones.LABEL_ESOFERTA;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.TELEFONO)) {sLabelColumna=ProformaConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.IDTIPOPRECIO)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IDTIPOPRECIO;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.IDVENDEDOR)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.IDSUBCLIENTE)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IDSUBCLIENTE;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.IDTIPOVIATRANSPORTE)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.IDTRANSPORTE)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IDTRANSPORTE;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.IDRUTATRANSPORTE)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IDRUTATRANSPORTE;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.DESCRIPCION)) {sLabelColumna=ProformaConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.DESCUENTOPORCENTAJE)) {sLabelColumna=ProformaConstantesFunciones.LABEL_DESCUENTOPORCENTAJE;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.MONTOCONIVA)) {sLabelColumna=ProformaConstantesFunciones.LABEL_MONTOCONIVA;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.SUMAN)) {sLabelColumna=ProformaConstantesFunciones.LABEL_SUMAN;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.DESCUENTOVALOR)) {sLabelColumna=ProformaConstantesFunciones.LABEL_DESCUENTOVALOR;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.MONTOSINIVA)) {sLabelColumna=ProformaConstantesFunciones.LABEL_MONTOSINIVA;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.DESCUENTOGENERAL)) {sLabelColumna=ProformaConstantesFunciones.LABEL_DESCUENTOGENERAL;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.FLETE)) {sLabelColumna=ProformaConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.ULTIMOCOSTO)) {sLabelColumna=ProformaConstantesFunciones.LABEL_ULTIMOCOSTO;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.SUBTOTAL)) {sLabelColumna=ProformaConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.OTROSCARGOS)) {sLabelColumna=ProformaConstantesFunciones.LABEL_OTROSCARGOS;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.MARGENUTILIDAD)) {sLabelColumna=ProformaConstantesFunciones.LABEL_MARGENUTILIDAD;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.IVA)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.FINANCIAMIENTO)) {sLabelColumna=ProformaConstantesFunciones.LABEL_FINANCIAMIENTO;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.TOTAL)) {sLabelColumna=ProformaConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.OTROSVALORES)) {sLabelColumna=ProformaConstantesFunciones.LABEL_OTROSVALORES;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.ANTICIPO)) {sLabelColumna=ProformaConstantesFunciones.LABEL_ANTICIPO;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.ICE)) {sLabelColumna=ProformaConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.MONTORETENCION)) {sLabelColumna=ProformaConstantesFunciones.LABEL_MONTORETENCION;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.FECHA)) {sLabelColumna=ProformaConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.FECHASERVIDOR)) {sLabelColumna=ProformaConstantesFunciones.LABEL_FECHASERVIDOR;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.HORAINICIO)) {sLabelColumna=ProformaConstantesFunciones.LABEL_HORAINICIO;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.HORAFIN)) {sLabelColumna=ProformaConstantesFunciones.LABEL_HORAFIN;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.IDTIPOPROFORMA)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IDTIPOPROFORMA;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.IDCONSIGNATARIO)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IDCONSIGNATARIO;}
		if(sNombreColumna.equals(ProformaConstantesFunciones.IDTIPOCAMBIO)) {sLabelColumna=ProformaConstantesFunciones.LABEL_IDTIPOCAMBIO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_ofertaDescripcion(Proforma proforma) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!proforma.getes_oferta()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_ofertaHtmlDescripcion(Proforma proforma) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(proforma.getId(),proforma.getes_oferta());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProformaDescripcion(Proforma proforma) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(proforma !=null/* && proforma.getId()!=0*/) {
			if(proforma.getId()!=null) {
				sDescripcion=proforma.getId().toString();
			}//proformaproforma.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProformaDescripcionDetallado(Proforma proforma) {
		String sDescripcion="";
			
		sDescripcion+=ProformaConstantesFunciones.ID+"=";
		sDescripcion+=proforma.getId().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=proforma.getVersionRow().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=proforma.getid_empresa().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=proforma.getid_sucursal().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=proforma.getid_usuario().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=proforma.getid_ejercicio().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=proforma.getid_periodo().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.IDANIO+"=";
		sDescripcion+=proforma.getid_anio().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.IDMES+"=";
		sDescripcion+=proforma.getid_mes().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.NUMEROPREIMPRESO+"=";
		sDescripcion+=proforma.getnumero_pre_impreso()+",";
		sDescripcion+=ProformaConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=proforma.getfecha_emision().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.DIAS+"=";
		sDescripcion+=proforma.getdias().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=proforma.getfecha_vencimiento().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=proforma.getid_moneda().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.COTIZACION+"=";
		sDescripcion+=proforma.getcotizacion().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=proforma.getid_empleado().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=proforma.getid_formato().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.IDESTADOPROFORMA+"=";
		sDescripcion+=proforma.getid_estado_proforma().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.DIRECCION+"=";
		sDescripcion+=proforma.getdireccion()+",";
		sDescripcion+=ProformaConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=proforma.getid_cliente().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.RUC+"=";
		sDescripcion+=proforma.getruc()+",";
		sDescripcion+=ProformaConstantesFunciones.ESOFERTA+"=";
		sDescripcion+=proforma.getes_oferta().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.TELEFONO+"=";
		sDescripcion+=proforma.gettelefono()+",";
		sDescripcion+=ProformaConstantesFunciones.IDTIPOPRECIO+"=";
		sDescripcion+=proforma.getid_tipo_precio().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=proforma.getid_vendedor().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.IDSUBCLIENTE+"=";
		sDescripcion+=proforma.getid_sub_cliente().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.IDTIPOVIATRANSPORTE+"=";
		sDescripcion+=proforma.getid_tipo_via_transporte().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.IDTRANSPORTE+"=";
		sDescripcion+=proforma.getid_transporte().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.IDRUTATRANSPORTE+"=";
		sDescripcion+=proforma.getid_ruta_transporte().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=proforma.getdescripcion()+",";
		sDescripcion+=ProformaConstantesFunciones.DESCUENTOPORCENTAJE+"=";
		sDescripcion+=proforma.getdescuento_porcentaje().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.MONTOCONIVA+"=";
		sDescripcion+=proforma.getmonto_con_iva().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.SUMAN+"=";
		sDescripcion+=proforma.getsuman().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.DESCUENTOVALOR+"=";
		sDescripcion+=proforma.getdescuento_valor().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.MONTOSINIVA+"=";
		sDescripcion+=proforma.getmonto_sin_iva().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.DESCUENTOGENERAL+"=";
		sDescripcion+=proforma.getdescuento_general().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.FLETE+"=";
		sDescripcion+=proforma.getflete().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.ULTIMOCOSTO+"=";
		sDescripcion+=proforma.getultimo_costo().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=proforma.getsubtotal().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.OTROSCARGOS+"=";
		sDescripcion+=proforma.getotros_cargos().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.MARGENUTILIDAD+"=";
		sDescripcion+=proforma.getmargen_utilidad().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.IVA+"=";
		sDescripcion+=proforma.getiva().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.FINANCIAMIENTO+"=";
		sDescripcion+=proforma.getfinanciamiento().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.TOTAL+"=";
		sDescripcion+=proforma.gettotal().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.OTROSVALORES+"=";
		sDescripcion+=proforma.getotros_valores().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.ANTICIPO+"=";
		sDescripcion+=proforma.getanticipo().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.ICE+"=";
		sDescripcion+=proforma.getice().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.MONTORETENCION+"=";
		sDescripcion+=proforma.getmonto_retencion().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.FECHA+"=";
		sDescripcion+=proforma.getfecha().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.FECHASERVIDOR+"=";
		sDescripcion+=proforma.getfecha_servidor().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.HORAINICIO+"=";
		sDescripcion+=proforma.gethora_inicio().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.HORAFIN+"=";
		sDescripcion+=proforma.gethora_fin().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=proforma.getid_centro_costo().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.IDTIPOPROFORMA+"=";
		sDescripcion+=proforma.getid_tipo_proforma().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.IDCONSIGNATARIO+"=";
		sDescripcion+=proforma.getid_consignatario().toString()+",";
		sDescripcion+=ProformaConstantesFunciones.IDTIPOCAMBIO+"=";
		sDescripcion+=proforma.getid_tipo_cambio().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProformaDescripcion(Proforma proforma,String sValor) throws Exception {			
		if(proforma !=null) {
			//proformaproforma.getId().toString();
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

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
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

	public static String getEstadoProformaDescripcion(EstadoProforma estadoproforma) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadoproforma!=null/*&&estadoproforma.getId()>0*/) {
			sDescripcion=EstadoProformaConstantesFunciones.getEstadoProformaDescripcion(estadoproforma);
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

	public static String getTipoPrecioDescripcion(TipoPrecio tipoprecio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoprecio!=null/*&&tipoprecio.getId()>0*/) {
			sDescripcion=TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(tipoprecio);
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

	public static String getTipoViaTransporteDescripcion(TipoViaTransporte tipoviatransporte) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoviatransporte!=null/*&&tipoviatransporte.getId()>0*/) {
			sDescripcion=TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcion(tipoviatransporte);
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

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
		}

		return sDescripcion;
	}

	public static String getTipoProformaDescripcion(TipoProforma tipoproforma) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoproforma!=null/*&&tipoproforma.getId()>0*/) {
			sDescripcion=TipoProformaConstantesFunciones.getTipoProformaDescripcion(tipoproforma);
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

	public static String getTipoCambioDescripcion(TipoCambio tipocambio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocambio!=null/*&&tipocambio.getId()>0*/) {
			sDescripcion=TipoCambioConstantesFunciones.getTipoCambioDescripcion(tipocambio);
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
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoProforma")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdRutaTransporte")) {
			sNombreIndice="Tipo=  Por Ruta";
		} else if(sNombreIndice.equals("FK_IdSubCliente")) {
			sNombreIndice="Tipo=  Por Contacto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCambio")) {
			sNombreIndice="Tipo=  Por T. Cambio";
		} else if(sNombreIndice.equals("FK_IdTipoPrecio")) {
			sNombreIndice="Tipo=  Por Tipo Precio";
		} else if(sNombreIndice.equals("FK_IdTipoProforma")) {
			sNombreIndice="Tipo=  Por Tipo Proforma";
		} else if(sNombreIndice.equals("FK_IdTipoViaTransporte")) {
			sNombreIndice="Tipo=  Por Forma Envio";
		} else if(sNombreIndice.equals("FK_IdTransporte")) {
			sNombreIndice="Tipo=  Por Transporte";
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

	public static String getDetalleIndiceFK_IdEstadoProforma(Long id_estado_proforma) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_proforma!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_proforma.toString();} 

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
		if(id_tipo_cambio!=null) {sDetalleIndice+=" Codigo Unico De T. Cambio="+id_tipo_cambio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoPrecio(Long id_tipo_precio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_precio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Precio="+id_tipo_precio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoProforma(Long id_tipo_proforma) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_proforma!=null) {sDetalleIndice+=" Codigo Unico De Tipo Proforma="+id_tipo_proforma.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoViaTransporte(Long id_tipo_via_transporte) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_via_transporte!=null) {sDetalleIndice+=" Codigo Unico De Forma Envio="+id_tipo_via_transporte.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransporte(Long id_transporte) {
		String sDetalleIndice=" Parametros->";
		if(id_transporte!=null) {sDetalleIndice+=" Codigo Unico De Transporte="+id_transporte.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosProforma(Proforma proforma,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		proforma.setnumero_pre_impreso(proforma.getnumero_pre_impreso().trim());
		proforma.setdireccion(proforma.getdireccion().trim());
		proforma.setruc(proforma.getruc().trim());
		proforma.settelefono(proforma.gettelefono().trim());
		proforma.setdescripcion(proforma.getdescripcion().trim());
	}
	
	public static void quitarEspaciosProformas(List<Proforma> proformas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Proforma proforma: proformas) {
			proforma.setnumero_pre_impreso(proforma.getnumero_pre_impreso().trim());
			proforma.setdireccion(proforma.getdireccion().trim());
			proforma.setruc(proforma.getruc().trim());
			proforma.settelefono(proforma.gettelefono().trim());
			proforma.setdescripcion(proforma.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProforma(Proforma proforma,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && proforma.getConCambioAuxiliar()) {
			proforma.setIsDeleted(proforma.getIsDeletedAuxiliar());	
			proforma.setIsNew(proforma.getIsNewAuxiliar());	
			proforma.setIsChanged(proforma.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			proforma.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			proforma.setIsDeletedAuxiliar(false);	
			proforma.setIsNewAuxiliar(false);	
			proforma.setIsChangedAuxiliar(false);
			
			proforma.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProformas(List<Proforma> proformas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Proforma proforma : proformas) {
			if(conAsignarBase && proforma.getConCambioAuxiliar()) {
				proforma.setIsDeleted(proforma.getIsDeletedAuxiliar());	
				proforma.setIsNew(proforma.getIsNewAuxiliar());	
				proforma.setIsChanged(proforma.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				proforma.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				proforma.setIsDeletedAuxiliar(false);	
				proforma.setIsNewAuxiliar(false);	
				proforma.setIsChangedAuxiliar(false);
				
				proforma.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProforma(Proforma proforma,Boolean conEnteros) throws Exception  {
		proforma.setcotizacion(0.0);
		proforma.setdescuento_porcentaje(0.0);
		proforma.setmonto_con_iva(0.0);
		proforma.setsuman(0.0);
		proforma.setdescuento_valor(0.0);
		proforma.setmonto_sin_iva(0.0);
		proforma.setdescuento_general(0.0);
		proforma.setflete(0.0);
		proforma.setultimo_costo(0.0);
		proforma.setsubtotal(0.0);
		proforma.setotros_cargos(0.0);
		proforma.setmargen_utilidad(0.0);
		proforma.setiva(0.0);
		proforma.setfinanciamiento(0.0);
		proforma.settotal(0.0);
		proforma.setotros_valores(0.0);
		proforma.setanticipo(0.0);
		proforma.setice(0.0);
		proforma.setmonto_retencion(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			proforma.setdias(0);
		}
	}		
	
	public static void InicializarValoresProformas(List<Proforma> proformas,Boolean conEnteros) throws Exception  {
		
		for(Proforma proforma: proformas) {
			proforma.setcotizacion(0.0);
			proforma.setdescuento_porcentaje(0.0);
			proforma.setmonto_con_iva(0.0);
			proforma.setsuman(0.0);
			proforma.setdescuento_valor(0.0);
			proforma.setmonto_sin_iva(0.0);
			proforma.setdescuento_general(0.0);
			proforma.setflete(0.0);
			proforma.setultimo_costo(0.0);
			proforma.setsubtotal(0.0);
			proforma.setotros_cargos(0.0);
			proforma.setmargen_utilidad(0.0);
			proforma.setiva(0.0);
			proforma.setfinanciamiento(0.0);
			proforma.settotal(0.0);
			proforma.setotros_valores(0.0);
			proforma.setanticipo(0.0);
			proforma.setice(0.0);
			proforma.setmonto_retencion(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				proforma.setdias(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProforma(List<Proforma> proformas,Proforma proformaAux) throws Exception  {
		ProformaConstantesFunciones.InicializarValoresProforma(proformaAux,true);
		
		for(Proforma proforma: proformas) {
			if(proforma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			proformaAux.setdias(proformaAux.getdias()+proforma.getdias());			
			proformaAux.setcotizacion(proformaAux.getcotizacion()+proforma.getcotizacion());			
			proformaAux.setdescuento_porcentaje(proformaAux.getdescuento_porcentaje()+proforma.getdescuento_porcentaje());			
			proformaAux.setmonto_con_iva(proformaAux.getmonto_con_iva()+proforma.getmonto_con_iva());			
			proformaAux.setsuman(proformaAux.getsuman()+proforma.getsuman());			
			proformaAux.setdescuento_valor(proformaAux.getdescuento_valor()+proforma.getdescuento_valor());			
			proformaAux.setmonto_sin_iva(proformaAux.getmonto_sin_iva()+proforma.getmonto_sin_iva());			
			proformaAux.setdescuento_general(proformaAux.getdescuento_general()+proforma.getdescuento_general());			
			proformaAux.setflete(proformaAux.getflete()+proforma.getflete());			
			proformaAux.setultimo_costo(proformaAux.getultimo_costo()+proforma.getultimo_costo());			
			proformaAux.setsubtotal(proformaAux.getsubtotal()+proforma.getsubtotal());			
			proformaAux.setotros_cargos(proformaAux.getotros_cargos()+proforma.getotros_cargos());			
			proformaAux.setmargen_utilidad(proformaAux.getmargen_utilidad()+proforma.getmargen_utilidad());			
			proformaAux.setiva(proformaAux.getiva()+proforma.getiva());			
			proformaAux.setfinanciamiento(proformaAux.getfinanciamiento()+proforma.getfinanciamiento());			
			proformaAux.settotal(proformaAux.gettotal()+proforma.gettotal());			
			proformaAux.setotros_valores(proformaAux.getotros_valores()+proforma.getotros_valores());			
			proformaAux.setanticipo(proformaAux.getanticipo()+proforma.getanticipo());			
			proformaAux.setice(proformaAux.getice()+proforma.getice());			
			proformaAux.setmonto_retencion(proformaAux.getmonto_retencion()+proforma.getmonto_retencion());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProforma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProformaConstantesFunciones.getArrayColumnasGlobalesProforma(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProforma(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProformaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProformaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProformaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProformaConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProformaConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProformaConstantesFunciones.IDUSUARIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProformaConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProformaConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProformaConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProformaConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProformaConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProformaConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProforma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Proforma> proformas,Proforma proforma,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Proforma proformaAux: proformas) {
			if(proformaAux!=null && proforma!=null) {
				if((proformaAux.getId()==null && proforma.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(proformaAux.getId()!=null && proforma.getId()!=null){
					if(proformaAux.getId().equals(proforma.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProforma(List<Proforma> proformas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double cotizacionTotal=0.0;
		Double descuento_porcentajeTotal=0.0;
		Double monto_con_ivaTotal=0.0;
		Double sumanTotal=0.0;
		Double descuento_valorTotal=0.0;
		Double monto_sin_ivaTotal=0.0;
		Double descuento_generalTotal=0.0;
		Double fleteTotal=0.0;
		Double ultimo_costoTotal=0.0;
		Double subtotalTotal=0.0;
		Double otros_cargosTotal=0.0;
		Double margen_utilidadTotal=0.0;
		Double ivaTotal=0.0;
		Double financiamientoTotal=0.0;
		Double totalTotal=0.0;
		Double otros_valoresTotal=0.0;
		Double anticipoTotal=0.0;
		Double iceTotal=0.0;
		Double monto_retencionTotal=0.0;
	
		for(Proforma proforma: proformas) {			
			if(proforma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cotizacionTotal+=proforma.getcotizacion();
			descuento_porcentajeTotal+=proforma.getdescuento_porcentaje();
			monto_con_ivaTotal+=proforma.getmonto_con_iva();
			sumanTotal+=proforma.getsuman();
			descuento_valorTotal+=proforma.getdescuento_valor();
			monto_sin_ivaTotal+=proforma.getmonto_sin_iva();
			descuento_generalTotal+=proforma.getdescuento_general();
			fleteTotal+=proforma.getflete();
			ultimo_costoTotal+=proforma.getultimo_costo();
			subtotalTotal+=proforma.getsubtotal();
			otros_cargosTotal+=proforma.getotros_cargos();
			margen_utilidadTotal+=proforma.getmargen_utilidad();
			ivaTotal+=proforma.getiva();
			financiamientoTotal+=proforma.getfinanciamiento();
			totalTotal+=proforma.gettotal();
			otros_valoresTotal+=proforma.getotros_valores();
			anticipoTotal+=proforma.getanticipo();
			iceTotal+=proforma.getice();
			monto_retencionTotal+=proforma.getmonto_retencion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.COTIZACION);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_COTIZACION);
		datoGeneral.setdValorDouble(cotizacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.DESCUENTOPORCENTAJE);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
		datoGeneral.setdValorDouble(descuento_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.MONTOCONIVA);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_MONTOCONIVA);
		datoGeneral.setdValorDouble(monto_con_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.SUMAN);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_SUMAN);
		datoGeneral.setdValorDouble(sumanTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.DESCUENTOVALOR);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_DESCUENTOVALOR);
		datoGeneral.setdValorDouble(descuento_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.MONTOSINIVA);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_MONTOSINIVA);
		datoGeneral.setdValorDouble(monto_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.DESCUENTOGENERAL);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_DESCUENTOGENERAL);
		datoGeneral.setdValorDouble(descuento_generalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.ULTIMOCOSTO);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_ULTIMOCOSTO);
		datoGeneral.setdValorDouble(ultimo_costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(subtotalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.OTROSCARGOS);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_OTROSCARGOS);
		datoGeneral.setdValorDouble(otros_cargosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.MARGENUTILIDAD);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_MARGENUTILIDAD);
		datoGeneral.setdValorDouble(margen_utilidadTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.OTROSVALORES);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_OTROSVALORES);
		datoGeneral.setdValorDouble(otros_valoresTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.ANTICIPO);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_ANTICIPO);
		datoGeneral.setdValorDouble(anticipoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.MONTORETENCION);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_MONTORETENCION);
		datoGeneral.setdValorDouble(monto_retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProforma() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_ID, ProformaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_VERSIONROW, ProformaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IDEMPRESA, ProformaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IDSUCURSAL, ProformaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IDUSUARIO, ProformaConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IDEJERCICIO, ProformaConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IDPERIODO, ProformaConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IDANIO, ProformaConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IDMES, ProformaConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_NUMEROPREIMPRESO, ProformaConstantesFunciones.NUMEROPREIMPRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_FECHAEMISION, ProformaConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_DIAS, ProformaConstantesFunciones.DIAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_FECHAVENCIMIENTO, ProformaConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IDMONEDA, ProformaConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_COTIZACION, ProformaConstantesFunciones.COTIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IDEMPLEADO, ProformaConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IDFORMATO, ProformaConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IDESTADOPROFORMA, ProformaConstantesFunciones.IDESTADOPROFORMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_DIRECCION, ProformaConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IDCLIENTE, ProformaConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_RUC, ProformaConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_ESOFERTA, ProformaConstantesFunciones.ESOFERTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_TELEFONO, ProformaConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IDTIPOPRECIO, ProformaConstantesFunciones.IDTIPOPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IDVENDEDOR, ProformaConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IDSUBCLIENTE, ProformaConstantesFunciones.IDSUBCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE, ProformaConstantesFunciones.IDTIPOVIATRANSPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IDTRANSPORTE, ProformaConstantesFunciones.IDTRANSPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IDRUTATRANSPORTE, ProformaConstantesFunciones.IDRUTATRANSPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_DESCRIPCION, ProformaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_DESCUENTOPORCENTAJE, ProformaConstantesFunciones.DESCUENTOPORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_MONTOCONIVA, ProformaConstantesFunciones.MONTOCONIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_SUMAN, ProformaConstantesFunciones.SUMAN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_DESCUENTOVALOR, ProformaConstantesFunciones.DESCUENTOVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_MONTOSINIVA, ProformaConstantesFunciones.MONTOSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_DESCUENTOGENERAL, ProformaConstantesFunciones.DESCUENTOGENERAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_FLETE, ProformaConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_ULTIMOCOSTO, ProformaConstantesFunciones.ULTIMOCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_SUBTOTAL, ProformaConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_OTROSCARGOS, ProformaConstantesFunciones.OTROSCARGOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_MARGENUTILIDAD, ProformaConstantesFunciones.MARGENUTILIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IVA, ProformaConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_FINANCIAMIENTO, ProformaConstantesFunciones.FINANCIAMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_TOTAL, ProformaConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_OTROSVALORES, ProformaConstantesFunciones.OTROSVALORES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_ANTICIPO, ProformaConstantesFunciones.ANTICIPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_ICE, ProformaConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_MONTORETENCION, ProformaConstantesFunciones.MONTORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_FECHA, ProformaConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_FECHASERVIDOR, ProformaConstantesFunciones.FECHASERVIDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_HORAINICIO, ProformaConstantesFunciones.HORAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_HORAFIN, ProformaConstantesFunciones.HORAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IDCENTROCOSTO, ProformaConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IDTIPOPROFORMA, ProformaConstantesFunciones.IDTIPOPROFORMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IDCONSIGNATARIO, ProformaConstantesFunciones.IDCONSIGNATARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProformaConstantesFunciones.LABEL_IDTIPOCAMBIO, ProformaConstantesFunciones.IDTIPOCAMBIO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProforma() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.NUMEROPREIMPRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.DIAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.COTIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IDESTADOPROFORMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.ESOFERTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IDTIPOPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IDSUBCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IDTIPOVIATRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IDTRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IDRUTATRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.DESCUENTOPORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.MONTOCONIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.SUMAN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.DESCUENTOVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.MONTOSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.DESCUENTOGENERAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.ULTIMOCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.OTROSCARGOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.MARGENUTILIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.FINANCIAMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.OTROSVALORES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.ANTICIPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.MONTORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.FECHASERVIDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.HORAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.HORAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IDTIPOPROFORMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IDCONSIGNATARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProformaConstantesFunciones.IDTIPOCAMBIO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProforma() throws Exception  {
		return ProformaConstantesFunciones.getTiposSeleccionarProforma(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProforma(Boolean conFk) throws Exception  {
		return ProformaConstantesFunciones.getTiposSeleccionarProforma(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProforma(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_NUMEROPREIMPRESO);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_NUMEROPREIMPRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_DIAS);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_DIAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_COTIZACION);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_COTIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IDESTADOPROFORMA);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IDESTADOPROFORMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_ESOFERTA);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_ESOFERTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IDTIPOPRECIO);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IDTIPOPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IDSUBCLIENTE);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IDSUBCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IDTRANSPORTE);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IDTRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IDRUTATRANSPORTE);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IDRUTATRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_MONTOCONIVA);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_MONTOCONIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_SUMAN);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_SUMAN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_DESCUENTOVALOR);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_DESCUENTOVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_MONTOSINIVA);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_MONTOSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_DESCUENTOGENERAL);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_DESCUENTOGENERAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_ULTIMOCOSTO);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_ULTIMOCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_OTROSCARGOS);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_OTROSCARGOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_MARGENUTILIDAD);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_MARGENUTILIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_FINANCIAMIENTO);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_FINANCIAMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_OTROSVALORES);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_OTROSVALORES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_ANTICIPO);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_ANTICIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_MONTORETENCION);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_MONTORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_FECHASERVIDOR);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_FECHASERVIDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(ProformaConstantesFunciones.LABEL_HORAINICIO);
		reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_HORAINICIO);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(ProformaConstantesFunciones.LABEL_HORAFIN);
		reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_HORAFIN);

		arrTiposSeleccionarTodos.add(reporte);
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IDTIPOPROFORMA);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IDTIPOPROFORMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IDCONSIGNATARIO);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IDCONSIGNATARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProformaConstantesFunciones.LABEL_IDTIPOCAMBIO);
			reporte.setsDescripcion(ProformaConstantesFunciones.LABEL_IDTIPOCAMBIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProforma(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProforma(Proforma proformaAux) throws Exception {
		
			proformaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(proformaAux.getEmpresa()));
			proformaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(proformaAux.getSucursal()));
			proformaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(proformaAux.getUsuario()));
			proformaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(proformaAux.getEjercicio()));
			proformaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(proformaAux.getPeriodo()));
			proformaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(proformaAux.getAnio()));
			proformaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(proformaAux.getMes()));
			proformaAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(proformaAux.getMoneda()));
			proformaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(proformaAux.getEmpleado()));
			proformaAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(proformaAux.getFormato()));
			proformaAux.setestadoproforma_descripcion(EstadoProformaConstantesFunciones.getEstadoProformaDescripcion(proformaAux.getEstadoProforma()));
			proformaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(proformaAux.getCliente()));
			proformaAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(proformaAux.getTipoPrecio()));
			proformaAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(proformaAux.getVendedor()));
			proformaAux.setsubcliente_descripcion(SubClienteConstantesFunciones.getSubClienteDescripcion(proformaAux.getSubCliente()));
			proformaAux.settipoviatransporte_descripcion(TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcion(proformaAux.getTipoViaTransporte()));
			proformaAux.settransporte_descripcion(TransporteConstantesFunciones.getTransporteDescripcion(proformaAux.getTransporte()));
			proformaAux.setrutatransporte_descripcion(RutaTransporteConstantesFunciones.getRutaTransporteDescripcion(proformaAux.getRutaTransporte()));
			proformaAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(proformaAux.getCentroCosto()));
			proformaAux.settipoproforma_descripcion(TipoProformaConstantesFunciones.getTipoProformaDescripcion(proformaAux.getTipoProforma()));
			proformaAux.setconsignatario_descripcion(ConsignatarioConstantesFunciones.getConsignatarioDescripcion(proformaAux.getConsignatario()));
			proformaAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(proformaAux.getTipoCambio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProforma(List<Proforma> proformasTemp) throws Exception {
		for(Proforma proformaAux:proformasTemp) {
			
			proformaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(proformaAux.getEmpresa()));
			proformaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(proformaAux.getSucursal()));
			proformaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(proformaAux.getUsuario()));
			proformaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(proformaAux.getEjercicio()));
			proformaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(proformaAux.getPeriodo()));
			proformaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(proformaAux.getAnio()));
			proformaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(proformaAux.getMes()));
			proformaAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(proformaAux.getMoneda()));
			proformaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(proformaAux.getEmpleado()));
			proformaAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(proformaAux.getFormato()));
			proformaAux.setestadoproforma_descripcion(EstadoProformaConstantesFunciones.getEstadoProformaDescripcion(proformaAux.getEstadoProforma()));
			proformaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(proformaAux.getCliente()));
			proformaAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(proformaAux.getTipoPrecio()));
			proformaAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(proformaAux.getVendedor()));
			proformaAux.setsubcliente_descripcion(SubClienteConstantesFunciones.getSubClienteDescripcion(proformaAux.getSubCliente()));
			proformaAux.settipoviatransporte_descripcion(TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcion(proformaAux.getTipoViaTransporte()));
			proformaAux.settransporte_descripcion(TransporteConstantesFunciones.getTransporteDescripcion(proformaAux.getTransporte()));
			proformaAux.setrutatransporte_descripcion(RutaTransporteConstantesFunciones.getRutaTransporteDescripcion(proformaAux.getRutaTransporte()));
			proformaAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(proformaAux.getCentroCosto()));
			proformaAux.settipoproforma_descripcion(TipoProformaConstantesFunciones.getTipoProformaDescripcion(proformaAux.getTipoProforma()));
			proformaAux.setconsignatario_descripcion(ConsignatarioConstantesFunciones.getConsignatarioDescripcion(proformaAux.getConsignatario()));
			proformaAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(proformaAux.getTipoCambio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(EstadoProforma.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoPrecio.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(SubCliente.class));
				classes.add(new Classe(TipoViaTransporte.class));
				classes.add(new Classe(Transporte.class));
				classes.add(new Classe(RutaTransporte.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(TipoProforma.class));
				classes.add(new Classe(Consignatario.class));
				classes.add(new Classe(TipoCambio.class));
				
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
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
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
					if(clas.clas.equals(EstadoProforma.class)) {
						classes.add(new Classe(EstadoProforma.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPrecio.class)) {
						classes.add(new Classe(TipoPrecio.class));
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
					if(clas.clas.equals(TipoViaTransporte.class)) {
						classes.add(new Classe(TipoViaTransporte.class));
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
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoProforma.class)) {
						classes.add(new Classe(TipoProforma.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Consignatario.class)) {
						classes.add(new Classe(Consignatario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCambio.class)) {
						classes.add(new Classe(TipoCambio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProforma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
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

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(EstadoProforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoProforma.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(TipoViaTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoViaTransporte.class)); continue;
					}

					if(Transporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transporte.class)); continue;
					}

					if(RutaTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RutaTransporte.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(TipoProforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProforma.class)); continue;
					}

					if(Consignatario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignatario.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
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

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(EstadoProforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoProforma.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(TipoViaTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoViaTransporte.class)); continue;
					}

					if(Transporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transporte.class)); continue;
					}

					if(RutaTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RutaTransporte.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(TipoProforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProforma.class)); continue;
					}

					if(Consignatario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignatario.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProformaConstantesFunciones.getClassesRelationshipsOfProforma(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TerminoProforma.class));
				classes.add(new Classe(DetalleProforma.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(TerminoProforma.class)) {
						classes.add(new Classe(TerminoProforma.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleProforma.class)) {
						classes.add(new Classe(DetalleProforma.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProforma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProformaConstantesFunciones.getClassesRelationshipsFromStringsOfProforma(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProforma(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(TerminoProforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TerminoProforma.class)); continue;
					}

					if(DetalleProforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleProforma.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(TerminoProforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TerminoProforma.class)); continue;
					}

					if(DetalleProforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleProforma.class)); continue;
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
	public static void actualizarLista(Proforma proforma,List<Proforma> proformas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Proforma proformaEncontrado=null;
			
			for(Proforma proformaLocal:proformas) {
				if(proformaLocal.getId().equals(proforma.getId())) {
					proformaEncontrado=proformaLocal;
					
					proformaLocal.setIsChanged(proforma.getIsChanged());
					proformaLocal.setIsNew(proforma.getIsNew());
					proformaLocal.setIsDeleted(proforma.getIsDeleted());
					
					proformaLocal.setGeneralEntityOriginal(proforma.getGeneralEntityOriginal());
					
					proformaLocal.setId(proforma.getId());	
					proformaLocal.setVersionRow(proforma.getVersionRow());	
					proformaLocal.setid_empresa(proforma.getid_empresa());	
					proformaLocal.setid_sucursal(proforma.getid_sucursal());	
					proformaLocal.setid_usuario(proforma.getid_usuario());	
					proformaLocal.setid_ejercicio(proforma.getid_ejercicio());	
					proformaLocal.setid_periodo(proforma.getid_periodo());	
					proformaLocal.setid_anio(proforma.getid_anio());	
					proformaLocal.setid_mes(proforma.getid_mes());	
					proformaLocal.setnumero_pre_impreso(proforma.getnumero_pre_impreso());	
					proformaLocal.setfecha_emision(proforma.getfecha_emision());	
					proformaLocal.setdias(proforma.getdias());	
					proformaLocal.setfecha_vencimiento(proforma.getfecha_vencimiento());	
					proformaLocal.setid_moneda(proforma.getid_moneda());	
					proformaLocal.setcotizacion(proforma.getcotizacion());	
					proformaLocal.setid_empleado(proforma.getid_empleado());	
					proformaLocal.setid_formato(proforma.getid_formato());	
					proformaLocal.setid_estado_proforma(proforma.getid_estado_proforma());	
					proformaLocal.setdireccion(proforma.getdireccion());	
					proformaLocal.setid_cliente(proforma.getid_cliente());	
					proformaLocal.setruc(proforma.getruc());	
					proformaLocal.setes_oferta(proforma.getes_oferta());	
					proformaLocal.settelefono(proforma.gettelefono());	
					proformaLocal.setid_tipo_precio(proforma.getid_tipo_precio());	
					proformaLocal.setid_vendedor(proforma.getid_vendedor());	
					proformaLocal.setid_sub_cliente(proforma.getid_sub_cliente());	
					proformaLocal.setid_tipo_via_transporte(proforma.getid_tipo_via_transporte());	
					proformaLocal.setid_transporte(proforma.getid_transporte());	
					proformaLocal.setid_ruta_transporte(proforma.getid_ruta_transporte());	
					proformaLocal.setdescripcion(proforma.getdescripcion());	
					proformaLocal.setdescuento_porcentaje(proforma.getdescuento_porcentaje());	
					proformaLocal.setmonto_con_iva(proforma.getmonto_con_iva());	
					proformaLocal.setsuman(proforma.getsuman());	
					proformaLocal.setdescuento_valor(proforma.getdescuento_valor());	
					proformaLocal.setmonto_sin_iva(proforma.getmonto_sin_iva());	
					proformaLocal.setdescuento_general(proforma.getdescuento_general());	
					proformaLocal.setflete(proforma.getflete());	
					proformaLocal.setultimo_costo(proforma.getultimo_costo());	
					proformaLocal.setsubtotal(proforma.getsubtotal());	
					proformaLocal.setotros_cargos(proforma.getotros_cargos());	
					proformaLocal.setmargen_utilidad(proforma.getmargen_utilidad());	
					proformaLocal.setiva(proforma.getiva());	
					proformaLocal.setfinanciamiento(proforma.getfinanciamiento());	
					proformaLocal.settotal(proforma.gettotal());	
					proformaLocal.setotros_valores(proforma.getotros_valores());	
					proformaLocal.setanticipo(proforma.getanticipo());	
					proformaLocal.setice(proforma.getice());	
					proformaLocal.setmonto_retencion(proforma.getmonto_retencion());	
					proformaLocal.setfecha(proforma.getfecha());	
					proformaLocal.setfecha_servidor(proforma.getfecha_servidor());	
					proformaLocal.sethora_inicio(proforma.gethora_inicio());	
					proformaLocal.sethora_fin(proforma.gethora_fin());	
					proformaLocal.setid_centro_costo(proforma.getid_centro_costo());	
					proformaLocal.setid_tipo_proforma(proforma.getid_tipo_proforma());	
					proformaLocal.setid_consignatario(proforma.getid_consignatario());	
					proformaLocal.setid_tipo_cambio(proforma.getid_tipo_cambio());	
					
					
					proformaLocal.setTerminoProformas(proforma.getTerminoProformas());
					proformaLocal.setDetalleProformas(proforma.getDetalleProformas());
					
					existe=true;
					break;
				}
			}
			
			if(!proforma.getIsDeleted()) {
				if(!existe) {
					proformas.add(proforma);
				}
			} else {
				if(proformaEncontrado!=null && permiteQuitar)  {
					proformas.remove(proformaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Proforma proforma,List<Proforma> proformas) throws Exception {
		try	{			
			for(Proforma proformaLocal:proformas) {
				if(proformaLocal.getId().equals(proforma.getId())) {
					proformaLocal.setIsSelected(proforma.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProforma(List<Proforma> proformasAux) throws Exception {
		//this.proformasAux=proformasAux;
		
		for(Proforma proformaAux:proformasAux) {
			if(proformaAux.getIsChanged()) {
				proformaAux.setIsChanged(false);
			}		
			
			if(proformaAux.getIsNew()) {
				proformaAux.setIsNew(false);
			}	
			
			if(proformaAux.getIsDeleted()) {
				proformaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProforma(Proforma proformaAux) throws Exception {
		//this.proformaAux=proformaAux;
		
			if(proformaAux.getIsChanged()) {
				proformaAux.setIsChanged(false);
			}		
			
			if(proformaAux.getIsNew()) {
				proformaAux.setIsNew(false);
			}	
			
			if(proformaAux.getIsDeleted()) {
				proformaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Proforma proformaAsignar,Proforma proforma) throws Exception {
		proformaAsignar.setId(proforma.getId());	
		proformaAsignar.setVersionRow(proforma.getVersionRow());	
		proformaAsignar.setid_empresa(proforma.getid_empresa());
		proformaAsignar.setempresa_descripcion(proforma.getempresa_descripcion());	
		proformaAsignar.setid_sucursal(proforma.getid_sucursal());
		proformaAsignar.setsucursal_descripcion(proforma.getsucursal_descripcion());	
		proformaAsignar.setid_usuario(proforma.getid_usuario());
		proformaAsignar.setusuario_descripcion(proforma.getusuario_descripcion());	
		proformaAsignar.setid_ejercicio(proforma.getid_ejercicio());
		proformaAsignar.setejercicio_descripcion(proforma.getejercicio_descripcion());	
		proformaAsignar.setid_periodo(proforma.getid_periodo());
		proformaAsignar.setperiodo_descripcion(proforma.getperiodo_descripcion());	
		proformaAsignar.setid_anio(proforma.getid_anio());
		proformaAsignar.setanio_descripcion(proforma.getanio_descripcion());	
		proformaAsignar.setid_mes(proforma.getid_mes());
		proformaAsignar.setmes_descripcion(proforma.getmes_descripcion());	
		proformaAsignar.setnumero_pre_impreso(proforma.getnumero_pre_impreso());	
		proformaAsignar.setfecha_emision(proforma.getfecha_emision());	
		proformaAsignar.setdias(proforma.getdias());	
		proformaAsignar.setfecha_vencimiento(proforma.getfecha_vencimiento());	
		proformaAsignar.setid_moneda(proforma.getid_moneda());
		proformaAsignar.setmoneda_descripcion(proforma.getmoneda_descripcion());	
		proformaAsignar.setcotizacion(proforma.getcotizacion());	
		proformaAsignar.setid_empleado(proforma.getid_empleado());
		proformaAsignar.setempleado_descripcion(proforma.getempleado_descripcion());	
		proformaAsignar.setid_formato(proforma.getid_formato());
		proformaAsignar.setformato_descripcion(proforma.getformato_descripcion());	
		proformaAsignar.setid_estado_proforma(proforma.getid_estado_proforma());
		proformaAsignar.setestadoproforma_descripcion(proforma.getestadoproforma_descripcion());	
		proformaAsignar.setdireccion(proforma.getdireccion());	
		proformaAsignar.setid_cliente(proforma.getid_cliente());
		proformaAsignar.setcliente_descripcion(proforma.getcliente_descripcion());	
		proformaAsignar.setruc(proforma.getruc());	
		proformaAsignar.setes_oferta(proforma.getes_oferta());	
		proformaAsignar.settelefono(proforma.gettelefono());	
		proformaAsignar.setid_tipo_precio(proforma.getid_tipo_precio());
		proformaAsignar.settipoprecio_descripcion(proforma.gettipoprecio_descripcion());	
		proformaAsignar.setid_vendedor(proforma.getid_vendedor());
		proformaAsignar.setvendedor_descripcion(proforma.getvendedor_descripcion());	
		proformaAsignar.setid_sub_cliente(proforma.getid_sub_cliente());
		proformaAsignar.setsubcliente_descripcion(proforma.getsubcliente_descripcion());	
		proformaAsignar.setid_tipo_via_transporte(proforma.getid_tipo_via_transporte());
		proformaAsignar.settipoviatransporte_descripcion(proforma.gettipoviatransporte_descripcion());	
		proformaAsignar.setid_transporte(proforma.getid_transporte());
		proformaAsignar.settransporte_descripcion(proforma.gettransporte_descripcion());	
		proformaAsignar.setid_ruta_transporte(proforma.getid_ruta_transporte());
		proformaAsignar.setrutatransporte_descripcion(proforma.getrutatransporte_descripcion());	
		proformaAsignar.setdescripcion(proforma.getdescripcion());	
		proformaAsignar.setdescuento_porcentaje(proforma.getdescuento_porcentaje());	
		proformaAsignar.setmonto_con_iva(proforma.getmonto_con_iva());	
		proformaAsignar.setsuman(proforma.getsuman());	
		proformaAsignar.setdescuento_valor(proforma.getdescuento_valor());	
		proformaAsignar.setmonto_sin_iva(proforma.getmonto_sin_iva());	
		proformaAsignar.setdescuento_general(proforma.getdescuento_general());	
		proformaAsignar.setflete(proforma.getflete());	
		proformaAsignar.setultimo_costo(proforma.getultimo_costo());	
		proformaAsignar.setsubtotal(proforma.getsubtotal());	
		proformaAsignar.setotros_cargos(proforma.getotros_cargos());	
		proformaAsignar.setmargen_utilidad(proforma.getmargen_utilidad());	
		proformaAsignar.setiva(proforma.getiva());	
		proformaAsignar.setfinanciamiento(proforma.getfinanciamiento());	
		proformaAsignar.settotal(proforma.gettotal());	
		proformaAsignar.setotros_valores(proforma.getotros_valores());	
		proformaAsignar.setanticipo(proforma.getanticipo());	
		proformaAsignar.setice(proforma.getice());	
		proformaAsignar.setmonto_retencion(proforma.getmonto_retencion());	
		proformaAsignar.setfecha(proforma.getfecha());	
		proformaAsignar.setfecha_servidor(proforma.getfecha_servidor());	
		proformaAsignar.sethora_inicio(proforma.gethora_inicio());	
		proformaAsignar.sethora_fin(proforma.gethora_fin());	
		proformaAsignar.setid_centro_costo(proforma.getid_centro_costo());
		proformaAsignar.setcentrocosto_descripcion(proforma.getcentrocosto_descripcion());	
		proformaAsignar.setid_tipo_proforma(proforma.getid_tipo_proforma());
		proformaAsignar.settipoproforma_descripcion(proforma.gettipoproforma_descripcion());	
		proformaAsignar.setid_consignatario(proforma.getid_consignatario());
		proformaAsignar.setconsignatario_descripcion(proforma.getconsignatario_descripcion());	
		proformaAsignar.setid_tipo_cambio(proforma.getid_tipo_cambio());
		proformaAsignar.settipocambio_descripcion(proforma.gettipocambio_descripcion());	
	}
	
	public static void inicializarProforma(Proforma proforma) throws Exception {
		try {
				proforma.setId(0L);	
					
				proforma.setid_empresa(-1L);	
				proforma.setid_sucursal(-1L);	
				proforma.setid_usuario(-1L);	
				proforma.setid_ejercicio(-1L);	
				proforma.setid_periodo(-1L);	
				proforma.setid_anio(null);	
				proforma.setid_mes(null);	
				proforma.setnumero_pre_impreso("");	
				proforma.setfecha_emision(new Date());	
				proforma.setdias(0);	
				proforma.setfecha_vencimiento(new Date());	
				proforma.setid_moneda(-1L);	
				proforma.setcotizacion(0.0);	
				proforma.setid_empleado(-1L);	
				proforma.setid_formato(null);	
				proforma.setid_estado_proforma(-1L);	
				proforma.setdireccion("");	
				proforma.setid_cliente(-1L);	
				proforma.setruc("");	
				proforma.setes_oferta(false);	
				proforma.settelefono("");	
				proforma.setid_tipo_precio(-1L);	
				proforma.setid_vendedor(null);	
				proforma.setid_sub_cliente(null);	
				proforma.setid_tipo_via_transporte(-1L);	
				proforma.setid_transporte(-1L);	
				proforma.setid_ruta_transporte(-1L);	
				proforma.setdescripcion("");	
				proforma.setdescuento_porcentaje(0.0);	
				proforma.setmonto_con_iva(0.0);	
				proforma.setsuman(0.0);	
				proforma.setdescuento_valor(0.0);	
				proforma.setmonto_sin_iva(0.0);	
				proforma.setdescuento_general(0.0);	
				proforma.setflete(0.0);	
				proforma.setultimo_costo(0.0);	
				proforma.setsubtotal(0.0);	
				proforma.setotros_cargos(0.0);	
				proforma.setmargen_utilidad(0.0);	
				proforma.setiva(0.0);	
				proforma.setfinanciamiento(0.0);	
				proforma.settotal(0.0);	
				proforma.setotros_valores(0.0);	
				proforma.setanticipo(0.0);	
				proforma.setice(0.0);	
				proforma.setmonto_retencion(0.0);	
				proforma.setfecha(new Date());	
				proforma.setfecha_servidor(new Date());	
				proforma.sethora_inicio(new Time((new Date()).getTime()));	
				proforma.sethora_fin(new Time((new Date()).getTime()));	
				proforma.setid_centro_costo(null);	
				proforma.setid_tipo_proforma(-1L);	
				proforma.setid_consignatario(-1L);	
				proforma.setid_tipo_cambio(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProforma(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_NUMEROPREIMPRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_DIAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_COTIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IDESTADOPROFORMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_ESOFERTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IDTIPOPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IDSUBCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IDTRANSPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IDRUTATRANSPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_MONTOCONIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_SUMAN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_DESCUENTOVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_MONTOSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_DESCUENTOGENERAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_ULTIMOCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_OTROSCARGOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_MARGENUTILIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_FINANCIAMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_OTROSVALORES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_ANTICIPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_MONTORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_FECHASERVIDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_HORAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_HORAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IDTIPOPROFORMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IDCONSIGNATARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProformaConstantesFunciones.LABEL_IDTIPOCAMBIO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProforma(String sTipo,Row row,Workbook workbook,Proforma proforma,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getnumero_pre_impreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getdias());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getcotizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getestadoproforma_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(proforma.getes_oferta()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.gettipoprecio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getsubcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.gettipoviatransporte_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.gettransporte_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getrutatransporte_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getdescuento_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getmonto_con_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getsuman());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getdescuento_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getmonto_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getdescuento_general());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getultimo_costo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getsubtotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getotros_cargos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getmargen_utilidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getfinanciamiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getotros_valores());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getanticipo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getmonto_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getfecha_servidor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.gethora_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.gethora_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.gettipoproforma_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.getconsignatario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proforma.gettipocambio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProforma=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProforma() {
		return this.sFinalQueryProforma;
	}
	
	public void setsFinalQueryProforma(String sFinalQueryProforma) {
		this.sFinalQueryProforma= sFinalQueryProforma;
	}
	
	public Border resaltarSeleccionarProforma=null;
	
	public Border setResaltarSeleccionarProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProforma= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProforma() {
		return this.resaltarSeleccionarProforma;
	}
	
	public void setResaltarSeleccionarProforma(Border borderResaltarSeleccionarProforma) {
		this.resaltarSeleccionarProforma= borderResaltarSeleccionarProforma;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProforma=null;
	public Boolean mostraridProforma=true;
	public Boolean activaridProforma=true;

	public Border resaltarid_empresaProforma=null;
	public Boolean mostrarid_empresaProforma=true;
	public Boolean activarid_empresaProforma=true;
	public Boolean cargarid_empresaProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProforma=false;//ConEventDepend=true

	public Border resaltarid_sucursalProforma=null;
	public Boolean mostrarid_sucursalProforma=true;
	public Boolean activarid_sucursalProforma=true;
	public Boolean cargarid_sucursalProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProforma=false;//ConEventDepend=true

	public Border resaltarid_usuarioProforma=null;
	public Boolean mostrarid_usuarioProforma=true;
	public Boolean activarid_usuarioProforma=true;
	public Boolean cargarid_usuarioProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioProforma=false;//ConEventDepend=true

	public Border resaltarid_ejercicioProforma=null;
	public Boolean mostrarid_ejercicioProforma=true;
	public Boolean activarid_ejercicioProforma=true;
	public Boolean cargarid_ejercicioProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioProforma=false;//ConEventDepend=true

	public Border resaltarid_periodoProforma=null;
	public Boolean mostrarid_periodoProforma=true;
	public Boolean activarid_periodoProforma=true;
	public Boolean cargarid_periodoProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoProforma=false;//ConEventDepend=true

	public Border resaltarid_anioProforma=null;
	public Boolean mostrarid_anioProforma=true;
	public Boolean activarid_anioProforma=false;
	public Boolean cargarid_anioProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioProforma=false;//ConEventDepend=true

	public Border resaltarid_mesProforma=null;
	public Boolean mostrarid_mesProforma=true;
	public Boolean activarid_mesProforma=false;
	public Boolean cargarid_mesProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesProforma=false;//ConEventDepend=true

	public Border resaltarnumero_pre_impresoProforma=null;
	public Boolean mostrarnumero_pre_impresoProforma=true;
	public Boolean activarnumero_pre_impresoProforma=true;

	public Border resaltarfecha_emisionProforma=null;
	public Boolean mostrarfecha_emisionProforma=true;
	public Boolean activarfecha_emisionProforma=true;

	public Border resaltardiasProforma=null;
	public Boolean mostrardiasProforma=true;
	public Boolean activardiasProforma=true;

	public Border resaltarfecha_vencimientoProforma=null;
	public Boolean mostrarfecha_vencimientoProforma=true;
	public Boolean activarfecha_vencimientoProforma=true;

	public Border resaltarid_monedaProforma=null;
	public Boolean mostrarid_monedaProforma=true;
	public Boolean activarid_monedaProforma=true;
	public Boolean cargarid_monedaProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaProforma=false;//ConEventDepend=true

	public Border resaltarcotizacionProforma=null;
	public Boolean mostrarcotizacionProforma=true;
	public Boolean activarcotizacionProforma=true;

	public Border resaltarid_empleadoProforma=null;
	public Boolean mostrarid_empleadoProforma=true;
	public Boolean activarid_empleadoProforma=true;
	public Boolean cargarid_empleadoProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoProforma=false;//ConEventDepend=true

	public Border resaltarid_formatoProforma=null;
	public Boolean mostrarid_formatoProforma=true;
	public Boolean activarid_formatoProforma=true;
	public Boolean cargarid_formatoProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoProforma=false;//ConEventDepend=true

	public Border resaltarid_estado_proformaProforma=null;
	public Boolean mostrarid_estado_proformaProforma=true;
	public Boolean activarid_estado_proformaProforma=true;
	public Boolean cargarid_estado_proformaProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_proformaProforma=false;//ConEventDepend=true

	public Border resaltardireccionProforma=null;
	public Boolean mostrardireccionProforma=true;
	public Boolean activardireccionProforma=true;

	public Border resaltarid_clienteProforma=null;
	public Boolean mostrarid_clienteProforma=true;
	public Boolean activarid_clienteProforma=true;
	public Boolean cargarid_clienteProforma=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteProforma=false;//ConEventDepend=true

	public Border resaltarrucProforma=null;
	public Boolean mostrarrucProforma=true;
	public Boolean activarrucProforma=true;

	public Border resaltares_ofertaProforma=null;
	public Boolean mostrares_ofertaProforma=true;
	public Boolean activares_ofertaProforma=true;

	public Border resaltartelefonoProforma=null;
	public Boolean mostrartelefonoProforma=true;
	public Boolean activartelefonoProforma=true;

	public Border resaltarid_tipo_precioProforma=null;
	public Boolean mostrarid_tipo_precioProforma=true;
	public Boolean activarid_tipo_precioProforma=true;
	public Boolean cargarid_tipo_precioProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_precioProforma=false;//ConEventDepend=true

	public Border resaltarid_vendedorProforma=null;
	public Boolean mostrarid_vendedorProforma=true;
	public Boolean activarid_vendedorProforma=true;
	public Boolean cargarid_vendedorProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorProforma=false;//ConEventDepend=true

	public Border resaltarid_sub_clienteProforma=null;
	public Boolean mostrarid_sub_clienteProforma=true;
	public Boolean activarid_sub_clienteProforma=true;
	public Boolean cargarid_sub_clienteProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sub_clienteProforma=false;//ConEventDepend=true

	public Border resaltarid_tipo_via_transporteProforma=null;
	public Boolean mostrarid_tipo_via_transporteProforma=true;
	public Boolean activarid_tipo_via_transporteProforma=true;
	public Boolean cargarid_tipo_via_transporteProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_via_transporteProforma=false;//ConEventDepend=true

	public Border resaltarid_transporteProforma=null;
	public Boolean mostrarid_transporteProforma=true;
	public Boolean activarid_transporteProforma=true;
	public Boolean cargarid_transporteProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transporteProforma=false;//ConEventDepend=true

	public Border resaltarid_ruta_transporteProforma=null;
	public Boolean mostrarid_ruta_transporteProforma=true;
	public Boolean activarid_ruta_transporteProforma=true;
	public Boolean cargarid_ruta_transporteProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ruta_transporteProforma=false;//ConEventDepend=true

	public Border resaltardescripcionProforma=null;
	public Boolean mostrardescripcionProforma=true;
	public Boolean activardescripcionProforma=true;

	public Border resaltardescuento_porcentajeProforma=null;
	public Boolean mostrardescuento_porcentajeProforma=true;
	public Boolean activardescuento_porcentajeProforma=true;

	public Border resaltarmonto_con_ivaProforma=null;
	public Boolean mostrarmonto_con_ivaProforma=true;
	public Boolean activarmonto_con_ivaProforma=true;

	public Border resaltarsumanProforma=null;
	public Boolean mostrarsumanProforma=true;
	public Boolean activarsumanProforma=true;

	public Border resaltardescuento_valorProforma=null;
	public Boolean mostrardescuento_valorProforma=true;
	public Boolean activardescuento_valorProforma=true;

	public Border resaltarmonto_sin_ivaProforma=null;
	public Boolean mostrarmonto_sin_ivaProforma=true;
	public Boolean activarmonto_sin_ivaProforma=true;

	public Border resaltardescuento_generalProforma=null;
	public Boolean mostrardescuento_generalProforma=true;
	public Boolean activardescuento_generalProforma=true;

	public Border resaltarfleteProforma=null;
	public Boolean mostrarfleteProforma=true;
	public Boolean activarfleteProforma=true;

	public Border resaltarultimo_costoProforma=null;
	public Boolean mostrarultimo_costoProforma=true;
	public Boolean activarultimo_costoProforma=true;

	public Border resaltarsubtotalProforma=null;
	public Boolean mostrarsubtotalProforma=true;
	public Boolean activarsubtotalProforma=true;

	public Border resaltarotros_cargosProforma=null;
	public Boolean mostrarotros_cargosProforma=true;
	public Boolean activarotros_cargosProforma=true;

	public Border resaltarmargen_utilidadProforma=null;
	public Boolean mostrarmargen_utilidadProforma=true;
	public Boolean activarmargen_utilidadProforma=true;

	public Border resaltarivaProforma=null;
	public Boolean mostrarivaProforma=true;
	public Boolean activarivaProforma=true;

	public Border resaltarfinanciamientoProforma=null;
	public Boolean mostrarfinanciamientoProforma=true;
	public Boolean activarfinanciamientoProforma=true;

	public Border resaltartotalProforma=null;
	public Boolean mostrartotalProforma=true;
	public Boolean activartotalProforma=true;

	public Border resaltarotros_valoresProforma=null;
	public Boolean mostrarotros_valoresProforma=true;
	public Boolean activarotros_valoresProforma=true;

	public Border resaltaranticipoProforma=null;
	public Boolean mostraranticipoProforma=true;
	public Boolean activaranticipoProforma=true;

	public Border resaltariceProforma=null;
	public Boolean mostrariceProforma=true;
	public Boolean activariceProforma=false;

	public Border resaltarmonto_retencionProforma=null;
	public Boolean mostrarmonto_retencionProforma=true;
	public Boolean activarmonto_retencionProforma=false;

	public Border resaltarfechaProforma=null;
	public Boolean mostrarfechaProforma=true;
	public Boolean activarfechaProforma=false;

	public Border resaltarfecha_servidorProforma=null;
	public Boolean mostrarfecha_servidorProforma=true;
	public Boolean activarfecha_servidorProforma=false;

	public Border resaltarhora_inicioProforma=null;
	public Boolean mostrarhora_inicioProforma=true;
	public Boolean activarhora_inicioProforma=false;

	public Border resaltarhora_finProforma=null;
	public Boolean mostrarhora_finProforma=true;
	public Boolean activarhora_finProforma=false;

	public Border resaltarid_centro_costoProforma=null;
	public Boolean mostrarid_centro_costoProforma=true;
	public Boolean activarid_centro_costoProforma=false;
	public Boolean cargarid_centro_costoProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoProforma=false;//ConEventDepend=true

	public Border resaltarid_tipo_proformaProforma=null;
	public Boolean mostrarid_tipo_proformaProforma=true;
	public Boolean activarid_tipo_proformaProforma=false;
	public Boolean cargarid_tipo_proformaProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_proformaProforma=false;//ConEventDepend=true

	public Border resaltarid_consignatarioProforma=null;
	public Boolean mostrarid_consignatarioProforma=true;
	public Boolean activarid_consignatarioProforma=false;
	public Boolean cargarid_consignatarioProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_consignatarioProforma=false;//ConEventDepend=true

	public Border resaltarid_tipo_cambioProforma=null;
	public Boolean mostrarid_tipo_cambioProforma=true;
	public Boolean activarid_tipo_cambioProforma=false;
	public Boolean cargarid_tipo_cambioProforma=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cambioProforma=false;//ConEventDepend=true

	
	

	public Border setResaltaridProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltaridProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProforma() {
		return this.resaltaridProforma;
	}

	public void setResaltaridProforma(Border borderResaltar) {
		this.resaltaridProforma= borderResaltar;
	}

	public Boolean getMostraridProforma() {
		return this.mostraridProforma;
	}

	public void setMostraridProforma(Boolean mostraridProforma) {
		this.mostraridProforma= mostraridProforma;
	}

	public Boolean getActivaridProforma() {
		return this.activaridProforma;
	}

	public void setActivaridProforma(Boolean activaridProforma) {
		this.activaridProforma= activaridProforma;
	}

	public Border setResaltarid_empresaProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarid_empresaProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProforma() {
		return this.resaltarid_empresaProforma;
	}

	public void setResaltarid_empresaProforma(Border borderResaltar) {
		this.resaltarid_empresaProforma= borderResaltar;
	}

	public Boolean getMostrarid_empresaProforma() {
		return this.mostrarid_empresaProforma;
	}

	public void setMostrarid_empresaProforma(Boolean mostrarid_empresaProforma) {
		this.mostrarid_empresaProforma= mostrarid_empresaProforma;
	}

	public Boolean getActivarid_empresaProforma() {
		return this.activarid_empresaProforma;
	}

	public void setActivarid_empresaProforma(Boolean activarid_empresaProforma) {
		this.activarid_empresaProforma= activarid_empresaProforma;
	}

	public Boolean getCargarid_empresaProforma() {
		return this.cargarid_empresaProforma;
	}

	public void setCargarid_empresaProforma(Boolean cargarid_empresaProforma) {
		this.cargarid_empresaProforma= cargarid_empresaProforma;
	}

	public Border setResaltarid_sucursalProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProforma() {
		return this.resaltarid_sucursalProforma;
	}

	public void setResaltarid_sucursalProforma(Border borderResaltar) {
		this.resaltarid_sucursalProforma= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProforma() {
		return this.mostrarid_sucursalProforma;
	}

	public void setMostrarid_sucursalProforma(Boolean mostrarid_sucursalProforma) {
		this.mostrarid_sucursalProforma= mostrarid_sucursalProforma;
	}

	public Boolean getActivarid_sucursalProforma() {
		return this.activarid_sucursalProforma;
	}

	public void setActivarid_sucursalProforma(Boolean activarid_sucursalProforma) {
		this.activarid_sucursalProforma= activarid_sucursalProforma;
	}

	public Boolean getCargarid_sucursalProforma() {
		return this.cargarid_sucursalProforma;
	}

	public void setCargarid_sucursalProforma(Boolean cargarid_sucursalProforma) {
		this.cargarid_sucursalProforma= cargarid_sucursalProforma;
	}

	public Border setResaltarid_usuarioProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarid_usuarioProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioProforma() {
		return this.resaltarid_usuarioProforma;
	}

	public void setResaltarid_usuarioProforma(Border borderResaltar) {
		this.resaltarid_usuarioProforma= borderResaltar;
	}

	public Boolean getMostrarid_usuarioProforma() {
		return this.mostrarid_usuarioProforma;
	}

	public void setMostrarid_usuarioProforma(Boolean mostrarid_usuarioProforma) {
		this.mostrarid_usuarioProforma= mostrarid_usuarioProforma;
	}

	public Boolean getActivarid_usuarioProforma() {
		return this.activarid_usuarioProforma;
	}

	public void setActivarid_usuarioProforma(Boolean activarid_usuarioProforma) {
		this.activarid_usuarioProforma= activarid_usuarioProforma;
	}

	public Boolean getCargarid_usuarioProforma() {
		return this.cargarid_usuarioProforma;
	}

	public void setCargarid_usuarioProforma(Boolean cargarid_usuarioProforma) {
		this.cargarid_usuarioProforma= cargarid_usuarioProforma;
	}

	public Border setResaltarid_ejercicioProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioProforma() {
		return this.resaltarid_ejercicioProforma;
	}

	public void setResaltarid_ejercicioProforma(Border borderResaltar) {
		this.resaltarid_ejercicioProforma= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioProforma() {
		return this.mostrarid_ejercicioProforma;
	}

	public void setMostrarid_ejercicioProforma(Boolean mostrarid_ejercicioProforma) {
		this.mostrarid_ejercicioProforma= mostrarid_ejercicioProforma;
	}

	public Boolean getActivarid_ejercicioProforma() {
		return this.activarid_ejercicioProforma;
	}

	public void setActivarid_ejercicioProforma(Boolean activarid_ejercicioProforma) {
		this.activarid_ejercicioProforma= activarid_ejercicioProforma;
	}

	public Boolean getCargarid_ejercicioProforma() {
		return this.cargarid_ejercicioProforma;
	}

	public void setCargarid_ejercicioProforma(Boolean cargarid_ejercicioProforma) {
		this.cargarid_ejercicioProforma= cargarid_ejercicioProforma;
	}

	public Border setResaltarid_periodoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarid_periodoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoProforma() {
		return this.resaltarid_periodoProforma;
	}

	public void setResaltarid_periodoProforma(Border borderResaltar) {
		this.resaltarid_periodoProforma= borderResaltar;
	}

	public Boolean getMostrarid_periodoProforma() {
		return this.mostrarid_periodoProforma;
	}

	public void setMostrarid_periodoProforma(Boolean mostrarid_periodoProforma) {
		this.mostrarid_periodoProforma= mostrarid_periodoProforma;
	}

	public Boolean getActivarid_periodoProforma() {
		return this.activarid_periodoProforma;
	}

	public void setActivarid_periodoProforma(Boolean activarid_periodoProforma) {
		this.activarid_periodoProforma= activarid_periodoProforma;
	}

	public Boolean getCargarid_periodoProforma() {
		return this.cargarid_periodoProforma;
	}

	public void setCargarid_periodoProforma(Boolean cargarid_periodoProforma) {
		this.cargarid_periodoProforma= cargarid_periodoProforma;
	}

	public Border setResaltarid_anioProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarid_anioProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioProforma() {
		return this.resaltarid_anioProforma;
	}

	public void setResaltarid_anioProforma(Border borderResaltar) {
		this.resaltarid_anioProforma= borderResaltar;
	}

	public Boolean getMostrarid_anioProforma() {
		return this.mostrarid_anioProforma;
	}

	public void setMostrarid_anioProforma(Boolean mostrarid_anioProforma) {
		this.mostrarid_anioProforma= mostrarid_anioProforma;
	}

	public Boolean getActivarid_anioProforma() {
		return this.activarid_anioProforma;
	}

	public void setActivarid_anioProforma(Boolean activarid_anioProforma) {
		this.activarid_anioProforma= activarid_anioProforma;
	}

	public Boolean getCargarid_anioProforma() {
		return this.cargarid_anioProforma;
	}

	public void setCargarid_anioProforma(Boolean cargarid_anioProforma) {
		this.cargarid_anioProforma= cargarid_anioProforma;
	}

	public Border setResaltarid_mesProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarid_mesProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesProforma() {
		return this.resaltarid_mesProforma;
	}

	public void setResaltarid_mesProforma(Border borderResaltar) {
		this.resaltarid_mesProforma= borderResaltar;
	}

	public Boolean getMostrarid_mesProforma() {
		return this.mostrarid_mesProforma;
	}

	public void setMostrarid_mesProforma(Boolean mostrarid_mesProforma) {
		this.mostrarid_mesProforma= mostrarid_mesProforma;
	}

	public Boolean getActivarid_mesProforma() {
		return this.activarid_mesProforma;
	}

	public void setActivarid_mesProforma(Boolean activarid_mesProforma) {
		this.activarid_mesProforma= activarid_mesProforma;
	}

	public Boolean getCargarid_mesProforma() {
		return this.cargarid_mesProforma;
	}

	public void setCargarid_mesProforma(Boolean cargarid_mesProforma) {
		this.cargarid_mesProforma= cargarid_mesProforma;
	}

	public Border setResaltarnumero_pre_impresoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impresoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impresoProforma() {
		return this.resaltarnumero_pre_impresoProforma;
	}

	public void setResaltarnumero_pre_impresoProforma(Border borderResaltar) {
		this.resaltarnumero_pre_impresoProforma= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impresoProforma() {
		return this.mostrarnumero_pre_impresoProforma;
	}

	public void setMostrarnumero_pre_impresoProforma(Boolean mostrarnumero_pre_impresoProforma) {
		this.mostrarnumero_pre_impresoProforma= mostrarnumero_pre_impresoProforma;
	}

	public Boolean getActivarnumero_pre_impresoProforma() {
		return this.activarnumero_pre_impresoProforma;
	}

	public void setActivarnumero_pre_impresoProforma(Boolean activarnumero_pre_impresoProforma) {
		this.activarnumero_pre_impresoProforma= activarnumero_pre_impresoProforma;
	}

	public Border setResaltarfecha_emisionProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionProforma() {
		return this.resaltarfecha_emisionProforma;
	}

	public void setResaltarfecha_emisionProforma(Border borderResaltar) {
		this.resaltarfecha_emisionProforma= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionProforma() {
		return this.mostrarfecha_emisionProforma;
	}

	public void setMostrarfecha_emisionProforma(Boolean mostrarfecha_emisionProforma) {
		this.mostrarfecha_emisionProforma= mostrarfecha_emisionProforma;
	}

	public Boolean getActivarfecha_emisionProforma() {
		return this.activarfecha_emisionProforma;
	}

	public void setActivarfecha_emisionProforma(Boolean activarfecha_emisionProforma) {
		this.activarfecha_emisionProforma= activarfecha_emisionProforma;
	}

	public Border setResaltardiasProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltardiasProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardiasProforma() {
		return this.resaltardiasProforma;
	}

	public void setResaltardiasProforma(Border borderResaltar) {
		this.resaltardiasProforma= borderResaltar;
	}

	public Boolean getMostrardiasProforma() {
		return this.mostrardiasProforma;
	}

	public void setMostrardiasProforma(Boolean mostrardiasProforma) {
		this.mostrardiasProforma= mostrardiasProforma;
	}

	public Boolean getActivardiasProforma() {
		return this.activardiasProforma;
	}

	public void setActivardiasProforma(Boolean activardiasProforma) {
		this.activardiasProforma= activardiasProforma;
	}

	public Border setResaltarfecha_vencimientoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoProforma() {
		return this.resaltarfecha_vencimientoProforma;
	}

	public void setResaltarfecha_vencimientoProforma(Border borderResaltar) {
		this.resaltarfecha_vencimientoProforma= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoProforma() {
		return this.mostrarfecha_vencimientoProforma;
	}

	public void setMostrarfecha_vencimientoProforma(Boolean mostrarfecha_vencimientoProforma) {
		this.mostrarfecha_vencimientoProforma= mostrarfecha_vencimientoProforma;
	}

	public Boolean getActivarfecha_vencimientoProforma() {
		return this.activarfecha_vencimientoProforma;
	}

	public void setActivarfecha_vencimientoProforma(Boolean activarfecha_vencimientoProforma) {
		this.activarfecha_vencimientoProforma= activarfecha_vencimientoProforma;
	}

	public Border setResaltarid_monedaProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarid_monedaProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaProforma() {
		return this.resaltarid_monedaProforma;
	}

	public void setResaltarid_monedaProforma(Border borderResaltar) {
		this.resaltarid_monedaProforma= borderResaltar;
	}

	public Boolean getMostrarid_monedaProforma() {
		return this.mostrarid_monedaProforma;
	}

	public void setMostrarid_monedaProforma(Boolean mostrarid_monedaProforma) {
		this.mostrarid_monedaProforma= mostrarid_monedaProforma;
	}

	public Boolean getActivarid_monedaProforma() {
		return this.activarid_monedaProforma;
	}

	public void setActivarid_monedaProforma(Boolean activarid_monedaProforma) {
		this.activarid_monedaProforma= activarid_monedaProforma;
	}

	public Boolean getCargarid_monedaProforma() {
		return this.cargarid_monedaProforma;
	}

	public void setCargarid_monedaProforma(Boolean cargarid_monedaProforma) {
		this.cargarid_monedaProforma= cargarid_monedaProforma;
	}

	public Border setResaltarcotizacionProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarcotizacionProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcotizacionProforma() {
		return this.resaltarcotizacionProforma;
	}

	public void setResaltarcotizacionProforma(Border borderResaltar) {
		this.resaltarcotizacionProforma= borderResaltar;
	}

	public Boolean getMostrarcotizacionProforma() {
		return this.mostrarcotizacionProforma;
	}

	public void setMostrarcotizacionProforma(Boolean mostrarcotizacionProforma) {
		this.mostrarcotizacionProforma= mostrarcotizacionProforma;
	}

	public Boolean getActivarcotizacionProforma() {
		return this.activarcotizacionProforma;
	}

	public void setActivarcotizacionProforma(Boolean activarcotizacionProforma) {
		this.activarcotizacionProforma= activarcotizacionProforma;
	}

	public Border setResaltarid_empleadoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarid_empleadoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoProforma() {
		return this.resaltarid_empleadoProforma;
	}

	public void setResaltarid_empleadoProforma(Border borderResaltar) {
		this.resaltarid_empleadoProforma= borderResaltar;
	}

	public Boolean getMostrarid_empleadoProforma() {
		return this.mostrarid_empleadoProforma;
	}

	public void setMostrarid_empleadoProforma(Boolean mostrarid_empleadoProforma) {
		this.mostrarid_empleadoProforma= mostrarid_empleadoProforma;
	}

	public Boolean getActivarid_empleadoProforma() {
		return this.activarid_empleadoProforma;
	}

	public void setActivarid_empleadoProforma(Boolean activarid_empleadoProforma) {
		this.activarid_empleadoProforma= activarid_empleadoProforma;
	}

	public Boolean getCargarid_empleadoProforma() {
		return this.cargarid_empleadoProforma;
	}

	public void setCargarid_empleadoProforma(Boolean cargarid_empleadoProforma) {
		this.cargarid_empleadoProforma= cargarid_empleadoProforma;
	}

	public Border setResaltarid_formatoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarid_formatoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoProforma() {
		return this.resaltarid_formatoProforma;
	}

	public void setResaltarid_formatoProforma(Border borderResaltar) {
		this.resaltarid_formatoProforma= borderResaltar;
	}

	public Boolean getMostrarid_formatoProforma() {
		return this.mostrarid_formatoProforma;
	}

	public void setMostrarid_formatoProforma(Boolean mostrarid_formatoProforma) {
		this.mostrarid_formatoProforma= mostrarid_formatoProforma;
	}

	public Boolean getActivarid_formatoProforma() {
		return this.activarid_formatoProforma;
	}

	public void setActivarid_formatoProforma(Boolean activarid_formatoProforma) {
		this.activarid_formatoProforma= activarid_formatoProforma;
	}

	public Boolean getCargarid_formatoProforma() {
		return this.cargarid_formatoProforma;
	}

	public void setCargarid_formatoProforma(Boolean cargarid_formatoProforma) {
		this.cargarid_formatoProforma= cargarid_formatoProforma;
	}

	public Border setResaltarid_estado_proformaProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarid_estado_proformaProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_proformaProforma() {
		return this.resaltarid_estado_proformaProforma;
	}

	public void setResaltarid_estado_proformaProforma(Border borderResaltar) {
		this.resaltarid_estado_proformaProforma= borderResaltar;
	}

	public Boolean getMostrarid_estado_proformaProforma() {
		return this.mostrarid_estado_proformaProforma;
	}

	public void setMostrarid_estado_proformaProforma(Boolean mostrarid_estado_proformaProforma) {
		this.mostrarid_estado_proformaProforma= mostrarid_estado_proformaProforma;
	}

	public Boolean getActivarid_estado_proformaProforma() {
		return this.activarid_estado_proformaProforma;
	}

	public void setActivarid_estado_proformaProforma(Boolean activarid_estado_proformaProforma) {
		this.activarid_estado_proformaProforma= activarid_estado_proformaProforma;
	}

	public Boolean getCargarid_estado_proformaProforma() {
		return this.cargarid_estado_proformaProforma;
	}

	public void setCargarid_estado_proformaProforma(Boolean cargarid_estado_proformaProforma) {
		this.cargarid_estado_proformaProforma= cargarid_estado_proformaProforma;
	}

	public Border setResaltardireccionProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltardireccionProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionProforma() {
		return this.resaltardireccionProforma;
	}

	public void setResaltardireccionProforma(Border borderResaltar) {
		this.resaltardireccionProforma= borderResaltar;
	}

	public Boolean getMostrardireccionProforma() {
		return this.mostrardireccionProforma;
	}

	public void setMostrardireccionProforma(Boolean mostrardireccionProforma) {
		this.mostrardireccionProforma= mostrardireccionProforma;
	}

	public Boolean getActivardireccionProforma() {
		return this.activardireccionProforma;
	}

	public void setActivardireccionProforma(Boolean activardireccionProforma) {
		this.activardireccionProforma= activardireccionProforma;
	}

	public Border setResaltarid_clienteProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarid_clienteProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteProforma() {
		return this.resaltarid_clienteProforma;
	}

	public void setResaltarid_clienteProforma(Border borderResaltar) {
		this.resaltarid_clienteProforma= borderResaltar;
	}

	public Boolean getMostrarid_clienteProforma() {
		return this.mostrarid_clienteProforma;
	}

	public void setMostrarid_clienteProforma(Boolean mostrarid_clienteProforma) {
		this.mostrarid_clienteProforma= mostrarid_clienteProforma;
	}

	public Boolean getActivarid_clienteProforma() {
		return this.activarid_clienteProforma;
	}

	public void setActivarid_clienteProforma(Boolean activarid_clienteProforma) {
		this.activarid_clienteProforma= activarid_clienteProforma;
	}

	public Boolean getCargarid_clienteProforma() {
		return this.cargarid_clienteProforma;
	}

	public void setCargarid_clienteProforma(Boolean cargarid_clienteProforma) {
		this.cargarid_clienteProforma= cargarid_clienteProforma;
	}

	public Border setResaltarrucProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarrucProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucProforma() {
		return this.resaltarrucProforma;
	}

	public void setResaltarrucProforma(Border borderResaltar) {
		this.resaltarrucProforma= borderResaltar;
	}

	public Boolean getMostrarrucProforma() {
		return this.mostrarrucProforma;
	}

	public void setMostrarrucProforma(Boolean mostrarrucProforma) {
		this.mostrarrucProforma= mostrarrucProforma;
	}

	public Boolean getActivarrucProforma() {
		return this.activarrucProforma;
	}

	public void setActivarrucProforma(Boolean activarrucProforma) {
		this.activarrucProforma= activarrucProforma;
	}

	public Border setResaltares_ofertaProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltares_ofertaProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_ofertaProforma() {
		return this.resaltares_ofertaProforma;
	}

	public void setResaltares_ofertaProforma(Border borderResaltar) {
		this.resaltares_ofertaProforma= borderResaltar;
	}

	public Boolean getMostrares_ofertaProforma() {
		return this.mostrares_ofertaProforma;
	}

	public void setMostrares_ofertaProforma(Boolean mostrares_ofertaProforma) {
		this.mostrares_ofertaProforma= mostrares_ofertaProforma;
	}

	public Boolean getActivares_ofertaProforma() {
		return this.activares_ofertaProforma;
	}

	public void setActivares_ofertaProforma(Boolean activares_ofertaProforma) {
		this.activares_ofertaProforma= activares_ofertaProforma;
	}

	public Border setResaltartelefonoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltartelefonoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoProforma() {
		return this.resaltartelefonoProforma;
	}

	public void setResaltartelefonoProforma(Border borderResaltar) {
		this.resaltartelefonoProforma= borderResaltar;
	}

	public Boolean getMostrartelefonoProforma() {
		return this.mostrartelefonoProforma;
	}

	public void setMostrartelefonoProforma(Boolean mostrartelefonoProforma) {
		this.mostrartelefonoProforma= mostrartelefonoProforma;
	}

	public Boolean getActivartelefonoProforma() {
		return this.activartelefonoProforma;
	}

	public void setActivartelefonoProforma(Boolean activartelefonoProforma) {
		this.activartelefonoProforma= activartelefonoProforma;
	}

	public Border setResaltarid_tipo_precioProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarid_tipo_precioProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_precioProforma() {
		return this.resaltarid_tipo_precioProforma;
	}

	public void setResaltarid_tipo_precioProforma(Border borderResaltar) {
		this.resaltarid_tipo_precioProforma= borderResaltar;
	}

	public Boolean getMostrarid_tipo_precioProforma() {
		return this.mostrarid_tipo_precioProforma;
	}

	public void setMostrarid_tipo_precioProforma(Boolean mostrarid_tipo_precioProforma) {
		this.mostrarid_tipo_precioProforma= mostrarid_tipo_precioProforma;
	}

	public Boolean getActivarid_tipo_precioProforma() {
		return this.activarid_tipo_precioProforma;
	}

	public void setActivarid_tipo_precioProforma(Boolean activarid_tipo_precioProforma) {
		this.activarid_tipo_precioProforma= activarid_tipo_precioProforma;
	}

	public Boolean getCargarid_tipo_precioProforma() {
		return this.cargarid_tipo_precioProforma;
	}

	public void setCargarid_tipo_precioProforma(Boolean cargarid_tipo_precioProforma) {
		this.cargarid_tipo_precioProforma= cargarid_tipo_precioProforma;
	}

	public Border setResaltarid_vendedorProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarid_vendedorProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorProforma() {
		return this.resaltarid_vendedorProforma;
	}

	public void setResaltarid_vendedorProforma(Border borderResaltar) {
		this.resaltarid_vendedorProforma= borderResaltar;
	}

	public Boolean getMostrarid_vendedorProforma() {
		return this.mostrarid_vendedorProforma;
	}

	public void setMostrarid_vendedorProforma(Boolean mostrarid_vendedorProforma) {
		this.mostrarid_vendedorProforma= mostrarid_vendedorProforma;
	}

	public Boolean getActivarid_vendedorProforma() {
		return this.activarid_vendedorProforma;
	}

	public void setActivarid_vendedorProforma(Boolean activarid_vendedorProforma) {
		this.activarid_vendedorProforma= activarid_vendedorProforma;
	}

	public Boolean getCargarid_vendedorProforma() {
		return this.cargarid_vendedorProforma;
	}

	public void setCargarid_vendedorProforma(Boolean cargarid_vendedorProforma) {
		this.cargarid_vendedorProforma= cargarid_vendedorProforma;
	}

	public Border setResaltarid_sub_clienteProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarid_sub_clienteProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sub_clienteProforma() {
		return this.resaltarid_sub_clienteProforma;
	}

	public void setResaltarid_sub_clienteProforma(Border borderResaltar) {
		this.resaltarid_sub_clienteProforma= borderResaltar;
	}

	public Boolean getMostrarid_sub_clienteProforma() {
		return this.mostrarid_sub_clienteProforma;
	}

	public void setMostrarid_sub_clienteProforma(Boolean mostrarid_sub_clienteProforma) {
		this.mostrarid_sub_clienteProforma= mostrarid_sub_clienteProforma;
	}

	public Boolean getActivarid_sub_clienteProforma() {
		return this.activarid_sub_clienteProforma;
	}

	public void setActivarid_sub_clienteProforma(Boolean activarid_sub_clienteProforma) {
		this.activarid_sub_clienteProforma= activarid_sub_clienteProforma;
	}

	public Boolean getCargarid_sub_clienteProforma() {
		return this.cargarid_sub_clienteProforma;
	}

	public void setCargarid_sub_clienteProforma(Boolean cargarid_sub_clienteProforma) {
		this.cargarid_sub_clienteProforma= cargarid_sub_clienteProforma;
	}

	public Border setResaltarid_tipo_via_transporteProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarid_tipo_via_transporteProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_via_transporteProforma() {
		return this.resaltarid_tipo_via_transporteProforma;
	}

	public void setResaltarid_tipo_via_transporteProforma(Border borderResaltar) {
		this.resaltarid_tipo_via_transporteProforma= borderResaltar;
	}

	public Boolean getMostrarid_tipo_via_transporteProforma() {
		return this.mostrarid_tipo_via_transporteProforma;
	}

	public void setMostrarid_tipo_via_transporteProforma(Boolean mostrarid_tipo_via_transporteProforma) {
		this.mostrarid_tipo_via_transporteProforma= mostrarid_tipo_via_transporteProforma;
	}

	public Boolean getActivarid_tipo_via_transporteProforma() {
		return this.activarid_tipo_via_transporteProforma;
	}

	public void setActivarid_tipo_via_transporteProforma(Boolean activarid_tipo_via_transporteProforma) {
		this.activarid_tipo_via_transporteProforma= activarid_tipo_via_transporteProforma;
	}

	public Boolean getCargarid_tipo_via_transporteProforma() {
		return this.cargarid_tipo_via_transporteProforma;
	}

	public void setCargarid_tipo_via_transporteProforma(Boolean cargarid_tipo_via_transporteProforma) {
		this.cargarid_tipo_via_transporteProforma= cargarid_tipo_via_transporteProforma;
	}

	public Border setResaltarid_transporteProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarid_transporteProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transporteProforma() {
		return this.resaltarid_transporteProforma;
	}

	public void setResaltarid_transporteProforma(Border borderResaltar) {
		this.resaltarid_transporteProforma= borderResaltar;
	}

	public Boolean getMostrarid_transporteProforma() {
		return this.mostrarid_transporteProforma;
	}

	public void setMostrarid_transporteProforma(Boolean mostrarid_transporteProforma) {
		this.mostrarid_transporteProforma= mostrarid_transporteProforma;
	}

	public Boolean getActivarid_transporteProforma() {
		return this.activarid_transporteProforma;
	}

	public void setActivarid_transporteProforma(Boolean activarid_transporteProforma) {
		this.activarid_transporteProforma= activarid_transporteProforma;
	}

	public Boolean getCargarid_transporteProforma() {
		return this.cargarid_transporteProforma;
	}

	public void setCargarid_transporteProforma(Boolean cargarid_transporteProforma) {
		this.cargarid_transporteProforma= cargarid_transporteProforma;
	}

	public Border setResaltarid_ruta_transporteProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarid_ruta_transporteProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ruta_transporteProforma() {
		return this.resaltarid_ruta_transporteProforma;
	}

	public void setResaltarid_ruta_transporteProforma(Border borderResaltar) {
		this.resaltarid_ruta_transporteProforma= borderResaltar;
	}

	public Boolean getMostrarid_ruta_transporteProforma() {
		return this.mostrarid_ruta_transporteProforma;
	}

	public void setMostrarid_ruta_transporteProforma(Boolean mostrarid_ruta_transporteProforma) {
		this.mostrarid_ruta_transporteProforma= mostrarid_ruta_transporteProforma;
	}

	public Boolean getActivarid_ruta_transporteProforma() {
		return this.activarid_ruta_transporteProforma;
	}

	public void setActivarid_ruta_transporteProforma(Boolean activarid_ruta_transporteProforma) {
		this.activarid_ruta_transporteProforma= activarid_ruta_transporteProforma;
	}

	public Boolean getCargarid_ruta_transporteProforma() {
		return this.cargarid_ruta_transporteProforma;
	}

	public void setCargarid_ruta_transporteProforma(Boolean cargarid_ruta_transporteProforma) {
		this.cargarid_ruta_transporteProforma= cargarid_ruta_transporteProforma;
	}

	public Border setResaltardescripcionProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltardescripcionProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionProforma() {
		return this.resaltardescripcionProforma;
	}

	public void setResaltardescripcionProforma(Border borderResaltar) {
		this.resaltardescripcionProforma= borderResaltar;
	}

	public Boolean getMostrardescripcionProforma() {
		return this.mostrardescripcionProforma;
	}

	public void setMostrardescripcionProforma(Boolean mostrardescripcionProforma) {
		this.mostrardescripcionProforma= mostrardescripcionProforma;
	}

	public Boolean getActivardescripcionProforma() {
		return this.activardescripcionProforma;
	}

	public void setActivardescripcionProforma(Boolean activardescripcionProforma) {
		this.activardescripcionProforma= activardescripcionProforma;
	}

	public Border setResaltardescuento_porcentajeProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltardescuento_porcentajeProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_porcentajeProforma() {
		return this.resaltardescuento_porcentajeProforma;
	}

	public void setResaltardescuento_porcentajeProforma(Border borderResaltar) {
		this.resaltardescuento_porcentajeProforma= borderResaltar;
	}

	public Boolean getMostrardescuento_porcentajeProforma() {
		return this.mostrardescuento_porcentajeProforma;
	}

	public void setMostrardescuento_porcentajeProforma(Boolean mostrardescuento_porcentajeProforma) {
		this.mostrardescuento_porcentajeProforma= mostrardescuento_porcentajeProforma;
	}

	public Boolean getActivardescuento_porcentajeProforma() {
		return this.activardescuento_porcentajeProforma;
	}

	public void setActivardescuento_porcentajeProforma(Boolean activardescuento_porcentajeProforma) {
		this.activardescuento_porcentajeProforma= activardescuento_porcentajeProforma;
	}

	public Border setResaltarmonto_con_ivaProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarmonto_con_ivaProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_con_ivaProforma() {
		return this.resaltarmonto_con_ivaProforma;
	}

	public void setResaltarmonto_con_ivaProforma(Border borderResaltar) {
		this.resaltarmonto_con_ivaProforma= borderResaltar;
	}

	public Boolean getMostrarmonto_con_ivaProforma() {
		return this.mostrarmonto_con_ivaProforma;
	}

	public void setMostrarmonto_con_ivaProforma(Boolean mostrarmonto_con_ivaProforma) {
		this.mostrarmonto_con_ivaProforma= mostrarmonto_con_ivaProforma;
	}

	public Boolean getActivarmonto_con_ivaProforma() {
		return this.activarmonto_con_ivaProforma;
	}

	public void setActivarmonto_con_ivaProforma(Boolean activarmonto_con_ivaProforma) {
		this.activarmonto_con_ivaProforma= activarmonto_con_ivaProforma;
	}

	public Border setResaltarsumanProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarsumanProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsumanProforma() {
		return this.resaltarsumanProforma;
	}

	public void setResaltarsumanProforma(Border borderResaltar) {
		this.resaltarsumanProforma= borderResaltar;
	}

	public Boolean getMostrarsumanProforma() {
		return this.mostrarsumanProforma;
	}

	public void setMostrarsumanProforma(Boolean mostrarsumanProforma) {
		this.mostrarsumanProforma= mostrarsumanProforma;
	}

	public Boolean getActivarsumanProforma() {
		return this.activarsumanProforma;
	}

	public void setActivarsumanProforma(Boolean activarsumanProforma) {
		this.activarsumanProforma= activarsumanProforma;
	}

	public Border setResaltardescuento_valorProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltardescuento_valorProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_valorProforma() {
		return this.resaltardescuento_valorProforma;
	}

	public void setResaltardescuento_valorProforma(Border borderResaltar) {
		this.resaltardescuento_valorProforma= borderResaltar;
	}

	public Boolean getMostrardescuento_valorProforma() {
		return this.mostrardescuento_valorProforma;
	}

	public void setMostrardescuento_valorProforma(Boolean mostrardescuento_valorProforma) {
		this.mostrardescuento_valorProforma= mostrardescuento_valorProforma;
	}

	public Boolean getActivardescuento_valorProforma() {
		return this.activardescuento_valorProforma;
	}

	public void setActivardescuento_valorProforma(Boolean activardescuento_valorProforma) {
		this.activardescuento_valorProforma= activardescuento_valorProforma;
	}

	public Border setResaltarmonto_sin_ivaProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarmonto_sin_ivaProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_sin_ivaProforma() {
		return this.resaltarmonto_sin_ivaProforma;
	}

	public void setResaltarmonto_sin_ivaProforma(Border borderResaltar) {
		this.resaltarmonto_sin_ivaProforma= borderResaltar;
	}

	public Boolean getMostrarmonto_sin_ivaProforma() {
		return this.mostrarmonto_sin_ivaProforma;
	}

	public void setMostrarmonto_sin_ivaProforma(Boolean mostrarmonto_sin_ivaProforma) {
		this.mostrarmonto_sin_ivaProforma= mostrarmonto_sin_ivaProforma;
	}

	public Boolean getActivarmonto_sin_ivaProforma() {
		return this.activarmonto_sin_ivaProforma;
	}

	public void setActivarmonto_sin_ivaProforma(Boolean activarmonto_sin_ivaProforma) {
		this.activarmonto_sin_ivaProforma= activarmonto_sin_ivaProforma;
	}

	public Border setResaltardescuento_generalProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltardescuento_generalProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_generalProforma() {
		return this.resaltardescuento_generalProforma;
	}

	public void setResaltardescuento_generalProforma(Border borderResaltar) {
		this.resaltardescuento_generalProforma= borderResaltar;
	}

	public Boolean getMostrardescuento_generalProforma() {
		return this.mostrardescuento_generalProforma;
	}

	public void setMostrardescuento_generalProforma(Boolean mostrardescuento_generalProforma) {
		this.mostrardescuento_generalProforma= mostrardescuento_generalProforma;
	}

	public Boolean getActivardescuento_generalProforma() {
		return this.activardescuento_generalProforma;
	}

	public void setActivardescuento_generalProforma(Boolean activardescuento_generalProforma) {
		this.activardescuento_generalProforma= activardescuento_generalProforma;
	}

	public Border setResaltarfleteProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarfleteProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfleteProforma() {
		return this.resaltarfleteProforma;
	}

	public void setResaltarfleteProforma(Border borderResaltar) {
		this.resaltarfleteProforma= borderResaltar;
	}

	public Boolean getMostrarfleteProforma() {
		return this.mostrarfleteProforma;
	}

	public void setMostrarfleteProforma(Boolean mostrarfleteProforma) {
		this.mostrarfleteProforma= mostrarfleteProforma;
	}

	public Boolean getActivarfleteProforma() {
		return this.activarfleteProforma;
	}

	public void setActivarfleteProforma(Boolean activarfleteProforma) {
		this.activarfleteProforma= activarfleteProforma;
	}

	public Border setResaltarultimo_costoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarultimo_costoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarultimo_costoProforma() {
		return this.resaltarultimo_costoProforma;
	}

	public void setResaltarultimo_costoProforma(Border borderResaltar) {
		this.resaltarultimo_costoProforma= borderResaltar;
	}

	public Boolean getMostrarultimo_costoProforma() {
		return this.mostrarultimo_costoProforma;
	}

	public void setMostrarultimo_costoProforma(Boolean mostrarultimo_costoProforma) {
		this.mostrarultimo_costoProforma= mostrarultimo_costoProforma;
	}

	public Boolean getActivarultimo_costoProforma() {
		return this.activarultimo_costoProforma;
	}

	public void setActivarultimo_costoProforma(Boolean activarultimo_costoProforma) {
		this.activarultimo_costoProforma= activarultimo_costoProforma;
	}

	public Border setResaltarsubtotalProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarsubtotalProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsubtotalProforma() {
		return this.resaltarsubtotalProforma;
	}

	public void setResaltarsubtotalProforma(Border borderResaltar) {
		this.resaltarsubtotalProforma= borderResaltar;
	}

	public Boolean getMostrarsubtotalProforma() {
		return this.mostrarsubtotalProforma;
	}

	public void setMostrarsubtotalProforma(Boolean mostrarsubtotalProforma) {
		this.mostrarsubtotalProforma= mostrarsubtotalProforma;
	}

	public Boolean getActivarsubtotalProforma() {
		return this.activarsubtotalProforma;
	}

	public void setActivarsubtotalProforma(Boolean activarsubtotalProforma) {
		this.activarsubtotalProforma= activarsubtotalProforma;
	}

	public Border setResaltarotros_cargosProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarotros_cargosProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotros_cargosProforma() {
		return this.resaltarotros_cargosProforma;
	}

	public void setResaltarotros_cargosProforma(Border borderResaltar) {
		this.resaltarotros_cargosProforma= borderResaltar;
	}

	public Boolean getMostrarotros_cargosProforma() {
		return this.mostrarotros_cargosProforma;
	}

	public void setMostrarotros_cargosProforma(Boolean mostrarotros_cargosProforma) {
		this.mostrarotros_cargosProforma= mostrarotros_cargosProforma;
	}

	public Boolean getActivarotros_cargosProforma() {
		return this.activarotros_cargosProforma;
	}

	public void setActivarotros_cargosProforma(Boolean activarotros_cargosProforma) {
		this.activarotros_cargosProforma= activarotros_cargosProforma;
	}

	public Border setResaltarmargen_utilidadProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarmargen_utilidadProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmargen_utilidadProforma() {
		return this.resaltarmargen_utilidadProforma;
	}

	public void setResaltarmargen_utilidadProforma(Border borderResaltar) {
		this.resaltarmargen_utilidadProforma= borderResaltar;
	}

	public Boolean getMostrarmargen_utilidadProforma() {
		return this.mostrarmargen_utilidadProforma;
	}

	public void setMostrarmargen_utilidadProforma(Boolean mostrarmargen_utilidadProforma) {
		this.mostrarmargen_utilidadProforma= mostrarmargen_utilidadProforma;
	}

	public Boolean getActivarmargen_utilidadProforma() {
		return this.activarmargen_utilidadProforma;
	}

	public void setActivarmargen_utilidadProforma(Boolean activarmargen_utilidadProforma) {
		this.activarmargen_utilidadProforma= activarmargen_utilidadProforma;
	}

	public Border setResaltarivaProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarivaProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaProforma() {
		return this.resaltarivaProforma;
	}

	public void setResaltarivaProforma(Border borderResaltar) {
		this.resaltarivaProforma= borderResaltar;
	}

	public Boolean getMostrarivaProforma() {
		return this.mostrarivaProforma;
	}

	public void setMostrarivaProforma(Boolean mostrarivaProforma) {
		this.mostrarivaProforma= mostrarivaProforma;
	}

	public Boolean getActivarivaProforma() {
		return this.activarivaProforma;
	}

	public void setActivarivaProforma(Boolean activarivaProforma) {
		this.activarivaProforma= activarivaProforma;
	}

	public Border setResaltarfinanciamientoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarfinanciamientoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfinanciamientoProforma() {
		return this.resaltarfinanciamientoProforma;
	}

	public void setResaltarfinanciamientoProforma(Border borderResaltar) {
		this.resaltarfinanciamientoProforma= borderResaltar;
	}

	public Boolean getMostrarfinanciamientoProforma() {
		return this.mostrarfinanciamientoProforma;
	}

	public void setMostrarfinanciamientoProforma(Boolean mostrarfinanciamientoProforma) {
		this.mostrarfinanciamientoProforma= mostrarfinanciamientoProforma;
	}

	public Boolean getActivarfinanciamientoProforma() {
		return this.activarfinanciamientoProforma;
	}

	public void setActivarfinanciamientoProforma(Boolean activarfinanciamientoProforma) {
		this.activarfinanciamientoProforma= activarfinanciamientoProforma;
	}

	public Border setResaltartotalProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltartotalProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalProforma() {
		return this.resaltartotalProforma;
	}

	public void setResaltartotalProforma(Border borderResaltar) {
		this.resaltartotalProforma= borderResaltar;
	}

	public Boolean getMostrartotalProforma() {
		return this.mostrartotalProforma;
	}

	public void setMostrartotalProforma(Boolean mostrartotalProforma) {
		this.mostrartotalProforma= mostrartotalProforma;
	}

	public Boolean getActivartotalProforma() {
		return this.activartotalProforma;
	}

	public void setActivartotalProforma(Boolean activartotalProforma) {
		this.activartotalProforma= activartotalProforma;
	}

	public Border setResaltarotros_valoresProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarotros_valoresProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotros_valoresProforma() {
		return this.resaltarotros_valoresProforma;
	}

	public void setResaltarotros_valoresProforma(Border borderResaltar) {
		this.resaltarotros_valoresProforma= borderResaltar;
	}

	public Boolean getMostrarotros_valoresProforma() {
		return this.mostrarotros_valoresProforma;
	}

	public void setMostrarotros_valoresProforma(Boolean mostrarotros_valoresProforma) {
		this.mostrarotros_valoresProforma= mostrarotros_valoresProforma;
	}

	public Boolean getActivarotros_valoresProforma() {
		return this.activarotros_valoresProforma;
	}

	public void setActivarotros_valoresProforma(Boolean activarotros_valoresProforma) {
		this.activarotros_valoresProforma= activarotros_valoresProforma;
	}

	public Border setResaltaranticipoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltaranticipoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaranticipoProforma() {
		return this.resaltaranticipoProforma;
	}

	public void setResaltaranticipoProforma(Border borderResaltar) {
		this.resaltaranticipoProforma= borderResaltar;
	}

	public Boolean getMostraranticipoProforma() {
		return this.mostraranticipoProforma;
	}

	public void setMostraranticipoProforma(Boolean mostraranticipoProforma) {
		this.mostraranticipoProforma= mostraranticipoProforma;
	}

	public Boolean getActivaranticipoProforma() {
		return this.activaranticipoProforma;
	}

	public void setActivaranticipoProforma(Boolean activaranticipoProforma) {
		this.activaranticipoProforma= activaranticipoProforma;
	}

	public Border setResaltariceProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltariceProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceProforma() {
		return this.resaltariceProforma;
	}

	public void setResaltariceProforma(Border borderResaltar) {
		this.resaltariceProforma= borderResaltar;
	}

	public Boolean getMostrariceProforma() {
		return this.mostrariceProforma;
	}

	public void setMostrariceProforma(Boolean mostrariceProforma) {
		this.mostrariceProforma= mostrariceProforma;
	}

	public Boolean getActivariceProforma() {
		return this.activariceProforma;
	}

	public void setActivariceProforma(Boolean activariceProforma) {
		this.activariceProforma= activariceProforma;
	}

	public Border setResaltarmonto_retencionProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarmonto_retencionProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_retencionProforma() {
		return this.resaltarmonto_retencionProforma;
	}

	public void setResaltarmonto_retencionProforma(Border borderResaltar) {
		this.resaltarmonto_retencionProforma= borderResaltar;
	}

	public Boolean getMostrarmonto_retencionProforma() {
		return this.mostrarmonto_retencionProforma;
	}

	public void setMostrarmonto_retencionProforma(Boolean mostrarmonto_retencionProforma) {
		this.mostrarmonto_retencionProforma= mostrarmonto_retencionProforma;
	}

	public Boolean getActivarmonto_retencionProforma() {
		return this.activarmonto_retencionProforma;
	}

	public void setActivarmonto_retencionProforma(Boolean activarmonto_retencionProforma) {
		this.activarmonto_retencionProforma= activarmonto_retencionProforma;
	}

	public Border setResaltarfechaProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarfechaProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaProforma() {
		return this.resaltarfechaProforma;
	}

	public void setResaltarfechaProforma(Border borderResaltar) {
		this.resaltarfechaProforma= borderResaltar;
	}

	public Boolean getMostrarfechaProforma() {
		return this.mostrarfechaProforma;
	}

	public void setMostrarfechaProforma(Boolean mostrarfechaProforma) {
		this.mostrarfechaProforma= mostrarfechaProforma;
	}

	public Boolean getActivarfechaProforma() {
		return this.activarfechaProforma;
	}

	public void setActivarfechaProforma(Boolean activarfechaProforma) {
		this.activarfechaProforma= activarfechaProforma;
	}

	public Border setResaltarfecha_servidorProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarfecha_servidorProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_servidorProforma() {
		return this.resaltarfecha_servidorProforma;
	}

	public void setResaltarfecha_servidorProforma(Border borderResaltar) {
		this.resaltarfecha_servidorProforma= borderResaltar;
	}

	public Boolean getMostrarfecha_servidorProforma() {
		return this.mostrarfecha_servidorProforma;
	}

	public void setMostrarfecha_servidorProforma(Boolean mostrarfecha_servidorProforma) {
		this.mostrarfecha_servidorProforma= mostrarfecha_servidorProforma;
	}

	public Boolean getActivarfecha_servidorProforma() {
		return this.activarfecha_servidorProforma;
	}

	public void setActivarfecha_servidorProforma(Boolean activarfecha_servidorProforma) {
		this.activarfecha_servidorProforma= activarfecha_servidorProforma;
	}

	public Border setResaltarhora_inicioProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarhora_inicioProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_inicioProforma() {
		return this.resaltarhora_inicioProforma;
	}

	public void setResaltarhora_inicioProforma(Border borderResaltar) {
		this.resaltarhora_inicioProforma= borderResaltar;
	}

	public Boolean getMostrarhora_inicioProforma() {
		return this.mostrarhora_inicioProforma;
	}

	public void setMostrarhora_inicioProforma(Boolean mostrarhora_inicioProforma) {
		this.mostrarhora_inicioProforma= mostrarhora_inicioProforma;
	}

	public Boolean getActivarhora_inicioProforma() {
		return this.activarhora_inicioProforma;
	}

	public void setActivarhora_inicioProforma(Boolean activarhora_inicioProforma) {
		this.activarhora_inicioProforma= activarhora_inicioProforma;
	}

	public Border setResaltarhora_finProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarhora_finProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_finProforma() {
		return this.resaltarhora_finProforma;
	}

	public void setResaltarhora_finProforma(Border borderResaltar) {
		this.resaltarhora_finProforma= borderResaltar;
	}

	public Boolean getMostrarhora_finProforma() {
		return this.mostrarhora_finProforma;
	}

	public void setMostrarhora_finProforma(Boolean mostrarhora_finProforma) {
		this.mostrarhora_finProforma= mostrarhora_finProforma;
	}

	public Boolean getActivarhora_finProforma() {
		return this.activarhora_finProforma;
	}

	public void setActivarhora_finProforma(Boolean activarhora_finProforma) {
		this.activarhora_finProforma= activarhora_finProforma;
	}

	public Border setResaltarid_centro_costoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoProforma() {
		return this.resaltarid_centro_costoProforma;
	}

	public void setResaltarid_centro_costoProforma(Border borderResaltar) {
		this.resaltarid_centro_costoProforma= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoProforma() {
		return this.mostrarid_centro_costoProforma;
	}

	public void setMostrarid_centro_costoProforma(Boolean mostrarid_centro_costoProforma) {
		this.mostrarid_centro_costoProforma= mostrarid_centro_costoProforma;
	}

	public Boolean getActivarid_centro_costoProforma() {
		return this.activarid_centro_costoProforma;
	}

	public void setActivarid_centro_costoProforma(Boolean activarid_centro_costoProforma) {
		this.activarid_centro_costoProforma= activarid_centro_costoProforma;
	}

	public Boolean getCargarid_centro_costoProforma() {
		return this.cargarid_centro_costoProforma;
	}

	public void setCargarid_centro_costoProforma(Boolean cargarid_centro_costoProforma) {
		this.cargarid_centro_costoProforma= cargarid_centro_costoProforma;
	}

	public Border setResaltarid_tipo_proformaProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarid_tipo_proformaProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_proformaProforma() {
		return this.resaltarid_tipo_proformaProforma;
	}

	public void setResaltarid_tipo_proformaProforma(Border borderResaltar) {
		this.resaltarid_tipo_proformaProforma= borderResaltar;
	}

	public Boolean getMostrarid_tipo_proformaProforma() {
		return this.mostrarid_tipo_proformaProforma;
	}

	public void setMostrarid_tipo_proformaProforma(Boolean mostrarid_tipo_proformaProforma) {
		this.mostrarid_tipo_proformaProforma= mostrarid_tipo_proformaProforma;
	}

	public Boolean getActivarid_tipo_proformaProforma() {
		return this.activarid_tipo_proformaProforma;
	}

	public void setActivarid_tipo_proformaProforma(Boolean activarid_tipo_proformaProforma) {
		this.activarid_tipo_proformaProforma= activarid_tipo_proformaProforma;
	}

	public Boolean getCargarid_tipo_proformaProforma() {
		return this.cargarid_tipo_proformaProforma;
	}

	public void setCargarid_tipo_proformaProforma(Boolean cargarid_tipo_proformaProforma) {
		this.cargarid_tipo_proformaProforma= cargarid_tipo_proformaProforma;
	}

	public Border setResaltarid_consignatarioProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarid_consignatarioProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_consignatarioProforma() {
		return this.resaltarid_consignatarioProforma;
	}

	public void setResaltarid_consignatarioProforma(Border borderResaltar) {
		this.resaltarid_consignatarioProforma= borderResaltar;
	}

	public Boolean getMostrarid_consignatarioProforma() {
		return this.mostrarid_consignatarioProforma;
	}

	public void setMostrarid_consignatarioProforma(Boolean mostrarid_consignatarioProforma) {
		this.mostrarid_consignatarioProforma= mostrarid_consignatarioProforma;
	}

	public Boolean getActivarid_consignatarioProforma() {
		return this.activarid_consignatarioProforma;
	}

	public void setActivarid_consignatarioProforma(Boolean activarid_consignatarioProforma) {
		this.activarid_consignatarioProforma= activarid_consignatarioProforma;
	}

	public Boolean getCargarid_consignatarioProforma() {
		return this.cargarid_consignatarioProforma;
	}

	public void setCargarid_consignatarioProforma(Boolean cargarid_consignatarioProforma) {
		this.cargarid_consignatarioProforma= cargarid_consignatarioProforma;
	}

	public Border setResaltarid_tipo_cambioProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cambioProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cambioProforma() {
		return this.resaltarid_tipo_cambioProforma;
	}

	public void setResaltarid_tipo_cambioProforma(Border borderResaltar) {
		this.resaltarid_tipo_cambioProforma= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cambioProforma() {
		return this.mostrarid_tipo_cambioProforma;
	}

	public void setMostrarid_tipo_cambioProforma(Boolean mostrarid_tipo_cambioProforma) {
		this.mostrarid_tipo_cambioProforma= mostrarid_tipo_cambioProforma;
	}

	public Boolean getActivarid_tipo_cambioProforma() {
		return this.activarid_tipo_cambioProforma;
	}

	public void setActivarid_tipo_cambioProforma(Boolean activarid_tipo_cambioProforma) {
		this.activarid_tipo_cambioProforma= activarid_tipo_cambioProforma;
	}

	public Boolean getCargarid_tipo_cambioProforma() {
		return this.cargarid_tipo_cambioProforma;
	}

	public void setCargarid_tipo_cambioProforma(Boolean cargarid_tipo_cambioProforma) {
		this.cargarid_tipo_cambioProforma= cargarid_tipo_cambioProforma;
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
		
		
		this.setMostraridProforma(esInicial);
		this.setMostrarid_empresaProforma(esInicial);
		this.setMostrarid_sucursalProforma(esInicial);
		this.setMostrarid_usuarioProforma(esInicial);
		this.setMostrarid_ejercicioProforma(esInicial);
		this.setMostrarid_periodoProforma(esInicial);
		this.setMostrarid_anioProforma(esInicial);
		this.setMostrarid_mesProforma(esInicial);
		this.setMostrarnumero_pre_impresoProforma(esInicial);
		this.setMostrarfecha_emisionProforma(esInicial);
		this.setMostrardiasProforma(esInicial);
		this.setMostrarfecha_vencimientoProforma(esInicial);
		this.setMostrarid_monedaProforma(esInicial);
		this.setMostrarcotizacionProforma(esInicial);
		this.setMostrarid_empleadoProforma(esInicial);
		this.setMostrarid_formatoProforma(esInicial);
		this.setMostrarid_estado_proformaProforma(esInicial);
		this.setMostrardireccionProforma(esInicial);
		this.setMostrarid_clienteProforma(esInicial);
		this.setMostrarrucProforma(esInicial);
		this.setMostrares_ofertaProforma(esInicial);
		this.setMostrartelefonoProforma(esInicial);
		this.setMostrarid_tipo_precioProforma(esInicial);
		this.setMostrarid_vendedorProforma(esInicial);
		this.setMostrarid_sub_clienteProforma(esInicial);
		this.setMostrarid_tipo_via_transporteProforma(esInicial);
		this.setMostrarid_transporteProforma(esInicial);
		this.setMostrarid_ruta_transporteProforma(esInicial);
		this.setMostrardescripcionProforma(esInicial);
		this.setMostrardescuento_porcentajeProforma(esInicial);
		this.setMostrarmonto_con_ivaProforma(esInicial);
		this.setMostrarsumanProforma(esInicial);
		this.setMostrardescuento_valorProforma(esInicial);
		this.setMostrarmonto_sin_ivaProforma(esInicial);
		this.setMostrardescuento_generalProforma(esInicial);
		this.setMostrarfleteProforma(esInicial);
		this.setMostrarultimo_costoProforma(esInicial);
		this.setMostrarsubtotalProforma(esInicial);
		this.setMostrarotros_cargosProforma(esInicial);
		this.setMostrarmargen_utilidadProforma(esInicial);
		this.setMostrarivaProforma(esInicial);
		this.setMostrarfinanciamientoProforma(esInicial);
		this.setMostrartotalProforma(esInicial);
		this.setMostrarotros_valoresProforma(esInicial);
		this.setMostraranticipoProforma(esInicial);
		this.setMostrariceProforma(esInicial);
		this.setMostrarmonto_retencionProforma(esInicial);
		this.setMostrarfechaProforma(esInicial);
		this.setMostrarfecha_servidorProforma(esInicial);
		this.setMostrarhora_inicioProforma(esInicial);
		this.setMostrarhora_finProforma(esInicial);
		this.setMostrarid_centro_costoProforma(esInicial);
		this.setMostrarid_tipo_proformaProforma(esInicial);
		this.setMostrarid_consignatarioProforma(esInicial);
		this.setMostrarid_tipo_cambioProforma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProformaConstantesFunciones.ID)) {
				this.setMostraridProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDMES)) {
				this.setMostrarid_mesProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setMostrarnumero_pre_impresoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.DIAS)) {
				this.setMostrardiasProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.COTIZACION)) {
				this.setMostrarcotizacionProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDESTADOPROFORMA)) {
				this.setMostrarid_estado_proformaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.RUC)) {
				this.setMostrarrucProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.ESOFERTA)) {
				this.setMostrares_ofertaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDTIPOPRECIO)) {
				this.setMostrarid_tipo_precioProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDSUBCLIENTE)) {
				this.setMostrarid_sub_clienteProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDTIPOVIATRANSPORTE)) {
				this.setMostrarid_tipo_via_transporteProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDTRANSPORTE)) {
				this.setMostrarid_transporteProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDRUTATRANSPORTE)) {
				this.setMostrarid_ruta_transporteProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setMostrardescuento_porcentajeProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.MONTOCONIVA)) {
				this.setMostrarmonto_con_ivaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.SUMAN)) {
				this.setMostrarsumanProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.DESCUENTOVALOR)) {
				this.setMostrardescuento_valorProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.MONTOSINIVA)) {
				this.setMostrarmonto_sin_ivaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.DESCUENTOGENERAL)) {
				this.setMostrardescuento_generalProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.FLETE)) {
				this.setMostrarfleteProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.ULTIMOCOSTO)) {
				this.setMostrarultimo_costoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsubtotalProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.OTROSCARGOS)) {
				this.setMostrarotros_cargosProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.MARGENUTILIDAD)) {
				this.setMostrarmargen_utilidadProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IVA)) {
				this.setMostrarivaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.FINANCIAMIENTO)) {
				this.setMostrarfinanciamientoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.TOTAL)) {
				this.setMostrartotalProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.OTROSVALORES)) {
				this.setMostrarotros_valoresProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.ANTICIPO)) {
				this.setMostraranticipoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.ICE)) {
				this.setMostrariceProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.MONTORETENCION)) {
				this.setMostrarmonto_retencionProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.FECHA)) {
				this.setMostrarfechaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.FECHASERVIDOR)) {
				this.setMostrarfecha_servidorProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.HORAINICIO)) {
				this.setMostrarhora_inicioProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.HORAFIN)) {
				this.setMostrarhora_finProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDTIPOPROFORMA)) {
				this.setMostrarid_tipo_proformaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDCONSIGNATARIO)) {
				this.setMostrarid_consignatarioProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDTIPOCAMBIO)) {
				this.setMostrarid_tipo_cambioProforma(esAsigna);
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
		
		
		this.setActivaridProforma(esInicial);
		this.setActivarid_empresaProforma(esInicial);
		this.setActivarid_sucursalProforma(esInicial);
		this.setActivarid_usuarioProforma(esInicial);
		this.setActivarid_ejercicioProforma(esInicial);
		this.setActivarid_periodoProforma(esInicial);
		this.setActivarid_anioProforma(esInicial);
		this.setActivarid_mesProforma(esInicial);
		this.setActivarnumero_pre_impresoProforma(esInicial);
		this.setActivarfecha_emisionProforma(esInicial);
		this.setActivardiasProforma(esInicial);
		this.setActivarfecha_vencimientoProforma(esInicial);
		this.setActivarid_monedaProforma(esInicial);
		this.setActivarcotizacionProforma(esInicial);
		this.setActivarid_empleadoProforma(esInicial);
		this.setActivarid_formatoProforma(esInicial);
		this.setActivarid_estado_proformaProforma(esInicial);
		this.setActivardireccionProforma(esInicial);
		this.setActivarid_clienteProforma(esInicial);
		this.setActivarrucProforma(esInicial);
		this.setActivares_ofertaProforma(esInicial);
		this.setActivartelefonoProforma(esInicial);
		this.setActivarid_tipo_precioProforma(esInicial);
		this.setActivarid_vendedorProforma(esInicial);
		this.setActivarid_sub_clienteProforma(esInicial);
		this.setActivarid_tipo_via_transporteProforma(esInicial);
		this.setActivarid_transporteProforma(esInicial);
		this.setActivarid_ruta_transporteProforma(esInicial);
		this.setActivardescripcionProforma(esInicial);
		this.setActivardescuento_porcentajeProforma(esInicial);
		this.setActivarmonto_con_ivaProforma(esInicial);
		this.setActivarsumanProforma(esInicial);
		this.setActivardescuento_valorProforma(esInicial);
		this.setActivarmonto_sin_ivaProforma(esInicial);
		this.setActivardescuento_generalProforma(esInicial);
		this.setActivarfleteProforma(esInicial);
		this.setActivarultimo_costoProforma(esInicial);
		this.setActivarsubtotalProforma(esInicial);
		this.setActivarotros_cargosProforma(esInicial);
		this.setActivarmargen_utilidadProforma(esInicial);
		this.setActivarivaProforma(esInicial);
		this.setActivarfinanciamientoProforma(esInicial);
		this.setActivartotalProforma(esInicial);
		this.setActivarotros_valoresProforma(esInicial);
		this.setActivaranticipoProforma(esInicial);
		this.setActivariceProforma(esInicial);
		this.setActivarmonto_retencionProforma(esInicial);
		this.setActivarfechaProforma(esInicial);
		this.setActivarfecha_servidorProforma(esInicial);
		this.setActivarhora_inicioProforma(esInicial);
		this.setActivarhora_finProforma(esInicial);
		this.setActivarid_centro_costoProforma(esInicial);
		this.setActivarid_tipo_proformaProforma(esInicial);
		this.setActivarid_consignatarioProforma(esInicial);
		this.setActivarid_tipo_cambioProforma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProformaConstantesFunciones.ID)) {
				this.setActivaridProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDANIO)) {
				this.setActivarid_anioProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDMES)) {
				this.setActivarid_mesProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setActivarnumero_pre_impresoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.DIAS)) {
				this.setActivardiasProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.COTIZACION)) {
				this.setActivarcotizacionProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDESTADOPROFORMA)) {
				this.setActivarid_estado_proformaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.DIRECCION)) {
				this.setActivardireccionProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.RUC)) {
				this.setActivarrucProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.ESOFERTA)) {
				this.setActivares_ofertaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDTIPOPRECIO)) {
				this.setActivarid_tipo_precioProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDSUBCLIENTE)) {
				this.setActivarid_sub_clienteProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDTIPOVIATRANSPORTE)) {
				this.setActivarid_tipo_via_transporteProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDTRANSPORTE)) {
				this.setActivarid_transporteProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDRUTATRANSPORTE)) {
				this.setActivarid_ruta_transporteProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setActivardescuento_porcentajeProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.MONTOCONIVA)) {
				this.setActivarmonto_con_ivaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.SUMAN)) {
				this.setActivarsumanProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.DESCUENTOVALOR)) {
				this.setActivardescuento_valorProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.MONTOSINIVA)) {
				this.setActivarmonto_sin_ivaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.DESCUENTOGENERAL)) {
				this.setActivardescuento_generalProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.FLETE)) {
				this.setActivarfleteProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.ULTIMOCOSTO)) {
				this.setActivarultimo_costoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.SUBTOTAL)) {
				this.setActivarsubtotalProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.OTROSCARGOS)) {
				this.setActivarotros_cargosProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.MARGENUTILIDAD)) {
				this.setActivarmargen_utilidadProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IVA)) {
				this.setActivarivaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.FINANCIAMIENTO)) {
				this.setActivarfinanciamientoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.TOTAL)) {
				this.setActivartotalProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.OTROSVALORES)) {
				this.setActivarotros_valoresProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.ANTICIPO)) {
				this.setActivaranticipoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.ICE)) {
				this.setActivariceProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.MONTORETENCION)) {
				this.setActivarmonto_retencionProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.FECHA)) {
				this.setActivarfechaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.FECHASERVIDOR)) {
				this.setActivarfecha_servidorProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.HORAINICIO)) {
				this.setActivarhora_inicioProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.HORAFIN)) {
				this.setActivarhora_finProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDTIPOPROFORMA)) {
				this.setActivarid_tipo_proformaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDCONSIGNATARIO)) {
				this.setActivarid_consignatarioProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDTIPOCAMBIO)) {
				this.setActivarid_tipo_cambioProforma(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProforma(esInicial);
		this.setResaltarid_empresaProforma(esInicial);
		this.setResaltarid_sucursalProforma(esInicial);
		this.setResaltarid_usuarioProforma(esInicial);
		this.setResaltarid_ejercicioProforma(esInicial);
		this.setResaltarid_periodoProforma(esInicial);
		this.setResaltarid_anioProforma(esInicial);
		this.setResaltarid_mesProforma(esInicial);
		this.setResaltarnumero_pre_impresoProforma(esInicial);
		this.setResaltarfecha_emisionProforma(esInicial);
		this.setResaltardiasProforma(esInicial);
		this.setResaltarfecha_vencimientoProforma(esInicial);
		this.setResaltarid_monedaProforma(esInicial);
		this.setResaltarcotizacionProforma(esInicial);
		this.setResaltarid_empleadoProforma(esInicial);
		this.setResaltarid_formatoProforma(esInicial);
		this.setResaltarid_estado_proformaProforma(esInicial);
		this.setResaltardireccionProforma(esInicial);
		this.setResaltarid_clienteProforma(esInicial);
		this.setResaltarrucProforma(esInicial);
		this.setResaltares_ofertaProforma(esInicial);
		this.setResaltartelefonoProforma(esInicial);
		this.setResaltarid_tipo_precioProforma(esInicial);
		this.setResaltarid_vendedorProforma(esInicial);
		this.setResaltarid_sub_clienteProforma(esInicial);
		this.setResaltarid_tipo_via_transporteProforma(esInicial);
		this.setResaltarid_transporteProforma(esInicial);
		this.setResaltarid_ruta_transporteProforma(esInicial);
		this.setResaltardescripcionProforma(esInicial);
		this.setResaltardescuento_porcentajeProforma(esInicial);
		this.setResaltarmonto_con_ivaProforma(esInicial);
		this.setResaltarsumanProforma(esInicial);
		this.setResaltardescuento_valorProforma(esInicial);
		this.setResaltarmonto_sin_ivaProforma(esInicial);
		this.setResaltardescuento_generalProforma(esInicial);
		this.setResaltarfleteProforma(esInicial);
		this.setResaltarultimo_costoProforma(esInicial);
		this.setResaltarsubtotalProforma(esInicial);
		this.setResaltarotros_cargosProforma(esInicial);
		this.setResaltarmargen_utilidadProforma(esInicial);
		this.setResaltarivaProforma(esInicial);
		this.setResaltarfinanciamientoProforma(esInicial);
		this.setResaltartotalProforma(esInicial);
		this.setResaltarotros_valoresProforma(esInicial);
		this.setResaltaranticipoProforma(esInicial);
		this.setResaltariceProforma(esInicial);
		this.setResaltarmonto_retencionProforma(esInicial);
		this.setResaltarfechaProforma(esInicial);
		this.setResaltarfecha_servidorProforma(esInicial);
		this.setResaltarhora_inicioProforma(esInicial);
		this.setResaltarhora_finProforma(esInicial);
		this.setResaltarid_centro_costoProforma(esInicial);
		this.setResaltarid_tipo_proformaProforma(esInicial);
		this.setResaltarid_consignatarioProforma(esInicial);
		this.setResaltarid_tipo_cambioProforma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProformaConstantesFunciones.ID)) {
				this.setResaltaridProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDMES)) {
				this.setResaltarid_mesProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setResaltarnumero_pre_impresoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.DIAS)) {
				this.setResaltardiasProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.COTIZACION)) {
				this.setResaltarcotizacionProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDESTADOPROFORMA)) {
				this.setResaltarid_estado_proformaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.RUC)) {
				this.setResaltarrucProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.ESOFERTA)) {
				this.setResaltares_ofertaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDTIPOPRECIO)) {
				this.setResaltarid_tipo_precioProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDSUBCLIENTE)) {
				this.setResaltarid_sub_clienteProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDTIPOVIATRANSPORTE)) {
				this.setResaltarid_tipo_via_transporteProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDTRANSPORTE)) {
				this.setResaltarid_transporteProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDRUTATRANSPORTE)) {
				this.setResaltarid_ruta_transporteProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setResaltardescuento_porcentajeProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.MONTOCONIVA)) {
				this.setResaltarmonto_con_ivaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.SUMAN)) {
				this.setResaltarsumanProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.DESCUENTOVALOR)) {
				this.setResaltardescuento_valorProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.MONTOSINIVA)) {
				this.setResaltarmonto_sin_ivaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.DESCUENTOGENERAL)) {
				this.setResaltardescuento_generalProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.FLETE)) {
				this.setResaltarfleteProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.ULTIMOCOSTO)) {
				this.setResaltarultimo_costoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsubtotalProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.OTROSCARGOS)) {
				this.setResaltarotros_cargosProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.MARGENUTILIDAD)) {
				this.setResaltarmargen_utilidadProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IVA)) {
				this.setResaltarivaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.FINANCIAMIENTO)) {
				this.setResaltarfinanciamientoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.TOTAL)) {
				this.setResaltartotalProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.OTROSVALORES)) {
				this.setResaltarotros_valoresProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.ANTICIPO)) {
				this.setResaltaranticipoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.ICE)) {
				this.setResaltariceProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.MONTORETENCION)) {
				this.setResaltarmonto_retencionProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.FECHA)) {
				this.setResaltarfechaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.FECHASERVIDOR)) {
				this.setResaltarfecha_servidorProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.HORAINICIO)) {
				this.setResaltarhora_inicioProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.HORAFIN)) {
				this.setResaltarhora_finProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDTIPOPROFORMA)) {
				this.setResaltarid_tipo_proformaProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDCONSIGNATARIO)) {
				this.setResaltarid_consignatarioProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProformaConstantesFunciones.IDTIPOCAMBIO)) {
				this.setResaltarid_tipo_cambioProforma(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarTerminoProformaProforma=null;

	public Border getResaltarTerminoProformaProforma() {
		return this.resaltarTerminoProformaProforma;
	}

	public void setResaltarTerminoProformaProforma(Border borderResaltarTerminoProforma) {
		if(borderResaltarTerminoProforma!=null) {
			this.resaltarTerminoProformaProforma= borderResaltarTerminoProforma;
		}
	}

	public Border setResaltarTerminoProformaProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltarTerminoProforma=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltarTerminoProforma);
			
		this.resaltarTerminoProformaProforma= borderResaltarTerminoProforma;

		 return borderResaltarTerminoProforma;
	}



	public Boolean mostrarTerminoProformaProforma=true;

	public Boolean getMostrarTerminoProformaProforma() {
		return this.mostrarTerminoProformaProforma;
	}

	public void setMostrarTerminoProformaProforma(Boolean visibilidadResaltarTerminoProforma) {
		this.mostrarTerminoProformaProforma= visibilidadResaltarTerminoProforma;
	}



	public Boolean activarTerminoProformaProforma=true;

	public Boolean gethabilitarResaltarTerminoProformaProforma() {
		return this.activarTerminoProformaProforma;
	}

	public void setActivarTerminoProformaProforma(Boolean habilitarResaltarTerminoProforma) {
		this.activarTerminoProformaProforma= habilitarResaltarTerminoProforma;
	}


	public Border resaltarDetalleProformaProforma=null;

	public Border getResaltarDetalleProformaProforma() {
		return this.resaltarDetalleProformaProforma;
	}

	public void setResaltarDetalleProformaProforma(Border borderResaltarDetalleProforma) {
		if(borderResaltarDetalleProforma!=null) {
			this.resaltarDetalleProformaProforma= borderResaltarDetalleProforma;
		}
	}

	public Border setResaltarDetalleProformaProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleProforma=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//proformaBeanSwingJInternalFrame.jTtoolBarProforma.setBorder(borderResaltarDetalleProforma);
			
		this.resaltarDetalleProformaProforma= borderResaltarDetalleProforma;

		 return borderResaltarDetalleProforma;
	}



	public Boolean mostrarDetalleProformaProforma=true;

	public Boolean getMostrarDetalleProformaProforma() {
		return this.mostrarDetalleProformaProforma;
	}

	public void setMostrarDetalleProformaProforma(Boolean visibilidadResaltarDetalleProforma) {
		this.mostrarDetalleProformaProforma= visibilidadResaltarDetalleProforma;
	}



	public Boolean activarDetalleProformaProforma=true;

	public Boolean gethabilitarResaltarDetalleProformaProforma() {
		return this.activarDetalleProformaProforma;
	}

	public void setActivarDetalleProformaProforma(Boolean habilitarResaltarDetalleProforma) {
		this.activarDetalleProformaProforma= habilitarResaltarDetalleProforma;
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

		this.setMostrarTerminoProformaProforma(esInicial);
		this.setMostrarDetalleProformaProforma(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TerminoProforma.class)) {
				this.setMostrarTerminoProformaProforma(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleProforma.class)) {
				this.setMostrarDetalleProformaProforma(esAsigna);
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

		this.setActivarTerminoProformaProforma(esInicial);
		this.setActivarDetalleProformaProforma(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TerminoProforma.class)) {
				this.setActivarTerminoProformaProforma(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleProforma.class)) {
				this.setActivarDetalleProformaProforma(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarTerminoProformaProforma(esInicial);
		this.setResaltarDetalleProformaProforma(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TerminoProforma.class)) {
				this.setResaltarTerminoProformaProforma(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleProforma.class)) {
				this.setResaltarDetalleProformaProforma(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdCentroCostoProforma=true;

	public Boolean getMostrarFK_IdCentroCostoProforma() {
		return this.mostrarFK_IdCentroCostoProforma;
	}

	public void setMostrarFK_IdCentroCostoProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteProforma=true;

	public Boolean getMostrarFK_IdClienteProforma() {
		return this.mostrarFK_IdClienteProforma;
	}

	public void setMostrarFK_IdClienteProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdConsignatarioProforma=true;

	public Boolean getMostrarFK_IdConsignatarioProforma() {
		return this.mostrarFK_IdConsignatarioProforma;
	}

	public void setMostrarFK_IdConsignatarioProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdConsignatarioProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioProforma=true;

	public Boolean getMostrarFK_IdEjercicioProforma() {
		return this.mostrarFK_IdEjercicioProforma;
	}

	public void setMostrarFK_IdEjercicioProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoProforma=true;

	public Boolean getMostrarFK_IdEmpleadoProforma() {
		return this.mostrarFK_IdEmpleadoProforma;
	}

	public void setMostrarFK_IdEmpleadoProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaProforma=true;

	public Boolean getMostrarFK_IdEmpresaProforma() {
		return this.mostrarFK_IdEmpresaProforma;
	}

	public void setMostrarFK_IdEmpresaProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoProformaProforma=true;

	public Boolean getMostrarFK_IdEstadoProformaProforma() {
		return this.mostrarFK_IdEstadoProformaProforma;
	}

	public void setMostrarFK_IdEstadoProformaProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoProformaProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoProforma=true;

	public Boolean getMostrarFK_IdFormatoProforma() {
		return this.mostrarFK_IdFormatoProforma;
	}

	public void setMostrarFK_IdFormatoProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMonedaProforma=true;

	public Boolean getMostrarFK_IdMonedaProforma() {
		return this.mostrarFK_IdMonedaProforma;
	}

	public void setMostrarFK_IdMonedaProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMonedaProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoProforma=true;

	public Boolean getMostrarFK_IdPeriodoProforma() {
		return this.mostrarFK_IdPeriodoProforma;
	}

	public void setMostrarFK_IdPeriodoProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdRutaTransporteProforma=true;

	public Boolean getMostrarFK_IdRutaTransporteProforma() {
		return this.mostrarFK_IdRutaTransporteProforma;
	}

	public void setMostrarFK_IdRutaTransporteProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdRutaTransporteProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSubClienteProforma=true;

	public Boolean getMostrarFK_IdSubClienteProforma() {
		return this.mostrarFK_IdSubClienteProforma;
	}

	public void setMostrarFK_IdSubClienteProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSubClienteProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalProforma=true;

	public Boolean getMostrarFK_IdSucursalProforma() {
		return this.mostrarFK_IdSucursalProforma;
	}

	public void setMostrarFK_IdSucursalProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCambioProforma=true;

	public Boolean getMostrarFK_IdTipoCambioProforma() {
		return this.mostrarFK_IdTipoCambioProforma;
	}

	public void setMostrarFK_IdTipoCambioProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCambioProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPrecioProforma=true;

	public Boolean getMostrarFK_IdTipoPrecioProforma() {
		return this.mostrarFK_IdTipoPrecioProforma;
	}

	public void setMostrarFK_IdTipoPrecioProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPrecioProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProformaProforma=true;

	public Boolean getMostrarFK_IdTipoProformaProforma() {
		return this.mostrarFK_IdTipoProformaProforma;
	}

	public void setMostrarFK_IdTipoProformaProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProformaProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoViaTransporteProforma=true;

	public Boolean getMostrarFK_IdTipoViaTransporteProforma() {
		return this.mostrarFK_IdTipoViaTransporteProforma;
	}

	public void setMostrarFK_IdTipoViaTransporteProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoViaTransporteProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransporteProforma=true;

	public Boolean getMostrarFK_IdTransporteProforma() {
		return this.mostrarFK_IdTransporteProforma;
	}

	public void setMostrarFK_IdTransporteProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransporteProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioProforma=true;

	public Boolean getMostrarFK_IdUsuarioProforma() {
		return this.mostrarFK_IdUsuarioProforma;
	}

	public void setMostrarFK_IdUsuarioProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdVendedorProforma=true;

	public Boolean getMostrarFK_IdVendedorProforma() {
		return this.mostrarFK_IdVendedorProforma;
	}

	public void setMostrarFK_IdVendedorProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdVendedorProforma= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCentroCostoProforma=true;

	public Boolean getActivarFK_IdCentroCostoProforma() {
		return this.activarFK_IdCentroCostoProforma;
	}

	public void setActivarFK_IdCentroCostoProforma(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteProforma=true;

	public Boolean getActivarFK_IdClienteProforma() {
		return this.activarFK_IdClienteProforma;
	}

	public void setActivarFK_IdClienteProforma(Boolean habilitarResaltar) {
		this.activarFK_IdClienteProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdConsignatarioProforma=true;

	public Boolean getActivarFK_IdConsignatarioProforma() {
		return this.activarFK_IdConsignatarioProforma;
	}

	public void setActivarFK_IdConsignatarioProforma(Boolean habilitarResaltar) {
		this.activarFK_IdConsignatarioProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioProforma=true;

	public Boolean getActivarFK_IdEjercicioProforma() {
		return this.activarFK_IdEjercicioProforma;
	}

	public void setActivarFK_IdEjercicioProforma(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoProforma=true;

	public Boolean getActivarFK_IdEmpleadoProforma() {
		return this.activarFK_IdEmpleadoProforma;
	}

	public void setActivarFK_IdEmpleadoProforma(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaProforma=true;

	public Boolean getActivarFK_IdEmpresaProforma() {
		return this.activarFK_IdEmpresaProforma;
	}

	public void setActivarFK_IdEmpresaProforma(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoProformaProforma=true;

	public Boolean getActivarFK_IdEstadoProformaProforma() {
		return this.activarFK_IdEstadoProformaProforma;
	}

	public void setActivarFK_IdEstadoProformaProforma(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoProformaProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoProforma=true;

	public Boolean getActivarFK_IdFormatoProforma() {
		return this.activarFK_IdFormatoProforma;
	}

	public void setActivarFK_IdFormatoProforma(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdMonedaProforma=true;

	public Boolean getActivarFK_IdMonedaProforma() {
		return this.activarFK_IdMonedaProforma;
	}

	public void setActivarFK_IdMonedaProforma(Boolean habilitarResaltar) {
		this.activarFK_IdMonedaProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoProforma=true;

	public Boolean getActivarFK_IdPeriodoProforma() {
		return this.activarFK_IdPeriodoProforma;
	}

	public void setActivarFK_IdPeriodoProforma(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdRutaTransporteProforma=true;

	public Boolean getActivarFK_IdRutaTransporteProforma() {
		return this.activarFK_IdRutaTransporteProforma;
	}

	public void setActivarFK_IdRutaTransporteProforma(Boolean habilitarResaltar) {
		this.activarFK_IdRutaTransporteProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdSubClienteProforma=true;

	public Boolean getActivarFK_IdSubClienteProforma() {
		return this.activarFK_IdSubClienteProforma;
	}

	public void setActivarFK_IdSubClienteProforma(Boolean habilitarResaltar) {
		this.activarFK_IdSubClienteProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalProforma=true;

	public Boolean getActivarFK_IdSucursalProforma() {
		return this.activarFK_IdSucursalProforma;
	}

	public void setActivarFK_IdSucursalProforma(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCambioProforma=true;

	public Boolean getActivarFK_IdTipoCambioProforma() {
		return this.activarFK_IdTipoCambioProforma;
	}

	public void setActivarFK_IdTipoCambioProforma(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCambioProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPrecioProforma=true;

	public Boolean getActivarFK_IdTipoPrecioProforma() {
		return this.activarFK_IdTipoPrecioProforma;
	}

	public void setActivarFK_IdTipoPrecioProforma(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPrecioProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProformaProforma=true;

	public Boolean getActivarFK_IdTipoProformaProforma() {
		return this.activarFK_IdTipoProformaProforma;
	}

	public void setActivarFK_IdTipoProformaProforma(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProformaProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoViaTransporteProforma=true;

	public Boolean getActivarFK_IdTipoViaTransporteProforma() {
		return this.activarFK_IdTipoViaTransporteProforma;
	}

	public void setActivarFK_IdTipoViaTransporteProforma(Boolean habilitarResaltar) {
		this.activarFK_IdTipoViaTransporteProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdTransporteProforma=true;

	public Boolean getActivarFK_IdTransporteProforma() {
		return this.activarFK_IdTransporteProforma;
	}

	public void setActivarFK_IdTransporteProforma(Boolean habilitarResaltar) {
		this.activarFK_IdTransporteProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioProforma=true;

	public Boolean getActivarFK_IdUsuarioProforma() {
		return this.activarFK_IdUsuarioProforma;
	}

	public void setActivarFK_IdUsuarioProforma(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdVendedorProforma=true;

	public Boolean getActivarFK_IdVendedorProforma() {
		return this.activarFK_IdVendedorProforma;
	}

	public void setActivarFK_IdVendedorProforma(Boolean habilitarResaltar) {
		this.activarFK_IdVendedorProforma= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCentroCostoProforma=null;

	public Border getResaltarFK_IdCentroCostoProforma() {
		return this.resaltarFK_IdCentroCostoProforma;
	}

	public void setResaltarFK_IdCentroCostoProforma(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoProforma= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoProforma= borderResaltar;
	}

	public Border resaltarFK_IdClienteProforma=null;

	public Border getResaltarFK_IdClienteProforma() {
		return this.resaltarFK_IdClienteProforma;
	}

	public void setResaltarFK_IdClienteProforma(Border borderResaltar) {
		this.resaltarFK_IdClienteProforma= borderResaltar;
	}

	public void setResaltarFK_IdClienteProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteProforma= borderResaltar;
	}

	public Border resaltarFK_IdConsignatarioProforma=null;

	public Border getResaltarFK_IdConsignatarioProforma() {
		return this.resaltarFK_IdConsignatarioProforma;
	}

	public void setResaltarFK_IdConsignatarioProforma(Border borderResaltar) {
		this.resaltarFK_IdConsignatarioProforma= borderResaltar;
	}

	public void setResaltarFK_IdConsignatarioProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdConsignatarioProforma= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioProforma=null;

	public Border getResaltarFK_IdEjercicioProforma() {
		return this.resaltarFK_IdEjercicioProforma;
	}

	public void setResaltarFK_IdEjercicioProforma(Border borderResaltar) {
		this.resaltarFK_IdEjercicioProforma= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioProforma= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoProforma=null;

	public Border getResaltarFK_IdEmpleadoProforma() {
		return this.resaltarFK_IdEmpleadoProforma;
	}

	public void setResaltarFK_IdEmpleadoProforma(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoProforma= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoProforma= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaProforma=null;

	public Border getResaltarFK_IdEmpresaProforma() {
		return this.resaltarFK_IdEmpresaProforma;
	}

	public void setResaltarFK_IdEmpresaProforma(Border borderResaltar) {
		this.resaltarFK_IdEmpresaProforma= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaProforma= borderResaltar;
	}

	public Border resaltarFK_IdEstadoProformaProforma=null;

	public Border getResaltarFK_IdEstadoProformaProforma() {
		return this.resaltarFK_IdEstadoProformaProforma;
	}

	public void setResaltarFK_IdEstadoProformaProforma(Border borderResaltar) {
		this.resaltarFK_IdEstadoProformaProforma= borderResaltar;
	}

	public void setResaltarFK_IdEstadoProformaProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoProformaProforma= borderResaltar;
	}

	public Border resaltarFK_IdFormatoProforma=null;

	public Border getResaltarFK_IdFormatoProforma() {
		return this.resaltarFK_IdFormatoProforma;
	}

	public void setResaltarFK_IdFormatoProforma(Border borderResaltar) {
		this.resaltarFK_IdFormatoProforma= borderResaltar;
	}

	public void setResaltarFK_IdFormatoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoProforma= borderResaltar;
	}

	public Border resaltarFK_IdMonedaProforma=null;

	public Border getResaltarFK_IdMonedaProforma() {
		return this.resaltarFK_IdMonedaProforma;
	}

	public void setResaltarFK_IdMonedaProforma(Border borderResaltar) {
		this.resaltarFK_IdMonedaProforma= borderResaltar;
	}

	public void setResaltarFK_IdMonedaProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMonedaProforma= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoProforma=null;

	public Border getResaltarFK_IdPeriodoProforma() {
		return this.resaltarFK_IdPeriodoProforma;
	}

	public void setResaltarFK_IdPeriodoProforma(Border borderResaltar) {
		this.resaltarFK_IdPeriodoProforma= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoProforma= borderResaltar;
	}

	public Border resaltarFK_IdRutaTransporteProforma=null;

	public Border getResaltarFK_IdRutaTransporteProforma() {
		return this.resaltarFK_IdRutaTransporteProforma;
	}

	public void setResaltarFK_IdRutaTransporteProforma(Border borderResaltar) {
		this.resaltarFK_IdRutaTransporteProforma= borderResaltar;
	}

	public void setResaltarFK_IdRutaTransporteProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdRutaTransporteProforma= borderResaltar;
	}

	public Border resaltarFK_IdSubClienteProforma=null;

	public Border getResaltarFK_IdSubClienteProforma() {
		return this.resaltarFK_IdSubClienteProforma;
	}

	public void setResaltarFK_IdSubClienteProforma(Border borderResaltar) {
		this.resaltarFK_IdSubClienteProforma= borderResaltar;
	}

	public void setResaltarFK_IdSubClienteProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSubClienteProforma= borderResaltar;
	}

	public Border resaltarFK_IdSucursalProforma=null;

	public Border getResaltarFK_IdSucursalProforma() {
		return this.resaltarFK_IdSucursalProforma;
	}

	public void setResaltarFK_IdSucursalProforma(Border borderResaltar) {
		this.resaltarFK_IdSucursalProforma= borderResaltar;
	}

	public void setResaltarFK_IdSucursalProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalProforma= borderResaltar;
	}

	public Border resaltarFK_IdTipoCambioProforma=null;

	public Border getResaltarFK_IdTipoCambioProforma() {
		return this.resaltarFK_IdTipoCambioProforma;
	}

	public void setResaltarFK_IdTipoCambioProforma(Border borderResaltar) {
		this.resaltarFK_IdTipoCambioProforma= borderResaltar;
	}

	public void setResaltarFK_IdTipoCambioProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCambioProforma= borderResaltar;
	}

	public Border resaltarFK_IdTipoPrecioProforma=null;

	public Border getResaltarFK_IdTipoPrecioProforma() {
		return this.resaltarFK_IdTipoPrecioProforma;
	}

	public void setResaltarFK_IdTipoPrecioProforma(Border borderResaltar) {
		this.resaltarFK_IdTipoPrecioProforma= borderResaltar;
	}

	public void setResaltarFK_IdTipoPrecioProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPrecioProforma= borderResaltar;
	}

	public Border resaltarFK_IdTipoProformaProforma=null;

	public Border getResaltarFK_IdTipoProformaProforma() {
		return this.resaltarFK_IdTipoProformaProforma;
	}

	public void setResaltarFK_IdTipoProformaProforma(Border borderResaltar) {
		this.resaltarFK_IdTipoProformaProforma= borderResaltar;
	}

	public void setResaltarFK_IdTipoProformaProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProformaProforma= borderResaltar;
	}

	public Border resaltarFK_IdTipoViaTransporteProforma=null;

	public Border getResaltarFK_IdTipoViaTransporteProforma() {
		return this.resaltarFK_IdTipoViaTransporteProforma;
	}

	public void setResaltarFK_IdTipoViaTransporteProforma(Border borderResaltar) {
		this.resaltarFK_IdTipoViaTransporteProforma= borderResaltar;
	}

	public void setResaltarFK_IdTipoViaTransporteProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoViaTransporteProforma= borderResaltar;
	}

	public Border resaltarFK_IdTransporteProforma=null;

	public Border getResaltarFK_IdTransporteProforma() {
		return this.resaltarFK_IdTransporteProforma;
	}

	public void setResaltarFK_IdTransporteProforma(Border borderResaltar) {
		this.resaltarFK_IdTransporteProforma= borderResaltar;
	}

	public void setResaltarFK_IdTransporteProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransporteProforma= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioProforma=null;

	public Border getResaltarFK_IdUsuarioProforma() {
		return this.resaltarFK_IdUsuarioProforma;
	}

	public void setResaltarFK_IdUsuarioProforma(Border borderResaltar) {
		this.resaltarFK_IdUsuarioProforma= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioProforma= borderResaltar;
	}

	public Border resaltarFK_IdVendedorProforma=null;

	public Border getResaltarFK_IdVendedorProforma() {
		return this.resaltarFK_IdVendedorProforma;
	}

	public void setResaltarFK_IdVendedorProforma(Border borderResaltar) {
		this.resaltarFK_IdVendedorProforma= borderResaltar;
	}

	public void setResaltarFK_IdVendedorProforma(ParametroGeneralUsuario parametroGeneralUsuario/*ProformaBeanSwingJInternalFrame proformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdVendedorProforma= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}