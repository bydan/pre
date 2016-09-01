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
package com.bydan.erp.contabilidad.util.report;

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

import com.bydan.erp.contabilidad.resources.general.AuxiliarGeneral;

import com.bydan.erp.contabilidad.util.report.ProcesoCierreEjercicioAnualConstantesFunciones;
import com.bydan.erp.contabilidad.util.report.ProcesoCierreEjercicioAnualParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.ProcesoCierreEjercicioAnualParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;



import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProcesoCierreEjercicioAnualConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoCierreEjercicioAnual";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoCierreEjercicioAnual"+ProcesoCierreEjercicioAnualConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoCierreEjercicioAnualHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoCierreEjercicioAnualHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoCierreEjercicioAnualConstantesFunciones.SCHEMA+"_"+ProcesoCierreEjercicioAnualConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoCierreEjercicioAnualHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoCierreEjercicioAnualConstantesFunciones.SCHEMA+"_"+ProcesoCierreEjercicioAnualConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoCierreEjercicioAnualConstantesFunciones.SCHEMA+"_"+ProcesoCierreEjercicioAnualConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoCierreEjercicioAnualHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoCierreEjercicioAnualConstantesFunciones.SCHEMA+"_"+ProcesoCierreEjercicioAnualConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCierreEjercicioAnualConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoCierreEjercicioAnualHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCierreEjercicioAnualConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCierreEjercicioAnualConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoCierreEjercicioAnualHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCierreEjercicioAnualConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoCierreEjercicioAnualConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoCierreEjercicioAnualConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoCierreEjercicioAnualConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoCierreEjercicioAnualConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Cierre Ejercicio Anuales";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Cierre Ejercicio Anual";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Cierre Ejercicio Anual";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoCierreEjercicioAnual";
	public static final String OBJECTNAME="procesocierreejercicioanual";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="proceso_cierre_ejercicio_anual";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesocierreejercicioanual from "+ProcesoCierreEjercicioAnualConstantesFunciones.SPERSISTENCENAME+" procesocierreejercicioanual";
	public static String QUERYSELECTNATIVE="select "+ProcesoCierreEjercicioAnualConstantesFunciones.SCHEMA+"."+ProcesoCierreEjercicioAnualConstantesFunciones.TABLENAME+".id,"+ProcesoCierreEjercicioAnualConstantesFunciones.SCHEMA+"."+ProcesoCierreEjercicioAnualConstantesFunciones.TABLENAME+".version_row,"+ProcesoCierreEjercicioAnualConstantesFunciones.SCHEMA+"."+ProcesoCierreEjercicioAnualConstantesFunciones.TABLENAME+".id_tipo_documento,"+ProcesoCierreEjercicioAnualConstantesFunciones.SCHEMA+"."+ProcesoCierreEjercicioAnualConstantesFunciones.TABLENAME+".fecha from "+ProcesoCierreEjercicioAnualConstantesFunciones.SCHEMA+"."+ProcesoCierreEjercicioAnualConstantesFunciones.TABLENAME;//+" as "+ProcesoCierreEjercicioAnualConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDTIPODOCUMENTO= "id_tipo_documento";
    public static final String FECHA= "fecha";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDTIPODOCUMENTO= "Tipo Documento";
		public static final String LABEL_IDTIPODOCUMENTO_LOWER= "Tipo Documento";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
	
		
		
		
		
	
	public static String getProcesoCierreEjercicioAnualLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoCierreEjercicioAnualConstantesFunciones.IDTIPODOCUMENTO)) {sLabelColumna=ProcesoCierreEjercicioAnualConstantesFunciones.LABEL_IDTIPODOCUMENTO;}
		if(sNombreColumna.equals(ProcesoCierreEjercicioAnualConstantesFunciones.FECHA)) {sLabelColumna=ProcesoCierreEjercicioAnualConstantesFunciones.LABEL_FECHA;}
		
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
	
	
	
			
			
			
			
	
	public static String getProcesoCierreEjercicioAnualDescripcion(ProcesoCierreEjercicioAnual procesocierreejercicioanual) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesocierreejercicioanual !=null/* && procesocierreejercicioanual.getId()!=0*/) {
			sDescripcion=procesocierreejercicioanual.getfecha().toString();//procesocierreejercicioanualprocesocierreejercicioanual.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoCierreEjercicioAnualDescripcionDetallado(ProcesoCierreEjercicioAnual procesocierreejercicioanual) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoCierreEjercicioAnualConstantesFunciones.ID+"=";
		sDescripcion+=procesocierreejercicioanual.getId().toString()+",";
		sDescripcion+=ProcesoCierreEjercicioAnualConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesocierreejercicioanual.getVersionRow().toString()+",";
		sDescripcion+=ProcesoCierreEjercicioAnualConstantesFunciones.IDTIPODOCUMENTO+"=";
		sDescripcion+=procesocierreejercicioanual.getid_tipo_documento().toString()+",";
		sDescripcion+=ProcesoCierreEjercicioAnualConstantesFunciones.FECHA+"=";
		sDescripcion+=procesocierreejercicioanual.getfecha().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoCierreEjercicioAnualDescripcion(ProcesoCierreEjercicioAnual procesocierreejercicioanual,String sValor) throws Exception {			
		if(procesocierreejercicioanual !=null) {
			//procesocierreejercicioanualprocesocierreejercicioanual.getId().toString();
		}		
	}
	
		

	public static String getTipoDocumentoDescripcion(TipoDocumento tipodocumento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodocumento!=null/*&&tipodocumento.getId()>0*/) {
			sDescripcion=TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(tipodocumento);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesoCierreEjercicioAnual")) {
			sNombreIndice="Tipo=  Por Tipo Documento Por Fecha";
		} else if(sNombreIndice.equals("FK_IdTipoDocumento")) {
			sNombreIndice="Tipo=  Por Tipo Documento";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesoCierreEjercicioAnual(Long id_tipo_documento,Date fecha) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Documento="+id_tipo_documento.toString();}
		if(fecha!=null) {sDetalleIndice+=" Fecha="+fecha.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDocumento(Long id_tipo_documento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Documento="+id_tipo_documento.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoCierreEjercicioAnual(ProcesoCierreEjercicioAnual procesocierreejercicioanual,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesoCierreEjercicioAnuals(List<ProcesoCierreEjercicioAnual> procesocierreejercicioanuals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoCierreEjercicioAnual procesocierreejercicioanual: procesocierreejercicioanuals) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoCierreEjercicioAnual(ProcesoCierreEjercicioAnual procesocierreejercicioanual,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesocierreejercicioanual.getConCambioAuxiliar()) {
			procesocierreejercicioanual.setIsDeleted(procesocierreejercicioanual.getIsDeletedAuxiliar());	
			procesocierreejercicioanual.setIsNew(procesocierreejercicioanual.getIsNewAuxiliar());	
			procesocierreejercicioanual.setIsChanged(procesocierreejercicioanual.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesocierreejercicioanual.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesocierreejercicioanual.setIsDeletedAuxiliar(false);	
			procesocierreejercicioanual.setIsNewAuxiliar(false);	
			procesocierreejercicioanual.setIsChangedAuxiliar(false);
			
			procesocierreejercicioanual.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoCierreEjercicioAnuals(List<ProcesoCierreEjercicioAnual> procesocierreejercicioanuals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoCierreEjercicioAnual procesocierreejercicioanual : procesocierreejercicioanuals) {
			if(conAsignarBase && procesocierreejercicioanual.getConCambioAuxiliar()) {
				procesocierreejercicioanual.setIsDeleted(procesocierreejercicioanual.getIsDeletedAuxiliar());	
				procesocierreejercicioanual.setIsNew(procesocierreejercicioanual.getIsNewAuxiliar());	
				procesocierreejercicioanual.setIsChanged(procesocierreejercicioanual.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesocierreejercicioanual.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesocierreejercicioanual.setIsDeletedAuxiliar(false);	
				procesocierreejercicioanual.setIsNewAuxiliar(false);	
				procesocierreejercicioanual.setIsChangedAuxiliar(false);
				
				procesocierreejercicioanual.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoCierreEjercicioAnual(ProcesoCierreEjercicioAnual procesocierreejercicioanual,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoCierreEjercicioAnuals(List<ProcesoCierreEjercicioAnual> procesocierreejercicioanuals,Boolean conEnteros) throws Exception  {
		
		for(ProcesoCierreEjercicioAnual procesocierreejercicioanual: procesocierreejercicioanuals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoCierreEjercicioAnual(List<ProcesoCierreEjercicioAnual> procesocierreejercicioanuals,ProcesoCierreEjercicioAnual procesocierreejercicioanualAux) throws Exception  {
		ProcesoCierreEjercicioAnualConstantesFunciones.InicializarValoresProcesoCierreEjercicioAnual(procesocierreejercicioanualAux,true);
		
		for(ProcesoCierreEjercicioAnual procesocierreejercicioanual: procesocierreejercicioanuals) {
			if(procesocierreejercicioanual.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCierreEjercicioAnual(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoCierreEjercicioAnualConstantesFunciones.getArrayColumnasGlobalesProcesoCierreEjercicioAnual(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCierreEjercicioAnual(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoCierreEjercicioAnual(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoCierreEjercicioAnual> procesocierreejercicioanuals,ProcesoCierreEjercicioAnual procesocierreejercicioanual,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoCierreEjercicioAnual procesocierreejercicioanualAux: procesocierreejercicioanuals) {
			if(procesocierreejercicioanualAux!=null && procesocierreejercicioanual!=null) {
				if((procesocierreejercicioanualAux.getId()==null && procesocierreejercicioanual.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesocierreejercicioanualAux.getId()!=null && procesocierreejercicioanual.getId()!=null){
					if(procesocierreejercicioanualAux.getId().equals(procesocierreejercicioanual.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoCierreEjercicioAnual(List<ProcesoCierreEjercicioAnual> procesocierreejercicioanuals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoCierreEjercicioAnual procesocierreejercicioanual: procesocierreejercicioanuals) {			
			if(procesocierreejercicioanual.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoCierreEjercicioAnual() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoCierreEjercicioAnual() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCierreEjercicioAnual() throws Exception  {
		return ProcesoCierreEjercicioAnualConstantesFunciones.getTiposSeleccionarProcesoCierreEjercicioAnual(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCierreEjercicioAnual(Boolean conFk) throws Exception  {
		return ProcesoCierreEjercicioAnualConstantesFunciones.getTiposSeleccionarProcesoCierreEjercicioAnual(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCierreEjercicioAnual(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCierreEjercicioAnualConstantesFunciones.LABEL_IDTIPODOCUMENTO);
			reporte.setsDescripcion(ProcesoCierreEjercicioAnualConstantesFunciones.LABEL_IDTIPODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCierreEjercicioAnualConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ProcesoCierreEjercicioAnualConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoCierreEjercicioAnual(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoCierreEjercicioAnual(ProcesoCierreEjercicioAnual procesocierreejercicioanualAux) throws Exception {
		
			procesocierreejercicioanualAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(procesocierreejercicioanualAux.getTipoDocumento()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoCierreEjercicioAnual(List<ProcesoCierreEjercicioAnual> procesocierreejercicioanualsTemp) throws Exception {
		for(ProcesoCierreEjercicioAnual procesocierreejercicioanualAux:procesocierreejercicioanualsTemp) {
			
			procesocierreejercicioanualAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(procesocierreejercicioanualAux.getTipoDocumento()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoCierreEjercicioAnual(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TipoDocumento.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDocumento.class)) {
						classes.add(new Classe(TipoDocumento.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoCierreEjercicioAnual(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoCierreEjercicioAnual(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoCierreEjercicioAnualConstantesFunciones.getClassesRelationshipsOfProcesoCierreEjercicioAnual(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoCierreEjercicioAnual(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoCierreEjercicioAnual(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoCierreEjercicioAnualConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoCierreEjercicioAnual(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoCierreEjercicioAnual(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoCierreEjercicioAnual procesocierreejercicioanual,List<ProcesoCierreEjercicioAnual> procesocierreejercicioanuals,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoCierreEjercicioAnual procesocierreejercicioanual,List<ProcesoCierreEjercicioAnual> procesocierreejercicioanuals) throws Exception {
		try	{			
			for(ProcesoCierreEjercicioAnual procesocierreejercicioanualLocal:procesocierreejercicioanuals) {
				if(procesocierreejercicioanualLocal.getId().equals(procesocierreejercicioanual.getId())) {
					procesocierreejercicioanualLocal.setIsSelected(procesocierreejercicioanual.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoCierreEjercicioAnual(List<ProcesoCierreEjercicioAnual> procesocierreejercicioanualsAux) throws Exception {
		//this.procesocierreejercicioanualsAux=procesocierreejercicioanualsAux;
		
		for(ProcesoCierreEjercicioAnual procesocierreejercicioanualAux:procesocierreejercicioanualsAux) {
			if(procesocierreejercicioanualAux.getIsChanged()) {
				procesocierreejercicioanualAux.setIsChanged(false);
			}		
			
			if(procesocierreejercicioanualAux.getIsNew()) {
				procesocierreejercicioanualAux.setIsNew(false);
			}	
			
			if(procesocierreejercicioanualAux.getIsDeleted()) {
				procesocierreejercicioanualAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoCierreEjercicioAnual(ProcesoCierreEjercicioAnual procesocierreejercicioanualAux) throws Exception {
		//this.procesocierreejercicioanualAux=procesocierreejercicioanualAux;
		
			if(procesocierreejercicioanualAux.getIsChanged()) {
				procesocierreejercicioanualAux.setIsChanged(false);
			}		
			
			if(procesocierreejercicioanualAux.getIsNew()) {
				procesocierreejercicioanualAux.setIsNew(false);
			}	
			
			if(procesocierreejercicioanualAux.getIsDeleted()) {
				procesocierreejercicioanualAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoCierreEjercicioAnual procesocierreejercicioanualAsignar,ProcesoCierreEjercicioAnual procesocierreejercicioanual) throws Exception {
		procesocierreejercicioanualAsignar.setId(procesocierreejercicioanual.getId());	
		procesocierreejercicioanualAsignar.setVersionRow(procesocierreejercicioanual.getVersionRow());	
		procesocierreejercicioanualAsignar.setid_tipo_documento(procesocierreejercicioanual.getid_tipo_documento());
		procesocierreejercicioanualAsignar.settipodocumento_descripcion(procesocierreejercicioanual.gettipodocumento_descripcion());	
		procesocierreejercicioanualAsignar.setfecha(procesocierreejercicioanual.getfecha());	
	}
	
	public static void inicializarProcesoCierreEjercicioAnual(ProcesoCierreEjercicioAnual procesocierreejercicioanual) throws Exception {
		try {
				procesocierreejercicioanual.setId(0L);	
					
				procesocierreejercicioanual.setid_tipo_documento(-1L);	
				procesocierreejercicioanual.setfecha(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoCierreEjercicioAnual(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCierreEjercicioAnualConstantesFunciones.LABEL_IDTIPODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCierreEjercicioAnualConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoCierreEjercicioAnual(String sTipo,Row row,Workbook workbook,ProcesoCierreEjercicioAnual procesocierreejercicioanual,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocierreejercicioanual.gettipodocumento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocierreejercicioanual.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoCierreEjercicioAnual="";
	
	public String getsFinalQueryProcesoCierreEjercicioAnual() {
		return this.sFinalQueryProcesoCierreEjercicioAnual;
	}
	
	public void setsFinalQueryProcesoCierreEjercicioAnual(String sFinalQueryProcesoCierreEjercicioAnual) {
		this.sFinalQueryProcesoCierreEjercicioAnual= sFinalQueryProcesoCierreEjercicioAnual;
	}
	
	public Border resaltarSeleccionarProcesoCierreEjercicioAnual=null;
	
	public Border setResaltarSeleccionarProcesoCierreEjercicioAnual(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreEjercicioAnualBeanSwingJInternalFrame procesocierreejercicioanualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesocierreejercicioanualBeanSwingJInternalFrame.jTtoolBarProcesoCierreEjercicioAnual.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoCierreEjercicioAnual= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoCierreEjercicioAnual() {
		return this.resaltarSeleccionarProcesoCierreEjercicioAnual;
	}
	
	public void setResaltarSeleccionarProcesoCierreEjercicioAnual(Border borderResaltarSeleccionarProcesoCierreEjercicioAnual) {
		this.resaltarSeleccionarProcesoCierreEjercicioAnual= borderResaltarSeleccionarProcesoCierreEjercicioAnual;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoCierreEjercicioAnual=null;
	public Boolean mostraridProcesoCierreEjercicioAnual=true;
	public Boolean activaridProcesoCierreEjercicioAnual=true;

	public Border resaltarid_tipo_documentoProcesoCierreEjercicioAnual=null;
	public Boolean mostrarid_tipo_documentoProcesoCierreEjercicioAnual=true;
	public Boolean activarid_tipo_documentoProcesoCierreEjercicioAnual=true;
	public Boolean cargarid_tipo_documentoProcesoCierreEjercicioAnual=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documentoProcesoCierreEjercicioAnual=false;//ConEventDepend=true

	public Border resaltarfechaProcesoCierreEjercicioAnual=null;
	public Boolean mostrarfechaProcesoCierreEjercicioAnual=true;
	public Boolean activarfechaProcesoCierreEjercicioAnual=true;

	
	

	public Border setResaltaridProcesoCierreEjercicioAnual(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreEjercicioAnualBeanSwingJInternalFrame procesocierreejercicioanualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocierreejercicioanualBeanSwingJInternalFrame.jTtoolBarProcesoCierreEjercicioAnual.setBorder(borderResaltar);
		
		this.resaltaridProcesoCierreEjercicioAnual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoCierreEjercicioAnual() {
		return this.resaltaridProcesoCierreEjercicioAnual;
	}

	public void setResaltaridProcesoCierreEjercicioAnual(Border borderResaltar) {
		this.resaltaridProcesoCierreEjercicioAnual= borderResaltar;
	}

	public Boolean getMostraridProcesoCierreEjercicioAnual() {
		return this.mostraridProcesoCierreEjercicioAnual;
	}

	public void setMostraridProcesoCierreEjercicioAnual(Boolean mostraridProcesoCierreEjercicioAnual) {
		this.mostraridProcesoCierreEjercicioAnual= mostraridProcesoCierreEjercicioAnual;
	}

	public Boolean getActivaridProcesoCierreEjercicioAnual() {
		return this.activaridProcesoCierreEjercicioAnual;
	}

	public void setActivaridProcesoCierreEjercicioAnual(Boolean activaridProcesoCierreEjercicioAnual) {
		this.activaridProcesoCierreEjercicioAnual= activaridProcesoCierreEjercicioAnual;
	}

	public Border setResaltarid_tipo_documentoProcesoCierreEjercicioAnual(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreEjercicioAnualBeanSwingJInternalFrame procesocierreejercicioanualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocierreejercicioanualBeanSwingJInternalFrame.jTtoolBarProcesoCierreEjercicioAnual.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documentoProcesoCierreEjercicioAnual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documentoProcesoCierreEjercicioAnual() {
		return this.resaltarid_tipo_documentoProcesoCierreEjercicioAnual;
	}

	public void setResaltarid_tipo_documentoProcesoCierreEjercicioAnual(Border borderResaltar) {
		this.resaltarid_tipo_documentoProcesoCierreEjercicioAnual= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documentoProcesoCierreEjercicioAnual() {
		return this.mostrarid_tipo_documentoProcesoCierreEjercicioAnual;
	}

	public void setMostrarid_tipo_documentoProcesoCierreEjercicioAnual(Boolean mostrarid_tipo_documentoProcesoCierreEjercicioAnual) {
		this.mostrarid_tipo_documentoProcesoCierreEjercicioAnual= mostrarid_tipo_documentoProcesoCierreEjercicioAnual;
	}

	public Boolean getActivarid_tipo_documentoProcesoCierreEjercicioAnual() {
		return this.activarid_tipo_documentoProcesoCierreEjercicioAnual;
	}

	public void setActivarid_tipo_documentoProcesoCierreEjercicioAnual(Boolean activarid_tipo_documentoProcesoCierreEjercicioAnual) {
		this.activarid_tipo_documentoProcesoCierreEjercicioAnual= activarid_tipo_documentoProcesoCierreEjercicioAnual;
	}

	public Boolean getCargarid_tipo_documentoProcesoCierreEjercicioAnual() {
		return this.cargarid_tipo_documentoProcesoCierreEjercicioAnual;
	}

	public void setCargarid_tipo_documentoProcesoCierreEjercicioAnual(Boolean cargarid_tipo_documentoProcesoCierreEjercicioAnual) {
		this.cargarid_tipo_documentoProcesoCierreEjercicioAnual= cargarid_tipo_documentoProcesoCierreEjercicioAnual;
	}

	public Border setResaltarfechaProcesoCierreEjercicioAnual(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreEjercicioAnualBeanSwingJInternalFrame procesocierreejercicioanualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocierreejercicioanualBeanSwingJInternalFrame.jTtoolBarProcesoCierreEjercicioAnual.setBorder(borderResaltar);
		
		this.resaltarfechaProcesoCierreEjercicioAnual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaProcesoCierreEjercicioAnual() {
		return this.resaltarfechaProcesoCierreEjercicioAnual;
	}

	public void setResaltarfechaProcesoCierreEjercicioAnual(Border borderResaltar) {
		this.resaltarfechaProcesoCierreEjercicioAnual= borderResaltar;
	}

	public Boolean getMostrarfechaProcesoCierreEjercicioAnual() {
		return this.mostrarfechaProcesoCierreEjercicioAnual;
	}

	public void setMostrarfechaProcesoCierreEjercicioAnual(Boolean mostrarfechaProcesoCierreEjercicioAnual) {
		this.mostrarfechaProcesoCierreEjercicioAnual= mostrarfechaProcesoCierreEjercicioAnual;
	}

	public Boolean getActivarfechaProcesoCierreEjercicioAnual() {
		return this.activarfechaProcesoCierreEjercicioAnual;
	}

	public void setActivarfechaProcesoCierreEjercicioAnual(Boolean activarfechaProcesoCierreEjercicioAnual) {
		this.activarfechaProcesoCierreEjercicioAnual= activarfechaProcesoCierreEjercicioAnual;
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
		
		
		this.setMostraridProcesoCierreEjercicioAnual(esInicial);
		this.setMostrarid_tipo_documentoProcesoCierreEjercicioAnual(esInicial);
		this.setMostrarfechaProcesoCierreEjercicioAnual(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCierreEjercicioAnualConstantesFunciones.ID)) {
				this.setMostraridProcesoCierreEjercicioAnual(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreEjercicioAnualConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setMostrarid_tipo_documentoProcesoCierreEjercicioAnual(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreEjercicioAnualConstantesFunciones.FECHA)) {
				this.setMostrarfechaProcesoCierreEjercicioAnual(esAsigna);
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
		
		
		this.setActivaridProcesoCierreEjercicioAnual(esInicial);
		this.setActivarid_tipo_documentoProcesoCierreEjercicioAnual(esInicial);
		this.setActivarfechaProcesoCierreEjercicioAnual(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCierreEjercicioAnualConstantesFunciones.ID)) {
				this.setActivaridProcesoCierreEjercicioAnual(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreEjercicioAnualConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setActivarid_tipo_documentoProcesoCierreEjercicioAnual(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreEjercicioAnualConstantesFunciones.FECHA)) {
				this.setActivarfechaProcesoCierreEjercicioAnual(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoCierreEjercicioAnualBeanSwingJInternalFrame procesocierreejercicioanualBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoCierreEjercicioAnual(esInicial);
		this.setResaltarid_tipo_documentoProcesoCierreEjercicioAnual(esInicial);
		this.setResaltarfechaProcesoCierreEjercicioAnual(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCierreEjercicioAnualConstantesFunciones.ID)) {
				this.setResaltaridProcesoCierreEjercicioAnual(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreEjercicioAnualConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setResaltarid_tipo_documentoProcesoCierreEjercicioAnual(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreEjercicioAnualConstantesFunciones.FECHA)) {
				this.setResaltarfechaProcesoCierreEjercicioAnual(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoCierreEjercicioAnualBeanSwingJInternalFrame procesocierreejercicioanualBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoCierreEjercicioAnualProcesoCierreEjercicioAnual=true;

	public Boolean getMostrarBusquedaProcesoCierreEjercicioAnualProcesoCierreEjercicioAnual() {
		return this.mostrarBusquedaProcesoCierreEjercicioAnualProcesoCierreEjercicioAnual;
	}

	public void setMostrarBusquedaProcesoCierreEjercicioAnualProcesoCierreEjercicioAnual(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoCierreEjercicioAnualProcesoCierreEjercicioAnual= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoCierreEjercicioAnualProcesoCierreEjercicioAnual=true;

	public Boolean getActivarBusquedaProcesoCierreEjercicioAnualProcesoCierreEjercicioAnual() {
		return this.activarBusquedaProcesoCierreEjercicioAnualProcesoCierreEjercicioAnual;
	}

	public void setActivarBusquedaProcesoCierreEjercicioAnualProcesoCierreEjercicioAnual(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoCierreEjercicioAnualProcesoCierreEjercicioAnual= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoCierreEjercicioAnualProcesoCierreEjercicioAnual=null;

	public Border getResaltarBusquedaProcesoCierreEjercicioAnualProcesoCierreEjercicioAnual() {
		return this.resaltarBusquedaProcesoCierreEjercicioAnualProcesoCierreEjercicioAnual;
	}

	public void setResaltarBusquedaProcesoCierreEjercicioAnualProcesoCierreEjercicioAnual(Border borderResaltar) {
		this.resaltarBusquedaProcesoCierreEjercicioAnualProcesoCierreEjercicioAnual= borderResaltar;
	}

	public void setResaltarBusquedaProcesoCierreEjercicioAnualProcesoCierreEjercicioAnual(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreEjercicioAnualBeanSwingJInternalFrame procesocierreejercicioanualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoCierreEjercicioAnualProcesoCierreEjercicioAnual= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}