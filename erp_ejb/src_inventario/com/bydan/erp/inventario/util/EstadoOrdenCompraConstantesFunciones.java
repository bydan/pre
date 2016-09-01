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


import com.bydan.erp.inventario.util.EstadoOrdenCompraConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoOrdenCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoOrdenCompraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoOrdenCompraConstantesFunciones extends EstadoOrdenCompraConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoOrdenCompra";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoOrdenCompra"+EstadoOrdenCompraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoOrdenCompraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoOrdenCompraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoOrdenCompraConstantesFunciones.SCHEMA+"_"+EstadoOrdenCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoOrdenCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoOrdenCompraConstantesFunciones.SCHEMA+"_"+EstadoOrdenCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoOrdenCompraConstantesFunciones.SCHEMA+"_"+EstadoOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoOrdenCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoOrdenCompraConstantesFunciones.SCHEMA+"_"+EstadoOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoOrdenCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoOrdenCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoOrdenCompraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoOrdenCompraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoOrdenCompraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoOrdenCompraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Orden Compras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Orden Compra";
	public static final String SCLASSWEBTITULO_LOWER="Estado Orden Compra";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoOrdenCompra";
	public static final String OBJECTNAME="estadoordencompra";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="estado_orden_compra";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadoordencompra from "+EstadoOrdenCompraConstantesFunciones.SPERSISTENCENAME+" estadoordencompra";
	public static String QUERYSELECTNATIVE="select "+EstadoOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoOrdenCompraConstantesFunciones.TABLENAME+".id,"+EstadoOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoOrdenCompraConstantesFunciones.TABLENAME+".version_row,"+EstadoOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoOrdenCompraConstantesFunciones.TABLENAME+".codigo,"+EstadoOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoOrdenCompraConstantesFunciones.TABLENAME+".nombre from "+EstadoOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoOrdenCompraConstantesFunciones.TABLENAME;//+" as "+EstadoOrdenCompraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoOrdenCompraConstantesFuncionesAdditional estadoordencompraConstantesFuncionesAdditional=null;
	
	public EstadoOrdenCompraConstantesFuncionesAdditional getEstadoOrdenCompraConstantesFuncionesAdditional() {
		return this.estadoordencompraConstantesFuncionesAdditional;
	}
	
	public void setEstadoOrdenCompraConstantesFuncionesAdditional(EstadoOrdenCompraConstantesFuncionesAdditional estadoordencompraConstantesFuncionesAdditional) {
		try {
			this.estadoordencompraConstantesFuncionesAdditional=estadoordencompraConstantesFuncionesAdditional;
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
	
	public static String getEstadoOrdenCompraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoOrdenCompraConstantesFunciones.CODIGO)) {sLabelColumna=EstadoOrdenCompraConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoOrdenCompraConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoOrdenCompraConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoOrdenCompraDescripcion(EstadoOrdenCompra estadoordencompra) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadoordencompra !=null/* && estadoordencompra.getId()!=0*/) {
			sDescripcion=estadoordencompra.getcodigo();//estadoordencompraestadoordencompra.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoOrdenCompraDescripcionDetallado(EstadoOrdenCompra estadoordencompra) {
		String sDescripcion="";
			
		sDescripcion+=EstadoOrdenCompraConstantesFunciones.ID+"=";
		sDescripcion+=estadoordencompra.getId().toString()+",";
		sDescripcion+=EstadoOrdenCompraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadoordencompra.getVersionRow().toString()+",";
		sDescripcion+=EstadoOrdenCompraConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadoordencompra.getcodigo()+",";
		sDescripcion+=EstadoOrdenCompraConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadoordencompra.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoOrdenCompraDescripcion(EstadoOrdenCompra estadoordencompra,String sValor) throws Exception {			
		if(estadoordencompra !=null) {
			estadoordencompra.setcodigo(sValor);;//estadoordencompraestadoordencompra.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoOrdenCompra(EstadoOrdenCompra estadoordencompra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadoordencompra.setcodigo(estadoordencompra.getcodigo().trim());
		estadoordencompra.setnombre(estadoordencompra.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoOrdenCompras(List<EstadoOrdenCompra> estadoordencompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoOrdenCompra estadoordencompra: estadoordencompras) {
			estadoordencompra.setcodigo(estadoordencompra.getcodigo().trim());
			estadoordencompra.setnombre(estadoordencompra.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoOrdenCompra(EstadoOrdenCompra estadoordencompra,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadoordencompra.getConCambioAuxiliar()) {
			estadoordencompra.setIsDeleted(estadoordencompra.getIsDeletedAuxiliar());	
			estadoordencompra.setIsNew(estadoordencompra.getIsNewAuxiliar());	
			estadoordencompra.setIsChanged(estadoordencompra.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadoordencompra.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadoordencompra.setIsDeletedAuxiliar(false);	
			estadoordencompra.setIsNewAuxiliar(false);	
			estadoordencompra.setIsChangedAuxiliar(false);
			
			estadoordencompra.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoOrdenCompras(List<EstadoOrdenCompra> estadoordencompras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoOrdenCompra estadoordencompra : estadoordencompras) {
			if(conAsignarBase && estadoordencompra.getConCambioAuxiliar()) {
				estadoordencompra.setIsDeleted(estadoordencompra.getIsDeletedAuxiliar());	
				estadoordencompra.setIsNew(estadoordencompra.getIsNewAuxiliar());	
				estadoordencompra.setIsChanged(estadoordencompra.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadoordencompra.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadoordencompra.setIsDeletedAuxiliar(false);	
				estadoordencompra.setIsNewAuxiliar(false);	
				estadoordencompra.setIsChangedAuxiliar(false);
				
				estadoordencompra.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoOrdenCompra(EstadoOrdenCompra estadoordencompra,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoOrdenCompras(List<EstadoOrdenCompra> estadoordencompras,Boolean conEnteros) throws Exception  {
		
		for(EstadoOrdenCompra estadoordencompra: estadoordencompras) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoOrdenCompra(List<EstadoOrdenCompra> estadoordencompras,EstadoOrdenCompra estadoordencompraAux) throws Exception  {
		EstadoOrdenCompraConstantesFunciones.InicializarValoresEstadoOrdenCompra(estadoordencompraAux,true);
		
		for(EstadoOrdenCompra estadoordencompra: estadoordencompras) {
			if(estadoordencompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoOrdenCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoOrdenCompraConstantesFunciones.getArrayColumnasGlobalesEstadoOrdenCompra(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoOrdenCompra(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoOrdenCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoOrdenCompra> estadoordencompras,EstadoOrdenCompra estadoordencompra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoOrdenCompra estadoordencompraAux: estadoordencompras) {
			if(estadoordencompraAux!=null && estadoordencompra!=null) {
				if((estadoordencompraAux.getId()==null && estadoordencompra.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadoordencompraAux.getId()!=null && estadoordencompra.getId()!=null){
					if(estadoordencompraAux.getId().equals(estadoordencompra.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoOrdenCompra(List<EstadoOrdenCompra> estadoordencompras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoOrdenCompra estadoordencompra: estadoordencompras) {			
			if(estadoordencompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoOrdenCompra() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoOrdenCompraConstantesFunciones.LABEL_ID, EstadoOrdenCompraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoOrdenCompraConstantesFunciones.LABEL_VERSIONROW, EstadoOrdenCompraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoOrdenCompraConstantesFunciones.LABEL_CODIGO, EstadoOrdenCompraConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoOrdenCompraConstantesFunciones.LABEL_NOMBRE, EstadoOrdenCompraConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoOrdenCompra() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoOrdenCompraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoOrdenCompraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoOrdenCompraConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoOrdenCompraConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoOrdenCompra() throws Exception  {
		return EstadoOrdenCompraConstantesFunciones.getTiposSeleccionarEstadoOrdenCompra(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoOrdenCompra(Boolean conFk) throws Exception  {
		return EstadoOrdenCompraConstantesFunciones.getTiposSeleccionarEstadoOrdenCompra(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoOrdenCompra(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoOrdenCompraConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoOrdenCompraConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoOrdenCompraConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoOrdenCompraConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoOrdenCompra(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoOrdenCompra(EstadoOrdenCompra estadoordencompraAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoOrdenCompra(List<EstadoOrdenCompra> estadoordencomprasTemp) throws Exception {
		for(EstadoOrdenCompra estadoordencompraAux:estadoordencomprasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoOrdenCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoOrdenCompraConstantesFunciones.getClassesRelationshipsOfEstadoOrdenCompra(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(OrdenCompra.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(OrdenCompra.class)) {
						classes.add(new Classe(OrdenCompra.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoOrdenCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoOrdenCompraConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoOrdenCompra(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoOrdenCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(OrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenCompra.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(OrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenCompra.class)); continue;
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
	public static void actualizarLista(EstadoOrdenCompra estadoordencompra,List<EstadoOrdenCompra> estadoordencompras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoOrdenCompra estadoordencompraEncontrado=null;
			
			for(EstadoOrdenCompra estadoordencompraLocal:estadoordencompras) {
				if(estadoordencompraLocal.getId().equals(estadoordencompra.getId())) {
					estadoordencompraEncontrado=estadoordencompraLocal;
					
					estadoordencompraLocal.setIsChanged(estadoordencompra.getIsChanged());
					estadoordencompraLocal.setIsNew(estadoordencompra.getIsNew());
					estadoordencompraLocal.setIsDeleted(estadoordencompra.getIsDeleted());
					
					estadoordencompraLocal.setGeneralEntityOriginal(estadoordencompra.getGeneralEntityOriginal());
					
					estadoordencompraLocal.setId(estadoordencompra.getId());	
					estadoordencompraLocal.setVersionRow(estadoordencompra.getVersionRow());	
					estadoordencompraLocal.setcodigo(estadoordencompra.getcodigo());	
					estadoordencompraLocal.setnombre(estadoordencompra.getnombre());	
					
					
					estadoordencompraLocal.setOrdenCompras(estadoordencompra.getOrdenCompras());
					
					existe=true;
					break;
				}
			}
			
			if(!estadoordencompra.getIsDeleted()) {
				if(!existe) {
					estadoordencompras.add(estadoordencompra);
				}
			} else {
				if(estadoordencompraEncontrado!=null && permiteQuitar)  {
					estadoordencompras.remove(estadoordencompraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoOrdenCompra estadoordencompra,List<EstadoOrdenCompra> estadoordencompras) throws Exception {
		try	{			
			for(EstadoOrdenCompra estadoordencompraLocal:estadoordencompras) {
				if(estadoordencompraLocal.getId().equals(estadoordencompra.getId())) {
					estadoordencompraLocal.setIsSelected(estadoordencompra.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoOrdenCompra(List<EstadoOrdenCompra> estadoordencomprasAux) throws Exception {
		//this.estadoordencomprasAux=estadoordencomprasAux;
		
		for(EstadoOrdenCompra estadoordencompraAux:estadoordencomprasAux) {
			if(estadoordencompraAux.getIsChanged()) {
				estadoordencompraAux.setIsChanged(false);
			}		
			
			if(estadoordencompraAux.getIsNew()) {
				estadoordencompraAux.setIsNew(false);
			}	
			
			if(estadoordencompraAux.getIsDeleted()) {
				estadoordencompraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoOrdenCompra(EstadoOrdenCompra estadoordencompraAux) throws Exception {
		//this.estadoordencompraAux=estadoordencompraAux;
		
			if(estadoordencompraAux.getIsChanged()) {
				estadoordencompraAux.setIsChanged(false);
			}		
			
			if(estadoordencompraAux.getIsNew()) {
				estadoordencompraAux.setIsNew(false);
			}	
			
			if(estadoordencompraAux.getIsDeleted()) {
				estadoordencompraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoOrdenCompra estadoordencompraAsignar,EstadoOrdenCompra estadoordencompra) throws Exception {
		estadoordencompraAsignar.setId(estadoordencompra.getId());	
		estadoordencompraAsignar.setVersionRow(estadoordencompra.getVersionRow());	
		estadoordencompraAsignar.setcodigo(estadoordencompra.getcodigo());	
		estadoordencompraAsignar.setnombre(estadoordencompra.getnombre());	
	}
	
	public static void inicializarEstadoOrdenCompra(EstadoOrdenCompra estadoordencompra) throws Exception {
		try {
				estadoordencompra.setId(0L);	
					
				estadoordencompra.setcodigo("");	
				estadoordencompra.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoOrdenCompra(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoOrdenCompraConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoOrdenCompraConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoOrdenCompra(String sTipo,Row row,Workbook workbook,EstadoOrdenCompra estadoordencompra,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoordencompra.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoordencompra.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoOrdenCompra=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoOrdenCompra() {
		return this.sFinalQueryEstadoOrdenCompra;
	}
	
	public void setsFinalQueryEstadoOrdenCompra(String sFinalQueryEstadoOrdenCompra) {
		this.sFinalQueryEstadoOrdenCompra= sFinalQueryEstadoOrdenCompra;
	}
	
	public Border resaltarSeleccionarEstadoOrdenCompra=null;
	
	public Border setResaltarSeleccionarEstadoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoOrdenCompraBeanSwingJInternalFrame estadoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadoordencompraBeanSwingJInternalFrame.jTtoolBarEstadoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoOrdenCompra= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoOrdenCompra() {
		return this.resaltarSeleccionarEstadoOrdenCompra;
	}
	
	public void setResaltarSeleccionarEstadoOrdenCompra(Border borderResaltarSeleccionarEstadoOrdenCompra) {
		this.resaltarSeleccionarEstadoOrdenCompra= borderResaltarSeleccionarEstadoOrdenCompra;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoOrdenCompra=null;
	public Boolean mostraridEstadoOrdenCompra=true;
	public Boolean activaridEstadoOrdenCompra=true;

	public Border resaltarcodigoEstadoOrdenCompra=null;
	public Boolean mostrarcodigoEstadoOrdenCompra=true;
	public Boolean activarcodigoEstadoOrdenCompra=true;

	public Border resaltarnombreEstadoOrdenCompra=null;
	public Boolean mostrarnombreEstadoOrdenCompra=true;
	public Boolean activarnombreEstadoOrdenCompra=true;

	
	

	public Border setResaltaridEstadoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoOrdenCompraBeanSwingJInternalFrame estadoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoordencompraBeanSwingJInternalFrame.jTtoolBarEstadoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltaridEstadoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoOrdenCompra() {
		return this.resaltaridEstadoOrdenCompra;
	}

	public void setResaltaridEstadoOrdenCompra(Border borderResaltar) {
		this.resaltaridEstadoOrdenCompra= borderResaltar;
	}

	public Boolean getMostraridEstadoOrdenCompra() {
		return this.mostraridEstadoOrdenCompra;
	}

	public void setMostraridEstadoOrdenCompra(Boolean mostraridEstadoOrdenCompra) {
		this.mostraridEstadoOrdenCompra= mostraridEstadoOrdenCompra;
	}

	public Boolean getActivaridEstadoOrdenCompra() {
		return this.activaridEstadoOrdenCompra;
	}

	public void setActivaridEstadoOrdenCompra(Boolean activaridEstadoOrdenCompra) {
		this.activaridEstadoOrdenCompra= activaridEstadoOrdenCompra;
	}

	public Border setResaltarcodigoEstadoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoOrdenCompraBeanSwingJInternalFrame estadoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoordencompraBeanSwingJInternalFrame.jTtoolBarEstadoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoOrdenCompra() {
		return this.resaltarcodigoEstadoOrdenCompra;
	}

	public void setResaltarcodigoEstadoOrdenCompra(Border borderResaltar) {
		this.resaltarcodigoEstadoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoOrdenCompra() {
		return this.mostrarcodigoEstadoOrdenCompra;
	}

	public void setMostrarcodigoEstadoOrdenCompra(Boolean mostrarcodigoEstadoOrdenCompra) {
		this.mostrarcodigoEstadoOrdenCompra= mostrarcodigoEstadoOrdenCompra;
	}

	public Boolean getActivarcodigoEstadoOrdenCompra() {
		return this.activarcodigoEstadoOrdenCompra;
	}

	public void setActivarcodigoEstadoOrdenCompra(Boolean activarcodigoEstadoOrdenCompra) {
		this.activarcodigoEstadoOrdenCompra= activarcodigoEstadoOrdenCompra;
	}

	public Border setResaltarnombreEstadoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoOrdenCompraBeanSwingJInternalFrame estadoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoordencompraBeanSwingJInternalFrame.jTtoolBarEstadoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoOrdenCompra() {
		return this.resaltarnombreEstadoOrdenCompra;
	}

	public void setResaltarnombreEstadoOrdenCompra(Border borderResaltar) {
		this.resaltarnombreEstadoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoOrdenCompra() {
		return this.mostrarnombreEstadoOrdenCompra;
	}

	public void setMostrarnombreEstadoOrdenCompra(Boolean mostrarnombreEstadoOrdenCompra) {
		this.mostrarnombreEstadoOrdenCompra= mostrarnombreEstadoOrdenCompra;
	}

	public Boolean getActivarnombreEstadoOrdenCompra() {
		return this.activarnombreEstadoOrdenCompra;
	}

	public void setActivarnombreEstadoOrdenCompra(Boolean activarnombreEstadoOrdenCompra) {
		this.activarnombreEstadoOrdenCompra= activarnombreEstadoOrdenCompra;
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
		
		
		this.setMostraridEstadoOrdenCompra(esInicial);
		this.setMostrarcodigoEstadoOrdenCompra(esInicial);
		this.setMostrarnombreEstadoOrdenCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoOrdenCompraConstantesFunciones.ID)) {
				this.setMostraridEstadoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoOrdenCompraConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoOrdenCompraConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoOrdenCompra(esAsigna);
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
		
		
		this.setActivaridEstadoOrdenCompra(esInicial);
		this.setActivarcodigoEstadoOrdenCompra(esInicial);
		this.setActivarnombreEstadoOrdenCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoOrdenCompraConstantesFunciones.ID)) {
				this.setActivaridEstadoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoOrdenCompraConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoOrdenCompraConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoOrdenCompra(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoOrdenCompraBeanSwingJInternalFrame estadoordencompraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoOrdenCompra(esInicial);
		this.setResaltarcodigoEstadoOrdenCompra(esInicial);
		this.setResaltarnombreEstadoOrdenCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoOrdenCompraConstantesFunciones.ID)) {
				this.setResaltaridEstadoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoOrdenCompraConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoOrdenCompraConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoOrdenCompra(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarOrdenCompraEstadoOrdenCompra=null;

	public Border getResaltarOrdenCompraEstadoOrdenCompra() {
		return this.resaltarOrdenCompraEstadoOrdenCompra;
	}

	public void setResaltarOrdenCompraEstadoOrdenCompra(Border borderResaltarOrdenCompra) {
		if(borderResaltarOrdenCompra!=null) {
			this.resaltarOrdenCompraEstadoOrdenCompra= borderResaltarOrdenCompra;
		}
	}

	public Border setResaltarOrdenCompraEstadoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoOrdenCompraBeanSwingJInternalFrame estadoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltarOrdenCompra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadoordencompraBeanSwingJInternalFrame.jTtoolBarEstadoOrdenCompra.setBorder(borderResaltarOrdenCompra);
			
		this.resaltarOrdenCompraEstadoOrdenCompra= borderResaltarOrdenCompra;

		 return borderResaltarOrdenCompra;
	}



	public Boolean mostrarOrdenCompraEstadoOrdenCompra=true;

	public Boolean getMostrarOrdenCompraEstadoOrdenCompra() {
		return this.mostrarOrdenCompraEstadoOrdenCompra;
	}

	public void setMostrarOrdenCompraEstadoOrdenCompra(Boolean visibilidadResaltarOrdenCompra) {
		this.mostrarOrdenCompraEstadoOrdenCompra= visibilidadResaltarOrdenCompra;
	}



	public Boolean activarOrdenCompraEstadoOrdenCompra=true;

	public Boolean gethabilitarResaltarOrdenCompraEstadoOrdenCompra() {
		return this.activarOrdenCompraEstadoOrdenCompra;
	}

	public void setActivarOrdenCompraEstadoOrdenCompra(Boolean habilitarResaltarOrdenCompra) {
		this.activarOrdenCompraEstadoOrdenCompra= habilitarResaltarOrdenCompra;
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

		this.setMostrarOrdenCompraEstadoOrdenCompra(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(OrdenCompra.class)) {
				this.setMostrarOrdenCompraEstadoOrdenCompra(esAsigna);
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

		this.setActivarOrdenCompraEstadoOrdenCompra(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(OrdenCompra.class)) {
				this.setActivarOrdenCompraEstadoOrdenCompra(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoOrdenCompraBeanSwingJInternalFrame estadoordencompraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarOrdenCompraEstadoOrdenCompra(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(OrdenCompra.class)) {
				this.setResaltarOrdenCompraEstadoOrdenCompra(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}