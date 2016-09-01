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

import com.bydan.erp.nomina.resources.general.AuxiliarGeneral;

import com.bydan.erp.nomina.util.report.ProcesoUtilidadesConstantesFunciones;
import com.bydan.erp.nomina.util.report.ProcesoUtilidadesParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ProcesoUtilidadesParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.business.entity.report.*;



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
final public class ProcesoUtilidadesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoUtilidades";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoUtilidades"+ProcesoUtilidadesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoUtilidadesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoUtilidadesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoUtilidadesConstantesFunciones.SCHEMA+"_"+ProcesoUtilidadesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoUtilidadesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoUtilidadesConstantesFunciones.SCHEMA+"_"+ProcesoUtilidadesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoUtilidadesConstantesFunciones.SCHEMA+"_"+ProcesoUtilidadesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoUtilidadesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoUtilidadesConstantesFunciones.SCHEMA+"_"+ProcesoUtilidadesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoUtilidadesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoUtilidadesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoUtilidadesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoUtilidadesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoUtilidadesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoUtilidadesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoUtilidadesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoUtilidadesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoUtilidadesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoUtilidadesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Utilidadeses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Utilidades";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Utilidades";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoUtilidades";
	public static final String OBJECTNAME="procesoutilidades";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="proceso_utilidades";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesoutilidades from "+ProcesoUtilidadesConstantesFunciones.SPERSISTENCENAME+" procesoutilidades";
	public static String QUERYSELECTNATIVE="select "+ProcesoUtilidadesConstantesFunciones.SCHEMA+"."+ProcesoUtilidadesConstantesFunciones.TABLENAME+".id,"+ProcesoUtilidadesConstantesFunciones.SCHEMA+"."+ProcesoUtilidadesConstantesFunciones.TABLENAME+".version_row,"+ProcesoUtilidadesConstantesFunciones.SCHEMA+"."+ProcesoUtilidadesConstantesFunciones.TABLENAME+".id_anio,"+ProcesoUtilidadesConstantesFunciones.SCHEMA+"."+ProcesoUtilidadesConstantesFunciones.TABLENAME+".valor from "+ProcesoUtilidadesConstantesFunciones.SCHEMA+"."+ProcesoUtilidadesConstantesFunciones.TABLENAME;//+" as "+ProcesoUtilidadesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDANIO= "id_anio";
    public static final String VALOR= "valor";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
	
		
		
		
		
	
	public static String getProcesoUtilidadesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoUtilidadesConstantesFunciones.IDANIO)) {sLabelColumna=ProcesoUtilidadesConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(ProcesoUtilidadesConstantesFunciones.VALOR)) {sLabelColumna=ProcesoUtilidadesConstantesFunciones.LABEL_VALOR;}
		
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
	
	
	
			
			
			
			
	
	public static String getProcesoUtilidadesDescripcion(ProcesoUtilidades procesoutilidades) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesoutilidades !=null/* && procesoutilidades.getId()!=0*/) {
			if(procesoutilidades.getId()!=null) {
				sDescripcion=procesoutilidades.getId().toString();
			}//procesoutilidadesprocesoutilidades.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoUtilidadesDescripcionDetallado(ProcesoUtilidades procesoutilidades) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoUtilidadesConstantesFunciones.ID+"=";
		sDescripcion+=procesoutilidades.getId().toString()+",";
		sDescripcion+=ProcesoUtilidadesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesoutilidades.getVersionRow().toString()+",";
		sDescripcion+=ProcesoUtilidadesConstantesFunciones.IDANIO+"=";
		sDescripcion+=procesoutilidades.getid_anio().toString()+",";
		sDescripcion+=ProcesoUtilidadesConstantesFunciones.VALOR+"=";
		sDescripcion+=procesoutilidades.getvalor().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoUtilidadesDescripcion(ProcesoUtilidades procesoutilidades,String sValor) throws Exception {			
		if(procesoutilidades !=null) {
			//procesoutilidadesprocesoutilidades.getId().toString();
		}		
	}
	
		

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesoUtilidades")) {
			sNombreIndice="Tipo=  Por Anio Por Valor";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesoUtilidades(Long id_anio,Double valor) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();}
		if(valor!=null) {sDetalleIndice+=" Valor="+valor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoUtilidades(ProcesoUtilidades procesoutilidades,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesoUtilidadess(List<ProcesoUtilidades> procesoutilidadess,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoUtilidades procesoutilidades: procesoutilidadess) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoUtilidades(ProcesoUtilidades procesoutilidades,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesoutilidades.getConCambioAuxiliar()) {
			procesoutilidades.setIsDeleted(procesoutilidades.getIsDeletedAuxiliar());	
			procesoutilidades.setIsNew(procesoutilidades.getIsNewAuxiliar());	
			procesoutilidades.setIsChanged(procesoutilidades.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesoutilidades.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesoutilidades.setIsDeletedAuxiliar(false);	
			procesoutilidades.setIsNewAuxiliar(false);	
			procesoutilidades.setIsChangedAuxiliar(false);
			
			procesoutilidades.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoUtilidadess(List<ProcesoUtilidades> procesoutilidadess,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoUtilidades procesoutilidades : procesoutilidadess) {
			if(conAsignarBase && procesoutilidades.getConCambioAuxiliar()) {
				procesoutilidades.setIsDeleted(procesoutilidades.getIsDeletedAuxiliar());	
				procesoutilidades.setIsNew(procesoutilidades.getIsNewAuxiliar());	
				procesoutilidades.setIsChanged(procesoutilidades.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesoutilidades.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesoutilidades.setIsDeletedAuxiliar(false);	
				procesoutilidades.setIsNewAuxiliar(false);	
				procesoutilidades.setIsChangedAuxiliar(false);
				
				procesoutilidades.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoUtilidades(ProcesoUtilidades procesoutilidades,Boolean conEnteros) throws Exception  {
		procesoutilidades.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoUtilidadess(List<ProcesoUtilidades> procesoutilidadess,Boolean conEnteros) throws Exception  {
		
		for(ProcesoUtilidades procesoutilidades: procesoutilidadess) {
			procesoutilidades.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoUtilidades(List<ProcesoUtilidades> procesoutilidadess,ProcesoUtilidades procesoutilidadesAux) throws Exception  {
		ProcesoUtilidadesConstantesFunciones.InicializarValoresProcesoUtilidades(procesoutilidadesAux,true);
		
		for(ProcesoUtilidades procesoutilidades: procesoutilidadess) {
			if(procesoutilidades.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			procesoutilidadesAux.setvalor(procesoutilidadesAux.getvalor()+procesoutilidades.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoUtilidades(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoUtilidadesConstantesFunciones.getArrayColumnasGlobalesProcesoUtilidades(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoUtilidades(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoUtilidades(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoUtilidades> procesoutilidadess,ProcesoUtilidades procesoutilidades,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoUtilidades procesoutilidadesAux: procesoutilidadess) {
			if(procesoutilidadesAux!=null && procesoutilidades!=null) {
				if((procesoutilidadesAux.getId()==null && procesoutilidades.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesoutilidadesAux.getId()!=null && procesoutilidades.getId()!=null){
					if(procesoutilidadesAux.getId().equals(procesoutilidades.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoUtilidades(List<ProcesoUtilidades> procesoutilidadess) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(ProcesoUtilidades procesoutilidades: procesoutilidadess) {			
			if(procesoutilidades.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=procesoutilidades.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProcesoUtilidadesConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ProcesoUtilidadesConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoUtilidades() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoUtilidades() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoUtilidades() throws Exception  {
		return ProcesoUtilidadesConstantesFunciones.getTiposSeleccionarProcesoUtilidades(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoUtilidades(Boolean conFk) throws Exception  {
		return ProcesoUtilidadesConstantesFunciones.getTiposSeleccionarProcesoUtilidades(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoUtilidades(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoUtilidadesConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(ProcesoUtilidadesConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoUtilidadesConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(ProcesoUtilidadesConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoUtilidades(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoUtilidades(ProcesoUtilidades procesoutilidadesAux) throws Exception {
		
			procesoutilidadesAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(procesoutilidadesAux.getAnio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoUtilidades(List<ProcesoUtilidades> procesoutilidadessTemp) throws Exception {
		for(ProcesoUtilidades procesoutilidadesAux:procesoutilidadessTemp) {
			
			procesoutilidadesAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(procesoutilidadesAux.getAnio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoUtilidades(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Anio.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoUtilidades(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoUtilidades(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoUtilidadesConstantesFunciones.getClassesRelationshipsOfProcesoUtilidades(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoUtilidades(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoUtilidades(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoUtilidadesConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoUtilidades(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoUtilidades(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoUtilidades procesoutilidades,List<ProcesoUtilidades> procesoutilidadess,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoUtilidades procesoutilidades,List<ProcesoUtilidades> procesoutilidadess) throws Exception {
		try	{			
			for(ProcesoUtilidades procesoutilidadesLocal:procesoutilidadess) {
				if(procesoutilidadesLocal.getId().equals(procesoutilidades.getId())) {
					procesoutilidadesLocal.setIsSelected(procesoutilidades.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoUtilidades(List<ProcesoUtilidades> procesoutilidadessAux) throws Exception {
		//this.procesoutilidadessAux=procesoutilidadessAux;
		
		for(ProcesoUtilidades procesoutilidadesAux:procesoutilidadessAux) {
			if(procesoutilidadesAux.getIsChanged()) {
				procesoutilidadesAux.setIsChanged(false);
			}		
			
			if(procesoutilidadesAux.getIsNew()) {
				procesoutilidadesAux.setIsNew(false);
			}	
			
			if(procesoutilidadesAux.getIsDeleted()) {
				procesoutilidadesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoUtilidades(ProcesoUtilidades procesoutilidadesAux) throws Exception {
		//this.procesoutilidadesAux=procesoutilidadesAux;
		
			if(procesoutilidadesAux.getIsChanged()) {
				procesoutilidadesAux.setIsChanged(false);
			}		
			
			if(procesoutilidadesAux.getIsNew()) {
				procesoutilidadesAux.setIsNew(false);
			}	
			
			if(procesoutilidadesAux.getIsDeleted()) {
				procesoutilidadesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoUtilidades procesoutilidadesAsignar,ProcesoUtilidades procesoutilidades) throws Exception {
		procesoutilidadesAsignar.setId(procesoutilidades.getId());	
		procesoutilidadesAsignar.setVersionRow(procesoutilidades.getVersionRow());	
		procesoutilidadesAsignar.setid_anio(procesoutilidades.getid_anio());
		procesoutilidadesAsignar.setanio_descripcion(procesoutilidades.getanio_descripcion());	
		procesoutilidadesAsignar.setvalor(procesoutilidades.getvalor());	
	}
	
	public static void inicializarProcesoUtilidades(ProcesoUtilidades procesoutilidades) throws Exception {
		try {
				procesoutilidades.setId(0L);	
					
				procesoutilidades.setid_anio(null);	
				procesoutilidades.setvalor(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoUtilidades(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoUtilidadesConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoUtilidadesConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoUtilidades(String sTipo,Row row,Workbook workbook,ProcesoUtilidades procesoutilidades,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesoutilidades.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesoutilidades.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoUtilidades="";
	
	public String getsFinalQueryProcesoUtilidades() {
		return this.sFinalQueryProcesoUtilidades;
	}
	
	public void setsFinalQueryProcesoUtilidades(String sFinalQueryProcesoUtilidades) {
		this.sFinalQueryProcesoUtilidades= sFinalQueryProcesoUtilidades;
	}
	
	public Border resaltarSeleccionarProcesoUtilidades=null;
	
	public Border setResaltarSeleccionarProcesoUtilidades(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoUtilidadesBeanSwingJInternalFrame procesoutilidadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesoutilidadesBeanSwingJInternalFrame.jTtoolBarProcesoUtilidades.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoUtilidades= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoUtilidades() {
		return this.resaltarSeleccionarProcesoUtilidades;
	}
	
	public void setResaltarSeleccionarProcesoUtilidades(Border borderResaltarSeleccionarProcesoUtilidades) {
		this.resaltarSeleccionarProcesoUtilidades= borderResaltarSeleccionarProcesoUtilidades;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoUtilidades=null;
	public Boolean mostraridProcesoUtilidades=true;
	public Boolean activaridProcesoUtilidades=true;

	public Border resaltarid_anioProcesoUtilidades=null;
	public Boolean mostrarid_anioProcesoUtilidades=true;
	public Boolean activarid_anioProcesoUtilidades=true;
	public Boolean cargarid_anioProcesoUtilidades=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioProcesoUtilidades=false;//ConEventDepend=true

	public Border resaltarvalorProcesoUtilidades=null;
	public Boolean mostrarvalorProcesoUtilidades=true;
	public Boolean activarvalorProcesoUtilidades=true;

	
	

	public Border setResaltaridProcesoUtilidades(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoUtilidadesBeanSwingJInternalFrame procesoutilidadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoutilidadesBeanSwingJInternalFrame.jTtoolBarProcesoUtilidades.setBorder(borderResaltar);
		
		this.resaltaridProcesoUtilidades= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoUtilidades() {
		return this.resaltaridProcesoUtilidades;
	}

	public void setResaltaridProcesoUtilidades(Border borderResaltar) {
		this.resaltaridProcesoUtilidades= borderResaltar;
	}

	public Boolean getMostraridProcesoUtilidades() {
		return this.mostraridProcesoUtilidades;
	}

	public void setMostraridProcesoUtilidades(Boolean mostraridProcesoUtilidades) {
		this.mostraridProcesoUtilidades= mostraridProcesoUtilidades;
	}

	public Boolean getActivaridProcesoUtilidades() {
		return this.activaridProcesoUtilidades;
	}

	public void setActivaridProcesoUtilidades(Boolean activaridProcesoUtilidades) {
		this.activaridProcesoUtilidades= activaridProcesoUtilidades;
	}

	public Border setResaltarid_anioProcesoUtilidades(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoUtilidadesBeanSwingJInternalFrame procesoutilidadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoutilidadesBeanSwingJInternalFrame.jTtoolBarProcesoUtilidades.setBorder(borderResaltar);
		
		this.resaltarid_anioProcesoUtilidades= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioProcesoUtilidades() {
		return this.resaltarid_anioProcesoUtilidades;
	}

	public void setResaltarid_anioProcesoUtilidades(Border borderResaltar) {
		this.resaltarid_anioProcesoUtilidades= borderResaltar;
	}

	public Boolean getMostrarid_anioProcesoUtilidades() {
		return this.mostrarid_anioProcesoUtilidades;
	}

	public void setMostrarid_anioProcesoUtilidades(Boolean mostrarid_anioProcesoUtilidades) {
		this.mostrarid_anioProcesoUtilidades= mostrarid_anioProcesoUtilidades;
	}

	public Boolean getActivarid_anioProcesoUtilidades() {
		return this.activarid_anioProcesoUtilidades;
	}

	public void setActivarid_anioProcesoUtilidades(Boolean activarid_anioProcesoUtilidades) {
		this.activarid_anioProcesoUtilidades= activarid_anioProcesoUtilidades;
	}

	public Boolean getCargarid_anioProcesoUtilidades() {
		return this.cargarid_anioProcesoUtilidades;
	}

	public void setCargarid_anioProcesoUtilidades(Boolean cargarid_anioProcesoUtilidades) {
		this.cargarid_anioProcesoUtilidades= cargarid_anioProcesoUtilidades;
	}

	public Border setResaltarvalorProcesoUtilidades(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoUtilidadesBeanSwingJInternalFrame procesoutilidadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoutilidadesBeanSwingJInternalFrame.jTtoolBarProcesoUtilidades.setBorder(borderResaltar);
		
		this.resaltarvalorProcesoUtilidades= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorProcesoUtilidades() {
		return this.resaltarvalorProcesoUtilidades;
	}

	public void setResaltarvalorProcesoUtilidades(Border borderResaltar) {
		this.resaltarvalorProcesoUtilidades= borderResaltar;
	}

	public Boolean getMostrarvalorProcesoUtilidades() {
		return this.mostrarvalorProcesoUtilidades;
	}

	public void setMostrarvalorProcesoUtilidades(Boolean mostrarvalorProcesoUtilidades) {
		this.mostrarvalorProcesoUtilidades= mostrarvalorProcesoUtilidades;
	}

	public Boolean getActivarvalorProcesoUtilidades() {
		return this.activarvalorProcesoUtilidades;
	}

	public void setActivarvalorProcesoUtilidades(Boolean activarvalorProcesoUtilidades) {
		this.activarvalorProcesoUtilidades= activarvalorProcesoUtilidades;
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
		
		
		this.setMostraridProcesoUtilidades(esInicial);
		this.setMostrarid_anioProcesoUtilidades(esInicial);
		this.setMostrarvalorProcesoUtilidades(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoUtilidadesConstantesFunciones.ID)) {
				this.setMostraridProcesoUtilidades(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoUtilidadesConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioProcesoUtilidades(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoUtilidadesConstantesFunciones.VALOR)) {
				this.setMostrarvalorProcesoUtilidades(esAsigna);
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
		
		
		this.setActivaridProcesoUtilidades(esInicial);
		this.setActivarid_anioProcesoUtilidades(esInicial);
		this.setActivarvalorProcesoUtilidades(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoUtilidadesConstantesFunciones.ID)) {
				this.setActivaridProcesoUtilidades(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoUtilidadesConstantesFunciones.IDANIO)) {
				this.setActivarid_anioProcesoUtilidades(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoUtilidadesConstantesFunciones.VALOR)) {
				this.setActivarvalorProcesoUtilidades(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoUtilidadesBeanSwingJInternalFrame procesoutilidadesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoUtilidades(esInicial);
		this.setResaltarid_anioProcesoUtilidades(esInicial);
		this.setResaltarvalorProcesoUtilidades(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoUtilidadesConstantesFunciones.ID)) {
				this.setResaltaridProcesoUtilidades(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoUtilidadesConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioProcesoUtilidades(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoUtilidadesConstantesFunciones.VALOR)) {
				this.setResaltarvalorProcesoUtilidades(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoUtilidadesBeanSwingJInternalFrame procesoutilidadesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoUtilidadesProcesoUtilidades=true;

	public Boolean getMostrarBusquedaProcesoUtilidadesProcesoUtilidades() {
		return this.mostrarBusquedaProcesoUtilidadesProcesoUtilidades;
	}

	public void setMostrarBusquedaProcesoUtilidadesProcesoUtilidades(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoUtilidadesProcesoUtilidades= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoUtilidadesProcesoUtilidades=true;

	public Boolean getActivarBusquedaProcesoUtilidadesProcesoUtilidades() {
		return this.activarBusquedaProcesoUtilidadesProcesoUtilidades;
	}

	public void setActivarBusquedaProcesoUtilidadesProcesoUtilidades(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoUtilidadesProcesoUtilidades= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoUtilidadesProcesoUtilidades=null;

	public Border getResaltarBusquedaProcesoUtilidadesProcesoUtilidades() {
		return this.resaltarBusquedaProcesoUtilidadesProcesoUtilidades;
	}

	public void setResaltarBusquedaProcesoUtilidadesProcesoUtilidades(Border borderResaltar) {
		this.resaltarBusquedaProcesoUtilidadesProcesoUtilidades= borderResaltar;
	}

	public void setResaltarBusquedaProcesoUtilidadesProcesoUtilidades(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoUtilidadesBeanSwingJInternalFrame procesoutilidadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoUtilidadesProcesoUtilidades= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}