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


import com.bydan.erp.puntoventa.util.TipoPagoTarjetaConstantesFunciones;
import com.bydan.erp.puntoventa.util.TipoPagoTarjetaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.TipoPagoTarjetaParameterGeneral;

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
final public class TipoPagoTarjetaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoPagoTarjeta";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoPagoTarjeta"+TipoPagoTarjetaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoPagoTarjetaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoPagoTarjetaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoPagoTarjetaConstantesFunciones.SCHEMA+"_"+TipoPagoTarjetaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoPagoTarjetaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoPagoTarjetaConstantesFunciones.SCHEMA+"_"+TipoPagoTarjetaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoPagoTarjetaConstantesFunciones.SCHEMA+"_"+TipoPagoTarjetaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoPagoTarjetaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoPagoTarjetaConstantesFunciones.SCHEMA+"_"+TipoPagoTarjetaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPagoTarjetaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPagoTarjetaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPagoTarjetaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPagoTarjetaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPagoTarjetaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPagoTarjetaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoPagoTarjetaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoPagoTarjetaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoPagoTarjetaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoPagoTarjetaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Pagos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Pago";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Pago Tarjeta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoPagoTarjeta";
	public static final String OBJECTNAME="tipopagotarjeta";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="tipo_pago_tarjeta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipopagotarjeta from "+TipoPagoTarjetaConstantesFunciones.SPERSISTENCENAME+" tipopagotarjeta";
	public static String QUERYSELECTNATIVE="select "+TipoPagoTarjetaConstantesFunciones.SCHEMA+"."+TipoPagoTarjetaConstantesFunciones.TABLENAME+".id,"+TipoPagoTarjetaConstantesFunciones.SCHEMA+"."+TipoPagoTarjetaConstantesFunciones.TABLENAME+".version_row,"+TipoPagoTarjetaConstantesFunciones.SCHEMA+"."+TipoPagoTarjetaConstantesFunciones.TABLENAME+".nombre,"+TipoPagoTarjetaConstantesFunciones.SCHEMA+"."+TipoPagoTarjetaConstantesFunciones.TABLENAME+".descripcion from "+TipoPagoTarjetaConstantesFunciones.SCHEMA+"."+TipoPagoTarjetaConstantesFunciones.TABLENAME;//+" as "+TipoPagoTarjetaConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoPagoTarjetaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoPagoTarjetaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoPagoTarjetaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoPagoTarjetaConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoPagoTarjetaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoPagoTarjetaDescripcion(TipoPagoTarjeta tipopagotarjeta) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipopagotarjeta !=null/* && tipopagotarjeta.getId()!=0*/) {
			sDescripcion=tipopagotarjeta.getnombre();//tipopagotarjetatipopagotarjeta.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoPagoTarjetaDescripcionDetallado(TipoPagoTarjeta tipopagotarjeta) {
		String sDescripcion="";
			
		sDescripcion+=TipoPagoTarjetaConstantesFunciones.ID+"=";
		sDescripcion+=tipopagotarjeta.getId().toString()+",";
		sDescripcion+=TipoPagoTarjetaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipopagotarjeta.getVersionRow().toString()+",";
		sDescripcion+=TipoPagoTarjetaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipopagotarjeta.getnombre()+",";
		sDescripcion+=TipoPagoTarjetaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tipopagotarjeta.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoPagoTarjetaDescripcion(TipoPagoTarjeta tipopagotarjeta,String sValor) throws Exception {			
		if(tipopagotarjeta !=null) {
			tipopagotarjeta.setnombre(sValor);;//tipopagotarjetatipopagotarjeta.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoPagoTarjeta(TipoPagoTarjeta tipopagotarjeta,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipopagotarjeta.setnombre(tipopagotarjeta.getnombre().trim());
		tipopagotarjeta.setdescripcion(tipopagotarjeta.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoPagoTarjetas(List<TipoPagoTarjeta> tipopagotarjetas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoPagoTarjeta tipopagotarjeta: tipopagotarjetas) {
			tipopagotarjeta.setnombre(tipopagotarjeta.getnombre().trim());
			tipopagotarjeta.setdescripcion(tipopagotarjeta.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoPagoTarjeta(TipoPagoTarjeta tipopagotarjeta,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipopagotarjeta.getConCambioAuxiliar()) {
			tipopagotarjeta.setIsDeleted(tipopagotarjeta.getIsDeletedAuxiliar());	
			tipopagotarjeta.setIsNew(tipopagotarjeta.getIsNewAuxiliar());	
			tipopagotarjeta.setIsChanged(tipopagotarjeta.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipopagotarjeta.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipopagotarjeta.setIsDeletedAuxiliar(false);	
			tipopagotarjeta.setIsNewAuxiliar(false);	
			tipopagotarjeta.setIsChangedAuxiliar(false);
			
			tipopagotarjeta.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoPagoTarjetas(List<TipoPagoTarjeta> tipopagotarjetas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoPagoTarjeta tipopagotarjeta : tipopagotarjetas) {
			if(conAsignarBase && tipopagotarjeta.getConCambioAuxiliar()) {
				tipopagotarjeta.setIsDeleted(tipopagotarjeta.getIsDeletedAuxiliar());	
				tipopagotarjeta.setIsNew(tipopagotarjeta.getIsNewAuxiliar());	
				tipopagotarjeta.setIsChanged(tipopagotarjeta.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipopagotarjeta.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipopagotarjeta.setIsDeletedAuxiliar(false);	
				tipopagotarjeta.setIsNewAuxiliar(false);	
				tipopagotarjeta.setIsChangedAuxiliar(false);
				
				tipopagotarjeta.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoPagoTarjeta(TipoPagoTarjeta tipopagotarjeta,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoPagoTarjetas(List<TipoPagoTarjeta> tipopagotarjetas,Boolean conEnteros) throws Exception  {
		
		for(TipoPagoTarjeta tipopagotarjeta: tipopagotarjetas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoPagoTarjeta(List<TipoPagoTarjeta> tipopagotarjetas,TipoPagoTarjeta tipopagotarjetaAux) throws Exception  {
		TipoPagoTarjetaConstantesFunciones.InicializarValoresTipoPagoTarjeta(tipopagotarjetaAux,true);
		
		for(TipoPagoTarjeta tipopagotarjeta: tipopagotarjetas) {
			if(tipopagotarjeta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPagoTarjeta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoPagoTarjetaConstantesFunciones.getArrayColumnasGlobalesTipoPagoTarjeta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPagoTarjeta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoPagoTarjeta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoPagoTarjeta> tipopagotarjetas,TipoPagoTarjeta tipopagotarjeta,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoPagoTarjeta tipopagotarjetaAux: tipopagotarjetas) {
			if(tipopagotarjetaAux!=null && tipopagotarjeta!=null) {
				if((tipopagotarjetaAux.getId()==null && tipopagotarjeta.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipopagotarjetaAux.getId()!=null && tipopagotarjeta.getId()!=null){
					if(tipopagotarjetaAux.getId().equals(tipopagotarjeta.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoPagoTarjeta(List<TipoPagoTarjeta> tipopagotarjetas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoPagoTarjeta tipopagotarjeta: tipopagotarjetas) {			
			if(tipopagotarjeta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoPagoTarjeta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoPagoTarjetaConstantesFunciones.LABEL_ID, TipoPagoTarjetaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPagoTarjetaConstantesFunciones.LABEL_VERSIONROW, TipoPagoTarjetaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPagoTarjetaConstantesFunciones.LABEL_NOMBRE, TipoPagoTarjetaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPagoTarjetaConstantesFunciones.LABEL_DESCRIPCION, TipoPagoTarjetaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoPagoTarjeta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoPagoTarjetaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPagoTarjetaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPagoTarjetaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPagoTarjetaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPagoTarjeta() throws Exception  {
		return TipoPagoTarjetaConstantesFunciones.getTiposSeleccionarTipoPagoTarjeta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPagoTarjeta(Boolean conFk) throws Exception  {
		return TipoPagoTarjetaConstantesFunciones.getTiposSeleccionarTipoPagoTarjeta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPagoTarjeta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPagoTarjetaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoPagoTarjetaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPagoTarjetaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoPagoTarjetaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoPagoTarjeta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPagoTarjeta(TipoPagoTarjeta tipopagotarjetaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPagoTarjeta(List<TipoPagoTarjeta> tipopagotarjetasTemp) throws Exception {
		for(TipoPagoTarjeta tipopagotarjetaAux:tipopagotarjetasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoPagoTarjeta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoPagoTarjeta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPagoTarjeta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPagoTarjetaConstantesFunciones.getClassesRelationshipsOfTipoPagoTarjeta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPagoTarjeta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPagoTarjeta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPagoTarjetaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoPagoTarjeta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPagoTarjeta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoPagoTarjeta tipopagotarjeta,List<TipoPagoTarjeta> tipopagotarjetas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoPagoTarjeta tipopagotarjetaEncontrado=null;
			
			for(TipoPagoTarjeta tipopagotarjetaLocal:tipopagotarjetas) {
				if(tipopagotarjetaLocal.getId().equals(tipopagotarjeta.getId())) {
					tipopagotarjetaEncontrado=tipopagotarjetaLocal;
					
					tipopagotarjetaLocal.setIsChanged(tipopagotarjeta.getIsChanged());
					tipopagotarjetaLocal.setIsNew(tipopagotarjeta.getIsNew());
					tipopagotarjetaLocal.setIsDeleted(tipopagotarjeta.getIsDeleted());
					
					tipopagotarjetaLocal.setGeneralEntityOriginal(tipopagotarjeta.getGeneralEntityOriginal());
					
					tipopagotarjetaLocal.setId(tipopagotarjeta.getId());	
					tipopagotarjetaLocal.setVersionRow(tipopagotarjeta.getVersionRow());	
					tipopagotarjetaLocal.setnombre(tipopagotarjeta.getnombre());	
					tipopagotarjetaLocal.setdescripcion(tipopagotarjeta.getdescripcion());	
					
					
					tipopagotarjetaLocal.setFormaPagoPuntoVentas(tipopagotarjeta.getFormaPagoPuntoVentas());
					
					existe=true;
					break;
				}
			}
			
			if(!tipopagotarjeta.getIsDeleted()) {
				if(!existe) {
					tipopagotarjetas.add(tipopagotarjeta);
				}
			} else {
				if(tipopagotarjetaEncontrado!=null && permiteQuitar)  {
					tipopagotarjetas.remove(tipopagotarjetaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoPagoTarjeta tipopagotarjeta,List<TipoPagoTarjeta> tipopagotarjetas) throws Exception {
		try	{			
			for(TipoPagoTarjeta tipopagotarjetaLocal:tipopagotarjetas) {
				if(tipopagotarjetaLocal.getId().equals(tipopagotarjeta.getId())) {
					tipopagotarjetaLocal.setIsSelected(tipopagotarjeta.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoPagoTarjeta(List<TipoPagoTarjeta> tipopagotarjetasAux) throws Exception {
		//this.tipopagotarjetasAux=tipopagotarjetasAux;
		
		for(TipoPagoTarjeta tipopagotarjetaAux:tipopagotarjetasAux) {
			if(tipopagotarjetaAux.getIsChanged()) {
				tipopagotarjetaAux.setIsChanged(false);
			}		
			
			if(tipopagotarjetaAux.getIsNew()) {
				tipopagotarjetaAux.setIsNew(false);
			}	
			
			if(tipopagotarjetaAux.getIsDeleted()) {
				tipopagotarjetaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoPagoTarjeta(TipoPagoTarjeta tipopagotarjetaAux) throws Exception {
		//this.tipopagotarjetaAux=tipopagotarjetaAux;
		
			if(tipopagotarjetaAux.getIsChanged()) {
				tipopagotarjetaAux.setIsChanged(false);
			}		
			
			if(tipopagotarjetaAux.getIsNew()) {
				tipopagotarjetaAux.setIsNew(false);
			}	
			
			if(tipopagotarjetaAux.getIsDeleted()) {
				tipopagotarjetaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoPagoTarjeta tipopagotarjetaAsignar,TipoPagoTarjeta tipopagotarjeta) throws Exception {
		tipopagotarjetaAsignar.setId(tipopagotarjeta.getId());	
		tipopagotarjetaAsignar.setVersionRow(tipopagotarjeta.getVersionRow());	
		tipopagotarjetaAsignar.setnombre(tipopagotarjeta.getnombre());	
		tipopagotarjetaAsignar.setdescripcion(tipopagotarjeta.getdescripcion());	
	}
	
	public static void inicializarTipoPagoTarjeta(TipoPagoTarjeta tipopagotarjeta) throws Exception {
		try {
				tipopagotarjeta.setId(0L);	
					
				tipopagotarjeta.setnombre("");	
				tipopagotarjeta.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoPagoTarjeta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPagoTarjetaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPagoTarjetaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoPagoTarjeta(String sTipo,Row row,Workbook workbook,TipoPagoTarjeta tipopagotarjeta,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipopagotarjeta.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipopagotarjeta.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoPagoTarjeta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoPagoTarjeta() {
		return this.sFinalQueryTipoPagoTarjeta;
	}
	
	public void setsFinalQueryTipoPagoTarjeta(String sFinalQueryTipoPagoTarjeta) {
		this.sFinalQueryTipoPagoTarjeta= sFinalQueryTipoPagoTarjeta;
	}
	
	public Border resaltarSeleccionarTipoPagoTarjeta=null;
	
	public Border setResaltarSeleccionarTipoPagoTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPagoTarjetaBeanSwingJInternalFrame tipopagotarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipopagotarjetaBeanSwingJInternalFrame.jTtoolBarTipoPagoTarjeta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoPagoTarjeta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoPagoTarjeta() {
		return this.resaltarSeleccionarTipoPagoTarjeta;
	}
	
	public void setResaltarSeleccionarTipoPagoTarjeta(Border borderResaltarSeleccionarTipoPagoTarjeta) {
		this.resaltarSeleccionarTipoPagoTarjeta= borderResaltarSeleccionarTipoPagoTarjeta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoPagoTarjeta=null;
	public Boolean mostraridTipoPagoTarjeta=true;
	public Boolean activaridTipoPagoTarjeta=true;

	public Border resaltarnombreTipoPagoTarjeta=null;
	public Boolean mostrarnombreTipoPagoTarjeta=true;
	public Boolean activarnombreTipoPagoTarjeta=true;

	public Border resaltardescripcionTipoPagoTarjeta=null;
	public Boolean mostrardescripcionTipoPagoTarjeta=true;
	public Boolean activardescripcionTipoPagoTarjeta=true;

	
	

	public Border setResaltaridTipoPagoTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPagoTarjetaBeanSwingJInternalFrame tipopagotarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipopagotarjetaBeanSwingJInternalFrame.jTtoolBarTipoPagoTarjeta.setBorder(borderResaltar);
		
		this.resaltaridTipoPagoTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoPagoTarjeta() {
		return this.resaltaridTipoPagoTarjeta;
	}

	public void setResaltaridTipoPagoTarjeta(Border borderResaltar) {
		this.resaltaridTipoPagoTarjeta= borderResaltar;
	}

	public Boolean getMostraridTipoPagoTarjeta() {
		return this.mostraridTipoPagoTarjeta;
	}

	public void setMostraridTipoPagoTarjeta(Boolean mostraridTipoPagoTarjeta) {
		this.mostraridTipoPagoTarjeta= mostraridTipoPagoTarjeta;
	}

	public Boolean getActivaridTipoPagoTarjeta() {
		return this.activaridTipoPagoTarjeta;
	}

	public void setActivaridTipoPagoTarjeta(Boolean activaridTipoPagoTarjeta) {
		this.activaridTipoPagoTarjeta= activaridTipoPagoTarjeta;
	}

	public Border setResaltarnombreTipoPagoTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPagoTarjetaBeanSwingJInternalFrame tipopagotarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipopagotarjetaBeanSwingJInternalFrame.jTtoolBarTipoPagoTarjeta.setBorder(borderResaltar);
		
		this.resaltarnombreTipoPagoTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoPagoTarjeta() {
		return this.resaltarnombreTipoPagoTarjeta;
	}

	public void setResaltarnombreTipoPagoTarjeta(Border borderResaltar) {
		this.resaltarnombreTipoPagoTarjeta= borderResaltar;
	}

	public Boolean getMostrarnombreTipoPagoTarjeta() {
		return this.mostrarnombreTipoPagoTarjeta;
	}

	public void setMostrarnombreTipoPagoTarjeta(Boolean mostrarnombreTipoPagoTarjeta) {
		this.mostrarnombreTipoPagoTarjeta= mostrarnombreTipoPagoTarjeta;
	}

	public Boolean getActivarnombreTipoPagoTarjeta() {
		return this.activarnombreTipoPagoTarjeta;
	}

	public void setActivarnombreTipoPagoTarjeta(Boolean activarnombreTipoPagoTarjeta) {
		this.activarnombreTipoPagoTarjeta= activarnombreTipoPagoTarjeta;
	}

	public Border setResaltardescripcionTipoPagoTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPagoTarjetaBeanSwingJInternalFrame tipopagotarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipopagotarjetaBeanSwingJInternalFrame.jTtoolBarTipoPagoTarjeta.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoPagoTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoPagoTarjeta() {
		return this.resaltardescripcionTipoPagoTarjeta;
	}

	public void setResaltardescripcionTipoPagoTarjeta(Border borderResaltar) {
		this.resaltardescripcionTipoPagoTarjeta= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoPagoTarjeta() {
		return this.mostrardescripcionTipoPagoTarjeta;
	}

	public void setMostrardescripcionTipoPagoTarjeta(Boolean mostrardescripcionTipoPagoTarjeta) {
		this.mostrardescripcionTipoPagoTarjeta= mostrardescripcionTipoPagoTarjeta;
	}

	public Boolean getActivardescripcionTipoPagoTarjeta() {
		return this.activardescripcionTipoPagoTarjeta;
	}

	public void setActivardescripcionTipoPagoTarjeta(Boolean activardescripcionTipoPagoTarjeta) {
		this.activardescripcionTipoPagoTarjeta= activardescripcionTipoPagoTarjeta;
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
		
		
		this.setMostraridTipoPagoTarjeta(esInicial);
		this.setMostrarnombreTipoPagoTarjeta(esInicial);
		this.setMostrardescripcionTipoPagoTarjeta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPagoTarjetaConstantesFunciones.ID)) {
				this.setMostraridTipoPagoTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPagoTarjetaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoPagoTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPagoTarjetaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoPagoTarjeta(esAsigna);
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
		
		
		this.setActivaridTipoPagoTarjeta(esInicial);
		this.setActivarnombreTipoPagoTarjeta(esInicial);
		this.setActivardescripcionTipoPagoTarjeta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPagoTarjetaConstantesFunciones.ID)) {
				this.setActivaridTipoPagoTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPagoTarjetaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoPagoTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPagoTarjetaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoPagoTarjeta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoPagoTarjetaBeanSwingJInternalFrame tipopagotarjetaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoPagoTarjeta(esInicial);
		this.setResaltarnombreTipoPagoTarjeta(esInicial);
		this.setResaltardescripcionTipoPagoTarjeta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPagoTarjetaConstantesFunciones.ID)) {
				this.setResaltaridTipoPagoTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPagoTarjetaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoPagoTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPagoTarjetaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoPagoTarjeta(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFormaPagoPuntoVentaTipoPagoTarjeta=null;

	public Border getResaltarFormaPagoPuntoVentaTipoPagoTarjeta() {
		return this.resaltarFormaPagoPuntoVentaTipoPagoTarjeta;
	}

	public void setResaltarFormaPagoPuntoVentaTipoPagoTarjeta(Border borderResaltarFormaPagoPuntoVenta) {
		if(borderResaltarFormaPagoPuntoVenta!=null) {
			this.resaltarFormaPagoPuntoVentaTipoPagoTarjeta= borderResaltarFormaPagoPuntoVenta;
		}
	}

	public Border setResaltarFormaPagoPuntoVentaTipoPagoTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPagoTarjetaBeanSwingJInternalFrame tipopagotarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltarFormaPagoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipopagotarjetaBeanSwingJInternalFrame.jTtoolBarTipoPagoTarjeta.setBorder(borderResaltarFormaPagoPuntoVenta);
			
		this.resaltarFormaPagoPuntoVentaTipoPagoTarjeta= borderResaltarFormaPagoPuntoVenta;

		 return borderResaltarFormaPagoPuntoVenta;
	}



	public Boolean mostrarFormaPagoPuntoVentaTipoPagoTarjeta=true;

	public Boolean getMostrarFormaPagoPuntoVentaTipoPagoTarjeta() {
		return this.mostrarFormaPagoPuntoVentaTipoPagoTarjeta;
	}

	public void setMostrarFormaPagoPuntoVentaTipoPagoTarjeta(Boolean visibilidadResaltarFormaPagoPuntoVenta) {
		this.mostrarFormaPagoPuntoVentaTipoPagoTarjeta= visibilidadResaltarFormaPagoPuntoVenta;
	}



	public Boolean activarFormaPagoPuntoVentaTipoPagoTarjeta=true;

	public Boolean gethabilitarResaltarFormaPagoPuntoVentaTipoPagoTarjeta() {
		return this.activarFormaPagoPuntoVentaTipoPagoTarjeta;
	}

	public void setActivarFormaPagoPuntoVentaTipoPagoTarjeta(Boolean habilitarResaltarFormaPagoPuntoVenta) {
		this.activarFormaPagoPuntoVentaTipoPagoTarjeta= habilitarResaltarFormaPagoPuntoVenta;
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

		this.setMostrarFormaPagoPuntoVentaTipoPagoTarjeta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setMostrarFormaPagoPuntoVentaTipoPagoTarjeta(esAsigna);
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

		this.setActivarFormaPagoPuntoVentaTipoPagoTarjeta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setActivarFormaPagoPuntoVentaTipoPagoTarjeta(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoPagoTarjetaBeanSwingJInternalFrame tipopagotarjetaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFormaPagoPuntoVentaTipoPagoTarjeta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setResaltarFormaPagoPuntoVentaTipoPagoTarjeta(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}