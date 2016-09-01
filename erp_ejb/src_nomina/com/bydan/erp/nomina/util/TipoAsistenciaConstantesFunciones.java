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


import com.bydan.erp.nomina.util.TipoAsistenciaConstantesFunciones;
import com.bydan.erp.nomina.util.TipoAsistenciaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoAsistenciaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



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
final public class TipoAsistenciaConstantesFunciones extends TipoAsistenciaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoAsistencia";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoAsistencia"+TipoAsistenciaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoAsistenciaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoAsistenciaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoAsistenciaConstantesFunciones.SCHEMA+"_"+TipoAsistenciaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoAsistenciaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoAsistenciaConstantesFunciones.SCHEMA+"_"+TipoAsistenciaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoAsistenciaConstantesFunciones.SCHEMA+"_"+TipoAsistenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoAsistenciaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoAsistenciaConstantesFunciones.SCHEMA+"_"+TipoAsistenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAsistenciaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoAsistenciaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAsistenciaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAsistenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoAsistenciaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAsistenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoAsistenciaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoAsistenciaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoAsistenciaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoAsistenciaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Asistencias";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Asistencia";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Asistencia";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoAsistencia";
	public static final String OBJECTNAME="tipoasistencia";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_asistencia";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoasistencia from "+TipoAsistenciaConstantesFunciones.SPERSISTENCENAME+" tipoasistencia";
	public static String QUERYSELECTNATIVE="select "+TipoAsistenciaConstantesFunciones.SCHEMA+"."+TipoAsistenciaConstantesFunciones.TABLENAME+".id,"+TipoAsistenciaConstantesFunciones.SCHEMA+"."+TipoAsistenciaConstantesFunciones.TABLENAME+".version_row,"+TipoAsistenciaConstantesFunciones.SCHEMA+"."+TipoAsistenciaConstantesFunciones.TABLENAME+".id_empresa,"+TipoAsistenciaConstantesFunciones.SCHEMA+"."+TipoAsistenciaConstantesFunciones.TABLENAME+".nombre from "+TipoAsistenciaConstantesFunciones.SCHEMA+"."+TipoAsistenciaConstantesFunciones.TABLENAME;//+" as "+TipoAsistenciaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoAsistenciaConstantesFuncionesAdditional tipoasistenciaConstantesFuncionesAdditional=null;
	
	public TipoAsistenciaConstantesFuncionesAdditional getTipoAsistenciaConstantesFuncionesAdditional() {
		return this.tipoasistenciaConstantesFuncionesAdditional;
	}
	
	public void setTipoAsistenciaConstantesFuncionesAdditional(TipoAsistenciaConstantesFuncionesAdditional tipoasistenciaConstantesFuncionesAdditional) {
		try {
			this.tipoasistenciaConstantesFuncionesAdditional=tipoasistenciaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoAsistenciaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoAsistenciaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoAsistenciaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoAsistenciaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoAsistenciaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoAsistenciaDescripcion(TipoAsistencia tipoasistencia) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoasistencia !=null/* && tipoasistencia.getId()!=0*/) {
			sDescripcion=tipoasistencia.getnombre();//tipoasistenciatipoasistencia.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoAsistenciaDescripcionDetallado(TipoAsistencia tipoasistencia) {
		String sDescripcion="";
			
		sDescripcion+=TipoAsistenciaConstantesFunciones.ID+"=";
		sDescripcion+=tipoasistencia.getId().toString()+",";
		sDescripcion+=TipoAsistenciaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoasistencia.getVersionRow().toString()+",";
		sDescripcion+=TipoAsistenciaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoasistencia.getid_empresa().toString()+",";
		sDescripcion+=TipoAsistenciaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoasistencia.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoAsistenciaDescripcion(TipoAsistencia tipoasistencia,String sValor) throws Exception {			
		if(tipoasistencia !=null) {
			tipoasistencia.setnombre(sValor);;//tipoasistenciatipoasistencia.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoAsistencia(TipoAsistencia tipoasistencia,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoasistencia.setnombre(tipoasistencia.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoAsistencias(List<TipoAsistencia> tipoasistencias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoAsistencia tipoasistencia: tipoasistencias) {
			tipoasistencia.setnombre(tipoasistencia.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoAsistencia(TipoAsistencia tipoasistencia,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoasistencia.getConCambioAuxiliar()) {
			tipoasistencia.setIsDeleted(tipoasistencia.getIsDeletedAuxiliar());	
			tipoasistencia.setIsNew(tipoasistencia.getIsNewAuxiliar());	
			tipoasistencia.setIsChanged(tipoasistencia.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoasistencia.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoasistencia.setIsDeletedAuxiliar(false);	
			tipoasistencia.setIsNewAuxiliar(false);	
			tipoasistencia.setIsChangedAuxiliar(false);
			
			tipoasistencia.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoAsistencias(List<TipoAsistencia> tipoasistencias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoAsistencia tipoasistencia : tipoasistencias) {
			if(conAsignarBase && tipoasistencia.getConCambioAuxiliar()) {
				tipoasistencia.setIsDeleted(tipoasistencia.getIsDeletedAuxiliar());	
				tipoasistencia.setIsNew(tipoasistencia.getIsNewAuxiliar());	
				tipoasistencia.setIsChanged(tipoasistencia.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoasistencia.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoasistencia.setIsDeletedAuxiliar(false);	
				tipoasistencia.setIsNewAuxiliar(false);	
				tipoasistencia.setIsChangedAuxiliar(false);
				
				tipoasistencia.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoAsistencia(TipoAsistencia tipoasistencia,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoAsistencias(List<TipoAsistencia> tipoasistencias,Boolean conEnteros) throws Exception  {
		
		for(TipoAsistencia tipoasistencia: tipoasistencias) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoAsistencia(List<TipoAsistencia> tipoasistencias,TipoAsistencia tipoasistenciaAux) throws Exception  {
		TipoAsistenciaConstantesFunciones.InicializarValoresTipoAsistencia(tipoasistenciaAux,true);
		
		for(TipoAsistencia tipoasistencia: tipoasistencias) {
			if(tipoasistencia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoAsistencia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoAsistenciaConstantesFunciones.getArrayColumnasGlobalesTipoAsistencia(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoAsistencia(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoAsistenciaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoAsistenciaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoAsistencia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoAsistencia> tipoasistencias,TipoAsistencia tipoasistencia,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoAsistencia tipoasistenciaAux: tipoasistencias) {
			if(tipoasistenciaAux!=null && tipoasistencia!=null) {
				if((tipoasistenciaAux.getId()==null && tipoasistencia.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoasistenciaAux.getId()!=null && tipoasistencia.getId()!=null){
					if(tipoasistenciaAux.getId().equals(tipoasistencia.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoAsistencia(List<TipoAsistencia> tipoasistencias) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoAsistencia tipoasistencia: tipoasistencias) {			
			if(tipoasistencia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoAsistencia() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoAsistenciaConstantesFunciones.LABEL_ID, TipoAsistenciaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAsistenciaConstantesFunciones.LABEL_VERSIONROW, TipoAsistenciaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAsistenciaConstantesFunciones.LABEL_IDEMPRESA, TipoAsistenciaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAsistenciaConstantesFunciones.LABEL_NOMBRE, TipoAsistenciaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoAsistencia() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoAsistenciaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAsistenciaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAsistenciaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAsistenciaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoAsistencia() throws Exception  {
		return TipoAsistenciaConstantesFunciones.getTiposSeleccionarTipoAsistencia(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoAsistencia(Boolean conFk) throws Exception  {
		return TipoAsistenciaConstantesFunciones.getTiposSeleccionarTipoAsistencia(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoAsistencia(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAsistenciaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoAsistenciaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAsistenciaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoAsistenciaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoAsistencia(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoAsistencia(TipoAsistencia tipoasistenciaAux) throws Exception {
		
			tipoasistenciaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoasistenciaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoAsistencia(List<TipoAsistencia> tipoasistenciasTemp) throws Exception {
		for(TipoAsistencia tipoasistenciaAux:tipoasistenciasTemp) {
			
			tipoasistenciaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoasistenciaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoAsistencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoAsistencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoAsistencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoAsistenciaConstantesFunciones.getClassesRelationshipsOfTipoAsistencia(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoAsistencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoAsistencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoAsistenciaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoAsistencia(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoAsistencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoAsistencia tipoasistencia,List<TipoAsistencia> tipoasistencias,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoAsistencia tipoasistenciaEncontrado=null;
			
			for(TipoAsistencia tipoasistenciaLocal:tipoasistencias) {
				if(tipoasistenciaLocal.getId().equals(tipoasistencia.getId())) {
					tipoasistenciaEncontrado=tipoasistenciaLocal;
					
					tipoasistenciaLocal.setIsChanged(tipoasistencia.getIsChanged());
					tipoasistenciaLocal.setIsNew(tipoasistencia.getIsNew());
					tipoasistenciaLocal.setIsDeleted(tipoasistencia.getIsDeleted());
					
					tipoasistenciaLocal.setGeneralEntityOriginal(tipoasistencia.getGeneralEntityOriginal());
					
					tipoasistenciaLocal.setId(tipoasistencia.getId());	
					tipoasistenciaLocal.setVersionRow(tipoasistencia.getVersionRow());	
					tipoasistenciaLocal.setid_empresa(tipoasistencia.getid_empresa());	
					tipoasistenciaLocal.setnombre(tipoasistencia.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoasistencia.getIsDeleted()) {
				if(!existe) {
					tipoasistencias.add(tipoasistencia);
				}
			} else {
				if(tipoasistenciaEncontrado!=null && permiteQuitar)  {
					tipoasistencias.remove(tipoasistenciaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoAsistencia tipoasistencia,List<TipoAsistencia> tipoasistencias) throws Exception {
		try	{			
			for(TipoAsistencia tipoasistenciaLocal:tipoasistencias) {
				if(tipoasistenciaLocal.getId().equals(tipoasistencia.getId())) {
					tipoasistenciaLocal.setIsSelected(tipoasistencia.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoAsistencia(List<TipoAsistencia> tipoasistenciasAux) throws Exception {
		//this.tipoasistenciasAux=tipoasistenciasAux;
		
		for(TipoAsistencia tipoasistenciaAux:tipoasistenciasAux) {
			if(tipoasistenciaAux.getIsChanged()) {
				tipoasistenciaAux.setIsChanged(false);
			}		
			
			if(tipoasistenciaAux.getIsNew()) {
				tipoasistenciaAux.setIsNew(false);
			}	
			
			if(tipoasistenciaAux.getIsDeleted()) {
				tipoasistenciaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoAsistencia(TipoAsistencia tipoasistenciaAux) throws Exception {
		//this.tipoasistenciaAux=tipoasistenciaAux;
		
			if(tipoasistenciaAux.getIsChanged()) {
				tipoasistenciaAux.setIsChanged(false);
			}		
			
			if(tipoasistenciaAux.getIsNew()) {
				tipoasistenciaAux.setIsNew(false);
			}	
			
			if(tipoasistenciaAux.getIsDeleted()) {
				tipoasistenciaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoAsistencia tipoasistenciaAsignar,TipoAsistencia tipoasistencia) throws Exception {
		tipoasistenciaAsignar.setId(tipoasistencia.getId());	
		tipoasistenciaAsignar.setVersionRow(tipoasistencia.getVersionRow());	
		tipoasistenciaAsignar.setid_empresa(tipoasistencia.getid_empresa());
		tipoasistenciaAsignar.setempresa_descripcion(tipoasistencia.getempresa_descripcion());	
		tipoasistenciaAsignar.setnombre(tipoasistencia.getnombre());	
	}
	
	public static void inicializarTipoAsistencia(TipoAsistencia tipoasistencia) throws Exception {
		try {
				tipoasistencia.setId(0L);	
					
				tipoasistencia.setid_empresa(-1L);	
				tipoasistencia.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoAsistencia(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAsistenciaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAsistenciaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoAsistencia(String sTipo,Row row,Workbook workbook,TipoAsistencia tipoasistencia,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoasistencia.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoasistencia.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoAsistencia=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoAsistencia() {
		return this.sFinalQueryTipoAsistencia;
	}
	
	public void setsFinalQueryTipoAsistencia(String sFinalQueryTipoAsistencia) {
		this.sFinalQueryTipoAsistencia= sFinalQueryTipoAsistencia;
	}
	
	public Border resaltarSeleccionarTipoAsistencia=null;
	
	public Border setResaltarSeleccionarTipoAsistencia(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAsistenciaBeanSwingJInternalFrame tipoasistenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoasistenciaBeanSwingJInternalFrame.jTtoolBarTipoAsistencia.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoAsistencia= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoAsistencia() {
		return this.resaltarSeleccionarTipoAsistencia;
	}
	
	public void setResaltarSeleccionarTipoAsistencia(Border borderResaltarSeleccionarTipoAsistencia) {
		this.resaltarSeleccionarTipoAsistencia= borderResaltarSeleccionarTipoAsistencia;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoAsistencia=null;
	public Boolean mostraridTipoAsistencia=true;
	public Boolean activaridTipoAsistencia=true;

	public Border resaltarid_empresaTipoAsistencia=null;
	public Boolean mostrarid_empresaTipoAsistencia=true;
	public Boolean activarid_empresaTipoAsistencia=true;
	public Boolean cargarid_empresaTipoAsistencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoAsistencia=false;//ConEventDepend=true

	public Border resaltarnombreTipoAsistencia=null;
	public Boolean mostrarnombreTipoAsistencia=true;
	public Boolean activarnombreTipoAsistencia=true;

	
	

	public Border setResaltaridTipoAsistencia(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAsistenciaBeanSwingJInternalFrame tipoasistenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoasistenciaBeanSwingJInternalFrame.jTtoolBarTipoAsistencia.setBorder(borderResaltar);
		
		this.resaltaridTipoAsistencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoAsistencia() {
		return this.resaltaridTipoAsistencia;
	}

	public void setResaltaridTipoAsistencia(Border borderResaltar) {
		this.resaltaridTipoAsistencia= borderResaltar;
	}

	public Boolean getMostraridTipoAsistencia() {
		return this.mostraridTipoAsistencia;
	}

	public void setMostraridTipoAsistencia(Boolean mostraridTipoAsistencia) {
		this.mostraridTipoAsistencia= mostraridTipoAsistencia;
	}

	public Boolean getActivaridTipoAsistencia() {
		return this.activaridTipoAsistencia;
	}

	public void setActivaridTipoAsistencia(Boolean activaridTipoAsistencia) {
		this.activaridTipoAsistencia= activaridTipoAsistencia;
	}

	public Border setResaltarid_empresaTipoAsistencia(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAsistenciaBeanSwingJInternalFrame tipoasistenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoasistenciaBeanSwingJInternalFrame.jTtoolBarTipoAsistencia.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoAsistencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoAsistencia() {
		return this.resaltarid_empresaTipoAsistencia;
	}

	public void setResaltarid_empresaTipoAsistencia(Border borderResaltar) {
		this.resaltarid_empresaTipoAsistencia= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoAsistencia() {
		return this.mostrarid_empresaTipoAsistencia;
	}

	public void setMostrarid_empresaTipoAsistencia(Boolean mostrarid_empresaTipoAsistencia) {
		this.mostrarid_empresaTipoAsistencia= mostrarid_empresaTipoAsistencia;
	}

	public Boolean getActivarid_empresaTipoAsistencia() {
		return this.activarid_empresaTipoAsistencia;
	}

	public void setActivarid_empresaTipoAsistencia(Boolean activarid_empresaTipoAsistencia) {
		this.activarid_empresaTipoAsistencia= activarid_empresaTipoAsistencia;
	}

	public Boolean getCargarid_empresaTipoAsistencia() {
		return this.cargarid_empresaTipoAsistencia;
	}

	public void setCargarid_empresaTipoAsistencia(Boolean cargarid_empresaTipoAsistencia) {
		this.cargarid_empresaTipoAsistencia= cargarid_empresaTipoAsistencia;
	}

	public Border setResaltarnombreTipoAsistencia(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAsistenciaBeanSwingJInternalFrame tipoasistenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoasistenciaBeanSwingJInternalFrame.jTtoolBarTipoAsistencia.setBorder(borderResaltar);
		
		this.resaltarnombreTipoAsistencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoAsistencia() {
		return this.resaltarnombreTipoAsistencia;
	}

	public void setResaltarnombreTipoAsistencia(Border borderResaltar) {
		this.resaltarnombreTipoAsistencia= borderResaltar;
	}

	public Boolean getMostrarnombreTipoAsistencia() {
		return this.mostrarnombreTipoAsistencia;
	}

	public void setMostrarnombreTipoAsistencia(Boolean mostrarnombreTipoAsistencia) {
		this.mostrarnombreTipoAsistencia= mostrarnombreTipoAsistencia;
	}

	public Boolean getActivarnombreTipoAsistencia() {
		return this.activarnombreTipoAsistencia;
	}

	public void setActivarnombreTipoAsistencia(Boolean activarnombreTipoAsistencia) {
		this.activarnombreTipoAsistencia= activarnombreTipoAsistencia;
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
		
		
		this.setMostraridTipoAsistencia(esInicial);
		this.setMostrarid_empresaTipoAsistencia(esInicial);
		this.setMostrarnombreTipoAsistencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoAsistenciaConstantesFunciones.ID)) {
				this.setMostraridTipoAsistencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAsistenciaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoAsistencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAsistenciaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoAsistencia(esAsigna);
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
		
		
		this.setActivaridTipoAsistencia(esInicial);
		this.setActivarid_empresaTipoAsistencia(esInicial);
		this.setActivarnombreTipoAsistencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoAsistenciaConstantesFunciones.ID)) {
				this.setActivaridTipoAsistencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAsistenciaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoAsistencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAsistenciaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoAsistencia(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoAsistenciaBeanSwingJInternalFrame tipoasistenciaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoAsistencia(esInicial);
		this.setResaltarid_empresaTipoAsistencia(esInicial);
		this.setResaltarnombreTipoAsistencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoAsistenciaConstantesFunciones.ID)) {
				this.setResaltaridTipoAsistencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAsistenciaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoAsistencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAsistenciaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoAsistencia(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoAsistenciaBeanSwingJInternalFrame tipoasistenciaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTipoAsistencia=true;

	public Boolean getMostrarFK_IdEmpresaTipoAsistencia() {
		return this.mostrarFK_IdEmpresaTipoAsistencia;
	}

	public void setMostrarFK_IdEmpresaTipoAsistencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoAsistencia= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoAsistencia=true;

	public Boolean getActivarFK_IdEmpresaTipoAsistencia() {
		return this.activarFK_IdEmpresaTipoAsistencia;
	}

	public void setActivarFK_IdEmpresaTipoAsistencia(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoAsistencia= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoAsistencia=null;

	public Border getResaltarFK_IdEmpresaTipoAsistencia() {
		return this.resaltarFK_IdEmpresaTipoAsistencia;
	}

	public void setResaltarFK_IdEmpresaTipoAsistencia(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoAsistencia= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoAsistencia(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAsistenciaBeanSwingJInternalFrame tipoasistenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoAsistencia= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}