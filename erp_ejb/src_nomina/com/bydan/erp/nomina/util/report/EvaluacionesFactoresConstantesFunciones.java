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


import com.bydan.erp.nomina.util.report.EvaluacionesFactoresConstantesFunciones;
import com.bydan.erp.nomina.util.report.EvaluacionesFactoresParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.EvaluacionesFactoresParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.business.entity.report.*;



import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EvaluacionesFactoresConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EvaluacionesFactores";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EvaluacionesFactores"+EvaluacionesFactoresConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EvaluacionesFactoresHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EvaluacionesFactoresHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EvaluacionesFactoresConstantesFunciones.SCHEMA+"_"+EvaluacionesFactoresConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EvaluacionesFactoresHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EvaluacionesFactoresConstantesFunciones.SCHEMA+"_"+EvaluacionesFactoresConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EvaluacionesFactoresConstantesFunciones.SCHEMA+"_"+EvaluacionesFactoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EvaluacionesFactoresHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EvaluacionesFactoresConstantesFunciones.SCHEMA+"_"+EvaluacionesFactoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionesFactoresConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EvaluacionesFactoresHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionesFactoresConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionesFactoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EvaluacionesFactoresHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionesFactoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EvaluacionesFactoresConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EvaluacionesFactoresConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EvaluacionesFactoresConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EvaluacionesFactoresConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Evaluaciones Factoreses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Evaluaciones Factores";
	public static final String SCLASSWEBTITULO_LOWER="Evaluaciones Factores";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EvaluacionesFactores";
	public static final String OBJECTNAME="evaluacionesfactores";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="evaluaciones_factores";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select evaluacionesfactores from "+EvaluacionesFactoresConstantesFunciones.SPERSISTENCENAME+" evaluacionesfactores";
	public static String QUERYSELECTNATIVE="select "+EvaluacionesFactoresConstantesFunciones.SCHEMA+"."+EvaluacionesFactoresConstantesFunciones.TABLENAME+".id,"+EvaluacionesFactoresConstantesFunciones.SCHEMA+"."+EvaluacionesFactoresConstantesFunciones.TABLENAME+".version_row,"+EvaluacionesFactoresConstantesFunciones.SCHEMA+"."+EvaluacionesFactoresConstantesFunciones.TABLENAME+".id_tipo_calificacion_empleado,"+EvaluacionesFactoresConstantesFunciones.SCHEMA+"."+EvaluacionesFactoresConstantesFunciones.TABLENAME+".verificado,"+EvaluacionesFactoresConstantesFunciones.SCHEMA+"."+EvaluacionesFactoresConstantesFunciones.TABLENAME+".id_estructura,"+EvaluacionesFactoresConstantesFunciones.SCHEMA+"."+EvaluacionesFactoresConstantesFunciones.TABLENAME+".codigo,"+EvaluacionesFactoresConstantesFunciones.SCHEMA+"."+EvaluacionesFactoresConstantesFunciones.TABLENAME+".id_empresa,"+EvaluacionesFactoresConstantesFunciones.SCHEMA+"."+EvaluacionesFactoresConstantesFunciones.TABLENAME+".id_sucursal,"+EvaluacionesFactoresConstantesFunciones.SCHEMA+"."+EvaluacionesFactoresConstantesFunciones.TABLENAME+".codigo_dato,"+EvaluacionesFactoresConstantesFunciones.SCHEMA+"."+EvaluacionesFactoresConstantesFunciones.TABLENAME+".nombre_completo,"+EvaluacionesFactoresConstantesFunciones.SCHEMA+"."+EvaluacionesFactoresConstantesFunciones.TABLENAME+".id_formato_nomi_pregunta_nomi,"+EvaluacionesFactoresConstantesFunciones.SCHEMA+"."+EvaluacionesFactoresConstantesFunciones.TABLENAME+".valor_conocimiento,"+EvaluacionesFactoresConstantesFunciones.SCHEMA+"."+EvaluacionesFactoresConstantesFunciones.TABLENAME+".valor_eficiencia,"+EvaluacionesFactoresConstantesFunciones.SCHEMA+"."+EvaluacionesFactoresConstantesFunciones.TABLENAME+".valor_obtenido,"+EvaluacionesFactoresConstantesFunciones.SCHEMA+"."+EvaluacionesFactoresConstantesFunciones.TABLENAME+".promedio from "+EvaluacionesFactoresConstantesFunciones.SCHEMA+"."+EvaluacionesFactoresConstantesFunciones.TABLENAME;//+" as "+EvaluacionesFactoresConstantesFunciones.TABLENAME;
	
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
		
		
		
		
		
	
	public static String getEvaluacionesFactoresLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EvaluacionesFactoresConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO)) {sLabelColumna=EvaluacionesFactoresConstantesFunciones.LABEL_IDTIPOCALIFICACIONEMPLEADO;}
		if(sNombreColumna.equals(EvaluacionesFactoresConstantesFunciones.VERIFICADO)) {sLabelColumna=EvaluacionesFactoresConstantesFunciones.LABEL_VERIFICADO;}
		if(sNombreColumna.equals(EvaluacionesFactoresConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=EvaluacionesFactoresConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(EvaluacionesFactoresConstantesFunciones.CODIGO)) {sLabelColumna=EvaluacionesFactoresConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EvaluacionesFactoresConstantesFunciones.IDEMPRESA)) {sLabelColumna=EvaluacionesFactoresConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EvaluacionesFactoresConstantesFunciones.IDSUCURSAL)) {sLabelColumna=EvaluacionesFactoresConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(EvaluacionesFactoresConstantesFunciones.CODIGODATO)) {sLabelColumna=EvaluacionesFactoresConstantesFunciones.LABEL_CODIGODATO;}
		if(sNombreColumna.equals(EvaluacionesFactoresConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=EvaluacionesFactoresConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(EvaluacionesFactoresConstantesFunciones.IDFORMATONOMIPREGUNTANOMI)) {sLabelColumna=EvaluacionesFactoresConstantesFunciones.LABEL_IDFORMATONOMIPREGUNTANOMI;}
		if(sNombreColumna.equals(EvaluacionesFactoresConstantesFunciones.VALORCONOCIMIENTO)) {sLabelColumna=EvaluacionesFactoresConstantesFunciones.LABEL_VALORCONOCIMIENTO;}
		if(sNombreColumna.equals(EvaluacionesFactoresConstantesFunciones.VALOREFICIENCIA)) {sLabelColumna=EvaluacionesFactoresConstantesFunciones.LABEL_VALOREFICIENCIA;}
		if(sNombreColumna.equals(EvaluacionesFactoresConstantesFunciones.VALOROBTENIDO)) {sLabelColumna=EvaluacionesFactoresConstantesFunciones.LABEL_VALOROBTENIDO;}
		if(sNombreColumna.equals(EvaluacionesFactoresConstantesFunciones.PROMEDIO)) {sLabelColumna=EvaluacionesFactoresConstantesFunciones.LABEL_PROMEDIO;}
		
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
	
	
	
			
			
			
		
	public static String getverificadoDescripcion(EvaluacionesFactores evaluacionesfactores) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!evaluacionesfactores.getverificado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getverificadoHtmlDescripcion(EvaluacionesFactores evaluacionesfactores) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(evaluacionesfactores.getId(),evaluacionesfactores.getverificado());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getEvaluacionesFactoresDescripcion(EvaluacionesFactores evaluacionesfactores) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(evaluacionesfactores !=null/* && evaluacionesfactores.getId()!=0*/) {
			sDescripcion=evaluacionesfactores.getcodigo();//evaluacionesfactoresevaluacionesfactores.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEvaluacionesFactoresDescripcionDetallado(EvaluacionesFactores evaluacionesfactores) {
		String sDescripcion="";
			
		sDescripcion+=EvaluacionesFactoresConstantesFunciones.ID+"=";
		sDescripcion+=evaluacionesfactores.getId().toString()+",";
		sDescripcion+=EvaluacionesFactoresConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=evaluacionesfactores.getVersionRow().toString()+",";
		sDescripcion+=EvaluacionesFactoresConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO+"=";
		sDescripcion+=evaluacionesfactores.getid_tipo_calificacion_empleado().toString()+",";
		sDescripcion+=EvaluacionesFactoresConstantesFunciones.VERIFICADO+"=";
		sDescripcion+=evaluacionesfactores.getverificado().toString()+",";
		sDescripcion+=EvaluacionesFactoresConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=evaluacionesfactores.getid_estructura().toString()+",";
		sDescripcion+=EvaluacionesFactoresConstantesFunciones.CODIGO+"=";
		sDescripcion+=evaluacionesfactores.getcodigo()+",";
		sDescripcion+=EvaluacionesFactoresConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=evaluacionesfactores.getid_empresa().toString()+",";
		sDescripcion+=EvaluacionesFactoresConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=evaluacionesfactores.getid_sucursal().toString()+",";
		sDescripcion+=EvaluacionesFactoresConstantesFunciones.CODIGODATO+"=";
		sDescripcion+=evaluacionesfactores.getcodigo_dato()+",";
		sDescripcion+=EvaluacionesFactoresConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=evaluacionesfactores.getnombre_completo()+",";
		sDescripcion+=EvaluacionesFactoresConstantesFunciones.IDFORMATONOMIPREGUNTANOMI+"=";
		sDescripcion+=evaluacionesfactores.getid_formato_nomi_pregunta_nomi().toString()+",";
		sDescripcion+=EvaluacionesFactoresConstantesFunciones.VALORCONOCIMIENTO+"=";
		sDescripcion+=evaluacionesfactores.getvalor_conocimiento().toString()+",";
		sDescripcion+=EvaluacionesFactoresConstantesFunciones.VALOREFICIENCIA+"=";
		sDescripcion+=evaluacionesfactores.getvalor_eficiencia().toString()+",";
		sDescripcion+=EvaluacionesFactoresConstantesFunciones.VALOROBTENIDO+"=";
		sDescripcion+=evaluacionesfactores.getvalor_obtenido().toString()+",";
		sDescripcion+=EvaluacionesFactoresConstantesFunciones.PROMEDIO+"=";
		sDescripcion+=evaluacionesfactores.getpromedio().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEvaluacionesFactoresDescripcion(EvaluacionesFactores evaluacionesfactores,String sValor) throws Exception {			
		if(evaluacionesfactores !=null) {
			evaluacionesfactores.setcodigo(sValor);;//evaluacionesfactoresevaluacionesfactores.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaEvaluacionesFactores")) {
			sNombreIndice="Tipo=  Por Tipo Calificacion Empleado Por Verificado Por Estructura Por Codigo";
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
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaEvaluacionesFactores(Long id_tipo_calificacion_empleado,Boolean verificado,Long id_estructura,String codigo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_calificacion_empleado!=null) {sDetalleIndice+=" Codigo Unico De Tipo Calificacion Empleado="+id_tipo_calificacion_empleado.toString();}
		if(verificado!=null) {sDetalleIndice+=" Verificado="+verificado.toString();}
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();}
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

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
	
	
	
	
	
	
	public static void quitarEspaciosEvaluacionesFactores(EvaluacionesFactores evaluacionesfactores,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		evaluacionesfactores.setcodigo_dato(evaluacionesfactores.getcodigo_dato().trim());
		evaluacionesfactores.setnombre_completo(evaluacionesfactores.getnombre_completo().trim());
	}
	
	public static void quitarEspaciosEvaluacionesFactoress(List<EvaluacionesFactores> evaluacionesfactoress,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EvaluacionesFactores evaluacionesfactores: evaluacionesfactoress) {
			evaluacionesfactores.setcodigo_dato(evaluacionesfactores.getcodigo_dato().trim());
			evaluacionesfactores.setnombre_completo(evaluacionesfactores.getnombre_completo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEvaluacionesFactores(EvaluacionesFactores evaluacionesfactores,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && evaluacionesfactores.getConCambioAuxiliar()) {
			evaluacionesfactores.setIsDeleted(evaluacionesfactores.getIsDeletedAuxiliar());	
			evaluacionesfactores.setIsNew(evaluacionesfactores.getIsNewAuxiliar());	
			evaluacionesfactores.setIsChanged(evaluacionesfactores.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			evaluacionesfactores.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			evaluacionesfactores.setIsDeletedAuxiliar(false);	
			evaluacionesfactores.setIsNewAuxiliar(false);	
			evaluacionesfactores.setIsChangedAuxiliar(false);
			
			evaluacionesfactores.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEvaluacionesFactoress(List<EvaluacionesFactores> evaluacionesfactoress,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EvaluacionesFactores evaluacionesfactores : evaluacionesfactoress) {
			if(conAsignarBase && evaluacionesfactores.getConCambioAuxiliar()) {
				evaluacionesfactores.setIsDeleted(evaluacionesfactores.getIsDeletedAuxiliar());	
				evaluacionesfactores.setIsNew(evaluacionesfactores.getIsNewAuxiliar());	
				evaluacionesfactores.setIsChanged(evaluacionesfactores.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				evaluacionesfactores.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				evaluacionesfactores.setIsDeletedAuxiliar(false);	
				evaluacionesfactores.setIsNewAuxiliar(false);	
				evaluacionesfactores.setIsChangedAuxiliar(false);
				
				evaluacionesfactores.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEvaluacionesFactores(EvaluacionesFactores evaluacionesfactores,Boolean conEnteros) throws Exception  {
		evaluacionesfactores.setvalor_conocimiento(0.0);
		evaluacionesfactores.setvalor_eficiencia(0.0);
		evaluacionesfactores.setvalor_obtenido(0.0);
		evaluacionesfactores.setpromedio(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEvaluacionesFactoress(List<EvaluacionesFactores> evaluacionesfactoress,Boolean conEnteros) throws Exception  {
		
		for(EvaluacionesFactores evaluacionesfactores: evaluacionesfactoress) {
			evaluacionesfactores.setvalor_conocimiento(0.0);
			evaluacionesfactores.setvalor_eficiencia(0.0);
			evaluacionesfactores.setvalor_obtenido(0.0);
			evaluacionesfactores.setpromedio(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEvaluacionesFactores(List<EvaluacionesFactores> evaluacionesfactoress,EvaluacionesFactores evaluacionesfactoresAux) throws Exception  {
		EvaluacionesFactoresConstantesFunciones.InicializarValoresEvaluacionesFactores(evaluacionesfactoresAux,true);
		
		for(EvaluacionesFactores evaluacionesfactores: evaluacionesfactoress) {
			if(evaluacionesfactores.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			evaluacionesfactoresAux.setvalor_conocimiento(evaluacionesfactoresAux.getvalor_conocimiento()+evaluacionesfactores.getvalor_conocimiento());			
			evaluacionesfactoresAux.setvalor_eficiencia(evaluacionesfactoresAux.getvalor_eficiencia()+evaluacionesfactores.getvalor_eficiencia());			
			evaluacionesfactoresAux.setvalor_obtenido(evaluacionesfactoresAux.getvalor_obtenido()+evaluacionesfactores.getvalor_obtenido());			
			evaluacionesfactoresAux.setpromedio(evaluacionesfactoresAux.getpromedio()+evaluacionesfactores.getpromedio());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEvaluacionesFactores(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EvaluacionesFactoresConstantesFunciones.getArrayColumnasGlobalesEvaluacionesFactores(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEvaluacionesFactores(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EvaluacionesFactoresConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EvaluacionesFactoresConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EvaluacionesFactoresConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EvaluacionesFactoresConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEvaluacionesFactores(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EvaluacionesFactores> evaluacionesfactoress,EvaluacionesFactores evaluacionesfactores,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EvaluacionesFactores evaluacionesfactoresAux: evaluacionesfactoress) {
			if(evaluacionesfactoresAux!=null && evaluacionesfactores!=null) {
				if((evaluacionesfactoresAux.getId()==null && evaluacionesfactores.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(evaluacionesfactoresAux.getId()!=null && evaluacionesfactores.getId()!=null){
					if(evaluacionesfactoresAux.getId().equals(evaluacionesfactores.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEvaluacionesFactores(List<EvaluacionesFactores> evaluacionesfactoress) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_conocimientoTotal=0.0;
		Double valor_eficienciaTotal=0.0;
		Double valor_obtenidoTotal=0.0;
		Double promedioTotal=0.0;
	
		for(EvaluacionesFactores evaluacionesfactores: evaluacionesfactoress) {			
			if(evaluacionesfactores.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_conocimientoTotal+=evaluacionesfactores.getvalor_conocimiento();
			valor_eficienciaTotal+=evaluacionesfactores.getvalor_eficiencia();
			valor_obtenidoTotal+=evaluacionesfactores.getvalor_obtenido();
			promedioTotal+=evaluacionesfactores.getpromedio();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EvaluacionesFactoresConstantesFunciones.VALORCONOCIMIENTO);
		datoGeneral.setsDescripcion(EvaluacionesFactoresConstantesFunciones.LABEL_VALORCONOCIMIENTO);
		datoGeneral.setdValorDouble(valor_conocimientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EvaluacionesFactoresConstantesFunciones.VALOREFICIENCIA);
		datoGeneral.setsDescripcion(EvaluacionesFactoresConstantesFunciones.LABEL_VALOREFICIENCIA);
		datoGeneral.setdValorDouble(valor_eficienciaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EvaluacionesFactoresConstantesFunciones.VALOROBTENIDO);
		datoGeneral.setsDescripcion(EvaluacionesFactoresConstantesFunciones.LABEL_VALOROBTENIDO);
		datoGeneral.setdValorDouble(valor_obtenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EvaluacionesFactoresConstantesFunciones.PROMEDIO);
		datoGeneral.setsDescripcion(EvaluacionesFactoresConstantesFunciones.LABEL_PROMEDIO);
		datoGeneral.setdValorDouble(promedioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEvaluacionesFactores() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EvaluacionesFactoresConstantesFunciones.LABEL_ID, EvaluacionesFactoresConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesFactoresConstantesFunciones.LABEL_VERSIONROW, EvaluacionesFactoresConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesFactoresConstantesFunciones.LABEL_CODIGODATO, EvaluacionesFactoresConstantesFunciones.CODIGODATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesFactoresConstantesFunciones.LABEL_NOMBRECOMPLETO, EvaluacionesFactoresConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesFactoresConstantesFunciones.LABEL_IDFORMATONOMIPREGUNTANOMI, EvaluacionesFactoresConstantesFunciones.IDFORMATONOMIPREGUNTANOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesFactoresConstantesFunciones.LABEL_VALORCONOCIMIENTO, EvaluacionesFactoresConstantesFunciones.VALORCONOCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesFactoresConstantesFunciones.LABEL_VALOREFICIENCIA, EvaluacionesFactoresConstantesFunciones.VALOREFICIENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesFactoresConstantesFunciones.LABEL_VALOROBTENIDO, EvaluacionesFactoresConstantesFunciones.VALOROBTENIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesFactoresConstantesFunciones.LABEL_PROMEDIO, EvaluacionesFactoresConstantesFunciones.PROMEDIO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEvaluacionesFactores() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesFactoresConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesFactoresConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesFactoresConstantesFunciones.CODIGODATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesFactoresConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesFactoresConstantesFunciones.IDFORMATONOMIPREGUNTANOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesFactoresConstantesFunciones.VALORCONOCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesFactoresConstantesFunciones.VALOREFICIENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesFactoresConstantesFunciones.VALOROBTENIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesFactoresConstantesFunciones.PROMEDIO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEvaluacionesFactores() throws Exception  {
		return EvaluacionesFactoresConstantesFunciones.getTiposSeleccionarEvaluacionesFactores(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEvaluacionesFactores(Boolean conFk) throws Exception  {
		return EvaluacionesFactoresConstantesFunciones.getTiposSeleccionarEvaluacionesFactores(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEvaluacionesFactores(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesFactoresConstantesFunciones.LABEL_IDTIPOCALIFICACIONEMPLEADO);
			reporte.setsDescripcion(EvaluacionesFactoresConstantesFunciones.LABEL_IDTIPOCALIFICACIONEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesFactoresConstantesFunciones.LABEL_VERIFICADO);
			reporte.setsDescripcion(EvaluacionesFactoresConstantesFunciones.LABEL_VERIFICADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesFactoresConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(EvaluacionesFactoresConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesFactoresConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EvaluacionesFactoresConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesFactoresConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EvaluacionesFactoresConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesFactoresConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(EvaluacionesFactoresConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesFactoresConstantesFunciones.LABEL_CODIGODATO);
			reporte.setsDescripcion(EvaluacionesFactoresConstantesFunciones.LABEL_CODIGODATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesFactoresConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(EvaluacionesFactoresConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesFactoresConstantesFunciones.LABEL_IDFORMATONOMIPREGUNTANOMI);
			reporte.setsDescripcion(EvaluacionesFactoresConstantesFunciones.LABEL_IDFORMATONOMIPREGUNTANOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesFactoresConstantesFunciones.LABEL_VALORCONOCIMIENTO);
			reporte.setsDescripcion(EvaluacionesFactoresConstantesFunciones.LABEL_VALORCONOCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesFactoresConstantesFunciones.LABEL_VALOREFICIENCIA);
			reporte.setsDescripcion(EvaluacionesFactoresConstantesFunciones.LABEL_VALOREFICIENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesFactoresConstantesFunciones.LABEL_VALOROBTENIDO);
			reporte.setsDescripcion(EvaluacionesFactoresConstantesFunciones.LABEL_VALOROBTENIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesFactoresConstantesFunciones.LABEL_PROMEDIO);
			reporte.setsDescripcion(EvaluacionesFactoresConstantesFunciones.LABEL_PROMEDIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEvaluacionesFactores(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEvaluacionesFactores(EvaluacionesFactores evaluacionesfactoresAux) throws Exception {
		
			evaluacionesfactoresAux.settipocalificacionempleado_descripcion(TipoCalificacionEmpleadoConstantesFunciones.getTipoCalificacionEmpleadoDescripcion(evaluacionesfactoresAux.getTipoCalificacionEmpleado()));
			evaluacionesfactoresAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(evaluacionesfactoresAux.getEstructura()));
			evaluacionesfactoresAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(evaluacionesfactoresAux.getEmpresa()));
			evaluacionesfactoresAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(evaluacionesfactoresAux.getSucursal()));
			evaluacionesfactoresAux.setformatonomipreguntanomi_descripcion(FormatoNomiPreguntaNomiConstantesFunciones.getFormatoNomiPreguntaNomiDescripcion(evaluacionesfactoresAux.getFormatoNomiPreguntaNomi()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEvaluacionesFactores(List<EvaluacionesFactores> evaluacionesfactoressTemp) throws Exception {
		for(EvaluacionesFactores evaluacionesfactoresAux:evaluacionesfactoressTemp) {
			
			evaluacionesfactoresAux.settipocalificacionempleado_descripcion(TipoCalificacionEmpleadoConstantesFunciones.getTipoCalificacionEmpleadoDescripcion(evaluacionesfactoresAux.getTipoCalificacionEmpleado()));
			evaluacionesfactoresAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(evaluacionesfactoresAux.getEstructura()));
			evaluacionesfactoresAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(evaluacionesfactoresAux.getEmpresa()));
			evaluacionesfactoresAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(evaluacionesfactoresAux.getSucursal()));
			evaluacionesfactoresAux.setformatonomipreguntanomi_descripcion(FormatoNomiPreguntaNomiConstantesFunciones.getFormatoNomiPreguntaNomiDescripcion(evaluacionesfactoresAux.getFormatoNomiPreguntaNomi()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEvaluacionesFactores(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TipoCalificacionEmpleado.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEvaluacionesFactores(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEvaluacionesFactores(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EvaluacionesFactoresConstantesFunciones.getClassesRelationshipsOfEvaluacionesFactores(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEvaluacionesFactores(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEvaluacionesFactores(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EvaluacionesFactoresConstantesFunciones.getClassesRelationshipsFromStringsOfEvaluacionesFactores(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEvaluacionesFactores(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(EvaluacionesFactores evaluacionesfactores,List<EvaluacionesFactores> evaluacionesfactoress,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(EvaluacionesFactores evaluacionesfactores,List<EvaluacionesFactores> evaluacionesfactoress) throws Exception {
		try	{			
			for(EvaluacionesFactores evaluacionesfactoresLocal:evaluacionesfactoress) {
				if(evaluacionesfactoresLocal.getId().equals(evaluacionesfactores.getId())) {
					evaluacionesfactoresLocal.setIsSelected(evaluacionesfactores.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEvaluacionesFactores(List<EvaluacionesFactores> evaluacionesfactoressAux) throws Exception {
		//this.evaluacionesfactoressAux=evaluacionesfactoressAux;
		
		for(EvaluacionesFactores evaluacionesfactoresAux:evaluacionesfactoressAux) {
			if(evaluacionesfactoresAux.getIsChanged()) {
				evaluacionesfactoresAux.setIsChanged(false);
			}		
			
			if(evaluacionesfactoresAux.getIsNew()) {
				evaluacionesfactoresAux.setIsNew(false);
			}	
			
			if(evaluacionesfactoresAux.getIsDeleted()) {
				evaluacionesfactoresAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEvaluacionesFactores(EvaluacionesFactores evaluacionesfactoresAux) throws Exception {
		//this.evaluacionesfactoresAux=evaluacionesfactoresAux;
		
			if(evaluacionesfactoresAux.getIsChanged()) {
				evaluacionesfactoresAux.setIsChanged(false);
			}		
			
			if(evaluacionesfactoresAux.getIsNew()) {
				evaluacionesfactoresAux.setIsNew(false);
			}	
			
			if(evaluacionesfactoresAux.getIsDeleted()) {
				evaluacionesfactoresAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EvaluacionesFactores evaluacionesfactoresAsignar,EvaluacionesFactores evaluacionesfactores) throws Exception {
		evaluacionesfactoresAsignar.setId(evaluacionesfactores.getId());	
		evaluacionesfactoresAsignar.setVersionRow(evaluacionesfactores.getVersionRow());	
		evaluacionesfactoresAsignar.setcodigo_dato(evaluacionesfactores.getcodigo_dato());	
		evaluacionesfactoresAsignar.setnombre_completo(evaluacionesfactores.getnombre_completo());	
		evaluacionesfactoresAsignar.setid_formato_nomi_pregunta_nomi(evaluacionesfactores.getid_formato_nomi_pregunta_nomi());
		evaluacionesfactoresAsignar.setformatonomipreguntanomi_descripcion(evaluacionesfactores.getformatonomipreguntanomi_descripcion());	
		evaluacionesfactoresAsignar.setvalor_conocimiento(evaluacionesfactores.getvalor_conocimiento());	
		evaluacionesfactoresAsignar.setvalor_eficiencia(evaluacionesfactores.getvalor_eficiencia());	
		evaluacionesfactoresAsignar.setvalor_obtenido(evaluacionesfactores.getvalor_obtenido());	
		evaluacionesfactoresAsignar.setpromedio(evaluacionesfactores.getpromedio());	
	}
	
	public static void inicializarEvaluacionesFactores(EvaluacionesFactores evaluacionesfactores) throws Exception {
		try {
				evaluacionesfactores.setId(0L);	
					
				evaluacionesfactores.setcodigo_dato("");	
				evaluacionesfactores.setnombre_completo("");	
				evaluacionesfactores.setid_formato_nomi_pregunta_nomi(-1L);	
				evaluacionesfactores.setvalor_conocimiento(0.0);	
				evaluacionesfactores.setvalor_eficiencia(0.0);	
				evaluacionesfactores.setvalor_obtenido(0.0);	
				evaluacionesfactores.setpromedio(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEvaluacionesFactores(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesFactoresConstantesFunciones.LABEL_IDTIPOCALIFICACIONEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesFactoresConstantesFunciones.LABEL_VERIFICADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesFactoresConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesFactoresConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesFactoresConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesFactoresConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesFactoresConstantesFunciones.LABEL_CODIGODATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesFactoresConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesFactoresConstantesFunciones.LABEL_IDFORMATONOMIPREGUNTANOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesFactoresConstantesFunciones.LABEL_VALORCONOCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesFactoresConstantesFunciones.LABEL_VALOREFICIENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesFactoresConstantesFunciones.LABEL_VALOROBTENIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesFactoresConstantesFunciones.LABEL_PROMEDIO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEvaluacionesFactores(String sTipo,Row row,Workbook workbook,EvaluacionesFactores evaluacionesfactores,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesfactores.gettipocalificacionempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(evaluacionesfactores.getverificado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesfactores.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesfactores.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesfactores.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesfactores.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesfactores.getcodigo_dato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesfactores.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesfactores.getformatonomipreguntanomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesfactores.getvalor_conocimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesfactores.getvalor_eficiencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesfactores.getvalor_obtenido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesfactores.getpromedio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEvaluacionesFactores="";
	
	public String getsFinalQueryEvaluacionesFactores() {
		return this.sFinalQueryEvaluacionesFactores;
	}
	
	public void setsFinalQueryEvaluacionesFactores(String sFinalQueryEvaluacionesFactores) {
		this.sFinalQueryEvaluacionesFactores= sFinalQueryEvaluacionesFactores;
	}
	
	public Border resaltarSeleccionarEvaluacionesFactores=null;
	
	public Border setResaltarSeleccionarEvaluacionesFactores(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesFactoresBeanSwingJInternalFrame evaluacionesfactoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//evaluacionesfactoresBeanSwingJInternalFrame.jTtoolBarEvaluacionesFactores.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEvaluacionesFactores= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEvaluacionesFactores() {
		return this.resaltarSeleccionarEvaluacionesFactores;
	}
	
	public void setResaltarSeleccionarEvaluacionesFactores(Border borderResaltarSeleccionarEvaluacionesFactores) {
		this.resaltarSeleccionarEvaluacionesFactores= borderResaltarSeleccionarEvaluacionesFactores;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEvaluacionesFactores=null;
	public Boolean mostraridEvaluacionesFactores=true;
	public Boolean activaridEvaluacionesFactores=true;

	public Border resaltarid_tipo_calificacion_empleadoEvaluacionesFactores=null;
	public Boolean mostrarid_tipo_calificacion_empleadoEvaluacionesFactores=true;
	public Boolean activarid_tipo_calificacion_empleadoEvaluacionesFactores=true;
	public Boolean cargarid_tipo_calificacion_empleadoEvaluacionesFactores=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_calificacion_empleadoEvaluacionesFactores=false;//ConEventDepend=true

	public Border resaltarverificadoEvaluacionesFactores=null;
	public Boolean mostrarverificadoEvaluacionesFactores=true;
	public Boolean activarverificadoEvaluacionesFactores=true;

	public Border resaltarid_estructuraEvaluacionesFactores=null;
	public Boolean mostrarid_estructuraEvaluacionesFactores=true;
	public Boolean activarid_estructuraEvaluacionesFactores=true;
	public Boolean cargarid_estructuraEvaluacionesFactores=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraEvaluacionesFactores=false;//ConEventDepend=true

	public Border resaltarcodigoEvaluacionesFactores=null;
	public Boolean mostrarcodigoEvaluacionesFactores=true;
	public Boolean activarcodigoEvaluacionesFactores=true;

	public Border resaltarid_empresaEvaluacionesFactores=null;
	public Boolean mostrarid_empresaEvaluacionesFactores=true;
	public Boolean activarid_empresaEvaluacionesFactores=true;
	public Boolean cargarid_empresaEvaluacionesFactores=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEvaluacionesFactores=false;//ConEventDepend=true

	public Border resaltarid_sucursalEvaluacionesFactores=null;
	public Boolean mostrarid_sucursalEvaluacionesFactores=true;
	public Boolean activarid_sucursalEvaluacionesFactores=true;
	public Boolean cargarid_sucursalEvaluacionesFactores=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalEvaluacionesFactores=false;//ConEventDepend=true

	public Border resaltarcodigo_datoEvaluacionesFactores=null;
	public Boolean mostrarcodigo_datoEvaluacionesFactores=true;
	public Boolean activarcodigo_datoEvaluacionesFactores=true;

	public Border resaltarnombre_completoEvaluacionesFactores=null;
	public Boolean mostrarnombre_completoEvaluacionesFactores=true;
	public Boolean activarnombre_completoEvaluacionesFactores=true;

	public Border resaltarid_formato_nomi_pregunta_nomiEvaluacionesFactores=null;
	public Boolean mostrarid_formato_nomi_pregunta_nomiEvaluacionesFactores=true;
	public Boolean activarid_formato_nomi_pregunta_nomiEvaluacionesFactores=true;
	public Boolean cargarid_formato_nomi_pregunta_nomiEvaluacionesFactores=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_nomi_pregunta_nomiEvaluacionesFactores=false;//ConEventDepend=true

	public Border resaltarvalor_conocimientoEvaluacionesFactores=null;
	public Boolean mostrarvalor_conocimientoEvaluacionesFactores=true;
	public Boolean activarvalor_conocimientoEvaluacionesFactores=true;

	public Border resaltarvalor_eficienciaEvaluacionesFactores=null;
	public Boolean mostrarvalor_eficienciaEvaluacionesFactores=true;
	public Boolean activarvalor_eficienciaEvaluacionesFactores=true;

	public Border resaltarvalor_obtenidoEvaluacionesFactores=null;
	public Boolean mostrarvalor_obtenidoEvaluacionesFactores=true;
	public Boolean activarvalor_obtenidoEvaluacionesFactores=true;

	public Border resaltarpromedioEvaluacionesFactores=null;
	public Boolean mostrarpromedioEvaluacionesFactores=true;
	public Boolean activarpromedioEvaluacionesFactores=true;

	
	

	public Border setResaltaridEvaluacionesFactores(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesFactoresBeanSwingJInternalFrame evaluacionesfactoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesfactoresBeanSwingJInternalFrame.jTtoolBarEvaluacionesFactores.setBorder(borderResaltar);
		
		this.resaltaridEvaluacionesFactores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEvaluacionesFactores() {
		return this.resaltaridEvaluacionesFactores;
	}

	public void setResaltaridEvaluacionesFactores(Border borderResaltar) {
		this.resaltaridEvaluacionesFactores= borderResaltar;
	}

	public Boolean getMostraridEvaluacionesFactores() {
		return this.mostraridEvaluacionesFactores;
	}

	public void setMostraridEvaluacionesFactores(Boolean mostraridEvaluacionesFactores) {
		this.mostraridEvaluacionesFactores= mostraridEvaluacionesFactores;
	}

	public Boolean getActivaridEvaluacionesFactores() {
		return this.activaridEvaluacionesFactores;
	}

	public void setActivaridEvaluacionesFactores(Boolean activaridEvaluacionesFactores) {
		this.activaridEvaluacionesFactores= activaridEvaluacionesFactores;
	}

	public Border setResaltarid_tipo_calificacion_empleadoEvaluacionesFactores(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesFactoresBeanSwingJInternalFrame evaluacionesfactoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesfactoresBeanSwingJInternalFrame.jTtoolBarEvaluacionesFactores.setBorder(borderResaltar);
		
		this.resaltarid_tipo_calificacion_empleadoEvaluacionesFactores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_calificacion_empleadoEvaluacionesFactores() {
		return this.resaltarid_tipo_calificacion_empleadoEvaluacionesFactores;
	}

	public void setResaltarid_tipo_calificacion_empleadoEvaluacionesFactores(Border borderResaltar) {
		this.resaltarid_tipo_calificacion_empleadoEvaluacionesFactores= borderResaltar;
	}

	public Boolean getMostrarid_tipo_calificacion_empleadoEvaluacionesFactores() {
		return this.mostrarid_tipo_calificacion_empleadoEvaluacionesFactores;
	}

	public void setMostrarid_tipo_calificacion_empleadoEvaluacionesFactores(Boolean mostrarid_tipo_calificacion_empleadoEvaluacionesFactores) {
		this.mostrarid_tipo_calificacion_empleadoEvaluacionesFactores= mostrarid_tipo_calificacion_empleadoEvaluacionesFactores;
	}

	public Boolean getActivarid_tipo_calificacion_empleadoEvaluacionesFactores() {
		return this.activarid_tipo_calificacion_empleadoEvaluacionesFactores;
	}

	public void setActivarid_tipo_calificacion_empleadoEvaluacionesFactores(Boolean activarid_tipo_calificacion_empleadoEvaluacionesFactores) {
		this.activarid_tipo_calificacion_empleadoEvaluacionesFactores= activarid_tipo_calificacion_empleadoEvaluacionesFactores;
	}

	public Boolean getCargarid_tipo_calificacion_empleadoEvaluacionesFactores() {
		return this.cargarid_tipo_calificacion_empleadoEvaluacionesFactores;
	}

	public void setCargarid_tipo_calificacion_empleadoEvaluacionesFactores(Boolean cargarid_tipo_calificacion_empleadoEvaluacionesFactores) {
		this.cargarid_tipo_calificacion_empleadoEvaluacionesFactores= cargarid_tipo_calificacion_empleadoEvaluacionesFactores;
	}

	public Border setResaltarverificadoEvaluacionesFactores(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesFactoresBeanSwingJInternalFrame evaluacionesfactoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesfactoresBeanSwingJInternalFrame.jTtoolBarEvaluacionesFactores.setBorder(borderResaltar);
		
		this.resaltarverificadoEvaluacionesFactores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarverificadoEvaluacionesFactores() {
		return this.resaltarverificadoEvaluacionesFactores;
	}

	public void setResaltarverificadoEvaluacionesFactores(Border borderResaltar) {
		this.resaltarverificadoEvaluacionesFactores= borderResaltar;
	}

	public Boolean getMostrarverificadoEvaluacionesFactores() {
		return this.mostrarverificadoEvaluacionesFactores;
	}

	public void setMostrarverificadoEvaluacionesFactores(Boolean mostrarverificadoEvaluacionesFactores) {
		this.mostrarverificadoEvaluacionesFactores= mostrarverificadoEvaluacionesFactores;
	}

	public Boolean getActivarverificadoEvaluacionesFactores() {
		return this.activarverificadoEvaluacionesFactores;
	}

	public void setActivarverificadoEvaluacionesFactores(Boolean activarverificadoEvaluacionesFactores) {
		this.activarverificadoEvaluacionesFactores= activarverificadoEvaluacionesFactores;
	}

	public Border setResaltarid_estructuraEvaluacionesFactores(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesFactoresBeanSwingJInternalFrame evaluacionesfactoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesfactoresBeanSwingJInternalFrame.jTtoolBarEvaluacionesFactores.setBorder(borderResaltar);
		
		this.resaltarid_estructuraEvaluacionesFactores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraEvaluacionesFactores() {
		return this.resaltarid_estructuraEvaluacionesFactores;
	}

	public void setResaltarid_estructuraEvaluacionesFactores(Border borderResaltar) {
		this.resaltarid_estructuraEvaluacionesFactores= borderResaltar;
	}

	public Boolean getMostrarid_estructuraEvaluacionesFactores() {
		return this.mostrarid_estructuraEvaluacionesFactores;
	}

	public void setMostrarid_estructuraEvaluacionesFactores(Boolean mostrarid_estructuraEvaluacionesFactores) {
		this.mostrarid_estructuraEvaluacionesFactores= mostrarid_estructuraEvaluacionesFactores;
	}

	public Boolean getActivarid_estructuraEvaluacionesFactores() {
		return this.activarid_estructuraEvaluacionesFactores;
	}

	public void setActivarid_estructuraEvaluacionesFactores(Boolean activarid_estructuraEvaluacionesFactores) {
		this.activarid_estructuraEvaluacionesFactores= activarid_estructuraEvaluacionesFactores;
	}

	public Boolean getCargarid_estructuraEvaluacionesFactores() {
		return this.cargarid_estructuraEvaluacionesFactores;
	}

	public void setCargarid_estructuraEvaluacionesFactores(Boolean cargarid_estructuraEvaluacionesFactores) {
		this.cargarid_estructuraEvaluacionesFactores= cargarid_estructuraEvaluacionesFactores;
	}

	public Border setResaltarcodigoEvaluacionesFactores(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesFactoresBeanSwingJInternalFrame evaluacionesfactoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesfactoresBeanSwingJInternalFrame.jTtoolBarEvaluacionesFactores.setBorder(borderResaltar);
		
		this.resaltarcodigoEvaluacionesFactores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEvaluacionesFactores() {
		return this.resaltarcodigoEvaluacionesFactores;
	}

	public void setResaltarcodigoEvaluacionesFactores(Border borderResaltar) {
		this.resaltarcodigoEvaluacionesFactores= borderResaltar;
	}

	public Boolean getMostrarcodigoEvaluacionesFactores() {
		return this.mostrarcodigoEvaluacionesFactores;
	}

	public void setMostrarcodigoEvaluacionesFactores(Boolean mostrarcodigoEvaluacionesFactores) {
		this.mostrarcodigoEvaluacionesFactores= mostrarcodigoEvaluacionesFactores;
	}

	public Boolean getActivarcodigoEvaluacionesFactores() {
		return this.activarcodigoEvaluacionesFactores;
	}

	public void setActivarcodigoEvaluacionesFactores(Boolean activarcodigoEvaluacionesFactores) {
		this.activarcodigoEvaluacionesFactores= activarcodigoEvaluacionesFactores;
	}

	public Border setResaltarid_empresaEvaluacionesFactores(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesFactoresBeanSwingJInternalFrame evaluacionesfactoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesfactoresBeanSwingJInternalFrame.jTtoolBarEvaluacionesFactores.setBorder(borderResaltar);
		
		this.resaltarid_empresaEvaluacionesFactores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEvaluacionesFactores() {
		return this.resaltarid_empresaEvaluacionesFactores;
	}

	public void setResaltarid_empresaEvaluacionesFactores(Border borderResaltar) {
		this.resaltarid_empresaEvaluacionesFactores= borderResaltar;
	}

	public Boolean getMostrarid_empresaEvaluacionesFactores() {
		return this.mostrarid_empresaEvaluacionesFactores;
	}

	public void setMostrarid_empresaEvaluacionesFactores(Boolean mostrarid_empresaEvaluacionesFactores) {
		this.mostrarid_empresaEvaluacionesFactores= mostrarid_empresaEvaluacionesFactores;
	}

	public Boolean getActivarid_empresaEvaluacionesFactores() {
		return this.activarid_empresaEvaluacionesFactores;
	}

	public void setActivarid_empresaEvaluacionesFactores(Boolean activarid_empresaEvaluacionesFactores) {
		this.activarid_empresaEvaluacionesFactores= activarid_empresaEvaluacionesFactores;
	}

	public Boolean getCargarid_empresaEvaluacionesFactores() {
		return this.cargarid_empresaEvaluacionesFactores;
	}

	public void setCargarid_empresaEvaluacionesFactores(Boolean cargarid_empresaEvaluacionesFactores) {
		this.cargarid_empresaEvaluacionesFactores= cargarid_empresaEvaluacionesFactores;
	}

	public Border setResaltarid_sucursalEvaluacionesFactores(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesFactoresBeanSwingJInternalFrame evaluacionesfactoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesfactoresBeanSwingJInternalFrame.jTtoolBarEvaluacionesFactores.setBorder(borderResaltar);
		
		this.resaltarid_sucursalEvaluacionesFactores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalEvaluacionesFactores() {
		return this.resaltarid_sucursalEvaluacionesFactores;
	}

	public void setResaltarid_sucursalEvaluacionesFactores(Border borderResaltar) {
		this.resaltarid_sucursalEvaluacionesFactores= borderResaltar;
	}

	public Boolean getMostrarid_sucursalEvaluacionesFactores() {
		return this.mostrarid_sucursalEvaluacionesFactores;
	}

	public void setMostrarid_sucursalEvaluacionesFactores(Boolean mostrarid_sucursalEvaluacionesFactores) {
		this.mostrarid_sucursalEvaluacionesFactores= mostrarid_sucursalEvaluacionesFactores;
	}

	public Boolean getActivarid_sucursalEvaluacionesFactores() {
		return this.activarid_sucursalEvaluacionesFactores;
	}

	public void setActivarid_sucursalEvaluacionesFactores(Boolean activarid_sucursalEvaluacionesFactores) {
		this.activarid_sucursalEvaluacionesFactores= activarid_sucursalEvaluacionesFactores;
	}

	public Boolean getCargarid_sucursalEvaluacionesFactores() {
		return this.cargarid_sucursalEvaluacionesFactores;
	}

	public void setCargarid_sucursalEvaluacionesFactores(Boolean cargarid_sucursalEvaluacionesFactores) {
		this.cargarid_sucursalEvaluacionesFactores= cargarid_sucursalEvaluacionesFactores;
	}

	public Border setResaltarcodigo_datoEvaluacionesFactores(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesFactoresBeanSwingJInternalFrame evaluacionesfactoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesfactoresBeanSwingJInternalFrame.jTtoolBarEvaluacionesFactores.setBorder(borderResaltar);
		
		this.resaltarcodigo_datoEvaluacionesFactores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_datoEvaluacionesFactores() {
		return this.resaltarcodigo_datoEvaluacionesFactores;
	}

	public void setResaltarcodigo_datoEvaluacionesFactores(Border borderResaltar) {
		this.resaltarcodigo_datoEvaluacionesFactores= borderResaltar;
	}

	public Boolean getMostrarcodigo_datoEvaluacionesFactores() {
		return this.mostrarcodigo_datoEvaluacionesFactores;
	}

	public void setMostrarcodigo_datoEvaluacionesFactores(Boolean mostrarcodigo_datoEvaluacionesFactores) {
		this.mostrarcodigo_datoEvaluacionesFactores= mostrarcodigo_datoEvaluacionesFactores;
	}

	public Boolean getActivarcodigo_datoEvaluacionesFactores() {
		return this.activarcodigo_datoEvaluacionesFactores;
	}

	public void setActivarcodigo_datoEvaluacionesFactores(Boolean activarcodigo_datoEvaluacionesFactores) {
		this.activarcodigo_datoEvaluacionesFactores= activarcodigo_datoEvaluacionesFactores;
	}

	public Border setResaltarnombre_completoEvaluacionesFactores(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesFactoresBeanSwingJInternalFrame evaluacionesfactoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesfactoresBeanSwingJInternalFrame.jTtoolBarEvaluacionesFactores.setBorder(borderResaltar);
		
		this.resaltarnombre_completoEvaluacionesFactores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoEvaluacionesFactores() {
		return this.resaltarnombre_completoEvaluacionesFactores;
	}

	public void setResaltarnombre_completoEvaluacionesFactores(Border borderResaltar) {
		this.resaltarnombre_completoEvaluacionesFactores= borderResaltar;
	}

	public Boolean getMostrarnombre_completoEvaluacionesFactores() {
		return this.mostrarnombre_completoEvaluacionesFactores;
	}

	public void setMostrarnombre_completoEvaluacionesFactores(Boolean mostrarnombre_completoEvaluacionesFactores) {
		this.mostrarnombre_completoEvaluacionesFactores= mostrarnombre_completoEvaluacionesFactores;
	}

	public Boolean getActivarnombre_completoEvaluacionesFactores() {
		return this.activarnombre_completoEvaluacionesFactores;
	}

	public void setActivarnombre_completoEvaluacionesFactores(Boolean activarnombre_completoEvaluacionesFactores) {
		this.activarnombre_completoEvaluacionesFactores= activarnombre_completoEvaluacionesFactores;
	}

	public Border setResaltarid_formato_nomi_pregunta_nomiEvaluacionesFactores(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesFactoresBeanSwingJInternalFrame evaluacionesfactoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesfactoresBeanSwingJInternalFrame.jTtoolBarEvaluacionesFactores.setBorder(borderResaltar);
		
		this.resaltarid_formato_nomi_pregunta_nomiEvaluacionesFactores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_nomi_pregunta_nomiEvaluacionesFactores() {
		return this.resaltarid_formato_nomi_pregunta_nomiEvaluacionesFactores;
	}

	public void setResaltarid_formato_nomi_pregunta_nomiEvaluacionesFactores(Border borderResaltar) {
		this.resaltarid_formato_nomi_pregunta_nomiEvaluacionesFactores= borderResaltar;
	}

	public Boolean getMostrarid_formato_nomi_pregunta_nomiEvaluacionesFactores() {
		return this.mostrarid_formato_nomi_pregunta_nomiEvaluacionesFactores;
	}

	public void setMostrarid_formato_nomi_pregunta_nomiEvaluacionesFactores(Boolean mostrarid_formato_nomi_pregunta_nomiEvaluacionesFactores) {
		this.mostrarid_formato_nomi_pregunta_nomiEvaluacionesFactores= mostrarid_formato_nomi_pregunta_nomiEvaluacionesFactores;
	}

	public Boolean getActivarid_formato_nomi_pregunta_nomiEvaluacionesFactores() {
		return this.activarid_formato_nomi_pregunta_nomiEvaluacionesFactores;
	}

	public void setActivarid_formato_nomi_pregunta_nomiEvaluacionesFactores(Boolean activarid_formato_nomi_pregunta_nomiEvaluacionesFactores) {
		this.activarid_formato_nomi_pregunta_nomiEvaluacionesFactores= activarid_formato_nomi_pregunta_nomiEvaluacionesFactores;
	}

	public Boolean getCargarid_formato_nomi_pregunta_nomiEvaluacionesFactores() {
		return this.cargarid_formato_nomi_pregunta_nomiEvaluacionesFactores;
	}

	public void setCargarid_formato_nomi_pregunta_nomiEvaluacionesFactores(Boolean cargarid_formato_nomi_pregunta_nomiEvaluacionesFactores) {
		this.cargarid_formato_nomi_pregunta_nomiEvaluacionesFactores= cargarid_formato_nomi_pregunta_nomiEvaluacionesFactores;
	}

	public Border setResaltarvalor_conocimientoEvaluacionesFactores(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesFactoresBeanSwingJInternalFrame evaluacionesfactoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesfactoresBeanSwingJInternalFrame.jTtoolBarEvaluacionesFactores.setBorder(borderResaltar);
		
		this.resaltarvalor_conocimientoEvaluacionesFactores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_conocimientoEvaluacionesFactores() {
		return this.resaltarvalor_conocimientoEvaluacionesFactores;
	}

	public void setResaltarvalor_conocimientoEvaluacionesFactores(Border borderResaltar) {
		this.resaltarvalor_conocimientoEvaluacionesFactores= borderResaltar;
	}

	public Boolean getMostrarvalor_conocimientoEvaluacionesFactores() {
		return this.mostrarvalor_conocimientoEvaluacionesFactores;
	}

	public void setMostrarvalor_conocimientoEvaluacionesFactores(Boolean mostrarvalor_conocimientoEvaluacionesFactores) {
		this.mostrarvalor_conocimientoEvaluacionesFactores= mostrarvalor_conocimientoEvaluacionesFactores;
	}

	public Boolean getActivarvalor_conocimientoEvaluacionesFactores() {
		return this.activarvalor_conocimientoEvaluacionesFactores;
	}

	public void setActivarvalor_conocimientoEvaluacionesFactores(Boolean activarvalor_conocimientoEvaluacionesFactores) {
		this.activarvalor_conocimientoEvaluacionesFactores= activarvalor_conocimientoEvaluacionesFactores;
	}

	public Border setResaltarvalor_eficienciaEvaluacionesFactores(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesFactoresBeanSwingJInternalFrame evaluacionesfactoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesfactoresBeanSwingJInternalFrame.jTtoolBarEvaluacionesFactores.setBorder(borderResaltar);
		
		this.resaltarvalor_eficienciaEvaluacionesFactores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_eficienciaEvaluacionesFactores() {
		return this.resaltarvalor_eficienciaEvaluacionesFactores;
	}

	public void setResaltarvalor_eficienciaEvaluacionesFactores(Border borderResaltar) {
		this.resaltarvalor_eficienciaEvaluacionesFactores= borderResaltar;
	}

	public Boolean getMostrarvalor_eficienciaEvaluacionesFactores() {
		return this.mostrarvalor_eficienciaEvaluacionesFactores;
	}

	public void setMostrarvalor_eficienciaEvaluacionesFactores(Boolean mostrarvalor_eficienciaEvaluacionesFactores) {
		this.mostrarvalor_eficienciaEvaluacionesFactores= mostrarvalor_eficienciaEvaluacionesFactores;
	}

	public Boolean getActivarvalor_eficienciaEvaluacionesFactores() {
		return this.activarvalor_eficienciaEvaluacionesFactores;
	}

	public void setActivarvalor_eficienciaEvaluacionesFactores(Boolean activarvalor_eficienciaEvaluacionesFactores) {
		this.activarvalor_eficienciaEvaluacionesFactores= activarvalor_eficienciaEvaluacionesFactores;
	}

	public Border setResaltarvalor_obtenidoEvaluacionesFactores(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesFactoresBeanSwingJInternalFrame evaluacionesfactoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesfactoresBeanSwingJInternalFrame.jTtoolBarEvaluacionesFactores.setBorder(borderResaltar);
		
		this.resaltarvalor_obtenidoEvaluacionesFactores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_obtenidoEvaluacionesFactores() {
		return this.resaltarvalor_obtenidoEvaluacionesFactores;
	}

	public void setResaltarvalor_obtenidoEvaluacionesFactores(Border borderResaltar) {
		this.resaltarvalor_obtenidoEvaluacionesFactores= borderResaltar;
	}

	public Boolean getMostrarvalor_obtenidoEvaluacionesFactores() {
		return this.mostrarvalor_obtenidoEvaluacionesFactores;
	}

	public void setMostrarvalor_obtenidoEvaluacionesFactores(Boolean mostrarvalor_obtenidoEvaluacionesFactores) {
		this.mostrarvalor_obtenidoEvaluacionesFactores= mostrarvalor_obtenidoEvaluacionesFactores;
	}

	public Boolean getActivarvalor_obtenidoEvaluacionesFactores() {
		return this.activarvalor_obtenidoEvaluacionesFactores;
	}

	public void setActivarvalor_obtenidoEvaluacionesFactores(Boolean activarvalor_obtenidoEvaluacionesFactores) {
		this.activarvalor_obtenidoEvaluacionesFactores= activarvalor_obtenidoEvaluacionesFactores;
	}

	public Border setResaltarpromedioEvaluacionesFactores(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesFactoresBeanSwingJInternalFrame evaluacionesfactoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesfactoresBeanSwingJInternalFrame.jTtoolBarEvaluacionesFactores.setBorder(borderResaltar);
		
		this.resaltarpromedioEvaluacionesFactores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpromedioEvaluacionesFactores() {
		return this.resaltarpromedioEvaluacionesFactores;
	}

	public void setResaltarpromedioEvaluacionesFactores(Border borderResaltar) {
		this.resaltarpromedioEvaluacionesFactores= borderResaltar;
	}

	public Boolean getMostrarpromedioEvaluacionesFactores() {
		return this.mostrarpromedioEvaluacionesFactores;
	}

	public void setMostrarpromedioEvaluacionesFactores(Boolean mostrarpromedioEvaluacionesFactores) {
		this.mostrarpromedioEvaluacionesFactores= mostrarpromedioEvaluacionesFactores;
	}

	public Boolean getActivarpromedioEvaluacionesFactores() {
		return this.activarpromedioEvaluacionesFactores;
	}

	public void setActivarpromedioEvaluacionesFactores(Boolean activarpromedioEvaluacionesFactores) {
		this.activarpromedioEvaluacionesFactores= activarpromedioEvaluacionesFactores;
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
		
		
		this.setMostraridEvaluacionesFactores(esInicial);
		this.setMostrarid_tipo_calificacion_empleadoEvaluacionesFactores(esInicial);
		this.setMostrarverificadoEvaluacionesFactores(esInicial);
		this.setMostrarid_estructuraEvaluacionesFactores(esInicial);
		this.setMostrarcodigoEvaluacionesFactores(esInicial);
		this.setMostrarid_empresaEvaluacionesFactores(esInicial);
		this.setMostrarid_sucursalEvaluacionesFactores(esInicial);
		this.setMostrarcodigo_datoEvaluacionesFactores(esInicial);
		this.setMostrarnombre_completoEvaluacionesFactores(esInicial);
		this.setMostrarid_formato_nomi_pregunta_nomiEvaluacionesFactores(esInicial);
		this.setMostrarvalor_conocimientoEvaluacionesFactores(esInicial);
		this.setMostrarvalor_eficienciaEvaluacionesFactores(esInicial);
		this.setMostrarvalor_obtenidoEvaluacionesFactores(esInicial);
		this.setMostrarpromedioEvaluacionesFactores(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.ID)) {
				this.setMostraridEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO)) {
				this.setMostrarid_tipo_calificacion_empleadoEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.VERIFICADO)) {
				this.setMostrarverificadoEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.CODIGODATO)) {
				this.setMostrarcodigo_datoEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.IDFORMATONOMIPREGUNTANOMI)) {
				this.setMostrarid_formato_nomi_pregunta_nomiEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.VALORCONOCIMIENTO)) {
				this.setMostrarvalor_conocimientoEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.VALOREFICIENCIA)) {
				this.setMostrarvalor_eficienciaEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.VALOROBTENIDO)) {
				this.setMostrarvalor_obtenidoEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.PROMEDIO)) {
				this.setMostrarpromedioEvaluacionesFactores(esAsigna);
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
		
		
		this.setActivaridEvaluacionesFactores(esInicial);
		this.setActivarid_tipo_calificacion_empleadoEvaluacionesFactores(esInicial);
		this.setActivarverificadoEvaluacionesFactores(esInicial);
		this.setActivarid_estructuraEvaluacionesFactores(esInicial);
		this.setActivarcodigoEvaluacionesFactores(esInicial);
		this.setActivarid_empresaEvaluacionesFactores(esInicial);
		this.setActivarid_sucursalEvaluacionesFactores(esInicial);
		this.setActivarcodigo_datoEvaluacionesFactores(esInicial);
		this.setActivarnombre_completoEvaluacionesFactores(esInicial);
		this.setActivarid_formato_nomi_pregunta_nomiEvaluacionesFactores(esInicial);
		this.setActivarvalor_conocimientoEvaluacionesFactores(esInicial);
		this.setActivarvalor_eficienciaEvaluacionesFactores(esInicial);
		this.setActivarvalor_obtenidoEvaluacionesFactores(esInicial);
		this.setActivarpromedioEvaluacionesFactores(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.ID)) {
				this.setActivaridEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO)) {
				this.setActivarid_tipo_calificacion_empleadoEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.VERIFICADO)) {
				this.setActivarverificadoEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.CODIGODATO)) {
				this.setActivarcodigo_datoEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.IDFORMATONOMIPREGUNTANOMI)) {
				this.setActivarid_formato_nomi_pregunta_nomiEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.VALORCONOCIMIENTO)) {
				this.setActivarvalor_conocimientoEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.VALOREFICIENCIA)) {
				this.setActivarvalor_eficienciaEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.VALOROBTENIDO)) {
				this.setActivarvalor_obtenidoEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.PROMEDIO)) {
				this.setActivarpromedioEvaluacionesFactores(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EvaluacionesFactoresBeanSwingJInternalFrame evaluacionesfactoresBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEvaluacionesFactores(esInicial);
		this.setResaltarid_tipo_calificacion_empleadoEvaluacionesFactores(esInicial);
		this.setResaltarverificadoEvaluacionesFactores(esInicial);
		this.setResaltarid_estructuraEvaluacionesFactores(esInicial);
		this.setResaltarcodigoEvaluacionesFactores(esInicial);
		this.setResaltarid_empresaEvaluacionesFactores(esInicial);
		this.setResaltarid_sucursalEvaluacionesFactores(esInicial);
		this.setResaltarcodigo_datoEvaluacionesFactores(esInicial);
		this.setResaltarnombre_completoEvaluacionesFactores(esInicial);
		this.setResaltarid_formato_nomi_pregunta_nomiEvaluacionesFactores(esInicial);
		this.setResaltarvalor_conocimientoEvaluacionesFactores(esInicial);
		this.setResaltarvalor_eficienciaEvaluacionesFactores(esInicial);
		this.setResaltarvalor_obtenidoEvaluacionesFactores(esInicial);
		this.setResaltarpromedioEvaluacionesFactores(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.ID)) {
				this.setResaltaridEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO)) {
				this.setResaltarid_tipo_calificacion_empleadoEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.VERIFICADO)) {
				this.setResaltarverificadoEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.CODIGODATO)) {
				this.setResaltarcodigo_datoEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.IDFORMATONOMIPREGUNTANOMI)) {
				this.setResaltarid_formato_nomi_pregunta_nomiEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.VALORCONOCIMIENTO)) {
				this.setResaltarvalor_conocimientoEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.VALOREFICIENCIA)) {
				this.setResaltarvalor_eficienciaEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.VALOROBTENIDO)) {
				this.setResaltarvalor_obtenidoEvaluacionesFactores(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesFactoresConstantesFunciones.PROMEDIO)) {
				this.setResaltarpromedioEvaluacionesFactores(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EvaluacionesFactoresBeanSwingJInternalFrame evaluacionesfactoresBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaEvaluacionesFactoresEvaluacionesFactores=true;

	public Boolean getMostrarBusquedaEvaluacionesFactoresEvaluacionesFactores() {
		return this.mostrarBusquedaEvaluacionesFactoresEvaluacionesFactores;
	}

	public void setMostrarBusquedaEvaluacionesFactoresEvaluacionesFactores(Boolean visibilidadResaltar) {
		this.mostrarBusquedaEvaluacionesFactoresEvaluacionesFactores= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaEvaluacionesFactoresEvaluacionesFactores=true;

	public Boolean getActivarBusquedaEvaluacionesFactoresEvaluacionesFactores() {
		return this.activarBusquedaEvaluacionesFactoresEvaluacionesFactores;
	}

	public void setActivarBusquedaEvaluacionesFactoresEvaluacionesFactores(Boolean habilitarResaltar) {
		this.activarBusquedaEvaluacionesFactoresEvaluacionesFactores= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaEvaluacionesFactoresEvaluacionesFactores=null;

	public Border getResaltarBusquedaEvaluacionesFactoresEvaluacionesFactores() {
		return this.resaltarBusquedaEvaluacionesFactoresEvaluacionesFactores;
	}

	public void setResaltarBusquedaEvaluacionesFactoresEvaluacionesFactores(Border borderResaltar) {
		this.resaltarBusquedaEvaluacionesFactoresEvaluacionesFactores= borderResaltar;
	}

	public void setResaltarBusquedaEvaluacionesFactoresEvaluacionesFactores(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesFactoresBeanSwingJInternalFrame evaluacionesfactoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaEvaluacionesFactoresEvaluacionesFactores= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}