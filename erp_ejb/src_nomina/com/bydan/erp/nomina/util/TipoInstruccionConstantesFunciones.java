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


import com.bydan.erp.nomina.util.TipoInstruccionConstantesFunciones;
import com.bydan.erp.nomina.util.TipoInstruccionParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoInstruccionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoInstruccionConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoInstruccion";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoInstruccion"+TipoInstruccionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoInstruccionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoInstruccionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoInstruccionConstantesFunciones.SCHEMA+"_"+TipoInstruccionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoInstruccionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoInstruccionConstantesFunciones.SCHEMA+"_"+TipoInstruccionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoInstruccionConstantesFunciones.SCHEMA+"_"+TipoInstruccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoInstruccionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoInstruccionConstantesFunciones.SCHEMA+"_"+TipoInstruccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoInstruccionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoInstruccionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoInstruccionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoInstruccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoInstruccionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoInstruccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoInstruccionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoInstruccionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoInstruccionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoInstruccionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Instrucciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Instruccion";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Instruccion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoInstruccion";
	public static final String OBJECTNAME="tipoinstruccion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_instruccion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoinstruccion from "+TipoInstruccionConstantesFunciones.SPERSISTENCENAME+" tipoinstruccion";
	public static String QUERYSELECTNATIVE="select "+TipoInstruccionConstantesFunciones.SCHEMA+"."+TipoInstruccionConstantesFunciones.TABLENAME+".id,"+TipoInstruccionConstantesFunciones.SCHEMA+"."+TipoInstruccionConstantesFunciones.TABLENAME+".version_row,"+TipoInstruccionConstantesFunciones.SCHEMA+"."+TipoInstruccionConstantesFunciones.TABLENAME+".codigo,"+TipoInstruccionConstantesFunciones.SCHEMA+"."+TipoInstruccionConstantesFunciones.TABLENAME+".nombre from "+TipoInstruccionConstantesFunciones.SCHEMA+"."+TipoInstruccionConstantesFunciones.TABLENAME;//+" as "+TipoInstruccionConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoInstruccionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoInstruccionConstantesFunciones.CODIGO)) {sLabelColumna=TipoInstruccionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoInstruccionConstantesFunciones.NOMBRE)) {sLabelColumna=TipoInstruccionConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoInstruccionDescripcion(TipoInstruccion tipoinstruccion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoinstruccion !=null/* && tipoinstruccion.getId()!=0*/) {
			sDescripcion=tipoinstruccion.getcodigo();//tipoinstrucciontipoinstruccion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoInstruccionDescripcionDetallado(TipoInstruccion tipoinstruccion) {
		String sDescripcion="";
			
		sDescripcion+=TipoInstruccionConstantesFunciones.ID+"=";
		sDescripcion+=tipoinstruccion.getId().toString()+",";
		sDescripcion+=TipoInstruccionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoinstruccion.getVersionRow().toString()+",";
		sDescripcion+=TipoInstruccionConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoinstruccion.getcodigo()+",";
		sDescripcion+=TipoInstruccionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoinstruccion.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoInstruccionDescripcion(TipoInstruccion tipoinstruccion,String sValor) throws Exception {			
		if(tipoinstruccion !=null) {
			tipoinstruccion.setcodigo(sValor);;//tipoinstrucciontipoinstruccion.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoInstruccion(TipoInstruccion tipoinstruccion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoinstruccion.setcodigo(tipoinstruccion.getcodigo().trim());
		tipoinstruccion.setnombre(tipoinstruccion.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoInstruccions(List<TipoInstruccion> tipoinstruccions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoInstruccion tipoinstruccion: tipoinstruccions) {
			tipoinstruccion.setcodigo(tipoinstruccion.getcodigo().trim());
			tipoinstruccion.setnombre(tipoinstruccion.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoInstruccion(TipoInstruccion tipoinstruccion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoinstruccion.getConCambioAuxiliar()) {
			tipoinstruccion.setIsDeleted(tipoinstruccion.getIsDeletedAuxiliar());	
			tipoinstruccion.setIsNew(tipoinstruccion.getIsNewAuxiliar());	
			tipoinstruccion.setIsChanged(tipoinstruccion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoinstruccion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoinstruccion.setIsDeletedAuxiliar(false);	
			tipoinstruccion.setIsNewAuxiliar(false);	
			tipoinstruccion.setIsChangedAuxiliar(false);
			
			tipoinstruccion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoInstruccions(List<TipoInstruccion> tipoinstruccions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoInstruccion tipoinstruccion : tipoinstruccions) {
			if(conAsignarBase && tipoinstruccion.getConCambioAuxiliar()) {
				tipoinstruccion.setIsDeleted(tipoinstruccion.getIsDeletedAuxiliar());	
				tipoinstruccion.setIsNew(tipoinstruccion.getIsNewAuxiliar());	
				tipoinstruccion.setIsChanged(tipoinstruccion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoinstruccion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoinstruccion.setIsDeletedAuxiliar(false);	
				tipoinstruccion.setIsNewAuxiliar(false);	
				tipoinstruccion.setIsChangedAuxiliar(false);
				
				tipoinstruccion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoInstruccion(TipoInstruccion tipoinstruccion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoInstruccions(List<TipoInstruccion> tipoinstruccions,Boolean conEnteros) throws Exception  {
		
		for(TipoInstruccion tipoinstruccion: tipoinstruccions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoInstruccion(List<TipoInstruccion> tipoinstruccions,TipoInstruccion tipoinstruccionAux) throws Exception  {
		TipoInstruccionConstantesFunciones.InicializarValoresTipoInstruccion(tipoinstruccionAux,true);
		
		for(TipoInstruccion tipoinstruccion: tipoinstruccions) {
			if(tipoinstruccion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoInstruccion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoInstruccionConstantesFunciones.getArrayColumnasGlobalesTipoInstruccion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoInstruccion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoInstruccion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoInstruccion> tipoinstruccions,TipoInstruccion tipoinstruccion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoInstruccion tipoinstruccionAux: tipoinstruccions) {
			if(tipoinstruccionAux!=null && tipoinstruccion!=null) {
				if((tipoinstruccionAux.getId()==null && tipoinstruccion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoinstruccionAux.getId()!=null && tipoinstruccion.getId()!=null){
					if(tipoinstruccionAux.getId().equals(tipoinstruccion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoInstruccion(List<TipoInstruccion> tipoinstruccions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoInstruccion tipoinstruccion: tipoinstruccions) {			
			if(tipoinstruccion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoInstruccion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoInstruccionConstantesFunciones.LABEL_ID, TipoInstruccionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoInstruccionConstantesFunciones.LABEL_VERSIONROW, TipoInstruccionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoInstruccionConstantesFunciones.LABEL_CODIGO, TipoInstruccionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoInstruccionConstantesFunciones.LABEL_NOMBRE, TipoInstruccionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoInstruccion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoInstruccionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoInstruccionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoInstruccionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoInstruccionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoInstruccion() throws Exception  {
		return TipoInstruccionConstantesFunciones.getTiposSeleccionarTipoInstruccion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoInstruccion(Boolean conFk) throws Exception  {
		return TipoInstruccionConstantesFunciones.getTiposSeleccionarTipoInstruccion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoInstruccion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoInstruccionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoInstruccionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoInstruccionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoInstruccionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoInstruccion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoInstruccion(TipoInstruccion tipoinstruccionAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoInstruccion(List<TipoInstruccion> tipoinstruccionsTemp) throws Exception {
		for(TipoInstruccion tipoinstruccionAux:tipoinstruccionsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoInstruccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoInstruccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoInstruccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoInstruccionConstantesFunciones.getClassesRelationshipsOfTipoInstruccion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoInstruccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoInstruccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoInstruccionConstantesFunciones.getClassesRelationshipsFromStringsOfTipoInstruccion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoInstruccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
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
	public static void actualizarLista(TipoInstruccion tipoinstruccion,List<TipoInstruccion> tipoinstruccions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoInstruccion tipoinstruccionEncontrado=null;
			
			for(TipoInstruccion tipoinstruccionLocal:tipoinstruccions) {
				if(tipoinstruccionLocal.getId().equals(tipoinstruccion.getId())) {
					tipoinstruccionEncontrado=tipoinstruccionLocal;
					
					tipoinstruccionLocal.setIsChanged(tipoinstruccion.getIsChanged());
					tipoinstruccionLocal.setIsNew(tipoinstruccion.getIsNew());
					tipoinstruccionLocal.setIsDeleted(tipoinstruccion.getIsDeleted());
					
					tipoinstruccionLocal.setGeneralEntityOriginal(tipoinstruccion.getGeneralEntityOriginal());
					
					tipoinstruccionLocal.setId(tipoinstruccion.getId());	
					tipoinstruccionLocal.setVersionRow(tipoinstruccion.getVersionRow());	
					tipoinstruccionLocal.setcodigo(tipoinstruccion.getcodigo());	
					tipoinstruccionLocal.setnombre(tipoinstruccion.getnombre());	
					
					
					tipoinstruccionLocal.setEmpleados(tipoinstruccion.getEmpleados());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoinstruccion.getIsDeleted()) {
				if(!existe) {
					tipoinstruccions.add(tipoinstruccion);
				}
			} else {
				if(tipoinstruccionEncontrado!=null && permiteQuitar)  {
					tipoinstruccions.remove(tipoinstruccionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoInstruccion tipoinstruccion,List<TipoInstruccion> tipoinstruccions) throws Exception {
		try	{			
			for(TipoInstruccion tipoinstruccionLocal:tipoinstruccions) {
				if(tipoinstruccionLocal.getId().equals(tipoinstruccion.getId())) {
					tipoinstruccionLocal.setIsSelected(tipoinstruccion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoInstruccion(List<TipoInstruccion> tipoinstruccionsAux) throws Exception {
		//this.tipoinstruccionsAux=tipoinstruccionsAux;
		
		for(TipoInstruccion tipoinstruccionAux:tipoinstruccionsAux) {
			if(tipoinstruccionAux.getIsChanged()) {
				tipoinstruccionAux.setIsChanged(false);
			}		
			
			if(tipoinstruccionAux.getIsNew()) {
				tipoinstruccionAux.setIsNew(false);
			}	
			
			if(tipoinstruccionAux.getIsDeleted()) {
				tipoinstruccionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoInstruccion(TipoInstruccion tipoinstruccionAux) throws Exception {
		//this.tipoinstruccionAux=tipoinstruccionAux;
		
			if(tipoinstruccionAux.getIsChanged()) {
				tipoinstruccionAux.setIsChanged(false);
			}		
			
			if(tipoinstruccionAux.getIsNew()) {
				tipoinstruccionAux.setIsNew(false);
			}	
			
			if(tipoinstruccionAux.getIsDeleted()) {
				tipoinstruccionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoInstruccion tipoinstruccionAsignar,TipoInstruccion tipoinstruccion) throws Exception {
		tipoinstruccionAsignar.setId(tipoinstruccion.getId());	
		tipoinstruccionAsignar.setVersionRow(tipoinstruccion.getVersionRow());	
		tipoinstruccionAsignar.setcodigo(tipoinstruccion.getcodigo());	
		tipoinstruccionAsignar.setnombre(tipoinstruccion.getnombre());	
	}
	
	public static void inicializarTipoInstruccion(TipoInstruccion tipoinstruccion) throws Exception {
		try {
				tipoinstruccion.setId(0L);	
					
				tipoinstruccion.setcodigo("");	
				tipoinstruccion.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoInstruccion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoInstruccionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoInstruccionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoInstruccion(String sTipo,Row row,Workbook workbook,TipoInstruccion tipoinstruccion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoinstruccion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoinstruccion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoInstruccion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoInstruccion() {
		return this.sFinalQueryTipoInstruccion;
	}
	
	public void setsFinalQueryTipoInstruccion(String sFinalQueryTipoInstruccion) {
		this.sFinalQueryTipoInstruccion= sFinalQueryTipoInstruccion;
	}
	
	public Border resaltarSeleccionarTipoInstruccion=null;
	
	public Border setResaltarSeleccionarTipoInstruccion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInstruccionBeanSwingJInternalFrame tipoinstruccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoinstruccionBeanSwingJInternalFrame.jTtoolBarTipoInstruccion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoInstruccion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoInstruccion() {
		return this.resaltarSeleccionarTipoInstruccion;
	}
	
	public void setResaltarSeleccionarTipoInstruccion(Border borderResaltarSeleccionarTipoInstruccion) {
		this.resaltarSeleccionarTipoInstruccion= borderResaltarSeleccionarTipoInstruccion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoInstruccion=null;
	public Boolean mostraridTipoInstruccion=true;
	public Boolean activaridTipoInstruccion=true;

	public Border resaltarcodigoTipoInstruccion=null;
	public Boolean mostrarcodigoTipoInstruccion=true;
	public Boolean activarcodigoTipoInstruccion=true;

	public Border resaltarnombreTipoInstruccion=null;
	public Boolean mostrarnombreTipoInstruccion=true;
	public Boolean activarnombreTipoInstruccion=true;

	
	

	public Border setResaltaridTipoInstruccion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInstruccionBeanSwingJInternalFrame tipoinstruccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoinstruccionBeanSwingJInternalFrame.jTtoolBarTipoInstruccion.setBorder(borderResaltar);
		
		this.resaltaridTipoInstruccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoInstruccion() {
		return this.resaltaridTipoInstruccion;
	}

	public void setResaltaridTipoInstruccion(Border borderResaltar) {
		this.resaltaridTipoInstruccion= borderResaltar;
	}

	public Boolean getMostraridTipoInstruccion() {
		return this.mostraridTipoInstruccion;
	}

	public void setMostraridTipoInstruccion(Boolean mostraridTipoInstruccion) {
		this.mostraridTipoInstruccion= mostraridTipoInstruccion;
	}

	public Boolean getActivaridTipoInstruccion() {
		return this.activaridTipoInstruccion;
	}

	public void setActivaridTipoInstruccion(Boolean activaridTipoInstruccion) {
		this.activaridTipoInstruccion= activaridTipoInstruccion;
	}

	public Border setResaltarcodigoTipoInstruccion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInstruccionBeanSwingJInternalFrame tipoinstruccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoinstruccionBeanSwingJInternalFrame.jTtoolBarTipoInstruccion.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoInstruccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoInstruccion() {
		return this.resaltarcodigoTipoInstruccion;
	}

	public void setResaltarcodigoTipoInstruccion(Border borderResaltar) {
		this.resaltarcodigoTipoInstruccion= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoInstruccion() {
		return this.mostrarcodigoTipoInstruccion;
	}

	public void setMostrarcodigoTipoInstruccion(Boolean mostrarcodigoTipoInstruccion) {
		this.mostrarcodigoTipoInstruccion= mostrarcodigoTipoInstruccion;
	}

	public Boolean getActivarcodigoTipoInstruccion() {
		return this.activarcodigoTipoInstruccion;
	}

	public void setActivarcodigoTipoInstruccion(Boolean activarcodigoTipoInstruccion) {
		this.activarcodigoTipoInstruccion= activarcodigoTipoInstruccion;
	}

	public Border setResaltarnombreTipoInstruccion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInstruccionBeanSwingJInternalFrame tipoinstruccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoinstruccionBeanSwingJInternalFrame.jTtoolBarTipoInstruccion.setBorder(borderResaltar);
		
		this.resaltarnombreTipoInstruccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoInstruccion() {
		return this.resaltarnombreTipoInstruccion;
	}

	public void setResaltarnombreTipoInstruccion(Border borderResaltar) {
		this.resaltarnombreTipoInstruccion= borderResaltar;
	}

	public Boolean getMostrarnombreTipoInstruccion() {
		return this.mostrarnombreTipoInstruccion;
	}

	public void setMostrarnombreTipoInstruccion(Boolean mostrarnombreTipoInstruccion) {
		this.mostrarnombreTipoInstruccion= mostrarnombreTipoInstruccion;
	}

	public Boolean getActivarnombreTipoInstruccion() {
		return this.activarnombreTipoInstruccion;
	}

	public void setActivarnombreTipoInstruccion(Boolean activarnombreTipoInstruccion) {
		this.activarnombreTipoInstruccion= activarnombreTipoInstruccion;
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
		
		
		this.setMostraridTipoInstruccion(esInicial);
		this.setMostrarcodigoTipoInstruccion(esInicial);
		this.setMostrarnombreTipoInstruccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoInstruccionConstantesFunciones.ID)) {
				this.setMostraridTipoInstruccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInstruccionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoInstruccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInstruccionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoInstruccion(esAsigna);
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
		
		
		this.setActivaridTipoInstruccion(esInicial);
		this.setActivarcodigoTipoInstruccion(esInicial);
		this.setActivarnombreTipoInstruccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoInstruccionConstantesFunciones.ID)) {
				this.setActivaridTipoInstruccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInstruccionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoInstruccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInstruccionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoInstruccion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoInstruccionBeanSwingJInternalFrame tipoinstruccionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoInstruccion(esInicial);
		this.setResaltarcodigoTipoInstruccion(esInicial);
		this.setResaltarnombreTipoInstruccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoInstruccionConstantesFunciones.ID)) {
				this.setResaltaridTipoInstruccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInstruccionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoInstruccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInstruccionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoInstruccion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarEmpleadoTipoInstruccion=null;

	public Border getResaltarEmpleadoTipoInstruccion() {
		return this.resaltarEmpleadoTipoInstruccion;
	}

	public void setResaltarEmpleadoTipoInstruccion(Border borderResaltarEmpleado) {
		if(borderResaltarEmpleado!=null) {
			this.resaltarEmpleadoTipoInstruccion= borderResaltarEmpleado;
		}
	}

	public Border setResaltarEmpleadoTipoInstruccion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInstruccionBeanSwingJInternalFrame tipoinstruccionBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoinstruccionBeanSwingJInternalFrame.jTtoolBarTipoInstruccion.setBorder(borderResaltarEmpleado);
			
		this.resaltarEmpleadoTipoInstruccion= borderResaltarEmpleado;

		 return borderResaltarEmpleado;
	}



	public Boolean mostrarEmpleadoTipoInstruccion=true;

	public Boolean getMostrarEmpleadoTipoInstruccion() {
		return this.mostrarEmpleadoTipoInstruccion;
	}

	public void setMostrarEmpleadoTipoInstruccion(Boolean visibilidadResaltarEmpleado) {
		this.mostrarEmpleadoTipoInstruccion= visibilidadResaltarEmpleado;
	}



	public Boolean activarEmpleadoTipoInstruccion=true;

	public Boolean gethabilitarResaltarEmpleadoTipoInstruccion() {
		return this.activarEmpleadoTipoInstruccion;
	}

	public void setActivarEmpleadoTipoInstruccion(Boolean habilitarResaltarEmpleado) {
		this.activarEmpleadoTipoInstruccion= habilitarResaltarEmpleado;
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

		this.setMostrarEmpleadoTipoInstruccion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Empleado.class)) {
				this.setMostrarEmpleadoTipoInstruccion(esAsigna);
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

		this.setActivarEmpleadoTipoInstruccion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Empleado.class)) {
				this.setActivarEmpleadoTipoInstruccion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoInstruccionBeanSwingJInternalFrame tipoinstruccionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarEmpleadoTipoInstruccion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Empleado.class)) {
				this.setResaltarEmpleadoTipoInstruccion(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}