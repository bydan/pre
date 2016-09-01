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

import com.bydan.erp.nomina.util.report.ProcesoCierreMesConstantesFunciones;
import com.bydan.erp.nomina.util.report.ProcesoCierreMesParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ProcesoCierreMesParameterGeneral;

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
final public class ProcesoCierreMesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoCierreMes";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoCierreMes"+ProcesoCierreMesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoCierreMesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoCierreMesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoCierreMesConstantesFunciones.SCHEMA+"_"+ProcesoCierreMesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoCierreMesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoCierreMesConstantesFunciones.SCHEMA+"_"+ProcesoCierreMesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoCierreMesConstantesFunciones.SCHEMA+"_"+ProcesoCierreMesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoCierreMesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoCierreMesConstantesFunciones.SCHEMA+"_"+ProcesoCierreMesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCierreMesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoCierreMesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCierreMesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCierreMesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoCierreMesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCierreMesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoCierreMesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoCierreMesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoCierreMesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoCierreMesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Cierre Meses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Cierre Mes";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Cierre Mes";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoCierreMes";
	public static final String OBJECTNAME="procesocierremes";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="proceso_cierre_mes";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesocierremes from "+ProcesoCierreMesConstantesFunciones.SPERSISTENCENAME+" procesocierremes";
	public static String QUERYSELECTNATIVE="select "+ProcesoCierreMesConstantesFunciones.SCHEMA+"."+ProcesoCierreMesConstantesFunciones.TABLENAME+".id,"+ProcesoCierreMesConstantesFunciones.SCHEMA+"."+ProcesoCierreMesConstantesFunciones.TABLENAME+".version_row,"+ProcesoCierreMesConstantesFunciones.SCHEMA+"."+ProcesoCierreMesConstantesFunciones.TABLENAME+".id_mes,"+ProcesoCierreMesConstantesFunciones.SCHEMA+"."+ProcesoCierreMesConstantesFunciones.TABLENAME+".id_estructura,"+ProcesoCierreMesConstantesFunciones.SCHEMA+"."+ProcesoCierreMesConstantesFunciones.TABLENAME+".es_para_reversion from "+ProcesoCierreMesConstantesFunciones.SCHEMA+"."+ProcesoCierreMesConstantesFunciones.TABLENAME;//+" as "+ProcesoCierreMesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDMES= "id_mes";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String ESPARAREVERSION= "es_para_reversion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_ESPARAREVERSION= "Es Para Reversion";
		public static final String LABEL_ESPARAREVERSION_LOWER= "Es Para Reversion";
	
		
		
		
		
		
	
	public static String getProcesoCierreMesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoCierreMesConstantesFunciones.IDMES)) {sLabelColumna=ProcesoCierreMesConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(ProcesoCierreMesConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=ProcesoCierreMesConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(ProcesoCierreMesConstantesFunciones.ESPARAREVERSION)) {sLabelColumna=ProcesoCierreMesConstantesFunciones.LABEL_ESPARAREVERSION;}
		
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
	
	
	
			
			
			
			
		
	public static String getes_para_reversionDescripcion(ProcesoCierreMes procesocierremes) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!procesocierremes.getes_para_reversion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_para_reversionHtmlDescripcion(ProcesoCierreMes procesocierremes) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(procesocierremes.getId(),procesocierremes.getes_para_reversion());

		return sDescripcion;
	}	
	
	public static String getProcesoCierreMesDescripcion(ProcesoCierreMes procesocierremes) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesocierremes !=null/* && procesocierremes.getId()!=0*/) {
			if(procesocierremes.getId()!=null) {
				sDescripcion=procesocierremes.getId().toString();
			}//procesocierremesprocesocierremes.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoCierreMesDescripcionDetallado(ProcesoCierreMes procesocierremes) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoCierreMesConstantesFunciones.ID+"=";
		sDescripcion+=procesocierremes.getId().toString()+",";
		sDescripcion+=ProcesoCierreMesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesocierremes.getVersionRow().toString()+",";
		sDescripcion+=ProcesoCierreMesConstantesFunciones.IDMES+"=";
		sDescripcion+=procesocierremes.getid_mes().toString()+",";
		sDescripcion+=ProcesoCierreMesConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=procesocierremes.getid_estructura().toString()+",";
		sDescripcion+=ProcesoCierreMesConstantesFunciones.ESPARAREVERSION+"=";
		sDescripcion+=procesocierremes.getes_para_reversion().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoCierreMesDescripcion(ProcesoCierreMes procesocierremes,String sValor) throws Exception {			
		if(procesocierremes !=null) {
			//procesocierremesprocesocierremes.getId().toString();
		}		
	}
	
		

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}

	public static String getEstructuraDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estructura!=null/*&&estructura.getId()>0*/) {
			sDescripcion=EstructuraConstantesFunciones.getEstructuraDescripcion(estructura);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesoCierreMes")) {
			sNombreIndice="Tipo=  Por Mes Por Estructura Por Es Para Reversion";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesoCierreMes(Long id_mes,Long id_estructura,Boolean es_para_reversion) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();}
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();}
		if(es_para_reversion!=null) {sDetalleIndice+=" Es Para Reversion="+es_para_reversion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstructura(Long id_estructura) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoCierreMes(ProcesoCierreMes procesocierremes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesoCierreMess(List<ProcesoCierreMes> procesocierremess,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoCierreMes procesocierremes: procesocierremess) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoCierreMes(ProcesoCierreMes procesocierremes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesocierremes.getConCambioAuxiliar()) {
			procesocierremes.setIsDeleted(procesocierremes.getIsDeletedAuxiliar());	
			procesocierremes.setIsNew(procesocierremes.getIsNewAuxiliar());	
			procesocierremes.setIsChanged(procesocierremes.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesocierremes.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesocierremes.setIsDeletedAuxiliar(false);	
			procesocierremes.setIsNewAuxiliar(false);	
			procesocierremes.setIsChangedAuxiliar(false);
			
			procesocierremes.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoCierreMess(List<ProcesoCierreMes> procesocierremess,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoCierreMes procesocierremes : procesocierremess) {
			if(conAsignarBase && procesocierremes.getConCambioAuxiliar()) {
				procesocierremes.setIsDeleted(procesocierremes.getIsDeletedAuxiliar());	
				procesocierremes.setIsNew(procesocierremes.getIsNewAuxiliar());	
				procesocierremes.setIsChanged(procesocierremes.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesocierremes.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesocierremes.setIsDeletedAuxiliar(false);	
				procesocierremes.setIsNewAuxiliar(false);	
				procesocierremes.setIsChangedAuxiliar(false);
				
				procesocierremes.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoCierreMes(ProcesoCierreMes procesocierremes,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoCierreMess(List<ProcesoCierreMes> procesocierremess,Boolean conEnteros) throws Exception  {
		
		for(ProcesoCierreMes procesocierremes: procesocierremess) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoCierreMes(List<ProcesoCierreMes> procesocierremess,ProcesoCierreMes procesocierremesAux) throws Exception  {
		ProcesoCierreMesConstantesFunciones.InicializarValoresProcesoCierreMes(procesocierremesAux,true);
		
		for(ProcesoCierreMes procesocierremes: procesocierremess) {
			if(procesocierremes.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCierreMes(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoCierreMesConstantesFunciones.getArrayColumnasGlobalesProcesoCierreMes(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCierreMes(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoCierreMes(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoCierreMes> procesocierremess,ProcesoCierreMes procesocierremes,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoCierreMes procesocierremesAux: procesocierremess) {
			if(procesocierremesAux!=null && procesocierremes!=null) {
				if((procesocierremesAux.getId()==null && procesocierremes.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesocierremesAux.getId()!=null && procesocierremes.getId()!=null){
					if(procesocierremesAux.getId().equals(procesocierremes.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoCierreMes(List<ProcesoCierreMes> procesocierremess) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoCierreMes procesocierremes: procesocierremess) {			
			if(procesocierremes.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoCierreMes() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoCierreMes() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCierreMes() throws Exception  {
		return ProcesoCierreMesConstantesFunciones.getTiposSeleccionarProcesoCierreMes(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCierreMes(Boolean conFk) throws Exception  {
		return ProcesoCierreMesConstantesFunciones.getTiposSeleccionarProcesoCierreMes(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCierreMes(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCierreMesConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(ProcesoCierreMesConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCierreMesConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(ProcesoCierreMesConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCierreMesConstantesFunciones.LABEL_ESPARAREVERSION);
			reporte.setsDescripcion(ProcesoCierreMesConstantesFunciones.LABEL_ESPARAREVERSION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoCierreMes(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoCierreMes(ProcesoCierreMes procesocierremesAux) throws Exception {
		
			procesocierremesAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(procesocierremesAux.getMes()));
			procesocierremesAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(procesocierremesAux.getEstructura()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoCierreMes(List<ProcesoCierreMes> procesocierremessTemp) throws Exception {
		for(ProcesoCierreMes procesocierremesAux:procesocierremessTemp) {
			
			procesocierremesAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(procesocierremesAux.getMes()));
			procesocierremesAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(procesocierremesAux.getEstructura()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoCierreMes(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Estructura.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoCierreMes(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoCierreMes(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoCierreMesConstantesFunciones.getClassesRelationshipsOfProcesoCierreMes(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoCierreMes(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoCierreMes(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoCierreMesConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoCierreMes(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoCierreMes(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoCierreMes procesocierremes,List<ProcesoCierreMes> procesocierremess,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoCierreMes procesocierremes,List<ProcesoCierreMes> procesocierremess) throws Exception {
		try	{			
			for(ProcesoCierreMes procesocierremesLocal:procesocierremess) {
				if(procesocierremesLocal.getId().equals(procesocierremes.getId())) {
					procesocierremesLocal.setIsSelected(procesocierremes.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoCierreMes(List<ProcesoCierreMes> procesocierremessAux) throws Exception {
		//this.procesocierremessAux=procesocierremessAux;
		
		for(ProcesoCierreMes procesocierremesAux:procesocierremessAux) {
			if(procesocierremesAux.getIsChanged()) {
				procesocierremesAux.setIsChanged(false);
			}		
			
			if(procesocierremesAux.getIsNew()) {
				procesocierremesAux.setIsNew(false);
			}	
			
			if(procesocierremesAux.getIsDeleted()) {
				procesocierremesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoCierreMes(ProcesoCierreMes procesocierremesAux) throws Exception {
		//this.procesocierremesAux=procesocierremesAux;
		
			if(procesocierremesAux.getIsChanged()) {
				procesocierremesAux.setIsChanged(false);
			}		
			
			if(procesocierremesAux.getIsNew()) {
				procesocierremesAux.setIsNew(false);
			}	
			
			if(procesocierremesAux.getIsDeleted()) {
				procesocierremesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoCierreMes procesocierremesAsignar,ProcesoCierreMes procesocierremes) throws Exception {
		procesocierremesAsignar.setId(procesocierremes.getId());	
		procesocierremesAsignar.setVersionRow(procesocierremes.getVersionRow());	
		procesocierremesAsignar.setid_mes(procesocierremes.getid_mes());
		procesocierremesAsignar.setmes_descripcion(procesocierremes.getmes_descripcion());	
		procesocierremesAsignar.setid_estructura(procesocierremes.getid_estructura());
		procesocierremesAsignar.setestructura_descripcion(procesocierremes.getestructura_descripcion());	
		procesocierremesAsignar.setes_para_reversion(procesocierremes.getes_para_reversion());	
	}
	
	public static void inicializarProcesoCierreMes(ProcesoCierreMes procesocierremes) throws Exception {
		try {
				procesocierremes.setId(0L);	
					
				procesocierremes.setid_mes(null);	
				procesocierremes.setid_estructura(-1L);	
				procesocierremes.setes_para_reversion(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoCierreMes(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCierreMesConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCierreMesConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCierreMesConstantesFunciones.LABEL_ESPARAREVERSION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoCierreMes(String sTipo,Row row,Workbook workbook,ProcesoCierreMes procesocierremes,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocierremes.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocierremes.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(procesocierremes.getes_para_reversion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoCierreMes="";
	
	public String getsFinalQueryProcesoCierreMes() {
		return this.sFinalQueryProcesoCierreMes;
	}
	
	public void setsFinalQueryProcesoCierreMes(String sFinalQueryProcesoCierreMes) {
		this.sFinalQueryProcesoCierreMes= sFinalQueryProcesoCierreMes;
	}
	
	public Border resaltarSeleccionarProcesoCierreMes=null;
	
	public Border setResaltarSeleccionarProcesoCierreMes(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreMesBeanSwingJInternalFrame procesocierremesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesocierremesBeanSwingJInternalFrame.jTtoolBarProcesoCierreMes.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoCierreMes= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoCierreMes() {
		return this.resaltarSeleccionarProcesoCierreMes;
	}
	
	public void setResaltarSeleccionarProcesoCierreMes(Border borderResaltarSeleccionarProcesoCierreMes) {
		this.resaltarSeleccionarProcesoCierreMes= borderResaltarSeleccionarProcesoCierreMes;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoCierreMes=null;
	public Boolean mostraridProcesoCierreMes=true;
	public Boolean activaridProcesoCierreMes=true;

	public Border resaltarid_mesProcesoCierreMes=null;
	public Boolean mostrarid_mesProcesoCierreMes=true;
	public Boolean activarid_mesProcesoCierreMes=true;
	public Boolean cargarid_mesProcesoCierreMes=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesProcesoCierreMes=false;//ConEventDepend=true

	public Border resaltarid_estructuraProcesoCierreMes=null;
	public Boolean mostrarid_estructuraProcesoCierreMes=true;
	public Boolean activarid_estructuraProcesoCierreMes=true;
	public Boolean cargarid_estructuraProcesoCierreMes=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraProcesoCierreMes=false;//ConEventDepend=true

	public Border resaltares_para_reversionProcesoCierreMes=null;
	public Boolean mostrares_para_reversionProcesoCierreMes=true;
	public Boolean activares_para_reversionProcesoCierreMes=true;

	
	

	public Border setResaltaridProcesoCierreMes(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreMesBeanSwingJInternalFrame procesocierremesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocierremesBeanSwingJInternalFrame.jTtoolBarProcesoCierreMes.setBorder(borderResaltar);
		
		this.resaltaridProcesoCierreMes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoCierreMes() {
		return this.resaltaridProcesoCierreMes;
	}

	public void setResaltaridProcesoCierreMes(Border borderResaltar) {
		this.resaltaridProcesoCierreMes= borderResaltar;
	}

	public Boolean getMostraridProcesoCierreMes() {
		return this.mostraridProcesoCierreMes;
	}

	public void setMostraridProcesoCierreMes(Boolean mostraridProcesoCierreMes) {
		this.mostraridProcesoCierreMes= mostraridProcesoCierreMes;
	}

	public Boolean getActivaridProcesoCierreMes() {
		return this.activaridProcesoCierreMes;
	}

	public void setActivaridProcesoCierreMes(Boolean activaridProcesoCierreMes) {
		this.activaridProcesoCierreMes= activaridProcesoCierreMes;
	}

	public Border setResaltarid_mesProcesoCierreMes(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreMesBeanSwingJInternalFrame procesocierremesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocierremesBeanSwingJInternalFrame.jTtoolBarProcesoCierreMes.setBorder(borderResaltar);
		
		this.resaltarid_mesProcesoCierreMes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesProcesoCierreMes() {
		return this.resaltarid_mesProcesoCierreMes;
	}

	public void setResaltarid_mesProcesoCierreMes(Border borderResaltar) {
		this.resaltarid_mesProcesoCierreMes= borderResaltar;
	}

	public Boolean getMostrarid_mesProcesoCierreMes() {
		return this.mostrarid_mesProcesoCierreMes;
	}

	public void setMostrarid_mesProcesoCierreMes(Boolean mostrarid_mesProcesoCierreMes) {
		this.mostrarid_mesProcesoCierreMes= mostrarid_mesProcesoCierreMes;
	}

	public Boolean getActivarid_mesProcesoCierreMes() {
		return this.activarid_mesProcesoCierreMes;
	}

	public void setActivarid_mesProcesoCierreMes(Boolean activarid_mesProcesoCierreMes) {
		this.activarid_mesProcesoCierreMes= activarid_mesProcesoCierreMes;
	}

	public Boolean getCargarid_mesProcesoCierreMes() {
		return this.cargarid_mesProcesoCierreMes;
	}

	public void setCargarid_mesProcesoCierreMes(Boolean cargarid_mesProcesoCierreMes) {
		this.cargarid_mesProcesoCierreMes= cargarid_mesProcesoCierreMes;
	}

	public Border setResaltarid_estructuraProcesoCierreMes(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreMesBeanSwingJInternalFrame procesocierremesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocierremesBeanSwingJInternalFrame.jTtoolBarProcesoCierreMes.setBorder(borderResaltar);
		
		this.resaltarid_estructuraProcesoCierreMes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraProcesoCierreMes() {
		return this.resaltarid_estructuraProcesoCierreMes;
	}

	public void setResaltarid_estructuraProcesoCierreMes(Border borderResaltar) {
		this.resaltarid_estructuraProcesoCierreMes= borderResaltar;
	}

	public Boolean getMostrarid_estructuraProcesoCierreMes() {
		return this.mostrarid_estructuraProcesoCierreMes;
	}

	public void setMostrarid_estructuraProcesoCierreMes(Boolean mostrarid_estructuraProcesoCierreMes) {
		this.mostrarid_estructuraProcesoCierreMes= mostrarid_estructuraProcesoCierreMes;
	}

	public Boolean getActivarid_estructuraProcesoCierreMes() {
		return this.activarid_estructuraProcesoCierreMes;
	}

	public void setActivarid_estructuraProcesoCierreMes(Boolean activarid_estructuraProcesoCierreMes) {
		this.activarid_estructuraProcesoCierreMes= activarid_estructuraProcesoCierreMes;
	}

	public Boolean getCargarid_estructuraProcesoCierreMes() {
		return this.cargarid_estructuraProcesoCierreMes;
	}

	public void setCargarid_estructuraProcesoCierreMes(Boolean cargarid_estructuraProcesoCierreMes) {
		this.cargarid_estructuraProcesoCierreMes= cargarid_estructuraProcesoCierreMes;
	}

	public Border setResaltares_para_reversionProcesoCierreMes(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreMesBeanSwingJInternalFrame procesocierremesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocierremesBeanSwingJInternalFrame.jTtoolBarProcesoCierreMes.setBorder(borderResaltar);
		
		this.resaltares_para_reversionProcesoCierreMes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_para_reversionProcesoCierreMes() {
		return this.resaltares_para_reversionProcesoCierreMes;
	}

	public void setResaltares_para_reversionProcesoCierreMes(Border borderResaltar) {
		this.resaltares_para_reversionProcesoCierreMes= borderResaltar;
	}

	public Boolean getMostrares_para_reversionProcesoCierreMes() {
		return this.mostrares_para_reversionProcesoCierreMes;
	}

	public void setMostrares_para_reversionProcesoCierreMes(Boolean mostrares_para_reversionProcesoCierreMes) {
		this.mostrares_para_reversionProcesoCierreMes= mostrares_para_reversionProcesoCierreMes;
	}

	public Boolean getActivares_para_reversionProcesoCierreMes() {
		return this.activares_para_reversionProcesoCierreMes;
	}

	public void setActivares_para_reversionProcesoCierreMes(Boolean activares_para_reversionProcesoCierreMes) {
		this.activares_para_reversionProcesoCierreMes= activares_para_reversionProcesoCierreMes;
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
		
		
		this.setMostraridProcesoCierreMes(esInicial);
		this.setMostrarid_mesProcesoCierreMes(esInicial);
		this.setMostrarid_estructuraProcesoCierreMes(esInicial);
		this.setMostrares_para_reversionProcesoCierreMes(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCierreMesConstantesFunciones.ID)) {
				this.setMostraridProcesoCierreMes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreMesConstantesFunciones.IDMES)) {
				this.setMostrarid_mesProcesoCierreMes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreMesConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraProcesoCierreMes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreMesConstantesFunciones.ESPARAREVERSION)) {
				this.setMostrares_para_reversionProcesoCierreMes(esAsigna);
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
		
		
		this.setActivaridProcesoCierreMes(esInicial);
		this.setActivarid_mesProcesoCierreMes(esInicial);
		this.setActivarid_estructuraProcesoCierreMes(esInicial);
		this.setActivares_para_reversionProcesoCierreMes(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCierreMesConstantesFunciones.ID)) {
				this.setActivaridProcesoCierreMes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreMesConstantesFunciones.IDMES)) {
				this.setActivarid_mesProcesoCierreMes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreMesConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraProcesoCierreMes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreMesConstantesFunciones.ESPARAREVERSION)) {
				this.setActivares_para_reversionProcesoCierreMes(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoCierreMesBeanSwingJInternalFrame procesocierremesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoCierreMes(esInicial);
		this.setResaltarid_mesProcesoCierreMes(esInicial);
		this.setResaltarid_estructuraProcesoCierreMes(esInicial);
		this.setResaltares_para_reversionProcesoCierreMes(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCierreMesConstantesFunciones.ID)) {
				this.setResaltaridProcesoCierreMes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreMesConstantesFunciones.IDMES)) {
				this.setResaltarid_mesProcesoCierreMes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreMesConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraProcesoCierreMes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreMesConstantesFunciones.ESPARAREVERSION)) {
				this.setResaltares_para_reversionProcesoCierreMes(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoCierreMesBeanSwingJInternalFrame procesocierremesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoCierreMesProcesoCierreMes=true;

	public Boolean getMostrarBusquedaProcesoCierreMesProcesoCierreMes() {
		return this.mostrarBusquedaProcesoCierreMesProcesoCierreMes;
	}

	public void setMostrarBusquedaProcesoCierreMesProcesoCierreMes(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoCierreMesProcesoCierreMes= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoCierreMesProcesoCierreMes=true;

	public Boolean getActivarBusquedaProcesoCierreMesProcesoCierreMes() {
		return this.activarBusquedaProcesoCierreMesProcesoCierreMes;
	}

	public void setActivarBusquedaProcesoCierreMesProcesoCierreMes(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoCierreMesProcesoCierreMes= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoCierreMesProcesoCierreMes=null;

	public Border getResaltarBusquedaProcesoCierreMesProcesoCierreMes() {
		return this.resaltarBusquedaProcesoCierreMesProcesoCierreMes;
	}

	public void setResaltarBusquedaProcesoCierreMesProcesoCierreMes(Border borderResaltar) {
		this.resaltarBusquedaProcesoCierreMesProcesoCierreMes= borderResaltar;
	}

	public void setResaltarBusquedaProcesoCierreMesProcesoCierreMes(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreMesBeanSwingJInternalFrame procesocierremesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoCierreMesProcesoCierreMes= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}