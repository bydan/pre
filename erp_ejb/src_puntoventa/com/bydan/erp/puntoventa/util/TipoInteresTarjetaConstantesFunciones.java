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


import com.bydan.erp.puntoventa.util.TipoInteresTarjetaConstantesFunciones;
import com.bydan.erp.puntoventa.util.TipoInteresTarjetaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.TipoInteresTarjetaParameterGeneral;

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
final public class TipoInteresTarjetaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoInteresTarjeta";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoInteresTarjeta"+TipoInteresTarjetaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoInteresTarjetaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoInteresTarjetaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoInteresTarjetaConstantesFunciones.SCHEMA+"_"+TipoInteresTarjetaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoInteresTarjetaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoInteresTarjetaConstantesFunciones.SCHEMA+"_"+TipoInteresTarjetaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoInteresTarjetaConstantesFunciones.SCHEMA+"_"+TipoInteresTarjetaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoInteresTarjetaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoInteresTarjetaConstantesFunciones.SCHEMA+"_"+TipoInteresTarjetaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoInteresTarjetaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoInteresTarjetaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoInteresTarjetaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoInteresTarjetaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoInteresTarjetaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoInteresTarjetaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoInteresTarjetaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoInteresTarjetaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoInteresTarjetaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoInteresTarjetaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Interes Tarjetas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Interes Tarjeta";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Interes Tarjeta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoInteresTarjeta";
	public static final String OBJECTNAME="tipointerestarjeta";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="tipo_interes_tarjeta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipointerestarjeta from "+TipoInteresTarjetaConstantesFunciones.SPERSISTENCENAME+" tipointerestarjeta";
	public static String QUERYSELECTNATIVE="select "+TipoInteresTarjetaConstantesFunciones.SCHEMA+"."+TipoInteresTarjetaConstantesFunciones.TABLENAME+".id,"+TipoInteresTarjetaConstantesFunciones.SCHEMA+"."+TipoInteresTarjetaConstantesFunciones.TABLENAME+".version_row,"+TipoInteresTarjetaConstantesFunciones.SCHEMA+"."+TipoInteresTarjetaConstantesFunciones.TABLENAME+".nombre,"+TipoInteresTarjetaConstantesFunciones.SCHEMA+"."+TipoInteresTarjetaConstantesFunciones.TABLENAME+".descripcion from "+TipoInteresTarjetaConstantesFunciones.SCHEMA+"."+TipoInteresTarjetaConstantesFunciones.TABLENAME;//+" as "+TipoInteresTarjetaConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoInteresTarjetaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoInteresTarjetaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoInteresTarjetaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoInteresTarjetaConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoInteresTarjetaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoInteresTarjetaDescripcion(TipoInteresTarjeta tipointerestarjeta) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipointerestarjeta !=null/* && tipointerestarjeta.getId()!=0*/) {
			sDescripcion=tipointerestarjeta.getnombre();//tipointerestarjetatipointerestarjeta.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoInteresTarjetaDescripcionDetallado(TipoInteresTarjeta tipointerestarjeta) {
		String sDescripcion="";
			
		sDescripcion+=TipoInteresTarjetaConstantesFunciones.ID+"=";
		sDescripcion+=tipointerestarjeta.getId().toString()+",";
		sDescripcion+=TipoInteresTarjetaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipointerestarjeta.getVersionRow().toString()+",";
		sDescripcion+=TipoInteresTarjetaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipointerestarjeta.getnombre()+",";
		sDescripcion+=TipoInteresTarjetaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tipointerestarjeta.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoInteresTarjetaDescripcion(TipoInteresTarjeta tipointerestarjeta,String sValor) throws Exception {			
		if(tipointerestarjeta !=null) {
			tipointerestarjeta.setnombre(sValor);;//tipointerestarjetatipointerestarjeta.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoInteresTarjeta(TipoInteresTarjeta tipointerestarjeta,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipointerestarjeta.setnombre(tipointerestarjeta.getnombre().trim());
		tipointerestarjeta.setdescripcion(tipointerestarjeta.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoInteresTarjetas(List<TipoInteresTarjeta> tipointerestarjetas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoInteresTarjeta tipointerestarjeta: tipointerestarjetas) {
			tipointerestarjeta.setnombre(tipointerestarjeta.getnombre().trim());
			tipointerestarjeta.setdescripcion(tipointerestarjeta.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoInteresTarjeta(TipoInteresTarjeta tipointerestarjeta,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipointerestarjeta.getConCambioAuxiliar()) {
			tipointerestarjeta.setIsDeleted(tipointerestarjeta.getIsDeletedAuxiliar());	
			tipointerestarjeta.setIsNew(tipointerestarjeta.getIsNewAuxiliar());	
			tipointerestarjeta.setIsChanged(tipointerestarjeta.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipointerestarjeta.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipointerestarjeta.setIsDeletedAuxiliar(false);	
			tipointerestarjeta.setIsNewAuxiliar(false);	
			tipointerestarjeta.setIsChangedAuxiliar(false);
			
			tipointerestarjeta.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoInteresTarjetas(List<TipoInteresTarjeta> tipointerestarjetas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoInteresTarjeta tipointerestarjeta : tipointerestarjetas) {
			if(conAsignarBase && tipointerestarjeta.getConCambioAuxiliar()) {
				tipointerestarjeta.setIsDeleted(tipointerestarjeta.getIsDeletedAuxiliar());	
				tipointerestarjeta.setIsNew(tipointerestarjeta.getIsNewAuxiliar());	
				tipointerestarjeta.setIsChanged(tipointerestarjeta.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipointerestarjeta.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipointerestarjeta.setIsDeletedAuxiliar(false);	
				tipointerestarjeta.setIsNewAuxiliar(false);	
				tipointerestarjeta.setIsChangedAuxiliar(false);
				
				tipointerestarjeta.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoInteresTarjeta(TipoInteresTarjeta tipointerestarjeta,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoInteresTarjetas(List<TipoInteresTarjeta> tipointerestarjetas,Boolean conEnteros) throws Exception  {
		
		for(TipoInteresTarjeta tipointerestarjeta: tipointerestarjetas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoInteresTarjeta(List<TipoInteresTarjeta> tipointerestarjetas,TipoInteresTarjeta tipointerestarjetaAux) throws Exception  {
		TipoInteresTarjetaConstantesFunciones.InicializarValoresTipoInteresTarjeta(tipointerestarjetaAux,true);
		
		for(TipoInteresTarjeta tipointerestarjeta: tipointerestarjetas) {
			if(tipointerestarjeta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoInteresTarjeta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoInteresTarjetaConstantesFunciones.getArrayColumnasGlobalesTipoInteresTarjeta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoInteresTarjeta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoInteresTarjeta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoInteresTarjeta> tipointerestarjetas,TipoInteresTarjeta tipointerestarjeta,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoInteresTarjeta tipointerestarjetaAux: tipointerestarjetas) {
			if(tipointerestarjetaAux!=null && tipointerestarjeta!=null) {
				if((tipointerestarjetaAux.getId()==null && tipointerestarjeta.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipointerestarjetaAux.getId()!=null && tipointerestarjeta.getId()!=null){
					if(tipointerestarjetaAux.getId().equals(tipointerestarjeta.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoInteresTarjeta(List<TipoInteresTarjeta> tipointerestarjetas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoInteresTarjeta tipointerestarjeta: tipointerestarjetas) {			
			if(tipointerestarjeta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoInteresTarjeta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoInteresTarjetaConstantesFunciones.LABEL_ID, TipoInteresTarjetaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoInteresTarjetaConstantesFunciones.LABEL_VERSIONROW, TipoInteresTarjetaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoInteresTarjetaConstantesFunciones.LABEL_NOMBRE, TipoInteresTarjetaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoInteresTarjetaConstantesFunciones.LABEL_DESCRIPCION, TipoInteresTarjetaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoInteresTarjeta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoInteresTarjetaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoInteresTarjetaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoInteresTarjetaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoInteresTarjetaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoInteresTarjeta() throws Exception  {
		return TipoInteresTarjetaConstantesFunciones.getTiposSeleccionarTipoInteresTarjeta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoInteresTarjeta(Boolean conFk) throws Exception  {
		return TipoInteresTarjetaConstantesFunciones.getTiposSeleccionarTipoInteresTarjeta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoInteresTarjeta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoInteresTarjetaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoInteresTarjetaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoInteresTarjetaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoInteresTarjetaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoInteresTarjeta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoInteresTarjeta(TipoInteresTarjeta tipointerestarjetaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoInteresTarjeta(List<TipoInteresTarjeta> tipointerestarjetasTemp) throws Exception {
		for(TipoInteresTarjeta tipointerestarjetaAux:tipointerestarjetasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoInteresTarjeta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoInteresTarjeta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoInteresTarjeta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoInteresTarjetaConstantesFunciones.getClassesRelationshipsOfTipoInteresTarjeta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoInteresTarjeta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoInteresTarjeta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoInteresTarjetaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoInteresTarjeta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoInteresTarjeta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoInteresTarjeta tipointerestarjeta,List<TipoInteresTarjeta> tipointerestarjetas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoInteresTarjeta tipointerestarjetaEncontrado=null;
			
			for(TipoInteresTarjeta tipointerestarjetaLocal:tipointerestarjetas) {
				if(tipointerestarjetaLocal.getId().equals(tipointerestarjeta.getId())) {
					tipointerestarjetaEncontrado=tipointerestarjetaLocal;
					
					tipointerestarjetaLocal.setIsChanged(tipointerestarjeta.getIsChanged());
					tipointerestarjetaLocal.setIsNew(tipointerestarjeta.getIsNew());
					tipointerestarjetaLocal.setIsDeleted(tipointerestarjeta.getIsDeleted());
					
					tipointerestarjetaLocal.setGeneralEntityOriginal(tipointerestarjeta.getGeneralEntityOriginal());
					
					tipointerestarjetaLocal.setId(tipointerestarjeta.getId());	
					tipointerestarjetaLocal.setVersionRow(tipointerestarjeta.getVersionRow());	
					tipointerestarjetaLocal.setnombre(tipointerestarjeta.getnombre());	
					tipointerestarjetaLocal.setdescripcion(tipointerestarjeta.getdescripcion());	
					
					
					tipointerestarjetaLocal.setFormaPagoPuntoVentas(tipointerestarjeta.getFormaPagoPuntoVentas());
					
					existe=true;
					break;
				}
			}
			
			if(!tipointerestarjeta.getIsDeleted()) {
				if(!existe) {
					tipointerestarjetas.add(tipointerestarjeta);
				}
			} else {
				if(tipointerestarjetaEncontrado!=null && permiteQuitar)  {
					tipointerestarjetas.remove(tipointerestarjetaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoInteresTarjeta tipointerestarjeta,List<TipoInteresTarjeta> tipointerestarjetas) throws Exception {
		try	{			
			for(TipoInteresTarjeta tipointerestarjetaLocal:tipointerestarjetas) {
				if(tipointerestarjetaLocal.getId().equals(tipointerestarjeta.getId())) {
					tipointerestarjetaLocal.setIsSelected(tipointerestarjeta.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoInteresTarjeta(List<TipoInteresTarjeta> tipointerestarjetasAux) throws Exception {
		//this.tipointerestarjetasAux=tipointerestarjetasAux;
		
		for(TipoInteresTarjeta tipointerestarjetaAux:tipointerestarjetasAux) {
			if(tipointerestarjetaAux.getIsChanged()) {
				tipointerestarjetaAux.setIsChanged(false);
			}		
			
			if(tipointerestarjetaAux.getIsNew()) {
				tipointerestarjetaAux.setIsNew(false);
			}	
			
			if(tipointerestarjetaAux.getIsDeleted()) {
				tipointerestarjetaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoInteresTarjeta(TipoInteresTarjeta tipointerestarjetaAux) throws Exception {
		//this.tipointerestarjetaAux=tipointerestarjetaAux;
		
			if(tipointerestarjetaAux.getIsChanged()) {
				tipointerestarjetaAux.setIsChanged(false);
			}		
			
			if(tipointerestarjetaAux.getIsNew()) {
				tipointerestarjetaAux.setIsNew(false);
			}	
			
			if(tipointerestarjetaAux.getIsDeleted()) {
				tipointerestarjetaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoInteresTarjeta tipointerestarjetaAsignar,TipoInteresTarjeta tipointerestarjeta) throws Exception {
		tipointerestarjetaAsignar.setId(tipointerestarjeta.getId());	
		tipointerestarjetaAsignar.setVersionRow(tipointerestarjeta.getVersionRow());	
		tipointerestarjetaAsignar.setnombre(tipointerestarjeta.getnombre());	
		tipointerestarjetaAsignar.setdescripcion(tipointerestarjeta.getdescripcion());	
	}
	
	public static void inicializarTipoInteresTarjeta(TipoInteresTarjeta tipointerestarjeta) throws Exception {
		try {
				tipointerestarjeta.setId(0L);	
					
				tipointerestarjeta.setnombre("");	
				tipointerestarjeta.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoInteresTarjeta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoInteresTarjetaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoInteresTarjetaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoInteresTarjeta(String sTipo,Row row,Workbook workbook,TipoInteresTarjeta tipointerestarjeta,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipointerestarjeta.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipointerestarjeta.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoInteresTarjeta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoInteresTarjeta() {
		return this.sFinalQueryTipoInteresTarjeta;
	}
	
	public void setsFinalQueryTipoInteresTarjeta(String sFinalQueryTipoInteresTarjeta) {
		this.sFinalQueryTipoInteresTarjeta= sFinalQueryTipoInteresTarjeta;
	}
	
	public Border resaltarSeleccionarTipoInteresTarjeta=null;
	
	public Border setResaltarSeleccionarTipoInteresTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInteresTarjetaBeanSwingJInternalFrame tipointerestarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipointerestarjetaBeanSwingJInternalFrame.jTtoolBarTipoInteresTarjeta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoInteresTarjeta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoInteresTarjeta() {
		return this.resaltarSeleccionarTipoInteresTarjeta;
	}
	
	public void setResaltarSeleccionarTipoInteresTarjeta(Border borderResaltarSeleccionarTipoInteresTarjeta) {
		this.resaltarSeleccionarTipoInteresTarjeta= borderResaltarSeleccionarTipoInteresTarjeta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoInteresTarjeta=null;
	public Boolean mostraridTipoInteresTarjeta=true;
	public Boolean activaridTipoInteresTarjeta=true;

	public Border resaltarnombreTipoInteresTarjeta=null;
	public Boolean mostrarnombreTipoInteresTarjeta=true;
	public Boolean activarnombreTipoInteresTarjeta=true;

	public Border resaltardescripcionTipoInteresTarjeta=null;
	public Boolean mostrardescripcionTipoInteresTarjeta=true;
	public Boolean activardescripcionTipoInteresTarjeta=true;

	
	

	public Border setResaltaridTipoInteresTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInteresTarjetaBeanSwingJInternalFrame tipointerestarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipointerestarjetaBeanSwingJInternalFrame.jTtoolBarTipoInteresTarjeta.setBorder(borderResaltar);
		
		this.resaltaridTipoInteresTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoInteresTarjeta() {
		return this.resaltaridTipoInteresTarjeta;
	}

	public void setResaltaridTipoInteresTarjeta(Border borderResaltar) {
		this.resaltaridTipoInteresTarjeta= borderResaltar;
	}

	public Boolean getMostraridTipoInteresTarjeta() {
		return this.mostraridTipoInteresTarjeta;
	}

	public void setMostraridTipoInteresTarjeta(Boolean mostraridTipoInteresTarjeta) {
		this.mostraridTipoInteresTarjeta= mostraridTipoInteresTarjeta;
	}

	public Boolean getActivaridTipoInteresTarjeta() {
		return this.activaridTipoInteresTarjeta;
	}

	public void setActivaridTipoInteresTarjeta(Boolean activaridTipoInteresTarjeta) {
		this.activaridTipoInteresTarjeta= activaridTipoInteresTarjeta;
	}

	public Border setResaltarnombreTipoInteresTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInteresTarjetaBeanSwingJInternalFrame tipointerestarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipointerestarjetaBeanSwingJInternalFrame.jTtoolBarTipoInteresTarjeta.setBorder(borderResaltar);
		
		this.resaltarnombreTipoInteresTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoInteresTarjeta() {
		return this.resaltarnombreTipoInteresTarjeta;
	}

	public void setResaltarnombreTipoInteresTarjeta(Border borderResaltar) {
		this.resaltarnombreTipoInteresTarjeta= borderResaltar;
	}

	public Boolean getMostrarnombreTipoInteresTarjeta() {
		return this.mostrarnombreTipoInteresTarjeta;
	}

	public void setMostrarnombreTipoInteresTarjeta(Boolean mostrarnombreTipoInteresTarjeta) {
		this.mostrarnombreTipoInteresTarjeta= mostrarnombreTipoInteresTarjeta;
	}

	public Boolean getActivarnombreTipoInteresTarjeta() {
		return this.activarnombreTipoInteresTarjeta;
	}

	public void setActivarnombreTipoInteresTarjeta(Boolean activarnombreTipoInteresTarjeta) {
		this.activarnombreTipoInteresTarjeta= activarnombreTipoInteresTarjeta;
	}

	public Border setResaltardescripcionTipoInteresTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInteresTarjetaBeanSwingJInternalFrame tipointerestarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipointerestarjetaBeanSwingJInternalFrame.jTtoolBarTipoInteresTarjeta.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoInteresTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoInteresTarjeta() {
		return this.resaltardescripcionTipoInteresTarjeta;
	}

	public void setResaltardescripcionTipoInteresTarjeta(Border borderResaltar) {
		this.resaltardescripcionTipoInteresTarjeta= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoInteresTarjeta() {
		return this.mostrardescripcionTipoInteresTarjeta;
	}

	public void setMostrardescripcionTipoInteresTarjeta(Boolean mostrardescripcionTipoInteresTarjeta) {
		this.mostrardescripcionTipoInteresTarjeta= mostrardescripcionTipoInteresTarjeta;
	}

	public Boolean getActivardescripcionTipoInteresTarjeta() {
		return this.activardescripcionTipoInteresTarjeta;
	}

	public void setActivardescripcionTipoInteresTarjeta(Boolean activardescripcionTipoInteresTarjeta) {
		this.activardescripcionTipoInteresTarjeta= activardescripcionTipoInteresTarjeta;
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
		
		
		this.setMostraridTipoInteresTarjeta(esInicial);
		this.setMostrarnombreTipoInteresTarjeta(esInicial);
		this.setMostrardescripcionTipoInteresTarjeta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoInteresTarjetaConstantesFunciones.ID)) {
				this.setMostraridTipoInteresTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInteresTarjetaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoInteresTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInteresTarjetaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoInteresTarjeta(esAsigna);
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
		
		
		this.setActivaridTipoInteresTarjeta(esInicial);
		this.setActivarnombreTipoInteresTarjeta(esInicial);
		this.setActivardescripcionTipoInteresTarjeta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoInteresTarjetaConstantesFunciones.ID)) {
				this.setActivaridTipoInteresTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInteresTarjetaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoInteresTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInteresTarjetaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoInteresTarjeta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoInteresTarjetaBeanSwingJInternalFrame tipointerestarjetaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoInteresTarjeta(esInicial);
		this.setResaltarnombreTipoInteresTarjeta(esInicial);
		this.setResaltardescripcionTipoInteresTarjeta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoInteresTarjetaConstantesFunciones.ID)) {
				this.setResaltaridTipoInteresTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInteresTarjetaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoInteresTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInteresTarjetaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoInteresTarjeta(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFormaPagoPuntoVentaTipoInteresTarjeta=null;

	public Border getResaltarFormaPagoPuntoVentaTipoInteresTarjeta() {
		return this.resaltarFormaPagoPuntoVentaTipoInteresTarjeta;
	}

	public void setResaltarFormaPagoPuntoVentaTipoInteresTarjeta(Border borderResaltarFormaPagoPuntoVenta) {
		if(borderResaltarFormaPagoPuntoVenta!=null) {
			this.resaltarFormaPagoPuntoVentaTipoInteresTarjeta= borderResaltarFormaPagoPuntoVenta;
		}
	}

	public Border setResaltarFormaPagoPuntoVentaTipoInteresTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInteresTarjetaBeanSwingJInternalFrame tipointerestarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltarFormaPagoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipointerestarjetaBeanSwingJInternalFrame.jTtoolBarTipoInteresTarjeta.setBorder(borderResaltarFormaPagoPuntoVenta);
			
		this.resaltarFormaPagoPuntoVentaTipoInteresTarjeta= borderResaltarFormaPagoPuntoVenta;

		 return borderResaltarFormaPagoPuntoVenta;
	}



	public Boolean mostrarFormaPagoPuntoVentaTipoInteresTarjeta=true;

	public Boolean getMostrarFormaPagoPuntoVentaTipoInteresTarjeta() {
		return this.mostrarFormaPagoPuntoVentaTipoInteresTarjeta;
	}

	public void setMostrarFormaPagoPuntoVentaTipoInteresTarjeta(Boolean visibilidadResaltarFormaPagoPuntoVenta) {
		this.mostrarFormaPagoPuntoVentaTipoInteresTarjeta= visibilidadResaltarFormaPagoPuntoVenta;
	}



	public Boolean activarFormaPagoPuntoVentaTipoInteresTarjeta=true;

	public Boolean gethabilitarResaltarFormaPagoPuntoVentaTipoInteresTarjeta() {
		return this.activarFormaPagoPuntoVentaTipoInteresTarjeta;
	}

	public void setActivarFormaPagoPuntoVentaTipoInteresTarjeta(Boolean habilitarResaltarFormaPagoPuntoVenta) {
		this.activarFormaPagoPuntoVentaTipoInteresTarjeta= habilitarResaltarFormaPagoPuntoVenta;
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

		this.setMostrarFormaPagoPuntoVentaTipoInteresTarjeta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setMostrarFormaPagoPuntoVentaTipoInteresTarjeta(esAsigna);
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

		this.setActivarFormaPagoPuntoVentaTipoInteresTarjeta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setActivarFormaPagoPuntoVentaTipoInteresTarjeta(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoInteresTarjetaBeanSwingJInternalFrame tipointerestarjetaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFormaPagoPuntoVentaTipoInteresTarjeta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setResaltarFormaPagoPuntoVentaTipoInteresTarjeta(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}