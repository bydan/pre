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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.PeriodoImportExportConstantesFunciones;
import com.bydan.erp.contabilidad.util.PeriodoImportExportParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.PeriodoImportExportParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PeriodoImportExportConstantesFunciones extends PeriodoImportExportConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PeriodoImportExport";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PeriodoImportExport"+PeriodoImportExportConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PeriodoImportExportHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PeriodoImportExportHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PeriodoImportExportConstantesFunciones.SCHEMA+"_"+PeriodoImportExportConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PeriodoImportExportHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PeriodoImportExportConstantesFunciones.SCHEMA+"_"+PeriodoImportExportConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PeriodoImportExportConstantesFunciones.SCHEMA+"_"+PeriodoImportExportConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PeriodoImportExportHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PeriodoImportExportConstantesFunciones.SCHEMA+"_"+PeriodoImportExportConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PeriodoImportExportConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PeriodoImportExportHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PeriodoImportExportConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PeriodoImportExportConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PeriodoImportExportHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PeriodoImportExportConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PeriodoImportExportConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PeriodoImportExportConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PeriodoImportExportConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PeriodoImportExportConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Periodo Importar Exportars";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Periodo Importar Exportar";
	public static final String SCLASSWEBTITULO_LOWER="Periodo Import Export";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PeriodoImportExport";
	public static final String OBJECTNAME="periodoimportexport";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="periodo_import_export";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select periodoimportexport from "+PeriodoImportExportConstantesFunciones.SPERSISTENCENAME+" periodoimportexport";
	public static String QUERYSELECTNATIVE="select "+PeriodoImportExportConstantesFunciones.SCHEMA+"."+PeriodoImportExportConstantesFunciones.TABLENAME+".id,"+PeriodoImportExportConstantesFunciones.SCHEMA+"."+PeriodoImportExportConstantesFunciones.TABLENAME+".version_row,"+PeriodoImportExportConstantesFunciones.SCHEMA+"."+PeriodoImportExportConstantesFunciones.TABLENAME+".codigo,"+PeriodoImportExportConstantesFunciones.SCHEMA+"."+PeriodoImportExportConstantesFunciones.TABLENAME+".id_anio,"+PeriodoImportExportConstantesFunciones.SCHEMA+"."+PeriodoImportExportConstantesFunciones.TABLENAME+".id_mes from "+PeriodoImportExportConstantesFunciones.SCHEMA+"."+PeriodoImportExportConstantesFunciones.TABLENAME;//+" as "+PeriodoImportExportConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PeriodoImportExportConstantesFuncionesAdditional periodoimportexportConstantesFuncionesAdditional=null;
	
	public PeriodoImportExportConstantesFuncionesAdditional getPeriodoImportExportConstantesFuncionesAdditional() {
		return this.periodoimportexportConstantesFuncionesAdditional;
	}
	
	public void setPeriodoImportExportConstantesFuncionesAdditional(PeriodoImportExportConstantesFuncionesAdditional periodoimportexportConstantesFuncionesAdditional) {
		try {
			this.periodoimportexportConstantesFuncionesAdditional=periodoimportexportConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getPeriodoImportExportLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PeriodoImportExportConstantesFunciones.CODIGO)) {sLabelColumna=PeriodoImportExportConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(PeriodoImportExportConstantesFunciones.IDANIO)) {sLabelColumna=PeriodoImportExportConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(PeriodoImportExportConstantesFunciones.IDMES)) {sLabelColumna=PeriodoImportExportConstantesFunciones.LABEL_IDMES;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getPeriodoImportExportDescripcion(PeriodoImportExport periodoimportexport) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(periodoimportexport !=null/* && periodoimportexport.getId()!=0*/) {
			sDescripcion=periodoimportexport.getcodigo();//periodoimportexportperiodoimportexport.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getPeriodoImportExportDescripcionDetallado(PeriodoImportExport periodoimportexport) {
		String sDescripcion="";
			
		sDescripcion+=PeriodoImportExportConstantesFunciones.ID+"=";
		sDescripcion+=periodoimportexport.getId().toString()+",";
		sDescripcion+=PeriodoImportExportConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=periodoimportexport.getVersionRow().toString()+",";
		sDescripcion+=PeriodoImportExportConstantesFunciones.CODIGO+"=";
		sDescripcion+=periodoimportexport.getcodigo()+",";
		sDescripcion+=PeriodoImportExportConstantesFunciones.IDANIO+"=";
		sDescripcion+=periodoimportexport.getid_anio().toString()+",";
		sDescripcion+=PeriodoImportExportConstantesFunciones.IDMES+"=";
		sDescripcion+=periodoimportexport.getid_mes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPeriodoImportExportDescripcion(PeriodoImportExport periodoimportexport,String sValor) throws Exception {			
		if(periodoimportexport !=null) {
			periodoimportexport.setcodigo(sValor);;//periodoimportexportperiodoimportexport.getcodigo().trim();
		}		
	}
	
		

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("PorIdAnioPorIdMes")) {
			sNombreIndice="Tipo=  Por Anio Por Mes";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdAnioPorIdMes(Long id_anio,Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();}
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPeriodoImportExport(PeriodoImportExport periodoimportexport,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		periodoimportexport.setcodigo(periodoimportexport.getcodigo().trim());
	}
	
	public static void quitarEspaciosPeriodoImportExports(List<PeriodoImportExport> periodoimportexports,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PeriodoImportExport periodoimportexport: periodoimportexports) {
			periodoimportexport.setcodigo(periodoimportexport.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPeriodoImportExport(PeriodoImportExport periodoimportexport,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && periodoimportexport.getConCambioAuxiliar()) {
			periodoimportexport.setIsDeleted(periodoimportexport.getIsDeletedAuxiliar());	
			periodoimportexport.setIsNew(periodoimportexport.getIsNewAuxiliar());	
			periodoimportexport.setIsChanged(periodoimportexport.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			periodoimportexport.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			periodoimportexport.setIsDeletedAuxiliar(false);	
			periodoimportexport.setIsNewAuxiliar(false);	
			periodoimportexport.setIsChangedAuxiliar(false);
			
			periodoimportexport.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPeriodoImportExports(List<PeriodoImportExport> periodoimportexports,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PeriodoImportExport periodoimportexport : periodoimportexports) {
			if(conAsignarBase && periodoimportexport.getConCambioAuxiliar()) {
				periodoimportexport.setIsDeleted(periodoimportexport.getIsDeletedAuxiliar());	
				periodoimportexport.setIsNew(periodoimportexport.getIsNewAuxiliar());	
				periodoimportexport.setIsChanged(periodoimportexport.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				periodoimportexport.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				periodoimportexport.setIsDeletedAuxiliar(false);	
				periodoimportexport.setIsNewAuxiliar(false);	
				periodoimportexport.setIsChangedAuxiliar(false);
				
				periodoimportexport.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPeriodoImportExport(PeriodoImportExport periodoimportexport,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPeriodoImportExports(List<PeriodoImportExport> periodoimportexports,Boolean conEnteros) throws Exception  {
		
		for(PeriodoImportExport periodoimportexport: periodoimportexports) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPeriodoImportExport(List<PeriodoImportExport> periodoimportexports,PeriodoImportExport periodoimportexportAux) throws Exception  {
		PeriodoImportExportConstantesFunciones.InicializarValoresPeriodoImportExport(periodoimportexportAux,true);
		
		for(PeriodoImportExport periodoimportexport: periodoimportexports) {
			if(periodoimportexport.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPeriodoImportExport(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PeriodoImportExportConstantesFunciones.getArrayColumnasGlobalesPeriodoImportExport(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPeriodoImportExport(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPeriodoImportExport(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PeriodoImportExport> periodoimportexports,PeriodoImportExport periodoimportexport,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PeriodoImportExport periodoimportexportAux: periodoimportexports) {
			if(periodoimportexportAux!=null && periodoimportexport!=null) {
				if((periodoimportexportAux.getId()==null && periodoimportexport.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(periodoimportexportAux.getId()!=null && periodoimportexport.getId()!=null){
					if(periodoimportexportAux.getId().equals(periodoimportexport.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPeriodoImportExport(List<PeriodoImportExport> periodoimportexports) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PeriodoImportExport periodoimportexport: periodoimportexports) {			
			if(periodoimportexport.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPeriodoImportExport() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PeriodoImportExportConstantesFunciones.LABEL_ID, PeriodoImportExportConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoImportExportConstantesFunciones.LABEL_VERSIONROW, PeriodoImportExportConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoImportExportConstantesFunciones.LABEL_CODIGO, PeriodoImportExportConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoImportExportConstantesFunciones.LABEL_IDANIO, PeriodoImportExportConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoImportExportConstantesFunciones.LABEL_IDMES, PeriodoImportExportConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPeriodoImportExport() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PeriodoImportExportConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoImportExportConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoImportExportConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoImportExportConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoImportExportConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPeriodoImportExport() throws Exception  {
		return PeriodoImportExportConstantesFunciones.getTiposSeleccionarPeriodoImportExport(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPeriodoImportExport(Boolean conFk) throws Exception  {
		return PeriodoImportExportConstantesFunciones.getTiposSeleccionarPeriodoImportExport(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPeriodoImportExport(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PeriodoImportExportConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(PeriodoImportExportConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PeriodoImportExportConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(PeriodoImportExportConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PeriodoImportExportConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(PeriodoImportExportConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPeriodoImportExport(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPeriodoImportExport(PeriodoImportExport periodoimportexportAux) throws Exception {
		
			periodoimportexportAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(periodoimportexportAux.getAnio()));
			periodoimportexportAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(periodoimportexportAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPeriodoImportExport(List<PeriodoImportExport> periodoimportexportsTemp) throws Exception {
		for(PeriodoImportExport periodoimportexportAux:periodoimportexportsTemp) {
			
			periodoimportexportAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(periodoimportexportAux.getAnio()));
			periodoimportexportAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(periodoimportexportAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPeriodoImportExport(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPeriodoImportExport(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPeriodoImportExport(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PeriodoImportExportConstantesFunciones.getClassesRelationshipsOfPeriodoImportExport(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPeriodoImportExport(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ImportarExportar.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ImportarExportar.class)) {
						classes.add(new Classe(ImportarExportar.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPeriodoImportExport(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PeriodoImportExportConstantesFunciones.getClassesRelationshipsFromStringsOfPeriodoImportExport(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPeriodoImportExport(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ImportarExportar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ImportarExportar.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ImportarExportar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ImportarExportar.class)); continue;
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
	public static void actualizarLista(PeriodoImportExport periodoimportexport,List<PeriodoImportExport> periodoimportexports,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PeriodoImportExport periodoimportexportEncontrado=null;
			
			for(PeriodoImportExport periodoimportexportLocal:periodoimportexports) {
				if(periodoimportexportLocal.getId().equals(periodoimportexport.getId())) {
					periodoimportexportEncontrado=periodoimportexportLocal;
					
					periodoimportexportLocal.setIsChanged(periodoimportexport.getIsChanged());
					periodoimportexportLocal.setIsNew(periodoimportexport.getIsNew());
					periodoimportexportLocal.setIsDeleted(periodoimportexport.getIsDeleted());
					
					periodoimportexportLocal.setGeneralEntityOriginal(periodoimportexport.getGeneralEntityOriginal());
					
					periodoimportexportLocal.setId(periodoimportexport.getId());	
					periodoimportexportLocal.setVersionRow(periodoimportexport.getVersionRow());	
					periodoimportexportLocal.setcodigo(periodoimportexport.getcodigo());	
					periodoimportexportLocal.setid_anio(periodoimportexport.getid_anio());	
					periodoimportexportLocal.setid_mes(periodoimportexport.getid_mes());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!periodoimportexport.getIsDeleted()) {
				if(!existe) {
					periodoimportexports.add(periodoimportexport);
				}
			} else {
				if(periodoimportexportEncontrado!=null && permiteQuitar)  {
					periodoimportexports.remove(periodoimportexportEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PeriodoImportExport periodoimportexport,List<PeriodoImportExport> periodoimportexports) throws Exception {
		try	{			
			for(PeriodoImportExport periodoimportexportLocal:periodoimportexports) {
				if(periodoimportexportLocal.getId().equals(periodoimportexport.getId())) {
					periodoimportexportLocal.setIsSelected(periodoimportexport.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPeriodoImportExport(List<PeriodoImportExport> periodoimportexportsAux) throws Exception {
		//this.periodoimportexportsAux=periodoimportexportsAux;
		
		for(PeriodoImportExport periodoimportexportAux:periodoimportexportsAux) {
			if(periodoimportexportAux.getIsChanged()) {
				periodoimportexportAux.setIsChanged(false);
			}		
			
			if(periodoimportexportAux.getIsNew()) {
				periodoimportexportAux.setIsNew(false);
			}	
			
			if(periodoimportexportAux.getIsDeleted()) {
				periodoimportexportAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPeriodoImportExport(PeriodoImportExport periodoimportexportAux) throws Exception {
		//this.periodoimportexportAux=periodoimportexportAux;
		
			if(periodoimportexportAux.getIsChanged()) {
				periodoimportexportAux.setIsChanged(false);
			}		
			
			if(periodoimportexportAux.getIsNew()) {
				periodoimportexportAux.setIsNew(false);
			}	
			
			if(periodoimportexportAux.getIsDeleted()) {
				periodoimportexportAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PeriodoImportExport periodoimportexportAsignar,PeriodoImportExport periodoimportexport) throws Exception {
		periodoimportexportAsignar.setId(periodoimportexport.getId());	
		periodoimportexportAsignar.setVersionRow(periodoimportexport.getVersionRow());	
		periodoimportexportAsignar.setcodigo(periodoimportexport.getcodigo());	
		periodoimportexportAsignar.setid_anio(periodoimportexport.getid_anio());
		periodoimportexportAsignar.setanio_descripcion(periodoimportexport.getanio_descripcion());	
		periodoimportexportAsignar.setid_mes(periodoimportexport.getid_mes());
		periodoimportexportAsignar.setmes_descripcion(periodoimportexport.getmes_descripcion());	
	}
	
	public static void inicializarPeriodoImportExport(PeriodoImportExport periodoimportexport) throws Exception {
		try {
				periodoimportexport.setId(0L);	
					
				periodoimportexport.setcodigo("");	
				periodoimportexport.setid_anio(null);	
				periodoimportexport.setid_mes(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPeriodoImportExport(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PeriodoImportExportConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PeriodoImportExportConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PeriodoImportExportConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPeriodoImportExport(String sTipo,Row row,Workbook workbook,PeriodoImportExport periodoimportexport,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(periodoimportexport.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(periodoimportexport.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(periodoimportexport.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPeriodoImportExport=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPeriodoImportExport() {
		return this.sFinalQueryPeriodoImportExport;
	}
	
	public void setsFinalQueryPeriodoImportExport(String sFinalQueryPeriodoImportExport) {
		this.sFinalQueryPeriodoImportExport= sFinalQueryPeriodoImportExport;
	}
	
	public Border resaltarSeleccionarPeriodoImportExport=null;
	
	public Border setResaltarSeleccionarPeriodoImportExport(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoImportExportBeanSwingJInternalFrame periodoimportexportBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//periodoimportexportBeanSwingJInternalFrame.jTtoolBarPeriodoImportExport.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPeriodoImportExport= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPeriodoImportExport() {
		return this.resaltarSeleccionarPeriodoImportExport;
	}
	
	public void setResaltarSeleccionarPeriodoImportExport(Border borderResaltarSeleccionarPeriodoImportExport) {
		this.resaltarSeleccionarPeriodoImportExport= borderResaltarSeleccionarPeriodoImportExport;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPeriodoImportExport=null;
	public Boolean mostraridPeriodoImportExport=true;
	public Boolean activaridPeriodoImportExport=true;

	public Border resaltarcodigoPeriodoImportExport=null;
	public Boolean mostrarcodigoPeriodoImportExport=true;
	public Boolean activarcodigoPeriodoImportExport=true;

	public Border resaltarid_anioPeriodoImportExport=null;
	public Boolean mostrarid_anioPeriodoImportExport=true;
	public Boolean activarid_anioPeriodoImportExport=true;
	public Boolean cargarid_anioPeriodoImportExport=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioPeriodoImportExport=false;//ConEventDepend=true

	public Border resaltarid_mesPeriodoImportExport=null;
	public Boolean mostrarid_mesPeriodoImportExport=true;
	public Boolean activarid_mesPeriodoImportExport=true;
	public Boolean cargarid_mesPeriodoImportExport=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesPeriodoImportExport=false;//ConEventDepend=true

	
	

	public Border setResaltaridPeriodoImportExport(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoImportExportBeanSwingJInternalFrame periodoimportexportBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periodoimportexportBeanSwingJInternalFrame.jTtoolBarPeriodoImportExport.setBorder(borderResaltar);
		
		this.resaltaridPeriodoImportExport= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPeriodoImportExport() {
		return this.resaltaridPeriodoImportExport;
	}

	public void setResaltaridPeriodoImportExport(Border borderResaltar) {
		this.resaltaridPeriodoImportExport= borderResaltar;
	}

	public Boolean getMostraridPeriodoImportExport() {
		return this.mostraridPeriodoImportExport;
	}

	public void setMostraridPeriodoImportExport(Boolean mostraridPeriodoImportExport) {
		this.mostraridPeriodoImportExport= mostraridPeriodoImportExport;
	}

	public Boolean getActivaridPeriodoImportExport() {
		return this.activaridPeriodoImportExport;
	}

	public void setActivaridPeriodoImportExport(Boolean activaridPeriodoImportExport) {
		this.activaridPeriodoImportExport= activaridPeriodoImportExport;
	}

	public Border setResaltarcodigoPeriodoImportExport(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoImportExportBeanSwingJInternalFrame periodoimportexportBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periodoimportexportBeanSwingJInternalFrame.jTtoolBarPeriodoImportExport.setBorder(borderResaltar);
		
		this.resaltarcodigoPeriodoImportExport= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoPeriodoImportExport() {
		return this.resaltarcodigoPeriodoImportExport;
	}

	public void setResaltarcodigoPeriodoImportExport(Border borderResaltar) {
		this.resaltarcodigoPeriodoImportExport= borderResaltar;
	}

	public Boolean getMostrarcodigoPeriodoImportExport() {
		return this.mostrarcodigoPeriodoImportExport;
	}

	public void setMostrarcodigoPeriodoImportExport(Boolean mostrarcodigoPeriodoImportExport) {
		this.mostrarcodigoPeriodoImportExport= mostrarcodigoPeriodoImportExport;
	}

	public Boolean getActivarcodigoPeriodoImportExport() {
		return this.activarcodigoPeriodoImportExport;
	}

	public void setActivarcodigoPeriodoImportExport(Boolean activarcodigoPeriodoImportExport) {
		this.activarcodigoPeriodoImportExport= activarcodigoPeriodoImportExport;
	}

	public Border setResaltarid_anioPeriodoImportExport(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoImportExportBeanSwingJInternalFrame periodoimportexportBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periodoimportexportBeanSwingJInternalFrame.jTtoolBarPeriodoImportExport.setBorder(borderResaltar);
		
		this.resaltarid_anioPeriodoImportExport= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioPeriodoImportExport() {
		return this.resaltarid_anioPeriodoImportExport;
	}

	public void setResaltarid_anioPeriodoImportExport(Border borderResaltar) {
		this.resaltarid_anioPeriodoImportExport= borderResaltar;
	}

	public Boolean getMostrarid_anioPeriodoImportExport() {
		return this.mostrarid_anioPeriodoImportExport;
	}

	public void setMostrarid_anioPeriodoImportExport(Boolean mostrarid_anioPeriodoImportExport) {
		this.mostrarid_anioPeriodoImportExport= mostrarid_anioPeriodoImportExport;
	}

	public Boolean getActivarid_anioPeriodoImportExport() {
		return this.activarid_anioPeriodoImportExport;
	}

	public void setActivarid_anioPeriodoImportExport(Boolean activarid_anioPeriodoImportExport) {
		this.activarid_anioPeriodoImportExport= activarid_anioPeriodoImportExport;
	}

	public Boolean getCargarid_anioPeriodoImportExport() {
		return this.cargarid_anioPeriodoImportExport;
	}

	public void setCargarid_anioPeriodoImportExport(Boolean cargarid_anioPeriodoImportExport) {
		this.cargarid_anioPeriodoImportExport= cargarid_anioPeriodoImportExport;
	}

	public Border setResaltarid_mesPeriodoImportExport(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoImportExportBeanSwingJInternalFrame periodoimportexportBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periodoimportexportBeanSwingJInternalFrame.jTtoolBarPeriodoImportExport.setBorder(borderResaltar);
		
		this.resaltarid_mesPeriodoImportExport= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesPeriodoImportExport() {
		return this.resaltarid_mesPeriodoImportExport;
	}

	public void setResaltarid_mesPeriodoImportExport(Border borderResaltar) {
		this.resaltarid_mesPeriodoImportExport= borderResaltar;
	}

	public Boolean getMostrarid_mesPeriodoImportExport() {
		return this.mostrarid_mesPeriodoImportExport;
	}

	public void setMostrarid_mesPeriodoImportExport(Boolean mostrarid_mesPeriodoImportExport) {
		this.mostrarid_mesPeriodoImportExport= mostrarid_mesPeriodoImportExport;
	}

	public Boolean getActivarid_mesPeriodoImportExport() {
		return this.activarid_mesPeriodoImportExport;
	}

	public void setActivarid_mesPeriodoImportExport(Boolean activarid_mesPeriodoImportExport) {
		this.activarid_mesPeriodoImportExport= activarid_mesPeriodoImportExport;
	}

	public Boolean getCargarid_mesPeriodoImportExport() {
		return this.cargarid_mesPeriodoImportExport;
	}

	public void setCargarid_mesPeriodoImportExport(Boolean cargarid_mesPeriodoImportExport) {
		this.cargarid_mesPeriodoImportExport= cargarid_mesPeriodoImportExport;
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
		
		
		this.setMostraridPeriodoImportExport(esInicial);
		this.setMostrarcodigoPeriodoImportExport(esInicial);
		this.setMostrarid_anioPeriodoImportExport(esInicial);
		this.setMostrarid_mesPeriodoImportExport(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PeriodoImportExportConstantesFunciones.ID)) {
				this.setMostraridPeriodoImportExport(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoImportExportConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoPeriodoImportExport(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoImportExportConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioPeriodoImportExport(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoImportExportConstantesFunciones.IDMES)) {
				this.setMostrarid_mesPeriodoImportExport(esAsigna);
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
		
		
		this.setActivaridPeriodoImportExport(esInicial);
		this.setActivarcodigoPeriodoImportExport(esInicial);
		this.setActivarid_anioPeriodoImportExport(esInicial);
		this.setActivarid_mesPeriodoImportExport(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PeriodoImportExportConstantesFunciones.ID)) {
				this.setActivaridPeriodoImportExport(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoImportExportConstantesFunciones.CODIGO)) {
				this.setActivarcodigoPeriodoImportExport(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoImportExportConstantesFunciones.IDANIO)) {
				this.setActivarid_anioPeriodoImportExport(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoImportExportConstantesFunciones.IDMES)) {
				this.setActivarid_mesPeriodoImportExport(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PeriodoImportExportBeanSwingJInternalFrame periodoimportexportBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPeriodoImportExport(esInicial);
		this.setResaltarcodigoPeriodoImportExport(esInicial);
		this.setResaltarid_anioPeriodoImportExport(esInicial);
		this.setResaltarid_mesPeriodoImportExport(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PeriodoImportExportConstantesFunciones.ID)) {
				this.setResaltaridPeriodoImportExport(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoImportExportConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoPeriodoImportExport(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoImportExportConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioPeriodoImportExport(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoImportExportConstantesFunciones.IDMES)) {
				this.setResaltarid_mesPeriodoImportExport(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PeriodoImportExportBeanSwingJInternalFrame periodoimportexportBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoPeriodoImportExport=true;

	public Boolean getMostrarBusquedaPorCodigoPeriodoImportExport() {
		return this.mostrarBusquedaPorCodigoPeriodoImportExport;
	}

	public void setMostrarBusquedaPorCodigoPeriodoImportExport(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoPeriodoImportExport= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdAnioPeriodoImportExport=true;

	public Boolean getMostrarFK_IdAnioPeriodoImportExport() {
		return this.mostrarFK_IdAnioPeriodoImportExport;
	}

	public void setMostrarFK_IdAnioPeriodoImportExport(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioPeriodoImportExport= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoPeriodoImportExport=true;

	public Boolean getActivarBusquedaPorCodigoPeriodoImportExport() {
		return this.activarBusquedaPorCodigoPeriodoImportExport;
	}

	public void setActivarBusquedaPorCodigoPeriodoImportExport(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoPeriodoImportExport= habilitarResaltar;
	}

	public Boolean activarFK_IdAnioPeriodoImportExport=true;

	public Boolean getActivarFK_IdAnioPeriodoImportExport() {
		return this.activarFK_IdAnioPeriodoImportExport;
	}

	public void setActivarFK_IdAnioPeriodoImportExport(Boolean habilitarResaltar) {
		this.activarFK_IdAnioPeriodoImportExport= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoPeriodoImportExport=null;

	public Border getResaltarBusquedaPorCodigoPeriodoImportExport() {
		return this.resaltarBusquedaPorCodigoPeriodoImportExport;
	}

	public void setResaltarBusquedaPorCodigoPeriodoImportExport(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoPeriodoImportExport= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoPeriodoImportExport(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoImportExportBeanSwingJInternalFrame periodoimportexportBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoPeriodoImportExport= borderResaltar;
	}

	public Border resaltarFK_IdAnioPeriodoImportExport=null;

	public Border getResaltarFK_IdAnioPeriodoImportExport() {
		return this.resaltarFK_IdAnioPeriodoImportExport;
	}

	public void setResaltarFK_IdAnioPeriodoImportExport(Border borderResaltar) {
		this.resaltarFK_IdAnioPeriodoImportExport= borderResaltar;
	}

	public void setResaltarFK_IdAnioPeriodoImportExport(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoImportExportBeanSwingJInternalFrame periodoimportexportBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioPeriodoImportExport= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}