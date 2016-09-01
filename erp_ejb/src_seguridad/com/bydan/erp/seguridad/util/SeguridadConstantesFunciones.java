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


import com.bydan.erp.seguridad.util.SeguridadConstantesFunciones;
import com.bydan.erp.seguridad.util.SeguridadParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.SeguridadParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.util.report.*;
import com.bydan.erp.seguridad.business.entity.report.*;
import com.bydan.erp.seguridad.util.SeguridadSql;
import com.bydan.erp.seguridad.util.SeguridadSqlReporte;


@SuppressWarnings("unused")
final public class SeguridadConstantesFunciones extends SeguridadConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Seguridad";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Seguridad"+SeguridadConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SeguridadHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SeguridadHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SeguridadConstantesFunciones.SCHEMA+"_"+SeguridadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SeguridadHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SeguridadConstantesFunciones.SCHEMA+"_"+SeguridadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SeguridadConstantesFunciones.SCHEMA+"_"+SeguridadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SeguridadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SeguridadConstantesFunciones.SCHEMA+"_"+SeguridadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SeguridadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SeguridadHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SeguridadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SeguridadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SeguridadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SeguridadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SeguridadConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SeguridadConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SeguridadConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SeguridadConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Seguridades";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Seguridad";
	public static final String SCLASSWEBTITULO_LOWER="Seguridad";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Seguridad";
	public static final String OBJECTNAME="seguridad";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="seguridad";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select seguridad from "+SeguridadConstantesFunciones.SPERSISTENCENAME+" seguridad";
	public static String QUERYSELECTNATIVE="select "+SeguridadConstantesFunciones.SCHEMA+"."+SeguridadConstantesFunciones.TABLENAME+".id,"+SeguridadConstantesFunciones.SCHEMA+"."+SeguridadConstantesFunciones.TABLENAME+".version_row,"+SeguridadConstantesFunciones.SCHEMA+"."+SeguridadConstantesFunciones.TABLENAME+".codigo from "+SeguridadConstantesFunciones.SCHEMA+"."+SeguridadConstantesFunciones.TABLENAME;//+" as "+SeguridadConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected SeguridadConstantesFuncionesAdditional seguridadConstantesFuncionesAdditional=null;
	
	public SeguridadConstantesFuncionesAdditional getSeguridadConstantesFuncionesAdditional() {
		return this.seguridadConstantesFuncionesAdditional;
	}
	
	public void setSeguridadConstantesFuncionesAdditional(SeguridadConstantesFuncionesAdditional seguridadConstantesFuncionesAdditional) {
		try {
			this.seguridadConstantesFuncionesAdditional=seguridadConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getSeguridadLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SeguridadConstantesFunciones.CODIGO)) {sLabelColumna=SeguridadConstantesFunciones.LABEL_CODIGO;}
		
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
	
	
	
			
			
			
	
	public static String getSeguridadDescripcion(Seguridad seguridad) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(seguridad !=null/* && seguridad.getId()!=0*/) {
			sDescripcion=seguridad.getcodigo();//seguridadseguridad.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getSeguridadDescripcionDetallado(Seguridad seguridad) {
		String sDescripcion="";
			
		sDescripcion+=SeguridadConstantesFunciones.ID+"=";
		sDescripcion+=seguridad.getId().toString()+",";
		sDescripcion+=SeguridadConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=seguridad.getVersionRow().toString()+",";
		sDescripcion+=SeguridadConstantesFunciones.CODIGO+"=";
		sDescripcion+=seguridad.getcodigo()+",";
			
		return sDescripcion;
	}
	
	public static void setSeguridadDescripcion(Seguridad seguridad,String sValor) throws Exception {			
		if(seguridad !=null) {
			seguridad.setcodigo(sValor);;//seguridadseguridad.getcodigo().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}
	
	
	
	
	
	
	public static void quitarEspaciosSeguridad(Seguridad seguridad,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		seguridad.setcodigo(seguridad.getcodigo().trim());
	}
	
	public static void quitarEspaciosSeguridads(List<Seguridad> seguridads,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Seguridad seguridad: seguridads) {
			seguridad.setcodigo(seguridad.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSeguridad(Seguridad seguridad,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && seguridad.getConCambioAuxiliar()) {
			seguridad.setIsDeleted(seguridad.getIsDeletedAuxiliar());	
			seguridad.setIsNew(seguridad.getIsNewAuxiliar());	
			seguridad.setIsChanged(seguridad.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			seguridad.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			seguridad.setIsDeletedAuxiliar(false);	
			seguridad.setIsNewAuxiliar(false);	
			seguridad.setIsChangedAuxiliar(false);
			
			seguridad.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSeguridads(List<Seguridad> seguridads,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Seguridad seguridad : seguridads) {
			if(conAsignarBase && seguridad.getConCambioAuxiliar()) {
				seguridad.setIsDeleted(seguridad.getIsDeletedAuxiliar());	
				seguridad.setIsNew(seguridad.getIsNewAuxiliar());	
				seguridad.setIsChanged(seguridad.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				seguridad.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				seguridad.setIsDeletedAuxiliar(false);	
				seguridad.setIsNewAuxiliar(false);	
				seguridad.setIsChangedAuxiliar(false);
				
				seguridad.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSeguridad(Seguridad seguridad,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSeguridads(List<Seguridad> seguridads,Boolean conEnteros) throws Exception  {
		
		for(Seguridad seguridad: seguridads) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSeguridad(List<Seguridad> seguridads,Seguridad seguridadAux) throws Exception  {
		SeguridadConstantesFunciones.InicializarValoresSeguridad(seguridadAux,true);
		
		for(Seguridad seguridad: seguridads) {
			if(seguridad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSeguridad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SeguridadConstantesFunciones.getArrayColumnasGlobalesSeguridad(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSeguridad(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSeguridad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Seguridad> seguridads,Seguridad seguridad,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Seguridad seguridadAux: seguridads) {
			if(seguridadAux!=null && seguridad!=null) {
				if((seguridadAux.getId()==null && seguridad.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(seguridadAux.getId()!=null && seguridad.getId()!=null){
					if(seguridadAux.getId().equals(seguridad.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSeguridad(List<Seguridad> seguridads) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Seguridad seguridad: seguridads) {			
			if(seguridad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSeguridad() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSeguridad() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSeguridad() throws Exception  {
		return SeguridadConstantesFunciones.getTiposSeleccionarSeguridad(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSeguridad(Boolean conFk) throws Exception  {
		return SeguridadConstantesFunciones.getTiposSeleccionarSeguridad(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSeguridad(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SeguridadConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(SeguridadConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSeguridad(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSeguridad(Seguridad seguridadAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesSeguridad(List<Seguridad> seguridadsTemp) throws Exception {
		for(Seguridad seguridadAux:seguridadsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSeguridad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSeguridad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSeguridad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SeguridadConstantesFunciones.getClassesRelationshipsOfSeguridad(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSeguridad(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSeguridad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SeguridadConstantesFunciones.getClassesRelationshipsFromStringsOfSeguridad(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSeguridad(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Seguridad seguridad,List<Seguridad> seguridads,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Seguridad seguridadEncontrado=null;
			
			for(Seguridad seguridadLocal:seguridads) {
				if(seguridadLocal.getId().equals(seguridad.getId())) {
					seguridadEncontrado=seguridadLocal;
					
					seguridadLocal.setIsChanged(seguridad.getIsChanged());
					seguridadLocal.setIsNew(seguridad.getIsNew());
					seguridadLocal.setIsDeleted(seguridad.getIsDeleted());
					
					seguridadLocal.setGeneralEntityOriginal(seguridad.getGeneralEntityOriginal());
					
					seguridadLocal.setId(seguridad.getId());	
					seguridadLocal.setVersionRow(seguridad.getVersionRow());	
					seguridadLocal.setcodigo(seguridad.getcodigo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!seguridad.getIsDeleted()) {
				if(!existe) {
					seguridads.add(seguridad);
				}
			} else {
				if(seguridadEncontrado!=null && permiteQuitar)  {
					seguridads.remove(seguridadEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Seguridad seguridad,List<Seguridad> seguridads) throws Exception {
		try	{			
			for(Seguridad seguridadLocal:seguridads) {
				if(seguridadLocal.getId().equals(seguridad.getId())) {
					seguridadLocal.setIsSelected(seguridad.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSeguridad(List<Seguridad> seguridadsAux) throws Exception {
		//this.seguridadsAux=seguridadsAux;
		
		for(Seguridad seguridadAux:seguridadsAux) {
			if(seguridadAux.getIsChanged()) {
				seguridadAux.setIsChanged(false);
			}		
			
			if(seguridadAux.getIsNew()) {
				seguridadAux.setIsNew(false);
			}	
			
			if(seguridadAux.getIsDeleted()) {
				seguridadAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSeguridad(Seguridad seguridadAux) throws Exception {
		//this.seguridadAux=seguridadAux;
		
			if(seguridadAux.getIsChanged()) {
				seguridadAux.setIsChanged(false);
			}		
			
			if(seguridadAux.getIsNew()) {
				seguridadAux.setIsNew(false);
			}	
			
			if(seguridadAux.getIsDeleted()) {
				seguridadAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Seguridad seguridadAsignar,Seguridad seguridad) throws Exception {
		seguridadAsignar.setId(seguridad.getId());	
		seguridadAsignar.setVersionRow(seguridad.getVersionRow());	
		seguridadAsignar.setcodigo(seguridad.getcodigo());	
	}
	
	public static void inicializarSeguridad(Seguridad seguridad) throws Exception {
		try {
				seguridad.setId(0L);	
					
				seguridad.setcodigo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSeguridad(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SeguridadConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSeguridad(String sTipo,Row row,Workbook workbook,Seguridad seguridad,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(seguridad.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySeguridad=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySeguridad() {
		return this.sFinalQuerySeguridad;
	}
	
	public void setsFinalQuerySeguridad(String sFinalQuerySeguridad) {
		this.sFinalQuerySeguridad= sFinalQuerySeguridad;
	}
	
	public Border resaltarSeleccionarSeguridad=null;
	
	public Border setResaltarSeleccionarSeguridad(ParametroGeneralUsuario parametroGeneralUsuario/*SeguridadBeanSwingJInternalFrame seguridadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//seguridadBeanSwingJInternalFrame.jTtoolBarSeguridad.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSeguridad= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSeguridad() {
		return this.resaltarSeleccionarSeguridad;
	}
	
	public void setResaltarSeleccionarSeguridad(Border borderResaltarSeleccionarSeguridad) {
		this.resaltarSeleccionarSeguridad= borderResaltarSeleccionarSeguridad;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSeguridad=null;
	public Boolean mostraridSeguridad=true;
	public Boolean activaridSeguridad=true;

	public Border resaltarcodigoSeguridad=null;
	public Boolean mostrarcodigoSeguridad=true;
	public Boolean activarcodigoSeguridad=true;

	
	

	public Border setResaltaridSeguridad(ParametroGeneralUsuario parametroGeneralUsuario/*SeguridadBeanSwingJInternalFrame seguridadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//seguridadBeanSwingJInternalFrame.jTtoolBarSeguridad.setBorder(borderResaltar);
		
		this.resaltaridSeguridad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSeguridad() {
		return this.resaltaridSeguridad;
	}

	public void setResaltaridSeguridad(Border borderResaltar) {
		this.resaltaridSeguridad= borderResaltar;
	}

	public Boolean getMostraridSeguridad() {
		return this.mostraridSeguridad;
	}

	public void setMostraridSeguridad(Boolean mostraridSeguridad) {
		this.mostraridSeguridad= mostraridSeguridad;
	}

	public Boolean getActivaridSeguridad() {
		return this.activaridSeguridad;
	}

	public void setActivaridSeguridad(Boolean activaridSeguridad) {
		this.activaridSeguridad= activaridSeguridad;
	}

	public Border setResaltarcodigoSeguridad(ParametroGeneralUsuario parametroGeneralUsuario/*SeguridadBeanSwingJInternalFrame seguridadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//seguridadBeanSwingJInternalFrame.jTtoolBarSeguridad.setBorder(borderResaltar);
		
		this.resaltarcodigoSeguridad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoSeguridad() {
		return this.resaltarcodigoSeguridad;
	}

	public void setResaltarcodigoSeguridad(Border borderResaltar) {
		this.resaltarcodigoSeguridad= borderResaltar;
	}

	public Boolean getMostrarcodigoSeguridad() {
		return this.mostrarcodigoSeguridad;
	}

	public void setMostrarcodigoSeguridad(Boolean mostrarcodigoSeguridad) {
		this.mostrarcodigoSeguridad= mostrarcodigoSeguridad;
	}

	public Boolean getActivarcodigoSeguridad() {
		return this.activarcodigoSeguridad;
	}

	public void setActivarcodigoSeguridad(Boolean activarcodigoSeguridad) {
		this.activarcodigoSeguridad= activarcodigoSeguridad;
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
		
		
		this.setMostraridSeguridad(esInicial);
		this.setMostrarcodigoSeguridad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SeguridadConstantesFunciones.ID)) {
				this.setMostraridSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(SeguridadConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoSeguridad(esAsigna);
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
		
		
		this.setActivaridSeguridad(esInicial);
		this.setActivarcodigoSeguridad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SeguridadConstantesFunciones.ID)) {
				this.setActivaridSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(SeguridadConstantesFunciones.CODIGO)) {
				this.setActivarcodigoSeguridad(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SeguridadBeanSwingJInternalFrame seguridadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSeguridad(esInicial);
		this.setResaltarcodigoSeguridad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SeguridadConstantesFunciones.ID)) {
				this.setResaltaridSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(SeguridadConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoSeguridad(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SeguridadBeanSwingJInternalFrame seguridadBeanSwingJInternalFrame*/)throws Exception {	
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