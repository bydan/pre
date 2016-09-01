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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.TipoCostoDefinicionConstantesFunciones;
import com.bydan.erp.inventario.util.TipoCostoDefinicionParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoCostoDefinicionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoCostoDefinicionConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoCostoDefinicion";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoCostoDefinicion"+TipoCostoDefinicionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoCostoDefinicionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoCostoDefinicionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoCostoDefinicionConstantesFunciones.SCHEMA+"_"+TipoCostoDefinicionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoCostoDefinicionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoCostoDefinicionConstantesFunciones.SCHEMA+"_"+TipoCostoDefinicionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoCostoDefinicionConstantesFunciones.SCHEMA+"_"+TipoCostoDefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoCostoDefinicionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoCostoDefinicionConstantesFunciones.SCHEMA+"_"+TipoCostoDefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCostoDefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCostoDefinicionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCostoDefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCostoDefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCostoDefinicionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCostoDefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoCostoDefinicionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoCostoDefinicionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoCostoDefinicionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoCostoDefinicionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Costo Definiciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Costo Definicion";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Costo Definicion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoCostoDefinicion";
	public static final String OBJECTNAME="tipocostodefinicion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="tipo_costo_definicion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocostodefinicion from "+TipoCostoDefinicionConstantesFunciones.SPERSISTENCENAME+" tipocostodefinicion";
	public static String QUERYSELECTNATIVE="select "+TipoCostoDefinicionConstantesFunciones.SCHEMA+"."+TipoCostoDefinicionConstantesFunciones.TABLENAME+".id,"+TipoCostoDefinicionConstantesFunciones.SCHEMA+"."+TipoCostoDefinicionConstantesFunciones.TABLENAME+".version_row,"+TipoCostoDefinicionConstantesFunciones.SCHEMA+"."+TipoCostoDefinicionConstantesFunciones.TABLENAME+".codigo,"+TipoCostoDefinicionConstantesFunciones.SCHEMA+"."+TipoCostoDefinicionConstantesFunciones.TABLENAME+".nombre from "+TipoCostoDefinicionConstantesFunciones.SCHEMA+"."+TipoCostoDefinicionConstantesFunciones.TABLENAME;//+" as "+TipoCostoDefinicionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoCostoDefinicionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoCostoDefinicionConstantesFunciones.CODIGO)) {sLabelColumna=TipoCostoDefinicionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoCostoDefinicionConstantesFunciones.NOMBRE)) {sLabelColumna=TipoCostoDefinicionConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoCostoDefinicionDescripcion(TipoCostoDefinicion tipocostodefinicion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocostodefinicion !=null/* && tipocostodefinicion.getId()!=0*/) {
			sDescripcion=tipocostodefinicion.getcodigo();//tipocostodefiniciontipocostodefinicion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoCostoDefinicionDescripcionDetallado(TipoCostoDefinicion tipocostodefinicion) {
		String sDescripcion="";
			
		sDescripcion+=TipoCostoDefinicionConstantesFunciones.ID+"=";
		sDescripcion+=tipocostodefinicion.getId().toString()+",";
		sDescripcion+=TipoCostoDefinicionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocostodefinicion.getVersionRow().toString()+",";
		sDescripcion+=TipoCostoDefinicionConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipocostodefinicion.getcodigo()+",";
		sDescripcion+=TipoCostoDefinicionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocostodefinicion.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoCostoDefinicionDescripcion(TipoCostoDefinicion tipocostodefinicion,String sValor) throws Exception {			
		if(tipocostodefinicion !=null) {
			tipocostodefinicion.setcodigo(sValor);;//tipocostodefiniciontipocostodefinicion.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoCostoDefinicion(TipoCostoDefinicion tipocostodefinicion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocostodefinicion.setcodigo(tipocostodefinicion.getcodigo().trim());
		tipocostodefinicion.setnombre(tipocostodefinicion.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoCostoDefinicions(List<TipoCostoDefinicion> tipocostodefinicions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoCostoDefinicion tipocostodefinicion: tipocostodefinicions) {
			tipocostodefinicion.setcodigo(tipocostodefinicion.getcodigo().trim());
			tipocostodefinicion.setnombre(tipocostodefinicion.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCostoDefinicion(TipoCostoDefinicion tipocostodefinicion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocostodefinicion.getConCambioAuxiliar()) {
			tipocostodefinicion.setIsDeleted(tipocostodefinicion.getIsDeletedAuxiliar());	
			tipocostodefinicion.setIsNew(tipocostodefinicion.getIsNewAuxiliar());	
			tipocostodefinicion.setIsChanged(tipocostodefinicion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocostodefinicion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocostodefinicion.setIsDeletedAuxiliar(false);	
			tipocostodefinicion.setIsNewAuxiliar(false);	
			tipocostodefinicion.setIsChangedAuxiliar(false);
			
			tipocostodefinicion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCostoDefinicions(List<TipoCostoDefinicion> tipocostodefinicions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoCostoDefinicion tipocostodefinicion : tipocostodefinicions) {
			if(conAsignarBase && tipocostodefinicion.getConCambioAuxiliar()) {
				tipocostodefinicion.setIsDeleted(tipocostodefinicion.getIsDeletedAuxiliar());	
				tipocostodefinicion.setIsNew(tipocostodefinicion.getIsNewAuxiliar());	
				tipocostodefinicion.setIsChanged(tipocostodefinicion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocostodefinicion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocostodefinicion.setIsDeletedAuxiliar(false);	
				tipocostodefinicion.setIsNewAuxiliar(false);	
				tipocostodefinicion.setIsChangedAuxiliar(false);
				
				tipocostodefinicion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoCostoDefinicion(TipoCostoDefinicion tipocostodefinicion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoCostoDefinicions(List<TipoCostoDefinicion> tipocostodefinicions,Boolean conEnteros) throws Exception  {
		
		for(TipoCostoDefinicion tipocostodefinicion: tipocostodefinicions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoCostoDefinicion(List<TipoCostoDefinicion> tipocostodefinicions,TipoCostoDefinicion tipocostodefinicionAux) throws Exception  {
		TipoCostoDefinicionConstantesFunciones.InicializarValoresTipoCostoDefinicion(tipocostodefinicionAux,true);
		
		for(TipoCostoDefinicion tipocostodefinicion: tipocostodefinicions) {
			if(tipocostodefinicion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCostoDefinicion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoCostoDefinicionConstantesFunciones.getArrayColumnasGlobalesTipoCostoDefinicion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCostoDefinicion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoCostoDefinicion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoCostoDefinicion> tipocostodefinicions,TipoCostoDefinicion tipocostodefinicion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoCostoDefinicion tipocostodefinicionAux: tipocostodefinicions) {
			if(tipocostodefinicionAux!=null && tipocostodefinicion!=null) {
				if((tipocostodefinicionAux.getId()==null && tipocostodefinicion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocostodefinicionAux.getId()!=null && tipocostodefinicion.getId()!=null){
					if(tipocostodefinicionAux.getId().equals(tipocostodefinicion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoCostoDefinicion(List<TipoCostoDefinicion> tipocostodefinicions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoCostoDefinicion tipocostodefinicion: tipocostodefinicions) {			
			if(tipocostodefinicion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoCostoDefinicion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoCostoDefinicionConstantesFunciones.LABEL_ID, TipoCostoDefinicionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCostoDefinicionConstantesFunciones.LABEL_VERSIONROW, TipoCostoDefinicionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCostoDefinicionConstantesFunciones.LABEL_CODIGO, TipoCostoDefinicionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCostoDefinicionConstantesFunciones.LABEL_NOMBRE, TipoCostoDefinicionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoCostoDefinicion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoCostoDefinicionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCostoDefinicionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCostoDefinicionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCostoDefinicionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCostoDefinicion() throws Exception  {
		return TipoCostoDefinicionConstantesFunciones.getTiposSeleccionarTipoCostoDefinicion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCostoDefinicion(Boolean conFk) throws Exception  {
		return TipoCostoDefinicionConstantesFunciones.getTiposSeleccionarTipoCostoDefinicion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCostoDefinicion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCostoDefinicionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoCostoDefinicionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCostoDefinicionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoCostoDefinicionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoCostoDefinicion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCostoDefinicion(TipoCostoDefinicion tipocostodefinicionAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCostoDefinicion(List<TipoCostoDefinicion> tipocostodefinicionsTemp) throws Exception {
		for(TipoCostoDefinicion tipocostodefinicionAux:tipocostodefinicionsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCostoDefinicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoCostoDefinicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCostoDefinicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCostoDefinicionConstantesFunciones.getClassesRelationshipsOfTipoCostoDefinicion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCostoDefinicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Definicion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Definicion.class)) {
						classes.add(new Classe(Definicion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCostoDefinicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCostoDefinicionConstantesFunciones.getClassesRelationshipsFromStringsOfTipoCostoDefinicion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCostoDefinicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Definicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Definicion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Definicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Definicion.class)); continue;
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
	public static void actualizarLista(TipoCostoDefinicion tipocostodefinicion,List<TipoCostoDefinicion> tipocostodefinicions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoCostoDefinicion tipocostodefinicionEncontrado=null;
			
			for(TipoCostoDefinicion tipocostodefinicionLocal:tipocostodefinicions) {
				if(tipocostodefinicionLocal.getId().equals(tipocostodefinicion.getId())) {
					tipocostodefinicionEncontrado=tipocostodefinicionLocal;
					
					tipocostodefinicionLocal.setIsChanged(tipocostodefinicion.getIsChanged());
					tipocostodefinicionLocal.setIsNew(tipocostodefinicion.getIsNew());
					tipocostodefinicionLocal.setIsDeleted(tipocostodefinicion.getIsDeleted());
					
					tipocostodefinicionLocal.setGeneralEntityOriginal(tipocostodefinicion.getGeneralEntityOriginal());
					
					tipocostodefinicionLocal.setId(tipocostodefinicion.getId());	
					tipocostodefinicionLocal.setVersionRow(tipocostodefinicion.getVersionRow());	
					tipocostodefinicionLocal.setcodigo(tipocostodefinicion.getcodigo());	
					tipocostodefinicionLocal.setnombre(tipocostodefinicion.getnombre());	
					
					
					tipocostodefinicionLocal.setDefinicions(tipocostodefinicion.getDefinicions());
					
					existe=true;
					break;
				}
			}
			
			if(!tipocostodefinicion.getIsDeleted()) {
				if(!existe) {
					tipocostodefinicions.add(tipocostodefinicion);
				}
			} else {
				if(tipocostodefinicionEncontrado!=null && permiteQuitar)  {
					tipocostodefinicions.remove(tipocostodefinicionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoCostoDefinicion tipocostodefinicion,List<TipoCostoDefinicion> tipocostodefinicions) throws Exception {
		try	{			
			for(TipoCostoDefinicion tipocostodefinicionLocal:tipocostodefinicions) {
				if(tipocostodefinicionLocal.getId().equals(tipocostodefinicion.getId())) {
					tipocostodefinicionLocal.setIsSelected(tipocostodefinicion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoCostoDefinicion(List<TipoCostoDefinicion> tipocostodefinicionsAux) throws Exception {
		//this.tipocostodefinicionsAux=tipocostodefinicionsAux;
		
		for(TipoCostoDefinicion tipocostodefinicionAux:tipocostodefinicionsAux) {
			if(tipocostodefinicionAux.getIsChanged()) {
				tipocostodefinicionAux.setIsChanged(false);
			}		
			
			if(tipocostodefinicionAux.getIsNew()) {
				tipocostodefinicionAux.setIsNew(false);
			}	
			
			if(tipocostodefinicionAux.getIsDeleted()) {
				tipocostodefinicionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoCostoDefinicion(TipoCostoDefinicion tipocostodefinicionAux) throws Exception {
		//this.tipocostodefinicionAux=tipocostodefinicionAux;
		
			if(tipocostodefinicionAux.getIsChanged()) {
				tipocostodefinicionAux.setIsChanged(false);
			}		
			
			if(tipocostodefinicionAux.getIsNew()) {
				tipocostodefinicionAux.setIsNew(false);
			}	
			
			if(tipocostodefinicionAux.getIsDeleted()) {
				tipocostodefinicionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoCostoDefinicion tipocostodefinicionAsignar,TipoCostoDefinicion tipocostodefinicion) throws Exception {
		tipocostodefinicionAsignar.setId(tipocostodefinicion.getId());	
		tipocostodefinicionAsignar.setVersionRow(tipocostodefinicion.getVersionRow());	
		tipocostodefinicionAsignar.setcodigo(tipocostodefinicion.getcodigo());	
		tipocostodefinicionAsignar.setnombre(tipocostodefinicion.getnombre());	
	}
	
	public static void inicializarTipoCostoDefinicion(TipoCostoDefinicion tipocostodefinicion) throws Exception {
		try {
				tipocostodefinicion.setId(0L);	
					
				tipocostodefinicion.setcodigo("");	
				tipocostodefinicion.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoCostoDefinicion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCostoDefinicionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCostoDefinicionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoCostoDefinicion(String sTipo,Row row,Workbook workbook,TipoCostoDefinicion tipocostodefinicion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocostodefinicion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocostodefinicion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoCostoDefinicion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoCostoDefinicion() {
		return this.sFinalQueryTipoCostoDefinicion;
	}
	
	public void setsFinalQueryTipoCostoDefinicion(String sFinalQueryTipoCostoDefinicion) {
		this.sFinalQueryTipoCostoDefinicion= sFinalQueryTipoCostoDefinicion;
	}
	
	public Border resaltarSeleccionarTipoCostoDefinicion=null;
	
	public Border setResaltarSeleccionarTipoCostoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCostoDefinicionBeanSwingJInternalFrame tipocostodefinicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocostodefinicionBeanSwingJInternalFrame.jTtoolBarTipoCostoDefinicion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoCostoDefinicion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoCostoDefinicion() {
		return this.resaltarSeleccionarTipoCostoDefinicion;
	}
	
	public void setResaltarSeleccionarTipoCostoDefinicion(Border borderResaltarSeleccionarTipoCostoDefinicion) {
		this.resaltarSeleccionarTipoCostoDefinicion= borderResaltarSeleccionarTipoCostoDefinicion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoCostoDefinicion=null;
	public Boolean mostraridTipoCostoDefinicion=true;
	public Boolean activaridTipoCostoDefinicion=true;

	public Border resaltarcodigoTipoCostoDefinicion=null;
	public Boolean mostrarcodigoTipoCostoDefinicion=true;
	public Boolean activarcodigoTipoCostoDefinicion=true;

	public Border resaltarnombreTipoCostoDefinicion=null;
	public Boolean mostrarnombreTipoCostoDefinicion=true;
	public Boolean activarnombreTipoCostoDefinicion=true;

	
	

	public Border setResaltaridTipoCostoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCostoDefinicionBeanSwingJInternalFrame tipocostodefinicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocostodefinicionBeanSwingJInternalFrame.jTtoolBarTipoCostoDefinicion.setBorder(borderResaltar);
		
		this.resaltaridTipoCostoDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoCostoDefinicion() {
		return this.resaltaridTipoCostoDefinicion;
	}

	public void setResaltaridTipoCostoDefinicion(Border borderResaltar) {
		this.resaltaridTipoCostoDefinicion= borderResaltar;
	}

	public Boolean getMostraridTipoCostoDefinicion() {
		return this.mostraridTipoCostoDefinicion;
	}

	public void setMostraridTipoCostoDefinicion(Boolean mostraridTipoCostoDefinicion) {
		this.mostraridTipoCostoDefinicion= mostraridTipoCostoDefinicion;
	}

	public Boolean getActivaridTipoCostoDefinicion() {
		return this.activaridTipoCostoDefinicion;
	}

	public void setActivaridTipoCostoDefinicion(Boolean activaridTipoCostoDefinicion) {
		this.activaridTipoCostoDefinicion= activaridTipoCostoDefinicion;
	}

	public Border setResaltarcodigoTipoCostoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCostoDefinicionBeanSwingJInternalFrame tipocostodefinicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocostodefinicionBeanSwingJInternalFrame.jTtoolBarTipoCostoDefinicion.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoCostoDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoCostoDefinicion() {
		return this.resaltarcodigoTipoCostoDefinicion;
	}

	public void setResaltarcodigoTipoCostoDefinicion(Border borderResaltar) {
		this.resaltarcodigoTipoCostoDefinicion= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoCostoDefinicion() {
		return this.mostrarcodigoTipoCostoDefinicion;
	}

	public void setMostrarcodigoTipoCostoDefinicion(Boolean mostrarcodigoTipoCostoDefinicion) {
		this.mostrarcodigoTipoCostoDefinicion= mostrarcodigoTipoCostoDefinicion;
	}

	public Boolean getActivarcodigoTipoCostoDefinicion() {
		return this.activarcodigoTipoCostoDefinicion;
	}

	public void setActivarcodigoTipoCostoDefinicion(Boolean activarcodigoTipoCostoDefinicion) {
		this.activarcodigoTipoCostoDefinicion= activarcodigoTipoCostoDefinicion;
	}

	public Border setResaltarnombreTipoCostoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCostoDefinicionBeanSwingJInternalFrame tipocostodefinicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocostodefinicionBeanSwingJInternalFrame.jTtoolBarTipoCostoDefinicion.setBorder(borderResaltar);
		
		this.resaltarnombreTipoCostoDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoCostoDefinicion() {
		return this.resaltarnombreTipoCostoDefinicion;
	}

	public void setResaltarnombreTipoCostoDefinicion(Border borderResaltar) {
		this.resaltarnombreTipoCostoDefinicion= borderResaltar;
	}

	public Boolean getMostrarnombreTipoCostoDefinicion() {
		return this.mostrarnombreTipoCostoDefinicion;
	}

	public void setMostrarnombreTipoCostoDefinicion(Boolean mostrarnombreTipoCostoDefinicion) {
		this.mostrarnombreTipoCostoDefinicion= mostrarnombreTipoCostoDefinicion;
	}

	public Boolean getActivarnombreTipoCostoDefinicion() {
		return this.activarnombreTipoCostoDefinicion;
	}

	public void setActivarnombreTipoCostoDefinicion(Boolean activarnombreTipoCostoDefinicion) {
		this.activarnombreTipoCostoDefinicion= activarnombreTipoCostoDefinicion;
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
		
		
		this.setMostraridTipoCostoDefinicion(esInicial);
		this.setMostrarcodigoTipoCostoDefinicion(esInicial);
		this.setMostrarnombreTipoCostoDefinicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCostoDefinicionConstantesFunciones.ID)) {
				this.setMostraridTipoCostoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCostoDefinicionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoCostoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCostoDefinicionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoCostoDefinicion(esAsigna);
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
		
		
		this.setActivaridTipoCostoDefinicion(esInicial);
		this.setActivarcodigoTipoCostoDefinicion(esInicial);
		this.setActivarnombreTipoCostoDefinicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCostoDefinicionConstantesFunciones.ID)) {
				this.setActivaridTipoCostoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCostoDefinicionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoCostoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCostoDefinicionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoCostoDefinicion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCostoDefinicionBeanSwingJInternalFrame tipocostodefinicionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoCostoDefinicion(esInicial);
		this.setResaltarcodigoTipoCostoDefinicion(esInicial);
		this.setResaltarnombreTipoCostoDefinicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCostoDefinicionConstantesFunciones.ID)) {
				this.setResaltaridTipoCostoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCostoDefinicionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoCostoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCostoDefinicionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoCostoDefinicion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDefinicionTipoCostoDefinicion=null;

	public Border getResaltarDefinicionTipoCostoDefinicion() {
		return this.resaltarDefinicionTipoCostoDefinicion;
	}

	public void setResaltarDefinicionTipoCostoDefinicion(Border borderResaltarDefinicion) {
		if(borderResaltarDefinicion!=null) {
			this.resaltarDefinicionTipoCostoDefinicion= borderResaltarDefinicion;
		}
	}

	public Border setResaltarDefinicionTipoCostoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCostoDefinicionBeanSwingJInternalFrame tipocostodefinicionBeanSwingJInternalFrame*/) {
		Border borderResaltarDefinicion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocostodefinicionBeanSwingJInternalFrame.jTtoolBarTipoCostoDefinicion.setBorder(borderResaltarDefinicion);
			
		this.resaltarDefinicionTipoCostoDefinicion= borderResaltarDefinicion;

		 return borderResaltarDefinicion;
	}



	public Boolean mostrarDefinicionTipoCostoDefinicion=true;

	public Boolean getMostrarDefinicionTipoCostoDefinicion() {
		return this.mostrarDefinicionTipoCostoDefinicion;
	}

	public void setMostrarDefinicionTipoCostoDefinicion(Boolean visibilidadResaltarDefinicion) {
		this.mostrarDefinicionTipoCostoDefinicion= visibilidadResaltarDefinicion;
	}



	public Boolean activarDefinicionTipoCostoDefinicion=true;

	public Boolean gethabilitarResaltarDefinicionTipoCostoDefinicion() {
		return this.activarDefinicionTipoCostoDefinicion;
	}

	public void setActivarDefinicionTipoCostoDefinicion(Boolean habilitarResaltarDefinicion) {
		this.activarDefinicionTipoCostoDefinicion= habilitarResaltarDefinicion;
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

		this.setMostrarDefinicionTipoCostoDefinicion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Definicion.class)) {
				this.setMostrarDefinicionTipoCostoDefinicion(esAsigna);
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

		this.setActivarDefinicionTipoCostoDefinicion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Definicion.class)) {
				this.setActivarDefinicionTipoCostoDefinicion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCostoDefinicionBeanSwingJInternalFrame tipocostodefinicionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDefinicionTipoCostoDefinicion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Definicion.class)) {
				this.setResaltarDefinicionTipoCostoDefinicion(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}