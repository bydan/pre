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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.DetalleEvaluacionNomiConstantesFunciones;
import com.bydan.erp.nomina.util.DetalleEvaluacionNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.DetalleEvaluacionNomiParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleEvaluacionNomiConstantesFunciones extends DetalleEvaluacionNomiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleEvaluacionNomi";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleEvaluacionNomi"+DetalleEvaluacionNomiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleEvaluacionNomiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleEvaluacionNomiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"_"+DetalleEvaluacionNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleEvaluacionNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"_"+DetalleEvaluacionNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"_"+DetalleEvaluacionNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleEvaluacionNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"_"+DetalleEvaluacionNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleEvaluacionNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleEvaluacionNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleEvaluacionNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleEvaluacionNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleEvaluacionNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleEvaluacionNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleEvaluacionNomiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleEvaluacionNomiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleEvaluacionNomiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleEvaluacionNomiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Evaluacion Nomis";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Evaluacion Nomi";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Evaluacion Nomi";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleEvaluacionNomi";
	public static final String OBJECTNAME="detalleevaluacionnomi";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="detalle_evaluacion_nomi";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalleevaluacionnomi from "+DetalleEvaluacionNomiConstantesFunciones.SPERSISTENCENAME+" detalleevaluacionnomi";
	public static String QUERYSELECTNATIVE="select "+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".id,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".version_row,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".id_empresa,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".id_evaluacion_nomi,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".id_formato_nomi,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".id_pregunta_nomi,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".respuesta,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".respuesta_valor,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".califica1,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".califica2,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".califica3,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".califica4,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".califica5,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".califica6,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".califica7,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".califica8,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".califica9,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".califica10 from "+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME;//+" as "+DetalleEvaluacionNomiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleEvaluacionNomiConstantesFuncionesAdditional detalleevaluacionnomiConstantesFuncionesAdditional=null;
	
	public DetalleEvaluacionNomiConstantesFuncionesAdditional getDetalleEvaluacionNomiConstantesFuncionesAdditional() {
		return this.detalleevaluacionnomiConstantesFuncionesAdditional;
	}
	
	public void setDetalleEvaluacionNomiConstantesFuncionesAdditional(DetalleEvaluacionNomiConstantesFuncionesAdditional detalleevaluacionnomiConstantesFuncionesAdditional) {
		try {
			this.detalleevaluacionnomiConstantesFuncionesAdditional=detalleevaluacionnomiConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEVALUACIONNOMI= "id_evaluacion_nomi";
    public static final String IDFORMATONOMI= "id_formato_nomi";
    public static final String IDPREGUNTANOMI= "id_pregunta_nomi";
    public static final String RESPUESTA= "respuesta";
    public static final String RESPUESTAVALOR= "respuesta_valor";
    public static final String CALIFICA1= "califica1";
    public static final String CALIFICA2= "califica2";
    public static final String CALIFICA3= "califica3";
    public static final String CALIFICA4= "califica4";
    public static final String CALIFICA5= "califica5";
    public static final String CALIFICA6= "califica6";
    public static final String CALIFICA7= "califica7";
    public static final String CALIFICA8= "califica8";
    public static final String CALIFICA9= "califica9";
    public static final String CALIFICA10= "califica10";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEVALUACIONNOMI= "Evaluacion Nomi";
		public static final String LABEL_IDEVALUACIONNOMI_LOWER= "Evaluacion Nomi";
    	public static final String LABEL_IDFORMATONOMI= "Formato Nomi";
		public static final String LABEL_IDFORMATONOMI_LOWER= "Formato Nomi";
    	public static final String LABEL_IDPREGUNTANOMI= "Pregunta Nomi";
		public static final String LABEL_IDPREGUNTANOMI_LOWER= "Pregunta Nomi";
    	public static final String LABEL_RESPUESTA= "Respuesta";
		public static final String LABEL_RESPUESTA_LOWER= "Respuesta";
    	public static final String LABEL_RESPUESTAVALOR= "Respuesta Valor";
		public static final String LABEL_RESPUESTAVALOR_LOWER= "Respuesta Valor";
    	public static final String LABEL_CALIFICA1= "Califica1";
		public static final String LABEL_CALIFICA1_LOWER= "Califica1";
    	public static final String LABEL_CALIFICA2= "Califica2";
		public static final String LABEL_CALIFICA2_LOWER= "Califica2";
    	public static final String LABEL_CALIFICA3= "Califica3";
		public static final String LABEL_CALIFICA3_LOWER= "Califica3";
    	public static final String LABEL_CALIFICA4= "Califica4";
		public static final String LABEL_CALIFICA4_LOWER= "Califica4";
    	public static final String LABEL_CALIFICA5= "Califica5";
		public static final String LABEL_CALIFICA5_LOWER= "Califica5";
    	public static final String LABEL_CALIFICA6= "Califica6";
		public static final String LABEL_CALIFICA6_LOWER= "Califica6";
    	public static final String LABEL_CALIFICA7= "Califica7";
		public static final String LABEL_CALIFICA7_LOWER= "Califica7";
    	public static final String LABEL_CALIFICA8= "Califica8";
		public static final String LABEL_CALIFICA8_LOWER= "Califica8";
    	public static final String LABEL_CALIFICA9= "Califica9";
		public static final String LABEL_CALIFICA9_LOWER= "Califica9";
    	public static final String LABEL_CALIFICA10= "Califica10";
		public static final String LABEL_CALIFICA10_LOWER= "Califica10";
	
		
		
		
		
		
		
	public static final String SREGEXRESPUESTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRESPUESTA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getDetalleEvaluacionNomiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleEvaluacionNomiConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleEvaluacionNomiConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleEvaluacionNomiConstantesFunciones.IDEVALUACIONNOMI)) {sLabelColumna=DetalleEvaluacionNomiConstantesFunciones.LABEL_IDEVALUACIONNOMI;}
		if(sNombreColumna.equals(DetalleEvaluacionNomiConstantesFunciones.IDFORMATONOMI)) {sLabelColumna=DetalleEvaluacionNomiConstantesFunciones.LABEL_IDFORMATONOMI;}
		if(sNombreColumna.equals(DetalleEvaluacionNomiConstantesFunciones.IDPREGUNTANOMI)) {sLabelColumna=DetalleEvaluacionNomiConstantesFunciones.LABEL_IDPREGUNTANOMI;}
		if(sNombreColumna.equals(DetalleEvaluacionNomiConstantesFunciones.RESPUESTA)) {sLabelColumna=DetalleEvaluacionNomiConstantesFunciones.LABEL_RESPUESTA;}
		if(sNombreColumna.equals(DetalleEvaluacionNomiConstantesFunciones.RESPUESTAVALOR)) {sLabelColumna=DetalleEvaluacionNomiConstantesFunciones.LABEL_RESPUESTAVALOR;}
		if(sNombreColumna.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA1)) {sLabelColumna=DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA1;}
		if(sNombreColumna.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA2)) {sLabelColumna=DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA2;}
		if(sNombreColumna.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA3)) {sLabelColumna=DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA3;}
		if(sNombreColumna.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA4)) {sLabelColumna=DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA4;}
		if(sNombreColumna.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA5)) {sLabelColumna=DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA5;}
		if(sNombreColumna.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA6)) {sLabelColumna=DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA6;}
		if(sNombreColumna.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA7)) {sLabelColumna=DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA7;}
		if(sNombreColumna.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA8)) {sLabelColumna=DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA8;}
		if(sNombreColumna.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA9)) {sLabelColumna=DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA9;}
		if(sNombreColumna.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA10)) {sLabelColumna=DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA10;}
		
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
	
	
	
			
			
			
			
			
			
			
			
		
	public static String getcalifica1Descripcion(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detalleevaluacionnomi.getcalifica1()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcalifica1HtmlDescripcion(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detalleevaluacionnomi.getId(),detalleevaluacionnomi.getcalifica1());

		return sDescripcion;
	}	
		
	public static String getcalifica2Descripcion(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detalleevaluacionnomi.getcalifica2()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcalifica2HtmlDescripcion(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detalleevaluacionnomi.getId(),detalleevaluacionnomi.getcalifica2());

		return sDescripcion;
	}	
		
	public static String getcalifica3Descripcion(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detalleevaluacionnomi.getcalifica3()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcalifica3HtmlDescripcion(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detalleevaluacionnomi.getId(),detalleevaluacionnomi.getcalifica3());

		return sDescripcion;
	}	
		
	public static String getcalifica4Descripcion(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detalleevaluacionnomi.getcalifica4()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcalifica4HtmlDescripcion(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detalleevaluacionnomi.getId(),detalleevaluacionnomi.getcalifica4());

		return sDescripcion;
	}	
		
	public static String getcalifica5Descripcion(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detalleevaluacionnomi.getcalifica5()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcalifica5HtmlDescripcion(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detalleevaluacionnomi.getId(),detalleevaluacionnomi.getcalifica5());

		return sDescripcion;
	}	
		
	public static String getcalifica6Descripcion(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detalleevaluacionnomi.getcalifica6()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcalifica6HtmlDescripcion(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detalleevaluacionnomi.getId(),detalleevaluacionnomi.getcalifica6());

		return sDescripcion;
	}	
		
	public static String getcalifica7Descripcion(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detalleevaluacionnomi.getcalifica7()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcalifica7HtmlDescripcion(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detalleevaluacionnomi.getId(),detalleevaluacionnomi.getcalifica7());

		return sDescripcion;
	}	
		
	public static String getcalifica8Descripcion(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detalleevaluacionnomi.getcalifica8()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcalifica8HtmlDescripcion(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detalleevaluacionnomi.getId(),detalleevaluacionnomi.getcalifica8());

		return sDescripcion;
	}	
		
	public static String getcalifica9Descripcion(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detalleevaluacionnomi.getcalifica9()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcalifica9HtmlDescripcion(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detalleevaluacionnomi.getId(),detalleevaluacionnomi.getcalifica9());

		return sDescripcion;
	}	
		
	public static String getcalifica10Descripcion(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detalleevaluacionnomi.getcalifica10()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcalifica10HtmlDescripcion(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detalleevaluacionnomi.getId(),detalleevaluacionnomi.getcalifica10());

		return sDescripcion;
	}	
	
	public static String getDetalleEvaluacionNomiDescripcion(DetalleEvaluacionNomi detalleevaluacionnomi) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalleevaluacionnomi !=null/* && detalleevaluacionnomi.getId()!=0*/) {
			if(detalleevaluacionnomi.getId()!=null) {
				sDescripcion=detalleevaluacionnomi.getId().toString();
			}//detalleevaluacionnomidetalleevaluacionnomi.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleEvaluacionNomiDescripcionDetallado(DetalleEvaluacionNomi detalleevaluacionnomi) {
		String sDescripcion="";
			
		sDescripcion+=DetalleEvaluacionNomiConstantesFunciones.ID+"=";
		sDescripcion+=detalleevaluacionnomi.getId().toString()+",";
		sDescripcion+=DetalleEvaluacionNomiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalleevaluacionnomi.getVersionRow().toString()+",";
		sDescripcion+=DetalleEvaluacionNomiConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalleevaluacionnomi.getid_empresa().toString()+",";
		sDescripcion+=DetalleEvaluacionNomiConstantesFunciones.IDEVALUACIONNOMI+"=";
		sDescripcion+=detalleevaluacionnomi.getid_evaluacion_nomi().toString()+",";
		sDescripcion+=DetalleEvaluacionNomiConstantesFunciones.IDFORMATONOMI+"=";
		sDescripcion+=detalleevaluacionnomi.getid_formato_nomi().toString()+",";
		sDescripcion+=DetalleEvaluacionNomiConstantesFunciones.IDPREGUNTANOMI+"=";
		sDescripcion+=detalleevaluacionnomi.getid_pregunta_nomi().toString()+",";
		sDescripcion+=DetalleEvaluacionNomiConstantesFunciones.RESPUESTA+"=";
		sDescripcion+=detalleevaluacionnomi.getrespuesta()+",";
		sDescripcion+=DetalleEvaluacionNomiConstantesFunciones.RESPUESTAVALOR+"=";
		sDescripcion+=detalleevaluacionnomi.getrespuesta_valor().toString()+",";
		sDescripcion+=DetalleEvaluacionNomiConstantesFunciones.CALIFICA1+"=";
		sDescripcion+=detalleevaluacionnomi.getcalifica1().toString()+",";
		sDescripcion+=DetalleEvaluacionNomiConstantesFunciones.CALIFICA2+"=";
		sDescripcion+=detalleevaluacionnomi.getcalifica2().toString()+",";
		sDescripcion+=DetalleEvaluacionNomiConstantesFunciones.CALIFICA3+"=";
		sDescripcion+=detalleevaluacionnomi.getcalifica3().toString()+",";
		sDescripcion+=DetalleEvaluacionNomiConstantesFunciones.CALIFICA4+"=";
		sDescripcion+=detalleevaluacionnomi.getcalifica4().toString()+",";
		sDescripcion+=DetalleEvaluacionNomiConstantesFunciones.CALIFICA5+"=";
		sDescripcion+=detalleevaluacionnomi.getcalifica5().toString()+",";
		sDescripcion+=DetalleEvaluacionNomiConstantesFunciones.CALIFICA6+"=";
		sDescripcion+=detalleevaluacionnomi.getcalifica6().toString()+",";
		sDescripcion+=DetalleEvaluacionNomiConstantesFunciones.CALIFICA7+"=";
		sDescripcion+=detalleevaluacionnomi.getcalifica7().toString()+",";
		sDescripcion+=DetalleEvaluacionNomiConstantesFunciones.CALIFICA8+"=";
		sDescripcion+=detalleevaluacionnomi.getcalifica8().toString()+",";
		sDescripcion+=DetalleEvaluacionNomiConstantesFunciones.CALIFICA9+"=";
		sDescripcion+=detalleevaluacionnomi.getcalifica9().toString()+",";
		sDescripcion+=DetalleEvaluacionNomiConstantesFunciones.CALIFICA10+"=";
		sDescripcion+=detalleevaluacionnomi.getcalifica10().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleEvaluacionNomiDescripcion(DetalleEvaluacionNomi detalleevaluacionnomi,String sValor) throws Exception {			
		if(detalleevaluacionnomi !=null) {
			//detalleevaluacionnomidetalleevaluacionnomi.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getEvaluacionNomiDescripcion(EvaluacionNomi evaluacionnomi) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(evaluacionnomi!=null/*&&evaluacionnomi.getId()>0*/) {
			sDescripcion=EvaluacionNomiConstantesFunciones.getEvaluacionNomiDescripcion(evaluacionnomi);
		}

		return sDescripcion;
	}

	public static String getFormatoNomiDescripcion(FormatoNomi formatonomi) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formatonomi!=null/*&&formatonomi.getId()>0*/) {
			sDescripcion=FormatoNomiConstantesFunciones.getFormatoNomiDescripcion(formatonomi);
		}

		return sDescripcion;
	}

	public static String getPreguntaNomiDescripcion(PreguntaNomi preguntanomi) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(preguntanomi!=null/*&&preguntanomi.getId()>0*/) {
			sDescripcion=PreguntaNomiConstantesFunciones.getPreguntaNomiDescripcion(preguntanomi);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEvaluacionNomi")) {
			sNombreIndice="Tipo=  Por Evaluacion Nomi";
		} else if(sNombreIndice.equals("FK_IdFormatoNomi")) {
			sNombreIndice="Tipo=  Por Formato Nomi";
		} else if(sNombreIndice.equals("FK_IdPreguntaNomi")) {
			sNombreIndice="Tipo=  Por Pregunta Nomi";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEvaluacionNomi(Long id_evaluacion_nomi) {
		String sDetalleIndice=" Parametros->";
		if(id_evaluacion_nomi!=null) {sDetalleIndice+=" Codigo Unico De Evaluacion Nomi="+id_evaluacion_nomi.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoNomi(Long id_formato_nomi) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_nomi!=null) {sDetalleIndice+=" Codigo Unico De Formato Nomi="+id_formato_nomi.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPreguntaNomi(Long id_pregunta_nomi) {
		String sDetalleIndice=" Parametros->";
		if(id_pregunta_nomi!=null) {sDetalleIndice+=" Codigo Unico De Pregunta Nomi="+id_pregunta_nomi.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleEvaluacionNomi(DetalleEvaluacionNomi detalleevaluacionnomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalleevaluacionnomi.setrespuesta(detalleevaluacionnomi.getrespuesta().trim());
	}
	
	public static void quitarEspaciosDetalleEvaluacionNomis(List<DetalleEvaluacionNomi> detalleevaluacionnomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleEvaluacionNomi detalleevaluacionnomi: detalleevaluacionnomis) {
			detalleevaluacionnomi.setrespuesta(detalleevaluacionnomi.getrespuesta().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleEvaluacionNomi(DetalleEvaluacionNomi detalleevaluacionnomi,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalleevaluacionnomi.getConCambioAuxiliar()) {
			detalleevaluacionnomi.setIsDeleted(detalleevaluacionnomi.getIsDeletedAuxiliar());	
			detalleevaluacionnomi.setIsNew(detalleevaluacionnomi.getIsNewAuxiliar());	
			detalleevaluacionnomi.setIsChanged(detalleevaluacionnomi.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalleevaluacionnomi.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalleevaluacionnomi.setIsDeletedAuxiliar(false);	
			detalleevaluacionnomi.setIsNewAuxiliar(false);	
			detalleevaluacionnomi.setIsChangedAuxiliar(false);
			
			detalleevaluacionnomi.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleEvaluacionNomis(List<DetalleEvaluacionNomi> detalleevaluacionnomis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleEvaluacionNomi detalleevaluacionnomi : detalleevaluacionnomis) {
			if(conAsignarBase && detalleevaluacionnomi.getConCambioAuxiliar()) {
				detalleevaluacionnomi.setIsDeleted(detalleevaluacionnomi.getIsDeletedAuxiliar());	
				detalleevaluacionnomi.setIsNew(detalleevaluacionnomi.getIsNewAuxiliar());	
				detalleevaluacionnomi.setIsChanged(detalleevaluacionnomi.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalleevaluacionnomi.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalleevaluacionnomi.setIsDeletedAuxiliar(false);	
				detalleevaluacionnomi.setIsNewAuxiliar(false);	
				detalleevaluacionnomi.setIsChangedAuxiliar(false);
				
				detalleevaluacionnomi.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleEvaluacionNomi(DetalleEvaluacionNomi detalleevaluacionnomi,Boolean conEnteros) throws Exception  {
		detalleevaluacionnomi.setrespuesta_valor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetalleEvaluacionNomis(List<DetalleEvaluacionNomi> detalleevaluacionnomis,Boolean conEnteros) throws Exception  {
		
		for(DetalleEvaluacionNomi detalleevaluacionnomi: detalleevaluacionnomis) {
			detalleevaluacionnomi.setrespuesta_valor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleEvaluacionNomi(List<DetalleEvaluacionNomi> detalleevaluacionnomis,DetalleEvaluacionNomi detalleevaluacionnomiAux) throws Exception  {
		DetalleEvaluacionNomiConstantesFunciones.InicializarValoresDetalleEvaluacionNomi(detalleevaluacionnomiAux,true);
		
		for(DetalleEvaluacionNomi detalleevaluacionnomi: detalleevaluacionnomis) {
			if(detalleevaluacionnomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detalleevaluacionnomiAux.setrespuesta_valor(detalleevaluacionnomiAux.getrespuesta_valor()+detalleevaluacionnomi.getrespuesta_valor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleEvaluacionNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleEvaluacionNomiConstantesFunciones.getArrayColumnasGlobalesDetalleEvaluacionNomi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleEvaluacionNomi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleEvaluacionNomiConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleEvaluacionNomiConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleEvaluacionNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleEvaluacionNomi> detalleevaluacionnomis,DetalleEvaluacionNomi detalleevaluacionnomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleEvaluacionNomi detalleevaluacionnomiAux: detalleevaluacionnomis) {
			if(detalleevaluacionnomiAux!=null && detalleevaluacionnomi!=null) {
				if((detalleevaluacionnomiAux.getId()==null && detalleevaluacionnomi.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalleevaluacionnomiAux.getId()!=null && detalleevaluacionnomi.getId()!=null){
					if(detalleevaluacionnomiAux.getId().equals(detalleevaluacionnomi.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleEvaluacionNomi(List<DetalleEvaluacionNomi> detalleevaluacionnomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double respuesta_valorTotal=0.0;
	
		for(DetalleEvaluacionNomi detalleevaluacionnomi: detalleevaluacionnomis) {			
			if(detalleevaluacionnomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			respuesta_valorTotal+=detalleevaluacionnomi.getrespuesta_valor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleEvaluacionNomiConstantesFunciones.RESPUESTAVALOR);
		datoGeneral.setsDescripcion(DetalleEvaluacionNomiConstantesFunciones.LABEL_RESPUESTAVALOR);
		datoGeneral.setdValorDouble(respuesta_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleEvaluacionNomi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleEvaluacionNomiConstantesFunciones.LABEL_ID, DetalleEvaluacionNomiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionNomiConstantesFunciones.LABEL_VERSIONROW, DetalleEvaluacionNomiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionNomiConstantesFunciones.LABEL_IDEMPRESA, DetalleEvaluacionNomiConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionNomiConstantesFunciones.LABEL_IDEVALUACIONNOMI, DetalleEvaluacionNomiConstantesFunciones.IDEVALUACIONNOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionNomiConstantesFunciones.LABEL_IDFORMATONOMI, DetalleEvaluacionNomiConstantesFunciones.IDFORMATONOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionNomiConstantesFunciones.LABEL_IDPREGUNTANOMI, DetalleEvaluacionNomiConstantesFunciones.IDPREGUNTANOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionNomiConstantesFunciones.LABEL_RESPUESTA, DetalleEvaluacionNomiConstantesFunciones.RESPUESTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionNomiConstantesFunciones.LABEL_RESPUESTAVALOR, DetalleEvaluacionNomiConstantesFunciones.RESPUESTAVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA1, DetalleEvaluacionNomiConstantesFunciones.CALIFICA1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA2, DetalleEvaluacionNomiConstantesFunciones.CALIFICA2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA3, DetalleEvaluacionNomiConstantesFunciones.CALIFICA3,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA4, DetalleEvaluacionNomiConstantesFunciones.CALIFICA4,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA5, DetalleEvaluacionNomiConstantesFunciones.CALIFICA5,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA6, DetalleEvaluacionNomiConstantesFunciones.CALIFICA6,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA7, DetalleEvaluacionNomiConstantesFunciones.CALIFICA7,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA8, DetalleEvaluacionNomiConstantesFunciones.CALIFICA8,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA9, DetalleEvaluacionNomiConstantesFunciones.CALIFICA9,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA10, DetalleEvaluacionNomiConstantesFunciones.CALIFICA10,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleEvaluacionNomi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionNomiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionNomiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionNomiConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionNomiConstantesFunciones.IDEVALUACIONNOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionNomiConstantesFunciones.IDFORMATONOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionNomiConstantesFunciones.IDPREGUNTANOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionNomiConstantesFunciones.RESPUESTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionNomiConstantesFunciones.RESPUESTAVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionNomiConstantesFunciones.CALIFICA1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionNomiConstantesFunciones.CALIFICA2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionNomiConstantesFunciones.CALIFICA3;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionNomiConstantesFunciones.CALIFICA4;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionNomiConstantesFunciones.CALIFICA5;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionNomiConstantesFunciones.CALIFICA6;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionNomiConstantesFunciones.CALIFICA7;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionNomiConstantesFunciones.CALIFICA8;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionNomiConstantesFunciones.CALIFICA9;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionNomiConstantesFunciones.CALIFICA10;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleEvaluacionNomi() throws Exception  {
		return DetalleEvaluacionNomiConstantesFunciones.getTiposSeleccionarDetalleEvaluacionNomi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleEvaluacionNomi(Boolean conFk) throws Exception  {
		return DetalleEvaluacionNomiConstantesFunciones.getTiposSeleccionarDetalleEvaluacionNomi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleEvaluacionNomi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionNomiConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleEvaluacionNomiConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionNomiConstantesFunciones.LABEL_IDEVALUACIONNOMI);
			reporte.setsDescripcion(DetalleEvaluacionNomiConstantesFunciones.LABEL_IDEVALUACIONNOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionNomiConstantesFunciones.LABEL_IDFORMATONOMI);
			reporte.setsDescripcion(DetalleEvaluacionNomiConstantesFunciones.LABEL_IDFORMATONOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionNomiConstantesFunciones.LABEL_IDPREGUNTANOMI);
			reporte.setsDescripcion(DetalleEvaluacionNomiConstantesFunciones.LABEL_IDPREGUNTANOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionNomiConstantesFunciones.LABEL_RESPUESTA);
			reporte.setsDescripcion(DetalleEvaluacionNomiConstantesFunciones.LABEL_RESPUESTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionNomiConstantesFunciones.LABEL_RESPUESTAVALOR);
			reporte.setsDescripcion(DetalleEvaluacionNomiConstantesFunciones.LABEL_RESPUESTAVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA1);
			reporte.setsDescripcion(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA2);
			reporte.setsDescripcion(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA3);
			reporte.setsDescripcion(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA3);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA4);
			reporte.setsDescripcion(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA4);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA5);
			reporte.setsDescripcion(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA5);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA6);
			reporte.setsDescripcion(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA6);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA7);
			reporte.setsDescripcion(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA7);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA8);
			reporte.setsDescripcion(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA8);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA9);
			reporte.setsDescripcion(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA9);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA10);
			reporte.setsDescripcion(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA10);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleEvaluacionNomi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(DetalleEvaluacionNomi detalleevaluacionnomiAux) throws Exception {
		
			detalleevaluacionnomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleevaluacionnomiAux.getEmpresa()));
			detalleevaluacionnomiAux.setevaluacionnomi_descripcion(EvaluacionNomiConstantesFunciones.getEvaluacionNomiDescripcion(detalleevaluacionnomiAux.getEvaluacionNomi()));
			detalleevaluacionnomiAux.setformatonomi_descripcion(FormatoNomiConstantesFunciones.getFormatoNomiDescripcion(detalleevaluacionnomiAux.getFormatoNomi()));
			detalleevaluacionnomiAux.setpreguntanomi_descripcion(PreguntaNomiConstantesFunciones.getPreguntaNomiDescripcion(detalleevaluacionnomiAux.getPreguntaNomi()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(List<DetalleEvaluacionNomi> detalleevaluacionnomisTemp) throws Exception {
		for(DetalleEvaluacionNomi detalleevaluacionnomiAux:detalleevaluacionnomisTemp) {
			
			detalleevaluacionnomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleevaluacionnomiAux.getEmpresa()));
			detalleevaluacionnomiAux.setevaluacionnomi_descripcion(EvaluacionNomiConstantesFunciones.getEvaluacionNomiDescripcion(detalleevaluacionnomiAux.getEvaluacionNomi()));
			detalleevaluacionnomiAux.setformatonomi_descripcion(FormatoNomiConstantesFunciones.getFormatoNomiDescripcion(detalleevaluacionnomiAux.getFormatoNomi()));
			detalleevaluacionnomiAux.setpreguntanomi_descripcion(PreguntaNomiConstantesFunciones.getPreguntaNomiDescripcion(detalleevaluacionnomiAux.getPreguntaNomi()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleEvaluacionNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(EvaluacionNomi.class));
				classes.add(new Classe(FormatoNomi.class));
				classes.add(new Classe(PreguntaNomi.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EvaluacionNomi.class)) {
						classes.add(new Classe(EvaluacionNomi.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FormatoNomi.class)) {
						classes.add(new Classe(FormatoNomi.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PreguntaNomi.class)) {
						classes.add(new Classe(PreguntaNomi.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleEvaluacionNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(EvaluacionNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EvaluacionNomi.class)); continue;
					}

					if(FormatoNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomi.class)); continue;
					}

					if(PreguntaNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PreguntaNomi.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(EvaluacionNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EvaluacionNomi.class)); continue;
					}

					if(FormatoNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomi.class)); continue;
					}

					if(PreguntaNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PreguntaNomi.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleEvaluacionNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleEvaluacionNomiConstantesFunciones.getClassesRelationshipsOfDetalleEvaluacionNomi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleEvaluacionNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleEvaluacionNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleEvaluacionNomiConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleEvaluacionNomi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleEvaluacionNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleEvaluacionNomi detalleevaluacionnomi,List<DetalleEvaluacionNomi> detalleevaluacionnomis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleEvaluacionNomi detalleevaluacionnomiEncontrado=null;
			
			for(DetalleEvaluacionNomi detalleevaluacionnomiLocal:detalleevaluacionnomis) {
				if(detalleevaluacionnomiLocal.getId().equals(detalleevaluacionnomi.getId())) {
					detalleevaluacionnomiEncontrado=detalleevaluacionnomiLocal;
					
					detalleevaluacionnomiLocal.setIsChanged(detalleevaluacionnomi.getIsChanged());
					detalleevaluacionnomiLocal.setIsNew(detalleevaluacionnomi.getIsNew());
					detalleevaluacionnomiLocal.setIsDeleted(detalleevaluacionnomi.getIsDeleted());
					
					detalleevaluacionnomiLocal.setGeneralEntityOriginal(detalleevaluacionnomi.getGeneralEntityOriginal());
					
					detalleevaluacionnomiLocal.setId(detalleevaluacionnomi.getId());	
					detalleevaluacionnomiLocal.setVersionRow(detalleevaluacionnomi.getVersionRow());	
					detalleevaluacionnomiLocal.setid_empresa(detalleevaluacionnomi.getid_empresa());	
					detalleevaluacionnomiLocal.setid_evaluacion_nomi(detalleevaluacionnomi.getid_evaluacion_nomi());	
					detalleevaluacionnomiLocal.setid_formato_nomi(detalleevaluacionnomi.getid_formato_nomi());	
					detalleevaluacionnomiLocal.setid_pregunta_nomi(detalleevaluacionnomi.getid_pregunta_nomi());	
					detalleevaluacionnomiLocal.setrespuesta(detalleevaluacionnomi.getrespuesta());	
					detalleevaluacionnomiLocal.setrespuesta_valor(detalleevaluacionnomi.getrespuesta_valor());	
					detalleevaluacionnomiLocal.setcalifica1(detalleevaluacionnomi.getcalifica1());	
					detalleevaluacionnomiLocal.setcalifica2(detalleevaluacionnomi.getcalifica2());	
					detalleevaluacionnomiLocal.setcalifica3(detalleevaluacionnomi.getcalifica3());	
					detalleevaluacionnomiLocal.setcalifica4(detalleevaluacionnomi.getcalifica4());	
					detalleevaluacionnomiLocal.setcalifica5(detalleevaluacionnomi.getcalifica5());	
					detalleevaluacionnomiLocal.setcalifica6(detalleevaluacionnomi.getcalifica6());	
					detalleevaluacionnomiLocal.setcalifica7(detalleevaluacionnomi.getcalifica7());	
					detalleevaluacionnomiLocal.setcalifica8(detalleevaluacionnomi.getcalifica8());	
					detalleevaluacionnomiLocal.setcalifica9(detalleevaluacionnomi.getcalifica9());	
					detalleevaluacionnomiLocal.setcalifica10(detalleevaluacionnomi.getcalifica10());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detalleevaluacionnomi.getIsDeleted()) {
				if(!existe) {
					detalleevaluacionnomis.add(detalleevaluacionnomi);
				}
			} else {
				if(detalleevaluacionnomiEncontrado!=null && permiteQuitar)  {
					detalleevaluacionnomis.remove(detalleevaluacionnomiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleEvaluacionNomi detalleevaluacionnomi,List<DetalleEvaluacionNomi> detalleevaluacionnomis) throws Exception {
		try	{			
			for(DetalleEvaluacionNomi detalleevaluacionnomiLocal:detalleevaluacionnomis) {
				if(detalleevaluacionnomiLocal.getId().equals(detalleevaluacionnomi.getId())) {
					detalleevaluacionnomiLocal.setIsSelected(detalleevaluacionnomi.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleEvaluacionNomi(List<DetalleEvaluacionNomi> detalleevaluacionnomisAux) throws Exception {
		//this.detalleevaluacionnomisAux=detalleevaluacionnomisAux;
		
		for(DetalleEvaluacionNomi detalleevaluacionnomiAux:detalleevaluacionnomisAux) {
			if(detalleevaluacionnomiAux.getIsChanged()) {
				detalleevaluacionnomiAux.setIsChanged(false);
			}		
			
			if(detalleevaluacionnomiAux.getIsNew()) {
				detalleevaluacionnomiAux.setIsNew(false);
			}	
			
			if(detalleevaluacionnomiAux.getIsDeleted()) {
				detalleevaluacionnomiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleEvaluacionNomi(DetalleEvaluacionNomi detalleevaluacionnomiAux) throws Exception {
		//this.detalleevaluacionnomiAux=detalleevaluacionnomiAux;
		
			if(detalleevaluacionnomiAux.getIsChanged()) {
				detalleevaluacionnomiAux.setIsChanged(false);
			}		
			
			if(detalleevaluacionnomiAux.getIsNew()) {
				detalleevaluacionnomiAux.setIsNew(false);
			}	
			
			if(detalleevaluacionnomiAux.getIsDeleted()) {
				detalleevaluacionnomiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleEvaluacionNomi detalleevaluacionnomiAsignar,DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		detalleevaluacionnomiAsignar.setId(detalleevaluacionnomi.getId());	
		detalleevaluacionnomiAsignar.setVersionRow(detalleevaluacionnomi.getVersionRow());	
		detalleevaluacionnomiAsignar.setid_empresa(detalleevaluacionnomi.getid_empresa());
		detalleevaluacionnomiAsignar.setempresa_descripcion(detalleevaluacionnomi.getempresa_descripcion());	
		detalleevaluacionnomiAsignar.setid_evaluacion_nomi(detalleevaluacionnomi.getid_evaluacion_nomi());
		detalleevaluacionnomiAsignar.setevaluacionnomi_descripcion(detalleevaluacionnomi.getevaluacionnomi_descripcion());	
		detalleevaluacionnomiAsignar.setid_formato_nomi(detalleevaluacionnomi.getid_formato_nomi());
		detalleevaluacionnomiAsignar.setformatonomi_descripcion(detalleevaluacionnomi.getformatonomi_descripcion());	
		detalleevaluacionnomiAsignar.setid_pregunta_nomi(detalleevaluacionnomi.getid_pregunta_nomi());
		detalleevaluacionnomiAsignar.setpreguntanomi_descripcion(detalleevaluacionnomi.getpreguntanomi_descripcion());	
		detalleevaluacionnomiAsignar.setrespuesta(detalleevaluacionnomi.getrespuesta());	
		detalleevaluacionnomiAsignar.setrespuesta_valor(detalleevaluacionnomi.getrespuesta_valor());	
		detalleevaluacionnomiAsignar.setcalifica1(detalleevaluacionnomi.getcalifica1());	
		detalleevaluacionnomiAsignar.setcalifica2(detalleevaluacionnomi.getcalifica2());	
		detalleevaluacionnomiAsignar.setcalifica3(detalleevaluacionnomi.getcalifica3());	
		detalleevaluacionnomiAsignar.setcalifica4(detalleevaluacionnomi.getcalifica4());	
		detalleevaluacionnomiAsignar.setcalifica5(detalleevaluacionnomi.getcalifica5());	
		detalleevaluacionnomiAsignar.setcalifica6(detalleevaluacionnomi.getcalifica6());	
		detalleevaluacionnomiAsignar.setcalifica7(detalleevaluacionnomi.getcalifica7());	
		detalleevaluacionnomiAsignar.setcalifica8(detalleevaluacionnomi.getcalifica8());	
		detalleevaluacionnomiAsignar.setcalifica9(detalleevaluacionnomi.getcalifica9());	
		detalleevaluacionnomiAsignar.setcalifica10(detalleevaluacionnomi.getcalifica10());	
	}
	
	public static void inicializarDetalleEvaluacionNomi(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		try {
				detalleevaluacionnomi.setId(0L);	
					
				detalleevaluacionnomi.setid_empresa(-1L);	
				detalleevaluacionnomi.setid_evaluacion_nomi(-1L);	
				detalleevaluacionnomi.setid_formato_nomi(-1L);	
				detalleevaluacionnomi.setid_pregunta_nomi(-1L);	
				detalleevaluacionnomi.setrespuesta("");	
				detalleevaluacionnomi.setrespuesta_valor(0.0);	
				detalleevaluacionnomi.setcalifica1(false);	
				detalleevaluacionnomi.setcalifica2(false);	
				detalleevaluacionnomi.setcalifica3(false);	
				detalleevaluacionnomi.setcalifica4(false);	
				detalleevaluacionnomi.setcalifica5(false);	
				detalleevaluacionnomi.setcalifica6(false);	
				detalleevaluacionnomi.setcalifica7(false);	
				detalleevaluacionnomi.setcalifica8(false);	
				detalleevaluacionnomi.setcalifica9(false);	
				detalleevaluacionnomi.setcalifica10(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleEvaluacionNomi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionNomiConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionNomiConstantesFunciones.LABEL_IDEVALUACIONNOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionNomiConstantesFunciones.LABEL_IDFORMATONOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionNomiConstantesFunciones.LABEL_IDPREGUNTANOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionNomiConstantesFunciones.LABEL_RESPUESTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionNomiConstantesFunciones.LABEL_RESPUESTAVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA3);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA4);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA5);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA6);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA7);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA8);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA9);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionNomiConstantesFunciones.LABEL_CALIFICA10);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleEvaluacionNomi(String sTipo,Row row,Workbook workbook,DetalleEvaluacionNomi detalleevaluacionnomi,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleevaluacionnomi.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleevaluacionnomi.getevaluacionnomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleevaluacionnomi.getformatonomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleevaluacionnomi.getpreguntanomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleevaluacionnomi.getrespuesta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleevaluacionnomi.getrespuesta_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detalleevaluacionnomi.getcalifica1()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detalleevaluacionnomi.getcalifica2()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detalleevaluacionnomi.getcalifica3()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detalleevaluacionnomi.getcalifica4()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detalleevaluacionnomi.getcalifica5()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detalleevaluacionnomi.getcalifica6()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detalleevaluacionnomi.getcalifica7()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detalleevaluacionnomi.getcalifica8()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detalleevaluacionnomi.getcalifica9()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detalleevaluacionnomi.getcalifica10()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleEvaluacionNomi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleEvaluacionNomi() {
		return this.sFinalQueryDetalleEvaluacionNomi;
	}
	
	public void setsFinalQueryDetalleEvaluacionNomi(String sFinalQueryDetalleEvaluacionNomi) {
		this.sFinalQueryDetalleEvaluacionNomi= sFinalQueryDetalleEvaluacionNomi;
	}
	
	public Border resaltarSeleccionarDetalleEvaluacionNomi=null;
	
	public Border setResaltarSeleccionarDetalleEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detalleevaluacionnomiBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleEvaluacionNomi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleEvaluacionNomi() {
		return this.resaltarSeleccionarDetalleEvaluacionNomi;
	}
	
	public void setResaltarSeleccionarDetalleEvaluacionNomi(Border borderResaltarSeleccionarDetalleEvaluacionNomi) {
		this.resaltarSeleccionarDetalleEvaluacionNomi= borderResaltarSeleccionarDetalleEvaluacionNomi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleEvaluacionNomi=null;
	public Boolean mostraridDetalleEvaluacionNomi=true;
	public Boolean activaridDetalleEvaluacionNomi=true;

	public Border resaltarid_empresaDetalleEvaluacionNomi=null;
	public Boolean mostrarid_empresaDetalleEvaluacionNomi=true;
	public Boolean activarid_empresaDetalleEvaluacionNomi=true;
	public Boolean cargarid_empresaDetalleEvaluacionNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleEvaluacionNomi=false;//ConEventDepend=true

	public Border resaltarid_evaluacion_nomiDetalleEvaluacionNomi=null;
	public Boolean mostrarid_evaluacion_nomiDetalleEvaluacionNomi=true;
	public Boolean activarid_evaluacion_nomiDetalleEvaluacionNomi=true;
	public Boolean cargarid_evaluacion_nomiDetalleEvaluacionNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_evaluacion_nomiDetalleEvaluacionNomi=false;//ConEventDepend=true

	public Border resaltarid_formato_nomiDetalleEvaluacionNomi=null;
	public Boolean mostrarid_formato_nomiDetalleEvaluacionNomi=true;
	public Boolean activarid_formato_nomiDetalleEvaluacionNomi=true;
	public Boolean cargarid_formato_nomiDetalleEvaluacionNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_nomiDetalleEvaluacionNomi=false;//ConEventDepend=true

	public Border resaltarid_pregunta_nomiDetalleEvaluacionNomi=null;
	public Boolean mostrarid_pregunta_nomiDetalleEvaluacionNomi=true;
	public Boolean activarid_pregunta_nomiDetalleEvaluacionNomi=true;
	public Boolean cargarid_pregunta_nomiDetalleEvaluacionNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_pregunta_nomiDetalleEvaluacionNomi=false;//ConEventDepend=true

	public Border resaltarrespuestaDetalleEvaluacionNomi=null;
	public Boolean mostrarrespuestaDetalleEvaluacionNomi=true;
	public Boolean activarrespuestaDetalleEvaluacionNomi=true;

	public Border resaltarrespuesta_valorDetalleEvaluacionNomi=null;
	public Boolean mostrarrespuesta_valorDetalleEvaluacionNomi=true;
	public Boolean activarrespuesta_valorDetalleEvaluacionNomi=true;

	public Border resaltarcalifica1DetalleEvaluacionNomi=null;
	public Boolean mostrarcalifica1DetalleEvaluacionNomi=true;
	public Boolean activarcalifica1DetalleEvaluacionNomi=true;

	public Border resaltarcalifica2DetalleEvaluacionNomi=null;
	public Boolean mostrarcalifica2DetalleEvaluacionNomi=true;
	public Boolean activarcalifica2DetalleEvaluacionNomi=true;

	public Border resaltarcalifica3DetalleEvaluacionNomi=null;
	public Boolean mostrarcalifica3DetalleEvaluacionNomi=true;
	public Boolean activarcalifica3DetalleEvaluacionNomi=true;

	public Border resaltarcalifica4DetalleEvaluacionNomi=null;
	public Boolean mostrarcalifica4DetalleEvaluacionNomi=true;
	public Boolean activarcalifica4DetalleEvaluacionNomi=true;

	public Border resaltarcalifica5DetalleEvaluacionNomi=null;
	public Boolean mostrarcalifica5DetalleEvaluacionNomi=true;
	public Boolean activarcalifica5DetalleEvaluacionNomi=true;

	public Border resaltarcalifica6DetalleEvaluacionNomi=null;
	public Boolean mostrarcalifica6DetalleEvaluacionNomi=true;
	public Boolean activarcalifica6DetalleEvaluacionNomi=true;

	public Border resaltarcalifica7DetalleEvaluacionNomi=null;
	public Boolean mostrarcalifica7DetalleEvaluacionNomi=true;
	public Boolean activarcalifica7DetalleEvaluacionNomi=true;

	public Border resaltarcalifica8DetalleEvaluacionNomi=null;
	public Boolean mostrarcalifica8DetalleEvaluacionNomi=true;
	public Boolean activarcalifica8DetalleEvaluacionNomi=true;

	public Border resaltarcalifica9DetalleEvaluacionNomi=null;
	public Boolean mostrarcalifica9DetalleEvaluacionNomi=true;
	public Boolean activarcalifica9DetalleEvaluacionNomi=true;

	public Border resaltarcalifica10DetalleEvaluacionNomi=null;
	public Boolean mostrarcalifica10DetalleEvaluacionNomi=true;
	public Boolean activarcalifica10DetalleEvaluacionNomi=true;

	
	

	public Border setResaltaridDetalleEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionnomiBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltaridDetalleEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleEvaluacionNomi() {
		return this.resaltaridDetalleEvaluacionNomi;
	}

	public void setResaltaridDetalleEvaluacionNomi(Border borderResaltar) {
		this.resaltaridDetalleEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostraridDetalleEvaluacionNomi() {
		return this.mostraridDetalleEvaluacionNomi;
	}

	public void setMostraridDetalleEvaluacionNomi(Boolean mostraridDetalleEvaluacionNomi) {
		this.mostraridDetalleEvaluacionNomi= mostraridDetalleEvaluacionNomi;
	}

	public Boolean getActivaridDetalleEvaluacionNomi() {
		return this.activaridDetalleEvaluacionNomi;
	}

	public void setActivaridDetalleEvaluacionNomi(Boolean activaridDetalleEvaluacionNomi) {
		this.activaridDetalleEvaluacionNomi= activaridDetalleEvaluacionNomi;
	}

	public Border setResaltarid_empresaDetalleEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionnomiBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleEvaluacionNomi() {
		return this.resaltarid_empresaDetalleEvaluacionNomi;
	}

	public void setResaltarid_empresaDetalleEvaluacionNomi(Border borderResaltar) {
		this.resaltarid_empresaDetalleEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleEvaluacionNomi() {
		return this.mostrarid_empresaDetalleEvaluacionNomi;
	}

	public void setMostrarid_empresaDetalleEvaluacionNomi(Boolean mostrarid_empresaDetalleEvaluacionNomi) {
		this.mostrarid_empresaDetalleEvaluacionNomi= mostrarid_empresaDetalleEvaluacionNomi;
	}

	public Boolean getActivarid_empresaDetalleEvaluacionNomi() {
		return this.activarid_empresaDetalleEvaluacionNomi;
	}

	public void setActivarid_empresaDetalleEvaluacionNomi(Boolean activarid_empresaDetalleEvaluacionNomi) {
		this.activarid_empresaDetalleEvaluacionNomi= activarid_empresaDetalleEvaluacionNomi;
	}

	public Boolean getCargarid_empresaDetalleEvaluacionNomi() {
		return this.cargarid_empresaDetalleEvaluacionNomi;
	}

	public void setCargarid_empresaDetalleEvaluacionNomi(Boolean cargarid_empresaDetalleEvaluacionNomi) {
		this.cargarid_empresaDetalleEvaluacionNomi= cargarid_empresaDetalleEvaluacionNomi;
	}

	public Border setResaltarid_evaluacion_nomiDetalleEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionnomiBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarid_evaluacion_nomiDetalleEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_evaluacion_nomiDetalleEvaluacionNomi() {
		return this.resaltarid_evaluacion_nomiDetalleEvaluacionNomi;
	}

	public void setResaltarid_evaluacion_nomiDetalleEvaluacionNomi(Border borderResaltar) {
		this.resaltarid_evaluacion_nomiDetalleEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarid_evaluacion_nomiDetalleEvaluacionNomi() {
		return this.mostrarid_evaluacion_nomiDetalleEvaluacionNomi;
	}

	public void setMostrarid_evaluacion_nomiDetalleEvaluacionNomi(Boolean mostrarid_evaluacion_nomiDetalleEvaluacionNomi) {
		this.mostrarid_evaluacion_nomiDetalleEvaluacionNomi= mostrarid_evaluacion_nomiDetalleEvaluacionNomi;
	}

	public Boolean getActivarid_evaluacion_nomiDetalleEvaluacionNomi() {
		return this.activarid_evaluacion_nomiDetalleEvaluacionNomi;
	}

	public void setActivarid_evaluacion_nomiDetalleEvaluacionNomi(Boolean activarid_evaluacion_nomiDetalleEvaluacionNomi) {
		this.activarid_evaluacion_nomiDetalleEvaluacionNomi= activarid_evaluacion_nomiDetalleEvaluacionNomi;
	}

	public Boolean getCargarid_evaluacion_nomiDetalleEvaluacionNomi() {
		return this.cargarid_evaluacion_nomiDetalleEvaluacionNomi;
	}

	public void setCargarid_evaluacion_nomiDetalleEvaluacionNomi(Boolean cargarid_evaluacion_nomiDetalleEvaluacionNomi) {
		this.cargarid_evaluacion_nomiDetalleEvaluacionNomi= cargarid_evaluacion_nomiDetalleEvaluacionNomi;
	}

	public Border setResaltarid_formato_nomiDetalleEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionnomiBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarid_formato_nomiDetalleEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_nomiDetalleEvaluacionNomi() {
		return this.resaltarid_formato_nomiDetalleEvaluacionNomi;
	}

	public void setResaltarid_formato_nomiDetalleEvaluacionNomi(Border borderResaltar) {
		this.resaltarid_formato_nomiDetalleEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarid_formato_nomiDetalleEvaluacionNomi() {
		return this.mostrarid_formato_nomiDetalleEvaluacionNomi;
	}

	public void setMostrarid_formato_nomiDetalleEvaluacionNomi(Boolean mostrarid_formato_nomiDetalleEvaluacionNomi) {
		this.mostrarid_formato_nomiDetalleEvaluacionNomi= mostrarid_formato_nomiDetalleEvaluacionNomi;
	}

	public Boolean getActivarid_formato_nomiDetalleEvaluacionNomi() {
		return this.activarid_formato_nomiDetalleEvaluacionNomi;
	}

	public void setActivarid_formato_nomiDetalleEvaluacionNomi(Boolean activarid_formato_nomiDetalleEvaluacionNomi) {
		this.activarid_formato_nomiDetalleEvaluacionNomi= activarid_formato_nomiDetalleEvaluacionNomi;
	}

	public Boolean getCargarid_formato_nomiDetalleEvaluacionNomi() {
		return this.cargarid_formato_nomiDetalleEvaluacionNomi;
	}

	public void setCargarid_formato_nomiDetalleEvaluacionNomi(Boolean cargarid_formato_nomiDetalleEvaluacionNomi) {
		this.cargarid_formato_nomiDetalleEvaluacionNomi= cargarid_formato_nomiDetalleEvaluacionNomi;
	}

	public Border setResaltarid_pregunta_nomiDetalleEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionnomiBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarid_pregunta_nomiDetalleEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_pregunta_nomiDetalleEvaluacionNomi() {
		return this.resaltarid_pregunta_nomiDetalleEvaluacionNomi;
	}

	public void setResaltarid_pregunta_nomiDetalleEvaluacionNomi(Border borderResaltar) {
		this.resaltarid_pregunta_nomiDetalleEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarid_pregunta_nomiDetalleEvaluacionNomi() {
		return this.mostrarid_pregunta_nomiDetalleEvaluacionNomi;
	}

	public void setMostrarid_pregunta_nomiDetalleEvaluacionNomi(Boolean mostrarid_pregunta_nomiDetalleEvaluacionNomi) {
		this.mostrarid_pregunta_nomiDetalleEvaluacionNomi= mostrarid_pregunta_nomiDetalleEvaluacionNomi;
	}

	public Boolean getActivarid_pregunta_nomiDetalleEvaluacionNomi() {
		return this.activarid_pregunta_nomiDetalleEvaluacionNomi;
	}

	public void setActivarid_pregunta_nomiDetalleEvaluacionNomi(Boolean activarid_pregunta_nomiDetalleEvaluacionNomi) {
		this.activarid_pregunta_nomiDetalleEvaluacionNomi= activarid_pregunta_nomiDetalleEvaluacionNomi;
	}

	public Boolean getCargarid_pregunta_nomiDetalleEvaluacionNomi() {
		return this.cargarid_pregunta_nomiDetalleEvaluacionNomi;
	}

	public void setCargarid_pregunta_nomiDetalleEvaluacionNomi(Boolean cargarid_pregunta_nomiDetalleEvaluacionNomi) {
		this.cargarid_pregunta_nomiDetalleEvaluacionNomi= cargarid_pregunta_nomiDetalleEvaluacionNomi;
	}

	public Border setResaltarrespuestaDetalleEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionnomiBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarrespuestaDetalleEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrespuestaDetalleEvaluacionNomi() {
		return this.resaltarrespuestaDetalleEvaluacionNomi;
	}

	public void setResaltarrespuestaDetalleEvaluacionNomi(Border borderResaltar) {
		this.resaltarrespuestaDetalleEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarrespuestaDetalleEvaluacionNomi() {
		return this.mostrarrespuestaDetalleEvaluacionNomi;
	}

	public void setMostrarrespuestaDetalleEvaluacionNomi(Boolean mostrarrespuestaDetalleEvaluacionNomi) {
		this.mostrarrespuestaDetalleEvaluacionNomi= mostrarrespuestaDetalleEvaluacionNomi;
	}

	public Boolean getActivarrespuestaDetalleEvaluacionNomi() {
		return this.activarrespuestaDetalleEvaluacionNomi;
	}

	public void setActivarrespuestaDetalleEvaluacionNomi(Boolean activarrespuestaDetalleEvaluacionNomi) {
		this.activarrespuestaDetalleEvaluacionNomi= activarrespuestaDetalleEvaluacionNomi;
	}

	public Border setResaltarrespuesta_valorDetalleEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionnomiBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarrespuesta_valorDetalleEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrespuesta_valorDetalleEvaluacionNomi() {
		return this.resaltarrespuesta_valorDetalleEvaluacionNomi;
	}

	public void setResaltarrespuesta_valorDetalleEvaluacionNomi(Border borderResaltar) {
		this.resaltarrespuesta_valorDetalleEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarrespuesta_valorDetalleEvaluacionNomi() {
		return this.mostrarrespuesta_valorDetalleEvaluacionNomi;
	}

	public void setMostrarrespuesta_valorDetalleEvaluacionNomi(Boolean mostrarrespuesta_valorDetalleEvaluacionNomi) {
		this.mostrarrespuesta_valorDetalleEvaluacionNomi= mostrarrespuesta_valorDetalleEvaluacionNomi;
	}

	public Boolean getActivarrespuesta_valorDetalleEvaluacionNomi() {
		return this.activarrespuesta_valorDetalleEvaluacionNomi;
	}

	public void setActivarrespuesta_valorDetalleEvaluacionNomi(Boolean activarrespuesta_valorDetalleEvaluacionNomi) {
		this.activarrespuesta_valorDetalleEvaluacionNomi= activarrespuesta_valorDetalleEvaluacionNomi;
	}

	public Border setResaltarcalifica1DetalleEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionnomiBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarcalifica1DetalleEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcalifica1DetalleEvaluacionNomi() {
		return this.resaltarcalifica1DetalleEvaluacionNomi;
	}

	public void setResaltarcalifica1DetalleEvaluacionNomi(Border borderResaltar) {
		this.resaltarcalifica1DetalleEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarcalifica1DetalleEvaluacionNomi() {
		return this.mostrarcalifica1DetalleEvaluacionNomi;
	}

	public void setMostrarcalifica1DetalleEvaluacionNomi(Boolean mostrarcalifica1DetalleEvaluacionNomi) {
		this.mostrarcalifica1DetalleEvaluacionNomi= mostrarcalifica1DetalleEvaluacionNomi;
	}

	public Boolean getActivarcalifica1DetalleEvaluacionNomi() {
		return this.activarcalifica1DetalleEvaluacionNomi;
	}

	public void setActivarcalifica1DetalleEvaluacionNomi(Boolean activarcalifica1DetalleEvaluacionNomi) {
		this.activarcalifica1DetalleEvaluacionNomi= activarcalifica1DetalleEvaluacionNomi;
	}

	public Border setResaltarcalifica2DetalleEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionnomiBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarcalifica2DetalleEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcalifica2DetalleEvaluacionNomi() {
		return this.resaltarcalifica2DetalleEvaluacionNomi;
	}

	public void setResaltarcalifica2DetalleEvaluacionNomi(Border borderResaltar) {
		this.resaltarcalifica2DetalleEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarcalifica2DetalleEvaluacionNomi() {
		return this.mostrarcalifica2DetalleEvaluacionNomi;
	}

	public void setMostrarcalifica2DetalleEvaluacionNomi(Boolean mostrarcalifica2DetalleEvaluacionNomi) {
		this.mostrarcalifica2DetalleEvaluacionNomi= mostrarcalifica2DetalleEvaluacionNomi;
	}

	public Boolean getActivarcalifica2DetalleEvaluacionNomi() {
		return this.activarcalifica2DetalleEvaluacionNomi;
	}

	public void setActivarcalifica2DetalleEvaluacionNomi(Boolean activarcalifica2DetalleEvaluacionNomi) {
		this.activarcalifica2DetalleEvaluacionNomi= activarcalifica2DetalleEvaluacionNomi;
	}

	public Border setResaltarcalifica3DetalleEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionnomiBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarcalifica3DetalleEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcalifica3DetalleEvaluacionNomi() {
		return this.resaltarcalifica3DetalleEvaluacionNomi;
	}

	public void setResaltarcalifica3DetalleEvaluacionNomi(Border borderResaltar) {
		this.resaltarcalifica3DetalleEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarcalifica3DetalleEvaluacionNomi() {
		return this.mostrarcalifica3DetalleEvaluacionNomi;
	}

	public void setMostrarcalifica3DetalleEvaluacionNomi(Boolean mostrarcalifica3DetalleEvaluacionNomi) {
		this.mostrarcalifica3DetalleEvaluacionNomi= mostrarcalifica3DetalleEvaluacionNomi;
	}

	public Boolean getActivarcalifica3DetalleEvaluacionNomi() {
		return this.activarcalifica3DetalleEvaluacionNomi;
	}

	public void setActivarcalifica3DetalleEvaluacionNomi(Boolean activarcalifica3DetalleEvaluacionNomi) {
		this.activarcalifica3DetalleEvaluacionNomi= activarcalifica3DetalleEvaluacionNomi;
	}

	public Border setResaltarcalifica4DetalleEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionnomiBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarcalifica4DetalleEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcalifica4DetalleEvaluacionNomi() {
		return this.resaltarcalifica4DetalleEvaluacionNomi;
	}

	public void setResaltarcalifica4DetalleEvaluacionNomi(Border borderResaltar) {
		this.resaltarcalifica4DetalleEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarcalifica4DetalleEvaluacionNomi() {
		return this.mostrarcalifica4DetalleEvaluacionNomi;
	}

	public void setMostrarcalifica4DetalleEvaluacionNomi(Boolean mostrarcalifica4DetalleEvaluacionNomi) {
		this.mostrarcalifica4DetalleEvaluacionNomi= mostrarcalifica4DetalleEvaluacionNomi;
	}

	public Boolean getActivarcalifica4DetalleEvaluacionNomi() {
		return this.activarcalifica4DetalleEvaluacionNomi;
	}

	public void setActivarcalifica4DetalleEvaluacionNomi(Boolean activarcalifica4DetalleEvaluacionNomi) {
		this.activarcalifica4DetalleEvaluacionNomi= activarcalifica4DetalleEvaluacionNomi;
	}

	public Border setResaltarcalifica5DetalleEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionnomiBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarcalifica5DetalleEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcalifica5DetalleEvaluacionNomi() {
		return this.resaltarcalifica5DetalleEvaluacionNomi;
	}

	public void setResaltarcalifica5DetalleEvaluacionNomi(Border borderResaltar) {
		this.resaltarcalifica5DetalleEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarcalifica5DetalleEvaluacionNomi() {
		return this.mostrarcalifica5DetalleEvaluacionNomi;
	}

	public void setMostrarcalifica5DetalleEvaluacionNomi(Boolean mostrarcalifica5DetalleEvaluacionNomi) {
		this.mostrarcalifica5DetalleEvaluacionNomi= mostrarcalifica5DetalleEvaluacionNomi;
	}

	public Boolean getActivarcalifica5DetalleEvaluacionNomi() {
		return this.activarcalifica5DetalleEvaluacionNomi;
	}

	public void setActivarcalifica5DetalleEvaluacionNomi(Boolean activarcalifica5DetalleEvaluacionNomi) {
		this.activarcalifica5DetalleEvaluacionNomi= activarcalifica5DetalleEvaluacionNomi;
	}

	public Border setResaltarcalifica6DetalleEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionnomiBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarcalifica6DetalleEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcalifica6DetalleEvaluacionNomi() {
		return this.resaltarcalifica6DetalleEvaluacionNomi;
	}

	public void setResaltarcalifica6DetalleEvaluacionNomi(Border borderResaltar) {
		this.resaltarcalifica6DetalleEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarcalifica6DetalleEvaluacionNomi() {
		return this.mostrarcalifica6DetalleEvaluacionNomi;
	}

	public void setMostrarcalifica6DetalleEvaluacionNomi(Boolean mostrarcalifica6DetalleEvaluacionNomi) {
		this.mostrarcalifica6DetalleEvaluacionNomi= mostrarcalifica6DetalleEvaluacionNomi;
	}

	public Boolean getActivarcalifica6DetalleEvaluacionNomi() {
		return this.activarcalifica6DetalleEvaluacionNomi;
	}

	public void setActivarcalifica6DetalleEvaluacionNomi(Boolean activarcalifica6DetalleEvaluacionNomi) {
		this.activarcalifica6DetalleEvaluacionNomi= activarcalifica6DetalleEvaluacionNomi;
	}

	public Border setResaltarcalifica7DetalleEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionnomiBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarcalifica7DetalleEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcalifica7DetalleEvaluacionNomi() {
		return this.resaltarcalifica7DetalleEvaluacionNomi;
	}

	public void setResaltarcalifica7DetalleEvaluacionNomi(Border borderResaltar) {
		this.resaltarcalifica7DetalleEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarcalifica7DetalleEvaluacionNomi() {
		return this.mostrarcalifica7DetalleEvaluacionNomi;
	}

	public void setMostrarcalifica7DetalleEvaluacionNomi(Boolean mostrarcalifica7DetalleEvaluacionNomi) {
		this.mostrarcalifica7DetalleEvaluacionNomi= mostrarcalifica7DetalleEvaluacionNomi;
	}

	public Boolean getActivarcalifica7DetalleEvaluacionNomi() {
		return this.activarcalifica7DetalleEvaluacionNomi;
	}

	public void setActivarcalifica7DetalleEvaluacionNomi(Boolean activarcalifica7DetalleEvaluacionNomi) {
		this.activarcalifica7DetalleEvaluacionNomi= activarcalifica7DetalleEvaluacionNomi;
	}

	public Border setResaltarcalifica8DetalleEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionnomiBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarcalifica8DetalleEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcalifica8DetalleEvaluacionNomi() {
		return this.resaltarcalifica8DetalleEvaluacionNomi;
	}

	public void setResaltarcalifica8DetalleEvaluacionNomi(Border borderResaltar) {
		this.resaltarcalifica8DetalleEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarcalifica8DetalleEvaluacionNomi() {
		return this.mostrarcalifica8DetalleEvaluacionNomi;
	}

	public void setMostrarcalifica8DetalleEvaluacionNomi(Boolean mostrarcalifica8DetalleEvaluacionNomi) {
		this.mostrarcalifica8DetalleEvaluacionNomi= mostrarcalifica8DetalleEvaluacionNomi;
	}

	public Boolean getActivarcalifica8DetalleEvaluacionNomi() {
		return this.activarcalifica8DetalleEvaluacionNomi;
	}

	public void setActivarcalifica8DetalleEvaluacionNomi(Boolean activarcalifica8DetalleEvaluacionNomi) {
		this.activarcalifica8DetalleEvaluacionNomi= activarcalifica8DetalleEvaluacionNomi;
	}

	public Border setResaltarcalifica9DetalleEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionnomiBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarcalifica9DetalleEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcalifica9DetalleEvaluacionNomi() {
		return this.resaltarcalifica9DetalleEvaluacionNomi;
	}

	public void setResaltarcalifica9DetalleEvaluacionNomi(Border borderResaltar) {
		this.resaltarcalifica9DetalleEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarcalifica9DetalleEvaluacionNomi() {
		return this.mostrarcalifica9DetalleEvaluacionNomi;
	}

	public void setMostrarcalifica9DetalleEvaluacionNomi(Boolean mostrarcalifica9DetalleEvaluacionNomi) {
		this.mostrarcalifica9DetalleEvaluacionNomi= mostrarcalifica9DetalleEvaluacionNomi;
	}

	public Boolean getActivarcalifica9DetalleEvaluacionNomi() {
		return this.activarcalifica9DetalleEvaluacionNomi;
	}

	public void setActivarcalifica9DetalleEvaluacionNomi(Boolean activarcalifica9DetalleEvaluacionNomi) {
		this.activarcalifica9DetalleEvaluacionNomi= activarcalifica9DetalleEvaluacionNomi;
	}

	public Border setResaltarcalifica10DetalleEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionnomiBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarcalifica10DetalleEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcalifica10DetalleEvaluacionNomi() {
		return this.resaltarcalifica10DetalleEvaluacionNomi;
	}

	public void setResaltarcalifica10DetalleEvaluacionNomi(Border borderResaltar) {
		this.resaltarcalifica10DetalleEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarcalifica10DetalleEvaluacionNomi() {
		return this.mostrarcalifica10DetalleEvaluacionNomi;
	}

	public void setMostrarcalifica10DetalleEvaluacionNomi(Boolean mostrarcalifica10DetalleEvaluacionNomi) {
		this.mostrarcalifica10DetalleEvaluacionNomi= mostrarcalifica10DetalleEvaluacionNomi;
	}

	public Boolean getActivarcalifica10DetalleEvaluacionNomi() {
		return this.activarcalifica10DetalleEvaluacionNomi;
	}

	public void setActivarcalifica10DetalleEvaluacionNomi(Boolean activarcalifica10DetalleEvaluacionNomi) {
		this.activarcalifica10DetalleEvaluacionNomi= activarcalifica10DetalleEvaluacionNomi;
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
		
		
		this.setMostraridDetalleEvaluacionNomi(esInicial);
		this.setMostrarid_empresaDetalleEvaluacionNomi(esInicial);
		this.setMostrarid_evaluacion_nomiDetalleEvaluacionNomi(esInicial);
		this.setMostrarid_formato_nomiDetalleEvaluacionNomi(esInicial);
		this.setMostrarid_pregunta_nomiDetalleEvaluacionNomi(esInicial);
		this.setMostrarrespuestaDetalleEvaluacionNomi(esInicial);
		this.setMostrarrespuesta_valorDetalleEvaluacionNomi(esInicial);
		this.setMostrarcalifica1DetalleEvaluacionNomi(esInicial);
		this.setMostrarcalifica2DetalleEvaluacionNomi(esInicial);
		this.setMostrarcalifica3DetalleEvaluacionNomi(esInicial);
		this.setMostrarcalifica4DetalleEvaluacionNomi(esInicial);
		this.setMostrarcalifica5DetalleEvaluacionNomi(esInicial);
		this.setMostrarcalifica6DetalleEvaluacionNomi(esInicial);
		this.setMostrarcalifica7DetalleEvaluacionNomi(esInicial);
		this.setMostrarcalifica8DetalleEvaluacionNomi(esInicial);
		this.setMostrarcalifica9DetalleEvaluacionNomi(esInicial);
		this.setMostrarcalifica10DetalleEvaluacionNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.ID)) {
				this.setMostraridDetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.IDEVALUACIONNOMI)) {
				this.setMostrarid_evaluacion_nomiDetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.IDFORMATONOMI)) {
				this.setMostrarid_formato_nomiDetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.IDPREGUNTANOMI)) {
				this.setMostrarid_pregunta_nomiDetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.RESPUESTA)) {
				this.setMostrarrespuestaDetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.RESPUESTAVALOR)) {
				this.setMostrarrespuesta_valorDetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA1)) {
				this.setMostrarcalifica1DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA2)) {
				this.setMostrarcalifica2DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA3)) {
				this.setMostrarcalifica3DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA4)) {
				this.setMostrarcalifica4DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA5)) {
				this.setMostrarcalifica5DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA6)) {
				this.setMostrarcalifica6DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA7)) {
				this.setMostrarcalifica7DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA8)) {
				this.setMostrarcalifica8DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA9)) {
				this.setMostrarcalifica9DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA10)) {
				this.setMostrarcalifica10DetalleEvaluacionNomi(esAsigna);
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
		
		
		this.setActivaridDetalleEvaluacionNomi(esInicial);
		this.setActivarid_empresaDetalleEvaluacionNomi(esInicial);
		this.setActivarid_evaluacion_nomiDetalleEvaluacionNomi(esInicial);
		this.setActivarid_formato_nomiDetalleEvaluacionNomi(esInicial);
		this.setActivarid_pregunta_nomiDetalleEvaluacionNomi(esInicial);
		this.setActivarrespuestaDetalleEvaluacionNomi(esInicial);
		this.setActivarrespuesta_valorDetalleEvaluacionNomi(esInicial);
		this.setActivarcalifica1DetalleEvaluacionNomi(esInicial);
		this.setActivarcalifica2DetalleEvaluacionNomi(esInicial);
		this.setActivarcalifica3DetalleEvaluacionNomi(esInicial);
		this.setActivarcalifica4DetalleEvaluacionNomi(esInicial);
		this.setActivarcalifica5DetalleEvaluacionNomi(esInicial);
		this.setActivarcalifica6DetalleEvaluacionNomi(esInicial);
		this.setActivarcalifica7DetalleEvaluacionNomi(esInicial);
		this.setActivarcalifica8DetalleEvaluacionNomi(esInicial);
		this.setActivarcalifica9DetalleEvaluacionNomi(esInicial);
		this.setActivarcalifica10DetalleEvaluacionNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.ID)) {
				this.setActivaridDetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.IDEVALUACIONNOMI)) {
				this.setActivarid_evaluacion_nomiDetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.IDFORMATONOMI)) {
				this.setActivarid_formato_nomiDetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.IDPREGUNTANOMI)) {
				this.setActivarid_pregunta_nomiDetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.RESPUESTA)) {
				this.setActivarrespuestaDetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.RESPUESTAVALOR)) {
				this.setActivarrespuesta_valorDetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA1)) {
				this.setActivarcalifica1DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA2)) {
				this.setActivarcalifica2DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA3)) {
				this.setActivarcalifica3DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA4)) {
				this.setActivarcalifica4DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA5)) {
				this.setActivarcalifica5DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA6)) {
				this.setActivarcalifica6DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA7)) {
				this.setActivarcalifica7DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA8)) {
				this.setActivarcalifica8DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA9)) {
				this.setActivarcalifica9DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA10)) {
				this.setActivarcalifica10DetalleEvaluacionNomi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleEvaluacionNomi(esInicial);
		this.setResaltarid_empresaDetalleEvaluacionNomi(esInicial);
		this.setResaltarid_evaluacion_nomiDetalleEvaluacionNomi(esInicial);
		this.setResaltarid_formato_nomiDetalleEvaluacionNomi(esInicial);
		this.setResaltarid_pregunta_nomiDetalleEvaluacionNomi(esInicial);
		this.setResaltarrespuestaDetalleEvaluacionNomi(esInicial);
		this.setResaltarrespuesta_valorDetalleEvaluacionNomi(esInicial);
		this.setResaltarcalifica1DetalleEvaluacionNomi(esInicial);
		this.setResaltarcalifica2DetalleEvaluacionNomi(esInicial);
		this.setResaltarcalifica3DetalleEvaluacionNomi(esInicial);
		this.setResaltarcalifica4DetalleEvaluacionNomi(esInicial);
		this.setResaltarcalifica5DetalleEvaluacionNomi(esInicial);
		this.setResaltarcalifica6DetalleEvaluacionNomi(esInicial);
		this.setResaltarcalifica7DetalleEvaluacionNomi(esInicial);
		this.setResaltarcalifica8DetalleEvaluacionNomi(esInicial);
		this.setResaltarcalifica9DetalleEvaluacionNomi(esInicial);
		this.setResaltarcalifica10DetalleEvaluacionNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.ID)) {
				this.setResaltaridDetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.IDEVALUACIONNOMI)) {
				this.setResaltarid_evaluacion_nomiDetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.IDFORMATONOMI)) {
				this.setResaltarid_formato_nomiDetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.IDPREGUNTANOMI)) {
				this.setResaltarid_pregunta_nomiDetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.RESPUESTA)) {
				this.setResaltarrespuestaDetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.RESPUESTAVALOR)) {
				this.setResaltarrespuesta_valorDetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA1)) {
				this.setResaltarcalifica1DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA2)) {
				this.setResaltarcalifica2DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA3)) {
				this.setResaltarcalifica3DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA4)) {
				this.setResaltarcalifica4DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA5)) {
				this.setResaltarcalifica5DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA6)) {
				this.setResaltarcalifica6DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA7)) {
				this.setResaltarcalifica7DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA8)) {
				this.setResaltarcalifica8DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA9)) {
				this.setResaltarcalifica9DetalleEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionNomiConstantesFunciones.CALIFICA10)) {
				this.setResaltarcalifica10DetalleEvaluacionNomi(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaDetalleEvaluacionNomi=true;

	public Boolean getMostrarFK_IdEmpresaDetalleEvaluacionNomi() {
		return this.mostrarFK_IdEmpresaDetalleEvaluacionNomi;
	}

	public void setMostrarFK_IdEmpresaDetalleEvaluacionNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleEvaluacionNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEvaluacionNomiDetalleEvaluacionNomi=true;

	public Boolean getMostrarFK_IdEvaluacionNomiDetalleEvaluacionNomi() {
		return this.mostrarFK_IdEvaluacionNomiDetalleEvaluacionNomi;
	}

	public void setMostrarFK_IdEvaluacionNomiDetalleEvaluacionNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEvaluacionNomiDetalleEvaluacionNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoNomiDetalleEvaluacionNomi=true;

	public Boolean getMostrarFK_IdFormatoNomiDetalleEvaluacionNomi() {
		return this.mostrarFK_IdFormatoNomiDetalleEvaluacionNomi;
	}

	public void setMostrarFK_IdFormatoNomiDetalleEvaluacionNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoNomiDetalleEvaluacionNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPreguntaNomiDetalleEvaluacionNomi=true;

	public Boolean getMostrarFK_IdPreguntaNomiDetalleEvaluacionNomi() {
		return this.mostrarFK_IdPreguntaNomiDetalleEvaluacionNomi;
	}

	public void setMostrarFK_IdPreguntaNomiDetalleEvaluacionNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPreguntaNomiDetalleEvaluacionNomi= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaDetalleEvaluacionNomi=true;

	public Boolean getActivarFK_IdEmpresaDetalleEvaluacionNomi() {
		return this.activarFK_IdEmpresaDetalleEvaluacionNomi;
	}

	public void setActivarFK_IdEmpresaDetalleEvaluacionNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleEvaluacionNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdEvaluacionNomiDetalleEvaluacionNomi=true;

	public Boolean getActivarFK_IdEvaluacionNomiDetalleEvaluacionNomi() {
		return this.activarFK_IdEvaluacionNomiDetalleEvaluacionNomi;
	}

	public void setActivarFK_IdEvaluacionNomiDetalleEvaluacionNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEvaluacionNomiDetalleEvaluacionNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoNomiDetalleEvaluacionNomi=true;

	public Boolean getActivarFK_IdFormatoNomiDetalleEvaluacionNomi() {
		return this.activarFK_IdFormatoNomiDetalleEvaluacionNomi;
	}

	public void setActivarFK_IdFormatoNomiDetalleEvaluacionNomi(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoNomiDetalleEvaluacionNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdPreguntaNomiDetalleEvaluacionNomi=true;

	public Boolean getActivarFK_IdPreguntaNomiDetalleEvaluacionNomi() {
		return this.activarFK_IdPreguntaNomiDetalleEvaluacionNomi;
	}

	public void setActivarFK_IdPreguntaNomiDetalleEvaluacionNomi(Boolean habilitarResaltar) {
		this.activarFK_IdPreguntaNomiDetalleEvaluacionNomi= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaDetalleEvaluacionNomi=null;

	public Border getResaltarFK_IdEmpresaDetalleEvaluacionNomi() {
		return this.resaltarFK_IdEmpresaDetalleEvaluacionNomi;
	}

	public void setResaltarFK_IdEmpresaDetalleEvaluacionNomi(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleEvaluacionNomi= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleEvaluacionNomi= borderResaltar;
	}

	public Border resaltarFK_IdEvaluacionNomiDetalleEvaluacionNomi=null;

	public Border getResaltarFK_IdEvaluacionNomiDetalleEvaluacionNomi() {
		return this.resaltarFK_IdEvaluacionNomiDetalleEvaluacionNomi;
	}

	public void setResaltarFK_IdEvaluacionNomiDetalleEvaluacionNomi(Border borderResaltar) {
		this.resaltarFK_IdEvaluacionNomiDetalleEvaluacionNomi= borderResaltar;
	}

	public void setResaltarFK_IdEvaluacionNomiDetalleEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEvaluacionNomiDetalleEvaluacionNomi= borderResaltar;
	}

	public Border resaltarFK_IdFormatoNomiDetalleEvaluacionNomi=null;

	public Border getResaltarFK_IdFormatoNomiDetalleEvaluacionNomi() {
		return this.resaltarFK_IdFormatoNomiDetalleEvaluacionNomi;
	}

	public void setResaltarFK_IdFormatoNomiDetalleEvaluacionNomi(Border borderResaltar) {
		this.resaltarFK_IdFormatoNomiDetalleEvaluacionNomi= borderResaltar;
	}

	public void setResaltarFK_IdFormatoNomiDetalleEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoNomiDetalleEvaluacionNomi= borderResaltar;
	}

	public Border resaltarFK_IdPreguntaNomiDetalleEvaluacionNomi=null;

	public Border getResaltarFK_IdPreguntaNomiDetalleEvaluacionNomi() {
		return this.resaltarFK_IdPreguntaNomiDetalleEvaluacionNomi;
	}

	public void setResaltarFK_IdPreguntaNomiDetalleEvaluacionNomi(Border borderResaltar) {
		this.resaltarFK_IdPreguntaNomiDetalleEvaluacionNomi= borderResaltar;
	}

	public void setResaltarFK_IdPreguntaNomiDetalleEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionNomiBeanSwingJInternalFrame detalleevaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPreguntaNomiDetalleEvaluacionNomi= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}