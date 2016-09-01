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


import com.bydan.erp.nomina.util.DetalleCursoConstantesFunciones;
import com.bydan.erp.nomina.util.DetalleCursoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.DetalleCursoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleCursoConstantesFunciones extends DetalleCursoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleCurso";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleCurso"+DetalleCursoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleCursoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleCursoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleCursoConstantesFunciones.SCHEMA+"_"+DetalleCursoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleCursoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleCursoConstantesFunciones.SCHEMA+"_"+DetalleCursoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleCursoConstantesFunciones.SCHEMA+"_"+DetalleCursoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleCursoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleCursoConstantesFunciones.SCHEMA+"_"+DetalleCursoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleCursoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleCursoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleCursoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleCursoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleCursoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleCursoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleCursoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleCursoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleCursoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleCursoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Cursos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Curso";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Curso";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleCurso";
	public static final String OBJECTNAME="detallecurso";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="detalle_curso";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallecurso from "+DetalleCursoConstantesFunciones.SPERSISTENCENAME+" detallecurso";
	public static String QUERYSELECTNATIVE="select "+DetalleCursoConstantesFunciones.SCHEMA+"."+DetalleCursoConstantesFunciones.TABLENAME+".id,"+DetalleCursoConstantesFunciones.SCHEMA+"."+DetalleCursoConstantesFunciones.TABLENAME+".version_row,"+DetalleCursoConstantesFunciones.SCHEMA+"."+DetalleCursoConstantesFunciones.TABLENAME+".id_curso,"+DetalleCursoConstantesFunciones.SCHEMA+"."+DetalleCursoConstantesFunciones.TABLENAME+".nombre,"+DetalleCursoConstantesFunciones.SCHEMA+"."+DetalleCursoConstantesFunciones.TABLENAME+".descripcion from "+DetalleCursoConstantesFunciones.SCHEMA+"."+DetalleCursoConstantesFunciones.TABLENAME;//+" as "+DetalleCursoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleCursoConstantesFuncionesAdditional detallecursoConstantesFuncionesAdditional=null;
	
	public DetalleCursoConstantesFuncionesAdditional getDetalleCursoConstantesFuncionesAdditional() {
		return this.detallecursoConstantesFuncionesAdditional;
	}
	
	public void setDetalleCursoConstantesFuncionesAdditional(DetalleCursoConstantesFuncionesAdditional detallecursoConstantesFuncionesAdditional) {
		try {
			this.detallecursoConstantesFuncionesAdditional=detallecursoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDCURSO= "id_curso";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDCURSO= "Curso";
		public static final String LABEL_IDCURSO_LOWER= "Curso";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetalleCursoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleCursoConstantesFunciones.IDCURSO)) {sLabelColumna=DetalleCursoConstantesFunciones.LABEL_IDCURSO;}
		if(sNombreColumna.equals(DetalleCursoConstantesFunciones.NOMBRE)) {sLabelColumna=DetalleCursoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(DetalleCursoConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleCursoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getDetalleCursoDescripcion(DetalleCurso detallecurso) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallecurso !=null/* && detallecurso.getId()!=0*/) {
			sDescripcion=detallecurso.getnombre();//detallecursodetallecurso.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleCursoDescripcionDetallado(DetalleCurso detallecurso) {
		String sDescripcion="";
			
		sDescripcion+=DetalleCursoConstantesFunciones.ID+"=";
		sDescripcion+=detallecurso.getId().toString()+",";
		sDescripcion+=DetalleCursoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallecurso.getVersionRow().toString()+",";
		sDescripcion+=DetalleCursoConstantesFunciones.IDCURSO+"=";
		sDescripcion+=detallecurso.getid_curso().toString()+",";
		sDescripcion+=DetalleCursoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=detallecurso.getnombre()+",";
		sDescripcion+=DetalleCursoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detallecurso.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleCursoDescripcion(DetalleCurso detallecurso,String sValor) throws Exception {			
		if(detallecurso !=null) {
			detallecurso.setnombre(sValor);;//detallecursodetallecurso.getnombre().trim();
		}		
	}
	
		

	public static String getCursoDescripcion(Curso curso) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(curso!=null/*&&curso.getId()>0*/) {
			sDescripcion=CursoConstantesFunciones.getCursoDescripcion(curso);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCurso")) {
			sNombreIndice="Tipo=  Por Curso";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCurso(Long id_curso) {
		String sDetalleIndice=" Parametros->";
		if(id_curso!=null) {sDetalleIndice+=" Codigo Unico De Curso="+id_curso.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleCurso(DetalleCurso detallecurso,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallecurso.setnombre(detallecurso.getnombre().trim());
		detallecurso.setdescripcion(detallecurso.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDetalleCursos(List<DetalleCurso> detallecursos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleCurso detallecurso: detallecursos) {
			detallecurso.setnombre(detallecurso.getnombre().trim());
			detallecurso.setdescripcion(detallecurso.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleCurso(DetalleCurso detallecurso,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallecurso.getConCambioAuxiliar()) {
			detallecurso.setIsDeleted(detallecurso.getIsDeletedAuxiliar());	
			detallecurso.setIsNew(detallecurso.getIsNewAuxiliar());	
			detallecurso.setIsChanged(detallecurso.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallecurso.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallecurso.setIsDeletedAuxiliar(false);	
			detallecurso.setIsNewAuxiliar(false);	
			detallecurso.setIsChangedAuxiliar(false);
			
			detallecurso.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleCursos(List<DetalleCurso> detallecursos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleCurso detallecurso : detallecursos) {
			if(conAsignarBase && detallecurso.getConCambioAuxiliar()) {
				detallecurso.setIsDeleted(detallecurso.getIsDeletedAuxiliar());	
				detallecurso.setIsNew(detallecurso.getIsNewAuxiliar());	
				detallecurso.setIsChanged(detallecurso.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallecurso.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallecurso.setIsDeletedAuxiliar(false);	
				detallecurso.setIsNewAuxiliar(false);	
				detallecurso.setIsChangedAuxiliar(false);
				
				detallecurso.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleCurso(DetalleCurso detallecurso,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetalleCursos(List<DetalleCurso> detallecursos,Boolean conEnteros) throws Exception  {
		
		for(DetalleCurso detallecurso: detallecursos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleCurso(List<DetalleCurso> detallecursos,DetalleCurso detallecursoAux) throws Exception  {
		DetalleCursoConstantesFunciones.InicializarValoresDetalleCurso(detallecursoAux,true);
		
		for(DetalleCurso detallecurso: detallecursos) {
			if(detallecurso.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleCurso(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleCursoConstantesFunciones.getArrayColumnasGlobalesDetalleCurso(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleCurso(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleCurso(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleCurso> detallecursos,DetalleCurso detallecurso,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleCurso detallecursoAux: detallecursos) {
			if(detallecursoAux!=null && detallecurso!=null) {
				if((detallecursoAux.getId()==null && detallecurso.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallecursoAux.getId()!=null && detallecurso.getId()!=null){
					if(detallecursoAux.getId().equals(detallecurso.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleCurso(List<DetalleCurso> detallecursos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(DetalleCurso detallecurso: detallecursos) {			
			if(detallecurso.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleCurso() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleCursoConstantesFunciones.LABEL_ID, DetalleCursoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCursoConstantesFunciones.LABEL_VERSIONROW, DetalleCursoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCursoConstantesFunciones.LABEL_IDCURSO, DetalleCursoConstantesFunciones.IDCURSO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCursoConstantesFunciones.LABEL_NOMBRE, DetalleCursoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCursoConstantesFunciones.LABEL_DESCRIPCION, DetalleCursoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleCurso() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleCursoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCursoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCursoConstantesFunciones.IDCURSO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCursoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCursoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleCurso() throws Exception  {
		return DetalleCursoConstantesFunciones.getTiposSeleccionarDetalleCurso(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleCurso(Boolean conFk) throws Exception  {
		return DetalleCursoConstantesFunciones.getTiposSeleccionarDetalleCurso(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleCurso(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCursoConstantesFunciones.LABEL_IDCURSO);
			reporte.setsDescripcion(DetalleCursoConstantesFunciones.LABEL_IDCURSO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCursoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(DetalleCursoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCursoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleCursoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleCurso(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleCurso(DetalleCurso detallecursoAux) throws Exception {
		
			detallecursoAux.setcurso_descripcion(CursoConstantesFunciones.getCursoDescripcion(detallecursoAux.getCurso()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleCurso(List<DetalleCurso> detallecursosTemp) throws Exception {
		for(DetalleCurso detallecursoAux:detallecursosTemp) {
			
			detallecursoAux.setcurso_descripcion(CursoConstantesFunciones.getCursoDescripcion(detallecursoAux.getCurso()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleCurso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Curso.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Curso.class)) {
						classes.add(new Classe(Curso.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleCurso(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Curso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Curso.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Curso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Curso.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleCurso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleCursoConstantesFunciones.getClassesRelationshipsOfDetalleCurso(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleCurso(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleCurso(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleCursoConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleCurso(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleCurso(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleCurso detallecurso,List<DetalleCurso> detallecursos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleCurso detallecursoEncontrado=null;
			
			for(DetalleCurso detallecursoLocal:detallecursos) {
				if(detallecursoLocal.getId().equals(detallecurso.getId())) {
					detallecursoEncontrado=detallecursoLocal;
					
					detallecursoLocal.setIsChanged(detallecurso.getIsChanged());
					detallecursoLocal.setIsNew(detallecurso.getIsNew());
					detallecursoLocal.setIsDeleted(detallecurso.getIsDeleted());
					
					detallecursoLocal.setGeneralEntityOriginal(detallecurso.getGeneralEntityOriginal());
					
					detallecursoLocal.setId(detallecurso.getId());	
					detallecursoLocal.setVersionRow(detallecurso.getVersionRow());	
					detallecursoLocal.setid_curso(detallecurso.getid_curso());	
					detallecursoLocal.setnombre(detallecurso.getnombre());	
					detallecursoLocal.setdescripcion(detallecurso.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detallecurso.getIsDeleted()) {
				if(!existe) {
					detallecursos.add(detallecurso);
				}
			} else {
				if(detallecursoEncontrado!=null && permiteQuitar)  {
					detallecursos.remove(detallecursoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleCurso detallecurso,List<DetalleCurso> detallecursos) throws Exception {
		try	{			
			for(DetalleCurso detallecursoLocal:detallecursos) {
				if(detallecursoLocal.getId().equals(detallecurso.getId())) {
					detallecursoLocal.setIsSelected(detallecurso.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleCurso(List<DetalleCurso> detallecursosAux) throws Exception {
		//this.detallecursosAux=detallecursosAux;
		
		for(DetalleCurso detallecursoAux:detallecursosAux) {
			if(detallecursoAux.getIsChanged()) {
				detallecursoAux.setIsChanged(false);
			}		
			
			if(detallecursoAux.getIsNew()) {
				detallecursoAux.setIsNew(false);
			}	
			
			if(detallecursoAux.getIsDeleted()) {
				detallecursoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleCurso(DetalleCurso detallecursoAux) throws Exception {
		//this.detallecursoAux=detallecursoAux;
		
			if(detallecursoAux.getIsChanged()) {
				detallecursoAux.setIsChanged(false);
			}		
			
			if(detallecursoAux.getIsNew()) {
				detallecursoAux.setIsNew(false);
			}	
			
			if(detallecursoAux.getIsDeleted()) {
				detallecursoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleCurso detallecursoAsignar,DetalleCurso detallecurso) throws Exception {
		detallecursoAsignar.setId(detallecurso.getId());	
		detallecursoAsignar.setVersionRow(detallecurso.getVersionRow());	
		detallecursoAsignar.setid_curso(detallecurso.getid_curso());
		detallecursoAsignar.setcurso_descripcion(detallecurso.getcurso_descripcion());	
		detallecursoAsignar.setnombre(detallecurso.getnombre());	
		detallecursoAsignar.setdescripcion(detallecurso.getdescripcion());	
	}
	
	public static void inicializarDetalleCurso(DetalleCurso detallecurso) throws Exception {
		try {
				detallecurso.setId(0L);	
					
				detallecurso.setid_curso(-1L);	
				detallecurso.setnombre("");	
				detallecurso.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleCurso(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCursoConstantesFunciones.LABEL_IDCURSO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCursoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCursoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleCurso(String sTipo,Row row,Workbook workbook,DetalleCurso detallecurso,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecurso.getcurso_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecurso.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecurso.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleCurso=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleCurso() {
		return this.sFinalQueryDetalleCurso;
	}
	
	public void setsFinalQueryDetalleCurso(String sFinalQueryDetalleCurso) {
		this.sFinalQueryDetalleCurso= sFinalQueryDetalleCurso;
	}
	
	public Border resaltarSeleccionarDetalleCurso=null;
	
	public Border setResaltarSeleccionarDetalleCurso(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCursoBeanSwingJInternalFrame detallecursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallecursoBeanSwingJInternalFrame.jTtoolBarDetalleCurso.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleCurso= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleCurso() {
		return this.resaltarSeleccionarDetalleCurso;
	}
	
	public void setResaltarSeleccionarDetalleCurso(Border borderResaltarSeleccionarDetalleCurso) {
		this.resaltarSeleccionarDetalleCurso= borderResaltarSeleccionarDetalleCurso;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleCurso=null;
	public Boolean mostraridDetalleCurso=true;
	public Boolean activaridDetalleCurso=true;

	public Border resaltarid_cursoDetalleCurso=null;
	public Boolean mostrarid_cursoDetalleCurso=true;
	public Boolean activarid_cursoDetalleCurso=true;
	public Boolean cargarid_cursoDetalleCurso=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cursoDetalleCurso=false;//ConEventDepend=true

	public Border resaltarnombreDetalleCurso=null;
	public Boolean mostrarnombreDetalleCurso=true;
	public Boolean activarnombreDetalleCurso=true;

	public Border resaltardescripcionDetalleCurso=null;
	public Boolean mostrardescripcionDetalleCurso=true;
	public Boolean activardescripcionDetalleCurso=true;

	
	

	public Border setResaltaridDetalleCurso(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCursoBeanSwingJInternalFrame detallecursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecursoBeanSwingJInternalFrame.jTtoolBarDetalleCurso.setBorder(borderResaltar);
		
		this.resaltaridDetalleCurso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleCurso() {
		return this.resaltaridDetalleCurso;
	}

	public void setResaltaridDetalleCurso(Border borderResaltar) {
		this.resaltaridDetalleCurso= borderResaltar;
	}

	public Boolean getMostraridDetalleCurso() {
		return this.mostraridDetalleCurso;
	}

	public void setMostraridDetalleCurso(Boolean mostraridDetalleCurso) {
		this.mostraridDetalleCurso= mostraridDetalleCurso;
	}

	public Boolean getActivaridDetalleCurso() {
		return this.activaridDetalleCurso;
	}

	public void setActivaridDetalleCurso(Boolean activaridDetalleCurso) {
		this.activaridDetalleCurso= activaridDetalleCurso;
	}

	public Border setResaltarid_cursoDetalleCurso(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCursoBeanSwingJInternalFrame detallecursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecursoBeanSwingJInternalFrame.jTtoolBarDetalleCurso.setBorder(borderResaltar);
		
		this.resaltarid_cursoDetalleCurso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cursoDetalleCurso() {
		return this.resaltarid_cursoDetalleCurso;
	}

	public void setResaltarid_cursoDetalleCurso(Border borderResaltar) {
		this.resaltarid_cursoDetalleCurso= borderResaltar;
	}

	public Boolean getMostrarid_cursoDetalleCurso() {
		return this.mostrarid_cursoDetalleCurso;
	}

	public void setMostrarid_cursoDetalleCurso(Boolean mostrarid_cursoDetalleCurso) {
		this.mostrarid_cursoDetalleCurso= mostrarid_cursoDetalleCurso;
	}

	public Boolean getActivarid_cursoDetalleCurso() {
		return this.activarid_cursoDetalleCurso;
	}

	public void setActivarid_cursoDetalleCurso(Boolean activarid_cursoDetalleCurso) {
		this.activarid_cursoDetalleCurso= activarid_cursoDetalleCurso;
	}

	public Boolean getCargarid_cursoDetalleCurso() {
		return this.cargarid_cursoDetalleCurso;
	}

	public void setCargarid_cursoDetalleCurso(Boolean cargarid_cursoDetalleCurso) {
		this.cargarid_cursoDetalleCurso= cargarid_cursoDetalleCurso;
	}

	public Border setResaltarnombreDetalleCurso(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCursoBeanSwingJInternalFrame detallecursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecursoBeanSwingJInternalFrame.jTtoolBarDetalleCurso.setBorder(borderResaltar);
		
		this.resaltarnombreDetalleCurso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreDetalleCurso() {
		return this.resaltarnombreDetalleCurso;
	}

	public void setResaltarnombreDetalleCurso(Border borderResaltar) {
		this.resaltarnombreDetalleCurso= borderResaltar;
	}

	public Boolean getMostrarnombreDetalleCurso() {
		return this.mostrarnombreDetalleCurso;
	}

	public void setMostrarnombreDetalleCurso(Boolean mostrarnombreDetalleCurso) {
		this.mostrarnombreDetalleCurso= mostrarnombreDetalleCurso;
	}

	public Boolean getActivarnombreDetalleCurso() {
		return this.activarnombreDetalleCurso;
	}

	public void setActivarnombreDetalleCurso(Boolean activarnombreDetalleCurso) {
		this.activarnombreDetalleCurso= activarnombreDetalleCurso;
	}

	public Border setResaltardescripcionDetalleCurso(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCursoBeanSwingJInternalFrame detallecursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecursoBeanSwingJInternalFrame.jTtoolBarDetalleCurso.setBorder(borderResaltar);
		
		this.resaltardescripcionDetalleCurso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleCurso() {
		return this.resaltardescripcionDetalleCurso;
	}

	public void setResaltardescripcionDetalleCurso(Border borderResaltar) {
		this.resaltardescripcionDetalleCurso= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleCurso() {
		return this.mostrardescripcionDetalleCurso;
	}

	public void setMostrardescripcionDetalleCurso(Boolean mostrardescripcionDetalleCurso) {
		this.mostrardescripcionDetalleCurso= mostrardescripcionDetalleCurso;
	}

	public Boolean getActivardescripcionDetalleCurso() {
		return this.activardescripcionDetalleCurso;
	}

	public void setActivardescripcionDetalleCurso(Boolean activardescripcionDetalleCurso) {
		this.activardescripcionDetalleCurso= activardescripcionDetalleCurso;
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
		
		
		this.setMostraridDetalleCurso(esInicial);
		this.setMostrarid_cursoDetalleCurso(esInicial);
		this.setMostrarnombreDetalleCurso(esInicial);
		this.setMostrardescripcionDetalleCurso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleCursoConstantesFunciones.ID)) {
				this.setMostraridDetalleCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCursoConstantesFunciones.IDCURSO)) {
				this.setMostrarid_cursoDetalleCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCursoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreDetalleCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCursoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleCurso(esAsigna);
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
		
		
		this.setActivaridDetalleCurso(esInicial);
		this.setActivarid_cursoDetalleCurso(esInicial);
		this.setActivarnombreDetalleCurso(esInicial);
		this.setActivardescripcionDetalleCurso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleCursoConstantesFunciones.ID)) {
				this.setActivaridDetalleCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCursoConstantesFunciones.IDCURSO)) {
				this.setActivarid_cursoDetalleCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCursoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreDetalleCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCursoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleCurso(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleCursoBeanSwingJInternalFrame detallecursoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleCurso(esInicial);
		this.setResaltarid_cursoDetalleCurso(esInicial);
		this.setResaltarnombreDetalleCurso(esInicial);
		this.setResaltardescripcionDetalleCurso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleCursoConstantesFunciones.ID)) {
				this.setResaltaridDetalleCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCursoConstantesFunciones.IDCURSO)) {
				this.setResaltarid_cursoDetalleCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCursoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreDetalleCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCursoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleCurso(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleCursoBeanSwingJInternalFrame detallecursoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCursoDetalleCurso=true;

	public Boolean getMostrarFK_IdCursoDetalleCurso() {
		return this.mostrarFK_IdCursoDetalleCurso;
	}

	public void setMostrarFK_IdCursoDetalleCurso(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCursoDetalleCurso= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCursoDetalleCurso=true;

	public Boolean getActivarFK_IdCursoDetalleCurso() {
		return this.activarFK_IdCursoDetalleCurso;
	}

	public void setActivarFK_IdCursoDetalleCurso(Boolean habilitarResaltar) {
		this.activarFK_IdCursoDetalleCurso= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCursoDetalleCurso=null;

	public Border getResaltarFK_IdCursoDetalleCurso() {
		return this.resaltarFK_IdCursoDetalleCurso;
	}

	public void setResaltarFK_IdCursoDetalleCurso(Border borderResaltar) {
		this.resaltarFK_IdCursoDetalleCurso= borderResaltar;
	}

	public void setResaltarFK_IdCursoDetalleCurso(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCursoBeanSwingJInternalFrame detallecursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCursoDetalleCurso= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}