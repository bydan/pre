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


import com.bydan.erp.facturacion.util.EstadoPedidoConstantesFunciones;
import com.bydan.erp.facturacion.util.EstadoPedidoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.EstadoPedidoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoPedidoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoPedido";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoPedido"+EstadoPedidoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoPedidoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoPedidoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoPedidoConstantesFunciones.SCHEMA+"_"+EstadoPedidoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoPedidoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoPedidoConstantesFunciones.SCHEMA+"_"+EstadoPedidoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoPedidoConstantesFunciones.SCHEMA+"_"+EstadoPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoPedidoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoPedidoConstantesFunciones.SCHEMA+"_"+EstadoPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoPedidoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoPedidoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoPedidoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoPedidoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoPedidoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoPedidoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Pedidos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Pedido";
	public static final String SCLASSWEBTITULO_LOWER="Estado Pedido";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoPedido";
	public static final String OBJECTNAME="estadopedido";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="estado_pedido";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadopedido from "+EstadoPedidoConstantesFunciones.SPERSISTENCENAME+" estadopedido";
	public static String QUERYSELECTNATIVE="select "+EstadoPedidoConstantesFunciones.SCHEMA+"."+EstadoPedidoConstantesFunciones.TABLENAME+".id,"+EstadoPedidoConstantesFunciones.SCHEMA+"."+EstadoPedidoConstantesFunciones.TABLENAME+".version_row,"+EstadoPedidoConstantesFunciones.SCHEMA+"."+EstadoPedidoConstantesFunciones.TABLENAME+".codigo,"+EstadoPedidoConstantesFunciones.SCHEMA+"."+EstadoPedidoConstantesFunciones.TABLENAME+".nombre,"+EstadoPedidoConstantesFunciones.SCHEMA+"."+EstadoPedidoConstantesFunciones.TABLENAME+".id_color_general from "+EstadoPedidoConstantesFunciones.SCHEMA+"."+EstadoPedidoConstantesFunciones.TABLENAME;//+" as "+EstadoPedidoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String IDCOLORGENERAL= "id_color_general";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_IDCOLORGENERAL= "Color General";
		public static final String LABEL_IDCOLORGENERAL_LOWER= "Color General";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getEstadoPedidoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoPedidoConstantesFunciones.CODIGO)) {sLabelColumna=EstadoPedidoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoPedidoConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoPedidoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(EstadoPedidoConstantesFunciones.IDCOLORGENERAL)) {sLabelColumna=EstadoPedidoConstantesFunciones.LABEL_IDCOLORGENERAL;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getEstadoPedidoDescripcion(EstadoPedido estadopedido) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadopedido !=null/* && estadopedido.getId()!=0*/) {
			sDescripcion=estadopedido.getcodigo();//estadopedidoestadopedido.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoPedidoDescripcionDetallado(EstadoPedido estadopedido) {
		String sDescripcion="";
			
		sDescripcion+=EstadoPedidoConstantesFunciones.ID+"=";
		sDescripcion+=estadopedido.getId().toString()+",";
		sDescripcion+=EstadoPedidoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadopedido.getVersionRow().toString()+",";
		sDescripcion+=EstadoPedidoConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadopedido.getcodigo()+",";
		sDescripcion+=EstadoPedidoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadopedido.getnombre()+",";
		sDescripcion+=EstadoPedidoConstantesFunciones.IDCOLORGENERAL+"=";
		sDescripcion+=estadopedido.getid_color_general().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoPedidoDescripcion(EstadoPedido estadopedido,String sValor) throws Exception {			
		if(estadopedido !=null) {
			estadopedido.setcodigo(sValor);;//estadopedidoestadopedido.getcodigo().trim();
		}		
	}
	
		

	public static String getColorGeneralDescripcion(ColorGeneral colorgeneral) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(colorgeneral!=null/*&&colorgeneral.getId()>0*/) {
			sDescripcion=ColorGeneralConstantesFunciones.getColorGeneralDescripcion(colorgeneral);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdColorGeneral")) {
			sNombreIndice="Tipo=  Por Color General";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdColorGeneral(Long id_color_general) {
		String sDetalleIndice=" Parametros->";
		if(id_color_general!=null) {sDetalleIndice+=" Codigo Unico De Color General="+id_color_general.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEstadoPedido(EstadoPedido estadopedido,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadopedido.setcodigo(estadopedido.getcodigo().trim());
		estadopedido.setnombre(estadopedido.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoPedidos(List<EstadoPedido> estadopedidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoPedido estadopedido: estadopedidos) {
			estadopedido.setcodigo(estadopedido.getcodigo().trim());
			estadopedido.setnombre(estadopedido.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoPedido(EstadoPedido estadopedido,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadopedido.getConCambioAuxiliar()) {
			estadopedido.setIsDeleted(estadopedido.getIsDeletedAuxiliar());	
			estadopedido.setIsNew(estadopedido.getIsNewAuxiliar());	
			estadopedido.setIsChanged(estadopedido.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadopedido.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadopedido.setIsDeletedAuxiliar(false);	
			estadopedido.setIsNewAuxiliar(false);	
			estadopedido.setIsChangedAuxiliar(false);
			
			estadopedido.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoPedidos(List<EstadoPedido> estadopedidos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoPedido estadopedido : estadopedidos) {
			if(conAsignarBase && estadopedido.getConCambioAuxiliar()) {
				estadopedido.setIsDeleted(estadopedido.getIsDeletedAuxiliar());	
				estadopedido.setIsNew(estadopedido.getIsNewAuxiliar());	
				estadopedido.setIsChanged(estadopedido.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadopedido.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadopedido.setIsDeletedAuxiliar(false);	
				estadopedido.setIsNewAuxiliar(false);	
				estadopedido.setIsChangedAuxiliar(false);
				
				estadopedido.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoPedido(EstadoPedido estadopedido,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoPedidos(List<EstadoPedido> estadopedidos,Boolean conEnteros) throws Exception  {
		
		for(EstadoPedido estadopedido: estadopedidos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoPedido(List<EstadoPedido> estadopedidos,EstadoPedido estadopedidoAux) throws Exception  {
		EstadoPedidoConstantesFunciones.InicializarValoresEstadoPedido(estadopedidoAux,true);
		
		for(EstadoPedido estadopedido: estadopedidos) {
			if(estadopedido.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoPedido(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoPedidoConstantesFunciones.getArrayColumnasGlobalesEstadoPedido(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoPedido(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoPedido(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoPedido> estadopedidos,EstadoPedido estadopedido,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoPedido estadopedidoAux: estadopedidos) {
			if(estadopedidoAux!=null && estadopedido!=null) {
				if((estadopedidoAux.getId()==null && estadopedido.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadopedidoAux.getId()!=null && estadopedido.getId()!=null){
					if(estadopedidoAux.getId().equals(estadopedido.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoPedido(List<EstadoPedido> estadopedidos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoPedido estadopedido: estadopedidos) {			
			if(estadopedido.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoPedido() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoPedidoConstantesFunciones.LABEL_ID, EstadoPedidoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoPedidoConstantesFunciones.LABEL_VERSIONROW, EstadoPedidoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoPedidoConstantesFunciones.LABEL_CODIGO, EstadoPedidoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoPedidoConstantesFunciones.LABEL_NOMBRE, EstadoPedidoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoPedidoConstantesFunciones.LABEL_IDCOLORGENERAL, EstadoPedidoConstantesFunciones.IDCOLORGENERAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoPedido() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoPedidoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoPedidoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoPedidoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoPedidoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoPedidoConstantesFunciones.IDCOLORGENERAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoPedido() throws Exception  {
		return EstadoPedidoConstantesFunciones.getTiposSeleccionarEstadoPedido(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoPedido(Boolean conFk) throws Exception  {
		return EstadoPedidoConstantesFunciones.getTiposSeleccionarEstadoPedido(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoPedido(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoPedidoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoPedidoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoPedidoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoPedidoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoPedidoConstantesFunciones.LABEL_IDCOLORGENERAL);
			reporte.setsDescripcion(EstadoPedidoConstantesFunciones.LABEL_IDCOLORGENERAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoPedido(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoPedido(EstadoPedido estadopedidoAux) throws Exception {
		
			estadopedidoAux.setcolorgeneral_descripcion(ColorGeneralConstantesFunciones.getColorGeneralDescripcion(estadopedidoAux.getColorGeneral()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoPedido(List<EstadoPedido> estadopedidosTemp) throws Exception {
		for(EstadoPedido estadopedidoAux:estadopedidosTemp) {
			
			estadopedidoAux.setcolorgeneral_descripcion(ColorGeneralConstantesFunciones.getColorGeneralDescripcion(estadopedidoAux.getColorGeneral()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ColorGeneral.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ColorGeneral.class)) {
						classes.add(new Classe(ColorGeneral.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoPedido(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ColorGeneral.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ColorGeneral.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ColorGeneral.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ColorGeneral.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoPedidoConstantesFunciones.getClassesRelationshipsOfEstadoPedido(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ParametroCompra.class));
				classes.add(new Classe(Consignacion.class));
				classes.add(new Classe(Pedido.class));
				classes.add(new Classe(PedidoExpor.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroCompra.class)) {
						classes.add(new Classe(ParametroCompra.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Consignacion.class)) {
						classes.add(new Classe(Consignacion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pedido.class)) {
						classes.add(new Classe(Pedido.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoExpor.class)) {
						classes.add(new Classe(PedidoExpor.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoPedido(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoPedidoConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoPedido(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoPedido(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCompra.class)); continue;
					}

					if(Consignacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignacion.class)); continue;
					}

					if(Pedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pedido.class)); continue;
					}

					if(PedidoExpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoExpor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCompra.class)); continue;
					}

					if(Consignacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignacion.class)); continue;
					}

					if(Pedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pedido.class)); continue;
					}

					if(PedidoExpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoExpor.class)); continue;
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
	public static void actualizarLista(EstadoPedido estadopedido,List<EstadoPedido> estadopedidos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoPedido estadopedidoEncontrado=null;
			
			for(EstadoPedido estadopedidoLocal:estadopedidos) {
				if(estadopedidoLocal.getId().equals(estadopedido.getId())) {
					estadopedidoEncontrado=estadopedidoLocal;
					
					estadopedidoLocal.setIsChanged(estadopedido.getIsChanged());
					estadopedidoLocal.setIsNew(estadopedido.getIsNew());
					estadopedidoLocal.setIsDeleted(estadopedido.getIsDeleted());
					
					estadopedidoLocal.setGeneralEntityOriginal(estadopedido.getGeneralEntityOriginal());
					
					estadopedidoLocal.setId(estadopedido.getId());	
					estadopedidoLocal.setVersionRow(estadopedido.getVersionRow());	
					estadopedidoLocal.setcodigo(estadopedido.getcodigo());	
					estadopedidoLocal.setnombre(estadopedido.getnombre());	
					estadopedidoLocal.setid_color_general(estadopedido.getid_color_general());	
					
					
					estadopedidoLocal.setConsignacions(estadopedido.getConsignacions());
					estadopedidoLocal.setPedidoExporExpors(estadopedido.getPedidoExporExpors());
					
					existe=true;
					break;
				}
			}
			
			if(!estadopedido.getIsDeleted()) {
				if(!existe) {
					estadopedidos.add(estadopedido);
				}
			} else {
				if(estadopedidoEncontrado!=null && permiteQuitar)  {
					estadopedidos.remove(estadopedidoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoPedido estadopedido,List<EstadoPedido> estadopedidos) throws Exception {
		try	{			
			for(EstadoPedido estadopedidoLocal:estadopedidos) {
				if(estadopedidoLocal.getId().equals(estadopedido.getId())) {
					estadopedidoLocal.setIsSelected(estadopedido.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoPedido(List<EstadoPedido> estadopedidosAux) throws Exception {
		//this.estadopedidosAux=estadopedidosAux;
		
		for(EstadoPedido estadopedidoAux:estadopedidosAux) {
			if(estadopedidoAux.getIsChanged()) {
				estadopedidoAux.setIsChanged(false);
			}		
			
			if(estadopedidoAux.getIsNew()) {
				estadopedidoAux.setIsNew(false);
			}	
			
			if(estadopedidoAux.getIsDeleted()) {
				estadopedidoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoPedido(EstadoPedido estadopedidoAux) throws Exception {
		//this.estadopedidoAux=estadopedidoAux;
		
			if(estadopedidoAux.getIsChanged()) {
				estadopedidoAux.setIsChanged(false);
			}		
			
			if(estadopedidoAux.getIsNew()) {
				estadopedidoAux.setIsNew(false);
			}	
			
			if(estadopedidoAux.getIsDeleted()) {
				estadopedidoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoPedido estadopedidoAsignar,EstadoPedido estadopedido) throws Exception {
		estadopedidoAsignar.setId(estadopedido.getId());	
		estadopedidoAsignar.setVersionRow(estadopedido.getVersionRow());	
		estadopedidoAsignar.setcodigo(estadopedido.getcodigo());	
		estadopedidoAsignar.setnombre(estadopedido.getnombre());	
		estadopedidoAsignar.setid_color_general(estadopedido.getid_color_general());
		estadopedidoAsignar.setcolorgeneral_descripcion(estadopedido.getcolorgeneral_descripcion());	
	}
	
	public static void inicializarEstadoPedido(EstadoPedido estadopedido) throws Exception {
		try {
				estadopedido.setId(0L);	
					
				estadopedido.setcodigo("");	
				estadopedido.setnombre("");	
				estadopedido.setid_color_general(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoPedido(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoPedidoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoPedidoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoPedidoConstantesFunciones.LABEL_IDCOLORGENERAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoPedido(String sTipo,Row row,Workbook workbook,EstadoPedido estadopedido,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadopedido.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadopedido.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadopedido.getcolorgeneral_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoPedido=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoPedido() {
		return this.sFinalQueryEstadoPedido;
	}
	
	public void setsFinalQueryEstadoPedido(String sFinalQueryEstadoPedido) {
		this.sFinalQueryEstadoPedido= sFinalQueryEstadoPedido;
	}
	
	public Border resaltarSeleccionarEstadoPedido=null;
	
	public Border setResaltarSeleccionarEstadoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPedidoBeanSwingJInternalFrame estadopedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadopedidoBeanSwingJInternalFrame.jTtoolBarEstadoPedido.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoPedido= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoPedido() {
		return this.resaltarSeleccionarEstadoPedido;
	}
	
	public void setResaltarSeleccionarEstadoPedido(Border borderResaltarSeleccionarEstadoPedido) {
		this.resaltarSeleccionarEstadoPedido= borderResaltarSeleccionarEstadoPedido;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoPedido=null;
	public Boolean mostraridEstadoPedido=true;
	public Boolean activaridEstadoPedido=true;

	public Border resaltarcodigoEstadoPedido=null;
	public Boolean mostrarcodigoEstadoPedido=true;
	public Boolean activarcodigoEstadoPedido=true;

	public Border resaltarnombreEstadoPedido=null;
	public Boolean mostrarnombreEstadoPedido=true;
	public Boolean activarnombreEstadoPedido=true;

	public Border resaltarid_color_generalEstadoPedido=null;
	public Boolean mostrarid_color_generalEstadoPedido=true;
	public Boolean activarid_color_generalEstadoPedido=true;
	public Boolean cargarid_color_generalEstadoPedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_color_generalEstadoPedido=false;//ConEventDepend=true

	
	

	public Border setResaltaridEstadoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPedidoBeanSwingJInternalFrame estadopedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadopedidoBeanSwingJInternalFrame.jTtoolBarEstadoPedido.setBorder(borderResaltar);
		
		this.resaltaridEstadoPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoPedido() {
		return this.resaltaridEstadoPedido;
	}

	public void setResaltaridEstadoPedido(Border borderResaltar) {
		this.resaltaridEstadoPedido= borderResaltar;
	}

	public Boolean getMostraridEstadoPedido() {
		return this.mostraridEstadoPedido;
	}

	public void setMostraridEstadoPedido(Boolean mostraridEstadoPedido) {
		this.mostraridEstadoPedido= mostraridEstadoPedido;
	}

	public Boolean getActivaridEstadoPedido() {
		return this.activaridEstadoPedido;
	}

	public void setActivaridEstadoPedido(Boolean activaridEstadoPedido) {
		this.activaridEstadoPedido= activaridEstadoPedido;
	}

	public Border setResaltarcodigoEstadoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPedidoBeanSwingJInternalFrame estadopedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadopedidoBeanSwingJInternalFrame.jTtoolBarEstadoPedido.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoPedido() {
		return this.resaltarcodigoEstadoPedido;
	}

	public void setResaltarcodigoEstadoPedido(Border borderResaltar) {
		this.resaltarcodigoEstadoPedido= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoPedido() {
		return this.mostrarcodigoEstadoPedido;
	}

	public void setMostrarcodigoEstadoPedido(Boolean mostrarcodigoEstadoPedido) {
		this.mostrarcodigoEstadoPedido= mostrarcodigoEstadoPedido;
	}

	public Boolean getActivarcodigoEstadoPedido() {
		return this.activarcodigoEstadoPedido;
	}

	public void setActivarcodigoEstadoPedido(Boolean activarcodigoEstadoPedido) {
		this.activarcodigoEstadoPedido= activarcodigoEstadoPedido;
	}

	public Border setResaltarnombreEstadoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPedidoBeanSwingJInternalFrame estadopedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadopedidoBeanSwingJInternalFrame.jTtoolBarEstadoPedido.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoPedido() {
		return this.resaltarnombreEstadoPedido;
	}

	public void setResaltarnombreEstadoPedido(Border borderResaltar) {
		this.resaltarnombreEstadoPedido= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoPedido() {
		return this.mostrarnombreEstadoPedido;
	}

	public void setMostrarnombreEstadoPedido(Boolean mostrarnombreEstadoPedido) {
		this.mostrarnombreEstadoPedido= mostrarnombreEstadoPedido;
	}

	public Boolean getActivarnombreEstadoPedido() {
		return this.activarnombreEstadoPedido;
	}

	public void setActivarnombreEstadoPedido(Boolean activarnombreEstadoPedido) {
		this.activarnombreEstadoPedido= activarnombreEstadoPedido;
	}

	public Border setResaltarid_color_generalEstadoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPedidoBeanSwingJInternalFrame estadopedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadopedidoBeanSwingJInternalFrame.jTtoolBarEstadoPedido.setBorder(borderResaltar);
		
		this.resaltarid_color_generalEstadoPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_color_generalEstadoPedido() {
		return this.resaltarid_color_generalEstadoPedido;
	}

	public void setResaltarid_color_generalEstadoPedido(Border borderResaltar) {
		this.resaltarid_color_generalEstadoPedido= borderResaltar;
	}

	public Boolean getMostrarid_color_generalEstadoPedido() {
		return this.mostrarid_color_generalEstadoPedido;
	}

	public void setMostrarid_color_generalEstadoPedido(Boolean mostrarid_color_generalEstadoPedido) {
		this.mostrarid_color_generalEstadoPedido= mostrarid_color_generalEstadoPedido;
	}

	public Boolean getActivarid_color_generalEstadoPedido() {
		return this.activarid_color_generalEstadoPedido;
	}

	public void setActivarid_color_generalEstadoPedido(Boolean activarid_color_generalEstadoPedido) {
		this.activarid_color_generalEstadoPedido= activarid_color_generalEstadoPedido;
	}

	public Boolean getCargarid_color_generalEstadoPedido() {
		return this.cargarid_color_generalEstadoPedido;
	}

	public void setCargarid_color_generalEstadoPedido(Boolean cargarid_color_generalEstadoPedido) {
		this.cargarid_color_generalEstadoPedido= cargarid_color_generalEstadoPedido;
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
		
		
		this.setMostraridEstadoPedido(esInicial);
		this.setMostrarcodigoEstadoPedido(esInicial);
		this.setMostrarnombreEstadoPedido(esInicial);
		this.setMostrarid_color_generalEstadoPedido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoPedidoConstantesFunciones.ID)) {
				this.setMostraridEstadoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPedidoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPedidoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPedidoConstantesFunciones.IDCOLORGENERAL)) {
				this.setMostrarid_color_generalEstadoPedido(esAsigna);
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
		
		
		this.setActivaridEstadoPedido(esInicial);
		this.setActivarcodigoEstadoPedido(esInicial);
		this.setActivarnombreEstadoPedido(esInicial);
		this.setActivarid_color_generalEstadoPedido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoPedidoConstantesFunciones.ID)) {
				this.setActivaridEstadoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPedidoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPedidoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPedidoConstantesFunciones.IDCOLORGENERAL)) {
				this.setActivarid_color_generalEstadoPedido(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoPedidoBeanSwingJInternalFrame estadopedidoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoPedido(esInicial);
		this.setResaltarcodigoEstadoPedido(esInicial);
		this.setResaltarnombreEstadoPedido(esInicial);
		this.setResaltarid_color_generalEstadoPedido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoPedidoConstantesFunciones.ID)) {
				this.setResaltaridEstadoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPedidoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPedidoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPedidoConstantesFunciones.IDCOLORGENERAL)) {
				this.setResaltarid_color_generalEstadoPedido(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarConsignacionEstadoPedido=null;

	public Border getResaltarConsignacionEstadoPedido() {
		return this.resaltarConsignacionEstadoPedido;
	}

	public void setResaltarConsignacionEstadoPedido(Border borderResaltarConsignacion) {
		if(borderResaltarConsignacion!=null) {
			this.resaltarConsignacionEstadoPedido= borderResaltarConsignacion;
		}
	}

	public Border setResaltarConsignacionEstadoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPedidoBeanSwingJInternalFrame estadopedidoBeanSwingJInternalFrame*/) {
		Border borderResaltarConsignacion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadopedidoBeanSwingJInternalFrame.jTtoolBarEstadoPedido.setBorder(borderResaltarConsignacion);
			
		this.resaltarConsignacionEstadoPedido= borderResaltarConsignacion;

		 return borderResaltarConsignacion;
	}



	public Boolean mostrarConsignacionEstadoPedido=true;

	public Boolean getMostrarConsignacionEstadoPedido() {
		return this.mostrarConsignacionEstadoPedido;
	}

	public void setMostrarConsignacionEstadoPedido(Boolean visibilidadResaltarConsignacion) {
		this.mostrarConsignacionEstadoPedido= visibilidadResaltarConsignacion;
	}



	public Boolean activarConsignacionEstadoPedido=true;

	public Boolean gethabilitarResaltarConsignacionEstadoPedido() {
		return this.activarConsignacionEstadoPedido;
	}

	public void setActivarConsignacionEstadoPedido(Boolean habilitarResaltarConsignacion) {
		this.activarConsignacionEstadoPedido= habilitarResaltarConsignacion;
	}


	public Border resaltarPedidoExporEstadoPedido=null;

	public Border getResaltarPedidoExporEstadoPedido() {
		return this.resaltarPedidoExporEstadoPedido;
	}

	public void setResaltarPedidoExporEstadoPedido(Border borderResaltarPedidoExpor) {
		if(borderResaltarPedidoExpor!=null) {
			this.resaltarPedidoExporEstadoPedido= borderResaltarPedidoExpor;
		}
	}

	public Border setResaltarPedidoExporEstadoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPedidoBeanSwingJInternalFrame estadopedidoBeanSwingJInternalFrame*/) {
		Border borderResaltarPedidoExpor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadopedidoBeanSwingJInternalFrame.jTtoolBarEstadoPedido.setBorder(borderResaltarPedidoExpor);
			
		this.resaltarPedidoExporEstadoPedido= borderResaltarPedidoExpor;

		 return borderResaltarPedidoExpor;
	}



	public Boolean mostrarPedidoExporEstadoPedido=true;

	public Boolean getMostrarPedidoExporEstadoPedido() {
		return this.mostrarPedidoExporEstadoPedido;
	}

	public void setMostrarPedidoExporEstadoPedido(Boolean visibilidadResaltarPedidoExpor) {
		this.mostrarPedidoExporEstadoPedido= visibilidadResaltarPedidoExpor;
	}



	public Boolean activarPedidoExporEstadoPedido=true;

	public Boolean gethabilitarResaltarPedidoExporEstadoPedido() {
		return this.activarPedidoExporEstadoPedido;
	}

	public void setActivarPedidoExporEstadoPedido(Boolean habilitarResaltarPedidoExpor) {
		this.activarPedidoExporEstadoPedido= habilitarResaltarPedidoExpor;
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

		this.setMostrarConsignacionEstadoPedido(esInicial);
		this.setMostrarPedidoExporEstadoPedido(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Consignacion.class)) {
				this.setMostrarConsignacionEstadoPedido(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoExpor.class)) {
				this.setMostrarPedidoExporEstadoPedido(esAsigna);
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

		this.setActivarConsignacionEstadoPedido(esInicial);
		this.setActivarPedidoExporEstadoPedido(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Consignacion.class)) {
				this.setActivarConsignacionEstadoPedido(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoExpor.class)) {
				this.setActivarPedidoExporEstadoPedido(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoPedidoBeanSwingJInternalFrame estadopedidoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarConsignacionEstadoPedido(esInicial);
		this.setResaltarPedidoExporEstadoPedido(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Consignacion.class)) {
				this.setResaltarConsignacionEstadoPedido(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoExpor.class)) {
				this.setResaltarPedidoExporEstadoPedido(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdColorGeneralEstadoPedido=true;

	public Boolean getMostrarFK_IdColorGeneralEstadoPedido() {
		return this.mostrarFK_IdColorGeneralEstadoPedido;
	}

	public void setMostrarFK_IdColorGeneralEstadoPedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdColorGeneralEstadoPedido= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdColorGeneralEstadoPedido=true;

	public Boolean getActivarFK_IdColorGeneralEstadoPedido() {
		return this.activarFK_IdColorGeneralEstadoPedido;
	}

	public void setActivarFK_IdColorGeneralEstadoPedido(Boolean habilitarResaltar) {
		this.activarFK_IdColorGeneralEstadoPedido= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdColorGeneralEstadoPedido=null;

	public Border getResaltarFK_IdColorGeneralEstadoPedido() {
		return this.resaltarFK_IdColorGeneralEstadoPedido;
	}

	public void setResaltarFK_IdColorGeneralEstadoPedido(Border borderResaltar) {
		this.resaltarFK_IdColorGeneralEstadoPedido= borderResaltar;
	}

	public void setResaltarFK_IdColorGeneralEstadoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPedidoBeanSwingJInternalFrame estadopedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdColorGeneralEstadoPedido= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}