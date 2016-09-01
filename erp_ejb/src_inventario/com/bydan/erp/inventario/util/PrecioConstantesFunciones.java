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


import com.bydan.erp.inventario.util.PrecioConstantesFunciones;
import com.bydan.erp.inventario.util.PrecioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.PrecioParameterGeneral;

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
final public class PrecioConstantesFunciones extends PrecioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Precio";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Precio"+PrecioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PrecioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PrecioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PrecioConstantesFunciones.SCHEMA+"_"+PrecioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PrecioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PrecioConstantesFunciones.SCHEMA+"_"+PrecioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PrecioConstantesFunciones.SCHEMA+"_"+PrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PrecioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PrecioConstantesFunciones.SCHEMA+"_"+PrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PrecioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PrecioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PrecioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PrecioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PrecioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PrecioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PrecioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PrecioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Precios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Precio";
	public static final String SCLASSWEBTITULO_LOWER="Precio";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Precio";
	public static final String OBJECTNAME="precio";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="precio";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select precio from "+PrecioConstantesFunciones.SPERSISTENCENAME+" precio";
	public static String QUERYSELECTNATIVE="select "+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".version_row,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id_empresa,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id_sucursal,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id_bodega,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id_producto,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id_linea,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id_linea_grupo,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id_linea_categoria,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id_linea_marca,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id_rango_unidad_venta,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id_tipo_precio,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".precio,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".descuento,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".precio_minimo,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".con_impuesto,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id_estado_precio from "+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME;//+" as "+PrecioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PrecioConstantesFuncionesAdditional precioConstantesFuncionesAdditional=null;
	
	public PrecioConstantesFuncionesAdditional getPrecioConstantesFuncionesAdditional() {
		return this.precioConstantesFuncionesAdditional;
	}
	
	public void setPrecioConstantesFuncionesAdditional(PrecioConstantesFuncionesAdditional precioConstantesFuncionesAdditional) {
		try {
			this.precioConstantesFuncionesAdditional=precioConstantesFuncionesAdditional;
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
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
    public static final String IDRANGOUNIDADVENTA= "id_rango_unidad_venta";
    public static final String IDTIPOPRECIO= "id_tipo_precio";
    public static final String PRECIO= "precio";
    public static final String DESCUENTO= "descuento";
    public static final String PRECIOMINIMO= "precio_minimo";
    public static final String CONIMPUESTO= "con_impuesto";
    public static final String IDESTADOPRECIO= "id_estado_precio";
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
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDLINEAGRUPO= "Linea Grupo";
		public static final String LABEL_IDLINEAGRUPO_LOWER= "Linea Grupo";
    	public static final String LABEL_IDLINEACATEGORIA= "Linea Categoria";
		public static final String LABEL_IDLINEACATEGORIA_LOWER= "Linea Categoria";
    	public static final String LABEL_IDLINEAMARCA= "Linea Marca";
		public static final String LABEL_IDLINEAMARCA_LOWER= "Linea Marca";
    	public static final String LABEL_IDRANGOUNIDADVENTA= "Rango Unidad Venta";
		public static final String LABEL_IDRANGOUNIDADVENTA_LOWER= "Rango Unidad Venta";
    	public static final String LABEL_IDTIPOPRECIO= "Tipo Precio";
		public static final String LABEL_IDTIPOPRECIO_LOWER= "Tipo Precio";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_PRECIOMINIMO= "Precio Minimo";
		public static final String LABEL_PRECIOMINIMO_LOWER= "Precio Minimo";
    	public static final String LABEL_CONIMPUESTO= "Con Impuesto";
		public static final String LABEL_CONIMPUESTO_LOWER= "Con Impuesto";
    	public static final String LABEL_IDESTADOPRECIO= "Estado";
		public static final String LABEL_IDESTADOPRECIO_LOWER= "Estado Precio";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getPrecioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PrecioConstantesFunciones.IDEMPRESA)) {sLabelColumna=PrecioConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PrecioConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PrecioConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PrecioConstantesFunciones.IDBODEGA)) {sLabelColumna=PrecioConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(PrecioConstantesFunciones.IDPRODUCTO)) {sLabelColumna=PrecioConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(PrecioConstantesFunciones.IDLINEA)) {sLabelColumna=PrecioConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(PrecioConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=PrecioConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(PrecioConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=PrecioConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(PrecioConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=PrecioConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(PrecioConstantesFunciones.IDRANGOUNIDADVENTA)) {sLabelColumna=PrecioConstantesFunciones.LABEL_IDRANGOUNIDADVENTA;}
		if(sNombreColumna.equals(PrecioConstantesFunciones.IDTIPOPRECIO)) {sLabelColumna=PrecioConstantesFunciones.LABEL_IDTIPOPRECIO;}
		if(sNombreColumna.equals(PrecioConstantesFunciones.PRECIO)) {sLabelColumna=PrecioConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(PrecioConstantesFunciones.DESCUENTO)) {sLabelColumna=PrecioConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(PrecioConstantesFunciones.PRECIOMINIMO)) {sLabelColumna=PrecioConstantesFunciones.LABEL_PRECIOMINIMO;}
		if(sNombreColumna.equals(PrecioConstantesFunciones.CONIMPUESTO)) {sLabelColumna=PrecioConstantesFunciones.LABEL_CONIMPUESTO;}
		if(sNombreColumna.equals(PrecioConstantesFunciones.IDESTADOPRECIO)) {sLabelColumna=PrecioConstantesFunciones.LABEL_IDESTADOPRECIO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_impuestoDescripcion(Precio precio) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!precio.getcon_impuesto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_impuestoHtmlDescripcion(Precio precio) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(precio.getId(),precio.getcon_impuesto());

		return sDescripcion;
	}	
			
	
	public static String getPrecioDescripcion(Precio precio) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(precio !=null/* && precio.getId()!=0*/) {
			if(precio.getId()!=null) {
				sDescripcion=precio.getId().toString();
			}//precioprecio.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPrecioDescripcionDetallado(Precio precio) {
		String sDescripcion="";
			
		sDescripcion+=PrecioConstantesFunciones.ID+"=";
		sDescripcion+=precio.getId().toString()+",";
		sDescripcion+=PrecioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=precio.getVersionRow().toString()+",";
		sDescripcion+=PrecioConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=precio.getid_empresa().toString()+",";
		sDescripcion+=PrecioConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=precio.getid_sucursal().toString()+",";
		sDescripcion+=PrecioConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=precio.getid_bodega().toString()+",";
		sDescripcion+=PrecioConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=precio.getid_producto().toString()+",";
		sDescripcion+=PrecioConstantesFunciones.IDLINEA+"=";
		sDescripcion+=precio.getid_linea().toString()+",";
		sDescripcion+=PrecioConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=precio.getid_linea_grupo().toString()+",";
		sDescripcion+=PrecioConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=precio.getid_linea_categoria().toString()+",";
		sDescripcion+=PrecioConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=precio.getid_linea_marca().toString()+",";
		sDescripcion+=PrecioConstantesFunciones.IDRANGOUNIDADVENTA+"=";
		sDescripcion+=precio.getid_rango_unidad_venta().toString()+",";
		sDescripcion+=PrecioConstantesFunciones.IDTIPOPRECIO+"=";
		sDescripcion+=precio.getid_tipo_precio().toString()+",";
		sDescripcion+=PrecioConstantesFunciones.PRECIO+"=";
		sDescripcion+=precio.getprecio().toString()+",";
		sDescripcion+=PrecioConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=precio.getdescuento().toString()+",";
		sDescripcion+=PrecioConstantesFunciones.PRECIOMINIMO+"=";
		sDescripcion+=precio.getprecio_minimo().toString()+",";
		sDescripcion+=PrecioConstantesFunciones.CONIMPUESTO+"=";
		sDescripcion+=precio.getcon_impuesto().toString()+",";
		sDescripcion+=PrecioConstantesFunciones.IDESTADOPRECIO+"=";
		sDescripcion+=precio.getid_estado_precio().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPrecioDescripcion(Precio precio,String sValor) throws Exception {			
		if(precio !=null) {
			//precioprecio.getId().toString();
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

	public static String getLineaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaGrupoDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaCategoriaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaMarcaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getRangoUnidadVentaDescripcion(RangoUnidadVenta rangounidadventa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(rangounidadventa!=null/*&&rangounidadventa.getId()>0*/) {
			sDescripcion=RangoUnidadVentaConstantesFunciones.getRangoUnidadVentaDescripcion(rangounidadventa);
		}

		return sDescripcion;
	}

	public static String getTipoPrecioDescripcion(TipoPrecio tipoprecio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoprecio!=null/*&&tipoprecio.getId()>0*/) {
			sDescripcion=TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(tipoprecio);
		}

		return sDescripcion;
	}

	public static String getEstadoPrecioDescripcion(EstadoPrecio estadoprecio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadoprecio!=null/*&&estadoprecio.getId()>0*/) {
			sDescripcion=EstadoPrecioConstantesFunciones.getEstadoPrecioDescripcion(estadoprecio);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorIdBodegaPorIdProducto")) {
			sNombreIndice="Tipo=  Por Bodega Por Producto";
		} else if(sNombreIndice.equals("BusquedaPorLineaGrupoCategoriaMarca")) {
			sNombreIndice="Tipo=  Por Linea Por Linea Grupo Por Linea Categoria Por Linea Marca";
		} else if(sNombreIndice.equals("BusquedaPorLineaGrupoCategoriaMarcaProducto")) {
			sNombreIndice="Tipo=  Por Linea Por Linea Grupo Por Linea Categoria Por Linea Marca Por Producto";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoPrecio")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdLinea")) {
			sNombreIndice="Tipo=  Por Linea";
		} else if(sNombreIndice.equals("FK_IdLineaCategoria")) {
			sNombreIndice="Tipo=  Por Linea Categoria";
		} else if(sNombreIndice.equals("FK_IdLineaGrupo")) {
			sNombreIndice="Tipo=  Por Linea Grupo";
		} else if(sNombreIndice.equals("FK_IdLineaMarca")) {
			sNombreIndice="Tipo=  Por Linea Marca";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdRangoUnidadVenta")) {
			sNombreIndice="Tipo=  Por Rango Unidad Venta";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoPrecio")) {
			sNombreIndice="Tipo=  Por Tipo Precio";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorIdBodegaPorIdProducto(Long id_bodega,Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();}
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorLineaGrupoCategoriaMarca(Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca) {
		String sDetalleIndice=" Parametros->";
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();}
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();}
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();}
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorLineaGrupoCategoriaMarcaProducto(Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();}
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();}
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();}
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();}
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

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

	public static String getDetalleIndiceFK_IdEstadoPrecio(Long id_estado_precio) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_precio!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_precio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLinea(Long id_linea) {
		String sDetalleIndice=" Parametros->";
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaCategoria(Long id_linea_categoria) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaGrupo(Long id_linea_grupo) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaMarca(Long id_linea_marca) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdRangoUnidadVenta(Long id_rango_unidad_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_rango_unidad_venta!=null) {sDetalleIndice+=" Codigo Unico De Rango Unidad Venta="+id_rango_unidad_venta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoPrecio(Long id_tipo_precio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_precio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Precio="+id_tipo_precio.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPrecio(Precio precio,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosPrecios(List<Precio> precios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Precio precio: precios) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPrecio(Precio precio,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && precio.getConCambioAuxiliar()) {
			precio.setIsDeleted(precio.getIsDeletedAuxiliar());	
			precio.setIsNew(precio.getIsNewAuxiliar());	
			precio.setIsChanged(precio.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			precio.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			precio.setIsDeletedAuxiliar(false);	
			precio.setIsNewAuxiliar(false);	
			precio.setIsChangedAuxiliar(false);
			
			precio.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPrecios(List<Precio> precios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Precio precio : precios) {
			if(conAsignarBase && precio.getConCambioAuxiliar()) {
				precio.setIsDeleted(precio.getIsDeletedAuxiliar());	
				precio.setIsNew(precio.getIsNewAuxiliar());	
				precio.setIsChanged(precio.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				precio.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				precio.setIsDeletedAuxiliar(false);	
				precio.setIsNewAuxiliar(false);	
				precio.setIsChangedAuxiliar(false);
				
				precio.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPrecio(Precio precio,Boolean conEnteros) throws Exception  {
		precio.setprecio(0.0);
		precio.setdescuento(0.0);
		precio.setprecio_minimo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPrecios(List<Precio> precios,Boolean conEnteros) throws Exception  {
		
		for(Precio precio: precios) {
			precio.setprecio(0.0);
			precio.setdescuento(0.0);
			precio.setprecio_minimo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPrecio(List<Precio> precios,Precio precioAux) throws Exception  {
		PrecioConstantesFunciones.InicializarValoresPrecio(precioAux,true);
		
		for(Precio precio: precios) {
			if(precio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioAux.setprecio(precioAux.getprecio()+precio.getprecio());			
			precioAux.setdescuento(precioAux.getdescuento()+precio.getdescuento());			
			precioAux.setprecio_minimo(precioAux.getprecio_minimo()+precio.getprecio_minimo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPrecio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PrecioConstantesFunciones.getArrayColumnasGlobalesPrecio(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPrecio(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PrecioConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PrecioConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PrecioConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PrecioConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPrecio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Precio> precios,Precio precio,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Precio precioAux: precios) {
			if(precioAux!=null && precio!=null) {
				if((precioAux.getId()==null && precio.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(precioAux.getId()!=null && precio.getId()!=null){
					if(precioAux.getId().equals(precio.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPrecio(List<Precio> precios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double descuentoTotal=0.0;
		Double precio_minimoTotal=0.0;
	
		for(Precio precio: precios) {			
			if(precio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=precio.getprecio();
			descuentoTotal+=precio.getdescuento();
			precio_minimoTotal+=precio.getprecio_minimo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PrecioConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(PrecioConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PrecioConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(PrecioConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PrecioConstantesFunciones.PRECIOMINIMO);
		datoGeneral.setsDescripcion(PrecioConstantesFunciones.LABEL_PRECIOMINIMO);
		datoGeneral.setdValorDouble(precio_minimoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPrecio() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PrecioConstantesFunciones.LABEL_ID, PrecioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrecioConstantesFunciones.LABEL_VERSIONROW, PrecioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrecioConstantesFunciones.LABEL_IDEMPRESA, PrecioConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrecioConstantesFunciones.LABEL_IDSUCURSAL, PrecioConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrecioConstantesFunciones.LABEL_IDBODEGA, PrecioConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrecioConstantesFunciones.LABEL_IDPRODUCTO, PrecioConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrecioConstantesFunciones.LABEL_IDLINEA, PrecioConstantesFunciones.IDLINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrecioConstantesFunciones.LABEL_IDLINEAGRUPO, PrecioConstantesFunciones.IDLINEAGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrecioConstantesFunciones.LABEL_IDLINEACATEGORIA, PrecioConstantesFunciones.IDLINEACATEGORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrecioConstantesFunciones.LABEL_IDLINEAMARCA, PrecioConstantesFunciones.IDLINEAMARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrecioConstantesFunciones.LABEL_IDRANGOUNIDADVENTA, PrecioConstantesFunciones.IDRANGOUNIDADVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrecioConstantesFunciones.LABEL_IDTIPOPRECIO, PrecioConstantesFunciones.IDTIPOPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrecioConstantesFunciones.LABEL_PRECIO, PrecioConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrecioConstantesFunciones.LABEL_DESCUENTO, PrecioConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrecioConstantesFunciones.LABEL_PRECIOMINIMO, PrecioConstantesFunciones.PRECIOMINIMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrecioConstantesFunciones.LABEL_CONIMPUESTO, PrecioConstantesFunciones.CONIMPUESTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrecioConstantesFunciones.LABEL_IDESTADOPRECIO, PrecioConstantesFunciones.IDESTADOPRECIO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPrecio() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PrecioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrecioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrecioConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrecioConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrecioConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrecioConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrecioConstantesFunciones.IDLINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrecioConstantesFunciones.IDLINEAGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrecioConstantesFunciones.IDLINEACATEGORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrecioConstantesFunciones.IDLINEAMARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrecioConstantesFunciones.IDRANGOUNIDADVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrecioConstantesFunciones.IDTIPOPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrecioConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrecioConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrecioConstantesFunciones.PRECIOMINIMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrecioConstantesFunciones.CONIMPUESTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrecioConstantesFunciones.IDESTADOPRECIO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPrecio() throws Exception  {
		return PrecioConstantesFunciones.getTiposSeleccionarPrecio(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPrecio(Boolean conFk) throws Exception  {
		return PrecioConstantesFunciones.getTiposSeleccionarPrecio(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPrecio(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PrecioConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PrecioConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PrecioConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PrecioConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PrecioConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(PrecioConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PrecioConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(PrecioConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PrecioConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(PrecioConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PrecioConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(PrecioConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PrecioConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(PrecioConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PrecioConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(PrecioConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PrecioConstantesFunciones.LABEL_IDRANGOUNIDADVENTA);
			reporte.setsDescripcion(PrecioConstantesFunciones.LABEL_IDRANGOUNIDADVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PrecioConstantesFunciones.LABEL_IDTIPOPRECIO);
			reporte.setsDescripcion(PrecioConstantesFunciones.LABEL_IDTIPOPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PrecioConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(PrecioConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PrecioConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(PrecioConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PrecioConstantesFunciones.LABEL_PRECIOMINIMO);
			reporte.setsDescripcion(PrecioConstantesFunciones.LABEL_PRECIOMINIMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PrecioConstantesFunciones.LABEL_CONIMPUESTO);
			reporte.setsDescripcion(PrecioConstantesFunciones.LABEL_CONIMPUESTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PrecioConstantesFunciones.LABEL_IDESTADOPRECIO);
			reporte.setsDescripcion(PrecioConstantesFunciones.LABEL_IDESTADOPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPrecio(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPrecio(Precio precioAux) throws Exception {
		
			precioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(precioAux.getEmpresa()));
			precioAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(precioAux.getSucursal()));
			precioAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(precioAux.getBodega()));
			precioAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(precioAux.getProducto()));
			precioAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(precioAux.getLinea()));
			precioAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(precioAux.getLineaGrupo()));
			precioAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(precioAux.getLineaCategoria()));
			precioAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(precioAux.getLineaMarca()));
			precioAux.setrangounidadventa_descripcion(RangoUnidadVentaConstantesFunciones.getRangoUnidadVentaDescripcion(precioAux.getRangoUnidadVenta()));
			precioAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(precioAux.getTipoPrecio()));
			precioAux.setestadoprecio_descripcion(EstadoPrecioConstantesFunciones.getEstadoPrecioDescripcion(precioAux.getEstadoPrecio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPrecio(List<Precio> preciosTemp) throws Exception {
		for(Precio precioAux:preciosTemp) {
			
			precioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(precioAux.getEmpresa()));
			precioAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(precioAux.getSucursal()));
			precioAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(precioAux.getBodega()));
			precioAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(precioAux.getProducto()));
			precioAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(precioAux.getLinea()));
			precioAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(precioAux.getLineaGrupo()));
			precioAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(precioAux.getLineaCategoria()));
			precioAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(precioAux.getLineaMarca()));
			precioAux.setrangounidadventa_descripcion(RangoUnidadVentaConstantesFunciones.getRangoUnidadVentaDescripcion(precioAux.getRangoUnidadVenta()));
			precioAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(precioAux.getTipoPrecio()));
			precioAux.setestadoprecio_descripcion(EstadoPrecioConstantesFunciones.getEstadoPrecioDescripcion(precioAux.getEstadoPrecio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(RangoUnidadVenta.class));
				classes.add(new Classe(TipoPrecio.class));
				classes.add(new Classe(EstadoPrecio.class));
				
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
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RangoUnidadVenta.class)) {
						classes.add(new Classe(RangoUnidadVenta.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPrecio.class)) {
						classes.add(new Classe(TipoPrecio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoPrecio.class)) {
						classes.add(new Classe(EstadoPrecio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPrecio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(RangoUnidadVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RangoUnidadVenta.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(EstadoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPrecio.class)); continue;
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

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(RangoUnidadVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RangoUnidadVenta.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(EstadoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPrecio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PrecioConstantesFunciones.getClassesRelationshipsOfPrecio(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPrecio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PrecioConstantesFunciones.getClassesRelationshipsFromStringsOfPrecio(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPrecio(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Precio precio,List<Precio> precios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Precio precioEncontrado=null;
			
			for(Precio precioLocal:precios) {
				if(precioLocal.getId().equals(precio.getId())) {
					precioEncontrado=precioLocal;
					
					precioLocal.setIsChanged(precio.getIsChanged());
					precioLocal.setIsNew(precio.getIsNew());
					precioLocal.setIsDeleted(precio.getIsDeleted());
					
					precioLocal.setGeneralEntityOriginal(precio.getGeneralEntityOriginal());
					
					precioLocal.setId(precio.getId());	
					precioLocal.setVersionRow(precio.getVersionRow());	
					precioLocal.setid_empresa(precio.getid_empresa());	
					precioLocal.setid_sucursal(precio.getid_sucursal());	
					precioLocal.setid_bodega(precio.getid_bodega());	
					precioLocal.setid_producto(precio.getid_producto());	
					precioLocal.setid_linea(precio.getid_linea());	
					precioLocal.setid_linea_grupo(precio.getid_linea_grupo());	
					precioLocal.setid_linea_categoria(precio.getid_linea_categoria());	
					precioLocal.setid_linea_marca(precio.getid_linea_marca());	
					precioLocal.setid_rango_unidad_venta(precio.getid_rango_unidad_venta());	
					precioLocal.setid_tipo_precio(precio.getid_tipo_precio());	
					precioLocal.setprecio(precio.getprecio());	
					precioLocal.setdescuento(precio.getdescuento());	
					precioLocal.setprecio_minimo(precio.getprecio_minimo());	
					precioLocal.setcon_impuesto(precio.getcon_impuesto());	
					precioLocal.setid_estado_precio(precio.getid_estado_precio());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!precio.getIsDeleted()) {
				if(!existe) {
					precios.add(precio);
				}
			} else {
				if(precioEncontrado!=null && permiteQuitar)  {
					precios.remove(precioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Precio precio,List<Precio> precios) throws Exception {
		try	{			
			for(Precio precioLocal:precios) {
				if(precioLocal.getId().equals(precio.getId())) {
					precioLocal.setIsSelected(precio.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPrecio(List<Precio> preciosAux) throws Exception {
		//this.preciosAux=preciosAux;
		
		for(Precio precioAux:preciosAux) {
			if(precioAux.getIsChanged()) {
				precioAux.setIsChanged(false);
			}		
			
			if(precioAux.getIsNew()) {
				precioAux.setIsNew(false);
			}	
			
			if(precioAux.getIsDeleted()) {
				precioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPrecio(Precio precioAux) throws Exception {
		//this.precioAux=precioAux;
		
			if(precioAux.getIsChanged()) {
				precioAux.setIsChanged(false);
			}		
			
			if(precioAux.getIsNew()) {
				precioAux.setIsNew(false);
			}	
			
			if(precioAux.getIsDeleted()) {
				precioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Precio precioAsignar,Precio precio) throws Exception {
		precioAsignar.setId(precio.getId());	
		precioAsignar.setVersionRow(precio.getVersionRow());	
		precioAsignar.setid_empresa(precio.getid_empresa());
		precioAsignar.setempresa_descripcion(precio.getempresa_descripcion());	
		precioAsignar.setid_sucursal(precio.getid_sucursal());
		precioAsignar.setsucursal_descripcion(precio.getsucursal_descripcion());	
		precioAsignar.setid_bodega(precio.getid_bodega());
		precioAsignar.setbodega_descripcion(precio.getbodega_descripcion());	
		precioAsignar.setid_producto(precio.getid_producto());
		precioAsignar.setproducto_descripcion(precio.getproducto_descripcion());	
		precioAsignar.setid_linea(precio.getid_linea());
		precioAsignar.setlinea_descripcion(precio.getlinea_descripcion());	
		precioAsignar.setid_linea_grupo(precio.getid_linea_grupo());
		precioAsignar.setlineagrupo_descripcion(precio.getlineagrupo_descripcion());	
		precioAsignar.setid_linea_categoria(precio.getid_linea_categoria());
		precioAsignar.setlineacategoria_descripcion(precio.getlineacategoria_descripcion());	
		precioAsignar.setid_linea_marca(precio.getid_linea_marca());
		precioAsignar.setlineamarca_descripcion(precio.getlineamarca_descripcion());	
		precioAsignar.setid_rango_unidad_venta(precio.getid_rango_unidad_venta());
		precioAsignar.setrangounidadventa_descripcion(precio.getrangounidadventa_descripcion());	
		precioAsignar.setid_tipo_precio(precio.getid_tipo_precio());
		precioAsignar.settipoprecio_descripcion(precio.gettipoprecio_descripcion());	
		precioAsignar.setprecio(precio.getprecio());	
		precioAsignar.setdescuento(precio.getdescuento());	
		precioAsignar.setprecio_minimo(precio.getprecio_minimo());	
		precioAsignar.setcon_impuesto(precio.getcon_impuesto());	
		precioAsignar.setid_estado_precio(precio.getid_estado_precio());
		precioAsignar.setestadoprecio_descripcion(precio.getestadoprecio_descripcion());	
	}
	
	public static void inicializarPrecio(Precio precio) throws Exception {
		try {
				precio.setId(0L);	
					
				precio.setid_empresa(-1L);	
				precio.setid_sucursal(-1L);	
				precio.setid_bodega(-1L);	
				precio.setid_producto(-1L);	
				precio.setid_linea(null);	
				precio.setid_linea_grupo(null);	
				precio.setid_linea_categoria(null);	
				precio.setid_linea_marca(null);	
				precio.setid_rango_unidad_venta(-1L);	
				precio.setid_tipo_precio(-1L);	
				precio.setprecio(0.0);	
				precio.setdescuento(0.0);	
				precio.setprecio_minimo(0.0);	
				precio.setcon_impuesto(false);	
				precio.setid_estado_precio(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPrecio(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PrecioConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrecioConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrecioConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrecioConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrecioConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrecioConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrecioConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrecioConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrecioConstantesFunciones.LABEL_IDRANGOUNIDADVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrecioConstantesFunciones.LABEL_IDTIPOPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrecioConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrecioConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrecioConstantesFunciones.LABEL_PRECIOMINIMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrecioConstantesFunciones.LABEL_CONIMPUESTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrecioConstantesFunciones.LABEL_IDESTADOPRECIO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPrecio(String sTipo,Row row,Workbook workbook,Precio precio,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(precio.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precio.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precio.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precio.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precio.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precio.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precio.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precio.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precio.getrangounidadventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precio.gettipoprecio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precio.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precio.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precio.getprecio_minimo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(precio.getcon_impuesto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(precio.getestadoprecio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPrecio=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPrecio() {
		return this.sFinalQueryPrecio;
	}
	
	public void setsFinalQueryPrecio(String sFinalQueryPrecio) {
		this.sFinalQueryPrecio= sFinalQueryPrecio;
	}
	
	public Border resaltarSeleccionarPrecio=null;
	
	public Border setResaltarSeleccionarPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//precioBeanSwingJInternalFrame.jTtoolBarPrecio.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPrecio= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPrecio() {
		return this.resaltarSeleccionarPrecio;
	}
	
	public void setResaltarSeleccionarPrecio(Border borderResaltarSeleccionarPrecio) {
		this.resaltarSeleccionarPrecio= borderResaltarSeleccionarPrecio;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPrecio=null;
	public Boolean mostraridPrecio=true;
	public Boolean activaridPrecio=true;

	public Border resaltarid_empresaPrecio=null;
	public Boolean mostrarid_empresaPrecio=true;
	public Boolean activarid_empresaPrecio=true;
	public Boolean cargarid_empresaPrecio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPrecio=false;//ConEventDepend=true

	public Border resaltarid_sucursalPrecio=null;
	public Boolean mostrarid_sucursalPrecio=true;
	public Boolean activarid_sucursalPrecio=true;
	public Boolean cargarid_sucursalPrecio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPrecio=false;//ConEventDepend=true

	public Border resaltarid_bodegaPrecio=null;
	public Boolean mostrarid_bodegaPrecio=true;
	public Boolean activarid_bodegaPrecio=true;
	public Boolean cargarid_bodegaPrecio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaPrecio=false;//ConEventDepend=true

	public Border resaltarid_productoPrecio=null;
	public Boolean mostrarid_productoPrecio=true;
	public Boolean activarid_productoPrecio=true;
	public Boolean cargarid_productoPrecio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoPrecio=true;//ConEventDepend=true

	public Border resaltarid_lineaPrecio=null;
	public Boolean mostrarid_lineaPrecio=true;
	public Boolean activarid_lineaPrecio=false;
	public Boolean cargarid_lineaPrecio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaPrecio=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoPrecio=null;
	public Boolean mostrarid_linea_grupoPrecio=true;
	public Boolean activarid_linea_grupoPrecio=false;
	public Boolean cargarid_linea_grupoPrecio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoPrecio=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaPrecio=null;
	public Boolean mostrarid_linea_categoriaPrecio=true;
	public Boolean activarid_linea_categoriaPrecio=false;
	public Boolean cargarid_linea_categoriaPrecio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaPrecio=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaPrecio=null;
	public Boolean mostrarid_linea_marcaPrecio=true;
	public Boolean activarid_linea_marcaPrecio=false;
	public Boolean cargarid_linea_marcaPrecio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaPrecio=false;//ConEventDepend=true

	public Border resaltarid_rango_unidad_ventaPrecio=null;
	public Boolean mostrarid_rango_unidad_ventaPrecio=true;
	public Boolean activarid_rango_unidad_ventaPrecio=true;
	public Boolean cargarid_rango_unidad_ventaPrecio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_rango_unidad_ventaPrecio=false;//ConEventDepend=true

	public Border resaltarid_tipo_precioPrecio=null;
	public Boolean mostrarid_tipo_precioPrecio=true;
	public Boolean activarid_tipo_precioPrecio=true;
	public Boolean cargarid_tipo_precioPrecio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_precioPrecio=false;//ConEventDepend=true

	public Border resaltarprecioPrecio=null;
	public Boolean mostrarprecioPrecio=true;
	public Boolean activarprecioPrecio=true;

	public Border resaltardescuentoPrecio=null;
	public Boolean mostrardescuentoPrecio=true;
	public Boolean activardescuentoPrecio=true;

	public Border resaltarprecio_minimoPrecio=null;
	public Boolean mostrarprecio_minimoPrecio=true;
	public Boolean activarprecio_minimoPrecio=true;

	public Border resaltarcon_impuestoPrecio=null;
	public Boolean mostrarcon_impuestoPrecio=true;
	public Boolean activarcon_impuestoPrecio=true;

	public Border resaltarid_estado_precioPrecio=null;
	public Boolean mostrarid_estado_precioPrecio=true;
	public Boolean activarid_estado_precioPrecio=true;
	public Boolean cargarid_estado_precioPrecio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_precioPrecio=false;//ConEventDepend=true

	
	

	public Border setResaltaridPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioBeanSwingJInternalFrame.jTtoolBarPrecio.setBorder(borderResaltar);
		
		this.resaltaridPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPrecio() {
		return this.resaltaridPrecio;
	}

	public void setResaltaridPrecio(Border borderResaltar) {
		this.resaltaridPrecio= borderResaltar;
	}

	public Boolean getMostraridPrecio() {
		return this.mostraridPrecio;
	}

	public void setMostraridPrecio(Boolean mostraridPrecio) {
		this.mostraridPrecio= mostraridPrecio;
	}

	public Boolean getActivaridPrecio() {
		return this.activaridPrecio;
	}

	public void setActivaridPrecio(Boolean activaridPrecio) {
		this.activaridPrecio= activaridPrecio;
	}

	public Border setResaltarid_empresaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioBeanSwingJInternalFrame.jTtoolBarPrecio.setBorder(borderResaltar);
		
		this.resaltarid_empresaPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPrecio() {
		return this.resaltarid_empresaPrecio;
	}

	public void setResaltarid_empresaPrecio(Border borderResaltar) {
		this.resaltarid_empresaPrecio= borderResaltar;
	}

	public Boolean getMostrarid_empresaPrecio() {
		return this.mostrarid_empresaPrecio;
	}

	public void setMostrarid_empresaPrecio(Boolean mostrarid_empresaPrecio) {
		this.mostrarid_empresaPrecio= mostrarid_empresaPrecio;
	}

	public Boolean getActivarid_empresaPrecio() {
		return this.activarid_empresaPrecio;
	}

	public void setActivarid_empresaPrecio(Boolean activarid_empresaPrecio) {
		this.activarid_empresaPrecio= activarid_empresaPrecio;
	}

	public Boolean getCargarid_empresaPrecio() {
		return this.cargarid_empresaPrecio;
	}

	public void setCargarid_empresaPrecio(Boolean cargarid_empresaPrecio) {
		this.cargarid_empresaPrecio= cargarid_empresaPrecio;
	}

	public Border setResaltarid_sucursalPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioBeanSwingJInternalFrame.jTtoolBarPrecio.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPrecio() {
		return this.resaltarid_sucursalPrecio;
	}

	public void setResaltarid_sucursalPrecio(Border borderResaltar) {
		this.resaltarid_sucursalPrecio= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPrecio() {
		return this.mostrarid_sucursalPrecio;
	}

	public void setMostrarid_sucursalPrecio(Boolean mostrarid_sucursalPrecio) {
		this.mostrarid_sucursalPrecio= mostrarid_sucursalPrecio;
	}

	public Boolean getActivarid_sucursalPrecio() {
		return this.activarid_sucursalPrecio;
	}

	public void setActivarid_sucursalPrecio(Boolean activarid_sucursalPrecio) {
		this.activarid_sucursalPrecio= activarid_sucursalPrecio;
	}

	public Boolean getCargarid_sucursalPrecio() {
		return this.cargarid_sucursalPrecio;
	}

	public void setCargarid_sucursalPrecio(Boolean cargarid_sucursalPrecio) {
		this.cargarid_sucursalPrecio= cargarid_sucursalPrecio;
	}

	public Border setResaltarid_bodegaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioBeanSwingJInternalFrame.jTtoolBarPrecio.setBorder(borderResaltar);
		
		this.resaltarid_bodegaPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaPrecio() {
		return this.resaltarid_bodegaPrecio;
	}

	public void setResaltarid_bodegaPrecio(Border borderResaltar) {
		this.resaltarid_bodegaPrecio= borderResaltar;
	}

	public Boolean getMostrarid_bodegaPrecio() {
		return this.mostrarid_bodegaPrecio;
	}

	public void setMostrarid_bodegaPrecio(Boolean mostrarid_bodegaPrecio) {
		this.mostrarid_bodegaPrecio= mostrarid_bodegaPrecio;
	}

	public Boolean getActivarid_bodegaPrecio() {
		return this.activarid_bodegaPrecio;
	}

	public void setActivarid_bodegaPrecio(Boolean activarid_bodegaPrecio) {
		this.activarid_bodegaPrecio= activarid_bodegaPrecio;
	}

	public Boolean getCargarid_bodegaPrecio() {
		return this.cargarid_bodegaPrecio;
	}

	public void setCargarid_bodegaPrecio(Boolean cargarid_bodegaPrecio) {
		this.cargarid_bodegaPrecio= cargarid_bodegaPrecio;
	}

	public Border setResaltarid_productoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioBeanSwingJInternalFrame.jTtoolBarPrecio.setBorder(borderResaltar);
		
		this.resaltarid_productoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoPrecio() {
		return this.resaltarid_productoPrecio;
	}

	public void setResaltarid_productoPrecio(Border borderResaltar) {
		this.resaltarid_productoPrecio= borderResaltar;
	}

	public Boolean getMostrarid_productoPrecio() {
		return this.mostrarid_productoPrecio;
	}

	public void setMostrarid_productoPrecio(Boolean mostrarid_productoPrecio) {
		this.mostrarid_productoPrecio= mostrarid_productoPrecio;
	}

	public Boolean getActivarid_productoPrecio() {
		return this.activarid_productoPrecio;
	}

	public void setActivarid_productoPrecio(Boolean activarid_productoPrecio) {
		this.activarid_productoPrecio= activarid_productoPrecio;
	}

	public Boolean getCargarid_productoPrecio() {
		return this.cargarid_productoPrecio;
	}

	public void setCargarid_productoPrecio(Boolean cargarid_productoPrecio) {
		this.cargarid_productoPrecio= cargarid_productoPrecio;
	}

	public Border setResaltarid_lineaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioBeanSwingJInternalFrame.jTtoolBarPrecio.setBorder(borderResaltar);
		
		this.resaltarid_lineaPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaPrecio() {
		return this.resaltarid_lineaPrecio;
	}

	public void setResaltarid_lineaPrecio(Border borderResaltar) {
		this.resaltarid_lineaPrecio= borderResaltar;
	}

	public Boolean getMostrarid_lineaPrecio() {
		return this.mostrarid_lineaPrecio;
	}

	public void setMostrarid_lineaPrecio(Boolean mostrarid_lineaPrecio) {
		this.mostrarid_lineaPrecio= mostrarid_lineaPrecio;
	}

	public Boolean getActivarid_lineaPrecio() {
		return this.activarid_lineaPrecio;
	}

	public void setActivarid_lineaPrecio(Boolean activarid_lineaPrecio) {
		this.activarid_lineaPrecio= activarid_lineaPrecio;
	}

	public Boolean getCargarid_lineaPrecio() {
		return this.cargarid_lineaPrecio;
	}

	public void setCargarid_lineaPrecio(Boolean cargarid_lineaPrecio) {
		this.cargarid_lineaPrecio= cargarid_lineaPrecio;
	}

	public Border setResaltarid_linea_grupoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioBeanSwingJInternalFrame.jTtoolBarPrecio.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoPrecio() {
		return this.resaltarid_linea_grupoPrecio;
	}

	public void setResaltarid_linea_grupoPrecio(Border borderResaltar) {
		this.resaltarid_linea_grupoPrecio= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoPrecio() {
		return this.mostrarid_linea_grupoPrecio;
	}

	public void setMostrarid_linea_grupoPrecio(Boolean mostrarid_linea_grupoPrecio) {
		this.mostrarid_linea_grupoPrecio= mostrarid_linea_grupoPrecio;
	}

	public Boolean getActivarid_linea_grupoPrecio() {
		return this.activarid_linea_grupoPrecio;
	}

	public void setActivarid_linea_grupoPrecio(Boolean activarid_linea_grupoPrecio) {
		this.activarid_linea_grupoPrecio= activarid_linea_grupoPrecio;
	}

	public Boolean getCargarid_linea_grupoPrecio() {
		return this.cargarid_linea_grupoPrecio;
	}

	public void setCargarid_linea_grupoPrecio(Boolean cargarid_linea_grupoPrecio) {
		this.cargarid_linea_grupoPrecio= cargarid_linea_grupoPrecio;
	}

	public Border setResaltarid_linea_categoriaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioBeanSwingJInternalFrame.jTtoolBarPrecio.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaPrecio() {
		return this.resaltarid_linea_categoriaPrecio;
	}

	public void setResaltarid_linea_categoriaPrecio(Border borderResaltar) {
		this.resaltarid_linea_categoriaPrecio= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaPrecio() {
		return this.mostrarid_linea_categoriaPrecio;
	}

	public void setMostrarid_linea_categoriaPrecio(Boolean mostrarid_linea_categoriaPrecio) {
		this.mostrarid_linea_categoriaPrecio= mostrarid_linea_categoriaPrecio;
	}

	public Boolean getActivarid_linea_categoriaPrecio() {
		return this.activarid_linea_categoriaPrecio;
	}

	public void setActivarid_linea_categoriaPrecio(Boolean activarid_linea_categoriaPrecio) {
		this.activarid_linea_categoriaPrecio= activarid_linea_categoriaPrecio;
	}

	public Boolean getCargarid_linea_categoriaPrecio() {
		return this.cargarid_linea_categoriaPrecio;
	}

	public void setCargarid_linea_categoriaPrecio(Boolean cargarid_linea_categoriaPrecio) {
		this.cargarid_linea_categoriaPrecio= cargarid_linea_categoriaPrecio;
	}

	public Border setResaltarid_linea_marcaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioBeanSwingJInternalFrame.jTtoolBarPrecio.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaPrecio() {
		return this.resaltarid_linea_marcaPrecio;
	}

	public void setResaltarid_linea_marcaPrecio(Border borderResaltar) {
		this.resaltarid_linea_marcaPrecio= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaPrecio() {
		return this.mostrarid_linea_marcaPrecio;
	}

	public void setMostrarid_linea_marcaPrecio(Boolean mostrarid_linea_marcaPrecio) {
		this.mostrarid_linea_marcaPrecio= mostrarid_linea_marcaPrecio;
	}

	public Boolean getActivarid_linea_marcaPrecio() {
		return this.activarid_linea_marcaPrecio;
	}

	public void setActivarid_linea_marcaPrecio(Boolean activarid_linea_marcaPrecio) {
		this.activarid_linea_marcaPrecio= activarid_linea_marcaPrecio;
	}

	public Boolean getCargarid_linea_marcaPrecio() {
		return this.cargarid_linea_marcaPrecio;
	}

	public void setCargarid_linea_marcaPrecio(Boolean cargarid_linea_marcaPrecio) {
		this.cargarid_linea_marcaPrecio= cargarid_linea_marcaPrecio;
	}

	public Border setResaltarid_rango_unidad_ventaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioBeanSwingJInternalFrame.jTtoolBarPrecio.setBorder(borderResaltar);
		
		this.resaltarid_rango_unidad_ventaPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_rango_unidad_ventaPrecio() {
		return this.resaltarid_rango_unidad_ventaPrecio;
	}

	public void setResaltarid_rango_unidad_ventaPrecio(Border borderResaltar) {
		this.resaltarid_rango_unidad_ventaPrecio= borderResaltar;
	}

	public Boolean getMostrarid_rango_unidad_ventaPrecio() {
		return this.mostrarid_rango_unidad_ventaPrecio;
	}

	public void setMostrarid_rango_unidad_ventaPrecio(Boolean mostrarid_rango_unidad_ventaPrecio) {
		this.mostrarid_rango_unidad_ventaPrecio= mostrarid_rango_unidad_ventaPrecio;
	}

	public Boolean getActivarid_rango_unidad_ventaPrecio() {
		return this.activarid_rango_unidad_ventaPrecio;
	}

	public void setActivarid_rango_unidad_ventaPrecio(Boolean activarid_rango_unidad_ventaPrecio) {
		this.activarid_rango_unidad_ventaPrecio= activarid_rango_unidad_ventaPrecio;
	}

	public Boolean getCargarid_rango_unidad_ventaPrecio() {
		return this.cargarid_rango_unidad_ventaPrecio;
	}

	public void setCargarid_rango_unidad_ventaPrecio(Boolean cargarid_rango_unidad_ventaPrecio) {
		this.cargarid_rango_unidad_ventaPrecio= cargarid_rango_unidad_ventaPrecio;
	}

	public Border setResaltarid_tipo_precioPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioBeanSwingJInternalFrame.jTtoolBarPrecio.setBorder(borderResaltar);
		
		this.resaltarid_tipo_precioPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_precioPrecio() {
		return this.resaltarid_tipo_precioPrecio;
	}

	public void setResaltarid_tipo_precioPrecio(Border borderResaltar) {
		this.resaltarid_tipo_precioPrecio= borderResaltar;
	}

	public Boolean getMostrarid_tipo_precioPrecio() {
		return this.mostrarid_tipo_precioPrecio;
	}

	public void setMostrarid_tipo_precioPrecio(Boolean mostrarid_tipo_precioPrecio) {
		this.mostrarid_tipo_precioPrecio= mostrarid_tipo_precioPrecio;
	}

	public Boolean getActivarid_tipo_precioPrecio() {
		return this.activarid_tipo_precioPrecio;
	}

	public void setActivarid_tipo_precioPrecio(Boolean activarid_tipo_precioPrecio) {
		this.activarid_tipo_precioPrecio= activarid_tipo_precioPrecio;
	}

	public Boolean getCargarid_tipo_precioPrecio() {
		return this.cargarid_tipo_precioPrecio;
	}

	public void setCargarid_tipo_precioPrecio(Boolean cargarid_tipo_precioPrecio) {
		this.cargarid_tipo_precioPrecio= cargarid_tipo_precioPrecio;
	}

	public Border setResaltarprecioPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioBeanSwingJInternalFrame.jTtoolBarPrecio.setBorder(borderResaltar);
		
		this.resaltarprecioPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioPrecio() {
		return this.resaltarprecioPrecio;
	}

	public void setResaltarprecioPrecio(Border borderResaltar) {
		this.resaltarprecioPrecio= borderResaltar;
	}

	public Boolean getMostrarprecioPrecio() {
		return this.mostrarprecioPrecio;
	}

	public void setMostrarprecioPrecio(Boolean mostrarprecioPrecio) {
		this.mostrarprecioPrecio= mostrarprecioPrecio;
	}

	public Boolean getActivarprecioPrecio() {
		return this.activarprecioPrecio;
	}

	public void setActivarprecioPrecio(Boolean activarprecioPrecio) {
		this.activarprecioPrecio= activarprecioPrecio;
	}

	public Border setResaltardescuentoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioBeanSwingJInternalFrame.jTtoolBarPrecio.setBorder(borderResaltar);
		
		this.resaltardescuentoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoPrecio() {
		return this.resaltardescuentoPrecio;
	}

	public void setResaltardescuentoPrecio(Border borderResaltar) {
		this.resaltardescuentoPrecio= borderResaltar;
	}

	public Boolean getMostrardescuentoPrecio() {
		return this.mostrardescuentoPrecio;
	}

	public void setMostrardescuentoPrecio(Boolean mostrardescuentoPrecio) {
		this.mostrardescuentoPrecio= mostrardescuentoPrecio;
	}

	public Boolean getActivardescuentoPrecio() {
		return this.activardescuentoPrecio;
	}

	public void setActivardescuentoPrecio(Boolean activardescuentoPrecio) {
		this.activardescuentoPrecio= activardescuentoPrecio;
	}

	public Border setResaltarprecio_minimoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioBeanSwingJInternalFrame.jTtoolBarPrecio.setBorder(borderResaltar);
		
		this.resaltarprecio_minimoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecio_minimoPrecio() {
		return this.resaltarprecio_minimoPrecio;
	}

	public void setResaltarprecio_minimoPrecio(Border borderResaltar) {
		this.resaltarprecio_minimoPrecio= borderResaltar;
	}

	public Boolean getMostrarprecio_minimoPrecio() {
		return this.mostrarprecio_minimoPrecio;
	}

	public void setMostrarprecio_minimoPrecio(Boolean mostrarprecio_minimoPrecio) {
		this.mostrarprecio_minimoPrecio= mostrarprecio_minimoPrecio;
	}

	public Boolean getActivarprecio_minimoPrecio() {
		return this.activarprecio_minimoPrecio;
	}

	public void setActivarprecio_minimoPrecio(Boolean activarprecio_minimoPrecio) {
		this.activarprecio_minimoPrecio= activarprecio_minimoPrecio;
	}

	public Border setResaltarcon_impuestoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioBeanSwingJInternalFrame.jTtoolBarPrecio.setBorder(borderResaltar);
		
		this.resaltarcon_impuestoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_impuestoPrecio() {
		return this.resaltarcon_impuestoPrecio;
	}

	public void setResaltarcon_impuestoPrecio(Border borderResaltar) {
		this.resaltarcon_impuestoPrecio= borderResaltar;
	}

	public Boolean getMostrarcon_impuestoPrecio() {
		return this.mostrarcon_impuestoPrecio;
	}

	public void setMostrarcon_impuestoPrecio(Boolean mostrarcon_impuestoPrecio) {
		this.mostrarcon_impuestoPrecio= mostrarcon_impuestoPrecio;
	}

	public Boolean getActivarcon_impuestoPrecio() {
		return this.activarcon_impuestoPrecio;
	}

	public void setActivarcon_impuestoPrecio(Boolean activarcon_impuestoPrecio) {
		this.activarcon_impuestoPrecio= activarcon_impuestoPrecio;
	}

	public Border setResaltarid_estado_precioPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//precioBeanSwingJInternalFrame.jTtoolBarPrecio.setBorder(borderResaltar);
		
		this.resaltarid_estado_precioPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_precioPrecio() {
		return this.resaltarid_estado_precioPrecio;
	}

	public void setResaltarid_estado_precioPrecio(Border borderResaltar) {
		this.resaltarid_estado_precioPrecio= borderResaltar;
	}

	public Boolean getMostrarid_estado_precioPrecio() {
		return this.mostrarid_estado_precioPrecio;
	}

	public void setMostrarid_estado_precioPrecio(Boolean mostrarid_estado_precioPrecio) {
		this.mostrarid_estado_precioPrecio= mostrarid_estado_precioPrecio;
	}

	public Boolean getActivarid_estado_precioPrecio() {
		return this.activarid_estado_precioPrecio;
	}

	public void setActivarid_estado_precioPrecio(Boolean activarid_estado_precioPrecio) {
		this.activarid_estado_precioPrecio= activarid_estado_precioPrecio;
	}

	public Boolean getCargarid_estado_precioPrecio() {
		return this.cargarid_estado_precioPrecio;
	}

	public void setCargarid_estado_precioPrecio(Boolean cargarid_estado_precioPrecio) {
		this.cargarid_estado_precioPrecio= cargarid_estado_precioPrecio;
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
		
		
		this.setMostraridPrecio(esInicial);
		this.setMostrarid_empresaPrecio(esInicial);
		this.setMostrarid_sucursalPrecio(esInicial);
		this.setMostrarid_bodegaPrecio(esInicial);
		this.setMostrarid_productoPrecio(esInicial);
		this.setMostrarid_lineaPrecio(esInicial);
		this.setMostrarid_linea_grupoPrecio(esInicial);
		this.setMostrarid_linea_categoriaPrecio(esInicial);
		this.setMostrarid_linea_marcaPrecio(esInicial);
		this.setMostrarid_rango_unidad_ventaPrecio(esInicial);
		this.setMostrarid_tipo_precioPrecio(esInicial);
		this.setMostrarprecioPrecio(esInicial);
		this.setMostrardescuentoPrecio(esInicial);
		this.setMostrarprecio_minimoPrecio(esInicial);
		this.setMostrarcon_impuestoPrecio(esInicial);
		this.setMostrarid_estado_precioPrecio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PrecioConstantesFunciones.ID)) {
				this.setMostraridPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDRANGOUNIDADVENTA)) {
				this.setMostrarid_rango_unidad_ventaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDTIPOPRECIO)) {
				this.setMostrarid_tipo_precioPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.PRECIO)) {
				this.setMostrarprecioPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.PRECIOMINIMO)) {
				this.setMostrarprecio_minimoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.CONIMPUESTO)) {
				this.setMostrarcon_impuestoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDESTADOPRECIO)) {
				this.setMostrarid_estado_precioPrecio(esAsigna);
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
		
		
		this.setActivaridPrecio(esInicial);
		this.setActivarid_empresaPrecio(esInicial);
		this.setActivarid_sucursalPrecio(esInicial);
		this.setActivarid_bodegaPrecio(esInicial);
		this.setActivarid_productoPrecio(esInicial);
		this.setActivarid_lineaPrecio(esInicial);
		this.setActivarid_linea_grupoPrecio(esInicial);
		this.setActivarid_linea_categoriaPrecio(esInicial);
		this.setActivarid_linea_marcaPrecio(esInicial);
		this.setActivarid_rango_unidad_ventaPrecio(esInicial);
		this.setActivarid_tipo_precioPrecio(esInicial);
		this.setActivarprecioPrecio(esInicial);
		this.setActivardescuentoPrecio(esInicial);
		this.setActivarprecio_minimoPrecio(esInicial);
		this.setActivarcon_impuestoPrecio(esInicial);
		this.setActivarid_estado_precioPrecio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PrecioConstantesFunciones.ID)) {
				this.setActivaridPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDRANGOUNIDADVENTA)) {
				this.setActivarid_rango_unidad_ventaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDTIPOPRECIO)) {
				this.setActivarid_tipo_precioPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.PRECIO)) {
				this.setActivarprecioPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.PRECIOMINIMO)) {
				this.setActivarprecio_minimoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.CONIMPUESTO)) {
				this.setActivarcon_impuestoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDESTADOPRECIO)) {
				this.setActivarid_estado_precioPrecio(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPrecio(esInicial);
		this.setResaltarid_empresaPrecio(esInicial);
		this.setResaltarid_sucursalPrecio(esInicial);
		this.setResaltarid_bodegaPrecio(esInicial);
		this.setResaltarid_productoPrecio(esInicial);
		this.setResaltarid_lineaPrecio(esInicial);
		this.setResaltarid_linea_grupoPrecio(esInicial);
		this.setResaltarid_linea_categoriaPrecio(esInicial);
		this.setResaltarid_linea_marcaPrecio(esInicial);
		this.setResaltarid_rango_unidad_ventaPrecio(esInicial);
		this.setResaltarid_tipo_precioPrecio(esInicial);
		this.setResaltarprecioPrecio(esInicial);
		this.setResaltardescuentoPrecio(esInicial);
		this.setResaltarprecio_minimoPrecio(esInicial);
		this.setResaltarcon_impuestoPrecio(esInicial);
		this.setResaltarid_estado_precioPrecio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PrecioConstantesFunciones.ID)) {
				this.setResaltaridPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDRANGOUNIDADVENTA)) {
				this.setResaltarid_rango_unidad_ventaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDTIPOPRECIO)) {
				this.setResaltarid_tipo_precioPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.PRECIO)) {
				this.setResaltarprecioPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.PRECIOMINIMO)) {
				this.setResaltarprecio_minimoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.CONIMPUESTO)) {
				this.setResaltarcon_impuestoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrecioConstantesFunciones.IDESTADOPRECIO)) {
				this.setResaltarid_estado_precioPrecio(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorIdBodegaPorIdProductoPrecio=true;

	public Boolean getMostrarBusquedaPorIdBodegaPorIdProductoPrecio() {
		return this.mostrarBusquedaPorIdBodegaPorIdProductoPrecio;
	}

	public void setMostrarBusquedaPorIdBodegaPorIdProductoPrecio(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdBodegaPorIdProductoPrecio= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorLineaGrupoCategoriaMarcaPrecio=true;

	public Boolean getMostrarBusquedaPorLineaGrupoCategoriaMarcaPrecio() {
		return this.mostrarBusquedaPorLineaGrupoCategoriaMarcaPrecio;
	}

	public void setMostrarBusquedaPorLineaGrupoCategoriaMarcaPrecio(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorLineaGrupoCategoriaMarcaPrecio= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorLineaGrupoCategoriaMarcaProductoPrecio=true;

	public Boolean getMostrarBusquedaPorLineaGrupoCategoriaMarcaProductoPrecio() {
		return this.mostrarBusquedaPorLineaGrupoCategoriaMarcaProductoPrecio;
	}

	public void setMostrarBusquedaPorLineaGrupoCategoriaMarcaProductoPrecio(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorLineaGrupoCategoriaMarcaProductoPrecio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBodegaPrecio=true;

	public Boolean getMostrarFK_IdBodegaPrecio() {
		return this.mostrarFK_IdBodegaPrecio;
	}

	public void setMostrarFK_IdBodegaPrecio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaPrecio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPrecio=true;

	public Boolean getMostrarFK_IdEmpresaPrecio() {
		return this.mostrarFK_IdEmpresaPrecio;
	}

	public void setMostrarFK_IdEmpresaPrecio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPrecio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoPrecioPrecio=true;

	public Boolean getMostrarFK_IdEstadoPrecioPrecio() {
		return this.mostrarFK_IdEstadoPrecioPrecio;
	}

	public void setMostrarFK_IdEstadoPrecioPrecio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoPrecioPrecio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaPrecio=true;

	public Boolean getMostrarFK_IdLineaPrecio() {
		return this.mostrarFK_IdLineaPrecio;
	}

	public void setMostrarFK_IdLineaPrecio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaPrecio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoPrecio=true;

	public Boolean getMostrarFK_IdProductoPrecio() {
		return this.mostrarFK_IdProductoPrecio;
	}

	public void setMostrarFK_IdProductoPrecio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoPrecio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdRangoUnidadVentaPrecio=true;

	public Boolean getMostrarFK_IdRangoUnidadVentaPrecio() {
		return this.mostrarFK_IdRangoUnidadVentaPrecio;
	}

	public void setMostrarFK_IdRangoUnidadVentaPrecio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdRangoUnidadVentaPrecio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalPrecio=true;

	public Boolean getMostrarFK_IdSucursalPrecio() {
		return this.mostrarFK_IdSucursalPrecio;
	}

	public void setMostrarFK_IdSucursalPrecio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalPrecio= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdBodegaPorIdProductoPrecio=true;

	public Boolean getActivarBusquedaPorIdBodegaPorIdProductoPrecio() {
		return this.activarBusquedaPorIdBodegaPorIdProductoPrecio;
	}

	public void setActivarBusquedaPorIdBodegaPorIdProductoPrecio(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdBodegaPorIdProductoPrecio= habilitarResaltar;
	}

	public Boolean activarBusquedaPorLineaGrupoCategoriaMarcaPrecio=true;

	public Boolean getActivarBusquedaPorLineaGrupoCategoriaMarcaPrecio() {
		return this.activarBusquedaPorLineaGrupoCategoriaMarcaPrecio;
	}

	public void setActivarBusquedaPorLineaGrupoCategoriaMarcaPrecio(Boolean habilitarResaltar) {
		this.activarBusquedaPorLineaGrupoCategoriaMarcaPrecio= habilitarResaltar;
	}

	public Boolean activarBusquedaPorLineaGrupoCategoriaMarcaProductoPrecio=true;

	public Boolean getActivarBusquedaPorLineaGrupoCategoriaMarcaProductoPrecio() {
		return this.activarBusquedaPorLineaGrupoCategoriaMarcaProductoPrecio;
	}

	public void setActivarBusquedaPorLineaGrupoCategoriaMarcaProductoPrecio(Boolean habilitarResaltar) {
		this.activarBusquedaPorLineaGrupoCategoriaMarcaProductoPrecio= habilitarResaltar;
	}

	public Boolean activarFK_IdBodegaPrecio=true;

	public Boolean getActivarFK_IdBodegaPrecio() {
		return this.activarFK_IdBodegaPrecio;
	}

	public void setActivarFK_IdBodegaPrecio(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaPrecio= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPrecio=true;

	public Boolean getActivarFK_IdEmpresaPrecio() {
		return this.activarFK_IdEmpresaPrecio;
	}

	public void setActivarFK_IdEmpresaPrecio(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPrecio= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoPrecioPrecio=true;

	public Boolean getActivarFK_IdEstadoPrecioPrecio() {
		return this.activarFK_IdEstadoPrecioPrecio;
	}

	public void setActivarFK_IdEstadoPrecioPrecio(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoPrecioPrecio= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaPrecio=true;

	public Boolean getActivarFK_IdLineaPrecio() {
		return this.activarFK_IdLineaPrecio;
	}

	public void setActivarFK_IdLineaPrecio(Boolean habilitarResaltar) {
		this.activarFK_IdLineaPrecio= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoPrecio=true;

	public Boolean getActivarFK_IdProductoPrecio() {
		return this.activarFK_IdProductoPrecio;
	}

	public void setActivarFK_IdProductoPrecio(Boolean habilitarResaltar) {
		this.activarFK_IdProductoPrecio= habilitarResaltar;
	}

	public Boolean activarFK_IdRangoUnidadVentaPrecio=true;

	public Boolean getActivarFK_IdRangoUnidadVentaPrecio() {
		return this.activarFK_IdRangoUnidadVentaPrecio;
	}

	public void setActivarFK_IdRangoUnidadVentaPrecio(Boolean habilitarResaltar) {
		this.activarFK_IdRangoUnidadVentaPrecio= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalPrecio=true;

	public Boolean getActivarFK_IdSucursalPrecio() {
		return this.activarFK_IdSucursalPrecio;
	}

	public void setActivarFK_IdSucursalPrecio(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalPrecio= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdBodegaPorIdProductoPrecio=null;

	public Border getResaltarBusquedaPorIdBodegaPorIdProductoPrecio() {
		return this.resaltarBusquedaPorIdBodegaPorIdProductoPrecio;
	}

	public void setResaltarBusquedaPorIdBodegaPorIdProductoPrecio(Border borderResaltar) {
		this.resaltarBusquedaPorIdBodegaPorIdProductoPrecio= borderResaltar;
	}

	public void setResaltarBusquedaPorIdBodegaPorIdProductoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdBodegaPorIdProductoPrecio= borderResaltar;
	}

	public Border resaltarBusquedaPorLineaGrupoCategoriaMarcaPrecio=null;

	public Border getResaltarBusquedaPorLineaGrupoCategoriaMarcaPrecio() {
		return this.resaltarBusquedaPorLineaGrupoCategoriaMarcaPrecio;
	}

	public void setResaltarBusquedaPorLineaGrupoCategoriaMarcaPrecio(Border borderResaltar) {
		this.resaltarBusquedaPorLineaGrupoCategoriaMarcaPrecio= borderResaltar;
	}

	public void setResaltarBusquedaPorLineaGrupoCategoriaMarcaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorLineaGrupoCategoriaMarcaPrecio= borderResaltar;
	}

	public Border resaltarBusquedaPorLineaGrupoCategoriaMarcaProductoPrecio=null;

	public Border getResaltarBusquedaPorLineaGrupoCategoriaMarcaProductoPrecio() {
		return this.resaltarBusquedaPorLineaGrupoCategoriaMarcaProductoPrecio;
	}

	public void setResaltarBusquedaPorLineaGrupoCategoriaMarcaProductoPrecio(Border borderResaltar) {
		this.resaltarBusquedaPorLineaGrupoCategoriaMarcaProductoPrecio= borderResaltar;
	}

	public void setResaltarBusquedaPorLineaGrupoCategoriaMarcaProductoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorLineaGrupoCategoriaMarcaProductoPrecio= borderResaltar;
	}

	public Border resaltarFK_IdBodegaPrecio=null;

	public Border getResaltarFK_IdBodegaPrecio() {
		return this.resaltarFK_IdBodegaPrecio;
	}

	public void setResaltarFK_IdBodegaPrecio(Border borderResaltar) {
		this.resaltarFK_IdBodegaPrecio= borderResaltar;
	}

	public void setResaltarFK_IdBodegaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaPrecio= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPrecio=null;

	public Border getResaltarFK_IdEmpresaPrecio() {
		return this.resaltarFK_IdEmpresaPrecio;
	}

	public void setResaltarFK_IdEmpresaPrecio(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPrecio= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPrecio= borderResaltar;
	}

	public Border resaltarFK_IdEstadoPrecioPrecio=null;

	public Border getResaltarFK_IdEstadoPrecioPrecio() {
		return this.resaltarFK_IdEstadoPrecioPrecio;
	}

	public void setResaltarFK_IdEstadoPrecioPrecio(Border borderResaltar) {
		this.resaltarFK_IdEstadoPrecioPrecio= borderResaltar;
	}

	public void setResaltarFK_IdEstadoPrecioPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoPrecioPrecio= borderResaltar;
	}

	public Border resaltarFK_IdLineaPrecio=null;

	public Border getResaltarFK_IdLineaPrecio() {
		return this.resaltarFK_IdLineaPrecio;
	}

	public void setResaltarFK_IdLineaPrecio(Border borderResaltar) {
		this.resaltarFK_IdLineaPrecio= borderResaltar;
	}

	public void setResaltarFK_IdLineaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaPrecio= borderResaltar;
	}

	public Border resaltarFK_IdProductoPrecio=null;

	public Border getResaltarFK_IdProductoPrecio() {
		return this.resaltarFK_IdProductoPrecio;
	}

	public void setResaltarFK_IdProductoPrecio(Border borderResaltar) {
		this.resaltarFK_IdProductoPrecio= borderResaltar;
	}

	public void setResaltarFK_IdProductoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoPrecio= borderResaltar;
	}

	public Border resaltarFK_IdRangoUnidadVentaPrecio=null;

	public Border getResaltarFK_IdRangoUnidadVentaPrecio() {
		return this.resaltarFK_IdRangoUnidadVentaPrecio;
	}

	public void setResaltarFK_IdRangoUnidadVentaPrecio(Border borderResaltar) {
		this.resaltarFK_IdRangoUnidadVentaPrecio= borderResaltar;
	}

	public void setResaltarFK_IdRangoUnidadVentaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdRangoUnidadVentaPrecio= borderResaltar;
	}

	public Border resaltarFK_IdSucursalPrecio=null;

	public Border getResaltarFK_IdSucursalPrecio() {
		return this.resaltarFK_IdSucursalPrecio;
	}

	public void setResaltarFK_IdSucursalPrecio(Border borderResaltar) {
		this.resaltarFK_IdSucursalPrecio= borderResaltar;
	}

	public void setResaltarFK_IdSucursalPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*PrecioBeanSwingJInternalFrame precioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalPrecio= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}