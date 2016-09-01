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


import com.bydan.erp.nomina.util.TipoPruebaConstantesFunciones;
import com.bydan.erp.nomina.util.TipoPruebaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoPruebaParameterGeneral;

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
final public class TipoPruebaConstantesFunciones extends TipoPruebaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoPrueba";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoPrueba"+TipoPruebaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoPruebaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoPruebaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoPruebaConstantesFunciones.SCHEMA+"_"+TipoPruebaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoPruebaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoPruebaConstantesFunciones.SCHEMA+"_"+TipoPruebaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoPruebaConstantesFunciones.SCHEMA+"_"+TipoPruebaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoPruebaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoPruebaConstantesFunciones.SCHEMA+"_"+TipoPruebaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPruebaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPruebaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPruebaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPruebaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPruebaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPruebaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoPruebaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoPruebaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoPruebaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoPruebaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Pruebas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Prueba";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Prueba";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoPrueba";
	public static final String OBJECTNAME="tipoprueba";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_prueba";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoprueba from "+TipoPruebaConstantesFunciones.SPERSISTENCENAME+" tipoprueba";
	public static String QUERYSELECTNATIVE="select "+TipoPruebaConstantesFunciones.SCHEMA+"."+TipoPruebaConstantesFunciones.TABLENAME+".id,"+TipoPruebaConstantesFunciones.SCHEMA+"."+TipoPruebaConstantesFunciones.TABLENAME+".version_row,"+TipoPruebaConstantesFunciones.SCHEMA+"."+TipoPruebaConstantesFunciones.TABLENAME+".codigo,"+TipoPruebaConstantesFunciones.SCHEMA+"."+TipoPruebaConstantesFunciones.TABLENAME+".nombre from "+TipoPruebaConstantesFunciones.SCHEMA+"."+TipoPruebaConstantesFunciones.TABLENAME;//+" as "+TipoPruebaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoPruebaConstantesFuncionesAdditional tipopruebaConstantesFuncionesAdditional=null;
	
	public TipoPruebaConstantesFuncionesAdditional getTipoPruebaConstantesFuncionesAdditional() {
		return this.tipopruebaConstantesFuncionesAdditional;
	}
	
	public void setTipoPruebaConstantesFuncionesAdditional(TipoPruebaConstantesFuncionesAdditional tipopruebaConstantesFuncionesAdditional) {
		try {
			this.tipopruebaConstantesFuncionesAdditional=tipopruebaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
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
	
	public static String getTipoPruebaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoPruebaConstantesFunciones.CODIGO)) {sLabelColumna=TipoPruebaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoPruebaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoPruebaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoPruebaDescripcion(TipoPrueba tipoprueba) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoprueba !=null/* && tipoprueba.getId()!=0*/) {
			sDescripcion=tipoprueba.getcodigo();//tipopruebatipoprueba.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoPruebaDescripcionDetallado(TipoPrueba tipoprueba) {
		String sDescripcion="";
			
		sDescripcion+=TipoPruebaConstantesFunciones.ID+"=";
		sDescripcion+=tipoprueba.getId().toString()+",";
		sDescripcion+=TipoPruebaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoprueba.getVersionRow().toString()+",";
		sDescripcion+=TipoPruebaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoprueba.getcodigo()+",";
		sDescripcion+=TipoPruebaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoprueba.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoPruebaDescripcion(TipoPrueba tipoprueba,String sValor) throws Exception {			
		if(tipoprueba !=null) {
			tipoprueba.setcodigo(sValor);;//tipopruebatipoprueba.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoPrueba(TipoPrueba tipoprueba,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoprueba.setcodigo(tipoprueba.getcodigo().trim());
		tipoprueba.setnombre(tipoprueba.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoPruebas(List<TipoPrueba> tipopruebas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoPrueba tipoprueba: tipopruebas) {
			tipoprueba.setcodigo(tipoprueba.getcodigo().trim());
			tipoprueba.setnombre(tipoprueba.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoPrueba(TipoPrueba tipoprueba,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoprueba.getConCambioAuxiliar()) {
			tipoprueba.setIsDeleted(tipoprueba.getIsDeletedAuxiliar());	
			tipoprueba.setIsNew(tipoprueba.getIsNewAuxiliar());	
			tipoprueba.setIsChanged(tipoprueba.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoprueba.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoprueba.setIsDeletedAuxiliar(false);	
			tipoprueba.setIsNewAuxiliar(false);	
			tipoprueba.setIsChangedAuxiliar(false);
			
			tipoprueba.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoPruebas(List<TipoPrueba> tipopruebas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoPrueba tipoprueba : tipopruebas) {
			if(conAsignarBase && tipoprueba.getConCambioAuxiliar()) {
				tipoprueba.setIsDeleted(tipoprueba.getIsDeletedAuxiliar());	
				tipoprueba.setIsNew(tipoprueba.getIsNewAuxiliar());	
				tipoprueba.setIsChanged(tipoprueba.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoprueba.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoprueba.setIsDeletedAuxiliar(false);	
				tipoprueba.setIsNewAuxiliar(false);	
				tipoprueba.setIsChangedAuxiliar(false);
				
				tipoprueba.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoPrueba(TipoPrueba tipoprueba,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoPruebas(List<TipoPrueba> tipopruebas,Boolean conEnteros) throws Exception  {
		
		for(TipoPrueba tipoprueba: tipopruebas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoPrueba(List<TipoPrueba> tipopruebas,TipoPrueba tipopruebaAux) throws Exception  {
		TipoPruebaConstantesFunciones.InicializarValoresTipoPrueba(tipopruebaAux,true);
		
		for(TipoPrueba tipoprueba: tipopruebas) {
			if(tipoprueba.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPrueba(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoPruebaConstantesFunciones.getArrayColumnasGlobalesTipoPrueba(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPrueba(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoPrueba(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoPrueba> tipopruebas,TipoPrueba tipoprueba,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoPrueba tipopruebaAux: tipopruebas) {
			if(tipopruebaAux!=null && tipoprueba!=null) {
				if((tipopruebaAux.getId()==null && tipoprueba.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipopruebaAux.getId()!=null && tipoprueba.getId()!=null){
					if(tipopruebaAux.getId().equals(tipoprueba.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoPrueba(List<TipoPrueba> tipopruebas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoPrueba tipoprueba: tipopruebas) {			
			if(tipoprueba.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoPrueba() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoPruebaConstantesFunciones.LABEL_ID, TipoPruebaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPruebaConstantesFunciones.LABEL_VERSIONROW, TipoPruebaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPruebaConstantesFunciones.LABEL_CODIGO, TipoPruebaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPruebaConstantesFunciones.LABEL_NOMBRE, TipoPruebaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoPrueba() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoPruebaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPruebaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPruebaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPruebaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPrueba() throws Exception  {
		return TipoPruebaConstantesFunciones.getTiposSeleccionarTipoPrueba(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPrueba(Boolean conFk) throws Exception  {
		return TipoPruebaConstantesFunciones.getTiposSeleccionarTipoPrueba(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPrueba(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPruebaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoPruebaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPruebaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoPruebaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoPrueba(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPrueba(TipoPrueba tipopruebaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPrueba(List<TipoPrueba> tipopruebasTemp) throws Exception {
		for(TipoPrueba tipopruebaAux:tipopruebasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoPrueba(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoPrueba(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPrueba(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPruebaConstantesFunciones.getClassesRelationshipsOfTipoPrueba(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPrueba(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPrueba(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPruebaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoPrueba(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPrueba(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoPrueba tipoprueba,List<TipoPrueba> tipopruebas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoPrueba tipopruebaEncontrado=null;
			
			for(TipoPrueba tipopruebaLocal:tipopruebas) {
				if(tipopruebaLocal.getId().equals(tipoprueba.getId())) {
					tipopruebaEncontrado=tipopruebaLocal;
					
					tipopruebaLocal.setIsChanged(tipoprueba.getIsChanged());
					tipopruebaLocal.setIsNew(tipoprueba.getIsNew());
					tipopruebaLocal.setIsDeleted(tipoprueba.getIsDeleted());
					
					tipopruebaLocal.setGeneralEntityOriginal(tipoprueba.getGeneralEntityOriginal());
					
					tipopruebaLocal.setId(tipoprueba.getId());	
					tipopruebaLocal.setVersionRow(tipoprueba.getVersionRow());	
					tipopruebaLocal.setcodigo(tipoprueba.getcodigo());	
					tipopruebaLocal.setnombre(tipoprueba.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoprueba.getIsDeleted()) {
				if(!existe) {
					tipopruebas.add(tipoprueba);
				}
			} else {
				if(tipopruebaEncontrado!=null && permiteQuitar)  {
					tipopruebas.remove(tipopruebaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoPrueba tipoprueba,List<TipoPrueba> tipopruebas) throws Exception {
		try	{			
			for(TipoPrueba tipopruebaLocal:tipopruebas) {
				if(tipopruebaLocal.getId().equals(tipoprueba.getId())) {
					tipopruebaLocal.setIsSelected(tipoprueba.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoPrueba(List<TipoPrueba> tipopruebasAux) throws Exception {
		//this.tipopruebasAux=tipopruebasAux;
		
		for(TipoPrueba tipopruebaAux:tipopruebasAux) {
			if(tipopruebaAux.getIsChanged()) {
				tipopruebaAux.setIsChanged(false);
			}		
			
			if(tipopruebaAux.getIsNew()) {
				tipopruebaAux.setIsNew(false);
			}	
			
			if(tipopruebaAux.getIsDeleted()) {
				tipopruebaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoPrueba(TipoPrueba tipopruebaAux) throws Exception {
		//this.tipopruebaAux=tipopruebaAux;
		
			if(tipopruebaAux.getIsChanged()) {
				tipopruebaAux.setIsChanged(false);
			}		
			
			if(tipopruebaAux.getIsNew()) {
				tipopruebaAux.setIsNew(false);
			}	
			
			if(tipopruebaAux.getIsDeleted()) {
				tipopruebaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoPrueba tipopruebaAsignar,TipoPrueba tipoprueba) throws Exception {
		tipopruebaAsignar.setId(tipoprueba.getId());	
		tipopruebaAsignar.setVersionRow(tipoprueba.getVersionRow());	
		tipopruebaAsignar.setcodigo(tipoprueba.getcodigo());	
		tipopruebaAsignar.setnombre(tipoprueba.getnombre());	
	}
	
	public static void inicializarTipoPrueba(TipoPrueba tipoprueba) throws Exception {
		try {
				tipoprueba.setId(0L);	
					
				tipoprueba.setcodigo("");	
				tipoprueba.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoPrueba(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPruebaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPruebaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoPrueba(String sTipo,Row row,Workbook workbook,TipoPrueba tipoprueba,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprueba.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprueba.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoPrueba=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoPrueba() {
		return this.sFinalQueryTipoPrueba;
	}
	
	public void setsFinalQueryTipoPrueba(String sFinalQueryTipoPrueba) {
		this.sFinalQueryTipoPrueba= sFinalQueryTipoPrueba;
	}
	
	public Border resaltarSeleccionarTipoPrueba=null;
	
	public Border setResaltarSeleccionarTipoPrueba(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPruebaBeanSwingJInternalFrame tipopruebaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipopruebaBeanSwingJInternalFrame.jTtoolBarTipoPrueba.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoPrueba= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoPrueba() {
		return this.resaltarSeleccionarTipoPrueba;
	}
	
	public void setResaltarSeleccionarTipoPrueba(Border borderResaltarSeleccionarTipoPrueba) {
		this.resaltarSeleccionarTipoPrueba= borderResaltarSeleccionarTipoPrueba;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoPrueba=null;
	public Boolean mostraridTipoPrueba=true;
	public Boolean activaridTipoPrueba=true;

	public Border resaltarcodigoTipoPrueba=null;
	public Boolean mostrarcodigoTipoPrueba=true;
	public Boolean activarcodigoTipoPrueba=true;

	public Border resaltarnombreTipoPrueba=null;
	public Boolean mostrarnombreTipoPrueba=true;
	public Boolean activarnombreTipoPrueba=true;

	
	

	public Border setResaltaridTipoPrueba(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPruebaBeanSwingJInternalFrame tipopruebaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipopruebaBeanSwingJInternalFrame.jTtoolBarTipoPrueba.setBorder(borderResaltar);
		
		this.resaltaridTipoPrueba= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoPrueba() {
		return this.resaltaridTipoPrueba;
	}

	public void setResaltaridTipoPrueba(Border borderResaltar) {
		this.resaltaridTipoPrueba= borderResaltar;
	}

	public Boolean getMostraridTipoPrueba() {
		return this.mostraridTipoPrueba;
	}

	public void setMostraridTipoPrueba(Boolean mostraridTipoPrueba) {
		this.mostraridTipoPrueba= mostraridTipoPrueba;
	}

	public Boolean getActivaridTipoPrueba() {
		return this.activaridTipoPrueba;
	}

	public void setActivaridTipoPrueba(Boolean activaridTipoPrueba) {
		this.activaridTipoPrueba= activaridTipoPrueba;
	}

	public Border setResaltarcodigoTipoPrueba(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPruebaBeanSwingJInternalFrame tipopruebaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipopruebaBeanSwingJInternalFrame.jTtoolBarTipoPrueba.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoPrueba= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoPrueba() {
		return this.resaltarcodigoTipoPrueba;
	}

	public void setResaltarcodigoTipoPrueba(Border borderResaltar) {
		this.resaltarcodigoTipoPrueba= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoPrueba() {
		return this.mostrarcodigoTipoPrueba;
	}

	public void setMostrarcodigoTipoPrueba(Boolean mostrarcodigoTipoPrueba) {
		this.mostrarcodigoTipoPrueba= mostrarcodigoTipoPrueba;
	}

	public Boolean getActivarcodigoTipoPrueba() {
		return this.activarcodigoTipoPrueba;
	}

	public void setActivarcodigoTipoPrueba(Boolean activarcodigoTipoPrueba) {
		this.activarcodigoTipoPrueba= activarcodigoTipoPrueba;
	}

	public Border setResaltarnombreTipoPrueba(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPruebaBeanSwingJInternalFrame tipopruebaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipopruebaBeanSwingJInternalFrame.jTtoolBarTipoPrueba.setBorder(borderResaltar);
		
		this.resaltarnombreTipoPrueba= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoPrueba() {
		return this.resaltarnombreTipoPrueba;
	}

	public void setResaltarnombreTipoPrueba(Border borderResaltar) {
		this.resaltarnombreTipoPrueba= borderResaltar;
	}

	public Boolean getMostrarnombreTipoPrueba() {
		return this.mostrarnombreTipoPrueba;
	}

	public void setMostrarnombreTipoPrueba(Boolean mostrarnombreTipoPrueba) {
		this.mostrarnombreTipoPrueba= mostrarnombreTipoPrueba;
	}

	public Boolean getActivarnombreTipoPrueba() {
		return this.activarnombreTipoPrueba;
	}

	public void setActivarnombreTipoPrueba(Boolean activarnombreTipoPrueba) {
		this.activarnombreTipoPrueba= activarnombreTipoPrueba;
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
		
		
		this.setMostraridTipoPrueba(esInicial);
		this.setMostrarcodigoTipoPrueba(esInicial);
		this.setMostrarnombreTipoPrueba(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPruebaConstantesFunciones.ID)) {
				this.setMostraridTipoPrueba(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPruebaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoPrueba(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPruebaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoPrueba(esAsigna);
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
		
		
		this.setActivaridTipoPrueba(esInicial);
		this.setActivarcodigoTipoPrueba(esInicial);
		this.setActivarnombreTipoPrueba(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPruebaConstantesFunciones.ID)) {
				this.setActivaridTipoPrueba(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPruebaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoPrueba(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPruebaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoPrueba(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoPruebaBeanSwingJInternalFrame tipopruebaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoPrueba(esInicial);
		this.setResaltarcodigoTipoPrueba(esInicial);
		this.setResaltarnombreTipoPrueba(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPruebaConstantesFunciones.ID)) {
				this.setResaltaridTipoPrueba(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPruebaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoPrueba(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPruebaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoPrueba(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoPruebaBeanSwingJInternalFrame tipopruebaBeanSwingJInternalFrame*/)throws Exception {	
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