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
package com.bydan.erp.puntoventa.util.report;

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


import com.bydan.erp.puntoventa.util.report.ProductosConstantesFunciones;
import com.bydan.erp.puntoventa.util.report.ProductosParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.ProductosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProductosConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="Productos";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Productos"+ProductosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductosConstantesFunciones.SCHEMA+"_"+ProductosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductosConstantesFunciones.SCHEMA+"_"+ProductosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductosConstantesFunciones.SCHEMA+"_"+ProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductosConstantesFunciones.SCHEMA+"_"+ProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Productoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Productos";
	public static final String SCLASSWEBTITULO_LOWER="Productos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Productos";
	public static final String OBJECTNAME="productos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="productos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productos from "+ProductosConstantesFunciones.SPERSISTENCENAME+" productos";
	public static String QUERYSELECTNATIVE="select "+ProductosConstantesFunciones.SCHEMA+"."+ProductosConstantesFunciones.TABLENAME+".id,"+ProductosConstantesFunciones.SCHEMA+"."+ProductosConstantesFunciones.TABLENAME+".version_row,"+ProductosConstantesFunciones.SCHEMA+"."+ProductosConstantesFunciones.TABLENAME+".id_empresa,"+ProductosConstantesFunciones.SCHEMA+"."+ProductosConstantesFunciones.TABLENAME+".id_sucursal,"+ProductosConstantesFunciones.SCHEMA+"."+ProductosConstantesFunciones.TABLENAME+".id_producto,"+ProductosConstantesFunciones.SCHEMA+"."+ProductosConstantesFunciones.TABLENAME+".fecha_inicio,"+ProductosConstantesFunciones.SCHEMA+"."+ProductosConstantesFunciones.TABLENAME+".fecha_fin,"+ProductosConstantesFunciones.SCHEMA+"."+ProductosConstantesFunciones.TABLENAME+".nombre_producto,"+ProductosConstantesFunciones.SCHEMA+"."+ProductosConstantesFunciones.TABLENAME+".fecha,"+ProductosConstantesFunciones.SCHEMA+"."+ProductosConstantesFunciones.TABLENAME+".cantidad from "+ProductosConstantesFunciones.SCHEMA+"."+ProductosConstantesFunciones.TABLENAME;//+" as "+ProductosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDPRODUCTO= "id_producto";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String FECHA= "fecha";
    public static final String CANTIDAD= "cantidad";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_CANTIDAD= "Cantad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
	
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getProductosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductosConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProductosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProductosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProductosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProductosConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProductosConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProductosConstantesFunciones.FECHAINICIO)) {sLabelColumna=ProductosConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(ProductosConstantesFunciones.FECHAFIN)) {sLabelColumna=ProductosConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(ProductosConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=ProductosConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(ProductosConstantesFunciones.FECHA)) {sLabelColumna=ProductosConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ProductosConstantesFunciones.CANTIDAD)) {sLabelColumna=ProductosConstantesFunciones.LABEL_CANTIDAD;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
	
	public static String getProductosDescripcion(Productos productos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productos !=null/* && productos.getId()!=0*/) {
			if(productos.getId()!=null) {
				sDescripcion=productos.getId().toString();
			}//productosproductos.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductosDescripcionDetallado(Productos productos) {
		String sDescripcion="";
			
		sDescripcion+=ProductosConstantesFunciones.ID+"=";
		sDescripcion+=productos.getId().toString()+",";
		sDescripcion+=ProductosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productos.getVersionRow().toString()+",";
		sDescripcion+=ProductosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=productos.getid_empresa().toString()+",";
		sDescripcion+=ProductosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=productos.getid_sucursal().toString()+",";
		sDescripcion+=ProductosConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=productos.getid_producto().toString()+",";
		sDescripcion+=ProductosConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=productos.getfecha_inicio().toString()+",";
		sDescripcion+=ProductosConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=productos.getfecha_fin().toString()+",";
		sDescripcion+=ProductosConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=productos.getnombre_producto()+",";
		sDescripcion+=ProductosConstantesFunciones.FECHA+"=";
		sDescripcion+=productos.getfecha().toString()+",";
		sDescripcion+=ProductosConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=productos.getcantidad().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProductosDescripcion(Productos productos,String sValor) throws Exception {			
		if(productos !=null) {
			//productosproductos.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
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
		} else if(sNombreIndice.equals("BusquedaProductos")) {
			sNombreIndice="Tipo=  Por Fecha Inicio Por Fecha Fin";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProductos(Date fecha_inicio,Date fecha_fin) {
		String sDetalleIndice=" Parametros->";
		if(fecha_inicio!=null) {sDetalleIndice+=" Fecha Inicio="+fecha_inicio.toString();}
		if(fecha_fin!=null) {sDetalleIndice+=" Fecha Fin="+fecha_fin.toString();} 

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

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProductos(Productos productos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productos.setnombre_producto(productos.getnombre_producto().trim());
	}
	
	public static void quitarEspaciosProductoss(List<Productos> productoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Productos productos: productoss) {
			productos.setnombre_producto(productos.getnombre_producto().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductos(Productos productos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productos.getConCambioAuxiliar()) {
			productos.setIsDeleted(productos.getIsDeletedAuxiliar());	
			productos.setIsNew(productos.getIsNewAuxiliar());	
			productos.setIsChanged(productos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productos.setIsDeletedAuxiliar(false);	
			productos.setIsNewAuxiliar(false);	
			productos.setIsChangedAuxiliar(false);
			
			productos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoss(List<Productos> productoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Productos productos : productoss) {
			if(conAsignarBase && productos.getConCambioAuxiliar()) {
				productos.setIsDeleted(productos.getIsDeletedAuxiliar());	
				productos.setIsNew(productos.getIsNewAuxiliar());	
				productos.setIsChanged(productos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productos.setIsDeletedAuxiliar(false);	
				productos.setIsNewAuxiliar(false);	
				productos.setIsChangedAuxiliar(false);
				
				productos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductos(Productos productos,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			productos.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresProductoss(List<Productos> productoss,Boolean conEnteros) throws Exception  {
		
		for(Productos productos: productoss) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				productos.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductos(List<Productos> productoss,Productos productosAux) throws Exception  {
		ProductosConstantesFunciones.InicializarValoresProductos(productosAux,true);
		
		for(Productos productos: productoss) {
			if(productos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productosAux.setcantidad(productosAux.getcantidad()+productos.getcantidad());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductosConstantesFunciones.getArrayColumnasGlobalesProductos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductosConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Productos> productoss,Productos productos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Productos productosAux: productoss) {
			if(productosAux!=null && productos!=null) {
				if((productosAux.getId()==null && productos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productosAux.getId()!=null && productos.getId()!=null){
					if(productosAux.getId().equals(productos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductos(List<Productos> productoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Productos productos: productoss) {			
			if(productos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductosConstantesFunciones.LABEL_ID, ProductosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosConstantesFunciones.LABEL_VERSIONROW, ProductosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosConstantesFunciones.LABEL_IDPRODUCTO, ProductosConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosConstantesFunciones.LABEL_NOMBREPRODUCTO, ProductosConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosConstantesFunciones.LABEL_FECHA, ProductosConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosConstantesFunciones.LABEL_CANTIDAD, ProductosConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductos() throws Exception  {
		return ProductosConstantesFunciones.getTiposSeleccionarProductos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductos(Boolean conFk) throws Exception  {
		return ProductosConstantesFunciones.getTiposSeleccionarProductos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProductosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProductosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProductosConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(ProductosConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(ProductosConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(ProductosConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ProductosConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(ProductosConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductos(Productos productosAux) throws Exception {
		
			productosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productosAux.getEmpresa()));
			productosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productosAux.getSucursal()));
			productosAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productosAux.getProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductos(List<Productos> productossTemp) throws Exception {
		for(Productos productosAux:productossTemp) {
			
			productosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productosAux.getEmpresa()));
			productosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productosAux.getSucursal()));
			productosAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productosAux.getProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Producto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductosConstantesFunciones.getClassesRelationshipsOfProductos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductosConstantesFunciones.getClassesRelationshipsFromStringsOfProductos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Productos productos,List<Productos> productoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(Productos productos,List<Productos> productoss) throws Exception {
		try	{			
			for(Productos productosLocal:productoss) {
				if(productosLocal.getId().equals(productos.getId())) {
					productosLocal.setIsSelected(productos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductos(List<Productos> productossAux) throws Exception {
		//this.productossAux=productossAux;
		
		for(Productos productosAux:productossAux) {
			if(productosAux.getIsChanged()) {
				productosAux.setIsChanged(false);
			}		
			
			if(productosAux.getIsNew()) {
				productosAux.setIsNew(false);
			}	
			
			if(productosAux.getIsDeleted()) {
				productosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductos(Productos productosAux) throws Exception {
		//this.productosAux=productosAux;
		
			if(productosAux.getIsChanged()) {
				productosAux.setIsChanged(false);
			}		
			
			if(productosAux.getIsNew()) {
				productosAux.setIsNew(false);
			}	
			
			if(productosAux.getIsDeleted()) {
				productosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Productos productosAsignar,Productos productos) throws Exception {
		productosAsignar.setId(productos.getId());	
		productosAsignar.setVersionRow(productos.getVersionRow());	
		productosAsignar.setid_producto(productos.getid_producto());
		productosAsignar.setproducto_descripcion(productos.getproducto_descripcion());	
		productosAsignar.setnombre_producto(productos.getnombre_producto());	
		productosAsignar.setfecha(productos.getfecha());	
		productosAsignar.setcantidad(productos.getcantidad());	
	}
	
	public static void inicializarProductos(Productos productos) throws Exception {
		try {
				productos.setId(0L);	
					
				productos.setid_producto(-1L);	
				productos.setnombre_producto("");	
				productos.setfecha(new Date());	
				productos.setcantidad(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductos(String sTipo,Row row,Workbook workbook,Productos productos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productos.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productos.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productos.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productos.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productos.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productos.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductos="";
	
	public String getsFinalQueryProductos() {
		return this.sFinalQueryProductos;
	}
	
	public void setsFinalQueryProductos(String sFinalQueryProductos) {
		this.sFinalQueryProductos= sFinalQueryProductos;
	}
	
	public Border resaltarSeleccionarProductos=null;
	
	public Border setResaltarSeleccionarProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBeanSwingJInternalFrame productosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productosBeanSwingJInternalFrame.jTtoolBarProductos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductos() {
		return this.resaltarSeleccionarProductos;
	}
	
	public void setResaltarSeleccionarProductos(Border borderResaltarSeleccionarProductos) {
		this.resaltarSeleccionarProductos= borderResaltarSeleccionarProductos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductos=null;
	public Boolean mostraridProductos=true;
	public Boolean activaridProductos=true;

	public Border resaltarid_empresaProductos=null;
	public Boolean mostrarid_empresaProductos=true;
	public Boolean activarid_empresaProductos=true;
	public Boolean cargarid_empresaProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProductos=false;//ConEventDepend=true

	public Border resaltarid_sucursalProductos=null;
	public Boolean mostrarid_sucursalProductos=true;
	public Boolean activarid_sucursalProductos=true;
	public Boolean cargarid_sucursalProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProductos=false;//ConEventDepend=true

	public Border resaltarid_productoProductos=null;
	public Boolean mostrarid_productoProductos=true;
	public Boolean activarid_productoProductos=false;
	public Boolean cargarid_productoProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProductos=false;//ConEventDepend=true

	public Border resaltarfecha_inicioProductos=null;
	public Boolean mostrarfecha_inicioProductos=true;
	public Boolean activarfecha_inicioProductos=true;

	public Border resaltarfecha_finProductos=null;
	public Boolean mostrarfecha_finProductos=true;
	public Boolean activarfecha_finProductos=true;

	public Border resaltarnombre_productoProductos=null;
	public Boolean mostrarnombre_productoProductos=true;
	public Boolean activarnombre_productoProductos=true;

	public Border resaltarfechaProductos=null;
	public Boolean mostrarfechaProductos=true;
	public Boolean activarfechaProductos=true;

	public Border resaltarcantidadProductos=null;
	public Boolean mostrarcantidadProductos=true;
	public Boolean activarcantidadProductos=true;

	
	

	public Border setResaltaridProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBeanSwingJInternalFrame productosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosBeanSwingJInternalFrame.jTtoolBarProductos.setBorder(borderResaltar);
		
		this.resaltaridProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductos() {
		return this.resaltaridProductos;
	}

	public void setResaltaridProductos(Border borderResaltar) {
		this.resaltaridProductos= borderResaltar;
	}

	public Boolean getMostraridProductos() {
		return this.mostraridProductos;
	}

	public void setMostraridProductos(Boolean mostraridProductos) {
		this.mostraridProductos= mostraridProductos;
	}

	public Boolean getActivaridProductos() {
		return this.activaridProductos;
	}

	public void setActivaridProductos(Boolean activaridProductos) {
		this.activaridProductos= activaridProductos;
	}

	public Border setResaltarid_empresaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBeanSwingJInternalFrame productosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosBeanSwingJInternalFrame.jTtoolBarProductos.setBorder(borderResaltar);
		
		this.resaltarid_empresaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProductos() {
		return this.resaltarid_empresaProductos;
	}

	public void setResaltarid_empresaProductos(Border borderResaltar) {
		this.resaltarid_empresaProductos= borderResaltar;
	}

	public Boolean getMostrarid_empresaProductos() {
		return this.mostrarid_empresaProductos;
	}

	public void setMostrarid_empresaProductos(Boolean mostrarid_empresaProductos) {
		this.mostrarid_empresaProductos= mostrarid_empresaProductos;
	}

	public Boolean getActivarid_empresaProductos() {
		return this.activarid_empresaProductos;
	}

	public void setActivarid_empresaProductos(Boolean activarid_empresaProductos) {
		this.activarid_empresaProductos= activarid_empresaProductos;
	}

	public Boolean getCargarid_empresaProductos() {
		return this.cargarid_empresaProductos;
	}

	public void setCargarid_empresaProductos(Boolean cargarid_empresaProductos) {
		this.cargarid_empresaProductos= cargarid_empresaProductos;
	}

	public Border setResaltarid_sucursalProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBeanSwingJInternalFrame productosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosBeanSwingJInternalFrame.jTtoolBarProductos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProductos() {
		return this.resaltarid_sucursalProductos;
	}

	public void setResaltarid_sucursalProductos(Border borderResaltar) {
		this.resaltarid_sucursalProductos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProductos() {
		return this.mostrarid_sucursalProductos;
	}

	public void setMostrarid_sucursalProductos(Boolean mostrarid_sucursalProductos) {
		this.mostrarid_sucursalProductos= mostrarid_sucursalProductos;
	}

	public Boolean getActivarid_sucursalProductos() {
		return this.activarid_sucursalProductos;
	}

	public void setActivarid_sucursalProductos(Boolean activarid_sucursalProductos) {
		this.activarid_sucursalProductos= activarid_sucursalProductos;
	}

	public Boolean getCargarid_sucursalProductos() {
		return this.cargarid_sucursalProductos;
	}

	public void setCargarid_sucursalProductos(Boolean cargarid_sucursalProductos) {
		this.cargarid_sucursalProductos= cargarid_sucursalProductos;
	}

	public Border setResaltarid_productoProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBeanSwingJInternalFrame productosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosBeanSwingJInternalFrame.jTtoolBarProductos.setBorder(borderResaltar);
		
		this.resaltarid_productoProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProductos() {
		return this.resaltarid_productoProductos;
	}

	public void setResaltarid_productoProductos(Border borderResaltar) {
		this.resaltarid_productoProductos= borderResaltar;
	}

	public Boolean getMostrarid_productoProductos() {
		return this.mostrarid_productoProductos;
	}

	public void setMostrarid_productoProductos(Boolean mostrarid_productoProductos) {
		this.mostrarid_productoProductos= mostrarid_productoProductos;
	}

	public Boolean getActivarid_productoProductos() {
		return this.activarid_productoProductos;
	}

	public void setActivarid_productoProductos(Boolean activarid_productoProductos) {
		this.activarid_productoProductos= activarid_productoProductos;
	}

	public Boolean getCargarid_productoProductos() {
		return this.cargarid_productoProductos;
	}

	public void setCargarid_productoProductos(Boolean cargarid_productoProductos) {
		this.cargarid_productoProductos= cargarid_productoProductos;
	}

	public Border setResaltarfecha_inicioProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBeanSwingJInternalFrame productosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosBeanSwingJInternalFrame.jTtoolBarProductos.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioProductos() {
		return this.resaltarfecha_inicioProductos;
	}

	public void setResaltarfecha_inicioProductos(Border borderResaltar) {
		this.resaltarfecha_inicioProductos= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioProductos() {
		return this.mostrarfecha_inicioProductos;
	}

	public void setMostrarfecha_inicioProductos(Boolean mostrarfecha_inicioProductos) {
		this.mostrarfecha_inicioProductos= mostrarfecha_inicioProductos;
	}

	public Boolean getActivarfecha_inicioProductos() {
		return this.activarfecha_inicioProductos;
	}

	public void setActivarfecha_inicioProductos(Boolean activarfecha_inicioProductos) {
		this.activarfecha_inicioProductos= activarfecha_inicioProductos;
	}

	public Border setResaltarfecha_finProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBeanSwingJInternalFrame productosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosBeanSwingJInternalFrame.jTtoolBarProductos.setBorder(borderResaltar);
		
		this.resaltarfecha_finProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finProductos() {
		return this.resaltarfecha_finProductos;
	}

	public void setResaltarfecha_finProductos(Border borderResaltar) {
		this.resaltarfecha_finProductos= borderResaltar;
	}

	public Boolean getMostrarfecha_finProductos() {
		return this.mostrarfecha_finProductos;
	}

	public void setMostrarfecha_finProductos(Boolean mostrarfecha_finProductos) {
		this.mostrarfecha_finProductos= mostrarfecha_finProductos;
	}

	public Boolean getActivarfecha_finProductos() {
		return this.activarfecha_finProductos;
	}

	public void setActivarfecha_finProductos(Boolean activarfecha_finProductos) {
		this.activarfecha_finProductos= activarfecha_finProductos;
	}

	public Border setResaltarnombre_productoProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBeanSwingJInternalFrame productosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosBeanSwingJInternalFrame.jTtoolBarProductos.setBorder(borderResaltar);
		
		this.resaltarnombre_productoProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoProductos() {
		return this.resaltarnombre_productoProductos;
	}

	public void setResaltarnombre_productoProductos(Border borderResaltar) {
		this.resaltarnombre_productoProductos= borderResaltar;
	}

	public Boolean getMostrarnombre_productoProductos() {
		return this.mostrarnombre_productoProductos;
	}

	public void setMostrarnombre_productoProductos(Boolean mostrarnombre_productoProductos) {
		this.mostrarnombre_productoProductos= mostrarnombre_productoProductos;
	}

	public Boolean getActivarnombre_productoProductos() {
		return this.activarnombre_productoProductos;
	}

	public void setActivarnombre_productoProductos(Boolean activarnombre_productoProductos) {
		this.activarnombre_productoProductos= activarnombre_productoProductos;
	}

	public Border setResaltarfechaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBeanSwingJInternalFrame productosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosBeanSwingJInternalFrame.jTtoolBarProductos.setBorder(borderResaltar);
		
		this.resaltarfechaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaProductos() {
		return this.resaltarfechaProductos;
	}

	public void setResaltarfechaProductos(Border borderResaltar) {
		this.resaltarfechaProductos= borderResaltar;
	}

	public Boolean getMostrarfechaProductos() {
		return this.mostrarfechaProductos;
	}

	public void setMostrarfechaProductos(Boolean mostrarfechaProductos) {
		this.mostrarfechaProductos= mostrarfechaProductos;
	}

	public Boolean getActivarfechaProductos() {
		return this.activarfechaProductos;
	}

	public void setActivarfechaProductos(Boolean activarfechaProductos) {
		this.activarfechaProductos= activarfechaProductos;
	}

	public Border setResaltarcantidadProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBeanSwingJInternalFrame productosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosBeanSwingJInternalFrame.jTtoolBarProductos.setBorder(borderResaltar);
		
		this.resaltarcantidadProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadProductos() {
		return this.resaltarcantidadProductos;
	}

	public void setResaltarcantidadProductos(Border borderResaltar) {
		this.resaltarcantidadProductos= borderResaltar;
	}

	public Boolean getMostrarcantidadProductos() {
		return this.mostrarcantidadProductos;
	}

	public void setMostrarcantidadProductos(Boolean mostrarcantidadProductos) {
		this.mostrarcantidadProductos= mostrarcantidadProductos;
	}

	public Boolean getActivarcantidadProductos() {
		return this.activarcantidadProductos;
	}

	public void setActivarcantidadProductos(Boolean activarcantidadProductos) {
		this.activarcantidadProductos= activarcantidadProductos;
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
		
		
		this.setMostraridProductos(esInicial);
		this.setMostrarid_empresaProductos(esInicial);
		this.setMostrarid_sucursalProductos(esInicial);
		this.setMostrarid_productoProductos(esInicial);
		this.setMostrarfecha_inicioProductos(esInicial);
		this.setMostrarfecha_finProductos(esInicial);
		this.setMostrarnombre_productoProductos(esInicial);
		this.setMostrarfechaProductos(esInicial);
		this.setMostrarcantidadProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosConstantesFunciones.ID)) {
				this.setMostraridProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.FECHA)) {
				this.setMostrarfechaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadProductos(esAsigna);
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
		
		
		this.setActivaridProductos(esInicial);
		this.setActivarid_empresaProductos(esInicial);
		this.setActivarid_sucursalProductos(esInicial);
		this.setActivarid_productoProductos(esInicial);
		this.setActivarfecha_inicioProductos(esInicial);
		this.setActivarfecha_finProductos(esInicial);
		this.setActivarnombre_productoProductos(esInicial);
		this.setActivarfechaProductos(esInicial);
		this.setActivarcantidadProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosConstantesFunciones.ID)) {
				this.setActivaridProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.FECHA)) {
				this.setActivarfechaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadProductos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductosBeanSwingJInternalFrame productosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductos(esInicial);
		this.setResaltarid_empresaProductos(esInicial);
		this.setResaltarid_sucursalProductos(esInicial);
		this.setResaltarid_productoProductos(esInicial);
		this.setResaltarfecha_inicioProductos(esInicial);
		this.setResaltarfecha_finProductos(esInicial);
		this.setResaltarnombre_productoProductos(esInicial);
		this.setResaltarfechaProductos(esInicial);
		this.setResaltarcantidadProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosConstantesFunciones.ID)) {
				this.setResaltaridProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.FECHA)) {
				this.setResaltarfechaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadProductos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductosBeanSwingJInternalFrame productosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProductosProductos=true;

	public Boolean getMostrarBusquedaProductosProductos() {
		return this.mostrarBusquedaProductosProductos;
	}

	public void setMostrarBusquedaProductosProductos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProductosProductos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProductosProductos=true;

	public Boolean getActivarBusquedaProductosProductos() {
		return this.activarBusquedaProductosProductos;
	}

	public void setActivarBusquedaProductosProductos(Boolean habilitarResaltar) {
		this.activarBusquedaProductosProductos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProductosProductos=null;

	public Border getResaltarBusquedaProductosProductos() {
		return this.resaltarBusquedaProductosProductos;
	}

	public void setResaltarBusquedaProductosProductos(Border borderResaltar) {
		this.resaltarBusquedaProductosProductos= borderResaltar;
	}

	public void setResaltarBusquedaProductosProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBeanSwingJInternalFrame productosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProductosProductos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}