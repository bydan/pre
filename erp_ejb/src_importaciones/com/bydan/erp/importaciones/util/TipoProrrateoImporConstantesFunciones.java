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
package com.bydan.erp.importaciones.util;

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


import com.bydan.erp.importaciones.util.TipoProrrateoImporConstantesFunciones;
import com.bydan.erp.importaciones.util.TipoProrrateoImporParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.TipoProrrateoImporParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.importaciones.business.dataaccess.*;
//import com.bydan.erp.importaciones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoProrrateoImporConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoProrrateoImpor";
	public static final String SPATHOPCION="Importaciones";	
	public static final String SPATHMODULO="importaciones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoProrrateoImpor"+TipoProrrateoImporConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoProrrateoImporHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoProrrateoImporHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoProrrateoImporConstantesFunciones.SCHEMA+"_"+TipoProrrateoImporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoProrrateoImporHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoProrrateoImporConstantesFunciones.SCHEMA+"_"+TipoProrrateoImporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoProrrateoImporConstantesFunciones.SCHEMA+"_"+TipoProrrateoImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoProrrateoImporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoProrrateoImporConstantesFunciones.SCHEMA+"_"+TipoProrrateoImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProrrateoImporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoProrrateoImporHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProrrateoImporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProrrateoImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoProrrateoImporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProrrateoImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoProrrateoImporConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoProrrateoImporConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoProrrateoImporConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoProrrateoImporConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Prorrateos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Prorrateo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Prorrateo Impor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoProrrateoImpor";
	public static final String OBJECTNAME="tipoprorrateoimpor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_IMPORTACIONES;	
	public static final String TABLENAME="tipo_prorrateo_impor";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoprorrateoimpor from "+TipoProrrateoImporConstantesFunciones.SPERSISTENCENAME+" tipoprorrateoimpor";
	public static String QUERYSELECTNATIVE="select "+TipoProrrateoImporConstantesFunciones.SCHEMA+"."+TipoProrrateoImporConstantesFunciones.TABLENAME+".id,"+TipoProrrateoImporConstantesFunciones.SCHEMA+"."+TipoProrrateoImporConstantesFunciones.TABLENAME+".version_row,"+TipoProrrateoImporConstantesFunciones.SCHEMA+"."+TipoProrrateoImporConstantesFunciones.TABLENAME+".codigo,"+TipoProrrateoImporConstantesFunciones.SCHEMA+"."+TipoProrrateoImporConstantesFunciones.TABLENAME+".nombre from "+TipoProrrateoImporConstantesFunciones.SCHEMA+"."+TipoProrrateoImporConstantesFunciones.TABLENAME;//+" as "+TipoProrrateoImporConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoProrrateoImporLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoProrrateoImporConstantesFunciones.CODIGO)) {sLabelColumna=TipoProrrateoImporConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoProrrateoImporConstantesFunciones.NOMBRE)) {sLabelColumna=TipoProrrateoImporConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoProrrateoImporDescripcion(TipoProrrateoImpor tipoprorrateoimpor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoprorrateoimpor !=null/* && tipoprorrateoimpor.getId()!=0*/) {
			sDescripcion=tipoprorrateoimpor.getcodigo();//tipoprorrateoimportipoprorrateoimpor.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoProrrateoImporDescripcionDetallado(TipoProrrateoImpor tipoprorrateoimpor) {
		String sDescripcion="";
			
		sDescripcion+=TipoProrrateoImporConstantesFunciones.ID+"=";
		sDescripcion+=tipoprorrateoimpor.getId().toString()+",";
		sDescripcion+=TipoProrrateoImporConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoprorrateoimpor.getVersionRow().toString()+",";
		sDescripcion+=TipoProrrateoImporConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoprorrateoimpor.getcodigo()+",";
		sDescripcion+=TipoProrrateoImporConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoprorrateoimpor.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoProrrateoImporDescripcion(TipoProrrateoImpor tipoprorrateoimpor,String sValor) throws Exception {			
		if(tipoprorrateoimpor !=null) {
			tipoprorrateoimpor.setcodigo(sValor);;//tipoprorrateoimportipoprorrateoimpor.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoProrrateoImpor(TipoProrrateoImpor tipoprorrateoimpor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoprorrateoimpor.setcodigo(tipoprorrateoimpor.getcodigo().trim());
		tipoprorrateoimpor.setnombre(tipoprorrateoimpor.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoProrrateoImpors(List<TipoProrrateoImpor> tipoprorrateoimpors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoProrrateoImpor tipoprorrateoimpor: tipoprorrateoimpors) {
			tipoprorrateoimpor.setcodigo(tipoprorrateoimpor.getcodigo().trim());
			tipoprorrateoimpor.setnombre(tipoprorrateoimpor.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoProrrateoImpor(TipoProrrateoImpor tipoprorrateoimpor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoprorrateoimpor.getConCambioAuxiliar()) {
			tipoprorrateoimpor.setIsDeleted(tipoprorrateoimpor.getIsDeletedAuxiliar());	
			tipoprorrateoimpor.setIsNew(tipoprorrateoimpor.getIsNewAuxiliar());	
			tipoprorrateoimpor.setIsChanged(tipoprorrateoimpor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoprorrateoimpor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoprorrateoimpor.setIsDeletedAuxiliar(false);	
			tipoprorrateoimpor.setIsNewAuxiliar(false);	
			tipoprorrateoimpor.setIsChangedAuxiliar(false);
			
			tipoprorrateoimpor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoProrrateoImpors(List<TipoProrrateoImpor> tipoprorrateoimpors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoProrrateoImpor tipoprorrateoimpor : tipoprorrateoimpors) {
			if(conAsignarBase && tipoprorrateoimpor.getConCambioAuxiliar()) {
				tipoprorrateoimpor.setIsDeleted(tipoprorrateoimpor.getIsDeletedAuxiliar());	
				tipoprorrateoimpor.setIsNew(tipoprorrateoimpor.getIsNewAuxiliar());	
				tipoprorrateoimpor.setIsChanged(tipoprorrateoimpor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoprorrateoimpor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoprorrateoimpor.setIsDeletedAuxiliar(false);	
				tipoprorrateoimpor.setIsNewAuxiliar(false);	
				tipoprorrateoimpor.setIsChangedAuxiliar(false);
				
				tipoprorrateoimpor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoProrrateoImpor(TipoProrrateoImpor tipoprorrateoimpor,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoProrrateoImpors(List<TipoProrrateoImpor> tipoprorrateoimpors,Boolean conEnteros) throws Exception  {
		
		for(TipoProrrateoImpor tipoprorrateoimpor: tipoprorrateoimpors) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoProrrateoImpor(List<TipoProrrateoImpor> tipoprorrateoimpors,TipoProrrateoImpor tipoprorrateoimporAux) throws Exception  {
		TipoProrrateoImporConstantesFunciones.InicializarValoresTipoProrrateoImpor(tipoprorrateoimporAux,true);
		
		for(TipoProrrateoImpor tipoprorrateoimpor: tipoprorrateoimpors) {
			if(tipoprorrateoimpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoProrrateoImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoProrrateoImporConstantesFunciones.getArrayColumnasGlobalesTipoProrrateoImpor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoProrrateoImpor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoProrrateoImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoProrrateoImpor> tipoprorrateoimpors,TipoProrrateoImpor tipoprorrateoimpor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoProrrateoImpor tipoprorrateoimporAux: tipoprorrateoimpors) {
			if(tipoprorrateoimporAux!=null && tipoprorrateoimpor!=null) {
				if((tipoprorrateoimporAux.getId()==null && tipoprorrateoimpor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoprorrateoimporAux.getId()!=null && tipoprorrateoimpor.getId()!=null){
					if(tipoprorrateoimporAux.getId().equals(tipoprorrateoimpor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoProrrateoImpor(List<TipoProrrateoImpor> tipoprorrateoimpors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoProrrateoImpor tipoprorrateoimpor: tipoprorrateoimpors) {			
			if(tipoprorrateoimpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoProrrateoImpor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoProrrateoImporConstantesFunciones.LABEL_ID, TipoProrrateoImporConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProrrateoImporConstantesFunciones.LABEL_VERSIONROW, TipoProrrateoImporConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProrrateoImporConstantesFunciones.LABEL_CODIGO, TipoProrrateoImporConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProrrateoImporConstantesFunciones.LABEL_NOMBRE, TipoProrrateoImporConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoProrrateoImpor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoProrrateoImporConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProrrateoImporConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProrrateoImporConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProrrateoImporConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProrrateoImpor() throws Exception  {
		return TipoProrrateoImporConstantesFunciones.getTiposSeleccionarTipoProrrateoImpor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProrrateoImpor(Boolean conFk) throws Exception  {
		return TipoProrrateoImporConstantesFunciones.getTiposSeleccionarTipoProrrateoImpor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProrrateoImpor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProrrateoImporConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoProrrateoImporConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProrrateoImporConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoProrrateoImporConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoProrrateoImpor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoProrrateoImpor(TipoProrrateoImpor tipoprorrateoimporAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoProrrateoImpor(List<TipoProrrateoImpor> tipoprorrateoimporsTemp) throws Exception {
		for(TipoProrrateoImpor tipoprorrateoimporAux:tipoprorrateoimporsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoProrrateoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoProrrateoImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProrrateoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoProrrateoImporConstantesFunciones.getClassesRelationshipsOfTipoProrrateoImpor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProrrateoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoProrrateoImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoProrrateoImporConstantesFunciones.getClassesRelationshipsFromStringsOfTipoProrrateoImpor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoProrrateoImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoProrrateoImpor tipoprorrateoimpor,List<TipoProrrateoImpor> tipoprorrateoimpors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoProrrateoImpor tipoprorrateoimporEncontrado=null;
			
			for(TipoProrrateoImpor tipoprorrateoimporLocal:tipoprorrateoimpors) {
				if(tipoprorrateoimporLocal.getId().equals(tipoprorrateoimpor.getId())) {
					tipoprorrateoimporEncontrado=tipoprorrateoimporLocal;
					
					tipoprorrateoimporLocal.setIsChanged(tipoprorrateoimpor.getIsChanged());
					tipoprorrateoimporLocal.setIsNew(tipoprorrateoimpor.getIsNew());
					tipoprorrateoimporLocal.setIsDeleted(tipoprorrateoimpor.getIsDeleted());
					
					tipoprorrateoimporLocal.setGeneralEntityOriginal(tipoprorrateoimpor.getGeneralEntityOriginal());
					
					tipoprorrateoimporLocal.setId(tipoprorrateoimpor.getId());	
					tipoprorrateoimporLocal.setVersionRow(tipoprorrateoimpor.getVersionRow());	
					tipoprorrateoimporLocal.setcodigo(tipoprorrateoimpor.getcodigo());	
					tipoprorrateoimporLocal.setnombre(tipoprorrateoimpor.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoprorrateoimpor.getIsDeleted()) {
				if(!existe) {
					tipoprorrateoimpors.add(tipoprorrateoimpor);
				}
			} else {
				if(tipoprorrateoimporEncontrado!=null && permiteQuitar)  {
					tipoprorrateoimpors.remove(tipoprorrateoimporEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoProrrateoImpor tipoprorrateoimpor,List<TipoProrrateoImpor> tipoprorrateoimpors) throws Exception {
		try	{			
			for(TipoProrrateoImpor tipoprorrateoimporLocal:tipoprorrateoimpors) {
				if(tipoprorrateoimporLocal.getId().equals(tipoprorrateoimpor.getId())) {
					tipoprorrateoimporLocal.setIsSelected(tipoprorrateoimpor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoProrrateoImpor(List<TipoProrrateoImpor> tipoprorrateoimporsAux) throws Exception {
		//this.tipoprorrateoimporsAux=tipoprorrateoimporsAux;
		
		for(TipoProrrateoImpor tipoprorrateoimporAux:tipoprorrateoimporsAux) {
			if(tipoprorrateoimporAux.getIsChanged()) {
				tipoprorrateoimporAux.setIsChanged(false);
			}		
			
			if(tipoprorrateoimporAux.getIsNew()) {
				tipoprorrateoimporAux.setIsNew(false);
			}	
			
			if(tipoprorrateoimporAux.getIsDeleted()) {
				tipoprorrateoimporAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoProrrateoImpor(TipoProrrateoImpor tipoprorrateoimporAux) throws Exception {
		//this.tipoprorrateoimporAux=tipoprorrateoimporAux;
		
			if(tipoprorrateoimporAux.getIsChanged()) {
				tipoprorrateoimporAux.setIsChanged(false);
			}		
			
			if(tipoprorrateoimporAux.getIsNew()) {
				tipoprorrateoimporAux.setIsNew(false);
			}	
			
			if(tipoprorrateoimporAux.getIsDeleted()) {
				tipoprorrateoimporAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoProrrateoImpor tipoprorrateoimporAsignar,TipoProrrateoImpor tipoprorrateoimpor) throws Exception {
		tipoprorrateoimporAsignar.setId(tipoprorrateoimpor.getId());	
		tipoprorrateoimporAsignar.setVersionRow(tipoprorrateoimpor.getVersionRow());	
		tipoprorrateoimporAsignar.setcodigo(tipoprorrateoimpor.getcodigo());	
		tipoprorrateoimporAsignar.setnombre(tipoprorrateoimpor.getnombre());	
	}
	
	public static void inicializarTipoProrrateoImpor(TipoProrrateoImpor tipoprorrateoimpor) throws Exception {
		try {
				tipoprorrateoimpor.setId(0L);	
					
				tipoprorrateoimpor.setcodigo("");	
				tipoprorrateoimpor.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoProrrateoImpor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProrrateoImporConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProrrateoImporConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoProrrateoImpor(String sTipo,Row row,Workbook workbook,TipoProrrateoImpor tipoprorrateoimpor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprorrateoimpor.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprorrateoimpor.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoProrrateoImpor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoProrrateoImpor() {
		return this.sFinalQueryTipoProrrateoImpor;
	}
	
	public void setsFinalQueryTipoProrrateoImpor(String sFinalQueryTipoProrrateoImpor) {
		this.sFinalQueryTipoProrrateoImpor= sFinalQueryTipoProrrateoImpor;
	}
	
	public Border resaltarSeleccionarTipoProrrateoImpor=null;
	
	public Border setResaltarSeleccionarTipoProrrateoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProrrateoImporBeanSwingJInternalFrame tipoprorrateoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoprorrateoimporBeanSwingJInternalFrame.jTtoolBarTipoProrrateoImpor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoProrrateoImpor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoProrrateoImpor() {
		return this.resaltarSeleccionarTipoProrrateoImpor;
	}
	
	public void setResaltarSeleccionarTipoProrrateoImpor(Border borderResaltarSeleccionarTipoProrrateoImpor) {
		this.resaltarSeleccionarTipoProrrateoImpor= borderResaltarSeleccionarTipoProrrateoImpor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoProrrateoImpor=null;
	public Boolean mostraridTipoProrrateoImpor=true;
	public Boolean activaridTipoProrrateoImpor=true;

	public Border resaltarcodigoTipoProrrateoImpor=null;
	public Boolean mostrarcodigoTipoProrrateoImpor=true;
	public Boolean activarcodigoTipoProrrateoImpor=true;

	public Border resaltarnombreTipoProrrateoImpor=null;
	public Boolean mostrarnombreTipoProrrateoImpor=true;
	public Boolean activarnombreTipoProrrateoImpor=true;

	
	

	public Border setResaltaridTipoProrrateoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProrrateoImporBeanSwingJInternalFrame tipoprorrateoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprorrateoimporBeanSwingJInternalFrame.jTtoolBarTipoProrrateoImpor.setBorder(borderResaltar);
		
		this.resaltaridTipoProrrateoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoProrrateoImpor() {
		return this.resaltaridTipoProrrateoImpor;
	}

	public void setResaltaridTipoProrrateoImpor(Border borderResaltar) {
		this.resaltaridTipoProrrateoImpor= borderResaltar;
	}

	public Boolean getMostraridTipoProrrateoImpor() {
		return this.mostraridTipoProrrateoImpor;
	}

	public void setMostraridTipoProrrateoImpor(Boolean mostraridTipoProrrateoImpor) {
		this.mostraridTipoProrrateoImpor= mostraridTipoProrrateoImpor;
	}

	public Boolean getActivaridTipoProrrateoImpor() {
		return this.activaridTipoProrrateoImpor;
	}

	public void setActivaridTipoProrrateoImpor(Boolean activaridTipoProrrateoImpor) {
		this.activaridTipoProrrateoImpor= activaridTipoProrrateoImpor;
	}

	public Border setResaltarcodigoTipoProrrateoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProrrateoImporBeanSwingJInternalFrame tipoprorrateoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprorrateoimporBeanSwingJInternalFrame.jTtoolBarTipoProrrateoImpor.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoProrrateoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoProrrateoImpor() {
		return this.resaltarcodigoTipoProrrateoImpor;
	}

	public void setResaltarcodigoTipoProrrateoImpor(Border borderResaltar) {
		this.resaltarcodigoTipoProrrateoImpor= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoProrrateoImpor() {
		return this.mostrarcodigoTipoProrrateoImpor;
	}

	public void setMostrarcodigoTipoProrrateoImpor(Boolean mostrarcodigoTipoProrrateoImpor) {
		this.mostrarcodigoTipoProrrateoImpor= mostrarcodigoTipoProrrateoImpor;
	}

	public Boolean getActivarcodigoTipoProrrateoImpor() {
		return this.activarcodigoTipoProrrateoImpor;
	}

	public void setActivarcodigoTipoProrrateoImpor(Boolean activarcodigoTipoProrrateoImpor) {
		this.activarcodigoTipoProrrateoImpor= activarcodigoTipoProrrateoImpor;
	}

	public Border setResaltarnombreTipoProrrateoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProrrateoImporBeanSwingJInternalFrame tipoprorrateoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprorrateoimporBeanSwingJInternalFrame.jTtoolBarTipoProrrateoImpor.setBorder(borderResaltar);
		
		this.resaltarnombreTipoProrrateoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoProrrateoImpor() {
		return this.resaltarnombreTipoProrrateoImpor;
	}

	public void setResaltarnombreTipoProrrateoImpor(Border borderResaltar) {
		this.resaltarnombreTipoProrrateoImpor= borderResaltar;
	}

	public Boolean getMostrarnombreTipoProrrateoImpor() {
		return this.mostrarnombreTipoProrrateoImpor;
	}

	public void setMostrarnombreTipoProrrateoImpor(Boolean mostrarnombreTipoProrrateoImpor) {
		this.mostrarnombreTipoProrrateoImpor= mostrarnombreTipoProrrateoImpor;
	}

	public Boolean getActivarnombreTipoProrrateoImpor() {
		return this.activarnombreTipoProrrateoImpor;
	}

	public void setActivarnombreTipoProrrateoImpor(Boolean activarnombreTipoProrrateoImpor) {
		this.activarnombreTipoProrrateoImpor= activarnombreTipoProrrateoImpor;
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
		
		
		this.setMostraridTipoProrrateoImpor(esInicial);
		this.setMostrarcodigoTipoProrrateoImpor(esInicial);
		this.setMostrarnombreTipoProrrateoImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProrrateoImporConstantesFunciones.ID)) {
				this.setMostraridTipoProrrateoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProrrateoImporConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoProrrateoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProrrateoImporConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoProrrateoImpor(esAsigna);
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
		
		
		this.setActivaridTipoProrrateoImpor(esInicial);
		this.setActivarcodigoTipoProrrateoImpor(esInicial);
		this.setActivarnombreTipoProrrateoImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProrrateoImporConstantesFunciones.ID)) {
				this.setActivaridTipoProrrateoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProrrateoImporConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoProrrateoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProrrateoImporConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoProrrateoImpor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoProrrateoImporBeanSwingJInternalFrame tipoprorrateoimporBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoProrrateoImpor(esInicial);
		this.setResaltarcodigoTipoProrrateoImpor(esInicial);
		this.setResaltarnombreTipoProrrateoImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProrrateoImporConstantesFunciones.ID)) {
				this.setResaltaridTipoProrrateoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProrrateoImporConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoProrrateoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProrrateoImporConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoProrrateoImpor(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoProrrateoImporBeanSwingJInternalFrame tipoprorrateoimporBeanSwingJInternalFrame*/)throws Exception {	
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