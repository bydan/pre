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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.TipoUnidadConstantesFunciones;
import com.bydan.erp.inventario.util.TipoUnidadParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoUnidadParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.importaciones.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoUnidadConstantesFunciones extends TipoUnidadConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoUnidad";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoUnidad"+TipoUnidadConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoUnidadHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoUnidadHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoUnidadConstantesFunciones.SCHEMA+"_"+TipoUnidadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoUnidadHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoUnidadConstantesFunciones.SCHEMA+"_"+TipoUnidadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoUnidadConstantesFunciones.SCHEMA+"_"+TipoUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoUnidadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoUnidadConstantesFunciones.SCHEMA+"_"+TipoUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoUnidadHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoUnidadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoUnidadConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoUnidadConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoUnidadConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoUnidadConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Unidades";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Unidad";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Unidad";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoUnidad";
	public static final String OBJECTNAME="tipounidad";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="tipo_unidad";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipounidad from "+TipoUnidadConstantesFunciones.SPERSISTENCENAME+" tipounidad";
	public static String QUERYSELECTNATIVE="select "+TipoUnidadConstantesFunciones.SCHEMA+"."+TipoUnidadConstantesFunciones.TABLENAME+".id,"+TipoUnidadConstantesFunciones.SCHEMA+"."+TipoUnidadConstantesFunciones.TABLENAME+".version_row,"+TipoUnidadConstantesFunciones.SCHEMA+"."+TipoUnidadConstantesFunciones.TABLENAME+".nombre,"+TipoUnidadConstantesFunciones.SCHEMA+"."+TipoUnidadConstantesFunciones.TABLENAME+".siglas from "+TipoUnidadConstantesFunciones.SCHEMA+"."+TipoUnidadConstantesFunciones.TABLENAME;//+" as "+TipoUnidadConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoUnidadConstantesFuncionesAdditional tipounidadConstantesFuncionesAdditional=null;
	
	public TipoUnidadConstantesFuncionesAdditional getTipoUnidadConstantesFuncionesAdditional() {
		return this.tipounidadConstantesFuncionesAdditional;
	}
	
	public void setTipoUnidadConstantesFuncionesAdditional(TipoUnidadConstantesFuncionesAdditional tipounidadConstantesFuncionesAdditional) {
		try {
			this.tipounidadConstantesFuncionesAdditional=tipounidadConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NOMBRE= "nombre";
    public static final String SIGLAS= "siglas";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_SIGLAS= "Siglas";
		public static final String LABEL_SIGLAS_LOWER= "Siglas";
	
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSIGLAS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSIGLAS=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoUnidadLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoUnidadConstantesFunciones.NOMBRE)) {sLabelColumna=TipoUnidadConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoUnidadConstantesFunciones.SIGLAS)) {sLabelColumna=TipoUnidadConstantesFunciones.LABEL_SIGLAS;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoUnidadDescripcion(TipoUnidad tipounidad) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipounidad !=null/* && tipounidad.getId()!=0*/) {
			sDescripcion=tipounidad.getnombre();//tipounidadtipounidad.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoUnidadDescripcionDetallado(TipoUnidad tipounidad) {
		String sDescripcion="";
			
		sDescripcion+=TipoUnidadConstantesFunciones.ID+"=";
		sDescripcion+=tipounidad.getId().toString()+",";
		sDescripcion+=TipoUnidadConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipounidad.getVersionRow().toString()+",";
		sDescripcion+=TipoUnidadConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipounidad.getnombre()+",";
		sDescripcion+=TipoUnidadConstantesFunciones.SIGLAS+"=";
		sDescripcion+=tipounidad.getsiglas()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoUnidadDescripcion(TipoUnidad tipounidad,String sValor) throws Exception {			
		if(tipounidad !=null) {
			tipounidad.setnombre(sValor);;//tipounidadtipounidad.getnombre().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("BusquedaPorSiglas")) {
			sNombreIndice="Tipo=  Por Siglas";
		} else if(sNombreIndice.equals("PorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorSiglas(String siglas) {
		String sDetalleIndice=" Parametros->";
		if(siglas!=null) {sDetalleIndice+=" Siglas="+siglas;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoUnidad(TipoUnidad tipounidad,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipounidad.setnombre(tipounidad.getnombre().trim());
		tipounidad.setsiglas(tipounidad.getsiglas().trim());
	}
	
	public static void quitarEspaciosTipoUnidads(List<TipoUnidad> tipounidads,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoUnidad tipounidad: tipounidads) {
			tipounidad.setnombre(tipounidad.getnombre().trim());
			tipounidad.setsiglas(tipounidad.getsiglas().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoUnidad(TipoUnidad tipounidad,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipounidad.getConCambioAuxiliar()) {
			tipounidad.setIsDeleted(tipounidad.getIsDeletedAuxiliar());	
			tipounidad.setIsNew(tipounidad.getIsNewAuxiliar());	
			tipounidad.setIsChanged(tipounidad.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipounidad.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipounidad.setIsDeletedAuxiliar(false);	
			tipounidad.setIsNewAuxiliar(false);	
			tipounidad.setIsChangedAuxiliar(false);
			
			tipounidad.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoUnidads(List<TipoUnidad> tipounidads,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoUnidad tipounidad : tipounidads) {
			if(conAsignarBase && tipounidad.getConCambioAuxiliar()) {
				tipounidad.setIsDeleted(tipounidad.getIsDeletedAuxiliar());	
				tipounidad.setIsNew(tipounidad.getIsNewAuxiliar());	
				tipounidad.setIsChanged(tipounidad.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipounidad.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipounidad.setIsDeletedAuxiliar(false);	
				tipounidad.setIsNewAuxiliar(false);	
				tipounidad.setIsChangedAuxiliar(false);
				
				tipounidad.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoUnidad(TipoUnidad tipounidad,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoUnidads(List<TipoUnidad> tipounidads,Boolean conEnteros) throws Exception  {
		
		for(TipoUnidad tipounidad: tipounidads) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoUnidad(List<TipoUnidad> tipounidads,TipoUnidad tipounidadAux) throws Exception  {
		TipoUnidadConstantesFunciones.InicializarValoresTipoUnidad(tipounidadAux,true);
		
		for(TipoUnidad tipounidad: tipounidads) {
			if(tipounidad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoUnidad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoUnidadConstantesFunciones.getArrayColumnasGlobalesTipoUnidad(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoUnidad(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoUnidad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoUnidad> tipounidads,TipoUnidad tipounidad,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoUnidad tipounidadAux: tipounidads) {
			if(tipounidadAux!=null && tipounidad!=null) {
				if((tipounidadAux.getId()==null && tipounidad.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipounidadAux.getId()!=null && tipounidad.getId()!=null){
					if(tipounidadAux.getId().equals(tipounidad.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoUnidad(List<TipoUnidad> tipounidads) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoUnidad tipounidad: tipounidads) {			
			if(tipounidad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoUnidad() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoUnidadConstantesFunciones.LABEL_ID, TipoUnidadConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoUnidadConstantesFunciones.LABEL_VERSIONROW, TipoUnidadConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoUnidadConstantesFunciones.LABEL_NOMBRE, TipoUnidadConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoUnidadConstantesFunciones.LABEL_SIGLAS, TipoUnidadConstantesFunciones.SIGLAS,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoUnidad() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoUnidadConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoUnidadConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoUnidadConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoUnidadConstantesFunciones.SIGLAS;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoUnidad() throws Exception  {
		return TipoUnidadConstantesFunciones.getTiposSeleccionarTipoUnidad(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoUnidad(Boolean conFk) throws Exception  {
		return TipoUnidadConstantesFunciones.getTiposSeleccionarTipoUnidad(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoUnidad(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoUnidadConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoUnidadConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoUnidadConstantesFunciones.LABEL_SIGLAS);
			reporte.setsDescripcion(TipoUnidadConstantesFunciones.LABEL_SIGLAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoUnidad(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoUnidad(TipoUnidad tipounidadAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoUnidad(List<TipoUnidad> tipounidadsTemp) throws Exception {
		for(TipoUnidad tipounidadAux:tipounidadsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoUnidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoUnidadConstantesFunciones.getClassesRelationshipsOfTipoUnidad(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Unidad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Unidad.class)) {
						classes.add(new Classe(Unidad.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoUnidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoUnidadConstantesFunciones.getClassesRelationshipsFromStringsOfTipoUnidad(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoUnidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
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
	public static void actualizarLista(TipoUnidad tipounidad,List<TipoUnidad> tipounidads,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoUnidad tipounidadEncontrado=null;
			
			for(TipoUnidad tipounidadLocal:tipounidads) {
				if(tipounidadLocal.getId().equals(tipounidad.getId())) {
					tipounidadEncontrado=tipounidadLocal;
					
					tipounidadLocal.setIsChanged(tipounidad.getIsChanged());
					tipounidadLocal.setIsNew(tipounidad.getIsNew());
					tipounidadLocal.setIsDeleted(tipounidad.getIsDeleted());
					
					tipounidadLocal.setGeneralEntityOriginal(tipounidad.getGeneralEntityOriginal());
					
					tipounidadLocal.setId(tipounidad.getId());	
					tipounidadLocal.setVersionRow(tipounidad.getVersionRow());	
					tipounidadLocal.setnombre(tipounidad.getnombre());	
					tipounidadLocal.setsiglas(tipounidad.getsiglas());	
					
					
					tipounidadLocal.setUnidads(tipounidad.getUnidads());
					
					existe=true;
					break;
				}
			}
			
			if(!tipounidad.getIsDeleted()) {
				if(!existe) {
					tipounidads.add(tipounidad);
				}
			} else {
				if(tipounidadEncontrado!=null && permiteQuitar)  {
					tipounidads.remove(tipounidadEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoUnidad tipounidad,List<TipoUnidad> tipounidads) throws Exception {
		try	{			
			for(TipoUnidad tipounidadLocal:tipounidads) {
				if(tipounidadLocal.getId().equals(tipounidad.getId())) {
					tipounidadLocal.setIsSelected(tipounidad.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoUnidad(List<TipoUnidad> tipounidadsAux) throws Exception {
		//this.tipounidadsAux=tipounidadsAux;
		
		for(TipoUnidad tipounidadAux:tipounidadsAux) {
			if(tipounidadAux.getIsChanged()) {
				tipounidadAux.setIsChanged(false);
			}		
			
			if(tipounidadAux.getIsNew()) {
				tipounidadAux.setIsNew(false);
			}	
			
			if(tipounidadAux.getIsDeleted()) {
				tipounidadAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoUnidad(TipoUnidad tipounidadAux) throws Exception {
		//this.tipounidadAux=tipounidadAux;
		
			if(tipounidadAux.getIsChanged()) {
				tipounidadAux.setIsChanged(false);
			}		
			
			if(tipounidadAux.getIsNew()) {
				tipounidadAux.setIsNew(false);
			}	
			
			if(tipounidadAux.getIsDeleted()) {
				tipounidadAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoUnidad tipounidadAsignar,TipoUnidad tipounidad) throws Exception {
		tipounidadAsignar.setId(tipounidad.getId());	
		tipounidadAsignar.setVersionRow(tipounidad.getVersionRow());	
		tipounidadAsignar.setnombre(tipounidad.getnombre());	
		tipounidadAsignar.setsiglas(tipounidad.getsiglas());	
	}
	
	public static void inicializarTipoUnidad(TipoUnidad tipounidad) throws Exception {
		try {
				tipounidad.setId(0L);	
					
				tipounidad.setnombre("");	
				tipounidad.setsiglas("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoUnidad(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoUnidadConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoUnidadConstantesFunciones.LABEL_SIGLAS);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoUnidad(String sTipo,Row row,Workbook workbook,TipoUnidad tipounidad,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipounidad.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipounidad.getsiglas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoUnidad=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoUnidad() {
		return this.sFinalQueryTipoUnidad;
	}
	
	public void setsFinalQueryTipoUnidad(String sFinalQueryTipoUnidad) {
		this.sFinalQueryTipoUnidad= sFinalQueryTipoUnidad;
	}
	
	public Border resaltarSeleccionarTipoUnidad=null;
	
	public Border setResaltarSeleccionarTipoUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoUnidadBeanSwingJInternalFrame tipounidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipounidadBeanSwingJInternalFrame.jTtoolBarTipoUnidad.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoUnidad= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoUnidad() {
		return this.resaltarSeleccionarTipoUnidad;
	}
	
	public void setResaltarSeleccionarTipoUnidad(Border borderResaltarSeleccionarTipoUnidad) {
		this.resaltarSeleccionarTipoUnidad= borderResaltarSeleccionarTipoUnidad;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoUnidad=null;
	public Boolean mostraridTipoUnidad=true;
	public Boolean activaridTipoUnidad=true;

	public Border resaltarnombreTipoUnidad=null;
	public Boolean mostrarnombreTipoUnidad=true;
	public Boolean activarnombreTipoUnidad=true;

	public Border resaltarsiglasTipoUnidad=null;
	public Boolean mostrarsiglasTipoUnidad=true;
	public Boolean activarsiglasTipoUnidad=true;

	
	

	public Border setResaltaridTipoUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoUnidadBeanSwingJInternalFrame tipounidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipounidadBeanSwingJInternalFrame.jTtoolBarTipoUnidad.setBorder(borderResaltar);
		
		this.resaltaridTipoUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoUnidad() {
		return this.resaltaridTipoUnidad;
	}

	public void setResaltaridTipoUnidad(Border borderResaltar) {
		this.resaltaridTipoUnidad= borderResaltar;
	}

	public Boolean getMostraridTipoUnidad() {
		return this.mostraridTipoUnidad;
	}

	public void setMostraridTipoUnidad(Boolean mostraridTipoUnidad) {
		this.mostraridTipoUnidad= mostraridTipoUnidad;
	}

	public Boolean getActivaridTipoUnidad() {
		return this.activaridTipoUnidad;
	}

	public void setActivaridTipoUnidad(Boolean activaridTipoUnidad) {
		this.activaridTipoUnidad= activaridTipoUnidad;
	}

	public Border setResaltarnombreTipoUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoUnidadBeanSwingJInternalFrame tipounidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipounidadBeanSwingJInternalFrame.jTtoolBarTipoUnidad.setBorder(borderResaltar);
		
		this.resaltarnombreTipoUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoUnidad() {
		return this.resaltarnombreTipoUnidad;
	}

	public void setResaltarnombreTipoUnidad(Border borderResaltar) {
		this.resaltarnombreTipoUnidad= borderResaltar;
	}

	public Boolean getMostrarnombreTipoUnidad() {
		return this.mostrarnombreTipoUnidad;
	}

	public void setMostrarnombreTipoUnidad(Boolean mostrarnombreTipoUnidad) {
		this.mostrarnombreTipoUnidad= mostrarnombreTipoUnidad;
	}

	public Boolean getActivarnombreTipoUnidad() {
		return this.activarnombreTipoUnidad;
	}

	public void setActivarnombreTipoUnidad(Boolean activarnombreTipoUnidad) {
		this.activarnombreTipoUnidad= activarnombreTipoUnidad;
	}

	public Border setResaltarsiglasTipoUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoUnidadBeanSwingJInternalFrame tipounidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipounidadBeanSwingJInternalFrame.jTtoolBarTipoUnidad.setBorder(borderResaltar);
		
		this.resaltarsiglasTipoUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsiglasTipoUnidad() {
		return this.resaltarsiglasTipoUnidad;
	}

	public void setResaltarsiglasTipoUnidad(Border borderResaltar) {
		this.resaltarsiglasTipoUnidad= borderResaltar;
	}

	public Boolean getMostrarsiglasTipoUnidad() {
		return this.mostrarsiglasTipoUnidad;
	}

	public void setMostrarsiglasTipoUnidad(Boolean mostrarsiglasTipoUnidad) {
		this.mostrarsiglasTipoUnidad= mostrarsiglasTipoUnidad;
	}

	public Boolean getActivarsiglasTipoUnidad() {
		return this.activarsiglasTipoUnidad;
	}

	public void setActivarsiglasTipoUnidad(Boolean activarsiglasTipoUnidad) {
		this.activarsiglasTipoUnidad= activarsiglasTipoUnidad;
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
		
		
		this.setMostraridTipoUnidad(esInicial);
		this.setMostrarnombreTipoUnidad(esInicial);
		this.setMostrarsiglasTipoUnidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoUnidadConstantesFunciones.ID)) {
				this.setMostraridTipoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoUnidadConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoUnidadConstantesFunciones.SIGLAS)) {
				this.setMostrarsiglasTipoUnidad(esAsigna);
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
		
		
		this.setActivaridTipoUnidad(esInicial);
		this.setActivarnombreTipoUnidad(esInicial);
		this.setActivarsiglasTipoUnidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoUnidadConstantesFunciones.ID)) {
				this.setActivaridTipoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoUnidadConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoUnidadConstantesFunciones.SIGLAS)) {
				this.setActivarsiglasTipoUnidad(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoUnidadBeanSwingJInternalFrame tipounidadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoUnidad(esInicial);
		this.setResaltarnombreTipoUnidad(esInicial);
		this.setResaltarsiglasTipoUnidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoUnidadConstantesFunciones.ID)) {
				this.setResaltaridTipoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoUnidadConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoUnidadConstantesFunciones.SIGLAS)) {
				this.setResaltarsiglasTipoUnidad(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarUnidadTipoUnidad=null;

	public Border getResaltarUnidadTipoUnidad() {
		return this.resaltarUnidadTipoUnidad;
	}

	public void setResaltarUnidadTipoUnidad(Border borderResaltarUnidad) {
		if(borderResaltarUnidad!=null) {
			this.resaltarUnidadTipoUnidad= borderResaltarUnidad;
		}
	}

	public Border setResaltarUnidadTipoUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoUnidadBeanSwingJInternalFrame tipounidadBeanSwingJInternalFrame*/) {
		Border borderResaltarUnidad=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipounidadBeanSwingJInternalFrame.jTtoolBarTipoUnidad.setBorder(borderResaltarUnidad);
			
		this.resaltarUnidadTipoUnidad= borderResaltarUnidad;

		 return borderResaltarUnidad;
	}



	public Boolean mostrarUnidadTipoUnidad=true;

	public Boolean getMostrarUnidadTipoUnidad() {
		return this.mostrarUnidadTipoUnidad;
	}

	public void setMostrarUnidadTipoUnidad(Boolean visibilidadResaltarUnidad) {
		this.mostrarUnidadTipoUnidad= visibilidadResaltarUnidad;
	}



	public Boolean activarUnidadTipoUnidad=true;

	public Boolean gethabilitarResaltarUnidadTipoUnidad() {
		return this.activarUnidadTipoUnidad;
	}

	public void setActivarUnidadTipoUnidad(Boolean habilitarResaltarUnidad) {
		this.activarUnidadTipoUnidad= habilitarResaltarUnidad;
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

		this.setMostrarUnidadTipoUnidad(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Unidad.class)) {
				this.setMostrarUnidadTipoUnidad(esAsigna);
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

		this.setActivarUnidadTipoUnidad(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Unidad.class)) {
				this.setActivarUnidadTipoUnidad(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoUnidadBeanSwingJInternalFrame tipounidadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarUnidadTipoUnidad(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Unidad.class)) {
				this.setResaltarUnidadTipoUnidad(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorNombreTipoUnidad=true;

	public Boolean getMostrarBusquedaPorNombreTipoUnidad() {
		return this.mostrarBusquedaPorNombreTipoUnidad;
	}

	public void setMostrarBusquedaPorNombreTipoUnidad(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoUnidad= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorSiglasTipoUnidad=true;

	public Boolean getMostrarBusquedaPorSiglasTipoUnidad() {
		return this.mostrarBusquedaPorSiglasTipoUnidad;
	}

	public void setMostrarBusquedaPorSiglasTipoUnidad(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorSiglasTipoUnidad= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreTipoUnidad=true;

	public Boolean getActivarBusquedaPorNombreTipoUnidad() {
		return this.activarBusquedaPorNombreTipoUnidad;
	}

	public void setActivarBusquedaPorNombreTipoUnidad(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoUnidad= habilitarResaltar;
	}

	public Boolean activarBusquedaPorSiglasTipoUnidad=true;

	public Boolean getActivarBusquedaPorSiglasTipoUnidad() {
		return this.activarBusquedaPorSiglasTipoUnidad;
	}

	public void setActivarBusquedaPorSiglasTipoUnidad(Boolean habilitarResaltar) {
		this.activarBusquedaPorSiglasTipoUnidad= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreTipoUnidad=null;

	public Border getResaltarBusquedaPorNombreTipoUnidad() {
		return this.resaltarBusquedaPorNombreTipoUnidad;
	}

	public void setResaltarBusquedaPorNombreTipoUnidad(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoUnidad= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoUnidadBeanSwingJInternalFrame tipounidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoUnidad= borderResaltar;
	}

	public Border resaltarBusquedaPorSiglasTipoUnidad=null;

	public Border getResaltarBusquedaPorSiglasTipoUnidad() {
		return this.resaltarBusquedaPorSiglasTipoUnidad;
	}

	public void setResaltarBusquedaPorSiglasTipoUnidad(Border borderResaltar) {
		this.resaltarBusquedaPorSiglasTipoUnidad= borderResaltar;
	}

	public void setResaltarBusquedaPorSiglasTipoUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoUnidadBeanSwingJInternalFrame tipounidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorSiglasTipoUnidad= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}