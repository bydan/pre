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


import com.bydan.erp.inventario.util.ProductoProveedorConstantesFunciones;
import com.bydan.erp.inventario.util.ProductoProveedorParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ProductoProveedorParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProductoProveedorConstantesFunciones extends ProductoProveedorConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProductoProveedor";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductoProveedor"+ProductoProveedorConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductoProveedorHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductoProveedorHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductoProveedorConstantesFunciones.SCHEMA+"_"+ProductoProveedorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductoProveedorHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductoProveedorConstantesFunciones.SCHEMA+"_"+ProductoProveedorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductoProveedorConstantesFunciones.SCHEMA+"_"+ProductoProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductoProveedorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductoProveedorConstantesFunciones.SCHEMA+"_"+ProductoProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoProveedorHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoProveedorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductoProveedorConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductoProveedorConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductoProveedorConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductoProveedorConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Producto Proveedors";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Producto Proveedor";
	public static final String SCLASSWEBTITULO_LOWER="Producto Proveedor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductoProveedor";
	public static final String OBJECTNAME="productoproveedor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="producto_proveedord";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productoproveedor from "+ProductoProveedorConstantesFunciones.SPERSISTENCENAME+" productoproveedor";
	public static String QUERYSELECTNATIVE="select "+ProductoProveedorConstantesFunciones.SCHEMA+"."+ProductoProveedorConstantesFunciones.TABLENAME+".id,"+ProductoProveedorConstantesFunciones.SCHEMA+"."+ProductoProveedorConstantesFunciones.TABLENAME+".version_row,"+ProductoProveedorConstantesFunciones.SCHEMA+"."+ProductoProveedorConstantesFunciones.TABLENAME+".id_empresa,"+ProductoProveedorConstantesFunciones.SCHEMA+"."+ProductoProveedorConstantesFunciones.TABLENAME+".id_sucursal,"+ProductoProveedorConstantesFunciones.SCHEMA+"."+ProductoProveedorConstantesFunciones.TABLENAME+".id_bodega,"+ProductoProveedorConstantesFunciones.SCHEMA+"."+ProductoProveedorConstantesFunciones.TABLENAME+".id_producto,"+ProductoProveedorConstantesFunciones.SCHEMA+"."+ProductoProveedorConstantesFunciones.TABLENAME+".id_cliente,"+ProductoProveedorConstantesFunciones.SCHEMA+"."+ProductoProveedorConstantesFunciones.TABLENAME+".precio_ultimo,"+ProductoProveedorConstantesFunciones.SCHEMA+"."+ProductoProveedorConstantesFunciones.TABLENAME+".precio_acuerdo,"+ProductoProveedorConstantesFunciones.SCHEMA+"."+ProductoProveedorConstantesFunciones.TABLENAME+".dia_entra,"+ProductoProveedorConstantesFunciones.SCHEMA+"."+ProductoProveedorConstantesFunciones.TABLENAME+".observacion from "+ProductoProveedorConstantesFunciones.SCHEMA+"."+ProductoProveedorConstantesFunciones.TABLENAME;//+" as "+ProductoProveedorConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProductoProveedorConstantesFuncionesAdditional productoproveedorConstantesFuncionesAdditional=null;
	
	public ProductoProveedorConstantesFuncionesAdditional getProductoProveedorConstantesFuncionesAdditional() {
		return this.productoproveedorConstantesFuncionesAdditional;
	}
	
	public void setProductoProveedorConstantesFuncionesAdditional(ProductoProveedorConstantesFuncionesAdditional productoproveedorConstantesFuncionesAdditional) {
		try {
			this.productoproveedorConstantesFuncionesAdditional=productoproveedorConstantesFuncionesAdditional;
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
    public static final String IDCLIENTE= "id_cliente";
    public static final String PRECIOULTIMO= "precio_ultimo";
    public static final String PRECIOACUERDO= "precio_acuerdo";
    public static final String DIAENTRA= "dia_entra";
    public static final String OBSERVACION= "observacion";
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
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_PRECIOULTIMO= "Precio Ultimo";
		public static final String LABEL_PRECIOULTIMO_LOWER= "Precio Ultimo";
    	public static final String LABEL_PRECIOACUERDO= "Precio Acuerdo";
		public static final String LABEL_PRECIOACUERDO_LOWER= "Precio Acuerdo";
    	public static final String LABEL_DIAENTRA= "Dia Entra";
		public static final String LABEL_DIAENTRA_LOWER= "Dia Entra";
    	public static final String LABEL_OBSERVACION= "Observacion";
		public static final String LABEL_OBSERVACION_LOWER= "Observacion";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXOBSERVACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXOBSERVACION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProductoProveedorLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductoProveedorConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProductoProveedorConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProductoProveedorConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProductoProveedorConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProductoProveedorConstantesFunciones.IDBODEGA)) {sLabelColumna=ProductoProveedorConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ProductoProveedorConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProductoProveedorConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProductoProveedorConstantesFunciones.IDCLIENTE)) {sLabelColumna=ProductoProveedorConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ProductoProveedorConstantesFunciones.PRECIOULTIMO)) {sLabelColumna=ProductoProveedorConstantesFunciones.LABEL_PRECIOULTIMO;}
		if(sNombreColumna.equals(ProductoProveedorConstantesFunciones.PRECIOACUERDO)) {sLabelColumna=ProductoProveedorConstantesFunciones.LABEL_PRECIOACUERDO;}
		if(sNombreColumna.equals(ProductoProveedorConstantesFunciones.DIAENTRA)) {sLabelColumna=ProductoProveedorConstantesFunciones.LABEL_DIAENTRA;}
		if(sNombreColumna.equals(ProductoProveedorConstantesFunciones.OBSERVACION)) {sLabelColumna=ProductoProveedorConstantesFunciones.LABEL_OBSERVACION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProductoProveedorDescripcion(ProductoProveedor productoproveedor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productoproveedor !=null/* && productoproveedor.getId()!=0*/) {
			if(productoproveedor.getId()!=null) {
				sDescripcion=productoproveedor.getId().toString();
			}//productoproveedorproductoproveedor.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductoProveedorDescripcionDetallado(ProductoProveedor productoproveedor) {
		String sDescripcion="";
			
		sDescripcion+=ProductoProveedorConstantesFunciones.ID+"=";
		sDescripcion+=productoproveedor.getId().toString()+",";
		sDescripcion+=ProductoProveedorConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productoproveedor.getVersionRow().toString()+",";
		sDescripcion+=ProductoProveedorConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=productoproveedor.getid_empresa().toString()+",";
		sDescripcion+=ProductoProveedorConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=productoproveedor.getid_sucursal().toString()+",";
		sDescripcion+=ProductoProveedorConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=productoproveedor.getid_bodega().toString()+",";
		sDescripcion+=ProductoProveedorConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=productoproveedor.getid_producto().toString()+",";
		sDescripcion+=ProductoProveedorConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=productoproveedor.getid_cliente().toString()+",";
		sDescripcion+=ProductoProveedorConstantesFunciones.PRECIOULTIMO+"=";
		sDescripcion+=productoproveedor.getprecio_ultimo().toString()+",";
		sDescripcion+=ProductoProveedorConstantesFunciones.PRECIOACUERDO+"=";
		sDescripcion+=productoproveedor.getprecio_acuerdo().toString()+",";
		sDescripcion+=ProductoProveedorConstantesFunciones.DIAENTRA+"=";
		sDescripcion+=productoproveedor.getdia_entra().toString()+",";
		sDescripcion+=ProductoProveedorConstantesFunciones.OBSERVACION+"=";
		sDescripcion+=productoproveedor.getobservacion()+",";
			
		return sDescripcion;
	}
	
	public static void setProductoProveedorDescripcion(ProductoProveedor productoproveedor,String sValor) throws Exception {			
		if(productoproveedor !=null) {
			//productoproveedorproductoproveedor.getId().toString();
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

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
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
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
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

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosProductoProveedor(ProductoProveedor productoproveedor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productoproveedor.setobservacion(productoproveedor.getobservacion().trim());
	}
	
	public static void quitarEspaciosProductoProveedors(List<ProductoProveedor> productoproveedors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoProveedor productoproveedor: productoproveedors) {
			productoproveedor.setobservacion(productoproveedor.getobservacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoProveedor(ProductoProveedor productoproveedor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productoproveedor.getConCambioAuxiliar()) {
			productoproveedor.setIsDeleted(productoproveedor.getIsDeletedAuxiliar());	
			productoproveedor.setIsNew(productoproveedor.getIsNewAuxiliar());	
			productoproveedor.setIsChanged(productoproveedor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productoproveedor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productoproveedor.setIsDeletedAuxiliar(false);	
			productoproveedor.setIsNewAuxiliar(false);	
			productoproveedor.setIsChangedAuxiliar(false);
			
			productoproveedor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoProveedors(List<ProductoProveedor> productoproveedors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductoProveedor productoproveedor : productoproveedors) {
			if(conAsignarBase && productoproveedor.getConCambioAuxiliar()) {
				productoproveedor.setIsDeleted(productoproveedor.getIsDeletedAuxiliar());	
				productoproveedor.setIsNew(productoproveedor.getIsNewAuxiliar());	
				productoproveedor.setIsChanged(productoproveedor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productoproveedor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productoproveedor.setIsDeletedAuxiliar(false);	
				productoproveedor.setIsNewAuxiliar(false);	
				productoproveedor.setIsChangedAuxiliar(false);
				
				productoproveedor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductoProveedor(ProductoProveedor productoproveedor,Boolean conEnteros) throws Exception  {
		productoproveedor.setprecio_ultimo(0.0);
		productoproveedor.setprecio_acuerdo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			productoproveedor.setdia_entra(0);
		}
	}		
	
	public static void InicializarValoresProductoProveedors(List<ProductoProveedor> productoproveedors,Boolean conEnteros) throws Exception  {
		
		for(ProductoProveedor productoproveedor: productoproveedors) {
			productoproveedor.setprecio_ultimo(0.0);
			productoproveedor.setprecio_acuerdo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				productoproveedor.setdia_entra(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductoProveedor(List<ProductoProveedor> productoproveedors,ProductoProveedor productoproveedorAux) throws Exception  {
		ProductoProveedorConstantesFunciones.InicializarValoresProductoProveedor(productoproveedorAux,true);
		
		for(ProductoProveedor productoproveedor: productoproveedors) {
			if(productoproveedor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productoproveedorAux.setprecio_ultimo(productoproveedorAux.getprecio_ultimo()+productoproveedor.getprecio_ultimo());			
			productoproveedorAux.setprecio_acuerdo(productoproveedorAux.getprecio_acuerdo()+productoproveedor.getprecio_acuerdo());			
			productoproveedorAux.setdia_entra(productoproveedorAux.getdia_entra()+productoproveedor.getdia_entra());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoProveedor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductoProveedorConstantesFunciones.getArrayColumnasGlobalesProductoProveedor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoProveedor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductoProveedorConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductoProveedorConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductoProveedorConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductoProveedorConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductoProveedor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoProveedor> productoproveedors,ProductoProveedor productoproveedor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoProveedor productoproveedorAux: productoproveedors) {
			if(productoproveedorAux!=null && productoproveedor!=null) {
				if((productoproveedorAux.getId()==null && productoproveedor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productoproveedorAux.getId()!=null && productoproveedor.getId()!=null){
					if(productoproveedorAux.getId().equals(productoproveedor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoProveedor(List<ProductoProveedor> productoproveedors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precio_ultimoTotal=0.0;
		Double precio_acuerdoTotal=0.0;
	
		for(ProductoProveedor productoproveedor: productoproveedors) {			
			if(productoproveedor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precio_ultimoTotal+=productoproveedor.getprecio_ultimo();
			precio_acuerdoTotal+=productoproveedor.getprecio_acuerdo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoProveedorConstantesFunciones.PRECIOULTIMO);
		datoGeneral.setsDescripcion(ProductoProveedorConstantesFunciones.LABEL_PRECIOULTIMO);
		datoGeneral.setdValorDouble(precio_ultimoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoProveedorConstantesFunciones.PRECIOACUERDO);
		datoGeneral.setsDescripcion(ProductoProveedorConstantesFunciones.LABEL_PRECIOACUERDO);
		datoGeneral.setdValorDouble(precio_acuerdoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductoProveedor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductoProveedorConstantesFunciones.LABEL_ID, ProductoProveedorConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProveedorConstantesFunciones.LABEL_VERSIONROW, ProductoProveedorConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProveedorConstantesFunciones.LABEL_IDEMPRESA, ProductoProveedorConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProveedorConstantesFunciones.LABEL_IDSUCURSAL, ProductoProveedorConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProveedorConstantesFunciones.LABEL_IDBODEGA, ProductoProveedorConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProveedorConstantesFunciones.LABEL_IDPRODUCTO, ProductoProveedorConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProveedorConstantesFunciones.LABEL_IDCLIENTE, ProductoProveedorConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProveedorConstantesFunciones.LABEL_PRECIOULTIMO, ProductoProveedorConstantesFunciones.PRECIOULTIMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProveedorConstantesFunciones.LABEL_PRECIOACUERDO, ProductoProveedorConstantesFunciones.PRECIOACUERDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProveedorConstantesFunciones.LABEL_DIAENTRA, ProductoProveedorConstantesFunciones.DIAENTRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProveedorConstantesFunciones.LABEL_OBSERVACION, ProductoProveedorConstantesFunciones.OBSERVACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductoProveedor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductoProveedorConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProveedorConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProveedorConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProveedorConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProveedorConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProveedorConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProveedorConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProveedorConstantesFunciones.PRECIOULTIMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProveedorConstantesFunciones.PRECIOACUERDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProveedorConstantesFunciones.DIAENTRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProveedorConstantesFunciones.OBSERVACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoProveedor() throws Exception  {
		return ProductoProveedorConstantesFunciones.getTiposSeleccionarProductoProveedor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoProveedor(Boolean conFk) throws Exception  {
		return ProductoProveedorConstantesFunciones.getTiposSeleccionarProductoProveedor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoProveedor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProveedorConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProductoProveedorConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProveedorConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProductoProveedorConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProveedorConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ProductoProveedorConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProveedorConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProductoProveedorConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProveedorConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ProductoProveedorConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProveedorConstantesFunciones.LABEL_PRECIOULTIMO);
			reporte.setsDescripcion(ProductoProveedorConstantesFunciones.LABEL_PRECIOULTIMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProveedorConstantesFunciones.LABEL_PRECIOACUERDO);
			reporte.setsDescripcion(ProductoProveedorConstantesFunciones.LABEL_PRECIOACUERDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProveedorConstantesFunciones.LABEL_DIAENTRA);
			reporte.setsDescripcion(ProductoProveedorConstantesFunciones.LABEL_DIAENTRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProveedorConstantesFunciones.LABEL_OBSERVACION);
			reporte.setsDescripcion(ProductoProveedorConstantesFunciones.LABEL_OBSERVACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductoProveedor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductoProveedor(ProductoProveedor productoproveedorAux) throws Exception {
		
			productoproveedorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productoproveedorAux.getEmpresa()));
			productoproveedorAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productoproveedorAux.getSucursal()));
			productoproveedorAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productoproveedorAux.getBodega()));
			productoproveedorAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productoproveedorAux.getProducto()));
			productoproveedorAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(productoproveedorAux.getCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductoProveedor(List<ProductoProveedor> productoproveedorsTemp) throws Exception {
		for(ProductoProveedor productoproveedorAux:productoproveedorsTemp) {
			
			productoproveedorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productoproveedorAux.getEmpresa()));
			productoproveedorAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productoproveedorAux.getSucursal()));
			productoproveedorAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productoproveedorAux.getBodega()));
			productoproveedorAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productoproveedorAux.getProducto()));
			productoproveedorAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(productoproveedorAux.getCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductoProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Cliente.class));
				
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
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductoProveedor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoProveedorConstantesFunciones.getClassesRelationshipsOfProductoProveedor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoProveedor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoProveedorConstantesFunciones.getClassesRelationshipsFromStringsOfProductoProveedor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoProveedor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductoProveedor productoproveedor,List<ProductoProveedor> productoproveedors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProductoProveedor productoproveedorEncontrado=null;
			
			for(ProductoProveedor productoproveedorLocal:productoproveedors) {
				if(productoproveedorLocal.getId().equals(productoproveedor.getId())) {
					productoproveedorEncontrado=productoproveedorLocal;
					
					productoproveedorLocal.setIsChanged(productoproveedor.getIsChanged());
					productoproveedorLocal.setIsNew(productoproveedor.getIsNew());
					productoproveedorLocal.setIsDeleted(productoproveedor.getIsDeleted());
					
					productoproveedorLocal.setGeneralEntityOriginal(productoproveedor.getGeneralEntityOriginal());
					
					productoproveedorLocal.setId(productoproveedor.getId());	
					productoproveedorLocal.setVersionRow(productoproveedor.getVersionRow());	
					productoproveedorLocal.setid_empresa(productoproveedor.getid_empresa());	
					productoproveedorLocal.setid_sucursal(productoproveedor.getid_sucursal());	
					productoproveedorLocal.setid_bodega(productoproveedor.getid_bodega());	
					productoproveedorLocal.setid_producto(productoproveedor.getid_producto());	
					productoproveedorLocal.setid_cliente(productoproveedor.getid_cliente());	
					productoproveedorLocal.setprecio_ultimo(productoproveedor.getprecio_ultimo());	
					productoproveedorLocal.setprecio_acuerdo(productoproveedor.getprecio_acuerdo());	
					productoproveedorLocal.setdia_entra(productoproveedor.getdia_entra());	
					productoproveedorLocal.setobservacion(productoproveedor.getobservacion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!productoproveedor.getIsDeleted()) {
				if(!existe) {
					productoproveedors.add(productoproveedor);
				}
			} else {
				if(productoproveedorEncontrado!=null && permiteQuitar)  {
					productoproveedors.remove(productoproveedorEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProductoProveedor productoproveedor,List<ProductoProveedor> productoproveedors) throws Exception {
		try	{			
			for(ProductoProveedor productoproveedorLocal:productoproveedors) {
				if(productoproveedorLocal.getId().equals(productoproveedor.getId())) {
					productoproveedorLocal.setIsSelected(productoproveedor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductoProveedor(List<ProductoProveedor> productoproveedorsAux) throws Exception {
		//this.productoproveedorsAux=productoproveedorsAux;
		
		for(ProductoProveedor productoproveedorAux:productoproveedorsAux) {
			if(productoproveedorAux.getIsChanged()) {
				productoproveedorAux.setIsChanged(false);
			}		
			
			if(productoproveedorAux.getIsNew()) {
				productoproveedorAux.setIsNew(false);
			}	
			
			if(productoproveedorAux.getIsDeleted()) {
				productoproveedorAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductoProveedor(ProductoProveedor productoproveedorAux) throws Exception {
		//this.productoproveedorAux=productoproveedorAux;
		
			if(productoproveedorAux.getIsChanged()) {
				productoproveedorAux.setIsChanged(false);
			}		
			
			if(productoproveedorAux.getIsNew()) {
				productoproveedorAux.setIsNew(false);
			}	
			
			if(productoproveedorAux.getIsDeleted()) {
				productoproveedorAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductoProveedor productoproveedorAsignar,ProductoProveedor productoproveedor) throws Exception {
		productoproveedorAsignar.setId(productoproveedor.getId());	
		productoproveedorAsignar.setVersionRow(productoproveedor.getVersionRow());	
		productoproveedorAsignar.setid_empresa(productoproveedor.getid_empresa());
		productoproveedorAsignar.setempresa_descripcion(productoproveedor.getempresa_descripcion());	
		productoproveedorAsignar.setid_sucursal(productoproveedor.getid_sucursal());
		productoproveedorAsignar.setsucursal_descripcion(productoproveedor.getsucursal_descripcion());	
		productoproveedorAsignar.setid_bodega(productoproveedor.getid_bodega());
		productoproveedorAsignar.setbodega_descripcion(productoproveedor.getbodega_descripcion());	
		productoproveedorAsignar.setid_producto(productoproveedor.getid_producto());
		productoproveedorAsignar.setproducto_descripcion(productoproveedor.getproducto_descripcion());	
		productoproveedorAsignar.setid_cliente(productoproveedor.getid_cliente());
		productoproveedorAsignar.setcliente_descripcion(productoproveedor.getcliente_descripcion());	
		productoproveedorAsignar.setprecio_ultimo(productoproveedor.getprecio_ultimo());	
		productoproveedorAsignar.setprecio_acuerdo(productoproveedor.getprecio_acuerdo());	
		productoproveedorAsignar.setdia_entra(productoproveedor.getdia_entra());	
		productoproveedorAsignar.setobservacion(productoproveedor.getobservacion());	
	}
	
	public static void inicializarProductoProveedor(ProductoProveedor productoproveedor) throws Exception {
		try {
				productoproveedor.setId(0L);	
					
				productoproveedor.setid_empresa(-1L);	
				productoproveedor.setid_sucursal(-1L);	
				productoproveedor.setid_bodega(-1L);	
				productoproveedor.setid_producto(-1L);	
				productoproveedor.setid_cliente(-1L);	
				productoproveedor.setprecio_ultimo(0.0);	
				productoproveedor.setprecio_acuerdo(0.0);	
				productoproveedor.setdia_entra(0);	
				productoproveedor.setobservacion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductoProveedor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProveedorConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProveedorConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProveedorConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProveedorConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProveedorConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProveedorConstantesFunciones.LABEL_PRECIOULTIMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProveedorConstantesFunciones.LABEL_PRECIOACUERDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProveedorConstantesFunciones.LABEL_DIAENTRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProveedorConstantesFunciones.LABEL_OBSERVACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductoProveedor(String sTipo,Row row,Workbook workbook,ProductoProveedor productoproveedor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productoproveedor.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoproveedor.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoproveedor.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoproveedor.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoproveedor.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoproveedor.getprecio_ultimo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoproveedor.getprecio_acuerdo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoproveedor.getdia_entra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoproveedor.getobservacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductoProveedor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProductoProveedor() {
		return this.sFinalQueryProductoProveedor;
	}
	
	public void setsFinalQueryProductoProveedor(String sFinalQueryProductoProveedor) {
		this.sFinalQueryProductoProveedor= sFinalQueryProductoProveedor;
	}
	
	public Border resaltarSeleccionarProductoProveedor=null;
	
	public Border setResaltarSeleccionarProductoProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProveedorBeanSwingJInternalFrame productoproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productoproveedorBeanSwingJInternalFrame.jTtoolBarProductoProveedor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductoProveedor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductoProveedor() {
		return this.resaltarSeleccionarProductoProveedor;
	}
	
	public void setResaltarSeleccionarProductoProveedor(Border borderResaltarSeleccionarProductoProveedor) {
		this.resaltarSeleccionarProductoProveedor= borderResaltarSeleccionarProductoProveedor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductoProveedor=null;
	public Boolean mostraridProductoProveedor=true;
	public Boolean activaridProductoProveedor=true;

	public Border resaltarid_empresaProductoProveedor=null;
	public Boolean mostrarid_empresaProductoProveedor=true;
	public Boolean activarid_empresaProductoProveedor=true;
	public Boolean cargarid_empresaProductoProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProductoProveedor=false;//ConEventDepend=true

	public Border resaltarid_sucursalProductoProveedor=null;
	public Boolean mostrarid_sucursalProductoProveedor=true;
	public Boolean activarid_sucursalProductoProveedor=true;
	public Boolean cargarid_sucursalProductoProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProductoProveedor=false;//ConEventDepend=true

	public Border resaltarid_bodegaProductoProveedor=null;
	public Boolean mostrarid_bodegaProductoProveedor=true;
	public Boolean activarid_bodegaProductoProveedor=true;
	public Boolean cargarid_bodegaProductoProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaProductoProveedor=false;//ConEventDepend=true

	public Border resaltarid_productoProductoProveedor=null;
	public Boolean mostrarid_productoProductoProveedor=true;
	public Boolean activarid_productoProductoProveedor=true;
	public Boolean cargarid_productoProductoProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProductoProveedor=false;//ConEventDepend=true

	public Border resaltarid_clienteProductoProveedor=null;
	public Boolean mostrarid_clienteProductoProveedor=true;
	public Boolean activarid_clienteProductoProveedor=true;
	public Boolean cargarid_clienteProductoProveedor=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteProductoProveedor=false;//ConEventDepend=true

	public Border resaltarprecio_ultimoProductoProveedor=null;
	public Boolean mostrarprecio_ultimoProductoProveedor=true;
	public Boolean activarprecio_ultimoProductoProveedor=true;

	public Border resaltarprecio_acuerdoProductoProveedor=null;
	public Boolean mostrarprecio_acuerdoProductoProveedor=true;
	public Boolean activarprecio_acuerdoProductoProveedor=true;

	public Border resaltardia_entraProductoProveedor=null;
	public Boolean mostrardia_entraProductoProveedor=true;
	public Boolean activardia_entraProductoProveedor=true;

	public Border resaltarobservacionProductoProveedor=null;
	public Boolean mostrarobservacionProductoProveedor=true;
	public Boolean activarobservacionProductoProveedor=true;

	
	

	public Border setResaltaridProductoProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProveedorBeanSwingJInternalFrame productoproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoproveedorBeanSwingJInternalFrame.jTtoolBarProductoProveedor.setBorder(borderResaltar);
		
		this.resaltaridProductoProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductoProveedor() {
		return this.resaltaridProductoProveedor;
	}

	public void setResaltaridProductoProveedor(Border borderResaltar) {
		this.resaltaridProductoProveedor= borderResaltar;
	}

	public Boolean getMostraridProductoProveedor() {
		return this.mostraridProductoProveedor;
	}

	public void setMostraridProductoProveedor(Boolean mostraridProductoProveedor) {
		this.mostraridProductoProveedor= mostraridProductoProveedor;
	}

	public Boolean getActivaridProductoProveedor() {
		return this.activaridProductoProveedor;
	}

	public void setActivaridProductoProveedor(Boolean activaridProductoProveedor) {
		this.activaridProductoProveedor= activaridProductoProveedor;
	}

	public Border setResaltarid_empresaProductoProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProveedorBeanSwingJInternalFrame productoproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoproveedorBeanSwingJInternalFrame.jTtoolBarProductoProveedor.setBorder(borderResaltar);
		
		this.resaltarid_empresaProductoProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProductoProveedor() {
		return this.resaltarid_empresaProductoProveedor;
	}

	public void setResaltarid_empresaProductoProveedor(Border borderResaltar) {
		this.resaltarid_empresaProductoProveedor= borderResaltar;
	}

	public Boolean getMostrarid_empresaProductoProveedor() {
		return this.mostrarid_empresaProductoProveedor;
	}

	public void setMostrarid_empresaProductoProveedor(Boolean mostrarid_empresaProductoProveedor) {
		this.mostrarid_empresaProductoProveedor= mostrarid_empresaProductoProveedor;
	}

	public Boolean getActivarid_empresaProductoProveedor() {
		return this.activarid_empresaProductoProveedor;
	}

	public void setActivarid_empresaProductoProveedor(Boolean activarid_empresaProductoProveedor) {
		this.activarid_empresaProductoProveedor= activarid_empresaProductoProveedor;
	}

	public Boolean getCargarid_empresaProductoProveedor() {
		return this.cargarid_empresaProductoProveedor;
	}

	public void setCargarid_empresaProductoProveedor(Boolean cargarid_empresaProductoProveedor) {
		this.cargarid_empresaProductoProveedor= cargarid_empresaProductoProveedor;
	}

	public Border setResaltarid_sucursalProductoProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProveedorBeanSwingJInternalFrame productoproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoproveedorBeanSwingJInternalFrame.jTtoolBarProductoProveedor.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProductoProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProductoProveedor() {
		return this.resaltarid_sucursalProductoProveedor;
	}

	public void setResaltarid_sucursalProductoProveedor(Border borderResaltar) {
		this.resaltarid_sucursalProductoProveedor= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProductoProveedor() {
		return this.mostrarid_sucursalProductoProveedor;
	}

	public void setMostrarid_sucursalProductoProveedor(Boolean mostrarid_sucursalProductoProveedor) {
		this.mostrarid_sucursalProductoProveedor= mostrarid_sucursalProductoProveedor;
	}

	public Boolean getActivarid_sucursalProductoProveedor() {
		return this.activarid_sucursalProductoProveedor;
	}

	public void setActivarid_sucursalProductoProveedor(Boolean activarid_sucursalProductoProveedor) {
		this.activarid_sucursalProductoProveedor= activarid_sucursalProductoProveedor;
	}

	public Boolean getCargarid_sucursalProductoProveedor() {
		return this.cargarid_sucursalProductoProveedor;
	}

	public void setCargarid_sucursalProductoProveedor(Boolean cargarid_sucursalProductoProveedor) {
		this.cargarid_sucursalProductoProveedor= cargarid_sucursalProductoProveedor;
	}

	public Border setResaltarid_bodegaProductoProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProveedorBeanSwingJInternalFrame productoproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoproveedorBeanSwingJInternalFrame.jTtoolBarProductoProveedor.setBorder(borderResaltar);
		
		this.resaltarid_bodegaProductoProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaProductoProveedor() {
		return this.resaltarid_bodegaProductoProveedor;
	}

	public void setResaltarid_bodegaProductoProveedor(Border borderResaltar) {
		this.resaltarid_bodegaProductoProveedor= borderResaltar;
	}

	public Boolean getMostrarid_bodegaProductoProveedor() {
		return this.mostrarid_bodegaProductoProveedor;
	}

	public void setMostrarid_bodegaProductoProveedor(Boolean mostrarid_bodegaProductoProveedor) {
		this.mostrarid_bodegaProductoProveedor= mostrarid_bodegaProductoProveedor;
	}

	public Boolean getActivarid_bodegaProductoProveedor() {
		return this.activarid_bodegaProductoProveedor;
	}

	public void setActivarid_bodegaProductoProveedor(Boolean activarid_bodegaProductoProveedor) {
		this.activarid_bodegaProductoProveedor= activarid_bodegaProductoProveedor;
	}

	public Boolean getCargarid_bodegaProductoProveedor() {
		return this.cargarid_bodegaProductoProveedor;
	}

	public void setCargarid_bodegaProductoProveedor(Boolean cargarid_bodegaProductoProveedor) {
		this.cargarid_bodegaProductoProveedor= cargarid_bodegaProductoProveedor;
	}

	public Border setResaltarid_productoProductoProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProveedorBeanSwingJInternalFrame productoproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoproveedorBeanSwingJInternalFrame.jTtoolBarProductoProveedor.setBorder(borderResaltar);
		
		this.resaltarid_productoProductoProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProductoProveedor() {
		return this.resaltarid_productoProductoProveedor;
	}

	public void setResaltarid_productoProductoProveedor(Border borderResaltar) {
		this.resaltarid_productoProductoProveedor= borderResaltar;
	}

	public Boolean getMostrarid_productoProductoProveedor() {
		return this.mostrarid_productoProductoProveedor;
	}

	public void setMostrarid_productoProductoProveedor(Boolean mostrarid_productoProductoProveedor) {
		this.mostrarid_productoProductoProveedor= mostrarid_productoProductoProveedor;
	}

	public Boolean getActivarid_productoProductoProveedor() {
		return this.activarid_productoProductoProveedor;
	}

	public void setActivarid_productoProductoProveedor(Boolean activarid_productoProductoProveedor) {
		this.activarid_productoProductoProveedor= activarid_productoProductoProveedor;
	}

	public Boolean getCargarid_productoProductoProveedor() {
		return this.cargarid_productoProductoProveedor;
	}

	public void setCargarid_productoProductoProveedor(Boolean cargarid_productoProductoProveedor) {
		this.cargarid_productoProductoProveedor= cargarid_productoProductoProveedor;
	}

	public Border setResaltarid_clienteProductoProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProveedorBeanSwingJInternalFrame productoproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoproveedorBeanSwingJInternalFrame.jTtoolBarProductoProveedor.setBorder(borderResaltar);
		
		this.resaltarid_clienteProductoProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteProductoProveedor() {
		return this.resaltarid_clienteProductoProveedor;
	}

	public void setResaltarid_clienteProductoProveedor(Border borderResaltar) {
		this.resaltarid_clienteProductoProveedor= borderResaltar;
	}

	public Boolean getMostrarid_clienteProductoProveedor() {
		return this.mostrarid_clienteProductoProveedor;
	}

	public void setMostrarid_clienteProductoProveedor(Boolean mostrarid_clienteProductoProveedor) {
		this.mostrarid_clienteProductoProveedor= mostrarid_clienteProductoProveedor;
	}

	public Boolean getActivarid_clienteProductoProveedor() {
		return this.activarid_clienteProductoProveedor;
	}

	public void setActivarid_clienteProductoProveedor(Boolean activarid_clienteProductoProveedor) {
		this.activarid_clienteProductoProveedor= activarid_clienteProductoProveedor;
	}

	public Boolean getCargarid_clienteProductoProveedor() {
		return this.cargarid_clienteProductoProveedor;
	}

	public void setCargarid_clienteProductoProveedor(Boolean cargarid_clienteProductoProveedor) {
		this.cargarid_clienteProductoProveedor= cargarid_clienteProductoProveedor;
	}

	public Border setResaltarprecio_ultimoProductoProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProveedorBeanSwingJInternalFrame productoproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoproveedorBeanSwingJInternalFrame.jTtoolBarProductoProveedor.setBorder(borderResaltar);
		
		this.resaltarprecio_ultimoProductoProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecio_ultimoProductoProveedor() {
		return this.resaltarprecio_ultimoProductoProveedor;
	}

	public void setResaltarprecio_ultimoProductoProveedor(Border borderResaltar) {
		this.resaltarprecio_ultimoProductoProveedor= borderResaltar;
	}

	public Boolean getMostrarprecio_ultimoProductoProveedor() {
		return this.mostrarprecio_ultimoProductoProveedor;
	}

	public void setMostrarprecio_ultimoProductoProveedor(Boolean mostrarprecio_ultimoProductoProveedor) {
		this.mostrarprecio_ultimoProductoProveedor= mostrarprecio_ultimoProductoProveedor;
	}

	public Boolean getActivarprecio_ultimoProductoProveedor() {
		return this.activarprecio_ultimoProductoProveedor;
	}

	public void setActivarprecio_ultimoProductoProveedor(Boolean activarprecio_ultimoProductoProveedor) {
		this.activarprecio_ultimoProductoProveedor= activarprecio_ultimoProductoProveedor;
	}

	public Border setResaltarprecio_acuerdoProductoProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProveedorBeanSwingJInternalFrame productoproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoproveedorBeanSwingJInternalFrame.jTtoolBarProductoProveedor.setBorder(borderResaltar);
		
		this.resaltarprecio_acuerdoProductoProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecio_acuerdoProductoProveedor() {
		return this.resaltarprecio_acuerdoProductoProveedor;
	}

	public void setResaltarprecio_acuerdoProductoProveedor(Border borderResaltar) {
		this.resaltarprecio_acuerdoProductoProveedor= borderResaltar;
	}

	public Boolean getMostrarprecio_acuerdoProductoProveedor() {
		return this.mostrarprecio_acuerdoProductoProveedor;
	}

	public void setMostrarprecio_acuerdoProductoProveedor(Boolean mostrarprecio_acuerdoProductoProveedor) {
		this.mostrarprecio_acuerdoProductoProveedor= mostrarprecio_acuerdoProductoProveedor;
	}

	public Boolean getActivarprecio_acuerdoProductoProveedor() {
		return this.activarprecio_acuerdoProductoProveedor;
	}

	public void setActivarprecio_acuerdoProductoProveedor(Boolean activarprecio_acuerdoProductoProveedor) {
		this.activarprecio_acuerdoProductoProveedor= activarprecio_acuerdoProductoProveedor;
	}

	public Border setResaltardia_entraProductoProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProveedorBeanSwingJInternalFrame productoproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoproveedorBeanSwingJInternalFrame.jTtoolBarProductoProveedor.setBorder(borderResaltar);
		
		this.resaltardia_entraProductoProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardia_entraProductoProveedor() {
		return this.resaltardia_entraProductoProveedor;
	}

	public void setResaltardia_entraProductoProveedor(Border borderResaltar) {
		this.resaltardia_entraProductoProveedor= borderResaltar;
	}

	public Boolean getMostrardia_entraProductoProveedor() {
		return this.mostrardia_entraProductoProveedor;
	}

	public void setMostrardia_entraProductoProveedor(Boolean mostrardia_entraProductoProveedor) {
		this.mostrardia_entraProductoProveedor= mostrardia_entraProductoProveedor;
	}

	public Boolean getActivardia_entraProductoProveedor() {
		return this.activardia_entraProductoProveedor;
	}

	public void setActivardia_entraProductoProveedor(Boolean activardia_entraProductoProveedor) {
		this.activardia_entraProductoProveedor= activardia_entraProductoProveedor;
	}

	public Border setResaltarobservacionProductoProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProveedorBeanSwingJInternalFrame productoproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoproveedorBeanSwingJInternalFrame.jTtoolBarProductoProveedor.setBorder(borderResaltar);
		
		this.resaltarobservacionProductoProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobservacionProductoProveedor() {
		return this.resaltarobservacionProductoProveedor;
	}

	public void setResaltarobservacionProductoProveedor(Border borderResaltar) {
		this.resaltarobservacionProductoProveedor= borderResaltar;
	}

	public Boolean getMostrarobservacionProductoProveedor() {
		return this.mostrarobservacionProductoProveedor;
	}

	public void setMostrarobservacionProductoProveedor(Boolean mostrarobservacionProductoProveedor) {
		this.mostrarobservacionProductoProveedor= mostrarobservacionProductoProveedor;
	}

	public Boolean getActivarobservacionProductoProveedor() {
		return this.activarobservacionProductoProveedor;
	}

	public void setActivarobservacionProductoProveedor(Boolean activarobservacionProductoProveedor) {
		this.activarobservacionProductoProveedor= activarobservacionProductoProveedor;
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
		
		
		this.setMostraridProductoProveedor(esInicial);
		this.setMostrarid_empresaProductoProveedor(esInicial);
		this.setMostrarid_sucursalProductoProveedor(esInicial);
		this.setMostrarid_bodegaProductoProveedor(esInicial);
		this.setMostrarid_productoProductoProveedor(esInicial);
		this.setMostrarid_clienteProductoProveedor(esInicial);
		this.setMostrarprecio_ultimoProductoProveedor(esInicial);
		this.setMostrarprecio_acuerdoProductoProveedor(esInicial);
		this.setMostrardia_entraProductoProveedor(esInicial);
		this.setMostrarobservacionProductoProveedor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.ID)) {
				this.setMostraridProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.PRECIOULTIMO)) {
				this.setMostrarprecio_ultimoProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.PRECIOACUERDO)) {
				this.setMostrarprecio_acuerdoProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.DIAENTRA)) {
				this.setMostrardia_entraProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.OBSERVACION)) {
				this.setMostrarobservacionProductoProveedor(esAsigna);
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
		
		
		this.setActivaridProductoProveedor(esInicial);
		this.setActivarid_empresaProductoProveedor(esInicial);
		this.setActivarid_sucursalProductoProveedor(esInicial);
		this.setActivarid_bodegaProductoProveedor(esInicial);
		this.setActivarid_productoProductoProveedor(esInicial);
		this.setActivarid_clienteProductoProveedor(esInicial);
		this.setActivarprecio_ultimoProductoProveedor(esInicial);
		this.setActivarprecio_acuerdoProductoProveedor(esInicial);
		this.setActivardia_entraProductoProveedor(esInicial);
		this.setActivarobservacionProductoProveedor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.ID)) {
				this.setActivaridProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.PRECIOULTIMO)) {
				this.setActivarprecio_ultimoProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.PRECIOACUERDO)) {
				this.setActivarprecio_acuerdoProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.DIAENTRA)) {
				this.setActivardia_entraProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.OBSERVACION)) {
				this.setActivarobservacionProductoProveedor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoProveedorBeanSwingJInternalFrame productoproveedorBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductoProveedor(esInicial);
		this.setResaltarid_empresaProductoProveedor(esInicial);
		this.setResaltarid_sucursalProductoProveedor(esInicial);
		this.setResaltarid_bodegaProductoProveedor(esInicial);
		this.setResaltarid_productoProductoProveedor(esInicial);
		this.setResaltarid_clienteProductoProveedor(esInicial);
		this.setResaltarprecio_ultimoProductoProveedor(esInicial);
		this.setResaltarprecio_acuerdoProductoProveedor(esInicial);
		this.setResaltardia_entraProductoProveedor(esInicial);
		this.setResaltarobservacionProductoProveedor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.ID)) {
				this.setResaltaridProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.PRECIOULTIMO)) {
				this.setResaltarprecio_ultimoProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.PRECIOACUERDO)) {
				this.setResaltarprecio_acuerdoProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.DIAENTRA)) {
				this.setResaltardia_entraProductoProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProveedorConstantesFunciones.OBSERVACION)) {
				this.setResaltarobservacionProductoProveedor(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoProveedorBeanSwingJInternalFrame productoproveedorBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaProductoProveedor=true;

	public Boolean getMostrarFK_IdBodegaProductoProveedor() {
		return this.mostrarFK_IdBodegaProductoProveedor;
	}

	public void setMostrarFK_IdBodegaProductoProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaProductoProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteProductoProveedor=true;

	public Boolean getMostrarFK_IdClienteProductoProveedor() {
		return this.mostrarFK_IdClienteProductoProveedor;
	}

	public void setMostrarFK_IdClienteProductoProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteProductoProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaProductoProveedor=true;

	public Boolean getMostrarFK_IdEmpresaProductoProveedor() {
		return this.mostrarFK_IdEmpresaProductoProveedor;
	}

	public void setMostrarFK_IdEmpresaProductoProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaProductoProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoProductoProveedor=true;

	public Boolean getMostrarFK_IdProductoProductoProveedor() {
		return this.mostrarFK_IdProductoProductoProveedor;
	}

	public void setMostrarFK_IdProductoProductoProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoProductoProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalProductoProveedor=true;

	public Boolean getMostrarFK_IdSucursalProductoProveedor() {
		return this.mostrarFK_IdSucursalProductoProveedor;
	}

	public void setMostrarFK_IdSucursalProductoProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalProductoProveedor= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaProductoProveedor=true;

	public Boolean getActivarFK_IdBodegaProductoProveedor() {
		return this.activarFK_IdBodegaProductoProveedor;
	}

	public void setActivarFK_IdBodegaProductoProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaProductoProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteProductoProveedor=true;

	public Boolean getActivarFK_IdClienteProductoProveedor() {
		return this.activarFK_IdClienteProductoProveedor;
	}

	public void setActivarFK_IdClienteProductoProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdClienteProductoProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaProductoProveedor=true;

	public Boolean getActivarFK_IdEmpresaProductoProveedor() {
		return this.activarFK_IdEmpresaProductoProveedor;
	}

	public void setActivarFK_IdEmpresaProductoProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaProductoProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoProductoProveedor=true;

	public Boolean getActivarFK_IdProductoProductoProveedor() {
		return this.activarFK_IdProductoProductoProveedor;
	}

	public void setActivarFK_IdProductoProductoProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdProductoProductoProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalProductoProveedor=true;

	public Boolean getActivarFK_IdSucursalProductoProveedor() {
		return this.activarFK_IdSucursalProductoProveedor;
	}

	public void setActivarFK_IdSucursalProductoProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalProductoProveedor= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaProductoProveedor=null;

	public Border getResaltarFK_IdBodegaProductoProveedor() {
		return this.resaltarFK_IdBodegaProductoProveedor;
	}

	public void setResaltarFK_IdBodegaProductoProveedor(Border borderResaltar) {
		this.resaltarFK_IdBodegaProductoProveedor= borderResaltar;
	}

	public void setResaltarFK_IdBodegaProductoProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProveedorBeanSwingJInternalFrame productoproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaProductoProveedor= borderResaltar;
	}

	public Border resaltarFK_IdClienteProductoProveedor=null;

	public Border getResaltarFK_IdClienteProductoProveedor() {
		return this.resaltarFK_IdClienteProductoProveedor;
	}

	public void setResaltarFK_IdClienteProductoProveedor(Border borderResaltar) {
		this.resaltarFK_IdClienteProductoProveedor= borderResaltar;
	}

	public void setResaltarFK_IdClienteProductoProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProveedorBeanSwingJInternalFrame productoproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteProductoProveedor= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaProductoProveedor=null;

	public Border getResaltarFK_IdEmpresaProductoProveedor() {
		return this.resaltarFK_IdEmpresaProductoProveedor;
	}

	public void setResaltarFK_IdEmpresaProductoProveedor(Border borderResaltar) {
		this.resaltarFK_IdEmpresaProductoProveedor= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaProductoProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProveedorBeanSwingJInternalFrame productoproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaProductoProveedor= borderResaltar;
	}

	public Border resaltarFK_IdProductoProductoProveedor=null;

	public Border getResaltarFK_IdProductoProductoProveedor() {
		return this.resaltarFK_IdProductoProductoProveedor;
	}

	public void setResaltarFK_IdProductoProductoProveedor(Border borderResaltar) {
		this.resaltarFK_IdProductoProductoProveedor= borderResaltar;
	}

	public void setResaltarFK_IdProductoProductoProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProveedorBeanSwingJInternalFrame productoproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoProductoProveedor= borderResaltar;
	}

	public Border resaltarFK_IdSucursalProductoProveedor=null;

	public Border getResaltarFK_IdSucursalProductoProveedor() {
		return this.resaltarFK_IdSucursalProductoProveedor;
	}

	public void setResaltarFK_IdSucursalProductoProveedor(Border borderResaltar) {
		this.resaltarFK_IdSucursalProductoProveedor= borderResaltar;
	}

	public void setResaltarFK_IdSucursalProductoProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProveedorBeanSwingJInternalFrame productoproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalProductoProveedor= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}