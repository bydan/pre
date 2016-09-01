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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.TipoTransaConstantesFunciones;
import com.bydan.erp.cartera.util.TipoTransaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoTransaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.produccion.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.puntoventa.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoTransaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoTransa";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoTransa"+TipoTransaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoTransaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoTransaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoTransaConstantesFunciones.SCHEMA+"_"+TipoTransaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoTransaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoTransaConstantesFunciones.SCHEMA+"_"+TipoTransaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoTransaConstantesFunciones.SCHEMA+"_"+TipoTransaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoTransaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoTransaConstantesFunciones.SCHEMA+"_"+TipoTransaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTransaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoTransaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTransaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTransaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoTransaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTransaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoTransaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoTransaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoTransaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoTransaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Transas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Transa";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Transa";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoTransa";
	public static final String OBJECTNAME="tipotransa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_transa";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipotransa from "+TipoTransaConstantesFunciones.SPERSISTENCENAME+" tipotransa";
	public static String QUERYSELECTNATIVE="select "+TipoTransaConstantesFunciones.SCHEMA+"."+TipoTransaConstantesFunciones.TABLENAME+".id,"+TipoTransaConstantesFunciones.SCHEMA+"."+TipoTransaConstantesFunciones.TABLENAME+".version_row,"+TipoTransaConstantesFunciones.SCHEMA+"."+TipoTransaConstantesFunciones.TABLENAME+".nombre from "+TipoTransaConstantesFunciones.SCHEMA+"."+TipoTransaConstantesFunciones.TABLENAME;//+" as "+TipoTransaConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoTransaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoTransaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoTransaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getTipoTransaDescripcion(TipoTransa tipotransa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipotransa !=null/* && tipotransa.getId()!=0*/) {
			sDescripcion=tipotransa.getnombre();//tipotransatipotransa.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoTransaDescripcionDetallado(TipoTransa tipotransa) {
		String sDescripcion="";
			
		sDescripcion+=TipoTransaConstantesFunciones.ID+"=";
		sDescripcion+=tipotransa.getId().toString()+",";
		sDescripcion+=TipoTransaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipotransa.getVersionRow().toString()+",";
		sDescripcion+=TipoTransaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipotransa.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoTransaDescripcion(TipoTransa tipotransa,String sValor) throws Exception {			
		if(tipotransa !=null) {
			tipotransa.setnombre(sValor);//tipotransatipotransa.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoTransa(TipoTransa tipotransa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipotransa.setnombre(tipotransa.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoTransas(List<TipoTransa> tipotransas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoTransa tipotransa: tipotransas) {
			tipotransa.setnombre(tipotransa.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoTransa(TipoTransa tipotransa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipotransa.getConCambioAuxiliar()) {
			tipotransa.setIsDeleted(tipotransa.getIsDeletedAuxiliar());	
			tipotransa.setIsNew(tipotransa.getIsNewAuxiliar());	
			tipotransa.setIsChanged(tipotransa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipotransa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipotransa.setIsDeletedAuxiliar(false);	
			tipotransa.setIsNewAuxiliar(false);	
			tipotransa.setIsChangedAuxiliar(false);
			
			tipotransa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoTransas(List<TipoTransa> tipotransas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoTransa tipotransa : tipotransas) {
			if(conAsignarBase && tipotransa.getConCambioAuxiliar()) {
				tipotransa.setIsDeleted(tipotransa.getIsDeletedAuxiliar());	
				tipotransa.setIsNew(tipotransa.getIsNewAuxiliar());	
				tipotransa.setIsChanged(tipotransa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipotransa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipotransa.setIsDeletedAuxiliar(false);	
				tipotransa.setIsNewAuxiliar(false);	
				tipotransa.setIsChangedAuxiliar(false);
				
				tipotransa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoTransa(TipoTransa tipotransa,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoTransas(List<TipoTransa> tipotransas,Boolean conEnteros) throws Exception  {
		
		for(TipoTransa tipotransa: tipotransas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoTransa(List<TipoTransa> tipotransas,TipoTransa tipotransaAux) throws Exception  {
		TipoTransaConstantesFunciones.InicializarValoresTipoTransa(tipotransaAux,true);
		
		for(TipoTransa tipotransa: tipotransas) {
			if(tipotransa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoTransa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoTransaConstantesFunciones.getArrayColumnasGlobalesTipoTransa(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoTransa(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoTransa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoTransa> tipotransas,TipoTransa tipotransa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoTransa tipotransaAux: tipotransas) {
			if(tipotransaAux!=null && tipotransa!=null) {
				if((tipotransaAux.getId()==null && tipotransa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipotransaAux.getId()!=null && tipotransa.getId()!=null){
					if(tipotransaAux.getId().equals(tipotransa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoTransa(List<TipoTransa> tipotransas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoTransa tipotransa: tipotransas) {			
			if(tipotransa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoTransa() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoTransaConstantesFunciones.LABEL_ID, TipoTransaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTransaConstantesFunciones.LABEL_VERSIONROW, TipoTransaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTransaConstantesFunciones.LABEL_NOMBRE, TipoTransaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoTransa() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoTransaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTransaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTransaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTransa() throws Exception  {
		return TipoTransaConstantesFunciones.getTiposSeleccionarTipoTransa(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTransa(Boolean conFk) throws Exception  {
		return TipoTransaConstantesFunciones.getTiposSeleccionarTipoTransa(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTransa(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoTransaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoTransaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoTransa(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoTransa(TipoTransa tipotransaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoTransa(List<TipoTransa> tipotransasTemp) throws Exception {
		for(TipoTransa tipotransaAux:tipotransasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoTransa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoTransa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoTransa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoTransaConstantesFunciones.getClassesRelationshipsOfTipoTransa(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoTransa(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Transaccion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoTransa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoTransaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoTransa(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoTransa(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
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
	public static void actualizarLista(TipoTransa tipotransa,List<TipoTransa> tipotransas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoTransa tipotransaEncontrado=null;
			
			for(TipoTransa tipotransaLocal:tipotransas) {
				if(tipotransaLocal.getId().equals(tipotransa.getId())) {
					tipotransaEncontrado=tipotransaLocal;
					
					tipotransaLocal.setIsChanged(tipotransa.getIsChanged());
					tipotransaLocal.setIsNew(tipotransa.getIsNew());
					tipotransaLocal.setIsDeleted(tipotransa.getIsDeleted());
					
					tipotransaLocal.setGeneralEntityOriginal(tipotransa.getGeneralEntityOriginal());
					
					tipotransaLocal.setId(tipotransa.getId());	
					tipotransaLocal.setVersionRow(tipotransa.getVersionRow());	
					tipotransaLocal.setnombre(tipotransa.getnombre());	
					
					
					tipotransaLocal.setTransaccions(tipotransa.getTransaccions());
					
					existe=true;
					break;
				}
			}
			
			if(!tipotransa.getIsDeleted()) {
				if(!existe) {
					tipotransas.add(tipotransa);
				}
			} else {
				if(tipotransaEncontrado!=null && permiteQuitar)  {
					tipotransas.remove(tipotransaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoTransa tipotransa,List<TipoTransa> tipotransas) throws Exception {
		try	{			
			for(TipoTransa tipotransaLocal:tipotransas) {
				if(tipotransaLocal.getId().equals(tipotransa.getId())) {
					tipotransaLocal.setIsSelected(tipotransa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoTransa(List<TipoTransa> tipotransasAux) throws Exception {
		//this.tipotransasAux=tipotransasAux;
		
		for(TipoTransa tipotransaAux:tipotransasAux) {
			if(tipotransaAux.getIsChanged()) {
				tipotransaAux.setIsChanged(false);
			}		
			
			if(tipotransaAux.getIsNew()) {
				tipotransaAux.setIsNew(false);
			}	
			
			if(tipotransaAux.getIsDeleted()) {
				tipotransaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoTransa(TipoTransa tipotransaAux) throws Exception {
		//this.tipotransaAux=tipotransaAux;
		
			if(tipotransaAux.getIsChanged()) {
				tipotransaAux.setIsChanged(false);
			}		
			
			if(tipotransaAux.getIsNew()) {
				tipotransaAux.setIsNew(false);
			}	
			
			if(tipotransaAux.getIsDeleted()) {
				tipotransaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoTransa tipotransaAsignar,TipoTransa tipotransa) throws Exception {
		tipotransaAsignar.setId(tipotransa.getId());	
		tipotransaAsignar.setVersionRow(tipotransa.getVersionRow());	
		tipotransaAsignar.setnombre(tipotransa.getnombre());	
	}
	
	public static void inicializarTipoTransa(TipoTransa tipotransa) throws Exception {
		try {
				tipotransa.setId(0L);	
					
				tipotransa.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoTransa(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoTransaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoTransa(String sTipo,Row row,Workbook workbook,TipoTransa tipotransa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipotransa.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoTransa=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoTransa() {
		return this.sFinalQueryTipoTransa;
	}
	
	public void setsFinalQueryTipoTransa(String sFinalQueryTipoTransa) {
		this.sFinalQueryTipoTransa= sFinalQueryTipoTransa;
	}
	
	public Border resaltarSeleccionarTipoTransa=null;
	
	public Border setResaltarSeleccionarTipoTransa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTransaBeanSwingJInternalFrame tipotransaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipotransaBeanSwingJInternalFrame.jTtoolBarTipoTransa.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoTransa= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoTransa() {
		return this.resaltarSeleccionarTipoTransa;
	}
	
	public void setResaltarSeleccionarTipoTransa(Border borderResaltarSeleccionarTipoTransa) {
		this.resaltarSeleccionarTipoTransa= borderResaltarSeleccionarTipoTransa;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoTransa=null;
	public Boolean mostraridTipoTransa=true;
	public Boolean activaridTipoTransa=true;

	public Border resaltarnombreTipoTransa=null;
	public Boolean mostrarnombreTipoTransa=true;
	public Boolean activarnombreTipoTransa=true;

	
	

	public Border setResaltaridTipoTransa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTransaBeanSwingJInternalFrame tipotransaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipotransaBeanSwingJInternalFrame.jTtoolBarTipoTransa.setBorder(borderResaltar);
		
		this.resaltaridTipoTransa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoTransa() {
		return this.resaltaridTipoTransa;
	}

	public void setResaltaridTipoTransa(Border borderResaltar) {
		this.resaltaridTipoTransa= borderResaltar;
	}

	public Boolean getMostraridTipoTransa() {
		return this.mostraridTipoTransa;
	}

	public void setMostraridTipoTransa(Boolean mostraridTipoTransa) {
		this.mostraridTipoTransa= mostraridTipoTransa;
	}

	public Boolean getActivaridTipoTransa() {
		return this.activaridTipoTransa;
	}

	public void setActivaridTipoTransa(Boolean activaridTipoTransa) {
		this.activaridTipoTransa= activaridTipoTransa;
	}

	public Border setResaltarnombreTipoTransa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTransaBeanSwingJInternalFrame tipotransaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipotransaBeanSwingJInternalFrame.jTtoolBarTipoTransa.setBorder(borderResaltar);
		
		this.resaltarnombreTipoTransa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoTransa() {
		return this.resaltarnombreTipoTransa;
	}

	public void setResaltarnombreTipoTransa(Border borderResaltar) {
		this.resaltarnombreTipoTransa= borderResaltar;
	}

	public Boolean getMostrarnombreTipoTransa() {
		return this.mostrarnombreTipoTransa;
	}

	public void setMostrarnombreTipoTransa(Boolean mostrarnombreTipoTransa) {
		this.mostrarnombreTipoTransa= mostrarnombreTipoTransa;
	}

	public Boolean getActivarnombreTipoTransa() {
		return this.activarnombreTipoTransa;
	}

	public void setActivarnombreTipoTransa(Boolean activarnombreTipoTransa) {
		this.activarnombreTipoTransa= activarnombreTipoTransa;
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
		
		
		this.setMostraridTipoTransa(esInicial);
		this.setMostrarnombreTipoTransa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTransaConstantesFunciones.ID)) {
				this.setMostraridTipoTransa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTransaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoTransa(esAsigna);
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
		
		
		this.setActivaridTipoTransa(esInicial);
		this.setActivarnombreTipoTransa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTransaConstantesFunciones.ID)) {
				this.setActivaridTipoTransa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTransaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoTransa(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoTransaBeanSwingJInternalFrame tipotransaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoTransa(esInicial);
		this.setResaltarnombreTipoTransa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTransaConstantesFunciones.ID)) {
				this.setResaltaridTipoTransa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTransaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoTransa(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarTransaccionTipoTransa=null;

	public Border getResaltarTransaccionTipoTransa() {
		return this.resaltarTransaccionTipoTransa;
	}

	public void setResaltarTransaccionTipoTransa(Border borderResaltarTransaccion) {
		if(borderResaltarTransaccion!=null) {
			this.resaltarTransaccionTipoTransa= borderResaltarTransaccion;
		}
	}

	public Border setResaltarTransaccionTipoTransa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTransaBeanSwingJInternalFrame tipotransaBeanSwingJInternalFrame*/) {
		Border borderResaltarTransaccion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipotransaBeanSwingJInternalFrame.jTtoolBarTipoTransa.setBorder(borderResaltarTransaccion);
			
		this.resaltarTransaccionTipoTransa= borderResaltarTransaccion;

		 return borderResaltarTransaccion;
	}



	public Boolean mostrarTransaccionTipoTransa=true;

	public Boolean getMostrarTransaccionTipoTransa() {
		return this.mostrarTransaccionTipoTransa;
	}

	public void setMostrarTransaccionTipoTransa(Boolean visibilidadResaltarTransaccion) {
		this.mostrarTransaccionTipoTransa= visibilidadResaltarTransaccion;
	}



	public Boolean activarTransaccionTipoTransa=true;

	public Boolean gethabilitarResaltarTransaccionTipoTransa() {
		return this.activarTransaccionTipoTransa;
	}

	public void setActivarTransaccionTipoTransa(Boolean habilitarResaltarTransaccion) {
		this.activarTransaccionTipoTransa= habilitarResaltarTransaccion;
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

		this.setMostrarTransaccionTipoTransa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Transaccion.class)) {
				this.setMostrarTransaccionTipoTransa(esAsigna);
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

		this.setActivarTransaccionTipoTransa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Transaccion.class)) {
				this.setActivarTransaccionTipoTransa(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoTransaBeanSwingJInternalFrame tipotransaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarTransaccionTipoTransa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Transaccion.class)) {
				this.setResaltarTransaccionTipoTransa(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}