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
package com.bydan.erp.nomina.util.report;

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

import com.bydan.erp.nomina.resources.general.AuxiliarGeneral;

import com.bydan.erp.nomina.util.report.ProcesoImpuestoRentaConstantesFunciones;
import com.bydan.erp.nomina.util.report.ProcesoImpuestoRentaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ProcesoImpuestoRentaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProcesoImpuestoRentaConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="ProcesoImpuestoRenta";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoImpuestoRenta"+ProcesoImpuestoRentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoImpuestoRentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoImpuestoRentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoImpuestoRentaConstantesFunciones.SCHEMA+"_"+ProcesoImpuestoRentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoImpuestoRentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoImpuestoRentaConstantesFunciones.SCHEMA+"_"+ProcesoImpuestoRentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoImpuestoRentaConstantesFunciones.SCHEMA+"_"+ProcesoImpuestoRentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoImpuestoRentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoImpuestoRentaConstantesFunciones.SCHEMA+"_"+ProcesoImpuestoRentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoImpuestoRentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoImpuestoRentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoImpuestoRentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoImpuestoRentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoImpuestoRentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoImpuestoRentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoImpuestoRentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoImpuestoRentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoImpuestoRentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoImpuestoRentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Impuesto Rentas";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Proceso Impuesto Renta";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Impuesto Renta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoImpuestoRenta";
	public static final String OBJECTNAME="procesoimpuestorenta";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="proceso_impuesto_renta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesoimpuestorenta from "+ProcesoImpuestoRentaConstantesFunciones.SPERSISTENCENAME+" procesoimpuestorenta";
	public static String QUERYSELECTNATIVE="select "+ProcesoImpuestoRentaConstantesFunciones.SCHEMA+"."+ProcesoImpuestoRentaConstantesFunciones.TABLENAME+".id,"+ProcesoImpuestoRentaConstantesFunciones.SCHEMA+"."+ProcesoImpuestoRentaConstantesFunciones.TABLENAME+".version_row,"+ProcesoImpuestoRentaConstantesFunciones.SCHEMA+"."+ProcesoImpuestoRentaConstantesFunciones.TABLENAME+".id_anio from "+ProcesoImpuestoRentaConstantesFunciones.SCHEMA+"."+ProcesoImpuestoRentaConstantesFunciones.TABLENAME;//+" as "+ProcesoImpuestoRentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDANIO= "id_anio";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
	
		
		
		
	
	public static String getProcesoImpuestoRentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoImpuestoRentaConstantesFunciones.IDANIO)) {sLabelColumna=ProcesoImpuestoRentaConstantesFunciones.LABEL_IDANIO;}
		
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
	
	
	
			
			
			
	
	public static String getProcesoImpuestoRentaDescripcion(ProcesoImpuestoRenta procesoimpuestorenta) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesoimpuestorenta !=null/* && procesoimpuestorenta.getId()!=0*/) {
			if(procesoimpuestorenta.getId()!=null) {
				sDescripcion=procesoimpuestorenta.getId().toString();
			}//procesoimpuestorentaprocesoimpuestorenta.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoImpuestoRentaDescripcionDetallado(ProcesoImpuestoRenta procesoimpuestorenta) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoImpuestoRentaConstantesFunciones.ID+"=";
		sDescripcion+=procesoimpuestorenta.getId().toString()+",";
		sDescripcion+=ProcesoImpuestoRentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesoimpuestorenta.getVersionRow().toString()+",";
		sDescripcion+=ProcesoImpuestoRentaConstantesFunciones.IDANIO+"=";
		sDescripcion+=procesoimpuestorenta.getid_anio().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoImpuestoRentaDescripcion(ProcesoImpuestoRenta procesoimpuestorenta,String sValor) throws Exception {			
		if(procesoimpuestorenta !=null) {
			//procesoimpuestorentaprocesoimpuestorenta.getId().toString();
		}		
	}
	
		

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesoImpuestoRenta")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesoImpuestoRenta(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoImpuestoRenta(ProcesoImpuestoRenta procesoimpuestorenta,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesoImpuestoRentas(List<ProcesoImpuestoRenta> procesoimpuestorentas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoImpuestoRenta procesoimpuestorenta: procesoimpuestorentas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoImpuestoRenta(ProcesoImpuestoRenta procesoimpuestorenta,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesoimpuestorenta.getConCambioAuxiliar()) {
			procesoimpuestorenta.setIsDeleted(procesoimpuestorenta.getIsDeletedAuxiliar());	
			procesoimpuestorenta.setIsNew(procesoimpuestorenta.getIsNewAuxiliar());	
			procesoimpuestorenta.setIsChanged(procesoimpuestorenta.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesoimpuestorenta.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesoimpuestorenta.setIsDeletedAuxiliar(false);	
			procesoimpuestorenta.setIsNewAuxiliar(false);	
			procesoimpuestorenta.setIsChangedAuxiliar(false);
			
			procesoimpuestorenta.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoImpuestoRentas(List<ProcesoImpuestoRenta> procesoimpuestorentas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoImpuestoRenta procesoimpuestorenta : procesoimpuestorentas) {
			if(conAsignarBase && procesoimpuestorenta.getConCambioAuxiliar()) {
				procesoimpuestorenta.setIsDeleted(procesoimpuestorenta.getIsDeletedAuxiliar());	
				procesoimpuestorenta.setIsNew(procesoimpuestorenta.getIsNewAuxiliar());	
				procesoimpuestorenta.setIsChanged(procesoimpuestorenta.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesoimpuestorenta.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesoimpuestorenta.setIsDeletedAuxiliar(false);	
				procesoimpuestorenta.setIsNewAuxiliar(false);	
				procesoimpuestorenta.setIsChangedAuxiliar(false);
				
				procesoimpuestorenta.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoImpuestoRenta(ProcesoImpuestoRenta procesoimpuestorenta,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoImpuestoRentas(List<ProcesoImpuestoRenta> procesoimpuestorentas,Boolean conEnteros) throws Exception  {
		
		for(ProcesoImpuestoRenta procesoimpuestorenta: procesoimpuestorentas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoImpuestoRenta(List<ProcesoImpuestoRenta> procesoimpuestorentas,ProcesoImpuestoRenta procesoimpuestorentaAux) throws Exception  {
		ProcesoImpuestoRentaConstantesFunciones.InicializarValoresProcesoImpuestoRenta(procesoimpuestorentaAux,true);
		
		for(ProcesoImpuestoRenta procesoimpuestorenta: procesoimpuestorentas) {
			if(procesoimpuestorenta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoImpuestoRenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoImpuestoRentaConstantesFunciones.getArrayColumnasGlobalesProcesoImpuestoRenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoImpuestoRenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoImpuestoRenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoImpuestoRenta> procesoimpuestorentas,ProcesoImpuestoRenta procesoimpuestorenta,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoImpuestoRenta procesoimpuestorentaAux: procesoimpuestorentas) {
			if(procesoimpuestorentaAux!=null && procesoimpuestorenta!=null) {
				if((procesoimpuestorentaAux.getId()==null && procesoimpuestorenta.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesoimpuestorentaAux.getId()!=null && procesoimpuestorenta.getId()!=null){
					if(procesoimpuestorentaAux.getId().equals(procesoimpuestorenta.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoImpuestoRenta(List<ProcesoImpuestoRenta> procesoimpuestorentas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoImpuestoRenta procesoimpuestorenta: procesoimpuestorentas) {			
			if(procesoimpuestorenta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoImpuestoRenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoImpuestoRenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoImpuestoRenta() throws Exception  {
		return ProcesoImpuestoRentaConstantesFunciones.getTiposSeleccionarProcesoImpuestoRenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoImpuestoRenta(Boolean conFk) throws Exception  {
		return ProcesoImpuestoRentaConstantesFunciones.getTiposSeleccionarProcesoImpuestoRenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoImpuestoRenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoImpuestoRentaConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(ProcesoImpuestoRentaConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoImpuestoRenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoImpuestoRenta(ProcesoImpuestoRenta procesoimpuestorentaAux) throws Exception {
		
			procesoimpuestorentaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(procesoimpuestorentaAux.getAnio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoImpuestoRenta(List<ProcesoImpuestoRenta> procesoimpuestorentasTemp) throws Exception {
		for(ProcesoImpuestoRenta procesoimpuestorentaAux:procesoimpuestorentasTemp) {
			
			procesoimpuestorentaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(procesoimpuestorentaAux.getAnio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoImpuestoRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Anio.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoImpuestoRenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoImpuestoRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoImpuestoRentaConstantesFunciones.getClassesRelationshipsOfProcesoImpuestoRenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoImpuestoRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoImpuestoRenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoImpuestoRentaConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoImpuestoRenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoImpuestoRenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoImpuestoRenta procesoimpuestorenta,List<ProcesoImpuestoRenta> procesoimpuestorentas,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoImpuestoRenta procesoimpuestorenta,List<ProcesoImpuestoRenta> procesoimpuestorentas) throws Exception {
		try	{			
			for(ProcesoImpuestoRenta procesoimpuestorentaLocal:procesoimpuestorentas) {
				if(procesoimpuestorentaLocal.getId().equals(procesoimpuestorenta.getId())) {
					procesoimpuestorentaLocal.setIsSelected(procesoimpuestorenta.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoImpuestoRenta(List<ProcesoImpuestoRenta> procesoimpuestorentasAux) throws Exception {
		//this.procesoimpuestorentasAux=procesoimpuestorentasAux;
		
		for(ProcesoImpuestoRenta procesoimpuestorentaAux:procesoimpuestorentasAux) {
			if(procesoimpuestorentaAux.getIsChanged()) {
				procesoimpuestorentaAux.setIsChanged(false);
			}		
			
			if(procesoimpuestorentaAux.getIsNew()) {
				procesoimpuestorentaAux.setIsNew(false);
			}	
			
			if(procesoimpuestorentaAux.getIsDeleted()) {
				procesoimpuestorentaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoImpuestoRenta(ProcesoImpuestoRenta procesoimpuestorentaAux) throws Exception {
		//this.procesoimpuestorentaAux=procesoimpuestorentaAux;
		
			if(procesoimpuestorentaAux.getIsChanged()) {
				procesoimpuestorentaAux.setIsChanged(false);
			}		
			
			if(procesoimpuestorentaAux.getIsNew()) {
				procesoimpuestorentaAux.setIsNew(false);
			}	
			
			if(procesoimpuestorentaAux.getIsDeleted()) {
				procesoimpuestorentaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoImpuestoRenta procesoimpuestorentaAsignar,ProcesoImpuestoRenta procesoimpuestorenta) throws Exception {
		procesoimpuestorentaAsignar.setId(procesoimpuestorenta.getId());	
		procesoimpuestorentaAsignar.setVersionRow(procesoimpuestorenta.getVersionRow());	
		procesoimpuestorentaAsignar.setid_anio(procesoimpuestorenta.getid_anio());
		procesoimpuestorentaAsignar.setanio_descripcion(procesoimpuestorenta.getanio_descripcion());	
	}
	
	public static void inicializarProcesoImpuestoRenta(ProcesoImpuestoRenta procesoimpuestorenta) throws Exception {
		try {
				procesoimpuestorenta.setId(0L);	
					
				procesoimpuestorenta.setid_anio(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoImpuestoRenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoImpuestoRentaConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoImpuestoRenta(String sTipo,Row row,Workbook workbook,ProcesoImpuestoRenta procesoimpuestorenta,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesoimpuestorenta.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoImpuestoRenta="";
	
	public String getsFinalQueryProcesoImpuestoRenta() {
		return this.sFinalQueryProcesoImpuestoRenta;
	}
	
	public void setsFinalQueryProcesoImpuestoRenta(String sFinalQueryProcesoImpuestoRenta) {
		this.sFinalQueryProcesoImpuestoRenta= sFinalQueryProcesoImpuestoRenta;
	}
	
	public Border resaltarSeleccionarProcesoImpuestoRenta=null;
	
	public Border setResaltarSeleccionarProcesoImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoImpuestoRentaBeanSwingJInternalFrame procesoimpuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesoimpuestorentaBeanSwingJInternalFrame.jTtoolBarProcesoImpuestoRenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoImpuestoRenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoImpuestoRenta() {
		return this.resaltarSeleccionarProcesoImpuestoRenta;
	}
	
	public void setResaltarSeleccionarProcesoImpuestoRenta(Border borderResaltarSeleccionarProcesoImpuestoRenta) {
		this.resaltarSeleccionarProcesoImpuestoRenta= borderResaltarSeleccionarProcesoImpuestoRenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoImpuestoRenta=null;
	public Boolean mostraridProcesoImpuestoRenta=true;
	public Boolean activaridProcesoImpuestoRenta=true;

	public Border resaltarid_anioProcesoImpuestoRenta=null;
	public Boolean mostrarid_anioProcesoImpuestoRenta=true;
	public Boolean activarid_anioProcesoImpuestoRenta=true;
	public Boolean cargarid_anioProcesoImpuestoRenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioProcesoImpuestoRenta=false;//ConEventDepend=true

	
	

	public Border setResaltaridProcesoImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoImpuestoRentaBeanSwingJInternalFrame procesoimpuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoimpuestorentaBeanSwingJInternalFrame.jTtoolBarProcesoImpuestoRenta.setBorder(borderResaltar);
		
		this.resaltaridProcesoImpuestoRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoImpuestoRenta() {
		return this.resaltaridProcesoImpuestoRenta;
	}

	public void setResaltaridProcesoImpuestoRenta(Border borderResaltar) {
		this.resaltaridProcesoImpuestoRenta= borderResaltar;
	}

	public Boolean getMostraridProcesoImpuestoRenta() {
		return this.mostraridProcesoImpuestoRenta;
	}

	public void setMostraridProcesoImpuestoRenta(Boolean mostraridProcesoImpuestoRenta) {
		this.mostraridProcesoImpuestoRenta= mostraridProcesoImpuestoRenta;
	}

	public Boolean getActivaridProcesoImpuestoRenta() {
		return this.activaridProcesoImpuestoRenta;
	}

	public void setActivaridProcesoImpuestoRenta(Boolean activaridProcesoImpuestoRenta) {
		this.activaridProcesoImpuestoRenta= activaridProcesoImpuestoRenta;
	}

	public Border setResaltarid_anioProcesoImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoImpuestoRentaBeanSwingJInternalFrame procesoimpuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoimpuestorentaBeanSwingJInternalFrame.jTtoolBarProcesoImpuestoRenta.setBorder(borderResaltar);
		
		this.resaltarid_anioProcesoImpuestoRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioProcesoImpuestoRenta() {
		return this.resaltarid_anioProcesoImpuestoRenta;
	}

	public void setResaltarid_anioProcesoImpuestoRenta(Border borderResaltar) {
		this.resaltarid_anioProcesoImpuestoRenta= borderResaltar;
	}

	public Boolean getMostrarid_anioProcesoImpuestoRenta() {
		return this.mostrarid_anioProcesoImpuestoRenta;
	}

	public void setMostrarid_anioProcesoImpuestoRenta(Boolean mostrarid_anioProcesoImpuestoRenta) {
		this.mostrarid_anioProcesoImpuestoRenta= mostrarid_anioProcesoImpuestoRenta;
	}

	public Boolean getActivarid_anioProcesoImpuestoRenta() {
		return this.activarid_anioProcesoImpuestoRenta;
	}

	public void setActivarid_anioProcesoImpuestoRenta(Boolean activarid_anioProcesoImpuestoRenta) {
		this.activarid_anioProcesoImpuestoRenta= activarid_anioProcesoImpuestoRenta;
	}

	public Boolean getCargarid_anioProcesoImpuestoRenta() {
		return this.cargarid_anioProcesoImpuestoRenta;
	}

	public void setCargarid_anioProcesoImpuestoRenta(Boolean cargarid_anioProcesoImpuestoRenta) {
		this.cargarid_anioProcesoImpuestoRenta= cargarid_anioProcesoImpuestoRenta;
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
		
		
		this.setMostraridProcesoImpuestoRenta(esInicial);
		this.setMostrarid_anioProcesoImpuestoRenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoImpuestoRentaConstantesFunciones.ID)) {
				this.setMostraridProcesoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoImpuestoRentaConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioProcesoImpuestoRenta(esAsigna);
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
		
		
		this.setActivaridProcesoImpuestoRenta(esInicial);
		this.setActivarid_anioProcesoImpuestoRenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoImpuestoRentaConstantesFunciones.ID)) {
				this.setActivaridProcesoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoImpuestoRentaConstantesFunciones.IDANIO)) {
				this.setActivarid_anioProcesoImpuestoRenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoImpuestoRentaBeanSwingJInternalFrame procesoimpuestorentaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoImpuestoRenta(esInicial);
		this.setResaltarid_anioProcesoImpuestoRenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoImpuestoRentaConstantesFunciones.ID)) {
				this.setResaltaridProcesoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoImpuestoRentaConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioProcesoImpuestoRenta(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoImpuestoRentaBeanSwingJInternalFrame procesoimpuestorentaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoImpuestoRentaProcesoImpuestoRenta=true;

	public Boolean getMostrarBusquedaProcesoImpuestoRentaProcesoImpuestoRenta() {
		return this.mostrarBusquedaProcesoImpuestoRentaProcesoImpuestoRenta;
	}

	public void setMostrarBusquedaProcesoImpuestoRentaProcesoImpuestoRenta(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoImpuestoRentaProcesoImpuestoRenta= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoImpuestoRentaProcesoImpuestoRenta=true;

	public Boolean getActivarBusquedaProcesoImpuestoRentaProcesoImpuestoRenta() {
		return this.activarBusquedaProcesoImpuestoRentaProcesoImpuestoRenta;
	}

	public void setActivarBusquedaProcesoImpuestoRentaProcesoImpuestoRenta(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoImpuestoRentaProcesoImpuestoRenta= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoImpuestoRentaProcesoImpuestoRenta=null;

	public Border getResaltarBusquedaProcesoImpuestoRentaProcesoImpuestoRenta() {
		return this.resaltarBusquedaProcesoImpuestoRentaProcesoImpuestoRenta;
	}

	public void setResaltarBusquedaProcesoImpuestoRentaProcesoImpuestoRenta(Border borderResaltar) {
		this.resaltarBusquedaProcesoImpuestoRentaProcesoImpuestoRenta= borderResaltar;
	}

	public void setResaltarBusquedaProcesoImpuestoRentaProcesoImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoImpuestoRentaBeanSwingJInternalFrame procesoimpuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoImpuestoRentaProcesoImpuestoRenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}