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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.TipoBancoDiscoConstantesFunciones;
import com.bydan.erp.nomina.util.TipoBancoDiscoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoBancoDiscoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoBancoDiscoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoBancoDisco";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoBancoDisco"+TipoBancoDiscoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoBancoDiscoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoBancoDiscoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoBancoDiscoConstantesFunciones.SCHEMA+"_"+TipoBancoDiscoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoBancoDiscoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoBancoDiscoConstantesFunciones.SCHEMA+"_"+TipoBancoDiscoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoBancoDiscoConstantesFunciones.SCHEMA+"_"+TipoBancoDiscoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoBancoDiscoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoBancoDiscoConstantesFunciones.SCHEMA+"_"+TipoBancoDiscoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoBancoDiscoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoBancoDiscoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoBancoDiscoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoBancoDiscoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoBancoDiscoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoBancoDiscoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoBancoDiscoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoBancoDiscoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoBancoDiscoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoBancoDiscoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Banco Discos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Banco Disco";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Banco Disco";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoBancoDisco";
	public static final String OBJECTNAME="tipobancodisco";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_banco_disco";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipobancodisco from "+TipoBancoDiscoConstantesFunciones.SPERSISTENCENAME+" tipobancodisco";
	public static String QUERYSELECTNATIVE="select "+TipoBancoDiscoConstantesFunciones.SCHEMA+"."+TipoBancoDiscoConstantesFunciones.TABLENAME+".id,"+TipoBancoDiscoConstantesFunciones.SCHEMA+"."+TipoBancoDiscoConstantesFunciones.TABLENAME+".version_row,"+TipoBancoDiscoConstantesFunciones.SCHEMA+"."+TipoBancoDiscoConstantesFunciones.TABLENAME+".codigo,"+TipoBancoDiscoConstantesFunciones.SCHEMA+"."+TipoBancoDiscoConstantesFunciones.TABLENAME+".nombre from "+TipoBancoDiscoConstantesFunciones.SCHEMA+"."+TipoBancoDiscoConstantesFunciones.TABLENAME;//+" as "+TipoBancoDiscoConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoBancoDiscoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoBancoDiscoConstantesFunciones.CODIGO)) {sLabelColumna=TipoBancoDiscoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoBancoDiscoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoBancoDiscoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoBancoDiscoDescripcion(TipoBancoDisco tipobancodisco) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipobancodisco !=null/* && tipobancodisco.getId()!=0*/) {
			sDescripcion=tipobancodisco.getcodigo();//tipobancodiscotipobancodisco.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoBancoDiscoDescripcionDetallado(TipoBancoDisco tipobancodisco) {
		String sDescripcion="";
			
		sDescripcion+=TipoBancoDiscoConstantesFunciones.ID+"=";
		sDescripcion+=tipobancodisco.getId().toString()+",";
		sDescripcion+=TipoBancoDiscoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipobancodisco.getVersionRow().toString()+",";
		sDescripcion+=TipoBancoDiscoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipobancodisco.getcodigo()+",";
		sDescripcion+=TipoBancoDiscoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipobancodisco.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoBancoDiscoDescripcion(TipoBancoDisco tipobancodisco,String sValor) throws Exception {			
		if(tipobancodisco !=null) {
			tipobancodisco.setcodigo(sValor);;//tipobancodiscotipobancodisco.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoBancoDisco(TipoBancoDisco tipobancodisco,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipobancodisco.setcodigo(tipobancodisco.getcodigo().trim());
		tipobancodisco.setnombre(tipobancodisco.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoBancoDiscos(List<TipoBancoDisco> tipobancodiscos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoBancoDisco tipobancodisco: tipobancodiscos) {
			tipobancodisco.setcodigo(tipobancodisco.getcodigo().trim());
			tipobancodisco.setnombre(tipobancodisco.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoBancoDisco(TipoBancoDisco tipobancodisco,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipobancodisco.getConCambioAuxiliar()) {
			tipobancodisco.setIsDeleted(tipobancodisco.getIsDeletedAuxiliar());	
			tipobancodisco.setIsNew(tipobancodisco.getIsNewAuxiliar());	
			tipobancodisco.setIsChanged(tipobancodisco.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipobancodisco.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipobancodisco.setIsDeletedAuxiliar(false);	
			tipobancodisco.setIsNewAuxiliar(false);	
			tipobancodisco.setIsChangedAuxiliar(false);
			
			tipobancodisco.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoBancoDiscos(List<TipoBancoDisco> tipobancodiscos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoBancoDisco tipobancodisco : tipobancodiscos) {
			if(conAsignarBase && tipobancodisco.getConCambioAuxiliar()) {
				tipobancodisco.setIsDeleted(tipobancodisco.getIsDeletedAuxiliar());	
				tipobancodisco.setIsNew(tipobancodisco.getIsNewAuxiliar());	
				tipobancodisco.setIsChanged(tipobancodisco.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipobancodisco.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipobancodisco.setIsDeletedAuxiliar(false);	
				tipobancodisco.setIsNewAuxiliar(false);	
				tipobancodisco.setIsChangedAuxiliar(false);
				
				tipobancodisco.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoBancoDisco(TipoBancoDisco tipobancodisco,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoBancoDiscos(List<TipoBancoDisco> tipobancodiscos,Boolean conEnteros) throws Exception  {
		
		for(TipoBancoDisco tipobancodisco: tipobancodiscos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoBancoDisco(List<TipoBancoDisco> tipobancodiscos,TipoBancoDisco tipobancodiscoAux) throws Exception  {
		TipoBancoDiscoConstantesFunciones.InicializarValoresTipoBancoDisco(tipobancodiscoAux,true);
		
		for(TipoBancoDisco tipobancodisco: tipobancodiscos) {
			if(tipobancodisco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoBancoDisco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoBancoDiscoConstantesFunciones.getArrayColumnasGlobalesTipoBancoDisco(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoBancoDisco(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoBancoDisco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoBancoDisco> tipobancodiscos,TipoBancoDisco tipobancodisco,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoBancoDisco tipobancodiscoAux: tipobancodiscos) {
			if(tipobancodiscoAux!=null && tipobancodisco!=null) {
				if((tipobancodiscoAux.getId()==null && tipobancodisco.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipobancodiscoAux.getId()!=null && tipobancodisco.getId()!=null){
					if(tipobancodiscoAux.getId().equals(tipobancodisco.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoBancoDisco(List<TipoBancoDisco> tipobancodiscos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoBancoDisco tipobancodisco: tipobancodiscos) {			
			if(tipobancodisco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoBancoDisco() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoBancoDiscoConstantesFunciones.LABEL_ID, TipoBancoDiscoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoBancoDiscoConstantesFunciones.LABEL_VERSIONROW, TipoBancoDiscoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoBancoDiscoConstantesFunciones.LABEL_CODIGO, TipoBancoDiscoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoBancoDiscoConstantesFunciones.LABEL_NOMBRE, TipoBancoDiscoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoBancoDisco() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoBancoDiscoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoBancoDiscoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoBancoDiscoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoBancoDiscoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoBancoDisco() throws Exception  {
		return TipoBancoDiscoConstantesFunciones.getTiposSeleccionarTipoBancoDisco(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoBancoDisco(Boolean conFk) throws Exception  {
		return TipoBancoDiscoConstantesFunciones.getTiposSeleccionarTipoBancoDisco(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoBancoDisco(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoBancoDiscoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoBancoDiscoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoBancoDiscoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoBancoDiscoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoBancoDisco(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoBancoDisco(TipoBancoDisco tipobancodiscoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoBancoDisco(List<TipoBancoDisco> tipobancodiscosTemp) throws Exception {
		for(TipoBancoDisco tipobancodiscoAux:tipobancodiscosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoBancoDisco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoBancoDisco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoBancoDisco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoBancoDiscoConstantesFunciones.getClassesRelationshipsOfTipoBancoDisco(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoBancoDisco(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoBancoDisco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoBancoDiscoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoBancoDisco(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoBancoDisco(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoBancoDisco tipobancodisco,List<TipoBancoDisco> tipobancodiscos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoBancoDisco tipobancodiscoEncontrado=null;
			
			for(TipoBancoDisco tipobancodiscoLocal:tipobancodiscos) {
				if(tipobancodiscoLocal.getId().equals(tipobancodisco.getId())) {
					tipobancodiscoEncontrado=tipobancodiscoLocal;
					
					tipobancodiscoLocal.setIsChanged(tipobancodisco.getIsChanged());
					tipobancodiscoLocal.setIsNew(tipobancodisco.getIsNew());
					tipobancodiscoLocal.setIsDeleted(tipobancodisco.getIsDeleted());
					
					tipobancodiscoLocal.setGeneralEntityOriginal(tipobancodisco.getGeneralEntityOriginal());
					
					tipobancodiscoLocal.setId(tipobancodisco.getId());	
					tipobancodiscoLocal.setVersionRow(tipobancodisco.getVersionRow());	
					tipobancodiscoLocal.setcodigo(tipobancodisco.getcodigo());	
					tipobancodiscoLocal.setnombre(tipobancodisco.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipobancodisco.getIsDeleted()) {
				if(!existe) {
					tipobancodiscos.add(tipobancodisco);
				}
			} else {
				if(tipobancodiscoEncontrado!=null && permiteQuitar)  {
					tipobancodiscos.remove(tipobancodiscoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoBancoDisco tipobancodisco,List<TipoBancoDisco> tipobancodiscos) throws Exception {
		try	{			
			for(TipoBancoDisco tipobancodiscoLocal:tipobancodiscos) {
				if(tipobancodiscoLocal.getId().equals(tipobancodisco.getId())) {
					tipobancodiscoLocal.setIsSelected(tipobancodisco.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoBancoDisco(List<TipoBancoDisco> tipobancodiscosAux) throws Exception {
		//this.tipobancodiscosAux=tipobancodiscosAux;
		
		for(TipoBancoDisco tipobancodiscoAux:tipobancodiscosAux) {
			if(tipobancodiscoAux.getIsChanged()) {
				tipobancodiscoAux.setIsChanged(false);
			}		
			
			if(tipobancodiscoAux.getIsNew()) {
				tipobancodiscoAux.setIsNew(false);
			}	
			
			if(tipobancodiscoAux.getIsDeleted()) {
				tipobancodiscoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoBancoDisco(TipoBancoDisco tipobancodiscoAux) throws Exception {
		//this.tipobancodiscoAux=tipobancodiscoAux;
		
			if(tipobancodiscoAux.getIsChanged()) {
				tipobancodiscoAux.setIsChanged(false);
			}		
			
			if(tipobancodiscoAux.getIsNew()) {
				tipobancodiscoAux.setIsNew(false);
			}	
			
			if(tipobancodiscoAux.getIsDeleted()) {
				tipobancodiscoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoBancoDisco tipobancodiscoAsignar,TipoBancoDisco tipobancodisco) throws Exception {
		tipobancodiscoAsignar.setId(tipobancodisco.getId());	
		tipobancodiscoAsignar.setVersionRow(tipobancodisco.getVersionRow());	
		tipobancodiscoAsignar.setcodigo(tipobancodisco.getcodigo());	
		tipobancodiscoAsignar.setnombre(tipobancodisco.getnombre());	
	}
	
	public static void inicializarTipoBancoDisco(TipoBancoDisco tipobancodisco) throws Exception {
		try {
				tipobancodisco.setId(0L);	
					
				tipobancodisco.setcodigo("");	
				tipobancodisco.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoBancoDisco(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoBancoDiscoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoBancoDiscoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoBancoDisco(String sTipo,Row row,Workbook workbook,TipoBancoDisco tipobancodisco,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipobancodisco.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipobancodisco.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoBancoDisco=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoBancoDisco() {
		return this.sFinalQueryTipoBancoDisco;
	}
	
	public void setsFinalQueryTipoBancoDisco(String sFinalQueryTipoBancoDisco) {
		this.sFinalQueryTipoBancoDisco= sFinalQueryTipoBancoDisco;
	}
	
	public Border resaltarSeleccionarTipoBancoDisco=null;
	
	public Border setResaltarSeleccionarTipoBancoDisco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoDiscoBeanSwingJInternalFrame tipobancodiscoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipobancodiscoBeanSwingJInternalFrame.jTtoolBarTipoBancoDisco.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoBancoDisco= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoBancoDisco() {
		return this.resaltarSeleccionarTipoBancoDisco;
	}
	
	public void setResaltarSeleccionarTipoBancoDisco(Border borderResaltarSeleccionarTipoBancoDisco) {
		this.resaltarSeleccionarTipoBancoDisco= borderResaltarSeleccionarTipoBancoDisco;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoBancoDisco=null;
	public Boolean mostraridTipoBancoDisco=true;
	public Boolean activaridTipoBancoDisco=true;

	public Border resaltarcodigoTipoBancoDisco=null;
	public Boolean mostrarcodigoTipoBancoDisco=true;
	public Boolean activarcodigoTipoBancoDisco=true;

	public Border resaltarnombreTipoBancoDisco=null;
	public Boolean mostrarnombreTipoBancoDisco=true;
	public Boolean activarnombreTipoBancoDisco=true;

	
	

	public Border setResaltaridTipoBancoDisco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoDiscoBeanSwingJInternalFrame tipobancodiscoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipobancodiscoBeanSwingJInternalFrame.jTtoolBarTipoBancoDisco.setBorder(borderResaltar);
		
		this.resaltaridTipoBancoDisco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoBancoDisco() {
		return this.resaltaridTipoBancoDisco;
	}

	public void setResaltaridTipoBancoDisco(Border borderResaltar) {
		this.resaltaridTipoBancoDisco= borderResaltar;
	}

	public Boolean getMostraridTipoBancoDisco() {
		return this.mostraridTipoBancoDisco;
	}

	public void setMostraridTipoBancoDisco(Boolean mostraridTipoBancoDisco) {
		this.mostraridTipoBancoDisco= mostraridTipoBancoDisco;
	}

	public Boolean getActivaridTipoBancoDisco() {
		return this.activaridTipoBancoDisco;
	}

	public void setActivaridTipoBancoDisco(Boolean activaridTipoBancoDisco) {
		this.activaridTipoBancoDisco= activaridTipoBancoDisco;
	}

	public Border setResaltarcodigoTipoBancoDisco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoDiscoBeanSwingJInternalFrame tipobancodiscoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipobancodiscoBeanSwingJInternalFrame.jTtoolBarTipoBancoDisco.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoBancoDisco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoBancoDisco() {
		return this.resaltarcodigoTipoBancoDisco;
	}

	public void setResaltarcodigoTipoBancoDisco(Border borderResaltar) {
		this.resaltarcodigoTipoBancoDisco= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoBancoDisco() {
		return this.mostrarcodigoTipoBancoDisco;
	}

	public void setMostrarcodigoTipoBancoDisco(Boolean mostrarcodigoTipoBancoDisco) {
		this.mostrarcodigoTipoBancoDisco= mostrarcodigoTipoBancoDisco;
	}

	public Boolean getActivarcodigoTipoBancoDisco() {
		return this.activarcodigoTipoBancoDisco;
	}

	public void setActivarcodigoTipoBancoDisco(Boolean activarcodigoTipoBancoDisco) {
		this.activarcodigoTipoBancoDisco= activarcodigoTipoBancoDisco;
	}

	public Border setResaltarnombreTipoBancoDisco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoDiscoBeanSwingJInternalFrame tipobancodiscoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipobancodiscoBeanSwingJInternalFrame.jTtoolBarTipoBancoDisco.setBorder(borderResaltar);
		
		this.resaltarnombreTipoBancoDisco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoBancoDisco() {
		return this.resaltarnombreTipoBancoDisco;
	}

	public void setResaltarnombreTipoBancoDisco(Border borderResaltar) {
		this.resaltarnombreTipoBancoDisco= borderResaltar;
	}

	public Boolean getMostrarnombreTipoBancoDisco() {
		return this.mostrarnombreTipoBancoDisco;
	}

	public void setMostrarnombreTipoBancoDisco(Boolean mostrarnombreTipoBancoDisco) {
		this.mostrarnombreTipoBancoDisco= mostrarnombreTipoBancoDisco;
	}

	public Boolean getActivarnombreTipoBancoDisco() {
		return this.activarnombreTipoBancoDisco;
	}

	public void setActivarnombreTipoBancoDisco(Boolean activarnombreTipoBancoDisco) {
		this.activarnombreTipoBancoDisco= activarnombreTipoBancoDisco;
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
		
		
		this.setMostraridTipoBancoDisco(esInicial);
		this.setMostrarcodigoTipoBancoDisco(esInicial);
		this.setMostrarnombreTipoBancoDisco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoBancoDiscoConstantesFunciones.ID)) {
				this.setMostraridTipoBancoDisco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoDiscoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoBancoDisco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoDiscoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoBancoDisco(esAsigna);
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
		
		
		this.setActivaridTipoBancoDisco(esInicial);
		this.setActivarcodigoTipoBancoDisco(esInicial);
		this.setActivarnombreTipoBancoDisco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoBancoDiscoConstantesFunciones.ID)) {
				this.setActivaridTipoBancoDisco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoDiscoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoBancoDisco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoDiscoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoBancoDisco(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoBancoDiscoBeanSwingJInternalFrame tipobancodiscoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoBancoDisco(esInicial);
		this.setResaltarcodigoTipoBancoDisco(esInicial);
		this.setResaltarnombreTipoBancoDisco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoBancoDiscoConstantesFunciones.ID)) {
				this.setResaltaridTipoBancoDisco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoDiscoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoBancoDisco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoDiscoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoBancoDisco(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoBancoDiscoBeanSwingJInternalFrame tipobancodiscoBeanSwingJInternalFrame*/)throws Exception {	
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