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


import com.bydan.erp.inventario.util.ProductoCuentaContableConstantesFunciones;
import com.bydan.erp.inventario.util.ProductoCuentaContableParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ProductoCuentaContableParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProductoCuentaContableConstantesFunciones extends ProductoCuentaContableConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProductoCuentaContable";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductoCuentaContable"+ProductoCuentaContableConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductoCuentaContableHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductoCuentaContableHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductoCuentaContableConstantesFunciones.SCHEMA+"_"+ProductoCuentaContableConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductoCuentaContableHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductoCuentaContableConstantesFunciones.SCHEMA+"_"+ProductoCuentaContableConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductoCuentaContableConstantesFunciones.SCHEMA+"_"+ProductoCuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductoCuentaContableHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductoCuentaContableConstantesFunciones.SCHEMA+"_"+ProductoCuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoCuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoCuentaContableHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoCuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoCuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoCuentaContableHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoCuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductoCuentaContableConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductoCuentaContableConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductoCuentaContableConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductoCuentaContableConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Producto Cuenta Contables";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Producto Cuenta Contable";
	public static final String SCLASSWEBTITULO_LOWER="Producto Cuenta Contable";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductoCuentaContable";
	public static final String OBJECTNAME="productocuentacontable";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="producto_cuenta_contable";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productocuentacontable from "+ProductoCuentaContableConstantesFunciones.SPERSISTENCENAME+" productocuentacontable";
	public static String QUERYSELECTNATIVE="select "+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".version_row,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_empresa,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_sucursal,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_bodega,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_producto,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_centro_costo,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_cuenta_contable_inventario,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_cuenta_contable_costo,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_cuenta_contable_venta,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_cuenta_contable_descuento,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_cuenta_contable_devolucion,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_cuenta_contable_debito,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_cuenta_contable_credito from "+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME;//+" as "+ProductoCuentaContableConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProductoCuentaContableConstantesFuncionesAdditional productocuentacontableConstantesFuncionesAdditional=null;
	
	public ProductoCuentaContableConstantesFuncionesAdditional getProductoCuentaContableConstantesFuncionesAdditional() {
		return this.productocuentacontableConstantesFuncionesAdditional;
	}
	
	public void setProductoCuentaContableConstantesFuncionesAdditional(ProductoCuentaContableConstantesFuncionesAdditional productocuentacontableConstantesFuncionesAdditional) {
		try {
			this.productocuentacontableConstantesFuncionesAdditional=productocuentacontableConstantesFuncionesAdditional;
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
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDCUENTACONTABLEINVENTARIO= "id_cuenta_contable_inventario";
    public static final String IDCUENTACONTABLECOSTO= "id_cuenta_contable_costo";
    public static final String IDCUENTACONTABLEVENTA= "id_cuenta_contable_venta";
    public static final String IDCUENTACONTABLEDESCUENTO= "id_cuenta_contable_descuento";
    public static final String IDCUENTACONTABLEDEVOLUCION= "id_cuenta_contable_devolucion";
    public static final String IDCUENTACONTABLEDEBITO= "id_cuenta_contable_debito";
    public static final String IDCUENTACONTABLECREDITO= "id_cuenta_contable_credito";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDCUENTACONTABLEINVENTARIO= "Cuenta Contable Inventario";
		public static final String LABEL_IDCUENTACONTABLEINVENTARIO_LOWER= "Cuenta Contable Inventario";
    	public static final String LABEL_IDCUENTACONTABLECOSTO= "Cuenta Contable Costo";
		public static final String LABEL_IDCUENTACONTABLECOSTO_LOWER= "Cuenta Contable Costo";
    	public static final String LABEL_IDCUENTACONTABLEVENTA= "Cuenta Contable Venta";
		public static final String LABEL_IDCUENTACONTABLEVENTA_LOWER= "Cuenta Contable Venta";
    	public static final String LABEL_IDCUENTACONTABLEDESCUENTO= "Cuenta Contable Descuento";
		public static final String LABEL_IDCUENTACONTABLEDESCUENTO_LOWER= "Cuenta Contable Descuento";
    	public static final String LABEL_IDCUENTACONTABLEDEVOLUCION= "Cuenta Contable Devolucion";
		public static final String LABEL_IDCUENTACONTABLEDEVOLUCION_LOWER= "Cuenta Contable Devolucion";
    	public static final String LABEL_IDCUENTACONTABLEDEBITO= "Cuenta Contable Debito";
		public static final String LABEL_IDCUENTACONTABLEDEBITO_LOWER= "Cuenta Contable Debito";
    	public static final String LABEL_IDCUENTACONTABLECREDITO= "Cuenta Contable Credito";
		public static final String LABEL_IDCUENTACONTABLECREDITO_LOWER= "Cuenta Contable Credito";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getProductoCuentaContableLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductoCuentaContableConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProductoCuentaContableConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProductoCuentaContableConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProductoCuentaContableConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProductoCuentaContableConstantesFunciones.IDBODEGA)) {sLabelColumna=ProductoCuentaContableConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ProductoCuentaContableConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProductoCuentaContableConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProductoCuentaContableConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=ProductoCuentaContableConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {sLabelColumna=ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO;}
		if(sNombreColumna.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECOSTO)) {sLabelColumna=ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO;}
		if(sNombreColumna.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEVENTA)) {sLabelColumna=ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA;}
		if(sNombreColumna.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {sLabelColumna=ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO;}
		if(sNombreColumna.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {sLabelColumna=ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION;}
		if(sNombreColumna.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO)) {sLabelColumna=ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO;}
		if(sNombreColumna.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO)) {sLabelColumna=ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProductoCuentaContableDescripcion(ProductoCuentaContable productocuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productocuentacontable !=null/* && productocuentacontable.getId()!=0*/) {
			if(productocuentacontable.getId()!=null) {
				sDescripcion=productocuentacontable.getId().toString();
			}//productocuentacontableproductocuentacontable.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductoCuentaContableDescripcionDetallado(ProductoCuentaContable productocuentacontable) {
		String sDescripcion="";
			
		sDescripcion+=ProductoCuentaContableConstantesFunciones.ID+"=";
		sDescripcion+=productocuentacontable.getId().toString()+",";
		sDescripcion+=ProductoCuentaContableConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productocuentacontable.getVersionRow().toString()+",";
		sDescripcion+=ProductoCuentaContableConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=productocuentacontable.getid_empresa().toString()+",";
		sDescripcion+=ProductoCuentaContableConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=productocuentacontable.getid_sucursal().toString()+",";
		sDescripcion+=ProductoCuentaContableConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=productocuentacontable.getid_bodega().toString()+",";
		sDescripcion+=ProductoCuentaContableConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=productocuentacontable.getid_producto().toString()+",";
		sDescripcion+=ProductoCuentaContableConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=productocuentacontable.getid_centro_costo().toString()+",";
		sDescripcion+=ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEINVENTARIO+"=";
		sDescripcion+=productocuentacontable.getid_cuenta_contable_inventario().toString()+",";
		sDescripcion+=ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECOSTO+"=";
		sDescripcion+=productocuentacontable.getid_cuenta_contable_costo().toString()+",";
		sDescripcion+=ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEVENTA+"=";
		sDescripcion+=productocuentacontable.getid_cuenta_contable_venta().toString()+",";
		sDescripcion+=ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDESCUENTO+"=";
		sDescripcion+=productocuentacontable.getid_cuenta_contable_descuento().toString()+",";
		sDescripcion+=ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEVOLUCION+"=";
		sDescripcion+=productocuentacontable.getid_cuenta_contable_devolucion().toString()+",";
		sDescripcion+=ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO+"=";
		sDescripcion+=productocuentacontable.getid_cuenta_contable_debito().toString()+",";
		sDescripcion+=ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO+"=";
		sDescripcion+=productocuentacontable.getid_cuenta_contable_credito().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProductoCuentaContableDescripcion(ProductoCuentaContable productocuentacontable,String sValor) throws Exception {			
		if(productocuentacontable !=null) {
			//productocuentacontableproductocuentacontable.getId().toString();
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

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
		}

		return sDescripcion;
	}

	public static String getCuentaContableInventarioDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCostoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableVentaDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescuentoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDevolucionDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDebitoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCreditoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
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
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCosto")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Costo";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCredito")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Credito";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDebito")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Debito";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDescuento")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Descuento";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDevolucion")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Devolucion";
		} else if(sNombreIndice.equals("FK_IdCuentaContableInventario")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Inventario";
		} else if(sNombreIndice.equals("FK_IdCuentaContableVenta")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Venta";
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

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCosto(Long id_cuenta_contable_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_costo!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Costo="+id_cuenta_contable_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCredito(Long id_cuenta_contable_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_credito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Credito="+id_cuenta_contable_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableDebito(Long id_cuenta_contable_debito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_debito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Debito="+id_cuenta_contable_debito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableDescuento(Long id_cuenta_contable_descuento) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_descuento!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Descuento="+id_cuenta_contable_descuento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableDevolucion(Long id_cuenta_contable_devolucion) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_devolucion!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Devolucion="+id_cuenta_contable_devolucion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableInventario(Long id_cuenta_contable_inventario) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_inventario!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Inventario="+id_cuenta_contable_inventario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableVenta(Long id_cuenta_contable_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_venta!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Venta="+id_cuenta_contable_venta.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosProductoCuentaContable(ProductoCuentaContable productocuentacontable,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProductoCuentaContables(List<ProductoCuentaContable> productocuentacontables,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoCuentaContable productocuentacontable: productocuentacontables) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoCuentaContable(ProductoCuentaContable productocuentacontable,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productocuentacontable.getConCambioAuxiliar()) {
			productocuentacontable.setIsDeleted(productocuentacontable.getIsDeletedAuxiliar());	
			productocuentacontable.setIsNew(productocuentacontable.getIsNewAuxiliar());	
			productocuentacontable.setIsChanged(productocuentacontable.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productocuentacontable.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productocuentacontable.setIsDeletedAuxiliar(false);	
			productocuentacontable.setIsNewAuxiliar(false);	
			productocuentacontable.setIsChangedAuxiliar(false);
			
			productocuentacontable.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoCuentaContables(List<ProductoCuentaContable> productocuentacontables,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductoCuentaContable productocuentacontable : productocuentacontables) {
			if(conAsignarBase && productocuentacontable.getConCambioAuxiliar()) {
				productocuentacontable.setIsDeleted(productocuentacontable.getIsDeletedAuxiliar());	
				productocuentacontable.setIsNew(productocuentacontable.getIsNewAuxiliar());	
				productocuentacontable.setIsChanged(productocuentacontable.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productocuentacontable.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productocuentacontable.setIsDeletedAuxiliar(false);	
				productocuentacontable.setIsNewAuxiliar(false);	
				productocuentacontable.setIsChangedAuxiliar(false);
				
				productocuentacontable.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductoCuentaContable(ProductoCuentaContable productocuentacontable,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProductoCuentaContables(List<ProductoCuentaContable> productocuentacontables,Boolean conEnteros) throws Exception  {
		
		for(ProductoCuentaContable productocuentacontable: productocuentacontables) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductoCuentaContable(List<ProductoCuentaContable> productocuentacontables,ProductoCuentaContable productocuentacontableAux) throws Exception  {
		ProductoCuentaContableConstantesFunciones.InicializarValoresProductoCuentaContable(productocuentacontableAux,true);
		
		for(ProductoCuentaContable productocuentacontable: productocuentacontables) {
			if(productocuentacontable.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoCuentaContable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductoCuentaContableConstantesFunciones.getArrayColumnasGlobalesProductoCuentaContable(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoCuentaContable(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductoCuentaContableConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductoCuentaContableConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductoCuentaContableConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductoCuentaContableConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductoCuentaContable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoCuentaContable> productocuentacontables,ProductoCuentaContable productocuentacontable,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoCuentaContable productocuentacontableAux: productocuentacontables) {
			if(productocuentacontableAux!=null && productocuentacontable!=null) {
				if((productocuentacontableAux.getId()==null && productocuentacontable.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productocuentacontableAux.getId()!=null && productocuentacontable.getId()!=null){
					if(productocuentacontableAux.getId().equals(productocuentacontable.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoCuentaContable(List<ProductoCuentaContable> productocuentacontables) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProductoCuentaContable productocuentacontable: productocuentacontables) {			
			if(productocuentacontable.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductoCuentaContable() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductoCuentaContableConstantesFunciones.LABEL_ID, ProductoCuentaContableConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoCuentaContableConstantesFunciones.LABEL_VERSIONROW, ProductoCuentaContableConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoCuentaContableConstantesFunciones.LABEL_IDEMPRESA, ProductoCuentaContableConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoCuentaContableConstantesFunciones.LABEL_IDSUCURSAL, ProductoCuentaContableConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoCuentaContableConstantesFunciones.LABEL_IDBODEGA, ProductoCuentaContableConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoCuentaContableConstantesFunciones.LABEL_IDPRODUCTO, ProductoCuentaContableConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoCuentaContableConstantesFunciones.LABEL_IDCENTROCOSTO, ProductoCuentaContableConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO, ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEINVENTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO, ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA, ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO, ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION, ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO, ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO, ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductoCuentaContable() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductoCuentaContableConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoCuentaContableConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoCuentaContableConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoCuentaContableConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoCuentaContableConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoCuentaContableConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoCuentaContableConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEINVENTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEVOLUCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoCuentaContable() throws Exception  {
		return ProductoCuentaContableConstantesFunciones.getTiposSeleccionarProductoCuentaContable(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoCuentaContable(Boolean conFk) throws Exception  {
		return ProductoCuentaContableConstantesFunciones.getTiposSeleccionarProductoCuentaContable(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoCuentaContable(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoCuentaContableConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProductoCuentaContableConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoCuentaContableConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProductoCuentaContableConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoCuentaContableConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ProductoCuentaContableConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoCuentaContableConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProductoCuentaContableConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoCuentaContableConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(ProductoCuentaContableConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO);
			reporte.setsDescripcion(ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO);
			reporte.setsDescripcion(ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA);
			reporte.setsDescripcion(ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO);
			reporte.setsDescripcion(ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION);
			reporte.setsDescripcion(ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);
			reporte.setsDescripcion(ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
			reporte.setsDescripcion(ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductoCuentaContable(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductoCuentaContable(ProductoCuentaContable productocuentacontableAux) throws Exception {
		
			productocuentacontableAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productocuentacontableAux.getEmpresa()));
			productocuentacontableAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productocuentacontableAux.getSucursal()));
			productocuentacontableAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productocuentacontableAux.getBodega()));
			productocuentacontableAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productocuentacontableAux.getProducto()));
			productocuentacontableAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(productocuentacontableAux.getCentroCosto()));
			productocuentacontableAux.setcuentacontableinventario_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(productocuentacontableAux.getCuentaContableInventario()));
			productocuentacontableAux.setcuentacontablecosto_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(productocuentacontableAux.getCuentaContableCosto()));
			productocuentacontableAux.setcuentacontableventa_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(productocuentacontableAux.getCuentaContableVenta()));
			productocuentacontableAux.setcuentacontabledescuento_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(productocuentacontableAux.getCuentaContableDescuento()));
			productocuentacontableAux.setcuentacontabledevolucion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(productocuentacontableAux.getCuentaContableDevolucion()));
			productocuentacontableAux.setcuentacontabledebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(productocuentacontableAux.getCuentaContableDebito()));
			productocuentacontableAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(productocuentacontableAux.getCuentaContableCredito()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductoCuentaContable(List<ProductoCuentaContable> productocuentacontablesTemp) throws Exception {
		for(ProductoCuentaContable productocuentacontableAux:productocuentacontablesTemp) {
			
			productocuentacontableAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productocuentacontableAux.getEmpresa()));
			productocuentacontableAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productocuentacontableAux.getSucursal()));
			productocuentacontableAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productocuentacontableAux.getBodega()));
			productocuentacontableAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productocuentacontableAux.getProducto()));
			productocuentacontableAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(productocuentacontableAux.getCentroCosto()));
			productocuentacontableAux.setcuentacontableinventario_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(productocuentacontableAux.getCuentaContableInventario()));
			productocuentacontableAux.setcuentacontablecosto_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(productocuentacontableAux.getCuentaContableCosto()));
			productocuentacontableAux.setcuentacontableventa_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(productocuentacontableAux.getCuentaContableVenta()));
			productocuentacontableAux.setcuentacontabledescuento_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(productocuentacontableAux.getCuentaContableDescuento()));
			productocuentacontableAux.setcuentacontabledevolucion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(productocuentacontableAux.getCuentaContableDevolucion()));
			productocuentacontableAux.setcuentacontabledebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(productocuentacontableAux.getCuentaContableDebito()));
			productocuentacontableAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(productocuentacontableAux.getCuentaContableCredito()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductoCuentaContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				
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
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductoCuentaContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoCuentaContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoCuentaContableConstantesFunciones.getClassesRelationshipsOfProductoCuentaContable(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoCuentaContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoCuentaContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoCuentaContableConstantesFunciones.getClassesRelationshipsFromStringsOfProductoCuentaContable(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoCuentaContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductoCuentaContable productocuentacontable,List<ProductoCuentaContable> productocuentacontables,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProductoCuentaContable productocuentacontableEncontrado=null;
			
			for(ProductoCuentaContable productocuentacontableLocal:productocuentacontables) {
				if(productocuentacontableLocal.getId().equals(productocuentacontable.getId())) {
					productocuentacontableEncontrado=productocuentacontableLocal;
					
					productocuentacontableLocal.setIsChanged(productocuentacontable.getIsChanged());
					productocuentacontableLocal.setIsNew(productocuentacontable.getIsNew());
					productocuentacontableLocal.setIsDeleted(productocuentacontable.getIsDeleted());
					
					productocuentacontableLocal.setGeneralEntityOriginal(productocuentacontable.getGeneralEntityOriginal());
					
					productocuentacontableLocal.setId(productocuentacontable.getId());	
					productocuentacontableLocal.setVersionRow(productocuentacontable.getVersionRow());	
					productocuentacontableLocal.setid_empresa(productocuentacontable.getid_empresa());	
					productocuentacontableLocal.setid_sucursal(productocuentacontable.getid_sucursal());	
					productocuentacontableLocal.setid_bodega(productocuentacontable.getid_bodega());	
					productocuentacontableLocal.setid_producto(productocuentacontable.getid_producto());	
					productocuentacontableLocal.setid_centro_costo(productocuentacontable.getid_centro_costo());	
					productocuentacontableLocal.setid_cuenta_contable_inventario(productocuentacontable.getid_cuenta_contable_inventario());	
					productocuentacontableLocal.setid_cuenta_contable_costo(productocuentacontable.getid_cuenta_contable_costo());	
					productocuentacontableLocal.setid_cuenta_contable_venta(productocuentacontable.getid_cuenta_contable_venta());	
					productocuentacontableLocal.setid_cuenta_contable_descuento(productocuentacontable.getid_cuenta_contable_descuento());	
					productocuentacontableLocal.setid_cuenta_contable_devolucion(productocuentacontable.getid_cuenta_contable_devolucion());	
					productocuentacontableLocal.setid_cuenta_contable_debito(productocuentacontable.getid_cuenta_contable_debito());	
					productocuentacontableLocal.setid_cuenta_contable_credito(productocuentacontable.getid_cuenta_contable_credito());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!productocuentacontable.getIsDeleted()) {
				if(!existe) {
					productocuentacontables.add(productocuentacontable);
				}
			} else {
				if(productocuentacontableEncontrado!=null && permiteQuitar)  {
					productocuentacontables.remove(productocuentacontableEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProductoCuentaContable productocuentacontable,List<ProductoCuentaContable> productocuentacontables) throws Exception {
		try	{			
			for(ProductoCuentaContable productocuentacontableLocal:productocuentacontables) {
				if(productocuentacontableLocal.getId().equals(productocuentacontable.getId())) {
					productocuentacontableLocal.setIsSelected(productocuentacontable.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductoCuentaContable(List<ProductoCuentaContable> productocuentacontablesAux) throws Exception {
		//this.productocuentacontablesAux=productocuentacontablesAux;
		
		for(ProductoCuentaContable productocuentacontableAux:productocuentacontablesAux) {
			if(productocuentacontableAux.getIsChanged()) {
				productocuentacontableAux.setIsChanged(false);
			}		
			
			if(productocuentacontableAux.getIsNew()) {
				productocuentacontableAux.setIsNew(false);
			}	
			
			if(productocuentacontableAux.getIsDeleted()) {
				productocuentacontableAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductoCuentaContable(ProductoCuentaContable productocuentacontableAux) throws Exception {
		//this.productocuentacontableAux=productocuentacontableAux;
		
			if(productocuentacontableAux.getIsChanged()) {
				productocuentacontableAux.setIsChanged(false);
			}		
			
			if(productocuentacontableAux.getIsNew()) {
				productocuentacontableAux.setIsNew(false);
			}	
			
			if(productocuentacontableAux.getIsDeleted()) {
				productocuentacontableAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductoCuentaContable productocuentacontableAsignar,ProductoCuentaContable productocuentacontable) throws Exception {
		productocuentacontableAsignar.setId(productocuentacontable.getId());	
		productocuentacontableAsignar.setVersionRow(productocuentacontable.getVersionRow());	
		productocuentacontableAsignar.setid_empresa(productocuentacontable.getid_empresa());
		productocuentacontableAsignar.setempresa_descripcion(productocuentacontable.getempresa_descripcion());	
		productocuentacontableAsignar.setid_sucursal(productocuentacontable.getid_sucursal());
		productocuentacontableAsignar.setsucursal_descripcion(productocuentacontable.getsucursal_descripcion());	
		productocuentacontableAsignar.setid_bodega(productocuentacontable.getid_bodega());
		productocuentacontableAsignar.setbodega_descripcion(productocuentacontable.getbodega_descripcion());	
		productocuentacontableAsignar.setid_producto(productocuentacontable.getid_producto());
		productocuentacontableAsignar.setproducto_descripcion(productocuentacontable.getproducto_descripcion());	
		productocuentacontableAsignar.setid_centro_costo(productocuentacontable.getid_centro_costo());
		productocuentacontableAsignar.setcentrocosto_descripcion(productocuentacontable.getcentrocosto_descripcion());	
		productocuentacontableAsignar.setid_cuenta_contable_inventario(productocuentacontable.getid_cuenta_contable_inventario());
		productocuentacontableAsignar.setcuentacontableinventario_descripcion(productocuentacontable.getcuentacontableinventario_descripcion());	
		productocuentacontableAsignar.setid_cuenta_contable_costo(productocuentacontable.getid_cuenta_contable_costo());
		productocuentacontableAsignar.setcuentacontablecosto_descripcion(productocuentacontable.getcuentacontablecosto_descripcion());	
		productocuentacontableAsignar.setid_cuenta_contable_venta(productocuentacontable.getid_cuenta_contable_venta());
		productocuentacontableAsignar.setcuentacontableventa_descripcion(productocuentacontable.getcuentacontableventa_descripcion());	
		productocuentacontableAsignar.setid_cuenta_contable_descuento(productocuentacontable.getid_cuenta_contable_descuento());
		productocuentacontableAsignar.setcuentacontabledescuento_descripcion(productocuentacontable.getcuentacontabledescuento_descripcion());	
		productocuentacontableAsignar.setid_cuenta_contable_devolucion(productocuentacontable.getid_cuenta_contable_devolucion());
		productocuentacontableAsignar.setcuentacontabledevolucion_descripcion(productocuentacontable.getcuentacontabledevolucion_descripcion());	
		productocuentacontableAsignar.setid_cuenta_contable_debito(productocuentacontable.getid_cuenta_contable_debito());
		productocuentacontableAsignar.setcuentacontabledebito_descripcion(productocuentacontable.getcuentacontabledebito_descripcion());	
		productocuentacontableAsignar.setid_cuenta_contable_credito(productocuentacontable.getid_cuenta_contable_credito());
		productocuentacontableAsignar.setcuentacontablecredito_descripcion(productocuentacontable.getcuentacontablecredito_descripcion());	
	}
	
	public static void inicializarProductoCuentaContable(ProductoCuentaContable productocuentacontable) throws Exception {
		try {
				productocuentacontable.setId(0L);	
					
				productocuentacontable.setid_empresa(-1L);	
				productocuentacontable.setid_sucursal(-1L);	
				productocuentacontable.setid_bodega(-1L);	
				productocuentacontable.setid_producto(-1L);	
				productocuentacontable.setid_centro_costo(null);	
				productocuentacontable.setid_cuenta_contable_inventario(-1L);	
				productocuentacontable.setid_cuenta_contable_costo(-1L);	
				productocuentacontable.setid_cuenta_contable_venta(-1L);	
				productocuentacontable.setid_cuenta_contable_descuento(-1L);	
				productocuentacontable.setid_cuenta_contable_devolucion(-1L);	
				productocuentacontable.setid_cuenta_contable_debito(-1L);	
				productocuentacontable.setid_cuenta_contable_credito(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductoCuentaContable(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoCuentaContableConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoCuentaContableConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoCuentaContableConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoCuentaContableConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoCuentaContableConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductoCuentaContable(String sTipo,Row row,Workbook workbook,ProductoCuentaContable productocuentacontable,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productocuentacontable.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productocuentacontable.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productocuentacontable.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productocuentacontable.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productocuentacontable.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productocuentacontable.getcuentacontableinventario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productocuentacontable.getcuentacontablecosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productocuentacontable.getcuentacontableventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productocuentacontable.getcuentacontabledescuento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productocuentacontable.getcuentacontabledevolucion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productocuentacontable.getcuentacontabledebito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productocuentacontable.getcuentacontablecredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductoCuentaContable=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProductoCuentaContable() {
		return this.sFinalQueryProductoCuentaContable;
	}
	
	public void setsFinalQueryProductoCuentaContable(String sFinalQueryProductoCuentaContable) {
		this.sFinalQueryProductoCuentaContable= sFinalQueryProductoCuentaContable;
	}
	
	public Border resaltarSeleccionarProductoCuentaContable=null;
	
	public Border setResaltarSeleccionarProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productocuentacontableBeanSwingJInternalFrame.jTtoolBarProductoCuentaContable.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductoCuentaContable= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductoCuentaContable() {
		return this.resaltarSeleccionarProductoCuentaContable;
	}
	
	public void setResaltarSeleccionarProductoCuentaContable(Border borderResaltarSeleccionarProductoCuentaContable) {
		this.resaltarSeleccionarProductoCuentaContable= borderResaltarSeleccionarProductoCuentaContable;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductoCuentaContable=null;
	public Boolean mostraridProductoCuentaContable=true;
	public Boolean activaridProductoCuentaContable=true;

	public Border resaltarid_empresaProductoCuentaContable=null;
	public Boolean mostrarid_empresaProductoCuentaContable=true;
	public Boolean activarid_empresaProductoCuentaContable=true;
	public Boolean cargarid_empresaProductoCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProductoCuentaContable=false;//ConEventDepend=true

	public Border resaltarid_sucursalProductoCuentaContable=null;
	public Boolean mostrarid_sucursalProductoCuentaContable=true;
	public Boolean activarid_sucursalProductoCuentaContable=true;
	public Boolean cargarid_sucursalProductoCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProductoCuentaContable=false;//ConEventDepend=true

	public Border resaltarid_bodegaProductoCuentaContable=null;
	public Boolean mostrarid_bodegaProductoCuentaContable=true;
	public Boolean activarid_bodegaProductoCuentaContable=true;
	public Boolean cargarid_bodegaProductoCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaProductoCuentaContable=false;//ConEventDepend=true

	public Border resaltarid_productoProductoCuentaContable=null;
	public Boolean mostrarid_productoProductoCuentaContable=true;
	public Boolean activarid_productoProductoCuentaContable=true;
	public Boolean cargarid_productoProductoCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProductoCuentaContable=false;//ConEventDepend=true

	public Border resaltarid_centro_costoProductoCuentaContable=null;
	public Boolean mostrarid_centro_costoProductoCuentaContable=true;
	public Boolean activarid_centro_costoProductoCuentaContable=true;
	public Boolean cargarid_centro_costoProductoCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoProductoCuentaContable=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_inventarioProductoCuentaContable=null;
	public Boolean mostrarid_cuenta_contable_inventarioProductoCuentaContable=true;
	public Boolean activarid_cuenta_contable_inventarioProductoCuentaContable=true;
	public Boolean cargarid_cuenta_contable_inventarioProductoCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_inventarioProductoCuentaContable=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_costoProductoCuentaContable=null;
	public Boolean mostrarid_cuenta_contable_costoProductoCuentaContable=true;
	public Boolean activarid_cuenta_contable_costoProductoCuentaContable=true;
	public Boolean cargarid_cuenta_contable_costoProductoCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_costoProductoCuentaContable=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_ventaProductoCuentaContable=null;
	public Boolean mostrarid_cuenta_contable_ventaProductoCuentaContable=true;
	public Boolean activarid_cuenta_contable_ventaProductoCuentaContable=true;
	public Boolean cargarid_cuenta_contable_ventaProductoCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_ventaProductoCuentaContable=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_descuentoProductoCuentaContable=null;
	public Boolean mostrarid_cuenta_contable_descuentoProductoCuentaContable=true;
	public Boolean activarid_cuenta_contable_descuentoProductoCuentaContable=true;
	public Boolean cargarid_cuenta_contable_descuentoProductoCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_descuentoProductoCuentaContable=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_devolucionProductoCuentaContable=null;
	public Boolean mostrarid_cuenta_contable_devolucionProductoCuentaContable=true;
	public Boolean activarid_cuenta_contable_devolucionProductoCuentaContable=true;
	public Boolean cargarid_cuenta_contable_devolucionProductoCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_devolucionProductoCuentaContable=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_debitoProductoCuentaContable=null;
	public Boolean mostrarid_cuenta_contable_debitoProductoCuentaContable=true;
	public Boolean activarid_cuenta_contable_debitoProductoCuentaContable=true;
	public Boolean cargarid_cuenta_contable_debitoProductoCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_debitoProductoCuentaContable=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_creditoProductoCuentaContable=null;
	public Boolean mostrarid_cuenta_contable_creditoProductoCuentaContable=true;
	public Boolean activarid_cuenta_contable_creditoProductoCuentaContable=true;
	public Boolean cargarid_cuenta_contable_creditoProductoCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_creditoProductoCuentaContable=false;//ConEventDepend=true

	
	

	public Border setResaltaridProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productocuentacontableBeanSwingJInternalFrame.jTtoolBarProductoCuentaContable.setBorder(borderResaltar);
		
		this.resaltaridProductoCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductoCuentaContable() {
		return this.resaltaridProductoCuentaContable;
	}

	public void setResaltaridProductoCuentaContable(Border borderResaltar) {
		this.resaltaridProductoCuentaContable= borderResaltar;
	}

	public Boolean getMostraridProductoCuentaContable() {
		return this.mostraridProductoCuentaContable;
	}

	public void setMostraridProductoCuentaContable(Boolean mostraridProductoCuentaContable) {
		this.mostraridProductoCuentaContable= mostraridProductoCuentaContable;
	}

	public Boolean getActivaridProductoCuentaContable() {
		return this.activaridProductoCuentaContable;
	}

	public void setActivaridProductoCuentaContable(Boolean activaridProductoCuentaContable) {
		this.activaridProductoCuentaContable= activaridProductoCuentaContable;
	}

	public Border setResaltarid_empresaProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productocuentacontableBeanSwingJInternalFrame.jTtoolBarProductoCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_empresaProductoCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProductoCuentaContable() {
		return this.resaltarid_empresaProductoCuentaContable;
	}

	public void setResaltarid_empresaProductoCuentaContable(Border borderResaltar) {
		this.resaltarid_empresaProductoCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_empresaProductoCuentaContable() {
		return this.mostrarid_empresaProductoCuentaContable;
	}

	public void setMostrarid_empresaProductoCuentaContable(Boolean mostrarid_empresaProductoCuentaContable) {
		this.mostrarid_empresaProductoCuentaContable= mostrarid_empresaProductoCuentaContable;
	}

	public Boolean getActivarid_empresaProductoCuentaContable() {
		return this.activarid_empresaProductoCuentaContable;
	}

	public void setActivarid_empresaProductoCuentaContable(Boolean activarid_empresaProductoCuentaContable) {
		this.activarid_empresaProductoCuentaContable= activarid_empresaProductoCuentaContable;
	}

	public Boolean getCargarid_empresaProductoCuentaContable() {
		return this.cargarid_empresaProductoCuentaContable;
	}

	public void setCargarid_empresaProductoCuentaContable(Boolean cargarid_empresaProductoCuentaContable) {
		this.cargarid_empresaProductoCuentaContable= cargarid_empresaProductoCuentaContable;
	}

	public Border setResaltarid_sucursalProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productocuentacontableBeanSwingJInternalFrame.jTtoolBarProductoCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProductoCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProductoCuentaContable() {
		return this.resaltarid_sucursalProductoCuentaContable;
	}

	public void setResaltarid_sucursalProductoCuentaContable(Border borderResaltar) {
		this.resaltarid_sucursalProductoCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProductoCuentaContable() {
		return this.mostrarid_sucursalProductoCuentaContable;
	}

	public void setMostrarid_sucursalProductoCuentaContable(Boolean mostrarid_sucursalProductoCuentaContable) {
		this.mostrarid_sucursalProductoCuentaContable= mostrarid_sucursalProductoCuentaContable;
	}

	public Boolean getActivarid_sucursalProductoCuentaContable() {
		return this.activarid_sucursalProductoCuentaContable;
	}

	public void setActivarid_sucursalProductoCuentaContable(Boolean activarid_sucursalProductoCuentaContable) {
		this.activarid_sucursalProductoCuentaContable= activarid_sucursalProductoCuentaContable;
	}

	public Boolean getCargarid_sucursalProductoCuentaContable() {
		return this.cargarid_sucursalProductoCuentaContable;
	}

	public void setCargarid_sucursalProductoCuentaContable(Boolean cargarid_sucursalProductoCuentaContable) {
		this.cargarid_sucursalProductoCuentaContable= cargarid_sucursalProductoCuentaContable;
	}

	public Border setResaltarid_bodegaProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productocuentacontableBeanSwingJInternalFrame.jTtoolBarProductoCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_bodegaProductoCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaProductoCuentaContable() {
		return this.resaltarid_bodegaProductoCuentaContable;
	}

	public void setResaltarid_bodegaProductoCuentaContable(Border borderResaltar) {
		this.resaltarid_bodegaProductoCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_bodegaProductoCuentaContable() {
		return this.mostrarid_bodegaProductoCuentaContable;
	}

	public void setMostrarid_bodegaProductoCuentaContable(Boolean mostrarid_bodegaProductoCuentaContable) {
		this.mostrarid_bodegaProductoCuentaContable= mostrarid_bodegaProductoCuentaContable;
	}

	public Boolean getActivarid_bodegaProductoCuentaContable() {
		return this.activarid_bodegaProductoCuentaContable;
	}

	public void setActivarid_bodegaProductoCuentaContable(Boolean activarid_bodegaProductoCuentaContable) {
		this.activarid_bodegaProductoCuentaContable= activarid_bodegaProductoCuentaContable;
	}

	public Boolean getCargarid_bodegaProductoCuentaContable() {
		return this.cargarid_bodegaProductoCuentaContable;
	}

	public void setCargarid_bodegaProductoCuentaContable(Boolean cargarid_bodegaProductoCuentaContable) {
		this.cargarid_bodegaProductoCuentaContable= cargarid_bodegaProductoCuentaContable;
	}

	public Border setResaltarid_productoProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productocuentacontableBeanSwingJInternalFrame.jTtoolBarProductoCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_productoProductoCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProductoCuentaContable() {
		return this.resaltarid_productoProductoCuentaContable;
	}

	public void setResaltarid_productoProductoCuentaContable(Border borderResaltar) {
		this.resaltarid_productoProductoCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_productoProductoCuentaContable() {
		return this.mostrarid_productoProductoCuentaContable;
	}

	public void setMostrarid_productoProductoCuentaContable(Boolean mostrarid_productoProductoCuentaContable) {
		this.mostrarid_productoProductoCuentaContable= mostrarid_productoProductoCuentaContable;
	}

	public Boolean getActivarid_productoProductoCuentaContable() {
		return this.activarid_productoProductoCuentaContable;
	}

	public void setActivarid_productoProductoCuentaContable(Boolean activarid_productoProductoCuentaContable) {
		this.activarid_productoProductoCuentaContable= activarid_productoProductoCuentaContable;
	}

	public Boolean getCargarid_productoProductoCuentaContable() {
		return this.cargarid_productoProductoCuentaContable;
	}

	public void setCargarid_productoProductoCuentaContable(Boolean cargarid_productoProductoCuentaContable) {
		this.cargarid_productoProductoCuentaContable= cargarid_productoProductoCuentaContable;
	}

	public Border setResaltarid_centro_costoProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productocuentacontableBeanSwingJInternalFrame.jTtoolBarProductoCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoProductoCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoProductoCuentaContable() {
		return this.resaltarid_centro_costoProductoCuentaContable;
	}

	public void setResaltarid_centro_costoProductoCuentaContable(Border borderResaltar) {
		this.resaltarid_centro_costoProductoCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoProductoCuentaContable() {
		return this.mostrarid_centro_costoProductoCuentaContable;
	}

	public void setMostrarid_centro_costoProductoCuentaContable(Boolean mostrarid_centro_costoProductoCuentaContable) {
		this.mostrarid_centro_costoProductoCuentaContable= mostrarid_centro_costoProductoCuentaContable;
	}

	public Boolean getActivarid_centro_costoProductoCuentaContable() {
		return this.activarid_centro_costoProductoCuentaContable;
	}

	public void setActivarid_centro_costoProductoCuentaContable(Boolean activarid_centro_costoProductoCuentaContable) {
		this.activarid_centro_costoProductoCuentaContable= activarid_centro_costoProductoCuentaContable;
	}

	public Boolean getCargarid_centro_costoProductoCuentaContable() {
		return this.cargarid_centro_costoProductoCuentaContable;
	}

	public void setCargarid_centro_costoProductoCuentaContable(Boolean cargarid_centro_costoProductoCuentaContable) {
		this.cargarid_centro_costoProductoCuentaContable= cargarid_centro_costoProductoCuentaContable;
	}

	public Border setResaltarid_cuenta_contable_inventarioProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productocuentacontableBeanSwingJInternalFrame.jTtoolBarProductoCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_inventarioProductoCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_inventarioProductoCuentaContable() {
		return this.resaltarid_cuenta_contable_inventarioProductoCuentaContable;
	}

	public void setResaltarid_cuenta_contable_inventarioProductoCuentaContable(Border borderResaltar) {
		this.resaltarid_cuenta_contable_inventarioProductoCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_inventarioProductoCuentaContable() {
		return this.mostrarid_cuenta_contable_inventarioProductoCuentaContable;
	}

	public void setMostrarid_cuenta_contable_inventarioProductoCuentaContable(Boolean mostrarid_cuenta_contable_inventarioProductoCuentaContable) {
		this.mostrarid_cuenta_contable_inventarioProductoCuentaContable= mostrarid_cuenta_contable_inventarioProductoCuentaContable;
	}

	public Boolean getActivarid_cuenta_contable_inventarioProductoCuentaContable() {
		return this.activarid_cuenta_contable_inventarioProductoCuentaContable;
	}

	public void setActivarid_cuenta_contable_inventarioProductoCuentaContable(Boolean activarid_cuenta_contable_inventarioProductoCuentaContable) {
		this.activarid_cuenta_contable_inventarioProductoCuentaContable= activarid_cuenta_contable_inventarioProductoCuentaContable;
	}

	public Boolean getCargarid_cuenta_contable_inventarioProductoCuentaContable() {
		return this.cargarid_cuenta_contable_inventarioProductoCuentaContable;
	}

	public void setCargarid_cuenta_contable_inventarioProductoCuentaContable(Boolean cargarid_cuenta_contable_inventarioProductoCuentaContable) {
		this.cargarid_cuenta_contable_inventarioProductoCuentaContable= cargarid_cuenta_contable_inventarioProductoCuentaContable;
	}

	public Border setResaltarid_cuenta_contable_costoProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productocuentacontableBeanSwingJInternalFrame.jTtoolBarProductoCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_costoProductoCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_costoProductoCuentaContable() {
		return this.resaltarid_cuenta_contable_costoProductoCuentaContable;
	}

	public void setResaltarid_cuenta_contable_costoProductoCuentaContable(Border borderResaltar) {
		this.resaltarid_cuenta_contable_costoProductoCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_costoProductoCuentaContable() {
		return this.mostrarid_cuenta_contable_costoProductoCuentaContable;
	}

	public void setMostrarid_cuenta_contable_costoProductoCuentaContable(Boolean mostrarid_cuenta_contable_costoProductoCuentaContable) {
		this.mostrarid_cuenta_contable_costoProductoCuentaContable= mostrarid_cuenta_contable_costoProductoCuentaContable;
	}

	public Boolean getActivarid_cuenta_contable_costoProductoCuentaContable() {
		return this.activarid_cuenta_contable_costoProductoCuentaContable;
	}

	public void setActivarid_cuenta_contable_costoProductoCuentaContable(Boolean activarid_cuenta_contable_costoProductoCuentaContable) {
		this.activarid_cuenta_contable_costoProductoCuentaContable= activarid_cuenta_contable_costoProductoCuentaContable;
	}

	public Boolean getCargarid_cuenta_contable_costoProductoCuentaContable() {
		return this.cargarid_cuenta_contable_costoProductoCuentaContable;
	}

	public void setCargarid_cuenta_contable_costoProductoCuentaContable(Boolean cargarid_cuenta_contable_costoProductoCuentaContable) {
		this.cargarid_cuenta_contable_costoProductoCuentaContable= cargarid_cuenta_contable_costoProductoCuentaContable;
	}

	public Border setResaltarid_cuenta_contable_ventaProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productocuentacontableBeanSwingJInternalFrame.jTtoolBarProductoCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_ventaProductoCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_ventaProductoCuentaContable() {
		return this.resaltarid_cuenta_contable_ventaProductoCuentaContable;
	}

	public void setResaltarid_cuenta_contable_ventaProductoCuentaContable(Border borderResaltar) {
		this.resaltarid_cuenta_contable_ventaProductoCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_ventaProductoCuentaContable() {
		return this.mostrarid_cuenta_contable_ventaProductoCuentaContable;
	}

	public void setMostrarid_cuenta_contable_ventaProductoCuentaContable(Boolean mostrarid_cuenta_contable_ventaProductoCuentaContable) {
		this.mostrarid_cuenta_contable_ventaProductoCuentaContable= mostrarid_cuenta_contable_ventaProductoCuentaContable;
	}

	public Boolean getActivarid_cuenta_contable_ventaProductoCuentaContable() {
		return this.activarid_cuenta_contable_ventaProductoCuentaContable;
	}

	public void setActivarid_cuenta_contable_ventaProductoCuentaContable(Boolean activarid_cuenta_contable_ventaProductoCuentaContable) {
		this.activarid_cuenta_contable_ventaProductoCuentaContable= activarid_cuenta_contable_ventaProductoCuentaContable;
	}

	public Boolean getCargarid_cuenta_contable_ventaProductoCuentaContable() {
		return this.cargarid_cuenta_contable_ventaProductoCuentaContable;
	}

	public void setCargarid_cuenta_contable_ventaProductoCuentaContable(Boolean cargarid_cuenta_contable_ventaProductoCuentaContable) {
		this.cargarid_cuenta_contable_ventaProductoCuentaContable= cargarid_cuenta_contable_ventaProductoCuentaContable;
	}

	public Border setResaltarid_cuenta_contable_descuentoProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productocuentacontableBeanSwingJInternalFrame.jTtoolBarProductoCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_descuentoProductoCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_descuentoProductoCuentaContable() {
		return this.resaltarid_cuenta_contable_descuentoProductoCuentaContable;
	}

	public void setResaltarid_cuenta_contable_descuentoProductoCuentaContable(Border borderResaltar) {
		this.resaltarid_cuenta_contable_descuentoProductoCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_descuentoProductoCuentaContable() {
		return this.mostrarid_cuenta_contable_descuentoProductoCuentaContable;
	}

	public void setMostrarid_cuenta_contable_descuentoProductoCuentaContable(Boolean mostrarid_cuenta_contable_descuentoProductoCuentaContable) {
		this.mostrarid_cuenta_contable_descuentoProductoCuentaContable= mostrarid_cuenta_contable_descuentoProductoCuentaContable;
	}

	public Boolean getActivarid_cuenta_contable_descuentoProductoCuentaContable() {
		return this.activarid_cuenta_contable_descuentoProductoCuentaContable;
	}

	public void setActivarid_cuenta_contable_descuentoProductoCuentaContable(Boolean activarid_cuenta_contable_descuentoProductoCuentaContable) {
		this.activarid_cuenta_contable_descuentoProductoCuentaContable= activarid_cuenta_contable_descuentoProductoCuentaContable;
	}

	public Boolean getCargarid_cuenta_contable_descuentoProductoCuentaContable() {
		return this.cargarid_cuenta_contable_descuentoProductoCuentaContable;
	}

	public void setCargarid_cuenta_contable_descuentoProductoCuentaContable(Boolean cargarid_cuenta_contable_descuentoProductoCuentaContable) {
		this.cargarid_cuenta_contable_descuentoProductoCuentaContable= cargarid_cuenta_contable_descuentoProductoCuentaContable;
	}

	public Border setResaltarid_cuenta_contable_devolucionProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productocuentacontableBeanSwingJInternalFrame.jTtoolBarProductoCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_devolucionProductoCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_devolucionProductoCuentaContable() {
		return this.resaltarid_cuenta_contable_devolucionProductoCuentaContable;
	}

	public void setResaltarid_cuenta_contable_devolucionProductoCuentaContable(Border borderResaltar) {
		this.resaltarid_cuenta_contable_devolucionProductoCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_devolucionProductoCuentaContable() {
		return this.mostrarid_cuenta_contable_devolucionProductoCuentaContable;
	}

	public void setMostrarid_cuenta_contable_devolucionProductoCuentaContable(Boolean mostrarid_cuenta_contable_devolucionProductoCuentaContable) {
		this.mostrarid_cuenta_contable_devolucionProductoCuentaContable= mostrarid_cuenta_contable_devolucionProductoCuentaContable;
	}

	public Boolean getActivarid_cuenta_contable_devolucionProductoCuentaContable() {
		return this.activarid_cuenta_contable_devolucionProductoCuentaContable;
	}

	public void setActivarid_cuenta_contable_devolucionProductoCuentaContable(Boolean activarid_cuenta_contable_devolucionProductoCuentaContable) {
		this.activarid_cuenta_contable_devolucionProductoCuentaContable= activarid_cuenta_contable_devolucionProductoCuentaContable;
	}

	public Boolean getCargarid_cuenta_contable_devolucionProductoCuentaContable() {
		return this.cargarid_cuenta_contable_devolucionProductoCuentaContable;
	}

	public void setCargarid_cuenta_contable_devolucionProductoCuentaContable(Boolean cargarid_cuenta_contable_devolucionProductoCuentaContable) {
		this.cargarid_cuenta_contable_devolucionProductoCuentaContable= cargarid_cuenta_contable_devolucionProductoCuentaContable;
	}

	public Border setResaltarid_cuenta_contable_debitoProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productocuentacontableBeanSwingJInternalFrame.jTtoolBarProductoCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_debitoProductoCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_debitoProductoCuentaContable() {
		return this.resaltarid_cuenta_contable_debitoProductoCuentaContable;
	}

	public void setResaltarid_cuenta_contable_debitoProductoCuentaContable(Border borderResaltar) {
		this.resaltarid_cuenta_contable_debitoProductoCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_debitoProductoCuentaContable() {
		return this.mostrarid_cuenta_contable_debitoProductoCuentaContable;
	}

	public void setMostrarid_cuenta_contable_debitoProductoCuentaContable(Boolean mostrarid_cuenta_contable_debitoProductoCuentaContable) {
		this.mostrarid_cuenta_contable_debitoProductoCuentaContable= mostrarid_cuenta_contable_debitoProductoCuentaContable;
	}

	public Boolean getActivarid_cuenta_contable_debitoProductoCuentaContable() {
		return this.activarid_cuenta_contable_debitoProductoCuentaContable;
	}

	public void setActivarid_cuenta_contable_debitoProductoCuentaContable(Boolean activarid_cuenta_contable_debitoProductoCuentaContable) {
		this.activarid_cuenta_contable_debitoProductoCuentaContable= activarid_cuenta_contable_debitoProductoCuentaContable;
	}

	public Boolean getCargarid_cuenta_contable_debitoProductoCuentaContable() {
		return this.cargarid_cuenta_contable_debitoProductoCuentaContable;
	}

	public void setCargarid_cuenta_contable_debitoProductoCuentaContable(Boolean cargarid_cuenta_contable_debitoProductoCuentaContable) {
		this.cargarid_cuenta_contable_debitoProductoCuentaContable= cargarid_cuenta_contable_debitoProductoCuentaContable;
	}

	public Border setResaltarid_cuenta_contable_creditoProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productocuentacontableBeanSwingJInternalFrame.jTtoolBarProductoCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_creditoProductoCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_creditoProductoCuentaContable() {
		return this.resaltarid_cuenta_contable_creditoProductoCuentaContable;
	}

	public void setResaltarid_cuenta_contable_creditoProductoCuentaContable(Border borderResaltar) {
		this.resaltarid_cuenta_contable_creditoProductoCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_creditoProductoCuentaContable() {
		return this.mostrarid_cuenta_contable_creditoProductoCuentaContable;
	}

	public void setMostrarid_cuenta_contable_creditoProductoCuentaContable(Boolean mostrarid_cuenta_contable_creditoProductoCuentaContable) {
		this.mostrarid_cuenta_contable_creditoProductoCuentaContable= mostrarid_cuenta_contable_creditoProductoCuentaContable;
	}

	public Boolean getActivarid_cuenta_contable_creditoProductoCuentaContable() {
		return this.activarid_cuenta_contable_creditoProductoCuentaContable;
	}

	public void setActivarid_cuenta_contable_creditoProductoCuentaContable(Boolean activarid_cuenta_contable_creditoProductoCuentaContable) {
		this.activarid_cuenta_contable_creditoProductoCuentaContable= activarid_cuenta_contable_creditoProductoCuentaContable;
	}

	public Boolean getCargarid_cuenta_contable_creditoProductoCuentaContable() {
		return this.cargarid_cuenta_contable_creditoProductoCuentaContable;
	}

	public void setCargarid_cuenta_contable_creditoProductoCuentaContable(Boolean cargarid_cuenta_contable_creditoProductoCuentaContable) {
		this.cargarid_cuenta_contable_creditoProductoCuentaContable= cargarid_cuenta_contable_creditoProductoCuentaContable;
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
		
		
		this.setMostraridProductoCuentaContable(esInicial);
		this.setMostrarid_empresaProductoCuentaContable(esInicial);
		this.setMostrarid_sucursalProductoCuentaContable(esInicial);
		this.setMostrarid_bodegaProductoCuentaContable(esInicial);
		this.setMostrarid_productoProductoCuentaContable(esInicial);
		this.setMostrarid_centro_costoProductoCuentaContable(esInicial);
		this.setMostrarid_cuenta_contable_inventarioProductoCuentaContable(esInicial);
		this.setMostrarid_cuenta_contable_costoProductoCuentaContable(esInicial);
		this.setMostrarid_cuenta_contable_ventaProductoCuentaContable(esInicial);
		this.setMostrarid_cuenta_contable_descuentoProductoCuentaContable(esInicial);
		this.setMostrarid_cuenta_contable_devolucionProductoCuentaContable(esInicial);
		this.setMostrarid_cuenta_contable_debitoProductoCuentaContable(esInicial);
		this.setMostrarid_cuenta_contable_creditoProductoCuentaContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.ID)) {
				this.setMostraridProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {
				this.setMostrarid_cuenta_contable_inventarioProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECOSTO)) {
				this.setMostrarid_cuenta_contable_costoProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEVENTA)) {
				this.setMostrarid_cuenta_contable_ventaProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {
				this.setMostrarid_cuenta_contable_descuentoProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {
				this.setMostrarid_cuenta_contable_devolucionProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setMostrarid_cuenta_contable_debitoProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setMostrarid_cuenta_contable_creditoProductoCuentaContable(esAsigna);
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
		
		
		this.setActivaridProductoCuentaContable(esInicial);
		this.setActivarid_empresaProductoCuentaContable(esInicial);
		this.setActivarid_sucursalProductoCuentaContable(esInicial);
		this.setActivarid_bodegaProductoCuentaContable(esInicial);
		this.setActivarid_productoProductoCuentaContable(esInicial);
		this.setActivarid_centro_costoProductoCuentaContable(esInicial);
		this.setActivarid_cuenta_contable_inventarioProductoCuentaContable(esInicial);
		this.setActivarid_cuenta_contable_costoProductoCuentaContable(esInicial);
		this.setActivarid_cuenta_contable_ventaProductoCuentaContable(esInicial);
		this.setActivarid_cuenta_contable_descuentoProductoCuentaContable(esInicial);
		this.setActivarid_cuenta_contable_devolucionProductoCuentaContable(esInicial);
		this.setActivarid_cuenta_contable_debitoProductoCuentaContable(esInicial);
		this.setActivarid_cuenta_contable_creditoProductoCuentaContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.ID)) {
				this.setActivaridProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {
				this.setActivarid_cuenta_contable_inventarioProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECOSTO)) {
				this.setActivarid_cuenta_contable_costoProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEVENTA)) {
				this.setActivarid_cuenta_contable_ventaProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {
				this.setActivarid_cuenta_contable_descuentoProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {
				this.setActivarid_cuenta_contable_devolucionProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setActivarid_cuenta_contable_debitoProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setActivarid_cuenta_contable_creditoProductoCuentaContable(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductoCuentaContable(esInicial);
		this.setResaltarid_empresaProductoCuentaContable(esInicial);
		this.setResaltarid_sucursalProductoCuentaContable(esInicial);
		this.setResaltarid_bodegaProductoCuentaContable(esInicial);
		this.setResaltarid_productoProductoCuentaContable(esInicial);
		this.setResaltarid_centro_costoProductoCuentaContable(esInicial);
		this.setResaltarid_cuenta_contable_inventarioProductoCuentaContable(esInicial);
		this.setResaltarid_cuenta_contable_costoProductoCuentaContable(esInicial);
		this.setResaltarid_cuenta_contable_ventaProductoCuentaContable(esInicial);
		this.setResaltarid_cuenta_contable_descuentoProductoCuentaContable(esInicial);
		this.setResaltarid_cuenta_contable_devolucionProductoCuentaContable(esInicial);
		this.setResaltarid_cuenta_contable_debitoProductoCuentaContable(esInicial);
		this.setResaltarid_cuenta_contable_creditoProductoCuentaContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.ID)) {
				this.setResaltaridProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {
				this.setResaltarid_cuenta_contable_inventarioProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECOSTO)) {
				this.setResaltarid_cuenta_contable_costoProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEVENTA)) {
				this.setResaltarid_cuenta_contable_ventaProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {
				this.setResaltarid_cuenta_contable_descuentoProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {
				this.setResaltarid_cuenta_contable_devolucionProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setResaltarid_cuenta_contable_debitoProductoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setResaltarid_cuenta_contable_creditoProductoCuentaContable(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaProductoCuentaContable=true;

	public Boolean getMostrarFK_IdBodegaProductoCuentaContable() {
		return this.mostrarFK_IdBodegaProductoCuentaContable;
	}

	public void setMostrarFK_IdBodegaProductoCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaProductoCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoProductoCuentaContable=true;

	public Boolean getMostrarFK_IdCentroCostoProductoCuentaContable() {
		return this.mostrarFK_IdCentroCostoProductoCuentaContable;
	}

	public void setMostrarFK_IdCentroCostoProductoCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoProductoCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCostoProductoCuentaContable=true;

	public Boolean getMostrarFK_IdCuentaContableCostoProductoCuentaContable() {
		return this.mostrarFK_IdCuentaContableCostoProductoCuentaContable;
	}

	public void setMostrarFK_IdCuentaContableCostoProductoCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCostoProductoCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCreditoProductoCuentaContable=true;

	public Boolean getMostrarFK_IdCuentaContableCreditoProductoCuentaContable() {
		return this.mostrarFK_IdCuentaContableCreditoProductoCuentaContable;
	}

	public void setMostrarFK_IdCuentaContableCreditoProductoCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCreditoProductoCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableDebitoProductoCuentaContable=true;

	public Boolean getMostrarFK_IdCuentaContableDebitoProductoCuentaContable() {
		return this.mostrarFK_IdCuentaContableDebitoProductoCuentaContable;
	}

	public void setMostrarFK_IdCuentaContableDebitoProductoCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableDebitoProductoCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableDescuentoProductoCuentaContable=true;

	public Boolean getMostrarFK_IdCuentaContableDescuentoProductoCuentaContable() {
		return this.mostrarFK_IdCuentaContableDescuentoProductoCuentaContable;
	}

	public void setMostrarFK_IdCuentaContableDescuentoProductoCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableDescuentoProductoCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableDevolucionProductoCuentaContable=true;

	public Boolean getMostrarFK_IdCuentaContableDevolucionProductoCuentaContable() {
		return this.mostrarFK_IdCuentaContableDevolucionProductoCuentaContable;
	}

	public void setMostrarFK_IdCuentaContableDevolucionProductoCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableDevolucionProductoCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableInventarioProductoCuentaContable=true;

	public Boolean getMostrarFK_IdCuentaContableInventarioProductoCuentaContable() {
		return this.mostrarFK_IdCuentaContableInventarioProductoCuentaContable;
	}

	public void setMostrarFK_IdCuentaContableInventarioProductoCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableInventarioProductoCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableVentaProductoCuentaContable=true;

	public Boolean getMostrarFK_IdCuentaContableVentaProductoCuentaContable() {
		return this.mostrarFK_IdCuentaContableVentaProductoCuentaContable;
	}

	public void setMostrarFK_IdCuentaContableVentaProductoCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableVentaProductoCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaProductoCuentaContable=true;

	public Boolean getMostrarFK_IdEmpresaProductoCuentaContable() {
		return this.mostrarFK_IdEmpresaProductoCuentaContable;
	}

	public void setMostrarFK_IdEmpresaProductoCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaProductoCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoProductoCuentaContable=true;

	public Boolean getMostrarFK_IdProductoProductoCuentaContable() {
		return this.mostrarFK_IdProductoProductoCuentaContable;
	}

	public void setMostrarFK_IdProductoProductoCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoProductoCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalProductoCuentaContable=true;

	public Boolean getMostrarFK_IdSucursalProductoCuentaContable() {
		return this.mostrarFK_IdSucursalProductoCuentaContable;
	}

	public void setMostrarFK_IdSucursalProductoCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalProductoCuentaContable= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaProductoCuentaContable=true;

	public Boolean getActivarFK_IdBodegaProductoCuentaContable() {
		return this.activarFK_IdBodegaProductoCuentaContable;
	}

	public void setActivarFK_IdBodegaProductoCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaProductoCuentaContable= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoProductoCuentaContable=true;

	public Boolean getActivarFK_IdCentroCostoProductoCuentaContable() {
		return this.activarFK_IdCentroCostoProductoCuentaContable;
	}

	public void setActivarFK_IdCentroCostoProductoCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoProductoCuentaContable= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCostoProductoCuentaContable=true;

	public Boolean getActivarFK_IdCuentaContableCostoProductoCuentaContable() {
		return this.activarFK_IdCuentaContableCostoProductoCuentaContable;
	}

	public void setActivarFK_IdCuentaContableCostoProductoCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCostoProductoCuentaContable= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCreditoProductoCuentaContable=true;

	public Boolean getActivarFK_IdCuentaContableCreditoProductoCuentaContable() {
		return this.activarFK_IdCuentaContableCreditoProductoCuentaContable;
	}

	public void setActivarFK_IdCuentaContableCreditoProductoCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCreditoProductoCuentaContable= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableDebitoProductoCuentaContable=true;

	public Boolean getActivarFK_IdCuentaContableDebitoProductoCuentaContable() {
		return this.activarFK_IdCuentaContableDebitoProductoCuentaContable;
	}

	public void setActivarFK_IdCuentaContableDebitoProductoCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableDebitoProductoCuentaContable= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableDescuentoProductoCuentaContable=true;

	public Boolean getActivarFK_IdCuentaContableDescuentoProductoCuentaContable() {
		return this.activarFK_IdCuentaContableDescuentoProductoCuentaContable;
	}

	public void setActivarFK_IdCuentaContableDescuentoProductoCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableDescuentoProductoCuentaContable= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableDevolucionProductoCuentaContable=true;

	public Boolean getActivarFK_IdCuentaContableDevolucionProductoCuentaContable() {
		return this.activarFK_IdCuentaContableDevolucionProductoCuentaContable;
	}

	public void setActivarFK_IdCuentaContableDevolucionProductoCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableDevolucionProductoCuentaContable= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableInventarioProductoCuentaContable=true;

	public Boolean getActivarFK_IdCuentaContableInventarioProductoCuentaContable() {
		return this.activarFK_IdCuentaContableInventarioProductoCuentaContable;
	}

	public void setActivarFK_IdCuentaContableInventarioProductoCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableInventarioProductoCuentaContable= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableVentaProductoCuentaContable=true;

	public Boolean getActivarFK_IdCuentaContableVentaProductoCuentaContable() {
		return this.activarFK_IdCuentaContableVentaProductoCuentaContable;
	}

	public void setActivarFK_IdCuentaContableVentaProductoCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableVentaProductoCuentaContable= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaProductoCuentaContable=true;

	public Boolean getActivarFK_IdEmpresaProductoCuentaContable() {
		return this.activarFK_IdEmpresaProductoCuentaContable;
	}

	public void setActivarFK_IdEmpresaProductoCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaProductoCuentaContable= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoProductoCuentaContable=true;

	public Boolean getActivarFK_IdProductoProductoCuentaContable() {
		return this.activarFK_IdProductoProductoCuentaContable;
	}

	public void setActivarFK_IdProductoProductoCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdProductoProductoCuentaContable= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalProductoCuentaContable=true;

	public Boolean getActivarFK_IdSucursalProductoCuentaContable() {
		return this.activarFK_IdSucursalProductoCuentaContable;
	}

	public void setActivarFK_IdSucursalProductoCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalProductoCuentaContable= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaProductoCuentaContable=null;

	public Border getResaltarFK_IdBodegaProductoCuentaContable() {
		return this.resaltarFK_IdBodegaProductoCuentaContable;
	}

	public void setResaltarFK_IdBodegaProductoCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdBodegaProductoCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdBodegaProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaProductoCuentaContable= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoProductoCuentaContable=null;

	public Border getResaltarFK_IdCentroCostoProductoCuentaContable() {
		return this.resaltarFK_IdCentroCostoProductoCuentaContable;
	}

	public void setResaltarFK_IdCentroCostoProductoCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoProductoCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoProductoCuentaContable= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCostoProductoCuentaContable=null;

	public Border getResaltarFK_IdCuentaContableCostoProductoCuentaContable() {
		return this.resaltarFK_IdCuentaContableCostoProductoCuentaContable;
	}

	public void setResaltarFK_IdCuentaContableCostoProductoCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCostoProductoCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCostoProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCostoProductoCuentaContable= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCreditoProductoCuentaContable=null;

	public Border getResaltarFK_IdCuentaContableCreditoProductoCuentaContable() {
		return this.resaltarFK_IdCuentaContableCreditoProductoCuentaContable;
	}

	public void setResaltarFK_IdCuentaContableCreditoProductoCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCreditoProductoCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCreditoProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCreditoProductoCuentaContable= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableDebitoProductoCuentaContable=null;

	public Border getResaltarFK_IdCuentaContableDebitoProductoCuentaContable() {
		return this.resaltarFK_IdCuentaContableDebitoProductoCuentaContable;
	}

	public void setResaltarFK_IdCuentaContableDebitoProductoCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableDebitoProductoCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableDebitoProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableDebitoProductoCuentaContable= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableDescuentoProductoCuentaContable=null;

	public Border getResaltarFK_IdCuentaContableDescuentoProductoCuentaContable() {
		return this.resaltarFK_IdCuentaContableDescuentoProductoCuentaContable;
	}

	public void setResaltarFK_IdCuentaContableDescuentoProductoCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableDescuentoProductoCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableDescuentoProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableDescuentoProductoCuentaContable= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableDevolucionProductoCuentaContable=null;

	public Border getResaltarFK_IdCuentaContableDevolucionProductoCuentaContable() {
		return this.resaltarFK_IdCuentaContableDevolucionProductoCuentaContable;
	}

	public void setResaltarFK_IdCuentaContableDevolucionProductoCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableDevolucionProductoCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableDevolucionProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableDevolucionProductoCuentaContable= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableInventarioProductoCuentaContable=null;

	public Border getResaltarFK_IdCuentaContableInventarioProductoCuentaContable() {
		return this.resaltarFK_IdCuentaContableInventarioProductoCuentaContable;
	}

	public void setResaltarFK_IdCuentaContableInventarioProductoCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableInventarioProductoCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableInventarioProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableInventarioProductoCuentaContable= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableVentaProductoCuentaContable=null;

	public Border getResaltarFK_IdCuentaContableVentaProductoCuentaContable() {
		return this.resaltarFK_IdCuentaContableVentaProductoCuentaContable;
	}

	public void setResaltarFK_IdCuentaContableVentaProductoCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableVentaProductoCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableVentaProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableVentaProductoCuentaContable= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaProductoCuentaContable=null;

	public Border getResaltarFK_IdEmpresaProductoCuentaContable() {
		return this.resaltarFK_IdEmpresaProductoCuentaContable;
	}

	public void setResaltarFK_IdEmpresaProductoCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdEmpresaProductoCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaProductoCuentaContable= borderResaltar;
	}

	public Border resaltarFK_IdProductoProductoCuentaContable=null;

	public Border getResaltarFK_IdProductoProductoCuentaContable() {
		return this.resaltarFK_IdProductoProductoCuentaContable;
	}

	public void setResaltarFK_IdProductoProductoCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdProductoProductoCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdProductoProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoProductoCuentaContable= borderResaltar;
	}

	public Border resaltarFK_IdSucursalProductoCuentaContable=null;

	public Border getResaltarFK_IdSucursalProductoCuentaContable() {
		return this.resaltarFK_IdSucursalProductoCuentaContable;
	}

	public void setResaltarFK_IdSucursalProductoCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdSucursalProductoCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdSucursalProductoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCuentaContableBeanSwingJInternalFrame productocuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalProductoCuentaContable= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}