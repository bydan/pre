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
package com.bydan.erp.nomina.util.report;

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


import com.bydan.erp.nomina.util.report.EvaluacionesPeriodosConstantesFunciones;
import com.bydan.erp.nomina.util.report.EvaluacionesPeriodosParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.EvaluacionesPeriodosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.business.entity.report.*;



import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EvaluacionesPeriodosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EvaluacionesPeriodos";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EvaluacionesPeriodos"+EvaluacionesPeriodosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EvaluacionesPeriodosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EvaluacionesPeriodosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EvaluacionesPeriodosConstantesFunciones.SCHEMA+"_"+EvaluacionesPeriodosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EvaluacionesPeriodosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EvaluacionesPeriodosConstantesFunciones.SCHEMA+"_"+EvaluacionesPeriodosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EvaluacionesPeriodosConstantesFunciones.SCHEMA+"_"+EvaluacionesPeriodosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EvaluacionesPeriodosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EvaluacionesPeriodosConstantesFunciones.SCHEMA+"_"+EvaluacionesPeriodosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionesPeriodosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EvaluacionesPeriodosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionesPeriodosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionesPeriodosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EvaluacionesPeriodosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionesPeriodosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EvaluacionesPeriodosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EvaluacionesPeriodosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EvaluacionesPeriodosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EvaluacionesPeriodosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Evaluaciones Periodoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Evaluaciones Periodos";
	public static final String SCLASSWEBTITULO_LOWER="Evaluaciones Periodos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EvaluacionesPeriodos";
	public static final String OBJECTNAME="evaluacionesperiodos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="evaluaciones_periodos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select evaluacionesperiodos from "+EvaluacionesPeriodosConstantesFunciones.SPERSISTENCENAME+" evaluacionesperiodos";
	public static String QUERYSELECTNATIVE="select "+EvaluacionesPeriodosConstantesFunciones.SCHEMA+"."+EvaluacionesPeriodosConstantesFunciones.TABLENAME+".id,"+EvaluacionesPeriodosConstantesFunciones.SCHEMA+"."+EvaluacionesPeriodosConstantesFunciones.TABLENAME+".version_row,"+EvaluacionesPeriodosConstantesFunciones.SCHEMA+"."+EvaluacionesPeriodosConstantesFunciones.TABLENAME+".id_tipo_calificacion_empleado,"+EvaluacionesPeriodosConstantesFunciones.SCHEMA+"."+EvaluacionesPeriodosConstantesFunciones.TABLENAME+".verificado,"+EvaluacionesPeriodosConstantesFunciones.SCHEMA+"."+EvaluacionesPeriodosConstantesFunciones.TABLENAME+".id_estructura,"+EvaluacionesPeriodosConstantesFunciones.SCHEMA+"."+EvaluacionesPeriodosConstantesFunciones.TABLENAME+".codigo,"+EvaluacionesPeriodosConstantesFunciones.SCHEMA+"."+EvaluacionesPeriodosConstantesFunciones.TABLENAME+".id_empresa,"+EvaluacionesPeriodosConstantesFunciones.SCHEMA+"."+EvaluacionesPeriodosConstantesFunciones.TABLENAME+".id_sucursal,"+EvaluacionesPeriodosConstantesFunciones.SCHEMA+"."+EvaluacionesPeriodosConstantesFunciones.TABLENAME+".id_ejercicio,"+EvaluacionesPeriodosConstantesFunciones.SCHEMA+"."+EvaluacionesPeriodosConstantesFunciones.TABLENAME+".id_tipo_evaluacion_empleado,"+EvaluacionesPeriodosConstantesFunciones.SCHEMA+"."+EvaluacionesPeriodosConstantesFunciones.TABLENAME+".codigo_dato,"+EvaluacionesPeriodosConstantesFunciones.SCHEMA+"."+EvaluacionesPeriodosConstantesFunciones.TABLENAME+".nombre_completo,"+EvaluacionesPeriodosConstantesFunciones.SCHEMA+"."+EvaluacionesPeriodosConstantesFunciones.TABLENAME+".id_formato_nomi_pregunta_nomi,"+EvaluacionesPeriodosConstantesFunciones.SCHEMA+"."+EvaluacionesPeriodosConstantesFunciones.TABLENAME+".valor_conocimiento,"+EvaluacionesPeriodosConstantesFunciones.SCHEMA+"."+EvaluacionesPeriodosConstantesFunciones.TABLENAME+".valor_eficiencia,"+EvaluacionesPeriodosConstantesFunciones.SCHEMA+"."+EvaluacionesPeriodosConstantesFunciones.TABLENAME+".valor_obtenido,"+EvaluacionesPeriodosConstantesFunciones.SCHEMA+"."+EvaluacionesPeriodosConstantesFunciones.TABLENAME+".promedio from "+EvaluacionesPeriodosConstantesFunciones.SCHEMA+"."+EvaluacionesPeriodosConstantesFunciones.TABLENAME;//+" as "+EvaluacionesPeriodosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDTIPOCALIFICACIONEMPLEADO= "id_tipo_calificacion_empleado";
    public static final String VERIFICADO= "verificado";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String CODIGO= "codigo";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDTIPOEVALUACIONEMPLEADO= "id_tipo_evaluacion_empleado";
    public static final String CODIGODATO= "codigo_dato";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String IDFORMATONOMIPREGUNTANOMI= "id_formato_nomi_pregunta_nomi";
    public static final String VALORCONOCIMIENTO= "valor_conocimiento";
    public static final String VALOREFICIENCIA= "valor_eficiencia";
    public static final String VALOROBTENIDO= "valor_obtenido";
    public static final String PROMEDIO= "promedio";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDTIPOCALIFICACIONEMPLEADO= "Tipo Calificacion Empleado";
		public static final String LABEL_IDTIPOCALIFICACIONEMPLEADO_LOWER= "Tipo Calificacion Empleado";
    	public static final String LABEL_VERIFICADO= "Verificado";
		public static final String LABEL_VERIFICADO_LOWER= "Verificado";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDTIPOEVALUACIONEMPLEADO= "Tipo Evaluacion Empleado";
		public static final String LABEL_IDTIPOEVALUACIONEMPLEADO_LOWER= "Tipo Evaluacion Empleado";
    	public static final String LABEL_CODIGODATO= "Codigo Dato";
		public static final String LABEL_CODIGODATO_LOWER= "Codigo Dato";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_IDFORMATONOMIPREGUNTANOMI= "Formato Nomi Pregunta Nomi";
		public static final String LABEL_IDFORMATONOMIPREGUNTANOMI_LOWER= "Formato Nomi Pregunta Nomi";
    	public static final String LABEL_VALORCONOCIMIENTO= "Valor Conocimiento";
		public static final String LABEL_VALORCONOCIMIENTO_LOWER= "Valor Conocimiento";
    	public static final String LABEL_VALOREFICIENCIA= "Valor Eficiencia";
		public static final String LABEL_VALOREFICIENCIA_LOWER= "Valor Eficiencia";
    	public static final String LABEL_VALOROBTENIDO= "Valor Obtenido";
		public static final String LABEL_VALOROBTENIDO_LOWER= "Valor Obtenido";
    	public static final String LABEL_PROMEDIO= "Promedio";
		public static final String LABEL_PROMEDIO_LOWER= "Promedio";
	
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXCODIGO_DATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_DATO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getEvaluacionesPeriodosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EvaluacionesPeriodosConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO)) {sLabelColumna=EvaluacionesPeriodosConstantesFunciones.LABEL_IDTIPOCALIFICACIONEMPLEADO;}
		if(sNombreColumna.equals(EvaluacionesPeriodosConstantesFunciones.VERIFICADO)) {sLabelColumna=EvaluacionesPeriodosConstantesFunciones.LABEL_VERIFICADO;}
		if(sNombreColumna.equals(EvaluacionesPeriodosConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=EvaluacionesPeriodosConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(EvaluacionesPeriodosConstantesFunciones.CODIGO)) {sLabelColumna=EvaluacionesPeriodosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EvaluacionesPeriodosConstantesFunciones.IDEMPRESA)) {sLabelColumna=EvaluacionesPeriodosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EvaluacionesPeriodosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=EvaluacionesPeriodosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(EvaluacionesPeriodosConstantesFunciones.IDEJERCICIO)) {sLabelColumna=EvaluacionesPeriodosConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(EvaluacionesPeriodosConstantesFunciones.IDTIPOEVALUACIONEMPLEADO)) {sLabelColumna=EvaluacionesPeriodosConstantesFunciones.LABEL_IDTIPOEVALUACIONEMPLEADO;}
		if(sNombreColumna.equals(EvaluacionesPeriodosConstantesFunciones.CODIGODATO)) {sLabelColumna=EvaluacionesPeriodosConstantesFunciones.LABEL_CODIGODATO;}
		if(sNombreColumna.equals(EvaluacionesPeriodosConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=EvaluacionesPeriodosConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(EvaluacionesPeriodosConstantesFunciones.IDFORMATONOMIPREGUNTANOMI)) {sLabelColumna=EvaluacionesPeriodosConstantesFunciones.LABEL_IDFORMATONOMIPREGUNTANOMI;}
		if(sNombreColumna.equals(EvaluacionesPeriodosConstantesFunciones.VALORCONOCIMIENTO)) {sLabelColumna=EvaluacionesPeriodosConstantesFunciones.LABEL_VALORCONOCIMIENTO;}
		if(sNombreColumna.equals(EvaluacionesPeriodosConstantesFunciones.VALOREFICIENCIA)) {sLabelColumna=EvaluacionesPeriodosConstantesFunciones.LABEL_VALOREFICIENCIA;}
		if(sNombreColumna.equals(EvaluacionesPeriodosConstantesFunciones.VALOROBTENIDO)) {sLabelColumna=EvaluacionesPeriodosConstantesFunciones.LABEL_VALOROBTENIDO;}
		if(sNombreColumna.equals(EvaluacionesPeriodosConstantesFunciones.PROMEDIO)) {sLabelColumna=EvaluacionesPeriodosConstantesFunciones.LABEL_PROMEDIO;}
		
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
	
	
	
			
			
			
		
	public static String getverificadoDescripcion(EvaluacionesPeriodos evaluacionesperiodos) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!evaluacionesperiodos.getverificado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getverificadoHtmlDescripcion(EvaluacionesPeriodos evaluacionesperiodos) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(evaluacionesperiodos.getId(),evaluacionesperiodos.getverificado());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getEvaluacionesPeriodosDescripcion(EvaluacionesPeriodos evaluacionesperiodos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(evaluacionesperiodos !=null/* && evaluacionesperiodos.getId()!=0*/) {
			sDescripcion=evaluacionesperiodos.getcodigo();//evaluacionesperiodosevaluacionesperiodos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEvaluacionesPeriodosDescripcionDetallado(EvaluacionesPeriodos evaluacionesperiodos) {
		String sDescripcion="";
			
		sDescripcion+=EvaluacionesPeriodosConstantesFunciones.ID+"=";
		sDescripcion+=evaluacionesperiodos.getId().toString()+",";
		sDescripcion+=EvaluacionesPeriodosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=evaluacionesperiodos.getVersionRow().toString()+",";
		sDescripcion+=EvaluacionesPeriodosConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO+"=";
		sDescripcion+=evaluacionesperiodos.getid_tipo_calificacion_empleado().toString()+",";
		sDescripcion+=EvaluacionesPeriodosConstantesFunciones.VERIFICADO+"=";
		sDescripcion+=evaluacionesperiodos.getverificado().toString()+",";
		sDescripcion+=EvaluacionesPeriodosConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=evaluacionesperiodos.getid_estructura().toString()+",";
		sDescripcion+=EvaluacionesPeriodosConstantesFunciones.CODIGO+"=";
		sDescripcion+=evaluacionesperiodos.getcodigo()+",";
		sDescripcion+=EvaluacionesPeriodosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=evaluacionesperiodos.getid_empresa().toString()+",";
		sDescripcion+=EvaluacionesPeriodosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=evaluacionesperiodos.getid_sucursal().toString()+",";
		sDescripcion+=EvaluacionesPeriodosConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=evaluacionesperiodos.getid_ejercicio().toString()+",";
		sDescripcion+=EvaluacionesPeriodosConstantesFunciones.IDTIPOEVALUACIONEMPLEADO+"=";
		sDescripcion+=evaluacionesperiodos.getid_tipo_evaluacion_empleado().toString()+",";
		sDescripcion+=EvaluacionesPeriodosConstantesFunciones.CODIGODATO+"=";
		sDescripcion+=evaluacionesperiodos.getcodigo_dato()+",";
		sDescripcion+=EvaluacionesPeriodosConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=evaluacionesperiodos.getnombre_completo()+",";
		sDescripcion+=EvaluacionesPeriodosConstantesFunciones.IDFORMATONOMIPREGUNTANOMI+"=";
		sDescripcion+=evaluacionesperiodos.getid_formato_nomi_pregunta_nomi().toString()+",";
		sDescripcion+=EvaluacionesPeriodosConstantesFunciones.VALORCONOCIMIENTO+"=";
		sDescripcion+=evaluacionesperiodos.getvalor_conocimiento().toString()+",";
		sDescripcion+=EvaluacionesPeriodosConstantesFunciones.VALOREFICIENCIA+"=";
		sDescripcion+=evaluacionesperiodos.getvalor_eficiencia().toString()+",";
		sDescripcion+=EvaluacionesPeriodosConstantesFunciones.VALOROBTENIDO+"=";
		sDescripcion+=evaluacionesperiodos.getvalor_obtenido().toString()+",";
		sDescripcion+=EvaluacionesPeriodosConstantesFunciones.PROMEDIO+"=";
		sDescripcion+=evaluacionesperiodos.getpromedio().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEvaluacionesPeriodosDescripcion(EvaluacionesPeriodos evaluacionesperiodos,String sValor) throws Exception {			
		if(evaluacionesperiodos !=null) {
			evaluacionesperiodos.setcodigo(sValor);;//evaluacionesperiodosevaluacionesperiodos.getcodigo().trim();
		}		
	}
	
		

	public static String getTipoCalificacionEmpleadoDescripcion(TipoCalificacionEmpleado tipocalificacionempleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocalificacionempleado!=null/*&&tipocalificacionempleado.getId()>0*/) {
			sDescripcion=TipoCalificacionEmpleadoConstantesFunciones.getTipoCalificacionEmpleadoDescripcion(tipocalificacionempleado);
		}

		return sDescripcion;
	}

	public static String getEstructuraDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estructura!=null/*&&estructura.getId()>0*/) {
			sDescripcion=EstructuraConstantesFunciones.getEstructuraDescripcion(estructura);
		}

		return sDescripcion;
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

	public static String getTipoEvaluacionEmpleadoDescripcion(TipoEvaluacionEmpleado tipoevaluacionempleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoevaluacionempleado!=null/*&&tipoevaluacionempleado.getId()>0*/) {
			sDescripcion=TipoEvaluacionEmpleadoConstantesFunciones.getTipoEvaluacionEmpleadoDescripcion(tipoevaluacionempleado);
		}

		return sDescripcion;
	}

	public static String getFormatoNomiPreguntaNomiDescripcion(FormatoNomiPreguntaNomi formatonomipreguntanomi) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formatonomipreguntanomi!=null/*&&formatonomipreguntanomi.getId()>0*/) {
			sDescripcion=FormatoNomiPreguntaNomiConstantesFunciones.getFormatoNomiPreguntaNomiDescripcion(formatonomipreguntanomi);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaEvaluacionesPeriodos")) {
			sNombreIndice="Tipo=  Por Tipo Calificacion Empleado Por Verificado Por Estructura Por Codigo Por Ejercicio Por Tipo Evaluacion Empleado";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdFormatoNomiPreguntaNomi")) {
			sNombreIndice="Tipo=  Por Formato Nomi Pregunta Nomi";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCalificacionEmpleado")) {
			sNombreIndice="Tipo=  Por Tipo Calificacion Empleado";
		} else if(sNombreIndice.equals("FK_IdTipoEvaluacionEmpleado")) {
			sNombreIndice="Tipo=  Por Tipo Evaluacion Empleado";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaEvaluacionesPeriodos(Long id_tipo_calificacion_empleado,Boolean verificado,Long id_estructura,String codigo,Long id_ejercicio,Long id_tipo_evaluacion_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_calificacion_empleado!=null) {sDetalleIndice+=" Codigo Unico De Tipo Calificacion Empleado="+id_tipo_calificacion_empleado.toString();}
		if(verificado!=null) {sDetalleIndice+=" Verificado="+verificado.toString();}
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();}
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;}
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(id_tipo_evaluacion_empleado!=null) {sDetalleIndice+=" Codigo Unico De Tipo Evaluacion Empleado="+id_tipo_evaluacion_empleado.toString();} 

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

	public static String getDetalleIndiceFK_IdEstructura(Long id_estructura) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoNomiPreguntaNomi(Long id_formato_nomi_pregunta_nomi) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_nomi_pregunta_nomi!=null) {sDetalleIndice+=" Codigo Unico De Formato Nomi Pregunta Nomi="+id_formato_nomi_pregunta_nomi.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCalificacionEmpleado(Long id_tipo_calificacion_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_calificacion_empleado!=null) {sDetalleIndice+=" Codigo Unico De Tipo Calificacion Empleado="+id_tipo_calificacion_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoEvaluacionEmpleado(Long id_tipo_evaluacion_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_evaluacion_empleado!=null) {sDetalleIndice+=" Codigo Unico De Tipo Evaluacion Empleado="+id_tipo_evaluacion_empleado.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEvaluacionesPeriodos(EvaluacionesPeriodos evaluacionesperiodos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		evaluacionesperiodos.setcodigo_dato(evaluacionesperiodos.getcodigo_dato().trim());
		evaluacionesperiodos.setnombre_completo(evaluacionesperiodos.getnombre_completo().trim());
	}
	
	public static void quitarEspaciosEvaluacionesPeriodoss(List<EvaluacionesPeriodos> evaluacionesperiodoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EvaluacionesPeriodos evaluacionesperiodos: evaluacionesperiodoss) {
			evaluacionesperiodos.setcodigo_dato(evaluacionesperiodos.getcodigo_dato().trim());
			evaluacionesperiodos.setnombre_completo(evaluacionesperiodos.getnombre_completo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEvaluacionesPeriodos(EvaluacionesPeriodos evaluacionesperiodos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && evaluacionesperiodos.getConCambioAuxiliar()) {
			evaluacionesperiodos.setIsDeleted(evaluacionesperiodos.getIsDeletedAuxiliar());	
			evaluacionesperiodos.setIsNew(evaluacionesperiodos.getIsNewAuxiliar());	
			evaluacionesperiodos.setIsChanged(evaluacionesperiodos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			evaluacionesperiodos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			evaluacionesperiodos.setIsDeletedAuxiliar(false);	
			evaluacionesperiodos.setIsNewAuxiliar(false);	
			evaluacionesperiodos.setIsChangedAuxiliar(false);
			
			evaluacionesperiodos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEvaluacionesPeriodoss(List<EvaluacionesPeriodos> evaluacionesperiodoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EvaluacionesPeriodos evaluacionesperiodos : evaluacionesperiodoss) {
			if(conAsignarBase && evaluacionesperiodos.getConCambioAuxiliar()) {
				evaluacionesperiodos.setIsDeleted(evaluacionesperiodos.getIsDeletedAuxiliar());	
				evaluacionesperiodos.setIsNew(evaluacionesperiodos.getIsNewAuxiliar());	
				evaluacionesperiodos.setIsChanged(evaluacionesperiodos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				evaluacionesperiodos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				evaluacionesperiodos.setIsDeletedAuxiliar(false);	
				evaluacionesperiodos.setIsNewAuxiliar(false);	
				evaluacionesperiodos.setIsChangedAuxiliar(false);
				
				evaluacionesperiodos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEvaluacionesPeriodos(EvaluacionesPeriodos evaluacionesperiodos,Boolean conEnteros) throws Exception  {
		evaluacionesperiodos.setvalor_conocimiento(0.0);
		evaluacionesperiodos.setvalor_eficiencia(0.0);
		evaluacionesperiodos.setvalor_obtenido(0.0);
		evaluacionesperiodos.setpromedio(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEvaluacionesPeriodoss(List<EvaluacionesPeriodos> evaluacionesperiodoss,Boolean conEnteros) throws Exception  {
		
		for(EvaluacionesPeriodos evaluacionesperiodos: evaluacionesperiodoss) {
			evaluacionesperiodos.setvalor_conocimiento(0.0);
			evaluacionesperiodos.setvalor_eficiencia(0.0);
			evaluacionesperiodos.setvalor_obtenido(0.0);
			evaluacionesperiodos.setpromedio(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEvaluacionesPeriodos(List<EvaluacionesPeriodos> evaluacionesperiodoss,EvaluacionesPeriodos evaluacionesperiodosAux) throws Exception  {
		EvaluacionesPeriodosConstantesFunciones.InicializarValoresEvaluacionesPeriodos(evaluacionesperiodosAux,true);
		
		for(EvaluacionesPeriodos evaluacionesperiodos: evaluacionesperiodoss) {
			if(evaluacionesperiodos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			evaluacionesperiodosAux.setvalor_conocimiento(evaluacionesperiodosAux.getvalor_conocimiento()+evaluacionesperiodos.getvalor_conocimiento());			
			evaluacionesperiodosAux.setvalor_eficiencia(evaluacionesperiodosAux.getvalor_eficiencia()+evaluacionesperiodos.getvalor_eficiencia());			
			evaluacionesperiodosAux.setvalor_obtenido(evaluacionesperiodosAux.getvalor_obtenido()+evaluacionesperiodos.getvalor_obtenido());			
			evaluacionesperiodosAux.setpromedio(evaluacionesperiodosAux.getpromedio()+evaluacionesperiodos.getpromedio());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEvaluacionesPeriodos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EvaluacionesPeriodosConstantesFunciones.getArrayColumnasGlobalesEvaluacionesPeriodos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEvaluacionesPeriodos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EvaluacionesPeriodosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EvaluacionesPeriodosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EvaluacionesPeriodosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EvaluacionesPeriodosConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EvaluacionesPeriodosConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EvaluacionesPeriodosConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEvaluacionesPeriodos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EvaluacionesPeriodos> evaluacionesperiodoss,EvaluacionesPeriodos evaluacionesperiodos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EvaluacionesPeriodos evaluacionesperiodosAux: evaluacionesperiodoss) {
			if(evaluacionesperiodosAux!=null && evaluacionesperiodos!=null) {
				if((evaluacionesperiodosAux.getId()==null && evaluacionesperiodos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(evaluacionesperiodosAux.getId()!=null && evaluacionesperiodos.getId()!=null){
					if(evaluacionesperiodosAux.getId().equals(evaluacionesperiodos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEvaluacionesPeriodos(List<EvaluacionesPeriodos> evaluacionesperiodoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_conocimientoTotal=0.0;
		Double valor_eficienciaTotal=0.0;
		Double valor_obtenidoTotal=0.0;
		Double promedioTotal=0.0;
	
		for(EvaluacionesPeriodos evaluacionesperiodos: evaluacionesperiodoss) {			
			if(evaluacionesperiodos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_conocimientoTotal+=evaluacionesperiodos.getvalor_conocimiento();
			valor_eficienciaTotal+=evaluacionesperiodos.getvalor_eficiencia();
			valor_obtenidoTotal+=evaluacionesperiodos.getvalor_obtenido();
			promedioTotal+=evaluacionesperiodos.getpromedio();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EvaluacionesPeriodosConstantesFunciones.VALORCONOCIMIENTO);
		datoGeneral.setsDescripcion(EvaluacionesPeriodosConstantesFunciones.LABEL_VALORCONOCIMIENTO);
		datoGeneral.setdValorDouble(valor_conocimientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EvaluacionesPeriodosConstantesFunciones.VALOREFICIENCIA);
		datoGeneral.setsDescripcion(EvaluacionesPeriodosConstantesFunciones.LABEL_VALOREFICIENCIA);
		datoGeneral.setdValorDouble(valor_eficienciaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EvaluacionesPeriodosConstantesFunciones.VALOROBTENIDO);
		datoGeneral.setsDescripcion(EvaluacionesPeriodosConstantesFunciones.LABEL_VALOROBTENIDO);
		datoGeneral.setdValorDouble(valor_obtenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EvaluacionesPeriodosConstantesFunciones.PROMEDIO);
		datoGeneral.setsDescripcion(EvaluacionesPeriodosConstantesFunciones.LABEL_PROMEDIO);
		datoGeneral.setdValorDouble(promedioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEvaluacionesPeriodos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EvaluacionesPeriodosConstantesFunciones.LABEL_ID, EvaluacionesPeriodosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesPeriodosConstantesFunciones.LABEL_VERSIONROW, EvaluacionesPeriodosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesPeriodosConstantesFunciones.LABEL_CODIGODATO, EvaluacionesPeriodosConstantesFunciones.CODIGODATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesPeriodosConstantesFunciones.LABEL_NOMBRECOMPLETO, EvaluacionesPeriodosConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesPeriodosConstantesFunciones.LABEL_IDFORMATONOMIPREGUNTANOMI, EvaluacionesPeriodosConstantesFunciones.IDFORMATONOMIPREGUNTANOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesPeriodosConstantesFunciones.LABEL_VALORCONOCIMIENTO, EvaluacionesPeriodosConstantesFunciones.VALORCONOCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesPeriodosConstantesFunciones.LABEL_VALOREFICIENCIA, EvaluacionesPeriodosConstantesFunciones.VALOREFICIENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesPeriodosConstantesFunciones.LABEL_VALOROBTENIDO, EvaluacionesPeriodosConstantesFunciones.VALOROBTENIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesPeriodosConstantesFunciones.LABEL_PROMEDIO, EvaluacionesPeriodosConstantesFunciones.PROMEDIO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEvaluacionesPeriodos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesPeriodosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesPeriodosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesPeriodosConstantesFunciones.CODIGODATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesPeriodosConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesPeriodosConstantesFunciones.IDFORMATONOMIPREGUNTANOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesPeriodosConstantesFunciones.VALORCONOCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesPeriodosConstantesFunciones.VALOREFICIENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesPeriodosConstantesFunciones.VALOROBTENIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesPeriodosConstantesFunciones.PROMEDIO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEvaluacionesPeriodos() throws Exception  {
		return EvaluacionesPeriodosConstantesFunciones.getTiposSeleccionarEvaluacionesPeriodos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEvaluacionesPeriodos(Boolean conFk) throws Exception  {
		return EvaluacionesPeriodosConstantesFunciones.getTiposSeleccionarEvaluacionesPeriodos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEvaluacionesPeriodos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesPeriodosConstantesFunciones.LABEL_IDTIPOCALIFICACIONEMPLEADO);
			reporte.setsDescripcion(EvaluacionesPeriodosConstantesFunciones.LABEL_IDTIPOCALIFICACIONEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesPeriodosConstantesFunciones.LABEL_VERIFICADO);
			reporte.setsDescripcion(EvaluacionesPeriodosConstantesFunciones.LABEL_VERIFICADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesPeriodosConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(EvaluacionesPeriodosConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesPeriodosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EvaluacionesPeriodosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesPeriodosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EvaluacionesPeriodosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesPeriodosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(EvaluacionesPeriodosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesPeriodosConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(EvaluacionesPeriodosConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesPeriodosConstantesFunciones.LABEL_IDTIPOEVALUACIONEMPLEADO);
			reporte.setsDescripcion(EvaluacionesPeriodosConstantesFunciones.LABEL_IDTIPOEVALUACIONEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesPeriodosConstantesFunciones.LABEL_CODIGODATO);
			reporte.setsDescripcion(EvaluacionesPeriodosConstantesFunciones.LABEL_CODIGODATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesPeriodosConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(EvaluacionesPeriodosConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesPeriodosConstantesFunciones.LABEL_IDFORMATONOMIPREGUNTANOMI);
			reporte.setsDescripcion(EvaluacionesPeriodosConstantesFunciones.LABEL_IDFORMATONOMIPREGUNTANOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesPeriodosConstantesFunciones.LABEL_VALORCONOCIMIENTO);
			reporte.setsDescripcion(EvaluacionesPeriodosConstantesFunciones.LABEL_VALORCONOCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesPeriodosConstantesFunciones.LABEL_VALOREFICIENCIA);
			reporte.setsDescripcion(EvaluacionesPeriodosConstantesFunciones.LABEL_VALOREFICIENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesPeriodosConstantesFunciones.LABEL_VALOROBTENIDO);
			reporte.setsDescripcion(EvaluacionesPeriodosConstantesFunciones.LABEL_VALOROBTENIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesPeriodosConstantesFunciones.LABEL_PROMEDIO);
			reporte.setsDescripcion(EvaluacionesPeriodosConstantesFunciones.LABEL_PROMEDIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEvaluacionesPeriodos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEvaluacionesPeriodos(EvaluacionesPeriodos evaluacionesperiodosAux) throws Exception {
		
			evaluacionesperiodosAux.settipocalificacionempleado_descripcion(TipoCalificacionEmpleadoConstantesFunciones.getTipoCalificacionEmpleadoDescripcion(evaluacionesperiodosAux.getTipoCalificacionEmpleado()));
			evaluacionesperiodosAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(evaluacionesperiodosAux.getEstructura()));
			evaluacionesperiodosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(evaluacionesperiodosAux.getEmpresa()));
			evaluacionesperiodosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(evaluacionesperiodosAux.getSucursal()));
			evaluacionesperiodosAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(evaluacionesperiodosAux.getEjercicio()));
			evaluacionesperiodosAux.settipoevaluacionempleado_descripcion(TipoEvaluacionEmpleadoConstantesFunciones.getTipoEvaluacionEmpleadoDescripcion(evaluacionesperiodosAux.getTipoEvaluacionEmpleado()));
			evaluacionesperiodosAux.setformatonomipreguntanomi_descripcion(FormatoNomiPreguntaNomiConstantesFunciones.getFormatoNomiPreguntaNomiDescripcion(evaluacionesperiodosAux.getFormatoNomiPreguntaNomi()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEvaluacionesPeriodos(List<EvaluacionesPeriodos> evaluacionesperiodossTemp) throws Exception {
		for(EvaluacionesPeriodos evaluacionesperiodosAux:evaluacionesperiodossTemp) {
			
			evaluacionesperiodosAux.settipocalificacionempleado_descripcion(TipoCalificacionEmpleadoConstantesFunciones.getTipoCalificacionEmpleadoDescripcion(evaluacionesperiodosAux.getTipoCalificacionEmpleado()));
			evaluacionesperiodosAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(evaluacionesperiodosAux.getEstructura()));
			evaluacionesperiodosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(evaluacionesperiodosAux.getEmpresa()));
			evaluacionesperiodosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(evaluacionesperiodosAux.getSucursal()));
			evaluacionesperiodosAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(evaluacionesperiodosAux.getEjercicio()));
			evaluacionesperiodosAux.settipoevaluacionempleado_descripcion(TipoEvaluacionEmpleadoConstantesFunciones.getTipoEvaluacionEmpleadoDescripcion(evaluacionesperiodosAux.getTipoEvaluacionEmpleado()));
			evaluacionesperiodosAux.setformatonomipreguntanomi_descripcion(FormatoNomiPreguntaNomiConstantesFunciones.getFormatoNomiPreguntaNomiDescripcion(evaluacionesperiodosAux.getFormatoNomiPreguntaNomi()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEvaluacionesPeriodos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TipoCalificacionEmpleado.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(TipoEvaluacionEmpleado.class));
				classes.add(new Classe(FormatoNomiPreguntaNomi.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCalificacionEmpleado.class)) {
						classes.add(new Classe(TipoCalificacionEmpleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
					}
				}

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
					if(clas.clas.equals(TipoEvaluacionEmpleado.class)) {
						classes.add(new Classe(TipoEvaluacionEmpleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FormatoNomiPreguntaNomi.class)) {
						classes.add(new Classe(FormatoNomiPreguntaNomi.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEvaluacionesPeriodos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoCalificacionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCalificacionEmpleado.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(TipoEvaluacionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoEvaluacionEmpleado.class)); continue;
					}

					if(FormatoNomiPreguntaNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomiPreguntaNomi.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoCalificacionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCalificacionEmpleado.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(TipoEvaluacionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoEvaluacionEmpleado.class)); continue;
					}

					if(FormatoNomiPreguntaNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomiPreguntaNomi.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEvaluacionesPeriodos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EvaluacionesPeriodosConstantesFunciones.getClassesRelationshipsOfEvaluacionesPeriodos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEvaluacionesPeriodos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEvaluacionesPeriodos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EvaluacionesPeriodosConstantesFunciones.getClassesRelationshipsFromStringsOfEvaluacionesPeriodos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEvaluacionesPeriodos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(EvaluacionesPeriodos evaluacionesperiodos,List<EvaluacionesPeriodos> evaluacionesperiodoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(EvaluacionesPeriodos evaluacionesperiodos,List<EvaluacionesPeriodos> evaluacionesperiodoss) throws Exception {
		try	{			
			for(EvaluacionesPeriodos evaluacionesperiodosLocal:evaluacionesperiodoss) {
				if(evaluacionesperiodosLocal.getId().equals(evaluacionesperiodos.getId())) {
					evaluacionesperiodosLocal.setIsSelected(evaluacionesperiodos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEvaluacionesPeriodos(List<EvaluacionesPeriodos> evaluacionesperiodossAux) throws Exception {
		//this.evaluacionesperiodossAux=evaluacionesperiodossAux;
		
		for(EvaluacionesPeriodos evaluacionesperiodosAux:evaluacionesperiodossAux) {
			if(evaluacionesperiodosAux.getIsChanged()) {
				evaluacionesperiodosAux.setIsChanged(false);
			}		
			
			if(evaluacionesperiodosAux.getIsNew()) {
				evaluacionesperiodosAux.setIsNew(false);
			}	
			
			if(evaluacionesperiodosAux.getIsDeleted()) {
				evaluacionesperiodosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEvaluacionesPeriodos(EvaluacionesPeriodos evaluacionesperiodosAux) throws Exception {
		//this.evaluacionesperiodosAux=evaluacionesperiodosAux;
		
			if(evaluacionesperiodosAux.getIsChanged()) {
				evaluacionesperiodosAux.setIsChanged(false);
			}		
			
			if(evaluacionesperiodosAux.getIsNew()) {
				evaluacionesperiodosAux.setIsNew(false);
			}	
			
			if(evaluacionesperiodosAux.getIsDeleted()) {
				evaluacionesperiodosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EvaluacionesPeriodos evaluacionesperiodosAsignar,EvaluacionesPeriodos evaluacionesperiodos) throws Exception {
		evaluacionesperiodosAsignar.setId(evaluacionesperiodos.getId());	
		evaluacionesperiodosAsignar.setVersionRow(evaluacionesperiodos.getVersionRow());	
		evaluacionesperiodosAsignar.setcodigo_dato(evaluacionesperiodos.getcodigo_dato());	
		evaluacionesperiodosAsignar.setnombre_completo(evaluacionesperiodos.getnombre_completo());	
		evaluacionesperiodosAsignar.setid_formato_nomi_pregunta_nomi(evaluacionesperiodos.getid_formato_nomi_pregunta_nomi());
		evaluacionesperiodosAsignar.setformatonomipreguntanomi_descripcion(evaluacionesperiodos.getformatonomipreguntanomi_descripcion());	
		evaluacionesperiodosAsignar.setvalor_conocimiento(evaluacionesperiodos.getvalor_conocimiento());	
		evaluacionesperiodosAsignar.setvalor_eficiencia(evaluacionesperiodos.getvalor_eficiencia());	
		evaluacionesperiodosAsignar.setvalor_obtenido(evaluacionesperiodos.getvalor_obtenido());	
		evaluacionesperiodosAsignar.setpromedio(evaluacionesperiodos.getpromedio());	
	}
	
	public static void inicializarEvaluacionesPeriodos(EvaluacionesPeriodos evaluacionesperiodos) throws Exception {
		try {
				evaluacionesperiodos.setId(0L);	
					
				evaluacionesperiodos.setcodigo_dato("");	
				evaluacionesperiodos.setnombre_completo("");	
				evaluacionesperiodos.setid_formato_nomi_pregunta_nomi(-1L);	
				evaluacionesperiodos.setvalor_conocimiento(0.0);	
				evaluacionesperiodos.setvalor_eficiencia(0.0);	
				evaluacionesperiodos.setvalor_obtenido(0.0);	
				evaluacionesperiodos.setpromedio(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEvaluacionesPeriodos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesPeriodosConstantesFunciones.LABEL_IDTIPOCALIFICACIONEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesPeriodosConstantesFunciones.LABEL_VERIFICADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesPeriodosConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesPeriodosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesPeriodosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesPeriodosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesPeriodosConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesPeriodosConstantesFunciones.LABEL_IDTIPOEVALUACIONEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesPeriodosConstantesFunciones.LABEL_CODIGODATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesPeriodosConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesPeriodosConstantesFunciones.LABEL_IDFORMATONOMIPREGUNTANOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesPeriodosConstantesFunciones.LABEL_VALORCONOCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesPeriodosConstantesFunciones.LABEL_VALOREFICIENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesPeriodosConstantesFunciones.LABEL_VALOROBTENIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesPeriodosConstantesFunciones.LABEL_PROMEDIO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEvaluacionesPeriodos(String sTipo,Row row,Workbook workbook,EvaluacionesPeriodos evaluacionesperiodos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesperiodos.gettipocalificacionempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(evaluacionesperiodos.getverificado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesperiodos.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesperiodos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesperiodos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesperiodos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesperiodos.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesperiodos.gettipoevaluacionempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesperiodos.getcodigo_dato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesperiodos.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesperiodos.getformatonomipreguntanomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesperiodos.getvalor_conocimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesperiodos.getvalor_eficiencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesperiodos.getvalor_obtenido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesperiodos.getpromedio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEvaluacionesPeriodos="";
	
	public String getsFinalQueryEvaluacionesPeriodos() {
		return this.sFinalQueryEvaluacionesPeriodos;
	}
	
	public void setsFinalQueryEvaluacionesPeriodos(String sFinalQueryEvaluacionesPeriodos) {
		this.sFinalQueryEvaluacionesPeriodos= sFinalQueryEvaluacionesPeriodos;
	}
	
	public Border resaltarSeleccionarEvaluacionesPeriodos=null;
	
	public Border setResaltarSeleccionarEvaluacionesPeriodos(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesPeriodosBeanSwingJInternalFrame evaluacionesperiodosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//evaluacionesperiodosBeanSwingJInternalFrame.jTtoolBarEvaluacionesPeriodos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEvaluacionesPeriodos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEvaluacionesPeriodos() {
		return this.resaltarSeleccionarEvaluacionesPeriodos;
	}
	
	public void setResaltarSeleccionarEvaluacionesPeriodos(Border borderResaltarSeleccionarEvaluacionesPeriodos) {
		this.resaltarSeleccionarEvaluacionesPeriodos= borderResaltarSeleccionarEvaluacionesPeriodos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEvaluacionesPeriodos=null;
	public Boolean mostraridEvaluacionesPeriodos=true;
	public Boolean activaridEvaluacionesPeriodos=true;

	public Border resaltarid_tipo_calificacion_empleadoEvaluacionesPeriodos=null;
	public Boolean mostrarid_tipo_calificacion_empleadoEvaluacionesPeriodos=true;
	public Boolean activarid_tipo_calificacion_empleadoEvaluacionesPeriodos=true;
	public Boolean cargarid_tipo_calificacion_empleadoEvaluacionesPeriodos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_calificacion_empleadoEvaluacionesPeriodos=false;//ConEventDepend=true

	public Border resaltarverificadoEvaluacionesPeriodos=null;
	public Boolean mostrarverificadoEvaluacionesPeriodos=true;
	public Boolean activarverificadoEvaluacionesPeriodos=true;

	public Border resaltarid_estructuraEvaluacionesPeriodos=null;
	public Boolean mostrarid_estructuraEvaluacionesPeriodos=true;
	public Boolean activarid_estructuraEvaluacionesPeriodos=true;
	public Boolean cargarid_estructuraEvaluacionesPeriodos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraEvaluacionesPeriodos=false;//ConEventDepend=true

	public Border resaltarcodigoEvaluacionesPeriodos=null;
	public Boolean mostrarcodigoEvaluacionesPeriodos=true;
	public Boolean activarcodigoEvaluacionesPeriodos=true;

	public Border resaltarid_empresaEvaluacionesPeriodos=null;
	public Boolean mostrarid_empresaEvaluacionesPeriodos=true;
	public Boolean activarid_empresaEvaluacionesPeriodos=true;
	public Boolean cargarid_empresaEvaluacionesPeriodos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEvaluacionesPeriodos=false;//ConEventDepend=true

	public Border resaltarid_sucursalEvaluacionesPeriodos=null;
	public Boolean mostrarid_sucursalEvaluacionesPeriodos=true;
	public Boolean activarid_sucursalEvaluacionesPeriodos=true;
	public Boolean cargarid_sucursalEvaluacionesPeriodos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalEvaluacionesPeriodos=false;//ConEventDepend=true

	public Border resaltarid_ejercicioEvaluacionesPeriodos=null;
	public Boolean mostrarid_ejercicioEvaluacionesPeriodos=true;
	public Boolean activarid_ejercicioEvaluacionesPeriodos=true;
	public Boolean cargarid_ejercicioEvaluacionesPeriodos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioEvaluacionesPeriodos=false;//ConEventDepend=true

	public Border resaltarid_tipo_evaluacion_empleadoEvaluacionesPeriodos=null;
	public Boolean mostrarid_tipo_evaluacion_empleadoEvaluacionesPeriodos=true;
	public Boolean activarid_tipo_evaluacion_empleadoEvaluacionesPeriodos=true;
	public Boolean cargarid_tipo_evaluacion_empleadoEvaluacionesPeriodos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_evaluacion_empleadoEvaluacionesPeriodos=false;//ConEventDepend=true

	public Border resaltarcodigo_datoEvaluacionesPeriodos=null;
	public Boolean mostrarcodigo_datoEvaluacionesPeriodos=true;
	public Boolean activarcodigo_datoEvaluacionesPeriodos=true;

	public Border resaltarnombre_completoEvaluacionesPeriodos=null;
	public Boolean mostrarnombre_completoEvaluacionesPeriodos=true;
	public Boolean activarnombre_completoEvaluacionesPeriodos=true;

	public Border resaltarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos=null;
	public Boolean mostrarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos=true;
	public Boolean activarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos=true;
	public Boolean cargarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_nomi_pregunta_nomiEvaluacionesPeriodos=false;//ConEventDepend=true

	public Border resaltarvalor_conocimientoEvaluacionesPeriodos=null;
	public Boolean mostrarvalor_conocimientoEvaluacionesPeriodos=true;
	public Boolean activarvalor_conocimientoEvaluacionesPeriodos=true;

	public Border resaltarvalor_eficienciaEvaluacionesPeriodos=null;
	public Boolean mostrarvalor_eficienciaEvaluacionesPeriodos=true;
	public Boolean activarvalor_eficienciaEvaluacionesPeriodos=true;

	public Border resaltarvalor_obtenidoEvaluacionesPeriodos=null;
	public Boolean mostrarvalor_obtenidoEvaluacionesPeriodos=true;
	public Boolean activarvalor_obtenidoEvaluacionesPeriodos=true;

	public Border resaltarpromedioEvaluacionesPeriodos=null;
	public Boolean mostrarpromedioEvaluacionesPeriodos=true;
	public Boolean activarpromedioEvaluacionesPeriodos=true;

	
	

	public Border setResaltaridEvaluacionesPeriodos(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesPeriodosBeanSwingJInternalFrame evaluacionesperiodosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesperiodosBeanSwingJInternalFrame.jTtoolBarEvaluacionesPeriodos.setBorder(borderResaltar);
		
		this.resaltaridEvaluacionesPeriodos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEvaluacionesPeriodos() {
		return this.resaltaridEvaluacionesPeriodos;
	}

	public void setResaltaridEvaluacionesPeriodos(Border borderResaltar) {
		this.resaltaridEvaluacionesPeriodos= borderResaltar;
	}

	public Boolean getMostraridEvaluacionesPeriodos() {
		return this.mostraridEvaluacionesPeriodos;
	}

	public void setMostraridEvaluacionesPeriodos(Boolean mostraridEvaluacionesPeriodos) {
		this.mostraridEvaluacionesPeriodos= mostraridEvaluacionesPeriodos;
	}

	public Boolean getActivaridEvaluacionesPeriodos() {
		return this.activaridEvaluacionesPeriodos;
	}

	public void setActivaridEvaluacionesPeriodos(Boolean activaridEvaluacionesPeriodos) {
		this.activaridEvaluacionesPeriodos= activaridEvaluacionesPeriodos;
	}

	public Border setResaltarid_tipo_calificacion_empleadoEvaluacionesPeriodos(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesPeriodosBeanSwingJInternalFrame evaluacionesperiodosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesperiodosBeanSwingJInternalFrame.jTtoolBarEvaluacionesPeriodos.setBorder(borderResaltar);
		
		this.resaltarid_tipo_calificacion_empleadoEvaluacionesPeriodos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_calificacion_empleadoEvaluacionesPeriodos() {
		return this.resaltarid_tipo_calificacion_empleadoEvaluacionesPeriodos;
	}

	public void setResaltarid_tipo_calificacion_empleadoEvaluacionesPeriodos(Border borderResaltar) {
		this.resaltarid_tipo_calificacion_empleadoEvaluacionesPeriodos= borderResaltar;
	}

	public Boolean getMostrarid_tipo_calificacion_empleadoEvaluacionesPeriodos() {
		return this.mostrarid_tipo_calificacion_empleadoEvaluacionesPeriodos;
	}

	public void setMostrarid_tipo_calificacion_empleadoEvaluacionesPeriodos(Boolean mostrarid_tipo_calificacion_empleadoEvaluacionesPeriodos) {
		this.mostrarid_tipo_calificacion_empleadoEvaluacionesPeriodos= mostrarid_tipo_calificacion_empleadoEvaluacionesPeriodos;
	}

	public Boolean getActivarid_tipo_calificacion_empleadoEvaluacionesPeriodos() {
		return this.activarid_tipo_calificacion_empleadoEvaluacionesPeriodos;
	}

	public void setActivarid_tipo_calificacion_empleadoEvaluacionesPeriodos(Boolean activarid_tipo_calificacion_empleadoEvaluacionesPeriodos) {
		this.activarid_tipo_calificacion_empleadoEvaluacionesPeriodos= activarid_tipo_calificacion_empleadoEvaluacionesPeriodos;
	}

	public Boolean getCargarid_tipo_calificacion_empleadoEvaluacionesPeriodos() {
		return this.cargarid_tipo_calificacion_empleadoEvaluacionesPeriodos;
	}

	public void setCargarid_tipo_calificacion_empleadoEvaluacionesPeriodos(Boolean cargarid_tipo_calificacion_empleadoEvaluacionesPeriodos) {
		this.cargarid_tipo_calificacion_empleadoEvaluacionesPeriodos= cargarid_tipo_calificacion_empleadoEvaluacionesPeriodos;
	}

	public Border setResaltarverificadoEvaluacionesPeriodos(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesPeriodosBeanSwingJInternalFrame evaluacionesperiodosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesperiodosBeanSwingJInternalFrame.jTtoolBarEvaluacionesPeriodos.setBorder(borderResaltar);
		
		this.resaltarverificadoEvaluacionesPeriodos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarverificadoEvaluacionesPeriodos() {
		return this.resaltarverificadoEvaluacionesPeriodos;
	}

	public void setResaltarverificadoEvaluacionesPeriodos(Border borderResaltar) {
		this.resaltarverificadoEvaluacionesPeriodos= borderResaltar;
	}

	public Boolean getMostrarverificadoEvaluacionesPeriodos() {
		return this.mostrarverificadoEvaluacionesPeriodos;
	}

	public void setMostrarverificadoEvaluacionesPeriodos(Boolean mostrarverificadoEvaluacionesPeriodos) {
		this.mostrarverificadoEvaluacionesPeriodos= mostrarverificadoEvaluacionesPeriodos;
	}

	public Boolean getActivarverificadoEvaluacionesPeriodos() {
		return this.activarverificadoEvaluacionesPeriodos;
	}

	public void setActivarverificadoEvaluacionesPeriodos(Boolean activarverificadoEvaluacionesPeriodos) {
		this.activarverificadoEvaluacionesPeriodos= activarverificadoEvaluacionesPeriodos;
	}

	public Border setResaltarid_estructuraEvaluacionesPeriodos(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesPeriodosBeanSwingJInternalFrame evaluacionesperiodosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesperiodosBeanSwingJInternalFrame.jTtoolBarEvaluacionesPeriodos.setBorder(borderResaltar);
		
		this.resaltarid_estructuraEvaluacionesPeriodos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraEvaluacionesPeriodos() {
		return this.resaltarid_estructuraEvaluacionesPeriodos;
	}

	public void setResaltarid_estructuraEvaluacionesPeriodos(Border borderResaltar) {
		this.resaltarid_estructuraEvaluacionesPeriodos= borderResaltar;
	}

	public Boolean getMostrarid_estructuraEvaluacionesPeriodos() {
		return this.mostrarid_estructuraEvaluacionesPeriodos;
	}

	public void setMostrarid_estructuraEvaluacionesPeriodos(Boolean mostrarid_estructuraEvaluacionesPeriodos) {
		this.mostrarid_estructuraEvaluacionesPeriodos= mostrarid_estructuraEvaluacionesPeriodos;
	}

	public Boolean getActivarid_estructuraEvaluacionesPeriodos() {
		return this.activarid_estructuraEvaluacionesPeriodos;
	}

	public void setActivarid_estructuraEvaluacionesPeriodos(Boolean activarid_estructuraEvaluacionesPeriodos) {
		this.activarid_estructuraEvaluacionesPeriodos= activarid_estructuraEvaluacionesPeriodos;
	}

	public Boolean getCargarid_estructuraEvaluacionesPeriodos() {
		return this.cargarid_estructuraEvaluacionesPeriodos;
	}

	public void setCargarid_estructuraEvaluacionesPeriodos(Boolean cargarid_estructuraEvaluacionesPeriodos) {
		this.cargarid_estructuraEvaluacionesPeriodos= cargarid_estructuraEvaluacionesPeriodos;
	}

	public Border setResaltarcodigoEvaluacionesPeriodos(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesPeriodosBeanSwingJInternalFrame evaluacionesperiodosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesperiodosBeanSwingJInternalFrame.jTtoolBarEvaluacionesPeriodos.setBorder(borderResaltar);
		
		this.resaltarcodigoEvaluacionesPeriodos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEvaluacionesPeriodos() {
		return this.resaltarcodigoEvaluacionesPeriodos;
	}

	public void setResaltarcodigoEvaluacionesPeriodos(Border borderResaltar) {
		this.resaltarcodigoEvaluacionesPeriodos= borderResaltar;
	}

	public Boolean getMostrarcodigoEvaluacionesPeriodos() {
		return this.mostrarcodigoEvaluacionesPeriodos;
	}

	public void setMostrarcodigoEvaluacionesPeriodos(Boolean mostrarcodigoEvaluacionesPeriodos) {
		this.mostrarcodigoEvaluacionesPeriodos= mostrarcodigoEvaluacionesPeriodos;
	}

	public Boolean getActivarcodigoEvaluacionesPeriodos() {
		return this.activarcodigoEvaluacionesPeriodos;
	}

	public void setActivarcodigoEvaluacionesPeriodos(Boolean activarcodigoEvaluacionesPeriodos) {
		this.activarcodigoEvaluacionesPeriodos= activarcodigoEvaluacionesPeriodos;
	}

	public Border setResaltarid_empresaEvaluacionesPeriodos(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesPeriodosBeanSwingJInternalFrame evaluacionesperiodosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesperiodosBeanSwingJInternalFrame.jTtoolBarEvaluacionesPeriodos.setBorder(borderResaltar);
		
		this.resaltarid_empresaEvaluacionesPeriodos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEvaluacionesPeriodos() {
		return this.resaltarid_empresaEvaluacionesPeriodos;
	}

	public void setResaltarid_empresaEvaluacionesPeriodos(Border borderResaltar) {
		this.resaltarid_empresaEvaluacionesPeriodos= borderResaltar;
	}

	public Boolean getMostrarid_empresaEvaluacionesPeriodos() {
		return this.mostrarid_empresaEvaluacionesPeriodos;
	}

	public void setMostrarid_empresaEvaluacionesPeriodos(Boolean mostrarid_empresaEvaluacionesPeriodos) {
		this.mostrarid_empresaEvaluacionesPeriodos= mostrarid_empresaEvaluacionesPeriodos;
	}

	public Boolean getActivarid_empresaEvaluacionesPeriodos() {
		return this.activarid_empresaEvaluacionesPeriodos;
	}

	public void setActivarid_empresaEvaluacionesPeriodos(Boolean activarid_empresaEvaluacionesPeriodos) {
		this.activarid_empresaEvaluacionesPeriodos= activarid_empresaEvaluacionesPeriodos;
	}

	public Boolean getCargarid_empresaEvaluacionesPeriodos() {
		return this.cargarid_empresaEvaluacionesPeriodos;
	}

	public void setCargarid_empresaEvaluacionesPeriodos(Boolean cargarid_empresaEvaluacionesPeriodos) {
		this.cargarid_empresaEvaluacionesPeriodos= cargarid_empresaEvaluacionesPeriodos;
	}

	public Border setResaltarid_sucursalEvaluacionesPeriodos(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesPeriodosBeanSwingJInternalFrame evaluacionesperiodosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesperiodosBeanSwingJInternalFrame.jTtoolBarEvaluacionesPeriodos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalEvaluacionesPeriodos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalEvaluacionesPeriodos() {
		return this.resaltarid_sucursalEvaluacionesPeriodos;
	}

	public void setResaltarid_sucursalEvaluacionesPeriodos(Border borderResaltar) {
		this.resaltarid_sucursalEvaluacionesPeriodos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalEvaluacionesPeriodos() {
		return this.mostrarid_sucursalEvaluacionesPeriodos;
	}

	public void setMostrarid_sucursalEvaluacionesPeriodos(Boolean mostrarid_sucursalEvaluacionesPeriodos) {
		this.mostrarid_sucursalEvaluacionesPeriodos= mostrarid_sucursalEvaluacionesPeriodos;
	}

	public Boolean getActivarid_sucursalEvaluacionesPeriodos() {
		return this.activarid_sucursalEvaluacionesPeriodos;
	}

	public void setActivarid_sucursalEvaluacionesPeriodos(Boolean activarid_sucursalEvaluacionesPeriodos) {
		this.activarid_sucursalEvaluacionesPeriodos= activarid_sucursalEvaluacionesPeriodos;
	}

	public Boolean getCargarid_sucursalEvaluacionesPeriodos() {
		return this.cargarid_sucursalEvaluacionesPeriodos;
	}

	public void setCargarid_sucursalEvaluacionesPeriodos(Boolean cargarid_sucursalEvaluacionesPeriodos) {
		this.cargarid_sucursalEvaluacionesPeriodos= cargarid_sucursalEvaluacionesPeriodos;
	}

	public Border setResaltarid_ejercicioEvaluacionesPeriodos(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesPeriodosBeanSwingJInternalFrame evaluacionesperiodosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesperiodosBeanSwingJInternalFrame.jTtoolBarEvaluacionesPeriodos.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioEvaluacionesPeriodos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioEvaluacionesPeriodos() {
		return this.resaltarid_ejercicioEvaluacionesPeriodos;
	}

	public void setResaltarid_ejercicioEvaluacionesPeriodos(Border borderResaltar) {
		this.resaltarid_ejercicioEvaluacionesPeriodos= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioEvaluacionesPeriodos() {
		return this.mostrarid_ejercicioEvaluacionesPeriodos;
	}

	public void setMostrarid_ejercicioEvaluacionesPeriodos(Boolean mostrarid_ejercicioEvaluacionesPeriodos) {
		this.mostrarid_ejercicioEvaluacionesPeriodos= mostrarid_ejercicioEvaluacionesPeriodos;
	}

	public Boolean getActivarid_ejercicioEvaluacionesPeriodos() {
		return this.activarid_ejercicioEvaluacionesPeriodos;
	}

	public void setActivarid_ejercicioEvaluacionesPeriodos(Boolean activarid_ejercicioEvaluacionesPeriodos) {
		this.activarid_ejercicioEvaluacionesPeriodos= activarid_ejercicioEvaluacionesPeriodos;
	}

	public Boolean getCargarid_ejercicioEvaluacionesPeriodos() {
		return this.cargarid_ejercicioEvaluacionesPeriodos;
	}

	public void setCargarid_ejercicioEvaluacionesPeriodos(Boolean cargarid_ejercicioEvaluacionesPeriodos) {
		this.cargarid_ejercicioEvaluacionesPeriodos= cargarid_ejercicioEvaluacionesPeriodos;
	}

	public Border setResaltarid_tipo_evaluacion_empleadoEvaluacionesPeriodos(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesPeriodosBeanSwingJInternalFrame evaluacionesperiodosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesperiodosBeanSwingJInternalFrame.jTtoolBarEvaluacionesPeriodos.setBorder(borderResaltar);
		
		this.resaltarid_tipo_evaluacion_empleadoEvaluacionesPeriodos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_evaluacion_empleadoEvaluacionesPeriodos() {
		return this.resaltarid_tipo_evaluacion_empleadoEvaluacionesPeriodos;
	}

	public void setResaltarid_tipo_evaluacion_empleadoEvaluacionesPeriodos(Border borderResaltar) {
		this.resaltarid_tipo_evaluacion_empleadoEvaluacionesPeriodos= borderResaltar;
	}

	public Boolean getMostrarid_tipo_evaluacion_empleadoEvaluacionesPeriodos() {
		return this.mostrarid_tipo_evaluacion_empleadoEvaluacionesPeriodos;
	}

	public void setMostrarid_tipo_evaluacion_empleadoEvaluacionesPeriodos(Boolean mostrarid_tipo_evaluacion_empleadoEvaluacionesPeriodos) {
		this.mostrarid_tipo_evaluacion_empleadoEvaluacionesPeriodos= mostrarid_tipo_evaluacion_empleadoEvaluacionesPeriodos;
	}

	public Boolean getActivarid_tipo_evaluacion_empleadoEvaluacionesPeriodos() {
		return this.activarid_tipo_evaluacion_empleadoEvaluacionesPeriodos;
	}

	public void setActivarid_tipo_evaluacion_empleadoEvaluacionesPeriodos(Boolean activarid_tipo_evaluacion_empleadoEvaluacionesPeriodos) {
		this.activarid_tipo_evaluacion_empleadoEvaluacionesPeriodos= activarid_tipo_evaluacion_empleadoEvaluacionesPeriodos;
	}

	public Boolean getCargarid_tipo_evaluacion_empleadoEvaluacionesPeriodos() {
		return this.cargarid_tipo_evaluacion_empleadoEvaluacionesPeriodos;
	}

	public void setCargarid_tipo_evaluacion_empleadoEvaluacionesPeriodos(Boolean cargarid_tipo_evaluacion_empleadoEvaluacionesPeriodos) {
		this.cargarid_tipo_evaluacion_empleadoEvaluacionesPeriodos= cargarid_tipo_evaluacion_empleadoEvaluacionesPeriodos;
	}

	public Border setResaltarcodigo_datoEvaluacionesPeriodos(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesPeriodosBeanSwingJInternalFrame evaluacionesperiodosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesperiodosBeanSwingJInternalFrame.jTtoolBarEvaluacionesPeriodos.setBorder(borderResaltar);
		
		this.resaltarcodigo_datoEvaluacionesPeriodos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_datoEvaluacionesPeriodos() {
		return this.resaltarcodigo_datoEvaluacionesPeriodos;
	}

	public void setResaltarcodigo_datoEvaluacionesPeriodos(Border borderResaltar) {
		this.resaltarcodigo_datoEvaluacionesPeriodos= borderResaltar;
	}

	public Boolean getMostrarcodigo_datoEvaluacionesPeriodos() {
		return this.mostrarcodigo_datoEvaluacionesPeriodos;
	}

	public void setMostrarcodigo_datoEvaluacionesPeriodos(Boolean mostrarcodigo_datoEvaluacionesPeriodos) {
		this.mostrarcodigo_datoEvaluacionesPeriodos= mostrarcodigo_datoEvaluacionesPeriodos;
	}

	public Boolean getActivarcodigo_datoEvaluacionesPeriodos() {
		return this.activarcodigo_datoEvaluacionesPeriodos;
	}

	public void setActivarcodigo_datoEvaluacionesPeriodos(Boolean activarcodigo_datoEvaluacionesPeriodos) {
		this.activarcodigo_datoEvaluacionesPeriodos= activarcodigo_datoEvaluacionesPeriodos;
	}

	public Border setResaltarnombre_completoEvaluacionesPeriodos(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesPeriodosBeanSwingJInternalFrame evaluacionesperiodosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesperiodosBeanSwingJInternalFrame.jTtoolBarEvaluacionesPeriodos.setBorder(borderResaltar);
		
		this.resaltarnombre_completoEvaluacionesPeriodos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoEvaluacionesPeriodos() {
		return this.resaltarnombre_completoEvaluacionesPeriodos;
	}

	public void setResaltarnombre_completoEvaluacionesPeriodos(Border borderResaltar) {
		this.resaltarnombre_completoEvaluacionesPeriodos= borderResaltar;
	}

	public Boolean getMostrarnombre_completoEvaluacionesPeriodos() {
		return this.mostrarnombre_completoEvaluacionesPeriodos;
	}

	public void setMostrarnombre_completoEvaluacionesPeriodos(Boolean mostrarnombre_completoEvaluacionesPeriodos) {
		this.mostrarnombre_completoEvaluacionesPeriodos= mostrarnombre_completoEvaluacionesPeriodos;
	}

	public Boolean getActivarnombre_completoEvaluacionesPeriodos() {
		return this.activarnombre_completoEvaluacionesPeriodos;
	}

	public void setActivarnombre_completoEvaluacionesPeriodos(Boolean activarnombre_completoEvaluacionesPeriodos) {
		this.activarnombre_completoEvaluacionesPeriodos= activarnombre_completoEvaluacionesPeriodos;
	}

	public Border setResaltarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesPeriodosBeanSwingJInternalFrame evaluacionesperiodosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesperiodosBeanSwingJInternalFrame.jTtoolBarEvaluacionesPeriodos.setBorder(borderResaltar);
		
		this.resaltarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos() {
		return this.resaltarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos;
	}

	public void setResaltarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos(Border borderResaltar) {
		this.resaltarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos= borderResaltar;
	}

	public Boolean getMostrarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos() {
		return this.mostrarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos;
	}

	public void setMostrarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos(Boolean mostrarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos) {
		this.mostrarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos= mostrarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos;
	}

	public Boolean getActivarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos() {
		return this.activarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos;
	}

	public void setActivarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos(Boolean activarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos) {
		this.activarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos= activarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos;
	}

	public Boolean getCargarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos() {
		return this.cargarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos;
	}

	public void setCargarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos(Boolean cargarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos) {
		this.cargarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos= cargarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos;
	}

	public Border setResaltarvalor_conocimientoEvaluacionesPeriodos(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesPeriodosBeanSwingJInternalFrame evaluacionesperiodosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesperiodosBeanSwingJInternalFrame.jTtoolBarEvaluacionesPeriodos.setBorder(borderResaltar);
		
		this.resaltarvalor_conocimientoEvaluacionesPeriodos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_conocimientoEvaluacionesPeriodos() {
		return this.resaltarvalor_conocimientoEvaluacionesPeriodos;
	}

	public void setResaltarvalor_conocimientoEvaluacionesPeriodos(Border borderResaltar) {
		this.resaltarvalor_conocimientoEvaluacionesPeriodos= borderResaltar;
	}

	public Boolean getMostrarvalor_conocimientoEvaluacionesPeriodos() {
		return this.mostrarvalor_conocimientoEvaluacionesPeriodos;
	}

	public void setMostrarvalor_conocimientoEvaluacionesPeriodos(Boolean mostrarvalor_conocimientoEvaluacionesPeriodos) {
		this.mostrarvalor_conocimientoEvaluacionesPeriodos= mostrarvalor_conocimientoEvaluacionesPeriodos;
	}

	public Boolean getActivarvalor_conocimientoEvaluacionesPeriodos() {
		return this.activarvalor_conocimientoEvaluacionesPeriodos;
	}

	public void setActivarvalor_conocimientoEvaluacionesPeriodos(Boolean activarvalor_conocimientoEvaluacionesPeriodos) {
		this.activarvalor_conocimientoEvaluacionesPeriodos= activarvalor_conocimientoEvaluacionesPeriodos;
	}

	public Border setResaltarvalor_eficienciaEvaluacionesPeriodos(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesPeriodosBeanSwingJInternalFrame evaluacionesperiodosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesperiodosBeanSwingJInternalFrame.jTtoolBarEvaluacionesPeriodos.setBorder(borderResaltar);
		
		this.resaltarvalor_eficienciaEvaluacionesPeriodos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_eficienciaEvaluacionesPeriodos() {
		return this.resaltarvalor_eficienciaEvaluacionesPeriodos;
	}

	public void setResaltarvalor_eficienciaEvaluacionesPeriodos(Border borderResaltar) {
		this.resaltarvalor_eficienciaEvaluacionesPeriodos= borderResaltar;
	}

	public Boolean getMostrarvalor_eficienciaEvaluacionesPeriodos() {
		return this.mostrarvalor_eficienciaEvaluacionesPeriodos;
	}

	public void setMostrarvalor_eficienciaEvaluacionesPeriodos(Boolean mostrarvalor_eficienciaEvaluacionesPeriodos) {
		this.mostrarvalor_eficienciaEvaluacionesPeriodos= mostrarvalor_eficienciaEvaluacionesPeriodos;
	}

	public Boolean getActivarvalor_eficienciaEvaluacionesPeriodos() {
		return this.activarvalor_eficienciaEvaluacionesPeriodos;
	}

	public void setActivarvalor_eficienciaEvaluacionesPeriodos(Boolean activarvalor_eficienciaEvaluacionesPeriodos) {
		this.activarvalor_eficienciaEvaluacionesPeriodos= activarvalor_eficienciaEvaluacionesPeriodos;
	}

	public Border setResaltarvalor_obtenidoEvaluacionesPeriodos(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesPeriodosBeanSwingJInternalFrame evaluacionesperiodosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesperiodosBeanSwingJInternalFrame.jTtoolBarEvaluacionesPeriodos.setBorder(borderResaltar);
		
		this.resaltarvalor_obtenidoEvaluacionesPeriodos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_obtenidoEvaluacionesPeriodos() {
		return this.resaltarvalor_obtenidoEvaluacionesPeriodos;
	}

	public void setResaltarvalor_obtenidoEvaluacionesPeriodos(Border borderResaltar) {
		this.resaltarvalor_obtenidoEvaluacionesPeriodos= borderResaltar;
	}

	public Boolean getMostrarvalor_obtenidoEvaluacionesPeriodos() {
		return this.mostrarvalor_obtenidoEvaluacionesPeriodos;
	}

	public void setMostrarvalor_obtenidoEvaluacionesPeriodos(Boolean mostrarvalor_obtenidoEvaluacionesPeriodos) {
		this.mostrarvalor_obtenidoEvaluacionesPeriodos= mostrarvalor_obtenidoEvaluacionesPeriodos;
	}

	public Boolean getActivarvalor_obtenidoEvaluacionesPeriodos() {
		return this.activarvalor_obtenidoEvaluacionesPeriodos;
	}

	public void setActivarvalor_obtenidoEvaluacionesPeriodos(Boolean activarvalor_obtenidoEvaluacionesPeriodos) {
		this.activarvalor_obtenidoEvaluacionesPeriodos= activarvalor_obtenidoEvaluacionesPeriodos;
	}

	public Border setResaltarpromedioEvaluacionesPeriodos(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesPeriodosBeanSwingJInternalFrame evaluacionesperiodosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesperiodosBeanSwingJInternalFrame.jTtoolBarEvaluacionesPeriodos.setBorder(borderResaltar);
		
		this.resaltarpromedioEvaluacionesPeriodos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpromedioEvaluacionesPeriodos() {
		return this.resaltarpromedioEvaluacionesPeriodos;
	}

	public void setResaltarpromedioEvaluacionesPeriodos(Border borderResaltar) {
		this.resaltarpromedioEvaluacionesPeriodos= borderResaltar;
	}

	public Boolean getMostrarpromedioEvaluacionesPeriodos() {
		return this.mostrarpromedioEvaluacionesPeriodos;
	}

	public void setMostrarpromedioEvaluacionesPeriodos(Boolean mostrarpromedioEvaluacionesPeriodos) {
		this.mostrarpromedioEvaluacionesPeriodos= mostrarpromedioEvaluacionesPeriodos;
	}

	public Boolean getActivarpromedioEvaluacionesPeriodos() {
		return this.activarpromedioEvaluacionesPeriodos;
	}

	public void setActivarpromedioEvaluacionesPeriodos(Boolean activarpromedioEvaluacionesPeriodos) {
		this.activarpromedioEvaluacionesPeriodos= activarpromedioEvaluacionesPeriodos;
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
		
		
		this.setMostraridEvaluacionesPeriodos(esInicial);
		this.setMostrarid_tipo_calificacion_empleadoEvaluacionesPeriodos(esInicial);
		this.setMostrarverificadoEvaluacionesPeriodos(esInicial);
		this.setMostrarid_estructuraEvaluacionesPeriodos(esInicial);
		this.setMostrarcodigoEvaluacionesPeriodos(esInicial);
		this.setMostrarid_empresaEvaluacionesPeriodos(esInicial);
		this.setMostrarid_sucursalEvaluacionesPeriodos(esInicial);
		this.setMostrarid_ejercicioEvaluacionesPeriodos(esInicial);
		this.setMostrarid_tipo_evaluacion_empleadoEvaluacionesPeriodos(esInicial);
		this.setMostrarcodigo_datoEvaluacionesPeriodos(esInicial);
		this.setMostrarnombre_completoEvaluacionesPeriodos(esInicial);
		this.setMostrarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos(esInicial);
		this.setMostrarvalor_conocimientoEvaluacionesPeriodos(esInicial);
		this.setMostrarvalor_eficienciaEvaluacionesPeriodos(esInicial);
		this.setMostrarvalor_obtenidoEvaluacionesPeriodos(esInicial);
		this.setMostrarpromedioEvaluacionesPeriodos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.ID)) {
				this.setMostraridEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO)) {
				this.setMostrarid_tipo_calificacion_empleadoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.VERIFICADO)) {
				this.setMostrarverificadoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.IDTIPOEVALUACIONEMPLEADO)) {
				this.setMostrarid_tipo_evaluacion_empleadoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.CODIGODATO)) {
				this.setMostrarcodigo_datoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.IDFORMATONOMIPREGUNTANOMI)) {
				this.setMostrarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.VALORCONOCIMIENTO)) {
				this.setMostrarvalor_conocimientoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.VALOREFICIENCIA)) {
				this.setMostrarvalor_eficienciaEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.VALOROBTENIDO)) {
				this.setMostrarvalor_obtenidoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.PROMEDIO)) {
				this.setMostrarpromedioEvaluacionesPeriodos(esAsigna);
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
		
		
		this.setActivaridEvaluacionesPeriodos(esInicial);
		this.setActivarid_tipo_calificacion_empleadoEvaluacionesPeriodos(esInicial);
		this.setActivarverificadoEvaluacionesPeriodos(esInicial);
		this.setActivarid_estructuraEvaluacionesPeriodos(esInicial);
		this.setActivarcodigoEvaluacionesPeriodos(esInicial);
		this.setActivarid_empresaEvaluacionesPeriodos(esInicial);
		this.setActivarid_sucursalEvaluacionesPeriodos(esInicial);
		this.setActivarid_ejercicioEvaluacionesPeriodos(esInicial);
		this.setActivarid_tipo_evaluacion_empleadoEvaluacionesPeriodos(esInicial);
		this.setActivarcodigo_datoEvaluacionesPeriodos(esInicial);
		this.setActivarnombre_completoEvaluacionesPeriodos(esInicial);
		this.setActivarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos(esInicial);
		this.setActivarvalor_conocimientoEvaluacionesPeriodos(esInicial);
		this.setActivarvalor_eficienciaEvaluacionesPeriodos(esInicial);
		this.setActivarvalor_obtenidoEvaluacionesPeriodos(esInicial);
		this.setActivarpromedioEvaluacionesPeriodos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.ID)) {
				this.setActivaridEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO)) {
				this.setActivarid_tipo_calificacion_empleadoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.VERIFICADO)) {
				this.setActivarverificadoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.IDTIPOEVALUACIONEMPLEADO)) {
				this.setActivarid_tipo_evaluacion_empleadoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.CODIGODATO)) {
				this.setActivarcodigo_datoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.IDFORMATONOMIPREGUNTANOMI)) {
				this.setActivarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.VALORCONOCIMIENTO)) {
				this.setActivarvalor_conocimientoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.VALOREFICIENCIA)) {
				this.setActivarvalor_eficienciaEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.VALOROBTENIDO)) {
				this.setActivarvalor_obtenidoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.PROMEDIO)) {
				this.setActivarpromedioEvaluacionesPeriodos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EvaluacionesPeriodosBeanSwingJInternalFrame evaluacionesperiodosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEvaluacionesPeriodos(esInicial);
		this.setResaltarid_tipo_calificacion_empleadoEvaluacionesPeriodos(esInicial);
		this.setResaltarverificadoEvaluacionesPeriodos(esInicial);
		this.setResaltarid_estructuraEvaluacionesPeriodos(esInicial);
		this.setResaltarcodigoEvaluacionesPeriodos(esInicial);
		this.setResaltarid_empresaEvaluacionesPeriodos(esInicial);
		this.setResaltarid_sucursalEvaluacionesPeriodos(esInicial);
		this.setResaltarid_ejercicioEvaluacionesPeriodos(esInicial);
		this.setResaltarid_tipo_evaluacion_empleadoEvaluacionesPeriodos(esInicial);
		this.setResaltarcodigo_datoEvaluacionesPeriodos(esInicial);
		this.setResaltarnombre_completoEvaluacionesPeriodos(esInicial);
		this.setResaltarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos(esInicial);
		this.setResaltarvalor_conocimientoEvaluacionesPeriodos(esInicial);
		this.setResaltarvalor_eficienciaEvaluacionesPeriodos(esInicial);
		this.setResaltarvalor_obtenidoEvaluacionesPeriodos(esInicial);
		this.setResaltarpromedioEvaluacionesPeriodos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.ID)) {
				this.setResaltaridEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO)) {
				this.setResaltarid_tipo_calificacion_empleadoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.VERIFICADO)) {
				this.setResaltarverificadoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.IDTIPOEVALUACIONEMPLEADO)) {
				this.setResaltarid_tipo_evaluacion_empleadoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.CODIGODATO)) {
				this.setResaltarcodigo_datoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.IDFORMATONOMIPREGUNTANOMI)) {
				this.setResaltarid_formato_nomi_pregunta_nomiEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.VALORCONOCIMIENTO)) {
				this.setResaltarvalor_conocimientoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.VALOREFICIENCIA)) {
				this.setResaltarvalor_eficienciaEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.VALOROBTENIDO)) {
				this.setResaltarvalor_obtenidoEvaluacionesPeriodos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesPeriodosConstantesFunciones.PROMEDIO)) {
				this.setResaltarpromedioEvaluacionesPeriodos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EvaluacionesPeriodosBeanSwingJInternalFrame evaluacionesperiodosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaEvaluacionesPeriodosEvaluacionesPeriodos=true;

	public Boolean getMostrarBusquedaEvaluacionesPeriodosEvaluacionesPeriodos() {
		return this.mostrarBusquedaEvaluacionesPeriodosEvaluacionesPeriodos;
	}

	public void setMostrarBusquedaEvaluacionesPeriodosEvaluacionesPeriodos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaEvaluacionesPeriodosEvaluacionesPeriodos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaEvaluacionesPeriodosEvaluacionesPeriodos=true;

	public Boolean getActivarBusquedaEvaluacionesPeriodosEvaluacionesPeriodos() {
		return this.activarBusquedaEvaluacionesPeriodosEvaluacionesPeriodos;
	}

	public void setActivarBusquedaEvaluacionesPeriodosEvaluacionesPeriodos(Boolean habilitarResaltar) {
		this.activarBusquedaEvaluacionesPeriodosEvaluacionesPeriodos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaEvaluacionesPeriodosEvaluacionesPeriodos=null;

	public Border getResaltarBusquedaEvaluacionesPeriodosEvaluacionesPeriodos() {
		return this.resaltarBusquedaEvaluacionesPeriodosEvaluacionesPeriodos;
	}

	public void setResaltarBusquedaEvaluacionesPeriodosEvaluacionesPeriodos(Border borderResaltar) {
		this.resaltarBusquedaEvaluacionesPeriodosEvaluacionesPeriodos= borderResaltar;
	}

	public void setResaltarBusquedaEvaluacionesPeriodosEvaluacionesPeriodos(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesPeriodosBeanSwingJInternalFrame evaluacionesperiodosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaEvaluacionesPeriodosEvaluacionesPeriodos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}