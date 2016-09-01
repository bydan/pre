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
package com.bydan.erp.comisiones.util;

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


import com.bydan.erp.comisiones.util.ComisionesConstantesFunciones;
import com.bydan.erp.comisiones.util.ComisionesParameterReturnGeneral;
//import com.bydan.erp.comisiones.util.ComisionesParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.comisiones.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.comisiones.business.dataaccess.*;
//import com.bydan.erp.comisiones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.comisiones.util.report.*;
import com.bydan.erp.comisiones.business.entity.report.*;
import com.bydan.erp.comisiones.util.ComisionesSql;
import com.bydan.erp.comisiones.util.ComisionesSqlReporte;


@SuppressWarnings("unused")
final public class ComisionesConstantesFunciones extends ComisionesConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Comisiones";
	public static final String SPATHOPCION="Comisiones";	
	public static final String SPATHMODULO="comisiones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Comisiones"+ComisionesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ComisionesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ComisionesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ComisionesConstantesFunciones.SCHEMA+"_"+ComisionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ComisionesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ComisionesConstantesFunciones.SCHEMA+"_"+ComisionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ComisionesConstantesFunciones.SCHEMA+"_"+ComisionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ComisionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ComisionesConstantesFunciones.SCHEMA+"_"+ComisionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComisionesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComisionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ComisionesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ComisionesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ComisionesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ComisionesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Comisioneses";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Comisiones";
	public static final String SCLASSWEBTITULO_LOWER="Comisiones";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Comisiones";
	public static final String OBJECTNAME="comisiones";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_COMISIONES;	
	public static final String TABLENAME="comisiones";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select comisiones from "+ComisionesConstantesFunciones.SPERSISTENCENAME+" comisiones";
	public static String QUERYSELECTNATIVE="select "+ComisionesConstantesFunciones.SCHEMA+"."+ComisionesConstantesFunciones.TABLENAME+".id,"+ComisionesConstantesFunciones.SCHEMA+"."+ComisionesConstantesFunciones.TABLENAME+".version_row,"+ComisionesConstantesFunciones.SCHEMA+"."+ComisionesConstantesFunciones.TABLENAME+".codigo from "+ComisionesConstantesFunciones.SCHEMA+"."+ComisionesConstantesFunciones.TABLENAME;//+" as "+ComisionesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ComisionesConstantesFuncionesAdditional comisionesConstantesFuncionesAdditional=null;
	
	public ComisionesConstantesFuncionesAdditional getComisionesConstantesFuncionesAdditional() {
		return this.comisionesConstantesFuncionesAdditional;
	}
	
	public void setComisionesConstantesFuncionesAdditional(ComisionesConstantesFuncionesAdditional comisionesConstantesFuncionesAdditional) {
		try {
			this.comisionesConstantesFuncionesAdditional=comisionesConstantesFuncionesAdditional;
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
	
	public static String getComisionesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ComisionesConstantesFunciones.CODIGO)) {sLabelColumna=ComisionesConstantesFunciones.LABEL_CODIGO;}
		
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
	
	
	
			
			
			
	
	public static String getComisionesDescripcion(Comisiones comisiones) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(comisiones !=null/* && comisiones.getId()!=0*/) {
			sDescripcion=comisiones.getcodigo();//comisionescomisiones.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getComisionesDescripcionDetallado(Comisiones comisiones) {
		String sDescripcion="";
			
		sDescripcion+=ComisionesConstantesFunciones.ID+"=";
		sDescripcion+=comisiones.getId().toString()+",";
		sDescripcion+=ComisionesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=comisiones.getVersionRow().toString()+",";
		sDescripcion+=ComisionesConstantesFunciones.CODIGO+"=";
		sDescripcion+=comisiones.getcodigo()+",";
			
		return sDescripcion;
	}
	
	public static void setComisionesDescripcion(Comisiones comisiones,String sValor) throws Exception {			
		if(comisiones !=null) {
			comisiones.setcodigo(sValor);;//comisionescomisiones.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosComisiones(Comisiones comisiones,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		comisiones.setcodigo(comisiones.getcodigo().trim());
	}
	
	public static void quitarEspaciosComisioness(List<Comisiones> comisioness,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Comisiones comisiones: comisioness) {
			comisiones.setcodigo(comisiones.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComisiones(Comisiones comisiones,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && comisiones.getConCambioAuxiliar()) {
			comisiones.setIsDeleted(comisiones.getIsDeletedAuxiliar());	
			comisiones.setIsNew(comisiones.getIsNewAuxiliar());	
			comisiones.setIsChanged(comisiones.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			comisiones.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			comisiones.setIsDeletedAuxiliar(false);	
			comisiones.setIsNewAuxiliar(false);	
			comisiones.setIsChangedAuxiliar(false);
			
			comisiones.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComisioness(List<Comisiones> comisioness,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Comisiones comisiones : comisioness) {
			if(conAsignarBase && comisiones.getConCambioAuxiliar()) {
				comisiones.setIsDeleted(comisiones.getIsDeletedAuxiliar());	
				comisiones.setIsNew(comisiones.getIsNewAuxiliar());	
				comisiones.setIsChanged(comisiones.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				comisiones.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				comisiones.setIsDeletedAuxiliar(false);	
				comisiones.setIsNewAuxiliar(false);	
				comisiones.setIsChangedAuxiliar(false);
				
				comisiones.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresComisiones(Comisiones comisiones,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresComisioness(List<Comisiones> comisioness,Boolean conEnteros) throws Exception  {
		
		for(Comisiones comisiones: comisioness) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaComisiones(List<Comisiones> comisioness,Comisiones comisionesAux) throws Exception  {
		ComisionesConstantesFunciones.InicializarValoresComisiones(comisionesAux,true);
		
		for(Comisiones comisiones: comisioness) {
			if(comisiones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesComisiones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ComisionesConstantesFunciones.getArrayColumnasGlobalesComisiones(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesComisiones(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoComisiones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Comisiones> comisioness,Comisiones comisiones,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Comisiones comisionesAux: comisioness) {
			if(comisionesAux!=null && comisiones!=null) {
				if((comisionesAux.getId()==null && comisiones.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(comisionesAux.getId()!=null && comisiones.getId()!=null){
					if(comisionesAux.getId().equals(comisiones.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaComisiones(List<Comisiones> comisioness) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Comisiones comisiones: comisioness) {			
			if(comisiones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaComisiones() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasComisiones() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisiones() throws Exception  {
		return ComisionesConstantesFunciones.getTiposSeleccionarComisiones(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisiones(Boolean conFk) throws Exception  {
		return ComisionesConstantesFunciones.getTiposSeleccionarComisiones(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisiones(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionesConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ComisionesConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesComisiones(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesComisiones(Comisiones comisionesAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesComisiones(List<Comisiones> comisionessTemp) throws Exception {
		for(Comisiones comisionesAux:comisionessTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfComisiones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfComisiones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisiones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComisionesConstantesFunciones.getClassesRelationshipsOfComisiones(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisiones(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComisiones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComisionesConstantesFunciones.getClassesRelationshipsFromStringsOfComisiones(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComisiones(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Comisiones comisiones,List<Comisiones> comisioness,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Comisiones comisionesEncontrado=null;
			
			for(Comisiones comisionesLocal:comisioness) {
				if(comisionesLocal.getId().equals(comisiones.getId())) {
					comisionesEncontrado=comisionesLocal;
					
					comisionesLocal.setIsChanged(comisiones.getIsChanged());
					comisionesLocal.setIsNew(comisiones.getIsNew());
					comisionesLocal.setIsDeleted(comisiones.getIsDeleted());
					
					comisionesLocal.setGeneralEntityOriginal(comisiones.getGeneralEntityOriginal());
					
					comisionesLocal.setId(comisiones.getId());	
					comisionesLocal.setVersionRow(comisiones.getVersionRow());	
					comisionesLocal.setcodigo(comisiones.getcodigo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!comisiones.getIsDeleted()) {
				if(!existe) {
					comisioness.add(comisiones);
				}
			} else {
				if(comisionesEncontrado!=null && permiteQuitar)  {
					comisioness.remove(comisionesEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Comisiones comisiones,List<Comisiones> comisioness) throws Exception {
		try	{			
			for(Comisiones comisionesLocal:comisioness) {
				if(comisionesLocal.getId().equals(comisiones.getId())) {
					comisionesLocal.setIsSelected(comisiones.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesComisiones(List<Comisiones> comisionessAux) throws Exception {
		//this.comisionessAux=comisionessAux;
		
		for(Comisiones comisionesAux:comisionessAux) {
			if(comisionesAux.getIsChanged()) {
				comisionesAux.setIsChanged(false);
			}		
			
			if(comisionesAux.getIsNew()) {
				comisionesAux.setIsNew(false);
			}	
			
			if(comisionesAux.getIsDeleted()) {
				comisionesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesComisiones(Comisiones comisionesAux) throws Exception {
		//this.comisionesAux=comisionesAux;
		
			if(comisionesAux.getIsChanged()) {
				comisionesAux.setIsChanged(false);
			}		
			
			if(comisionesAux.getIsNew()) {
				comisionesAux.setIsNew(false);
			}	
			
			if(comisionesAux.getIsDeleted()) {
				comisionesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Comisiones comisionesAsignar,Comisiones comisiones) throws Exception {
		comisionesAsignar.setId(comisiones.getId());	
		comisionesAsignar.setVersionRow(comisiones.getVersionRow());	
		comisionesAsignar.setcodigo(comisiones.getcodigo());	
	}
	
	public static void inicializarComisiones(Comisiones comisiones) throws Exception {
		try {
				comisiones.setId(0L);	
					
				comisiones.setcodigo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderComisiones(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionesConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataComisiones(String sTipo,Row row,Workbook workbook,Comisiones comisiones,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(comisiones.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryComisiones=Constantes.SFINALQUERY;
	
	public String getsFinalQueryComisiones() {
		return this.sFinalQueryComisiones;
	}
	
	public void setsFinalQueryComisiones(String sFinalQueryComisiones) {
		this.sFinalQueryComisiones= sFinalQueryComisiones;
	}
	
	public Border resaltarSeleccionarComisiones=null;
	
	public Border setResaltarSeleccionarComisiones(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionesBeanSwingJInternalFrame comisionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//comisionesBeanSwingJInternalFrame.jTtoolBarComisiones.setBorder(borderResaltar);
		
		this.resaltarSeleccionarComisiones= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarComisiones() {
		return this.resaltarSeleccionarComisiones;
	}
	
	public void setResaltarSeleccionarComisiones(Border borderResaltarSeleccionarComisiones) {
		this.resaltarSeleccionarComisiones= borderResaltarSeleccionarComisiones;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridComisiones=null;
	public Boolean mostraridComisiones=true;
	public Boolean activaridComisiones=true;

	public Border resaltarcodigoComisiones=null;
	public Boolean mostrarcodigoComisiones=true;
	public Boolean activarcodigoComisiones=true;

	
	

	public Border setResaltaridComisiones(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionesBeanSwingJInternalFrame comisionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionesBeanSwingJInternalFrame.jTtoolBarComisiones.setBorder(borderResaltar);
		
		this.resaltaridComisiones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridComisiones() {
		return this.resaltaridComisiones;
	}

	public void setResaltaridComisiones(Border borderResaltar) {
		this.resaltaridComisiones= borderResaltar;
	}

	public Boolean getMostraridComisiones() {
		return this.mostraridComisiones;
	}

	public void setMostraridComisiones(Boolean mostraridComisiones) {
		this.mostraridComisiones= mostraridComisiones;
	}

	public Boolean getActivaridComisiones() {
		return this.activaridComisiones;
	}

	public void setActivaridComisiones(Boolean activaridComisiones) {
		this.activaridComisiones= activaridComisiones;
	}

	public Border setResaltarcodigoComisiones(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionesBeanSwingJInternalFrame comisionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionesBeanSwingJInternalFrame.jTtoolBarComisiones.setBorder(borderResaltar);
		
		this.resaltarcodigoComisiones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoComisiones() {
		return this.resaltarcodigoComisiones;
	}

	public void setResaltarcodigoComisiones(Border borderResaltar) {
		this.resaltarcodigoComisiones= borderResaltar;
	}

	public Boolean getMostrarcodigoComisiones() {
		return this.mostrarcodigoComisiones;
	}

	public void setMostrarcodigoComisiones(Boolean mostrarcodigoComisiones) {
		this.mostrarcodigoComisiones= mostrarcodigoComisiones;
	}

	public Boolean getActivarcodigoComisiones() {
		return this.activarcodigoComisiones;
	}

	public void setActivarcodigoComisiones(Boolean activarcodigoComisiones) {
		this.activarcodigoComisiones= activarcodigoComisiones;
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
		
		
		this.setMostraridComisiones(esInicial);
		this.setMostrarcodigoComisiones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionesConstantesFunciones.ID)) {
				this.setMostraridComisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionesConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoComisiones(esAsigna);
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
		
		
		this.setActivaridComisiones(esInicial);
		this.setActivarcodigoComisiones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionesConstantesFunciones.ID)) {
				this.setActivaridComisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionesConstantesFunciones.CODIGO)) {
				this.setActivarcodigoComisiones(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ComisionesBeanSwingJInternalFrame comisionesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridComisiones(esInicial);
		this.setResaltarcodigoComisiones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionesConstantesFunciones.ID)) {
				this.setResaltaridComisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionesConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoComisiones(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ComisionesBeanSwingJInternalFrame comisionesBeanSwingJInternalFrame*/)throws Exception {	
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