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
package com.bydan.erp.seguridad.util;

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


import com.bydan.erp.seguridad.util.TipoEmpresaConstantesFunciones;
import com.bydan.erp.seguridad.util.TipoEmpresaParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.TipoEmpresaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;



import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoEmpresaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoEmpresa";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoEmpresa"+TipoEmpresaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoEmpresaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoEmpresaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoEmpresaConstantesFunciones.SCHEMA+"_"+TipoEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoEmpresaConstantesFunciones.SCHEMA+"_"+TipoEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoEmpresaConstantesFunciones.SCHEMA+"_"+TipoEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoEmpresaConstantesFunciones.SCHEMA+"_"+TipoEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoEmpresaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoEmpresaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoEmpresaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoEmpresaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Empresas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Empresa";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Empresa";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoEmpresa";
	public static final String OBJECTNAME="tipoempresa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="tipo_empresa";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoempresa from "+TipoEmpresaConstantesFunciones.SPERSISTENCENAME+" tipoempresa";
	public static String QUERYSELECTNATIVE="select "+TipoEmpresaConstantesFunciones.SCHEMA+"."+TipoEmpresaConstantesFunciones.TABLENAME+".id,"+TipoEmpresaConstantesFunciones.SCHEMA+"."+TipoEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoEmpresaConstantesFunciones.SCHEMA+"."+TipoEmpresaConstantesFunciones.TABLENAME+".codigo,"+TipoEmpresaConstantesFunciones.SCHEMA+"."+TipoEmpresaConstantesFunciones.TABLENAME+".nombre from "+TipoEmpresaConstantesFunciones.SCHEMA+"."+TipoEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoEmpresaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoEmpresaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoEmpresaConstantesFunciones.CODIGO)) {sLabelColumna=TipoEmpresaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoEmpresaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoEmpresaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoEmpresaDescripcion(TipoEmpresa tipoempresa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoempresa !=null/* && tipoempresa.getId()!=0*/) {
			sDescripcion=tipoempresa.getcodigo();//tipoempresatipoempresa.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoEmpresaDescripcionDetallado(TipoEmpresa tipoempresa) {
		String sDescripcion="";
			
		sDescripcion+=TipoEmpresaConstantesFunciones.ID+"=";
		sDescripcion+=tipoempresa.getId().toString()+",";
		sDescripcion+=TipoEmpresaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoempresa.getVersionRow().toString()+",";
		sDescripcion+=TipoEmpresaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoempresa.getcodigo()+",";
		sDescripcion+=TipoEmpresaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoempresa.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoEmpresaDescripcion(TipoEmpresa tipoempresa,String sValor) throws Exception {			
		if(tipoempresa !=null) {
			tipoempresa.setcodigo(sValor);;//tipoempresatipoempresa.getcodigo().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("PorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndicePorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoEmpresa(TipoEmpresa tipoempresa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoempresa.setcodigo(tipoempresa.getcodigo().trim());
		tipoempresa.setnombre(tipoempresa.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoEmpresas(List<TipoEmpresa> tipoempresas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoEmpresa tipoempresa: tipoempresas) {
			tipoempresa.setcodigo(tipoempresa.getcodigo().trim());
			tipoempresa.setnombre(tipoempresa.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoEmpresa(TipoEmpresa tipoempresa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoempresa.getConCambioAuxiliar()) {
			tipoempresa.setIsDeleted(tipoempresa.getIsDeletedAuxiliar());	
			tipoempresa.setIsNew(tipoempresa.getIsNewAuxiliar());	
			tipoempresa.setIsChanged(tipoempresa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoempresa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoempresa.setIsDeletedAuxiliar(false);	
			tipoempresa.setIsNewAuxiliar(false);	
			tipoempresa.setIsChangedAuxiliar(false);
			
			tipoempresa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoEmpresas(List<TipoEmpresa> tipoempresas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoEmpresa tipoempresa : tipoempresas) {
			if(conAsignarBase && tipoempresa.getConCambioAuxiliar()) {
				tipoempresa.setIsDeleted(tipoempresa.getIsDeletedAuxiliar());	
				tipoempresa.setIsNew(tipoempresa.getIsNewAuxiliar());	
				tipoempresa.setIsChanged(tipoempresa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoempresa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoempresa.setIsDeletedAuxiliar(false);	
				tipoempresa.setIsNewAuxiliar(false);	
				tipoempresa.setIsChangedAuxiliar(false);
				
				tipoempresa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoEmpresa(TipoEmpresa tipoempresa,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoEmpresas(List<TipoEmpresa> tipoempresas,Boolean conEnteros) throws Exception  {
		
		for(TipoEmpresa tipoempresa: tipoempresas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoEmpresa(List<TipoEmpresa> tipoempresas,TipoEmpresa tipoempresaAux) throws Exception  {
		TipoEmpresaConstantesFunciones.InicializarValoresTipoEmpresa(tipoempresaAux,true);
		
		for(TipoEmpresa tipoempresa: tipoempresas) {
			if(tipoempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoEmpresaConstantesFunciones.getArrayColumnasGlobalesTipoEmpresa(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoEmpresa(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoEmpresa> tipoempresas,TipoEmpresa tipoempresa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoEmpresa tipoempresaAux: tipoempresas) {
			if(tipoempresaAux!=null && tipoempresa!=null) {
				if((tipoempresaAux.getId()==null && tipoempresa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoempresaAux.getId()!=null && tipoempresa.getId()!=null){
					if(tipoempresaAux.getId().equals(tipoempresa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoEmpresa(List<TipoEmpresa> tipoempresas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoEmpresa tipoempresa: tipoempresas) {			
			if(tipoempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoEmpresa() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoEmpresaConstantesFunciones.LABEL_ID, TipoEmpresaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEmpresaConstantesFunciones.LABEL_VERSIONROW, TipoEmpresaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEmpresaConstantesFunciones.LABEL_CODIGO, TipoEmpresaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEmpresaConstantesFunciones.LABEL_NOMBRE, TipoEmpresaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoEmpresa() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoEmpresaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEmpresaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEmpresaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEmpresaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoEmpresa() throws Exception  {
		return TipoEmpresaConstantesFunciones.getTiposSeleccionarTipoEmpresa(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoEmpresa(Boolean conFk) throws Exception  {
		return TipoEmpresaConstantesFunciones.getTiposSeleccionarTipoEmpresa(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoEmpresa(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoEmpresaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoEmpresaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoEmpresaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoEmpresaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoEmpresa(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoEmpresa(TipoEmpresa tipoempresaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoEmpresa(List<TipoEmpresa> tipoempresasTemp) throws Exception {
		for(TipoEmpresa tipoempresaAux:tipoempresasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoEmpresaConstantesFunciones.getClassesRelationshipsOfTipoEmpresa(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoEmpresaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoEmpresa(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(TipoEmpresa tipoempresa,List<TipoEmpresa> tipoempresas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoEmpresa tipoempresaEncontrado=null;
			
			for(TipoEmpresa tipoempresaLocal:tipoempresas) {
				if(tipoempresaLocal.getId().equals(tipoempresa.getId())) {
					tipoempresaEncontrado=tipoempresaLocal;
					
					tipoempresaLocal.setIsChanged(tipoempresa.getIsChanged());
					tipoempresaLocal.setIsNew(tipoempresa.getIsNew());
					tipoempresaLocal.setIsDeleted(tipoempresa.getIsDeleted());
					
					tipoempresaLocal.setGeneralEntityOriginal(tipoempresa.getGeneralEntityOriginal());
					
					tipoempresaLocal.setId(tipoempresa.getId());	
					tipoempresaLocal.setVersionRow(tipoempresa.getVersionRow());	
					tipoempresaLocal.setcodigo(tipoempresa.getcodigo());	
					tipoempresaLocal.setnombre(tipoempresa.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoempresa.getIsDeleted()) {
				if(!existe) {
					tipoempresas.add(tipoempresa);
				}
			} else {
				if(tipoempresaEncontrado!=null && permiteQuitar)  {
					tipoempresas.remove(tipoempresaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoEmpresa tipoempresa,List<TipoEmpresa> tipoempresas) throws Exception {
		try	{			
			for(TipoEmpresa tipoempresaLocal:tipoempresas) {
				if(tipoempresaLocal.getId().equals(tipoempresa.getId())) {
					tipoempresaLocal.setIsSelected(tipoempresa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoEmpresa(List<TipoEmpresa> tipoempresasAux) throws Exception {
		//this.tipoempresasAux=tipoempresasAux;
		
		for(TipoEmpresa tipoempresaAux:tipoempresasAux) {
			if(tipoempresaAux.getIsChanged()) {
				tipoempresaAux.setIsChanged(false);
			}		
			
			if(tipoempresaAux.getIsNew()) {
				tipoempresaAux.setIsNew(false);
			}	
			
			if(tipoempresaAux.getIsDeleted()) {
				tipoempresaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoEmpresa(TipoEmpresa tipoempresaAux) throws Exception {
		//this.tipoempresaAux=tipoempresaAux;
		
			if(tipoempresaAux.getIsChanged()) {
				tipoempresaAux.setIsChanged(false);
			}		
			
			if(tipoempresaAux.getIsNew()) {
				tipoempresaAux.setIsNew(false);
			}	
			
			if(tipoempresaAux.getIsDeleted()) {
				tipoempresaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoEmpresa tipoempresaAsignar,TipoEmpresa tipoempresa) throws Exception {
		tipoempresaAsignar.setId(tipoempresa.getId());	
		tipoempresaAsignar.setVersionRow(tipoempresa.getVersionRow());	
		tipoempresaAsignar.setcodigo(tipoempresa.getcodigo());	
		tipoempresaAsignar.setnombre(tipoempresa.getnombre());	
	}
	
	public static void inicializarTipoEmpresa(TipoEmpresa tipoempresa) throws Exception {
		try {
				tipoempresa.setId(0L);	
					
				tipoempresa.setcodigo("");	
				tipoempresa.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoEmpresa(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoEmpresaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoEmpresaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoEmpresa(String sTipo,Row row,Workbook workbook,TipoEmpresa tipoempresa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoempresa.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoempresa.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoEmpresa=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoEmpresa() {
		return this.sFinalQueryTipoEmpresa;
	}
	
	public void setsFinalQueryTipoEmpresa(String sFinalQueryTipoEmpresa) {
		this.sFinalQueryTipoEmpresa= sFinalQueryTipoEmpresa;
	}
	
	public Border resaltarSeleccionarTipoEmpresa=null;
	
	public Border setResaltarSeleccionarTipoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEmpresaBeanSwingJInternalFrame tipoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoempresaBeanSwingJInternalFrame.jTtoolBarTipoEmpresa.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoEmpresa= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoEmpresa() {
		return this.resaltarSeleccionarTipoEmpresa;
	}
	
	public void setResaltarSeleccionarTipoEmpresa(Border borderResaltarSeleccionarTipoEmpresa) {
		this.resaltarSeleccionarTipoEmpresa= borderResaltarSeleccionarTipoEmpresa;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoEmpresa=null;
	public Boolean mostraridTipoEmpresa=true;
	public Boolean activaridTipoEmpresa=true;

	public Border resaltarcodigoTipoEmpresa=null;
	public Boolean mostrarcodigoTipoEmpresa=true;
	public Boolean activarcodigoTipoEmpresa=true;

	public Border resaltarnombreTipoEmpresa=null;
	public Boolean mostrarnombreTipoEmpresa=true;
	public Boolean activarnombreTipoEmpresa=true;

	
	

	public Border setResaltaridTipoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEmpresaBeanSwingJInternalFrame tipoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoempresaBeanSwingJInternalFrame.jTtoolBarTipoEmpresa.setBorder(borderResaltar);
		
		this.resaltaridTipoEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoEmpresa() {
		return this.resaltaridTipoEmpresa;
	}

	public void setResaltaridTipoEmpresa(Border borderResaltar) {
		this.resaltaridTipoEmpresa= borderResaltar;
	}

	public Boolean getMostraridTipoEmpresa() {
		return this.mostraridTipoEmpresa;
	}

	public void setMostraridTipoEmpresa(Boolean mostraridTipoEmpresa) {
		this.mostraridTipoEmpresa= mostraridTipoEmpresa;
	}

	public Boolean getActivaridTipoEmpresa() {
		return this.activaridTipoEmpresa;
	}

	public void setActivaridTipoEmpresa(Boolean activaridTipoEmpresa) {
		this.activaridTipoEmpresa= activaridTipoEmpresa;
	}

	public Border setResaltarcodigoTipoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEmpresaBeanSwingJInternalFrame tipoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoempresaBeanSwingJInternalFrame.jTtoolBarTipoEmpresa.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoEmpresa() {
		return this.resaltarcodigoTipoEmpresa;
	}

	public void setResaltarcodigoTipoEmpresa(Border borderResaltar) {
		this.resaltarcodigoTipoEmpresa= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoEmpresa() {
		return this.mostrarcodigoTipoEmpresa;
	}

	public void setMostrarcodigoTipoEmpresa(Boolean mostrarcodigoTipoEmpresa) {
		this.mostrarcodigoTipoEmpresa= mostrarcodigoTipoEmpresa;
	}

	public Boolean getActivarcodigoTipoEmpresa() {
		return this.activarcodigoTipoEmpresa;
	}

	public void setActivarcodigoTipoEmpresa(Boolean activarcodigoTipoEmpresa) {
		this.activarcodigoTipoEmpresa= activarcodigoTipoEmpresa;
	}

	public Border setResaltarnombreTipoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEmpresaBeanSwingJInternalFrame tipoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoempresaBeanSwingJInternalFrame.jTtoolBarTipoEmpresa.setBorder(borderResaltar);
		
		this.resaltarnombreTipoEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoEmpresa() {
		return this.resaltarnombreTipoEmpresa;
	}

	public void setResaltarnombreTipoEmpresa(Border borderResaltar) {
		this.resaltarnombreTipoEmpresa= borderResaltar;
	}

	public Boolean getMostrarnombreTipoEmpresa() {
		return this.mostrarnombreTipoEmpresa;
	}

	public void setMostrarnombreTipoEmpresa(Boolean mostrarnombreTipoEmpresa) {
		this.mostrarnombreTipoEmpresa= mostrarnombreTipoEmpresa;
	}

	public Boolean getActivarnombreTipoEmpresa() {
		return this.activarnombreTipoEmpresa;
	}

	public void setActivarnombreTipoEmpresa(Boolean activarnombreTipoEmpresa) {
		this.activarnombreTipoEmpresa= activarnombreTipoEmpresa;
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
		
		
		this.setMostraridTipoEmpresa(esInicial);
		this.setMostrarcodigoTipoEmpresa(esInicial);
		this.setMostrarnombreTipoEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoEmpresaConstantesFunciones.ID)) {
				this.setMostraridTipoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEmpresaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEmpresaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoEmpresa(esAsigna);
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
		
		
		this.setActivaridTipoEmpresa(esInicial);
		this.setActivarcodigoTipoEmpresa(esInicial);
		this.setActivarnombreTipoEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoEmpresaConstantesFunciones.ID)) {
				this.setActivaridTipoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEmpresaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEmpresaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoEmpresa(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoEmpresaBeanSwingJInternalFrame tipoempresaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoEmpresa(esInicial);
		this.setResaltarcodigoTipoEmpresa(esInicial);
		this.setResaltarnombreTipoEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoEmpresaConstantesFunciones.ID)) {
				this.setResaltaridTipoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEmpresaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEmpresaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoEmpresa(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoEmpresaBeanSwingJInternalFrame tipoempresaBeanSwingJInternalFrame*/)throws Exception {	
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