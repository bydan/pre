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


import com.bydan.erp.inventario.util.ProductoUnidadConstantesFunciones;
import com.bydan.erp.inventario.util.ProductoUnidadParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ProductoUnidadParameterGeneral;

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
final public class ProductoUnidadConstantesFunciones extends ProductoUnidadConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProductoUnidad";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductoUnidad"+ProductoUnidadConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductoUnidadHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductoUnidadHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductoUnidadConstantesFunciones.SCHEMA+"_"+ProductoUnidadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductoUnidadHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductoUnidadConstantesFunciones.SCHEMA+"_"+ProductoUnidadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductoUnidadConstantesFunciones.SCHEMA+"_"+ProductoUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductoUnidadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductoUnidadConstantesFunciones.SCHEMA+"_"+ProductoUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoUnidadHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoUnidadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductoUnidadConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductoUnidadConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductoUnidadConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductoUnidadConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Producto Unidads";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Producto Unidad";
	public static final String SCLASSWEBTITULO_LOWER="Producto Unidad";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductoUnidad";
	public static final String OBJECTNAME="productounidad";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="producto_unidad";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productounidad from "+ProductoUnidadConstantesFunciones.SPERSISTENCENAME+" productounidad";
	public static String QUERYSELECTNATIVE="select "+ProductoUnidadConstantesFunciones.SCHEMA+"."+ProductoUnidadConstantesFunciones.TABLENAME+".id,"+ProductoUnidadConstantesFunciones.SCHEMA+"."+ProductoUnidadConstantesFunciones.TABLENAME+".version_row,"+ProductoUnidadConstantesFunciones.SCHEMA+"."+ProductoUnidadConstantesFunciones.TABLENAME+".id_empresa,"+ProductoUnidadConstantesFunciones.SCHEMA+"."+ProductoUnidadConstantesFunciones.TABLENAME+".id_sucursal,"+ProductoUnidadConstantesFunciones.SCHEMA+"."+ProductoUnidadConstantesFunciones.TABLENAME+".id_bodega,"+ProductoUnidadConstantesFunciones.SCHEMA+"."+ProductoUnidadConstantesFunciones.TABLENAME+".id_producto,"+ProductoUnidadConstantesFunciones.SCHEMA+"."+ProductoUnidadConstantesFunciones.TABLENAME+".id_unidad,"+ProductoUnidadConstantesFunciones.SCHEMA+"."+ProductoUnidadConstantesFunciones.TABLENAME+".valor_unidad from "+ProductoUnidadConstantesFunciones.SCHEMA+"."+ProductoUnidadConstantesFunciones.TABLENAME;//+" as "+ProductoUnidadConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProductoUnidadConstantesFuncionesAdditional productounidadConstantesFuncionesAdditional=null;
	
	public ProductoUnidadConstantesFuncionesAdditional getProductoUnidadConstantesFuncionesAdditional() {
		return this.productounidadConstantesFuncionesAdditional;
	}
	
	public void setProductoUnidadConstantesFuncionesAdditional(ProductoUnidadConstantesFuncionesAdditional productounidadConstantesFuncionesAdditional) {
		try {
			this.productounidadConstantesFuncionesAdditional=productounidadConstantesFuncionesAdditional;
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
    public static final String VALORUNIDAD= "valor_unidad";
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
    	public static final String LABEL_VALORUNIDAD= "Valor Unidad";
		public static final String LABEL_VALORUNIDAD_LOWER= "Valor Unidad";
	
		
		
		
		
		
		
		
		
	
	public static String getProductoUnidadLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductoUnidadConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProductoUnidadConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProductoUnidadConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProductoUnidadConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProductoUnidadConstantesFunciones.IDBODEGA)) {sLabelColumna=ProductoUnidadConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ProductoUnidadConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProductoUnidadConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProductoUnidadConstantesFunciones.IDUNIDAD)) {sLabelColumna=ProductoUnidadConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(ProductoUnidadConstantesFunciones.VALORUNIDAD)) {sLabelColumna=ProductoUnidadConstantesFunciones.LABEL_VALORUNIDAD;}
		
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
	
	
	
			
			
			
			
			
			
			
			
	
	public static String getProductoUnidadDescripcion(ProductoUnidad productounidad) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productounidad !=null/* && productounidad.getId()!=0*/) {
			if(productounidad.getId()!=null) {
				sDescripcion=productounidad.getId().toString();
			}//productounidadproductounidad.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductoUnidadDescripcionDetallado(ProductoUnidad productounidad) {
		String sDescripcion="";
			
		sDescripcion+=ProductoUnidadConstantesFunciones.ID+"=";
		sDescripcion+=productounidad.getId().toString()+",";
		sDescripcion+=ProductoUnidadConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productounidad.getVersionRow().toString()+",";
		sDescripcion+=ProductoUnidadConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=productounidad.getid_empresa().toString()+",";
		sDescripcion+=ProductoUnidadConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=productounidad.getid_sucursal().toString()+",";
		sDescripcion+=ProductoUnidadConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=productounidad.getid_bodega().toString()+",";
		sDescripcion+=ProductoUnidadConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=productounidad.getid_producto().toString()+",";
		sDescripcion+=ProductoUnidadConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=productounidad.getid_unidad().toString()+",";
		sDescripcion+=ProductoUnidadConstantesFunciones.VALORUNIDAD+"=";
		sDescripcion+=productounidad.getvalor_unidad().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProductoUnidadDescripcion(ProductoUnidad productounidad,String sValor) throws Exception {			
		if(productounidad !=null) {
			//productounidadproductounidad.getId().toString();
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
		} else if(sNombreIndice.equals("FK_IdUnidad")) {
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

	public static String getDetalleIndiceFK_IdUnidad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProductoUnidad(ProductoUnidad productounidad,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProductoUnidads(List<ProductoUnidad> productounidads,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoUnidad productounidad: productounidads) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoUnidad(ProductoUnidad productounidad,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productounidad.getConCambioAuxiliar()) {
			productounidad.setIsDeleted(productounidad.getIsDeletedAuxiliar());	
			productounidad.setIsNew(productounidad.getIsNewAuxiliar());	
			productounidad.setIsChanged(productounidad.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productounidad.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productounidad.setIsDeletedAuxiliar(false);	
			productounidad.setIsNewAuxiliar(false);	
			productounidad.setIsChangedAuxiliar(false);
			
			productounidad.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoUnidads(List<ProductoUnidad> productounidads,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductoUnidad productounidad : productounidads) {
			if(conAsignarBase && productounidad.getConCambioAuxiliar()) {
				productounidad.setIsDeleted(productounidad.getIsDeletedAuxiliar());	
				productounidad.setIsNew(productounidad.getIsNewAuxiliar());	
				productounidad.setIsChanged(productounidad.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productounidad.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productounidad.setIsDeletedAuxiliar(false);	
				productounidad.setIsNewAuxiliar(false);	
				productounidad.setIsChangedAuxiliar(false);
				
				productounidad.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductoUnidad(ProductoUnidad productounidad,Boolean conEnteros) throws Exception  {
		productounidad.setvalor_unidad(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProductoUnidads(List<ProductoUnidad> productounidads,Boolean conEnteros) throws Exception  {
		
		for(ProductoUnidad productounidad: productounidads) {
			productounidad.setvalor_unidad(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductoUnidad(List<ProductoUnidad> productounidads,ProductoUnidad productounidadAux) throws Exception  {
		ProductoUnidadConstantesFunciones.InicializarValoresProductoUnidad(productounidadAux,true);
		
		for(ProductoUnidad productounidad: productounidads) {
			if(productounidad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productounidadAux.setvalor_unidad(productounidadAux.getvalor_unidad()+productounidad.getvalor_unidad());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoUnidad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductoUnidadConstantesFunciones.getArrayColumnasGlobalesProductoUnidad(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoUnidad(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductoUnidadConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductoUnidadConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductoUnidadConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductoUnidadConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductoUnidad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoUnidad> productounidads,ProductoUnidad productounidad,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoUnidad productounidadAux: productounidads) {
			if(productounidadAux!=null && productounidad!=null) {
				if((productounidadAux.getId()==null && productounidad.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productounidadAux.getId()!=null && productounidad.getId()!=null){
					if(productounidadAux.getId().equals(productounidad.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoUnidad(List<ProductoUnidad> productounidads) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_unidadTotal=0.0;
	
		for(ProductoUnidad productounidad: productounidads) {			
			if(productounidad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_unidadTotal+=productounidad.getvalor_unidad();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoUnidadConstantesFunciones.VALORUNIDAD);
		datoGeneral.setsDescripcion(ProductoUnidadConstantesFunciones.LABEL_VALORUNIDAD);
		datoGeneral.setdValorDouble(valor_unidadTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductoUnidad() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductoUnidadConstantesFunciones.LABEL_ID, ProductoUnidadConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoUnidadConstantesFunciones.LABEL_VERSIONROW, ProductoUnidadConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoUnidadConstantesFunciones.LABEL_IDEMPRESA, ProductoUnidadConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoUnidadConstantesFunciones.LABEL_IDSUCURSAL, ProductoUnidadConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoUnidadConstantesFunciones.LABEL_IDBODEGA, ProductoUnidadConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoUnidadConstantesFunciones.LABEL_IDPRODUCTO, ProductoUnidadConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoUnidadConstantesFunciones.LABEL_IDUNIDAD, ProductoUnidadConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoUnidadConstantesFunciones.LABEL_VALORUNIDAD, ProductoUnidadConstantesFunciones.VALORUNIDAD,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductoUnidad() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductoUnidadConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoUnidadConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoUnidadConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoUnidadConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoUnidadConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoUnidadConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoUnidadConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoUnidadConstantesFunciones.VALORUNIDAD;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoUnidad() throws Exception  {
		return ProductoUnidadConstantesFunciones.getTiposSeleccionarProductoUnidad(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoUnidad(Boolean conFk) throws Exception  {
		return ProductoUnidadConstantesFunciones.getTiposSeleccionarProductoUnidad(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoUnidad(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoUnidadConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProductoUnidadConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoUnidadConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProductoUnidadConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoUnidadConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ProductoUnidadConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoUnidadConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProductoUnidadConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoUnidadConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(ProductoUnidadConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoUnidadConstantesFunciones.LABEL_VALORUNIDAD);
			reporte.setsDescripcion(ProductoUnidadConstantesFunciones.LABEL_VALORUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductoUnidad(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductoUnidad(ProductoUnidad productounidadAux) throws Exception {
		
			productounidadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productounidadAux.getEmpresa()));
			productounidadAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productounidadAux.getSucursal()));
			productounidadAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productounidadAux.getBodega()));
			productounidadAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productounidadAux.getProducto()));
			productounidadAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productounidadAux.getUnidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductoUnidad(List<ProductoUnidad> productounidadsTemp) throws Exception {
		for(ProductoUnidad productounidadAux:productounidadsTemp) {
			
			productounidadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productounidadAux.getEmpresa()));
			productounidadAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productounidadAux.getSucursal()));
			productounidadAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productounidadAux.getBodega()));
			productounidadAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productounidadAux.getProducto()));
			productounidadAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productounidadAux.getUnidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductoUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductoUnidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoUnidadConstantesFunciones.getClassesRelationshipsOfProductoUnidad(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoUnidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoUnidadConstantesFunciones.getClassesRelationshipsFromStringsOfProductoUnidad(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoUnidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductoUnidad productounidad,List<ProductoUnidad> productounidads,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProductoUnidad productounidadEncontrado=null;
			
			for(ProductoUnidad productounidadLocal:productounidads) {
				if(productounidadLocal.getId().equals(productounidad.getId())) {
					productounidadEncontrado=productounidadLocal;
					
					productounidadLocal.setIsChanged(productounidad.getIsChanged());
					productounidadLocal.setIsNew(productounidad.getIsNew());
					productounidadLocal.setIsDeleted(productounidad.getIsDeleted());
					
					productounidadLocal.setGeneralEntityOriginal(productounidad.getGeneralEntityOriginal());
					
					productounidadLocal.setId(productounidad.getId());	
					productounidadLocal.setVersionRow(productounidad.getVersionRow());	
					productounidadLocal.setid_empresa(productounidad.getid_empresa());	
					productounidadLocal.setid_sucursal(productounidad.getid_sucursal());	
					productounidadLocal.setid_bodega(productounidad.getid_bodega());	
					productounidadLocal.setid_producto(productounidad.getid_producto());	
					productounidadLocal.setid_unidad(productounidad.getid_unidad());	
					productounidadLocal.setvalor_unidad(productounidad.getvalor_unidad());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!productounidad.getIsDeleted()) {
				if(!existe) {
					productounidads.add(productounidad);
				}
			} else {
				if(productounidadEncontrado!=null && permiteQuitar)  {
					productounidads.remove(productounidadEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProductoUnidad productounidad,List<ProductoUnidad> productounidads) throws Exception {
		try	{			
			for(ProductoUnidad productounidadLocal:productounidads) {
				if(productounidadLocal.getId().equals(productounidad.getId())) {
					productounidadLocal.setIsSelected(productounidad.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductoUnidad(List<ProductoUnidad> productounidadsAux) throws Exception {
		//this.productounidadsAux=productounidadsAux;
		
		for(ProductoUnidad productounidadAux:productounidadsAux) {
			if(productounidadAux.getIsChanged()) {
				productounidadAux.setIsChanged(false);
			}		
			
			if(productounidadAux.getIsNew()) {
				productounidadAux.setIsNew(false);
			}	
			
			if(productounidadAux.getIsDeleted()) {
				productounidadAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductoUnidad(ProductoUnidad productounidadAux) throws Exception {
		//this.productounidadAux=productounidadAux;
		
			if(productounidadAux.getIsChanged()) {
				productounidadAux.setIsChanged(false);
			}		
			
			if(productounidadAux.getIsNew()) {
				productounidadAux.setIsNew(false);
			}	
			
			if(productounidadAux.getIsDeleted()) {
				productounidadAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductoUnidad productounidadAsignar,ProductoUnidad productounidad) throws Exception {
		productounidadAsignar.setId(productounidad.getId());	
		productounidadAsignar.setVersionRow(productounidad.getVersionRow());	
		productounidadAsignar.setid_empresa(productounidad.getid_empresa());
		productounidadAsignar.setempresa_descripcion(productounidad.getempresa_descripcion());	
		productounidadAsignar.setid_sucursal(productounidad.getid_sucursal());
		productounidadAsignar.setsucursal_descripcion(productounidad.getsucursal_descripcion());	
		productounidadAsignar.setid_bodega(productounidad.getid_bodega());
		productounidadAsignar.setbodega_descripcion(productounidad.getbodega_descripcion());	
		productounidadAsignar.setid_producto(productounidad.getid_producto());
		productounidadAsignar.setproducto_descripcion(productounidad.getproducto_descripcion());	
		productounidadAsignar.setid_unidad(productounidad.getid_unidad());
		productounidadAsignar.setunidad_descripcion(productounidad.getunidad_descripcion());	
		productounidadAsignar.setvalor_unidad(productounidad.getvalor_unidad());	
	}
	
	public static void inicializarProductoUnidad(ProductoUnidad productounidad) throws Exception {
		try {
				productounidad.setId(0L);	
					
				productounidad.setid_empresa(-1L);	
				productounidad.setid_sucursal(-1L);	
				productounidad.setid_bodega(-1L);	
				productounidad.setid_producto(-1L);	
				productounidad.setid_unidad(-1L);	
				productounidad.setvalor_unidad(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductoUnidad(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoUnidadConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoUnidadConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoUnidadConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoUnidadConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoUnidadConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoUnidadConstantesFunciones.LABEL_VALORUNIDAD);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductoUnidad(String sTipo,Row row,Workbook workbook,ProductoUnidad productounidad,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productounidad.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productounidad.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productounidad.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productounidad.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productounidad.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productounidad.getvalor_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductoUnidad=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProductoUnidad() {
		return this.sFinalQueryProductoUnidad;
	}
	
	public void setsFinalQueryProductoUnidad(String sFinalQueryProductoUnidad) {
		this.sFinalQueryProductoUnidad= sFinalQueryProductoUnidad;
	}
	
	public Border resaltarSeleccionarProductoUnidad=null;
	
	public Border setResaltarSeleccionarProductoUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoUnidadBeanSwingJInternalFrame productounidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productounidadBeanSwingJInternalFrame.jTtoolBarProductoUnidad.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductoUnidad= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductoUnidad() {
		return this.resaltarSeleccionarProductoUnidad;
	}
	
	public void setResaltarSeleccionarProductoUnidad(Border borderResaltarSeleccionarProductoUnidad) {
		this.resaltarSeleccionarProductoUnidad= borderResaltarSeleccionarProductoUnidad;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductoUnidad=null;
	public Boolean mostraridProductoUnidad=true;
	public Boolean activaridProductoUnidad=true;

	public Border resaltarid_empresaProductoUnidad=null;
	public Boolean mostrarid_empresaProductoUnidad=true;
	public Boolean activarid_empresaProductoUnidad=true;
	public Boolean cargarid_empresaProductoUnidad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProductoUnidad=false;//ConEventDepend=true

	public Border resaltarid_sucursalProductoUnidad=null;
	public Boolean mostrarid_sucursalProductoUnidad=true;
	public Boolean activarid_sucursalProductoUnidad=true;
	public Boolean cargarid_sucursalProductoUnidad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProductoUnidad=false;//ConEventDepend=true

	public Border resaltarid_bodegaProductoUnidad=null;
	public Boolean mostrarid_bodegaProductoUnidad=true;
	public Boolean activarid_bodegaProductoUnidad=true;
	public Boolean cargarid_bodegaProductoUnidad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaProductoUnidad=false;//ConEventDepend=true

	public Border resaltarid_productoProductoUnidad=null;
	public Boolean mostrarid_productoProductoUnidad=true;
	public Boolean activarid_productoProductoUnidad=true;
	public Boolean cargarid_productoProductoUnidad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProductoUnidad=true;//ConEventDepend=true

	public Border resaltarid_unidadProductoUnidad=null;
	public Boolean mostrarid_unidadProductoUnidad=true;
	public Boolean activarid_unidadProductoUnidad=true;
	public Boolean cargarid_unidadProductoUnidad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadProductoUnidad=true;//ConEventDepend=true

	public Border resaltarvalor_unidadProductoUnidad=null;
	public Boolean mostrarvalor_unidadProductoUnidad=true;
	public Boolean activarvalor_unidadProductoUnidad=true;

	
	

	public Border setResaltaridProductoUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoUnidadBeanSwingJInternalFrame productounidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productounidadBeanSwingJInternalFrame.jTtoolBarProductoUnidad.setBorder(borderResaltar);
		
		this.resaltaridProductoUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductoUnidad() {
		return this.resaltaridProductoUnidad;
	}

	public void setResaltaridProductoUnidad(Border borderResaltar) {
		this.resaltaridProductoUnidad= borderResaltar;
	}

	public Boolean getMostraridProductoUnidad() {
		return this.mostraridProductoUnidad;
	}

	public void setMostraridProductoUnidad(Boolean mostraridProductoUnidad) {
		this.mostraridProductoUnidad= mostraridProductoUnidad;
	}

	public Boolean getActivaridProductoUnidad() {
		return this.activaridProductoUnidad;
	}

	public void setActivaridProductoUnidad(Boolean activaridProductoUnidad) {
		this.activaridProductoUnidad= activaridProductoUnidad;
	}

	public Border setResaltarid_empresaProductoUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoUnidadBeanSwingJInternalFrame productounidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productounidadBeanSwingJInternalFrame.jTtoolBarProductoUnidad.setBorder(borderResaltar);
		
		this.resaltarid_empresaProductoUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProductoUnidad() {
		return this.resaltarid_empresaProductoUnidad;
	}

	public void setResaltarid_empresaProductoUnidad(Border borderResaltar) {
		this.resaltarid_empresaProductoUnidad= borderResaltar;
	}

	public Boolean getMostrarid_empresaProductoUnidad() {
		return this.mostrarid_empresaProductoUnidad;
	}

	public void setMostrarid_empresaProductoUnidad(Boolean mostrarid_empresaProductoUnidad) {
		this.mostrarid_empresaProductoUnidad= mostrarid_empresaProductoUnidad;
	}

	public Boolean getActivarid_empresaProductoUnidad() {
		return this.activarid_empresaProductoUnidad;
	}

	public void setActivarid_empresaProductoUnidad(Boolean activarid_empresaProductoUnidad) {
		this.activarid_empresaProductoUnidad= activarid_empresaProductoUnidad;
	}

	public Boolean getCargarid_empresaProductoUnidad() {
		return this.cargarid_empresaProductoUnidad;
	}

	public void setCargarid_empresaProductoUnidad(Boolean cargarid_empresaProductoUnidad) {
		this.cargarid_empresaProductoUnidad= cargarid_empresaProductoUnidad;
	}

	public Border setResaltarid_sucursalProductoUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoUnidadBeanSwingJInternalFrame productounidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productounidadBeanSwingJInternalFrame.jTtoolBarProductoUnidad.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProductoUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProductoUnidad() {
		return this.resaltarid_sucursalProductoUnidad;
	}

	public void setResaltarid_sucursalProductoUnidad(Border borderResaltar) {
		this.resaltarid_sucursalProductoUnidad= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProductoUnidad() {
		return this.mostrarid_sucursalProductoUnidad;
	}

	public void setMostrarid_sucursalProductoUnidad(Boolean mostrarid_sucursalProductoUnidad) {
		this.mostrarid_sucursalProductoUnidad= mostrarid_sucursalProductoUnidad;
	}

	public Boolean getActivarid_sucursalProductoUnidad() {
		return this.activarid_sucursalProductoUnidad;
	}

	public void setActivarid_sucursalProductoUnidad(Boolean activarid_sucursalProductoUnidad) {
		this.activarid_sucursalProductoUnidad= activarid_sucursalProductoUnidad;
	}

	public Boolean getCargarid_sucursalProductoUnidad() {
		return this.cargarid_sucursalProductoUnidad;
	}

	public void setCargarid_sucursalProductoUnidad(Boolean cargarid_sucursalProductoUnidad) {
		this.cargarid_sucursalProductoUnidad= cargarid_sucursalProductoUnidad;
	}

	public Border setResaltarid_bodegaProductoUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoUnidadBeanSwingJInternalFrame productounidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productounidadBeanSwingJInternalFrame.jTtoolBarProductoUnidad.setBorder(borderResaltar);
		
		this.resaltarid_bodegaProductoUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaProductoUnidad() {
		return this.resaltarid_bodegaProductoUnidad;
	}

	public void setResaltarid_bodegaProductoUnidad(Border borderResaltar) {
		this.resaltarid_bodegaProductoUnidad= borderResaltar;
	}

	public Boolean getMostrarid_bodegaProductoUnidad() {
		return this.mostrarid_bodegaProductoUnidad;
	}

	public void setMostrarid_bodegaProductoUnidad(Boolean mostrarid_bodegaProductoUnidad) {
		this.mostrarid_bodegaProductoUnidad= mostrarid_bodegaProductoUnidad;
	}

	public Boolean getActivarid_bodegaProductoUnidad() {
		return this.activarid_bodegaProductoUnidad;
	}

	public void setActivarid_bodegaProductoUnidad(Boolean activarid_bodegaProductoUnidad) {
		this.activarid_bodegaProductoUnidad= activarid_bodegaProductoUnidad;
	}

	public Boolean getCargarid_bodegaProductoUnidad() {
		return this.cargarid_bodegaProductoUnidad;
	}

	public void setCargarid_bodegaProductoUnidad(Boolean cargarid_bodegaProductoUnidad) {
		this.cargarid_bodegaProductoUnidad= cargarid_bodegaProductoUnidad;
	}

	public Border setResaltarid_productoProductoUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoUnidadBeanSwingJInternalFrame productounidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productounidadBeanSwingJInternalFrame.jTtoolBarProductoUnidad.setBorder(borderResaltar);
		
		this.resaltarid_productoProductoUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProductoUnidad() {
		return this.resaltarid_productoProductoUnidad;
	}

	public void setResaltarid_productoProductoUnidad(Border borderResaltar) {
		this.resaltarid_productoProductoUnidad= borderResaltar;
	}

	public Boolean getMostrarid_productoProductoUnidad() {
		return this.mostrarid_productoProductoUnidad;
	}

	public void setMostrarid_productoProductoUnidad(Boolean mostrarid_productoProductoUnidad) {
		this.mostrarid_productoProductoUnidad= mostrarid_productoProductoUnidad;
	}

	public Boolean getActivarid_productoProductoUnidad() {
		return this.activarid_productoProductoUnidad;
	}

	public void setActivarid_productoProductoUnidad(Boolean activarid_productoProductoUnidad) {
		this.activarid_productoProductoUnidad= activarid_productoProductoUnidad;
	}

	public Boolean getCargarid_productoProductoUnidad() {
		return this.cargarid_productoProductoUnidad;
	}

	public void setCargarid_productoProductoUnidad(Boolean cargarid_productoProductoUnidad) {
		this.cargarid_productoProductoUnidad= cargarid_productoProductoUnidad;
	}

	public Border setResaltarid_unidadProductoUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoUnidadBeanSwingJInternalFrame productounidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productounidadBeanSwingJInternalFrame.jTtoolBarProductoUnidad.setBorder(borderResaltar);
		
		this.resaltarid_unidadProductoUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadProductoUnidad() {
		return this.resaltarid_unidadProductoUnidad;
	}

	public void setResaltarid_unidadProductoUnidad(Border borderResaltar) {
		this.resaltarid_unidadProductoUnidad= borderResaltar;
	}

	public Boolean getMostrarid_unidadProductoUnidad() {
		return this.mostrarid_unidadProductoUnidad;
	}

	public void setMostrarid_unidadProductoUnidad(Boolean mostrarid_unidadProductoUnidad) {
		this.mostrarid_unidadProductoUnidad= mostrarid_unidadProductoUnidad;
	}

	public Boolean getActivarid_unidadProductoUnidad() {
		return this.activarid_unidadProductoUnidad;
	}

	public void setActivarid_unidadProductoUnidad(Boolean activarid_unidadProductoUnidad) {
		this.activarid_unidadProductoUnidad= activarid_unidadProductoUnidad;
	}

	public Boolean getCargarid_unidadProductoUnidad() {
		return this.cargarid_unidadProductoUnidad;
	}

	public void setCargarid_unidadProductoUnidad(Boolean cargarid_unidadProductoUnidad) {
		this.cargarid_unidadProductoUnidad= cargarid_unidadProductoUnidad;
	}

	public Border setResaltarvalor_unidadProductoUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoUnidadBeanSwingJInternalFrame productounidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productounidadBeanSwingJInternalFrame.jTtoolBarProductoUnidad.setBorder(borderResaltar);
		
		this.resaltarvalor_unidadProductoUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_unidadProductoUnidad() {
		return this.resaltarvalor_unidadProductoUnidad;
	}

	public void setResaltarvalor_unidadProductoUnidad(Border borderResaltar) {
		this.resaltarvalor_unidadProductoUnidad= borderResaltar;
	}

	public Boolean getMostrarvalor_unidadProductoUnidad() {
		return this.mostrarvalor_unidadProductoUnidad;
	}

	public void setMostrarvalor_unidadProductoUnidad(Boolean mostrarvalor_unidadProductoUnidad) {
		this.mostrarvalor_unidadProductoUnidad= mostrarvalor_unidadProductoUnidad;
	}

	public Boolean getActivarvalor_unidadProductoUnidad() {
		return this.activarvalor_unidadProductoUnidad;
	}

	public void setActivarvalor_unidadProductoUnidad(Boolean activarvalor_unidadProductoUnidad) {
		this.activarvalor_unidadProductoUnidad= activarvalor_unidadProductoUnidad;
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
		
		
		this.setMostraridProductoUnidad(esInicial);
		this.setMostrarid_empresaProductoUnidad(esInicial);
		this.setMostrarid_sucursalProductoUnidad(esInicial);
		this.setMostrarid_bodegaProductoUnidad(esInicial);
		this.setMostrarid_productoProductoUnidad(esInicial);
		this.setMostrarid_unidadProductoUnidad(esInicial);
		this.setMostrarvalor_unidadProductoUnidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoUnidadConstantesFunciones.ID)) {
				this.setMostraridProductoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoUnidadConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProductoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoUnidadConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProductoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoUnidadConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaProductoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoUnidadConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProductoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoUnidadConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadProductoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoUnidadConstantesFunciones.VALORUNIDAD)) {
				this.setMostrarvalor_unidadProductoUnidad(esAsigna);
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
		
		
		this.setActivaridProductoUnidad(esInicial);
		this.setActivarid_empresaProductoUnidad(esInicial);
		this.setActivarid_sucursalProductoUnidad(esInicial);
		this.setActivarid_bodegaProductoUnidad(esInicial);
		this.setActivarid_productoProductoUnidad(esInicial);
		this.setActivarid_unidadProductoUnidad(esInicial);
		this.setActivarvalor_unidadProductoUnidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoUnidadConstantesFunciones.ID)) {
				this.setActivaridProductoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoUnidadConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProductoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoUnidadConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProductoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoUnidadConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaProductoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoUnidadConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProductoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoUnidadConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadProductoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoUnidadConstantesFunciones.VALORUNIDAD)) {
				this.setActivarvalor_unidadProductoUnidad(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoUnidadBeanSwingJInternalFrame productounidadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductoUnidad(esInicial);
		this.setResaltarid_empresaProductoUnidad(esInicial);
		this.setResaltarid_sucursalProductoUnidad(esInicial);
		this.setResaltarid_bodegaProductoUnidad(esInicial);
		this.setResaltarid_productoProductoUnidad(esInicial);
		this.setResaltarid_unidadProductoUnidad(esInicial);
		this.setResaltarvalor_unidadProductoUnidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoUnidadConstantesFunciones.ID)) {
				this.setResaltaridProductoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoUnidadConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProductoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoUnidadConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProductoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoUnidadConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaProductoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoUnidadConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProductoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoUnidadConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadProductoUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoUnidadConstantesFunciones.VALORUNIDAD)) {
				this.setResaltarvalor_unidadProductoUnidad(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoUnidadBeanSwingJInternalFrame productounidadBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaProductoUnidad=true;

	public Boolean getMostrarFK_IdBodegaProductoUnidad() {
		return this.mostrarFK_IdBodegaProductoUnidad;
	}

	public void setMostrarFK_IdBodegaProductoUnidad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaProductoUnidad= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaProductoUnidad=true;

	public Boolean getMostrarFK_IdEmpresaProductoUnidad() {
		return this.mostrarFK_IdEmpresaProductoUnidad;
	}

	public void setMostrarFK_IdEmpresaProductoUnidad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaProductoUnidad= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoProductoUnidad=true;

	public Boolean getMostrarFK_IdProductoProductoUnidad() {
		return this.mostrarFK_IdProductoProductoUnidad;
	}

	public void setMostrarFK_IdProductoProductoUnidad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoProductoUnidad= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalProductoUnidad=true;

	public Boolean getMostrarFK_IdSucursalProductoUnidad() {
		return this.mostrarFK_IdSucursalProductoUnidad;
	}

	public void setMostrarFK_IdSucursalProductoUnidad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalProductoUnidad= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadProductoUnidad=true;

	public Boolean getMostrarFK_IdUnidadProductoUnidad() {
		return this.mostrarFK_IdUnidadProductoUnidad;
	}

	public void setMostrarFK_IdUnidadProductoUnidad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadProductoUnidad= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaProductoUnidad=true;

	public Boolean getActivarFK_IdBodegaProductoUnidad() {
		return this.activarFK_IdBodegaProductoUnidad;
	}

	public void setActivarFK_IdBodegaProductoUnidad(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaProductoUnidad= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaProductoUnidad=true;

	public Boolean getActivarFK_IdEmpresaProductoUnidad() {
		return this.activarFK_IdEmpresaProductoUnidad;
	}

	public void setActivarFK_IdEmpresaProductoUnidad(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaProductoUnidad= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoProductoUnidad=true;

	public Boolean getActivarFK_IdProductoProductoUnidad() {
		return this.activarFK_IdProductoProductoUnidad;
	}

	public void setActivarFK_IdProductoProductoUnidad(Boolean habilitarResaltar) {
		this.activarFK_IdProductoProductoUnidad= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalProductoUnidad=true;

	public Boolean getActivarFK_IdSucursalProductoUnidad() {
		return this.activarFK_IdSucursalProductoUnidad;
	}

	public void setActivarFK_IdSucursalProductoUnidad(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalProductoUnidad= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadProductoUnidad=true;

	public Boolean getActivarFK_IdUnidadProductoUnidad() {
		return this.activarFK_IdUnidadProductoUnidad;
	}

	public void setActivarFK_IdUnidadProductoUnidad(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadProductoUnidad= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaProductoUnidad=null;

	public Border getResaltarFK_IdBodegaProductoUnidad() {
		return this.resaltarFK_IdBodegaProductoUnidad;
	}

	public void setResaltarFK_IdBodegaProductoUnidad(Border borderResaltar) {
		this.resaltarFK_IdBodegaProductoUnidad= borderResaltar;
	}

	public void setResaltarFK_IdBodegaProductoUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoUnidadBeanSwingJInternalFrame productounidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaProductoUnidad= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaProductoUnidad=null;

	public Border getResaltarFK_IdEmpresaProductoUnidad() {
		return this.resaltarFK_IdEmpresaProductoUnidad;
	}

	public void setResaltarFK_IdEmpresaProductoUnidad(Border borderResaltar) {
		this.resaltarFK_IdEmpresaProductoUnidad= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaProductoUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoUnidadBeanSwingJInternalFrame productounidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaProductoUnidad= borderResaltar;
	}

	public Border resaltarFK_IdProductoProductoUnidad=null;

	public Border getResaltarFK_IdProductoProductoUnidad() {
		return this.resaltarFK_IdProductoProductoUnidad;
	}

	public void setResaltarFK_IdProductoProductoUnidad(Border borderResaltar) {
		this.resaltarFK_IdProductoProductoUnidad= borderResaltar;
	}

	public void setResaltarFK_IdProductoProductoUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoUnidadBeanSwingJInternalFrame productounidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoProductoUnidad= borderResaltar;
	}

	public Border resaltarFK_IdSucursalProductoUnidad=null;

	public Border getResaltarFK_IdSucursalProductoUnidad() {
		return this.resaltarFK_IdSucursalProductoUnidad;
	}

	public void setResaltarFK_IdSucursalProductoUnidad(Border borderResaltar) {
		this.resaltarFK_IdSucursalProductoUnidad= borderResaltar;
	}

	public void setResaltarFK_IdSucursalProductoUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoUnidadBeanSwingJInternalFrame productounidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalProductoUnidad= borderResaltar;
	}

	public Border resaltarFK_IdUnidadProductoUnidad=null;

	public Border getResaltarFK_IdUnidadProductoUnidad() {
		return this.resaltarFK_IdUnidadProductoUnidad;
	}

	public void setResaltarFK_IdUnidadProductoUnidad(Border borderResaltar) {
		this.resaltarFK_IdUnidadProductoUnidad= borderResaltar;
	}

	public void setResaltarFK_IdUnidadProductoUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoUnidadBeanSwingJInternalFrame productounidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadProductoUnidad= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}