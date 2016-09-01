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
package com.bydan.erp.seguridad.util;

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


import com.bydan.erp.seguridad.util.TipoImagenPersonaConstantesFunciones;
import com.bydan.erp.seguridad.util.TipoImagenPersonaParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.TipoImagenPersonaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;



import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoImagenPersonaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoImagenPersona";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoImagenPersona"+TipoImagenPersonaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoImagenPersonaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoImagenPersonaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoImagenPersonaConstantesFunciones.SCHEMA+"_"+TipoImagenPersonaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoImagenPersonaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoImagenPersonaConstantesFunciones.SCHEMA+"_"+TipoImagenPersonaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoImagenPersonaConstantesFunciones.SCHEMA+"_"+TipoImagenPersonaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoImagenPersonaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoImagenPersonaConstantesFunciones.SCHEMA+"_"+TipoImagenPersonaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoImagenPersonaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoImagenPersonaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoImagenPersonaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoImagenPersonaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoImagenPersonaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoImagenPersonaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoImagenPersonaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoImagenPersonaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoImagenPersonaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoImagenPersonaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Imagen Personas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Imagen Persona";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Imagen Persona";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoImagenPersona";
	public static final String OBJECTNAME="tipoimagenpersona";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="tipo_imagen_persona";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoimagenpersona from "+TipoImagenPersonaConstantesFunciones.SPERSISTENCENAME+" tipoimagenpersona";
	public static String QUERYSELECTNATIVE="select "+TipoImagenPersonaConstantesFunciones.SCHEMA+"."+TipoImagenPersonaConstantesFunciones.TABLENAME+".id,"+TipoImagenPersonaConstantesFunciones.SCHEMA+"."+TipoImagenPersonaConstantesFunciones.TABLENAME+".version_row,"+TipoImagenPersonaConstantesFunciones.SCHEMA+"."+TipoImagenPersonaConstantesFunciones.TABLENAME+".codigo,"+TipoImagenPersonaConstantesFunciones.SCHEMA+"."+TipoImagenPersonaConstantesFunciones.TABLENAME+".nombre from "+TipoImagenPersonaConstantesFunciones.SCHEMA+"."+TipoImagenPersonaConstantesFunciones.TABLENAME;//+" as "+TipoImagenPersonaConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoImagenPersonaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoImagenPersonaConstantesFunciones.CODIGO)) {sLabelColumna=TipoImagenPersonaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoImagenPersonaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoImagenPersonaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoImagenPersonaDescripcion(TipoImagenPersona tipoimagenpersona) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoimagenpersona !=null/* && tipoimagenpersona.getId()!=0*/) {
			sDescripcion=tipoimagenpersona.getcodigo();//tipoimagenpersonatipoimagenpersona.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoImagenPersonaDescripcionDetallado(TipoImagenPersona tipoimagenpersona) {
		String sDescripcion="";
			
		sDescripcion+=TipoImagenPersonaConstantesFunciones.ID+"=";
		sDescripcion+=tipoimagenpersona.getId().toString()+",";
		sDescripcion+=TipoImagenPersonaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoimagenpersona.getVersionRow().toString()+",";
		sDescripcion+=TipoImagenPersonaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoimagenpersona.getcodigo()+",";
		sDescripcion+=TipoImagenPersonaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoimagenpersona.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoImagenPersonaDescripcion(TipoImagenPersona tipoimagenpersona,String sValor) throws Exception {			
		if(tipoimagenpersona !=null) {
			tipoimagenpersona.setcodigo(sValor);;//tipoimagenpersonatipoimagenpersona.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoImagenPersona(TipoImagenPersona tipoimagenpersona,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoimagenpersona.setcodigo(tipoimagenpersona.getcodigo().trim());
		tipoimagenpersona.setnombre(tipoimagenpersona.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoImagenPersonas(List<TipoImagenPersona> tipoimagenpersonas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoImagenPersona tipoimagenpersona: tipoimagenpersonas) {
			tipoimagenpersona.setcodigo(tipoimagenpersona.getcodigo().trim());
			tipoimagenpersona.setnombre(tipoimagenpersona.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoImagenPersona(TipoImagenPersona tipoimagenpersona,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoimagenpersona.getConCambioAuxiliar()) {
			tipoimagenpersona.setIsDeleted(tipoimagenpersona.getIsDeletedAuxiliar());	
			tipoimagenpersona.setIsNew(tipoimagenpersona.getIsNewAuxiliar());	
			tipoimagenpersona.setIsChanged(tipoimagenpersona.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoimagenpersona.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoimagenpersona.setIsDeletedAuxiliar(false);	
			tipoimagenpersona.setIsNewAuxiliar(false);	
			tipoimagenpersona.setIsChangedAuxiliar(false);
			
			tipoimagenpersona.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoImagenPersonas(List<TipoImagenPersona> tipoimagenpersonas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoImagenPersona tipoimagenpersona : tipoimagenpersonas) {
			if(conAsignarBase && tipoimagenpersona.getConCambioAuxiliar()) {
				tipoimagenpersona.setIsDeleted(tipoimagenpersona.getIsDeletedAuxiliar());	
				tipoimagenpersona.setIsNew(tipoimagenpersona.getIsNewAuxiliar());	
				tipoimagenpersona.setIsChanged(tipoimagenpersona.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoimagenpersona.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoimagenpersona.setIsDeletedAuxiliar(false);	
				tipoimagenpersona.setIsNewAuxiliar(false);	
				tipoimagenpersona.setIsChangedAuxiliar(false);
				
				tipoimagenpersona.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoImagenPersona(TipoImagenPersona tipoimagenpersona,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoImagenPersonas(List<TipoImagenPersona> tipoimagenpersonas,Boolean conEnteros) throws Exception  {
		
		for(TipoImagenPersona tipoimagenpersona: tipoimagenpersonas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoImagenPersona(List<TipoImagenPersona> tipoimagenpersonas,TipoImagenPersona tipoimagenpersonaAux) throws Exception  {
		TipoImagenPersonaConstantesFunciones.InicializarValoresTipoImagenPersona(tipoimagenpersonaAux,true);
		
		for(TipoImagenPersona tipoimagenpersona: tipoimagenpersonas) {
			if(tipoimagenpersona.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoImagenPersona(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoImagenPersonaConstantesFunciones.getArrayColumnasGlobalesTipoImagenPersona(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoImagenPersona(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoImagenPersona(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoImagenPersona> tipoimagenpersonas,TipoImagenPersona tipoimagenpersona,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoImagenPersona tipoimagenpersonaAux: tipoimagenpersonas) {
			if(tipoimagenpersonaAux!=null && tipoimagenpersona!=null) {
				if((tipoimagenpersonaAux.getId()==null && tipoimagenpersona.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoimagenpersonaAux.getId()!=null && tipoimagenpersona.getId()!=null){
					if(tipoimagenpersonaAux.getId().equals(tipoimagenpersona.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoImagenPersona(List<TipoImagenPersona> tipoimagenpersonas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoImagenPersona tipoimagenpersona: tipoimagenpersonas) {			
			if(tipoimagenpersona.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoImagenPersona() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoImagenPersonaConstantesFunciones.LABEL_ID, TipoImagenPersonaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoImagenPersonaConstantesFunciones.LABEL_VERSIONROW, TipoImagenPersonaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoImagenPersonaConstantesFunciones.LABEL_CODIGO, TipoImagenPersonaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoImagenPersonaConstantesFunciones.LABEL_NOMBRE, TipoImagenPersonaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoImagenPersona() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoImagenPersonaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoImagenPersonaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoImagenPersonaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoImagenPersonaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoImagenPersona() throws Exception  {
		return TipoImagenPersonaConstantesFunciones.getTiposSeleccionarTipoImagenPersona(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoImagenPersona(Boolean conFk) throws Exception  {
		return TipoImagenPersonaConstantesFunciones.getTiposSeleccionarTipoImagenPersona(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoImagenPersona(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoImagenPersonaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoImagenPersonaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoImagenPersonaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoImagenPersonaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoImagenPersona(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoImagenPersona(TipoImagenPersona tipoimagenpersonaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoImagenPersona(List<TipoImagenPersona> tipoimagenpersonasTemp) throws Exception {
		for(TipoImagenPersona tipoimagenpersonaAux:tipoimagenpersonasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoImagenPersona(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoImagenPersona(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoImagenPersona(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoImagenPersonaConstantesFunciones.getClassesRelationshipsOfTipoImagenPersona(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoImagenPersona(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoImagenPersona(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoImagenPersonaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoImagenPersona(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoImagenPersona(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(TipoImagenPersona tipoimagenpersona,List<TipoImagenPersona> tipoimagenpersonas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoImagenPersona tipoimagenpersonaEncontrado=null;
			
			for(TipoImagenPersona tipoimagenpersonaLocal:tipoimagenpersonas) {
				if(tipoimagenpersonaLocal.getId().equals(tipoimagenpersona.getId())) {
					tipoimagenpersonaEncontrado=tipoimagenpersonaLocal;
					
					tipoimagenpersonaLocal.setIsChanged(tipoimagenpersona.getIsChanged());
					tipoimagenpersonaLocal.setIsNew(tipoimagenpersona.getIsNew());
					tipoimagenpersonaLocal.setIsDeleted(tipoimagenpersona.getIsDeleted());
					
					tipoimagenpersonaLocal.setGeneralEntityOriginal(tipoimagenpersona.getGeneralEntityOriginal());
					
					tipoimagenpersonaLocal.setId(tipoimagenpersona.getId());	
					tipoimagenpersonaLocal.setVersionRow(tipoimagenpersona.getVersionRow());	
					tipoimagenpersonaLocal.setcodigo(tipoimagenpersona.getcodigo());	
					tipoimagenpersonaLocal.setnombre(tipoimagenpersona.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoimagenpersona.getIsDeleted()) {
				if(!existe) {
					tipoimagenpersonas.add(tipoimagenpersona);
				}
			} else {
				if(tipoimagenpersonaEncontrado!=null && permiteQuitar)  {
					tipoimagenpersonas.remove(tipoimagenpersonaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoImagenPersona tipoimagenpersona,List<TipoImagenPersona> tipoimagenpersonas) throws Exception {
		try	{			
			for(TipoImagenPersona tipoimagenpersonaLocal:tipoimagenpersonas) {
				if(tipoimagenpersonaLocal.getId().equals(tipoimagenpersona.getId())) {
					tipoimagenpersonaLocal.setIsSelected(tipoimagenpersona.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoImagenPersona(List<TipoImagenPersona> tipoimagenpersonasAux) throws Exception {
		//this.tipoimagenpersonasAux=tipoimagenpersonasAux;
		
		for(TipoImagenPersona tipoimagenpersonaAux:tipoimagenpersonasAux) {
			if(tipoimagenpersonaAux.getIsChanged()) {
				tipoimagenpersonaAux.setIsChanged(false);
			}		
			
			if(tipoimagenpersonaAux.getIsNew()) {
				tipoimagenpersonaAux.setIsNew(false);
			}	
			
			if(tipoimagenpersonaAux.getIsDeleted()) {
				tipoimagenpersonaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoImagenPersona(TipoImagenPersona tipoimagenpersonaAux) throws Exception {
		//this.tipoimagenpersonaAux=tipoimagenpersonaAux;
		
			if(tipoimagenpersonaAux.getIsChanged()) {
				tipoimagenpersonaAux.setIsChanged(false);
			}		
			
			if(tipoimagenpersonaAux.getIsNew()) {
				tipoimagenpersonaAux.setIsNew(false);
			}	
			
			if(tipoimagenpersonaAux.getIsDeleted()) {
				tipoimagenpersonaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoImagenPersona tipoimagenpersonaAsignar,TipoImagenPersona tipoimagenpersona) throws Exception {
		tipoimagenpersonaAsignar.setId(tipoimagenpersona.getId());	
		tipoimagenpersonaAsignar.setVersionRow(tipoimagenpersona.getVersionRow());	
		tipoimagenpersonaAsignar.setcodigo(tipoimagenpersona.getcodigo());	
		tipoimagenpersonaAsignar.setnombre(tipoimagenpersona.getnombre());	
	}
	
	public static void inicializarTipoImagenPersona(TipoImagenPersona tipoimagenpersona) throws Exception {
		try {
				tipoimagenpersona.setId(0L);	
					
				tipoimagenpersona.setcodigo("");	
				tipoimagenpersona.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoImagenPersona(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoImagenPersonaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoImagenPersonaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoImagenPersona(String sTipo,Row row,Workbook workbook,TipoImagenPersona tipoimagenpersona,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoimagenpersona.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoimagenpersona.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoImagenPersona=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoImagenPersona() {
		return this.sFinalQueryTipoImagenPersona;
	}
	
	public void setsFinalQueryTipoImagenPersona(String sFinalQueryTipoImagenPersona) {
		this.sFinalQueryTipoImagenPersona= sFinalQueryTipoImagenPersona;
	}
	
	public Border resaltarSeleccionarTipoImagenPersona=null;
	
	public Border setResaltarSeleccionarTipoImagenPersona(ParametroGeneralUsuario parametroGeneralUsuario/*TipoImagenPersonaBeanSwingJInternalFrame tipoimagenpersonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoimagenpersonaBeanSwingJInternalFrame.jTtoolBarTipoImagenPersona.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoImagenPersona= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoImagenPersona() {
		return this.resaltarSeleccionarTipoImagenPersona;
	}
	
	public void setResaltarSeleccionarTipoImagenPersona(Border borderResaltarSeleccionarTipoImagenPersona) {
		this.resaltarSeleccionarTipoImagenPersona= borderResaltarSeleccionarTipoImagenPersona;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoImagenPersona=null;
	public Boolean mostraridTipoImagenPersona=true;
	public Boolean activaridTipoImagenPersona=true;

	public Border resaltarcodigoTipoImagenPersona=null;
	public Boolean mostrarcodigoTipoImagenPersona=true;
	public Boolean activarcodigoTipoImagenPersona=true;

	public Border resaltarnombreTipoImagenPersona=null;
	public Boolean mostrarnombreTipoImagenPersona=true;
	public Boolean activarnombreTipoImagenPersona=true;

	
	

	public Border setResaltaridTipoImagenPersona(ParametroGeneralUsuario parametroGeneralUsuario/*TipoImagenPersonaBeanSwingJInternalFrame tipoimagenpersonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoimagenpersonaBeanSwingJInternalFrame.jTtoolBarTipoImagenPersona.setBorder(borderResaltar);
		
		this.resaltaridTipoImagenPersona= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoImagenPersona() {
		return this.resaltaridTipoImagenPersona;
	}

	public void setResaltaridTipoImagenPersona(Border borderResaltar) {
		this.resaltaridTipoImagenPersona= borderResaltar;
	}

	public Boolean getMostraridTipoImagenPersona() {
		return this.mostraridTipoImagenPersona;
	}

	public void setMostraridTipoImagenPersona(Boolean mostraridTipoImagenPersona) {
		this.mostraridTipoImagenPersona= mostraridTipoImagenPersona;
	}

	public Boolean getActivaridTipoImagenPersona() {
		return this.activaridTipoImagenPersona;
	}

	public void setActivaridTipoImagenPersona(Boolean activaridTipoImagenPersona) {
		this.activaridTipoImagenPersona= activaridTipoImagenPersona;
	}

	public Border setResaltarcodigoTipoImagenPersona(ParametroGeneralUsuario parametroGeneralUsuario/*TipoImagenPersonaBeanSwingJInternalFrame tipoimagenpersonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoimagenpersonaBeanSwingJInternalFrame.jTtoolBarTipoImagenPersona.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoImagenPersona= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoImagenPersona() {
		return this.resaltarcodigoTipoImagenPersona;
	}

	public void setResaltarcodigoTipoImagenPersona(Border borderResaltar) {
		this.resaltarcodigoTipoImagenPersona= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoImagenPersona() {
		return this.mostrarcodigoTipoImagenPersona;
	}

	public void setMostrarcodigoTipoImagenPersona(Boolean mostrarcodigoTipoImagenPersona) {
		this.mostrarcodigoTipoImagenPersona= mostrarcodigoTipoImagenPersona;
	}

	public Boolean getActivarcodigoTipoImagenPersona() {
		return this.activarcodigoTipoImagenPersona;
	}

	public void setActivarcodigoTipoImagenPersona(Boolean activarcodigoTipoImagenPersona) {
		this.activarcodigoTipoImagenPersona= activarcodigoTipoImagenPersona;
	}

	public Border setResaltarnombreTipoImagenPersona(ParametroGeneralUsuario parametroGeneralUsuario/*TipoImagenPersonaBeanSwingJInternalFrame tipoimagenpersonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoimagenpersonaBeanSwingJInternalFrame.jTtoolBarTipoImagenPersona.setBorder(borderResaltar);
		
		this.resaltarnombreTipoImagenPersona= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoImagenPersona() {
		return this.resaltarnombreTipoImagenPersona;
	}

	public void setResaltarnombreTipoImagenPersona(Border borderResaltar) {
		this.resaltarnombreTipoImagenPersona= borderResaltar;
	}

	public Boolean getMostrarnombreTipoImagenPersona() {
		return this.mostrarnombreTipoImagenPersona;
	}

	public void setMostrarnombreTipoImagenPersona(Boolean mostrarnombreTipoImagenPersona) {
		this.mostrarnombreTipoImagenPersona= mostrarnombreTipoImagenPersona;
	}

	public Boolean getActivarnombreTipoImagenPersona() {
		return this.activarnombreTipoImagenPersona;
	}

	public void setActivarnombreTipoImagenPersona(Boolean activarnombreTipoImagenPersona) {
		this.activarnombreTipoImagenPersona= activarnombreTipoImagenPersona;
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
		
		
		this.setMostraridTipoImagenPersona(esInicial);
		this.setMostrarcodigoTipoImagenPersona(esInicial);
		this.setMostrarnombreTipoImagenPersona(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoImagenPersonaConstantesFunciones.ID)) {
				this.setMostraridTipoImagenPersona(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoImagenPersonaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoImagenPersona(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoImagenPersonaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoImagenPersona(esAsigna);
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
		
		
		this.setActivaridTipoImagenPersona(esInicial);
		this.setActivarcodigoTipoImagenPersona(esInicial);
		this.setActivarnombreTipoImagenPersona(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoImagenPersonaConstantesFunciones.ID)) {
				this.setActivaridTipoImagenPersona(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoImagenPersonaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoImagenPersona(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoImagenPersonaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoImagenPersona(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoImagenPersonaBeanSwingJInternalFrame tipoimagenpersonaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoImagenPersona(esInicial);
		this.setResaltarcodigoTipoImagenPersona(esInicial);
		this.setResaltarnombreTipoImagenPersona(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoImagenPersonaConstantesFunciones.ID)) {
				this.setResaltaridTipoImagenPersona(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoImagenPersonaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoImagenPersona(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoImagenPersonaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoImagenPersona(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoImagenPersonaBeanSwingJInternalFrame tipoimagenpersonaBeanSwingJInternalFrame*/)throws Exception {	
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