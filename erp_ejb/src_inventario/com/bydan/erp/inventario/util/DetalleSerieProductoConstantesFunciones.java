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


import com.bydan.erp.inventario.util.DetalleSerieProductoConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleSerieProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleSerieProductoParameterGeneral;

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
final public class DetalleSerieProductoConstantesFunciones extends DetalleSerieProductoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleSerieProducto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleSerieProducto"+DetalleSerieProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleSerieProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleSerieProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleSerieProductoConstantesFunciones.SCHEMA+"_"+DetalleSerieProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleSerieProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleSerieProductoConstantesFunciones.SCHEMA+"_"+DetalleSerieProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleSerieProductoConstantesFunciones.SCHEMA+"_"+DetalleSerieProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleSerieProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleSerieProductoConstantesFunciones.SCHEMA+"_"+DetalleSerieProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleSerieProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleSerieProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleSerieProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleSerieProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleSerieProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleSerieProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleSerieProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleSerieProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleSerieProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleSerieProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Serie Productos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Serie Producto";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Serie Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleSerieProducto";
	public static final String OBJECTNAME="detalleserieproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="detalle_serie_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalleserieproducto from "+DetalleSerieProductoConstantesFunciones.SPERSISTENCENAME+" detalleserieproducto";
	public static String QUERYSELECTNATIVE="select "+DetalleSerieProductoConstantesFunciones.SCHEMA+"."+DetalleSerieProductoConstantesFunciones.TABLENAME+".id,"+DetalleSerieProductoConstantesFunciones.SCHEMA+"."+DetalleSerieProductoConstantesFunciones.TABLENAME+".version_row,"+DetalleSerieProductoConstantesFunciones.SCHEMA+"."+DetalleSerieProductoConstantesFunciones.TABLENAME+".id_serie_producto,"+DetalleSerieProductoConstantesFunciones.SCHEMA+"."+DetalleSerieProductoConstantesFunciones.TABLENAME+".nombre,"+DetalleSerieProductoConstantesFunciones.SCHEMA+"."+DetalleSerieProductoConstantesFunciones.TABLENAME+".descripcion from "+DetalleSerieProductoConstantesFunciones.SCHEMA+"."+DetalleSerieProductoConstantesFunciones.TABLENAME;//+" as "+DetalleSerieProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleSerieProductoConstantesFuncionesAdditional detalleserieproductoConstantesFuncionesAdditional=null;
	
	public DetalleSerieProductoConstantesFuncionesAdditional getDetalleSerieProductoConstantesFuncionesAdditional() {
		return this.detalleserieproductoConstantesFuncionesAdditional;
	}
	
	public void setDetalleSerieProductoConstantesFuncionesAdditional(DetalleSerieProductoConstantesFuncionesAdditional detalleserieproductoConstantesFuncionesAdditional) {
		try {
			this.detalleserieproductoConstantesFuncionesAdditional=detalleserieproductoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDSERIEPRODUCTO= "id_serie_producto";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDSERIEPRODUCTO= "Serie Producto";
		public static final String LABEL_IDSERIEPRODUCTO_LOWER= "Serie Producto";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetalleSerieProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleSerieProductoConstantesFunciones.IDSERIEPRODUCTO)) {sLabelColumna=DetalleSerieProductoConstantesFunciones.LABEL_IDSERIEPRODUCTO;}
		if(sNombreColumna.equals(DetalleSerieProductoConstantesFunciones.NOMBRE)) {sLabelColumna=DetalleSerieProductoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(DetalleSerieProductoConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleSerieProductoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getDetalleSerieProductoDescripcion(DetalleSerieProducto detalleserieproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalleserieproducto !=null/* && detalleserieproducto.getId()!=0*/) {
			sDescripcion=detalleserieproducto.getnombre();//detalleserieproductodetalleserieproducto.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleSerieProductoDescripcionDetallado(DetalleSerieProducto detalleserieproducto) {
		String sDescripcion="";
			
		sDescripcion+=DetalleSerieProductoConstantesFunciones.ID+"=";
		sDescripcion+=detalleserieproducto.getId().toString()+",";
		sDescripcion+=DetalleSerieProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalleserieproducto.getVersionRow().toString()+",";
		sDescripcion+=DetalleSerieProductoConstantesFunciones.IDSERIEPRODUCTO+"=";
		sDescripcion+=detalleserieproducto.getid_serie_producto().toString()+",";
		sDescripcion+=DetalleSerieProductoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=detalleserieproducto.getnombre()+",";
		sDescripcion+=DetalleSerieProductoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detalleserieproducto.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleSerieProductoDescripcion(DetalleSerieProducto detalleserieproducto,String sValor) throws Exception {			
		if(detalleserieproducto !=null) {
			detalleserieproducto.setnombre(sValor);;//detalleserieproductodetalleserieproducto.getnombre().trim();
		}		
	}
	
		

	public static String getSerieProductoDescripcion(SerieProducto serieproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(serieproducto!=null/*&&serieproducto.getId()>0*/) {
			sDescripcion=SerieProductoConstantesFunciones.getSerieProductoDescripcion(serieproducto);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdSerieProducto")) {
			sNombreIndice="Tipo=  Por Serie Producto";
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

	public static String getDetalleIndiceFK_IdSerieProducto(Long id_serie_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_serie_producto!=null) {sDetalleIndice+=" Codigo Unico De Serie Producto="+id_serie_producto.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleSerieProducto(DetalleSerieProducto detalleserieproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalleserieproducto.setnombre(detalleserieproducto.getnombre().trim());
		detalleserieproducto.setdescripcion(detalleserieproducto.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDetalleSerieProductos(List<DetalleSerieProducto> detalleserieproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleSerieProducto detalleserieproducto: detalleserieproductos) {
			detalleserieproducto.setnombre(detalleserieproducto.getnombre().trim());
			detalleserieproducto.setdescripcion(detalleserieproducto.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleSerieProducto(DetalleSerieProducto detalleserieproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalleserieproducto.getConCambioAuxiliar()) {
			detalleserieproducto.setIsDeleted(detalleserieproducto.getIsDeletedAuxiliar());	
			detalleserieproducto.setIsNew(detalleserieproducto.getIsNewAuxiliar());	
			detalleserieproducto.setIsChanged(detalleserieproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalleserieproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalleserieproducto.setIsDeletedAuxiliar(false);	
			detalleserieproducto.setIsNewAuxiliar(false);	
			detalleserieproducto.setIsChangedAuxiliar(false);
			
			detalleserieproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleSerieProductos(List<DetalleSerieProducto> detalleserieproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleSerieProducto detalleserieproducto : detalleserieproductos) {
			if(conAsignarBase && detalleserieproducto.getConCambioAuxiliar()) {
				detalleserieproducto.setIsDeleted(detalleserieproducto.getIsDeletedAuxiliar());	
				detalleserieproducto.setIsNew(detalleserieproducto.getIsNewAuxiliar());	
				detalleserieproducto.setIsChanged(detalleserieproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalleserieproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalleserieproducto.setIsDeletedAuxiliar(false);	
				detalleserieproducto.setIsNewAuxiliar(false);	
				detalleserieproducto.setIsChangedAuxiliar(false);
				
				detalleserieproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleSerieProducto(DetalleSerieProducto detalleserieproducto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetalleSerieProductos(List<DetalleSerieProducto> detalleserieproductos,Boolean conEnteros) throws Exception  {
		
		for(DetalleSerieProducto detalleserieproducto: detalleserieproductos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleSerieProducto(List<DetalleSerieProducto> detalleserieproductos,DetalleSerieProducto detalleserieproductoAux) throws Exception  {
		DetalleSerieProductoConstantesFunciones.InicializarValoresDetalleSerieProducto(detalleserieproductoAux,true);
		
		for(DetalleSerieProducto detalleserieproducto: detalleserieproductos) {
			if(detalleserieproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleSerieProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleSerieProductoConstantesFunciones.getArrayColumnasGlobalesDetalleSerieProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleSerieProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleSerieProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleSerieProducto> detalleserieproductos,DetalleSerieProducto detalleserieproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleSerieProducto detalleserieproductoAux: detalleserieproductos) {
			if(detalleserieproductoAux!=null && detalleserieproducto!=null) {
				if((detalleserieproductoAux.getId()==null && detalleserieproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalleserieproductoAux.getId()!=null && detalleserieproducto.getId()!=null){
					if(detalleserieproductoAux.getId().equals(detalleserieproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleSerieProducto(List<DetalleSerieProducto> detalleserieproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(DetalleSerieProducto detalleserieproducto: detalleserieproductos) {			
			if(detalleserieproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleSerieProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleSerieProductoConstantesFunciones.LABEL_ID, DetalleSerieProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleSerieProductoConstantesFunciones.LABEL_VERSIONROW, DetalleSerieProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleSerieProductoConstantesFunciones.LABEL_IDSERIEPRODUCTO, DetalleSerieProductoConstantesFunciones.IDSERIEPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleSerieProductoConstantesFunciones.LABEL_NOMBRE, DetalleSerieProductoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleSerieProductoConstantesFunciones.LABEL_DESCRIPCION, DetalleSerieProductoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleSerieProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleSerieProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleSerieProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleSerieProductoConstantesFunciones.IDSERIEPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleSerieProductoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleSerieProductoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleSerieProducto() throws Exception  {
		return DetalleSerieProductoConstantesFunciones.getTiposSeleccionarDetalleSerieProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleSerieProducto(Boolean conFk) throws Exception  {
		return DetalleSerieProductoConstantesFunciones.getTiposSeleccionarDetalleSerieProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleSerieProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleSerieProductoConstantesFunciones.LABEL_IDSERIEPRODUCTO);
			reporte.setsDescripcion(DetalleSerieProductoConstantesFunciones.LABEL_IDSERIEPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleSerieProductoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(DetalleSerieProductoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleSerieProductoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleSerieProductoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleSerieProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleSerieProducto(DetalleSerieProducto detalleserieproductoAux) throws Exception {
		
			detalleserieproductoAux.setserieproducto_descripcion(SerieProductoConstantesFunciones.getSerieProductoDescripcion(detalleserieproductoAux.getSerieProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleSerieProducto(List<DetalleSerieProducto> detalleserieproductosTemp) throws Exception {
		for(DetalleSerieProducto detalleserieproductoAux:detalleserieproductosTemp) {
			
			detalleserieproductoAux.setserieproducto_descripcion(SerieProductoConstantesFunciones.getSerieProductoDescripcion(detalleserieproductoAux.getSerieProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleSerieProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(SerieProducto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(SerieProducto.class)) {
						classes.add(new Classe(SerieProducto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleSerieProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(SerieProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SerieProducto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(SerieProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SerieProducto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleSerieProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleSerieProductoConstantesFunciones.getClassesRelationshipsOfDetalleSerieProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleSerieProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleSerieProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleSerieProductoConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleSerieProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleSerieProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(DetalleSerieProducto detalleserieproducto,List<DetalleSerieProducto> detalleserieproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleSerieProducto detalleserieproductoEncontrado=null;
			
			for(DetalleSerieProducto detalleserieproductoLocal:detalleserieproductos) {
				if(detalleserieproductoLocal.getId().equals(detalleserieproducto.getId())) {
					detalleserieproductoEncontrado=detalleserieproductoLocal;
					
					detalleserieproductoLocal.setIsChanged(detalleserieproducto.getIsChanged());
					detalleserieproductoLocal.setIsNew(detalleserieproducto.getIsNew());
					detalleserieproductoLocal.setIsDeleted(detalleserieproducto.getIsDeleted());
					
					detalleserieproductoLocal.setGeneralEntityOriginal(detalleserieproducto.getGeneralEntityOriginal());
					
					detalleserieproductoLocal.setId(detalleserieproducto.getId());	
					detalleserieproductoLocal.setVersionRow(detalleserieproducto.getVersionRow());	
					detalleserieproductoLocal.setid_serie_producto(detalleserieproducto.getid_serie_producto());	
					detalleserieproductoLocal.setnombre(detalleserieproducto.getnombre());	
					detalleserieproductoLocal.setdescripcion(detalleserieproducto.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detalleserieproducto.getIsDeleted()) {
				if(!existe) {
					detalleserieproductos.add(detalleserieproducto);
				}
			} else {
				if(detalleserieproductoEncontrado!=null && permiteQuitar)  {
					detalleserieproductos.remove(detalleserieproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleSerieProducto detalleserieproducto,List<DetalleSerieProducto> detalleserieproductos) throws Exception {
		try	{			
			for(DetalleSerieProducto detalleserieproductoLocal:detalleserieproductos) {
				if(detalleserieproductoLocal.getId().equals(detalleserieproducto.getId())) {
					detalleserieproductoLocal.setIsSelected(detalleserieproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleSerieProducto(List<DetalleSerieProducto> detalleserieproductosAux) throws Exception {
		//this.detalleserieproductosAux=detalleserieproductosAux;
		
		for(DetalleSerieProducto detalleserieproductoAux:detalleserieproductosAux) {
			if(detalleserieproductoAux.getIsChanged()) {
				detalleserieproductoAux.setIsChanged(false);
			}		
			
			if(detalleserieproductoAux.getIsNew()) {
				detalleserieproductoAux.setIsNew(false);
			}	
			
			if(detalleserieproductoAux.getIsDeleted()) {
				detalleserieproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleSerieProducto(DetalleSerieProducto detalleserieproductoAux) throws Exception {
		//this.detalleserieproductoAux=detalleserieproductoAux;
		
			if(detalleserieproductoAux.getIsChanged()) {
				detalleserieproductoAux.setIsChanged(false);
			}		
			
			if(detalleserieproductoAux.getIsNew()) {
				detalleserieproductoAux.setIsNew(false);
			}	
			
			if(detalleserieproductoAux.getIsDeleted()) {
				detalleserieproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleSerieProducto detalleserieproductoAsignar,DetalleSerieProducto detalleserieproducto) throws Exception {
		detalleserieproductoAsignar.setId(detalleserieproducto.getId());	
		detalleserieproductoAsignar.setVersionRow(detalleserieproducto.getVersionRow());	
		detalleserieproductoAsignar.setid_serie_producto(detalleserieproducto.getid_serie_producto());
		detalleserieproductoAsignar.setserieproducto_descripcion(detalleserieproducto.getserieproducto_descripcion());	
		detalleserieproductoAsignar.setnombre(detalleserieproducto.getnombre());	
		detalleserieproductoAsignar.setdescripcion(detalleserieproducto.getdescripcion());	
	}
	
	public static void inicializarDetalleSerieProducto(DetalleSerieProducto detalleserieproducto) throws Exception {
		try {
				detalleserieproducto.setId(0L);	
					
				detalleserieproducto.setid_serie_producto(-1L);	
				detalleserieproducto.setnombre("");	
				detalleserieproducto.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleSerieProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleSerieProductoConstantesFunciones.LABEL_IDSERIEPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleSerieProductoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleSerieProductoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleSerieProducto(String sTipo,Row row,Workbook workbook,DetalleSerieProducto detalleserieproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleserieproducto.getserieproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleserieproducto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleserieproducto.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleSerieProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleSerieProducto() {
		return this.sFinalQueryDetalleSerieProducto;
	}
	
	public void setsFinalQueryDetalleSerieProducto(String sFinalQueryDetalleSerieProducto) {
		this.sFinalQueryDetalleSerieProducto= sFinalQueryDetalleSerieProducto;
	}
	
	public Border resaltarSeleccionarDetalleSerieProducto=null;
	
	public Border setResaltarSeleccionarDetalleSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleSerieProductoBeanSwingJInternalFrame detalleserieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detalleserieproductoBeanSwingJInternalFrame.jTtoolBarDetalleSerieProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleSerieProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleSerieProducto() {
		return this.resaltarSeleccionarDetalleSerieProducto;
	}
	
	public void setResaltarSeleccionarDetalleSerieProducto(Border borderResaltarSeleccionarDetalleSerieProducto) {
		this.resaltarSeleccionarDetalleSerieProducto= borderResaltarSeleccionarDetalleSerieProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleSerieProducto=null;
	public Boolean mostraridDetalleSerieProducto=true;
	public Boolean activaridDetalleSerieProducto=true;

	public Border resaltarid_serie_productoDetalleSerieProducto=null;
	public Boolean mostrarid_serie_productoDetalleSerieProducto=true;
	public Boolean activarid_serie_productoDetalleSerieProducto=true;
	public Boolean cargarid_serie_productoDetalleSerieProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_serie_productoDetalleSerieProducto=false;//ConEventDepend=true

	public Border resaltarnombreDetalleSerieProducto=null;
	public Boolean mostrarnombreDetalleSerieProducto=true;
	public Boolean activarnombreDetalleSerieProducto=true;

	public Border resaltardescripcionDetalleSerieProducto=null;
	public Boolean mostrardescripcionDetalleSerieProducto=true;
	public Boolean activardescripcionDetalleSerieProducto=true;

	
	

	public Border setResaltaridDetalleSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleSerieProductoBeanSwingJInternalFrame detalleserieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleserieproductoBeanSwingJInternalFrame.jTtoolBarDetalleSerieProducto.setBorder(borderResaltar);
		
		this.resaltaridDetalleSerieProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleSerieProducto() {
		return this.resaltaridDetalleSerieProducto;
	}

	public void setResaltaridDetalleSerieProducto(Border borderResaltar) {
		this.resaltaridDetalleSerieProducto= borderResaltar;
	}

	public Boolean getMostraridDetalleSerieProducto() {
		return this.mostraridDetalleSerieProducto;
	}

	public void setMostraridDetalleSerieProducto(Boolean mostraridDetalleSerieProducto) {
		this.mostraridDetalleSerieProducto= mostraridDetalleSerieProducto;
	}

	public Boolean getActivaridDetalleSerieProducto() {
		return this.activaridDetalleSerieProducto;
	}

	public void setActivaridDetalleSerieProducto(Boolean activaridDetalleSerieProducto) {
		this.activaridDetalleSerieProducto= activaridDetalleSerieProducto;
	}

	public Border setResaltarid_serie_productoDetalleSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleSerieProductoBeanSwingJInternalFrame detalleserieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleserieproductoBeanSwingJInternalFrame.jTtoolBarDetalleSerieProducto.setBorder(borderResaltar);
		
		this.resaltarid_serie_productoDetalleSerieProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_serie_productoDetalleSerieProducto() {
		return this.resaltarid_serie_productoDetalleSerieProducto;
	}

	public void setResaltarid_serie_productoDetalleSerieProducto(Border borderResaltar) {
		this.resaltarid_serie_productoDetalleSerieProducto= borderResaltar;
	}

	public Boolean getMostrarid_serie_productoDetalleSerieProducto() {
		return this.mostrarid_serie_productoDetalleSerieProducto;
	}

	public void setMostrarid_serie_productoDetalleSerieProducto(Boolean mostrarid_serie_productoDetalleSerieProducto) {
		this.mostrarid_serie_productoDetalleSerieProducto= mostrarid_serie_productoDetalleSerieProducto;
	}

	public Boolean getActivarid_serie_productoDetalleSerieProducto() {
		return this.activarid_serie_productoDetalleSerieProducto;
	}

	public void setActivarid_serie_productoDetalleSerieProducto(Boolean activarid_serie_productoDetalleSerieProducto) {
		this.activarid_serie_productoDetalleSerieProducto= activarid_serie_productoDetalleSerieProducto;
	}

	public Boolean getCargarid_serie_productoDetalleSerieProducto() {
		return this.cargarid_serie_productoDetalleSerieProducto;
	}

	public void setCargarid_serie_productoDetalleSerieProducto(Boolean cargarid_serie_productoDetalleSerieProducto) {
		this.cargarid_serie_productoDetalleSerieProducto= cargarid_serie_productoDetalleSerieProducto;
	}

	public Border setResaltarnombreDetalleSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleSerieProductoBeanSwingJInternalFrame detalleserieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleserieproductoBeanSwingJInternalFrame.jTtoolBarDetalleSerieProducto.setBorder(borderResaltar);
		
		this.resaltarnombreDetalleSerieProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreDetalleSerieProducto() {
		return this.resaltarnombreDetalleSerieProducto;
	}

	public void setResaltarnombreDetalleSerieProducto(Border borderResaltar) {
		this.resaltarnombreDetalleSerieProducto= borderResaltar;
	}

	public Boolean getMostrarnombreDetalleSerieProducto() {
		return this.mostrarnombreDetalleSerieProducto;
	}

	public void setMostrarnombreDetalleSerieProducto(Boolean mostrarnombreDetalleSerieProducto) {
		this.mostrarnombreDetalleSerieProducto= mostrarnombreDetalleSerieProducto;
	}

	public Boolean getActivarnombreDetalleSerieProducto() {
		return this.activarnombreDetalleSerieProducto;
	}

	public void setActivarnombreDetalleSerieProducto(Boolean activarnombreDetalleSerieProducto) {
		this.activarnombreDetalleSerieProducto= activarnombreDetalleSerieProducto;
	}

	public Border setResaltardescripcionDetalleSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleSerieProductoBeanSwingJInternalFrame detalleserieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleserieproductoBeanSwingJInternalFrame.jTtoolBarDetalleSerieProducto.setBorder(borderResaltar);
		
		this.resaltardescripcionDetalleSerieProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleSerieProducto() {
		return this.resaltardescripcionDetalleSerieProducto;
	}

	public void setResaltardescripcionDetalleSerieProducto(Border borderResaltar) {
		this.resaltardescripcionDetalleSerieProducto= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleSerieProducto() {
		return this.mostrardescripcionDetalleSerieProducto;
	}

	public void setMostrardescripcionDetalleSerieProducto(Boolean mostrardescripcionDetalleSerieProducto) {
		this.mostrardescripcionDetalleSerieProducto= mostrardescripcionDetalleSerieProducto;
	}

	public Boolean getActivardescripcionDetalleSerieProducto() {
		return this.activardescripcionDetalleSerieProducto;
	}

	public void setActivardescripcionDetalleSerieProducto(Boolean activardescripcionDetalleSerieProducto) {
		this.activardescripcionDetalleSerieProducto= activardescripcionDetalleSerieProducto;
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
		
		
		this.setMostraridDetalleSerieProducto(esInicial);
		this.setMostrarid_serie_productoDetalleSerieProducto(esInicial);
		this.setMostrarnombreDetalleSerieProducto(esInicial);
		this.setMostrardescripcionDetalleSerieProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleSerieProductoConstantesFunciones.ID)) {
				this.setMostraridDetalleSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleSerieProductoConstantesFunciones.IDSERIEPRODUCTO)) {
				this.setMostrarid_serie_productoDetalleSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleSerieProductoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreDetalleSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleSerieProductoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleSerieProducto(esAsigna);
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
		
		
		this.setActivaridDetalleSerieProducto(esInicial);
		this.setActivarid_serie_productoDetalleSerieProducto(esInicial);
		this.setActivarnombreDetalleSerieProducto(esInicial);
		this.setActivardescripcionDetalleSerieProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleSerieProductoConstantesFunciones.ID)) {
				this.setActivaridDetalleSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleSerieProductoConstantesFunciones.IDSERIEPRODUCTO)) {
				this.setActivarid_serie_productoDetalleSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleSerieProductoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreDetalleSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleSerieProductoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleSerieProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleSerieProductoBeanSwingJInternalFrame detalleserieproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleSerieProducto(esInicial);
		this.setResaltarid_serie_productoDetalleSerieProducto(esInicial);
		this.setResaltarnombreDetalleSerieProducto(esInicial);
		this.setResaltardescripcionDetalleSerieProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleSerieProductoConstantesFunciones.ID)) {
				this.setResaltaridDetalleSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleSerieProductoConstantesFunciones.IDSERIEPRODUCTO)) {
				this.setResaltarid_serie_productoDetalleSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleSerieProductoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreDetalleSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleSerieProductoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleSerieProducto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleSerieProductoBeanSwingJInternalFrame detalleserieproductoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorNombreDetalleSerieProducto=true;

	public Boolean getMostrarBusquedaPorNombreDetalleSerieProducto() {
		return this.mostrarBusquedaPorNombreDetalleSerieProducto;
	}

	public void setMostrarBusquedaPorNombreDetalleSerieProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreDetalleSerieProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSerieProductoDetalleSerieProducto=true;

	public Boolean getMostrarFK_IdSerieProductoDetalleSerieProducto() {
		return this.mostrarFK_IdSerieProductoDetalleSerieProducto;
	}

	public void setMostrarFK_IdSerieProductoDetalleSerieProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSerieProductoDetalleSerieProducto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreDetalleSerieProducto=true;

	public Boolean getActivarBusquedaPorNombreDetalleSerieProducto() {
		return this.activarBusquedaPorNombreDetalleSerieProducto;
	}

	public void setActivarBusquedaPorNombreDetalleSerieProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreDetalleSerieProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdSerieProductoDetalleSerieProducto=true;

	public Boolean getActivarFK_IdSerieProductoDetalleSerieProducto() {
		return this.activarFK_IdSerieProductoDetalleSerieProducto;
	}

	public void setActivarFK_IdSerieProductoDetalleSerieProducto(Boolean habilitarResaltar) {
		this.activarFK_IdSerieProductoDetalleSerieProducto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreDetalleSerieProducto=null;

	public Border getResaltarBusquedaPorNombreDetalleSerieProducto() {
		return this.resaltarBusquedaPorNombreDetalleSerieProducto;
	}

	public void setResaltarBusquedaPorNombreDetalleSerieProducto(Border borderResaltar) {
		this.resaltarBusquedaPorNombreDetalleSerieProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreDetalleSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleSerieProductoBeanSwingJInternalFrame detalleserieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreDetalleSerieProducto= borderResaltar;
	}

	public Border resaltarFK_IdSerieProductoDetalleSerieProducto=null;

	public Border getResaltarFK_IdSerieProductoDetalleSerieProducto() {
		return this.resaltarFK_IdSerieProductoDetalleSerieProducto;
	}

	public void setResaltarFK_IdSerieProductoDetalleSerieProducto(Border borderResaltar) {
		this.resaltarFK_IdSerieProductoDetalleSerieProducto= borderResaltar;
	}

	public void setResaltarFK_IdSerieProductoDetalleSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleSerieProductoBeanSwingJInternalFrame detalleserieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSerieProductoDetalleSerieProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}