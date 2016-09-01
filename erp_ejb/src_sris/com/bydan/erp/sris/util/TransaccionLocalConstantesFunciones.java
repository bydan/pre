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
package com.bydan.erp.sris.util;

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


import com.bydan.erp.sris.util.TransaccionLocalConstantesFunciones;
import com.bydan.erp.sris.util.TransaccionLocalParameterReturnGeneral;
//import com.bydan.erp.sris.util.TransaccionLocalParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.sris.business.entity.*;



import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.sris.business.dataaccess.*;
//import com.bydan.erp.sris.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TransaccionLocalConstantesFunciones extends TransaccionLocalConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,-20);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,-20);	
	
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
	public static final String SNOMBREOPCION="TransaccionLocal";
	public static final String SPATHOPCION="Sris";	
	public static final String SPATHMODULO="sris/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TransaccionLocal"+TransaccionLocalConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TransaccionLocalHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TransaccionLocalHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TransaccionLocalConstantesFunciones.SCHEMA+"_"+TransaccionLocalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TransaccionLocalHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TransaccionLocalConstantesFunciones.SCHEMA+"_"+TransaccionLocalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TransaccionLocalConstantesFunciones.SCHEMA+"_"+TransaccionLocalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TransaccionLocalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TransaccionLocalConstantesFunciones.SCHEMA+"_"+TransaccionLocalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionLocalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransaccionLocalHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionLocalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionLocalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransaccionLocalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionLocalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TransaccionLocalConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TransaccionLocalConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TransaccionLocalConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TransaccionLocalConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Transaccion Locales";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Transaccion Local";
	public static final String SCLASSWEBTITULO_LOWER="Transaccion Local";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TransaccionLocal";
	public static final String OBJECTNAME="transaccionlocal";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SRIS;	
	public static final String TABLENAME="transaccion_local";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select transaccionlocal from "+TransaccionLocalConstantesFunciones.SPERSISTENCENAME+" transaccionlocal";
	public static String QUERYSELECTNATIVE="select "+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".version_row,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id_compra,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".ruc,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".razon_social,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id_periodo_declara,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id_transaccion_conta,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id_cliente,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".identificacion,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id_tipo_comprobante,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".fecha_emision,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".fecha_registro_contable,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".numero_secuencial,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".numero_serie,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".numero_autorizacion,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".fecha_caducidad,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id_tipo_tributario,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".numero_documento_contable,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id_asiento_contable,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".es_rise,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".bienes_iva,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".bienes_sin_iva,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id_tipo_iva,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".servicios_iva,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".servicios_sin_iva,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".monto_iva,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".total_iva,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".total_sin_iva,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".monto_ice,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".transfe_iva_retener,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".presta_iva_retener,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id_tipo_retencion_iva,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id_tipo_retencion_iva_presta,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".transfe_iva_retenido,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".presta_iva_retenido,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".permite_devolucion from "+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME;//+" as "+TransaccionLocalConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TransaccionLocalConstantesFuncionesAdditional transaccionlocalConstantesFuncionesAdditional=null;
	
	public TransaccionLocalConstantesFuncionesAdditional getTransaccionLocalConstantesFuncionesAdditional() {
		return this.transaccionlocalConstantesFuncionesAdditional;
	}
	
	public void setTransaccionLocalConstantesFuncionesAdditional(TransaccionLocalConstantesFuncionesAdditional transaccionlocalConstantesFuncionesAdditional) {
		try {
			this.transaccionlocalConstantesFuncionesAdditional=transaccionlocalConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDCOMPRA= "id_compra";
    public static final String RUC= "ruc";
    public static final String RAZONSOCIAL= "razon_social";
    public static final String IDPERIODODECLARA= "id_periodo_declara";
    public static final String IDTRANSACCIONCONTA= "id_transaccion_conta";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDENTIFICACION= "identificacion";
    public static final String IDTIPOCOMPROBANTE= "id_tipo_comprobante";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAREGISTROCONTABLE= "fecha_registro_contable";
    public static final String NUMEROSECUENCIAL= "numero_secuencial";
    public static final String NUMEROSERIE= "numero_serie";
    public static final String NUMEROAUTORIZACION= "numero_autorizacion";
    public static final String FECHACADUCIDAD= "fecha_caducidad";
    public static final String IDTIPOTRIBUTARIO= "id_tipo_tributario";
    public static final String NUMERODOCUMENTOCONTABLE= "numero_documento_contable";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String ESRISE= "es_rise";
    public static final String BIENESIVA= "bienes_iva";
    public static final String BIENESSINIVA= "bienes_sin_iva";
    public static final String IDTIPOIVA= "id_tipo_iva";
    public static final String SERVICIOSIVA= "servicios_iva";
    public static final String SERVICIOSSINIVA= "servicios_sin_iva";
    public static final String MONTOIVA= "monto_iva";
    public static final String TOTALIVA= "total_iva";
    public static final String TOTALSINIVA= "total_sin_iva";
    public static final String MONTOICE= "monto_ice";
    public static final String TRANSFEIVARETENER= "transfe_iva_retener";
    public static final String PRESTAIVARETENER= "presta_iva_retener";
    public static final String IDTIPORETENCIONIVA= "id_tipo_retencion_iva";
    public static final String IDTIPORETENCIONIVAPRESTA= "id_tipo_retencion_iva_presta";
    public static final String TRANSFEIVARETENIDO= "transfe_iva_retenido";
    public static final String PRESTAIVARETENIDO= "presta_iva_retenido";
    public static final String PERMITEDEVOLUCION= "permite_devolucion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDCOMPRA= "Compra";
		public static final String LABEL_IDCOMPRA_LOWER= "Compra";
    	public static final String LABEL_RUC= "Ruc Informante";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_RAZONSOCIAL= "Razon Social";
		public static final String LABEL_RAZONSOCIAL_LOWER= "Razon Social";
    	public static final String LABEL_IDPERIODODECLARA= "Periodo Declara";
		public static final String LABEL_IDPERIODODECLARA_LOWER= "Periodo Declara";
    	public static final String LABEL_IDTRANSACCIONCONTA= "Transaccion";
		public static final String LABEL_IDTRANSACCIONCONTA_LOWER= "Transaccion Conta";
    	public static final String LABEL_IDCLIENTE= "Prove/Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDENTIFICACION= "Identificacion";
		public static final String LABEL_IDENTIFICACION_LOWER= "Identificacion";
    	public static final String LABEL_IDTIPOCOMPROBANTE= "T. Comprobante";
		public static final String LABEL_IDTIPOCOMPROBANTE_LOWER= "Tipo Comprobante";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAREGISTROCONTABLE= "Fecha Reg Contable";
		public static final String LABEL_FECHAREGISTROCONTABLE_LOWER= "Fecha Registro Contable";
    	public static final String LABEL_NUMEROSECUENCIAL= "Nro Secuencial";
		public static final String LABEL_NUMEROSECUENCIAL_LOWER= "Numero Secuencial";
    	public static final String LABEL_NUMEROSERIE= "Nro Serie";
		public static final String LABEL_NUMEROSERIE_LOWER= "Numero Serie";
    	public static final String LABEL_NUMEROAUTORIZACION= "Nro Autorizacion";
		public static final String LABEL_NUMEROAUTORIZACION_LOWER= "Numero Autorizacion";
    	public static final String LABEL_FECHACADUCIDAD= "Fecha Caducidad";
		public static final String LABEL_FECHACADUCIDAD_LOWER= "Fecha Caducidad";
    	public static final String LABEL_IDTIPOTRIBUTARIO= "Cod. Tributario";
		public static final String LABEL_IDTIPOTRIBUTARIO_LOWER= "Tipo Tributario";
    	public static final String LABEL_NUMERODOCUMENTOCONTABLE= "Nro Documento";
		public static final String LABEL_NUMERODOCUMENTOCONTABLE_LOWER= "Numero Documento Contable";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento C.";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_ESRISE= "Es Rise";
		public static final String LABEL_ESRISE_LOWER= "Es Rise";
    	public static final String LABEL_BIENESIVA= "Bienes Iva";
		public static final String LABEL_BIENESIVA_LOWER= "Bienes Iva";
    	public static final String LABEL_BIENESSINIVA= "BienesTarifa 0";
		public static final String LABEL_BIENESSINIVA_LOWER= "Bienes Sin Iva";
    	public static final String LABEL_IDTIPOIVA= "% Iva";
		public static final String LABEL_IDTIPOIVA_LOWER= "Tipo Iva";
    	public static final String LABEL_SERVICIOSIVA= "Servicios Iva";
		public static final String LABEL_SERVICIOSIVA_LOWER= "Servicios Iva";
    	public static final String LABEL_SERVICIOSSINIVA= "Servicios Tarifa 0";
		public static final String LABEL_SERVICIOSSINIVA_LOWER= "Servicios Sin Iva";
    	public static final String LABEL_MONTOIVA= "Monto Iva";
		public static final String LABEL_MONTOIVA_LOWER= "Monto Iva";
    	public static final String LABEL_TOTALIVA= "B. Ímp. Iva";
		public static final String LABEL_TOTALIVA_LOWER= "Total Iva";
    	public static final String LABEL_TOTALSINIVA= "B. Imp. Tarifa 0";
		public static final String LABEL_TOTALSINIVA_LOWER= "Total Sin Iva";
    	public static final String LABEL_MONTOICE= "Monto ICE";
		public static final String LABEL_MONTOICE_LOWER= "Monto Ice";
    	public static final String LABEL_TRANSFEIVARETENER= "Monto Iva Retener";
		public static final String LABEL_TRANSFEIVARETENER_LOWER= "Transfe Iva Retener";
    	public static final String LABEL_PRESTAIVARETENER= "Monto Iva Retener.";
		public static final String LABEL_PRESTAIVARETENER_LOWER= "Presta Iva Retener";
    	public static final String LABEL_IDTIPORETENCIONIVA= "% Iva_";
		public static final String LABEL_IDTIPORETENCIONIVA_LOWER= "Tipo Retencion Iva";
    	public static final String LABEL_IDTIPORETENCIONIVAPRESTA= "% Iva.";
		public static final String LABEL_IDTIPORETENCIONIVAPRESTA_LOWER= "Tipo Retencion Iva Presta";
    	public static final String LABEL_TRANSFEIVARETENIDO= "Iva Retenido";
		public static final String LABEL_TRANSFEIVARETENIDO_LOWER= "Transfe Iva Retenido";
    	public static final String LABEL_PRESTAIVARETENIDO= "Iva Retenido.";
		public static final String LABEL_PRESTAIVARETENIDO_LOWER= "Presta Iva Retenido";
    	public static final String LABEL_PERMITEDEVOLUCION= "Con Devolucion";
		public static final String LABEL_PERMITEDEVOLUCION_LOWER= "Permite Devolucion";
	
		
		
		
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRAZON_SOCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRAZON_SOCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXIDENTIFICACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXIDENTIFICACION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_SERIE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SERIE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_AUTORIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_AUTORIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_DOCUMENTO_CONTABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_DOCUMENTO_CONTABLE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getTransaccionLocalLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.IDCOMPRA)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_IDCOMPRA;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.RUC)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.RAZONSOCIAL)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_RAZONSOCIAL;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.IDPERIODODECLARA)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_IDPERIODODECLARA;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.IDTRANSACCIONCONTA)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_IDTRANSACCIONCONTA;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.IDCLIENTE)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.IDENTIFICACION)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_IDENTIFICACION;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.IDTIPOCOMPROBANTE)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_IDTIPOCOMPROBANTE;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.FECHAEMISION)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.FECHAREGISTROCONTABLE)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_FECHAREGISTROCONTABLE;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.NUMEROSECUENCIAL)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_NUMEROSECUENCIAL;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.NUMEROSERIE)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_NUMEROSERIE;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.NUMEROAUTORIZACION)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_NUMEROAUTORIZACION;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.FECHACADUCIDAD)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_FECHACADUCIDAD;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.IDTIPOTRIBUTARIO)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_IDTIPOTRIBUTARIO;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.NUMERODOCUMENTOCONTABLE)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_NUMERODOCUMENTOCONTABLE;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.ESRISE)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_ESRISE;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.BIENESIVA)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_BIENESIVA;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.BIENESSINIVA)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_BIENESSINIVA;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.IDTIPOIVA)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_IDTIPOIVA;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.SERVICIOSIVA)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_SERVICIOSIVA;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.SERVICIOSSINIVA)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_SERVICIOSSINIVA;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.MONTOIVA)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_MONTOIVA;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.TOTALIVA)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_TOTALIVA;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.TOTALSINIVA)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_TOTALSINIVA;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.MONTOICE)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_MONTOICE;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.TRANSFEIVARETENER)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_TRANSFEIVARETENER;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.PRESTAIVARETENER)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_PRESTAIVARETENER;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVA)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_IDTIPORETENCIONIVA;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVAPRESTA)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_IDTIPORETENCIONIVAPRESTA;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.TRANSFEIVARETENIDO)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_TRANSFEIVARETENIDO;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.PRESTAIVARETENIDO)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_PRESTAIVARETENIDO;}
		if(sNombreColumna.equals(TransaccionLocalConstantesFunciones.PERMITEDEVOLUCION)) {sLabelColumna=TransaccionLocalConstantesFunciones.LABEL_PERMITEDEVOLUCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_riseDescripcion(TransaccionLocal transaccionlocal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!transaccionlocal.getes_rise()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_riseHtmlDescripcion(TransaccionLocal transaccionlocal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(transaccionlocal.getId(),transaccionlocal.getes_rise());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getpermite_devolucionDescripcion(TransaccionLocal transaccionlocal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!transaccionlocal.getpermite_devolucion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getpermite_devolucionHtmlDescripcion(TransaccionLocal transaccionlocal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(transaccionlocal.getId(),transaccionlocal.getpermite_devolucion());

		return sDescripcion;
	}	
	
	public static String getTransaccionLocalDescripcion(TransaccionLocal transaccionlocal) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(transaccionlocal !=null/* && transaccionlocal.getId()!=0*/) {
			sDescripcion=transaccionlocal.getrazon_social();//transaccionlocaltransaccionlocal.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTransaccionLocalDescripcionDetallado(TransaccionLocal transaccionlocal) {
		String sDescripcion="";
			
		sDescripcion+=TransaccionLocalConstantesFunciones.ID+"=";
		sDescripcion+=transaccionlocal.getId().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=transaccionlocal.getVersionRow().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.IDCOMPRA+"=";
		sDescripcion+=transaccionlocal.getid_compra().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.RUC+"=";
		sDescripcion+=transaccionlocal.getruc()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.RAZONSOCIAL+"=";
		sDescripcion+=transaccionlocal.getrazon_social()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.IDPERIODODECLARA+"=";
		sDescripcion+=transaccionlocal.getid_periodo_declara().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.IDTRANSACCIONCONTA+"=";
		sDescripcion+=transaccionlocal.getid_transaccion_conta().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=transaccionlocal.getid_cliente().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.IDENTIFICACION+"=";
		sDescripcion+=transaccionlocal.getidentificacion()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.IDTIPOCOMPROBANTE+"=";
		sDescripcion+=transaccionlocal.getid_tipo_comprobante().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=transaccionlocal.getfecha_emision().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.FECHAREGISTROCONTABLE+"=";
		sDescripcion+=transaccionlocal.getfecha_registro_contable().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.NUMEROSECUENCIAL+"=";
		sDescripcion+=transaccionlocal.getnumero_secuencial()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.NUMEROSERIE+"=";
		sDescripcion+=transaccionlocal.getnumero_serie()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.NUMEROAUTORIZACION+"=";
		sDescripcion+=transaccionlocal.getnumero_autorizacion()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.FECHACADUCIDAD+"=";
		sDescripcion+=transaccionlocal.getfecha_caducidad().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.IDTIPOTRIBUTARIO+"=";
		sDescripcion+=transaccionlocal.getid_tipo_tributario().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.NUMERODOCUMENTOCONTABLE+"=";
		sDescripcion+=transaccionlocal.getnumero_documento_contable()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=transaccionlocal.getid_asiento_contable().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.ESRISE+"=";
		sDescripcion+=transaccionlocal.getes_rise().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.BIENESIVA+"=";
		sDescripcion+=transaccionlocal.getbienes_iva().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.BIENESSINIVA+"=";
		sDescripcion+=transaccionlocal.getbienes_sin_iva().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.IDTIPOIVA+"=";
		sDescripcion+=transaccionlocal.getid_tipo_iva().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.SERVICIOSIVA+"=";
		sDescripcion+=transaccionlocal.getservicios_iva().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.SERVICIOSSINIVA+"=";
		sDescripcion+=transaccionlocal.getservicios_sin_iva().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.MONTOIVA+"=";
		sDescripcion+=transaccionlocal.getmonto_iva().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.TOTALIVA+"=";
		sDescripcion+=transaccionlocal.gettotal_iva().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.TOTALSINIVA+"=";
		sDescripcion+=transaccionlocal.gettotal_sin_iva().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.MONTOICE+"=";
		sDescripcion+=transaccionlocal.getmonto_ice().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.TRANSFEIVARETENER+"=";
		sDescripcion+=transaccionlocal.gettransfe_iva_retener().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.PRESTAIVARETENER+"=";
		sDescripcion+=transaccionlocal.getpresta_iva_retener().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVA+"=";
		sDescripcion+=transaccionlocal.getid_tipo_retencion_iva().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVAPRESTA+"=";
		sDescripcion+=transaccionlocal.getid_tipo_retencion_iva_presta().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.TRANSFEIVARETENIDO+"=";
		sDescripcion+=transaccionlocal.gettransfe_iva_retenido().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.PRESTAIVARETENIDO+"=";
		sDescripcion+=transaccionlocal.getpresta_iva_retenido().toString()+",";
		sDescripcion+=TransaccionLocalConstantesFunciones.PERMITEDEVOLUCION+"=";
		sDescripcion+=transaccionlocal.getpermite_devolucion().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTransaccionLocalDescripcion(TransaccionLocal transaccionlocal,String sValor) throws Exception {			
		if(transaccionlocal !=null) {
			transaccionlocal.setrazon_social(sValor);//transaccionlocaltransaccionlocal.getId().toString();
		}		
	}
	
		

	public static String getCompraDescripcion(Compra compra) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(compra!=null/*&&compra.getId()>0*/) {
			sDescripcion=CompraConstantesFunciones.getCompraDescripcion(compra);
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

	public static String getTransaccionContaDescripcion(TransaccionConta transaccionconta) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccionconta!=null/*&&transaccionconta.getId()>0*/) {
			sDescripcion=TransaccionContaConstantesFunciones.getTransaccionContaDescripcion(transaccionconta);
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

	public static String getTipoComprobanteDescripcion(TipoComprobante tipocomprobante) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocomprobante!=null/*&&tipocomprobante.getId()>0*/) {
			sDescripcion=TipoComprobanteConstantesFunciones.getTipoComprobanteDescripcion(tipocomprobante);
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

	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontable!=null/*&&asientocontable.getId()>0*/) {
			sDescripcion=AsientoContableConstantesFunciones.getAsientoContableDescripcion(asientocontable);
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

	public static String getTipoRetencionIvaDescripcion(TipoRetencionIva tiporetencioniva) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencioniva!=null/*&&tiporetencioniva.getId()>0*/) {
			sDescripcion=TipoRetencionIvaConstantesFunciones.getTipoRetencionIvaDescripcion(tiporetencioniva);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionIvaPrestaDescripcion(TipoRetencionIva tiporetencioniva) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencioniva!=null/*&&tiporetencioniva.getId()>0*/) {
			sDescripcion=TipoRetencionIvaConstantesFunciones.getTipoRetencionIvaDescripcion(tiporetencioniva);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento C.";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Prove/Cliente";
		} else if(sNombreIndice.equals("FK_IdCompra")) {
			sNombreIndice="Tipo=  Por Compra";
		} else if(sNombreIndice.equals("FK_IdPeriodoDeclara")) {
			sNombreIndice="Tipo=  Por Periodo Declara";
		} else if(sNombreIndice.equals("FK_IdTipoComprobante")) {
			sNombreIndice="Tipo=  Por T. Comprobante";
		} else if(sNombreIndice.equals("FK_IdTipoIva")) {
			sNombreIndice="Tipo=  Por % Iva";
		} else if(sNombreIndice.equals("FK_IdTipoRetencionIva")) {
			sNombreIndice="Tipo=  Por % Iva_";
		} else if(sNombreIndice.equals("FK_IdTipoRetencionIvaPresta")) {
			sNombreIndice="Tipo=  Por % Iva.";
		} else if(sNombreIndice.equals("FK_IdTipoTributario")) {
			sNombreIndice="Tipo=  Por Cod. Tributario";
		} else if(sNombreIndice.equals("FK_IdTransaccionConta")) {
			sNombreIndice="Tipo=  Por Transaccion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAsientoContable(Long id_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento C.="+id_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Prove/Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCompra(Long id_compra) {
		String sDetalleIndice=" Parametros->";
		if(id_compra!=null) {sDetalleIndice+=" Codigo Unico De Compra="+id_compra.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodoDeclara(Long id_periodo_declara) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo_declara!=null) {sDetalleIndice+=" Codigo Unico De Periodo Declara="+id_periodo_declara.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoComprobante(Long id_tipo_comprobante) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_comprobante!=null) {sDetalleIndice+=" Codigo Unico De T. Comprobante="+id_tipo_comprobante.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoIva(Long id_tipo_iva) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_iva!=null) {sDetalleIndice+=" Codigo Unico De % Iva="+id_tipo_iva.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencionIva(Long id_tipo_retencion_iva) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion_iva!=null) {sDetalleIndice+=" Codigo Unico De % Iva_="+id_tipo_retencion_iva.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencionIvaPresta(Long id_tipo_retencion_iva_presta) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion_iva_presta!=null) {sDetalleIndice+=" Codigo Unico De % Iva.="+id_tipo_retencion_iva_presta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTributario(Long id_tipo_tributario) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_tributario!=null) {sDetalleIndice+=" Codigo Unico De Cod. Tributario="+id_tipo_tributario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionConta(Long id_transaccion_conta) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_conta!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion_conta.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTransaccionLocal(TransaccionLocal transaccionlocal,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		transaccionlocal.setruc(transaccionlocal.getruc().trim());
		transaccionlocal.setrazon_social(transaccionlocal.getrazon_social().trim());
		transaccionlocal.setidentificacion(transaccionlocal.getidentificacion().trim());
		transaccionlocal.setnumero_secuencial(transaccionlocal.getnumero_secuencial().trim());
		transaccionlocal.setnumero_serie(transaccionlocal.getnumero_serie().trim());
		transaccionlocal.setnumero_autorizacion(transaccionlocal.getnumero_autorizacion().trim());
		transaccionlocal.setnumero_documento_contable(transaccionlocal.getnumero_documento_contable().trim());
	}
	
	public static void quitarEspaciosTransaccionLocals(List<TransaccionLocal> transaccionlocals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TransaccionLocal transaccionlocal: transaccionlocals) {
			transaccionlocal.setruc(transaccionlocal.getruc().trim());
			transaccionlocal.setrazon_social(transaccionlocal.getrazon_social().trim());
			transaccionlocal.setidentificacion(transaccionlocal.getidentificacion().trim());
			transaccionlocal.setnumero_secuencial(transaccionlocal.getnumero_secuencial().trim());
			transaccionlocal.setnumero_serie(transaccionlocal.getnumero_serie().trim());
			transaccionlocal.setnumero_autorizacion(transaccionlocal.getnumero_autorizacion().trim());
			transaccionlocal.setnumero_documento_contable(transaccionlocal.getnumero_documento_contable().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransaccionLocal(TransaccionLocal transaccionlocal,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && transaccionlocal.getConCambioAuxiliar()) {
			transaccionlocal.setIsDeleted(transaccionlocal.getIsDeletedAuxiliar());	
			transaccionlocal.setIsNew(transaccionlocal.getIsNewAuxiliar());	
			transaccionlocal.setIsChanged(transaccionlocal.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			transaccionlocal.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			transaccionlocal.setIsDeletedAuxiliar(false);	
			transaccionlocal.setIsNewAuxiliar(false);	
			transaccionlocal.setIsChangedAuxiliar(false);
			
			transaccionlocal.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransaccionLocals(List<TransaccionLocal> transaccionlocals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TransaccionLocal transaccionlocal : transaccionlocals) {
			if(conAsignarBase && transaccionlocal.getConCambioAuxiliar()) {
				transaccionlocal.setIsDeleted(transaccionlocal.getIsDeletedAuxiliar());	
				transaccionlocal.setIsNew(transaccionlocal.getIsNewAuxiliar());	
				transaccionlocal.setIsChanged(transaccionlocal.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				transaccionlocal.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				transaccionlocal.setIsDeletedAuxiliar(false);	
				transaccionlocal.setIsNewAuxiliar(false);	
				transaccionlocal.setIsChangedAuxiliar(false);
				
				transaccionlocal.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTransaccionLocal(TransaccionLocal transaccionlocal,Boolean conEnteros) throws Exception  {
		transaccionlocal.setbienes_iva(0.0);
		transaccionlocal.setbienes_sin_iva(0.0);
		transaccionlocal.setservicios_iva(0.0);
		transaccionlocal.setservicios_sin_iva(0.0);
		transaccionlocal.setmonto_iva(0.0);
		transaccionlocal.settotal_iva(0.0);
		transaccionlocal.settotal_sin_iva(0.0);
		transaccionlocal.setmonto_ice(0.0);
		transaccionlocal.settransfe_iva_retener(0.0);
		transaccionlocal.setpresta_iva_retener(0.0);
		transaccionlocal.settransfe_iva_retenido(0.0);
		transaccionlocal.setpresta_iva_retenido(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTransaccionLocals(List<TransaccionLocal> transaccionlocals,Boolean conEnteros) throws Exception  {
		
		for(TransaccionLocal transaccionlocal: transaccionlocals) {
			transaccionlocal.setbienes_iva(0.0);
			transaccionlocal.setbienes_sin_iva(0.0);
			transaccionlocal.setservicios_iva(0.0);
			transaccionlocal.setservicios_sin_iva(0.0);
			transaccionlocal.setmonto_iva(0.0);
			transaccionlocal.settotal_iva(0.0);
			transaccionlocal.settotal_sin_iva(0.0);
			transaccionlocal.setmonto_ice(0.0);
			transaccionlocal.settransfe_iva_retener(0.0);
			transaccionlocal.setpresta_iva_retener(0.0);
			transaccionlocal.settransfe_iva_retenido(0.0);
			transaccionlocal.setpresta_iva_retenido(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTransaccionLocal(List<TransaccionLocal> transaccionlocals,TransaccionLocal transaccionlocalAux) throws Exception  {
		TransaccionLocalConstantesFunciones.InicializarValoresTransaccionLocal(transaccionlocalAux,true);
		
		for(TransaccionLocal transaccionlocal: transaccionlocals) {
			if(transaccionlocal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			transaccionlocalAux.setbienes_iva(transaccionlocalAux.getbienes_iva()+transaccionlocal.getbienes_iva());			
			transaccionlocalAux.setbienes_sin_iva(transaccionlocalAux.getbienes_sin_iva()+transaccionlocal.getbienes_sin_iva());			
			transaccionlocalAux.setservicios_iva(transaccionlocalAux.getservicios_iva()+transaccionlocal.getservicios_iva());			
			transaccionlocalAux.setservicios_sin_iva(transaccionlocalAux.getservicios_sin_iva()+transaccionlocal.getservicios_sin_iva());			
			transaccionlocalAux.setmonto_iva(transaccionlocalAux.getmonto_iva()+transaccionlocal.getmonto_iva());			
			transaccionlocalAux.settotal_iva(transaccionlocalAux.gettotal_iva()+transaccionlocal.gettotal_iva());			
			transaccionlocalAux.settotal_sin_iva(transaccionlocalAux.gettotal_sin_iva()+transaccionlocal.gettotal_sin_iva());			
			transaccionlocalAux.setmonto_ice(transaccionlocalAux.getmonto_ice()+transaccionlocal.getmonto_ice());			
			transaccionlocalAux.settransfe_iva_retener(transaccionlocalAux.gettransfe_iva_retener()+transaccionlocal.gettransfe_iva_retener());			
			transaccionlocalAux.setpresta_iva_retener(transaccionlocalAux.getpresta_iva_retener()+transaccionlocal.getpresta_iva_retener());			
			transaccionlocalAux.settransfe_iva_retenido(transaccionlocalAux.gettransfe_iva_retenido()+transaccionlocal.gettransfe_iva_retenido());			
			transaccionlocalAux.setpresta_iva_retenido(transaccionlocalAux.getpresta_iva_retenido()+transaccionlocal.getpresta_iva_retenido());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTransaccionLocal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TransaccionLocalConstantesFunciones.getArrayColumnasGlobalesTransaccionLocal(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTransaccionLocal(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTransaccionLocal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TransaccionLocal> transaccionlocals,TransaccionLocal transaccionlocal,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TransaccionLocal transaccionlocalAux: transaccionlocals) {
			if(transaccionlocalAux!=null && transaccionlocal!=null) {
				if((transaccionlocalAux.getId()==null && transaccionlocal.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(transaccionlocalAux.getId()!=null && transaccionlocal.getId()!=null){
					if(transaccionlocalAux.getId().equals(transaccionlocal.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTransaccionLocal(List<TransaccionLocal> transaccionlocals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double bienes_ivaTotal=0.0;
		Double bienes_sin_ivaTotal=0.0;
		Double servicios_ivaTotal=0.0;
		Double servicios_sin_ivaTotal=0.0;
		Double monto_ivaTotal=0.0;
		Double total_ivaTotal=0.0;
		Double total_sin_ivaTotal=0.0;
		Double monto_iceTotal=0.0;
		Double transfe_iva_retenerTotal=0.0;
		Double presta_iva_retenerTotal=0.0;
		Double transfe_iva_retenidoTotal=0.0;
		Double presta_iva_retenidoTotal=0.0;
	
		for(TransaccionLocal transaccionlocal: transaccionlocals) {			
			if(transaccionlocal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			bienes_ivaTotal+=transaccionlocal.getbienes_iva();
			bienes_sin_ivaTotal+=transaccionlocal.getbienes_sin_iva();
			servicios_ivaTotal+=transaccionlocal.getservicios_iva();
			servicios_sin_ivaTotal+=transaccionlocal.getservicios_sin_iva();
			monto_ivaTotal+=transaccionlocal.getmonto_iva();
			total_ivaTotal+=transaccionlocal.gettotal_iva();
			total_sin_ivaTotal+=transaccionlocal.gettotal_sin_iva();
			monto_iceTotal+=transaccionlocal.getmonto_ice();
			transfe_iva_retenerTotal+=transaccionlocal.gettransfe_iva_retener();
			presta_iva_retenerTotal+=transaccionlocal.getpresta_iva_retener();
			transfe_iva_retenidoTotal+=transaccionlocal.gettransfe_iva_retenido();
			presta_iva_retenidoTotal+=transaccionlocal.getpresta_iva_retenido();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransaccionLocalConstantesFunciones.BIENESIVA);
		datoGeneral.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_BIENESIVA);
		datoGeneral.setdValorDouble(bienes_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransaccionLocalConstantesFunciones.BIENESSINIVA);
		datoGeneral.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_BIENESSINIVA);
		datoGeneral.setdValorDouble(bienes_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransaccionLocalConstantesFunciones.SERVICIOSIVA);
		datoGeneral.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_SERVICIOSIVA);
		datoGeneral.setdValorDouble(servicios_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransaccionLocalConstantesFunciones.SERVICIOSSINIVA);
		datoGeneral.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_SERVICIOSSINIVA);
		datoGeneral.setdValorDouble(servicios_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransaccionLocalConstantesFunciones.MONTOIVA);
		datoGeneral.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_MONTOIVA);
		datoGeneral.setdValorDouble(monto_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransaccionLocalConstantesFunciones.TOTALIVA);
		datoGeneral.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_TOTALIVA);
		datoGeneral.setdValorDouble(total_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransaccionLocalConstantesFunciones.TOTALSINIVA);
		datoGeneral.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_TOTALSINIVA);
		datoGeneral.setdValorDouble(total_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransaccionLocalConstantesFunciones.MONTOICE);
		datoGeneral.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_MONTOICE);
		datoGeneral.setdValorDouble(monto_iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransaccionLocalConstantesFunciones.TRANSFEIVARETENER);
		datoGeneral.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_TRANSFEIVARETENER);
		datoGeneral.setdValorDouble(transfe_iva_retenerTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransaccionLocalConstantesFunciones.PRESTAIVARETENER);
		datoGeneral.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_PRESTAIVARETENER);
		datoGeneral.setdValorDouble(presta_iva_retenerTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransaccionLocalConstantesFunciones.TRANSFEIVARETENIDO);
		datoGeneral.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_TRANSFEIVARETENIDO);
		datoGeneral.setdValorDouble(transfe_iva_retenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransaccionLocalConstantesFunciones.PRESTAIVARETENIDO);
		datoGeneral.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_PRESTAIVARETENIDO);
		datoGeneral.setdValorDouble(presta_iva_retenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTransaccionLocal() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_ID, TransaccionLocalConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_VERSIONROW, TransaccionLocalConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_IDCOMPRA, TransaccionLocalConstantesFunciones.IDCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_RUC, TransaccionLocalConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_RAZONSOCIAL, TransaccionLocalConstantesFunciones.RAZONSOCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_IDPERIODODECLARA, TransaccionLocalConstantesFunciones.IDPERIODODECLARA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_IDTRANSACCIONCONTA, TransaccionLocalConstantesFunciones.IDTRANSACCIONCONTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_IDCLIENTE, TransaccionLocalConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_IDENTIFICACION, TransaccionLocalConstantesFunciones.IDENTIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_IDTIPOCOMPROBANTE, TransaccionLocalConstantesFunciones.IDTIPOCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_FECHAEMISION, TransaccionLocalConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_FECHAREGISTROCONTABLE, TransaccionLocalConstantesFunciones.FECHAREGISTROCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_NUMEROSECUENCIAL, TransaccionLocalConstantesFunciones.NUMEROSECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_NUMEROSERIE, TransaccionLocalConstantesFunciones.NUMEROSERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_NUMEROAUTORIZACION, TransaccionLocalConstantesFunciones.NUMEROAUTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_FECHACADUCIDAD, TransaccionLocalConstantesFunciones.FECHACADUCIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_IDTIPOTRIBUTARIO, TransaccionLocalConstantesFunciones.IDTIPOTRIBUTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_NUMERODOCUMENTOCONTABLE, TransaccionLocalConstantesFunciones.NUMERODOCUMENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_IDASIENTOCONTABLE, TransaccionLocalConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_ESRISE, TransaccionLocalConstantesFunciones.ESRISE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_BIENESIVA, TransaccionLocalConstantesFunciones.BIENESIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_BIENESSINIVA, TransaccionLocalConstantesFunciones.BIENESSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_IDTIPOIVA, TransaccionLocalConstantesFunciones.IDTIPOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_SERVICIOSIVA, TransaccionLocalConstantesFunciones.SERVICIOSIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_SERVICIOSSINIVA, TransaccionLocalConstantesFunciones.SERVICIOSSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_MONTOIVA, TransaccionLocalConstantesFunciones.MONTOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_TOTALIVA, TransaccionLocalConstantesFunciones.TOTALIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_TOTALSINIVA, TransaccionLocalConstantesFunciones.TOTALSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_MONTOICE, TransaccionLocalConstantesFunciones.MONTOICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_TRANSFEIVARETENER, TransaccionLocalConstantesFunciones.TRANSFEIVARETENER,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_PRESTAIVARETENER, TransaccionLocalConstantesFunciones.PRESTAIVARETENER,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_IDTIPORETENCIONIVA, TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_IDTIPORETENCIONIVAPRESTA, TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVAPRESTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_TRANSFEIVARETENIDO, TransaccionLocalConstantesFunciones.TRANSFEIVARETENIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_PRESTAIVARETENIDO, TransaccionLocalConstantesFunciones.PRESTAIVARETENIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionLocalConstantesFunciones.LABEL_PERMITEDEVOLUCION, TransaccionLocalConstantesFunciones.PERMITEDEVOLUCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTransaccionLocal() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.IDCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.RAZONSOCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.IDPERIODODECLARA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.IDTRANSACCIONCONTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.IDENTIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.IDTIPOCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.FECHAREGISTROCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.NUMEROSECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.NUMEROSERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.NUMEROAUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.FECHACADUCIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.IDTIPOTRIBUTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.NUMERODOCUMENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.ESRISE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.BIENESIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.BIENESSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.IDTIPOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.SERVICIOSIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.SERVICIOSSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.MONTOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.TOTALIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.TOTALSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.MONTOICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.TRANSFEIVARETENER;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.PRESTAIVARETENER;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVAPRESTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.TRANSFEIVARETENIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.PRESTAIVARETENIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionLocalConstantesFunciones.PERMITEDEVOLUCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransaccionLocal() throws Exception  {
		return TransaccionLocalConstantesFunciones.getTiposSeleccionarTransaccionLocal(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransaccionLocal(Boolean conFk) throws Exception  {
		return TransaccionLocalConstantesFunciones.getTiposSeleccionarTransaccionLocal(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransaccionLocal(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_IDCOMPRA);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_IDCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_RAZONSOCIAL);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_RAZONSOCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_IDPERIODODECLARA);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_IDPERIODODECLARA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_IDTRANSACCIONCONTA);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_IDTRANSACCIONCONTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_IDENTIFICACION);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_IDENTIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_IDTIPOCOMPROBANTE);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_IDTIPOCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_FECHAREGISTROCONTABLE);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_FECHAREGISTROCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_NUMEROSECUENCIAL);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_NUMEROSECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_NUMEROSERIE);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_NUMEROSERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_NUMEROAUTORIZACION);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_NUMEROAUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_FECHACADUCIDAD);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_FECHACADUCIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_IDTIPOTRIBUTARIO);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_IDTIPOTRIBUTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_NUMERODOCUMENTOCONTABLE);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_NUMERODOCUMENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_ESRISE);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_ESRISE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_BIENESIVA);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_BIENESIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_BIENESSINIVA);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_BIENESSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_IDTIPOIVA);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_IDTIPOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_SERVICIOSIVA);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_SERVICIOSIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_SERVICIOSSINIVA);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_SERVICIOSSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_MONTOIVA);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_MONTOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_TOTALIVA);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_TOTALIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_TOTALSINIVA);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_TOTALSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_MONTOICE);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_MONTOICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_TRANSFEIVARETENER);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_TRANSFEIVARETENER);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_PRESTAIVARETENER);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_PRESTAIVARETENER);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_IDTIPORETENCIONIVA);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_IDTIPORETENCIONIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_IDTIPORETENCIONIVAPRESTA);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_IDTIPORETENCIONIVAPRESTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_TRANSFEIVARETENIDO);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_TRANSFEIVARETENIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_PRESTAIVARETENIDO);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_PRESTAIVARETENIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionLocalConstantesFunciones.LABEL_PERMITEDEVOLUCION);
			reporte.setsDescripcion(TransaccionLocalConstantesFunciones.LABEL_PERMITEDEVOLUCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTransaccionLocal(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTransaccionLocal(TransaccionLocal transaccionlocalAux) throws Exception {
		
			transaccionlocalAux.setcompra_descripcion(CompraConstantesFunciones.getCompraDescripcion(transaccionlocalAux.getCompra()));
			transaccionlocalAux.setperiododeclara_descripcion(PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(transaccionlocalAux.getPeriodoDeclara()));
			transaccionlocalAux.settransaccionconta_descripcion(TransaccionContaConstantesFunciones.getTransaccionContaDescripcion(transaccionlocalAux.getTransaccionConta()));
			transaccionlocalAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(transaccionlocalAux.getCliente()));
			transaccionlocalAux.settipocomprobante_descripcion(TipoComprobanteConstantesFunciones.getTipoComprobanteDescripcion(transaccionlocalAux.getTipoComprobante()));
			transaccionlocalAux.settipotributario_descripcion(TipoTributarioConstantesFunciones.getTipoTributarioDescripcion(transaccionlocalAux.getTipoTributario()));
			transaccionlocalAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(transaccionlocalAux.getAsientoContable()));
			transaccionlocalAux.settipoiva_descripcion(TipoIvaConstantesFunciones.getTipoIvaDescripcion(transaccionlocalAux.getTipoIva()));
			transaccionlocalAux.settiporetencioniva_descripcion(TipoRetencionIvaConstantesFunciones.getTipoRetencionIvaDescripcion(transaccionlocalAux.getTipoRetencionIva()));
			transaccionlocalAux.settiporetencionivapresta_descripcion(TipoRetencionIvaConstantesFunciones.getTipoRetencionIvaDescripcion(transaccionlocalAux.getTipoRetencionIvaPresta()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTransaccionLocal(List<TransaccionLocal> transaccionlocalsTemp) throws Exception {
		for(TransaccionLocal transaccionlocalAux:transaccionlocalsTemp) {
			
			transaccionlocalAux.setcompra_descripcion(CompraConstantesFunciones.getCompraDescripcion(transaccionlocalAux.getCompra()));
			transaccionlocalAux.setperiododeclara_descripcion(PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(transaccionlocalAux.getPeriodoDeclara()));
			transaccionlocalAux.settransaccionconta_descripcion(TransaccionContaConstantesFunciones.getTransaccionContaDescripcion(transaccionlocalAux.getTransaccionConta()));
			transaccionlocalAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(transaccionlocalAux.getCliente()));
			transaccionlocalAux.settipocomprobante_descripcion(TipoComprobanteConstantesFunciones.getTipoComprobanteDescripcion(transaccionlocalAux.getTipoComprobante()));
			transaccionlocalAux.settipotributario_descripcion(TipoTributarioConstantesFunciones.getTipoTributarioDescripcion(transaccionlocalAux.getTipoTributario()));
			transaccionlocalAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(transaccionlocalAux.getAsientoContable()));
			transaccionlocalAux.settipoiva_descripcion(TipoIvaConstantesFunciones.getTipoIvaDescripcion(transaccionlocalAux.getTipoIva()));
			transaccionlocalAux.settiporetencioniva_descripcion(TipoRetencionIvaConstantesFunciones.getTipoRetencionIvaDescripcion(transaccionlocalAux.getTipoRetencionIva()));
			transaccionlocalAux.settiporetencionivapresta_descripcion(TipoRetencionIvaConstantesFunciones.getTipoRetencionIvaDescripcion(transaccionlocalAux.getTipoRetencionIvaPresta()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTransaccionLocal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Compra.class));
				classes.add(new Classe(PeriodoDeclara.class));
				classes.add(new Classe(TransaccionConta.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoComprobante.class));
				classes.add(new Classe(TipoTributario.class));
				classes.add(new Classe(AsientoContable.class));
				classes.add(new Classe(TipoIva.class));
				classes.add(new Classe(TipoRetencionIva.class));
				classes.add(new Classe(TipoRetencionIva.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Compra.class)) {
						classes.add(new Classe(Compra.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PeriodoDeclara.class)) {
						classes.add(new Classe(PeriodoDeclara.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TransaccionConta.class)) {
						classes.add(new Classe(TransaccionConta.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoComprobante.class)) {
						classes.add(new Classe(TipoComprobante.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTributario.class)) {
						classes.add(new Classe(TipoTributario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoIva.class)) {
						classes.add(new Classe(TipoIva.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencionIva.class)) {
						classes.add(new Classe(TipoRetencionIva.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencionIva.class)) {
						classes.add(new Classe(TipoRetencionIva.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTransaccionLocal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Compra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Compra.class)); continue;
					}

					if(PeriodoDeclara.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PeriodoDeclara.class)); continue;
					}

					if(TransaccionConta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TransaccionConta.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoComprobante.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoComprobante.class)); continue;
					}

					if(TipoTributario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTributario.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(TipoIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIva.class)); continue;
					}

					if(TipoRetencionIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencionIva.class)); continue;
					}

					if(TipoRetencionIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencionIva.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Compra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Compra.class)); continue;
					}

					if(PeriodoDeclara.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PeriodoDeclara.class)); continue;
					}

					if(TransaccionConta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TransaccionConta.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoComprobante.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoComprobante.class)); continue;
					}

					if(TipoTributario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTributario.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(TipoIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIva.class)); continue;
					}

					if(TipoRetencionIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencionIva.class)); continue;
					}

					if(TipoRetencionIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencionIva.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransaccionLocal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransaccionLocalConstantesFunciones.getClassesRelationshipsOfTransaccionLocal(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransaccionLocal(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransaccionLocal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransaccionLocalConstantesFunciones.getClassesRelationshipsFromStringsOfTransaccionLocal(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransaccionLocal(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TransaccionLocal transaccionlocal,List<TransaccionLocal> transaccionlocals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TransaccionLocal transaccionlocalEncontrado=null;
			
			for(TransaccionLocal transaccionlocalLocal:transaccionlocals) {
				if(transaccionlocalLocal.getId().equals(transaccionlocal.getId())) {
					transaccionlocalEncontrado=transaccionlocalLocal;
					
					transaccionlocalLocal.setIsChanged(transaccionlocal.getIsChanged());
					transaccionlocalLocal.setIsNew(transaccionlocal.getIsNew());
					transaccionlocalLocal.setIsDeleted(transaccionlocal.getIsDeleted());
					
					transaccionlocalLocal.setGeneralEntityOriginal(transaccionlocal.getGeneralEntityOriginal());
					
					transaccionlocalLocal.setId(transaccionlocal.getId());	
					transaccionlocalLocal.setVersionRow(transaccionlocal.getVersionRow());	
					transaccionlocalLocal.setid_compra(transaccionlocal.getid_compra());	
					transaccionlocalLocal.setruc(transaccionlocal.getruc());	
					transaccionlocalLocal.setrazon_social(transaccionlocal.getrazon_social());	
					transaccionlocalLocal.setid_periodo_declara(transaccionlocal.getid_periodo_declara());	
					transaccionlocalLocal.setid_transaccion_conta(transaccionlocal.getid_transaccion_conta());	
					transaccionlocalLocal.setid_cliente(transaccionlocal.getid_cliente());	
					transaccionlocalLocal.setidentificacion(transaccionlocal.getidentificacion());	
					transaccionlocalLocal.setid_tipo_comprobante(transaccionlocal.getid_tipo_comprobante());	
					transaccionlocalLocal.setfecha_emision(transaccionlocal.getfecha_emision());	
					transaccionlocalLocal.setfecha_registro_contable(transaccionlocal.getfecha_registro_contable());	
					transaccionlocalLocal.setnumero_secuencial(transaccionlocal.getnumero_secuencial());	
					transaccionlocalLocal.setnumero_serie(transaccionlocal.getnumero_serie());	
					transaccionlocalLocal.setnumero_autorizacion(transaccionlocal.getnumero_autorizacion());	
					transaccionlocalLocal.setfecha_caducidad(transaccionlocal.getfecha_caducidad());	
					transaccionlocalLocal.setid_tipo_tributario(transaccionlocal.getid_tipo_tributario());	
					transaccionlocalLocal.setnumero_documento_contable(transaccionlocal.getnumero_documento_contable());	
					transaccionlocalLocal.setid_asiento_contable(transaccionlocal.getid_asiento_contable());	
					transaccionlocalLocal.setes_rise(transaccionlocal.getes_rise());	
					transaccionlocalLocal.setbienes_iva(transaccionlocal.getbienes_iva());	
					transaccionlocalLocal.setbienes_sin_iva(transaccionlocal.getbienes_sin_iva());	
					transaccionlocalLocal.setid_tipo_iva(transaccionlocal.getid_tipo_iva());	
					transaccionlocalLocal.setservicios_iva(transaccionlocal.getservicios_iva());	
					transaccionlocalLocal.setservicios_sin_iva(transaccionlocal.getservicios_sin_iva());	
					transaccionlocalLocal.setmonto_iva(transaccionlocal.getmonto_iva());	
					transaccionlocalLocal.settotal_iva(transaccionlocal.gettotal_iva());	
					transaccionlocalLocal.settotal_sin_iva(transaccionlocal.gettotal_sin_iva());	
					transaccionlocalLocal.setmonto_ice(transaccionlocal.getmonto_ice());	
					transaccionlocalLocal.settransfe_iva_retener(transaccionlocal.gettransfe_iva_retener());	
					transaccionlocalLocal.setpresta_iva_retener(transaccionlocal.getpresta_iva_retener());	
					transaccionlocalLocal.setid_tipo_retencion_iva(transaccionlocal.getid_tipo_retencion_iva());	
					transaccionlocalLocal.setid_tipo_retencion_iva_presta(transaccionlocal.getid_tipo_retencion_iva_presta());	
					transaccionlocalLocal.settransfe_iva_retenido(transaccionlocal.gettransfe_iva_retenido());	
					transaccionlocalLocal.setpresta_iva_retenido(transaccionlocal.getpresta_iva_retenido());	
					transaccionlocalLocal.setpermite_devolucion(transaccionlocal.getpermite_devolucion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!transaccionlocal.getIsDeleted()) {
				if(!existe) {
					transaccionlocals.add(transaccionlocal);
				}
			} else {
				if(transaccionlocalEncontrado!=null && permiteQuitar)  {
					transaccionlocals.remove(transaccionlocalEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TransaccionLocal transaccionlocal,List<TransaccionLocal> transaccionlocals) throws Exception {
		try	{			
			for(TransaccionLocal transaccionlocalLocal:transaccionlocals) {
				if(transaccionlocalLocal.getId().equals(transaccionlocal.getId())) {
					transaccionlocalLocal.setIsSelected(transaccionlocal.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTransaccionLocal(List<TransaccionLocal> transaccionlocalsAux) throws Exception {
		//this.transaccionlocalsAux=transaccionlocalsAux;
		
		for(TransaccionLocal transaccionlocalAux:transaccionlocalsAux) {
			if(transaccionlocalAux.getIsChanged()) {
				transaccionlocalAux.setIsChanged(false);
			}		
			
			if(transaccionlocalAux.getIsNew()) {
				transaccionlocalAux.setIsNew(false);
			}	
			
			if(transaccionlocalAux.getIsDeleted()) {
				transaccionlocalAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTransaccionLocal(TransaccionLocal transaccionlocalAux) throws Exception {
		//this.transaccionlocalAux=transaccionlocalAux;
		
			if(transaccionlocalAux.getIsChanged()) {
				transaccionlocalAux.setIsChanged(false);
			}		
			
			if(transaccionlocalAux.getIsNew()) {
				transaccionlocalAux.setIsNew(false);
			}	
			
			if(transaccionlocalAux.getIsDeleted()) {
				transaccionlocalAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TransaccionLocal transaccionlocalAsignar,TransaccionLocal transaccionlocal) throws Exception {
		transaccionlocalAsignar.setId(transaccionlocal.getId());	
		transaccionlocalAsignar.setVersionRow(transaccionlocal.getVersionRow());	
		transaccionlocalAsignar.setid_compra(transaccionlocal.getid_compra());
		transaccionlocalAsignar.setcompra_descripcion(transaccionlocal.getcompra_descripcion());	
		transaccionlocalAsignar.setruc(transaccionlocal.getruc());	
		transaccionlocalAsignar.setrazon_social(transaccionlocal.getrazon_social());	
		transaccionlocalAsignar.setid_periodo_declara(transaccionlocal.getid_periodo_declara());
		transaccionlocalAsignar.setperiododeclara_descripcion(transaccionlocal.getperiododeclara_descripcion());	
		transaccionlocalAsignar.setid_transaccion_conta(transaccionlocal.getid_transaccion_conta());
		transaccionlocalAsignar.settransaccionconta_descripcion(transaccionlocal.gettransaccionconta_descripcion());	
		transaccionlocalAsignar.setid_cliente(transaccionlocal.getid_cliente());
		transaccionlocalAsignar.setcliente_descripcion(transaccionlocal.getcliente_descripcion());	
		transaccionlocalAsignar.setidentificacion(transaccionlocal.getidentificacion());	
		transaccionlocalAsignar.setid_tipo_comprobante(transaccionlocal.getid_tipo_comprobante());
		transaccionlocalAsignar.settipocomprobante_descripcion(transaccionlocal.gettipocomprobante_descripcion());	
		transaccionlocalAsignar.setfecha_emision(transaccionlocal.getfecha_emision());	
		transaccionlocalAsignar.setfecha_registro_contable(transaccionlocal.getfecha_registro_contable());	
		transaccionlocalAsignar.setnumero_secuencial(transaccionlocal.getnumero_secuencial());	
		transaccionlocalAsignar.setnumero_serie(transaccionlocal.getnumero_serie());	
		transaccionlocalAsignar.setnumero_autorizacion(transaccionlocal.getnumero_autorizacion());	
		transaccionlocalAsignar.setfecha_caducidad(transaccionlocal.getfecha_caducidad());	
		transaccionlocalAsignar.setid_tipo_tributario(transaccionlocal.getid_tipo_tributario());
		transaccionlocalAsignar.settipotributario_descripcion(transaccionlocal.gettipotributario_descripcion());	
		transaccionlocalAsignar.setnumero_documento_contable(transaccionlocal.getnumero_documento_contable());	
		transaccionlocalAsignar.setid_asiento_contable(transaccionlocal.getid_asiento_contable());
		transaccionlocalAsignar.setasientocontable_descripcion(transaccionlocal.getasientocontable_descripcion());	
		transaccionlocalAsignar.setes_rise(transaccionlocal.getes_rise());	
		transaccionlocalAsignar.setbienes_iva(transaccionlocal.getbienes_iva());	
		transaccionlocalAsignar.setbienes_sin_iva(transaccionlocal.getbienes_sin_iva());	
		transaccionlocalAsignar.setid_tipo_iva(transaccionlocal.getid_tipo_iva());
		transaccionlocalAsignar.settipoiva_descripcion(transaccionlocal.gettipoiva_descripcion());	
		transaccionlocalAsignar.setservicios_iva(transaccionlocal.getservicios_iva());	
		transaccionlocalAsignar.setservicios_sin_iva(transaccionlocal.getservicios_sin_iva());	
		transaccionlocalAsignar.setmonto_iva(transaccionlocal.getmonto_iva());	
		transaccionlocalAsignar.settotal_iva(transaccionlocal.gettotal_iva());	
		transaccionlocalAsignar.settotal_sin_iva(transaccionlocal.gettotal_sin_iva());	
		transaccionlocalAsignar.setmonto_ice(transaccionlocal.getmonto_ice());	
		transaccionlocalAsignar.settransfe_iva_retener(transaccionlocal.gettransfe_iva_retener());	
		transaccionlocalAsignar.setpresta_iva_retener(transaccionlocal.getpresta_iva_retener());	
		transaccionlocalAsignar.setid_tipo_retencion_iva(transaccionlocal.getid_tipo_retencion_iva());
		transaccionlocalAsignar.settiporetencioniva_descripcion(transaccionlocal.gettiporetencioniva_descripcion());	
		transaccionlocalAsignar.setid_tipo_retencion_iva_presta(transaccionlocal.getid_tipo_retencion_iva_presta());
		transaccionlocalAsignar.settiporetencionivapresta_descripcion(transaccionlocal.gettiporetencionivapresta_descripcion());	
		transaccionlocalAsignar.settransfe_iva_retenido(transaccionlocal.gettransfe_iva_retenido());	
		transaccionlocalAsignar.setpresta_iva_retenido(transaccionlocal.getpresta_iva_retenido());	
		transaccionlocalAsignar.setpermite_devolucion(transaccionlocal.getpermite_devolucion());	
	}
	
	public static void inicializarTransaccionLocal(TransaccionLocal transaccionlocal) throws Exception {
		try {
				transaccionlocal.setId(0L);	
					
				transaccionlocal.setid_compra(null);	
				transaccionlocal.setruc("");	
				transaccionlocal.setrazon_social("");	
				transaccionlocal.setid_periodo_declara(-1L);	
				transaccionlocal.setid_transaccion_conta(-1L);	
				transaccionlocal.setid_cliente(-1L);	
				transaccionlocal.setidentificacion("");	
				transaccionlocal.setid_tipo_comprobante(-1L);	
				transaccionlocal.setfecha_emision(new Date());	
				transaccionlocal.setfecha_registro_contable(new Date());	
				transaccionlocal.setnumero_secuencial("");	
				transaccionlocal.setnumero_serie("");	
				transaccionlocal.setnumero_autorizacion("");	
				transaccionlocal.setfecha_caducidad(new Date());	
				transaccionlocal.setid_tipo_tributario(-1L);	
				transaccionlocal.setnumero_documento_contable("");	
				transaccionlocal.setid_asiento_contable(null);	
				transaccionlocal.setes_rise(false);	
				transaccionlocal.setbienes_iva(0.0);	
				transaccionlocal.setbienes_sin_iva(0.0);	
				transaccionlocal.setid_tipo_iva(-1L);	
				transaccionlocal.setservicios_iva(0.0);	
				transaccionlocal.setservicios_sin_iva(0.0);	
				transaccionlocal.setmonto_iva(0.0);	
				transaccionlocal.settotal_iva(0.0);	
				transaccionlocal.settotal_sin_iva(0.0);	
				transaccionlocal.setmonto_ice(0.0);	
				transaccionlocal.settransfe_iva_retener(0.0);	
				transaccionlocal.setpresta_iva_retener(0.0);	
				transaccionlocal.setid_tipo_retencion_iva(-1L);	
				transaccionlocal.setid_tipo_retencion_iva_presta(-1L);	
				transaccionlocal.settransfe_iva_retenido(0.0);	
				transaccionlocal.setpresta_iva_retenido(0.0);	
				transaccionlocal.setpermite_devolucion(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTransaccionLocal(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_IDCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_RAZONSOCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_IDPERIODODECLARA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_IDTRANSACCIONCONTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_IDENTIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_IDTIPOCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_FECHAREGISTROCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_NUMEROSECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_NUMEROSERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_NUMEROAUTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_FECHACADUCIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_IDTIPOTRIBUTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_NUMERODOCUMENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_ESRISE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_BIENESIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_BIENESSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_IDTIPOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_SERVICIOSIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_SERVICIOSSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_MONTOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_TOTALIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_TOTALSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_MONTOICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_TRANSFEIVARETENER);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_PRESTAIVARETENER);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_IDTIPORETENCIONIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_IDTIPORETENCIONIVAPRESTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_TRANSFEIVARETENIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_PRESTAIVARETENIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionLocalConstantesFunciones.LABEL_PERMITEDEVOLUCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTransaccionLocal(String sTipo,Row row,Workbook workbook,TransaccionLocal transaccionlocal,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.getcompra_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.getrazon_social());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.getperiododeclara_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.gettransaccionconta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.getidentificacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.gettipocomprobante_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.getfecha_registro_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.getnumero_secuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.getnumero_serie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.getnumero_autorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.getfecha_caducidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.gettipotributario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.getnumero_documento_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(transaccionlocal.getes_rise()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.getbienes_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.getbienes_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.gettipoiva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.getservicios_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.getservicios_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.getmonto_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.gettotal_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.gettotal_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.getmonto_ice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.gettransfe_iva_retener());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.getpresta_iva_retener());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.gettiporetencioniva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.gettiporetencionivapresta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.gettransfe_iva_retenido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionlocal.getpresta_iva_retenido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(transaccionlocal.getpermite_devolucion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTransaccionLocal=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTransaccionLocal() {
		return this.sFinalQueryTransaccionLocal;
	}
	
	public void setsFinalQueryTransaccionLocal(String sFinalQueryTransaccionLocal) {
		this.sFinalQueryTransaccionLocal= sFinalQueryTransaccionLocal;
	}
	
	public Border resaltarSeleccionarTransaccionLocal=null;
	
	public Border setResaltarSeleccionarTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTransaccionLocal= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTransaccionLocal() {
		return this.resaltarSeleccionarTransaccionLocal;
	}
	
	public void setResaltarSeleccionarTransaccionLocal(Border borderResaltarSeleccionarTransaccionLocal) {
		this.resaltarSeleccionarTransaccionLocal= borderResaltarSeleccionarTransaccionLocal;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTransaccionLocal=null;
	public Boolean mostraridTransaccionLocal=true;
	public Boolean activaridTransaccionLocal=true;

	public Border resaltarid_compraTransaccionLocal=null;
	public Boolean mostrarid_compraTransaccionLocal=true;
	public Boolean activarid_compraTransaccionLocal=false;
	public Boolean cargarid_compraTransaccionLocal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_compraTransaccionLocal=false;//ConEventDepend=true

	public Border resaltarrucTransaccionLocal=null;
	public Boolean mostrarrucTransaccionLocal=true;
	public Boolean activarrucTransaccionLocal=true;

	public Border resaltarrazon_socialTransaccionLocal=null;
	public Boolean mostrarrazon_socialTransaccionLocal=true;
	public Boolean activarrazon_socialTransaccionLocal=true;

	public Border resaltarid_periodo_declaraTransaccionLocal=null;
	public Boolean mostrarid_periodo_declaraTransaccionLocal=true;
	public Boolean activarid_periodo_declaraTransaccionLocal=true;
	public Boolean cargarid_periodo_declaraTransaccionLocal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodo_declaraTransaccionLocal=false;//ConEventDepend=true

	public Border resaltarid_transaccion_contaTransaccionLocal=null;
	public Boolean mostrarid_transaccion_contaTransaccionLocal=true;
	public Boolean activarid_transaccion_contaTransaccionLocal=true;
	public Boolean cargarid_transaccion_contaTransaccionLocal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_contaTransaccionLocal=false;//ConEventDepend=true

	public Border resaltarid_clienteTransaccionLocal=null;
	public Boolean mostrarid_clienteTransaccionLocal=true;
	public Boolean activarid_clienteTransaccionLocal=true;
	public Boolean cargarid_clienteTransaccionLocal=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteTransaccionLocal=false;//ConEventDepend=true

	public Border resaltaridentificacionTransaccionLocal=null;
	public Boolean mostraridentificacionTransaccionLocal=true;
	public Boolean activaridentificacionTransaccionLocal=true;

	public Border resaltarid_tipo_comprobanteTransaccionLocal=null;
	public Boolean mostrarid_tipo_comprobanteTransaccionLocal=true;
	public Boolean activarid_tipo_comprobanteTransaccionLocal=true;
	public Boolean cargarid_tipo_comprobanteTransaccionLocal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_comprobanteTransaccionLocal=false;//ConEventDepend=true

	public Border resaltarfecha_emisionTransaccionLocal=null;
	public Boolean mostrarfecha_emisionTransaccionLocal=true;
	public Boolean activarfecha_emisionTransaccionLocal=true;

	public Border resaltarfecha_registro_contableTransaccionLocal=null;
	public Boolean mostrarfecha_registro_contableTransaccionLocal=true;
	public Boolean activarfecha_registro_contableTransaccionLocal=true;

	public Border resaltarnumero_secuencialTransaccionLocal=null;
	public Boolean mostrarnumero_secuencialTransaccionLocal=true;
	public Boolean activarnumero_secuencialTransaccionLocal=true;

	public Border resaltarnumero_serieTransaccionLocal=null;
	public Boolean mostrarnumero_serieTransaccionLocal=true;
	public Boolean activarnumero_serieTransaccionLocal=true;

	public Border resaltarnumero_autorizacionTransaccionLocal=null;
	public Boolean mostrarnumero_autorizacionTransaccionLocal=true;
	public Boolean activarnumero_autorizacionTransaccionLocal=true;

	public Border resaltarfecha_caducidadTransaccionLocal=null;
	public Boolean mostrarfecha_caducidadTransaccionLocal=true;
	public Boolean activarfecha_caducidadTransaccionLocal=true;

	public Border resaltarid_tipo_tributarioTransaccionLocal=null;
	public Boolean mostrarid_tipo_tributarioTransaccionLocal=true;
	public Boolean activarid_tipo_tributarioTransaccionLocal=true;
	public Boolean cargarid_tipo_tributarioTransaccionLocal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_tributarioTransaccionLocal=false;//ConEventDepend=true

	public Border resaltarnumero_documento_contableTransaccionLocal=null;
	public Boolean mostrarnumero_documento_contableTransaccionLocal=true;
	public Boolean activarnumero_documento_contableTransaccionLocal=true;

	public Border resaltarid_asiento_contableTransaccionLocal=null;
	public Boolean mostrarid_asiento_contableTransaccionLocal=true;
	public Boolean activarid_asiento_contableTransaccionLocal=false;
	public Boolean cargarid_asiento_contableTransaccionLocal=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableTransaccionLocal=false;//ConEventDepend=true

	public Border resaltares_riseTransaccionLocal=null;
	public Boolean mostrares_riseTransaccionLocal=true;
	public Boolean activares_riseTransaccionLocal=true;

	public Border resaltarbienes_ivaTransaccionLocal=null;
	public Boolean mostrarbienes_ivaTransaccionLocal=true;
	public Boolean activarbienes_ivaTransaccionLocal=true;

	public Border resaltarbienes_sin_ivaTransaccionLocal=null;
	public Boolean mostrarbienes_sin_ivaTransaccionLocal=true;
	public Boolean activarbienes_sin_ivaTransaccionLocal=true;

	public Border resaltarid_tipo_ivaTransaccionLocal=null;
	public Boolean mostrarid_tipo_ivaTransaccionLocal=true;
	public Boolean activarid_tipo_ivaTransaccionLocal=true;
	public Boolean cargarid_tipo_ivaTransaccionLocal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_ivaTransaccionLocal=false;//ConEventDepend=true

	public Border resaltarservicios_ivaTransaccionLocal=null;
	public Boolean mostrarservicios_ivaTransaccionLocal=true;
	public Boolean activarservicios_ivaTransaccionLocal=true;

	public Border resaltarservicios_sin_ivaTransaccionLocal=null;
	public Boolean mostrarservicios_sin_ivaTransaccionLocal=true;
	public Boolean activarservicios_sin_ivaTransaccionLocal=true;

	public Border resaltarmonto_ivaTransaccionLocal=null;
	public Boolean mostrarmonto_ivaTransaccionLocal=true;
	public Boolean activarmonto_ivaTransaccionLocal=true;

	public Border resaltartotal_ivaTransaccionLocal=null;
	public Boolean mostrartotal_ivaTransaccionLocal=true;
	public Boolean activartotal_ivaTransaccionLocal=true;

	public Border resaltartotal_sin_ivaTransaccionLocal=null;
	public Boolean mostrartotal_sin_ivaTransaccionLocal=true;
	public Boolean activartotal_sin_ivaTransaccionLocal=true;

	public Border resaltarmonto_iceTransaccionLocal=null;
	public Boolean mostrarmonto_iceTransaccionLocal=true;
	public Boolean activarmonto_iceTransaccionLocal=true;

	public Border resaltartransfe_iva_retenerTransaccionLocal=null;
	public Boolean mostrartransfe_iva_retenerTransaccionLocal=true;
	public Boolean activartransfe_iva_retenerTransaccionLocal=true;

	public Border resaltarpresta_iva_retenerTransaccionLocal=null;
	public Boolean mostrarpresta_iva_retenerTransaccionLocal=true;
	public Boolean activarpresta_iva_retenerTransaccionLocal=true;

	public Border resaltarid_tipo_retencion_ivaTransaccionLocal=null;
	public Boolean mostrarid_tipo_retencion_ivaTransaccionLocal=true;
	public Boolean activarid_tipo_retencion_ivaTransaccionLocal=true;
	public Boolean cargarid_tipo_retencion_ivaTransaccionLocal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencion_ivaTransaccionLocal=false;//ConEventDepend=true

	public Border resaltarid_tipo_retencion_iva_prestaTransaccionLocal=null;
	public Boolean mostrarid_tipo_retencion_iva_prestaTransaccionLocal=true;
	public Boolean activarid_tipo_retencion_iva_prestaTransaccionLocal=true;
	public Boolean cargarid_tipo_retencion_iva_prestaTransaccionLocal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencion_iva_prestaTransaccionLocal=false;//ConEventDepend=true

	public Border resaltartransfe_iva_retenidoTransaccionLocal=null;
	public Boolean mostrartransfe_iva_retenidoTransaccionLocal=true;
	public Boolean activartransfe_iva_retenidoTransaccionLocal=true;

	public Border resaltarpresta_iva_retenidoTransaccionLocal=null;
	public Boolean mostrarpresta_iva_retenidoTransaccionLocal=true;
	public Boolean activarpresta_iva_retenidoTransaccionLocal=true;

	public Border resaltarpermite_devolucionTransaccionLocal=null;
	public Boolean mostrarpermite_devolucionTransaccionLocal=true;
	public Boolean activarpermite_devolucionTransaccionLocal=true;

	
	

	public Border setResaltaridTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltaridTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTransaccionLocal() {
		return this.resaltaridTransaccionLocal;
	}

	public void setResaltaridTransaccionLocal(Border borderResaltar) {
		this.resaltaridTransaccionLocal= borderResaltar;
	}

	public Boolean getMostraridTransaccionLocal() {
		return this.mostraridTransaccionLocal;
	}

	public void setMostraridTransaccionLocal(Boolean mostraridTransaccionLocal) {
		this.mostraridTransaccionLocal= mostraridTransaccionLocal;
	}

	public Boolean getActivaridTransaccionLocal() {
		return this.activaridTransaccionLocal;
	}

	public void setActivaridTransaccionLocal(Boolean activaridTransaccionLocal) {
		this.activaridTransaccionLocal= activaridTransaccionLocal;
	}

	public Border setResaltarid_compraTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarid_compraTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_compraTransaccionLocal() {
		return this.resaltarid_compraTransaccionLocal;
	}

	public void setResaltarid_compraTransaccionLocal(Border borderResaltar) {
		this.resaltarid_compraTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarid_compraTransaccionLocal() {
		return this.mostrarid_compraTransaccionLocal;
	}

	public void setMostrarid_compraTransaccionLocal(Boolean mostrarid_compraTransaccionLocal) {
		this.mostrarid_compraTransaccionLocal= mostrarid_compraTransaccionLocal;
	}

	public Boolean getActivarid_compraTransaccionLocal() {
		return this.activarid_compraTransaccionLocal;
	}

	public void setActivarid_compraTransaccionLocal(Boolean activarid_compraTransaccionLocal) {
		this.activarid_compraTransaccionLocal= activarid_compraTransaccionLocal;
	}

	public Boolean getCargarid_compraTransaccionLocal() {
		return this.cargarid_compraTransaccionLocal;
	}

	public void setCargarid_compraTransaccionLocal(Boolean cargarid_compraTransaccionLocal) {
		this.cargarid_compraTransaccionLocal= cargarid_compraTransaccionLocal;
	}

	public Border setResaltarrucTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarrucTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucTransaccionLocal() {
		return this.resaltarrucTransaccionLocal;
	}

	public void setResaltarrucTransaccionLocal(Border borderResaltar) {
		this.resaltarrucTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarrucTransaccionLocal() {
		return this.mostrarrucTransaccionLocal;
	}

	public void setMostrarrucTransaccionLocal(Boolean mostrarrucTransaccionLocal) {
		this.mostrarrucTransaccionLocal= mostrarrucTransaccionLocal;
	}

	public Boolean getActivarrucTransaccionLocal() {
		return this.activarrucTransaccionLocal;
	}

	public void setActivarrucTransaccionLocal(Boolean activarrucTransaccionLocal) {
		this.activarrucTransaccionLocal= activarrucTransaccionLocal;
	}

	public Border setResaltarrazon_socialTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarrazon_socialTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrazon_socialTransaccionLocal() {
		return this.resaltarrazon_socialTransaccionLocal;
	}

	public void setResaltarrazon_socialTransaccionLocal(Border borderResaltar) {
		this.resaltarrazon_socialTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarrazon_socialTransaccionLocal() {
		return this.mostrarrazon_socialTransaccionLocal;
	}

	public void setMostrarrazon_socialTransaccionLocal(Boolean mostrarrazon_socialTransaccionLocal) {
		this.mostrarrazon_socialTransaccionLocal= mostrarrazon_socialTransaccionLocal;
	}

	public Boolean getActivarrazon_socialTransaccionLocal() {
		return this.activarrazon_socialTransaccionLocal;
	}

	public void setActivarrazon_socialTransaccionLocal(Boolean activarrazon_socialTransaccionLocal) {
		this.activarrazon_socialTransaccionLocal= activarrazon_socialTransaccionLocal;
	}

	public Border setResaltarid_periodo_declaraTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarid_periodo_declaraTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodo_declaraTransaccionLocal() {
		return this.resaltarid_periodo_declaraTransaccionLocal;
	}

	public void setResaltarid_periodo_declaraTransaccionLocal(Border borderResaltar) {
		this.resaltarid_periodo_declaraTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarid_periodo_declaraTransaccionLocal() {
		return this.mostrarid_periodo_declaraTransaccionLocal;
	}

	public void setMostrarid_periodo_declaraTransaccionLocal(Boolean mostrarid_periodo_declaraTransaccionLocal) {
		this.mostrarid_periodo_declaraTransaccionLocal= mostrarid_periodo_declaraTransaccionLocal;
	}

	public Boolean getActivarid_periodo_declaraTransaccionLocal() {
		return this.activarid_periodo_declaraTransaccionLocal;
	}

	public void setActivarid_periodo_declaraTransaccionLocal(Boolean activarid_periodo_declaraTransaccionLocal) {
		this.activarid_periodo_declaraTransaccionLocal= activarid_periodo_declaraTransaccionLocal;
	}

	public Boolean getCargarid_periodo_declaraTransaccionLocal() {
		return this.cargarid_periodo_declaraTransaccionLocal;
	}

	public void setCargarid_periodo_declaraTransaccionLocal(Boolean cargarid_periodo_declaraTransaccionLocal) {
		this.cargarid_periodo_declaraTransaccionLocal= cargarid_periodo_declaraTransaccionLocal;
	}

	public Border setResaltarid_transaccion_contaTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_contaTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_contaTransaccionLocal() {
		return this.resaltarid_transaccion_contaTransaccionLocal;
	}

	public void setResaltarid_transaccion_contaTransaccionLocal(Border borderResaltar) {
		this.resaltarid_transaccion_contaTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_contaTransaccionLocal() {
		return this.mostrarid_transaccion_contaTransaccionLocal;
	}

	public void setMostrarid_transaccion_contaTransaccionLocal(Boolean mostrarid_transaccion_contaTransaccionLocal) {
		this.mostrarid_transaccion_contaTransaccionLocal= mostrarid_transaccion_contaTransaccionLocal;
	}

	public Boolean getActivarid_transaccion_contaTransaccionLocal() {
		return this.activarid_transaccion_contaTransaccionLocal;
	}

	public void setActivarid_transaccion_contaTransaccionLocal(Boolean activarid_transaccion_contaTransaccionLocal) {
		this.activarid_transaccion_contaTransaccionLocal= activarid_transaccion_contaTransaccionLocal;
	}

	public Boolean getCargarid_transaccion_contaTransaccionLocal() {
		return this.cargarid_transaccion_contaTransaccionLocal;
	}

	public void setCargarid_transaccion_contaTransaccionLocal(Boolean cargarid_transaccion_contaTransaccionLocal) {
		this.cargarid_transaccion_contaTransaccionLocal= cargarid_transaccion_contaTransaccionLocal;
	}

	public Border setResaltarid_clienteTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarid_clienteTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteTransaccionLocal() {
		return this.resaltarid_clienteTransaccionLocal;
	}

	public void setResaltarid_clienteTransaccionLocal(Border borderResaltar) {
		this.resaltarid_clienteTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarid_clienteTransaccionLocal() {
		return this.mostrarid_clienteTransaccionLocal;
	}

	public void setMostrarid_clienteTransaccionLocal(Boolean mostrarid_clienteTransaccionLocal) {
		this.mostrarid_clienteTransaccionLocal= mostrarid_clienteTransaccionLocal;
	}

	public Boolean getActivarid_clienteTransaccionLocal() {
		return this.activarid_clienteTransaccionLocal;
	}

	public void setActivarid_clienteTransaccionLocal(Boolean activarid_clienteTransaccionLocal) {
		this.activarid_clienteTransaccionLocal= activarid_clienteTransaccionLocal;
	}

	public Boolean getCargarid_clienteTransaccionLocal() {
		return this.cargarid_clienteTransaccionLocal;
	}

	public void setCargarid_clienteTransaccionLocal(Boolean cargarid_clienteTransaccionLocal) {
		this.cargarid_clienteTransaccionLocal= cargarid_clienteTransaccionLocal;
	}

	public Border setResaltaridentificacionTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltaridentificacionTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridentificacionTransaccionLocal() {
		return this.resaltaridentificacionTransaccionLocal;
	}

	public void setResaltaridentificacionTransaccionLocal(Border borderResaltar) {
		this.resaltaridentificacionTransaccionLocal= borderResaltar;
	}

	public Boolean getMostraridentificacionTransaccionLocal() {
		return this.mostraridentificacionTransaccionLocal;
	}

	public void setMostraridentificacionTransaccionLocal(Boolean mostraridentificacionTransaccionLocal) {
		this.mostraridentificacionTransaccionLocal= mostraridentificacionTransaccionLocal;
	}

	public Boolean getActivaridentificacionTransaccionLocal() {
		return this.activaridentificacionTransaccionLocal;
	}

	public void setActivaridentificacionTransaccionLocal(Boolean activaridentificacionTransaccionLocal) {
		this.activaridentificacionTransaccionLocal= activaridentificacionTransaccionLocal;
	}

	public Border setResaltarid_tipo_comprobanteTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarid_tipo_comprobanteTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_comprobanteTransaccionLocal() {
		return this.resaltarid_tipo_comprobanteTransaccionLocal;
	}

	public void setResaltarid_tipo_comprobanteTransaccionLocal(Border borderResaltar) {
		this.resaltarid_tipo_comprobanteTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarid_tipo_comprobanteTransaccionLocal() {
		return this.mostrarid_tipo_comprobanteTransaccionLocal;
	}

	public void setMostrarid_tipo_comprobanteTransaccionLocal(Boolean mostrarid_tipo_comprobanteTransaccionLocal) {
		this.mostrarid_tipo_comprobanteTransaccionLocal= mostrarid_tipo_comprobanteTransaccionLocal;
	}

	public Boolean getActivarid_tipo_comprobanteTransaccionLocal() {
		return this.activarid_tipo_comprobanteTransaccionLocal;
	}

	public void setActivarid_tipo_comprobanteTransaccionLocal(Boolean activarid_tipo_comprobanteTransaccionLocal) {
		this.activarid_tipo_comprobanteTransaccionLocal= activarid_tipo_comprobanteTransaccionLocal;
	}

	public Boolean getCargarid_tipo_comprobanteTransaccionLocal() {
		return this.cargarid_tipo_comprobanteTransaccionLocal;
	}

	public void setCargarid_tipo_comprobanteTransaccionLocal(Boolean cargarid_tipo_comprobanteTransaccionLocal) {
		this.cargarid_tipo_comprobanteTransaccionLocal= cargarid_tipo_comprobanteTransaccionLocal;
	}

	public Border setResaltarfecha_emisionTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionTransaccionLocal() {
		return this.resaltarfecha_emisionTransaccionLocal;
	}

	public void setResaltarfecha_emisionTransaccionLocal(Border borderResaltar) {
		this.resaltarfecha_emisionTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionTransaccionLocal() {
		return this.mostrarfecha_emisionTransaccionLocal;
	}

	public void setMostrarfecha_emisionTransaccionLocal(Boolean mostrarfecha_emisionTransaccionLocal) {
		this.mostrarfecha_emisionTransaccionLocal= mostrarfecha_emisionTransaccionLocal;
	}

	public Boolean getActivarfecha_emisionTransaccionLocal() {
		return this.activarfecha_emisionTransaccionLocal;
	}

	public void setActivarfecha_emisionTransaccionLocal(Boolean activarfecha_emisionTransaccionLocal) {
		this.activarfecha_emisionTransaccionLocal= activarfecha_emisionTransaccionLocal;
	}

	public Border setResaltarfecha_registro_contableTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarfecha_registro_contableTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_registro_contableTransaccionLocal() {
		return this.resaltarfecha_registro_contableTransaccionLocal;
	}

	public void setResaltarfecha_registro_contableTransaccionLocal(Border borderResaltar) {
		this.resaltarfecha_registro_contableTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarfecha_registro_contableTransaccionLocal() {
		return this.mostrarfecha_registro_contableTransaccionLocal;
	}

	public void setMostrarfecha_registro_contableTransaccionLocal(Boolean mostrarfecha_registro_contableTransaccionLocal) {
		this.mostrarfecha_registro_contableTransaccionLocal= mostrarfecha_registro_contableTransaccionLocal;
	}

	public Boolean getActivarfecha_registro_contableTransaccionLocal() {
		return this.activarfecha_registro_contableTransaccionLocal;
	}

	public void setActivarfecha_registro_contableTransaccionLocal(Boolean activarfecha_registro_contableTransaccionLocal) {
		this.activarfecha_registro_contableTransaccionLocal= activarfecha_registro_contableTransaccionLocal;
	}

	public Border setResaltarnumero_secuencialTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarnumero_secuencialTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_secuencialTransaccionLocal() {
		return this.resaltarnumero_secuencialTransaccionLocal;
	}

	public void setResaltarnumero_secuencialTransaccionLocal(Border borderResaltar) {
		this.resaltarnumero_secuencialTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarnumero_secuencialTransaccionLocal() {
		return this.mostrarnumero_secuencialTransaccionLocal;
	}

	public void setMostrarnumero_secuencialTransaccionLocal(Boolean mostrarnumero_secuencialTransaccionLocal) {
		this.mostrarnumero_secuencialTransaccionLocal= mostrarnumero_secuencialTransaccionLocal;
	}

	public Boolean getActivarnumero_secuencialTransaccionLocal() {
		return this.activarnumero_secuencialTransaccionLocal;
	}

	public void setActivarnumero_secuencialTransaccionLocal(Boolean activarnumero_secuencialTransaccionLocal) {
		this.activarnumero_secuencialTransaccionLocal= activarnumero_secuencialTransaccionLocal;
	}

	public Border setResaltarnumero_serieTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarnumero_serieTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_serieTransaccionLocal() {
		return this.resaltarnumero_serieTransaccionLocal;
	}

	public void setResaltarnumero_serieTransaccionLocal(Border borderResaltar) {
		this.resaltarnumero_serieTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarnumero_serieTransaccionLocal() {
		return this.mostrarnumero_serieTransaccionLocal;
	}

	public void setMostrarnumero_serieTransaccionLocal(Boolean mostrarnumero_serieTransaccionLocal) {
		this.mostrarnumero_serieTransaccionLocal= mostrarnumero_serieTransaccionLocal;
	}

	public Boolean getActivarnumero_serieTransaccionLocal() {
		return this.activarnumero_serieTransaccionLocal;
	}

	public void setActivarnumero_serieTransaccionLocal(Boolean activarnumero_serieTransaccionLocal) {
		this.activarnumero_serieTransaccionLocal= activarnumero_serieTransaccionLocal;
	}

	public Border setResaltarnumero_autorizacionTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarnumero_autorizacionTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_autorizacionTransaccionLocal() {
		return this.resaltarnumero_autorizacionTransaccionLocal;
	}

	public void setResaltarnumero_autorizacionTransaccionLocal(Border borderResaltar) {
		this.resaltarnumero_autorizacionTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarnumero_autorizacionTransaccionLocal() {
		return this.mostrarnumero_autorizacionTransaccionLocal;
	}

	public void setMostrarnumero_autorizacionTransaccionLocal(Boolean mostrarnumero_autorizacionTransaccionLocal) {
		this.mostrarnumero_autorizacionTransaccionLocal= mostrarnumero_autorizacionTransaccionLocal;
	}

	public Boolean getActivarnumero_autorizacionTransaccionLocal() {
		return this.activarnumero_autorizacionTransaccionLocal;
	}

	public void setActivarnumero_autorizacionTransaccionLocal(Boolean activarnumero_autorizacionTransaccionLocal) {
		this.activarnumero_autorizacionTransaccionLocal= activarnumero_autorizacionTransaccionLocal;
	}

	public Border setResaltarfecha_caducidadTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarfecha_caducidadTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_caducidadTransaccionLocal() {
		return this.resaltarfecha_caducidadTransaccionLocal;
	}

	public void setResaltarfecha_caducidadTransaccionLocal(Border borderResaltar) {
		this.resaltarfecha_caducidadTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarfecha_caducidadTransaccionLocal() {
		return this.mostrarfecha_caducidadTransaccionLocal;
	}

	public void setMostrarfecha_caducidadTransaccionLocal(Boolean mostrarfecha_caducidadTransaccionLocal) {
		this.mostrarfecha_caducidadTransaccionLocal= mostrarfecha_caducidadTransaccionLocal;
	}

	public Boolean getActivarfecha_caducidadTransaccionLocal() {
		return this.activarfecha_caducidadTransaccionLocal;
	}

	public void setActivarfecha_caducidadTransaccionLocal(Boolean activarfecha_caducidadTransaccionLocal) {
		this.activarfecha_caducidadTransaccionLocal= activarfecha_caducidadTransaccionLocal;
	}

	public Border setResaltarid_tipo_tributarioTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarid_tipo_tributarioTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_tributarioTransaccionLocal() {
		return this.resaltarid_tipo_tributarioTransaccionLocal;
	}

	public void setResaltarid_tipo_tributarioTransaccionLocal(Border borderResaltar) {
		this.resaltarid_tipo_tributarioTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarid_tipo_tributarioTransaccionLocal() {
		return this.mostrarid_tipo_tributarioTransaccionLocal;
	}

	public void setMostrarid_tipo_tributarioTransaccionLocal(Boolean mostrarid_tipo_tributarioTransaccionLocal) {
		this.mostrarid_tipo_tributarioTransaccionLocal= mostrarid_tipo_tributarioTransaccionLocal;
	}

	public Boolean getActivarid_tipo_tributarioTransaccionLocal() {
		return this.activarid_tipo_tributarioTransaccionLocal;
	}

	public void setActivarid_tipo_tributarioTransaccionLocal(Boolean activarid_tipo_tributarioTransaccionLocal) {
		this.activarid_tipo_tributarioTransaccionLocal= activarid_tipo_tributarioTransaccionLocal;
	}

	public Boolean getCargarid_tipo_tributarioTransaccionLocal() {
		return this.cargarid_tipo_tributarioTransaccionLocal;
	}

	public void setCargarid_tipo_tributarioTransaccionLocal(Boolean cargarid_tipo_tributarioTransaccionLocal) {
		this.cargarid_tipo_tributarioTransaccionLocal= cargarid_tipo_tributarioTransaccionLocal;
	}

	public Border setResaltarnumero_documento_contableTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarnumero_documento_contableTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_documento_contableTransaccionLocal() {
		return this.resaltarnumero_documento_contableTransaccionLocal;
	}

	public void setResaltarnumero_documento_contableTransaccionLocal(Border borderResaltar) {
		this.resaltarnumero_documento_contableTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarnumero_documento_contableTransaccionLocal() {
		return this.mostrarnumero_documento_contableTransaccionLocal;
	}

	public void setMostrarnumero_documento_contableTransaccionLocal(Boolean mostrarnumero_documento_contableTransaccionLocal) {
		this.mostrarnumero_documento_contableTransaccionLocal= mostrarnumero_documento_contableTransaccionLocal;
	}

	public Boolean getActivarnumero_documento_contableTransaccionLocal() {
		return this.activarnumero_documento_contableTransaccionLocal;
	}

	public void setActivarnumero_documento_contableTransaccionLocal(Boolean activarnumero_documento_contableTransaccionLocal) {
		this.activarnumero_documento_contableTransaccionLocal= activarnumero_documento_contableTransaccionLocal;
	}

	public Border setResaltarid_asiento_contableTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableTransaccionLocal() {
		return this.resaltarid_asiento_contableTransaccionLocal;
	}

	public void setResaltarid_asiento_contableTransaccionLocal(Border borderResaltar) {
		this.resaltarid_asiento_contableTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableTransaccionLocal() {
		return this.mostrarid_asiento_contableTransaccionLocal;
	}

	public void setMostrarid_asiento_contableTransaccionLocal(Boolean mostrarid_asiento_contableTransaccionLocal) {
		this.mostrarid_asiento_contableTransaccionLocal= mostrarid_asiento_contableTransaccionLocal;
	}

	public Boolean getActivarid_asiento_contableTransaccionLocal() {
		return this.activarid_asiento_contableTransaccionLocal;
	}

	public void setActivarid_asiento_contableTransaccionLocal(Boolean activarid_asiento_contableTransaccionLocal) {
		this.activarid_asiento_contableTransaccionLocal= activarid_asiento_contableTransaccionLocal;
	}

	public Boolean getCargarid_asiento_contableTransaccionLocal() {
		return this.cargarid_asiento_contableTransaccionLocal;
	}

	public void setCargarid_asiento_contableTransaccionLocal(Boolean cargarid_asiento_contableTransaccionLocal) {
		this.cargarid_asiento_contableTransaccionLocal= cargarid_asiento_contableTransaccionLocal;
	}

	public Border setResaltares_riseTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltares_riseTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_riseTransaccionLocal() {
		return this.resaltares_riseTransaccionLocal;
	}

	public void setResaltares_riseTransaccionLocal(Border borderResaltar) {
		this.resaltares_riseTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrares_riseTransaccionLocal() {
		return this.mostrares_riseTransaccionLocal;
	}

	public void setMostrares_riseTransaccionLocal(Boolean mostrares_riseTransaccionLocal) {
		this.mostrares_riseTransaccionLocal= mostrares_riseTransaccionLocal;
	}

	public Boolean getActivares_riseTransaccionLocal() {
		return this.activares_riseTransaccionLocal;
	}

	public void setActivares_riseTransaccionLocal(Boolean activares_riseTransaccionLocal) {
		this.activares_riseTransaccionLocal= activares_riseTransaccionLocal;
	}

	public Border setResaltarbienes_ivaTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarbienes_ivaTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbienes_ivaTransaccionLocal() {
		return this.resaltarbienes_ivaTransaccionLocal;
	}

	public void setResaltarbienes_ivaTransaccionLocal(Border borderResaltar) {
		this.resaltarbienes_ivaTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarbienes_ivaTransaccionLocal() {
		return this.mostrarbienes_ivaTransaccionLocal;
	}

	public void setMostrarbienes_ivaTransaccionLocal(Boolean mostrarbienes_ivaTransaccionLocal) {
		this.mostrarbienes_ivaTransaccionLocal= mostrarbienes_ivaTransaccionLocal;
	}

	public Boolean getActivarbienes_ivaTransaccionLocal() {
		return this.activarbienes_ivaTransaccionLocal;
	}

	public void setActivarbienes_ivaTransaccionLocal(Boolean activarbienes_ivaTransaccionLocal) {
		this.activarbienes_ivaTransaccionLocal= activarbienes_ivaTransaccionLocal;
	}

	public Border setResaltarbienes_sin_ivaTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarbienes_sin_ivaTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbienes_sin_ivaTransaccionLocal() {
		return this.resaltarbienes_sin_ivaTransaccionLocal;
	}

	public void setResaltarbienes_sin_ivaTransaccionLocal(Border borderResaltar) {
		this.resaltarbienes_sin_ivaTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarbienes_sin_ivaTransaccionLocal() {
		return this.mostrarbienes_sin_ivaTransaccionLocal;
	}

	public void setMostrarbienes_sin_ivaTransaccionLocal(Boolean mostrarbienes_sin_ivaTransaccionLocal) {
		this.mostrarbienes_sin_ivaTransaccionLocal= mostrarbienes_sin_ivaTransaccionLocal;
	}

	public Boolean getActivarbienes_sin_ivaTransaccionLocal() {
		return this.activarbienes_sin_ivaTransaccionLocal;
	}

	public void setActivarbienes_sin_ivaTransaccionLocal(Boolean activarbienes_sin_ivaTransaccionLocal) {
		this.activarbienes_sin_ivaTransaccionLocal= activarbienes_sin_ivaTransaccionLocal;
	}

	public Border setResaltarid_tipo_ivaTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarid_tipo_ivaTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_ivaTransaccionLocal() {
		return this.resaltarid_tipo_ivaTransaccionLocal;
	}

	public void setResaltarid_tipo_ivaTransaccionLocal(Border borderResaltar) {
		this.resaltarid_tipo_ivaTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarid_tipo_ivaTransaccionLocal() {
		return this.mostrarid_tipo_ivaTransaccionLocal;
	}

	public void setMostrarid_tipo_ivaTransaccionLocal(Boolean mostrarid_tipo_ivaTransaccionLocal) {
		this.mostrarid_tipo_ivaTransaccionLocal= mostrarid_tipo_ivaTransaccionLocal;
	}

	public Boolean getActivarid_tipo_ivaTransaccionLocal() {
		return this.activarid_tipo_ivaTransaccionLocal;
	}

	public void setActivarid_tipo_ivaTransaccionLocal(Boolean activarid_tipo_ivaTransaccionLocal) {
		this.activarid_tipo_ivaTransaccionLocal= activarid_tipo_ivaTransaccionLocal;
	}

	public Boolean getCargarid_tipo_ivaTransaccionLocal() {
		return this.cargarid_tipo_ivaTransaccionLocal;
	}

	public void setCargarid_tipo_ivaTransaccionLocal(Boolean cargarid_tipo_ivaTransaccionLocal) {
		this.cargarid_tipo_ivaTransaccionLocal= cargarid_tipo_ivaTransaccionLocal;
	}

	public Border setResaltarservicios_ivaTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarservicios_ivaTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarservicios_ivaTransaccionLocal() {
		return this.resaltarservicios_ivaTransaccionLocal;
	}

	public void setResaltarservicios_ivaTransaccionLocal(Border borderResaltar) {
		this.resaltarservicios_ivaTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarservicios_ivaTransaccionLocal() {
		return this.mostrarservicios_ivaTransaccionLocal;
	}

	public void setMostrarservicios_ivaTransaccionLocal(Boolean mostrarservicios_ivaTransaccionLocal) {
		this.mostrarservicios_ivaTransaccionLocal= mostrarservicios_ivaTransaccionLocal;
	}

	public Boolean getActivarservicios_ivaTransaccionLocal() {
		return this.activarservicios_ivaTransaccionLocal;
	}

	public void setActivarservicios_ivaTransaccionLocal(Boolean activarservicios_ivaTransaccionLocal) {
		this.activarservicios_ivaTransaccionLocal= activarservicios_ivaTransaccionLocal;
	}

	public Border setResaltarservicios_sin_ivaTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarservicios_sin_ivaTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarservicios_sin_ivaTransaccionLocal() {
		return this.resaltarservicios_sin_ivaTransaccionLocal;
	}

	public void setResaltarservicios_sin_ivaTransaccionLocal(Border borderResaltar) {
		this.resaltarservicios_sin_ivaTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarservicios_sin_ivaTransaccionLocal() {
		return this.mostrarservicios_sin_ivaTransaccionLocal;
	}

	public void setMostrarservicios_sin_ivaTransaccionLocal(Boolean mostrarservicios_sin_ivaTransaccionLocal) {
		this.mostrarservicios_sin_ivaTransaccionLocal= mostrarservicios_sin_ivaTransaccionLocal;
	}

	public Boolean getActivarservicios_sin_ivaTransaccionLocal() {
		return this.activarservicios_sin_ivaTransaccionLocal;
	}

	public void setActivarservicios_sin_ivaTransaccionLocal(Boolean activarservicios_sin_ivaTransaccionLocal) {
		this.activarservicios_sin_ivaTransaccionLocal= activarservicios_sin_ivaTransaccionLocal;
	}

	public Border setResaltarmonto_ivaTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarmonto_ivaTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_ivaTransaccionLocal() {
		return this.resaltarmonto_ivaTransaccionLocal;
	}

	public void setResaltarmonto_ivaTransaccionLocal(Border borderResaltar) {
		this.resaltarmonto_ivaTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarmonto_ivaTransaccionLocal() {
		return this.mostrarmonto_ivaTransaccionLocal;
	}

	public void setMostrarmonto_ivaTransaccionLocal(Boolean mostrarmonto_ivaTransaccionLocal) {
		this.mostrarmonto_ivaTransaccionLocal= mostrarmonto_ivaTransaccionLocal;
	}

	public Boolean getActivarmonto_ivaTransaccionLocal() {
		return this.activarmonto_ivaTransaccionLocal;
	}

	public void setActivarmonto_ivaTransaccionLocal(Boolean activarmonto_ivaTransaccionLocal) {
		this.activarmonto_ivaTransaccionLocal= activarmonto_ivaTransaccionLocal;
	}

	public Border setResaltartotal_ivaTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltartotal_ivaTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ivaTransaccionLocal() {
		return this.resaltartotal_ivaTransaccionLocal;
	}

	public void setResaltartotal_ivaTransaccionLocal(Border borderResaltar) {
		this.resaltartotal_ivaTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrartotal_ivaTransaccionLocal() {
		return this.mostrartotal_ivaTransaccionLocal;
	}

	public void setMostrartotal_ivaTransaccionLocal(Boolean mostrartotal_ivaTransaccionLocal) {
		this.mostrartotal_ivaTransaccionLocal= mostrartotal_ivaTransaccionLocal;
	}

	public Boolean getActivartotal_ivaTransaccionLocal() {
		return this.activartotal_ivaTransaccionLocal;
	}

	public void setActivartotal_ivaTransaccionLocal(Boolean activartotal_ivaTransaccionLocal) {
		this.activartotal_ivaTransaccionLocal= activartotal_ivaTransaccionLocal;
	}

	public Border setResaltartotal_sin_ivaTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltartotal_sin_ivaTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_sin_ivaTransaccionLocal() {
		return this.resaltartotal_sin_ivaTransaccionLocal;
	}

	public void setResaltartotal_sin_ivaTransaccionLocal(Border borderResaltar) {
		this.resaltartotal_sin_ivaTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrartotal_sin_ivaTransaccionLocal() {
		return this.mostrartotal_sin_ivaTransaccionLocal;
	}

	public void setMostrartotal_sin_ivaTransaccionLocal(Boolean mostrartotal_sin_ivaTransaccionLocal) {
		this.mostrartotal_sin_ivaTransaccionLocal= mostrartotal_sin_ivaTransaccionLocal;
	}

	public Boolean getActivartotal_sin_ivaTransaccionLocal() {
		return this.activartotal_sin_ivaTransaccionLocal;
	}

	public void setActivartotal_sin_ivaTransaccionLocal(Boolean activartotal_sin_ivaTransaccionLocal) {
		this.activartotal_sin_ivaTransaccionLocal= activartotal_sin_ivaTransaccionLocal;
	}

	public Border setResaltarmonto_iceTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarmonto_iceTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_iceTransaccionLocal() {
		return this.resaltarmonto_iceTransaccionLocal;
	}

	public void setResaltarmonto_iceTransaccionLocal(Border borderResaltar) {
		this.resaltarmonto_iceTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarmonto_iceTransaccionLocal() {
		return this.mostrarmonto_iceTransaccionLocal;
	}

	public void setMostrarmonto_iceTransaccionLocal(Boolean mostrarmonto_iceTransaccionLocal) {
		this.mostrarmonto_iceTransaccionLocal= mostrarmonto_iceTransaccionLocal;
	}

	public Boolean getActivarmonto_iceTransaccionLocal() {
		return this.activarmonto_iceTransaccionLocal;
	}

	public void setActivarmonto_iceTransaccionLocal(Boolean activarmonto_iceTransaccionLocal) {
		this.activarmonto_iceTransaccionLocal= activarmonto_iceTransaccionLocal;
	}

	public Border setResaltartransfe_iva_retenerTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltartransfe_iva_retenerTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartransfe_iva_retenerTransaccionLocal() {
		return this.resaltartransfe_iva_retenerTransaccionLocal;
	}

	public void setResaltartransfe_iva_retenerTransaccionLocal(Border borderResaltar) {
		this.resaltartransfe_iva_retenerTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrartransfe_iva_retenerTransaccionLocal() {
		return this.mostrartransfe_iva_retenerTransaccionLocal;
	}

	public void setMostrartransfe_iva_retenerTransaccionLocal(Boolean mostrartransfe_iva_retenerTransaccionLocal) {
		this.mostrartransfe_iva_retenerTransaccionLocal= mostrartransfe_iva_retenerTransaccionLocal;
	}

	public Boolean getActivartransfe_iva_retenerTransaccionLocal() {
		return this.activartransfe_iva_retenerTransaccionLocal;
	}

	public void setActivartransfe_iva_retenerTransaccionLocal(Boolean activartransfe_iva_retenerTransaccionLocal) {
		this.activartransfe_iva_retenerTransaccionLocal= activartransfe_iva_retenerTransaccionLocal;
	}

	public Border setResaltarpresta_iva_retenerTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarpresta_iva_retenerTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpresta_iva_retenerTransaccionLocal() {
		return this.resaltarpresta_iva_retenerTransaccionLocal;
	}

	public void setResaltarpresta_iva_retenerTransaccionLocal(Border borderResaltar) {
		this.resaltarpresta_iva_retenerTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarpresta_iva_retenerTransaccionLocal() {
		return this.mostrarpresta_iva_retenerTransaccionLocal;
	}

	public void setMostrarpresta_iva_retenerTransaccionLocal(Boolean mostrarpresta_iva_retenerTransaccionLocal) {
		this.mostrarpresta_iva_retenerTransaccionLocal= mostrarpresta_iva_retenerTransaccionLocal;
	}

	public Boolean getActivarpresta_iva_retenerTransaccionLocal() {
		return this.activarpresta_iva_retenerTransaccionLocal;
	}

	public void setActivarpresta_iva_retenerTransaccionLocal(Boolean activarpresta_iva_retenerTransaccionLocal) {
		this.activarpresta_iva_retenerTransaccionLocal= activarpresta_iva_retenerTransaccionLocal;
	}

	public Border setResaltarid_tipo_retencion_ivaTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencion_ivaTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencion_ivaTransaccionLocal() {
		return this.resaltarid_tipo_retencion_ivaTransaccionLocal;
	}

	public void setResaltarid_tipo_retencion_ivaTransaccionLocal(Border borderResaltar) {
		this.resaltarid_tipo_retencion_ivaTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencion_ivaTransaccionLocal() {
		return this.mostrarid_tipo_retencion_ivaTransaccionLocal;
	}

	public void setMostrarid_tipo_retencion_ivaTransaccionLocal(Boolean mostrarid_tipo_retencion_ivaTransaccionLocal) {
		this.mostrarid_tipo_retencion_ivaTransaccionLocal= mostrarid_tipo_retencion_ivaTransaccionLocal;
	}

	public Boolean getActivarid_tipo_retencion_ivaTransaccionLocal() {
		return this.activarid_tipo_retencion_ivaTransaccionLocal;
	}

	public void setActivarid_tipo_retencion_ivaTransaccionLocal(Boolean activarid_tipo_retencion_ivaTransaccionLocal) {
		this.activarid_tipo_retencion_ivaTransaccionLocal= activarid_tipo_retencion_ivaTransaccionLocal;
	}

	public Boolean getCargarid_tipo_retencion_ivaTransaccionLocal() {
		return this.cargarid_tipo_retencion_ivaTransaccionLocal;
	}

	public void setCargarid_tipo_retencion_ivaTransaccionLocal(Boolean cargarid_tipo_retencion_ivaTransaccionLocal) {
		this.cargarid_tipo_retencion_ivaTransaccionLocal= cargarid_tipo_retencion_ivaTransaccionLocal;
	}

	public Border setResaltarid_tipo_retencion_iva_prestaTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencion_iva_prestaTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencion_iva_prestaTransaccionLocal() {
		return this.resaltarid_tipo_retencion_iva_prestaTransaccionLocal;
	}

	public void setResaltarid_tipo_retencion_iva_prestaTransaccionLocal(Border borderResaltar) {
		this.resaltarid_tipo_retencion_iva_prestaTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencion_iva_prestaTransaccionLocal() {
		return this.mostrarid_tipo_retencion_iva_prestaTransaccionLocal;
	}

	public void setMostrarid_tipo_retencion_iva_prestaTransaccionLocal(Boolean mostrarid_tipo_retencion_iva_prestaTransaccionLocal) {
		this.mostrarid_tipo_retencion_iva_prestaTransaccionLocal= mostrarid_tipo_retencion_iva_prestaTransaccionLocal;
	}

	public Boolean getActivarid_tipo_retencion_iva_prestaTransaccionLocal() {
		return this.activarid_tipo_retencion_iva_prestaTransaccionLocal;
	}

	public void setActivarid_tipo_retencion_iva_prestaTransaccionLocal(Boolean activarid_tipo_retencion_iva_prestaTransaccionLocal) {
		this.activarid_tipo_retencion_iva_prestaTransaccionLocal= activarid_tipo_retencion_iva_prestaTransaccionLocal;
	}

	public Boolean getCargarid_tipo_retencion_iva_prestaTransaccionLocal() {
		return this.cargarid_tipo_retencion_iva_prestaTransaccionLocal;
	}

	public void setCargarid_tipo_retencion_iva_prestaTransaccionLocal(Boolean cargarid_tipo_retencion_iva_prestaTransaccionLocal) {
		this.cargarid_tipo_retencion_iva_prestaTransaccionLocal= cargarid_tipo_retencion_iva_prestaTransaccionLocal;
	}

	public Border setResaltartransfe_iva_retenidoTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltartransfe_iva_retenidoTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartransfe_iva_retenidoTransaccionLocal() {
		return this.resaltartransfe_iva_retenidoTransaccionLocal;
	}

	public void setResaltartransfe_iva_retenidoTransaccionLocal(Border borderResaltar) {
		this.resaltartransfe_iva_retenidoTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrartransfe_iva_retenidoTransaccionLocal() {
		return this.mostrartransfe_iva_retenidoTransaccionLocal;
	}

	public void setMostrartransfe_iva_retenidoTransaccionLocal(Boolean mostrartransfe_iva_retenidoTransaccionLocal) {
		this.mostrartransfe_iva_retenidoTransaccionLocal= mostrartransfe_iva_retenidoTransaccionLocal;
	}

	public Boolean getActivartransfe_iva_retenidoTransaccionLocal() {
		return this.activartransfe_iva_retenidoTransaccionLocal;
	}

	public void setActivartransfe_iva_retenidoTransaccionLocal(Boolean activartransfe_iva_retenidoTransaccionLocal) {
		this.activartransfe_iva_retenidoTransaccionLocal= activartransfe_iva_retenidoTransaccionLocal;
	}

	public Border setResaltarpresta_iva_retenidoTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarpresta_iva_retenidoTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpresta_iva_retenidoTransaccionLocal() {
		return this.resaltarpresta_iva_retenidoTransaccionLocal;
	}

	public void setResaltarpresta_iva_retenidoTransaccionLocal(Border borderResaltar) {
		this.resaltarpresta_iva_retenidoTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarpresta_iva_retenidoTransaccionLocal() {
		return this.mostrarpresta_iva_retenidoTransaccionLocal;
	}

	public void setMostrarpresta_iva_retenidoTransaccionLocal(Boolean mostrarpresta_iva_retenidoTransaccionLocal) {
		this.mostrarpresta_iva_retenidoTransaccionLocal= mostrarpresta_iva_retenidoTransaccionLocal;
	}

	public Boolean getActivarpresta_iva_retenidoTransaccionLocal() {
		return this.activarpresta_iva_retenidoTransaccionLocal;
	}

	public void setActivarpresta_iva_retenidoTransaccionLocal(Boolean activarpresta_iva_retenidoTransaccionLocal) {
		this.activarpresta_iva_retenidoTransaccionLocal= activarpresta_iva_retenidoTransaccionLocal;
	}

	public Border setResaltarpermite_devolucionTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionlocalBeanSwingJInternalFrame.jTtoolBarTransaccionLocal.setBorder(borderResaltar);
		
		this.resaltarpermite_devolucionTransaccionLocal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpermite_devolucionTransaccionLocal() {
		return this.resaltarpermite_devolucionTransaccionLocal;
	}

	public void setResaltarpermite_devolucionTransaccionLocal(Border borderResaltar) {
		this.resaltarpermite_devolucionTransaccionLocal= borderResaltar;
	}

	public Boolean getMostrarpermite_devolucionTransaccionLocal() {
		return this.mostrarpermite_devolucionTransaccionLocal;
	}

	public void setMostrarpermite_devolucionTransaccionLocal(Boolean mostrarpermite_devolucionTransaccionLocal) {
		this.mostrarpermite_devolucionTransaccionLocal= mostrarpermite_devolucionTransaccionLocal;
	}

	public Boolean getActivarpermite_devolucionTransaccionLocal() {
		return this.activarpermite_devolucionTransaccionLocal;
	}

	public void setActivarpermite_devolucionTransaccionLocal(Boolean activarpermite_devolucionTransaccionLocal) {
		this.activarpermite_devolucionTransaccionLocal= activarpermite_devolucionTransaccionLocal;
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
		
		
		this.setMostraridTransaccionLocal(esInicial);
		this.setMostrarid_compraTransaccionLocal(esInicial);
		this.setMostrarrucTransaccionLocal(esInicial);
		this.setMostrarrazon_socialTransaccionLocal(esInicial);
		this.setMostrarid_periodo_declaraTransaccionLocal(esInicial);
		this.setMostrarid_transaccion_contaTransaccionLocal(esInicial);
		this.setMostrarid_clienteTransaccionLocal(esInicial);
		this.setMostraridentificacionTransaccionLocal(esInicial);
		this.setMostrarid_tipo_comprobanteTransaccionLocal(esInicial);
		this.setMostrarfecha_emisionTransaccionLocal(esInicial);
		this.setMostrarfecha_registro_contableTransaccionLocal(esInicial);
		this.setMostrarnumero_secuencialTransaccionLocal(esInicial);
		this.setMostrarnumero_serieTransaccionLocal(esInicial);
		this.setMostrarnumero_autorizacionTransaccionLocal(esInicial);
		this.setMostrarfecha_caducidadTransaccionLocal(esInicial);
		this.setMostrarid_tipo_tributarioTransaccionLocal(esInicial);
		this.setMostrarnumero_documento_contableTransaccionLocal(esInicial);
		this.setMostrarid_asiento_contableTransaccionLocal(esInicial);
		this.setMostrares_riseTransaccionLocal(esInicial);
		this.setMostrarbienes_ivaTransaccionLocal(esInicial);
		this.setMostrarbienes_sin_ivaTransaccionLocal(esInicial);
		this.setMostrarid_tipo_ivaTransaccionLocal(esInicial);
		this.setMostrarservicios_ivaTransaccionLocal(esInicial);
		this.setMostrarservicios_sin_ivaTransaccionLocal(esInicial);
		this.setMostrarmonto_ivaTransaccionLocal(esInicial);
		this.setMostrartotal_ivaTransaccionLocal(esInicial);
		this.setMostrartotal_sin_ivaTransaccionLocal(esInicial);
		this.setMostrarmonto_iceTransaccionLocal(esInicial);
		this.setMostrartransfe_iva_retenerTransaccionLocal(esInicial);
		this.setMostrarpresta_iva_retenerTransaccionLocal(esInicial);
		this.setMostrarid_tipo_retencion_ivaTransaccionLocal(esInicial);
		this.setMostrarid_tipo_retencion_iva_prestaTransaccionLocal(esInicial);
		this.setMostrartransfe_iva_retenidoTransaccionLocal(esInicial);
		this.setMostrarpresta_iva_retenidoTransaccionLocal(esInicial);
		this.setMostrarpermite_devolucionTransaccionLocal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.ID)) {
				this.setMostraridTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDCOMPRA)) {
				this.setMostrarid_compraTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.RUC)) {
				this.setMostrarrucTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.RAZONSOCIAL)) {
				this.setMostrarrazon_socialTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDPERIODODECLARA)) {
				this.setMostrarid_periodo_declaraTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDTRANSACCIONCONTA)) {
				this.setMostrarid_transaccion_contaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDENTIFICACION)) {
				this.setMostraridentificacionTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDTIPOCOMPROBANTE)) {
				this.setMostrarid_tipo_comprobanteTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.FECHAREGISTROCONTABLE)) {
				this.setMostrarfecha_registro_contableTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setMostrarnumero_secuencialTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.NUMEROSERIE)) {
				this.setMostrarnumero_serieTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setMostrarnumero_autorizacionTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.FECHACADUCIDAD)) {
				this.setMostrarfecha_caducidadTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDTIPOTRIBUTARIO)) {
				this.setMostrarid_tipo_tributarioTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.NUMERODOCUMENTOCONTABLE)) {
				this.setMostrarnumero_documento_contableTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.ESRISE)) {
				this.setMostrares_riseTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.BIENESIVA)) {
				this.setMostrarbienes_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.BIENESSINIVA)) {
				this.setMostrarbienes_sin_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDTIPOIVA)) {
				this.setMostrarid_tipo_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.SERVICIOSIVA)) {
				this.setMostrarservicios_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.SERVICIOSSINIVA)) {
				this.setMostrarservicios_sin_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.MONTOIVA)) {
				this.setMostrarmonto_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.TOTALIVA)) {
				this.setMostrartotal_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.TOTALSINIVA)) {
				this.setMostrartotal_sin_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.MONTOICE)) {
				this.setMostrarmonto_iceTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.TRANSFEIVARETENER)) {
				this.setMostrartransfe_iva_retenerTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.PRESTAIVARETENER)) {
				this.setMostrarpresta_iva_retenerTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVA)) {
				this.setMostrarid_tipo_retencion_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVAPRESTA)) {
				this.setMostrarid_tipo_retencion_iva_prestaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.TRANSFEIVARETENIDO)) {
				this.setMostrartransfe_iva_retenidoTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.PRESTAIVARETENIDO)) {
				this.setMostrarpresta_iva_retenidoTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.PERMITEDEVOLUCION)) {
				this.setMostrarpermite_devolucionTransaccionLocal(esAsigna);
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
		
		
		this.setActivaridTransaccionLocal(esInicial);
		this.setActivarid_compraTransaccionLocal(esInicial);
		this.setActivarrucTransaccionLocal(esInicial);
		this.setActivarrazon_socialTransaccionLocal(esInicial);
		this.setActivarid_periodo_declaraTransaccionLocal(esInicial);
		this.setActivarid_transaccion_contaTransaccionLocal(esInicial);
		this.setActivarid_clienteTransaccionLocal(esInicial);
		this.setActivaridentificacionTransaccionLocal(esInicial);
		this.setActivarid_tipo_comprobanteTransaccionLocal(esInicial);
		this.setActivarfecha_emisionTransaccionLocal(esInicial);
		this.setActivarfecha_registro_contableTransaccionLocal(esInicial);
		this.setActivarnumero_secuencialTransaccionLocal(esInicial);
		this.setActivarnumero_serieTransaccionLocal(esInicial);
		this.setActivarnumero_autorizacionTransaccionLocal(esInicial);
		this.setActivarfecha_caducidadTransaccionLocal(esInicial);
		this.setActivarid_tipo_tributarioTransaccionLocal(esInicial);
		this.setActivarnumero_documento_contableTransaccionLocal(esInicial);
		this.setActivarid_asiento_contableTransaccionLocal(esInicial);
		this.setActivares_riseTransaccionLocal(esInicial);
		this.setActivarbienes_ivaTransaccionLocal(esInicial);
		this.setActivarbienes_sin_ivaTransaccionLocal(esInicial);
		this.setActivarid_tipo_ivaTransaccionLocal(esInicial);
		this.setActivarservicios_ivaTransaccionLocal(esInicial);
		this.setActivarservicios_sin_ivaTransaccionLocal(esInicial);
		this.setActivarmonto_ivaTransaccionLocal(esInicial);
		this.setActivartotal_ivaTransaccionLocal(esInicial);
		this.setActivartotal_sin_ivaTransaccionLocal(esInicial);
		this.setActivarmonto_iceTransaccionLocal(esInicial);
		this.setActivartransfe_iva_retenerTransaccionLocal(esInicial);
		this.setActivarpresta_iva_retenerTransaccionLocal(esInicial);
		this.setActivarid_tipo_retencion_ivaTransaccionLocal(esInicial);
		this.setActivarid_tipo_retencion_iva_prestaTransaccionLocal(esInicial);
		this.setActivartransfe_iva_retenidoTransaccionLocal(esInicial);
		this.setActivarpresta_iva_retenidoTransaccionLocal(esInicial);
		this.setActivarpermite_devolucionTransaccionLocal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.ID)) {
				this.setActivaridTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDCOMPRA)) {
				this.setActivarid_compraTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.RUC)) {
				this.setActivarrucTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.RAZONSOCIAL)) {
				this.setActivarrazon_socialTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDPERIODODECLARA)) {
				this.setActivarid_periodo_declaraTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDTRANSACCIONCONTA)) {
				this.setActivarid_transaccion_contaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDENTIFICACION)) {
				this.setActivaridentificacionTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDTIPOCOMPROBANTE)) {
				this.setActivarid_tipo_comprobanteTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.FECHAREGISTROCONTABLE)) {
				this.setActivarfecha_registro_contableTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setActivarnumero_secuencialTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.NUMEROSERIE)) {
				this.setActivarnumero_serieTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setActivarnumero_autorizacionTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.FECHACADUCIDAD)) {
				this.setActivarfecha_caducidadTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDTIPOTRIBUTARIO)) {
				this.setActivarid_tipo_tributarioTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.NUMERODOCUMENTOCONTABLE)) {
				this.setActivarnumero_documento_contableTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.ESRISE)) {
				this.setActivares_riseTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.BIENESIVA)) {
				this.setActivarbienes_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.BIENESSINIVA)) {
				this.setActivarbienes_sin_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDTIPOIVA)) {
				this.setActivarid_tipo_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.SERVICIOSIVA)) {
				this.setActivarservicios_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.SERVICIOSSINIVA)) {
				this.setActivarservicios_sin_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.MONTOIVA)) {
				this.setActivarmonto_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.TOTALIVA)) {
				this.setActivartotal_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.TOTALSINIVA)) {
				this.setActivartotal_sin_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.MONTOICE)) {
				this.setActivarmonto_iceTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.TRANSFEIVARETENER)) {
				this.setActivartransfe_iva_retenerTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.PRESTAIVARETENER)) {
				this.setActivarpresta_iva_retenerTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVA)) {
				this.setActivarid_tipo_retencion_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVAPRESTA)) {
				this.setActivarid_tipo_retencion_iva_prestaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.TRANSFEIVARETENIDO)) {
				this.setActivartransfe_iva_retenidoTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.PRESTAIVARETENIDO)) {
				this.setActivarpresta_iva_retenidoTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.PERMITEDEVOLUCION)) {
				this.setActivarpermite_devolucionTransaccionLocal(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTransaccionLocal(esInicial);
		this.setResaltarid_compraTransaccionLocal(esInicial);
		this.setResaltarrucTransaccionLocal(esInicial);
		this.setResaltarrazon_socialTransaccionLocal(esInicial);
		this.setResaltarid_periodo_declaraTransaccionLocal(esInicial);
		this.setResaltarid_transaccion_contaTransaccionLocal(esInicial);
		this.setResaltarid_clienteTransaccionLocal(esInicial);
		this.setResaltaridentificacionTransaccionLocal(esInicial);
		this.setResaltarid_tipo_comprobanteTransaccionLocal(esInicial);
		this.setResaltarfecha_emisionTransaccionLocal(esInicial);
		this.setResaltarfecha_registro_contableTransaccionLocal(esInicial);
		this.setResaltarnumero_secuencialTransaccionLocal(esInicial);
		this.setResaltarnumero_serieTransaccionLocal(esInicial);
		this.setResaltarnumero_autorizacionTransaccionLocal(esInicial);
		this.setResaltarfecha_caducidadTransaccionLocal(esInicial);
		this.setResaltarid_tipo_tributarioTransaccionLocal(esInicial);
		this.setResaltarnumero_documento_contableTransaccionLocal(esInicial);
		this.setResaltarid_asiento_contableTransaccionLocal(esInicial);
		this.setResaltares_riseTransaccionLocal(esInicial);
		this.setResaltarbienes_ivaTransaccionLocal(esInicial);
		this.setResaltarbienes_sin_ivaTransaccionLocal(esInicial);
		this.setResaltarid_tipo_ivaTransaccionLocal(esInicial);
		this.setResaltarservicios_ivaTransaccionLocal(esInicial);
		this.setResaltarservicios_sin_ivaTransaccionLocal(esInicial);
		this.setResaltarmonto_ivaTransaccionLocal(esInicial);
		this.setResaltartotal_ivaTransaccionLocal(esInicial);
		this.setResaltartotal_sin_ivaTransaccionLocal(esInicial);
		this.setResaltarmonto_iceTransaccionLocal(esInicial);
		this.setResaltartransfe_iva_retenerTransaccionLocal(esInicial);
		this.setResaltarpresta_iva_retenerTransaccionLocal(esInicial);
		this.setResaltarid_tipo_retencion_ivaTransaccionLocal(esInicial);
		this.setResaltarid_tipo_retencion_iva_prestaTransaccionLocal(esInicial);
		this.setResaltartransfe_iva_retenidoTransaccionLocal(esInicial);
		this.setResaltarpresta_iva_retenidoTransaccionLocal(esInicial);
		this.setResaltarpermite_devolucionTransaccionLocal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.ID)) {
				this.setResaltaridTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDCOMPRA)) {
				this.setResaltarid_compraTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.RUC)) {
				this.setResaltarrucTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.RAZONSOCIAL)) {
				this.setResaltarrazon_socialTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDPERIODODECLARA)) {
				this.setResaltarid_periodo_declaraTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDTRANSACCIONCONTA)) {
				this.setResaltarid_transaccion_contaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDENTIFICACION)) {
				this.setResaltaridentificacionTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDTIPOCOMPROBANTE)) {
				this.setResaltarid_tipo_comprobanteTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.FECHAREGISTROCONTABLE)) {
				this.setResaltarfecha_registro_contableTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setResaltarnumero_secuencialTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.NUMEROSERIE)) {
				this.setResaltarnumero_serieTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setResaltarnumero_autorizacionTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.FECHACADUCIDAD)) {
				this.setResaltarfecha_caducidadTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDTIPOTRIBUTARIO)) {
				this.setResaltarid_tipo_tributarioTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.NUMERODOCUMENTOCONTABLE)) {
				this.setResaltarnumero_documento_contableTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.ESRISE)) {
				this.setResaltares_riseTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.BIENESIVA)) {
				this.setResaltarbienes_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.BIENESSINIVA)) {
				this.setResaltarbienes_sin_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDTIPOIVA)) {
				this.setResaltarid_tipo_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.SERVICIOSIVA)) {
				this.setResaltarservicios_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.SERVICIOSSINIVA)) {
				this.setResaltarservicios_sin_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.MONTOIVA)) {
				this.setResaltarmonto_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.TOTALIVA)) {
				this.setResaltartotal_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.TOTALSINIVA)) {
				this.setResaltartotal_sin_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.MONTOICE)) {
				this.setResaltarmonto_iceTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.TRANSFEIVARETENER)) {
				this.setResaltartransfe_iva_retenerTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.PRESTAIVARETENER)) {
				this.setResaltarpresta_iva_retenerTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVA)) {
				this.setResaltarid_tipo_retencion_ivaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVAPRESTA)) {
				this.setResaltarid_tipo_retencion_iva_prestaTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.TRANSFEIVARETENIDO)) {
				this.setResaltartransfe_iva_retenidoTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.PRESTAIVARETENIDO)) {
				this.setResaltarpresta_iva_retenidoTransaccionLocal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionLocalConstantesFunciones.PERMITEDEVOLUCION)) {
				this.setResaltarpermite_devolucionTransaccionLocal(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAsientoContableTransaccionLocal=true;

	public Boolean getMostrarFK_IdAsientoContableTransaccionLocal() {
		return this.mostrarFK_IdAsientoContableTransaccionLocal;
	}

	public void setMostrarFK_IdAsientoContableTransaccionLocal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableTransaccionLocal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteTransaccionLocal=true;

	public Boolean getMostrarFK_IdClienteTransaccionLocal() {
		return this.mostrarFK_IdClienteTransaccionLocal;
	}

	public void setMostrarFK_IdClienteTransaccionLocal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteTransaccionLocal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCompraTransaccionLocal=true;

	public Boolean getMostrarFK_IdCompraTransaccionLocal() {
		return this.mostrarFK_IdCompraTransaccionLocal;
	}

	public void setMostrarFK_IdCompraTransaccionLocal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCompraTransaccionLocal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDeclaraTransaccionLocal=true;

	public Boolean getMostrarFK_IdPeriodoDeclaraTransaccionLocal() {
		return this.mostrarFK_IdPeriodoDeclaraTransaccionLocal;
	}

	public void setMostrarFK_IdPeriodoDeclaraTransaccionLocal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDeclaraTransaccionLocal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoComprobanteTransaccionLocal=true;

	public Boolean getMostrarFK_IdTipoComprobanteTransaccionLocal() {
		return this.mostrarFK_IdTipoComprobanteTransaccionLocal;
	}

	public void setMostrarFK_IdTipoComprobanteTransaccionLocal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoComprobanteTransaccionLocal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoIvaTransaccionLocal=true;

	public Boolean getMostrarFK_IdTipoIvaTransaccionLocal() {
		return this.mostrarFK_IdTipoIvaTransaccionLocal;
	}

	public void setMostrarFK_IdTipoIvaTransaccionLocal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoIvaTransaccionLocal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionIvaTransaccionLocal=true;

	public Boolean getMostrarFK_IdTipoRetencionIvaTransaccionLocal() {
		return this.mostrarFK_IdTipoRetencionIvaTransaccionLocal;
	}

	public void setMostrarFK_IdTipoRetencionIvaTransaccionLocal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionIvaTransaccionLocal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionIvaPrestaTransaccionLocal=true;

	public Boolean getMostrarFK_IdTipoRetencionIvaPrestaTransaccionLocal() {
		return this.mostrarFK_IdTipoRetencionIvaPrestaTransaccionLocal;
	}

	public void setMostrarFK_IdTipoRetencionIvaPrestaTransaccionLocal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionIvaPrestaTransaccionLocal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTributarioTransaccionLocal=true;

	public Boolean getMostrarFK_IdTipoTributarioTransaccionLocal() {
		return this.mostrarFK_IdTipoTributarioTransaccionLocal;
	}

	public void setMostrarFK_IdTipoTributarioTransaccionLocal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTributarioTransaccionLocal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionContaTransaccionLocal=true;

	public Boolean getMostrarFK_IdTransaccionContaTransaccionLocal() {
		return this.mostrarFK_IdTransaccionContaTransaccionLocal;
	}

	public void setMostrarFK_IdTransaccionContaTransaccionLocal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionContaTransaccionLocal= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableTransaccionLocal=true;

	public Boolean getActivarFK_IdAsientoContableTransaccionLocal() {
		return this.activarFK_IdAsientoContableTransaccionLocal;
	}

	public void setActivarFK_IdAsientoContableTransaccionLocal(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableTransaccionLocal= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteTransaccionLocal=true;

	public Boolean getActivarFK_IdClienteTransaccionLocal() {
		return this.activarFK_IdClienteTransaccionLocal;
	}

	public void setActivarFK_IdClienteTransaccionLocal(Boolean habilitarResaltar) {
		this.activarFK_IdClienteTransaccionLocal= habilitarResaltar;
	}

	public Boolean activarFK_IdCompraTransaccionLocal=true;

	public Boolean getActivarFK_IdCompraTransaccionLocal() {
		return this.activarFK_IdCompraTransaccionLocal;
	}

	public void setActivarFK_IdCompraTransaccionLocal(Boolean habilitarResaltar) {
		this.activarFK_IdCompraTransaccionLocal= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDeclaraTransaccionLocal=true;

	public Boolean getActivarFK_IdPeriodoDeclaraTransaccionLocal() {
		return this.activarFK_IdPeriodoDeclaraTransaccionLocal;
	}

	public void setActivarFK_IdPeriodoDeclaraTransaccionLocal(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDeclaraTransaccionLocal= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoComprobanteTransaccionLocal=true;

	public Boolean getActivarFK_IdTipoComprobanteTransaccionLocal() {
		return this.activarFK_IdTipoComprobanteTransaccionLocal;
	}

	public void setActivarFK_IdTipoComprobanteTransaccionLocal(Boolean habilitarResaltar) {
		this.activarFK_IdTipoComprobanteTransaccionLocal= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoIvaTransaccionLocal=true;

	public Boolean getActivarFK_IdTipoIvaTransaccionLocal() {
		return this.activarFK_IdTipoIvaTransaccionLocal;
	}

	public void setActivarFK_IdTipoIvaTransaccionLocal(Boolean habilitarResaltar) {
		this.activarFK_IdTipoIvaTransaccionLocal= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionIvaTransaccionLocal=true;

	public Boolean getActivarFK_IdTipoRetencionIvaTransaccionLocal() {
		return this.activarFK_IdTipoRetencionIvaTransaccionLocal;
	}

	public void setActivarFK_IdTipoRetencionIvaTransaccionLocal(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionIvaTransaccionLocal= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionIvaPrestaTransaccionLocal=true;

	public Boolean getActivarFK_IdTipoRetencionIvaPrestaTransaccionLocal() {
		return this.activarFK_IdTipoRetencionIvaPrestaTransaccionLocal;
	}

	public void setActivarFK_IdTipoRetencionIvaPrestaTransaccionLocal(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionIvaPrestaTransaccionLocal= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTributarioTransaccionLocal=true;

	public Boolean getActivarFK_IdTipoTributarioTransaccionLocal() {
		return this.activarFK_IdTipoTributarioTransaccionLocal;
	}

	public void setActivarFK_IdTipoTributarioTransaccionLocal(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTributarioTransaccionLocal= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionContaTransaccionLocal=true;

	public Boolean getActivarFK_IdTransaccionContaTransaccionLocal() {
		return this.activarFK_IdTransaccionContaTransaccionLocal;
	}

	public void setActivarFK_IdTransaccionContaTransaccionLocal(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionContaTransaccionLocal= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableTransaccionLocal=null;

	public Border getResaltarFK_IdAsientoContableTransaccionLocal() {
		return this.resaltarFK_IdAsientoContableTransaccionLocal;
	}

	public void setResaltarFK_IdAsientoContableTransaccionLocal(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableTransaccionLocal= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableTransaccionLocal= borderResaltar;
	}

	public Border resaltarFK_IdClienteTransaccionLocal=null;

	public Border getResaltarFK_IdClienteTransaccionLocal() {
		return this.resaltarFK_IdClienteTransaccionLocal;
	}

	public void setResaltarFK_IdClienteTransaccionLocal(Border borderResaltar) {
		this.resaltarFK_IdClienteTransaccionLocal= borderResaltar;
	}

	public void setResaltarFK_IdClienteTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteTransaccionLocal= borderResaltar;
	}

	public Border resaltarFK_IdCompraTransaccionLocal=null;

	public Border getResaltarFK_IdCompraTransaccionLocal() {
		return this.resaltarFK_IdCompraTransaccionLocal;
	}

	public void setResaltarFK_IdCompraTransaccionLocal(Border borderResaltar) {
		this.resaltarFK_IdCompraTransaccionLocal= borderResaltar;
	}

	public void setResaltarFK_IdCompraTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCompraTransaccionLocal= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDeclaraTransaccionLocal=null;

	public Border getResaltarFK_IdPeriodoDeclaraTransaccionLocal() {
		return this.resaltarFK_IdPeriodoDeclaraTransaccionLocal;
	}

	public void setResaltarFK_IdPeriodoDeclaraTransaccionLocal(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDeclaraTransaccionLocal= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDeclaraTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDeclaraTransaccionLocal= borderResaltar;
	}

	public Border resaltarFK_IdTipoComprobanteTransaccionLocal=null;

	public Border getResaltarFK_IdTipoComprobanteTransaccionLocal() {
		return this.resaltarFK_IdTipoComprobanteTransaccionLocal;
	}

	public void setResaltarFK_IdTipoComprobanteTransaccionLocal(Border borderResaltar) {
		this.resaltarFK_IdTipoComprobanteTransaccionLocal= borderResaltar;
	}

	public void setResaltarFK_IdTipoComprobanteTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoComprobanteTransaccionLocal= borderResaltar;
	}

	public Border resaltarFK_IdTipoIvaTransaccionLocal=null;

	public Border getResaltarFK_IdTipoIvaTransaccionLocal() {
		return this.resaltarFK_IdTipoIvaTransaccionLocal;
	}

	public void setResaltarFK_IdTipoIvaTransaccionLocal(Border borderResaltar) {
		this.resaltarFK_IdTipoIvaTransaccionLocal= borderResaltar;
	}

	public void setResaltarFK_IdTipoIvaTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoIvaTransaccionLocal= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionIvaTransaccionLocal=null;

	public Border getResaltarFK_IdTipoRetencionIvaTransaccionLocal() {
		return this.resaltarFK_IdTipoRetencionIvaTransaccionLocal;
	}

	public void setResaltarFK_IdTipoRetencionIvaTransaccionLocal(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionIvaTransaccionLocal= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionIvaTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionIvaTransaccionLocal= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionIvaPrestaTransaccionLocal=null;

	public Border getResaltarFK_IdTipoRetencionIvaPrestaTransaccionLocal() {
		return this.resaltarFK_IdTipoRetencionIvaPrestaTransaccionLocal;
	}

	public void setResaltarFK_IdTipoRetencionIvaPrestaTransaccionLocal(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionIvaPrestaTransaccionLocal= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionIvaPrestaTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionIvaPrestaTransaccionLocal= borderResaltar;
	}

	public Border resaltarFK_IdTipoTributarioTransaccionLocal=null;

	public Border getResaltarFK_IdTipoTributarioTransaccionLocal() {
		return this.resaltarFK_IdTipoTributarioTransaccionLocal;
	}

	public void setResaltarFK_IdTipoTributarioTransaccionLocal(Border borderResaltar) {
		this.resaltarFK_IdTipoTributarioTransaccionLocal= borderResaltar;
	}

	public void setResaltarFK_IdTipoTributarioTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTributarioTransaccionLocal= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionContaTransaccionLocal=null;

	public Border getResaltarFK_IdTransaccionContaTransaccionLocal() {
		return this.resaltarFK_IdTransaccionContaTransaccionLocal;
	}

	public void setResaltarFK_IdTransaccionContaTransaccionLocal(Border borderResaltar) {
		this.resaltarFK_IdTransaccionContaTransaccionLocal= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionContaTransaccionLocal(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionLocalBeanSwingJInternalFrame transaccionlocalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionContaTransaccionLocal= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}