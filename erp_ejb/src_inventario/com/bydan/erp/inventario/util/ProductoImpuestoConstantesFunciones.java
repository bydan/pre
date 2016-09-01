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


import com.bydan.erp.inventario.util.ProductoImpuestoConstantesFunciones;
import com.bydan.erp.inventario.util.ProductoImpuestoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ProductoImpuestoParameterGeneral;

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
final public class ProductoImpuestoConstantesFunciones extends ProductoImpuestoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProductoImpuesto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductoImpuesto"+ProductoImpuestoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductoImpuestoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductoImpuestoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductoImpuestoConstantesFunciones.SCHEMA+"_"+ProductoImpuestoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductoImpuestoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductoImpuestoConstantesFunciones.SCHEMA+"_"+ProductoImpuestoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductoImpuestoConstantesFunciones.SCHEMA+"_"+ProductoImpuestoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductoImpuestoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductoImpuestoConstantesFunciones.SCHEMA+"_"+ProductoImpuestoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoImpuestoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoImpuestoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoImpuestoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoImpuestoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoImpuestoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoImpuestoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductoImpuestoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductoImpuestoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductoImpuestoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductoImpuestoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Producto Impuestos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Producto Impuesto";
	public static final String SCLASSWEBTITULO_LOWER="Producto Impuesto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductoImpuesto";
	public static final String OBJECTNAME="productoimpuesto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="producto_impuesto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productoimpuesto from "+ProductoImpuestoConstantesFunciones.SPERSISTENCENAME+" productoimpuesto";
	public static String QUERYSELECTNATIVE="select "+ProductoImpuestoConstantesFunciones.SCHEMA+"."+ProductoImpuestoConstantesFunciones.TABLENAME+".id,"+ProductoImpuestoConstantesFunciones.SCHEMA+"."+ProductoImpuestoConstantesFunciones.TABLENAME+".version_row,"+ProductoImpuestoConstantesFunciones.SCHEMA+"."+ProductoImpuestoConstantesFunciones.TABLENAME+".id_empresa,"+ProductoImpuestoConstantesFunciones.SCHEMA+"."+ProductoImpuestoConstantesFunciones.TABLENAME+".id_sucursal,"+ProductoImpuestoConstantesFunciones.SCHEMA+"."+ProductoImpuestoConstantesFunciones.TABLENAME+".id_bodega,"+ProductoImpuestoConstantesFunciones.SCHEMA+"."+ProductoImpuestoConstantesFunciones.TABLENAME+".id_producto,"+ProductoImpuestoConstantesFunciones.SCHEMA+"."+ProductoImpuestoConstantesFunciones.TABLENAME+".id_impuesto_inven,"+ProductoImpuestoConstantesFunciones.SCHEMA+"."+ProductoImpuestoConstantesFunciones.TABLENAME+".porcentaje,"+ProductoImpuestoConstantesFunciones.SCHEMA+"."+ProductoImpuestoConstantesFunciones.TABLENAME+".valor from "+ProductoImpuestoConstantesFunciones.SCHEMA+"."+ProductoImpuestoConstantesFunciones.TABLENAME;//+" as "+ProductoImpuestoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProductoImpuestoConstantesFuncionesAdditional productoimpuestoConstantesFuncionesAdditional=null;
	
	public ProductoImpuestoConstantesFuncionesAdditional getProductoImpuestoConstantesFuncionesAdditional() {
		return this.productoimpuestoConstantesFuncionesAdditional;
	}
	
	public void setProductoImpuestoConstantesFuncionesAdditional(ProductoImpuestoConstantesFuncionesAdditional productoimpuestoConstantesFuncionesAdditional) {
		try {
			this.productoimpuestoConstantesFuncionesAdditional=productoimpuestoConstantesFuncionesAdditional;
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
    public static final String IDIMPUESTOINVEN= "id_impuesto_inven";
    public static final String PORCENTAJE= "porcentaje";
    public static final String VALOR= "valor";
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
    	public static final String LABEL_IDIMPUESTOINVEN= "Impuesto Inven";
		public static final String LABEL_IDIMPUESTOINVEN_LOWER= "Impuesto Inven";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
	
		
		
		
		
		
		
		
		
		
	
	public static String getProductoImpuestoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductoImpuestoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProductoImpuestoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProductoImpuestoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProductoImpuestoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProductoImpuestoConstantesFunciones.IDBODEGA)) {sLabelColumna=ProductoImpuestoConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ProductoImpuestoConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProductoImpuestoConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProductoImpuestoConstantesFunciones.IDIMPUESTOINVEN)) {sLabelColumna=ProductoImpuestoConstantesFunciones.LABEL_IDIMPUESTOINVEN;}
		if(sNombreColumna.equals(ProductoImpuestoConstantesFunciones.PORCENTAJE)) {sLabelColumna=ProductoImpuestoConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(ProductoImpuestoConstantesFunciones.VALOR)) {sLabelColumna=ProductoImpuestoConstantesFunciones.LABEL_VALOR;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
	
	public static String getProductoImpuestoDescripcion(ProductoImpuesto productoimpuesto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productoimpuesto !=null/* && productoimpuesto.getId()!=0*/) {
			if(productoimpuesto.getId()!=null) {
				sDescripcion=productoimpuesto.getId().toString();
			}//productoimpuestoproductoimpuesto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductoImpuestoDescripcionDetallado(ProductoImpuesto productoimpuesto) {
		String sDescripcion="";
			
		sDescripcion+=ProductoImpuestoConstantesFunciones.ID+"=";
		sDescripcion+=productoimpuesto.getId().toString()+",";
		sDescripcion+=ProductoImpuestoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productoimpuesto.getVersionRow().toString()+",";
		sDescripcion+=ProductoImpuestoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=productoimpuesto.getid_empresa().toString()+",";
		sDescripcion+=ProductoImpuestoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=productoimpuesto.getid_sucursal().toString()+",";
		sDescripcion+=ProductoImpuestoConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=productoimpuesto.getid_bodega().toString()+",";
		sDescripcion+=ProductoImpuestoConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=productoimpuesto.getid_producto().toString()+",";
		sDescripcion+=ProductoImpuestoConstantesFunciones.IDIMPUESTOINVEN+"=";
		sDescripcion+=productoimpuesto.getid_impuesto_inven().toString()+",";
		sDescripcion+=ProductoImpuestoConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=productoimpuesto.getporcentaje().toString()+",";
		sDescripcion+=ProductoImpuestoConstantesFunciones.VALOR+"=";
		sDescripcion+=productoimpuesto.getvalor().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProductoImpuestoDescripcion(ProductoImpuesto productoimpuesto,String sValor) throws Exception {			
		if(productoimpuesto !=null) {
			//productoimpuestoproductoimpuesto.getId().toString();
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

	public static String getImpuestoInvenDescripcion(ImpuestoInven impuestoinven) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(impuestoinven!=null/*&&impuestoinven.getId()>0*/) {
			sDescripcion=ImpuestoInvenConstantesFunciones.getImpuestoInvenDescripcion(impuestoinven);
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
		} else if(sNombreIndice.equals("FK_IdImpuestoInven")) {
			sNombreIndice="Tipo=  Por Impuesto Inven";
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

	public static String getDetalleIndiceFK_IdImpuestoInven(Long id_impuesto_inven) {
		String sDetalleIndice=" Parametros->";
		if(id_impuesto_inven!=null) {sDetalleIndice+=" Codigo Unico De Impuesto Inven="+id_impuesto_inven.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosProductoImpuesto(ProductoImpuesto productoimpuesto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProductoImpuestos(List<ProductoImpuesto> productoimpuestos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoImpuesto productoimpuesto: productoimpuestos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoImpuesto(ProductoImpuesto productoimpuesto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productoimpuesto.getConCambioAuxiliar()) {
			productoimpuesto.setIsDeleted(productoimpuesto.getIsDeletedAuxiliar());	
			productoimpuesto.setIsNew(productoimpuesto.getIsNewAuxiliar());	
			productoimpuesto.setIsChanged(productoimpuesto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productoimpuesto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productoimpuesto.setIsDeletedAuxiliar(false);	
			productoimpuesto.setIsNewAuxiliar(false);	
			productoimpuesto.setIsChangedAuxiliar(false);
			
			productoimpuesto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoImpuestos(List<ProductoImpuesto> productoimpuestos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductoImpuesto productoimpuesto : productoimpuestos) {
			if(conAsignarBase && productoimpuesto.getConCambioAuxiliar()) {
				productoimpuesto.setIsDeleted(productoimpuesto.getIsDeletedAuxiliar());	
				productoimpuesto.setIsNew(productoimpuesto.getIsNewAuxiliar());	
				productoimpuesto.setIsChanged(productoimpuesto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productoimpuesto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productoimpuesto.setIsDeletedAuxiliar(false);	
				productoimpuesto.setIsNewAuxiliar(false);	
				productoimpuesto.setIsChangedAuxiliar(false);
				
				productoimpuesto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductoImpuesto(ProductoImpuesto productoimpuesto,Boolean conEnteros) throws Exception  {
		productoimpuesto.setporcentaje(0.0);
		productoimpuesto.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProductoImpuestos(List<ProductoImpuesto> productoimpuestos,Boolean conEnteros) throws Exception  {
		
		for(ProductoImpuesto productoimpuesto: productoimpuestos) {
			productoimpuesto.setporcentaje(0.0);
			productoimpuesto.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductoImpuesto(List<ProductoImpuesto> productoimpuestos,ProductoImpuesto productoimpuestoAux) throws Exception  {
		ProductoImpuestoConstantesFunciones.InicializarValoresProductoImpuesto(productoimpuestoAux,true);
		
		for(ProductoImpuesto productoimpuesto: productoimpuestos) {
			if(productoimpuesto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productoimpuestoAux.setporcentaje(productoimpuestoAux.getporcentaje()+productoimpuesto.getporcentaje());			
			productoimpuestoAux.setvalor(productoimpuestoAux.getvalor()+productoimpuesto.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoImpuesto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductoImpuestoConstantesFunciones.getArrayColumnasGlobalesProductoImpuesto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoImpuesto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductoImpuestoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductoImpuestoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductoImpuestoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductoImpuestoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductoImpuesto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoImpuesto> productoimpuestos,ProductoImpuesto productoimpuesto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoImpuesto productoimpuestoAux: productoimpuestos) {
			if(productoimpuestoAux!=null && productoimpuesto!=null) {
				if((productoimpuestoAux.getId()==null && productoimpuesto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productoimpuestoAux.getId()!=null && productoimpuesto.getId()!=null){
					if(productoimpuestoAux.getId().equals(productoimpuesto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoImpuesto(List<ProductoImpuesto> productoimpuestos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double valorTotal=0.0;
	
		for(ProductoImpuesto productoimpuesto: productoimpuestos) {			
			if(productoimpuesto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=productoimpuesto.getporcentaje();
			valorTotal+=productoimpuesto.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoImpuestoConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(ProductoImpuestoConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoImpuestoConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ProductoImpuestoConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductoImpuesto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductoImpuestoConstantesFunciones.LABEL_ID, ProductoImpuestoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoImpuestoConstantesFunciones.LABEL_VERSIONROW, ProductoImpuestoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoImpuestoConstantesFunciones.LABEL_IDEMPRESA, ProductoImpuestoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoImpuestoConstantesFunciones.LABEL_IDSUCURSAL, ProductoImpuestoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoImpuestoConstantesFunciones.LABEL_IDBODEGA, ProductoImpuestoConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoImpuestoConstantesFunciones.LABEL_IDPRODUCTO, ProductoImpuestoConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoImpuestoConstantesFunciones.LABEL_IDIMPUESTOINVEN, ProductoImpuestoConstantesFunciones.IDIMPUESTOINVEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoImpuestoConstantesFunciones.LABEL_PORCENTAJE, ProductoImpuestoConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoImpuestoConstantesFunciones.LABEL_VALOR, ProductoImpuestoConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductoImpuesto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductoImpuestoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoImpuestoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoImpuestoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoImpuestoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoImpuestoConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoImpuestoConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoImpuestoConstantesFunciones.IDIMPUESTOINVEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoImpuestoConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoImpuestoConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoImpuesto() throws Exception  {
		return ProductoImpuestoConstantesFunciones.getTiposSeleccionarProductoImpuesto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoImpuesto(Boolean conFk) throws Exception  {
		return ProductoImpuestoConstantesFunciones.getTiposSeleccionarProductoImpuesto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoImpuesto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoImpuestoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProductoImpuestoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoImpuestoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProductoImpuestoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoImpuestoConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ProductoImpuestoConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoImpuestoConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProductoImpuestoConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoImpuestoConstantesFunciones.LABEL_IDIMPUESTOINVEN);
			reporte.setsDescripcion(ProductoImpuestoConstantesFunciones.LABEL_IDIMPUESTOINVEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoImpuestoConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(ProductoImpuestoConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoImpuestoConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(ProductoImpuestoConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductoImpuesto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductoImpuesto(ProductoImpuesto productoimpuestoAux) throws Exception {
		
			productoimpuestoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productoimpuestoAux.getEmpresa()));
			productoimpuestoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productoimpuestoAux.getSucursal()));
			productoimpuestoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productoimpuestoAux.getBodega()));
			productoimpuestoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productoimpuestoAux.getProducto()));
			productoimpuestoAux.setimpuestoinven_descripcion(ImpuestoInvenConstantesFunciones.getImpuestoInvenDescripcion(productoimpuestoAux.getImpuestoInven()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductoImpuesto(List<ProductoImpuesto> productoimpuestosTemp) throws Exception {
		for(ProductoImpuesto productoimpuestoAux:productoimpuestosTemp) {
			
			productoimpuestoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productoimpuestoAux.getEmpresa()));
			productoimpuestoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productoimpuestoAux.getSucursal()));
			productoimpuestoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productoimpuestoAux.getBodega()));
			productoimpuestoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productoimpuestoAux.getProducto()));
			productoimpuestoAux.setimpuestoinven_descripcion(ImpuestoInvenConstantesFunciones.getImpuestoInvenDescripcion(productoimpuestoAux.getImpuestoInven()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductoImpuesto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(ImpuestoInven.class));
				
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
					if(clas.clas.equals(ImpuestoInven.class)) {
						classes.add(new Classe(ImpuestoInven.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductoImpuesto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(ImpuestoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ImpuestoInven.class)); continue;
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

					if(ImpuestoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ImpuestoInven.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoImpuesto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoImpuestoConstantesFunciones.getClassesRelationshipsOfProductoImpuesto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoImpuesto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoImpuesto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoImpuestoConstantesFunciones.getClassesRelationshipsFromStringsOfProductoImpuesto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoImpuesto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductoImpuesto productoimpuesto,List<ProductoImpuesto> productoimpuestos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProductoImpuesto productoimpuestoEncontrado=null;
			
			for(ProductoImpuesto productoimpuestoLocal:productoimpuestos) {
				if(productoimpuestoLocal.getId().equals(productoimpuesto.getId())) {
					productoimpuestoEncontrado=productoimpuestoLocal;
					
					productoimpuestoLocal.setIsChanged(productoimpuesto.getIsChanged());
					productoimpuestoLocal.setIsNew(productoimpuesto.getIsNew());
					productoimpuestoLocal.setIsDeleted(productoimpuesto.getIsDeleted());
					
					productoimpuestoLocal.setGeneralEntityOriginal(productoimpuesto.getGeneralEntityOriginal());
					
					productoimpuestoLocal.setId(productoimpuesto.getId());	
					productoimpuestoLocal.setVersionRow(productoimpuesto.getVersionRow());	
					productoimpuestoLocal.setid_empresa(productoimpuesto.getid_empresa());	
					productoimpuestoLocal.setid_sucursal(productoimpuesto.getid_sucursal());	
					productoimpuestoLocal.setid_bodega(productoimpuesto.getid_bodega());	
					productoimpuestoLocal.setid_producto(productoimpuesto.getid_producto());	
					productoimpuestoLocal.setid_impuesto_inven(productoimpuesto.getid_impuesto_inven());	
					productoimpuestoLocal.setporcentaje(productoimpuesto.getporcentaje());	
					productoimpuestoLocal.setvalor(productoimpuesto.getvalor());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!productoimpuesto.getIsDeleted()) {
				if(!existe) {
					productoimpuestos.add(productoimpuesto);
				}
			} else {
				if(productoimpuestoEncontrado!=null && permiteQuitar)  {
					productoimpuestos.remove(productoimpuestoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProductoImpuesto productoimpuesto,List<ProductoImpuesto> productoimpuestos) throws Exception {
		try	{			
			for(ProductoImpuesto productoimpuestoLocal:productoimpuestos) {
				if(productoimpuestoLocal.getId().equals(productoimpuesto.getId())) {
					productoimpuestoLocal.setIsSelected(productoimpuesto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductoImpuesto(List<ProductoImpuesto> productoimpuestosAux) throws Exception {
		//this.productoimpuestosAux=productoimpuestosAux;
		
		for(ProductoImpuesto productoimpuestoAux:productoimpuestosAux) {
			if(productoimpuestoAux.getIsChanged()) {
				productoimpuestoAux.setIsChanged(false);
			}		
			
			if(productoimpuestoAux.getIsNew()) {
				productoimpuestoAux.setIsNew(false);
			}	
			
			if(productoimpuestoAux.getIsDeleted()) {
				productoimpuestoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductoImpuesto(ProductoImpuesto productoimpuestoAux) throws Exception {
		//this.productoimpuestoAux=productoimpuestoAux;
		
			if(productoimpuestoAux.getIsChanged()) {
				productoimpuestoAux.setIsChanged(false);
			}		
			
			if(productoimpuestoAux.getIsNew()) {
				productoimpuestoAux.setIsNew(false);
			}	
			
			if(productoimpuestoAux.getIsDeleted()) {
				productoimpuestoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductoImpuesto productoimpuestoAsignar,ProductoImpuesto productoimpuesto) throws Exception {
		productoimpuestoAsignar.setId(productoimpuesto.getId());	
		productoimpuestoAsignar.setVersionRow(productoimpuesto.getVersionRow());	
		productoimpuestoAsignar.setid_empresa(productoimpuesto.getid_empresa());
		productoimpuestoAsignar.setempresa_descripcion(productoimpuesto.getempresa_descripcion());	
		productoimpuestoAsignar.setid_sucursal(productoimpuesto.getid_sucursal());
		productoimpuestoAsignar.setsucursal_descripcion(productoimpuesto.getsucursal_descripcion());	
		productoimpuestoAsignar.setid_bodega(productoimpuesto.getid_bodega());
		productoimpuestoAsignar.setbodega_descripcion(productoimpuesto.getbodega_descripcion());	
		productoimpuestoAsignar.setid_producto(productoimpuesto.getid_producto());
		productoimpuestoAsignar.setproducto_descripcion(productoimpuesto.getproducto_descripcion());	
		productoimpuestoAsignar.setid_impuesto_inven(productoimpuesto.getid_impuesto_inven());
		productoimpuestoAsignar.setimpuestoinven_descripcion(productoimpuesto.getimpuestoinven_descripcion());	
		productoimpuestoAsignar.setporcentaje(productoimpuesto.getporcentaje());	
		productoimpuestoAsignar.setvalor(productoimpuesto.getvalor());	
	}
	
	public static void inicializarProductoImpuesto(ProductoImpuesto productoimpuesto) throws Exception {
		try {
				productoimpuesto.setId(0L);	
					
				productoimpuesto.setid_empresa(-1L);	
				productoimpuesto.setid_sucursal(-1L);	
				productoimpuesto.setid_bodega(-1L);	
				productoimpuesto.setid_producto(-1L);	
				productoimpuesto.setid_impuesto_inven(-1L);	
				productoimpuesto.setporcentaje(0.0);	
				productoimpuesto.setvalor(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductoImpuesto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoImpuestoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoImpuestoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoImpuestoConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoImpuestoConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoImpuestoConstantesFunciones.LABEL_IDIMPUESTOINVEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoImpuestoConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoImpuestoConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductoImpuesto(String sTipo,Row row,Workbook workbook,ProductoImpuesto productoimpuesto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productoimpuesto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoimpuesto.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoimpuesto.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoimpuesto.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoimpuesto.getimpuestoinven_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoimpuesto.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoimpuesto.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductoImpuesto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProductoImpuesto() {
		return this.sFinalQueryProductoImpuesto;
	}
	
	public void setsFinalQueryProductoImpuesto(String sFinalQueryProductoImpuesto) {
		this.sFinalQueryProductoImpuesto= sFinalQueryProductoImpuesto;
	}
	
	public Border resaltarSeleccionarProductoImpuesto=null;
	
	public Border setResaltarSeleccionarProductoImpuesto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoImpuestoBeanSwingJInternalFrame productoimpuestoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productoimpuestoBeanSwingJInternalFrame.jTtoolBarProductoImpuesto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductoImpuesto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductoImpuesto() {
		return this.resaltarSeleccionarProductoImpuesto;
	}
	
	public void setResaltarSeleccionarProductoImpuesto(Border borderResaltarSeleccionarProductoImpuesto) {
		this.resaltarSeleccionarProductoImpuesto= borderResaltarSeleccionarProductoImpuesto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductoImpuesto=null;
	public Boolean mostraridProductoImpuesto=true;
	public Boolean activaridProductoImpuesto=true;

	public Border resaltarid_empresaProductoImpuesto=null;
	public Boolean mostrarid_empresaProductoImpuesto=true;
	public Boolean activarid_empresaProductoImpuesto=true;
	public Boolean cargarid_empresaProductoImpuesto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProductoImpuesto=false;//ConEventDepend=true

	public Border resaltarid_sucursalProductoImpuesto=null;
	public Boolean mostrarid_sucursalProductoImpuesto=true;
	public Boolean activarid_sucursalProductoImpuesto=true;
	public Boolean cargarid_sucursalProductoImpuesto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProductoImpuesto=false;//ConEventDepend=true

	public Border resaltarid_bodegaProductoImpuesto=null;
	public Boolean mostrarid_bodegaProductoImpuesto=true;
	public Boolean activarid_bodegaProductoImpuesto=true;
	public Boolean cargarid_bodegaProductoImpuesto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaProductoImpuesto=false;//ConEventDepend=true

	public Border resaltarid_productoProductoImpuesto=null;
	public Boolean mostrarid_productoProductoImpuesto=true;
	public Boolean activarid_productoProductoImpuesto=true;
	public Boolean cargarid_productoProductoImpuesto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProductoImpuesto=false;//ConEventDepend=true

	public Border resaltarid_impuesto_invenProductoImpuesto=null;
	public Boolean mostrarid_impuesto_invenProductoImpuesto=true;
	public Boolean activarid_impuesto_invenProductoImpuesto=true;
	public Boolean cargarid_impuesto_invenProductoImpuesto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_impuesto_invenProductoImpuesto=false;//ConEventDepend=true

	public Border resaltarporcentajeProductoImpuesto=null;
	public Boolean mostrarporcentajeProductoImpuesto=true;
	public Boolean activarporcentajeProductoImpuesto=true;

	public Border resaltarvalorProductoImpuesto=null;
	public Boolean mostrarvalorProductoImpuesto=true;
	public Boolean activarvalorProductoImpuesto=true;

	
	

	public Border setResaltaridProductoImpuesto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoImpuestoBeanSwingJInternalFrame productoimpuestoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoimpuestoBeanSwingJInternalFrame.jTtoolBarProductoImpuesto.setBorder(borderResaltar);
		
		this.resaltaridProductoImpuesto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductoImpuesto() {
		return this.resaltaridProductoImpuesto;
	}

	public void setResaltaridProductoImpuesto(Border borderResaltar) {
		this.resaltaridProductoImpuesto= borderResaltar;
	}

	public Boolean getMostraridProductoImpuesto() {
		return this.mostraridProductoImpuesto;
	}

	public void setMostraridProductoImpuesto(Boolean mostraridProductoImpuesto) {
		this.mostraridProductoImpuesto= mostraridProductoImpuesto;
	}

	public Boolean getActivaridProductoImpuesto() {
		return this.activaridProductoImpuesto;
	}

	public void setActivaridProductoImpuesto(Boolean activaridProductoImpuesto) {
		this.activaridProductoImpuesto= activaridProductoImpuesto;
	}

	public Border setResaltarid_empresaProductoImpuesto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoImpuestoBeanSwingJInternalFrame productoimpuestoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoimpuestoBeanSwingJInternalFrame.jTtoolBarProductoImpuesto.setBorder(borderResaltar);
		
		this.resaltarid_empresaProductoImpuesto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProductoImpuesto() {
		return this.resaltarid_empresaProductoImpuesto;
	}

	public void setResaltarid_empresaProductoImpuesto(Border borderResaltar) {
		this.resaltarid_empresaProductoImpuesto= borderResaltar;
	}

	public Boolean getMostrarid_empresaProductoImpuesto() {
		return this.mostrarid_empresaProductoImpuesto;
	}

	public void setMostrarid_empresaProductoImpuesto(Boolean mostrarid_empresaProductoImpuesto) {
		this.mostrarid_empresaProductoImpuesto= mostrarid_empresaProductoImpuesto;
	}

	public Boolean getActivarid_empresaProductoImpuesto() {
		return this.activarid_empresaProductoImpuesto;
	}

	public void setActivarid_empresaProductoImpuesto(Boolean activarid_empresaProductoImpuesto) {
		this.activarid_empresaProductoImpuesto= activarid_empresaProductoImpuesto;
	}

	public Boolean getCargarid_empresaProductoImpuesto() {
		return this.cargarid_empresaProductoImpuesto;
	}

	public void setCargarid_empresaProductoImpuesto(Boolean cargarid_empresaProductoImpuesto) {
		this.cargarid_empresaProductoImpuesto= cargarid_empresaProductoImpuesto;
	}

	public Border setResaltarid_sucursalProductoImpuesto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoImpuestoBeanSwingJInternalFrame productoimpuestoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoimpuestoBeanSwingJInternalFrame.jTtoolBarProductoImpuesto.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProductoImpuesto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProductoImpuesto() {
		return this.resaltarid_sucursalProductoImpuesto;
	}

	public void setResaltarid_sucursalProductoImpuesto(Border borderResaltar) {
		this.resaltarid_sucursalProductoImpuesto= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProductoImpuesto() {
		return this.mostrarid_sucursalProductoImpuesto;
	}

	public void setMostrarid_sucursalProductoImpuesto(Boolean mostrarid_sucursalProductoImpuesto) {
		this.mostrarid_sucursalProductoImpuesto= mostrarid_sucursalProductoImpuesto;
	}

	public Boolean getActivarid_sucursalProductoImpuesto() {
		return this.activarid_sucursalProductoImpuesto;
	}

	public void setActivarid_sucursalProductoImpuesto(Boolean activarid_sucursalProductoImpuesto) {
		this.activarid_sucursalProductoImpuesto= activarid_sucursalProductoImpuesto;
	}

	public Boolean getCargarid_sucursalProductoImpuesto() {
		return this.cargarid_sucursalProductoImpuesto;
	}

	public void setCargarid_sucursalProductoImpuesto(Boolean cargarid_sucursalProductoImpuesto) {
		this.cargarid_sucursalProductoImpuesto= cargarid_sucursalProductoImpuesto;
	}

	public Border setResaltarid_bodegaProductoImpuesto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoImpuestoBeanSwingJInternalFrame productoimpuestoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoimpuestoBeanSwingJInternalFrame.jTtoolBarProductoImpuesto.setBorder(borderResaltar);
		
		this.resaltarid_bodegaProductoImpuesto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaProductoImpuesto() {
		return this.resaltarid_bodegaProductoImpuesto;
	}

	public void setResaltarid_bodegaProductoImpuesto(Border borderResaltar) {
		this.resaltarid_bodegaProductoImpuesto= borderResaltar;
	}

	public Boolean getMostrarid_bodegaProductoImpuesto() {
		return this.mostrarid_bodegaProductoImpuesto;
	}

	public void setMostrarid_bodegaProductoImpuesto(Boolean mostrarid_bodegaProductoImpuesto) {
		this.mostrarid_bodegaProductoImpuesto= mostrarid_bodegaProductoImpuesto;
	}

	public Boolean getActivarid_bodegaProductoImpuesto() {
		return this.activarid_bodegaProductoImpuesto;
	}

	public void setActivarid_bodegaProductoImpuesto(Boolean activarid_bodegaProductoImpuesto) {
		this.activarid_bodegaProductoImpuesto= activarid_bodegaProductoImpuesto;
	}

	public Boolean getCargarid_bodegaProductoImpuesto() {
		return this.cargarid_bodegaProductoImpuesto;
	}

	public void setCargarid_bodegaProductoImpuesto(Boolean cargarid_bodegaProductoImpuesto) {
		this.cargarid_bodegaProductoImpuesto= cargarid_bodegaProductoImpuesto;
	}

	public Border setResaltarid_productoProductoImpuesto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoImpuestoBeanSwingJInternalFrame productoimpuestoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoimpuestoBeanSwingJInternalFrame.jTtoolBarProductoImpuesto.setBorder(borderResaltar);
		
		this.resaltarid_productoProductoImpuesto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProductoImpuesto() {
		return this.resaltarid_productoProductoImpuesto;
	}

	public void setResaltarid_productoProductoImpuesto(Border borderResaltar) {
		this.resaltarid_productoProductoImpuesto= borderResaltar;
	}

	public Boolean getMostrarid_productoProductoImpuesto() {
		return this.mostrarid_productoProductoImpuesto;
	}

	public void setMostrarid_productoProductoImpuesto(Boolean mostrarid_productoProductoImpuesto) {
		this.mostrarid_productoProductoImpuesto= mostrarid_productoProductoImpuesto;
	}

	public Boolean getActivarid_productoProductoImpuesto() {
		return this.activarid_productoProductoImpuesto;
	}

	public void setActivarid_productoProductoImpuesto(Boolean activarid_productoProductoImpuesto) {
		this.activarid_productoProductoImpuesto= activarid_productoProductoImpuesto;
	}

	public Boolean getCargarid_productoProductoImpuesto() {
		return this.cargarid_productoProductoImpuesto;
	}

	public void setCargarid_productoProductoImpuesto(Boolean cargarid_productoProductoImpuesto) {
		this.cargarid_productoProductoImpuesto= cargarid_productoProductoImpuesto;
	}

	public Border setResaltarid_impuesto_invenProductoImpuesto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoImpuestoBeanSwingJInternalFrame productoimpuestoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoimpuestoBeanSwingJInternalFrame.jTtoolBarProductoImpuesto.setBorder(borderResaltar);
		
		this.resaltarid_impuesto_invenProductoImpuesto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_impuesto_invenProductoImpuesto() {
		return this.resaltarid_impuesto_invenProductoImpuesto;
	}

	public void setResaltarid_impuesto_invenProductoImpuesto(Border borderResaltar) {
		this.resaltarid_impuesto_invenProductoImpuesto= borderResaltar;
	}

	public Boolean getMostrarid_impuesto_invenProductoImpuesto() {
		return this.mostrarid_impuesto_invenProductoImpuesto;
	}

	public void setMostrarid_impuesto_invenProductoImpuesto(Boolean mostrarid_impuesto_invenProductoImpuesto) {
		this.mostrarid_impuesto_invenProductoImpuesto= mostrarid_impuesto_invenProductoImpuesto;
	}

	public Boolean getActivarid_impuesto_invenProductoImpuesto() {
		return this.activarid_impuesto_invenProductoImpuesto;
	}

	public void setActivarid_impuesto_invenProductoImpuesto(Boolean activarid_impuesto_invenProductoImpuesto) {
		this.activarid_impuesto_invenProductoImpuesto= activarid_impuesto_invenProductoImpuesto;
	}

	public Boolean getCargarid_impuesto_invenProductoImpuesto() {
		return this.cargarid_impuesto_invenProductoImpuesto;
	}

	public void setCargarid_impuesto_invenProductoImpuesto(Boolean cargarid_impuesto_invenProductoImpuesto) {
		this.cargarid_impuesto_invenProductoImpuesto= cargarid_impuesto_invenProductoImpuesto;
	}

	public Border setResaltarporcentajeProductoImpuesto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoImpuestoBeanSwingJInternalFrame productoimpuestoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoimpuestoBeanSwingJInternalFrame.jTtoolBarProductoImpuesto.setBorder(borderResaltar);
		
		this.resaltarporcentajeProductoImpuesto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeProductoImpuesto() {
		return this.resaltarporcentajeProductoImpuesto;
	}

	public void setResaltarporcentajeProductoImpuesto(Border borderResaltar) {
		this.resaltarporcentajeProductoImpuesto= borderResaltar;
	}

	public Boolean getMostrarporcentajeProductoImpuesto() {
		return this.mostrarporcentajeProductoImpuesto;
	}

	public void setMostrarporcentajeProductoImpuesto(Boolean mostrarporcentajeProductoImpuesto) {
		this.mostrarporcentajeProductoImpuesto= mostrarporcentajeProductoImpuesto;
	}

	public Boolean getActivarporcentajeProductoImpuesto() {
		return this.activarporcentajeProductoImpuesto;
	}

	public void setActivarporcentajeProductoImpuesto(Boolean activarporcentajeProductoImpuesto) {
		this.activarporcentajeProductoImpuesto= activarporcentajeProductoImpuesto;
	}

	public Border setResaltarvalorProductoImpuesto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoImpuestoBeanSwingJInternalFrame productoimpuestoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoimpuestoBeanSwingJInternalFrame.jTtoolBarProductoImpuesto.setBorder(borderResaltar);
		
		this.resaltarvalorProductoImpuesto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorProductoImpuesto() {
		return this.resaltarvalorProductoImpuesto;
	}

	public void setResaltarvalorProductoImpuesto(Border borderResaltar) {
		this.resaltarvalorProductoImpuesto= borderResaltar;
	}

	public Boolean getMostrarvalorProductoImpuesto() {
		return this.mostrarvalorProductoImpuesto;
	}

	public void setMostrarvalorProductoImpuesto(Boolean mostrarvalorProductoImpuesto) {
		this.mostrarvalorProductoImpuesto= mostrarvalorProductoImpuesto;
	}

	public Boolean getActivarvalorProductoImpuesto() {
		return this.activarvalorProductoImpuesto;
	}

	public void setActivarvalorProductoImpuesto(Boolean activarvalorProductoImpuesto) {
		this.activarvalorProductoImpuesto= activarvalorProductoImpuesto;
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
		
		
		this.setMostraridProductoImpuesto(esInicial);
		this.setMostrarid_empresaProductoImpuesto(esInicial);
		this.setMostrarid_sucursalProductoImpuesto(esInicial);
		this.setMostrarid_bodegaProductoImpuesto(esInicial);
		this.setMostrarid_productoProductoImpuesto(esInicial);
		this.setMostrarid_impuesto_invenProductoImpuesto(esInicial);
		this.setMostrarporcentajeProductoImpuesto(esInicial);
		this.setMostrarvalorProductoImpuesto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.ID)) {
				this.setMostraridProductoImpuesto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProductoImpuesto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProductoImpuesto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaProductoImpuesto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProductoImpuesto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.IDIMPUESTOINVEN)) {
				this.setMostrarid_impuesto_invenProductoImpuesto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeProductoImpuesto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.VALOR)) {
				this.setMostrarvalorProductoImpuesto(esAsigna);
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
		
		
		this.setActivaridProductoImpuesto(esInicial);
		this.setActivarid_empresaProductoImpuesto(esInicial);
		this.setActivarid_sucursalProductoImpuesto(esInicial);
		this.setActivarid_bodegaProductoImpuesto(esInicial);
		this.setActivarid_productoProductoImpuesto(esInicial);
		this.setActivarid_impuesto_invenProductoImpuesto(esInicial);
		this.setActivarporcentajeProductoImpuesto(esInicial);
		this.setActivarvalorProductoImpuesto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.ID)) {
				this.setActivaridProductoImpuesto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProductoImpuesto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProductoImpuesto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaProductoImpuesto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProductoImpuesto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.IDIMPUESTOINVEN)) {
				this.setActivarid_impuesto_invenProductoImpuesto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeProductoImpuesto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.VALOR)) {
				this.setActivarvalorProductoImpuesto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoImpuestoBeanSwingJInternalFrame productoimpuestoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductoImpuesto(esInicial);
		this.setResaltarid_empresaProductoImpuesto(esInicial);
		this.setResaltarid_sucursalProductoImpuesto(esInicial);
		this.setResaltarid_bodegaProductoImpuesto(esInicial);
		this.setResaltarid_productoProductoImpuesto(esInicial);
		this.setResaltarid_impuesto_invenProductoImpuesto(esInicial);
		this.setResaltarporcentajeProductoImpuesto(esInicial);
		this.setResaltarvalorProductoImpuesto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.ID)) {
				this.setResaltaridProductoImpuesto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProductoImpuesto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProductoImpuesto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaProductoImpuesto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProductoImpuesto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.IDIMPUESTOINVEN)) {
				this.setResaltarid_impuesto_invenProductoImpuesto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeProductoImpuesto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoImpuestoConstantesFunciones.VALOR)) {
				this.setResaltarvalorProductoImpuesto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoImpuestoBeanSwingJInternalFrame productoimpuestoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaProductoImpuesto=true;

	public Boolean getMostrarFK_IdBodegaProductoImpuesto() {
		return this.mostrarFK_IdBodegaProductoImpuesto;
	}

	public void setMostrarFK_IdBodegaProductoImpuesto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaProductoImpuesto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaProductoImpuesto=true;

	public Boolean getMostrarFK_IdEmpresaProductoImpuesto() {
		return this.mostrarFK_IdEmpresaProductoImpuesto;
	}

	public void setMostrarFK_IdEmpresaProductoImpuesto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaProductoImpuesto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdImpuestoInvenProductoImpuesto=true;

	public Boolean getMostrarFK_IdImpuestoInvenProductoImpuesto() {
		return this.mostrarFK_IdImpuestoInvenProductoImpuesto;
	}

	public void setMostrarFK_IdImpuestoInvenProductoImpuesto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdImpuestoInvenProductoImpuesto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoProductoImpuesto=true;

	public Boolean getMostrarFK_IdProductoProductoImpuesto() {
		return this.mostrarFK_IdProductoProductoImpuesto;
	}

	public void setMostrarFK_IdProductoProductoImpuesto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoProductoImpuesto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalProductoImpuesto=true;

	public Boolean getMostrarFK_IdSucursalProductoImpuesto() {
		return this.mostrarFK_IdSucursalProductoImpuesto;
	}

	public void setMostrarFK_IdSucursalProductoImpuesto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalProductoImpuesto= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaProductoImpuesto=true;

	public Boolean getActivarFK_IdBodegaProductoImpuesto() {
		return this.activarFK_IdBodegaProductoImpuesto;
	}

	public void setActivarFK_IdBodegaProductoImpuesto(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaProductoImpuesto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaProductoImpuesto=true;

	public Boolean getActivarFK_IdEmpresaProductoImpuesto() {
		return this.activarFK_IdEmpresaProductoImpuesto;
	}

	public void setActivarFK_IdEmpresaProductoImpuesto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaProductoImpuesto= habilitarResaltar;
	}

	public Boolean activarFK_IdImpuestoInvenProductoImpuesto=true;

	public Boolean getActivarFK_IdImpuestoInvenProductoImpuesto() {
		return this.activarFK_IdImpuestoInvenProductoImpuesto;
	}

	public void setActivarFK_IdImpuestoInvenProductoImpuesto(Boolean habilitarResaltar) {
		this.activarFK_IdImpuestoInvenProductoImpuesto= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoProductoImpuesto=true;

	public Boolean getActivarFK_IdProductoProductoImpuesto() {
		return this.activarFK_IdProductoProductoImpuesto;
	}

	public void setActivarFK_IdProductoProductoImpuesto(Boolean habilitarResaltar) {
		this.activarFK_IdProductoProductoImpuesto= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalProductoImpuesto=true;

	public Boolean getActivarFK_IdSucursalProductoImpuesto() {
		return this.activarFK_IdSucursalProductoImpuesto;
	}

	public void setActivarFK_IdSucursalProductoImpuesto(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalProductoImpuesto= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaProductoImpuesto=null;

	public Border getResaltarFK_IdBodegaProductoImpuesto() {
		return this.resaltarFK_IdBodegaProductoImpuesto;
	}

	public void setResaltarFK_IdBodegaProductoImpuesto(Border borderResaltar) {
		this.resaltarFK_IdBodegaProductoImpuesto= borderResaltar;
	}

	public void setResaltarFK_IdBodegaProductoImpuesto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoImpuestoBeanSwingJInternalFrame productoimpuestoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaProductoImpuesto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaProductoImpuesto=null;

	public Border getResaltarFK_IdEmpresaProductoImpuesto() {
		return this.resaltarFK_IdEmpresaProductoImpuesto;
	}

	public void setResaltarFK_IdEmpresaProductoImpuesto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaProductoImpuesto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaProductoImpuesto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoImpuestoBeanSwingJInternalFrame productoimpuestoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaProductoImpuesto= borderResaltar;
	}

	public Border resaltarFK_IdImpuestoInvenProductoImpuesto=null;

	public Border getResaltarFK_IdImpuestoInvenProductoImpuesto() {
		return this.resaltarFK_IdImpuestoInvenProductoImpuesto;
	}

	public void setResaltarFK_IdImpuestoInvenProductoImpuesto(Border borderResaltar) {
		this.resaltarFK_IdImpuestoInvenProductoImpuesto= borderResaltar;
	}

	public void setResaltarFK_IdImpuestoInvenProductoImpuesto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoImpuestoBeanSwingJInternalFrame productoimpuestoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdImpuestoInvenProductoImpuesto= borderResaltar;
	}

	public Border resaltarFK_IdProductoProductoImpuesto=null;

	public Border getResaltarFK_IdProductoProductoImpuesto() {
		return this.resaltarFK_IdProductoProductoImpuesto;
	}

	public void setResaltarFK_IdProductoProductoImpuesto(Border borderResaltar) {
		this.resaltarFK_IdProductoProductoImpuesto= borderResaltar;
	}

	public void setResaltarFK_IdProductoProductoImpuesto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoImpuestoBeanSwingJInternalFrame productoimpuestoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoProductoImpuesto= borderResaltar;
	}

	public Border resaltarFK_IdSucursalProductoImpuesto=null;

	public Border getResaltarFK_IdSucursalProductoImpuesto() {
		return this.resaltarFK_IdSucursalProductoImpuesto;
	}

	public void setResaltarFK_IdSucursalProductoImpuesto(Border borderResaltar) {
		this.resaltarFK_IdSucursalProductoImpuesto= borderResaltar;
	}

	public void setResaltarFK_IdSucursalProductoImpuesto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoImpuestoBeanSwingJInternalFrame productoimpuestoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalProductoImpuesto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}