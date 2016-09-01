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
package com.bydan.erp.tesoreria.util;

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


import com.bydan.erp.tesoreria.util.TesoreriaConstantesFunciones;
import com.bydan.erp.tesoreria.util.TesoreriaParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TesoreriaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.tesoreria.util.report.*;
import com.bydan.erp.tesoreria.business.entity.report.*;
import com.bydan.erp.tesoreria.util.TesoreriaSql;
import com.bydan.erp.tesoreria.util.TesoreriaSqlReporte;


@SuppressWarnings("unused")
final public class TesoreriaConstantesFunciones extends TesoreriaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Tesoreria";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Tesoreria"+TesoreriaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TesoreriaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TesoreriaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TesoreriaConstantesFunciones.SCHEMA+"_"+TesoreriaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TesoreriaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TesoreriaConstantesFunciones.SCHEMA+"_"+TesoreriaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TesoreriaConstantesFunciones.SCHEMA+"_"+TesoreriaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TesoreriaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TesoreriaConstantesFunciones.SCHEMA+"_"+TesoreriaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TesoreriaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TesoreriaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TesoreriaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TesoreriaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TesoreriaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TesoreriaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TesoreriaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TesoreriaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TesoreriaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TesoreriaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tesorerias";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tesoreria";
	public static final String SCLASSWEBTITULO_LOWER="Tesoreria";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Tesoreria";
	public static final String OBJECTNAME="tesoreria";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="tesoreria";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tesoreria from "+TesoreriaConstantesFunciones.SPERSISTENCENAME+" tesoreria";
	public static String QUERYSELECTNATIVE="select "+TesoreriaConstantesFunciones.SCHEMA+"."+TesoreriaConstantesFunciones.TABLENAME+".id,"+TesoreriaConstantesFunciones.SCHEMA+"."+TesoreriaConstantesFunciones.TABLENAME+".version_row,"+TesoreriaConstantesFunciones.SCHEMA+"."+TesoreriaConstantesFunciones.TABLENAME+".codigo from "+TesoreriaConstantesFunciones.SCHEMA+"."+TesoreriaConstantesFunciones.TABLENAME;//+" as "+TesoreriaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TesoreriaConstantesFuncionesAdditional tesoreriaConstantesFuncionesAdditional=null;
	
	public TesoreriaConstantesFuncionesAdditional getTesoreriaConstantesFuncionesAdditional() {
		return this.tesoreriaConstantesFuncionesAdditional;
	}
	
	public void setTesoreriaConstantesFuncionesAdditional(TesoreriaConstantesFuncionesAdditional tesoreriaConstantesFuncionesAdditional) {
		try {
			this.tesoreriaConstantesFuncionesAdditional=tesoreriaConstantesFuncionesAdditional;
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
	
	public static String getTesoreriaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TesoreriaConstantesFunciones.CODIGO)) {sLabelColumna=TesoreriaConstantesFunciones.LABEL_CODIGO;}
		
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
	
	
	
			
			
			
	
	public static String getTesoreriaDescripcion(Tesoreria tesoreria) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tesoreria !=null/* && tesoreria.getId()!=0*/) {
			sDescripcion=tesoreria.getcodigo();//tesoreriatesoreria.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTesoreriaDescripcionDetallado(Tesoreria tesoreria) {
		String sDescripcion="";
			
		sDescripcion+=TesoreriaConstantesFunciones.ID+"=";
		sDescripcion+=tesoreria.getId().toString()+",";
		sDescripcion+=TesoreriaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tesoreria.getVersionRow().toString()+",";
		sDescripcion+=TesoreriaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tesoreria.getcodigo()+",";
			
		return sDescripcion;
	}
	
	public static void setTesoreriaDescripcion(Tesoreria tesoreria,String sValor) throws Exception {			
		if(tesoreria !=null) {
			tesoreria.setcodigo(sValor);;//tesoreriatesoreria.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTesoreria(Tesoreria tesoreria,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tesoreria.setcodigo(tesoreria.getcodigo().trim());
	}
	
	public static void quitarEspaciosTesorerias(List<Tesoreria> tesorerias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Tesoreria tesoreria: tesorerias) {
			tesoreria.setcodigo(tesoreria.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTesoreria(Tesoreria tesoreria,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tesoreria.getConCambioAuxiliar()) {
			tesoreria.setIsDeleted(tesoreria.getIsDeletedAuxiliar());	
			tesoreria.setIsNew(tesoreria.getIsNewAuxiliar());	
			tesoreria.setIsChanged(tesoreria.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tesoreria.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tesoreria.setIsDeletedAuxiliar(false);	
			tesoreria.setIsNewAuxiliar(false);	
			tesoreria.setIsChangedAuxiliar(false);
			
			tesoreria.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTesorerias(List<Tesoreria> tesorerias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Tesoreria tesoreria : tesorerias) {
			if(conAsignarBase && tesoreria.getConCambioAuxiliar()) {
				tesoreria.setIsDeleted(tesoreria.getIsDeletedAuxiliar());	
				tesoreria.setIsNew(tesoreria.getIsNewAuxiliar());	
				tesoreria.setIsChanged(tesoreria.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tesoreria.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tesoreria.setIsDeletedAuxiliar(false);	
				tesoreria.setIsNewAuxiliar(false);	
				tesoreria.setIsChangedAuxiliar(false);
				
				tesoreria.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTesoreria(Tesoreria tesoreria,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTesorerias(List<Tesoreria> tesorerias,Boolean conEnteros) throws Exception  {
		
		for(Tesoreria tesoreria: tesorerias) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTesoreria(List<Tesoreria> tesorerias,Tesoreria tesoreriaAux) throws Exception  {
		TesoreriaConstantesFunciones.InicializarValoresTesoreria(tesoreriaAux,true);
		
		for(Tesoreria tesoreria: tesorerias) {
			if(tesoreria.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTesoreria(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TesoreriaConstantesFunciones.getArrayColumnasGlobalesTesoreria(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTesoreria(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTesoreria(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Tesoreria> tesorerias,Tesoreria tesoreria,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Tesoreria tesoreriaAux: tesorerias) {
			if(tesoreriaAux!=null && tesoreria!=null) {
				if((tesoreriaAux.getId()==null && tesoreria.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tesoreriaAux.getId()!=null && tesoreria.getId()!=null){
					if(tesoreriaAux.getId().equals(tesoreria.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTesoreria(List<Tesoreria> tesorerias) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Tesoreria tesoreria: tesorerias) {			
			if(tesoreria.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTesoreria() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTesoreria() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTesoreria() throws Exception  {
		return TesoreriaConstantesFunciones.getTiposSeleccionarTesoreria(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTesoreria(Boolean conFk) throws Exception  {
		return TesoreriaConstantesFunciones.getTiposSeleccionarTesoreria(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTesoreria(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TesoreriaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TesoreriaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTesoreria(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTesoreria(Tesoreria tesoreriaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTesoreria(List<Tesoreria> tesoreriasTemp) throws Exception {
		for(Tesoreria tesoreriaAux:tesoreriasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTesoreria(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTesoreria(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTesoreria(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TesoreriaConstantesFunciones.getClassesRelationshipsOfTesoreria(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTesoreria(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTesoreria(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TesoreriaConstantesFunciones.getClassesRelationshipsFromStringsOfTesoreria(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTesoreria(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Tesoreria tesoreria,List<Tesoreria> tesorerias,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Tesoreria tesoreriaEncontrado=null;
			
			for(Tesoreria tesoreriaLocal:tesorerias) {
				if(tesoreriaLocal.getId().equals(tesoreria.getId())) {
					tesoreriaEncontrado=tesoreriaLocal;
					
					tesoreriaLocal.setIsChanged(tesoreria.getIsChanged());
					tesoreriaLocal.setIsNew(tesoreria.getIsNew());
					tesoreriaLocal.setIsDeleted(tesoreria.getIsDeleted());
					
					tesoreriaLocal.setGeneralEntityOriginal(tesoreria.getGeneralEntityOriginal());
					
					tesoreriaLocal.setId(tesoreria.getId());	
					tesoreriaLocal.setVersionRow(tesoreria.getVersionRow());	
					tesoreriaLocal.setcodigo(tesoreria.getcodigo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tesoreria.getIsDeleted()) {
				if(!existe) {
					tesorerias.add(tesoreria);
				}
			} else {
				if(tesoreriaEncontrado!=null && permiteQuitar)  {
					tesorerias.remove(tesoreriaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Tesoreria tesoreria,List<Tesoreria> tesorerias) throws Exception {
		try	{			
			for(Tesoreria tesoreriaLocal:tesorerias) {
				if(tesoreriaLocal.getId().equals(tesoreria.getId())) {
					tesoreriaLocal.setIsSelected(tesoreria.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTesoreria(List<Tesoreria> tesoreriasAux) throws Exception {
		//this.tesoreriasAux=tesoreriasAux;
		
		for(Tesoreria tesoreriaAux:tesoreriasAux) {
			if(tesoreriaAux.getIsChanged()) {
				tesoreriaAux.setIsChanged(false);
			}		
			
			if(tesoreriaAux.getIsNew()) {
				tesoreriaAux.setIsNew(false);
			}	
			
			if(tesoreriaAux.getIsDeleted()) {
				tesoreriaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTesoreria(Tesoreria tesoreriaAux) throws Exception {
		//this.tesoreriaAux=tesoreriaAux;
		
			if(tesoreriaAux.getIsChanged()) {
				tesoreriaAux.setIsChanged(false);
			}		
			
			if(tesoreriaAux.getIsNew()) {
				tesoreriaAux.setIsNew(false);
			}	
			
			if(tesoreriaAux.getIsDeleted()) {
				tesoreriaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Tesoreria tesoreriaAsignar,Tesoreria tesoreria) throws Exception {
		tesoreriaAsignar.setId(tesoreria.getId());	
		tesoreriaAsignar.setVersionRow(tesoreria.getVersionRow());	
		tesoreriaAsignar.setcodigo(tesoreria.getcodigo());	
	}
	
	public static void inicializarTesoreria(Tesoreria tesoreria) throws Exception {
		try {
				tesoreria.setId(0L);	
					
				tesoreria.setcodigo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTesoreria(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TesoreriaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTesoreria(String sTipo,Row row,Workbook workbook,Tesoreria tesoreria,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tesoreria.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTesoreria=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTesoreria() {
		return this.sFinalQueryTesoreria;
	}
	
	public void setsFinalQueryTesoreria(String sFinalQueryTesoreria) {
		this.sFinalQueryTesoreria= sFinalQueryTesoreria;
	}
	
	public Border resaltarSeleccionarTesoreria=null;
	
	public Border setResaltarSeleccionarTesoreria(ParametroGeneralUsuario parametroGeneralUsuario/*TesoreriaBeanSwingJInternalFrame tesoreriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tesoreriaBeanSwingJInternalFrame.jTtoolBarTesoreria.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTesoreria= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTesoreria() {
		return this.resaltarSeleccionarTesoreria;
	}
	
	public void setResaltarSeleccionarTesoreria(Border borderResaltarSeleccionarTesoreria) {
		this.resaltarSeleccionarTesoreria= borderResaltarSeleccionarTesoreria;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTesoreria=null;
	public Boolean mostraridTesoreria=true;
	public Boolean activaridTesoreria=true;

	public Border resaltarcodigoTesoreria=null;
	public Boolean mostrarcodigoTesoreria=true;
	public Boolean activarcodigoTesoreria=true;

	
	

	public Border setResaltaridTesoreria(ParametroGeneralUsuario parametroGeneralUsuario/*TesoreriaBeanSwingJInternalFrame tesoreriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tesoreriaBeanSwingJInternalFrame.jTtoolBarTesoreria.setBorder(borderResaltar);
		
		this.resaltaridTesoreria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTesoreria() {
		return this.resaltaridTesoreria;
	}

	public void setResaltaridTesoreria(Border borderResaltar) {
		this.resaltaridTesoreria= borderResaltar;
	}

	public Boolean getMostraridTesoreria() {
		return this.mostraridTesoreria;
	}

	public void setMostraridTesoreria(Boolean mostraridTesoreria) {
		this.mostraridTesoreria= mostraridTesoreria;
	}

	public Boolean getActivaridTesoreria() {
		return this.activaridTesoreria;
	}

	public void setActivaridTesoreria(Boolean activaridTesoreria) {
		this.activaridTesoreria= activaridTesoreria;
	}

	public Border setResaltarcodigoTesoreria(ParametroGeneralUsuario parametroGeneralUsuario/*TesoreriaBeanSwingJInternalFrame tesoreriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tesoreriaBeanSwingJInternalFrame.jTtoolBarTesoreria.setBorder(borderResaltar);
		
		this.resaltarcodigoTesoreria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTesoreria() {
		return this.resaltarcodigoTesoreria;
	}

	public void setResaltarcodigoTesoreria(Border borderResaltar) {
		this.resaltarcodigoTesoreria= borderResaltar;
	}

	public Boolean getMostrarcodigoTesoreria() {
		return this.mostrarcodigoTesoreria;
	}

	public void setMostrarcodigoTesoreria(Boolean mostrarcodigoTesoreria) {
		this.mostrarcodigoTesoreria= mostrarcodigoTesoreria;
	}

	public Boolean getActivarcodigoTesoreria() {
		return this.activarcodigoTesoreria;
	}

	public void setActivarcodigoTesoreria(Boolean activarcodigoTesoreria) {
		this.activarcodigoTesoreria= activarcodigoTesoreria;
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
		
		
		this.setMostraridTesoreria(esInicial);
		this.setMostrarcodigoTesoreria(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TesoreriaConstantesFunciones.ID)) {
				this.setMostraridTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(TesoreriaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTesoreria(esAsigna);
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
		
		
		this.setActivaridTesoreria(esInicial);
		this.setActivarcodigoTesoreria(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TesoreriaConstantesFunciones.ID)) {
				this.setActivaridTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(TesoreriaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTesoreria(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TesoreriaBeanSwingJInternalFrame tesoreriaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTesoreria(esInicial);
		this.setResaltarcodigoTesoreria(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TesoreriaConstantesFunciones.ID)) {
				this.setResaltaridTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(TesoreriaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTesoreria(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TesoreriaBeanSwingJInternalFrame tesoreriaBeanSwingJInternalFrame*/)throws Exception {	
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