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


import com.bydan.erp.seguridad.util.AnioConstantesFunciones;
import com.bydan.erp.seguridad.util.AnioParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.AnioParameterGeneral;

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



@SuppressWarnings("unused")
final public class AnioConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="Anio";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Anio"+AnioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AnioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AnioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AnioConstantesFunciones.SCHEMA+"_"+AnioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AnioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AnioConstantesFunciones.SCHEMA+"_"+AnioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AnioConstantesFunciones.SCHEMA+"_"+AnioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AnioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AnioConstantesFunciones.SCHEMA+"_"+AnioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AnioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AnioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AnioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AnioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AnioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AnioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AnioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AnioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AnioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AnioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Anios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Anio";
	public static final String SCLASSWEBTITULO_LOWER="Anio";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Anio";
	public static final String OBJECTNAME="anio";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="anio";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select anio from "+AnioConstantesFunciones.SPERSISTENCENAME+" anio";
	public static String QUERYSELECTNATIVE="select "+AnioConstantesFunciones.SCHEMA+"."+AnioConstantesFunciones.TABLENAME+".id,"+AnioConstantesFunciones.SCHEMA+"."+AnioConstantesFunciones.TABLENAME+".version_row,"+AnioConstantesFunciones.SCHEMA+"."+AnioConstantesFunciones.TABLENAME+".nombre,"+AnioConstantesFunciones.SCHEMA+"."+AnioConstantesFunciones.TABLENAME+".valor from "+AnioConstantesFunciones.SCHEMA+"."+AnioConstantesFunciones.TABLENAME;//+" as "+AnioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NOMBRE= "nombre";
    public static final String VALOR= "valor";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
	
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getAnioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AnioConstantesFunciones.NOMBRE)) {sLabelColumna=AnioConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(AnioConstantesFunciones.VALOR)) {sLabelColumna=AnioConstantesFunciones.LABEL_VALOR;}
		
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
	
	
	
			
			
			
			
	
	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(anio !=null/* && anio.getId()!=0*/) {
			sDescripcion=anio.getnombre();//anioanio.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getAnioDescripcionDetallado(Anio anio) {
		String sDescripcion="";
			
		sDescripcion+=AnioConstantesFunciones.ID+"=";
		sDescripcion+=anio.getId().toString()+",";
		sDescripcion+=AnioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=anio.getVersionRow().toString()+",";
		sDescripcion+=AnioConstantesFunciones.NOMBRE+"=";
		sDescripcion+=anio.getnombre()+",";
		sDescripcion+=AnioConstantesFunciones.VALOR+"=";
		sDescripcion+=anio.getvalor().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setAnioDescripcion(Anio anio,String sValor) throws Exception {			
		if(anio !=null) {
			anio.setnombre(sValor);;//anioanio.getnombre().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("PorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndicePorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosAnio(Anio anio,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		anio.setnombre(anio.getnombre().trim());
	}
	
	public static void quitarEspaciosAnios(List<Anio> anios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Anio anio: anios) {
			anio.setnombre(anio.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAnio(Anio anio,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && anio.getConCambioAuxiliar()) {
			anio.setIsDeleted(anio.getIsDeletedAuxiliar());	
			anio.setIsNew(anio.getIsNewAuxiliar());	
			anio.setIsChanged(anio.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			anio.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			anio.setIsDeletedAuxiliar(false);	
			anio.setIsNewAuxiliar(false);	
			anio.setIsChangedAuxiliar(false);
			
			anio.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAnios(List<Anio> anios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Anio anio : anios) {
			if(conAsignarBase && anio.getConCambioAuxiliar()) {
				anio.setIsDeleted(anio.getIsDeletedAuxiliar());	
				anio.setIsNew(anio.getIsNewAuxiliar());	
				anio.setIsChanged(anio.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				anio.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				anio.setIsDeletedAuxiliar(false);	
				anio.setIsNewAuxiliar(false);	
				anio.setIsChangedAuxiliar(false);
				
				anio.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAnio(Anio anio,Boolean conEnteros) throws Exception  {
		anio.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresAnios(List<Anio> anios,Boolean conEnteros) throws Exception  {
		
		for(Anio anio: anios) {
			anio.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaAnio(List<Anio> anios,Anio anioAux) throws Exception  {
		AnioConstantesFunciones.InicializarValoresAnio(anioAux,true);
		
		for(Anio anio: anios) {
			if(anio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			anioAux.setvalor(anioAux.getvalor()+anio.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAnio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AnioConstantesFunciones.getArrayColumnasGlobalesAnio(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAnio(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAnio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Anio> anios,Anio anio,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Anio anioAux: anios) {
			if(anioAux!=null && anio!=null) {
				if((anioAux.getId()==null && anio.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(anioAux.getId()!=null && anio.getId()!=null){
					if(anioAux.getId().equals(anio.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAnio(List<Anio> anios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(Anio anio: anios) {			
			if(anio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=anio.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AnioConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(AnioConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAnio() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AnioConstantesFunciones.LABEL_ID, AnioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnioConstantesFunciones.LABEL_VERSIONROW, AnioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnioConstantesFunciones.LABEL_NOMBRE, AnioConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnioConstantesFunciones.LABEL_VALOR, AnioConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAnio() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AnioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnioConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnioConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAnio() throws Exception  {
		return AnioConstantesFunciones.getTiposSeleccionarAnio(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAnio(Boolean conFk) throws Exception  {
		return AnioConstantesFunciones.getTiposSeleccionarAnio(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAnio(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnioConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(AnioConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnioConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(AnioConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAnio(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAnio(Anio anioAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesAnio(List<Anio> aniosTemp) throws Exception {
		for(Anio anioAux:aniosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAnio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAnio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfAnio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AnioConstantesFunciones.getClassesRelationshipsOfAnio(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAnio(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAnio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AnioConstantesFunciones.getClassesRelationshipsFromStringsOfAnio(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAnio(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Anio anio,List<Anio> anios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Anio anioEncontrado=null;
			
			for(Anio anioLocal:anios) {
				if(anioLocal.getId().equals(anio.getId())) {
					anioEncontrado=anioLocal;
					
					anioLocal.setIsChanged(anio.getIsChanged());
					anioLocal.setIsNew(anio.getIsNew());
					anioLocal.setIsDeleted(anio.getIsDeleted());
					
					anioLocal.setGeneralEntityOriginal(anio.getGeneralEntityOriginal());
					
					anioLocal.setId(anio.getId());	
					anioLocal.setVersionRow(anio.getVersionRow());	
					anioLocal.setnombre(anio.getnombre());	
					anioLocal.setvalor(anio.getvalor());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!anio.getIsDeleted()) {
				if(!existe) {
					anios.add(anio);
				}
			} else {
				if(anioEncontrado!=null && permiteQuitar)  {
					anios.remove(anioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Anio anio,List<Anio> anios) throws Exception {
		try	{			
			for(Anio anioLocal:anios) {
				if(anioLocal.getId().equals(anio.getId())) {
					anioLocal.setIsSelected(anio.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAnio(List<Anio> aniosAux) throws Exception {
		//this.aniosAux=aniosAux;
		
		for(Anio anioAux:aniosAux) {
			if(anioAux.getIsChanged()) {
				anioAux.setIsChanged(false);
			}		
			
			if(anioAux.getIsNew()) {
				anioAux.setIsNew(false);
			}	
			
			if(anioAux.getIsDeleted()) {
				anioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAnio(Anio anioAux) throws Exception {
		//this.anioAux=anioAux;
		
			if(anioAux.getIsChanged()) {
				anioAux.setIsChanged(false);
			}		
			
			if(anioAux.getIsNew()) {
				anioAux.setIsNew(false);
			}	
			
			if(anioAux.getIsDeleted()) {
				anioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Anio anioAsignar,Anio anio) throws Exception {
		anioAsignar.setId(anio.getId());	
		anioAsignar.setVersionRow(anio.getVersionRow());	
		anioAsignar.setnombre(anio.getnombre());	
		anioAsignar.setvalor(anio.getvalor());	
	}
	
	public static void inicializarAnio(Anio anio) throws Exception {
		try {
				anio.setId(0L);	
					
				anio.setnombre("");	
				anio.setvalor(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAnio(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AnioConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnioConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAnio(String sTipo,Row row,Workbook workbook,Anio anio,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(anio.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anio.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAnio=Constantes.SFINALQUERY;
	
	public String getsFinalQueryAnio() {
		return this.sFinalQueryAnio;
	}
	
	public void setsFinalQueryAnio(String sFinalQueryAnio) {
		this.sFinalQueryAnio= sFinalQueryAnio;
	}
	
	public Border resaltarSeleccionarAnio=null;
	
	public Border setResaltarSeleccionarAnio(ParametroGeneralUsuario parametroGeneralUsuario/*AnioBeanSwingJInternalFrame anioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//anioBeanSwingJInternalFrame.jTtoolBarAnio.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAnio= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAnio() {
		return this.resaltarSeleccionarAnio;
	}
	
	public void setResaltarSeleccionarAnio(Border borderResaltarSeleccionarAnio) {
		this.resaltarSeleccionarAnio= borderResaltarSeleccionarAnio;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAnio=null;
	public Boolean mostraridAnio=true;
	public Boolean activaridAnio=true;

	public Border resaltarnombreAnio=null;
	public Boolean mostrarnombreAnio=true;
	public Boolean activarnombreAnio=true;

	public Border resaltarvalorAnio=null;
	public Boolean mostrarvalorAnio=true;
	public Boolean activarvalorAnio=true;

	
	

	public Border setResaltaridAnio(ParametroGeneralUsuario parametroGeneralUsuario/*AnioBeanSwingJInternalFrame anioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anioBeanSwingJInternalFrame.jTtoolBarAnio.setBorder(borderResaltar);
		
		this.resaltaridAnio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAnio() {
		return this.resaltaridAnio;
	}

	public void setResaltaridAnio(Border borderResaltar) {
		this.resaltaridAnio= borderResaltar;
	}

	public Boolean getMostraridAnio() {
		return this.mostraridAnio;
	}

	public void setMostraridAnio(Boolean mostraridAnio) {
		this.mostraridAnio= mostraridAnio;
	}

	public Boolean getActivaridAnio() {
		return this.activaridAnio;
	}

	public void setActivaridAnio(Boolean activaridAnio) {
		this.activaridAnio= activaridAnio;
	}

	public Border setResaltarnombreAnio(ParametroGeneralUsuario parametroGeneralUsuario/*AnioBeanSwingJInternalFrame anioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anioBeanSwingJInternalFrame.jTtoolBarAnio.setBorder(borderResaltar);
		
		this.resaltarnombreAnio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreAnio() {
		return this.resaltarnombreAnio;
	}

	public void setResaltarnombreAnio(Border borderResaltar) {
		this.resaltarnombreAnio= borderResaltar;
	}

	public Boolean getMostrarnombreAnio() {
		return this.mostrarnombreAnio;
	}

	public void setMostrarnombreAnio(Boolean mostrarnombreAnio) {
		this.mostrarnombreAnio= mostrarnombreAnio;
	}

	public Boolean getActivarnombreAnio() {
		return this.activarnombreAnio;
	}

	public void setActivarnombreAnio(Boolean activarnombreAnio) {
		this.activarnombreAnio= activarnombreAnio;
	}

	public Border setResaltarvalorAnio(ParametroGeneralUsuario parametroGeneralUsuario/*AnioBeanSwingJInternalFrame anioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anioBeanSwingJInternalFrame.jTtoolBarAnio.setBorder(borderResaltar);
		
		this.resaltarvalorAnio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorAnio() {
		return this.resaltarvalorAnio;
	}

	public void setResaltarvalorAnio(Border borderResaltar) {
		this.resaltarvalorAnio= borderResaltar;
	}

	public Boolean getMostrarvalorAnio() {
		return this.mostrarvalorAnio;
	}

	public void setMostrarvalorAnio(Boolean mostrarvalorAnio) {
		this.mostrarvalorAnio= mostrarvalorAnio;
	}

	public Boolean getActivarvalorAnio() {
		return this.activarvalorAnio;
	}

	public void setActivarvalorAnio(Boolean activarvalorAnio) {
		this.activarvalorAnio= activarvalorAnio;
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
		
		
		this.setMostraridAnio(esInicial);
		this.setMostrarnombreAnio(esInicial);
		this.setMostrarvalorAnio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AnioConstantesFunciones.ID)) {
				this.setMostraridAnio(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnioConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreAnio(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnioConstantesFunciones.VALOR)) {
				this.setMostrarvalorAnio(esAsigna);
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
		
		
		this.setActivaridAnio(esInicial);
		this.setActivarnombreAnio(esInicial);
		this.setActivarvalorAnio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AnioConstantesFunciones.ID)) {
				this.setActivaridAnio(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnioConstantesFunciones.NOMBRE)) {
				this.setActivarnombreAnio(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnioConstantesFunciones.VALOR)) {
				this.setActivarvalorAnio(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AnioBeanSwingJInternalFrame anioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAnio(esInicial);
		this.setResaltarnombreAnio(esInicial);
		this.setResaltarvalorAnio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AnioConstantesFunciones.ID)) {
				this.setResaltaridAnio(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnioConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreAnio(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnioConstantesFunciones.VALOR)) {
				this.setResaltarvalorAnio(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AnioBeanSwingJInternalFrame anioBeanSwingJInternalFrame*/)throws Exception {	
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