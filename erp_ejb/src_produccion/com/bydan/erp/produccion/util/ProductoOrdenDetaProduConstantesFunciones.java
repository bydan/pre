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


import com.bydan.erp.produccion.util.ProductoOrdenDetaProduConstantesFunciones;
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProductoOrdenDetaProduParameterGeneral;

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
final public class ProductoOrdenDetaProduConstantesFunciones extends ProductoOrdenDetaProduConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProductoOrdenDetaProdu";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductoOrdenDetaProdu"+ProductoOrdenDetaProduConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductoOrdenDetaProduHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductoOrdenDetaProduHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"_"+ProductoOrdenDetaProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductoOrdenDetaProduHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"_"+ProductoOrdenDetaProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"_"+ProductoOrdenDetaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductoOrdenDetaProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"_"+ProductoOrdenDetaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoOrdenDetaProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoOrdenDetaProduHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoOrdenDetaProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoOrdenDetaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoOrdenDetaProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoOrdenDetaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductoOrdenDetaProduConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductoOrdenDetaProduConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductoOrdenDetaProduConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductoOrdenDetaProduConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Orden Producto Producciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Orden Producto Produccion";
	public static final String SCLASSWEBTITULO_LOWER="Producto Orden Deta Produ";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductoOrdenDetaProdu";
	public static final String OBJECTNAME="productoordendetaprodu";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="producto_orden_deta_produ";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productoordendetaprodu from "+ProductoOrdenDetaProduConstantesFunciones.SPERSISTENCENAME+" productoordendetaprodu";
	public static String QUERYSELECTNATIVE="select "+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".id,"+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".version_row,"+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".id_orden_deta_produ,"+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".id_bodega,"+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".id_producto,"+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".id_unidad,"+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".porcentaje,"+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".cantidad,"+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".costo,"+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".costo_total,"+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".descripcion from "+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME;//+" as "+ProductoOrdenDetaProduConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProductoOrdenDetaProduConstantesFuncionesAdditional productoordendetaproduConstantesFuncionesAdditional=null;
	
	public ProductoOrdenDetaProduConstantesFuncionesAdditional getProductoOrdenDetaProduConstantesFuncionesAdditional() {
		return this.productoordendetaproduConstantesFuncionesAdditional;
	}
	
	public void setProductoOrdenDetaProduConstantesFuncionesAdditional(ProductoOrdenDetaProduConstantesFuncionesAdditional productoordendetaproduConstantesFuncionesAdditional) {
		try {
			this.productoordendetaproduConstantesFuncionesAdditional=productoordendetaproduConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDORDENDETAPRODU= "id_orden_deta_produ";
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
    	public static final String LABEL_IDORDENDETAPRODU= "Orden Deta Produ";
		public static final String LABEL_IDORDENDETAPRODU_LOWER= "Orden Deta Produ";
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
	
	public static String getProductoOrdenDetaProduLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductoOrdenDetaProduConstantesFunciones.IDORDENDETAPRODU)) {sLabelColumna=ProductoOrdenDetaProduConstantesFunciones.LABEL_IDORDENDETAPRODU;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduConstantesFunciones.IDBODEGA)) {sLabelColumna=ProductoOrdenDetaProduConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProductoOrdenDetaProduConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduConstantesFunciones.IDUNIDAD)) {sLabelColumna=ProductoOrdenDetaProduConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduConstantesFunciones.PORCENTAJE)) {sLabelColumna=ProductoOrdenDetaProduConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduConstantesFunciones.CANTIDAD)) {sLabelColumna=ProductoOrdenDetaProduConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduConstantesFunciones.COSTO)) {sLabelColumna=ProductoOrdenDetaProduConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduConstantesFunciones.COSTOTOTAL)) {sLabelColumna=ProductoOrdenDetaProduConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduConstantesFunciones.DESCRIPCION)) {sLabelColumna=ProductoOrdenDetaProduConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProductoOrdenDetaProduDescripcion(ProductoOrdenDetaProdu productoordendetaprodu) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productoordendetaprodu !=null/* && productoordendetaprodu.getId()!=0*/) {
			if(productoordendetaprodu.getId()!=null) {
				sDescripcion=productoordendetaprodu.getId().toString();
			}//productoordendetaproduproductoordendetaprodu.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductoOrdenDetaProduDescripcionDetallado(ProductoOrdenDetaProdu productoordendetaprodu) {
		String sDescripcion="";
			
		sDescripcion+=ProductoOrdenDetaProduConstantesFunciones.ID+"=";
		sDescripcion+=productoordendetaprodu.getId().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productoordendetaprodu.getVersionRow().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduConstantesFunciones.IDORDENDETAPRODU+"=";
		sDescripcion+=productoordendetaprodu.getid_orden_deta_produ().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=productoordendetaprodu.getid_bodega().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=productoordendetaprodu.getid_producto().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=productoordendetaprodu.getid_unidad().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=productoordendetaprodu.getporcentaje().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=productoordendetaprodu.getcantidad().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduConstantesFunciones.COSTO+"=";
		sDescripcion+=productoordendetaprodu.getcosto().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=productoordendetaprodu.getcosto_total().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=productoordendetaprodu.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setProductoOrdenDetaProduDescripcion(ProductoOrdenDetaProdu productoordendetaprodu,String sValor) throws Exception {			
		if(productoordendetaprodu !=null) {
			//productoordendetaproduproductoordendetaprodu.getId().toString();
		}		
	}
	
		

	public static String getOrdenDetaProduDescripcion(OrdenDetaProdu ordendetaprodu) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ordendetaprodu!=null/*&&ordendetaprodu.getId()>0*/) {
			sDescripcion=OrdenDetaProduConstantesFunciones.getOrdenDetaProduDescripcion(ordendetaprodu);
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
		} else if(sNombreIndice.equals("FK_IdOrdenDetaProdu")) {
			sNombreIndice="Tipo=  Por Orden Deta Produ";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
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

	public static String getDetalleIndiceFK_IdOrdenDetaProdu(Long id_orden_deta_produ) {
		String sDetalleIndice=" Parametros->";
		if(id_orden_deta_produ!=null) {sDetalleIndice+=" Codigo Unico De Orden Deta Produ="+id_orden_deta_produ.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidadUnad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProductoOrdenDetaProdu(ProductoOrdenDetaProdu productoordendetaprodu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productoordendetaprodu.setdescripcion(productoordendetaprodu.getdescripcion().trim());
	}
	
	public static void quitarEspaciosProductoOrdenDetaProdus(List<ProductoOrdenDetaProdu> productoordendetaprodus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoOrdenDetaProdu productoordendetaprodu: productoordendetaprodus) {
			productoordendetaprodu.setdescripcion(productoordendetaprodu.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoOrdenDetaProdu(ProductoOrdenDetaProdu productoordendetaprodu,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productoordendetaprodu.getConCambioAuxiliar()) {
			productoordendetaprodu.setIsDeleted(productoordendetaprodu.getIsDeletedAuxiliar());	
			productoordendetaprodu.setIsNew(productoordendetaprodu.getIsNewAuxiliar());	
			productoordendetaprodu.setIsChanged(productoordendetaprodu.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productoordendetaprodu.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productoordendetaprodu.setIsDeletedAuxiliar(false);	
			productoordendetaprodu.setIsNewAuxiliar(false);	
			productoordendetaprodu.setIsChangedAuxiliar(false);
			
			productoordendetaprodu.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoOrdenDetaProdus(List<ProductoOrdenDetaProdu> productoordendetaprodus,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductoOrdenDetaProdu productoordendetaprodu : productoordendetaprodus) {
			if(conAsignarBase && productoordendetaprodu.getConCambioAuxiliar()) {
				productoordendetaprodu.setIsDeleted(productoordendetaprodu.getIsDeletedAuxiliar());	
				productoordendetaprodu.setIsNew(productoordendetaprodu.getIsNewAuxiliar());	
				productoordendetaprodu.setIsChanged(productoordendetaprodu.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productoordendetaprodu.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productoordendetaprodu.setIsDeletedAuxiliar(false);	
				productoordendetaprodu.setIsNewAuxiliar(false);	
				productoordendetaprodu.setIsChangedAuxiliar(false);
				
				productoordendetaprodu.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductoOrdenDetaProdu(ProductoOrdenDetaProdu productoordendetaprodu,Boolean conEnteros) throws Exception  {
		productoordendetaprodu.setporcentaje(0.0);
		productoordendetaprodu.setcosto(0.0);
		productoordendetaprodu.setcosto_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			productoordendetaprodu.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresProductoOrdenDetaProdus(List<ProductoOrdenDetaProdu> productoordendetaprodus,Boolean conEnteros) throws Exception  {
		
		for(ProductoOrdenDetaProdu productoordendetaprodu: productoordendetaprodus) {
			productoordendetaprodu.setporcentaje(0.0);
			productoordendetaprodu.setcosto(0.0);
			productoordendetaprodu.setcosto_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				productoordendetaprodu.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductoOrdenDetaProdu(List<ProductoOrdenDetaProdu> productoordendetaprodus,ProductoOrdenDetaProdu productoordendetaproduAux) throws Exception  {
		ProductoOrdenDetaProduConstantesFunciones.InicializarValoresProductoOrdenDetaProdu(productoordendetaproduAux,true);
		
		for(ProductoOrdenDetaProdu productoordendetaprodu: productoordendetaprodus) {
			if(productoordendetaprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productoordendetaproduAux.setporcentaje(productoordendetaproduAux.getporcentaje()+productoordendetaprodu.getporcentaje());			
			productoordendetaproduAux.setcantidad(productoordendetaproduAux.getcantidad()+productoordendetaprodu.getcantidad());			
			productoordendetaproduAux.setcosto(productoordendetaproduAux.getcosto()+productoordendetaprodu.getcosto());			
			productoordendetaproduAux.setcosto_total(productoordendetaproduAux.getcosto_total()+productoordendetaprodu.getcosto_total());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoOrdenDetaProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductoOrdenDetaProduConstantesFunciones.getArrayColumnasGlobalesProductoOrdenDetaProdu(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoOrdenDetaProdu(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductoOrdenDetaProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoOrdenDetaProdu> productoordendetaprodus,ProductoOrdenDetaProdu productoordendetaprodu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoOrdenDetaProdu productoordendetaproduAux: productoordendetaprodus) {
			if(productoordendetaproduAux!=null && productoordendetaprodu!=null) {
				if((productoordendetaproduAux.getId()==null && productoordendetaprodu.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productoordendetaproduAux.getId()!=null && productoordendetaprodu.getId()!=null){
					if(productoordendetaproduAux.getId().equals(productoordendetaprodu.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoOrdenDetaProdu(List<ProductoOrdenDetaProdu> productoordendetaprodus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double costoTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(ProductoOrdenDetaProdu productoordendetaprodu: productoordendetaprodus) {			
			if(productoordendetaprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=productoordendetaprodu.getporcentaje();
			costoTotal+=productoordendetaprodu.getcosto();
			costo_totalTotal+=productoordendetaprodu.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoOrdenDetaProduConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(ProductoOrdenDetaProduConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoOrdenDetaProduConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(ProductoOrdenDetaProduConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoOrdenDetaProduConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(ProductoOrdenDetaProduConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductoOrdenDetaProdu() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductoOrdenDetaProduConstantesFunciones.LABEL_ID, ProductoOrdenDetaProduConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduConstantesFunciones.LABEL_VERSIONROW, ProductoOrdenDetaProduConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduConstantesFunciones.LABEL_IDORDENDETAPRODU, ProductoOrdenDetaProduConstantesFunciones.IDORDENDETAPRODU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduConstantesFunciones.LABEL_IDBODEGA, ProductoOrdenDetaProduConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduConstantesFunciones.LABEL_IDPRODUCTO, ProductoOrdenDetaProduConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduConstantesFunciones.LABEL_IDUNIDAD, ProductoOrdenDetaProduConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduConstantesFunciones.LABEL_PORCENTAJE, ProductoOrdenDetaProduConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduConstantesFunciones.LABEL_CANTIDAD, ProductoOrdenDetaProduConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduConstantesFunciones.LABEL_COSTO, ProductoOrdenDetaProduConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduConstantesFunciones.LABEL_COSTOTOTAL, ProductoOrdenDetaProduConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduConstantesFunciones.LABEL_DESCRIPCION, ProductoOrdenDetaProduConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductoOrdenDetaProdu() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduConstantesFunciones.IDORDENDETAPRODU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoOrdenDetaProdu() throws Exception  {
		return ProductoOrdenDetaProduConstantesFunciones.getTiposSeleccionarProductoOrdenDetaProdu(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoOrdenDetaProdu(Boolean conFk) throws Exception  {
		return ProductoOrdenDetaProduConstantesFunciones.getTiposSeleccionarProductoOrdenDetaProdu(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoOrdenDetaProdu(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduConstantesFunciones.LABEL_IDORDENDETAPRODU);
			reporte.setsDescripcion(ProductoOrdenDetaProduConstantesFunciones.LABEL_IDORDENDETAPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ProductoOrdenDetaProduConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProductoOrdenDetaProduConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(ProductoOrdenDetaProduConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(ProductoOrdenDetaProduConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(ProductoOrdenDetaProduConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(ProductoOrdenDetaProduConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(ProductoOrdenDetaProduConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ProductoOrdenDetaProduConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductoOrdenDetaProdu(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(ProductoOrdenDetaProdu productoordendetaproduAux) throws Exception {
		
			productoordendetaproduAux.setordendetaprodu_descripcion(OrdenDetaProduConstantesFunciones.getOrdenDetaProduDescripcion(productoordendetaproduAux.getOrdenDetaProdu()));
			productoordendetaproduAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productoordendetaproduAux.getBodega()));
			productoordendetaproduAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productoordendetaproduAux.getProducto()));
			productoordendetaproduAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoordendetaproduAux.getUnidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(List<ProductoOrdenDetaProdu> productoordendetaprodusTemp) throws Exception {
		for(ProductoOrdenDetaProdu productoordendetaproduAux:productoordendetaprodusTemp) {
			
			productoordendetaproduAux.setordendetaprodu_descripcion(OrdenDetaProduConstantesFunciones.getOrdenDetaProduDescripcion(productoordendetaproduAux.getOrdenDetaProdu()));
			productoordendetaproduAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productoordendetaproduAux.getBodega()));
			productoordendetaproduAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productoordendetaproduAux.getProducto()));
			productoordendetaproduAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoordendetaproduAux.getUnidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductoOrdenDetaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(OrdenDetaProdu.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(OrdenDetaProdu.class)) {
						classes.add(new Classe(OrdenDetaProdu.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductoOrdenDetaProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(OrdenDetaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenDetaProdu.class)); continue;
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

					if(OrdenDetaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenDetaProdu.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoOrdenDetaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoOrdenDetaProduConstantesFunciones.getClassesRelationshipsOfProductoOrdenDetaProdu(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoOrdenDetaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoOrdenDetaProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoOrdenDetaProduConstantesFunciones.getClassesRelationshipsFromStringsOfProductoOrdenDetaProdu(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoOrdenDetaProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductoOrdenDetaProdu productoordendetaprodu,List<ProductoOrdenDetaProdu> productoordendetaprodus,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProductoOrdenDetaProdu productoordendetaproduEncontrado=null;
			
			for(ProductoOrdenDetaProdu productoordendetaproduLocal:productoordendetaprodus) {
				if(productoordendetaproduLocal.getId().equals(productoordendetaprodu.getId())) {
					productoordendetaproduEncontrado=productoordendetaproduLocal;
					
					productoordendetaproduLocal.setIsChanged(productoordendetaprodu.getIsChanged());
					productoordendetaproduLocal.setIsNew(productoordendetaprodu.getIsNew());
					productoordendetaproduLocal.setIsDeleted(productoordendetaprodu.getIsDeleted());
					
					productoordendetaproduLocal.setGeneralEntityOriginal(productoordendetaprodu.getGeneralEntityOriginal());
					
					productoordendetaproduLocal.setId(productoordendetaprodu.getId());	
					productoordendetaproduLocal.setVersionRow(productoordendetaprodu.getVersionRow());	
					productoordendetaproduLocal.setid_orden_deta_produ(productoordendetaprodu.getid_orden_deta_produ());	
					productoordendetaproduLocal.setid_bodega(productoordendetaprodu.getid_bodega());	
					productoordendetaproduLocal.setid_producto(productoordendetaprodu.getid_producto());	
					productoordendetaproduLocal.setid_unidad(productoordendetaprodu.getid_unidad());	
					productoordendetaproduLocal.setporcentaje(productoordendetaprodu.getporcentaje());	
					productoordendetaproduLocal.setcantidad(productoordendetaprodu.getcantidad());	
					productoordendetaproduLocal.setcosto(productoordendetaprodu.getcosto());	
					productoordendetaproduLocal.setcosto_total(productoordendetaprodu.getcosto_total());	
					productoordendetaproduLocal.setdescripcion(productoordendetaprodu.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!productoordendetaprodu.getIsDeleted()) {
				if(!existe) {
					productoordendetaprodus.add(productoordendetaprodu);
				}
			} else {
				if(productoordendetaproduEncontrado!=null && permiteQuitar)  {
					productoordendetaprodus.remove(productoordendetaproduEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProductoOrdenDetaProdu productoordendetaprodu,List<ProductoOrdenDetaProdu> productoordendetaprodus) throws Exception {
		try	{			
			for(ProductoOrdenDetaProdu productoordendetaproduLocal:productoordendetaprodus) {
				if(productoordendetaproduLocal.getId().equals(productoordendetaprodu.getId())) {
					productoordendetaproduLocal.setIsSelected(productoordendetaprodu.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductoOrdenDetaProdu(List<ProductoOrdenDetaProdu> productoordendetaprodusAux) throws Exception {
		//this.productoordendetaprodusAux=productoordendetaprodusAux;
		
		for(ProductoOrdenDetaProdu productoordendetaproduAux:productoordendetaprodusAux) {
			if(productoordendetaproduAux.getIsChanged()) {
				productoordendetaproduAux.setIsChanged(false);
			}		
			
			if(productoordendetaproduAux.getIsNew()) {
				productoordendetaproduAux.setIsNew(false);
			}	
			
			if(productoordendetaproduAux.getIsDeleted()) {
				productoordendetaproduAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductoOrdenDetaProdu(ProductoOrdenDetaProdu productoordendetaproduAux) throws Exception {
		//this.productoordendetaproduAux=productoordendetaproduAux;
		
			if(productoordendetaproduAux.getIsChanged()) {
				productoordendetaproduAux.setIsChanged(false);
			}		
			
			if(productoordendetaproduAux.getIsNew()) {
				productoordendetaproduAux.setIsNew(false);
			}	
			
			if(productoordendetaproduAux.getIsDeleted()) {
				productoordendetaproduAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductoOrdenDetaProdu productoordendetaproduAsignar,ProductoOrdenDetaProdu productoordendetaprodu) throws Exception {
		productoordendetaproduAsignar.setId(productoordendetaprodu.getId());	
		productoordendetaproduAsignar.setVersionRow(productoordendetaprodu.getVersionRow());	
		productoordendetaproduAsignar.setid_orden_deta_produ(productoordendetaprodu.getid_orden_deta_produ());
		productoordendetaproduAsignar.setordendetaprodu_descripcion(productoordendetaprodu.getordendetaprodu_descripcion());	
		productoordendetaproduAsignar.setid_bodega(productoordendetaprodu.getid_bodega());
		productoordendetaproduAsignar.setbodega_descripcion(productoordendetaprodu.getbodega_descripcion());	
		productoordendetaproduAsignar.setid_producto(productoordendetaprodu.getid_producto());
		productoordendetaproduAsignar.setproducto_descripcion(productoordendetaprodu.getproducto_descripcion());	
		productoordendetaproduAsignar.setid_unidad(productoordendetaprodu.getid_unidad());
		productoordendetaproduAsignar.setunidad_descripcion(productoordendetaprodu.getunidad_descripcion());	
		productoordendetaproduAsignar.setporcentaje(productoordendetaprodu.getporcentaje());	
		productoordendetaproduAsignar.setcantidad(productoordendetaprodu.getcantidad());	
		productoordendetaproduAsignar.setcosto(productoordendetaprodu.getcosto());	
		productoordendetaproduAsignar.setcosto_total(productoordendetaprodu.getcosto_total());	
		productoordendetaproduAsignar.setdescripcion(productoordendetaprodu.getdescripcion());	
	}
	
	public static void inicializarProductoOrdenDetaProdu(ProductoOrdenDetaProdu productoordendetaprodu) throws Exception {
		try {
				productoordendetaprodu.setId(0L);	
					
				productoordendetaprodu.setid_orden_deta_produ(-1L);	
				productoordendetaprodu.setid_bodega(-1L);	
				productoordendetaprodu.setid_producto(-1L);	
				productoordendetaprodu.setid_unidad(-1L);	
				productoordendetaprodu.setporcentaje(0.0);	
				productoordendetaprodu.setcantidad(0);	
				productoordendetaprodu.setcosto(0.0);	
				productoordendetaprodu.setcosto_total(0.0);	
				productoordendetaprodu.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductoOrdenDetaProdu(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduConstantesFunciones.LABEL_IDORDENDETAPRODU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductoOrdenDetaProdu(String sTipo,Row row,Workbook workbook,ProductoOrdenDetaProdu productoordendetaprodu,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodu.getordendetaprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodu.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodu.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodu.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodu.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodu.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodu.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodu.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodu.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductoOrdenDetaProdu=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProductoOrdenDetaProdu() {
		return this.sFinalQueryProductoOrdenDetaProdu;
	}
	
	public void setsFinalQueryProductoOrdenDetaProdu(String sFinalQueryProductoOrdenDetaProdu) {
		this.sFinalQueryProductoOrdenDetaProdu= sFinalQueryProductoOrdenDetaProdu;
	}
	
	public Border resaltarSeleccionarProductoOrdenDetaProdu=null;
	
	public Border setResaltarSeleccionarProductoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduBeanSwingJInternalFrame productoordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productoordendetaproduBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductoOrdenDetaProdu= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductoOrdenDetaProdu() {
		return this.resaltarSeleccionarProductoOrdenDetaProdu;
	}
	
	public void setResaltarSeleccionarProductoOrdenDetaProdu(Border borderResaltarSeleccionarProductoOrdenDetaProdu) {
		this.resaltarSeleccionarProductoOrdenDetaProdu= borderResaltarSeleccionarProductoOrdenDetaProdu;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductoOrdenDetaProdu=null;
	public Boolean mostraridProductoOrdenDetaProdu=true;
	public Boolean activaridProductoOrdenDetaProdu=true;

	public Border resaltarid_orden_deta_produProductoOrdenDetaProdu=null;
	public Boolean mostrarid_orden_deta_produProductoOrdenDetaProdu=true;
	public Boolean activarid_orden_deta_produProductoOrdenDetaProdu=true;
	public Boolean cargarid_orden_deta_produProductoOrdenDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_orden_deta_produProductoOrdenDetaProdu=false;//ConEventDepend=true

	public Border resaltarid_bodegaProductoOrdenDetaProdu=null;
	public Boolean mostrarid_bodegaProductoOrdenDetaProdu=true;
	public Boolean activarid_bodegaProductoOrdenDetaProdu=true;
	public Boolean cargarid_bodegaProductoOrdenDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaProductoOrdenDetaProdu=false;//ConEventDepend=true

	public Border resaltarid_productoProductoOrdenDetaProdu=null;
	public Boolean mostrarid_productoProductoOrdenDetaProdu=true;
	public Boolean activarid_productoProductoOrdenDetaProdu=true;
	public Boolean cargarid_productoProductoOrdenDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProductoOrdenDetaProdu=true;//ConEventDepend=true

	public Border resaltarid_unidadProductoOrdenDetaProdu=null;
	public Boolean mostrarid_unidadProductoOrdenDetaProdu=true;
	public Boolean activarid_unidadProductoOrdenDetaProdu=true;
	public Boolean cargarid_unidadProductoOrdenDetaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadProductoOrdenDetaProdu=true;//ConEventDepend=true

	public Border resaltarporcentajeProductoOrdenDetaProdu=null;
	public Boolean mostrarporcentajeProductoOrdenDetaProdu=true;
	public Boolean activarporcentajeProductoOrdenDetaProdu=true;

	public Border resaltarcantidadProductoOrdenDetaProdu=null;
	public Boolean mostrarcantidadProductoOrdenDetaProdu=true;
	public Boolean activarcantidadProductoOrdenDetaProdu=true;

	public Border resaltarcostoProductoOrdenDetaProdu=null;
	public Boolean mostrarcostoProductoOrdenDetaProdu=true;
	public Boolean activarcostoProductoOrdenDetaProdu=true;

	public Border resaltarcosto_totalProductoOrdenDetaProdu=null;
	public Boolean mostrarcosto_totalProductoOrdenDetaProdu=true;
	public Boolean activarcosto_totalProductoOrdenDetaProdu=true;

	public Border resaltardescripcionProductoOrdenDetaProdu=null;
	public Boolean mostrardescripcionProductoOrdenDetaProdu=true;
	public Boolean activardescripcionProductoOrdenDetaProdu=true;

	
	

	public Border setResaltaridProductoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduBeanSwingJInternalFrame productoordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaproduBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltaridProductoOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductoOrdenDetaProdu() {
		return this.resaltaridProductoOrdenDetaProdu;
	}

	public void setResaltaridProductoOrdenDetaProdu(Border borderResaltar) {
		this.resaltaridProductoOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostraridProductoOrdenDetaProdu() {
		return this.mostraridProductoOrdenDetaProdu;
	}

	public void setMostraridProductoOrdenDetaProdu(Boolean mostraridProductoOrdenDetaProdu) {
		this.mostraridProductoOrdenDetaProdu= mostraridProductoOrdenDetaProdu;
	}

	public Boolean getActivaridProductoOrdenDetaProdu() {
		return this.activaridProductoOrdenDetaProdu;
	}

	public void setActivaridProductoOrdenDetaProdu(Boolean activaridProductoOrdenDetaProdu) {
		this.activaridProductoOrdenDetaProdu= activaridProductoOrdenDetaProdu;
	}

	public Border setResaltarid_orden_deta_produProductoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduBeanSwingJInternalFrame productoordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaproduBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_orden_deta_produProductoOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_orden_deta_produProductoOrdenDetaProdu() {
		return this.resaltarid_orden_deta_produProductoOrdenDetaProdu;
	}

	public void setResaltarid_orden_deta_produProductoOrdenDetaProdu(Border borderResaltar) {
		this.resaltarid_orden_deta_produProductoOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_orden_deta_produProductoOrdenDetaProdu() {
		return this.mostrarid_orden_deta_produProductoOrdenDetaProdu;
	}

	public void setMostrarid_orden_deta_produProductoOrdenDetaProdu(Boolean mostrarid_orden_deta_produProductoOrdenDetaProdu) {
		this.mostrarid_orden_deta_produProductoOrdenDetaProdu= mostrarid_orden_deta_produProductoOrdenDetaProdu;
	}

	public Boolean getActivarid_orden_deta_produProductoOrdenDetaProdu() {
		return this.activarid_orden_deta_produProductoOrdenDetaProdu;
	}

	public void setActivarid_orden_deta_produProductoOrdenDetaProdu(Boolean activarid_orden_deta_produProductoOrdenDetaProdu) {
		this.activarid_orden_deta_produProductoOrdenDetaProdu= activarid_orden_deta_produProductoOrdenDetaProdu;
	}

	public Boolean getCargarid_orden_deta_produProductoOrdenDetaProdu() {
		return this.cargarid_orden_deta_produProductoOrdenDetaProdu;
	}

	public void setCargarid_orden_deta_produProductoOrdenDetaProdu(Boolean cargarid_orden_deta_produProductoOrdenDetaProdu) {
		this.cargarid_orden_deta_produProductoOrdenDetaProdu= cargarid_orden_deta_produProductoOrdenDetaProdu;
	}

	public Border setResaltarid_bodegaProductoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduBeanSwingJInternalFrame productoordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaproduBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_bodegaProductoOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaProductoOrdenDetaProdu() {
		return this.resaltarid_bodegaProductoOrdenDetaProdu;
	}

	public void setResaltarid_bodegaProductoOrdenDetaProdu(Border borderResaltar) {
		this.resaltarid_bodegaProductoOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_bodegaProductoOrdenDetaProdu() {
		return this.mostrarid_bodegaProductoOrdenDetaProdu;
	}

	public void setMostrarid_bodegaProductoOrdenDetaProdu(Boolean mostrarid_bodegaProductoOrdenDetaProdu) {
		this.mostrarid_bodegaProductoOrdenDetaProdu= mostrarid_bodegaProductoOrdenDetaProdu;
	}

	public Boolean getActivarid_bodegaProductoOrdenDetaProdu() {
		return this.activarid_bodegaProductoOrdenDetaProdu;
	}

	public void setActivarid_bodegaProductoOrdenDetaProdu(Boolean activarid_bodegaProductoOrdenDetaProdu) {
		this.activarid_bodegaProductoOrdenDetaProdu= activarid_bodegaProductoOrdenDetaProdu;
	}

	public Boolean getCargarid_bodegaProductoOrdenDetaProdu() {
		return this.cargarid_bodegaProductoOrdenDetaProdu;
	}

	public void setCargarid_bodegaProductoOrdenDetaProdu(Boolean cargarid_bodegaProductoOrdenDetaProdu) {
		this.cargarid_bodegaProductoOrdenDetaProdu= cargarid_bodegaProductoOrdenDetaProdu;
	}

	public Border setResaltarid_productoProductoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduBeanSwingJInternalFrame productoordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaproduBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_productoProductoOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProductoOrdenDetaProdu() {
		return this.resaltarid_productoProductoOrdenDetaProdu;
	}

	public void setResaltarid_productoProductoOrdenDetaProdu(Border borderResaltar) {
		this.resaltarid_productoProductoOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_productoProductoOrdenDetaProdu() {
		return this.mostrarid_productoProductoOrdenDetaProdu;
	}

	public void setMostrarid_productoProductoOrdenDetaProdu(Boolean mostrarid_productoProductoOrdenDetaProdu) {
		this.mostrarid_productoProductoOrdenDetaProdu= mostrarid_productoProductoOrdenDetaProdu;
	}

	public Boolean getActivarid_productoProductoOrdenDetaProdu() {
		return this.activarid_productoProductoOrdenDetaProdu;
	}

	public void setActivarid_productoProductoOrdenDetaProdu(Boolean activarid_productoProductoOrdenDetaProdu) {
		this.activarid_productoProductoOrdenDetaProdu= activarid_productoProductoOrdenDetaProdu;
	}

	public Boolean getCargarid_productoProductoOrdenDetaProdu() {
		return this.cargarid_productoProductoOrdenDetaProdu;
	}

	public void setCargarid_productoProductoOrdenDetaProdu(Boolean cargarid_productoProductoOrdenDetaProdu) {
		this.cargarid_productoProductoOrdenDetaProdu= cargarid_productoProductoOrdenDetaProdu;
	}

	public Border setResaltarid_unidadProductoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduBeanSwingJInternalFrame productoordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaproduBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltarid_unidadProductoOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadProductoOrdenDetaProdu() {
		return this.resaltarid_unidadProductoOrdenDetaProdu;
	}

	public void setResaltarid_unidadProductoOrdenDetaProdu(Border borderResaltar) {
		this.resaltarid_unidadProductoOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostrarid_unidadProductoOrdenDetaProdu() {
		return this.mostrarid_unidadProductoOrdenDetaProdu;
	}

	public void setMostrarid_unidadProductoOrdenDetaProdu(Boolean mostrarid_unidadProductoOrdenDetaProdu) {
		this.mostrarid_unidadProductoOrdenDetaProdu= mostrarid_unidadProductoOrdenDetaProdu;
	}

	public Boolean getActivarid_unidadProductoOrdenDetaProdu() {
		return this.activarid_unidadProductoOrdenDetaProdu;
	}

	public void setActivarid_unidadProductoOrdenDetaProdu(Boolean activarid_unidadProductoOrdenDetaProdu) {
		this.activarid_unidadProductoOrdenDetaProdu= activarid_unidadProductoOrdenDetaProdu;
	}

	public Boolean getCargarid_unidadProductoOrdenDetaProdu() {
		return this.cargarid_unidadProductoOrdenDetaProdu;
	}

	public void setCargarid_unidadProductoOrdenDetaProdu(Boolean cargarid_unidadProductoOrdenDetaProdu) {
		this.cargarid_unidadProductoOrdenDetaProdu= cargarid_unidadProductoOrdenDetaProdu;
	}

	public Border setResaltarporcentajeProductoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduBeanSwingJInternalFrame productoordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaproduBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltarporcentajeProductoOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeProductoOrdenDetaProdu() {
		return this.resaltarporcentajeProductoOrdenDetaProdu;
	}

	public void setResaltarporcentajeProductoOrdenDetaProdu(Border borderResaltar) {
		this.resaltarporcentajeProductoOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostrarporcentajeProductoOrdenDetaProdu() {
		return this.mostrarporcentajeProductoOrdenDetaProdu;
	}

	public void setMostrarporcentajeProductoOrdenDetaProdu(Boolean mostrarporcentajeProductoOrdenDetaProdu) {
		this.mostrarporcentajeProductoOrdenDetaProdu= mostrarporcentajeProductoOrdenDetaProdu;
	}

	public Boolean getActivarporcentajeProductoOrdenDetaProdu() {
		return this.activarporcentajeProductoOrdenDetaProdu;
	}

	public void setActivarporcentajeProductoOrdenDetaProdu(Boolean activarporcentajeProductoOrdenDetaProdu) {
		this.activarporcentajeProductoOrdenDetaProdu= activarporcentajeProductoOrdenDetaProdu;
	}

	public Border setResaltarcantidadProductoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduBeanSwingJInternalFrame productoordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaproduBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltarcantidadProductoOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadProductoOrdenDetaProdu() {
		return this.resaltarcantidadProductoOrdenDetaProdu;
	}

	public void setResaltarcantidadProductoOrdenDetaProdu(Border borderResaltar) {
		this.resaltarcantidadProductoOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostrarcantidadProductoOrdenDetaProdu() {
		return this.mostrarcantidadProductoOrdenDetaProdu;
	}

	public void setMostrarcantidadProductoOrdenDetaProdu(Boolean mostrarcantidadProductoOrdenDetaProdu) {
		this.mostrarcantidadProductoOrdenDetaProdu= mostrarcantidadProductoOrdenDetaProdu;
	}

	public Boolean getActivarcantidadProductoOrdenDetaProdu() {
		return this.activarcantidadProductoOrdenDetaProdu;
	}

	public void setActivarcantidadProductoOrdenDetaProdu(Boolean activarcantidadProductoOrdenDetaProdu) {
		this.activarcantidadProductoOrdenDetaProdu= activarcantidadProductoOrdenDetaProdu;
	}

	public Border setResaltarcostoProductoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduBeanSwingJInternalFrame productoordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaproduBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltarcostoProductoOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoProductoOrdenDetaProdu() {
		return this.resaltarcostoProductoOrdenDetaProdu;
	}

	public void setResaltarcostoProductoOrdenDetaProdu(Border borderResaltar) {
		this.resaltarcostoProductoOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostrarcostoProductoOrdenDetaProdu() {
		return this.mostrarcostoProductoOrdenDetaProdu;
	}

	public void setMostrarcostoProductoOrdenDetaProdu(Boolean mostrarcostoProductoOrdenDetaProdu) {
		this.mostrarcostoProductoOrdenDetaProdu= mostrarcostoProductoOrdenDetaProdu;
	}

	public Boolean getActivarcostoProductoOrdenDetaProdu() {
		return this.activarcostoProductoOrdenDetaProdu;
	}

	public void setActivarcostoProductoOrdenDetaProdu(Boolean activarcostoProductoOrdenDetaProdu) {
		this.activarcostoProductoOrdenDetaProdu= activarcostoProductoOrdenDetaProdu;
	}

	public Border setResaltarcosto_totalProductoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduBeanSwingJInternalFrame productoordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaproduBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltarcosto_totalProductoOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalProductoOrdenDetaProdu() {
		return this.resaltarcosto_totalProductoOrdenDetaProdu;
	}

	public void setResaltarcosto_totalProductoOrdenDetaProdu(Border borderResaltar) {
		this.resaltarcosto_totalProductoOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostrarcosto_totalProductoOrdenDetaProdu() {
		return this.mostrarcosto_totalProductoOrdenDetaProdu;
	}

	public void setMostrarcosto_totalProductoOrdenDetaProdu(Boolean mostrarcosto_totalProductoOrdenDetaProdu) {
		this.mostrarcosto_totalProductoOrdenDetaProdu= mostrarcosto_totalProductoOrdenDetaProdu;
	}

	public Boolean getActivarcosto_totalProductoOrdenDetaProdu() {
		return this.activarcosto_totalProductoOrdenDetaProdu;
	}

	public void setActivarcosto_totalProductoOrdenDetaProdu(Boolean activarcosto_totalProductoOrdenDetaProdu) {
		this.activarcosto_totalProductoOrdenDetaProdu= activarcosto_totalProductoOrdenDetaProdu;
	}

	public Border setResaltardescripcionProductoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduBeanSwingJInternalFrame productoordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaproduBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProdu.setBorder(borderResaltar);
		
		this.resaltardescripcionProductoOrdenDetaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionProductoOrdenDetaProdu() {
		return this.resaltardescripcionProductoOrdenDetaProdu;
	}

	public void setResaltardescripcionProductoOrdenDetaProdu(Border borderResaltar) {
		this.resaltardescripcionProductoOrdenDetaProdu= borderResaltar;
	}

	public Boolean getMostrardescripcionProductoOrdenDetaProdu() {
		return this.mostrardescripcionProductoOrdenDetaProdu;
	}

	public void setMostrardescripcionProductoOrdenDetaProdu(Boolean mostrardescripcionProductoOrdenDetaProdu) {
		this.mostrardescripcionProductoOrdenDetaProdu= mostrardescripcionProductoOrdenDetaProdu;
	}

	public Boolean getActivardescripcionProductoOrdenDetaProdu() {
		return this.activardescripcionProductoOrdenDetaProdu;
	}

	public void setActivardescripcionProductoOrdenDetaProdu(Boolean activardescripcionProductoOrdenDetaProdu) {
		this.activardescripcionProductoOrdenDetaProdu= activardescripcionProductoOrdenDetaProdu;
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
		
		
		this.setMostraridProductoOrdenDetaProdu(esInicial);
		this.setMostrarid_orden_deta_produProductoOrdenDetaProdu(esInicial);
		this.setMostrarid_bodegaProductoOrdenDetaProdu(esInicial);
		this.setMostrarid_productoProductoOrdenDetaProdu(esInicial);
		this.setMostrarid_unidadProductoOrdenDetaProdu(esInicial);
		this.setMostrarporcentajeProductoOrdenDetaProdu(esInicial);
		this.setMostrarcantidadProductoOrdenDetaProdu(esInicial);
		this.setMostrarcostoProductoOrdenDetaProdu(esInicial);
		this.setMostrarcosto_totalProductoOrdenDetaProdu(esInicial);
		this.setMostrardescripcionProductoOrdenDetaProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.ID)) {
				this.setMostraridProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.IDORDENDETAPRODU)) {
				this.setMostrarid_orden_deta_produProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.COSTO)) {
				this.setMostrarcostoProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionProductoOrdenDetaProdu(esAsigna);
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
		
		
		this.setActivaridProductoOrdenDetaProdu(esInicial);
		this.setActivarid_orden_deta_produProductoOrdenDetaProdu(esInicial);
		this.setActivarid_bodegaProductoOrdenDetaProdu(esInicial);
		this.setActivarid_productoProductoOrdenDetaProdu(esInicial);
		this.setActivarid_unidadProductoOrdenDetaProdu(esInicial);
		this.setActivarporcentajeProductoOrdenDetaProdu(esInicial);
		this.setActivarcantidadProductoOrdenDetaProdu(esInicial);
		this.setActivarcostoProductoOrdenDetaProdu(esInicial);
		this.setActivarcosto_totalProductoOrdenDetaProdu(esInicial);
		this.setActivardescripcionProductoOrdenDetaProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.ID)) {
				this.setActivaridProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.IDORDENDETAPRODU)) {
				this.setActivarid_orden_deta_produProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.COSTO)) {
				this.setActivarcostoProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionProductoOrdenDetaProdu(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoOrdenDetaProduBeanSwingJInternalFrame productoordendetaproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductoOrdenDetaProdu(esInicial);
		this.setResaltarid_orden_deta_produProductoOrdenDetaProdu(esInicial);
		this.setResaltarid_bodegaProductoOrdenDetaProdu(esInicial);
		this.setResaltarid_productoProductoOrdenDetaProdu(esInicial);
		this.setResaltarid_unidadProductoOrdenDetaProdu(esInicial);
		this.setResaltarporcentajeProductoOrdenDetaProdu(esInicial);
		this.setResaltarcantidadProductoOrdenDetaProdu(esInicial);
		this.setResaltarcostoProductoOrdenDetaProdu(esInicial);
		this.setResaltarcosto_totalProductoOrdenDetaProdu(esInicial);
		this.setResaltardescripcionProductoOrdenDetaProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.ID)) {
				this.setResaltaridProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.IDORDENDETAPRODU)) {
				this.setResaltarid_orden_deta_produProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.COSTO)) {
				this.setResaltarcostoProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalProductoOrdenDetaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionProductoOrdenDetaProdu(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoOrdenDetaProduBeanSwingJInternalFrame productoordendetaproduBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaProductoOrdenDetaProdu=true;

	public Boolean getMostrarFK_IdBodegaProductoOrdenDetaProdu() {
		return this.mostrarFK_IdBodegaProductoOrdenDetaProdu;
	}

	public void setMostrarFK_IdBodegaProductoOrdenDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaProductoOrdenDetaProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdOrdenDetaProduProductoOrdenDetaProdu=true;

	public Boolean getMostrarFK_IdOrdenDetaProduProductoOrdenDetaProdu() {
		return this.mostrarFK_IdOrdenDetaProduProductoOrdenDetaProdu;
	}

	public void setMostrarFK_IdOrdenDetaProduProductoOrdenDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdOrdenDetaProduProductoOrdenDetaProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoProductoOrdenDetaProdu=true;

	public Boolean getMostrarFK_IdProductoProductoOrdenDetaProdu() {
		return this.mostrarFK_IdProductoProductoOrdenDetaProdu;
	}

	public void setMostrarFK_IdProductoProductoOrdenDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoProductoOrdenDetaProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadUnadProductoOrdenDetaProdu=true;

	public Boolean getMostrarFK_IdUnidadUnadProductoOrdenDetaProdu() {
		return this.mostrarFK_IdUnidadUnadProductoOrdenDetaProdu;
	}

	public void setMostrarFK_IdUnidadUnadProductoOrdenDetaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadUnadProductoOrdenDetaProdu= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaProductoOrdenDetaProdu=true;

	public Boolean getActivarFK_IdBodegaProductoOrdenDetaProdu() {
		return this.activarFK_IdBodegaProductoOrdenDetaProdu;
	}

	public void setActivarFK_IdBodegaProductoOrdenDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaProductoOrdenDetaProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdOrdenDetaProduProductoOrdenDetaProdu=true;

	public Boolean getActivarFK_IdOrdenDetaProduProductoOrdenDetaProdu() {
		return this.activarFK_IdOrdenDetaProduProductoOrdenDetaProdu;
	}

	public void setActivarFK_IdOrdenDetaProduProductoOrdenDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdOrdenDetaProduProductoOrdenDetaProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoProductoOrdenDetaProdu=true;

	public Boolean getActivarFK_IdProductoProductoOrdenDetaProdu() {
		return this.activarFK_IdProductoProductoOrdenDetaProdu;
	}

	public void setActivarFK_IdProductoProductoOrdenDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdProductoProductoOrdenDetaProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadUnadProductoOrdenDetaProdu=true;

	public Boolean getActivarFK_IdUnidadUnadProductoOrdenDetaProdu() {
		return this.activarFK_IdUnidadUnadProductoOrdenDetaProdu;
	}

	public void setActivarFK_IdUnidadUnadProductoOrdenDetaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadUnadProductoOrdenDetaProdu= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaProductoOrdenDetaProdu=null;

	public Border getResaltarFK_IdBodegaProductoOrdenDetaProdu() {
		return this.resaltarFK_IdBodegaProductoOrdenDetaProdu;
	}

	public void setResaltarFK_IdBodegaProductoOrdenDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdBodegaProductoOrdenDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdBodegaProductoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduBeanSwingJInternalFrame productoordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaProductoOrdenDetaProdu= borderResaltar;
	}

	public Border resaltarFK_IdOrdenDetaProduProductoOrdenDetaProdu=null;

	public Border getResaltarFK_IdOrdenDetaProduProductoOrdenDetaProdu() {
		return this.resaltarFK_IdOrdenDetaProduProductoOrdenDetaProdu;
	}

	public void setResaltarFK_IdOrdenDetaProduProductoOrdenDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdOrdenDetaProduProductoOrdenDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdOrdenDetaProduProductoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduBeanSwingJInternalFrame productoordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdOrdenDetaProduProductoOrdenDetaProdu= borderResaltar;
	}

	public Border resaltarFK_IdProductoProductoOrdenDetaProdu=null;

	public Border getResaltarFK_IdProductoProductoOrdenDetaProdu() {
		return this.resaltarFK_IdProductoProductoOrdenDetaProdu;
	}

	public void setResaltarFK_IdProductoProductoOrdenDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdProductoProductoOrdenDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdProductoProductoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduBeanSwingJInternalFrame productoordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoProductoOrdenDetaProdu= borderResaltar;
	}

	public Border resaltarFK_IdUnidadUnadProductoOrdenDetaProdu=null;

	public Border getResaltarFK_IdUnidadUnadProductoOrdenDetaProdu() {
		return this.resaltarFK_IdUnidadUnadProductoOrdenDetaProdu;
	}

	public void setResaltarFK_IdUnidadUnadProductoOrdenDetaProdu(Border borderResaltar) {
		this.resaltarFK_IdUnidadUnadProductoOrdenDetaProdu= borderResaltar;
	}

	public void setResaltarFK_IdUnidadUnadProductoOrdenDetaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduBeanSwingJInternalFrame productoordendetaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadUnadProductoOrdenDetaProdu= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}