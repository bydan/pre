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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.SubPreguntaEvaluacionConstantesFunciones;
import com.bydan.erp.cartera.util.SubPreguntaEvaluacionParameterReturnGeneral;
//import com.bydan.erp.cartera.util.SubPreguntaEvaluacionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class SubPreguntaEvaluacionConstantesFunciones extends SubPreguntaEvaluacionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="SubPreguntaEvaluacion";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="SubPreguntaEvaluacion"+SubPreguntaEvaluacionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SubPreguntaEvaluacionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SubPreguntaEvaluacionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"_"+SubPreguntaEvaluacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SubPreguntaEvaluacionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"_"+SubPreguntaEvaluacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"_"+SubPreguntaEvaluacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SubPreguntaEvaluacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"_"+SubPreguntaEvaluacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SubPreguntaEvaluacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SubPreguntaEvaluacionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SubPreguntaEvaluacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SubPreguntaEvaluacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SubPreguntaEvaluacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SubPreguntaEvaluacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SubPreguntaEvaluacionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SubPreguntaEvaluacionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SubPreguntaEvaluacionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SubPreguntaEvaluacionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Sub Pregunta Evaluaciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Sub Pregunta Evaluacion";
	public static final String SCLASSWEBTITULO_LOWER="Sub Pregunta Evaluacion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="SubPreguntaEvaluacion";
	public static final String OBJECTNAME="subpreguntaevaluacion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="sub_pregunta_evaluacion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select subpreguntaevaluacion from "+SubPreguntaEvaluacionConstantesFunciones.SPERSISTENCENAME+" subpreguntaevaluacion";
	public static String QUERYSELECTNATIVE="select "+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".id,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".version_row,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".id_empresa,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".id_sucursal,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".id_pregunta_evaluacion,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".id_ejercicio,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".id_periodo,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".orden,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".pregunta,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".porcentaje_si,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".con_factura,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".con_orden_compra,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".con_completo,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".con_a_tiempo from "+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME;//+" as "+SubPreguntaEvaluacionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected SubPreguntaEvaluacionConstantesFuncionesAdditional subpreguntaevaluacionConstantesFuncionesAdditional=null;
	
	public SubPreguntaEvaluacionConstantesFuncionesAdditional getSubPreguntaEvaluacionConstantesFuncionesAdditional() {
		return this.subpreguntaevaluacionConstantesFuncionesAdditional;
	}
	
	public void setSubPreguntaEvaluacionConstantesFuncionesAdditional(SubPreguntaEvaluacionConstantesFuncionesAdditional subpreguntaevaluacionConstantesFuncionesAdditional) {
		try {
			this.subpreguntaevaluacionConstantesFuncionesAdditional=subpreguntaevaluacionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDPREGUNTAEVALUACION= "id_pregunta_evaluacion";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String ORDEN= "orden";
    public static final String PREGUNTA= "pregunta";
    public static final String PORCENTAJESI= "porcentaje_si";
    public static final String CONFACTURA= "con_factura";
    public static final String CONORDENCOMPRA= "con_orden_compra";
    public static final String CONCOMPLETO= "con_completo";
    public static final String CONATIEMPO= "con_a_tiempo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDPREGUNTAEVALUACION= "Pregunta Evaluacion";
		public static final String LABEL_IDPREGUNTAEVALUACION_LOWER= "Pregunta Evaluacion";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_ORDEN= "Orden";
		public static final String LABEL_ORDEN_LOWER= "Orden";
    	public static final String LABEL_PREGUNTA= "Pregunta";
		public static final String LABEL_PREGUNTA_LOWER= "Pregunta";
    	public static final String LABEL_PORCENTAJESI= "Porcentaje Si";
		public static final String LABEL_PORCENTAJESI_LOWER= "Porcentaje Si";
    	public static final String LABEL_CONFACTURA= "Con Factura";
		public static final String LABEL_CONFACTURA_LOWER= "Con Factura";
    	public static final String LABEL_CONORDENCOMPRA= "Con Orden Compra";
		public static final String LABEL_CONORDENCOMPRA_LOWER= "Con Orden Compra";
    	public static final String LABEL_CONCOMPLETO= "Con Completo";
		public static final String LABEL_CONCOMPLETO_LOWER= "Con Completo";
    	public static final String LABEL_CONATIEMPO= "Con A Tiempo";
		public static final String LABEL_CONATIEMPO_LOWER= "Con A Tiempo";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXPREGUNTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPREGUNTA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getSubPreguntaEvaluacionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SubPreguntaEvaluacionConstantesFunciones.IDEMPRESA)) {sLabelColumna=SubPreguntaEvaluacionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SubPreguntaEvaluacionConstantesFunciones.IDSUCURSAL)) {sLabelColumna=SubPreguntaEvaluacionConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(SubPreguntaEvaluacionConstantesFunciones.IDPREGUNTAEVALUACION)) {sLabelColumna=SubPreguntaEvaluacionConstantesFunciones.LABEL_IDPREGUNTAEVALUACION;}
		if(sNombreColumna.equals(SubPreguntaEvaluacionConstantesFunciones.IDEJERCICIO)) {sLabelColumna=SubPreguntaEvaluacionConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(SubPreguntaEvaluacionConstantesFunciones.IDPERIODO)) {sLabelColumna=SubPreguntaEvaluacionConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(SubPreguntaEvaluacionConstantesFunciones.ORDEN)) {sLabelColumna=SubPreguntaEvaluacionConstantesFunciones.LABEL_ORDEN;}
		if(sNombreColumna.equals(SubPreguntaEvaluacionConstantesFunciones.PREGUNTA)) {sLabelColumna=SubPreguntaEvaluacionConstantesFunciones.LABEL_PREGUNTA;}
		if(sNombreColumna.equals(SubPreguntaEvaluacionConstantesFunciones.PORCENTAJESI)) {sLabelColumna=SubPreguntaEvaluacionConstantesFunciones.LABEL_PORCENTAJESI;}
		if(sNombreColumna.equals(SubPreguntaEvaluacionConstantesFunciones.CONFACTURA)) {sLabelColumna=SubPreguntaEvaluacionConstantesFunciones.LABEL_CONFACTURA;}
		if(sNombreColumna.equals(SubPreguntaEvaluacionConstantesFunciones.CONORDENCOMPRA)) {sLabelColumna=SubPreguntaEvaluacionConstantesFunciones.LABEL_CONORDENCOMPRA;}
		if(sNombreColumna.equals(SubPreguntaEvaluacionConstantesFunciones.CONCOMPLETO)) {sLabelColumna=SubPreguntaEvaluacionConstantesFunciones.LABEL_CONCOMPLETO;}
		if(sNombreColumna.equals(SubPreguntaEvaluacionConstantesFunciones.CONATIEMPO)) {sLabelColumna=SubPreguntaEvaluacionConstantesFunciones.LABEL_CONATIEMPO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_facturaDescripcion(SubPreguntaEvaluacion subpreguntaevaluacion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!subpreguntaevaluacion.getcon_factura()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_facturaHtmlDescripcion(SubPreguntaEvaluacion subpreguntaevaluacion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(subpreguntaevaluacion.getId(),subpreguntaevaluacion.getcon_factura());

		return sDescripcion;
	}	
		
	public static String getcon_orden_compraDescripcion(SubPreguntaEvaluacion subpreguntaevaluacion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!subpreguntaevaluacion.getcon_orden_compra()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_orden_compraHtmlDescripcion(SubPreguntaEvaluacion subpreguntaevaluacion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(subpreguntaevaluacion.getId(),subpreguntaevaluacion.getcon_orden_compra());

		return sDescripcion;
	}	
		
	public static String getcon_completoDescripcion(SubPreguntaEvaluacion subpreguntaevaluacion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!subpreguntaevaluacion.getcon_completo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_completoHtmlDescripcion(SubPreguntaEvaluacion subpreguntaevaluacion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(subpreguntaevaluacion.getId(),subpreguntaevaluacion.getcon_completo());

		return sDescripcion;
	}	
		
	public static String getcon_a_tiempoDescripcion(SubPreguntaEvaluacion subpreguntaevaluacion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!subpreguntaevaluacion.getcon_a_tiempo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_a_tiempoHtmlDescripcion(SubPreguntaEvaluacion subpreguntaevaluacion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(subpreguntaevaluacion.getId(),subpreguntaevaluacion.getcon_a_tiempo());

		return sDescripcion;
	}	
	
	public static String getSubPreguntaEvaluacionDescripcion(SubPreguntaEvaluacion subpreguntaevaluacion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(subpreguntaevaluacion !=null/* && subpreguntaevaluacion.getId()!=0*/) {
			if(subpreguntaevaluacion.getId()!=null) {
				sDescripcion=subpreguntaevaluacion.getId().toString();
			}//subpreguntaevaluacionsubpreguntaevaluacion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getSubPreguntaEvaluacionDescripcionDetallado(SubPreguntaEvaluacion subpreguntaevaluacion) {
		String sDescripcion="";
			
		sDescripcion+=SubPreguntaEvaluacionConstantesFunciones.ID+"=";
		sDescripcion+=subpreguntaevaluacion.getId().toString()+",";
		sDescripcion+=SubPreguntaEvaluacionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=subpreguntaevaluacion.getVersionRow().toString()+",";
		sDescripcion+=SubPreguntaEvaluacionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=subpreguntaevaluacion.getid_empresa().toString()+",";
		sDescripcion+=SubPreguntaEvaluacionConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=subpreguntaevaluacion.getid_sucursal().toString()+",";
		sDescripcion+=SubPreguntaEvaluacionConstantesFunciones.IDPREGUNTAEVALUACION+"=";
		sDescripcion+=subpreguntaevaluacion.getid_pregunta_evaluacion().toString()+",";
		sDescripcion+=SubPreguntaEvaluacionConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=subpreguntaevaluacion.getid_ejercicio().toString()+",";
		sDescripcion+=SubPreguntaEvaluacionConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=subpreguntaevaluacion.getid_periodo().toString()+",";
		sDescripcion+=SubPreguntaEvaluacionConstantesFunciones.ORDEN+"=";
		sDescripcion+=subpreguntaevaluacion.getorden().toString()+",";
		sDescripcion+=SubPreguntaEvaluacionConstantesFunciones.PREGUNTA+"=";
		sDescripcion+=subpreguntaevaluacion.getpregunta()+",";
		sDescripcion+=SubPreguntaEvaluacionConstantesFunciones.PORCENTAJESI+"=";
		sDescripcion+=subpreguntaevaluacion.getporcentaje_si().toString()+",";
		sDescripcion+=SubPreguntaEvaluacionConstantesFunciones.CONFACTURA+"=";
		sDescripcion+=subpreguntaevaluacion.getcon_factura().toString()+",";
		sDescripcion+=SubPreguntaEvaluacionConstantesFunciones.CONORDENCOMPRA+"=";
		sDescripcion+=subpreguntaevaluacion.getcon_orden_compra().toString()+",";
		sDescripcion+=SubPreguntaEvaluacionConstantesFunciones.CONCOMPLETO+"=";
		sDescripcion+=subpreguntaevaluacion.getcon_completo().toString()+",";
		sDescripcion+=SubPreguntaEvaluacionConstantesFunciones.CONATIEMPO+"=";
		sDescripcion+=subpreguntaevaluacion.getcon_a_tiempo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setSubPreguntaEvaluacionDescripcion(SubPreguntaEvaluacion subpreguntaevaluacion,String sValor) throws Exception {			
		if(subpreguntaevaluacion !=null) {
			//subpreguntaevaluacionsubpreguntaevaluacion.getId().toString();
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

	public static String getPreguntaEvaluacionDescripcion(PreguntaEvaluacion preguntaevaluacion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(preguntaevaluacion!=null/*&&preguntaevaluacion.getId()>0*/) {
			sDescripcion=PreguntaEvaluacionConstantesFunciones.getPreguntaEvaluacionDescripcion(preguntaevaluacion);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdPreguntaEvaluacion")) {
			sNombreIndice="Tipo=  Por Pregunta Evaluacion";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
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

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPreguntaEvaluacion(Long id_pregunta_evaluacion) {
		String sDetalleIndice=" Parametros->";
		if(id_pregunta_evaluacion!=null) {sDetalleIndice+=" Codigo Unico De Pregunta Evaluacion="+id_pregunta_evaluacion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosSubPreguntaEvaluacion(SubPreguntaEvaluacion subpreguntaevaluacion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		subpreguntaevaluacion.setpregunta(subpreguntaevaluacion.getpregunta().trim());
	}
	
	public static void quitarEspaciosSubPreguntaEvaluacions(List<SubPreguntaEvaluacion> subpreguntaevaluacions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SubPreguntaEvaluacion subpreguntaevaluacion: subpreguntaevaluacions) {
			subpreguntaevaluacion.setpregunta(subpreguntaevaluacion.getpregunta().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSubPreguntaEvaluacion(SubPreguntaEvaluacion subpreguntaevaluacion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && subpreguntaevaluacion.getConCambioAuxiliar()) {
			subpreguntaevaluacion.setIsDeleted(subpreguntaevaluacion.getIsDeletedAuxiliar());	
			subpreguntaevaluacion.setIsNew(subpreguntaevaluacion.getIsNewAuxiliar());	
			subpreguntaevaluacion.setIsChanged(subpreguntaevaluacion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			subpreguntaevaluacion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			subpreguntaevaluacion.setIsDeletedAuxiliar(false);	
			subpreguntaevaluacion.setIsNewAuxiliar(false);	
			subpreguntaevaluacion.setIsChangedAuxiliar(false);
			
			subpreguntaevaluacion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSubPreguntaEvaluacions(List<SubPreguntaEvaluacion> subpreguntaevaluacions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(SubPreguntaEvaluacion subpreguntaevaluacion : subpreguntaevaluacions) {
			if(conAsignarBase && subpreguntaevaluacion.getConCambioAuxiliar()) {
				subpreguntaevaluacion.setIsDeleted(subpreguntaevaluacion.getIsDeletedAuxiliar());	
				subpreguntaevaluacion.setIsNew(subpreguntaevaluacion.getIsNewAuxiliar());	
				subpreguntaevaluacion.setIsChanged(subpreguntaevaluacion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				subpreguntaevaluacion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				subpreguntaevaluacion.setIsDeletedAuxiliar(false);	
				subpreguntaevaluacion.setIsNewAuxiliar(false);	
				subpreguntaevaluacion.setIsChangedAuxiliar(false);
				
				subpreguntaevaluacion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSubPreguntaEvaluacion(SubPreguntaEvaluacion subpreguntaevaluacion,Boolean conEnteros) throws Exception  {
		subpreguntaevaluacion.setporcentaje_si(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			subpreguntaevaluacion.setorden(0);
		}
	}		
	
	public static void InicializarValoresSubPreguntaEvaluacions(List<SubPreguntaEvaluacion> subpreguntaevaluacions,Boolean conEnteros) throws Exception  {
		
		for(SubPreguntaEvaluacion subpreguntaevaluacion: subpreguntaevaluacions) {
			subpreguntaevaluacion.setporcentaje_si(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				subpreguntaevaluacion.setorden(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaSubPreguntaEvaluacion(List<SubPreguntaEvaluacion> subpreguntaevaluacions,SubPreguntaEvaluacion subpreguntaevaluacionAux) throws Exception  {
		SubPreguntaEvaluacionConstantesFunciones.InicializarValoresSubPreguntaEvaluacion(subpreguntaevaluacionAux,true);
		
		for(SubPreguntaEvaluacion subpreguntaevaluacion: subpreguntaevaluacions) {
			if(subpreguntaevaluacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			subpreguntaevaluacionAux.setorden(subpreguntaevaluacionAux.getorden()+subpreguntaevaluacion.getorden());			
			subpreguntaevaluacionAux.setporcentaje_si(subpreguntaevaluacionAux.getporcentaje_si()+subpreguntaevaluacion.getporcentaje_si());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSubPreguntaEvaluacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SubPreguntaEvaluacionConstantesFunciones.getArrayColumnasGlobalesSubPreguntaEvaluacion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSubPreguntaEvaluacion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SubPreguntaEvaluacionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SubPreguntaEvaluacionConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SubPreguntaEvaluacionConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SubPreguntaEvaluacionConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SubPreguntaEvaluacionConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SubPreguntaEvaluacionConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SubPreguntaEvaluacionConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SubPreguntaEvaluacionConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSubPreguntaEvaluacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SubPreguntaEvaluacion> subpreguntaevaluacions,SubPreguntaEvaluacion subpreguntaevaluacion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SubPreguntaEvaluacion subpreguntaevaluacionAux: subpreguntaevaluacions) {
			if(subpreguntaevaluacionAux!=null && subpreguntaevaluacion!=null) {
				if((subpreguntaevaluacionAux.getId()==null && subpreguntaevaluacion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(subpreguntaevaluacionAux.getId()!=null && subpreguntaevaluacion.getId()!=null){
					if(subpreguntaevaluacionAux.getId().equals(subpreguntaevaluacion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSubPreguntaEvaluacion(List<SubPreguntaEvaluacion> subpreguntaevaluacions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentaje_siTotal=0.0;
	
		for(SubPreguntaEvaluacion subpreguntaevaluacion: subpreguntaevaluacions) {			
			if(subpreguntaevaluacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentaje_siTotal+=subpreguntaevaluacion.getporcentaje_si();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SubPreguntaEvaluacionConstantesFunciones.PORCENTAJESI);
		datoGeneral.setsDescripcion(SubPreguntaEvaluacionConstantesFunciones.LABEL_PORCENTAJESI);
		datoGeneral.setdValorDouble(porcentaje_siTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSubPreguntaEvaluacion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SubPreguntaEvaluacionConstantesFunciones.LABEL_ID, SubPreguntaEvaluacionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubPreguntaEvaluacionConstantesFunciones.LABEL_VERSIONROW, SubPreguntaEvaluacionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubPreguntaEvaluacionConstantesFunciones.LABEL_IDEMPRESA, SubPreguntaEvaluacionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubPreguntaEvaluacionConstantesFunciones.LABEL_IDSUCURSAL, SubPreguntaEvaluacionConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubPreguntaEvaluacionConstantesFunciones.LABEL_IDPREGUNTAEVALUACION, SubPreguntaEvaluacionConstantesFunciones.IDPREGUNTAEVALUACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubPreguntaEvaluacionConstantesFunciones.LABEL_IDEJERCICIO, SubPreguntaEvaluacionConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubPreguntaEvaluacionConstantesFunciones.LABEL_IDPERIODO, SubPreguntaEvaluacionConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubPreguntaEvaluacionConstantesFunciones.LABEL_ORDEN, SubPreguntaEvaluacionConstantesFunciones.ORDEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubPreguntaEvaluacionConstantesFunciones.LABEL_PREGUNTA, SubPreguntaEvaluacionConstantesFunciones.PREGUNTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubPreguntaEvaluacionConstantesFunciones.LABEL_PORCENTAJESI, SubPreguntaEvaluacionConstantesFunciones.PORCENTAJESI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubPreguntaEvaluacionConstantesFunciones.LABEL_CONFACTURA, SubPreguntaEvaluacionConstantesFunciones.CONFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubPreguntaEvaluacionConstantesFunciones.LABEL_CONORDENCOMPRA, SubPreguntaEvaluacionConstantesFunciones.CONORDENCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubPreguntaEvaluacionConstantesFunciones.LABEL_CONCOMPLETO, SubPreguntaEvaluacionConstantesFunciones.CONCOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubPreguntaEvaluacionConstantesFunciones.LABEL_CONATIEMPO, SubPreguntaEvaluacionConstantesFunciones.CONATIEMPO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSubPreguntaEvaluacion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SubPreguntaEvaluacionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubPreguntaEvaluacionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubPreguntaEvaluacionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubPreguntaEvaluacionConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubPreguntaEvaluacionConstantesFunciones.IDPREGUNTAEVALUACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubPreguntaEvaluacionConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubPreguntaEvaluacionConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubPreguntaEvaluacionConstantesFunciones.ORDEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubPreguntaEvaluacionConstantesFunciones.PREGUNTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubPreguntaEvaluacionConstantesFunciones.PORCENTAJESI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubPreguntaEvaluacionConstantesFunciones.CONFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubPreguntaEvaluacionConstantesFunciones.CONORDENCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubPreguntaEvaluacionConstantesFunciones.CONCOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubPreguntaEvaluacionConstantesFunciones.CONATIEMPO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSubPreguntaEvaluacion() throws Exception  {
		return SubPreguntaEvaluacionConstantesFunciones.getTiposSeleccionarSubPreguntaEvaluacion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSubPreguntaEvaluacion(Boolean conFk) throws Exception  {
		return SubPreguntaEvaluacionConstantesFunciones.getTiposSeleccionarSubPreguntaEvaluacion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSubPreguntaEvaluacion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubPreguntaEvaluacionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SubPreguntaEvaluacionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubPreguntaEvaluacionConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(SubPreguntaEvaluacionConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubPreguntaEvaluacionConstantesFunciones.LABEL_IDPREGUNTAEVALUACION);
			reporte.setsDescripcion(SubPreguntaEvaluacionConstantesFunciones.LABEL_IDPREGUNTAEVALUACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubPreguntaEvaluacionConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(SubPreguntaEvaluacionConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubPreguntaEvaluacionConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(SubPreguntaEvaluacionConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubPreguntaEvaluacionConstantesFunciones.LABEL_ORDEN);
			reporte.setsDescripcion(SubPreguntaEvaluacionConstantesFunciones.LABEL_ORDEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubPreguntaEvaluacionConstantesFunciones.LABEL_PREGUNTA);
			reporte.setsDescripcion(SubPreguntaEvaluacionConstantesFunciones.LABEL_PREGUNTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubPreguntaEvaluacionConstantesFunciones.LABEL_PORCENTAJESI);
			reporte.setsDescripcion(SubPreguntaEvaluacionConstantesFunciones.LABEL_PORCENTAJESI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubPreguntaEvaluacionConstantesFunciones.LABEL_CONFACTURA);
			reporte.setsDescripcion(SubPreguntaEvaluacionConstantesFunciones.LABEL_CONFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubPreguntaEvaluacionConstantesFunciones.LABEL_CONORDENCOMPRA);
			reporte.setsDescripcion(SubPreguntaEvaluacionConstantesFunciones.LABEL_CONORDENCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubPreguntaEvaluacionConstantesFunciones.LABEL_CONCOMPLETO);
			reporte.setsDescripcion(SubPreguntaEvaluacionConstantesFunciones.LABEL_CONCOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubPreguntaEvaluacionConstantesFunciones.LABEL_CONATIEMPO);
			reporte.setsDescripcion(SubPreguntaEvaluacionConstantesFunciones.LABEL_CONATIEMPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSubPreguntaEvaluacion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(SubPreguntaEvaluacion subpreguntaevaluacionAux) throws Exception {
		
			subpreguntaevaluacionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(subpreguntaevaluacionAux.getEmpresa()));
			subpreguntaevaluacionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(subpreguntaevaluacionAux.getSucursal()));
			subpreguntaevaluacionAux.setpreguntaevaluacion_descripcion(PreguntaEvaluacionConstantesFunciones.getPreguntaEvaluacionDescripcion(subpreguntaevaluacionAux.getPreguntaEvaluacion()));
			subpreguntaevaluacionAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(subpreguntaevaluacionAux.getEjercicio()));
			subpreguntaevaluacionAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(subpreguntaevaluacionAux.getPeriodo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(List<SubPreguntaEvaluacion> subpreguntaevaluacionsTemp) throws Exception {
		for(SubPreguntaEvaluacion subpreguntaevaluacionAux:subpreguntaevaluacionsTemp) {
			
			subpreguntaevaluacionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(subpreguntaevaluacionAux.getEmpresa()));
			subpreguntaevaluacionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(subpreguntaevaluacionAux.getSucursal()));
			subpreguntaevaluacionAux.setpreguntaevaluacion_descripcion(PreguntaEvaluacionConstantesFunciones.getPreguntaEvaluacionDescripcion(subpreguntaevaluacionAux.getPreguntaEvaluacion()));
			subpreguntaevaluacionAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(subpreguntaevaluacionAux.getEjercicio()));
			subpreguntaevaluacionAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(subpreguntaevaluacionAux.getPeriodo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSubPreguntaEvaluacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(PreguntaEvaluacion.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				
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
					if(clas.clas.equals(PreguntaEvaluacion.class)) {
						classes.add(new Classe(PreguntaEvaluacion.class));
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSubPreguntaEvaluacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(PreguntaEvaluacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PreguntaEvaluacion.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
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

					if(PreguntaEvaluacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PreguntaEvaluacion.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSubPreguntaEvaluacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SubPreguntaEvaluacionConstantesFunciones.getClassesRelationshipsOfSubPreguntaEvaluacion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSubPreguntaEvaluacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleEvaluacionProveedor.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleEvaluacionProveedor.class)) {
						classes.add(new Classe(DetalleEvaluacionProveedor.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSubPreguntaEvaluacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SubPreguntaEvaluacionConstantesFunciones.getClassesRelationshipsFromStringsOfSubPreguntaEvaluacion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSubPreguntaEvaluacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleEvaluacionProveedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleEvaluacionProveedor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleEvaluacionProveedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleEvaluacionProveedor.class)); continue;
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
	public static void actualizarLista(SubPreguntaEvaluacion subpreguntaevaluacion,List<SubPreguntaEvaluacion> subpreguntaevaluacions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			SubPreguntaEvaluacion subpreguntaevaluacionEncontrado=null;
			
			for(SubPreguntaEvaluacion subpreguntaevaluacionLocal:subpreguntaevaluacions) {
				if(subpreguntaevaluacionLocal.getId().equals(subpreguntaevaluacion.getId())) {
					subpreguntaevaluacionEncontrado=subpreguntaevaluacionLocal;
					
					subpreguntaevaluacionLocal.setIsChanged(subpreguntaevaluacion.getIsChanged());
					subpreguntaevaluacionLocal.setIsNew(subpreguntaevaluacion.getIsNew());
					subpreguntaevaluacionLocal.setIsDeleted(subpreguntaevaluacion.getIsDeleted());
					
					subpreguntaevaluacionLocal.setGeneralEntityOriginal(subpreguntaevaluacion.getGeneralEntityOriginal());
					
					subpreguntaevaluacionLocal.setId(subpreguntaevaluacion.getId());	
					subpreguntaevaluacionLocal.setVersionRow(subpreguntaevaluacion.getVersionRow());	
					subpreguntaevaluacionLocal.setid_empresa(subpreguntaevaluacion.getid_empresa());	
					subpreguntaevaluacionLocal.setid_sucursal(subpreguntaevaluacion.getid_sucursal());	
					subpreguntaevaluacionLocal.setid_pregunta_evaluacion(subpreguntaevaluacion.getid_pregunta_evaluacion());	
					subpreguntaevaluacionLocal.setid_ejercicio(subpreguntaevaluacion.getid_ejercicio());	
					subpreguntaevaluacionLocal.setid_periodo(subpreguntaevaluacion.getid_periodo());	
					subpreguntaevaluacionLocal.setorden(subpreguntaevaluacion.getorden());	
					subpreguntaevaluacionLocal.setpregunta(subpreguntaevaluacion.getpregunta());	
					subpreguntaevaluacionLocal.setporcentaje_si(subpreguntaevaluacion.getporcentaje_si());	
					subpreguntaevaluacionLocal.setcon_factura(subpreguntaevaluacion.getcon_factura());	
					subpreguntaevaluacionLocal.setcon_orden_compra(subpreguntaevaluacion.getcon_orden_compra());	
					subpreguntaevaluacionLocal.setcon_completo(subpreguntaevaluacion.getcon_completo());	
					subpreguntaevaluacionLocal.setcon_a_tiempo(subpreguntaevaluacion.getcon_a_tiempo());	
					
					
					subpreguntaevaluacionLocal.setDetalleEvaluacionProveedors(subpreguntaevaluacion.getDetalleEvaluacionProveedors());
					
					existe=true;
					break;
				}
			}
			
			if(!subpreguntaevaluacion.getIsDeleted()) {
				if(!existe) {
					subpreguntaevaluacions.add(subpreguntaevaluacion);
				}
			} else {
				if(subpreguntaevaluacionEncontrado!=null && permiteQuitar)  {
					subpreguntaevaluacions.remove(subpreguntaevaluacionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(SubPreguntaEvaluacion subpreguntaevaluacion,List<SubPreguntaEvaluacion> subpreguntaevaluacions) throws Exception {
		try	{			
			for(SubPreguntaEvaluacion subpreguntaevaluacionLocal:subpreguntaevaluacions) {
				if(subpreguntaevaluacionLocal.getId().equals(subpreguntaevaluacion.getId())) {
					subpreguntaevaluacionLocal.setIsSelected(subpreguntaevaluacion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSubPreguntaEvaluacion(List<SubPreguntaEvaluacion> subpreguntaevaluacionsAux) throws Exception {
		//this.subpreguntaevaluacionsAux=subpreguntaevaluacionsAux;
		
		for(SubPreguntaEvaluacion subpreguntaevaluacionAux:subpreguntaevaluacionsAux) {
			if(subpreguntaevaluacionAux.getIsChanged()) {
				subpreguntaevaluacionAux.setIsChanged(false);
			}		
			
			if(subpreguntaevaluacionAux.getIsNew()) {
				subpreguntaevaluacionAux.setIsNew(false);
			}	
			
			if(subpreguntaevaluacionAux.getIsDeleted()) {
				subpreguntaevaluacionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSubPreguntaEvaluacion(SubPreguntaEvaluacion subpreguntaevaluacionAux) throws Exception {
		//this.subpreguntaevaluacionAux=subpreguntaevaluacionAux;
		
			if(subpreguntaevaluacionAux.getIsChanged()) {
				subpreguntaevaluacionAux.setIsChanged(false);
			}		
			
			if(subpreguntaevaluacionAux.getIsNew()) {
				subpreguntaevaluacionAux.setIsNew(false);
			}	
			
			if(subpreguntaevaluacionAux.getIsDeleted()) {
				subpreguntaevaluacionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(SubPreguntaEvaluacion subpreguntaevaluacionAsignar,SubPreguntaEvaluacion subpreguntaevaluacion) throws Exception {
		subpreguntaevaluacionAsignar.setId(subpreguntaevaluacion.getId());	
		subpreguntaevaluacionAsignar.setVersionRow(subpreguntaevaluacion.getVersionRow());	
		subpreguntaevaluacionAsignar.setid_empresa(subpreguntaevaluacion.getid_empresa());
		subpreguntaevaluacionAsignar.setempresa_descripcion(subpreguntaevaluacion.getempresa_descripcion());	
		subpreguntaevaluacionAsignar.setid_sucursal(subpreguntaevaluacion.getid_sucursal());
		subpreguntaevaluacionAsignar.setsucursal_descripcion(subpreguntaevaluacion.getsucursal_descripcion());	
		subpreguntaevaluacionAsignar.setid_pregunta_evaluacion(subpreguntaevaluacion.getid_pregunta_evaluacion());
		subpreguntaevaluacionAsignar.setpreguntaevaluacion_descripcion(subpreguntaevaluacion.getpreguntaevaluacion_descripcion());	
		subpreguntaevaluacionAsignar.setid_ejercicio(subpreguntaevaluacion.getid_ejercicio());
		subpreguntaevaluacionAsignar.setejercicio_descripcion(subpreguntaevaluacion.getejercicio_descripcion());	
		subpreguntaevaluacionAsignar.setid_periodo(subpreguntaevaluacion.getid_periodo());
		subpreguntaevaluacionAsignar.setperiodo_descripcion(subpreguntaevaluacion.getperiodo_descripcion());	
		subpreguntaevaluacionAsignar.setorden(subpreguntaevaluacion.getorden());	
		subpreguntaevaluacionAsignar.setpregunta(subpreguntaevaluacion.getpregunta());	
		subpreguntaevaluacionAsignar.setporcentaje_si(subpreguntaevaluacion.getporcentaje_si());	
		subpreguntaevaluacionAsignar.setcon_factura(subpreguntaevaluacion.getcon_factura());	
		subpreguntaevaluacionAsignar.setcon_orden_compra(subpreguntaevaluacion.getcon_orden_compra());	
		subpreguntaevaluacionAsignar.setcon_completo(subpreguntaevaluacion.getcon_completo());	
		subpreguntaevaluacionAsignar.setcon_a_tiempo(subpreguntaevaluacion.getcon_a_tiempo());	
	}
	
	public static void inicializarSubPreguntaEvaluacion(SubPreguntaEvaluacion subpreguntaevaluacion) throws Exception {
		try {
				subpreguntaevaluacion.setId(0L);	
					
				subpreguntaevaluacion.setid_empresa(-1L);	
				subpreguntaevaluacion.setid_sucursal(-1L);	
				subpreguntaevaluacion.setid_pregunta_evaluacion(-1L);	
				subpreguntaevaluacion.setid_ejercicio(-1L);	
				subpreguntaevaluacion.setid_periodo(-1L);	
				subpreguntaevaluacion.setorden(0);	
				subpreguntaevaluacion.setpregunta("");	
				subpreguntaevaluacion.setporcentaje_si(0.0);	
				subpreguntaevaluacion.setcon_factura(false);	
				subpreguntaevaluacion.setcon_orden_compra(false);	
				subpreguntaevaluacion.setcon_completo(false);	
				subpreguntaevaluacion.setcon_a_tiempo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSubPreguntaEvaluacion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SubPreguntaEvaluacionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubPreguntaEvaluacionConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubPreguntaEvaluacionConstantesFunciones.LABEL_IDPREGUNTAEVALUACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubPreguntaEvaluacionConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubPreguntaEvaluacionConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubPreguntaEvaluacionConstantesFunciones.LABEL_ORDEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubPreguntaEvaluacionConstantesFunciones.LABEL_PREGUNTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubPreguntaEvaluacionConstantesFunciones.LABEL_PORCENTAJESI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubPreguntaEvaluacionConstantesFunciones.LABEL_CONFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubPreguntaEvaluacionConstantesFunciones.LABEL_CONORDENCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubPreguntaEvaluacionConstantesFunciones.LABEL_CONCOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubPreguntaEvaluacionConstantesFunciones.LABEL_CONATIEMPO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSubPreguntaEvaluacion(String sTipo,Row row,Workbook workbook,SubPreguntaEvaluacion subpreguntaevaluacion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(subpreguntaevaluacion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subpreguntaevaluacion.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subpreguntaevaluacion.getpreguntaevaluacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subpreguntaevaluacion.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subpreguntaevaluacion.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subpreguntaevaluacion.getorden());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subpreguntaevaluacion.getpregunta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subpreguntaevaluacion.getporcentaje_si());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(subpreguntaevaluacion.getcon_factura()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(subpreguntaevaluacion.getcon_orden_compra()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(subpreguntaevaluacion.getcon_completo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(subpreguntaevaluacion.getcon_a_tiempo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySubPreguntaEvaluacion=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySubPreguntaEvaluacion() {
		return this.sFinalQuerySubPreguntaEvaluacion;
	}
	
	public void setsFinalQuerySubPreguntaEvaluacion(String sFinalQuerySubPreguntaEvaluacion) {
		this.sFinalQuerySubPreguntaEvaluacion= sFinalQuerySubPreguntaEvaluacion;
	}
	
	public Border resaltarSeleccionarSubPreguntaEvaluacion=null;
	
	public Border setResaltarSeleccionarSubPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*SubPreguntaEvaluacionBeanSwingJInternalFrame subpreguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//subpreguntaevaluacionBeanSwingJInternalFrame.jTtoolBarSubPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSubPreguntaEvaluacion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSubPreguntaEvaluacion() {
		return this.resaltarSeleccionarSubPreguntaEvaluacion;
	}
	
	public void setResaltarSeleccionarSubPreguntaEvaluacion(Border borderResaltarSeleccionarSubPreguntaEvaluacion) {
		this.resaltarSeleccionarSubPreguntaEvaluacion= borderResaltarSeleccionarSubPreguntaEvaluacion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSubPreguntaEvaluacion=null;
	public Boolean mostraridSubPreguntaEvaluacion=true;
	public Boolean activaridSubPreguntaEvaluacion=true;

	public Border resaltarid_empresaSubPreguntaEvaluacion=null;
	public Boolean mostrarid_empresaSubPreguntaEvaluacion=true;
	public Boolean activarid_empresaSubPreguntaEvaluacion=true;
	public Boolean cargarid_empresaSubPreguntaEvaluacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSubPreguntaEvaluacion=false;//ConEventDepend=true

	public Border resaltarid_sucursalSubPreguntaEvaluacion=null;
	public Boolean mostrarid_sucursalSubPreguntaEvaluacion=true;
	public Boolean activarid_sucursalSubPreguntaEvaluacion=true;
	public Boolean cargarid_sucursalSubPreguntaEvaluacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalSubPreguntaEvaluacion=false;//ConEventDepend=true

	public Border resaltarid_pregunta_evaluacionSubPreguntaEvaluacion=null;
	public Boolean mostrarid_pregunta_evaluacionSubPreguntaEvaluacion=true;
	public Boolean activarid_pregunta_evaluacionSubPreguntaEvaluacion=true;
	public Boolean cargarid_pregunta_evaluacionSubPreguntaEvaluacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_pregunta_evaluacionSubPreguntaEvaluacion=false;//ConEventDepend=true

	public Border resaltarid_ejercicioSubPreguntaEvaluacion=null;
	public Boolean mostrarid_ejercicioSubPreguntaEvaluacion=true;
	public Boolean activarid_ejercicioSubPreguntaEvaluacion=true;
	public Boolean cargarid_ejercicioSubPreguntaEvaluacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioSubPreguntaEvaluacion=false;//ConEventDepend=true

	public Border resaltarid_periodoSubPreguntaEvaluacion=null;
	public Boolean mostrarid_periodoSubPreguntaEvaluacion=true;
	public Boolean activarid_periodoSubPreguntaEvaluacion=true;
	public Boolean cargarid_periodoSubPreguntaEvaluacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoSubPreguntaEvaluacion=false;//ConEventDepend=true

	public Border resaltarordenSubPreguntaEvaluacion=null;
	public Boolean mostrarordenSubPreguntaEvaluacion=true;
	public Boolean activarordenSubPreguntaEvaluacion=true;

	public Border resaltarpreguntaSubPreguntaEvaluacion=null;
	public Boolean mostrarpreguntaSubPreguntaEvaluacion=true;
	public Boolean activarpreguntaSubPreguntaEvaluacion=true;

	public Border resaltarporcentaje_siSubPreguntaEvaluacion=null;
	public Boolean mostrarporcentaje_siSubPreguntaEvaluacion=true;
	public Boolean activarporcentaje_siSubPreguntaEvaluacion=true;

	public Border resaltarcon_facturaSubPreguntaEvaluacion=null;
	public Boolean mostrarcon_facturaSubPreguntaEvaluacion=true;
	public Boolean activarcon_facturaSubPreguntaEvaluacion=true;

	public Border resaltarcon_orden_compraSubPreguntaEvaluacion=null;
	public Boolean mostrarcon_orden_compraSubPreguntaEvaluacion=true;
	public Boolean activarcon_orden_compraSubPreguntaEvaluacion=true;

	public Border resaltarcon_completoSubPreguntaEvaluacion=null;
	public Boolean mostrarcon_completoSubPreguntaEvaluacion=true;
	public Boolean activarcon_completoSubPreguntaEvaluacion=true;

	public Border resaltarcon_a_tiempoSubPreguntaEvaluacion=null;
	public Boolean mostrarcon_a_tiempoSubPreguntaEvaluacion=true;
	public Boolean activarcon_a_tiempoSubPreguntaEvaluacion=true;

	
	

	public Border setResaltaridSubPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*SubPreguntaEvaluacionBeanSwingJInternalFrame subpreguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subpreguntaevaluacionBeanSwingJInternalFrame.jTtoolBarSubPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltaridSubPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSubPreguntaEvaluacion() {
		return this.resaltaridSubPreguntaEvaluacion;
	}

	public void setResaltaridSubPreguntaEvaluacion(Border borderResaltar) {
		this.resaltaridSubPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostraridSubPreguntaEvaluacion() {
		return this.mostraridSubPreguntaEvaluacion;
	}

	public void setMostraridSubPreguntaEvaluacion(Boolean mostraridSubPreguntaEvaluacion) {
		this.mostraridSubPreguntaEvaluacion= mostraridSubPreguntaEvaluacion;
	}

	public Boolean getActivaridSubPreguntaEvaluacion() {
		return this.activaridSubPreguntaEvaluacion;
	}

	public void setActivaridSubPreguntaEvaluacion(Boolean activaridSubPreguntaEvaluacion) {
		this.activaridSubPreguntaEvaluacion= activaridSubPreguntaEvaluacion;
	}

	public Border setResaltarid_empresaSubPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*SubPreguntaEvaluacionBeanSwingJInternalFrame subpreguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subpreguntaevaluacionBeanSwingJInternalFrame.jTtoolBarSubPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarid_empresaSubPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSubPreguntaEvaluacion() {
		return this.resaltarid_empresaSubPreguntaEvaluacion;
	}

	public void setResaltarid_empresaSubPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarid_empresaSubPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostrarid_empresaSubPreguntaEvaluacion() {
		return this.mostrarid_empresaSubPreguntaEvaluacion;
	}

	public void setMostrarid_empresaSubPreguntaEvaluacion(Boolean mostrarid_empresaSubPreguntaEvaluacion) {
		this.mostrarid_empresaSubPreguntaEvaluacion= mostrarid_empresaSubPreguntaEvaluacion;
	}

	public Boolean getActivarid_empresaSubPreguntaEvaluacion() {
		return this.activarid_empresaSubPreguntaEvaluacion;
	}

	public void setActivarid_empresaSubPreguntaEvaluacion(Boolean activarid_empresaSubPreguntaEvaluacion) {
		this.activarid_empresaSubPreguntaEvaluacion= activarid_empresaSubPreguntaEvaluacion;
	}

	public Boolean getCargarid_empresaSubPreguntaEvaluacion() {
		return this.cargarid_empresaSubPreguntaEvaluacion;
	}

	public void setCargarid_empresaSubPreguntaEvaluacion(Boolean cargarid_empresaSubPreguntaEvaluacion) {
		this.cargarid_empresaSubPreguntaEvaluacion= cargarid_empresaSubPreguntaEvaluacion;
	}

	public Border setResaltarid_sucursalSubPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*SubPreguntaEvaluacionBeanSwingJInternalFrame subpreguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subpreguntaevaluacionBeanSwingJInternalFrame.jTtoolBarSubPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarid_sucursalSubPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalSubPreguntaEvaluacion() {
		return this.resaltarid_sucursalSubPreguntaEvaluacion;
	}

	public void setResaltarid_sucursalSubPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarid_sucursalSubPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostrarid_sucursalSubPreguntaEvaluacion() {
		return this.mostrarid_sucursalSubPreguntaEvaluacion;
	}

	public void setMostrarid_sucursalSubPreguntaEvaluacion(Boolean mostrarid_sucursalSubPreguntaEvaluacion) {
		this.mostrarid_sucursalSubPreguntaEvaluacion= mostrarid_sucursalSubPreguntaEvaluacion;
	}

	public Boolean getActivarid_sucursalSubPreguntaEvaluacion() {
		return this.activarid_sucursalSubPreguntaEvaluacion;
	}

	public void setActivarid_sucursalSubPreguntaEvaluacion(Boolean activarid_sucursalSubPreguntaEvaluacion) {
		this.activarid_sucursalSubPreguntaEvaluacion= activarid_sucursalSubPreguntaEvaluacion;
	}

	public Boolean getCargarid_sucursalSubPreguntaEvaluacion() {
		return this.cargarid_sucursalSubPreguntaEvaluacion;
	}

	public void setCargarid_sucursalSubPreguntaEvaluacion(Boolean cargarid_sucursalSubPreguntaEvaluacion) {
		this.cargarid_sucursalSubPreguntaEvaluacion= cargarid_sucursalSubPreguntaEvaluacion;
	}

	public Border setResaltarid_pregunta_evaluacionSubPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*SubPreguntaEvaluacionBeanSwingJInternalFrame subpreguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subpreguntaevaluacionBeanSwingJInternalFrame.jTtoolBarSubPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarid_pregunta_evaluacionSubPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_pregunta_evaluacionSubPreguntaEvaluacion() {
		return this.resaltarid_pregunta_evaluacionSubPreguntaEvaluacion;
	}

	public void setResaltarid_pregunta_evaluacionSubPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarid_pregunta_evaluacionSubPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostrarid_pregunta_evaluacionSubPreguntaEvaluacion() {
		return this.mostrarid_pregunta_evaluacionSubPreguntaEvaluacion;
	}

	public void setMostrarid_pregunta_evaluacionSubPreguntaEvaluacion(Boolean mostrarid_pregunta_evaluacionSubPreguntaEvaluacion) {
		this.mostrarid_pregunta_evaluacionSubPreguntaEvaluacion= mostrarid_pregunta_evaluacionSubPreguntaEvaluacion;
	}

	public Boolean getActivarid_pregunta_evaluacionSubPreguntaEvaluacion() {
		return this.activarid_pregunta_evaluacionSubPreguntaEvaluacion;
	}

	public void setActivarid_pregunta_evaluacionSubPreguntaEvaluacion(Boolean activarid_pregunta_evaluacionSubPreguntaEvaluacion) {
		this.activarid_pregunta_evaluacionSubPreguntaEvaluacion= activarid_pregunta_evaluacionSubPreguntaEvaluacion;
	}

	public Boolean getCargarid_pregunta_evaluacionSubPreguntaEvaluacion() {
		return this.cargarid_pregunta_evaluacionSubPreguntaEvaluacion;
	}

	public void setCargarid_pregunta_evaluacionSubPreguntaEvaluacion(Boolean cargarid_pregunta_evaluacionSubPreguntaEvaluacion) {
		this.cargarid_pregunta_evaluacionSubPreguntaEvaluacion= cargarid_pregunta_evaluacionSubPreguntaEvaluacion;
	}

	public Border setResaltarid_ejercicioSubPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*SubPreguntaEvaluacionBeanSwingJInternalFrame subpreguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subpreguntaevaluacionBeanSwingJInternalFrame.jTtoolBarSubPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioSubPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioSubPreguntaEvaluacion() {
		return this.resaltarid_ejercicioSubPreguntaEvaluacion;
	}

	public void setResaltarid_ejercicioSubPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarid_ejercicioSubPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioSubPreguntaEvaluacion() {
		return this.mostrarid_ejercicioSubPreguntaEvaluacion;
	}

	public void setMostrarid_ejercicioSubPreguntaEvaluacion(Boolean mostrarid_ejercicioSubPreguntaEvaluacion) {
		this.mostrarid_ejercicioSubPreguntaEvaluacion= mostrarid_ejercicioSubPreguntaEvaluacion;
	}

	public Boolean getActivarid_ejercicioSubPreguntaEvaluacion() {
		return this.activarid_ejercicioSubPreguntaEvaluacion;
	}

	public void setActivarid_ejercicioSubPreguntaEvaluacion(Boolean activarid_ejercicioSubPreguntaEvaluacion) {
		this.activarid_ejercicioSubPreguntaEvaluacion= activarid_ejercicioSubPreguntaEvaluacion;
	}

	public Boolean getCargarid_ejercicioSubPreguntaEvaluacion() {
		return this.cargarid_ejercicioSubPreguntaEvaluacion;
	}

	public void setCargarid_ejercicioSubPreguntaEvaluacion(Boolean cargarid_ejercicioSubPreguntaEvaluacion) {
		this.cargarid_ejercicioSubPreguntaEvaluacion= cargarid_ejercicioSubPreguntaEvaluacion;
	}

	public Border setResaltarid_periodoSubPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*SubPreguntaEvaluacionBeanSwingJInternalFrame subpreguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subpreguntaevaluacionBeanSwingJInternalFrame.jTtoolBarSubPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarid_periodoSubPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoSubPreguntaEvaluacion() {
		return this.resaltarid_periodoSubPreguntaEvaluacion;
	}

	public void setResaltarid_periodoSubPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarid_periodoSubPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostrarid_periodoSubPreguntaEvaluacion() {
		return this.mostrarid_periodoSubPreguntaEvaluacion;
	}

	public void setMostrarid_periodoSubPreguntaEvaluacion(Boolean mostrarid_periodoSubPreguntaEvaluacion) {
		this.mostrarid_periodoSubPreguntaEvaluacion= mostrarid_periodoSubPreguntaEvaluacion;
	}

	public Boolean getActivarid_periodoSubPreguntaEvaluacion() {
		return this.activarid_periodoSubPreguntaEvaluacion;
	}

	public void setActivarid_periodoSubPreguntaEvaluacion(Boolean activarid_periodoSubPreguntaEvaluacion) {
		this.activarid_periodoSubPreguntaEvaluacion= activarid_periodoSubPreguntaEvaluacion;
	}

	public Boolean getCargarid_periodoSubPreguntaEvaluacion() {
		return this.cargarid_periodoSubPreguntaEvaluacion;
	}

	public void setCargarid_periodoSubPreguntaEvaluacion(Boolean cargarid_periodoSubPreguntaEvaluacion) {
		this.cargarid_periodoSubPreguntaEvaluacion= cargarid_periodoSubPreguntaEvaluacion;
	}

	public Border setResaltarordenSubPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*SubPreguntaEvaluacionBeanSwingJInternalFrame subpreguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subpreguntaevaluacionBeanSwingJInternalFrame.jTtoolBarSubPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarordenSubPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarordenSubPreguntaEvaluacion() {
		return this.resaltarordenSubPreguntaEvaluacion;
	}

	public void setResaltarordenSubPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarordenSubPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostrarordenSubPreguntaEvaluacion() {
		return this.mostrarordenSubPreguntaEvaluacion;
	}

	public void setMostrarordenSubPreguntaEvaluacion(Boolean mostrarordenSubPreguntaEvaluacion) {
		this.mostrarordenSubPreguntaEvaluacion= mostrarordenSubPreguntaEvaluacion;
	}

	public Boolean getActivarordenSubPreguntaEvaluacion() {
		return this.activarordenSubPreguntaEvaluacion;
	}

	public void setActivarordenSubPreguntaEvaluacion(Boolean activarordenSubPreguntaEvaluacion) {
		this.activarordenSubPreguntaEvaluacion= activarordenSubPreguntaEvaluacion;
	}

	public Border setResaltarpreguntaSubPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*SubPreguntaEvaluacionBeanSwingJInternalFrame subpreguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subpreguntaevaluacionBeanSwingJInternalFrame.jTtoolBarSubPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarpreguntaSubPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpreguntaSubPreguntaEvaluacion() {
		return this.resaltarpreguntaSubPreguntaEvaluacion;
	}

	public void setResaltarpreguntaSubPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarpreguntaSubPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostrarpreguntaSubPreguntaEvaluacion() {
		return this.mostrarpreguntaSubPreguntaEvaluacion;
	}

	public void setMostrarpreguntaSubPreguntaEvaluacion(Boolean mostrarpreguntaSubPreguntaEvaluacion) {
		this.mostrarpreguntaSubPreguntaEvaluacion= mostrarpreguntaSubPreguntaEvaluacion;
	}

	public Boolean getActivarpreguntaSubPreguntaEvaluacion() {
		return this.activarpreguntaSubPreguntaEvaluacion;
	}

	public void setActivarpreguntaSubPreguntaEvaluacion(Boolean activarpreguntaSubPreguntaEvaluacion) {
		this.activarpreguntaSubPreguntaEvaluacion= activarpreguntaSubPreguntaEvaluacion;
	}

	public Border setResaltarporcentaje_siSubPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*SubPreguntaEvaluacionBeanSwingJInternalFrame subpreguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subpreguntaevaluacionBeanSwingJInternalFrame.jTtoolBarSubPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarporcentaje_siSubPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_siSubPreguntaEvaluacion() {
		return this.resaltarporcentaje_siSubPreguntaEvaluacion;
	}

	public void setResaltarporcentaje_siSubPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarporcentaje_siSubPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostrarporcentaje_siSubPreguntaEvaluacion() {
		return this.mostrarporcentaje_siSubPreguntaEvaluacion;
	}

	public void setMostrarporcentaje_siSubPreguntaEvaluacion(Boolean mostrarporcentaje_siSubPreguntaEvaluacion) {
		this.mostrarporcentaje_siSubPreguntaEvaluacion= mostrarporcentaje_siSubPreguntaEvaluacion;
	}

	public Boolean getActivarporcentaje_siSubPreguntaEvaluacion() {
		return this.activarporcentaje_siSubPreguntaEvaluacion;
	}

	public void setActivarporcentaje_siSubPreguntaEvaluacion(Boolean activarporcentaje_siSubPreguntaEvaluacion) {
		this.activarporcentaje_siSubPreguntaEvaluacion= activarporcentaje_siSubPreguntaEvaluacion;
	}

	public Border setResaltarcon_facturaSubPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*SubPreguntaEvaluacionBeanSwingJInternalFrame subpreguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subpreguntaevaluacionBeanSwingJInternalFrame.jTtoolBarSubPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarcon_facturaSubPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_facturaSubPreguntaEvaluacion() {
		return this.resaltarcon_facturaSubPreguntaEvaluacion;
	}

	public void setResaltarcon_facturaSubPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarcon_facturaSubPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostrarcon_facturaSubPreguntaEvaluacion() {
		return this.mostrarcon_facturaSubPreguntaEvaluacion;
	}

	public void setMostrarcon_facturaSubPreguntaEvaluacion(Boolean mostrarcon_facturaSubPreguntaEvaluacion) {
		this.mostrarcon_facturaSubPreguntaEvaluacion= mostrarcon_facturaSubPreguntaEvaluacion;
	}

	public Boolean getActivarcon_facturaSubPreguntaEvaluacion() {
		return this.activarcon_facturaSubPreguntaEvaluacion;
	}

	public void setActivarcon_facturaSubPreguntaEvaluacion(Boolean activarcon_facturaSubPreguntaEvaluacion) {
		this.activarcon_facturaSubPreguntaEvaluacion= activarcon_facturaSubPreguntaEvaluacion;
	}

	public Border setResaltarcon_orden_compraSubPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*SubPreguntaEvaluacionBeanSwingJInternalFrame subpreguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subpreguntaevaluacionBeanSwingJInternalFrame.jTtoolBarSubPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarcon_orden_compraSubPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_orden_compraSubPreguntaEvaluacion() {
		return this.resaltarcon_orden_compraSubPreguntaEvaluacion;
	}

	public void setResaltarcon_orden_compraSubPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarcon_orden_compraSubPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostrarcon_orden_compraSubPreguntaEvaluacion() {
		return this.mostrarcon_orden_compraSubPreguntaEvaluacion;
	}

	public void setMostrarcon_orden_compraSubPreguntaEvaluacion(Boolean mostrarcon_orden_compraSubPreguntaEvaluacion) {
		this.mostrarcon_orden_compraSubPreguntaEvaluacion= mostrarcon_orden_compraSubPreguntaEvaluacion;
	}

	public Boolean getActivarcon_orden_compraSubPreguntaEvaluacion() {
		return this.activarcon_orden_compraSubPreguntaEvaluacion;
	}

	public void setActivarcon_orden_compraSubPreguntaEvaluacion(Boolean activarcon_orden_compraSubPreguntaEvaluacion) {
		this.activarcon_orden_compraSubPreguntaEvaluacion= activarcon_orden_compraSubPreguntaEvaluacion;
	}

	public Border setResaltarcon_completoSubPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*SubPreguntaEvaluacionBeanSwingJInternalFrame subpreguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subpreguntaevaluacionBeanSwingJInternalFrame.jTtoolBarSubPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarcon_completoSubPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_completoSubPreguntaEvaluacion() {
		return this.resaltarcon_completoSubPreguntaEvaluacion;
	}

	public void setResaltarcon_completoSubPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarcon_completoSubPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostrarcon_completoSubPreguntaEvaluacion() {
		return this.mostrarcon_completoSubPreguntaEvaluacion;
	}

	public void setMostrarcon_completoSubPreguntaEvaluacion(Boolean mostrarcon_completoSubPreguntaEvaluacion) {
		this.mostrarcon_completoSubPreguntaEvaluacion= mostrarcon_completoSubPreguntaEvaluacion;
	}

	public Boolean getActivarcon_completoSubPreguntaEvaluacion() {
		return this.activarcon_completoSubPreguntaEvaluacion;
	}

	public void setActivarcon_completoSubPreguntaEvaluacion(Boolean activarcon_completoSubPreguntaEvaluacion) {
		this.activarcon_completoSubPreguntaEvaluacion= activarcon_completoSubPreguntaEvaluacion;
	}

	public Border setResaltarcon_a_tiempoSubPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*SubPreguntaEvaluacionBeanSwingJInternalFrame subpreguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subpreguntaevaluacionBeanSwingJInternalFrame.jTtoolBarSubPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarcon_a_tiempoSubPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_a_tiempoSubPreguntaEvaluacion() {
		return this.resaltarcon_a_tiempoSubPreguntaEvaluacion;
	}

	public void setResaltarcon_a_tiempoSubPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarcon_a_tiempoSubPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostrarcon_a_tiempoSubPreguntaEvaluacion() {
		return this.mostrarcon_a_tiempoSubPreguntaEvaluacion;
	}

	public void setMostrarcon_a_tiempoSubPreguntaEvaluacion(Boolean mostrarcon_a_tiempoSubPreguntaEvaluacion) {
		this.mostrarcon_a_tiempoSubPreguntaEvaluacion= mostrarcon_a_tiempoSubPreguntaEvaluacion;
	}

	public Boolean getActivarcon_a_tiempoSubPreguntaEvaluacion() {
		return this.activarcon_a_tiempoSubPreguntaEvaluacion;
	}

	public void setActivarcon_a_tiempoSubPreguntaEvaluacion(Boolean activarcon_a_tiempoSubPreguntaEvaluacion) {
		this.activarcon_a_tiempoSubPreguntaEvaluacion= activarcon_a_tiempoSubPreguntaEvaluacion;
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
		
		
		this.setMostraridSubPreguntaEvaluacion(esInicial);
		this.setMostrarid_empresaSubPreguntaEvaluacion(esInicial);
		this.setMostrarid_sucursalSubPreguntaEvaluacion(esInicial);
		this.setMostrarid_pregunta_evaluacionSubPreguntaEvaluacion(esInicial);
		this.setMostrarid_ejercicioSubPreguntaEvaluacion(esInicial);
		this.setMostrarid_periodoSubPreguntaEvaluacion(esInicial);
		this.setMostrarordenSubPreguntaEvaluacion(esInicial);
		this.setMostrarpreguntaSubPreguntaEvaluacion(esInicial);
		this.setMostrarporcentaje_siSubPreguntaEvaluacion(esInicial);
		this.setMostrarcon_facturaSubPreguntaEvaluacion(esInicial);
		this.setMostrarcon_orden_compraSubPreguntaEvaluacion(esInicial);
		this.setMostrarcon_completoSubPreguntaEvaluacion(esInicial);
		this.setMostrarcon_a_tiempoSubPreguntaEvaluacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.ID)) {
				this.setMostraridSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.IDPREGUNTAEVALUACION)) {
				this.setMostrarid_pregunta_evaluacionSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.ORDEN)) {
				this.setMostrarordenSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.PREGUNTA)) {
				this.setMostrarpreguntaSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.PORCENTAJESI)) {
				this.setMostrarporcentaje_siSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.CONFACTURA)) {
				this.setMostrarcon_facturaSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.CONORDENCOMPRA)) {
				this.setMostrarcon_orden_compraSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.CONCOMPLETO)) {
				this.setMostrarcon_completoSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.CONATIEMPO)) {
				this.setMostrarcon_a_tiempoSubPreguntaEvaluacion(esAsigna);
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
		
		
		this.setActivaridSubPreguntaEvaluacion(esInicial);
		this.setActivarid_empresaSubPreguntaEvaluacion(esInicial);
		this.setActivarid_sucursalSubPreguntaEvaluacion(esInicial);
		this.setActivarid_pregunta_evaluacionSubPreguntaEvaluacion(esInicial);
		this.setActivarid_ejercicioSubPreguntaEvaluacion(esInicial);
		this.setActivarid_periodoSubPreguntaEvaluacion(esInicial);
		this.setActivarordenSubPreguntaEvaluacion(esInicial);
		this.setActivarpreguntaSubPreguntaEvaluacion(esInicial);
		this.setActivarporcentaje_siSubPreguntaEvaluacion(esInicial);
		this.setActivarcon_facturaSubPreguntaEvaluacion(esInicial);
		this.setActivarcon_orden_compraSubPreguntaEvaluacion(esInicial);
		this.setActivarcon_completoSubPreguntaEvaluacion(esInicial);
		this.setActivarcon_a_tiempoSubPreguntaEvaluacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.ID)) {
				this.setActivaridSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.IDPREGUNTAEVALUACION)) {
				this.setActivarid_pregunta_evaluacionSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.ORDEN)) {
				this.setActivarordenSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.PREGUNTA)) {
				this.setActivarpreguntaSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.PORCENTAJESI)) {
				this.setActivarporcentaje_siSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.CONFACTURA)) {
				this.setActivarcon_facturaSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.CONORDENCOMPRA)) {
				this.setActivarcon_orden_compraSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.CONCOMPLETO)) {
				this.setActivarcon_completoSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.CONATIEMPO)) {
				this.setActivarcon_a_tiempoSubPreguntaEvaluacion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SubPreguntaEvaluacionBeanSwingJInternalFrame subpreguntaevaluacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSubPreguntaEvaluacion(esInicial);
		this.setResaltarid_empresaSubPreguntaEvaluacion(esInicial);
		this.setResaltarid_sucursalSubPreguntaEvaluacion(esInicial);
		this.setResaltarid_pregunta_evaluacionSubPreguntaEvaluacion(esInicial);
		this.setResaltarid_ejercicioSubPreguntaEvaluacion(esInicial);
		this.setResaltarid_periodoSubPreguntaEvaluacion(esInicial);
		this.setResaltarordenSubPreguntaEvaluacion(esInicial);
		this.setResaltarpreguntaSubPreguntaEvaluacion(esInicial);
		this.setResaltarporcentaje_siSubPreguntaEvaluacion(esInicial);
		this.setResaltarcon_facturaSubPreguntaEvaluacion(esInicial);
		this.setResaltarcon_orden_compraSubPreguntaEvaluacion(esInicial);
		this.setResaltarcon_completoSubPreguntaEvaluacion(esInicial);
		this.setResaltarcon_a_tiempoSubPreguntaEvaluacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.ID)) {
				this.setResaltaridSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.IDPREGUNTAEVALUACION)) {
				this.setResaltarid_pregunta_evaluacionSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.ORDEN)) {
				this.setResaltarordenSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.PREGUNTA)) {
				this.setResaltarpreguntaSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.PORCENTAJESI)) {
				this.setResaltarporcentaje_siSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.CONFACTURA)) {
				this.setResaltarcon_facturaSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.CONORDENCOMPRA)) {
				this.setResaltarcon_orden_compraSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.CONCOMPLETO)) {
				this.setResaltarcon_completoSubPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubPreguntaEvaluacionConstantesFunciones.CONATIEMPO)) {
				this.setResaltarcon_a_tiempoSubPreguntaEvaluacion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleEvaluacionProveedorSubPreguntaEvaluacion=null;

	public Border getResaltarDetalleEvaluacionProveedorSubPreguntaEvaluacion() {
		return this.resaltarDetalleEvaluacionProveedorSubPreguntaEvaluacion;
	}

	public void setResaltarDetalleEvaluacionProveedorSubPreguntaEvaluacion(Border borderResaltarDetalleEvaluacionProveedor) {
		if(borderResaltarDetalleEvaluacionProveedor!=null) {
			this.resaltarDetalleEvaluacionProveedorSubPreguntaEvaluacion= borderResaltarDetalleEvaluacionProveedor;
		}
	}

	public Border setResaltarDetalleEvaluacionProveedorSubPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*SubPreguntaEvaluacionBeanSwingJInternalFrame subpreguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleEvaluacionProveedor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//subpreguntaevaluacionBeanSwingJInternalFrame.jTtoolBarSubPreguntaEvaluacion.setBorder(borderResaltarDetalleEvaluacionProveedor);
			
		this.resaltarDetalleEvaluacionProveedorSubPreguntaEvaluacion= borderResaltarDetalleEvaluacionProveedor;

		 return borderResaltarDetalleEvaluacionProveedor;
	}



	public Boolean mostrarDetalleEvaluacionProveedorSubPreguntaEvaluacion=true;

	public Boolean getMostrarDetalleEvaluacionProveedorSubPreguntaEvaluacion() {
		return this.mostrarDetalleEvaluacionProveedorSubPreguntaEvaluacion;
	}

	public void setMostrarDetalleEvaluacionProveedorSubPreguntaEvaluacion(Boolean visibilidadResaltarDetalleEvaluacionProveedor) {
		this.mostrarDetalleEvaluacionProveedorSubPreguntaEvaluacion= visibilidadResaltarDetalleEvaluacionProveedor;
	}



	public Boolean activarDetalleEvaluacionProveedorSubPreguntaEvaluacion=true;

	public Boolean gethabilitarResaltarDetalleEvaluacionProveedorSubPreguntaEvaluacion() {
		return this.activarDetalleEvaluacionProveedorSubPreguntaEvaluacion;
	}

	public void setActivarDetalleEvaluacionProveedorSubPreguntaEvaluacion(Boolean habilitarResaltarDetalleEvaluacionProveedor) {
		this.activarDetalleEvaluacionProveedorSubPreguntaEvaluacion= habilitarResaltarDetalleEvaluacionProveedor;
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

		this.setMostrarDetalleEvaluacionProveedorSubPreguntaEvaluacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleEvaluacionProveedor.class)) {
				this.setMostrarDetalleEvaluacionProveedorSubPreguntaEvaluacion(esAsigna);
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

		this.setActivarDetalleEvaluacionProveedorSubPreguntaEvaluacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleEvaluacionProveedor.class)) {
				this.setActivarDetalleEvaluacionProveedorSubPreguntaEvaluacion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SubPreguntaEvaluacionBeanSwingJInternalFrame subpreguntaevaluacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleEvaluacionProveedorSubPreguntaEvaluacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleEvaluacionProveedor.class)) {
				this.setResaltarDetalleEvaluacionProveedorSubPreguntaEvaluacion(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEjercicioSubPreguntaEvaluacion=true;

	public Boolean getMostrarFK_IdEjercicioSubPreguntaEvaluacion() {
		return this.mostrarFK_IdEjercicioSubPreguntaEvaluacion;
	}

	public void setMostrarFK_IdEjercicioSubPreguntaEvaluacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioSubPreguntaEvaluacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaSubPreguntaEvaluacion=true;

	public Boolean getMostrarFK_IdEmpresaSubPreguntaEvaluacion() {
		return this.mostrarFK_IdEmpresaSubPreguntaEvaluacion;
	}

	public void setMostrarFK_IdEmpresaSubPreguntaEvaluacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaSubPreguntaEvaluacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoSubPreguntaEvaluacion=true;

	public Boolean getMostrarFK_IdPeriodoSubPreguntaEvaluacion() {
		return this.mostrarFK_IdPeriodoSubPreguntaEvaluacion;
	}

	public void setMostrarFK_IdPeriodoSubPreguntaEvaluacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoSubPreguntaEvaluacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPreguntaEvaluacionSubPreguntaEvaluacion=true;

	public Boolean getMostrarFK_IdPreguntaEvaluacionSubPreguntaEvaluacion() {
		return this.mostrarFK_IdPreguntaEvaluacionSubPreguntaEvaluacion;
	}

	public void setMostrarFK_IdPreguntaEvaluacionSubPreguntaEvaluacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPreguntaEvaluacionSubPreguntaEvaluacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalSubPreguntaEvaluacion=true;

	public Boolean getMostrarFK_IdSucursalSubPreguntaEvaluacion() {
		return this.mostrarFK_IdSucursalSubPreguntaEvaluacion;
	}

	public void setMostrarFK_IdSucursalSubPreguntaEvaluacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalSubPreguntaEvaluacion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEjercicioSubPreguntaEvaluacion=true;

	public Boolean getActivarFK_IdEjercicioSubPreguntaEvaluacion() {
		return this.activarFK_IdEjercicioSubPreguntaEvaluacion;
	}

	public void setActivarFK_IdEjercicioSubPreguntaEvaluacion(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioSubPreguntaEvaluacion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaSubPreguntaEvaluacion=true;

	public Boolean getActivarFK_IdEmpresaSubPreguntaEvaluacion() {
		return this.activarFK_IdEmpresaSubPreguntaEvaluacion;
	}

	public void setActivarFK_IdEmpresaSubPreguntaEvaluacion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaSubPreguntaEvaluacion= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoSubPreguntaEvaluacion=true;

	public Boolean getActivarFK_IdPeriodoSubPreguntaEvaluacion() {
		return this.activarFK_IdPeriodoSubPreguntaEvaluacion;
	}

	public void setActivarFK_IdPeriodoSubPreguntaEvaluacion(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoSubPreguntaEvaluacion= habilitarResaltar;
	}

	public Boolean activarFK_IdPreguntaEvaluacionSubPreguntaEvaluacion=true;

	public Boolean getActivarFK_IdPreguntaEvaluacionSubPreguntaEvaluacion() {
		return this.activarFK_IdPreguntaEvaluacionSubPreguntaEvaluacion;
	}

	public void setActivarFK_IdPreguntaEvaluacionSubPreguntaEvaluacion(Boolean habilitarResaltar) {
		this.activarFK_IdPreguntaEvaluacionSubPreguntaEvaluacion= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalSubPreguntaEvaluacion=true;

	public Boolean getActivarFK_IdSucursalSubPreguntaEvaluacion() {
		return this.activarFK_IdSucursalSubPreguntaEvaluacion;
	}

	public void setActivarFK_IdSucursalSubPreguntaEvaluacion(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalSubPreguntaEvaluacion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEjercicioSubPreguntaEvaluacion=null;

	public Border getResaltarFK_IdEjercicioSubPreguntaEvaluacion() {
		return this.resaltarFK_IdEjercicioSubPreguntaEvaluacion;
	}

	public void setResaltarFK_IdEjercicioSubPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarFK_IdEjercicioSubPreguntaEvaluacion= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioSubPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*SubPreguntaEvaluacionBeanSwingJInternalFrame subpreguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioSubPreguntaEvaluacion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaSubPreguntaEvaluacion=null;

	public Border getResaltarFK_IdEmpresaSubPreguntaEvaluacion() {
		return this.resaltarFK_IdEmpresaSubPreguntaEvaluacion;
	}

	public void setResaltarFK_IdEmpresaSubPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaSubPreguntaEvaluacion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaSubPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*SubPreguntaEvaluacionBeanSwingJInternalFrame subpreguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaSubPreguntaEvaluacion= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoSubPreguntaEvaluacion=null;

	public Border getResaltarFK_IdPeriodoSubPreguntaEvaluacion() {
		return this.resaltarFK_IdPeriodoSubPreguntaEvaluacion;
	}

	public void setResaltarFK_IdPeriodoSubPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarFK_IdPeriodoSubPreguntaEvaluacion= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoSubPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*SubPreguntaEvaluacionBeanSwingJInternalFrame subpreguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoSubPreguntaEvaluacion= borderResaltar;
	}

	public Border resaltarFK_IdPreguntaEvaluacionSubPreguntaEvaluacion=null;

	public Border getResaltarFK_IdPreguntaEvaluacionSubPreguntaEvaluacion() {
		return this.resaltarFK_IdPreguntaEvaluacionSubPreguntaEvaluacion;
	}

	public void setResaltarFK_IdPreguntaEvaluacionSubPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarFK_IdPreguntaEvaluacionSubPreguntaEvaluacion= borderResaltar;
	}

	public void setResaltarFK_IdPreguntaEvaluacionSubPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*SubPreguntaEvaluacionBeanSwingJInternalFrame subpreguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPreguntaEvaluacionSubPreguntaEvaluacion= borderResaltar;
	}

	public Border resaltarFK_IdSucursalSubPreguntaEvaluacion=null;

	public Border getResaltarFK_IdSucursalSubPreguntaEvaluacion() {
		return this.resaltarFK_IdSucursalSubPreguntaEvaluacion;
	}

	public void setResaltarFK_IdSucursalSubPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarFK_IdSucursalSubPreguntaEvaluacion= borderResaltar;
	}

	public void setResaltarFK_IdSucursalSubPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*SubPreguntaEvaluacionBeanSwingJInternalFrame subpreguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalSubPreguntaEvaluacion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}