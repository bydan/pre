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


import com.bydan.erp.cartera.util.TipoGlobalClienteConstantesFunciones;
import com.bydan.erp.cartera.util.TipoGlobalClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoGlobalClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoGlobalClienteConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoGlobalCliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoGlobalCliente"+TipoGlobalClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoGlobalClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoGlobalClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoGlobalClienteConstantesFunciones.SCHEMA+"_"+TipoGlobalClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoGlobalClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoGlobalClienteConstantesFunciones.SCHEMA+"_"+TipoGlobalClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoGlobalClienteConstantesFunciones.SCHEMA+"_"+TipoGlobalClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoGlobalClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoGlobalClienteConstantesFunciones.SCHEMA+"_"+TipoGlobalClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGlobalClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGlobalClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGlobalClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGlobalClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGlobalClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGlobalClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoGlobalClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoGlobalClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoGlobalClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoGlobalClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Global Clientees";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Global Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Global Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoGlobalCliente";
	public static final String OBJECTNAME="tipoglobalcliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_global_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoglobalcliente from "+TipoGlobalClienteConstantesFunciones.SPERSISTENCENAME+" tipoglobalcliente";
	public static String QUERYSELECTNATIVE="select "+TipoGlobalClienteConstantesFunciones.SCHEMA+"."+TipoGlobalClienteConstantesFunciones.TABLENAME+".id,"+TipoGlobalClienteConstantesFunciones.SCHEMA+"."+TipoGlobalClienteConstantesFunciones.TABLENAME+".version_row,"+TipoGlobalClienteConstantesFunciones.SCHEMA+"."+TipoGlobalClienteConstantesFunciones.TABLENAME+".codigo,"+TipoGlobalClienteConstantesFunciones.SCHEMA+"."+TipoGlobalClienteConstantesFunciones.TABLENAME+".nombre from "+TipoGlobalClienteConstantesFunciones.SCHEMA+"."+TipoGlobalClienteConstantesFunciones.TABLENAME;//+" as "+TipoGlobalClienteConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoGlobalClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoGlobalClienteConstantesFunciones.CODIGO)) {sLabelColumna=TipoGlobalClienteConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoGlobalClienteConstantesFunciones.NOMBRE)) {sLabelColumna=TipoGlobalClienteConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoGlobalClienteDescripcion(TipoGlobalCliente tipoglobalcliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoglobalcliente !=null/* && tipoglobalcliente.getId()!=0*/) {
			sDescripcion=tipoglobalcliente.getcodigo();//tipoglobalclientetipoglobalcliente.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoGlobalClienteDescripcionDetallado(TipoGlobalCliente tipoglobalcliente) {
		String sDescripcion="";
			
		sDescripcion+=TipoGlobalClienteConstantesFunciones.ID+"=";
		sDescripcion+=tipoglobalcliente.getId().toString()+",";
		sDescripcion+=TipoGlobalClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoglobalcliente.getVersionRow().toString()+",";
		sDescripcion+=TipoGlobalClienteConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoglobalcliente.getcodigo()+",";
		sDescripcion+=TipoGlobalClienteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoglobalcliente.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoGlobalClienteDescripcion(TipoGlobalCliente tipoglobalcliente,String sValor) throws Exception {			
		if(tipoglobalcliente !=null) {
			tipoglobalcliente.setcodigo(sValor);;//tipoglobalclientetipoglobalcliente.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoGlobalCliente(TipoGlobalCliente tipoglobalcliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoglobalcliente.setcodigo(tipoglobalcliente.getcodigo().trim());
		tipoglobalcliente.setnombre(tipoglobalcliente.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoGlobalClientes(List<TipoGlobalCliente> tipoglobalclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoGlobalCliente tipoglobalcliente: tipoglobalclientes) {
			tipoglobalcliente.setcodigo(tipoglobalcliente.getcodigo().trim());
			tipoglobalcliente.setnombre(tipoglobalcliente.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGlobalCliente(TipoGlobalCliente tipoglobalcliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoglobalcliente.getConCambioAuxiliar()) {
			tipoglobalcliente.setIsDeleted(tipoglobalcliente.getIsDeletedAuxiliar());	
			tipoglobalcliente.setIsNew(tipoglobalcliente.getIsNewAuxiliar());	
			tipoglobalcliente.setIsChanged(tipoglobalcliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoglobalcliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoglobalcliente.setIsDeletedAuxiliar(false);	
			tipoglobalcliente.setIsNewAuxiliar(false);	
			tipoglobalcliente.setIsChangedAuxiliar(false);
			
			tipoglobalcliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGlobalClientes(List<TipoGlobalCliente> tipoglobalclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoGlobalCliente tipoglobalcliente : tipoglobalclientes) {
			if(conAsignarBase && tipoglobalcliente.getConCambioAuxiliar()) {
				tipoglobalcliente.setIsDeleted(tipoglobalcliente.getIsDeletedAuxiliar());	
				tipoglobalcliente.setIsNew(tipoglobalcliente.getIsNewAuxiliar());	
				tipoglobalcliente.setIsChanged(tipoglobalcliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoglobalcliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoglobalcliente.setIsDeletedAuxiliar(false);	
				tipoglobalcliente.setIsNewAuxiliar(false);	
				tipoglobalcliente.setIsChangedAuxiliar(false);
				
				tipoglobalcliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoGlobalCliente(TipoGlobalCliente tipoglobalcliente,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoGlobalClientes(List<TipoGlobalCliente> tipoglobalclientes,Boolean conEnteros) throws Exception  {
		
		for(TipoGlobalCliente tipoglobalcliente: tipoglobalclientes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoGlobalCliente(List<TipoGlobalCliente> tipoglobalclientes,TipoGlobalCliente tipoglobalclienteAux) throws Exception  {
		TipoGlobalClienteConstantesFunciones.InicializarValoresTipoGlobalCliente(tipoglobalclienteAux,true);
		
		for(TipoGlobalCliente tipoglobalcliente: tipoglobalclientes) {
			if(tipoglobalcliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGlobalCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoGlobalClienteConstantesFunciones.getArrayColumnasGlobalesTipoGlobalCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGlobalCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoGlobalCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoGlobalCliente> tipoglobalclientes,TipoGlobalCliente tipoglobalcliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoGlobalCliente tipoglobalclienteAux: tipoglobalclientes) {
			if(tipoglobalclienteAux!=null && tipoglobalcliente!=null) {
				if((tipoglobalclienteAux.getId()==null && tipoglobalcliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoglobalclienteAux.getId()!=null && tipoglobalcliente.getId()!=null){
					if(tipoglobalclienteAux.getId().equals(tipoglobalcliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoGlobalCliente(List<TipoGlobalCliente> tipoglobalclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoGlobalCliente tipoglobalcliente: tipoglobalclientes) {			
			if(tipoglobalcliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoGlobalCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoGlobalClienteConstantesFunciones.LABEL_ID, TipoGlobalClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGlobalClienteConstantesFunciones.LABEL_VERSIONROW, TipoGlobalClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGlobalClienteConstantesFunciones.LABEL_CODIGO, TipoGlobalClienteConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGlobalClienteConstantesFunciones.LABEL_NOMBRE, TipoGlobalClienteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoGlobalCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoGlobalClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGlobalClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGlobalClienteConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGlobalClienteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGlobalCliente() throws Exception  {
		return TipoGlobalClienteConstantesFunciones.getTiposSeleccionarTipoGlobalCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGlobalCliente(Boolean conFk) throws Exception  {
		return TipoGlobalClienteConstantesFunciones.getTiposSeleccionarTipoGlobalCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGlobalCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGlobalClienteConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoGlobalClienteConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGlobalClienteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoGlobalClienteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoGlobalCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGlobalCliente(TipoGlobalCliente tipoglobalclienteAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGlobalCliente(List<TipoGlobalCliente> tipoglobalclientesTemp) throws Exception {
		for(TipoGlobalCliente tipoglobalclienteAux:tipoglobalclientesTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoGlobalCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoGlobalCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGlobalCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGlobalClienteConstantesFunciones.getClassesRelationshipsOfTipoGlobalCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGlobalCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Definicion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Definicion.class)) {
						classes.add(new Classe(Definicion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGlobalCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGlobalClienteConstantesFunciones.getClassesRelationshipsFromStringsOfTipoGlobalCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGlobalCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Definicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Definicion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Definicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Definicion.class)); continue;
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
	public static void actualizarLista(TipoGlobalCliente tipoglobalcliente,List<TipoGlobalCliente> tipoglobalclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoGlobalCliente tipoglobalclienteEncontrado=null;
			
			for(TipoGlobalCliente tipoglobalclienteLocal:tipoglobalclientes) {
				if(tipoglobalclienteLocal.getId().equals(tipoglobalcliente.getId())) {
					tipoglobalclienteEncontrado=tipoglobalclienteLocal;
					
					tipoglobalclienteLocal.setIsChanged(tipoglobalcliente.getIsChanged());
					tipoglobalclienteLocal.setIsNew(tipoglobalcliente.getIsNew());
					tipoglobalclienteLocal.setIsDeleted(tipoglobalcliente.getIsDeleted());
					
					tipoglobalclienteLocal.setGeneralEntityOriginal(tipoglobalcliente.getGeneralEntityOriginal());
					
					tipoglobalclienteLocal.setId(tipoglobalcliente.getId());	
					tipoglobalclienteLocal.setVersionRow(tipoglobalcliente.getVersionRow());	
					tipoglobalclienteLocal.setcodigo(tipoglobalcliente.getcodigo());	
					tipoglobalclienteLocal.setnombre(tipoglobalcliente.getnombre());	
					
					
					tipoglobalclienteLocal.setDefinicions(tipoglobalcliente.getDefinicions());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoglobalcliente.getIsDeleted()) {
				if(!existe) {
					tipoglobalclientes.add(tipoglobalcliente);
				}
			} else {
				if(tipoglobalclienteEncontrado!=null && permiteQuitar)  {
					tipoglobalclientes.remove(tipoglobalclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoGlobalCliente tipoglobalcliente,List<TipoGlobalCliente> tipoglobalclientes) throws Exception {
		try	{			
			for(TipoGlobalCliente tipoglobalclienteLocal:tipoglobalclientes) {
				if(tipoglobalclienteLocal.getId().equals(tipoglobalcliente.getId())) {
					tipoglobalclienteLocal.setIsSelected(tipoglobalcliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoGlobalCliente(List<TipoGlobalCliente> tipoglobalclientesAux) throws Exception {
		//this.tipoglobalclientesAux=tipoglobalclientesAux;
		
		for(TipoGlobalCliente tipoglobalclienteAux:tipoglobalclientesAux) {
			if(tipoglobalclienteAux.getIsChanged()) {
				tipoglobalclienteAux.setIsChanged(false);
			}		
			
			if(tipoglobalclienteAux.getIsNew()) {
				tipoglobalclienteAux.setIsNew(false);
			}	
			
			if(tipoglobalclienteAux.getIsDeleted()) {
				tipoglobalclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoGlobalCliente(TipoGlobalCliente tipoglobalclienteAux) throws Exception {
		//this.tipoglobalclienteAux=tipoglobalclienteAux;
		
			if(tipoglobalclienteAux.getIsChanged()) {
				tipoglobalclienteAux.setIsChanged(false);
			}		
			
			if(tipoglobalclienteAux.getIsNew()) {
				tipoglobalclienteAux.setIsNew(false);
			}	
			
			if(tipoglobalclienteAux.getIsDeleted()) {
				tipoglobalclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoGlobalCliente tipoglobalclienteAsignar,TipoGlobalCliente tipoglobalcliente) throws Exception {
		tipoglobalclienteAsignar.setId(tipoglobalcliente.getId());	
		tipoglobalclienteAsignar.setVersionRow(tipoglobalcliente.getVersionRow());	
		tipoglobalclienteAsignar.setcodigo(tipoglobalcliente.getcodigo());	
		tipoglobalclienteAsignar.setnombre(tipoglobalcliente.getnombre());	
	}
	
	public static void inicializarTipoGlobalCliente(TipoGlobalCliente tipoglobalcliente) throws Exception {
		try {
				tipoglobalcliente.setId(0L);	
					
				tipoglobalcliente.setcodigo("");	
				tipoglobalcliente.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoGlobalCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGlobalClienteConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGlobalClienteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoGlobalCliente(String sTipo,Row row,Workbook workbook,TipoGlobalCliente tipoglobalcliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoglobalcliente.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoglobalcliente.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoGlobalCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoGlobalCliente() {
		return this.sFinalQueryTipoGlobalCliente;
	}
	
	public void setsFinalQueryTipoGlobalCliente(String sFinalQueryTipoGlobalCliente) {
		this.sFinalQueryTipoGlobalCliente= sFinalQueryTipoGlobalCliente;
	}
	
	public Border resaltarSeleccionarTipoGlobalCliente=null;
	
	public Border setResaltarSeleccionarTipoGlobalCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGlobalClienteBeanSwingJInternalFrame tipoglobalclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoglobalclienteBeanSwingJInternalFrame.jTtoolBarTipoGlobalCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoGlobalCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoGlobalCliente() {
		return this.resaltarSeleccionarTipoGlobalCliente;
	}
	
	public void setResaltarSeleccionarTipoGlobalCliente(Border borderResaltarSeleccionarTipoGlobalCliente) {
		this.resaltarSeleccionarTipoGlobalCliente= borderResaltarSeleccionarTipoGlobalCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoGlobalCliente=null;
	public Boolean mostraridTipoGlobalCliente=true;
	public Boolean activaridTipoGlobalCliente=true;

	public Border resaltarcodigoTipoGlobalCliente=null;
	public Boolean mostrarcodigoTipoGlobalCliente=true;
	public Boolean activarcodigoTipoGlobalCliente=true;

	public Border resaltarnombreTipoGlobalCliente=null;
	public Boolean mostrarnombreTipoGlobalCliente=true;
	public Boolean activarnombreTipoGlobalCliente=true;

	
	

	public Border setResaltaridTipoGlobalCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGlobalClienteBeanSwingJInternalFrame tipoglobalclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoglobalclienteBeanSwingJInternalFrame.jTtoolBarTipoGlobalCliente.setBorder(borderResaltar);
		
		this.resaltaridTipoGlobalCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoGlobalCliente() {
		return this.resaltaridTipoGlobalCliente;
	}

	public void setResaltaridTipoGlobalCliente(Border borderResaltar) {
		this.resaltaridTipoGlobalCliente= borderResaltar;
	}

	public Boolean getMostraridTipoGlobalCliente() {
		return this.mostraridTipoGlobalCliente;
	}

	public void setMostraridTipoGlobalCliente(Boolean mostraridTipoGlobalCliente) {
		this.mostraridTipoGlobalCliente= mostraridTipoGlobalCliente;
	}

	public Boolean getActivaridTipoGlobalCliente() {
		return this.activaridTipoGlobalCliente;
	}

	public void setActivaridTipoGlobalCliente(Boolean activaridTipoGlobalCliente) {
		this.activaridTipoGlobalCliente= activaridTipoGlobalCliente;
	}

	public Border setResaltarcodigoTipoGlobalCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGlobalClienteBeanSwingJInternalFrame tipoglobalclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoglobalclienteBeanSwingJInternalFrame.jTtoolBarTipoGlobalCliente.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoGlobalCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoGlobalCliente() {
		return this.resaltarcodigoTipoGlobalCliente;
	}

	public void setResaltarcodigoTipoGlobalCliente(Border borderResaltar) {
		this.resaltarcodigoTipoGlobalCliente= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoGlobalCliente() {
		return this.mostrarcodigoTipoGlobalCliente;
	}

	public void setMostrarcodigoTipoGlobalCliente(Boolean mostrarcodigoTipoGlobalCliente) {
		this.mostrarcodigoTipoGlobalCliente= mostrarcodigoTipoGlobalCliente;
	}

	public Boolean getActivarcodigoTipoGlobalCliente() {
		return this.activarcodigoTipoGlobalCliente;
	}

	public void setActivarcodigoTipoGlobalCliente(Boolean activarcodigoTipoGlobalCliente) {
		this.activarcodigoTipoGlobalCliente= activarcodigoTipoGlobalCliente;
	}

	public Border setResaltarnombreTipoGlobalCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGlobalClienteBeanSwingJInternalFrame tipoglobalclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoglobalclienteBeanSwingJInternalFrame.jTtoolBarTipoGlobalCliente.setBorder(borderResaltar);
		
		this.resaltarnombreTipoGlobalCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoGlobalCliente() {
		return this.resaltarnombreTipoGlobalCliente;
	}

	public void setResaltarnombreTipoGlobalCliente(Border borderResaltar) {
		this.resaltarnombreTipoGlobalCliente= borderResaltar;
	}

	public Boolean getMostrarnombreTipoGlobalCliente() {
		return this.mostrarnombreTipoGlobalCliente;
	}

	public void setMostrarnombreTipoGlobalCliente(Boolean mostrarnombreTipoGlobalCliente) {
		this.mostrarnombreTipoGlobalCliente= mostrarnombreTipoGlobalCliente;
	}

	public Boolean getActivarnombreTipoGlobalCliente() {
		return this.activarnombreTipoGlobalCliente;
	}

	public void setActivarnombreTipoGlobalCliente(Boolean activarnombreTipoGlobalCliente) {
		this.activarnombreTipoGlobalCliente= activarnombreTipoGlobalCliente;
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
		
		
		this.setMostraridTipoGlobalCliente(esInicial);
		this.setMostrarcodigoTipoGlobalCliente(esInicial);
		this.setMostrarnombreTipoGlobalCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGlobalClienteConstantesFunciones.ID)) {
				this.setMostraridTipoGlobalCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGlobalClienteConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoGlobalCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGlobalClienteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoGlobalCliente(esAsigna);
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
		
		
		this.setActivaridTipoGlobalCliente(esInicial);
		this.setActivarcodigoTipoGlobalCliente(esInicial);
		this.setActivarnombreTipoGlobalCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGlobalClienteConstantesFunciones.ID)) {
				this.setActivaridTipoGlobalCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGlobalClienteConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoGlobalCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGlobalClienteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoGlobalCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGlobalClienteBeanSwingJInternalFrame tipoglobalclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoGlobalCliente(esInicial);
		this.setResaltarcodigoTipoGlobalCliente(esInicial);
		this.setResaltarnombreTipoGlobalCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGlobalClienteConstantesFunciones.ID)) {
				this.setResaltaridTipoGlobalCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGlobalClienteConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoGlobalCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGlobalClienteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoGlobalCliente(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDefinicionTipoGlobalCliente=null;

	public Border getResaltarDefinicionTipoGlobalCliente() {
		return this.resaltarDefinicionTipoGlobalCliente;
	}

	public void setResaltarDefinicionTipoGlobalCliente(Border borderResaltarDefinicion) {
		if(borderResaltarDefinicion!=null) {
			this.resaltarDefinicionTipoGlobalCliente= borderResaltarDefinicion;
		}
	}

	public Border setResaltarDefinicionTipoGlobalCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGlobalClienteBeanSwingJInternalFrame tipoglobalclienteBeanSwingJInternalFrame*/) {
		Border borderResaltarDefinicion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoglobalclienteBeanSwingJInternalFrame.jTtoolBarTipoGlobalCliente.setBorder(borderResaltarDefinicion);
			
		this.resaltarDefinicionTipoGlobalCliente= borderResaltarDefinicion;

		 return borderResaltarDefinicion;
	}



	public Boolean mostrarDefinicionTipoGlobalCliente=true;

	public Boolean getMostrarDefinicionTipoGlobalCliente() {
		return this.mostrarDefinicionTipoGlobalCliente;
	}

	public void setMostrarDefinicionTipoGlobalCliente(Boolean visibilidadResaltarDefinicion) {
		this.mostrarDefinicionTipoGlobalCliente= visibilidadResaltarDefinicion;
	}



	public Boolean activarDefinicionTipoGlobalCliente=true;

	public Boolean gethabilitarResaltarDefinicionTipoGlobalCliente() {
		return this.activarDefinicionTipoGlobalCliente;
	}

	public void setActivarDefinicionTipoGlobalCliente(Boolean habilitarResaltarDefinicion) {
		this.activarDefinicionTipoGlobalCliente= habilitarResaltarDefinicion;
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

		this.setMostrarDefinicionTipoGlobalCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Definicion.class)) {
				this.setMostrarDefinicionTipoGlobalCliente(esAsigna);
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

		this.setActivarDefinicionTipoGlobalCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Definicion.class)) {
				this.setActivarDefinicionTipoGlobalCliente(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGlobalClienteBeanSwingJInternalFrame tipoglobalclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDefinicionTipoGlobalCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Definicion.class)) {
				this.setResaltarDefinicionTipoGlobalCliente(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}