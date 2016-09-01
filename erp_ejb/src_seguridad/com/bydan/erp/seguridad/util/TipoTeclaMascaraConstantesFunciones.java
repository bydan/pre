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


import com.bydan.erp.seguridad.util.TipoTeclaMascaraConstantesFunciones;
import com.bydan.erp.seguridad.util.TipoTeclaMascaraParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.TipoTeclaMascaraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoTeclaMascaraConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoTeclaMascara";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoTeclaMascara"+TipoTeclaMascaraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoTeclaMascaraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoTeclaMascaraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoTeclaMascaraConstantesFunciones.SCHEMA+"_"+TipoTeclaMascaraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoTeclaMascaraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoTeclaMascaraConstantesFunciones.SCHEMA+"_"+TipoTeclaMascaraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoTeclaMascaraConstantesFunciones.SCHEMA+"_"+TipoTeclaMascaraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoTeclaMascaraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoTeclaMascaraConstantesFunciones.SCHEMA+"_"+TipoTeclaMascaraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTeclaMascaraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoTeclaMascaraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTeclaMascaraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTeclaMascaraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoTeclaMascaraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTeclaMascaraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoTeclaMascaraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoTeclaMascaraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoTeclaMascaraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoTeclaMascaraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Tecla Mascaras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Tecla Mascara";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Tecla Mascara";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoTeclaMascara";
	public static final String OBJECTNAME="tipoteclamascara";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="tipo_tecla_mascara";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoteclamascara from "+TipoTeclaMascaraConstantesFunciones.SPERSISTENCENAME+" tipoteclamascara";
	public static String QUERYSELECTNATIVE="select "+TipoTeclaMascaraConstantesFunciones.SCHEMA+"."+TipoTeclaMascaraConstantesFunciones.TABLENAME+".id,"+TipoTeclaMascaraConstantesFunciones.SCHEMA+"."+TipoTeclaMascaraConstantesFunciones.TABLENAME+".version_row,"+TipoTeclaMascaraConstantesFunciones.SCHEMA+"."+TipoTeclaMascaraConstantesFunciones.TABLENAME+".codigo,"+TipoTeclaMascaraConstantesFunciones.SCHEMA+"."+TipoTeclaMascaraConstantesFunciones.TABLENAME+".nombre from "+TipoTeclaMascaraConstantesFunciones.SCHEMA+"."+TipoTeclaMascaraConstantesFunciones.TABLENAME;//+" as "+TipoTeclaMascaraConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoTeclaMascaraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoTeclaMascaraConstantesFunciones.CODIGO)) {sLabelColumna=TipoTeclaMascaraConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoTeclaMascaraConstantesFunciones.NOMBRE)) {sLabelColumna=TipoTeclaMascaraConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoTeclaMascaraDescripcion(TipoTeclaMascara tipoteclamascara) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoteclamascara !=null/* && tipoteclamascara.getId()!=0*/) {
			sDescripcion=tipoteclamascara.getcodigo();//tipoteclamascaratipoteclamascara.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoTeclaMascaraDescripcionDetallado(TipoTeclaMascara tipoteclamascara) {
		String sDescripcion="";
			
		sDescripcion+=TipoTeclaMascaraConstantesFunciones.ID+"=";
		sDescripcion+=tipoteclamascara.getId().toString()+",";
		sDescripcion+=TipoTeclaMascaraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoteclamascara.getVersionRow().toString()+",";
		sDescripcion+=TipoTeclaMascaraConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoteclamascara.getcodigo()+",";
		sDescripcion+=TipoTeclaMascaraConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoteclamascara.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoTeclaMascaraDescripcion(TipoTeclaMascara tipoteclamascara,String sValor) throws Exception {			
		if(tipoteclamascara !=null) {
			tipoteclamascara.setcodigo(sValor);;//tipoteclamascaratipoteclamascara.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoTeclaMascara(TipoTeclaMascara tipoteclamascara,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoteclamascara.setcodigo(tipoteclamascara.getcodigo().trim());
		tipoteclamascara.setnombre(tipoteclamascara.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoTeclaMascaras(List<TipoTeclaMascara> tipoteclamascaras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoTeclaMascara tipoteclamascara: tipoteclamascaras) {
			tipoteclamascara.setcodigo(tipoteclamascara.getcodigo().trim());
			tipoteclamascara.setnombre(tipoteclamascara.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoTeclaMascara(TipoTeclaMascara tipoteclamascara,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoteclamascara.getConCambioAuxiliar()) {
			tipoteclamascara.setIsDeleted(tipoteclamascara.getIsDeletedAuxiliar());	
			tipoteclamascara.setIsNew(tipoteclamascara.getIsNewAuxiliar());	
			tipoteclamascara.setIsChanged(tipoteclamascara.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoteclamascara.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoteclamascara.setIsDeletedAuxiliar(false);	
			tipoteclamascara.setIsNewAuxiliar(false);	
			tipoteclamascara.setIsChangedAuxiliar(false);
			
			tipoteclamascara.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoTeclaMascaras(List<TipoTeclaMascara> tipoteclamascaras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoTeclaMascara tipoteclamascara : tipoteclamascaras) {
			if(conAsignarBase && tipoteclamascara.getConCambioAuxiliar()) {
				tipoteclamascara.setIsDeleted(tipoteclamascara.getIsDeletedAuxiliar());	
				tipoteclamascara.setIsNew(tipoteclamascara.getIsNewAuxiliar());	
				tipoteclamascara.setIsChanged(tipoteclamascara.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoteclamascara.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoteclamascara.setIsDeletedAuxiliar(false);	
				tipoteclamascara.setIsNewAuxiliar(false);	
				tipoteclamascara.setIsChangedAuxiliar(false);
				
				tipoteclamascara.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoTeclaMascara(TipoTeclaMascara tipoteclamascara,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoTeclaMascaras(List<TipoTeclaMascara> tipoteclamascaras,Boolean conEnteros) throws Exception  {
		
		for(TipoTeclaMascara tipoteclamascara: tipoteclamascaras) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoTeclaMascara(List<TipoTeclaMascara> tipoteclamascaras,TipoTeclaMascara tipoteclamascaraAux) throws Exception  {
		TipoTeclaMascaraConstantesFunciones.InicializarValoresTipoTeclaMascara(tipoteclamascaraAux,true);
		
		for(TipoTeclaMascara tipoteclamascara: tipoteclamascaras) {
			if(tipoteclamascara.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoTeclaMascara(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoTeclaMascaraConstantesFunciones.getArrayColumnasGlobalesTipoTeclaMascara(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoTeclaMascara(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoTeclaMascara(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoTeclaMascara> tipoteclamascaras,TipoTeclaMascara tipoteclamascara,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoTeclaMascara tipoteclamascaraAux: tipoteclamascaras) {
			if(tipoteclamascaraAux!=null && tipoteclamascara!=null) {
				if((tipoteclamascaraAux.getId()==null && tipoteclamascara.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoteclamascaraAux.getId()!=null && tipoteclamascara.getId()!=null){
					if(tipoteclamascaraAux.getId().equals(tipoteclamascara.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoTeclaMascara(List<TipoTeclaMascara> tipoteclamascaras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoTeclaMascara tipoteclamascara: tipoteclamascaras) {			
			if(tipoteclamascara.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoTeclaMascara() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoTeclaMascaraConstantesFunciones.LABEL_ID, TipoTeclaMascaraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTeclaMascaraConstantesFunciones.LABEL_VERSIONROW, TipoTeclaMascaraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTeclaMascaraConstantesFunciones.LABEL_CODIGO, TipoTeclaMascaraConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTeclaMascaraConstantesFunciones.LABEL_NOMBRE, TipoTeclaMascaraConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoTeclaMascara() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoTeclaMascaraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTeclaMascaraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTeclaMascaraConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTeclaMascaraConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTeclaMascara() throws Exception  {
		return TipoTeclaMascaraConstantesFunciones.getTiposSeleccionarTipoTeclaMascara(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTeclaMascara(Boolean conFk) throws Exception  {
		return TipoTeclaMascaraConstantesFunciones.getTiposSeleccionarTipoTeclaMascara(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTeclaMascara(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoTeclaMascaraConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoTeclaMascaraConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoTeclaMascaraConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoTeclaMascaraConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoTeclaMascara(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoTeclaMascara(TipoTeclaMascara tipoteclamascaraAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoTeclaMascara(List<TipoTeclaMascara> tipoteclamascarasTemp) throws Exception {
		for(TipoTeclaMascara tipoteclamascaraAux:tipoteclamascarasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoTeclaMascara(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoTeclaMascara(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoTeclaMascara(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoTeclaMascaraConstantesFunciones.getClassesRelationshipsOfTipoTeclaMascara(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoTeclaMascara(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoTeclaMascara(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoTeclaMascaraConstantesFunciones.getClassesRelationshipsFromStringsOfTipoTeclaMascara(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoTeclaMascara(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoTeclaMascara tipoteclamascara,List<TipoTeclaMascara> tipoteclamascaras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoTeclaMascara tipoteclamascaraEncontrado=null;
			
			for(TipoTeclaMascara tipoteclamascaraLocal:tipoteclamascaras) {
				if(tipoteclamascaraLocal.getId().equals(tipoteclamascara.getId())) {
					tipoteclamascaraEncontrado=tipoteclamascaraLocal;
					
					tipoteclamascaraLocal.setIsChanged(tipoteclamascara.getIsChanged());
					tipoteclamascaraLocal.setIsNew(tipoteclamascara.getIsNew());
					tipoteclamascaraLocal.setIsDeleted(tipoteclamascara.getIsDeleted());
					
					tipoteclamascaraLocal.setGeneralEntityOriginal(tipoteclamascara.getGeneralEntityOriginal());
					
					tipoteclamascaraLocal.setId(tipoteclamascara.getId());	
					tipoteclamascaraLocal.setVersionRow(tipoteclamascara.getVersionRow());	
					tipoteclamascaraLocal.setcodigo(tipoteclamascara.getcodigo());	
					tipoteclamascaraLocal.setnombre(tipoteclamascara.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoteclamascara.getIsDeleted()) {
				if(!existe) {
					tipoteclamascaras.add(tipoteclamascara);
				}
			} else {
				if(tipoteclamascaraEncontrado!=null && permiteQuitar)  {
					tipoteclamascaras.remove(tipoteclamascaraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoTeclaMascara tipoteclamascara,List<TipoTeclaMascara> tipoteclamascaras) throws Exception {
		try	{			
			for(TipoTeclaMascara tipoteclamascaraLocal:tipoteclamascaras) {
				if(tipoteclamascaraLocal.getId().equals(tipoteclamascara.getId())) {
					tipoteclamascaraLocal.setIsSelected(tipoteclamascara.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoTeclaMascara(List<TipoTeclaMascara> tipoteclamascarasAux) throws Exception {
		//this.tipoteclamascarasAux=tipoteclamascarasAux;
		
		for(TipoTeclaMascara tipoteclamascaraAux:tipoteclamascarasAux) {
			if(tipoteclamascaraAux.getIsChanged()) {
				tipoteclamascaraAux.setIsChanged(false);
			}		
			
			if(tipoteclamascaraAux.getIsNew()) {
				tipoteclamascaraAux.setIsNew(false);
			}	
			
			if(tipoteclamascaraAux.getIsDeleted()) {
				tipoteclamascaraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoTeclaMascara(TipoTeclaMascara tipoteclamascaraAux) throws Exception {
		//this.tipoteclamascaraAux=tipoteclamascaraAux;
		
			if(tipoteclamascaraAux.getIsChanged()) {
				tipoteclamascaraAux.setIsChanged(false);
			}		
			
			if(tipoteclamascaraAux.getIsNew()) {
				tipoteclamascaraAux.setIsNew(false);
			}	
			
			if(tipoteclamascaraAux.getIsDeleted()) {
				tipoteclamascaraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoTeclaMascara tipoteclamascaraAsignar,TipoTeclaMascara tipoteclamascara) throws Exception {
		tipoteclamascaraAsignar.setId(tipoteclamascara.getId());	
		tipoteclamascaraAsignar.setVersionRow(tipoteclamascara.getVersionRow());	
		tipoteclamascaraAsignar.setcodigo(tipoteclamascara.getcodigo());	
		tipoteclamascaraAsignar.setnombre(tipoteclamascara.getnombre());	
	}
	
	public static void inicializarTipoTeclaMascara(TipoTeclaMascara tipoteclamascara) throws Exception {
		try {
				tipoteclamascara.setId(0L);	
					
				tipoteclamascara.setcodigo("");	
				tipoteclamascara.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoTeclaMascara(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoTeclaMascaraConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoTeclaMascaraConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoTeclaMascara(String sTipo,Row row,Workbook workbook,TipoTeclaMascara tipoteclamascara,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoteclamascara.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoteclamascara.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoTeclaMascara=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoTeclaMascara() {
		return this.sFinalQueryTipoTeclaMascara;
	}
	
	public void setsFinalQueryTipoTeclaMascara(String sFinalQueryTipoTeclaMascara) {
		this.sFinalQueryTipoTeclaMascara= sFinalQueryTipoTeclaMascara;
	}
	
	public Border resaltarSeleccionarTipoTeclaMascara=null;
	
	public Border setResaltarSeleccionarTipoTeclaMascara(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTeclaMascaraBeanSwingJInternalFrame tipoteclamascaraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoteclamascaraBeanSwingJInternalFrame.jTtoolBarTipoTeclaMascara.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoTeclaMascara= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoTeclaMascara() {
		return this.resaltarSeleccionarTipoTeclaMascara;
	}
	
	public void setResaltarSeleccionarTipoTeclaMascara(Border borderResaltarSeleccionarTipoTeclaMascara) {
		this.resaltarSeleccionarTipoTeclaMascara= borderResaltarSeleccionarTipoTeclaMascara;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoTeclaMascara=null;
	public Boolean mostraridTipoTeclaMascara=true;
	public Boolean activaridTipoTeclaMascara=true;

	public Border resaltarcodigoTipoTeclaMascara=null;
	public Boolean mostrarcodigoTipoTeclaMascara=true;
	public Boolean activarcodigoTipoTeclaMascara=true;

	public Border resaltarnombreTipoTeclaMascara=null;
	public Boolean mostrarnombreTipoTeclaMascara=true;
	public Boolean activarnombreTipoTeclaMascara=true;

	
	

	public Border setResaltaridTipoTeclaMascara(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTeclaMascaraBeanSwingJInternalFrame tipoteclamascaraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoteclamascaraBeanSwingJInternalFrame.jTtoolBarTipoTeclaMascara.setBorder(borderResaltar);
		
		this.resaltaridTipoTeclaMascara= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoTeclaMascara() {
		return this.resaltaridTipoTeclaMascara;
	}

	public void setResaltaridTipoTeclaMascara(Border borderResaltar) {
		this.resaltaridTipoTeclaMascara= borderResaltar;
	}

	public Boolean getMostraridTipoTeclaMascara() {
		return this.mostraridTipoTeclaMascara;
	}

	public void setMostraridTipoTeclaMascara(Boolean mostraridTipoTeclaMascara) {
		this.mostraridTipoTeclaMascara= mostraridTipoTeclaMascara;
	}

	public Boolean getActivaridTipoTeclaMascara() {
		return this.activaridTipoTeclaMascara;
	}

	public void setActivaridTipoTeclaMascara(Boolean activaridTipoTeclaMascara) {
		this.activaridTipoTeclaMascara= activaridTipoTeclaMascara;
	}

	public Border setResaltarcodigoTipoTeclaMascara(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTeclaMascaraBeanSwingJInternalFrame tipoteclamascaraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoteclamascaraBeanSwingJInternalFrame.jTtoolBarTipoTeclaMascara.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoTeclaMascara= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoTeclaMascara() {
		return this.resaltarcodigoTipoTeclaMascara;
	}

	public void setResaltarcodigoTipoTeclaMascara(Border borderResaltar) {
		this.resaltarcodigoTipoTeclaMascara= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoTeclaMascara() {
		return this.mostrarcodigoTipoTeclaMascara;
	}

	public void setMostrarcodigoTipoTeclaMascara(Boolean mostrarcodigoTipoTeclaMascara) {
		this.mostrarcodigoTipoTeclaMascara= mostrarcodigoTipoTeclaMascara;
	}

	public Boolean getActivarcodigoTipoTeclaMascara() {
		return this.activarcodigoTipoTeclaMascara;
	}

	public void setActivarcodigoTipoTeclaMascara(Boolean activarcodigoTipoTeclaMascara) {
		this.activarcodigoTipoTeclaMascara= activarcodigoTipoTeclaMascara;
	}

	public Border setResaltarnombreTipoTeclaMascara(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTeclaMascaraBeanSwingJInternalFrame tipoteclamascaraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoteclamascaraBeanSwingJInternalFrame.jTtoolBarTipoTeclaMascara.setBorder(borderResaltar);
		
		this.resaltarnombreTipoTeclaMascara= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoTeclaMascara() {
		return this.resaltarnombreTipoTeclaMascara;
	}

	public void setResaltarnombreTipoTeclaMascara(Border borderResaltar) {
		this.resaltarnombreTipoTeclaMascara= borderResaltar;
	}

	public Boolean getMostrarnombreTipoTeclaMascara() {
		return this.mostrarnombreTipoTeclaMascara;
	}

	public void setMostrarnombreTipoTeclaMascara(Boolean mostrarnombreTipoTeclaMascara) {
		this.mostrarnombreTipoTeclaMascara= mostrarnombreTipoTeclaMascara;
	}

	public Boolean getActivarnombreTipoTeclaMascara() {
		return this.activarnombreTipoTeclaMascara;
	}

	public void setActivarnombreTipoTeclaMascara(Boolean activarnombreTipoTeclaMascara) {
		this.activarnombreTipoTeclaMascara= activarnombreTipoTeclaMascara;
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
		
		
		this.setMostraridTipoTeclaMascara(esInicial);
		this.setMostrarcodigoTipoTeclaMascara(esInicial);
		this.setMostrarnombreTipoTeclaMascara(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTeclaMascaraConstantesFunciones.ID)) {
				this.setMostraridTipoTeclaMascara(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTeclaMascaraConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoTeclaMascara(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTeclaMascaraConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoTeclaMascara(esAsigna);
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
		
		
		this.setActivaridTipoTeclaMascara(esInicial);
		this.setActivarcodigoTipoTeclaMascara(esInicial);
		this.setActivarnombreTipoTeclaMascara(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTeclaMascaraConstantesFunciones.ID)) {
				this.setActivaridTipoTeclaMascara(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTeclaMascaraConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoTeclaMascara(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTeclaMascaraConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoTeclaMascara(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoTeclaMascaraBeanSwingJInternalFrame tipoteclamascaraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoTeclaMascara(esInicial);
		this.setResaltarcodigoTipoTeclaMascara(esInicial);
		this.setResaltarnombreTipoTeclaMascara(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTeclaMascaraConstantesFunciones.ID)) {
				this.setResaltaridTipoTeclaMascara(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTeclaMascaraConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoTeclaMascara(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTeclaMascaraConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoTeclaMascara(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoTeclaMascaraBeanSwingJInternalFrame tipoteclamascaraBeanSwingJInternalFrame*/)throws Exception {	
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