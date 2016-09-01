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


import com.bydan.erp.nomina.util.TipoGeneroConstantesFunciones;
import com.bydan.erp.nomina.util.TipoGeneroParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoGeneroParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



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
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoGeneroConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoGenero";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoGenero"+TipoGeneroConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoGeneroHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoGeneroHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoGeneroConstantesFunciones.SCHEMA+"_"+TipoGeneroConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoGeneroHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoGeneroConstantesFunciones.SCHEMA+"_"+TipoGeneroConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoGeneroConstantesFunciones.SCHEMA+"_"+TipoGeneroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoGeneroHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoGeneroConstantesFunciones.SCHEMA+"_"+TipoGeneroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGeneroConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGeneroHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGeneroConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGeneroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGeneroHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGeneroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoGeneroConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoGeneroConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoGeneroConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoGeneroConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Generoes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Genero";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Genero";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoGenero";
	public static final String OBJECTNAME="tipogenero";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_genero";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipogenero from "+TipoGeneroConstantesFunciones.SPERSISTENCENAME+" tipogenero";
	public static String QUERYSELECTNATIVE="select "+TipoGeneroConstantesFunciones.SCHEMA+"."+TipoGeneroConstantesFunciones.TABLENAME+".id,"+TipoGeneroConstantesFunciones.SCHEMA+"."+TipoGeneroConstantesFunciones.TABLENAME+".version_row,"+TipoGeneroConstantesFunciones.SCHEMA+"."+TipoGeneroConstantesFunciones.TABLENAME+".codigo,"+TipoGeneroConstantesFunciones.SCHEMA+"."+TipoGeneroConstantesFunciones.TABLENAME+".nombre from "+TipoGeneroConstantesFunciones.SCHEMA+"."+TipoGeneroConstantesFunciones.TABLENAME;//+" as "+TipoGeneroConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoGeneroLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoGeneroConstantesFunciones.CODIGO)) {sLabelColumna=TipoGeneroConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoGeneroConstantesFunciones.NOMBRE)) {sLabelColumna=TipoGeneroConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoGeneroDescripcion(TipoGenero tipogenero) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipogenero !=null/* && tipogenero.getId()!=0*/) {
			sDescripcion=tipogenero.getcodigo();//tipogenerotipogenero.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoGeneroDescripcionDetallado(TipoGenero tipogenero) {
		String sDescripcion="";
			
		sDescripcion+=TipoGeneroConstantesFunciones.ID+"=";
		sDescripcion+=tipogenero.getId().toString()+",";
		sDescripcion+=TipoGeneroConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipogenero.getVersionRow().toString()+",";
		sDescripcion+=TipoGeneroConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipogenero.getcodigo()+",";
		sDescripcion+=TipoGeneroConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipogenero.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoGeneroDescripcion(TipoGenero tipogenero,String sValor) throws Exception {			
		if(tipogenero !=null) {
			tipogenero.setcodigo(sValor);;//tipogenerotipogenero.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoGenero(TipoGenero tipogenero,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipogenero.setcodigo(tipogenero.getcodigo().trim());
		tipogenero.setnombre(tipogenero.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoGeneros(List<TipoGenero> tipogeneros,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoGenero tipogenero: tipogeneros) {
			tipogenero.setcodigo(tipogenero.getcodigo().trim());
			tipogenero.setnombre(tipogenero.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGenero(TipoGenero tipogenero,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipogenero.getConCambioAuxiliar()) {
			tipogenero.setIsDeleted(tipogenero.getIsDeletedAuxiliar());	
			tipogenero.setIsNew(tipogenero.getIsNewAuxiliar());	
			tipogenero.setIsChanged(tipogenero.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipogenero.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipogenero.setIsDeletedAuxiliar(false);	
			tipogenero.setIsNewAuxiliar(false);	
			tipogenero.setIsChangedAuxiliar(false);
			
			tipogenero.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGeneros(List<TipoGenero> tipogeneros,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoGenero tipogenero : tipogeneros) {
			if(conAsignarBase && tipogenero.getConCambioAuxiliar()) {
				tipogenero.setIsDeleted(tipogenero.getIsDeletedAuxiliar());	
				tipogenero.setIsNew(tipogenero.getIsNewAuxiliar());	
				tipogenero.setIsChanged(tipogenero.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipogenero.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipogenero.setIsDeletedAuxiliar(false);	
				tipogenero.setIsNewAuxiliar(false);	
				tipogenero.setIsChangedAuxiliar(false);
				
				tipogenero.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoGenero(TipoGenero tipogenero,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoGeneros(List<TipoGenero> tipogeneros,Boolean conEnteros) throws Exception  {
		
		for(TipoGenero tipogenero: tipogeneros) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoGenero(List<TipoGenero> tipogeneros,TipoGenero tipogeneroAux) throws Exception  {
		TipoGeneroConstantesFunciones.InicializarValoresTipoGenero(tipogeneroAux,true);
		
		for(TipoGenero tipogenero: tipogeneros) {
			if(tipogenero.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGenero(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoGeneroConstantesFunciones.getArrayColumnasGlobalesTipoGenero(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGenero(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoGenero(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoGenero> tipogeneros,TipoGenero tipogenero,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoGenero tipogeneroAux: tipogeneros) {
			if(tipogeneroAux!=null && tipogenero!=null) {
				if((tipogeneroAux.getId()==null && tipogenero.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipogeneroAux.getId()!=null && tipogenero.getId()!=null){
					if(tipogeneroAux.getId().equals(tipogenero.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoGenero(List<TipoGenero> tipogeneros) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoGenero tipogenero: tipogeneros) {			
			if(tipogenero.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoGenero() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoGeneroConstantesFunciones.LABEL_ID, TipoGeneroConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGeneroConstantesFunciones.LABEL_VERSIONROW, TipoGeneroConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGeneroConstantesFunciones.LABEL_CODIGO, TipoGeneroConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGeneroConstantesFunciones.LABEL_NOMBRE, TipoGeneroConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoGenero() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoGeneroConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGeneroConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGeneroConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGeneroConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGenero() throws Exception  {
		return TipoGeneroConstantesFunciones.getTiposSeleccionarTipoGenero(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGenero(Boolean conFk) throws Exception  {
		return TipoGeneroConstantesFunciones.getTiposSeleccionarTipoGenero(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGenero(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGeneroConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoGeneroConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGeneroConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoGeneroConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoGenero(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGenero(TipoGenero tipogeneroAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGenero(List<TipoGenero> tipogenerosTemp) throws Exception {
		for(TipoGenero tipogeneroAux:tipogenerosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoGenero(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoGenero(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGenero(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGeneroConstantesFunciones.getClassesRelationshipsOfTipoGenero(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGenero(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(CargaFamiliar_NM.class));
				classes.add(new Classe(SubCliente.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(ParametroCarteraDefecto.class));
				classes.add(new Classe(CargaFamiliar.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CargaFamiliar_NM.class)) {
						classes.add(new Classe(CargaFamiliar_NM.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SubCliente.class)) {
						classes.add(new Classe(SubCliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroCarteraDefecto.class)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CargaFamiliar.class)) {
						classes.add(new Classe(CargaFamiliar.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGenero(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGeneroConstantesFunciones.getClassesRelationshipsFromStringsOfTipoGenero(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGenero(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(CargaFamiliar_NM.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CargaFamiliar_NM.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(ParametroCarteraDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); continue;
					}

					if(CargaFamiliar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CargaFamiliar.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(CargaFamiliar_NM.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CargaFamiliar_NM.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(ParametroCarteraDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); continue;
					}

					if(CargaFamiliar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CargaFamiliar.class)); continue;
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
	public static void actualizarLista(TipoGenero tipogenero,List<TipoGenero> tipogeneros,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoGenero tipogeneroEncontrado=null;
			
			for(TipoGenero tipogeneroLocal:tipogeneros) {
				if(tipogeneroLocal.getId().equals(tipogenero.getId())) {
					tipogeneroEncontrado=tipogeneroLocal;
					
					tipogeneroLocal.setIsChanged(tipogenero.getIsChanged());
					tipogeneroLocal.setIsNew(tipogenero.getIsNew());
					tipogeneroLocal.setIsDeleted(tipogenero.getIsDeleted());
					
					tipogeneroLocal.setGeneralEntityOriginal(tipogenero.getGeneralEntityOriginal());
					
					tipogeneroLocal.setId(tipogenero.getId());	
					tipogeneroLocal.setVersionRow(tipogenero.getVersionRow());	
					tipogeneroLocal.setcodigo(tipogenero.getcodigo());	
					tipogeneroLocal.setnombre(tipogenero.getnombre());	
					
					
					tipogeneroLocal.setClientes(tipogenero.getClientes());
					tipogeneroLocal.setCargaFamiliar_NMs(tipogenero.getCargaFamiliar_NMs());
					tipogeneroLocal.setSubClientes(tipogenero.getSubClientes());
					tipogeneroLocal.setEmpleados(tipogenero.getEmpleados());
					tipogeneroLocal.setParametroCarteraDefectos(tipogenero.getParametroCarteraDefectos());
					tipogeneroLocal.setCargaFamiliars(tipogenero.getCargaFamiliars());
					
					existe=true;
					break;
				}
			}
			
			if(!tipogenero.getIsDeleted()) {
				if(!existe) {
					tipogeneros.add(tipogenero);
				}
			} else {
				if(tipogeneroEncontrado!=null && permiteQuitar)  {
					tipogeneros.remove(tipogeneroEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoGenero tipogenero,List<TipoGenero> tipogeneros) throws Exception {
		try	{			
			for(TipoGenero tipogeneroLocal:tipogeneros) {
				if(tipogeneroLocal.getId().equals(tipogenero.getId())) {
					tipogeneroLocal.setIsSelected(tipogenero.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoGenero(List<TipoGenero> tipogenerosAux) throws Exception {
		//this.tipogenerosAux=tipogenerosAux;
		
		for(TipoGenero tipogeneroAux:tipogenerosAux) {
			if(tipogeneroAux.getIsChanged()) {
				tipogeneroAux.setIsChanged(false);
			}		
			
			if(tipogeneroAux.getIsNew()) {
				tipogeneroAux.setIsNew(false);
			}	
			
			if(tipogeneroAux.getIsDeleted()) {
				tipogeneroAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoGenero(TipoGenero tipogeneroAux) throws Exception {
		//this.tipogeneroAux=tipogeneroAux;
		
			if(tipogeneroAux.getIsChanged()) {
				tipogeneroAux.setIsChanged(false);
			}		
			
			if(tipogeneroAux.getIsNew()) {
				tipogeneroAux.setIsNew(false);
			}	
			
			if(tipogeneroAux.getIsDeleted()) {
				tipogeneroAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoGenero tipogeneroAsignar,TipoGenero tipogenero) throws Exception {
		tipogeneroAsignar.setId(tipogenero.getId());	
		tipogeneroAsignar.setVersionRow(tipogenero.getVersionRow());	
		tipogeneroAsignar.setcodigo(tipogenero.getcodigo());	
		tipogeneroAsignar.setnombre(tipogenero.getnombre());	
	}
	
	public static void inicializarTipoGenero(TipoGenero tipogenero) throws Exception {
		try {
				tipogenero.setId(0L);	
					
				tipogenero.setcodigo("");	
				tipogenero.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoGenero(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGeneroConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGeneroConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoGenero(String sTipo,Row row,Workbook workbook,TipoGenero tipogenero,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogenero.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogenero.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoGenero=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoGenero() {
		return this.sFinalQueryTipoGenero;
	}
	
	public void setsFinalQueryTipoGenero(String sFinalQueryTipoGenero) {
		this.sFinalQueryTipoGenero= sFinalQueryTipoGenero;
	}
	
	public Border resaltarSeleccionarTipoGenero=null;
	
	public Border setResaltarSeleccionarTipoGenero(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGeneroBeanSwingJInternalFrame tipogeneroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipogeneroBeanSwingJInternalFrame.jTtoolBarTipoGenero.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoGenero= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoGenero() {
		return this.resaltarSeleccionarTipoGenero;
	}
	
	public void setResaltarSeleccionarTipoGenero(Border borderResaltarSeleccionarTipoGenero) {
		this.resaltarSeleccionarTipoGenero= borderResaltarSeleccionarTipoGenero;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoGenero=null;
	public Boolean mostraridTipoGenero=true;
	public Boolean activaridTipoGenero=true;

	public Border resaltarcodigoTipoGenero=null;
	public Boolean mostrarcodigoTipoGenero=true;
	public Boolean activarcodigoTipoGenero=true;

	public Border resaltarnombreTipoGenero=null;
	public Boolean mostrarnombreTipoGenero=true;
	public Boolean activarnombreTipoGenero=true;

	
	

	public Border setResaltaridTipoGenero(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGeneroBeanSwingJInternalFrame tipogeneroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogeneroBeanSwingJInternalFrame.jTtoolBarTipoGenero.setBorder(borderResaltar);
		
		this.resaltaridTipoGenero= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoGenero() {
		return this.resaltaridTipoGenero;
	}

	public void setResaltaridTipoGenero(Border borderResaltar) {
		this.resaltaridTipoGenero= borderResaltar;
	}

	public Boolean getMostraridTipoGenero() {
		return this.mostraridTipoGenero;
	}

	public void setMostraridTipoGenero(Boolean mostraridTipoGenero) {
		this.mostraridTipoGenero= mostraridTipoGenero;
	}

	public Boolean getActivaridTipoGenero() {
		return this.activaridTipoGenero;
	}

	public void setActivaridTipoGenero(Boolean activaridTipoGenero) {
		this.activaridTipoGenero= activaridTipoGenero;
	}

	public Border setResaltarcodigoTipoGenero(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGeneroBeanSwingJInternalFrame tipogeneroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogeneroBeanSwingJInternalFrame.jTtoolBarTipoGenero.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoGenero= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoGenero() {
		return this.resaltarcodigoTipoGenero;
	}

	public void setResaltarcodigoTipoGenero(Border borderResaltar) {
		this.resaltarcodigoTipoGenero= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoGenero() {
		return this.mostrarcodigoTipoGenero;
	}

	public void setMostrarcodigoTipoGenero(Boolean mostrarcodigoTipoGenero) {
		this.mostrarcodigoTipoGenero= mostrarcodigoTipoGenero;
	}

	public Boolean getActivarcodigoTipoGenero() {
		return this.activarcodigoTipoGenero;
	}

	public void setActivarcodigoTipoGenero(Boolean activarcodigoTipoGenero) {
		this.activarcodigoTipoGenero= activarcodigoTipoGenero;
	}

	public Border setResaltarnombreTipoGenero(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGeneroBeanSwingJInternalFrame tipogeneroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogeneroBeanSwingJInternalFrame.jTtoolBarTipoGenero.setBorder(borderResaltar);
		
		this.resaltarnombreTipoGenero= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoGenero() {
		return this.resaltarnombreTipoGenero;
	}

	public void setResaltarnombreTipoGenero(Border borderResaltar) {
		this.resaltarnombreTipoGenero= borderResaltar;
	}

	public Boolean getMostrarnombreTipoGenero() {
		return this.mostrarnombreTipoGenero;
	}

	public void setMostrarnombreTipoGenero(Boolean mostrarnombreTipoGenero) {
		this.mostrarnombreTipoGenero= mostrarnombreTipoGenero;
	}

	public Boolean getActivarnombreTipoGenero() {
		return this.activarnombreTipoGenero;
	}

	public void setActivarnombreTipoGenero(Boolean activarnombreTipoGenero) {
		this.activarnombreTipoGenero= activarnombreTipoGenero;
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
		
		
		this.setMostraridTipoGenero(esInicial);
		this.setMostrarcodigoTipoGenero(esInicial);
		this.setMostrarnombreTipoGenero(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGeneroConstantesFunciones.ID)) {
				this.setMostraridTipoGenero(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGeneroConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoGenero(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGeneroConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoGenero(esAsigna);
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
		
		
		this.setActivaridTipoGenero(esInicial);
		this.setActivarcodigoTipoGenero(esInicial);
		this.setActivarnombreTipoGenero(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGeneroConstantesFunciones.ID)) {
				this.setActivaridTipoGenero(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGeneroConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoGenero(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGeneroConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoGenero(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGeneroBeanSwingJInternalFrame tipogeneroBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoGenero(esInicial);
		this.setResaltarcodigoTipoGenero(esInicial);
		this.setResaltarnombreTipoGenero(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGeneroConstantesFunciones.ID)) {
				this.setResaltaridTipoGenero(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGeneroConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoGenero(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGeneroConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoGenero(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarClienteTipoGenero=null;

	public Border getResaltarClienteTipoGenero() {
		return this.resaltarClienteTipoGenero;
	}

	public void setResaltarClienteTipoGenero(Border borderResaltarCliente) {
		if(borderResaltarCliente!=null) {
			this.resaltarClienteTipoGenero= borderResaltarCliente;
		}
	}

	public Border setResaltarClienteTipoGenero(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGeneroBeanSwingJInternalFrame tipogeneroBeanSwingJInternalFrame*/) {
		Border borderResaltarCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipogeneroBeanSwingJInternalFrame.jTtoolBarTipoGenero.setBorder(borderResaltarCliente);
			
		this.resaltarClienteTipoGenero= borderResaltarCliente;

		 return borderResaltarCliente;
	}



	public Boolean mostrarClienteTipoGenero=true;

	public Boolean getMostrarClienteTipoGenero() {
		return this.mostrarClienteTipoGenero;
	}

	public void setMostrarClienteTipoGenero(Boolean visibilidadResaltarCliente) {
		this.mostrarClienteTipoGenero= visibilidadResaltarCliente;
	}



	public Boolean activarClienteTipoGenero=true;

	public Boolean gethabilitarResaltarClienteTipoGenero() {
		return this.activarClienteTipoGenero;
	}

	public void setActivarClienteTipoGenero(Boolean habilitarResaltarCliente) {
		this.activarClienteTipoGenero= habilitarResaltarCliente;
	}


	public Border resaltarCargaFamiliar_NMTipoGenero=null;

	public Border getResaltarCargaFamiliar_NMTipoGenero() {
		return this.resaltarCargaFamiliar_NMTipoGenero;
	}

	public void setResaltarCargaFamiliar_NMTipoGenero(Border borderResaltarCargaFamiliar_NM) {
		if(borderResaltarCargaFamiliar_NM!=null) {
			this.resaltarCargaFamiliar_NMTipoGenero= borderResaltarCargaFamiliar_NM;
		}
	}

	public Border setResaltarCargaFamiliar_NMTipoGenero(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGeneroBeanSwingJInternalFrame tipogeneroBeanSwingJInternalFrame*/) {
		Border borderResaltarCargaFamiliar_NM=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipogeneroBeanSwingJInternalFrame.jTtoolBarTipoGenero.setBorder(borderResaltarCargaFamiliar_NM);
			
		this.resaltarCargaFamiliar_NMTipoGenero= borderResaltarCargaFamiliar_NM;

		 return borderResaltarCargaFamiliar_NM;
	}



	public Boolean mostrarCargaFamiliar_NMTipoGenero=true;

	public Boolean getMostrarCargaFamiliar_NMTipoGenero() {
		return this.mostrarCargaFamiliar_NMTipoGenero;
	}

	public void setMostrarCargaFamiliar_NMTipoGenero(Boolean visibilidadResaltarCargaFamiliar_NM) {
		this.mostrarCargaFamiliar_NMTipoGenero= visibilidadResaltarCargaFamiliar_NM;
	}



	public Boolean activarCargaFamiliar_NMTipoGenero=true;

	public Boolean gethabilitarResaltarCargaFamiliar_NMTipoGenero() {
		return this.activarCargaFamiliar_NMTipoGenero;
	}

	public void setActivarCargaFamiliar_NMTipoGenero(Boolean habilitarResaltarCargaFamiliar_NM) {
		this.activarCargaFamiliar_NMTipoGenero= habilitarResaltarCargaFamiliar_NM;
	}


	public Border resaltarSubClienteTipoGenero=null;

	public Border getResaltarSubClienteTipoGenero() {
		return this.resaltarSubClienteTipoGenero;
	}

	public void setResaltarSubClienteTipoGenero(Border borderResaltarSubCliente) {
		if(borderResaltarSubCliente!=null) {
			this.resaltarSubClienteTipoGenero= borderResaltarSubCliente;
		}
	}

	public Border setResaltarSubClienteTipoGenero(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGeneroBeanSwingJInternalFrame tipogeneroBeanSwingJInternalFrame*/) {
		Border borderResaltarSubCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipogeneroBeanSwingJInternalFrame.jTtoolBarTipoGenero.setBorder(borderResaltarSubCliente);
			
		this.resaltarSubClienteTipoGenero= borderResaltarSubCliente;

		 return borderResaltarSubCliente;
	}



	public Boolean mostrarSubClienteTipoGenero=true;

	public Boolean getMostrarSubClienteTipoGenero() {
		return this.mostrarSubClienteTipoGenero;
	}

	public void setMostrarSubClienteTipoGenero(Boolean visibilidadResaltarSubCliente) {
		this.mostrarSubClienteTipoGenero= visibilidadResaltarSubCliente;
	}



	public Boolean activarSubClienteTipoGenero=true;

	public Boolean gethabilitarResaltarSubClienteTipoGenero() {
		return this.activarSubClienteTipoGenero;
	}

	public void setActivarSubClienteTipoGenero(Boolean habilitarResaltarSubCliente) {
		this.activarSubClienteTipoGenero= habilitarResaltarSubCliente;
	}


	public Border resaltarEmpleadoTipoGenero=null;

	public Border getResaltarEmpleadoTipoGenero() {
		return this.resaltarEmpleadoTipoGenero;
	}

	public void setResaltarEmpleadoTipoGenero(Border borderResaltarEmpleado) {
		if(borderResaltarEmpleado!=null) {
			this.resaltarEmpleadoTipoGenero= borderResaltarEmpleado;
		}
	}

	public Border setResaltarEmpleadoTipoGenero(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGeneroBeanSwingJInternalFrame tipogeneroBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipogeneroBeanSwingJInternalFrame.jTtoolBarTipoGenero.setBorder(borderResaltarEmpleado);
			
		this.resaltarEmpleadoTipoGenero= borderResaltarEmpleado;

		 return borderResaltarEmpleado;
	}



	public Boolean mostrarEmpleadoTipoGenero=true;

	public Boolean getMostrarEmpleadoTipoGenero() {
		return this.mostrarEmpleadoTipoGenero;
	}

	public void setMostrarEmpleadoTipoGenero(Boolean visibilidadResaltarEmpleado) {
		this.mostrarEmpleadoTipoGenero= visibilidadResaltarEmpleado;
	}



	public Boolean activarEmpleadoTipoGenero=true;

	public Boolean gethabilitarResaltarEmpleadoTipoGenero() {
		return this.activarEmpleadoTipoGenero;
	}

	public void setActivarEmpleadoTipoGenero(Boolean habilitarResaltarEmpleado) {
		this.activarEmpleadoTipoGenero= habilitarResaltarEmpleado;
	}


	public Border resaltarParametroCarteraDefectoTipoGenero=null;

	public Border getResaltarParametroCarteraDefectoTipoGenero() {
		return this.resaltarParametroCarteraDefectoTipoGenero;
	}

	public void setResaltarParametroCarteraDefectoTipoGenero(Border borderResaltarParametroCarteraDefecto) {
		if(borderResaltarParametroCarteraDefecto!=null) {
			this.resaltarParametroCarteraDefectoTipoGenero= borderResaltarParametroCarteraDefecto;
		}
	}

	public Border setResaltarParametroCarteraDefectoTipoGenero(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGeneroBeanSwingJInternalFrame tipogeneroBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroCarteraDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipogeneroBeanSwingJInternalFrame.jTtoolBarTipoGenero.setBorder(borderResaltarParametroCarteraDefecto);
			
		this.resaltarParametroCarteraDefectoTipoGenero= borderResaltarParametroCarteraDefecto;

		 return borderResaltarParametroCarteraDefecto;
	}



	public Boolean mostrarParametroCarteraDefectoTipoGenero=true;

	public Boolean getMostrarParametroCarteraDefectoTipoGenero() {
		return this.mostrarParametroCarteraDefectoTipoGenero;
	}

	public void setMostrarParametroCarteraDefectoTipoGenero(Boolean visibilidadResaltarParametroCarteraDefecto) {
		this.mostrarParametroCarteraDefectoTipoGenero= visibilidadResaltarParametroCarteraDefecto;
	}



	public Boolean activarParametroCarteraDefectoTipoGenero=true;

	public Boolean gethabilitarResaltarParametroCarteraDefectoTipoGenero() {
		return this.activarParametroCarteraDefectoTipoGenero;
	}

	public void setActivarParametroCarteraDefectoTipoGenero(Boolean habilitarResaltarParametroCarteraDefecto) {
		this.activarParametroCarteraDefectoTipoGenero= habilitarResaltarParametroCarteraDefecto;
	}


	public Border resaltarCargaFamiliarTipoGenero=null;

	public Border getResaltarCargaFamiliarTipoGenero() {
		return this.resaltarCargaFamiliarTipoGenero;
	}

	public void setResaltarCargaFamiliarTipoGenero(Border borderResaltarCargaFamiliar) {
		if(borderResaltarCargaFamiliar!=null) {
			this.resaltarCargaFamiliarTipoGenero= borderResaltarCargaFamiliar;
		}
	}

	public Border setResaltarCargaFamiliarTipoGenero(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGeneroBeanSwingJInternalFrame tipogeneroBeanSwingJInternalFrame*/) {
		Border borderResaltarCargaFamiliar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipogeneroBeanSwingJInternalFrame.jTtoolBarTipoGenero.setBorder(borderResaltarCargaFamiliar);
			
		this.resaltarCargaFamiliarTipoGenero= borderResaltarCargaFamiliar;

		 return borderResaltarCargaFamiliar;
	}



	public Boolean mostrarCargaFamiliarTipoGenero=true;

	public Boolean getMostrarCargaFamiliarTipoGenero() {
		return this.mostrarCargaFamiliarTipoGenero;
	}

	public void setMostrarCargaFamiliarTipoGenero(Boolean visibilidadResaltarCargaFamiliar) {
		this.mostrarCargaFamiliarTipoGenero= visibilidadResaltarCargaFamiliar;
	}



	public Boolean activarCargaFamiliarTipoGenero=true;

	public Boolean gethabilitarResaltarCargaFamiliarTipoGenero() {
		return this.activarCargaFamiliarTipoGenero;
	}

	public void setActivarCargaFamiliarTipoGenero(Boolean habilitarResaltarCargaFamiliar) {
		this.activarCargaFamiliarTipoGenero= habilitarResaltarCargaFamiliar;
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

		this.setMostrarClienteTipoGenero(esInicial);
		this.setMostrarCargaFamiliar_NMTipoGenero(esInicial);
		this.setMostrarSubClienteTipoGenero(esInicial);
		this.setMostrarEmpleadoTipoGenero(esInicial);
		this.setMostrarParametroCarteraDefectoTipoGenero(esInicial);
		this.setMostrarCargaFamiliarTipoGenero(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setMostrarClienteTipoGenero(esAsigna);
				continue;
			}

			if(clase.clas.equals(CargaFamiliar_NM.class)) {
				this.setMostrarCargaFamiliar_NMTipoGenero(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubCliente.class)) {
				this.setMostrarSubClienteTipoGenero(esAsigna);
				continue;
			}

			if(clase.clas.equals(Empleado.class)) {
				this.setMostrarEmpleadoTipoGenero(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setMostrarParametroCarteraDefectoTipoGenero(esAsigna);
				continue;
			}

			if(clase.clas.equals(CargaFamiliar.class)) {
				this.setMostrarCargaFamiliarTipoGenero(esAsigna);
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

		this.setActivarClienteTipoGenero(esInicial);
		this.setActivarCargaFamiliar_NMTipoGenero(esInicial);
		this.setActivarSubClienteTipoGenero(esInicial);
		this.setActivarEmpleadoTipoGenero(esInicial);
		this.setActivarParametroCarteraDefectoTipoGenero(esInicial);
		this.setActivarCargaFamiliarTipoGenero(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setActivarClienteTipoGenero(esAsigna);
				continue;
			}

			if(clase.clas.equals(CargaFamiliar_NM.class)) {
				this.setActivarCargaFamiliar_NMTipoGenero(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubCliente.class)) {
				this.setActivarSubClienteTipoGenero(esAsigna);
				continue;
			}

			if(clase.clas.equals(Empleado.class)) {
				this.setActivarEmpleadoTipoGenero(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setActivarParametroCarteraDefectoTipoGenero(esAsigna);
				continue;
			}

			if(clase.clas.equals(CargaFamiliar.class)) {
				this.setActivarCargaFamiliarTipoGenero(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGeneroBeanSwingJInternalFrame tipogeneroBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarClienteTipoGenero(esInicial);
		this.setResaltarCargaFamiliar_NMTipoGenero(esInicial);
		this.setResaltarSubClienteTipoGenero(esInicial);
		this.setResaltarEmpleadoTipoGenero(esInicial);
		this.setResaltarParametroCarteraDefectoTipoGenero(esInicial);
		this.setResaltarCargaFamiliarTipoGenero(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setResaltarClienteTipoGenero(esAsigna);
				continue;
			}

			if(clase.clas.equals(CargaFamiliar_NM.class)) {
				this.setResaltarCargaFamiliar_NMTipoGenero(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubCliente.class)) {
				this.setResaltarSubClienteTipoGenero(esAsigna);
				continue;
			}

			if(clase.clas.equals(Empleado.class)) {
				this.setResaltarEmpleadoTipoGenero(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setResaltarParametroCarteraDefectoTipoGenero(esAsigna);
				continue;
			}

			if(clase.clas.equals(CargaFamiliar.class)) {
				this.setResaltarCargaFamiliarTipoGenero(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}