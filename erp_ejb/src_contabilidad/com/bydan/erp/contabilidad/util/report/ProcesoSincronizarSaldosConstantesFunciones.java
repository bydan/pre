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


import com.bydan.erp.contabilidad.util.report.ProcesoSincronizarSaldosConstantesFunciones;
import com.bydan.erp.contabilidad.util.report.ProcesoSincronizarSaldosParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.ProcesoSincronizarSaldosParameterGeneral;

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
final public class ProcesoSincronizarSaldosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoSincronizarSaldos";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoSincronizarSaldos"+ProcesoSincronizarSaldosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoSincronizarSaldosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoSincronizarSaldosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoSincronizarSaldosConstantesFunciones.SCHEMA+"_"+ProcesoSincronizarSaldosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoSincronizarSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoSincronizarSaldosConstantesFunciones.SCHEMA+"_"+ProcesoSincronizarSaldosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoSincronizarSaldosConstantesFunciones.SCHEMA+"_"+ProcesoSincronizarSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoSincronizarSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoSincronizarSaldosConstantesFunciones.SCHEMA+"_"+ProcesoSincronizarSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoSincronizarSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoSincronizarSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoSincronizarSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoSincronizarSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoSincronizarSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoSincronizarSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoSincronizarSaldosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoSincronizarSaldosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoSincronizarSaldosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoSincronizarSaldosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Sincronizar Saldoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Sincronizar Saldos";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Sincronizar Saldos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoSincronizarSaldos";
	public static final String OBJECTNAME="procesosincronizarsaldos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="proceso_sincronizar_saldos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesosincronizarsaldos from "+ProcesoSincronizarSaldosConstantesFunciones.SPERSISTENCENAME+" procesosincronizarsaldos";
	public static String QUERYSELECTNATIVE="select "+ProcesoSincronizarSaldosConstantesFunciones.SCHEMA+"."+ProcesoSincronizarSaldosConstantesFunciones.TABLENAME+".id,"+ProcesoSincronizarSaldosConstantesFunciones.SCHEMA+"."+ProcesoSincronizarSaldosConstantesFunciones.TABLENAME+".version_row,"+ProcesoSincronizarSaldosConstantesFunciones.SCHEMA+"."+ProcesoSincronizarSaldosConstantesFunciones.TABLENAME+".id_ejercicio,"+ProcesoSincronizarSaldosConstantesFunciones.SCHEMA+"."+ProcesoSincronizarSaldosConstantesFunciones.TABLENAME+".id_periodo from "+ProcesoSincronizarSaldosConstantesFunciones.SCHEMA+"."+ProcesoSincronizarSaldosConstantesFunciones.TABLENAME;//+" as "+ProcesoSincronizarSaldosConstantesFunciones.TABLENAME;
	
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
	
		
		
		
		
	
	public static String getProcesoSincronizarSaldosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoSincronizarSaldosConstantesFunciones.IDEJERCICIO)) {sLabelColumna=ProcesoSincronizarSaldosConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(ProcesoSincronizarSaldosConstantesFunciones.IDPERIODO)) {sLabelColumna=ProcesoSincronizarSaldosConstantesFunciones.LABEL_IDPERIODO;}
		
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
	
	
	
			
			
			
			
	
	public static String getProcesoSincronizarSaldosDescripcion(ProcesoSincronizarSaldos procesosincronizarsaldos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesosincronizarsaldos !=null/* && procesosincronizarsaldos.getId()!=0*/) {
			if(procesosincronizarsaldos.getId()!=null) {
				sDescripcion=procesosincronizarsaldos.getId().toString();
			}//procesosincronizarsaldosprocesosincronizarsaldos.getId().toString().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoSincronizarSaldosDescripcionDetallado(ProcesoSincronizarSaldos procesosincronizarsaldos) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoSincronizarSaldosConstantesFunciones.ID+"=";
		sDescripcion+=procesosincronizarsaldos.getId().toString()+",";
		sDescripcion+=ProcesoSincronizarSaldosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesosincronizarsaldos.getVersionRow().toString()+",";
		sDescripcion+=ProcesoSincronizarSaldosConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=procesosincronizarsaldos.getid_ejercicio().toString()+",";
		sDescripcion+=ProcesoSincronizarSaldosConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=procesosincronizarsaldos.getid_periodo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoSincronizarSaldosDescripcion(ProcesoSincronizarSaldos procesosincronizarsaldos,String sValor) throws Exception {			
		if(procesosincronizarsaldos !=null) {
			;//procesosincronizarsaldosprocesosincronizarsaldos.getId().toString().trim();
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
		} else if(sNombreIndice.equals("BusquedaProcesoSincronizarSaldos")) {
			sNombreIndice="Tipo=  Por Ejercicio Por Periodo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesoSincronizarSaldos(Long id_ejercicio,Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoSincronizarSaldos(ProcesoSincronizarSaldos procesosincronizarsaldos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesoSincronizarSaldoss(List<ProcesoSincronizarSaldos> procesosincronizarsaldoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoSincronizarSaldos procesosincronizarsaldos: procesosincronizarsaldoss) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoSincronizarSaldos(ProcesoSincronizarSaldos procesosincronizarsaldos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesosincronizarsaldos.getConCambioAuxiliar()) {
			procesosincronizarsaldos.setIsDeleted(procesosincronizarsaldos.getIsDeletedAuxiliar());	
			procesosincronizarsaldos.setIsNew(procesosincronizarsaldos.getIsNewAuxiliar());	
			procesosincronizarsaldos.setIsChanged(procesosincronizarsaldos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesosincronizarsaldos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesosincronizarsaldos.setIsDeletedAuxiliar(false);	
			procesosincronizarsaldos.setIsNewAuxiliar(false);	
			procesosincronizarsaldos.setIsChangedAuxiliar(false);
			
			procesosincronizarsaldos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoSincronizarSaldoss(List<ProcesoSincronizarSaldos> procesosincronizarsaldoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoSincronizarSaldos procesosincronizarsaldos : procesosincronizarsaldoss) {
			if(conAsignarBase && procesosincronizarsaldos.getConCambioAuxiliar()) {
				procesosincronizarsaldos.setIsDeleted(procesosincronizarsaldos.getIsDeletedAuxiliar());	
				procesosincronizarsaldos.setIsNew(procesosincronizarsaldos.getIsNewAuxiliar());	
				procesosincronizarsaldos.setIsChanged(procesosincronizarsaldos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesosincronizarsaldos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesosincronizarsaldos.setIsDeletedAuxiliar(false);	
				procesosincronizarsaldos.setIsNewAuxiliar(false);	
				procesosincronizarsaldos.setIsChangedAuxiliar(false);
				
				procesosincronizarsaldos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoSincronizarSaldos(ProcesoSincronizarSaldos procesosincronizarsaldos,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoSincronizarSaldoss(List<ProcesoSincronizarSaldos> procesosincronizarsaldoss,Boolean conEnteros) throws Exception  {
		
		for(ProcesoSincronizarSaldos procesosincronizarsaldos: procesosincronizarsaldoss) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoSincronizarSaldos(List<ProcesoSincronizarSaldos> procesosincronizarsaldoss,ProcesoSincronizarSaldos procesosincronizarsaldosAux) throws Exception  {
		ProcesoSincronizarSaldosConstantesFunciones.InicializarValoresProcesoSincronizarSaldos(procesosincronizarsaldosAux,true);
		
		for(ProcesoSincronizarSaldos procesosincronizarsaldos: procesosincronizarsaldoss) {
			if(procesosincronizarsaldos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoSincronizarSaldos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoSincronizarSaldosConstantesFunciones.getArrayColumnasGlobalesProcesoSincronizarSaldos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoSincronizarSaldos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoSincronizarSaldosConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoSincronizarSaldosConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoSincronizarSaldosConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoSincronizarSaldosConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoSincronizarSaldos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoSincronizarSaldos> procesosincronizarsaldoss,ProcesoSincronizarSaldos procesosincronizarsaldos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoSincronizarSaldos procesosincronizarsaldosAux: procesosincronizarsaldoss) {
			if(procesosincronizarsaldosAux!=null && procesosincronizarsaldos!=null) {
				if((procesosincronizarsaldosAux.getId()==null && procesosincronizarsaldos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesosincronizarsaldosAux.getId()!=null && procesosincronizarsaldos.getId()!=null){
					if(procesosincronizarsaldosAux.getId().equals(procesosincronizarsaldos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoSincronizarSaldos(List<ProcesoSincronizarSaldos> procesosincronizarsaldoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoSincronizarSaldos procesosincronizarsaldos: procesosincronizarsaldoss) {			
			if(procesosincronizarsaldos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoSincronizarSaldos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoSincronizarSaldos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoSincronizarSaldos() throws Exception  {
		return ProcesoSincronizarSaldosConstantesFunciones.getTiposSeleccionarProcesoSincronizarSaldos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoSincronizarSaldos(Boolean conFk) throws Exception  {
		return ProcesoSincronizarSaldosConstantesFunciones.getTiposSeleccionarProcesoSincronizarSaldos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoSincronizarSaldos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoSincronizarSaldosConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(ProcesoSincronizarSaldosConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoSincronizarSaldosConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(ProcesoSincronizarSaldosConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoSincronizarSaldos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoSincronizarSaldos(ProcesoSincronizarSaldos procesosincronizarsaldosAux) throws Exception {
		
			procesosincronizarsaldosAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(procesosincronizarsaldosAux.getEjercicio()));
			procesosincronizarsaldosAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(procesosincronizarsaldosAux.getPeriodo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoSincronizarSaldos(List<ProcesoSincronizarSaldos> procesosincronizarsaldossTemp) throws Exception {
		for(ProcesoSincronizarSaldos procesosincronizarsaldosAux:procesosincronizarsaldossTemp) {
			
			procesosincronizarsaldosAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(procesosincronizarsaldosAux.getEjercicio()));
			procesosincronizarsaldosAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(procesosincronizarsaldosAux.getPeriodo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoSincronizarSaldos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoSincronizarSaldos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoSincronizarSaldos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoSincronizarSaldosConstantesFunciones.getClassesRelationshipsOfProcesoSincronizarSaldos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoSincronizarSaldos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoSincronizarSaldos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoSincronizarSaldosConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoSincronizarSaldos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoSincronizarSaldos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoSincronizarSaldos procesosincronizarsaldos,List<ProcesoSincronizarSaldos> procesosincronizarsaldoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoSincronizarSaldos procesosincronizarsaldos,List<ProcesoSincronizarSaldos> procesosincronizarsaldoss) throws Exception {
		try	{			
			for(ProcesoSincronizarSaldos procesosincronizarsaldosLocal:procesosincronizarsaldoss) {
				if(procesosincronizarsaldosLocal.getId().equals(procesosincronizarsaldos.getId())) {
					procesosincronizarsaldosLocal.setIsSelected(procesosincronizarsaldos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoSincronizarSaldos(List<ProcesoSincronizarSaldos> procesosincronizarsaldossAux) throws Exception {
		//this.procesosincronizarsaldossAux=procesosincronizarsaldossAux;
		
		for(ProcesoSincronizarSaldos procesosincronizarsaldosAux:procesosincronizarsaldossAux) {
			if(procesosincronizarsaldosAux.getIsChanged()) {
				procesosincronizarsaldosAux.setIsChanged(false);
			}		
			
			if(procesosincronizarsaldosAux.getIsNew()) {
				procesosincronizarsaldosAux.setIsNew(false);
			}	
			
			if(procesosincronizarsaldosAux.getIsDeleted()) {
				procesosincronizarsaldosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoSincronizarSaldos(ProcesoSincronizarSaldos procesosincronizarsaldosAux) throws Exception {
		//this.procesosincronizarsaldosAux=procesosincronizarsaldosAux;
		
			if(procesosincronizarsaldosAux.getIsChanged()) {
				procesosincronizarsaldosAux.setIsChanged(false);
			}		
			
			if(procesosincronizarsaldosAux.getIsNew()) {
				procesosincronizarsaldosAux.setIsNew(false);
			}	
			
			if(procesosincronizarsaldosAux.getIsDeleted()) {
				procesosincronizarsaldosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoSincronizarSaldos procesosincronizarsaldosAsignar,ProcesoSincronizarSaldos procesosincronizarsaldos) throws Exception {
		procesosincronizarsaldosAsignar.setId(procesosincronizarsaldos.getId());	
		procesosincronizarsaldosAsignar.setVersionRow(procesosincronizarsaldos.getVersionRow());	
		procesosincronizarsaldosAsignar.setid_ejercicio(procesosincronizarsaldos.getid_ejercicio());
		procesosincronizarsaldosAsignar.setejercicio_descripcion(procesosincronizarsaldos.getejercicio_descripcion());	
	}
	
	public static void inicializarProcesoSincronizarSaldos(ProcesoSincronizarSaldos procesosincronizarsaldos) throws Exception {
		try {
				procesosincronizarsaldos.setId(0L);	
					
				procesosincronizarsaldos.setid_ejercicio(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoSincronizarSaldos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoSincronizarSaldosConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoSincronizarSaldosConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoSincronizarSaldos(String sTipo,Row row,Workbook workbook,ProcesoSincronizarSaldos procesosincronizarsaldos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesosincronizarsaldos.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesosincronizarsaldos.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoSincronizarSaldos="";
	
	public String getsFinalQueryProcesoSincronizarSaldos() {
		return this.sFinalQueryProcesoSincronizarSaldos;
	}
	
	public void setsFinalQueryProcesoSincronizarSaldos(String sFinalQueryProcesoSincronizarSaldos) {
		this.sFinalQueryProcesoSincronizarSaldos= sFinalQueryProcesoSincronizarSaldos;
	}
	
	public Border resaltarSeleccionarProcesoSincronizarSaldos=null;
	
	public Border setResaltarSeleccionarProcesoSincronizarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoSincronizarSaldosBeanSwingJInternalFrame procesosincronizarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesosincronizarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoSincronizarSaldos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoSincronizarSaldos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoSincronizarSaldos() {
		return this.resaltarSeleccionarProcesoSincronizarSaldos;
	}
	
	public void setResaltarSeleccionarProcesoSincronizarSaldos(Border borderResaltarSeleccionarProcesoSincronizarSaldos) {
		this.resaltarSeleccionarProcesoSincronizarSaldos= borderResaltarSeleccionarProcesoSincronizarSaldos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoSincronizarSaldos=null;
	public Boolean mostraridProcesoSincronizarSaldos=true;
	public Boolean activaridProcesoSincronizarSaldos=true;

	public Border resaltarid_ejercicioProcesoSincronizarSaldos=null;
	public Boolean mostrarid_ejercicioProcesoSincronizarSaldos=true;
	public Boolean activarid_ejercicioProcesoSincronizarSaldos=true;
	public Boolean cargarid_ejercicioProcesoSincronizarSaldos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioProcesoSincronizarSaldos=false;//ConEventDepend=true

	public Border resaltarid_periodoProcesoSincronizarSaldos=null;
	public Boolean mostrarid_periodoProcesoSincronizarSaldos=true;
	public Boolean activarid_periodoProcesoSincronizarSaldos=true;
	public Boolean cargarid_periodoProcesoSincronizarSaldos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoProcesoSincronizarSaldos=true;//ConEventDepend=true

	
	

	public Border setResaltaridProcesoSincronizarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoSincronizarSaldosBeanSwingJInternalFrame procesosincronizarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesosincronizarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoSincronizarSaldos.setBorder(borderResaltar);
		
		this.resaltaridProcesoSincronizarSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoSincronizarSaldos() {
		return this.resaltaridProcesoSincronizarSaldos;
	}

	public void setResaltaridProcesoSincronizarSaldos(Border borderResaltar) {
		this.resaltaridProcesoSincronizarSaldos= borderResaltar;
	}

	public Boolean getMostraridProcesoSincronizarSaldos() {
		return this.mostraridProcesoSincronizarSaldos;
	}

	public void setMostraridProcesoSincronizarSaldos(Boolean mostraridProcesoSincronizarSaldos) {
		this.mostraridProcesoSincronizarSaldos= mostraridProcesoSincronizarSaldos;
	}

	public Boolean getActivaridProcesoSincronizarSaldos() {
		return this.activaridProcesoSincronizarSaldos;
	}

	public void setActivaridProcesoSincronizarSaldos(Boolean activaridProcesoSincronizarSaldos) {
		this.activaridProcesoSincronizarSaldos= activaridProcesoSincronizarSaldos;
	}

	public Border setResaltarid_ejercicioProcesoSincronizarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoSincronizarSaldosBeanSwingJInternalFrame procesosincronizarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesosincronizarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoSincronizarSaldos.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioProcesoSincronizarSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioProcesoSincronizarSaldos() {
		return this.resaltarid_ejercicioProcesoSincronizarSaldos;
	}

	public void setResaltarid_ejercicioProcesoSincronizarSaldos(Border borderResaltar) {
		this.resaltarid_ejercicioProcesoSincronizarSaldos= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioProcesoSincronizarSaldos() {
		return this.mostrarid_ejercicioProcesoSincronizarSaldos;
	}

	public void setMostrarid_ejercicioProcesoSincronizarSaldos(Boolean mostrarid_ejercicioProcesoSincronizarSaldos) {
		this.mostrarid_ejercicioProcesoSincronizarSaldos= mostrarid_ejercicioProcesoSincronizarSaldos;
	}

	public Boolean getActivarid_ejercicioProcesoSincronizarSaldos() {
		return this.activarid_ejercicioProcesoSincronizarSaldos;
	}

	public void setActivarid_ejercicioProcesoSincronizarSaldos(Boolean activarid_ejercicioProcesoSincronizarSaldos) {
		this.activarid_ejercicioProcesoSincronizarSaldos= activarid_ejercicioProcesoSincronizarSaldos;
	}

	public Boolean getCargarid_ejercicioProcesoSincronizarSaldos() {
		return this.cargarid_ejercicioProcesoSincronizarSaldos;
	}

	public void setCargarid_ejercicioProcesoSincronizarSaldos(Boolean cargarid_ejercicioProcesoSincronizarSaldos) {
		this.cargarid_ejercicioProcesoSincronizarSaldos= cargarid_ejercicioProcesoSincronizarSaldos;
	}

	public Border setResaltarid_periodoProcesoSincronizarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoSincronizarSaldosBeanSwingJInternalFrame procesosincronizarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesosincronizarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoSincronizarSaldos.setBorder(borderResaltar);
		
		this.resaltarid_periodoProcesoSincronizarSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoProcesoSincronizarSaldos() {
		return this.resaltarid_periodoProcesoSincronizarSaldos;
	}

	public void setResaltarid_periodoProcesoSincronizarSaldos(Border borderResaltar) {
		this.resaltarid_periodoProcesoSincronizarSaldos= borderResaltar;
	}

	public Boolean getMostrarid_periodoProcesoSincronizarSaldos() {
		return this.mostrarid_periodoProcesoSincronizarSaldos;
	}

	public void setMostrarid_periodoProcesoSincronizarSaldos(Boolean mostrarid_periodoProcesoSincronizarSaldos) {
		this.mostrarid_periodoProcesoSincronizarSaldos= mostrarid_periodoProcesoSincronizarSaldos;
	}

	public Boolean getActivarid_periodoProcesoSincronizarSaldos() {
		return this.activarid_periodoProcesoSincronizarSaldos;
	}

	public void setActivarid_periodoProcesoSincronizarSaldos(Boolean activarid_periodoProcesoSincronizarSaldos) {
		this.activarid_periodoProcesoSincronizarSaldos= activarid_periodoProcesoSincronizarSaldos;
	}

	public Boolean getCargarid_periodoProcesoSincronizarSaldos() {
		return this.cargarid_periodoProcesoSincronizarSaldos;
	}

	public void setCargarid_periodoProcesoSincronizarSaldos(Boolean cargarid_periodoProcesoSincronizarSaldos) {
		this.cargarid_periodoProcesoSincronizarSaldos= cargarid_periodoProcesoSincronizarSaldos;
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
		
		
		this.setMostraridProcesoSincronizarSaldos(esInicial);
		this.setMostrarid_ejercicioProcesoSincronizarSaldos(esInicial);
		this.setMostrarid_periodoProcesoSincronizarSaldos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoSincronizarSaldosConstantesFunciones.ID)) {
				this.setMostraridProcesoSincronizarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSincronizarSaldosConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioProcesoSincronizarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSincronizarSaldosConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoProcesoSincronizarSaldos(esAsigna);
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
		
		
		this.setActivaridProcesoSincronizarSaldos(esInicial);
		this.setActivarid_ejercicioProcesoSincronizarSaldos(esInicial);
		this.setActivarid_periodoProcesoSincronizarSaldos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoSincronizarSaldosConstantesFunciones.ID)) {
				this.setActivaridProcesoSincronizarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSincronizarSaldosConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioProcesoSincronizarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSincronizarSaldosConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoProcesoSincronizarSaldos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoSincronizarSaldosBeanSwingJInternalFrame procesosincronizarsaldosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoSincronizarSaldos(esInicial);
		this.setResaltarid_ejercicioProcesoSincronizarSaldos(esInicial);
		this.setResaltarid_periodoProcesoSincronizarSaldos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoSincronizarSaldosConstantesFunciones.ID)) {
				this.setResaltaridProcesoSincronizarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSincronizarSaldosConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioProcesoSincronizarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSincronizarSaldosConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoProcesoSincronizarSaldos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoSincronizarSaldosBeanSwingJInternalFrame procesosincronizarsaldosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoSincronizarSaldosProcesoSincronizarSaldos=true;

	public Boolean getMostrarBusquedaProcesoSincronizarSaldosProcesoSincronizarSaldos() {
		return this.mostrarBusquedaProcesoSincronizarSaldosProcesoSincronizarSaldos;
	}

	public void setMostrarBusquedaProcesoSincronizarSaldosProcesoSincronizarSaldos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoSincronizarSaldosProcesoSincronizarSaldos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoSincronizarSaldosProcesoSincronizarSaldos=true;

	public Boolean getActivarBusquedaProcesoSincronizarSaldosProcesoSincronizarSaldos() {
		return this.activarBusquedaProcesoSincronizarSaldosProcesoSincronizarSaldos;
	}

	public void setActivarBusquedaProcesoSincronizarSaldosProcesoSincronizarSaldos(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoSincronizarSaldosProcesoSincronizarSaldos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoSincronizarSaldosProcesoSincronizarSaldos=null;

	public Border getResaltarBusquedaProcesoSincronizarSaldosProcesoSincronizarSaldos() {
		return this.resaltarBusquedaProcesoSincronizarSaldosProcesoSincronizarSaldos;
	}

	public void setResaltarBusquedaProcesoSincronizarSaldosProcesoSincronizarSaldos(Border borderResaltar) {
		this.resaltarBusquedaProcesoSincronizarSaldosProcesoSincronizarSaldos= borderResaltar;
	}

	public void setResaltarBusquedaProcesoSincronizarSaldosProcesoSincronizarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoSincronizarSaldosBeanSwingJInternalFrame procesosincronizarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoSincronizarSaldosProcesoSincronizarSaldos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}