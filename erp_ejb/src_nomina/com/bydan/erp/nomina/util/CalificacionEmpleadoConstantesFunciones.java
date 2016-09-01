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


import com.bydan.erp.nomina.util.CalificacionEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.CalificacionEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.CalificacionEmpleadoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


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
final public class CalificacionEmpleadoConstantesFunciones extends CalificacionEmpleadoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CalificacionEmpleado";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CalificacionEmpleado"+CalificacionEmpleadoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CalificacionEmpleadoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CalificacionEmpleadoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CalificacionEmpleadoConstantesFunciones.SCHEMA+"_"+CalificacionEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CalificacionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CalificacionEmpleadoConstantesFunciones.SCHEMA+"_"+CalificacionEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CalificacionEmpleadoConstantesFunciones.SCHEMA+"_"+CalificacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CalificacionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CalificacionEmpleadoConstantesFunciones.SCHEMA+"_"+CalificacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CalificacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CalificacionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CalificacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CalificacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CalificacionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CalificacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CalificacionEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CalificacionEmpleadoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CalificacionEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CalificacionEmpleadoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Calificacion Empleados";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Calificacion Empleado";
	public static final String SCLASSWEBTITULO_LOWER="Calificacion Empleado";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CalificacionEmpleado";
	public static final String OBJECTNAME="calificacionempleado";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="calificacion_empleado";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select calificacionempleado from "+CalificacionEmpleadoConstantesFunciones.SPERSISTENCENAME+" calificacionempleado";
	public static String QUERYSELECTNATIVE="select "+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".id,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".version_row,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".id_sucursal,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".id_ejercicio,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".id_periodo,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".id_empleado,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".id_evaluacion_empleado,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".id_formato_nomi_factor_nomi,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".id_formato_nomi_pregunta_nomi,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".id_tipo_calificacion_empleado,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".valor_conocimiento,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".valor_eficiencia,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".valor_obtenido,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".valor_peso,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".verificado from "+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME;//+" as "+CalificacionEmpleadoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CalificacionEmpleadoConstantesFuncionesAdditional calificacionempleadoConstantesFuncionesAdditional=null;
	
	public CalificacionEmpleadoConstantesFuncionesAdditional getCalificacionEmpleadoConstantesFuncionesAdditional() {
		return this.calificacionempleadoConstantesFuncionesAdditional;
	}
	
	public void setCalificacionEmpleadoConstantesFuncionesAdditional(CalificacionEmpleadoConstantesFuncionesAdditional calificacionempleadoConstantesFuncionesAdditional) {
		try {
			this.calificacionempleadoConstantesFuncionesAdditional=calificacionempleadoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDEVALUACIONEMPLEADO= "id_evaluacion_empleado";
    public static final String IDFORMATONOMIFACTORNOMI= "id_formato_nomi_factor_nomi";
    public static final String IDFORMATONOMIPREGUNTANOMI= "id_formato_nomi_pregunta_nomi";
    public static final String IDTIPOCALIFICACIONEMPLEADO= "id_tipo_calificacion_empleado";
    public static final String VALORCONOCIMIENTO= "valor_conocimiento";
    public static final String VALOREFICIENCIA= "valor_eficiencia";
    public static final String VALOROBTENIDO= "valor_obtenido";
    public static final String VALORPESO= "valor_peso";
    public static final String VERIFICADO= "verificado";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDEVALUACIONEMPLEADO= "Evaluacion Empleado";
		public static final String LABEL_IDEVALUACIONEMPLEADO_LOWER= "Evaluacion Empleado";
    	public static final String LABEL_IDFORMATONOMIFACTORNOMI= "Formato Nomi Factor Nomi";
		public static final String LABEL_IDFORMATONOMIFACTORNOMI_LOWER= "Formato Nomi Factor Nomi";
    	public static final String LABEL_IDFORMATONOMIPREGUNTANOMI= "Formato Nomi Pregunta Nomi";
		public static final String LABEL_IDFORMATONOMIPREGUNTANOMI_LOWER= "Formato Nomi Pregunta Nomi";
    	public static final String LABEL_IDTIPOCALIFICACIONEMPLEADO= "Idtipo Calificacion Empleado";
		public static final String LABEL_IDTIPOCALIFICACIONEMPLEADO_LOWER= "Tipo Calificacion Empleado";
    	public static final String LABEL_VALORCONOCIMIENTO= "Valor Conocimiento";
		public static final String LABEL_VALORCONOCIMIENTO_LOWER= "Valor Conocimiento";
    	public static final String LABEL_VALOREFICIENCIA= "Valor Eficiencia";
		public static final String LABEL_VALOREFICIENCIA_LOWER= "Valor Eficiencia";
    	public static final String LABEL_VALOROBTENIDO= "Valor Obtenido";
		public static final String LABEL_VALOROBTENIDO_LOWER= "Valor Obtenido";
    	public static final String LABEL_VALORPESO= "Valor Peso";
		public static final String LABEL_VALORPESO_LOWER= "Valor Peso";
    	public static final String LABEL_VERIFICADO= "Verificado";
		public static final String LABEL_VERIFICADO_LOWER= "Verificado";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getCalificacionEmpleadoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CalificacionEmpleadoConstantesFunciones.IDEMPRESA)) {sLabelColumna=CalificacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CalificacionEmpleadoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CalificacionEmpleadoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CalificacionEmpleadoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=CalificacionEmpleadoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(CalificacionEmpleadoConstantesFunciones.IDPERIODO)) {sLabelColumna=CalificacionEmpleadoConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(CalificacionEmpleadoConstantesFunciones.IDEMPLEADO)) {sLabelColumna=CalificacionEmpleadoConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(CalificacionEmpleadoConstantesFunciones.IDEVALUACIONEMPLEADO)) {sLabelColumna=CalificacionEmpleadoConstantesFunciones.LABEL_IDEVALUACIONEMPLEADO;}
		if(sNombreColumna.equals(CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIFACTORNOMI)) {sLabelColumna=CalificacionEmpleadoConstantesFunciones.LABEL_IDFORMATONOMIFACTORNOMI;}
		if(sNombreColumna.equals(CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIPREGUNTANOMI)) {sLabelColumna=CalificacionEmpleadoConstantesFunciones.LABEL_IDFORMATONOMIPREGUNTANOMI;}
		if(sNombreColumna.equals(CalificacionEmpleadoConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO)) {sLabelColumna=CalificacionEmpleadoConstantesFunciones.LABEL_IDTIPOCALIFICACIONEMPLEADO;}
		if(sNombreColumna.equals(CalificacionEmpleadoConstantesFunciones.VALORCONOCIMIENTO)) {sLabelColumna=CalificacionEmpleadoConstantesFunciones.LABEL_VALORCONOCIMIENTO;}
		if(sNombreColumna.equals(CalificacionEmpleadoConstantesFunciones.VALOREFICIENCIA)) {sLabelColumna=CalificacionEmpleadoConstantesFunciones.LABEL_VALOREFICIENCIA;}
		if(sNombreColumna.equals(CalificacionEmpleadoConstantesFunciones.VALOROBTENIDO)) {sLabelColumna=CalificacionEmpleadoConstantesFunciones.LABEL_VALOROBTENIDO;}
		if(sNombreColumna.equals(CalificacionEmpleadoConstantesFunciones.VALORPESO)) {sLabelColumna=CalificacionEmpleadoConstantesFunciones.LABEL_VALORPESO;}
		if(sNombreColumna.equals(CalificacionEmpleadoConstantesFunciones.VERIFICADO)) {sLabelColumna=CalificacionEmpleadoConstantesFunciones.LABEL_VERIFICADO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getverificadoDescripcion(CalificacionEmpleado calificacionempleado) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!calificacionempleado.getverificado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getverificadoHtmlDescripcion(CalificacionEmpleado calificacionempleado) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(calificacionempleado.getId(),calificacionempleado.getverificado());

		return sDescripcion;
	}	
	
	public static String getCalificacionEmpleadoDescripcion(CalificacionEmpleado calificacionempleado) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(calificacionempleado !=null/* && calificacionempleado.getId()!=0*/) {
			if(calificacionempleado.getId()!=null) {
				sDescripcion=calificacionempleado.getId().toString();
			}//calificacionempleadocalificacionempleado.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCalificacionEmpleadoDescripcionDetallado(CalificacionEmpleado calificacionempleado) {
		String sDescripcion="";
			
		sDescripcion+=CalificacionEmpleadoConstantesFunciones.ID+"=";
		sDescripcion+=calificacionempleado.getId().toString()+",";
		sDescripcion+=CalificacionEmpleadoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=calificacionempleado.getVersionRow().toString()+",";
		sDescripcion+=CalificacionEmpleadoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=calificacionempleado.getid_empresa().toString()+",";
		sDescripcion+=CalificacionEmpleadoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=calificacionempleado.getid_sucursal().toString()+",";
		sDescripcion+=CalificacionEmpleadoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=calificacionempleado.getid_ejercicio().toString()+",";
		sDescripcion+=CalificacionEmpleadoConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=calificacionempleado.getid_periodo().toString()+",";
		sDescripcion+=CalificacionEmpleadoConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=calificacionempleado.getid_empleado().toString()+",";
		sDescripcion+=CalificacionEmpleadoConstantesFunciones.IDEVALUACIONEMPLEADO+"=";
		sDescripcion+=calificacionempleado.getid_evaluacion_empleado().toString()+",";
		sDescripcion+=CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIFACTORNOMI+"=";
		sDescripcion+=calificacionempleado.getid_formato_nomi_factor_nomi().toString()+",";
		sDescripcion+=CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIPREGUNTANOMI+"=";
		sDescripcion+=calificacionempleado.getid_formato_nomi_pregunta_nomi().toString()+",";
		sDescripcion+=CalificacionEmpleadoConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO+"=";
		sDescripcion+=calificacionempleado.getid_tipo_calificacion_empleado().toString()+",";
		sDescripcion+=CalificacionEmpleadoConstantesFunciones.VALORCONOCIMIENTO+"=";
		sDescripcion+=calificacionempleado.getvalor_conocimiento().toString()+",";
		sDescripcion+=CalificacionEmpleadoConstantesFunciones.VALOREFICIENCIA+"=";
		sDescripcion+=calificacionempleado.getvalor_eficiencia().toString()+",";
		sDescripcion+=CalificacionEmpleadoConstantesFunciones.VALOROBTENIDO+"=";
		sDescripcion+=calificacionempleado.getvalor_obtenido().toString()+",";
		sDescripcion+=CalificacionEmpleadoConstantesFunciones.VALORPESO+"=";
		sDescripcion+=calificacionempleado.getvalor_peso().toString()+",";
		sDescripcion+=CalificacionEmpleadoConstantesFunciones.VERIFICADO+"=";
		sDescripcion+=calificacionempleado.getverificado().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCalificacionEmpleadoDescripcion(CalificacionEmpleado calificacionempleado,String sValor) throws Exception {			
		if(calificacionempleado !=null) {
			//calificacionempleadocalificacionempleado.getId().toString();
		}		
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

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getEvaluacionEmpleadoDescripcion(EvaluacionEmpleado evaluacionempleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(evaluacionempleado!=null/*&&evaluacionempleado.getId()>0*/) {
			sDescripcion=EvaluacionEmpleadoConstantesFunciones.getEvaluacionEmpleadoDescripcion(evaluacionempleado);
		}

		return sDescripcion;
	}

	public static String getFormatoNomiFactorNomiDescripcion(FormatoNomiFactorNomi formatonomifactornomi) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formatonomifactornomi!=null/*&&formatonomifactornomi.getId()>0*/) {
			sDescripcion=FormatoNomiFactorNomiConstantesFunciones.getFormatoNomiFactorNomiDescripcion(formatonomifactornomi);
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

	public static String getTipoCalificacionEmpleadoDescripcion(TipoCalificacionEmpleado tipocalificacionempleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocalificacionempleado!=null/*&&tipocalificacionempleado.getId()>0*/) {
			sDescripcion=TipoCalificacionEmpleadoConstantesFunciones.getTipoCalificacionEmpleadoDescripcion(tipocalificacionempleado);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEvaluacionEmpleado")) {
			sNombreIndice="Tipo=  Por Evaluacion Empleado";
		} else if(sNombreIndice.equals("FK_IdFormatoNomiFactorNomi")) {
			sNombreIndice="Tipo=  Por Formato Nomi Factor Nomi";
		} else if(sNombreIndice.equals("FK_IdFormatoNomiPreguntaNomi")) {
			sNombreIndice="Tipo=  Por Formato Nomi Pregunta Nomi";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCalificacionEmpleado")) {
			sNombreIndice="Tipo=  Por Idtipo Calificacion Empleado";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEvaluacionEmpleado(Long id_evaluacion_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_evaluacion_empleado!=null) {sDetalleIndice+=" Codigo Unico De Evaluacion Empleado="+id_evaluacion_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoNomiFactorNomi(Long id_formato_nomi_factor_nomi) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_nomi_factor_nomi!=null) {sDetalleIndice+=" Codigo Unico De Formato Nomi Factor Nomi="+id_formato_nomi_factor_nomi.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoNomiPreguntaNomi(Long id_formato_nomi_pregunta_nomi) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_nomi_pregunta_nomi!=null) {sDetalleIndice+=" Codigo Unico De Formato Nomi Pregunta Nomi="+id_formato_nomi_pregunta_nomi.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCalificacionEmpleado(Long id_tipo_calificacion_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_calificacion_empleado!=null) {sDetalleIndice+=" Codigo Unico De Idtipo Calificacion Empleado="+id_tipo_calificacion_empleado.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCalificacionEmpleado(CalificacionEmpleado calificacionempleado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosCalificacionEmpleados(List<CalificacionEmpleado> calificacionempleados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CalificacionEmpleado calificacionempleado: calificacionempleados) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCalificacionEmpleado(CalificacionEmpleado calificacionempleado,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && calificacionempleado.getConCambioAuxiliar()) {
			calificacionempleado.setIsDeleted(calificacionempleado.getIsDeletedAuxiliar());	
			calificacionempleado.setIsNew(calificacionempleado.getIsNewAuxiliar());	
			calificacionempleado.setIsChanged(calificacionempleado.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			calificacionempleado.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			calificacionempleado.setIsDeletedAuxiliar(false);	
			calificacionempleado.setIsNewAuxiliar(false);	
			calificacionempleado.setIsChangedAuxiliar(false);
			
			calificacionempleado.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCalificacionEmpleados(List<CalificacionEmpleado> calificacionempleados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CalificacionEmpleado calificacionempleado : calificacionempleados) {
			if(conAsignarBase && calificacionempleado.getConCambioAuxiliar()) {
				calificacionempleado.setIsDeleted(calificacionempleado.getIsDeletedAuxiliar());	
				calificacionempleado.setIsNew(calificacionempleado.getIsNewAuxiliar());	
				calificacionempleado.setIsChanged(calificacionempleado.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				calificacionempleado.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				calificacionempleado.setIsDeletedAuxiliar(false);	
				calificacionempleado.setIsNewAuxiliar(false);	
				calificacionempleado.setIsChangedAuxiliar(false);
				
				calificacionempleado.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCalificacionEmpleado(CalificacionEmpleado calificacionempleado,Boolean conEnteros) throws Exception  {
		calificacionempleado.setvalor_conocimiento(0.0);
		calificacionempleado.setvalor_eficiencia(0.0);
		calificacionempleado.setvalor_obtenido(0.0);
		calificacionempleado.setvalor_peso(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCalificacionEmpleados(List<CalificacionEmpleado> calificacionempleados,Boolean conEnteros) throws Exception  {
		
		for(CalificacionEmpleado calificacionempleado: calificacionempleados) {
			calificacionempleado.setvalor_conocimiento(0.0);
			calificacionempleado.setvalor_eficiencia(0.0);
			calificacionempleado.setvalor_obtenido(0.0);
			calificacionempleado.setvalor_peso(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCalificacionEmpleado(List<CalificacionEmpleado> calificacionempleados,CalificacionEmpleado calificacionempleadoAux) throws Exception  {
		CalificacionEmpleadoConstantesFunciones.InicializarValoresCalificacionEmpleado(calificacionempleadoAux,true);
		
		for(CalificacionEmpleado calificacionempleado: calificacionempleados) {
			if(calificacionempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			calificacionempleadoAux.setvalor_conocimiento(calificacionempleadoAux.getvalor_conocimiento()+calificacionempleado.getvalor_conocimiento());			
			calificacionempleadoAux.setvalor_eficiencia(calificacionempleadoAux.getvalor_eficiencia()+calificacionempleado.getvalor_eficiencia());			
			calificacionempleadoAux.setvalor_obtenido(calificacionempleadoAux.getvalor_obtenido()+calificacionempleado.getvalor_obtenido());			
			calificacionempleadoAux.setvalor_peso(calificacionempleadoAux.getvalor_peso()+calificacionempleado.getvalor_peso());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCalificacionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CalificacionEmpleadoConstantesFunciones.getArrayColumnasGlobalesCalificacionEmpleado(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCalificacionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CalificacionEmpleadoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CalificacionEmpleadoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CalificacionEmpleadoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CalificacionEmpleadoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CalificacionEmpleadoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CalificacionEmpleadoConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CalificacionEmpleadoConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CalificacionEmpleadoConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCalificacionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CalificacionEmpleado> calificacionempleados,CalificacionEmpleado calificacionempleado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CalificacionEmpleado calificacionempleadoAux: calificacionempleados) {
			if(calificacionempleadoAux!=null && calificacionempleado!=null) {
				if((calificacionempleadoAux.getId()==null && calificacionempleado.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(calificacionempleadoAux.getId()!=null && calificacionempleado.getId()!=null){
					if(calificacionempleadoAux.getId().equals(calificacionempleado.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCalificacionEmpleado(List<CalificacionEmpleado> calificacionempleados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_conocimientoTotal=0.0;
		Double valor_eficienciaTotal=0.0;
		Double valor_obtenidoTotal=0.0;
		Double valor_pesoTotal=0.0;
	
		for(CalificacionEmpleado calificacionempleado: calificacionempleados) {			
			if(calificacionempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_conocimientoTotal+=calificacionempleado.getvalor_conocimiento();
			valor_eficienciaTotal+=calificacionempleado.getvalor_eficiencia();
			valor_obtenidoTotal+=calificacionempleado.getvalor_obtenido();
			valor_pesoTotal+=calificacionempleado.getvalor_peso();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CalificacionEmpleadoConstantesFunciones.VALORCONOCIMIENTO);
		datoGeneral.setsDescripcion(CalificacionEmpleadoConstantesFunciones.LABEL_VALORCONOCIMIENTO);
		datoGeneral.setdValorDouble(valor_conocimientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CalificacionEmpleadoConstantesFunciones.VALOREFICIENCIA);
		datoGeneral.setsDescripcion(CalificacionEmpleadoConstantesFunciones.LABEL_VALOREFICIENCIA);
		datoGeneral.setdValorDouble(valor_eficienciaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CalificacionEmpleadoConstantesFunciones.VALOROBTENIDO);
		datoGeneral.setsDescripcion(CalificacionEmpleadoConstantesFunciones.LABEL_VALOROBTENIDO);
		datoGeneral.setdValorDouble(valor_obtenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CalificacionEmpleadoConstantesFunciones.VALORPESO);
		datoGeneral.setsDescripcion(CalificacionEmpleadoConstantesFunciones.LABEL_VALORPESO);
		datoGeneral.setdValorDouble(valor_pesoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCalificacionEmpleado() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CalificacionEmpleadoConstantesFunciones.LABEL_ID, CalificacionEmpleadoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CalificacionEmpleadoConstantesFunciones.LABEL_VERSIONROW, CalificacionEmpleadoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CalificacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA, CalificacionEmpleadoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CalificacionEmpleadoConstantesFunciones.LABEL_IDSUCURSAL, CalificacionEmpleadoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CalificacionEmpleadoConstantesFunciones.LABEL_IDEJERCICIO, CalificacionEmpleadoConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CalificacionEmpleadoConstantesFunciones.LABEL_IDPERIODO, CalificacionEmpleadoConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CalificacionEmpleadoConstantesFunciones.LABEL_IDEMPLEADO, CalificacionEmpleadoConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CalificacionEmpleadoConstantesFunciones.LABEL_IDEVALUACIONEMPLEADO, CalificacionEmpleadoConstantesFunciones.IDEVALUACIONEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CalificacionEmpleadoConstantesFunciones.LABEL_IDFORMATONOMIFACTORNOMI, CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIFACTORNOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CalificacionEmpleadoConstantesFunciones.LABEL_IDFORMATONOMIPREGUNTANOMI, CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIPREGUNTANOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CalificacionEmpleadoConstantesFunciones.LABEL_IDTIPOCALIFICACIONEMPLEADO, CalificacionEmpleadoConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CalificacionEmpleadoConstantesFunciones.LABEL_VALORCONOCIMIENTO, CalificacionEmpleadoConstantesFunciones.VALORCONOCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CalificacionEmpleadoConstantesFunciones.LABEL_VALOREFICIENCIA, CalificacionEmpleadoConstantesFunciones.VALOREFICIENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CalificacionEmpleadoConstantesFunciones.LABEL_VALOROBTENIDO, CalificacionEmpleadoConstantesFunciones.VALOROBTENIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CalificacionEmpleadoConstantesFunciones.LABEL_VALORPESO, CalificacionEmpleadoConstantesFunciones.VALORPESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CalificacionEmpleadoConstantesFunciones.LABEL_VERIFICADO, CalificacionEmpleadoConstantesFunciones.VERIFICADO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCalificacionEmpleado() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CalificacionEmpleadoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CalificacionEmpleadoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CalificacionEmpleadoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CalificacionEmpleadoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CalificacionEmpleadoConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CalificacionEmpleadoConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CalificacionEmpleadoConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CalificacionEmpleadoConstantesFunciones.IDEVALUACIONEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIFACTORNOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIPREGUNTANOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CalificacionEmpleadoConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CalificacionEmpleadoConstantesFunciones.VALORCONOCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CalificacionEmpleadoConstantesFunciones.VALOREFICIENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CalificacionEmpleadoConstantesFunciones.VALOROBTENIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CalificacionEmpleadoConstantesFunciones.VALORPESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CalificacionEmpleadoConstantesFunciones.VERIFICADO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCalificacionEmpleado() throws Exception  {
		return CalificacionEmpleadoConstantesFunciones.getTiposSeleccionarCalificacionEmpleado(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCalificacionEmpleado(Boolean conFk) throws Exception  {
		return CalificacionEmpleadoConstantesFunciones.getTiposSeleccionarCalificacionEmpleado(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCalificacionEmpleado(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CalificacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CalificacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CalificacionEmpleadoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CalificacionEmpleadoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CalificacionEmpleadoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(CalificacionEmpleadoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CalificacionEmpleadoConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(CalificacionEmpleadoConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CalificacionEmpleadoConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(CalificacionEmpleadoConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CalificacionEmpleadoConstantesFunciones.LABEL_IDEVALUACIONEMPLEADO);
			reporte.setsDescripcion(CalificacionEmpleadoConstantesFunciones.LABEL_IDEVALUACIONEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CalificacionEmpleadoConstantesFunciones.LABEL_IDFORMATONOMIFACTORNOMI);
			reporte.setsDescripcion(CalificacionEmpleadoConstantesFunciones.LABEL_IDFORMATONOMIFACTORNOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CalificacionEmpleadoConstantesFunciones.LABEL_IDFORMATONOMIPREGUNTANOMI);
			reporte.setsDescripcion(CalificacionEmpleadoConstantesFunciones.LABEL_IDFORMATONOMIPREGUNTANOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CalificacionEmpleadoConstantesFunciones.LABEL_IDTIPOCALIFICACIONEMPLEADO);
			reporte.setsDescripcion(CalificacionEmpleadoConstantesFunciones.LABEL_IDTIPOCALIFICACIONEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CalificacionEmpleadoConstantesFunciones.LABEL_VALORCONOCIMIENTO);
			reporte.setsDescripcion(CalificacionEmpleadoConstantesFunciones.LABEL_VALORCONOCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CalificacionEmpleadoConstantesFunciones.LABEL_VALOREFICIENCIA);
			reporte.setsDescripcion(CalificacionEmpleadoConstantesFunciones.LABEL_VALOREFICIENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CalificacionEmpleadoConstantesFunciones.LABEL_VALOROBTENIDO);
			reporte.setsDescripcion(CalificacionEmpleadoConstantesFunciones.LABEL_VALOROBTENIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CalificacionEmpleadoConstantesFunciones.LABEL_VALORPESO);
			reporte.setsDescripcion(CalificacionEmpleadoConstantesFunciones.LABEL_VALORPESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CalificacionEmpleadoConstantesFunciones.LABEL_VERIFICADO);
			reporte.setsDescripcion(CalificacionEmpleadoConstantesFunciones.LABEL_VERIFICADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCalificacionEmpleado(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCalificacionEmpleado(CalificacionEmpleado calificacionempleadoAux) throws Exception {
		
			calificacionempleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(calificacionempleadoAux.getEmpresa()));
			calificacionempleadoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(calificacionempleadoAux.getSucursal()));
			calificacionempleadoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(calificacionempleadoAux.getEjercicio()));
			calificacionempleadoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(calificacionempleadoAux.getPeriodo()));
			calificacionempleadoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(calificacionempleadoAux.getEmpleado()));
			calificacionempleadoAux.setevaluacionempleado_descripcion(EvaluacionEmpleadoConstantesFunciones.getEvaluacionEmpleadoDescripcion(calificacionempleadoAux.getEvaluacionEmpleado()));
			calificacionempleadoAux.setformatonomifactornomi_descripcion(FormatoNomiFactorNomiConstantesFunciones.getFormatoNomiFactorNomiDescripcion(calificacionempleadoAux.getFormatoNomiFactorNomi()));
			calificacionempleadoAux.setformatonomipreguntanomi_descripcion(FormatoNomiPreguntaNomiConstantesFunciones.getFormatoNomiPreguntaNomiDescripcion(calificacionempleadoAux.getFormatoNomiPreguntaNomi()));
			calificacionempleadoAux.settipocalificacionempleado_descripcion(TipoCalificacionEmpleadoConstantesFunciones.getTipoCalificacionEmpleadoDescripcion(calificacionempleadoAux.getTipoCalificacionEmpleado()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCalificacionEmpleado(List<CalificacionEmpleado> calificacionempleadosTemp) throws Exception {
		for(CalificacionEmpleado calificacionempleadoAux:calificacionempleadosTemp) {
			
			calificacionempleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(calificacionempleadoAux.getEmpresa()));
			calificacionempleadoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(calificacionempleadoAux.getSucursal()));
			calificacionempleadoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(calificacionempleadoAux.getEjercicio()));
			calificacionempleadoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(calificacionempleadoAux.getPeriodo()));
			calificacionempleadoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(calificacionempleadoAux.getEmpleado()));
			calificacionempleadoAux.setevaluacionempleado_descripcion(EvaluacionEmpleadoConstantesFunciones.getEvaluacionEmpleadoDescripcion(calificacionempleadoAux.getEvaluacionEmpleado()));
			calificacionempleadoAux.setformatonomifactornomi_descripcion(FormatoNomiFactorNomiConstantesFunciones.getFormatoNomiFactorNomiDescripcion(calificacionempleadoAux.getFormatoNomiFactorNomi()));
			calificacionempleadoAux.setformatonomipreguntanomi_descripcion(FormatoNomiPreguntaNomiConstantesFunciones.getFormatoNomiPreguntaNomiDescripcion(calificacionempleadoAux.getFormatoNomiPreguntaNomi()));
			calificacionempleadoAux.settipocalificacionempleado_descripcion(TipoCalificacionEmpleadoConstantesFunciones.getTipoCalificacionEmpleadoDescripcion(calificacionempleadoAux.getTipoCalificacionEmpleado()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCalificacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(EvaluacionEmpleado.class));
				classes.add(new Classe(FormatoNomiFactorNomi.class));
				classes.add(new Classe(FormatoNomiPreguntaNomi.class));
				classes.add(new Classe(TipoCalificacionEmpleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
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
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EvaluacionEmpleado.class)) {
						classes.add(new Classe(EvaluacionEmpleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FormatoNomiFactorNomi.class)) {
						classes.add(new Classe(FormatoNomiFactorNomi.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FormatoNomiPreguntaNomi.class)) {
						classes.add(new Classe(FormatoNomiPreguntaNomi.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCalificacionEmpleado.class)) {
						classes.add(new Classe(TipoCalificacionEmpleado.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCalificacionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(EvaluacionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EvaluacionEmpleado.class)); continue;
					}

					if(FormatoNomiFactorNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomiFactorNomi.class)); continue;
					}

					if(FormatoNomiPreguntaNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomiPreguntaNomi.class)); continue;
					}

					if(TipoCalificacionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCalificacionEmpleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(EvaluacionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EvaluacionEmpleado.class)); continue;
					}

					if(FormatoNomiFactorNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomiFactorNomi.class)); continue;
					}

					if(FormatoNomiPreguntaNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomiPreguntaNomi.class)); continue;
					}

					if(TipoCalificacionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCalificacionEmpleado.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCalificacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CalificacionEmpleadoConstantesFunciones.getClassesRelationshipsOfCalificacionEmpleado(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCalificacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCalificacionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CalificacionEmpleadoConstantesFunciones.getClassesRelationshipsFromStringsOfCalificacionEmpleado(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCalificacionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CalificacionEmpleado calificacionempleado,List<CalificacionEmpleado> calificacionempleados,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CalificacionEmpleado calificacionempleadoEncontrado=null;
			
			for(CalificacionEmpleado calificacionempleadoLocal:calificacionempleados) {
				if(calificacionempleadoLocal.getId().equals(calificacionempleado.getId())) {
					calificacionempleadoEncontrado=calificacionempleadoLocal;
					
					calificacionempleadoLocal.setIsChanged(calificacionempleado.getIsChanged());
					calificacionempleadoLocal.setIsNew(calificacionempleado.getIsNew());
					calificacionempleadoLocal.setIsDeleted(calificacionempleado.getIsDeleted());
					
					calificacionempleadoLocal.setGeneralEntityOriginal(calificacionempleado.getGeneralEntityOriginal());
					
					calificacionempleadoLocal.setId(calificacionempleado.getId());	
					calificacionempleadoLocal.setVersionRow(calificacionempleado.getVersionRow());	
					calificacionempleadoLocal.setid_empresa(calificacionempleado.getid_empresa());	
					calificacionempleadoLocal.setid_sucursal(calificacionempleado.getid_sucursal());	
					calificacionempleadoLocal.setid_ejercicio(calificacionempleado.getid_ejercicio());	
					calificacionempleadoLocal.setid_periodo(calificacionempleado.getid_periodo());	
					calificacionempleadoLocal.setid_empleado(calificacionempleado.getid_empleado());	
					calificacionempleadoLocal.setid_evaluacion_empleado(calificacionempleado.getid_evaluacion_empleado());	
					calificacionempleadoLocal.setid_formato_nomi_factor_nomi(calificacionempleado.getid_formato_nomi_factor_nomi());	
					calificacionempleadoLocal.setid_formato_nomi_pregunta_nomi(calificacionempleado.getid_formato_nomi_pregunta_nomi());	
					calificacionempleadoLocal.setid_tipo_calificacion_empleado(calificacionempleado.getid_tipo_calificacion_empleado());	
					calificacionempleadoLocal.setvalor_conocimiento(calificacionempleado.getvalor_conocimiento());	
					calificacionempleadoLocal.setvalor_eficiencia(calificacionempleado.getvalor_eficiencia());	
					calificacionempleadoLocal.setvalor_obtenido(calificacionempleado.getvalor_obtenido());	
					calificacionempleadoLocal.setvalor_peso(calificacionempleado.getvalor_peso());	
					calificacionempleadoLocal.setverificado(calificacionempleado.getverificado());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!calificacionempleado.getIsDeleted()) {
				if(!existe) {
					calificacionempleados.add(calificacionempleado);
				}
			} else {
				if(calificacionempleadoEncontrado!=null && permiteQuitar)  {
					calificacionempleados.remove(calificacionempleadoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CalificacionEmpleado calificacionempleado,List<CalificacionEmpleado> calificacionempleados) throws Exception {
		try	{			
			for(CalificacionEmpleado calificacionempleadoLocal:calificacionempleados) {
				if(calificacionempleadoLocal.getId().equals(calificacionempleado.getId())) {
					calificacionempleadoLocal.setIsSelected(calificacionempleado.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCalificacionEmpleado(List<CalificacionEmpleado> calificacionempleadosAux) throws Exception {
		//this.calificacionempleadosAux=calificacionempleadosAux;
		
		for(CalificacionEmpleado calificacionempleadoAux:calificacionempleadosAux) {
			if(calificacionempleadoAux.getIsChanged()) {
				calificacionempleadoAux.setIsChanged(false);
			}		
			
			if(calificacionempleadoAux.getIsNew()) {
				calificacionempleadoAux.setIsNew(false);
			}	
			
			if(calificacionempleadoAux.getIsDeleted()) {
				calificacionempleadoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCalificacionEmpleado(CalificacionEmpleado calificacionempleadoAux) throws Exception {
		//this.calificacionempleadoAux=calificacionempleadoAux;
		
			if(calificacionempleadoAux.getIsChanged()) {
				calificacionempleadoAux.setIsChanged(false);
			}		
			
			if(calificacionempleadoAux.getIsNew()) {
				calificacionempleadoAux.setIsNew(false);
			}	
			
			if(calificacionempleadoAux.getIsDeleted()) {
				calificacionempleadoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CalificacionEmpleado calificacionempleadoAsignar,CalificacionEmpleado calificacionempleado) throws Exception {
		calificacionempleadoAsignar.setId(calificacionempleado.getId());	
		calificacionempleadoAsignar.setVersionRow(calificacionempleado.getVersionRow());	
		calificacionempleadoAsignar.setid_empresa(calificacionempleado.getid_empresa());
		calificacionempleadoAsignar.setempresa_descripcion(calificacionempleado.getempresa_descripcion());	
		calificacionempleadoAsignar.setid_sucursal(calificacionempleado.getid_sucursal());
		calificacionempleadoAsignar.setsucursal_descripcion(calificacionempleado.getsucursal_descripcion());	
		calificacionempleadoAsignar.setid_ejercicio(calificacionempleado.getid_ejercicio());
		calificacionempleadoAsignar.setejercicio_descripcion(calificacionempleado.getejercicio_descripcion());	
		calificacionempleadoAsignar.setid_periodo(calificacionempleado.getid_periodo());
		calificacionempleadoAsignar.setperiodo_descripcion(calificacionempleado.getperiodo_descripcion());	
		calificacionempleadoAsignar.setid_empleado(calificacionempleado.getid_empleado());
		calificacionempleadoAsignar.setempleado_descripcion(calificacionempleado.getempleado_descripcion());	
		calificacionempleadoAsignar.setid_evaluacion_empleado(calificacionempleado.getid_evaluacion_empleado());
		calificacionempleadoAsignar.setevaluacionempleado_descripcion(calificacionempleado.getevaluacionempleado_descripcion());	
		calificacionempleadoAsignar.setid_formato_nomi_factor_nomi(calificacionempleado.getid_formato_nomi_factor_nomi());
		calificacionempleadoAsignar.setformatonomifactornomi_descripcion(calificacionempleado.getformatonomifactornomi_descripcion());	
		calificacionempleadoAsignar.setid_formato_nomi_pregunta_nomi(calificacionempleado.getid_formato_nomi_pregunta_nomi());
		calificacionempleadoAsignar.setformatonomipreguntanomi_descripcion(calificacionempleado.getformatonomipreguntanomi_descripcion());	
		calificacionempleadoAsignar.setid_tipo_calificacion_empleado(calificacionempleado.getid_tipo_calificacion_empleado());
		calificacionempleadoAsignar.settipocalificacionempleado_descripcion(calificacionempleado.gettipocalificacionempleado_descripcion());	
		calificacionempleadoAsignar.setvalor_conocimiento(calificacionempleado.getvalor_conocimiento());	
		calificacionempleadoAsignar.setvalor_eficiencia(calificacionempleado.getvalor_eficiencia());	
		calificacionempleadoAsignar.setvalor_obtenido(calificacionempleado.getvalor_obtenido());	
		calificacionempleadoAsignar.setvalor_peso(calificacionempleado.getvalor_peso());	
		calificacionempleadoAsignar.setverificado(calificacionempleado.getverificado());	
	}
	
	public static void inicializarCalificacionEmpleado(CalificacionEmpleado calificacionempleado) throws Exception {
		try {
				calificacionempleado.setId(0L);	
					
				calificacionempleado.setid_empresa(-1L);	
				calificacionempleado.setid_sucursal(-1L);	
				calificacionempleado.setid_ejercicio(-1L);	
				calificacionempleado.setid_periodo(-1L);	
				calificacionempleado.setid_empleado(-1L);	
				calificacionempleado.setid_evaluacion_empleado(-1L);	
				calificacionempleado.setid_formato_nomi_factor_nomi(-1L);	
				calificacionempleado.setid_formato_nomi_pregunta_nomi(-1L);	
				calificacionempleado.setid_tipo_calificacion_empleado(-1L);	
				calificacionempleado.setvalor_conocimiento(0.0);	
				calificacionempleado.setvalor_eficiencia(0.0);	
				calificacionempleado.setvalor_obtenido(0.0);	
				calificacionempleado.setvalor_peso(0.0);	
				calificacionempleado.setverificado(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCalificacionEmpleado(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CalificacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CalificacionEmpleadoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CalificacionEmpleadoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CalificacionEmpleadoConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CalificacionEmpleadoConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CalificacionEmpleadoConstantesFunciones.LABEL_IDEVALUACIONEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CalificacionEmpleadoConstantesFunciones.LABEL_IDFORMATONOMIFACTORNOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CalificacionEmpleadoConstantesFunciones.LABEL_IDFORMATONOMIPREGUNTANOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CalificacionEmpleadoConstantesFunciones.LABEL_IDTIPOCALIFICACIONEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CalificacionEmpleadoConstantesFunciones.LABEL_VALORCONOCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CalificacionEmpleadoConstantesFunciones.LABEL_VALOREFICIENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CalificacionEmpleadoConstantesFunciones.LABEL_VALOROBTENIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CalificacionEmpleadoConstantesFunciones.LABEL_VALORPESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CalificacionEmpleadoConstantesFunciones.LABEL_VERIFICADO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCalificacionEmpleado(String sTipo,Row row,Workbook workbook,CalificacionEmpleado calificacionempleado,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(calificacionempleado.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(calificacionempleado.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(calificacionempleado.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(calificacionempleado.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(calificacionempleado.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(calificacionempleado.getevaluacionempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(calificacionempleado.getformatonomifactornomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(calificacionempleado.getformatonomipreguntanomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(calificacionempleado.gettipocalificacionempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(calificacionempleado.getvalor_conocimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(calificacionempleado.getvalor_eficiencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(calificacionempleado.getvalor_obtenido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(calificacionempleado.getvalor_peso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(calificacionempleado.getverificado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCalificacionEmpleado=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCalificacionEmpleado() {
		return this.sFinalQueryCalificacionEmpleado;
	}
	
	public void setsFinalQueryCalificacionEmpleado(String sFinalQueryCalificacionEmpleado) {
		this.sFinalQueryCalificacionEmpleado= sFinalQueryCalificacionEmpleado;
	}
	
	public Border resaltarSeleccionarCalificacionEmpleado=null;
	
	public Border setResaltarSeleccionarCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//calificacionempleadoBeanSwingJInternalFrame.jTtoolBarCalificacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCalificacionEmpleado= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCalificacionEmpleado() {
		return this.resaltarSeleccionarCalificacionEmpleado;
	}
	
	public void setResaltarSeleccionarCalificacionEmpleado(Border borderResaltarSeleccionarCalificacionEmpleado) {
		this.resaltarSeleccionarCalificacionEmpleado= borderResaltarSeleccionarCalificacionEmpleado;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCalificacionEmpleado=null;
	public Boolean mostraridCalificacionEmpleado=true;
	public Boolean activaridCalificacionEmpleado=true;

	public Border resaltarid_empresaCalificacionEmpleado=null;
	public Boolean mostrarid_empresaCalificacionEmpleado=true;
	public Boolean activarid_empresaCalificacionEmpleado=true;
	public Boolean cargarid_empresaCalificacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCalificacionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_sucursalCalificacionEmpleado=null;
	public Boolean mostrarid_sucursalCalificacionEmpleado=true;
	public Boolean activarid_sucursalCalificacionEmpleado=true;
	public Boolean cargarid_sucursalCalificacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCalificacionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_ejercicioCalificacionEmpleado=null;
	public Boolean mostrarid_ejercicioCalificacionEmpleado=true;
	public Boolean activarid_ejercicioCalificacionEmpleado=true;
	public Boolean cargarid_ejercicioCalificacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioCalificacionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_periodoCalificacionEmpleado=null;
	public Boolean mostrarid_periodoCalificacionEmpleado=true;
	public Boolean activarid_periodoCalificacionEmpleado=true;
	public Boolean cargarid_periodoCalificacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoCalificacionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_empleadoCalificacionEmpleado=null;
	public Boolean mostrarid_empleadoCalificacionEmpleado=true;
	public Boolean activarid_empleadoCalificacionEmpleado=true;
	public Boolean cargarid_empleadoCalificacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoCalificacionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_evaluacion_empleadoCalificacionEmpleado=null;
	public Boolean mostrarid_evaluacion_empleadoCalificacionEmpleado=true;
	public Boolean activarid_evaluacion_empleadoCalificacionEmpleado=true;
	public Boolean cargarid_evaluacion_empleadoCalificacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_evaluacion_empleadoCalificacionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_formato_nomi_factor_nomiCalificacionEmpleado=null;
	public Boolean mostrarid_formato_nomi_factor_nomiCalificacionEmpleado=true;
	public Boolean activarid_formato_nomi_factor_nomiCalificacionEmpleado=true;
	public Boolean cargarid_formato_nomi_factor_nomiCalificacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_nomi_factor_nomiCalificacionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_formato_nomi_pregunta_nomiCalificacionEmpleado=null;
	public Boolean mostrarid_formato_nomi_pregunta_nomiCalificacionEmpleado=true;
	public Boolean activarid_formato_nomi_pregunta_nomiCalificacionEmpleado=true;
	public Boolean cargarid_formato_nomi_pregunta_nomiCalificacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_nomi_pregunta_nomiCalificacionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_tipo_calificacion_empleadoCalificacionEmpleado=null;
	public Boolean mostrarid_tipo_calificacion_empleadoCalificacionEmpleado=true;
	public Boolean activarid_tipo_calificacion_empleadoCalificacionEmpleado=true;
	public Boolean cargarid_tipo_calificacion_empleadoCalificacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_calificacion_empleadoCalificacionEmpleado=false;//ConEventDepend=true

	public Border resaltarvalor_conocimientoCalificacionEmpleado=null;
	public Boolean mostrarvalor_conocimientoCalificacionEmpleado=true;
	public Boolean activarvalor_conocimientoCalificacionEmpleado=true;

	public Border resaltarvalor_eficienciaCalificacionEmpleado=null;
	public Boolean mostrarvalor_eficienciaCalificacionEmpleado=true;
	public Boolean activarvalor_eficienciaCalificacionEmpleado=true;

	public Border resaltarvalor_obtenidoCalificacionEmpleado=null;
	public Boolean mostrarvalor_obtenidoCalificacionEmpleado=true;
	public Boolean activarvalor_obtenidoCalificacionEmpleado=true;

	public Border resaltarvalor_pesoCalificacionEmpleado=null;
	public Boolean mostrarvalor_pesoCalificacionEmpleado=true;
	public Boolean activarvalor_pesoCalificacionEmpleado=true;

	public Border resaltarverificadoCalificacionEmpleado=null;
	public Boolean mostrarverificadoCalificacionEmpleado=true;
	public Boolean activarverificadoCalificacionEmpleado=true;

	
	

	public Border setResaltaridCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//calificacionempleadoBeanSwingJInternalFrame.jTtoolBarCalificacionEmpleado.setBorder(borderResaltar);
		
		this.resaltaridCalificacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCalificacionEmpleado() {
		return this.resaltaridCalificacionEmpleado;
	}

	public void setResaltaridCalificacionEmpleado(Border borderResaltar) {
		this.resaltaridCalificacionEmpleado= borderResaltar;
	}

	public Boolean getMostraridCalificacionEmpleado() {
		return this.mostraridCalificacionEmpleado;
	}

	public void setMostraridCalificacionEmpleado(Boolean mostraridCalificacionEmpleado) {
		this.mostraridCalificacionEmpleado= mostraridCalificacionEmpleado;
	}

	public Boolean getActivaridCalificacionEmpleado() {
		return this.activaridCalificacionEmpleado;
	}

	public void setActivaridCalificacionEmpleado(Boolean activaridCalificacionEmpleado) {
		this.activaridCalificacionEmpleado= activaridCalificacionEmpleado;
	}

	public Border setResaltarid_empresaCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//calificacionempleadoBeanSwingJInternalFrame.jTtoolBarCalificacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_empresaCalificacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCalificacionEmpleado() {
		return this.resaltarid_empresaCalificacionEmpleado;
	}

	public void setResaltarid_empresaCalificacionEmpleado(Border borderResaltar) {
		this.resaltarid_empresaCalificacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_empresaCalificacionEmpleado() {
		return this.mostrarid_empresaCalificacionEmpleado;
	}

	public void setMostrarid_empresaCalificacionEmpleado(Boolean mostrarid_empresaCalificacionEmpleado) {
		this.mostrarid_empresaCalificacionEmpleado= mostrarid_empresaCalificacionEmpleado;
	}

	public Boolean getActivarid_empresaCalificacionEmpleado() {
		return this.activarid_empresaCalificacionEmpleado;
	}

	public void setActivarid_empresaCalificacionEmpleado(Boolean activarid_empresaCalificacionEmpleado) {
		this.activarid_empresaCalificacionEmpleado= activarid_empresaCalificacionEmpleado;
	}

	public Boolean getCargarid_empresaCalificacionEmpleado() {
		return this.cargarid_empresaCalificacionEmpleado;
	}

	public void setCargarid_empresaCalificacionEmpleado(Boolean cargarid_empresaCalificacionEmpleado) {
		this.cargarid_empresaCalificacionEmpleado= cargarid_empresaCalificacionEmpleado;
	}

	public Border setResaltarid_sucursalCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//calificacionempleadoBeanSwingJInternalFrame.jTtoolBarCalificacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCalificacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCalificacionEmpleado() {
		return this.resaltarid_sucursalCalificacionEmpleado;
	}

	public void setResaltarid_sucursalCalificacionEmpleado(Border borderResaltar) {
		this.resaltarid_sucursalCalificacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCalificacionEmpleado() {
		return this.mostrarid_sucursalCalificacionEmpleado;
	}

	public void setMostrarid_sucursalCalificacionEmpleado(Boolean mostrarid_sucursalCalificacionEmpleado) {
		this.mostrarid_sucursalCalificacionEmpleado= mostrarid_sucursalCalificacionEmpleado;
	}

	public Boolean getActivarid_sucursalCalificacionEmpleado() {
		return this.activarid_sucursalCalificacionEmpleado;
	}

	public void setActivarid_sucursalCalificacionEmpleado(Boolean activarid_sucursalCalificacionEmpleado) {
		this.activarid_sucursalCalificacionEmpleado= activarid_sucursalCalificacionEmpleado;
	}

	public Boolean getCargarid_sucursalCalificacionEmpleado() {
		return this.cargarid_sucursalCalificacionEmpleado;
	}

	public void setCargarid_sucursalCalificacionEmpleado(Boolean cargarid_sucursalCalificacionEmpleado) {
		this.cargarid_sucursalCalificacionEmpleado= cargarid_sucursalCalificacionEmpleado;
	}

	public Border setResaltarid_ejercicioCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//calificacionempleadoBeanSwingJInternalFrame.jTtoolBarCalificacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioCalificacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioCalificacionEmpleado() {
		return this.resaltarid_ejercicioCalificacionEmpleado;
	}

	public void setResaltarid_ejercicioCalificacionEmpleado(Border borderResaltar) {
		this.resaltarid_ejercicioCalificacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioCalificacionEmpleado() {
		return this.mostrarid_ejercicioCalificacionEmpleado;
	}

	public void setMostrarid_ejercicioCalificacionEmpleado(Boolean mostrarid_ejercicioCalificacionEmpleado) {
		this.mostrarid_ejercicioCalificacionEmpleado= mostrarid_ejercicioCalificacionEmpleado;
	}

	public Boolean getActivarid_ejercicioCalificacionEmpleado() {
		return this.activarid_ejercicioCalificacionEmpleado;
	}

	public void setActivarid_ejercicioCalificacionEmpleado(Boolean activarid_ejercicioCalificacionEmpleado) {
		this.activarid_ejercicioCalificacionEmpleado= activarid_ejercicioCalificacionEmpleado;
	}

	public Boolean getCargarid_ejercicioCalificacionEmpleado() {
		return this.cargarid_ejercicioCalificacionEmpleado;
	}

	public void setCargarid_ejercicioCalificacionEmpleado(Boolean cargarid_ejercicioCalificacionEmpleado) {
		this.cargarid_ejercicioCalificacionEmpleado= cargarid_ejercicioCalificacionEmpleado;
	}

	public Border setResaltarid_periodoCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//calificacionempleadoBeanSwingJInternalFrame.jTtoolBarCalificacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_periodoCalificacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoCalificacionEmpleado() {
		return this.resaltarid_periodoCalificacionEmpleado;
	}

	public void setResaltarid_periodoCalificacionEmpleado(Border borderResaltar) {
		this.resaltarid_periodoCalificacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_periodoCalificacionEmpleado() {
		return this.mostrarid_periodoCalificacionEmpleado;
	}

	public void setMostrarid_periodoCalificacionEmpleado(Boolean mostrarid_periodoCalificacionEmpleado) {
		this.mostrarid_periodoCalificacionEmpleado= mostrarid_periodoCalificacionEmpleado;
	}

	public Boolean getActivarid_periodoCalificacionEmpleado() {
		return this.activarid_periodoCalificacionEmpleado;
	}

	public void setActivarid_periodoCalificacionEmpleado(Boolean activarid_periodoCalificacionEmpleado) {
		this.activarid_periodoCalificacionEmpleado= activarid_periodoCalificacionEmpleado;
	}

	public Boolean getCargarid_periodoCalificacionEmpleado() {
		return this.cargarid_periodoCalificacionEmpleado;
	}

	public void setCargarid_periodoCalificacionEmpleado(Boolean cargarid_periodoCalificacionEmpleado) {
		this.cargarid_periodoCalificacionEmpleado= cargarid_periodoCalificacionEmpleado;
	}

	public Border setResaltarid_empleadoCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//calificacionempleadoBeanSwingJInternalFrame.jTtoolBarCalificacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_empleadoCalificacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoCalificacionEmpleado() {
		return this.resaltarid_empleadoCalificacionEmpleado;
	}

	public void setResaltarid_empleadoCalificacionEmpleado(Border borderResaltar) {
		this.resaltarid_empleadoCalificacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_empleadoCalificacionEmpleado() {
		return this.mostrarid_empleadoCalificacionEmpleado;
	}

	public void setMostrarid_empleadoCalificacionEmpleado(Boolean mostrarid_empleadoCalificacionEmpleado) {
		this.mostrarid_empleadoCalificacionEmpleado= mostrarid_empleadoCalificacionEmpleado;
	}

	public Boolean getActivarid_empleadoCalificacionEmpleado() {
		return this.activarid_empleadoCalificacionEmpleado;
	}

	public void setActivarid_empleadoCalificacionEmpleado(Boolean activarid_empleadoCalificacionEmpleado) {
		this.activarid_empleadoCalificacionEmpleado= activarid_empleadoCalificacionEmpleado;
	}

	public Boolean getCargarid_empleadoCalificacionEmpleado() {
		return this.cargarid_empleadoCalificacionEmpleado;
	}

	public void setCargarid_empleadoCalificacionEmpleado(Boolean cargarid_empleadoCalificacionEmpleado) {
		this.cargarid_empleadoCalificacionEmpleado= cargarid_empleadoCalificacionEmpleado;
	}

	public Border setResaltarid_evaluacion_empleadoCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//calificacionempleadoBeanSwingJInternalFrame.jTtoolBarCalificacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_evaluacion_empleadoCalificacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_evaluacion_empleadoCalificacionEmpleado() {
		return this.resaltarid_evaluacion_empleadoCalificacionEmpleado;
	}

	public void setResaltarid_evaluacion_empleadoCalificacionEmpleado(Border borderResaltar) {
		this.resaltarid_evaluacion_empleadoCalificacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_evaluacion_empleadoCalificacionEmpleado() {
		return this.mostrarid_evaluacion_empleadoCalificacionEmpleado;
	}

	public void setMostrarid_evaluacion_empleadoCalificacionEmpleado(Boolean mostrarid_evaluacion_empleadoCalificacionEmpleado) {
		this.mostrarid_evaluacion_empleadoCalificacionEmpleado= mostrarid_evaluacion_empleadoCalificacionEmpleado;
	}

	public Boolean getActivarid_evaluacion_empleadoCalificacionEmpleado() {
		return this.activarid_evaluacion_empleadoCalificacionEmpleado;
	}

	public void setActivarid_evaluacion_empleadoCalificacionEmpleado(Boolean activarid_evaluacion_empleadoCalificacionEmpleado) {
		this.activarid_evaluacion_empleadoCalificacionEmpleado= activarid_evaluacion_empleadoCalificacionEmpleado;
	}

	public Boolean getCargarid_evaluacion_empleadoCalificacionEmpleado() {
		return this.cargarid_evaluacion_empleadoCalificacionEmpleado;
	}

	public void setCargarid_evaluacion_empleadoCalificacionEmpleado(Boolean cargarid_evaluacion_empleadoCalificacionEmpleado) {
		this.cargarid_evaluacion_empleadoCalificacionEmpleado= cargarid_evaluacion_empleadoCalificacionEmpleado;
	}

	public Border setResaltarid_formato_nomi_factor_nomiCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//calificacionempleadoBeanSwingJInternalFrame.jTtoolBarCalificacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_formato_nomi_factor_nomiCalificacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_nomi_factor_nomiCalificacionEmpleado() {
		return this.resaltarid_formato_nomi_factor_nomiCalificacionEmpleado;
	}

	public void setResaltarid_formato_nomi_factor_nomiCalificacionEmpleado(Border borderResaltar) {
		this.resaltarid_formato_nomi_factor_nomiCalificacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_formato_nomi_factor_nomiCalificacionEmpleado() {
		return this.mostrarid_formato_nomi_factor_nomiCalificacionEmpleado;
	}

	public void setMostrarid_formato_nomi_factor_nomiCalificacionEmpleado(Boolean mostrarid_formato_nomi_factor_nomiCalificacionEmpleado) {
		this.mostrarid_formato_nomi_factor_nomiCalificacionEmpleado= mostrarid_formato_nomi_factor_nomiCalificacionEmpleado;
	}

	public Boolean getActivarid_formato_nomi_factor_nomiCalificacionEmpleado() {
		return this.activarid_formato_nomi_factor_nomiCalificacionEmpleado;
	}

	public void setActivarid_formato_nomi_factor_nomiCalificacionEmpleado(Boolean activarid_formato_nomi_factor_nomiCalificacionEmpleado) {
		this.activarid_formato_nomi_factor_nomiCalificacionEmpleado= activarid_formato_nomi_factor_nomiCalificacionEmpleado;
	}

	public Boolean getCargarid_formato_nomi_factor_nomiCalificacionEmpleado() {
		return this.cargarid_formato_nomi_factor_nomiCalificacionEmpleado;
	}

	public void setCargarid_formato_nomi_factor_nomiCalificacionEmpleado(Boolean cargarid_formato_nomi_factor_nomiCalificacionEmpleado) {
		this.cargarid_formato_nomi_factor_nomiCalificacionEmpleado= cargarid_formato_nomi_factor_nomiCalificacionEmpleado;
	}

	public Border setResaltarid_formato_nomi_pregunta_nomiCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//calificacionempleadoBeanSwingJInternalFrame.jTtoolBarCalificacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_formato_nomi_pregunta_nomiCalificacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_nomi_pregunta_nomiCalificacionEmpleado() {
		return this.resaltarid_formato_nomi_pregunta_nomiCalificacionEmpleado;
	}

	public void setResaltarid_formato_nomi_pregunta_nomiCalificacionEmpleado(Border borderResaltar) {
		this.resaltarid_formato_nomi_pregunta_nomiCalificacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_formato_nomi_pregunta_nomiCalificacionEmpleado() {
		return this.mostrarid_formato_nomi_pregunta_nomiCalificacionEmpleado;
	}

	public void setMostrarid_formato_nomi_pregunta_nomiCalificacionEmpleado(Boolean mostrarid_formato_nomi_pregunta_nomiCalificacionEmpleado) {
		this.mostrarid_formato_nomi_pregunta_nomiCalificacionEmpleado= mostrarid_formato_nomi_pregunta_nomiCalificacionEmpleado;
	}

	public Boolean getActivarid_formato_nomi_pregunta_nomiCalificacionEmpleado() {
		return this.activarid_formato_nomi_pregunta_nomiCalificacionEmpleado;
	}

	public void setActivarid_formato_nomi_pregunta_nomiCalificacionEmpleado(Boolean activarid_formato_nomi_pregunta_nomiCalificacionEmpleado) {
		this.activarid_formato_nomi_pregunta_nomiCalificacionEmpleado= activarid_formato_nomi_pregunta_nomiCalificacionEmpleado;
	}

	public Boolean getCargarid_formato_nomi_pregunta_nomiCalificacionEmpleado() {
		return this.cargarid_formato_nomi_pregunta_nomiCalificacionEmpleado;
	}

	public void setCargarid_formato_nomi_pregunta_nomiCalificacionEmpleado(Boolean cargarid_formato_nomi_pregunta_nomiCalificacionEmpleado) {
		this.cargarid_formato_nomi_pregunta_nomiCalificacionEmpleado= cargarid_formato_nomi_pregunta_nomiCalificacionEmpleado;
	}

	public Border setResaltarid_tipo_calificacion_empleadoCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//calificacionempleadoBeanSwingJInternalFrame.jTtoolBarCalificacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_tipo_calificacion_empleadoCalificacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_calificacion_empleadoCalificacionEmpleado() {
		return this.resaltarid_tipo_calificacion_empleadoCalificacionEmpleado;
	}

	public void setResaltarid_tipo_calificacion_empleadoCalificacionEmpleado(Border borderResaltar) {
		this.resaltarid_tipo_calificacion_empleadoCalificacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_tipo_calificacion_empleadoCalificacionEmpleado() {
		return this.mostrarid_tipo_calificacion_empleadoCalificacionEmpleado;
	}

	public void setMostrarid_tipo_calificacion_empleadoCalificacionEmpleado(Boolean mostrarid_tipo_calificacion_empleadoCalificacionEmpleado) {
		this.mostrarid_tipo_calificacion_empleadoCalificacionEmpleado= mostrarid_tipo_calificacion_empleadoCalificacionEmpleado;
	}

	public Boolean getActivarid_tipo_calificacion_empleadoCalificacionEmpleado() {
		return this.activarid_tipo_calificacion_empleadoCalificacionEmpleado;
	}

	public void setActivarid_tipo_calificacion_empleadoCalificacionEmpleado(Boolean activarid_tipo_calificacion_empleadoCalificacionEmpleado) {
		this.activarid_tipo_calificacion_empleadoCalificacionEmpleado= activarid_tipo_calificacion_empleadoCalificacionEmpleado;
	}

	public Boolean getCargarid_tipo_calificacion_empleadoCalificacionEmpleado() {
		return this.cargarid_tipo_calificacion_empleadoCalificacionEmpleado;
	}

	public void setCargarid_tipo_calificacion_empleadoCalificacionEmpleado(Boolean cargarid_tipo_calificacion_empleadoCalificacionEmpleado) {
		this.cargarid_tipo_calificacion_empleadoCalificacionEmpleado= cargarid_tipo_calificacion_empleadoCalificacionEmpleado;
	}

	public Border setResaltarvalor_conocimientoCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//calificacionempleadoBeanSwingJInternalFrame.jTtoolBarCalificacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarvalor_conocimientoCalificacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_conocimientoCalificacionEmpleado() {
		return this.resaltarvalor_conocimientoCalificacionEmpleado;
	}

	public void setResaltarvalor_conocimientoCalificacionEmpleado(Border borderResaltar) {
		this.resaltarvalor_conocimientoCalificacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarvalor_conocimientoCalificacionEmpleado() {
		return this.mostrarvalor_conocimientoCalificacionEmpleado;
	}

	public void setMostrarvalor_conocimientoCalificacionEmpleado(Boolean mostrarvalor_conocimientoCalificacionEmpleado) {
		this.mostrarvalor_conocimientoCalificacionEmpleado= mostrarvalor_conocimientoCalificacionEmpleado;
	}

	public Boolean getActivarvalor_conocimientoCalificacionEmpleado() {
		return this.activarvalor_conocimientoCalificacionEmpleado;
	}

	public void setActivarvalor_conocimientoCalificacionEmpleado(Boolean activarvalor_conocimientoCalificacionEmpleado) {
		this.activarvalor_conocimientoCalificacionEmpleado= activarvalor_conocimientoCalificacionEmpleado;
	}

	public Border setResaltarvalor_eficienciaCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//calificacionempleadoBeanSwingJInternalFrame.jTtoolBarCalificacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarvalor_eficienciaCalificacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_eficienciaCalificacionEmpleado() {
		return this.resaltarvalor_eficienciaCalificacionEmpleado;
	}

	public void setResaltarvalor_eficienciaCalificacionEmpleado(Border borderResaltar) {
		this.resaltarvalor_eficienciaCalificacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarvalor_eficienciaCalificacionEmpleado() {
		return this.mostrarvalor_eficienciaCalificacionEmpleado;
	}

	public void setMostrarvalor_eficienciaCalificacionEmpleado(Boolean mostrarvalor_eficienciaCalificacionEmpleado) {
		this.mostrarvalor_eficienciaCalificacionEmpleado= mostrarvalor_eficienciaCalificacionEmpleado;
	}

	public Boolean getActivarvalor_eficienciaCalificacionEmpleado() {
		return this.activarvalor_eficienciaCalificacionEmpleado;
	}

	public void setActivarvalor_eficienciaCalificacionEmpleado(Boolean activarvalor_eficienciaCalificacionEmpleado) {
		this.activarvalor_eficienciaCalificacionEmpleado= activarvalor_eficienciaCalificacionEmpleado;
	}

	public Border setResaltarvalor_obtenidoCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//calificacionempleadoBeanSwingJInternalFrame.jTtoolBarCalificacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarvalor_obtenidoCalificacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_obtenidoCalificacionEmpleado() {
		return this.resaltarvalor_obtenidoCalificacionEmpleado;
	}

	public void setResaltarvalor_obtenidoCalificacionEmpleado(Border borderResaltar) {
		this.resaltarvalor_obtenidoCalificacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarvalor_obtenidoCalificacionEmpleado() {
		return this.mostrarvalor_obtenidoCalificacionEmpleado;
	}

	public void setMostrarvalor_obtenidoCalificacionEmpleado(Boolean mostrarvalor_obtenidoCalificacionEmpleado) {
		this.mostrarvalor_obtenidoCalificacionEmpleado= mostrarvalor_obtenidoCalificacionEmpleado;
	}

	public Boolean getActivarvalor_obtenidoCalificacionEmpleado() {
		return this.activarvalor_obtenidoCalificacionEmpleado;
	}

	public void setActivarvalor_obtenidoCalificacionEmpleado(Boolean activarvalor_obtenidoCalificacionEmpleado) {
		this.activarvalor_obtenidoCalificacionEmpleado= activarvalor_obtenidoCalificacionEmpleado;
	}

	public Border setResaltarvalor_pesoCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//calificacionempleadoBeanSwingJInternalFrame.jTtoolBarCalificacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarvalor_pesoCalificacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_pesoCalificacionEmpleado() {
		return this.resaltarvalor_pesoCalificacionEmpleado;
	}

	public void setResaltarvalor_pesoCalificacionEmpleado(Border borderResaltar) {
		this.resaltarvalor_pesoCalificacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarvalor_pesoCalificacionEmpleado() {
		return this.mostrarvalor_pesoCalificacionEmpleado;
	}

	public void setMostrarvalor_pesoCalificacionEmpleado(Boolean mostrarvalor_pesoCalificacionEmpleado) {
		this.mostrarvalor_pesoCalificacionEmpleado= mostrarvalor_pesoCalificacionEmpleado;
	}

	public Boolean getActivarvalor_pesoCalificacionEmpleado() {
		return this.activarvalor_pesoCalificacionEmpleado;
	}

	public void setActivarvalor_pesoCalificacionEmpleado(Boolean activarvalor_pesoCalificacionEmpleado) {
		this.activarvalor_pesoCalificacionEmpleado= activarvalor_pesoCalificacionEmpleado;
	}

	public Border setResaltarverificadoCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//calificacionempleadoBeanSwingJInternalFrame.jTtoolBarCalificacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarverificadoCalificacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarverificadoCalificacionEmpleado() {
		return this.resaltarverificadoCalificacionEmpleado;
	}

	public void setResaltarverificadoCalificacionEmpleado(Border borderResaltar) {
		this.resaltarverificadoCalificacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarverificadoCalificacionEmpleado() {
		return this.mostrarverificadoCalificacionEmpleado;
	}

	public void setMostrarverificadoCalificacionEmpleado(Boolean mostrarverificadoCalificacionEmpleado) {
		this.mostrarverificadoCalificacionEmpleado= mostrarverificadoCalificacionEmpleado;
	}

	public Boolean getActivarverificadoCalificacionEmpleado() {
		return this.activarverificadoCalificacionEmpleado;
	}

	public void setActivarverificadoCalificacionEmpleado(Boolean activarverificadoCalificacionEmpleado) {
		this.activarverificadoCalificacionEmpleado= activarverificadoCalificacionEmpleado;
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
		
		
		this.setMostraridCalificacionEmpleado(esInicial);
		this.setMostrarid_empresaCalificacionEmpleado(esInicial);
		this.setMostrarid_sucursalCalificacionEmpleado(esInicial);
		this.setMostrarid_ejercicioCalificacionEmpleado(esInicial);
		this.setMostrarid_periodoCalificacionEmpleado(esInicial);
		this.setMostrarid_empleadoCalificacionEmpleado(esInicial);
		this.setMostrarid_evaluacion_empleadoCalificacionEmpleado(esInicial);
		this.setMostrarid_formato_nomi_factor_nomiCalificacionEmpleado(esInicial);
		this.setMostrarid_formato_nomi_pregunta_nomiCalificacionEmpleado(esInicial);
		this.setMostrarid_tipo_calificacion_empleadoCalificacionEmpleado(esInicial);
		this.setMostrarvalor_conocimientoCalificacionEmpleado(esInicial);
		this.setMostrarvalor_eficienciaCalificacionEmpleado(esInicial);
		this.setMostrarvalor_obtenidoCalificacionEmpleado(esInicial);
		this.setMostrarvalor_pesoCalificacionEmpleado(esInicial);
		this.setMostrarverificadoCalificacionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.ID)) {
				this.setMostraridCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDEVALUACIONEMPLEADO)) {
				this.setMostrarid_evaluacion_empleadoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIFACTORNOMI)) {
				this.setMostrarid_formato_nomi_factor_nomiCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIPREGUNTANOMI)) {
				this.setMostrarid_formato_nomi_pregunta_nomiCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO)) {
				this.setMostrarid_tipo_calificacion_empleadoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.VALORCONOCIMIENTO)) {
				this.setMostrarvalor_conocimientoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.VALOREFICIENCIA)) {
				this.setMostrarvalor_eficienciaCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.VALOROBTENIDO)) {
				this.setMostrarvalor_obtenidoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.VALORPESO)) {
				this.setMostrarvalor_pesoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.VERIFICADO)) {
				this.setMostrarverificadoCalificacionEmpleado(esAsigna);
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
		
		
		this.setActivaridCalificacionEmpleado(esInicial);
		this.setActivarid_empresaCalificacionEmpleado(esInicial);
		this.setActivarid_sucursalCalificacionEmpleado(esInicial);
		this.setActivarid_ejercicioCalificacionEmpleado(esInicial);
		this.setActivarid_periodoCalificacionEmpleado(esInicial);
		this.setActivarid_empleadoCalificacionEmpleado(esInicial);
		this.setActivarid_evaluacion_empleadoCalificacionEmpleado(esInicial);
		this.setActivarid_formato_nomi_factor_nomiCalificacionEmpleado(esInicial);
		this.setActivarid_formato_nomi_pregunta_nomiCalificacionEmpleado(esInicial);
		this.setActivarid_tipo_calificacion_empleadoCalificacionEmpleado(esInicial);
		this.setActivarvalor_conocimientoCalificacionEmpleado(esInicial);
		this.setActivarvalor_eficienciaCalificacionEmpleado(esInicial);
		this.setActivarvalor_obtenidoCalificacionEmpleado(esInicial);
		this.setActivarvalor_pesoCalificacionEmpleado(esInicial);
		this.setActivarverificadoCalificacionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.ID)) {
				this.setActivaridCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDEVALUACIONEMPLEADO)) {
				this.setActivarid_evaluacion_empleadoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIFACTORNOMI)) {
				this.setActivarid_formato_nomi_factor_nomiCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIPREGUNTANOMI)) {
				this.setActivarid_formato_nomi_pregunta_nomiCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO)) {
				this.setActivarid_tipo_calificacion_empleadoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.VALORCONOCIMIENTO)) {
				this.setActivarvalor_conocimientoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.VALOREFICIENCIA)) {
				this.setActivarvalor_eficienciaCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.VALOROBTENIDO)) {
				this.setActivarvalor_obtenidoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.VALORPESO)) {
				this.setActivarvalor_pesoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.VERIFICADO)) {
				this.setActivarverificadoCalificacionEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCalificacionEmpleado(esInicial);
		this.setResaltarid_empresaCalificacionEmpleado(esInicial);
		this.setResaltarid_sucursalCalificacionEmpleado(esInicial);
		this.setResaltarid_ejercicioCalificacionEmpleado(esInicial);
		this.setResaltarid_periodoCalificacionEmpleado(esInicial);
		this.setResaltarid_empleadoCalificacionEmpleado(esInicial);
		this.setResaltarid_evaluacion_empleadoCalificacionEmpleado(esInicial);
		this.setResaltarid_formato_nomi_factor_nomiCalificacionEmpleado(esInicial);
		this.setResaltarid_formato_nomi_pregunta_nomiCalificacionEmpleado(esInicial);
		this.setResaltarid_tipo_calificacion_empleadoCalificacionEmpleado(esInicial);
		this.setResaltarvalor_conocimientoCalificacionEmpleado(esInicial);
		this.setResaltarvalor_eficienciaCalificacionEmpleado(esInicial);
		this.setResaltarvalor_obtenidoCalificacionEmpleado(esInicial);
		this.setResaltarvalor_pesoCalificacionEmpleado(esInicial);
		this.setResaltarverificadoCalificacionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.ID)) {
				this.setResaltaridCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDEVALUACIONEMPLEADO)) {
				this.setResaltarid_evaluacion_empleadoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIFACTORNOMI)) {
				this.setResaltarid_formato_nomi_factor_nomiCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIPREGUNTANOMI)) {
				this.setResaltarid_formato_nomi_pregunta_nomiCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO)) {
				this.setResaltarid_tipo_calificacion_empleadoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.VALORCONOCIMIENTO)) {
				this.setResaltarvalor_conocimientoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.VALOREFICIENCIA)) {
				this.setResaltarvalor_eficienciaCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.VALOROBTENIDO)) {
				this.setResaltarvalor_obtenidoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.VALORPESO)) {
				this.setResaltarvalor_pesoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalificacionEmpleadoConstantesFunciones.VERIFICADO)) {
				this.setResaltarverificadoCalificacionEmpleado(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEjercicioCalificacionEmpleado=true;

	public Boolean getMostrarFK_IdEjercicioCalificacionEmpleado() {
		return this.mostrarFK_IdEjercicioCalificacionEmpleado;
	}

	public void setMostrarFK_IdEjercicioCalificacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioCalificacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoCalificacionEmpleado=true;

	public Boolean getMostrarFK_IdEmpleadoCalificacionEmpleado() {
		return this.mostrarFK_IdEmpleadoCalificacionEmpleado;
	}

	public void setMostrarFK_IdEmpleadoCalificacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoCalificacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCalificacionEmpleado=true;

	public Boolean getMostrarFK_IdEmpresaCalificacionEmpleado() {
		return this.mostrarFK_IdEmpresaCalificacionEmpleado;
	}

	public void setMostrarFK_IdEmpresaCalificacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCalificacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEvaluacionEmpleadoCalificacionEmpleado=true;

	public Boolean getMostrarFK_IdEvaluacionEmpleadoCalificacionEmpleado() {
		return this.mostrarFK_IdEvaluacionEmpleadoCalificacionEmpleado;
	}

	public void setMostrarFK_IdEvaluacionEmpleadoCalificacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEvaluacionEmpleadoCalificacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoNomiFactorNomiCalificacionEmpleado=true;

	public Boolean getMostrarFK_IdFormatoNomiFactorNomiCalificacionEmpleado() {
		return this.mostrarFK_IdFormatoNomiFactorNomiCalificacionEmpleado;
	}

	public void setMostrarFK_IdFormatoNomiFactorNomiCalificacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoNomiFactorNomiCalificacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoNomiPreguntaNomiCalificacionEmpleado=true;

	public Boolean getMostrarFK_IdFormatoNomiPreguntaNomiCalificacionEmpleado() {
		return this.mostrarFK_IdFormatoNomiPreguntaNomiCalificacionEmpleado;
	}

	public void setMostrarFK_IdFormatoNomiPreguntaNomiCalificacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoNomiPreguntaNomiCalificacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoCalificacionEmpleado=true;

	public Boolean getMostrarFK_IdPeriodoCalificacionEmpleado() {
		return this.mostrarFK_IdPeriodoCalificacionEmpleado;
	}

	public void setMostrarFK_IdPeriodoCalificacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoCalificacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalCalificacionEmpleado=true;

	public Boolean getMostrarFK_IdSucursalCalificacionEmpleado() {
		return this.mostrarFK_IdSucursalCalificacionEmpleado;
	}

	public void setMostrarFK_IdSucursalCalificacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalCalificacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCalificacionEmpleadoCalificacionEmpleado=true;

	public Boolean getMostrarFK_IdTipoCalificacionEmpleadoCalificacionEmpleado() {
		return this.mostrarFK_IdTipoCalificacionEmpleadoCalificacionEmpleado;
	}

	public void setMostrarFK_IdTipoCalificacionEmpleadoCalificacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCalificacionEmpleadoCalificacionEmpleado= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEjercicioCalificacionEmpleado=true;

	public Boolean getActivarFK_IdEjercicioCalificacionEmpleado() {
		return this.activarFK_IdEjercicioCalificacionEmpleado;
	}

	public void setActivarFK_IdEjercicioCalificacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioCalificacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoCalificacionEmpleado=true;

	public Boolean getActivarFK_IdEmpleadoCalificacionEmpleado() {
		return this.activarFK_IdEmpleadoCalificacionEmpleado;
	}

	public void setActivarFK_IdEmpleadoCalificacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoCalificacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCalificacionEmpleado=true;

	public Boolean getActivarFK_IdEmpresaCalificacionEmpleado() {
		return this.activarFK_IdEmpresaCalificacionEmpleado;
	}

	public void setActivarFK_IdEmpresaCalificacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCalificacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEvaluacionEmpleadoCalificacionEmpleado=true;

	public Boolean getActivarFK_IdEvaluacionEmpleadoCalificacionEmpleado() {
		return this.activarFK_IdEvaluacionEmpleadoCalificacionEmpleado;
	}

	public void setActivarFK_IdEvaluacionEmpleadoCalificacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEvaluacionEmpleadoCalificacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoNomiFactorNomiCalificacionEmpleado=true;

	public Boolean getActivarFK_IdFormatoNomiFactorNomiCalificacionEmpleado() {
		return this.activarFK_IdFormatoNomiFactorNomiCalificacionEmpleado;
	}

	public void setActivarFK_IdFormatoNomiFactorNomiCalificacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoNomiFactorNomiCalificacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoNomiPreguntaNomiCalificacionEmpleado=true;

	public Boolean getActivarFK_IdFormatoNomiPreguntaNomiCalificacionEmpleado() {
		return this.activarFK_IdFormatoNomiPreguntaNomiCalificacionEmpleado;
	}

	public void setActivarFK_IdFormatoNomiPreguntaNomiCalificacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoNomiPreguntaNomiCalificacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoCalificacionEmpleado=true;

	public Boolean getActivarFK_IdPeriodoCalificacionEmpleado() {
		return this.activarFK_IdPeriodoCalificacionEmpleado;
	}

	public void setActivarFK_IdPeriodoCalificacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoCalificacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalCalificacionEmpleado=true;

	public Boolean getActivarFK_IdSucursalCalificacionEmpleado() {
		return this.activarFK_IdSucursalCalificacionEmpleado;
	}

	public void setActivarFK_IdSucursalCalificacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalCalificacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCalificacionEmpleadoCalificacionEmpleado=true;

	public Boolean getActivarFK_IdTipoCalificacionEmpleadoCalificacionEmpleado() {
		return this.activarFK_IdTipoCalificacionEmpleadoCalificacionEmpleado;
	}

	public void setActivarFK_IdTipoCalificacionEmpleadoCalificacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCalificacionEmpleadoCalificacionEmpleado= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEjercicioCalificacionEmpleado=null;

	public Border getResaltarFK_IdEjercicioCalificacionEmpleado() {
		return this.resaltarFK_IdEjercicioCalificacionEmpleado;
	}

	public void setResaltarFK_IdEjercicioCalificacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEjercicioCalificacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioCalificacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoCalificacionEmpleado=null;

	public Border getResaltarFK_IdEmpleadoCalificacionEmpleado() {
		return this.resaltarFK_IdEmpleadoCalificacionEmpleado;
	}

	public void setResaltarFK_IdEmpleadoCalificacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoCalificacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoCalificacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCalificacionEmpleado=null;

	public Border getResaltarFK_IdEmpresaCalificacionEmpleado() {
		return this.resaltarFK_IdEmpresaCalificacionEmpleado;
	}

	public void setResaltarFK_IdEmpresaCalificacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCalificacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCalificacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEvaluacionEmpleadoCalificacionEmpleado=null;

	public Border getResaltarFK_IdEvaluacionEmpleadoCalificacionEmpleado() {
		return this.resaltarFK_IdEvaluacionEmpleadoCalificacionEmpleado;
	}

	public void setResaltarFK_IdEvaluacionEmpleadoCalificacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEvaluacionEmpleadoCalificacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEvaluacionEmpleadoCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEvaluacionEmpleadoCalificacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdFormatoNomiFactorNomiCalificacionEmpleado=null;

	public Border getResaltarFK_IdFormatoNomiFactorNomiCalificacionEmpleado() {
		return this.resaltarFK_IdFormatoNomiFactorNomiCalificacionEmpleado;
	}

	public void setResaltarFK_IdFormatoNomiFactorNomiCalificacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdFormatoNomiFactorNomiCalificacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdFormatoNomiFactorNomiCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoNomiFactorNomiCalificacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdFormatoNomiPreguntaNomiCalificacionEmpleado=null;

	public Border getResaltarFK_IdFormatoNomiPreguntaNomiCalificacionEmpleado() {
		return this.resaltarFK_IdFormatoNomiPreguntaNomiCalificacionEmpleado;
	}

	public void setResaltarFK_IdFormatoNomiPreguntaNomiCalificacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdFormatoNomiPreguntaNomiCalificacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdFormatoNomiPreguntaNomiCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoNomiPreguntaNomiCalificacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoCalificacionEmpleado=null;

	public Border getResaltarFK_IdPeriodoCalificacionEmpleado() {
		return this.resaltarFK_IdPeriodoCalificacionEmpleado;
	}

	public void setResaltarFK_IdPeriodoCalificacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdPeriodoCalificacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoCalificacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdSucursalCalificacionEmpleado=null;

	public Border getResaltarFK_IdSucursalCalificacionEmpleado() {
		return this.resaltarFK_IdSucursalCalificacionEmpleado;
	}

	public void setResaltarFK_IdSucursalCalificacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdSucursalCalificacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdSucursalCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalCalificacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdTipoCalificacionEmpleadoCalificacionEmpleado=null;

	public Border getResaltarFK_IdTipoCalificacionEmpleadoCalificacionEmpleado() {
		return this.resaltarFK_IdTipoCalificacionEmpleadoCalificacionEmpleado;
	}

	public void setResaltarFK_IdTipoCalificacionEmpleadoCalificacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdTipoCalificacionEmpleadoCalificacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdTipoCalificacionEmpleadoCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*CalificacionEmpleadoBeanSwingJInternalFrame calificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCalificacionEmpleadoCalificacionEmpleado= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}