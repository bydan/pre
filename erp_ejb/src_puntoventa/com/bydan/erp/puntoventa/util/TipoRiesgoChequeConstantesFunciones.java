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
package com.bydan.erp.puntoventa.util;

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


import com.bydan.erp.puntoventa.util.TipoRiesgoChequeConstantesFunciones;
import com.bydan.erp.puntoventa.util.TipoRiesgoChequeParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.TipoRiesgoChequeParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoRiesgoChequeConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoRiesgoCheque";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoRiesgoCheque"+TipoRiesgoChequeConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoRiesgoChequeHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoRiesgoChequeHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoRiesgoChequeConstantesFunciones.SCHEMA+"_"+TipoRiesgoChequeConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoRiesgoChequeHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoRiesgoChequeConstantesFunciones.SCHEMA+"_"+TipoRiesgoChequeConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoRiesgoChequeConstantesFunciones.SCHEMA+"_"+TipoRiesgoChequeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoRiesgoChequeHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoRiesgoChequeConstantesFunciones.SCHEMA+"_"+TipoRiesgoChequeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRiesgoChequeConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRiesgoChequeHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRiesgoChequeConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRiesgoChequeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRiesgoChequeHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRiesgoChequeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoRiesgoChequeConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoRiesgoChequeConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoRiesgoChequeConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoRiesgoChequeConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Riesgo Cheques";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Riesgo Cheque";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Riesgo Cheque";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoRiesgoCheque";
	public static final String OBJECTNAME="tiporiesgocheque";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="tipo_riesgo_cheque";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiporiesgocheque from "+TipoRiesgoChequeConstantesFunciones.SPERSISTENCENAME+" tiporiesgocheque";
	public static String QUERYSELECTNATIVE="select "+TipoRiesgoChequeConstantesFunciones.SCHEMA+"."+TipoRiesgoChequeConstantesFunciones.TABLENAME+".id,"+TipoRiesgoChequeConstantesFunciones.SCHEMA+"."+TipoRiesgoChequeConstantesFunciones.TABLENAME+".version_row,"+TipoRiesgoChequeConstantesFunciones.SCHEMA+"."+TipoRiesgoChequeConstantesFunciones.TABLENAME+".nombre,"+TipoRiesgoChequeConstantesFunciones.SCHEMA+"."+TipoRiesgoChequeConstantesFunciones.TABLENAME+".descripcion from "+TipoRiesgoChequeConstantesFunciones.SCHEMA+"."+TipoRiesgoChequeConstantesFunciones.TABLENAME;//+" as "+TipoRiesgoChequeConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoRiesgoChequeLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoRiesgoChequeConstantesFunciones.NOMBRE)) {sLabelColumna=TipoRiesgoChequeConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoRiesgoChequeConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoRiesgoChequeConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoRiesgoChequeDescripcion(TipoRiesgoCheque tiporiesgocheque) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiporiesgocheque !=null/* && tiporiesgocheque.getId()!=0*/) {
			sDescripcion=tiporiesgocheque.getnombre();//tiporiesgochequetiporiesgocheque.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoRiesgoChequeDescripcionDetallado(TipoRiesgoCheque tiporiesgocheque) {
		String sDescripcion="";
			
		sDescripcion+=TipoRiesgoChequeConstantesFunciones.ID+"=";
		sDescripcion+=tiporiesgocheque.getId().toString()+",";
		sDescripcion+=TipoRiesgoChequeConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiporiesgocheque.getVersionRow().toString()+",";
		sDescripcion+=TipoRiesgoChequeConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiporiesgocheque.getnombre()+",";
		sDescripcion+=TipoRiesgoChequeConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tiporiesgocheque.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoRiesgoChequeDescripcion(TipoRiesgoCheque tiporiesgocheque,String sValor) throws Exception {			
		if(tiporiesgocheque !=null) {
			tiporiesgocheque.setnombre(sValor);;//tiporiesgochequetiporiesgocheque.getnombre().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoRiesgoCheque(TipoRiesgoCheque tiporiesgocheque,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiporiesgocheque.setnombre(tiporiesgocheque.getnombre().trim());
		tiporiesgocheque.setdescripcion(tiporiesgocheque.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoRiesgoCheques(List<TipoRiesgoCheque> tiporiesgocheques,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoRiesgoCheque tiporiesgocheque: tiporiesgocheques) {
			tiporiesgocheque.setnombre(tiporiesgocheque.getnombre().trim());
			tiporiesgocheque.setdescripcion(tiporiesgocheque.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRiesgoCheque(TipoRiesgoCheque tiporiesgocheque,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiporiesgocheque.getConCambioAuxiliar()) {
			tiporiesgocheque.setIsDeleted(tiporiesgocheque.getIsDeletedAuxiliar());	
			tiporiesgocheque.setIsNew(tiporiesgocheque.getIsNewAuxiliar());	
			tiporiesgocheque.setIsChanged(tiporiesgocheque.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiporiesgocheque.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiporiesgocheque.setIsDeletedAuxiliar(false);	
			tiporiesgocheque.setIsNewAuxiliar(false);	
			tiporiesgocheque.setIsChangedAuxiliar(false);
			
			tiporiesgocheque.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRiesgoCheques(List<TipoRiesgoCheque> tiporiesgocheques,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoRiesgoCheque tiporiesgocheque : tiporiesgocheques) {
			if(conAsignarBase && tiporiesgocheque.getConCambioAuxiliar()) {
				tiporiesgocheque.setIsDeleted(tiporiesgocheque.getIsDeletedAuxiliar());	
				tiporiesgocheque.setIsNew(tiporiesgocheque.getIsNewAuxiliar());	
				tiporiesgocheque.setIsChanged(tiporiesgocheque.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiporiesgocheque.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiporiesgocheque.setIsDeletedAuxiliar(false);	
				tiporiesgocheque.setIsNewAuxiliar(false);	
				tiporiesgocheque.setIsChangedAuxiliar(false);
				
				tiporiesgocheque.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoRiesgoCheque(TipoRiesgoCheque tiporiesgocheque,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoRiesgoCheques(List<TipoRiesgoCheque> tiporiesgocheques,Boolean conEnteros) throws Exception  {
		
		for(TipoRiesgoCheque tiporiesgocheque: tiporiesgocheques) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoRiesgoCheque(List<TipoRiesgoCheque> tiporiesgocheques,TipoRiesgoCheque tiporiesgochequeAux) throws Exception  {
		TipoRiesgoChequeConstantesFunciones.InicializarValoresTipoRiesgoCheque(tiporiesgochequeAux,true);
		
		for(TipoRiesgoCheque tiporiesgocheque: tiporiesgocheques) {
			if(tiporiesgocheque.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRiesgoCheque(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoRiesgoChequeConstantesFunciones.getArrayColumnasGlobalesTipoRiesgoCheque(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRiesgoCheque(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoRiesgoCheque(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoRiesgoCheque> tiporiesgocheques,TipoRiesgoCheque tiporiesgocheque,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoRiesgoCheque tiporiesgochequeAux: tiporiesgocheques) {
			if(tiporiesgochequeAux!=null && tiporiesgocheque!=null) {
				if((tiporiesgochequeAux.getId()==null && tiporiesgocheque.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiporiesgochequeAux.getId()!=null && tiporiesgocheque.getId()!=null){
					if(tiporiesgochequeAux.getId().equals(tiporiesgocheque.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoRiesgoCheque(List<TipoRiesgoCheque> tiporiesgocheques) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoRiesgoCheque tiporiesgocheque: tiporiesgocheques) {			
			if(tiporiesgocheque.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoRiesgoCheque() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoRiesgoChequeConstantesFunciones.LABEL_ID, TipoRiesgoChequeConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRiesgoChequeConstantesFunciones.LABEL_VERSIONROW, TipoRiesgoChequeConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRiesgoChequeConstantesFunciones.LABEL_NOMBRE, TipoRiesgoChequeConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRiesgoChequeConstantesFunciones.LABEL_DESCRIPCION, TipoRiesgoChequeConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoRiesgoCheque() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoRiesgoChequeConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRiesgoChequeConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRiesgoChequeConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRiesgoChequeConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRiesgoCheque() throws Exception  {
		return TipoRiesgoChequeConstantesFunciones.getTiposSeleccionarTipoRiesgoCheque(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRiesgoCheque(Boolean conFk) throws Exception  {
		return TipoRiesgoChequeConstantesFunciones.getTiposSeleccionarTipoRiesgoCheque(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRiesgoCheque(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRiesgoChequeConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoRiesgoChequeConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRiesgoChequeConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoRiesgoChequeConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoRiesgoCheque(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRiesgoCheque(TipoRiesgoCheque tiporiesgochequeAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRiesgoCheque(List<TipoRiesgoCheque> tiporiesgochequesTemp) throws Exception {
		for(TipoRiesgoCheque tiporiesgochequeAux:tiporiesgochequesTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRiesgoCheque(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoRiesgoCheque(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRiesgoCheque(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRiesgoChequeConstantesFunciones.getClassesRelationshipsOfTipoRiesgoCheque(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRiesgoCheque(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(FormaPagoPuntoVenta.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(FormaPagoPuntoVenta.class)) {
						classes.add(new Classe(FormaPagoPuntoVenta.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRiesgoCheque(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRiesgoChequeConstantesFunciones.getClassesRelationshipsFromStringsOfTipoRiesgoCheque(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRiesgoCheque(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(FormaPagoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormaPagoPuntoVenta.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(FormaPagoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormaPagoPuntoVenta.class)); continue;
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
	public static void actualizarLista(TipoRiesgoCheque tiporiesgocheque,List<TipoRiesgoCheque> tiporiesgocheques,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoRiesgoCheque tiporiesgochequeEncontrado=null;
			
			for(TipoRiesgoCheque tiporiesgochequeLocal:tiporiesgocheques) {
				if(tiporiesgochequeLocal.getId().equals(tiporiesgocheque.getId())) {
					tiporiesgochequeEncontrado=tiporiesgochequeLocal;
					
					tiporiesgochequeLocal.setIsChanged(tiporiesgocheque.getIsChanged());
					tiporiesgochequeLocal.setIsNew(tiporiesgocheque.getIsNew());
					tiporiesgochequeLocal.setIsDeleted(tiporiesgocheque.getIsDeleted());
					
					tiporiesgochequeLocal.setGeneralEntityOriginal(tiporiesgocheque.getGeneralEntityOriginal());
					
					tiporiesgochequeLocal.setId(tiporiesgocheque.getId());	
					tiporiesgochequeLocal.setVersionRow(tiporiesgocheque.getVersionRow());	
					tiporiesgochequeLocal.setnombre(tiporiesgocheque.getnombre());	
					tiporiesgochequeLocal.setdescripcion(tiporiesgocheque.getdescripcion());	
					
					
					tiporiesgochequeLocal.setFormaPagoPuntoVentas(tiporiesgocheque.getFormaPagoPuntoVentas());
					
					existe=true;
					break;
				}
			}
			
			if(!tiporiesgocheque.getIsDeleted()) {
				if(!existe) {
					tiporiesgocheques.add(tiporiesgocheque);
				}
			} else {
				if(tiporiesgochequeEncontrado!=null && permiteQuitar)  {
					tiporiesgocheques.remove(tiporiesgochequeEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoRiesgoCheque tiporiesgocheque,List<TipoRiesgoCheque> tiporiesgocheques) throws Exception {
		try	{			
			for(TipoRiesgoCheque tiporiesgochequeLocal:tiporiesgocheques) {
				if(tiporiesgochequeLocal.getId().equals(tiporiesgocheque.getId())) {
					tiporiesgochequeLocal.setIsSelected(tiporiesgocheque.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoRiesgoCheque(List<TipoRiesgoCheque> tiporiesgochequesAux) throws Exception {
		//this.tiporiesgochequesAux=tiporiesgochequesAux;
		
		for(TipoRiesgoCheque tiporiesgochequeAux:tiporiesgochequesAux) {
			if(tiporiesgochequeAux.getIsChanged()) {
				tiporiesgochequeAux.setIsChanged(false);
			}		
			
			if(tiporiesgochequeAux.getIsNew()) {
				tiporiesgochequeAux.setIsNew(false);
			}	
			
			if(tiporiesgochequeAux.getIsDeleted()) {
				tiporiesgochequeAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoRiesgoCheque(TipoRiesgoCheque tiporiesgochequeAux) throws Exception {
		//this.tiporiesgochequeAux=tiporiesgochequeAux;
		
			if(tiporiesgochequeAux.getIsChanged()) {
				tiporiesgochequeAux.setIsChanged(false);
			}		
			
			if(tiporiesgochequeAux.getIsNew()) {
				tiporiesgochequeAux.setIsNew(false);
			}	
			
			if(tiporiesgochequeAux.getIsDeleted()) {
				tiporiesgochequeAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoRiesgoCheque tiporiesgochequeAsignar,TipoRiesgoCheque tiporiesgocheque) throws Exception {
		tiporiesgochequeAsignar.setId(tiporiesgocheque.getId());	
		tiporiesgochequeAsignar.setVersionRow(tiporiesgocheque.getVersionRow());	
		tiporiesgochequeAsignar.setnombre(tiporiesgocheque.getnombre());	
		tiporiesgochequeAsignar.setdescripcion(tiporiesgocheque.getdescripcion());	
	}
	
	public static void inicializarTipoRiesgoCheque(TipoRiesgoCheque tiporiesgocheque) throws Exception {
		try {
				tiporiesgocheque.setId(0L);	
					
				tiporiesgocheque.setnombre("");	
				tiporiesgocheque.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoRiesgoCheque(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRiesgoChequeConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRiesgoChequeConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoRiesgoCheque(String sTipo,Row row,Workbook workbook,TipoRiesgoCheque tiporiesgocheque,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporiesgocheque.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporiesgocheque.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoRiesgoCheque=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoRiesgoCheque() {
		return this.sFinalQueryTipoRiesgoCheque;
	}
	
	public void setsFinalQueryTipoRiesgoCheque(String sFinalQueryTipoRiesgoCheque) {
		this.sFinalQueryTipoRiesgoCheque= sFinalQueryTipoRiesgoCheque;
	}
	
	public Border resaltarSeleccionarTipoRiesgoCheque=null;
	
	public Border setResaltarSeleccionarTipoRiesgoCheque(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRiesgoChequeBeanSwingJInternalFrame tiporiesgochequeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiporiesgochequeBeanSwingJInternalFrame.jTtoolBarTipoRiesgoCheque.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoRiesgoCheque= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoRiesgoCheque() {
		return this.resaltarSeleccionarTipoRiesgoCheque;
	}
	
	public void setResaltarSeleccionarTipoRiesgoCheque(Border borderResaltarSeleccionarTipoRiesgoCheque) {
		this.resaltarSeleccionarTipoRiesgoCheque= borderResaltarSeleccionarTipoRiesgoCheque;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoRiesgoCheque=null;
	public Boolean mostraridTipoRiesgoCheque=true;
	public Boolean activaridTipoRiesgoCheque=true;

	public Border resaltarnombreTipoRiesgoCheque=null;
	public Boolean mostrarnombreTipoRiesgoCheque=true;
	public Boolean activarnombreTipoRiesgoCheque=true;

	public Border resaltardescripcionTipoRiesgoCheque=null;
	public Boolean mostrardescripcionTipoRiesgoCheque=true;
	public Boolean activardescripcionTipoRiesgoCheque=true;

	
	

	public Border setResaltaridTipoRiesgoCheque(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRiesgoChequeBeanSwingJInternalFrame tiporiesgochequeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporiesgochequeBeanSwingJInternalFrame.jTtoolBarTipoRiesgoCheque.setBorder(borderResaltar);
		
		this.resaltaridTipoRiesgoCheque= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoRiesgoCheque() {
		return this.resaltaridTipoRiesgoCheque;
	}

	public void setResaltaridTipoRiesgoCheque(Border borderResaltar) {
		this.resaltaridTipoRiesgoCheque= borderResaltar;
	}

	public Boolean getMostraridTipoRiesgoCheque() {
		return this.mostraridTipoRiesgoCheque;
	}

	public void setMostraridTipoRiesgoCheque(Boolean mostraridTipoRiesgoCheque) {
		this.mostraridTipoRiesgoCheque= mostraridTipoRiesgoCheque;
	}

	public Boolean getActivaridTipoRiesgoCheque() {
		return this.activaridTipoRiesgoCheque;
	}

	public void setActivaridTipoRiesgoCheque(Boolean activaridTipoRiesgoCheque) {
		this.activaridTipoRiesgoCheque= activaridTipoRiesgoCheque;
	}

	public Border setResaltarnombreTipoRiesgoCheque(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRiesgoChequeBeanSwingJInternalFrame tiporiesgochequeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporiesgochequeBeanSwingJInternalFrame.jTtoolBarTipoRiesgoCheque.setBorder(borderResaltar);
		
		this.resaltarnombreTipoRiesgoCheque= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoRiesgoCheque() {
		return this.resaltarnombreTipoRiesgoCheque;
	}

	public void setResaltarnombreTipoRiesgoCheque(Border borderResaltar) {
		this.resaltarnombreTipoRiesgoCheque= borderResaltar;
	}

	public Boolean getMostrarnombreTipoRiesgoCheque() {
		return this.mostrarnombreTipoRiesgoCheque;
	}

	public void setMostrarnombreTipoRiesgoCheque(Boolean mostrarnombreTipoRiesgoCheque) {
		this.mostrarnombreTipoRiesgoCheque= mostrarnombreTipoRiesgoCheque;
	}

	public Boolean getActivarnombreTipoRiesgoCheque() {
		return this.activarnombreTipoRiesgoCheque;
	}

	public void setActivarnombreTipoRiesgoCheque(Boolean activarnombreTipoRiesgoCheque) {
		this.activarnombreTipoRiesgoCheque= activarnombreTipoRiesgoCheque;
	}

	public Border setResaltardescripcionTipoRiesgoCheque(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRiesgoChequeBeanSwingJInternalFrame tiporiesgochequeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporiesgochequeBeanSwingJInternalFrame.jTtoolBarTipoRiesgoCheque.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoRiesgoCheque= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoRiesgoCheque() {
		return this.resaltardescripcionTipoRiesgoCheque;
	}

	public void setResaltardescripcionTipoRiesgoCheque(Border borderResaltar) {
		this.resaltardescripcionTipoRiesgoCheque= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoRiesgoCheque() {
		return this.mostrardescripcionTipoRiesgoCheque;
	}

	public void setMostrardescripcionTipoRiesgoCheque(Boolean mostrardescripcionTipoRiesgoCheque) {
		this.mostrardescripcionTipoRiesgoCheque= mostrardescripcionTipoRiesgoCheque;
	}

	public Boolean getActivardescripcionTipoRiesgoCheque() {
		return this.activardescripcionTipoRiesgoCheque;
	}

	public void setActivardescripcionTipoRiesgoCheque(Boolean activardescripcionTipoRiesgoCheque) {
		this.activardescripcionTipoRiesgoCheque= activardescripcionTipoRiesgoCheque;
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
		
		
		this.setMostraridTipoRiesgoCheque(esInicial);
		this.setMostrarnombreTipoRiesgoCheque(esInicial);
		this.setMostrardescripcionTipoRiesgoCheque(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRiesgoChequeConstantesFunciones.ID)) {
				this.setMostraridTipoRiesgoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRiesgoChequeConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoRiesgoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRiesgoChequeConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoRiesgoCheque(esAsigna);
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
		
		
		this.setActivaridTipoRiesgoCheque(esInicial);
		this.setActivarnombreTipoRiesgoCheque(esInicial);
		this.setActivardescripcionTipoRiesgoCheque(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRiesgoChequeConstantesFunciones.ID)) {
				this.setActivaridTipoRiesgoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRiesgoChequeConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoRiesgoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRiesgoChequeConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoRiesgoCheque(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRiesgoChequeBeanSwingJInternalFrame tiporiesgochequeBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoRiesgoCheque(esInicial);
		this.setResaltarnombreTipoRiesgoCheque(esInicial);
		this.setResaltardescripcionTipoRiesgoCheque(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRiesgoChequeConstantesFunciones.ID)) {
				this.setResaltaridTipoRiesgoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRiesgoChequeConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoRiesgoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRiesgoChequeConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoRiesgoCheque(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFormaPagoPuntoVentaTipoRiesgoCheque=null;

	public Border getResaltarFormaPagoPuntoVentaTipoRiesgoCheque() {
		return this.resaltarFormaPagoPuntoVentaTipoRiesgoCheque;
	}

	public void setResaltarFormaPagoPuntoVentaTipoRiesgoCheque(Border borderResaltarFormaPagoPuntoVenta) {
		if(borderResaltarFormaPagoPuntoVenta!=null) {
			this.resaltarFormaPagoPuntoVentaTipoRiesgoCheque= borderResaltarFormaPagoPuntoVenta;
		}
	}

	public Border setResaltarFormaPagoPuntoVentaTipoRiesgoCheque(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRiesgoChequeBeanSwingJInternalFrame tiporiesgochequeBeanSwingJInternalFrame*/) {
		Border borderResaltarFormaPagoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tiporiesgochequeBeanSwingJInternalFrame.jTtoolBarTipoRiesgoCheque.setBorder(borderResaltarFormaPagoPuntoVenta);
			
		this.resaltarFormaPagoPuntoVentaTipoRiesgoCheque= borderResaltarFormaPagoPuntoVenta;

		 return borderResaltarFormaPagoPuntoVenta;
	}



	public Boolean mostrarFormaPagoPuntoVentaTipoRiesgoCheque=true;

	public Boolean getMostrarFormaPagoPuntoVentaTipoRiesgoCheque() {
		return this.mostrarFormaPagoPuntoVentaTipoRiesgoCheque;
	}

	public void setMostrarFormaPagoPuntoVentaTipoRiesgoCheque(Boolean visibilidadResaltarFormaPagoPuntoVenta) {
		this.mostrarFormaPagoPuntoVentaTipoRiesgoCheque= visibilidadResaltarFormaPagoPuntoVenta;
	}



	public Boolean activarFormaPagoPuntoVentaTipoRiesgoCheque=true;

	public Boolean gethabilitarResaltarFormaPagoPuntoVentaTipoRiesgoCheque() {
		return this.activarFormaPagoPuntoVentaTipoRiesgoCheque;
	}

	public void setActivarFormaPagoPuntoVentaTipoRiesgoCheque(Boolean habilitarResaltarFormaPagoPuntoVenta) {
		this.activarFormaPagoPuntoVentaTipoRiesgoCheque= habilitarResaltarFormaPagoPuntoVenta;
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

		this.setMostrarFormaPagoPuntoVentaTipoRiesgoCheque(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setMostrarFormaPagoPuntoVentaTipoRiesgoCheque(esAsigna);
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

		this.setActivarFormaPagoPuntoVentaTipoRiesgoCheque(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setActivarFormaPagoPuntoVentaTipoRiesgoCheque(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRiesgoChequeBeanSwingJInternalFrame tiporiesgochequeBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFormaPagoPuntoVentaTipoRiesgoCheque(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setResaltarFormaPagoPuntoVentaTipoRiesgoCheque(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}