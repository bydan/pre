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
package com.bydan.erp.seguridad.util.report;

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

import com.bydan.erp.seguridad.resources.general.AuxiliarGeneral;

import com.bydan.erp.seguridad.util.report.ProcesoCambiarParametroGeneralConstantesFunciones;
import com.bydan.erp.seguridad.util.report.ProcesoCambiarParametroGeneralParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.report.ProcesoCambiarParametroGeneralParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProcesoCambiarParametroGeneralConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoCambiarParametroGeneral";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoCambiarParametroGeneral"+ProcesoCambiarParametroGeneralConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoCambiarParametroGeneralHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoCambiarParametroGeneralHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoCambiarParametroGeneralConstantesFunciones.SCHEMA+"_"+ProcesoCambiarParametroGeneralConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoCambiarParametroGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoCambiarParametroGeneralConstantesFunciones.SCHEMA+"_"+ProcesoCambiarParametroGeneralConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoCambiarParametroGeneralConstantesFunciones.SCHEMA+"_"+ProcesoCambiarParametroGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoCambiarParametroGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoCambiarParametroGeneralConstantesFunciones.SCHEMA+"_"+ProcesoCambiarParametroGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCambiarParametroGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoCambiarParametroGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCambiarParametroGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCambiarParametroGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoCambiarParametroGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCambiarParametroGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoCambiarParametroGeneralConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoCambiarParametroGeneralConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoCambiarParametroGeneralConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoCambiarParametroGeneralConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Cambiar Parametro Generales";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Cambiar Parametro General";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Cambiar Parametro General";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoCambiarParametroGeneral";
	public static final String OBJECTNAME="procesocambiarparametrogeneral";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="proceso_cambiar_parametro_general";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesocambiarparametrogeneral from "+ProcesoCambiarParametroGeneralConstantesFunciones.SPERSISTENCENAME+" procesocambiarparametrogeneral";
	public static String QUERYSELECTNATIVE="select "+ProcesoCambiarParametroGeneralConstantesFunciones.SCHEMA+"."+ProcesoCambiarParametroGeneralConstantesFunciones.TABLENAME+".id,"+ProcesoCambiarParametroGeneralConstantesFunciones.SCHEMA+"."+ProcesoCambiarParametroGeneralConstantesFunciones.TABLENAME+".version_row,"+ProcesoCambiarParametroGeneralConstantesFunciones.SCHEMA+"."+ProcesoCambiarParametroGeneralConstantesFunciones.TABLENAME+".id_tipo_visual,"+ProcesoCambiarParametroGeneralConstantesFunciones.SCHEMA+"."+ProcesoCambiarParametroGeneralConstantesFunciones.TABLENAME+".id_tipo_fondo,"+ProcesoCambiarParametroGeneralConstantesFunciones.SCHEMA+"."+ProcesoCambiarParametroGeneralConstantesFunciones.TABLENAME+".id_tipo_fondo_borde,"+ProcesoCambiarParametroGeneralConstantesFunciones.SCHEMA+"."+ProcesoCambiarParametroGeneralConstantesFunciones.TABLENAME+".id_tipo_fondo_control,"+ProcesoCambiarParametroGeneralConstantesFunciones.SCHEMA+"."+ProcesoCambiarParametroGeneralConstantesFunciones.TABLENAME+".id_tipo_tamanio_control,"+ProcesoCambiarParametroGeneralConstantesFunciones.SCHEMA+"."+ProcesoCambiarParametroGeneralConstantesFunciones.TABLENAME+".con_mensaje_confirmacion,"+ProcesoCambiarParametroGeneralConstantesFunciones.SCHEMA+"."+ProcesoCambiarParametroGeneralConstantesFunciones.TABLENAME+".con_botones_tool_bar,"+ProcesoCambiarParametroGeneralConstantesFunciones.SCHEMA+"."+ProcesoCambiarParametroGeneralConstantesFunciones.TABLENAME+".id_tipo_exportar,"+ProcesoCambiarParametroGeneralConstantesFunciones.SCHEMA+"."+ProcesoCambiarParametroGeneralConstantesFunciones.TABLENAME+".id_tipo_delimiter,"+ProcesoCambiarParametroGeneralConstantesFunciones.SCHEMA+"."+ProcesoCambiarParametroGeneralConstantesFunciones.TABLENAME+".con_exportar_cabecera,"+ProcesoCambiarParametroGeneralConstantesFunciones.SCHEMA+"."+ProcesoCambiarParametroGeneralConstantesFunciones.TABLENAME+".path_exportar from "+ProcesoCambiarParametroGeneralConstantesFunciones.SCHEMA+"."+ProcesoCambiarParametroGeneralConstantesFunciones.TABLENAME;//+" as "+ProcesoCambiarParametroGeneralConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDTIPOVISUAL= "id_tipo_visual";
    public static final String IDTIPOFONDO= "id_tipo_fondo";
    public static final String IDTIPOFONDOBORDE= "id_tipo_fondo_borde";
    public static final String IDTIPOFONDOCONTROL= "id_tipo_fondo_control";
    public static final String IDTIPOTAMANIOCONTROL= "id_tipo_tamanio_control";
    public static final String CONMENSAJECONFIRMACION= "con_mensaje_confirmacion";
    public static final String CONBOTONESTOOLBAR= "con_botones_tool_bar";
    public static final String IDTIPOEXPORTAR= "id_tipo_exportar";
    public static final String IDTIPODELIMITER= "id_tipo_delimiter";
    public static final String CONEXPORTARCABECERA= "con_exportar_cabecera";
    public static final String PATHEXPORTAR= "path_exportar";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDTIPOVISUAL= "Tipo Visual";
		public static final String LABEL_IDTIPOVISUAL_LOWER= "Tipo Visual";
    	public static final String LABEL_IDTIPOFONDO= "Tipo Fondo";
		public static final String LABEL_IDTIPOFONDO_LOWER= "Tipo Fondo";
    	public static final String LABEL_IDTIPOFONDOBORDE= "Tipo Fondo Borde";
		public static final String LABEL_IDTIPOFONDOBORDE_LOWER= "Tipo Fondo Borde";
    	public static final String LABEL_IDTIPOFONDOCONTROL= "Tipo Fondo Control";
		public static final String LABEL_IDTIPOFONDOCONTROL_LOWER= "Tipo Fondo Control";
    	public static final String LABEL_IDTIPOTAMANIOCONTROL= "Tipo Tamanio Control";
		public static final String LABEL_IDTIPOTAMANIOCONTROL_LOWER= "Tipo Tamanio Control";
    	public static final String LABEL_CONMENSAJECONFIRMACION= "Con Mensaje Confirmacion";
		public static final String LABEL_CONMENSAJECONFIRMACION_LOWER= "Con Mensaje Confirmacion";
    	public static final String LABEL_CONBOTONESTOOLBAR= "Con Botones Tool Bar";
		public static final String LABEL_CONBOTONESTOOLBAR_LOWER= "Con Botones Tool Bar";
    	public static final String LABEL_IDTIPOEXPORTAR= "Tipo Exportar";
		public static final String LABEL_IDTIPOEXPORTAR_LOWER= "Tipo Exportar";
    	public static final String LABEL_IDTIPODELIMITER= "Tipo Delimiter";
		public static final String LABEL_IDTIPODELIMITER_LOWER= "Tipo Delimiter";
    	public static final String LABEL_CONEXPORTARCABECERA= "Con Exportar Cabecera";
		public static final String LABEL_CONEXPORTARCABECERA_LOWER= "Con Exportar Cabecera";
    	public static final String LABEL_PATHEXPORTAR= "Path Exportar";
		public static final String LABEL_PATHEXPORTAR_LOWER= "Path Exportar";
	
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXPATH_EXPORTAR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPATH_EXPORTAR=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProcesoCambiarParametroGeneralLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOVISUAL)) {sLabelColumna=ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOVISUAL;}
		if(sNombreColumna.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOFONDO)) {sLabelColumna=ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOFONDO;}
		if(sNombreColumna.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOFONDOBORDE)) {sLabelColumna=ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOFONDOBORDE;}
		if(sNombreColumna.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOFONDOCONTROL)) {sLabelColumna=ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOFONDOCONTROL;}
		if(sNombreColumna.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOTAMANIOCONTROL)) {sLabelColumna=ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOTAMANIOCONTROL;}
		if(sNombreColumna.equals(ProcesoCambiarParametroGeneralConstantesFunciones.CONMENSAJECONFIRMACION)) {sLabelColumna=ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_CONMENSAJECONFIRMACION;}
		if(sNombreColumna.equals(ProcesoCambiarParametroGeneralConstantesFunciones.CONBOTONESTOOLBAR)) {sLabelColumna=ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_CONBOTONESTOOLBAR;}
		if(sNombreColumna.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOEXPORTAR)) {sLabelColumna=ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOEXPORTAR;}
		if(sNombreColumna.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPODELIMITER)) {sLabelColumna=ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPODELIMITER;}
		if(sNombreColumna.equals(ProcesoCambiarParametroGeneralConstantesFunciones.CONEXPORTARCABECERA)) {sLabelColumna=ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_CONEXPORTARCABECERA;}
		if(sNombreColumna.equals(ProcesoCambiarParametroGeneralConstantesFunciones.PATHEXPORTAR)) {sLabelColumna=ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_PATHEXPORTAR;}
		
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
	
	
	
			
			
			
			
			
			
			
		
	public static String getcon_mensaje_confirmacionDescripcion(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!procesocambiarparametrogeneral.getcon_mensaje_confirmacion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_mensaje_confirmacionHtmlDescripcion(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(procesocambiarparametrogeneral.getId(),procesocambiarparametrogeneral.getcon_mensaje_confirmacion());

		return sDescripcion;
	}	
		
	public static String getcon_botones_tool_barDescripcion(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!procesocambiarparametrogeneral.getcon_botones_tool_bar()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_botones_tool_barHtmlDescripcion(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(procesocambiarparametrogeneral.getId(),procesocambiarparametrogeneral.getcon_botones_tool_bar());

		return sDescripcion;
	}	
			
			
		
	public static String getcon_exportar_cabeceraDescripcion(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!procesocambiarparametrogeneral.getcon_exportar_cabecera()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_exportar_cabeceraHtmlDescripcion(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(procesocambiarparametrogeneral.getId(),procesocambiarparametrogeneral.getcon_exportar_cabecera());

		return sDescripcion;
	}	
			
	
	public static String getProcesoCambiarParametroGeneralDescripcion(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesocambiarparametrogeneral !=null/* && procesocambiarparametrogeneral.getId()!=0*/) {
			if(procesocambiarparametrogeneral.getId()!=null) {
				sDescripcion=procesocambiarparametrogeneral.getId().toString();
			}//procesocambiarparametrogeneralprocesocambiarparametrogeneral.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoCambiarParametroGeneralDescripcionDetallado(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoCambiarParametroGeneralConstantesFunciones.ID+"=";
		sDescripcion+=procesocambiarparametrogeneral.getId().toString()+",";
		sDescripcion+=ProcesoCambiarParametroGeneralConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesocambiarparametrogeneral.getVersionRow().toString()+",";
		sDescripcion+=ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOVISUAL+"=";
		sDescripcion+=procesocambiarparametrogeneral.getid_tipo_visual().toString()+",";
		sDescripcion+=ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOFONDO+"=";
		sDescripcion+=procesocambiarparametrogeneral.getid_tipo_fondo().toString()+",";
		sDescripcion+=ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOFONDOBORDE+"=";
		sDescripcion+=procesocambiarparametrogeneral.getid_tipo_fondo_borde().toString()+",";
		sDescripcion+=ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOFONDOCONTROL+"=";
		sDescripcion+=procesocambiarparametrogeneral.getid_tipo_fondo_control().toString()+",";
		sDescripcion+=ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOTAMANIOCONTROL+"=";
		sDescripcion+=procesocambiarparametrogeneral.getid_tipo_tamanio_control().toString()+",";
		sDescripcion+=ProcesoCambiarParametroGeneralConstantesFunciones.CONMENSAJECONFIRMACION+"=";
		sDescripcion+=procesocambiarparametrogeneral.getcon_mensaje_confirmacion().toString()+",";
		sDescripcion+=ProcesoCambiarParametroGeneralConstantesFunciones.CONBOTONESTOOLBAR+"=";
		sDescripcion+=procesocambiarparametrogeneral.getcon_botones_tool_bar().toString()+",";
		sDescripcion+=ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOEXPORTAR+"=";
		sDescripcion+=procesocambiarparametrogeneral.getid_tipo_exportar().toString()+",";
		sDescripcion+=ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPODELIMITER+"=";
		sDescripcion+=procesocambiarparametrogeneral.getid_tipo_delimiter().toString()+",";
		sDescripcion+=ProcesoCambiarParametroGeneralConstantesFunciones.CONEXPORTARCABECERA+"=";
		sDescripcion+=procesocambiarparametrogeneral.getcon_exportar_cabecera().toString()+",";
		sDescripcion+=ProcesoCambiarParametroGeneralConstantesFunciones.PATHEXPORTAR+"=";
		sDescripcion+=procesocambiarparametrogeneral.getpath_exportar()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoCambiarParametroGeneralDescripcion(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral,String sValor) throws Exception {			
		if(procesocambiarparametrogeneral !=null) {
			//procesocambiarparametrogeneralprocesocambiarparametrogeneral.getId().toString();
		}		
	}
	
		

	public static String getTipoVisualDescripcion(TipoVisual tipovisual) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipovisual!=null/*&&tipovisual.getId()>0*/) {
			sDescripcion=TipoVisualConstantesFunciones.getTipoVisualDescripcion(tipovisual);
		}

		return sDescripcion;
	}

	public static String getTipoFondoDescripcion(TipoFondo tipofondo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipofondo!=null/*&&tipofondo.getId()>0*/) {
			sDescripcion=TipoFondoConstantesFunciones.getTipoFondoDescripcion(tipofondo);
		}

		return sDescripcion;
	}

	public static String getTipoFondoBordeDescripcion(TipoFondo tipofondo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipofondo!=null/*&&tipofondo.getId()>0*/) {
			sDescripcion=TipoFondoConstantesFunciones.getTipoFondoDescripcion(tipofondo);
		}

		return sDescripcion;
	}

	public static String getTipoFondoControlDescripcion(TipoFondoControl tipofondocontrol) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipofondocontrol!=null/*&&tipofondocontrol.getId()>0*/) {
			sDescripcion=TipoFondoControlConstantesFunciones.getTipoFondoControlDescripcion(tipofondocontrol);
		}

		return sDescripcion;
	}

	public static String getTipoTamanioControlDescripcion(TipoTamanioControl tipotamaniocontrol) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotamaniocontrol!=null/*&&tipotamaniocontrol.getId()>0*/) {
			sDescripcion=TipoTamanioControlConstantesFunciones.getTipoTamanioControlDescripcion(tipotamaniocontrol);
		}

		return sDescripcion;
	}

	public static String getTipoExportarDescripcion(TipoExportar tipoexportar) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoexportar!=null/*&&tipoexportar.getId()>0*/) {
			sDescripcion=TipoExportarConstantesFunciones.getTipoExportarDescripcion(tipoexportar);
		}

		return sDescripcion;
	}

	public static String getTipoDelimiterDescripcion(TipoDelimiter tipodelimiter) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodelimiter!=null/*&&tipodelimiter.getId()>0*/) {
			sDescripcion=TipoDelimiterConstantesFunciones.getTipoDelimiterDescripcion(tipodelimiter);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesoCambiarParametroGeneral")) {
			sNombreIndice="Tipo=  Por Tipo Visual Por Con Mensaje Confirmacion Por Con Botones Tool Bar Por Tipo Fondo Por Tipo Fondo Borde Por Tipo Fondo Control Por Tipo Tamanio Control Por Tipo Exportar Por Tipo Delimiter Por Con Exportar Cabecera Por Path Exportar";
		} else if(sNombreIndice.equals("FK_IdTipoDelimiter")) {
			sNombreIndice="Tipo=  Por Tipo Delimiter";
		} else if(sNombreIndice.equals("FK_IdTipoExportar")) {
			sNombreIndice="Tipo=  Por Tipo Exportar";
		} else if(sNombreIndice.equals("FK_IdTipoFondo")) {
			sNombreIndice="Tipo=  Por Tipo Fondo";
		} else if(sNombreIndice.equals("FK_IdTipoFondoBorde")) {
			sNombreIndice="Tipo=  Por Tipo Fondo Borde";
		} else if(sNombreIndice.equals("FK_IdTipoFondoControl")) {
			sNombreIndice="Tipo=  Por Tipo Fondo Control";
		} else if(sNombreIndice.equals("FK_IdTipoTamanioControl")) {
			sNombreIndice="Tipo=  Por Tipo Tamanio Control";
		} else if(sNombreIndice.equals("FK_IdTipoVisual")) {
			sNombreIndice="Tipo=  Por Tipo Visual";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesoCambiarParametroGeneral(Long id_tipo_visual,Boolean con_mensaje_confirmacion,Boolean con_botones_tool_bar,Long id_tipo_fondo,Long id_tipo_fondo_borde,Long id_tipo_fondo_control,Long id_tipo_tamanio_control,Long id_tipo_exportar,Long id_tipo_delimiter,Boolean con_exportar_cabecera,String path_exportar) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_visual!=null) {sDetalleIndice+=" Codigo Unico De Tipo Visual="+id_tipo_visual.toString();}
		if(con_mensaje_confirmacion!=null) {sDetalleIndice+=" Con Mensaje Confirmacion="+con_mensaje_confirmacion.toString();}
		if(con_botones_tool_bar!=null) {sDetalleIndice+=" Con Botones Tool Bar="+con_botones_tool_bar.toString();}
		if(id_tipo_fondo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Fondo="+id_tipo_fondo.toString();}
		if(id_tipo_fondo_borde!=null) {sDetalleIndice+=" Codigo Unico De Tipo Fondo Borde="+id_tipo_fondo_borde.toString();}
		if(id_tipo_fondo_control!=null) {sDetalleIndice+=" Codigo Unico De Tipo Fondo Control="+id_tipo_fondo_control.toString();}
		if(id_tipo_tamanio_control!=null) {sDetalleIndice+=" Codigo Unico De Tipo Tamanio Control="+id_tipo_tamanio_control.toString();}
		if(id_tipo_exportar!=null) {sDetalleIndice+=" Codigo Unico De Tipo Exportar="+id_tipo_exportar.toString();}
		if(id_tipo_delimiter!=null) {sDetalleIndice+=" Codigo Unico De Tipo Delimiter="+id_tipo_delimiter.toString();}
		if(con_exportar_cabecera!=null) {sDetalleIndice+=" Con Exportar Cabecera="+con_exportar_cabecera.toString();}
		if(path_exportar!=null) {sDetalleIndice+=" Path Exportar="+path_exportar;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDelimiter(Long id_tipo_delimiter) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_delimiter!=null) {sDetalleIndice+=" Codigo Unico De Tipo Delimiter="+id_tipo_delimiter.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoExportar(Long id_tipo_exportar) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_exportar!=null) {sDetalleIndice+=" Codigo Unico De Tipo Exportar="+id_tipo_exportar.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoFondo(Long id_tipo_fondo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_fondo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Fondo="+id_tipo_fondo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoFondoBorde(Long id_tipo_fondo_borde) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_fondo_borde!=null) {sDetalleIndice+=" Codigo Unico De Tipo Fondo Borde="+id_tipo_fondo_borde.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoFondoControl(Long id_tipo_fondo_control) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_fondo_control!=null) {sDetalleIndice+=" Codigo Unico De Tipo Fondo Control="+id_tipo_fondo_control.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTamanioControl(Long id_tipo_tamanio_control) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_tamanio_control!=null) {sDetalleIndice+=" Codigo Unico De Tipo Tamanio Control="+id_tipo_tamanio_control.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoVisual(Long id_tipo_visual) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_visual!=null) {sDetalleIndice+=" Codigo Unico De Tipo Visual="+id_tipo_visual.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoCambiarParametroGeneral(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		procesocambiarparametrogeneral.setpath_exportar(procesocambiarparametrogeneral.getpath_exportar().trim());
	}
	
	public static void quitarEspaciosProcesoCambiarParametroGenerals(List<ProcesoCambiarParametroGeneral> procesocambiarparametrogenerals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral: procesocambiarparametrogenerals) {
			procesocambiarparametrogeneral.setpath_exportar(procesocambiarparametrogeneral.getpath_exportar().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoCambiarParametroGeneral(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesocambiarparametrogeneral.getConCambioAuxiliar()) {
			procesocambiarparametrogeneral.setIsDeleted(procesocambiarparametrogeneral.getIsDeletedAuxiliar());	
			procesocambiarparametrogeneral.setIsNew(procesocambiarparametrogeneral.getIsNewAuxiliar());	
			procesocambiarparametrogeneral.setIsChanged(procesocambiarparametrogeneral.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesocambiarparametrogeneral.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesocambiarparametrogeneral.setIsDeletedAuxiliar(false);	
			procesocambiarparametrogeneral.setIsNewAuxiliar(false);	
			procesocambiarparametrogeneral.setIsChangedAuxiliar(false);
			
			procesocambiarparametrogeneral.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoCambiarParametroGenerals(List<ProcesoCambiarParametroGeneral> procesocambiarparametrogenerals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral : procesocambiarparametrogenerals) {
			if(conAsignarBase && procesocambiarparametrogeneral.getConCambioAuxiliar()) {
				procesocambiarparametrogeneral.setIsDeleted(procesocambiarparametrogeneral.getIsDeletedAuxiliar());	
				procesocambiarparametrogeneral.setIsNew(procesocambiarparametrogeneral.getIsNewAuxiliar());	
				procesocambiarparametrogeneral.setIsChanged(procesocambiarparametrogeneral.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesocambiarparametrogeneral.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesocambiarparametrogeneral.setIsDeletedAuxiliar(false);	
				procesocambiarparametrogeneral.setIsNewAuxiliar(false);	
				procesocambiarparametrogeneral.setIsChangedAuxiliar(false);
				
				procesocambiarparametrogeneral.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoCambiarParametroGeneral(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoCambiarParametroGenerals(List<ProcesoCambiarParametroGeneral> procesocambiarparametrogenerals,Boolean conEnteros) throws Exception  {
		
		for(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral: procesocambiarparametrogenerals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoCambiarParametroGeneral(List<ProcesoCambiarParametroGeneral> procesocambiarparametrogenerals,ProcesoCambiarParametroGeneral procesocambiarparametrogeneralAux) throws Exception  {
		ProcesoCambiarParametroGeneralConstantesFunciones.InicializarValoresProcesoCambiarParametroGeneral(procesocambiarparametrogeneralAux,true);
		
		for(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral: procesocambiarparametrogenerals) {
			if(procesocambiarparametrogeneral.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCambiarParametroGeneral(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoCambiarParametroGeneralConstantesFunciones.getArrayColumnasGlobalesProcesoCambiarParametroGeneral(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCambiarParametroGeneral(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoCambiarParametroGeneral(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoCambiarParametroGeneral> procesocambiarparametrogenerals,ProcesoCambiarParametroGeneral procesocambiarparametrogeneral,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoCambiarParametroGeneral procesocambiarparametrogeneralAux: procesocambiarparametrogenerals) {
			if(procesocambiarparametrogeneralAux!=null && procesocambiarparametrogeneral!=null) {
				if((procesocambiarparametrogeneralAux.getId()==null && procesocambiarparametrogeneral.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesocambiarparametrogeneralAux.getId()!=null && procesocambiarparametrogeneral.getId()!=null){
					if(procesocambiarparametrogeneralAux.getId().equals(procesocambiarparametrogeneral.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoCambiarParametroGeneral(List<ProcesoCambiarParametroGeneral> procesocambiarparametrogenerals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral: procesocambiarparametrogenerals) {			
			if(procesocambiarparametrogeneral.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoCambiarParametroGeneral() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoCambiarParametroGeneral() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCambiarParametroGeneral() throws Exception  {
		return ProcesoCambiarParametroGeneralConstantesFunciones.getTiposSeleccionarProcesoCambiarParametroGeneral(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCambiarParametroGeneral(Boolean conFk) throws Exception  {
		return ProcesoCambiarParametroGeneralConstantesFunciones.getTiposSeleccionarProcesoCambiarParametroGeneral(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCambiarParametroGeneral(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOVISUAL);
			reporte.setsDescripcion(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOVISUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOFONDO);
			reporte.setsDescripcion(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOFONDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOFONDOBORDE);
			reporte.setsDescripcion(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOFONDOBORDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOFONDOCONTROL);
			reporte.setsDescripcion(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOFONDOCONTROL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOTAMANIOCONTROL);
			reporte.setsDescripcion(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOTAMANIOCONTROL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_CONMENSAJECONFIRMACION);
			reporte.setsDescripcion(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_CONMENSAJECONFIRMACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_CONBOTONESTOOLBAR);
			reporte.setsDescripcion(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_CONBOTONESTOOLBAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOEXPORTAR);
			reporte.setsDescripcion(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOEXPORTAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPODELIMITER);
			reporte.setsDescripcion(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPODELIMITER);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_CONEXPORTARCABECERA);
			reporte.setsDescripcion(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_CONEXPORTARCABECERA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_PATHEXPORTAR);
			reporte.setsDescripcion(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_PATHEXPORTAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoCambiarParametroGeneral(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoCambiarParametroGeneral(ProcesoCambiarParametroGeneral procesocambiarparametrogeneralAux) throws Exception {
		
			procesocambiarparametrogeneralAux.settipovisual_descripcion(TipoVisualConstantesFunciones.getTipoVisualDescripcion(procesocambiarparametrogeneralAux.getTipoVisual()));
			procesocambiarparametrogeneralAux.settipofondo_descripcion(TipoFondoConstantesFunciones.getTipoFondoDescripcion(procesocambiarparametrogeneralAux.getTipoFondo()));
			procesocambiarparametrogeneralAux.settipofondoborde_descripcion(TipoFondoConstantesFunciones.getTipoFondoDescripcion(procesocambiarparametrogeneralAux.getTipoFondoBorde()));
			procesocambiarparametrogeneralAux.settipofondocontrol_descripcion(TipoFondoControlConstantesFunciones.getTipoFondoControlDescripcion(procesocambiarparametrogeneralAux.getTipoFondoControl()));
			procesocambiarparametrogeneralAux.settipotamaniocontrol_descripcion(TipoTamanioControlConstantesFunciones.getTipoTamanioControlDescripcion(procesocambiarparametrogeneralAux.getTipoTamanioControl()));
			procesocambiarparametrogeneralAux.settipoexportar_descripcion(TipoExportarConstantesFunciones.getTipoExportarDescripcion(procesocambiarparametrogeneralAux.getTipoExportar()));
			procesocambiarparametrogeneralAux.settipodelimiter_descripcion(TipoDelimiterConstantesFunciones.getTipoDelimiterDescripcion(procesocambiarparametrogeneralAux.getTipoDelimiter()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoCambiarParametroGeneral(List<ProcesoCambiarParametroGeneral> procesocambiarparametrogeneralsTemp) throws Exception {
		for(ProcesoCambiarParametroGeneral procesocambiarparametrogeneralAux:procesocambiarparametrogeneralsTemp) {
			
			procesocambiarparametrogeneralAux.settipovisual_descripcion(TipoVisualConstantesFunciones.getTipoVisualDescripcion(procesocambiarparametrogeneralAux.getTipoVisual()));
			procesocambiarparametrogeneralAux.settipofondo_descripcion(TipoFondoConstantesFunciones.getTipoFondoDescripcion(procesocambiarparametrogeneralAux.getTipoFondo()));
			procesocambiarparametrogeneralAux.settipofondoborde_descripcion(TipoFondoConstantesFunciones.getTipoFondoDescripcion(procesocambiarparametrogeneralAux.getTipoFondoBorde()));
			procesocambiarparametrogeneralAux.settipofondocontrol_descripcion(TipoFondoControlConstantesFunciones.getTipoFondoControlDescripcion(procesocambiarparametrogeneralAux.getTipoFondoControl()));
			procesocambiarparametrogeneralAux.settipotamaniocontrol_descripcion(TipoTamanioControlConstantesFunciones.getTipoTamanioControlDescripcion(procesocambiarparametrogeneralAux.getTipoTamanioControl()));
			procesocambiarparametrogeneralAux.settipoexportar_descripcion(TipoExportarConstantesFunciones.getTipoExportarDescripcion(procesocambiarparametrogeneralAux.getTipoExportar()));
			procesocambiarparametrogeneralAux.settipodelimiter_descripcion(TipoDelimiterConstantesFunciones.getTipoDelimiterDescripcion(procesocambiarparametrogeneralAux.getTipoDelimiter()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoCambiarParametroGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TipoVisual.class));
				classes.add(new Classe(TipoFondo.class));
				classes.add(new Classe(TipoFondo.class));
				classes.add(new Classe(TipoFondoControl.class));
				classes.add(new Classe(TipoTamanioControl.class));
				classes.add(new Classe(TipoExportar.class));
				classes.add(new Classe(TipoDelimiter.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoVisual.class)) {
						classes.add(new Classe(TipoVisual.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFondo.class)) {
						classes.add(new Classe(TipoFondo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFondo.class)) {
						classes.add(new Classe(TipoFondo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFondoControl.class)) {
						classes.add(new Classe(TipoFondoControl.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTamanioControl.class)) {
						classes.add(new Classe(TipoTamanioControl.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoExportar.class)) {
						classes.add(new Classe(TipoExportar.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDelimiter.class)) {
						classes.add(new Classe(TipoDelimiter.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoCambiarParametroGeneral(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoVisual.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoVisual.class)); continue;
					}

					if(TipoFondo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFondo.class)); continue;
					}

					if(TipoFondo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFondo.class)); continue;
					}

					if(TipoFondoControl.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFondoControl.class)); continue;
					}

					if(TipoTamanioControl.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTamanioControl.class)); continue;
					}

					if(TipoExportar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoExportar.class)); continue;
					}

					if(TipoDelimiter.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDelimiter.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoVisual.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoVisual.class)); continue;
					}

					if(TipoFondo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFondo.class)); continue;
					}

					if(TipoFondo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFondo.class)); continue;
					}

					if(TipoFondoControl.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFondoControl.class)); continue;
					}

					if(TipoTamanioControl.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTamanioControl.class)); continue;
					}

					if(TipoExportar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoExportar.class)); continue;
					}

					if(TipoDelimiter.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDelimiter.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoCambiarParametroGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoCambiarParametroGeneralConstantesFunciones.getClassesRelationshipsOfProcesoCambiarParametroGeneral(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoCambiarParametroGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoCambiarParametroGeneral(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoCambiarParametroGeneralConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoCambiarParametroGeneral(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoCambiarParametroGeneral(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral,List<ProcesoCambiarParametroGeneral> procesocambiarparametrogenerals,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral,List<ProcesoCambiarParametroGeneral> procesocambiarparametrogenerals) throws Exception {
		try	{			
			for(ProcesoCambiarParametroGeneral procesocambiarparametrogeneralLocal:procesocambiarparametrogenerals) {
				if(procesocambiarparametrogeneralLocal.getId().equals(procesocambiarparametrogeneral.getId())) {
					procesocambiarparametrogeneralLocal.setIsSelected(procesocambiarparametrogeneral.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoCambiarParametroGeneral(List<ProcesoCambiarParametroGeneral> procesocambiarparametrogeneralsAux) throws Exception {
		//this.procesocambiarparametrogeneralsAux=procesocambiarparametrogeneralsAux;
		
		for(ProcesoCambiarParametroGeneral procesocambiarparametrogeneralAux:procesocambiarparametrogeneralsAux) {
			if(procesocambiarparametrogeneralAux.getIsChanged()) {
				procesocambiarparametrogeneralAux.setIsChanged(false);
			}		
			
			if(procesocambiarparametrogeneralAux.getIsNew()) {
				procesocambiarparametrogeneralAux.setIsNew(false);
			}	
			
			if(procesocambiarparametrogeneralAux.getIsDeleted()) {
				procesocambiarparametrogeneralAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoCambiarParametroGeneral(ProcesoCambiarParametroGeneral procesocambiarparametrogeneralAux) throws Exception {
		//this.procesocambiarparametrogeneralAux=procesocambiarparametrogeneralAux;
		
			if(procesocambiarparametrogeneralAux.getIsChanged()) {
				procesocambiarparametrogeneralAux.setIsChanged(false);
			}		
			
			if(procesocambiarparametrogeneralAux.getIsNew()) {
				procesocambiarparametrogeneralAux.setIsNew(false);
			}	
			
			if(procesocambiarparametrogeneralAux.getIsDeleted()) {
				procesocambiarparametrogeneralAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoCambiarParametroGeneral procesocambiarparametrogeneralAsignar,ProcesoCambiarParametroGeneral procesocambiarparametrogeneral) throws Exception {
		procesocambiarparametrogeneralAsignar.setId(procesocambiarparametrogeneral.getId());	
		procesocambiarparametrogeneralAsignar.setVersionRow(procesocambiarparametrogeneral.getVersionRow());	
		procesocambiarparametrogeneralAsignar.setid_tipo_visual(procesocambiarparametrogeneral.getid_tipo_visual());
		procesocambiarparametrogeneralAsignar.settipovisual_descripcion(procesocambiarparametrogeneral.gettipovisual_descripcion());	
		procesocambiarparametrogeneralAsignar.setid_tipo_fondo(procesocambiarparametrogeneral.getid_tipo_fondo());
		procesocambiarparametrogeneralAsignar.settipofondo_descripcion(procesocambiarparametrogeneral.gettipofondo_descripcion());	
		procesocambiarparametrogeneralAsignar.setid_tipo_fondo_borde(procesocambiarparametrogeneral.getid_tipo_fondo_borde());
		procesocambiarparametrogeneralAsignar.settipofondoborde_descripcion(procesocambiarparametrogeneral.gettipofondoborde_descripcion());	
		procesocambiarparametrogeneralAsignar.setid_tipo_fondo_control(procesocambiarparametrogeneral.getid_tipo_fondo_control());
		procesocambiarparametrogeneralAsignar.settipofondocontrol_descripcion(procesocambiarparametrogeneral.gettipofondocontrol_descripcion());	
		procesocambiarparametrogeneralAsignar.setid_tipo_tamanio_control(procesocambiarparametrogeneral.getid_tipo_tamanio_control());
		procesocambiarparametrogeneralAsignar.settipotamaniocontrol_descripcion(procesocambiarparametrogeneral.gettipotamaniocontrol_descripcion());	
		procesocambiarparametrogeneralAsignar.setcon_mensaje_confirmacion(procesocambiarparametrogeneral.getcon_mensaje_confirmacion());	
		procesocambiarparametrogeneralAsignar.setcon_botones_tool_bar(procesocambiarparametrogeneral.getcon_botones_tool_bar());	
		procesocambiarparametrogeneralAsignar.setid_tipo_exportar(procesocambiarparametrogeneral.getid_tipo_exportar());
		procesocambiarparametrogeneralAsignar.settipoexportar_descripcion(procesocambiarparametrogeneral.gettipoexportar_descripcion());	
		procesocambiarparametrogeneralAsignar.setid_tipo_delimiter(procesocambiarparametrogeneral.getid_tipo_delimiter());
		procesocambiarparametrogeneralAsignar.settipodelimiter_descripcion(procesocambiarparametrogeneral.gettipodelimiter_descripcion());	
		procesocambiarparametrogeneralAsignar.setcon_exportar_cabecera(procesocambiarparametrogeneral.getcon_exportar_cabecera());	
		procesocambiarparametrogeneralAsignar.setpath_exportar(procesocambiarparametrogeneral.getpath_exportar());	
	}
	
	public static void inicializarProcesoCambiarParametroGeneral(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral) throws Exception {
		try {
				procesocambiarparametrogeneral.setId(0L);	
					
				procesocambiarparametrogeneral.setid_tipo_visual(-1L);	
				procesocambiarparametrogeneral.setid_tipo_fondo(-1L);	
				procesocambiarparametrogeneral.setid_tipo_fondo_borde(-1L);	
				procesocambiarparametrogeneral.setid_tipo_fondo_control(-1L);	
				procesocambiarparametrogeneral.setid_tipo_tamanio_control(-1L);	
				procesocambiarparametrogeneral.setcon_mensaje_confirmacion(false);	
				procesocambiarparametrogeneral.setcon_botones_tool_bar(false);	
				procesocambiarparametrogeneral.setid_tipo_exportar(-1L);	
				procesocambiarparametrogeneral.setid_tipo_delimiter(-1L);	
				procesocambiarparametrogeneral.setcon_exportar_cabecera(false);	
				procesocambiarparametrogeneral.setpath_exportar("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoCambiarParametroGeneral(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOVISUAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOFONDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOFONDOBORDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOFONDOCONTROL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOTAMANIOCONTROL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_CONMENSAJECONFIRMACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_CONBOTONESTOOLBAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPOEXPORTAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_IDTIPODELIMITER);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_CONEXPORTARCABECERA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCambiarParametroGeneralConstantesFunciones.LABEL_PATHEXPORTAR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoCambiarParametroGeneral(String sTipo,Row row,Workbook workbook,ProcesoCambiarParametroGeneral procesocambiarparametrogeneral,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocambiarparametrogeneral.gettipovisual_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocambiarparametrogeneral.gettipofondo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocambiarparametrogeneral.gettipofondoborde_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocambiarparametrogeneral.gettipofondocontrol_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocambiarparametrogeneral.gettipotamaniocontrol_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(procesocambiarparametrogeneral.getcon_mensaje_confirmacion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(procesocambiarparametrogeneral.getcon_botones_tool_bar()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocambiarparametrogeneral.gettipoexportar_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocambiarparametrogeneral.gettipodelimiter_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(procesocambiarparametrogeneral.getcon_exportar_cabecera()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocambiarparametrogeneral.getpath_exportar());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoCambiarParametroGeneral="";
	
	public String getsFinalQueryProcesoCambiarParametroGeneral() {
		return this.sFinalQueryProcesoCambiarParametroGeneral;
	}
	
	public void setsFinalQueryProcesoCambiarParametroGeneral(String sFinalQueryProcesoCambiarParametroGeneral) {
		this.sFinalQueryProcesoCambiarParametroGeneral= sFinalQueryProcesoCambiarParametroGeneral;
	}
	
	public Border resaltarSeleccionarProcesoCambiarParametroGeneral=null;
	
	public Border setResaltarSeleccionarProcesoCambiarParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarParametroGeneralBeanSwingJInternalFrame procesocambiarparametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesocambiarparametrogeneralBeanSwingJInternalFrame.jTtoolBarProcesoCambiarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoCambiarParametroGeneral= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoCambiarParametroGeneral() {
		return this.resaltarSeleccionarProcesoCambiarParametroGeneral;
	}
	
	public void setResaltarSeleccionarProcesoCambiarParametroGeneral(Border borderResaltarSeleccionarProcesoCambiarParametroGeneral) {
		this.resaltarSeleccionarProcesoCambiarParametroGeneral= borderResaltarSeleccionarProcesoCambiarParametroGeneral;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoCambiarParametroGeneral=null;
	public Boolean mostraridProcesoCambiarParametroGeneral=true;
	public Boolean activaridProcesoCambiarParametroGeneral=true;

	public Border resaltarid_tipo_visualProcesoCambiarParametroGeneral=null;
	public Boolean mostrarid_tipo_visualProcesoCambiarParametroGeneral=true;
	public Boolean activarid_tipo_visualProcesoCambiarParametroGeneral=true;
	public Boolean cargarid_tipo_visualProcesoCambiarParametroGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_visualProcesoCambiarParametroGeneral=false;//ConEventDepend=true

	public Border resaltarid_tipo_fondoProcesoCambiarParametroGeneral=null;
	public Boolean mostrarid_tipo_fondoProcesoCambiarParametroGeneral=true;
	public Boolean activarid_tipo_fondoProcesoCambiarParametroGeneral=true;
	public Boolean cargarid_tipo_fondoProcesoCambiarParametroGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_fondoProcesoCambiarParametroGeneral=false;//ConEventDepend=true

	public Border resaltarid_tipo_fondo_bordeProcesoCambiarParametroGeneral=null;
	public Boolean mostrarid_tipo_fondo_bordeProcesoCambiarParametroGeneral=true;
	public Boolean activarid_tipo_fondo_bordeProcesoCambiarParametroGeneral=true;
	public Boolean cargarid_tipo_fondo_bordeProcesoCambiarParametroGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_fondo_bordeProcesoCambiarParametroGeneral=false;//ConEventDepend=true

	public Border resaltarid_tipo_fondo_controlProcesoCambiarParametroGeneral=null;
	public Boolean mostrarid_tipo_fondo_controlProcesoCambiarParametroGeneral=true;
	public Boolean activarid_tipo_fondo_controlProcesoCambiarParametroGeneral=true;
	public Boolean cargarid_tipo_fondo_controlProcesoCambiarParametroGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_fondo_controlProcesoCambiarParametroGeneral=false;//ConEventDepend=true

	public Border resaltarid_tipo_tamanio_controlProcesoCambiarParametroGeneral=null;
	public Boolean mostrarid_tipo_tamanio_controlProcesoCambiarParametroGeneral=true;
	public Boolean activarid_tipo_tamanio_controlProcesoCambiarParametroGeneral=true;
	public Boolean cargarid_tipo_tamanio_controlProcesoCambiarParametroGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_tamanio_controlProcesoCambiarParametroGeneral=false;//ConEventDepend=true

	public Border resaltarcon_mensaje_confirmacionProcesoCambiarParametroGeneral=null;
	public Boolean mostrarcon_mensaje_confirmacionProcesoCambiarParametroGeneral=true;
	public Boolean activarcon_mensaje_confirmacionProcesoCambiarParametroGeneral=true;

	public Border resaltarcon_botones_tool_barProcesoCambiarParametroGeneral=null;
	public Boolean mostrarcon_botones_tool_barProcesoCambiarParametroGeneral=true;
	public Boolean activarcon_botones_tool_barProcesoCambiarParametroGeneral=true;

	public Border resaltarid_tipo_exportarProcesoCambiarParametroGeneral=null;
	public Boolean mostrarid_tipo_exportarProcesoCambiarParametroGeneral=true;
	public Boolean activarid_tipo_exportarProcesoCambiarParametroGeneral=true;
	public Boolean cargarid_tipo_exportarProcesoCambiarParametroGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_exportarProcesoCambiarParametroGeneral=false;//ConEventDepend=true

	public Border resaltarid_tipo_delimiterProcesoCambiarParametroGeneral=null;
	public Boolean mostrarid_tipo_delimiterProcesoCambiarParametroGeneral=true;
	public Boolean activarid_tipo_delimiterProcesoCambiarParametroGeneral=true;
	public Boolean cargarid_tipo_delimiterProcesoCambiarParametroGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_delimiterProcesoCambiarParametroGeneral=false;//ConEventDepend=true

	public Border resaltarcon_exportar_cabeceraProcesoCambiarParametroGeneral=null;
	public Boolean mostrarcon_exportar_cabeceraProcesoCambiarParametroGeneral=true;
	public Boolean activarcon_exportar_cabeceraProcesoCambiarParametroGeneral=true;

	public Border resaltarpath_exportarProcesoCambiarParametroGeneral=null;
	public Boolean mostrarpath_exportarProcesoCambiarParametroGeneral=true;
	public Boolean activarpath_exportarProcesoCambiarParametroGeneral=true;

	
	

	public Border setResaltaridProcesoCambiarParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarParametroGeneralBeanSwingJInternalFrame procesocambiarparametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocambiarparametrogeneralBeanSwingJInternalFrame.jTtoolBarProcesoCambiarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltaridProcesoCambiarParametroGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoCambiarParametroGeneral() {
		return this.resaltaridProcesoCambiarParametroGeneral;
	}

	public void setResaltaridProcesoCambiarParametroGeneral(Border borderResaltar) {
		this.resaltaridProcesoCambiarParametroGeneral= borderResaltar;
	}

	public Boolean getMostraridProcesoCambiarParametroGeneral() {
		return this.mostraridProcesoCambiarParametroGeneral;
	}

	public void setMostraridProcesoCambiarParametroGeneral(Boolean mostraridProcesoCambiarParametroGeneral) {
		this.mostraridProcesoCambiarParametroGeneral= mostraridProcesoCambiarParametroGeneral;
	}

	public Boolean getActivaridProcesoCambiarParametroGeneral() {
		return this.activaridProcesoCambiarParametroGeneral;
	}

	public void setActivaridProcesoCambiarParametroGeneral(Boolean activaridProcesoCambiarParametroGeneral) {
		this.activaridProcesoCambiarParametroGeneral= activaridProcesoCambiarParametroGeneral;
	}

	public Border setResaltarid_tipo_visualProcesoCambiarParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarParametroGeneralBeanSwingJInternalFrame procesocambiarparametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocambiarparametrogeneralBeanSwingJInternalFrame.jTtoolBarProcesoCambiarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltarid_tipo_visualProcesoCambiarParametroGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_visualProcesoCambiarParametroGeneral() {
		return this.resaltarid_tipo_visualProcesoCambiarParametroGeneral;
	}

	public void setResaltarid_tipo_visualProcesoCambiarParametroGeneral(Border borderResaltar) {
		this.resaltarid_tipo_visualProcesoCambiarParametroGeneral= borderResaltar;
	}

	public Boolean getMostrarid_tipo_visualProcesoCambiarParametroGeneral() {
		return this.mostrarid_tipo_visualProcesoCambiarParametroGeneral;
	}

	public void setMostrarid_tipo_visualProcesoCambiarParametroGeneral(Boolean mostrarid_tipo_visualProcesoCambiarParametroGeneral) {
		this.mostrarid_tipo_visualProcesoCambiarParametroGeneral= mostrarid_tipo_visualProcesoCambiarParametroGeneral;
	}

	public Boolean getActivarid_tipo_visualProcesoCambiarParametroGeneral() {
		return this.activarid_tipo_visualProcesoCambiarParametroGeneral;
	}

	public void setActivarid_tipo_visualProcesoCambiarParametroGeneral(Boolean activarid_tipo_visualProcesoCambiarParametroGeneral) {
		this.activarid_tipo_visualProcesoCambiarParametroGeneral= activarid_tipo_visualProcesoCambiarParametroGeneral;
	}

	public Boolean getCargarid_tipo_visualProcesoCambiarParametroGeneral() {
		return this.cargarid_tipo_visualProcesoCambiarParametroGeneral;
	}

	public void setCargarid_tipo_visualProcesoCambiarParametroGeneral(Boolean cargarid_tipo_visualProcesoCambiarParametroGeneral) {
		this.cargarid_tipo_visualProcesoCambiarParametroGeneral= cargarid_tipo_visualProcesoCambiarParametroGeneral;
	}

	public Border setResaltarid_tipo_fondoProcesoCambiarParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarParametroGeneralBeanSwingJInternalFrame procesocambiarparametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocambiarparametrogeneralBeanSwingJInternalFrame.jTtoolBarProcesoCambiarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltarid_tipo_fondoProcesoCambiarParametroGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_fondoProcesoCambiarParametroGeneral() {
		return this.resaltarid_tipo_fondoProcesoCambiarParametroGeneral;
	}

	public void setResaltarid_tipo_fondoProcesoCambiarParametroGeneral(Border borderResaltar) {
		this.resaltarid_tipo_fondoProcesoCambiarParametroGeneral= borderResaltar;
	}

	public Boolean getMostrarid_tipo_fondoProcesoCambiarParametroGeneral() {
		return this.mostrarid_tipo_fondoProcesoCambiarParametroGeneral;
	}

	public void setMostrarid_tipo_fondoProcesoCambiarParametroGeneral(Boolean mostrarid_tipo_fondoProcesoCambiarParametroGeneral) {
		this.mostrarid_tipo_fondoProcesoCambiarParametroGeneral= mostrarid_tipo_fondoProcesoCambiarParametroGeneral;
	}

	public Boolean getActivarid_tipo_fondoProcesoCambiarParametroGeneral() {
		return this.activarid_tipo_fondoProcesoCambiarParametroGeneral;
	}

	public void setActivarid_tipo_fondoProcesoCambiarParametroGeneral(Boolean activarid_tipo_fondoProcesoCambiarParametroGeneral) {
		this.activarid_tipo_fondoProcesoCambiarParametroGeneral= activarid_tipo_fondoProcesoCambiarParametroGeneral;
	}

	public Boolean getCargarid_tipo_fondoProcesoCambiarParametroGeneral() {
		return this.cargarid_tipo_fondoProcesoCambiarParametroGeneral;
	}

	public void setCargarid_tipo_fondoProcesoCambiarParametroGeneral(Boolean cargarid_tipo_fondoProcesoCambiarParametroGeneral) {
		this.cargarid_tipo_fondoProcesoCambiarParametroGeneral= cargarid_tipo_fondoProcesoCambiarParametroGeneral;
	}

	public Border setResaltarid_tipo_fondo_bordeProcesoCambiarParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarParametroGeneralBeanSwingJInternalFrame procesocambiarparametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocambiarparametrogeneralBeanSwingJInternalFrame.jTtoolBarProcesoCambiarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltarid_tipo_fondo_bordeProcesoCambiarParametroGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_fondo_bordeProcesoCambiarParametroGeneral() {
		return this.resaltarid_tipo_fondo_bordeProcesoCambiarParametroGeneral;
	}

	public void setResaltarid_tipo_fondo_bordeProcesoCambiarParametroGeneral(Border borderResaltar) {
		this.resaltarid_tipo_fondo_bordeProcesoCambiarParametroGeneral= borderResaltar;
	}

	public Boolean getMostrarid_tipo_fondo_bordeProcesoCambiarParametroGeneral() {
		return this.mostrarid_tipo_fondo_bordeProcesoCambiarParametroGeneral;
	}

	public void setMostrarid_tipo_fondo_bordeProcesoCambiarParametroGeneral(Boolean mostrarid_tipo_fondo_bordeProcesoCambiarParametroGeneral) {
		this.mostrarid_tipo_fondo_bordeProcesoCambiarParametroGeneral= mostrarid_tipo_fondo_bordeProcesoCambiarParametroGeneral;
	}

	public Boolean getActivarid_tipo_fondo_bordeProcesoCambiarParametroGeneral() {
		return this.activarid_tipo_fondo_bordeProcesoCambiarParametroGeneral;
	}

	public void setActivarid_tipo_fondo_bordeProcesoCambiarParametroGeneral(Boolean activarid_tipo_fondo_bordeProcesoCambiarParametroGeneral) {
		this.activarid_tipo_fondo_bordeProcesoCambiarParametroGeneral= activarid_tipo_fondo_bordeProcesoCambiarParametroGeneral;
	}

	public Boolean getCargarid_tipo_fondo_bordeProcesoCambiarParametroGeneral() {
		return this.cargarid_tipo_fondo_bordeProcesoCambiarParametroGeneral;
	}

	public void setCargarid_tipo_fondo_bordeProcesoCambiarParametroGeneral(Boolean cargarid_tipo_fondo_bordeProcesoCambiarParametroGeneral) {
		this.cargarid_tipo_fondo_bordeProcesoCambiarParametroGeneral= cargarid_tipo_fondo_bordeProcesoCambiarParametroGeneral;
	}

	public Border setResaltarid_tipo_fondo_controlProcesoCambiarParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarParametroGeneralBeanSwingJInternalFrame procesocambiarparametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocambiarparametrogeneralBeanSwingJInternalFrame.jTtoolBarProcesoCambiarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltarid_tipo_fondo_controlProcesoCambiarParametroGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_fondo_controlProcesoCambiarParametroGeneral() {
		return this.resaltarid_tipo_fondo_controlProcesoCambiarParametroGeneral;
	}

	public void setResaltarid_tipo_fondo_controlProcesoCambiarParametroGeneral(Border borderResaltar) {
		this.resaltarid_tipo_fondo_controlProcesoCambiarParametroGeneral= borderResaltar;
	}

	public Boolean getMostrarid_tipo_fondo_controlProcesoCambiarParametroGeneral() {
		return this.mostrarid_tipo_fondo_controlProcesoCambiarParametroGeneral;
	}

	public void setMostrarid_tipo_fondo_controlProcesoCambiarParametroGeneral(Boolean mostrarid_tipo_fondo_controlProcesoCambiarParametroGeneral) {
		this.mostrarid_tipo_fondo_controlProcesoCambiarParametroGeneral= mostrarid_tipo_fondo_controlProcesoCambiarParametroGeneral;
	}

	public Boolean getActivarid_tipo_fondo_controlProcesoCambiarParametroGeneral() {
		return this.activarid_tipo_fondo_controlProcesoCambiarParametroGeneral;
	}

	public void setActivarid_tipo_fondo_controlProcesoCambiarParametroGeneral(Boolean activarid_tipo_fondo_controlProcesoCambiarParametroGeneral) {
		this.activarid_tipo_fondo_controlProcesoCambiarParametroGeneral= activarid_tipo_fondo_controlProcesoCambiarParametroGeneral;
	}

	public Boolean getCargarid_tipo_fondo_controlProcesoCambiarParametroGeneral() {
		return this.cargarid_tipo_fondo_controlProcesoCambiarParametroGeneral;
	}

	public void setCargarid_tipo_fondo_controlProcesoCambiarParametroGeneral(Boolean cargarid_tipo_fondo_controlProcesoCambiarParametroGeneral) {
		this.cargarid_tipo_fondo_controlProcesoCambiarParametroGeneral= cargarid_tipo_fondo_controlProcesoCambiarParametroGeneral;
	}

	public Border setResaltarid_tipo_tamanio_controlProcesoCambiarParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarParametroGeneralBeanSwingJInternalFrame procesocambiarparametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocambiarparametrogeneralBeanSwingJInternalFrame.jTtoolBarProcesoCambiarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltarid_tipo_tamanio_controlProcesoCambiarParametroGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_tamanio_controlProcesoCambiarParametroGeneral() {
		return this.resaltarid_tipo_tamanio_controlProcesoCambiarParametroGeneral;
	}

	public void setResaltarid_tipo_tamanio_controlProcesoCambiarParametroGeneral(Border borderResaltar) {
		this.resaltarid_tipo_tamanio_controlProcesoCambiarParametroGeneral= borderResaltar;
	}

	public Boolean getMostrarid_tipo_tamanio_controlProcesoCambiarParametroGeneral() {
		return this.mostrarid_tipo_tamanio_controlProcesoCambiarParametroGeneral;
	}

	public void setMostrarid_tipo_tamanio_controlProcesoCambiarParametroGeneral(Boolean mostrarid_tipo_tamanio_controlProcesoCambiarParametroGeneral) {
		this.mostrarid_tipo_tamanio_controlProcesoCambiarParametroGeneral= mostrarid_tipo_tamanio_controlProcesoCambiarParametroGeneral;
	}

	public Boolean getActivarid_tipo_tamanio_controlProcesoCambiarParametroGeneral() {
		return this.activarid_tipo_tamanio_controlProcesoCambiarParametroGeneral;
	}

	public void setActivarid_tipo_tamanio_controlProcesoCambiarParametroGeneral(Boolean activarid_tipo_tamanio_controlProcesoCambiarParametroGeneral) {
		this.activarid_tipo_tamanio_controlProcesoCambiarParametroGeneral= activarid_tipo_tamanio_controlProcesoCambiarParametroGeneral;
	}

	public Boolean getCargarid_tipo_tamanio_controlProcesoCambiarParametroGeneral() {
		return this.cargarid_tipo_tamanio_controlProcesoCambiarParametroGeneral;
	}

	public void setCargarid_tipo_tamanio_controlProcesoCambiarParametroGeneral(Boolean cargarid_tipo_tamanio_controlProcesoCambiarParametroGeneral) {
		this.cargarid_tipo_tamanio_controlProcesoCambiarParametroGeneral= cargarid_tipo_tamanio_controlProcesoCambiarParametroGeneral;
	}

	public Border setResaltarcon_mensaje_confirmacionProcesoCambiarParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarParametroGeneralBeanSwingJInternalFrame procesocambiarparametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocambiarparametrogeneralBeanSwingJInternalFrame.jTtoolBarProcesoCambiarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltarcon_mensaje_confirmacionProcesoCambiarParametroGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_mensaje_confirmacionProcesoCambiarParametroGeneral() {
		return this.resaltarcon_mensaje_confirmacionProcesoCambiarParametroGeneral;
	}

	public void setResaltarcon_mensaje_confirmacionProcesoCambiarParametroGeneral(Border borderResaltar) {
		this.resaltarcon_mensaje_confirmacionProcesoCambiarParametroGeneral= borderResaltar;
	}

	public Boolean getMostrarcon_mensaje_confirmacionProcesoCambiarParametroGeneral() {
		return this.mostrarcon_mensaje_confirmacionProcesoCambiarParametroGeneral;
	}

	public void setMostrarcon_mensaje_confirmacionProcesoCambiarParametroGeneral(Boolean mostrarcon_mensaje_confirmacionProcesoCambiarParametroGeneral) {
		this.mostrarcon_mensaje_confirmacionProcesoCambiarParametroGeneral= mostrarcon_mensaje_confirmacionProcesoCambiarParametroGeneral;
	}

	public Boolean getActivarcon_mensaje_confirmacionProcesoCambiarParametroGeneral() {
		return this.activarcon_mensaje_confirmacionProcesoCambiarParametroGeneral;
	}

	public void setActivarcon_mensaje_confirmacionProcesoCambiarParametroGeneral(Boolean activarcon_mensaje_confirmacionProcesoCambiarParametroGeneral) {
		this.activarcon_mensaje_confirmacionProcesoCambiarParametroGeneral= activarcon_mensaje_confirmacionProcesoCambiarParametroGeneral;
	}

	public Border setResaltarcon_botones_tool_barProcesoCambiarParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarParametroGeneralBeanSwingJInternalFrame procesocambiarparametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocambiarparametrogeneralBeanSwingJInternalFrame.jTtoolBarProcesoCambiarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltarcon_botones_tool_barProcesoCambiarParametroGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_botones_tool_barProcesoCambiarParametroGeneral() {
		return this.resaltarcon_botones_tool_barProcesoCambiarParametroGeneral;
	}

	public void setResaltarcon_botones_tool_barProcesoCambiarParametroGeneral(Border borderResaltar) {
		this.resaltarcon_botones_tool_barProcesoCambiarParametroGeneral= borderResaltar;
	}

	public Boolean getMostrarcon_botones_tool_barProcesoCambiarParametroGeneral() {
		return this.mostrarcon_botones_tool_barProcesoCambiarParametroGeneral;
	}

	public void setMostrarcon_botones_tool_barProcesoCambiarParametroGeneral(Boolean mostrarcon_botones_tool_barProcesoCambiarParametroGeneral) {
		this.mostrarcon_botones_tool_barProcesoCambiarParametroGeneral= mostrarcon_botones_tool_barProcesoCambiarParametroGeneral;
	}

	public Boolean getActivarcon_botones_tool_barProcesoCambiarParametroGeneral() {
		return this.activarcon_botones_tool_barProcesoCambiarParametroGeneral;
	}

	public void setActivarcon_botones_tool_barProcesoCambiarParametroGeneral(Boolean activarcon_botones_tool_barProcesoCambiarParametroGeneral) {
		this.activarcon_botones_tool_barProcesoCambiarParametroGeneral= activarcon_botones_tool_barProcesoCambiarParametroGeneral;
	}

	public Border setResaltarid_tipo_exportarProcesoCambiarParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarParametroGeneralBeanSwingJInternalFrame procesocambiarparametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocambiarparametrogeneralBeanSwingJInternalFrame.jTtoolBarProcesoCambiarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltarid_tipo_exportarProcesoCambiarParametroGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_exportarProcesoCambiarParametroGeneral() {
		return this.resaltarid_tipo_exportarProcesoCambiarParametroGeneral;
	}

	public void setResaltarid_tipo_exportarProcesoCambiarParametroGeneral(Border borderResaltar) {
		this.resaltarid_tipo_exportarProcesoCambiarParametroGeneral= borderResaltar;
	}

	public Boolean getMostrarid_tipo_exportarProcesoCambiarParametroGeneral() {
		return this.mostrarid_tipo_exportarProcesoCambiarParametroGeneral;
	}

	public void setMostrarid_tipo_exportarProcesoCambiarParametroGeneral(Boolean mostrarid_tipo_exportarProcesoCambiarParametroGeneral) {
		this.mostrarid_tipo_exportarProcesoCambiarParametroGeneral= mostrarid_tipo_exportarProcesoCambiarParametroGeneral;
	}

	public Boolean getActivarid_tipo_exportarProcesoCambiarParametroGeneral() {
		return this.activarid_tipo_exportarProcesoCambiarParametroGeneral;
	}

	public void setActivarid_tipo_exportarProcesoCambiarParametroGeneral(Boolean activarid_tipo_exportarProcesoCambiarParametroGeneral) {
		this.activarid_tipo_exportarProcesoCambiarParametroGeneral= activarid_tipo_exportarProcesoCambiarParametroGeneral;
	}

	public Boolean getCargarid_tipo_exportarProcesoCambiarParametroGeneral() {
		return this.cargarid_tipo_exportarProcesoCambiarParametroGeneral;
	}

	public void setCargarid_tipo_exportarProcesoCambiarParametroGeneral(Boolean cargarid_tipo_exportarProcesoCambiarParametroGeneral) {
		this.cargarid_tipo_exportarProcesoCambiarParametroGeneral= cargarid_tipo_exportarProcesoCambiarParametroGeneral;
	}

	public Border setResaltarid_tipo_delimiterProcesoCambiarParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarParametroGeneralBeanSwingJInternalFrame procesocambiarparametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocambiarparametrogeneralBeanSwingJInternalFrame.jTtoolBarProcesoCambiarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltarid_tipo_delimiterProcesoCambiarParametroGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_delimiterProcesoCambiarParametroGeneral() {
		return this.resaltarid_tipo_delimiterProcesoCambiarParametroGeneral;
	}

	public void setResaltarid_tipo_delimiterProcesoCambiarParametroGeneral(Border borderResaltar) {
		this.resaltarid_tipo_delimiterProcesoCambiarParametroGeneral= borderResaltar;
	}

	public Boolean getMostrarid_tipo_delimiterProcesoCambiarParametroGeneral() {
		return this.mostrarid_tipo_delimiterProcesoCambiarParametroGeneral;
	}

	public void setMostrarid_tipo_delimiterProcesoCambiarParametroGeneral(Boolean mostrarid_tipo_delimiterProcesoCambiarParametroGeneral) {
		this.mostrarid_tipo_delimiterProcesoCambiarParametroGeneral= mostrarid_tipo_delimiterProcesoCambiarParametroGeneral;
	}

	public Boolean getActivarid_tipo_delimiterProcesoCambiarParametroGeneral() {
		return this.activarid_tipo_delimiterProcesoCambiarParametroGeneral;
	}

	public void setActivarid_tipo_delimiterProcesoCambiarParametroGeneral(Boolean activarid_tipo_delimiterProcesoCambiarParametroGeneral) {
		this.activarid_tipo_delimiterProcesoCambiarParametroGeneral= activarid_tipo_delimiterProcesoCambiarParametroGeneral;
	}

	public Boolean getCargarid_tipo_delimiterProcesoCambiarParametroGeneral() {
		return this.cargarid_tipo_delimiterProcesoCambiarParametroGeneral;
	}

	public void setCargarid_tipo_delimiterProcesoCambiarParametroGeneral(Boolean cargarid_tipo_delimiterProcesoCambiarParametroGeneral) {
		this.cargarid_tipo_delimiterProcesoCambiarParametroGeneral= cargarid_tipo_delimiterProcesoCambiarParametroGeneral;
	}

	public Border setResaltarcon_exportar_cabeceraProcesoCambiarParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarParametroGeneralBeanSwingJInternalFrame procesocambiarparametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocambiarparametrogeneralBeanSwingJInternalFrame.jTtoolBarProcesoCambiarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltarcon_exportar_cabeceraProcesoCambiarParametroGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_exportar_cabeceraProcesoCambiarParametroGeneral() {
		return this.resaltarcon_exportar_cabeceraProcesoCambiarParametroGeneral;
	}

	public void setResaltarcon_exportar_cabeceraProcesoCambiarParametroGeneral(Border borderResaltar) {
		this.resaltarcon_exportar_cabeceraProcesoCambiarParametroGeneral= borderResaltar;
	}

	public Boolean getMostrarcon_exportar_cabeceraProcesoCambiarParametroGeneral() {
		return this.mostrarcon_exportar_cabeceraProcesoCambiarParametroGeneral;
	}

	public void setMostrarcon_exportar_cabeceraProcesoCambiarParametroGeneral(Boolean mostrarcon_exportar_cabeceraProcesoCambiarParametroGeneral) {
		this.mostrarcon_exportar_cabeceraProcesoCambiarParametroGeneral= mostrarcon_exportar_cabeceraProcesoCambiarParametroGeneral;
	}

	public Boolean getActivarcon_exportar_cabeceraProcesoCambiarParametroGeneral() {
		return this.activarcon_exportar_cabeceraProcesoCambiarParametroGeneral;
	}

	public void setActivarcon_exportar_cabeceraProcesoCambiarParametroGeneral(Boolean activarcon_exportar_cabeceraProcesoCambiarParametroGeneral) {
		this.activarcon_exportar_cabeceraProcesoCambiarParametroGeneral= activarcon_exportar_cabeceraProcesoCambiarParametroGeneral;
	}

	public Border setResaltarpath_exportarProcesoCambiarParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarParametroGeneralBeanSwingJInternalFrame procesocambiarparametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocambiarparametrogeneralBeanSwingJInternalFrame.jTtoolBarProcesoCambiarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltarpath_exportarProcesoCambiarParametroGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpath_exportarProcesoCambiarParametroGeneral() {
		return this.resaltarpath_exportarProcesoCambiarParametroGeneral;
	}

	public void setResaltarpath_exportarProcesoCambiarParametroGeneral(Border borderResaltar) {
		this.resaltarpath_exportarProcesoCambiarParametroGeneral= borderResaltar;
	}

	public Boolean getMostrarpath_exportarProcesoCambiarParametroGeneral() {
		return this.mostrarpath_exportarProcesoCambiarParametroGeneral;
	}

	public void setMostrarpath_exportarProcesoCambiarParametroGeneral(Boolean mostrarpath_exportarProcesoCambiarParametroGeneral) {
		this.mostrarpath_exportarProcesoCambiarParametroGeneral= mostrarpath_exportarProcesoCambiarParametroGeneral;
	}

	public Boolean getActivarpath_exportarProcesoCambiarParametroGeneral() {
		return this.activarpath_exportarProcesoCambiarParametroGeneral;
	}

	public void setActivarpath_exportarProcesoCambiarParametroGeneral(Boolean activarpath_exportarProcesoCambiarParametroGeneral) {
		this.activarpath_exportarProcesoCambiarParametroGeneral= activarpath_exportarProcesoCambiarParametroGeneral;
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
		
		
		this.setMostraridProcesoCambiarParametroGeneral(esInicial);
		this.setMostrarid_tipo_visualProcesoCambiarParametroGeneral(esInicial);
		this.setMostrarid_tipo_fondoProcesoCambiarParametroGeneral(esInicial);
		this.setMostrarid_tipo_fondo_bordeProcesoCambiarParametroGeneral(esInicial);
		this.setMostrarid_tipo_fondo_controlProcesoCambiarParametroGeneral(esInicial);
		this.setMostrarid_tipo_tamanio_controlProcesoCambiarParametroGeneral(esInicial);
		this.setMostrarcon_mensaje_confirmacionProcesoCambiarParametroGeneral(esInicial);
		this.setMostrarcon_botones_tool_barProcesoCambiarParametroGeneral(esInicial);
		this.setMostrarid_tipo_exportarProcesoCambiarParametroGeneral(esInicial);
		this.setMostrarid_tipo_delimiterProcesoCambiarParametroGeneral(esInicial);
		this.setMostrarcon_exportar_cabeceraProcesoCambiarParametroGeneral(esInicial);
		this.setMostrarpath_exportarProcesoCambiarParametroGeneral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.ID)) {
				this.setMostraridProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOVISUAL)) {
				this.setMostrarid_tipo_visualProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOFONDO)) {
				this.setMostrarid_tipo_fondoProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOFONDOBORDE)) {
				this.setMostrarid_tipo_fondo_bordeProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOFONDOCONTROL)) {
				this.setMostrarid_tipo_fondo_controlProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOTAMANIOCONTROL)) {
				this.setMostrarid_tipo_tamanio_controlProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.CONMENSAJECONFIRMACION)) {
				this.setMostrarcon_mensaje_confirmacionProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.CONBOTONESTOOLBAR)) {
				this.setMostrarcon_botones_tool_barProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOEXPORTAR)) {
				this.setMostrarid_tipo_exportarProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPODELIMITER)) {
				this.setMostrarid_tipo_delimiterProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.CONEXPORTARCABECERA)) {
				this.setMostrarcon_exportar_cabeceraProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.PATHEXPORTAR)) {
				this.setMostrarpath_exportarProcesoCambiarParametroGeneral(esAsigna);
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
		
		
		this.setActivaridProcesoCambiarParametroGeneral(esInicial);
		this.setActivarid_tipo_visualProcesoCambiarParametroGeneral(esInicial);
		this.setActivarid_tipo_fondoProcesoCambiarParametroGeneral(esInicial);
		this.setActivarid_tipo_fondo_bordeProcesoCambiarParametroGeneral(esInicial);
		this.setActivarid_tipo_fondo_controlProcesoCambiarParametroGeneral(esInicial);
		this.setActivarid_tipo_tamanio_controlProcesoCambiarParametroGeneral(esInicial);
		this.setActivarcon_mensaje_confirmacionProcesoCambiarParametroGeneral(esInicial);
		this.setActivarcon_botones_tool_barProcesoCambiarParametroGeneral(esInicial);
		this.setActivarid_tipo_exportarProcesoCambiarParametroGeneral(esInicial);
		this.setActivarid_tipo_delimiterProcesoCambiarParametroGeneral(esInicial);
		this.setActivarcon_exportar_cabeceraProcesoCambiarParametroGeneral(esInicial);
		this.setActivarpath_exportarProcesoCambiarParametroGeneral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.ID)) {
				this.setActivaridProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOVISUAL)) {
				this.setActivarid_tipo_visualProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOFONDO)) {
				this.setActivarid_tipo_fondoProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOFONDOBORDE)) {
				this.setActivarid_tipo_fondo_bordeProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOFONDOCONTROL)) {
				this.setActivarid_tipo_fondo_controlProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOTAMANIOCONTROL)) {
				this.setActivarid_tipo_tamanio_controlProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.CONMENSAJECONFIRMACION)) {
				this.setActivarcon_mensaje_confirmacionProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.CONBOTONESTOOLBAR)) {
				this.setActivarcon_botones_tool_barProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOEXPORTAR)) {
				this.setActivarid_tipo_exportarProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPODELIMITER)) {
				this.setActivarid_tipo_delimiterProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.CONEXPORTARCABECERA)) {
				this.setActivarcon_exportar_cabeceraProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.PATHEXPORTAR)) {
				this.setActivarpath_exportarProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoCambiarParametroGeneralBeanSwingJInternalFrame procesocambiarparametrogeneralBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoCambiarParametroGeneral(esInicial);
		this.setResaltarid_tipo_visualProcesoCambiarParametroGeneral(esInicial);
		this.setResaltarid_tipo_fondoProcesoCambiarParametroGeneral(esInicial);
		this.setResaltarid_tipo_fondo_bordeProcesoCambiarParametroGeneral(esInicial);
		this.setResaltarid_tipo_fondo_controlProcesoCambiarParametroGeneral(esInicial);
		this.setResaltarid_tipo_tamanio_controlProcesoCambiarParametroGeneral(esInicial);
		this.setResaltarcon_mensaje_confirmacionProcesoCambiarParametroGeneral(esInicial);
		this.setResaltarcon_botones_tool_barProcesoCambiarParametroGeneral(esInicial);
		this.setResaltarid_tipo_exportarProcesoCambiarParametroGeneral(esInicial);
		this.setResaltarid_tipo_delimiterProcesoCambiarParametroGeneral(esInicial);
		this.setResaltarcon_exportar_cabeceraProcesoCambiarParametroGeneral(esInicial);
		this.setResaltarpath_exportarProcesoCambiarParametroGeneral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.ID)) {
				this.setResaltaridProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOVISUAL)) {
				this.setResaltarid_tipo_visualProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOFONDO)) {
				this.setResaltarid_tipo_fondoProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOFONDOBORDE)) {
				this.setResaltarid_tipo_fondo_bordeProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOFONDOCONTROL)) {
				this.setResaltarid_tipo_fondo_controlProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOTAMANIOCONTROL)) {
				this.setResaltarid_tipo_tamanio_controlProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.CONMENSAJECONFIRMACION)) {
				this.setResaltarcon_mensaje_confirmacionProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.CONBOTONESTOOLBAR)) {
				this.setResaltarcon_botones_tool_barProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOEXPORTAR)) {
				this.setResaltarid_tipo_exportarProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPODELIMITER)) {
				this.setResaltarid_tipo_delimiterProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.CONEXPORTARCABECERA)) {
				this.setResaltarcon_exportar_cabeceraProcesoCambiarParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarParametroGeneralConstantesFunciones.PATHEXPORTAR)) {
				this.setResaltarpath_exportarProcesoCambiarParametroGeneral(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoCambiarParametroGeneralBeanSwingJInternalFrame procesocambiarparametrogeneralBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoCambiarParametroGeneralProcesoCambiarParametroGeneral=true;

	public Boolean getMostrarBusquedaProcesoCambiarParametroGeneralProcesoCambiarParametroGeneral() {
		return this.mostrarBusquedaProcesoCambiarParametroGeneralProcesoCambiarParametroGeneral;
	}

	public void setMostrarBusquedaProcesoCambiarParametroGeneralProcesoCambiarParametroGeneral(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoCambiarParametroGeneralProcesoCambiarParametroGeneral= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoCambiarParametroGeneralProcesoCambiarParametroGeneral=true;

	public Boolean getActivarBusquedaProcesoCambiarParametroGeneralProcesoCambiarParametroGeneral() {
		return this.activarBusquedaProcesoCambiarParametroGeneralProcesoCambiarParametroGeneral;
	}

	public void setActivarBusquedaProcesoCambiarParametroGeneralProcesoCambiarParametroGeneral(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoCambiarParametroGeneralProcesoCambiarParametroGeneral= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoCambiarParametroGeneralProcesoCambiarParametroGeneral=null;

	public Border getResaltarBusquedaProcesoCambiarParametroGeneralProcesoCambiarParametroGeneral() {
		return this.resaltarBusquedaProcesoCambiarParametroGeneralProcesoCambiarParametroGeneral;
	}

	public void setResaltarBusquedaProcesoCambiarParametroGeneralProcesoCambiarParametroGeneral(Border borderResaltar) {
		this.resaltarBusquedaProcesoCambiarParametroGeneralProcesoCambiarParametroGeneral= borderResaltar;
	}

	public void setResaltarBusquedaProcesoCambiarParametroGeneralProcesoCambiarParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarParametroGeneralBeanSwingJInternalFrame procesocambiarparametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoCambiarParametroGeneralProcesoCambiarParametroGeneral= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}