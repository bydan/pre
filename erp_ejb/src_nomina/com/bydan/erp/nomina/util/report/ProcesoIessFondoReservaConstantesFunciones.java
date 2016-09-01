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

import com.bydan.erp.nomina.util.report.ProcesoIessFondoReservaConstantesFunciones;
import com.bydan.erp.nomina.util.report.ProcesoIessFondoReservaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ProcesoIessFondoReservaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProcesoIessFondoReservaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoIessFondoReserva";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoIessFondoReserva"+ProcesoIessFondoReservaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoIessFondoReservaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoIessFondoReservaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoIessFondoReservaConstantesFunciones.SCHEMA+"_"+ProcesoIessFondoReservaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoIessFondoReservaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoIessFondoReservaConstantesFunciones.SCHEMA+"_"+ProcesoIessFondoReservaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoIessFondoReservaConstantesFunciones.SCHEMA+"_"+ProcesoIessFondoReservaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoIessFondoReservaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoIessFondoReservaConstantesFunciones.SCHEMA+"_"+ProcesoIessFondoReservaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoIessFondoReservaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoIessFondoReservaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoIessFondoReservaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoIessFondoReservaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoIessFondoReservaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoIessFondoReservaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoIessFondoReservaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoIessFondoReservaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoIessFondoReservaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoIessFondoReservaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Iess Fondo Reservas";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Proceso Iess Fondo Reserva";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Iess Fondo Reserva";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoIessFondoReserva";
	public static final String OBJECTNAME="procesoiessfondoreserva";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="proceso_iess_fondo_reserva";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesoiessfondoreserva from "+ProcesoIessFondoReservaConstantesFunciones.SPERSISTENCENAME+" procesoiessfondoreserva";
	public static String QUERYSELECTNATIVE="select "+ProcesoIessFondoReservaConstantesFunciones.SCHEMA+"."+ProcesoIessFondoReservaConstantesFunciones.TABLENAME+".id,"+ProcesoIessFondoReservaConstantesFunciones.SCHEMA+"."+ProcesoIessFondoReservaConstantesFunciones.TABLENAME+".version_row,"+ProcesoIessFondoReservaConstantesFunciones.SCHEMA+"."+ProcesoIessFondoReservaConstantesFunciones.TABLENAME+".id_anio,"+ProcesoIessFondoReservaConstantesFunciones.SCHEMA+"."+ProcesoIessFondoReservaConstantesFunciones.TABLENAME+".id_numero_patronal from "+ProcesoIessFondoReservaConstantesFunciones.SCHEMA+"."+ProcesoIessFondoReservaConstantesFunciones.TABLENAME;//+" as "+ProcesoIessFondoReservaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDANIO= "id_anio";
    public static final String IDNUMEROPATRONAL= "id_numero_patronal";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDNUMEROPATRONAL= "Numero Patronal";
		public static final String LABEL_IDNUMEROPATRONAL_LOWER= "Numero Patronal";
	
		
		
		
		
	
	public static String getProcesoIessFondoReservaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoIessFondoReservaConstantesFunciones.IDANIO)) {sLabelColumna=ProcesoIessFondoReservaConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(ProcesoIessFondoReservaConstantesFunciones.IDNUMEROPATRONAL)) {sLabelColumna=ProcesoIessFondoReservaConstantesFunciones.LABEL_IDNUMEROPATRONAL;}
		
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
	
	
	
			
			
			
			
	
	public static String getProcesoIessFondoReservaDescripcion(ProcesoIessFondoReserva procesoiessfondoreserva) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesoiessfondoreserva !=null/* && procesoiessfondoreserva.getId()!=0*/) {
			if(procesoiessfondoreserva.getId()!=null) {
				sDescripcion=procesoiessfondoreserva.getId().toString();
			}//procesoiessfondoreservaprocesoiessfondoreserva.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoIessFondoReservaDescripcionDetallado(ProcesoIessFondoReserva procesoiessfondoreserva) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoIessFondoReservaConstantesFunciones.ID+"=";
		sDescripcion+=procesoiessfondoreserva.getId().toString()+",";
		sDescripcion+=ProcesoIessFondoReservaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesoiessfondoreserva.getVersionRow().toString()+",";
		sDescripcion+=ProcesoIessFondoReservaConstantesFunciones.IDANIO+"=";
		sDescripcion+=procesoiessfondoreserva.getid_anio().toString()+",";
		sDescripcion+=ProcesoIessFondoReservaConstantesFunciones.IDNUMEROPATRONAL+"=";
		sDescripcion+=procesoiessfondoreserva.getid_numero_patronal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoIessFondoReservaDescripcion(ProcesoIessFondoReserva procesoiessfondoreserva,String sValor) throws Exception {			
		if(procesoiessfondoreserva !=null) {
			//procesoiessfondoreservaprocesoiessfondoreserva.getId().toString();
		}		
	}
	
		

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getNumeroPatronalDescripcion(NumeroPatronal numeropatronal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(numeropatronal!=null/*&&numeropatronal.getId()>0*/) {
			sDescripcion=NumeroPatronalConstantesFunciones.getNumeroPatronalDescripcion(numeropatronal);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesoIessFondoReserva")) {
			sNombreIndice="Tipo=  Por Anio Por Numero Patronal";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdNumeroPatronal")) {
			sNombreIndice="Tipo=  Por Numero Patronal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesoIessFondoReserva(Long id_anio,Long id_numero_patronal) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();}
		if(id_numero_patronal!=null) {sDetalleIndice+=" Codigo Unico De Numero Patronal="+id_numero_patronal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdNumeroPatronal(Long id_numero_patronal) {
		String sDetalleIndice=" Parametros->";
		if(id_numero_patronal!=null) {sDetalleIndice+=" Codigo Unico De Numero Patronal="+id_numero_patronal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoIessFondoReserva(ProcesoIessFondoReserva procesoiessfondoreserva,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesoIessFondoReservas(List<ProcesoIessFondoReserva> procesoiessfondoreservas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoIessFondoReserva procesoiessfondoreserva: procesoiessfondoreservas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoIessFondoReserva(ProcesoIessFondoReserva procesoiessfondoreserva,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesoiessfondoreserva.getConCambioAuxiliar()) {
			procesoiessfondoreserva.setIsDeleted(procesoiessfondoreserva.getIsDeletedAuxiliar());	
			procesoiessfondoreserva.setIsNew(procesoiessfondoreserva.getIsNewAuxiliar());	
			procesoiessfondoreserva.setIsChanged(procesoiessfondoreserva.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesoiessfondoreserva.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesoiessfondoreserva.setIsDeletedAuxiliar(false);	
			procesoiessfondoreserva.setIsNewAuxiliar(false);	
			procesoiessfondoreserva.setIsChangedAuxiliar(false);
			
			procesoiessfondoreserva.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoIessFondoReservas(List<ProcesoIessFondoReserva> procesoiessfondoreservas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoIessFondoReserva procesoiessfondoreserva : procesoiessfondoreservas) {
			if(conAsignarBase && procesoiessfondoreserva.getConCambioAuxiliar()) {
				procesoiessfondoreserva.setIsDeleted(procesoiessfondoreserva.getIsDeletedAuxiliar());	
				procesoiessfondoreserva.setIsNew(procesoiessfondoreserva.getIsNewAuxiliar());	
				procesoiessfondoreserva.setIsChanged(procesoiessfondoreserva.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesoiessfondoreserva.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesoiessfondoreserva.setIsDeletedAuxiliar(false);	
				procesoiessfondoreserva.setIsNewAuxiliar(false);	
				procesoiessfondoreserva.setIsChangedAuxiliar(false);
				
				procesoiessfondoreserva.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoIessFondoReserva(ProcesoIessFondoReserva procesoiessfondoreserva,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoIessFondoReservas(List<ProcesoIessFondoReserva> procesoiessfondoreservas,Boolean conEnteros) throws Exception  {
		
		for(ProcesoIessFondoReserva procesoiessfondoreserva: procesoiessfondoreservas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoIessFondoReserva(List<ProcesoIessFondoReserva> procesoiessfondoreservas,ProcesoIessFondoReserva procesoiessfondoreservaAux) throws Exception  {
		ProcesoIessFondoReservaConstantesFunciones.InicializarValoresProcesoIessFondoReserva(procesoiessfondoreservaAux,true);
		
		for(ProcesoIessFondoReserva procesoiessfondoreserva: procesoiessfondoreservas) {
			if(procesoiessfondoreserva.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoIessFondoReserva(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoIessFondoReservaConstantesFunciones.getArrayColumnasGlobalesProcesoIessFondoReserva(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoIessFondoReserva(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoIessFondoReserva(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoIessFondoReserva> procesoiessfondoreservas,ProcesoIessFondoReserva procesoiessfondoreserva,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoIessFondoReserva procesoiessfondoreservaAux: procesoiessfondoreservas) {
			if(procesoiessfondoreservaAux!=null && procesoiessfondoreserva!=null) {
				if((procesoiessfondoreservaAux.getId()==null && procesoiessfondoreserva.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesoiessfondoreservaAux.getId()!=null && procesoiessfondoreserva.getId()!=null){
					if(procesoiessfondoreservaAux.getId().equals(procesoiessfondoreserva.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoIessFondoReserva(List<ProcesoIessFondoReserva> procesoiessfondoreservas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoIessFondoReserva procesoiessfondoreserva: procesoiessfondoreservas) {			
			if(procesoiessfondoreserva.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoIessFondoReserva() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoIessFondoReserva() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoIessFondoReserva() throws Exception  {
		return ProcesoIessFondoReservaConstantesFunciones.getTiposSeleccionarProcesoIessFondoReserva(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoIessFondoReserva(Boolean conFk) throws Exception  {
		return ProcesoIessFondoReservaConstantesFunciones.getTiposSeleccionarProcesoIessFondoReserva(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoIessFondoReserva(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoIessFondoReservaConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(ProcesoIessFondoReservaConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoIessFondoReservaConstantesFunciones.LABEL_IDNUMEROPATRONAL);
			reporte.setsDescripcion(ProcesoIessFondoReservaConstantesFunciones.LABEL_IDNUMEROPATRONAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoIessFondoReserva(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoIessFondoReserva(ProcesoIessFondoReserva procesoiessfondoreservaAux) throws Exception {
		
			procesoiessfondoreservaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(procesoiessfondoreservaAux.getAnio()));
			procesoiessfondoreservaAux.setnumeropatronal_descripcion(NumeroPatronalConstantesFunciones.getNumeroPatronalDescripcion(procesoiessfondoreservaAux.getNumeroPatronal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoIessFondoReserva(List<ProcesoIessFondoReserva> procesoiessfondoreservasTemp) throws Exception {
		for(ProcesoIessFondoReserva procesoiessfondoreservaAux:procesoiessfondoreservasTemp) {
			
			procesoiessfondoreservaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(procesoiessfondoreservaAux.getAnio()));
			procesoiessfondoreservaAux.setnumeropatronal_descripcion(NumeroPatronalConstantesFunciones.getNumeroPatronalDescripcion(procesoiessfondoreservaAux.getNumeroPatronal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoIessFondoReserva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(NumeroPatronal.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NumeroPatronal.class)) {
						classes.add(new Classe(NumeroPatronal.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoIessFondoReserva(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(NumeroPatronal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NumeroPatronal.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(NumeroPatronal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NumeroPatronal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoIessFondoReserva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoIessFondoReservaConstantesFunciones.getClassesRelationshipsOfProcesoIessFondoReserva(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoIessFondoReserva(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoIessFondoReserva(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoIessFondoReservaConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoIessFondoReserva(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoIessFondoReserva(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoIessFondoReserva procesoiessfondoreserva,List<ProcesoIessFondoReserva> procesoiessfondoreservas,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoIessFondoReserva procesoiessfondoreserva,List<ProcesoIessFondoReserva> procesoiessfondoreservas) throws Exception {
		try	{			
			for(ProcesoIessFondoReserva procesoiessfondoreservaLocal:procesoiessfondoreservas) {
				if(procesoiessfondoreservaLocal.getId().equals(procesoiessfondoreserva.getId())) {
					procesoiessfondoreservaLocal.setIsSelected(procesoiessfondoreserva.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoIessFondoReserva(List<ProcesoIessFondoReserva> procesoiessfondoreservasAux) throws Exception {
		//this.procesoiessfondoreservasAux=procesoiessfondoreservasAux;
		
		for(ProcesoIessFondoReserva procesoiessfondoreservaAux:procesoiessfondoreservasAux) {
			if(procesoiessfondoreservaAux.getIsChanged()) {
				procesoiessfondoreservaAux.setIsChanged(false);
			}		
			
			if(procesoiessfondoreservaAux.getIsNew()) {
				procesoiessfondoreservaAux.setIsNew(false);
			}	
			
			if(procesoiessfondoreservaAux.getIsDeleted()) {
				procesoiessfondoreservaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoIessFondoReserva(ProcesoIessFondoReserva procesoiessfondoreservaAux) throws Exception {
		//this.procesoiessfondoreservaAux=procesoiessfondoreservaAux;
		
			if(procesoiessfondoreservaAux.getIsChanged()) {
				procesoiessfondoreservaAux.setIsChanged(false);
			}		
			
			if(procesoiessfondoreservaAux.getIsNew()) {
				procesoiessfondoreservaAux.setIsNew(false);
			}	
			
			if(procesoiessfondoreservaAux.getIsDeleted()) {
				procesoiessfondoreservaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoIessFondoReserva procesoiessfondoreservaAsignar,ProcesoIessFondoReserva procesoiessfondoreserva) throws Exception {
		procesoiessfondoreservaAsignar.setId(procesoiessfondoreserva.getId());	
		procesoiessfondoreservaAsignar.setVersionRow(procesoiessfondoreserva.getVersionRow());	
		procesoiessfondoreservaAsignar.setid_anio(procesoiessfondoreserva.getid_anio());
		procesoiessfondoreservaAsignar.setanio_descripcion(procesoiessfondoreserva.getanio_descripcion());	
		procesoiessfondoreservaAsignar.setid_numero_patronal(procesoiessfondoreserva.getid_numero_patronal());
		procesoiessfondoreservaAsignar.setnumeropatronal_descripcion(procesoiessfondoreserva.getnumeropatronal_descripcion());	
	}
	
	public static void inicializarProcesoIessFondoReserva(ProcesoIessFondoReserva procesoiessfondoreserva) throws Exception {
		try {
				procesoiessfondoreserva.setId(0L);	
					
				procesoiessfondoreserva.setid_anio(null);	
				procesoiessfondoreserva.setid_numero_patronal(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoIessFondoReserva(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoIessFondoReservaConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoIessFondoReservaConstantesFunciones.LABEL_IDNUMEROPATRONAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoIessFondoReserva(String sTipo,Row row,Workbook workbook,ProcesoIessFondoReserva procesoiessfondoreserva,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesoiessfondoreserva.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesoiessfondoreserva.getnumeropatronal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoIessFondoReserva="";
	
	public String getsFinalQueryProcesoIessFondoReserva() {
		return this.sFinalQueryProcesoIessFondoReserva;
	}
	
	public void setsFinalQueryProcesoIessFondoReserva(String sFinalQueryProcesoIessFondoReserva) {
		this.sFinalQueryProcesoIessFondoReserva= sFinalQueryProcesoIessFondoReserva;
	}
	
	public Border resaltarSeleccionarProcesoIessFondoReserva=null;
	
	public Border setResaltarSeleccionarProcesoIessFondoReserva(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoIessFondoReservaBeanSwingJInternalFrame procesoiessfondoreservaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesoiessfondoreservaBeanSwingJInternalFrame.jTtoolBarProcesoIessFondoReserva.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoIessFondoReserva= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoIessFondoReserva() {
		return this.resaltarSeleccionarProcesoIessFondoReserva;
	}
	
	public void setResaltarSeleccionarProcesoIessFondoReserva(Border borderResaltarSeleccionarProcesoIessFondoReserva) {
		this.resaltarSeleccionarProcesoIessFondoReserva= borderResaltarSeleccionarProcesoIessFondoReserva;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoIessFondoReserva=null;
	public Boolean mostraridProcesoIessFondoReserva=true;
	public Boolean activaridProcesoIessFondoReserva=true;

	public Border resaltarid_anioProcesoIessFondoReserva=null;
	public Boolean mostrarid_anioProcesoIessFondoReserva=true;
	public Boolean activarid_anioProcesoIessFondoReserva=true;
	public Boolean cargarid_anioProcesoIessFondoReserva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioProcesoIessFondoReserva=false;//ConEventDepend=true

	public Border resaltarid_numero_patronalProcesoIessFondoReserva=null;
	public Boolean mostrarid_numero_patronalProcesoIessFondoReserva=true;
	public Boolean activarid_numero_patronalProcesoIessFondoReserva=true;
	public Boolean cargarid_numero_patronalProcesoIessFondoReserva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_numero_patronalProcesoIessFondoReserva=false;//ConEventDepend=true

	
	

	public Border setResaltaridProcesoIessFondoReserva(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoIessFondoReservaBeanSwingJInternalFrame procesoiessfondoreservaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoiessfondoreservaBeanSwingJInternalFrame.jTtoolBarProcesoIessFondoReserva.setBorder(borderResaltar);
		
		this.resaltaridProcesoIessFondoReserva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoIessFondoReserva() {
		return this.resaltaridProcesoIessFondoReserva;
	}

	public void setResaltaridProcesoIessFondoReserva(Border borderResaltar) {
		this.resaltaridProcesoIessFondoReserva= borderResaltar;
	}

	public Boolean getMostraridProcesoIessFondoReserva() {
		return this.mostraridProcesoIessFondoReserva;
	}

	public void setMostraridProcesoIessFondoReserva(Boolean mostraridProcesoIessFondoReserva) {
		this.mostraridProcesoIessFondoReserva= mostraridProcesoIessFondoReserva;
	}

	public Boolean getActivaridProcesoIessFondoReserva() {
		return this.activaridProcesoIessFondoReserva;
	}

	public void setActivaridProcesoIessFondoReserva(Boolean activaridProcesoIessFondoReserva) {
		this.activaridProcesoIessFondoReserva= activaridProcesoIessFondoReserva;
	}

	public Border setResaltarid_anioProcesoIessFondoReserva(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoIessFondoReservaBeanSwingJInternalFrame procesoiessfondoreservaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoiessfondoreservaBeanSwingJInternalFrame.jTtoolBarProcesoIessFondoReserva.setBorder(borderResaltar);
		
		this.resaltarid_anioProcesoIessFondoReserva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioProcesoIessFondoReserva() {
		return this.resaltarid_anioProcesoIessFondoReserva;
	}

	public void setResaltarid_anioProcesoIessFondoReserva(Border borderResaltar) {
		this.resaltarid_anioProcesoIessFondoReserva= borderResaltar;
	}

	public Boolean getMostrarid_anioProcesoIessFondoReserva() {
		return this.mostrarid_anioProcesoIessFondoReserva;
	}

	public void setMostrarid_anioProcesoIessFondoReserva(Boolean mostrarid_anioProcesoIessFondoReserva) {
		this.mostrarid_anioProcesoIessFondoReserva= mostrarid_anioProcesoIessFondoReserva;
	}

	public Boolean getActivarid_anioProcesoIessFondoReserva() {
		return this.activarid_anioProcesoIessFondoReserva;
	}

	public void setActivarid_anioProcesoIessFondoReserva(Boolean activarid_anioProcesoIessFondoReserva) {
		this.activarid_anioProcesoIessFondoReserva= activarid_anioProcesoIessFondoReserva;
	}

	public Boolean getCargarid_anioProcesoIessFondoReserva() {
		return this.cargarid_anioProcesoIessFondoReserva;
	}

	public void setCargarid_anioProcesoIessFondoReserva(Boolean cargarid_anioProcesoIessFondoReserva) {
		this.cargarid_anioProcesoIessFondoReserva= cargarid_anioProcesoIessFondoReserva;
	}

	public Border setResaltarid_numero_patronalProcesoIessFondoReserva(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoIessFondoReservaBeanSwingJInternalFrame procesoiessfondoreservaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoiessfondoreservaBeanSwingJInternalFrame.jTtoolBarProcesoIessFondoReserva.setBorder(borderResaltar);
		
		this.resaltarid_numero_patronalProcesoIessFondoReserva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_numero_patronalProcesoIessFondoReserva() {
		return this.resaltarid_numero_patronalProcesoIessFondoReserva;
	}

	public void setResaltarid_numero_patronalProcesoIessFondoReserva(Border borderResaltar) {
		this.resaltarid_numero_patronalProcesoIessFondoReserva= borderResaltar;
	}

	public Boolean getMostrarid_numero_patronalProcesoIessFondoReserva() {
		return this.mostrarid_numero_patronalProcesoIessFondoReserva;
	}

	public void setMostrarid_numero_patronalProcesoIessFondoReserva(Boolean mostrarid_numero_patronalProcesoIessFondoReserva) {
		this.mostrarid_numero_patronalProcesoIessFondoReserva= mostrarid_numero_patronalProcesoIessFondoReserva;
	}

	public Boolean getActivarid_numero_patronalProcesoIessFondoReserva() {
		return this.activarid_numero_patronalProcesoIessFondoReserva;
	}

	public void setActivarid_numero_patronalProcesoIessFondoReserva(Boolean activarid_numero_patronalProcesoIessFondoReserva) {
		this.activarid_numero_patronalProcesoIessFondoReserva= activarid_numero_patronalProcesoIessFondoReserva;
	}

	public Boolean getCargarid_numero_patronalProcesoIessFondoReserva() {
		return this.cargarid_numero_patronalProcesoIessFondoReserva;
	}

	public void setCargarid_numero_patronalProcesoIessFondoReserva(Boolean cargarid_numero_patronalProcesoIessFondoReserva) {
		this.cargarid_numero_patronalProcesoIessFondoReserva= cargarid_numero_patronalProcesoIessFondoReserva;
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
		
		
		this.setMostraridProcesoIessFondoReserva(esInicial);
		this.setMostrarid_anioProcesoIessFondoReserva(esInicial);
		this.setMostrarid_numero_patronalProcesoIessFondoReserva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoIessFondoReservaConstantesFunciones.ID)) {
				this.setMostraridProcesoIessFondoReserva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessFondoReservaConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioProcesoIessFondoReserva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessFondoReservaConstantesFunciones.IDNUMEROPATRONAL)) {
				this.setMostrarid_numero_patronalProcesoIessFondoReserva(esAsigna);
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
		
		
		this.setActivaridProcesoIessFondoReserva(esInicial);
		this.setActivarid_anioProcesoIessFondoReserva(esInicial);
		this.setActivarid_numero_patronalProcesoIessFondoReserva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoIessFondoReservaConstantesFunciones.ID)) {
				this.setActivaridProcesoIessFondoReserva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessFondoReservaConstantesFunciones.IDANIO)) {
				this.setActivarid_anioProcesoIessFondoReserva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessFondoReservaConstantesFunciones.IDNUMEROPATRONAL)) {
				this.setActivarid_numero_patronalProcesoIessFondoReserva(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoIessFondoReservaBeanSwingJInternalFrame procesoiessfondoreservaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoIessFondoReserva(esInicial);
		this.setResaltarid_anioProcesoIessFondoReserva(esInicial);
		this.setResaltarid_numero_patronalProcesoIessFondoReserva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoIessFondoReservaConstantesFunciones.ID)) {
				this.setResaltaridProcesoIessFondoReserva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessFondoReservaConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioProcesoIessFondoReserva(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessFondoReservaConstantesFunciones.IDNUMEROPATRONAL)) {
				this.setResaltarid_numero_patronalProcesoIessFondoReserva(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoIessFondoReservaBeanSwingJInternalFrame procesoiessfondoreservaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoIessFondoReservaProcesoIessFondoReserva=true;

	public Boolean getMostrarBusquedaProcesoIessFondoReservaProcesoIessFondoReserva() {
		return this.mostrarBusquedaProcesoIessFondoReservaProcesoIessFondoReserva;
	}

	public void setMostrarBusquedaProcesoIessFondoReservaProcesoIessFondoReserva(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoIessFondoReservaProcesoIessFondoReserva= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoIessFondoReservaProcesoIessFondoReserva=true;

	public Boolean getActivarBusquedaProcesoIessFondoReservaProcesoIessFondoReserva() {
		return this.activarBusquedaProcesoIessFondoReservaProcesoIessFondoReserva;
	}

	public void setActivarBusquedaProcesoIessFondoReservaProcesoIessFondoReserva(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoIessFondoReservaProcesoIessFondoReserva= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoIessFondoReservaProcesoIessFondoReserva=null;

	public Border getResaltarBusquedaProcesoIessFondoReservaProcesoIessFondoReserva() {
		return this.resaltarBusquedaProcesoIessFondoReservaProcesoIessFondoReserva;
	}

	public void setResaltarBusquedaProcesoIessFondoReservaProcesoIessFondoReserva(Border borderResaltar) {
		this.resaltarBusquedaProcesoIessFondoReservaProcesoIessFondoReserva= borderResaltar;
	}

	public void setResaltarBusquedaProcesoIessFondoReservaProcesoIessFondoReserva(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoIessFondoReservaBeanSwingJInternalFrame procesoiessfondoreservaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoIessFondoReservaProcesoIessFondoReserva= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}