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


import com.bydan.erp.sris.util.report.SriComprasConstantesFunciones;
import com.bydan.erp.sris.util.report.SriComprasParameterReturnGeneral;
//import com.bydan.erp.sris.util.report.SriComprasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.sris.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.sris.business.dataaccess.*;
//import com.bydan.erp.sris.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class SriComprasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="SriCompras";
	public static final String SPATHOPCION="Sris";	
	public static final String SPATHMODULO="sris/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="SriCompras"+SriComprasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SriComprasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SriComprasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SriComprasConstantesFunciones.SCHEMA+"_"+SriComprasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SriComprasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SriComprasConstantesFunciones.SCHEMA+"_"+SriComprasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SriComprasConstantesFunciones.SCHEMA+"_"+SriComprasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SriComprasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SriComprasConstantesFunciones.SCHEMA+"_"+SriComprasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriComprasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SriComprasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriComprasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriComprasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SriComprasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriComprasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SriComprasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SriComprasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SriComprasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SriComprasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Sri Comprases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Sri Compras";
	public static final String SCLASSWEBTITULO_LOWER="Sri Compras";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="SriCompras";
	public static final String OBJECTNAME="sricompras";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SRIS;	
	public static final String TABLENAME="sri_compras";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select sricompras from "+SriComprasConstantesFunciones.SPERSISTENCENAME+" sricompras";
	public static String QUERYSELECTNATIVE="select "+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".id,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".version_row,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".id_empresa,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".id_periodo_declara,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".id_cliente,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".ruc,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".nombre_tipo_comprobante,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".ruc_dato,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".numero_documento,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".fecha_emision,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".fecha_registro_contable,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".numero_serie,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".numero_autorizacion,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".bienes_iva,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".servicion_iva,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".total_iva,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".bienes_sin_iva,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".servicios_sin_iva,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".total_sin_iva,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".id_tipo_iva,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".monto_iva,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".monto_ice,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".transfe_iva_retener,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".id_tipo_retencion_iva,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".transfe_iva_retenido,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".presta_iva_retener,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".id_tipo_retencion_iva_presta,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".presta_iva_retenido,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".fecha_caducidad,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".codigo_asiento_contable,"+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME+".numero_documento_contable from "+SriComprasConstantesFunciones.SCHEMA+"."+SriComprasConstantesFunciones.TABLENAME;//+" as "+SriComprasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDPERIODODECLARA= "id_periodo_declara";
    public static final String IDCLIENTE= "id_cliente";
    public static final String RUC= "ruc";
    public static final String NOMBRETIPOCOMPROBANTE= "nombre_tipo_comprobante";
    public static final String NOMBRECOMPLETOCLIENTE= "nombre_completo_cliente";
    public static final String RUCDATO= "ruc_dato";
    public static final String NUMERODOCUMENTO= "numero_documento";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAREGISTROCONTABLE= "fecha_registro_contable";
    public static final String NUMEROSERIE= "numero_serie";
    public static final String NUMEROAUTORIZACION= "numero_autorizacion";
    public static final String BIENESIVA= "bienes_iva";
    public static final String SERVICIONIVA= "servicion_iva";
    public static final String TOTALIVA= "total_iva";
    public static final String BIENESSINIVA= "bienes_sin_iva";
    public static final String SERVICIOSSINIVA= "servicios_sin_iva";
    public static final String TOTALSINIVA= "total_sin_iva";
    public static final String IDTIPOIVA= "id_tipo_iva";
    public static final String MONTOIVA= "monto_iva";
    public static final String MONTOICE= "monto_ice";
    public static final String TRANSFEIVARETENER= "transfe_iva_retener";
    public static final String IDTIPORETENCIONIVA= "id_tipo_retencion_iva";
    public static final String TRANSFEIVARETENIDO= "transfe_iva_retenido";
    public static final String PRESTAIVARETENER= "presta_iva_retener";
    public static final String IDTIPORETENCIONIVAPRESTA= "id_tipo_retencion_iva_presta";
    public static final String PRESTAIVARETENIDO= "presta_iva_retenido";
    public static final String FECHACADUCIDAD= "fecha_caducidad";
    public static final String CODIGOASIENTOCONTABLE= "codigo_asiento_contable";
    public static final String NUMERODOCUMENTOCONTABLE= "numero_documento_contable";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDPERIODODECLARA= "Periodo Declara";
		public static final String LABEL_IDPERIODODECLARA_LOWER= "Periodo Declara";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
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
    	public static final String LABEL_NUMEROAUTORIZACION= "Numero Autorizacion";
		public static final String LABEL_NUMEROAUTORIZACION_LOWER= "Numero Autorizacion";
    	public static final String LABEL_BIENESIVA= "Bienes Iva";
		public static final String LABEL_BIENESIVA_LOWER= "Bienes Iva";
    	public static final String LABEL_SERVICIONIVA= "Servicion Iva";
		public static final String LABEL_SERVICIONIVA_LOWER= "Servicion Iva";
    	public static final String LABEL_TOTALIVA= "Total Iva";
		public static final String LABEL_TOTALIVA_LOWER= "Total Iva";
    	public static final String LABEL_BIENESSINIVA= "Bienes Sin Iva";
		public static final String LABEL_BIENESSINIVA_LOWER= "Bienes Sin Iva";
    	public static final String LABEL_SERVICIOSSINIVA= "Servicios Sin Iva";
		public static final String LABEL_SERVICIOSSINIVA_LOWER= "Servicios Sin Iva";
    	public static final String LABEL_TOTALSINIVA= "Total Sin Iva";
		public static final String LABEL_TOTALSINIVA_LOWER= "Total Sin Iva";
    	public static final String LABEL_IDTIPOIVA= "Tipo Iva";
		public static final String LABEL_IDTIPOIVA_LOWER= "Tipo Iva";
    	public static final String LABEL_MONTOIVA= "Monto Iva";
		public static final String LABEL_MONTOIVA_LOWER= "Monto Iva";
    	public static final String LABEL_MONTOICE= "Monto Ice";
		public static final String LABEL_MONTOICE_LOWER= "Monto Ice";
    	public static final String LABEL_TRANSFEIVARETENER= "Transfe Iva Retener";
		public static final String LABEL_TRANSFEIVARETENER_LOWER= "Transfe Iva Retener";
    	public static final String LABEL_IDTIPORETENCIONIVA= "Tipo Retencion Iva";
		public static final String LABEL_IDTIPORETENCIONIVA_LOWER= "Tipo Retencion Iva";
    	public static final String LABEL_TRANSFEIVARETENIDO= "Transfe Iva Reteno";
		public static final String LABEL_TRANSFEIVARETENIDO_LOWER= "Transfe Iva Retenido";
    	public static final String LABEL_PRESTAIVARETENER= "Presta Iva Retener";
		public static final String LABEL_PRESTAIVARETENER_LOWER= "Presta Iva Retener";
    	public static final String LABEL_IDTIPORETENCIONIVAPRESTA= "Tipo Retencion Iva Presta";
		public static final String LABEL_IDTIPORETENCIONIVAPRESTA_LOWER= "Tipo Retencion Iva Presta";
    	public static final String LABEL_PRESTAIVARETENIDO= "Presta Iva Reteno";
		public static final String LABEL_PRESTAIVARETENIDO_LOWER= "Presta Iva Retenido";
    	public static final String LABEL_FECHACADUCIDAD= "Fecha Caducad";
		public static final String LABEL_FECHACADUCIDAD_LOWER= "Fecha Caducidad";
    	public static final String LABEL_CODIGOASIENTOCONTABLE= "Codigo Asiento Contable";
		public static final String LABEL_CODIGOASIENTOCONTABLE_LOWER= "Codigo Asiento Contable";
    	public static final String LABEL_NUMERODOCUMENTOCONTABLE= "Numero Documento Contable";
		public static final String LABEL_NUMERODOCUMENTOCONTABLE_LOWER= "Numero Documento Contable";
	
		
		
		
		
		
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
	public static final String SREGEXNUMERO_AUTORIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_AUTORIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO_ASIENTO_CONTABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_ASIENTO_CONTABLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_DOCUMENTO_CONTABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_DOCUMENTO_CONTABLE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getSriComprasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SriComprasConstantesFunciones.IDEMPRESA)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.IDPERIODODECLARA)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_IDPERIODODECLARA;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.IDCLIENTE)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.RUC)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.NOMBRETIPOCOMPROBANTE)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_NOMBRETIPOCOMPROBANTE;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.RUCDATO)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_RUCDATO;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.NUMERODOCUMENTO)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_NUMERODOCUMENTO;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.FECHAEMISION)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.FECHAREGISTROCONTABLE)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_FECHAREGISTROCONTABLE;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.NUMEROSERIE)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_NUMEROSERIE;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.NUMEROAUTORIZACION)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_NUMEROAUTORIZACION;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.BIENESIVA)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_BIENESIVA;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.SERVICIONIVA)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_SERVICIONIVA;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.TOTALIVA)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_TOTALIVA;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.BIENESSINIVA)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_BIENESSINIVA;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.SERVICIOSSINIVA)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_SERVICIOSSINIVA;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.TOTALSINIVA)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_TOTALSINIVA;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.IDTIPOIVA)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_IDTIPOIVA;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.MONTOIVA)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_MONTOIVA;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.MONTOICE)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_MONTOICE;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.TRANSFEIVARETENER)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_TRANSFEIVARETENER;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.IDTIPORETENCIONIVA)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_IDTIPORETENCIONIVA;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.TRANSFEIVARETENIDO)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_TRANSFEIVARETENIDO;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.PRESTAIVARETENER)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_PRESTAIVARETENER;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.IDTIPORETENCIONIVAPRESTA)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_IDTIPORETENCIONIVAPRESTA;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.PRESTAIVARETENIDO)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_PRESTAIVARETENIDO;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.FECHACADUCIDAD)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_FECHACADUCIDAD;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.CODIGOASIENTOCONTABLE)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_CODIGOASIENTOCONTABLE;}
		if(sNombreColumna.equals(SriComprasConstantesFunciones.NUMERODOCUMENTOCONTABLE)) {sLabelColumna=SriComprasConstantesFunciones.LABEL_NUMERODOCUMENTOCONTABLE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getSriComprasDescripcion(SriCompras sricompras) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(sricompras !=null/* && sricompras.getId()!=0*/) {
			if(sricompras.getId()!=null) {
				sDescripcion=sricompras.getId().toString();
			}//sricomprassricompras.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getSriComprasDescripcionDetallado(SriCompras sricompras) {
		String sDescripcion="";
			
		sDescripcion+=SriComprasConstantesFunciones.ID+"=";
		sDescripcion+=sricompras.getId().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=sricompras.getVersionRow().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=sricompras.getid_empresa().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.IDPERIODODECLARA+"=";
		sDescripcion+=sricompras.getid_periodo_declara().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=sricompras.getid_cliente().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.RUC+"=";
		sDescripcion+=sricompras.getruc()+",";
		sDescripcion+=SriComprasConstantesFunciones.NOMBRETIPOCOMPROBANTE+"=";
		sDescripcion+=sricompras.getnombre_tipo_comprobante()+",";
		sDescripcion+=SriComprasConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=sricompras.getnombre_completo_cliente()+",";
		sDescripcion+=SriComprasConstantesFunciones.RUCDATO+"=";
		sDescripcion+=sricompras.getruc_dato()+",";
		sDescripcion+=SriComprasConstantesFunciones.NUMERODOCUMENTO+"=";
		sDescripcion+=sricompras.getnumero_documento()+",";
		sDescripcion+=SriComprasConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=sricompras.getfecha_emision().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.FECHAREGISTROCONTABLE+"=";
		sDescripcion+=sricompras.getfecha_registro_contable().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.NUMEROSERIE+"=";
		sDescripcion+=sricompras.getnumero_serie()+",";
		sDescripcion+=SriComprasConstantesFunciones.NUMEROAUTORIZACION+"=";
		sDescripcion+=sricompras.getnumero_autorizacion()+",";
		sDescripcion+=SriComprasConstantesFunciones.BIENESIVA+"=";
		sDescripcion+=sricompras.getbienes_iva().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.SERVICIONIVA+"=";
		sDescripcion+=sricompras.getservicion_iva().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.TOTALIVA+"=";
		sDescripcion+=sricompras.gettotal_iva().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.BIENESSINIVA+"=";
		sDescripcion+=sricompras.getbienes_sin_iva().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.SERVICIOSSINIVA+"=";
		sDescripcion+=sricompras.getservicios_sin_iva().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.TOTALSINIVA+"=";
		sDescripcion+=sricompras.gettotal_sin_iva().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.IDTIPOIVA+"=";
		sDescripcion+=sricompras.getid_tipo_iva().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.MONTOIVA+"=";
		sDescripcion+=sricompras.getmonto_iva().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.MONTOICE+"=";
		sDescripcion+=sricompras.getmonto_ice().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.TRANSFEIVARETENER+"=";
		sDescripcion+=sricompras.gettransfe_iva_retener().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.IDTIPORETENCIONIVA+"=";
		sDescripcion+=sricompras.getid_tipo_retencion_iva().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.TRANSFEIVARETENIDO+"=";
		sDescripcion+=sricompras.gettransfe_iva_retenido().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.PRESTAIVARETENER+"=";
		sDescripcion+=sricompras.getpresta_iva_retener().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.IDTIPORETENCIONIVAPRESTA+"=";
		sDescripcion+=sricompras.getid_tipo_retencion_iva_presta().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.PRESTAIVARETENIDO+"=";
		sDescripcion+=sricompras.getpresta_iva_retenido().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.FECHACADUCIDAD+"=";
		sDescripcion+=sricompras.getfecha_caducidad().toString()+",";
		sDescripcion+=SriComprasConstantesFunciones.CODIGOASIENTOCONTABLE+"=";
		sDescripcion+=sricompras.getcodigo_asiento_contable()+",";
		sDescripcion+=SriComprasConstantesFunciones.NUMERODOCUMENTOCONTABLE+"=";
		sDescripcion+=sricompras.getnumero_documento_contable()+",";
			
		return sDescripcion;
	}
	
	public static void setSriComprasDescripcion(SriCompras sricompras,String sValor) throws Exception {			
		if(sricompras !=null) {
			//sricomprassricompras.getId().toString();
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

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
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
		} else if(sNombreIndice.equals("BusquedaSriCompras")) {
			sNombreIndice="Tipo=  Por Periodo Declara Por Cliente Por Ruc";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
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

	public static String getDetalleIndiceBusquedaSriCompras(Long id_periodo_declara,Long id_cliente,String ruc) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo_declara!=null) {sDetalleIndice+=" Codigo Unico De Periodo Declara="+id_periodo_declara.toString();}
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();}
		if(ruc!=null) {sDetalleIndice+=" Ruc="+ruc;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosSriCompras(SriCompras sricompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		sricompras.setnombre_tipo_comprobante(sricompras.getnombre_tipo_comprobante().trim());
		sricompras.setnombre_completo_cliente(sricompras.getnombre_completo_cliente().trim());
		sricompras.setruc_dato(sricompras.getruc_dato().trim());
		sricompras.setnumero_documento(sricompras.getnumero_documento().trim());
		sricompras.setnumero_serie(sricompras.getnumero_serie().trim());
		sricompras.setnumero_autorizacion(sricompras.getnumero_autorizacion().trim());
		sricompras.setcodigo_asiento_contable(sricompras.getcodigo_asiento_contable().trim());
		sricompras.setnumero_documento_contable(sricompras.getnumero_documento_contable().trim());
	}
	
	public static void quitarEspaciosSriComprass(List<SriCompras> sricomprass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SriCompras sricompras: sricomprass) {
			sricompras.setnombre_tipo_comprobante(sricompras.getnombre_tipo_comprobante().trim());
			sricompras.setnombre_completo_cliente(sricompras.getnombre_completo_cliente().trim());
			sricompras.setruc_dato(sricompras.getruc_dato().trim());
			sricompras.setnumero_documento(sricompras.getnumero_documento().trim());
			sricompras.setnumero_serie(sricompras.getnumero_serie().trim());
			sricompras.setnumero_autorizacion(sricompras.getnumero_autorizacion().trim());
			sricompras.setcodigo_asiento_contable(sricompras.getcodigo_asiento_contable().trim());
			sricompras.setnumero_documento_contable(sricompras.getnumero_documento_contable().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSriCompras(SriCompras sricompras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && sricompras.getConCambioAuxiliar()) {
			sricompras.setIsDeleted(sricompras.getIsDeletedAuxiliar());	
			sricompras.setIsNew(sricompras.getIsNewAuxiliar());	
			sricompras.setIsChanged(sricompras.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			sricompras.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			sricompras.setIsDeletedAuxiliar(false);	
			sricompras.setIsNewAuxiliar(false);	
			sricompras.setIsChangedAuxiliar(false);
			
			sricompras.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSriComprass(List<SriCompras> sricomprass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(SriCompras sricompras : sricomprass) {
			if(conAsignarBase && sricompras.getConCambioAuxiliar()) {
				sricompras.setIsDeleted(sricompras.getIsDeletedAuxiliar());	
				sricompras.setIsNew(sricompras.getIsNewAuxiliar());	
				sricompras.setIsChanged(sricompras.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				sricompras.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				sricompras.setIsDeletedAuxiliar(false);	
				sricompras.setIsNewAuxiliar(false);	
				sricompras.setIsChangedAuxiliar(false);
				
				sricompras.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSriCompras(SriCompras sricompras,Boolean conEnteros) throws Exception  {
		sricompras.setbienes_iva(0.0);
		sricompras.setservicion_iva(0.0);
		sricompras.settotal_iva(0.0);
		sricompras.setbienes_sin_iva(0.0);
		sricompras.setservicios_sin_iva(0.0);
		sricompras.settotal_sin_iva(0.0);
		sricompras.setmonto_iva(0.0);
		sricompras.setmonto_ice(0.0);
		sricompras.settransfe_iva_retener(0.0);
		sricompras.settransfe_iva_retenido(0.0);
		sricompras.setpresta_iva_retener(0.0);
		sricompras.setpresta_iva_retenido(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSriComprass(List<SriCompras> sricomprass,Boolean conEnteros) throws Exception  {
		
		for(SriCompras sricompras: sricomprass) {
			sricompras.setbienes_iva(0.0);
			sricompras.setservicion_iva(0.0);
			sricompras.settotal_iva(0.0);
			sricompras.setbienes_sin_iva(0.0);
			sricompras.setservicios_sin_iva(0.0);
			sricompras.settotal_sin_iva(0.0);
			sricompras.setmonto_iva(0.0);
			sricompras.setmonto_ice(0.0);
			sricompras.settransfe_iva_retener(0.0);
			sricompras.settransfe_iva_retenido(0.0);
			sricompras.setpresta_iva_retener(0.0);
			sricompras.setpresta_iva_retenido(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSriCompras(List<SriCompras> sricomprass,SriCompras sricomprasAux) throws Exception  {
		SriComprasConstantesFunciones.InicializarValoresSriCompras(sricomprasAux,true);
		
		for(SriCompras sricompras: sricomprass) {
			if(sricompras.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			sricomprasAux.setbienes_iva(sricomprasAux.getbienes_iva()+sricompras.getbienes_iva());			
			sricomprasAux.setservicion_iva(sricomprasAux.getservicion_iva()+sricompras.getservicion_iva());			
			sricomprasAux.settotal_iva(sricomprasAux.gettotal_iva()+sricompras.gettotal_iva());			
			sricomprasAux.setbienes_sin_iva(sricomprasAux.getbienes_sin_iva()+sricompras.getbienes_sin_iva());			
			sricomprasAux.setservicios_sin_iva(sricomprasAux.getservicios_sin_iva()+sricompras.getservicios_sin_iva());			
			sricomprasAux.settotal_sin_iva(sricomprasAux.gettotal_sin_iva()+sricompras.gettotal_sin_iva());			
			sricomprasAux.setmonto_iva(sricomprasAux.getmonto_iva()+sricompras.getmonto_iva());			
			sricomprasAux.setmonto_ice(sricomprasAux.getmonto_ice()+sricompras.getmonto_ice());			
			sricomprasAux.settransfe_iva_retener(sricomprasAux.gettransfe_iva_retener()+sricompras.gettransfe_iva_retener());			
			sricomprasAux.settransfe_iva_retenido(sricomprasAux.gettransfe_iva_retenido()+sricompras.gettransfe_iva_retenido());			
			sricomprasAux.setpresta_iva_retener(sricomprasAux.getpresta_iva_retener()+sricompras.getpresta_iva_retener());			
			sricomprasAux.setpresta_iva_retenido(sricomprasAux.getpresta_iva_retenido()+sricompras.getpresta_iva_retenido());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSriCompras(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SriComprasConstantesFunciones.getArrayColumnasGlobalesSriCompras(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSriCompras(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SriComprasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SriComprasConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSriCompras(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SriCompras> sricomprass,SriCompras sricompras,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SriCompras sricomprasAux: sricomprass) {
			if(sricomprasAux!=null && sricompras!=null) {
				if((sricomprasAux.getId()==null && sricompras.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(sricomprasAux.getId()!=null && sricompras.getId()!=null){
					if(sricomprasAux.getId().equals(sricompras.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSriCompras(List<SriCompras> sricomprass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double bienes_ivaTotal=0.0;
		Double servicion_ivaTotal=0.0;
		Double total_ivaTotal=0.0;
		Double bienes_sin_ivaTotal=0.0;
		Double servicios_sin_ivaTotal=0.0;
		Double total_sin_ivaTotal=0.0;
		Double monto_ivaTotal=0.0;
		Double monto_iceTotal=0.0;
		Double transfe_iva_retenerTotal=0.0;
		Double transfe_iva_retenidoTotal=0.0;
		Double presta_iva_retenerTotal=0.0;
		Double presta_iva_retenidoTotal=0.0;
	
		for(SriCompras sricompras: sricomprass) {			
			if(sricompras.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			bienes_ivaTotal+=sricompras.getbienes_iva();
			servicion_ivaTotal+=sricompras.getservicion_iva();
			total_ivaTotal+=sricompras.gettotal_iva();
			bienes_sin_ivaTotal+=sricompras.getbienes_sin_iva();
			servicios_sin_ivaTotal+=sricompras.getservicios_sin_iva();
			total_sin_ivaTotal+=sricompras.gettotal_sin_iva();
			monto_ivaTotal+=sricompras.getmonto_iva();
			monto_iceTotal+=sricompras.getmonto_ice();
			transfe_iva_retenerTotal+=sricompras.gettransfe_iva_retener();
			transfe_iva_retenidoTotal+=sricompras.gettransfe_iva_retenido();
			presta_iva_retenerTotal+=sricompras.getpresta_iva_retener();
			presta_iva_retenidoTotal+=sricompras.getpresta_iva_retenido();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriComprasConstantesFunciones.BIENESIVA);
		datoGeneral.setsDescripcion(SriComprasConstantesFunciones.LABEL_BIENESIVA);
		datoGeneral.setdValorDouble(bienes_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriComprasConstantesFunciones.SERVICIONIVA);
		datoGeneral.setsDescripcion(SriComprasConstantesFunciones.LABEL_SERVICIONIVA);
		datoGeneral.setdValorDouble(servicion_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriComprasConstantesFunciones.TOTALIVA);
		datoGeneral.setsDescripcion(SriComprasConstantesFunciones.LABEL_TOTALIVA);
		datoGeneral.setdValorDouble(total_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriComprasConstantesFunciones.BIENESSINIVA);
		datoGeneral.setsDescripcion(SriComprasConstantesFunciones.LABEL_BIENESSINIVA);
		datoGeneral.setdValorDouble(bienes_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriComprasConstantesFunciones.SERVICIOSSINIVA);
		datoGeneral.setsDescripcion(SriComprasConstantesFunciones.LABEL_SERVICIOSSINIVA);
		datoGeneral.setdValorDouble(servicios_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriComprasConstantesFunciones.TOTALSINIVA);
		datoGeneral.setsDescripcion(SriComprasConstantesFunciones.LABEL_TOTALSINIVA);
		datoGeneral.setdValorDouble(total_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriComprasConstantesFunciones.MONTOIVA);
		datoGeneral.setsDescripcion(SriComprasConstantesFunciones.LABEL_MONTOIVA);
		datoGeneral.setdValorDouble(monto_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriComprasConstantesFunciones.MONTOICE);
		datoGeneral.setsDescripcion(SriComprasConstantesFunciones.LABEL_MONTOICE);
		datoGeneral.setdValorDouble(monto_iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriComprasConstantesFunciones.TRANSFEIVARETENER);
		datoGeneral.setsDescripcion(SriComprasConstantesFunciones.LABEL_TRANSFEIVARETENER);
		datoGeneral.setdValorDouble(transfe_iva_retenerTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriComprasConstantesFunciones.TRANSFEIVARETENIDO);
		datoGeneral.setsDescripcion(SriComprasConstantesFunciones.LABEL_TRANSFEIVARETENIDO);
		datoGeneral.setdValorDouble(transfe_iva_retenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriComprasConstantesFunciones.PRESTAIVARETENER);
		datoGeneral.setsDescripcion(SriComprasConstantesFunciones.LABEL_PRESTAIVARETENER);
		datoGeneral.setdValorDouble(presta_iva_retenerTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriComprasConstantesFunciones.PRESTAIVARETENIDO);
		datoGeneral.setsDescripcion(SriComprasConstantesFunciones.LABEL_PRESTAIVARETENIDO);
		datoGeneral.setdValorDouble(presta_iva_retenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSriCompras() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_ID, SriComprasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_VERSIONROW, SriComprasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_NOMBRETIPOCOMPROBANTE, SriComprasConstantesFunciones.NOMBRETIPOCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE, SriComprasConstantesFunciones.NOMBRECOMPLETOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_RUCDATO, SriComprasConstantesFunciones.RUCDATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_NUMERODOCUMENTO, SriComprasConstantesFunciones.NUMERODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_FECHAEMISION, SriComprasConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_FECHAREGISTROCONTABLE, SriComprasConstantesFunciones.FECHAREGISTROCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_NUMEROSERIE, SriComprasConstantesFunciones.NUMEROSERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_NUMEROAUTORIZACION, SriComprasConstantesFunciones.NUMEROAUTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_BIENESIVA, SriComprasConstantesFunciones.BIENESIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_SERVICIONIVA, SriComprasConstantesFunciones.SERVICIONIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_TOTALIVA, SriComprasConstantesFunciones.TOTALIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_BIENESSINIVA, SriComprasConstantesFunciones.BIENESSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_SERVICIOSSINIVA, SriComprasConstantesFunciones.SERVICIOSSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_TOTALSINIVA, SriComprasConstantesFunciones.TOTALSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_IDTIPOIVA, SriComprasConstantesFunciones.IDTIPOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_MONTOIVA, SriComprasConstantesFunciones.MONTOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_MONTOICE, SriComprasConstantesFunciones.MONTOICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_TRANSFEIVARETENER, SriComprasConstantesFunciones.TRANSFEIVARETENER,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_IDTIPORETENCIONIVA, SriComprasConstantesFunciones.IDTIPORETENCIONIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_TRANSFEIVARETENIDO, SriComprasConstantesFunciones.TRANSFEIVARETENIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_PRESTAIVARETENER, SriComprasConstantesFunciones.PRESTAIVARETENER,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_IDTIPORETENCIONIVAPRESTA, SriComprasConstantesFunciones.IDTIPORETENCIONIVAPRESTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_PRESTAIVARETENIDO, SriComprasConstantesFunciones.PRESTAIVARETENIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_FECHACADUCIDAD, SriComprasConstantesFunciones.FECHACADUCIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_CODIGOASIENTOCONTABLE, SriComprasConstantesFunciones.CODIGOASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriComprasConstantesFunciones.LABEL_NUMERODOCUMENTOCONTABLE, SriComprasConstantesFunciones.NUMERODOCUMENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSriCompras() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.NOMBRETIPOCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.NOMBRECOMPLETOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.RUCDATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.NUMERODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.FECHAREGISTROCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.NUMEROSERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.NUMEROAUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.BIENESIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.SERVICIONIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.TOTALIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.BIENESSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.SERVICIOSSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.TOTALSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.IDTIPOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.MONTOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.MONTOICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.TRANSFEIVARETENER;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.IDTIPORETENCIONIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.TRANSFEIVARETENIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.PRESTAIVARETENER;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.IDTIPORETENCIONIVAPRESTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.PRESTAIVARETENIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.FECHACADUCIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.CODIGOASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriComprasConstantesFunciones.NUMERODOCUMENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSriCompras() throws Exception  {
		return SriComprasConstantesFunciones.getTiposSeleccionarSriCompras(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSriCompras(Boolean conFk) throws Exception  {
		return SriComprasConstantesFunciones.getTiposSeleccionarSriCompras(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSriCompras(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_IDPERIODODECLARA);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_IDPERIODODECLARA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_NOMBRETIPOCOMPROBANTE);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_NOMBRETIPOCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_RUCDATO);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_RUCDATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_NUMERODOCUMENTO);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_NUMERODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_FECHAREGISTROCONTABLE);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_FECHAREGISTROCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_NUMEROSERIE);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_NUMEROSERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_NUMEROAUTORIZACION);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_NUMEROAUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_BIENESIVA);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_BIENESIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_SERVICIONIVA);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_SERVICIONIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_TOTALIVA);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_TOTALIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_BIENESSINIVA);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_BIENESSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_SERVICIOSSINIVA);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_SERVICIOSSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_TOTALSINIVA);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_TOTALSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_IDTIPOIVA);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_IDTIPOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_MONTOIVA);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_MONTOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_MONTOICE);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_MONTOICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_TRANSFEIVARETENER);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_TRANSFEIVARETENER);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_IDTIPORETENCIONIVA);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_IDTIPORETENCIONIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_TRANSFEIVARETENIDO);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_TRANSFEIVARETENIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_PRESTAIVARETENER);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_PRESTAIVARETENER);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_IDTIPORETENCIONIVAPRESTA);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_IDTIPORETENCIONIVAPRESTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_PRESTAIVARETENIDO);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_PRESTAIVARETENIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_FECHACADUCIDAD);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_FECHACADUCIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_CODIGOASIENTOCONTABLE);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_CODIGOASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriComprasConstantesFunciones.LABEL_NUMERODOCUMENTOCONTABLE);
			reporte.setsDescripcion(SriComprasConstantesFunciones.LABEL_NUMERODOCUMENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSriCompras(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSriCompras(SriCompras sricomprasAux) throws Exception {
		
			sricomprasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(sricomprasAux.getEmpresa()));
			sricomprasAux.setperiododeclara_descripcion(PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(sricomprasAux.getPeriodoDeclara()));
			sricomprasAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(sricomprasAux.getCliente()));
			sricomprasAux.settipoiva_descripcion(TipoIvaConstantesFunciones.getTipoIvaDescripcion(sricomprasAux.getTipoIva()));
			sricomprasAux.settiporetencioniva_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(sricomprasAux.getTipoRetencionIva()));
			sricomprasAux.settiporetencionivapresta_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(sricomprasAux.getTipoRetencionIvaPresta()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSriCompras(List<SriCompras> sricomprassTemp) throws Exception {
		for(SriCompras sricomprasAux:sricomprassTemp) {
			
			sricomprasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(sricomprasAux.getEmpresa()));
			sricomprasAux.setperiododeclara_descripcion(PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(sricomprasAux.getPeriodoDeclara()));
			sricomprasAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(sricomprasAux.getCliente()));
			sricomprasAux.settipoiva_descripcion(TipoIvaConstantesFunciones.getTipoIvaDescripcion(sricomprasAux.getTipoIva()));
			sricomprasAux.settiporetencioniva_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(sricomprasAux.getTipoRetencionIva()));
			sricomprasAux.settiporetencionivapresta_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(sricomprasAux.getTipoRetencionIvaPresta()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSriCompras(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(PeriodoDeclara.class));
				classes.add(new Classe(Cliente.class));
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
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSriCompras(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSriCompras(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SriComprasConstantesFunciones.getClassesRelationshipsOfSriCompras(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSriCompras(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSriCompras(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SriComprasConstantesFunciones.getClassesRelationshipsFromStringsOfSriCompras(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSriCompras(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(SriCompras sricompras,List<SriCompras> sricomprass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(SriCompras sricompras,List<SriCompras> sricomprass) throws Exception {
		try	{			
			for(SriCompras sricomprasLocal:sricomprass) {
				if(sricomprasLocal.getId().equals(sricompras.getId())) {
					sricomprasLocal.setIsSelected(sricompras.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSriCompras(List<SriCompras> sricomprassAux) throws Exception {
		//this.sricomprassAux=sricomprassAux;
		
		for(SriCompras sricomprasAux:sricomprassAux) {
			if(sricomprasAux.getIsChanged()) {
				sricomprasAux.setIsChanged(false);
			}		
			
			if(sricomprasAux.getIsNew()) {
				sricomprasAux.setIsNew(false);
			}	
			
			if(sricomprasAux.getIsDeleted()) {
				sricomprasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSriCompras(SriCompras sricomprasAux) throws Exception {
		//this.sricomprasAux=sricomprasAux;
		
			if(sricomprasAux.getIsChanged()) {
				sricomprasAux.setIsChanged(false);
			}		
			
			if(sricomprasAux.getIsNew()) {
				sricomprasAux.setIsNew(false);
			}	
			
			if(sricomprasAux.getIsDeleted()) {
				sricomprasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(SriCompras sricomprasAsignar,SriCompras sricompras) throws Exception {
		sricomprasAsignar.setId(sricompras.getId());	
		sricomprasAsignar.setVersionRow(sricompras.getVersionRow());	
		sricomprasAsignar.setnombre_tipo_comprobante(sricompras.getnombre_tipo_comprobante());	
		sricomprasAsignar.setnombre_completo_cliente(sricompras.getnombre_completo_cliente());	
		sricomprasAsignar.setruc_dato(sricompras.getruc_dato());	
		sricomprasAsignar.setnumero_documento(sricompras.getnumero_documento());	
		sricomprasAsignar.setfecha_emision(sricompras.getfecha_emision());	
		sricomprasAsignar.setfecha_registro_contable(sricompras.getfecha_registro_contable());	
		sricomprasAsignar.setnumero_serie(sricompras.getnumero_serie());	
		sricomprasAsignar.setnumero_autorizacion(sricompras.getnumero_autorizacion());	
		sricomprasAsignar.setbienes_iva(sricompras.getbienes_iva());	
		sricomprasAsignar.setservicion_iva(sricompras.getservicion_iva());	
		sricomprasAsignar.settotal_iva(sricompras.gettotal_iva());	
		sricomprasAsignar.setbienes_sin_iva(sricompras.getbienes_sin_iva());	
		sricomprasAsignar.setservicios_sin_iva(sricompras.getservicios_sin_iva());	
		sricomprasAsignar.settotal_sin_iva(sricompras.gettotal_sin_iva());	
		sricomprasAsignar.setid_tipo_iva(sricompras.getid_tipo_iva());
		sricomprasAsignar.settipoiva_descripcion(sricompras.gettipoiva_descripcion());	
		sricomprasAsignar.setmonto_iva(sricompras.getmonto_iva());	
		sricomprasAsignar.setmonto_ice(sricompras.getmonto_ice());	
		sricomprasAsignar.settransfe_iva_retener(sricompras.gettransfe_iva_retener());	
		sricomprasAsignar.setid_tipo_retencion_iva(sricompras.getid_tipo_retencion_iva());
		sricomprasAsignar.settiporetencioniva_descripcion(sricompras.gettiporetencioniva_descripcion());	
		sricomprasAsignar.settransfe_iva_retenido(sricompras.gettransfe_iva_retenido());	
		sricomprasAsignar.setpresta_iva_retener(sricompras.getpresta_iva_retener());	
		sricomprasAsignar.setid_tipo_retencion_iva_presta(sricompras.getid_tipo_retencion_iva_presta());
		sricomprasAsignar.settiporetencionivapresta_descripcion(sricompras.gettiporetencionivapresta_descripcion());	
		sricomprasAsignar.setpresta_iva_retenido(sricompras.getpresta_iva_retenido());	
		sricomprasAsignar.setfecha_caducidad(sricompras.getfecha_caducidad());	
		sricomprasAsignar.setcodigo_asiento_contable(sricompras.getcodigo_asiento_contable());	
		sricomprasAsignar.setnumero_documento_contable(sricompras.getnumero_documento_contable());	
	}
	
	public static void inicializarSriCompras(SriCompras sricompras) throws Exception {
		try {
				sricompras.setId(0L);	
					
				sricompras.setnombre_tipo_comprobante("");	
				sricompras.setnombre_completo_cliente("");	
				sricompras.setruc_dato("");	
				sricompras.setnumero_documento("");	
				sricompras.setfecha_emision(new Date());	
				sricompras.setfecha_registro_contable(new Date());	
				sricompras.setnumero_serie("");	
				sricompras.setnumero_autorizacion("");	
				sricompras.setbienes_iva(0.0);	
				sricompras.setservicion_iva(0.0);	
				sricompras.settotal_iva(0.0);	
				sricompras.setbienes_sin_iva(0.0);	
				sricompras.setservicios_sin_iva(0.0);	
				sricompras.settotal_sin_iva(0.0);	
				sricompras.setid_tipo_iva(-1L);	
				sricompras.setmonto_iva(0.0);	
				sricompras.setmonto_ice(0.0);	
				sricompras.settransfe_iva_retener(0.0);	
				sricompras.setid_tipo_retencion_iva(-1L);	
				sricompras.settransfe_iva_retenido(0.0);	
				sricompras.setpresta_iva_retener(0.0);	
				sricompras.setid_tipo_retencion_iva_presta(-1L);	
				sricompras.setpresta_iva_retenido(0.0);	
				sricompras.setfecha_caducidad(new Date());	
				sricompras.setcodigo_asiento_contable("");	
				sricompras.setnumero_documento_contable("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSriCompras(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_IDPERIODODECLARA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_NOMBRETIPOCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_RUCDATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_NUMERODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_FECHAREGISTROCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_NUMEROSERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_NUMEROAUTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_BIENESIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_SERVICIONIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_TOTALIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_BIENESSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_SERVICIOSSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_TOTALSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_IDTIPOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_MONTOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_MONTOICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_TRANSFEIVARETENER);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_IDTIPORETENCIONIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_TRANSFEIVARETENIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_PRESTAIVARETENER);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_IDTIPORETENCIONIVAPRESTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_PRESTAIVARETENIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_FECHACADUCIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_CODIGOASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriComprasConstantesFunciones.LABEL_NUMERODOCUMENTOCONTABLE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSriCompras(String sTipo,Row row,Workbook workbook,SriCompras sricompras,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getperiododeclara_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getnombre_tipo_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getruc_dato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getnumero_documento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getfecha_registro_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getnumero_serie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getnumero_autorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getbienes_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getservicion_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.gettotal_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getbienes_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getservicios_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.gettotal_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.gettipoiva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getmonto_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getmonto_ice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.gettransfe_iva_retener());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.gettiporetencioniva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.gettransfe_iva_retenido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getpresta_iva_retener());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.gettiporetencionivapresta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getpresta_iva_retenido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getfecha_caducidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getcodigo_asiento_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sricompras.getnumero_documento_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySriCompras="";
	
	public String getsFinalQuerySriCompras() {
		return this.sFinalQuerySriCompras;
	}
	
	public void setsFinalQuerySriCompras(String sFinalQuerySriCompras) {
		this.sFinalQuerySriCompras= sFinalQuerySriCompras;
	}
	
	public Border resaltarSeleccionarSriCompras=null;
	
	public Border setResaltarSeleccionarSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSriCompras= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSriCompras() {
		return this.resaltarSeleccionarSriCompras;
	}
	
	public void setResaltarSeleccionarSriCompras(Border borderResaltarSeleccionarSriCompras) {
		this.resaltarSeleccionarSriCompras= borderResaltarSeleccionarSriCompras;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSriCompras=null;
	public Boolean mostraridSriCompras=true;
	public Boolean activaridSriCompras=true;

	public Border resaltarid_empresaSriCompras=null;
	public Boolean mostrarid_empresaSriCompras=true;
	public Boolean activarid_empresaSriCompras=true;
	public Boolean cargarid_empresaSriCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSriCompras=false;//ConEventDepend=true

	public Border resaltarid_periodo_declaraSriCompras=null;
	public Boolean mostrarid_periodo_declaraSriCompras=true;
	public Boolean activarid_periodo_declaraSriCompras=true;
	public Boolean cargarid_periodo_declaraSriCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodo_declaraSriCompras=false;//ConEventDepend=true

	public Border resaltarid_clienteSriCompras=null;
	public Boolean mostrarid_clienteSriCompras=true;
	public Boolean activarid_clienteSriCompras=true;
	public Boolean cargarid_clienteSriCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteSriCompras=false;//ConEventDepend=true

	public Border resaltarrucSriCompras=null;
	public Boolean mostrarrucSriCompras=true;
	public Boolean activarrucSriCompras=true;

	public Border resaltarnombre_tipo_comprobanteSriCompras=null;
	public Boolean mostrarnombre_tipo_comprobanteSriCompras=true;
	public Boolean activarnombre_tipo_comprobanteSriCompras=true;

	public Border resaltarnombre_completo_clienteSriCompras=null;
	public Boolean mostrarnombre_completo_clienteSriCompras=true;
	public Boolean activarnombre_completo_clienteSriCompras=true;

	public Border resaltarruc_datoSriCompras=null;
	public Boolean mostrarruc_datoSriCompras=true;
	public Boolean activarruc_datoSriCompras=true;

	public Border resaltarnumero_documentoSriCompras=null;
	public Boolean mostrarnumero_documentoSriCompras=true;
	public Boolean activarnumero_documentoSriCompras=true;

	public Border resaltarfecha_emisionSriCompras=null;
	public Boolean mostrarfecha_emisionSriCompras=true;
	public Boolean activarfecha_emisionSriCompras=true;

	public Border resaltarfecha_registro_contableSriCompras=null;
	public Boolean mostrarfecha_registro_contableSriCompras=true;
	public Boolean activarfecha_registro_contableSriCompras=true;

	public Border resaltarnumero_serieSriCompras=null;
	public Boolean mostrarnumero_serieSriCompras=true;
	public Boolean activarnumero_serieSriCompras=true;

	public Border resaltarnumero_autorizacionSriCompras=null;
	public Boolean mostrarnumero_autorizacionSriCompras=true;
	public Boolean activarnumero_autorizacionSriCompras=true;

	public Border resaltarbienes_ivaSriCompras=null;
	public Boolean mostrarbienes_ivaSriCompras=true;
	public Boolean activarbienes_ivaSriCompras=true;

	public Border resaltarservicion_ivaSriCompras=null;
	public Boolean mostrarservicion_ivaSriCompras=true;
	public Boolean activarservicion_ivaSriCompras=true;

	public Border resaltartotal_ivaSriCompras=null;
	public Boolean mostrartotal_ivaSriCompras=true;
	public Boolean activartotal_ivaSriCompras=true;

	public Border resaltarbienes_sin_ivaSriCompras=null;
	public Boolean mostrarbienes_sin_ivaSriCompras=true;
	public Boolean activarbienes_sin_ivaSriCompras=true;

	public Border resaltarservicios_sin_ivaSriCompras=null;
	public Boolean mostrarservicios_sin_ivaSriCompras=true;
	public Boolean activarservicios_sin_ivaSriCompras=true;

	public Border resaltartotal_sin_ivaSriCompras=null;
	public Boolean mostrartotal_sin_ivaSriCompras=true;
	public Boolean activartotal_sin_ivaSriCompras=true;

	public Border resaltarid_tipo_ivaSriCompras=null;
	public Boolean mostrarid_tipo_ivaSriCompras=true;
	public Boolean activarid_tipo_ivaSriCompras=true;
	public Boolean cargarid_tipo_ivaSriCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_ivaSriCompras=false;//ConEventDepend=true

	public Border resaltarmonto_ivaSriCompras=null;
	public Boolean mostrarmonto_ivaSriCompras=true;
	public Boolean activarmonto_ivaSriCompras=true;

	public Border resaltarmonto_iceSriCompras=null;
	public Boolean mostrarmonto_iceSriCompras=true;
	public Boolean activarmonto_iceSriCompras=true;

	public Border resaltartransfe_iva_retenerSriCompras=null;
	public Boolean mostrartransfe_iva_retenerSriCompras=true;
	public Boolean activartransfe_iva_retenerSriCompras=true;

	public Border resaltarid_tipo_retencion_ivaSriCompras=null;
	public Boolean mostrarid_tipo_retencion_ivaSriCompras=true;
	public Boolean activarid_tipo_retencion_ivaSriCompras=true;
	public Boolean cargarid_tipo_retencion_ivaSriCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencion_ivaSriCompras=false;//ConEventDepend=true

	public Border resaltartransfe_iva_retenidoSriCompras=null;
	public Boolean mostrartransfe_iva_retenidoSriCompras=true;
	public Boolean activartransfe_iva_retenidoSriCompras=true;

	public Border resaltarpresta_iva_retenerSriCompras=null;
	public Boolean mostrarpresta_iva_retenerSriCompras=true;
	public Boolean activarpresta_iva_retenerSriCompras=true;

	public Border resaltarid_tipo_retencion_iva_prestaSriCompras=null;
	public Boolean mostrarid_tipo_retencion_iva_prestaSriCompras=true;
	public Boolean activarid_tipo_retencion_iva_prestaSriCompras=true;
	public Boolean cargarid_tipo_retencion_iva_prestaSriCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencion_iva_prestaSriCompras=false;//ConEventDepend=true

	public Border resaltarpresta_iva_retenidoSriCompras=null;
	public Boolean mostrarpresta_iva_retenidoSriCompras=true;
	public Boolean activarpresta_iva_retenidoSriCompras=true;

	public Border resaltarfecha_caducidadSriCompras=null;
	public Boolean mostrarfecha_caducidadSriCompras=true;
	public Boolean activarfecha_caducidadSriCompras=true;

	public Border resaltarcodigo_asiento_contableSriCompras=null;
	public Boolean mostrarcodigo_asiento_contableSriCompras=true;
	public Boolean activarcodigo_asiento_contableSriCompras=true;

	public Border resaltarnumero_documento_contableSriCompras=null;
	public Boolean mostrarnumero_documento_contableSriCompras=true;
	public Boolean activarnumero_documento_contableSriCompras=true;

	
	

	public Border setResaltaridSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltaridSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSriCompras() {
		return this.resaltaridSriCompras;
	}

	public void setResaltaridSriCompras(Border borderResaltar) {
		this.resaltaridSriCompras= borderResaltar;
	}

	public Boolean getMostraridSriCompras() {
		return this.mostraridSriCompras;
	}

	public void setMostraridSriCompras(Boolean mostraridSriCompras) {
		this.mostraridSriCompras= mostraridSriCompras;
	}

	public Boolean getActivaridSriCompras() {
		return this.activaridSriCompras;
	}

	public void setActivaridSriCompras(Boolean activaridSriCompras) {
		this.activaridSriCompras= activaridSriCompras;
	}

	public Border setResaltarid_empresaSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarid_empresaSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSriCompras() {
		return this.resaltarid_empresaSriCompras;
	}

	public void setResaltarid_empresaSriCompras(Border borderResaltar) {
		this.resaltarid_empresaSriCompras= borderResaltar;
	}

	public Boolean getMostrarid_empresaSriCompras() {
		return this.mostrarid_empresaSriCompras;
	}

	public void setMostrarid_empresaSriCompras(Boolean mostrarid_empresaSriCompras) {
		this.mostrarid_empresaSriCompras= mostrarid_empresaSriCompras;
	}

	public Boolean getActivarid_empresaSriCompras() {
		return this.activarid_empresaSriCompras;
	}

	public void setActivarid_empresaSriCompras(Boolean activarid_empresaSriCompras) {
		this.activarid_empresaSriCompras= activarid_empresaSriCompras;
	}

	public Boolean getCargarid_empresaSriCompras() {
		return this.cargarid_empresaSriCompras;
	}

	public void setCargarid_empresaSriCompras(Boolean cargarid_empresaSriCompras) {
		this.cargarid_empresaSriCompras= cargarid_empresaSriCompras;
	}

	public Border setResaltarid_periodo_declaraSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarid_periodo_declaraSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodo_declaraSriCompras() {
		return this.resaltarid_periodo_declaraSriCompras;
	}

	public void setResaltarid_periodo_declaraSriCompras(Border borderResaltar) {
		this.resaltarid_periodo_declaraSriCompras= borderResaltar;
	}

	public Boolean getMostrarid_periodo_declaraSriCompras() {
		return this.mostrarid_periodo_declaraSriCompras;
	}

	public void setMostrarid_periodo_declaraSriCompras(Boolean mostrarid_periodo_declaraSriCompras) {
		this.mostrarid_periodo_declaraSriCompras= mostrarid_periodo_declaraSriCompras;
	}

	public Boolean getActivarid_periodo_declaraSriCompras() {
		return this.activarid_periodo_declaraSriCompras;
	}

	public void setActivarid_periodo_declaraSriCompras(Boolean activarid_periodo_declaraSriCompras) {
		this.activarid_periodo_declaraSriCompras= activarid_periodo_declaraSriCompras;
	}

	public Boolean getCargarid_periodo_declaraSriCompras() {
		return this.cargarid_periodo_declaraSriCompras;
	}

	public void setCargarid_periodo_declaraSriCompras(Boolean cargarid_periodo_declaraSriCompras) {
		this.cargarid_periodo_declaraSriCompras= cargarid_periodo_declaraSriCompras;
	}

	public Border setResaltarid_clienteSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarid_clienteSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteSriCompras() {
		return this.resaltarid_clienteSriCompras;
	}

	public void setResaltarid_clienteSriCompras(Border borderResaltar) {
		this.resaltarid_clienteSriCompras= borderResaltar;
	}

	public Boolean getMostrarid_clienteSriCompras() {
		return this.mostrarid_clienteSriCompras;
	}

	public void setMostrarid_clienteSriCompras(Boolean mostrarid_clienteSriCompras) {
		this.mostrarid_clienteSriCompras= mostrarid_clienteSriCompras;
	}

	public Boolean getActivarid_clienteSriCompras() {
		return this.activarid_clienteSriCompras;
	}

	public void setActivarid_clienteSriCompras(Boolean activarid_clienteSriCompras) {
		this.activarid_clienteSriCompras= activarid_clienteSriCompras;
	}

	public Boolean getCargarid_clienteSriCompras() {
		return this.cargarid_clienteSriCompras;
	}

	public void setCargarid_clienteSriCompras(Boolean cargarid_clienteSriCompras) {
		this.cargarid_clienteSriCompras= cargarid_clienteSriCompras;
	}

	public Border setResaltarrucSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarrucSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucSriCompras() {
		return this.resaltarrucSriCompras;
	}

	public void setResaltarrucSriCompras(Border borderResaltar) {
		this.resaltarrucSriCompras= borderResaltar;
	}

	public Boolean getMostrarrucSriCompras() {
		return this.mostrarrucSriCompras;
	}

	public void setMostrarrucSriCompras(Boolean mostrarrucSriCompras) {
		this.mostrarrucSriCompras= mostrarrucSriCompras;
	}

	public Boolean getActivarrucSriCompras() {
		return this.activarrucSriCompras;
	}

	public void setActivarrucSriCompras(Boolean activarrucSriCompras) {
		this.activarrucSriCompras= activarrucSriCompras;
	}

	public Border setResaltarnombre_tipo_comprobanteSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_comprobanteSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_comprobanteSriCompras() {
		return this.resaltarnombre_tipo_comprobanteSriCompras;
	}

	public void setResaltarnombre_tipo_comprobanteSriCompras(Border borderResaltar) {
		this.resaltarnombre_tipo_comprobanteSriCompras= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_comprobanteSriCompras() {
		return this.mostrarnombre_tipo_comprobanteSriCompras;
	}

	public void setMostrarnombre_tipo_comprobanteSriCompras(Boolean mostrarnombre_tipo_comprobanteSriCompras) {
		this.mostrarnombre_tipo_comprobanteSriCompras= mostrarnombre_tipo_comprobanteSriCompras;
	}

	public Boolean getActivarnombre_tipo_comprobanteSriCompras() {
		return this.activarnombre_tipo_comprobanteSriCompras;
	}

	public void setActivarnombre_tipo_comprobanteSriCompras(Boolean activarnombre_tipo_comprobanteSriCompras) {
		this.activarnombre_tipo_comprobanteSriCompras= activarnombre_tipo_comprobanteSriCompras;
	}

	public Border setResaltarnombre_completo_clienteSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clienteSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clienteSriCompras() {
		return this.resaltarnombre_completo_clienteSriCompras;
	}

	public void setResaltarnombre_completo_clienteSriCompras(Border borderResaltar) {
		this.resaltarnombre_completo_clienteSriCompras= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clienteSriCompras() {
		return this.mostrarnombre_completo_clienteSriCompras;
	}

	public void setMostrarnombre_completo_clienteSriCompras(Boolean mostrarnombre_completo_clienteSriCompras) {
		this.mostrarnombre_completo_clienteSriCompras= mostrarnombre_completo_clienteSriCompras;
	}

	public Boolean getActivarnombre_completo_clienteSriCompras() {
		return this.activarnombre_completo_clienteSriCompras;
	}

	public void setActivarnombre_completo_clienteSriCompras(Boolean activarnombre_completo_clienteSriCompras) {
		this.activarnombre_completo_clienteSriCompras= activarnombre_completo_clienteSriCompras;
	}

	public Border setResaltarruc_datoSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarruc_datoSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarruc_datoSriCompras() {
		return this.resaltarruc_datoSriCompras;
	}

	public void setResaltarruc_datoSriCompras(Border borderResaltar) {
		this.resaltarruc_datoSriCompras= borderResaltar;
	}

	public Boolean getMostrarruc_datoSriCompras() {
		return this.mostrarruc_datoSriCompras;
	}

	public void setMostrarruc_datoSriCompras(Boolean mostrarruc_datoSriCompras) {
		this.mostrarruc_datoSriCompras= mostrarruc_datoSriCompras;
	}

	public Boolean getActivarruc_datoSriCompras() {
		return this.activarruc_datoSriCompras;
	}

	public void setActivarruc_datoSriCompras(Boolean activarruc_datoSriCompras) {
		this.activarruc_datoSriCompras= activarruc_datoSriCompras;
	}

	public Border setResaltarnumero_documentoSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarnumero_documentoSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_documentoSriCompras() {
		return this.resaltarnumero_documentoSriCompras;
	}

	public void setResaltarnumero_documentoSriCompras(Border borderResaltar) {
		this.resaltarnumero_documentoSriCompras= borderResaltar;
	}

	public Boolean getMostrarnumero_documentoSriCompras() {
		return this.mostrarnumero_documentoSriCompras;
	}

	public void setMostrarnumero_documentoSriCompras(Boolean mostrarnumero_documentoSriCompras) {
		this.mostrarnumero_documentoSriCompras= mostrarnumero_documentoSriCompras;
	}

	public Boolean getActivarnumero_documentoSriCompras() {
		return this.activarnumero_documentoSriCompras;
	}

	public void setActivarnumero_documentoSriCompras(Boolean activarnumero_documentoSriCompras) {
		this.activarnumero_documentoSriCompras= activarnumero_documentoSriCompras;
	}

	public Border setResaltarfecha_emisionSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionSriCompras() {
		return this.resaltarfecha_emisionSriCompras;
	}

	public void setResaltarfecha_emisionSriCompras(Border borderResaltar) {
		this.resaltarfecha_emisionSriCompras= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionSriCompras() {
		return this.mostrarfecha_emisionSriCompras;
	}

	public void setMostrarfecha_emisionSriCompras(Boolean mostrarfecha_emisionSriCompras) {
		this.mostrarfecha_emisionSriCompras= mostrarfecha_emisionSriCompras;
	}

	public Boolean getActivarfecha_emisionSriCompras() {
		return this.activarfecha_emisionSriCompras;
	}

	public void setActivarfecha_emisionSriCompras(Boolean activarfecha_emisionSriCompras) {
		this.activarfecha_emisionSriCompras= activarfecha_emisionSriCompras;
	}

	public Border setResaltarfecha_registro_contableSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarfecha_registro_contableSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_registro_contableSriCompras() {
		return this.resaltarfecha_registro_contableSriCompras;
	}

	public void setResaltarfecha_registro_contableSriCompras(Border borderResaltar) {
		this.resaltarfecha_registro_contableSriCompras= borderResaltar;
	}

	public Boolean getMostrarfecha_registro_contableSriCompras() {
		return this.mostrarfecha_registro_contableSriCompras;
	}

	public void setMostrarfecha_registro_contableSriCompras(Boolean mostrarfecha_registro_contableSriCompras) {
		this.mostrarfecha_registro_contableSriCompras= mostrarfecha_registro_contableSriCompras;
	}

	public Boolean getActivarfecha_registro_contableSriCompras() {
		return this.activarfecha_registro_contableSriCompras;
	}

	public void setActivarfecha_registro_contableSriCompras(Boolean activarfecha_registro_contableSriCompras) {
		this.activarfecha_registro_contableSriCompras= activarfecha_registro_contableSriCompras;
	}

	public Border setResaltarnumero_serieSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarnumero_serieSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_serieSriCompras() {
		return this.resaltarnumero_serieSriCompras;
	}

	public void setResaltarnumero_serieSriCompras(Border borderResaltar) {
		this.resaltarnumero_serieSriCompras= borderResaltar;
	}

	public Boolean getMostrarnumero_serieSriCompras() {
		return this.mostrarnumero_serieSriCompras;
	}

	public void setMostrarnumero_serieSriCompras(Boolean mostrarnumero_serieSriCompras) {
		this.mostrarnumero_serieSriCompras= mostrarnumero_serieSriCompras;
	}

	public Boolean getActivarnumero_serieSriCompras() {
		return this.activarnumero_serieSriCompras;
	}

	public void setActivarnumero_serieSriCompras(Boolean activarnumero_serieSriCompras) {
		this.activarnumero_serieSriCompras= activarnumero_serieSriCompras;
	}

	public Border setResaltarnumero_autorizacionSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarnumero_autorizacionSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_autorizacionSriCompras() {
		return this.resaltarnumero_autorizacionSriCompras;
	}

	public void setResaltarnumero_autorizacionSriCompras(Border borderResaltar) {
		this.resaltarnumero_autorizacionSriCompras= borderResaltar;
	}

	public Boolean getMostrarnumero_autorizacionSriCompras() {
		return this.mostrarnumero_autorizacionSriCompras;
	}

	public void setMostrarnumero_autorizacionSriCompras(Boolean mostrarnumero_autorizacionSriCompras) {
		this.mostrarnumero_autorizacionSriCompras= mostrarnumero_autorizacionSriCompras;
	}

	public Boolean getActivarnumero_autorizacionSriCompras() {
		return this.activarnumero_autorizacionSriCompras;
	}

	public void setActivarnumero_autorizacionSriCompras(Boolean activarnumero_autorizacionSriCompras) {
		this.activarnumero_autorizacionSriCompras= activarnumero_autorizacionSriCompras;
	}

	public Border setResaltarbienes_ivaSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarbienes_ivaSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbienes_ivaSriCompras() {
		return this.resaltarbienes_ivaSriCompras;
	}

	public void setResaltarbienes_ivaSriCompras(Border borderResaltar) {
		this.resaltarbienes_ivaSriCompras= borderResaltar;
	}

	public Boolean getMostrarbienes_ivaSriCompras() {
		return this.mostrarbienes_ivaSriCompras;
	}

	public void setMostrarbienes_ivaSriCompras(Boolean mostrarbienes_ivaSriCompras) {
		this.mostrarbienes_ivaSriCompras= mostrarbienes_ivaSriCompras;
	}

	public Boolean getActivarbienes_ivaSriCompras() {
		return this.activarbienes_ivaSriCompras;
	}

	public void setActivarbienes_ivaSriCompras(Boolean activarbienes_ivaSriCompras) {
		this.activarbienes_ivaSriCompras= activarbienes_ivaSriCompras;
	}

	public Border setResaltarservicion_ivaSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarservicion_ivaSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarservicion_ivaSriCompras() {
		return this.resaltarservicion_ivaSriCompras;
	}

	public void setResaltarservicion_ivaSriCompras(Border borderResaltar) {
		this.resaltarservicion_ivaSriCompras= borderResaltar;
	}

	public Boolean getMostrarservicion_ivaSriCompras() {
		return this.mostrarservicion_ivaSriCompras;
	}

	public void setMostrarservicion_ivaSriCompras(Boolean mostrarservicion_ivaSriCompras) {
		this.mostrarservicion_ivaSriCompras= mostrarservicion_ivaSriCompras;
	}

	public Boolean getActivarservicion_ivaSriCompras() {
		return this.activarservicion_ivaSriCompras;
	}

	public void setActivarservicion_ivaSriCompras(Boolean activarservicion_ivaSriCompras) {
		this.activarservicion_ivaSriCompras= activarservicion_ivaSriCompras;
	}

	public Border setResaltartotal_ivaSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltartotal_ivaSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ivaSriCompras() {
		return this.resaltartotal_ivaSriCompras;
	}

	public void setResaltartotal_ivaSriCompras(Border borderResaltar) {
		this.resaltartotal_ivaSriCompras= borderResaltar;
	}

	public Boolean getMostrartotal_ivaSriCompras() {
		return this.mostrartotal_ivaSriCompras;
	}

	public void setMostrartotal_ivaSriCompras(Boolean mostrartotal_ivaSriCompras) {
		this.mostrartotal_ivaSriCompras= mostrartotal_ivaSriCompras;
	}

	public Boolean getActivartotal_ivaSriCompras() {
		return this.activartotal_ivaSriCompras;
	}

	public void setActivartotal_ivaSriCompras(Boolean activartotal_ivaSriCompras) {
		this.activartotal_ivaSriCompras= activartotal_ivaSriCompras;
	}

	public Border setResaltarbienes_sin_ivaSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarbienes_sin_ivaSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbienes_sin_ivaSriCompras() {
		return this.resaltarbienes_sin_ivaSriCompras;
	}

	public void setResaltarbienes_sin_ivaSriCompras(Border borderResaltar) {
		this.resaltarbienes_sin_ivaSriCompras= borderResaltar;
	}

	public Boolean getMostrarbienes_sin_ivaSriCompras() {
		return this.mostrarbienes_sin_ivaSriCompras;
	}

	public void setMostrarbienes_sin_ivaSriCompras(Boolean mostrarbienes_sin_ivaSriCompras) {
		this.mostrarbienes_sin_ivaSriCompras= mostrarbienes_sin_ivaSriCompras;
	}

	public Boolean getActivarbienes_sin_ivaSriCompras() {
		return this.activarbienes_sin_ivaSriCompras;
	}

	public void setActivarbienes_sin_ivaSriCompras(Boolean activarbienes_sin_ivaSriCompras) {
		this.activarbienes_sin_ivaSriCompras= activarbienes_sin_ivaSriCompras;
	}

	public Border setResaltarservicios_sin_ivaSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarservicios_sin_ivaSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarservicios_sin_ivaSriCompras() {
		return this.resaltarservicios_sin_ivaSriCompras;
	}

	public void setResaltarservicios_sin_ivaSriCompras(Border borderResaltar) {
		this.resaltarservicios_sin_ivaSriCompras= borderResaltar;
	}

	public Boolean getMostrarservicios_sin_ivaSriCompras() {
		return this.mostrarservicios_sin_ivaSriCompras;
	}

	public void setMostrarservicios_sin_ivaSriCompras(Boolean mostrarservicios_sin_ivaSriCompras) {
		this.mostrarservicios_sin_ivaSriCompras= mostrarservicios_sin_ivaSriCompras;
	}

	public Boolean getActivarservicios_sin_ivaSriCompras() {
		return this.activarservicios_sin_ivaSriCompras;
	}

	public void setActivarservicios_sin_ivaSriCompras(Boolean activarservicios_sin_ivaSriCompras) {
		this.activarservicios_sin_ivaSriCompras= activarservicios_sin_ivaSriCompras;
	}

	public Border setResaltartotal_sin_ivaSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltartotal_sin_ivaSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_sin_ivaSriCompras() {
		return this.resaltartotal_sin_ivaSriCompras;
	}

	public void setResaltartotal_sin_ivaSriCompras(Border borderResaltar) {
		this.resaltartotal_sin_ivaSriCompras= borderResaltar;
	}

	public Boolean getMostrartotal_sin_ivaSriCompras() {
		return this.mostrartotal_sin_ivaSriCompras;
	}

	public void setMostrartotal_sin_ivaSriCompras(Boolean mostrartotal_sin_ivaSriCompras) {
		this.mostrartotal_sin_ivaSriCompras= mostrartotal_sin_ivaSriCompras;
	}

	public Boolean getActivartotal_sin_ivaSriCompras() {
		return this.activartotal_sin_ivaSriCompras;
	}

	public void setActivartotal_sin_ivaSriCompras(Boolean activartotal_sin_ivaSriCompras) {
		this.activartotal_sin_ivaSriCompras= activartotal_sin_ivaSriCompras;
	}

	public Border setResaltarid_tipo_ivaSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarid_tipo_ivaSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_ivaSriCompras() {
		return this.resaltarid_tipo_ivaSriCompras;
	}

	public void setResaltarid_tipo_ivaSriCompras(Border borderResaltar) {
		this.resaltarid_tipo_ivaSriCompras= borderResaltar;
	}

	public Boolean getMostrarid_tipo_ivaSriCompras() {
		return this.mostrarid_tipo_ivaSriCompras;
	}

	public void setMostrarid_tipo_ivaSriCompras(Boolean mostrarid_tipo_ivaSriCompras) {
		this.mostrarid_tipo_ivaSriCompras= mostrarid_tipo_ivaSriCompras;
	}

	public Boolean getActivarid_tipo_ivaSriCompras() {
		return this.activarid_tipo_ivaSriCompras;
	}

	public void setActivarid_tipo_ivaSriCompras(Boolean activarid_tipo_ivaSriCompras) {
		this.activarid_tipo_ivaSriCompras= activarid_tipo_ivaSriCompras;
	}

	public Boolean getCargarid_tipo_ivaSriCompras() {
		return this.cargarid_tipo_ivaSriCompras;
	}

	public void setCargarid_tipo_ivaSriCompras(Boolean cargarid_tipo_ivaSriCompras) {
		this.cargarid_tipo_ivaSriCompras= cargarid_tipo_ivaSriCompras;
	}

	public Border setResaltarmonto_ivaSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarmonto_ivaSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_ivaSriCompras() {
		return this.resaltarmonto_ivaSriCompras;
	}

	public void setResaltarmonto_ivaSriCompras(Border borderResaltar) {
		this.resaltarmonto_ivaSriCompras= borderResaltar;
	}

	public Boolean getMostrarmonto_ivaSriCompras() {
		return this.mostrarmonto_ivaSriCompras;
	}

	public void setMostrarmonto_ivaSriCompras(Boolean mostrarmonto_ivaSriCompras) {
		this.mostrarmonto_ivaSriCompras= mostrarmonto_ivaSriCompras;
	}

	public Boolean getActivarmonto_ivaSriCompras() {
		return this.activarmonto_ivaSriCompras;
	}

	public void setActivarmonto_ivaSriCompras(Boolean activarmonto_ivaSriCompras) {
		this.activarmonto_ivaSriCompras= activarmonto_ivaSriCompras;
	}

	public Border setResaltarmonto_iceSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarmonto_iceSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_iceSriCompras() {
		return this.resaltarmonto_iceSriCompras;
	}

	public void setResaltarmonto_iceSriCompras(Border borderResaltar) {
		this.resaltarmonto_iceSriCompras= borderResaltar;
	}

	public Boolean getMostrarmonto_iceSriCompras() {
		return this.mostrarmonto_iceSriCompras;
	}

	public void setMostrarmonto_iceSriCompras(Boolean mostrarmonto_iceSriCompras) {
		this.mostrarmonto_iceSriCompras= mostrarmonto_iceSriCompras;
	}

	public Boolean getActivarmonto_iceSriCompras() {
		return this.activarmonto_iceSriCompras;
	}

	public void setActivarmonto_iceSriCompras(Boolean activarmonto_iceSriCompras) {
		this.activarmonto_iceSriCompras= activarmonto_iceSriCompras;
	}

	public Border setResaltartransfe_iva_retenerSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltartransfe_iva_retenerSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartransfe_iva_retenerSriCompras() {
		return this.resaltartransfe_iva_retenerSriCompras;
	}

	public void setResaltartransfe_iva_retenerSriCompras(Border borderResaltar) {
		this.resaltartransfe_iva_retenerSriCompras= borderResaltar;
	}

	public Boolean getMostrartransfe_iva_retenerSriCompras() {
		return this.mostrartransfe_iva_retenerSriCompras;
	}

	public void setMostrartransfe_iva_retenerSriCompras(Boolean mostrartransfe_iva_retenerSriCompras) {
		this.mostrartransfe_iva_retenerSriCompras= mostrartransfe_iva_retenerSriCompras;
	}

	public Boolean getActivartransfe_iva_retenerSriCompras() {
		return this.activartransfe_iva_retenerSriCompras;
	}

	public void setActivartransfe_iva_retenerSriCompras(Boolean activartransfe_iva_retenerSriCompras) {
		this.activartransfe_iva_retenerSriCompras= activartransfe_iva_retenerSriCompras;
	}

	public Border setResaltarid_tipo_retencion_ivaSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencion_ivaSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencion_ivaSriCompras() {
		return this.resaltarid_tipo_retencion_ivaSriCompras;
	}

	public void setResaltarid_tipo_retencion_ivaSriCompras(Border borderResaltar) {
		this.resaltarid_tipo_retencion_ivaSriCompras= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencion_ivaSriCompras() {
		return this.mostrarid_tipo_retencion_ivaSriCompras;
	}

	public void setMostrarid_tipo_retencion_ivaSriCompras(Boolean mostrarid_tipo_retencion_ivaSriCompras) {
		this.mostrarid_tipo_retencion_ivaSriCompras= mostrarid_tipo_retencion_ivaSriCompras;
	}

	public Boolean getActivarid_tipo_retencion_ivaSriCompras() {
		return this.activarid_tipo_retencion_ivaSriCompras;
	}

	public void setActivarid_tipo_retencion_ivaSriCompras(Boolean activarid_tipo_retencion_ivaSriCompras) {
		this.activarid_tipo_retencion_ivaSriCompras= activarid_tipo_retencion_ivaSriCompras;
	}

	public Boolean getCargarid_tipo_retencion_ivaSriCompras() {
		return this.cargarid_tipo_retencion_ivaSriCompras;
	}

	public void setCargarid_tipo_retencion_ivaSriCompras(Boolean cargarid_tipo_retencion_ivaSriCompras) {
		this.cargarid_tipo_retencion_ivaSriCompras= cargarid_tipo_retencion_ivaSriCompras;
	}

	public Border setResaltartransfe_iva_retenidoSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltartransfe_iva_retenidoSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartransfe_iva_retenidoSriCompras() {
		return this.resaltartransfe_iva_retenidoSriCompras;
	}

	public void setResaltartransfe_iva_retenidoSriCompras(Border borderResaltar) {
		this.resaltartransfe_iva_retenidoSriCompras= borderResaltar;
	}

	public Boolean getMostrartransfe_iva_retenidoSriCompras() {
		return this.mostrartransfe_iva_retenidoSriCompras;
	}

	public void setMostrartransfe_iva_retenidoSriCompras(Boolean mostrartransfe_iva_retenidoSriCompras) {
		this.mostrartransfe_iva_retenidoSriCompras= mostrartransfe_iva_retenidoSriCompras;
	}

	public Boolean getActivartransfe_iva_retenidoSriCompras() {
		return this.activartransfe_iva_retenidoSriCompras;
	}

	public void setActivartransfe_iva_retenidoSriCompras(Boolean activartransfe_iva_retenidoSriCompras) {
		this.activartransfe_iva_retenidoSriCompras= activartransfe_iva_retenidoSriCompras;
	}

	public Border setResaltarpresta_iva_retenerSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarpresta_iva_retenerSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpresta_iva_retenerSriCompras() {
		return this.resaltarpresta_iva_retenerSriCompras;
	}

	public void setResaltarpresta_iva_retenerSriCompras(Border borderResaltar) {
		this.resaltarpresta_iva_retenerSriCompras= borderResaltar;
	}

	public Boolean getMostrarpresta_iva_retenerSriCompras() {
		return this.mostrarpresta_iva_retenerSriCompras;
	}

	public void setMostrarpresta_iva_retenerSriCompras(Boolean mostrarpresta_iva_retenerSriCompras) {
		this.mostrarpresta_iva_retenerSriCompras= mostrarpresta_iva_retenerSriCompras;
	}

	public Boolean getActivarpresta_iva_retenerSriCompras() {
		return this.activarpresta_iva_retenerSriCompras;
	}

	public void setActivarpresta_iva_retenerSriCompras(Boolean activarpresta_iva_retenerSriCompras) {
		this.activarpresta_iva_retenerSriCompras= activarpresta_iva_retenerSriCompras;
	}

	public Border setResaltarid_tipo_retencion_iva_prestaSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencion_iva_prestaSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencion_iva_prestaSriCompras() {
		return this.resaltarid_tipo_retencion_iva_prestaSriCompras;
	}

	public void setResaltarid_tipo_retencion_iva_prestaSriCompras(Border borderResaltar) {
		this.resaltarid_tipo_retencion_iva_prestaSriCompras= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencion_iva_prestaSriCompras() {
		return this.mostrarid_tipo_retencion_iva_prestaSriCompras;
	}

	public void setMostrarid_tipo_retencion_iva_prestaSriCompras(Boolean mostrarid_tipo_retencion_iva_prestaSriCompras) {
		this.mostrarid_tipo_retencion_iva_prestaSriCompras= mostrarid_tipo_retencion_iva_prestaSriCompras;
	}

	public Boolean getActivarid_tipo_retencion_iva_prestaSriCompras() {
		return this.activarid_tipo_retencion_iva_prestaSriCompras;
	}

	public void setActivarid_tipo_retencion_iva_prestaSriCompras(Boolean activarid_tipo_retencion_iva_prestaSriCompras) {
		this.activarid_tipo_retencion_iva_prestaSriCompras= activarid_tipo_retencion_iva_prestaSriCompras;
	}

	public Boolean getCargarid_tipo_retencion_iva_prestaSriCompras() {
		return this.cargarid_tipo_retencion_iva_prestaSriCompras;
	}

	public void setCargarid_tipo_retencion_iva_prestaSriCompras(Boolean cargarid_tipo_retencion_iva_prestaSriCompras) {
		this.cargarid_tipo_retencion_iva_prestaSriCompras= cargarid_tipo_retencion_iva_prestaSriCompras;
	}

	public Border setResaltarpresta_iva_retenidoSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarpresta_iva_retenidoSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpresta_iva_retenidoSriCompras() {
		return this.resaltarpresta_iva_retenidoSriCompras;
	}

	public void setResaltarpresta_iva_retenidoSriCompras(Border borderResaltar) {
		this.resaltarpresta_iva_retenidoSriCompras= borderResaltar;
	}

	public Boolean getMostrarpresta_iva_retenidoSriCompras() {
		return this.mostrarpresta_iva_retenidoSriCompras;
	}

	public void setMostrarpresta_iva_retenidoSriCompras(Boolean mostrarpresta_iva_retenidoSriCompras) {
		this.mostrarpresta_iva_retenidoSriCompras= mostrarpresta_iva_retenidoSriCompras;
	}

	public Boolean getActivarpresta_iva_retenidoSriCompras() {
		return this.activarpresta_iva_retenidoSriCompras;
	}

	public void setActivarpresta_iva_retenidoSriCompras(Boolean activarpresta_iva_retenidoSriCompras) {
		this.activarpresta_iva_retenidoSriCompras= activarpresta_iva_retenidoSriCompras;
	}

	public Border setResaltarfecha_caducidadSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarfecha_caducidadSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_caducidadSriCompras() {
		return this.resaltarfecha_caducidadSriCompras;
	}

	public void setResaltarfecha_caducidadSriCompras(Border borderResaltar) {
		this.resaltarfecha_caducidadSriCompras= borderResaltar;
	}

	public Boolean getMostrarfecha_caducidadSriCompras() {
		return this.mostrarfecha_caducidadSriCompras;
	}

	public void setMostrarfecha_caducidadSriCompras(Boolean mostrarfecha_caducidadSriCompras) {
		this.mostrarfecha_caducidadSriCompras= mostrarfecha_caducidadSriCompras;
	}

	public Boolean getActivarfecha_caducidadSriCompras() {
		return this.activarfecha_caducidadSriCompras;
	}

	public void setActivarfecha_caducidadSriCompras(Boolean activarfecha_caducidadSriCompras) {
		this.activarfecha_caducidadSriCompras= activarfecha_caducidadSriCompras;
	}

	public Border setResaltarcodigo_asiento_contableSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarcodigo_asiento_contableSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_asiento_contableSriCompras() {
		return this.resaltarcodigo_asiento_contableSriCompras;
	}

	public void setResaltarcodigo_asiento_contableSriCompras(Border borderResaltar) {
		this.resaltarcodigo_asiento_contableSriCompras= borderResaltar;
	}

	public Boolean getMostrarcodigo_asiento_contableSriCompras() {
		return this.mostrarcodigo_asiento_contableSriCompras;
	}

	public void setMostrarcodigo_asiento_contableSriCompras(Boolean mostrarcodigo_asiento_contableSriCompras) {
		this.mostrarcodigo_asiento_contableSriCompras= mostrarcodigo_asiento_contableSriCompras;
	}

	public Boolean getActivarcodigo_asiento_contableSriCompras() {
		return this.activarcodigo_asiento_contableSriCompras;
	}

	public void setActivarcodigo_asiento_contableSriCompras(Boolean activarcodigo_asiento_contableSriCompras) {
		this.activarcodigo_asiento_contableSriCompras= activarcodigo_asiento_contableSriCompras;
	}

	public Border setResaltarnumero_documento_contableSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sricomprasBeanSwingJInternalFrame.jTtoolBarSriCompras.setBorder(borderResaltar);
		
		this.resaltarnumero_documento_contableSriCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_documento_contableSriCompras() {
		return this.resaltarnumero_documento_contableSriCompras;
	}

	public void setResaltarnumero_documento_contableSriCompras(Border borderResaltar) {
		this.resaltarnumero_documento_contableSriCompras= borderResaltar;
	}

	public Boolean getMostrarnumero_documento_contableSriCompras() {
		return this.mostrarnumero_documento_contableSriCompras;
	}

	public void setMostrarnumero_documento_contableSriCompras(Boolean mostrarnumero_documento_contableSriCompras) {
		this.mostrarnumero_documento_contableSriCompras= mostrarnumero_documento_contableSriCompras;
	}

	public Boolean getActivarnumero_documento_contableSriCompras() {
		return this.activarnumero_documento_contableSriCompras;
	}

	public void setActivarnumero_documento_contableSriCompras(Boolean activarnumero_documento_contableSriCompras) {
		this.activarnumero_documento_contableSriCompras= activarnumero_documento_contableSriCompras;
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
		
		
		this.setMostraridSriCompras(esInicial);
		this.setMostrarid_empresaSriCompras(esInicial);
		this.setMostrarid_periodo_declaraSriCompras(esInicial);
		this.setMostrarid_clienteSriCompras(esInicial);
		this.setMostrarrucSriCompras(esInicial);
		this.setMostrarnombre_tipo_comprobanteSriCompras(esInicial);
		this.setMostrarnombre_completo_clienteSriCompras(esInicial);
		this.setMostrarruc_datoSriCompras(esInicial);
		this.setMostrarnumero_documentoSriCompras(esInicial);
		this.setMostrarfecha_emisionSriCompras(esInicial);
		this.setMostrarfecha_registro_contableSriCompras(esInicial);
		this.setMostrarnumero_serieSriCompras(esInicial);
		this.setMostrarnumero_autorizacionSriCompras(esInicial);
		this.setMostrarbienes_ivaSriCompras(esInicial);
		this.setMostrarservicion_ivaSriCompras(esInicial);
		this.setMostrartotal_ivaSriCompras(esInicial);
		this.setMostrarbienes_sin_ivaSriCompras(esInicial);
		this.setMostrarservicios_sin_ivaSriCompras(esInicial);
		this.setMostrartotal_sin_ivaSriCompras(esInicial);
		this.setMostrarid_tipo_ivaSriCompras(esInicial);
		this.setMostrarmonto_ivaSriCompras(esInicial);
		this.setMostrarmonto_iceSriCompras(esInicial);
		this.setMostrartransfe_iva_retenerSriCompras(esInicial);
		this.setMostrarid_tipo_retencion_ivaSriCompras(esInicial);
		this.setMostrartransfe_iva_retenidoSriCompras(esInicial);
		this.setMostrarpresta_iva_retenerSriCompras(esInicial);
		this.setMostrarid_tipo_retencion_iva_prestaSriCompras(esInicial);
		this.setMostrarpresta_iva_retenidoSriCompras(esInicial);
		this.setMostrarfecha_caducidadSriCompras(esInicial);
		this.setMostrarcodigo_asiento_contableSriCompras(esInicial);
		this.setMostrarnumero_documento_contableSriCompras(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SriComprasConstantesFunciones.ID)) {
				this.setMostraridSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.IDPERIODODECLARA)) {
				this.setMostrarid_periodo_declaraSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.RUC)) {
				this.setMostrarrucSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.NOMBRETIPOCOMPROBANTE)) {
				this.setMostrarnombre_tipo_comprobanteSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clienteSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.RUCDATO)) {
				this.setMostrarruc_datoSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.NUMERODOCUMENTO)) {
				this.setMostrarnumero_documentoSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.FECHAREGISTROCONTABLE)) {
				this.setMostrarfecha_registro_contableSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.NUMEROSERIE)) {
				this.setMostrarnumero_serieSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setMostrarnumero_autorizacionSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.BIENESIVA)) {
				this.setMostrarbienes_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.SERVICIONIVA)) {
				this.setMostrarservicion_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.TOTALIVA)) {
				this.setMostrartotal_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.BIENESSINIVA)) {
				this.setMostrarbienes_sin_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.SERVICIOSSINIVA)) {
				this.setMostrarservicios_sin_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.TOTALSINIVA)) {
				this.setMostrartotal_sin_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.IDTIPOIVA)) {
				this.setMostrarid_tipo_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.MONTOIVA)) {
				this.setMostrarmonto_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.MONTOICE)) {
				this.setMostrarmonto_iceSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.TRANSFEIVARETENER)) {
				this.setMostrartransfe_iva_retenerSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.IDTIPORETENCIONIVA)) {
				this.setMostrarid_tipo_retencion_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.TRANSFEIVARETENIDO)) {
				this.setMostrartransfe_iva_retenidoSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.PRESTAIVARETENER)) {
				this.setMostrarpresta_iva_retenerSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.IDTIPORETENCIONIVAPRESTA)) {
				this.setMostrarid_tipo_retencion_iva_prestaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.PRESTAIVARETENIDO)) {
				this.setMostrarpresta_iva_retenidoSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.FECHACADUCIDAD)) {
				this.setMostrarfecha_caducidadSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.CODIGOASIENTOCONTABLE)) {
				this.setMostrarcodigo_asiento_contableSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.NUMERODOCUMENTOCONTABLE)) {
				this.setMostrarnumero_documento_contableSriCompras(esAsigna);
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
		
		
		this.setActivaridSriCompras(esInicial);
		this.setActivarid_empresaSriCompras(esInicial);
		this.setActivarid_periodo_declaraSriCompras(esInicial);
		this.setActivarid_clienteSriCompras(esInicial);
		this.setActivarrucSriCompras(esInicial);
		this.setActivarnombre_tipo_comprobanteSriCompras(esInicial);
		this.setActivarnombre_completo_clienteSriCompras(esInicial);
		this.setActivarruc_datoSriCompras(esInicial);
		this.setActivarnumero_documentoSriCompras(esInicial);
		this.setActivarfecha_emisionSriCompras(esInicial);
		this.setActivarfecha_registro_contableSriCompras(esInicial);
		this.setActivarnumero_serieSriCompras(esInicial);
		this.setActivarnumero_autorizacionSriCompras(esInicial);
		this.setActivarbienes_ivaSriCompras(esInicial);
		this.setActivarservicion_ivaSriCompras(esInicial);
		this.setActivartotal_ivaSriCompras(esInicial);
		this.setActivarbienes_sin_ivaSriCompras(esInicial);
		this.setActivarservicios_sin_ivaSriCompras(esInicial);
		this.setActivartotal_sin_ivaSriCompras(esInicial);
		this.setActivarid_tipo_ivaSriCompras(esInicial);
		this.setActivarmonto_ivaSriCompras(esInicial);
		this.setActivarmonto_iceSriCompras(esInicial);
		this.setActivartransfe_iva_retenerSriCompras(esInicial);
		this.setActivarid_tipo_retencion_ivaSriCompras(esInicial);
		this.setActivartransfe_iva_retenidoSriCompras(esInicial);
		this.setActivarpresta_iva_retenerSriCompras(esInicial);
		this.setActivarid_tipo_retencion_iva_prestaSriCompras(esInicial);
		this.setActivarpresta_iva_retenidoSriCompras(esInicial);
		this.setActivarfecha_caducidadSriCompras(esInicial);
		this.setActivarcodigo_asiento_contableSriCompras(esInicial);
		this.setActivarnumero_documento_contableSriCompras(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SriComprasConstantesFunciones.ID)) {
				this.setActivaridSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.IDPERIODODECLARA)) {
				this.setActivarid_periodo_declaraSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.RUC)) {
				this.setActivarrucSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.NOMBRETIPOCOMPROBANTE)) {
				this.setActivarnombre_tipo_comprobanteSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clienteSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.RUCDATO)) {
				this.setActivarruc_datoSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.NUMERODOCUMENTO)) {
				this.setActivarnumero_documentoSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.FECHAREGISTROCONTABLE)) {
				this.setActivarfecha_registro_contableSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.NUMEROSERIE)) {
				this.setActivarnumero_serieSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setActivarnumero_autorizacionSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.BIENESIVA)) {
				this.setActivarbienes_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.SERVICIONIVA)) {
				this.setActivarservicion_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.TOTALIVA)) {
				this.setActivartotal_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.BIENESSINIVA)) {
				this.setActivarbienes_sin_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.SERVICIOSSINIVA)) {
				this.setActivarservicios_sin_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.TOTALSINIVA)) {
				this.setActivartotal_sin_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.IDTIPOIVA)) {
				this.setActivarid_tipo_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.MONTOIVA)) {
				this.setActivarmonto_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.MONTOICE)) {
				this.setActivarmonto_iceSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.TRANSFEIVARETENER)) {
				this.setActivartransfe_iva_retenerSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.IDTIPORETENCIONIVA)) {
				this.setActivarid_tipo_retencion_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.TRANSFEIVARETENIDO)) {
				this.setActivartransfe_iva_retenidoSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.PRESTAIVARETENER)) {
				this.setActivarpresta_iva_retenerSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.IDTIPORETENCIONIVAPRESTA)) {
				this.setActivarid_tipo_retencion_iva_prestaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.PRESTAIVARETENIDO)) {
				this.setActivarpresta_iva_retenidoSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.FECHACADUCIDAD)) {
				this.setActivarfecha_caducidadSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.CODIGOASIENTOCONTABLE)) {
				this.setActivarcodigo_asiento_contableSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.NUMERODOCUMENTOCONTABLE)) {
				this.setActivarnumero_documento_contableSriCompras(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSriCompras(esInicial);
		this.setResaltarid_empresaSriCompras(esInicial);
		this.setResaltarid_periodo_declaraSriCompras(esInicial);
		this.setResaltarid_clienteSriCompras(esInicial);
		this.setResaltarrucSriCompras(esInicial);
		this.setResaltarnombre_tipo_comprobanteSriCompras(esInicial);
		this.setResaltarnombre_completo_clienteSriCompras(esInicial);
		this.setResaltarruc_datoSriCompras(esInicial);
		this.setResaltarnumero_documentoSriCompras(esInicial);
		this.setResaltarfecha_emisionSriCompras(esInicial);
		this.setResaltarfecha_registro_contableSriCompras(esInicial);
		this.setResaltarnumero_serieSriCompras(esInicial);
		this.setResaltarnumero_autorizacionSriCompras(esInicial);
		this.setResaltarbienes_ivaSriCompras(esInicial);
		this.setResaltarservicion_ivaSriCompras(esInicial);
		this.setResaltartotal_ivaSriCompras(esInicial);
		this.setResaltarbienes_sin_ivaSriCompras(esInicial);
		this.setResaltarservicios_sin_ivaSriCompras(esInicial);
		this.setResaltartotal_sin_ivaSriCompras(esInicial);
		this.setResaltarid_tipo_ivaSriCompras(esInicial);
		this.setResaltarmonto_ivaSriCompras(esInicial);
		this.setResaltarmonto_iceSriCompras(esInicial);
		this.setResaltartransfe_iva_retenerSriCompras(esInicial);
		this.setResaltarid_tipo_retencion_ivaSriCompras(esInicial);
		this.setResaltartransfe_iva_retenidoSriCompras(esInicial);
		this.setResaltarpresta_iva_retenerSriCompras(esInicial);
		this.setResaltarid_tipo_retencion_iva_prestaSriCompras(esInicial);
		this.setResaltarpresta_iva_retenidoSriCompras(esInicial);
		this.setResaltarfecha_caducidadSriCompras(esInicial);
		this.setResaltarcodigo_asiento_contableSriCompras(esInicial);
		this.setResaltarnumero_documento_contableSriCompras(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SriComprasConstantesFunciones.ID)) {
				this.setResaltaridSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.IDPERIODODECLARA)) {
				this.setResaltarid_periodo_declaraSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.RUC)) {
				this.setResaltarrucSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.NOMBRETIPOCOMPROBANTE)) {
				this.setResaltarnombre_tipo_comprobanteSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clienteSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.RUCDATO)) {
				this.setResaltarruc_datoSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.NUMERODOCUMENTO)) {
				this.setResaltarnumero_documentoSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.FECHAREGISTROCONTABLE)) {
				this.setResaltarfecha_registro_contableSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.NUMEROSERIE)) {
				this.setResaltarnumero_serieSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setResaltarnumero_autorizacionSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.BIENESIVA)) {
				this.setResaltarbienes_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.SERVICIONIVA)) {
				this.setResaltarservicion_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.TOTALIVA)) {
				this.setResaltartotal_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.BIENESSINIVA)) {
				this.setResaltarbienes_sin_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.SERVICIOSSINIVA)) {
				this.setResaltarservicios_sin_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.TOTALSINIVA)) {
				this.setResaltartotal_sin_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.IDTIPOIVA)) {
				this.setResaltarid_tipo_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.MONTOIVA)) {
				this.setResaltarmonto_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.MONTOICE)) {
				this.setResaltarmonto_iceSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.TRANSFEIVARETENER)) {
				this.setResaltartransfe_iva_retenerSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.IDTIPORETENCIONIVA)) {
				this.setResaltarid_tipo_retencion_ivaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.TRANSFEIVARETENIDO)) {
				this.setResaltartransfe_iva_retenidoSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.PRESTAIVARETENER)) {
				this.setResaltarpresta_iva_retenerSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.IDTIPORETENCIONIVAPRESTA)) {
				this.setResaltarid_tipo_retencion_iva_prestaSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.PRESTAIVARETENIDO)) {
				this.setResaltarpresta_iva_retenidoSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.FECHACADUCIDAD)) {
				this.setResaltarfecha_caducidadSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.CODIGOASIENTOCONTABLE)) {
				this.setResaltarcodigo_asiento_contableSriCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriComprasConstantesFunciones.NUMERODOCUMENTOCONTABLE)) {
				this.setResaltarnumero_documento_contableSriCompras(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaSriComprasSriCompras=true;

	public Boolean getMostrarBusquedaSriComprasSriCompras() {
		return this.mostrarBusquedaSriComprasSriCompras;
	}

	public void setMostrarBusquedaSriComprasSriCompras(Boolean visibilidadResaltar) {
		this.mostrarBusquedaSriComprasSriCompras= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaSriComprasSriCompras=true;

	public Boolean getActivarBusquedaSriComprasSriCompras() {
		return this.activarBusquedaSriComprasSriCompras;
	}

	public void setActivarBusquedaSriComprasSriCompras(Boolean habilitarResaltar) {
		this.activarBusquedaSriComprasSriCompras= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaSriComprasSriCompras=null;

	public Border getResaltarBusquedaSriComprasSriCompras() {
		return this.resaltarBusquedaSriComprasSriCompras;
	}

	public void setResaltarBusquedaSriComprasSriCompras(Border borderResaltar) {
		this.resaltarBusquedaSriComprasSriCompras= borderResaltar;
	}

	public void setResaltarBusquedaSriComprasSriCompras(ParametroGeneralUsuario parametroGeneralUsuario/*SriComprasBeanSwingJInternalFrame sricomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaSriComprasSriCompras= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}