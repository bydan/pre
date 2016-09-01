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
package com.bydan.erp.sris.util.report;

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


import com.bydan.erp.sris.util.report.SriFacturasProveedoresIva012ConstantesFunciones;
import com.bydan.erp.sris.util.report.SriFacturasProveedoresIva012ParameterReturnGeneral;
//import com.bydan.erp.sris.util.report.SriFacturasProveedoresIva012ParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.sris.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.sris.business.dataaccess.*;
//import com.bydan.erp.sris.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class SriFacturasProveedoresIva012ConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="SriFacturasProveedoresIva012";
	public static final String SPATHOPCION="Sris";	
	public static final String SPATHMODULO="sris/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="SriFacturasProveedoresIva012"+SriFacturasProveedoresIva012ConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SriFacturasProveedoresIva012HomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SriFacturasProveedoresIva012HomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"_"+SriFacturasProveedoresIva012ConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SriFacturasProveedoresIva012HomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"_"+SriFacturasProveedoresIva012ConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"_"+SriFacturasProveedoresIva012ConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SriFacturasProveedoresIva012HomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"_"+SriFacturasProveedoresIva012ConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriFacturasProveedoresIva012ConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SriFacturasProveedoresIva012HomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriFacturasProveedoresIva012ConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriFacturasProveedoresIva012ConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SriFacturasProveedoresIva012HomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriFacturasProveedoresIva012ConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SriFacturasProveedoresIva012ConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SriFacturasProveedoresIva012ConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SriFacturasProveedoresIva012ConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SriFacturasProveedoresIva012ConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Sri Facturas Proveedores Iva012es";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Sri Facturas Proveedores Iva012";
	public static final String SCLASSWEBTITULO_LOWER="Sri Facturas Proveedores Iva012";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="SriFacturasProveedoresIva012";
	public static final String OBJECTNAME="srifacturasproveedoresiva012";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SRIS;	
	public static final String TABLENAME="sri_facturas_proveedores_iva012";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select srifacturasproveedoresiva012 from "+SriFacturasProveedoresIva012ConstantesFunciones.SPERSISTENCENAME+" srifacturasproveedoresiva012";
	public static String QUERYSELECTNATIVE="select "+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".id,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".version_row,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".id_empresa,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".id_periodo_declara,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".ruc,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".nombre_tipo_comprobante,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".ruc_dato,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".numero_documento,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".fecha_emision,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".fecha_registro_contable,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".numero_serie,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".total_iva,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".total_sin_iva,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".id_tipo_iva,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".id_tipo_retencion_iva,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".transfe_iva_retenido,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".id_tipo_retencion_iva_presta,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".presta_iva_retenido,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".nombre_tipo_retencion_fuente1,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".ret_fuente1_porcentaje,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".ret_fuente1_retenido,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".nombre_tipo_retencion_fuente2,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".ret_fuente2_porcentaje,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".ret_fuente2_retenido,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".nombre_tipo_retencion_iva1,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".ret_iva_bien_porcentaje,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".ret_iva_bien_retenido,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".nombre_tipo_retencion_iva2,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".ret_iva_servicio_porcentaje,"+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME+".ret_iva_servicio_retenido from "+SriFacturasProveedoresIva012ConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME;//+" as "+SriFacturasProveedoresIva012ConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDPERIODODECLARA= "id_periodo_declara";
    public static final String RUC= "ruc";
    public static final String NOMBRETIPOCOMPROBANTE= "nombre_tipo_comprobante";
    public static final String NOMBRECOMPLETOCLIENTE= "nombre_completo_cliente";
    public static final String RUCDATO= "ruc_dato";
    public static final String NUMERODOCUMENTO= "numero_documento";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAREGISTROCONTABLE= "fecha_registro_contable";
    public static final String NUMEROSERIE= "numero_serie";
    public static final String TOTALIVA= "total_iva";
    public static final String TOTALSINIVA= "total_sin_iva";
    public static final String IDTIPOIVA= "id_tipo_iva";
    public static final String IDTIPORETENCIONIVA= "id_tipo_retencion_iva";
    public static final String TRANSFEIVARETENIDO= "transfe_iva_retenido";
    public static final String IDTIPORETENCIONIVAPRESTA= "id_tipo_retencion_iva_presta";
    public static final String PRESTAIVARETENIDO= "presta_iva_retenido";
    public static final String NOMBRETIPORETENCIONFUENTE1= "nombre_tipo_retencion_fuente1";
    public static final String RETFUENTE1PORCENTAJE= "ret_fuente1_porcentaje";
    public static final String RETFUENTE1RETENIDO= "ret_fuente1_retenido";
    public static final String NOMBRETIPORETENCIONFUENTE2= "nombre_tipo_retencion_fuente2";
    public static final String RETFUENTE2PORCENTAJE= "ret_fuente2_porcentaje";
    public static final String RETFUENTE2RETENIDO= "ret_fuente2_retenido";
    public static final String NOMBRETIPORETENCIONIVA1= "nombre_tipo_retencion_iva1";
    public static final String RETIVABIENPORCENTAJE= "ret_iva_bien_porcentaje";
    public static final String RETIVABIENRETENIDO= "ret_iva_bien_retenido";
    public static final String NOMBRETIPORETENCIONIVA2= "nombre_tipo_retencion_iva2";
    public static final String RETIVASERVICIOPORCENTAJE= "ret_iva_servicio_porcentaje";
    public static final String RETIVASERVICIORETENIDO= "ret_iva_servicio_retenido";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDPERIODODECLARA= "Periodo Declara";
		public static final String LABEL_IDPERIODODECLARA_LOWER= "Periodo Declara";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_NOMBRETIPOCOMPROBANTE= "Nombre Tipo Comprobante";
		public static final String LABEL_NOMBRETIPOCOMPROBANTE_LOWER= "Nombre Tipo Comprobante";
    	public static final String LABEL_NOMBRECOMPLETOCLIENTE= "Nombre Completo Cliente";
		public static final String LABEL_NOMBRECOMPLETOCLIENTE_LOWER= "Nombre Completo Cliente";
    	public static final String LABEL_RUCDATO= "Ruc Dato";
		public static final String LABEL_RUCDATO_LOWER= "Ruc Dato";
    	public static final String LABEL_NUMERODOCUMENTO= "Numero Documento";
		public static final String LABEL_NUMERODOCUMENTO_LOWER= "Numero Documento";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAREGISTROCONTABLE= "Fecha Registro Contable";
		public static final String LABEL_FECHAREGISTROCONTABLE_LOWER= "Fecha Registro Contable";
    	public static final String LABEL_NUMEROSERIE= "Numero Serie";
		public static final String LABEL_NUMEROSERIE_LOWER= "Numero Serie";
    	public static final String LABEL_TOTALIVA= "Total Iva";
		public static final String LABEL_TOTALIVA_LOWER= "Total Iva";
    	public static final String LABEL_TOTALSINIVA= "Total Sin Iva";
		public static final String LABEL_TOTALSINIVA_LOWER= "Total Sin Iva";
    	public static final String LABEL_IDTIPOIVA= "Tipo Iva";
		public static final String LABEL_IDTIPOIVA_LOWER= "Tipo Iva";
    	public static final String LABEL_IDTIPORETENCIONIVA= "Tipo Retencion Iva";
		public static final String LABEL_IDTIPORETENCIONIVA_LOWER= "Tipo Retencion Iva";
    	public static final String LABEL_TRANSFEIVARETENIDO= "Transfe Iva Reteno";
		public static final String LABEL_TRANSFEIVARETENIDO_LOWER= "Transfe Iva Retenido";
    	public static final String LABEL_IDTIPORETENCIONIVAPRESTA= "Tipo Retencion Iva Presta";
		public static final String LABEL_IDTIPORETENCIONIVAPRESTA_LOWER= "Tipo Retencion Iva Presta";
    	public static final String LABEL_PRESTAIVARETENIDO= "Presta Iva Reteno";
		public static final String LABEL_PRESTAIVARETENIDO_LOWER= "Presta Iva Retenido";
    	public static final String LABEL_NOMBRETIPORETENCIONFUENTE1= "Nombre Tipo Retencion Fuente1";
		public static final String LABEL_NOMBRETIPORETENCIONFUENTE1_LOWER= "Nombre Tipo Retencion Fuente1";
    	public static final String LABEL_RETFUENTE1PORCENTAJE= "Ret Fuente1 Porcentaje";
		public static final String LABEL_RETFUENTE1PORCENTAJE_LOWER= "Ret Fuente1 Porcentaje";
    	public static final String LABEL_RETFUENTE1RETENIDO= "Ret Fuente1 Reteno";
		public static final String LABEL_RETFUENTE1RETENIDO_LOWER= "Ret Fuente1 Retenido";
    	public static final String LABEL_NOMBRETIPORETENCIONFUENTE2= "Nombre Tipo Retencion Fuente2";
		public static final String LABEL_NOMBRETIPORETENCIONFUENTE2_LOWER= "Nombre Tipo Retencion Fuente2";
    	public static final String LABEL_RETFUENTE2PORCENTAJE= "Ret Fuente2 Porcentaje";
		public static final String LABEL_RETFUENTE2PORCENTAJE_LOWER= "Ret Fuente2 Porcentaje";
    	public static final String LABEL_RETFUENTE2RETENIDO= "Ret Fuente2 Reteno";
		public static final String LABEL_RETFUENTE2RETENIDO_LOWER= "Ret Fuente2 Retenido";
    	public static final String LABEL_NOMBRETIPORETENCIONIVA1= "Nombre Tipo Retencion Iva1";
		public static final String LABEL_NOMBRETIPORETENCIONIVA1_LOWER= "Nombre Tipo Retencion Iva1";
    	public static final String LABEL_RETIVABIENPORCENTAJE= "Ret Iva Bien Porcentaje";
		public static final String LABEL_RETIVABIENPORCENTAJE_LOWER= "Ret Iva Bien Porcentaje";
    	public static final String LABEL_RETIVABIENRETENIDO= "Ret Iva Bien Reteno";
		public static final String LABEL_RETIVABIENRETENIDO_LOWER= "Ret Iva Bien Retenido";
    	public static final String LABEL_NOMBRETIPORETENCIONIVA2= "Nombre Tipo Retencion Iva2";
		public static final String LABEL_NOMBRETIPORETENCIONIVA2_LOWER= "Nombre Tipo Retencion Iva2";
    	public static final String LABEL_RETIVASERVICIOPORCENTAJE= "Ret Iva Servicio Porcentaje";
		public static final String LABEL_RETIVASERVICIOPORCENTAJE_LOWER= "Ret Iva Servicio Porcentaje";
    	public static final String LABEL_RETIVASERVICIORETENIDO= "Ret Iva Servicio Reteno";
		public static final String LABEL_RETIVASERVICIORETENIDO_LOWER= "Ret Iva Servicio Retenido";
	
		
		
		
		
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_TIPO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TIPO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC_DATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC_DATO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_SERIE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SERIE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_TIPO_RETENCION_FUENTE1=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TIPO_RETENCION_FUENTE1=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNOMBRE_TIPO_RETENCION_FUENTE2=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TIPO_RETENCION_FUENTE2=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNOMBRE_TIPO_RETENCION_IVA1=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TIPO_RETENCION_IVA1=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNOMBRE_TIPO_RETENCION_IVA2=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TIPO_RETENCION_IVA2=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getSriFacturasProveedoresIva012LabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.IDEMPRESA)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.IDPERIODODECLARA)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDPERIODODECLARA;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.RUC)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPOCOMPROBANTE)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPOCOMPROBANTE;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.RUCDATO)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RUCDATO;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.NUMERODOCUMENTO)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NUMERODOCUMENTO;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.FECHAEMISION)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.FECHAREGISTROCONTABLE)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_FECHAREGISTROCONTABLE;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.NUMEROSERIE)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NUMEROSERIE;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.TOTALIVA)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_TOTALIVA;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.TOTALSINIVA)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_TOTALSINIVA;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.IDTIPOIVA)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDTIPOIVA;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.IDTIPORETENCIONIVA)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDTIPORETENCIONIVA;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.TRANSFEIVARETENIDO)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_TRANSFEIVARETENIDO;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.IDTIPORETENCIONIVAPRESTA)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDTIPORETENCIONIVAPRESTA;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.PRESTAIVARETENIDO)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_PRESTAIVARETENIDO;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONFUENTE1)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPORETENCIONFUENTE1;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE1PORCENTAJE)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE1PORCENTAJE;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE1RETENIDO)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE1RETENIDO;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONFUENTE2)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPORETENCIONFUENTE2;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE2PORCENTAJE)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE2PORCENTAJE;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE2RETENIDO)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE2RETENIDO;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONIVA1)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPORETENCIONIVA1;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETIVABIENPORCENTAJE)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVABIENPORCENTAJE;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETIVABIENRETENIDO)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVABIENRETENIDO;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONIVA2)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPORETENCIONIVA2;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETIVASERVICIOPORCENTAJE)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVASERVICIOPORCENTAJE;}
		if(sNombreColumna.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETIVASERVICIORETENIDO)) {sLabelColumna=SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVASERVICIORETENIDO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getSriFacturasProveedoresIva012Descripcion(SriFacturasProveedoresIva012 srifacturasproveedoresiva012) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(srifacturasproveedoresiva012 !=null/* && srifacturasproveedoresiva012.getId()!=0*/) {
			sDescripcion=srifacturasproveedoresiva012.getruc();//srifacturasproveedoresiva012srifacturasproveedoresiva012.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getSriFacturasProveedoresIva012DescripcionDetallado(SriFacturasProveedoresIva012 srifacturasproveedoresiva012) {
		String sDescripcion="";
			
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.ID+"=";
		sDescripcion+=srifacturasproveedoresiva012.getId().toString()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=srifacturasproveedoresiva012.getVersionRow().toString()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=srifacturasproveedoresiva012.getid_empresa().toString()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.IDPERIODODECLARA+"=";
		sDescripcion+=srifacturasproveedoresiva012.getid_periodo_declara().toString()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.RUC+"=";
		sDescripcion+=srifacturasproveedoresiva012.getruc()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPOCOMPROBANTE+"=";
		sDescripcion+=srifacturasproveedoresiva012.getnombre_tipo_comprobante()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=srifacturasproveedoresiva012.getnombre_completo_cliente()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.RUCDATO+"=";
		sDescripcion+=srifacturasproveedoresiva012.getruc_dato()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.NUMERODOCUMENTO+"=";
		sDescripcion+=srifacturasproveedoresiva012.getnumero_documento()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=srifacturasproveedoresiva012.getfecha_emision().toString()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.FECHAREGISTROCONTABLE+"=";
		sDescripcion+=srifacturasproveedoresiva012.getfecha_registro_contable().toString()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.NUMEROSERIE+"=";
		sDescripcion+=srifacturasproveedoresiva012.getnumero_serie()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.TOTALIVA+"=";
		sDescripcion+=srifacturasproveedoresiva012.gettotal_iva().toString()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.TOTALSINIVA+"=";
		sDescripcion+=srifacturasproveedoresiva012.gettotal_sin_iva().toString()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.IDTIPOIVA+"=";
		sDescripcion+=srifacturasproveedoresiva012.getid_tipo_iva().toString()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.IDTIPORETENCIONIVA+"=";
		sDescripcion+=srifacturasproveedoresiva012.getid_tipo_retencion_iva().toString()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.TRANSFEIVARETENIDO+"=";
		sDescripcion+=srifacturasproveedoresiva012.gettransfe_iva_retenido().toString()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.IDTIPORETENCIONIVAPRESTA+"=";
		sDescripcion+=srifacturasproveedoresiva012.getid_tipo_retencion_iva_presta().toString()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.PRESTAIVARETENIDO+"=";
		sDescripcion+=srifacturasproveedoresiva012.getpresta_iva_retenido().toString()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONFUENTE1+"=";
		sDescripcion+=srifacturasproveedoresiva012.getnombre_tipo_retencion_fuente1()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE1PORCENTAJE+"=";
		sDescripcion+=srifacturasproveedoresiva012.getret_fuente1_porcentaje().toString()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE1RETENIDO+"=";
		sDescripcion+=srifacturasproveedoresiva012.getret_fuente1_retenido().toString()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONFUENTE2+"=";
		sDescripcion+=srifacturasproveedoresiva012.getnombre_tipo_retencion_fuente2()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE2PORCENTAJE+"=";
		sDescripcion+=srifacturasproveedoresiva012.getret_fuente2_porcentaje().toString()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE2RETENIDO+"=";
		sDescripcion+=srifacturasproveedoresiva012.getret_fuente2_retenido().toString()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONIVA1+"=";
		sDescripcion+=srifacturasproveedoresiva012.getnombre_tipo_retencion_iva1()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.RETIVABIENPORCENTAJE+"=";
		sDescripcion+=srifacturasproveedoresiva012.getret_iva_bien_porcentaje().toString()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.RETIVABIENRETENIDO+"=";
		sDescripcion+=srifacturasproveedoresiva012.getret_iva_bien_retenido().toString()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONIVA2+"=";
		sDescripcion+=srifacturasproveedoresiva012.getnombre_tipo_retencion_iva2()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.RETIVASERVICIOPORCENTAJE+"=";
		sDescripcion+=srifacturasproveedoresiva012.getret_iva_servicio_porcentaje().toString()+",";
		sDescripcion+=SriFacturasProveedoresIva012ConstantesFunciones.RETIVASERVICIORETENIDO+"=";
		sDescripcion+=srifacturasproveedoresiva012.getret_iva_servicio_retenido().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setSriFacturasProveedoresIva012Descripcion(SriFacturasProveedoresIva012 srifacturasproveedoresiva012,String sValor) throws Exception {			
		if(srifacturasproveedoresiva012 !=null) {
			srifacturasproveedoresiva012.setruc(sValor);//srifacturasproveedoresiva012srifacturasproveedoresiva012.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getPeriodoDeclaraDescripcion(PeriodoDeclara periododeclara) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periododeclara!=null/*&&periododeclara.getId()>0*/) {
			sDescripcion=PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(periododeclara);
		}

		return sDescripcion;
	}

	public static String getTipoIvaDescripcion(TipoIva tipoiva) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoiva!=null/*&&tipoiva.getId()>0*/) {
			sDescripcion=TipoIvaConstantesFunciones.getTipoIvaDescripcion(tipoiva);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionIvaDescripcion(TipoRetencion tiporetencion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencion!=null/*&&tiporetencion.getId()>0*/) {
			sDescripcion=TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tiporetencion);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionIvaPrestaDescripcion(TipoRetencion tiporetencion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencion!=null/*&&tiporetencion.getId()>0*/) {
			sDescripcion=TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tiporetencion);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaSriFacturasProveedoresIva012")) {
			sNombreIndice="Tipo=  Por Periodo Declara Por Ruc";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPeriodoDeclara")) {
			sNombreIndice="Tipo=  Por Periodo Declara";
		} else if(sNombreIndice.equals("FK_IdTipoIva")) {
			sNombreIndice="Tipo=  Por Tipo Iva";
		} else if(sNombreIndice.equals("FK_IdTipoRetencionIva")) {
			sNombreIndice="Tipo=  Por Tipo Retencion Iva";
		} else if(sNombreIndice.equals("FK_IdTipoRetencionIvaPresta")) {
			sNombreIndice="Tipo=  Por Tipo Retencion Iva Presta";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaSriFacturasProveedoresIva012(Long id_periodo_declara,String ruc) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo_declara!=null) {sDetalleIndice+=" Codigo Unico De Periodo Declara="+id_periodo_declara.toString();}
		if(ruc!=null) {sDetalleIndice+=" Ruc="+ruc;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodoDeclara(Long id_periodo_declara) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo_declara!=null) {sDetalleIndice+=" Codigo Unico De Periodo Declara="+id_periodo_declara.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoIva(Long id_tipo_iva) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_iva!=null) {sDetalleIndice+=" Codigo Unico De Tipo Iva="+id_tipo_iva.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencionIva(Long id_tipo_retencion_iva) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion_iva!=null) {sDetalleIndice+=" Codigo Unico De Tipo Retencion Iva="+id_tipo_retencion_iva.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencionIvaPresta(Long id_tipo_retencion_iva_presta) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion_iva_presta!=null) {sDetalleIndice+=" Codigo Unico De Tipo Retencion Iva Presta="+id_tipo_retencion_iva_presta.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosSriFacturasProveedoresIva012(SriFacturasProveedoresIva012 srifacturasproveedoresiva012,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		srifacturasproveedoresiva012.setnombre_tipo_comprobante(srifacturasproveedoresiva012.getnombre_tipo_comprobante().trim());
		srifacturasproveedoresiva012.setnombre_completo_cliente(srifacturasproveedoresiva012.getnombre_completo_cliente().trim());
		srifacturasproveedoresiva012.setruc_dato(srifacturasproveedoresiva012.getruc_dato().trim());
		srifacturasproveedoresiva012.setnumero_documento(srifacturasproveedoresiva012.getnumero_documento().trim());
		srifacturasproveedoresiva012.setnumero_serie(srifacturasproveedoresiva012.getnumero_serie().trim());
		srifacturasproveedoresiva012.setnombre_tipo_retencion_fuente1(srifacturasproveedoresiva012.getnombre_tipo_retencion_fuente1().trim());
		srifacturasproveedoresiva012.setnombre_tipo_retencion_fuente2(srifacturasproveedoresiva012.getnombre_tipo_retencion_fuente2().trim());
		srifacturasproveedoresiva012.setnombre_tipo_retencion_iva1(srifacturasproveedoresiva012.getnombre_tipo_retencion_iva1().trim());
		srifacturasproveedoresiva012.setnombre_tipo_retencion_iva2(srifacturasproveedoresiva012.getnombre_tipo_retencion_iva2().trim());
	}
	
	public static void quitarEspaciosSriFacturasProveedoresIva012s(List<SriFacturasProveedoresIva012> srifacturasproveedoresiva012s,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SriFacturasProveedoresIva012 srifacturasproveedoresiva012: srifacturasproveedoresiva012s) {
			srifacturasproveedoresiva012.setnombre_tipo_comprobante(srifacturasproveedoresiva012.getnombre_tipo_comprobante().trim());
			srifacturasproveedoresiva012.setnombre_completo_cliente(srifacturasproveedoresiva012.getnombre_completo_cliente().trim());
			srifacturasproveedoresiva012.setruc_dato(srifacturasproveedoresiva012.getruc_dato().trim());
			srifacturasproveedoresiva012.setnumero_documento(srifacturasproveedoresiva012.getnumero_documento().trim());
			srifacturasproveedoresiva012.setnumero_serie(srifacturasproveedoresiva012.getnumero_serie().trim());
			srifacturasproveedoresiva012.setnombre_tipo_retencion_fuente1(srifacturasproveedoresiva012.getnombre_tipo_retencion_fuente1().trim());
			srifacturasproveedoresiva012.setnombre_tipo_retencion_fuente2(srifacturasproveedoresiva012.getnombre_tipo_retencion_fuente2().trim());
			srifacturasproveedoresiva012.setnombre_tipo_retencion_iva1(srifacturasproveedoresiva012.getnombre_tipo_retencion_iva1().trim());
			srifacturasproveedoresiva012.setnombre_tipo_retencion_iva2(srifacturasproveedoresiva012.getnombre_tipo_retencion_iva2().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSriFacturasProveedoresIva012(SriFacturasProveedoresIva012 srifacturasproveedoresiva012,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && srifacturasproveedoresiva012.getConCambioAuxiliar()) {
			srifacturasproveedoresiva012.setIsDeleted(srifacturasproveedoresiva012.getIsDeletedAuxiliar());	
			srifacturasproveedoresiva012.setIsNew(srifacturasproveedoresiva012.getIsNewAuxiliar());	
			srifacturasproveedoresiva012.setIsChanged(srifacturasproveedoresiva012.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			srifacturasproveedoresiva012.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			srifacturasproveedoresiva012.setIsDeletedAuxiliar(false);	
			srifacturasproveedoresiva012.setIsNewAuxiliar(false);	
			srifacturasproveedoresiva012.setIsChangedAuxiliar(false);
			
			srifacturasproveedoresiva012.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSriFacturasProveedoresIva012s(List<SriFacturasProveedoresIva012> srifacturasproveedoresiva012s,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(SriFacturasProveedoresIva012 srifacturasproveedoresiva012 : srifacturasproveedoresiva012s) {
			if(conAsignarBase && srifacturasproveedoresiva012.getConCambioAuxiliar()) {
				srifacturasproveedoresiva012.setIsDeleted(srifacturasproveedoresiva012.getIsDeletedAuxiliar());	
				srifacturasproveedoresiva012.setIsNew(srifacturasproveedoresiva012.getIsNewAuxiliar());	
				srifacturasproveedoresiva012.setIsChanged(srifacturasproveedoresiva012.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				srifacturasproveedoresiva012.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				srifacturasproveedoresiva012.setIsDeletedAuxiliar(false);	
				srifacturasproveedoresiva012.setIsNewAuxiliar(false);	
				srifacturasproveedoresiva012.setIsChangedAuxiliar(false);
				
				srifacturasproveedoresiva012.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSriFacturasProveedoresIva012(SriFacturasProveedoresIva012 srifacturasproveedoresiva012,Boolean conEnteros) throws Exception  {
		srifacturasproveedoresiva012.settotal_iva(0.0);
		srifacturasproveedoresiva012.settotal_sin_iva(0.0);
		srifacturasproveedoresiva012.settransfe_iva_retenido(0.0);
		srifacturasproveedoresiva012.setpresta_iva_retenido(0.0);
		srifacturasproveedoresiva012.setret_fuente1_porcentaje(0.0);
		srifacturasproveedoresiva012.setret_fuente1_retenido(0.0);
		srifacturasproveedoresiva012.setret_fuente2_porcentaje(0.0);
		srifacturasproveedoresiva012.setret_fuente2_retenido(0.0);
		srifacturasproveedoresiva012.setret_iva_bien_porcentaje(0.0);
		srifacturasproveedoresiva012.setret_iva_bien_retenido(0.0);
		srifacturasproveedoresiva012.setret_iva_servicio_porcentaje(0.0);
		srifacturasproveedoresiva012.setret_iva_servicio_retenido(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSriFacturasProveedoresIva012s(List<SriFacturasProveedoresIva012> srifacturasproveedoresiva012s,Boolean conEnteros) throws Exception  {
		
		for(SriFacturasProveedoresIva012 srifacturasproveedoresiva012: srifacturasproveedoresiva012s) {
			srifacturasproveedoresiva012.settotal_iva(0.0);
			srifacturasproveedoresiva012.settotal_sin_iva(0.0);
			srifacturasproveedoresiva012.settransfe_iva_retenido(0.0);
			srifacturasproveedoresiva012.setpresta_iva_retenido(0.0);
			srifacturasproveedoresiva012.setret_fuente1_porcentaje(0.0);
			srifacturasproveedoresiva012.setret_fuente1_retenido(0.0);
			srifacturasproveedoresiva012.setret_fuente2_porcentaje(0.0);
			srifacturasproveedoresiva012.setret_fuente2_retenido(0.0);
			srifacturasproveedoresiva012.setret_iva_bien_porcentaje(0.0);
			srifacturasproveedoresiva012.setret_iva_bien_retenido(0.0);
			srifacturasproveedoresiva012.setret_iva_servicio_porcentaje(0.0);
			srifacturasproveedoresiva012.setret_iva_servicio_retenido(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSriFacturasProveedoresIva012(List<SriFacturasProveedoresIva012> srifacturasproveedoresiva012s,SriFacturasProveedoresIva012 srifacturasproveedoresiva012Aux) throws Exception  {
		SriFacturasProveedoresIva012ConstantesFunciones.InicializarValoresSriFacturasProveedoresIva012(srifacturasproveedoresiva012Aux,true);
		
		for(SriFacturasProveedoresIva012 srifacturasproveedoresiva012: srifacturasproveedoresiva012s) {
			if(srifacturasproveedoresiva012.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			srifacturasproveedoresiva012Aux.settotal_iva(srifacturasproveedoresiva012Aux.gettotal_iva()+srifacturasproveedoresiva012.gettotal_iva());			
			srifacturasproveedoresiva012Aux.settotal_sin_iva(srifacturasproveedoresiva012Aux.gettotal_sin_iva()+srifacturasproveedoresiva012.gettotal_sin_iva());			
			srifacturasproveedoresiva012Aux.settransfe_iva_retenido(srifacturasproveedoresiva012Aux.gettransfe_iva_retenido()+srifacturasproveedoresiva012.gettransfe_iva_retenido());			
			srifacturasproveedoresiva012Aux.setpresta_iva_retenido(srifacturasproveedoresiva012Aux.getpresta_iva_retenido()+srifacturasproveedoresiva012.getpresta_iva_retenido());			
			srifacturasproveedoresiva012Aux.setret_fuente1_porcentaje(srifacturasproveedoresiva012Aux.getret_fuente1_porcentaje()+srifacturasproveedoresiva012.getret_fuente1_porcentaje());			
			srifacturasproveedoresiva012Aux.setret_fuente1_retenido(srifacturasproveedoresiva012Aux.getret_fuente1_retenido()+srifacturasproveedoresiva012.getret_fuente1_retenido());			
			srifacturasproveedoresiva012Aux.setret_fuente2_porcentaje(srifacturasproveedoresiva012Aux.getret_fuente2_porcentaje()+srifacturasproveedoresiva012.getret_fuente2_porcentaje());			
			srifacturasproveedoresiva012Aux.setret_fuente2_retenido(srifacturasproveedoresiva012Aux.getret_fuente2_retenido()+srifacturasproveedoresiva012.getret_fuente2_retenido());			
			srifacturasproveedoresiva012Aux.setret_iva_bien_porcentaje(srifacturasproveedoresiva012Aux.getret_iva_bien_porcentaje()+srifacturasproveedoresiva012.getret_iva_bien_porcentaje());			
			srifacturasproveedoresiva012Aux.setret_iva_bien_retenido(srifacturasproveedoresiva012Aux.getret_iva_bien_retenido()+srifacturasproveedoresiva012.getret_iva_bien_retenido());			
			srifacturasproveedoresiva012Aux.setret_iva_servicio_porcentaje(srifacturasproveedoresiva012Aux.getret_iva_servicio_porcentaje()+srifacturasproveedoresiva012.getret_iva_servicio_porcentaje());			
			srifacturasproveedoresiva012Aux.setret_iva_servicio_retenido(srifacturasproveedoresiva012Aux.getret_iva_servicio_retenido()+srifacturasproveedoresiva012.getret_iva_servicio_retenido());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSriFacturasProveedoresIva012(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SriFacturasProveedoresIva012ConstantesFunciones.getArrayColumnasGlobalesSriFacturasProveedoresIva012(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSriFacturasProveedoresIva012(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SriFacturasProveedoresIva012ConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SriFacturasProveedoresIva012ConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSriFacturasProveedoresIva012(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SriFacturasProveedoresIva012> srifacturasproveedoresiva012s,SriFacturasProveedoresIva012 srifacturasproveedoresiva012,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SriFacturasProveedoresIva012 srifacturasproveedoresiva012Aux: srifacturasproveedoresiva012s) {
			if(srifacturasproveedoresiva012Aux!=null && srifacturasproveedoresiva012!=null) {
				if((srifacturasproveedoresiva012Aux.getId()==null && srifacturasproveedoresiva012.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(srifacturasproveedoresiva012Aux.getId()!=null && srifacturasproveedoresiva012.getId()!=null){
					if(srifacturasproveedoresiva012Aux.getId().equals(srifacturasproveedoresiva012.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSriFacturasProveedoresIva012(List<SriFacturasProveedoresIva012> srifacturasproveedoresiva012s) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_ivaTotal=0.0;
		Double total_sin_ivaTotal=0.0;
		Double transfe_iva_retenidoTotal=0.0;
		Double presta_iva_retenidoTotal=0.0;
		Double ret_fuente1_porcentajeTotal=0.0;
		Double ret_fuente1_retenidoTotal=0.0;
		Double ret_fuente2_porcentajeTotal=0.0;
		Double ret_fuente2_retenidoTotal=0.0;
		Double ret_iva_bien_porcentajeTotal=0.0;
		Double ret_iva_bien_retenidoTotal=0.0;
		Double ret_iva_servicio_porcentajeTotal=0.0;
		Double ret_iva_servicio_retenidoTotal=0.0;
	
		for(SriFacturasProveedoresIva012 srifacturasproveedoresiva012: srifacturasproveedoresiva012s) {			
			if(srifacturasproveedoresiva012.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			total_ivaTotal+=srifacturasproveedoresiva012.gettotal_iva();
			total_sin_ivaTotal+=srifacturasproveedoresiva012.gettotal_sin_iva();
			transfe_iva_retenidoTotal+=srifacturasproveedoresiva012.gettransfe_iva_retenido();
			presta_iva_retenidoTotal+=srifacturasproveedoresiva012.getpresta_iva_retenido();
			ret_fuente1_porcentajeTotal+=srifacturasproveedoresiva012.getret_fuente1_porcentaje();
			ret_fuente1_retenidoTotal+=srifacturasproveedoresiva012.getret_fuente1_retenido();
			ret_fuente2_porcentajeTotal+=srifacturasproveedoresiva012.getret_fuente2_porcentaje();
			ret_fuente2_retenidoTotal+=srifacturasproveedoresiva012.getret_fuente2_retenido();
			ret_iva_bien_porcentajeTotal+=srifacturasproveedoresiva012.getret_iva_bien_porcentaje();
			ret_iva_bien_retenidoTotal+=srifacturasproveedoresiva012.getret_iva_bien_retenido();
			ret_iva_servicio_porcentajeTotal+=srifacturasproveedoresiva012.getret_iva_servicio_porcentaje();
			ret_iva_servicio_retenidoTotal+=srifacturasproveedoresiva012.getret_iva_servicio_retenido();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.TOTALIVA);
		datoGeneral.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_TOTALIVA);
		datoGeneral.setdValorDouble(total_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.TOTALSINIVA);
		datoGeneral.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_TOTALSINIVA);
		datoGeneral.setdValorDouble(total_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.TRANSFEIVARETENIDO);
		datoGeneral.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_TRANSFEIVARETENIDO);
		datoGeneral.setdValorDouble(transfe_iva_retenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.PRESTAIVARETENIDO);
		datoGeneral.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_PRESTAIVARETENIDO);
		datoGeneral.setdValorDouble(presta_iva_retenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE1PORCENTAJE);
		datoGeneral.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE1PORCENTAJE);
		datoGeneral.setdValorDouble(ret_fuente1_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE1RETENIDO);
		datoGeneral.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE1RETENIDO);
		datoGeneral.setdValorDouble(ret_fuente1_retenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE2PORCENTAJE);
		datoGeneral.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE2PORCENTAJE);
		datoGeneral.setdValorDouble(ret_fuente2_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE2RETENIDO);
		datoGeneral.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE2RETENIDO);
		datoGeneral.setdValorDouble(ret_fuente2_retenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.RETIVABIENPORCENTAJE);
		datoGeneral.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVABIENPORCENTAJE);
		datoGeneral.setdValorDouble(ret_iva_bien_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.RETIVABIENRETENIDO);
		datoGeneral.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVABIENRETENIDO);
		datoGeneral.setdValorDouble(ret_iva_bien_retenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.RETIVASERVICIOPORCENTAJE);
		datoGeneral.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVASERVICIOPORCENTAJE);
		datoGeneral.setdValorDouble(ret_iva_servicio_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.RETIVASERVICIORETENIDO);
		datoGeneral.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVASERVICIORETENIDO);
		datoGeneral.setdValorDouble(ret_iva_servicio_retenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSriFacturasProveedoresIva012() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_ID, SriFacturasProveedoresIva012ConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_VERSIONROW, SriFacturasProveedoresIva012ConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPOCOMPROBANTE, SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPOCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE, SriFacturasProveedoresIva012ConstantesFunciones.NOMBRECOMPLETOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RUCDATO, SriFacturasProveedoresIva012ConstantesFunciones.RUCDATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NUMERODOCUMENTO, SriFacturasProveedoresIva012ConstantesFunciones.NUMERODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_FECHAEMISION, SriFacturasProveedoresIva012ConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_FECHAREGISTROCONTABLE, SriFacturasProveedoresIva012ConstantesFunciones.FECHAREGISTROCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NUMEROSERIE, SriFacturasProveedoresIva012ConstantesFunciones.NUMEROSERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_TOTALIVA, SriFacturasProveedoresIva012ConstantesFunciones.TOTALIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_TOTALSINIVA, SriFacturasProveedoresIva012ConstantesFunciones.TOTALSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDTIPOIVA, SriFacturasProveedoresIva012ConstantesFunciones.IDTIPOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDTIPORETENCIONIVA, SriFacturasProveedoresIva012ConstantesFunciones.IDTIPORETENCIONIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_TRANSFEIVARETENIDO, SriFacturasProveedoresIva012ConstantesFunciones.TRANSFEIVARETENIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDTIPORETENCIONIVAPRESTA, SriFacturasProveedoresIva012ConstantesFunciones.IDTIPORETENCIONIVAPRESTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_PRESTAIVARETENIDO, SriFacturasProveedoresIva012ConstantesFunciones.PRESTAIVARETENIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPORETENCIONFUENTE1, SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONFUENTE1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE1PORCENTAJE, SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE1PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE1RETENIDO, SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE1RETENIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPORETENCIONFUENTE2, SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONFUENTE2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE2PORCENTAJE, SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE2PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE2RETENIDO, SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE2RETENIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPORETENCIONIVA1, SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONIVA1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVABIENPORCENTAJE, SriFacturasProveedoresIva012ConstantesFunciones.RETIVABIENPORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVABIENRETENIDO, SriFacturasProveedoresIva012ConstantesFunciones.RETIVABIENRETENIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPORETENCIONIVA2, SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONIVA2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVASERVICIOPORCENTAJE, SriFacturasProveedoresIva012ConstantesFunciones.RETIVASERVICIOPORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVASERVICIORETENIDO, SriFacturasProveedoresIva012ConstantesFunciones.RETIVASERVICIORETENIDO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSriFacturasProveedoresIva012() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPOCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.NOMBRECOMPLETOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.RUCDATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.NUMERODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.FECHAREGISTROCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.NUMEROSERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.TOTALIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.TOTALSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.IDTIPOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.IDTIPORETENCIONIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.TRANSFEIVARETENIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.IDTIPORETENCIONIVAPRESTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.PRESTAIVARETENIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONFUENTE1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE1PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE1RETENIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONFUENTE2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE2PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE2RETENIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONIVA1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.RETIVABIENPORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.RETIVABIENRETENIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONIVA2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.RETIVASERVICIOPORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresIva012ConstantesFunciones.RETIVASERVICIORETENIDO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSriFacturasProveedoresIva012() throws Exception  {
		return SriFacturasProveedoresIva012ConstantesFunciones.getTiposSeleccionarSriFacturasProveedoresIva012(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSriFacturasProveedoresIva012(Boolean conFk) throws Exception  {
		return SriFacturasProveedoresIva012ConstantesFunciones.getTiposSeleccionarSriFacturasProveedoresIva012(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSriFacturasProveedoresIva012(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDPERIODODECLARA);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDPERIODODECLARA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPOCOMPROBANTE);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPOCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RUCDATO);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RUCDATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NUMERODOCUMENTO);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NUMERODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_FECHAREGISTROCONTABLE);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_FECHAREGISTROCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NUMEROSERIE);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NUMEROSERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_TOTALIVA);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_TOTALIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_TOTALSINIVA);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_TOTALSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDTIPOIVA);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDTIPOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDTIPORETENCIONIVA);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDTIPORETENCIONIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_TRANSFEIVARETENIDO);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_TRANSFEIVARETENIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDTIPORETENCIONIVAPRESTA);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDTIPORETENCIONIVAPRESTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_PRESTAIVARETENIDO);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_PRESTAIVARETENIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPORETENCIONFUENTE1);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPORETENCIONFUENTE1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE1PORCENTAJE);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE1PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE1RETENIDO);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE1RETENIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPORETENCIONFUENTE2);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPORETENCIONFUENTE2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE2PORCENTAJE);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE2PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE2RETENIDO);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE2RETENIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPORETENCIONIVA1);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPORETENCIONIVA1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVABIENPORCENTAJE);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVABIENPORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVABIENRETENIDO);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVABIENRETENIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPORETENCIONIVA2);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPORETENCIONIVA2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVASERVICIOPORCENTAJE);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVASERVICIOPORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVASERVICIORETENIDO);
			reporte.setsDescripcion(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVASERVICIORETENIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSriFacturasProveedoresIva012(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSriFacturasProveedoresIva012(SriFacturasProveedoresIva012 srifacturasproveedoresiva012Aux) throws Exception {
		
			srifacturasproveedoresiva012Aux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(srifacturasproveedoresiva012Aux.getEmpresa()));
			srifacturasproveedoresiva012Aux.setperiododeclara_descripcion(PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(srifacturasproveedoresiva012Aux.getPeriodoDeclara()));
			srifacturasproveedoresiva012Aux.settipoiva_descripcion(TipoIvaConstantesFunciones.getTipoIvaDescripcion(srifacturasproveedoresiva012Aux.getTipoIva()));
			srifacturasproveedoresiva012Aux.settiporetencioniva_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(srifacturasproveedoresiva012Aux.getTipoRetencionIva()));
			srifacturasproveedoresiva012Aux.settiporetencionivapresta_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(srifacturasproveedoresiva012Aux.getTipoRetencionIvaPresta()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSriFacturasProveedoresIva012(List<SriFacturasProveedoresIva012> srifacturasproveedoresiva012sTemp) throws Exception {
		for(SriFacturasProveedoresIva012 srifacturasproveedoresiva012Aux:srifacturasproveedoresiva012sTemp) {
			
			srifacturasproveedoresiva012Aux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(srifacturasproveedoresiva012Aux.getEmpresa()));
			srifacturasproveedoresiva012Aux.setperiododeclara_descripcion(PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(srifacturasproveedoresiva012Aux.getPeriodoDeclara()));
			srifacturasproveedoresiva012Aux.settipoiva_descripcion(TipoIvaConstantesFunciones.getTipoIvaDescripcion(srifacturasproveedoresiva012Aux.getTipoIva()));
			srifacturasproveedoresiva012Aux.settiporetencioniva_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(srifacturasproveedoresiva012Aux.getTipoRetencionIva()));
			srifacturasproveedoresiva012Aux.settiporetencionivapresta_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(srifacturasproveedoresiva012Aux.getTipoRetencionIvaPresta()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSriFacturasProveedoresIva012(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(PeriodoDeclara.class));
				classes.add(new Classe(TipoIva.class));
				classes.add(new Classe(TipoRetencion.class));
				classes.add(new Classe(TipoRetencion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PeriodoDeclara.class)) {
						classes.add(new Classe(PeriodoDeclara.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoIva.class)) {
						classes.add(new Classe(TipoIva.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencion.class)) {
						classes.add(new Classe(TipoRetencion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencion.class)) {
						classes.add(new Classe(TipoRetencion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSriFacturasProveedoresIva012(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(PeriodoDeclara.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PeriodoDeclara.class)); continue;
					}

					if(TipoIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIva.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(PeriodoDeclara.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PeriodoDeclara.class)); continue;
					}

					if(TipoIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIva.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSriFacturasProveedoresIva012(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SriFacturasProveedoresIva012ConstantesFunciones.getClassesRelationshipsOfSriFacturasProveedoresIva012(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSriFacturasProveedoresIva012(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSriFacturasProveedoresIva012(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SriFacturasProveedoresIva012ConstantesFunciones.getClassesRelationshipsFromStringsOfSriFacturasProveedoresIva012(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSriFacturasProveedoresIva012(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(SriFacturasProveedoresIva012 srifacturasproveedoresiva012,List<SriFacturasProveedoresIva012> srifacturasproveedoresiva012s,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(SriFacturasProveedoresIva012 srifacturasproveedoresiva012,List<SriFacturasProveedoresIva012> srifacturasproveedoresiva012s) throws Exception {
		try	{			
			for(SriFacturasProveedoresIva012 srifacturasproveedoresiva012Local:srifacturasproveedoresiva012s) {
				if(srifacturasproveedoresiva012Local.getId().equals(srifacturasproveedoresiva012.getId())) {
					srifacturasproveedoresiva012Local.setIsSelected(srifacturasproveedoresiva012.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSriFacturasProveedoresIva012(List<SriFacturasProveedoresIva012> srifacturasproveedoresiva012sAux) throws Exception {
		//this.srifacturasproveedoresiva012sAux=srifacturasproveedoresiva012sAux;
		
		for(SriFacturasProveedoresIva012 srifacturasproveedoresiva012Aux:srifacturasproveedoresiva012sAux) {
			if(srifacturasproveedoresiva012Aux.getIsChanged()) {
				srifacturasproveedoresiva012Aux.setIsChanged(false);
			}		
			
			if(srifacturasproveedoresiva012Aux.getIsNew()) {
				srifacturasproveedoresiva012Aux.setIsNew(false);
			}	
			
			if(srifacturasproveedoresiva012Aux.getIsDeleted()) {
				srifacturasproveedoresiva012Aux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSriFacturasProveedoresIva012(SriFacturasProveedoresIva012 srifacturasproveedoresiva012Aux) throws Exception {
		//this.srifacturasproveedoresiva012Aux=srifacturasproveedoresiva012Aux;
		
			if(srifacturasproveedoresiva012Aux.getIsChanged()) {
				srifacturasproveedoresiva012Aux.setIsChanged(false);
			}		
			
			if(srifacturasproveedoresiva012Aux.getIsNew()) {
				srifacturasproveedoresiva012Aux.setIsNew(false);
			}	
			
			if(srifacturasproveedoresiva012Aux.getIsDeleted()) {
				srifacturasproveedoresiva012Aux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(SriFacturasProveedoresIva012 srifacturasproveedoresiva012Asignar,SriFacturasProveedoresIva012 srifacturasproveedoresiva012) throws Exception {
		srifacturasproveedoresiva012Asignar.setId(srifacturasproveedoresiva012.getId());	
		srifacturasproveedoresiva012Asignar.setVersionRow(srifacturasproveedoresiva012.getVersionRow());	
		srifacturasproveedoresiva012Asignar.setnombre_tipo_comprobante(srifacturasproveedoresiva012.getnombre_tipo_comprobante());	
		srifacturasproveedoresiva012Asignar.setnombre_completo_cliente(srifacturasproveedoresiva012.getnombre_completo_cliente());	
		srifacturasproveedoresiva012Asignar.setruc_dato(srifacturasproveedoresiva012.getruc_dato());	
		srifacturasproveedoresiva012Asignar.setnumero_documento(srifacturasproveedoresiva012.getnumero_documento());	
		srifacturasproveedoresiva012Asignar.setfecha_emision(srifacturasproveedoresiva012.getfecha_emision());	
		srifacturasproveedoresiva012Asignar.setfecha_registro_contable(srifacturasproveedoresiva012.getfecha_registro_contable());	
		srifacturasproveedoresiva012Asignar.setnumero_serie(srifacturasproveedoresiva012.getnumero_serie());	
		srifacturasproveedoresiva012Asignar.settotal_iva(srifacturasproveedoresiva012.gettotal_iva());	
		srifacturasproveedoresiva012Asignar.settotal_sin_iva(srifacturasproveedoresiva012.gettotal_sin_iva());	
		srifacturasproveedoresiva012Asignar.setid_tipo_iva(srifacturasproveedoresiva012.getid_tipo_iva());
		srifacturasproveedoresiva012Asignar.settipoiva_descripcion(srifacturasproveedoresiva012.gettipoiva_descripcion());	
		srifacturasproveedoresiva012Asignar.setid_tipo_retencion_iva(srifacturasproveedoresiva012.getid_tipo_retencion_iva());
		srifacturasproveedoresiva012Asignar.settiporetencioniva_descripcion(srifacturasproveedoresiva012.gettiporetencioniva_descripcion());	
		srifacturasproveedoresiva012Asignar.settransfe_iva_retenido(srifacturasproveedoresiva012.gettransfe_iva_retenido());	
		srifacturasproveedoresiva012Asignar.setid_tipo_retencion_iva_presta(srifacturasproveedoresiva012.getid_tipo_retencion_iva_presta());
		srifacturasproveedoresiva012Asignar.settiporetencionivapresta_descripcion(srifacturasproveedoresiva012.gettiporetencionivapresta_descripcion());	
		srifacturasproveedoresiva012Asignar.setpresta_iva_retenido(srifacturasproveedoresiva012.getpresta_iva_retenido());	
		srifacturasproveedoresiva012Asignar.setnombre_tipo_retencion_fuente1(srifacturasproveedoresiva012.getnombre_tipo_retencion_fuente1());	
		srifacturasproveedoresiva012Asignar.setret_fuente1_porcentaje(srifacturasproveedoresiva012.getret_fuente1_porcentaje());	
		srifacturasproveedoresiva012Asignar.setret_fuente1_retenido(srifacturasproveedoresiva012.getret_fuente1_retenido());	
		srifacturasproveedoresiva012Asignar.setnombre_tipo_retencion_fuente2(srifacturasproveedoresiva012.getnombre_tipo_retencion_fuente2());	
		srifacturasproveedoresiva012Asignar.setret_fuente2_porcentaje(srifacturasproveedoresiva012.getret_fuente2_porcentaje());	
		srifacturasproveedoresiva012Asignar.setret_fuente2_retenido(srifacturasproveedoresiva012.getret_fuente2_retenido());	
		srifacturasproveedoresiva012Asignar.setnombre_tipo_retencion_iva1(srifacturasproveedoresiva012.getnombre_tipo_retencion_iva1());	
		srifacturasproveedoresiva012Asignar.setret_iva_bien_porcentaje(srifacturasproveedoresiva012.getret_iva_bien_porcentaje());	
		srifacturasproveedoresiva012Asignar.setret_iva_bien_retenido(srifacturasproveedoresiva012.getret_iva_bien_retenido());	
		srifacturasproveedoresiva012Asignar.setnombre_tipo_retencion_iva2(srifacturasproveedoresiva012.getnombre_tipo_retencion_iva2());	
		srifacturasproveedoresiva012Asignar.setret_iva_servicio_porcentaje(srifacturasproveedoresiva012.getret_iva_servicio_porcentaje());	
		srifacturasproveedoresiva012Asignar.setret_iva_servicio_retenido(srifacturasproveedoresiva012.getret_iva_servicio_retenido());	
	}
	
	public static void inicializarSriFacturasProveedoresIva012(SriFacturasProveedoresIva012 srifacturasproveedoresiva012) throws Exception {
		try {
				srifacturasproveedoresiva012.setId(0L);	
					
				srifacturasproveedoresiva012.setnombre_tipo_comprobante("");	
				srifacturasproveedoresiva012.setnombre_completo_cliente("");	
				srifacturasproveedoresiva012.setruc_dato("");	
				srifacturasproveedoresiva012.setnumero_documento("");	
				srifacturasproveedoresiva012.setfecha_emision(new Date());	
				srifacturasproveedoresiva012.setfecha_registro_contable(new Date());	
				srifacturasproveedoresiva012.setnumero_serie("");	
				srifacturasproveedoresiva012.settotal_iva(0.0);	
				srifacturasproveedoresiva012.settotal_sin_iva(0.0);	
				srifacturasproveedoresiva012.setid_tipo_iva(-1L);	
				srifacturasproveedoresiva012.setid_tipo_retencion_iva(-1L);	
				srifacturasproveedoresiva012.settransfe_iva_retenido(0.0);	
				srifacturasproveedoresiva012.setid_tipo_retencion_iva_presta(-1L);	
				srifacturasproveedoresiva012.setpresta_iva_retenido(0.0);	
				srifacturasproveedoresiva012.setnombre_tipo_retencion_fuente1("");	
				srifacturasproveedoresiva012.setret_fuente1_porcentaje(0.0);	
				srifacturasproveedoresiva012.setret_fuente1_retenido(0.0);	
				srifacturasproveedoresiva012.setnombre_tipo_retencion_fuente2("");	
				srifacturasproveedoresiva012.setret_fuente2_porcentaje(0.0);	
				srifacturasproveedoresiva012.setret_fuente2_retenido(0.0);	
				srifacturasproveedoresiva012.setnombre_tipo_retencion_iva1("");	
				srifacturasproveedoresiva012.setret_iva_bien_porcentaje(0.0);	
				srifacturasproveedoresiva012.setret_iva_bien_retenido(0.0);	
				srifacturasproveedoresiva012.setnombre_tipo_retencion_iva2("");	
				srifacturasproveedoresiva012.setret_iva_servicio_porcentaje(0.0);	
				srifacturasproveedoresiva012.setret_iva_servicio_retenido(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSriFacturasProveedoresIva012(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDPERIODODECLARA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPOCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RUCDATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NUMERODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_FECHAREGISTROCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NUMEROSERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_TOTALIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_TOTALSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDTIPOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDTIPORETENCIONIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_TRANSFEIVARETENIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_IDTIPORETENCIONIVAPRESTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_PRESTAIVARETENIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPORETENCIONFUENTE1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE1PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE1RETENIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPORETENCIONFUENTE2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE2PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETFUENTE2RETENIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPORETENCIONIVA1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVABIENPORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVABIENRETENIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_NOMBRETIPORETENCIONIVA2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVASERVICIOPORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresIva012ConstantesFunciones.LABEL_RETIVASERVICIORETENIDO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSriFacturasProveedoresIva012(String sTipo,Row row,Workbook workbook,SriFacturasProveedoresIva012 srifacturasproveedoresiva012,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getperiododeclara_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getnombre_tipo_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getruc_dato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getnumero_documento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getfecha_registro_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getnumero_serie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.gettotal_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.gettotal_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.gettipoiva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.gettiporetencioniva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.gettransfe_iva_retenido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.gettiporetencionivapresta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getpresta_iva_retenido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getnombre_tipo_retencion_fuente1());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getret_fuente1_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getret_fuente1_retenido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getnombre_tipo_retencion_fuente2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getret_fuente2_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getret_fuente2_retenido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getnombre_tipo_retencion_iva1());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getret_iva_bien_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getret_iva_bien_retenido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getnombre_tipo_retencion_iva2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getret_iva_servicio_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedoresiva012.getret_iva_servicio_retenido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySriFacturasProveedoresIva012="";
	
	public String getsFinalQuerySriFacturasProveedoresIva012() {
		return this.sFinalQuerySriFacturasProveedoresIva012;
	}
	
	public void setsFinalQuerySriFacturasProveedoresIva012(String sFinalQuerySriFacturasProveedoresIva012) {
		this.sFinalQuerySriFacturasProveedoresIva012= sFinalQuerySriFacturasProveedoresIva012;
	}
	
	public Border resaltarSeleccionarSriFacturasProveedoresIva012=null;
	
	public Border setResaltarSeleccionarSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSriFacturasProveedoresIva012= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSriFacturasProveedoresIva012() {
		return this.resaltarSeleccionarSriFacturasProveedoresIva012;
	}
	
	public void setResaltarSeleccionarSriFacturasProveedoresIva012(Border borderResaltarSeleccionarSriFacturasProveedoresIva012) {
		this.resaltarSeleccionarSriFacturasProveedoresIva012= borderResaltarSeleccionarSriFacturasProveedoresIva012;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSriFacturasProveedoresIva012=null;
	public Boolean mostraridSriFacturasProveedoresIva012=true;
	public Boolean activaridSriFacturasProveedoresIva012=true;

	public Border resaltarid_empresaSriFacturasProveedoresIva012=null;
	public Boolean mostrarid_empresaSriFacturasProveedoresIva012=true;
	public Boolean activarid_empresaSriFacturasProveedoresIva012=true;
	public Boolean cargarid_empresaSriFacturasProveedoresIva012=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSriFacturasProveedoresIva012=false;//ConEventDepend=true

	public Border resaltarid_periodo_declaraSriFacturasProveedoresIva012=null;
	public Boolean mostrarid_periodo_declaraSriFacturasProveedoresIva012=true;
	public Boolean activarid_periodo_declaraSriFacturasProveedoresIva012=true;
	public Boolean cargarid_periodo_declaraSriFacturasProveedoresIva012=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodo_declaraSriFacturasProveedoresIva012=false;//ConEventDepend=true

	public Border resaltarrucSriFacturasProveedoresIva012=null;
	public Boolean mostrarrucSriFacturasProveedoresIva012=true;
	public Boolean activarrucSriFacturasProveedoresIva012=true;

	public Border resaltarnombre_tipo_comprobanteSriFacturasProveedoresIva012=null;
	public Boolean mostrarnombre_tipo_comprobanteSriFacturasProveedoresIva012=true;
	public Boolean activarnombre_tipo_comprobanteSriFacturasProveedoresIva012=true;

	public Border resaltarnombre_completo_clienteSriFacturasProveedoresIva012=null;
	public Boolean mostrarnombre_completo_clienteSriFacturasProveedoresIva012=true;
	public Boolean activarnombre_completo_clienteSriFacturasProveedoresIva012=true;

	public Border resaltarruc_datoSriFacturasProveedoresIva012=null;
	public Boolean mostrarruc_datoSriFacturasProveedoresIva012=true;
	public Boolean activarruc_datoSriFacturasProveedoresIva012=true;

	public Border resaltarnumero_documentoSriFacturasProveedoresIva012=null;
	public Boolean mostrarnumero_documentoSriFacturasProveedoresIva012=true;
	public Boolean activarnumero_documentoSriFacturasProveedoresIva012=true;

	public Border resaltarfecha_emisionSriFacturasProveedoresIva012=null;
	public Boolean mostrarfecha_emisionSriFacturasProveedoresIva012=true;
	public Boolean activarfecha_emisionSriFacturasProveedoresIva012=true;

	public Border resaltarfecha_registro_contableSriFacturasProveedoresIva012=null;
	public Boolean mostrarfecha_registro_contableSriFacturasProveedoresIva012=true;
	public Boolean activarfecha_registro_contableSriFacturasProveedoresIva012=true;

	public Border resaltarnumero_serieSriFacturasProveedoresIva012=null;
	public Boolean mostrarnumero_serieSriFacturasProveedoresIva012=true;
	public Boolean activarnumero_serieSriFacturasProveedoresIva012=true;

	public Border resaltartotal_ivaSriFacturasProveedoresIva012=null;
	public Boolean mostrartotal_ivaSriFacturasProveedoresIva012=true;
	public Boolean activartotal_ivaSriFacturasProveedoresIva012=true;

	public Border resaltartotal_sin_ivaSriFacturasProveedoresIva012=null;
	public Boolean mostrartotal_sin_ivaSriFacturasProveedoresIva012=true;
	public Boolean activartotal_sin_ivaSriFacturasProveedoresIva012=true;

	public Border resaltarid_tipo_ivaSriFacturasProveedoresIva012=null;
	public Boolean mostrarid_tipo_ivaSriFacturasProveedoresIva012=true;
	public Boolean activarid_tipo_ivaSriFacturasProveedoresIva012=true;
	public Boolean cargarid_tipo_ivaSriFacturasProveedoresIva012=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_ivaSriFacturasProveedoresIva012=false;//ConEventDepend=true

	public Border resaltarid_tipo_retencion_ivaSriFacturasProveedoresIva012=null;
	public Boolean mostrarid_tipo_retencion_ivaSriFacturasProveedoresIva012=true;
	public Boolean activarid_tipo_retencion_ivaSriFacturasProveedoresIva012=true;
	public Boolean cargarid_tipo_retencion_ivaSriFacturasProveedoresIva012=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencion_ivaSriFacturasProveedoresIva012=false;//ConEventDepend=true

	public Border resaltartransfe_iva_retenidoSriFacturasProveedoresIva012=null;
	public Boolean mostrartransfe_iva_retenidoSriFacturasProveedoresIva012=true;
	public Boolean activartransfe_iva_retenidoSriFacturasProveedoresIva012=true;

	public Border resaltarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012=null;
	public Boolean mostrarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012=true;
	public Boolean activarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012=true;
	public Boolean cargarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012=false;//ConEventDepend=true

	public Border resaltarpresta_iva_retenidoSriFacturasProveedoresIva012=null;
	public Boolean mostrarpresta_iva_retenidoSriFacturasProveedoresIva012=true;
	public Boolean activarpresta_iva_retenidoSriFacturasProveedoresIva012=true;

	public Border resaltarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012=null;
	public Boolean mostrarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012=true;
	public Boolean activarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012=true;

	public Border resaltarret_fuente1_porcentajeSriFacturasProveedoresIva012=null;
	public Boolean mostrarret_fuente1_porcentajeSriFacturasProveedoresIva012=true;
	public Boolean activarret_fuente1_porcentajeSriFacturasProveedoresIva012=true;

	public Border resaltarret_fuente1_retenidoSriFacturasProveedoresIva012=null;
	public Boolean mostrarret_fuente1_retenidoSriFacturasProveedoresIva012=true;
	public Boolean activarret_fuente1_retenidoSriFacturasProveedoresIva012=true;

	public Border resaltarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012=null;
	public Boolean mostrarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012=true;
	public Boolean activarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012=true;

	public Border resaltarret_fuente2_porcentajeSriFacturasProveedoresIva012=null;
	public Boolean mostrarret_fuente2_porcentajeSriFacturasProveedoresIva012=true;
	public Boolean activarret_fuente2_porcentajeSriFacturasProveedoresIva012=true;

	public Border resaltarret_fuente2_retenidoSriFacturasProveedoresIva012=null;
	public Boolean mostrarret_fuente2_retenidoSriFacturasProveedoresIva012=true;
	public Boolean activarret_fuente2_retenidoSriFacturasProveedoresIva012=true;

	public Border resaltarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012=null;
	public Boolean mostrarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012=true;
	public Boolean activarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012=true;

	public Border resaltarret_iva_bien_porcentajeSriFacturasProveedoresIva012=null;
	public Boolean mostrarret_iva_bien_porcentajeSriFacturasProveedoresIva012=true;
	public Boolean activarret_iva_bien_porcentajeSriFacturasProveedoresIva012=true;

	public Border resaltarret_iva_bien_retenidoSriFacturasProveedoresIva012=null;
	public Boolean mostrarret_iva_bien_retenidoSriFacturasProveedoresIva012=true;
	public Boolean activarret_iva_bien_retenidoSriFacturasProveedoresIva012=true;

	public Border resaltarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012=null;
	public Boolean mostrarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012=true;
	public Boolean activarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012=true;

	public Border resaltarret_iva_servicio_porcentajeSriFacturasProveedoresIva012=null;
	public Boolean mostrarret_iva_servicio_porcentajeSriFacturasProveedoresIva012=true;
	public Boolean activarret_iva_servicio_porcentajeSriFacturasProveedoresIva012=true;

	public Border resaltarret_iva_servicio_retenidoSriFacturasProveedoresIva012=null;
	public Boolean mostrarret_iva_servicio_retenidoSriFacturasProveedoresIva012=true;
	public Boolean activarret_iva_servicio_retenidoSriFacturasProveedoresIva012=true;

	
	

	public Border setResaltaridSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltaridSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSriFacturasProveedoresIva012() {
		return this.resaltaridSriFacturasProveedoresIva012;
	}

	public void setResaltaridSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltaridSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostraridSriFacturasProveedoresIva012() {
		return this.mostraridSriFacturasProveedoresIva012;
	}

	public void setMostraridSriFacturasProveedoresIva012(Boolean mostraridSriFacturasProveedoresIva012) {
		this.mostraridSriFacturasProveedoresIva012= mostraridSriFacturasProveedoresIva012;
	}

	public Boolean getActivaridSriFacturasProveedoresIva012() {
		return this.activaridSriFacturasProveedoresIva012;
	}

	public void setActivaridSriFacturasProveedoresIva012(Boolean activaridSriFacturasProveedoresIva012) {
		this.activaridSriFacturasProveedoresIva012= activaridSriFacturasProveedoresIva012;
	}

	public Border setResaltarid_empresaSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarid_empresaSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSriFacturasProveedoresIva012() {
		return this.resaltarid_empresaSriFacturasProveedoresIva012;
	}

	public void setResaltarid_empresaSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarid_empresaSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarid_empresaSriFacturasProveedoresIva012() {
		return this.mostrarid_empresaSriFacturasProveedoresIva012;
	}

	public void setMostrarid_empresaSriFacturasProveedoresIva012(Boolean mostrarid_empresaSriFacturasProveedoresIva012) {
		this.mostrarid_empresaSriFacturasProveedoresIva012= mostrarid_empresaSriFacturasProveedoresIva012;
	}

	public Boolean getActivarid_empresaSriFacturasProveedoresIva012() {
		return this.activarid_empresaSriFacturasProveedoresIva012;
	}

	public void setActivarid_empresaSriFacturasProveedoresIva012(Boolean activarid_empresaSriFacturasProveedoresIva012) {
		this.activarid_empresaSriFacturasProveedoresIva012= activarid_empresaSriFacturasProveedoresIva012;
	}

	public Boolean getCargarid_empresaSriFacturasProveedoresIva012() {
		return this.cargarid_empresaSriFacturasProveedoresIva012;
	}

	public void setCargarid_empresaSriFacturasProveedoresIva012(Boolean cargarid_empresaSriFacturasProveedoresIva012) {
		this.cargarid_empresaSriFacturasProveedoresIva012= cargarid_empresaSriFacturasProveedoresIva012;
	}

	public Border setResaltarid_periodo_declaraSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarid_periodo_declaraSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodo_declaraSriFacturasProveedoresIva012() {
		return this.resaltarid_periodo_declaraSriFacturasProveedoresIva012;
	}

	public void setResaltarid_periodo_declaraSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarid_periodo_declaraSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarid_periodo_declaraSriFacturasProveedoresIva012() {
		return this.mostrarid_periodo_declaraSriFacturasProveedoresIva012;
	}

	public void setMostrarid_periodo_declaraSriFacturasProveedoresIva012(Boolean mostrarid_periodo_declaraSriFacturasProveedoresIva012) {
		this.mostrarid_periodo_declaraSriFacturasProveedoresIva012= mostrarid_periodo_declaraSriFacturasProveedoresIva012;
	}

	public Boolean getActivarid_periodo_declaraSriFacturasProveedoresIva012() {
		return this.activarid_periodo_declaraSriFacturasProveedoresIva012;
	}

	public void setActivarid_periodo_declaraSriFacturasProveedoresIva012(Boolean activarid_periodo_declaraSriFacturasProveedoresIva012) {
		this.activarid_periodo_declaraSriFacturasProveedoresIva012= activarid_periodo_declaraSriFacturasProveedoresIva012;
	}

	public Boolean getCargarid_periodo_declaraSriFacturasProveedoresIva012() {
		return this.cargarid_periodo_declaraSriFacturasProveedoresIva012;
	}

	public void setCargarid_periodo_declaraSriFacturasProveedoresIva012(Boolean cargarid_periodo_declaraSriFacturasProveedoresIva012) {
		this.cargarid_periodo_declaraSriFacturasProveedoresIva012= cargarid_periodo_declaraSriFacturasProveedoresIva012;
	}

	public Border setResaltarrucSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarrucSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucSriFacturasProveedoresIva012() {
		return this.resaltarrucSriFacturasProveedoresIva012;
	}

	public void setResaltarrucSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarrucSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarrucSriFacturasProveedoresIva012() {
		return this.mostrarrucSriFacturasProveedoresIva012;
	}

	public void setMostrarrucSriFacturasProveedoresIva012(Boolean mostrarrucSriFacturasProveedoresIva012) {
		this.mostrarrucSriFacturasProveedoresIva012= mostrarrucSriFacturasProveedoresIva012;
	}

	public Boolean getActivarrucSriFacturasProveedoresIva012() {
		return this.activarrucSriFacturasProveedoresIva012;
	}

	public void setActivarrucSriFacturasProveedoresIva012(Boolean activarrucSriFacturasProveedoresIva012) {
		this.activarrucSriFacturasProveedoresIva012= activarrucSriFacturasProveedoresIva012;
	}

	public Border setResaltarnombre_tipo_comprobanteSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_comprobanteSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_comprobanteSriFacturasProveedoresIva012() {
		return this.resaltarnombre_tipo_comprobanteSriFacturasProveedoresIva012;
	}

	public void setResaltarnombre_tipo_comprobanteSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarnombre_tipo_comprobanteSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_comprobanteSriFacturasProveedoresIva012() {
		return this.mostrarnombre_tipo_comprobanteSriFacturasProveedoresIva012;
	}

	public void setMostrarnombre_tipo_comprobanteSriFacturasProveedoresIva012(Boolean mostrarnombre_tipo_comprobanteSriFacturasProveedoresIva012) {
		this.mostrarnombre_tipo_comprobanteSriFacturasProveedoresIva012= mostrarnombre_tipo_comprobanteSriFacturasProveedoresIva012;
	}

	public Boolean getActivarnombre_tipo_comprobanteSriFacturasProveedoresIva012() {
		return this.activarnombre_tipo_comprobanteSriFacturasProveedoresIva012;
	}

	public void setActivarnombre_tipo_comprobanteSriFacturasProveedoresIva012(Boolean activarnombre_tipo_comprobanteSriFacturasProveedoresIva012) {
		this.activarnombre_tipo_comprobanteSriFacturasProveedoresIva012= activarnombre_tipo_comprobanteSriFacturasProveedoresIva012;
	}

	public Border setResaltarnombre_completo_clienteSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clienteSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clienteSriFacturasProveedoresIva012() {
		return this.resaltarnombre_completo_clienteSriFacturasProveedoresIva012;
	}

	public void setResaltarnombre_completo_clienteSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarnombre_completo_clienteSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clienteSriFacturasProveedoresIva012() {
		return this.mostrarnombre_completo_clienteSriFacturasProveedoresIva012;
	}

	public void setMostrarnombre_completo_clienteSriFacturasProveedoresIva012(Boolean mostrarnombre_completo_clienteSriFacturasProveedoresIva012) {
		this.mostrarnombre_completo_clienteSriFacturasProveedoresIva012= mostrarnombre_completo_clienteSriFacturasProveedoresIva012;
	}

	public Boolean getActivarnombre_completo_clienteSriFacturasProveedoresIva012() {
		return this.activarnombre_completo_clienteSriFacturasProveedoresIva012;
	}

	public void setActivarnombre_completo_clienteSriFacturasProveedoresIva012(Boolean activarnombre_completo_clienteSriFacturasProveedoresIva012) {
		this.activarnombre_completo_clienteSriFacturasProveedoresIva012= activarnombre_completo_clienteSriFacturasProveedoresIva012;
	}

	public Border setResaltarruc_datoSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarruc_datoSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarruc_datoSriFacturasProveedoresIva012() {
		return this.resaltarruc_datoSriFacturasProveedoresIva012;
	}

	public void setResaltarruc_datoSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarruc_datoSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarruc_datoSriFacturasProveedoresIva012() {
		return this.mostrarruc_datoSriFacturasProveedoresIva012;
	}

	public void setMostrarruc_datoSriFacturasProveedoresIva012(Boolean mostrarruc_datoSriFacturasProveedoresIva012) {
		this.mostrarruc_datoSriFacturasProveedoresIva012= mostrarruc_datoSriFacturasProveedoresIva012;
	}

	public Boolean getActivarruc_datoSriFacturasProveedoresIva012() {
		return this.activarruc_datoSriFacturasProveedoresIva012;
	}

	public void setActivarruc_datoSriFacturasProveedoresIva012(Boolean activarruc_datoSriFacturasProveedoresIva012) {
		this.activarruc_datoSriFacturasProveedoresIva012= activarruc_datoSriFacturasProveedoresIva012;
	}

	public Border setResaltarnumero_documentoSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarnumero_documentoSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_documentoSriFacturasProveedoresIva012() {
		return this.resaltarnumero_documentoSriFacturasProveedoresIva012;
	}

	public void setResaltarnumero_documentoSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarnumero_documentoSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarnumero_documentoSriFacturasProveedoresIva012() {
		return this.mostrarnumero_documentoSriFacturasProveedoresIva012;
	}

	public void setMostrarnumero_documentoSriFacturasProveedoresIva012(Boolean mostrarnumero_documentoSriFacturasProveedoresIva012) {
		this.mostrarnumero_documentoSriFacturasProveedoresIva012= mostrarnumero_documentoSriFacturasProveedoresIva012;
	}

	public Boolean getActivarnumero_documentoSriFacturasProveedoresIva012() {
		return this.activarnumero_documentoSriFacturasProveedoresIva012;
	}

	public void setActivarnumero_documentoSriFacturasProveedoresIva012(Boolean activarnumero_documentoSriFacturasProveedoresIva012) {
		this.activarnumero_documentoSriFacturasProveedoresIva012= activarnumero_documentoSriFacturasProveedoresIva012;
	}

	public Border setResaltarfecha_emisionSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionSriFacturasProveedoresIva012() {
		return this.resaltarfecha_emisionSriFacturasProveedoresIva012;
	}

	public void setResaltarfecha_emisionSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarfecha_emisionSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionSriFacturasProveedoresIva012() {
		return this.mostrarfecha_emisionSriFacturasProveedoresIva012;
	}

	public void setMostrarfecha_emisionSriFacturasProveedoresIva012(Boolean mostrarfecha_emisionSriFacturasProveedoresIva012) {
		this.mostrarfecha_emisionSriFacturasProveedoresIva012= mostrarfecha_emisionSriFacturasProveedoresIva012;
	}

	public Boolean getActivarfecha_emisionSriFacturasProveedoresIva012() {
		return this.activarfecha_emisionSriFacturasProveedoresIva012;
	}

	public void setActivarfecha_emisionSriFacturasProveedoresIva012(Boolean activarfecha_emisionSriFacturasProveedoresIva012) {
		this.activarfecha_emisionSriFacturasProveedoresIva012= activarfecha_emisionSriFacturasProveedoresIva012;
	}

	public Border setResaltarfecha_registro_contableSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarfecha_registro_contableSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_registro_contableSriFacturasProveedoresIva012() {
		return this.resaltarfecha_registro_contableSriFacturasProveedoresIva012;
	}

	public void setResaltarfecha_registro_contableSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarfecha_registro_contableSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarfecha_registro_contableSriFacturasProveedoresIva012() {
		return this.mostrarfecha_registro_contableSriFacturasProveedoresIva012;
	}

	public void setMostrarfecha_registro_contableSriFacturasProveedoresIva012(Boolean mostrarfecha_registro_contableSriFacturasProveedoresIva012) {
		this.mostrarfecha_registro_contableSriFacturasProveedoresIva012= mostrarfecha_registro_contableSriFacturasProveedoresIva012;
	}

	public Boolean getActivarfecha_registro_contableSriFacturasProveedoresIva012() {
		return this.activarfecha_registro_contableSriFacturasProveedoresIva012;
	}

	public void setActivarfecha_registro_contableSriFacturasProveedoresIva012(Boolean activarfecha_registro_contableSriFacturasProveedoresIva012) {
		this.activarfecha_registro_contableSriFacturasProveedoresIva012= activarfecha_registro_contableSriFacturasProveedoresIva012;
	}

	public Border setResaltarnumero_serieSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarnumero_serieSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_serieSriFacturasProveedoresIva012() {
		return this.resaltarnumero_serieSriFacturasProveedoresIva012;
	}

	public void setResaltarnumero_serieSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarnumero_serieSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarnumero_serieSriFacturasProveedoresIva012() {
		return this.mostrarnumero_serieSriFacturasProveedoresIva012;
	}

	public void setMostrarnumero_serieSriFacturasProveedoresIva012(Boolean mostrarnumero_serieSriFacturasProveedoresIva012) {
		this.mostrarnumero_serieSriFacturasProveedoresIva012= mostrarnumero_serieSriFacturasProveedoresIva012;
	}

	public Boolean getActivarnumero_serieSriFacturasProveedoresIva012() {
		return this.activarnumero_serieSriFacturasProveedoresIva012;
	}

	public void setActivarnumero_serieSriFacturasProveedoresIva012(Boolean activarnumero_serieSriFacturasProveedoresIva012) {
		this.activarnumero_serieSriFacturasProveedoresIva012= activarnumero_serieSriFacturasProveedoresIva012;
	}

	public Border setResaltartotal_ivaSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltartotal_ivaSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ivaSriFacturasProveedoresIva012() {
		return this.resaltartotal_ivaSriFacturasProveedoresIva012;
	}

	public void setResaltartotal_ivaSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltartotal_ivaSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrartotal_ivaSriFacturasProveedoresIva012() {
		return this.mostrartotal_ivaSriFacturasProveedoresIva012;
	}

	public void setMostrartotal_ivaSriFacturasProveedoresIva012(Boolean mostrartotal_ivaSriFacturasProveedoresIva012) {
		this.mostrartotal_ivaSriFacturasProveedoresIva012= mostrartotal_ivaSriFacturasProveedoresIva012;
	}

	public Boolean getActivartotal_ivaSriFacturasProveedoresIva012() {
		return this.activartotal_ivaSriFacturasProveedoresIva012;
	}

	public void setActivartotal_ivaSriFacturasProveedoresIva012(Boolean activartotal_ivaSriFacturasProveedoresIva012) {
		this.activartotal_ivaSriFacturasProveedoresIva012= activartotal_ivaSriFacturasProveedoresIva012;
	}

	public Border setResaltartotal_sin_ivaSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltartotal_sin_ivaSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_sin_ivaSriFacturasProveedoresIva012() {
		return this.resaltartotal_sin_ivaSriFacturasProveedoresIva012;
	}

	public void setResaltartotal_sin_ivaSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltartotal_sin_ivaSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrartotal_sin_ivaSriFacturasProveedoresIva012() {
		return this.mostrartotal_sin_ivaSriFacturasProveedoresIva012;
	}

	public void setMostrartotal_sin_ivaSriFacturasProveedoresIva012(Boolean mostrartotal_sin_ivaSriFacturasProveedoresIva012) {
		this.mostrartotal_sin_ivaSriFacturasProveedoresIva012= mostrartotal_sin_ivaSriFacturasProveedoresIva012;
	}

	public Boolean getActivartotal_sin_ivaSriFacturasProveedoresIva012() {
		return this.activartotal_sin_ivaSriFacturasProveedoresIva012;
	}

	public void setActivartotal_sin_ivaSriFacturasProveedoresIva012(Boolean activartotal_sin_ivaSriFacturasProveedoresIva012) {
		this.activartotal_sin_ivaSriFacturasProveedoresIva012= activartotal_sin_ivaSriFacturasProveedoresIva012;
	}

	public Border setResaltarid_tipo_ivaSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarid_tipo_ivaSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_ivaSriFacturasProveedoresIva012() {
		return this.resaltarid_tipo_ivaSriFacturasProveedoresIva012;
	}

	public void setResaltarid_tipo_ivaSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarid_tipo_ivaSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarid_tipo_ivaSriFacturasProveedoresIva012() {
		return this.mostrarid_tipo_ivaSriFacturasProveedoresIva012;
	}

	public void setMostrarid_tipo_ivaSriFacturasProveedoresIva012(Boolean mostrarid_tipo_ivaSriFacturasProveedoresIva012) {
		this.mostrarid_tipo_ivaSriFacturasProveedoresIva012= mostrarid_tipo_ivaSriFacturasProveedoresIva012;
	}

	public Boolean getActivarid_tipo_ivaSriFacturasProveedoresIva012() {
		return this.activarid_tipo_ivaSriFacturasProveedoresIva012;
	}

	public void setActivarid_tipo_ivaSriFacturasProveedoresIva012(Boolean activarid_tipo_ivaSriFacturasProveedoresIva012) {
		this.activarid_tipo_ivaSriFacturasProveedoresIva012= activarid_tipo_ivaSriFacturasProveedoresIva012;
	}

	public Boolean getCargarid_tipo_ivaSriFacturasProveedoresIva012() {
		return this.cargarid_tipo_ivaSriFacturasProveedoresIva012;
	}

	public void setCargarid_tipo_ivaSriFacturasProveedoresIva012(Boolean cargarid_tipo_ivaSriFacturasProveedoresIva012) {
		this.cargarid_tipo_ivaSriFacturasProveedoresIva012= cargarid_tipo_ivaSriFacturasProveedoresIva012;
	}

	public Border setResaltarid_tipo_retencion_ivaSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencion_ivaSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencion_ivaSriFacturasProveedoresIva012() {
		return this.resaltarid_tipo_retencion_ivaSriFacturasProveedoresIva012;
	}

	public void setResaltarid_tipo_retencion_ivaSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarid_tipo_retencion_ivaSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencion_ivaSriFacturasProveedoresIva012() {
		return this.mostrarid_tipo_retencion_ivaSriFacturasProveedoresIva012;
	}

	public void setMostrarid_tipo_retencion_ivaSriFacturasProveedoresIva012(Boolean mostrarid_tipo_retencion_ivaSriFacturasProveedoresIva012) {
		this.mostrarid_tipo_retencion_ivaSriFacturasProveedoresIva012= mostrarid_tipo_retencion_ivaSriFacturasProveedoresIva012;
	}

	public Boolean getActivarid_tipo_retencion_ivaSriFacturasProveedoresIva012() {
		return this.activarid_tipo_retencion_ivaSriFacturasProveedoresIva012;
	}

	public void setActivarid_tipo_retencion_ivaSriFacturasProveedoresIva012(Boolean activarid_tipo_retencion_ivaSriFacturasProveedoresIva012) {
		this.activarid_tipo_retencion_ivaSriFacturasProveedoresIva012= activarid_tipo_retencion_ivaSriFacturasProveedoresIva012;
	}

	public Boolean getCargarid_tipo_retencion_ivaSriFacturasProveedoresIva012() {
		return this.cargarid_tipo_retencion_ivaSriFacturasProveedoresIva012;
	}

	public void setCargarid_tipo_retencion_ivaSriFacturasProveedoresIva012(Boolean cargarid_tipo_retencion_ivaSriFacturasProveedoresIva012) {
		this.cargarid_tipo_retencion_ivaSriFacturasProveedoresIva012= cargarid_tipo_retencion_ivaSriFacturasProveedoresIva012;
	}

	public Border setResaltartransfe_iva_retenidoSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltartransfe_iva_retenidoSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartransfe_iva_retenidoSriFacturasProveedoresIva012() {
		return this.resaltartransfe_iva_retenidoSriFacturasProveedoresIva012;
	}

	public void setResaltartransfe_iva_retenidoSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltartransfe_iva_retenidoSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrartransfe_iva_retenidoSriFacturasProveedoresIva012() {
		return this.mostrartransfe_iva_retenidoSriFacturasProveedoresIva012;
	}

	public void setMostrartransfe_iva_retenidoSriFacturasProveedoresIva012(Boolean mostrartransfe_iva_retenidoSriFacturasProveedoresIva012) {
		this.mostrartransfe_iva_retenidoSriFacturasProveedoresIva012= mostrartransfe_iva_retenidoSriFacturasProveedoresIva012;
	}

	public Boolean getActivartransfe_iva_retenidoSriFacturasProveedoresIva012() {
		return this.activartransfe_iva_retenidoSriFacturasProveedoresIva012;
	}

	public void setActivartransfe_iva_retenidoSriFacturasProveedoresIva012(Boolean activartransfe_iva_retenidoSriFacturasProveedoresIva012) {
		this.activartransfe_iva_retenidoSriFacturasProveedoresIva012= activartransfe_iva_retenidoSriFacturasProveedoresIva012;
	}

	public Border setResaltarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012() {
		return this.resaltarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012;
	}

	public void setResaltarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012() {
		return this.mostrarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012;
	}

	public void setMostrarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012(Boolean mostrarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012) {
		this.mostrarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012= mostrarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012;
	}

	public Boolean getActivarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012() {
		return this.activarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012;
	}

	public void setActivarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012(Boolean activarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012) {
		this.activarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012= activarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012;
	}

	public Boolean getCargarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012() {
		return this.cargarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012;
	}

	public void setCargarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012(Boolean cargarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012) {
		this.cargarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012= cargarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012;
	}

	public Border setResaltarpresta_iva_retenidoSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarpresta_iva_retenidoSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpresta_iva_retenidoSriFacturasProveedoresIva012() {
		return this.resaltarpresta_iva_retenidoSriFacturasProveedoresIva012;
	}

	public void setResaltarpresta_iva_retenidoSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarpresta_iva_retenidoSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarpresta_iva_retenidoSriFacturasProveedoresIva012() {
		return this.mostrarpresta_iva_retenidoSriFacturasProveedoresIva012;
	}

	public void setMostrarpresta_iva_retenidoSriFacturasProveedoresIva012(Boolean mostrarpresta_iva_retenidoSriFacturasProveedoresIva012) {
		this.mostrarpresta_iva_retenidoSriFacturasProveedoresIva012= mostrarpresta_iva_retenidoSriFacturasProveedoresIva012;
	}

	public Boolean getActivarpresta_iva_retenidoSriFacturasProveedoresIva012() {
		return this.activarpresta_iva_retenidoSriFacturasProveedoresIva012;
	}

	public void setActivarpresta_iva_retenidoSriFacturasProveedoresIva012(Boolean activarpresta_iva_retenidoSriFacturasProveedoresIva012) {
		this.activarpresta_iva_retenidoSriFacturasProveedoresIva012= activarpresta_iva_retenidoSriFacturasProveedoresIva012;
	}

	public Border setResaltarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012() {
		return this.resaltarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012;
	}

	public void setResaltarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012() {
		return this.mostrarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012;
	}

	public void setMostrarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012(Boolean mostrarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012) {
		this.mostrarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012= mostrarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012;
	}

	public Boolean getActivarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012() {
		return this.activarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012;
	}

	public void setActivarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012(Boolean activarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012) {
		this.activarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012= activarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012;
	}

	public Border setResaltarret_fuente1_porcentajeSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarret_fuente1_porcentajeSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarret_fuente1_porcentajeSriFacturasProveedoresIva012() {
		return this.resaltarret_fuente1_porcentajeSriFacturasProveedoresIva012;
	}

	public void setResaltarret_fuente1_porcentajeSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarret_fuente1_porcentajeSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarret_fuente1_porcentajeSriFacturasProveedoresIva012() {
		return this.mostrarret_fuente1_porcentajeSriFacturasProveedoresIva012;
	}

	public void setMostrarret_fuente1_porcentajeSriFacturasProveedoresIva012(Boolean mostrarret_fuente1_porcentajeSriFacturasProveedoresIva012) {
		this.mostrarret_fuente1_porcentajeSriFacturasProveedoresIva012= mostrarret_fuente1_porcentajeSriFacturasProveedoresIva012;
	}

	public Boolean getActivarret_fuente1_porcentajeSriFacturasProveedoresIva012() {
		return this.activarret_fuente1_porcentajeSriFacturasProveedoresIva012;
	}

	public void setActivarret_fuente1_porcentajeSriFacturasProveedoresIva012(Boolean activarret_fuente1_porcentajeSriFacturasProveedoresIva012) {
		this.activarret_fuente1_porcentajeSriFacturasProveedoresIva012= activarret_fuente1_porcentajeSriFacturasProveedoresIva012;
	}

	public Border setResaltarret_fuente1_retenidoSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarret_fuente1_retenidoSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarret_fuente1_retenidoSriFacturasProveedoresIva012() {
		return this.resaltarret_fuente1_retenidoSriFacturasProveedoresIva012;
	}

	public void setResaltarret_fuente1_retenidoSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarret_fuente1_retenidoSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarret_fuente1_retenidoSriFacturasProveedoresIva012() {
		return this.mostrarret_fuente1_retenidoSriFacturasProveedoresIva012;
	}

	public void setMostrarret_fuente1_retenidoSriFacturasProveedoresIva012(Boolean mostrarret_fuente1_retenidoSriFacturasProveedoresIva012) {
		this.mostrarret_fuente1_retenidoSriFacturasProveedoresIva012= mostrarret_fuente1_retenidoSriFacturasProveedoresIva012;
	}

	public Boolean getActivarret_fuente1_retenidoSriFacturasProveedoresIva012() {
		return this.activarret_fuente1_retenidoSriFacturasProveedoresIva012;
	}

	public void setActivarret_fuente1_retenidoSriFacturasProveedoresIva012(Boolean activarret_fuente1_retenidoSriFacturasProveedoresIva012) {
		this.activarret_fuente1_retenidoSriFacturasProveedoresIva012= activarret_fuente1_retenidoSriFacturasProveedoresIva012;
	}

	public Border setResaltarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012() {
		return this.resaltarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012;
	}

	public void setResaltarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012() {
		return this.mostrarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012;
	}

	public void setMostrarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012(Boolean mostrarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012) {
		this.mostrarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012= mostrarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012;
	}

	public Boolean getActivarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012() {
		return this.activarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012;
	}

	public void setActivarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012(Boolean activarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012) {
		this.activarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012= activarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012;
	}

	public Border setResaltarret_fuente2_porcentajeSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarret_fuente2_porcentajeSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarret_fuente2_porcentajeSriFacturasProveedoresIva012() {
		return this.resaltarret_fuente2_porcentajeSriFacturasProveedoresIva012;
	}

	public void setResaltarret_fuente2_porcentajeSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarret_fuente2_porcentajeSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarret_fuente2_porcentajeSriFacturasProveedoresIva012() {
		return this.mostrarret_fuente2_porcentajeSriFacturasProveedoresIva012;
	}

	public void setMostrarret_fuente2_porcentajeSriFacturasProveedoresIva012(Boolean mostrarret_fuente2_porcentajeSriFacturasProveedoresIva012) {
		this.mostrarret_fuente2_porcentajeSriFacturasProveedoresIva012= mostrarret_fuente2_porcentajeSriFacturasProveedoresIva012;
	}

	public Boolean getActivarret_fuente2_porcentajeSriFacturasProveedoresIva012() {
		return this.activarret_fuente2_porcentajeSriFacturasProveedoresIva012;
	}

	public void setActivarret_fuente2_porcentajeSriFacturasProveedoresIva012(Boolean activarret_fuente2_porcentajeSriFacturasProveedoresIva012) {
		this.activarret_fuente2_porcentajeSriFacturasProveedoresIva012= activarret_fuente2_porcentajeSriFacturasProveedoresIva012;
	}

	public Border setResaltarret_fuente2_retenidoSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarret_fuente2_retenidoSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarret_fuente2_retenidoSriFacturasProveedoresIva012() {
		return this.resaltarret_fuente2_retenidoSriFacturasProveedoresIva012;
	}

	public void setResaltarret_fuente2_retenidoSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarret_fuente2_retenidoSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarret_fuente2_retenidoSriFacturasProveedoresIva012() {
		return this.mostrarret_fuente2_retenidoSriFacturasProveedoresIva012;
	}

	public void setMostrarret_fuente2_retenidoSriFacturasProveedoresIva012(Boolean mostrarret_fuente2_retenidoSriFacturasProveedoresIva012) {
		this.mostrarret_fuente2_retenidoSriFacturasProveedoresIva012= mostrarret_fuente2_retenidoSriFacturasProveedoresIva012;
	}

	public Boolean getActivarret_fuente2_retenidoSriFacturasProveedoresIva012() {
		return this.activarret_fuente2_retenidoSriFacturasProveedoresIva012;
	}

	public void setActivarret_fuente2_retenidoSriFacturasProveedoresIva012(Boolean activarret_fuente2_retenidoSriFacturasProveedoresIva012) {
		this.activarret_fuente2_retenidoSriFacturasProveedoresIva012= activarret_fuente2_retenidoSriFacturasProveedoresIva012;
	}

	public Border setResaltarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012() {
		return this.resaltarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012;
	}

	public void setResaltarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012() {
		return this.mostrarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012;
	}

	public void setMostrarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012(Boolean mostrarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012) {
		this.mostrarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012= mostrarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012;
	}

	public Boolean getActivarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012() {
		return this.activarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012;
	}

	public void setActivarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012(Boolean activarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012) {
		this.activarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012= activarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012;
	}

	public Border setResaltarret_iva_bien_porcentajeSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarret_iva_bien_porcentajeSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarret_iva_bien_porcentajeSriFacturasProveedoresIva012() {
		return this.resaltarret_iva_bien_porcentajeSriFacturasProveedoresIva012;
	}

	public void setResaltarret_iva_bien_porcentajeSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarret_iva_bien_porcentajeSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarret_iva_bien_porcentajeSriFacturasProveedoresIva012() {
		return this.mostrarret_iva_bien_porcentajeSriFacturasProveedoresIva012;
	}

	public void setMostrarret_iva_bien_porcentajeSriFacturasProveedoresIva012(Boolean mostrarret_iva_bien_porcentajeSriFacturasProveedoresIva012) {
		this.mostrarret_iva_bien_porcentajeSriFacturasProveedoresIva012= mostrarret_iva_bien_porcentajeSriFacturasProveedoresIva012;
	}

	public Boolean getActivarret_iva_bien_porcentajeSriFacturasProveedoresIva012() {
		return this.activarret_iva_bien_porcentajeSriFacturasProveedoresIva012;
	}

	public void setActivarret_iva_bien_porcentajeSriFacturasProveedoresIva012(Boolean activarret_iva_bien_porcentajeSriFacturasProveedoresIva012) {
		this.activarret_iva_bien_porcentajeSriFacturasProveedoresIva012= activarret_iva_bien_porcentajeSriFacturasProveedoresIva012;
	}

	public Border setResaltarret_iva_bien_retenidoSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarret_iva_bien_retenidoSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarret_iva_bien_retenidoSriFacturasProveedoresIva012() {
		return this.resaltarret_iva_bien_retenidoSriFacturasProveedoresIva012;
	}

	public void setResaltarret_iva_bien_retenidoSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarret_iva_bien_retenidoSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarret_iva_bien_retenidoSriFacturasProveedoresIva012() {
		return this.mostrarret_iva_bien_retenidoSriFacturasProveedoresIva012;
	}

	public void setMostrarret_iva_bien_retenidoSriFacturasProveedoresIva012(Boolean mostrarret_iva_bien_retenidoSriFacturasProveedoresIva012) {
		this.mostrarret_iva_bien_retenidoSriFacturasProveedoresIva012= mostrarret_iva_bien_retenidoSriFacturasProveedoresIva012;
	}

	public Boolean getActivarret_iva_bien_retenidoSriFacturasProveedoresIva012() {
		return this.activarret_iva_bien_retenidoSriFacturasProveedoresIva012;
	}

	public void setActivarret_iva_bien_retenidoSriFacturasProveedoresIva012(Boolean activarret_iva_bien_retenidoSriFacturasProveedoresIva012) {
		this.activarret_iva_bien_retenidoSriFacturasProveedoresIva012= activarret_iva_bien_retenidoSriFacturasProveedoresIva012;
	}

	public Border setResaltarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012() {
		return this.resaltarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012;
	}

	public void setResaltarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012() {
		return this.mostrarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012;
	}

	public void setMostrarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012(Boolean mostrarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012) {
		this.mostrarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012= mostrarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012;
	}

	public Boolean getActivarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012() {
		return this.activarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012;
	}

	public void setActivarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012(Boolean activarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012) {
		this.activarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012= activarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012;
	}

	public Border setResaltarret_iva_servicio_porcentajeSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarret_iva_servicio_porcentajeSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarret_iva_servicio_porcentajeSriFacturasProveedoresIva012() {
		return this.resaltarret_iva_servicio_porcentajeSriFacturasProveedoresIva012;
	}

	public void setResaltarret_iva_servicio_porcentajeSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarret_iva_servicio_porcentajeSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarret_iva_servicio_porcentajeSriFacturasProveedoresIva012() {
		return this.mostrarret_iva_servicio_porcentajeSriFacturasProveedoresIva012;
	}

	public void setMostrarret_iva_servicio_porcentajeSriFacturasProveedoresIva012(Boolean mostrarret_iva_servicio_porcentajeSriFacturasProveedoresIva012) {
		this.mostrarret_iva_servicio_porcentajeSriFacturasProveedoresIva012= mostrarret_iva_servicio_porcentajeSriFacturasProveedoresIva012;
	}

	public Boolean getActivarret_iva_servicio_porcentajeSriFacturasProveedoresIva012() {
		return this.activarret_iva_servicio_porcentajeSriFacturasProveedoresIva012;
	}

	public void setActivarret_iva_servicio_porcentajeSriFacturasProveedoresIva012(Boolean activarret_iva_servicio_porcentajeSriFacturasProveedoresIva012) {
		this.activarret_iva_servicio_porcentajeSriFacturasProveedoresIva012= activarret_iva_servicio_porcentajeSriFacturasProveedoresIva012;
	}

	public Border setResaltarret_iva_servicio_retenidoSriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresiva012BeanSwingJInternalFrame.jTtoolBarSriFacturasProveedoresIva012.setBorder(borderResaltar);
		
		this.resaltarret_iva_servicio_retenidoSriFacturasProveedoresIva012= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarret_iva_servicio_retenidoSriFacturasProveedoresIva012() {
		return this.resaltarret_iva_servicio_retenidoSriFacturasProveedoresIva012;
	}

	public void setResaltarret_iva_servicio_retenidoSriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarret_iva_servicio_retenidoSriFacturasProveedoresIva012= borderResaltar;
	}

	public Boolean getMostrarret_iva_servicio_retenidoSriFacturasProveedoresIva012() {
		return this.mostrarret_iva_servicio_retenidoSriFacturasProveedoresIva012;
	}

	public void setMostrarret_iva_servicio_retenidoSriFacturasProveedoresIva012(Boolean mostrarret_iva_servicio_retenidoSriFacturasProveedoresIva012) {
		this.mostrarret_iva_servicio_retenidoSriFacturasProveedoresIva012= mostrarret_iva_servicio_retenidoSriFacturasProveedoresIva012;
	}

	public Boolean getActivarret_iva_servicio_retenidoSriFacturasProveedoresIva012() {
		return this.activarret_iva_servicio_retenidoSriFacturasProveedoresIva012;
	}

	public void setActivarret_iva_servicio_retenidoSriFacturasProveedoresIva012(Boolean activarret_iva_servicio_retenidoSriFacturasProveedoresIva012) {
		this.activarret_iva_servicio_retenidoSriFacturasProveedoresIva012= activarret_iva_servicio_retenidoSriFacturasProveedoresIva012;
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
		
		
		this.setMostraridSriFacturasProveedoresIva012(esInicial);
		this.setMostrarid_empresaSriFacturasProveedoresIva012(esInicial);
		this.setMostrarid_periodo_declaraSriFacturasProveedoresIva012(esInicial);
		this.setMostrarrucSriFacturasProveedoresIva012(esInicial);
		this.setMostrarnombre_tipo_comprobanteSriFacturasProveedoresIva012(esInicial);
		this.setMostrarnombre_completo_clienteSriFacturasProveedoresIva012(esInicial);
		this.setMostrarruc_datoSriFacturasProveedoresIva012(esInicial);
		this.setMostrarnumero_documentoSriFacturasProveedoresIva012(esInicial);
		this.setMostrarfecha_emisionSriFacturasProveedoresIva012(esInicial);
		this.setMostrarfecha_registro_contableSriFacturasProveedoresIva012(esInicial);
		this.setMostrarnumero_serieSriFacturasProveedoresIva012(esInicial);
		this.setMostrartotal_ivaSriFacturasProveedoresIva012(esInicial);
		this.setMostrartotal_sin_ivaSriFacturasProveedoresIva012(esInicial);
		this.setMostrarid_tipo_ivaSriFacturasProveedoresIva012(esInicial);
		this.setMostrarid_tipo_retencion_ivaSriFacturasProveedoresIva012(esInicial);
		this.setMostrartransfe_iva_retenidoSriFacturasProveedoresIva012(esInicial);
		this.setMostrarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012(esInicial);
		this.setMostrarpresta_iva_retenidoSriFacturasProveedoresIva012(esInicial);
		this.setMostrarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012(esInicial);
		this.setMostrarret_fuente1_porcentajeSriFacturasProveedoresIva012(esInicial);
		this.setMostrarret_fuente1_retenidoSriFacturasProveedoresIva012(esInicial);
		this.setMostrarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012(esInicial);
		this.setMostrarret_fuente2_porcentajeSriFacturasProveedoresIva012(esInicial);
		this.setMostrarret_fuente2_retenidoSriFacturasProveedoresIva012(esInicial);
		this.setMostrarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012(esInicial);
		this.setMostrarret_iva_bien_porcentajeSriFacturasProveedoresIva012(esInicial);
		this.setMostrarret_iva_bien_retenidoSriFacturasProveedoresIva012(esInicial);
		this.setMostrarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012(esInicial);
		this.setMostrarret_iva_servicio_porcentajeSriFacturasProveedoresIva012(esInicial);
		this.setMostrarret_iva_servicio_retenidoSriFacturasProveedoresIva012(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.ID)) {
				this.setMostraridSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.IDPERIODODECLARA)) {
				this.setMostrarid_periodo_declaraSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RUC)) {
				this.setMostrarrucSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPOCOMPROBANTE)) {
				this.setMostrarnombre_tipo_comprobanteSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clienteSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RUCDATO)) {
				this.setMostrarruc_datoSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NUMERODOCUMENTO)) {
				this.setMostrarnumero_documentoSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.FECHAREGISTROCONTABLE)) {
				this.setMostrarfecha_registro_contableSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NUMEROSERIE)) {
				this.setMostrarnumero_serieSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.TOTALIVA)) {
				this.setMostrartotal_ivaSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.TOTALSINIVA)) {
				this.setMostrartotal_sin_ivaSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.IDTIPOIVA)) {
				this.setMostrarid_tipo_ivaSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.IDTIPORETENCIONIVA)) {
				this.setMostrarid_tipo_retencion_ivaSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.TRANSFEIVARETENIDO)) {
				this.setMostrartransfe_iva_retenidoSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.IDTIPORETENCIONIVAPRESTA)) {
				this.setMostrarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.PRESTAIVARETENIDO)) {
				this.setMostrarpresta_iva_retenidoSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONFUENTE1)) {
				this.setMostrarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE1PORCENTAJE)) {
				this.setMostrarret_fuente1_porcentajeSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE1RETENIDO)) {
				this.setMostrarret_fuente1_retenidoSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONFUENTE2)) {
				this.setMostrarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE2PORCENTAJE)) {
				this.setMostrarret_fuente2_porcentajeSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE2RETENIDO)) {
				this.setMostrarret_fuente2_retenidoSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONIVA1)) {
				this.setMostrarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETIVABIENPORCENTAJE)) {
				this.setMostrarret_iva_bien_porcentajeSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETIVABIENRETENIDO)) {
				this.setMostrarret_iva_bien_retenidoSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONIVA2)) {
				this.setMostrarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETIVASERVICIOPORCENTAJE)) {
				this.setMostrarret_iva_servicio_porcentajeSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETIVASERVICIORETENIDO)) {
				this.setMostrarret_iva_servicio_retenidoSriFacturasProveedoresIva012(esAsigna);
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
		
		
		this.setActivaridSriFacturasProveedoresIva012(esInicial);
		this.setActivarid_empresaSriFacturasProveedoresIva012(esInicial);
		this.setActivarid_periodo_declaraSriFacturasProveedoresIva012(esInicial);
		this.setActivarrucSriFacturasProveedoresIva012(esInicial);
		this.setActivarnombre_tipo_comprobanteSriFacturasProveedoresIva012(esInicial);
		this.setActivarnombre_completo_clienteSriFacturasProveedoresIva012(esInicial);
		this.setActivarruc_datoSriFacturasProveedoresIva012(esInicial);
		this.setActivarnumero_documentoSriFacturasProveedoresIva012(esInicial);
		this.setActivarfecha_emisionSriFacturasProveedoresIva012(esInicial);
		this.setActivarfecha_registro_contableSriFacturasProveedoresIva012(esInicial);
		this.setActivarnumero_serieSriFacturasProveedoresIva012(esInicial);
		this.setActivartotal_ivaSriFacturasProveedoresIva012(esInicial);
		this.setActivartotal_sin_ivaSriFacturasProveedoresIva012(esInicial);
		this.setActivarid_tipo_ivaSriFacturasProveedoresIva012(esInicial);
		this.setActivarid_tipo_retencion_ivaSriFacturasProveedoresIva012(esInicial);
		this.setActivartransfe_iva_retenidoSriFacturasProveedoresIva012(esInicial);
		this.setActivarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012(esInicial);
		this.setActivarpresta_iva_retenidoSriFacturasProveedoresIva012(esInicial);
		this.setActivarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012(esInicial);
		this.setActivarret_fuente1_porcentajeSriFacturasProveedoresIva012(esInicial);
		this.setActivarret_fuente1_retenidoSriFacturasProveedoresIva012(esInicial);
		this.setActivarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012(esInicial);
		this.setActivarret_fuente2_porcentajeSriFacturasProveedoresIva012(esInicial);
		this.setActivarret_fuente2_retenidoSriFacturasProveedoresIva012(esInicial);
		this.setActivarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012(esInicial);
		this.setActivarret_iva_bien_porcentajeSriFacturasProveedoresIva012(esInicial);
		this.setActivarret_iva_bien_retenidoSriFacturasProveedoresIva012(esInicial);
		this.setActivarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012(esInicial);
		this.setActivarret_iva_servicio_porcentajeSriFacturasProveedoresIva012(esInicial);
		this.setActivarret_iva_servicio_retenidoSriFacturasProveedoresIva012(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.ID)) {
				this.setActivaridSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.IDPERIODODECLARA)) {
				this.setActivarid_periodo_declaraSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RUC)) {
				this.setActivarrucSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPOCOMPROBANTE)) {
				this.setActivarnombre_tipo_comprobanteSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clienteSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RUCDATO)) {
				this.setActivarruc_datoSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NUMERODOCUMENTO)) {
				this.setActivarnumero_documentoSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.FECHAREGISTROCONTABLE)) {
				this.setActivarfecha_registro_contableSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NUMEROSERIE)) {
				this.setActivarnumero_serieSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.TOTALIVA)) {
				this.setActivartotal_ivaSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.TOTALSINIVA)) {
				this.setActivartotal_sin_ivaSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.IDTIPOIVA)) {
				this.setActivarid_tipo_ivaSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.IDTIPORETENCIONIVA)) {
				this.setActivarid_tipo_retencion_ivaSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.TRANSFEIVARETENIDO)) {
				this.setActivartransfe_iva_retenidoSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.IDTIPORETENCIONIVAPRESTA)) {
				this.setActivarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.PRESTAIVARETENIDO)) {
				this.setActivarpresta_iva_retenidoSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONFUENTE1)) {
				this.setActivarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE1PORCENTAJE)) {
				this.setActivarret_fuente1_porcentajeSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE1RETENIDO)) {
				this.setActivarret_fuente1_retenidoSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONFUENTE2)) {
				this.setActivarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE2PORCENTAJE)) {
				this.setActivarret_fuente2_porcentajeSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE2RETENIDO)) {
				this.setActivarret_fuente2_retenidoSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONIVA1)) {
				this.setActivarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETIVABIENPORCENTAJE)) {
				this.setActivarret_iva_bien_porcentajeSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETIVABIENRETENIDO)) {
				this.setActivarret_iva_bien_retenidoSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONIVA2)) {
				this.setActivarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETIVASERVICIOPORCENTAJE)) {
				this.setActivarret_iva_servicio_porcentajeSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETIVASERVICIORETENIDO)) {
				this.setActivarret_iva_servicio_retenidoSriFacturasProveedoresIva012(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSriFacturasProveedoresIva012(esInicial);
		this.setResaltarid_empresaSriFacturasProveedoresIva012(esInicial);
		this.setResaltarid_periodo_declaraSriFacturasProveedoresIva012(esInicial);
		this.setResaltarrucSriFacturasProveedoresIva012(esInicial);
		this.setResaltarnombre_tipo_comprobanteSriFacturasProveedoresIva012(esInicial);
		this.setResaltarnombre_completo_clienteSriFacturasProveedoresIva012(esInicial);
		this.setResaltarruc_datoSriFacturasProveedoresIva012(esInicial);
		this.setResaltarnumero_documentoSriFacturasProveedoresIva012(esInicial);
		this.setResaltarfecha_emisionSriFacturasProveedoresIva012(esInicial);
		this.setResaltarfecha_registro_contableSriFacturasProveedoresIva012(esInicial);
		this.setResaltarnumero_serieSriFacturasProveedoresIva012(esInicial);
		this.setResaltartotal_ivaSriFacturasProveedoresIva012(esInicial);
		this.setResaltartotal_sin_ivaSriFacturasProveedoresIva012(esInicial);
		this.setResaltarid_tipo_ivaSriFacturasProveedoresIva012(esInicial);
		this.setResaltarid_tipo_retencion_ivaSriFacturasProveedoresIva012(esInicial);
		this.setResaltartransfe_iva_retenidoSriFacturasProveedoresIva012(esInicial);
		this.setResaltarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012(esInicial);
		this.setResaltarpresta_iva_retenidoSriFacturasProveedoresIva012(esInicial);
		this.setResaltarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012(esInicial);
		this.setResaltarret_fuente1_porcentajeSriFacturasProveedoresIva012(esInicial);
		this.setResaltarret_fuente1_retenidoSriFacturasProveedoresIva012(esInicial);
		this.setResaltarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012(esInicial);
		this.setResaltarret_fuente2_porcentajeSriFacturasProveedoresIva012(esInicial);
		this.setResaltarret_fuente2_retenidoSriFacturasProveedoresIva012(esInicial);
		this.setResaltarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012(esInicial);
		this.setResaltarret_iva_bien_porcentajeSriFacturasProveedoresIva012(esInicial);
		this.setResaltarret_iva_bien_retenidoSriFacturasProveedoresIva012(esInicial);
		this.setResaltarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012(esInicial);
		this.setResaltarret_iva_servicio_porcentajeSriFacturasProveedoresIva012(esInicial);
		this.setResaltarret_iva_servicio_retenidoSriFacturasProveedoresIva012(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.ID)) {
				this.setResaltaridSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.IDPERIODODECLARA)) {
				this.setResaltarid_periodo_declaraSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RUC)) {
				this.setResaltarrucSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPOCOMPROBANTE)) {
				this.setResaltarnombre_tipo_comprobanteSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clienteSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RUCDATO)) {
				this.setResaltarruc_datoSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NUMERODOCUMENTO)) {
				this.setResaltarnumero_documentoSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.FECHAREGISTROCONTABLE)) {
				this.setResaltarfecha_registro_contableSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NUMEROSERIE)) {
				this.setResaltarnumero_serieSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.TOTALIVA)) {
				this.setResaltartotal_ivaSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.TOTALSINIVA)) {
				this.setResaltartotal_sin_ivaSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.IDTIPOIVA)) {
				this.setResaltarid_tipo_ivaSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.IDTIPORETENCIONIVA)) {
				this.setResaltarid_tipo_retencion_ivaSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.TRANSFEIVARETENIDO)) {
				this.setResaltartransfe_iva_retenidoSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.IDTIPORETENCIONIVAPRESTA)) {
				this.setResaltarid_tipo_retencion_iva_prestaSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.PRESTAIVARETENIDO)) {
				this.setResaltarpresta_iva_retenidoSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONFUENTE1)) {
				this.setResaltarnombre_tipo_retencion_fuente1SriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE1PORCENTAJE)) {
				this.setResaltarret_fuente1_porcentajeSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE1RETENIDO)) {
				this.setResaltarret_fuente1_retenidoSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONFUENTE2)) {
				this.setResaltarnombre_tipo_retencion_fuente2SriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE2PORCENTAJE)) {
				this.setResaltarret_fuente2_porcentajeSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE2RETENIDO)) {
				this.setResaltarret_fuente2_retenidoSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONIVA1)) {
				this.setResaltarnombre_tipo_retencion_iva1SriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETIVABIENPORCENTAJE)) {
				this.setResaltarret_iva_bien_porcentajeSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETIVABIENRETENIDO)) {
				this.setResaltarret_iva_bien_retenidoSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONIVA2)) {
				this.setResaltarnombre_tipo_retencion_iva2SriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETIVASERVICIOPORCENTAJE)) {
				this.setResaltarret_iva_servicio_porcentajeSriFacturasProveedoresIva012(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresIva012ConstantesFunciones.RETIVASERVICIORETENIDO)) {
				this.setResaltarret_iva_servicio_retenidoSriFacturasProveedoresIva012(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaSriFacturasProveedoresIva012SriFacturasProveedoresIva012=true;

	public Boolean getMostrarBusquedaSriFacturasProveedoresIva012SriFacturasProveedoresIva012() {
		return this.mostrarBusquedaSriFacturasProveedoresIva012SriFacturasProveedoresIva012;
	}

	public void setMostrarBusquedaSriFacturasProveedoresIva012SriFacturasProveedoresIva012(Boolean visibilidadResaltar) {
		this.mostrarBusquedaSriFacturasProveedoresIva012SriFacturasProveedoresIva012= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaSriFacturasProveedoresIva012SriFacturasProveedoresIva012=true;

	public Boolean getActivarBusquedaSriFacturasProveedoresIva012SriFacturasProveedoresIva012() {
		return this.activarBusquedaSriFacturasProveedoresIva012SriFacturasProveedoresIva012;
	}

	public void setActivarBusquedaSriFacturasProveedoresIva012SriFacturasProveedoresIva012(Boolean habilitarResaltar) {
		this.activarBusquedaSriFacturasProveedoresIva012SriFacturasProveedoresIva012= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaSriFacturasProveedoresIva012SriFacturasProveedoresIva012=null;

	public Border getResaltarBusquedaSriFacturasProveedoresIva012SriFacturasProveedoresIva012() {
		return this.resaltarBusquedaSriFacturasProveedoresIva012SriFacturasProveedoresIva012;
	}

	public void setResaltarBusquedaSriFacturasProveedoresIva012SriFacturasProveedoresIva012(Border borderResaltar) {
		this.resaltarBusquedaSriFacturasProveedoresIva012SriFacturasProveedoresIva012= borderResaltar;
	}

	public void setResaltarBusquedaSriFacturasProveedoresIva012SriFacturasProveedoresIva012(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresIva012BeanSwingJInternalFrame srifacturasproveedoresiva012BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaSriFacturasProveedoresIva012SriFacturasProveedoresIva012= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}