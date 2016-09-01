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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.EstadoDetallePedidoConstantesFunciones;
import com.bydan.erp.facturacion.util.EstadoDetallePedidoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.EstadoDetallePedidoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoDetallePedidoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoDetallePedido";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoDetallePedido"+EstadoDetallePedidoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoDetallePedidoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoDetallePedidoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoDetallePedidoConstantesFunciones.SCHEMA+"_"+EstadoDetallePedidoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoDetallePedidoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoDetallePedidoConstantesFunciones.SCHEMA+"_"+EstadoDetallePedidoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoDetallePedidoConstantesFunciones.SCHEMA+"_"+EstadoDetallePedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoDetallePedidoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoDetallePedidoConstantesFunciones.SCHEMA+"_"+EstadoDetallePedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetallePedidoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoDetallePedidoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetallePedidoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetallePedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoDetallePedidoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetallePedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoDetallePedidoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoDetallePedidoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoDetallePedidoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoDetallePedidoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Detalle Pedidos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Detalle Pedido";
	public static final String SCLASSWEBTITULO_LOWER="Estado Detalle Pedido";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoDetallePedido";
	public static final String OBJECTNAME="estadodetallepedido";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="estado_detalle_pedido";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadodetallepedido from "+EstadoDetallePedidoConstantesFunciones.SPERSISTENCENAME+" estadodetallepedido";
	public static String QUERYSELECTNATIVE="select "+EstadoDetallePedidoConstantesFunciones.SCHEMA+"."+EstadoDetallePedidoConstantesFunciones.TABLENAME+".id,"+EstadoDetallePedidoConstantesFunciones.SCHEMA+"."+EstadoDetallePedidoConstantesFunciones.TABLENAME+".version_row,"+EstadoDetallePedidoConstantesFunciones.SCHEMA+"."+EstadoDetallePedidoConstantesFunciones.TABLENAME+".codigo,"+EstadoDetallePedidoConstantesFunciones.SCHEMA+"."+EstadoDetallePedidoConstantesFunciones.TABLENAME+".nombre from "+EstadoDetallePedidoConstantesFunciones.SCHEMA+"."+EstadoDetallePedidoConstantesFunciones.TABLENAME;//+" as "+EstadoDetallePedidoConstantesFunciones.TABLENAME;
	
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
	
	public static String getEstadoDetallePedidoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoDetallePedidoConstantesFunciones.CODIGO)) {sLabelColumna=EstadoDetallePedidoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoDetallePedidoConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoDetallePedidoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoDetallePedidoDescripcion(EstadoDetallePedido estadodetallepedido) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadodetallepedido !=null/* && estadodetallepedido.getId()!=0*/) {
			sDescripcion=estadodetallepedido.getcodigo();//estadodetallepedidoestadodetallepedido.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoDetallePedidoDescripcionDetallado(EstadoDetallePedido estadodetallepedido) {
		String sDescripcion="";
			
		sDescripcion+=EstadoDetallePedidoConstantesFunciones.ID+"=";
		sDescripcion+=estadodetallepedido.getId().toString()+",";
		sDescripcion+=EstadoDetallePedidoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadodetallepedido.getVersionRow().toString()+",";
		sDescripcion+=EstadoDetallePedidoConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadodetallepedido.getcodigo()+",";
		sDescripcion+=EstadoDetallePedidoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadodetallepedido.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoDetallePedidoDescripcion(EstadoDetallePedido estadodetallepedido,String sValor) throws Exception {			
		if(estadodetallepedido !=null) {
			estadodetallepedido.setcodigo(sValor);;//estadodetallepedidoestadodetallepedido.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoDetallePedido(EstadoDetallePedido estadodetallepedido,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadodetallepedido.setcodigo(estadodetallepedido.getcodigo().trim());
		estadodetallepedido.setnombre(estadodetallepedido.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoDetallePedidos(List<EstadoDetallePedido> estadodetallepedidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoDetallePedido estadodetallepedido: estadodetallepedidos) {
			estadodetallepedido.setcodigo(estadodetallepedido.getcodigo().trim());
			estadodetallepedido.setnombre(estadodetallepedido.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoDetallePedido(EstadoDetallePedido estadodetallepedido,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadodetallepedido.getConCambioAuxiliar()) {
			estadodetallepedido.setIsDeleted(estadodetallepedido.getIsDeletedAuxiliar());	
			estadodetallepedido.setIsNew(estadodetallepedido.getIsNewAuxiliar());	
			estadodetallepedido.setIsChanged(estadodetallepedido.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadodetallepedido.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadodetallepedido.setIsDeletedAuxiliar(false);	
			estadodetallepedido.setIsNewAuxiliar(false);	
			estadodetallepedido.setIsChangedAuxiliar(false);
			
			estadodetallepedido.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoDetallePedidos(List<EstadoDetallePedido> estadodetallepedidos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoDetallePedido estadodetallepedido : estadodetallepedidos) {
			if(conAsignarBase && estadodetallepedido.getConCambioAuxiliar()) {
				estadodetallepedido.setIsDeleted(estadodetallepedido.getIsDeletedAuxiliar());	
				estadodetallepedido.setIsNew(estadodetallepedido.getIsNewAuxiliar());	
				estadodetallepedido.setIsChanged(estadodetallepedido.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadodetallepedido.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadodetallepedido.setIsDeletedAuxiliar(false);	
				estadodetallepedido.setIsNewAuxiliar(false);	
				estadodetallepedido.setIsChangedAuxiliar(false);
				
				estadodetallepedido.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoDetallePedido(EstadoDetallePedido estadodetallepedido,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoDetallePedidos(List<EstadoDetallePedido> estadodetallepedidos,Boolean conEnteros) throws Exception  {
		
		for(EstadoDetallePedido estadodetallepedido: estadodetallepedidos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoDetallePedido(List<EstadoDetallePedido> estadodetallepedidos,EstadoDetallePedido estadodetallepedidoAux) throws Exception  {
		EstadoDetallePedidoConstantesFunciones.InicializarValoresEstadoDetallePedido(estadodetallepedidoAux,true);
		
		for(EstadoDetallePedido estadodetallepedido: estadodetallepedidos) {
			if(estadodetallepedido.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoDetallePedido(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoDetallePedidoConstantesFunciones.getArrayColumnasGlobalesEstadoDetallePedido(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoDetallePedido(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoDetallePedido(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoDetallePedido> estadodetallepedidos,EstadoDetallePedido estadodetallepedido,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoDetallePedido estadodetallepedidoAux: estadodetallepedidos) {
			if(estadodetallepedidoAux!=null && estadodetallepedido!=null) {
				if((estadodetallepedidoAux.getId()==null && estadodetallepedido.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadodetallepedidoAux.getId()!=null && estadodetallepedido.getId()!=null){
					if(estadodetallepedidoAux.getId().equals(estadodetallepedido.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoDetallePedido(List<EstadoDetallePedido> estadodetallepedidos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoDetallePedido estadodetallepedido: estadodetallepedidos) {			
			if(estadodetallepedido.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoDetallePedido() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoDetallePedidoConstantesFunciones.LABEL_ID, EstadoDetallePedidoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDetallePedidoConstantesFunciones.LABEL_VERSIONROW, EstadoDetallePedidoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDetallePedidoConstantesFunciones.LABEL_CODIGO, EstadoDetallePedidoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDetallePedidoConstantesFunciones.LABEL_NOMBRE, EstadoDetallePedidoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoDetallePedido() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoDetallePedidoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDetallePedidoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDetallePedidoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDetallePedidoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDetallePedido() throws Exception  {
		return EstadoDetallePedidoConstantesFunciones.getTiposSeleccionarEstadoDetallePedido(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDetallePedido(Boolean conFk) throws Exception  {
		return EstadoDetallePedidoConstantesFunciones.getTiposSeleccionarEstadoDetallePedido(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDetallePedido(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoDetallePedidoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoDetallePedidoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoDetallePedidoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoDetallePedidoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoDetallePedido(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoDetallePedido(EstadoDetallePedido estadodetallepedidoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoDetallePedido(List<EstadoDetallePedido> estadodetallepedidosTemp) throws Exception {
		for(EstadoDetallePedido estadodetallepedidoAux:estadodetallepedidosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoDetallePedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoDetallePedido(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDetallePedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoDetallePedidoConstantesFunciones.getClassesRelationshipsOfEstadoDetallePedido(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDetallePedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleConsignacion.class));
				classes.add(new Classe(DetallePedido.class));
				classes.add(new Classe(DetallePedidoExpor.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleConsignacion.class)) {
						classes.add(new Classe(DetalleConsignacion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetallePedido.class)) {
						classes.add(new Classe(DetallePedido.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetallePedidoExpor.class)) {
						classes.add(new Classe(DetallePedidoExpor.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoDetallePedido(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoDetallePedidoConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoDetallePedido(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoDetallePedido(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleConsignacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleConsignacion.class)); continue;
					}

					if(DetallePedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetallePedido.class)); continue;
					}

					if(DetallePedidoExpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetallePedidoExpor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleConsignacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleConsignacion.class)); continue;
					}

					if(DetallePedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetallePedido.class)); continue;
					}

					if(DetallePedidoExpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetallePedidoExpor.class)); continue;
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
	public static void actualizarLista(EstadoDetallePedido estadodetallepedido,List<EstadoDetallePedido> estadodetallepedidos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoDetallePedido estadodetallepedidoEncontrado=null;
			
			for(EstadoDetallePedido estadodetallepedidoLocal:estadodetallepedidos) {
				if(estadodetallepedidoLocal.getId().equals(estadodetallepedido.getId())) {
					estadodetallepedidoEncontrado=estadodetallepedidoLocal;
					
					estadodetallepedidoLocal.setIsChanged(estadodetallepedido.getIsChanged());
					estadodetallepedidoLocal.setIsNew(estadodetallepedido.getIsNew());
					estadodetallepedidoLocal.setIsDeleted(estadodetallepedido.getIsDeleted());
					
					estadodetallepedidoLocal.setGeneralEntityOriginal(estadodetallepedido.getGeneralEntityOriginal());
					
					estadodetallepedidoLocal.setId(estadodetallepedido.getId());	
					estadodetallepedidoLocal.setVersionRow(estadodetallepedido.getVersionRow());	
					estadodetallepedidoLocal.setcodigo(estadodetallepedido.getcodigo());	
					estadodetallepedidoLocal.setnombre(estadodetallepedido.getnombre());	
					
					
					estadodetallepedidoLocal.setDetalleConsignacions(estadodetallepedido.getDetalleConsignacions());
					estadodetallepedidoLocal.setDetallePedidoExporExpors(estadodetallepedido.getDetallePedidoExporExpors());
					
					existe=true;
					break;
				}
			}
			
			if(!estadodetallepedido.getIsDeleted()) {
				if(!existe) {
					estadodetallepedidos.add(estadodetallepedido);
				}
			} else {
				if(estadodetallepedidoEncontrado!=null && permiteQuitar)  {
					estadodetallepedidos.remove(estadodetallepedidoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoDetallePedido estadodetallepedido,List<EstadoDetallePedido> estadodetallepedidos) throws Exception {
		try	{			
			for(EstadoDetallePedido estadodetallepedidoLocal:estadodetallepedidos) {
				if(estadodetallepedidoLocal.getId().equals(estadodetallepedido.getId())) {
					estadodetallepedidoLocal.setIsSelected(estadodetallepedido.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoDetallePedido(List<EstadoDetallePedido> estadodetallepedidosAux) throws Exception {
		//this.estadodetallepedidosAux=estadodetallepedidosAux;
		
		for(EstadoDetallePedido estadodetallepedidoAux:estadodetallepedidosAux) {
			if(estadodetallepedidoAux.getIsChanged()) {
				estadodetallepedidoAux.setIsChanged(false);
			}		
			
			if(estadodetallepedidoAux.getIsNew()) {
				estadodetallepedidoAux.setIsNew(false);
			}	
			
			if(estadodetallepedidoAux.getIsDeleted()) {
				estadodetallepedidoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoDetallePedido(EstadoDetallePedido estadodetallepedidoAux) throws Exception {
		//this.estadodetallepedidoAux=estadodetallepedidoAux;
		
			if(estadodetallepedidoAux.getIsChanged()) {
				estadodetallepedidoAux.setIsChanged(false);
			}		
			
			if(estadodetallepedidoAux.getIsNew()) {
				estadodetallepedidoAux.setIsNew(false);
			}	
			
			if(estadodetallepedidoAux.getIsDeleted()) {
				estadodetallepedidoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoDetallePedido estadodetallepedidoAsignar,EstadoDetallePedido estadodetallepedido) throws Exception {
		estadodetallepedidoAsignar.setId(estadodetallepedido.getId());	
		estadodetallepedidoAsignar.setVersionRow(estadodetallepedido.getVersionRow());	
		estadodetallepedidoAsignar.setcodigo(estadodetallepedido.getcodigo());	
		estadodetallepedidoAsignar.setnombre(estadodetallepedido.getnombre());	
	}
	
	public static void inicializarEstadoDetallePedido(EstadoDetallePedido estadodetallepedido) throws Exception {
		try {
				estadodetallepedido.setId(0L);	
					
				estadodetallepedido.setcodigo("");	
				estadodetallepedido.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoDetallePedido(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoDetallePedidoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoDetallePedidoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoDetallePedido(String sTipo,Row row,Workbook workbook,EstadoDetallePedido estadodetallepedido,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadodetallepedido.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadodetallepedido.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoDetallePedido=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoDetallePedido() {
		return this.sFinalQueryEstadoDetallePedido;
	}
	
	public void setsFinalQueryEstadoDetallePedido(String sFinalQueryEstadoDetallePedido) {
		this.sFinalQueryEstadoDetallePedido= sFinalQueryEstadoDetallePedido;
	}
	
	public Border resaltarSeleccionarEstadoDetallePedido=null;
	
	public Border setResaltarSeleccionarEstadoDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetallePedidoBeanSwingJInternalFrame estadodetallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadodetallepedidoBeanSwingJInternalFrame.jTtoolBarEstadoDetallePedido.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoDetallePedido= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoDetallePedido() {
		return this.resaltarSeleccionarEstadoDetallePedido;
	}
	
	public void setResaltarSeleccionarEstadoDetallePedido(Border borderResaltarSeleccionarEstadoDetallePedido) {
		this.resaltarSeleccionarEstadoDetallePedido= borderResaltarSeleccionarEstadoDetallePedido;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoDetallePedido=null;
	public Boolean mostraridEstadoDetallePedido=true;
	public Boolean activaridEstadoDetallePedido=true;

	public Border resaltarcodigoEstadoDetallePedido=null;
	public Boolean mostrarcodigoEstadoDetallePedido=true;
	public Boolean activarcodigoEstadoDetallePedido=true;

	public Border resaltarnombreEstadoDetallePedido=null;
	public Boolean mostrarnombreEstadoDetallePedido=true;
	public Boolean activarnombreEstadoDetallePedido=true;

	
	

	public Border setResaltaridEstadoDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetallePedidoBeanSwingJInternalFrame estadodetallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodetallepedidoBeanSwingJInternalFrame.jTtoolBarEstadoDetallePedido.setBorder(borderResaltar);
		
		this.resaltaridEstadoDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoDetallePedido() {
		return this.resaltaridEstadoDetallePedido;
	}

	public void setResaltaridEstadoDetallePedido(Border borderResaltar) {
		this.resaltaridEstadoDetallePedido= borderResaltar;
	}

	public Boolean getMostraridEstadoDetallePedido() {
		return this.mostraridEstadoDetallePedido;
	}

	public void setMostraridEstadoDetallePedido(Boolean mostraridEstadoDetallePedido) {
		this.mostraridEstadoDetallePedido= mostraridEstadoDetallePedido;
	}

	public Boolean getActivaridEstadoDetallePedido() {
		return this.activaridEstadoDetallePedido;
	}

	public void setActivaridEstadoDetallePedido(Boolean activaridEstadoDetallePedido) {
		this.activaridEstadoDetallePedido= activaridEstadoDetallePedido;
	}

	public Border setResaltarcodigoEstadoDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetallePedidoBeanSwingJInternalFrame estadodetallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodetallepedidoBeanSwingJInternalFrame.jTtoolBarEstadoDetallePedido.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoDetallePedido() {
		return this.resaltarcodigoEstadoDetallePedido;
	}

	public void setResaltarcodigoEstadoDetallePedido(Border borderResaltar) {
		this.resaltarcodigoEstadoDetallePedido= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoDetallePedido() {
		return this.mostrarcodigoEstadoDetallePedido;
	}

	public void setMostrarcodigoEstadoDetallePedido(Boolean mostrarcodigoEstadoDetallePedido) {
		this.mostrarcodigoEstadoDetallePedido= mostrarcodigoEstadoDetallePedido;
	}

	public Boolean getActivarcodigoEstadoDetallePedido() {
		return this.activarcodigoEstadoDetallePedido;
	}

	public void setActivarcodigoEstadoDetallePedido(Boolean activarcodigoEstadoDetallePedido) {
		this.activarcodigoEstadoDetallePedido= activarcodigoEstadoDetallePedido;
	}

	public Border setResaltarnombreEstadoDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetallePedidoBeanSwingJInternalFrame estadodetallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodetallepedidoBeanSwingJInternalFrame.jTtoolBarEstadoDetallePedido.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoDetallePedido() {
		return this.resaltarnombreEstadoDetallePedido;
	}

	public void setResaltarnombreEstadoDetallePedido(Border borderResaltar) {
		this.resaltarnombreEstadoDetallePedido= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoDetallePedido() {
		return this.mostrarnombreEstadoDetallePedido;
	}

	public void setMostrarnombreEstadoDetallePedido(Boolean mostrarnombreEstadoDetallePedido) {
		this.mostrarnombreEstadoDetallePedido= mostrarnombreEstadoDetallePedido;
	}

	public Boolean getActivarnombreEstadoDetallePedido() {
		return this.activarnombreEstadoDetallePedido;
	}

	public void setActivarnombreEstadoDetallePedido(Boolean activarnombreEstadoDetallePedido) {
		this.activarnombreEstadoDetallePedido= activarnombreEstadoDetallePedido;
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
		
		
		this.setMostraridEstadoDetallePedido(esInicial);
		this.setMostrarcodigoEstadoDetallePedido(esInicial);
		this.setMostrarnombreEstadoDetallePedido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDetallePedidoConstantesFunciones.ID)) {
				this.setMostraridEstadoDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetallePedidoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetallePedidoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoDetallePedido(esAsigna);
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
		
		
		this.setActivaridEstadoDetallePedido(esInicial);
		this.setActivarcodigoEstadoDetallePedido(esInicial);
		this.setActivarnombreEstadoDetallePedido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDetallePedidoConstantesFunciones.ID)) {
				this.setActivaridEstadoDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetallePedidoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetallePedidoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoDetallePedido(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoDetallePedidoBeanSwingJInternalFrame estadodetallepedidoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoDetallePedido(esInicial);
		this.setResaltarcodigoEstadoDetallePedido(esInicial);
		this.setResaltarnombreEstadoDetallePedido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDetallePedidoConstantesFunciones.ID)) {
				this.setResaltaridEstadoDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetallePedidoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetallePedidoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoDetallePedido(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleConsignacionEstadoDetallePedido=null;

	public Border getResaltarDetalleConsignacionEstadoDetallePedido() {
		return this.resaltarDetalleConsignacionEstadoDetallePedido;
	}

	public void setResaltarDetalleConsignacionEstadoDetallePedido(Border borderResaltarDetalleConsignacion) {
		if(borderResaltarDetalleConsignacion!=null) {
			this.resaltarDetalleConsignacionEstadoDetallePedido= borderResaltarDetalleConsignacion;
		}
	}

	public Border setResaltarDetalleConsignacionEstadoDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetallePedidoBeanSwingJInternalFrame estadodetallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleConsignacion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadodetallepedidoBeanSwingJInternalFrame.jTtoolBarEstadoDetallePedido.setBorder(borderResaltarDetalleConsignacion);
			
		this.resaltarDetalleConsignacionEstadoDetallePedido= borderResaltarDetalleConsignacion;

		 return borderResaltarDetalleConsignacion;
	}



	public Boolean mostrarDetalleConsignacionEstadoDetallePedido=true;

	public Boolean getMostrarDetalleConsignacionEstadoDetallePedido() {
		return this.mostrarDetalleConsignacionEstadoDetallePedido;
	}

	public void setMostrarDetalleConsignacionEstadoDetallePedido(Boolean visibilidadResaltarDetalleConsignacion) {
		this.mostrarDetalleConsignacionEstadoDetallePedido= visibilidadResaltarDetalleConsignacion;
	}



	public Boolean activarDetalleConsignacionEstadoDetallePedido=true;

	public Boolean gethabilitarResaltarDetalleConsignacionEstadoDetallePedido() {
		return this.activarDetalleConsignacionEstadoDetallePedido;
	}

	public void setActivarDetalleConsignacionEstadoDetallePedido(Boolean habilitarResaltarDetalleConsignacion) {
		this.activarDetalleConsignacionEstadoDetallePedido= habilitarResaltarDetalleConsignacion;
	}


	public Border resaltarDetallePedidoExporEstadoDetallePedido=null;

	public Border getResaltarDetallePedidoExporEstadoDetallePedido() {
		return this.resaltarDetallePedidoExporEstadoDetallePedido;
	}

	public void setResaltarDetallePedidoExporEstadoDetallePedido(Border borderResaltarDetallePedidoExpor) {
		if(borderResaltarDetallePedidoExpor!=null) {
			this.resaltarDetallePedidoExporEstadoDetallePedido= borderResaltarDetallePedidoExpor;
		}
	}

	public Border setResaltarDetallePedidoExporEstadoDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetallePedidoBeanSwingJInternalFrame estadodetallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltarDetallePedidoExpor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadodetallepedidoBeanSwingJInternalFrame.jTtoolBarEstadoDetallePedido.setBorder(borderResaltarDetallePedidoExpor);
			
		this.resaltarDetallePedidoExporEstadoDetallePedido= borderResaltarDetallePedidoExpor;

		 return borderResaltarDetallePedidoExpor;
	}



	public Boolean mostrarDetallePedidoExporEstadoDetallePedido=true;

	public Boolean getMostrarDetallePedidoExporEstadoDetallePedido() {
		return this.mostrarDetallePedidoExporEstadoDetallePedido;
	}

	public void setMostrarDetallePedidoExporEstadoDetallePedido(Boolean visibilidadResaltarDetallePedidoExpor) {
		this.mostrarDetallePedidoExporEstadoDetallePedido= visibilidadResaltarDetallePedidoExpor;
	}



	public Boolean activarDetallePedidoExporEstadoDetallePedido=true;

	public Boolean gethabilitarResaltarDetallePedidoExporEstadoDetallePedido() {
		return this.activarDetallePedidoExporEstadoDetallePedido;
	}

	public void setActivarDetallePedidoExporEstadoDetallePedido(Boolean habilitarResaltarDetallePedidoExpor) {
		this.activarDetallePedidoExporEstadoDetallePedido= habilitarResaltarDetallePedidoExpor;
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

		this.setMostrarDetalleConsignacionEstadoDetallePedido(esInicial);
		this.setMostrarDetallePedidoExporEstadoDetallePedido(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleConsignacion.class)) {
				this.setMostrarDetalleConsignacionEstadoDetallePedido(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetallePedidoExpor.class)) {
				this.setMostrarDetallePedidoExporEstadoDetallePedido(esAsigna);
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

		this.setActivarDetalleConsignacionEstadoDetallePedido(esInicial);
		this.setActivarDetallePedidoExporEstadoDetallePedido(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleConsignacion.class)) {
				this.setActivarDetalleConsignacionEstadoDetallePedido(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetallePedidoExpor.class)) {
				this.setActivarDetallePedidoExporEstadoDetallePedido(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoDetallePedidoBeanSwingJInternalFrame estadodetallepedidoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleConsignacionEstadoDetallePedido(esInicial);
		this.setResaltarDetallePedidoExporEstadoDetallePedido(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleConsignacion.class)) {
				this.setResaltarDetalleConsignacionEstadoDetallePedido(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetallePedidoExpor.class)) {
				this.setResaltarDetallePedidoExporEstadoDetallePedido(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}