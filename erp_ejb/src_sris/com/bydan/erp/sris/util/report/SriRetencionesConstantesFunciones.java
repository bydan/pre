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


import com.bydan.erp.sris.util.report.SriRetencionesConstantesFunciones;
import com.bydan.erp.sris.util.report.SriRetencionesParameterReturnGeneral;
//import com.bydan.erp.sris.util.report.SriRetencionesParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.sris.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.sris.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.sris.business.dataaccess.*;
//import com.bydan.erp.sris.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class SriRetencionesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="SriRetenciones";
	public static final String SPATHOPCION="Sris";	
	public static final String SPATHMODULO="sris/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="SriRetenciones"+SriRetencionesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SriRetencionesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SriRetencionesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SriRetencionesConstantesFunciones.SCHEMA+"_"+SriRetencionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SriRetencionesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SriRetencionesConstantesFunciones.SCHEMA+"_"+SriRetencionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SriRetencionesConstantesFunciones.SCHEMA+"_"+SriRetencionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SriRetencionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SriRetencionesConstantesFunciones.SCHEMA+"_"+SriRetencionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriRetencionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SriRetencionesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriRetencionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriRetencionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SriRetencionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriRetencionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SriRetencionesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SriRetencionesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SriRetencionesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SriRetencionesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Sri Retencioneses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Sri Retenciones";
	public static final String SCLASSWEBTITULO_LOWER="Sri Retenciones";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="SriRetenciones";
	public static final String OBJECTNAME="sriretenciones";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SRIS;	
	public static final String TABLENAME="sri_retenciones";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select sriretenciones from "+SriRetencionesConstantesFunciones.SPERSISTENCENAME+" sriretenciones";
	public static String QUERYSELECTNATIVE="select "+SriRetencionesConstantesFunciones.SCHEMA+"."+SriRetencionesConstantesFunciones.TABLENAME+".id,"+SriRetencionesConstantesFunciones.SCHEMA+"."+SriRetencionesConstantesFunciones.TABLENAME+".version_row,"+SriRetencionesConstantesFunciones.SCHEMA+"."+SriRetencionesConstantesFunciones.TABLENAME+".id_empresa,"+SriRetencionesConstantesFunciones.SCHEMA+"."+SriRetencionesConstantesFunciones.TABLENAME+".id_ejercicio,"+SriRetencionesConstantesFunciones.SCHEMA+"."+SriRetencionesConstantesFunciones.TABLENAME+".id_periodo_declara,"+SriRetencionesConstantesFunciones.SCHEMA+"."+SriRetencionesConstantesFunciones.TABLENAME+".ruc,"+SriRetencionesConstantesFunciones.SCHEMA+"."+SriRetencionesConstantesFunciones.TABLENAME+".nombre_modulo,"+SriRetencionesConstantesFunciones.SCHEMA+"."+SriRetencionesConstantesFunciones.TABLENAME+".nombre_tipo_comprobante,"+SriRetencionesConstantesFunciones.SCHEMA+"."+SriRetencionesConstantesFunciones.TABLENAME+".numero_documento,"+SriRetencionesConstantesFunciones.SCHEMA+"."+SriRetencionesConstantesFunciones.TABLENAME+".fecha_emision,"+SriRetencionesConstantesFunciones.SCHEMA+"."+SriRetencionesConstantesFunciones.TABLENAME+".fecha_registro_contable,"+SriRetencionesConstantesFunciones.SCHEMA+"."+SriRetencionesConstantesFunciones.TABLENAME+".numero_serie,"+SriRetencionesConstantesFunciones.SCHEMA+"."+SriRetencionesConstantesFunciones.TABLENAME+".total_iva,"+SriRetencionesConstantesFunciones.SCHEMA+"."+SriRetencionesConstantesFunciones.TABLENAME+".monto_iva,"+SriRetencionesConstantesFunciones.SCHEMA+"."+SriRetencionesConstantesFunciones.TABLENAME+".numero_documento_contable,"+SriRetencionesConstantesFunciones.SCHEMA+"."+SriRetencionesConstantesFunciones.TABLENAME+".nombre_cuenta_contable_retencion,"+SriRetencionesConstantesFunciones.SCHEMA+"."+SriRetencionesConstantesFunciones.TABLENAME+".porcentaje,"+SriRetencionesConstantesFunciones.SCHEMA+"."+SriRetencionesConstantesFunciones.TABLENAME+".valor,"+SriRetencionesConstantesFunciones.SCHEMA+"."+SriRetencionesConstantesFunciones.TABLENAME+".nombre_benef from "+SriRetencionesConstantesFunciones.SCHEMA+"."+SriRetencionesConstantesFunciones.TABLENAME;//+" as "+SriRetencionesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODODECLARA= "id_periodo_declara";
    public static final String RUC= "ruc";
    public static final String NOMBREMODULO= "nombre_modulo";
    public static final String NOMBRETIPOCOMPROBANTE= "nombre_tipo_comprobante";
    public static final String NUMERODOCUMENTO= "numero_documento";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAREGISTROCONTABLE= "fecha_registro_contable";
    public static final String NUMEROSERIE= "numero_serie";
    public static final String TOTALIVA= "total_iva";
    public static final String MONTOIVA= "monto_iva";
    public static final String NUMERODOCUMENTOCONTABLE= "numero_documento_contable";
    public static final String NOMBRECUENTACONTABLERETENCION= "nombre_cuenta_contable_retencion";
    public static final String PORCENTAJE= "porcentaje";
    public static final String VALOR= "valor";
    public static final String NOMBREBENEF= "nombre_benef";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODODECLARA= "Periodo Declara";
		public static final String LABEL_IDPERIODODECLARA_LOWER= "Periodo Declara";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_NOMBREMODULO= "Nombre Modulo";
		public static final String LABEL_NOMBREMODULO_LOWER= "Nombre Modulo";
    	public static final String LABEL_NOMBRETIPOCOMPROBANTE= "Nombre Tipo Comprobante";
		public static final String LABEL_NOMBRETIPOCOMPROBANTE_LOWER= "Nombre Tipo Comprobante";
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
    	public static final String LABEL_MONTOIVA= "Monto Iva";
		public static final String LABEL_MONTOIVA_LOWER= "Monto Iva";
    	public static final String LABEL_NUMERODOCUMENTOCONTABLE= "Numero Documento Contable";
		public static final String LABEL_NUMERODOCUMENTOCONTABLE_LOWER= "Numero Documento Contable";
    	public static final String LABEL_NOMBRECUENTACONTABLERETENCION= "Nombre Cuenta Contable Retencion";
		public static final String LABEL_NOMBRECUENTACONTABLERETENCION_LOWER= "Nombre Cuenta Contable Retencion";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_NOMBREBENEF= "Nombre Benef";
		public static final String LABEL_NOMBREBENEF_LOWER= "Nombre Benef";
	
		
		
		
		
		
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_MODULO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_MODULO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_TIPO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TIPO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_SERIE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SERIE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_DOCUMENTO_CONTABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_DOCUMENTO_CONTABLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CUENTA_CONTABLE_RETENCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CUENTA_CONTABLE_RETENCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNOMBRE_BENEF=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BENEF=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getSriRetencionesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SriRetencionesConstantesFunciones.IDEMPRESA)) {sLabelColumna=SriRetencionesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SriRetencionesConstantesFunciones.IDEJERCICIO)) {sLabelColumna=SriRetencionesConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(SriRetencionesConstantesFunciones.IDPERIODODECLARA)) {sLabelColumna=SriRetencionesConstantesFunciones.LABEL_IDPERIODODECLARA;}
		if(sNombreColumna.equals(SriRetencionesConstantesFunciones.RUC)) {sLabelColumna=SriRetencionesConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(SriRetencionesConstantesFunciones.NOMBREMODULO)) {sLabelColumna=SriRetencionesConstantesFunciones.LABEL_NOMBREMODULO;}
		if(sNombreColumna.equals(SriRetencionesConstantesFunciones.NOMBRETIPOCOMPROBANTE)) {sLabelColumna=SriRetencionesConstantesFunciones.LABEL_NOMBRETIPOCOMPROBANTE;}
		if(sNombreColumna.equals(SriRetencionesConstantesFunciones.NUMERODOCUMENTO)) {sLabelColumna=SriRetencionesConstantesFunciones.LABEL_NUMERODOCUMENTO;}
		if(sNombreColumna.equals(SriRetencionesConstantesFunciones.FECHAEMISION)) {sLabelColumna=SriRetencionesConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(SriRetencionesConstantesFunciones.FECHAREGISTROCONTABLE)) {sLabelColumna=SriRetencionesConstantesFunciones.LABEL_FECHAREGISTROCONTABLE;}
		if(sNombreColumna.equals(SriRetencionesConstantesFunciones.NUMEROSERIE)) {sLabelColumna=SriRetencionesConstantesFunciones.LABEL_NUMEROSERIE;}
		if(sNombreColumna.equals(SriRetencionesConstantesFunciones.TOTALIVA)) {sLabelColumna=SriRetencionesConstantesFunciones.LABEL_TOTALIVA;}
		if(sNombreColumna.equals(SriRetencionesConstantesFunciones.MONTOIVA)) {sLabelColumna=SriRetencionesConstantesFunciones.LABEL_MONTOIVA;}
		if(sNombreColumna.equals(SriRetencionesConstantesFunciones.NUMERODOCUMENTOCONTABLE)) {sLabelColumna=SriRetencionesConstantesFunciones.LABEL_NUMERODOCUMENTOCONTABLE;}
		if(sNombreColumna.equals(SriRetencionesConstantesFunciones.NOMBRECUENTACONTABLERETENCION)) {sLabelColumna=SriRetencionesConstantesFunciones.LABEL_NOMBRECUENTACONTABLERETENCION;}
		if(sNombreColumna.equals(SriRetencionesConstantesFunciones.PORCENTAJE)) {sLabelColumna=SriRetencionesConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(SriRetencionesConstantesFunciones.VALOR)) {sLabelColumna=SriRetencionesConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(SriRetencionesConstantesFunciones.NOMBREBENEF)) {sLabelColumna=SriRetencionesConstantesFunciones.LABEL_NOMBREBENEF;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getSriRetencionesDescripcion(SriRetenciones sriretenciones) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(sriretenciones !=null/* && sriretenciones.getId()!=0*/) {
			if(sriretenciones.getId()!=null) {
				sDescripcion=sriretenciones.getId().toString();
			}//sriretencionessriretenciones.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getSriRetencionesDescripcionDetallado(SriRetenciones sriretenciones) {
		String sDescripcion="";
			
		sDescripcion+=SriRetencionesConstantesFunciones.ID+"=";
		sDescripcion+=sriretenciones.getId().toString()+",";
		sDescripcion+=SriRetencionesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=sriretenciones.getVersionRow().toString()+",";
		sDescripcion+=SriRetencionesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=sriretenciones.getid_empresa().toString()+",";
		sDescripcion+=SriRetencionesConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=sriretenciones.getid_ejercicio().toString()+",";
		sDescripcion+=SriRetencionesConstantesFunciones.IDPERIODODECLARA+"=";
		sDescripcion+=sriretenciones.getid_periodo_declara().toString()+",";
		sDescripcion+=SriRetencionesConstantesFunciones.RUC+"=";
		sDescripcion+=sriretenciones.getruc()+",";
		sDescripcion+=SriRetencionesConstantesFunciones.NOMBREMODULO+"=";
		sDescripcion+=sriretenciones.getnombre_modulo()+",";
		sDescripcion+=SriRetencionesConstantesFunciones.NOMBRETIPOCOMPROBANTE+"=";
		sDescripcion+=sriretenciones.getnombre_tipo_comprobante()+",";
		sDescripcion+=SriRetencionesConstantesFunciones.NUMERODOCUMENTO+"=";
		sDescripcion+=sriretenciones.getnumero_documento()+",";
		sDescripcion+=SriRetencionesConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=sriretenciones.getfecha_emision().toString()+",";
		sDescripcion+=SriRetencionesConstantesFunciones.FECHAREGISTROCONTABLE+"=";
		sDescripcion+=sriretenciones.getfecha_registro_contable().toString()+",";
		sDescripcion+=SriRetencionesConstantesFunciones.NUMEROSERIE+"=";
		sDescripcion+=sriretenciones.getnumero_serie()+",";
		sDescripcion+=SriRetencionesConstantesFunciones.TOTALIVA+"=";
		sDescripcion+=sriretenciones.gettotal_iva().toString()+",";
		sDescripcion+=SriRetencionesConstantesFunciones.MONTOIVA+"=";
		sDescripcion+=sriretenciones.getmonto_iva().toString()+",";
		sDescripcion+=SriRetencionesConstantesFunciones.NUMERODOCUMENTOCONTABLE+"=";
		sDescripcion+=sriretenciones.getnumero_documento_contable()+",";
		sDescripcion+=SriRetencionesConstantesFunciones.NOMBRECUENTACONTABLERETENCION+"=";
		sDescripcion+=sriretenciones.getnombre_cuenta_contable_retencion()+",";
		sDescripcion+=SriRetencionesConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=sriretenciones.getporcentaje().toString()+",";
		sDescripcion+=SriRetencionesConstantesFunciones.VALOR+"=";
		sDescripcion+=sriretenciones.getvalor().toString()+",";
		sDescripcion+=SriRetencionesConstantesFunciones.NOMBREBENEF+"=";
		sDescripcion+=sriretenciones.getnombre_benef()+",";
			
		return sDescripcion;
	}
	
	public static void setSriRetencionesDescripcion(SriRetenciones sriretenciones,String sValor) throws Exception {			
		if(sriretenciones !=null) {
			//sriretencionessriretenciones.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getPeriodoDeclaraDescripcion(PeriodoDeclara periododeclara) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periododeclara!=null/*&&periododeclara.getId()>0*/) {
			sDescripcion=PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(periododeclara);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaSriRetenciones")) {
			sNombreIndice="Tipo=  Por Ejercicio Por Periodo Declara Por Ruc";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPeriodoDeclara")) {
			sNombreIndice="Tipo=  Por Periodo Declara";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaSriRetenciones(Long id_ejercicio,Long id_periodo_declara,String ruc) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(id_periodo_declara!=null) {sDetalleIndice+=" Codigo Unico De Periodo Declara="+id_periodo_declara.toString();}
		if(ruc!=null) {sDetalleIndice+=" Ruc="+ruc;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosSriRetenciones(SriRetenciones sriretenciones,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		sriretenciones.setnombre_modulo(sriretenciones.getnombre_modulo().trim());
		sriretenciones.setnombre_tipo_comprobante(sriretenciones.getnombre_tipo_comprobante().trim());
		sriretenciones.setnumero_documento(sriretenciones.getnumero_documento().trim());
		sriretenciones.setnumero_serie(sriretenciones.getnumero_serie().trim());
		sriretenciones.setnumero_documento_contable(sriretenciones.getnumero_documento_contable().trim());
		sriretenciones.setnombre_cuenta_contable_retencion(sriretenciones.getnombre_cuenta_contable_retencion().trim());
		sriretenciones.setnombre_benef(sriretenciones.getnombre_benef().trim());
	}
	
	public static void quitarEspaciosSriRetencioness(List<SriRetenciones> sriretencioness,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SriRetenciones sriretenciones: sriretencioness) {
			sriretenciones.setnombre_modulo(sriretenciones.getnombre_modulo().trim());
			sriretenciones.setnombre_tipo_comprobante(sriretenciones.getnombre_tipo_comprobante().trim());
			sriretenciones.setnumero_documento(sriretenciones.getnumero_documento().trim());
			sriretenciones.setnumero_serie(sriretenciones.getnumero_serie().trim());
			sriretenciones.setnumero_documento_contable(sriretenciones.getnumero_documento_contable().trim());
			sriretenciones.setnombre_cuenta_contable_retencion(sriretenciones.getnombre_cuenta_contable_retencion().trim());
			sriretenciones.setnombre_benef(sriretenciones.getnombre_benef().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSriRetenciones(SriRetenciones sriretenciones,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && sriretenciones.getConCambioAuxiliar()) {
			sriretenciones.setIsDeleted(sriretenciones.getIsDeletedAuxiliar());	
			sriretenciones.setIsNew(sriretenciones.getIsNewAuxiliar());	
			sriretenciones.setIsChanged(sriretenciones.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			sriretenciones.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			sriretenciones.setIsDeletedAuxiliar(false);	
			sriretenciones.setIsNewAuxiliar(false);	
			sriretenciones.setIsChangedAuxiliar(false);
			
			sriretenciones.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSriRetencioness(List<SriRetenciones> sriretencioness,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(SriRetenciones sriretenciones : sriretencioness) {
			if(conAsignarBase && sriretenciones.getConCambioAuxiliar()) {
				sriretenciones.setIsDeleted(sriretenciones.getIsDeletedAuxiliar());	
				sriretenciones.setIsNew(sriretenciones.getIsNewAuxiliar());	
				sriretenciones.setIsChanged(sriretenciones.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				sriretenciones.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				sriretenciones.setIsDeletedAuxiliar(false);	
				sriretenciones.setIsNewAuxiliar(false);	
				sriretenciones.setIsChangedAuxiliar(false);
				
				sriretenciones.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSriRetenciones(SriRetenciones sriretenciones,Boolean conEnteros) throws Exception  {
		sriretenciones.settotal_iva(0.0);
		sriretenciones.setmonto_iva(0.0);
		sriretenciones.setporcentaje(0.0);
		sriretenciones.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSriRetencioness(List<SriRetenciones> sriretencioness,Boolean conEnteros) throws Exception  {
		
		for(SriRetenciones sriretenciones: sriretencioness) {
			sriretenciones.settotal_iva(0.0);
			sriretenciones.setmonto_iva(0.0);
			sriretenciones.setporcentaje(0.0);
			sriretenciones.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSriRetenciones(List<SriRetenciones> sriretencioness,SriRetenciones sriretencionesAux) throws Exception  {
		SriRetencionesConstantesFunciones.InicializarValoresSriRetenciones(sriretencionesAux,true);
		
		for(SriRetenciones sriretenciones: sriretencioness) {
			if(sriretenciones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			sriretencionesAux.settotal_iva(sriretencionesAux.gettotal_iva()+sriretenciones.gettotal_iva());			
			sriretencionesAux.setmonto_iva(sriretencionesAux.getmonto_iva()+sriretenciones.getmonto_iva());			
			sriretencionesAux.setporcentaje(sriretencionesAux.getporcentaje()+sriretenciones.getporcentaje());			
			sriretencionesAux.setvalor(sriretencionesAux.getvalor()+sriretenciones.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSriRetenciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SriRetencionesConstantesFunciones.getArrayColumnasGlobalesSriRetenciones(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSriRetenciones(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SriRetencionesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SriRetencionesConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SriRetencionesConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SriRetencionesConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSriRetenciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SriRetenciones> sriretencioness,SriRetenciones sriretenciones,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SriRetenciones sriretencionesAux: sriretencioness) {
			if(sriretencionesAux!=null && sriretenciones!=null) {
				if((sriretencionesAux.getId()==null && sriretenciones.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(sriretencionesAux.getId()!=null && sriretenciones.getId()!=null){
					if(sriretencionesAux.getId().equals(sriretenciones.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSriRetenciones(List<SriRetenciones> sriretencioness) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_ivaTotal=0.0;
		Double monto_ivaTotal=0.0;
		Double porcentajeTotal=0.0;
		Double valorTotal=0.0;
	
		for(SriRetenciones sriretenciones: sriretencioness) {			
			if(sriretenciones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			total_ivaTotal+=sriretenciones.gettotal_iva();
			monto_ivaTotal+=sriretenciones.getmonto_iva();
			porcentajeTotal+=sriretenciones.getporcentaje();
			valorTotal+=sriretenciones.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriRetencionesConstantesFunciones.TOTALIVA);
		datoGeneral.setsDescripcion(SriRetencionesConstantesFunciones.LABEL_TOTALIVA);
		datoGeneral.setdValorDouble(total_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriRetencionesConstantesFunciones.MONTOIVA);
		datoGeneral.setsDescripcion(SriRetencionesConstantesFunciones.LABEL_MONTOIVA);
		datoGeneral.setdValorDouble(monto_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriRetencionesConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(SriRetencionesConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriRetencionesConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(SriRetencionesConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSriRetenciones() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SriRetencionesConstantesFunciones.LABEL_ID, SriRetencionesConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriRetencionesConstantesFunciones.LABEL_VERSIONROW, SriRetencionesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriRetencionesConstantesFunciones.LABEL_NOMBREMODULO, SriRetencionesConstantesFunciones.NOMBREMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriRetencionesConstantesFunciones.LABEL_NOMBRETIPOCOMPROBANTE, SriRetencionesConstantesFunciones.NOMBRETIPOCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriRetencionesConstantesFunciones.LABEL_NUMERODOCUMENTO, SriRetencionesConstantesFunciones.NUMERODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriRetencionesConstantesFunciones.LABEL_FECHAEMISION, SriRetencionesConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriRetencionesConstantesFunciones.LABEL_FECHAREGISTROCONTABLE, SriRetencionesConstantesFunciones.FECHAREGISTROCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriRetencionesConstantesFunciones.LABEL_NUMEROSERIE, SriRetencionesConstantesFunciones.NUMEROSERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriRetencionesConstantesFunciones.LABEL_TOTALIVA, SriRetencionesConstantesFunciones.TOTALIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriRetencionesConstantesFunciones.LABEL_MONTOIVA, SriRetencionesConstantesFunciones.MONTOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriRetencionesConstantesFunciones.LABEL_NUMERODOCUMENTOCONTABLE, SriRetencionesConstantesFunciones.NUMERODOCUMENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriRetencionesConstantesFunciones.LABEL_NOMBRECUENTACONTABLERETENCION, SriRetencionesConstantesFunciones.NOMBRECUENTACONTABLERETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriRetencionesConstantesFunciones.LABEL_PORCENTAJE, SriRetencionesConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriRetencionesConstantesFunciones.LABEL_VALOR, SriRetencionesConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriRetencionesConstantesFunciones.LABEL_NOMBREBENEF, SriRetencionesConstantesFunciones.NOMBREBENEF,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSriRetenciones() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SriRetencionesConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriRetencionesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriRetencionesConstantesFunciones.NOMBREMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriRetencionesConstantesFunciones.NOMBRETIPOCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriRetencionesConstantesFunciones.NUMERODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriRetencionesConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriRetencionesConstantesFunciones.FECHAREGISTROCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriRetencionesConstantesFunciones.NUMEROSERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriRetencionesConstantesFunciones.TOTALIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriRetencionesConstantesFunciones.MONTOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriRetencionesConstantesFunciones.NUMERODOCUMENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriRetencionesConstantesFunciones.NOMBRECUENTACONTABLERETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriRetencionesConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriRetencionesConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriRetencionesConstantesFunciones.NOMBREBENEF;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSriRetenciones() throws Exception  {
		return SriRetencionesConstantesFunciones.getTiposSeleccionarSriRetenciones(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSriRetenciones(Boolean conFk) throws Exception  {
		return SriRetencionesConstantesFunciones.getTiposSeleccionarSriRetenciones(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSriRetenciones(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriRetencionesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SriRetencionesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriRetencionesConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(SriRetencionesConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriRetencionesConstantesFunciones.LABEL_IDPERIODODECLARA);
			reporte.setsDescripcion(SriRetencionesConstantesFunciones.LABEL_IDPERIODODECLARA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriRetencionesConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(SriRetencionesConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriRetencionesConstantesFunciones.LABEL_NOMBREMODULO);
			reporte.setsDescripcion(SriRetencionesConstantesFunciones.LABEL_NOMBREMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriRetencionesConstantesFunciones.LABEL_NOMBRETIPOCOMPROBANTE);
			reporte.setsDescripcion(SriRetencionesConstantesFunciones.LABEL_NOMBRETIPOCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriRetencionesConstantesFunciones.LABEL_NUMERODOCUMENTO);
			reporte.setsDescripcion(SriRetencionesConstantesFunciones.LABEL_NUMERODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriRetencionesConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(SriRetencionesConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriRetencionesConstantesFunciones.LABEL_FECHAREGISTROCONTABLE);
			reporte.setsDescripcion(SriRetencionesConstantesFunciones.LABEL_FECHAREGISTROCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriRetencionesConstantesFunciones.LABEL_NUMEROSERIE);
			reporte.setsDescripcion(SriRetencionesConstantesFunciones.LABEL_NUMEROSERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriRetencionesConstantesFunciones.LABEL_TOTALIVA);
			reporte.setsDescripcion(SriRetencionesConstantesFunciones.LABEL_TOTALIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriRetencionesConstantesFunciones.LABEL_MONTOIVA);
			reporte.setsDescripcion(SriRetencionesConstantesFunciones.LABEL_MONTOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriRetencionesConstantesFunciones.LABEL_NUMERODOCUMENTOCONTABLE);
			reporte.setsDescripcion(SriRetencionesConstantesFunciones.LABEL_NUMERODOCUMENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriRetencionesConstantesFunciones.LABEL_NOMBRECUENTACONTABLERETENCION);
			reporte.setsDescripcion(SriRetencionesConstantesFunciones.LABEL_NOMBRECUENTACONTABLERETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriRetencionesConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(SriRetencionesConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriRetencionesConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(SriRetencionesConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriRetencionesConstantesFunciones.LABEL_NOMBREBENEF);
			reporte.setsDescripcion(SriRetencionesConstantesFunciones.LABEL_NOMBREBENEF);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSriRetenciones(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSriRetenciones(SriRetenciones sriretencionesAux) throws Exception {
		
			sriretencionesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(sriretencionesAux.getEmpresa()));
			sriretencionesAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(sriretencionesAux.getEjercicio()));
			sriretencionesAux.setperiododeclara_descripcion(PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(sriretencionesAux.getPeriodoDeclara()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSriRetenciones(List<SriRetenciones> sriretencionessTemp) throws Exception {
		for(SriRetenciones sriretencionesAux:sriretencionessTemp) {
			
			sriretencionesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(sriretencionesAux.getEmpresa()));
			sriretencionesAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(sriretencionesAux.getEjercicio()));
			sriretencionesAux.setperiododeclara_descripcion(PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(sriretencionesAux.getPeriodoDeclara()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSriRetenciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(PeriodoDeclara.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PeriodoDeclara.class)) {
						classes.add(new Classe(PeriodoDeclara.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSriRetenciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(PeriodoDeclara.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PeriodoDeclara.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(PeriodoDeclara.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PeriodoDeclara.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSriRetenciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SriRetencionesConstantesFunciones.getClassesRelationshipsOfSriRetenciones(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSriRetenciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSriRetenciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SriRetencionesConstantesFunciones.getClassesRelationshipsFromStringsOfSriRetenciones(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSriRetenciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(SriRetenciones sriretenciones,List<SriRetenciones> sriretencioness,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(SriRetenciones sriretenciones,List<SriRetenciones> sriretencioness) throws Exception {
		try	{			
			for(SriRetenciones sriretencionesLocal:sriretencioness) {
				if(sriretencionesLocal.getId().equals(sriretenciones.getId())) {
					sriretencionesLocal.setIsSelected(sriretenciones.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSriRetenciones(List<SriRetenciones> sriretencionessAux) throws Exception {
		//this.sriretencionessAux=sriretencionessAux;
		
		for(SriRetenciones sriretencionesAux:sriretencionessAux) {
			if(sriretencionesAux.getIsChanged()) {
				sriretencionesAux.setIsChanged(false);
			}		
			
			if(sriretencionesAux.getIsNew()) {
				sriretencionesAux.setIsNew(false);
			}	
			
			if(sriretencionesAux.getIsDeleted()) {
				sriretencionesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSriRetenciones(SriRetenciones sriretencionesAux) throws Exception {
		//this.sriretencionesAux=sriretencionesAux;
		
			if(sriretencionesAux.getIsChanged()) {
				sriretencionesAux.setIsChanged(false);
			}		
			
			if(sriretencionesAux.getIsNew()) {
				sriretencionesAux.setIsNew(false);
			}	
			
			if(sriretencionesAux.getIsDeleted()) {
				sriretencionesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(SriRetenciones sriretencionesAsignar,SriRetenciones sriretenciones) throws Exception {
		sriretencionesAsignar.setId(sriretenciones.getId());	
		sriretencionesAsignar.setVersionRow(sriretenciones.getVersionRow());	
		sriretencionesAsignar.setnombre_modulo(sriretenciones.getnombre_modulo());	
		sriretencionesAsignar.setnombre_tipo_comprobante(sriretenciones.getnombre_tipo_comprobante());	
		sriretencionesAsignar.setnumero_documento(sriretenciones.getnumero_documento());	
		sriretencionesAsignar.setfecha_emision(sriretenciones.getfecha_emision());	
		sriretencionesAsignar.setfecha_registro_contable(sriretenciones.getfecha_registro_contable());	
		sriretencionesAsignar.setnumero_serie(sriretenciones.getnumero_serie());	
		sriretencionesAsignar.settotal_iva(sriretenciones.gettotal_iva());	
		sriretencionesAsignar.setmonto_iva(sriretenciones.getmonto_iva());	
		sriretencionesAsignar.setnumero_documento_contable(sriretenciones.getnumero_documento_contable());	
		sriretencionesAsignar.setnombre_cuenta_contable_retencion(sriretenciones.getnombre_cuenta_contable_retencion());	
		sriretencionesAsignar.setporcentaje(sriretenciones.getporcentaje());	
		sriretencionesAsignar.setvalor(sriretenciones.getvalor());	
		sriretencionesAsignar.setnombre_benef(sriretenciones.getnombre_benef());	
	}
	
	public static void inicializarSriRetenciones(SriRetenciones sriretenciones) throws Exception {
		try {
				sriretenciones.setId(0L);	
					
				sriretenciones.setnombre_modulo("");	
				sriretenciones.setnombre_tipo_comprobante("");	
				sriretenciones.setnumero_documento("");	
				sriretenciones.setfecha_emision(new Date());	
				sriretenciones.setfecha_registro_contable(new Date());	
				sriretenciones.setnumero_serie("");	
				sriretenciones.settotal_iva(0.0);	
				sriretenciones.setmonto_iva(0.0);	
				sriretenciones.setnumero_documento_contable("");	
				sriretenciones.setnombre_cuenta_contable_retencion("");	
				sriretenciones.setporcentaje(0.0);	
				sriretenciones.setvalor(0.0);	
				sriretenciones.setnombre_benef("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSriRetenciones(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SriRetencionesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriRetencionesConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriRetencionesConstantesFunciones.LABEL_IDPERIODODECLARA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriRetencionesConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriRetencionesConstantesFunciones.LABEL_NOMBREMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriRetencionesConstantesFunciones.LABEL_NOMBRETIPOCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriRetencionesConstantesFunciones.LABEL_NUMERODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriRetencionesConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriRetencionesConstantesFunciones.LABEL_FECHAREGISTROCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriRetencionesConstantesFunciones.LABEL_NUMEROSERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriRetencionesConstantesFunciones.LABEL_TOTALIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriRetencionesConstantesFunciones.LABEL_MONTOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriRetencionesConstantesFunciones.LABEL_NUMERODOCUMENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriRetencionesConstantesFunciones.LABEL_NOMBRECUENTACONTABLERETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriRetencionesConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriRetencionesConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriRetencionesConstantesFunciones.LABEL_NOMBREBENEF);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSriRetenciones(String sTipo,Row row,Workbook workbook,SriRetenciones sriretenciones,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(sriretenciones.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sriretenciones.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sriretenciones.getperiododeclara_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sriretenciones.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sriretenciones.getnombre_modulo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sriretenciones.getnombre_tipo_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sriretenciones.getnumero_documento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sriretenciones.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sriretenciones.getfecha_registro_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sriretenciones.getnumero_serie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sriretenciones.gettotal_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sriretenciones.getmonto_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sriretenciones.getnumero_documento_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sriretenciones.getnombre_cuenta_contable_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sriretenciones.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sriretenciones.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sriretenciones.getnombre_benef());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySriRetenciones="";
	
	public String getsFinalQuerySriRetenciones() {
		return this.sFinalQuerySriRetenciones;
	}
	
	public void setsFinalQuerySriRetenciones(String sFinalQuerySriRetenciones) {
		this.sFinalQuerySriRetenciones= sFinalQuerySriRetenciones;
	}
	
	public Border resaltarSeleccionarSriRetenciones=null;
	
	public Border setResaltarSeleccionarSriRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*SriRetencionesBeanSwingJInternalFrame sriretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//sriretencionesBeanSwingJInternalFrame.jTtoolBarSriRetenciones.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSriRetenciones= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSriRetenciones() {
		return this.resaltarSeleccionarSriRetenciones;
	}
	
	public void setResaltarSeleccionarSriRetenciones(Border borderResaltarSeleccionarSriRetenciones) {
		this.resaltarSeleccionarSriRetenciones= borderResaltarSeleccionarSriRetenciones;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSriRetenciones=null;
	public Boolean mostraridSriRetenciones=true;
	public Boolean activaridSriRetenciones=true;

	public Border resaltarid_empresaSriRetenciones=null;
	public Boolean mostrarid_empresaSriRetenciones=true;
	public Boolean activarid_empresaSriRetenciones=true;
	public Boolean cargarid_empresaSriRetenciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSriRetenciones=false;//ConEventDepend=true

	public Border resaltarid_ejercicioSriRetenciones=null;
	public Boolean mostrarid_ejercicioSriRetenciones=true;
	public Boolean activarid_ejercicioSriRetenciones=true;
	public Boolean cargarid_ejercicioSriRetenciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioSriRetenciones=false;//ConEventDepend=true

	public Border resaltarid_periodo_declaraSriRetenciones=null;
	public Boolean mostrarid_periodo_declaraSriRetenciones=true;
	public Boolean activarid_periodo_declaraSriRetenciones=true;
	public Boolean cargarid_periodo_declaraSriRetenciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodo_declaraSriRetenciones=false;//ConEventDepend=true

	public Border resaltarrucSriRetenciones=null;
	public Boolean mostrarrucSriRetenciones=true;
	public Boolean activarrucSriRetenciones=true;

	public Border resaltarnombre_moduloSriRetenciones=null;
	public Boolean mostrarnombre_moduloSriRetenciones=true;
	public Boolean activarnombre_moduloSriRetenciones=true;

	public Border resaltarnombre_tipo_comprobanteSriRetenciones=null;
	public Boolean mostrarnombre_tipo_comprobanteSriRetenciones=true;
	public Boolean activarnombre_tipo_comprobanteSriRetenciones=true;

	public Border resaltarnumero_documentoSriRetenciones=null;
	public Boolean mostrarnumero_documentoSriRetenciones=true;
	public Boolean activarnumero_documentoSriRetenciones=true;

	public Border resaltarfecha_emisionSriRetenciones=null;
	public Boolean mostrarfecha_emisionSriRetenciones=true;
	public Boolean activarfecha_emisionSriRetenciones=true;

	public Border resaltarfecha_registro_contableSriRetenciones=null;
	public Boolean mostrarfecha_registro_contableSriRetenciones=true;
	public Boolean activarfecha_registro_contableSriRetenciones=true;

	public Border resaltarnumero_serieSriRetenciones=null;
	public Boolean mostrarnumero_serieSriRetenciones=true;
	public Boolean activarnumero_serieSriRetenciones=true;

	public Border resaltartotal_ivaSriRetenciones=null;
	public Boolean mostrartotal_ivaSriRetenciones=true;
	public Boolean activartotal_ivaSriRetenciones=true;

	public Border resaltarmonto_ivaSriRetenciones=null;
	public Boolean mostrarmonto_ivaSriRetenciones=true;
	public Boolean activarmonto_ivaSriRetenciones=true;

	public Border resaltarnumero_documento_contableSriRetenciones=null;
	public Boolean mostrarnumero_documento_contableSriRetenciones=true;
	public Boolean activarnumero_documento_contableSriRetenciones=true;

	public Border resaltarnombre_cuenta_contable_retencionSriRetenciones=null;
	public Boolean mostrarnombre_cuenta_contable_retencionSriRetenciones=true;
	public Boolean activarnombre_cuenta_contable_retencionSriRetenciones=true;

	public Border resaltarporcentajeSriRetenciones=null;
	public Boolean mostrarporcentajeSriRetenciones=true;
	public Boolean activarporcentajeSriRetenciones=true;

	public Border resaltarvalorSriRetenciones=null;
	public Boolean mostrarvalorSriRetenciones=true;
	public Boolean activarvalorSriRetenciones=true;

	public Border resaltarnombre_benefSriRetenciones=null;
	public Boolean mostrarnombre_benefSriRetenciones=true;
	public Boolean activarnombre_benefSriRetenciones=true;

	
	

	public Border setResaltaridSriRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*SriRetencionesBeanSwingJInternalFrame sriretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sriretencionesBeanSwingJInternalFrame.jTtoolBarSriRetenciones.setBorder(borderResaltar);
		
		this.resaltaridSriRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSriRetenciones() {
		return this.resaltaridSriRetenciones;
	}

	public void setResaltaridSriRetenciones(Border borderResaltar) {
		this.resaltaridSriRetenciones= borderResaltar;
	}

	public Boolean getMostraridSriRetenciones() {
		return this.mostraridSriRetenciones;
	}

	public void setMostraridSriRetenciones(Boolean mostraridSriRetenciones) {
		this.mostraridSriRetenciones= mostraridSriRetenciones;
	}

	public Boolean getActivaridSriRetenciones() {
		return this.activaridSriRetenciones;
	}

	public void setActivaridSriRetenciones(Boolean activaridSriRetenciones) {
		this.activaridSriRetenciones= activaridSriRetenciones;
	}

	public Border setResaltarid_empresaSriRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*SriRetencionesBeanSwingJInternalFrame sriretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sriretencionesBeanSwingJInternalFrame.jTtoolBarSriRetenciones.setBorder(borderResaltar);
		
		this.resaltarid_empresaSriRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSriRetenciones() {
		return this.resaltarid_empresaSriRetenciones;
	}

	public void setResaltarid_empresaSriRetenciones(Border borderResaltar) {
		this.resaltarid_empresaSriRetenciones= borderResaltar;
	}

	public Boolean getMostrarid_empresaSriRetenciones() {
		return this.mostrarid_empresaSriRetenciones;
	}

	public void setMostrarid_empresaSriRetenciones(Boolean mostrarid_empresaSriRetenciones) {
		this.mostrarid_empresaSriRetenciones= mostrarid_empresaSriRetenciones;
	}

	public Boolean getActivarid_empresaSriRetenciones() {
		return this.activarid_empresaSriRetenciones;
	}

	public void setActivarid_empresaSriRetenciones(Boolean activarid_empresaSriRetenciones) {
		this.activarid_empresaSriRetenciones= activarid_empresaSriRetenciones;
	}

	public Boolean getCargarid_empresaSriRetenciones() {
		return this.cargarid_empresaSriRetenciones;
	}

	public void setCargarid_empresaSriRetenciones(Boolean cargarid_empresaSriRetenciones) {
		this.cargarid_empresaSriRetenciones= cargarid_empresaSriRetenciones;
	}

	public Border setResaltarid_ejercicioSriRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*SriRetencionesBeanSwingJInternalFrame sriretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sriretencionesBeanSwingJInternalFrame.jTtoolBarSriRetenciones.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioSriRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioSriRetenciones() {
		return this.resaltarid_ejercicioSriRetenciones;
	}

	public void setResaltarid_ejercicioSriRetenciones(Border borderResaltar) {
		this.resaltarid_ejercicioSriRetenciones= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioSriRetenciones() {
		return this.mostrarid_ejercicioSriRetenciones;
	}

	public void setMostrarid_ejercicioSriRetenciones(Boolean mostrarid_ejercicioSriRetenciones) {
		this.mostrarid_ejercicioSriRetenciones= mostrarid_ejercicioSriRetenciones;
	}

	public Boolean getActivarid_ejercicioSriRetenciones() {
		return this.activarid_ejercicioSriRetenciones;
	}

	public void setActivarid_ejercicioSriRetenciones(Boolean activarid_ejercicioSriRetenciones) {
		this.activarid_ejercicioSriRetenciones= activarid_ejercicioSriRetenciones;
	}

	public Boolean getCargarid_ejercicioSriRetenciones() {
		return this.cargarid_ejercicioSriRetenciones;
	}

	public void setCargarid_ejercicioSriRetenciones(Boolean cargarid_ejercicioSriRetenciones) {
		this.cargarid_ejercicioSriRetenciones= cargarid_ejercicioSriRetenciones;
	}

	public Border setResaltarid_periodo_declaraSriRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*SriRetencionesBeanSwingJInternalFrame sriretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sriretencionesBeanSwingJInternalFrame.jTtoolBarSriRetenciones.setBorder(borderResaltar);
		
		this.resaltarid_periodo_declaraSriRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodo_declaraSriRetenciones() {
		return this.resaltarid_periodo_declaraSriRetenciones;
	}

	public void setResaltarid_periodo_declaraSriRetenciones(Border borderResaltar) {
		this.resaltarid_periodo_declaraSriRetenciones= borderResaltar;
	}

	public Boolean getMostrarid_periodo_declaraSriRetenciones() {
		return this.mostrarid_periodo_declaraSriRetenciones;
	}

	public void setMostrarid_periodo_declaraSriRetenciones(Boolean mostrarid_periodo_declaraSriRetenciones) {
		this.mostrarid_periodo_declaraSriRetenciones= mostrarid_periodo_declaraSriRetenciones;
	}

	public Boolean getActivarid_periodo_declaraSriRetenciones() {
		return this.activarid_periodo_declaraSriRetenciones;
	}

	public void setActivarid_periodo_declaraSriRetenciones(Boolean activarid_periodo_declaraSriRetenciones) {
		this.activarid_periodo_declaraSriRetenciones= activarid_periodo_declaraSriRetenciones;
	}

	public Boolean getCargarid_periodo_declaraSriRetenciones() {
		return this.cargarid_periodo_declaraSriRetenciones;
	}

	public void setCargarid_periodo_declaraSriRetenciones(Boolean cargarid_periodo_declaraSriRetenciones) {
		this.cargarid_periodo_declaraSriRetenciones= cargarid_periodo_declaraSriRetenciones;
	}

	public Border setResaltarrucSriRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*SriRetencionesBeanSwingJInternalFrame sriretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sriretencionesBeanSwingJInternalFrame.jTtoolBarSriRetenciones.setBorder(borderResaltar);
		
		this.resaltarrucSriRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucSriRetenciones() {
		return this.resaltarrucSriRetenciones;
	}

	public void setResaltarrucSriRetenciones(Border borderResaltar) {
		this.resaltarrucSriRetenciones= borderResaltar;
	}

	public Boolean getMostrarrucSriRetenciones() {
		return this.mostrarrucSriRetenciones;
	}

	public void setMostrarrucSriRetenciones(Boolean mostrarrucSriRetenciones) {
		this.mostrarrucSriRetenciones= mostrarrucSriRetenciones;
	}

	public Boolean getActivarrucSriRetenciones() {
		return this.activarrucSriRetenciones;
	}

	public void setActivarrucSriRetenciones(Boolean activarrucSriRetenciones) {
		this.activarrucSriRetenciones= activarrucSriRetenciones;
	}

	public Border setResaltarnombre_moduloSriRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*SriRetencionesBeanSwingJInternalFrame sriretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sriretencionesBeanSwingJInternalFrame.jTtoolBarSriRetenciones.setBorder(borderResaltar);
		
		this.resaltarnombre_moduloSriRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_moduloSriRetenciones() {
		return this.resaltarnombre_moduloSriRetenciones;
	}

	public void setResaltarnombre_moduloSriRetenciones(Border borderResaltar) {
		this.resaltarnombre_moduloSriRetenciones= borderResaltar;
	}

	public Boolean getMostrarnombre_moduloSriRetenciones() {
		return this.mostrarnombre_moduloSriRetenciones;
	}

	public void setMostrarnombre_moduloSriRetenciones(Boolean mostrarnombre_moduloSriRetenciones) {
		this.mostrarnombre_moduloSriRetenciones= mostrarnombre_moduloSriRetenciones;
	}

	public Boolean getActivarnombre_moduloSriRetenciones() {
		return this.activarnombre_moduloSriRetenciones;
	}

	public void setActivarnombre_moduloSriRetenciones(Boolean activarnombre_moduloSriRetenciones) {
		this.activarnombre_moduloSriRetenciones= activarnombre_moduloSriRetenciones;
	}

	public Border setResaltarnombre_tipo_comprobanteSriRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*SriRetencionesBeanSwingJInternalFrame sriretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sriretencionesBeanSwingJInternalFrame.jTtoolBarSriRetenciones.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_comprobanteSriRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_comprobanteSriRetenciones() {
		return this.resaltarnombre_tipo_comprobanteSriRetenciones;
	}

	public void setResaltarnombre_tipo_comprobanteSriRetenciones(Border borderResaltar) {
		this.resaltarnombre_tipo_comprobanteSriRetenciones= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_comprobanteSriRetenciones() {
		return this.mostrarnombre_tipo_comprobanteSriRetenciones;
	}

	public void setMostrarnombre_tipo_comprobanteSriRetenciones(Boolean mostrarnombre_tipo_comprobanteSriRetenciones) {
		this.mostrarnombre_tipo_comprobanteSriRetenciones= mostrarnombre_tipo_comprobanteSriRetenciones;
	}

	public Boolean getActivarnombre_tipo_comprobanteSriRetenciones() {
		return this.activarnombre_tipo_comprobanteSriRetenciones;
	}

	public void setActivarnombre_tipo_comprobanteSriRetenciones(Boolean activarnombre_tipo_comprobanteSriRetenciones) {
		this.activarnombre_tipo_comprobanteSriRetenciones= activarnombre_tipo_comprobanteSriRetenciones;
	}

	public Border setResaltarnumero_documentoSriRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*SriRetencionesBeanSwingJInternalFrame sriretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sriretencionesBeanSwingJInternalFrame.jTtoolBarSriRetenciones.setBorder(borderResaltar);
		
		this.resaltarnumero_documentoSriRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_documentoSriRetenciones() {
		return this.resaltarnumero_documentoSriRetenciones;
	}

	public void setResaltarnumero_documentoSriRetenciones(Border borderResaltar) {
		this.resaltarnumero_documentoSriRetenciones= borderResaltar;
	}

	public Boolean getMostrarnumero_documentoSriRetenciones() {
		return this.mostrarnumero_documentoSriRetenciones;
	}

	public void setMostrarnumero_documentoSriRetenciones(Boolean mostrarnumero_documentoSriRetenciones) {
		this.mostrarnumero_documentoSriRetenciones= mostrarnumero_documentoSriRetenciones;
	}

	public Boolean getActivarnumero_documentoSriRetenciones() {
		return this.activarnumero_documentoSriRetenciones;
	}

	public void setActivarnumero_documentoSriRetenciones(Boolean activarnumero_documentoSriRetenciones) {
		this.activarnumero_documentoSriRetenciones= activarnumero_documentoSriRetenciones;
	}

	public Border setResaltarfecha_emisionSriRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*SriRetencionesBeanSwingJInternalFrame sriretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sriretencionesBeanSwingJInternalFrame.jTtoolBarSriRetenciones.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionSriRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionSriRetenciones() {
		return this.resaltarfecha_emisionSriRetenciones;
	}

	public void setResaltarfecha_emisionSriRetenciones(Border borderResaltar) {
		this.resaltarfecha_emisionSriRetenciones= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionSriRetenciones() {
		return this.mostrarfecha_emisionSriRetenciones;
	}

	public void setMostrarfecha_emisionSriRetenciones(Boolean mostrarfecha_emisionSriRetenciones) {
		this.mostrarfecha_emisionSriRetenciones= mostrarfecha_emisionSriRetenciones;
	}

	public Boolean getActivarfecha_emisionSriRetenciones() {
		return this.activarfecha_emisionSriRetenciones;
	}

	public void setActivarfecha_emisionSriRetenciones(Boolean activarfecha_emisionSriRetenciones) {
		this.activarfecha_emisionSriRetenciones= activarfecha_emisionSriRetenciones;
	}

	public Border setResaltarfecha_registro_contableSriRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*SriRetencionesBeanSwingJInternalFrame sriretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sriretencionesBeanSwingJInternalFrame.jTtoolBarSriRetenciones.setBorder(borderResaltar);
		
		this.resaltarfecha_registro_contableSriRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_registro_contableSriRetenciones() {
		return this.resaltarfecha_registro_contableSriRetenciones;
	}

	public void setResaltarfecha_registro_contableSriRetenciones(Border borderResaltar) {
		this.resaltarfecha_registro_contableSriRetenciones= borderResaltar;
	}

	public Boolean getMostrarfecha_registro_contableSriRetenciones() {
		return this.mostrarfecha_registro_contableSriRetenciones;
	}

	public void setMostrarfecha_registro_contableSriRetenciones(Boolean mostrarfecha_registro_contableSriRetenciones) {
		this.mostrarfecha_registro_contableSriRetenciones= mostrarfecha_registro_contableSriRetenciones;
	}

	public Boolean getActivarfecha_registro_contableSriRetenciones() {
		return this.activarfecha_registro_contableSriRetenciones;
	}

	public void setActivarfecha_registro_contableSriRetenciones(Boolean activarfecha_registro_contableSriRetenciones) {
		this.activarfecha_registro_contableSriRetenciones= activarfecha_registro_contableSriRetenciones;
	}

	public Border setResaltarnumero_serieSriRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*SriRetencionesBeanSwingJInternalFrame sriretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sriretencionesBeanSwingJInternalFrame.jTtoolBarSriRetenciones.setBorder(borderResaltar);
		
		this.resaltarnumero_serieSriRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_serieSriRetenciones() {
		return this.resaltarnumero_serieSriRetenciones;
	}

	public void setResaltarnumero_serieSriRetenciones(Border borderResaltar) {
		this.resaltarnumero_serieSriRetenciones= borderResaltar;
	}

	public Boolean getMostrarnumero_serieSriRetenciones() {
		return this.mostrarnumero_serieSriRetenciones;
	}

	public void setMostrarnumero_serieSriRetenciones(Boolean mostrarnumero_serieSriRetenciones) {
		this.mostrarnumero_serieSriRetenciones= mostrarnumero_serieSriRetenciones;
	}

	public Boolean getActivarnumero_serieSriRetenciones() {
		return this.activarnumero_serieSriRetenciones;
	}

	public void setActivarnumero_serieSriRetenciones(Boolean activarnumero_serieSriRetenciones) {
		this.activarnumero_serieSriRetenciones= activarnumero_serieSriRetenciones;
	}

	public Border setResaltartotal_ivaSriRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*SriRetencionesBeanSwingJInternalFrame sriretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sriretencionesBeanSwingJInternalFrame.jTtoolBarSriRetenciones.setBorder(borderResaltar);
		
		this.resaltartotal_ivaSriRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ivaSriRetenciones() {
		return this.resaltartotal_ivaSriRetenciones;
	}

	public void setResaltartotal_ivaSriRetenciones(Border borderResaltar) {
		this.resaltartotal_ivaSriRetenciones= borderResaltar;
	}

	public Boolean getMostrartotal_ivaSriRetenciones() {
		return this.mostrartotal_ivaSriRetenciones;
	}

	public void setMostrartotal_ivaSriRetenciones(Boolean mostrartotal_ivaSriRetenciones) {
		this.mostrartotal_ivaSriRetenciones= mostrartotal_ivaSriRetenciones;
	}

	public Boolean getActivartotal_ivaSriRetenciones() {
		return this.activartotal_ivaSriRetenciones;
	}

	public void setActivartotal_ivaSriRetenciones(Boolean activartotal_ivaSriRetenciones) {
		this.activartotal_ivaSriRetenciones= activartotal_ivaSriRetenciones;
	}

	public Border setResaltarmonto_ivaSriRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*SriRetencionesBeanSwingJInternalFrame sriretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sriretencionesBeanSwingJInternalFrame.jTtoolBarSriRetenciones.setBorder(borderResaltar);
		
		this.resaltarmonto_ivaSriRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_ivaSriRetenciones() {
		return this.resaltarmonto_ivaSriRetenciones;
	}

	public void setResaltarmonto_ivaSriRetenciones(Border borderResaltar) {
		this.resaltarmonto_ivaSriRetenciones= borderResaltar;
	}

	public Boolean getMostrarmonto_ivaSriRetenciones() {
		return this.mostrarmonto_ivaSriRetenciones;
	}

	public void setMostrarmonto_ivaSriRetenciones(Boolean mostrarmonto_ivaSriRetenciones) {
		this.mostrarmonto_ivaSriRetenciones= mostrarmonto_ivaSriRetenciones;
	}

	public Boolean getActivarmonto_ivaSriRetenciones() {
		return this.activarmonto_ivaSriRetenciones;
	}

	public void setActivarmonto_ivaSriRetenciones(Boolean activarmonto_ivaSriRetenciones) {
		this.activarmonto_ivaSriRetenciones= activarmonto_ivaSriRetenciones;
	}

	public Border setResaltarnumero_documento_contableSriRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*SriRetencionesBeanSwingJInternalFrame sriretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sriretencionesBeanSwingJInternalFrame.jTtoolBarSriRetenciones.setBorder(borderResaltar);
		
		this.resaltarnumero_documento_contableSriRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_documento_contableSriRetenciones() {
		return this.resaltarnumero_documento_contableSriRetenciones;
	}

	public void setResaltarnumero_documento_contableSriRetenciones(Border borderResaltar) {
		this.resaltarnumero_documento_contableSriRetenciones= borderResaltar;
	}

	public Boolean getMostrarnumero_documento_contableSriRetenciones() {
		return this.mostrarnumero_documento_contableSriRetenciones;
	}

	public void setMostrarnumero_documento_contableSriRetenciones(Boolean mostrarnumero_documento_contableSriRetenciones) {
		this.mostrarnumero_documento_contableSriRetenciones= mostrarnumero_documento_contableSriRetenciones;
	}

	public Boolean getActivarnumero_documento_contableSriRetenciones() {
		return this.activarnumero_documento_contableSriRetenciones;
	}

	public void setActivarnumero_documento_contableSriRetenciones(Boolean activarnumero_documento_contableSriRetenciones) {
		this.activarnumero_documento_contableSriRetenciones= activarnumero_documento_contableSriRetenciones;
	}

	public Border setResaltarnombre_cuenta_contable_retencionSriRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*SriRetencionesBeanSwingJInternalFrame sriretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sriretencionesBeanSwingJInternalFrame.jTtoolBarSriRetenciones.setBorder(borderResaltar);
		
		this.resaltarnombre_cuenta_contable_retencionSriRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cuenta_contable_retencionSriRetenciones() {
		return this.resaltarnombre_cuenta_contable_retencionSriRetenciones;
	}

	public void setResaltarnombre_cuenta_contable_retencionSriRetenciones(Border borderResaltar) {
		this.resaltarnombre_cuenta_contable_retencionSriRetenciones= borderResaltar;
	}

	public Boolean getMostrarnombre_cuenta_contable_retencionSriRetenciones() {
		return this.mostrarnombre_cuenta_contable_retencionSriRetenciones;
	}

	public void setMostrarnombre_cuenta_contable_retencionSriRetenciones(Boolean mostrarnombre_cuenta_contable_retencionSriRetenciones) {
		this.mostrarnombre_cuenta_contable_retencionSriRetenciones= mostrarnombre_cuenta_contable_retencionSriRetenciones;
	}

	public Boolean getActivarnombre_cuenta_contable_retencionSriRetenciones() {
		return this.activarnombre_cuenta_contable_retencionSriRetenciones;
	}

	public void setActivarnombre_cuenta_contable_retencionSriRetenciones(Boolean activarnombre_cuenta_contable_retencionSriRetenciones) {
		this.activarnombre_cuenta_contable_retencionSriRetenciones= activarnombre_cuenta_contable_retencionSriRetenciones;
	}

	public Border setResaltarporcentajeSriRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*SriRetencionesBeanSwingJInternalFrame sriretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sriretencionesBeanSwingJInternalFrame.jTtoolBarSriRetenciones.setBorder(borderResaltar);
		
		this.resaltarporcentajeSriRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeSriRetenciones() {
		return this.resaltarporcentajeSriRetenciones;
	}

	public void setResaltarporcentajeSriRetenciones(Border borderResaltar) {
		this.resaltarporcentajeSriRetenciones= borderResaltar;
	}

	public Boolean getMostrarporcentajeSriRetenciones() {
		return this.mostrarporcentajeSriRetenciones;
	}

	public void setMostrarporcentajeSriRetenciones(Boolean mostrarporcentajeSriRetenciones) {
		this.mostrarporcentajeSriRetenciones= mostrarporcentajeSriRetenciones;
	}

	public Boolean getActivarporcentajeSriRetenciones() {
		return this.activarporcentajeSriRetenciones;
	}

	public void setActivarporcentajeSriRetenciones(Boolean activarporcentajeSriRetenciones) {
		this.activarporcentajeSriRetenciones= activarporcentajeSriRetenciones;
	}

	public Border setResaltarvalorSriRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*SriRetencionesBeanSwingJInternalFrame sriretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sriretencionesBeanSwingJInternalFrame.jTtoolBarSriRetenciones.setBorder(borderResaltar);
		
		this.resaltarvalorSriRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorSriRetenciones() {
		return this.resaltarvalorSriRetenciones;
	}

	public void setResaltarvalorSriRetenciones(Border borderResaltar) {
		this.resaltarvalorSriRetenciones= borderResaltar;
	}

	public Boolean getMostrarvalorSriRetenciones() {
		return this.mostrarvalorSriRetenciones;
	}

	public void setMostrarvalorSriRetenciones(Boolean mostrarvalorSriRetenciones) {
		this.mostrarvalorSriRetenciones= mostrarvalorSriRetenciones;
	}

	public Boolean getActivarvalorSriRetenciones() {
		return this.activarvalorSriRetenciones;
	}

	public void setActivarvalorSriRetenciones(Boolean activarvalorSriRetenciones) {
		this.activarvalorSriRetenciones= activarvalorSriRetenciones;
	}

	public Border setResaltarnombre_benefSriRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*SriRetencionesBeanSwingJInternalFrame sriretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sriretencionesBeanSwingJInternalFrame.jTtoolBarSriRetenciones.setBorder(borderResaltar);
		
		this.resaltarnombre_benefSriRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_benefSriRetenciones() {
		return this.resaltarnombre_benefSriRetenciones;
	}

	public void setResaltarnombre_benefSriRetenciones(Border borderResaltar) {
		this.resaltarnombre_benefSriRetenciones= borderResaltar;
	}

	public Boolean getMostrarnombre_benefSriRetenciones() {
		return this.mostrarnombre_benefSriRetenciones;
	}

	public void setMostrarnombre_benefSriRetenciones(Boolean mostrarnombre_benefSriRetenciones) {
		this.mostrarnombre_benefSriRetenciones= mostrarnombre_benefSriRetenciones;
	}

	public Boolean getActivarnombre_benefSriRetenciones() {
		return this.activarnombre_benefSriRetenciones;
	}

	public void setActivarnombre_benefSriRetenciones(Boolean activarnombre_benefSriRetenciones) {
		this.activarnombre_benefSriRetenciones= activarnombre_benefSriRetenciones;
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
		
		
		this.setMostraridSriRetenciones(esInicial);
		this.setMostrarid_empresaSriRetenciones(esInicial);
		this.setMostrarid_ejercicioSriRetenciones(esInicial);
		this.setMostrarid_periodo_declaraSriRetenciones(esInicial);
		this.setMostrarrucSriRetenciones(esInicial);
		this.setMostrarnombre_moduloSriRetenciones(esInicial);
		this.setMostrarnombre_tipo_comprobanteSriRetenciones(esInicial);
		this.setMostrarnumero_documentoSriRetenciones(esInicial);
		this.setMostrarfecha_emisionSriRetenciones(esInicial);
		this.setMostrarfecha_registro_contableSriRetenciones(esInicial);
		this.setMostrarnumero_serieSriRetenciones(esInicial);
		this.setMostrartotal_ivaSriRetenciones(esInicial);
		this.setMostrarmonto_ivaSriRetenciones(esInicial);
		this.setMostrarnumero_documento_contableSriRetenciones(esInicial);
		this.setMostrarnombre_cuenta_contable_retencionSriRetenciones(esInicial);
		this.setMostrarporcentajeSriRetenciones(esInicial);
		this.setMostrarvalorSriRetenciones(esInicial);
		this.setMostrarnombre_benefSriRetenciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SriRetencionesConstantesFunciones.ID)) {
				this.setMostraridSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.IDPERIODODECLARA)) {
				this.setMostrarid_periodo_declaraSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.RUC)) {
				this.setMostrarrucSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.NOMBREMODULO)) {
				this.setMostrarnombre_moduloSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.NOMBRETIPOCOMPROBANTE)) {
				this.setMostrarnombre_tipo_comprobanteSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.NUMERODOCUMENTO)) {
				this.setMostrarnumero_documentoSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.FECHAREGISTROCONTABLE)) {
				this.setMostrarfecha_registro_contableSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.NUMEROSERIE)) {
				this.setMostrarnumero_serieSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.TOTALIVA)) {
				this.setMostrartotal_ivaSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.MONTOIVA)) {
				this.setMostrarmonto_ivaSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.NUMERODOCUMENTOCONTABLE)) {
				this.setMostrarnumero_documento_contableSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.NOMBRECUENTACONTABLERETENCION)) {
				this.setMostrarnombre_cuenta_contable_retencionSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.VALOR)) {
				this.setMostrarvalorSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.NOMBREBENEF)) {
				this.setMostrarnombre_benefSriRetenciones(esAsigna);
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
		
		
		this.setActivaridSriRetenciones(esInicial);
		this.setActivarid_empresaSriRetenciones(esInicial);
		this.setActivarid_ejercicioSriRetenciones(esInicial);
		this.setActivarid_periodo_declaraSriRetenciones(esInicial);
		this.setActivarrucSriRetenciones(esInicial);
		this.setActivarnombre_moduloSriRetenciones(esInicial);
		this.setActivarnombre_tipo_comprobanteSriRetenciones(esInicial);
		this.setActivarnumero_documentoSriRetenciones(esInicial);
		this.setActivarfecha_emisionSriRetenciones(esInicial);
		this.setActivarfecha_registro_contableSriRetenciones(esInicial);
		this.setActivarnumero_serieSriRetenciones(esInicial);
		this.setActivartotal_ivaSriRetenciones(esInicial);
		this.setActivarmonto_ivaSriRetenciones(esInicial);
		this.setActivarnumero_documento_contableSriRetenciones(esInicial);
		this.setActivarnombre_cuenta_contable_retencionSriRetenciones(esInicial);
		this.setActivarporcentajeSriRetenciones(esInicial);
		this.setActivarvalorSriRetenciones(esInicial);
		this.setActivarnombre_benefSriRetenciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SriRetencionesConstantesFunciones.ID)) {
				this.setActivaridSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.IDPERIODODECLARA)) {
				this.setActivarid_periodo_declaraSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.RUC)) {
				this.setActivarrucSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.NOMBREMODULO)) {
				this.setActivarnombre_moduloSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.NOMBRETIPOCOMPROBANTE)) {
				this.setActivarnombre_tipo_comprobanteSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.NUMERODOCUMENTO)) {
				this.setActivarnumero_documentoSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.FECHAREGISTROCONTABLE)) {
				this.setActivarfecha_registro_contableSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.NUMEROSERIE)) {
				this.setActivarnumero_serieSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.TOTALIVA)) {
				this.setActivartotal_ivaSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.MONTOIVA)) {
				this.setActivarmonto_ivaSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.NUMERODOCUMENTOCONTABLE)) {
				this.setActivarnumero_documento_contableSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.NOMBRECUENTACONTABLERETENCION)) {
				this.setActivarnombre_cuenta_contable_retencionSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.VALOR)) {
				this.setActivarvalorSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.NOMBREBENEF)) {
				this.setActivarnombre_benefSriRetenciones(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SriRetencionesBeanSwingJInternalFrame sriretencionesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSriRetenciones(esInicial);
		this.setResaltarid_empresaSriRetenciones(esInicial);
		this.setResaltarid_ejercicioSriRetenciones(esInicial);
		this.setResaltarid_periodo_declaraSriRetenciones(esInicial);
		this.setResaltarrucSriRetenciones(esInicial);
		this.setResaltarnombre_moduloSriRetenciones(esInicial);
		this.setResaltarnombre_tipo_comprobanteSriRetenciones(esInicial);
		this.setResaltarnumero_documentoSriRetenciones(esInicial);
		this.setResaltarfecha_emisionSriRetenciones(esInicial);
		this.setResaltarfecha_registro_contableSriRetenciones(esInicial);
		this.setResaltarnumero_serieSriRetenciones(esInicial);
		this.setResaltartotal_ivaSriRetenciones(esInicial);
		this.setResaltarmonto_ivaSriRetenciones(esInicial);
		this.setResaltarnumero_documento_contableSriRetenciones(esInicial);
		this.setResaltarnombre_cuenta_contable_retencionSriRetenciones(esInicial);
		this.setResaltarporcentajeSriRetenciones(esInicial);
		this.setResaltarvalorSriRetenciones(esInicial);
		this.setResaltarnombre_benefSriRetenciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SriRetencionesConstantesFunciones.ID)) {
				this.setResaltaridSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.IDPERIODODECLARA)) {
				this.setResaltarid_periodo_declaraSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.RUC)) {
				this.setResaltarrucSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.NOMBREMODULO)) {
				this.setResaltarnombre_moduloSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.NOMBRETIPOCOMPROBANTE)) {
				this.setResaltarnombre_tipo_comprobanteSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.NUMERODOCUMENTO)) {
				this.setResaltarnumero_documentoSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.FECHAREGISTROCONTABLE)) {
				this.setResaltarfecha_registro_contableSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.NUMEROSERIE)) {
				this.setResaltarnumero_serieSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.TOTALIVA)) {
				this.setResaltartotal_ivaSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.MONTOIVA)) {
				this.setResaltarmonto_ivaSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.NUMERODOCUMENTOCONTABLE)) {
				this.setResaltarnumero_documento_contableSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.NOMBRECUENTACONTABLERETENCION)) {
				this.setResaltarnombre_cuenta_contable_retencionSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.VALOR)) {
				this.setResaltarvalorSriRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriRetencionesConstantesFunciones.NOMBREBENEF)) {
				this.setResaltarnombre_benefSriRetenciones(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SriRetencionesBeanSwingJInternalFrame sriretencionesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaSriRetencionesSriRetenciones=true;

	public Boolean getMostrarBusquedaSriRetencionesSriRetenciones() {
		return this.mostrarBusquedaSriRetencionesSriRetenciones;
	}

	public void setMostrarBusquedaSriRetencionesSriRetenciones(Boolean visibilidadResaltar) {
		this.mostrarBusquedaSriRetencionesSriRetenciones= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaSriRetencionesSriRetenciones=true;

	public Boolean getActivarBusquedaSriRetencionesSriRetenciones() {
		return this.activarBusquedaSriRetencionesSriRetenciones;
	}

	public void setActivarBusquedaSriRetencionesSriRetenciones(Boolean habilitarResaltar) {
		this.activarBusquedaSriRetencionesSriRetenciones= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaSriRetencionesSriRetenciones=null;

	public Border getResaltarBusquedaSriRetencionesSriRetenciones() {
		return this.resaltarBusquedaSriRetencionesSriRetenciones;
	}

	public void setResaltarBusquedaSriRetencionesSriRetenciones(Border borderResaltar) {
		this.resaltarBusquedaSriRetencionesSriRetenciones= borderResaltar;
	}

	public void setResaltarBusquedaSriRetencionesSriRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*SriRetencionesBeanSwingJInternalFrame sriretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaSriRetencionesSriRetenciones= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}