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


import com.bydan.erp.produccion.util.ProductoProduConstantesFunciones;
import com.bydan.erp.produccion.util.ProductoProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProductoProduParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;



import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProductoProduConstantesFunciones extends ProductoProduConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProductoProdu";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductoProdu"+ProductoProduConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductoProduHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductoProduHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductoProduConstantesFunciones.SCHEMA+"_"+ProductoProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductoProduHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductoProduConstantesFunciones.SCHEMA+"_"+ProductoProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductoProduConstantesFunciones.SCHEMA+"_"+ProductoProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductoProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductoProduConstantesFunciones.SCHEMA+"_"+ProductoProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoProduHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductoProduConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductoProduConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductoProduConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductoProduConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Producto Parte Producciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Producto Parte Produccion";
	public static final String SCLASSWEBTITULO_LOWER="Producto Produ";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductoProdu";
	public static final String OBJECTNAME="productoprodu";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="producto_produ";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productoprodu from "+ProductoProduConstantesFunciones.SPERSISTENCENAME+" productoprodu";
	public static String QUERYSELECTNATIVE="select "+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".id,"+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".version_row,"+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".id_producto_defi_produ,"+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".id_bodega,"+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".id_producto,"+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".id_unidad,"+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".porcentaje,"+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".cantidad,"+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".costo,"+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".costo_total,"+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".descripcion from "+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME;//+" as "+ProductoProduConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProductoProduConstantesFuncionesAdditional productoproduConstantesFuncionesAdditional=null;
	
	public ProductoProduConstantesFuncionesAdditional getProductoProduConstantesFuncionesAdditional() {
		return this.productoproduConstantesFuncionesAdditional;
	}
	
	public void setProductoProduConstantesFuncionesAdditional(ProductoProduConstantesFuncionesAdditional productoproduConstantesFuncionesAdditional) {
		try {
			this.productoproduConstantesFuncionesAdditional=productoproduConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPRODUCTODEFIPRODU= "id_producto_defi_produ";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String PORCENTAJE= "porcentaje";
    public static final String CANTIDAD= "cantidad";
    public static final String COSTO= "costo";
    public static final String COSTOTOTAL= "costo_total";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPRODUCTODEFIPRODU= "Producto Defi Produ";
		public static final String LABEL_IDPRODUCTODEFIPRODU_LOWER= "Producto Defi Produ";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDUNIDAD= "Unad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_CANTIDAD= "Cantad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_COSTO= "Costo";
		public static final String LABEL_COSTO_LOWER= "Costo";
    	public static final String LABEL_COSTOTOTAL= "Costo Total";
		public static final String LABEL_COSTOTOTAL_LOWER= "Costo Total";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProductoProduLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductoProduConstantesFunciones.IDPRODUCTODEFIPRODU)) {sLabelColumna=ProductoProduConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU;}
		if(sNombreColumna.equals(ProductoProduConstantesFunciones.IDBODEGA)) {sLabelColumna=ProductoProduConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ProductoProduConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProductoProduConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProductoProduConstantesFunciones.IDUNIDAD)) {sLabelColumna=ProductoProduConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(ProductoProduConstantesFunciones.PORCENTAJE)) {sLabelColumna=ProductoProduConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(ProductoProduConstantesFunciones.CANTIDAD)) {sLabelColumna=ProductoProduConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(ProductoProduConstantesFunciones.COSTO)) {sLabelColumna=ProductoProduConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(ProductoProduConstantesFunciones.COSTOTOTAL)) {sLabelColumna=ProductoProduConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(ProductoProduConstantesFunciones.DESCRIPCION)) {sLabelColumna=ProductoProduConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProductoProduDescripcion(ProductoProdu productoprodu) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productoprodu !=null/* && productoprodu.getId()!=0*/) {
			if(productoprodu.getId()!=null) {
				sDescripcion=productoprodu.getId().toString();
			}//productoproduproductoprodu.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductoProduDescripcionDetallado(ProductoProdu productoprodu) {
		String sDescripcion="";
			
		sDescripcion+=ProductoProduConstantesFunciones.ID+"=";
		sDescripcion+=productoprodu.getId().toString()+",";
		sDescripcion+=ProductoProduConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productoprodu.getVersionRow().toString()+",";
		sDescripcion+=ProductoProduConstantesFunciones.IDPRODUCTODEFIPRODU+"=";
		sDescripcion+=productoprodu.getid_producto_defi_produ().toString()+",";
		sDescripcion+=ProductoProduConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=productoprodu.getid_bodega().toString()+",";
		sDescripcion+=ProductoProduConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=productoprodu.getid_producto().toString()+",";
		sDescripcion+=ProductoProduConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=productoprodu.getid_unidad().toString()+",";
		sDescripcion+=ProductoProduConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=productoprodu.getporcentaje().toString()+",";
		sDescripcion+=ProductoProduConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=productoprodu.getcantidad().toString()+",";
		sDescripcion+=ProductoProduConstantesFunciones.COSTO+"=";
		sDescripcion+=productoprodu.getcosto().toString()+",";
		sDescripcion+=ProductoProduConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=productoprodu.getcosto_total().toString()+",";
		sDescripcion+=ProductoProduConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=productoprodu.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setProductoProduDescripcion(ProductoProdu productoprodu,String sValor) throws Exception {			
		if(productoprodu !=null) {
			//productoproduproductoprodu.getId().toString();
		}		
	}
	
		

	public static String getProductoDefiProduDescripcion(ProductoDefiProdu productodefiprodu) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(productodefiprodu!=null/*&&productodefiprodu.getId()>0*/) {
			sDescripcion=ProductoDefiProduConstantesFunciones.getProductoDefiProduDescripcion(productodefiprodu);
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
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdProductoDefiProdu")) {
			sNombreIndice="Tipo=  Por Producto Defi Produ";
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

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProductoDefiProdu(Long id_producto_defi_produ) {
		String sDetalleIndice=" Parametros->";
		if(id_producto_defi_produ!=null) {sDetalleIndice+=" Codigo Unico De Producto Defi Produ="+id_producto_defi_produ.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidadUnad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProductoProdu(ProductoProdu productoprodu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productoprodu.setdescripcion(productoprodu.getdescripcion().trim());
	}
	
	public static void quitarEspaciosProductoProdus(List<ProductoProdu> productoprodus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoProdu productoprodu: productoprodus) {
			productoprodu.setdescripcion(productoprodu.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoProdu(ProductoProdu productoprodu,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productoprodu.getConCambioAuxiliar()) {
			productoprodu.setIsDeleted(productoprodu.getIsDeletedAuxiliar());	
			productoprodu.setIsNew(productoprodu.getIsNewAuxiliar());	
			productoprodu.setIsChanged(productoprodu.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productoprodu.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productoprodu.setIsDeletedAuxiliar(false);	
			productoprodu.setIsNewAuxiliar(false);	
			productoprodu.setIsChangedAuxiliar(false);
			
			productoprodu.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoProdus(List<ProductoProdu> productoprodus,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductoProdu productoprodu : productoprodus) {
			if(conAsignarBase && productoprodu.getConCambioAuxiliar()) {
				productoprodu.setIsDeleted(productoprodu.getIsDeletedAuxiliar());	
				productoprodu.setIsNew(productoprodu.getIsNewAuxiliar());	
				productoprodu.setIsChanged(productoprodu.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productoprodu.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productoprodu.setIsDeletedAuxiliar(false);	
				productoprodu.setIsNewAuxiliar(false);	
				productoprodu.setIsChangedAuxiliar(false);
				
				productoprodu.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductoProdu(ProductoProdu productoprodu,Boolean conEnteros) throws Exception  {
		productoprodu.setporcentaje(0.0);
		productoprodu.setcosto(0.0);
		productoprodu.setcosto_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			productoprodu.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresProductoProdus(List<ProductoProdu> productoprodus,Boolean conEnteros) throws Exception  {
		
		for(ProductoProdu productoprodu: productoprodus) {
			productoprodu.setporcentaje(0.0);
			productoprodu.setcosto(0.0);
			productoprodu.setcosto_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				productoprodu.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductoProdu(List<ProductoProdu> productoprodus,ProductoProdu productoproduAux) throws Exception  {
		ProductoProduConstantesFunciones.InicializarValoresProductoProdu(productoproduAux,true);
		
		for(ProductoProdu productoprodu: productoprodus) {
			if(productoprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productoproduAux.setporcentaje(productoproduAux.getporcentaje()+productoprodu.getporcentaje());			
			productoproduAux.setcantidad(productoproduAux.getcantidad()+productoprodu.getcantidad());			
			productoproduAux.setcosto(productoproduAux.getcosto()+productoprodu.getcosto());			
			productoproduAux.setcosto_total(productoproduAux.getcosto_total()+productoprodu.getcosto_total());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductoProduConstantesFunciones.getArrayColumnasGlobalesProductoProdu(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoProdu(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductoProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoProdu> productoprodus,ProductoProdu productoprodu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoProdu productoproduAux: productoprodus) {
			if(productoproduAux!=null && productoprodu!=null) {
				if((productoproduAux.getId()==null && productoprodu.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productoproduAux.getId()!=null && productoprodu.getId()!=null){
					if(productoproduAux.getId().equals(productoprodu.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoProdu(List<ProductoProdu> productoprodus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double costoTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(ProductoProdu productoprodu: productoprodus) {			
			if(productoprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=productoprodu.getporcentaje();
			costoTotal+=productoprodu.getcosto();
			costo_totalTotal+=productoprodu.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoProduConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(ProductoProduConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoProduConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(ProductoProduConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoProduConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(ProductoProduConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductoProdu() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductoProduConstantesFunciones.LABEL_ID, ProductoProduConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduConstantesFunciones.LABEL_VERSIONROW, ProductoProduConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU, ProductoProduConstantesFunciones.IDPRODUCTODEFIPRODU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduConstantesFunciones.LABEL_IDBODEGA, ProductoProduConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduConstantesFunciones.LABEL_IDPRODUCTO, ProductoProduConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduConstantesFunciones.LABEL_IDUNIDAD, ProductoProduConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduConstantesFunciones.LABEL_PORCENTAJE, ProductoProduConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduConstantesFunciones.LABEL_CANTIDAD, ProductoProduConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduConstantesFunciones.LABEL_COSTO, ProductoProduConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduConstantesFunciones.LABEL_COSTOTOTAL, ProductoProduConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduConstantesFunciones.LABEL_DESCRIPCION, ProductoProduConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductoProdu() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductoProduConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduConstantesFunciones.IDPRODUCTODEFIPRODU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoProdu() throws Exception  {
		return ProductoProduConstantesFunciones.getTiposSeleccionarProductoProdu(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoProdu(Boolean conFk) throws Exception  {
		return ProductoProduConstantesFunciones.getTiposSeleccionarProductoProdu(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoProdu(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU);
			reporte.setsDescripcion(ProductoProduConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ProductoProduConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProductoProduConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(ProductoProduConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(ProductoProduConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(ProductoProduConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(ProductoProduConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(ProductoProduConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ProductoProduConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductoProdu(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductoProdu(ProductoProdu productoproduAux) throws Exception {
		
			productoproduAux.setproductodefiprodu_descripcion(ProductoDefiProduConstantesFunciones.getProductoDefiProduDescripcion(productoproduAux.getProductoDefiProdu()));
			productoproduAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productoproduAux.getBodega()));
			productoproduAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productoproduAux.getProducto()));
			productoproduAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoproduAux.getUnidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductoProdu(List<ProductoProdu> productoprodusTemp) throws Exception {
		for(ProductoProdu productoproduAux:productoprodusTemp) {
			
			productoproduAux.setproductodefiprodu_descripcion(ProductoDefiProduConstantesFunciones.getProductoDefiProduDescripcion(productoproduAux.getProductoDefiProdu()));
			productoproduAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productoproduAux.getBodega()));
			productoproduAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productoproduAux.getProducto()));
			productoproduAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoproduAux.getUnidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductoProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ProductoDefiProdu.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoDefiProdu.class)) {
						classes.add(new Classe(ProductoDefiProdu.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductoProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoDefiProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoDefiProdu.class)); continue;
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

					if(ProductoDefiProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoDefiProdu.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoProduConstantesFunciones.getClassesRelationshipsOfProductoProdu(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoProduConstantesFunciones.getClassesRelationshipsFromStringsOfProductoProdu(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductoProdu productoprodu,List<ProductoProdu> productoprodus,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProductoProdu productoproduEncontrado=null;
			
			for(ProductoProdu productoproduLocal:productoprodus) {
				if(productoproduLocal.getId().equals(productoprodu.getId())) {
					productoproduEncontrado=productoproduLocal;
					
					productoproduLocal.setIsChanged(productoprodu.getIsChanged());
					productoproduLocal.setIsNew(productoprodu.getIsNew());
					productoproduLocal.setIsDeleted(productoprodu.getIsDeleted());
					
					productoproduLocal.setGeneralEntityOriginal(productoprodu.getGeneralEntityOriginal());
					
					productoproduLocal.setId(productoprodu.getId());	
					productoproduLocal.setVersionRow(productoprodu.getVersionRow());	
					productoproduLocal.setid_producto_defi_produ(productoprodu.getid_producto_defi_produ());	
					productoproduLocal.setid_bodega(productoprodu.getid_bodega());	
					productoproduLocal.setid_producto(productoprodu.getid_producto());	
					productoproduLocal.setid_unidad(productoprodu.getid_unidad());	
					productoproduLocal.setporcentaje(productoprodu.getporcentaje());	
					productoproduLocal.setcantidad(productoprodu.getcantidad());	
					productoproduLocal.setcosto(productoprodu.getcosto());	
					productoproduLocal.setcosto_total(productoprodu.getcosto_total());	
					productoproduLocal.setdescripcion(productoprodu.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!productoprodu.getIsDeleted()) {
				if(!existe) {
					productoprodus.add(productoprodu);
				}
			} else {
				if(productoproduEncontrado!=null && permiteQuitar)  {
					productoprodus.remove(productoproduEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProductoProdu productoprodu,List<ProductoProdu> productoprodus) throws Exception {
		try	{			
			for(ProductoProdu productoproduLocal:productoprodus) {
				if(productoproduLocal.getId().equals(productoprodu.getId())) {
					productoproduLocal.setIsSelected(productoprodu.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductoProdu(List<ProductoProdu> productoprodusAux) throws Exception {
		//this.productoprodusAux=productoprodusAux;
		
		for(ProductoProdu productoproduAux:productoprodusAux) {
			if(productoproduAux.getIsChanged()) {
				productoproduAux.setIsChanged(false);
			}		
			
			if(productoproduAux.getIsNew()) {
				productoproduAux.setIsNew(false);
			}	
			
			if(productoproduAux.getIsDeleted()) {
				productoproduAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductoProdu(ProductoProdu productoproduAux) throws Exception {
		//this.productoproduAux=productoproduAux;
		
			if(productoproduAux.getIsChanged()) {
				productoproduAux.setIsChanged(false);
			}		
			
			if(productoproduAux.getIsNew()) {
				productoproduAux.setIsNew(false);
			}	
			
			if(productoproduAux.getIsDeleted()) {
				productoproduAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductoProdu productoproduAsignar,ProductoProdu productoprodu) throws Exception {
		productoproduAsignar.setId(productoprodu.getId());	
		productoproduAsignar.setVersionRow(productoprodu.getVersionRow());	
		productoproduAsignar.setid_producto_defi_produ(productoprodu.getid_producto_defi_produ());
		productoproduAsignar.setproductodefiprodu_descripcion(productoprodu.getproductodefiprodu_descripcion());	
		productoproduAsignar.setid_bodega(productoprodu.getid_bodega());
		productoproduAsignar.setbodega_descripcion(productoprodu.getbodega_descripcion());	
		productoproduAsignar.setid_producto(productoprodu.getid_producto());
		productoproduAsignar.setproducto_descripcion(productoprodu.getproducto_descripcion());	
		productoproduAsignar.setid_unidad(productoprodu.getid_unidad());
		productoproduAsignar.setunidad_descripcion(productoprodu.getunidad_descripcion());	
		productoproduAsignar.setporcentaje(productoprodu.getporcentaje());	
		productoproduAsignar.setcantidad(productoprodu.getcantidad());	
		productoproduAsignar.setcosto(productoprodu.getcosto());	
		productoproduAsignar.setcosto_total(productoprodu.getcosto_total());	
		productoproduAsignar.setdescripcion(productoprodu.getdescripcion());	
	}
	
	public static void inicializarProductoProdu(ProductoProdu productoprodu) throws Exception {
		try {
				productoprodu.setId(0L);	
					
				productoprodu.setid_producto_defi_produ(-1L);	
				productoprodu.setid_bodega(-1L);	
				productoprodu.setid_producto(-1L);	
				productoprodu.setid_unidad(-1L);	
				productoprodu.setporcentaje(0.0);	
				productoprodu.setcantidad(0);	
				productoprodu.setcosto(0.0);	
				productoprodu.setcosto_total(0.0);	
				productoprodu.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductoProdu(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductoProdu(String sTipo,Row row,Workbook workbook,ProductoProdu productoprodu,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodu.getproductodefiprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodu.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodu.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodu.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodu.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodu.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodu.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodu.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodu.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductoProdu=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProductoProdu() {
		return this.sFinalQueryProductoProdu;
	}
	
	public void setsFinalQueryProductoProdu(String sFinalQueryProductoProdu) {
		this.sFinalQueryProductoProdu= sFinalQueryProductoProdu;
	}
	
	public Border resaltarSeleccionarProductoProdu=null;
	
	public Border setResaltarSeleccionarProductoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduBeanSwingJInternalFrame productoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productoproduBeanSwingJInternalFrame.jTtoolBarProductoProdu.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductoProdu= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductoProdu() {
		return this.resaltarSeleccionarProductoProdu;
	}
	
	public void setResaltarSeleccionarProductoProdu(Border borderResaltarSeleccionarProductoProdu) {
		this.resaltarSeleccionarProductoProdu= borderResaltarSeleccionarProductoProdu;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductoProdu=null;
	public Boolean mostraridProductoProdu=true;
	public Boolean activaridProductoProdu=true;

	public Border resaltarid_producto_defi_produProductoProdu=null;
	public Boolean mostrarid_producto_defi_produProductoProdu=true;
	public Boolean activarid_producto_defi_produProductoProdu=true;
	public Boolean cargarid_producto_defi_produProductoProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_producto_defi_produProductoProdu=false;//ConEventDepend=true

	public Border resaltarid_bodegaProductoProdu=null;
	public Boolean mostrarid_bodegaProductoProdu=true;
	public Boolean activarid_bodegaProductoProdu=true;
	public Boolean cargarid_bodegaProductoProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaProductoProdu=false;//ConEventDepend=true

	public Border resaltarid_productoProductoProdu=null;
	public Boolean mostrarid_productoProductoProdu=true;
	public Boolean activarid_productoProductoProdu=true;
	public Boolean cargarid_productoProductoProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProductoProdu=true;//ConEventDepend=true

	public Border resaltarid_unidadProductoProdu=null;
	public Boolean mostrarid_unidadProductoProdu=true;
	public Boolean activarid_unidadProductoProdu=true;
	public Boolean cargarid_unidadProductoProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadProductoProdu=true;//ConEventDepend=true

	public Border resaltarporcentajeProductoProdu=null;
	public Boolean mostrarporcentajeProductoProdu=true;
	public Boolean activarporcentajeProductoProdu=true;

	public Border resaltarcantidadProductoProdu=null;
	public Boolean mostrarcantidadProductoProdu=true;
	public Boolean activarcantidadProductoProdu=true;

	public Border resaltarcostoProductoProdu=null;
	public Boolean mostrarcostoProductoProdu=true;
	public Boolean activarcostoProductoProdu=true;

	public Border resaltarcosto_totalProductoProdu=null;
	public Boolean mostrarcosto_totalProductoProdu=true;
	public Boolean activarcosto_totalProductoProdu=true;

	public Border resaltardescripcionProductoProdu=null;
	public Boolean mostrardescripcionProductoProdu=true;
	public Boolean activardescripcionProductoProdu=true;

	
	

	public Border setResaltaridProductoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduBeanSwingJInternalFrame productoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoproduBeanSwingJInternalFrame.jTtoolBarProductoProdu.setBorder(borderResaltar);
		
		this.resaltaridProductoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductoProdu() {
		return this.resaltaridProductoProdu;
	}

	public void setResaltaridProductoProdu(Border borderResaltar) {
		this.resaltaridProductoProdu= borderResaltar;
	}

	public Boolean getMostraridProductoProdu() {
		return this.mostraridProductoProdu;
	}

	public void setMostraridProductoProdu(Boolean mostraridProductoProdu) {
		this.mostraridProductoProdu= mostraridProductoProdu;
	}

	public Boolean getActivaridProductoProdu() {
		return this.activaridProductoProdu;
	}

	public void setActivaridProductoProdu(Boolean activaridProductoProdu) {
		this.activaridProductoProdu= activaridProductoProdu;
	}

	public Border setResaltarid_producto_defi_produProductoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduBeanSwingJInternalFrame productoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoproduBeanSwingJInternalFrame.jTtoolBarProductoProdu.setBorder(borderResaltar);
		
		this.resaltarid_producto_defi_produProductoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_producto_defi_produProductoProdu() {
		return this.resaltarid_producto_defi_produProductoProdu;
	}

	public void setResaltarid_producto_defi_produProductoProdu(Border borderResaltar) {
		this.resaltarid_producto_defi_produProductoProdu= borderResaltar;
	}

	public Boolean getMostrarid_producto_defi_produProductoProdu() {
		return this.mostrarid_producto_defi_produProductoProdu;
	}

	public void setMostrarid_producto_defi_produProductoProdu(Boolean mostrarid_producto_defi_produProductoProdu) {
		this.mostrarid_producto_defi_produProductoProdu= mostrarid_producto_defi_produProductoProdu;
	}

	public Boolean getActivarid_producto_defi_produProductoProdu() {
		return this.activarid_producto_defi_produProductoProdu;
	}

	public void setActivarid_producto_defi_produProductoProdu(Boolean activarid_producto_defi_produProductoProdu) {
		this.activarid_producto_defi_produProductoProdu= activarid_producto_defi_produProductoProdu;
	}

	public Boolean getCargarid_producto_defi_produProductoProdu() {
		return this.cargarid_producto_defi_produProductoProdu;
	}

	public void setCargarid_producto_defi_produProductoProdu(Boolean cargarid_producto_defi_produProductoProdu) {
		this.cargarid_producto_defi_produProductoProdu= cargarid_producto_defi_produProductoProdu;
	}

	public Border setResaltarid_bodegaProductoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduBeanSwingJInternalFrame productoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoproduBeanSwingJInternalFrame.jTtoolBarProductoProdu.setBorder(borderResaltar);
		
		this.resaltarid_bodegaProductoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaProductoProdu() {
		return this.resaltarid_bodegaProductoProdu;
	}

	public void setResaltarid_bodegaProductoProdu(Border borderResaltar) {
		this.resaltarid_bodegaProductoProdu= borderResaltar;
	}

	public Boolean getMostrarid_bodegaProductoProdu() {
		return this.mostrarid_bodegaProductoProdu;
	}

	public void setMostrarid_bodegaProductoProdu(Boolean mostrarid_bodegaProductoProdu) {
		this.mostrarid_bodegaProductoProdu= mostrarid_bodegaProductoProdu;
	}

	public Boolean getActivarid_bodegaProductoProdu() {
		return this.activarid_bodegaProductoProdu;
	}

	public void setActivarid_bodegaProductoProdu(Boolean activarid_bodegaProductoProdu) {
		this.activarid_bodegaProductoProdu= activarid_bodegaProductoProdu;
	}

	public Boolean getCargarid_bodegaProductoProdu() {
		return this.cargarid_bodegaProductoProdu;
	}

	public void setCargarid_bodegaProductoProdu(Boolean cargarid_bodegaProductoProdu) {
		this.cargarid_bodegaProductoProdu= cargarid_bodegaProductoProdu;
	}

	public Border setResaltarid_productoProductoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduBeanSwingJInternalFrame productoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoproduBeanSwingJInternalFrame.jTtoolBarProductoProdu.setBorder(borderResaltar);
		
		this.resaltarid_productoProductoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProductoProdu() {
		return this.resaltarid_productoProductoProdu;
	}

	public void setResaltarid_productoProductoProdu(Border borderResaltar) {
		this.resaltarid_productoProductoProdu= borderResaltar;
	}

	public Boolean getMostrarid_productoProductoProdu() {
		return this.mostrarid_productoProductoProdu;
	}

	public void setMostrarid_productoProductoProdu(Boolean mostrarid_productoProductoProdu) {
		this.mostrarid_productoProductoProdu= mostrarid_productoProductoProdu;
	}

	public Boolean getActivarid_productoProductoProdu() {
		return this.activarid_productoProductoProdu;
	}

	public void setActivarid_productoProductoProdu(Boolean activarid_productoProductoProdu) {
		this.activarid_productoProductoProdu= activarid_productoProductoProdu;
	}

	public Boolean getCargarid_productoProductoProdu() {
		return this.cargarid_productoProductoProdu;
	}

	public void setCargarid_productoProductoProdu(Boolean cargarid_productoProductoProdu) {
		this.cargarid_productoProductoProdu= cargarid_productoProductoProdu;
	}

	public Border setResaltarid_unidadProductoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduBeanSwingJInternalFrame productoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoproduBeanSwingJInternalFrame.jTtoolBarProductoProdu.setBorder(borderResaltar);
		
		this.resaltarid_unidadProductoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadProductoProdu() {
		return this.resaltarid_unidadProductoProdu;
	}

	public void setResaltarid_unidadProductoProdu(Border borderResaltar) {
		this.resaltarid_unidadProductoProdu= borderResaltar;
	}

	public Boolean getMostrarid_unidadProductoProdu() {
		return this.mostrarid_unidadProductoProdu;
	}

	public void setMostrarid_unidadProductoProdu(Boolean mostrarid_unidadProductoProdu) {
		this.mostrarid_unidadProductoProdu= mostrarid_unidadProductoProdu;
	}

	public Boolean getActivarid_unidadProductoProdu() {
		return this.activarid_unidadProductoProdu;
	}

	public void setActivarid_unidadProductoProdu(Boolean activarid_unidadProductoProdu) {
		this.activarid_unidadProductoProdu= activarid_unidadProductoProdu;
	}

	public Boolean getCargarid_unidadProductoProdu() {
		return this.cargarid_unidadProductoProdu;
	}

	public void setCargarid_unidadProductoProdu(Boolean cargarid_unidadProductoProdu) {
		this.cargarid_unidadProductoProdu= cargarid_unidadProductoProdu;
	}

	public Border setResaltarporcentajeProductoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduBeanSwingJInternalFrame productoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoproduBeanSwingJInternalFrame.jTtoolBarProductoProdu.setBorder(borderResaltar);
		
		this.resaltarporcentajeProductoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeProductoProdu() {
		return this.resaltarporcentajeProductoProdu;
	}

	public void setResaltarporcentajeProductoProdu(Border borderResaltar) {
		this.resaltarporcentajeProductoProdu= borderResaltar;
	}

	public Boolean getMostrarporcentajeProductoProdu() {
		return this.mostrarporcentajeProductoProdu;
	}

	public void setMostrarporcentajeProductoProdu(Boolean mostrarporcentajeProductoProdu) {
		this.mostrarporcentajeProductoProdu= mostrarporcentajeProductoProdu;
	}

	public Boolean getActivarporcentajeProductoProdu() {
		return this.activarporcentajeProductoProdu;
	}

	public void setActivarporcentajeProductoProdu(Boolean activarporcentajeProductoProdu) {
		this.activarporcentajeProductoProdu= activarporcentajeProductoProdu;
	}

	public Border setResaltarcantidadProductoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduBeanSwingJInternalFrame productoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoproduBeanSwingJInternalFrame.jTtoolBarProductoProdu.setBorder(borderResaltar);
		
		this.resaltarcantidadProductoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadProductoProdu() {
		return this.resaltarcantidadProductoProdu;
	}

	public void setResaltarcantidadProductoProdu(Border borderResaltar) {
		this.resaltarcantidadProductoProdu= borderResaltar;
	}

	public Boolean getMostrarcantidadProductoProdu() {
		return this.mostrarcantidadProductoProdu;
	}

	public void setMostrarcantidadProductoProdu(Boolean mostrarcantidadProductoProdu) {
		this.mostrarcantidadProductoProdu= mostrarcantidadProductoProdu;
	}

	public Boolean getActivarcantidadProductoProdu() {
		return this.activarcantidadProductoProdu;
	}

	public void setActivarcantidadProductoProdu(Boolean activarcantidadProductoProdu) {
		this.activarcantidadProductoProdu= activarcantidadProductoProdu;
	}

	public Border setResaltarcostoProductoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduBeanSwingJInternalFrame productoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoproduBeanSwingJInternalFrame.jTtoolBarProductoProdu.setBorder(borderResaltar);
		
		this.resaltarcostoProductoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoProductoProdu() {
		return this.resaltarcostoProductoProdu;
	}

	public void setResaltarcostoProductoProdu(Border borderResaltar) {
		this.resaltarcostoProductoProdu= borderResaltar;
	}

	public Boolean getMostrarcostoProductoProdu() {
		return this.mostrarcostoProductoProdu;
	}

	public void setMostrarcostoProductoProdu(Boolean mostrarcostoProductoProdu) {
		this.mostrarcostoProductoProdu= mostrarcostoProductoProdu;
	}

	public Boolean getActivarcostoProductoProdu() {
		return this.activarcostoProductoProdu;
	}

	public void setActivarcostoProductoProdu(Boolean activarcostoProductoProdu) {
		this.activarcostoProductoProdu= activarcostoProductoProdu;
	}

	public Border setResaltarcosto_totalProductoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduBeanSwingJInternalFrame productoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoproduBeanSwingJInternalFrame.jTtoolBarProductoProdu.setBorder(borderResaltar);
		
		this.resaltarcosto_totalProductoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalProductoProdu() {
		return this.resaltarcosto_totalProductoProdu;
	}

	public void setResaltarcosto_totalProductoProdu(Border borderResaltar) {
		this.resaltarcosto_totalProductoProdu= borderResaltar;
	}

	public Boolean getMostrarcosto_totalProductoProdu() {
		return this.mostrarcosto_totalProductoProdu;
	}

	public void setMostrarcosto_totalProductoProdu(Boolean mostrarcosto_totalProductoProdu) {
		this.mostrarcosto_totalProductoProdu= mostrarcosto_totalProductoProdu;
	}

	public Boolean getActivarcosto_totalProductoProdu() {
		return this.activarcosto_totalProductoProdu;
	}

	public void setActivarcosto_totalProductoProdu(Boolean activarcosto_totalProductoProdu) {
		this.activarcosto_totalProductoProdu= activarcosto_totalProductoProdu;
	}

	public Border setResaltardescripcionProductoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduBeanSwingJInternalFrame productoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoproduBeanSwingJInternalFrame.jTtoolBarProductoProdu.setBorder(borderResaltar);
		
		this.resaltardescripcionProductoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionProductoProdu() {
		return this.resaltardescripcionProductoProdu;
	}

	public void setResaltardescripcionProductoProdu(Border borderResaltar) {
		this.resaltardescripcionProductoProdu= borderResaltar;
	}

	public Boolean getMostrardescripcionProductoProdu() {
		return this.mostrardescripcionProductoProdu;
	}

	public void setMostrardescripcionProductoProdu(Boolean mostrardescripcionProductoProdu) {
		this.mostrardescripcionProductoProdu= mostrardescripcionProductoProdu;
	}

	public Boolean getActivardescripcionProductoProdu() {
		return this.activardescripcionProductoProdu;
	}

	public void setActivardescripcionProductoProdu(Boolean activardescripcionProductoProdu) {
		this.activardescripcionProductoProdu= activardescripcionProductoProdu;
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
		
		
		this.setMostraridProductoProdu(esInicial);
		this.setMostrarid_producto_defi_produProductoProdu(esInicial);
		this.setMostrarid_bodegaProductoProdu(esInicial);
		this.setMostrarid_productoProductoProdu(esInicial);
		this.setMostrarid_unidadProductoProdu(esInicial);
		this.setMostrarporcentajeProductoProdu(esInicial);
		this.setMostrarcantidadProductoProdu(esInicial);
		this.setMostrarcostoProductoProdu(esInicial);
		this.setMostrarcosto_totalProductoProdu(esInicial);
		this.setMostrardescripcionProductoProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoProduConstantesFunciones.ID)) {
				this.setMostraridProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.IDPRODUCTODEFIPRODU)) {
				this.setMostrarid_producto_defi_produProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.COSTO)) {
				this.setMostrarcostoProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionProductoProdu(esAsigna);
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
		
		
		this.setActivaridProductoProdu(esInicial);
		this.setActivarid_producto_defi_produProductoProdu(esInicial);
		this.setActivarid_bodegaProductoProdu(esInicial);
		this.setActivarid_productoProductoProdu(esInicial);
		this.setActivarid_unidadProductoProdu(esInicial);
		this.setActivarporcentajeProductoProdu(esInicial);
		this.setActivarcantidadProductoProdu(esInicial);
		this.setActivarcostoProductoProdu(esInicial);
		this.setActivarcosto_totalProductoProdu(esInicial);
		this.setActivardescripcionProductoProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoProduConstantesFunciones.ID)) {
				this.setActivaridProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.IDPRODUCTODEFIPRODU)) {
				this.setActivarid_producto_defi_produProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.COSTO)) {
				this.setActivarcostoProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionProductoProdu(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoProduBeanSwingJInternalFrame productoproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductoProdu(esInicial);
		this.setResaltarid_producto_defi_produProductoProdu(esInicial);
		this.setResaltarid_bodegaProductoProdu(esInicial);
		this.setResaltarid_productoProductoProdu(esInicial);
		this.setResaltarid_unidadProductoProdu(esInicial);
		this.setResaltarporcentajeProductoProdu(esInicial);
		this.setResaltarcantidadProductoProdu(esInicial);
		this.setResaltarcostoProductoProdu(esInicial);
		this.setResaltarcosto_totalProductoProdu(esInicial);
		this.setResaltardescripcionProductoProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoProduConstantesFunciones.ID)) {
				this.setResaltaridProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.IDPRODUCTODEFIPRODU)) {
				this.setResaltarid_producto_defi_produProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.COSTO)) {
				this.setResaltarcostoProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalProductoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionProductoProdu(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoProduBeanSwingJInternalFrame productoproduBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaProductoProdu=true;

	public Boolean getMostrarFK_IdBodegaProductoProdu() {
		return this.mostrarFK_IdBodegaProductoProdu;
	}

	public void setMostrarFK_IdBodegaProductoProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaProductoProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoProductoProdu=true;

	public Boolean getMostrarFK_IdProductoProductoProdu() {
		return this.mostrarFK_IdProductoProductoProdu;
	}

	public void setMostrarFK_IdProductoProductoProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoProductoProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDefiProduProductoProdu=true;

	public Boolean getMostrarFK_IdProductoDefiProduProductoProdu() {
		return this.mostrarFK_IdProductoDefiProduProductoProdu;
	}

	public void setMostrarFK_IdProductoDefiProduProductoProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDefiProduProductoProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadUnadProductoProdu=true;

	public Boolean getMostrarFK_IdUnidadUnadProductoProdu() {
		return this.mostrarFK_IdUnidadUnadProductoProdu;
	}

	public void setMostrarFK_IdUnidadUnadProductoProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadUnadProductoProdu= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaProductoProdu=true;

	public Boolean getActivarFK_IdBodegaProductoProdu() {
		return this.activarFK_IdBodegaProductoProdu;
	}

	public void setActivarFK_IdBodegaProductoProdu(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaProductoProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoProductoProdu=true;

	public Boolean getActivarFK_IdProductoProductoProdu() {
		return this.activarFK_IdProductoProductoProdu;
	}

	public void setActivarFK_IdProductoProductoProdu(Boolean habilitarResaltar) {
		this.activarFK_IdProductoProductoProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDefiProduProductoProdu=true;

	public Boolean getActivarFK_IdProductoDefiProduProductoProdu() {
		return this.activarFK_IdProductoDefiProduProductoProdu;
	}

	public void setActivarFK_IdProductoDefiProduProductoProdu(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDefiProduProductoProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadUnadProductoProdu=true;

	public Boolean getActivarFK_IdUnidadUnadProductoProdu() {
		return this.activarFK_IdUnidadUnadProductoProdu;
	}

	public void setActivarFK_IdUnidadUnadProductoProdu(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadUnadProductoProdu= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaProductoProdu=null;

	public Border getResaltarFK_IdBodegaProductoProdu() {
		return this.resaltarFK_IdBodegaProductoProdu;
	}

	public void setResaltarFK_IdBodegaProductoProdu(Border borderResaltar) {
		this.resaltarFK_IdBodegaProductoProdu= borderResaltar;
	}

	public void setResaltarFK_IdBodegaProductoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduBeanSwingJInternalFrame productoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaProductoProdu= borderResaltar;
	}

	public Border resaltarFK_IdProductoProductoProdu=null;

	public Border getResaltarFK_IdProductoProductoProdu() {
		return this.resaltarFK_IdProductoProductoProdu;
	}

	public void setResaltarFK_IdProductoProductoProdu(Border borderResaltar) {
		this.resaltarFK_IdProductoProductoProdu= borderResaltar;
	}

	public void setResaltarFK_IdProductoProductoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduBeanSwingJInternalFrame productoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoProductoProdu= borderResaltar;
	}

	public Border resaltarFK_IdProductoDefiProduProductoProdu=null;

	public Border getResaltarFK_IdProductoDefiProduProductoProdu() {
		return this.resaltarFK_IdProductoDefiProduProductoProdu;
	}

	public void setResaltarFK_IdProductoDefiProduProductoProdu(Border borderResaltar) {
		this.resaltarFK_IdProductoDefiProduProductoProdu= borderResaltar;
	}

	public void setResaltarFK_IdProductoDefiProduProductoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduBeanSwingJInternalFrame productoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDefiProduProductoProdu= borderResaltar;
	}

	public Border resaltarFK_IdUnidadUnadProductoProdu=null;

	public Border getResaltarFK_IdUnidadUnadProductoProdu() {
		return this.resaltarFK_IdUnidadUnadProductoProdu;
	}

	public void setResaltarFK_IdUnidadUnadProductoProdu(Border borderResaltar) {
		this.resaltarFK_IdUnidadUnadProductoProdu= borderResaltar;
	}

	public void setResaltarFK_IdUnidadUnadProductoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduBeanSwingJInternalFrame productoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadUnadProductoProdu= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}