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


import com.bydan.erp.inventario.util.EstadoDetalleOrdenCompraConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoDetalleOrdenCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoDetalleOrdenCompraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoDetalleOrdenCompraConstantesFunciones extends EstadoDetalleOrdenCompraConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoDetalleOrdenCompra";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoDetalleOrdenCompra"+EstadoDetalleOrdenCompraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoDetalleOrdenCompraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoDetalleOrdenCompraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+"_"+EstadoDetalleOrdenCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoDetalleOrdenCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+"_"+EstadoDetalleOrdenCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+"_"+EstadoDetalleOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoDetalleOrdenCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+"_"+EstadoDetalleOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoDetalleOrdenCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoDetalleOrdenCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoDetalleOrdenCompraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoDetalleOrdenCompraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoDetalleOrdenCompraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoDetalleOrdenCompraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Detalle Orden Compras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Detalle Orden Compra";
	public static final String SCLASSWEBTITULO_LOWER="Estado Detalle Orden Compra";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoDetalleOrdenCompra";
	public static final String OBJECTNAME="estadodetalleordencompra";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="estado_detalle_orden_compra";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadodetalleordencompra from "+EstadoDetalleOrdenCompraConstantesFunciones.SPERSISTENCENAME+" estadodetalleordencompra";
	public static String QUERYSELECTNATIVE="select "+EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoDetalleOrdenCompraConstantesFunciones.TABLENAME+".id,"+EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoDetalleOrdenCompraConstantesFunciones.TABLENAME+".version_row,"+EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoDetalleOrdenCompraConstantesFunciones.TABLENAME+".codigo,"+EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoDetalleOrdenCompraConstantesFunciones.TABLENAME+".nombre from "+EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoDetalleOrdenCompraConstantesFunciones.TABLENAME;//+" as "+EstadoDetalleOrdenCompraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoDetalleOrdenCompraConstantesFuncionesAdditional estadodetalleordencompraConstantesFuncionesAdditional=null;
	
	public EstadoDetalleOrdenCompraConstantesFuncionesAdditional getEstadoDetalleOrdenCompraConstantesFuncionesAdditional() {
		return this.estadodetalleordencompraConstantesFuncionesAdditional;
	}
	
	public void setEstadoDetalleOrdenCompraConstantesFuncionesAdditional(EstadoDetalleOrdenCompraConstantesFuncionesAdditional estadodetalleordencompraConstantesFuncionesAdditional) {
		try {
			this.estadodetalleordencompraConstantesFuncionesAdditional=estadodetalleordencompraConstantesFuncionesAdditional;
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
	
	public static String getEstadoDetalleOrdenCompraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoDetalleOrdenCompraConstantesFunciones.CODIGO)) {sLabelColumna=EstadoDetalleOrdenCompraConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoDetalleOrdenCompraConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoDetalleOrdenCompraConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoDetalleOrdenCompraDescripcion(EstadoDetalleOrdenCompra estadodetalleordencompra) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadodetalleordencompra !=null/* && estadodetalleordencompra.getId()!=0*/) {
			sDescripcion=estadodetalleordencompra.getcodigo();//estadodetalleordencompraestadodetalleordencompra.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoDetalleOrdenCompraDescripcionDetallado(EstadoDetalleOrdenCompra estadodetalleordencompra) {
		String sDescripcion="";
			
		sDescripcion+=EstadoDetalleOrdenCompraConstantesFunciones.ID+"=";
		sDescripcion+=estadodetalleordencompra.getId().toString()+",";
		sDescripcion+=EstadoDetalleOrdenCompraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadodetalleordencompra.getVersionRow().toString()+",";
		sDescripcion+=EstadoDetalleOrdenCompraConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadodetalleordencompra.getcodigo()+",";
		sDescripcion+=EstadoDetalleOrdenCompraConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadodetalleordencompra.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoDetalleOrdenCompraDescripcion(EstadoDetalleOrdenCompra estadodetalleordencompra,String sValor) throws Exception {			
		if(estadodetalleordencompra !=null) {
			estadodetalleordencompra.setcodigo(sValor);;//estadodetalleordencompraestadodetalleordencompra.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoDetalleOrdenCompra(EstadoDetalleOrdenCompra estadodetalleordencompra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadodetalleordencompra.setcodigo(estadodetalleordencompra.getcodigo().trim());
		estadodetalleordencompra.setnombre(estadodetalleordencompra.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoDetalleOrdenCompras(List<EstadoDetalleOrdenCompra> estadodetalleordencompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoDetalleOrdenCompra estadodetalleordencompra: estadodetalleordencompras) {
			estadodetalleordencompra.setcodigo(estadodetalleordencompra.getcodigo().trim());
			estadodetalleordencompra.setnombre(estadodetalleordencompra.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoDetalleOrdenCompra(EstadoDetalleOrdenCompra estadodetalleordencompra,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadodetalleordencompra.getConCambioAuxiliar()) {
			estadodetalleordencompra.setIsDeleted(estadodetalleordencompra.getIsDeletedAuxiliar());	
			estadodetalleordencompra.setIsNew(estadodetalleordencompra.getIsNewAuxiliar());	
			estadodetalleordencompra.setIsChanged(estadodetalleordencompra.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadodetalleordencompra.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadodetalleordencompra.setIsDeletedAuxiliar(false);	
			estadodetalleordencompra.setIsNewAuxiliar(false);	
			estadodetalleordencompra.setIsChangedAuxiliar(false);
			
			estadodetalleordencompra.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoDetalleOrdenCompras(List<EstadoDetalleOrdenCompra> estadodetalleordencompras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoDetalleOrdenCompra estadodetalleordencompra : estadodetalleordencompras) {
			if(conAsignarBase && estadodetalleordencompra.getConCambioAuxiliar()) {
				estadodetalleordencompra.setIsDeleted(estadodetalleordencompra.getIsDeletedAuxiliar());	
				estadodetalleordencompra.setIsNew(estadodetalleordencompra.getIsNewAuxiliar());	
				estadodetalleordencompra.setIsChanged(estadodetalleordencompra.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadodetalleordencompra.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadodetalleordencompra.setIsDeletedAuxiliar(false);	
				estadodetalleordencompra.setIsNewAuxiliar(false);	
				estadodetalleordencompra.setIsChangedAuxiliar(false);
				
				estadodetalleordencompra.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoDetalleOrdenCompra(EstadoDetalleOrdenCompra estadodetalleordencompra,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoDetalleOrdenCompras(List<EstadoDetalleOrdenCompra> estadodetalleordencompras,Boolean conEnteros) throws Exception  {
		
		for(EstadoDetalleOrdenCompra estadodetalleordencompra: estadodetalleordencompras) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoDetalleOrdenCompra(List<EstadoDetalleOrdenCompra> estadodetalleordencompras,EstadoDetalleOrdenCompra estadodetalleordencompraAux) throws Exception  {
		EstadoDetalleOrdenCompraConstantesFunciones.InicializarValoresEstadoDetalleOrdenCompra(estadodetalleordencompraAux,true);
		
		for(EstadoDetalleOrdenCompra estadodetalleordencompra: estadodetalleordencompras) {
			if(estadodetalleordencompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoDetalleOrdenCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoDetalleOrdenCompraConstantesFunciones.getArrayColumnasGlobalesEstadoDetalleOrdenCompra(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoDetalleOrdenCompra(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoDetalleOrdenCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoDetalleOrdenCompra> estadodetalleordencompras,EstadoDetalleOrdenCompra estadodetalleordencompra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoDetalleOrdenCompra estadodetalleordencompraAux: estadodetalleordencompras) {
			if(estadodetalleordencompraAux!=null && estadodetalleordencompra!=null) {
				if((estadodetalleordencompraAux.getId()==null && estadodetalleordencompra.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadodetalleordencompraAux.getId()!=null && estadodetalleordencompra.getId()!=null){
					if(estadodetalleordencompraAux.getId().equals(estadodetalleordencompra.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoDetalleOrdenCompra(List<EstadoDetalleOrdenCompra> estadodetalleordencompras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoDetalleOrdenCompra estadodetalleordencompra: estadodetalleordencompras) {			
			if(estadodetalleordencompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoDetalleOrdenCompra() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoDetalleOrdenCompraConstantesFunciones.LABEL_ID, EstadoDetalleOrdenCompraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDetalleOrdenCompraConstantesFunciones.LABEL_VERSIONROW, EstadoDetalleOrdenCompraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDetalleOrdenCompraConstantesFunciones.LABEL_CODIGO, EstadoDetalleOrdenCompraConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDetalleOrdenCompraConstantesFunciones.LABEL_NOMBRE, EstadoDetalleOrdenCompraConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoDetalleOrdenCompra() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleOrdenCompraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleOrdenCompraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleOrdenCompraConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleOrdenCompraConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDetalleOrdenCompra() throws Exception  {
		return EstadoDetalleOrdenCompraConstantesFunciones.getTiposSeleccionarEstadoDetalleOrdenCompra(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDetalleOrdenCompra(Boolean conFk) throws Exception  {
		return EstadoDetalleOrdenCompraConstantesFunciones.getTiposSeleccionarEstadoDetalleOrdenCompra(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDetalleOrdenCompra(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoDetalleOrdenCompraConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoDetalleOrdenCompraConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoDetalleOrdenCompraConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoDetalleOrdenCompraConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoDetalleOrdenCompra(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoDetalleOrdenCompra(EstadoDetalleOrdenCompra estadodetalleordencompraAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoDetalleOrdenCompra(List<EstadoDetalleOrdenCompra> estadodetalleordencomprasTemp) throws Exception {
		for(EstadoDetalleOrdenCompra estadodetalleordencompraAux:estadodetalleordencomprasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoDetalleOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoDetalleOrdenCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDetalleOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoDetalleOrdenCompraConstantesFunciones.getClassesRelationshipsOfEstadoDetalleOrdenCompra(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDetalleOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleOrdenCompra.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleOrdenCompra.class)) {
						classes.add(new Classe(DetalleOrdenCompra.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoDetalleOrdenCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoDetalleOrdenCompraConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoDetalleOrdenCompra(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoDetalleOrdenCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleOrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleOrdenCompra.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleOrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleOrdenCompra.class)); continue;
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
	public static void actualizarLista(EstadoDetalleOrdenCompra estadodetalleordencompra,List<EstadoDetalleOrdenCompra> estadodetalleordencompras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoDetalleOrdenCompra estadodetalleordencompraEncontrado=null;
			
			for(EstadoDetalleOrdenCompra estadodetalleordencompraLocal:estadodetalleordencompras) {
				if(estadodetalleordencompraLocal.getId().equals(estadodetalleordencompra.getId())) {
					estadodetalleordencompraEncontrado=estadodetalleordencompraLocal;
					
					estadodetalleordencompraLocal.setIsChanged(estadodetalleordencompra.getIsChanged());
					estadodetalleordencompraLocal.setIsNew(estadodetalleordencompra.getIsNew());
					estadodetalleordencompraLocal.setIsDeleted(estadodetalleordencompra.getIsDeleted());
					
					estadodetalleordencompraLocal.setGeneralEntityOriginal(estadodetalleordencompra.getGeneralEntityOriginal());
					
					estadodetalleordencompraLocal.setId(estadodetalleordencompra.getId());	
					estadodetalleordencompraLocal.setVersionRow(estadodetalleordencompra.getVersionRow());	
					estadodetalleordencompraLocal.setcodigo(estadodetalleordencompra.getcodigo());	
					estadodetalleordencompraLocal.setnombre(estadodetalleordencompra.getnombre());	
					
					
					estadodetalleordencompraLocal.setDetalleOrdenCompras(estadodetalleordencompra.getDetalleOrdenCompras());
					
					existe=true;
					break;
				}
			}
			
			if(!estadodetalleordencompra.getIsDeleted()) {
				if(!existe) {
					estadodetalleordencompras.add(estadodetalleordencompra);
				}
			} else {
				if(estadodetalleordencompraEncontrado!=null && permiteQuitar)  {
					estadodetalleordencompras.remove(estadodetalleordencompraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoDetalleOrdenCompra estadodetalleordencompra,List<EstadoDetalleOrdenCompra> estadodetalleordencompras) throws Exception {
		try	{			
			for(EstadoDetalleOrdenCompra estadodetalleordencompraLocal:estadodetalleordencompras) {
				if(estadodetalleordencompraLocal.getId().equals(estadodetalleordencompra.getId())) {
					estadodetalleordencompraLocal.setIsSelected(estadodetalleordencompra.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoDetalleOrdenCompra(List<EstadoDetalleOrdenCompra> estadodetalleordencomprasAux) throws Exception {
		//this.estadodetalleordencomprasAux=estadodetalleordencomprasAux;
		
		for(EstadoDetalleOrdenCompra estadodetalleordencompraAux:estadodetalleordencomprasAux) {
			if(estadodetalleordencompraAux.getIsChanged()) {
				estadodetalleordencompraAux.setIsChanged(false);
			}		
			
			if(estadodetalleordencompraAux.getIsNew()) {
				estadodetalleordencompraAux.setIsNew(false);
			}	
			
			if(estadodetalleordencompraAux.getIsDeleted()) {
				estadodetalleordencompraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoDetalleOrdenCompra(EstadoDetalleOrdenCompra estadodetalleordencompraAux) throws Exception {
		//this.estadodetalleordencompraAux=estadodetalleordencompraAux;
		
			if(estadodetalleordencompraAux.getIsChanged()) {
				estadodetalleordencompraAux.setIsChanged(false);
			}		
			
			if(estadodetalleordencompraAux.getIsNew()) {
				estadodetalleordencompraAux.setIsNew(false);
			}	
			
			if(estadodetalleordencompraAux.getIsDeleted()) {
				estadodetalleordencompraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoDetalleOrdenCompra estadodetalleordencompraAsignar,EstadoDetalleOrdenCompra estadodetalleordencompra) throws Exception {
		estadodetalleordencompraAsignar.setId(estadodetalleordencompra.getId());	
		estadodetalleordencompraAsignar.setVersionRow(estadodetalleordencompra.getVersionRow());	
		estadodetalleordencompraAsignar.setcodigo(estadodetalleordencompra.getcodigo());	
		estadodetalleordencompraAsignar.setnombre(estadodetalleordencompra.getnombre());	
	}
	
	public static void inicializarEstadoDetalleOrdenCompra(EstadoDetalleOrdenCompra estadodetalleordencompra) throws Exception {
		try {
				estadodetalleordencompra.setId(0L);	
					
				estadodetalleordencompra.setcodigo("");	
				estadodetalleordencompra.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoDetalleOrdenCompra(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoDetalleOrdenCompraConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoDetalleOrdenCompraConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoDetalleOrdenCompra(String sTipo,Row row,Workbook workbook,EstadoDetalleOrdenCompra estadodetalleordencompra,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadodetalleordencompra.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadodetalleordencompra.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoDetalleOrdenCompra=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoDetalleOrdenCompra() {
		return this.sFinalQueryEstadoDetalleOrdenCompra;
	}
	
	public void setsFinalQueryEstadoDetalleOrdenCompra(String sFinalQueryEstadoDetalleOrdenCompra) {
		this.sFinalQueryEstadoDetalleOrdenCompra= sFinalQueryEstadoDetalleOrdenCompra;
	}
	
	public Border resaltarSeleccionarEstadoDetalleOrdenCompra=null;
	
	public Border setResaltarSeleccionarEstadoDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleOrdenCompraBeanSwingJInternalFrame estadodetalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadodetalleordencompraBeanSwingJInternalFrame.jTtoolBarEstadoDetalleOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoDetalleOrdenCompra= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoDetalleOrdenCompra() {
		return this.resaltarSeleccionarEstadoDetalleOrdenCompra;
	}
	
	public void setResaltarSeleccionarEstadoDetalleOrdenCompra(Border borderResaltarSeleccionarEstadoDetalleOrdenCompra) {
		this.resaltarSeleccionarEstadoDetalleOrdenCompra= borderResaltarSeleccionarEstadoDetalleOrdenCompra;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoDetalleOrdenCompra=null;
	public Boolean mostraridEstadoDetalleOrdenCompra=true;
	public Boolean activaridEstadoDetalleOrdenCompra=true;

	public Border resaltarcodigoEstadoDetalleOrdenCompra=null;
	public Boolean mostrarcodigoEstadoDetalleOrdenCompra=true;
	public Boolean activarcodigoEstadoDetalleOrdenCompra=true;

	public Border resaltarnombreEstadoDetalleOrdenCompra=null;
	public Boolean mostrarnombreEstadoDetalleOrdenCompra=true;
	public Boolean activarnombreEstadoDetalleOrdenCompra=true;

	
	

	public Border setResaltaridEstadoDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleOrdenCompraBeanSwingJInternalFrame estadodetalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodetalleordencompraBeanSwingJInternalFrame.jTtoolBarEstadoDetalleOrdenCompra.setBorder(borderResaltar);
		
		this.resaltaridEstadoDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoDetalleOrdenCompra() {
		return this.resaltaridEstadoDetalleOrdenCompra;
	}

	public void setResaltaridEstadoDetalleOrdenCompra(Border borderResaltar) {
		this.resaltaridEstadoDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostraridEstadoDetalleOrdenCompra() {
		return this.mostraridEstadoDetalleOrdenCompra;
	}

	public void setMostraridEstadoDetalleOrdenCompra(Boolean mostraridEstadoDetalleOrdenCompra) {
		this.mostraridEstadoDetalleOrdenCompra= mostraridEstadoDetalleOrdenCompra;
	}

	public Boolean getActivaridEstadoDetalleOrdenCompra() {
		return this.activaridEstadoDetalleOrdenCompra;
	}

	public void setActivaridEstadoDetalleOrdenCompra(Boolean activaridEstadoDetalleOrdenCompra) {
		this.activaridEstadoDetalleOrdenCompra= activaridEstadoDetalleOrdenCompra;
	}

	public Border setResaltarcodigoEstadoDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleOrdenCompraBeanSwingJInternalFrame estadodetalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodetalleordencompraBeanSwingJInternalFrame.jTtoolBarEstadoDetalleOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoDetalleOrdenCompra() {
		return this.resaltarcodigoEstadoDetalleOrdenCompra;
	}

	public void setResaltarcodigoEstadoDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarcodigoEstadoDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoDetalleOrdenCompra() {
		return this.mostrarcodigoEstadoDetalleOrdenCompra;
	}

	public void setMostrarcodigoEstadoDetalleOrdenCompra(Boolean mostrarcodigoEstadoDetalleOrdenCompra) {
		this.mostrarcodigoEstadoDetalleOrdenCompra= mostrarcodigoEstadoDetalleOrdenCompra;
	}

	public Boolean getActivarcodigoEstadoDetalleOrdenCompra() {
		return this.activarcodigoEstadoDetalleOrdenCompra;
	}

	public void setActivarcodigoEstadoDetalleOrdenCompra(Boolean activarcodigoEstadoDetalleOrdenCompra) {
		this.activarcodigoEstadoDetalleOrdenCompra= activarcodigoEstadoDetalleOrdenCompra;
	}

	public Border setResaltarnombreEstadoDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleOrdenCompraBeanSwingJInternalFrame estadodetalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodetalleordencompraBeanSwingJInternalFrame.jTtoolBarEstadoDetalleOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoDetalleOrdenCompra() {
		return this.resaltarnombreEstadoDetalleOrdenCompra;
	}

	public void setResaltarnombreEstadoDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarnombreEstadoDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoDetalleOrdenCompra() {
		return this.mostrarnombreEstadoDetalleOrdenCompra;
	}

	public void setMostrarnombreEstadoDetalleOrdenCompra(Boolean mostrarnombreEstadoDetalleOrdenCompra) {
		this.mostrarnombreEstadoDetalleOrdenCompra= mostrarnombreEstadoDetalleOrdenCompra;
	}

	public Boolean getActivarnombreEstadoDetalleOrdenCompra() {
		return this.activarnombreEstadoDetalleOrdenCompra;
	}

	public void setActivarnombreEstadoDetalleOrdenCompra(Boolean activarnombreEstadoDetalleOrdenCompra) {
		this.activarnombreEstadoDetalleOrdenCompra= activarnombreEstadoDetalleOrdenCompra;
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
		
		
		this.setMostraridEstadoDetalleOrdenCompra(esInicial);
		this.setMostrarcodigoEstadoDetalleOrdenCompra(esInicial);
		this.setMostrarnombreEstadoDetalleOrdenCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDetalleOrdenCompraConstantesFunciones.ID)) {
				this.setMostraridEstadoDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleOrdenCompraConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleOrdenCompraConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoDetalleOrdenCompra(esAsigna);
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
		
		
		this.setActivaridEstadoDetalleOrdenCompra(esInicial);
		this.setActivarcodigoEstadoDetalleOrdenCompra(esInicial);
		this.setActivarnombreEstadoDetalleOrdenCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDetalleOrdenCompraConstantesFunciones.ID)) {
				this.setActivaridEstadoDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleOrdenCompraConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleOrdenCompraConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoDetalleOrdenCompra(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoDetalleOrdenCompraBeanSwingJInternalFrame estadodetalleordencompraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoDetalleOrdenCompra(esInicial);
		this.setResaltarcodigoEstadoDetalleOrdenCompra(esInicial);
		this.setResaltarnombreEstadoDetalleOrdenCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDetalleOrdenCompraConstantesFunciones.ID)) {
				this.setResaltaridEstadoDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleOrdenCompraConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleOrdenCompraConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoDetalleOrdenCompra(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleOrdenCompraEstadoDetalleOrdenCompra=null;

	public Border getResaltarDetalleOrdenCompraEstadoDetalleOrdenCompra() {
		return this.resaltarDetalleOrdenCompraEstadoDetalleOrdenCompra;
	}

	public void setResaltarDetalleOrdenCompraEstadoDetalleOrdenCompra(Border borderResaltarDetalleOrdenCompra) {
		if(borderResaltarDetalleOrdenCompra!=null) {
			this.resaltarDetalleOrdenCompraEstadoDetalleOrdenCompra= borderResaltarDetalleOrdenCompra;
		}
	}

	public Border setResaltarDetalleOrdenCompraEstadoDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleOrdenCompraBeanSwingJInternalFrame estadodetalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleOrdenCompra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadodetalleordencompraBeanSwingJInternalFrame.jTtoolBarEstadoDetalleOrdenCompra.setBorder(borderResaltarDetalleOrdenCompra);
			
		this.resaltarDetalleOrdenCompraEstadoDetalleOrdenCompra= borderResaltarDetalleOrdenCompra;

		 return borderResaltarDetalleOrdenCompra;
	}



	public Boolean mostrarDetalleOrdenCompraEstadoDetalleOrdenCompra=true;

	public Boolean getMostrarDetalleOrdenCompraEstadoDetalleOrdenCompra() {
		return this.mostrarDetalleOrdenCompraEstadoDetalleOrdenCompra;
	}

	public void setMostrarDetalleOrdenCompraEstadoDetalleOrdenCompra(Boolean visibilidadResaltarDetalleOrdenCompra) {
		this.mostrarDetalleOrdenCompraEstadoDetalleOrdenCompra= visibilidadResaltarDetalleOrdenCompra;
	}



	public Boolean activarDetalleOrdenCompraEstadoDetalleOrdenCompra=true;

	public Boolean gethabilitarResaltarDetalleOrdenCompraEstadoDetalleOrdenCompra() {
		return this.activarDetalleOrdenCompraEstadoDetalleOrdenCompra;
	}

	public void setActivarDetalleOrdenCompraEstadoDetalleOrdenCompra(Boolean habilitarResaltarDetalleOrdenCompra) {
		this.activarDetalleOrdenCompraEstadoDetalleOrdenCompra= habilitarResaltarDetalleOrdenCompra;
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

		this.setMostrarDetalleOrdenCompraEstadoDetalleOrdenCompra(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleOrdenCompra.class)) {
				this.setMostrarDetalleOrdenCompraEstadoDetalleOrdenCompra(esAsigna);
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

		this.setActivarDetalleOrdenCompraEstadoDetalleOrdenCompra(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleOrdenCompra.class)) {
				this.setActivarDetalleOrdenCompraEstadoDetalleOrdenCompra(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoDetalleOrdenCompraBeanSwingJInternalFrame estadodetalleordencompraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleOrdenCompraEstadoDetalleOrdenCompra(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleOrdenCompra.class)) {
				this.setResaltarDetalleOrdenCompraEstadoDetalleOrdenCompra(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}