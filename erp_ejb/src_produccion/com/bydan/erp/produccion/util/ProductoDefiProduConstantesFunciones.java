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
package com.bydan.erp.produccion.util;

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


import com.bydan.erp.produccion.util.ProductoDefiProduConstantesFunciones;
import com.bydan.erp.produccion.util.ProductoDefiProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProductoDefiProduParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProductoDefiProduConstantesFunciones extends ProductoDefiProduConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProductoDefiProdu";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductoDefiProdu"+ProductoDefiProduConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductoDefiProduHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductoDefiProduHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductoDefiProduConstantesFunciones.SCHEMA+"_"+ProductoDefiProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductoDefiProduHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductoDefiProduConstantesFunciones.SCHEMA+"_"+ProductoDefiProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductoDefiProduConstantesFunciones.SCHEMA+"_"+ProductoDefiProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductoDefiProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductoDefiProduConstantesFunciones.SCHEMA+"_"+ProductoDefiProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoDefiProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoDefiProduHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoDefiProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoDefiProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoDefiProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoDefiProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductoDefiProduConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductoDefiProduConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductoDefiProduConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductoDefiProduConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Producto Definicion Producciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Producto Definicion Produccion";
	public static final String SCLASSWEBTITULO_LOWER="Producto Defi Produ";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductoDefiProdu";
	public static final String OBJECTNAME="productodefiprodu";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="producto_defi_produ";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productodefiprodu from "+ProductoDefiProduConstantesFunciones.SPERSISTENCENAME+" productodefiprodu";
	public static String QUERYSELECTNATIVE="select "+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+".id,"+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+".version_row,"+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+".id_empresa,"+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+".id_sucursal,"+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+".id_bodega,"+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+".id_producto,"+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+".id_unidad,"+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+".con_genera_sub_productos,"+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+".descripcion from "+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME;//+" as "+ProductoDefiProduConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProductoDefiProduConstantesFuncionesAdditional productodefiproduConstantesFuncionesAdditional=null;
	
	public ProductoDefiProduConstantesFuncionesAdditional getProductoDefiProduConstantesFuncionesAdditional() {
		return this.productodefiproduConstantesFuncionesAdditional;
	}
	
	public void setProductoDefiProduConstantesFuncionesAdditional(ProductoDefiProduConstantesFuncionesAdditional productodefiproduConstantesFuncionesAdditional) {
		try {
			this.productodefiproduConstantesFuncionesAdditional=productodefiproduConstantesFuncionesAdditional;
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
    public static final String IDUNIDAD= "id_unidad";
    public static final String CONGENERASUBPRODUCTOS= "con_genera_sub_productos";
    public static final String DESCRIPCION= "descripcion";
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
    	public static final String LABEL_IDUNIDAD= "Unad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_CONGENERASUBPRODUCTOS= "Con Genera Sub Productos";
		public static final String LABEL_CONGENERASUBPRODUCTOS_LOWER= "Con Genera Sub Productos";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProductoDefiProduLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductoDefiProduConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProductoDefiProduConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProductoDefiProduConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProductoDefiProduConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProductoDefiProduConstantesFunciones.IDBODEGA)) {sLabelColumna=ProductoDefiProduConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ProductoDefiProduConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProductoDefiProduConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProductoDefiProduConstantesFunciones.IDUNIDAD)) {sLabelColumna=ProductoDefiProduConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(ProductoDefiProduConstantesFunciones.CONGENERASUBPRODUCTOS)) {sLabelColumna=ProductoDefiProduConstantesFunciones.LABEL_CONGENERASUBPRODUCTOS;}
		if(sNombreColumna.equals(ProductoDefiProduConstantesFunciones.DESCRIPCION)) {sLabelColumna=ProductoDefiProduConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
		
	public static String getcon_genera_sub_productosDescripcion(ProductoDefiProdu productodefiprodu) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!productodefiprodu.getcon_genera_sub_productos()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_genera_sub_productosHtmlDescripcion(ProductoDefiProdu productodefiprodu) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(productodefiprodu.getId(),productodefiprodu.getcon_genera_sub_productos());

		return sDescripcion;
	}	
			
	
	public static String getProductoDefiProduDescripcion(ProductoDefiProdu productodefiprodu) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productodefiprodu !=null/* && productodefiprodu.getId()!=0*/) {
			sDescripcion=productodefiprodu.getid_producto().toString();//productodefiproduproductodefiprodu.getid_producto().toString().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProductoDefiProduDescripcionDetallado(ProductoDefiProdu productodefiprodu) {
		String sDescripcion="";
			
		sDescripcion+=ProductoDefiProduConstantesFunciones.ID+"=";
		sDescripcion+=productodefiprodu.getId().toString()+",";
		sDescripcion+=ProductoDefiProduConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productodefiprodu.getVersionRow().toString()+",";
		sDescripcion+=ProductoDefiProduConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=productodefiprodu.getid_empresa().toString()+",";
		sDescripcion+=ProductoDefiProduConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=productodefiprodu.getid_sucursal().toString()+",";
		sDescripcion+=ProductoDefiProduConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=productodefiprodu.getid_bodega().toString()+",";
		sDescripcion+=ProductoDefiProduConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=productodefiprodu.getid_producto().toString()+",";
		sDescripcion+=ProductoDefiProduConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=productodefiprodu.getid_unidad().toString()+",";
		sDescripcion+=ProductoDefiProduConstantesFunciones.CONGENERASUBPRODUCTOS+"=";
		sDescripcion+=productodefiprodu.getcon_genera_sub_productos().toString()+",";
		sDescripcion+=ProductoDefiProduConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=productodefiprodu.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setProductoDefiProduDescripcion(ProductoDefiProdu productodefiprodu,String sValor) throws Exception {			
		if(productodefiprodu !=null) {
			;//productodefiproduproductodefiprodu.getid_producto().toString().trim();
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

	public static String getUnidadDescripcion(Unidad unidad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(unidad!=null/*&&unidad.getId()>0*/) {
			sDescripcion=UnidadConstantesFunciones.getUnidadDescripcion(unidad);
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdUnidadUnad")) {
			sNombreIndice="Tipo=  Por Unad";
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

	public static String getDetalleIndiceFK_IdUnidadUnad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProductoDefiProdu(ProductoDefiProdu productodefiprodu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productodefiprodu.setdescripcion(productodefiprodu.getdescripcion().trim());
	}
	
	public static void quitarEspaciosProductoDefiProdus(List<ProductoDefiProdu> productodefiprodus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoDefiProdu productodefiprodu: productodefiprodus) {
			productodefiprodu.setdescripcion(productodefiprodu.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoDefiProdu(ProductoDefiProdu productodefiprodu,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productodefiprodu.getConCambioAuxiliar()) {
			productodefiprodu.setIsDeleted(productodefiprodu.getIsDeletedAuxiliar());	
			productodefiprodu.setIsNew(productodefiprodu.getIsNewAuxiliar());	
			productodefiprodu.setIsChanged(productodefiprodu.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productodefiprodu.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productodefiprodu.setIsDeletedAuxiliar(false);	
			productodefiprodu.setIsNewAuxiliar(false);	
			productodefiprodu.setIsChangedAuxiliar(false);
			
			productodefiprodu.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoDefiProdus(List<ProductoDefiProdu> productodefiprodus,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductoDefiProdu productodefiprodu : productodefiprodus) {
			if(conAsignarBase && productodefiprodu.getConCambioAuxiliar()) {
				productodefiprodu.setIsDeleted(productodefiprodu.getIsDeletedAuxiliar());	
				productodefiprodu.setIsNew(productodefiprodu.getIsNewAuxiliar());	
				productodefiprodu.setIsChanged(productodefiprodu.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productodefiprodu.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productodefiprodu.setIsDeletedAuxiliar(false);	
				productodefiprodu.setIsNewAuxiliar(false);	
				productodefiprodu.setIsChangedAuxiliar(false);
				
				productodefiprodu.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductoDefiProdu(ProductoDefiProdu productodefiprodu,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProductoDefiProdus(List<ProductoDefiProdu> productodefiprodus,Boolean conEnteros) throws Exception  {
		
		for(ProductoDefiProdu productodefiprodu: productodefiprodus) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductoDefiProdu(List<ProductoDefiProdu> productodefiprodus,ProductoDefiProdu productodefiproduAux) throws Exception  {
		ProductoDefiProduConstantesFunciones.InicializarValoresProductoDefiProdu(productodefiproduAux,true);
		
		for(ProductoDefiProdu productodefiprodu: productodefiprodus) {
			if(productodefiprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoDefiProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductoDefiProduConstantesFunciones.getArrayColumnasGlobalesProductoDefiProdu(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoDefiProdu(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductoDefiProduConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductoDefiProduConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductoDefiProduConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductoDefiProduConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductoDefiProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoDefiProdu> productodefiprodus,ProductoDefiProdu productodefiprodu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoDefiProdu productodefiproduAux: productodefiprodus) {
			if(productodefiproduAux!=null && productodefiprodu!=null) {
				if((productodefiproduAux.getId()==null && productodefiprodu.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productodefiproduAux.getId()!=null && productodefiprodu.getId()!=null){
					if(productodefiproduAux.getId().equals(productodefiprodu.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoDefiProdu(List<ProductoDefiProdu> productodefiprodus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProductoDefiProdu productodefiprodu: productodefiprodus) {			
			if(productodefiprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductoDefiProdu() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductoDefiProduConstantesFunciones.LABEL_ID, ProductoDefiProduConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoDefiProduConstantesFunciones.LABEL_VERSIONROW, ProductoDefiProduConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoDefiProduConstantesFunciones.LABEL_IDEMPRESA, ProductoDefiProduConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoDefiProduConstantesFunciones.LABEL_IDSUCURSAL, ProductoDefiProduConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoDefiProduConstantesFunciones.LABEL_IDBODEGA, ProductoDefiProduConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoDefiProduConstantesFunciones.LABEL_IDPRODUCTO, ProductoDefiProduConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoDefiProduConstantesFunciones.LABEL_IDUNIDAD, ProductoDefiProduConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoDefiProduConstantesFunciones.LABEL_CONGENERASUBPRODUCTOS, ProductoDefiProduConstantesFunciones.CONGENERASUBPRODUCTOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoDefiProduConstantesFunciones.LABEL_DESCRIPCION, ProductoDefiProduConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductoDefiProdu() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductoDefiProduConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoDefiProduConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoDefiProduConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoDefiProduConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoDefiProduConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoDefiProduConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoDefiProduConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoDefiProduConstantesFunciones.CONGENERASUBPRODUCTOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoDefiProduConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoDefiProdu() throws Exception  {
		return ProductoDefiProduConstantesFunciones.getTiposSeleccionarProductoDefiProdu(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoDefiProdu(Boolean conFk) throws Exception  {
		return ProductoDefiProduConstantesFunciones.getTiposSeleccionarProductoDefiProdu(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoDefiProdu(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoDefiProduConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProductoDefiProduConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoDefiProduConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProductoDefiProduConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoDefiProduConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ProductoDefiProduConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoDefiProduConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProductoDefiProduConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoDefiProduConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(ProductoDefiProduConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoDefiProduConstantesFunciones.LABEL_CONGENERASUBPRODUCTOS);
			reporte.setsDescripcion(ProductoDefiProduConstantesFunciones.LABEL_CONGENERASUBPRODUCTOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoDefiProduConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ProductoDefiProduConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductoDefiProdu(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductoDefiProdu(ProductoDefiProdu productodefiproduAux) throws Exception {
		
			productodefiproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productodefiproduAux.getEmpresa()));
			productodefiproduAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productodefiproduAux.getSucursal()));
			productodefiproduAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productodefiproduAux.getBodega()));
			productodefiproduAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productodefiproduAux.getProducto()));
			productodefiproduAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productodefiproduAux.getUnidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductoDefiProdu(List<ProductoDefiProdu> productodefiprodusTemp) throws Exception {
		for(ProductoDefiProdu productodefiproduAux:productodefiprodusTemp) {
			
			productodefiproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productodefiproduAux.getEmpresa()));
			productodefiproduAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productodefiproduAux.getSucursal()));
			productodefiproduAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productodefiproduAux.getBodega()));
			productodefiproduAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productodefiproduAux.getProducto()));
			productodefiproduAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productodefiproduAux.getUnidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductoDefiProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				
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
					if(clas.clas.equals(Unidad.class)) {
						classes.add(new Classe(Unidad.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductoDefiProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
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

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoDefiProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoDefiProduConstantesFunciones.getClassesRelationshipsOfProductoDefiProdu(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoDefiProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ProductoProduMano.class));
				classes.add(new Classe(ProductoProduMerma.class));
				classes.add(new Classe(ProductoProduGasto.class));
				classes.add(new Classe(ProductoProdu.class));
				classes.add(new Classe(ProductoProduMaquina.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoProduMano.class)) {
						classes.add(new Classe(ProductoProduMano.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoProduMerma.class)) {
						classes.add(new Classe(ProductoProduMerma.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoProduGasto.class)) {
						classes.add(new Classe(ProductoProduGasto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoProdu.class)) {
						classes.add(new Classe(ProductoProdu.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoProduMaquina.class)) {
						classes.add(new Classe(ProductoProduMaquina.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoDefiProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoDefiProduConstantesFunciones.getClassesRelationshipsFromStringsOfProductoDefiProdu(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoDefiProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoProduMano.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProduMano.class)); continue;
					}

					if(ProductoProduMerma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProduMerma.class)); continue;
					}

					if(ProductoProduGasto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProduGasto.class)); continue;
					}

					if(ProductoProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProdu.class)); continue;
					}

					if(ProductoProduMaquina.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProduMaquina.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoProduMano.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProduMano.class)); continue;
					}

					if(ProductoProduMerma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProduMerma.class)); continue;
					}

					if(ProductoProduGasto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProduGasto.class)); continue;
					}

					if(ProductoProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProdu.class)); continue;
					}

					if(ProductoProduMaquina.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProduMaquina.class)); continue;
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
	public static void actualizarLista(ProductoDefiProdu productodefiprodu,List<ProductoDefiProdu> productodefiprodus,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProductoDefiProdu productodefiproduEncontrado=null;
			
			for(ProductoDefiProdu productodefiproduLocal:productodefiprodus) {
				if(productodefiproduLocal.getId().equals(productodefiprodu.getId())) {
					productodefiproduEncontrado=productodefiproduLocal;
					
					productodefiproduLocal.setIsChanged(productodefiprodu.getIsChanged());
					productodefiproduLocal.setIsNew(productodefiprodu.getIsNew());
					productodefiproduLocal.setIsDeleted(productodefiprodu.getIsDeleted());
					
					productodefiproduLocal.setGeneralEntityOriginal(productodefiprodu.getGeneralEntityOriginal());
					
					productodefiproduLocal.setId(productodefiprodu.getId());	
					productodefiproduLocal.setVersionRow(productodefiprodu.getVersionRow());	
					productodefiproduLocal.setid_empresa(productodefiprodu.getid_empresa());	
					productodefiproduLocal.setid_sucursal(productodefiprodu.getid_sucursal());	
					productodefiproduLocal.setid_bodega(productodefiprodu.getid_bodega());	
					productodefiproduLocal.setid_producto(productodefiprodu.getid_producto());	
					productodefiproduLocal.setid_unidad(productodefiprodu.getid_unidad());	
					productodefiproduLocal.setcon_genera_sub_productos(productodefiprodu.getcon_genera_sub_productos());	
					productodefiproduLocal.setdescripcion(productodefiprodu.getdescripcion());	
					
					
					productodefiproduLocal.setProductoProduManos(productodefiprodu.getProductoProduManos());
					productodefiproduLocal.setProductoProduMermas(productodefiprodu.getProductoProduMermas());
					productodefiproduLocal.setProductoProduGastos(productodefiprodu.getProductoProduGastos());
					productodefiproduLocal.setProductoProdus(productodefiprodu.getProductoProdus());
					productodefiproduLocal.setProductoProduMaquinas(productodefiprodu.getProductoProduMaquinas());
					
					existe=true;
					break;
				}
			}
			
			if(!productodefiprodu.getIsDeleted()) {
				if(!existe) {
					productodefiprodus.add(productodefiprodu);
				}
			} else {
				if(productodefiproduEncontrado!=null && permiteQuitar)  {
					productodefiprodus.remove(productodefiproduEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProductoDefiProdu productodefiprodu,List<ProductoDefiProdu> productodefiprodus) throws Exception {
		try	{			
			for(ProductoDefiProdu productodefiproduLocal:productodefiprodus) {
				if(productodefiproduLocal.getId().equals(productodefiprodu.getId())) {
					productodefiproduLocal.setIsSelected(productodefiprodu.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductoDefiProdu(List<ProductoDefiProdu> productodefiprodusAux) throws Exception {
		//this.productodefiprodusAux=productodefiprodusAux;
		
		for(ProductoDefiProdu productodefiproduAux:productodefiprodusAux) {
			if(productodefiproduAux.getIsChanged()) {
				productodefiproduAux.setIsChanged(false);
			}		
			
			if(productodefiproduAux.getIsNew()) {
				productodefiproduAux.setIsNew(false);
			}	
			
			if(productodefiproduAux.getIsDeleted()) {
				productodefiproduAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductoDefiProdu(ProductoDefiProdu productodefiproduAux) throws Exception {
		//this.productodefiproduAux=productodefiproduAux;
		
			if(productodefiproduAux.getIsChanged()) {
				productodefiproduAux.setIsChanged(false);
			}		
			
			if(productodefiproduAux.getIsNew()) {
				productodefiproduAux.setIsNew(false);
			}	
			
			if(productodefiproduAux.getIsDeleted()) {
				productodefiproduAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductoDefiProdu productodefiproduAsignar,ProductoDefiProdu productodefiprodu) throws Exception {
		productodefiproduAsignar.setId(productodefiprodu.getId());	
		productodefiproduAsignar.setVersionRow(productodefiprodu.getVersionRow());	
		productodefiproduAsignar.setid_empresa(productodefiprodu.getid_empresa());
		productodefiproduAsignar.setempresa_descripcion(productodefiprodu.getempresa_descripcion());	
		productodefiproduAsignar.setid_sucursal(productodefiprodu.getid_sucursal());
		productodefiproduAsignar.setsucursal_descripcion(productodefiprodu.getsucursal_descripcion());	
		productodefiproduAsignar.setid_bodega(productodefiprodu.getid_bodega());
		productodefiproduAsignar.setbodega_descripcion(productodefiprodu.getbodega_descripcion());	
		productodefiproduAsignar.setid_producto(productodefiprodu.getid_producto());
		productodefiproduAsignar.setproducto_descripcion(productodefiprodu.getproducto_descripcion());	
		productodefiproduAsignar.setid_unidad(productodefiprodu.getid_unidad());
		productodefiproduAsignar.setunidad_descripcion(productodefiprodu.getunidad_descripcion());	
		productodefiproduAsignar.setcon_genera_sub_productos(productodefiprodu.getcon_genera_sub_productos());	
		productodefiproduAsignar.setdescripcion(productodefiprodu.getdescripcion());	
	}
	
	public static void inicializarProductoDefiProdu(ProductoDefiProdu productodefiprodu) throws Exception {
		try {
				productodefiprodu.setId(0L);	
					
				productodefiprodu.setid_empresa(-1L);	
				productodefiprodu.setid_sucursal(-1L);	
				productodefiprodu.setid_bodega(-1L);	
				productodefiprodu.setid_producto(-1L);	
				productodefiprodu.setid_unidad(-1L);	
				productodefiprodu.setcon_genera_sub_productos(false);	
				productodefiprodu.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductoDefiProdu(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoDefiProduConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoDefiProduConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoDefiProduConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoDefiProduConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoDefiProduConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoDefiProduConstantesFunciones.LABEL_CONGENERASUBPRODUCTOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoDefiProduConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductoDefiProdu(String sTipo,Row row,Workbook workbook,ProductoDefiProdu productodefiprodu,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productodefiprodu.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productodefiprodu.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productodefiprodu.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productodefiprodu.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productodefiprodu.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(productodefiprodu.getcon_genera_sub_productos()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productodefiprodu.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductoDefiProdu=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProductoDefiProdu() {
		return this.sFinalQueryProductoDefiProdu;
	}
	
	public void setsFinalQueryProductoDefiProdu(String sFinalQueryProductoDefiProdu) {
		this.sFinalQueryProductoDefiProdu= sFinalQueryProductoDefiProdu;
	}
	
	public Border resaltarSeleccionarProductoDefiProdu=null;
	
	public Border setResaltarSeleccionarProductoDefiProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoDefiProduBeanSwingJInternalFrame productodefiproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productodefiproduBeanSwingJInternalFrame.jTtoolBarProductoDefiProdu.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductoDefiProdu= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductoDefiProdu() {
		return this.resaltarSeleccionarProductoDefiProdu;
	}
	
	public void setResaltarSeleccionarProductoDefiProdu(Border borderResaltarSeleccionarProductoDefiProdu) {
		this.resaltarSeleccionarProductoDefiProdu= borderResaltarSeleccionarProductoDefiProdu;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductoDefiProdu=null;
	public Boolean mostraridProductoDefiProdu=true;
	public Boolean activaridProductoDefiProdu=true;

	public Border resaltarid_empresaProductoDefiProdu=null;
	public Boolean mostrarid_empresaProductoDefiProdu=true;
	public Boolean activarid_empresaProductoDefiProdu=true;
	public Boolean cargarid_empresaProductoDefiProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProductoDefiProdu=false;//ConEventDepend=true

	public Border resaltarid_sucursalProductoDefiProdu=null;
	public Boolean mostrarid_sucursalProductoDefiProdu=true;
	public Boolean activarid_sucursalProductoDefiProdu=true;
	public Boolean cargarid_sucursalProductoDefiProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProductoDefiProdu=false;//ConEventDepend=true

	public Border resaltarid_bodegaProductoDefiProdu=null;
	public Boolean mostrarid_bodegaProductoDefiProdu=true;
	public Boolean activarid_bodegaProductoDefiProdu=true;
	public Boolean cargarid_bodegaProductoDefiProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaProductoDefiProdu=false;//ConEventDepend=true

	public Border resaltarid_productoProductoDefiProdu=null;
	public Boolean mostrarid_productoProductoDefiProdu=true;
	public Boolean activarid_productoProductoDefiProdu=true;
	public Boolean cargarid_productoProductoDefiProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProductoDefiProdu=true;//ConEventDepend=true

	public Border resaltarid_unidadProductoDefiProdu=null;
	public Boolean mostrarid_unidadProductoDefiProdu=true;
	public Boolean activarid_unidadProductoDefiProdu=true;
	public Boolean cargarid_unidadProductoDefiProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadProductoDefiProdu=true;//ConEventDepend=true

	public Border resaltarcon_genera_sub_productosProductoDefiProdu=null;
	public Boolean mostrarcon_genera_sub_productosProductoDefiProdu=true;
	public Boolean activarcon_genera_sub_productosProductoDefiProdu=true;

	public Border resaltardescripcionProductoDefiProdu=null;
	public Boolean mostrardescripcionProductoDefiProdu=true;
	public Boolean activardescripcionProductoDefiProdu=true;

	
	

	public Border setResaltaridProductoDefiProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoDefiProduBeanSwingJInternalFrame productodefiproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productodefiproduBeanSwingJInternalFrame.jTtoolBarProductoDefiProdu.setBorder(borderResaltar);
		
		this.resaltaridProductoDefiProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductoDefiProdu() {
		return this.resaltaridProductoDefiProdu;
	}

	public void setResaltaridProductoDefiProdu(Border borderResaltar) {
		this.resaltaridProductoDefiProdu= borderResaltar;
	}

	public Boolean getMostraridProductoDefiProdu() {
		return this.mostraridProductoDefiProdu;
	}

	public void setMostraridProductoDefiProdu(Boolean mostraridProductoDefiProdu) {
		this.mostraridProductoDefiProdu= mostraridProductoDefiProdu;
	}

	public Boolean getActivaridProductoDefiProdu() {
		return this.activaridProductoDefiProdu;
	}

	public void setActivaridProductoDefiProdu(Boolean activaridProductoDefiProdu) {
		this.activaridProductoDefiProdu= activaridProductoDefiProdu;
	}

	public Border setResaltarid_empresaProductoDefiProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoDefiProduBeanSwingJInternalFrame productodefiproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productodefiproduBeanSwingJInternalFrame.jTtoolBarProductoDefiProdu.setBorder(borderResaltar);
		
		this.resaltarid_empresaProductoDefiProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProductoDefiProdu() {
		return this.resaltarid_empresaProductoDefiProdu;
	}

	public void setResaltarid_empresaProductoDefiProdu(Border borderResaltar) {
		this.resaltarid_empresaProductoDefiProdu= borderResaltar;
	}

	public Boolean getMostrarid_empresaProductoDefiProdu() {
		return this.mostrarid_empresaProductoDefiProdu;
	}

	public void setMostrarid_empresaProductoDefiProdu(Boolean mostrarid_empresaProductoDefiProdu) {
		this.mostrarid_empresaProductoDefiProdu= mostrarid_empresaProductoDefiProdu;
	}

	public Boolean getActivarid_empresaProductoDefiProdu() {
		return this.activarid_empresaProductoDefiProdu;
	}

	public void setActivarid_empresaProductoDefiProdu(Boolean activarid_empresaProductoDefiProdu) {
		this.activarid_empresaProductoDefiProdu= activarid_empresaProductoDefiProdu;
	}

	public Boolean getCargarid_empresaProductoDefiProdu() {
		return this.cargarid_empresaProductoDefiProdu;
	}

	public void setCargarid_empresaProductoDefiProdu(Boolean cargarid_empresaProductoDefiProdu) {
		this.cargarid_empresaProductoDefiProdu= cargarid_empresaProductoDefiProdu;
	}

	public Border setResaltarid_sucursalProductoDefiProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoDefiProduBeanSwingJInternalFrame productodefiproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productodefiproduBeanSwingJInternalFrame.jTtoolBarProductoDefiProdu.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProductoDefiProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProductoDefiProdu() {
		return this.resaltarid_sucursalProductoDefiProdu;
	}

	public void setResaltarid_sucursalProductoDefiProdu(Border borderResaltar) {
		this.resaltarid_sucursalProductoDefiProdu= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProductoDefiProdu() {
		return this.mostrarid_sucursalProductoDefiProdu;
	}

	public void setMostrarid_sucursalProductoDefiProdu(Boolean mostrarid_sucursalProductoDefiProdu) {
		this.mostrarid_sucursalProductoDefiProdu= mostrarid_sucursalProductoDefiProdu;
	}

	public Boolean getActivarid_sucursalProductoDefiProdu() {
		return this.activarid_sucursalProductoDefiProdu;
	}

	public void setActivarid_sucursalProductoDefiProdu(Boolean activarid_sucursalProductoDefiProdu) {
		this.activarid_sucursalProductoDefiProdu= activarid_sucursalProductoDefiProdu;
	}

	public Boolean getCargarid_sucursalProductoDefiProdu() {
		return this.cargarid_sucursalProductoDefiProdu;
	}

	public void setCargarid_sucursalProductoDefiProdu(Boolean cargarid_sucursalProductoDefiProdu) {
		this.cargarid_sucursalProductoDefiProdu= cargarid_sucursalProductoDefiProdu;
	}

	public Border setResaltarid_bodegaProductoDefiProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoDefiProduBeanSwingJInternalFrame productodefiproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productodefiproduBeanSwingJInternalFrame.jTtoolBarProductoDefiProdu.setBorder(borderResaltar);
		
		this.resaltarid_bodegaProductoDefiProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaProductoDefiProdu() {
		return this.resaltarid_bodegaProductoDefiProdu;
	}

	public void setResaltarid_bodegaProductoDefiProdu(Border borderResaltar) {
		this.resaltarid_bodegaProductoDefiProdu= borderResaltar;
	}

	public Boolean getMostrarid_bodegaProductoDefiProdu() {
		return this.mostrarid_bodegaProductoDefiProdu;
	}

	public void setMostrarid_bodegaProductoDefiProdu(Boolean mostrarid_bodegaProductoDefiProdu) {
		this.mostrarid_bodegaProductoDefiProdu= mostrarid_bodegaProductoDefiProdu;
	}

	public Boolean getActivarid_bodegaProductoDefiProdu() {
		return this.activarid_bodegaProductoDefiProdu;
	}

	public void setActivarid_bodegaProductoDefiProdu(Boolean activarid_bodegaProductoDefiProdu) {
		this.activarid_bodegaProductoDefiProdu= activarid_bodegaProductoDefiProdu;
	}

	public Boolean getCargarid_bodegaProductoDefiProdu() {
		return this.cargarid_bodegaProductoDefiProdu;
	}

	public void setCargarid_bodegaProductoDefiProdu(Boolean cargarid_bodegaProductoDefiProdu) {
		this.cargarid_bodegaProductoDefiProdu= cargarid_bodegaProductoDefiProdu;
	}

	public Border setResaltarid_productoProductoDefiProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoDefiProduBeanSwingJInternalFrame productodefiproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productodefiproduBeanSwingJInternalFrame.jTtoolBarProductoDefiProdu.setBorder(borderResaltar);
		
		this.resaltarid_productoProductoDefiProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProductoDefiProdu() {
		return this.resaltarid_productoProductoDefiProdu;
	}

	public void setResaltarid_productoProductoDefiProdu(Border borderResaltar) {
		this.resaltarid_productoProductoDefiProdu= borderResaltar;
	}

	public Boolean getMostrarid_productoProductoDefiProdu() {
		return this.mostrarid_productoProductoDefiProdu;
	}

	public void setMostrarid_productoProductoDefiProdu(Boolean mostrarid_productoProductoDefiProdu) {
		this.mostrarid_productoProductoDefiProdu= mostrarid_productoProductoDefiProdu;
	}

	public Boolean getActivarid_productoProductoDefiProdu() {
		return this.activarid_productoProductoDefiProdu;
	}

	public void setActivarid_productoProductoDefiProdu(Boolean activarid_productoProductoDefiProdu) {
		this.activarid_productoProductoDefiProdu= activarid_productoProductoDefiProdu;
	}

	public Boolean getCargarid_productoProductoDefiProdu() {
		return this.cargarid_productoProductoDefiProdu;
	}

	public void setCargarid_productoProductoDefiProdu(Boolean cargarid_productoProductoDefiProdu) {
		this.cargarid_productoProductoDefiProdu= cargarid_productoProductoDefiProdu;
	}

	public Border setResaltarid_unidadProductoDefiProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoDefiProduBeanSwingJInternalFrame productodefiproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productodefiproduBeanSwingJInternalFrame.jTtoolBarProductoDefiProdu.setBorder(borderResaltar);
		
		this.resaltarid_unidadProductoDefiProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadProductoDefiProdu() {
		return this.resaltarid_unidadProductoDefiProdu;
	}

	public void setResaltarid_unidadProductoDefiProdu(Border borderResaltar) {
		this.resaltarid_unidadProductoDefiProdu= borderResaltar;
	}

	public Boolean getMostrarid_unidadProductoDefiProdu() {
		return this.mostrarid_unidadProductoDefiProdu;
	}

	public void setMostrarid_unidadProductoDefiProdu(Boolean mostrarid_unidadProductoDefiProdu) {
		this.mostrarid_unidadProductoDefiProdu= mostrarid_unidadProductoDefiProdu;
	}

	public Boolean getActivarid_unidadProductoDefiProdu() {
		return this.activarid_unidadProductoDefiProdu;
	}

	public void setActivarid_unidadProductoDefiProdu(Boolean activarid_unidadProductoDefiProdu) {
		this.activarid_unidadProductoDefiProdu= activarid_unidadProductoDefiProdu;
	}

	public Boolean getCargarid_unidadProductoDefiProdu() {
		return this.cargarid_unidadProductoDefiProdu;
	}

	public void setCargarid_unidadProductoDefiProdu(Boolean cargarid_unidadProductoDefiProdu) {
		this.cargarid_unidadProductoDefiProdu= cargarid_unidadProductoDefiProdu;
	}

	public Border setResaltarcon_genera_sub_productosProductoDefiProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoDefiProduBeanSwingJInternalFrame productodefiproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productodefiproduBeanSwingJInternalFrame.jTtoolBarProductoDefiProdu.setBorder(borderResaltar);
		
		this.resaltarcon_genera_sub_productosProductoDefiProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_genera_sub_productosProductoDefiProdu() {
		return this.resaltarcon_genera_sub_productosProductoDefiProdu;
	}

	public void setResaltarcon_genera_sub_productosProductoDefiProdu(Border borderResaltar) {
		this.resaltarcon_genera_sub_productosProductoDefiProdu= borderResaltar;
	}

	public Boolean getMostrarcon_genera_sub_productosProductoDefiProdu() {
		return this.mostrarcon_genera_sub_productosProductoDefiProdu;
	}

	public void setMostrarcon_genera_sub_productosProductoDefiProdu(Boolean mostrarcon_genera_sub_productosProductoDefiProdu) {
		this.mostrarcon_genera_sub_productosProductoDefiProdu= mostrarcon_genera_sub_productosProductoDefiProdu;
	}

	public Boolean getActivarcon_genera_sub_productosProductoDefiProdu() {
		return this.activarcon_genera_sub_productosProductoDefiProdu;
	}

	public void setActivarcon_genera_sub_productosProductoDefiProdu(Boolean activarcon_genera_sub_productosProductoDefiProdu) {
		this.activarcon_genera_sub_productosProductoDefiProdu= activarcon_genera_sub_productosProductoDefiProdu;
	}

	public Border setResaltardescripcionProductoDefiProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoDefiProduBeanSwingJInternalFrame productodefiproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productodefiproduBeanSwingJInternalFrame.jTtoolBarProductoDefiProdu.setBorder(borderResaltar);
		
		this.resaltardescripcionProductoDefiProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionProductoDefiProdu() {
		return this.resaltardescripcionProductoDefiProdu;
	}

	public void setResaltardescripcionProductoDefiProdu(Border borderResaltar) {
		this.resaltardescripcionProductoDefiProdu= borderResaltar;
	}

	public Boolean getMostrardescripcionProductoDefiProdu() {
		return this.mostrardescripcionProductoDefiProdu;
	}

	public void setMostrardescripcionProductoDefiProdu(Boolean mostrardescripcionProductoDefiProdu) {
		this.mostrardescripcionProductoDefiProdu= mostrardescripcionProductoDefiProdu;
	}

	public Boolean getActivardescripcionProductoDefiProdu() {
		return this.activardescripcionProductoDefiProdu;
	}

	public void setActivardescripcionProductoDefiProdu(Boolean activardescripcionProductoDefiProdu) {
		this.activardescripcionProductoDefiProdu= activardescripcionProductoDefiProdu;
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
		
		
		this.setMostraridProductoDefiProdu(esInicial);
		this.setMostrarid_empresaProductoDefiProdu(esInicial);
		this.setMostrarid_sucursalProductoDefiProdu(esInicial);
		this.setMostrarid_bodegaProductoDefiProdu(esInicial);
		this.setMostrarid_productoProductoDefiProdu(esInicial);
		this.setMostrarid_unidadProductoDefiProdu(esInicial);
		this.setMostrarcon_genera_sub_productosProductoDefiProdu(esInicial);
		this.setMostrardescripcionProductoDefiProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.ID)) {
				this.setMostraridProductoDefiProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProductoDefiProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProductoDefiProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaProductoDefiProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProductoDefiProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadProductoDefiProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.CONGENERASUBPRODUCTOS)) {
				this.setMostrarcon_genera_sub_productosProductoDefiProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionProductoDefiProdu(esAsigna);
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
		
		
		this.setActivaridProductoDefiProdu(esInicial);
		this.setActivarid_empresaProductoDefiProdu(esInicial);
		this.setActivarid_sucursalProductoDefiProdu(esInicial);
		this.setActivarid_bodegaProductoDefiProdu(esInicial);
		this.setActivarid_productoProductoDefiProdu(esInicial);
		this.setActivarid_unidadProductoDefiProdu(esInicial);
		this.setActivarcon_genera_sub_productosProductoDefiProdu(esInicial);
		this.setActivardescripcionProductoDefiProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.ID)) {
				this.setActivaridProductoDefiProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProductoDefiProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProductoDefiProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaProductoDefiProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProductoDefiProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadProductoDefiProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.CONGENERASUBPRODUCTOS)) {
				this.setActivarcon_genera_sub_productosProductoDefiProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionProductoDefiProdu(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoDefiProduBeanSwingJInternalFrame productodefiproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductoDefiProdu(esInicial);
		this.setResaltarid_empresaProductoDefiProdu(esInicial);
		this.setResaltarid_sucursalProductoDefiProdu(esInicial);
		this.setResaltarid_bodegaProductoDefiProdu(esInicial);
		this.setResaltarid_productoProductoDefiProdu(esInicial);
		this.setResaltarid_unidadProductoDefiProdu(esInicial);
		this.setResaltarcon_genera_sub_productosProductoDefiProdu(esInicial);
		this.setResaltardescripcionProductoDefiProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.ID)) {
				this.setResaltaridProductoDefiProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProductoDefiProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProductoDefiProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaProductoDefiProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProductoDefiProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadProductoDefiProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.CONGENERASUBPRODUCTOS)) {
				this.setResaltarcon_genera_sub_productosProductoDefiProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoDefiProduConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionProductoDefiProdu(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarProductoProduManoProductoDefiProdu=null;

	public Border getResaltarProductoProduManoProductoDefiProdu() {
		return this.resaltarProductoProduManoProductoDefiProdu;
	}

	public void setResaltarProductoProduManoProductoDefiProdu(Border borderResaltarProductoProduMano) {
		if(borderResaltarProductoProduMano!=null) {
			this.resaltarProductoProduManoProductoDefiProdu= borderResaltarProductoProduMano;
		}
	}

	public Border setResaltarProductoProduManoProductoDefiProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoDefiProduBeanSwingJInternalFrame productodefiproduBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoProduMano=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productodefiproduBeanSwingJInternalFrame.jTtoolBarProductoDefiProdu.setBorder(borderResaltarProductoProduMano);
			
		this.resaltarProductoProduManoProductoDefiProdu= borderResaltarProductoProduMano;

		 return borderResaltarProductoProduMano;
	}



	public Boolean mostrarProductoProduManoProductoDefiProdu=true;

	public Boolean getMostrarProductoProduManoProductoDefiProdu() {
		return this.mostrarProductoProduManoProductoDefiProdu;
	}

	public void setMostrarProductoProduManoProductoDefiProdu(Boolean visibilidadResaltarProductoProduMano) {
		this.mostrarProductoProduManoProductoDefiProdu= visibilidadResaltarProductoProduMano;
	}



	public Boolean activarProductoProduManoProductoDefiProdu=true;

	public Boolean gethabilitarResaltarProductoProduManoProductoDefiProdu() {
		return this.activarProductoProduManoProductoDefiProdu;
	}

	public void setActivarProductoProduManoProductoDefiProdu(Boolean habilitarResaltarProductoProduMano) {
		this.activarProductoProduManoProductoDefiProdu= habilitarResaltarProductoProduMano;
	}


	public Border resaltarProductoProduMermaProductoDefiProdu=null;

	public Border getResaltarProductoProduMermaProductoDefiProdu() {
		return this.resaltarProductoProduMermaProductoDefiProdu;
	}

	public void setResaltarProductoProduMermaProductoDefiProdu(Border borderResaltarProductoProduMerma) {
		if(borderResaltarProductoProduMerma!=null) {
			this.resaltarProductoProduMermaProductoDefiProdu= borderResaltarProductoProduMerma;
		}
	}

	public Border setResaltarProductoProduMermaProductoDefiProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoDefiProduBeanSwingJInternalFrame productodefiproduBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoProduMerma=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productodefiproduBeanSwingJInternalFrame.jTtoolBarProductoDefiProdu.setBorder(borderResaltarProductoProduMerma);
			
		this.resaltarProductoProduMermaProductoDefiProdu= borderResaltarProductoProduMerma;

		 return borderResaltarProductoProduMerma;
	}



	public Boolean mostrarProductoProduMermaProductoDefiProdu=true;

	public Boolean getMostrarProductoProduMermaProductoDefiProdu() {
		return this.mostrarProductoProduMermaProductoDefiProdu;
	}

	public void setMostrarProductoProduMermaProductoDefiProdu(Boolean visibilidadResaltarProductoProduMerma) {
		this.mostrarProductoProduMermaProductoDefiProdu= visibilidadResaltarProductoProduMerma;
	}



	public Boolean activarProductoProduMermaProductoDefiProdu=true;

	public Boolean gethabilitarResaltarProductoProduMermaProductoDefiProdu() {
		return this.activarProductoProduMermaProductoDefiProdu;
	}

	public void setActivarProductoProduMermaProductoDefiProdu(Boolean habilitarResaltarProductoProduMerma) {
		this.activarProductoProduMermaProductoDefiProdu= habilitarResaltarProductoProduMerma;
	}


	public Border resaltarProductoProduGastoProductoDefiProdu=null;

	public Border getResaltarProductoProduGastoProductoDefiProdu() {
		return this.resaltarProductoProduGastoProductoDefiProdu;
	}

	public void setResaltarProductoProduGastoProductoDefiProdu(Border borderResaltarProductoProduGasto) {
		if(borderResaltarProductoProduGasto!=null) {
			this.resaltarProductoProduGastoProductoDefiProdu= borderResaltarProductoProduGasto;
		}
	}

	public Border setResaltarProductoProduGastoProductoDefiProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoDefiProduBeanSwingJInternalFrame productodefiproduBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoProduGasto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productodefiproduBeanSwingJInternalFrame.jTtoolBarProductoDefiProdu.setBorder(borderResaltarProductoProduGasto);
			
		this.resaltarProductoProduGastoProductoDefiProdu= borderResaltarProductoProduGasto;

		 return borderResaltarProductoProduGasto;
	}



	public Boolean mostrarProductoProduGastoProductoDefiProdu=true;

	public Boolean getMostrarProductoProduGastoProductoDefiProdu() {
		return this.mostrarProductoProduGastoProductoDefiProdu;
	}

	public void setMostrarProductoProduGastoProductoDefiProdu(Boolean visibilidadResaltarProductoProduGasto) {
		this.mostrarProductoProduGastoProductoDefiProdu= visibilidadResaltarProductoProduGasto;
	}



	public Boolean activarProductoProduGastoProductoDefiProdu=true;

	public Boolean gethabilitarResaltarProductoProduGastoProductoDefiProdu() {
		return this.activarProductoProduGastoProductoDefiProdu;
	}

	public void setActivarProductoProduGastoProductoDefiProdu(Boolean habilitarResaltarProductoProduGasto) {
		this.activarProductoProduGastoProductoDefiProdu= habilitarResaltarProductoProduGasto;
	}


	public Border resaltarProductoProduProductoDefiProdu=null;

	public Border getResaltarProductoProduProductoDefiProdu() {
		return this.resaltarProductoProduProductoDefiProdu;
	}

	public void setResaltarProductoProduProductoDefiProdu(Border borderResaltarProductoProdu) {
		if(borderResaltarProductoProdu!=null) {
			this.resaltarProductoProduProductoDefiProdu= borderResaltarProductoProdu;
		}
	}

	public Border setResaltarProductoProduProductoDefiProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoDefiProduBeanSwingJInternalFrame productodefiproduBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoProdu=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productodefiproduBeanSwingJInternalFrame.jTtoolBarProductoDefiProdu.setBorder(borderResaltarProductoProdu);
			
		this.resaltarProductoProduProductoDefiProdu= borderResaltarProductoProdu;

		 return borderResaltarProductoProdu;
	}



	public Boolean mostrarProductoProduProductoDefiProdu=true;

	public Boolean getMostrarProductoProduProductoDefiProdu() {
		return this.mostrarProductoProduProductoDefiProdu;
	}

	public void setMostrarProductoProduProductoDefiProdu(Boolean visibilidadResaltarProductoProdu) {
		this.mostrarProductoProduProductoDefiProdu= visibilidadResaltarProductoProdu;
	}



	public Boolean activarProductoProduProductoDefiProdu=true;

	public Boolean gethabilitarResaltarProductoProduProductoDefiProdu() {
		return this.activarProductoProduProductoDefiProdu;
	}

	public void setActivarProductoProduProductoDefiProdu(Boolean habilitarResaltarProductoProdu) {
		this.activarProductoProduProductoDefiProdu= habilitarResaltarProductoProdu;
	}


	public Border resaltarProductoProduMaquinaProductoDefiProdu=null;

	public Border getResaltarProductoProduMaquinaProductoDefiProdu() {
		return this.resaltarProductoProduMaquinaProductoDefiProdu;
	}

	public void setResaltarProductoProduMaquinaProductoDefiProdu(Border borderResaltarProductoProduMaquina) {
		if(borderResaltarProductoProduMaquina!=null) {
			this.resaltarProductoProduMaquinaProductoDefiProdu= borderResaltarProductoProduMaquina;
		}
	}

	public Border setResaltarProductoProduMaquinaProductoDefiProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoDefiProduBeanSwingJInternalFrame productodefiproduBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoProduMaquina=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productodefiproduBeanSwingJInternalFrame.jTtoolBarProductoDefiProdu.setBorder(borderResaltarProductoProduMaquina);
			
		this.resaltarProductoProduMaquinaProductoDefiProdu= borderResaltarProductoProduMaquina;

		 return borderResaltarProductoProduMaquina;
	}



	public Boolean mostrarProductoProduMaquinaProductoDefiProdu=true;

	public Boolean getMostrarProductoProduMaquinaProductoDefiProdu() {
		return this.mostrarProductoProduMaquinaProductoDefiProdu;
	}

	public void setMostrarProductoProduMaquinaProductoDefiProdu(Boolean visibilidadResaltarProductoProduMaquina) {
		this.mostrarProductoProduMaquinaProductoDefiProdu= visibilidadResaltarProductoProduMaquina;
	}



	public Boolean activarProductoProduMaquinaProductoDefiProdu=true;

	public Boolean gethabilitarResaltarProductoProduMaquinaProductoDefiProdu() {
		return this.activarProductoProduMaquinaProductoDefiProdu;
	}

	public void setActivarProductoProduMaquinaProductoDefiProdu(Boolean habilitarResaltarProductoProduMaquina) {
		this.activarProductoProduMaquinaProductoDefiProdu= habilitarResaltarProductoProduMaquina;
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

		this.setMostrarProductoProduManoProductoDefiProdu(esInicial);
		this.setMostrarProductoProduMermaProductoDefiProdu(esInicial);
		this.setMostrarProductoProduGastoProductoDefiProdu(esInicial);
		this.setMostrarProductoProduProductoDefiProdu(esInicial);
		this.setMostrarProductoProduMaquinaProductoDefiProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProductoProduMano.class)) {
				this.setMostrarProductoProduManoProductoDefiProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoProduMerma.class)) {
				this.setMostrarProductoProduMermaProductoDefiProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoProduGasto.class)) {
				this.setMostrarProductoProduGastoProductoDefiProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoProdu.class)) {
				this.setMostrarProductoProduProductoDefiProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoProduMaquina.class)) {
				this.setMostrarProductoProduMaquinaProductoDefiProdu(esAsigna);
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

		this.setActivarProductoProduManoProductoDefiProdu(esInicial);
		this.setActivarProductoProduMermaProductoDefiProdu(esInicial);
		this.setActivarProductoProduGastoProductoDefiProdu(esInicial);
		this.setActivarProductoProduProductoDefiProdu(esInicial);
		this.setActivarProductoProduMaquinaProductoDefiProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProductoProduMano.class)) {
				this.setActivarProductoProduManoProductoDefiProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoProduMerma.class)) {
				this.setActivarProductoProduMermaProductoDefiProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoProduGasto.class)) {
				this.setActivarProductoProduGastoProductoDefiProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoProdu.class)) {
				this.setActivarProductoProduProductoDefiProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoProduMaquina.class)) {
				this.setActivarProductoProduMaquinaProductoDefiProdu(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoDefiProduBeanSwingJInternalFrame productodefiproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarProductoProduManoProductoDefiProdu(esInicial);
		this.setResaltarProductoProduMermaProductoDefiProdu(esInicial);
		this.setResaltarProductoProduGastoProductoDefiProdu(esInicial);
		this.setResaltarProductoProduProductoDefiProdu(esInicial);
		this.setResaltarProductoProduMaquinaProductoDefiProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProductoProduMano.class)) {
				this.setResaltarProductoProduManoProductoDefiProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoProduMerma.class)) {
				this.setResaltarProductoProduMermaProductoDefiProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoProduGasto.class)) {
				this.setResaltarProductoProduGastoProductoDefiProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoProdu.class)) {
				this.setResaltarProductoProduProductoDefiProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoProduMaquina.class)) {
				this.setResaltarProductoProduMaquinaProductoDefiProdu(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaProductoDefiProdu=true;

	public Boolean getMostrarFK_IdEmpresaProductoDefiProdu() {
		return this.mostrarFK_IdEmpresaProductoDefiProdu;
	}

	public void setMostrarFK_IdEmpresaProductoDefiProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaProductoDefiProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalProductoDefiProdu=true;

	public Boolean getMostrarFK_IdSucursalProductoDefiProdu() {
		return this.mostrarFK_IdSucursalProductoDefiProdu;
	}

	public void setMostrarFK_IdSucursalProductoDefiProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalProductoDefiProdu= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaProductoDefiProdu=true;

	public Boolean getActivarFK_IdEmpresaProductoDefiProdu() {
		return this.activarFK_IdEmpresaProductoDefiProdu;
	}

	public void setActivarFK_IdEmpresaProductoDefiProdu(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaProductoDefiProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalProductoDefiProdu=true;

	public Boolean getActivarFK_IdSucursalProductoDefiProdu() {
		return this.activarFK_IdSucursalProductoDefiProdu;
	}

	public void setActivarFK_IdSucursalProductoDefiProdu(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalProductoDefiProdu= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaProductoDefiProdu=null;

	public Border getResaltarFK_IdEmpresaProductoDefiProdu() {
		return this.resaltarFK_IdEmpresaProductoDefiProdu;
	}

	public void setResaltarFK_IdEmpresaProductoDefiProdu(Border borderResaltar) {
		this.resaltarFK_IdEmpresaProductoDefiProdu= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaProductoDefiProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoDefiProduBeanSwingJInternalFrame productodefiproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaProductoDefiProdu= borderResaltar;
	}

	public Border resaltarFK_IdSucursalProductoDefiProdu=null;

	public Border getResaltarFK_IdSucursalProductoDefiProdu() {
		return this.resaltarFK_IdSucursalProductoDefiProdu;
	}

	public void setResaltarFK_IdSucursalProductoDefiProdu(Border borderResaltar) {
		this.resaltarFK_IdSucursalProductoDefiProdu= borderResaltar;
	}

	public void setResaltarFK_IdSucursalProductoDefiProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoDefiProduBeanSwingJInternalFrame productodefiproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalProductoDefiProdu= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}