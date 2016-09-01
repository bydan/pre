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


import com.bydan.erp.seguridad.util.TipoFondoControlConstantesFunciones;
import com.bydan.erp.seguridad.util.TipoFondoControlParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.TipoFondoControlParameterGeneral;

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
final public class TipoFondoControlConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoFondoControl";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoFondoControl"+TipoFondoControlConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoFondoControlHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoFondoControlHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoFondoControlConstantesFunciones.SCHEMA+"_"+TipoFondoControlConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoFondoControlHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoFondoControlConstantesFunciones.SCHEMA+"_"+TipoFondoControlConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoFondoControlConstantesFunciones.SCHEMA+"_"+TipoFondoControlConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoFondoControlHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoFondoControlConstantesFunciones.SCHEMA+"_"+TipoFondoControlConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFondoControlConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoFondoControlHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFondoControlConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFondoControlConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoFondoControlHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFondoControlConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoFondoControlConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoFondoControlConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoFondoControlConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoFondoControlConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Fondo Controls";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Fondo Control";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Fondo Control";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoFondoControl";
	public static final String OBJECTNAME="tipofondocontrol";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="tipo_fondo_control";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipofondocontrol from "+TipoFondoControlConstantesFunciones.SPERSISTENCENAME+" tipofondocontrol";
	public static String QUERYSELECTNATIVE="select "+TipoFondoControlConstantesFunciones.SCHEMA+"."+TipoFondoControlConstantesFunciones.TABLENAME+".id,"+TipoFondoControlConstantesFunciones.SCHEMA+"."+TipoFondoControlConstantesFunciones.TABLENAME+".version_row,"+TipoFondoControlConstantesFunciones.SCHEMA+"."+TipoFondoControlConstantesFunciones.TABLENAME+".codigo,"+TipoFondoControlConstantesFunciones.SCHEMA+"."+TipoFondoControlConstantesFunciones.TABLENAME+".nombre from "+TipoFondoControlConstantesFunciones.SCHEMA+"."+TipoFondoControlConstantesFunciones.TABLENAME;//+" as "+TipoFondoControlConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoFondoControlLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoFondoControlConstantesFunciones.CODIGO)) {sLabelColumna=TipoFondoControlConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoFondoControlConstantesFunciones.NOMBRE)) {sLabelColumna=TipoFondoControlConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoFondoControlDescripcion(TipoFondoControl tipofondocontrol) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipofondocontrol !=null/* && tipofondocontrol.getId()!=0*/) {
			sDescripcion=tipofondocontrol.getcodigo();//tipofondocontroltipofondocontrol.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoFondoControlDescripcionDetallado(TipoFondoControl tipofondocontrol) {
		String sDescripcion="";
			
		sDescripcion+=TipoFondoControlConstantesFunciones.ID+"=";
		sDescripcion+=tipofondocontrol.getId().toString()+",";
		sDescripcion+=TipoFondoControlConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipofondocontrol.getVersionRow().toString()+",";
		sDescripcion+=TipoFondoControlConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipofondocontrol.getcodigo()+",";
		sDescripcion+=TipoFondoControlConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipofondocontrol.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoFondoControlDescripcion(TipoFondoControl tipofondocontrol,String sValor) throws Exception {			
		if(tipofondocontrol !=null) {
			tipofondocontrol.setcodigo(sValor);;//tipofondocontroltipofondocontrol.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoFondoControl(TipoFondoControl tipofondocontrol,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipofondocontrol.setcodigo(tipofondocontrol.getcodigo().trim());
		tipofondocontrol.setnombre(tipofondocontrol.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoFondoControls(List<TipoFondoControl> tipofondocontrols,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoFondoControl tipofondocontrol: tipofondocontrols) {
			tipofondocontrol.setcodigo(tipofondocontrol.getcodigo().trim());
			tipofondocontrol.setnombre(tipofondocontrol.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoFondoControl(TipoFondoControl tipofondocontrol,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipofondocontrol.getConCambioAuxiliar()) {
			tipofondocontrol.setIsDeleted(tipofondocontrol.getIsDeletedAuxiliar());	
			tipofondocontrol.setIsNew(tipofondocontrol.getIsNewAuxiliar());	
			tipofondocontrol.setIsChanged(tipofondocontrol.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipofondocontrol.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipofondocontrol.setIsDeletedAuxiliar(false);	
			tipofondocontrol.setIsNewAuxiliar(false);	
			tipofondocontrol.setIsChangedAuxiliar(false);
			
			tipofondocontrol.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoFondoControls(List<TipoFondoControl> tipofondocontrols,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoFondoControl tipofondocontrol : tipofondocontrols) {
			if(conAsignarBase && tipofondocontrol.getConCambioAuxiliar()) {
				tipofondocontrol.setIsDeleted(tipofondocontrol.getIsDeletedAuxiliar());	
				tipofondocontrol.setIsNew(tipofondocontrol.getIsNewAuxiliar());	
				tipofondocontrol.setIsChanged(tipofondocontrol.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipofondocontrol.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipofondocontrol.setIsDeletedAuxiliar(false);	
				tipofondocontrol.setIsNewAuxiliar(false);	
				tipofondocontrol.setIsChangedAuxiliar(false);
				
				tipofondocontrol.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoFondoControl(TipoFondoControl tipofondocontrol,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoFondoControls(List<TipoFondoControl> tipofondocontrols,Boolean conEnteros) throws Exception  {
		
		for(TipoFondoControl tipofondocontrol: tipofondocontrols) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoFondoControl(List<TipoFondoControl> tipofondocontrols,TipoFondoControl tipofondocontrolAux) throws Exception  {
		TipoFondoControlConstantesFunciones.InicializarValoresTipoFondoControl(tipofondocontrolAux,true);
		
		for(TipoFondoControl tipofondocontrol: tipofondocontrols) {
			if(tipofondocontrol.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoFondoControl(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoFondoControlConstantesFunciones.getArrayColumnasGlobalesTipoFondoControl(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoFondoControl(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoFondoControl(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoFondoControl> tipofondocontrols,TipoFondoControl tipofondocontrol,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoFondoControl tipofondocontrolAux: tipofondocontrols) {
			if(tipofondocontrolAux!=null && tipofondocontrol!=null) {
				if((tipofondocontrolAux.getId()==null && tipofondocontrol.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipofondocontrolAux.getId()!=null && tipofondocontrol.getId()!=null){
					if(tipofondocontrolAux.getId().equals(tipofondocontrol.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoFondoControl(List<TipoFondoControl> tipofondocontrols) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoFondoControl tipofondocontrol: tipofondocontrols) {			
			if(tipofondocontrol.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoFondoControl() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoFondoControlConstantesFunciones.LABEL_ID, TipoFondoControlConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFondoControlConstantesFunciones.LABEL_VERSIONROW, TipoFondoControlConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFondoControlConstantesFunciones.LABEL_CODIGO, TipoFondoControlConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFondoControlConstantesFunciones.LABEL_NOMBRE, TipoFondoControlConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoFondoControl() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoFondoControlConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFondoControlConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFondoControlConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFondoControlConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFondoControl() throws Exception  {
		return TipoFondoControlConstantesFunciones.getTiposSeleccionarTipoFondoControl(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFondoControl(Boolean conFk) throws Exception  {
		return TipoFondoControlConstantesFunciones.getTiposSeleccionarTipoFondoControl(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFondoControl(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFondoControlConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoFondoControlConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFondoControlConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoFondoControlConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoFondoControl(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoFondoControl(TipoFondoControl tipofondocontrolAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoFondoControl(List<TipoFondoControl> tipofondocontrolsTemp) throws Exception {
		for(TipoFondoControl tipofondocontrolAux:tipofondocontrolsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoFondoControl(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoFondoControl(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFondoControl(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoFondoControlConstantesFunciones.getClassesRelationshipsOfTipoFondoControl(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFondoControl(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoFondoControl(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoFondoControlConstantesFunciones.getClassesRelationshipsFromStringsOfTipoFondoControl(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoFondoControl(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoFondoControl tipofondocontrol,List<TipoFondoControl> tipofondocontrols,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoFondoControl tipofondocontrolEncontrado=null;
			
			for(TipoFondoControl tipofondocontrolLocal:tipofondocontrols) {
				if(tipofondocontrolLocal.getId().equals(tipofondocontrol.getId())) {
					tipofondocontrolEncontrado=tipofondocontrolLocal;
					
					tipofondocontrolLocal.setIsChanged(tipofondocontrol.getIsChanged());
					tipofondocontrolLocal.setIsNew(tipofondocontrol.getIsNew());
					tipofondocontrolLocal.setIsDeleted(tipofondocontrol.getIsDeleted());
					
					tipofondocontrolLocal.setGeneralEntityOriginal(tipofondocontrol.getGeneralEntityOriginal());
					
					tipofondocontrolLocal.setId(tipofondocontrol.getId());	
					tipofondocontrolLocal.setVersionRow(tipofondocontrol.getVersionRow());	
					tipofondocontrolLocal.setcodigo(tipofondocontrol.getcodigo());	
					tipofondocontrolLocal.setnombre(tipofondocontrol.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipofondocontrol.getIsDeleted()) {
				if(!existe) {
					tipofondocontrols.add(tipofondocontrol);
				}
			} else {
				if(tipofondocontrolEncontrado!=null && permiteQuitar)  {
					tipofondocontrols.remove(tipofondocontrolEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoFondoControl tipofondocontrol,List<TipoFondoControl> tipofondocontrols) throws Exception {
		try	{			
			for(TipoFondoControl tipofondocontrolLocal:tipofondocontrols) {
				if(tipofondocontrolLocal.getId().equals(tipofondocontrol.getId())) {
					tipofondocontrolLocal.setIsSelected(tipofondocontrol.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoFondoControl(List<TipoFondoControl> tipofondocontrolsAux) throws Exception {
		//this.tipofondocontrolsAux=tipofondocontrolsAux;
		
		for(TipoFondoControl tipofondocontrolAux:tipofondocontrolsAux) {
			if(tipofondocontrolAux.getIsChanged()) {
				tipofondocontrolAux.setIsChanged(false);
			}		
			
			if(tipofondocontrolAux.getIsNew()) {
				tipofondocontrolAux.setIsNew(false);
			}	
			
			if(tipofondocontrolAux.getIsDeleted()) {
				tipofondocontrolAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoFondoControl(TipoFondoControl tipofondocontrolAux) throws Exception {
		//this.tipofondocontrolAux=tipofondocontrolAux;
		
			if(tipofondocontrolAux.getIsChanged()) {
				tipofondocontrolAux.setIsChanged(false);
			}		
			
			if(tipofondocontrolAux.getIsNew()) {
				tipofondocontrolAux.setIsNew(false);
			}	
			
			if(tipofondocontrolAux.getIsDeleted()) {
				tipofondocontrolAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoFondoControl tipofondocontrolAsignar,TipoFondoControl tipofondocontrol) throws Exception {
		tipofondocontrolAsignar.setId(tipofondocontrol.getId());	
		tipofondocontrolAsignar.setVersionRow(tipofondocontrol.getVersionRow());	
		tipofondocontrolAsignar.setcodigo(tipofondocontrol.getcodigo());	
		tipofondocontrolAsignar.setnombre(tipofondocontrol.getnombre());	
	}
	
	public static void inicializarTipoFondoControl(TipoFondoControl tipofondocontrol) throws Exception {
		try {
				tipofondocontrol.setId(0L);	
					
				tipofondocontrol.setcodigo("");	
				tipofondocontrol.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoFondoControl(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFondoControlConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFondoControlConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoFondoControl(String sTipo,Row row,Workbook workbook,TipoFondoControl tipofondocontrol,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipofondocontrol.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipofondocontrol.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoFondoControl=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoFondoControl() {
		return this.sFinalQueryTipoFondoControl;
	}
	
	public void setsFinalQueryTipoFondoControl(String sFinalQueryTipoFondoControl) {
		this.sFinalQueryTipoFondoControl= sFinalQueryTipoFondoControl;
	}
	
	public Border resaltarSeleccionarTipoFondoControl=null;
	
	public Border setResaltarSeleccionarTipoFondoControl(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFondoControlBeanSwingJInternalFrame tipofondocontrolBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipofondocontrolBeanSwingJInternalFrame.jTtoolBarTipoFondoControl.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoFondoControl= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoFondoControl() {
		return this.resaltarSeleccionarTipoFondoControl;
	}
	
	public void setResaltarSeleccionarTipoFondoControl(Border borderResaltarSeleccionarTipoFondoControl) {
		this.resaltarSeleccionarTipoFondoControl= borderResaltarSeleccionarTipoFondoControl;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoFondoControl=null;
	public Boolean mostraridTipoFondoControl=true;
	public Boolean activaridTipoFondoControl=true;

	public Border resaltarcodigoTipoFondoControl=null;
	public Boolean mostrarcodigoTipoFondoControl=true;
	public Boolean activarcodigoTipoFondoControl=true;

	public Border resaltarnombreTipoFondoControl=null;
	public Boolean mostrarnombreTipoFondoControl=true;
	public Boolean activarnombreTipoFondoControl=true;

	
	

	public Border setResaltaridTipoFondoControl(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFondoControlBeanSwingJInternalFrame tipofondocontrolBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipofondocontrolBeanSwingJInternalFrame.jTtoolBarTipoFondoControl.setBorder(borderResaltar);
		
		this.resaltaridTipoFondoControl= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoFondoControl() {
		return this.resaltaridTipoFondoControl;
	}

	public void setResaltaridTipoFondoControl(Border borderResaltar) {
		this.resaltaridTipoFondoControl= borderResaltar;
	}

	public Boolean getMostraridTipoFondoControl() {
		return this.mostraridTipoFondoControl;
	}

	public void setMostraridTipoFondoControl(Boolean mostraridTipoFondoControl) {
		this.mostraridTipoFondoControl= mostraridTipoFondoControl;
	}

	public Boolean getActivaridTipoFondoControl() {
		return this.activaridTipoFondoControl;
	}

	public void setActivaridTipoFondoControl(Boolean activaridTipoFondoControl) {
		this.activaridTipoFondoControl= activaridTipoFondoControl;
	}

	public Border setResaltarcodigoTipoFondoControl(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFondoControlBeanSwingJInternalFrame tipofondocontrolBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipofondocontrolBeanSwingJInternalFrame.jTtoolBarTipoFondoControl.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoFondoControl= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoFondoControl() {
		return this.resaltarcodigoTipoFondoControl;
	}

	public void setResaltarcodigoTipoFondoControl(Border borderResaltar) {
		this.resaltarcodigoTipoFondoControl= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoFondoControl() {
		return this.mostrarcodigoTipoFondoControl;
	}

	public void setMostrarcodigoTipoFondoControl(Boolean mostrarcodigoTipoFondoControl) {
		this.mostrarcodigoTipoFondoControl= mostrarcodigoTipoFondoControl;
	}

	public Boolean getActivarcodigoTipoFondoControl() {
		return this.activarcodigoTipoFondoControl;
	}

	public void setActivarcodigoTipoFondoControl(Boolean activarcodigoTipoFondoControl) {
		this.activarcodigoTipoFondoControl= activarcodigoTipoFondoControl;
	}

	public Border setResaltarnombreTipoFondoControl(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFondoControlBeanSwingJInternalFrame tipofondocontrolBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipofondocontrolBeanSwingJInternalFrame.jTtoolBarTipoFondoControl.setBorder(borderResaltar);
		
		this.resaltarnombreTipoFondoControl= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoFondoControl() {
		return this.resaltarnombreTipoFondoControl;
	}

	public void setResaltarnombreTipoFondoControl(Border borderResaltar) {
		this.resaltarnombreTipoFondoControl= borderResaltar;
	}

	public Boolean getMostrarnombreTipoFondoControl() {
		return this.mostrarnombreTipoFondoControl;
	}

	public void setMostrarnombreTipoFondoControl(Boolean mostrarnombreTipoFondoControl) {
		this.mostrarnombreTipoFondoControl= mostrarnombreTipoFondoControl;
	}

	public Boolean getActivarnombreTipoFondoControl() {
		return this.activarnombreTipoFondoControl;
	}

	public void setActivarnombreTipoFondoControl(Boolean activarnombreTipoFondoControl) {
		this.activarnombreTipoFondoControl= activarnombreTipoFondoControl;
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
		
		
		this.setMostraridTipoFondoControl(esInicial);
		this.setMostrarcodigoTipoFondoControl(esInicial);
		this.setMostrarnombreTipoFondoControl(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFondoControlConstantesFunciones.ID)) {
				this.setMostraridTipoFondoControl(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFondoControlConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoFondoControl(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFondoControlConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoFondoControl(esAsigna);
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
		
		
		this.setActivaridTipoFondoControl(esInicial);
		this.setActivarcodigoTipoFondoControl(esInicial);
		this.setActivarnombreTipoFondoControl(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFondoControlConstantesFunciones.ID)) {
				this.setActivaridTipoFondoControl(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFondoControlConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoFondoControl(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFondoControlConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoFondoControl(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoFondoControlBeanSwingJInternalFrame tipofondocontrolBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoFondoControl(esInicial);
		this.setResaltarcodigoTipoFondoControl(esInicial);
		this.setResaltarnombreTipoFondoControl(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFondoControlConstantesFunciones.ID)) {
				this.setResaltaridTipoFondoControl(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFondoControlConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoFondoControl(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFondoControlConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoFondoControl(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoFondoControlBeanSwingJInternalFrame tipofondocontrolBeanSwingJInternalFrame*/)throws Exception {	
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