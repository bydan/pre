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


import com.bydan.erp.seguridad.util.DiaConstantesFunciones;
import com.bydan.erp.seguridad.util.DiaParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.DiaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;



import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DiaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="Dia";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Dia"+DiaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DiaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DiaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DiaConstantesFunciones.SCHEMA+"_"+DiaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DiaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DiaConstantesFunciones.SCHEMA+"_"+DiaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DiaConstantesFunciones.SCHEMA+"_"+DiaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DiaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DiaConstantesFunciones.SCHEMA+"_"+DiaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DiaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DiaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DiaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DiaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DiaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DiaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DiaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DiaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DiaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DiaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Dias";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Dia";
	public static final String SCLASSWEBTITULO_LOWER="Dia";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Dia";
	public static final String OBJECTNAME="dia";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="dia";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select dia from "+DiaConstantesFunciones.SPERSISTENCENAME+" dia";
	public static String QUERYSELECTNATIVE="select "+DiaConstantesFunciones.SCHEMA+"."+DiaConstantesFunciones.TABLENAME+".id,"+DiaConstantesFunciones.SCHEMA+"."+DiaConstantesFunciones.TABLENAME+".version_row,"+DiaConstantesFunciones.SCHEMA+"."+DiaConstantesFunciones.TABLENAME+".nombre from "+DiaConstantesFunciones.SCHEMA+"."+DiaConstantesFunciones.TABLENAME;//+" as "+DiaConstantesFunciones.TABLENAME;
	
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
	
	public static String getDiaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DiaConstantesFunciones.NOMBRE)) {sLabelColumna=DiaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getDiaDescripcion(Dia dia) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(dia !=null/* && dia.getId()!=0*/) {
			sDescripcion=dia.getnombre();//diadia.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getDiaDescripcionDetallado(Dia dia) {
		String sDescripcion="";
			
		sDescripcion+=DiaConstantesFunciones.ID+"=";
		sDescripcion+=dia.getId().toString()+",";
		sDescripcion+=DiaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=dia.getVersionRow().toString()+",";
		sDescripcion+=DiaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=dia.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setDiaDescripcion(Dia dia,String sValor) throws Exception {			
		if(dia !=null) {
			dia.setnombre(sValor);;//diadia.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosDia(Dia dia,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		dia.setnombre(dia.getnombre().trim());
	}
	
	public static void quitarEspaciosDias(List<Dia> dias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Dia dia: dias) {
			dia.setnombre(dia.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDia(Dia dia,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && dia.getConCambioAuxiliar()) {
			dia.setIsDeleted(dia.getIsDeletedAuxiliar());	
			dia.setIsNew(dia.getIsNewAuxiliar());	
			dia.setIsChanged(dia.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			dia.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			dia.setIsDeletedAuxiliar(false);	
			dia.setIsNewAuxiliar(false);	
			dia.setIsChangedAuxiliar(false);
			
			dia.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDias(List<Dia> dias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Dia dia : dias) {
			if(conAsignarBase && dia.getConCambioAuxiliar()) {
				dia.setIsDeleted(dia.getIsDeletedAuxiliar());	
				dia.setIsNew(dia.getIsNewAuxiliar());	
				dia.setIsChanged(dia.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				dia.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				dia.setIsDeletedAuxiliar(false);	
				dia.setIsNewAuxiliar(false);	
				dia.setIsChangedAuxiliar(false);
				
				dia.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDia(Dia dia,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDias(List<Dia> dias,Boolean conEnteros) throws Exception  {
		
		for(Dia dia: dias) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDia(List<Dia> dias,Dia diaAux) throws Exception  {
		DiaConstantesFunciones.InicializarValoresDia(diaAux,true);
		
		for(Dia dia: dias) {
			if(dia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DiaConstantesFunciones.getArrayColumnasGlobalesDia(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDia(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Dia> dias,Dia dia,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Dia diaAux: dias) {
			if(diaAux!=null && dia!=null) {
				if((diaAux.getId()==null && dia.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(diaAux.getId()!=null && dia.getId()!=null){
					if(diaAux.getId().equals(dia.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDia(List<Dia> dias) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Dia dia: dias) {			
			if(dia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDia() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DiaConstantesFunciones.LABEL_ID, DiaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiaConstantesFunciones.LABEL_VERSIONROW, DiaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiaConstantesFunciones.LABEL_NOMBRE, DiaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDia() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DiaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDia() throws Exception  {
		return DiaConstantesFunciones.getTiposSeleccionarDia(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDia(Boolean conFk) throws Exception  {
		return DiaConstantesFunciones.getTiposSeleccionarDia(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDia(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(DiaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDia(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDia(Dia diaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesDia(List<Dia> diasTemp) throws Exception {
		for(Dia diaAux:diasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DiaConstantesFunciones.getClassesRelationshipsOfDia(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDia(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DiaConstantesFunciones.getClassesRelationshipsFromStringsOfDia(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDia(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Dia dia,List<Dia> dias,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Dia diaEncontrado=null;
			
			for(Dia diaLocal:dias) {
				if(diaLocal.getId().equals(dia.getId())) {
					diaEncontrado=diaLocal;
					
					diaLocal.setIsChanged(dia.getIsChanged());
					diaLocal.setIsNew(dia.getIsNew());
					diaLocal.setIsDeleted(dia.getIsDeleted());
					
					diaLocal.setGeneralEntityOriginal(dia.getGeneralEntityOriginal());
					
					diaLocal.setId(dia.getId());	
					diaLocal.setVersionRow(dia.getVersionRow());	
					diaLocal.setnombre(dia.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!dia.getIsDeleted()) {
				if(!existe) {
					dias.add(dia);
				}
			} else {
				if(diaEncontrado!=null && permiteQuitar)  {
					dias.remove(diaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Dia dia,List<Dia> dias) throws Exception {
		try	{			
			for(Dia diaLocal:dias) {
				if(diaLocal.getId().equals(dia.getId())) {
					diaLocal.setIsSelected(dia.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDia(List<Dia> diasAux) throws Exception {
		//this.diasAux=diasAux;
		
		for(Dia diaAux:diasAux) {
			if(diaAux.getIsChanged()) {
				diaAux.setIsChanged(false);
			}		
			
			if(diaAux.getIsNew()) {
				diaAux.setIsNew(false);
			}	
			
			if(diaAux.getIsDeleted()) {
				diaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDia(Dia diaAux) throws Exception {
		//this.diaAux=diaAux;
		
			if(diaAux.getIsChanged()) {
				diaAux.setIsChanged(false);
			}		
			
			if(diaAux.getIsNew()) {
				diaAux.setIsNew(false);
			}	
			
			if(diaAux.getIsDeleted()) {
				diaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Dia diaAsignar,Dia dia) throws Exception {
		diaAsignar.setId(dia.getId());	
		diaAsignar.setVersionRow(dia.getVersionRow());	
		diaAsignar.setnombre(dia.getnombre());	
	}
	
	public static void inicializarDia(Dia dia) throws Exception {
		try {
				dia.setId(0L);	
					
				dia.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDia(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DiaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDia(String sTipo,Row row,Workbook workbook,Dia dia,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(dia.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDia=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDia() {
		return this.sFinalQueryDia;
	}
	
	public void setsFinalQueryDia(String sFinalQueryDia) {
		this.sFinalQueryDia= sFinalQueryDia;
	}
	
	public Border resaltarSeleccionarDia=null;
	
	public Border setResaltarSeleccionarDia(ParametroGeneralUsuario parametroGeneralUsuario/*DiaBeanSwingJInternalFrame diaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//diaBeanSwingJInternalFrame.jTtoolBarDia.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDia= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDia() {
		return this.resaltarSeleccionarDia;
	}
	
	public void setResaltarSeleccionarDia(Border borderResaltarSeleccionarDia) {
		this.resaltarSeleccionarDia= borderResaltarSeleccionarDia;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDia=null;
	public Boolean mostraridDia=true;
	public Boolean activaridDia=true;

	public Border resaltarnombreDia=null;
	public Boolean mostrarnombreDia=true;
	public Boolean activarnombreDia=true;

	
	

	public Border setResaltaridDia(ParametroGeneralUsuario parametroGeneralUsuario/*DiaBeanSwingJInternalFrame diaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diaBeanSwingJInternalFrame.jTtoolBarDia.setBorder(borderResaltar);
		
		this.resaltaridDia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDia() {
		return this.resaltaridDia;
	}

	public void setResaltaridDia(Border borderResaltar) {
		this.resaltaridDia= borderResaltar;
	}

	public Boolean getMostraridDia() {
		return this.mostraridDia;
	}

	public void setMostraridDia(Boolean mostraridDia) {
		this.mostraridDia= mostraridDia;
	}

	public Boolean getActivaridDia() {
		return this.activaridDia;
	}

	public void setActivaridDia(Boolean activaridDia) {
		this.activaridDia= activaridDia;
	}

	public Border setResaltarnombreDia(ParametroGeneralUsuario parametroGeneralUsuario/*DiaBeanSwingJInternalFrame diaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diaBeanSwingJInternalFrame.jTtoolBarDia.setBorder(borderResaltar);
		
		this.resaltarnombreDia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreDia() {
		return this.resaltarnombreDia;
	}

	public void setResaltarnombreDia(Border borderResaltar) {
		this.resaltarnombreDia= borderResaltar;
	}

	public Boolean getMostrarnombreDia() {
		return this.mostrarnombreDia;
	}

	public void setMostrarnombreDia(Boolean mostrarnombreDia) {
		this.mostrarnombreDia= mostrarnombreDia;
	}

	public Boolean getActivarnombreDia() {
		return this.activarnombreDia;
	}

	public void setActivarnombreDia(Boolean activarnombreDia) {
		this.activarnombreDia= activarnombreDia;
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
		
		
		this.setMostraridDia(esInicial);
		this.setMostrarnombreDia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DiaConstantesFunciones.ID)) {
				this.setMostraridDia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreDia(esAsigna);
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
		
		
		this.setActivaridDia(esInicial);
		this.setActivarnombreDia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DiaConstantesFunciones.ID)) {
				this.setActivaridDia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreDia(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DiaBeanSwingJInternalFrame diaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDia(esInicial);
		this.setResaltarnombreDia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DiaConstantesFunciones.ID)) {
				this.setResaltaridDia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreDia(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DiaBeanSwingJInternalFrame diaBeanSwingJInternalFrame*/)throws Exception {	
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