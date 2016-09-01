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


import com.bydan.erp.sris.util.report.SriDetalladosIvaConstantesFunciones;
import com.bydan.erp.sris.util.report.SriDetalladosIvaParameterReturnGeneral;
//import com.bydan.erp.sris.util.report.SriDetalladosIvaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.sris.business.entity.report.*;



import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


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
final public class SriDetalladosIvaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="SriDetalladosIva";
	public static final String SPATHOPCION="Sris";	
	public static final String SPATHMODULO="sris/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="SriDetalladosIva"+SriDetalladosIvaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SriDetalladosIvaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SriDetalladosIvaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SriDetalladosIvaConstantesFunciones.SCHEMA+"_"+SriDetalladosIvaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SriDetalladosIvaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SriDetalladosIvaConstantesFunciones.SCHEMA+"_"+SriDetalladosIvaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SriDetalladosIvaConstantesFunciones.SCHEMA+"_"+SriDetalladosIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SriDetalladosIvaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SriDetalladosIvaConstantesFunciones.SCHEMA+"_"+SriDetalladosIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriDetalladosIvaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SriDetalladosIvaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriDetalladosIvaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriDetalladosIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SriDetalladosIvaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriDetalladosIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SriDetalladosIvaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SriDetalladosIvaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SriDetalladosIvaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SriDetalladosIvaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Sri Detallados Ivas";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Sri Detallados Iva";
	public static final String SCLASSWEBTITULO_LOWER="Sri Detallados Iva";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="SriDetalladosIva";
	public static final String OBJECTNAME="sridetalladosiva";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SRIS;	
	public static final String TABLENAME="sri_detallados_iva";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select sridetalladosiva from "+SriDetalladosIvaConstantesFunciones.SPERSISTENCENAME+" sridetalladosiva";
	public static String QUERYSELECTNATIVE="select "+SriDetalladosIvaConstantesFunciones.SCHEMA+"."+SriDetalladosIvaConstantesFunciones.TABLENAME+".id,"+SriDetalladosIvaConstantesFunciones.SCHEMA+"."+SriDetalladosIvaConstantesFunciones.TABLENAME+".version_row,"+SriDetalladosIvaConstantesFunciones.SCHEMA+"."+SriDetalladosIvaConstantesFunciones.TABLENAME+".id_periodo_declara,"+SriDetalladosIvaConstantesFunciones.SCHEMA+"."+SriDetalladosIvaConstantesFunciones.TABLENAME+".id_tipo_comprobante,"+SriDetalladosIvaConstantesFunciones.SCHEMA+"."+SriDetalladosIvaConstantesFunciones.TABLENAME+".ruc,"+SriDetalladosIvaConstantesFunciones.SCHEMA+"."+SriDetalladosIvaConstantesFunciones.TABLENAME+".nombre_tipo_comprobante,"+SriDetalladosIvaConstantesFunciones.SCHEMA+"."+SriDetalladosIvaConstantesFunciones.TABLENAME+".ruc_dato,"+SriDetalladosIvaConstantesFunciones.SCHEMA+"."+SriDetalladosIvaConstantesFunciones.TABLENAME+".numero_documento,"+SriDetalladosIvaConstantesFunciones.SCHEMA+"."+SriDetalladosIvaConstantesFunciones.TABLENAME+".fecha_emision,"+SriDetalladosIvaConstantesFunciones.SCHEMA+"."+SriDetalladosIvaConstantesFunciones.TABLENAME+".fecha_registro_contable,"+SriDetalladosIvaConstantesFunciones.SCHEMA+"."+SriDetalladosIvaConstantesFunciones.TABLENAME+".numero_serie,"+SriDetalladosIvaConstantesFunciones.SCHEMA+"."+SriDetalladosIvaConstantesFunciones.TABLENAME+".total_iva,"+SriDetalladosIvaConstantesFunciones.SCHEMA+"."+SriDetalladosIvaConstantesFunciones.TABLENAME+".total_sin_iva,"+SriDetalladosIvaConstantesFunciones.SCHEMA+"."+SriDetalladosIvaConstantesFunciones.TABLENAME+".id_tipo_iva,"+SriDetalladosIvaConstantesFunciones.SCHEMA+"."+SriDetalladosIvaConstantesFunciones.TABLENAME+".id_tipo_retencion_iva,"+SriDetalladosIvaConstantesFunciones.SCHEMA+"."+SriDetalladosIvaConstantesFunciones.TABLENAME+".transfe_iva_retenido,"+SriDetalladosIvaConstantesFunciones.SCHEMA+"."+SriDetalladosIvaConstantesFunciones.TABLENAME+".id_tipo_retencion_iva_presta,"+SriDetalladosIvaConstantesFunciones.SCHEMA+"."+SriDetalladosIvaConstantesFunciones.TABLENAME+".presta_iva_retenido from "+SriDetalladosIvaConstantesFunciones.SCHEMA+"."+SriDetalladosIvaConstantesFunciones.TABLENAME;//+" as "+SriDetalladosIvaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPERIODODECLARA= "id_periodo_declara";
    public static final String IDTIPOCOMPROBANTE= "id_tipo_comprobante";
    public static final String RUC= "ruc";
    public static final String NOMBRETIPOCOMPROBANTE= "nombre_tipo_comprobante";
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
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPERIODODECLARA= "Periodo Declara";
		public static final String LABEL_IDPERIODODECLARA_LOWER= "Periodo Declara";
    	public static final String LABEL_IDTIPOCOMPROBANTE= "Tipo Comprobante";
		public static final String LABEL_IDTIPOCOMPROBANTE_LOWER= "Tipo Comprobante";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_NOMBRETIPOCOMPROBANTE= "Nombre Tipo Comprobante";
		public static final String LABEL_NOMBRETIPOCOMPROBANTE_LOWER= "Nombre Tipo Comprobante";
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
	
		
		
		
		
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_TIPO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TIPO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC_DATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC_DATO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_SERIE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SERIE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	
	public static String getSriDetalladosIvaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SriDetalladosIvaConstantesFunciones.IDPERIODODECLARA)) {sLabelColumna=SriDetalladosIvaConstantesFunciones.LABEL_IDPERIODODECLARA;}
		if(sNombreColumna.equals(SriDetalladosIvaConstantesFunciones.IDTIPOCOMPROBANTE)) {sLabelColumna=SriDetalladosIvaConstantesFunciones.LABEL_IDTIPOCOMPROBANTE;}
		if(sNombreColumna.equals(SriDetalladosIvaConstantesFunciones.RUC)) {sLabelColumna=SriDetalladosIvaConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(SriDetalladosIvaConstantesFunciones.NOMBRETIPOCOMPROBANTE)) {sLabelColumna=SriDetalladosIvaConstantesFunciones.LABEL_NOMBRETIPOCOMPROBANTE;}
		if(sNombreColumna.equals(SriDetalladosIvaConstantesFunciones.RUCDATO)) {sLabelColumna=SriDetalladosIvaConstantesFunciones.LABEL_RUCDATO;}
		if(sNombreColumna.equals(SriDetalladosIvaConstantesFunciones.NUMERODOCUMENTO)) {sLabelColumna=SriDetalladosIvaConstantesFunciones.LABEL_NUMERODOCUMENTO;}
		if(sNombreColumna.equals(SriDetalladosIvaConstantesFunciones.FECHAEMISION)) {sLabelColumna=SriDetalladosIvaConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(SriDetalladosIvaConstantesFunciones.FECHAREGISTROCONTABLE)) {sLabelColumna=SriDetalladosIvaConstantesFunciones.LABEL_FECHAREGISTROCONTABLE;}
		if(sNombreColumna.equals(SriDetalladosIvaConstantesFunciones.NUMEROSERIE)) {sLabelColumna=SriDetalladosIvaConstantesFunciones.LABEL_NUMEROSERIE;}
		if(sNombreColumna.equals(SriDetalladosIvaConstantesFunciones.TOTALIVA)) {sLabelColumna=SriDetalladosIvaConstantesFunciones.LABEL_TOTALIVA;}
		if(sNombreColumna.equals(SriDetalladosIvaConstantesFunciones.TOTALSINIVA)) {sLabelColumna=SriDetalladosIvaConstantesFunciones.LABEL_TOTALSINIVA;}
		if(sNombreColumna.equals(SriDetalladosIvaConstantesFunciones.IDTIPOIVA)) {sLabelColumna=SriDetalladosIvaConstantesFunciones.LABEL_IDTIPOIVA;}
		if(sNombreColumna.equals(SriDetalladosIvaConstantesFunciones.IDTIPORETENCIONIVA)) {sLabelColumna=SriDetalladosIvaConstantesFunciones.LABEL_IDTIPORETENCIONIVA;}
		if(sNombreColumna.equals(SriDetalladosIvaConstantesFunciones.TRANSFEIVARETENIDO)) {sLabelColumna=SriDetalladosIvaConstantesFunciones.LABEL_TRANSFEIVARETENIDO;}
		if(sNombreColumna.equals(SriDetalladosIvaConstantesFunciones.IDTIPORETENCIONIVAPRESTA)) {sLabelColumna=SriDetalladosIvaConstantesFunciones.LABEL_IDTIPORETENCIONIVAPRESTA;}
		if(sNombreColumna.equals(SriDetalladosIvaConstantesFunciones.PRESTAIVARETENIDO)) {sLabelColumna=SriDetalladosIvaConstantesFunciones.LABEL_PRESTAIVARETENIDO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getSriDetalladosIvaDescripcion(SriDetalladosIva sridetalladosiva) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(sridetalladosiva !=null/* && sridetalladosiva.getId()!=0*/) {
			sDescripcion=sridetalladosiva.getruc();//sridetalladosivasridetalladosiva.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getSriDetalladosIvaDescripcionDetallado(SriDetalladosIva sridetalladosiva) {
		String sDescripcion="";
			
		sDescripcion+=SriDetalladosIvaConstantesFunciones.ID+"=";
		sDescripcion+=sridetalladosiva.getId().toString()+",";
		sDescripcion+=SriDetalladosIvaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=sridetalladosiva.getVersionRow().toString()+",";
		sDescripcion+=SriDetalladosIvaConstantesFunciones.IDPERIODODECLARA+"=";
		sDescripcion+=sridetalladosiva.getid_periodo_declara().toString()+",";
		sDescripcion+=SriDetalladosIvaConstantesFunciones.IDTIPOCOMPROBANTE+"=";
		sDescripcion+=sridetalladosiva.getid_tipo_comprobante().toString()+",";
		sDescripcion+=SriDetalladosIvaConstantesFunciones.RUC+"=";
		sDescripcion+=sridetalladosiva.getruc()+",";
		sDescripcion+=SriDetalladosIvaConstantesFunciones.NOMBRETIPOCOMPROBANTE+"=";
		sDescripcion+=sridetalladosiva.getnombre_tipo_comprobante()+",";
		sDescripcion+=SriDetalladosIvaConstantesFunciones.RUCDATO+"=";
		sDescripcion+=sridetalladosiva.getruc_dato()+",";
		sDescripcion+=SriDetalladosIvaConstantesFunciones.NUMERODOCUMENTO+"=";
		sDescripcion+=sridetalladosiva.getnumero_documento()+",";
		sDescripcion+=SriDetalladosIvaConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=sridetalladosiva.getfecha_emision().toString()+",";
		sDescripcion+=SriDetalladosIvaConstantesFunciones.FECHAREGISTROCONTABLE+"=";
		sDescripcion+=sridetalladosiva.getfecha_registro_contable().toString()+",";
		sDescripcion+=SriDetalladosIvaConstantesFunciones.NUMEROSERIE+"=";
		sDescripcion+=sridetalladosiva.getnumero_serie()+",";
		sDescripcion+=SriDetalladosIvaConstantesFunciones.TOTALIVA+"=";
		sDescripcion+=sridetalladosiva.gettotal_iva().toString()+",";
		sDescripcion+=SriDetalladosIvaConstantesFunciones.TOTALSINIVA+"=";
		sDescripcion+=sridetalladosiva.gettotal_sin_iva().toString()+",";
		sDescripcion+=SriDetalladosIvaConstantesFunciones.IDTIPOIVA+"=";
		sDescripcion+=sridetalladosiva.getid_tipo_iva().toString()+",";
		sDescripcion+=SriDetalladosIvaConstantesFunciones.IDTIPORETENCIONIVA+"=";
		sDescripcion+=sridetalladosiva.getid_tipo_retencion_iva().toString()+",";
		sDescripcion+=SriDetalladosIvaConstantesFunciones.TRANSFEIVARETENIDO+"=";
		sDescripcion+=sridetalladosiva.gettransfe_iva_retenido().toString()+",";
		sDescripcion+=SriDetalladosIvaConstantesFunciones.IDTIPORETENCIONIVAPRESTA+"=";
		sDescripcion+=sridetalladosiva.getid_tipo_retencion_iva_presta().toString()+",";
		sDescripcion+=SriDetalladosIvaConstantesFunciones.PRESTAIVARETENIDO+"=";
		sDescripcion+=sridetalladosiva.getpresta_iva_retenido().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setSriDetalladosIvaDescripcion(SriDetalladosIva sridetalladosiva,String sValor) throws Exception {			
		if(sridetalladosiva !=null) {
			sridetalladosiva.setruc(sValor);//sridetalladosivasridetalladosiva.getId().toString();
		}		
	}
	
		

	public static String getPeriodoDeclaraDescripcion(PeriodoDeclara periododeclara) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periododeclara!=null/*&&periododeclara.getId()>0*/) {
			sDescripcion=PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(periododeclara);
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
		} else if(sNombreIndice.equals("BusquedaSriDetalladosIva")) {
			sNombreIndice="Tipo=  Por Periodo Declara Por Tipo Comprobante Por Ruc";
		} else if(sNombreIndice.equals("FK_IdPeriodoDeclara")) {
			sNombreIndice="Tipo=  Por Periodo Declara";
		} else if(sNombreIndice.equals("FK_IdTipoComprobante")) {
			sNombreIndice="Tipo=  Por Tipo Comprobante";
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

	public static String getDetalleIndiceBusquedaSriDetalladosIva(Long id_periodo_declara,Long id_tipo_comprobante,String ruc) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo_declara!=null) {sDetalleIndice+=" Codigo Unico De Periodo Declara="+id_periodo_declara.toString();}
		if(id_tipo_comprobante!=null) {sDetalleIndice+=" Codigo Unico De Tipo Comprobante="+id_tipo_comprobante.toString();}
		if(ruc!=null) {sDetalleIndice+=" Ruc="+ruc;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodoDeclara(Long id_periodo_declara) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo_declara!=null) {sDetalleIndice+=" Codigo Unico De Periodo Declara="+id_periodo_declara.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoComprobante(Long id_tipo_comprobante) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_comprobante!=null) {sDetalleIndice+=" Codigo Unico De Tipo Comprobante="+id_tipo_comprobante.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosSriDetalladosIva(SriDetalladosIva sridetalladosiva,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		sridetalladosiva.setnombre_tipo_comprobante(sridetalladosiva.getnombre_tipo_comprobante().trim());
		sridetalladosiva.setruc_dato(sridetalladosiva.getruc_dato().trim());
		sridetalladosiva.setnumero_documento(sridetalladosiva.getnumero_documento().trim());
		sridetalladosiva.setnumero_serie(sridetalladosiva.getnumero_serie().trim());
	}
	
	public static void quitarEspaciosSriDetalladosIvas(List<SriDetalladosIva> sridetalladosivas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SriDetalladosIva sridetalladosiva: sridetalladosivas) {
			sridetalladosiva.setnombre_tipo_comprobante(sridetalladosiva.getnombre_tipo_comprobante().trim());
			sridetalladosiva.setruc_dato(sridetalladosiva.getruc_dato().trim());
			sridetalladosiva.setnumero_documento(sridetalladosiva.getnumero_documento().trim());
			sridetalladosiva.setnumero_serie(sridetalladosiva.getnumero_serie().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSriDetalladosIva(SriDetalladosIva sridetalladosiva,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && sridetalladosiva.getConCambioAuxiliar()) {
			sridetalladosiva.setIsDeleted(sridetalladosiva.getIsDeletedAuxiliar());	
			sridetalladosiva.setIsNew(sridetalladosiva.getIsNewAuxiliar());	
			sridetalladosiva.setIsChanged(sridetalladosiva.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			sridetalladosiva.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			sridetalladosiva.setIsDeletedAuxiliar(false);	
			sridetalladosiva.setIsNewAuxiliar(false);	
			sridetalladosiva.setIsChangedAuxiliar(false);
			
			sridetalladosiva.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSriDetalladosIvas(List<SriDetalladosIva> sridetalladosivas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(SriDetalladosIva sridetalladosiva : sridetalladosivas) {
			if(conAsignarBase && sridetalladosiva.getConCambioAuxiliar()) {
				sridetalladosiva.setIsDeleted(sridetalladosiva.getIsDeletedAuxiliar());	
				sridetalladosiva.setIsNew(sridetalladosiva.getIsNewAuxiliar());	
				sridetalladosiva.setIsChanged(sridetalladosiva.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				sridetalladosiva.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				sridetalladosiva.setIsDeletedAuxiliar(false);	
				sridetalladosiva.setIsNewAuxiliar(false);	
				sridetalladosiva.setIsChangedAuxiliar(false);
				
				sridetalladosiva.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSriDetalladosIva(SriDetalladosIva sridetalladosiva,Boolean conEnteros) throws Exception  {
		sridetalladosiva.settotal_iva(0.0);
		sridetalladosiva.settotal_sin_iva(0.0);
		sridetalladosiva.settransfe_iva_retenido(0.0);
		sridetalladosiva.setpresta_iva_retenido(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSriDetalladosIvas(List<SriDetalladosIva> sridetalladosivas,Boolean conEnteros) throws Exception  {
		
		for(SriDetalladosIva sridetalladosiva: sridetalladosivas) {
			sridetalladosiva.settotal_iva(0.0);
			sridetalladosiva.settotal_sin_iva(0.0);
			sridetalladosiva.settransfe_iva_retenido(0.0);
			sridetalladosiva.setpresta_iva_retenido(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSriDetalladosIva(List<SriDetalladosIva> sridetalladosivas,SriDetalladosIva sridetalladosivaAux) throws Exception  {
		SriDetalladosIvaConstantesFunciones.InicializarValoresSriDetalladosIva(sridetalladosivaAux,true);
		
		for(SriDetalladosIva sridetalladosiva: sridetalladosivas) {
			if(sridetalladosiva.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			sridetalladosivaAux.settotal_iva(sridetalladosivaAux.gettotal_iva()+sridetalladosiva.gettotal_iva());			
			sridetalladosivaAux.settotal_sin_iva(sridetalladosivaAux.gettotal_sin_iva()+sridetalladosiva.gettotal_sin_iva());			
			sridetalladosivaAux.settransfe_iva_retenido(sridetalladosivaAux.gettransfe_iva_retenido()+sridetalladosiva.gettransfe_iva_retenido());			
			sridetalladosivaAux.setpresta_iva_retenido(sridetalladosivaAux.getpresta_iva_retenido()+sridetalladosiva.getpresta_iva_retenido());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSriDetalladosIva(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SriDetalladosIvaConstantesFunciones.getArrayColumnasGlobalesSriDetalladosIva(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSriDetalladosIva(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSriDetalladosIva(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SriDetalladosIva> sridetalladosivas,SriDetalladosIva sridetalladosiva,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SriDetalladosIva sridetalladosivaAux: sridetalladosivas) {
			if(sridetalladosivaAux!=null && sridetalladosiva!=null) {
				if((sridetalladosivaAux.getId()==null && sridetalladosiva.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(sridetalladosivaAux.getId()!=null && sridetalladosiva.getId()!=null){
					if(sridetalladosivaAux.getId().equals(sridetalladosiva.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSriDetalladosIva(List<SriDetalladosIva> sridetalladosivas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_ivaTotal=0.0;
		Double total_sin_ivaTotal=0.0;
		Double transfe_iva_retenidoTotal=0.0;
		Double presta_iva_retenidoTotal=0.0;
	
		for(SriDetalladosIva sridetalladosiva: sridetalladosivas) {			
			if(sridetalladosiva.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			total_ivaTotal+=sridetalladosiva.gettotal_iva();
			total_sin_ivaTotal+=sridetalladosiva.gettotal_sin_iva();
			transfe_iva_retenidoTotal+=sridetalladosiva.gettransfe_iva_retenido();
			presta_iva_retenidoTotal+=sridetalladosiva.getpresta_iva_retenido();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriDetalladosIvaConstantesFunciones.TOTALIVA);
		datoGeneral.setsDescripcion(SriDetalladosIvaConstantesFunciones.LABEL_TOTALIVA);
		datoGeneral.setdValorDouble(total_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriDetalladosIvaConstantesFunciones.TOTALSINIVA);
		datoGeneral.setsDescripcion(SriDetalladosIvaConstantesFunciones.LABEL_TOTALSINIVA);
		datoGeneral.setdValorDouble(total_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriDetalladosIvaConstantesFunciones.TRANSFEIVARETENIDO);
		datoGeneral.setsDescripcion(SriDetalladosIvaConstantesFunciones.LABEL_TRANSFEIVARETENIDO);
		datoGeneral.setdValorDouble(transfe_iva_retenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriDetalladosIvaConstantesFunciones.PRESTAIVARETENIDO);
		datoGeneral.setsDescripcion(SriDetalladosIvaConstantesFunciones.LABEL_PRESTAIVARETENIDO);
		datoGeneral.setdValorDouble(presta_iva_retenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSriDetalladosIva() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SriDetalladosIvaConstantesFunciones.LABEL_ID, SriDetalladosIvaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriDetalladosIvaConstantesFunciones.LABEL_VERSIONROW, SriDetalladosIvaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriDetalladosIvaConstantesFunciones.LABEL_NOMBRETIPOCOMPROBANTE, SriDetalladosIvaConstantesFunciones.NOMBRETIPOCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriDetalladosIvaConstantesFunciones.LABEL_RUCDATO, SriDetalladosIvaConstantesFunciones.RUCDATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriDetalladosIvaConstantesFunciones.LABEL_NUMERODOCUMENTO, SriDetalladosIvaConstantesFunciones.NUMERODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriDetalladosIvaConstantesFunciones.LABEL_FECHAEMISION, SriDetalladosIvaConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriDetalladosIvaConstantesFunciones.LABEL_FECHAREGISTROCONTABLE, SriDetalladosIvaConstantesFunciones.FECHAREGISTROCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriDetalladosIvaConstantesFunciones.LABEL_NUMEROSERIE, SriDetalladosIvaConstantesFunciones.NUMEROSERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriDetalladosIvaConstantesFunciones.LABEL_TOTALIVA, SriDetalladosIvaConstantesFunciones.TOTALIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriDetalladosIvaConstantesFunciones.LABEL_TOTALSINIVA, SriDetalladosIvaConstantesFunciones.TOTALSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriDetalladosIvaConstantesFunciones.LABEL_IDTIPOIVA, SriDetalladosIvaConstantesFunciones.IDTIPOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriDetalladosIvaConstantesFunciones.LABEL_IDTIPORETENCIONIVA, SriDetalladosIvaConstantesFunciones.IDTIPORETENCIONIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriDetalladosIvaConstantesFunciones.LABEL_TRANSFEIVARETENIDO, SriDetalladosIvaConstantesFunciones.TRANSFEIVARETENIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriDetalladosIvaConstantesFunciones.LABEL_IDTIPORETENCIONIVAPRESTA, SriDetalladosIvaConstantesFunciones.IDTIPORETENCIONIVAPRESTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriDetalladosIvaConstantesFunciones.LABEL_PRESTAIVARETENIDO, SriDetalladosIvaConstantesFunciones.PRESTAIVARETENIDO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSriDetalladosIva() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SriDetalladosIvaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriDetalladosIvaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriDetalladosIvaConstantesFunciones.NOMBRETIPOCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriDetalladosIvaConstantesFunciones.RUCDATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriDetalladosIvaConstantesFunciones.NUMERODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriDetalladosIvaConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriDetalladosIvaConstantesFunciones.FECHAREGISTROCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriDetalladosIvaConstantesFunciones.NUMEROSERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriDetalladosIvaConstantesFunciones.TOTALIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriDetalladosIvaConstantesFunciones.TOTALSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriDetalladosIvaConstantesFunciones.IDTIPOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriDetalladosIvaConstantesFunciones.IDTIPORETENCIONIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriDetalladosIvaConstantesFunciones.TRANSFEIVARETENIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriDetalladosIvaConstantesFunciones.IDTIPORETENCIONIVAPRESTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriDetalladosIvaConstantesFunciones.PRESTAIVARETENIDO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSriDetalladosIva() throws Exception  {
		return SriDetalladosIvaConstantesFunciones.getTiposSeleccionarSriDetalladosIva(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSriDetalladosIva(Boolean conFk) throws Exception  {
		return SriDetalladosIvaConstantesFunciones.getTiposSeleccionarSriDetalladosIva(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSriDetalladosIva(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriDetalladosIvaConstantesFunciones.LABEL_IDPERIODODECLARA);
			reporte.setsDescripcion(SriDetalladosIvaConstantesFunciones.LABEL_IDPERIODODECLARA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriDetalladosIvaConstantesFunciones.LABEL_IDTIPOCOMPROBANTE);
			reporte.setsDescripcion(SriDetalladosIvaConstantesFunciones.LABEL_IDTIPOCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriDetalladosIvaConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(SriDetalladosIvaConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriDetalladosIvaConstantesFunciones.LABEL_NOMBRETIPOCOMPROBANTE);
			reporte.setsDescripcion(SriDetalladosIvaConstantesFunciones.LABEL_NOMBRETIPOCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriDetalladosIvaConstantesFunciones.LABEL_RUCDATO);
			reporte.setsDescripcion(SriDetalladosIvaConstantesFunciones.LABEL_RUCDATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriDetalladosIvaConstantesFunciones.LABEL_NUMERODOCUMENTO);
			reporte.setsDescripcion(SriDetalladosIvaConstantesFunciones.LABEL_NUMERODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriDetalladosIvaConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(SriDetalladosIvaConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriDetalladosIvaConstantesFunciones.LABEL_FECHAREGISTROCONTABLE);
			reporte.setsDescripcion(SriDetalladosIvaConstantesFunciones.LABEL_FECHAREGISTROCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriDetalladosIvaConstantesFunciones.LABEL_NUMEROSERIE);
			reporte.setsDescripcion(SriDetalladosIvaConstantesFunciones.LABEL_NUMEROSERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriDetalladosIvaConstantesFunciones.LABEL_TOTALIVA);
			reporte.setsDescripcion(SriDetalladosIvaConstantesFunciones.LABEL_TOTALIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriDetalladosIvaConstantesFunciones.LABEL_TOTALSINIVA);
			reporte.setsDescripcion(SriDetalladosIvaConstantesFunciones.LABEL_TOTALSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriDetalladosIvaConstantesFunciones.LABEL_IDTIPOIVA);
			reporte.setsDescripcion(SriDetalladosIvaConstantesFunciones.LABEL_IDTIPOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriDetalladosIvaConstantesFunciones.LABEL_IDTIPORETENCIONIVA);
			reporte.setsDescripcion(SriDetalladosIvaConstantesFunciones.LABEL_IDTIPORETENCIONIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriDetalladosIvaConstantesFunciones.LABEL_TRANSFEIVARETENIDO);
			reporte.setsDescripcion(SriDetalladosIvaConstantesFunciones.LABEL_TRANSFEIVARETENIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriDetalladosIvaConstantesFunciones.LABEL_IDTIPORETENCIONIVAPRESTA);
			reporte.setsDescripcion(SriDetalladosIvaConstantesFunciones.LABEL_IDTIPORETENCIONIVAPRESTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriDetalladosIvaConstantesFunciones.LABEL_PRESTAIVARETENIDO);
			reporte.setsDescripcion(SriDetalladosIvaConstantesFunciones.LABEL_PRESTAIVARETENIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSriDetalladosIva(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSriDetalladosIva(SriDetalladosIva sridetalladosivaAux) throws Exception {
		
			sridetalladosivaAux.setperiododeclara_descripcion(PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(sridetalladosivaAux.getPeriodoDeclara()));
			sridetalladosivaAux.settipocomprobante_descripcion(TipoComprobanteConstantesFunciones.getTipoComprobanteDescripcion(sridetalladosivaAux.getTipoComprobante()));
			sridetalladosivaAux.settipoiva_descripcion(TipoIvaConstantesFunciones.getTipoIvaDescripcion(sridetalladosivaAux.getTipoIva()));
			sridetalladosivaAux.settiporetencioniva_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(sridetalladosivaAux.getTipoRetencionIva()));
			sridetalladosivaAux.settiporetencionivapresta_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(sridetalladosivaAux.getTipoRetencionIvaPresta()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSriDetalladosIva(List<SriDetalladosIva> sridetalladosivasTemp) throws Exception {
		for(SriDetalladosIva sridetalladosivaAux:sridetalladosivasTemp) {
			
			sridetalladosivaAux.setperiododeclara_descripcion(PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(sridetalladosivaAux.getPeriodoDeclara()));
			sridetalladosivaAux.settipocomprobante_descripcion(TipoComprobanteConstantesFunciones.getTipoComprobanteDescripcion(sridetalladosivaAux.getTipoComprobante()));
			sridetalladosivaAux.settipoiva_descripcion(TipoIvaConstantesFunciones.getTipoIvaDescripcion(sridetalladosivaAux.getTipoIva()));
			sridetalladosivaAux.settiporetencioniva_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(sridetalladosivaAux.getTipoRetencionIva()));
			sridetalladosivaAux.settiporetencionivapresta_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(sridetalladosivaAux.getTipoRetencionIvaPresta()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSriDetalladosIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PeriodoDeclara.class));
				classes.add(new Classe(TipoComprobante.class));
				classes.add(new Classe(TipoIva.class));
				classes.add(new Classe(TipoRetencion.class));
				classes.add(new Classe(TipoRetencion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PeriodoDeclara.class)) {
						classes.add(new Classe(PeriodoDeclara.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoComprobante.class)) {
						classes.add(new Classe(TipoComprobante.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSriDetalladosIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PeriodoDeclara.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PeriodoDeclara.class)); continue;
					}

					if(TipoComprobante.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoComprobante.class)); continue;
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

					if(PeriodoDeclara.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PeriodoDeclara.class)); continue;
					}

					if(TipoComprobante.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoComprobante.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSriDetalladosIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SriDetalladosIvaConstantesFunciones.getClassesRelationshipsOfSriDetalladosIva(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSriDetalladosIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSriDetalladosIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SriDetalladosIvaConstantesFunciones.getClassesRelationshipsFromStringsOfSriDetalladosIva(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSriDetalladosIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(SriDetalladosIva sridetalladosiva,List<SriDetalladosIva> sridetalladosivas,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(SriDetalladosIva sridetalladosiva,List<SriDetalladosIva> sridetalladosivas) throws Exception {
		try	{			
			for(SriDetalladosIva sridetalladosivaLocal:sridetalladosivas) {
				if(sridetalladosivaLocal.getId().equals(sridetalladosiva.getId())) {
					sridetalladosivaLocal.setIsSelected(sridetalladosiva.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSriDetalladosIva(List<SriDetalladosIva> sridetalladosivasAux) throws Exception {
		//this.sridetalladosivasAux=sridetalladosivasAux;
		
		for(SriDetalladosIva sridetalladosivaAux:sridetalladosivasAux) {
			if(sridetalladosivaAux.getIsChanged()) {
				sridetalladosivaAux.setIsChanged(false);
			}		
			
			if(sridetalladosivaAux.getIsNew()) {
				sridetalladosivaAux.setIsNew(false);
			}	
			
			if(sridetalladosivaAux.getIsDeleted()) {
				sridetalladosivaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSriDetalladosIva(SriDetalladosIva sridetalladosivaAux) throws Exception {
		//this.sridetalladosivaAux=sridetalladosivaAux;
		
			if(sridetalladosivaAux.getIsChanged()) {
				sridetalladosivaAux.setIsChanged(false);
			}		
			
			if(sridetalladosivaAux.getIsNew()) {
				sridetalladosivaAux.setIsNew(false);
			}	
			
			if(sridetalladosivaAux.getIsDeleted()) {
				sridetalladosivaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(SriDetalladosIva sridetalladosivaAsignar,SriDetalladosIva sridetalladosiva) throws Exception {
		sridetalladosivaAsignar.setId(sridetalladosiva.getId());	
		sridetalladosivaAsignar.setVersionRow(sridetalladosiva.getVersionRow());	
		sridetalladosivaAsignar.setnombre_tipo_comprobante(sridetalladosiva.getnombre_tipo_comprobante());	
		sridetalladosivaAsignar.setruc_dato(sridetalladosiva.getruc_dato());	
		sridetalladosivaAsignar.setnumero_documento(sridetalladosiva.getnumero_documento());	
		sridetalladosivaAsignar.setfecha_emision(sridetalladosiva.getfecha_emision());	
		sridetalladosivaAsignar.setfecha_registro_contable(sridetalladosiva.getfecha_registro_contable());	
		sridetalladosivaAsignar.setnumero_serie(sridetalladosiva.getnumero_serie());	
		sridetalladosivaAsignar.settotal_iva(sridetalladosiva.gettotal_iva());	
		sridetalladosivaAsignar.settotal_sin_iva(sridetalladosiva.gettotal_sin_iva());	
		sridetalladosivaAsignar.setid_tipo_iva(sridetalladosiva.getid_tipo_iva());
		sridetalladosivaAsignar.settipoiva_descripcion(sridetalladosiva.gettipoiva_descripcion());	
		sridetalladosivaAsignar.setid_tipo_retencion_iva(sridetalladosiva.getid_tipo_retencion_iva());
		sridetalladosivaAsignar.settiporetencioniva_descripcion(sridetalladosiva.gettiporetencioniva_descripcion());	
		sridetalladosivaAsignar.settransfe_iva_retenido(sridetalladosiva.gettransfe_iva_retenido());	
		sridetalladosivaAsignar.setid_tipo_retencion_iva_presta(sridetalladosiva.getid_tipo_retencion_iva_presta());
		sridetalladosivaAsignar.settiporetencionivapresta_descripcion(sridetalladosiva.gettiporetencionivapresta_descripcion());	
		sridetalladosivaAsignar.setpresta_iva_retenido(sridetalladosiva.getpresta_iva_retenido());	
	}
	
	public static void inicializarSriDetalladosIva(SriDetalladosIva sridetalladosiva) throws Exception {
		try {
				sridetalladosiva.setId(0L);	
					
				sridetalladosiva.setnombre_tipo_comprobante("");	
				sridetalladosiva.setruc_dato("");	
				sridetalladosiva.setnumero_documento("");	
				sridetalladosiva.setfecha_emision(new Date());	
				sridetalladosiva.setfecha_registro_contable(new Date());	
				sridetalladosiva.setnumero_serie("");	
				sridetalladosiva.settotal_iva(0.0);	
				sridetalladosiva.settotal_sin_iva(0.0);	
				sridetalladosiva.setid_tipo_iva(-1L);	
				sridetalladosiva.setid_tipo_retencion_iva(-1L);	
				sridetalladosiva.settransfe_iva_retenido(0.0);	
				sridetalladosiva.setid_tipo_retencion_iva_presta(-1L);	
				sridetalladosiva.setpresta_iva_retenido(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSriDetalladosIva(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SriDetalladosIvaConstantesFunciones.LABEL_IDPERIODODECLARA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriDetalladosIvaConstantesFunciones.LABEL_IDTIPOCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriDetalladosIvaConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriDetalladosIvaConstantesFunciones.LABEL_NOMBRETIPOCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriDetalladosIvaConstantesFunciones.LABEL_RUCDATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriDetalladosIvaConstantesFunciones.LABEL_NUMERODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriDetalladosIvaConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriDetalladosIvaConstantesFunciones.LABEL_FECHAREGISTROCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriDetalladosIvaConstantesFunciones.LABEL_NUMEROSERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriDetalladosIvaConstantesFunciones.LABEL_TOTALIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriDetalladosIvaConstantesFunciones.LABEL_TOTALSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriDetalladosIvaConstantesFunciones.LABEL_IDTIPOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriDetalladosIvaConstantesFunciones.LABEL_IDTIPORETENCIONIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriDetalladosIvaConstantesFunciones.LABEL_TRANSFEIVARETENIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriDetalladosIvaConstantesFunciones.LABEL_IDTIPORETENCIONIVAPRESTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriDetalladosIvaConstantesFunciones.LABEL_PRESTAIVARETENIDO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSriDetalladosIva(String sTipo,Row row,Workbook workbook,SriDetalladosIva sridetalladosiva,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(sridetalladosiva.getperiododeclara_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sridetalladosiva.gettipocomprobante_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sridetalladosiva.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sridetalladosiva.getnombre_tipo_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sridetalladosiva.getruc_dato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sridetalladosiva.getnumero_documento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sridetalladosiva.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sridetalladosiva.getfecha_registro_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sridetalladosiva.getnumero_serie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sridetalladosiva.gettotal_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sridetalladosiva.gettotal_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sridetalladosiva.gettipoiva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sridetalladosiva.gettiporetencioniva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sridetalladosiva.gettransfe_iva_retenido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sridetalladosiva.gettiporetencionivapresta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sridetalladosiva.getpresta_iva_retenido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySriDetalladosIva="";
	
	public String getsFinalQuerySriDetalladosIva() {
		return this.sFinalQuerySriDetalladosIva;
	}
	
	public void setsFinalQuerySriDetalladosIva(String sFinalQuerySriDetalladosIva) {
		this.sFinalQuerySriDetalladosIva= sFinalQuerySriDetalladosIva;
	}
	
	public Border resaltarSeleccionarSriDetalladosIva=null;
	
	public Border setResaltarSeleccionarSriDetalladosIva(ParametroGeneralUsuario parametroGeneralUsuario/*SriDetalladosIvaBeanSwingJInternalFrame sridetalladosivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//sridetalladosivaBeanSwingJInternalFrame.jTtoolBarSriDetalladosIva.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSriDetalladosIva= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSriDetalladosIva() {
		return this.resaltarSeleccionarSriDetalladosIva;
	}
	
	public void setResaltarSeleccionarSriDetalladosIva(Border borderResaltarSeleccionarSriDetalladosIva) {
		this.resaltarSeleccionarSriDetalladosIva= borderResaltarSeleccionarSriDetalladosIva;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSriDetalladosIva=null;
	public Boolean mostraridSriDetalladosIva=true;
	public Boolean activaridSriDetalladosIva=true;

	public Border resaltarid_periodo_declaraSriDetalladosIva=null;
	public Boolean mostrarid_periodo_declaraSriDetalladosIva=true;
	public Boolean activarid_periodo_declaraSriDetalladosIva=true;
	public Boolean cargarid_periodo_declaraSriDetalladosIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodo_declaraSriDetalladosIva=false;//ConEventDepend=true

	public Border resaltarid_tipo_comprobanteSriDetalladosIva=null;
	public Boolean mostrarid_tipo_comprobanteSriDetalladosIva=true;
	public Boolean activarid_tipo_comprobanteSriDetalladosIva=true;
	public Boolean cargarid_tipo_comprobanteSriDetalladosIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_comprobanteSriDetalladosIva=false;//ConEventDepend=true

	public Border resaltarrucSriDetalladosIva=null;
	public Boolean mostrarrucSriDetalladosIva=true;
	public Boolean activarrucSriDetalladosIva=true;

	public Border resaltarnombre_tipo_comprobanteSriDetalladosIva=null;
	public Boolean mostrarnombre_tipo_comprobanteSriDetalladosIva=true;
	public Boolean activarnombre_tipo_comprobanteSriDetalladosIva=true;

	public Border resaltarruc_datoSriDetalladosIva=null;
	public Boolean mostrarruc_datoSriDetalladosIva=true;
	public Boolean activarruc_datoSriDetalladosIva=true;

	public Border resaltarnumero_documentoSriDetalladosIva=null;
	public Boolean mostrarnumero_documentoSriDetalladosIva=true;
	public Boolean activarnumero_documentoSriDetalladosIva=true;

	public Border resaltarfecha_emisionSriDetalladosIva=null;
	public Boolean mostrarfecha_emisionSriDetalladosIva=true;
	public Boolean activarfecha_emisionSriDetalladosIva=true;

	public Border resaltarfecha_registro_contableSriDetalladosIva=null;
	public Boolean mostrarfecha_registro_contableSriDetalladosIva=true;
	public Boolean activarfecha_registro_contableSriDetalladosIva=true;

	public Border resaltarnumero_serieSriDetalladosIva=null;
	public Boolean mostrarnumero_serieSriDetalladosIva=true;
	public Boolean activarnumero_serieSriDetalladosIva=true;

	public Border resaltartotal_ivaSriDetalladosIva=null;
	public Boolean mostrartotal_ivaSriDetalladosIva=true;
	public Boolean activartotal_ivaSriDetalladosIva=true;

	public Border resaltartotal_sin_ivaSriDetalladosIva=null;
	public Boolean mostrartotal_sin_ivaSriDetalladosIva=true;
	public Boolean activartotal_sin_ivaSriDetalladosIva=true;

	public Border resaltarid_tipo_ivaSriDetalladosIva=null;
	public Boolean mostrarid_tipo_ivaSriDetalladosIva=true;
	public Boolean activarid_tipo_ivaSriDetalladosIva=true;
	public Boolean cargarid_tipo_ivaSriDetalladosIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_ivaSriDetalladosIva=false;//ConEventDepend=true

	public Border resaltarid_tipo_retencion_ivaSriDetalladosIva=null;
	public Boolean mostrarid_tipo_retencion_ivaSriDetalladosIva=true;
	public Boolean activarid_tipo_retencion_ivaSriDetalladosIva=true;
	public Boolean cargarid_tipo_retencion_ivaSriDetalladosIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencion_ivaSriDetalladosIva=false;//ConEventDepend=true

	public Border resaltartransfe_iva_retenidoSriDetalladosIva=null;
	public Boolean mostrartransfe_iva_retenidoSriDetalladosIva=true;
	public Boolean activartransfe_iva_retenidoSriDetalladosIva=true;

	public Border resaltarid_tipo_retencion_iva_prestaSriDetalladosIva=null;
	public Boolean mostrarid_tipo_retencion_iva_prestaSriDetalladosIva=true;
	public Boolean activarid_tipo_retencion_iva_prestaSriDetalladosIva=true;
	public Boolean cargarid_tipo_retencion_iva_prestaSriDetalladosIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencion_iva_prestaSriDetalladosIva=false;//ConEventDepend=true

	public Border resaltarpresta_iva_retenidoSriDetalladosIva=null;
	public Boolean mostrarpresta_iva_retenidoSriDetalladosIva=true;
	public Boolean activarpresta_iva_retenidoSriDetalladosIva=true;

	
	

	public Border setResaltaridSriDetalladosIva(ParametroGeneralUsuario parametroGeneralUsuario/*SriDetalladosIvaBeanSwingJInternalFrame sridetalladosivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sridetalladosivaBeanSwingJInternalFrame.jTtoolBarSriDetalladosIva.setBorder(borderResaltar);
		
		this.resaltaridSriDetalladosIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSriDetalladosIva() {
		return this.resaltaridSriDetalladosIva;
	}

	public void setResaltaridSriDetalladosIva(Border borderResaltar) {
		this.resaltaridSriDetalladosIva= borderResaltar;
	}

	public Boolean getMostraridSriDetalladosIva() {
		return this.mostraridSriDetalladosIva;
	}

	public void setMostraridSriDetalladosIva(Boolean mostraridSriDetalladosIva) {
		this.mostraridSriDetalladosIva= mostraridSriDetalladosIva;
	}

	public Boolean getActivaridSriDetalladosIva() {
		return this.activaridSriDetalladosIva;
	}

	public void setActivaridSriDetalladosIva(Boolean activaridSriDetalladosIva) {
		this.activaridSriDetalladosIva= activaridSriDetalladosIva;
	}

	public Border setResaltarid_periodo_declaraSriDetalladosIva(ParametroGeneralUsuario parametroGeneralUsuario/*SriDetalladosIvaBeanSwingJInternalFrame sridetalladosivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sridetalladosivaBeanSwingJInternalFrame.jTtoolBarSriDetalladosIva.setBorder(borderResaltar);
		
		this.resaltarid_periodo_declaraSriDetalladosIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodo_declaraSriDetalladosIva() {
		return this.resaltarid_periodo_declaraSriDetalladosIva;
	}

	public void setResaltarid_periodo_declaraSriDetalladosIva(Border borderResaltar) {
		this.resaltarid_periodo_declaraSriDetalladosIva= borderResaltar;
	}

	public Boolean getMostrarid_periodo_declaraSriDetalladosIva() {
		return this.mostrarid_periodo_declaraSriDetalladosIva;
	}

	public void setMostrarid_periodo_declaraSriDetalladosIva(Boolean mostrarid_periodo_declaraSriDetalladosIva) {
		this.mostrarid_periodo_declaraSriDetalladosIva= mostrarid_periodo_declaraSriDetalladosIva;
	}

	public Boolean getActivarid_periodo_declaraSriDetalladosIva() {
		return this.activarid_periodo_declaraSriDetalladosIva;
	}

	public void setActivarid_periodo_declaraSriDetalladosIva(Boolean activarid_periodo_declaraSriDetalladosIva) {
		this.activarid_periodo_declaraSriDetalladosIva= activarid_periodo_declaraSriDetalladosIva;
	}

	public Boolean getCargarid_periodo_declaraSriDetalladosIva() {
		return this.cargarid_periodo_declaraSriDetalladosIva;
	}

	public void setCargarid_periodo_declaraSriDetalladosIva(Boolean cargarid_periodo_declaraSriDetalladosIva) {
		this.cargarid_periodo_declaraSriDetalladosIva= cargarid_periodo_declaraSriDetalladosIva;
	}

	public Border setResaltarid_tipo_comprobanteSriDetalladosIva(ParametroGeneralUsuario parametroGeneralUsuario/*SriDetalladosIvaBeanSwingJInternalFrame sridetalladosivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sridetalladosivaBeanSwingJInternalFrame.jTtoolBarSriDetalladosIva.setBorder(borderResaltar);
		
		this.resaltarid_tipo_comprobanteSriDetalladosIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_comprobanteSriDetalladosIva() {
		return this.resaltarid_tipo_comprobanteSriDetalladosIva;
	}

	public void setResaltarid_tipo_comprobanteSriDetalladosIva(Border borderResaltar) {
		this.resaltarid_tipo_comprobanteSriDetalladosIva= borderResaltar;
	}

	public Boolean getMostrarid_tipo_comprobanteSriDetalladosIva() {
		return this.mostrarid_tipo_comprobanteSriDetalladosIva;
	}

	public void setMostrarid_tipo_comprobanteSriDetalladosIva(Boolean mostrarid_tipo_comprobanteSriDetalladosIva) {
		this.mostrarid_tipo_comprobanteSriDetalladosIva= mostrarid_tipo_comprobanteSriDetalladosIva;
	}

	public Boolean getActivarid_tipo_comprobanteSriDetalladosIva() {
		return this.activarid_tipo_comprobanteSriDetalladosIva;
	}

	public void setActivarid_tipo_comprobanteSriDetalladosIva(Boolean activarid_tipo_comprobanteSriDetalladosIva) {
		this.activarid_tipo_comprobanteSriDetalladosIva= activarid_tipo_comprobanteSriDetalladosIva;
	}

	public Boolean getCargarid_tipo_comprobanteSriDetalladosIva() {
		return this.cargarid_tipo_comprobanteSriDetalladosIva;
	}

	public void setCargarid_tipo_comprobanteSriDetalladosIva(Boolean cargarid_tipo_comprobanteSriDetalladosIva) {
		this.cargarid_tipo_comprobanteSriDetalladosIva= cargarid_tipo_comprobanteSriDetalladosIva;
	}

	public Border setResaltarrucSriDetalladosIva(ParametroGeneralUsuario parametroGeneralUsuario/*SriDetalladosIvaBeanSwingJInternalFrame sridetalladosivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sridetalladosivaBeanSwingJInternalFrame.jTtoolBarSriDetalladosIva.setBorder(borderResaltar);
		
		this.resaltarrucSriDetalladosIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucSriDetalladosIva() {
		return this.resaltarrucSriDetalladosIva;
	}

	public void setResaltarrucSriDetalladosIva(Border borderResaltar) {
		this.resaltarrucSriDetalladosIva= borderResaltar;
	}

	public Boolean getMostrarrucSriDetalladosIva() {
		return this.mostrarrucSriDetalladosIva;
	}

	public void setMostrarrucSriDetalladosIva(Boolean mostrarrucSriDetalladosIva) {
		this.mostrarrucSriDetalladosIva= mostrarrucSriDetalladosIva;
	}

	public Boolean getActivarrucSriDetalladosIva() {
		return this.activarrucSriDetalladosIva;
	}

	public void setActivarrucSriDetalladosIva(Boolean activarrucSriDetalladosIva) {
		this.activarrucSriDetalladosIva= activarrucSriDetalladosIva;
	}

	public Border setResaltarnombre_tipo_comprobanteSriDetalladosIva(ParametroGeneralUsuario parametroGeneralUsuario/*SriDetalladosIvaBeanSwingJInternalFrame sridetalladosivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sridetalladosivaBeanSwingJInternalFrame.jTtoolBarSriDetalladosIva.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_comprobanteSriDetalladosIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_comprobanteSriDetalladosIva() {
		return this.resaltarnombre_tipo_comprobanteSriDetalladosIva;
	}

	public void setResaltarnombre_tipo_comprobanteSriDetalladosIva(Border borderResaltar) {
		this.resaltarnombre_tipo_comprobanteSriDetalladosIva= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_comprobanteSriDetalladosIva() {
		return this.mostrarnombre_tipo_comprobanteSriDetalladosIva;
	}

	public void setMostrarnombre_tipo_comprobanteSriDetalladosIva(Boolean mostrarnombre_tipo_comprobanteSriDetalladosIva) {
		this.mostrarnombre_tipo_comprobanteSriDetalladosIva= mostrarnombre_tipo_comprobanteSriDetalladosIva;
	}

	public Boolean getActivarnombre_tipo_comprobanteSriDetalladosIva() {
		return this.activarnombre_tipo_comprobanteSriDetalladosIva;
	}

	public void setActivarnombre_tipo_comprobanteSriDetalladosIva(Boolean activarnombre_tipo_comprobanteSriDetalladosIva) {
		this.activarnombre_tipo_comprobanteSriDetalladosIva= activarnombre_tipo_comprobanteSriDetalladosIva;
	}

	public Border setResaltarruc_datoSriDetalladosIva(ParametroGeneralUsuario parametroGeneralUsuario/*SriDetalladosIvaBeanSwingJInternalFrame sridetalladosivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sridetalladosivaBeanSwingJInternalFrame.jTtoolBarSriDetalladosIva.setBorder(borderResaltar);
		
		this.resaltarruc_datoSriDetalladosIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarruc_datoSriDetalladosIva() {
		return this.resaltarruc_datoSriDetalladosIva;
	}

	public void setResaltarruc_datoSriDetalladosIva(Border borderResaltar) {
		this.resaltarruc_datoSriDetalladosIva= borderResaltar;
	}

	public Boolean getMostrarruc_datoSriDetalladosIva() {
		return this.mostrarruc_datoSriDetalladosIva;
	}

	public void setMostrarruc_datoSriDetalladosIva(Boolean mostrarruc_datoSriDetalladosIva) {
		this.mostrarruc_datoSriDetalladosIva= mostrarruc_datoSriDetalladosIva;
	}

	public Boolean getActivarruc_datoSriDetalladosIva() {
		return this.activarruc_datoSriDetalladosIva;
	}

	public void setActivarruc_datoSriDetalladosIva(Boolean activarruc_datoSriDetalladosIva) {
		this.activarruc_datoSriDetalladosIva= activarruc_datoSriDetalladosIva;
	}

	public Border setResaltarnumero_documentoSriDetalladosIva(ParametroGeneralUsuario parametroGeneralUsuario/*SriDetalladosIvaBeanSwingJInternalFrame sridetalladosivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sridetalladosivaBeanSwingJInternalFrame.jTtoolBarSriDetalladosIva.setBorder(borderResaltar);
		
		this.resaltarnumero_documentoSriDetalladosIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_documentoSriDetalladosIva() {
		return this.resaltarnumero_documentoSriDetalladosIva;
	}

	public void setResaltarnumero_documentoSriDetalladosIva(Border borderResaltar) {
		this.resaltarnumero_documentoSriDetalladosIva= borderResaltar;
	}

	public Boolean getMostrarnumero_documentoSriDetalladosIva() {
		return this.mostrarnumero_documentoSriDetalladosIva;
	}

	public void setMostrarnumero_documentoSriDetalladosIva(Boolean mostrarnumero_documentoSriDetalladosIva) {
		this.mostrarnumero_documentoSriDetalladosIva= mostrarnumero_documentoSriDetalladosIva;
	}

	public Boolean getActivarnumero_documentoSriDetalladosIva() {
		return this.activarnumero_documentoSriDetalladosIva;
	}

	public void setActivarnumero_documentoSriDetalladosIva(Boolean activarnumero_documentoSriDetalladosIva) {
		this.activarnumero_documentoSriDetalladosIva= activarnumero_documentoSriDetalladosIva;
	}

	public Border setResaltarfecha_emisionSriDetalladosIva(ParametroGeneralUsuario parametroGeneralUsuario/*SriDetalladosIvaBeanSwingJInternalFrame sridetalladosivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sridetalladosivaBeanSwingJInternalFrame.jTtoolBarSriDetalladosIva.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionSriDetalladosIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionSriDetalladosIva() {
		return this.resaltarfecha_emisionSriDetalladosIva;
	}

	public void setResaltarfecha_emisionSriDetalladosIva(Border borderResaltar) {
		this.resaltarfecha_emisionSriDetalladosIva= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionSriDetalladosIva() {
		return this.mostrarfecha_emisionSriDetalladosIva;
	}

	public void setMostrarfecha_emisionSriDetalladosIva(Boolean mostrarfecha_emisionSriDetalladosIva) {
		this.mostrarfecha_emisionSriDetalladosIva= mostrarfecha_emisionSriDetalladosIva;
	}

	public Boolean getActivarfecha_emisionSriDetalladosIva() {
		return this.activarfecha_emisionSriDetalladosIva;
	}

	public void setActivarfecha_emisionSriDetalladosIva(Boolean activarfecha_emisionSriDetalladosIva) {
		this.activarfecha_emisionSriDetalladosIva= activarfecha_emisionSriDetalladosIva;
	}

	public Border setResaltarfecha_registro_contableSriDetalladosIva(ParametroGeneralUsuario parametroGeneralUsuario/*SriDetalladosIvaBeanSwingJInternalFrame sridetalladosivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sridetalladosivaBeanSwingJInternalFrame.jTtoolBarSriDetalladosIva.setBorder(borderResaltar);
		
		this.resaltarfecha_registro_contableSriDetalladosIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_registro_contableSriDetalladosIva() {
		return this.resaltarfecha_registro_contableSriDetalladosIva;
	}

	public void setResaltarfecha_registro_contableSriDetalladosIva(Border borderResaltar) {
		this.resaltarfecha_registro_contableSriDetalladosIva= borderResaltar;
	}

	public Boolean getMostrarfecha_registro_contableSriDetalladosIva() {
		return this.mostrarfecha_registro_contableSriDetalladosIva;
	}

	public void setMostrarfecha_registro_contableSriDetalladosIva(Boolean mostrarfecha_registro_contableSriDetalladosIva) {
		this.mostrarfecha_registro_contableSriDetalladosIva= mostrarfecha_registro_contableSriDetalladosIva;
	}

	public Boolean getActivarfecha_registro_contableSriDetalladosIva() {
		return this.activarfecha_registro_contableSriDetalladosIva;
	}

	public void setActivarfecha_registro_contableSriDetalladosIva(Boolean activarfecha_registro_contableSriDetalladosIva) {
		this.activarfecha_registro_contableSriDetalladosIva= activarfecha_registro_contableSriDetalladosIva;
	}

	public Border setResaltarnumero_serieSriDetalladosIva(ParametroGeneralUsuario parametroGeneralUsuario/*SriDetalladosIvaBeanSwingJInternalFrame sridetalladosivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sridetalladosivaBeanSwingJInternalFrame.jTtoolBarSriDetalladosIva.setBorder(borderResaltar);
		
		this.resaltarnumero_serieSriDetalladosIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_serieSriDetalladosIva() {
		return this.resaltarnumero_serieSriDetalladosIva;
	}

	public void setResaltarnumero_serieSriDetalladosIva(Border borderResaltar) {
		this.resaltarnumero_serieSriDetalladosIva= borderResaltar;
	}

	public Boolean getMostrarnumero_serieSriDetalladosIva() {
		return this.mostrarnumero_serieSriDetalladosIva;
	}

	public void setMostrarnumero_serieSriDetalladosIva(Boolean mostrarnumero_serieSriDetalladosIva) {
		this.mostrarnumero_serieSriDetalladosIva= mostrarnumero_serieSriDetalladosIva;
	}

	public Boolean getActivarnumero_serieSriDetalladosIva() {
		return this.activarnumero_serieSriDetalladosIva;
	}

	public void setActivarnumero_serieSriDetalladosIva(Boolean activarnumero_serieSriDetalladosIva) {
		this.activarnumero_serieSriDetalladosIva= activarnumero_serieSriDetalladosIva;
	}

	public Border setResaltartotal_ivaSriDetalladosIva(ParametroGeneralUsuario parametroGeneralUsuario/*SriDetalladosIvaBeanSwingJInternalFrame sridetalladosivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sridetalladosivaBeanSwingJInternalFrame.jTtoolBarSriDetalladosIva.setBorder(borderResaltar);
		
		this.resaltartotal_ivaSriDetalladosIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ivaSriDetalladosIva() {
		return this.resaltartotal_ivaSriDetalladosIva;
	}

	public void setResaltartotal_ivaSriDetalladosIva(Border borderResaltar) {
		this.resaltartotal_ivaSriDetalladosIva= borderResaltar;
	}

	public Boolean getMostrartotal_ivaSriDetalladosIva() {
		return this.mostrartotal_ivaSriDetalladosIva;
	}

	public void setMostrartotal_ivaSriDetalladosIva(Boolean mostrartotal_ivaSriDetalladosIva) {
		this.mostrartotal_ivaSriDetalladosIva= mostrartotal_ivaSriDetalladosIva;
	}

	public Boolean getActivartotal_ivaSriDetalladosIva() {
		return this.activartotal_ivaSriDetalladosIva;
	}

	public void setActivartotal_ivaSriDetalladosIva(Boolean activartotal_ivaSriDetalladosIva) {
		this.activartotal_ivaSriDetalladosIva= activartotal_ivaSriDetalladosIva;
	}

	public Border setResaltartotal_sin_ivaSriDetalladosIva(ParametroGeneralUsuario parametroGeneralUsuario/*SriDetalladosIvaBeanSwingJInternalFrame sridetalladosivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sridetalladosivaBeanSwingJInternalFrame.jTtoolBarSriDetalladosIva.setBorder(borderResaltar);
		
		this.resaltartotal_sin_ivaSriDetalladosIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_sin_ivaSriDetalladosIva() {
		return this.resaltartotal_sin_ivaSriDetalladosIva;
	}

	public void setResaltartotal_sin_ivaSriDetalladosIva(Border borderResaltar) {
		this.resaltartotal_sin_ivaSriDetalladosIva= borderResaltar;
	}

	public Boolean getMostrartotal_sin_ivaSriDetalladosIva() {
		return this.mostrartotal_sin_ivaSriDetalladosIva;
	}

	public void setMostrartotal_sin_ivaSriDetalladosIva(Boolean mostrartotal_sin_ivaSriDetalladosIva) {
		this.mostrartotal_sin_ivaSriDetalladosIva= mostrartotal_sin_ivaSriDetalladosIva;
	}

	public Boolean getActivartotal_sin_ivaSriDetalladosIva() {
		return this.activartotal_sin_ivaSriDetalladosIva;
	}

	public void setActivartotal_sin_ivaSriDetalladosIva(Boolean activartotal_sin_ivaSriDetalladosIva) {
		this.activartotal_sin_ivaSriDetalladosIva= activartotal_sin_ivaSriDetalladosIva;
	}

	public Border setResaltarid_tipo_ivaSriDetalladosIva(ParametroGeneralUsuario parametroGeneralUsuario/*SriDetalladosIvaBeanSwingJInternalFrame sridetalladosivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sridetalladosivaBeanSwingJInternalFrame.jTtoolBarSriDetalladosIva.setBorder(borderResaltar);
		
		this.resaltarid_tipo_ivaSriDetalladosIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_ivaSriDetalladosIva() {
		return this.resaltarid_tipo_ivaSriDetalladosIva;
	}

	public void setResaltarid_tipo_ivaSriDetalladosIva(Border borderResaltar) {
		this.resaltarid_tipo_ivaSriDetalladosIva= borderResaltar;
	}

	public Boolean getMostrarid_tipo_ivaSriDetalladosIva() {
		return this.mostrarid_tipo_ivaSriDetalladosIva;
	}

	public void setMostrarid_tipo_ivaSriDetalladosIva(Boolean mostrarid_tipo_ivaSriDetalladosIva) {
		this.mostrarid_tipo_ivaSriDetalladosIva= mostrarid_tipo_ivaSriDetalladosIva;
	}

	public Boolean getActivarid_tipo_ivaSriDetalladosIva() {
		return this.activarid_tipo_ivaSriDetalladosIva;
	}

	public void setActivarid_tipo_ivaSriDetalladosIva(Boolean activarid_tipo_ivaSriDetalladosIva) {
		this.activarid_tipo_ivaSriDetalladosIva= activarid_tipo_ivaSriDetalladosIva;
	}

	public Boolean getCargarid_tipo_ivaSriDetalladosIva() {
		return this.cargarid_tipo_ivaSriDetalladosIva;
	}

	public void setCargarid_tipo_ivaSriDetalladosIva(Boolean cargarid_tipo_ivaSriDetalladosIva) {
		this.cargarid_tipo_ivaSriDetalladosIva= cargarid_tipo_ivaSriDetalladosIva;
	}

	public Border setResaltarid_tipo_retencion_ivaSriDetalladosIva(ParametroGeneralUsuario parametroGeneralUsuario/*SriDetalladosIvaBeanSwingJInternalFrame sridetalladosivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sridetalladosivaBeanSwingJInternalFrame.jTtoolBarSriDetalladosIva.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencion_ivaSriDetalladosIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencion_ivaSriDetalladosIva() {
		return this.resaltarid_tipo_retencion_ivaSriDetalladosIva;
	}

	public void setResaltarid_tipo_retencion_ivaSriDetalladosIva(Border borderResaltar) {
		this.resaltarid_tipo_retencion_ivaSriDetalladosIva= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencion_ivaSriDetalladosIva() {
		return this.mostrarid_tipo_retencion_ivaSriDetalladosIva;
	}

	public void setMostrarid_tipo_retencion_ivaSriDetalladosIva(Boolean mostrarid_tipo_retencion_ivaSriDetalladosIva) {
		this.mostrarid_tipo_retencion_ivaSriDetalladosIva= mostrarid_tipo_retencion_ivaSriDetalladosIva;
	}

	public Boolean getActivarid_tipo_retencion_ivaSriDetalladosIva() {
		return this.activarid_tipo_retencion_ivaSriDetalladosIva;
	}

	public void setActivarid_tipo_retencion_ivaSriDetalladosIva(Boolean activarid_tipo_retencion_ivaSriDetalladosIva) {
		this.activarid_tipo_retencion_ivaSriDetalladosIva= activarid_tipo_retencion_ivaSriDetalladosIva;
	}

	public Boolean getCargarid_tipo_retencion_ivaSriDetalladosIva() {
		return this.cargarid_tipo_retencion_ivaSriDetalladosIva;
	}

	public void setCargarid_tipo_retencion_ivaSriDetalladosIva(Boolean cargarid_tipo_retencion_ivaSriDetalladosIva) {
		this.cargarid_tipo_retencion_ivaSriDetalladosIva= cargarid_tipo_retencion_ivaSriDetalladosIva;
	}

	public Border setResaltartransfe_iva_retenidoSriDetalladosIva(ParametroGeneralUsuario parametroGeneralUsuario/*SriDetalladosIvaBeanSwingJInternalFrame sridetalladosivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sridetalladosivaBeanSwingJInternalFrame.jTtoolBarSriDetalladosIva.setBorder(borderResaltar);
		
		this.resaltartransfe_iva_retenidoSriDetalladosIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartransfe_iva_retenidoSriDetalladosIva() {
		return this.resaltartransfe_iva_retenidoSriDetalladosIva;
	}

	public void setResaltartransfe_iva_retenidoSriDetalladosIva(Border borderResaltar) {
		this.resaltartransfe_iva_retenidoSriDetalladosIva= borderResaltar;
	}

	public Boolean getMostrartransfe_iva_retenidoSriDetalladosIva() {
		return this.mostrartransfe_iva_retenidoSriDetalladosIva;
	}

	public void setMostrartransfe_iva_retenidoSriDetalladosIva(Boolean mostrartransfe_iva_retenidoSriDetalladosIva) {
		this.mostrartransfe_iva_retenidoSriDetalladosIva= mostrartransfe_iva_retenidoSriDetalladosIva;
	}

	public Boolean getActivartransfe_iva_retenidoSriDetalladosIva() {
		return this.activartransfe_iva_retenidoSriDetalladosIva;
	}

	public void setActivartransfe_iva_retenidoSriDetalladosIva(Boolean activartransfe_iva_retenidoSriDetalladosIva) {
		this.activartransfe_iva_retenidoSriDetalladosIva= activartransfe_iva_retenidoSriDetalladosIva;
	}

	public Border setResaltarid_tipo_retencion_iva_prestaSriDetalladosIva(ParametroGeneralUsuario parametroGeneralUsuario/*SriDetalladosIvaBeanSwingJInternalFrame sridetalladosivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sridetalladosivaBeanSwingJInternalFrame.jTtoolBarSriDetalladosIva.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencion_iva_prestaSriDetalladosIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencion_iva_prestaSriDetalladosIva() {
		return this.resaltarid_tipo_retencion_iva_prestaSriDetalladosIva;
	}

	public void setResaltarid_tipo_retencion_iva_prestaSriDetalladosIva(Border borderResaltar) {
		this.resaltarid_tipo_retencion_iva_prestaSriDetalladosIva= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencion_iva_prestaSriDetalladosIva() {
		return this.mostrarid_tipo_retencion_iva_prestaSriDetalladosIva;
	}

	public void setMostrarid_tipo_retencion_iva_prestaSriDetalladosIva(Boolean mostrarid_tipo_retencion_iva_prestaSriDetalladosIva) {
		this.mostrarid_tipo_retencion_iva_prestaSriDetalladosIva= mostrarid_tipo_retencion_iva_prestaSriDetalladosIva;
	}

	public Boolean getActivarid_tipo_retencion_iva_prestaSriDetalladosIva() {
		return this.activarid_tipo_retencion_iva_prestaSriDetalladosIva;
	}

	public void setActivarid_tipo_retencion_iva_prestaSriDetalladosIva(Boolean activarid_tipo_retencion_iva_prestaSriDetalladosIva) {
		this.activarid_tipo_retencion_iva_prestaSriDetalladosIva= activarid_tipo_retencion_iva_prestaSriDetalladosIva;
	}

	public Boolean getCargarid_tipo_retencion_iva_prestaSriDetalladosIva() {
		return this.cargarid_tipo_retencion_iva_prestaSriDetalladosIva;
	}

	public void setCargarid_tipo_retencion_iva_prestaSriDetalladosIva(Boolean cargarid_tipo_retencion_iva_prestaSriDetalladosIva) {
		this.cargarid_tipo_retencion_iva_prestaSriDetalladosIva= cargarid_tipo_retencion_iva_prestaSriDetalladosIva;
	}

	public Border setResaltarpresta_iva_retenidoSriDetalladosIva(ParametroGeneralUsuario parametroGeneralUsuario/*SriDetalladosIvaBeanSwingJInternalFrame sridetalladosivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sridetalladosivaBeanSwingJInternalFrame.jTtoolBarSriDetalladosIva.setBorder(borderResaltar);
		
		this.resaltarpresta_iva_retenidoSriDetalladosIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpresta_iva_retenidoSriDetalladosIva() {
		return this.resaltarpresta_iva_retenidoSriDetalladosIva;
	}

	public void setResaltarpresta_iva_retenidoSriDetalladosIva(Border borderResaltar) {
		this.resaltarpresta_iva_retenidoSriDetalladosIva= borderResaltar;
	}

	public Boolean getMostrarpresta_iva_retenidoSriDetalladosIva() {
		return this.mostrarpresta_iva_retenidoSriDetalladosIva;
	}

	public void setMostrarpresta_iva_retenidoSriDetalladosIva(Boolean mostrarpresta_iva_retenidoSriDetalladosIva) {
		this.mostrarpresta_iva_retenidoSriDetalladosIva= mostrarpresta_iva_retenidoSriDetalladosIva;
	}

	public Boolean getActivarpresta_iva_retenidoSriDetalladosIva() {
		return this.activarpresta_iva_retenidoSriDetalladosIva;
	}

	public void setActivarpresta_iva_retenidoSriDetalladosIva(Boolean activarpresta_iva_retenidoSriDetalladosIva) {
		this.activarpresta_iva_retenidoSriDetalladosIva= activarpresta_iva_retenidoSriDetalladosIva;
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
		
		
		this.setMostraridSriDetalladosIva(esInicial);
		this.setMostrarid_periodo_declaraSriDetalladosIva(esInicial);
		this.setMostrarid_tipo_comprobanteSriDetalladosIva(esInicial);
		this.setMostrarrucSriDetalladosIva(esInicial);
		this.setMostrarnombre_tipo_comprobanteSriDetalladosIva(esInicial);
		this.setMostrarruc_datoSriDetalladosIva(esInicial);
		this.setMostrarnumero_documentoSriDetalladosIva(esInicial);
		this.setMostrarfecha_emisionSriDetalladosIva(esInicial);
		this.setMostrarfecha_registro_contableSriDetalladosIva(esInicial);
		this.setMostrarnumero_serieSriDetalladosIva(esInicial);
		this.setMostrartotal_ivaSriDetalladosIva(esInicial);
		this.setMostrartotal_sin_ivaSriDetalladosIva(esInicial);
		this.setMostrarid_tipo_ivaSriDetalladosIva(esInicial);
		this.setMostrarid_tipo_retencion_ivaSriDetalladosIva(esInicial);
		this.setMostrartransfe_iva_retenidoSriDetalladosIva(esInicial);
		this.setMostrarid_tipo_retencion_iva_prestaSriDetalladosIva(esInicial);
		this.setMostrarpresta_iva_retenidoSriDetalladosIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.ID)) {
				this.setMostraridSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.IDPERIODODECLARA)) {
				this.setMostrarid_periodo_declaraSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.IDTIPOCOMPROBANTE)) {
				this.setMostrarid_tipo_comprobanteSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.RUC)) {
				this.setMostrarrucSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.NOMBRETIPOCOMPROBANTE)) {
				this.setMostrarnombre_tipo_comprobanteSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.RUCDATO)) {
				this.setMostrarruc_datoSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.NUMERODOCUMENTO)) {
				this.setMostrarnumero_documentoSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.FECHAREGISTROCONTABLE)) {
				this.setMostrarfecha_registro_contableSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.NUMEROSERIE)) {
				this.setMostrarnumero_serieSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.TOTALIVA)) {
				this.setMostrartotal_ivaSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.TOTALSINIVA)) {
				this.setMostrartotal_sin_ivaSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.IDTIPOIVA)) {
				this.setMostrarid_tipo_ivaSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.IDTIPORETENCIONIVA)) {
				this.setMostrarid_tipo_retencion_ivaSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.TRANSFEIVARETENIDO)) {
				this.setMostrartransfe_iva_retenidoSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.IDTIPORETENCIONIVAPRESTA)) {
				this.setMostrarid_tipo_retencion_iva_prestaSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.PRESTAIVARETENIDO)) {
				this.setMostrarpresta_iva_retenidoSriDetalladosIva(esAsigna);
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
		
		
		this.setActivaridSriDetalladosIva(esInicial);
		this.setActivarid_periodo_declaraSriDetalladosIva(esInicial);
		this.setActivarid_tipo_comprobanteSriDetalladosIva(esInicial);
		this.setActivarrucSriDetalladosIva(esInicial);
		this.setActivarnombre_tipo_comprobanteSriDetalladosIva(esInicial);
		this.setActivarruc_datoSriDetalladosIva(esInicial);
		this.setActivarnumero_documentoSriDetalladosIva(esInicial);
		this.setActivarfecha_emisionSriDetalladosIva(esInicial);
		this.setActivarfecha_registro_contableSriDetalladosIva(esInicial);
		this.setActivarnumero_serieSriDetalladosIva(esInicial);
		this.setActivartotal_ivaSriDetalladosIva(esInicial);
		this.setActivartotal_sin_ivaSriDetalladosIva(esInicial);
		this.setActivarid_tipo_ivaSriDetalladosIva(esInicial);
		this.setActivarid_tipo_retencion_ivaSriDetalladosIva(esInicial);
		this.setActivartransfe_iva_retenidoSriDetalladosIva(esInicial);
		this.setActivarid_tipo_retencion_iva_prestaSriDetalladosIva(esInicial);
		this.setActivarpresta_iva_retenidoSriDetalladosIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.ID)) {
				this.setActivaridSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.IDPERIODODECLARA)) {
				this.setActivarid_periodo_declaraSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.IDTIPOCOMPROBANTE)) {
				this.setActivarid_tipo_comprobanteSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.RUC)) {
				this.setActivarrucSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.NOMBRETIPOCOMPROBANTE)) {
				this.setActivarnombre_tipo_comprobanteSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.RUCDATO)) {
				this.setActivarruc_datoSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.NUMERODOCUMENTO)) {
				this.setActivarnumero_documentoSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.FECHAREGISTROCONTABLE)) {
				this.setActivarfecha_registro_contableSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.NUMEROSERIE)) {
				this.setActivarnumero_serieSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.TOTALIVA)) {
				this.setActivartotal_ivaSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.TOTALSINIVA)) {
				this.setActivartotal_sin_ivaSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.IDTIPOIVA)) {
				this.setActivarid_tipo_ivaSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.IDTIPORETENCIONIVA)) {
				this.setActivarid_tipo_retencion_ivaSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.TRANSFEIVARETENIDO)) {
				this.setActivartransfe_iva_retenidoSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.IDTIPORETENCIONIVAPRESTA)) {
				this.setActivarid_tipo_retencion_iva_prestaSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.PRESTAIVARETENIDO)) {
				this.setActivarpresta_iva_retenidoSriDetalladosIva(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SriDetalladosIvaBeanSwingJInternalFrame sridetalladosivaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSriDetalladosIva(esInicial);
		this.setResaltarid_periodo_declaraSriDetalladosIva(esInicial);
		this.setResaltarid_tipo_comprobanteSriDetalladosIva(esInicial);
		this.setResaltarrucSriDetalladosIva(esInicial);
		this.setResaltarnombre_tipo_comprobanteSriDetalladosIva(esInicial);
		this.setResaltarruc_datoSriDetalladosIva(esInicial);
		this.setResaltarnumero_documentoSriDetalladosIva(esInicial);
		this.setResaltarfecha_emisionSriDetalladosIva(esInicial);
		this.setResaltarfecha_registro_contableSriDetalladosIva(esInicial);
		this.setResaltarnumero_serieSriDetalladosIva(esInicial);
		this.setResaltartotal_ivaSriDetalladosIva(esInicial);
		this.setResaltartotal_sin_ivaSriDetalladosIva(esInicial);
		this.setResaltarid_tipo_ivaSriDetalladosIva(esInicial);
		this.setResaltarid_tipo_retencion_ivaSriDetalladosIva(esInicial);
		this.setResaltartransfe_iva_retenidoSriDetalladosIva(esInicial);
		this.setResaltarid_tipo_retencion_iva_prestaSriDetalladosIva(esInicial);
		this.setResaltarpresta_iva_retenidoSriDetalladosIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.ID)) {
				this.setResaltaridSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.IDPERIODODECLARA)) {
				this.setResaltarid_periodo_declaraSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.IDTIPOCOMPROBANTE)) {
				this.setResaltarid_tipo_comprobanteSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.RUC)) {
				this.setResaltarrucSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.NOMBRETIPOCOMPROBANTE)) {
				this.setResaltarnombre_tipo_comprobanteSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.RUCDATO)) {
				this.setResaltarruc_datoSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.NUMERODOCUMENTO)) {
				this.setResaltarnumero_documentoSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.FECHAREGISTROCONTABLE)) {
				this.setResaltarfecha_registro_contableSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.NUMEROSERIE)) {
				this.setResaltarnumero_serieSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.TOTALIVA)) {
				this.setResaltartotal_ivaSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.TOTALSINIVA)) {
				this.setResaltartotal_sin_ivaSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.IDTIPOIVA)) {
				this.setResaltarid_tipo_ivaSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.IDTIPORETENCIONIVA)) {
				this.setResaltarid_tipo_retencion_ivaSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.TRANSFEIVARETENIDO)) {
				this.setResaltartransfe_iva_retenidoSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.IDTIPORETENCIONIVAPRESTA)) {
				this.setResaltarid_tipo_retencion_iva_prestaSriDetalladosIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriDetalladosIvaConstantesFunciones.PRESTAIVARETENIDO)) {
				this.setResaltarpresta_iva_retenidoSriDetalladosIva(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SriDetalladosIvaBeanSwingJInternalFrame sridetalladosivaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaSriDetalladosIvaSriDetalladosIva=true;

	public Boolean getMostrarBusquedaSriDetalladosIvaSriDetalladosIva() {
		return this.mostrarBusquedaSriDetalladosIvaSriDetalladosIva;
	}

	public void setMostrarBusquedaSriDetalladosIvaSriDetalladosIva(Boolean visibilidadResaltar) {
		this.mostrarBusquedaSriDetalladosIvaSriDetalladosIva= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaSriDetalladosIvaSriDetalladosIva=true;

	public Boolean getActivarBusquedaSriDetalladosIvaSriDetalladosIva() {
		return this.activarBusquedaSriDetalladosIvaSriDetalladosIva;
	}

	public void setActivarBusquedaSriDetalladosIvaSriDetalladosIva(Boolean habilitarResaltar) {
		this.activarBusquedaSriDetalladosIvaSriDetalladosIva= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaSriDetalladosIvaSriDetalladosIva=null;

	public Border getResaltarBusquedaSriDetalladosIvaSriDetalladosIva() {
		return this.resaltarBusquedaSriDetalladosIvaSriDetalladosIva;
	}

	public void setResaltarBusquedaSriDetalladosIvaSriDetalladosIva(Border borderResaltar) {
		this.resaltarBusquedaSriDetalladosIvaSriDetalladosIva= borderResaltar;
	}

	public void setResaltarBusquedaSriDetalladosIvaSriDetalladosIva(ParametroGeneralUsuario parametroGeneralUsuario/*SriDetalladosIvaBeanSwingJInternalFrame sridetalladosivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaSriDetalladosIvaSriDetalladosIva= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}