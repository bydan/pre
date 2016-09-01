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


import com.bydan.erp.nomina.util.NominaConstantesFunciones;
import com.bydan.erp.nomina.util.NominaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.NominaParameterGeneral;

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

import com.bydan.erp.nomina.util.report.*;
import com.bydan.erp.nomina.business.entity.report.*;
import com.bydan.erp.nomina.util.NominaSql;
import com.bydan.erp.nomina.util.NominaSqlReporte;


@SuppressWarnings("unused")
final public class NominaConstantesFunciones extends NominaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Nomina";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Nomina"+NominaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="NominaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="NominaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=NominaConstantesFunciones.SCHEMA+"_"+NominaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/NominaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=NominaConstantesFunciones.SCHEMA+"_"+NominaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=NominaConstantesFunciones.SCHEMA+"_"+NominaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/NominaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=NominaConstantesFunciones.SCHEMA+"_"+NominaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NominaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NominaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NominaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NominaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NominaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NominaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=NominaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+NominaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=NominaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+NominaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Nominas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Nomina";
	public static final String SCLASSWEBTITULO_LOWER="Nomina";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Nomina";
	public static final String OBJECTNAME="nomina";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="nomina";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select nomina from "+NominaConstantesFunciones.SPERSISTENCENAME+" nomina";
	public static String QUERYSELECTNATIVE="select "+NominaConstantesFunciones.SCHEMA+"."+NominaConstantesFunciones.TABLENAME+".id,"+NominaConstantesFunciones.SCHEMA+"."+NominaConstantesFunciones.TABLENAME+".version_row,"+NominaConstantesFunciones.SCHEMA+"."+NominaConstantesFunciones.TABLENAME+".codigo from "+NominaConstantesFunciones.SCHEMA+"."+NominaConstantesFunciones.TABLENAME;//+" as "+NominaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected NominaConstantesFuncionesAdditional nominaConstantesFuncionesAdditional=null;
	
	public NominaConstantesFuncionesAdditional getNominaConstantesFuncionesAdditional() {
		return this.nominaConstantesFuncionesAdditional;
	}
	
	public void setNominaConstantesFuncionesAdditional(NominaConstantesFuncionesAdditional nominaConstantesFuncionesAdditional) {
		try {
			this.nominaConstantesFuncionesAdditional=nominaConstantesFuncionesAdditional;
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
	
	public static String getNominaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(NominaConstantesFunciones.CODIGO)) {sLabelColumna=NominaConstantesFunciones.LABEL_CODIGO;}
		
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
	
	
	
			
			
			
	
	public static String getNominaDescripcion(Nomina nomina) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(nomina !=null/* && nomina.getId()!=0*/) {
			sDescripcion=nomina.getcodigo();//nominanomina.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getNominaDescripcionDetallado(Nomina nomina) {
		String sDescripcion="";
			
		sDescripcion+=NominaConstantesFunciones.ID+"=";
		sDescripcion+=nomina.getId().toString()+",";
		sDescripcion+=NominaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=nomina.getVersionRow().toString()+",";
		sDescripcion+=NominaConstantesFunciones.CODIGO+"=";
		sDescripcion+=nomina.getcodigo()+",";
			
		return sDescripcion;
	}
	
	public static void setNominaDescripcion(Nomina nomina,String sValor) throws Exception {			
		if(nomina !=null) {
			nomina.setcodigo(sValor);;//nominanomina.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosNomina(Nomina nomina,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		nomina.setcodigo(nomina.getcodigo().trim());
	}
	
	public static void quitarEspaciosNominas(List<Nomina> nominas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Nomina nomina: nominas) {
			nomina.setcodigo(nomina.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNomina(Nomina nomina,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && nomina.getConCambioAuxiliar()) {
			nomina.setIsDeleted(nomina.getIsDeletedAuxiliar());	
			nomina.setIsNew(nomina.getIsNewAuxiliar());	
			nomina.setIsChanged(nomina.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			nomina.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			nomina.setIsDeletedAuxiliar(false);	
			nomina.setIsNewAuxiliar(false);	
			nomina.setIsChangedAuxiliar(false);
			
			nomina.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNominas(List<Nomina> nominas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Nomina nomina : nominas) {
			if(conAsignarBase && nomina.getConCambioAuxiliar()) {
				nomina.setIsDeleted(nomina.getIsDeletedAuxiliar());	
				nomina.setIsNew(nomina.getIsNewAuxiliar());	
				nomina.setIsChanged(nomina.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				nomina.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				nomina.setIsDeletedAuxiliar(false);	
				nomina.setIsNewAuxiliar(false);	
				nomina.setIsChangedAuxiliar(false);
				
				nomina.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresNomina(Nomina nomina,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresNominas(List<Nomina> nominas,Boolean conEnteros) throws Exception  {
		
		for(Nomina nomina: nominas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaNomina(List<Nomina> nominas,Nomina nominaAux) throws Exception  {
		NominaConstantesFunciones.InicializarValoresNomina(nominaAux,true);
		
		for(Nomina nomina: nominas) {
			if(nomina.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNomina(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=NominaConstantesFunciones.getArrayColumnasGlobalesNomina(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesNomina(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoNomina(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Nomina> nominas,Nomina nomina,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Nomina nominaAux: nominas) {
			if(nominaAux!=null && nomina!=null) {
				if((nominaAux.getId()==null && nomina.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(nominaAux.getId()!=null && nomina.getId()!=null){
					if(nominaAux.getId().equals(nomina.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaNomina(List<Nomina> nominas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Nomina nomina: nominas) {			
			if(nomina.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaNomina() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasNomina() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNomina() throws Exception  {
		return NominaConstantesFunciones.getTiposSeleccionarNomina(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNomina(Boolean conFk) throws Exception  {
		return NominaConstantesFunciones.getTiposSeleccionarNomina(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNomina(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NominaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(NominaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesNomina(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesNomina(Nomina nominaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesNomina(List<Nomina> nominasTemp) throws Exception {
		for(Nomina nominaAux:nominasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfNomina(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfNomina(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfNomina(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return NominaConstantesFunciones.getClassesRelationshipsOfNomina(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNomina(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNomina(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return NominaConstantesFunciones.getClassesRelationshipsFromStringsOfNomina(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNomina(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Nomina nomina,List<Nomina> nominas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Nomina nominaEncontrado=null;
			
			for(Nomina nominaLocal:nominas) {
				if(nominaLocal.getId().equals(nomina.getId())) {
					nominaEncontrado=nominaLocal;
					
					nominaLocal.setIsChanged(nomina.getIsChanged());
					nominaLocal.setIsNew(nomina.getIsNew());
					nominaLocal.setIsDeleted(nomina.getIsDeleted());
					
					nominaLocal.setGeneralEntityOriginal(nomina.getGeneralEntityOriginal());
					
					nominaLocal.setId(nomina.getId());	
					nominaLocal.setVersionRow(nomina.getVersionRow());	
					nominaLocal.setcodigo(nomina.getcodigo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!nomina.getIsDeleted()) {
				if(!existe) {
					nominas.add(nomina);
				}
			} else {
				if(nominaEncontrado!=null && permiteQuitar)  {
					nominas.remove(nominaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Nomina nomina,List<Nomina> nominas) throws Exception {
		try	{			
			for(Nomina nominaLocal:nominas) {
				if(nominaLocal.getId().equals(nomina.getId())) {
					nominaLocal.setIsSelected(nomina.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesNomina(List<Nomina> nominasAux) throws Exception {
		//this.nominasAux=nominasAux;
		
		for(Nomina nominaAux:nominasAux) {
			if(nominaAux.getIsChanged()) {
				nominaAux.setIsChanged(false);
			}		
			
			if(nominaAux.getIsNew()) {
				nominaAux.setIsNew(false);
			}	
			
			if(nominaAux.getIsDeleted()) {
				nominaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesNomina(Nomina nominaAux) throws Exception {
		//this.nominaAux=nominaAux;
		
			if(nominaAux.getIsChanged()) {
				nominaAux.setIsChanged(false);
			}		
			
			if(nominaAux.getIsNew()) {
				nominaAux.setIsNew(false);
			}	
			
			if(nominaAux.getIsDeleted()) {
				nominaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Nomina nominaAsignar,Nomina nomina) throws Exception {
		nominaAsignar.setId(nomina.getId());	
		nominaAsignar.setVersionRow(nomina.getVersionRow());	
		nominaAsignar.setcodigo(nomina.getcodigo());	
	}
	
	public static void inicializarNomina(Nomina nomina) throws Exception {
		try {
				nomina.setId(0L);	
					
				nomina.setcodigo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderNomina(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(NominaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataNomina(String sTipo,Row row,Workbook workbook,Nomina nomina,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(nomina.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryNomina=Constantes.SFINALQUERY;
	
	public String getsFinalQueryNomina() {
		return this.sFinalQueryNomina;
	}
	
	public void setsFinalQueryNomina(String sFinalQueryNomina) {
		this.sFinalQueryNomina= sFinalQueryNomina;
	}
	
	public Border resaltarSeleccionarNomina=null;
	
	public Border setResaltarSeleccionarNomina(ParametroGeneralUsuario parametroGeneralUsuario/*NominaBeanSwingJInternalFrame nominaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//nominaBeanSwingJInternalFrame.jTtoolBarNomina.setBorder(borderResaltar);
		
		this.resaltarSeleccionarNomina= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarNomina() {
		return this.resaltarSeleccionarNomina;
	}
	
	public void setResaltarSeleccionarNomina(Border borderResaltarSeleccionarNomina) {
		this.resaltarSeleccionarNomina= borderResaltarSeleccionarNomina;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridNomina=null;
	public Boolean mostraridNomina=true;
	public Boolean activaridNomina=true;

	public Border resaltarcodigoNomina=null;
	public Boolean mostrarcodigoNomina=true;
	public Boolean activarcodigoNomina=true;

	
	

	public Border setResaltaridNomina(ParametroGeneralUsuario parametroGeneralUsuario/*NominaBeanSwingJInternalFrame nominaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//nominaBeanSwingJInternalFrame.jTtoolBarNomina.setBorder(borderResaltar);
		
		this.resaltaridNomina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridNomina() {
		return this.resaltaridNomina;
	}

	public void setResaltaridNomina(Border borderResaltar) {
		this.resaltaridNomina= borderResaltar;
	}

	public Boolean getMostraridNomina() {
		return this.mostraridNomina;
	}

	public void setMostraridNomina(Boolean mostraridNomina) {
		this.mostraridNomina= mostraridNomina;
	}

	public Boolean getActivaridNomina() {
		return this.activaridNomina;
	}

	public void setActivaridNomina(Boolean activaridNomina) {
		this.activaridNomina= activaridNomina;
	}

	public Border setResaltarcodigoNomina(ParametroGeneralUsuario parametroGeneralUsuario/*NominaBeanSwingJInternalFrame nominaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//nominaBeanSwingJInternalFrame.jTtoolBarNomina.setBorder(borderResaltar);
		
		this.resaltarcodigoNomina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoNomina() {
		return this.resaltarcodigoNomina;
	}

	public void setResaltarcodigoNomina(Border borderResaltar) {
		this.resaltarcodigoNomina= borderResaltar;
	}

	public Boolean getMostrarcodigoNomina() {
		return this.mostrarcodigoNomina;
	}

	public void setMostrarcodigoNomina(Boolean mostrarcodigoNomina) {
		this.mostrarcodigoNomina= mostrarcodigoNomina;
	}

	public Boolean getActivarcodigoNomina() {
		return this.activarcodigoNomina;
	}

	public void setActivarcodigoNomina(Boolean activarcodigoNomina) {
		this.activarcodigoNomina= activarcodigoNomina;
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
		
		
		this.setMostraridNomina(esInicial);
		this.setMostrarcodigoNomina(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NominaConstantesFunciones.ID)) {
				this.setMostraridNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(NominaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoNomina(esAsigna);
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
		
		
		this.setActivaridNomina(esInicial);
		this.setActivarcodigoNomina(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NominaConstantesFunciones.ID)) {
				this.setActivaridNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(NominaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoNomina(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,NominaBeanSwingJInternalFrame nominaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridNomina(esInicial);
		this.setResaltarcodigoNomina(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NominaConstantesFunciones.ID)) {
				this.setResaltaridNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(NominaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoNomina(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,NominaBeanSwingJInternalFrame nominaBeanSwingJInternalFrame*/)throws Exception {	
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