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


import com.bydan.erp.nomina.util.report.EvaluacionesBonificacionesConstantesFunciones;
import com.bydan.erp.nomina.util.report.EvaluacionesBonificacionesParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.EvaluacionesBonificacionesParameterGeneral;

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
final public class EvaluacionesBonificacionesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EvaluacionesBonificaciones";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EvaluacionesBonificaciones"+EvaluacionesBonificacionesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EvaluacionesBonificacionesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EvaluacionesBonificacionesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EvaluacionesBonificacionesConstantesFunciones.SCHEMA+"_"+EvaluacionesBonificacionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EvaluacionesBonificacionesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EvaluacionesBonificacionesConstantesFunciones.SCHEMA+"_"+EvaluacionesBonificacionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EvaluacionesBonificacionesConstantesFunciones.SCHEMA+"_"+EvaluacionesBonificacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EvaluacionesBonificacionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EvaluacionesBonificacionesConstantesFunciones.SCHEMA+"_"+EvaluacionesBonificacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionesBonificacionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EvaluacionesBonificacionesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionesBonificacionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionesBonificacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EvaluacionesBonificacionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionesBonificacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EvaluacionesBonificacionesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EvaluacionesBonificacionesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EvaluacionesBonificacionesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EvaluacionesBonificacionesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Evaluaciones Bonificacioneses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Evaluaciones Bonificaciones";
	public static final String SCLASSWEBTITULO_LOWER="Evaluaciones Bonificaciones";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EvaluacionesBonificaciones";
	public static final String OBJECTNAME="evaluacionesbonificaciones";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="evaluaciones_bonificaciones";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select evaluacionesbonificaciones from "+EvaluacionesBonificacionesConstantesFunciones.SPERSISTENCENAME+" evaluacionesbonificaciones";
	public static String QUERYSELECTNATIVE="select "+EvaluacionesBonificacionesConstantesFunciones.SCHEMA+"."+EvaluacionesBonificacionesConstantesFunciones.TABLENAME+".id,"+EvaluacionesBonificacionesConstantesFunciones.SCHEMA+"."+EvaluacionesBonificacionesConstantesFunciones.TABLENAME+".version_row,"+EvaluacionesBonificacionesConstantesFunciones.SCHEMA+"."+EvaluacionesBonificacionesConstantesFunciones.TABLENAME+".id_tipo_calificacion_empleado,"+EvaluacionesBonificacionesConstantesFunciones.SCHEMA+"."+EvaluacionesBonificacionesConstantesFunciones.TABLENAME+".verificado,"+EvaluacionesBonificacionesConstantesFunciones.SCHEMA+"."+EvaluacionesBonificacionesConstantesFunciones.TABLENAME+".id_estructura,"+EvaluacionesBonificacionesConstantesFunciones.SCHEMA+"."+EvaluacionesBonificacionesConstantesFunciones.TABLENAME+".codigo,"+EvaluacionesBonificacionesConstantesFunciones.SCHEMA+"."+EvaluacionesBonificacionesConstantesFunciones.TABLENAME+".id_empresa,"+EvaluacionesBonificacionesConstantesFunciones.SCHEMA+"."+EvaluacionesBonificacionesConstantesFunciones.TABLENAME+".id_sucursal,"+EvaluacionesBonificacionesConstantesFunciones.SCHEMA+"."+EvaluacionesBonificacionesConstantesFunciones.TABLENAME+".codigo_dato,"+EvaluacionesBonificacionesConstantesFunciones.SCHEMA+"."+EvaluacionesBonificacionesConstantesFunciones.TABLENAME+".nombre_completo,"+EvaluacionesBonificacionesConstantesFunciones.SCHEMA+"."+EvaluacionesBonificacionesConstantesFunciones.TABLENAME+".sueldo,"+EvaluacionesBonificacionesConstantesFunciones.SCHEMA+"."+EvaluacionesBonificacionesConstantesFunciones.TABLENAME+".valor_conocimiento,"+EvaluacionesBonificacionesConstantesFunciones.SCHEMA+"."+EvaluacionesBonificacionesConstantesFunciones.TABLENAME+".valor_eficiencia,"+EvaluacionesBonificacionesConstantesFunciones.SCHEMA+"."+EvaluacionesBonificacionesConstantesFunciones.TABLENAME+".valor_obtenido,"+EvaluacionesBonificacionesConstantesFunciones.SCHEMA+"."+EvaluacionesBonificacionesConstantesFunciones.TABLENAME+".valor_peso,"+EvaluacionesBonificacionesConstantesFunciones.SCHEMA+"."+EvaluacionesBonificacionesConstantesFunciones.TABLENAME+".bonificacion from "+EvaluacionesBonificacionesConstantesFunciones.SCHEMA+"."+EvaluacionesBonificacionesConstantesFunciones.TABLENAME;//+" as "+EvaluacionesBonificacionesConstantesFunciones.TABLENAME;
	
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
    public static final String SUELDO= "sueldo";
    public static final String VALORCONOCIMIENTO= "valor_conocimiento";
    public static final String VALOREFICIENCIA= "valor_eficiencia";
    public static final String VALOROBTENIDO= "valor_obtenido";
    public static final String VALORPESO= "valor_peso";
    public static final String BONIFICACION= "bonificacion";
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
    	public static final String LABEL_SUELDO= "Sueldo";
		public static final String LABEL_SUELDO_LOWER= "Sueldo";
    	public static final String LABEL_VALORCONOCIMIENTO= "Valor Conocimiento";
		public static final String LABEL_VALORCONOCIMIENTO_LOWER= "Valor Conocimiento";
    	public static final String LABEL_VALOREFICIENCIA= "Valor Eficiencia";
		public static final String LABEL_VALOREFICIENCIA_LOWER= "Valor Eficiencia";
    	public static final String LABEL_VALOROBTENIDO= "Valor Obtenido";
		public static final String LABEL_VALOROBTENIDO_LOWER= "Valor Obtenido";
    	public static final String LABEL_VALORPESO= "Valor Peso";
		public static final String LABEL_VALORPESO_LOWER= "Valor Peso";
    	public static final String LABEL_BONIFICACION= "Bonificacion";
		public static final String LABEL_BONIFICACION_LOWER= "Bonificacion";
	
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXCODIGO_DATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_DATO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	
	public static String getEvaluacionesBonificacionesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EvaluacionesBonificacionesConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO)) {sLabelColumna=EvaluacionesBonificacionesConstantesFunciones.LABEL_IDTIPOCALIFICACIONEMPLEADO;}
		if(sNombreColumna.equals(EvaluacionesBonificacionesConstantesFunciones.VERIFICADO)) {sLabelColumna=EvaluacionesBonificacionesConstantesFunciones.LABEL_VERIFICADO;}
		if(sNombreColumna.equals(EvaluacionesBonificacionesConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=EvaluacionesBonificacionesConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(EvaluacionesBonificacionesConstantesFunciones.CODIGO)) {sLabelColumna=EvaluacionesBonificacionesConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EvaluacionesBonificacionesConstantesFunciones.IDEMPRESA)) {sLabelColumna=EvaluacionesBonificacionesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EvaluacionesBonificacionesConstantesFunciones.IDSUCURSAL)) {sLabelColumna=EvaluacionesBonificacionesConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(EvaluacionesBonificacionesConstantesFunciones.CODIGODATO)) {sLabelColumna=EvaluacionesBonificacionesConstantesFunciones.LABEL_CODIGODATO;}
		if(sNombreColumna.equals(EvaluacionesBonificacionesConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=EvaluacionesBonificacionesConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(EvaluacionesBonificacionesConstantesFunciones.SUELDO)) {sLabelColumna=EvaluacionesBonificacionesConstantesFunciones.LABEL_SUELDO;}
		if(sNombreColumna.equals(EvaluacionesBonificacionesConstantesFunciones.VALORCONOCIMIENTO)) {sLabelColumna=EvaluacionesBonificacionesConstantesFunciones.LABEL_VALORCONOCIMIENTO;}
		if(sNombreColumna.equals(EvaluacionesBonificacionesConstantesFunciones.VALOREFICIENCIA)) {sLabelColumna=EvaluacionesBonificacionesConstantesFunciones.LABEL_VALOREFICIENCIA;}
		if(sNombreColumna.equals(EvaluacionesBonificacionesConstantesFunciones.VALOROBTENIDO)) {sLabelColumna=EvaluacionesBonificacionesConstantesFunciones.LABEL_VALOROBTENIDO;}
		if(sNombreColumna.equals(EvaluacionesBonificacionesConstantesFunciones.VALORPESO)) {sLabelColumna=EvaluacionesBonificacionesConstantesFunciones.LABEL_VALORPESO;}
		if(sNombreColumna.equals(EvaluacionesBonificacionesConstantesFunciones.BONIFICACION)) {sLabelColumna=EvaluacionesBonificacionesConstantesFunciones.LABEL_BONIFICACION;}
		
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
	
	
	
			
			
			
		
	public static String getverificadoDescripcion(EvaluacionesBonificaciones evaluacionesbonificaciones) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!evaluacionesbonificaciones.getverificado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getverificadoHtmlDescripcion(EvaluacionesBonificaciones evaluacionesbonificaciones) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(evaluacionesbonificaciones.getId(),evaluacionesbonificaciones.getverificado());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getEvaluacionesBonificacionesDescripcion(EvaluacionesBonificaciones evaluacionesbonificaciones) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(evaluacionesbonificaciones !=null/* && evaluacionesbonificaciones.getId()!=0*/) {
			sDescripcion=evaluacionesbonificaciones.getcodigo();//evaluacionesbonificacionesevaluacionesbonificaciones.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEvaluacionesBonificacionesDescripcionDetallado(EvaluacionesBonificaciones evaluacionesbonificaciones) {
		String sDescripcion="";
			
		sDescripcion+=EvaluacionesBonificacionesConstantesFunciones.ID+"=";
		sDescripcion+=evaluacionesbonificaciones.getId().toString()+",";
		sDescripcion+=EvaluacionesBonificacionesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=evaluacionesbonificaciones.getVersionRow().toString()+",";
		sDescripcion+=EvaluacionesBonificacionesConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO+"=";
		sDescripcion+=evaluacionesbonificaciones.getid_tipo_calificacion_empleado().toString()+",";
		sDescripcion+=EvaluacionesBonificacionesConstantesFunciones.VERIFICADO+"=";
		sDescripcion+=evaluacionesbonificaciones.getverificado().toString()+",";
		sDescripcion+=EvaluacionesBonificacionesConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=evaluacionesbonificaciones.getid_estructura().toString()+",";
		sDescripcion+=EvaluacionesBonificacionesConstantesFunciones.CODIGO+"=";
		sDescripcion+=evaluacionesbonificaciones.getcodigo()+",";
		sDescripcion+=EvaluacionesBonificacionesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=evaluacionesbonificaciones.getid_empresa().toString()+",";
		sDescripcion+=EvaluacionesBonificacionesConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=evaluacionesbonificaciones.getid_sucursal().toString()+",";
		sDescripcion+=EvaluacionesBonificacionesConstantesFunciones.CODIGODATO+"=";
		sDescripcion+=evaluacionesbonificaciones.getcodigo_dato()+",";
		sDescripcion+=EvaluacionesBonificacionesConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=evaluacionesbonificaciones.getnombre_completo()+",";
		sDescripcion+=EvaluacionesBonificacionesConstantesFunciones.SUELDO+"=";
		sDescripcion+=evaluacionesbonificaciones.getsueldo().toString()+",";
		sDescripcion+=EvaluacionesBonificacionesConstantesFunciones.VALORCONOCIMIENTO+"=";
		sDescripcion+=evaluacionesbonificaciones.getvalor_conocimiento().toString()+",";
		sDescripcion+=EvaluacionesBonificacionesConstantesFunciones.VALOREFICIENCIA+"=";
		sDescripcion+=evaluacionesbonificaciones.getvalor_eficiencia().toString()+",";
		sDescripcion+=EvaluacionesBonificacionesConstantesFunciones.VALOROBTENIDO+"=";
		sDescripcion+=evaluacionesbonificaciones.getvalor_obtenido().toString()+",";
		sDescripcion+=EvaluacionesBonificacionesConstantesFunciones.VALORPESO+"=";
		sDescripcion+=evaluacionesbonificaciones.getvalor_peso().toString()+",";
		sDescripcion+=EvaluacionesBonificacionesConstantesFunciones.BONIFICACION+"=";
		sDescripcion+=evaluacionesbonificaciones.getbonificacion().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEvaluacionesBonificacionesDescripcion(EvaluacionesBonificaciones evaluacionesbonificaciones,String sValor) throws Exception {			
		if(evaluacionesbonificaciones !=null) {
			evaluacionesbonificaciones.setcodigo(sValor);;//evaluacionesbonificacionesevaluacionesbonificaciones.getcodigo().trim();
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaEvaluacionesBonificaciones")) {
			sNombreIndice="Tipo=  Por Tipo Calificacion Empleado Por Verificado Por Estructura Por Codigo";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
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

	public static String getDetalleIndiceBusquedaEvaluacionesBonificaciones(Long id_tipo_calificacion_empleado,Boolean verificado,Long id_estructura,String codigo) {
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
	
	
	
	
	
	
	public static void quitarEspaciosEvaluacionesBonificaciones(EvaluacionesBonificaciones evaluacionesbonificaciones,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		evaluacionesbonificaciones.setcodigo_dato(evaluacionesbonificaciones.getcodigo_dato().trim());
		evaluacionesbonificaciones.setnombre_completo(evaluacionesbonificaciones.getnombre_completo().trim());
	}
	
	public static void quitarEspaciosEvaluacionesBonificacioness(List<EvaluacionesBonificaciones> evaluacionesbonificacioness,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EvaluacionesBonificaciones evaluacionesbonificaciones: evaluacionesbonificacioness) {
			evaluacionesbonificaciones.setcodigo_dato(evaluacionesbonificaciones.getcodigo_dato().trim());
			evaluacionesbonificaciones.setnombre_completo(evaluacionesbonificaciones.getnombre_completo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEvaluacionesBonificaciones(EvaluacionesBonificaciones evaluacionesbonificaciones,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && evaluacionesbonificaciones.getConCambioAuxiliar()) {
			evaluacionesbonificaciones.setIsDeleted(evaluacionesbonificaciones.getIsDeletedAuxiliar());	
			evaluacionesbonificaciones.setIsNew(evaluacionesbonificaciones.getIsNewAuxiliar());	
			evaluacionesbonificaciones.setIsChanged(evaluacionesbonificaciones.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			evaluacionesbonificaciones.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			evaluacionesbonificaciones.setIsDeletedAuxiliar(false);	
			evaluacionesbonificaciones.setIsNewAuxiliar(false);	
			evaluacionesbonificaciones.setIsChangedAuxiliar(false);
			
			evaluacionesbonificaciones.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEvaluacionesBonificacioness(List<EvaluacionesBonificaciones> evaluacionesbonificacioness,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EvaluacionesBonificaciones evaluacionesbonificaciones : evaluacionesbonificacioness) {
			if(conAsignarBase && evaluacionesbonificaciones.getConCambioAuxiliar()) {
				evaluacionesbonificaciones.setIsDeleted(evaluacionesbonificaciones.getIsDeletedAuxiliar());	
				evaluacionesbonificaciones.setIsNew(evaluacionesbonificaciones.getIsNewAuxiliar());	
				evaluacionesbonificaciones.setIsChanged(evaluacionesbonificaciones.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				evaluacionesbonificaciones.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				evaluacionesbonificaciones.setIsDeletedAuxiliar(false);	
				evaluacionesbonificaciones.setIsNewAuxiliar(false);	
				evaluacionesbonificaciones.setIsChangedAuxiliar(false);
				
				evaluacionesbonificaciones.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEvaluacionesBonificaciones(EvaluacionesBonificaciones evaluacionesbonificaciones,Boolean conEnteros) throws Exception  {
		evaluacionesbonificaciones.setsueldo(0.0);
		evaluacionesbonificaciones.setvalor_conocimiento(0.0);
		evaluacionesbonificaciones.setvalor_eficiencia(0.0);
		evaluacionesbonificaciones.setvalor_obtenido(0.0);
		evaluacionesbonificaciones.setvalor_peso(0.0);
		evaluacionesbonificaciones.setbonificacion(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEvaluacionesBonificacioness(List<EvaluacionesBonificaciones> evaluacionesbonificacioness,Boolean conEnteros) throws Exception  {
		
		for(EvaluacionesBonificaciones evaluacionesbonificaciones: evaluacionesbonificacioness) {
			evaluacionesbonificaciones.setsueldo(0.0);
			evaluacionesbonificaciones.setvalor_conocimiento(0.0);
			evaluacionesbonificaciones.setvalor_eficiencia(0.0);
			evaluacionesbonificaciones.setvalor_obtenido(0.0);
			evaluacionesbonificaciones.setvalor_peso(0.0);
			evaluacionesbonificaciones.setbonificacion(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEvaluacionesBonificaciones(List<EvaluacionesBonificaciones> evaluacionesbonificacioness,EvaluacionesBonificaciones evaluacionesbonificacionesAux) throws Exception  {
		EvaluacionesBonificacionesConstantesFunciones.InicializarValoresEvaluacionesBonificaciones(evaluacionesbonificacionesAux,true);
		
		for(EvaluacionesBonificaciones evaluacionesbonificaciones: evaluacionesbonificacioness) {
			if(evaluacionesbonificaciones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			evaluacionesbonificacionesAux.setsueldo(evaluacionesbonificacionesAux.getsueldo()+evaluacionesbonificaciones.getsueldo());			
			evaluacionesbonificacionesAux.setvalor_conocimiento(evaluacionesbonificacionesAux.getvalor_conocimiento()+evaluacionesbonificaciones.getvalor_conocimiento());			
			evaluacionesbonificacionesAux.setvalor_eficiencia(evaluacionesbonificacionesAux.getvalor_eficiencia()+evaluacionesbonificaciones.getvalor_eficiencia());			
			evaluacionesbonificacionesAux.setvalor_obtenido(evaluacionesbonificacionesAux.getvalor_obtenido()+evaluacionesbonificaciones.getvalor_obtenido());			
			evaluacionesbonificacionesAux.setvalor_peso(evaluacionesbonificacionesAux.getvalor_peso()+evaluacionesbonificaciones.getvalor_peso());			
			evaluacionesbonificacionesAux.setbonificacion(evaluacionesbonificacionesAux.getbonificacion()+evaluacionesbonificaciones.getbonificacion());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEvaluacionesBonificaciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EvaluacionesBonificacionesConstantesFunciones.getArrayColumnasGlobalesEvaluacionesBonificaciones(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEvaluacionesBonificaciones(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EvaluacionesBonificacionesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EvaluacionesBonificacionesConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EvaluacionesBonificacionesConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EvaluacionesBonificacionesConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEvaluacionesBonificaciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EvaluacionesBonificaciones> evaluacionesbonificacioness,EvaluacionesBonificaciones evaluacionesbonificaciones,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EvaluacionesBonificaciones evaluacionesbonificacionesAux: evaluacionesbonificacioness) {
			if(evaluacionesbonificacionesAux!=null && evaluacionesbonificaciones!=null) {
				if((evaluacionesbonificacionesAux.getId()==null && evaluacionesbonificaciones.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(evaluacionesbonificacionesAux.getId()!=null && evaluacionesbonificaciones.getId()!=null){
					if(evaluacionesbonificacionesAux.getId().equals(evaluacionesbonificaciones.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEvaluacionesBonificaciones(List<EvaluacionesBonificaciones> evaluacionesbonificacioness) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double sueldoTotal=0.0;
		Double valor_conocimientoTotal=0.0;
		Double valor_eficienciaTotal=0.0;
		Double valor_obtenidoTotal=0.0;
		Double valor_pesoTotal=0.0;
		Double bonificacionTotal=0.0;
	
		for(EvaluacionesBonificaciones evaluacionesbonificaciones: evaluacionesbonificacioness) {			
			if(evaluacionesbonificaciones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			sueldoTotal+=evaluacionesbonificaciones.getsueldo();
			valor_conocimientoTotal+=evaluacionesbonificaciones.getvalor_conocimiento();
			valor_eficienciaTotal+=evaluacionesbonificaciones.getvalor_eficiencia();
			valor_obtenidoTotal+=evaluacionesbonificaciones.getvalor_obtenido();
			valor_pesoTotal+=evaluacionesbonificaciones.getvalor_peso();
			bonificacionTotal+=evaluacionesbonificaciones.getbonificacion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EvaluacionesBonificacionesConstantesFunciones.SUELDO);
		datoGeneral.setsDescripcion(EvaluacionesBonificacionesConstantesFunciones.LABEL_SUELDO);
		datoGeneral.setdValorDouble(sueldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EvaluacionesBonificacionesConstantesFunciones.VALORCONOCIMIENTO);
		datoGeneral.setsDescripcion(EvaluacionesBonificacionesConstantesFunciones.LABEL_VALORCONOCIMIENTO);
		datoGeneral.setdValorDouble(valor_conocimientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EvaluacionesBonificacionesConstantesFunciones.VALOREFICIENCIA);
		datoGeneral.setsDescripcion(EvaluacionesBonificacionesConstantesFunciones.LABEL_VALOREFICIENCIA);
		datoGeneral.setdValorDouble(valor_eficienciaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EvaluacionesBonificacionesConstantesFunciones.VALOROBTENIDO);
		datoGeneral.setsDescripcion(EvaluacionesBonificacionesConstantesFunciones.LABEL_VALOROBTENIDO);
		datoGeneral.setdValorDouble(valor_obtenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EvaluacionesBonificacionesConstantesFunciones.VALORPESO);
		datoGeneral.setsDescripcion(EvaluacionesBonificacionesConstantesFunciones.LABEL_VALORPESO);
		datoGeneral.setdValorDouble(valor_pesoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EvaluacionesBonificacionesConstantesFunciones.BONIFICACION);
		datoGeneral.setsDescripcion(EvaluacionesBonificacionesConstantesFunciones.LABEL_BONIFICACION);
		datoGeneral.setdValorDouble(bonificacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEvaluacionesBonificaciones() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EvaluacionesBonificacionesConstantesFunciones.LABEL_ID, EvaluacionesBonificacionesConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesBonificacionesConstantesFunciones.LABEL_VERSIONROW, EvaluacionesBonificacionesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesBonificacionesConstantesFunciones.LABEL_CODIGODATO, EvaluacionesBonificacionesConstantesFunciones.CODIGODATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesBonificacionesConstantesFunciones.LABEL_NOMBRECOMPLETO, EvaluacionesBonificacionesConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesBonificacionesConstantesFunciones.LABEL_SUELDO, EvaluacionesBonificacionesConstantesFunciones.SUELDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesBonificacionesConstantesFunciones.LABEL_VALORCONOCIMIENTO, EvaluacionesBonificacionesConstantesFunciones.VALORCONOCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesBonificacionesConstantesFunciones.LABEL_VALOREFICIENCIA, EvaluacionesBonificacionesConstantesFunciones.VALOREFICIENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesBonificacionesConstantesFunciones.LABEL_VALOROBTENIDO, EvaluacionesBonificacionesConstantesFunciones.VALOROBTENIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesBonificacionesConstantesFunciones.LABEL_VALORPESO, EvaluacionesBonificacionesConstantesFunciones.VALORPESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionesBonificacionesConstantesFunciones.LABEL_BONIFICACION, EvaluacionesBonificacionesConstantesFunciones.BONIFICACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEvaluacionesBonificaciones() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesBonificacionesConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesBonificacionesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesBonificacionesConstantesFunciones.CODIGODATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesBonificacionesConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesBonificacionesConstantesFunciones.SUELDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesBonificacionesConstantesFunciones.VALORCONOCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesBonificacionesConstantesFunciones.VALOREFICIENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesBonificacionesConstantesFunciones.VALOROBTENIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesBonificacionesConstantesFunciones.VALORPESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionesBonificacionesConstantesFunciones.BONIFICACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEvaluacionesBonificaciones() throws Exception  {
		return EvaluacionesBonificacionesConstantesFunciones.getTiposSeleccionarEvaluacionesBonificaciones(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEvaluacionesBonificaciones(Boolean conFk) throws Exception  {
		return EvaluacionesBonificacionesConstantesFunciones.getTiposSeleccionarEvaluacionesBonificaciones(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEvaluacionesBonificaciones(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesBonificacionesConstantesFunciones.LABEL_IDTIPOCALIFICACIONEMPLEADO);
			reporte.setsDescripcion(EvaluacionesBonificacionesConstantesFunciones.LABEL_IDTIPOCALIFICACIONEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesBonificacionesConstantesFunciones.LABEL_VERIFICADO);
			reporte.setsDescripcion(EvaluacionesBonificacionesConstantesFunciones.LABEL_VERIFICADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesBonificacionesConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(EvaluacionesBonificacionesConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesBonificacionesConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EvaluacionesBonificacionesConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesBonificacionesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EvaluacionesBonificacionesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesBonificacionesConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(EvaluacionesBonificacionesConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesBonificacionesConstantesFunciones.LABEL_CODIGODATO);
			reporte.setsDescripcion(EvaluacionesBonificacionesConstantesFunciones.LABEL_CODIGODATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesBonificacionesConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(EvaluacionesBonificacionesConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesBonificacionesConstantesFunciones.LABEL_SUELDO);
			reporte.setsDescripcion(EvaluacionesBonificacionesConstantesFunciones.LABEL_SUELDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesBonificacionesConstantesFunciones.LABEL_VALORCONOCIMIENTO);
			reporte.setsDescripcion(EvaluacionesBonificacionesConstantesFunciones.LABEL_VALORCONOCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesBonificacionesConstantesFunciones.LABEL_VALOREFICIENCIA);
			reporte.setsDescripcion(EvaluacionesBonificacionesConstantesFunciones.LABEL_VALOREFICIENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesBonificacionesConstantesFunciones.LABEL_VALOROBTENIDO);
			reporte.setsDescripcion(EvaluacionesBonificacionesConstantesFunciones.LABEL_VALOROBTENIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesBonificacionesConstantesFunciones.LABEL_VALORPESO);
			reporte.setsDescripcion(EvaluacionesBonificacionesConstantesFunciones.LABEL_VALORPESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionesBonificacionesConstantesFunciones.LABEL_BONIFICACION);
			reporte.setsDescripcion(EvaluacionesBonificacionesConstantesFunciones.LABEL_BONIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEvaluacionesBonificaciones(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEvaluacionesBonificaciones(EvaluacionesBonificaciones evaluacionesbonificacionesAux) throws Exception {
		
			evaluacionesbonificacionesAux.settipocalificacionempleado_descripcion(TipoCalificacionEmpleadoConstantesFunciones.getTipoCalificacionEmpleadoDescripcion(evaluacionesbonificacionesAux.getTipoCalificacionEmpleado()));
			evaluacionesbonificacionesAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(evaluacionesbonificacionesAux.getEstructura()));
			evaluacionesbonificacionesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(evaluacionesbonificacionesAux.getEmpresa()));
			evaluacionesbonificacionesAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(evaluacionesbonificacionesAux.getSucursal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEvaluacionesBonificaciones(List<EvaluacionesBonificaciones> evaluacionesbonificacionessTemp) throws Exception {
		for(EvaluacionesBonificaciones evaluacionesbonificacionesAux:evaluacionesbonificacionessTemp) {
			
			evaluacionesbonificacionesAux.settipocalificacionempleado_descripcion(TipoCalificacionEmpleadoConstantesFunciones.getTipoCalificacionEmpleadoDescripcion(evaluacionesbonificacionesAux.getTipoCalificacionEmpleado()));
			evaluacionesbonificacionesAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(evaluacionesbonificacionesAux.getEstructura()));
			evaluacionesbonificacionesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(evaluacionesbonificacionesAux.getEmpresa()));
			evaluacionesbonificacionesAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(evaluacionesbonificacionesAux.getSucursal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEvaluacionesBonificaciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TipoCalificacionEmpleado.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEvaluacionesBonificaciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEvaluacionesBonificaciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EvaluacionesBonificacionesConstantesFunciones.getClassesRelationshipsOfEvaluacionesBonificaciones(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEvaluacionesBonificaciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEvaluacionesBonificaciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EvaluacionesBonificacionesConstantesFunciones.getClassesRelationshipsFromStringsOfEvaluacionesBonificaciones(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEvaluacionesBonificaciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(EvaluacionesBonificaciones evaluacionesbonificaciones,List<EvaluacionesBonificaciones> evaluacionesbonificacioness,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(EvaluacionesBonificaciones evaluacionesbonificaciones,List<EvaluacionesBonificaciones> evaluacionesbonificacioness) throws Exception {
		try	{			
			for(EvaluacionesBonificaciones evaluacionesbonificacionesLocal:evaluacionesbonificacioness) {
				if(evaluacionesbonificacionesLocal.getId().equals(evaluacionesbonificaciones.getId())) {
					evaluacionesbonificacionesLocal.setIsSelected(evaluacionesbonificaciones.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEvaluacionesBonificaciones(List<EvaluacionesBonificaciones> evaluacionesbonificacionessAux) throws Exception {
		//this.evaluacionesbonificacionessAux=evaluacionesbonificacionessAux;
		
		for(EvaluacionesBonificaciones evaluacionesbonificacionesAux:evaluacionesbonificacionessAux) {
			if(evaluacionesbonificacionesAux.getIsChanged()) {
				evaluacionesbonificacionesAux.setIsChanged(false);
			}		
			
			if(evaluacionesbonificacionesAux.getIsNew()) {
				evaluacionesbonificacionesAux.setIsNew(false);
			}	
			
			if(evaluacionesbonificacionesAux.getIsDeleted()) {
				evaluacionesbonificacionesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEvaluacionesBonificaciones(EvaluacionesBonificaciones evaluacionesbonificacionesAux) throws Exception {
		//this.evaluacionesbonificacionesAux=evaluacionesbonificacionesAux;
		
			if(evaluacionesbonificacionesAux.getIsChanged()) {
				evaluacionesbonificacionesAux.setIsChanged(false);
			}		
			
			if(evaluacionesbonificacionesAux.getIsNew()) {
				evaluacionesbonificacionesAux.setIsNew(false);
			}	
			
			if(evaluacionesbonificacionesAux.getIsDeleted()) {
				evaluacionesbonificacionesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EvaluacionesBonificaciones evaluacionesbonificacionesAsignar,EvaluacionesBonificaciones evaluacionesbonificaciones) throws Exception {
		evaluacionesbonificacionesAsignar.setId(evaluacionesbonificaciones.getId());	
		evaluacionesbonificacionesAsignar.setVersionRow(evaluacionesbonificaciones.getVersionRow());	
		evaluacionesbonificacionesAsignar.setcodigo_dato(evaluacionesbonificaciones.getcodigo_dato());	
		evaluacionesbonificacionesAsignar.setnombre_completo(evaluacionesbonificaciones.getnombre_completo());	
		evaluacionesbonificacionesAsignar.setsueldo(evaluacionesbonificaciones.getsueldo());	
		evaluacionesbonificacionesAsignar.setvalor_conocimiento(evaluacionesbonificaciones.getvalor_conocimiento());	
		evaluacionesbonificacionesAsignar.setvalor_eficiencia(evaluacionesbonificaciones.getvalor_eficiencia());	
		evaluacionesbonificacionesAsignar.setvalor_obtenido(evaluacionesbonificaciones.getvalor_obtenido());	
		evaluacionesbonificacionesAsignar.setvalor_peso(evaluacionesbonificaciones.getvalor_peso());	
		evaluacionesbonificacionesAsignar.setbonificacion(evaluacionesbonificaciones.getbonificacion());	
	}
	
	public static void inicializarEvaluacionesBonificaciones(EvaluacionesBonificaciones evaluacionesbonificaciones) throws Exception {
		try {
				evaluacionesbonificaciones.setId(0L);	
					
				evaluacionesbonificaciones.setcodigo_dato("");	
				evaluacionesbonificaciones.setnombre_completo("");	
				evaluacionesbonificaciones.setsueldo(0.0);	
				evaluacionesbonificaciones.setvalor_conocimiento(0.0);	
				evaluacionesbonificaciones.setvalor_eficiencia(0.0);	
				evaluacionesbonificaciones.setvalor_obtenido(0.0);	
				evaluacionesbonificaciones.setvalor_peso(0.0);	
				evaluacionesbonificaciones.setbonificacion(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEvaluacionesBonificaciones(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesBonificacionesConstantesFunciones.LABEL_IDTIPOCALIFICACIONEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesBonificacionesConstantesFunciones.LABEL_VERIFICADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesBonificacionesConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesBonificacionesConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesBonificacionesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesBonificacionesConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesBonificacionesConstantesFunciones.LABEL_CODIGODATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesBonificacionesConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesBonificacionesConstantesFunciones.LABEL_SUELDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesBonificacionesConstantesFunciones.LABEL_VALORCONOCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesBonificacionesConstantesFunciones.LABEL_VALOREFICIENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesBonificacionesConstantesFunciones.LABEL_VALOROBTENIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesBonificacionesConstantesFunciones.LABEL_VALORPESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionesBonificacionesConstantesFunciones.LABEL_BONIFICACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEvaluacionesBonificaciones(String sTipo,Row row,Workbook workbook,EvaluacionesBonificaciones evaluacionesbonificaciones,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesbonificaciones.gettipocalificacionempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(evaluacionesbonificaciones.getverificado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesbonificaciones.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesbonificaciones.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesbonificaciones.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesbonificaciones.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesbonificaciones.getcodigo_dato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesbonificaciones.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesbonificaciones.getsueldo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesbonificaciones.getvalor_conocimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesbonificaciones.getvalor_eficiencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesbonificaciones.getvalor_obtenido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesbonificaciones.getvalor_peso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionesbonificaciones.getbonificacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEvaluacionesBonificaciones="";
	
	public String getsFinalQueryEvaluacionesBonificaciones() {
		return this.sFinalQueryEvaluacionesBonificaciones;
	}
	
	public void setsFinalQueryEvaluacionesBonificaciones(String sFinalQueryEvaluacionesBonificaciones) {
		this.sFinalQueryEvaluacionesBonificaciones= sFinalQueryEvaluacionesBonificaciones;
	}
	
	public Border resaltarSeleccionarEvaluacionesBonificaciones=null;
	
	public Border setResaltarSeleccionarEvaluacionesBonificaciones(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesBonificacionesBeanSwingJInternalFrame evaluacionesbonificacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//evaluacionesbonificacionesBeanSwingJInternalFrame.jTtoolBarEvaluacionesBonificaciones.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEvaluacionesBonificaciones= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEvaluacionesBonificaciones() {
		return this.resaltarSeleccionarEvaluacionesBonificaciones;
	}
	
	public void setResaltarSeleccionarEvaluacionesBonificaciones(Border borderResaltarSeleccionarEvaluacionesBonificaciones) {
		this.resaltarSeleccionarEvaluacionesBonificaciones= borderResaltarSeleccionarEvaluacionesBonificaciones;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEvaluacionesBonificaciones=null;
	public Boolean mostraridEvaluacionesBonificaciones=true;
	public Boolean activaridEvaluacionesBonificaciones=true;

	public Border resaltarid_tipo_calificacion_empleadoEvaluacionesBonificaciones=null;
	public Boolean mostrarid_tipo_calificacion_empleadoEvaluacionesBonificaciones=true;
	public Boolean activarid_tipo_calificacion_empleadoEvaluacionesBonificaciones=true;
	public Boolean cargarid_tipo_calificacion_empleadoEvaluacionesBonificaciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_calificacion_empleadoEvaluacionesBonificaciones=false;//ConEventDepend=true

	public Border resaltarverificadoEvaluacionesBonificaciones=null;
	public Boolean mostrarverificadoEvaluacionesBonificaciones=true;
	public Boolean activarverificadoEvaluacionesBonificaciones=true;

	public Border resaltarid_estructuraEvaluacionesBonificaciones=null;
	public Boolean mostrarid_estructuraEvaluacionesBonificaciones=true;
	public Boolean activarid_estructuraEvaluacionesBonificaciones=true;
	public Boolean cargarid_estructuraEvaluacionesBonificaciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraEvaluacionesBonificaciones=false;//ConEventDepend=true

	public Border resaltarcodigoEvaluacionesBonificaciones=null;
	public Boolean mostrarcodigoEvaluacionesBonificaciones=true;
	public Boolean activarcodigoEvaluacionesBonificaciones=true;

	public Border resaltarid_empresaEvaluacionesBonificaciones=null;
	public Boolean mostrarid_empresaEvaluacionesBonificaciones=true;
	public Boolean activarid_empresaEvaluacionesBonificaciones=true;
	public Boolean cargarid_empresaEvaluacionesBonificaciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEvaluacionesBonificaciones=false;//ConEventDepend=true

	public Border resaltarid_sucursalEvaluacionesBonificaciones=null;
	public Boolean mostrarid_sucursalEvaluacionesBonificaciones=true;
	public Boolean activarid_sucursalEvaluacionesBonificaciones=true;
	public Boolean cargarid_sucursalEvaluacionesBonificaciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalEvaluacionesBonificaciones=false;//ConEventDepend=true

	public Border resaltarcodigo_datoEvaluacionesBonificaciones=null;
	public Boolean mostrarcodigo_datoEvaluacionesBonificaciones=true;
	public Boolean activarcodigo_datoEvaluacionesBonificaciones=true;

	public Border resaltarnombre_completoEvaluacionesBonificaciones=null;
	public Boolean mostrarnombre_completoEvaluacionesBonificaciones=true;
	public Boolean activarnombre_completoEvaluacionesBonificaciones=true;

	public Border resaltarsueldoEvaluacionesBonificaciones=null;
	public Boolean mostrarsueldoEvaluacionesBonificaciones=true;
	public Boolean activarsueldoEvaluacionesBonificaciones=true;

	public Border resaltarvalor_conocimientoEvaluacionesBonificaciones=null;
	public Boolean mostrarvalor_conocimientoEvaluacionesBonificaciones=true;
	public Boolean activarvalor_conocimientoEvaluacionesBonificaciones=true;

	public Border resaltarvalor_eficienciaEvaluacionesBonificaciones=null;
	public Boolean mostrarvalor_eficienciaEvaluacionesBonificaciones=true;
	public Boolean activarvalor_eficienciaEvaluacionesBonificaciones=true;

	public Border resaltarvalor_obtenidoEvaluacionesBonificaciones=null;
	public Boolean mostrarvalor_obtenidoEvaluacionesBonificaciones=true;
	public Boolean activarvalor_obtenidoEvaluacionesBonificaciones=true;

	public Border resaltarvalor_pesoEvaluacionesBonificaciones=null;
	public Boolean mostrarvalor_pesoEvaluacionesBonificaciones=true;
	public Boolean activarvalor_pesoEvaluacionesBonificaciones=true;

	public Border resaltarbonificacionEvaluacionesBonificaciones=null;
	public Boolean mostrarbonificacionEvaluacionesBonificaciones=true;
	public Boolean activarbonificacionEvaluacionesBonificaciones=true;

	
	

	public Border setResaltaridEvaluacionesBonificaciones(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesBonificacionesBeanSwingJInternalFrame evaluacionesbonificacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesbonificacionesBeanSwingJInternalFrame.jTtoolBarEvaluacionesBonificaciones.setBorder(borderResaltar);
		
		this.resaltaridEvaluacionesBonificaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEvaluacionesBonificaciones() {
		return this.resaltaridEvaluacionesBonificaciones;
	}

	public void setResaltaridEvaluacionesBonificaciones(Border borderResaltar) {
		this.resaltaridEvaluacionesBonificaciones= borderResaltar;
	}

	public Boolean getMostraridEvaluacionesBonificaciones() {
		return this.mostraridEvaluacionesBonificaciones;
	}

	public void setMostraridEvaluacionesBonificaciones(Boolean mostraridEvaluacionesBonificaciones) {
		this.mostraridEvaluacionesBonificaciones= mostraridEvaluacionesBonificaciones;
	}

	public Boolean getActivaridEvaluacionesBonificaciones() {
		return this.activaridEvaluacionesBonificaciones;
	}

	public void setActivaridEvaluacionesBonificaciones(Boolean activaridEvaluacionesBonificaciones) {
		this.activaridEvaluacionesBonificaciones= activaridEvaluacionesBonificaciones;
	}

	public Border setResaltarid_tipo_calificacion_empleadoEvaluacionesBonificaciones(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesBonificacionesBeanSwingJInternalFrame evaluacionesbonificacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesbonificacionesBeanSwingJInternalFrame.jTtoolBarEvaluacionesBonificaciones.setBorder(borderResaltar);
		
		this.resaltarid_tipo_calificacion_empleadoEvaluacionesBonificaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_calificacion_empleadoEvaluacionesBonificaciones() {
		return this.resaltarid_tipo_calificacion_empleadoEvaluacionesBonificaciones;
	}

	public void setResaltarid_tipo_calificacion_empleadoEvaluacionesBonificaciones(Border borderResaltar) {
		this.resaltarid_tipo_calificacion_empleadoEvaluacionesBonificaciones= borderResaltar;
	}

	public Boolean getMostrarid_tipo_calificacion_empleadoEvaluacionesBonificaciones() {
		return this.mostrarid_tipo_calificacion_empleadoEvaluacionesBonificaciones;
	}

	public void setMostrarid_tipo_calificacion_empleadoEvaluacionesBonificaciones(Boolean mostrarid_tipo_calificacion_empleadoEvaluacionesBonificaciones) {
		this.mostrarid_tipo_calificacion_empleadoEvaluacionesBonificaciones= mostrarid_tipo_calificacion_empleadoEvaluacionesBonificaciones;
	}

	public Boolean getActivarid_tipo_calificacion_empleadoEvaluacionesBonificaciones() {
		return this.activarid_tipo_calificacion_empleadoEvaluacionesBonificaciones;
	}

	public void setActivarid_tipo_calificacion_empleadoEvaluacionesBonificaciones(Boolean activarid_tipo_calificacion_empleadoEvaluacionesBonificaciones) {
		this.activarid_tipo_calificacion_empleadoEvaluacionesBonificaciones= activarid_tipo_calificacion_empleadoEvaluacionesBonificaciones;
	}

	public Boolean getCargarid_tipo_calificacion_empleadoEvaluacionesBonificaciones() {
		return this.cargarid_tipo_calificacion_empleadoEvaluacionesBonificaciones;
	}

	public void setCargarid_tipo_calificacion_empleadoEvaluacionesBonificaciones(Boolean cargarid_tipo_calificacion_empleadoEvaluacionesBonificaciones) {
		this.cargarid_tipo_calificacion_empleadoEvaluacionesBonificaciones= cargarid_tipo_calificacion_empleadoEvaluacionesBonificaciones;
	}

	public Border setResaltarverificadoEvaluacionesBonificaciones(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesBonificacionesBeanSwingJInternalFrame evaluacionesbonificacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesbonificacionesBeanSwingJInternalFrame.jTtoolBarEvaluacionesBonificaciones.setBorder(borderResaltar);
		
		this.resaltarverificadoEvaluacionesBonificaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarverificadoEvaluacionesBonificaciones() {
		return this.resaltarverificadoEvaluacionesBonificaciones;
	}

	public void setResaltarverificadoEvaluacionesBonificaciones(Border borderResaltar) {
		this.resaltarverificadoEvaluacionesBonificaciones= borderResaltar;
	}

	public Boolean getMostrarverificadoEvaluacionesBonificaciones() {
		return this.mostrarverificadoEvaluacionesBonificaciones;
	}

	public void setMostrarverificadoEvaluacionesBonificaciones(Boolean mostrarverificadoEvaluacionesBonificaciones) {
		this.mostrarverificadoEvaluacionesBonificaciones= mostrarverificadoEvaluacionesBonificaciones;
	}

	public Boolean getActivarverificadoEvaluacionesBonificaciones() {
		return this.activarverificadoEvaluacionesBonificaciones;
	}

	public void setActivarverificadoEvaluacionesBonificaciones(Boolean activarverificadoEvaluacionesBonificaciones) {
		this.activarverificadoEvaluacionesBonificaciones= activarverificadoEvaluacionesBonificaciones;
	}

	public Border setResaltarid_estructuraEvaluacionesBonificaciones(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesBonificacionesBeanSwingJInternalFrame evaluacionesbonificacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesbonificacionesBeanSwingJInternalFrame.jTtoolBarEvaluacionesBonificaciones.setBorder(borderResaltar);
		
		this.resaltarid_estructuraEvaluacionesBonificaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraEvaluacionesBonificaciones() {
		return this.resaltarid_estructuraEvaluacionesBonificaciones;
	}

	public void setResaltarid_estructuraEvaluacionesBonificaciones(Border borderResaltar) {
		this.resaltarid_estructuraEvaluacionesBonificaciones= borderResaltar;
	}

	public Boolean getMostrarid_estructuraEvaluacionesBonificaciones() {
		return this.mostrarid_estructuraEvaluacionesBonificaciones;
	}

	public void setMostrarid_estructuraEvaluacionesBonificaciones(Boolean mostrarid_estructuraEvaluacionesBonificaciones) {
		this.mostrarid_estructuraEvaluacionesBonificaciones= mostrarid_estructuraEvaluacionesBonificaciones;
	}

	public Boolean getActivarid_estructuraEvaluacionesBonificaciones() {
		return this.activarid_estructuraEvaluacionesBonificaciones;
	}

	public void setActivarid_estructuraEvaluacionesBonificaciones(Boolean activarid_estructuraEvaluacionesBonificaciones) {
		this.activarid_estructuraEvaluacionesBonificaciones= activarid_estructuraEvaluacionesBonificaciones;
	}

	public Boolean getCargarid_estructuraEvaluacionesBonificaciones() {
		return this.cargarid_estructuraEvaluacionesBonificaciones;
	}

	public void setCargarid_estructuraEvaluacionesBonificaciones(Boolean cargarid_estructuraEvaluacionesBonificaciones) {
		this.cargarid_estructuraEvaluacionesBonificaciones= cargarid_estructuraEvaluacionesBonificaciones;
	}

	public Border setResaltarcodigoEvaluacionesBonificaciones(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesBonificacionesBeanSwingJInternalFrame evaluacionesbonificacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesbonificacionesBeanSwingJInternalFrame.jTtoolBarEvaluacionesBonificaciones.setBorder(borderResaltar);
		
		this.resaltarcodigoEvaluacionesBonificaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEvaluacionesBonificaciones() {
		return this.resaltarcodigoEvaluacionesBonificaciones;
	}

	public void setResaltarcodigoEvaluacionesBonificaciones(Border borderResaltar) {
		this.resaltarcodigoEvaluacionesBonificaciones= borderResaltar;
	}

	public Boolean getMostrarcodigoEvaluacionesBonificaciones() {
		return this.mostrarcodigoEvaluacionesBonificaciones;
	}

	public void setMostrarcodigoEvaluacionesBonificaciones(Boolean mostrarcodigoEvaluacionesBonificaciones) {
		this.mostrarcodigoEvaluacionesBonificaciones= mostrarcodigoEvaluacionesBonificaciones;
	}

	public Boolean getActivarcodigoEvaluacionesBonificaciones() {
		return this.activarcodigoEvaluacionesBonificaciones;
	}

	public void setActivarcodigoEvaluacionesBonificaciones(Boolean activarcodigoEvaluacionesBonificaciones) {
		this.activarcodigoEvaluacionesBonificaciones= activarcodigoEvaluacionesBonificaciones;
	}

	public Border setResaltarid_empresaEvaluacionesBonificaciones(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesBonificacionesBeanSwingJInternalFrame evaluacionesbonificacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesbonificacionesBeanSwingJInternalFrame.jTtoolBarEvaluacionesBonificaciones.setBorder(borderResaltar);
		
		this.resaltarid_empresaEvaluacionesBonificaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEvaluacionesBonificaciones() {
		return this.resaltarid_empresaEvaluacionesBonificaciones;
	}

	public void setResaltarid_empresaEvaluacionesBonificaciones(Border borderResaltar) {
		this.resaltarid_empresaEvaluacionesBonificaciones= borderResaltar;
	}

	public Boolean getMostrarid_empresaEvaluacionesBonificaciones() {
		return this.mostrarid_empresaEvaluacionesBonificaciones;
	}

	public void setMostrarid_empresaEvaluacionesBonificaciones(Boolean mostrarid_empresaEvaluacionesBonificaciones) {
		this.mostrarid_empresaEvaluacionesBonificaciones= mostrarid_empresaEvaluacionesBonificaciones;
	}

	public Boolean getActivarid_empresaEvaluacionesBonificaciones() {
		return this.activarid_empresaEvaluacionesBonificaciones;
	}

	public void setActivarid_empresaEvaluacionesBonificaciones(Boolean activarid_empresaEvaluacionesBonificaciones) {
		this.activarid_empresaEvaluacionesBonificaciones= activarid_empresaEvaluacionesBonificaciones;
	}

	public Boolean getCargarid_empresaEvaluacionesBonificaciones() {
		return this.cargarid_empresaEvaluacionesBonificaciones;
	}

	public void setCargarid_empresaEvaluacionesBonificaciones(Boolean cargarid_empresaEvaluacionesBonificaciones) {
		this.cargarid_empresaEvaluacionesBonificaciones= cargarid_empresaEvaluacionesBonificaciones;
	}

	public Border setResaltarid_sucursalEvaluacionesBonificaciones(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesBonificacionesBeanSwingJInternalFrame evaluacionesbonificacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesbonificacionesBeanSwingJInternalFrame.jTtoolBarEvaluacionesBonificaciones.setBorder(borderResaltar);
		
		this.resaltarid_sucursalEvaluacionesBonificaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalEvaluacionesBonificaciones() {
		return this.resaltarid_sucursalEvaluacionesBonificaciones;
	}

	public void setResaltarid_sucursalEvaluacionesBonificaciones(Border borderResaltar) {
		this.resaltarid_sucursalEvaluacionesBonificaciones= borderResaltar;
	}

	public Boolean getMostrarid_sucursalEvaluacionesBonificaciones() {
		return this.mostrarid_sucursalEvaluacionesBonificaciones;
	}

	public void setMostrarid_sucursalEvaluacionesBonificaciones(Boolean mostrarid_sucursalEvaluacionesBonificaciones) {
		this.mostrarid_sucursalEvaluacionesBonificaciones= mostrarid_sucursalEvaluacionesBonificaciones;
	}

	public Boolean getActivarid_sucursalEvaluacionesBonificaciones() {
		return this.activarid_sucursalEvaluacionesBonificaciones;
	}

	public void setActivarid_sucursalEvaluacionesBonificaciones(Boolean activarid_sucursalEvaluacionesBonificaciones) {
		this.activarid_sucursalEvaluacionesBonificaciones= activarid_sucursalEvaluacionesBonificaciones;
	}

	public Boolean getCargarid_sucursalEvaluacionesBonificaciones() {
		return this.cargarid_sucursalEvaluacionesBonificaciones;
	}

	public void setCargarid_sucursalEvaluacionesBonificaciones(Boolean cargarid_sucursalEvaluacionesBonificaciones) {
		this.cargarid_sucursalEvaluacionesBonificaciones= cargarid_sucursalEvaluacionesBonificaciones;
	}

	public Border setResaltarcodigo_datoEvaluacionesBonificaciones(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesBonificacionesBeanSwingJInternalFrame evaluacionesbonificacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesbonificacionesBeanSwingJInternalFrame.jTtoolBarEvaluacionesBonificaciones.setBorder(borderResaltar);
		
		this.resaltarcodigo_datoEvaluacionesBonificaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_datoEvaluacionesBonificaciones() {
		return this.resaltarcodigo_datoEvaluacionesBonificaciones;
	}

	public void setResaltarcodigo_datoEvaluacionesBonificaciones(Border borderResaltar) {
		this.resaltarcodigo_datoEvaluacionesBonificaciones= borderResaltar;
	}

	public Boolean getMostrarcodigo_datoEvaluacionesBonificaciones() {
		return this.mostrarcodigo_datoEvaluacionesBonificaciones;
	}

	public void setMostrarcodigo_datoEvaluacionesBonificaciones(Boolean mostrarcodigo_datoEvaluacionesBonificaciones) {
		this.mostrarcodigo_datoEvaluacionesBonificaciones= mostrarcodigo_datoEvaluacionesBonificaciones;
	}

	public Boolean getActivarcodigo_datoEvaluacionesBonificaciones() {
		return this.activarcodigo_datoEvaluacionesBonificaciones;
	}

	public void setActivarcodigo_datoEvaluacionesBonificaciones(Boolean activarcodigo_datoEvaluacionesBonificaciones) {
		this.activarcodigo_datoEvaluacionesBonificaciones= activarcodigo_datoEvaluacionesBonificaciones;
	}

	public Border setResaltarnombre_completoEvaluacionesBonificaciones(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesBonificacionesBeanSwingJInternalFrame evaluacionesbonificacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesbonificacionesBeanSwingJInternalFrame.jTtoolBarEvaluacionesBonificaciones.setBorder(borderResaltar);
		
		this.resaltarnombre_completoEvaluacionesBonificaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoEvaluacionesBonificaciones() {
		return this.resaltarnombre_completoEvaluacionesBonificaciones;
	}

	public void setResaltarnombre_completoEvaluacionesBonificaciones(Border borderResaltar) {
		this.resaltarnombre_completoEvaluacionesBonificaciones= borderResaltar;
	}

	public Boolean getMostrarnombre_completoEvaluacionesBonificaciones() {
		return this.mostrarnombre_completoEvaluacionesBonificaciones;
	}

	public void setMostrarnombre_completoEvaluacionesBonificaciones(Boolean mostrarnombre_completoEvaluacionesBonificaciones) {
		this.mostrarnombre_completoEvaluacionesBonificaciones= mostrarnombre_completoEvaluacionesBonificaciones;
	}

	public Boolean getActivarnombre_completoEvaluacionesBonificaciones() {
		return this.activarnombre_completoEvaluacionesBonificaciones;
	}

	public void setActivarnombre_completoEvaluacionesBonificaciones(Boolean activarnombre_completoEvaluacionesBonificaciones) {
		this.activarnombre_completoEvaluacionesBonificaciones= activarnombre_completoEvaluacionesBonificaciones;
	}

	public Border setResaltarsueldoEvaluacionesBonificaciones(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesBonificacionesBeanSwingJInternalFrame evaluacionesbonificacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesbonificacionesBeanSwingJInternalFrame.jTtoolBarEvaluacionesBonificaciones.setBorder(borderResaltar);
		
		this.resaltarsueldoEvaluacionesBonificaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsueldoEvaluacionesBonificaciones() {
		return this.resaltarsueldoEvaluacionesBonificaciones;
	}

	public void setResaltarsueldoEvaluacionesBonificaciones(Border borderResaltar) {
		this.resaltarsueldoEvaluacionesBonificaciones= borderResaltar;
	}

	public Boolean getMostrarsueldoEvaluacionesBonificaciones() {
		return this.mostrarsueldoEvaluacionesBonificaciones;
	}

	public void setMostrarsueldoEvaluacionesBonificaciones(Boolean mostrarsueldoEvaluacionesBonificaciones) {
		this.mostrarsueldoEvaluacionesBonificaciones= mostrarsueldoEvaluacionesBonificaciones;
	}

	public Boolean getActivarsueldoEvaluacionesBonificaciones() {
		return this.activarsueldoEvaluacionesBonificaciones;
	}

	public void setActivarsueldoEvaluacionesBonificaciones(Boolean activarsueldoEvaluacionesBonificaciones) {
		this.activarsueldoEvaluacionesBonificaciones= activarsueldoEvaluacionesBonificaciones;
	}

	public Border setResaltarvalor_conocimientoEvaluacionesBonificaciones(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesBonificacionesBeanSwingJInternalFrame evaluacionesbonificacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesbonificacionesBeanSwingJInternalFrame.jTtoolBarEvaluacionesBonificaciones.setBorder(borderResaltar);
		
		this.resaltarvalor_conocimientoEvaluacionesBonificaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_conocimientoEvaluacionesBonificaciones() {
		return this.resaltarvalor_conocimientoEvaluacionesBonificaciones;
	}

	public void setResaltarvalor_conocimientoEvaluacionesBonificaciones(Border borderResaltar) {
		this.resaltarvalor_conocimientoEvaluacionesBonificaciones= borderResaltar;
	}

	public Boolean getMostrarvalor_conocimientoEvaluacionesBonificaciones() {
		return this.mostrarvalor_conocimientoEvaluacionesBonificaciones;
	}

	public void setMostrarvalor_conocimientoEvaluacionesBonificaciones(Boolean mostrarvalor_conocimientoEvaluacionesBonificaciones) {
		this.mostrarvalor_conocimientoEvaluacionesBonificaciones= mostrarvalor_conocimientoEvaluacionesBonificaciones;
	}

	public Boolean getActivarvalor_conocimientoEvaluacionesBonificaciones() {
		return this.activarvalor_conocimientoEvaluacionesBonificaciones;
	}

	public void setActivarvalor_conocimientoEvaluacionesBonificaciones(Boolean activarvalor_conocimientoEvaluacionesBonificaciones) {
		this.activarvalor_conocimientoEvaluacionesBonificaciones= activarvalor_conocimientoEvaluacionesBonificaciones;
	}

	public Border setResaltarvalor_eficienciaEvaluacionesBonificaciones(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesBonificacionesBeanSwingJInternalFrame evaluacionesbonificacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesbonificacionesBeanSwingJInternalFrame.jTtoolBarEvaluacionesBonificaciones.setBorder(borderResaltar);
		
		this.resaltarvalor_eficienciaEvaluacionesBonificaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_eficienciaEvaluacionesBonificaciones() {
		return this.resaltarvalor_eficienciaEvaluacionesBonificaciones;
	}

	public void setResaltarvalor_eficienciaEvaluacionesBonificaciones(Border borderResaltar) {
		this.resaltarvalor_eficienciaEvaluacionesBonificaciones= borderResaltar;
	}

	public Boolean getMostrarvalor_eficienciaEvaluacionesBonificaciones() {
		return this.mostrarvalor_eficienciaEvaluacionesBonificaciones;
	}

	public void setMostrarvalor_eficienciaEvaluacionesBonificaciones(Boolean mostrarvalor_eficienciaEvaluacionesBonificaciones) {
		this.mostrarvalor_eficienciaEvaluacionesBonificaciones= mostrarvalor_eficienciaEvaluacionesBonificaciones;
	}

	public Boolean getActivarvalor_eficienciaEvaluacionesBonificaciones() {
		return this.activarvalor_eficienciaEvaluacionesBonificaciones;
	}

	public void setActivarvalor_eficienciaEvaluacionesBonificaciones(Boolean activarvalor_eficienciaEvaluacionesBonificaciones) {
		this.activarvalor_eficienciaEvaluacionesBonificaciones= activarvalor_eficienciaEvaluacionesBonificaciones;
	}

	public Border setResaltarvalor_obtenidoEvaluacionesBonificaciones(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesBonificacionesBeanSwingJInternalFrame evaluacionesbonificacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesbonificacionesBeanSwingJInternalFrame.jTtoolBarEvaluacionesBonificaciones.setBorder(borderResaltar);
		
		this.resaltarvalor_obtenidoEvaluacionesBonificaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_obtenidoEvaluacionesBonificaciones() {
		return this.resaltarvalor_obtenidoEvaluacionesBonificaciones;
	}

	public void setResaltarvalor_obtenidoEvaluacionesBonificaciones(Border borderResaltar) {
		this.resaltarvalor_obtenidoEvaluacionesBonificaciones= borderResaltar;
	}

	public Boolean getMostrarvalor_obtenidoEvaluacionesBonificaciones() {
		return this.mostrarvalor_obtenidoEvaluacionesBonificaciones;
	}

	public void setMostrarvalor_obtenidoEvaluacionesBonificaciones(Boolean mostrarvalor_obtenidoEvaluacionesBonificaciones) {
		this.mostrarvalor_obtenidoEvaluacionesBonificaciones= mostrarvalor_obtenidoEvaluacionesBonificaciones;
	}

	public Boolean getActivarvalor_obtenidoEvaluacionesBonificaciones() {
		return this.activarvalor_obtenidoEvaluacionesBonificaciones;
	}

	public void setActivarvalor_obtenidoEvaluacionesBonificaciones(Boolean activarvalor_obtenidoEvaluacionesBonificaciones) {
		this.activarvalor_obtenidoEvaluacionesBonificaciones= activarvalor_obtenidoEvaluacionesBonificaciones;
	}

	public Border setResaltarvalor_pesoEvaluacionesBonificaciones(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesBonificacionesBeanSwingJInternalFrame evaluacionesbonificacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesbonificacionesBeanSwingJInternalFrame.jTtoolBarEvaluacionesBonificaciones.setBorder(borderResaltar);
		
		this.resaltarvalor_pesoEvaluacionesBonificaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_pesoEvaluacionesBonificaciones() {
		return this.resaltarvalor_pesoEvaluacionesBonificaciones;
	}

	public void setResaltarvalor_pesoEvaluacionesBonificaciones(Border borderResaltar) {
		this.resaltarvalor_pesoEvaluacionesBonificaciones= borderResaltar;
	}

	public Boolean getMostrarvalor_pesoEvaluacionesBonificaciones() {
		return this.mostrarvalor_pesoEvaluacionesBonificaciones;
	}

	public void setMostrarvalor_pesoEvaluacionesBonificaciones(Boolean mostrarvalor_pesoEvaluacionesBonificaciones) {
		this.mostrarvalor_pesoEvaluacionesBonificaciones= mostrarvalor_pesoEvaluacionesBonificaciones;
	}

	public Boolean getActivarvalor_pesoEvaluacionesBonificaciones() {
		return this.activarvalor_pesoEvaluacionesBonificaciones;
	}

	public void setActivarvalor_pesoEvaluacionesBonificaciones(Boolean activarvalor_pesoEvaluacionesBonificaciones) {
		this.activarvalor_pesoEvaluacionesBonificaciones= activarvalor_pesoEvaluacionesBonificaciones;
	}

	public Border setResaltarbonificacionEvaluacionesBonificaciones(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesBonificacionesBeanSwingJInternalFrame evaluacionesbonificacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionesbonificacionesBeanSwingJInternalFrame.jTtoolBarEvaluacionesBonificaciones.setBorder(borderResaltar);
		
		this.resaltarbonificacionEvaluacionesBonificaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbonificacionEvaluacionesBonificaciones() {
		return this.resaltarbonificacionEvaluacionesBonificaciones;
	}

	public void setResaltarbonificacionEvaluacionesBonificaciones(Border borderResaltar) {
		this.resaltarbonificacionEvaluacionesBonificaciones= borderResaltar;
	}

	public Boolean getMostrarbonificacionEvaluacionesBonificaciones() {
		return this.mostrarbonificacionEvaluacionesBonificaciones;
	}

	public void setMostrarbonificacionEvaluacionesBonificaciones(Boolean mostrarbonificacionEvaluacionesBonificaciones) {
		this.mostrarbonificacionEvaluacionesBonificaciones= mostrarbonificacionEvaluacionesBonificaciones;
	}

	public Boolean getActivarbonificacionEvaluacionesBonificaciones() {
		return this.activarbonificacionEvaluacionesBonificaciones;
	}

	public void setActivarbonificacionEvaluacionesBonificaciones(Boolean activarbonificacionEvaluacionesBonificaciones) {
		this.activarbonificacionEvaluacionesBonificaciones= activarbonificacionEvaluacionesBonificaciones;
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
		
		
		this.setMostraridEvaluacionesBonificaciones(esInicial);
		this.setMostrarid_tipo_calificacion_empleadoEvaluacionesBonificaciones(esInicial);
		this.setMostrarverificadoEvaluacionesBonificaciones(esInicial);
		this.setMostrarid_estructuraEvaluacionesBonificaciones(esInicial);
		this.setMostrarcodigoEvaluacionesBonificaciones(esInicial);
		this.setMostrarid_empresaEvaluacionesBonificaciones(esInicial);
		this.setMostrarid_sucursalEvaluacionesBonificaciones(esInicial);
		this.setMostrarcodigo_datoEvaluacionesBonificaciones(esInicial);
		this.setMostrarnombre_completoEvaluacionesBonificaciones(esInicial);
		this.setMostrarsueldoEvaluacionesBonificaciones(esInicial);
		this.setMostrarvalor_conocimientoEvaluacionesBonificaciones(esInicial);
		this.setMostrarvalor_eficienciaEvaluacionesBonificaciones(esInicial);
		this.setMostrarvalor_obtenidoEvaluacionesBonificaciones(esInicial);
		this.setMostrarvalor_pesoEvaluacionesBonificaciones(esInicial);
		this.setMostrarbonificacionEvaluacionesBonificaciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.ID)) {
				this.setMostraridEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO)) {
				this.setMostrarid_tipo_calificacion_empleadoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.VERIFICADO)) {
				this.setMostrarverificadoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.CODIGODATO)) {
				this.setMostrarcodigo_datoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.SUELDO)) {
				this.setMostrarsueldoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.VALORCONOCIMIENTO)) {
				this.setMostrarvalor_conocimientoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.VALOREFICIENCIA)) {
				this.setMostrarvalor_eficienciaEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.VALOROBTENIDO)) {
				this.setMostrarvalor_obtenidoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.VALORPESO)) {
				this.setMostrarvalor_pesoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.BONIFICACION)) {
				this.setMostrarbonificacionEvaluacionesBonificaciones(esAsigna);
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
		
		
		this.setActivaridEvaluacionesBonificaciones(esInicial);
		this.setActivarid_tipo_calificacion_empleadoEvaluacionesBonificaciones(esInicial);
		this.setActivarverificadoEvaluacionesBonificaciones(esInicial);
		this.setActivarid_estructuraEvaluacionesBonificaciones(esInicial);
		this.setActivarcodigoEvaluacionesBonificaciones(esInicial);
		this.setActivarid_empresaEvaluacionesBonificaciones(esInicial);
		this.setActivarid_sucursalEvaluacionesBonificaciones(esInicial);
		this.setActivarcodigo_datoEvaluacionesBonificaciones(esInicial);
		this.setActivarnombre_completoEvaluacionesBonificaciones(esInicial);
		this.setActivarsueldoEvaluacionesBonificaciones(esInicial);
		this.setActivarvalor_conocimientoEvaluacionesBonificaciones(esInicial);
		this.setActivarvalor_eficienciaEvaluacionesBonificaciones(esInicial);
		this.setActivarvalor_obtenidoEvaluacionesBonificaciones(esInicial);
		this.setActivarvalor_pesoEvaluacionesBonificaciones(esInicial);
		this.setActivarbonificacionEvaluacionesBonificaciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.ID)) {
				this.setActivaridEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO)) {
				this.setActivarid_tipo_calificacion_empleadoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.VERIFICADO)) {
				this.setActivarverificadoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.CODIGODATO)) {
				this.setActivarcodigo_datoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.SUELDO)) {
				this.setActivarsueldoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.VALORCONOCIMIENTO)) {
				this.setActivarvalor_conocimientoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.VALOREFICIENCIA)) {
				this.setActivarvalor_eficienciaEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.VALOROBTENIDO)) {
				this.setActivarvalor_obtenidoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.VALORPESO)) {
				this.setActivarvalor_pesoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.BONIFICACION)) {
				this.setActivarbonificacionEvaluacionesBonificaciones(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EvaluacionesBonificacionesBeanSwingJInternalFrame evaluacionesbonificacionesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEvaluacionesBonificaciones(esInicial);
		this.setResaltarid_tipo_calificacion_empleadoEvaluacionesBonificaciones(esInicial);
		this.setResaltarverificadoEvaluacionesBonificaciones(esInicial);
		this.setResaltarid_estructuraEvaluacionesBonificaciones(esInicial);
		this.setResaltarcodigoEvaluacionesBonificaciones(esInicial);
		this.setResaltarid_empresaEvaluacionesBonificaciones(esInicial);
		this.setResaltarid_sucursalEvaluacionesBonificaciones(esInicial);
		this.setResaltarcodigo_datoEvaluacionesBonificaciones(esInicial);
		this.setResaltarnombre_completoEvaluacionesBonificaciones(esInicial);
		this.setResaltarsueldoEvaluacionesBonificaciones(esInicial);
		this.setResaltarvalor_conocimientoEvaluacionesBonificaciones(esInicial);
		this.setResaltarvalor_eficienciaEvaluacionesBonificaciones(esInicial);
		this.setResaltarvalor_obtenidoEvaluacionesBonificaciones(esInicial);
		this.setResaltarvalor_pesoEvaluacionesBonificaciones(esInicial);
		this.setResaltarbonificacionEvaluacionesBonificaciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.ID)) {
				this.setResaltaridEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO)) {
				this.setResaltarid_tipo_calificacion_empleadoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.VERIFICADO)) {
				this.setResaltarverificadoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.CODIGODATO)) {
				this.setResaltarcodigo_datoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.SUELDO)) {
				this.setResaltarsueldoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.VALORCONOCIMIENTO)) {
				this.setResaltarvalor_conocimientoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.VALOREFICIENCIA)) {
				this.setResaltarvalor_eficienciaEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.VALOROBTENIDO)) {
				this.setResaltarvalor_obtenidoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.VALORPESO)) {
				this.setResaltarvalor_pesoEvaluacionesBonificaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionesBonificacionesConstantesFunciones.BONIFICACION)) {
				this.setResaltarbonificacionEvaluacionesBonificaciones(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EvaluacionesBonificacionesBeanSwingJInternalFrame evaluacionesbonificacionesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaEvaluacionesBonificacionesEvaluacionesBonificaciones=true;

	public Boolean getMostrarBusquedaEvaluacionesBonificacionesEvaluacionesBonificaciones() {
		return this.mostrarBusquedaEvaluacionesBonificacionesEvaluacionesBonificaciones;
	}

	public void setMostrarBusquedaEvaluacionesBonificacionesEvaluacionesBonificaciones(Boolean visibilidadResaltar) {
		this.mostrarBusquedaEvaluacionesBonificacionesEvaluacionesBonificaciones= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaEvaluacionesBonificacionesEvaluacionesBonificaciones=true;

	public Boolean getActivarBusquedaEvaluacionesBonificacionesEvaluacionesBonificaciones() {
		return this.activarBusquedaEvaluacionesBonificacionesEvaluacionesBonificaciones;
	}

	public void setActivarBusquedaEvaluacionesBonificacionesEvaluacionesBonificaciones(Boolean habilitarResaltar) {
		this.activarBusquedaEvaluacionesBonificacionesEvaluacionesBonificaciones= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaEvaluacionesBonificacionesEvaluacionesBonificaciones=null;

	public Border getResaltarBusquedaEvaluacionesBonificacionesEvaluacionesBonificaciones() {
		return this.resaltarBusquedaEvaluacionesBonificacionesEvaluacionesBonificaciones;
	}

	public void setResaltarBusquedaEvaluacionesBonificacionesEvaluacionesBonificaciones(Border borderResaltar) {
		this.resaltarBusquedaEvaluacionesBonificacionesEvaluacionesBonificaciones= borderResaltar;
	}

	public void setResaltarBusquedaEvaluacionesBonificacionesEvaluacionesBonificaciones(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionesBonificacionesBeanSwingJInternalFrame evaluacionesbonificacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaEvaluacionesBonificacionesEvaluacionesBonificaciones= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}