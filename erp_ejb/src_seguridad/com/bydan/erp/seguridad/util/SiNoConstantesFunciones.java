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


import com.bydan.erp.seguridad.util.SiNoConstantesFunciones;
import com.bydan.erp.seguridad.util.SiNoParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.SiNoParameterGeneral;

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
final public class SiNoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="SiNo";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="SiNo"+SiNoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SiNoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SiNoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SiNoConstantesFunciones.SCHEMA+"_"+SiNoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SiNoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SiNoConstantesFunciones.SCHEMA+"_"+SiNoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SiNoConstantesFunciones.SCHEMA+"_"+SiNoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SiNoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SiNoConstantesFunciones.SCHEMA+"_"+SiNoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SiNoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SiNoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SiNoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SiNoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SiNoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SiNoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SiNoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SiNoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SiNoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SiNoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Si/no";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="";
	public static final String SCLASSWEBTITULO="Si/no";
	public static final String SCLASSWEBTITULO_LOWER="Si No";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="SiNo";
	public static final String OBJECTNAME="sino";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="sino";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select sino from "+SiNoConstantesFunciones.SPERSISTENCENAME+" sino";
	public static String QUERYSELECTNATIVE="select "+SiNoConstantesFunciones.SCHEMA+"."+SiNoConstantesFunciones.TABLENAME+".id,"+SiNoConstantesFunciones.SCHEMA+"."+SiNoConstantesFunciones.TABLENAME+".version_row,"+SiNoConstantesFunciones.SCHEMA+"."+SiNoConstantesFunciones.TABLENAME+".nombre from "+SiNoConstantesFunciones.SCHEMA+"."+SiNoConstantesFunciones.TABLENAME;//+" as "+SiNoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getSiNoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SiNoConstantesFunciones.NOMBRE)) {sLabelColumna=SiNoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getSiNoDescripcion(SiNo sino) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(sino !=null/* && sino.getId()!=0*/) {
			sDescripcion=sino.getnombre();//sinosino.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getSiNoDescripcionDetallado(SiNo sino) {
		String sDescripcion="";
			
		sDescripcion+=SiNoConstantesFunciones.ID+"=";
		sDescripcion+=sino.getId().toString()+",";
		sDescripcion+=SiNoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=sino.getVersionRow().toString()+",";
		sDescripcion+=SiNoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=sino.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setSiNoDescripcion(SiNo sino,String sValor) throws Exception {			
		if(sino !=null) {
			sino.setnombre(sValor);;//sinosino.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosSiNo(SiNo sino,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		sino.setnombre(sino.getnombre().trim());
	}
	
	public static void quitarEspaciosSiNos(List<SiNo> sinos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SiNo sino: sinos) {
			sino.setnombre(sino.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSiNo(SiNo sino,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && sino.getConCambioAuxiliar()) {
			sino.setIsDeleted(sino.getIsDeletedAuxiliar());	
			sino.setIsNew(sino.getIsNewAuxiliar());	
			sino.setIsChanged(sino.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			sino.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			sino.setIsDeletedAuxiliar(false);	
			sino.setIsNewAuxiliar(false);	
			sino.setIsChangedAuxiliar(false);
			
			sino.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSiNos(List<SiNo> sinos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(SiNo sino : sinos) {
			if(conAsignarBase && sino.getConCambioAuxiliar()) {
				sino.setIsDeleted(sino.getIsDeletedAuxiliar());	
				sino.setIsNew(sino.getIsNewAuxiliar());	
				sino.setIsChanged(sino.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				sino.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				sino.setIsDeletedAuxiliar(false);	
				sino.setIsNewAuxiliar(false);	
				sino.setIsChangedAuxiliar(false);
				
				sino.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSiNo(SiNo sino,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSiNos(List<SiNo> sinos,Boolean conEnteros) throws Exception  {
		
		for(SiNo sino: sinos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSiNo(List<SiNo> sinos,SiNo sinoAux) throws Exception  {
		SiNoConstantesFunciones.InicializarValoresSiNo(sinoAux,true);
		
		for(SiNo sino: sinos) {
			if(sino.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSiNo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SiNoConstantesFunciones.getArrayColumnasGlobalesSiNo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSiNo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSiNo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SiNo> sinos,SiNo sino,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SiNo sinoAux: sinos) {
			if(sinoAux!=null && sino!=null) {
				if((sinoAux.getId()==null && sino.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(sinoAux.getId()!=null && sino.getId()!=null){
					if(sinoAux.getId().equals(sino.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSiNo(List<SiNo> sinos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(SiNo sino: sinos) {			
			if(sino.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSiNo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SiNoConstantesFunciones.LABEL_ID, SiNoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SiNoConstantesFunciones.LABEL_VERSIONROW, SiNoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SiNoConstantesFunciones.LABEL_NOMBRE, SiNoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSiNo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SiNoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SiNoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SiNoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSiNo() throws Exception  {
		return SiNoConstantesFunciones.getTiposSeleccionarSiNo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSiNo(Boolean conFk) throws Exception  {
		return SiNoConstantesFunciones.getTiposSeleccionarSiNo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSiNo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SiNoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(SiNoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSiNo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSiNo(SiNo sinoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesSiNo(List<SiNo> sinosTemp) throws Exception {
		for(SiNo sinoAux:sinosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSiNo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSiNo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSiNo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SiNoConstantesFunciones.getClassesRelationshipsOfSiNo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSiNo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSiNo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SiNoConstantesFunciones.getClassesRelationshipsFromStringsOfSiNo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSiNo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(SiNo sino,List<SiNo> sinos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			SiNo sinoEncontrado=null;
			
			for(SiNo sinoLocal:sinos) {
				if(sinoLocal.getId().equals(sino.getId())) {
					sinoEncontrado=sinoLocal;
					
					sinoLocal.setIsChanged(sino.getIsChanged());
					sinoLocal.setIsNew(sino.getIsNew());
					sinoLocal.setIsDeleted(sino.getIsDeleted());
					
					sinoLocal.setGeneralEntityOriginal(sino.getGeneralEntityOriginal());
					
					sinoLocal.setId(sino.getId());	
					sinoLocal.setVersionRow(sino.getVersionRow());	
					sinoLocal.setnombre(sino.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!sino.getIsDeleted()) {
				if(!existe) {
					sinos.add(sino);
				}
			} else {
				if(sinoEncontrado!=null && permiteQuitar)  {
					sinos.remove(sinoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(SiNo sino,List<SiNo> sinos) throws Exception {
		try	{			
			for(SiNo sinoLocal:sinos) {
				if(sinoLocal.getId().equals(sino.getId())) {
					sinoLocal.setIsSelected(sino.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSiNo(List<SiNo> sinosAux) throws Exception {
		//this.sinosAux=sinosAux;
		
		for(SiNo sinoAux:sinosAux) {
			if(sinoAux.getIsChanged()) {
				sinoAux.setIsChanged(false);
			}		
			
			if(sinoAux.getIsNew()) {
				sinoAux.setIsNew(false);
			}	
			
			if(sinoAux.getIsDeleted()) {
				sinoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSiNo(SiNo sinoAux) throws Exception {
		//this.sinoAux=sinoAux;
		
			if(sinoAux.getIsChanged()) {
				sinoAux.setIsChanged(false);
			}		
			
			if(sinoAux.getIsNew()) {
				sinoAux.setIsNew(false);
			}	
			
			if(sinoAux.getIsDeleted()) {
				sinoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(SiNo sinoAsignar,SiNo sino) throws Exception {
		sinoAsignar.setId(sino.getId());	
		sinoAsignar.setVersionRow(sino.getVersionRow());	
		sinoAsignar.setnombre(sino.getnombre());	
	}
	
	public static void inicializarSiNo(SiNo sino) throws Exception {
		try {
				sino.setId(0L);	
					
				sino.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSiNo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SiNoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSiNo(String sTipo,Row row,Workbook workbook,SiNo sino,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(sino.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySiNo=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySiNo() {
		return this.sFinalQuerySiNo;
	}
	
	public void setsFinalQuerySiNo(String sFinalQuerySiNo) {
		this.sFinalQuerySiNo= sFinalQuerySiNo;
	}
	
	public Border resaltarSeleccionarSiNo=null;
	
	public Border setResaltarSeleccionarSiNo(ParametroGeneralUsuario parametroGeneralUsuario/*SiNoBeanSwingJInternalFrame sinoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//sinoBeanSwingJInternalFrame.jTtoolBarSiNo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSiNo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSiNo() {
		return this.resaltarSeleccionarSiNo;
	}
	
	public void setResaltarSeleccionarSiNo(Border borderResaltarSeleccionarSiNo) {
		this.resaltarSeleccionarSiNo= borderResaltarSeleccionarSiNo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSiNo=null;
	public Boolean mostraridSiNo=true;
	public Boolean activaridSiNo=true;

	public Border resaltarnombreSiNo=null;
	public Boolean mostrarnombreSiNo=true;
	public Boolean activarnombreSiNo=true;

	
	

	public Border setResaltaridSiNo(ParametroGeneralUsuario parametroGeneralUsuario/*SiNoBeanSwingJInternalFrame sinoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sinoBeanSwingJInternalFrame.jTtoolBarSiNo.setBorder(borderResaltar);
		
		this.resaltaridSiNo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSiNo() {
		return this.resaltaridSiNo;
	}

	public void setResaltaridSiNo(Border borderResaltar) {
		this.resaltaridSiNo= borderResaltar;
	}

	public Boolean getMostraridSiNo() {
		return this.mostraridSiNo;
	}

	public void setMostraridSiNo(Boolean mostraridSiNo) {
		this.mostraridSiNo= mostraridSiNo;
	}

	public Boolean getActivaridSiNo() {
		return this.activaridSiNo;
	}

	public void setActivaridSiNo(Boolean activaridSiNo) {
		this.activaridSiNo= activaridSiNo;
	}

	public Border setResaltarnombreSiNo(ParametroGeneralUsuario parametroGeneralUsuario/*SiNoBeanSwingJInternalFrame sinoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sinoBeanSwingJInternalFrame.jTtoolBarSiNo.setBorder(borderResaltar);
		
		this.resaltarnombreSiNo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreSiNo() {
		return this.resaltarnombreSiNo;
	}

	public void setResaltarnombreSiNo(Border borderResaltar) {
		this.resaltarnombreSiNo= borderResaltar;
	}

	public Boolean getMostrarnombreSiNo() {
		return this.mostrarnombreSiNo;
	}

	public void setMostrarnombreSiNo(Boolean mostrarnombreSiNo) {
		this.mostrarnombreSiNo= mostrarnombreSiNo;
	}

	public Boolean getActivarnombreSiNo() {
		return this.activarnombreSiNo;
	}

	public void setActivarnombreSiNo(Boolean activarnombreSiNo) {
		this.activarnombreSiNo= activarnombreSiNo;
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
		
		
		this.setMostraridSiNo(esInicial);
		this.setMostrarnombreSiNo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SiNoConstantesFunciones.ID)) {
				this.setMostraridSiNo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SiNoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreSiNo(esAsigna);
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
		
		
		this.setActivaridSiNo(esInicial);
		this.setActivarnombreSiNo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SiNoConstantesFunciones.ID)) {
				this.setActivaridSiNo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SiNoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreSiNo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SiNoBeanSwingJInternalFrame sinoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSiNo(esInicial);
		this.setResaltarnombreSiNo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SiNoConstantesFunciones.ID)) {
				this.setResaltaridSiNo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SiNoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreSiNo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SiNoBeanSwingJInternalFrame sinoBeanSwingJInternalFrame*/)throws Exception {	
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