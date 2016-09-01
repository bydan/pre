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
package com.bydan.erp.facturacion.util.report;

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


import com.bydan.erp.facturacion.util.report.ProductosResumidosConstantesFunciones;
import com.bydan.erp.facturacion.util.report.ProductosResumidosParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.ProductosResumidosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;



import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProductosResumidosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProductosResumidos";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductosResumidos"+ProductosResumidosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductosResumidosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductosResumidosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductosResumidosConstantesFunciones.SCHEMA+"_"+ProductosResumidosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductosResumidosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductosResumidosConstantesFunciones.SCHEMA+"_"+ProductosResumidosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductosResumidosConstantesFunciones.SCHEMA+"_"+ProductosResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductosResumidosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductosResumidosConstantesFunciones.SCHEMA+"_"+ProductosResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductosResumidosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductosResumidosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductosResumidosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductosResumidosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductosResumidosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductosResumidosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Productos Resumidoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Productos Resumidos";
	public static final String SCLASSWEBTITULO_LOWER="Productos Resumidos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductosResumidos";
	public static final String OBJECTNAME="productosresumidos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="productos_resumidos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productosresumidos from "+ProductosResumidosConstantesFunciones.SPERSISTENCENAME+" productosresumidos";
	public static String QUERYSELECTNATIVE="select "+ProductosResumidosConstantesFunciones.SCHEMA+"."+ProductosResumidosConstantesFunciones.TABLENAME+".id,"+ProductosResumidosConstantesFunciones.SCHEMA+"."+ProductosResumidosConstantesFunciones.TABLENAME+".version_row,"+ProductosResumidosConstantesFunciones.SCHEMA+"."+ProductosResumidosConstantesFunciones.TABLENAME+".id_producto,"+ProductosResumidosConstantesFunciones.SCHEMA+"."+ProductosResumidosConstantesFunciones.TABLENAME+".id_empresa,"+ProductosResumidosConstantesFunciones.SCHEMA+"."+ProductosResumidosConstantesFunciones.TABLENAME+".id_sucursal,"+ProductosResumidosConstantesFunciones.SCHEMA+"."+ProductosResumidosConstantesFunciones.TABLENAME+".fecha_emision_desde,"+ProductosResumidosConstantesFunciones.SCHEMA+"."+ProductosResumidosConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+ProductosResumidosConstantesFunciones.SCHEMA+"."+ProductosResumidosConstantesFunciones.TABLENAME+".nombre_unidad,"+ProductosResumidosConstantesFunciones.SCHEMA+"."+ProductosResumidosConstantesFunciones.TABLENAME+".nombre_producto,"+ProductosResumidosConstantesFunciones.SCHEMA+"."+ProductosResumidosConstantesFunciones.TABLENAME+".cantidad,"+ProductosResumidosConstantesFunciones.SCHEMA+"."+ProductosResumidosConstantesFunciones.TABLENAME+".monto,"+ProductosResumidosConstantesFunciones.SCHEMA+"."+ProductosResumidosConstantesFunciones.TABLENAME+".codigo_producto,"+ProductosResumidosConstantesFunciones.SCHEMA+"."+ProductosResumidosConstantesFunciones.TABLENAME+".tipo from "+ProductosResumidosConstantesFunciones.SCHEMA+"."+ProductosResumidosConstantesFunciones.TABLENAME;//+" as "+ProductosResumidosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBREUNIDAD= "nombre_unidad";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String CANTIDAD= "cantidad";
    public static final String MONTO= "monto";
    public static final String CODIGOPRODUCTO= "codigo_producto";
    public static final String TIPO= "tipo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBREUNIDAD= "Nombre Unad";
		public static final String LABEL_NOMBREUNIDAD_LOWER= "Nombre Unidad";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_CANTIDAD= "Cantad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_MONTO= "Monto";
		public static final String LABEL_MONTO_LOWER= "Monto";
    	public static final String LABEL_CODIGOPRODUCTO= "Codigo Producto";
		public static final String LABEL_CODIGOPRODUCTO_LOWER= "Codigo Producto";
    	public static final String LABEL_TIPO= "Tipo";
		public static final String LABEL_TIPO_LOWER= "Tipo";
	
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_UNIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_UNIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXCODIGO_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTIPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProductosResumidosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductosResumidosConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProductosResumidosConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProductosResumidosConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProductosResumidosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProductosResumidosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProductosResumidosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProductosResumidosConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=ProductosResumidosConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(ProductosResumidosConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=ProductosResumidosConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(ProductosResumidosConstantesFunciones.NOMBREUNIDAD)) {sLabelColumna=ProductosResumidosConstantesFunciones.LABEL_NOMBREUNIDAD;}
		if(sNombreColumna.equals(ProductosResumidosConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=ProductosResumidosConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(ProductosResumidosConstantesFunciones.CANTIDAD)) {sLabelColumna=ProductosResumidosConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(ProductosResumidosConstantesFunciones.MONTO)) {sLabelColumna=ProductosResumidosConstantesFunciones.LABEL_MONTO;}
		if(sNombreColumna.equals(ProductosResumidosConstantesFunciones.CODIGOPRODUCTO)) {sLabelColumna=ProductosResumidosConstantesFunciones.LABEL_CODIGOPRODUCTO;}
		if(sNombreColumna.equals(ProductosResumidosConstantesFunciones.TIPO)) {sLabelColumna=ProductosResumidosConstantesFunciones.LABEL_TIPO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProductosResumidosDescripcion(ProductosResumidos productosresumidos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productosresumidos !=null/* && productosresumidos.getId()!=0*/) {
			if(productosresumidos.getId()!=null) {
				sDescripcion=productosresumidos.getId().toString();
			}//productosresumidosproductosresumidos.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductosResumidosDescripcionDetallado(ProductosResumidos productosresumidos) {
		String sDescripcion="";
			
		sDescripcion+=ProductosResumidosConstantesFunciones.ID+"=";
		sDescripcion+=productosresumidos.getId().toString()+",";
		sDescripcion+=ProductosResumidosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productosresumidos.getVersionRow().toString()+",";
		sDescripcion+=ProductosResumidosConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=productosresumidos.getid_producto().toString()+",";
		sDescripcion+=ProductosResumidosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=productosresumidos.getid_empresa().toString()+",";
		sDescripcion+=ProductosResumidosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=productosresumidos.getid_sucursal().toString()+",";
		sDescripcion+=ProductosResumidosConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=productosresumidos.getfecha_emision_desde().toString()+",";
		sDescripcion+=ProductosResumidosConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=productosresumidos.getfecha_emision_hasta().toString()+",";
		sDescripcion+=ProductosResumidosConstantesFunciones.NOMBREUNIDAD+"=";
		sDescripcion+=productosresumidos.getnombre_unidad()+",";
		sDescripcion+=ProductosResumidosConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=productosresumidos.getnombre_producto()+",";
		sDescripcion+=ProductosResumidosConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=productosresumidos.getcantidad().toString()+",";
		sDescripcion+=ProductosResumidosConstantesFunciones.MONTO+"=";
		sDescripcion+=productosresumidos.getmonto().toString()+",";
		sDescripcion+=ProductosResumidosConstantesFunciones.CODIGOPRODUCTO+"=";
		sDescripcion+=productosresumidos.getcodigo_producto()+",";
		sDescripcion+=ProductosResumidosConstantesFunciones.TIPO+"=";
		sDescripcion+=productosresumidos.gettipo()+",";
			
		return sDescripcion;
	}
	
	public static void setProductosResumidosDescripcion(ProductosResumidos productosresumidos,String sValor) throws Exception {			
		if(productosresumidos !=null) {
			//productosresumidosproductosresumidos.getId().toString();
		}		
	}
	
		

	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
		}

		return sDescripcion;
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProductosResumidos")) {
			sNombreIndice="Tipo=  Por Producto Por Fecha Emision Desde Por Fecha Emision Hasta";
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

	public static String getDetalleIndiceBusquedaProductosResumidos(Long id_producto,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosProductosResumidos(ProductosResumidos productosresumidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productosresumidos.setnombre_unidad(productosresumidos.getnombre_unidad().trim());
		productosresumidos.setnombre_producto(productosresumidos.getnombre_producto().trim());
		productosresumidos.setcodigo_producto(productosresumidos.getcodigo_producto().trim());
		productosresumidos.settipo(productosresumidos.gettipo().trim());
	}
	
	public static void quitarEspaciosProductosResumidoss(List<ProductosResumidos> productosresumidoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductosResumidos productosresumidos: productosresumidoss) {
			productosresumidos.setnombre_unidad(productosresumidos.getnombre_unidad().trim());
			productosresumidos.setnombre_producto(productosresumidos.getnombre_producto().trim());
			productosresumidos.setcodigo_producto(productosresumidos.getcodigo_producto().trim());
			productosresumidos.settipo(productosresumidos.gettipo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductosResumidos(ProductosResumidos productosresumidos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productosresumidos.getConCambioAuxiliar()) {
			productosresumidos.setIsDeleted(productosresumidos.getIsDeletedAuxiliar());	
			productosresumidos.setIsNew(productosresumidos.getIsNewAuxiliar());	
			productosresumidos.setIsChanged(productosresumidos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productosresumidos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productosresumidos.setIsDeletedAuxiliar(false);	
			productosresumidos.setIsNewAuxiliar(false);	
			productosresumidos.setIsChangedAuxiliar(false);
			
			productosresumidos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductosResumidoss(List<ProductosResumidos> productosresumidoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductosResumidos productosresumidos : productosresumidoss) {
			if(conAsignarBase && productosresumidos.getConCambioAuxiliar()) {
				productosresumidos.setIsDeleted(productosresumidos.getIsDeletedAuxiliar());	
				productosresumidos.setIsNew(productosresumidos.getIsNewAuxiliar());	
				productosresumidos.setIsChanged(productosresumidos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productosresumidos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productosresumidos.setIsDeletedAuxiliar(false);	
				productosresumidos.setIsNewAuxiliar(false);	
				productosresumidos.setIsChangedAuxiliar(false);
				
				productosresumidos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductosResumidos(ProductosResumidos productosresumidos,Boolean conEnteros) throws Exception  {
		productosresumidos.setmonto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			productosresumidos.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresProductosResumidoss(List<ProductosResumidos> productosresumidoss,Boolean conEnteros) throws Exception  {
		
		for(ProductosResumidos productosresumidos: productosresumidoss) {
			productosresumidos.setmonto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				productosresumidos.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductosResumidos(List<ProductosResumidos> productosresumidoss,ProductosResumidos productosresumidosAux) throws Exception  {
		ProductosResumidosConstantesFunciones.InicializarValoresProductosResumidos(productosresumidosAux,true);
		
		for(ProductosResumidos productosresumidos: productosresumidoss) {
			if(productosresumidos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productosresumidosAux.setcantidad(productosresumidosAux.getcantidad()+productosresumidos.getcantidad());			
			productosresumidosAux.setmonto(productosresumidosAux.getmonto()+productosresumidos.getmonto());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosResumidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductosResumidosConstantesFunciones.getArrayColumnasGlobalesProductosResumidos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosResumidos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductosResumidosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductosResumidosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductosResumidosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductosResumidosConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductosResumidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductosResumidos> productosresumidoss,ProductosResumidos productosresumidos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductosResumidos productosresumidosAux: productosresumidoss) {
			if(productosresumidosAux!=null && productosresumidos!=null) {
				if((productosresumidosAux.getId()==null && productosresumidos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productosresumidosAux.getId()!=null && productosresumidos.getId()!=null){
					if(productosresumidosAux.getId().equals(productosresumidos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductosResumidos(List<ProductosResumidos> productosresumidoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double montoTotal=0.0;
	
		for(ProductosResumidos productosresumidos: productosresumidoss) {			
			if(productosresumidos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			montoTotal+=productosresumidos.getmonto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosResumidosConstantesFunciones.MONTO);
		datoGeneral.setsDescripcion(ProductosResumidosConstantesFunciones.LABEL_MONTO);
		datoGeneral.setdValorDouble(montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductosResumidos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductosResumidosConstantesFunciones.LABEL_ID, ProductosResumidosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosResumidosConstantesFunciones.LABEL_VERSIONROW, ProductosResumidosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosResumidosConstantesFunciones.LABEL_NOMBREUNIDAD, ProductosResumidosConstantesFunciones.NOMBREUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosResumidosConstantesFunciones.LABEL_NOMBREPRODUCTO, ProductosResumidosConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosResumidosConstantesFunciones.LABEL_CANTIDAD, ProductosResumidosConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosResumidosConstantesFunciones.LABEL_MONTO, ProductosResumidosConstantesFunciones.MONTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosResumidosConstantesFunciones.LABEL_CODIGOPRODUCTO, ProductosResumidosConstantesFunciones.CODIGOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosResumidosConstantesFunciones.LABEL_TIPO, ProductosResumidosConstantesFunciones.TIPO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductosResumidos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductosResumidosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosResumidosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosResumidosConstantesFunciones.NOMBREUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosResumidosConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosResumidosConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosResumidosConstantesFunciones.MONTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosResumidosConstantesFunciones.CODIGOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosResumidosConstantesFunciones.TIPO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosResumidos() throws Exception  {
		return ProductosResumidosConstantesFunciones.getTiposSeleccionarProductosResumidos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosResumidos(Boolean conFk) throws Exception  {
		return ProductosResumidosConstantesFunciones.getTiposSeleccionarProductosResumidos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosResumidos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosResumidosConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProductosResumidosConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosResumidosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProductosResumidosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosResumidosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProductosResumidosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosResumidosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(ProductosResumidosConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosResumidosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(ProductosResumidosConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosResumidosConstantesFunciones.LABEL_NOMBREUNIDAD);
			reporte.setsDescripcion(ProductosResumidosConstantesFunciones.LABEL_NOMBREUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosResumidosConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(ProductosResumidosConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosResumidosConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(ProductosResumidosConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosResumidosConstantesFunciones.LABEL_MONTO);
			reporte.setsDescripcion(ProductosResumidosConstantesFunciones.LABEL_MONTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosResumidosConstantesFunciones.LABEL_CODIGOPRODUCTO);
			reporte.setsDescripcion(ProductosResumidosConstantesFunciones.LABEL_CODIGOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosResumidosConstantesFunciones.LABEL_TIPO);
			reporte.setsDescripcion(ProductosResumidosConstantesFunciones.LABEL_TIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductosResumidos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductosResumidos(ProductosResumidos productosresumidosAux) throws Exception {
		
			productosresumidosAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productosresumidosAux.getProducto()));
			productosresumidosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productosresumidosAux.getEmpresa()));
			productosresumidosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productosresumidosAux.getSucursal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductosResumidos(List<ProductosResumidos> productosresumidossTemp) throws Exception {
		for(ProductosResumidos productosresumidosAux:productosresumidossTemp) {
			
			productosresumidosAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productosresumidosAux.getProducto()));
			productosresumidosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productosresumidosAux.getEmpresa()));
			productosresumidosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productosresumidosAux.getSucursal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductosResumidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
					}
				}

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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductosResumidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductosResumidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductosResumidosConstantesFunciones.getClassesRelationshipsOfProductosResumidos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductosResumidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductosResumidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductosResumidosConstantesFunciones.getClassesRelationshipsFromStringsOfProductosResumidos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductosResumidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductosResumidos productosresumidos,List<ProductosResumidos> productosresumidoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProductosResumidos productosresumidos,List<ProductosResumidos> productosresumidoss) throws Exception {
		try	{			
			for(ProductosResumidos productosresumidosLocal:productosresumidoss) {
				if(productosresumidosLocal.getId().equals(productosresumidos.getId())) {
					productosresumidosLocal.setIsSelected(productosresumidos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductosResumidos(List<ProductosResumidos> productosresumidossAux) throws Exception {
		//this.productosresumidossAux=productosresumidossAux;
		
		for(ProductosResumidos productosresumidosAux:productosresumidossAux) {
			if(productosresumidosAux.getIsChanged()) {
				productosresumidosAux.setIsChanged(false);
			}		
			
			if(productosresumidosAux.getIsNew()) {
				productosresumidosAux.setIsNew(false);
			}	
			
			if(productosresumidosAux.getIsDeleted()) {
				productosresumidosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductosResumidos(ProductosResumidos productosresumidosAux) throws Exception {
		//this.productosresumidosAux=productosresumidosAux;
		
			if(productosresumidosAux.getIsChanged()) {
				productosresumidosAux.setIsChanged(false);
			}		
			
			if(productosresumidosAux.getIsNew()) {
				productosresumidosAux.setIsNew(false);
			}	
			
			if(productosresumidosAux.getIsDeleted()) {
				productosresumidosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductosResumidos productosresumidosAsignar,ProductosResumidos productosresumidos) throws Exception {
		productosresumidosAsignar.setId(productosresumidos.getId());	
		productosresumidosAsignar.setVersionRow(productosresumidos.getVersionRow());	
		productosresumidosAsignar.setnombre_unidad(productosresumidos.getnombre_unidad());	
		productosresumidosAsignar.setnombre_producto(productosresumidos.getnombre_producto());	
		productosresumidosAsignar.setcantidad(productosresumidos.getcantidad());	
		productosresumidosAsignar.setmonto(productosresumidos.getmonto());	
		productosresumidosAsignar.setcodigo_producto(productosresumidos.getcodigo_producto());	
		productosresumidosAsignar.settipo(productosresumidos.gettipo());	
	}
	
	public static void inicializarProductosResumidos(ProductosResumidos productosresumidos) throws Exception {
		try {
				productosresumidos.setId(0L);	
					
				productosresumidos.setnombre_unidad("");	
				productosresumidos.setnombre_producto("");	
				productosresumidos.setcantidad(0);	
				productosresumidos.setmonto(0.0);	
				productosresumidos.setcodigo_producto("");	
				productosresumidos.settipo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductosResumidos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosResumidosConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosResumidosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosResumidosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosResumidosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosResumidosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosResumidosConstantesFunciones.LABEL_NOMBREUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosResumidosConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosResumidosConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosResumidosConstantesFunciones.LABEL_MONTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosResumidosConstantesFunciones.LABEL_CODIGOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosResumidosConstantesFunciones.LABEL_TIPO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductosResumidos(String sTipo,Row row,Workbook workbook,ProductosResumidos productosresumidos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productosresumidos.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosresumidos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosresumidos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosresumidos.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosresumidos.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosresumidos.getnombre_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosresumidos.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosresumidos.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosresumidos.getmonto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosresumidos.getcodigo_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosresumidos.gettipo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductosResumidos="";
	
	public String getsFinalQueryProductosResumidos() {
		return this.sFinalQueryProductosResumidos;
	}
	
	public void setsFinalQueryProductosResumidos(String sFinalQueryProductosResumidos) {
		this.sFinalQueryProductosResumidos= sFinalQueryProductosResumidos;
	}
	
	public Border resaltarSeleccionarProductosResumidos=null;
	
	public Border setResaltarSeleccionarProductosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosResumidosBeanSwingJInternalFrame productosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productosresumidosBeanSwingJInternalFrame.jTtoolBarProductosResumidos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductosResumidos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductosResumidos() {
		return this.resaltarSeleccionarProductosResumidos;
	}
	
	public void setResaltarSeleccionarProductosResumidos(Border borderResaltarSeleccionarProductosResumidos) {
		this.resaltarSeleccionarProductosResumidos= borderResaltarSeleccionarProductosResumidos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductosResumidos=null;
	public Boolean mostraridProductosResumidos=true;
	public Boolean activaridProductosResumidos=true;

	public Border resaltarid_productoProductosResumidos=null;
	public Boolean mostrarid_productoProductosResumidos=true;
	public Boolean activarid_productoProductosResumidos=true;
	public Boolean cargarid_productoProductosResumidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProductosResumidos=false;//ConEventDepend=true

	public Border resaltarid_empresaProductosResumidos=null;
	public Boolean mostrarid_empresaProductosResumidos=true;
	public Boolean activarid_empresaProductosResumidos=true;
	public Boolean cargarid_empresaProductosResumidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProductosResumidos=false;//ConEventDepend=true

	public Border resaltarid_sucursalProductosResumidos=null;
	public Boolean mostrarid_sucursalProductosResumidos=true;
	public Boolean activarid_sucursalProductosResumidos=true;
	public Boolean cargarid_sucursalProductosResumidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProductosResumidos=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeProductosResumidos=null;
	public Boolean mostrarfecha_emision_desdeProductosResumidos=true;
	public Boolean activarfecha_emision_desdeProductosResumidos=true;

	public Border resaltarfecha_emision_hastaProductosResumidos=null;
	public Boolean mostrarfecha_emision_hastaProductosResumidos=true;
	public Boolean activarfecha_emision_hastaProductosResumidos=true;

	public Border resaltarnombre_unidadProductosResumidos=null;
	public Boolean mostrarnombre_unidadProductosResumidos=true;
	public Boolean activarnombre_unidadProductosResumidos=true;

	public Border resaltarnombre_productoProductosResumidos=null;
	public Boolean mostrarnombre_productoProductosResumidos=true;
	public Boolean activarnombre_productoProductosResumidos=true;

	public Border resaltarcantidadProductosResumidos=null;
	public Boolean mostrarcantidadProductosResumidos=true;
	public Boolean activarcantidadProductosResumidos=true;

	public Border resaltarmontoProductosResumidos=null;
	public Boolean mostrarmontoProductosResumidos=true;
	public Boolean activarmontoProductosResumidos=true;

	public Border resaltarcodigo_productoProductosResumidos=null;
	public Boolean mostrarcodigo_productoProductosResumidos=true;
	public Boolean activarcodigo_productoProductosResumidos=true;

	public Border resaltartipoProductosResumidos=null;
	public Boolean mostrartipoProductosResumidos=true;
	public Boolean activartipoProductosResumidos=true;

	
	

	public Border setResaltaridProductosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosResumidosBeanSwingJInternalFrame productosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosresumidosBeanSwingJInternalFrame.jTtoolBarProductosResumidos.setBorder(borderResaltar);
		
		this.resaltaridProductosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductosResumidos() {
		return this.resaltaridProductosResumidos;
	}

	public void setResaltaridProductosResumidos(Border borderResaltar) {
		this.resaltaridProductosResumidos= borderResaltar;
	}

	public Boolean getMostraridProductosResumidos() {
		return this.mostraridProductosResumidos;
	}

	public void setMostraridProductosResumidos(Boolean mostraridProductosResumidos) {
		this.mostraridProductosResumidos= mostraridProductosResumidos;
	}

	public Boolean getActivaridProductosResumidos() {
		return this.activaridProductosResumidos;
	}

	public void setActivaridProductosResumidos(Boolean activaridProductosResumidos) {
		this.activaridProductosResumidos= activaridProductosResumidos;
	}

	public Border setResaltarid_productoProductosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosResumidosBeanSwingJInternalFrame productosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosresumidosBeanSwingJInternalFrame.jTtoolBarProductosResumidos.setBorder(borderResaltar);
		
		this.resaltarid_productoProductosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProductosResumidos() {
		return this.resaltarid_productoProductosResumidos;
	}

	public void setResaltarid_productoProductosResumidos(Border borderResaltar) {
		this.resaltarid_productoProductosResumidos= borderResaltar;
	}

	public Boolean getMostrarid_productoProductosResumidos() {
		return this.mostrarid_productoProductosResumidos;
	}

	public void setMostrarid_productoProductosResumidos(Boolean mostrarid_productoProductosResumidos) {
		this.mostrarid_productoProductosResumidos= mostrarid_productoProductosResumidos;
	}

	public Boolean getActivarid_productoProductosResumidos() {
		return this.activarid_productoProductosResumidos;
	}

	public void setActivarid_productoProductosResumidos(Boolean activarid_productoProductosResumidos) {
		this.activarid_productoProductosResumidos= activarid_productoProductosResumidos;
	}

	public Boolean getCargarid_productoProductosResumidos() {
		return this.cargarid_productoProductosResumidos;
	}

	public void setCargarid_productoProductosResumidos(Boolean cargarid_productoProductosResumidos) {
		this.cargarid_productoProductosResumidos= cargarid_productoProductosResumidos;
	}

	public Border setResaltarid_empresaProductosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosResumidosBeanSwingJInternalFrame productosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosresumidosBeanSwingJInternalFrame.jTtoolBarProductosResumidos.setBorder(borderResaltar);
		
		this.resaltarid_empresaProductosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProductosResumidos() {
		return this.resaltarid_empresaProductosResumidos;
	}

	public void setResaltarid_empresaProductosResumidos(Border borderResaltar) {
		this.resaltarid_empresaProductosResumidos= borderResaltar;
	}

	public Boolean getMostrarid_empresaProductosResumidos() {
		return this.mostrarid_empresaProductosResumidos;
	}

	public void setMostrarid_empresaProductosResumidos(Boolean mostrarid_empresaProductosResumidos) {
		this.mostrarid_empresaProductosResumidos= mostrarid_empresaProductosResumidos;
	}

	public Boolean getActivarid_empresaProductosResumidos() {
		return this.activarid_empresaProductosResumidos;
	}

	public void setActivarid_empresaProductosResumidos(Boolean activarid_empresaProductosResumidos) {
		this.activarid_empresaProductosResumidos= activarid_empresaProductosResumidos;
	}

	public Boolean getCargarid_empresaProductosResumidos() {
		return this.cargarid_empresaProductosResumidos;
	}

	public void setCargarid_empresaProductosResumidos(Boolean cargarid_empresaProductosResumidos) {
		this.cargarid_empresaProductosResumidos= cargarid_empresaProductosResumidos;
	}

	public Border setResaltarid_sucursalProductosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosResumidosBeanSwingJInternalFrame productosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosresumidosBeanSwingJInternalFrame.jTtoolBarProductosResumidos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProductosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProductosResumidos() {
		return this.resaltarid_sucursalProductosResumidos;
	}

	public void setResaltarid_sucursalProductosResumidos(Border borderResaltar) {
		this.resaltarid_sucursalProductosResumidos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProductosResumidos() {
		return this.mostrarid_sucursalProductosResumidos;
	}

	public void setMostrarid_sucursalProductosResumidos(Boolean mostrarid_sucursalProductosResumidos) {
		this.mostrarid_sucursalProductosResumidos= mostrarid_sucursalProductosResumidos;
	}

	public Boolean getActivarid_sucursalProductosResumidos() {
		return this.activarid_sucursalProductosResumidos;
	}

	public void setActivarid_sucursalProductosResumidos(Boolean activarid_sucursalProductosResumidos) {
		this.activarid_sucursalProductosResumidos= activarid_sucursalProductosResumidos;
	}

	public Boolean getCargarid_sucursalProductosResumidos() {
		return this.cargarid_sucursalProductosResumidos;
	}

	public void setCargarid_sucursalProductosResumidos(Boolean cargarid_sucursalProductosResumidos) {
		this.cargarid_sucursalProductosResumidos= cargarid_sucursalProductosResumidos;
	}

	public Border setResaltarfecha_emision_desdeProductosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosResumidosBeanSwingJInternalFrame productosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosresumidosBeanSwingJInternalFrame.jTtoolBarProductosResumidos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeProductosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeProductosResumidos() {
		return this.resaltarfecha_emision_desdeProductosResumidos;
	}

	public void setResaltarfecha_emision_desdeProductosResumidos(Border borderResaltar) {
		this.resaltarfecha_emision_desdeProductosResumidos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeProductosResumidos() {
		return this.mostrarfecha_emision_desdeProductosResumidos;
	}

	public void setMostrarfecha_emision_desdeProductosResumidos(Boolean mostrarfecha_emision_desdeProductosResumidos) {
		this.mostrarfecha_emision_desdeProductosResumidos= mostrarfecha_emision_desdeProductosResumidos;
	}

	public Boolean getActivarfecha_emision_desdeProductosResumidos() {
		return this.activarfecha_emision_desdeProductosResumidos;
	}

	public void setActivarfecha_emision_desdeProductosResumidos(Boolean activarfecha_emision_desdeProductosResumidos) {
		this.activarfecha_emision_desdeProductosResumidos= activarfecha_emision_desdeProductosResumidos;
	}

	public Border setResaltarfecha_emision_hastaProductosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosResumidosBeanSwingJInternalFrame productosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosresumidosBeanSwingJInternalFrame.jTtoolBarProductosResumidos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaProductosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaProductosResumidos() {
		return this.resaltarfecha_emision_hastaProductosResumidos;
	}

	public void setResaltarfecha_emision_hastaProductosResumidos(Border borderResaltar) {
		this.resaltarfecha_emision_hastaProductosResumidos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaProductosResumidos() {
		return this.mostrarfecha_emision_hastaProductosResumidos;
	}

	public void setMostrarfecha_emision_hastaProductosResumidos(Boolean mostrarfecha_emision_hastaProductosResumidos) {
		this.mostrarfecha_emision_hastaProductosResumidos= mostrarfecha_emision_hastaProductosResumidos;
	}

	public Boolean getActivarfecha_emision_hastaProductosResumidos() {
		return this.activarfecha_emision_hastaProductosResumidos;
	}

	public void setActivarfecha_emision_hastaProductosResumidos(Boolean activarfecha_emision_hastaProductosResumidos) {
		this.activarfecha_emision_hastaProductosResumidos= activarfecha_emision_hastaProductosResumidos;
	}

	public Border setResaltarnombre_unidadProductosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosResumidosBeanSwingJInternalFrame productosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosresumidosBeanSwingJInternalFrame.jTtoolBarProductosResumidos.setBorder(borderResaltar);
		
		this.resaltarnombre_unidadProductosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_unidadProductosResumidos() {
		return this.resaltarnombre_unidadProductosResumidos;
	}

	public void setResaltarnombre_unidadProductosResumidos(Border borderResaltar) {
		this.resaltarnombre_unidadProductosResumidos= borderResaltar;
	}

	public Boolean getMostrarnombre_unidadProductosResumidos() {
		return this.mostrarnombre_unidadProductosResumidos;
	}

	public void setMostrarnombre_unidadProductosResumidos(Boolean mostrarnombre_unidadProductosResumidos) {
		this.mostrarnombre_unidadProductosResumidos= mostrarnombre_unidadProductosResumidos;
	}

	public Boolean getActivarnombre_unidadProductosResumidos() {
		return this.activarnombre_unidadProductosResumidos;
	}

	public void setActivarnombre_unidadProductosResumidos(Boolean activarnombre_unidadProductosResumidos) {
		this.activarnombre_unidadProductosResumidos= activarnombre_unidadProductosResumidos;
	}

	public Border setResaltarnombre_productoProductosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosResumidosBeanSwingJInternalFrame productosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosresumidosBeanSwingJInternalFrame.jTtoolBarProductosResumidos.setBorder(borderResaltar);
		
		this.resaltarnombre_productoProductosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoProductosResumidos() {
		return this.resaltarnombre_productoProductosResumidos;
	}

	public void setResaltarnombre_productoProductosResumidos(Border borderResaltar) {
		this.resaltarnombre_productoProductosResumidos= borderResaltar;
	}

	public Boolean getMostrarnombre_productoProductosResumidos() {
		return this.mostrarnombre_productoProductosResumidos;
	}

	public void setMostrarnombre_productoProductosResumidos(Boolean mostrarnombre_productoProductosResumidos) {
		this.mostrarnombre_productoProductosResumidos= mostrarnombre_productoProductosResumidos;
	}

	public Boolean getActivarnombre_productoProductosResumidos() {
		return this.activarnombre_productoProductosResumidos;
	}

	public void setActivarnombre_productoProductosResumidos(Boolean activarnombre_productoProductosResumidos) {
		this.activarnombre_productoProductosResumidos= activarnombre_productoProductosResumidos;
	}

	public Border setResaltarcantidadProductosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosResumidosBeanSwingJInternalFrame productosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosresumidosBeanSwingJInternalFrame.jTtoolBarProductosResumidos.setBorder(borderResaltar);
		
		this.resaltarcantidadProductosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadProductosResumidos() {
		return this.resaltarcantidadProductosResumidos;
	}

	public void setResaltarcantidadProductosResumidos(Border borderResaltar) {
		this.resaltarcantidadProductosResumidos= borderResaltar;
	}

	public Boolean getMostrarcantidadProductosResumidos() {
		return this.mostrarcantidadProductosResumidos;
	}

	public void setMostrarcantidadProductosResumidos(Boolean mostrarcantidadProductosResumidos) {
		this.mostrarcantidadProductosResumidos= mostrarcantidadProductosResumidos;
	}

	public Boolean getActivarcantidadProductosResumidos() {
		return this.activarcantidadProductosResumidos;
	}

	public void setActivarcantidadProductosResumidos(Boolean activarcantidadProductosResumidos) {
		this.activarcantidadProductosResumidos= activarcantidadProductosResumidos;
	}

	public Border setResaltarmontoProductosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosResumidosBeanSwingJInternalFrame productosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosresumidosBeanSwingJInternalFrame.jTtoolBarProductosResumidos.setBorder(borderResaltar);
		
		this.resaltarmontoProductosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmontoProductosResumidos() {
		return this.resaltarmontoProductosResumidos;
	}

	public void setResaltarmontoProductosResumidos(Border borderResaltar) {
		this.resaltarmontoProductosResumidos= borderResaltar;
	}

	public Boolean getMostrarmontoProductosResumidos() {
		return this.mostrarmontoProductosResumidos;
	}

	public void setMostrarmontoProductosResumidos(Boolean mostrarmontoProductosResumidos) {
		this.mostrarmontoProductosResumidos= mostrarmontoProductosResumidos;
	}

	public Boolean getActivarmontoProductosResumidos() {
		return this.activarmontoProductosResumidos;
	}

	public void setActivarmontoProductosResumidos(Boolean activarmontoProductosResumidos) {
		this.activarmontoProductosResumidos= activarmontoProductosResumidos;
	}

	public Border setResaltarcodigo_productoProductosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosResumidosBeanSwingJInternalFrame productosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosresumidosBeanSwingJInternalFrame.jTtoolBarProductosResumidos.setBorder(borderResaltar);
		
		this.resaltarcodigo_productoProductosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_productoProductosResumidos() {
		return this.resaltarcodigo_productoProductosResumidos;
	}

	public void setResaltarcodigo_productoProductosResumidos(Border borderResaltar) {
		this.resaltarcodigo_productoProductosResumidos= borderResaltar;
	}

	public Boolean getMostrarcodigo_productoProductosResumidos() {
		return this.mostrarcodigo_productoProductosResumidos;
	}

	public void setMostrarcodigo_productoProductosResumidos(Boolean mostrarcodigo_productoProductosResumidos) {
		this.mostrarcodigo_productoProductosResumidos= mostrarcodigo_productoProductosResumidos;
	}

	public Boolean getActivarcodigo_productoProductosResumidos() {
		return this.activarcodigo_productoProductosResumidos;
	}

	public void setActivarcodigo_productoProductosResumidos(Boolean activarcodigo_productoProductosResumidos) {
		this.activarcodigo_productoProductosResumidos= activarcodigo_productoProductosResumidos;
	}

	public Border setResaltartipoProductosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosResumidosBeanSwingJInternalFrame productosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosresumidosBeanSwingJInternalFrame.jTtoolBarProductosResumidos.setBorder(borderResaltar);
		
		this.resaltartipoProductosResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipoProductosResumidos() {
		return this.resaltartipoProductosResumidos;
	}

	public void setResaltartipoProductosResumidos(Border borderResaltar) {
		this.resaltartipoProductosResumidos= borderResaltar;
	}

	public Boolean getMostrartipoProductosResumidos() {
		return this.mostrartipoProductosResumidos;
	}

	public void setMostrartipoProductosResumidos(Boolean mostrartipoProductosResumidos) {
		this.mostrartipoProductosResumidos= mostrartipoProductosResumidos;
	}

	public Boolean getActivartipoProductosResumidos() {
		return this.activartipoProductosResumidos;
	}

	public void setActivartipoProductosResumidos(Boolean activartipoProductosResumidos) {
		this.activartipoProductosResumidos= activartipoProductosResumidos;
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
		
		
		this.setMostraridProductosResumidos(esInicial);
		this.setMostrarid_productoProductosResumidos(esInicial);
		this.setMostrarid_empresaProductosResumidos(esInicial);
		this.setMostrarid_sucursalProductosResumidos(esInicial);
		this.setMostrarfecha_emision_desdeProductosResumidos(esInicial);
		this.setMostrarfecha_emision_hastaProductosResumidos(esInicial);
		this.setMostrarnombre_unidadProductosResumidos(esInicial);
		this.setMostrarnombre_productoProductosResumidos(esInicial);
		this.setMostrarcantidadProductosResumidos(esInicial);
		this.setMostrarmontoProductosResumidos(esInicial);
		this.setMostrarcodigo_productoProductosResumidos(esInicial);
		this.setMostrartipoProductosResumidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.ID)) {
				this.setMostraridProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.NOMBREUNIDAD)) {
				this.setMostrarnombre_unidadProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.MONTO)) {
				this.setMostrarmontoProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setMostrarcodigo_productoProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.TIPO)) {
				this.setMostrartipoProductosResumidos(esAsigna);
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
		
		
		this.setActivaridProductosResumidos(esInicial);
		this.setActivarid_productoProductosResumidos(esInicial);
		this.setActivarid_empresaProductosResumidos(esInicial);
		this.setActivarid_sucursalProductosResumidos(esInicial);
		this.setActivarfecha_emision_desdeProductosResumidos(esInicial);
		this.setActivarfecha_emision_hastaProductosResumidos(esInicial);
		this.setActivarnombre_unidadProductosResumidos(esInicial);
		this.setActivarnombre_productoProductosResumidos(esInicial);
		this.setActivarcantidadProductosResumidos(esInicial);
		this.setActivarmontoProductosResumidos(esInicial);
		this.setActivarcodigo_productoProductosResumidos(esInicial);
		this.setActivartipoProductosResumidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.ID)) {
				this.setActivaridProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.NOMBREUNIDAD)) {
				this.setActivarnombre_unidadProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.MONTO)) {
				this.setActivarmontoProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setActivarcodigo_productoProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.TIPO)) {
				this.setActivartipoProductosResumidos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductosResumidosBeanSwingJInternalFrame productosresumidosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductosResumidos(esInicial);
		this.setResaltarid_productoProductosResumidos(esInicial);
		this.setResaltarid_empresaProductosResumidos(esInicial);
		this.setResaltarid_sucursalProductosResumidos(esInicial);
		this.setResaltarfecha_emision_desdeProductosResumidos(esInicial);
		this.setResaltarfecha_emision_hastaProductosResumidos(esInicial);
		this.setResaltarnombre_unidadProductosResumidos(esInicial);
		this.setResaltarnombre_productoProductosResumidos(esInicial);
		this.setResaltarcantidadProductosResumidos(esInicial);
		this.setResaltarmontoProductosResumidos(esInicial);
		this.setResaltarcodigo_productoProductosResumidos(esInicial);
		this.setResaltartipoProductosResumidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.ID)) {
				this.setResaltaridProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.NOMBREUNIDAD)) {
				this.setResaltarnombre_unidadProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.MONTO)) {
				this.setResaltarmontoProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setResaltarcodigo_productoProductosResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosResumidosConstantesFunciones.TIPO)) {
				this.setResaltartipoProductosResumidos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductosResumidosBeanSwingJInternalFrame productosresumidosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProductosResumidosProductosResumidos=true;

	public Boolean getMostrarBusquedaProductosResumidosProductosResumidos() {
		return this.mostrarBusquedaProductosResumidosProductosResumidos;
	}

	public void setMostrarBusquedaProductosResumidosProductosResumidos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProductosResumidosProductosResumidos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProductosResumidosProductosResumidos=true;

	public Boolean getActivarBusquedaProductosResumidosProductosResumidos() {
		return this.activarBusquedaProductosResumidosProductosResumidos;
	}

	public void setActivarBusquedaProductosResumidosProductosResumidos(Boolean habilitarResaltar) {
		this.activarBusquedaProductosResumidosProductosResumidos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProductosResumidosProductosResumidos=null;

	public Border getResaltarBusquedaProductosResumidosProductosResumidos() {
		return this.resaltarBusquedaProductosResumidosProductosResumidos;
	}

	public void setResaltarBusquedaProductosResumidosProductosResumidos(Border borderResaltar) {
		this.resaltarBusquedaProductosResumidosProductosResumidos= borderResaltar;
	}

	public void setResaltarBusquedaProductosResumidosProductosResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosResumidosBeanSwingJInternalFrame productosresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProductosResumidosProductosResumidos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}