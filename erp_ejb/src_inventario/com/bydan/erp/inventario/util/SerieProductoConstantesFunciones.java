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


import com.bydan.erp.inventario.util.SerieProductoConstantesFunciones;
import com.bydan.erp.inventario.util.SerieProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.SerieProductoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class SerieProductoConstantesFunciones extends SerieProductoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="SerieProducto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="SerieProducto"+SerieProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SerieProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SerieProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SerieProductoConstantesFunciones.SCHEMA+"_"+SerieProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SerieProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SerieProductoConstantesFunciones.SCHEMA+"_"+SerieProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SerieProductoConstantesFunciones.SCHEMA+"_"+SerieProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SerieProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SerieProductoConstantesFunciones.SCHEMA+"_"+SerieProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SerieProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SerieProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SerieProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SerieProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SerieProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SerieProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SerieProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SerieProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SerieProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SerieProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Serie Productos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Serie Producto";
	public static final String SCLASSWEBTITULO_LOWER="Serie Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="SerieProducto";
	public static final String OBJECTNAME="serieproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="serie_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select serieproducto from "+SerieProductoConstantesFunciones.SPERSISTENCENAME+" serieproducto";
	public static String QUERYSELECTNATIVE="select "+SerieProductoConstantesFunciones.SCHEMA+"."+SerieProductoConstantesFunciones.TABLENAME+".id,"+SerieProductoConstantesFunciones.SCHEMA+"."+SerieProductoConstantesFunciones.TABLENAME+".version_row,"+SerieProductoConstantesFunciones.SCHEMA+"."+SerieProductoConstantesFunciones.TABLENAME+".id_empresa,"+SerieProductoConstantesFunciones.SCHEMA+"."+SerieProductoConstantesFunciones.TABLENAME+".id_bodega,"+SerieProductoConstantesFunciones.SCHEMA+"."+SerieProductoConstantesFunciones.TABLENAME+".id_producto,"+SerieProductoConstantesFunciones.SCHEMA+"."+SerieProductoConstantesFunciones.TABLENAME+".codigo,"+SerieProductoConstantesFunciones.SCHEMA+"."+SerieProductoConstantesFunciones.TABLENAME+".fecha_compra,"+SerieProductoConstantesFunciones.SCHEMA+"."+SerieProductoConstantesFunciones.TABLENAME+".fecha_entrega,"+SerieProductoConstantesFunciones.SCHEMA+"."+SerieProductoConstantesFunciones.TABLENAME+".fecha_venta,"+SerieProductoConstantesFunciones.SCHEMA+"."+SerieProductoConstantesFunciones.TABLENAME+".descripcion from "+SerieProductoConstantesFunciones.SCHEMA+"."+SerieProductoConstantesFunciones.TABLENAME;//+" as "+SerieProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected SerieProductoConstantesFuncionesAdditional serieproductoConstantesFuncionesAdditional=null;
	
	public SerieProductoConstantesFuncionesAdditional getSerieProductoConstantesFuncionesAdditional() {
		return this.serieproductoConstantesFuncionesAdditional;
	}
	
	public void setSerieProductoConstantesFuncionesAdditional(SerieProductoConstantesFuncionesAdditional serieproductoConstantesFuncionesAdditional) {
		try {
			this.serieproductoConstantesFuncionesAdditional=serieproductoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String CODIGO= "codigo";
    public static final String FECHACOMPRA= "fecha_compra";
    public static final String FECHAENTREGA= "fecha_entrega";
    public static final String FECHAVENTA= "fecha_venta";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_FECHACOMPRA= "Fecha Compra";
		public static final String LABEL_FECHACOMPRA_LOWER= "Fecha Compra";
    	public static final String LABEL_FECHAENTREGA= "Fecha Entrega";
		public static final String LABEL_FECHAENTREGA_LOWER= "Fecha Entrega";
    	public static final String LABEL_FECHAVENTA= "Fecha Venta";
		public static final String LABEL_FECHAVENTA_LOWER= "Fecha Venta";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getSerieProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SerieProductoConstantesFunciones.IDEMPRESA)) {sLabelColumna=SerieProductoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SerieProductoConstantesFunciones.IDBODEGA)) {sLabelColumna=SerieProductoConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(SerieProductoConstantesFunciones.IDPRODUCTO)) {sLabelColumna=SerieProductoConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(SerieProductoConstantesFunciones.CODIGO)) {sLabelColumna=SerieProductoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(SerieProductoConstantesFunciones.FECHACOMPRA)) {sLabelColumna=SerieProductoConstantesFunciones.LABEL_FECHACOMPRA;}
		if(sNombreColumna.equals(SerieProductoConstantesFunciones.FECHAENTREGA)) {sLabelColumna=SerieProductoConstantesFunciones.LABEL_FECHAENTREGA;}
		if(sNombreColumna.equals(SerieProductoConstantesFunciones.FECHAVENTA)) {sLabelColumna=SerieProductoConstantesFunciones.LABEL_FECHAVENTA;}
		if(sNombreColumna.equals(SerieProductoConstantesFunciones.DESCRIPCION)) {sLabelColumna=SerieProductoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
	
	public static String getSerieProductoDescripcion(SerieProducto serieproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(serieproducto !=null/* && serieproducto.getId()!=0*/) {
			sDescripcion=serieproducto.getcodigo().toString();//serieproductoserieproducto.getcodigo().toString().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getSerieProductoDescripcionDetallado(SerieProducto serieproducto) {
		String sDescripcion="";
			
		sDescripcion+=SerieProductoConstantesFunciones.ID+"=";
		sDescripcion+=serieproducto.getId().toString()+",";
		sDescripcion+=SerieProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=serieproducto.getVersionRow().toString()+",";
		sDescripcion+=SerieProductoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=serieproducto.getid_empresa().toString()+",";
		sDescripcion+=SerieProductoConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=serieproducto.getid_bodega().toString()+",";
		sDescripcion+=SerieProductoConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=serieproducto.getid_producto().toString()+",";
		sDescripcion+=SerieProductoConstantesFunciones.CODIGO+"=";
		sDescripcion+=serieproducto.getcodigo().toString()+",";
		sDescripcion+=SerieProductoConstantesFunciones.FECHACOMPRA+"=";
		sDescripcion+=serieproducto.getfecha_compra().toString()+",";
		sDescripcion+=SerieProductoConstantesFunciones.FECHAENTREGA+"=";
		sDescripcion+=serieproducto.getfecha_entrega().toString()+",";
		sDescripcion+=SerieProductoConstantesFunciones.FECHAVENTA+"=";
		sDescripcion+=serieproducto.getfecha_venta().toString()+",";
		sDescripcion+=SerieProductoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=serieproducto.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setSerieProductoDescripcion(SerieProducto serieproducto,String sValor) throws Exception {			
		if(serieproducto !=null) {
			;//serieproductoserieproducto.getcodigo().toString().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getBodegaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}

	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorFechaCompra")) {
			sNombreIndice="Tipo=  Por Fecha Compra";
		} else if(sNombreIndice.equals("BusquedaPorFechaEntrega")) {
			sNombreIndice="Tipo=  Por Fecha Entrega";
		} else if(sNombreIndice.equals("BusquedaPorFechaVenta")) {
			sNombreIndice="Tipo=  Por Fecha Venta";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(Double codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorFechaCompra(Date fecha_compra) {
		String sDetalleIndice=" Parametros->";
		if(fecha_compra!=null) {sDetalleIndice+=" Fecha Compra="+fecha_compra.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorFechaEntrega(Date fecha_entrega) {
		String sDetalleIndice=" Parametros->";
		if(fecha_entrega!=null) {sDetalleIndice+=" Fecha Entrega="+fecha_entrega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorFechaVenta(Date fecha_venta) {
		String sDetalleIndice=" Parametros->";
		if(fecha_venta!=null) {sDetalleIndice+=" Fecha Venta="+fecha_venta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosSerieProducto(SerieProducto serieproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		serieproducto.setdescripcion(serieproducto.getdescripcion().trim());
	}
	
	public static void quitarEspaciosSerieProductos(List<SerieProducto> serieproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SerieProducto serieproducto: serieproductos) {
			serieproducto.setdescripcion(serieproducto.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSerieProducto(SerieProducto serieproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && serieproducto.getConCambioAuxiliar()) {
			serieproducto.setIsDeleted(serieproducto.getIsDeletedAuxiliar());	
			serieproducto.setIsNew(serieproducto.getIsNewAuxiliar());	
			serieproducto.setIsChanged(serieproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			serieproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			serieproducto.setIsDeletedAuxiliar(false);	
			serieproducto.setIsNewAuxiliar(false);	
			serieproducto.setIsChangedAuxiliar(false);
			
			serieproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSerieProductos(List<SerieProducto> serieproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(SerieProducto serieproducto : serieproductos) {
			if(conAsignarBase && serieproducto.getConCambioAuxiliar()) {
				serieproducto.setIsDeleted(serieproducto.getIsDeletedAuxiliar());	
				serieproducto.setIsNew(serieproducto.getIsNewAuxiliar());	
				serieproducto.setIsChanged(serieproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				serieproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				serieproducto.setIsDeletedAuxiliar(false);	
				serieproducto.setIsNewAuxiliar(false);	
				serieproducto.setIsChangedAuxiliar(false);
				
				serieproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSerieProducto(SerieProducto serieproducto,Boolean conEnteros) throws Exception  {
		serieproducto.setcodigo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSerieProductos(List<SerieProducto> serieproductos,Boolean conEnteros) throws Exception  {
		
		for(SerieProducto serieproducto: serieproductos) {
			serieproducto.setcodigo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSerieProducto(List<SerieProducto> serieproductos,SerieProducto serieproductoAux) throws Exception  {
		SerieProductoConstantesFunciones.InicializarValoresSerieProducto(serieproductoAux,true);
		
		for(SerieProducto serieproducto: serieproductos) {
			if(serieproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			serieproductoAux.setcodigo(serieproductoAux.getcodigo()+serieproducto.getcodigo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSerieProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SerieProductoConstantesFunciones.getArrayColumnasGlobalesSerieProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSerieProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SerieProductoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SerieProductoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSerieProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SerieProducto> serieproductos,SerieProducto serieproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SerieProducto serieproductoAux: serieproductos) {
			if(serieproductoAux!=null && serieproducto!=null) {
				if((serieproductoAux.getId()==null && serieproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(serieproductoAux.getId()!=null && serieproducto.getId()!=null){
					if(serieproductoAux.getId().equals(serieproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSerieProducto(List<SerieProducto> serieproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double codigoTotal=0.0;
	
		for(SerieProducto serieproducto: serieproductos) {			
			if(serieproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			codigoTotal+=serieproducto.getcodigo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SerieProductoConstantesFunciones.CODIGO);
		datoGeneral.setsDescripcion(SerieProductoConstantesFunciones.LABEL_CODIGO);
		datoGeneral.setdValorDouble(codigoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSerieProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SerieProductoConstantesFunciones.LABEL_ID, SerieProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SerieProductoConstantesFunciones.LABEL_VERSIONROW, SerieProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SerieProductoConstantesFunciones.LABEL_IDEMPRESA, SerieProductoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SerieProductoConstantesFunciones.LABEL_IDBODEGA, SerieProductoConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SerieProductoConstantesFunciones.LABEL_IDPRODUCTO, SerieProductoConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SerieProductoConstantesFunciones.LABEL_CODIGO, SerieProductoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SerieProductoConstantesFunciones.LABEL_FECHACOMPRA, SerieProductoConstantesFunciones.FECHACOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SerieProductoConstantesFunciones.LABEL_FECHAENTREGA, SerieProductoConstantesFunciones.FECHAENTREGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SerieProductoConstantesFunciones.LABEL_FECHAVENTA, SerieProductoConstantesFunciones.FECHAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SerieProductoConstantesFunciones.LABEL_DESCRIPCION, SerieProductoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSerieProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SerieProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SerieProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SerieProductoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SerieProductoConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SerieProductoConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SerieProductoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SerieProductoConstantesFunciones.FECHACOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SerieProductoConstantesFunciones.FECHAENTREGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SerieProductoConstantesFunciones.FECHAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SerieProductoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSerieProducto() throws Exception  {
		return SerieProductoConstantesFunciones.getTiposSeleccionarSerieProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSerieProducto(Boolean conFk) throws Exception  {
		return SerieProductoConstantesFunciones.getTiposSeleccionarSerieProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSerieProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SerieProductoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SerieProductoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SerieProductoConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(SerieProductoConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SerieProductoConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(SerieProductoConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SerieProductoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(SerieProductoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SerieProductoConstantesFunciones.LABEL_FECHACOMPRA);
			reporte.setsDescripcion(SerieProductoConstantesFunciones.LABEL_FECHACOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SerieProductoConstantesFunciones.LABEL_FECHAENTREGA);
			reporte.setsDescripcion(SerieProductoConstantesFunciones.LABEL_FECHAENTREGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SerieProductoConstantesFunciones.LABEL_FECHAVENTA);
			reporte.setsDescripcion(SerieProductoConstantesFunciones.LABEL_FECHAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SerieProductoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(SerieProductoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSerieProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSerieProducto(SerieProducto serieproductoAux) throws Exception {
		
			serieproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(serieproductoAux.getEmpresa()));
			serieproductoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(serieproductoAux.getBodega()));
			serieproductoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(serieproductoAux.getProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSerieProducto(List<SerieProducto> serieproductosTemp) throws Exception {
		for(SerieProducto serieproductoAux:serieproductosTemp) {
			
			serieproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(serieproductoAux.getEmpresa()));
			serieproductoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(serieproductoAux.getBodega()));
			serieproductoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(serieproductoAux.getProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSerieProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSerieProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSerieProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SerieProductoConstantesFunciones.getClassesRelationshipsOfSerieProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSerieProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleSerieProducto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleSerieProducto.class)) {
						classes.add(new Classe(DetalleSerieProducto.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSerieProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SerieProductoConstantesFunciones.getClassesRelationshipsFromStringsOfSerieProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSerieProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleSerieProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleSerieProducto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleSerieProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleSerieProducto.class)); continue;
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
	public static void actualizarLista(SerieProducto serieproducto,List<SerieProducto> serieproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			SerieProducto serieproductoEncontrado=null;
			
			for(SerieProducto serieproductoLocal:serieproductos) {
				if(serieproductoLocal.getId().equals(serieproducto.getId())) {
					serieproductoEncontrado=serieproductoLocal;
					
					serieproductoLocal.setIsChanged(serieproducto.getIsChanged());
					serieproductoLocal.setIsNew(serieproducto.getIsNew());
					serieproductoLocal.setIsDeleted(serieproducto.getIsDeleted());
					
					serieproductoLocal.setGeneralEntityOriginal(serieproducto.getGeneralEntityOriginal());
					
					serieproductoLocal.setId(serieproducto.getId());	
					serieproductoLocal.setVersionRow(serieproducto.getVersionRow());	
					serieproductoLocal.setid_empresa(serieproducto.getid_empresa());	
					serieproductoLocal.setid_bodega(serieproducto.getid_bodega());	
					serieproductoLocal.setid_producto(serieproducto.getid_producto());	
					serieproductoLocal.setcodigo(serieproducto.getcodigo());	
					serieproductoLocal.setfecha_compra(serieproducto.getfecha_compra());	
					serieproductoLocal.setfecha_entrega(serieproducto.getfecha_entrega());	
					serieproductoLocal.setfecha_venta(serieproducto.getfecha_venta());	
					serieproductoLocal.setdescripcion(serieproducto.getdescripcion());	
					
					
					serieproductoLocal.setDetalleSerieProductos(serieproducto.getDetalleSerieProductos());
					
					existe=true;
					break;
				}
			}
			
			if(!serieproducto.getIsDeleted()) {
				if(!existe) {
					serieproductos.add(serieproducto);
				}
			} else {
				if(serieproductoEncontrado!=null && permiteQuitar)  {
					serieproductos.remove(serieproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(SerieProducto serieproducto,List<SerieProducto> serieproductos) throws Exception {
		try	{			
			for(SerieProducto serieproductoLocal:serieproductos) {
				if(serieproductoLocal.getId().equals(serieproducto.getId())) {
					serieproductoLocal.setIsSelected(serieproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSerieProducto(List<SerieProducto> serieproductosAux) throws Exception {
		//this.serieproductosAux=serieproductosAux;
		
		for(SerieProducto serieproductoAux:serieproductosAux) {
			if(serieproductoAux.getIsChanged()) {
				serieproductoAux.setIsChanged(false);
			}		
			
			if(serieproductoAux.getIsNew()) {
				serieproductoAux.setIsNew(false);
			}	
			
			if(serieproductoAux.getIsDeleted()) {
				serieproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSerieProducto(SerieProducto serieproductoAux) throws Exception {
		//this.serieproductoAux=serieproductoAux;
		
			if(serieproductoAux.getIsChanged()) {
				serieproductoAux.setIsChanged(false);
			}		
			
			if(serieproductoAux.getIsNew()) {
				serieproductoAux.setIsNew(false);
			}	
			
			if(serieproductoAux.getIsDeleted()) {
				serieproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(SerieProducto serieproductoAsignar,SerieProducto serieproducto) throws Exception {
		serieproductoAsignar.setId(serieproducto.getId());	
		serieproductoAsignar.setVersionRow(serieproducto.getVersionRow());	
		serieproductoAsignar.setid_empresa(serieproducto.getid_empresa());
		serieproductoAsignar.setempresa_descripcion(serieproducto.getempresa_descripcion());	
		serieproductoAsignar.setid_bodega(serieproducto.getid_bodega());
		serieproductoAsignar.setbodega_descripcion(serieproducto.getbodega_descripcion());	
		serieproductoAsignar.setid_producto(serieproducto.getid_producto());
		serieproductoAsignar.setproducto_descripcion(serieproducto.getproducto_descripcion());	
		serieproductoAsignar.setcodigo(serieproducto.getcodigo());	
		serieproductoAsignar.setfecha_compra(serieproducto.getfecha_compra());	
		serieproductoAsignar.setfecha_entrega(serieproducto.getfecha_entrega());	
		serieproductoAsignar.setfecha_venta(serieproducto.getfecha_venta());	
		serieproductoAsignar.setdescripcion(serieproducto.getdescripcion());	
	}
	
	public static void inicializarSerieProducto(SerieProducto serieproducto) throws Exception {
		try {
				serieproducto.setId(0L);	
					
				serieproducto.setid_empresa(-1L);	
				serieproducto.setid_bodega(-1L);	
				serieproducto.setid_producto(-1L);	
				serieproducto.setcodigo(0.0);	
				serieproducto.setfecha_compra(new Date());	
				serieproducto.setfecha_entrega(new Date());	
				serieproducto.setfecha_venta(new Date());	
				serieproducto.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSerieProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SerieProductoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SerieProductoConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SerieProductoConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SerieProductoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SerieProductoConstantesFunciones.LABEL_FECHACOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SerieProductoConstantesFunciones.LABEL_FECHAENTREGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SerieProductoConstantesFunciones.LABEL_FECHAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SerieProductoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSerieProducto(String sTipo,Row row,Workbook workbook,SerieProducto serieproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(serieproducto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serieproducto.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serieproducto.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serieproducto.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serieproducto.getfecha_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serieproducto.getfecha_entrega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serieproducto.getfecha_venta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serieproducto.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySerieProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySerieProducto() {
		return this.sFinalQuerySerieProducto;
	}
	
	public void setsFinalQuerySerieProducto(String sFinalQuerySerieProducto) {
		this.sFinalQuerySerieProducto= sFinalQuerySerieProducto;
	}
	
	public Border resaltarSeleccionarSerieProducto=null;
	
	public Border setResaltarSeleccionarSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SerieProductoBeanSwingJInternalFrame serieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//serieproductoBeanSwingJInternalFrame.jTtoolBarSerieProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSerieProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSerieProducto() {
		return this.resaltarSeleccionarSerieProducto;
	}
	
	public void setResaltarSeleccionarSerieProducto(Border borderResaltarSeleccionarSerieProducto) {
		this.resaltarSeleccionarSerieProducto= borderResaltarSeleccionarSerieProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSerieProducto=null;
	public Boolean mostraridSerieProducto=true;
	public Boolean activaridSerieProducto=true;

	public Border resaltarid_empresaSerieProducto=null;
	public Boolean mostrarid_empresaSerieProducto=true;
	public Boolean activarid_empresaSerieProducto=true;
	public Boolean cargarid_empresaSerieProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSerieProducto=false;//ConEventDepend=true

	public Border resaltarid_bodegaSerieProducto=null;
	public Boolean mostrarid_bodegaSerieProducto=true;
	public Boolean activarid_bodegaSerieProducto=true;
	public Boolean cargarid_bodegaSerieProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaSerieProducto=false;//ConEventDepend=true

	public Border resaltarid_productoSerieProducto=null;
	public Boolean mostrarid_productoSerieProducto=true;
	public Boolean activarid_productoSerieProducto=true;
	public Boolean cargarid_productoSerieProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoSerieProducto=false;//ConEventDepend=true

	public Border resaltarcodigoSerieProducto=null;
	public Boolean mostrarcodigoSerieProducto=true;
	public Boolean activarcodigoSerieProducto=true;

	public Border resaltarfecha_compraSerieProducto=null;
	public Boolean mostrarfecha_compraSerieProducto=true;
	public Boolean activarfecha_compraSerieProducto=true;

	public Border resaltarfecha_entregaSerieProducto=null;
	public Boolean mostrarfecha_entregaSerieProducto=true;
	public Boolean activarfecha_entregaSerieProducto=true;

	public Border resaltarfecha_ventaSerieProducto=null;
	public Boolean mostrarfecha_ventaSerieProducto=true;
	public Boolean activarfecha_ventaSerieProducto=true;

	public Border resaltardescripcionSerieProducto=null;
	public Boolean mostrardescripcionSerieProducto=true;
	public Boolean activardescripcionSerieProducto=true;

	
	

	public Border setResaltaridSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SerieProductoBeanSwingJInternalFrame serieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serieproductoBeanSwingJInternalFrame.jTtoolBarSerieProducto.setBorder(borderResaltar);
		
		this.resaltaridSerieProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSerieProducto() {
		return this.resaltaridSerieProducto;
	}

	public void setResaltaridSerieProducto(Border borderResaltar) {
		this.resaltaridSerieProducto= borderResaltar;
	}

	public Boolean getMostraridSerieProducto() {
		return this.mostraridSerieProducto;
	}

	public void setMostraridSerieProducto(Boolean mostraridSerieProducto) {
		this.mostraridSerieProducto= mostraridSerieProducto;
	}

	public Boolean getActivaridSerieProducto() {
		return this.activaridSerieProducto;
	}

	public void setActivaridSerieProducto(Boolean activaridSerieProducto) {
		this.activaridSerieProducto= activaridSerieProducto;
	}

	public Border setResaltarid_empresaSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SerieProductoBeanSwingJInternalFrame serieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serieproductoBeanSwingJInternalFrame.jTtoolBarSerieProducto.setBorder(borderResaltar);
		
		this.resaltarid_empresaSerieProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSerieProducto() {
		return this.resaltarid_empresaSerieProducto;
	}

	public void setResaltarid_empresaSerieProducto(Border borderResaltar) {
		this.resaltarid_empresaSerieProducto= borderResaltar;
	}

	public Boolean getMostrarid_empresaSerieProducto() {
		return this.mostrarid_empresaSerieProducto;
	}

	public void setMostrarid_empresaSerieProducto(Boolean mostrarid_empresaSerieProducto) {
		this.mostrarid_empresaSerieProducto= mostrarid_empresaSerieProducto;
	}

	public Boolean getActivarid_empresaSerieProducto() {
		return this.activarid_empresaSerieProducto;
	}

	public void setActivarid_empresaSerieProducto(Boolean activarid_empresaSerieProducto) {
		this.activarid_empresaSerieProducto= activarid_empresaSerieProducto;
	}

	public Boolean getCargarid_empresaSerieProducto() {
		return this.cargarid_empresaSerieProducto;
	}

	public void setCargarid_empresaSerieProducto(Boolean cargarid_empresaSerieProducto) {
		this.cargarid_empresaSerieProducto= cargarid_empresaSerieProducto;
	}

	public Border setResaltarid_bodegaSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SerieProductoBeanSwingJInternalFrame serieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serieproductoBeanSwingJInternalFrame.jTtoolBarSerieProducto.setBorder(borderResaltar);
		
		this.resaltarid_bodegaSerieProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaSerieProducto() {
		return this.resaltarid_bodegaSerieProducto;
	}

	public void setResaltarid_bodegaSerieProducto(Border borderResaltar) {
		this.resaltarid_bodegaSerieProducto= borderResaltar;
	}

	public Boolean getMostrarid_bodegaSerieProducto() {
		return this.mostrarid_bodegaSerieProducto;
	}

	public void setMostrarid_bodegaSerieProducto(Boolean mostrarid_bodegaSerieProducto) {
		this.mostrarid_bodegaSerieProducto= mostrarid_bodegaSerieProducto;
	}

	public Boolean getActivarid_bodegaSerieProducto() {
		return this.activarid_bodegaSerieProducto;
	}

	public void setActivarid_bodegaSerieProducto(Boolean activarid_bodegaSerieProducto) {
		this.activarid_bodegaSerieProducto= activarid_bodegaSerieProducto;
	}

	public Boolean getCargarid_bodegaSerieProducto() {
		return this.cargarid_bodegaSerieProducto;
	}

	public void setCargarid_bodegaSerieProducto(Boolean cargarid_bodegaSerieProducto) {
		this.cargarid_bodegaSerieProducto= cargarid_bodegaSerieProducto;
	}

	public Border setResaltarid_productoSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SerieProductoBeanSwingJInternalFrame serieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serieproductoBeanSwingJInternalFrame.jTtoolBarSerieProducto.setBorder(borderResaltar);
		
		this.resaltarid_productoSerieProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoSerieProducto() {
		return this.resaltarid_productoSerieProducto;
	}

	public void setResaltarid_productoSerieProducto(Border borderResaltar) {
		this.resaltarid_productoSerieProducto= borderResaltar;
	}

	public Boolean getMostrarid_productoSerieProducto() {
		return this.mostrarid_productoSerieProducto;
	}

	public void setMostrarid_productoSerieProducto(Boolean mostrarid_productoSerieProducto) {
		this.mostrarid_productoSerieProducto= mostrarid_productoSerieProducto;
	}

	public Boolean getActivarid_productoSerieProducto() {
		return this.activarid_productoSerieProducto;
	}

	public void setActivarid_productoSerieProducto(Boolean activarid_productoSerieProducto) {
		this.activarid_productoSerieProducto= activarid_productoSerieProducto;
	}

	public Boolean getCargarid_productoSerieProducto() {
		return this.cargarid_productoSerieProducto;
	}

	public void setCargarid_productoSerieProducto(Boolean cargarid_productoSerieProducto) {
		this.cargarid_productoSerieProducto= cargarid_productoSerieProducto;
	}

	public Border setResaltarcodigoSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SerieProductoBeanSwingJInternalFrame serieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serieproductoBeanSwingJInternalFrame.jTtoolBarSerieProducto.setBorder(borderResaltar);
		
		this.resaltarcodigoSerieProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoSerieProducto() {
		return this.resaltarcodigoSerieProducto;
	}

	public void setResaltarcodigoSerieProducto(Border borderResaltar) {
		this.resaltarcodigoSerieProducto= borderResaltar;
	}

	public Boolean getMostrarcodigoSerieProducto() {
		return this.mostrarcodigoSerieProducto;
	}

	public void setMostrarcodigoSerieProducto(Boolean mostrarcodigoSerieProducto) {
		this.mostrarcodigoSerieProducto= mostrarcodigoSerieProducto;
	}

	public Boolean getActivarcodigoSerieProducto() {
		return this.activarcodigoSerieProducto;
	}

	public void setActivarcodigoSerieProducto(Boolean activarcodigoSerieProducto) {
		this.activarcodigoSerieProducto= activarcodigoSerieProducto;
	}

	public Border setResaltarfecha_compraSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SerieProductoBeanSwingJInternalFrame serieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serieproductoBeanSwingJInternalFrame.jTtoolBarSerieProducto.setBorder(borderResaltar);
		
		this.resaltarfecha_compraSerieProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_compraSerieProducto() {
		return this.resaltarfecha_compraSerieProducto;
	}

	public void setResaltarfecha_compraSerieProducto(Border borderResaltar) {
		this.resaltarfecha_compraSerieProducto= borderResaltar;
	}

	public Boolean getMostrarfecha_compraSerieProducto() {
		return this.mostrarfecha_compraSerieProducto;
	}

	public void setMostrarfecha_compraSerieProducto(Boolean mostrarfecha_compraSerieProducto) {
		this.mostrarfecha_compraSerieProducto= mostrarfecha_compraSerieProducto;
	}

	public Boolean getActivarfecha_compraSerieProducto() {
		return this.activarfecha_compraSerieProducto;
	}

	public void setActivarfecha_compraSerieProducto(Boolean activarfecha_compraSerieProducto) {
		this.activarfecha_compraSerieProducto= activarfecha_compraSerieProducto;
	}

	public Border setResaltarfecha_entregaSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SerieProductoBeanSwingJInternalFrame serieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serieproductoBeanSwingJInternalFrame.jTtoolBarSerieProducto.setBorder(borderResaltar);
		
		this.resaltarfecha_entregaSerieProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_entregaSerieProducto() {
		return this.resaltarfecha_entregaSerieProducto;
	}

	public void setResaltarfecha_entregaSerieProducto(Border borderResaltar) {
		this.resaltarfecha_entregaSerieProducto= borderResaltar;
	}

	public Boolean getMostrarfecha_entregaSerieProducto() {
		return this.mostrarfecha_entregaSerieProducto;
	}

	public void setMostrarfecha_entregaSerieProducto(Boolean mostrarfecha_entregaSerieProducto) {
		this.mostrarfecha_entregaSerieProducto= mostrarfecha_entregaSerieProducto;
	}

	public Boolean getActivarfecha_entregaSerieProducto() {
		return this.activarfecha_entregaSerieProducto;
	}

	public void setActivarfecha_entregaSerieProducto(Boolean activarfecha_entregaSerieProducto) {
		this.activarfecha_entregaSerieProducto= activarfecha_entregaSerieProducto;
	}

	public Border setResaltarfecha_ventaSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SerieProductoBeanSwingJInternalFrame serieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serieproductoBeanSwingJInternalFrame.jTtoolBarSerieProducto.setBorder(borderResaltar);
		
		this.resaltarfecha_ventaSerieProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ventaSerieProducto() {
		return this.resaltarfecha_ventaSerieProducto;
	}

	public void setResaltarfecha_ventaSerieProducto(Border borderResaltar) {
		this.resaltarfecha_ventaSerieProducto= borderResaltar;
	}

	public Boolean getMostrarfecha_ventaSerieProducto() {
		return this.mostrarfecha_ventaSerieProducto;
	}

	public void setMostrarfecha_ventaSerieProducto(Boolean mostrarfecha_ventaSerieProducto) {
		this.mostrarfecha_ventaSerieProducto= mostrarfecha_ventaSerieProducto;
	}

	public Boolean getActivarfecha_ventaSerieProducto() {
		return this.activarfecha_ventaSerieProducto;
	}

	public void setActivarfecha_ventaSerieProducto(Boolean activarfecha_ventaSerieProducto) {
		this.activarfecha_ventaSerieProducto= activarfecha_ventaSerieProducto;
	}

	public Border setResaltardescripcionSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SerieProductoBeanSwingJInternalFrame serieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serieproductoBeanSwingJInternalFrame.jTtoolBarSerieProducto.setBorder(borderResaltar);
		
		this.resaltardescripcionSerieProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionSerieProducto() {
		return this.resaltardescripcionSerieProducto;
	}

	public void setResaltardescripcionSerieProducto(Border borderResaltar) {
		this.resaltardescripcionSerieProducto= borderResaltar;
	}

	public Boolean getMostrardescripcionSerieProducto() {
		return this.mostrardescripcionSerieProducto;
	}

	public void setMostrardescripcionSerieProducto(Boolean mostrardescripcionSerieProducto) {
		this.mostrardescripcionSerieProducto= mostrardescripcionSerieProducto;
	}

	public Boolean getActivardescripcionSerieProducto() {
		return this.activardescripcionSerieProducto;
	}

	public void setActivardescripcionSerieProducto(Boolean activardescripcionSerieProducto) {
		this.activardescripcionSerieProducto= activardescripcionSerieProducto;
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
		
		
		this.setMostraridSerieProducto(esInicial);
		this.setMostrarid_empresaSerieProducto(esInicial);
		this.setMostrarid_bodegaSerieProducto(esInicial);
		this.setMostrarid_productoSerieProducto(esInicial);
		this.setMostrarcodigoSerieProducto(esInicial);
		this.setMostrarfecha_compraSerieProducto(esInicial);
		this.setMostrarfecha_entregaSerieProducto(esInicial);
		this.setMostrarfecha_ventaSerieProducto(esInicial);
		this.setMostrardescripcionSerieProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SerieProductoConstantesFunciones.ID)) {
				this.setMostraridSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.FECHACOMPRA)) {
				this.setMostrarfecha_compraSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.FECHAENTREGA)) {
				this.setMostrarfecha_entregaSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.FECHAVENTA)) {
				this.setMostrarfecha_ventaSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionSerieProducto(esAsigna);
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
		
		
		this.setActivaridSerieProducto(esInicial);
		this.setActivarid_empresaSerieProducto(esInicial);
		this.setActivarid_bodegaSerieProducto(esInicial);
		this.setActivarid_productoSerieProducto(esInicial);
		this.setActivarcodigoSerieProducto(esInicial);
		this.setActivarfecha_compraSerieProducto(esInicial);
		this.setActivarfecha_entregaSerieProducto(esInicial);
		this.setActivarfecha_ventaSerieProducto(esInicial);
		this.setActivardescripcionSerieProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SerieProductoConstantesFunciones.ID)) {
				this.setActivaridSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.FECHACOMPRA)) {
				this.setActivarfecha_compraSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.FECHAENTREGA)) {
				this.setActivarfecha_entregaSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.FECHAVENTA)) {
				this.setActivarfecha_ventaSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionSerieProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SerieProductoBeanSwingJInternalFrame serieproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSerieProducto(esInicial);
		this.setResaltarid_empresaSerieProducto(esInicial);
		this.setResaltarid_bodegaSerieProducto(esInicial);
		this.setResaltarid_productoSerieProducto(esInicial);
		this.setResaltarcodigoSerieProducto(esInicial);
		this.setResaltarfecha_compraSerieProducto(esInicial);
		this.setResaltarfecha_entregaSerieProducto(esInicial);
		this.setResaltarfecha_ventaSerieProducto(esInicial);
		this.setResaltardescripcionSerieProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SerieProductoConstantesFunciones.ID)) {
				this.setResaltaridSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.FECHACOMPRA)) {
				this.setResaltarfecha_compraSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.FECHAENTREGA)) {
				this.setResaltarfecha_entregaSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.FECHAVENTA)) {
				this.setResaltarfecha_ventaSerieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SerieProductoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionSerieProducto(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleSerieProductoSerieProducto=null;

	public Border getResaltarDetalleSerieProductoSerieProducto() {
		return this.resaltarDetalleSerieProductoSerieProducto;
	}

	public void setResaltarDetalleSerieProductoSerieProducto(Border borderResaltarDetalleSerieProducto) {
		if(borderResaltarDetalleSerieProducto!=null) {
			this.resaltarDetalleSerieProductoSerieProducto= borderResaltarDetalleSerieProducto;
		}
	}

	public Border setResaltarDetalleSerieProductoSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SerieProductoBeanSwingJInternalFrame serieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleSerieProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//serieproductoBeanSwingJInternalFrame.jTtoolBarSerieProducto.setBorder(borderResaltarDetalleSerieProducto);
			
		this.resaltarDetalleSerieProductoSerieProducto= borderResaltarDetalleSerieProducto;

		 return borderResaltarDetalleSerieProducto;
	}



	public Boolean mostrarDetalleSerieProductoSerieProducto=true;

	public Boolean getMostrarDetalleSerieProductoSerieProducto() {
		return this.mostrarDetalleSerieProductoSerieProducto;
	}

	public void setMostrarDetalleSerieProductoSerieProducto(Boolean visibilidadResaltarDetalleSerieProducto) {
		this.mostrarDetalleSerieProductoSerieProducto= visibilidadResaltarDetalleSerieProducto;
	}



	public Boolean activarDetalleSerieProductoSerieProducto=true;

	public Boolean gethabilitarResaltarDetalleSerieProductoSerieProducto() {
		return this.activarDetalleSerieProductoSerieProducto;
	}

	public void setActivarDetalleSerieProductoSerieProducto(Boolean habilitarResaltarDetalleSerieProducto) {
		this.activarDetalleSerieProductoSerieProducto= habilitarResaltarDetalleSerieProducto;
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

		this.setMostrarDetalleSerieProductoSerieProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleSerieProducto.class)) {
				this.setMostrarDetalleSerieProductoSerieProducto(esAsigna);
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

		this.setActivarDetalleSerieProductoSerieProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleSerieProducto.class)) {
				this.setActivarDetalleSerieProductoSerieProducto(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SerieProductoBeanSwingJInternalFrame serieproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleSerieProductoSerieProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleSerieProducto.class)) {
				this.setResaltarDetalleSerieProductoSerieProducto(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoSerieProducto=true;

	public Boolean getMostrarBusquedaPorCodigoSerieProducto() {
		return this.mostrarBusquedaPorCodigoSerieProducto;
	}

	public void setMostrarBusquedaPorCodigoSerieProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoSerieProducto= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorFechaCompraSerieProducto=true;

	public Boolean getMostrarBusquedaPorFechaCompraSerieProducto() {
		return this.mostrarBusquedaPorFechaCompraSerieProducto;
	}

	public void setMostrarBusquedaPorFechaCompraSerieProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorFechaCompraSerieProducto= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorFechaEntregaSerieProducto=true;

	public Boolean getMostrarBusquedaPorFechaEntregaSerieProducto() {
		return this.mostrarBusquedaPorFechaEntregaSerieProducto;
	}

	public void setMostrarBusquedaPorFechaEntregaSerieProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorFechaEntregaSerieProducto= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorFechaVentaSerieProducto=true;

	public Boolean getMostrarBusquedaPorFechaVentaSerieProducto() {
		return this.mostrarBusquedaPorFechaVentaSerieProducto;
	}

	public void setMostrarBusquedaPorFechaVentaSerieProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorFechaVentaSerieProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBodegaSerieProducto=true;

	public Boolean getMostrarFK_IdBodegaSerieProducto() {
		return this.mostrarFK_IdBodegaSerieProducto;
	}

	public void setMostrarFK_IdBodegaSerieProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaSerieProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaSerieProducto=true;

	public Boolean getMostrarFK_IdEmpresaSerieProducto() {
		return this.mostrarFK_IdEmpresaSerieProducto;
	}

	public void setMostrarFK_IdEmpresaSerieProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaSerieProducto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoSerieProducto=true;

	public Boolean getActivarBusquedaPorCodigoSerieProducto() {
		return this.activarBusquedaPorCodigoSerieProducto;
	}

	public void setActivarBusquedaPorCodigoSerieProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoSerieProducto= habilitarResaltar;
	}

	public Boolean activarBusquedaPorFechaCompraSerieProducto=true;

	public Boolean getActivarBusquedaPorFechaCompraSerieProducto() {
		return this.activarBusquedaPorFechaCompraSerieProducto;
	}

	public void setActivarBusquedaPorFechaCompraSerieProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorFechaCompraSerieProducto= habilitarResaltar;
	}

	public Boolean activarBusquedaPorFechaEntregaSerieProducto=true;

	public Boolean getActivarBusquedaPorFechaEntregaSerieProducto() {
		return this.activarBusquedaPorFechaEntregaSerieProducto;
	}

	public void setActivarBusquedaPorFechaEntregaSerieProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorFechaEntregaSerieProducto= habilitarResaltar;
	}

	public Boolean activarBusquedaPorFechaVentaSerieProducto=true;

	public Boolean getActivarBusquedaPorFechaVentaSerieProducto() {
		return this.activarBusquedaPorFechaVentaSerieProducto;
	}

	public void setActivarBusquedaPorFechaVentaSerieProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorFechaVentaSerieProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdBodegaSerieProducto=true;

	public Boolean getActivarFK_IdBodegaSerieProducto() {
		return this.activarFK_IdBodegaSerieProducto;
	}

	public void setActivarFK_IdBodegaSerieProducto(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaSerieProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaSerieProducto=true;

	public Boolean getActivarFK_IdEmpresaSerieProducto() {
		return this.activarFK_IdEmpresaSerieProducto;
	}

	public void setActivarFK_IdEmpresaSerieProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaSerieProducto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoSerieProducto=null;

	public Border getResaltarBusquedaPorCodigoSerieProducto() {
		return this.resaltarBusquedaPorCodigoSerieProducto;
	}

	public void setResaltarBusquedaPorCodigoSerieProducto(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoSerieProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SerieProductoBeanSwingJInternalFrame serieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoSerieProducto= borderResaltar;
	}

	public Border resaltarBusquedaPorFechaCompraSerieProducto=null;

	public Border getResaltarBusquedaPorFechaCompraSerieProducto() {
		return this.resaltarBusquedaPorFechaCompraSerieProducto;
	}

	public void setResaltarBusquedaPorFechaCompraSerieProducto(Border borderResaltar) {
		this.resaltarBusquedaPorFechaCompraSerieProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorFechaCompraSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SerieProductoBeanSwingJInternalFrame serieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorFechaCompraSerieProducto= borderResaltar;
	}

	public Border resaltarBusquedaPorFechaEntregaSerieProducto=null;

	public Border getResaltarBusquedaPorFechaEntregaSerieProducto() {
		return this.resaltarBusquedaPorFechaEntregaSerieProducto;
	}

	public void setResaltarBusquedaPorFechaEntregaSerieProducto(Border borderResaltar) {
		this.resaltarBusquedaPorFechaEntregaSerieProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorFechaEntregaSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SerieProductoBeanSwingJInternalFrame serieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorFechaEntregaSerieProducto= borderResaltar;
	}

	public Border resaltarBusquedaPorFechaVentaSerieProducto=null;

	public Border getResaltarBusquedaPorFechaVentaSerieProducto() {
		return this.resaltarBusquedaPorFechaVentaSerieProducto;
	}

	public void setResaltarBusquedaPorFechaVentaSerieProducto(Border borderResaltar) {
		this.resaltarBusquedaPorFechaVentaSerieProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorFechaVentaSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SerieProductoBeanSwingJInternalFrame serieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorFechaVentaSerieProducto= borderResaltar;
	}

	public Border resaltarFK_IdBodegaSerieProducto=null;

	public Border getResaltarFK_IdBodegaSerieProducto() {
		return this.resaltarFK_IdBodegaSerieProducto;
	}

	public void setResaltarFK_IdBodegaSerieProducto(Border borderResaltar) {
		this.resaltarFK_IdBodegaSerieProducto= borderResaltar;
	}

	public void setResaltarFK_IdBodegaSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SerieProductoBeanSwingJInternalFrame serieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaSerieProducto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaSerieProducto=null;

	public Border getResaltarFK_IdEmpresaSerieProducto() {
		return this.resaltarFK_IdEmpresaSerieProducto;
	}

	public void setResaltarFK_IdEmpresaSerieProducto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaSerieProducto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaSerieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SerieProductoBeanSwingJInternalFrame serieproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaSerieProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}