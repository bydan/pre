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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.TipoViaTransporteConstantesFunciones;
import com.bydan.erp.cartera.util.TipoViaTransporteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoViaTransporteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.comisiones.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoViaTransporteConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoViaTransporte";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoViaTransporte"+TipoViaTransporteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoViaTransporteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoViaTransporteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoViaTransporteConstantesFunciones.SCHEMA+"_"+TipoViaTransporteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoViaTransporteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoViaTransporteConstantesFunciones.SCHEMA+"_"+TipoViaTransporteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoViaTransporteConstantesFunciones.SCHEMA+"_"+TipoViaTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoViaTransporteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoViaTransporteConstantesFunciones.SCHEMA+"_"+TipoViaTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoViaTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoViaTransporteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoViaTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoViaTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoViaTransporteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoViaTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoViaTransporteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoViaTransporteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoViaTransporteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoViaTransporteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Via Transportes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Via Transporte";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Via Transporte";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoViaTransporte";
	public static final String OBJECTNAME="tipoviatransporte";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_via_transporte";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoviatransporte from "+TipoViaTransporteConstantesFunciones.SPERSISTENCENAME+" tipoviatransporte";
	public static String QUERYSELECTNATIVE="select "+TipoViaTransporteConstantesFunciones.SCHEMA+"."+TipoViaTransporteConstantesFunciones.TABLENAME+".id,"+TipoViaTransporteConstantesFunciones.SCHEMA+"."+TipoViaTransporteConstantesFunciones.TABLENAME+".version_row,"+TipoViaTransporteConstantesFunciones.SCHEMA+"."+TipoViaTransporteConstantesFunciones.TABLENAME+".nombre from "+TipoViaTransporteConstantesFunciones.SCHEMA+"."+TipoViaTransporteConstantesFunciones.TABLENAME;//+" as "+TipoViaTransporteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoViaTransporteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoViaTransporteConstantesFunciones.NOMBRE)) {sLabelColumna=TipoViaTransporteConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getTipoViaTransporteDescripcion(TipoViaTransporte tipoviatransporte) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoviatransporte !=null/* && tipoviatransporte.getId()!=0*/) {
			sDescripcion=tipoviatransporte.getnombre();//tipoviatransportetipoviatransporte.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoViaTransporteDescripcionDetallado(TipoViaTransporte tipoviatransporte) {
		String sDescripcion="";
			
		sDescripcion+=TipoViaTransporteConstantesFunciones.ID+"=";
		sDescripcion+=tipoviatransporte.getId().toString()+",";
		sDescripcion+=TipoViaTransporteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoviatransporte.getVersionRow().toString()+",";
		sDescripcion+=TipoViaTransporteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoviatransporte.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoViaTransporteDescripcion(TipoViaTransporte tipoviatransporte,String sValor) throws Exception {			
		if(tipoviatransporte !=null) {
			tipoviatransporte.setnombre(sValor);//tipoviatransportetipoviatransporte.getId().toString();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("PorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndicePorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoViaTransporte(TipoViaTransporte tipoviatransporte,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoviatransporte.setnombre(tipoviatransporte.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoViaTransportes(List<TipoViaTransporte> tipoviatransportes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoViaTransporte tipoviatransporte: tipoviatransportes) {
			tipoviatransporte.setnombre(tipoviatransporte.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoViaTransporte(TipoViaTransporte tipoviatransporte,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoviatransporte.getConCambioAuxiliar()) {
			tipoviatransporte.setIsDeleted(tipoviatransporte.getIsDeletedAuxiliar());	
			tipoviatransporte.setIsNew(tipoviatransporte.getIsNewAuxiliar());	
			tipoviatransporte.setIsChanged(tipoviatransporte.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoviatransporte.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoviatransporte.setIsDeletedAuxiliar(false);	
			tipoviatransporte.setIsNewAuxiliar(false);	
			tipoviatransporte.setIsChangedAuxiliar(false);
			
			tipoviatransporte.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoViaTransportes(List<TipoViaTransporte> tipoviatransportes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoViaTransporte tipoviatransporte : tipoviatransportes) {
			if(conAsignarBase && tipoviatransporte.getConCambioAuxiliar()) {
				tipoviatransporte.setIsDeleted(tipoviatransporte.getIsDeletedAuxiliar());	
				tipoviatransporte.setIsNew(tipoviatransporte.getIsNewAuxiliar());	
				tipoviatransporte.setIsChanged(tipoviatransporte.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoviatransporte.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoviatransporte.setIsDeletedAuxiliar(false);	
				tipoviatransporte.setIsNewAuxiliar(false);	
				tipoviatransporte.setIsChangedAuxiliar(false);
				
				tipoviatransporte.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoViaTransporte(TipoViaTransporte tipoviatransporte,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoViaTransportes(List<TipoViaTransporte> tipoviatransportes,Boolean conEnteros) throws Exception  {
		
		for(TipoViaTransporte tipoviatransporte: tipoviatransportes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoViaTransporte(List<TipoViaTransporte> tipoviatransportes,TipoViaTransporte tipoviatransporteAux) throws Exception  {
		TipoViaTransporteConstantesFunciones.InicializarValoresTipoViaTransporte(tipoviatransporteAux,true);
		
		for(TipoViaTransporte tipoviatransporte: tipoviatransportes) {
			if(tipoviatransporte.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoViaTransporte(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoViaTransporteConstantesFunciones.getArrayColumnasGlobalesTipoViaTransporte(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoViaTransporte(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoViaTransporte(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoViaTransporte> tipoviatransportes,TipoViaTransporte tipoviatransporte,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoViaTransporte tipoviatransporteAux: tipoviatransportes) {
			if(tipoviatransporteAux!=null && tipoviatransporte!=null) {
				if((tipoviatransporteAux.getId()==null && tipoviatransporte.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoviatransporteAux.getId()!=null && tipoviatransporte.getId()!=null){
					if(tipoviatransporteAux.getId().equals(tipoviatransporte.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoViaTransporte(List<TipoViaTransporte> tipoviatransportes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoViaTransporte tipoviatransporte: tipoviatransportes) {			
			if(tipoviatransporte.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoViaTransporte() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoViaTransporteConstantesFunciones.LABEL_ID, TipoViaTransporteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoViaTransporteConstantesFunciones.LABEL_VERSIONROW, TipoViaTransporteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoViaTransporteConstantesFunciones.LABEL_NOMBRE, TipoViaTransporteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoViaTransporte() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoViaTransporteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoViaTransporteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoViaTransporteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoViaTransporte() throws Exception  {
		return TipoViaTransporteConstantesFunciones.getTiposSeleccionarTipoViaTransporte(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoViaTransporte(Boolean conFk) throws Exception  {
		return TipoViaTransporteConstantesFunciones.getTiposSeleccionarTipoViaTransporte(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoViaTransporte(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoViaTransporteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoViaTransporteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoViaTransporte(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoViaTransporte(TipoViaTransporte tipoviatransporteAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoViaTransporte(List<TipoViaTransporte> tipoviatransportesTemp) throws Exception {
		for(TipoViaTransporte tipoviatransporteAux:tipoviatransportesTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoViaTransporte(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoViaTransporte(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoViaTransporte(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoViaTransporteConstantesFunciones.getClassesRelationshipsOfTipoViaTransporte(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoViaTransporte(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoViaTransporte(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoViaTransporteConstantesFunciones.getClassesRelationshipsFromStringsOfTipoViaTransporte(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoViaTransporte(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoViaTransporte tipoviatransporte,List<TipoViaTransporte> tipoviatransportes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoViaTransporte tipoviatransporteEncontrado=null;
			
			for(TipoViaTransporte tipoviatransporteLocal:tipoviatransportes) {
				if(tipoviatransporteLocal.getId().equals(tipoviatransporte.getId())) {
					tipoviatransporteEncontrado=tipoviatransporteLocal;
					
					tipoviatransporteLocal.setIsChanged(tipoviatransporte.getIsChanged());
					tipoviatransporteLocal.setIsNew(tipoviatransporte.getIsNew());
					tipoviatransporteLocal.setIsDeleted(tipoviatransporte.getIsDeleted());
					
					tipoviatransporteLocal.setGeneralEntityOriginal(tipoviatransporte.getGeneralEntityOriginal());
					
					tipoviatransporteLocal.setId(tipoviatransporte.getId());	
					tipoviatransporteLocal.setVersionRow(tipoviatransporte.getVersionRow());	
					tipoviatransporteLocal.setnombre(tipoviatransporte.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoviatransporte.getIsDeleted()) {
				if(!existe) {
					tipoviatransportes.add(tipoviatransporte);
				}
			} else {
				if(tipoviatransporteEncontrado!=null && permiteQuitar)  {
					tipoviatransportes.remove(tipoviatransporteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoViaTransporte tipoviatransporte,List<TipoViaTransporte> tipoviatransportes) throws Exception {
		try	{			
			for(TipoViaTransporte tipoviatransporteLocal:tipoviatransportes) {
				if(tipoviatransporteLocal.getId().equals(tipoviatransporte.getId())) {
					tipoviatransporteLocal.setIsSelected(tipoviatransporte.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoViaTransporte(List<TipoViaTransporte> tipoviatransportesAux) throws Exception {
		//this.tipoviatransportesAux=tipoviatransportesAux;
		
		for(TipoViaTransporte tipoviatransporteAux:tipoviatransportesAux) {
			if(tipoviatransporteAux.getIsChanged()) {
				tipoviatransporteAux.setIsChanged(false);
			}		
			
			if(tipoviatransporteAux.getIsNew()) {
				tipoviatransporteAux.setIsNew(false);
			}	
			
			if(tipoviatransporteAux.getIsDeleted()) {
				tipoviatransporteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoViaTransporte(TipoViaTransporte tipoviatransporteAux) throws Exception {
		//this.tipoviatransporteAux=tipoviatransporteAux;
		
			if(tipoviatransporteAux.getIsChanged()) {
				tipoviatransporteAux.setIsChanged(false);
			}		
			
			if(tipoviatransporteAux.getIsNew()) {
				tipoviatransporteAux.setIsNew(false);
			}	
			
			if(tipoviatransporteAux.getIsDeleted()) {
				tipoviatransporteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoViaTransporte tipoviatransporteAsignar,TipoViaTransporte tipoviatransporte) throws Exception {
		tipoviatransporteAsignar.setId(tipoviatransporte.getId());	
		tipoviatransporteAsignar.setVersionRow(tipoviatransporte.getVersionRow());	
		tipoviatransporteAsignar.setnombre(tipoviatransporte.getnombre());	
	}
	
	public static void inicializarTipoViaTransporte(TipoViaTransporte tipoviatransporte) throws Exception {
		try {
				tipoviatransporte.setId(0L);	
					
				tipoviatransporte.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoViaTransporte(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoViaTransporteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoViaTransporte(String sTipo,Row row,Workbook workbook,TipoViaTransporte tipoviatransporte,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoviatransporte.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoViaTransporte=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoViaTransporte() {
		return this.sFinalQueryTipoViaTransporte;
	}
	
	public void setsFinalQueryTipoViaTransporte(String sFinalQueryTipoViaTransporte) {
		this.sFinalQueryTipoViaTransporte= sFinalQueryTipoViaTransporte;
	}
	
	public Border resaltarSeleccionarTipoViaTransporte=null;
	
	public Border setResaltarSeleccionarTipoViaTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*TipoViaTransporteBeanSwingJInternalFrame tipoviatransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoviatransporteBeanSwingJInternalFrame.jTtoolBarTipoViaTransporte.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoViaTransporte= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoViaTransporte() {
		return this.resaltarSeleccionarTipoViaTransporte;
	}
	
	public void setResaltarSeleccionarTipoViaTransporte(Border borderResaltarSeleccionarTipoViaTransporte) {
		this.resaltarSeleccionarTipoViaTransporte= borderResaltarSeleccionarTipoViaTransporte;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoViaTransporte=null;
	public Boolean mostraridTipoViaTransporte=true;
	public Boolean activaridTipoViaTransporte=true;

	public Border resaltarnombreTipoViaTransporte=null;
	public Boolean mostrarnombreTipoViaTransporte=true;
	public Boolean activarnombreTipoViaTransporte=true;

	
	

	public Border setResaltaridTipoViaTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*TipoViaTransporteBeanSwingJInternalFrame tipoviatransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoviatransporteBeanSwingJInternalFrame.jTtoolBarTipoViaTransporte.setBorder(borderResaltar);
		
		this.resaltaridTipoViaTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoViaTransporte() {
		return this.resaltaridTipoViaTransporte;
	}

	public void setResaltaridTipoViaTransporte(Border borderResaltar) {
		this.resaltaridTipoViaTransporte= borderResaltar;
	}

	public Boolean getMostraridTipoViaTransporte() {
		return this.mostraridTipoViaTransporte;
	}

	public void setMostraridTipoViaTransporte(Boolean mostraridTipoViaTransporte) {
		this.mostraridTipoViaTransporte= mostraridTipoViaTransporte;
	}

	public Boolean getActivaridTipoViaTransporte() {
		return this.activaridTipoViaTransporte;
	}

	public void setActivaridTipoViaTransporte(Boolean activaridTipoViaTransporte) {
		this.activaridTipoViaTransporte= activaridTipoViaTransporte;
	}

	public Border setResaltarnombreTipoViaTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*TipoViaTransporteBeanSwingJInternalFrame tipoviatransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoviatransporteBeanSwingJInternalFrame.jTtoolBarTipoViaTransporte.setBorder(borderResaltar);
		
		this.resaltarnombreTipoViaTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoViaTransporte() {
		return this.resaltarnombreTipoViaTransporte;
	}

	public void setResaltarnombreTipoViaTransporte(Border borderResaltar) {
		this.resaltarnombreTipoViaTransporte= borderResaltar;
	}

	public Boolean getMostrarnombreTipoViaTransporte() {
		return this.mostrarnombreTipoViaTransporte;
	}

	public void setMostrarnombreTipoViaTransporte(Boolean mostrarnombreTipoViaTransporte) {
		this.mostrarnombreTipoViaTransporte= mostrarnombreTipoViaTransporte;
	}

	public Boolean getActivarnombreTipoViaTransporte() {
		return this.activarnombreTipoViaTransporte;
	}

	public void setActivarnombreTipoViaTransporte(Boolean activarnombreTipoViaTransporte) {
		this.activarnombreTipoViaTransporte= activarnombreTipoViaTransporte;
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
		
		
		this.setMostraridTipoViaTransporte(esInicial);
		this.setMostrarnombreTipoViaTransporte(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoViaTransporteConstantesFunciones.ID)) {
				this.setMostraridTipoViaTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoViaTransporteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoViaTransporte(esAsigna);
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
		
		
		this.setActivaridTipoViaTransporte(esInicial);
		this.setActivarnombreTipoViaTransporte(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoViaTransporteConstantesFunciones.ID)) {
				this.setActivaridTipoViaTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoViaTransporteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoViaTransporte(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoViaTransporteBeanSwingJInternalFrame tipoviatransporteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoViaTransporte(esInicial);
		this.setResaltarnombreTipoViaTransporte(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoViaTransporteConstantesFunciones.ID)) {
				this.setResaltaridTipoViaTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoViaTransporteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoViaTransporte(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoViaTransporteBeanSwingJInternalFrame tipoviatransporteBeanSwingJInternalFrame*/)throws Exception {	
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