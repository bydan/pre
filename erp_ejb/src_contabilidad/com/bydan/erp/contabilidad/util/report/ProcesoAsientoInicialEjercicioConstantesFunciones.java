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
package com.bydan.erp.contabilidad.util.report;

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

import com.bydan.erp.contabilidad.resources.general.AuxiliarGeneral;

import com.bydan.erp.contabilidad.util.report.ProcesoAsientoInicialEjercicioConstantesFunciones;
import com.bydan.erp.contabilidad.util.report.ProcesoAsientoInicialEjercicioParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.ProcesoAsientoInicialEjercicioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;



import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProcesoAsientoInicialEjercicioConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoAsientoInicialEjercicio";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoAsientoInicialEjercicio"+ProcesoAsientoInicialEjercicioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoAsientoInicialEjercicioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoAsientoInicialEjercicioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoAsientoInicialEjercicioConstantesFunciones.SCHEMA+"_"+ProcesoAsientoInicialEjercicioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoAsientoInicialEjercicioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoAsientoInicialEjercicioConstantesFunciones.SCHEMA+"_"+ProcesoAsientoInicialEjercicioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoAsientoInicialEjercicioConstantesFunciones.SCHEMA+"_"+ProcesoAsientoInicialEjercicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoAsientoInicialEjercicioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoAsientoInicialEjercicioConstantesFunciones.SCHEMA+"_"+ProcesoAsientoInicialEjercicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoAsientoInicialEjercicioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoAsientoInicialEjercicioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoAsientoInicialEjercicioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoAsientoInicialEjercicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoAsientoInicialEjercicioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoAsientoInicialEjercicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoAsientoInicialEjercicioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoAsientoInicialEjercicioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoAsientoInicialEjercicioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoAsientoInicialEjercicioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Asiento Inicial Ejercicios";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Proceso Asiento Inicial Ejercicio";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Asiento Inicial Ejercicio";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoAsientoInicialEjercicio";
	public static final String OBJECTNAME="procesoasientoinicialejercicio";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="proceso_asiento_inicial_ejercicio";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesoasientoinicialejercicio from "+ProcesoAsientoInicialEjercicioConstantesFunciones.SPERSISTENCENAME+" procesoasientoinicialejercicio";
	public static String QUERYSELECTNATIVE="select "+ProcesoAsientoInicialEjercicioConstantesFunciones.SCHEMA+"."+ProcesoAsientoInicialEjercicioConstantesFunciones.TABLENAME+".id,"+ProcesoAsientoInicialEjercicioConstantesFunciones.SCHEMA+"."+ProcesoAsientoInicialEjercicioConstantesFunciones.TABLENAME+".version_row,"+ProcesoAsientoInicialEjercicioConstantesFunciones.SCHEMA+"."+ProcesoAsientoInicialEjercicioConstantesFunciones.TABLENAME+".id_tipo_documento,"+ProcesoAsientoInicialEjercicioConstantesFunciones.SCHEMA+"."+ProcesoAsientoInicialEjercicioConstantesFunciones.TABLENAME+".fecha_inicio,"+ProcesoAsientoInicialEjercicioConstantesFunciones.SCHEMA+"."+ProcesoAsientoInicialEjercicioConstantesFunciones.TABLENAME+".fecha_fin from "+ProcesoAsientoInicialEjercicioConstantesFunciones.SCHEMA+"."+ProcesoAsientoInicialEjercicioConstantesFunciones.TABLENAME;//+" as "+ProcesoAsientoInicialEjercicioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDTIPODOCUMENTO= "id_tipo_documento";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDTIPODOCUMENTO= "Tipo Documento";
		public static final String LABEL_IDTIPODOCUMENTO_LOWER= "Tipo Documento";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
	
		
		
		
		
		
	
	public static String getProcesoAsientoInicialEjercicioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoAsientoInicialEjercicioConstantesFunciones.IDTIPODOCUMENTO)) {sLabelColumna=ProcesoAsientoInicialEjercicioConstantesFunciones.LABEL_IDTIPODOCUMENTO;}
		if(sNombreColumna.equals(ProcesoAsientoInicialEjercicioConstantesFunciones.FECHAINICIO)) {sLabelColumna=ProcesoAsientoInicialEjercicioConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(ProcesoAsientoInicialEjercicioConstantesFunciones.FECHAFIN)) {sLabelColumna=ProcesoAsientoInicialEjercicioConstantesFunciones.LABEL_FECHAFIN;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getProcesoAsientoInicialEjercicioDescripcion(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesoasientoinicialejercicio !=null/* && procesoasientoinicialejercicio.getId()!=0*/) {
			sDescripcion=procesoasientoinicialejercicio.getfecha_fin().toString();//procesoasientoinicialejercicioprocesoasientoinicialejercicio.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoAsientoInicialEjercicioDescripcionDetallado(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoAsientoInicialEjercicioConstantesFunciones.ID+"=";
		sDescripcion+=procesoasientoinicialejercicio.getId().toString()+",";
		sDescripcion+=ProcesoAsientoInicialEjercicioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesoasientoinicialejercicio.getVersionRow().toString()+",";
		sDescripcion+=ProcesoAsientoInicialEjercicioConstantesFunciones.IDTIPODOCUMENTO+"=";
		sDescripcion+=procesoasientoinicialejercicio.getid_tipo_documento().toString()+",";
		sDescripcion+=ProcesoAsientoInicialEjercicioConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=procesoasientoinicialejercicio.getfecha_inicio().toString()+",";
		sDescripcion+=ProcesoAsientoInicialEjercicioConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=procesoasientoinicialejercicio.getfecha_fin().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoAsientoInicialEjercicioDescripcion(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio,String sValor) throws Exception {			
		if(procesoasientoinicialejercicio !=null) {
			//procesoasientoinicialejercicioprocesoasientoinicialejercicio.getId().toString();
		}		
	}
	
		

	public static String getTipoDocumentoDescripcion(TipoDocumento tipodocumento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodocumento!=null/*&&tipodocumento.getId()>0*/) {
			sDescripcion=TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(tipodocumento);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesoAsientoInicialEjercicio")) {
			sNombreIndice="Tipo=  Por Tipo Documento Por Fecha Inicio Por Fecha Fin";
		} else if(sNombreIndice.equals("FK_IdTipoDocumento")) {
			sNombreIndice="Tipo=  Por Tipo Documento";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesoAsientoInicialEjercicio(Long id_tipo_documento,Date fecha_inicio,Date fecha_fin) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Documento="+id_tipo_documento.toString();}
		if(fecha_inicio!=null) {sDetalleIndice+=" Fecha Inicio="+fecha_inicio.toString();}
		if(fecha_fin!=null) {sDetalleIndice+=" Fecha Fin="+fecha_fin.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDocumento(Long id_tipo_documento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Documento="+id_tipo_documento.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoAsientoInicialEjercicio(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesoAsientoInicialEjercicios(List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejercicios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio: procesoasientoinicialejercicios) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoAsientoInicialEjercicio(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesoasientoinicialejercicio.getConCambioAuxiliar()) {
			procesoasientoinicialejercicio.setIsDeleted(procesoasientoinicialejercicio.getIsDeletedAuxiliar());	
			procesoasientoinicialejercicio.setIsNew(procesoasientoinicialejercicio.getIsNewAuxiliar());	
			procesoasientoinicialejercicio.setIsChanged(procesoasientoinicialejercicio.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesoasientoinicialejercicio.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesoasientoinicialejercicio.setIsDeletedAuxiliar(false);	
			procesoasientoinicialejercicio.setIsNewAuxiliar(false);	
			procesoasientoinicialejercicio.setIsChangedAuxiliar(false);
			
			procesoasientoinicialejercicio.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoAsientoInicialEjercicios(List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejercicios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio : procesoasientoinicialejercicios) {
			if(conAsignarBase && procesoasientoinicialejercicio.getConCambioAuxiliar()) {
				procesoasientoinicialejercicio.setIsDeleted(procesoasientoinicialejercicio.getIsDeletedAuxiliar());	
				procesoasientoinicialejercicio.setIsNew(procesoasientoinicialejercicio.getIsNewAuxiliar());	
				procesoasientoinicialejercicio.setIsChanged(procesoasientoinicialejercicio.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesoasientoinicialejercicio.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesoasientoinicialejercicio.setIsDeletedAuxiliar(false);	
				procesoasientoinicialejercicio.setIsNewAuxiliar(false);	
				procesoasientoinicialejercicio.setIsChangedAuxiliar(false);
				
				procesoasientoinicialejercicio.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoAsientoInicialEjercicio(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoAsientoInicialEjercicios(List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejercicios,Boolean conEnteros) throws Exception  {
		
		for(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio: procesoasientoinicialejercicios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoAsientoInicialEjercicio(List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejercicios,ProcesoAsientoInicialEjercicio procesoasientoinicialejercicioAux) throws Exception  {
		ProcesoAsientoInicialEjercicioConstantesFunciones.InicializarValoresProcesoAsientoInicialEjercicio(procesoasientoinicialejercicioAux,true);
		
		for(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio: procesoasientoinicialejercicios) {
			if(procesoasientoinicialejercicio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoAsientoInicialEjercicio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoAsientoInicialEjercicioConstantesFunciones.getArrayColumnasGlobalesProcesoAsientoInicialEjercicio(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoAsientoInicialEjercicio(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoAsientoInicialEjercicio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejercicios,ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicioAux: procesoasientoinicialejercicios) {
			if(procesoasientoinicialejercicioAux!=null && procesoasientoinicialejercicio!=null) {
				if((procesoasientoinicialejercicioAux.getId()==null && procesoasientoinicialejercicio.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesoasientoinicialejercicioAux.getId()!=null && procesoasientoinicialejercicio.getId()!=null){
					if(procesoasientoinicialejercicioAux.getId().equals(procesoasientoinicialejercicio.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoAsientoInicialEjercicio(List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejercicios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio: procesoasientoinicialejercicios) {			
			if(procesoasientoinicialejercicio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoAsientoInicialEjercicio() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoAsientoInicialEjercicio() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoAsientoInicialEjercicio() throws Exception  {
		return ProcesoAsientoInicialEjercicioConstantesFunciones.getTiposSeleccionarProcesoAsientoInicialEjercicio(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoAsientoInicialEjercicio(Boolean conFk) throws Exception  {
		return ProcesoAsientoInicialEjercicioConstantesFunciones.getTiposSeleccionarProcesoAsientoInicialEjercicio(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoAsientoInicialEjercicio(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoAsientoInicialEjercicioConstantesFunciones.LABEL_IDTIPODOCUMENTO);
			reporte.setsDescripcion(ProcesoAsientoInicialEjercicioConstantesFunciones.LABEL_IDTIPODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoAsientoInicialEjercicioConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(ProcesoAsientoInicialEjercicioConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoAsientoInicialEjercicioConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(ProcesoAsientoInicialEjercicioConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoAsientoInicialEjercicio(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoAsientoInicialEjercicio(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicioAux) throws Exception {
		
			procesoasientoinicialejercicioAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(procesoasientoinicialejercicioAux.getTipoDocumento()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoAsientoInicialEjercicio(List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejerciciosTemp) throws Exception {
		for(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicioAux:procesoasientoinicialejerciciosTemp) {
			
			procesoasientoinicialejercicioAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(procesoasientoinicialejercicioAux.getTipoDocumento()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoAsientoInicialEjercicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TipoDocumento.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDocumento.class)) {
						classes.add(new Classe(TipoDocumento.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoAsientoInicialEjercicio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoAsientoInicialEjercicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoAsientoInicialEjercicioConstantesFunciones.getClassesRelationshipsOfProcesoAsientoInicialEjercicio(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoAsientoInicialEjercicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoAsientoInicialEjercicio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoAsientoInicialEjercicioConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoAsientoInicialEjercicio(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoAsientoInicialEjercicio(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio,List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejercicios,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio,List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejercicios) throws Exception {
		try	{			
			for(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicioLocal:procesoasientoinicialejercicios) {
				if(procesoasientoinicialejercicioLocal.getId().equals(procesoasientoinicialejercicio.getId())) {
					procesoasientoinicialejercicioLocal.setIsSelected(procesoasientoinicialejercicio.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoAsientoInicialEjercicio(List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejerciciosAux) throws Exception {
		//this.procesoasientoinicialejerciciosAux=procesoasientoinicialejerciciosAux;
		
		for(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicioAux:procesoasientoinicialejerciciosAux) {
			if(procesoasientoinicialejercicioAux.getIsChanged()) {
				procesoasientoinicialejercicioAux.setIsChanged(false);
			}		
			
			if(procesoasientoinicialejercicioAux.getIsNew()) {
				procesoasientoinicialejercicioAux.setIsNew(false);
			}	
			
			if(procesoasientoinicialejercicioAux.getIsDeleted()) {
				procesoasientoinicialejercicioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoAsientoInicialEjercicio(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicioAux) throws Exception {
		//this.procesoasientoinicialejercicioAux=procesoasientoinicialejercicioAux;
		
			if(procesoasientoinicialejercicioAux.getIsChanged()) {
				procesoasientoinicialejercicioAux.setIsChanged(false);
			}		
			
			if(procesoasientoinicialejercicioAux.getIsNew()) {
				procesoasientoinicialejercicioAux.setIsNew(false);
			}	
			
			if(procesoasientoinicialejercicioAux.getIsDeleted()) {
				procesoasientoinicialejercicioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicioAsignar,ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio) throws Exception {
		procesoasientoinicialejercicioAsignar.setId(procesoasientoinicialejercicio.getId());	
		procesoasientoinicialejercicioAsignar.setVersionRow(procesoasientoinicialejercicio.getVersionRow());	
		procesoasientoinicialejercicioAsignar.setid_tipo_documento(procesoasientoinicialejercicio.getid_tipo_documento());
		procesoasientoinicialejercicioAsignar.settipodocumento_descripcion(procesoasientoinicialejercicio.gettipodocumento_descripcion());	
		procesoasientoinicialejercicioAsignar.setfecha_inicio(procesoasientoinicialejercicio.getfecha_inicio());	
		procesoasientoinicialejercicioAsignar.setfecha_fin(procesoasientoinicialejercicio.getfecha_fin());	
	}
	
	public static void inicializarProcesoAsientoInicialEjercicio(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio) throws Exception {
		try {
				procesoasientoinicialejercicio.setId(0L);	
					
				procesoasientoinicialejercicio.setid_tipo_documento(-1L);	
				procesoasientoinicialejercicio.setfecha_inicio(new Date());	
				procesoasientoinicialejercicio.setfecha_fin(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoAsientoInicialEjercicio(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoAsientoInicialEjercicioConstantesFunciones.LABEL_IDTIPODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoAsientoInicialEjercicioConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoAsientoInicialEjercicioConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoAsientoInicialEjercicio(String sTipo,Row row,Workbook workbook,ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesoasientoinicialejercicio.gettipodocumento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesoasientoinicialejercicio.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesoasientoinicialejercicio.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoAsientoInicialEjercicio="";
	
	public String getsFinalQueryProcesoAsientoInicialEjercicio() {
		return this.sFinalQueryProcesoAsientoInicialEjercicio;
	}
	
	public void setsFinalQueryProcesoAsientoInicialEjercicio(String sFinalQueryProcesoAsientoInicialEjercicio) {
		this.sFinalQueryProcesoAsientoInicialEjercicio= sFinalQueryProcesoAsientoInicialEjercicio;
	}
	
	public Border resaltarSeleccionarProcesoAsientoInicialEjercicio=null;
	
	public Border setResaltarSeleccionarProcesoAsientoInicialEjercicio(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoAsientoInicialEjercicioBeanSwingJInternalFrame procesoasientoinicialejercicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesoasientoinicialejercicioBeanSwingJInternalFrame.jTtoolBarProcesoAsientoInicialEjercicio.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoAsientoInicialEjercicio= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoAsientoInicialEjercicio() {
		return this.resaltarSeleccionarProcesoAsientoInicialEjercicio;
	}
	
	public void setResaltarSeleccionarProcesoAsientoInicialEjercicio(Border borderResaltarSeleccionarProcesoAsientoInicialEjercicio) {
		this.resaltarSeleccionarProcesoAsientoInicialEjercicio= borderResaltarSeleccionarProcesoAsientoInicialEjercicio;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoAsientoInicialEjercicio=null;
	public Boolean mostraridProcesoAsientoInicialEjercicio=true;
	public Boolean activaridProcesoAsientoInicialEjercicio=true;

	public Border resaltarid_tipo_documentoProcesoAsientoInicialEjercicio=null;
	public Boolean mostrarid_tipo_documentoProcesoAsientoInicialEjercicio=true;
	public Boolean activarid_tipo_documentoProcesoAsientoInicialEjercicio=true;
	public Boolean cargarid_tipo_documentoProcesoAsientoInicialEjercicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documentoProcesoAsientoInicialEjercicio=false;//ConEventDepend=true

	public Border resaltarfecha_inicioProcesoAsientoInicialEjercicio=null;
	public Boolean mostrarfecha_inicioProcesoAsientoInicialEjercicio=true;
	public Boolean activarfecha_inicioProcesoAsientoInicialEjercicio=true;

	public Border resaltarfecha_finProcesoAsientoInicialEjercicio=null;
	public Boolean mostrarfecha_finProcesoAsientoInicialEjercicio=true;
	public Boolean activarfecha_finProcesoAsientoInicialEjercicio=true;

	
	

	public Border setResaltaridProcesoAsientoInicialEjercicio(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoAsientoInicialEjercicioBeanSwingJInternalFrame procesoasientoinicialejercicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoasientoinicialejercicioBeanSwingJInternalFrame.jTtoolBarProcesoAsientoInicialEjercicio.setBorder(borderResaltar);
		
		this.resaltaridProcesoAsientoInicialEjercicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoAsientoInicialEjercicio() {
		return this.resaltaridProcesoAsientoInicialEjercicio;
	}

	public void setResaltaridProcesoAsientoInicialEjercicio(Border borderResaltar) {
		this.resaltaridProcesoAsientoInicialEjercicio= borderResaltar;
	}

	public Boolean getMostraridProcesoAsientoInicialEjercicio() {
		return this.mostraridProcesoAsientoInicialEjercicio;
	}

	public void setMostraridProcesoAsientoInicialEjercicio(Boolean mostraridProcesoAsientoInicialEjercicio) {
		this.mostraridProcesoAsientoInicialEjercicio= mostraridProcesoAsientoInicialEjercicio;
	}

	public Boolean getActivaridProcesoAsientoInicialEjercicio() {
		return this.activaridProcesoAsientoInicialEjercicio;
	}

	public void setActivaridProcesoAsientoInicialEjercicio(Boolean activaridProcesoAsientoInicialEjercicio) {
		this.activaridProcesoAsientoInicialEjercicio= activaridProcesoAsientoInicialEjercicio;
	}

	public Border setResaltarid_tipo_documentoProcesoAsientoInicialEjercicio(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoAsientoInicialEjercicioBeanSwingJInternalFrame procesoasientoinicialejercicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoasientoinicialejercicioBeanSwingJInternalFrame.jTtoolBarProcesoAsientoInicialEjercicio.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documentoProcesoAsientoInicialEjercicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documentoProcesoAsientoInicialEjercicio() {
		return this.resaltarid_tipo_documentoProcesoAsientoInicialEjercicio;
	}

	public void setResaltarid_tipo_documentoProcesoAsientoInicialEjercicio(Border borderResaltar) {
		this.resaltarid_tipo_documentoProcesoAsientoInicialEjercicio= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documentoProcesoAsientoInicialEjercicio() {
		return this.mostrarid_tipo_documentoProcesoAsientoInicialEjercicio;
	}

	public void setMostrarid_tipo_documentoProcesoAsientoInicialEjercicio(Boolean mostrarid_tipo_documentoProcesoAsientoInicialEjercicio) {
		this.mostrarid_tipo_documentoProcesoAsientoInicialEjercicio= mostrarid_tipo_documentoProcesoAsientoInicialEjercicio;
	}

	public Boolean getActivarid_tipo_documentoProcesoAsientoInicialEjercicio() {
		return this.activarid_tipo_documentoProcesoAsientoInicialEjercicio;
	}

	public void setActivarid_tipo_documentoProcesoAsientoInicialEjercicio(Boolean activarid_tipo_documentoProcesoAsientoInicialEjercicio) {
		this.activarid_tipo_documentoProcesoAsientoInicialEjercicio= activarid_tipo_documentoProcesoAsientoInicialEjercicio;
	}

	public Boolean getCargarid_tipo_documentoProcesoAsientoInicialEjercicio() {
		return this.cargarid_tipo_documentoProcesoAsientoInicialEjercicio;
	}

	public void setCargarid_tipo_documentoProcesoAsientoInicialEjercicio(Boolean cargarid_tipo_documentoProcesoAsientoInicialEjercicio) {
		this.cargarid_tipo_documentoProcesoAsientoInicialEjercicio= cargarid_tipo_documentoProcesoAsientoInicialEjercicio;
	}

	public Border setResaltarfecha_inicioProcesoAsientoInicialEjercicio(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoAsientoInicialEjercicioBeanSwingJInternalFrame procesoasientoinicialejercicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoasientoinicialejercicioBeanSwingJInternalFrame.jTtoolBarProcesoAsientoInicialEjercicio.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioProcesoAsientoInicialEjercicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioProcesoAsientoInicialEjercicio() {
		return this.resaltarfecha_inicioProcesoAsientoInicialEjercicio;
	}

	public void setResaltarfecha_inicioProcesoAsientoInicialEjercicio(Border borderResaltar) {
		this.resaltarfecha_inicioProcesoAsientoInicialEjercicio= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioProcesoAsientoInicialEjercicio() {
		return this.mostrarfecha_inicioProcesoAsientoInicialEjercicio;
	}

	public void setMostrarfecha_inicioProcesoAsientoInicialEjercicio(Boolean mostrarfecha_inicioProcesoAsientoInicialEjercicio) {
		this.mostrarfecha_inicioProcesoAsientoInicialEjercicio= mostrarfecha_inicioProcesoAsientoInicialEjercicio;
	}

	public Boolean getActivarfecha_inicioProcesoAsientoInicialEjercicio() {
		return this.activarfecha_inicioProcesoAsientoInicialEjercicio;
	}

	public void setActivarfecha_inicioProcesoAsientoInicialEjercicio(Boolean activarfecha_inicioProcesoAsientoInicialEjercicio) {
		this.activarfecha_inicioProcesoAsientoInicialEjercicio= activarfecha_inicioProcesoAsientoInicialEjercicio;
	}

	public Border setResaltarfecha_finProcesoAsientoInicialEjercicio(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoAsientoInicialEjercicioBeanSwingJInternalFrame procesoasientoinicialejercicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoasientoinicialejercicioBeanSwingJInternalFrame.jTtoolBarProcesoAsientoInicialEjercicio.setBorder(borderResaltar);
		
		this.resaltarfecha_finProcesoAsientoInicialEjercicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finProcesoAsientoInicialEjercicio() {
		return this.resaltarfecha_finProcesoAsientoInicialEjercicio;
	}

	public void setResaltarfecha_finProcesoAsientoInicialEjercicio(Border borderResaltar) {
		this.resaltarfecha_finProcesoAsientoInicialEjercicio= borderResaltar;
	}

	public Boolean getMostrarfecha_finProcesoAsientoInicialEjercicio() {
		return this.mostrarfecha_finProcesoAsientoInicialEjercicio;
	}

	public void setMostrarfecha_finProcesoAsientoInicialEjercicio(Boolean mostrarfecha_finProcesoAsientoInicialEjercicio) {
		this.mostrarfecha_finProcesoAsientoInicialEjercicio= mostrarfecha_finProcesoAsientoInicialEjercicio;
	}

	public Boolean getActivarfecha_finProcesoAsientoInicialEjercicio() {
		return this.activarfecha_finProcesoAsientoInicialEjercicio;
	}

	public void setActivarfecha_finProcesoAsientoInicialEjercicio(Boolean activarfecha_finProcesoAsientoInicialEjercicio) {
		this.activarfecha_finProcesoAsientoInicialEjercicio= activarfecha_finProcesoAsientoInicialEjercicio;
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
		
		
		this.setMostraridProcesoAsientoInicialEjercicio(esInicial);
		this.setMostrarid_tipo_documentoProcesoAsientoInicialEjercicio(esInicial);
		this.setMostrarfecha_inicioProcesoAsientoInicialEjercicio(esInicial);
		this.setMostrarfecha_finProcesoAsientoInicialEjercicio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoAsientoInicialEjercicioConstantesFunciones.ID)) {
				this.setMostraridProcesoAsientoInicialEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoAsientoInicialEjercicioConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setMostrarid_tipo_documentoProcesoAsientoInicialEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoAsientoInicialEjercicioConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioProcesoAsientoInicialEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoAsientoInicialEjercicioConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finProcesoAsientoInicialEjercicio(esAsigna);
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
		
		
		this.setActivaridProcesoAsientoInicialEjercicio(esInicial);
		this.setActivarid_tipo_documentoProcesoAsientoInicialEjercicio(esInicial);
		this.setActivarfecha_inicioProcesoAsientoInicialEjercicio(esInicial);
		this.setActivarfecha_finProcesoAsientoInicialEjercicio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoAsientoInicialEjercicioConstantesFunciones.ID)) {
				this.setActivaridProcesoAsientoInicialEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoAsientoInicialEjercicioConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setActivarid_tipo_documentoProcesoAsientoInicialEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoAsientoInicialEjercicioConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioProcesoAsientoInicialEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoAsientoInicialEjercicioConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finProcesoAsientoInicialEjercicio(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoAsientoInicialEjercicioBeanSwingJInternalFrame procesoasientoinicialejercicioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoAsientoInicialEjercicio(esInicial);
		this.setResaltarid_tipo_documentoProcesoAsientoInicialEjercicio(esInicial);
		this.setResaltarfecha_inicioProcesoAsientoInicialEjercicio(esInicial);
		this.setResaltarfecha_finProcesoAsientoInicialEjercicio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoAsientoInicialEjercicioConstantesFunciones.ID)) {
				this.setResaltaridProcesoAsientoInicialEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoAsientoInicialEjercicioConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setResaltarid_tipo_documentoProcesoAsientoInicialEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoAsientoInicialEjercicioConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioProcesoAsientoInicialEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoAsientoInicialEjercicioConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finProcesoAsientoInicialEjercicio(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoAsientoInicialEjercicioBeanSwingJInternalFrame procesoasientoinicialejercicioBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoAsientoInicialEjercicioProcesoAsientoInicialEjercicio=true;

	public Boolean getMostrarBusquedaProcesoAsientoInicialEjercicioProcesoAsientoInicialEjercicio() {
		return this.mostrarBusquedaProcesoAsientoInicialEjercicioProcesoAsientoInicialEjercicio;
	}

	public void setMostrarBusquedaProcesoAsientoInicialEjercicioProcesoAsientoInicialEjercicio(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoAsientoInicialEjercicioProcesoAsientoInicialEjercicio= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoAsientoInicialEjercicioProcesoAsientoInicialEjercicio=true;

	public Boolean getActivarBusquedaProcesoAsientoInicialEjercicioProcesoAsientoInicialEjercicio() {
		return this.activarBusquedaProcesoAsientoInicialEjercicioProcesoAsientoInicialEjercicio;
	}

	public void setActivarBusquedaProcesoAsientoInicialEjercicioProcesoAsientoInicialEjercicio(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoAsientoInicialEjercicioProcesoAsientoInicialEjercicio= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoAsientoInicialEjercicioProcesoAsientoInicialEjercicio=null;

	public Border getResaltarBusquedaProcesoAsientoInicialEjercicioProcesoAsientoInicialEjercicio() {
		return this.resaltarBusquedaProcesoAsientoInicialEjercicioProcesoAsientoInicialEjercicio;
	}

	public void setResaltarBusquedaProcesoAsientoInicialEjercicioProcesoAsientoInicialEjercicio(Border borderResaltar) {
		this.resaltarBusquedaProcesoAsientoInicialEjercicioProcesoAsientoInicialEjercicio= borderResaltar;
	}

	public void setResaltarBusquedaProcesoAsientoInicialEjercicioProcesoAsientoInicialEjercicio(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoAsientoInicialEjercicioBeanSwingJInternalFrame procesoasientoinicialejercicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoAsientoInicialEjercicioProcesoAsientoInicialEjercicio= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}