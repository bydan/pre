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


import com.bydan.erp.contabilidad.util.report.ProcesoTotalizarSaldosConstantesFunciones;
import com.bydan.erp.contabilidad.util.report.ProcesoTotalizarSaldosParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.ProcesoTotalizarSaldosParameterGeneral;

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
final public class ProcesoTotalizarSaldosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoTotalizarSaldos";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoTotalizarSaldos"+ProcesoTotalizarSaldosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoTotalizarSaldosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoTotalizarSaldosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoTotalizarSaldosConstantesFunciones.SCHEMA+"_"+ProcesoTotalizarSaldosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoTotalizarSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoTotalizarSaldosConstantesFunciones.SCHEMA+"_"+ProcesoTotalizarSaldosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoTotalizarSaldosConstantesFunciones.SCHEMA+"_"+ProcesoTotalizarSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoTotalizarSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoTotalizarSaldosConstantesFunciones.SCHEMA+"_"+ProcesoTotalizarSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoTotalizarSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoTotalizarSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoTotalizarSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoTotalizarSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoTotalizarSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoTotalizarSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoTotalizarSaldosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoTotalizarSaldosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoTotalizarSaldosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoTotalizarSaldosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Totalizar Saldoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Totalizar Saldos";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Totalizar Saldos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoTotalizarSaldos";
	public static final String OBJECTNAME="procesototalizarsaldos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="totalizar_saldos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesototalizarsaldos from "+ProcesoTotalizarSaldosConstantesFunciones.SPERSISTENCENAME+" procesototalizarsaldos";
	public static String QUERYSELECTNATIVE="select "+ProcesoTotalizarSaldosConstantesFunciones.SCHEMA+"."+ProcesoTotalizarSaldosConstantesFunciones.TABLENAME+".id,"+ProcesoTotalizarSaldosConstantesFunciones.SCHEMA+"."+ProcesoTotalizarSaldosConstantesFunciones.TABLENAME+".version_row,"+ProcesoTotalizarSaldosConstantesFunciones.SCHEMA+"."+ProcesoTotalizarSaldosConstantesFunciones.TABLENAME+".id_ejercicio,"+ProcesoTotalizarSaldosConstantesFunciones.SCHEMA+"."+ProcesoTotalizarSaldosConstantesFunciones.TABLENAME+".id_periodo from "+ProcesoTotalizarSaldosConstantesFunciones.SCHEMA+"."+ProcesoTotalizarSaldosConstantesFunciones.TABLENAME;//+" as "+ProcesoTotalizarSaldosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
	
		
		
		
		
	
	public static String getProcesoTotalizarSaldosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoTotalizarSaldosConstantesFunciones.IDEJERCICIO)) {sLabelColumna=ProcesoTotalizarSaldosConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(ProcesoTotalizarSaldosConstantesFunciones.IDPERIODO)) {sLabelColumna=ProcesoTotalizarSaldosConstantesFunciones.LABEL_IDPERIODO;}
		
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
	
	
	
			
			
			
			
	
	public static String getProcesoTotalizarSaldosDescripcion(ProcesoTotalizarSaldos procesototalizarsaldos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesototalizarsaldos !=null/* && procesototalizarsaldos.getId()!=0*/) {
			if(procesototalizarsaldos.getId()!=null) {
				sDescripcion=procesototalizarsaldos.getId().toString();
			}//procesototalizarsaldosprocesototalizarsaldos.getId().toString().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoTotalizarSaldosDescripcionDetallado(ProcesoTotalizarSaldos procesototalizarsaldos) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoTotalizarSaldosConstantesFunciones.ID+"=";
		sDescripcion+=procesototalizarsaldos.getId().toString()+",";
		sDescripcion+=ProcesoTotalizarSaldosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesototalizarsaldos.getVersionRow().toString()+",";
		sDescripcion+=ProcesoTotalizarSaldosConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=procesototalizarsaldos.getid_ejercicio().toString()+",";
		sDescripcion+=ProcesoTotalizarSaldosConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=procesototalizarsaldos.getid_periodo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoTotalizarSaldosDescripcion(ProcesoTotalizarSaldos procesototalizarsaldos,String sValor) throws Exception {			
		if(procesototalizarsaldos !=null) {
			;//procesototalizarsaldosprocesototalizarsaldos.getId().toString().trim();
		}		
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
		} else if(sNombreIndice.equals("BusquedaPorEjercicioPorPeriodo")) {
			sNombreIndice="Tipo=  Por Ejercicio Por Periodo";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorEjercicioPorPeriodo(Long id_ejercicio,Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoTotalizarSaldos(ProcesoTotalizarSaldos procesototalizarsaldos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesoTotalizarSaldoss(List<ProcesoTotalizarSaldos> procesototalizarsaldoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoTotalizarSaldos procesototalizarsaldos: procesototalizarsaldoss) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoTotalizarSaldos(ProcesoTotalizarSaldos procesototalizarsaldos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesototalizarsaldos.getConCambioAuxiliar()) {
			procesototalizarsaldos.setIsDeleted(procesototalizarsaldos.getIsDeletedAuxiliar());	
			procesototalizarsaldos.setIsNew(procesototalizarsaldos.getIsNewAuxiliar());	
			procesototalizarsaldos.setIsChanged(procesototalizarsaldos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesototalizarsaldos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesototalizarsaldos.setIsDeletedAuxiliar(false);	
			procesototalizarsaldos.setIsNewAuxiliar(false);	
			procesototalizarsaldos.setIsChangedAuxiliar(false);
			
			procesototalizarsaldos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoTotalizarSaldoss(List<ProcesoTotalizarSaldos> procesototalizarsaldoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoTotalizarSaldos procesototalizarsaldos : procesototalizarsaldoss) {
			if(conAsignarBase && procesototalizarsaldos.getConCambioAuxiliar()) {
				procesototalizarsaldos.setIsDeleted(procesototalizarsaldos.getIsDeletedAuxiliar());	
				procesototalizarsaldos.setIsNew(procesototalizarsaldos.getIsNewAuxiliar());	
				procesototalizarsaldos.setIsChanged(procesototalizarsaldos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesototalizarsaldos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesototalizarsaldos.setIsDeletedAuxiliar(false);	
				procesototalizarsaldos.setIsNewAuxiliar(false);	
				procesototalizarsaldos.setIsChangedAuxiliar(false);
				
				procesototalizarsaldos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoTotalizarSaldos(ProcesoTotalizarSaldos procesototalizarsaldos,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoTotalizarSaldoss(List<ProcesoTotalizarSaldos> procesototalizarsaldoss,Boolean conEnteros) throws Exception  {
		
		for(ProcesoTotalizarSaldos procesototalizarsaldos: procesototalizarsaldoss) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoTotalizarSaldos(List<ProcesoTotalizarSaldos> procesototalizarsaldoss,ProcesoTotalizarSaldos procesototalizarsaldosAux) throws Exception  {
		ProcesoTotalizarSaldosConstantesFunciones.InicializarValoresProcesoTotalizarSaldos(procesototalizarsaldosAux,true);
		
		for(ProcesoTotalizarSaldos procesototalizarsaldos: procesototalizarsaldoss) {
			if(procesototalizarsaldos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoTotalizarSaldos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoTotalizarSaldosConstantesFunciones.getArrayColumnasGlobalesProcesoTotalizarSaldos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoTotalizarSaldos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoTotalizarSaldosConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoTotalizarSaldosConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoTotalizarSaldosConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoTotalizarSaldosConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoTotalizarSaldos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoTotalizarSaldos> procesototalizarsaldoss,ProcesoTotalizarSaldos procesototalizarsaldos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoTotalizarSaldos procesototalizarsaldosAux: procesototalizarsaldoss) {
			if(procesototalizarsaldosAux!=null && procesototalizarsaldos!=null) {
				if((procesototalizarsaldosAux.getId()==null && procesototalizarsaldos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesototalizarsaldosAux.getId()!=null && procesototalizarsaldos.getId()!=null){
					if(procesototalizarsaldosAux.getId().equals(procesototalizarsaldos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoTotalizarSaldos(List<ProcesoTotalizarSaldos> procesototalizarsaldoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoTotalizarSaldos procesototalizarsaldos: procesototalizarsaldoss) {			
			if(procesototalizarsaldos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoTotalizarSaldos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoTotalizarSaldos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoTotalizarSaldos() throws Exception  {
		return ProcesoTotalizarSaldosConstantesFunciones.getTiposSeleccionarProcesoTotalizarSaldos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoTotalizarSaldos(Boolean conFk) throws Exception  {
		return ProcesoTotalizarSaldosConstantesFunciones.getTiposSeleccionarProcesoTotalizarSaldos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoTotalizarSaldos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoTotalizarSaldosConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(ProcesoTotalizarSaldosConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoTotalizarSaldosConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(ProcesoTotalizarSaldosConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoTotalizarSaldos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoTotalizarSaldos(ProcesoTotalizarSaldos procesototalizarsaldosAux) throws Exception {
		
			procesototalizarsaldosAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(procesototalizarsaldosAux.getEjercicio()));
			procesototalizarsaldosAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(procesototalizarsaldosAux.getPeriodo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoTotalizarSaldos(List<ProcesoTotalizarSaldos> procesototalizarsaldossTemp) throws Exception {
		for(ProcesoTotalizarSaldos procesototalizarsaldosAux:procesototalizarsaldossTemp) {
			
			procesototalizarsaldosAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(procesototalizarsaldosAux.getEjercicio()));
			procesototalizarsaldosAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(procesototalizarsaldosAux.getPeriodo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoTotalizarSaldos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoTotalizarSaldos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoTotalizarSaldos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoTotalizarSaldosConstantesFunciones.getClassesRelationshipsOfProcesoTotalizarSaldos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoTotalizarSaldos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoTotalizarSaldos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoTotalizarSaldosConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoTotalizarSaldos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoTotalizarSaldos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoTotalizarSaldos procesototalizarsaldos,List<ProcesoTotalizarSaldos> procesototalizarsaldoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoTotalizarSaldos procesototalizarsaldos,List<ProcesoTotalizarSaldos> procesototalizarsaldoss) throws Exception {
		try	{			
			for(ProcesoTotalizarSaldos procesototalizarsaldosLocal:procesototalizarsaldoss) {
				if(procesototalizarsaldosLocal.getId().equals(procesototalizarsaldos.getId())) {
					procesototalizarsaldosLocal.setIsSelected(procesototalizarsaldos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoTotalizarSaldos(List<ProcesoTotalizarSaldos> procesototalizarsaldossAux) throws Exception {
		//this.procesototalizarsaldossAux=procesototalizarsaldossAux;
		
		for(ProcesoTotalizarSaldos procesototalizarsaldosAux:procesototalizarsaldossAux) {
			if(procesototalizarsaldosAux.getIsChanged()) {
				procesototalizarsaldosAux.setIsChanged(false);
			}		
			
			if(procesototalizarsaldosAux.getIsNew()) {
				procesototalizarsaldosAux.setIsNew(false);
			}	
			
			if(procesototalizarsaldosAux.getIsDeleted()) {
				procesototalizarsaldosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoTotalizarSaldos(ProcesoTotalizarSaldos procesototalizarsaldosAux) throws Exception {
		//this.procesototalizarsaldosAux=procesototalizarsaldosAux;
		
			if(procesototalizarsaldosAux.getIsChanged()) {
				procesototalizarsaldosAux.setIsChanged(false);
			}		
			
			if(procesototalizarsaldosAux.getIsNew()) {
				procesototalizarsaldosAux.setIsNew(false);
			}	
			
			if(procesototalizarsaldosAux.getIsDeleted()) {
				procesototalizarsaldosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoTotalizarSaldos procesototalizarsaldosAsignar,ProcesoTotalizarSaldos procesototalizarsaldos) throws Exception {
		procesototalizarsaldosAsignar.setId(procesototalizarsaldos.getId());	
		procesototalizarsaldosAsignar.setVersionRow(procesototalizarsaldos.getVersionRow());	
		procesototalizarsaldosAsignar.setid_ejercicio(procesototalizarsaldos.getid_ejercicio());
		procesototalizarsaldosAsignar.setejercicio_descripcion(procesototalizarsaldos.getejercicio_descripcion());	
		procesototalizarsaldosAsignar.setid_periodo(procesototalizarsaldos.getid_periodo());
		procesototalizarsaldosAsignar.setperiodo_descripcion(procesototalizarsaldos.getperiodo_descripcion());	
	}
	
	public static void inicializarProcesoTotalizarSaldos(ProcesoTotalizarSaldos procesototalizarsaldos) throws Exception {
		try {
				procesototalizarsaldos.setId(0L);	
					
				procesototalizarsaldos.setid_ejercicio(-1L);	
				procesototalizarsaldos.setid_periodo(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoTotalizarSaldos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoTotalizarSaldosConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoTotalizarSaldosConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoTotalizarSaldos(String sTipo,Row row,Workbook workbook,ProcesoTotalizarSaldos procesototalizarsaldos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesototalizarsaldos.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesototalizarsaldos.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoTotalizarSaldos="";
	
	public String getsFinalQueryProcesoTotalizarSaldos() {
		return this.sFinalQueryProcesoTotalizarSaldos;
	}
	
	public void setsFinalQueryProcesoTotalizarSaldos(String sFinalQueryProcesoTotalizarSaldos) {
		this.sFinalQueryProcesoTotalizarSaldos= sFinalQueryProcesoTotalizarSaldos;
	}
	
	public Border resaltarSeleccionarProcesoTotalizarSaldos=null;
	
	public Border setResaltarSeleccionarProcesoTotalizarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoTotalizarSaldosBeanSwingJInternalFrame procesototalizarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesototalizarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoTotalizarSaldos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoTotalizarSaldos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoTotalizarSaldos() {
		return this.resaltarSeleccionarProcesoTotalizarSaldos;
	}
	
	public void setResaltarSeleccionarProcesoTotalizarSaldos(Border borderResaltarSeleccionarProcesoTotalizarSaldos) {
		this.resaltarSeleccionarProcesoTotalizarSaldos= borderResaltarSeleccionarProcesoTotalizarSaldos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoTotalizarSaldos=null;
	public Boolean mostraridProcesoTotalizarSaldos=true;
	public Boolean activaridProcesoTotalizarSaldos=true;

	public Border resaltarid_ejercicioProcesoTotalizarSaldos=null;
	public Boolean mostrarid_ejercicioProcesoTotalizarSaldos=true;
	public Boolean activarid_ejercicioProcesoTotalizarSaldos=true;
	public Boolean cargarid_ejercicioProcesoTotalizarSaldos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioProcesoTotalizarSaldos=false;//ConEventDepend=true

	public Border resaltarid_periodoProcesoTotalizarSaldos=null;
	public Boolean mostrarid_periodoProcesoTotalizarSaldos=true;
	public Boolean activarid_periodoProcesoTotalizarSaldos=true;
	public Boolean cargarid_periodoProcesoTotalizarSaldos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoProcesoTotalizarSaldos=true;//ConEventDepend=true

	
	

	public Border setResaltaridProcesoTotalizarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoTotalizarSaldosBeanSwingJInternalFrame procesototalizarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesototalizarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoTotalizarSaldos.setBorder(borderResaltar);
		
		this.resaltaridProcesoTotalizarSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoTotalizarSaldos() {
		return this.resaltaridProcesoTotalizarSaldos;
	}

	public void setResaltaridProcesoTotalizarSaldos(Border borderResaltar) {
		this.resaltaridProcesoTotalizarSaldos= borderResaltar;
	}

	public Boolean getMostraridProcesoTotalizarSaldos() {
		return this.mostraridProcesoTotalizarSaldos;
	}

	public void setMostraridProcesoTotalizarSaldos(Boolean mostraridProcesoTotalizarSaldos) {
		this.mostraridProcesoTotalizarSaldos= mostraridProcesoTotalizarSaldos;
	}

	public Boolean getActivaridProcesoTotalizarSaldos() {
		return this.activaridProcesoTotalizarSaldos;
	}

	public void setActivaridProcesoTotalizarSaldos(Boolean activaridProcesoTotalizarSaldos) {
		this.activaridProcesoTotalizarSaldos= activaridProcesoTotalizarSaldos;
	}

	public Border setResaltarid_ejercicioProcesoTotalizarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoTotalizarSaldosBeanSwingJInternalFrame procesototalizarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesototalizarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoTotalizarSaldos.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioProcesoTotalizarSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioProcesoTotalizarSaldos() {
		return this.resaltarid_ejercicioProcesoTotalizarSaldos;
	}

	public void setResaltarid_ejercicioProcesoTotalizarSaldos(Border borderResaltar) {
		this.resaltarid_ejercicioProcesoTotalizarSaldos= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioProcesoTotalizarSaldos() {
		return this.mostrarid_ejercicioProcesoTotalizarSaldos;
	}

	public void setMostrarid_ejercicioProcesoTotalizarSaldos(Boolean mostrarid_ejercicioProcesoTotalizarSaldos) {
		this.mostrarid_ejercicioProcesoTotalizarSaldos= mostrarid_ejercicioProcesoTotalizarSaldos;
	}

	public Boolean getActivarid_ejercicioProcesoTotalizarSaldos() {
		return this.activarid_ejercicioProcesoTotalizarSaldos;
	}

	public void setActivarid_ejercicioProcesoTotalizarSaldos(Boolean activarid_ejercicioProcesoTotalizarSaldos) {
		this.activarid_ejercicioProcesoTotalizarSaldos= activarid_ejercicioProcesoTotalizarSaldos;
	}

	public Boolean getCargarid_ejercicioProcesoTotalizarSaldos() {
		return this.cargarid_ejercicioProcesoTotalizarSaldos;
	}

	public void setCargarid_ejercicioProcesoTotalizarSaldos(Boolean cargarid_ejercicioProcesoTotalizarSaldos) {
		this.cargarid_ejercicioProcesoTotalizarSaldos= cargarid_ejercicioProcesoTotalizarSaldos;
	}

	public Border setResaltarid_periodoProcesoTotalizarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoTotalizarSaldosBeanSwingJInternalFrame procesototalizarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesototalizarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoTotalizarSaldos.setBorder(borderResaltar);
		
		this.resaltarid_periodoProcesoTotalizarSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoProcesoTotalizarSaldos() {
		return this.resaltarid_periodoProcesoTotalizarSaldos;
	}

	public void setResaltarid_periodoProcesoTotalizarSaldos(Border borderResaltar) {
		this.resaltarid_periodoProcesoTotalizarSaldos= borderResaltar;
	}

	public Boolean getMostrarid_periodoProcesoTotalizarSaldos() {
		return this.mostrarid_periodoProcesoTotalizarSaldos;
	}

	public void setMostrarid_periodoProcesoTotalizarSaldos(Boolean mostrarid_periodoProcesoTotalizarSaldos) {
		this.mostrarid_periodoProcesoTotalizarSaldos= mostrarid_periodoProcesoTotalizarSaldos;
	}

	public Boolean getActivarid_periodoProcesoTotalizarSaldos() {
		return this.activarid_periodoProcesoTotalizarSaldos;
	}

	public void setActivarid_periodoProcesoTotalizarSaldos(Boolean activarid_periodoProcesoTotalizarSaldos) {
		this.activarid_periodoProcesoTotalizarSaldos= activarid_periodoProcesoTotalizarSaldos;
	}

	public Boolean getCargarid_periodoProcesoTotalizarSaldos() {
		return this.cargarid_periodoProcesoTotalizarSaldos;
	}

	public void setCargarid_periodoProcesoTotalizarSaldos(Boolean cargarid_periodoProcesoTotalizarSaldos) {
		this.cargarid_periodoProcesoTotalizarSaldos= cargarid_periodoProcesoTotalizarSaldos;
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
		
		
		this.setMostraridProcesoTotalizarSaldos(esInicial);
		this.setMostrarid_ejercicioProcesoTotalizarSaldos(esInicial);
		this.setMostrarid_periodoProcesoTotalizarSaldos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoTotalizarSaldosConstantesFunciones.ID)) {
				this.setMostraridProcesoTotalizarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoTotalizarSaldosConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioProcesoTotalizarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoTotalizarSaldosConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoProcesoTotalizarSaldos(esAsigna);
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
		
		
		this.setActivaridProcesoTotalizarSaldos(esInicial);
		this.setActivarid_ejercicioProcesoTotalizarSaldos(esInicial);
		this.setActivarid_periodoProcesoTotalizarSaldos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoTotalizarSaldosConstantesFunciones.ID)) {
				this.setActivaridProcesoTotalizarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoTotalizarSaldosConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioProcesoTotalizarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoTotalizarSaldosConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoProcesoTotalizarSaldos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoTotalizarSaldosBeanSwingJInternalFrame procesototalizarsaldosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoTotalizarSaldos(esInicial);
		this.setResaltarid_ejercicioProcesoTotalizarSaldos(esInicial);
		this.setResaltarid_periodoProcesoTotalizarSaldos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoTotalizarSaldosConstantesFunciones.ID)) {
				this.setResaltaridProcesoTotalizarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoTotalizarSaldosConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioProcesoTotalizarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoTotalizarSaldosConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoProcesoTotalizarSaldos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoTotalizarSaldosBeanSwingJInternalFrame procesototalizarsaldosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorEjercicioPorPeriodoProcesoTotalizarSaldos=true;

	public Boolean getMostrarBusquedaPorEjercicioPorPeriodoProcesoTotalizarSaldos() {
		return this.mostrarBusquedaPorEjercicioPorPeriodoProcesoTotalizarSaldos;
	}

	public void setMostrarBusquedaPorEjercicioPorPeriodoProcesoTotalizarSaldos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorEjercicioPorPeriodoProcesoTotalizarSaldos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorEjercicioPorPeriodoProcesoTotalizarSaldos=true;

	public Boolean getActivarBusquedaPorEjercicioPorPeriodoProcesoTotalizarSaldos() {
		return this.activarBusquedaPorEjercicioPorPeriodoProcesoTotalizarSaldos;
	}

	public void setActivarBusquedaPorEjercicioPorPeriodoProcesoTotalizarSaldos(Boolean habilitarResaltar) {
		this.activarBusquedaPorEjercicioPorPeriodoProcesoTotalizarSaldos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorEjercicioPorPeriodoProcesoTotalizarSaldos=null;

	public Border getResaltarBusquedaPorEjercicioPorPeriodoProcesoTotalizarSaldos() {
		return this.resaltarBusquedaPorEjercicioPorPeriodoProcesoTotalizarSaldos;
	}

	public void setResaltarBusquedaPorEjercicioPorPeriodoProcesoTotalizarSaldos(Border borderResaltar) {
		this.resaltarBusquedaPorEjercicioPorPeriodoProcesoTotalizarSaldos= borderResaltar;
	}

	public void setResaltarBusquedaPorEjercicioPorPeriodoProcesoTotalizarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoTotalizarSaldosBeanSwingJInternalFrame procesototalizarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorEjercicioPorPeriodoProcesoTotalizarSaldos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}