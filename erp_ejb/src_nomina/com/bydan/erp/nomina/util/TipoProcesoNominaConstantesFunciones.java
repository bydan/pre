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


import com.bydan.erp.nomina.util.TipoProcesoNominaConstantesFunciones;
import com.bydan.erp.nomina.util.TipoProcesoNominaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoProcesoNominaParameterGeneral;

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
final public class TipoProcesoNominaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoProcesoNomina";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoProcesoNomina"+TipoProcesoNominaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoProcesoNominaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoProcesoNominaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoProcesoNominaConstantesFunciones.SCHEMA+"_"+TipoProcesoNominaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoProcesoNominaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoProcesoNominaConstantesFunciones.SCHEMA+"_"+TipoProcesoNominaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoProcesoNominaConstantesFunciones.SCHEMA+"_"+TipoProcesoNominaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoProcesoNominaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoProcesoNominaConstantesFunciones.SCHEMA+"_"+TipoProcesoNominaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProcesoNominaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoProcesoNominaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProcesoNominaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProcesoNominaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoProcesoNominaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProcesoNominaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoProcesoNominaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoProcesoNominaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoProcesoNominaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoProcesoNominaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Proceso Nominaes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Proceso Nomina";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Proceso Nomina";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoProcesoNomina";
	public static final String OBJECTNAME="tipoprocesonomina";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_proceso_nomina";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoprocesonomina from "+TipoProcesoNominaConstantesFunciones.SPERSISTENCENAME+" tipoprocesonomina";
	public static String QUERYSELECTNATIVE="select "+TipoProcesoNominaConstantesFunciones.SCHEMA+"."+TipoProcesoNominaConstantesFunciones.TABLENAME+".id,"+TipoProcesoNominaConstantesFunciones.SCHEMA+"."+TipoProcesoNominaConstantesFunciones.TABLENAME+".version_row,"+TipoProcesoNominaConstantesFunciones.SCHEMA+"."+TipoProcesoNominaConstantesFunciones.TABLENAME+".codigo,"+TipoProcesoNominaConstantesFunciones.SCHEMA+"."+TipoProcesoNominaConstantesFunciones.TABLENAME+".nombre from "+TipoProcesoNominaConstantesFunciones.SCHEMA+"."+TipoProcesoNominaConstantesFunciones.TABLENAME;//+" as "+TipoProcesoNominaConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoProcesoNominaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoProcesoNominaConstantesFunciones.CODIGO)) {sLabelColumna=TipoProcesoNominaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoProcesoNominaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoProcesoNominaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoProcesoNominaDescripcion(TipoProcesoNomina tipoprocesonomina) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoprocesonomina !=null/* && tipoprocesonomina.getId()!=0*/) {
			sDescripcion=tipoprocesonomina.getcodigo();//tipoprocesonominatipoprocesonomina.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoProcesoNominaDescripcionDetallado(TipoProcesoNomina tipoprocesonomina) {
		String sDescripcion="";
			
		sDescripcion+=TipoProcesoNominaConstantesFunciones.ID+"=";
		sDescripcion+=tipoprocesonomina.getId().toString()+",";
		sDescripcion+=TipoProcesoNominaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoprocesonomina.getVersionRow().toString()+",";
		sDescripcion+=TipoProcesoNominaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoprocesonomina.getcodigo()+",";
		sDescripcion+=TipoProcesoNominaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoprocesonomina.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoProcesoNominaDescripcion(TipoProcesoNomina tipoprocesonomina,String sValor) throws Exception {			
		if(tipoprocesonomina !=null) {
			tipoprocesonomina.setcodigo(sValor);;//tipoprocesonominatipoprocesonomina.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoProcesoNomina(TipoProcesoNomina tipoprocesonomina,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoprocesonomina.setcodigo(tipoprocesonomina.getcodigo().trim());
		tipoprocesonomina.setnombre(tipoprocesonomina.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoProcesoNominas(List<TipoProcesoNomina> tipoprocesonominas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoProcesoNomina tipoprocesonomina: tipoprocesonominas) {
			tipoprocesonomina.setcodigo(tipoprocesonomina.getcodigo().trim());
			tipoprocesonomina.setnombre(tipoprocesonomina.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoProcesoNomina(TipoProcesoNomina tipoprocesonomina,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoprocesonomina.getConCambioAuxiliar()) {
			tipoprocesonomina.setIsDeleted(tipoprocesonomina.getIsDeletedAuxiliar());	
			tipoprocesonomina.setIsNew(tipoprocesonomina.getIsNewAuxiliar());	
			tipoprocesonomina.setIsChanged(tipoprocesonomina.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoprocesonomina.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoprocesonomina.setIsDeletedAuxiliar(false);	
			tipoprocesonomina.setIsNewAuxiliar(false);	
			tipoprocesonomina.setIsChangedAuxiliar(false);
			
			tipoprocesonomina.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoProcesoNominas(List<TipoProcesoNomina> tipoprocesonominas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoProcesoNomina tipoprocesonomina : tipoprocesonominas) {
			if(conAsignarBase && tipoprocesonomina.getConCambioAuxiliar()) {
				tipoprocesonomina.setIsDeleted(tipoprocesonomina.getIsDeletedAuxiliar());	
				tipoprocesonomina.setIsNew(tipoprocesonomina.getIsNewAuxiliar());	
				tipoprocesonomina.setIsChanged(tipoprocesonomina.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoprocesonomina.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoprocesonomina.setIsDeletedAuxiliar(false);	
				tipoprocesonomina.setIsNewAuxiliar(false);	
				tipoprocesonomina.setIsChangedAuxiliar(false);
				
				tipoprocesonomina.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoProcesoNomina(TipoProcesoNomina tipoprocesonomina,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoProcesoNominas(List<TipoProcesoNomina> tipoprocesonominas,Boolean conEnteros) throws Exception  {
		
		for(TipoProcesoNomina tipoprocesonomina: tipoprocesonominas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoProcesoNomina(List<TipoProcesoNomina> tipoprocesonominas,TipoProcesoNomina tipoprocesonominaAux) throws Exception  {
		TipoProcesoNominaConstantesFunciones.InicializarValoresTipoProcesoNomina(tipoprocesonominaAux,true);
		
		for(TipoProcesoNomina tipoprocesonomina: tipoprocesonominas) {
			if(tipoprocesonomina.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoProcesoNomina(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoProcesoNominaConstantesFunciones.getArrayColumnasGlobalesTipoProcesoNomina(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoProcesoNomina(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoProcesoNomina(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoProcesoNomina> tipoprocesonominas,TipoProcesoNomina tipoprocesonomina,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoProcesoNomina tipoprocesonominaAux: tipoprocesonominas) {
			if(tipoprocesonominaAux!=null && tipoprocesonomina!=null) {
				if((tipoprocesonominaAux.getId()==null && tipoprocesonomina.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoprocesonominaAux.getId()!=null && tipoprocesonomina.getId()!=null){
					if(tipoprocesonominaAux.getId().equals(tipoprocesonomina.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoProcesoNomina(List<TipoProcesoNomina> tipoprocesonominas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoProcesoNomina tipoprocesonomina: tipoprocesonominas) {			
			if(tipoprocesonomina.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoProcesoNomina() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoProcesoNominaConstantesFunciones.LABEL_ID, TipoProcesoNominaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProcesoNominaConstantesFunciones.LABEL_VERSIONROW, TipoProcesoNominaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProcesoNominaConstantesFunciones.LABEL_CODIGO, TipoProcesoNominaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProcesoNominaConstantesFunciones.LABEL_NOMBRE, TipoProcesoNominaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoProcesoNomina() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoProcesoNominaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProcesoNominaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProcesoNominaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProcesoNominaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProcesoNomina() throws Exception  {
		return TipoProcesoNominaConstantesFunciones.getTiposSeleccionarTipoProcesoNomina(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProcesoNomina(Boolean conFk) throws Exception  {
		return TipoProcesoNominaConstantesFunciones.getTiposSeleccionarTipoProcesoNomina(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProcesoNomina(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProcesoNominaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoProcesoNominaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProcesoNominaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoProcesoNominaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoProcesoNomina(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoProcesoNomina(TipoProcesoNomina tipoprocesonominaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoProcesoNomina(List<TipoProcesoNomina> tipoprocesonominasTemp) throws Exception {
		for(TipoProcesoNomina tipoprocesonominaAux:tipoprocesonominasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoProcesoNomina(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoProcesoNomina(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProcesoNomina(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoProcesoNominaConstantesFunciones.getClassesRelationshipsOfTipoProcesoNomina(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProcesoNomina(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoProcesoNomina(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoProcesoNominaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoProcesoNomina(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoProcesoNomina(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoProcesoNomina tipoprocesonomina,List<TipoProcesoNomina> tipoprocesonominas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoProcesoNomina tipoprocesonominaEncontrado=null;
			
			for(TipoProcesoNomina tipoprocesonominaLocal:tipoprocesonominas) {
				if(tipoprocesonominaLocal.getId().equals(tipoprocesonomina.getId())) {
					tipoprocesonominaEncontrado=tipoprocesonominaLocal;
					
					tipoprocesonominaLocal.setIsChanged(tipoprocesonomina.getIsChanged());
					tipoprocesonominaLocal.setIsNew(tipoprocesonomina.getIsNew());
					tipoprocesonominaLocal.setIsDeleted(tipoprocesonomina.getIsDeleted());
					
					tipoprocesonominaLocal.setGeneralEntityOriginal(tipoprocesonomina.getGeneralEntityOriginal());
					
					tipoprocesonominaLocal.setId(tipoprocesonomina.getId());	
					tipoprocesonominaLocal.setVersionRow(tipoprocesonomina.getVersionRow());	
					tipoprocesonominaLocal.setcodigo(tipoprocesonomina.getcodigo());	
					tipoprocesonominaLocal.setnombre(tipoprocesonomina.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoprocesonomina.getIsDeleted()) {
				if(!existe) {
					tipoprocesonominas.add(tipoprocesonomina);
				}
			} else {
				if(tipoprocesonominaEncontrado!=null && permiteQuitar)  {
					tipoprocesonominas.remove(tipoprocesonominaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoProcesoNomina tipoprocesonomina,List<TipoProcesoNomina> tipoprocesonominas) throws Exception {
		try	{			
			for(TipoProcesoNomina tipoprocesonominaLocal:tipoprocesonominas) {
				if(tipoprocesonominaLocal.getId().equals(tipoprocesonomina.getId())) {
					tipoprocesonominaLocal.setIsSelected(tipoprocesonomina.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoProcesoNomina(List<TipoProcesoNomina> tipoprocesonominasAux) throws Exception {
		//this.tipoprocesonominasAux=tipoprocesonominasAux;
		
		for(TipoProcesoNomina tipoprocesonominaAux:tipoprocesonominasAux) {
			if(tipoprocesonominaAux.getIsChanged()) {
				tipoprocesonominaAux.setIsChanged(false);
			}		
			
			if(tipoprocesonominaAux.getIsNew()) {
				tipoprocesonominaAux.setIsNew(false);
			}	
			
			if(tipoprocesonominaAux.getIsDeleted()) {
				tipoprocesonominaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoProcesoNomina(TipoProcesoNomina tipoprocesonominaAux) throws Exception {
		//this.tipoprocesonominaAux=tipoprocesonominaAux;
		
			if(tipoprocesonominaAux.getIsChanged()) {
				tipoprocesonominaAux.setIsChanged(false);
			}		
			
			if(tipoprocesonominaAux.getIsNew()) {
				tipoprocesonominaAux.setIsNew(false);
			}	
			
			if(tipoprocesonominaAux.getIsDeleted()) {
				tipoprocesonominaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoProcesoNomina tipoprocesonominaAsignar,TipoProcesoNomina tipoprocesonomina) throws Exception {
		tipoprocesonominaAsignar.setId(tipoprocesonomina.getId());	
		tipoprocesonominaAsignar.setVersionRow(tipoprocesonomina.getVersionRow());	
		tipoprocesonominaAsignar.setcodigo(tipoprocesonomina.getcodigo());	
		tipoprocesonominaAsignar.setnombre(tipoprocesonomina.getnombre());	
	}
	
	public static void inicializarTipoProcesoNomina(TipoProcesoNomina tipoprocesonomina) throws Exception {
		try {
				tipoprocesonomina.setId(0L);	
					
				tipoprocesonomina.setcodigo("");	
				tipoprocesonomina.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoProcesoNomina(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProcesoNominaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProcesoNominaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoProcesoNomina(String sTipo,Row row,Workbook workbook,TipoProcesoNomina tipoprocesonomina,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprocesonomina.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprocesonomina.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoProcesoNomina=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoProcesoNomina() {
		return this.sFinalQueryTipoProcesoNomina;
	}
	
	public void setsFinalQueryTipoProcesoNomina(String sFinalQueryTipoProcesoNomina) {
		this.sFinalQueryTipoProcesoNomina= sFinalQueryTipoProcesoNomina;
	}
	
	public Border resaltarSeleccionarTipoProcesoNomina=null;
	
	public Border setResaltarSeleccionarTipoProcesoNomina(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProcesoNominaBeanSwingJInternalFrame tipoprocesonominaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoprocesonominaBeanSwingJInternalFrame.jTtoolBarTipoProcesoNomina.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoProcesoNomina= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoProcesoNomina() {
		return this.resaltarSeleccionarTipoProcesoNomina;
	}
	
	public void setResaltarSeleccionarTipoProcesoNomina(Border borderResaltarSeleccionarTipoProcesoNomina) {
		this.resaltarSeleccionarTipoProcesoNomina= borderResaltarSeleccionarTipoProcesoNomina;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoProcesoNomina=null;
	public Boolean mostraridTipoProcesoNomina=true;
	public Boolean activaridTipoProcesoNomina=true;

	public Border resaltarcodigoTipoProcesoNomina=null;
	public Boolean mostrarcodigoTipoProcesoNomina=true;
	public Boolean activarcodigoTipoProcesoNomina=true;

	public Border resaltarnombreTipoProcesoNomina=null;
	public Boolean mostrarnombreTipoProcesoNomina=true;
	public Boolean activarnombreTipoProcesoNomina=true;

	
	

	public Border setResaltaridTipoProcesoNomina(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProcesoNominaBeanSwingJInternalFrame tipoprocesonominaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprocesonominaBeanSwingJInternalFrame.jTtoolBarTipoProcesoNomina.setBorder(borderResaltar);
		
		this.resaltaridTipoProcesoNomina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoProcesoNomina() {
		return this.resaltaridTipoProcesoNomina;
	}

	public void setResaltaridTipoProcesoNomina(Border borderResaltar) {
		this.resaltaridTipoProcesoNomina= borderResaltar;
	}

	public Boolean getMostraridTipoProcesoNomina() {
		return this.mostraridTipoProcesoNomina;
	}

	public void setMostraridTipoProcesoNomina(Boolean mostraridTipoProcesoNomina) {
		this.mostraridTipoProcesoNomina= mostraridTipoProcesoNomina;
	}

	public Boolean getActivaridTipoProcesoNomina() {
		return this.activaridTipoProcesoNomina;
	}

	public void setActivaridTipoProcesoNomina(Boolean activaridTipoProcesoNomina) {
		this.activaridTipoProcesoNomina= activaridTipoProcesoNomina;
	}

	public Border setResaltarcodigoTipoProcesoNomina(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProcesoNominaBeanSwingJInternalFrame tipoprocesonominaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprocesonominaBeanSwingJInternalFrame.jTtoolBarTipoProcesoNomina.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoProcesoNomina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoProcesoNomina() {
		return this.resaltarcodigoTipoProcesoNomina;
	}

	public void setResaltarcodigoTipoProcesoNomina(Border borderResaltar) {
		this.resaltarcodigoTipoProcesoNomina= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoProcesoNomina() {
		return this.mostrarcodigoTipoProcesoNomina;
	}

	public void setMostrarcodigoTipoProcesoNomina(Boolean mostrarcodigoTipoProcesoNomina) {
		this.mostrarcodigoTipoProcesoNomina= mostrarcodigoTipoProcesoNomina;
	}

	public Boolean getActivarcodigoTipoProcesoNomina() {
		return this.activarcodigoTipoProcesoNomina;
	}

	public void setActivarcodigoTipoProcesoNomina(Boolean activarcodigoTipoProcesoNomina) {
		this.activarcodigoTipoProcesoNomina= activarcodigoTipoProcesoNomina;
	}

	public Border setResaltarnombreTipoProcesoNomina(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProcesoNominaBeanSwingJInternalFrame tipoprocesonominaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprocesonominaBeanSwingJInternalFrame.jTtoolBarTipoProcesoNomina.setBorder(borderResaltar);
		
		this.resaltarnombreTipoProcesoNomina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoProcesoNomina() {
		return this.resaltarnombreTipoProcesoNomina;
	}

	public void setResaltarnombreTipoProcesoNomina(Border borderResaltar) {
		this.resaltarnombreTipoProcesoNomina= borderResaltar;
	}

	public Boolean getMostrarnombreTipoProcesoNomina() {
		return this.mostrarnombreTipoProcesoNomina;
	}

	public void setMostrarnombreTipoProcesoNomina(Boolean mostrarnombreTipoProcesoNomina) {
		this.mostrarnombreTipoProcesoNomina= mostrarnombreTipoProcesoNomina;
	}

	public Boolean getActivarnombreTipoProcesoNomina() {
		return this.activarnombreTipoProcesoNomina;
	}

	public void setActivarnombreTipoProcesoNomina(Boolean activarnombreTipoProcesoNomina) {
		this.activarnombreTipoProcesoNomina= activarnombreTipoProcesoNomina;
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
		
		
		this.setMostraridTipoProcesoNomina(esInicial);
		this.setMostrarcodigoTipoProcesoNomina(esInicial);
		this.setMostrarnombreTipoProcesoNomina(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProcesoNominaConstantesFunciones.ID)) {
				this.setMostraridTipoProcesoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoNominaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoProcesoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoNominaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoProcesoNomina(esAsigna);
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
		
		
		this.setActivaridTipoProcesoNomina(esInicial);
		this.setActivarcodigoTipoProcesoNomina(esInicial);
		this.setActivarnombreTipoProcesoNomina(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProcesoNominaConstantesFunciones.ID)) {
				this.setActivaridTipoProcesoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoNominaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoProcesoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoNominaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoProcesoNomina(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoProcesoNominaBeanSwingJInternalFrame tipoprocesonominaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoProcesoNomina(esInicial);
		this.setResaltarcodigoTipoProcesoNomina(esInicial);
		this.setResaltarnombreTipoProcesoNomina(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProcesoNominaConstantesFunciones.ID)) {
				this.setResaltaridTipoProcesoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoNominaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoProcesoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoNominaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoProcesoNomina(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoProcesoNominaBeanSwingJInternalFrame tipoprocesonominaBeanSwingJInternalFrame*/)throws Exception {	
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