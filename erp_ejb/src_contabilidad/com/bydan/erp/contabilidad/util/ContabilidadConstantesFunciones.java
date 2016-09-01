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


import com.bydan.erp.contabilidad.util.ContabilidadConstantesFunciones;
import com.bydan.erp.contabilidad.util.ContabilidadParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.ContabilidadParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.contabilidad.util.report.*;
import com.bydan.erp.contabilidad.business.entity.report.*;
import com.bydan.erp.contabilidad.util.ContabilidadSql;
import com.bydan.erp.contabilidad.util.ContabilidadSqlReporte;


@SuppressWarnings("unused")
final public class ContabilidadConstantesFunciones extends ContabilidadConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Contabilidad";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Contabilidad"+ContabilidadConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ContabilidadHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ContabilidadHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ContabilidadConstantesFunciones.SCHEMA+"_"+ContabilidadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ContabilidadHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ContabilidadConstantesFunciones.SCHEMA+"_"+ContabilidadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ContabilidadConstantesFunciones.SCHEMA+"_"+ContabilidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ContabilidadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ContabilidadConstantesFunciones.SCHEMA+"_"+ContabilidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ContabilidadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ContabilidadHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ContabilidadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ContabilidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ContabilidadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ContabilidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ContabilidadConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ContabilidadConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ContabilidadConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ContabilidadConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Contabilidads";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Contabilidad";
	public static final String SCLASSWEBTITULO_LOWER="Contabilidad";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Contabilidad";
	public static final String OBJECTNAME="contabilidad";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="contabilidad";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select contabilidad from "+ContabilidadConstantesFunciones.SPERSISTENCENAME+" contabilidad";
	public static String QUERYSELECTNATIVE="select "+ContabilidadConstantesFunciones.SCHEMA+"."+ContabilidadConstantesFunciones.TABLENAME+".id,"+ContabilidadConstantesFunciones.SCHEMA+"."+ContabilidadConstantesFunciones.TABLENAME+".version_row,"+ContabilidadConstantesFunciones.SCHEMA+"."+ContabilidadConstantesFunciones.TABLENAME+".codigo from "+ContabilidadConstantesFunciones.SCHEMA+"."+ContabilidadConstantesFunciones.TABLENAME;//+" as "+ContabilidadConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ContabilidadConstantesFuncionesAdditional contabilidadConstantesFuncionesAdditional=null;
	
	public ContabilidadConstantesFuncionesAdditional getContabilidadConstantesFuncionesAdditional() {
		return this.contabilidadConstantesFuncionesAdditional;
	}
	
	public void setContabilidadConstantesFuncionesAdditional(ContabilidadConstantesFuncionesAdditional contabilidadConstantesFuncionesAdditional) {
		try {
			this.contabilidadConstantesFuncionesAdditional=contabilidadConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getContabilidadLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ContabilidadConstantesFunciones.CODIGO)) {sLabelColumna=ContabilidadConstantesFunciones.LABEL_CODIGO;}
		
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
	
	
	
			
			
			
	
	public static String getContabilidadDescripcion(Contabilidad contabilidad) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(contabilidad !=null/* && contabilidad.getId()!=0*/) {
			sDescripcion=contabilidad.getcodigo();//contabilidadcontabilidad.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getContabilidadDescripcionDetallado(Contabilidad contabilidad) {
		String sDescripcion="";
			
		sDescripcion+=ContabilidadConstantesFunciones.ID+"=";
		sDescripcion+=contabilidad.getId().toString()+",";
		sDescripcion+=ContabilidadConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=contabilidad.getVersionRow().toString()+",";
		sDescripcion+=ContabilidadConstantesFunciones.CODIGO+"=";
		sDescripcion+=contabilidad.getcodigo()+",";
			
		return sDescripcion;
	}
	
	public static void setContabilidadDescripcion(Contabilidad contabilidad,String sValor) throws Exception {			
		if(contabilidad !=null) {
			contabilidad.setcodigo(sValor);;//contabilidadcontabilidad.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosContabilidad(Contabilidad contabilidad,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		contabilidad.setcodigo(contabilidad.getcodigo().trim());
	}
	
	public static void quitarEspaciosContabilidads(List<Contabilidad> contabilidads,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Contabilidad contabilidad: contabilidads) {
			contabilidad.setcodigo(contabilidad.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresContabilidad(Contabilidad contabilidad,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && contabilidad.getConCambioAuxiliar()) {
			contabilidad.setIsDeleted(contabilidad.getIsDeletedAuxiliar());	
			contabilidad.setIsNew(contabilidad.getIsNewAuxiliar());	
			contabilidad.setIsChanged(contabilidad.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			contabilidad.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			contabilidad.setIsDeletedAuxiliar(false);	
			contabilidad.setIsNewAuxiliar(false);	
			contabilidad.setIsChangedAuxiliar(false);
			
			contabilidad.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresContabilidads(List<Contabilidad> contabilidads,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Contabilidad contabilidad : contabilidads) {
			if(conAsignarBase && contabilidad.getConCambioAuxiliar()) {
				contabilidad.setIsDeleted(contabilidad.getIsDeletedAuxiliar());	
				contabilidad.setIsNew(contabilidad.getIsNewAuxiliar());	
				contabilidad.setIsChanged(contabilidad.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				contabilidad.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				contabilidad.setIsDeletedAuxiliar(false);	
				contabilidad.setIsNewAuxiliar(false);	
				contabilidad.setIsChangedAuxiliar(false);
				
				contabilidad.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresContabilidad(Contabilidad contabilidad,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresContabilidads(List<Contabilidad> contabilidads,Boolean conEnteros) throws Exception  {
		
		for(Contabilidad contabilidad: contabilidads) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaContabilidad(List<Contabilidad> contabilidads,Contabilidad contabilidadAux) throws Exception  {
		ContabilidadConstantesFunciones.InicializarValoresContabilidad(contabilidadAux,true);
		
		for(Contabilidad contabilidad: contabilidads) {
			if(contabilidad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesContabilidad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ContabilidadConstantesFunciones.getArrayColumnasGlobalesContabilidad(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesContabilidad(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoContabilidad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Contabilidad> contabilidads,Contabilidad contabilidad,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Contabilidad contabilidadAux: contabilidads) {
			if(contabilidadAux!=null && contabilidad!=null) {
				if((contabilidadAux.getId()==null && contabilidad.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(contabilidadAux.getId()!=null && contabilidad.getId()!=null){
					if(contabilidadAux.getId().equals(contabilidad.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaContabilidad(List<Contabilidad> contabilidads) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Contabilidad contabilidad: contabilidads) {			
			if(contabilidad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaContabilidad() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasContabilidad() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarContabilidad() throws Exception  {
		return ContabilidadConstantesFunciones.getTiposSeleccionarContabilidad(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarContabilidad(Boolean conFk) throws Exception  {
		return ContabilidadConstantesFunciones.getTiposSeleccionarContabilidad(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarContabilidad(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ContabilidadConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ContabilidadConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesContabilidad(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesContabilidad(Contabilidad contabilidadAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesContabilidad(List<Contabilidad> contabilidadsTemp) throws Exception {
		for(Contabilidad contabilidadAux:contabilidadsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfContabilidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfContabilidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfContabilidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ContabilidadConstantesFunciones.getClassesRelationshipsOfContabilidad(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfContabilidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfContabilidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ContabilidadConstantesFunciones.getClassesRelationshipsFromStringsOfContabilidad(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfContabilidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Contabilidad contabilidad,List<Contabilidad> contabilidads,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Contabilidad contabilidadEncontrado=null;
			
			for(Contabilidad contabilidadLocal:contabilidads) {
				if(contabilidadLocal.getId().equals(contabilidad.getId())) {
					contabilidadEncontrado=contabilidadLocal;
					
					contabilidadLocal.setIsChanged(contabilidad.getIsChanged());
					contabilidadLocal.setIsNew(contabilidad.getIsNew());
					contabilidadLocal.setIsDeleted(contabilidad.getIsDeleted());
					
					contabilidadLocal.setGeneralEntityOriginal(contabilidad.getGeneralEntityOriginal());
					
					contabilidadLocal.setId(contabilidad.getId());	
					contabilidadLocal.setVersionRow(contabilidad.getVersionRow());	
					contabilidadLocal.setcodigo(contabilidad.getcodigo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!contabilidad.getIsDeleted()) {
				if(!existe) {
					contabilidads.add(contabilidad);
				}
			} else {
				if(contabilidadEncontrado!=null && permiteQuitar)  {
					contabilidads.remove(contabilidadEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Contabilidad contabilidad,List<Contabilidad> contabilidads) throws Exception {
		try	{			
			for(Contabilidad contabilidadLocal:contabilidads) {
				if(contabilidadLocal.getId().equals(contabilidad.getId())) {
					contabilidadLocal.setIsSelected(contabilidad.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesContabilidad(List<Contabilidad> contabilidadsAux) throws Exception {
		//this.contabilidadsAux=contabilidadsAux;
		
		for(Contabilidad contabilidadAux:contabilidadsAux) {
			if(contabilidadAux.getIsChanged()) {
				contabilidadAux.setIsChanged(false);
			}		
			
			if(contabilidadAux.getIsNew()) {
				contabilidadAux.setIsNew(false);
			}	
			
			if(contabilidadAux.getIsDeleted()) {
				contabilidadAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesContabilidad(Contabilidad contabilidadAux) throws Exception {
		//this.contabilidadAux=contabilidadAux;
		
			if(contabilidadAux.getIsChanged()) {
				contabilidadAux.setIsChanged(false);
			}		
			
			if(contabilidadAux.getIsNew()) {
				contabilidadAux.setIsNew(false);
			}	
			
			if(contabilidadAux.getIsDeleted()) {
				contabilidadAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Contabilidad contabilidadAsignar,Contabilidad contabilidad) throws Exception {
		contabilidadAsignar.setId(contabilidad.getId());	
		contabilidadAsignar.setVersionRow(contabilidad.getVersionRow());	
		contabilidadAsignar.setcodigo(contabilidad.getcodigo());	
	}
	
	public static void inicializarContabilidad(Contabilidad contabilidad) throws Exception {
		try {
				contabilidad.setId(0L);	
					
				contabilidad.setcodigo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderContabilidad(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ContabilidadConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataContabilidad(String sTipo,Row row,Workbook workbook,Contabilidad contabilidad,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(contabilidad.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryContabilidad=Constantes.SFINALQUERY;
	
	public String getsFinalQueryContabilidad() {
		return this.sFinalQueryContabilidad;
	}
	
	public void setsFinalQueryContabilidad(String sFinalQueryContabilidad) {
		this.sFinalQueryContabilidad= sFinalQueryContabilidad;
	}
	
	public Border resaltarSeleccionarContabilidad=null;
	
	public Border setResaltarSeleccionarContabilidad(ParametroGeneralUsuario parametroGeneralUsuario/*ContabilidadBeanSwingJInternalFrame contabilidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//contabilidadBeanSwingJInternalFrame.jTtoolBarContabilidad.setBorder(borderResaltar);
		
		this.resaltarSeleccionarContabilidad= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarContabilidad() {
		return this.resaltarSeleccionarContabilidad;
	}
	
	public void setResaltarSeleccionarContabilidad(Border borderResaltarSeleccionarContabilidad) {
		this.resaltarSeleccionarContabilidad= borderResaltarSeleccionarContabilidad;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridContabilidad=null;
	public Boolean mostraridContabilidad=true;
	public Boolean activaridContabilidad=true;

	public Border resaltarcodigoContabilidad=null;
	public Boolean mostrarcodigoContabilidad=true;
	public Boolean activarcodigoContabilidad=true;

	
	

	public Border setResaltaridContabilidad(ParametroGeneralUsuario parametroGeneralUsuario/*ContabilidadBeanSwingJInternalFrame contabilidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//contabilidadBeanSwingJInternalFrame.jTtoolBarContabilidad.setBorder(borderResaltar);
		
		this.resaltaridContabilidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridContabilidad() {
		return this.resaltaridContabilidad;
	}

	public void setResaltaridContabilidad(Border borderResaltar) {
		this.resaltaridContabilidad= borderResaltar;
	}

	public Boolean getMostraridContabilidad() {
		return this.mostraridContabilidad;
	}

	public void setMostraridContabilidad(Boolean mostraridContabilidad) {
		this.mostraridContabilidad= mostraridContabilidad;
	}

	public Boolean getActivaridContabilidad() {
		return this.activaridContabilidad;
	}

	public void setActivaridContabilidad(Boolean activaridContabilidad) {
		this.activaridContabilidad= activaridContabilidad;
	}

	public Border setResaltarcodigoContabilidad(ParametroGeneralUsuario parametroGeneralUsuario/*ContabilidadBeanSwingJInternalFrame contabilidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//contabilidadBeanSwingJInternalFrame.jTtoolBarContabilidad.setBorder(borderResaltar);
		
		this.resaltarcodigoContabilidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoContabilidad() {
		return this.resaltarcodigoContabilidad;
	}

	public void setResaltarcodigoContabilidad(Border borderResaltar) {
		this.resaltarcodigoContabilidad= borderResaltar;
	}

	public Boolean getMostrarcodigoContabilidad() {
		return this.mostrarcodigoContabilidad;
	}

	public void setMostrarcodigoContabilidad(Boolean mostrarcodigoContabilidad) {
		this.mostrarcodigoContabilidad= mostrarcodigoContabilidad;
	}

	public Boolean getActivarcodigoContabilidad() {
		return this.activarcodigoContabilidad;
	}

	public void setActivarcodigoContabilidad(Boolean activarcodigoContabilidad) {
		this.activarcodigoContabilidad= activarcodigoContabilidad;
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
		
		
		this.setMostraridContabilidad(esInicial);
		this.setMostrarcodigoContabilidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ContabilidadConstantesFunciones.ID)) {
				this.setMostraridContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContabilidadConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoContabilidad(esAsigna);
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
		
		
		this.setActivaridContabilidad(esInicial);
		this.setActivarcodigoContabilidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ContabilidadConstantesFunciones.ID)) {
				this.setActivaridContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContabilidadConstantesFunciones.CODIGO)) {
				this.setActivarcodigoContabilidad(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ContabilidadBeanSwingJInternalFrame contabilidadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridContabilidad(esInicial);
		this.setResaltarcodigoContabilidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ContabilidadConstantesFunciones.ID)) {
				this.setResaltaridContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContabilidadConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoContabilidad(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ContabilidadBeanSwingJInternalFrame contabilidadBeanSwingJInternalFrame*/)throws Exception {	
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