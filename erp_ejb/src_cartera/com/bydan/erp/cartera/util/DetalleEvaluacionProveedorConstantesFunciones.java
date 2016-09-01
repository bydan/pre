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


import com.bydan.erp.cartera.util.DetalleEvaluacionProveedorConstantesFunciones;
import com.bydan.erp.cartera.util.DetalleEvaluacionProveedorParameterReturnGeneral;
//import com.bydan.erp.cartera.util.DetalleEvaluacionProveedorParameterGeneral;

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
final public class DetalleEvaluacionProveedorConstantesFunciones extends DetalleEvaluacionProveedorConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleEvaluacionProveedor";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleEvaluacionProveedor"+DetalleEvaluacionProveedorConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleEvaluacionProveedorHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleEvaluacionProveedorHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"_"+DetalleEvaluacionProveedorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleEvaluacionProveedorHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"_"+DetalleEvaluacionProveedorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"_"+DetalleEvaluacionProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleEvaluacionProveedorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"_"+DetalleEvaluacionProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleEvaluacionProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleEvaluacionProveedorHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleEvaluacionProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleEvaluacionProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleEvaluacionProveedorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleEvaluacionProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleEvaluacionProveedorConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleEvaluacionProveedorConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleEvaluacionProveedorConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleEvaluacionProveedorConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Evaluacion Proveedores";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Detalle Evaluacion Proveedor";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Evaluacion Proveedor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleEvaluacionProveedor";
	public static final String OBJECTNAME="detalleevaluacionproveedor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="detalle_evaluacion_proveedor";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalleevaluacionproveedor from "+DetalleEvaluacionProveedorConstantesFunciones.SPERSISTENCENAME+" detalleevaluacionproveedor";
	public static String QUERYSELECTNATIVE="select "+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".id,"+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".version_row,"+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".id_empresa,"+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".id_periodo,"+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".id_evaluacion_proveedor,"+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".id_pregunta_evaluacion,"+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".id_sub_pregunta_evaluacion,"+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".id_si_no,"+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".descripcion from "+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME;//+" as "+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleEvaluacionProveedorConstantesFuncionesAdditional detalleevaluacionproveedorConstantesFuncionesAdditional=null;
	
	public DetalleEvaluacionProveedorConstantesFuncionesAdditional getDetalleEvaluacionProveedorConstantesFuncionesAdditional() {
		return this.detalleevaluacionproveedorConstantesFuncionesAdditional;
	}
	
	public void setDetalleEvaluacionProveedorConstantesFuncionesAdditional(DetalleEvaluacionProveedorConstantesFuncionesAdditional detalleevaluacionproveedorConstantesFuncionesAdditional) {
		try {
			this.detalleevaluacionproveedorConstantesFuncionesAdditional=detalleevaluacionproveedorConstantesFuncionesAdditional;
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
    public static final String IDEVALUACIONPROVEEDOR= "id_evaluacion_proveedor";
    public static final String IDPREGUNTAEVALUACION= "id_pregunta_evaluacion";
    public static final String IDSUBPREGUNTAEVALUACION= "id_sub_pregunta_evaluacion";
    public static final String IDSINO= "id_si_no";
    public static final String DESCRIPCION= "descripcion";
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
    	public static final String LABEL_IDEVALUACIONPROVEEDOR= "Evaluacion Proveedor";
		public static final String LABEL_IDEVALUACIONPROVEEDOR_LOWER= "Evaluacion Proveedor";
    	public static final String LABEL_IDPREGUNTAEVALUACION= "Pregunta Evaluacion";
		public static final String LABEL_IDPREGUNTAEVALUACION_LOWER= "Pregunta Evaluacion";
    	public static final String LABEL_IDSUBPREGUNTAEVALUACION= "Sub Pregunta Evaluacion";
		public static final String LABEL_IDSUBPREGUNTAEVALUACION_LOWER= "Sub Pregunta Evaluacion";
    	public static final String LABEL_IDSINO= "Si No";
		public static final String LABEL_IDSINO_LOWER= "Si No";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetalleEvaluacionProveedorLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleEvaluacionProveedorConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleEvaluacionProveedorConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleEvaluacionProveedorConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetalleEvaluacionProveedorConstantesFunciones.IDPERIODO)) {sLabelColumna=DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetalleEvaluacionProveedorConstantesFunciones.IDEVALUACIONPROVEEDOR)) {sLabelColumna=DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDEVALUACIONPROVEEDOR;}
		if(sNombreColumna.equals(DetalleEvaluacionProveedorConstantesFunciones.IDPREGUNTAEVALUACION)) {sLabelColumna=DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDPREGUNTAEVALUACION;}
		if(sNombreColumna.equals(DetalleEvaluacionProveedorConstantesFunciones.IDSUBPREGUNTAEVALUACION)) {sLabelColumna=DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDSUBPREGUNTAEVALUACION;}
		if(sNombreColumna.equals(DetalleEvaluacionProveedorConstantesFunciones.IDSINO)) {sLabelColumna=DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDSINO;}
		if(sNombreColumna.equals(DetalleEvaluacionProveedorConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleEvaluacionProveedorConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleEvaluacionProveedorDescripcion(DetalleEvaluacionProveedor detalleevaluacionproveedor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalleevaluacionproveedor !=null/* && detalleevaluacionproveedor.getId()!=0*/) {
			if(detalleevaluacionproveedor.getId()!=null) {
				sDescripcion=detalleevaluacionproveedor.getId().toString();
			}//detalleevaluacionproveedordetalleevaluacionproveedor.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleEvaluacionProveedorDescripcionDetallado(DetalleEvaluacionProveedor detalleevaluacionproveedor) {
		String sDescripcion="";
			
		sDescripcion+=DetalleEvaluacionProveedorConstantesFunciones.ID+"=";
		sDescripcion+=detalleevaluacionproveedor.getId().toString()+",";
		sDescripcion+=DetalleEvaluacionProveedorConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalleevaluacionproveedor.getVersionRow().toString()+",";
		sDescripcion+=DetalleEvaluacionProveedorConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalleevaluacionproveedor.getid_empresa().toString()+",";
		sDescripcion+=DetalleEvaluacionProveedorConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detalleevaluacionproveedor.getid_sucursal().toString()+",";
		sDescripcion+=DetalleEvaluacionProveedorConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detalleevaluacionproveedor.getid_ejercicio().toString()+",";
		sDescripcion+=DetalleEvaluacionProveedorConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detalleevaluacionproveedor.getid_periodo().toString()+",";
		sDescripcion+=DetalleEvaluacionProveedorConstantesFunciones.IDEVALUACIONPROVEEDOR+"=";
		sDescripcion+=detalleevaluacionproveedor.getid_evaluacion_proveedor().toString()+",";
		sDescripcion+=DetalleEvaluacionProveedorConstantesFunciones.IDPREGUNTAEVALUACION+"=";
		sDescripcion+=detalleevaluacionproveedor.getid_pregunta_evaluacion().toString()+",";
		sDescripcion+=DetalleEvaluacionProveedorConstantesFunciones.IDSUBPREGUNTAEVALUACION+"=";
		sDescripcion+=detalleevaluacionproveedor.getid_sub_pregunta_evaluacion().toString()+",";
		sDescripcion+=DetalleEvaluacionProveedorConstantesFunciones.IDSINO+"=";
		sDescripcion+=detalleevaluacionproveedor.getid_si_no().toString()+",";
		sDescripcion+=DetalleEvaluacionProveedorConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detalleevaluacionproveedor.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleEvaluacionProveedorDescripcion(DetalleEvaluacionProveedor detalleevaluacionproveedor,String sValor) throws Exception {			
		if(detalleevaluacionproveedor !=null) {
			//detalleevaluacionproveedordetalleevaluacionproveedor.getId().toString();
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

	public static String getEvaluacionProveedorDescripcion(EvaluacionProveedor evaluacionproveedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(evaluacionproveedor!=null/*&&evaluacionproveedor.getId()>0*/) {
			sDescripcion=EvaluacionProveedorConstantesFunciones.getEvaluacionProveedorDescripcion(evaluacionproveedor);
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

	public static String getSubPreguntaEvaluacionDescripcion(SubPreguntaEvaluacion subpreguntaevaluacion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(subpreguntaevaluacion!=null/*&&subpreguntaevaluacion.getId()>0*/) {
			sDescripcion=SubPreguntaEvaluacionConstantesFunciones.getSubPreguntaEvaluacionDescripcion(subpreguntaevaluacion);
		}

		return sDescripcion;
	}

	public static String getSiNoDescripcion(SiNo sino) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sino!=null/*&&sino.getId()>0*/) {
			sDescripcion=SiNoConstantesFunciones.getSiNoDescripcion(sino);
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
		} else if(sNombreIndice.equals("FK_IdEvaluacionProveedor")) {
			sNombreIndice="Tipo=  Por Evaluacion Proveedor";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdPreguntaEvaluacion")) {
			sNombreIndice="Tipo=  Por Pregunta Evaluacion";
		} else if(sNombreIndice.equals("FK_IdSiNo")) {
			sNombreIndice="Tipo=  Por Si No";
		} else if(sNombreIndice.equals("FK_IdSubPreguntaEvaluacion")) {
			sNombreIndice="Tipo=  Por Sub Pregunta Evaluacion";
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

	public static String getDetalleIndiceFK_IdEvaluacionProveedor(Long id_evaluacion_proveedor) {
		String sDetalleIndice=" Parametros->";
		if(id_evaluacion_proveedor!=null) {sDetalleIndice+=" Codigo Unico De Evaluacion Proveedor="+id_evaluacion_proveedor.toString();} 

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

	public static String getDetalleIndiceFK_IdSiNo(Long id_si_no) {
		String sDetalleIndice=" Parametros->";
		if(id_si_no!=null) {sDetalleIndice+=" Codigo Unico De Si No="+id_si_no.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSubPreguntaEvaluacion(Long id_sub_pregunta_evaluacion) {
		String sDetalleIndice=" Parametros->";
		if(id_sub_pregunta_evaluacion!=null) {sDetalleIndice+=" Codigo Unico De Sub Pregunta Evaluacion="+id_sub_pregunta_evaluacion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleEvaluacionProveedor(DetalleEvaluacionProveedor detalleevaluacionproveedor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalleevaluacionproveedor.setdescripcion(detalleevaluacionproveedor.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDetalleEvaluacionProveedors(List<DetalleEvaluacionProveedor> detalleevaluacionproveedors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleEvaluacionProveedor detalleevaluacionproveedor: detalleevaluacionproveedors) {
			detalleevaluacionproveedor.setdescripcion(detalleevaluacionproveedor.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleEvaluacionProveedor(DetalleEvaluacionProveedor detalleevaluacionproveedor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalleevaluacionproveedor.getConCambioAuxiliar()) {
			detalleevaluacionproveedor.setIsDeleted(detalleevaluacionproveedor.getIsDeletedAuxiliar());	
			detalleevaluacionproveedor.setIsNew(detalleevaluacionproveedor.getIsNewAuxiliar());	
			detalleevaluacionproveedor.setIsChanged(detalleevaluacionproveedor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalleevaluacionproveedor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalleevaluacionproveedor.setIsDeletedAuxiliar(false);	
			detalleevaluacionproveedor.setIsNewAuxiliar(false);	
			detalleevaluacionproveedor.setIsChangedAuxiliar(false);
			
			detalleevaluacionproveedor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleEvaluacionProveedors(List<DetalleEvaluacionProveedor> detalleevaluacionproveedors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleEvaluacionProveedor detalleevaluacionproveedor : detalleevaluacionproveedors) {
			if(conAsignarBase && detalleevaluacionproveedor.getConCambioAuxiliar()) {
				detalleevaluacionproveedor.setIsDeleted(detalleevaluacionproveedor.getIsDeletedAuxiliar());	
				detalleevaluacionproveedor.setIsNew(detalleevaluacionproveedor.getIsNewAuxiliar());	
				detalleevaluacionproveedor.setIsChanged(detalleevaluacionproveedor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalleevaluacionproveedor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalleevaluacionproveedor.setIsDeletedAuxiliar(false);	
				detalleevaluacionproveedor.setIsNewAuxiliar(false);	
				detalleevaluacionproveedor.setIsChangedAuxiliar(false);
				
				detalleevaluacionproveedor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleEvaluacionProveedor(DetalleEvaluacionProveedor detalleevaluacionproveedor,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetalleEvaluacionProveedors(List<DetalleEvaluacionProveedor> detalleevaluacionproveedors,Boolean conEnteros) throws Exception  {
		
		for(DetalleEvaluacionProveedor detalleevaluacionproveedor: detalleevaluacionproveedors) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleEvaluacionProveedor(List<DetalleEvaluacionProveedor> detalleevaluacionproveedors,DetalleEvaluacionProveedor detalleevaluacionproveedorAux) throws Exception  {
		DetalleEvaluacionProveedorConstantesFunciones.InicializarValoresDetalleEvaluacionProveedor(detalleevaluacionproveedorAux,true);
		
		for(DetalleEvaluacionProveedor detalleevaluacionproveedor: detalleevaluacionproveedors) {
			if(detalleevaluacionproveedor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleEvaluacionProveedor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleEvaluacionProveedorConstantesFunciones.getArrayColumnasGlobalesDetalleEvaluacionProveedor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleEvaluacionProveedor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleEvaluacionProveedorConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleEvaluacionProveedorConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleEvaluacionProveedorConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleEvaluacionProveedorConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleEvaluacionProveedorConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleEvaluacionProveedorConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleEvaluacionProveedorConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleEvaluacionProveedorConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleEvaluacionProveedor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleEvaluacionProveedor> detalleevaluacionproveedors,DetalleEvaluacionProveedor detalleevaluacionproveedor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleEvaluacionProveedor detalleevaluacionproveedorAux: detalleevaluacionproveedors) {
			if(detalleevaluacionproveedorAux!=null && detalleevaluacionproveedor!=null) {
				if((detalleevaluacionproveedorAux.getId()==null && detalleevaluacionproveedor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalleevaluacionproveedorAux.getId()!=null && detalleevaluacionproveedor.getId()!=null){
					if(detalleevaluacionproveedorAux.getId().equals(detalleevaluacionproveedor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleEvaluacionProveedor(List<DetalleEvaluacionProveedor> detalleevaluacionproveedors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(DetalleEvaluacionProveedor detalleevaluacionproveedor: detalleevaluacionproveedors) {			
			if(detalleevaluacionproveedor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleEvaluacionProveedor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleEvaluacionProveedorConstantesFunciones.LABEL_ID, DetalleEvaluacionProveedorConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionProveedorConstantesFunciones.LABEL_VERSIONROW, DetalleEvaluacionProveedorConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDEMPRESA, DetalleEvaluacionProveedorConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDSUCURSAL, DetalleEvaluacionProveedorConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDEJERCICIO, DetalleEvaluacionProveedorConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDPERIODO, DetalleEvaluacionProveedorConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDEVALUACIONPROVEEDOR, DetalleEvaluacionProveedorConstantesFunciones.IDEVALUACIONPROVEEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDPREGUNTAEVALUACION, DetalleEvaluacionProveedorConstantesFunciones.IDPREGUNTAEVALUACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDSUBPREGUNTAEVALUACION, DetalleEvaluacionProveedorConstantesFunciones.IDSUBPREGUNTAEVALUACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDSINO, DetalleEvaluacionProveedorConstantesFunciones.IDSINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleEvaluacionProveedorConstantesFunciones.LABEL_DESCRIPCION, DetalleEvaluacionProveedorConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleEvaluacionProveedor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionProveedorConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionProveedorConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionProveedorConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionProveedorConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionProveedorConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionProveedorConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionProveedorConstantesFunciones.IDEVALUACIONPROVEEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionProveedorConstantesFunciones.IDPREGUNTAEVALUACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionProveedorConstantesFunciones.IDSUBPREGUNTAEVALUACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionProveedorConstantesFunciones.IDSINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleEvaluacionProveedorConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleEvaluacionProveedor() throws Exception  {
		return DetalleEvaluacionProveedorConstantesFunciones.getTiposSeleccionarDetalleEvaluacionProveedor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleEvaluacionProveedor(Boolean conFk) throws Exception  {
		return DetalleEvaluacionProveedorConstantesFunciones.getTiposSeleccionarDetalleEvaluacionProveedor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleEvaluacionProveedor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDEVALUACIONPROVEEDOR);
			reporte.setsDescripcion(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDEVALUACIONPROVEEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDPREGUNTAEVALUACION);
			reporte.setsDescripcion(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDPREGUNTAEVALUACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDSUBPREGUNTAEVALUACION);
			reporte.setsDescripcion(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDSUBPREGUNTAEVALUACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDSINO);
			reporte.setsDescripcion(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDSINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleEvaluacionProveedorConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleEvaluacionProveedorConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleEvaluacionProveedor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(DetalleEvaluacionProveedor detalleevaluacionproveedorAux) throws Exception {
		
			detalleevaluacionproveedorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleevaluacionproveedorAux.getEmpresa()));
			detalleevaluacionproveedorAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleevaluacionproveedorAux.getSucursal()));
			detalleevaluacionproveedorAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleevaluacionproveedorAux.getEjercicio()));
			detalleevaluacionproveedorAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalleevaluacionproveedorAux.getPeriodo()));
			detalleevaluacionproveedorAux.setevaluacionproveedor_descripcion(EvaluacionProveedorConstantesFunciones.getEvaluacionProveedorDescripcion(detalleevaluacionproveedorAux.getEvaluacionProveedor()));
			detalleevaluacionproveedorAux.setpreguntaevaluacion_descripcion(PreguntaEvaluacionConstantesFunciones.getPreguntaEvaluacionDescripcion(detalleevaluacionproveedorAux.getPreguntaEvaluacion()));
			detalleevaluacionproveedorAux.setsubpreguntaevaluacion_descripcion(SubPreguntaEvaluacionConstantesFunciones.getSubPreguntaEvaluacionDescripcion(detalleevaluacionproveedorAux.getSubPreguntaEvaluacion()));
			detalleevaluacionproveedorAux.setsino_descripcion(SiNoConstantesFunciones.getSiNoDescripcion(detalleevaluacionproveedorAux.getSiNo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(List<DetalleEvaluacionProveedor> detalleevaluacionproveedorsTemp) throws Exception {
		for(DetalleEvaluacionProveedor detalleevaluacionproveedorAux:detalleevaluacionproveedorsTemp) {
			
			detalleevaluacionproveedorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleevaluacionproveedorAux.getEmpresa()));
			detalleevaluacionproveedorAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleevaluacionproveedorAux.getSucursal()));
			detalleevaluacionproveedorAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleevaluacionproveedorAux.getEjercicio()));
			detalleevaluacionproveedorAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalleevaluacionproveedorAux.getPeriodo()));
			detalleevaluacionproveedorAux.setevaluacionproveedor_descripcion(EvaluacionProveedorConstantesFunciones.getEvaluacionProveedorDescripcion(detalleevaluacionproveedorAux.getEvaluacionProveedor()));
			detalleevaluacionproveedorAux.setpreguntaevaluacion_descripcion(PreguntaEvaluacionConstantesFunciones.getPreguntaEvaluacionDescripcion(detalleevaluacionproveedorAux.getPreguntaEvaluacion()));
			detalleevaluacionproveedorAux.setsubpreguntaevaluacion_descripcion(SubPreguntaEvaluacionConstantesFunciones.getSubPreguntaEvaluacionDescripcion(detalleevaluacionproveedorAux.getSubPreguntaEvaluacion()));
			detalleevaluacionproveedorAux.setsino_descripcion(SiNoConstantesFunciones.getSiNoDescripcion(detalleevaluacionproveedorAux.getSiNo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleEvaluacionProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(EvaluacionProveedor.class));
				classes.add(new Classe(PreguntaEvaluacion.class));
				classes.add(new Classe(SubPreguntaEvaluacion.class));
				classes.add(new Classe(SiNo.class));
				
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
					if(clas.clas.equals(EvaluacionProveedor.class)) {
						classes.add(new Classe(EvaluacionProveedor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PreguntaEvaluacion.class)) {
						classes.add(new Classe(PreguntaEvaluacion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SubPreguntaEvaluacion.class)) {
						classes.add(new Classe(SubPreguntaEvaluacion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SiNo.class)) {
						classes.add(new Classe(SiNo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleEvaluacionProveedor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(EvaluacionProveedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EvaluacionProveedor.class)); continue;
					}

					if(PreguntaEvaluacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PreguntaEvaluacion.class)); continue;
					}

					if(SubPreguntaEvaluacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubPreguntaEvaluacion.class)); continue;
					}

					if(SiNo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SiNo.class)); continue;
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

					if(EvaluacionProveedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EvaluacionProveedor.class)); continue;
					}

					if(PreguntaEvaluacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PreguntaEvaluacion.class)); continue;
					}

					if(SubPreguntaEvaluacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubPreguntaEvaluacion.class)); continue;
					}

					if(SiNo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SiNo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleEvaluacionProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleEvaluacionProveedorConstantesFunciones.getClassesRelationshipsOfDetalleEvaluacionProveedor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleEvaluacionProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleEvaluacionProveedor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleEvaluacionProveedorConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleEvaluacionProveedor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleEvaluacionProveedor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleEvaluacionProveedor detalleevaluacionproveedor,List<DetalleEvaluacionProveedor> detalleevaluacionproveedors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleEvaluacionProveedor detalleevaluacionproveedorEncontrado=null;
			
			for(DetalleEvaluacionProveedor detalleevaluacionproveedorLocal:detalleevaluacionproveedors) {
				if(detalleevaluacionproveedorLocal.getId().equals(detalleevaluacionproveedor.getId())) {
					detalleevaluacionproveedorEncontrado=detalleevaluacionproveedorLocal;
					
					detalleevaluacionproveedorLocal.setIsChanged(detalleevaluacionproveedor.getIsChanged());
					detalleevaluacionproveedorLocal.setIsNew(detalleevaluacionproveedor.getIsNew());
					detalleevaluacionproveedorLocal.setIsDeleted(detalleevaluacionproveedor.getIsDeleted());
					
					detalleevaluacionproveedorLocal.setGeneralEntityOriginal(detalleevaluacionproveedor.getGeneralEntityOriginal());
					
					detalleevaluacionproveedorLocal.setId(detalleevaluacionproveedor.getId());	
					detalleevaluacionproveedorLocal.setVersionRow(detalleevaluacionproveedor.getVersionRow());	
					detalleevaluacionproveedorLocal.setid_empresa(detalleevaluacionproveedor.getid_empresa());	
					detalleevaluacionproveedorLocal.setid_sucursal(detalleevaluacionproveedor.getid_sucursal());	
					detalleevaluacionproveedorLocal.setid_ejercicio(detalleevaluacionproveedor.getid_ejercicio());	
					detalleevaluacionproveedorLocal.setid_periodo(detalleevaluacionproveedor.getid_periodo());	
					detalleevaluacionproveedorLocal.setid_evaluacion_proveedor(detalleevaluacionproveedor.getid_evaluacion_proveedor());	
					detalleevaluacionproveedorLocal.setid_pregunta_evaluacion(detalleevaluacionproveedor.getid_pregunta_evaluacion());	
					detalleevaluacionproveedorLocal.setid_sub_pregunta_evaluacion(detalleevaluacionproveedor.getid_sub_pregunta_evaluacion());	
					detalleevaluacionproveedorLocal.setid_si_no(detalleevaluacionproveedor.getid_si_no());	
					detalleevaluacionproveedorLocal.setdescripcion(detalleevaluacionproveedor.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detalleevaluacionproveedor.getIsDeleted()) {
				if(!existe) {
					detalleevaluacionproveedors.add(detalleevaluacionproveedor);
				}
			} else {
				if(detalleevaluacionproveedorEncontrado!=null && permiteQuitar)  {
					detalleevaluacionproveedors.remove(detalleevaluacionproveedorEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleEvaluacionProveedor detalleevaluacionproveedor,List<DetalleEvaluacionProveedor> detalleevaluacionproveedors) throws Exception {
		try	{			
			for(DetalleEvaluacionProveedor detalleevaluacionproveedorLocal:detalleevaluacionproveedors) {
				if(detalleevaluacionproveedorLocal.getId().equals(detalleevaluacionproveedor.getId())) {
					detalleevaluacionproveedorLocal.setIsSelected(detalleevaluacionproveedor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleEvaluacionProveedor(List<DetalleEvaluacionProveedor> detalleevaluacionproveedorsAux) throws Exception {
		//this.detalleevaluacionproveedorsAux=detalleevaluacionproveedorsAux;
		
		for(DetalleEvaluacionProveedor detalleevaluacionproveedorAux:detalleevaluacionproveedorsAux) {
			if(detalleevaluacionproveedorAux.getIsChanged()) {
				detalleevaluacionproveedorAux.setIsChanged(false);
			}		
			
			if(detalleevaluacionproveedorAux.getIsNew()) {
				detalleevaluacionproveedorAux.setIsNew(false);
			}	
			
			if(detalleevaluacionproveedorAux.getIsDeleted()) {
				detalleevaluacionproveedorAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleEvaluacionProveedor(DetalleEvaluacionProveedor detalleevaluacionproveedorAux) throws Exception {
		//this.detalleevaluacionproveedorAux=detalleevaluacionproveedorAux;
		
			if(detalleevaluacionproveedorAux.getIsChanged()) {
				detalleevaluacionproveedorAux.setIsChanged(false);
			}		
			
			if(detalleevaluacionproveedorAux.getIsNew()) {
				detalleevaluacionproveedorAux.setIsNew(false);
			}	
			
			if(detalleevaluacionproveedorAux.getIsDeleted()) {
				detalleevaluacionproveedorAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleEvaluacionProveedor detalleevaluacionproveedorAsignar,DetalleEvaluacionProveedor detalleevaluacionproveedor) throws Exception {
		detalleevaluacionproveedorAsignar.setId(detalleevaluacionproveedor.getId());	
		detalleevaluacionproveedorAsignar.setVersionRow(detalleevaluacionproveedor.getVersionRow());	
		detalleevaluacionproveedorAsignar.setid_empresa(detalleevaluacionproveedor.getid_empresa());
		detalleevaluacionproveedorAsignar.setempresa_descripcion(detalleevaluacionproveedor.getempresa_descripcion());	
		detalleevaluacionproveedorAsignar.setid_sucursal(detalleevaluacionproveedor.getid_sucursal());
		detalleevaluacionproveedorAsignar.setsucursal_descripcion(detalleevaluacionproveedor.getsucursal_descripcion());	
		detalleevaluacionproveedorAsignar.setid_ejercicio(detalleevaluacionproveedor.getid_ejercicio());
		detalleevaluacionproveedorAsignar.setejercicio_descripcion(detalleevaluacionproveedor.getejercicio_descripcion());	
		detalleevaluacionproveedorAsignar.setid_periodo(detalleevaluacionproveedor.getid_periodo());
		detalleevaluacionproveedorAsignar.setperiodo_descripcion(detalleevaluacionproveedor.getperiodo_descripcion());	
		detalleevaluacionproveedorAsignar.setid_evaluacion_proveedor(detalleevaluacionproveedor.getid_evaluacion_proveedor());
		detalleevaluacionproveedorAsignar.setevaluacionproveedor_descripcion(detalleevaluacionproveedor.getevaluacionproveedor_descripcion());	
		detalleevaluacionproveedorAsignar.setid_pregunta_evaluacion(detalleevaluacionproveedor.getid_pregunta_evaluacion());
		detalleevaluacionproveedorAsignar.setpreguntaevaluacion_descripcion(detalleevaluacionproveedor.getpreguntaevaluacion_descripcion());	
		detalleevaluacionproveedorAsignar.setid_sub_pregunta_evaluacion(detalleevaluacionproveedor.getid_sub_pregunta_evaluacion());
		detalleevaluacionproveedorAsignar.setsubpreguntaevaluacion_descripcion(detalleevaluacionproveedor.getsubpreguntaevaluacion_descripcion());	
		detalleevaluacionproveedorAsignar.setid_si_no(detalleevaluacionproveedor.getid_si_no());
		detalleevaluacionproveedorAsignar.setsino_descripcion(detalleevaluacionproveedor.getsino_descripcion());	
		detalleevaluacionproveedorAsignar.setdescripcion(detalleevaluacionproveedor.getdescripcion());	
	}
	
	public static void inicializarDetalleEvaluacionProveedor(DetalleEvaluacionProveedor detalleevaluacionproveedor) throws Exception {
		try {
				detalleevaluacionproveedor.setId(0L);	
					
				detalleevaluacionproveedor.setid_empresa(-1L);	
				detalleevaluacionproveedor.setid_sucursal(-1L);	
				detalleevaluacionproveedor.setid_ejercicio(-1L);	
				detalleevaluacionproveedor.setid_periodo(-1L);	
				detalleevaluacionproveedor.setid_evaluacion_proveedor(-1L);	
				detalleevaluacionproveedor.setid_pregunta_evaluacion(-1L);	
				detalleevaluacionproveedor.setid_sub_pregunta_evaluacion(-1L);	
				detalleevaluacionproveedor.setid_si_no(-1L);	
				detalleevaluacionproveedor.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleEvaluacionProveedor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDEVALUACIONPROVEEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDPREGUNTAEVALUACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDSUBPREGUNTAEVALUACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionProveedorConstantesFunciones.LABEL_IDSINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleEvaluacionProveedorConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleEvaluacionProveedor(String sTipo,Row row,Workbook workbook,DetalleEvaluacionProveedor detalleevaluacionproveedor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleevaluacionproveedor.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleevaluacionproveedor.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleevaluacionproveedor.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleevaluacionproveedor.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleevaluacionproveedor.getevaluacionproveedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleevaluacionproveedor.getpreguntaevaluacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleevaluacionproveedor.getsubpreguntaevaluacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleevaluacionproveedor.getsino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleevaluacionproveedor.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleEvaluacionProveedor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleEvaluacionProveedor() {
		return this.sFinalQueryDetalleEvaluacionProveedor;
	}
	
	public void setsFinalQueryDetalleEvaluacionProveedor(String sFinalQueryDetalleEvaluacionProveedor) {
		this.sFinalQueryDetalleEvaluacionProveedor= sFinalQueryDetalleEvaluacionProveedor;
	}
	
	public Border resaltarSeleccionarDetalleEvaluacionProveedor=null;
	
	public Border setResaltarSeleccionarDetalleEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionProveedorBeanSwingJInternalFrame detalleevaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detalleevaluacionproveedorBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleEvaluacionProveedor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleEvaluacionProveedor() {
		return this.resaltarSeleccionarDetalleEvaluacionProveedor;
	}
	
	public void setResaltarSeleccionarDetalleEvaluacionProveedor(Border borderResaltarSeleccionarDetalleEvaluacionProveedor) {
		this.resaltarSeleccionarDetalleEvaluacionProveedor= borderResaltarSeleccionarDetalleEvaluacionProveedor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleEvaluacionProveedor=null;
	public Boolean mostraridDetalleEvaluacionProveedor=true;
	public Boolean activaridDetalleEvaluacionProveedor=true;

	public Border resaltarid_empresaDetalleEvaluacionProveedor=null;
	public Boolean mostrarid_empresaDetalleEvaluacionProveedor=true;
	public Boolean activarid_empresaDetalleEvaluacionProveedor=true;
	public Boolean cargarid_empresaDetalleEvaluacionProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleEvaluacionProveedor=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleEvaluacionProveedor=null;
	public Boolean mostrarid_sucursalDetalleEvaluacionProveedor=true;
	public Boolean activarid_sucursalDetalleEvaluacionProveedor=true;
	public Boolean cargarid_sucursalDetalleEvaluacionProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleEvaluacionProveedor=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetalleEvaluacionProveedor=null;
	public Boolean mostrarid_ejercicioDetalleEvaluacionProveedor=true;
	public Boolean activarid_ejercicioDetalleEvaluacionProveedor=true;
	public Boolean cargarid_ejercicioDetalleEvaluacionProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetalleEvaluacionProveedor=false;//ConEventDepend=true

	public Border resaltarid_periodoDetalleEvaluacionProveedor=null;
	public Boolean mostrarid_periodoDetalleEvaluacionProveedor=true;
	public Boolean activarid_periodoDetalleEvaluacionProveedor=true;
	public Boolean cargarid_periodoDetalleEvaluacionProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetalleEvaluacionProveedor=false;//ConEventDepend=true

	public Border resaltarid_evaluacion_proveedorDetalleEvaluacionProveedor=null;
	public Boolean mostrarid_evaluacion_proveedorDetalleEvaluacionProveedor=true;
	public Boolean activarid_evaluacion_proveedorDetalleEvaluacionProveedor=true;
	public Boolean cargarid_evaluacion_proveedorDetalleEvaluacionProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_evaluacion_proveedorDetalleEvaluacionProveedor=false;//ConEventDepend=true

	public Border resaltarid_pregunta_evaluacionDetalleEvaluacionProveedor=null;
	public Boolean mostrarid_pregunta_evaluacionDetalleEvaluacionProveedor=true;
	public Boolean activarid_pregunta_evaluacionDetalleEvaluacionProveedor=true;
	public Boolean cargarid_pregunta_evaluacionDetalleEvaluacionProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_pregunta_evaluacionDetalleEvaluacionProveedor=false;//ConEventDepend=true

	public Border resaltarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor=null;
	public Boolean mostrarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor=true;
	public Boolean activarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor=true;
	public Boolean cargarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sub_pregunta_evaluacionDetalleEvaluacionProveedor=false;//ConEventDepend=true

	public Border resaltarid_si_noDetalleEvaluacionProveedor=null;
	public Boolean mostrarid_si_noDetalleEvaluacionProveedor=true;
	public Boolean activarid_si_noDetalleEvaluacionProveedor=true;
	public Boolean cargarid_si_noDetalleEvaluacionProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_si_noDetalleEvaluacionProveedor=false;//ConEventDepend=true

	public Border resaltardescripcionDetalleEvaluacionProveedor=null;
	public Boolean mostrardescripcionDetalleEvaluacionProveedor=true;
	public Boolean activardescripcionDetalleEvaluacionProveedor=true;

	
	

	public Border setResaltaridDetalleEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionProveedorBeanSwingJInternalFrame detalleevaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionproveedorBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltaridDetalleEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleEvaluacionProveedor() {
		return this.resaltaridDetalleEvaluacionProveedor;
	}

	public void setResaltaridDetalleEvaluacionProveedor(Border borderResaltar) {
		this.resaltaridDetalleEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostraridDetalleEvaluacionProveedor() {
		return this.mostraridDetalleEvaluacionProveedor;
	}

	public void setMostraridDetalleEvaluacionProveedor(Boolean mostraridDetalleEvaluacionProveedor) {
		this.mostraridDetalleEvaluacionProveedor= mostraridDetalleEvaluacionProveedor;
	}

	public Boolean getActivaridDetalleEvaluacionProveedor() {
		return this.activaridDetalleEvaluacionProveedor;
	}

	public void setActivaridDetalleEvaluacionProveedor(Boolean activaridDetalleEvaluacionProveedor) {
		this.activaridDetalleEvaluacionProveedor= activaridDetalleEvaluacionProveedor;
	}

	public Border setResaltarid_empresaDetalleEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionProveedorBeanSwingJInternalFrame detalleevaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionproveedorBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleEvaluacionProveedor() {
		return this.resaltarid_empresaDetalleEvaluacionProveedor;
	}

	public void setResaltarid_empresaDetalleEvaluacionProveedor(Border borderResaltar) {
		this.resaltarid_empresaDetalleEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleEvaluacionProveedor() {
		return this.mostrarid_empresaDetalleEvaluacionProveedor;
	}

	public void setMostrarid_empresaDetalleEvaluacionProveedor(Boolean mostrarid_empresaDetalleEvaluacionProveedor) {
		this.mostrarid_empresaDetalleEvaluacionProveedor= mostrarid_empresaDetalleEvaluacionProveedor;
	}

	public Boolean getActivarid_empresaDetalleEvaluacionProveedor() {
		return this.activarid_empresaDetalleEvaluacionProveedor;
	}

	public void setActivarid_empresaDetalleEvaluacionProveedor(Boolean activarid_empresaDetalleEvaluacionProveedor) {
		this.activarid_empresaDetalleEvaluacionProveedor= activarid_empresaDetalleEvaluacionProveedor;
	}

	public Boolean getCargarid_empresaDetalleEvaluacionProveedor() {
		return this.cargarid_empresaDetalleEvaluacionProveedor;
	}

	public void setCargarid_empresaDetalleEvaluacionProveedor(Boolean cargarid_empresaDetalleEvaluacionProveedor) {
		this.cargarid_empresaDetalleEvaluacionProveedor= cargarid_empresaDetalleEvaluacionProveedor;
	}

	public Border setResaltarid_sucursalDetalleEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionProveedorBeanSwingJInternalFrame detalleevaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionproveedorBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleEvaluacionProveedor() {
		return this.resaltarid_sucursalDetalleEvaluacionProveedor;
	}

	public void setResaltarid_sucursalDetalleEvaluacionProveedor(Border borderResaltar) {
		this.resaltarid_sucursalDetalleEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleEvaluacionProveedor() {
		return this.mostrarid_sucursalDetalleEvaluacionProveedor;
	}

	public void setMostrarid_sucursalDetalleEvaluacionProveedor(Boolean mostrarid_sucursalDetalleEvaluacionProveedor) {
		this.mostrarid_sucursalDetalleEvaluacionProveedor= mostrarid_sucursalDetalleEvaluacionProveedor;
	}

	public Boolean getActivarid_sucursalDetalleEvaluacionProveedor() {
		return this.activarid_sucursalDetalleEvaluacionProveedor;
	}

	public void setActivarid_sucursalDetalleEvaluacionProveedor(Boolean activarid_sucursalDetalleEvaluacionProveedor) {
		this.activarid_sucursalDetalleEvaluacionProveedor= activarid_sucursalDetalleEvaluacionProveedor;
	}

	public Boolean getCargarid_sucursalDetalleEvaluacionProveedor() {
		return this.cargarid_sucursalDetalleEvaluacionProveedor;
	}

	public void setCargarid_sucursalDetalleEvaluacionProveedor(Boolean cargarid_sucursalDetalleEvaluacionProveedor) {
		this.cargarid_sucursalDetalleEvaluacionProveedor= cargarid_sucursalDetalleEvaluacionProveedor;
	}

	public Border setResaltarid_ejercicioDetalleEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionProveedorBeanSwingJInternalFrame detalleevaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionproveedorBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetalleEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetalleEvaluacionProveedor() {
		return this.resaltarid_ejercicioDetalleEvaluacionProveedor;
	}

	public void setResaltarid_ejercicioDetalleEvaluacionProveedor(Border borderResaltar) {
		this.resaltarid_ejercicioDetalleEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetalleEvaluacionProveedor() {
		return this.mostrarid_ejercicioDetalleEvaluacionProveedor;
	}

	public void setMostrarid_ejercicioDetalleEvaluacionProveedor(Boolean mostrarid_ejercicioDetalleEvaluacionProveedor) {
		this.mostrarid_ejercicioDetalleEvaluacionProveedor= mostrarid_ejercicioDetalleEvaluacionProveedor;
	}

	public Boolean getActivarid_ejercicioDetalleEvaluacionProveedor() {
		return this.activarid_ejercicioDetalleEvaluacionProveedor;
	}

	public void setActivarid_ejercicioDetalleEvaluacionProveedor(Boolean activarid_ejercicioDetalleEvaluacionProveedor) {
		this.activarid_ejercicioDetalleEvaluacionProveedor= activarid_ejercicioDetalleEvaluacionProveedor;
	}

	public Boolean getCargarid_ejercicioDetalleEvaluacionProveedor() {
		return this.cargarid_ejercicioDetalleEvaluacionProveedor;
	}

	public void setCargarid_ejercicioDetalleEvaluacionProveedor(Boolean cargarid_ejercicioDetalleEvaluacionProveedor) {
		this.cargarid_ejercicioDetalleEvaluacionProveedor= cargarid_ejercicioDetalleEvaluacionProveedor;
	}

	public Border setResaltarid_periodoDetalleEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionProveedorBeanSwingJInternalFrame detalleevaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionproveedorBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetalleEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetalleEvaluacionProveedor() {
		return this.resaltarid_periodoDetalleEvaluacionProveedor;
	}

	public void setResaltarid_periodoDetalleEvaluacionProveedor(Border borderResaltar) {
		this.resaltarid_periodoDetalleEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetalleEvaluacionProveedor() {
		return this.mostrarid_periodoDetalleEvaluacionProveedor;
	}

	public void setMostrarid_periodoDetalleEvaluacionProveedor(Boolean mostrarid_periodoDetalleEvaluacionProveedor) {
		this.mostrarid_periodoDetalleEvaluacionProveedor= mostrarid_periodoDetalleEvaluacionProveedor;
	}

	public Boolean getActivarid_periodoDetalleEvaluacionProveedor() {
		return this.activarid_periodoDetalleEvaluacionProveedor;
	}

	public void setActivarid_periodoDetalleEvaluacionProveedor(Boolean activarid_periodoDetalleEvaluacionProveedor) {
		this.activarid_periodoDetalleEvaluacionProveedor= activarid_periodoDetalleEvaluacionProveedor;
	}

	public Boolean getCargarid_periodoDetalleEvaluacionProveedor() {
		return this.cargarid_periodoDetalleEvaluacionProveedor;
	}

	public void setCargarid_periodoDetalleEvaluacionProveedor(Boolean cargarid_periodoDetalleEvaluacionProveedor) {
		this.cargarid_periodoDetalleEvaluacionProveedor= cargarid_periodoDetalleEvaluacionProveedor;
	}

	public Border setResaltarid_evaluacion_proveedorDetalleEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionProveedorBeanSwingJInternalFrame detalleevaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionproveedorBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarid_evaluacion_proveedorDetalleEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_evaluacion_proveedorDetalleEvaluacionProveedor() {
		return this.resaltarid_evaluacion_proveedorDetalleEvaluacionProveedor;
	}

	public void setResaltarid_evaluacion_proveedorDetalleEvaluacionProveedor(Border borderResaltar) {
		this.resaltarid_evaluacion_proveedorDetalleEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostrarid_evaluacion_proveedorDetalleEvaluacionProveedor() {
		return this.mostrarid_evaluacion_proveedorDetalleEvaluacionProveedor;
	}

	public void setMostrarid_evaluacion_proveedorDetalleEvaluacionProveedor(Boolean mostrarid_evaluacion_proveedorDetalleEvaluacionProveedor) {
		this.mostrarid_evaluacion_proveedorDetalleEvaluacionProveedor= mostrarid_evaluacion_proveedorDetalleEvaluacionProveedor;
	}

	public Boolean getActivarid_evaluacion_proveedorDetalleEvaluacionProveedor() {
		return this.activarid_evaluacion_proveedorDetalleEvaluacionProveedor;
	}

	public void setActivarid_evaluacion_proveedorDetalleEvaluacionProveedor(Boolean activarid_evaluacion_proveedorDetalleEvaluacionProveedor) {
		this.activarid_evaluacion_proveedorDetalleEvaluacionProveedor= activarid_evaluacion_proveedorDetalleEvaluacionProveedor;
	}

	public Boolean getCargarid_evaluacion_proveedorDetalleEvaluacionProveedor() {
		return this.cargarid_evaluacion_proveedorDetalleEvaluacionProveedor;
	}

	public void setCargarid_evaluacion_proveedorDetalleEvaluacionProveedor(Boolean cargarid_evaluacion_proveedorDetalleEvaluacionProveedor) {
		this.cargarid_evaluacion_proveedorDetalleEvaluacionProveedor= cargarid_evaluacion_proveedorDetalleEvaluacionProveedor;
	}

	public Border setResaltarid_pregunta_evaluacionDetalleEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionProveedorBeanSwingJInternalFrame detalleevaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionproveedorBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarid_pregunta_evaluacionDetalleEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_pregunta_evaluacionDetalleEvaluacionProveedor() {
		return this.resaltarid_pregunta_evaluacionDetalleEvaluacionProveedor;
	}

	public void setResaltarid_pregunta_evaluacionDetalleEvaluacionProveedor(Border borderResaltar) {
		this.resaltarid_pregunta_evaluacionDetalleEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostrarid_pregunta_evaluacionDetalleEvaluacionProveedor() {
		return this.mostrarid_pregunta_evaluacionDetalleEvaluacionProveedor;
	}

	public void setMostrarid_pregunta_evaluacionDetalleEvaluacionProveedor(Boolean mostrarid_pregunta_evaluacionDetalleEvaluacionProveedor) {
		this.mostrarid_pregunta_evaluacionDetalleEvaluacionProveedor= mostrarid_pregunta_evaluacionDetalleEvaluacionProveedor;
	}

	public Boolean getActivarid_pregunta_evaluacionDetalleEvaluacionProveedor() {
		return this.activarid_pregunta_evaluacionDetalleEvaluacionProveedor;
	}

	public void setActivarid_pregunta_evaluacionDetalleEvaluacionProveedor(Boolean activarid_pregunta_evaluacionDetalleEvaluacionProveedor) {
		this.activarid_pregunta_evaluacionDetalleEvaluacionProveedor= activarid_pregunta_evaluacionDetalleEvaluacionProveedor;
	}

	public Boolean getCargarid_pregunta_evaluacionDetalleEvaluacionProveedor() {
		return this.cargarid_pregunta_evaluacionDetalleEvaluacionProveedor;
	}

	public void setCargarid_pregunta_evaluacionDetalleEvaluacionProveedor(Boolean cargarid_pregunta_evaluacionDetalleEvaluacionProveedor) {
		this.cargarid_pregunta_evaluacionDetalleEvaluacionProveedor= cargarid_pregunta_evaluacionDetalleEvaluacionProveedor;
	}

	public Border setResaltarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionProveedorBeanSwingJInternalFrame detalleevaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionproveedorBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor() {
		return this.resaltarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor;
	}

	public void setResaltarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor(Border borderResaltar) {
		this.resaltarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostrarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor() {
		return this.mostrarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor;
	}

	public void setMostrarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor(Boolean mostrarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor) {
		this.mostrarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor= mostrarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor;
	}

	public Boolean getActivarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor() {
		return this.activarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor;
	}

	public void setActivarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor(Boolean activarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor) {
		this.activarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor= activarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor;
	}

	public Boolean getCargarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor() {
		return this.cargarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor;
	}

	public void setCargarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor(Boolean cargarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor) {
		this.cargarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor= cargarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor;
	}

	public Border setResaltarid_si_noDetalleEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionProveedorBeanSwingJInternalFrame detalleevaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionproveedorBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarid_si_noDetalleEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_si_noDetalleEvaluacionProveedor() {
		return this.resaltarid_si_noDetalleEvaluacionProveedor;
	}

	public void setResaltarid_si_noDetalleEvaluacionProveedor(Border borderResaltar) {
		this.resaltarid_si_noDetalleEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostrarid_si_noDetalleEvaluacionProveedor() {
		return this.mostrarid_si_noDetalleEvaluacionProveedor;
	}

	public void setMostrarid_si_noDetalleEvaluacionProveedor(Boolean mostrarid_si_noDetalleEvaluacionProveedor) {
		this.mostrarid_si_noDetalleEvaluacionProveedor= mostrarid_si_noDetalleEvaluacionProveedor;
	}

	public Boolean getActivarid_si_noDetalleEvaluacionProveedor() {
		return this.activarid_si_noDetalleEvaluacionProveedor;
	}

	public void setActivarid_si_noDetalleEvaluacionProveedor(Boolean activarid_si_noDetalleEvaluacionProveedor) {
		this.activarid_si_noDetalleEvaluacionProveedor= activarid_si_noDetalleEvaluacionProveedor;
	}

	public Boolean getCargarid_si_noDetalleEvaluacionProveedor() {
		return this.cargarid_si_noDetalleEvaluacionProveedor;
	}

	public void setCargarid_si_noDetalleEvaluacionProveedor(Boolean cargarid_si_noDetalleEvaluacionProveedor) {
		this.cargarid_si_noDetalleEvaluacionProveedor= cargarid_si_noDetalleEvaluacionProveedor;
	}

	public Border setResaltardescripcionDetalleEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionProveedorBeanSwingJInternalFrame detalleevaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleevaluacionproveedorBeanSwingJInternalFrame.jTtoolBarDetalleEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltardescripcionDetalleEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleEvaluacionProveedor() {
		return this.resaltardescripcionDetalleEvaluacionProveedor;
	}

	public void setResaltardescripcionDetalleEvaluacionProveedor(Border borderResaltar) {
		this.resaltardescripcionDetalleEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleEvaluacionProveedor() {
		return this.mostrardescripcionDetalleEvaluacionProveedor;
	}

	public void setMostrardescripcionDetalleEvaluacionProveedor(Boolean mostrardescripcionDetalleEvaluacionProveedor) {
		this.mostrardescripcionDetalleEvaluacionProveedor= mostrardescripcionDetalleEvaluacionProveedor;
	}

	public Boolean getActivardescripcionDetalleEvaluacionProveedor() {
		return this.activardescripcionDetalleEvaluacionProveedor;
	}

	public void setActivardescripcionDetalleEvaluacionProveedor(Boolean activardescripcionDetalleEvaluacionProveedor) {
		this.activardescripcionDetalleEvaluacionProveedor= activardescripcionDetalleEvaluacionProveedor;
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
		
		
		this.setMostraridDetalleEvaluacionProveedor(esInicial);
		this.setMostrarid_empresaDetalleEvaluacionProveedor(esInicial);
		this.setMostrarid_sucursalDetalleEvaluacionProveedor(esInicial);
		this.setMostrarid_ejercicioDetalleEvaluacionProveedor(esInicial);
		this.setMostrarid_periodoDetalleEvaluacionProveedor(esInicial);
		this.setMostrarid_evaluacion_proveedorDetalleEvaluacionProveedor(esInicial);
		this.setMostrarid_pregunta_evaluacionDetalleEvaluacionProveedor(esInicial);
		this.setMostrarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor(esInicial);
		this.setMostrarid_si_noDetalleEvaluacionProveedor(esInicial);
		this.setMostrardescripcionDetalleEvaluacionProveedor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.ID)) {
				this.setMostraridDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDEVALUACIONPROVEEDOR)) {
				this.setMostrarid_evaluacion_proveedorDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDPREGUNTAEVALUACION)) {
				this.setMostrarid_pregunta_evaluacionDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDSUBPREGUNTAEVALUACION)) {
				this.setMostrarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDSINO)) {
				this.setMostrarid_si_noDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleEvaluacionProveedor(esAsigna);
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
		
		
		this.setActivaridDetalleEvaluacionProveedor(esInicial);
		this.setActivarid_empresaDetalleEvaluacionProveedor(esInicial);
		this.setActivarid_sucursalDetalleEvaluacionProveedor(esInicial);
		this.setActivarid_ejercicioDetalleEvaluacionProveedor(esInicial);
		this.setActivarid_periodoDetalleEvaluacionProveedor(esInicial);
		this.setActivarid_evaluacion_proveedorDetalleEvaluacionProveedor(esInicial);
		this.setActivarid_pregunta_evaluacionDetalleEvaluacionProveedor(esInicial);
		this.setActivarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor(esInicial);
		this.setActivarid_si_noDetalleEvaluacionProveedor(esInicial);
		this.setActivardescripcionDetalleEvaluacionProveedor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.ID)) {
				this.setActivaridDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDEVALUACIONPROVEEDOR)) {
				this.setActivarid_evaluacion_proveedorDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDPREGUNTAEVALUACION)) {
				this.setActivarid_pregunta_evaluacionDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDSUBPREGUNTAEVALUACION)) {
				this.setActivarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDSINO)) {
				this.setActivarid_si_noDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleEvaluacionProveedor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleEvaluacionProveedorBeanSwingJInternalFrame detalleevaluacionproveedorBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleEvaluacionProveedor(esInicial);
		this.setResaltarid_empresaDetalleEvaluacionProveedor(esInicial);
		this.setResaltarid_sucursalDetalleEvaluacionProveedor(esInicial);
		this.setResaltarid_ejercicioDetalleEvaluacionProveedor(esInicial);
		this.setResaltarid_periodoDetalleEvaluacionProveedor(esInicial);
		this.setResaltarid_evaluacion_proveedorDetalleEvaluacionProveedor(esInicial);
		this.setResaltarid_pregunta_evaluacionDetalleEvaluacionProveedor(esInicial);
		this.setResaltarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor(esInicial);
		this.setResaltarid_si_noDetalleEvaluacionProveedor(esInicial);
		this.setResaltardescripcionDetalleEvaluacionProveedor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.ID)) {
				this.setResaltaridDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDEVALUACIONPROVEEDOR)) {
				this.setResaltarid_evaluacion_proveedorDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDPREGUNTAEVALUACION)) {
				this.setResaltarid_pregunta_evaluacionDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDSUBPREGUNTAEVALUACION)) {
				this.setResaltarid_sub_pregunta_evaluacionDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.IDSINO)) {
				this.setResaltarid_si_noDetalleEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleEvaluacionProveedorConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleEvaluacionProveedor(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleEvaluacionProveedorBeanSwingJInternalFrame detalleevaluacionproveedorBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEjercicioDetalleEvaluacionProveedor=true;

	public Boolean getMostrarFK_IdEjercicioDetalleEvaluacionProveedor() {
		return this.mostrarFK_IdEjercicioDetalleEvaluacionProveedor;
	}

	public void setMostrarFK_IdEjercicioDetalleEvaluacionProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetalleEvaluacionProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleEvaluacionProveedor=true;

	public Boolean getMostrarFK_IdEmpresaDetalleEvaluacionProveedor() {
		return this.mostrarFK_IdEmpresaDetalleEvaluacionProveedor;
	}

	public void setMostrarFK_IdEmpresaDetalleEvaluacionProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleEvaluacionProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEvaluacionProveedorDetalleEvaluacionProveedor=true;

	public Boolean getMostrarFK_IdEvaluacionProveedorDetalleEvaluacionProveedor() {
		return this.mostrarFK_IdEvaluacionProveedorDetalleEvaluacionProveedor;
	}

	public void setMostrarFK_IdEvaluacionProveedorDetalleEvaluacionProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEvaluacionProveedorDetalleEvaluacionProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetalleEvaluacionProveedor=true;

	public Boolean getMostrarFK_IdPeriodoDetalleEvaluacionProveedor() {
		return this.mostrarFK_IdPeriodoDetalleEvaluacionProveedor;
	}

	public void setMostrarFK_IdPeriodoDetalleEvaluacionProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetalleEvaluacionProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPreguntaEvaluacionDetalleEvaluacionProveedor=true;

	public Boolean getMostrarFK_IdPreguntaEvaluacionDetalleEvaluacionProveedor() {
		return this.mostrarFK_IdPreguntaEvaluacionDetalleEvaluacionProveedor;
	}

	public void setMostrarFK_IdPreguntaEvaluacionDetalleEvaluacionProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPreguntaEvaluacionDetalleEvaluacionProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSiNoDetalleEvaluacionProveedor=true;

	public Boolean getMostrarFK_IdSiNoDetalleEvaluacionProveedor() {
		return this.mostrarFK_IdSiNoDetalleEvaluacionProveedor;
	}

	public void setMostrarFK_IdSiNoDetalleEvaluacionProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSiNoDetalleEvaluacionProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSubPreguntaEvaluacionDetalleEvaluacionProveedor=true;

	public Boolean getMostrarFK_IdSubPreguntaEvaluacionDetalleEvaluacionProveedor() {
		return this.mostrarFK_IdSubPreguntaEvaluacionDetalleEvaluacionProveedor;
	}

	public void setMostrarFK_IdSubPreguntaEvaluacionDetalleEvaluacionProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSubPreguntaEvaluacionDetalleEvaluacionProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleEvaluacionProveedor=true;

	public Boolean getMostrarFK_IdSucursalDetalleEvaluacionProveedor() {
		return this.mostrarFK_IdSucursalDetalleEvaluacionProveedor;
	}

	public void setMostrarFK_IdSucursalDetalleEvaluacionProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleEvaluacionProveedor= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEjercicioDetalleEvaluacionProveedor=true;

	public Boolean getActivarFK_IdEjercicioDetalleEvaluacionProveedor() {
		return this.activarFK_IdEjercicioDetalleEvaluacionProveedor;
	}

	public void setActivarFK_IdEjercicioDetalleEvaluacionProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetalleEvaluacionProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleEvaluacionProveedor=true;

	public Boolean getActivarFK_IdEmpresaDetalleEvaluacionProveedor() {
		return this.activarFK_IdEmpresaDetalleEvaluacionProveedor;
	}

	public void setActivarFK_IdEmpresaDetalleEvaluacionProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleEvaluacionProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdEvaluacionProveedorDetalleEvaluacionProveedor=true;

	public Boolean getActivarFK_IdEvaluacionProveedorDetalleEvaluacionProveedor() {
		return this.activarFK_IdEvaluacionProveedorDetalleEvaluacionProveedor;
	}

	public void setActivarFK_IdEvaluacionProveedorDetalleEvaluacionProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdEvaluacionProveedorDetalleEvaluacionProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetalleEvaluacionProveedor=true;

	public Boolean getActivarFK_IdPeriodoDetalleEvaluacionProveedor() {
		return this.activarFK_IdPeriodoDetalleEvaluacionProveedor;
	}

	public void setActivarFK_IdPeriodoDetalleEvaluacionProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetalleEvaluacionProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdPreguntaEvaluacionDetalleEvaluacionProveedor=true;

	public Boolean getActivarFK_IdPreguntaEvaluacionDetalleEvaluacionProveedor() {
		return this.activarFK_IdPreguntaEvaluacionDetalleEvaluacionProveedor;
	}

	public void setActivarFK_IdPreguntaEvaluacionDetalleEvaluacionProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdPreguntaEvaluacionDetalleEvaluacionProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdSiNoDetalleEvaluacionProveedor=true;

	public Boolean getActivarFK_IdSiNoDetalleEvaluacionProveedor() {
		return this.activarFK_IdSiNoDetalleEvaluacionProveedor;
	}

	public void setActivarFK_IdSiNoDetalleEvaluacionProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdSiNoDetalleEvaluacionProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdSubPreguntaEvaluacionDetalleEvaluacionProveedor=true;

	public Boolean getActivarFK_IdSubPreguntaEvaluacionDetalleEvaluacionProveedor() {
		return this.activarFK_IdSubPreguntaEvaluacionDetalleEvaluacionProveedor;
	}

	public void setActivarFK_IdSubPreguntaEvaluacionDetalleEvaluacionProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdSubPreguntaEvaluacionDetalleEvaluacionProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleEvaluacionProveedor=true;

	public Boolean getActivarFK_IdSucursalDetalleEvaluacionProveedor() {
		return this.activarFK_IdSucursalDetalleEvaluacionProveedor;
	}

	public void setActivarFK_IdSucursalDetalleEvaluacionProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleEvaluacionProveedor= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEjercicioDetalleEvaluacionProveedor=null;

	public Border getResaltarFK_IdEjercicioDetalleEvaluacionProveedor() {
		return this.resaltarFK_IdEjercicioDetalleEvaluacionProveedor;
	}

	public void setResaltarFK_IdEjercicioDetalleEvaluacionProveedor(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetalleEvaluacionProveedor= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetalleEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionProveedorBeanSwingJInternalFrame detalleevaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetalleEvaluacionProveedor= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleEvaluacionProveedor=null;

	public Border getResaltarFK_IdEmpresaDetalleEvaluacionProveedor() {
		return this.resaltarFK_IdEmpresaDetalleEvaluacionProveedor;
	}

	public void setResaltarFK_IdEmpresaDetalleEvaluacionProveedor(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleEvaluacionProveedor= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionProveedorBeanSwingJInternalFrame detalleevaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleEvaluacionProveedor= borderResaltar;
	}

	public Border resaltarFK_IdEvaluacionProveedorDetalleEvaluacionProveedor=null;

	public Border getResaltarFK_IdEvaluacionProveedorDetalleEvaluacionProveedor() {
		return this.resaltarFK_IdEvaluacionProveedorDetalleEvaluacionProveedor;
	}

	public void setResaltarFK_IdEvaluacionProveedorDetalleEvaluacionProveedor(Border borderResaltar) {
		this.resaltarFK_IdEvaluacionProveedorDetalleEvaluacionProveedor= borderResaltar;
	}

	public void setResaltarFK_IdEvaluacionProveedorDetalleEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionProveedorBeanSwingJInternalFrame detalleevaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEvaluacionProveedorDetalleEvaluacionProveedor= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetalleEvaluacionProveedor=null;

	public Border getResaltarFK_IdPeriodoDetalleEvaluacionProveedor() {
		return this.resaltarFK_IdPeriodoDetalleEvaluacionProveedor;
	}

	public void setResaltarFK_IdPeriodoDetalleEvaluacionProveedor(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetalleEvaluacionProveedor= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetalleEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionProveedorBeanSwingJInternalFrame detalleevaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetalleEvaluacionProveedor= borderResaltar;
	}

	public Border resaltarFK_IdPreguntaEvaluacionDetalleEvaluacionProveedor=null;

	public Border getResaltarFK_IdPreguntaEvaluacionDetalleEvaluacionProveedor() {
		return this.resaltarFK_IdPreguntaEvaluacionDetalleEvaluacionProveedor;
	}

	public void setResaltarFK_IdPreguntaEvaluacionDetalleEvaluacionProveedor(Border borderResaltar) {
		this.resaltarFK_IdPreguntaEvaluacionDetalleEvaluacionProveedor= borderResaltar;
	}

	public void setResaltarFK_IdPreguntaEvaluacionDetalleEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionProveedorBeanSwingJInternalFrame detalleevaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPreguntaEvaluacionDetalleEvaluacionProveedor= borderResaltar;
	}

	public Border resaltarFK_IdSiNoDetalleEvaluacionProveedor=null;

	public Border getResaltarFK_IdSiNoDetalleEvaluacionProveedor() {
		return this.resaltarFK_IdSiNoDetalleEvaluacionProveedor;
	}

	public void setResaltarFK_IdSiNoDetalleEvaluacionProveedor(Border borderResaltar) {
		this.resaltarFK_IdSiNoDetalleEvaluacionProveedor= borderResaltar;
	}

	public void setResaltarFK_IdSiNoDetalleEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionProveedorBeanSwingJInternalFrame detalleevaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSiNoDetalleEvaluacionProveedor= borderResaltar;
	}

	public Border resaltarFK_IdSubPreguntaEvaluacionDetalleEvaluacionProveedor=null;

	public Border getResaltarFK_IdSubPreguntaEvaluacionDetalleEvaluacionProveedor() {
		return this.resaltarFK_IdSubPreguntaEvaluacionDetalleEvaluacionProveedor;
	}

	public void setResaltarFK_IdSubPreguntaEvaluacionDetalleEvaluacionProveedor(Border borderResaltar) {
		this.resaltarFK_IdSubPreguntaEvaluacionDetalleEvaluacionProveedor= borderResaltar;
	}

	public void setResaltarFK_IdSubPreguntaEvaluacionDetalleEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionProveedorBeanSwingJInternalFrame detalleevaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSubPreguntaEvaluacionDetalleEvaluacionProveedor= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleEvaluacionProveedor=null;

	public Border getResaltarFK_IdSucursalDetalleEvaluacionProveedor() {
		return this.resaltarFK_IdSucursalDetalleEvaluacionProveedor;
	}

	public void setResaltarFK_IdSucursalDetalleEvaluacionProveedor(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleEvaluacionProveedor= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleEvaluacionProveedorBeanSwingJInternalFrame detalleevaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleEvaluacionProveedor= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}