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
package com.bydan.erp.puntoventa.util;

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


import com.bydan.erp.puntoventa.util.PuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.PuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.PuntoVentaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.puntoventa.util.report.*;
import com.bydan.erp.puntoventa.business.entity.report.*;
import com.bydan.erp.puntoventa.util.PuntoVentaSql;
import com.bydan.erp.puntoventa.util.PuntoVentaSqlReporte;


@SuppressWarnings("unused")
final public class PuntoVentaConstantesFunciones extends PuntoVentaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PuntoVenta";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PuntoVenta"+PuntoVentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PuntoVentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PuntoVentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PuntoVentaConstantesFunciones.SCHEMA+"_"+PuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PuntoVentaConstantesFunciones.SCHEMA+"_"+PuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PuntoVentaConstantesFunciones.SCHEMA+"_"+PuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PuntoVentaConstantesFunciones.SCHEMA+"_"+PuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PuntoVentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PuntoVentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Punto Ventas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Punto Venta";
	public static final String SCLASSWEBTITULO_LOWER="Punto Venta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PuntoVenta";
	public static final String OBJECTNAME="puntoventa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="punto_venta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select puntoventa from "+PuntoVentaConstantesFunciones.SPERSISTENCENAME+" puntoventa";
	public static String QUERYSELECTNATIVE="select "+PuntoVentaConstantesFunciones.SCHEMA+"."+PuntoVentaConstantesFunciones.TABLENAME+".id,"+PuntoVentaConstantesFunciones.SCHEMA+"."+PuntoVentaConstantesFunciones.TABLENAME+".version_row,"+PuntoVentaConstantesFunciones.SCHEMA+"."+PuntoVentaConstantesFunciones.TABLENAME+".codigo from "+PuntoVentaConstantesFunciones.SCHEMA+"."+PuntoVentaConstantesFunciones.TABLENAME;//+" as "+PuntoVentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PuntoVentaConstantesFuncionesAdditional puntoventaConstantesFuncionesAdditional=null;
	
	public PuntoVentaConstantesFuncionesAdditional getPuntoVentaConstantesFuncionesAdditional() {
		return this.puntoventaConstantesFuncionesAdditional;
	}
	
	public void setPuntoVentaConstantesFuncionesAdditional(PuntoVentaConstantesFuncionesAdditional puntoventaConstantesFuncionesAdditional) {
		try {
			this.puntoventaConstantesFuncionesAdditional=puntoventaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getPuntoVentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PuntoVentaConstantesFunciones.CODIGO)) {sLabelColumna=PuntoVentaConstantesFunciones.LABEL_CODIGO;}
		
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
	
	
	
			
			
			
	
	public static String getPuntoVentaDescripcion(PuntoVenta puntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(puntoventa !=null/* && puntoventa.getId()!=0*/) {
			sDescripcion=puntoventa.getcodigo();//puntoventapuntoventa.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getPuntoVentaDescripcionDetallado(PuntoVenta puntoventa) {
		String sDescripcion="";
			
		sDescripcion+=PuntoVentaConstantesFunciones.ID+"=";
		sDescripcion+=puntoventa.getId().toString()+",";
		sDescripcion+=PuntoVentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=puntoventa.getVersionRow().toString()+",";
		sDescripcion+=PuntoVentaConstantesFunciones.CODIGO+"=";
		sDescripcion+=puntoventa.getcodigo()+",";
			
		return sDescripcion;
	}
	
	public static void setPuntoVentaDescripcion(PuntoVenta puntoventa,String sValor) throws Exception {			
		if(puntoventa !=null) {
			puntoventa.setcodigo(sValor);;//puntoventapuntoventa.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosPuntoVenta(PuntoVenta puntoventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		puntoventa.setcodigo(puntoventa.getcodigo().trim());
	}
	
	public static void quitarEspaciosPuntoVentas(List<PuntoVenta> puntoventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PuntoVenta puntoventa: puntoventas) {
			puntoventa.setcodigo(puntoventa.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPuntoVenta(PuntoVenta puntoventa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && puntoventa.getConCambioAuxiliar()) {
			puntoventa.setIsDeleted(puntoventa.getIsDeletedAuxiliar());	
			puntoventa.setIsNew(puntoventa.getIsNewAuxiliar());	
			puntoventa.setIsChanged(puntoventa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			puntoventa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			puntoventa.setIsDeletedAuxiliar(false);	
			puntoventa.setIsNewAuxiliar(false);	
			puntoventa.setIsChangedAuxiliar(false);
			
			puntoventa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPuntoVentas(List<PuntoVenta> puntoventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PuntoVenta puntoventa : puntoventas) {
			if(conAsignarBase && puntoventa.getConCambioAuxiliar()) {
				puntoventa.setIsDeleted(puntoventa.getIsDeletedAuxiliar());	
				puntoventa.setIsNew(puntoventa.getIsNewAuxiliar());	
				puntoventa.setIsChanged(puntoventa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				puntoventa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				puntoventa.setIsDeletedAuxiliar(false);	
				puntoventa.setIsNewAuxiliar(false);	
				puntoventa.setIsChangedAuxiliar(false);
				
				puntoventa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPuntoVenta(PuntoVenta puntoventa,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPuntoVentas(List<PuntoVenta> puntoventas,Boolean conEnteros) throws Exception  {
		
		for(PuntoVenta puntoventa: puntoventas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPuntoVenta(List<PuntoVenta> puntoventas,PuntoVenta puntoventaAux) throws Exception  {
		PuntoVentaConstantesFunciones.InicializarValoresPuntoVenta(puntoventaAux,true);
		
		for(PuntoVenta puntoventa: puntoventas) {
			if(puntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PuntoVentaConstantesFunciones.getArrayColumnasGlobalesPuntoVenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PuntoVenta> puntoventas,PuntoVenta puntoventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PuntoVenta puntoventaAux: puntoventas) {
			if(puntoventaAux!=null && puntoventa!=null) {
				if((puntoventaAux.getId()==null && puntoventa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(puntoventaAux.getId()!=null && puntoventa.getId()!=null){
					if(puntoventaAux.getId().equals(puntoventa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPuntoVenta(List<PuntoVenta> puntoventas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PuntoVenta puntoventa: puntoventas) {			
			if(puntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPuntoVenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPuntoVenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPuntoVenta() throws Exception  {
		return PuntoVentaConstantesFunciones.getTiposSeleccionarPuntoVenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPuntoVenta(Boolean conFk) throws Exception  {
		return PuntoVentaConstantesFunciones.getTiposSeleccionarPuntoVenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPuntoVenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PuntoVentaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(PuntoVentaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPuntoVenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPuntoVenta(PuntoVenta puntoventaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesPuntoVenta(List<PuntoVenta> puntoventasTemp) throws Exception {
		for(PuntoVenta puntoventaAux:puntoventasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PuntoVentaConstantesFunciones.getClassesRelationshipsOfPuntoVenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PuntoVentaConstantesFunciones.getClassesRelationshipsFromStringsOfPuntoVenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PuntoVenta puntoventa,List<PuntoVenta> puntoventas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PuntoVenta puntoventaEncontrado=null;
			
			for(PuntoVenta puntoventaLocal:puntoventas) {
				if(puntoventaLocal.getId().equals(puntoventa.getId())) {
					puntoventaEncontrado=puntoventaLocal;
					
					puntoventaLocal.setIsChanged(puntoventa.getIsChanged());
					puntoventaLocal.setIsNew(puntoventa.getIsNew());
					puntoventaLocal.setIsDeleted(puntoventa.getIsDeleted());
					
					puntoventaLocal.setGeneralEntityOriginal(puntoventa.getGeneralEntityOriginal());
					
					puntoventaLocal.setId(puntoventa.getId());	
					puntoventaLocal.setVersionRow(puntoventa.getVersionRow());	
					puntoventaLocal.setcodigo(puntoventa.getcodigo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!puntoventa.getIsDeleted()) {
				if(!existe) {
					puntoventas.add(puntoventa);
				}
			} else {
				if(puntoventaEncontrado!=null && permiteQuitar)  {
					puntoventas.remove(puntoventaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PuntoVenta puntoventa,List<PuntoVenta> puntoventas) throws Exception {
		try	{			
			for(PuntoVenta puntoventaLocal:puntoventas) {
				if(puntoventaLocal.getId().equals(puntoventa.getId())) {
					puntoventaLocal.setIsSelected(puntoventa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPuntoVenta(List<PuntoVenta> puntoventasAux) throws Exception {
		//this.puntoventasAux=puntoventasAux;
		
		for(PuntoVenta puntoventaAux:puntoventasAux) {
			if(puntoventaAux.getIsChanged()) {
				puntoventaAux.setIsChanged(false);
			}		
			
			if(puntoventaAux.getIsNew()) {
				puntoventaAux.setIsNew(false);
			}	
			
			if(puntoventaAux.getIsDeleted()) {
				puntoventaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPuntoVenta(PuntoVenta puntoventaAux) throws Exception {
		//this.puntoventaAux=puntoventaAux;
		
			if(puntoventaAux.getIsChanged()) {
				puntoventaAux.setIsChanged(false);
			}		
			
			if(puntoventaAux.getIsNew()) {
				puntoventaAux.setIsNew(false);
			}	
			
			if(puntoventaAux.getIsDeleted()) {
				puntoventaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PuntoVenta puntoventaAsignar,PuntoVenta puntoventa) throws Exception {
		puntoventaAsignar.setId(puntoventa.getId());	
		puntoventaAsignar.setVersionRow(puntoventa.getVersionRow());	
		puntoventaAsignar.setcodigo(puntoventa.getcodigo());	
	}
	
	public static void inicializarPuntoVenta(PuntoVenta puntoventa) throws Exception {
		try {
				puntoventa.setId(0L);	
					
				puntoventa.setcodigo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPuntoVenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PuntoVentaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPuntoVenta(String sTipo,Row row,Workbook workbook,PuntoVenta puntoventa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(puntoventa.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPuntoVenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPuntoVenta() {
		return this.sFinalQueryPuntoVenta;
	}
	
	public void setsFinalQueryPuntoVenta(String sFinalQueryPuntoVenta) {
		this.sFinalQueryPuntoVenta= sFinalQueryPuntoVenta;
	}
	
	public Border resaltarSeleccionarPuntoVenta=null;
	
	public Border setResaltarSeleccionarPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PuntoVentaBeanSwingJInternalFrame puntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//puntoventaBeanSwingJInternalFrame.jTtoolBarPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPuntoVenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPuntoVenta() {
		return this.resaltarSeleccionarPuntoVenta;
	}
	
	public void setResaltarSeleccionarPuntoVenta(Border borderResaltarSeleccionarPuntoVenta) {
		this.resaltarSeleccionarPuntoVenta= borderResaltarSeleccionarPuntoVenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPuntoVenta=null;
	public Boolean mostraridPuntoVenta=true;
	public Boolean activaridPuntoVenta=true;

	public Border resaltarcodigoPuntoVenta=null;
	public Boolean mostrarcodigoPuntoVenta=true;
	public Boolean activarcodigoPuntoVenta=true;

	
	

	public Border setResaltaridPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PuntoVentaBeanSwingJInternalFrame puntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//puntoventaBeanSwingJInternalFrame.jTtoolBarPuntoVenta.setBorder(borderResaltar);
		
		this.resaltaridPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPuntoVenta() {
		return this.resaltaridPuntoVenta;
	}

	public void setResaltaridPuntoVenta(Border borderResaltar) {
		this.resaltaridPuntoVenta= borderResaltar;
	}

	public Boolean getMostraridPuntoVenta() {
		return this.mostraridPuntoVenta;
	}

	public void setMostraridPuntoVenta(Boolean mostraridPuntoVenta) {
		this.mostraridPuntoVenta= mostraridPuntoVenta;
	}

	public Boolean getActivaridPuntoVenta() {
		return this.activaridPuntoVenta;
	}

	public void setActivaridPuntoVenta(Boolean activaridPuntoVenta) {
		this.activaridPuntoVenta= activaridPuntoVenta;
	}

	public Border setResaltarcodigoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PuntoVentaBeanSwingJInternalFrame puntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//puntoventaBeanSwingJInternalFrame.jTtoolBarPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarcodigoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoPuntoVenta() {
		return this.resaltarcodigoPuntoVenta;
	}

	public void setResaltarcodigoPuntoVenta(Border borderResaltar) {
		this.resaltarcodigoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarcodigoPuntoVenta() {
		return this.mostrarcodigoPuntoVenta;
	}

	public void setMostrarcodigoPuntoVenta(Boolean mostrarcodigoPuntoVenta) {
		this.mostrarcodigoPuntoVenta= mostrarcodigoPuntoVenta;
	}

	public Boolean getActivarcodigoPuntoVenta() {
		return this.activarcodigoPuntoVenta;
	}

	public void setActivarcodigoPuntoVenta(Boolean activarcodigoPuntoVenta) {
		this.activarcodigoPuntoVenta= activarcodigoPuntoVenta;
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
		
		
		this.setMostraridPuntoVenta(esInicial);
		this.setMostrarcodigoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PuntoVentaConstantesFunciones.ID)) {
				this.setMostraridPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PuntoVentaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoPuntoVenta(esAsigna);
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
		
		
		this.setActivaridPuntoVenta(esInicial);
		this.setActivarcodigoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PuntoVentaConstantesFunciones.ID)) {
				this.setActivaridPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PuntoVentaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PuntoVentaBeanSwingJInternalFrame puntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPuntoVenta(esInicial);
		this.setResaltarcodigoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PuntoVentaConstantesFunciones.ID)) {
				this.setResaltaridPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PuntoVentaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoPuntoVenta(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PuntoVentaBeanSwingJInternalFrame puntoventaBeanSwingJInternalFrame*/)throws Exception {	
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