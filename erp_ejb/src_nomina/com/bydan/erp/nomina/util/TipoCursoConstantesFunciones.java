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


import com.bydan.erp.nomina.util.TipoCursoConstantesFunciones;
import com.bydan.erp.nomina.util.TipoCursoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoCursoParameterGeneral;

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
final public class TipoCursoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoCurso";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoCurso"+TipoCursoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoCursoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoCursoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoCursoConstantesFunciones.SCHEMA+"_"+TipoCursoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoCursoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoCursoConstantesFunciones.SCHEMA+"_"+TipoCursoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoCursoConstantesFunciones.SCHEMA+"_"+TipoCursoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoCursoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoCursoConstantesFunciones.SCHEMA+"_"+TipoCursoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCursoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCursoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCursoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCursoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCursoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCursoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoCursoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoCursoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoCursoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoCursoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Cursos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Curso";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Curso";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoCurso";
	public static final String OBJECTNAME="tipocurso";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_curso";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocurso from "+TipoCursoConstantesFunciones.SPERSISTENCENAME+" tipocurso";
	public static String QUERYSELECTNATIVE="select "+TipoCursoConstantesFunciones.SCHEMA+"."+TipoCursoConstantesFunciones.TABLENAME+".id,"+TipoCursoConstantesFunciones.SCHEMA+"."+TipoCursoConstantesFunciones.TABLENAME+".version_row,"+TipoCursoConstantesFunciones.SCHEMA+"."+TipoCursoConstantesFunciones.TABLENAME+".id_empresa,"+TipoCursoConstantesFunciones.SCHEMA+"."+TipoCursoConstantesFunciones.TABLENAME+".codigo,"+TipoCursoConstantesFunciones.SCHEMA+"."+TipoCursoConstantesFunciones.TABLENAME+".nombre from "+TipoCursoConstantesFunciones.SCHEMA+"."+TipoCursoConstantesFunciones.TABLENAME;//+" as "+TipoCursoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoCursoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoCursoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoCursoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoCursoConstantesFunciones.CODIGO)) {sLabelColumna=TipoCursoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoCursoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoCursoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoCursoDescripcion(TipoCurso tipocurso) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocurso !=null/* && tipocurso.getId()!=0*/) {
			sDescripcion=tipocurso.getcodigo();//tipocursotipocurso.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoCursoDescripcionDetallado(TipoCurso tipocurso) {
		String sDescripcion="";
			
		sDescripcion+=TipoCursoConstantesFunciones.ID+"=";
		sDescripcion+=tipocurso.getId().toString()+",";
		sDescripcion+=TipoCursoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocurso.getVersionRow().toString()+",";
		sDescripcion+=TipoCursoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipocurso.getid_empresa().toString()+",";
		sDescripcion+=TipoCursoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipocurso.getcodigo()+",";
		sDescripcion+=TipoCursoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocurso.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoCursoDescripcion(TipoCurso tipocurso,String sValor) throws Exception {			
		if(tipocurso !=null) {
			tipocurso.setcodigo(sValor);;//tipocursotipocurso.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoCurso(TipoCurso tipocurso,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocurso.setcodigo(tipocurso.getcodigo().trim());
		tipocurso.setnombre(tipocurso.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoCursos(List<TipoCurso> tipocursos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoCurso tipocurso: tipocursos) {
			tipocurso.setcodigo(tipocurso.getcodigo().trim());
			tipocurso.setnombre(tipocurso.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCurso(TipoCurso tipocurso,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocurso.getConCambioAuxiliar()) {
			tipocurso.setIsDeleted(tipocurso.getIsDeletedAuxiliar());	
			tipocurso.setIsNew(tipocurso.getIsNewAuxiliar());	
			tipocurso.setIsChanged(tipocurso.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocurso.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocurso.setIsDeletedAuxiliar(false);	
			tipocurso.setIsNewAuxiliar(false);	
			tipocurso.setIsChangedAuxiliar(false);
			
			tipocurso.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCursos(List<TipoCurso> tipocursos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoCurso tipocurso : tipocursos) {
			if(conAsignarBase && tipocurso.getConCambioAuxiliar()) {
				tipocurso.setIsDeleted(tipocurso.getIsDeletedAuxiliar());	
				tipocurso.setIsNew(tipocurso.getIsNewAuxiliar());	
				tipocurso.setIsChanged(tipocurso.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocurso.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocurso.setIsDeletedAuxiliar(false);	
				tipocurso.setIsNewAuxiliar(false);	
				tipocurso.setIsChangedAuxiliar(false);
				
				tipocurso.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoCurso(TipoCurso tipocurso,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoCursos(List<TipoCurso> tipocursos,Boolean conEnteros) throws Exception  {
		
		for(TipoCurso tipocurso: tipocursos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoCurso(List<TipoCurso> tipocursos,TipoCurso tipocursoAux) throws Exception  {
		TipoCursoConstantesFunciones.InicializarValoresTipoCurso(tipocursoAux,true);
		
		for(TipoCurso tipocurso: tipocursos) {
			if(tipocurso.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCurso(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoCursoConstantesFunciones.getArrayColumnasGlobalesTipoCurso(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCurso(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoCursoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoCursoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoCurso(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoCurso> tipocursos,TipoCurso tipocurso,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoCurso tipocursoAux: tipocursos) {
			if(tipocursoAux!=null && tipocurso!=null) {
				if((tipocursoAux.getId()==null && tipocurso.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocursoAux.getId()!=null && tipocurso.getId()!=null){
					if(tipocursoAux.getId().equals(tipocurso.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoCurso(List<TipoCurso> tipocursos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoCurso tipocurso: tipocursos) {			
			if(tipocurso.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoCurso() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoCursoConstantesFunciones.LABEL_ID, TipoCursoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCursoConstantesFunciones.LABEL_VERSIONROW, TipoCursoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCursoConstantesFunciones.LABEL_IDEMPRESA, TipoCursoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCursoConstantesFunciones.LABEL_CODIGO, TipoCursoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCursoConstantesFunciones.LABEL_NOMBRE, TipoCursoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoCurso() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoCursoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCursoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCursoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCursoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCursoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCurso() throws Exception  {
		return TipoCursoConstantesFunciones.getTiposSeleccionarTipoCurso(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCurso(Boolean conFk) throws Exception  {
		return TipoCursoConstantesFunciones.getTiposSeleccionarTipoCurso(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCurso(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCursoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoCursoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCursoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoCursoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCursoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoCursoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoCurso(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCurso(TipoCurso tipocursoAux) throws Exception {
		
			tipocursoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocursoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCurso(List<TipoCurso> tipocursosTemp) throws Exception {
		for(TipoCurso tipocursoAux:tipocursosTemp) {
			
			tipocursoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocursoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCurso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoCurso(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCurso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCursoConstantesFunciones.getClassesRelationshipsOfTipoCurso(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCurso(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Curso.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Curso.class)) {
						classes.add(new Classe(Curso.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCurso(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCursoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoCurso(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCurso(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(TipoCurso tipocurso,List<TipoCurso> tipocursos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoCurso tipocursoEncontrado=null;
			
			for(TipoCurso tipocursoLocal:tipocursos) {
				if(tipocursoLocal.getId().equals(tipocurso.getId())) {
					tipocursoEncontrado=tipocursoLocal;
					
					tipocursoLocal.setIsChanged(tipocurso.getIsChanged());
					tipocursoLocal.setIsNew(tipocurso.getIsNew());
					tipocursoLocal.setIsDeleted(tipocurso.getIsDeleted());
					
					tipocursoLocal.setGeneralEntityOriginal(tipocurso.getGeneralEntityOriginal());
					
					tipocursoLocal.setId(tipocurso.getId());	
					tipocursoLocal.setVersionRow(tipocurso.getVersionRow());	
					tipocursoLocal.setid_empresa(tipocurso.getid_empresa());	
					tipocursoLocal.setcodigo(tipocurso.getcodigo());	
					tipocursoLocal.setnombre(tipocurso.getnombre());	
					
					
					tipocursoLocal.setCursos(tipocurso.getCursos());
					
					existe=true;
					break;
				}
			}
			
			if(!tipocurso.getIsDeleted()) {
				if(!existe) {
					tipocursos.add(tipocurso);
				}
			} else {
				if(tipocursoEncontrado!=null && permiteQuitar)  {
					tipocursos.remove(tipocursoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoCurso tipocurso,List<TipoCurso> tipocursos) throws Exception {
		try	{			
			for(TipoCurso tipocursoLocal:tipocursos) {
				if(tipocursoLocal.getId().equals(tipocurso.getId())) {
					tipocursoLocal.setIsSelected(tipocurso.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoCurso(List<TipoCurso> tipocursosAux) throws Exception {
		//this.tipocursosAux=tipocursosAux;
		
		for(TipoCurso tipocursoAux:tipocursosAux) {
			if(tipocursoAux.getIsChanged()) {
				tipocursoAux.setIsChanged(false);
			}		
			
			if(tipocursoAux.getIsNew()) {
				tipocursoAux.setIsNew(false);
			}	
			
			if(tipocursoAux.getIsDeleted()) {
				tipocursoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoCurso(TipoCurso tipocursoAux) throws Exception {
		//this.tipocursoAux=tipocursoAux;
		
			if(tipocursoAux.getIsChanged()) {
				tipocursoAux.setIsChanged(false);
			}		
			
			if(tipocursoAux.getIsNew()) {
				tipocursoAux.setIsNew(false);
			}	
			
			if(tipocursoAux.getIsDeleted()) {
				tipocursoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoCurso tipocursoAsignar,TipoCurso tipocurso) throws Exception {
		tipocursoAsignar.setId(tipocurso.getId());	
		tipocursoAsignar.setVersionRow(tipocurso.getVersionRow());	
		tipocursoAsignar.setid_empresa(tipocurso.getid_empresa());
		tipocursoAsignar.setempresa_descripcion(tipocurso.getempresa_descripcion());	
		tipocursoAsignar.setcodigo(tipocurso.getcodigo());	
		tipocursoAsignar.setnombre(tipocurso.getnombre());	
	}
	
	public static void inicializarTipoCurso(TipoCurso tipocurso) throws Exception {
		try {
				tipocurso.setId(0L);	
					
				tipocurso.setid_empresa(-1L);	
				tipocurso.setcodigo("");	
				tipocurso.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoCurso(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCursoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCursoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCursoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoCurso(String sTipo,Row row,Workbook workbook,TipoCurso tipocurso,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocurso.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocurso.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocurso.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoCurso=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoCurso() {
		return this.sFinalQueryTipoCurso;
	}
	
	public void setsFinalQueryTipoCurso(String sFinalQueryTipoCurso) {
		this.sFinalQueryTipoCurso= sFinalQueryTipoCurso;
	}
	
	public Border resaltarSeleccionarTipoCurso=null;
	
	public Border setResaltarSeleccionarTipoCurso(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCursoBeanSwingJInternalFrame tipocursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocursoBeanSwingJInternalFrame.jTtoolBarTipoCurso.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoCurso= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoCurso() {
		return this.resaltarSeleccionarTipoCurso;
	}
	
	public void setResaltarSeleccionarTipoCurso(Border borderResaltarSeleccionarTipoCurso) {
		this.resaltarSeleccionarTipoCurso= borderResaltarSeleccionarTipoCurso;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoCurso=null;
	public Boolean mostraridTipoCurso=true;
	public Boolean activaridTipoCurso=true;

	public Border resaltarid_empresaTipoCurso=null;
	public Boolean mostrarid_empresaTipoCurso=true;
	public Boolean activarid_empresaTipoCurso=true;
	public Boolean cargarid_empresaTipoCurso=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoCurso=false;//ConEventDepend=true

	public Border resaltarcodigoTipoCurso=null;
	public Boolean mostrarcodigoTipoCurso=true;
	public Boolean activarcodigoTipoCurso=true;

	public Border resaltarnombreTipoCurso=null;
	public Boolean mostrarnombreTipoCurso=true;
	public Boolean activarnombreTipoCurso=true;

	
	

	public Border setResaltaridTipoCurso(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCursoBeanSwingJInternalFrame tipocursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocursoBeanSwingJInternalFrame.jTtoolBarTipoCurso.setBorder(borderResaltar);
		
		this.resaltaridTipoCurso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoCurso() {
		return this.resaltaridTipoCurso;
	}

	public void setResaltaridTipoCurso(Border borderResaltar) {
		this.resaltaridTipoCurso= borderResaltar;
	}

	public Boolean getMostraridTipoCurso() {
		return this.mostraridTipoCurso;
	}

	public void setMostraridTipoCurso(Boolean mostraridTipoCurso) {
		this.mostraridTipoCurso= mostraridTipoCurso;
	}

	public Boolean getActivaridTipoCurso() {
		return this.activaridTipoCurso;
	}

	public void setActivaridTipoCurso(Boolean activaridTipoCurso) {
		this.activaridTipoCurso= activaridTipoCurso;
	}

	public Border setResaltarid_empresaTipoCurso(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCursoBeanSwingJInternalFrame tipocursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocursoBeanSwingJInternalFrame.jTtoolBarTipoCurso.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoCurso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoCurso() {
		return this.resaltarid_empresaTipoCurso;
	}

	public void setResaltarid_empresaTipoCurso(Border borderResaltar) {
		this.resaltarid_empresaTipoCurso= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoCurso() {
		return this.mostrarid_empresaTipoCurso;
	}

	public void setMostrarid_empresaTipoCurso(Boolean mostrarid_empresaTipoCurso) {
		this.mostrarid_empresaTipoCurso= mostrarid_empresaTipoCurso;
	}

	public Boolean getActivarid_empresaTipoCurso() {
		return this.activarid_empresaTipoCurso;
	}

	public void setActivarid_empresaTipoCurso(Boolean activarid_empresaTipoCurso) {
		this.activarid_empresaTipoCurso= activarid_empresaTipoCurso;
	}

	public Boolean getCargarid_empresaTipoCurso() {
		return this.cargarid_empresaTipoCurso;
	}

	public void setCargarid_empresaTipoCurso(Boolean cargarid_empresaTipoCurso) {
		this.cargarid_empresaTipoCurso= cargarid_empresaTipoCurso;
	}

	public Border setResaltarcodigoTipoCurso(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCursoBeanSwingJInternalFrame tipocursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocursoBeanSwingJInternalFrame.jTtoolBarTipoCurso.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoCurso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoCurso() {
		return this.resaltarcodigoTipoCurso;
	}

	public void setResaltarcodigoTipoCurso(Border borderResaltar) {
		this.resaltarcodigoTipoCurso= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoCurso() {
		return this.mostrarcodigoTipoCurso;
	}

	public void setMostrarcodigoTipoCurso(Boolean mostrarcodigoTipoCurso) {
		this.mostrarcodigoTipoCurso= mostrarcodigoTipoCurso;
	}

	public Boolean getActivarcodigoTipoCurso() {
		return this.activarcodigoTipoCurso;
	}

	public void setActivarcodigoTipoCurso(Boolean activarcodigoTipoCurso) {
		this.activarcodigoTipoCurso= activarcodigoTipoCurso;
	}

	public Border setResaltarnombreTipoCurso(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCursoBeanSwingJInternalFrame tipocursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocursoBeanSwingJInternalFrame.jTtoolBarTipoCurso.setBorder(borderResaltar);
		
		this.resaltarnombreTipoCurso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoCurso() {
		return this.resaltarnombreTipoCurso;
	}

	public void setResaltarnombreTipoCurso(Border borderResaltar) {
		this.resaltarnombreTipoCurso= borderResaltar;
	}

	public Boolean getMostrarnombreTipoCurso() {
		return this.mostrarnombreTipoCurso;
	}

	public void setMostrarnombreTipoCurso(Boolean mostrarnombreTipoCurso) {
		this.mostrarnombreTipoCurso= mostrarnombreTipoCurso;
	}

	public Boolean getActivarnombreTipoCurso() {
		return this.activarnombreTipoCurso;
	}

	public void setActivarnombreTipoCurso(Boolean activarnombreTipoCurso) {
		this.activarnombreTipoCurso= activarnombreTipoCurso;
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
		
		
		this.setMostraridTipoCurso(esInicial);
		this.setMostrarid_empresaTipoCurso(esInicial);
		this.setMostrarcodigoTipoCurso(esInicial);
		this.setMostrarnombreTipoCurso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCursoConstantesFunciones.ID)) {
				this.setMostraridTipoCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCursoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCursoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCursoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoCurso(esAsigna);
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
		
		
		this.setActivaridTipoCurso(esInicial);
		this.setActivarid_empresaTipoCurso(esInicial);
		this.setActivarcodigoTipoCurso(esInicial);
		this.setActivarnombreTipoCurso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCursoConstantesFunciones.ID)) {
				this.setActivaridTipoCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCursoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCursoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCursoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoCurso(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCursoBeanSwingJInternalFrame tipocursoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoCurso(esInicial);
		this.setResaltarid_empresaTipoCurso(esInicial);
		this.setResaltarcodigoTipoCurso(esInicial);
		this.setResaltarnombreTipoCurso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCursoConstantesFunciones.ID)) {
				this.setResaltaridTipoCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCursoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCursoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCursoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoCurso(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarCursoTipoCurso=null;

	public Border getResaltarCursoTipoCurso() {
		return this.resaltarCursoTipoCurso;
	}

	public void setResaltarCursoTipoCurso(Border borderResaltarCurso) {
		if(borderResaltarCurso!=null) {
			this.resaltarCursoTipoCurso= borderResaltarCurso;
		}
	}

	public Border setResaltarCursoTipoCurso(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCursoBeanSwingJInternalFrame tipocursoBeanSwingJInternalFrame*/) {
		Border borderResaltarCurso=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocursoBeanSwingJInternalFrame.jTtoolBarTipoCurso.setBorder(borderResaltarCurso);
			
		this.resaltarCursoTipoCurso= borderResaltarCurso;

		 return borderResaltarCurso;
	}



	public Boolean mostrarCursoTipoCurso=true;

	public Boolean getMostrarCursoTipoCurso() {
		return this.mostrarCursoTipoCurso;
	}

	public void setMostrarCursoTipoCurso(Boolean visibilidadResaltarCurso) {
		this.mostrarCursoTipoCurso= visibilidadResaltarCurso;
	}



	public Boolean activarCursoTipoCurso=true;

	public Boolean gethabilitarResaltarCursoTipoCurso() {
		return this.activarCursoTipoCurso;
	}

	public void setActivarCursoTipoCurso(Boolean habilitarResaltarCurso) {
		this.activarCursoTipoCurso= habilitarResaltarCurso;
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

		this.setMostrarCursoTipoCurso(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Curso.class)) {
				this.setMostrarCursoTipoCurso(esAsigna);
				continue;
			}
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

		this.setActivarCursoTipoCurso(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Curso.class)) {
				this.setActivarCursoTipoCurso(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCursoBeanSwingJInternalFrame tipocursoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarCursoTipoCurso(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Curso.class)) {
				this.setResaltarCursoTipoCurso(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoCurso=true;

	public Boolean getMostrarFK_IdEmpresaTipoCurso() {
		return this.mostrarFK_IdEmpresaTipoCurso;
	}

	public void setMostrarFK_IdEmpresaTipoCurso(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoCurso= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoCurso=true;

	public Boolean getActivarFK_IdEmpresaTipoCurso() {
		return this.activarFK_IdEmpresaTipoCurso;
	}

	public void setActivarFK_IdEmpresaTipoCurso(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoCurso= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoCurso=null;

	public Border getResaltarFK_IdEmpresaTipoCurso() {
		return this.resaltarFK_IdEmpresaTipoCurso;
	}

	public void setResaltarFK_IdEmpresaTipoCurso(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoCurso= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoCurso(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCursoBeanSwingJInternalFrame tipocursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoCurso= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}