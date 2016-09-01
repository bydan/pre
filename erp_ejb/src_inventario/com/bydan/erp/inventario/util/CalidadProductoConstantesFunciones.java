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


import com.bydan.erp.inventario.util.CalidadProductoConstantesFunciones;
import com.bydan.erp.inventario.util.CalidadProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.CalidadProductoParameterGeneral;

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
final public class CalidadProductoConstantesFunciones extends CalidadProductoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CalidadProducto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CalidadProducto"+CalidadProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CalidadProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CalidadProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CalidadProductoConstantesFunciones.SCHEMA+"_"+CalidadProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CalidadProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CalidadProductoConstantesFunciones.SCHEMA+"_"+CalidadProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CalidadProductoConstantesFunciones.SCHEMA+"_"+CalidadProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CalidadProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CalidadProductoConstantesFunciones.SCHEMA+"_"+CalidadProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CalidadProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CalidadProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CalidadProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CalidadProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CalidadProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CalidadProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CalidadProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CalidadProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CalidadProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CalidadProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Calidad Productos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Calidad Producto";
	public static final String SCLASSWEBTITULO_LOWER="Calidad Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CalidadProducto";
	public static final String OBJECTNAME="calidadproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="calidad_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select calidadproducto from "+CalidadProductoConstantesFunciones.SPERSISTENCENAME+" calidadproducto";
	public static String QUERYSELECTNATIVE="select "+CalidadProductoConstantesFunciones.SCHEMA+"."+CalidadProductoConstantesFunciones.TABLENAME+".id,"+CalidadProductoConstantesFunciones.SCHEMA+"."+CalidadProductoConstantesFunciones.TABLENAME+".version_row,"+CalidadProductoConstantesFunciones.SCHEMA+"."+CalidadProductoConstantesFunciones.TABLENAME+".codigo,"+CalidadProductoConstantesFunciones.SCHEMA+"."+CalidadProductoConstantesFunciones.TABLENAME+".nombre from "+CalidadProductoConstantesFunciones.SCHEMA+"."+CalidadProductoConstantesFunciones.TABLENAME;//+" as "+CalidadProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CalidadProductoConstantesFuncionesAdditional calidadproductoConstantesFuncionesAdditional=null;
	
	public CalidadProductoConstantesFuncionesAdditional getCalidadProductoConstantesFuncionesAdditional() {
		return this.calidadproductoConstantesFuncionesAdditional;
	}
	
	public void setCalidadProductoConstantesFuncionesAdditional(CalidadProductoConstantesFuncionesAdditional calidadproductoConstantesFuncionesAdditional) {
		try {
			this.calidadproductoConstantesFuncionesAdditional=calidadproductoConstantesFuncionesAdditional;
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
	
	public static String getCalidadProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CalidadProductoConstantesFunciones.CODIGO)) {sLabelColumna=CalidadProductoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CalidadProductoConstantesFunciones.NOMBRE)) {sLabelColumna=CalidadProductoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getCalidadProductoDescripcion(CalidadProducto calidadproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(calidadproducto !=null/* && calidadproducto.getId()!=0*/) {
			sDescripcion=calidadproducto.getcodigo();//calidadproductocalidadproducto.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCalidadProductoDescripcionDetallado(CalidadProducto calidadproducto) {
		String sDescripcion="";
			
		sDescripcion+=CalidadProductoConstantesFunciones.ID+"=";
		sDescripcion+=calidadproducto.getId().toString()+",";
		sDescripcion+=CalidadProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=calidadproducto.getVersionRow().toString()+",";
		sDescripcion+=CalidadProductoConstantesFunciones.CODIGO+"=";
		sDescripcion+=calidadproducto.getcodigo()+",";
		sDescripcion+=CalidadProductoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=calidadproducto.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setCalidadProductoDescripcion(CalidadProducto calidadproducto,String sValor) throws Exception {			
		if(calidadproducto !=null) {
			calidadproducto.setcodigo(sValor);;//calidadproductocalidadproducto.getcodigo().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCalidadProducto(CalidadProducto calidadproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		calidadproducto.setcodigo(calidadproducto.getcodigo().trim());
		calidadproducto.setnombre(calidadproducto.getnombre().trim());
	}
	
	public static void quitarEspaciosCalidadProductos(List<CalidadProducto> calidadproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CalidadProducto calidadproducto: calidadproductos) {
			calidadproducto.setcodigo(calidadproducto.getcodigo().trim());
			calidadproducto.setnombre(calidadproducto.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCalidadProducto(CalidadProducto calidadproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && calidadproducto.getConCambioAuxiliar()) {
			calidadproducto.setIsDeleted(calidadproducto.getIsDeletedAuxiliar());	
			calidadproducto.setIsNew(calidadproducto.getIsNewAuxiliar());	
			calidadproducto.setIsChanged(calidadproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			calidadproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			calidadproducto.setIsDeletedAuxiliar(false);	
			calidadproducto.setIsNewAuxiliar(false);	
			calidadproducto.setIsChangedAuxiliar(false);
			
			calidadproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCalidadProductos(List<CalidadProducto> calidadproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CalidadProducto calidadproducto : calidadproductos) {
			if(conAsignarBase && calidadproducto.getConCambioAuxiliar()) {
				calidadproducto.setIsDeleted(calidadproducto.getIsDeletedAuxiliar());	
				calidadproducto.setIsNew(calidadproducto.getIsNewAuxiliar());	
				calidadproducto.setIsChanged(calidadproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				calidadproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				calidadproducto.setIsDeletedAuxiliar(false);	
				calidadproducto.setIsNewAuxiliar(false);	
				calidadproducto.setIsChangedAuxiliar(false);
				
				calidadproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCalidadProducto(CalidadProducto calidadproducto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCalidadProductos(List<CalidadProducto> calidadproductos,Boolean conEnteros) throws Exception  {
		
		for(CalidadProducto calidadproducto: calidadproductos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCalidadProducto(List<CalidadProducto> calidadproductos,CalidadProducto calidadproductoAux) throws Exception  {
		CalidadProductoConstantesFunciones.InicializarValoresCalidadProducto(calidadproductoAux,true);
		
		for(CalidadProducto calidadproducto: calidadproductos) {
			if(calidadproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCalidadProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CalidadProductoConstantesFunciones.getArrayColumnasGlobalesCalidadProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCalidadProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCalidadProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CalidadProducto> calidadproductos,CalidadProducto calidadproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CalidadProducto calidadproductoAux: calidadproductos) {
			if(calidadproductoAux!=null && calidadproducto!=null) {
				if((calidadproductoAux.getId()==null && calidadproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(calidadproductoAux.getId()!=null && calidadproducto.getId()!=null){
					if(calidadproductoAux.getId().equals(calidadproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCalidadProducto(List<CalidadProducto> calidadproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CalidadProducto calidadproducto: calidadproductos) {			
			if(calidadproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCalidadProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CalidadProductoConstantesFunciones.LABEL_ID, CalidadProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CalidadProductoConstantesFunciones.LABEL_VERSIONROW, CalidadProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CalidadProductoConstantesFunciones.LABEL_CODIGO, CalidadProductoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CalidadProductoConstantesFunciones.LABEL_NOMBRE, CalidadProductoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCalidadProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CalidadProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CalidadProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CalidadProductoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CalidadProductoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCalidadProducto() throws Exception  {
		return CalidadProductoConstantesFunciones.getTiposSeleccionarCalidadProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCalidadProducto(Boolean conFk) throws Exception  {
		return CalidadProductoConstantesFunciones.getTiposSeleccionarCalidadProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCalidadProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CalidadProductoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CalidadProductoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CalidadProductoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CalidadProductoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCalidadProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCalidadProducto(CalidadProducto calidadproductoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesCalidadProducto(List<CalidadProducto> calidadproductosTemp) throws Exception {
		for(CalidadProducto calidadproductoAux:calidadproductosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCalidadProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCalidadProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCalidadProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CalidadProductoConstantesFunciones.getClassesRelationshipsOfCalidadProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCalidadProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(ParametroInventarioDefecto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCalidadProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CalidadProductoConstantesFunciones.getClassesRelationshipsFromStringsOfCalidadProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCalidadProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(ParametroInventarioDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
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
	public static void actualizarLista(CalidadProducto calidadproducto,List<CalidadProducto> calidadproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CalidadProducto calidadproductoEncontrado=null;
			
			for(CalidadProducto calidadproductoLocal:calidadproductos) {
				if(calidadproductoLocal.getId().equals(calidadproducto.getId())) {
					calidadproductoEncontrado=calidadproductoLocal;
					
					calidadproductoLocal.setIsChanged(calidadproducto.getIsChanged());
					calidadproductoLocal.setIsNew(calidadproducto.getIsNew());
					calidadproductoLocal.setIsDeleted(calidadproducto.getIsDeleted());
					
					calidadproductoLocal.setGeneralEntityOriginal(calidadproducto.getGeneralEntityOriginal());
					
					calidadproductoLocal.setId(calidadproducto.getId());	
					calidadproductoLocal.setVersionRow(calidadproducto.getVersionRow());	
					calidadproductoLocal.setcodigo(calidadproducto.getcodigo());	
					calidadproductoLocal.setnombre(calidadproducto.getnombre());	
					
					
					calidadproductoLocal.setBodegas(calidadproducto.getBodegas());
					calidadproductoLocal.setParametroInventarioDefectos(calidadproducto.getParametroInventarioDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!calidadproducto.getIsDeleted()) {
				if(!existe) {
					calidadproductos.add(calidadproducto);
				}
			} else {
				if(calidadproductoEncontrado!=null && permiteQuitar)  {
					calidadproductos.remove(calidadproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CalidadProducto calidadproducto,List<CalidadProducto> calidadproductos) throws Exception {
		try	{			
			for(CalidadProducto calidadproductoLocal:calidadproductos) {
				if(calidadproductoLocal.getId().equals(calidadproducto.getId())) {
					calidadproductoLocal.setIsSelected(calidadproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCalidadProducto(List<CalidadProducto> calidadproductosAux) throws Exception {
		//this.calidadproductosAux=calidadproductosAux;
		
		for(CalidadProducto calidadproductoAux:calidadproductosAux) {
			if(calidadproductoAux.getIsChanged()) {
				calidadproductoAux.setIsChanged(false);
			}		
			
			if(calidadproductoAux.getIsNew()) {
				calidadproductoAux.setIsNew(false);
			}	
			
			if(calidadproductoAux.getIsDeleted()) {
				calidadproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCalidadProducto(CalidadProducto calidadproductoAux) throws Exception {
		//this.calidadproductoAux=calidadproductoAux;
		
			if(calidadproductoAux.getIsChanged()) {
				calidadproductoAux.setIsChanged(false);
			}		
			
			if(calidadproductoAux.getIsNew()) {
				calidadproductoAux.setIsNew(false);
			}	
			
			if(calidadproductoAux.getIsDeleted()) {
				calidadproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CalidadProducto calidadproductoAsignar,CalidadProducto calidadproducto) throws Exception {
		calidadproductoAsignar.setId(calidadproducto.getId());	
		calidadproductoAsignar.setVersionRow(calidadproducto.getVersionRow());	
		calidadproductoAsignar.setcodigo(calidadproducto.getcodigo());	
		calidadproductoAsignar.setnombre(calidadproducto.getnombre());	
	}
	
	public static void inicializarCalidadProducto(CalidadProducto calidadproducto) throws Exception {
		try {
				calidadproducto.setId(0L);	
					
				calidadproducto.setcodigo("");	
				calidadproducto.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCalidadProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CalidadProductoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CalidadProductoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCalidadProducto(String sTipo,Row row,Workbook workbook,CalidadProducto calidadproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(calidadproducto.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(calidadproducto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCalidadProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCalidadProducto() {
		return this.sFinalQueryCalidadProducto;
	}
	
	public void setsFinalQueryCalidadProducto(String sFinalQueryCalidadProducto) {
		this.sFinalQueryCalidadProducto= sFinalQueryCalidadProducto;
	}
	
	public Border resaltarSeleccionarCalidadProducto=null;
	
	public Border setResaltarSeleccionarCalidadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CalidadProductoBeanSwingJInternalFrame calidadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//calidadproductoBeanSwingJInternalFrame.jTtoolBarCalidadProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCalidadProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCalidadProducto() {
		return this.resaltarSeleccionarCalidadProducto;
	}
	
	public void setResaltarSeleccionarCalidadProducto(Border borderResaltarSeleccionarCalidadProducto) {
		this.resaltarSeleccionarCalidadProducto= borderResaltarSeleccionarCalidadProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCalidadProducto=null;
	public Boolean mostraridCalidadProducto=true;
	public Boolean activaridCalidadProducto=true;

	public Border resaltarcodigoCalidadProducto=null;
	public Boolean mostrarcodigoCalidadProducto=true;
	public Boolean activarcodigoCalidadProducto=true;

	public Border resaltarnombreCalidadProducto=null;
	public Boolean mostrarnombreCalidadProducto=true;
	public Boolean activarnombreCalidadProducto=true;

	
	

	public Border setResaltaridCalidadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CalidadProductoBeanSwingJInternalFrame calidadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//calidadproductoBeanSwingJInternalFrame.jTtoolBarCalidadProducto.setBorder(borderResaltar);
		
		this.resaltaridCalidadProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCalidadProducto() {
		return this.resaltaridCalidadProducto;
	}

	public void setResaltaridCalidadProducto(Border borderResaltar) {
		this.resaltaridCalidadProducto= borderResaltar;
	}

	public Boolean getMostraridCalidadProducto() {
		return this.mostraridCalidadProducto;
	}

	public void setMostraridCalidadProducto(Boolean mostraridCalidadProducto) {
		this.mostraridCalidadProducto= mostraridCalidadProducto;
	}

	public Boolean getActivaridCalidadProducto() {
		return this.activaridCalidadProducto;
	}

	public void setActivaridCalidadProducto(Boolean activaridCalidadProducto) {
		this.activaridCalidadProducto= activaridCalidadProducto;
	}

	public Border setResaltarcodigoCalidadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CalidadProductoBeanSwingJInternalFrame calidadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//calidadproductoBeanSwingJInternalFrame.jTtoolBarCalidadProducto.setBorder(borderResaltar);
		
		this.resaltarcodigoCalidadProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCalidadProducto() {
		return this.resaltarcodigoCalidadProducto;
	}

	public void setResaltarcodigoCalidadProducto(Border borderResaltar) {
		this.resaltarcodigoCalidadProducto= borderResaltar;
	}

	public Boolean getMostrarcodigoCalidadProducto() {
		return this.mostrarcodigoCalidadProducto;
	}

	public void setMostrarcodigoCalidadProducto(Boolean mostrarcodigoCalidadProducto) {
		this.mostrarcodigoCalidadProducto= mostrarcodigoCalidadProducto;
	}

	public Boolean getActivarcodigoCalidadProducto() {
		return this.activarcodigoCalidadProducto;
	}

	public void setActivarcodigoCalidadProducto(Boolean activarcodigoCalidadProducto) {
		this.activarcodigoCalidadProducto= activarcodigoCalidadProducto;
	}

	public Border setResaltarnombreCalidadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CalidadProductoBeanSwingJInternalFrame calidadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//calidadproductoBeanSwingJInternalFrame.jTtoolBarCalidadProducto.setBorder(borderResaltar);
		
		this.resaltarnombreCalidadProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCalidadProducto() {
		return this.resaltarnombreCalidadProducto;
	}

	public void setResaltarnombreCalidadProducto(Border borderResaltar) {
		this.resaltarnombreCalidadProducto= borderResaltar;
	}

	public Boolean getMostrarnombreCalidadProducto() {
		return this.mostrarnombreCalidadProducto;
	}

	public void setMostrarnombreCalidadProducto(Boolean mostrarnombreCalidadProducto) {
		this.mostrarnombreCalidadProducto= mostrarnombreCalidadProducto;
	}

	public Boolean getActivarnombreCalidadProducto() {
		return this.activarnombreCalidadProducto;
	}

	public void setActivarnombreCalidadProducto(Boolean activarnombreCalidadProducto) {
		this.activarnombreCalidadProducto= activarnombreCalidadProducto;
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
		
		
		this.setMostraridCalidadProducto(esInicial);
		this.setMostrarcodigoCalidadProducto(esInicial);
		this.setMostrarnombreCalidadProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CalidadProductoConstantesFunciones.ID)) {
				this.setMostraridCalidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalidadProductoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCalidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalidadProductoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCalidadProducto(esAsigna);
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
		
		
		this.setActivaridCalidadProducto(esInicial);
		this.setActivarcodigoCalidadProducto(esInicial);
		this.setActivarnombreCalidadProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CalidadProductoConstantesFunciones.ID)) {
				this.setActivaridCalidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalidadProductoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCalidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalidadProductoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCalidadProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CalidadProductoBeanSwingJInternalFrame calidadproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCalidadProducto(esInicial);
		this.setResaltarcodigoCalidadProducto(esInicial);
		this.setResaltarnombreCalidadProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CalidadProductoConstantesFunciones.ID)) {
				this.setResaltaridCalidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalidadProductoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCalidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CalidadProductoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCalidadProducto(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarBodegaCalidadProducto=null;

	public Border getResaltarBodegaCalidadProducto() {
		return this.resaltarBodegaCalidadProducto;
	}

	public void setResaltarBodegaCalidadProducto(Border borderResaltarBodega) {
		if(borderResaltarBodega!=null) {
			this.resaltarBodegaCalidadProducto= borderResaltarBodega;
		}
	}

	public Border setResaltarBodegaCalidadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CalidadProductoBeanSwingJInternalFrame calidadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarBodega=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//calidadproductoBeanSwingJInternalFrame.jTtoolBarCalidadProducto.setBorder(borderResaltarBodega);
			
		this.resaltarBodegaCalidadProducto= borderResaltarBodega;

		 return borderResaltarBodega;
	}



	public Boolean mostrarBodegaCalidadProducto=true;

	public Boolean getMostrarBodegaCalidadProducto() {
		return this.mostrarBodegaCalidadProducto;
	}

	public void setMostrarBodegaCalidadProducto(Boolean visibilidadResaltarBodega) {
		this.mostrarBodegaCalidadProducto= visibilidadResaltarBodega;
	}



	public Boolean activarBodegaCalidadProducto=true;

	public Boolean gethabilitarResaltarBodegaCalidadProducto() {
		return this.activarBodegaCalidadProducto;
	}

	public void setActivarBodegaCalidadProducto(Boolean habilitarResaltarBodega) {
		this.activarBodegaCalidadProducto= habilitarResaltarBodega;
	}


	public Border resaltarParametroInventarioDefectoCalidadProducto=null;

	public Border getResaltarParametroInventarioDefectoCalidadProducto() {
		return this.resaltarParametroInventarioDefectoCalidadProducto;
	}

	public void setResaltarParametroInventarioDefectoCalidadProducto(Border borderResaltarParametroInventarioDefecto) {
		if(borderResaltarParametroInventarioDefecto!=null) {
			this.resaltarParametroInventarioDefectoCalidadProducto= borderResaltarParametroInventarioDefecto;
		}
	}

	public Border setResaltarParametroInventarioDefectoCalidadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CalidadProductoBeanSwingJInternalFrame calidadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroInventarioDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//calidadproductoBeanSwingJInternalFrame.jTtoolBarCalidadProducto.setBorder(borderResaltarParametroInventarioDefecto);
			
		this.resaltarParametroInventarioDefectoCalidadProducto= borderResaltarParametroInventarioDefecto;

		 return borderResaltarParametroInventarioDefecto;
	}



	public Boolean mostrarParametroInventarioDefectoCalidadProducto=true;

	public Boolean getMostrarParametroInventarioDefectoCalidadProducto() {
		return this.mostrarParametroInventarioDefectoCalidadProducto;
	}

	public void setMostrarParametroInventarioDefectoCalidadProducto(Boolean visibilidadResaltarParametroInventarioDefecto) {
		this.mostrarParametroInventarioDefectoCalidadProducto= visibilidadResaltarParametroInventarioDefecto;
	}



	public Boolean activarParametroInventarioDefectoCalidadProducto=true;

	public Boolean gethabilitarResaltarParametroInventarioDefectoCalidadProducto() {
		return this.activarParametroInventarioDefectoCalidadProducto;
	}

	public void setActivarParametroInventarioDefectoCalidadProducto(Boolean habilitarResaltarParametroInventarioDefecto) {
		this.activarParametroInventarioDefectoCalidadProducto= habilitarResaltarParametroInventarioDefecto;
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

		this.setMostrarBodegaCalidadProducto(esInicial);
		this.setMostrarParametroInventarioDefectoCalidadProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Bodega.class)) {
				this.setMostrarBodegaCalidadProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setMostrarParametroInventarioDefectoCalidadProducto(esAsigna);
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

		this.setActivarBodegaCalidadProducto(esInicial);
		this.setActivarParametroInventarioDefectoCalidadProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Bodega.class)) {
				this.setActivarBodegaCalidadProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setActivarParametroInventarioDefectoCalidadProducto(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CalidadProductoBeanSwingJInternalFrame calidadproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarBodegaCalidadProducto(esInicial);
		this.setResaltarParametroInventarioDefectoCalidadProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Bodega.class)) {
				this.setResaltarBodegaCalidadProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setResaltarParametroInventarioDefectoCalidadProducto(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoCalidadProducto=true;

	public Boolean getMostrarBusquedaPorCodigoCalidadProducto() {
		return this.mostrarBusquedaPorCodigoCalidadProducto;
	}

	public void setMostrarBusquedaPorCodigoCalidadProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoCalidadProducto= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreCalidadProducto=true;

	public Boolean getMostrarBusquedaPorNombreCalidadProducto() {
		return this.mostrarBusquedaPorNombreCalidadProducto;
	}

	public void setMostrarBusquedaPorNombreCalidadProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreCalidadProducto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoCalidadProducto=true;

	public Boolean getActivarBusquedaPorCodigoCalidadProducto() {
		return this.activarBusquedaPorCodigoCalidadProducto;
	}

	public void setActivarBusquedaPorCodigoCalidadProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoCalidadProducto= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreCalidadProducto=true;

	public Boolean getActivarBusquedaPorNombreCalidadProducto() {
		return this.activarBusquedaPorNombreCalidadProducto;
	}

	public void setActivarBusquedaPorNombreCalidadProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreCalidadProducto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoCalidadProducto=null;

	public Border getResaltarBusquedaPorCodigoCalidadProducto() {
		return this.resaltarBusquedaPorCodigoCalidadProducto;
	}

	public void setResaltarBusquedaPorCodigoCalidadProducto(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoCalidadProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoCalidadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CalidadProductoBeanSwingJInternalFrame calidadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoCalidadProducto= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreCalidadProducto=null;

	public Border getResaltarBusquedaPorNombreCalidadProducto() {
		return this.resaltarBusquedaPorNombreCalidadProducto;
	}

	public void setResaltarBusquedaPorNombreCalidadProducto(Border borderResaltar) {
		this.resaltarBusquedaPorNombreCalidadProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreCalidadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CalidadProductoBeanSwingJInternalFrame calidadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreCalidadProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}