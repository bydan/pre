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


import com.bydan.erp.inventario.util.TipoCostoConstantesFunciones;
import com.bydan.erp.inventario.util.TipoCostoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoCostoParameterGeneral;

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
final public class TipoCostoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoCosto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoCosto"+TipoCostoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoCostoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoCostoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoCostoConstantesFunciones.SCHEMA+"_"+TipoCostoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoCostoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoCostoConstantesFunciones.SCHEMA+"_"+TipoCostoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoCostoConstantesFunciones.SCHEMA+"_"+TipoCostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoCostoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoCostoConstantesFunciones.SCHEMA+"_"+TipoCostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCostoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCostoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCostoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCostoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoCostoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoCostoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoCostoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoCostoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Costos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Costo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Costo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoCosto";
	public static final String OBJECTNAME="tipocosto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="tipo_costo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocosto from "+TipoCostoConstantesFunciones.SPERSISTENCENAME+" tipocosto";
	public static String QUERYSELECTNATIVE="select "+TipoCostoConstantesFunciones.SCHEMA+"."+TipoCostoConstantesFunciones.TABLENAME+".id,"+TipoCostoConstantesFunciones.SCHEMA+"."+TipoCostoConstantesFunciones.TABLENAME+".version_row,"+TipoCostoConstantesFunciones.SCHEMA+"."+TipoCostoConstantesFunciones.TABLENAME+".codigo,"+TipoCostoConstantesFunciones.SCHEMA+"."+TipoCostoConstantesFunciones.TABLENAME+".nombre from "+TipoCostoConstantesFunciones.SCHEMA+"."+TipoCostoConstantesFunciones.TABLENAME;//+" as "+TipoCostoConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoCostoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoCostoConstantesFunciones.CODIGO)) {sLabelColumna=TipoCostoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoCostoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoCostoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoCostoDescripcion(TipoCosto tipocosto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocosto !=null/* && tipocosto.getId()!=0*/) {
			sDescripcion=tipocosto.getcodigo();//tipocostotipocosto.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoCostoDescripcionDetallado(TipoCosto tipocosto) {
		String sDescripcion="";
			
		sDescripcion+=TipoCostoConstantesFunciones.ID+"=";
		sDescripcion+=tipocosto.getId().toString()+",";
		sDescripcion+=TipoCostoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocosto.getVersionRow().toString()+",";
		sDescripcion+=TipoCostoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipocosto.getcodigo()+",";
		sDescripcion+=TipoCostoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocosto.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoCostoDescripcion(TipoCosto tipocosto,String sValor) throws Exception {			
		if(tipocosto !=null) {
			tipocosto.setcodigo(sValor);;//tipocostotipocosto.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoCosto(TipoCosto tipocosto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocosto.setcodigo(tipocosto.getcodigo().trim());
		tipocosto.setnombre(tipocosto.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoCostos(List<TipoCosto> tipocostos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoCosto tipocosto: tipocostos) {
			tipocosto.setcodigo(tipocosto.getcodigo().trim());
			tipocosto.setnombre(tipocosto.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCosto(TipoCosto tipocosto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocosto.getConCambioAuxiliar()) {
			tipocosto.setIsDeleted(tipocosto.getIsDeletedAuxiliar());	
			tipocosto.setIsNew(tipocosto.getIsNewAuxiliar());	
			tipocosto.setIsChanged(tipocosto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocosto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocosto.setIsDeletedAuxiliar(false);	
			tipocosto.setIsNewAuxiliar(false);	
			tipocosto.setIsChangedAuxiliar(false);
			
			tipocosto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCostos(List<TipoCosto> tipocostos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoCosto tipocosto : tipocostos) {
			if(conAsignarBase && tipocosto.getConCambioAuxiliar()) {
				tipocosto.setIsDeleted(tipocosto.getIsDeletedAuxiliar());	
				tipocosto.setIsNew(tipocosto.getIsNewAuxiliar());	
				tipocosto.setIsChanged(tipocosto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocosto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocosto.setIsDeletedAuxiliar(false);	
				tipocosto.setIsNewAuxiliar(false);	
				tipocosto.setIsChangedAuxiliar(false);
				
				tipocosto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoCosto(TipoCosto tipocosto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoCostos(List<TipoCosto> tipocostos,Boolean conEnteros) throws Exception  {
		
		for(TipoCosto tipocosto: tipocostos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoCosto(List<TipoCosto> tipocostos,TipoCosto tipocostoAux) throws Exception  {
		TipoCostoConstantesFunciones.InicializarValoresTipoCosto(tipocostoAux,true);
		
		for(TipoCosto tipocosto: tipocostos) {
			if(tipocosto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCosto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoCostoConstantesFunciones.getArrayColumnasGlobalesTipoCosto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCosto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoCosto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoCosto> tipocostos,TipoCosto tipocosto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoCosto tipocostoAux: tipocostos) {
			if(tipocostoAux!=null && tipocosto!=null) {
				if((tipocostoAux.getId()==null && tipocosto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocostoAux.getId()!=null && tipocosto.getId()!=null){
					if(tipocostoAux.getId().equals(tipocosto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoCosto(List<TipoCosto> tipocostos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoCosto tipocosto: tipocostos) {			
			if(tipocosto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoCosto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoCostoConstantesFunciones.LABEL_ID, TipoCostoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCostoConstantesFunciones.LABEL_VERSIONROW, TipoCostoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCostoConstantesFunciones.LABEL_CODIGO, TipoCostoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCostoConstantesFunciones.LABEL_NOMBRE, TipoCostoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoCosto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoCostoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCostoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCostoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCostoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCosto() throws Exception  {
		return TipoCostoConstantesFunciones.getTiposSeleccionarTipoCosto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCosto(Boolean conFk) throws Exception  {
		return TipoCostoConstantesFunciones.getTiposSeleccionarTipoCosto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCosto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCostoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoCostoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCostoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoCostoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoCosto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCosto(TipoCosto tipocostoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCosto(List<TipoCosto> tipocostosTemp) throws Exception {
		for(TipoCosto tipocostoAux:tipocostosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoCosto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCostoConstantesFunciones.getClassesRelationshipsOfTipoCosto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Costo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Costo.class)) {
						classes.add(new Classe(Costo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCosto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCostoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoCosto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCosto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Costo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Costo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Costo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Costo.class)); continue;
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
	public static void actualizarLista(TipoCosto tipocosto,List<TipoCosto> tipocostos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoCosto tipocostoEncontrado=null;
			
			for(TipoCosto tipocostoLocal:tipocostos) {
				if(tipocostoLocal.getId().equals(tipocosto.getId())) {
					tipocostoEncontrado=tipocostoLocal;
					
					tipocostoLocal.setIsChanged(tipocosto.getIsChanged());
					tipocostoLocal.setIsNew(tipocosto.getIsNew());
					tipocostoLocal.setIsDeleted(tipocosto.getIsDeleted());
					
					tipocostoLocal.setGeneralEntityOriginal(tipocosto.getGeneralEntityOriginal());
					
					tipocostoLocal.setId(tipocosto.getId());	
					tipocostoLocal.setVersionRow(tipocosto.getVersionRow());	
					tipocostoLocal.setcodigo(tipocosto.getcodigo());	
					tipocostoLocal.setnombre(tipocosto.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipocosto.getIsDeleted()) {
				if(!existe) {
					tipocostos.add(tipocosto);
				}
			} else {
				if(tipocostoEncontrado!=null && permiteQuitar)  {
					tipocostos.remove(tipocostoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoCosto tipocosto,List<TipoCosto> tipocostos) throws Exception {
		try	{			
			for(TipoCosto tipocostoLocal:tipocostos) {
				if(tipocostoLocal.getId().equals(tipocosto.getId())) {
					tipocostoLocal.setIsSelected(tipocosto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoCosto(List<TipoCosto> tipocostosAux) throws Exception {
		//this.tipocostosAux=tipocostosAux;
		
		for(TipoCosto tipocostoAux:tipocostosAux) {
			if(tipocostoAux.getIsChanged()) {
				tipocostoAux.setIsChanged(false);
			}		
			
			if(tipocostoAux.getIsNew()) {
				tipocostoAux.setIsNew(false);
			}	
			
			if(tipocostoAux.getIsDeleted()) {
				tipocostoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoCosto(TipoCosto tipocostoAux) throws Exception {
		//this.tipocostoAux=tipocostoAux;
		
			if(tipocostoAux.getIsChanged()) {
				tipocostoAux.setIsChanged(false);
			}		
			
			if(tipocostoAux.getIsNew()) {
				tipocostoAux.setIsNew(false);
			}	
			
			if(tipocostoAux.getIsDeleted()) {
				tipocostoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoCosto tipocostoAsignar,TipoCosto tipocosto) throws Exception {
		tipocostoAsignar.setId(tipocosto.getId());	
		tipocostoAsignar.setVersionRow(tipocosto.getVersionRow());	
		tipocostoAsignar.setcodigo(tipocosto.getcodigo());	
		tipocostoAsignar.setnombre(tipocosto.getnombre());	
	}
	
	public static void inicializarTipoCosto(TipoCosto tipocosto) throws Exception {
		try {
				tipocosto.setId(0L);	
					
				tipocosto.setcodigo("");	
				tipocosto.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoCosto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCostoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCostoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoCosto(String sTipo,Row row,Workbook workbook,TipoCosto tipocosto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocosto.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocosto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoCosto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoCosto() {
		return this.sFinalQueryTipoCosto;
	}
	
	public void setsFinalQueryTipoCosto(String sFinalQueryTipoCosto) {
		this.sFinalQueryTipoCosto= sFinalQueryTipoCosto;
	}
	
	public Border resaltarSeleccionarTipoCosto=null;
	
	public Border setResaltarSeleccionarTipoCosto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCostoBeanSwingJInternalFrame tipocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocostoBeanSwingJInternalFrame.jTtoolBarTipoCosto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoCosto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoCosto() {
		return this.resaltarSeleccionarTipoCosto;
	}
	
	public void setResaltarSeleccionarTipoCosto(Border borderResaltarSeleccionarTipoCosto) {
		this.resaltarSeleccionarTipoCosto= borderResaltarSeleccionarTipoCosto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoCosto=null;
	public Boolean mostraridTipoCosto=true;
	public Boolean activaridTipoCosto=true;

	public Border resaltarcodigoTipoCosto=null;
	public Boolean mostrarcodigoTipoCosto=true;
	public Boolean activarcodigoTipoCosto=true;

	public Border resaltarnombreTipoCosto=null;
	public Boolean mostrarnombreTipoCosto=true;
	public Boolean activarnombreTipoCosto=true;

	
	

	public Border setResaltaridTipoCosto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCostoBeanSwingJInternalFrame tipocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocostoBeanSwingJInternalFrame.jTtoolBarTipoCosto.setBorder(borderResaltar);
		
		this.resaltaridTipoCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoCosto() {
		return this.resaltaridTipoCosto;
	}

	public void setResaltaridTipoCosto(Border borderResaltar) {
		this.resaltaridTipoCosto= borderResaltar;
	}

	public Boolean getMostraridTipoCosto() {
		return this.mostraridTipoCosto;
	}

	public void setMostraridTipoCosto(Boolean mostraridTipoCosto) {
		this.mostraridTipoCosto= mostraridTipoCosto;
	}

	public Boolean getActivaridTipoCosto() {
		return this.activaridTipoCosto;
	}

	public void setActivaridTipoCosto(Boolean activaridTipoCosto) {
		this.activaridTipoCosto= activaridTipoCosto;
	}

	public Border setResaltarcodigoTipoCosto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCostoBeanSwingJInternalFrame tipocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocostoBeanSwingJInternalFrame.jTtoolBarTipoCosto.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoCosto() {
		return this.resaltarcodigoTipoCosto;
	}

	public void setResaltarcodigoTipoCosto(Border borderResaltar) {
		this.resaltarcodigoTipoCosto= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoCosto() {
		return this.mostrarcodigoTipoCosto;
	}

	public void setMostrarcodigoTipoCosto(Boolean mostrarcodigoTipoCosto) {
		this.mostrarcodigoTipoCosto= mostrarcodigoTipoCosto;
	}

	public Boolean getActivarcodigoTipoCosto() {
		return this.activarcodigoTipoCosto;
	}

	public void setActivarcodigoTipoCosto(Boolean activarcodigoTipoCosto) {
		this.activarcodigoTipoCosto= activarcodigoTipoCosto;
	}

	public Border setResaltarnombreTipoCosto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCostoBeanSwingJInternalFrame tipocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocostoBeanSwingJInternalFrame.jTtoolBarTipoCosto.setBorder(borderResaltar);
		
		this.resaltarnombreTipoCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoCosto() {
		return this.resaltarnombreTipoCosto;
	}

	public void setResaltarnombreTipoCosto(Border borderResaltar) {
		this.resaltarnombreTipoCosto= borderResaltar;
	}

	public Boolean getMostrarnombreTipoCosto() {
		return this.mostrarnombreTipoCosto;
	}

	public void setMostrarnombreTipoCosto(Boolean mostrarnombreTipoCosto) {
		this.mostrarnombreTipoCosto= mostrarnombreTipoCosto;
	}

	public Boolean getActivarnombreTipoCosto() {
		return this.activarnombreTipoCosto;
	}

	public void setActivarnombreTipoCosto(Boolean activarnombreTipoCosto) {
		this.activarnombreTipoCosto= activarnombreTipoCosto;
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
		
		
		this.setMostraridTipoCosto(esInicial);
		this.setMostrarcodigoTipoCosto(esInicial);
		this.setMostrarnombreTipoCosto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCostoConstantesFunciones.ID)) {
				this.setMostraridTipoCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCostoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCostoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoCosto(esAsigna);
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
		
		
		this.setActivaridTipoCosto(esInicial);
		this.setActivarcodigoTipoCosto(esInicial);
		this.setActivarnombreTipoCosto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCostoConstantesFunciones.ID)) {
				this.setActivaridTipoCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCostoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCostoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoCosto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCostoBeanSwingJInternalFrame tipocostoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoCosto(esInicial);
		this.setResaltarcodigoTipoCosto(esInicial);
		this.setResaltarnombreTipoCosto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCostoConstantesFunciones.ID)) {
				this.setResaltaridTipoCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCostoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCostoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoCosto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCostoBeanSwingJInternalFrame tipocostoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	
	//CONTROL_FUNCION2
}