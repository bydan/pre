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
package com.bydan.erp.importaciones.util;

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


import com.bydan.erp.importaciones.util.EstadoPedidoCompraConstantesFunciones;
import com.bydan.erp.importaciones.util.EstadoPedidoCompraParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.EstadoPedidoCompraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;



import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.importaciones.business.dataaccess.*;
//import com.bydan.erp.importaciones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoPedidoCompraConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoPedidoCompra";
	public static final String SPATHOPCION="Importaciones";	
	public static final String SPATHMODULO="importaciones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoPedidoCompra"+EstadoPedidoCompraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoPedidoCompraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoPedidoCompraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoPedidoCompraConstantesFunciones.SCHEMA+"_"+EstadoPedidoCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoPedidoCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoPedidoCompraConstantesFunciones.SCHEMA+"_"+EstadoPedidoCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoPedidoCompraConstantesFunciones.SCHEMA+"_"+EstadoPedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoPedidoCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoPedidoCompraConstantesFunciones.SCHEMA+"_"+EstadoPedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoPedidoCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoPedidoCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoPedidoCompraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoPedidoCompraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoPedidoCompraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoPedidoCompraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Pedido Compras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Pedido Compra";
	public static final String SCLASSWEBTITULO_LOWER="Estado Pedido Compra";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoPedidoCompra";
	public static final String OBJECTNAME="estadopedidocompra";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_IMPORTACIONES;	
	public static final String TABLENAME="estado_pedido_compra";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadopedidocompra from "+EstadoPedidoCompraConstantesFunciones.SPERSISTENCENAME+" estadopedidocompra";
	public static String QUERYSELECTNATIVE="select "+EstadoPedidoCompraConstantesFunciones.SCHEMA+"."+EstadoPedidoCompraConstantesFunciones.TABLENAME+".id,"+EstadoPedidoCompraConstantesFunciones.SCHEMA+"."+EstadoPedidoCompraConstantesFunciones.TABLENAME+".version_row,"+EstadoPedidoCompraConstantesFunciones.SCHEMA+"."+EstadoPedidoCompraConstantesFunciones.TABLENAME+".codigo,"+EstadoPedidoCompraConstantesFunciones.SCHEMA+"."+EstadoPedidoCompraConstantesFunciones.TABLENAME+".nombre from "+EstadoPedidoCompraConstantesFunciones.SCHEMA+"."+EstadoPedidoCompraConstantesFunciones.TABLENAME;//+" as "+EstadoPedidoCompraConstantesFunciones.TABLENAME;
	
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
	
	public static String getEstadoPedidoCompraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoPedidoCompraConstantesFunciones.CODIGO)) {sLabelColumna=EstadoPedidoCompraConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoPedidoCompraConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoPedidoCompraConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoPedidoCompraDescripcion(EstadoPedidoCompra estadopedidocompra) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadopedidocompra !=null/* && estadopedidocompra.getId()!=0*/) {
			sDescripcion=estadopedidocompra.getcodigo();//estadopedidocompraestadopedidocompra.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoPedidoCompraDescripcionDetallado(EstadoPedidoCompra estadopedidocompra) {
		String sDescripcion="";
			
		sDescripcion+=EstadoPedidoCompraConstantesFunciones.ID+"=";
		sDescripcion+=estadopedidocompra.getId().toString()+",";
		sDescripcion+=EstadoPedidoCompraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadopedidocompra.getVersionRow().toString()+",";
		sDescripcion+=EstadoPedidoCompraConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadopedidocompra.getcodigo()+",";
		sDescripcion+=EstadoPedidoCompraConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadopedidocompra.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoPedidoCompraDescripcion(EstadoPedidoCompra estadopedidocompra,String sValor) throws Exception {			
		if(estadopedidocompra !=null) {
			estadopedidocompra.setcodigo(sValor);;//estadopedidocompraestadopedidocompra.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoPedidoCompra(EstadoPedidoCompra estadopedidocompra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadopedidocompra.setcodigo(estadopedidocompra.getcodigo().trim());
		estadopedidocompra.setnombre(estadopedidocompra.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoPedidoCompras(List<EstadoPedidoCompra> estadopedidocompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoPedidoCompra estadopedidocompra: estadopedidocompras) {
			estadopedidocompra.setcodigo(estadopedidocompra.getcodigo().trim());
			estadopedidocompra.setnombre(estadopedidocompra.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoPedidoCompra(EstadoPedidoCompra estadopedidocompra,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadopedidocompra.getConCambioAuxiliar()) {
			estadopedidocompra.setIsDeleted(estadopedidocompra.getIsDeletedAuxiliar());	
			estadopedidocompra.setIsNew(estadopedidocompra.getIsNewAuxiliar());	
			estadopedidocompra.setIsChanged(estadopedidocompra.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadopedidocompra.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadopedidocompra.setIsDeletedAuxiliar(false);	
			estadopedidocompra.setIsNewAuxiliar(false);	
			estadopedidocompra.setIsChangedAuxiliar(false);
			
			estadopedidocompra.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoPedidoCompras(List<EstadoPedidoCompra> estadopedidocompras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoPedidoCompra estadopedidocompra : estadopedidocompras) {
			if(conAsignarBase && estadopedidocompra.getConCambioAuxiliar()) {
				estadopedidocompra.setIsDeleted(estadopedidocompra.getIsDeletedAuxiliar());	
				estadopedidocompra.setIsNew(estadopedidocompra.getIsNewAuxiliar());	
				estadopedidocompra.setIsChanged(estadopedidocompra.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadopedidocompra.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadopedidocompra.setIsDeletedAuxiliar(false);	
				estadopedidocompra.setIsNewAuxiliar(false);	
				estadopedidocompra.setIsChangedAuxiliar(false);
				
				estadopedidocompra.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoPedidoCompra(EstadoPedidoCompra estadopedidocompra,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoPedidoCompras(List<EstadoPedidoCompra> estadopedidocompras,Boolean conEnteros) throws Exception  {
		
		for(EstadoPedidoCompra estadopedidocompra: estadopedidocompras) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoPedidoCompra(List<EstadoPedidoCompra> estadopedidocompras,EstadoPedidoCompra estadopedidocompraAux) throws Exception  {
		EstadoPedidoCompraConstantesFunciones.InicializarValoresEstadoPedidoCompra(estadopedidocompraAux,true);
		
		for(EstadoPedidoCompra estadopedidocompra: estadopedidocompras) {
			if(estadopedidocompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoPedidoCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoPedidoCompraConstantesFunciones.getArrayColumnasGlobalesEstadoPedidoCompra(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoPedidoCompra(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoPedidoCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoPedidoCompra> estadopedidocompras,EstadoPedidoCompra estadopedidocompra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoPedidoCompra estadopedidocompraAux: estadopedidocompras) {
			if(estadopedidocompraAux!=null && estadopedidocompra!=null) {
				if((estadopedidocompraAux.getId()==null && estadopedidocompra.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadopedidocompraAux.getId()!=null && estadopedidocompra.getId()!=null){
					if(estadopedidocompraAux.getId().equals(estadopedidocompra.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoPedidoCompra(List<EstadoPedidoCompra> estadopedidocompras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoPedidoCompra estadopedidocompra: estadopedidocompras) {			
			if(estadopedidocompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoPedidoCompra() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoPedidoCompraConstantesFunciones.LABEL_ID, EstadoPedidoCompraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoPedidoCompraConstantesFunciones.LABEL_VERSIONROW, EstadoPedidoCompraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoPedidoCompraConstantesFunciones.LABEL_CODIGO, EstadoPedidoCompraConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoPedidoCompraConstantesFunciones.LABEL_NOMBRE, EstadoPedidoCompraConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoPedidoCompra() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoPedidoCompraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoPedidoCompraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoPedidoCompraConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoPedidoCompraConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoPedidoCompra() throws Exception  {
		return EstadoPedidoCompraConstantesFunciones.getTiposSeleccionarEstadoPedidoCompra(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoPedidoCompra(Boolean conFk) throws Exception  {
		return EstadoPedidoCompraConstantesFunciones.getTiposSeleccionarEstadoPedidoCompra(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoPedidoCompra(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoPedidoCompraConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoPedidoCompraConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoPedidoCompraConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoPedidoCompraConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoPedidoCompra(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoPedidoCompra(EstadoPedidoCompra estadopedidocompraAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoPedidoCompra(List<EstadoPedidoCompra> estadopedidocomprasTemp) throws Exception {
		for(EstadoPedidoCompra estadopedidocompraAux:estadopedidocomprasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoPedidoCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoPedidoCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoPedidoCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoPedidoCompraConstantesFunciones.getClassesRelationshipsOfEstadoPedidoCompra(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoPedidoCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoPedidoCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoPedidoCompraConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoPedidoCompra(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoPedidoCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(EstadoPedidoCompra estadopedidocompra,List<EstadoPedidoCompra> estadopedidocompras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoPedidoCompra estadopedidocompraEncontrado=null;
			
			for(EstadoPedidoCompra estadopedidocompraLocal:estadopedidocompras) {
				if(estadopedidocompraLocal.getId().equals(estadopedidocompra.getId())) {
					estadopedidocompraEncontrado=estadopedidocompraLocal;
					
					estadopedidocompraLocal.setIsChanged(estadopedidocompra.getIsChanged());
					estadopedidocompraLocal.setIsNew(estadopedidocompra.getIsNew());
					estadopedidocompraLocal.setIsDeleted(estadopedidocompra.getIsDeleted());
					
					estadopedidocompraLocal.setGeneralEntityOriginal(estadopedidocompra.getGeneralEntityOriginal());
					
					estadopedidocompraLocal.setId(estadopedidocompra.getId());	
					estadopedidocompraLocal.setVersionRow(estadopedidocompra.getVersionRow());	
					estadopedidocompraLocal.setcodigo(estadopedidocompra.getcodigo());	
					estadopedidocompraLocal.setnombre(estadopedidocompra.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!estadopedidocompra.getIsDeleted()) {
				if(!existe) {
					estadopedidocompras.add(estadopedidocompra);
				}
			} else {
				if(estadopedidocompraEncontrado!=null && permiteQuitar)  {
					estadopedidocompras.remove(estadopedidocompraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoPedidoCompra estadopedidocompra,List<EstadoPedidoCompra> estadopedidocompras) throws Exception {
		try	{			
			for(EstadoPedidoCompra estadopedidocompraLocal:estadopedidocompras) {
				if(estadopedidocompraLocal.getId().equals(estadopedidocompra.getId())) {
					estadopedidocompraLocal.setIsSelected(estadopedidocompra.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoPedidoCompra(List<EstadoPedidoCompra> estadopedidocomprasAux) throws Exception {
		//this.estadopedidocomprasAux=estadopedidocomprasAux;
		
		for(EstadoPedidoCompra estadopedidocompraAux:estadopedidocomprasAux) {
			if(estadopedidocompraAux.getIsChanged()) {
				estadopedidocompraAux.setIsChanged(false);
			}		
			
			if(estadopedidocompraAux.getIsNew()) {
				estadopedidocompraAux.setIsNew(false);
			}	
			
			if(estadopedidocompraAux.getIsDeleted()) {
				estadopedidocompraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoPedidoCompra(EstadoPedidoCompra estadopedidocompraAux) throws Exception {
		//this.estadopedidocompraAux=estadopedidocompraAux;
		
			if(estadopedidocompraAux.getIsChanged()) {
				estadopedidocompraAux.setIsChanged(false);
			}		
			
			if(estadopedidocompraAux.getIsNew()) {
				estadopedidocompraAux.setIsNew(false);
			}	
			
			if(estadopedidocompraAux.getIsDeleted()) {
				estadopedidocompraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoPedidoCompra estadopedidocompraAsignar,EstadoPedidoCompra estadopedidocompra) throws Exception {
		estadopedidocompraAsignar.setId(estadopedidocompra.getId());	
		estadopedidocompraAsignar.setVersionRow(estadopedidocompra.getVersionRow());	
		estadopedidocompraAsignar.setcodigo(estadopedidocompra.getcodigo());	
		estadopedidocompraAsignar.setnombre(estadopedidocompra.getnombre());	
	}
	
	public static void inicializarEstadoPedidoCompra(EstadoPedidoCompra estadopedidocompra) throws Exception {
		try {
				estadopedidocompra.setId(0L);	
					
				estadopedidocompra.setcodigo("");	
				estadopedidocompra.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoPedidoCompra(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoPedidoCompraConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoPedidoCompraConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoPedidoCompra(String sTipo,Row row,Workbook workbook,EstadoPedidoCompra estadopedidocompra,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadopedidocompra.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadopedidocompra.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoPedidoCompra=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoPedidoCompra() {
		return this.sFinalQueryEstadoPedidoCompra;
	}
	
	public void setsFinalQueryEstadoPedidoCompra(String sFinalQueryEstadoPedidoCompra) {
		this.sFinalQueryEstadoPedidoCompra= sFinalQueryEstadoPedidoCompra;
	}
	
	public Border resaltarSeleccionarEstadoPedidoCompra=null;
	
	public Border setResaltarSeleccionarEstadoPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPedidoCompraBeanSwingJInternalFrame estadopedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadopedidocompraBeanSwingJInternalFrame.jTtoolBarEstadoPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoPedidoCompra= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoPedidoCompra() {
		return this.resaltarSeleccionarEstadoPedidoCompra;
	}
	
	public void setResaltarSeleccionarEstadoPedidoCompra(Border borderResaltarSeleccionarEstadoPedidoCompra) {
		this.resaltarSeleccionarEstadoPedidoCompra= borderResaltarSeleccionarEstadoPedidoCompra;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoPedidoCompra=null;
	public Boolean mostraridEstadoPedidoCompra=true;
	public Boolean activaridEstadoPedidoCompra=true;

	public Border resaltarcodigoEstadoPedidoCompra=null;
	public Boolean mostrarcodigoEstadoPedidoCompra=true;
	public Boolean activarcodigoEstadoPedidoCompra=true;

	public Border resaltarnombreEstadoPedidoCompra=null;
	public Boolean mostrarnombreEstadoPedidoCompra=true;
	public Boolean activarnombreEstadoPedidoCompra=true;

	
	

	public Border setResaltaridEstadoPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPedidoCompraBeanSwingJInternalFrame estadopedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadopedidocompraBeanSwingJInternalFrame.jTtoolBarEstadoPedidoCompra.setBorder(borderResaltar);
		
		this.resaltaridEstadoPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoPedidoCompra() {
		return this.resaltaridEstadoPedidoCompra;
	}

	public void setResaltaridEstadoPedidoCompra(Border borderResaltar) {
		this.resaltaridEstadoPedidoCompra= borderResaltar;
	}

	public Boolean getMostraridEstadoPedidoCompra() {
		return this.mostraridEstadoPedidoCompra;
	}

	public void setMostraridEstadoPedidoCompra(Boolean mostraridEstadoPedidoCompra) {
		this.mostraridEstadoPedidoCompra= mostraridEstadoPedidoCompra;
	}

	public Boolean getActivaridEstadoPedidoCompra() {
		return this.activaridEstadoPedidoCompra;
	}

	public void setActivaridEstadoPedidoCompra(Boolean activaridEstadoPedidoCompra) {
		this.activaridEstadoPedidoCompra= activaridEstadoPedidoCompra;
	}

	public Border setResaltarcodigoEstadoPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPedidoCompraBeanSwingJInternalFrame estadopedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadopedidocompraBeanSwingJInternalFrame.jTtoolBarEstadoPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoPedidoCompra() {
		return this.resaltarcodigoEstadoPedidoCompra;
	}

	public void setResaltarcodigoEstadoPedidoCompra(Border borderResaltar) {
		this.resaltarcodigoEstadoPedidoCompra= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoPedidoCompra() {
		return this.mostrarcodigoEstadoPedidoCompra;
	}

	public void setMostrarcodigoEstadoPedidoCompra(Boolean mostrarcodigoEstadoPedidoCompra) {
		this.mostrarcodigoEstadoPedidoCompra= mostrarcodigoEstadoPedidoCompra;
	}

	public Boolean getActivarcodigoEstadoPedidoCompra() {
		return this.activarcodigoEstadoPedidoCompra;
	}

	public void setActivarcodigoEstadoPedidoCompra(Boolean activarcodigoEstadoPedidoCompra) {
		this.activarcodigoEstadoPedidoCompra= activarcodigoEstadoPedidoCompra;
	}

	public Border setResaltarnombreEstadoPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPedidoCompraBeanSwingJInternalFrame estadopedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadopedidocompraBeanSwingJInternalFrame.jTtoolBarEstadoPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoPedidoCompra() {
		return this.resaltarnombreEstadoPedidoCompra;
	}

	public void setResaltarnombreEstadoPedidoCompra(Border borderResaltar) {
		this.resaltarnombreEstadoPedidoCompra= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoPedidoCompra() {
		return this.mostrarnombreEstadoPedidoCompra;
	}

	public void setMostrarnombreEstadoPedidoCompra(Boolean mostrarnombreEstadoPedidoCompra) {
		this.mostrarnombreEstadoPedidoCompra= mostrarnombreEstadoPedidoCompra;
	}

	public Boolean getActivarnombreEstadoPedidoCompra() {
		return this.activarnombreEstadoPedidoCompra;
	}

	public void setActivarnombreEstadoPedidoCompra(Boolean activarnombreEstadoPedidoCompra) {
		this.activarnombreEstadoPedidoCompra= activarnombreEstadoPedidoCompra;
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
		
		
		this.setMostraridEstadoPedidoCompra(esInicial);
		this.setMostrarcodigoEstadoPedidoCompra(esInicial);
		this.setMostrarnombreEstadoPedidoCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoPedidoCompraConstantesFunciones.ID)) {
				this.setMostraridEstadoPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPedidoCompraConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPedidoCompraConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoPedidoCompra(esAsigna);
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
		
		
		this.setActivaridEstadoPedidoCompra(esInicial);
		this.setActivarcodigoEstadoPedidoCompra(esInicial);
		this.setActivarnombreEstadoPedidoCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoPedidoCompraConstantesFunciones.ID)) {
				this.setActivaridEstadoPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPedidoCompraConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPedidoCompraConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoPedidoCompra(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoPedidoCompraBeanSwingJInternalFrame estadopedidocompraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoPedidoCompra(esInicial);
		this.setResaltarcodigoEstadoPedidoCompra(esInicial);
		this.setResaltarnombreEstadoPedidoCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoPedidoCompraConstantesFunciones.ID)) {
				this.setResaltaridEstadoPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPedidoCompraConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPedidoCompraConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoPedidoCompra(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoPedidoCompraBeanSwingJInternalFrame estadopedidocompraBeanSwingJInternalFrame*/)throws Exception {	
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