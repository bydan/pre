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


import com.bydan.erp.inventario.util.ProductoPromocionConstantesFunciones;
import com.bydan.erp.inventario.util.ProductoPromocionParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ProductoPromocionParameterGeneral;

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
final public class ProductoPromocionConstantesFunciones extends ProductoPromocionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProductoPromocion";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductoPromocion"+ProductoPromocionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductoPromocionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductoPromocionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductoPromocionConstantesFunciones.SCHEMA+"_"+ProductoPromocionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductoPromocionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductoPromocionConstantesFunciones.SCHEMA+"_"+ProductoPromocionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductoPromocionConstantesFunciones.SCHEMA+"_"+ProductoPromocionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductoPromocionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductoPromocionConstantesFunciones.SCHEMA+"_"+ProductoPromocionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoPromocionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoPromocionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoPromocionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoPromocionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoPromocionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoPromocionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductoPromocionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductoPromocionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductoPromocionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductoPromocionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Promocions";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Promocion";
	public static final String SCLASSWEBTITULO_LOWER="Producto Promocion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductoPromocion";
	public static final String OBJECTNAME="productopromocion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="producto_promocion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productopromocion from "+ProductoPromocionConstantesFunciones.SPERSISTENCENAME+" productopromocion";
	public static String QUERYSELECTNATIVE="select "+ProductoPromocionConstantesFunciones.SCHEMA+"."+ProductoPromocionConstantesFunciones.TABLENAME+".id,"+ProductoPromocionConstantesFunciones.SCHEMA+"."+ProductoPromocionConstantesFunciones.TABLENAME+".version_row,"+ProductoPromocionConstantesFunciones.SCHEMA+"."+ProductoPromocionConstantesFunciones.TABLENAME+".id_empresa,"+ProductoPromocionConstantesFunciones.SCHEMA+"."+ProductoPromocionConstantesFunciones.TABLENAME+".id_sucursal,"+ProductoPromocionConstantesFunciones.SCHEMA+"."+ProductoPromocionConstantesFunciones.TABLENAME+".id_bodega,"+ProductoPromocionConstantesFunciones.SCHEMA+"."+ProductoPromocionConstantesFunciones.TABLENAME+".id_producto,"+ProductoPromocionConstantesFunciones.SCHEMA+"."+ProductoPromocionConstantesFunciones.TABLENAME+".id_bodega_relacion,"+ProductoPromocionConstantesFunciones.SCHEMA+"."+ProductoPromocionConstantesFunciones.TABLENAME+".id_producto_relacion,"+ProductoPromocionConstantesFunciones.SCHEMA+"."+ProductoPromocionConstantesFunciones.TABLENAME+".cantidad,"+ProductoPromocionConstantesFunciones.SCHEMA+"."+ProductoPromocionConstantesFunciones.TABLENAME+".precio,"+ProductoPromocionConstantesFunciones.SCHEMA+"."+ProductoPromocionConstantesFunciones.TABLENAME+".porcentaje,"+ProductoPromocionConstantesFunciones.SCHEMA+"."+ProductoPromocionConstantesFunciones.TABLENAME+".descripcion,"+ProductoPromocionConstantesFunciones.SCHEMA+"."+ProductoPromocionConstantesFunciones.TABLENAME+".descripcion2 from "+ProductoPromocionConstantesFunciones.SCHEMA+"."+ProductoPromocionConstantesFunciones.TABLENAME;//+" as "+ProductoPromocionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProductoPromocionConstantesFuncionesAdditional productopromocionConstantesFuncionesAdditional=null;
	
	public ProductoPromocionConstantesFuncionesAdditional getProductoPromocionConstantesFuncionesAdditional() {
		return this.productopromocionConstantesFuncionesAdditional;
	}
	
	public void setProductoPromocionConstantesFuncionesAdditional(ProductoPromocionConstantesFuncionesAdditional productopromocionConstantesFuncionesAdditional) {
		try {
			this.productopromocionConstantesFuncionesAdditional=productopromocionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDBODEGARELACION= "id_bodega_relacion";
    public static final String IDPRODUCTORELACION= "id_producto_relacion";
    public static final String CANTIDAD= "cantidad";
    public static final String PRECIO= "precio";
    public static final String PORCENTAJE= "porcentaje";
    public static final String DESCRIPCION= "descripcion";
    public static final String DESCRIPCION2= "descripcion2";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDBODEGARELACION= "Bodega Relacion";
		public static final String LABEL_IDBODEGARELACION_LOWER= "Bodega Relacion";
    	public static final String LABEL_IDPRODUCTORELACION= "Producto Relacion";
		public static final String LABEL_IDPRODUCTORELACION_LOWER= "Producto Relacion";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_DESCRIPCION2= "Descripcion2";
		public static final String LABEL_DESCRIPCION2_LOWER= "Descripcion2";
	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION2=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION2=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProductoPromocionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductoPromocionConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProductoPromocionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProductoPromocionConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProductoPromocionConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProductoPromocionConstantesFunciones.IDBODEGA)) {sLabelColumna=ProductoPromocionConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ProductoPromocionConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProductoPromocionConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProductoPromocionConstantesFunciones.IDBODEGARELACION)) {sLabelColumna=ProductoPromocionConstantesFunciones.LABEL_IDBODEGARELACION;}
		if(sNombreColumna.equals(ProductoPromocionConstantesFunciones.IDPRODUCTORELACION)) {sLabelColumna=ProductoPromocionConstantesFunciones.LABEL_IDPRODUCTORELACION;}
		if(sNombreColumna.equals(ProductoPromocionConstantesFunciones.CANTIDAD)) {sLabelColumna=ProductoPromocionConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(ProductoPromocionConstantesFunciones.PRECIO)) {sLabelColumna=ProductoPromocionConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(ProductoPromocionConstantesFunciones.PORCENTAJE)) {sLabelColumna=ProductoPromocionConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(ProductoPromocionConstantesFunciones.DESCRIPCION)) {sLabelColumna=ProductoPromocionConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(ProductoPromocionConstantesFunciones.DESCRIPCION2)) {sLabelColumna=ProductoPromocionConstantesFunciones.LABEL_DESCRIPCION2;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProductoPromocionDescripcion(ProductoPromocion productopromocion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productopromocion !=null/* && productopromocion.getId()!=0*/) {
			if(productopromocion.getId()!=null) {
				sDescripcion=productopromocion.getId().toString();
			}//productopromocionproductopromocion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductoPromocionDescripcionDetallado(ProductoPromocion productopromocion) {
		String sDescripcion="";
			
		sDescripcion+=ProductoPromocionConstantesFunciones.ID+"=";
		sDescripcion+=productopromocion.getId().toString()+",";
		sDescripcion+=ProductoPromocionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productopromocion.getVersionRow().toString()+",";
		sDescripcion+=ProductoPromocionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=productopromocion.getid_empresa().toString()+",";
		sDescripcion+=ProductoPromocionConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=productopromocion.getid_sucursal().toString()+",";
		sDescripcion+=ProductoPromocionConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=productopromocion.getid_bodega().toString()+",";
		sDescripcion+=ProductoPromocionConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=productopromocion.getid_producto().toString()+",";
		sDescripcion+=ProductoPromocionConstantesFunciones.IDBODEGARELACION+"=";
		sDescripcion+=productopromocion.getid_bodega_relacion().toString()+",";
		sDescripcion+=ProductoPromocionConstantesFunciones.IDPRODUCTORELACION+"=";
		sDescripcion+=productopromocion.getid_producto_relacion().toString()+",";
		sDescripcion+=ProductoPromocionConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=productopromocion.getcantidad().toString()+",";
		sDescripcion+=ProductoPromocionConstantesFunciones.PRECIO+"=";
		sDescripcion+=productopromocion.getprecio().toString()+",";
		sDescripcion+=ProductoPromocionConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=productopromocion.getporcentaje().toString()+",";
		sDescripcion+=ProductoPromocionConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=productopromocion.getdescripcion()+",";
		sDescripcion+=ProductoPromocionConstantesFunciones.DESCRIPCION2+"=";
		sDescripcion+=productopromocion.getdescripcion2()+",";
			
		return sDescripcion;
	}
	
	public static void setProductoPromocionDescripcion(ProductoPromocion productopromocion,String sValor) throws Exception {			
		if(productopromocion !=null) {
			//productopromocionproductopromocion.getId().toString();
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

	public static String getBodegaRelacionDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}

	public static String getProductoRelacionDescripcion(Producto producto) {
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
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdBodegaRelacion")) {
			sNombreIndice="Tipo=  Por Bodega Relacion";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdProductoRelacion")) {
			sNombreIndice="Tipo=  Por Producto Relacion";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodegaRelacion(Long id_bodega_relacion) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega_relacion!=null) {sDetalleIndice+=" Codigo Unico De Bodega Relacion="+id_bodega_relacion.toString();} 

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

	public static String getDetalleIndiceFK_IdProductoRelacion(Long id_producto_relacion) {
		String sDetalleIndice=" Parametros->";
		if(id_producto_relacion!=null) {sDetalleIndice+=" Codigo Unico De Producto Relacion="+id_producto_relacion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProductoPromocion(ProductoPromocion productopromocion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productopromocion.setdescripcion(productopromocion.getdescripcion().trim());
		productopromocion.setdescripcion2(productopromocion.getdescripcion2().trim());
	}
	
	public static void quitarEspaciosProductoPromocions(List<ProductoPromocion> productopromocions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoPromocion productopromocion: productopromocions) {
			productopromocion.setdescripcion(productopromocion.getdescripcion().trim());
			productopromocion.setdescripcion2(productopromocion.getdescripcion2().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoPromocion(ProductoPromocion productopromocion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productopromocion.getConCambioAuxiliar()) {
			productopromocion.setIsDeleted(productopromocion.getIsDeletedAuxiliar());	
			productopromocion.setIsNew(productopromocion.getIsNewAuxiliar());	
			productopromocion.setIsChanged(productopromocion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productopromocion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productopromocion.setIsDeletedAuxiliar(false);	
			productopromocion.setIsNewAuxiliar(false);	
			productopromocion.setIsChangedAuxiliar(false);
			
			productopromocion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoPromocions(List<ProductoPromocion> productopromocions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductoPromocion productopromocion : productopromocions) {
			if(conAsignarBase && productopromocion.getConCambioAuxiliar()) {
				productopromocion.setIsDeleted(productopromocion.getIsDeletedAuxiliar());	
				productopromocion.setIsNew(productopromocion.getIsNewAuxiliar());	
				productopromocion.setIsChanged(productopromocion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productopromocion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productopromocion.setIsDeletedAuxiliar(false);	
				productopromocion.setIsNewAuxiliar(false);	
				productopromocion.setIsChangedAuxiliar(false);
				
				productopromocion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductoPromocion(ProductoPromocion productopromocion,Boolean conEnteros) throws Exception  {
		productopromocion.setcantidad(0.0);
		productopromocion.setprecio(0.0);
		productopromocion.setporcentaje(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProductoPromocions(List<ProductoPromocion> productopromocions,Boolean conEnteros) throws Exception  {
		
		for(ProductoPromocion productopromocion: productopromocions) {
			productopromocion.setcantidad(0.0);
			productopromocion.setprecio(0.0);
			productopromocion.setporcentaje(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductoPromocion(List<ProductoPromocion> productopromocions,ProductoPromocion productopromocionAux) throws Exception  {
		ProductoPromocionConstantesFunciones.InicializarValoresProductoPromocion(productopromocionAux,true);
		
		for(ProductoPromocion productopromocion: productopromocions) {
			if(productopromocion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productopromocionAux.setcantidad(productopromocionAux.getcantidad()+productopromocion.getcantidad());			
			productopromocionAux.setprecio(productopromocionAux.getprecio()+productopromocion.getprecio());			
			productopromocionAux.setporcentaje(productopromocionAux.getporcentaje()+productopromocion.getporcentaje());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoPromocion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductoPromocionConstantesFunciones.getArrayColumnasGlobalesProductoPromocion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoPromocion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductoPromocionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductoPromocionConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductoPromocionConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductoPromocionConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductoPromocion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoPromocion> productopromocions,ProductoPromocion productopromocion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoPromocion productopromocionAux: productopromocions) {
			if(productopromocionAux!=null && productopromocion!=null) {
				if((productopromocionAux.getId()==null && productopromocion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productopromocionAux.getId()!=null && productopromocion.getId()!=null){
					if(productopromocionAux.getId().equals(productopromocion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoPromocion(List<ProductoPromocion> productopromocions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double cantidadTotal=0.0;
		Double precioTotal=0.0;
		Double porcentajeTotal=0.0;
	
		for(ProductoPromocion productopromocion: productopromocions) {			
			if(productopromocion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cantidadTotal+=productopromocion.getcantidad();
			precioTotal+=productopromocion.getprecio();
			porcentajeTotal+=productopromocion.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoPromocionConstantesFunciones.CANTIDAD);
		datoGeneral.setsDescripcion(ProductoPromocionConstantesFunciones.LABEL_CANTIDAD);
		datoGeneral.setdValorDouble(cantidadTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoPromocionConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(ProductoPromocionConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoPromocionConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(ProductoPromocionConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductoPromocion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductoPromocionConstantesFunciones.LABEL_ID, ProductoPromocionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoPromocionConstantesFunciones.LABEL_VERSIONROW, ProductoPromocionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoPromocionConstantesFunciones.LABEL_IDEMPRESA, ProductoPromocionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoPromocionConstantesFunciones.LABEL_IDSUCURSAL, ProductoPromocionConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoPromocionConstantesFunciones.LABEL_IDBODEGA, ProductoPromocionConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoPromocionConstantesFunciones.LABEL_IDPRODUCTO, ProductoPromocionConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoPromocionConstantesFunciones.LABEL_IDBODEGARELACION, ProductoPromocionConstantesFunciones.IDBODEGARELACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoPromocionConstantesFunciones.LABEL_IDPRODUCTORELACION, ProductoPromocionConstantesFunciones.IDPRODUCTORELACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoPromocionConstantesFunciones.LABEL_CANTIDAD, ProductoPromocionConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoPromocionConstantesFunciones.LABEL_PRECIO, ProductoPromocionConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoPromocionConstantesFunciones.LABEL_PORCENTAJE, ProductoPromocionConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoPromocionConstantesFunciones.LABEL_DESCRIPCION, ProductoPromocionConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoPromocionConstantesFunciones.LABEL_DESCRIPCION2, ProductoPromocionConstantesFunciones.DESCRIPCION2,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductoPromocion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductoPromocionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoPromocionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoPromocionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoPromocionConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoPromocionConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoPromocionConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoPromocionConstantesFunciones.IDBODEGARELACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoPromocionConstantesFunciones.IDPRODUCTORELACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoPromocionConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoPromocionConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoPromocionConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoPromocionConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoPromocionConstantesFunciones.DESCRIPCION2;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoPromocion() throws Exception  {
		return ProductoPromocionConstantesFunciones.getTiposSeleccionarProductoPromocion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoPromocion(Boolean conFk) throws Exception  {
		return ProductoPromocionConstantesFunciones.getTiposSeleccionarProductoPromocion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoPromocion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoPromocionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProductoPromocionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoPromocionConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProductoPromocionConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoPromocionConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ProductoPromocionConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoPromocionConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProductoPromocionConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoPromocionConstantesFunciones.LABEL_IDBODEGARELACION);
			reporte.setsDescripcion(ProductoPromocionConstantesFunciones.LABEL_IDBODEGARELACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoPromocionConstantesFunciones.LABEL_IDPRODUCTORELACION);
			reporte.setsDescripcion(ProductoPromocionConstantesFunciones.LABEL_IDPRODUCTORELACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoPromocionConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(ProductoPromocionConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoPromocionConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(ProductoPromocionConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoPromocionConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(ProductoPromocionConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoPromocionConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ProductoPromocionConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoPromocionConstantesFunciones.LABEL_DESCRIPCION2);
			reporte.setsDescripcion(ProductoPromocionConstantesFunciones.LABEL_DESCRIPCION2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductoPromocion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductoPromocion(ProductoPromocion productopromocionAux) throws Exception {
		
			productopromocionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productopromocionAux.getEmpresa()));
			productopromocionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productopromocionAux.getSucursal()));
			productopromocionAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productopromocionAux.getBodega()));
			productopromocionAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productopromocionAux.getProducto()));
			productopromocionAux.setbodegarelacion_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productopromocionAux.getBodegaRelacion()));
			productopromocionAux.setproductorelacion_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productopromocionAux.getProductoRelacion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductoPromocion(List<ProductoPromocion> productopromocionsTemp) throws Exception {
		for(ProductoPromocion productopromocionAux:productopromocionsTemp) {
			
			productopromocionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productopromocionAux.getEmpresa()));
			productopromocionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productopromocionAux.getSucursal()));
			productopromocionAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productopromocionAux.getBodega()));
			productopromocionAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productopromocionAux.getProducto()));
			productopromocionAux.setbodegarelacion_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productopromocionAux.getBodegaRelacion()));
			productopromocionAux.setproductorelacion_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productopromocionAux.getProductoRelacion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductoPromocion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Bodega.class));
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
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductoPromocion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
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

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoPromocion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoPromocionConstantesFunciones.getClassesRelationshipsOfProductoPromocion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoPromocion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoPromocion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoPromocionConstantesFunciones.getClassesRelationshipsFromStringsOfProductoPromocion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoPromocion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductoPromocion productopromocion,List<ProductoPromocion> productopromocions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProductoPromocion productopromocionEncontrado=null;
			
			for(ProductoPromocion productopromocionLocal:productopromocions) {
				if(productopromocionLocal.getId().equals(productopromocion.getId())) {
					productopromocionEncontrado=productopromocionLocal;
					
					productopromocionLocal.setIsChanged(productopromocion.getIsChanged());
					productopromocionLocal.setIsNew(productopromocion.getIsNew());
					productopromocionLocal.setIsDeleted(productopromocion.getIsDeleted());
					
					productopromocionLocal.setGeneralEntityOriginal(productopromocion.getGeneralEntityOriginal());
					
					productopromocionLocal.setId(productopromocion.getId());	
					productopromocionLocal.setVersionRow(productopromocion.getVersionRow());	
					productopromocionLocal.setid_empresa(productopromocion.getid_empresa());	
					productopromocionLocal.setid_sucursal(productopromocion.getid_sucursal());	
					productopromocionLocal.setid_bodega(productopromocion.getid_bodega());	
					productopromocionLocal.setid_producto(productopromocion.getid_producto());	
					productopromocionLocal.setid_bodega_relacion(productopromocion.getid_bodega_relacion());	
					productopromocionLocal.setid_producto_relacion(productopromocion.getid_producto_relacion());	
					productopromocionLocal.setcantidad(productopromocion.getcantidad());	
					productopromocionLocal.setprecio(productopromocion.getprecio());	
					productopromocionLocal.setporcentaje(productopromocion.getporcentaje());	
					productopromocionLocal.setdescripcion(productopromocion.getdescripcion());	
					productopromocionLocal.setdescripcion2(productopromocion.getdescripcion2());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!productopromocion.getIsDeleted()) {
				if(!existe) {
					productopromocions.add(productopromocion);
				}
			} else {
				if(productopromocionEncontrado!=null && permiteQuitar)  {
					productopromocions.remove(productopromocionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProductoPromocion productopromocion,List<ProductoPromocion> productopromocions) throws Exception {
		try	{			
			for(ProductoPromocion productopromocionLocal:productopromocions) {
				if(productopromocionLocal.getId().equals(productopromocion.getId())) {
					productopromocionLocal.setIsSelected(productopromocion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductoPromocion(List<ProductoPromocion> productopromocionsAux) throws Exception {
		//this.productopromocionsAux=productopromocionsAux;
		
		for(ProductoPromocion productopromocionAux:productopromocionsAux) {
			if(productopromocionAux.getIsChanged()) {
				productopromocionAux.setIsChanged(false);
			}		
			
			if(productopromocionAux.getIsNew()) {
				productopromocionAux.setIsNew(false);
			}	
			
			if(productopromocionAux.getIsDeleted()) {
				productopromocionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductoPromocion(ProductoPromocion productopromocionAux) throws Exception {
		//this.productopromocionAux=productopromocionAux;
		
			if(productopromocionAux.getIsChanged()) {
				productopromocionAux.setIsChanged(false);
			}		
			
			if(productopromocionAux.getIsNew()) {
				productopromocionAux.setIsNew(false);
			}	
			
			if(productopromocionAux.getIsDeleted()) {
				productopromocionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductoPromocion productopromocionAsignar,ProductoPromocion productopromocion) throws Exception {
		productopromocionAsignar.setId(productopromocion.getId());	
		productopromocionAsignar.setVersionRow(productopromocion.getVersionRow());	
		productopromocionAsignar.setid_empresa(productopromocion.getid_empresa());
		productopromocionAsignar.setempresa_descripcion(productopromocion.getempresa_descripcion());	
		productopromocionAsignar.setid_sucursal(productopromocion.getid_sucursal());
		productopromocionAsignar.setsucursal_descripcion(productopromocion.getsucursal_descripcion());	
		productopromocionAsignar.setid_bodega(productopromocion.getid_bodega());
		productopromocionAsignar.setbodega_descripcion(productopromocion.getbodega_descripcion());	
		productopromocionAsignar.setid_producto(productopromocion.getid_producto());
		productopromocionAsignar.setproducto_descripcion(productopromocion.getproducto_descripcion());	
		productopromocionAsignar.setid_bodega_relacion(productopromocion.getid_bodega_relacion());
		productopromocionAsignar.setbodegarelacion_descripcion(productopromocion.getbodegarelacion_descripcion());	
		productopromocionAsignar.setid_producto_relacion(productopromocion.getid_producto_relacion());
		productopromocionAsignar.setproductorelacion_descripcion(productopromocion.getproductorelacion_descripcion());	
		productopromocionAsignar.setcantidad(productopromocion.getcantidad());	
		productopromocionAsignar.setprecio(productopromocion.getprecio());	
		productopromocionAsignar.setporcentaje(productopromocion.getporcentaje());	
		productopromocionAsignar.setdescripcion(productopromocion.getdescripcion());	
		productopromocionAsignar.setdescripcion2(productopromocion.getdescripcion2());	
	}
	
	public static void inicializarProductoPromocion(ProductoPromocion productopromocion) throws Exception {
		try {
				productopromocion.setId(0L);	
					
				productopromocion.setid_empresa(-1L);	
				productopromocion.setid_sucursal(-1L);	
				productopromocion.setid_bodega(-1L);	
				productopromocion.setid_producto(-1L);	
				productopromocion.setid_bodega_relacion(-1L);	
				productopromocion.setid_producto_relacion(-1L);	
				productopromocion.setcantidad(0.0);	
				productopromocion.setprecio(0.0);	
				productopromocion.setporcentaje(0.0);	
				productopromocion.setdescripcion("");	
				productopromocion.setdescripcion2("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductoPromocion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoPromocionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoPromocionConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoPromocionConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoPromocionConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoPromocionConstantesFunciones.LABEL_IDBODEGARELACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoPromocionConstantesFunciones.LABEL_IDPRODUCTORELACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoPromocionConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoPromocionConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoPromocionConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoPromocionConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoPromocionConstantesFunciones.LABEL_DESCRIPCION2);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductoPromocion(String sTipo,Row row,Workbook workbook,ProductoPromocion productopromocion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productopromocion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productopromocion.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productopromocion.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productopromocion.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productopromocion.getbodegarelacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productopromocion.getproductorelacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productopromocion.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productopromocion.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productopromocion.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productopromocion.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productopromocion.getdescripcion2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductoPromocion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProductoPromocion() {
		return this.sFinalQueryProductoPromocion;
	}
	
	public void setsFinalQueryProductoPromocion(String sFinalQueryProductoPromocion) {
		this.sFinalQueryProductoPromocion= sFinalQueryProductoPromocion;
	}
	
	public Border resaltarSeleccionarProductoPromocion=null;
	
	public Border setResaltarSeleccionarProductoPromocion(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPromocionBeanSwingJInternalFrame productopromocionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productopromocionBeanSwingJInternalFrame.jTtoolBarProductoPromocion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductoPromocion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductoPromocion() {
		return this.resaltarSeleccionarProductoPromocion;
	}
	
	public void setResaltarSeleccionarProductoPromocion(Border borderResaltarSeleccionarProductoPromocion) {
		this.resaltarSeleccionarProductoPromocion= borderResaltarSeleccionarProductoPromocion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductoPromocion=null;
	public Boolean mostraridProductoPromocion=true;
	public Boolean activaridProductoPromocion=true;

	public Border resaltarid_empresaProductoPromocion=null;
	public Boolean mostrarid_empresaProductoPromocion=true;
	public Boolean activarid_empresaProductoPromocion=true;
	public Boolean cargarid_empresaProductoPromocion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProductoPromocion=false;//ConEventDepend=true

	public Border resaltarid_sucursalProductoPromocion=null;
	public Boolean mostrarid_sucursalProductoPromocion=true;
	public Boolean activarid_sucursalProductoPromocion=true;
	public Boolean cargarid_sucursalProductoPromocion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProductoPromocion=false;//ConEventDepend=true

	public Border resaltarid_bodegaProductoPromocion=null;
	public Boolean mostrarid_bodegaProductoPromocion=true;
	public Boolean activarid_bodegaProductoPromocion=true;
	public Boolean cargarid_bodegaProductoPromocion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaProductoPromocion=false;//ConEventDepend=true

	public Border resaltarid_productoProductoPromocion=null;
	public Boolean mostrarid_productoProductoPromocion=true;
	public Boolean activarid_productoProductoPromocion=true;
	public Boolean cargarid_productoProductoPromocion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProductoPromocion=false;//ConEventDepend=true

	public Border resaltarid_bodega_relacionProductoPromocion=null;
	public Boolean mostrarid_bodega_relacionProductoPromocion=true;
	public Boolean activarid_bodega_relacionProductoPromocion=true;
	public Boolean cargarid_bodega_relacionProductoPromocion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodega_relacionProductoPromocion=false;//ConEventDepend=true

	public Border resaltarid_producto_relacionProductoPromocion=null;
	public Boolean mostrarid_producto_relacionProductoPromocion=true;
	public Boolean activarid_producto_relacionProductoPromocion=true;
	public Boolean cargarid_producto_relacionProductoPromocion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_producto_relacionProductoPromocion=false;//ConEventDepend=true

	public Border resaltarcantidadProductoPromocion=null;
	public Boolean mostrarcantidadProductoPromocion=true;
	public Boolean activarcantidadProductoPromocion=true;

	public Border resaltarprecioProductoPromocion=null;
	public Boolean mostrarprecioProductoPromocion=true;
	public Boolean activarprecioProductoPromocion=true;

	public Border resaltarporcentajeProductoPromocion=null;
	public Boolean mostrarporcentajeProductoPromocion=true;
	public Boolean activarporcentajeProductoPromocion=true;

	public Border resaltardescripcionProductoPromocion=null;
	public Boolean mostrardescripcionProductoPromocion=true;
	public Boolean activardescripcionProductoPromocion=true;

	public Border resaltardescripcion2ProductoPromocion=null;
	public Boolean mostrardescripcion2ProductoPromocion=true;
	public Boolean activardescripcion2ProductoPromocion=true;

	
	

	public Border setResaltaridProductoPromocion(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPromocionBeanSwingJInternalFrame productopromocionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productopromocionBeanSwingJInternalFrame.jTtoolBarProductoPromocion.setBorder(borderResaltar);
		
		this.resaltaridProductoPromocion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductoPromocion() {
		return this.resaltaridProductoPromocion;
	}

	public void setResaltaridProductoPromocion(Border borderResaltar) {
		this.resaltaridProductoPromocion= borderResaltar;
	}

	public Boolean getMostraridProductoPromocion() {
		return this.mostraridProductoPromocion;
	}

	public void setMostraridProductoPromocion(Boolean mostraridProductoPromocion) {
		this.mostraridProductoPromocion= mostraridProductoPromocion;
	}

	public Boolean getActivaridProductoPromocion() {
		return this.activaridProductoPromocion;
	}

	public void setActivaridProductoPromocion(Boolean activaridProductoPromocion) {
		this.activaridProductoPromocion= activaridProductoPromocion;
	}

	public Border setResaltarid_empresaProductoPromocion(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPromocionBeanSwingJInternalFrame productopromocionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productopromocionBeanSwingJInternalFrame.jTtoolBarProductoPromocion.setBorder(borderResaltar);
		
		this.resaltarid_empresaProductoPromocion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProductoPromocion() {
		return this.resaltarid_empresaProductoPromocion;
	}

	public void setResaltarid_empresaProductoPromocion(Border borderResaltar) {
		this.resaltarid_empresaProductoPromocion= borderResaltar;
	}

	public Boolean getMostrarid_empresaProductoPromocion() {
		return this.mostrarid_empresaProductoPromocion;
	}

	public void setMostrarid_empresaProductoPromocion(Boolean mostrarid_empresaProductoPromocion) {
		this.mostrarid_empresaProductoPromocion= mostrarid_empresaProductoPromocion;
	}

	public Boolean getActivarid_empresaProductoPromocion() {
		return this.activarid_empresaProductoPromocion;
	}

	public void setActivarid_empresaProductoPromocion(Boolean activarid_empresaProductoPromocion) {
		this.activarid_empresaProductoPromocion= activarid_empresaProductoPromocion;
	}

	public Boolean getCargarid_empresaProductoPromocion() {
		return this.cargarid_empresaProductoPromocion;
	}

	public void setCargarid_empresaProductoPromocion(Boolean cargarid_empresaProductoPromocion) {
		this.cargarid_empresaProductoPromocion= cargarid_empresaProductoPromocion;
	}

	public Border setResaltarid_sucursalProductoPromocion(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPromocionBeanSwingJInternalFrame productopromocionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productopromocionBeanSwingJInternalFrame.jTtoolBarProductoPromocion.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProductoPromocion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProductoPromocion() {
		return this.resaltarid_sucursalProductoPromocion;
	}

	public void setResaltarid_sucursalProductoPromocion(Border borderResaltar) {
		this.resaltarid_sucursalProductoPromocion= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProductoPromocion() {
		return this.mostrarid_sucursalProductoPromocion;
	}

	public void setMostrarid_sucursalProductoPromocion(Boolean mostrarid_sucursalProductoPromocion) {
		this.mostrarid_sucursalProductoPromocion= mostrarid_sucursalProductoPromocion;
	}

	public Boolean getActivarid_sucursalProductoPromocion() {
		return this.activarid_sucursalProductoPromocion;
	}

	public void setActivarid_sucursalProductoPromocion(Boolean activarid_sucursalProductoPromocion) {
		this.activarid_sucursalProductoPromocion= activarid_sucursalProductoPromocion;
	}

	public Boolean getCargarid_sucursalProductoPromocion() {
		return this.cargarid_sucursalProductoPromocion;
	}

	public void setCargarid_sucursalProductoPromocion(Boolean cargarid_sucursalProductoPromocion) {
		this.cargarid_sucursalProductoPromocion= cargarid_sucursalProductoPromocion;
	}

	public Border setResaltarid_bodegaProductoPromocion(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPromocionBeanSwingJInternalFrame productopromocionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productopromocionBeanSwingJInternalFrame.jTtoolBarProductoPromocion.setBorder(borderResaltar);
		
		this.resaltarid_bodegaProductoPromocion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaProductoPromocion() {
		return this.resaltarid_bodegaProductoPromocion;
	}

	public void setResaltarid_bodegaProductoPromocion(Border borderResaltar) {
		this.resaltarid_bodegaProductoPromocion= borderResaltar;
	}

	public Boolean getMostrarid_bodegaProductoPromocion() {
		return this.mostrarid_bodegaProductoPromocion;
	}

	public void setMostrarid_bodegaProductoPromocion(Boolean mostrarid_bodegaProductoPromocion) {
		this.mostrarid_bodegaProductoPromocion= mostrarid_bodegaProductoPromocion;
	}

	public Boolean getActivarid_bodegaProductoPromocion() {
		return this.activarid_bodegaProductoPromocion;
	}

	public void setActivarid_bodegaProductoPromocion(Boolean activarid_bodegaProductoPromocion) {
		this.activarid_bodegaProductoPromocion= activarid_bodegaProductoPromocion;
	}

	public Boolean getCargarid_bodegaProductoPromocion() {
		return this.cargarid_bodegaProductoPromocion;
	}

	public void setCargarid_bodegaProductoPromocion(Boolean cargarid_bodegaProductoPromocion) {
		this.cargarid_bodegaProductoPromocion= cargarid_bodegaProductoPromocion;
	}

	public Border setResaltarid_productoProductoPromocion(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPromocionBeanSwingJInternalFrame productopromocionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productopromocionBeanSwingJInternalFrame.jTtoolBarProductoPromocion.setBorder(borderResaltar);
		
		this.resaltarid_productoProductoPromocion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProductoPromocion() {
		return this.resaltarid_productoProductoPromocion;
	}

	public void setResaltarid_productoProductoPromocion(Border borderResaltar) {
		this.resaltarid_productoProductoPromocion= borderResaltar;
	}

	public Boolean getMostrarid_productoProductoPromocion() {
		return this.mostrarid_productoProductoPromocion;
	}

	public void setMostrarid_productoProductoPromocion(Boolean mostrarid_productoProductoPromocion) {
		this.mostrarid_productoProductoPromocion= mostrarid_productoProductoPromocion;
	}

	public Boolean getActivarid_productoProductoPromocion() {
		return this.activarid_productoProductoPromocion;
	}

	public void setActivarid_productoProductoPromocion(Boolean activarid_productoProductoPromocion) {
		this.activarid_productoProductoPromocion= activarid_productoProductoPromocion;
	}

	public Boolean getCargarid_productoProductoPromocion() {
		return this.cargarid_productoProductoPromocion;
	}

	public void setCargarid_productoProductoPromocion(Boolean cargarid_productoProductoPromocion) {
		this.cargarid_productoProductoPromocion= cargarid_productoProductoPromocion;
	}

	public Border setResaltarid_bodega_relacionProductoPromocion(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPromocionBeanSwingJInternalFrame productopromocionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productopromocionBeanSwingJInternalFrame.jTtoolBarProductoPromocion.setBorder(borderResaltar);
		
		this.resaltarid_bodega_relacionProductoPromocion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodega_relacionProductoPromocion() {
		return this.resaltarid_bodega_relacionProductoPromocion;
	}

	public void setResaltarid_bodega_relacionProductoPromocion(Border borderResaltar) {
		this.resaltarid_bodega_relacionProductoPromocion= borderResaltar;
	}

	public Boolean getMostrarid_bodega_relacionProductoPromocion() {
		return this.mostrarid_bodega_relacionProductoPromocion;
	}

	public void setMostrarid_bodega_relacionProductoPromocion(Boolean mostrarid_bodega_relacionProductoPromocion) {
		this.mostrarid_bodega_relacionProductoPromocion= mostrarid_bodega_relacionProductoPromocion;
	}

	public Boolean getActivarid_bodega_relacionProductoPromocion() {
		return this.activarid_bodega_relacionProductoPromocion;
	}

	public void setActivarid_bodega_relacionProductoPromocion(Boolean activarid_bodega_relacionProductoPromocion) {
		this.activarid_bodega_relacionProductoPromocion= activarid_bodega_relacionProductoPromocion;
	}

	public Boolean getCargarid_bodega_relacionProductoPromocion() {
		return this.cargarid_bodega_relacionProductoPromocion;
	}

	public void setCargarid_bodega_relacionProductoPromocion(Boolean cargarid_bodega_relacionProductoPromocion) {
		this.cargarid_bodega_relacionProductoPromocion= cargarid_bodega_relacionProductoPromocion;
	}

	public Border setResaltarid_producto_relacionProductoPromocion(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPromocionBeanSwingJInternalFrame productopromocionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productopromocionBeanSwingJInternalFrame.jTtoolBarProductoPromocion.setBorder(borderResaltar);
		
		this.resaltarid_producto_relacionProductoPromocion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_producto_relacionProductoPromocion() {
		return this.resaltarid_producto_relacionProductoPromocion;
	}

	public void setResaltarid_producto_relacionProductoPromocion(Border borderResaltar) {
		this.resaltarid_producto_relacionProductoPromocion= borderResaltar;
	}

	public Boolean getMostrarid_producto_relacionProductoPromocion() {
		return this.mostrarid_producto_relacionProductoPromocion;
	}

	public void setMostrarid_producto_relacionProductoPromocion(Boolean mostrarid_producto_relacionProductoPromocion) {
		this.mostrarid_producto_relacionProductoPromocion= mostrarid_producto_relacionProductoPromocion;
	}

	public Boolean getActivarid_producto_relacionProductoPromocion() {
		return this.activarid_producto_relacionProductoPromocion;
	}

	public void setActivarid_producto_relacionProductoPromocion(Boolean activarid_producto_relacionProductoPromocion) {
		this.activarid_producto_relacionProductoPromocion= activarid_producto_relacionProductoPromocion;
	}

	public Boolean getCargarid_producto_relacionProductoPromocion() {
		return this.cargarid_producto_relacionProductoPromocion;
	}

	public void setCargarid_producto_relacionProductoPromocion(Boolean cargarid_producto_relacionProductoPromocion) {
		this.cargarid_producto_relacionProductoPromocion= cargarid_producto_relacionProductoPromocion;
	}

	public Border setResaltarcantidadProductoPromocion(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPromocionBeanSwingJInternalFrame productopromocionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productopromocionBeanSwingJInternalFrame.jTtoolBarProductoPromocion.setBorder(borderResaltar);
		
		this.resaltarcantidadProductoPromocion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadProductoPromocion() {
		return this.resaltarcantidadProductoPromocion;
	}

	public void setResaltarcantidadProductoPromocion(Border borderResaltar) {
		this.resaltarcantidadProductoPromocion= borderResaltar;
	}

	public Boolean getMostrarcantidadProductoPromocion() {
		return this.mostrarcantidadProductoPromocion;
	}

	public void setMostrarcantidadProductoPromocion(Boolean mostrarcantidadProductoPromocion) {
		this.mostrarcantidadProductoPromocion= mostrarcantidadProductoPromocion;
	}

	public Boolean getActivarcantidadProductoPromocion() {
		return this.activarcantidadProductoPromocion;
	}

	public void setActivarcantidadProductoPromocion(Boolean activarcantidadProductoPromocion) {
		this.activarcantidadProductoPromocion= activarcantidadProductoPromocion;
	}

	public Border setResaltarprecioProductoPromocion(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPromocionBeanSwingJInternalFrame productopromocionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productopromocionBeanSwingJInternalFrame.jTtoolBarProductoPromocion.setBorder(borderResaltar);
		
		this.resaltarprecioProductoPromocion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioProductoPromocion() {
		return this.resaltarprecioProductoPromocion;
	}

	public void setResaltarprecioProductoPromocion(Border borderResaltar) {
		this.resaltarprecioProductoPromocion= borderResaltar;
	}

	public Boolean getMostrarprecioProductoPromocion() {
		return this.mostrarprecioProductoPromocion;
	}

	public void setMostrarprecioProductoPromocion(Boolean mostrarprecioProductoPromocion) {
		this.mostrarprecioProductoPromocion= mostrarprecioProductoPromocion;
	}

	public Boolean getActivarprecioProductoPromocion() {
		return this.activarprecioProductoPromocion;
	}

	public void setActivarprecioProductoPromocion(Boolean activarprecioProductoPromocion) {
		this.activarprecioProductoPromocion= activarprecioProductoPromocion;
	}

	public Border setResaltarporcentajeProductoPromocion(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPromocionBeanSwingJInternalFrame productopromocionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productopromocionBeanSwingJInternalFrame.jTtoolBarProductoPromocion.setBorder(borderResaltar);
		
		this.resaltarporcentajeProductoPromocion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeProductoPromocion() {
		return this.resaltarporcentajeProductoPromocion;
	}

	public void setResaltarporcentajeProductoPromocion(Border borderResaltar) {
		this.resaltarporcentajeProductoPromocion= borderResaltar;
	}

	public Boolean getMostrarporcentajeProductoPromocion() {
		return this.mostrarporcentajeProductoPromocion;
	}

	public void setMostrarporcentajeProductoPromocion(Boolean mostrarporcentajeProductoPromocion) {
		this.mostrarporcentajeProductoPromocion= mostrarporcentajeProductoPromocion;
	}

	public Boolean getActivarporcentajeProductoPromocion() {
		return this.activarporcentajeProductoPromocion;
	}

	public void setActivarporcentajeProductoPromocion(Boolean activarporcentajeProductoPromocion) {
		this.activarporcentajeProductoPromocion= activarporcentajeProductoPromocion;
	}

	public Border setResaltardescripcionProductoPromocion(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPromocionBeanSwingJInternalFrame productopromocionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productopromocionBeanSwingJInternalFrame.jTtoolBarProductoPromocion.setBorder(borderResaltar);
		
		this.resaltardescripcionProductoPromocion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionProductoPromocion() {
		return this.resaltardescripcionProductoPromocion;
	}

	public void setResaltardescripcionProductoPromocion(Border borderResaltar) {
		this.resaltardescripcionProductoPromocion= borderResaltar;
	}

	public Boolean getMostrardescripcionProductoPromocion() {
		return this.mostrardescripcionProductoPromocion;
	}

	public void setMostrardescripcionProductoPromocion(Boolean mostrardescripcionProductoPromocion) {
		this.mostrardescripcionProductoPromocion= mostrardescripcionProductoPromocion;
	}

	public Boolean getActivardescripcionProductoPromocion() {
		return this.activardescripcionProductoPromocion;
	}

	public void setActivardescripcionProductoPromocion(Boolean activardescripcionProductoPromocion) {
		this.activardescripcionProductoPromocion= activardescripcionProductoPromocion;
	}

	public Border setResaltardescripcion2ProductoPromocion(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPromocionBeanSwingJInternalFrame productopromocionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productopromocionBeanSwingJInternalFrame.jTtoolBarProductoPromocion.setBorder(borderResaltar);
		
		this.resaltardescripcion2ProductoPromocion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcion2ProductoPromocion() {
		return this.resaltardescripcion2ProductoPromocion;
	}

	public void setResaltardescripcion2ProductoPromocion(Border borderResaltar) {
		this.resaltardescripcion2ProductoPromocion= borderResaltar;
	}

	public Boolean getMostrardescripcion2ProductoPromocion() {
		return this.mostrardescripcion2ProductoPromocion;
	}

	public void setMostrardescripcion2ProductoPromocion(Boolean mostrardescripcion2ProductoPromocion) {
		this.mostrardescripcion2ProductoPromocion= mostrardescripcion2ProductoPromocion;
	}

	public Boolean getActivardescripcion2ProductoPromocion() {
		return this.activardescripcion2ProductoPromocion;
	}

	public void setActivardescripcion2ProductoPromocion(Boolean activardescripcion2ProductoPromocion) {
		this.activardescripcion2ProductoPromocion= activardescripcion2ProductoPromocion;
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
		
		
		this.setMostraridProductoPromocion(esInicial);
		this.setMostrarid_empresaProductoPromocion(esInicial);
		this.setMostrarid_sucursalProductoPromocion(esInicial);
		this.setMostrarid_bodegaProductoPromocion(esInicial);
		this.setMostrarid_productoProductoPromocion(esInicial);
		this.setMostrarid_bodega_relacionProductoPromocion(esInicial);
		this.setMostrarid_producto_relacionProductoPromocion(esInicial);
		this.setMostrarcantidadProductoPromocion(esInicial);
		this.setMostrarprecioProductoPromocion(esInicial);
		this.setMostrarporcentajeProductoPromocion(esInicial);
		this.setMostrardescripcionProductoPromocion(esInicial);
		this.setMostrardescripcion2ProductoPromocion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.ID)) {
				this.setMostraridProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.IDBODEGARELACION)) {
				this.setMostrarid_bodega_relacionProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.IDPRODUCTORELACION)) {
				this.setMostrarid_producto_relacionProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.PRECIO)) {
				this.setMostrarprecioProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.DESCRIPCION2)) {
				this.setMostrardescripcion2ProductoPromocion(esAsigna);
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
		
		
		this.setActivaridProductoPromocion(esInicial);
		this.setActivarid_empresaProductoPromocion(esInicial);
		this.setActivarid_sucursalProductoPromocion(esInicial);
		this.setActivarid_bodegaProductoPromocion(esInicial);
		this.setActivarid_productoProductoPromocion(esInicial);
		this.setActivarid_bodega_relacionProductoPromocion(esInicial);
		this.setActivarid_producto_relacionProductoPromocion(esInicial);
		this.setActivarcantidadProductoPromocion(esInicial);
		this.setActivarprecioProductoPromocion(esInicial);
		this.setActivarporcentajeProductoPromocion(esInicial);
		this.setActivardescripcionProductoPromocion(esInicial);
		this.setActivardescripcion2ProductoPromocion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.ID)) {
				this.setActivaridProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.IDBODEGARELACION)) {
				this.setActivarid_bodega_relacionProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.IDPRODUCTORELACION)) {
				this.setActivarid_producto_relacionProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.PRECIO)) {
				this.setActivarprecioProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.DESCRIPCION2)) {
				this.setActivardescripcion2ProductoPromocion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoPromocionBeanSwingJInternalFrame productopromocionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductoPromocion(esInicial);
		this.setResaltarid_empresaProductoPromocion(esInicial);
		this.setResaltarid_sucursalProductoPromocion(esInicial);
		this.setResaltarid_bodegaProductoPromocion(esInicial);
		this.setResaltarid_productoProductoPromocion(esInicial);
		this.setResaltarid_bodega_relacionProductoPromocion(esInicial);
		this.setResaltarid_producto_relacionProductoPromocion(esInicial);
		this.setResaltarcantidadProductoPromocion(esInicial);
		this.setResaltarprecioProductoPromocion(esInicial);
		this.setResaltarporcentajeProductoPromocion(esInicial);
		this.setResaltardescripcionProductoPromocion(esInicial);
		this.setResaltardescripcion2ProductoPromocion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.ID)) {
				this.setResaltaridProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.IDBODEGARELACION)) {
				this.setResaltarid_bodega_relacionProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.IDPRODUCTORELACION)) {
				this.setResaltarid_producto_relacionProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.PRECIO)) {
				this.setResaltarprecioProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionProductoPromocion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPromocionConstantesFunciones.DESCRIPCION2)) {
				this.setResaltardescripcion2ProductoPromocion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoPromocionBeanSwingJInternalFrame productopromocionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaProductoPromocion=true;

	public Boolean getMostrarFK_IdBodegaProductoPromocion() {
		return this.mostrarFK_IdBodegaProductoPromocion;
	}

	public void setMostrarFK_IdBodegaProductoPromocion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaProductoPromocion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBodegaRelacionProductoPromocion=true;

	public Boolean getMostrarFK_IdBodegaRelacionProductoPromocion() {
		return this.mostrarFK_IdBodegaRelacionProductoPromocion;
	}

	public void setMostrarFK_IdBodegaRelacionProductoPromocion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaRelacionProductoPromocion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaProductoPromocion=true;

	public Boolean getMostrarFK_IdEmpresaProductoPromocion() {
		return this.mostrarFK_IdEmpresaProductoPromocion;
	}

	public void setMostrarFK_IdEmpresaProductoPromocion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaProductoPromocion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoProductoPromocion=true;

	public Boolean getMostrarFK_IdProductoProductoPromocion() {
		return this.mostrarFK_IdProductoProductoPromocion;
	}

	public void setMostrarFK_IdProductoProductoPromocion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoProductoPromocion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoRelacionProductoPromocion=true;

	public Boolean getMostrarFK_IdProductoRelacionProductoPromocion() {
		return this.mostrarFK_IdProductoRelacionProductoPromocion;
	}

	public void setMostrarFK_IdProductoRelacionProductoPromocion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoRelacionProductoPromocion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalProductoPromocion=true;

	public Boolean getMostrarFK_IdSucursalProductoPromocion() {
		return this.mostrarFK_IdSucursalProductoPromocion;
	}

	public void setMostrarFK_IdSucursalProductoPromocion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalProductoPromocion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaProductoPromocion=true;

	public Boolean getActivarFK_IdBodegaProductoPromocion() {
		return this.activarFK_IdBodegaProductoPromocion;
	}

	public void setActivarFK_IdBodegaProductoPromocion(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaProductoPromocion= habilitarResaltar;
	}

	public Boolean activarFK_IdBodegaRelacionProductoPromocion=true;

	public Boolean getActivarFK_IdBodegaRelacionProductoPromocion() {
		return this.activarFK_IdBodegaRelacionProductoPromocion;
	}

	public void setActivarFK_IdBodegaRelacionProductoPromocion(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaRelacionProductoPromocion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaProductoPromocion=true;

	public Boolean getActivarFK_IdEmpresaProductoPromocion() {
		return this.activarFK_IdEmpresaProductoPromocion;
	}

	public void setActivarFK_IdEmpresaProductoPromocion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaProductoPromocion= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoProductoPromocion=true;

	public Boolean getActivarFK_IdProductoProductoPromocion() {
		return this.activarFK_IdProductoProductoPromocion;
	}

	public void setActivarFK_IdProductoProductoPromocion(Boolean habilitarResaltar) {
		this.activarFK_IdProductoProductoPromocion= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoRelacionProductoPromocion=true;

	public Boolean getActivarFK_IdProductoRelacionProductoPromocion() {
		return this.activarFK_IdProductoRelacionProductoPromocion;
	}

	public void setActivarFK_IdProductoRelacionProductoPromocion(Boolean habilitarResaltar) {
		this.activarFK_IdProductoRelacionProductoPromocion= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalProductoPromocion=true;

	public Boolean getActivarFK_IdSucursalProductoPromocion() {
		return this.activarFK_IdSucursalProductoPromocion;
	}

	public void setActivarFK_IdSucursalProductoPromocion(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalProductoPromocion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaProductoPromocion=null;

	public Border getResaltarFK_IdBodegaProductoPromocion() {
		return this.resaltarFK_IdBodegaProductoPromocion;
	}

	public void setResaltarFK_IdBodegaProductoPromocion(Border borderResaltar) {
		this.resaltarFK_IdBodegaProductoPromocion= borderResaltar;
	}

	public void setResaltarFK_IdBodegaProductoPromocion(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPromocionBeanSwingJInternalFrame productopromocionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaProductoPromocion= borderResaltar;
	}

	public Border resaltarFK_IdBodegaRelacionProductoPromocion=null;

	public Border getResaltarFK_IdBodegaRelacionProductoPromocion() {
		return this.resaltarFK_IdBodegaRelacionProductoPromocion;
	}

	public void setResaltarFK_IdBodegaRelacionProductoPromocion(Border borderResaltar) {
		this.resaltarFK_IdBodegaRelacionProductoPromocion= borderResaltar;
	}

	public void setResaltarFK_IdBodegaRelacionProductoPromocion(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPromocionBeanSwingJInternalFrame productopromocionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaRelacionProductoPromocion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaProductoPromocion=null;

	public Border getResaltarFK_IdEmpresaProductoPromocion() {
		return this.resaltarFK_IdEmpresaProductoPromocion;
	}

	public void setResaltarFK_IdEmpresaProductoPromocion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaProductoPromocion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaProductoPromocion(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPromocionBeanSwingJInternalFrame productopromocionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaProductoPromocion= borderResaltar;
	}

	public Border resaltarFK_IdProductoProductoPromocion=null;

	public Border getResaltarFK_IdProductoProductoPromocion() {
		return this.resaltarFK_IdProductoProductoPromocion;
	}

	public void setResaltarFK_IdProductoProductoPromocion(Border borderResaltar) {
		this.resaltarFK_IdProductoProductoPromocion= borderResaltar;
	}

	public void setResaltarFK_IdProductoProductoPromocion(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPromocionBeanSwingJInternalFrame productopromocionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoProductoPromocion= borderResaltar;
	}

	public Border resaltarFK_IdProductoRelacionProductoPromocion=null;

	public Border getResaltarFK_IdProductoRelacionProductoPromocion() {
		return this.resaltarFK_IdProductoRelacionProductoPromocion;
	}

	public void setResaltarFK_IdProductoRelacionProductoPromocion(Border borderResaltar) {
		this.resaltarFK_IdProductoRelacionProductoPromocion= borderResaltar;
	}

	public void setResaltarFK_IdProductoRelacionProductoPromocion(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPromocionBeanSwingJInternalFrame productopromocionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoRelacionProductoPromocion= borderResaltar;
	}

	public Border resaltarFK_IdSucursalProductoPromocion=null;

	public Border getResaltarFK_IdSucursalProductoPromocion() {
		return this.resaltarFK_IdSucursalProductoPromocion;
	}

	public void setResaltarFK_IdSucursalProductoPromocion(Border borderResaltar) {
		this.resaltarFK_IdSucursalProductoPromocion= borderResaltar;
	}

	public void setResaltarFK_IdSucursalProductoPromocion(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPromocionBeanSwingJInternalFrame productopromocionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalProductoPromocion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}