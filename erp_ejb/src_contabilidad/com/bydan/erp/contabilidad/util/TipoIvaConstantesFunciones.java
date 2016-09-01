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


import com.bydan.erp.contabilidad.util.TipoIvaConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoIvaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoIvaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.sris.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoIvaConstantesFunciones extends TipoIvaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoIva";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoIva"+TipoIvaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoIvaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoIvaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoIvaConstantesFunciones.SCHEMA+"_"+TipoIvaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoIvaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoIvaConstantesFunciones.SCHEMA+"_"+TipoIvaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoIvaConstantesFunciones.SCHEMA+"_"+TipoIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoIvaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoIvaConstantesFunciones.SCHEMA+"_"+TipoIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoIvaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoIvaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoIvaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoIvaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoIvaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoIvaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoIvaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoIvaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Ivas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Iva";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Iva";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoIva";
	public static final String OBJECTNAME="tipoiva";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_iva";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoiva from "+TipoIvaConstantesFunciones.SPERSISTENCENAME+" tipoiva";
	public static String QUERYSELECTNATIVE="select "+TipoIvaConstantesFunciones.SCHEMA+"."+TipoIvaConstantesFunciones.TABLENAME+".id,"+TipoIvaConstantesFunciones.SCHEMA+"."+TipoIvaConstantesFunciones.TABLENAME+".version_row,"+TipoIvaConstantesFunciones.SCHEMA+"."+TipoIvaConstantesFunciones.TABLENAME+".codigo,"+TipoIvaConstantesFunciones.SCHEMA+"."+TipoIvaConstantesFunciones.TABLENAME+".nombre from "+TipoIvaConstantesFunciones.SCHEMA+"."+TipoIvaConstantesFunciones.TABLENAME;//+" as "+TipoIvaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoIvaConstantesFuncionesAdditional tipoivaConstantesFuncionesAdditional=null;
	
	public TipoIvaConstantesFuncionesAdditional getTipoIvaConstantesFuncionesAdditional() {
		return this.tipoivaConstantesFuncionesAdditional;
	}
	
	public void setTipoIvaConstantesFuncionesAdditional(TipoIvaConstantesFuncionesAdditional tipoivaConstantesFuncionesAdditional) {
		try {
			this.tipoivaConstantesFuncionesAdditional=tipoivaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
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
	
	public static String getTipoIvaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoIvaConstantesFunciones.CODIGO)) {sLabelColumna=TipoIvaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoIvaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoIvaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoIvaDescripcion(TipoIva tipoiva) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoiva !=null/* && tipoiva.getId()!=0*/) {
			sDescripcion=tipoiva.getnombre();//tipoivatipoiva.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoIvaDescripcionDetallado(TipoIva tipoiva) {
		String sDescripcion="";
			
		sDescripcion+=TipoIvaConstantesFunciones.ID+"=";
		sDescripcion+=tipoiva.getId().toString()+",";
		sDescripcion+=TipoIvaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoiva.getVersionRow().toString()+",";
		sDescripcion+=TipoIvaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoiva.getcodigo()+",";
		sDescripcion+=TipoIvaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoiva.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoIvaDescripcion(TipoIva tipoiva,String sValor) throws Exception {			
		if(tipoiva !=null) {
			tipoiva.setnombre(sValor);;//tipoivatipoiva.getnombre().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("PorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndicePorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoIva(TipoIva tipoiva,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoiva.setcodigo(tipoiva.getcodigo().trim());
		tipoiva.setnombre(tipoiva.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoIvas(List<TipoIva> tipoivas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoIva tipoiva: tipoivas) {
			tipoiva.setcodigo(tipoiva.getcodigo().trim());
			tipoiva.setnombre(tipoiva.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoIva(TipoIva tipoiva,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoiva.getConCambioAuxiliar()) {
			tipoiva.setIsDeleted(tipoiva.getIsDeletedAuxiliar());	
			tipoiva.setIsNew(tipoiva.getIsNewAuxiliar());	
			tipoiva.setIsChanged(tipoiva.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoiva.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoiva.setIsDeletedAuxiliar(false);	
			tipoiva.setIsNewAuxiliar(false);	
			tipoiva.setIsChangedAuxiliar(false);
			
			tipoiva.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoIvas(List<TipoIva> tipoivas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoIva tipoiva : tipoivas) {
			if(conAsignarBase && tipoiva.getConCambioAuxiliar()) {
				tipoiva.setIsDeleted(tipoiva.getIsDeletedAuxiliar());	
				tipoiva.setIsNew(tipoiva.getIsNewAuxiliar());	
				tipoiva.setIsChanged(tipoiva.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoiva.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoiva.setIsDeletedAuxiliar(false);	
				tipoiva.setIsNewAuxiliar(false);	
				tipoiva.setIsChangedAuxiliar(false);
				
				tipoiva.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoIva(TipoIva tipoiva,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoIvas(List<TipoIva> tipoivas,Boolean conEnteros) throws Exception  {
		
		for(TipoIva tipoiva: tipoivas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoIva(List<TipoIva> tipoivas,TipoIva tipoivaAux) throws Exception  {
		TipoIvaConstantesFunciones.InicializarValoresTipoIva(tipoivaAux,true);
		
		for(TipoIva tipoiva: tipoivas) {
			if(tipoiva.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoIva(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoIvaConstantesFunciones.getArrayColumnasGlobalesTipoIva(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoIva(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoIva(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoIva> tipoivas,TipoIva tipoiva,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoIva tipoivaAux: tipoivas) {
			if(tipoivaAux!=null && tipoiva!=null) {
				if((tipoivaAux.getId()==null && tipoiva.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoivaAux.getId()!=null && tipoiva.getId()!=null){
					if(tipoivaAux.getId().equals(tipoiva.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoIva(List<TipoIva> tipoivas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoIva tipoiva: tipoivas) {			
			if(tipoiva.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoIva() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoIvaConstantesFunciones.LABEL_ID, TipoIvaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoIvaConstantesFunciones.LABEL_VERSIONROW, TipoIvaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoIvaConstantesFunciones.LABEL_CODIGO, TipoIvaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoIvaConstantesFunciones.LABEL_NOMBRE, TipoIvaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoIva() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoIvaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoIvaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoIvaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoIvaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoIva() throws Exception  {
		return TipoIvaConstantesFunciones.getTiposSeleccionarTipoIva(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoIva(Boolean conFk) throws Exception  {
		return TipoIvaConstantesFunciones.getTiposSeleccionarTipoIva(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoIva(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoIvaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoIvaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoIvaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoIvaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoIva(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoIva(TipoIva tipoivaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoIva(List<TipoIva> tipoivasTemp) throws Exception {
		for(TipoIva tipoivaAux:tipoivasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoIvaConstantesFunciones.getClassesRelationshipsOfTipoIva(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Sri.class));
				classes.add(new Classe(ImportarExportar.class));
				classes.add(new Classe(TransaccionLocal.class));
				classes.add(new Classe(FacturaDiario.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Sri.class)) {
						classes.add(new Classe(Sri.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ImportarExportar.class)) {
						classes.add(new Classe(ImportarExportar.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TransaccionLocal.class)) {
						classes.add(new Classe(TransaccionLocal.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FacturaDiario.class)) {
						classes.add(new Classe(FacturaDiario.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoIvaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoIva(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Sri.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sri.class)); continue;
					}

					if(ImportarExportar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ImportarExportar.class)); continue;
					}

					if(TransaccionLocal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TransaccionLocal.class)); continue;
					}

					if(FacturaDiario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaDiario.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Sri.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sri.class)); continue;
					}

					if(ImportarExportar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ImportarExportar.class)); continue;
					}

					if(TransaccionLocal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TransaccionLocal.class)); continue;
					}

					if(FacturaDiario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaDiario.class)); continue;
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
	public static void actualizarLista(TipoIva tipoiva,List<TipoIva> tipoivas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoIva tipoivaEncontrado=null;
			
			for(TipoIva tipoivaLocal:tipoivas) {
				if(tipoivaLocal.getId().equals(tipoiva.getId())) {
					tipoivaEncontrado=tipoivaLocal;
					
					tipoivaLocal.setIsChanged(tipoiva.getIsChanged());
					tipoivaLocal.setIsNew(tipoiva.getIsNew());
					tipoivaLocal.setIsDeleted(tipoiva.getIsDeleted());
					
					tipoivaLocal.setGeneralEntityOriginal(tipoiva.getGeneralEntityOriginal());
					
					tipoivaLocal.setId(tipoiva.getId());	
					tipoivaLocal.setVersionRow(tipoiva.getVersionRow());	
					tipoivaLocal.setcodigo(tipoiva.getcodigo());	
					tipoivaLocal.setnombre(tipoiva.getnombre());	
					
					
					tipoivaLocal.setTransaccionLocals(tipoiva.getTransaccionLocals());
					tipoivaLocal.setFacturaDiarios(tipoiva.getFacturaDiarios());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoiva.getIsDeleted()) {
				if(!existe) {
					tipoivas.add(tipoiva);
				}
			} else {
				if(tipoivaEncontrado!=null && permiteQuitar)  {
					tipoivas.remove(tipoivaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoIva tipoiva,List<TipoIva> tipoivas) throws Exception {
		try	{			
			for(TipoIva tipoivaLocal:tipoivas) {
				if(tipoivaLocal.getId().equals(tipoiva.getId())) {
					tipoivaLocal.setIsSelected(tipoiva.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoIva(List<TipoIva> tipoivasAux) throws Exception {
		//this.tipoivasAux=tipoivasAux;
		
		for(TipoIva tipoivaAux:tipoivasAux) {
			if(tipoivaAux.getIsChanged()) {
				tipoivaAux.setIsChanged(false);
			}		
			
			if(tipoivaAux.getIsNew()) {
				tipoivaAux.setIsNew(false);
			}	
			
			if(tipoivaAux.getIsDeleted()) {
				tipoivaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoIva(TipoIva tipoivaAux) throws Exception {
		//this.tipoivaAux=tipoivaAux;
		
			if(tipoivaAux.getIsChanged()) {
				tipoivaAux.setIsChanged(false);
			}		
			
			if(tipoivaAux.getIsNew()) {
				tipoivaAux.setIsNew(false);
			}	
			
			if(tipoivaAux.getIsDeleted()) {
				tipoivaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoIva tipoivaAsignar,TipoIva tipoiva) throws Exception {
		tipoivaAsignar.setId(tipoiva.getId());	
		tipoivaAsignar.setVersionRow(tipoiva.getVersionRow());	
		tipoivaAsignar.setcodigo(tipoiva.getcodigo());	
		tipoivaAsignar.setnombre(tipoiva.getnombre());	
	}
	
	public static void inicializarTipoIva(TipoIva tipoiva) throws Exception {
		try {
				tipoiva.setId(0L);	
					
				tipoiva.setcodigo("");	
				tipoiva.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoIva(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoIvaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoIvaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoIva(String sTipo,Row row,Workbook workbook,TipoIva tipoiva,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoiva.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoiva.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoIva=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoIva() {
		return this.sFinalQueryTipoIva;
	}
	
	public void setsFinalQueryTipoIva(String sFinalQueryTipoIva) {
		this.sFinalQueryTipoIva= sFinalQueryTipoIva;
	}
	
	public Border resaltarSeleccionarTipoIva=null;
	
	public Border setResaltarSeleccionarTipoIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIvaBeanSwingJInternalFrame tipoivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoivaBeanSwingJInternalFrame.jTtoolBarTipoIva.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoIva= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoIva() {
		return this.resaltarSeleccionarTipoIva;
	}
	
	public void setResaltarSeleccionarTipoIva(Border borderResaltarSeleccionarTipoIva) {
		this.resaltarSeleccionarTipoIva= borderResaltarSeleccionarTipoIva;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoIva=null;
	public Boolean mostraridTipoIva=true;
	public Boolean activaridTipoIva=true;

	public Border resaltarcodigoTipoIva=null;
	public Boolean mostrarcodigoTipoIva=true;
	public Boolean activarcodigoTipoIva=true;

	public Border resaltarnombreTipoIva=null;
	public Boolean mostrarnombreTipoIva=true;
	public Boolean activarnombreTipoIva=true;

	
	

	public Border setResaltaridTipoIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIvaBeanSwingJInternalFrame tipoivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoivaBeanSwingJInternalFrame.jTtoolBarTipoIva.setBorder(borderResaltar);
		
		this.resaltaridTipoIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoIva() {
		return this.resaltaridTipoIva;
	}

	public void setResaltaridTipoIva(Border borderResaltar) {
		this.resaltaridTipoIva= borderResaltar;
	}

	public Boolean getMostraridTipoIva() {
		return this.mostraridTipoIva;
	}

	public void setMostraridTipoIva(Boolean mostraridTipoIva) {
		this.mostraridTipoIva= mostraridTipoIva;
	}

	public Boolean getActivaridTipoIva() {
		return this.activaridTipoIva;
	}

	public void setActivaridTipoIva(Boolean activaridTipoIva) {
		this.activaridTipoIva= activaridTipoIva;
	}

	public Border setResaltarcodigoTipoIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIvaBeanSwingJInternalFrame tipoivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoivaBeanSwingJInternalFrame.jTtoolBarTipoIva.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoIva() {
		return this.resaltarcodigoTipoIva;
	}

	public void setResaltarcodigoTipoIva(Border borderResaltar) {
		this.resaltarcodigoTipoIva= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoIva() {
		return this.mostrarcodigoTipoIva;
	}

	public void setMostrarcodigoTipoIva(Boolean mostrarcodigoTipoIva) {
		this.mostrarcodigoTipoIva= mostrarcodigoTipoIva;
	}

	public Boolean getActivarcodigoTipoIva() {
		return this.activarcodigoTipoIva;
	}

	public void setActivarcodigoTipoIva(Boolean activarcodigoTipoIva) {
		this.activarcodigoTipoIva= activarcodigoTipoIva;
	}

	public Border setResaltarnombreTipoIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIvaBeanSwingJInternalFrame tipoivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoivaBeanSwingJInternalFrame.jTtoolBarTipoIva.setBorder(borderResaltar);
		
		this.resaltarnombreTipoIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoIva() {
		return this.resaltarnombreTipoIva;
	}

	public void setResaltarnombreTipoIva(Border borderResaltar) {
		this.resaltarnombreTipoIva= borderResaltar;
	}

	public Boolean getMostrarnombreTipoIva() {
		return this.mostrarnombreTipoIva;
	}

	public void setMostrarnombreTipoIva(Boolean mostrarnombreTipoIva) {
		this.mostrarnombreTipoIva= mostrarnombreTipoIva;
	}

	public Boolean getActivarnombreTipoIva() {
		return this.activarnombreTipoIva;
	}

	public void setActivarnombreTipoIva(Boolean activarnombreTipoIva) {
		this.activarnombreTipoIva= activarnombreTipoIva;
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
		
		
		this.setMostraridTipoIva(esInicial);
		this.setMostrarcodigoTipoIva(esInicial);
		this.setMostrarnombreTipoIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoIvaConstantesFunciones.ID)) {
				this.setMostraridTipoIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIvaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIvaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoIva(esAsigna);
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
		
		
		this.setActivaridTipoIva(esInicial);
		this.setActivarcodigoTipoIva(esInicial);
		this.setActivarnombreTipoIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoIvaConstantesFunciones.ID)) {
				this.setActivaridTipoIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIvaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIvaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoIva(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoIvaBeanSwingJInternalFrame tipoivaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoIva(esInicial);
		this.setResaltarcodigoTipoIva(esInicial);
		this.setResaltarnombreTipoIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoIvaConstantesFunciones.ID)) {
				this.setResaltaridTipoIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIvaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIvaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoIva(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarTransaccionLocalTipoIva=null;

	public Border getResaltarTransaccionLocalTipoIva() {
		return this.resaltarTransaccionLocalTipoIva;
	}

	public void setResaltarTransaccionLocalTipoIva(Border borderResaltarTransaccionLocal) {
		if(borderResaltarTransaccionLocal!=null) {
			this.resaltarTransaccionLocalTipoIva= borderResaltarTransaccionLocal;
		}
	}

	public Border setResaltarTransaccionLocalTipoIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIvaBeanSwingJInternalFrame tipoivaBeanSwingJInternalFrame*/) {
		Border borderResaltarTransaccionLocal=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoivaBeanSwingJInternalFrame.jTtoolBarTipoIva.setBorder(borderResaltarTransaccionLocal);
			
		this.resaltarTransaccionLocalTipoIva= borderResaltarTransaccionLocal;

		 return borderResaltarTransaccionLocal;
	}



	public Boolean mostrarTransaccionLocalTipoIva=true;

	public Boolean getMostrarTransaccionLocalTipoIva() {
		return this.mostrarTransaccionLocalTipoIva;
	}

	public void setMostrarTransaccionLocalTipoIva(Boolean visibilidadResaltarTransaccionLocal) {
		this.mostrarTransaccionLocalTipoIva= visibilidadResaltarTransaccionLocal;
	}



	public Boolean activarTransaccionLocalTipoIva=true;

	public Boolean gethabilitarResaltarTransaccionLocalTipoIva() {
		return this.activarTransaccionLocalTipoIva;
	}

	public void setActivarTransaccionLocalTipoIva(Boolean habilitarResaltarTransaccionLocal) {
		this.activarTransaccionLocalTipoIva= habilitarResaltarTransaccionLocal;
	}


	public Border resaltarFacturaDiarioTipoIva=null;

	public Border getResaltarFacturaDiarioTipoIva() {
		return this.resaltarFacturaDiarioTipoIva;
	}

	public void setResaltarFacturaDiarioTipoIva(Border borderResaltarFacturaDiario) {
		if(borderResaltarFacturaDiario!=null) {
			this.resaltarFacturaDiarioTipoIva= borderResaltarFacturaDiario;
		}
	}

	public Border setResaltarFacturaDiarioTipoIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIvaBeanSwingJInternalFrame tipoivaBeanSwingJInternalFrame*/) {
		Border borderResaltarFacturaDiario=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoivaBeanSwingJInternalFrame.jTtoolBarTipoIva.setBorder(borderResaltarFacturaDiario);
			
		this.resaltarFacturaDiarioTipoIva= borderResaltarFacturaDiario;

		 return borderResaltarFacturaDiario;
	}



	public Boolean mostrarFacturaDiarioTipoIva=true;

	public Boolean getMostrarFacturaDiarioTipoIva() {
		return this.mostrarFacturaDiarioTipoIva;
	}

	public void setMostrarFacturaDiarioTipoIva(Boolean visibilidadResaltarFacturaDiario) {
		this.mostrarFacturaDiarioTipoIva= visibilidadResaltarFacturaDiario;
	}



	public Boolean activarFacturaDiarioTipoIva=true;

	public Boolean gethabilitarResaltarFacturaDiarioTipoIva() {
		return this.activarFacturaDiarioTipoIva;
	}

	public void setActivarFacturaDiarioTipoIva(Boolean habilitarResaltarFacturaDiario) {
		this.activarFacturaDiarioTipoIva= habilitarResaltarFacturaDiario;
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

		this.setMostrarTransaccionLocalTipoIva(esInicial);
		this.setMostrarFacturaDiarioTipoIva(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TransaccionLocal.class)) {
				this.setMostrarTransaccionLocalTipoIva(esAsigna);
				continue;
			}

			if(clase.clas.equals(FacturaDiario.class)) {
				this.setMostrarFacturaDiarioTipoIva(esAsigna);
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

		this.setActivarTransaccionLocalTipoIva(esInicial);
		this.setActivarFacturaDiarioTipoIva(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TransaccionLocal.class)) {
				this.setActivarTransaccionLocalTipoIva(esAsigna);
				continue;
			}

			if(clase.clas.equals(FacturaDiario.class)) {
				this.setActivarFacturaDiarioTipoIva(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoIvaBeanSwingJInternalFrame tipoivaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarTransaccionLocalTipoIva(esInicial);
		this.setResaltarFacturaDiarioTipoIva(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TransaccionLocal.class)) {
				this.setResaltarTransaccionLocalTipoIva(esAsigna);
				continue;
			}

			if(clase.clas.equals(FacturaDiario.class)) {
				this.setResaltarFacturaDiarioTipoIva(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}