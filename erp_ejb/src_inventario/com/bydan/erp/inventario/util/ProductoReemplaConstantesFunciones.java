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


import com.bydan.erp.inventario.util.ProductoReemplaConstantesFunciones;
import com.bydan.erp.inventario.util.ProductoReemplaParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ProductoReemplaParameterGeneral;

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
final public class ProductoReemplaConstantesFunciones extends ProductoReemplaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProductoReempla";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductoReempla"+ProductoReemplaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductoReemplaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductoReemplaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductoReemplaConstantesFunciones.SCHEMA+"_"+ProductoReemplaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductoReemplaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductoReemplaConstantesFunciones.SCHEMA+"_"+ProductoReemplaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductoReemplaConstantesFunciones.SCHEMA+"_"+ProductoReemplaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductoReemplaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductoReemplaConstantesFunciones.SCHEMA+"_"+ProductoReemplaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoReemplaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoReemplaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoReemplaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoReemplaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoReemplaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoReemplaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductoReemplaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductoReemplaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductoReemplaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductoReemplaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Reemplazos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Reemplazo";
	public static final String SCLASSWEBTITULO_LOWER="Producto Reempla";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductoReempla";
	public static final String OBJECTNAME="productoreempla";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="producto_reempla";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productoreempla from "+ProductoReemplaConstantesFunciones.SPERSISTENCENAME+" productoreempla";
	public static String QUERYSELECTNATIVE="select "+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME+".id,"+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME+".version_row,"+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME+".id_empresa,"+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME+".id_sucursal,"+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME+".id_bodega,"+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME+".id_producto,"+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME+".id_producto_reempla,"+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME+".descripcion from "+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME;//+" as "+ProductoReemplaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProductoReemplaConstantesFuncionesAdditional productoreemplaConstantesFuncionesAdditional=null;
	
	public ProductoReemplaConstantesFuncionesAdditional getProductoReemplaConstantesFuncionesAdditional() {
		return this.productoreemplaConstantesFuncionesAdditional;
	}
	
	public void setProductoReemplaConstantesFuncionesAdditional(ProductoReemplaConstantesFuncionesAdditional productoreemplaConstantesFuncionesAdditional) {
		try {
			this.productoreemplaConstantesFuncionesAdditional=productoreemplaConstantesFuncionesAdditional;
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
    public static final String IDPRODUCTOREEMPLA= "id_producto_reempla";
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
    	public static final String LABEL_IDPRODUCTOREEMPLA= "Producto Reempla";
		public static final String LABEL_IDPRODUCTOREEMPLA_LOWER= "Producto Reempla";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProductoReemplaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductoReemplaConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProductoReemplaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProductoReemplaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProductoReemplaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProductoReemplaConstantesFunciones.IDBODEGA)) {sLabelColumna=ProductoReemplaConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ProductoReemplaConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProductoReemplaConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProductoReemplaConstantesFunciones.IDPRODUCTOREEMPLA)) {sLabelColumna=ProductoReemplaConstantesFunciones.LABEL_IDPRODUCTOREEMPLA;}
		if(sNombreColumna.equals(ProductoReemplaConstantesFunciones.DESCRIPCION)) {sLabelColumna=ProductoReemplaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
	
	public static String getProductoReemplaDescripcion(ProductoReempla productoreempla) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productoreempla !=null/* && productoreempla.getId()!=0*/) {
			if(productoreempla.getId()!=null) {
				sDescripcion=productoreempla.getId().toString();
			}//productoreemplaproductoreempla.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductoReemplaDescripcionDetallado(ProductoReempla productoreempla) {
		String sDescripcion="";
			
		sDescripcion+=ProductoReemplaConstantesFunciones.ID+"=";
		sDescripcion+=productoreempla.getId().toString()+",";
		sDescripcion+=ProductoReemplaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productoreempla.getVersionRow().toString()+",";
		sDescripcion+=ProductoReemplaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=productoreempla.getid_empresa().toString()+",";
		sDescripcion+=ProductoReemplaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=productoreempla.getid_sucursal().toString()+",";
		sDescripcion+=ProductoReemplaConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=productoreempla.getid_bodega().toString()+",";
		sDescripcion+=ProductoReemplaConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=productoreempla.getid_producto().toString()+",";
		sDescripcion+=ProductoReemplaConstantesFunciones.IDPRODUCTOREEMPLA+"=";
		sDescripcion+=productoreempla.getid_producto_reempla().toString()+",";
		sDescripcion+=ProductoReemplaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=productoreempla.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setProductoReemplaDescripcion(ProductoReempla productoreempla,String sValor) throws Exception {			
		if(productoreempla !=null) {
			//productoreemplaproductoreempla.getId().toString();
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
		} else if(sNombreIndice.equals("FK_IdProductoReempla")) {
			sNombreIndice="Tipo=  Por Producto Reempla";
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

	public static String getDetalleIndiceFK_IdProductoReempla(Long id_producto_reempla) {
		String sDetalleIndice=" Parametros->";
		if(id_producto_reempla!=null) {sDetalleIndice+=" Codigo Unico De Producto Reempla="+id_producto_reempla.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProductoReempla(ProductoReempla productoreempla,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productoreempla.setdescripcion(productoreempla.getdescripcion().trim());
	}
	
	public static void quitarEspaciosProductoReemplas(List<ProductoReempla> productoreemplas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoReempla productoreempla: productoreemplas) {
			productoreempla.setdescripcion(productoreempla.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoReempla(ProductoReempla productoreempla,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productoreempla.getConCambioAuxiliar()) {
			productoreempla.setIsDeleted(productoreempla.getIsDeletedAuxiliar());	
			productoreempla.setIsNew(productoreempla.getIsNewAuxiliar());	
			productoreempla.setIsChanged(productoreempla.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productoreempla.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productoreempla.setIsDeletedAuxiliar(false);	
			productoreempla.setIsNewAuxiliar(false);	
			productoreempla.setIsChangedAuxiliar(false);
			
			productoreempla.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoReemplas(List<ProductoReempla> productoreemplas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductoReempla productoreempla : productoreemplas) {
			if(conAsignarBase && productoreempla.getConCambioAuxiliar()) {
				productoreempla.setIsDeleted(productoreempla.getIsDeletedAuxiliar());	
				productoreempla.setIsNew(productoreempla.getIsNewAuxiliar());	
				productoreempla.setIsChanged(productoreempla.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productoreempla.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productoreempla.setIsDeletedAuxiliar(false);	
				productoreempla.setIsNewAuxiliar(false);	
				productoreempla.setIsChangedAuxiliar(false);
				
				productoreempla.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductoReempla(ProductoReempla productoreempla,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProductoReemplas(List<ProductoReempla> productoreemplas,Boolean conEnteros) throws Exception  {
		
		for(ProductoReempla productoreempla: productoreemplas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductoReempla(List<ProductoReempla> productoreemplas,ProductoReempla productoreemplaAux) throws Exception  {
		ProductoReemplaConstantesFunciones.InicializarValoresProductoReempla(productoreemplaAux,true);
		
		for(ProductoReempla productoreempla: productoreemplas) {
			if(productoreempla.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoReempla(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductoReemplaConstantesFunciones.getArrayColumnasGlobalesProductoReempla(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoReempla(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductoReemplaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductoReemplaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductoReemplaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductoReemplaConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductoReempla(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoReempla> productoreemplas,ProductoReempla productoreempla,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoReempla productoreemplaAux: productoreemplas) {
			if(productoreemplaAux!=null && productoreempla!=null) {
				if((productoreemplaAux.getId()==null && productoreempla.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productoreemplaAux.getId()!=null && productoreempla.getId()!=null){
					if(productoreemplaAux.getId().equals(productoreempla.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoReempla(List<ProductoReempla> productoreemplas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProductoReempla productoreempla: productoreemplas) {			
			if(productoreempla.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductoReempla() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductoReemplaConstantesFunciones.LABEL_ID, ProductoReemplaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoReemplaConstantesFunciones.LABEL_VERSIONROW, ProductoReemplaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoReemplaConstantesFunciones.LABEL_IDEMPRESA, ProductoReemplaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoReemplaConstantesFunciones.LABEL_IDSUCURSAL, ProductoReemplaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoReemplaConstantesFunciones.LABEL_IDBODEGA, ProductoReemplaConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoReemplaConstantesFunciones.LABEL_IDPRODUCTO, ProductoReemplaConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoReemplaConstantesFunciones.LABEL_IDPRODUCTOREEMPLA, ProductoReemplaConstantesFunciones.IDPRODUCTOREEMPLA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoReemplaConstantesFunciones.LABEL_DESCRIPCION, ProductoReemplaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductoReempla() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductoReemplaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoReemplaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoReemplaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoReemplaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoReemplaConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoReemplaConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoReemplaConstantesFunciones.IDPRODUCTOREEMPLA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoReemplaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoReempla() throws Exception  {
		return ProductoReemplaConstantesFunciones.getTiposSeleccionarProductoReempla(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoReempla(Boolean conFk) throws Exception  {
		return ProductoReemplaConstantesFunciones.getTiposSeleccionarProductoReempla(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoReempla(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoReemplaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProductoReemplaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoReemplaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProductoReemplaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoReemplaConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ProductoReemplaConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoReemplaConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProductoReemplaConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoReemplaConstantesFunciones.LABEL_IDPRODUCTOREEMPLA);
			reporte.setsDescripcion(ProductoReemplaConstantesFunciones.LABEL_IDPRODUCTOREEMPLA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoReemplaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ProductoReemplaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductoReempla(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductoReempla(ProductoReempla productoreemplaAux) throws Exception {
		
			productoreemplaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productoreemplaAux.getEmpresa()));
			productoreemplaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productoreemplaAux.getSucursal()));
			productoreemplaAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productoreemplaAux.getBodega()));
			productoreemplaAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productoreemplaAux.getProducto()));
			productoreemplaAux.setproductoreempla_descripcion(ProductoReemplaConstantesFunciones.getProductoReemplaDescripcion(productoreemplaAux.getProductoReempla()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductoReempla(List<ProductoReempla> productoreemplasTemp) throws Exception {
		for(ProductoReempla productoreemplaAux:productoreemplasTemp) {
			
			productoreemplaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productoreemplaAux.getEmpresa()));
			productoreemplaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productoreemplaAux.getSucursal()));
			productoreemplaAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productoreemplaAux.getBodega()));
			productoreemplaAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productoreemplaAux.getProducto()));
			productoreemplaAux.setproductoreempla_descripcion(ProductoReemplaConstantesFunciones.getProductoReemplaDescripcion(productoreemplaAux.getProductoReempla()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductoReempla(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(ProductoReempla.class));
				
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
					if(clas.clas.equals(ProductoReempla.class)) {
						classes.add(new Classe(ProductoReempla.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductoReempla(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(ProductoReempla.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoReempla.class)); continue;
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

					if(ProductoReempla.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoReempla.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoReempla(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoReemplaConstantesFunciones.getClassesRelationshipsOfProductoReempla(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoReempla(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ProductoReempla.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoReempla.class)) {
						classes.add(new Classe(ProductoReempla.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoReempla(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoReemplaConstantesFunciones.getClassesRelationshipsFromStringsOfProductoReempla(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoReempla(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoReempla.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoReempla.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoReempla.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoReempla.class)); continue;
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
	public static void actualizarLista(ProductoReempla productoreempla,List<ProductoReempla> productoreemplas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProductoReempla productoreemplaEncontrado=null;
			
			for(ProductoReempla productoreemplaLocal:productoreemplas) {
				if(productoreemplaLocal.getId().equals(productoreempla.getId())) {
					productoreemplaEncontrado=productoreemplaLocal;
					
					productoreemplaLocal.setIsChanged(productoreempla.getIsChanged());
					productoreemplaLocal.setIsNew(productoreempla.getIsNew());
					productoreemplaLocal.setIsDeleted(productoreempla.getIsDeleted());
					
					productoreemplaLocal.setGeneralEntityOriginal(productoreempla.getGeneralEntityOriginal());
					
					productoreemplaLocal.setId(productoreempla.getId());	
					productoreemplaLocal.setVersionRow(productoreempla.getVersionRow());	
					productoreemplaLocal.setid_empresa(productoreempla.getid_empresa());	
					productoreemplaLocal.setid_sucursal(productoreempla.getid_sucursal());	
					productoreemplaLocal.setid_bodega(productoreempla.getid_bodega());	
					productoreemplaLocal.setid_producto(productoreempla.getid_producto());	
					productoreemplaLocal.setid_producto_reempla(productoreempla.getid_producto_reempla());	
					productoreemplaLocal.setdescripcion(productoreempla.getdescripcion());	
					
					
					productoreemplaLocal.setProductoReemplas(productoreempla.getProductoReemplas());
					
					existe=true;
					break;
				}
			}
			
			if(!productoreempla.getIsDeleted()) {
				if(!existe) {
					productoreemplas.add(productoreempla);
				}
			} else {
				if(productoreemplaEncontrado!=null && permiteQuitar)  {
					productoreemplas.remove(productoreemplaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProductoReempla productoreempla,List<ProductoReempla> productoreemplas) throws Exception {
		try	{			
			for(ProductoReempla productoreemplaLocal:productoreemplas) {
				if(productoreemplaLocal.getId().equals(productoreempla.getId())) {
					productoreemplaLocal.setIsSelected(productoreempla.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductoReempla(List<ProductoReempla> productoreemplasAux) throws Exception {
		//this.productoreemplasAux=productoreemplasAux;
		
		for(ProductoReempla productoreemplaAux:productoreemplasAux) {
			if(productoreemplaAux.getIsChanged()) {
				productoreemplaAux.setIsChanged(false);
			}		
			
			if(productoreemplaAux.getIsNew()) {
				productoreemplaAux.setIsNew(false);
			}	
			
			if(productoreemplaAux.getIsDeleted()) {
				productoreemplaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductoReempla(ProductoReempla productoreemplaAux) throws Exception {
		//this.productoreemplaAux=productoreemplaAux;
		
			if(productoreemplaAux.getIsChanged()) {
				productoreemplaAux.setIsChanged(false);
			}		
			
			if(productoreemplaAux.getIsNew()) {
				productoreemplaAux.setIsNew(false);
			}	
			
			if(productoreemplaAux.getIsDeleted()) {
				productoreemplaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductoReempla productoreemplaAsignar,ProductoReempla productoreempla) throws Exception {
		productoreemplaAsignar.setId(productoreempla.getId());	
		productoreemplaAsignar.setVersionRow(productoreempla.getVersionRow());	
		productoreemplaAsignar.setid_empresa(productoreempla.getid_empresa());
		productoreemplaAsignar.setempresa_descripcion(productoreempla.getempresa_descripcion());	
		productoreemplaAsignar.setid_sucursal(productoreempla.getid_sucursal());
		productoreemplaAsignar.setsucursal_descripcion(productoreempla.getsucursal_descripcion());	
		productoreemplaAsignar.setid_bodega(productoreempla.getid_bodega());
		productoreemplaAsignar.setbodega_descripcion(productoreempla.getbodega_descripcion());	
		productoreemplaAsignar.setid_producto(productoreempla.getid_producto());
		productoreemplaAsignar.setproducto_descripcion(productoreempla.getproducto_descripcion());	
		productoreemplaAsignar.setid_producto_reempla(productoreempla.getid_producto_reempla());
		productoreemplaAsignar.setproductoreempla_descripcion(productoreempla.getproductoreempla_descripcion());	
		productoreemplaAsignar.setdescripcion(productoreempla.getdescripcion());	
	}
	
	public static void inicializarProductoReempla(ProductoReempla productoreempla) throws Exception {
		try {
				productoreempla.setId(0L);	
					
				productoreempla.setid_empresa(-1L);	
				productoreempla.setid_sucursal(-1L);	
				productoreempla.setid_bodega(-1L);	
				productoreempla.setid_producto(-1L);	
				productoreempla.setid_producto_reempla(-1L);	
				productoreempla.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductoReempla(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoReemplaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoReemplaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoReemplaConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoReemplaConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoReemplaConstantesFunciones.LABEL_IDPRODUCTOREEMPLA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoReemplaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductoReempla(String sTipo,Row row,Workbook workbook,ProductoReempla productoreempla,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productoreempla.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoreempla.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoreempla.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoreempla.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoreempla.getproductoreempla_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoreempla.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductoReempla=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProductoReempla() {
		return this.sFinalQueryProductoReempla;
	}
	
	public void setsFinalQueryProductoReempla(String sFinalQueryProductoReempla) {
		this.sFinalQueryProductoReempla= sFinalQueryProductoReempla;
	}
	
	public Border resaltarSeleccionarProductoReempla=null;
	
	public Border setResaltarSeleccionarProductoReempla(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoReemplaBeanSwingJInternalFrame productoreemplaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productoreemplaBeanSwingJInternalFrame.jTtoolBarProductoReempla.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductoReempla= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductoReempla() {
		return this.resaltarSeleccionarProductoReempla;
	}
	
	public void setResaltarSeleccionarProductoReempla(Border borderResaltarSeleccionarProductoReempla) {
		this.resaltarSeleccionarProductoReempla= borderResaltarSeleccionarProductoReempla;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductoReempla=null;
	public Boolean mostraridProductoReempla=true;
	public Boolean activaridProductoReempla=true;

	public Border resaltarid_empresaProductoReempla=null;
	public Boolean mostrarid_empresaProductoReempla=true;
	public Boolean activarid_empresaProductoReempla=true;
	public Boolean cargarid_empresaProductoReempla=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProductoReempla=false;//ConEventDepend=true

	public Border resaltarid_sucursalProductoReempla=null;
	public Boolean mostrarid_sucursalProductoReempla=true;
	public Boolean activarid_sucursalProductoReempla=true;
	public Boolean cargarid_sucursalProductoReempla=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProductoReempla=false;//ConEventDepend=true

	public Border resaltarid_bodegaProductoReempla=null;
	public Boolean mostrarid_bodegaProductoReempla=true;
	public Boolean activarid_bodegaProductoReempla=true;
	public Boolean cargarid_bodegaProductoReempla=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaProductoReempla=false;//ConEventDepend=true

	public Border resaltarid_productoProductoReempla=null;
	public Boolean mostrarid_productoProductoReempla=true;
	public Boolean activarid_productoProductoReempla=true;
	public Boolean cargarid_productoProductoReempla=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProductoReempla=false;//ConEventDepend=true

	public Border resaltarid_producto_reemplaProductoReempla=null;
	public Boolean mostrarid_producto_reemplaProductoReempla=true;
	public Boolean activarid_producto_reemplaProductoReempla=true;
	public Boolean cargarid_producto_reemplaProductoReempla=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_producto_reemplaProductoReempla=false;//ConEventDepend=true

	public Border resaltardescripcionProductoReempla=null;
	public Boolean mostrardescripcionProductoReempla=true;
	public Boolean activardescripcionProductoReempla=true;

	
	

	public Border setResaltaridProductoReempla(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoReemplaBeanSwingJInternalFrame productoreemplaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoreemplaBeanSwingJInternalFrame.jTtoolBarProductoReempla.setBorder(borderResaltar);
		
		this.resaltaridProductoReempla= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductoReempla() {
		return this.resaltaridProductoReempla;
	}

	public void setResaltaridProductoReempla(Border borderResaltar) {
		this.resaltaridProductoReempla= borderResaltar;
	}

	public Boolean getMostraridProductoReempla() {
		return this.mostraridProductoReempla;
	}

	public void setMostraridProductoReempla(Boolean mostraridProductoReempla) {
		this.mostraridProductoReempla= mostraridProductoReempla;
	}

	public Boolean getActivaridProductoReempla() {
		return this.activaridProductoReempla;
	}

	public void setActivaridProductoReempla(Boolean activaridProductoReempla) {
		this.activaridProductoReempla= activaridProductoReempla;
	}

	public Border setResaltarid_empresaProductoReempla(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoReemplaBeanSwingJInternalFrame productoreemplaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoreemplaBeanSwingJInternalFrame.jTtoolBarProductoReempla.setBorder(borderResaltar);
		
		this.resaltarid_empresaProductoReempla= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProductoReempla() {
		return this.resaltarid_empresaProductoReempla;
	}

	public void setResaltarid_empresaProductoReempla(Border borderResaltar) {
		this.resaltarid_empresaProductoReempla= borderResaltar;
	}

	public Boolean getMostrarid_empresaProductoReempla() {
		return this.mostrarid_empresaProductoReempla;
	}

	public void setMostrarid_empresaProductoReempla(Boolean mostrarid_empresaProductoReempla) {
		this.mostrarid_empresaProductoReempla= mostrarid_empresaProductoReempla;
	}

	public Boolean getActivarid_empresaProductoReempla() {
		return this.activarid_empresaProductoReempla;
	}

	public void setActivarid_empresaProductoReempla(Boolean activarid_empresaProductoReempla) {
		this.activarid_empresaProductoReempla= activarid_empresaProductoReempla;
	}

	public Boolean getCargarid_empresaProductoReempla() {
		return this.cargarid_empresaProductoReempla;
	}

	public void setCargarid_empresaProductoReempla(Boolean cargarid_empresaProductoReempla) {
		this.cargarid_empresaProductoReempla= cargarid_empresaProductoReempla;
	}

	public Border setResaltarid_sucursalProductoReempla(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoReemplaBeanSwingJInternalFrame productoreemplaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoreemplaBeanSwingJInternalFrame.jTtoolBarProductoReempla.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProductoReempla= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProductoReempla() {
		return this.resaltarid_sucursalProductoReempla;
	}

	public void setResaltarid_sucursalProductoReempla(Border borderResaltar) {
		this.resaltarid_sucursalProductoReempla= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProductoReempla() {
		return this.mostrarid_sucursalProductoReempla;
	}

	public void setMostrarid_sucursalProductoReempla(Boolean mostrarid_sucursalProductoReempla) {
		this.mostrarid_sucursalProductoReempla= mostrarid_sucursalProductoReempla;
	}

	public Boolean getActivarid_sucursalProductoReempla() {
		return this.activarid_sucursalProductoReempla;
	}

	public void setActivarid_sucursalProductoReempla(Boolean activarid_sucursalProductoReempla) {
		this.activarid_sucursalProductoReempla= activarid_sucursalProductoReempla;
	}

	public Boolean getCargarid_sucursalProductoReempla() {
		return this.cargarid_sucursalProductoReempla;
	}

	public void setCargarid_sucursalProductoReempla(Boolean cargarid_sucursalProductoReempla) {
		this.cargarid_sucursalProductoReempla= cargarid_sucursalProductoReempla;
	}

	public Border setResaltarid_bodegaProductoReempla(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoReemplaBeanSwingJInternalFrame productoreemplaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoreemplaBeanSwingJInternalFrame.jTtoolBarProductoReempla.setBorder(borderResaltar);
		
		this.resaltarid_bodegaProductoReempla= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaProductoReempla() {
		return this.resaltarid_bodegaProductoReempla;
	}

	public void setResaltarid_bodegaProductoReempla(Border borderResaltar) {
		this.resaltarid_bodegaProductoReempla= borderResaltar;
	}

	public Boolean getMostrarid_bodegaProductoReempla() {
		return this.mostrarid_bodegaProductoReempla;
	}

	public void setMostrarid_bodegaProductoReempla(Boolean mostrarid_bodegaProductoReempla) {
		this.mostrarid_bodegaProductoReempla= mostrarid_bodegaProductoReempla;
	}

	public Boolean getActivarid_bodegaProductoReempla() {
		return this.activarid_bodegaProductoReempla;
	}

	public void setActivarid_bodegaProductoReempla(Boolean activarid_bodegaProductoReempla) {
		this.activarid_bodegaProductoReempla= activarid_bodegaProductoReempla;
	}

	public Boolean getCargarid_bodegaProductoReempla() {
		return this.cargarid_bodegaProductoReempla;
	}

	public void setCargarid_bodegaProductoReempla(Boolean cargarid_bodegaProductoReempla) {
		this.cargarid_bodegaProductoReempla= cargarid_bodegaProductoReempla;
	}

	public Border setResaltarid_productoProductoReempla(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoReemplaBeanSwingJInternalFrame productoreemplaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoreemplaBeanSwingJInternalFrame.jTtoolBarProductoReempla.setBorder(borderResaltar);
		
		this.resaltarid_productoProductoReempla= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProductoReempla() {
		return this.resaltarid_productoProductoReempla;
	}

	public void setResaltarid_productoProductoReempla(Border borderResaltar) {
		this.resaltarid_productoProductoReempla= borderResaltar;
	}

	public Boolean getMostrarid_productoProductoReempla() {
		return this.mostrarid_productoProductoReempla;
	}

	public void setMostrarid_productoProductoReempla(Boolean mostrarid_productoProductoReempla) {
		this.mostrarid_productoProductoReempla= mostrarid_productoProductoReempla;
	}

	public Boolean getActivarid_productoProductoReempla() {
		return this.activarid_productoProductoReempla;
	}

	public void setActivarid_productoProductoReempla(Boolean activarid_productoProductoReempla) {
		this.activarid_productoProductoReempla= activarid_productoProductoReempla;
	}

	public Boolean getCargarid_productoProductoReempla() {
		return this.cargarid_productoProductoReempla;
	}

	public void setCargarid_productoProductoReempla(Boolean cargarid_productoProductoReempla) {
		this.cargarid_productoProductoReempla= cargarid_productoProductoReempla;
	}

	public Border setResaltarid_producto_reemplaProductoReempla(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoReemplaBeanSwingJInternalFrame productoreemplaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoreemplaBeanSwingJInternalFrame.jTtoolBarProductoReempla.setBorder(borderResaltar);
		
		this.resaltarid_producto_reemplaProductoReempla= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_producto_reemplaProductoReempla() {
		return this.resaltarid_producto_reemplaProductoReempla;
	}

	public void setResaltarid_producto_reemplaProductoReempla(Border borderResaltar) {
		this.resaltarid_producto_reemplaProductoReempla= borderResaltar;
	}

	public Boolean getMostrarid_producto_reemplaProductoReempla() {
		return this.mostrarid_producto_reemplaProductoReempla;
	}

	public void setMostrarid_producto_reemplaProductoReempla(Boolean mostrarid_producto_reemplaProductoReempla) {
		this.mostrarid_producto_reemplaProductoReempla= mostrarid_producto_reemplaProductoReempla;
	}

	public Boolean getActivarid_producto_reemplaProductoReempla() {
		return this.activarid_producto_reemplaProductoReempla;
	}

	public void setActivarid_producto_reemplaProductoReempla(Boolean activarid_producto_reemplaProductoReempla) {
		this.activarid_producto_reemplaProductoReempla= activarid_producto_reemplaProductoReempla;
	}

	public Boolean getCargarid_producto_reemplaProductoReempla() {
		return this.cargarid_producto_reemplaProductoReempla;
	}

	public void setCargarid_producto_reemplaProductoReempla(Boolean cargarid_producto_reemplaProductoReempla) {
		this.cargarid_producto_reemplaProductoReempla= cargarid_producto_reemplaProductoReempla;
	}

	public Border setResaltardescripcionProductoReempla(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoReemplaBeanSwingJInternalFrame productoreemplaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoreemplaBeanSwingJInternalFrame.jTtoolBarProductoReempla.setBorder(borderResaltar);
		
		this.resaltardescripcionProductoReempla= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionProductoReempla() {
		return this.resaltardescripcionProductoReempla;
	}

	public void setResaltardescripcionProductoReempla(Border borderResaltar) {
		this.resaltardescripcionProductoReempla= borderResaltar;
	}

	public Boolean getMostrardescripcionProductoReempla() {
		return this.mostrardescripcionProductoReempla;
	}

	public void setMostrardescripcionProductoReempla(Boolean mostrardescripcionProductoReempla) {
		this.mostrardescripcionProductoReempla= mostrardescripcionProductoReempla;
	}

	public Boolean getActivardescripcionProductoReempla() {
		return this.activardescripcionProductoReempla;
	}

	public void setActivardescripcionProductoReempla(Boolean activardescripcionProductoReempla) {
		this.activardescripcionProductoReempla= activardescripcionProductoReempla;
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
		
		
		this.setMostraridProductoReempla(esInicial);
		this.setMostrarid_empresaProductoReempla(esInicial);
		this.setMostrarid_sucursalProductoReempla(esInicial);
		this.setMostrarid_bodegaProductoReempla(esInicial);
		this.setMostrarid_productoProductoReempla(esInicial);
		this.setMostrarid_producto_reemplaProductoReempla(esInicial);
		this.setMostrardescripcionProductoReempla(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoReemplaConstantesFunciones.ID)) {
				this.setMostraridProductoReempla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoReemplaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProductoReempla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoReemplaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProductoReempla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoReemplaConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaProductoReempla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoReemplaConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProductoReempla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoReemplaConstantesFunciones.IDPRODUCTOREEMPLA)) {
				this.setMostrarid_producto_reemplaProductoReempla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoReemplaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionProductoReempla(esAsigna);
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
		
		
		this.setActivaridProductoReempla(esInicial);
		this.setActivarid_empresaProductoReempla(esInicial);
		this.setActivarid_sucursalProductoReempla(esInicial);
		this.setActivarid_bodegaProductoReempla(esInicial);
		this.setActivarid_productoProductoReempla(esInicial);
		this.setActivarid_producto_reemplaProductoReempla(esInicial);
		this.setActivardescripcionProductoReempla(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoReemplaConstantesFunciones.ID)) {
				this.setActivaridProductoReempla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoReemplaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProductoReempla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoReemplaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProductoReempla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoReemplaConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaProductoReempla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoReemplaConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProductoReempla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoReemplaConstantesFunciones.IDPRODUCTOREEMPLA)) {
				this.setActivarid_producto_reemplaProductoReempla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoReemplaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionProductoReempla(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoReemplaBeanSwingJInternalFrame productoreemplaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductoReempla(esInicial);
		this.setResaltarid_empresaProductoReempla(esInicial);
		this.setResaltarid_sucursalProductoReempla(esInicial);
		this.setResaltarid_bodegaProductoReempla(esInicial);
		this.setResaltarid_productoProductoReempla(esInicial);
		this.setResaltarid_producto_reemplaProductoReempla(esInicial);
		this.setResaltardescripcionProductoReempla(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoReemplaConstantesFunciones.ID)) {
				this.setResaltaridProductoReempla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoReemplaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProductoReempla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoReemplaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProductoReempla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoReemplaConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaProductoReempla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoReemplaConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProductoReempla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoReemplaConstantesFunciones.IDPRODUCTOREEMPLA)) {
				this.setResaltarid_producto_reemplaProductoReempla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoReemplaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionProductoReempla(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarProductoReemplaProductoReempla=null;

	public Border getResaltarProductoReemplaProductoReempla() {
		return this.resaltarProductoReemplaProductoReempla;
	}

	public void setResaltarProductoReemplaProductoReempla(Border borderResaltarProductoReempla) {
		if(borderResaltarProductoReempla!=null) {
			this.resaltarProductoReemplaProductoReempla= borderResaltarProductoReempla;
		}
	}

	public Border setResaltarProductoReemplaProductoReempla(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoReemplaBeanSwingJInternalFrame productoreemplaBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoReempla=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productoreemplaBeanSwingJInternalFrame.jTtoolBarProductoReempla.setBorder(borderResaltarProductoReempla);
			
		this.resaltarProductoReemplaProductoReempla= borderResaltarProductoReempla;

		 return borderResaltarProductoReempla;
	}



	public Boolean mostrarProductoReemplaProductoReempla=true;

	public Boolean getMostrarProductoReemplaProductoReempla() {
		return this.mostrarProductoReemplaProductoReempla;
	}

	public void setMostrarProductoReemplaProductoReempla(Boolean visibilidadResaltarProductoReempla) {
		this.mostrarProductoReemplaProductoReempla= visibilidadResaltarProductoReempla;
	}



	public Boolean activarProductoReemplaProductoReempla=true;

	public Boolean gethabilitarResaltarProductoReemplaProductoReempla() {
		return this.activarProductoReemplaProductoReempla;
	}

	public void setActivarProductoReemplaProductoReempla(Boolean habilitarResaltarProductoReempla) {
		this.activarProductoReemplaProductoReempla= habilitarResaltarProductoReempla;
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

		this.setMostrarProductoReemplaProductoReempla(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProductoReempla.class)) {
				this.setMostrarProductoReemplaProductoReempla(esAsigna);
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

		this.setActivarProductoReemplaProductoReempla(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProductoReempla.class)) {
				this.setActivarProductoReemplaProductoReempla(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoReemplaBeanSwingJInternalFrame productoreemplaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarProductoReemplaProductoReempla(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProductoReempla.class)) {
				this.setResaltarProductoReemplaProductoReempla(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdBodegaProductoReempla=true;

	public Boolean getMostrarFK_IdBodegaProductoReempla() {
		return this.mostrarFK_IdBodegaProductoReempla;
	}

	public void setMostrarFK_IdBodegaProductoReempla(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaProductoReempla= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaProductoReempla=true;

	public Boolean getMostrarFK_IdEmpresaProductoReempla() {
		return this.mostrarFK_IdEmpresaProductoReempla;
	}

	public void setMostrarFK_IdEmpresaProductoReempla(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaProductoReempla= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoProductoReempla=true;

	public Boolean getMostrarFK_IdProductoProductoReempla() {
		return this.mostrarFK_IdProductoProductoReempla;
	}

	public void setMostrarFK_IdProductoProductoReempla(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoProductoReempla= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoReemplaProductoReempla=true;

	public Boolean getMostrarFK_IdProductoReemplaProductoReempla() {
		return this.mostrarFK_IdProductoReemplaProductoReempla;
	}

	public void setMostrarFK_IdProductoReemplaProductoReempla(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoReemplaProductoReempla= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalProductoReempla=true;

	public Boolean getMostrarFK_IdSucursalProductoReempla() {
		return this.mostrarFK_IdSucursalProductoReempla;
	}

	public void setMostrarFK_IdSucursalProductoReempla(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalProductoReempla= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaProductoReempla=true;

	public Boolean getActivarFK_IdBodegaProductoReempla() {
		return this.activarFK_IdBodegaProductoReempla;
	}

	public void setActivarFK_IdBodegaProductoReempla(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaProductoReempla= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaProductoReempla=true;

	public Boolean getActivarFK_IdEmpresaProductoReempla() {
		return this.activarFK_IdEmpresaProductoReempla;
	}

	public void setActivarFK_IdEmpresaProductoReempla(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaProductoReempla= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoProductoReempla=true;

	public Boolean getActivarFK_IdProductoProductoReempla() {
		return this.activarFK_IdProductoProductoReempla;
	}

	public void setActivarFK_IdProductoProductoReempla(Boolean habilitarResaltar) {
		this.activarFK_IdProductoProductoReempla= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoReemplaProductoReempla=true;

	public Boolean getActivarFK_IdProductoReemplaProductoReempla() {
		return this.activarFK_IdProductoReemplaProductoReempla;
	}

	public void setActivarFK_IdProductoReemplaProductoReempla(Boolean habilitarResaltar) {
		this.activarFK_IdProductoReemplaProductoReempla= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalProductoReempla=true;

	public Boolean getActivarFK_IdSucursalProductoReempla() {
		return this.activarFK_IdSucursalProductoReempla;
	}

	public void setActivarFK_IdSucursalProductoReempla(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalProductoReempla= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaProductoReempla=null;

	public Border getResaltarFK_IdBodegaProductoReempla() {
		return this.resaltarFK_IdBodegaProductoReempla;
	}

	public void setResaltarFK_IdBodegaProductoReempla(Border borderResaltar) {
		this.resaltarFK_IdBodegaProductoReempla= borderResaltar;
	}

	public void setResaltarFK_IdBodegaProductoReempla(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoReemplaBeanSwingJInternalFrame productoreemplaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaProductoReempla= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaProductoReempla=null;

	public Border getResaltarFK_IdEmpresaProductoReempla() {
		return this.resaltarFK_IdEmpresaProductoReempla;
	}

	public void setResaltarFK_IdEmpresaProductoReempla(Border borderResaltar) {
		this.resaltarFK_IdEmpresaProductoReempla= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaProductoReempla(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoReemplaBeanSwingJInternalFrame productoreemplaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaProductoReempla= borderResaltar;
	}

	public Border resaltarFK_IdProductoProductoReempla=null;

	public Border getResaltarFK_IdProductoProductoReempla() {
		return this.resaltarFK_IdProductoProductoReempla;
	}

	public void setResaltarFK_IdProductoProductoReempla(Border borderResaltar) {
		this.resaltarFK_IdProductoProductoReempla= borderResaltar;
	}

	public void setResaltarFK_IdProductoProductoReempla(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoReemplaBeanSwingJInternalFrame productoreemplaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoProductoReempla= borderResaltar;
	}

	public Border resaltarFK_IdProductoReemplaProductoReempla=null;

	public Border getResaltarFK_IdProductoReemplaProductoReempla() {
		return this.resaltarFK_IdProductoReemplaProductoReempla;
	}

	public void setResaltarFK_IdProductoReemplaProductoReempla(Border borderResaltar) {
		this.resaltarFK_IdProductoReemplaProductoReempla= borderResaltar;
	}

	public void setResaltarFK_IdProductoReemplaProductoReempla(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoReemplaBeanSwingJInternalFrame productoreemplaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoReemplaProductoReempla= borderResaltar;
	}

	public Border resaltarFK_IdSucursalProductoReempla=null;

	public Border getResaltarFK_IdSucursalProductoReempla() {
		return this.resaltarFK_IdSucursalProductoReempla;
	}

	public void setResaltarFK_IdSucursalProductoReempla(Border borderResaltar) {
		this.resaltarFK_IdSucursalProductoReempla= borderResaltar;
	}

	public void setResaltarFK_IdSucursalProductoReempla(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoReemplaBeanSwingJInternalFrame productoreemplaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalProductoReempla= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}