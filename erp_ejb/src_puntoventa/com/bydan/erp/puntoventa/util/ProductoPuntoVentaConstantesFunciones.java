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
package com.bydan.erp.puntoventa.util;

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


import com.bydan.erp.puntoventa.util.ProductoPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.ProductoPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.ProductoPuntoVentaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProductoPuntoVentaConstantesFunciones extends ProductoPuntoVentaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProductoPuntoVenta";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductoPuntoVenta"+ProductoPuntoVentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductoPuntoVentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductoPuntoVentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductoPuntoVentaConstantesFunciones.SCHEMA+"_"+ProductoPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductoPuntoVentaConstantesFunciones.SCHEMA+"_"+ProductoPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductoPuntoVentaConstantesFunciones.SCHEMA+"_"+ProductoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductoPuntoVentaConstantesFunciones.SCHEMA+"_"+ProductoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductoPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductoPuntoVentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductoPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductoPuntoVentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Producto Punto Ventas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Producto Punto Venta";
	public static final String SCLASSWEBTITULO_LOWER="Producto Punto Venta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductoPuntoVenta";
	public static final String OBJECTNAME="productopuntoventa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="producto_punto_venta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productopuntoventa from "+ProductoPuntoVentaConstantesFunciones.SPERSISTENCENAME+" productopuntoventa";
	public static String QUERYSELECTNATIVE="select "+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME+".id,"+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME+".id_linea,"+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME+".id_linea_grupo,"+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME+".id_linea_categoria,"+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME+".id_linea_marca,"+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME+".id_producto,"+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME+".esta_activo from "+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME;//+" as "+ProductoPuntoVentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProductoPuntoVentaConstantesFuncionesAdditional productopuntoventaConstantesFuncionesAdditional=null;
	
	public ProductoPuntoVentaConstantesFuncionesAdditional getProductoPuntoVentaConstantesFuncionesAdditional() {
		return this.productopuntoventaConstantesFuncionesAdditional;
	}
	
	public void setProductoPuntoVentaConstantesFuncionesAdditional(ProductoPuntoVentaConstantesFuncionesAdditional productopuntoventaConstantesFuncionesAdditional) {
		try {
			this.productopuntoventaConstantesFuncionesAdditional=productopuntoventaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
    public static final String IDPRODUCTO= "id_producto";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDLINEAGRUPO= "Linea Grupo";
		public static final String LABEL_IDLINEAGRUPO_LOWER= "Linea Grupo";
    	public static final String LABEL_IDLINEACATEGORIA= "Linea Categoria";
		public static final String LABEL_IDLINEACATEGORIA_LOWER= "Linea Categoria";
    	public static final String LABEL_IDLINEAMARCA= "Linea Marca";
		public static final String LABEL_IDLINEAMARCA_LOWER= "Linea Marca";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
		
		
		
	
	public static String getProductoPuntoVentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductoPuntoVentaConstantesFunciones.IDLINEA)) {sLabelColumna=ProductoPuntoVentaConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ProductoPuntoVentaConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=ProductoPuntoVentaConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(ProductoPuntoVentaConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=ProductoPuntoVentaConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(ProductoPuntoVentaConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=ProductoPuntoVentaConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(ProductoPuntoVentaConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProductoPuntoVentaConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProductoPuntoVentaConstantesFunciones.ESTAACTIVO)) {sLabelColumna=ProductoPuntoVentaConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(ProductoPuntoVenta productopuntoventa) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!productopuntoventa.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(ProductoPuntoVenta productopuntoventa) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(productopuntoventa.getId(),productopuntoventa.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getProductoPuntoVentaDescripcion(ProductoPuntoVenta productopuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productopuntoventa !=null/* && productopuntoventa.getId()!=0*/) {
			if(productopuntoventa.getId()!=null) {
				sDescripcion=productopuntoventa.getId().toString();
			}//productopuntoventaproductopuntoventa.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductoPuntoVentaDescripcionDetallado(ProductoPuntoVenta productopuntoventa) {
		String sDescripcion="";
			
		sDescripcion+=ProductoPuntoVentaConstantesFunciones.ID+"=";
		sDescripcion+=productopuntoventa.getId().toString()+",";
		sDescripcion+=ProductoPuntoVentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productopuntoventa.getVersionRow().toString()+",";
		sDescripcion+=ProductoPuntoVentaConstantesFunciones.IDLINEA+"=";
		sDescripcion+=productopuntoventa.getid_linea().toString()+",";
		sDescripcion+=ProductoPuntoVentaConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=productopuntoventa.getid_linea_grupo().toString()+",";
		sDescripcion+=ProductoPuntoVentaConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=productopuntoventa.getid_linea_categoria().toString()+",";
		sDescripcion+=ProductoPuntoVentaConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=productopuntoventa.getid_linea_marca().toString()+",";
		sDescripcion+=ProductoPuntoVentaConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=productopuntoventa.getid_producto().toString()+",";
		sDescripcion+=ProductoPuntoVentaConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=productopuntoventa.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProductoPuntoVentaDescripcion(ProductoPuntoVenta productopuntoventa,String sValor) throws Exception {			
		if(productopuntoventa !=null) {
			//productopuntoventaproductopuntoventa.getId().toString();
		}		
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
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosProductoPuntoVenta(ProductoPuntoVenta productopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProductoPuntoVentas(List<ProductoPuntoVenta> productopuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoPuntoVenta productopuntoventa: productopuntoventas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoPuntoVenta(ProductoPuntoVenta productopuntoventa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productopuntoventa.getConCambioAuxiliar()) {
			productopuntoventa.setIsDeleted(productopuntoventa.getIsDeletedAuxiliar());	
			productopuntoventa.setIsNew(productopuntoventa.getIsNewAuxiliar());	
			productopuntoventa.setIsChanged(productopuntoventa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productopuntoventa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productopuntoventa.setIsDeletedAuxiliar(false);	
			productopuntoventa.setIsNewAuxiliar(false);	
			productopuntoventa.setIsChangedAuxiliar(false);
			
			productopuntoventa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoPuntoVentas(List<ProductoPuntoVenta> productopuntoventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductoPuntoVenta productopuntoventa : productopuntoventas) {
			if(conAsignarBase && productopuntoventa.getConCambioAuxiliar()) {
				productopuntoventa.setIsDeleted(productopuntoventa.getIsDeletedAuxiliar());	
				productopuntoventa.setIsNew(productopuntoventa.getIsNewAuxiliar());	
				productopuntoventa.setIsChanged(productopuntoventa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productopuntoventa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productopuntoventa.setIsDeletedAuxiliar(false);	
				productopuntoventa.setIsNewAuxiliar(false);	
				productopuntoventa.setIsChangedAuxiliar(false);
				
				productopuntoventa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductoPuntoVenta(ProductoPuntoVenta productopuntoventa,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProductoPuntoVentas(List<ProductoPuntoVenta> productopuntoventas,Boolean conEnteros) throws Exception  {
		
		for(ProductoPuntoVenta productopuntoventa: productopuntoventas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductoPuntoVenta(List<ProductoPuntoVenta> productopuntoventas,ProductoPuntoVenta productopuntoventaAux) throws Exception  {
		ProductoPuntoVentaConstantesFunciones.InicializarValoresProductoPuntoVenta(productopuntoventaAux,true);
		
		for(ProductoPuntoVenta productopuntoventa: productopuntoventas) {
			if(productopuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductoPuntoVentaConstantesFunciones.getArrayColumnasGlobalesProductoPuntoVenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoPuntoVenta> productopuntoventas,ProductoPuntoVenta productopuntoventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoPuntoVenta productopuntoventaAux: productopuntoventas) {
			if(productopuntoventaAux!=null && productopuntoventa!=null) {
				if((productopuntoventaAux.getId()==null && productopuntoventa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productopuntoventaAux.getId()!=null && productopuntoventa.getId()!=null){
					if(productopuntoventaAux.getId().equals(productopuntoventa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoPuntoVenta(List<ProductoPuntoVenta> productopuntoventas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProductoPuntoVenta productopuntoventa: productopuntoventas) {			
			if(productopuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductoPuntoVenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductoPuntoVentaConstantesFunciones.LABEL_ID, ProductoPuntoVentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoPuntoVentaConstantesFunciones.LABEL_VERSIONROW, ProductoPuntoVentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoPuntoVentaConstantesFunciones.LABEL_IDLINEA, ProductoPuntoVentaConstantesFunciones.IDLINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoPuntoVentaConstantesFunciones.LABEL_IDLINEAGRUPO, ProductoPuntoVentaConstantesFunciones.IDLINEAGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoPuntoVentaConstantesFunciones.LABEL_IDLINEACATEGORIA, ProductoPuntoVentaConstantesFunciones.IDLINEACATEGORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoPuntoVentaConstantesFunciones.LABEL_IDLINEAMARCA, ProductoPuntoVentaConstantesFunciones.IDLINEAMARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoPuntoVentaConstantesFunciones.LABEL_IDPRODUCTO, ProductoPuntoVentaConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoPuntoVentaConstantesFunciones.LABEL_ESTAACTIVO, ProductoPuntoVentaConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductoPuntoVenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductoPuntoVentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoPuntoVentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoPuntoVentaConstantesFunciones.IDLINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoPuntoVentaConstantesFunciones.IDLINEAGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoPuntoVentaConstantesFunciones.IDLINEACATEGORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoPuntoVentaConstantesFunciones.IDLINEAMARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoPuntoVentaConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoPuntoVentaConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoPuntoVenta() throws Exception  {
		return ProductoPuntoVentaConstantesFunciones.getTiposSeleccionarProductoPuntoVenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoPuntoVenta(Boolean conFk) throws Exception  {
		return ProductoPuntoVentaConstantesFunciones.getTiposSeleccionarProductoPuntoVenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoPuntoVenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoPuntoVentaConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ProductoPuntoVentaConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoPuntoVentaConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(ProductoPuntoVentaConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoPuntoVentaConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(ProductoPuntoVentaConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoPuntoVentaConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(ProductoPuntoVentaConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoPuntoVentaConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProductoPuntoVentaConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoPuntoVentaConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(ProductoPuntoVentaConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductoPuntoVenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductoPuntoVenta(ProductoPuntoVenta productopuntoventaAux) throws Exception {
		
			productopuntoventaAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(productopuntoventaAux.getLinea()));
			productopuntoventaAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(productopuntoventaAux.getLineaGrupo()));
			productopuntoventaAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(productopuntoventaAux.getLineaCategoria()));
			productopuntoventaAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(productopuntoventaAux.getLineaMarca()));
			productopuntoventaAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productopuntoventaAux.getProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductoPuntoVenta(List<ProductoPuntoVenta> productopuntoventasTemp) throws Exception {
		for(ProductoPuntoVenta productopuntoventaAux:productopuntoventasTemp) {
			
			productopuntoventaAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(productopuntoventaAux.getLinea()));
			productopuntoventaAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(productopuntoventaAux.getLineaGrupo()));
			productopuntoventaAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(productopuntoventaAux.getLineaCategoria()));
			productopuntoventaAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(productopuntoventaAux.getLineaMarca()));
			productopuntoventaAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productopuntoventaAux.getProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Producto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

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

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoPuntoVentaConstantesFunciones.getClassesRelationshipsOfProductoPuntoVenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoPuntoVentaConstantesFunciones.getClassesRelationshipsFromStringsOfProductoPuntoVenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductoPuntoVenta productopuntoventa,List<ProductoPuntoVenta> productopuntoventas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProductoPuntoVenta productopuntoventaEncontrado=null;
			
			for(ProductoPuntoVenta productopuntoventaLocal:productopuntoventas) {
				if(productopuntoventaLocal.getId().equals(productopuntoventa.getId())) {
					productopuntoventaEncontrado=productopuntoventaLocal;
					
					productopuntoventaLocal.setIsChanged(productopuntoventa.getIsChanged());
					productopuntoventaLocal.setIsNew(productopuntoventa.getIsNew());
					productopuntoventaLocal.setIsDeleted(productopuntoventa.getIsDeleted());
					
					productopuntoventaLocal.setGeneralEntityOriginal(productopuntoventa.getGeneralEntityOriginal());
					
					productopuntoventaLocal.setId(productopuntoventa.getId());	
					productopuntoventaLocal.setVersionRow(productopuntoventa.getVersionRow());	
					productopuntoventaLocal.setid_linea(productopuntoventa.getid_linea());	
					productopuntoventaLocal.setid_linea_grupo(productopuntoventa.getid_linea_grupo());	
					productopuntoventaLocal.setid_linea_categoria(productopuntoventa.getid_linea_categoria());	
					productopuntoventaLocal.setid_linea_marca(productopuntoventa.getid_linea_marca());	
					productopuntoventaLocal.setid_producto(productopuntoventa.getid_producto());	
					productopuntoventaLocal.setesta_activo(productopuntoventa.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!productopuntoventa.getIsDeleted()) {
				if(!existe) {
					productopuntoventas.add(productopuntoventa);
				}
			} else {
				if(productopuntoventaEncontrado!=null && permiteQuitar)  {
					productopuntoventas.remove(productopuntoventaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProductoPuntoVenta productopuntoventa,List<ProductoPuntoVenta> productopuntoventas) throws Exception {
		try	{			
			for(ProductoPuntoVenta productopuntoventaLocal:productopuntoventas) {
				if(productopuntoventaLocal.getId().equals(productopuntoventa.getId())) {
					productopuntoventaLocal.setIsSelected(productopuntoventa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductoPuntoVenta(List<ProductoPuntoVenta> productopuntoventasAux) throws Exception {
		//this.productopuntoventasAux=productopuntoventasAux;
		
		for(ProductoPuntoVenta productopuntoventaAux:productopuntoventasAux) {
			if(productopuntoventaAux.getIsChanged()) {
				productopuntoventaAux.setIsChanged(false);
			}		
			
			if(productopuntoventaAux.getIsNew()) {
				productopuntoventaAux.setIsNew(false);
			}	
			
			if(productopuntoventaAux.getIsDeleted()) {
				productopuntoventaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductoPuntoVenta(ProductoPuntoVenta productopuntoventaAux) throws Exception {
		//this.productopuntoventaAux=productopuntoventaAux;
		
			if(productopuntoventaAux.getIsChanged()) {
				productopuntoventaAux.setIsChanged(false);
			}		
			
			if(productopuntoventaAux.getIsNew()) {
				productopuntoventaAux.setIsNew(false);
			}	
			
			if(productopuntoventaAux.getIsDeleted()) {
				productopuntoventaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductoPuntoVenta productopuntoventaAsignar,ProductoPuntoVenta productopuntoventa) throws Exception {
		productopuntoventaAsignar.setId(productopuntoventa.getId());	
		productopuntoventaAsignar.setVersionRow(productopuntoventa.getVersionRow());	
		productopuntoventaAsignar.setid_linea(productopuntoventa.getid_linea());
		productopuntoventaAsignar.setlinea_descripcion(productopuntoventa.getlinea_descripcion());	
		productopuntoventaAsignar.setid_linea_grupo(productopuntoventa.getid_linea_grupo());
		productopuntoventaAsignar.setlineagrupo_descripcion(productopuntoventa.getlineagrupo_descripcion());	
		productopuntoventaAsignar.setid_linea_categoria(productopuntoventa.getid_linea_categoria());
		productopuntoventaAsignar.setlineacategoria_descripcion(productopuntoventa.getlineacategoria_descripcion());	
		productopuntoventaAsignar.setid_linea_marca(productopuntoventa.getid_linea_marca());
		productopuntoventaAsignar.setlineamarca_descripcion(productopuntoventa.getlineamarca_descripcion());	
		productopuntoventaAsignar.setid_producto(productopuntoventa.getid_producto());
		productopuntoventaAsignar.setproducto_descripcion(productopuntoventa.getproducto_descripcion());	
		productopuntoventaAsignar.setesta_activo(productopuntoventa.getesta_activo());	
	}
	
	public static void inicializarProductoPuntoVenta(ProductoPuntoVenta productopuntoventa) throws Exception {
		try {
				productopuntoventa.setId(0L);	
					
				productopuntoventa.setid_linea(-1L);	
				productopuntoventa.setid_linea_grupo(null);	
				productopuntoventa.setid_linea_categoria(null);	
				productopuntoventa.setid_linea_marca(null);	
				productopuntoventa.setid_producto(-1L);	
				productopuntoventa.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductoPuntoVenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoPuntoVentaConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoPuntoVentaConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoPuntoVentaConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoPuntoVentaConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoPuntoVentaConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoPuntoVentaConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductoPuntoVenta(String sTipo,Row row,Workbook workbook,ProductoPuntoVenta productopuntoventa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productopuntoventa.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productopuntoventa.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productopuntoventa.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productopuntoventa.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productopuntoventa.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(productopuntoventa.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductoPuntoVenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProductoPuntoVenta() {
		return this.sFinalQueryProductoPuntoVenta;
	}
	
	public void setsFinalQueryProductoPuntoVenta(String sFinalQueryProductoPuntoVenta) {
		this.sFinalQueryProductoPuntoVenta= sFinalQueryProductoPuntoVenta;
	}
	
	public Border resaltarSeleccionarProductoPuntoVenta=null;
	
	public Border setResaltarSeleccionarProductoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPuntoVentaBeanSwingJInternalFrame productopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productopuntoventaBeanSwingJInternalFrame.jTtoolBarProductoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductoPuntoVenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductoPuntoVenta() {
		return this.resaltarSeleccionarProductoPuntoVenta;
	}
	
	public void setResaltarSeleccionarProductoPuntoVenta(Border borderResaltarSeleccionarProductoPuntoVenta) {
		this.resaltarSeleccionarProductoPuntoVenta= borderResaltarSeleccionarProductoPuntoVenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductoPuntoVenta=null;
	public Boolean mostraridProductoPuntoVenta=true;
	public Boolean activaridProductoPuntoVenta=true;

	public Border resaltarid_lineaProductoPuntoVenta=null;
	public Boolean mostrarid_lineaProductoPuntoVenta=true;
	public Boolean activarid_lineaProductoPuntoVenta=true;
	public Boolean cargarid_lineaProductoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaProductoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoProductoPuntoVenta=null;
	public Boolean mostrarid_linea_grupoProductoPuntoVenta=true;
	public Boolean activarid_linea_grupoProductoPuntoVenta=true;
	public Boolean cargarid_linea_grupoProductoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoProductoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaProductoPuntoVenta=null;
	public Boolean mostrarid_linea_categoriaProductoPuntoVenta=true;
	public Boolean activarid_linea_categoriaProductoPuntoVenta=true;
	public Boolean cargarid_linea_categoriaProductoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaProductoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaProductoPuntoVenta=null;
	public Boolean mostrarid_linea_marcaProductoPuntoVenta=true;
	public Boolean activarid_linea_marcaProductoPuntoVenta=true;
	public Boolean cargarid_linea_marcaProductoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaProductoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_productoProductoPuntoVenta=null;
	public Boolean mostrarid_productoProductoPuntoVenta=true;
	public Boolean activarid_productoProductoPuntoVenta=true;
	public Boolean cargarid_productoProductoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProductoPuntoVenta=false;//ConEventDepend=true

	public Border resaltaresta_activoProductoPuntoVenta=null;
	public Boolean mostraresta_activoProductoPuntoVenta=true;
	public Boolean activaresta_activoProductoPuntoVenta=true;

	
	

	public Border setResaltaridProductoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPuntoVentaBeanSwingJInternalFrame productopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productopuntoventaBeanSwingJInternalFrame.jTtoolBarProductoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltaridProductoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductoPuntoVenta() {
		return this.resaltaridProductoPuntoVenta;
	}

	public void setResaltaridProductoPuntoVenta(Border borderResaltar) {
		this.resaltaridProductoPuntoVenta= borderResaltar;
	}

	public Boolean getMostraridProductoPuntoVenta() {
		return this.mostraridProductoPuntoVenta;
	}

	public void setMostraridProductoPuntoVenta(Boolean mostraridProductoPuntoVenta) {
		this.mostraridProductoPuntoVenta= mostraridProductoPuntoVenta;
	}

	public Boolean getActivaridProductoPuntoVenta() {
		return this.activaridProductoPuntoVenta;
	}

	public void setActivaridProductoPuntoVenta(Boolean activaridProductoPuntoVenta) {
		this.activaridProductoPuntoVenta= activaridProductoPuntoVenta;
	}

	public Border setResaltarid_lineaProductoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPuntoVentaBeanSwingJInternalFrame productopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productopuntoventaBeanSwingJInternalFrame.jTtoolBarProductoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_lineaProductoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaProductoPuntoVenta() {
		return this.resaltarid_lineaProductoPuntoVenta;
	}

	public void setResaltarid_lineaProductoPuntoVenta(Border borderResaltar) {
		this.resaltarid_lineaProductoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_lineaProductoPuntoVenta() {
		return this.mostrarid_lineaProductoPuntoVenta;
	}

	public void setMostrarid_lineaProductoPuntoVenta(Boolean mostrarid_lineaProductoPuntoVenta) {
		this.mostrarid_lineaProductoPuntoVenta= mostrarid_lineaProductoPuntoVenta;
	}

	public Boolean getActivarid_lineaProductoPuntoVenta() {
		return this.activarid_lineaProductoPuntoVenta;
	}

	public void setActivarid_lineaProductoPuntoVenta(Boolean activarid_lineaProductoPuntoVenta) {
		this.activarid_lineaProductoPuntoVenta= activarid_lineaProductoPuntoVenta;
	}

	public Boolean getCargarid_lineaProductoPuntoVenta() {
		return this.cargarid_lineaProductoPuntoVenta;
	}

	public void setCargarid_lineaProductoPuntoVenta(Boolean cargarid_lineaProductoPuntoVenta) {
		this.cargarid_lineaProductoPuntoVenta= cargarid_lineaProductoPuntoVenta;
	}

	public Border setResaltarid_linea_grupoProductoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPuntoVentaBeanSwingJInternalFrame productopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productopuntoventaBeanSwingJInternalFrame.jTtoolBarProductoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoProductoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoProductoPuntoVenta() {
		return this.resaltarid_linea_grupoProductoPuntoVenta;
	}

	public void setResaltarid_linea_grupoProductoPuntoVenta(Border borderResaltar) {
		this.resaltarid_linea_grupoProductoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoProductoPuntoVenta() {
		return this.mostrarid_linea_grupoProductoPuntoVenta;
	}

	public void setMostrarid_linea_grupoProductoPuntoVenta(Boolean mostrarid_linea_grupoProductoPuntoVenta) {
		this.mostrarid_linea_grupoProductoPuntoVenta= mostrarid_linea_grupoProductoPuntoVenta;
	}

	public Boolean getActivarid_linea_grupoProductoPuntoVenta() {
		return this.activarid_linea_grupoProductoPuntoVenta;
	}

	public void setActivarid_linea_grupoProductoPuntoVenta(Boolean activarid_linea_grupoProductoPuntoVenta) {
		this.activarid_linea_grupoProductoPuntoVenta= activarid_linea_grupoProductoPuntoVenta;
	}

	public Boolean getCargarid_linea_grupoProductoPuntoVenta() {
		return this.cargarid_linea_grupoProductoPuntoVenta;
	}

	public void setCargarid_linea_grupoProductoPuntoVenta(Boolean cargarid_linea_grupoProductoPuntoVenta) {
		this.cargarid_linea_grupoProductoPuntoVenta= cargarid_linea_grupoProductoPuntoVenta;
	}

	public Border setResaltarid_linea_categoriaProductoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPuntoVentaBeanSwingJInternalFrame productopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productopuntoventaBeanSwingJInternalFrame.jTtoolBarProductoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaProductoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaProductoPuntoVenta() {
		return this.resaltarid_linea_categoriaProductoPuntoVenta;
	}

	public void setResaltarid_linea_categoriaProductoPuntoVenta(Border borderResaltar) {
		this.resaltarid_linea_categoriaProductoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaProductoPuntoVenta() {
		return this.mostrarid_linea_categoriaProductoPuntoVenta;
	}

	public void setMostrarid_linea_categoriaProductoPuntoVenta(Boolean mostrarid_linea_categoriaProductoPuntoVenta) {
		this.mostrarid_linea_categoriaProductoPuntoVenta= mostrarid_linea_categoriaProductoPuntoVenta;
	}

	public Boolean getActivarid_linea_categoriaProductoPuntoVenta() {
		return this.activarid_linea_categoriaProductoPuntoVenta;
	}

	public void setActivarid_linea_categoriaProductoPuntoVenta(Boolean activarid_linea_categoriaProductoPuntoVenta) {
		this.activarid_linea_categoriaProductoPuntoVenta= activarid_linea_categoriaProductoPuntoVenta;
	}

	public Boolean getCargarid_linea_categoriaProductoPuntoVenta() {
		return this.cargarid_linea_categoriaProductoPuntoVenta;
	}

	public void setCargarid_linea_categoriaProductoPuntoVenta(Boolean cargarid_linea_categoriaProductoPuntoVenta) {
		this.cargarid_linea_categoriaProductoPuntoVenta= cargarid_linea_categoriaProductoPuntoVenta;
	}

	public Border setResaltarid_linea_marcaProductoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPuntoVentaBeanSwingJInternalFrame productopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productopuntoventaBeanSwingJInternalFrame.jTtoolBarProductoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaProductoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaProductoPuntoVenta() {
		return this.resaltarid_linea_marcaProductoPuntoVenta;
	}

	public void setResaltarid_linea_marcaProductoPuntoVenta(Border borderResaltar) {
		this.resaltarid_linea_marcaProductoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaProductoPuntoVenta() {
		return this.mostrarid_linea_marcaProductoPuntoVenta;
	}

	public void setMostrarid_linea_marcaProductoPuntoVenta(Boolean mostrarid_linea_marcaProductoPuntoVenta) {
		this.mostrarid_linea_marcaProductoPuntoVenta= mostrarid_linea_marcaProductoPuntoVenta;
	}

	public Boolean getActivarid_linea_marcaProductoPuntoVenta() {
		return this.activarid_linea_marcaProductoPuntoVenta;
	}

	public void setActivarid_linea_marcaProductoPuntoVenta(Boolean activarid_linea_marcaProductoPuntoVenta) {
		this.activarid_linea_marcaProductoPuntoVenta= activarid_linea_marcaProductoPuntoVenta;
	}

	public Boolean getCargarid_linea_marcaProductoPuntoVenta() {
		return this.cargarid_linea_marcaProductoPuntoVenta;
	}

	public void setCargarid_linea_marcaProductoPuntoVenta(Boolean cargarid_linea_marcaProductoPuntoVenta) {
		this.cargarid_linea_marcaProductoPuntoVenta= cargarid_linea_marcaProductoPuntoVenta;
	}

	public Border setResaltarid_productoProductoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPuntoVentaBeanSwingJInternalFrame productopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productopuntoventaBeanSwingJInternalFrame.jTtoolBarProductoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_productoProductoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProductoPuntoVenta() {
		return this.resaltarid_productoProductoPuntoVenta;
	}

	public void setResaltarid_productoProductoPuntoVenta(Border borderResaltar) {
		this.resaltarid_productoProductoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_productoProductoPuntoVenta() {
		return this.mostrarid_productoProductoPuntoVenta;
	}

	public void setMostrarid_productoProductoPuntoVenta(Boolean mostrarid_productoProductoPuntoVenta) {
		this.mostrarid_productoProductoPuntoVenta= mostrarid_productoProductoPuntoVenta;
	}

	public Boolean getActivarid_productoProductoPuntoVenta() {
		return this.activarid_productoProductoPuntoVenta;
	}

	public void setActivarid_productoProductoPuntoVenta(Boolean activarid_productoProductoPuntoVenta) {
		this.activarid_productoProductoPuntoVenta= activarid_productoProductoPuntoVenta;
	}

	public Boolean getCargarid_productoProductoPuntoVenta() {
		return this.cargarid_productoProductoPuntoVenta;
	}

	public void setCargarid_productoProductoPuntoVenta(Boolean cargarid_productoProductoPuntoVenta) {
		this.cargarid_productoProductoPuntoVenta= cargarid_productoProductoPuntoVenta;
	}

	public Border setResaltaresta_activoProductoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPuntoVentaBeanSwingJInternalFrame productopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productopuntoventaBeanSwingJInternalFrame.jTtoolBarProductoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltaresta_activoProductoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoProductoPuntoVenta() {
		return this.resaltaresta_activoProductoPuntoVenta;
	}

	public void setResaltaresta_activoProductoPuntoVenta(Border borderResaltar) {
		this.resaltaresta_activoProductoPuntoVenta= borderResaltar;
	}

	public Boolean getMostraresta_activoProductoPuntoVenta() {
		return this.mostraresta_activoProductoPuntoVenta;
	}

	public void setMostraresta_activoProductoPuntoVenta(Boolean mostraresta_activoProductoPuntoVenta) {
		this.mostraresta_activoProductoPuntoVenta= mostraresta_activoProductoPuntoVenta;
	}

	public Boolean getActivaresta_activoProductoPuntoVenta() {
		return this.activaresta_activoProductoPuntoVenta;
	}

	public void setActivaresta_activoProductoPuntoVenta(Boolean activaresta_activoProductoPuntoVenta) {
		this.activaresta_activoProductoPuntoVenta= activaresta_activoProductoPuntoVenta;
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
		
		
		this.setMostraridProductoPuntoVenta(esInicial);
		this.setMostrarid_lineaProductoPuntoVenta(esInicial);
		this.setMostrarid_linea_grupoProductoPuntoVenta(esInicial);
		this.setMostrarid_linea_categoriaProductoPuntoVenta(esInicial);
		this.setMostrarid_linea_marcaProductoPuntoVenta(esInicial);
		this.setMostrarid_productoProductoPuntoVenta(esInicial);
		this.setMostraresta_activoProductoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoPuntoVentaConstantesFunciones.ID)) {
				this.setMostraridProductoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPuntoVentaConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaProductoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPuntoVentaConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoProductoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPuntoVentaConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaProductoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPuntoVentaConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaProductoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPuntoVentaConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProductoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPuntoVentaConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoProductoPuntoVenta(esAsigna);
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
		
		
		this.setActivaridProductoPuntoVenta(esInicial);
		this.setActivarid_lineaProductoPuntoVenta(esInicial);
		this.setActivarid_linea_grupoProductoPuntoVenta(esInicial);
		this.setActivarid_linea_categoriaProductoPuntoVenta(esInicial);
		this.setActivarid_linea_marcaProductoPuntoVenta(esInicial);
		this.setActivarid_productoProductoPuntoVenta(esInicial);
		this.setActivaresta_activoProductoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoPuntoVentaConstantesFunciones.ID)) {
				this.setActivaridProductoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPuntoVentaConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaProductoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPuntoVentaConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoProductoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPuntoVentaConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaProductoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPuntoVentaConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaProductoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPuntoVentaConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProductoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPuntoVentaConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoProductoPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoPuntoVentaBeanSwingJInternalFrame productopuntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductoPuntoVenta(esInicial);
		this.setResaltarid_lineaProductoPuntoVenta(esInicial);
		this.setResaltarid_linea_grupoProductoPuntoVenta(esInicial);
		this.setResaltarid_linea_categoriaProductoPuntoVenta(esInicial);
		this.setResaltarid_linea_marcaProductoPuntoVenta(esInicial);
		this.setResaltarid_productoProductoPuntoVenta(esInicial);
		this.setResaltaresta_activoProductoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoPuntoVentaConstantesFunciones.ID)) {
				this.setResaltaridProductoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPuntoVentaConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaProductoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPuntoVentaConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoProductoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPuntoVentaConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaProductoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPuntoVentaConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaProductoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPuntoVentaConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProductoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoPuntoVentaConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoProductoPuntoVenta(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoPuntoVentaBeanSwingJInternalFrame productopuntoventaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdLineaProductoPuntoVenta=true;

	public Boolean getMostrarFK_IdLineaProductoPuntoVenta() {
		return this.mostrarFK_IdLineaProductoPuntoVenta;
	}

	public void setMostrarFK_IdLineaProductoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaProductoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaCategoriaProductoPuntoVenta=true;

	public Boolean getMostrarFK_IdLineaCategoriaProductoPuntoVenta() {
		return this.mostrarFK_IdLineaCategoriaProductoPuntoVenta;
	}

	public void setMostrarFK_IdLineaCategoriaProductoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaCategoriaProductoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaGrupoProductoPuntoVenta=true;

	public Boolean getMostrarFK_IdLineaGrupoProductoPuntoVenta() {
		return this.mostrarFK_IdLineaGrupoProductoPuntoVenta;
	}

	public void setMostrarFK_IdLineaGrupoProductoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaGrupoProductoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaMarcaProductoPuntoVenta=true;

	public Boolean getMostrarFK_IdLineaMarcaProductoPuntoVenta() {
		return this.mostrarFK_IdLineaMarcaProductoPuntoVenta;
	}

	public void setMostrarFK_IdLineaMarcaProductoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaMarcaProductoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoProductoPuntoVenta=true;

	public Boolean getMostrarFK_IdProductoProductoPuntoVenta() {
		return this.mostrarFK_IdProductoProductoPuntoVenta;
	}

	public void setMostrarFK_IdProductoProductoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoProductoPuntoVenta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdLineaProductoPuntoVenta=true;

	public Boolean getActivarFK_IdLineaProductoPuntoVenta() {
		return this.activarFK_IdLineaProductoPuntoVenta;
	}

	public void setActivarFK_IdLineaProductoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdLineaProductoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaCategoriaProductoPuntoVenta=true;

	public Boolean getActivarFK_IdLineaCategoriaProductoPuntoVenta() {
		return this.activarFK_IdLineaCategoriaProductoPuntoVenta;
	}

	public void setActivarFK_IdLineaCategoriaProductoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdLineaCategoriaProductoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaGrupoProductoPuntoVenta=true;

	public Boolean getActivarFK_IdLineaGrupoProductoPuntoVenta() {
		return this.activarFK_IdLineaGrupoProductoPuntoVenta;
	}

	public void setActivarFK_IdLineaGrupoProductoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdLineaGrupoProductoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaMarcaProductoPuntoVenta=true;

	public Boolean getActivarFK_IdLineaMarcaProductoPuntoVenta() {
		return this.activarFK_IdLineaMarcaProductoPuntoVenta;
	}

	public void setActivarFK_IdLineaMarcaProductoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdLineaMarcaProductoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoProductoPuntoVenta=true;

	public Boolean getActivarFK_IdProductoProductoPuntoVenta() {
		return this.activarFK_IdProductoProductoPuntoVenta;
	}

	public void setActivarFK_IdProductoProductoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdProductoProductoPuntoVenta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdLineaProductoPuntoVenta=null;

	public Border getResaltarFK_IdLineaProductoPuntoVenta() {
		return this.resaltarFK_IdLineaProductoPuntoVenta;
	}

	public void setResaltarFK_IdLineaProductoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdLineaProductoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdLineaProductoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPuntoVentaBeanSwingJInternalFrame productopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaProductoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdLineaCategoriaProductoPuntoVenta=null;

	public Border getResaltarFK_IdLineaCategoriaProductoPuntoVenta() {
		return this.resaltarFK_IdLineaCategoriaProductoPuntoVenta;
	}

	public void setResaltarFK_IdLineaCategoriaProductoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdLineaCategoriaProductoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdLineaCategoriaProductoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPuntoVentaBeanSwingJInternalFrame productopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaCategoriaProductoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdLineaGrupoProductoPuntoVenta=null;

	public Border getResaltarFK_IdLineaGrupoProductoPuntoVenta() {
		return this.resaltarFK_IdLineaGrupoProductoPuntoVenta;
	}

	public void setResaltarFK_IdLineaGrupoProductoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdLineaGrupoProductoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdLineaGrupoProductoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPuntoVentaBeanSwingJInternalFrame productopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaGrupoProductoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdLineaMarcaProductoPuntoVenta=null;

	public Border getResaltarFK_IdLineaMarcaProductoPuntoVenta() {
		return this.resaltarFK_IdLineaMarcaProductoPuntoVenta;
	}

	public void setResaltarFK_IdLineaMarcaProductoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdLineaMarcaProductoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdLineaMarcaProductoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPuntoVentaBeanSwingJInternalFrame productopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaMarcaProductoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdProductoProductoPuntoVenta=null;

	public Border getResaltarFK_IdProductoProductoPuntoVenta() {
		return this.resaltarFK_IdProductoProductoPuntoVenta;
	}

	public void setResaltarFK_IdProductoProductoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdProductoProductoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdProductoProductoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoPuntoVentaBeanSwingJInternalFrame productopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoProductoPuntoVenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}