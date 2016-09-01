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


import com.bydan.erp.nomina.util.PeriodoAsistenciaConstantesFunciones;
import com.bydan.erp.nomina.util.PeriodoAsistenciaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.PeriodoAsistenciaParameterGeneral;

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
final public class PeriodoAsistenciaConstantesFunciones extends PeriodoAsistenciaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PeriodoAsistencia";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PeriodoAsistencia"+PeriodoAsistenciaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PeriodoAsistenciaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PeriodoAsistenciaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PeriodoAsistenciaConstantesFunciones.SCHEMA+"_"+PeriodoAsistenciaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PeriodoAsistenciaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PeriodoAsistenciaConstantesFunciones.SCHEMA+"_"+PeriodoAsistenciaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PeriodoAsistenciaConstantesFunciones.SCHEMA+"_"+PeriodoAsistenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PeriodoAsistenciaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PeriodoAsistenciaConstantesFunciones.SCHEMA+"_"+PeriodoAsistenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PeriodoAsistenciaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PeriodoAsistenciaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PeriodoAsistenciaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PeriodoAsistenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PeriodoAsistenciaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PeriodoAsistenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PeriodoAsistenciaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PeriodoAsistenciaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PeriodoAsistenciaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PeriodoAsistenciaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Periodo Asistencias";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Periodo Asistencia";
	public static final String SCLASSWEBTITULO_LOWER="Periodo Asistencia";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PeriodoAsistencia";
	public static final String OBJECTNAME="periodoasistencia";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="periodo_asistencia";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select periodoasistencia from "+PeriodoAsistenciaConstantesFunciones.SPERSISTENCENAME+" periodoasistencia";
	public static String QUERYSELECTNATIVE="select "+PeriodoAsistenciaConstantesFunciones.SCHEMA+"."+PeriodoAsistenciaConstantesFunciones.TABLENAME+".id,"+PeriodoAsistenciaConstantesFunciones.SCHEMA+"."+PeriodoAsistenciaConstantesFunciones.TABLENAME+".version_row,"+PeriodoAsistenciaConstantesFunciones.SCHEMA+"."+PeriodoAsistenciaConstantesFunciones.TABLENAME+".id_empresa,"+PeriodoAsistenciaConstantesFunciones.SCHEMA+"."+PeriodoAsistenciaConstantesFunciones.TABLENAME+".id_ejercicio,"+PeriodoAsistenciaConstantesFunciones.SCHEMA+"."+PeriodoAsistenciaConstantesFunciones.TABLENAME+".id_periodo,"+PeriodoAsistenciaConstantesFunciones.SCHEMA+"."+PeriodoAsistenciaConstantesFunciones.TABLENAME+".fecha_inicio,"+PeriodoAsistenciaConstantesFunciones.SCHEMA+"."+PeriodoAsistenciaConstantesFunciones.TABLENAME+".fecha_fin from "+PeriodoAsistenciaConstantesFunciones.SCHEMA+"."+PeriodoAsistenciaConstantesFunciones.TABLENAME;//+" as "+PeriodoAsistenciaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PeriodoAsistenciaConstantesFuncionesAdditional periodoasistenciaConstantesFuncionesAdditional=null;
	
	public PeriodoAsistenciaConstantesFuncionesAdditional getPeriodoAsistenciaConstantesFuncionesAdditional() {
		return this.periodoasistenciaConstantesFuncionesAdditional;
	}
	
	public void setPeriodoAsistenciaConstantesFuncionesAdditional(PeriodoAsistenciaConstantesFuncionesAdditional periodoasistenciaConstantesFuncionesAdditional) {
		try {
			this.periodoasistenciaConstantesFuncionesAdditional=periodoasistenciaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
	
		
		
		
		
		
		
		
	
	public static String getPeriodoAsistenciaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PeriodoAsistenciaConstantesFunciones.IDEMPRESA)) {sLabelColumna=PeriodoAsistenciaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PeriodoAsistenciaConstantesFunciones.IDEJERCICIO)) {sLabelColumna=PeriodoAsistenciaConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(PeriodoAsistenciaConstantesFunciones.IDPERIODO)) {sLabelColumna=PeriodoAsistenciaConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(PeriodoAsistenciaConstantesFunciones.FECHAINICIO)) {sLabelColumna=PeriodoAsistenciaConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(PeriodoAsistenciaConstantesFunciones.FECHAFIN)) {sLabelColumna=PeriodoAsistenciaConstantesFunciones.LABEL_FECHAFIN;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getPeriodoAsistenciaDescripcion(PeriodoAsistencia periodoasistencia) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(periodoasistencia !=null/* && periodoasistencia.getId()!=0*/) {
			if(periodoasistencia.getId()!=null) {
				sDescripcion=periodoasistencia.getId().toString();
			}//periodoasistenciaperiodoasistencia.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPeriodoAsistenciaDescripcionDetallado(PeriodoAsistencia periodoasistencia) {
		String sDescripcion="";
			
		sDescripcion+=PeriodoAsistenciaConstantesFunciones.ID+"=";
		sDescripcion+=periodoasistencia.getId().toString()+",";
		sDescripcion+=PeriodoAsistenciaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=periodoasistencia.getVersionRow().toString()+",";
		sDescripcion+=PeriodoAsistenciaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=periodoasistencia.getid_empresa().toString()+",";
		sDescripcion+=PeriodoAsistenciaConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=periodoasistencia.getid_ejercicio().toString()+",";
		sDescripcion+=PeriodoAsistenciaConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=periodoasistencia.getid_periodo().toString()+",";
		sDescripcion+=PeriodoAsistenciaConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=periodoasistencia.getfecha_inicio().toString()+",";
		sDescripcion+=PeriodoAsistenciaConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=periodoasistencia.getfecha_fin().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPeriodoAsistenciaDescripcion(PeriodoAsistencia periodoasistencia,String sValor) throws Exception {			
		if(periodoasistencia !=null) {
			//periodoasistenciaperiodoasistencia.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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
	
	
	
	
	
	
	public static void quitarEspaciosPeriodoAsistencia(PeriodoAsistencia periodoasistencia,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosPeriodoAsistencias(List<PeriodoAsistencia> periodoasistencias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PeriodoAsistencia periodoasistencia: periodoasistencias) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPeriodoAsistencia(PeriodoAsistencia periodoasistencia,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && periodoasistencia.getConCambioAuxiliar()) {
			periodoasistencia.setIsDeleted(periodoasistencia.getIsDeletedAuxiliar());	
			periodoasistencia.setIsNew(periodoasistencia.getIsNewAuxiliar());	
			periodoasistencia.setIsChanged(periodoasistencia.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			periodoasistencia.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			periodoasistencia.setIsDeletedAuxiliar(false);	
			periodoasistencia.setIsNewAuxiliar(false);	
			periodoasistencia.setIsChangedAuxiliar(false);
			
			periodoasistencia.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPeriodoAsistencias(List<PeriodoAsistencia> periodoasistencias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PeriodoAsistencia periodoasistencia : periodoasistencias) {
			if(conAsignarBase && periodoasistencia.getConCambioAuxiliar()) {
				periodoasistencia.setIsDeleted(periodoasistencia.getIsDeletedAuxiliar());	
				periodoasistencia.setIsNew(periodoasistencia.getIsNewAuxiliar());	
				periodoasistencia.setIsChanged(periodoasistencia.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				periodoasistencia.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				periodoasistencia.setIsDeletedAuxiliar(false);	
				periodoasistencia.setIsNewAuxiliar(false);	
				periodoasistencia.setIsChangedAuxiliar(false);
				
				periodoasistencia.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPeriodoAsistencia(PeriodoAsistencia periodoasistencia,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPeriodoAsistencias(List<PeriodoAsistencia> periodoasistencias,Boolean conEnteros) throws Exception  {
		
		for(PeriodoAsistencia periodoasistencia: periodoasistencias) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPeriodoAsistencia(List<PeriodoAsistencia> periodoasistencias,PeriodoAsistencia periodoasistenciaAux) throws Exception  {
		PeriodoAsistenciaConstantesFunciones.InicializarValoresPeriodoAsistencia(periodoasistenciaAux,true);
		
		for(PeriodoAsistencia periodoasistencia: periodoasistencias) {
			if(periodoasistencia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPeriodoAsistencia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PeriodoAsistenciaConstantesFunciones.getArrayColumnasGlobalesPeriodoAsistencia(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPeriodoAsistencia(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PeriodoAsistenciaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PeriodoAsistenciaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PeriodoAsistenciaConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PeriodoAsistenciaConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PeriodoAsistenciaConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PeriodoAsistenciaConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPeriodoAsistencia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PeriodoAsistencia> periodoasistencias,PeriodoAsistencia periodoasistencia,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PeriodoAsistencia periodoasistenciaAux: periodoasistencias) {
			if(periodoasistenciaAux!=null && periodoasistencia!=null) {
				if((periodoasistenciaAux.getId()==null && periodoasistencia.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(periodoasistenciaAux.getId()!=null && periodoasistencia.getId()!=null){
					if(periodoasistenciaAux.getId().equals(periodoasistencia.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPeriodoAsistencia(List<PeriodoAsistencia> periodoasistencias) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PeriodoAsistencia periodoasistencia: periodoasistencias) {			
			if(periodoasistencia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPeriodoAsistencia() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PeriodoAsistenciaConstantesFunciones.LABEL_ID, PeriodoAsistenciaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoAsistenciaConstantesFunciones.LABEL_VERSIONROW, PeriodoAsistenciaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoAsistenciaConstantesFunciones.LABEL_IDEMPRESA, PeriodoAsistenciaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoAsistenciaConstantesFunciones.LABEL_IDEJERCICIO, PeriodoAsistenciaConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoAsistenciaConstantesFunciones.LABEL_IDPERIODO, PeriodoAsistenciaConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoAsistenciaConstantesFunciones.LABEL_FECHAINICIO, PeriodoAsistenciaConstantesFunciones.FECHAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoAsistenciaConstantesFunciones.LABEL_FECHAFIN, PeriodoAsistenciaConstantesFunciones.FECHAFIN,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPeriodoAsistencia() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PeriodoAsistenciaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoAsistenciaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoAsistenciaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoAsistenciaConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoAsistenciaConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoAsistenciaConstantesFunciones.FECHAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoAsistenciaConstantesFunciones.FECHAFIN;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPeriodoAsistencia() throws Exception  {
		return PeriodoAsistenciaConstantesFunciones.getTiposSeleccionarPeriodoAsistencia(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPeriodoAsistencia(Boolean conFk) throws Exception  {
		return PeriodoAsistenciaConstantesFunciones.getTiposSeleccionarPeriodoAsistencia(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPeriodoAsistencia(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PeriodoAsistenciaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PeriodoAsistenciaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PeriodoAsistenciaConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(PeriodoAsistenciaConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PeriodoAsistenciaConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(PeriodoAsistenciaConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PeriodoAsistenciaConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(PeriodoAsistenciaConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PeriodoAsistenciaConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(PeriodoAsistenciaConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPeriodoAsistencia(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPeriodoAsistencia(PeriodoAsistencia periodoasistenciaAux) throws Exception {
		
			periodoasistenciaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(periodoasistenciaAux.getEmpresa()));
			periodoasistenciaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(periodoasistenciaAux.getEjercicio()));
			periodoasistenciaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(periodoasistenciaAux.getPeriodo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPeriodoAsistencia(List<PeriodoAsistencia> periodoasistenciasTemp) throws Exception {
		for(PeriodoAsistencia periodoasistenciaAux:periodoasistenciasTemp) {
			
			periodoasistenciaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(periodoasistenciaAux.getEmpresa()));
			periodoasistenciaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(periodoasistenciaAux.getEjercicio()));
			periodoasistenciaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(periodoasistenciaAux.getPeriodo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPeriodoAsistencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPeriodoAsistencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPeriodoAsistencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PeriodoAsistenciaConstantesFunciones.getClassesRelationshipsOfPeriodoAsistencia(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPeriodoAsistencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPeriodoAsistencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PeriodoAsistenciaConstantesFunciones.getClassesRelationshipsFromStringsOfPeriodoAsistencia(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPeriodoAsistencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PeriodoAsistencia periodoasistencia,List<PeriodoAsistencia> periodoasistencias,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PeriodoAsistencia periodoasistenciaEncontrado=null;
			
			for(PeriodoAsistencia periodoasistenciaLocal:periodoasistencias) {
				if(periodoasistenciaLocal.getId().equals(periodoasistencia.getId())) {
					periodoasistenciaEncontrado=periodoasistenciaLocal;
					
					periodoasistenciaLocal.setIsChanged(periodoasistencia.getIsChanged());
					periodoasistenciaLocal.setIsNew(periodoasistencia.getIsNew());
					periodoasistenciaLocal.setIsDeleted(periodoasistencia.getIsDeleted());
					
					periodoasistenciaLocal.setGeneralEntityOriginal(periodoasistencia.getGeneralEntityOriginal());
					
					periodoasistenciaLocal.setId(periodoasistencia.getId());	
					periodoasistenciaLocal.setVersionRow(periodoasistencia.getVersionRow());	
					periodoasistenciaLocal.setid_empresa(periodoasistencia.getid_empresa());	
					periodoasistenciaLocal.setid_ejercicio(periodoasistencia.getid_ejercicio());	
					periodoasistenciaLocal.setid_periodo(periodoasistencia.getid_periodo());	
					periodoasistenciaLocal.setfecha_inicio(periodoasistencia.getfecha_inicio());	
					periodoasistenciaLocal.setfecha_fin(periodoasistencia.getfecha_fin());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!periodoasistencia.getIsDeleted()) {
				if(!existe) {
					periodoasistencias.add(periodoasistencia);
				}
			} else {
				if(periodoasistenciaEncontrado!=null && permiteQuitar)  {
					periodoasistencias.remove(periodoasistenciaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PeriodoAsistencia periodoasistencia,List<PeriodoAsistencia> periodoasistencias) throws Exception {
		try	{			
			for(PeriodoAsistencia periodoasistenciaLocal:periodoasistencias) {
				if(periodoasistenciaLocal.getId().equals(periodoasistencia.getId())) {
					periodoasistenciaLocal.setIsSelected(periodoasistencia.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPeriodoAsistencia(List<PeriodoAsistencia> periodoasistenciasAux) throws Exception {
		//this.periodoasistenciasAux=periodoasistenciasAux;
		
		for(PeriodoAsistencia periodoasistenciaAux:periodoasistenciasAux) {
			if(periodoasistenciaAux.getIsChanged()) {
				periodoasistenciaAux.setIsChanged(false);
			}		
			
			if(periodoasistenciaAux.getIsNew()) {
				periodoasistenciaAux.setIsNew(false);
			}	
			
			if(periodoasistenciaAux.getIsDeleted()) {
				periodoasistenciaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPeriodoAsistencia(PeriodoAsistencia periodoasistenciaAux) throws Exception {
		//this.periodoasistenciaAux=periodoasistenciaAux;
		
			if(periodoasistenciaAux.getIsChanged()) {
				periodoasistenciaAux.setIsChanged(false);
			}		
			
			if(periodoasistenciaAux.getIsNew()) {
				periodoasistenciaAux.setIsNew(false);
			}	
			
			if(periodoasistenciaAux.getIsDeleted()) {
				periodoasistenciaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PeriodoAsistencia periodoasistenciaAsignar,PeriodoAsistencia periodoasistencia) throws Exception {
		periodoasistenciaAsignar.setId(periodoasistencia.getId());	
		periodoasistenciaAsignar.setVersionRow(periodoasistencia.getVersionRow());	
		periodoasistenciaAsignar.setid_empresa(periodoasistencia.getid_empresa());
		periodoasistenciaAsignar.setempresa_descripcion(periodoasistencia.getempresa_descripcion());	
		periodoasistenciaAsignar.setid_ejercicio(periodoasistencia.getid_ejercicio());
		periodoasistenciaAsignar.setejercicio_descripcion(periodoasistencia.getejercicio_descripcion());	
		periodoasistenciaAsignar.setid_periodo(periodoasistencia.getid_periodo());
		periodoasistenciaAsignar.setperiodo_descripcion(periodoasistencia.getperiodo_descripcion());	
		periodoasistenciaAsignar.setfecha_inicio(periodoasistencia.getfecha_inicio());	
		periodoasistenciaAsignar.setfecha_fin(periodoasistencia.getfecha_fin());	
	}
	
	public static void inicializarPeriodoAsistencia(PeriodoAsistencia periodoasistencia) throws Exception {
		try {
				periodoasistencia.setId(0L);	
					
				periodoasistencia.setid_empresa(-1L);	
				periodoasistencia.setid_ejercicio(-1L);	
				periodoasistencia.setid_periodo(-1L);	
				periodoasistencia.setfecha_inicio(new Date());	
				periodoasistencia.setfecha_fin(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPeriodoAsistencia(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PeriodoAsistenciaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PeriodoAsistenciaConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PeriodoAsistenciaConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PeriodoAsistenciaConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PeriodoAsistenciaConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPeriodoAsistencia(String sTipo,Row row,Workbook workbook,PeriodoAsistencia periodoasistencia,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(periodoasistencia.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(periodoasistencia.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(periodoasistencia.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(periodoasistencia.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(periodoasistencia.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPeriodoAsistencia=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPeriodoAsistencia() {
		return this.sFinalQueryPeriodoAsistencia;
	}
	
	public void setsFinalQueryPeriodoAsistencia(String sFinalQueryPeriodoAsistencia) {
		this.sFinalQueryPeriodoAsistencia= sFinalQueryPeriodoAsistencia;
	}
	
	public Border resaltarSeleccionarPeriodoAsistencia=null;
	
	public Border setResaltarSeleccionarPeriodoAsistencia(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoAsistenciaBeanSwingJInternalFrame periodoasistenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//periodoasistenciaBeanSwingJInternalFrame.jTtoolBarPeriodoAsistencia.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPeriodoAsistencia= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPeriodoAsistencia() {
		return this.resaltarSeleccionarPeriodoAsistencia;
	}
	
	public void setResaltarSeleccionarPeriodoAsistencia(Border borderResaltarSeleccionarPeriodoAsistencia) {
		this.resaltarSeleccionarPeriodoAsistencia= borderResaltarSeleccionarPeriodoAsistencia;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPeriodoAsistencia=null;
	public Boolean mostraridPeriodoAsistencia=true;
	public Boolean activaridPeriodoAsistencia=true;

	public Border resaltarid_empresaPeriodoAsistencia=null;
	public Boolean mostrarid_empresaPeriodoAsistencia=true;
	public Boolean activarid_empresaPeriodoAsistencia=true;
	public Boolean cargarid_empresaPeriodoAsistencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPeriodoAsistencia=false;//ConEventDepend=true

	public Border resaltarid_ejercicioPeriodoAsistencia=null;
	public Boolean mostrarid_ejercicioPeriodoAsistencia=true;
	public Boolean activarid_ejercicioPeriodoAsistencia=true;
	public Boolean cargarid_ejercicioPeriodoAsistencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioPeriodoAsistencia=false;//ConEventDepend=true

	public Border resaltarid_periodoPeriodoAsistencia=null;
	public Boolean mostrarid_periodoPeriodoAsistencia=true;
	public Boolean activarid_periodoPeriodoAsistencia=true;
	public Boolean cargarid_periodoPeriodoAsistencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoPeriodoAsistencia=false;//ConEventDepend=true

	public Border resaltarfecha_inicioPeriodoAsistencia=null;
	public Boolean mostrarfecha_inicioPeriodoAsistencia=true;
	public Boolean activarfecha_inicioPeriodoAsistencia=false;

	public Border resaltarfecha_finPeriodoAsistencia=null;
	public Boolean mostrarfecha_finPeriodoAsistencia=true;
	public Boolean activarfecha_finPeriodoAsistencia=false;

	
	

	public Border setResaltaridPeriodoAsistencia(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoAsistenciaBeanSwingJInternalFrame periodoasistenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periodoasistenciaBeanSwingJInternalFrame.jTtoolBarPeriodoAsistencia.setBorder(borderResaltar);
		
		this.resaltaridPeriodoAsistencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPeriodoAsistencia() {
		return this.resaltaridPeriodoAsistencia;
	}

	public void setResaltaridPeriodoAsistencia(Border borderResaltar) {
		this.resaltaridPeriodoAsistencia= borderResaltar;
	}

	public Boolean getMostraridPeriodoAsistencia() {
		return this.mostraridPeriodoAsistencia;
	}

	public void setMostraridPeriodoAsistencia(Boolean mostraridPeriodoAsistencia) {
		this.mostraridPeriodoAsistencia= mostraridPeriodoAsistencia;
	}

	public Boolean getActivaridPeriodoAsistencia() {
		return this.activaridPeriodoAsistencia;
	}

	public void setActivaridPeriodoAsistencia(Boolean activaridPeriodoAsistencia) {
		this.activaridPeriodoAsistencia= activaridPeriodoAsistencia;
	}

	public Border setResaltarid_empresaPeriodoAsistencia(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoAsistenciaBeanSwingJInternalFrame periodoasistenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periodoasistenciaBeanSwingJInternalFrame.jTtoolBarPeriodoAsistencia.setBorder(borderResaltar);
		
		this.resaltarid_empresaPeriodoAsistencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPeriodoAsistencia() {
		return this.resaltarid_empresaPeriodoAsistencia;
	}

	public void setResaltarid_empresaPeriodoAsistencia(Border borderResaltar) {
		this.resaltarid_empresaPeriodoAsistencia= borderResaltar;
	}

	public Boolean getMostrarid_empresaPeriodoAsistencia() {
		return this.mostrarid_empresaPeriodoAsistencia;
	}

	public void setMostrarid_empresaPeriodoAsistencia(Boolean mostrarid_empresaPeriodoAsistencia) {
		this.mostrarid_empresaPeriodoAsistencia= mostrarid_empresaPeriodoAsistencia;
	}

	public Boolean getActivarid_empresaPeriodoAsistencia() {
		return this.activarid_empresaPeriodoAsistencia;
	}

	public void setActivarid_empresaPeriodoAsistencia(Boolean activarid_empresaPeriodoAsistencia) {
		this.activarid_empresaPeriodoAsistencia= activarid_empresaPeriodoAsistencia;
	}

	public Boolean getCargarid_empresaPeriodoAsistencia() {
		return this.cargarid_empresaPeriodoAsistencia;
	}

	public void setCargarid_empresaPeriodoAsistencia(Boolean cargarid_empresaPeriodoAsistencia) {
		this.cargarid_empresaPeriodoAsistencia= cargarid_empresaPeriodoAsistencia;
	}

	public Border setResaltarid_ejercicioPeriodoAsistencia(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoAsistenciaBeanSwingJInternalFrame periodoasistenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periodoasistenciaBeanSwingJInternalFrame.jTtoolBarPeriodoAsistencia.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioPeriodoAsistencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioPeriodoAsistencia() {
		return this.resaltarid_ejercicioPeriodoAsistencia;
	}

	public void setResaltarid_ejercicioPeriodoAsistencia(Border borderResaltar) {
		this.resaltarid_ejercicioPeriodoAsistencia= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioPeriodoAsistencia() {
		return this.mostrarid_ejercicioPeriodoAsistencia;
	}

	public void setMostrarid_ejercicioPeriodoAsistencia(Boolean mostrarid_ejercicioPeriodoAsistencia) {
		this.mostrarid_ejercicioPeriodoAsistencia= mostrarid_ejercicioPeriodoAsistencia;
	}

	public Boolean getActivarid_ejercicioPeriodoAsistencia() {
		return this.activarid_ejercicioPeriodoAsistencia;
	}

	public void setActivarid_ejercicioPeriodoAsistencia(Boolean activarid_ejercicioPeriodoAsistencia) {
		this.activarid_ejercicioPeriodoAsistencia= activarid_ejercicioPeriodoAsistencia;
	}

	public Boolean getCargarid_ejercicioPeriodoAsistencia() {
		return this.cargarid_ejercicioPeriodoAsistencia;
	}

	public void setCargarid_ejercicioPeriodoAsistencia(Boolean cargarid_ejercicioPeriodoAsistencia) {
		this.cargarid_ejercicioPeriodoAsistencia= cargarid_ejercicioPeriodoAsistencia;
	}

	public Border setResaltarid_periodoPeriodoAsistencia(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoAsistenciaBeanSwingJInternalFrame periodoasistenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periodoasistenciaBeanSwingJInternalFrame.jTtoolBarPeriodoAsistencia.setBorder(borderResaltar);
		
		this.resaltarid_periodoPeriodoAsistencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoPeriodoAsistencia() {
		return this.resaltarid_periodoPeriodoAsistencia;
	}

	public void setResaltarid_periodoPeriodoAsistencia(Border borderResaltar) {
		this.resaltarid_periodoPeriodoAsistencia= borderResaltar;
	}

	public Boolean getMostrarid_periodoPeriodoAsistencia() {
		return this.mostrarid_periodoPeriodoAsistencia;
	}

	public void setMostrarid_periodoPeriodoAsistencia(Boolean mostrarid_periodoPeriodoAsistencia) {
		this.mostrarid_periodoPeriodoAsistencia= mostrarid_periodoPeriodoAsistencia;
	}

	public Boolean getActivarid_periodoPeriodoAsistencia() {
		return this.activarid_periodoPeriodoAsistencia;
	}

	public void setActivarid_periodoPeriodoAsistencia(Boolean activarid_periodoPeriodoAsistencia) {
		this.activarid_periodoPeriodoAsistencia= activarid_periodoPeriodoAsistencia;
	}

	public Boolean getCargarid_periodoPeriodoAsistencia() {
		return this.cargarid_periodoPeriodoAsistencia;
	}

	public void setCargarid_periodoPeriodoAsistencia(Boolean cargarid_periodoPeriodoAsistencia) {
		this.cargarid_periodoPeriodoAsistencia= cargarid_periodoPeriodoAsistencia;
	}

	public Border setResaltarfecha_inicioPeriodoAsistencia(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoAsistenciaBeanSwingJInternalFrame periodoasistenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periodoasistenciaBeanSwingJInternalFrame.jTtoolBarPeriodoAsistencia.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioPeriodoAsistencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioPeriodoAsistencia() {
		return this.resaltarfecha_inicioPeriodoAsistencia;
	}

	public void setResaltarfecha_inicioPeriodoAsistencia(Border borderResaltar) {
		this.resaltarfecha_inicioPeriodoAsistencia= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioPeriodoAsistencia() {
		return this.mostrarfecha_inicioPeriodoAsistencia;
	}

	public void setMostrarfecha_inicioPeriodoAsistencia(Boolean mostrarfecha_inicioPeriodoAsistencia) {
		this.mostrarfecha_inicioPeriodoAsistencia= mostrarfecha_inicioPeriodoAsistencia;
	}

	public Boolean getActivarfecha_inicioPeriodoAsistencia() {
		return this.activarfecha_inicioPeriodoAsistencia;
	}

	public void setActivarfecha_inicioPeriodoAsistencia(Boolean activarfecha_inicioPeriodoAsistencia) {
		this.activarfecha_inicioPeriodoAsistencia= activarfecha_inicioPeriodoAsistencia;
	}

	public Border setResaltarfecha_finPeriodoAsistencia(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoAsistenciaBeanSwingJInternalFrame periodoasistenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periodoasistenciaBeanSwingJInternalFrame.jTtoolBarPeriodoAsistencia.setBorder(borderResaltar);
		
		this.resaltarfecha_finPeriodoAsistencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finPeriodoAsistencia() {
		return this.resaltarfecha_finPeriodoAsistencia;
	}

	public void setResaltarfecha_finPeriodoAsistencia(Border borderResaltar) {
		this.resaltarfecha_finPeriodoAsistencia= borderResaltar;
	}

	public Boolean getMostrarfecha_finPeriodoAsistencia() {
		return this.mostrarfecha_finPeriodoAsistencia;
	}

	public void setMostrarfecha_finPeriodoAsistencia(Boolean mostrarfecha_finPeriodoAsistencia) {
		this.mostrarfecha_finPeriodoAsistencia= mostrarfecha_finPeriodoAsistencia;
	}

	public Boolean getActivarfecha_finPeriodoAsistencia() {
		return this.activarfecha_finPeriodoAsistencia;
	}

	public void setActivarfecha_finPeriodoAsistencia(Boolean activarfecha_finPeriodoAsistencia) {
		this.activarfecha_finPeriodoAsistencia= activarfecha_finPeriodoAsistencia;
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
		
		
		this.setMostraridPeriodoAsistencia(esInicial);
		this.setMostrarid_empresaPeriodoAsistencia(esInicial);
		this.setMostrarid_ejercicioPeriodoAsistencia(esInicial);
		this.setMostrarid_periodoPeriodoAsistencia(esInicial);
		this.setMostrarfecha_inicioPeriodoAsistencia(esInicial);
		this.setMostrarfecha_finPeriodoAsistencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PeriodoAsistenciaConstantesFunciones.ID)) {
				this.setMostraridPeriodoAsistencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoAsistenciaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPeriodoAsistencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoAsistenciaConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioPeriodoAsistencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoAsistenciaConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoPeriodoAsistencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoAsistenciaConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioPeriodoAsistencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoAsistenciaConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finPeriodoAsistencia(esAsigna);
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
		
		
		this.setActivaridPeriodoAsistencia(esInicial);
		this.setActivarid_empresaPeriodoAsistencia(esInicial);
		this.setActivarid_ejercicioPeriodoAsistencia(esInicial);
		this.setActivarid_periodoPeriodoAsistencia(esInicial);
		this.setActivarfecha_inicioPeriodoAsistencia(esInicial);
		this.setActivarfecha_finPeriodoAsistencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PeriodoAsistenciaConstantesFunciones.ID)) {
				this.setActivaridPeriodoAsistencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoAsistenciaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPeriodoAsistencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoAsistenciaConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioPeriodoAsistencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoAsistenciaConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoPeriodoAsistencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoAsistenciaConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioPeriodoAsistencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoAsistenciaConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finPeriodoAsistencia(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PeriodoAsistenciaBeanSwingJInternalFrame periodoasistenciaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPeriodoAsistencia(esInicial);
		this.setResaltarid_empresaPeriodoAsistencia(esInicial);
		this.setResaltarid_ejercicioPeriodoAsistencia(esInicial);
		this.setResaltarid_periodoPeriodoAsistencia(esInicial);
		this.setResaltarfecha_inicioPeriodoAsistencia(esInicial);
		this.setResaltarfecha_finPeriodoAsistencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PeriodoAsistenciaConstantesFunciones.ID)) {
				this.setResaltaridPeriodoAsistencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoAsistenciaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPeriodoAsistencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoAsistenciaConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioPeriodoAsistencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoAsistenciaConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoPeriodoAsistencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoAsistenciaConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioPeriodoAsistencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoAsistenciaConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finPeriodoAsistencia(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PeriodoAsistenciaBeanSwingJInternalFrame periodoasistenciaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEjercicioPeriodoAsistencia=true;

	public Boolean getMostrarFK_IdEjercicioPeriodoAsistencia() {
		return this.mostrarFK_IdEjercicioPeriodoAsistencia;
	}

	public void setMostrarFK_IdEjercicioPeriodoAsistencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioPeriodoAsistencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPeriodoAsistencia=true;

	public Boolean getMostrarFK_IdEmpresaPeriodoAsistencia() {
		return this.mostrarFK_IdEmpresaPeriodoAsistencia;
	}

	public void setMostrarFK_IdEmpresaPeriodoAsistencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPeriodoAsistencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoPeriodoAsistencia=true;

	public Boolean getMostrarFK_IdPeriodoPeriodoAsistencia() {
		return this.mostrarFK_IdPeriodoPeriodoAsistencia;
	}

	public void setMostrarFK_IdPeriodoPeriodoAsistencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoPeriodoAsistencia= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEjercicioPeriodoAsistencia=true;

	public Boolean getActivarFK_IdEjercicioPeriodoAsistencia() {
		return this.activarFK_IdEjercicioPeriodoAsistencia;
	}

	public void setActivarFK_IdEjercicioPeriodoAsistencia(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioPeriodoAsistencia= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPeriodoAsistencia=true;

	public Boolean getActivarFK_IdEmpresaPeriodoAsistencia() {
		return this.activarFK_IdEmpresaPeriodoAsistencia;
	}

	public void setActivarFK_IdEmpresaPeriodoAsistencia(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPeriodoAsistencia= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoPeriodoAsistencia=true;

	public Boolean getActivarFK_IdPeriodoPeriodoAsistencia() {
		return this.activarFK_IdPeriodoPeriodoAsistencia;
	}

	public void setActivarFK_IdPeriodoPeriodoAsistencia(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoPeriodoAsistencia= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEjercicioPeriodoAsistencia=null;

	public Border getResaltarFK_IdEjercicioPeriodoAsistencia() {
		return this.resaltarFK_IdEjercicioPeriodoAsistencia;
	}

	public void setResaltarFK_IdEjercicioPeriodoAsistencia(Border borderResaltar) {
		this.resaltarFK_IdEjercicioPeriodoAsistencia= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioPeriodoAsistencia(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoAsistenciaBeanSwingJInternalFrame periodoasistenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioPeriodoAsistencia= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPeriodoAsistencia=null;

	public Border getResaltarFK_IdEmpresaPeriodoAsistencia() {
		return this.resaltarFK_IdEmpresaPeriodoAsistencia;
	}

	public void setResaltarFK_IdEmpresaPeriodoAsistencia(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPeriodoAsistencia= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPeriodoAsistencia(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoAsistenciaBeanSwingJInternalFrame periodoasistenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPeriodoAsistencia= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoPeriodoAsistencia=null;

	public Border getResaltarFK_IdPeriodoPeriodoAsistencia() {
		return this.resaltarFK_IdPeriodoPeriodoAsistencia;
	}

	public void setResaltarFK_IdPeriodoPeriodoAsistencia(Border borderResaltar) {
		this.resaltarFK_IdPeriodoPeriodoAsistencia= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoPeriodoAsistencia(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoAsistenciaBeanSwingJInternalFrame periodoasistenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoPeriodoAsistencia= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}