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


import com.bydan.erp.inventario.util.EstadoBodegaProductoConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoBodegaProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoBodegaProductoParameterGeneral;

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
final public class EstadoBodegaProductoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoBodegaProducto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoBodegaProducto"+EstadoBodegaProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoBodegaProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoBodegaProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoBodegaProductoConstantesFunciones.SCHEMA+"_"+EstadoBodegaProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoBodegaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoBodegaProductoConstantesFunciones.SCHEMA+"_"+EstadoBodegaProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoBodegaProductoConstantesFunciones.SCHEMA+"_"+EstadoBodegaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoBodegaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoBodegaProductoConstantesFunciones.SCHEMA+"_"+EstadoBodegaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoBodegaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoBodegaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoBodegaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoBodegaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoBodegaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoBodegaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoBodegaProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoBodegaProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoBodegaProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoBodegaProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Bodega Productos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Bodega Producto";
	public static final String SCLASSWEBTITULO_LOWER="Estado Bodega Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoBodegaProducto";
	public static final String OBJECTNAME="estadobodegaproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="estado_bodega_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadobodegaproducto from "+EstadoBodegaProductoConstantesFunciones.SPERSISTENCENAME+" estadobodegaproducto";
	public static String QUERYSELECTNATIVE="select "+EstadoBodegaProductoConstantesFunciones.SCHEMA+"."+EstadoBodegaProductoConstantesFunciones.TABLENAME+".id,"+EstadoBodegaProductoConstantesFunciones.SCHEMA+"."+EstadoBodegaProductoConstantesFunciones.TABLENAME+".version_row,"+EstadoBodegaProductoConstantesFunciones.SCHEMA+"."+EstadoBodegaProductoConstantesFunciones.TABLENAME+".codigo,"+EstadoBodegaProductoConstantesFunciones.SCHEMA+"."+EstadoBodegaProductoConstantesFunciones.TABLENAME+".nombre,"+EstadoBodegaProductoConstantesFunciones.SCHEMA+"."+EstadoBodegaProductoConstantesFunciones.TABLENAME+".es_defecto from "+EstadoBodegaProductoConstantesFunciones.SCHEMA+"."+EstadoBodegaProductoConstantesFunciones.TABLENAME;//+" as "+EstadoBodegaProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String ESDEFECTO= "es_defecto";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_ESDEFECTO= "Es Defecto";
		public static final String LABEL_ESDEFECTO_LOWER= "Es Defecto";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getEstadoBodegaProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoBodegaProductoConstantesFunciones.CODIGO)) {sLabelColumna=EstadoBodegaProductoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoBodegaProductoConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoBodegaProductoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(EstadoBodegaProductoConstantesFunciones.ESDEFECTO)) {sLabelColumna=EstadoBodegaProductoConstantesFunciones.LABEL_ESDEFECTO;}
		
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
	
	
	
			
			
			
			
		
	public static String getes_defectoDescripcion(EstadoBodegaProducto estadobodegaproducto) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!estadobodegaproducto.getes_defecto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_defectoHtmlDescripcion(EstadoBodegaProducto estadobodegaproducto) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(estadobodegaproducto.getId(),estadobodegaproducto.getes_defecto());

		return sDescripcion;
	}	
	
	public static String getEstadoBodegaProductoDescripcion(EstadoBodegaProducto estadobodegaproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadobodegaproducto !=null/* && estadobodegaproducto.getId()!=0*/) {
			sDescripcion=estadobodegaproducto.getcodigo();//estadobodegaproductoestadobodegaproducto.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoBodegaProductoDescripcionDetallado(EstadoBodegaProducto estadobodegaproducto) {
		String sDescripcion="";
			
		sDescripcion+=EstadoBodegaProductoConstantesFunciones.ID+"=";
		sDescripcion+=estadobodegaproducto.getId().toString()+",";
		sDescripcion+=EstadoBodegaProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadobodegaproducto.getVersionRow().toString()+",";
		sDescripcion+=EstadoBodegaProductoConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadobodegaproducto.getcodigo()+",";
		sDescripcion+=EstadoBodegaProductoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadobodegaproducto.getnombre()+",";
		sDescripcion+=EstadoBodegaProductoConstantesFunciones.ESDEFECTO+"=";
		sDescripcion+=estadobodegaproducto.getes_defecto().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoBodegaProductoDescripcion(EstadoBodegaProducto estadobodegaproducto,String sValor) throws Exception {			
		if(estadobodegaproducto !=null) {
			estadobodegaproducto.setcodigo(sValor);;//estadobodegaproductoestadobodegaproducto.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoBodegaProducto(EstadoBodegaProducto estadobodegaproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadobodegaproducto.setcodigo(estadobodegaproducto.getcodigo().trim());
		estadobodegaproducto.setnombre(estadobodegaproducto.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoBodegaProductos(List<EstadoBodegaProducto> estadobodegaproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoBodegaProducto estadobodegaproducto: estadobodegaproductos) {
			estadobodegaproducto.setcodigo(estadobodegaproducto.getcodigo().trim());
			estadobodegaproducto.setnombre(estadobodegaproducto.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoBodegaProducto(EstadoBodegaProducto estadobodegaproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadobodegaproducto.getConCambioAuxiliar()) {
			estadobodegaproducto.setIsDeleted(estadobodegaproducto.getIsDeletedAuxiliar());	
			estadobodegaproducto.setIsNew(estadobodegaproducto.getIsNewAuxiliar());	
			estadobodegaproducto.setIsChanged(estadobodegaproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadobodegaproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadobodegaproducto.setIsDeletedAuxiliar(false);	
			estadobodegaproducto.setIsNewAuxiliar(false);	
			estadobodegaproducto.setIsChangedAuxiliar(false);
			
			estadobodegaproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoBodegaProductos(List<EstadoBodegaProducto> estadobodegaproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoBodegaProducto estadobodegaproducto : estadobodegaproductos) {
			if(conAsignarBase && estadobodegaproducto.getConCambioAuxiliar()) {
				estadobodegaproducto.setIsDeleted(estadobodegaproducto.getIsDeletedAuxiliar());	
				estadobodegaproducto.setIsNew(estadobodegaproducto.getIsNewAuxiliar());	
				estadobodegaproducto.setIsChanged(estadobodegaproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadobodegaproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadobodegaproducto.setIsDeletedAuxiliar(false);	
				estadobodegaproducto.setIsNewAuxiliar(false);	
				estadobodegaproducto.setIsChangedAuxiliar(false);
				
				estadobodegaproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoBodegaProducto(EstadoBodegaProducto estadobodegaproducto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoBodegaProductos(List<EstadoBodegaProducto> estadobodegaproductos,Boolean conEnteros) throws Exception  {
		
		for(EstadoBodegaProducto estadobodegaproducto: estadobodegaproductos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoBodegaProducto(List<EstadoBodegaProducto> estadobodegaproductos,EstadoBodegaProducto estadobodegaproductoAux) throws Exception  {
		EstadoBodegaProductoConstantesFunciones.InicializarValoresEstadoBodegaProducto(estadobodegaproductoAux,true);
		
		for(EstadoBodegaProducto estadobodegaproducto: estadobodegaproductos) {
			if(estadobodegaproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoBodegaProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoBodegaProductoConstantesFunciones.getArrayColumnasGlobalesEstadoBodegaProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoBodegaProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoBodegaProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoBodegaProducto> estadobodegaproductos,EstadoBodegaProducto estadobodegaproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoBodegaProducto estadobodegaproductoAux: estadobodegaproductos) {
			if(estadobodegaproductoAux!=null && estadobodegaproducto!=null) {
				if((estadobodegaproductoAux.getId()==null && estadobodegaproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadobodegaproductoAux.getId()!=null && estadobodegaproducto.getId()!=null){
					if(estadobodegaproductoAux.getId().equals(estadobodegaproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoBodegaProducto(List<EstadoBodegaProducto> estadobodegaproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoBodegaProducto estadobodegaproducto: estadobodegaproductos) {			
			if(estadobodegaproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoBodegaProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoBodegaProductoConstantesFunciones.LABEL_ID, EstadoBodegaProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoBodegaProductoConstantesFunciones.LABEL_VERSIONROW, EstadoBodegaProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoBodegaProductoConstantesFunciones.LABEL_CODIGO, EstadoBodegaProductoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoBodegaProductoConstantesFunciones.LABEL_NOMBRE, EstadoBodegaProductoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoBodegaProductoConstantesFunciones.LABEL_ESDEFECTO, EstadoBodegaProductoConstantesFunciones.ESDEFECTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoBodegaProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoBodegaProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoBodegaProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoBodegaProductoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoBodegaProductoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoBodegaProductoConstantesFunciones.ESDEFECTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoBodegaProducto() throws Exception  {
		return EstadoBodegaProductoConstantesFunciones.getTiposSeleccionarEstadoBodegaProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoBodegaProducto(Boolean conFk) throws Exception  {
		return EstadoBodegaProductoConstantesFunciones.getTiposSeleccionarEstadoBodegaProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoBodegaProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoBodegaProductoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoBodegaProductoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoBodegaProductoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoBodegaProductoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoBodegaProductoConstantesFunciones.LABEL_ESDEFECTO);
			reporte.setsDescripcion(EstadoBodegaProductoConstantesFunciones.LABEL_ESDEFECTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoBodegaProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoBodegaProducto(EstadoBodegaProducto estadobodegaproductoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoBodegaProducto(List<EstadoBodegaProducto> estadobodegaproductosTemp) throws Exception {
		for(EstadoBodegaProducto estadobodegaproductoAux:estadobodegaproductosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoBodegaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoBodegaProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoBodegaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoBodegaProductoConstantesFunciones.getClassesRelationshipsOfEstadoBodegaProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoBodegaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(BodegaProducto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(BodegaProducto.class)) {
						classes.add(new Classe(BodegaProducto.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoBodegaProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoBodegaProductoConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoBodegaProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoBodegaProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(BodegaProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(BodegaProducto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(BodegaProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(BodegaProducto.class)); continue;
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
	public static void actualizarLista(EstadoBodegaProducto estadobodegaproducto,List<EstadoBodegaProducto> estadobodegaproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoBodegaProducto estadobodegaproductoEncontrado=null;
			
			for(EstadoBodegaProducto estadobodegaproductoLocal:estadobodegaproductos) {
				if(estadobodegaproductoLocal.getId().equals(estadobodegaproducto.getId())) {
					estadobodegaproductoEncontrado=estadobodegaproductoLocal;
					
					estadobodegaproductoLocal.setIsChanged(estadobodegaproducto.getIsChanged());
					estadobodegaproductoLocal.setIsNew(estadobodegaproducto.getIsNew());
					estadobodegaproductoLocal.setIsDeleted(estadobodegaproducto.getIsDeleted());
					
					estadobodegaproductoLocal.setGeneralEntityOriginal(estadobodegaproducto.getGeneralEntityOriginal());
					
					estadobodegaproductoLocal.setId(estadobodegaproducto.getId());	
					estadobodegaproductoLocal.setVersionRow(estadobodegaproducto.getVersionRow());	
					estadobodegaproductoLocal.setcodigo(estadobodegaproducto.getcodigo());	
					estadobodegaproductoLocal.setnombre(estadobodegaproducto.getnombre());	
					estadobodegaproductoLocal.setes_defecto(estadobodegaproducto.getes_defecto());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!estadobodegaproducto.getIsDeleted()) {
				if(!existe) {
					estadobodegaproductos.add(estadobodegaproducto);
				}
			} else {
				if(estadobodegaproductoEncontrado!=null && permiteQuitar)  {
					estadobodegaproductos.remove(estadobodegaproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoBodegaProducto estadobodegaproducto,List<EstadoBodegaProducto> estadobodegaproductos) throws Exception {
		try	{			
			for(EstadoBodegaProducto estadobodegaproductoLocal:estadobodegaproductos) {
				if(estadobodegaproductoLocal.getId().equals(estadobodegaproducto.getId())) {
					estadobodegaproductoLocal.setIsSelected(estadobodegaproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoBodegaProducto(List<EstadoBodegaProducto> estadobodegaproductosAux) throws Exception {
		//this.estadobodegaproductosAux=estadobodegaproductosAux;
		
		for(EstadoBodegaProducto estadobodegaproductoAux:estadobodegaproductosAux) {
			if(estadobodegaproductoAux.getIsChanged()) {
				estadobodegaproductoAux.setIsChanged(false);
			}		
			
			if(estadobodegaproductoAux.getIsNew()) {
				estadobodegaproductoAux.setIsNew(false);
			}	
			
			if(estadobodegaproductoAux.getIsDeleted()) {
				estadobodegaproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoBodegaProducto(EstadoBodegaProducto estadobodegaproductoAux) throws Exception {
		//this.estadobodegaproductoAux=estadobodegaproductoAux;
		
			if(estadobodegaproductoAux.getIsChanged()) {
				estadobodegaproductoAux.setIsChanged(false);
			}		
			
			if(estadobodegaproductoAux.getIsNew()) {
				estadobodegaproductoAux.setIsNew(false);
			}	
			
			if(estadobodegaproductoAux.getIsDeleted()) {
				estadobodegaproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoBodegaProducto estadobodegaproductoAsignar,EstadoBodegaProducto estadobodegaproducto) throws Exception {
		estadobodegaproductoAsignar.setId(estadobodegaproducto.getId());	
		estadobodegaproductoAsignar.setVersionRow(estadobodegaproducto.getVersionRow());	
		estadobodegaproductoAsignar.setcodigo(estadobodegaproducto.getcodigo());	
		estadobodegaproductoAsignar.setnombre(estadobodegaproducto.getnombre());	
		estadobodegaproductoAsignar.setes_defecto(estadobodegaproducto.getes_defecto());	
	}
	
	public static void inicializarEstadoBodegaProducto(EstadoBodegaProducto estadobodegaproducto) throws Exception {
		try {
				estadobodegaproducto.setId(0L);	
					
				estadobodegaproducto.setcodigo("");	
				estadobodegaproducto.setnombre("");	
				estadobodegaproducto.setes_defecto(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoBodegaProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoBodegaProductoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoBodegaProductoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoBodegaProductoConstantesFunciones.LABEL_ESDEFECTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoBodegaProducto(String sTipo,Row row,Workbook workbook,EstadoBodegaProducto estadobodegaproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadobodegaproducto.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadobodegaproducto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(estadobodegaproducto.getes_defecto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoBodegaProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoBodegaProducto() {
		return this.sFinalQueryEstadoBodegaProducto;
	}
	
	public void setsFinalQueryEstadoBodegaProducto(String sFinalQueryEstadoBodegaProducto) {
		this.sFinalQueryEstadoBodegaProducto= sFinalQueryEstadoBodegaProducto;
	}
	
	public Border resaltarSeleccionarEstadoBodegaProducto=null;
	
	public Border setResaltarSeleccionarEstadoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoBodegaProductoBeanSwingJInternalFrame estadobodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadobodegaproductoBeanSwingJInternalFrame.jTtoolBarEstadoBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoBodegaProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoBodegaProducto() {
		return this.resaltarSeleccionarEstadoBodegaProducto;
	}
	
	public void setResaltarSeleccionarEstadoBodegaProducto(Border borderResaltarSeleccionarEstadoBodegaProducto) {
		this.resaltarSeleccionarEstadoBodegaProducto= borderResaltarSeleccionarEstadoBodegaProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoBodegaProducto=null;
	public Boolean mostraridEstadoBodegaProducto=true;
	public Boolean activaridEstadoBodegaProducto=true;

	public Border resaltarcodigoEstadoBodegaProducto=null;
	public Boolean mostrarcodigoEstadoBodegaProducto=true;
	public Boolean activarcodigoEstadoBodegaProducto=true;

	public Border resaltarnombreEstadoBodegaProducto=null;
	public Boolean mostrarnombreEstadoBodegaProducto=true;
	public Boolean activarnombreEstadoBodegaProducto=true;

	public Border resaltares_defectoEstadoBodegaProducto=null;
	public Boolean mostrares_defectoEstadoBodegaProducto=true;
	public Boolean activares_defectoEstadoBodegaProducto=true;

	
	

	public Border setResaltaridEstadoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoBodegaProductoBeanSwingJInternalFrame estadobodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadobodegaproductoBeanSwingJInternalFrame.jTtoolBarEstadoBodegaProducto.setBorder(borderResaltar);
		
		this.resaltaridEstadoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoBodegaProducto() {
		return this.resaltaridEstadoBodegaProducto;
	}

	public void setResaltaridEstadoBodegaProducto(Border borderResaltar) {
		this.resaltaridEstadoBodegaProducto= borderResaltar;
	}

	public Boolean getMostraridEstadoBodegaProducto() {
		return this.mostraridEstadoBodegaProducto;
	}

	public void setMostraridEstadoBodegaProducto(Boolean mostraridEstadoBodegaProducto) {
		this.mostraridEstadoBodegaProducto= mostraridEstadoBodegaProducto;
	}

	public Boolean getActivaridEstadoBodegaProducto() {
		return this.activaridEstadoBodegaProducto;
	}

	public void setActivaridEstadoBodegaProducto(Boolean activaridEstadoBodegaProducto) {
		this.activaridEstadoBodegaProducto= activaridEstadoBodegaProducto;
	}

	public Border setResaltarcodigoEstadoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoBodegaProductoBeanSwingJInternalFrame estadobodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadobodegaproductoBeanSwingJInternalFrame.jTtoolBarEstadoBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoBodegaProducto() {
		return this.resaltarcodigoEstadoBodegaProducto;
	}

	public void setResaltarcodigoEstadoBodegaProducto(Border borderResaltar) {
		this.resaltarcodigoEstadoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoBodegaProducto() {
		return this.mostrarcodigoEstadoBodegaProducto;
	}

	public void setMostrarcodigoEstadoBodegaProducto(Boolean mostrarcodigoEstadoBodegaProducto) {
		this.mostrarcodigoEstadoBodegaProducto= mostrarcodigoEstadoBodegaProducto;
	}

	public Boolean getActivarcodigoEstadoBodegaProducto() {
		return this.activarcodigoEstadoBodegaProducto;
	}

	public void setActivarcodigoEstadoBodegaProducto(Boolean activarcodigoEstadoBodegaProducto) {
		this.activarcodigoEstadoBodegaProducto= activarcodigoEstadoBodegaProducto;
	}

	public Border setResaltarnombreEstadoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoBodegaProductoBeanSwingJInternalFrame estadobodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadobodegaproductoBeanSwingJInternalFrame.jTtoolBarEstadoBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoBodegaProducto() {
		return this.resaltarnombreEstadoBodegaProducto;
	}

	public void setResaltarnombreEstadoBodegaProducto(Border borderResaltar) {
		this.resaltarnombreEstadoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoBodegaProducto() {
		return this.mostrarnombreEstadoBodegaProducto;
	}

	public void setMostrarnombreEstadoBodegaProducto(Boolean mostrarnombreEstadoBodegaProducto) {
		this.mostrarnombreEstadoBodegaProducto= mostrarnombreEstadoBodegaProducto;
	}

	public Boolean getActivarnombreEstadoBodegaProducto() {
		return this.activarnombreEstadoBodegaProducto;
	}

	public void setActivarnombreEstadoBodegaProducto(Boolean activarnombreEstadoBodegaProducto) {
		this.activarnombreEstadoBodegaProducto= activarnombreEstadoBodegaProducto;
	}

	public Border setResaltares_defectoEstadoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoBodegaProductoBeanSwingJInternalFrame estadobodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadobodegaproductoBeanSwingJInternalFrame.jTtoolBarEstadoBodegaProducto.setBorder(borderResaltar);
		
		this.resaltares_defectoEstadoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_defectoEstadoBodegaProducto() {
		return this.resaltares_defectoEstadoBodegaProducto;
	}

	public void setResaltares_defectoEstadoBodegaProducto(Border borderResaltar) {
		this.resaltares_defectoEstadoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrares_defectoEstadoBodegaProducto() {
		return this.mostrares_defectoEstadoBodegaProducto;
	}

	public void setMostrares_defectoEstadoBodegaProducto(Boolean mostrares_defectoEstadoBodegaProducto) {
		this.mostrares_defectoEstadoBodegaProducto= mostrares_defectoEstadoBodegaProducto;
	}

	public Boolean getActivares_defectoEstadoBodegaProducto() {
		return this.activares_defectoEstadoBodegaProducto;
	}

	public void setActivares_defectoEstadoBodegaProducto(Boolean activares_defectoEstadoBodegaProducto) {
		this.activares_defectoEstadoBodegaProducto= activares_defectoEstadoBodegaProducto;
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
		
		
		this.setMostraridEstadoBodegaProducto(esInicial);
		this.setMostrarcodigoEstadoBodegaProducto(esInicial);
		this.setMostrarnombreEstadoBodegaProducto(esInicial);
		this.setMostrares_defectoEstadoBodegaProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoBodegaProductoConstantesFunciones.ID)) {
				this.setMostraridEstadoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoBodegaProductoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoBodegaProductoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoBodegaProductoConstantesFunciones.ESDEFECTO)) {
				this.setMostrares_defectoEstadoBodegaProducto(esAsigna);
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
		
		
		this.setActivaridEstadoBodegaProducto(esInicial);
		this.setActivarcodigoEstadoBodegaProducto(esInicial);
		this.setActivarnombreEstadoBodegaProducto(esInicial);
		this.setActivares_defectoEstadoBodegaProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoBodegaProductoConstantesFunciones.ID)) {
				this.setActivaridEstadoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoBodegaProductoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoBodegaProductoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoBodegaProductoConstantesFunciones.ESDEFECTO)) {
				this.setActivares_defectoEstadoBodegaProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoBodegaProductoBeanSwingJInternalFrame estadobodegaproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoBodegaProducto(esInicial);
		this.setResaltarcodigoEstadoBodegaProducto(esInicial);
		this.setResaltarnombreEstadoBodegaProducto(esInicial);
		this.setResaltares_defectoEstadoBodegaProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoBodegaProductoConstantesFunciones.ID)) {
				this.setResaltaridEstadoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoBodegaProductoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoBodegaProductoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoBodegaProductoConstantesFunciones.ESDEFECTO)) {
				this.setResaltares_defectoEstadoBodegaProducto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoBodegaProductoBeanSwingJInternalFrame estadobodegaproductoBeanSwingJInternalFrame*/)throws Exception {	
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