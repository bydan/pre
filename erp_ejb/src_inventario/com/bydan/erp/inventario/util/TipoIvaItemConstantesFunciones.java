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


import com.bydan.erp.inventario.util.TipoIvaItemConstantesFunciones;
import com.bydan.erp.inventario.util.TipoIvaItemParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoIvaItemParameterGeneral;

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
final public class TipoIvaItemConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoIvaItem";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoIvaItem"+TipoIvaItemConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoIvaItemHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoIvaItemHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoIvaItemConstantesFunciones.SCHEMA+"_"+TipoIvaItemConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoIvaItemHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoIvaItemConstantesFunciones.SCHEMA+"_"+TipoIvaItemConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoIvaItemConstantesFunciones.SCHEMA+"_"+TipoIvaItemConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoIvaItemHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoIvaItemConstantesFunciones.SCHEMA+"_"+TipoIvaItemConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoIvaItemConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoIvaItemHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoIvaItemConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoIvaItemConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoIvaItemHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoIvaItemConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoIvaItemConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoIvaItemConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoIvaItemConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoIvaItemConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Iva Itemes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Iva Item";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Iva Item";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoIvaItem";
	public static final String OBJECTNAME="tipoivaitem";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="tipo_iva_item";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoivaitem from "+TipoIvaItemConstantesFunciones.SPERSISTENCENAME+" tipoivaitem";
	public static String QUERYSELECTNATIVE="select "+TipoIvaItemConstantesFunciones.SCHEMA+"."+TipoIvaItemConstantesFunciones.TABLENAME+".id,"+TipoIvaItemConstantesFunciones.SCHEMA+"."+TipoIvaItemConstantesFunciones.TABLENAME+".version_row,"+TipoIvaItemConstantesFunciones.SCHEMA+"."+TipoIvaItemConstantesFunciones.TABLENAME+".codigo,"+TipoIvaItemConstantesFunciones.SCHEMA+"."+TipoIvaItemConstantesFunciones.TABLENAME+".nombre from "+TipoIvaItemConstantesFunciones.SCHEMA+"."+TipoIvaItemConstantesFunciones.TABLENAME;//+" as "+TipoIvaItemConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoIvaItemLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoIvaItemConstantesFunciones.CODIGO)) {sLabelColumna=TipoIvaItemConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoIvaItemConstantesFunciones.NOMBRE)) {sLabelColumna=TipoIvaItemConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoIvaItemDescripcion(TipoIvaItem tipoivaitem) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoivaitem !=null/* && tipoivaitem.getId()!=0*/) {
			sDescripcion=tipoivaitem.getcodigo();//tipoivaitemtipoivaitem.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoIvaItemDescripcionDetallado(TipoIvaItem tipoivaitem) {
		String sDescripcion="";
			
		sDescripcion+=TipoIvaItemConstantesFunciones.ID+"=";
		sDescripcion+=tipoivaitem.getId().toString()+",";
		sDescripcion+=TipoIvaItemConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoivaitem.getVersionRow().toString()+",";
		sDescripcion+=TipoIvaItemConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoivaitem.getcodigo()+",";
		sDescripcion+=TipoIvaItemConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoivaitem.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoIvaItemDescripcion(TipoIvaItem tipoivaitem,String sValor) throws Exception {			
		if(tipoivaitem !=null) {
			tipoivaitem.setcodigo(sValor);;//tipoivaitemtipoivaitem.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoIvaItem(TipoIvaItem tipoivaitem,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoivaitem.setcodigo(tipoivaitem.getcodigo().trim());
		tipoivaitem.setnombre(tipoivaitem.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoIvaItems(List<TipoIvaItem> tipoivaitems,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoIvaItem tipoivaitem: tipoivaitems) {
			tipoivaitem.setcodigo(tipoivaitem.getcodigo().trim());
			tipoivaitem.setnombre(tipoivaitem.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoIvaItem(TipoIvaItem tipoivaitem,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoivaitem.getConCambioAuxiliar()) {
			tipoivaitem.setIsDeleted(tipoivaitem.getIsDeletedAuxiliar());	
			tipoivaitem.setIsNew(tipoivaitem.getIsNewAuxiliar());	
			tipoivaitem.setIsChanged(tipoivaitem.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoivaitem.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoivaitem.setIsDeletedAuxiliar(false);	
			tipoivaitem.setIsNewAuxiliar(false);	
			tipoivaitem.setIsChangedAuxiliar(false);
			
			tipoivaitem.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoIvaItems(List<TipoIvaItem> tipoivaitems,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoIvaItem tipoivaitem : tipoivaitems) {
			if(conAsignarBase && tipoivaitem.getConCambioAuxiliar()) {
				tipoivaitem.setIsDeleted(tipoivaitem.getIsDeletedAuxiliar());	
				tipoivaitem.setIsNew(tipoivaitem.getIsNewAuxiliar());	
				tipoivaitem.setIsChanged(tipoivaitem.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoivaitem.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoivaitem.setIsDeletedAuxiliar(false);	
				tipoivaitem.setIsNewAuxiliar(false);	
				tipoivaitem.setIsChangedAuxiliar(false);
				
				tipoivaitem.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoIvaItem(TipoIvaItem tipoivaitem,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoIvaItems(List<TipoIvaItem> tipoivaitems,Boolean conEnteros) throws Exception  {
		
		for(TipoIvaItem tipoivaitem: tipoivaitems) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoIvaItem(List<TipoIvaItem> tipoivaitems,TipoIvaItem tipoivaitemAux) throws Exception  {
		TipoIvaItemConstantesFunciones.InicializarValoresTipoIvaItem(tipoivaitemAux,true);
		
		for(TipoIvaItem tipoivaitem: tipoivaitems) {
			if(tipoivaitem.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoIvaItem(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoIvaItemConstantesFunciones.getArrayColumnasGlobalesTipoIvaItem(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoIvaItem(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoIvaItem(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoIvaItem> tipoivaitems,TipoIvaItem tipoivaitem,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoIvaItem tipoivaitemAux: tipoivaitems) {
			if(tipoivaitemAux!=null && tipoivaitem!=null) {
				if((tipoivaitemAux.getId()==null && tipoivaitem.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoivaitemAux.getId()!=null && tipoivaitem.getId()!=null){
					if(tipoivaitemAux.getId().equals(tipoivaitem.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoIvaItem(List<TipoIvaItem> tipoivaitems) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoIvaItem tipoivaitem: tipoivaitems) {			
			if(tipoivaitem.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoIvaItem() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoIvaItemConstantesFunciones.LABEL_ID, TipoIvaItemConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoIvaItemConstantesFunciones.LABEL_VERSIONROW, TipoIvaItemConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoIvaItemConstantesFunciones.LABEL_CODIGO, TipoIvaItemConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoIvaItemConstantesFunciones.LABEL_NOMBRE, TipoIvaItemConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoIvaItem() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoIvaItemConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoIvaItemConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoIvaItemConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoIvaItemConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoIvaItem() throws Exception  {
		return TipoIvaItemConstantesFunciones.getTiposSeleccionarTipoIvaItem(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoIvaItem(Boolean conFk) throws Exception  {
		return TipoIvaItemConstantesFunciones.getTiposSeleccionarTipoIvaItem(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoIvaItem(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoIvaItemConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoIvaItemConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoIvaItemConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoIvaItemConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoIvaItem(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoIvaItem(TipoIvaItem tipoivaitemAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoIvaItem(List<TipoIvaItem> tipoivaitemsTemp) throws Exception {
		for(TipoIvaItem tipoivaitemAux:tipoivaitemsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoIvaItem(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoIvaItem(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoIvaItem(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoIvaItemConstantesFunciones.getClassesRelationshipsOfTipoIvaItem(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoIvaItem(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoIvaItem(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoIvaItemConstantesFunciones.getClassesRelationshipsFromStringsOfTipoIvaItem(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoIvaItem(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoIvaItem tipoivaitem,List<TipoIvaItem> tipoivaitems,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoIvaItem tipoivaitemEncontrado=null;
			
			for(TipoIvaItem tipoivaitemLocal:tipoivaitems) {
				if(tipoivaitemLocal.getId().equals(tipoivaitem.getId())) {
					tipoivaitemEncontrado=tipoivaitemLocal;
					
					tipoivaitemLocal.setIsChanged(tipoivaitem.getIsChanged());
					tipoivaitemLocal.setIsNew(tipoivaitem.getIsNew());
					tipoivaitemLocal.setIsDeleted(tipoivaitem.getIsDeleted());
					
					tipoivaitemLocal.setGeneralEntityOriginal(tipoivaitem.getGeneralEntityOriginal());
					
					tipoivaitemLocal.setId(tipoivaitem.getId());	
					tipoivaitemLocal.setVersionRow(tipoivaitem.getVersionRow());	
					tipoivaitemLocal.setcodigo(tipoivaitem.getcodigo());	
					tipoivaitemLocal.setnombre(tipoivaitem.getnombre());	
					
					
					tipoivaitemLocal.setDefinicions(tipoivaitem.getDefinicions());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoivaitem.getIsDeleted()) {
				if(!existe) {
					tipoivaitems.add(tipoivaitem);
				}
			} else {
				if(tipoivaitemEncontrado!=null && permiteQuitar)  {
					tipoivaitems.remove(tipoivaitemEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoIvaItem tipoivaitem,List<TipoIvaItem> tipoivaitems) throws Exception {
		try	{			
			for(TipoIvaItem tipoivaitemLocal:tipoivaitems) {
				if(tipoivaitemLocal.getId().equals(tipoivaitem.getId())) {
					tipoivaitemLocal.setIsSelected(tipoivaitem.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoIvaItem(List<TipoIvaItem> tipoivaitemsAux) throws Exception {
		//this.tipoivaitemsAux=tipoivaitemsAux;
		
		for(TipoIvaItem tipoivaitemAux:tipoivaitemsAux) {
			if(tipoivaitemAux.getIsChanged()) {
				tipoivaitemAux.setIsChanged(false);
			}		
			
			if(tipoivaitemAux.getIsNew()) {
				tipoivaitemAux.setIsNew(false);
			}	
			
			if(tipoivaitemAux.getIsDeleted()) {
				tipoivaitemAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoIvaItem(TipoIvaItem tipoivaitemAux) throws Exception {
		//this.tipoivaitemAux=tipoivaitemAux;
		
			if(tipoivaitemAux.getIsChanged()) {
				tipoivaitemAux.setIsChanged(false);
			}		
			
			if(tipoivaitemAux.getIsNew()) {
				tipoivaitemAux.setIsNew(false);
			}	
			
			if(tipoivaitemAux.getIsDeleted()) {
				tipoivaitemAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoIvaItem tipoivaitemAsignar,TipoIvaItem tipoivaitem) throws Exception {
		tipoivaitemAsignar.setId(tipoivaitem.getId());	
		tipoivaitemAsignar.setVersionRow(tipoivaitem.getVersionRow());	
		tipoivaitemAsignar.setcodigo(tipoivaitem.getcodigo());	
		tipoivaitemAsignar.setnombre(tipoivaitem.getnombre());	
	}
	
	public static void inicializarTipoIvaItem(TipoIvaItem tipoivaitem) throws Exception {
		try {
				tipoivaitem.setId(0L);	
					
				tipoivaitem.setcodigo("");	
				tipoivaitem.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoIvaItem(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoIvaItemConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoIvaItemConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoIvaItem(String sTipo,Row row,Workbook workbook,TipoIvaItem tipoivaitem,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoivaitem.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoivaitem.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoIvaItem=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoIvaItem() {
		return this.sFinalQueryTipoIvaItem;
	}
	
	public void setsFinalQueryTipoIvaItem(String sFinalQueryTipoIvaItem) {
		this.sFinalQueryTipoIvaItem= sFinalQueryTipoIvaItem;
	}
	
	public Border resaltarSeleccionarTipoIvaItem=null;
	
	public Border setResaltarSeleccionarTipoIvaItem(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIvaItemBeanSwingJInternalFrame tipoivaitemBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoivaitemBeanSwingJInternalFrame.jTtoolBarTipoIvaItem.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoIvaItem= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoIvaItem() {
		return this.resaltarSeleccionarTipoIvaItem;
	}
	
	public void setResaltarSeleccionarTipoIvaItem(Border borderResaltarSeleccionarTipoIvaItem) {
		this.resaltarSeleccionarTipoIvaItem= borderResaltarSeleccionarTipoIvaItem;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoIvaItem=null;
	public Boolean mostraridTipoIvaItem=true;
	public Boolean activaridTipoIvaItem=true;

	public Border resaltarcodigoTipoIvaItem=null;
	public Boolean mostrarcodigoTipoIvaItem=true;
	public Boolean activarcodigoTipoIvaItem=true;

	public Border resaltarnombreTipoIvaItem=null;
	public Boolean mostrarnombreTipoIvaItem=true;
	public Boolean activarnombreTipoIvaItem=true;

	
	

	public Border setResaltaridTipoIvaItem(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIvaItemBeanSwingJInternalFrame tipoivaitemBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoivaitemBeanSwingJInternalFrame.jTtoolBarTipoIvaItem.setBorder(borderResaltar);
		
		this.resaltaridTipoIvaItem= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoIvaItem() {
		return this.resaltaridTipoIvaItem;
	}

	public void setResaltaridTipoIvaItem(Border borderResaltar) {
		this.resaltaridTipoIvaItem= borderResaltar;
	}

	public Boolean getMostraridTipoIvaItem() {
		return this.mostraridTipoIvaItem;
	}

	public void setMostraridTipoIvaItem(Boolean mostraridTipoIvaItem) {
		this.mostraridTipoIvaItem= mostraridTipoIvaItem;
	}

	public Boolean getActivaridTipoIvaItem() {
		return this.activaridTipoIvaItem;
	}

	public void setActivaridTipoIvaItem(Boolean activaridTipoIvaItem) {
		this.activaridTipoIvaItem= activaridTipoIvaItem;
	}

	public Border setResaltarcodigoTipoIvaItem(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIvaItemBeanSwingJInternalFrame tipoivaitemBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoivaitemBeanSwingJInternalFrame.jTtoolBarTipoIvaItem.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoIvaItem= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoIvaItem() {
		return this.resaltarcodigoTipoIvaItem;
	}

	public void setResaltarcodigoTipoIvaItem(Border borderResaltar) {
		this.resaltarcodigoTipoIvaItem= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoIvaItem() {
		return this.mostrarcodigoTipoIvaItem;
	}

	public void setMostrarcodigoTipoIvaItem(Boolean mostrarcodigoTipoIvaItem) {
		this.mostrarcodigoTipoIvaItem= mostrarcodigoTipoIvaItem;
	}

	public Boolean getActivarcodigoTipoIvaItem() {
		return this.activarcodigoTipoIvaItem;
	}

	public void setActivarcodigoTipoIvaItem(Boolean activarcodigoTipoIvaItem) {
		this.activarcodigoTipoIvaItem= activarcodigoTipoIvaItem;
	}

	public Border setResaltarnombreTipoIvaItem(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIvaItemBeanSwingJInternalFrame tipoivaitemBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoivaitemBeanSwingJInternalFrame.jTtoolBarTipoIvaItem.setBorder(borderResaltar);
		
		this.resaltarnombreTipoIvaItem= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoIvaItem() {
		return this.resaltarnombreTipoIvaItem;
	}

	public void setResaltarnombreTipoIvaItem(Border borderResaltar) {
		this.resaltarnombreTipoIvaItem= borderResaltar;
	}

	public Boolean getMostrarnombreTipoIvaItem() {
		return this.mostrarnombreTipoIvaItem;
	}

	public void setMostrarnombreTipoIvaItem(Boolean mostrarnombreTipoIvaItem) {
		this.mostrarnombreTipoIvaItem= mostrarnombreTipoIvaItem;
	}

	public Boolean getActivarnombreTipoIvaItem() {
		return this.activarnombreTipoIvaItem;
	}

	public void setActivarnombreTipoIvaItem(Boolean activarnombreTipoIvaItem) {
		this.activarnombreTipoIvaItem= activarnombreTipoIvaItem;
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
		
		
		this.setMostraridTipoIvaItem(esInicial);
		this.setMostrarcodigoTipoIvaItem(esInicial);
		this.setMostrarnombreTipoIvaItem(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoIvaItemConstantesFunciones.ID)) {
				this.setMostraridTipoIvaItem(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIvaItemConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoIvaItem(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIvaItemConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoIvaItem(esAsigna);
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
		
		
		this.setActivaridTipoIvaItem(esInicial);
		this.setActivarcodigoTipoIvaItem(esInicial);
		this.setActivarnombreTipoIvaItem(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoIvaItemConstantesFunciones.ID)) {
				this.setActivaridTipoIvaItem(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIvaItemConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoIvaItem(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIvaItemConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoIvaItem(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoIvaItemBeanSwingJInternalFrame tipoivaitemBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoIvaItem(esInicial);
		this.setResaltarcodigoTipoIvaItem(esInicial);
		this.setResaltarnombreTipoIvaItem(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoIvaItemConstantesFunciones.ID)) {
				this.setResaltaridTipoIvaItem(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIvaItemConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoIvaItem(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIvaItemConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoIvaItem(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDefinicionTipoIvaItem=null;

	public Border getResaltarDefinicionTipoIvaItem() {
		return this.resaltarDefinicionTipoIvaItem;
	}

	public void setResaltarDefinicionTipoIvaItem(Border borderResaltarDefinicion) {
		if(borderResaltarDefinicion!=null) {
			this.resaltarDefinicionTipoIvaItem= borderResaltarDefinicion;
		}
	}

	public Border setResaltarDefinicionTipoIvaItem(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIvaItemBeanSwingJInternalFrame tipoivaitemBeanSwingJInternalFrame*/) {
		Border borderResaltarDefinicion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoivaitemBeanSwingJInternalFrame.jTtoolBarTipoIvaItem.setBorder(borderResaltarDefinicion);
			
		this.resaltarDefinicionTipoIvaItem= borderResaltarDefinicion;

		 return borderResaltarDefinicion;
	}



	public Boolean mostrarDefinicionTipoIvaItem=true;

	public Boolean getMostrarDefinicionTipoIvaItem() {
		return this.mostrarDefinicionTipoIvaItem;
	}

	public void setMostrarDefinicionTipoIvaItem(Boolean visibilidadResaltarDefinicion) {
		this.mostrarDefinicionTipoIvaItem= visibilidadResaltarDefinicion;
	}



	public Boolean activarDefinicionTipoIvaItem=true;

	public Boolean gethabilitarResaltarDefinicionTipoIvaItem() {
		return this.activarDefinicionTipoIvaItem;
	}

	public void setActivarDefinicionTipoIvaItem(Boolean habilitarResaltarDefinicion) {
		this.activarDefinicionTipoIvaItem= habilitarResaltarDefinicion;
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

		this.setMostrarDefinicionTipoIvaItem(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Definicion.class)) {
				this.setMostrarDefinicionTipoIvaItem(esAsigna);
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

		this.setActivarDefinicionTipoIvaItem(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Definicion.class)) {
				this.setActivarDefinicionTipoIvaItem(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoIvaItemBeanSwingJInternalFrame tipoivaitemBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDefinicionTipoIvaItem(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Definicion.class)) {
				this.setResaltarDefinicionTipoIvaItem(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}