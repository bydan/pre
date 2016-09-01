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
package com.bydan.erp.cartera.util.report;

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


import com.bydan.erp.cartera.util.report.CobrarAnalisisCarterasConstantesFunciones;
import com.bydan.erp.cartera.util.report.CobrarAnalisisCarterasParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarAnalisisCarterasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CobrarAnalisisCarterasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="CobrarAnalisisCarteras";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CobrarAnalisisCarteras"+CobrarAnalisisCarterasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CobrarAnalisisCarterasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CobrarAnalisisCarterasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CobrarAnalisisCarterasConstantesFunciones.SCHEMA+"_"+CobrarAnalisisCarterasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CobrarAnalisisCarterasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CobrarAnalisisCarterasConstantesFunciones.SCHEMA+"_"+CobrarAnalisisCarterasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CobrarAnalisisCarterasConstantesFunciones.SCHEMA+"_"+CobrarAnalisisCarterasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CobrarAnalisisCarterasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CobrarAnalisisCarterasConstantesFunciones.SCHEMA+"_"+CobrarAnalisisCarterasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarAnalisisCarterasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarAnalisisCarterasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarAnalisisCarterasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarAnalisisCarterasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarAnalisisCarterasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarAnalisisCarterasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CobrarAnalisisCarterasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CobrarAnalisisCarterasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CobrarAnalisisCarterasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CobrarAnalisisCarterasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cobrar Analisis Carterases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cobrar Analisis Carteras";
	public static final String SCLASSWEBTITULO_LOWER="Cobrar Analisis Carteras";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CobrarAnalisisCarteras";
	public static final String OBJECTNAME="cobraranalisiscarteras";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cobrar_analisis_carteras";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cobraranalisiscarteras from "+CobrarAnalisisCarterasConstantesFunciones.SPERSISTENCENAME+" cobraranalisiscarteras";
	public static String QUERYSELECTNATIVE="select "+CobrarAnalisisCarterasConstantesFunciones.SCHEMA+"."+CobrarAnalisisCarterasConstantesFunciones.TABLENAME+".id,"+CobrarAnalisisCarterasConstantesFunciones.SCHEMA+"."+CobrarAnalisisCarterasConstantesFunciones.TABLENAME+".version_row,"+CobrarAnalisisCarterasConstantesFunciones.SCHEMA+"."+CobrarAnalisisCarterasConstantesFunciones.TABLENAME+".id_empresa,"+CobrarAnalisisCarterasConstantesFunciones.SCHEMA+"."+CobrarAnalisisCarterasConstantesFunciones.TABLENAME+".nombre_tipo_radio_venci,"+CobrarAnalisisCarterasConstantesFunciones.SCHEMA+"."+CobrarAnalisisCarterasConstantesFunciones.TABLENAME+".dia_desde,"+CobrarAnalisisCarterasConstantesFunciones.SCHEMA+"."+CobrarAnalisisCarterasConstantesFunciones.TABLENAME+".dia_hasta from "+CobrarAnalisisCarterasConstantesFunciones.SCHEMA+"."+CobrarAnalisisCarterasConstantesFunciones.TABLENAME;//+" as "+CobrarAnalisisCarterasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRETIPORADIOVENCI= "nombre_tipo_radio_venci";
    public static final String DIADESDE= "dia_desde";
    public static final String DIAHASTA= "dia_hasta";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "id Empresa";
    	public static final String LABEL_NOMBRETIPORADIOVENCI= "Nombre Tipo Radio Venci";
		public static final String LABEL_NOMBRETIPORADIOVENCI_LOWER= "Nombre Tipo Radio Venci";
    	public static final String LABEL_DIADESDE= "Dia Desde";
		public static final String LABEL_DIADESDE_LOWER= "Dia Desde";
    	public static final String LABEL_DIAHASTA= "Dia Hasta";
		public static final String LABEL_DIAHASTA_LOWER= "Dia Hasta";
	
		
		
		
	public static final String SREGEXNOMBRE_TIPO_RADIO_VENCI=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TIPO_RADIO_VENCI=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getCobrarAnalisisCarterasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CobrarAnalisisCarterasConstantesFunciones.IDEMPRESA)) {sLabelColumna=CobrarAnalisisCarterasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CobrarAnalisisCarterasConstantesFunciones.NOMBRETIPORADIOVENCI)) {sLabelColumna=CobrarAnalisisCarterasConstantesFunciones.LABEL_NOMBRETIPORADIOVENCI;}
		if(sNombreColumna.equals(CobrarAnalisisCarterasConstantesFunciones.DIADESDE)) {sLabelColumna=CobrarAnalisisCarterasConstantesFunciones.LABEL_DIADESDE;}
		if(sNombreColumna.equals(CobrarAnalisisCarterasConstantesFunciones.DIAHASTA)) {sLabelColumna=CobrarAnalisisCarterasConstantesFunciones.LABEL_DIAHASTA;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getCobrarAnalisisCarterasDescripcion(CobrarAnalisisCarteras cobraranalisiscarteras) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cobraranalisiscarteras !=null/* && cobraranalisiscarteras.getId()!=0*/) {
			sDescripcion=cobraranalisiscarteras.getnombre_tipo_radio_venci();//cobraranalisiscarterascobraranalisiscarteras.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCobrarAnalisisCarterasDescripcionDetallado(CobrarAnalisisCarteras cobraranalisiscarteras) {
		String sDescripcion="";
			
		sDescripcion+=CobrarAnalisisCarterasConstantesFunciones.ID+"=";
		sDescripcion+=cobraranalisiscarteras.getId().toString()+",";
		sDescripcion+=CobrarAnalisisCarterasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cobraranalisiscarteras.getVersionRow().toString()+",";
		sDescripcion+=CobrarAnalisisCarterasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cobraranalisiscarteras.getid_empresa().toString()+",";
		sDescripcion+=CobrarAnalisisCarterasConstantesFunciones.NOMBRETIPORADIOVENCI+"=";
		sDescripcion+=cobraranalisiscarteras.getnombre_tipo_radio_venci()+",";
		sDescripcion+=CobrarAnalisisCarterasConstantesFunciones.DIADESDE+"=";
		sDescripcion+=cobraranalisiscarteras.getdia_desde().toString()+",";
		sDescripcion+=CobrarAnalisisCarterasConstantesFunciones.DIAHASTA+"=";
		sDescripcion+=cobraranalisiscarteras.getdia_hasta().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCobrarAnalisisCarterasDescripcion(CobrarAnalisisCarteras cobraranalisiscarteras,String sValor) throws Exception {			
		if(cobraranalisiscarteras !=null) {
			cobraranalisiscarteras.setnombre_tipo_radio_venci(sValor);//cobraranalisiscarterascobraranalisiscarteras.getId().toString();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaCobrarAnalisisCarteras")) {
			sNombreIndice="Tipo=  Por Id";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaCobrarAnalisisCarteras(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCobrarAnalisisCarteras(CobrarAnalisisCarteras cobraranalisiscarteras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobraranalisiscarteras.setnombre_tipo_radio_venci(cobraranalisiscarteras.getnombre_tipo_radio_venci().trim());
	}
	
	public static void quitarEspaciosCobrarAnalisisCarterass(List<CobrarAnalisisCarteras> cobraranalisiscarterass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarAnalisisCarteras cobraranalisiscarteras: cobraranalisiscarterass) {
			cobraranalisiscarteras.setnombre_tipo_radio_venci(cobraranalisiscarteras.getnombre_tipo_radio_venci().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarAnalisisCarteras(CobrarAnalisisCarteras cobraranalisiscarteras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cobraranalisiscarteras.getConCambioAuxiliar()) {
			cobraranalisiscarteras.setIsDeleted(cobraranalisiscarteras.getIsDeletedAuxiliar());	
			cobraranalisiscarteras.setIsNew(cobraranalisiscarteras.getIsNewAuxiliar());	
			cobraranalisiscarteras.setIsChanged(cobraranalisiscarteras.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cobraranalisiscarteras.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cobraranalisiscarteras.setIsDeletedAuxiliar(false);	
			cobraranalisiscarteras.setIsNewAuxiliar(false);	
			cobraranalisiscarteras.setIsChangedAuxiliar(false);
			
			cobraranalisiscarteras.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarAnalisisCarterass(List<CobrarAnalisisCarteras> cobraranalisiscarterass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CobrarAnalisisCarteras cobraranalisiscarteras : cobraranalisiscarterass) {
			if(conAsignarBase && cobraranalisiscarteras.getConCambioAuxiliar()) {
				cobraranalisiscarteras.setIsDeleted(cobraranalisiscarteras.getIsDeletedAuxiliar());	
				cobraranalisiscarteras.setIsNew(cobraranalisiscarteras.getIsNewAuxiliar());	
				cobraranalisiscarteras.setIsChanged(cobraranalisiscarteras.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cobraranalisiscarteras.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cobraranalisiscarteras.setIsDeletedAuxiliar(false);	
				cobraranalisiscarteras.setIsNewAuxiliar(false);	
				cobraranalisiscarteras.setIsChangedAuxiliar(false);
				
				cobraranalisiscarteras.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCobrarAnalisisCarteras(CobrarAnalisisCarteras cobraranalisiscarteras,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			cobraranalisiscarteras.setdia_desde(0);
			cobraranalisiscarteras.setdia_hasta(0);
		}
	}		
	
	public static void InicializarValoresCobrarAnalisisCarterass(List<CobrarAnalisisCarteras> cobraranalisiscarterass,Boolean conEnteros) throws Exception  {
		
		for(CobrarAnalisisCarteras cobraranalisiscarteras: cobraranalisiscarterass) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				cobraranalisiscarteras.setdia_desde(0);
				cobraranalisiscarteras.setdia_hasta(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaCobrarAnalisisCarteras(List<CobrarAnalisisCarteras> cobraranalisiscarterass,CobrarAnalisisCarteras cobraranalisiscarterasAux) throws Exception  {
		CobrarAnalisisCarterasConstantesFunciones.InicializarValoresCobrarAnalisisCarteras(cobraranalisiscarterasAux,true);
		
		for(CobrarAnalisisCarteras cobraranalisiscarteras: cobraranalisiscarterass) {
			if(cobraranalisiscarteras.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cobraranalisiscarterasAux.setdia_desde(cobraranalisiscarterasAux.getdia_desde()+cobraranalisiscarteras.getdia_desde());			
			cobraranalisiscarterasAux.setdia_hasta(cobraranalisiscarterasAux.getdia_hasta()+cobraranalisiscarteras.getdia_hasta());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarAnalisisCarteras(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CobrarAnalisisCarterasConstantesFunciones.getArrayColumnasGlobalesCobrarAnalisisCarteras(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarAnalisisCarteras(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCobrarAnalisisCarteras(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarAnalisisCarteras> cobraranalisiscarterass,CobrarAnalisisCarteras cobraranalisiscarteras,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarAnalisisCarteras cobraranalisiscarterasAux: cobraranalisiscarterass) {
			if(cobraranalisiscarterasAux!=null && cobraranalisiscarteras!=null) {
				if((cobraranalisiscarterasAux.getId()==null && cobraranalisiscarteras.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cobraranalisiscarterasAux.getId()!=null && cobraranalisiscarteras.getId()!=null){
					if(cobraranalisiscarterasAux.getId().equals(cobraranalisiscarteras.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarAnalisisCarteras(List<CobrarAnalisisCarteras> cobraranalisiscarterass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CobrarAnalisisCarteras cobraranalisiscarteras: cobraranalisiscarterass) {			
			if(cobraranalisiscarteras.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCobrarAnalisisCarteras() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CobrarAnalisisCarterasConstantesFunciones.LABEL_VERSIONROW, CobrarAnalisisCarterasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarAnalisisCarterasConstantesFunciones.LABEL_NOMBRETIPORADIOVENCI, CobrarAnalisisCarterasConstantesFunciones.NOMBRETIPORADIOVENCI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarAnalisisCarterasConstantesFunciones.LABEL_DIADESDE, CobrarAnalisisCarterasConstantesFunciones.DIADESDE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarAnalisisCarterasConstantesFunciones.LABEL_DIAHASTA, CobrarAnalisisCarterasConstantesFunciones.DIAHASTA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCobrarAnalisisCarteras() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CobrarAnalisisCarterasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarAnalisisCarterasConstantesFunciones.NOMBRETIPORADIOVENCI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarAnalisisCarterasConstantesFunciones.DIADESDE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarAnalisisCarterasConstantesFunciones.DIAHASTA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarAnalisisCarteras() throws Exception  {
		return CobrarAnalisisCarterasConstantesFunciones.getTiposSeleccionarCobrarAnalisisCarteras(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarAnalisisCarteras(Boolean conFk) throws Exception  {
		return CobrarAnalisisCarterasConstantesFunciones.getTiposSeleccionarCobrarAnalisisCarteras(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarAnalisisCarteras(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarAnalisisCarterasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CobrarAnalisisCarterasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarAnalisisCarterasConstantesFunciones.LABEL_NOMBRETIPORADIOVENCI);
			reporte.setsDescripcion(CobrarAnalisisCarterasConstantesFunciones.LABEL_NOMBRETIPORADIOVENCI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarAnalisisCarterasConstantesFunciones.LABEL_DIADESDE);
			reporte.setsDescripcion(CobrarAnalisisCarterasConstantesFunciones.LABEL_DIADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarAnalisisCarterasConstantesFunciones.LABEL_DIAHASTA);
			reporte.setsDescripcion(CobrarAnalisisCarterasConstantesFunciones.LABEL_DIAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCobrarAnalisisCarteras(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarAnalisisCarteras(CobrarAnalisisCarteras cobraranalisiscarterasAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarAnalisisCarteras(List<CobrarAnalisisCarteras> cobraranalisiscarterassTemp) throws Exception {
		for(CobrarAnalisisCarteras cobraranalisiscarterasAux:cobraranalisiscarterassTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCobrarAnalisisCarteras(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCobrarAnalisisCarteras(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarAnalisisCarteras(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarAnalisisCarterasConstantesFunciones.getClassesRelationshipsOfCobrarAnalisisCarteras(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarAnalisisCarteras(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarAnalisisCarteras(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarAnalisisCarterasConstantesFunciones.getClassesRelationshipsFromStringsOfCobrarAnalisisCarteras(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarAnalisisCarteras(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CobrarAnalisisCarteras cobraranalisiscarteras,List<CobrarAnalisisCarteras> cobraranalisiscarterass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(CobrarAnalisisCarteras cobraranalisiscarteras,List<CobrarAnalisisCarteras> cobraranalisiscarterass) throws Exception {
		try	{			
			for(CobrarAnalisisCarteras cobraranalisiscarterasLocal:cobraranalisiscarterass) {
				if(cobraranalisiscarterasLocal.getId().equals(cobraranalisiscarteras.getId())) {
					cobraranalisiscarterasLocal.setIsSelected(cobraranalisiscarteras.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCobrarAnalisisCarteras(List<CobrarAnalisisCarteras> cobraranalisiscarterassAux) throws Exception {
		//this.cobraranalisiscarterassAux=cobraranalisiscarterassAux;
		
		for(CobrarAnalisisCarteras cobraranalisiscarterasAux:cobraranalisiscarterassAux) {
			if(cobraranalisiscarterasAux.getIsChanged()) {
				cobraranalisiscarterasAux.setIsChanged(false);
			}		
			
			if(cobraranalisiscarterasAux.getIsNew()) {
				cobraranalisiscarterasAux.setIsNew(false);
			}	
			
			if(cobraranalisiscarterasAux.getIsDeleted()) {
				cobraranalisiscarterasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCobrarAnalisisCarteras(CobrarAnalisisCarteras cobraranalisiscarterasAux) throws Exception {
		//this.cobraranalisiscarterasAux=cobraranalisiscarterasAux;
		
			if(cobraranalisiscarterasAux.getIsChanged()) {
				cobraranalisiscarterasAux.setIsChanged(false);
			}		
			
			if(cobraranalisiscarterasAux.getIsNew()) {
				cobraranalisiscarterasAux.setIsNew(false);
			}	
			
			if(cobraranalisiscarterasAux.getIsDeleted()) {
				cobraranalisiscarterasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CobrarAnalisisCarteras cobraranalisiscarterasAsignar,CobrarAnalisisCarteras cobraranalisiscarteras) throws Exception {
		cobraranalisiscarterasAsignar.setVersionRow(cobraranalisiscarteras.getVersionRow());	
		cobraranalisiscarterasAsignar.setnombre_tipo_radio_venci(cobraranalisiscarteras.getnombre_tipo_radio_venci());	
		cobraranalisiscarterasAsignar.setdia_desde(cobraranalisiscarteras.getdia_desde());	
		cobraranalisiscarterasAsignar.setdia_hasta(cobraranalisiscarteras.getdia_hasta());	
	}
	
	public static void inicializarCobrarAnalisisCarteras(CobrarAnalisisCarteras cobraranalisiscarteras) throws Exception {
		try {
					
				cobraranalisiscarteras.setnombre_tipo_radio_venci("");	
				cobraranalisiscarteras.setdia_desde(0);	
				cobraranalisiscarteras.setdia_hasta(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCobrarAnalisisCarteras(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarAnalisisCarterasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarAnalisisCarterasConstantesFunciones.LABEL_NOMBRETIPORADIOVENCI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarAnalisisCarterasConstantesFunciones.LABEL_DIADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarAnalisisCarterasConstantesFunciones.LABEL_DIAHASTA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCobrarAnalisisCarteras(String sTipo,Row row,Workbook workbook,CobrarAnalisisCarteras cobraranalisiscarteras,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cobraranalisiscarteras.getid_empresa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobraranalisiscarteras.getnombre_tipo_radio_venci());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobraranalisiscarteras.getdia_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobraranalisiscarteras.getdia_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCobrarAnalisisCarteras="";
	
	public String getsFinalQueryCobrarAnalisisCarteras() {
		return this.sFinalQueryCobrarAnalisisCarteras;
	}
	
	public void setsFinalQueryCobrarAnalisisCarteras(String sFinalQueryCobrarAnalisisCarteras) {
		this.sFinalQueryCobrarAnalisisCarteras= sFinalQueryCobrarAnalisisCarteras;
	}
	
	public Border resaltarSeleccionarCobrarAnalisisCarteras=null;
	
	public Border setResaltarSeleccionarCobrarAnalisisCarteras(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarAnalisisCarterasBeanSwingJInternalFrame cobraranalisiscarterasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cobraranalisiscarterasBeanSwingJInternalFrame.jTtoolBarCobrarAnalisisCarteras.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCobrarAnalisisCarteras= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCobrarAnalisisCarteras() {
		return this.resaltarSeleccionarCobrarAnalisisCarteras;
	}
	
	public void setResaltarSeleccionarCobrarAnalisisCarteras(Border borderResaltarSeleccionarCobrarAnalisisCarteras) {
		this.resaltarSeleccionarCobrarAnalisisCarteras= borderResaltarSeleccionarCobrarAnalisisCarteras;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCobrarAnalisisCarteras=null;
	public Boolean mostraridCobrarAnalisisCarteras=true;
	public Boolean activaridCobrarAnalisisCarteras=true;

	public Border resaltarid_empresaCobrarAnalisisCarteras=null;
	public Boolean mostrarid_empresaCobrarAnalisisCarteras=true;
	public Boolean activarid_empresaCobrarAnalisisCarteras=true;

	public Border resaltarnombre_tipo_radio_venciCobrarAnalisisCarteras=null;
	public Boolean mostrarnombre_tipo_radio_venciCobrarAnalisisCarteras=true;
	public Boolean activarnombre_tipo_radio_venciCobrarAnalisisCarteras=true;

	public Border resaltardia_desdeCobrarAnalisisCarteras=null;
	public Boolean mostrardia_desdeCobrarAnalisisCarteras=true;
	public Boolean activardia_desdeCobrarAnalisisCarteras=true;

	public Border resaltardia_hastaCobrarAnalisisCarteras=null;
	public Boolean mostrardia_hastaCobrarAnalisisCarteras=true;
	public Boolean activardia_hastaCobrarAnalisisCarteras=true;

	
	

	public Border setResaltaridCobrarAnalisisCarteras(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarAnalisisCarterasBeanSwingJInternalFrame cobraranalisiscarterasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobraranalisiscarterasBeanSwingJInternalFrame.jTtoolBarCobrarAnalisisCarteras.setBorder(borderResaltar);
		
		this.resaltaridCobrarAnalisisCarteras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCobrarAnalisisCarteras() {
		return this.resaltaridCobrarAnalisisCarteras;
	}

	public void setResaltaridCobrarAnalisisCarteras(Border borderResaltar) {
		this.resaltaridCobrarAnalisisCarteras= borderResaltar;
	}

	public Boolean getMostraridCobrarAnalisisCarteras() {
		return this.mostraridCobrarAnalisisCarteras;
	}

	public void setMostraridCobrarAnalisisCarteras(Boolean mostraridCobrarAnalisisCarteras) {
		this.mostraridCobrarAnalisisCarteras= mostraridCobrarAnalisisCarteras;
	}

	public Boolean getActivaridCobrarAnalisisCarteras() {
		return this.activaridCobrarAnalisisCarteras;
	}

	public void setActivaridCobrarAnalisisCarteras(Boolean activaridCobrarAnalisisCarteras) {
		this.activaridCobrarAnalisisCarteras= activaridCobrarAnalisisCarteras;
	}

	public Border setResaltarid_empresaCobrarAnalisisCarteras(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarAnalisisCarterasBeanSwingJInternalFrame cobraranalisiscarterasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobraranalisiscarterasBeanSwingJInternalFrame.jTtoolBarCobrarAnalisisCarteras.setBorder(borderResaltar);
		
		this.resaltarid_empresaCobrarAnalisisCarteras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCobrarAnalisisCarteras() {
		return this.resaltarid_empresaCobrarAnalisisCarteras;
	}

	public void setResaltarid_empresaCobrarAnalisisCarteras(Border borderResaltar) {
		this.resaltarid_empresaCobrarAnalisisCarteras= borderResaltar;
	}

	public Boolean getMostrarid_empresaCobrarAnalisisCarteras() {
		return this.mostrarid_empresaCobrarAnalisisCarteras;
	}

	public void setMostrarid_empresaCobrarAnalisisCarteras(Boolean mostrarid_empresaCobrarAnalisisCarteras) {
		this.mostrarid_empresaCobrarAnalisisCarteras= mostrarid_empresaCobrarAnalisisCarteras;
	}

	public Boolean getActivarid_empresaCobrarAnalisisCarteras() {
		return this.activarid_empresaCobrarAnalisisCarteras;
	}

	public void setActivarid_empresaCobrarAnalisisCarteras(Boolean activarid_empresaCobrarAnalisisCarteras) {
		this.activarid_empresaCobrarAnalisisCarteras= activarid_empresaCobrarAnalisisCarteras;
	}

	public Border setResaltarnombre_tipo_radio_venciCobrarAnalisisCarteras(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarAnalisisCarterasBeanSwingJInternalFrame cobraranalisiscarterasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobraranalisiscarterasBeanSwingJInternalFrame.jTtoolBarCobrarAnalisisCarteras.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_radio_venciCobrarAnalisisCarteras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_radio_venciCobrarAnalisisCarteras() {
		return this.resaltarnombre_tipo_radio_venciCobrarAnalisisCarteras;
	}

	public void setResaltarnombre_tipo_radio_venciCobrarAnalisisCarteras(Border borderResaltar) {
		this.resaltarnombre_tipo_radio_venciCobrarAnalisisCarteras= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_radio_venciCobrarAnalisisCarteras() {
		return this.mostrarnombre_tipo_radio_venciCobrarAnalisisCarteras;
	}

	public void setMostrarnombre_tipo_radio_venciCobrarAnalisisCarteras(Boolean mostrarnombre_tipo_radio_venciCobrarAnalisisCarteras) {
		this.mostrarnombre_tipo_radio_venciCobrarAnalisisCarteras= mostrarnombre_tipo_radio_venciCobrarAnalisisCarteras;
	}

	public Boolean getActivarnombre_tipo_radio_venciCobrarAnalisisCarteras() {
		return this.activarnombre_tipo_radio_venciCobrarAnalisisCarteras;
	}

	public void setActivarnombre_tipo_radio_venciCobrarAnalisisCarteras(Boolean activarnombre_tipo_radio_venciCobrarAnalisisCarteras) {
		this.activarnombre_tipo_radio_venciCobrarAnalisisCarteras= activarnombre_tipo_radio_venciCobrarAnalisisCarteras;
	}

	public Border setResaltardia_desdeCobrarAnalisisCarteras(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarAnalisisCarterasBeanSwingJInternalFrame cobraranalisiscarterasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobraranalisiscarterasBeanSwingJInternalFrame.jTtoolBarCobrarAnalisisCarteras.setBorder(borderResaltar);
		
		this.resaltardia_desdeCobrarAnalisisCarteras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardia_desdeCobrarAnalisisCarteras() {
		return this.resaltardia_desdeCobrarAnalisisCarteras;
	}

	public void setResaltardia_desdeCobrarAnalisisCarteras(Border borderResaltar) {
		this.resaltardia_desdeCobrarAnalisisCarteras= borderResaltar;
	}

	public Boolean getMostrardia_desdeCobrarAnalisisCarteras() {
		return this.mostrardia_desdeCobrarAnalisisCarteras;
	}

	public void setMostrardia_desdeCobrarAnalisisCarteras(Boolean mostrardia_desdeCobrarAnalisisCarteras) {
		this.mostrardia_desdeCobrarAnalisisCarteras= mostrardia_desdeCobrarAnalisisCarteras;
	}

	public Boolean getActivardia_desdeCobrarAnalisisCarteras() {
		return this.activardia_desdeCobrarAnalisisCarteras;
	}

	public void setActivardia_desdeCobrarAnalisisCarteras(Boolean activardia_desdeCobrarAnalisisCarteras) {
		this.activardia_desdeCobrarAnalisisCarteras= activardia_desdeCobrarAnalisisCarteras;
	}

	public Border setResaltardia_hastaCobrarAnalisisCarteras(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarAnalisisCarterasBeanSwingJInternalFrame cobraranalisiscarterasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobraranalisiscarterasBeanSwingJInternalFrame.jTtoolBarCobrarAnalisisCarteras.setBorder(borderResaltar);
		
		this.resaltardia_hastaCobrarAnalisisCarteras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardia_hastaCobrarAnalisisCarteras() {
		return this.resaltardia_hastaCobrarAnalisisCarteras;
	}

	public void setResaltardia_hastaCobrarAnalisisCarteras(Border borderResaltar) {
		this.resaltardia_hastaCobrarAnalisisCarteras= borderResaltar;
	}

	public Boolean getMostrardia_hastaCobrarAnalisisCarteras() {
		return this.mostrardia_hastaCobrarAnalisisCarteras;
	}

	public void setMostrardia_hastaCobrarAnalisisCarteras(Boolean mostrardia_hastaCobrarAnalisisCarteras) {
		this.mostrardia_hastaCobrarAnalisisCarteras= mostrardia_hastaCobrarAnalisisCarteras;
	}

	public Boolean getActivardia_hastaCobrarAnalisisCarteras() {
		return this.activardia_hastaCobrarAnalisisCarteras;
	}

	public void setActivardia_hastaCobrarAnalisisCarteras(Boolean activardia_hastaCobrarAnalisisCarteras) {
		this.activardia_hastaCobrarAnalisisCarteras= activardia_hastaCobrarAnalisisCarteras;
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
		
		
		this.setMostraridCobrarAnalisisCarteras(esInicial);
		this.setMostrarid_empresaCobrarAnalisisCarteras(esInicial);
		this.setMostrarnombre_tipo_radio_venciCobrarAnalisisCarteras(esInicial);
		this.setMostrardia_desdeCobrarAnalisisCarteras(esInicial);
		this.setMostrardia_hastaCobrarAnalisisCarteras(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarAnalisisCarterasConstantesFunciones.ID)) {
				this.setMostraridCobrarAnalisisCarteras(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarAnalisisCarterasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCobrarAnalisisCarteras(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarAnalisisCarterasConstantesFunciones.NOMBRETIPORADIOVENCI)) {
				this.setMostrarnombre_tipo_radio_venciCobrarAnalisisCarteras(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarAnalisisCarterasConstantesFunciones.DIADESDE)) {
				this.setMostrardia_desdeCobrarAnalisisCarteras(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarAnalisisCarterasConstantesFunciones.DIAHASTA)) {
				this.setMostrardia_hastaCobrarAnalisisCarteras(esAsigna);
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
		
		
		this.setActivaridCobrarAnalisisCarteras(esInicial);
		this.setActivarid_empresaCobrarAnalisisCarteras(esInicial);
		this.setActivarnombre_tipo_radio_venciCobrarAnalisisCarteras(esInicial);
		this.setActivardia_desdeCobrarAnalisisCarteras(esInicial);
		this.setActivardia_hastaCobrarAnalisisCarteras(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarAnalisisCarterasConstantesFunciones.ID)) {
				this.setActivaridCobrarAnalisisCarteras(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarAnalisisCarterasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCobrarAnalisisCarteras(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarAnalisisCarterasConstantesFunciones.NOMBRETIPORADIOVENCI)) {
				this.setActivarnombre_tipo_radio_venciCobrarAnalisisCarteras(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarAnalisisCarterasConstantesFunciones.DIADESDE)) {
				this.setActivardia_desdeCobrarAnalisisCarteras(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarAnalisisCarterasConstantesFunciones.DIAHASTA)) {
				this.setActivardia_hastaCobrarAnalisisCarteras(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarAnalisisCarterasBeanSwingJInternalFrame cobraranalisiscarterasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCobrarAnalisisCarteras(esInicial);
		this.setResaltarid_empresaCobrarAnalisisCarteras(esInicial);
		this.setResaltarnombre_tipo_radio_venciCobrarAnalisisCarteras(esInicial);
		this.setResaltardia_desdeCobrarAnalisisCarteras(esInicial);
		this.setResaltardia_hastaCobrarAnalisisCarteras(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarAnalisisCarterasConstantesFunciones.ID)) {
				this.setResaltaridCobrarAnalisisCarteras(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarAnalisisCarterasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCobrarAnalisisCarteras(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarAnalisisCarterasConstantesFunciones.NOMBRETIPORADIOVENCI)) {
				this.setResaltarnombre_tipo_radio_venciCobrarAnalisisCarteras(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarAnalisisCarterasConstantesFunciones.DIADESDE)) {
				this.setResaltardia_desdeCobrarAnalisisCarteras(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarAnalisisCarterasConstantesFunciones.DIAHASTA)) {
				this.setResaltardia_hastaCobrarAnalisisCarteras(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarAnalisisCarterasBeanSwingJInternalFrame cobraranalisiscarterasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaCobrarAnalisisCarterasCobrarAnalisisCarteras=true;

	public Boolean getMostrarBusquedaCobrarAnalisisCarterasCobrarAnalisisCarteras() {
		return this.mostrarBusquedaCobrarAnalisisCarterasCobrarAnalisisCarteras;
	}

	public void setMostrarBusquedaCobrarAnalisisCarterasCobrarAnalisisCarteras(Boolean visibilidadResaltar) {
		this.mostrarBusquedaCobrarAnalisisCarterasCobrarAnalisisCarteras= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaCobrarAnalisisCarterasCobrarAnalisisCarteras=true;

	public Boolean getActivarBusquedaCobrarAnalisisCarterasCobrarAnalisisCarteras() {
		return this.activarBusquedaCobrarAnalisisCarterasCobrarAnalisisCarteras;
	}

	public void setActivarBusquedaCobrarAnalisisCarterasCobrarAnalisisCarteras(Boolean habilitarResaltar) {
		this.activarBusquedaCobrarAnalisisCarterasCobrarAnalisisCarteras= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaCobrarAnalisisCarterasCobrarAnalisisCarteras=null;

	public Border getResaltarBusquedaCobrarAnalisisCarterasCobrarAnalisisCarteras() {
		return this.resaltarBusquedaCobrarAnalisisCarterasCobrarAnalisisCarteras;
	}

	public void setResaltarBusquedaCobrarAnalisisCarterasCobrarAnalisisCarteras(Border borderResaltar) {
		this.resaltarBusquedaCobrarAnalisisCarterasCobrarAnalisisCarteras= borderResaltar;
	}

	public void setResaltarBusquedaCobrarAnalisisCarterasCobrarAnalisisCarteras(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarAnalisisCarterasBeanSwingJInternalFrame cobraranalisiscarterasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaCobrarAnalisisCarterasCobrarAnalisisCarteras= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}