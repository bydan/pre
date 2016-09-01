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


import com.bydan.erp.inventario.util.TipoProductoServicioInvenConstantesFunciones;
import com.bydan.erp.inventario.util.TipoProductoServicioInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoProductoServicioInvenParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoProductoServicioInvenConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoProductoServicioInven";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoProductoServicioInven"+TipoProductoServicioInvenConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoProductoServicioInvenHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoProductoServicioInvenHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoProductoServicioInvenConstantesFunciones.SCHEMA+"_"+TipoProductoServicioInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoProductoServicioInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoProductoServicioInvenConstantesFunciones.SCHEMA+"_"+TipoProductoServicioInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoProductoServicioInvenConstantesFunciones.SCHEMA+"_"+TipoProductoServicioInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoProductoServicioInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoProductoServicioInvenConstantesFunciones.SCHEMA+"_"+TipoProductoServicioInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProductoServicioInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoProductoServicioInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProductoServicioInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProductoServicioInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoProductoServicioInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProductoServicioInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoProductoServicioInvenConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoProductoServicioInvenConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoProductoServicioInvenConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoProductoServicioInvenConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Producto Servicio Inventarios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Producto Servicio Inventario";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Producto Servicio Inven";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoProductoServicioInven";
	public static final String OBJECTNAME="tipoproductoservicioinven";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="tipo_producto_servicio_inven";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoproductoservicioinven from "+TipoProductoServicioInvenConstantesFunciones.SPERSISTENCENAME+" tipoproductoservicioinven";
	public static String QUERYSELECTNATIVE="select "+TipoProductoServicioInvenConstantesFunciones.SCHEMA+"."+TipoProductoServicioInvenConstantesFunciones.TABLENAME+".id,"+TipoProductoServicioInvenConstantesFunciones.SCHEMA+"."+TipoProductoServicioInvenConstantesFunciones.TABLENAME+".version_row,"+TipoProductoServicioInvenConstantesFunciones.SCHEMA+"."+TipoProductoServicioInvenConstantesFunciones.TABLENAME+".nombre from "+TipoProductoServicioInvenConstantesFunciones.SCHEMA+"."+TipoProductoServicioInvenConstantesFunciones.TABLENAME;//+" as "+TipoProductoServicioInvenConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoProductoServicioInvenLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoProductoServicioInvenConstantesFunciones.NOMBRE)) {sLabelColumna=TipoProductoServicioInvenConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getTipoProductoServicioInvenDescripcion(TipoProductoServicioInven tipoproductoservicioinven) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoproductoservicioinven !=null/* && tipoproductoservicioinven.getId()!=0*/) {
			sDescripcion=tipoproductoservicioinven.getnombre();//tipoproductoservicioinventipoproductoservicioinven.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoProductoServicioInvenDescripcionDetallado(TipoProductoServicioInven tipoproductoservicioinven) {
		String sDescripcion="";
			
		sDescripcion+=TipoProductoServicioInvenConstantesFunciones.ID+"=";
		sDescripcion+=tipoproductoservicioinven.getId().toString()+",";
		sDescripcion+=TipoProductoServicioInvenConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoproductoservicioinven.getVersionRow().toString()+",";
		sDescripcion+=TipoProductoServicioInvenConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoproductoservicioinven.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoProductoServicioInvenDescripcion(TipoProductoServicioInven tipoproductoservicioinven,String sValor) throws Exception {			
		if(tipoproductoservicioinven !=null) {
			tipoproductoservicioinven.setnombre(sValor);//tipoproductoservicioinventipoproductoservicioinven.getId().toString();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
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

	public static String getDetalleIndicePorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoProductoServicioInven(TipoProductoServicioInven tipoproductoservicioinven,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoproductoservicioinven.setnombre(tipoproductoservicioinven.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoProductoServicioInvens(List<TipoProductoServicioInven> tipoproductoservicioinvens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoProductoServicioInven tipoproductoservicioinven: tipoproductoservicioinvens) {
			tipoproductoservicioinven.setnombre(tipoproductoservicioinven.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoProductoServicioInven(TipoProductoServicioInven tipoproductoservicioinven,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoproductoservicioinven.getConCambioAuxiliar()) {
			tipoproductoservicioinven.setIsDeleted(tipoproductoservicioinven.getIsDeletedAuxiliar());	
			tipoproductoservicioinven.setIsNew(tipoproductoservicioinven.getIsNewAuxiliar());	
			tipoproductoservicioinven.setIsChanged(tipoproductoservicioinven.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoproductoservicioinven.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoproductoservicioinven.setIsDeletedAuxiliar(false);	
			tipoproductoservicioinven.setIsNewAuxiliar(false);	
			tipoproductoservicioinven.setIsChangedAuxiliar(false);
			
			tipoproductoservicioinven.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoProductoServicioInvens(List<TipoProductoServicioInven> tipoproductoservicioinvens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoProductoServicioInven tipoproductoservicioinven : tipoproductoservicioinvens) {
			if(conAsignarBase && tipoproductoservicioinven.getConCambioAuxiliar()) {
				tipoproductoservicioinven.setIsDeleted(tipoproductoservicioinven.getIsDeletedAuxiliar());	
				tipoproductoservicioinven.setIsNew(tipoproductoservicioinven.getIsNewAuxiliar());	
				tipoproductoservicioinven.setIsChanged(tipoproductoservicioinven.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoproductoservicioinven.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoproductoservicioinven.setIsDeletedAuxiliar(false);	
				tipoproductoservicioinven.setIsNewAuxiliar(false);	
				tipoproductoservicioinven.setIsChangedAuxiliar(false);
				
				tipoproductoservicioinven.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoProductoServicioInven(TipoProductoServicioInven tipoproductoservicioinven,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoProductoServicioInvens(List<TipoProductoServicioInven> tipoproductoservicioinvens,Boolean conEnteros) throws Exception  {
		
		for(TipoProductoServicioInven tipoproductoservicioinven: tipoproductoservicioinvens) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoProductoServicioInven(List<TipoProductoServicioInven> tipoproductoservicioinvens,TipoProductoServicioInven tipoproductoservicioinvenAux) throws Exception  {
		TipoProductoServicioInvenConstantesFunciones.InicializarValoresTipoProductoServicioInven(tipoproductoservicioinvenAux,true);
		
		for(TipoProductoServicioInven tipoproductoservicioinven: tipoproductoservicioinvens) {
			if(tipoproductoservicioinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoProductoServicioInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoProductoServicioInvenConstantesFunciones.getArrayColumnasGlobalesTipoProductoServicioInven(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoProductoServicioInven(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoProductoServicioInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoProductoServicioInven> tipoproductoservicioinvens,TipoProductoServicioInven tipoproductoservicioinven,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoProductoServicioInven tipoproductoservicioinvenAux: tipoproductoservicioinvens) {
			if(tipoproductoservicioinvenAux!=null && tipoproductoservicioinven!=null) {
				if((tipoproductoservicioinvenAux.getId()==null && tipoproductoservicioinven.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoproductoservicioinvenAux.getId()!=null && tipoproductoservicioinven.getId()!=null){
					if(tipoproductoservicioinvenAux.getId().equals(tipoproductoservicioinven.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoProductoServicioInven(List<TipoProductoServicioInven> tipoproductoservicioinvens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoProductoServicioInven tipoproductoservicioinven: tipoproductoservicioinvens) {			
			if(tipoproductoservicioinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoProductoServicioInven() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoProductoServicioInvenConstantesFunciones.LABEL_ID, TipoProductoServicioInvenConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProductoServicioInvenConstantesFunciones.LABEL_VERSIONROW, TipoProductoServicioInvenConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProductoServicioInvenConstantesFunciones.LABEL_NOMBRE, TipoProductoServicioInvenConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoProductoServicioInven() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoProductoServicioInvenConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProductoServicioInvenConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProductoServicioInvenConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProductoServicioInven() throws Exception  {
		return TipoProductoServicioInvenConstantesFunciones.getTiposSeleccionarTipoProductoServicioInven(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProductoServicioInven(Boolean conFk) throws Exception  {
		return TipoProductoServicioInvenConstantesFunciones.getTiposSeleccionarTipoProductoServicioInven(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProductoServicioInven(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProductoServicioInvenConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoProductoServicioInvenConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoProductoServicioInven(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoProductoServicioInven(TipoProductoServicioInven tipoproductoservicioinvenAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoProductoServicioInven(List<TipoProductoServicioInven> tipoproductoservicioinvensTemp) throws Exception {
		for(TipoProductoServicioInven tipoproductoservicioinvenAux:tipoproductoservicioinvensTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoProductoServicioInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoProductoServicioInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProductoServicioInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoProductoServicioInvenConstantesFunciones.getClassesRelationshipsOfTipoProductoServicioInven(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProductoServicioInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(ParametroInventarioDefecto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroInventarioDefecto.class)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoProductoServicioInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoProductoServicioInvenConstantesFunciones.getClassesRelationshipsFromStringsOfTipoProductoServicioInven(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoProductoServicioInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(ParametroInventarioDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(ParametroInventarioDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); continue;
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
	public static void actualizarLista(TipoProductoServicioInven tipoproductoservicioinven,List<TipoProductoServicioInven> tipoproductoservicioinvens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoProductoServicioInven tipoproductoservicioinvenEncontrado=null;
			
			for(TipoProductoServicioInven tipoproductoservicioinvenLocal:tipoproductoservicioinvens) {
				if(tipoproductoservicioinvenLocal.getId().equals(tipoproductoservicioinven.getId())) {
					tipoproductoservicioinvenEncontrado=tipoproductoservicioinvenLocal;
					
					tipoproductoservicioinvenLocal.setIsChanged(tipoproductoservicioinven.getIsChanged());
					tipoproductoservicioinvenLocal.setIsNew(tipoproductoservicioinven.getIsNew());
					tipoproductoservicioinvenLocal.setIsDeleted(tipoproductoservicioinven.getIsDeleted());
					
					tipoproductoservicioinvenLocal.setGeneralEntityOriginal(tipoproductoservicioinven.getGeneralEntityOriginal());
					
					tipoproductoservicioinvenLocal.setId(tipoproductoservicioinven.getId());	
					tipoproductoservicioinvenLocal.setVersionRow(tipoproductoservicioinven.getVersionRow());	
					tipoproductoservicioinvenLocal.setnombre(tipoproductoservicioinven.getnombre());	
					
					
					tipoproductoservicioinvenLocal.setParametroInventarioDefectos(tipoproductoservicioinven.getParametroInventarioDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoproductoservicioinven.getIsDeleted()) {
				if(!existe) {
					tipoproductoservicioinvens.add(tipoproductoservicioinven);
				}
			} else {
				if(tipoproductoservicioinvenEncontrado!=null && permiteQuitar)  {
					tipoproductoservicioinvens.remove(tipoproductoservicioinvenEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoProductoServicioInven tipoproductoservicioinven,List<TipoProductoServicioInven> tipoproductoservicioinvens) throws Exception {
		try	{			
			for(TipoProductoServicioInven tipoproductoservicioinvenLocal:tipoproductoservicioinvens) {
				if(tipoproductoservicioinvenLocal.getId().equals(tipoproductoservicioinven.getId())) {
					tipoproductoservicioinvenLocal.setIsSelected(tipoproductoservicioinven.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoProductoServicioInven(List<TipoProductoServicioInven> tipoproductoservicioinvensAux) throws Exception {
		//this.tipoproductoservicioinvensAux=tipoproductoservicioinvensAux;
		
		for(TipoProductoServicioInven tipoproductoservicioinvenAux:tipoproductoservicioinvensAux) {
			if(tipoproductoservicioinvenAux.getIsChanged()) {
				tipoproductoservicioinvenAux.setIsChanged(false);
			}		
			
			if(tipoproductoservicioinvenAux.getIsNew()) {
				tipoproductoservicioinvenAux.setIsNew(false);
			}	
			
			if(tipoproductoservicioinvenAux.getIsDeleted()) {
				tipoproductoservicioinvenAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoProductoServicioInven(TipoProductoServicioInven tipoproductoservicioinvenAux) throws Exception {
		//this.tipoproductoservicioinvenAux=tipoproductoservicioinvenAux;
		
			if(tipoproductoservicioinvenAux.getIsChanged()) {
				tipoproductoservicioinvenAux.setIsChanged(false);
			}		
			
			if(tipoproductoservicioinvenAux.getIsNew()) {
				tipoproductoservicioinvenAux.setIsNew(false);
			}	
			
			if(tipoproductoservicioinvenAux.getIsDeleted()) {
				tipoproductoservicioinvenAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoProductoServicioInven tipoproductoservicioinvenAsignar,TipoProductoServicioInven tipoproductoservicioinven) throws Exception {
		tipoproductoservicioinvenAsignar.setId(tipoproductoservicioinven.getId());	
		tipoproductoservicioinvenAsignar.setVersionRow(tipoproductoservicioinven.getVersionRow());	
		tipoproductoservicioinvenAsignar.setnombre(tipoproductoservicioinven.getnombre());	
	}
	
	public static void inicializarTipoProductoServicioInven(TipoProductoServicioInven tipoproductoservicioinven) throws Exception {
		try {
				tipoproductoservicioinven.setId(0L);	
					
				tipoproductoservicioinven.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoProductoServicioInven(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProductoServicioInvenConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoProductoServicioInven(String sTipo,Row row,Workbook workbook,TipoProductoServicioInven tipoproductoservicioinven,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoproductoservicioinven.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoProductoServicioInven=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoProductoServicioInven() {
		return this.sFinalQueryTipoProductoServicioInven;
	}
	
	public void setsFinalQueryTipoProductoServicioInven(String sFinalQueryTipoProductoServicioInven) {
		this.sFinalQueryTipoProductoServicioInven= sFinalQueryTipoProductoServicioInven;
	}
	
	public Border resaltarSeleccionarTipoProductoServicioInven=null;
	
	public Border setResaltarSeleccionarTipoProductoServicioInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoServicioInvenBeanSwingJInternalFrame tipoproductoservicioinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoproductoservicioinvenBeanSwingJInternalFrame.jTtoolBarTipoProductoServicioInven.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoProductoServicioInven= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoProductoServicioInven() {
		return this.resaltarSeleccionarTipoProductoServicioInven;
	}
	
	public void setResaltarSeleccionarTipoProductoServicioInven(Border borderResaltarSeleccionarTipoProductoServicioInven) {
		this.resaltarSeleccionarTipoProductoServicioInven= borderResaltarSeleccionarTipoProductoServicioInven;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoProductoServicioInven=null;
	public Boolean mostraridTipoProductoServicioInven=true;
	public Boolean activaridTipoProductoServicioInven=true;

	public Border resaltarnombreTipoProductoServicioInven=null;
	public Boolean mostrarnombreTipoProductoServicioInven=true;
	public Boolean activarnombreTipoProductoServicioInven=true;

	
	

	public Border setResaltaridTipoProductoServicioInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoServicioInvenBeanSwingJInternalFrame tipoproductoservicioinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoproductoservicioinvenBeanSwingJInternalFrame.jTtoolBarTipoProductoServicioInven.setBorder(borderResaltar);
		
		this.resaltaridTipoProductoServicioInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoProductoServicioInven() {
		return this.resaltaridTipoProductoServicioInven;
	}

	public void setResaltaridTipoProductoServicioInven(Border borderResaltar) {
		this.resaltaridTipoProductoServicioInven= borderResaltar;
	}

	public Boolean getMostraridTipoProductoServicioInven() {
		return this.mostraridTipoProductoServicioInven;
	}

	public void setMostraridTipoProductoServicioInven(Boolean mostraridTipoProductoServicioInven) {
		this.mostraridTipoProductoServicioInven= mostraridTipoProductoServicioInven;
	}

	public Boolean getActivaridTipoProductoServicioInven() {
		return this.activaridTipoProductoServicioInven;
	}

	public void setActivaridTipoProductoServicioInven(Boolean activaridTipoProductoServicioInven) {
		this.activaridTipoProductoServicioInven= activaridTipoProductoServicioInven;
	}

	public Border setResaltarnombreTipoProductoServicioInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoServicioInvenBeanSwingJInternalFrame tipoproductoservicioinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoproductoservicioinvenBeanSwingJInternalFrame.jTtoolBarTipoProductoServicioInven.setBorder(borderResaltar);
		
		this.resaltarnombreTipoProductoServicioInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoProductoServicioInven() {
		return this.resaltarnombreTipoProductoServicioInven;
	}

	public void setResaltarnombreTipoProductoServicioInven(Border borderResaltar) {
		this.resaltarnombreTipoProductoServicioInven= borderResaltar;
	}

	public Boolean getMostrarnombreTipoProductoServicioInven() {
		return this.mostrarnombreTipoProductoServicioInven;
	}

	public void setMostrarnombreTipoProductoServicioInven(Boolean mostrarnombreTipoProductoServicioInven) {
		this.mostrarnombreTipoProductoServicioInven= mostrarnombreTipoProductoServicioInven;
	}

	public Boolean getActivarnombreTipoProductoServicioInven() {
		return this.activarnombreTipoProductoServicioInven;
	}

	public void setActivarnombreTipoProductoServicioInven(Boolean activarnombreTipoProductoServicioInven) {
		this.activarnombreTipoProductoServicioInven= activarnombreTipoProductoServicioInven;
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
		
		
		this.setMostraridTipoProductoServicioInven(esInicial);
		this.setMostrarnombreTipoProductoServicioInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProductoServicioInvenConstantesFunciones.ID)) {
				this.setMostraridTipoProductoServicioInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProductoServicioInvenConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoProductoServicioInven(esAsigna);
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
		
		
		this.setActivaridTipoProductoServicioInven(esInicial);
		this.setActivarnombreTipoProductoServicioInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProductoServicioInvenConstantesFunciones.ID)) {
				this.setActivaridTipoProductoServicioInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProductoServicioInvenConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoProductoServicioInven(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoProductoServicioInvenBeanSwingJInternalFrame tipoproductoservicioinvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoProductoServicioInven(esInicial);
		this.setResaltarnombreTipoProductoServicioInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProductoServicioInvenConstantesFunciones.ID)) {
				this.setResaltaridTipoProductoServicioInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProductoServicioInvenConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoProductoServicioInven(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarParametroInventarioDefectoTipoProductoServicioInven=null;

	public Border getResaltarParametroInventarioDefectoTipoProductoServicioInven() {
		return this.resaltarParametroInventarioDefectoTipoProductoServicioInven;
	}

	public void setResaltarParametroInventarioDefectoTipoProductoServicioInven(Border borderResaltarParametroInventarioDefecto) {
		if(borderResaltarParametroInventarioDefecto!=null) {
			this.resaltarParametroInventarioDefectoTipoProductoServicioInven= borderResaltarParametroInventarioDefecto;
		}
	}

	public Border setResaltarParametroInventarioDefectoTipoProductoServicioInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoServicioInvenBeanSwingJInternalFrame tipoproductoservicioinvenBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroInventarioDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoproductoservicioinvenBeanSwingJInternalFrame.jTtoolBarTipoProductoServicioInven.setBorder(borderResaltarParametroInventarioDefecto);
			
		this.resaltarParametroInventarioDefectoTipoProductoServicioInven= borderResaltarParametroInventarioDefecto;

		 return borderResaltarParametroInventarioDefecto;
	}



	public Boolean mostrarParametroInventarioDefectoTipoProductoServicioInven=true;

	public Boolean getMostrarParametroInventarioDefectoTipoProductoServicioInven() {
		return this.mostrarParametroInventarioDefectoTipoProductoServicioInven;
	}

	public void setMostrarParametroInventarioDefectoTipoProductoServicioInven(Boolean visibilidadResaltarParametroInventarioDefecto) {
		this.mostrarParametroInventarioDefectoTipoProductoServicioInven= visibilidadResaltarParametroInventarioDefecto;
	}



	public Boolean activarParametroInventarioDefectoTipoProductoServicioInven=true;

	public Boolean gethabilitarResaltarParametroInventarioDefectoTipoProductoServicioInven() {
		return this.activarParametroInventarioDefectoTipoProductoServicioInven;
	}

	public void setActivarParametroInventarioDefectoTipoProductoServicioInven(Boolean habilitarResaltarParametroInventarioDefecto) {
		this.activarParametroInventarioDefectoTipoProductoServicioInven= habilitarResaltarParametroInventarioDefecto;
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

		this.setMostrarParametroInventarioDefectoTipoProductoServicioInven(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setMostrarParametroInventarioDefectoTipoProductoServicioInven(esAsigna);
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

		this.setActivarParametroInventarioDefectoTipoProductoServicioInven(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setActivarParametroInventarioDefectoTipoProductoServicioInven(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoProductoServicioInvenBeanSwingJInternalFrame tipoproductoservicioinvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarParametroInventarioDefectoTipoProductoServicioInven(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setResaltarParametroInventarioDefectoTipoProductoServicioInven(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorNombreTipoProductoServicioInven=true;

	public Boolean getMostrarBusquedaPorNombreTipoProductoServicioInven() {
		return this.mostrarBusquedaPorNombreTipoProductoServicioInven;
	}

	public void setMostrarBusquedaPorNombreTipoProductoServicioInven(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoProductoServicioInven= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreTipoProductoServicioInven=true;

	public Boolean getActivarBusquedaPorNombreTipoProductoServicioInven() {
		return this.activarBusquedaPorNombreTipoProductoServicioInven;
	}

	public void setActivarBusquedaPorNombreTipoProductoServicioInven(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoProductoServicioInven= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreTipoProductoServicioInven=null;

	public Border getResaltarBusquedaPorNombreTipoProductoServicioInven() {
		return this.resaltarBusquedaPorNombreTipoProductoServicioInven;
	}

	public void setResaltarBusquedaPorNombreTipoProductoServicioInven(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoProductoServicioInven= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoProductoServicioInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoServicioInvenBeanSwingJInternalFrame tipoproductoservicioinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoProductoServicioInven= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}