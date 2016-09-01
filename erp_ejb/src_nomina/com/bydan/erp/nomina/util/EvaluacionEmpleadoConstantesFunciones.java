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


import com.bydan.erp.nomina.util.EvaluacionEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.EvaluacionEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EvaluacionEmpleadoParameterGeneral;

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
final public class EvaluacionEmpleadoConstantesFunciones extends EvaluacionEmpleadoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EvaluacionEmpleado";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EvaluacionEmpleado"+EvaluacionEmpleadoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EvaluacionEmpleadoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EvaluacionEmpleadoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EvaluacionEmpleadoConstantesFunciones.SCHEMA+"_"+EvaluacionEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EvaluacionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EvaluacionEmpleadoConstantesFunciones.SCHEMA+"_"+EvaluacionEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EvaluacionEmpleadoConstantesFunciones.SCHEMA+"_"+EvaluacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EvaluacionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EvaluacionEmpleadoConstantesFunciones.SCHEMA+"_"+EvaluacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EvaluacionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EvaluacionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EvaluacionEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EvaluacionEmpleadoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EvaluacionEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EvaluacionEmpleadoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Evaluacion Empleados";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Evaluacion Empleado";
	public static final String SCLASSWEBTITULO_LOWER="Evaluacion Empleado";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EvaluacionEmpleado";
	public static final String OBJECTNAME="evaluacionempleado";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="evaluacion_empleado";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select evaluacionempleado from "+EvaluacionEmpleadoConstantesFunciones.SPERSISTENCENAME+" evaluacionempleado";
	public static String QUERYSELECTNATIVE="select "+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".version_row,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_sucursal,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_ejercicio,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_periodo,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_estructura,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_empleado,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_empleado_evalua,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_tipo_evaluacion_empleado,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".fecha,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".esta_evaluado,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_anio,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_semestre,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_trimestre,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_bimestre,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_mes,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".observacion1,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".observacion2,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".observacion3,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".observacion4 from "+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME;//+" as "+EvaluacionEmpleadoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EvaluacionEmpleadoConstantesFuncionesAdditional evaluacionempleadoConstantesFuncionesAdditional=null;
	
	public EvaluacionEmpleadoConstantesFuncionesAdditional getEvaluacionEmpleadoConstantesFuncionesAdditional() {
		return this.evaluacionempleadoConstantesFuncionesAdditional;
	}
	
	public void setEvaluacionEmpleadoConstantesFuncionesAdditional(EvaluacionEmpleadoConstantesFuncionesAdditional evaluacionempleadoConstantesFuncionesAdditional) {
		try {
			this.evaluacionempleadoConstantesFuncionesAdditional=evaluacionempleadoConstantesFuncionesAdditional;
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
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDEMPLEADOEVALUA= "id_empleado_evalua";
    public static final String IDTIPOEVALUACIONEMPLEADO= "id_tipo_evaluacion_empleado";
    public static final String FECHA= "fecha";
    public static final String ESTAEVALUADO= "esta_evaluado";
    public static final String IDANIO= "id_anio";
    public static final String IDSEMESTRE= "id_semestre";
    public static final String IDTRIMESTRE= "id_trimestre";
    public static final String IDBIMESTRE= "id_bimestre";
    public static final String IDMES= "id_mes";
    public static final String OBSERVACION1= "observacion1";
    public static final String OBSERVACION2= "observacion2";
    public static final String OBSERVACION3= "observacion3";
    public static final String OBSERVACION4= "observacion4";
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
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDEMPLEADOEVALUA= "Empleado Evalua";
		public static final String LABEL_IDEMPLEADOEVALUA_LOWER= "Empleado Evalua";
    	public static final String LABEL_IDTIPOEVALUACIONEMPLEADO= "Tipo Evaluacion Empleado";
		public static final String LABEL_IDTIPOEVALUACIONEMPLEADO_LOWER= "Tipo Evaluacion Empleado";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_ESTAEVALUADO= "Esta Evaluado";
		public static final String LABEL_ESTAEVALUADO_LOWER= "Esta Evaluado";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDSEMESTRE= "Semestre";
		public static final String LABEL_IDSEMESTRE_LOWER= "Semestre";
    	public static final String LABEL_IDTRIMESTRE= "Trimestre";
		public static final String LABEL_IDTRIMESTRE_LOWER= "Trimestre";
    	public static final String LABEL_IDBIMESTRE= "Bimestre";
		public static final String LABEL_IDBIMESTRE_LOWER= "Bimestre";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_OBSERVACION1= "Observacion1";
		public static final String LABEL_OBSERVACION1_LOWER= "Observacion1";
    	public static final String LABEL_OBSERVACION2= "Observacion2";
		public static final String LABEL_OBSERVACION2_LOWER= "Observacion2";
    	public static final String LABEL_OBSERVACION3= "Observacion3";
		public static final String LABEL_OBSERVACION3_LOWER= "Observacion3";
    	public static final String LABEL_OBSERVACION4= "Observacion4";
		public static final String LABEL_OBSERVACION4_LOWER= "Observacion4";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXOBSERVACION1=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXOBSERVACION1=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXOBSERVACION2=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXOBSERVACION2=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXOBSERVACION3=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXOBSERVACION3=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXOBSERVACION4=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXOBSERVACION4=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getEvaluacionEmpleadoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EvaluacionEmpleadoConstantesFunciones.IDEMPRESA)) {sLabelColumna=EvaluacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EvaluacionEmpleadoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=EvaluacionEmpleadoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(EvaluacionEmpleadoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=EvaluacionEmpleadoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(EvaluacionEmpleadoConstantesFunciones.IDPERIODO)) {sLabelColumna=EvaluacionEmpleadoConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(EvaluacionEmpleadoConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=EvaluacionEmpleadoConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(EvaluacionEmpleadoConstantesFunciones.IDEMPLEADO)) {sLabelColumna=EvaluacionEmpleadoConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(EvaluacionEmpleadoConstantesFunciones.IDEMPLEADOEVALUA)) {sLabelColumna=EvaluacionEmpleadoConstantesFunciones.LABEL_IDEMPLEADOEVALUA;}
		if(sNombreColumna.equals(EvaluacionEmpleadoConstantesFunciones.IDTIPOEVALUACIONEMPLEADO)) {sLabelColumna=EvaluacionEmpleadoConstantesFunciones.LABEL_IDTIPOEVALUACIONEMPLEADO;}
		if(sNombreColumna.equals(EvaluacionEmpleadoConstantesFunciones.FECHA)) {sLabelColumna=EvaluacionEmpleadoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(EvaluacionEmpleadoConstantesFunciones.ESTAEVALUADO)) {sLabelColumna=EvaluacionEmpleadoConstantesFunciones.LABEL_ESTAEVALUADO;}
		if(sNombreColumna.equals(EvaluacionEmpleadoConstantesFunciones.IDANIO)) {sLabelColumna=EvaluacionEmpleadoConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(EvaluacionEmpleadoConstantesFunciones.IDSEMESTRE)) {sLabelColumna=EvaluacionEmpleadoConstantesFunciones.LABEL_IDSEMESTRE;}
		if(sNombreColumna.equals(EvaluacionEmpleadoConstantesFunciones.IDTRIMESTRE)) {sLabelColumna=EvaluacionEmpleadoConstantesFunciones.LABEL_IDTRIMESTRE;}
		if(sNombreColumna.equals(EvaluacionEmpleadoConstantesFunciones.IDBIMESTRE)) {sLabelColumna=EvaluacionEmpleadoConstantesFunciones.LABEL_IDBIMESTRE;}
		if(sNombreColumna.equals(EvaluacionEmpleadoConstantesFunciones.IDMES)) {sLabelColumna=EvaluacionEmpleadoConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(EvaluacionEmpleadoConstantesFunciones.OBSERVACION1)) {sLabelColumna=EvaluacionEmpleadoConstantesFunciones.LABEL_OBSERVACION1;}
		if(sNombreColumna.equals(EvaluacionEmpleadoConstantesFunciones.OBSERVACION2)) {sLabelColumna=EvaluacionEmpleadoConstantesFunciones.LABEL_OBSERVACION2;}
		if(sNombreColumna.equals(EvaluacionEmpleadoConstantesFunciones.OBSERVACION3)) {sLabelColumna=EvaluacionEmpleadoConstantesFunciones.LABEL_OBSERVACION3;}
		if(sNombreColumna.equals(EvaluacionEmpleadoConstantesFunciones.OBSERVACION4)) {sLabelColumna=EvaluacionEmpleadoConstantesFunciones.LABEL_OBSERVACION4;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getesta_evaluadoDescripcion(EvaluacionEmpleado evaluacionempleado) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!evaluacionempleado.getesta_evaluado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_evaluadoHtmlDescripcion(EvaluacionEmpleado evaluacionempleado) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(evaluacionempleado.getId(),evaluacionempleado.getesta_evaluado());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
	
	public static String getEvaluacionEmpleadoDescripcion(EvaluacionEmpleado evaluacionempleado) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(evaluacionempleado !=null/* && evaluacionempleado.getId()!=0*/) {
			if(evaluacionempleado.getId()!=null) {
				sDescripcion=evaluacionempleado.getId().toString();
			}//evaluacionempleadoevaluacionempleado.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getEvaluacionEmpleadoDescripcionDetallado(EvaluacionEmpleado evaluacionempleado) {
		String sDescripcion="";
			
		sDescripcion+=EvaluacionEmpleadoConstantesFunciones.ID+"=";
		sDescripcion+=evaluacionempleado.getId().toString()+",";
		sDescripcion+=EvaluacionEmpleadoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=evaluacionempleado.getVersionRow().toString()+",";
		sDescripcion+=EvaluacionEmpleadoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=evaluacionempleado.getid_empresa().toString()+",";
		sDescripcion+=EvaluacionEmpleadoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=evaluacionempleado.getid_sucursal().toString()+",";
		sDescripcion+=EvaluacionEmpleadoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=evaluacionempleado.getid_ejercicio().toString()+",";
		sDescripcion+=EvaluacionEmpleadoConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=evaluacionempleado.getid_periodo().toString()+",";
		sDescripcion+=EvaluacionEmpleadoConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=evaluacionempleado.getid_estructura().toString()+",";
		sDescripcion+=EvaluacionEmpleadoConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=evaluacionempleado.getid_empleado().toString()+",";
		sDescripcion+=EvaluacionEmpleadoConstantesFunciones.IDEMPLEADOEVALUA+"=";
		sDescripcion+=evaluacionempleado.getid_empleado_evalua().toString()+",";
		sDescripcion+=EvaluacionEmpleadoConstantesFunciones.IDTIPOEVALUACIONEMPLEADO+"=";
		sDescripcion+=evaluacionempleado.getid_tipo_evaluacion_empleado().toString()+",";
		sDescripcion+=EvaluacionEmpleadoConstantesFunciones.FECHA+"=";
		sDescripcion+=evaluacionempleado.getfecha().toString()+",";
		sDescripcion+=EvaluacionEmpleadoConstantesFunciones.ESTAEVALUADO+"=";
		sDescripcion+=evaluacionempleado.getesta_evaluado().toString()+",";
		sDescripcion+=EvaluacionEmpleadoConstantesFunciones.IDANIO+"=";
		sDescripcion+=evaluacionempleado.getid_anio().toString()+",";
		sDescripcion+=EvaluacionEmpleadoConstantesFunciones.IDSEMESTRE+"=";
		sDescripcion+=evaluacionempleado.getid_semestre().toString()+",";
		sDescripcion+=EvaluacionEmpleadoConstantesFunciones.IDTRIMESTRE+"=";
		sDescripcion+=evaluacionempleado.getid_trimestre().toString()+",";
		sDescripcion+=EvaluacionEmpleadoConstantesFunciones.IDBIMESTRE+"=";
		sDescripcion+=evaluacionempleado.getid_bimestre().toString()+",";
		sDescripcion+=EvaluacionEmpleadoConstantesFunciones.IDMES+"=";
		sDescripcion+=evaluacionempleado.getid_mes().toString()+",";
		sDescripcion+=EvaluacionEmpleadoConstantesFunciones.OBSERVACION1+"=";
		sDescripcion+=evaluacionempleado.getobservacion1()+",";
		sDescripcion+=EvaluacionEmpleadoConstantesFunciones.OBSERVACION2+"=";
		sDescripcion+=evaluacionempleado.getobservacion2()+",";
		sDescripcion+=EvaluacionEmpleadoConstantesFunciones.OBSERVACION3+"=";
		sDescripcion+=evaluacionempleado.getobservacion3()+",";
		sDescripcion+=EvaluacionEmpleadoConstantesFunciones.OBSERVACION4+"=";
		sDescripcion+=evaluacionempleado.getobservacion4()+",";
			
		return sDescripcion;
	}
	
	public static void setEvaluacionEmpleadoDescripcion(EvaluacionEmpleado evaluacionempleado,String sValor) throws Exception {			
		if(evaluacionempleado !=null) {
			//evaluacionempleadoevaluacionempleado.getId().toString();
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

	public static String getEstructuraDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estructura!=null/*&&estructura.getId()>0*/) {
			sDescripcion=EstructuraConstantesFunciones.getEstructuraDescripcion(estructura);
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

	public static String getEmpleadoEvaluaDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
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

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getSemestreDescripcion(Semestre semestre) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(semestre!=null/*&&semestre.getId()>0*/) {
			sDescripcion=SemestreConstantesFunciones.getSemestreDescripcion(semestre);
		}

		return sDescripcion;
	}

	public static String getTrimestreDescripcion(Trimestre trimestre) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(trimestre!=null/*&&trimestre.getId()>0*/) {
			sDescripcion=TrimestreConstantesFunciones.getTrimestreDescripcion(trimestre);
		}

		return sDescripcion;
	}

	public static String getBimestreDescripcion(Bimestre bimestre) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bimestre!=null/*&&bimestre.getId()>0*/) {
			sDescripcion=BimestreConstantesFunciones.getBimestreDescripcion(bimestre);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdBimestre")) {
			sNombreIndice="Tipo=  Por Bimestre";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpleadoEvalua")) {
			sNombreIndice="Tipo=  Por Empleado Evalua";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSemestre")) {
			sNombreIndice="Tipo=  Por Semestre";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoEvaluacionEmpleado")) {
			sNombreIndice="Tipo=  Por Tipo Evaluacion Empleado";
		} else if(sNombreIndice.equals("FK_IdTrimestre")) {
			sNombreIndice="Tipo=  Por Trimestre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBimestre(Long id_bimestre) {
		String sDetalleIndice=" Parametros->";
		if(id_bimestre!=null) {sDetalleIndice+=" Codigo Unico De Bimestre="+id_bimestre.toString();} 

		return sDetalleIndice;
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

	public static String getDetalleIndiceFK_IdEmpleadoEvalua(Long id_empleado_evalua) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado_evalua!=null) {sDetalleIndice+=" Codigo Unico De Empleado Evalua="+id_empleado_evalua.toString();} 

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

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSemestre(Long id_semestre) {
		String sDetalleIndice=" Parametros->";
		if(id_semestre!=null) {sDetalleIndice+=" Codigo Unico De Semestre="+id_semestre.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoEvaluacionEmpleado(Long id_tipo_evaluacion_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_evaluacion_empleado!=null) {sDetalleIndice+=" Codigo Unico De Tipo Evaluacion Empleado="+id_tipo_evaluacion_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTrimestre(Long id_trimestre) {
		String sDetalleIndice=" Parametros->";
		if(id_trimestre!=null) {sDetalleIndice+=" Codigo Unico De Trimestre="+id_trimestre.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEvaluacionEmpleado(EvaluacionEmpleado evaluacionempleado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		evaluacionempleado.setobservacion1(evaluacionempleado.getobservacion1().trim());
		evaluacionempleado.setobservacion2(evaluacionempleado.getobservacion2().trim());
		evaluacionempleado.setobservacion3(evaluacionempleado.getobservacion3().trim());
		evaluacionempleado.setobservacion4(evaluacionempleado.getobservacion4().trim());
	}
	
	public static void quitarEspaciosEvaluacionEmpleados(List<EvaluacionEmpleado> evaluacionempleados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EvaluacionEmpleado evaluacionempleado: evaluacionempleados) {
			evaluacionempleado.setobservacion1(evaluacionempleado.getobservacion1().trim());
			evaluacionempleado.setobservacion2(evaluacionempleado.getobservacion2().trim());
			evaluacionempleado.setobservacion3(evaluacionempleado.getobservacion3().trim());
			evaluacionempleado.setobservacion4(evaluacionempleado.getobservacion4().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEvaluacionEmpleado(EvaluacionEmpleado evaluacionempleado,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && evaluacionempleado.getConCambioAuxiliar()) {
			evaluacionempleado.setIsDeleted(evaluacionempleado.getIsDeletedAuxiliar());	
			evaluacionempleado.setIsNew(evaluacionempleado.getIsNewAuxiliar());	
			evaluacionempleado.setIsChanged(evaluacionempleado.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			evaluacionempleado.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			evaluacionempleado.setIsDeletedAuxiliar(false);	
			evaluacionempleado.setIsNewAuxiliar(false);	
			evaluacionempleado.setIsChangedAuxiliar(false);
			
			evaluacionempleado.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEvaluacionEmpleados(List<EvaluacionEmpleado> evaluacionempleados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EvaluacionEmpleado evaluacionempleado : evaluacionempleados) {
			if(conAsignarBase && evaluacionempleado.getConCambioAuxiliar()) {
				evaluacionempleado.setIsDeleted(evaluacionempleado.getIsDeletedAuxiliar());	
				evaluacionempleado.setIsNew(evaluacionempleado.getIsNewAuxiliar());	
				evaluacionempleado.setIsChanged(evaluacionempleado.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				evaluacionempleado.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				evaluacionempleado.setIsDeletedAuxiliar(false);	
				evaluacionempleado.setIsNewAuxiliar(false);	
				evaluacionempleado.setIsChangedAuxiliar(false);
				
				evaluacionempleado.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEvaluacionEmpleado(EvaluacionEmpleado evaluacionempleado,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEvaluacionEmpleados(List<EvaluacionEmpleado> evaluacionempleados,Boolean conEnteros) throws Exception  {
		
		for(EvaluacionEmpleado evaluacionempleado: evaluacionempleados) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEvaluacionEmpleado(List<EvaluacionEmpleado> evaluacionempleados,EvaluacionEmpleado evaluacionempleadoAux) throws Exception  {
		EvaluacionEmpleadoConstantesFunciones.InicializarValoresEvaluacionEmpleado(evaluacionempleadoAux,true);
		
		for(EvaluacionEmpleado evaluacionempleado: evaluacionempleados) {
			if(evaluacionempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEvaluacionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EvaluacionEmpleadoConstantesFunciones.getArrayColumnasGlobalesEvaluacionEmpleado(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEvaluacionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EvaluacionEmpleadoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EvaluacionEmpleadoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EvaluacionEmpleadoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EvaluacionEmpleadoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EvaluacionEmpleadoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EvaluacionEmpleadoConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EvaluacionEmpleadoConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EvaluacionEmpleadoConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEvaluacionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EvaluacionEmpleado> evaluacionempleados,EvaluacionEmpleado evaluacionempleado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EvaluacionEmpleado evaluacionempleadoAux: evaluacionempleados) {
			if(evaluacionempleadoAux!=null && evaluacionempleado!=null) {
				if((evaluacionempleadoAux.getId()==null && evaluacionempleado.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(evaluacionempleadoAux.getId()!=null && evaluacionempleado.getId()!=null){
					if(evaluacionempleadoAux.getId().equals(evaluacionempleado.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEvaluacionEmpleado(List<EvaluacionEmpleado> evaluacionempleados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EvaluacionEmpleado evaluacionempleado: evaluacionempleados) {			
			if(evaluacionempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEvaluacionEmpleado() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EvaluacionEmpleadoConstantesFunciones.LABEL_ID, EvaluacionEmpleadoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionEmpleadoConstantesFunciones.LABEL_VERSIONROW, EvaluacionEmpleadoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA, EvaluacionEmpleadoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionEmpleadoConstantesFunciones.LABEL_IDSUCURSAL, EvaluacionEmpleadoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionEmpleadoConstantesFunciones.LABEL_IDEJERCICIO, EvaluacionEmpleadoConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionEmpleadoConstantesFunciones.LABEL_IDPERIODO, EvaluacionEmpleadoConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionEmpleadoConstantesFunciones.LABEL_IDESTRUCTURA, EvaluacionEmpleadoConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionEmpleadoConstantesFunciones.LABEL_IDEMPLEADO, EvaluacionEmpleadoConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionEmpleadoConstantesFunciones.LABEL_IDEMPLEADOEVALUA, EvaluacionEmpleadoConstantesFunciones.IDEMPLEADOEVALUA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionEmpleadoConstantesFunciones.LABEL_IDTIPOEVALUACIONEMPLEADO, EvaluacionEmpleadoConstantesFunciones.IDTIPOEVALUACIONEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionEmpleadoConstantesFunciones.LABEL_FECHA, EvaluacionEmpleadoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionEmpleadoConstantesFunciones.LABEL_ESTAEVALUADO, EvaluacionEmpleadoConstantesFunciones.ESTAEVALUADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionEmpleadoConstantesFunciones.LABEL_IDANIO, EvaluacionEmpleadoConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionEmpleadoConstantesFunciones.LABEL_IDSEMESTRE, EvaluacionEmpleadoConstantesFunciones.IDSEMESTRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionEmpleadoConstantesFunciones.LABEL_IDTRIMESTRE, EvaluacionEmpleadoConstantesFunciones.IDTRIMESTRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionEmpleadoConstantesFunciones.LABEL_IDBIMESTRE, EvaluacionEmpleadoConstantesFunciones.IDBIMESTRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionEmpleadoConstantesFunciones.LABEL_IDMES, EvaluacionEmpleadoConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionEmpleadoConstantesFunciones.LABEL_OBSERVACION1, EvaluacionEmpleadoConstantesFunciones.OBSERVACION1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionEmpleadoConstantesFunciones.LABEL_OBSERVACION2, EvaluacionEmpleadoConstantesFunciones.OBSERVACION2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionEmpleadoConstantesFunciones.LABEL_OBSERVACION3, EvaluacionEmpleadoConstantesFunciones.OBSERVACION3,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionEmpleadoConstantesFunciones.LABEL_OBSERVACION4, EvaluacionEmpleadoConstantesFunciones.OBSERVACION4,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEvaluacionEmpleado() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EvaluacionEmpleadoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionEmpleadoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionEmpleadoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionEmpleadoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionEmpleadoConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionEmpleadoConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionEmpleadoConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionEmpleadoConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionEmpleadoConstantesFunciones.IDEMPLEADOEVALUA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionEmpleadoConstantesFunciones.IDTIPOEVALUACIONEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionEmpleadoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionEmpleadoConstantesFunciones.ESTAEVALUADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionEmpleadoConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionEmpleadoConstantesFunciones.IDSEMESTRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionEmpleadoConstantesFunciones.IDTRIMESTRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionEmpleadoConstantesFunciones.IDBIMESTRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionEmpleadoConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionEmpleadoConstantesFunciones.OBSERVACION1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionEmpleadoConstantesFunciones.OBSERVACION2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionEmpleadoConstantesFunciones.OBSERVACION3;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionEmpleadoConstantesFunciones.OBSERVACION4;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEvaluacionEmpleado() throws Exception  {
		return EvaluacionEmpleadoConstantesFunciones.getTiposSeleccionarEvaluacionEmpleado(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEvaluacionEmpleado(Boolean conFk) throws Exception  {
		return EvaluacionEmpleadoConstantesFunciones.getTiposSeleccionarEvaluacionEmpleado(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEvaluacionEmpleado(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EvaluacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionEmpleadoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(EvaluacionEmpleadoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionEmpleadoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(EvaluacionEmpleadoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionEmpleadoConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(EvaluacionEmpleadoConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionEmpleadoConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(EvaluacionEmpleadoConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionEmpleadoConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(EvaluacionEmpleadoConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionEmpleadoConstantesFunciones.LABEL_IDEMPLEADOEVALUA);
			reporte.setsDescripcion(EvaluacionEmpleadoConstantesFunciones.LABEL_IDEMPLEADOEVALUA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionEmpleadoConstantesFunciones.LABEL_IDTIPOEVALUACIONEMPLEADO);
			reporte.setsDescripcion(EvaluacionEmpleadoConstantesFunciones.LABEL_IDTIPOEVALUACIONEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionEmpleadoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(EvaluacionEmpleadoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionEmpleadoConstantesFunciones.LABEL_ESTAEVALUADO);
			reporte.setsDescripcion(EvaluacionEmpleadoConstantesFunciones.LABEL_ESTAEVALUADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionEmpleadoConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(EvaluacionEmpleadoConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionEmpleadoConstantesFunciones.LABEL_IDSEMESTRE);
			reporte.setsDescripcion(EvaluacionEmpleadoConstantesFunciones.LABEL_IDSEMESTRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionEmpleadoConstantesFunciones.LABEL_IDTRIMESTRE);
			reporte.setsDescripcion(EvaluacionEmpleadoConstantesFunciones.LABEL_IDTRIMESTRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionEmpleadoConstantesFunciones.LABEL_IDBIMESTRE);
			reporte.setsDescripcion(EvaluacionEmpleadoConstantesFunciones.LABEL_IDBIMESTRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionEmpleadoConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(EvaluacionEmpleadoConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionEmpleadoConstantesFunciones.LABEL_OBSERVACION1);
			reporte.setsDescripcion(EvaluacionEmpleadoConstantesFunciones.LABEL_OBSERVACION1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionEmpleadoConstantesFunciones.LABEL_OBSERVACION2);
			reporte.setsDescripcion(EvaluacionEmpleadoConstantesFunciones.LABEL_OBSERVACION2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionEmpleadoConstantesFunciones.LABEL_OBSERVACION3);
			reporte.setsDescripcion(EvaluacionEmpleadoConstantesFunciones.LABEL_OBSERVACION3);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionEmpleadoConstantesFunciones.LABEL_OBSERVACION4);
			reporte.setsDescripcion(EvaluacionEmpleadoConstantesFunciones.LABEL_OBSERVACION4);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEvaluacionEmpleado(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEvaluacionEmpleado(EvaluacionEmpleado evaluacionempleadoAux) throws Exception {
		
			evaluacionempleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(evaluacionempleadoAux.getEmpresa()));
			evaluacionempleadoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(evaluacionempleadoAux.getSucursal()));
			evaluacionempleadoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(evaluacionempleadoAux.getEjercicio()));
			evaluacionempleadoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(evaluacionempleadoAux.getPeriodo()));
			evaluacionempleadoAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(evaluacionempleadoAux.getEstructura()));
			evaluacionempleadoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(evaluacionempleadoAux.getEmpleado()));
			evaluacionempleadoAux.setempleadoevalua_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(evaluacionempleadoAux.getEmpleadoEvalua()));
			evaluacionempleadoAux.settipoevaluacionempleado_descripcion(TipoEvaluacionEmpleadoConstantesFunciones.getTipoEvaluacionEmpleadoDescripcion(evaluacionempleadoAux.getTipoEvaluacionEmpleado()));
			evaluacionempleadoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(evaluacionempleadoAux.getAnio()));
			evaluacionempleadoAux.setsemestre_descripcion(SemestreConstantesFunciones.getSemestreDescripcion(evaluacionempleadoAux.getSemestre()));
			evaluacionempleadoAux.settrimestre_descripcion(TrimestreConstantesFunciones.getTrimestreDescripcion(evaluacionempleadoAux.getTrimestre()));
			evaluacionempleadoAux.setbimestre_descripcion(BimestreConstantesFunciones.getBimestreDescripcion(evaluacionempleadoAux.getBimestre()));
			evaluacionempleadoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(evaluacionempleadoAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEvaluacionEmpleado(List<EvaluacionEmpleado> evaluacionempleadosTemp) throws Exception {
		for(EvaluacionEmpleado evaluacionempleadoAux:evaluacionempleadosTemp) {
			
			evaluacionempleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(evaluacionempleadoAux.getEmpresa()));
			evaluacionempleadoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(evaluacionempleadoAux.getSucursal()));
			evaluacionempleadoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(evaluacionempleadoAux.getEjercicio()));
			evaluacionempleadoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(evaluacionempleadoAux.getPeriodo()));
			evaluacionempleadoAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(evaluacionempleadoAux.getEstructura()));
			evaluacionempleadoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(evaluacionempleadoAux.getEmpleado()));
			evaluacionempleadoAux.setempleadoevalua_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(evaluacionempleadoAux.getEmpleadoEvalua()));
			evaluacionempleadoAux.settipoevaluacionempleado_descripcion(TipoEvaluacionEmpleadoConstantesFunciones.getTipoEvaluacionEmpleadoDescripcion(evaluacionempleadoAux.getTipoEvaluacionEmpleado()));
			evaluacionempleadoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(evaluacionempleadoAux.getAnio()));
			evaluacionempleadoAux.setsemestre_descripcion(SemestreConstantesFunciones.getSemestreDescripcion(evaluacionempleadoAux.getSemestre()));
			evaluacionempleadoAux.settrimestre_descripcion(TrimestreConstantesFunciones.getTrimestreDescripcion(evaluacionempleadoAux.getTrimestre()));
			evaluacionempleadoAux.setbimestre_descripcion(BimestreConstantesFunciones.getBimestreDescripcion(evaluacionempleadoAux.getBimestre()));
			evaluacionempleadoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(evaluacionempleadoAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEvaluacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(TipoEvaluacionEmpleado.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Semestre.class));
				classes.add(new Classe(Trimestre.class));
				classes.add(new Classe(Bimestre.class));
				classes.add(new Classe(Mes.class));
				
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
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoEvaluacionEmpleado.class)) {
						classes.add(new Classe(TipoEvaluacionEmpleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Semestre.class)) {
						classes.add(new Classe(Semestre.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Trimestre.class)) {
						classes.add(new Classe(Trimestre.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bimestre.class)) {
						classes.add(new Classe(Bimestre.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEvaluacionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(TipoEvaluacionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoEvaluacionEmpleado.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Semestre.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Semestre.class)); continue;
					}

					if(Trimestre.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Trimestre.class)); continue;
					}

					if(Bimestre.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bimestre.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(TipoEvaluacionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoEvaluacionEmpleado.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Semestre.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Semestre.class)); continue;
					}

					if(Trimestre.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Trimestre.class)); continue;
					}

					if(Bimestre.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bimestre.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEvaluacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EvaluacionEmpleadoConstantesFunciones.getClassesRelationshipsOfEvaluacionEmpleado(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEvaluacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(CalificacionEmpleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(CalificacionEmpleado.class)) {
						classes.add(new Classe(CalificacionEmpleado.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEvaluacionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EvaluacionEmpleadoConstantesFunciones.getClassesRelationshipsFromStringsOfEvaluacionEmpleado(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEvaluacionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(CalificacionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CalificacionEmpleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(CalificacionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CalificacionEmpleado.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(EvaluacionEmpleado evaluacionempleado,List<EvaluacionEmpleado> evaluacionempleados,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EvaluacionEmpleado evaluacionempleadoEncontrado=null;
			
			for(EvaluacionEmpleado evaluacionempleadoLocal:evaluacionempleados) {
				if(evaluacionempleadoLocal.getId().equals(evaluacionempleado.getId())) {
					evaluacionempleadoEncontrado=evaluacionempleadoLocal;
					
					evaluacionempleadoLocal.setIsChanged(evaluacionempleado.getIsChanged());
					evaluacionempleadoLocal.setIsNew(evaluacionempleado.getIsNew());
					evaluacionempleadoLocal.setIsDeleted(evaluacionempleado.getIsDeleted());
					
					evaluacionempleadoLocal.setGeneralEntityOriginal(evaluacionempleado.getGeneralEntityOriginal());
					
					evaluacionempleadoLocal.setId(evaluacionempleado.getId());	
					evaluacionempleadoLocal.setVersionRow(evaluacionempleado.getVersionRow());	
					evaluacionempleadoLocal.setid_empresa(evaluacionempleado.getid_empresa());	
					evaluacionempleadoLocal.setid_sucursal(evaluacionempleado.getid_sucursal());	
					evaluacionempleadoLocal.setid_ejercicio(evaluacionempleado.getid_ejercicio());	
					evaluacionempleadoLocal.setid_periodo(evaluacionempleado.getid_periodo());	
					evaluacionempleadoLocal.setid_estructura(evaluacionempleado.getid_estructura());	
					evaluacionempleadoLocal.setid_empleado(evaluacionempleado.getid_empleado());	
					evaluacionempleadoLocal.setid_empleado_evalua(evaluacionempleado.getid_empleado_evalua());	
					evaluacionempleadoLocal.setid_tipo_evaluacion_empleado(evaluacionempleado.getid_tipo_evaluacion_empleado());	
					evaluacionempleadoLocal.setfecha(evaluacionempleado.getfecha());	
					evaluacionempleadoLocal.setesta_evaluado(evaluacionempleado.getesta_evaluado());	
					evaluacionempleadoLocal.setid_anio(evaluacionempleado.getid_anio());	
					evaluacionempleadoLocal.setid_semestre(evaluacionempleado.getid_semestre());	
					evaluacionempleadoLocal.setid_trimestre(evaluacionempleado.getid_trimestre());	
					evaluacionempleadoLocal.setid_bimestre(evaluacionempleado.getid_bimestre());	
					evaluacionempleadoLocal.setid_mes(evaluacionempleado.getid_mes());	
					evaluacionempleadoLocal.setobservacion1(evaluacionempleado.getobservacion1());	
					evaluacionempleadoLocal.setobservacion2(evaluacionempleado.getobservacion2());	
					evaluacionempleadoLocal.setobservacion3(evaluacionempleado.getobservacion3());	
					evaluacionempleadoLocal.setobservacion4(evaluacionempleado.getobservacion4());	
					
					
					evaluacionempleadoLocal.setCalificacionEmpleados(evaluacionempleado.getCalificacionEmpleados());
					
					existe=true;
					break;
				}
			}
			
			if(!evaluacionempleado.getIsDeleted()) {
				if(!existe) {
					evaluacionempleados.add(evaluacionempleado);
				}
			} else {
				if(evaluacionempleadoEncontrado!=null && permiteQuitar)  {
					evaluacionempleados.remove(evaluacionempleadoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EvaluacionEmpleado evaluacionempleado,List<EvaluacionEmpleado> evaluacionempleados) throws Exception {
		try	{			
			for(EvaluacionEmpleado evaluacionempleadoLocal:evaluacionempleados) {
				if(evaluacionempleadoLocal.getId().equals(evaluacionempleado.getId())) {
					evaluacionempleadoLocal.setIsSelected(evaluacionempleado.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEvaluacionEmpleado(List<EvaluacionEmpleado> evaluacionempleadosAux) throws Exception {
		//this.evaluacionempleadosAux=evaluacionempleadosAux;
		
		for(EvaluacionEmpleado evaluacionempleadoAux:evaluacionempleadosAux) {
			if(evaluacionempleadoAux.getIsChanged()) {
				evaluacionempleadoAux.setIsChanged(false);
			}		
			
			if(evaluacionempleadoAux.getIsNew()) {
				evaluacionempleadoAux.setIsNew(false);
			}	
			
			if(evaluacionempleadoAux.getIsDeleted()) {
				evaluacionempleadoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEvaluacionEmpleado(EvaluacionEmpleado evaluacionempleadoAux) throws Exception {
		//this.evaluacionempleadoAux=evaluacionempleadoAux;
		
			if(evaluacionempleadoAux.getIsChanged()) {
				evaluacionempleadoAux.setIsChanged(false);
			}		
			
			if(evaluacionempleadoAux.getIsNew()) {
				evaluacionempleadoAux.setIsNew(false);
			}	
			
			if(evaluacionempleadoAux.getIsDeleted()) {
				evaluacionempleadoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EvaluacionEmpleado evaluacionempleadoAsignar,EvaluacionEmpleado evaluacionempleado) throws Exception {
		evaluacionempleadoAsignar.setId(evaluacionempleado.getId());	
		evaluacionempleadoAsignar.setVersionRow(evaluacionempleado.getVersionRow());	
		evaluacionempleadoAsignar.setid_empresa(evaluacionempleado.getid_empresa());
		evaluacionempleadoAsignar.setempresa_descripcion(evaluacionempleado.getempresa_descripcion());	
		evaluacionempleadoAsignar.setid_sucursal(evaluacionempleado.getid_sucursal());
		evaluacionempleadoAsignar.setsucursal_descripcion(evaluacionempleado.getsucursal_descripcion());	
		evaluacionempleadoAsignar.setid_ejercicio(evaluacionempleado.getid_ejercicio());
		evaluacionempleadoAsignar.setejercicio_descripcion(evaluacionempleado.getejercicio_descripcion());	
		evaluacionempleadoAsignar.setid_periodo(evaluacionempleado.getid_periodo());
		evaluacionempleadoAsignar.setperiodo_descripcion(evaluacionempleado.getperiodo_descripcion());	
		evaluacionempleadoAsignar.setid_estructura(evaluacionempleado.getid_estructura());
		evaluacionempleadoAsignar.setestructura_descripcion(evaluacionempleado.getestructura_descripcion());	
		evaluacionempleadoAsignar.setid_empleado(evaluacionempleado.getid_empleado());
		evaluacionempleadoAsignar.setempleado_descripcion(evaluacionempleado.getempleado_descripcion());	
		evaluacionempleadoAsignar.setid_empleado_evalua(evaluacionempleado.getid_empleado_evalua());
		evaluacionempleadoAsignar.setempleadoevalua_descripcion(evaluacionempleado.getempleadoevalua_descripcion());	
		evaluacionempleadoAsignar.setid_tipo_evaluacion_empleado(evaluacionempleado.getid_tipo_evaluacion_empleado());
		evaluacionempleadoAsignar.settipoevaluacionempleado_descripcion(evaluacionempleado.gettipoevaluacionempleado_descripcion());	
		evaluacionempleadoAsignar.setfecha(evaluacionempleado.getfecha());	
		evaluacionempleadoAsignar.setesta_evaluado(evaluacionempleado.getesta_evaluado());	
		evaluacionempleadoAsignar.setid_anio(evaluacionempleado.getid_anio());
		evaluacionempleadoAsignar.setanio_descripcion(evaluacionempleado.getanio_descripcion());	
		evaluacionempleadoAsignar.setid_semestre(evaluacionempleado.getid_semestre());
		evaluacionempleadoAsignar.setsemestre_descripcion(evaluacionempleado.getsemestre_descripcion());	
		evaluacionempleadoAsignar.setid_trimestre(evaluacionempleado.getid_trimestre());
		evaluacionempleadoAsignar.settrimestre_descripcion(evaluacionempleado.gettrimestre_descripcion());	
		evaluacionempleadoAsignar.setid_bimestre(evaluacionempleado.getid_bimestre());
		evaluacionempleadoAsignar.setbimestre_descripcion(evaluacionempleado.getbimestre_descripcion());	
		evaluacionempleadoAsignar.setid_mes(evaluacionempleado.getid_mes());
		evaluacionempleadoAsignar.setmes_descripcion(evaluacionempleado.getmes_descripcion());	
		evaluacionempleadoAsignar.setobservacion1(evaluacionempleado.getobservacion1());	
		evaluacionempleadoAsignar.setobservacion2(evaluacionempleado.getobservacion2());	
		evaluacionempleadoAsignar.setobservacion3(evaluacionempleado.getobservacion3());	
		evaluacionempleadoAsignar.setobservacion4(evaluacionempleado.getobservacion4());	
	}
	
	public static void inicializarEvaluacionEmpleado(EvaluacionEmpleado evaluacionempleado) throws Exception {
		try {
				evaluacionempleado.setId(0L);	
					
				evaluacionempleado.setid_empresa(-1L);	
				evaluacionempleado.setid_sucursal(-1L);	
				evaluacionempleado.setid_ejercicio(-1L);	
				evaluacionempleado.setid_periodo(-1L);	
				evaluacionempleado.setid_estructura(-1L);	
				evaluacionempleado.setid_empleado(-1L);	
				evaluacionempleado.setid_empleado_evalua(-1L);	
				evaluacionempleado.setid_tipo_evaluacion_empleado(-1L);	
				evaluacionempleado.setfecha(new Date());	
				evaluacionempleado.setesta_evaluado(false);	
				evaluacionempleado.setid_anio(null);	
				evaluacionempleado.setid_semestre(-1L);	
				evaluacionempleado.setid_trimestre(-1L);	
				evaluacionempleado.setid_bimestre(-1L);	
				evaluacionempleado.setid_mes(null);	
				evaluacionempleado.setobservacion1("");	
				evaluacionempleado.setobservacion2("");	
				evaluacionempleado.setobservacion3("");	
				evaluacionempleado.setobservacion4("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEvaluacionEmpleado(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionEmpleadoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionEmpleadoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionEmpleadoConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionEmpleadoConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionEmpleadoConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionEmpleadoConstantesFunciones.LABEL_IDEMPLEADOEVALUA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionEmpleadoConstantesFunciones.LABEL_IDTIPOEVALUACIONEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionEmpleadoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionEmpleadoConstantesFunciones.LABEL_ESTAEVALUADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionEmpleadoConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionEmpleadoConstantesFunciones.LABEL_IDSEMESTRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionEmpleadoConstantesFunciones.LABEL_IDTRIMESTRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionEmpleadoConstantesFunciones.LABEL_IDBIMESTRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionEmpleadoConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionEmpleadoConstantesFunciones.LABEL_OBSERVACION1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionEmpleadoConstantesFunciones.LABEL_OBSERVACION2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionEmpleadoConstantesFunciones.LABEL_OBSERVACION3);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionEmpleadoConstantesFunciones.LABEL_OBSERVACION4);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEvaluacionEmpleado(String sTipo,Row row,Workbook workbook,EvaluacionEmpleado evaluacionempleado,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionempleado.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionempleado.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionempleado.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionempleado.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionempleado.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionempleado.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionempleado.getempleadoevalua_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionempleado.gettipoevaluacionempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionempleado.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(evaluacionempleado.getesta_evaluado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionempleado.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionempleado.getsemestre_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionempleado.gettrimestre_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionempleado.getbimestre_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionempleado.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionempleado.getobservacion1());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionempleado.getobservacion2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionempleado.getobservacion3());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionempleado.getobservacion4());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEvaluacionEmpleado=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEvaluacionEmpleado() {
		return this.sFinalQueryEvaluacionEmpleado;
	}
	
	public void setsFinalQueryEvaluacionEmpleado(String sFinalQueryEvaluacionEmpleado) {
		this.sFinalQueryEvaluacionEmpleado= sFinalQueryEvaluacionEmpleado;
	}
	
	public Border resaltarSeleccionarEvaluacionEmpleado=null;
	
	public Border setResaltarSeleccionarEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//evaluacionempleadoBeanSwingJInternalFrame.jTtoolBarEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEvaluacionEmpleado= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEvaluacionEmpleado() {
		return this.resaltarSeleccionarEvaluacionEmpleado;
	}
	
	public void setResaltarSeleccionarEvaluacionEmpleado(Border borderResaltarSeleccionarEvaluacionEmpleado) {
		this.resaltarSeleccionarEvaluacionEmpleado= borderResaltarSeleccionarEvaluacionEmpleado;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEvaluacionEmpleado=null;
	public Boolean mostraridEvaluacionEmpleado=true;
	public Boolean activaridEvaluacionEmpleado=true;

	public Border resaltarid_empresaEvaluacionEmpleado=null;
	public Boolean mostrarid_empresaEvaluacionEmpleado=true;
	public Boolean activarid_empresaEvaluacionEmpleado=true;
	public Boolean cargarid_empresaEvaluacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEvaluacionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_sucursalEvaluacionEmpleado=null;
	public Boolean mostrarid_sucursalEvaluacionEmpleado=true;
	public Boolean activarid_sucursalEvaluacionEmpleado=true;
	public Boolean cargarid_sucursalEvaluacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalEvaluacionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_ejercicioEvaluacionEmpleado=null;
	public Boolean mostrarid_ejercicioEvaluacionEmpleado=true;
	public Boolean activarid_ejercicioEvaluacionEmpleado=true;
	public Boolean cargarid_ejercicioEvaluacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioEvaluacionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_periodoEvaluacionEmpleado=null;
	public Boolean mostrarid_periodoEvaluacionEmpleado=true;
	public Boolean activarid_periodoEvaluacionEmpleado=true;
	public Boolean cargarid_periodoEvaluacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoEvaluacionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_estructuraEvaluacionEmpleado=null;
	public Boolean mostrarid_estructuraEvaluacionEmpleado=true;
	public Boolean activarid_estructuraEvaluacionEmpleado=true;
	public Boolean cargarid_estructuraEvaluacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraEvaluacionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_empleadoEvaluacionEmpleado=null;
	public Boolean mostrarid_empleadoEvaluacionEmpleado=true;
	public Boolean activarid_empleadoEvaluacionEmpleado=true;
	public Boolean cargarid_empleadoEvaluacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoEvaluacionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_empleado_evaluaEvaluacionEmpleado=null;
	public Boolean mostrarid_empleado_evaluaEvaluacionEmpleado=true;
	public Boolean activarid_empleado_evaluaEvaluacionEmpleado=true;
	public Boolean cargarid_empleado_evaluaEvaluacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleado_evaluaEvaluacionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_tipo_evaluacion_empleadoEvaluacionEmpleado=null;
	public Boolean mostrarid_tipo_evaluacion_empleadoEvaluacionEmpleado=true;
	public Boolean activarid_tipo_evaluacion_empleadoEvaluacionEmpleado=true;
	public Boolean cargarid_tipo_evaluacion_empleadoEvaluacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_evaluacion_empleadoEvaluacionEmpleado=false;//ConEventDepend=true

	public Border resaltarfechaEvaluacionEmpleado=null;
	public Boolean mostrarfechaEvaluacionEmpleado=true;
	public Boolean activarfechaEvaluacionEmpleado=false;

	public Border resaltaresta_evaluadoEvaluacionEmpleado=null;
	public Boolean mostraresta_evaluadoEvaluacionEmpleado=true;
	public Boolean activaresta_evaluadoEvaluacionEmpleado=true;

	public Border resaltarid_anioEvaluacionEmpleado=null;
	public Boolean mostrarid_anioEvaluacionEmpleado=true;
	public Boolean activarid_anioEvaluacionEmpleado=true;
	public Boolean cargarid_anioEvaluacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioEvaluacionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_semestreEvaluacionEmpleado=null;
	public Boolean mostrarid_semestreEvaluacionEmpleado=true;
	public Boolean activarid_semestreEvaluacionEmpleado=true;
	public Boolean cargarid_semestreEvaluacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_semestreEvaluacionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_trimestreEvaluacionEmpleado=null;
	public Boolean mostrarid_trimestreEvaluacionEmpleado=true;
	public Boolean activarid_trimestreEvaluacionEmpleado=true;
	public Boolean cargarid_trimestreEvaluacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_trimestreEvaluacionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_bimestreEvaluacionEmpleado=null;
	public Boolean mostrarid_bimestreEvaluacionEmpleado=true;
	public Boolean activarid_bimestreEvaluacionEmpleado=true;
	public Boolean cargarid_bimestreEvaluacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bimestreEvaluacionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_mesEvaluacionEmpleado=null;
	public Boolean mostrarid_mesEvaluacionEmpleado=true;
	public Boolean activarid_mesEvaluacionEmpleado=true;
	public Boolean cargarid_mesEvaluacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesEvaluacionEmpleado=false;//ConEventDepend=true

	public Border resaltarobservacion1EvaluacionEmpleado=null;
	public Boolean mostrarobservacion1EvaluacionEmpleado=true;
	public Boolean activarobservacion1EvaluacionEmpleado=true;

	public Border resaltarobservacion2EvaluacionEmpleado=null;
	public Boolean mostrarobservacion2EvaluacionEmpleado=true;
	public Boolean activarobservacion2EvaluacionEmpleado=true;

	public Border resaltarobservacion3EvaluacionEmpleado=null;
	public Boolean mostrarobservacion3EvaluacionEmpleado=true;
	public Boolean activarobservacion3EvaluacionEmpleado=true;

	public Border resaltarobservacion4EvaluacionEmpleado=null;
	public Boolean mostrarobservacion4EvaluacionEmpleado=true;
	public Boolean activarobservacion4EvaluacionEmpleado=true;

	
	

	public Border setResaltaridEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionempleadoBeanSwingJInternalFrame.jTtoolBarEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltaridEvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEvaluacionEmpleado() {
		return this.resaltaridEvaluacionEmpleado;
	}

	public void setResaltaridEvaluacionEmpleado(Border borderResaltar) {
		this.resaltaridEvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostraridEvaluacionEmpleado() {
		return this.mostraridEvaluacionEmpleado;
	}

	public void setMostraridEvaluacionEmpleado(Boolean mostraridEvaluacionEmpleado) {
		this.mostraridEvaluacionEmpleado= mostraridEvaluacionEmpleado;
	}

	public Boolean getActivaridEvaluacionEmpleado() {
		return this.activaridEvaluacionEmpleado;
	}

	public void setActivaridEvaluacionEmpleado(Boolean activaridEvaluacionEmpleado) {
		this.activaridEvaluacionEmpleado= activaridEvaluacionEmpleado;
	}

	public Border setResaltarid_empresaEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionempleadoBeanSwingJInternalFrame.jTtoolBarEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_empresaEvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEvaluacionEmpleado() {
		return this.resaltarid_empresaEvaluacionEmpleado;
	}

	public void setResaltarid_empresaEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarid_empresaEvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_empresaEvaluacionEmpleado() {
		return this.mostrarid_empresaEvaluacionEmpleado;
	}

	public void setMostrarid_empresaEvaluacionEmpleado(Boolean mostrarid_empresaEvaluacionEmpleado) {
		this.mostrarid_empresaEvaluacionEmpleado= mostrarid_empresaEvaluacionEmpleado;
	}

	public Boolean getActivarid_empresaEvaluacionEmpleado() {
		return this.activarid_empresaEvaluacionEmpleado;
	}

	public void setActivarid_empresaEvaluacionEmpleado(Boolean activarid_empresaEvaluacionEmpleado) {
		this.activarid_empresaEvaluacionEmpleado= activarid_empresaEvaluacionEmpleado;
	}

	public Boolean getCargarid_empresaEvaluacionEmpleado() {
		return this.cargarid_empresaEvaluacionEmpleado;
	}

	public void setCargarid_empresaEvaluacionEmpleado(Boolean cargarid_empresaEvaluacionEmpleado) {
		this.cargarid_empresaEvaluacionEmpleado= cargarid_empresaEvaluacionEmpleado;
	}

	public Border setResaltarid_sucursalEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionempleadoBeanSwingJInternalFrame.jTtoolBarEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_sucursalEvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalEvaluacionEmpleado() {
		return this.resaltarid_sucursalEvaluacionEmpleado;
	}

	public void setResaltarid_sucursalEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarid_sucursalEvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_sucursalEvaluacionEmpleado() {
		return this.mostrarid_sucursalEvaluacionEmpleado;
	}

	public void setMostrarid_sucursalEvaluacionEmpleado(Boolean mostrarid_sucursalEvaluacionEmpleado) {
		this.mostrarid_sucursalEvaluacionEmpleado= mostrarid_sucursalEvaluacionEmpleado;
	}

	public Boolean getActivarid_sucursalEvaluacionEmpleado() {
		return this.activarid_sucursalEvaluacionEmpleado;
	}

	public void setActivarid_sucursalEvaluacionEmpleado(Boolean activarid_sucursalEvaluacionEmpleado) {
		this.activarid_sucursalEvaluacionEmpleado= activarid_sucursalEvaluacionEmpleado;
	}

	public Boolean getCargarid_sucursalEvaluacionEmpleado() {
		return this.cargarid_sucursalEvaluacionEmpleado;
	}

	public void setCargarid_sucursalEvaluacionEmpleado(Boolean cargarid_sucursalEvaluacionEmpleado) {
		this.cargarid_sucursalEvaluacionEmpleado= cargarid_sucursalEvaluacionEmpleado;
	}

	public Border setResaltarid_ejercicioEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionempleadoBeanSwingJInternalFrame.jTtoolBarEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioEvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioEvaluacionEmpleado() {
		return this.resaltarid_ejercicioEvaluacionEmpleado;
	}

	public void setResaltarid_ejercicioEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarid_ejercicioEvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioEvaluacionEmpleado() {
		return this.mostrarid_ejercicioEvaluacionEmpleado;
	}

	public void setMostrarid_ejercicioEvaluacionEmpleado(Boolean mostrarid_ejercicioEvaluacionEmpleado) {
		this.mostrarid_ejercicioEvaluacionEmpleado= mostrarid_ejercicioEvaluacionEmpleado;
	}

	public Boolean getActivarid_ejercicioEvaluacionEmpleado() {
		return this.activarid_ejercicioEvaluacionEmpleado;
	}

	public void setActivarid_ejercicioEvaluacionEmpleado(Boolean activarid_ejercicioEvaluacionEmpleado) {
		this.activarid_ejercicioEvaluacionEmpleado= activarid_ejercicioEvaluacionEmpleado;
	}

	public Boolean getCargarid_ejercicioEvaluacionEmpleado() {
		return this.cargarid_ejercicioEvaluacionEmpleado;
	}

	public void setCargarid_ejercicioEvaluacionEmpleado(Boolean cargarid_ejercicioEvaluacionEmpleado) {
		this.cargarid_ejercicioEvaluacionEmpleado= cargarid_ejercicioEvaluacionEmpleado;
	}

	public Border setResaltarid_periodoEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionempleadoBeanSwingJInternalFrame.jTtoolBarEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_periodoEvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoEvaluacionEmpleado() {
		return this.resaltarid_periodoEvaluacionEmpleado;
	}

	public void setResaltarid_periodoEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarid_periodoEvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_periodoEvaluacionEmpleado() {
		return this.mostrarid_periodoEvaluacionEmpleado;
	}

	public void setMostrarid_periodoEvaluacionEmpleado(Boolean mostrarid_periodoEvaluacionEmpleado) {
		this.mostrarid_periodoEvaluacionEmpleado= mostrarid_periodoEvaluacionEmpleado;
	}

	public Boolean getActivarid_periodoEvaluacionEmpleado() {
		return this.activarid_periodoEvaluacionEmpleado;
	}

	public void setActivarid_periodoEvaluacionEmpleado(Boolean activarid_periodoEvaluacionEmpleado) {
		this.activarid_periodoEvaluacionEmpleado= activarid_periodoEvaluacionEmpleado;
	}

	public Boolean getCargarid_periodoEvaluacionEmpleado() {
		return this.cargarid_periodoEvaluacionEmpleado;
	}

	public void setCargarid_periodoEvaluacionEmpleado(Boolean cargarid_periodoEvaluacionEmpleado) {
		this.cargarid_periodoEvaluacionEmpleado= cargarid_periodoEvaluacionEmpleado;
	}

	public Border setResaltarid_estructuraEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionempleadoBeanSwingJInternalFrame.jTtoolBarEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_estructuraEvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraEvaluacionEmpleado() {
		return this.resaltarid_estructuraEvaluacionEmpleado;
	}

	public void setResaltarid_estructuraEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarid_estructuraEvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_estructuraEvaluacionEmpleado() {
		return this.mostrarid_estructuraEvaluacionEmpleado;
	}

	public void setMostrarid_estructuraEvaluacionEmpleado(Boolean mostrarid_estructuraEvaluacionEmpleado) {
		this.mostrarid_estructuraEvaluacionEmpleado= mostrarid_estructuraEvaluacionEmpleado;
	}

	public Boolean getActivarid_estructuraEvaluacionEmpleado() {
		return this.activarid_estructuraEvaluacionEmpleado;
	}

	public void setActivarid_estructuraEvaluacionEmpleado(Boolean activarid_estructuraEvaluacionEmpleado) {
		this.activarid_estructuraEvaluacionEmpleado= activarid_estructuraEvaluacionEmpleado;
	}

	public Boolean getCargarid_estructuraEvaluacionEmpleado() {
		return this.cargarid_estructuraEvaluacionEmpleado;
	}

	public void setCargarid_estructuraEvaluacionEmpleado(Boolean cargarid_estructuraEvaluacionEmpleado) {
		this.cargarid_estructuraEvaluacionEmpleado= cargarid_estructuraEvaluacionEmpleado;
	}

	public Border setResaltarid_empleadoEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionempleadoBeanSwingJInternalFrame.jTtoolBarEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_empleadoEvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoEvaluacionEmpleado() {
		return this.resaltarid_empleadoEvaluacionEmpleado;
	}

	public void setResaltarid_empleadoEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarid_empleadoEvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_empleadoEvaluacionEmpleado() {
		return this.mostrarid_empleadoEvaluacionEmpleado;
	}

	public void setMostrarid_empleadoEvaluacionEmpleado(Boolean mostrarid_empleadoEvaluacionEmpleado) {
		this.mostrarid_empleadoEvaluacionEmpleado= mostrarid_empleadoEvaluacionEmpleado;
	}

	public Boolean getActivarid_empleadoEvaluacionEmpleado() {
		return this.activarid_empleadoEvaluacionEmpleado;
	}

	public void setActivarid_empleadoEvaluacionEmpleado(Boolean activarid_empleadoEvaluacionEmpleado) {
		this.activarid_empleadoEvaluacionEmpleado= activarid_empleadoEvaluacionEmpleado;
	}

	public Boolean getCargarid_empleadoEvaluacionEmpleado() {
		return this.cargarid_empleadoEvaluacionEmpleado;
	}

	public void setCargarid_empleadoEvaluacionEmpleado(Boolean cargarid_empleadoEvaluacionEmpleado) {
		this.cargarid_empleadoEvaluacionEmpleado= cargarid_empleadoEvaluacionEmpleado;
	}

	public Border setResaltarid_empleado_evaluaEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionempleadoBeanSwingJInternalFrame.jTtoolBarEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_empleado_evaluaEvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleado_evaluaEvaluacionEmpleado() {
		return this.resaltarid_empleado_evaluaEvaluacionEmpleado;
	}

	public void setResaltarid_empleado_evaluaEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarid_empleado_evaluaEvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_empleado_evaluaEvaluacionEmpleado() {
		return this.mostrarid_empleado_evaluaEvaluacionEmpleado;
	}

	public void setMostrarid_empleado_evaluaEvaluacionEmpleado(Boolean mostrarid_empleado_evaluaEvaluacionEmpleado) {
		this.mostrarid_empleado_evaluaEvaluacionEmpleado= mostrarid_empleado_evaluaEvaluacionEmpleado;
	}

	public Boolean getActivarid_empleado_evaluaEvaluacionEmpleado() {
		return this.activarid_empleado_evaluaEvaluacionEmpleado;
	}

	public void setActivarid_empleado_evaluaEvaluacionEmpleado(Boolean activarid_empleado_evaluaEvaluacionEmpleado) {
		this.activarid_empleado_evaluaEvaluacionEmpleado= activarid_empleado_evaluaEvaluacionEmpleado;
	}

	public Boolean getCargarid_empleado_evaluaEvaluacionEmpleado() {
		return this.cargarid_empleado_evaluaEvaluacionEmpleado;
	}

	public void setCargarid_empleado_evaluaEvaluacionEmpleado(Boolean cargarid_empleado_evaluaEvaluacionEmpleado) {
		this.cargarid_empleado_evaluaEvaluacionEmpleado= cargarid_empleado_evaluaEvaluacionEmpleado;
	}

	public Border setResaltarid_tipo_evaluacion_empleadoEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionempleadoBeanSwingJInternalFrame.jTtoolBarEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_tipo_evaluacion_empleadoEvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_evaluacion_empleadoEvaluacionEmpleado() {
		return this.resaltarid_tipo_evaluacion_empleadoEvaluacionEmpleado;
	}

	public void setResaltarid_tipo_evaluacion_empleadoEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarid_tipo_evaluacion_empleadoEvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_tipo_evaluacion_empleadoEvaluacionEmpleado() {
		return this.mostrarid_tipo_evaluacion_empleadoEvaluacionEmpleado;
	}

	public void setMostrarid_tipo_evaluacion_empleadoEvaluacionEmpleado(Boolean mostrarid_tipo_evaluacion_empleadoEvaluacionEmpleado) {
		this.mostrarid_tipo_evaluacion_empleadoEvaluacionEmpleado= mostrarid_tipo_evaluacion_empleadoEvaluacionEmpleado;
	}

	public Boolean getActivarid_tipo_evaluacion_empleadoEvaluacionEmpleado() {
		return this.activarid_tipo_evaluacion_empleadoEvaluacionEmpleado;
	}

	public void setActivarid_tipo_evaluacion_empleadoEvaluacionEmpleado(Boolean activarid_tipo_evaluacion_empleadoEvaluacionEmpleado) {
		this.activarid_tipo_evaluacion_empleadoEvaluacionEmpleado= activarid_tipo_evaluacion_empleadoEvaluacionEmpleado;
	}

	public Boolean getCargarid_tipo_evaluacion_empleadoEvaluacionEmpleado() {
		return this.cargarid_tipo_evaluacion_empleadoEvaluacionEmpleado;
	}

	public void setCargarid_tipo_evaluacion_empleadoEvaluacionEmpleado(Boolean cargarid_tipo_evaluacion_empleadoEvaluacionEmpleado) {
		this.cargarid_tipo_evaluacion_empleadoEvaluacionEmpleado= cargarid_tipo_evaluacion_empleadoEvaluacionEmpleado;
	}

	public Border setResaltarfechaEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionempleadoBeanSwingJInternalFrame.jTtoolBarEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarfechaEvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaEvaluacionEmpleado() {
		return this.resaltarfechaEvaluacionEmpleado;
	}

	public void setResaltarfechaEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarfechaEvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarfechaEvaluacionEmpleado() {
		return this.mostrarfechaEvaluacionEmpleado;
	}

	public void setMostrarfechaEvaluacionEmpleado(Boolean mostrarfechaEvaluacionEmpleado) {
		this.mostrarfechaEvaluacionEmpleado= mostrarfechaEvaluacionEmpleado;
	}

	public Boolean getActivarfechaEvaluacionEmpleado() {
		return this.activarfechaEvaluacionEmpleado;
	}

	public void setActivarfechaEvaluacionEmpleado(Boolean activarfechaEvaluacionEmpleado) {
		this.activarfechaEvaluacionEmpleado= activarfechaEvaluacionEmpleado;
	}

	public Border setResaltaresta_evaluadoEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionempleadoBeanSwingJInternalFrame.jTtoolBarEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltaresta_evaluadoEvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_evaluadoEvaluacionEmpleado() {
		return this.resaltaresta_evaluadoEvaluacionEmpleado;
	}

	public void setResaltaresta_evaluadoEvaluacionEmpleado(Border borderResaltar) {
		this.resaltaresta_evaluadoEvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostraresta_evaluadoEvaluacionEmpleado() {
		return this.mostraresta_evaluadoEvaluacionEmpleado;
	}

	public void setMostraresta_evaluadoEvaluacionEmpleado(Boolean mostraresta_evaluadoEvaluacionEmpleado) {
		this.mostraresta_evaluadoEvaluacionEmpleado= mostraresta_evaluadoEvaluacionEmpleado;
	}

	public Boolean getActivaresta_evaluadoEvaluacionEmpleado() {
		return this.activaresta_evaluadoEvaluacionEmpleado;
	}

	public void setActivaresta_evaluadoEvaluacionEmpleado(Boolean activaresta_evaluadoEvaluacionEmpleado) {
		this.activaresta_evaluadoEvaluacionEmpleado= activaresta_evaluadoEvaluacionEmpleado;
	}

	public Border setResaltarid_anioEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionempleadoBeanSwingJInternalFrame.jTtoolBarEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_anioEvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioEvaluacionEmpleado() {
		return this.resaltarid_anioEvaluacionEmpleado;
	}

	public void setResaltarid_anioEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarid_anioEvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_anioEvaluacionEmpleado() {
		return this.mostrarid_anioEvaluacionEmpleado;
	}

	public void setMostrarid_anioEvaluacionEmpleado(Boolean mostrarid_anioEvaluacionEmpleado) {
		this.mostrarid_anioEvaluacionEmpleado= mostrarid_anioEvaluacionEmpleado;
	}

	public Boolean getActivarid_anioEvaluacionEmpleado() {
		return this.activarid_anioEvaluacionEmpleado;
	}

	public void setActivarid_anioEvaluacionEmpleado(Boolean activarid_anioEvaluacionEmpleado) {
		this.activarid_anioEvaluacionEmpleado= activarid_anioEvaluacionEmpleado;
	}

	public Boolean getCargarid_anioEvaluacionEmpleado() {
		return this.cargarid_anioEvaluacionEmpleado;
	}

	public void setCargarid_anioEvaluacionEmpleado(Boolean cargarid_anioEvaluacionEmpleado) {
		this.cargarid_anioEvaluacionEmpleado= cargarid_anioEvaluacionEmpleado;
	}

	public Border setResaltarid_semestreEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionempleadoBeanSwingJInternalFrame.jTtoolBarEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_semestreEvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_semestreEvaluacionEmpleado() {
		return this.resaltarid_semestreEvaluacionEmpleado;
	}

	public void setResaltarid_semestreEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarid_semestreEvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_semestreEvaluacionEmpleado() {
		return this.mostrarid_semestreEvaluacionEmpleado;
	}

	public void setMostrarid_semestreEvaluacionEmpleado(Boolean mostrarid_semestreEvaluacionEmpleado) {
		this.mostrarid_semestreEvaluacionEmpleado= mostrarid_semestreEvaluacionEmpleado;
	}

	public Boolean getActivarid_semestreEvaluacionEmpleado() {
		return this.activarid_semestreEvaluacionEmpleado;
	}

	public void setActivarid_semestreEvaluacionEmpleado(Boolean activarid_semestreEvaluacionEmpleado) {
		this.activarid_semestreEvaluacionEmpleado= activarid_semestreEvaluacionEmpleado;
	}

	public Boolean getCargarid_semestreEvaluacionEmpleado() {
		return this.cargarid_semestreEvaluacionEmpleado;
	}

	public void setCargarid_semestreEvaluacionEmpleado(Boolean cargarid_semestreEvaluacionEmpleado) {
		this.cargarid_semestreEvaluacionEmpleado= cargarid_semestreEvaluacionEmpleado;
	}

	public Border setResaltarid_trimestreEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionempleadoBeanSwingJInternalFrame.jTtoolBarEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_trimestreEvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_trimestreEvaluacionEmpleado() {
		return this.resaltarid_trimestreEvaluacionEmpleado;
	}

	public void setResaltarid_trimestreEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarid_trimestreEvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_trimestreEvaluacionEmpleado() {
		return this.mostrarid_trimestreEvaluacionEmpleado;
	}

	public void setMostrarid_trimestreEvaluacionEmpleado(Boolean mostrarid_trimestreEvaluacionEmpleado) {
		this.mostrarid_trimestreEvaluacionEmpleado= mostrarid_trimestreEvaluacionEmpleado;
	}

	public Boolean getActivarid_trimestreEvaluacionEmpleado() {
		return this.activarid_trimestreEvaluacionEmpleado;
	}

	public void setActivarid_trimestreEvaluacionEmpleado(Boolean activarid_trimestreEvaluacionEmpleado) {
		this.activarid_trimestreEvaluacionEmpleado= activarid_trimestreEvaluacionEmpleado;
	}

	public Boolean getCargarid_trimestreEvaluacionEmpleado() {
		return this.cargarid_trimestreEvaluacionEmpleado;
	}

	public void setCargarid_trimestreEvaluacionEmpleado(Boolean cargarid_trimestreEvaluacionEmpleado) {
		this.cargarid_trimestreEvaluacionEmpleado= cargarid_trimestreEvaluacionEmpleado;
	}

	public Border setResaltarid_bimestreEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionempleadoBeanSwingJInternalFrame.jTtoolBarEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_bimestreEvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bimestreEvaluacionEmpleado() {
		return this.resaltarid_bimestreEvaluacionEmpleado;
	}

	public void setResaltarid_bimestreEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarid_bimestreEvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_bimestreEvaluacionEmpleado() {
		return this.mostrarid_bimestreEvaluacionEmpleado;
	}

	public void setMostrarid_bimestreEvaluacionEmpleado(Boolean mostrarid_bimestreEvaluacionEmpleado) {
		this.mostrarid_bimestreEvaluacionEmpleado= mostrarid_bimestreEvaluacionEmpleado;
	}

	public Boolean getActivarid_bimestreEvaluacionEmpleado() {
		return this.activarid_bimestreEvaluacionEmpleado;
	}

	public void setActivarid_bimestreEvaluacionEmpleado(Boolean activarid_bimestreEvaluacionEmpleado) {
		this.activarid_bimestreEvaluacionEmpleado= activarid_bimestreEvaluacionEmpleado;
	}

	public Boolean getCargarid_bimestreEvaluacionEmpleado() {
		return this.cargarid_bimestreEvaluacionEmpleado;
	}

	public void setCargarid_bimestreEvaluacionEmpleado(Boolean cargarid_bimestreEvaluacionEmpleado) {
		this.cargarid_bimestreEvaluacionEmpleado= cargarid_bimestreEvaluacionEmpleado;
	}

	public Border setResaltarid_mesEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionempleadoBeanSwingJInternalFrame.jTtoolBarEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_mesEvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesEvaluacionEmpleado() {
		return this.resaltarid_mesEvaluacionEmpleado;
	}

	public void setResaltarid_mesEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarid_mesEvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_mesEvaluacionEmpleado() {
		return this.mostrarid_mesEvaluacionEmpleado;
	}

	public void setMostrarid_mesEvaluacionEmpleado(Boolean mostrarid_mesEvaluacionEmpleado) {
		this.mostrarid_mesEvaluacionEmpleado= mostrarid_mesEvaluacionEmpleado;
	}

	public Boolean getActivarid_mesEvaluacionEmpleado() {
		return this.activarid_mesEvaluacionEmpleado;
	}

	public void setActivarid_mesEvaluacionEmpleado(Boolean activarid_mesEvaluacionEmpleado) {
		this.activarid_mesEvaluacionEmpleado= activarid_mesEvaluacionEmpleado;
	}

	public Boolean getCargarid_mesEvaluacionEmpleado() {
		return this.cargarid_mesEvaluacionEmpleado;
	}

	public void setCargarid_mesEvaluacionEmpleado(Boolean cargarid_mesEvaluacionEmpleado) {
		this.cargarid_mesEvaluacionEmpleado= cargarid_mesEvaluacionEmpleado;
	}

	public Border setResaltarobservacion1EvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionempleadoBeanSwingJInternalFrame.jTtoolBarEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarobservacion1EvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobservacion1EvaluacionEmpleado() {
		return this.resaltarobservacion1EvaluacionEmpleado;
	}

	public void setResaltarobservacion1EvaluacionEmpleado(Border borderResaltar) {
		this.resaltarobservacion1EvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarobservacion1EvaluacionEmpleado() {
		return this.mostrarobservacion1EvaluacionEmpleado;
	}

	public void setMostrarobservacion1EvaluacionEmpleado(Boolean mostrarobservacion1EvaluacionEmpleado) {
		this.mostrarobservacion1EvaluacionEmpleado= mostrarobservacion1EvaluacionEmpleado;
	}

	public Boolean getActivarobservacion1EvaluacionEmpleado() {
		return this.activarobservacion1EvaluacionEmpleado;
	}

	public void setActivarobservacion1EvaluacionEmpleado(Boolean activarobservacion1EvaluacionEmpleado) {
		this.activarobservacion1EvaluacionEmpleado= activarobservacion1EvaluacionEmpleado;
	}

	public Border setResaltarobservacion2EvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionempleadoBeanSwingJInternalFrame.jTtoolBarEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarobservacion2EvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobservacion2EvaluacionEmpleado() {
		return this.resaltarobservacion2EvaluacionEmpleado;
	}

	public void setResaltarobservacion2EvaluacionEmpleado(Border borderResaltar) {
		this.resaltarobservacion2EvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarobservacion2EvaluacionEmpleado() {
		return this.mostrarobservacion2EvaluacionEmpleado;
	}

	public void setMostrarobservacion2EvaluacionEmpleado(Boolean mostrarobservacion2EvaluacionEmpleado) {
		this.mostrarobservacion2EvaluacionEmpleado= mostrarobservacion2EvaluacionEmpleado;
	}

	public Boolean getActivarobservacion2EvaluacionEmpleado() {
		return this.activarobservacion2EvaluacionEmpleado;
	}

	public void setActivarobservacion2EvaluacionEmpleado(Boolean activarobservacion2EvaluacionEmpleado) {
		this.activarobservacion2EvaluacionEmpleado= activarobservacion2EvaluacionEmpleado;
	}

	public Border setResaltarobservacion3EvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionempleadoBeanSwingJInternalFrame.jTtoolBarEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarobservacion3EvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobservacion3EvaluacionEmpleado() {
		return this.resaltarobservacion3EvaluacionEmpleado;
	}

	public void setResaltarobservacion3EvaluacionEmpleado(Border borderResaltar) {
		this.resaltarobservacion3EvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarobservacion3EvaluacionEmpleado() {
		return this.mostrarobservacion3EvaluacionEmpleado;
	}

	public void setMostrarobservacion3EvaluacionEmpleado(Boolean mostrarobservacion3EvaluacionEmpleado) {
		this.mostrarobservacion3EvaluacionEmpleado= mostrarobservacion3EvaluacionEmpleado;
	}

	public Boolean getActivarobservacion3EvaluacionEmpleado() {
		return this.activarobservacion3EvaluacionEmpleado;
	}

	public void setActivarobservacion3EvaluacionEmpleado(Boolean activarobservacion3EvaluacionEmpleado) {
		this.activarobservacion3EvaluacionEmpleado= activarobservacion3EvaluacionEmpleado;
	}

	public Border setResaltarobservacion4EvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionempleadoBeanSwingJInternalFrame.jTtoolBarEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarobservacion4EvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobservacion4EvaluacionEmpleado() {
		return this.resaltarobservacion4EvaluacionEmpleado;
	}

	public void setResaltarobservacion4EvaluacionEmpleado(Border borderResaltar) {
		this.resaltarobservacion4EvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarobservacion4EvaluacionEmpleado() {
		return this.mostrarobservacion4EvaluacionEmpleado;
	}

	public void setMostrarobservacion4EvaluacionEmpleado(Boolean mostrarobservacion4EvaluacionEmpleado) {
		this.mostrarobservacion4EvaluacionEmpleado= mostrarobservacion4EvaluacionEmpleado;
	}

	public Boolean getActivarobservacion4EvaluacionEmpleado() {
		return this.activarobservacion4EvaluacionEmpleado;
	}

	public void setActivarobservacion4EvaluacionEmpleado(Boolean activarobservacion4EvaluacionEmpleado) {
		this.activarobservacion4EvaluacionEmpleado= activarobservacion4EvaluacionEmpleado;
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
		
		
		this.setMostraridEvaluacionEmpleado(esInicial);
		this.setMostrarid_empresaEvaluacionEmpleado(esInicial);
		this.setMostrarid_sucursalEvaluacionEmpleado(esInicial);
		this.setMostrarid_ejercicioEvaluacionEmpleado(esInicial);
		this.setMostrarid_periodoEvaluacionEmpleado(esInicial);
		this.setMostrarid_estructuraEvaluacionEmpleado(esInicial);
		this.setMostrarid_empleadoEvaluacionEmpleado(esInicial);
		this.setMostrarid_empleado_evaluaEvaluacionEmpleado(esInicial);
		this.setMostrarid_tipo_evaluacion_empleadoEvaluacionEmpleado(esInicial);
		this.setMostrarfechaEvaluacionEmpleado(esInicial);
		this.setMostraresta_evaluadoEvaluacionEmpleado(esInicial);
		this.setMostrarid_anioEvaluacionEmpleado(esInicial);
		this.setMostrarid_semestreEvaluacionEmpleado(esInicial);
		this.setMostrarid_trimestreEvaluacionEmpleado(esInicial);
		this.setMostrarid_bimestreEvaluacionEmpleado(esInicial);
		this.setMostrarid_mesEvaluacionEmpleado(esInicial);
		this.setMostrarobservacion1EvaluacionEmpleado(esInicial);
		this.setMostrarobservacion2EvaluacionEmpleado(esInicial);
		this.setMostrarobservacion3EvaluacionEmpleado(esInicial);
		this.setMostrarobservacion4EvaluacionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.ID)) {
				this.setMostraridEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDEMPLEADOEVALUA)) {
				this.setMostrarid_empleado_evaluaEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDTIPOEVALUACIONEMPLEADO)) {
				this.setMostrarid_tipo_evaluacion_empleadoEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.FECHA)) {
				this.setMostrarfechaEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.ESTAEVALUADO)) {
				this.setMostraresta_evaluadoEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDSEMESTRE)) {
				this.setMostrarid_semestreEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDTRIMESTRE)) {
				this.setMostrarid_trimestreEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDBIMESTRE)) {
				this.setMostrarid_bimestreEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDMES)) {
				this.setMostrarid_mesEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.OBSERVACION1)) {
				this.setMostrarobservacion1EvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.OBSERVACION2)) {
				this.setMostrarobservacion2EvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.OBSERVACION3)) {
				this.setMostrarobservacion3EvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.OBSERVACION4)) {
				this.setMostrarobservacion4EvaluacionEmpleado(esAsigna);
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
		
		
		this.setActivaridEvaluacionEmpleado(esInicial);
		this.setActivarid_empresaEvaluacionEmpleado(esInicial);
		this.setActivarid_sucursalEvaluacionEmpleado(esInicial);
		this.setActivarid_ejercicioEvaluacionEmpleado(esInicial);
		this.setActivarid_periodoEvaluacionEmpleado(esInicial);
		this.setActivarid_estructuraEvaluacionEmpleado(esInicial);
		this.setActivarid_empleadoEvaluacionEmpleado(esInicial);
		this.setActivarid_empleado_evaluaEvaluacionEmpleado(esInicial);
		this.setActivarid_tipo_evaluacion_empleadoEvaluacionEmpleado(esInicial);
		this.setActivarfechaEvaluacionEmpleado(esInicial);
		this.setActivaresta_evaluadoEvaluacionEmpleado(esInicial);
		this.setActivarid_anioEvaluacionEmpleado(esInicial);
		this.setActivarid_semestreEvaluacionEmpleado(esInicial);
		this.setActivarid_trimestreEvaluacionEmpleado(esInicial);
		this.setActivarid_bimestreEvaluacionEmpleado(esInicial);
		this.setActivarid_mesEvaluacionEmpleado(esInicial);
		this.setActivarobservacion1EvaluacionEmpleado(esInicial);
		this.setActivarobservacion2EvaluacionEmpleado(esInicial);
		this.setActivarobservacion3EvaluacionEmpleado(esInicial);
		this.setActivarobservacion4EvaluacionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.ID)) {
				this.setActivaridEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDEMPLEADOEVALUA)) {
				this.setActivarid_empleado_evaluaEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDTIPOEVALUACIONEMPLEADO)) {
				this.setActivarid_tipo_evaluacion_empleadoEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.FECHA)) {
				this.setActivarfechaEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.ESTAEVALUADO)) {
				this.setActivaresta_evaluadoEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDANIO)) {
				this.setActivarid_anioEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDSEMESTRE)) {
				this.setActivarid_semestreEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDTRIMESTRE)) {
				this.setActivarid_trimestreEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDBIMESTRE)) {
				this.setActivarid_bimestreEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDMES)) {
				this.setActivarid_mesEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.OBSERVACION1)) {
				this.setActivarobservacion1EvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.OBSERVACION2)) {
				this.setActivarobservacion2EvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.OBSERVACION3)) {
				this.setActivarobservacion3EvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.OBSERVACION4)) {
				this.setActivarobservacion4EvaluacionEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEvaluacionEmpleado(esInicial);
		this.setResaltarid_empresaEvaluacionEmpleado(esInicial);
		this.setResaltarid_sucursalEvaluacionEmpleado(esInicial);
		this.setResaltarid_ejercicioEvaluacionEmpleado(esInicial);
		this.setResaltarid_periodoEvaluacionEmpleado(esInicial);
		this.setResaltarid_estructuraEvaluacionEmpleado(esInicial);
		this.setResaltarid_empleadoEvaluacionEmpleado(esInicial);
		this.setResaltarid_empleado_evaluaEvaluacionEmpleado(esInicial);
		this.setResaltarid_tipo_evaluacion_empleadoEvaluacionEmpleado(esInicial);
		this.setResaltarfechaEvaluacionEmpleado(esInicial);
		this.setResaltaresta_evaluadoEvaluacionEmpleado(esInicial);
		this.setResaltarid_anioEvaluacionEmpleado(esInicial);
		this.setResaltarid_semestreEvaluacionEmpleado(esInicial);
		this.setResaltarid_trimestreEvaluacionEmpleado(esInicial);
		this.setResaltarid_bimestreEvaluacionEmpleado(esInicial);
		this.setResaltarid_mesEvaluacionEmpleado(esInicial);
		this.setResaltarobservacion1EvaluacionEmpleado(esInicial);
		this.setResaltarobservacion2EvaluacionEmpleado(esInicial);
		this.setResaltarobservacion3EvaluacionEmpleado(esInicial);
		this.setResaltarobservacion4EvaluacionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.ID)) {
				this.setResaltaridEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDEMPLEADOEVALUA)) {
				this.setResaltarid_empleado_evaluaEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDTIPOEVALUACIONEMPLEADO)) {
				this.setResaltarid_tipo_evaluacion_empleadoEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.FECHA)) {
				this.setResaltarfechaEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.ESTAEVALUADO)) {
				this.setResaltaresta_evaluadoEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDSEMESTRE)) {
				this.setResaltarid_semestreEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDTRIMESTRE)) {
				this.setResaltarid_trimestreEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDBIMESTRE)) {
				this.setResaltarid_bimestreEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.IDMES)) {
				this.setResaltarid_mesEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.OBSERVACION1)) {
				this.setResaltarobservacion1EvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.OBSERVACION2)) {
				this.setResaltarobservacion2EvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.OBSERVACION3)) {
				this.setResaltarobservacion3EvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionEmpleadoConstantesFunciones.OBSERVACION4)) {
				this.setResaltarobservacion4EvaluacionEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarCalificacionEmpleadoEvaluacionEmpleado=null;

	public Border getResaltarCalificacionEmpleadoEvaluacionEmpleado() {
		return this.resaltarCalificacionEmpleadoEvaluacionEmpleado;
	}

	public void setResaltarCalificacionEmpleadoEvaluacionEmpleado(Border borderResaltarCalificacionEmpleado) {
		if(borderResaltarCalificacionEmpleado!=null) {
			this.resaltarCalificacionEmpleadoEvaluacionEmpleado= borderResaltarCalificacionEmpleado;
		}
	}

	public Border setResaltarCalificacionEmpleadoEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarCalificacionEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//evaluacionempleadoBeanSwingJInternalFrame.jTtoolBarEvaluacionEmpleado.setBorder(borderResaltarCalificacionEmpleado);
			
		this.resaltarCalificacionEmpleadoEvaluacionEmpleado= borderResaltarCalificacionEmpleado;

		 return borderResaltarCalificacionEmpleado;
	}



	public Boolean mostrarCalificacionEmpleadoEvaluacionEmpleado=true;

	public Boolean getMostrarCalificacionEmpleadoEvaluacionEmpleado() {
		return this.mostrarCalificacionEmpleadoEvaluacionEmpleado;
	}

	public void setMostrarCalificacionEmpleadoEvaluacionEmpleado(Boolean visibilidadResaltarCalificacionEmpleado) {
		this.mostrarCalificacionEmpleadoEvaluacionEmpleado= visibilidadResaltarCalificacionEmpleado;
	}



	public Boolean activarCalificacionEmpleadoEvaluacionEmpleado=true;

	public Boolean gethabilitarResaltarCalificacionEmpleadoEvaluacionEmpleado() {
		return this.activarCalificacionEmpleadoEvaluacionEmpleado;
	}

	public void setActivarCalificacionEmpleadoEvaluacionEmpleado(Boolean habilitarResaltarCalificacionEmpleado) {
		this.activarCalificacionEmpleadoEvaluacionEmpleado= habilitarResaltarCalificacionEmpleado;
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

		this.setMostrarCalificacionEmpleadoEvaluacionEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CalificacionEmpleado.class)) {
				this.setMostrarCalificacionEmpleadoEvaluacionEmpleado(esAsigna);
				continue;
			}
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

		this.setActivarCalificacionEmpleadoEvaluacionEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CalificacionEmpleado.class)) {
				this.setActivarCalificacionEmpleadoEvaluacionEmpleado(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarCalificacionEmpleadoEvaluacionEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CalificacionEmpleado.class)) {
				this.setResaltarCalificacionEmpleadoEvaluacionEmpleado(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdAnioEvaluacionEmpleado=true;

	public Boolean getMostrarFK_IdAnioEvaluacionEmpleado() {
		return this.mostrarFK_IdAnioEvaluacionEmpleado;
	}

	public void setMostrarFK_IdAnioEvaluacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioEvaluacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBimestreEvaluacionEmpleado=true;

	public Boolean getMostrarFK_IdBimestreEvaluacionEmpleado() {
		return this.mostrarFK_IdBimestreEvaluacionEmpleado;
	}

	public void setMostrarFK_IdBimestreEvaluacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBimestreEvaluacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioEvaluacionEmpleado=true;

	public Boolean getMostrarFK_IdEjercicioEvaluacionEmpleado() {
		return this.mostrarFK_IdEjercicioEvaluacionEmpleado;
	}

	public void setMostrarFK_IdEjercicioEvaluacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioEvaluacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoEvaluacionEmpleado=true;

	public Boolean getMostrarFK_IdEmpleadoEvaluacionEmpleado() {
		return this.mostrarFK_IdEmpleadoEvaluacionEmpleado;
	}

	public void setMostrarFK_IdEmpleadoEvaluacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoEvaluacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoEvaluaEvaluacionEmpleado=true;

	public Boolean getMostrarFK_IdEmpleadoEvaluaEvaluacionEmpleado() {
		return this.mostrarFK_IdEmpleadoEvaluaEvaluacionEmpleado;
	}

	public void setMostrarFK_IdEmpleadoEvaluaEvaluacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoEvaluaEvaluacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaEvaluacionEmpleado=true;

	public Boolean getMostrarFK_IdEmpresaEvaluacionEmpleado() {
		return this.mostrarFK_IdEmpresaEvaluacionEmpleado;
	}

	public void setMostrarFK_IdEmpresaEvaluacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEvaluacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraEvaluacionEmpleado=true;

	public Boolean getMostrarFK_IdEstructuraEvaluacionEmpleado() {
		return this.mostrarFK_IdEstructuraEvaluacionEmpleado;
	}

	public void setMostrarFK_IdEstructuraEvaluacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraEvaluacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesEvaluacionEmpleado=true;

	public Boolean getMostrarFK_IdMesEvaluacionEmpleado() {
		return this.mostrarFK_IdMesEvaluacionEmpleado;
	}

	public void setMostrarFK_IdMesEvaluacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesEvaluacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoEvaluacionEmpleado=true;

	public Boolean getMostrarFK_IdPeriodoEvaluacionEmpleado() {
		return this.mostrarFK_IdPeriodoEvaluacionEmpleado;
	}

	public void setMostrarFK_IdPeriodoEvaluacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoEvaluacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSemestreEvaluacionEmpleado=true;

	public Boolean getMostrarFK_IdSemestreEvaluacionEmpleado() {
		return this.mostrarFK_IdSemestreEvaluacionEmpleado;
	}

	public void setMostrarFK_IdSemestreEvaluacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSemestreEvaluacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalEvaluacionEmpleado=true;

	public Boolean getMostrarFK_IdSucursalEvaluacionEmpleado() {
		return this.mostrarFK_IdSucursalEvaluacionEmpleado;
	}

	public void setMostrarFK_IdSucursalEvaluacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalEvaluacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoEvaluacionEmpleadoEvaluacionEmpleado=true;

	public Boolean getMostrarFK_IdTipoEvaluacionEmpleadoEvaluacionEmpleado() {
		return this.mostrarFK_IdTipoEvaluacionEmpleadoEvaluacionEmpleado;
	}

	public void setMostrarFK_IdTipoEvaluacionEmpleadoEvaluacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoEvaluacionEmpleadoEvaluacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTrimestreEvaluacionEmpleado=true;

	public Boolean getMostrarFK_IdTrimestreEvaluacionEmpleado() {
		return this.mostrarFK_IdTrimestreEvaluacionEmpleado;
	}

	public void setMostrarFK_IdTrimestreEvaluacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTrimestreEvaluacionEmpleado= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAnioEvaluacionEmpleado=true;

	public Boolean getActivarFK_IdAnioEvaluacionEmpleado() {
		return this.activarFK_IdAnioEvaluacionEmpleado;
	}

	public void setActivarFK_IdAnioEvaluacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdAnioEvaluacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdBimestreEvaluacionEmpleado=true;

	public Boolean getActivarFK_IdBimestreEvaluacionEmpleado() {
		return this.activarFK_IdBimestreEvaluacionEmpleado;
	}

	public void setActivarFK_IdBimestreEvaluacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdBimestreEvaluacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioEvaluacionEmpleado=true;

	public Boolean getActivarFK_IdEjercicioEvaluacionEmpleado() {
		return this.activarFK_IdEjercicioEvaluacionEmpleado;
	}

	public void setActivarFK_IdEjercicioEvaluacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioEvaluacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoEvaluacionEmpleado=true;

	public Boolean getActivarFK_IdEmpleadoEvaluacionEmpleado() {
		return this.activarFK_IdEmpleadoEvaluacionEmpleado;
	}

	public void setActivarFK_IdEmpleadoEvaluacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoEvaluacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoEvaluaEvaluacionEmpleado=true;

	public Boolean getActivarFK_IdEmpleadoEvaluaEvaluacionEmpleado() {
		return this.activarFK_IdEmpleadoEvaluaEvaluacionEmpleado;
	}

	public void setActivarFK_IdEmpleadoEvaluaEvaluacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoEvaluaEvaluacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaEvaluacionEmpleado=true;

	public Boolean getActivarFK_IdEmpresaEvaluacionEmpleado() {
		return this.activarFK_IdEmpresaEvaluacionEmpleado;
	}

	public void setActivarFK_IdEmpresaEvaluacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEvaluacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraEvaluacionEmpleado=true;

	public Boolean getActivarFK_IdEstructuraEvaluacionEmpleado() {
		return this.activarFK_IdEstructuraEvaluacionEmpleado;
	}

	public void setActivarFK_IdEstructuraEvaluacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraEvaluacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdMesEvaluacionEmpleado=true;

	public Boolean getActivarFK_IdMesEvaluacionEmpleado() {
		return this.activarFK_IdMesEvaluacionEmpleado;
	}

	public void setActivarFK_IdMesEvaluacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdMesEvaluacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoEvaluacionEmpleado=true;

	public Boolean getActivarFK_IdPeriodoEvaluacionEmpleado() {
		return this.activarFK_IdPeriodoEvaluacionEmpleado;
	}

	public void setActivarFK_IdPeriodoEvaluacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoEvaluacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdSemestreEvaluacionEmpleado=true;

	public Boolean getActivarFK_IdSemestreEvaluacionEmpleado() {
		return this.activarFK_IdSemestreEvaluacionEmpleado;
	}

	public void setActivarFK_IdSemestreEvaluacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdSemestreEvaluacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalEvaluacionEmpleado=true;

	public Boolean getActivarFK_IdSucursalEvaluacionEmpleado() {
		return this.activarFK_IdSucursalEvaluacionEmpleado;
	}

	public void setActivarFK_IdSucursalEvaluacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalEvaluacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoEvaluacionEmpleadoEvaluacionEmpleado=true;

	public Boolean getActivarFK_IdTipoEvaluacionEmpleadoEvaluacionEmpleado() {
		return this.activarFK_IdTipoEvaluacionEmpleadoEvaluacionEmpleado;
	}

	public void setActivarFK_IdTipoEvaluacionEmpleadoEvaluacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdTipoEvaluacionEmpleadoEvaluacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdTrimestreEvaluacionEmpleado=true;

	public Boolean getActivarFK_IdTrimestreEvaluacionEmpleado() {
		return this.activarFK_IdTrimestreEvaluacionEmpleado;
	}

	public void setActivarFK_IdTrimestreEvaluacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdTrimestreEvaluacionEmpleado= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAnioEvaluacionEmpleado=null;

	public Border getResaltarFK_IdAnioEvaluacionEmpleado() {
		return this.resaltarFK_IdAnioEvaluacionEmpleado;
	}

	public void setResaltarFK_IdAnioEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdAnioEvaluacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdAnioEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioEvaluacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdBimestreEvaluacionEmpleado=null;

	public Border getResaltarFK_IdBimestreEvaluacionEmpleado() {
		return this.resaltarFK_IdBimestreEvaluacionEmpleado;
	}

	public void setResaltarFK_IdBimestreEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdBimestreEvaluacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdBimestreEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBimestreEvaluacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioEvaluacionEmpleado=null;

	public Border getResaltarFK_IdEjercicioEvaluacionEmpleado() {
		return this.resaltarFK_IdEjercicioEvaluacionEmpleado;
	}

	public void setResaltarFK_IdEjercicioEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEjercicioEvaluacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioEvaluacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoEvaluacionEmpleado=null;

	public Border getResaltarFK_IdEmpleadoEvaluacionEmpleado() {
		return this.resaltarFK_IdEmpleadoEvaluacionEmpleado;
	}

	public void setResaltarFK_IdEmpleadoEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoEvaluacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoEvaluacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoEvaluaEvaluacionEmpleado=null;

	public Border getResaltarFK_IdEmpleadoEvaluaEvaluacionEmpleado() {
		return this.resaltarFK_IdEmpleadoEvaluaEvaluacionEmpleado;
	}

	public void setResaltarFK_IdEmpleadoEvaluaEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoEvaluaEvaluacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoEvaluaEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoEvaluaEvaluacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaEvaluacionEmpleado=null;

	public Border getResaltarFK_IdEmpresaEvaluacionEmpleado() {
		return this.resaltarFK_IdEmpresaEvaluacionEmpleado;
	}

	public void setResaltarFK_IdEmpresaEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEvaluacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEvaluacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraEvaluacionEmpleado=null;

	public Border getResaltarFK_IdEstructuraEvaluacionEmpleado() {
		return this.resaltarFK_IdEstructuraEvaluacionEmpleado;
	}

	public void setResaltarFK_IdEstructuraEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEstructuraEvaluacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraEvaluacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdMesEvaluacionEmpleado=null;

	public Border getResaltarFK_IdMesEvaluacionEmpleado() {
		return this.resaltarFK_IdMesEvaluacionEmpleado;
	}

	public void setResaltarFK_IdMesEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdMesEvaluacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdMesEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesEvaluacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoEvaluacionEmpleado=null;

	public Border getResaltarFK_IdPeriodoEvaluacionEmpleado() {
		return this.resaltarFK_IdPeriodoEvaluacionEmpleado;
	}

	public void setResaltarFK_IdPeriodoEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdPeriodoEvaluacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoEvaluacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdSemestreEvaluacionEmpleado=null;

	public Border getResaltarFK_IdSemestreEvaluacionEmpleado() {
		return this.resaltarFK_IdSemestreEvaluacionEmpleado;
	}

	public void setResaltarFK_IdSemestreEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdSemestreEvaluacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdSemestreEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSemestreEvaluacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdSucursalEvaluacionEmpleado=null;

	public Border getResaltarFK_IdSucursalEvaluacionEmpleado() {
		return this.resaltarFK_IdSucursalEvaluacionEmpleado;
	}

	public void setResaltarFK_IdSucursalEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdSucursalEvaluacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdSucursalEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalEvaluacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdTipoEvaluacionEmpleadoEvaluacionEmpleado=null;

	public Border getResaltarFK_IdTipoEvaluacionEmpleadoEvaluacionEmpleado() {
		return this.resaltarFK_IdTipoEvaluacionEmpleadoEvaluacionEmpleado;
	}

	public void setResaltarFK_IdTipoEvaluacionEmpleadoEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdTipoEvaluacionEmpleadoEvaluacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdTipoEvaluacionEmpleadoEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoEvaluacionEmpleadoEvaluacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdTrimestreEvaluacionEmpleado=null;

	public Border getResaltarFK_IdTrimestreEvaluacionEmpleado() {
		return this.resaltarFK_IdTrimestreEvaluacionEmpleado;
	}

	public void setResaltarFK_IdTrimestreEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdTrimestreEvaluacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdTrimestreEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionEmpleadoBeanSwingJInternalFrame evaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTrimestreEvaluacionEmpleado= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}