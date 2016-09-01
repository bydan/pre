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


import com.bydan.erp.produccion.util.ProductoProduGastoConstantesFunciones;
import com.bydan.erp.produccion.util.ProductoProduGastoParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProductoProduGastoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;



import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProductoProduGastoConstantesFunciones extends ProductoProduGastoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProductoProduGasto";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductoProduGasto"+ProductoProduGastoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductoProduGastoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductoProduGastoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductoProduGastoConstantesFunciones.SCHEMA+"_"+ProductoProduGastoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductoProduGastoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductoProduGastoConstantesFunciones.SCHEMA+"_"+ProductoProduGastoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductoProduGastoConstantesFunciones.SCHEMA+"_"+ProductoProduGastoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductoProduGastoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductoProduGastoConstantesFunciones.SCHEMA+"_"+ProductoProduGastoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProduGastoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoProduGastoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProduGastoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProduGastoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoProduGastoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoProduGastoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductoProduGastoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductoProduGastoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductoProduGastoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductoProduGastoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Producto Gasto Producciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Producto Gasto Produccion";
	public static final String SCLASSWEBTITULO_LOWER="Producto Produ Gasto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductoProduGasto";
	public static final String OBJECTNAME="productoprodugasto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="producto_produ_gasto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productoprodugasto from "+ProductoProduGastoConstantesFunciones.SPERSISTENCENAME+" productoprodugasto";
	public static String QUERYSELECTNATIVE="select "+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".id,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".version_row,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".id_producto_defi_produ,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".id_tipo_gasto_produ_empresa,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".id_cuenta_contable_debito,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".id_cliente_proveedor,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".id_factura,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".id_unidad,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".canitdad,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".costo,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".costo_total,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".descripcion from "+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME;//+" as "+ProductoProduGastoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProductoProduGastoConstantesFuncionesAdditional productoprodugastoConstantesFuncionesAdditional=null;
	
	public ProductoProduGastoConstantesFuncionesAdditional getProductoProduGastoConstantesFuncionesAdditional() {
		return this.productoprodugastoConstantesFuncionesAdditional;
	}
	
	public void setProductoProduGastoConstantesFuncionesAdditional(ProductoProduGastoConstantesFuncionesAdditional productoprodugastoConstantesFuncionesAdditional) {
		try {
			this.productoprodugastoConstantesFuncionesAdditional=productoprodugastoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPRODUCTODEFIPRODU= "id_producto_defi_produ";
    public static final String IDTIPOGASTOPRODUEMPRESA= "id_tipo_gasto_produ_empresa";
    public static final String IDCUENTACONTABLEDEBITO= "id_cuenta_contable_debito";
    public static final String IDCUENTACONTABLECREDITO= "id_cuenta_contable_credito";
    public static final String IDCLIENTEPROVEEDOR= "id_cliente_proveedor";
    public static final String IDFACTURA= "id_factura";
    public static final String IDUNIDAD= "id_unidad";
    public static final String CANTIDAD= "canitdad";
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
    	public static final String LABEL_IDTIPOGASTOPRODUEMPRESA= "Tipo Gasto Produ Empresa";
		public static final String LABEL_IDTIPOGASTOPRODUEMPRESA_LOWER= "Tipo Gasto Produ Empresa";
    	public static final String LABEL_IDCUENTACONTABLEDEBITO= "Cuenta Contable Debito";
		public static final String LABEL_IDCUENTACONTABLEDEBITO_LOWER= "Cuenta Contable Debito";
    	public static final String LABEL_IDCUENTACONTABLECREDITO= "Cuenta Contable Credito";
		public static final String LABEL_IDCUENTACONTABLECREDITO_LOWER= "Cuenta Contable Credito";
    	public static final String LABEL_IDCLIENTEPROVEEDOR= "Cliente Proveedor";
		public static final String LABEL_IDCLIENTEPROVEEDOR_LOWER= "Cliente Proveedor";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_IDUNIDAD= "Unad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_COSTO= "Costo";
		public static final String LABEL_COSTO_LOWER= "Costo";
    	public static final String LABEL_COSTOTOTAL= "Costo Total";
		public static final String LABEL_COSTOTOTAL_LOWER= "Costo Total";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProductoProduGastoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductoProduGastoConstantesFunciones.IDPRODUCTODEFIPRODU)) {sLabelColumna=ProductoProduGastoConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU;}
		if(sNombreColumna.equals(ProductoProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA)) {sLabelColumna=ProductoProduGastoConstantesFunciones.LABEL_IDTIPOGASTOPRODUEMPRESA;}
		if(sNombreColumna.equals(ProductoProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO)) {sLabelColumna=ProductoProduGastoConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO;}
		if(sNombreColumna.equals(ProductoProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO)) {sLabelColumna=ProductoProduGastoConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO;}
		if(sNombreColumna.equals(ProductoProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR)) {sLabelColumna=ProductoProduGastoConstantesFunciones.LABEL_IDCLIENTEPROVEEDOR;}
		if(sNombreColumna.equals(ProductoProduGastoConstantesFunciones.IDFACTURA)) {sLabelColumna=ProductoProduGastoConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(ProductoProduGastoConstantesFunciones.IDUNIDAD)) {sLabelColumna=ProductoProduGastoConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(ProductoProduGastoConstantesFunciones.CANTIDAD)) {sLabelColumna=ProductoProduGastoConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(ProductoProduGastoConstantesFunciones.COSTO)) {sLabelColumna=ProductoProduGastoConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(ProductoProduGastoConstantesFunciones.COSTOTOTAL)) {sLabelColumna=ProductoProduGastoConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(ProductoProduGastoConstantesFunciones.DESCRIPCION)) {sLabelColumna=ProductoProduGastoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProductoProduGastoDescripcion(ProductoProduGasto productoprodugasto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productoprodugasto !=null/* && productoprodugasto.getId()!=0*/) {
			if(productoprodugasto.getId()!=null) {
				sDescripcion=productoprodugasto.getId().toString();
			}//productoprodugastoproductoprodugasto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductoProduGastoDescripcionDetallado(ProductoProduGasto productoprodugasto) {
		String sDescripcion="";
			
		sDescripcion+=ProductoProduGastoConstantesFunciones.ID+"=";
		sDescripcion+=productoprodugasto.getId().toString()+",";
		sDescripcion+=ProductoProduGastoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productoprodugasto.getVersionRow().toString()+",";
		sDescripcion+=ProductoProduGastoConstantesFunciones.IDPRODUCTODEFIPRODU+"=";
		sDescripcion+=productoprodugasto.getid_producto_defi_produ().toString()+",";
		sDescripcion+=ProductoProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA+"=";
		sDescripcion+=productoprodugasto.getid_tipo_gasto_produ_empresa().toString()+",";
		sDescripcion+=ProductoProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO+"=";
		sDescripcion+=productoprodugasto.getid_cuenta_contable_debito().toString()+",";
		sDescripcion+=ProductoProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO+"=";
		sDescripcion+=productoprodugasto.getid_cuenta_contable_credito().toString()+",";
		sDescripcion+=ProductoProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR+"=";
		sDescripcion+=productoprodugasto.getid_cliente_proveedor().toString()+",";
		sDescripcion+=ProductoProduGastoConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=productoprodugasto.getid_factura().toString()+",";
		sDescripcion+=ProductoProduGastoConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=productoprodugasto.getid_unidad().toString()+",";
		sDescripcion+=ProductoProduGastoConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=productoprodugasto.getcanitdad().toString()+",";
		sDescripcion+=ProductoProduGastoConstantesFunciones.COSTO+"=";
		sDescripcion+=productoprodugasto.getcosto().toString()+",";
		sDescripcion+=ProductoProduGastoConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=productoprodugasto.getcosto_total().toString()+",";
		sDescripcion+=ProductoProduGastoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=productoprodugasto.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setProductoProduGastoDescripcion(ProductoProduGasto productoprodugasto,String sValor) throws Exception {			
		if(productoprodugasto !=null) {
			//productoprodugastoproductoprodugasto.getId().toString();
		}		
	}
	
		

	public static String getProductoDefiProduDescripcion(ProductoDefiProdu productodefiprodu) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(productodefiprodu!=null/*&&productodefiprodu.getId()>0*/) {
			sDescripcion=ProductoDefiProduConstantesFunciones.getProductoDefiProduDescripcion(productodefiprodu);
		}

		return sDescripcion;
	}

	public static String getTipoGastoProduEmpresaDescripcion(TipoGastoProduEmpresa tipogastoproduempresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipogastoproduempresa!=null/*&&tipogastoproduempresa.getId()>0*/) {
			sDescripcion=TipoGastoProduEmpresaConstantesFunciones.getTipoGastoProduEmpresaDescripcion(tipogastoproduempresa);
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

	public static String getClienteProveedorDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getFacturaDescripcion(Factura factura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factura!=null/*&&factura.getId()>0*/) {
			sDescripcion=FacturaConstantesFunciones.getFacturaDescripcion(factura);
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
		} else if(sNombreIndice.equals("FK_IdClienteProveedor")) {
			sNombreIndice="Tipo=  Por Cliente Proveedor";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCredito")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Credito";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDebito")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Debito";
		} else if(sNombreIndice.equals("FK_IdFactura")) {
			sNombreIndice="Tipo=  Por Factura";
		} else if(sNombreIndice.equals("FK_IdProductoDefiProdu")) {
			sNombreIndice="Tipo=  Por Producto Defi Produ";
		} else if(sNombreIndice.equals("FK_IdTipoGastoProduEmpresa")) {
			sNombreIndice="Tipo=  Por Tipo Gasto Produ Empresa";
		} else if(sNombreIndice.equals("FK_IdUnidad")) {
			sNombreIndice="Tipo=  Por Unad";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdClienteProveedor(Long id_cliente_proveedor) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente_proveedor!=null) {sDetalleIndice+=" Codigo Unico De Cliente Proveedor="+id_cliente_proveedor.toString();} 

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

	public static String getDetalleIndiceFK_IdFactura(Long id_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_factura!=null) {sDetalleIndice+=" Codigo Unico De Factura="+id_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProductoDefiProdu(Long id_producto_defi_produ) {
		String sDetalleIndice=" Parametros->";
		if(id_producto_defi_produ!=null) {sDetalleIndice+=" Codigo Unico De Producto Defi Produ="+id_producto_defi_produ.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoGastoProduEmpresa(Long id_tipo_gasto_produ_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_gasto_produ_empresa!=null) {sDetalleIndice+=" Codigo Unico De Tipo Gasto Produ Empresa="+id_tipo_gasto_produ_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProductoProduGasto(ProductoProduGasto productoprodugasto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productoprodugasto.setdescripcion(productoprodugasto.getdescripcion().trim());
	}
	
	public static void quitarEspaciosProductoProduGastos(List<ProductoProduGasto> productoprodugastos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoProduGasto productoprodugasto: productoprodugastos) {
			productoprodugasto.setdescripcion(productoprodugasto.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoProduGasto(ProductoProduGasto productoprodugasto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productoprodugasto.getConCambioAuxiliar()) {
			productoprodugasto.setIsDeleted(productoprodugasto.getIsDeletedAuxiliar());	
			productoprodugasto.setIsNew(productoprodugasto.getIsNewAuxiliar());	
			productoprodugasto.setIsChanged(productoprodugasto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productoprodugasto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productoprodugasto.setIsDeletedAuxiliar(false);	
			productoprodugasto.setIsNewAuxiliar(false);	
			productoprodugasto.setIsChangedAuxiliar(false);
			
			productoprodugasto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoProduGastos(List<ProductoProduGasto> productoprodugastos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductoProduGasto productoprodugasto : productoprodugastos) {
			if(conAsignarBase && productoprodugasto.getConCambioAuxiliar()) {
				productoprodugasto.setIsDeleted(productoprodugasto.getIsDeletedAuxiliar());	
				productoprodugasto.setIsNew(productoprodugasto.getIsNewAuxiliar());	
				productoprodugasto.setIsChanged(productoprodugasto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productoprodugasto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productoprodugasto.setIsDeletedAuxiliar(false);	
				productoprodugasto.setIsNewAuxiliar(false);	
				productoprodugasto.setIsChangedAuxiliar(false);
				
				productoprodugasto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductoProduGasto(ProductoProduGasto productoprodugasto,Boolean conEnteros) throws Exception  {
		productoprodugasto.setcosto(0.0);
		productoprodugasto.setcosto_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			productoprodugasto.setcanitdad(0);
		}
	}		
	
	public static void InicializarValoresProductoProduGastos(List<ProductoProduGasto> productoprodugastos,Boolean conEnteros) throws Exception  {
		
		for(ProductoProduGasto productoprodugasto: productoprodugastos) {
			productoprodugasto.setcosto(0.0);
			productoprodugasto.setcosto_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				productoprodugasto.setcanitdad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductoProduGasto(List<ProductoProduGasto> productoprodugastos,ProductoProduGasto productoprodugastoAux) throws Exception  {
		ProductoProduGastoConstantesFunciones.InicializarValoresProductoProduGasto(productoprodugastoAux,true);
		
		for(ProductoProduGasto productoprodugasto: productoprodugastos) {
			if(productoprodugasto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productoprodugastoAux.setcanitdad(productoprodugastoAux.getcanitdad()+productoprodugasto.getcanitdad());			
			productoprodugastoAux.setcosto(productoprodugastoAux.getcosto()+productoprodugasto.getcosto());			
			productoprodugastoAux.setcosto_total(productoprodugastoAux.getcosto_total()+productoprodugasto.getcosto_total());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoProduGasto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductoProduGastoConstantesFunciones.getArrayColumnasGlobalesProductoProduGasto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoProduGasto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductoProduGasto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoProduGasto> productoprodugastos,ProductoProduGasto productoprodugasto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoProduGasto productoprodugastoAux: productoprodugastos) {
			if(productoprodugastoAux!=null && productoprodugasto!=null) {
				if((productoprodugastoAux.getId()==null && productoprodugasto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productoprodugastoAux.getId()!=null && productoprodugasto.getId()!=null){
					if(productoprodugastoAux.getId().equals(productoprodugasto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoProduGasto(List<ProductoProduGasto> productoprodugastos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costoTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(ProductoProduGasto productoprodugasto: productoprodugastos) {			
			if(productoprodugasto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costoTotal+=productoprodugasto.getcosto();
			costo_totalTotal+=productoprodugasto.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoProduGastoConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(ProductoProduGastoConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoProduGastoConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(ProductoProduGastoConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductoProduGasto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductoProduGastoConstantesFunciones.LABEL_ID, ProductoProduGastoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduGastoConstantesFunciones.LABEL_VERSIONROW, ProductoProduGastoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduGastoConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU, ProductoProduGastoConstantesFunciones.IDPRODUCTODEFIPRODU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduGastoConstantesFunciones.LABEL_IDTIPOGASTOPRODUEMPRESA, ProductoProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduGastoConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO, ProductoProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduGastoConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO, ProductoProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduGastoConstantesFunciones.LABEL_IDCLIENTEPROVEEDOR, ProductoProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduGastoConstantesFunciones.LABEL_IDFACTURA, ProductoProduGastoConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduGastoConstantesFunciones.LABEL_IDUNIDAD, ProductoProduGastoConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduGastoConstantesFunciones.LABEL_CANTIDAD, ProductoProduGastoConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduGastoConstantesFunciones.LABEL_COSTO, ProductoProduGastoConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduGastoConstantesFunciones.LABEL_COSTOTOTAL, ProductoProduGastoConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoProduGastoConstantesFunciones.LABEL_DESCRIPCION, ProductoProduGastoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductoProduGasto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductoProduGastoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduGastoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduGastoConstantesFunciones.IDPRODUCTODEFIPRODU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduGastoConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduGastoConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduGastoConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduGastoConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduGastoConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoProduGastoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoProduGasto() throws Exception  {
		return ProductoProduGastoConstantesFunciones.getTiposSeleccionarProductoProduGasto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoProduGasto(Boolean conFk) throws Exception  {
		return ProductoProduGastoConstantesFunciones.getTiposSeleccionarProductoProduGasto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoProduGasto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduGastoConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU);
			reporte.setsDescripcion(ProductoProduGastoConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduGastoConstantesFunciones.LABEL_IDTIPOGASTOPRODUEMPRESA);
			reporte.setsDescripcion(ProductoProduGastoConstantesFunciones.LABEL_IDTIPOGASTOPRODUEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduGastoConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);
			reporte.setsDescripcion(ProductoProduGastoConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduGastoConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
			reporte.setsDescripcion(ProductoProduGastoConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduGastoConstantesFunciones.LABEL_IDCLIENTEPROVEEDOR);
			reporte.setsDescripcion(ProductoProduGastoConstantesFunciones.LABEL_IDCLIENTEPROVEEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduGastoConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(ProductoProduGastoConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduGastoConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(ProductoProduGastoConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduGastoConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(ProductoProduGastoConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduGastoConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(ProductoProduGastoConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduGastoConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(ProductoProduGastoConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoProduGastoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ProductoProduGastoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductoProduGasto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductoProduGasto(ProductoProduGasto productoprodugastoAux) throws Exception {
		
			productoprodugastoAux.setproductodefiprodu_descripcion(ProductoDefiProduConstantesFunciones.getProductoDefiProduDescripcion(productoprodugastoAux.getProductoDefiProdu()));
			productoprodugastoAux.settipogastoproduempresa_descripcion(TipoGastoProduEmpresaConstantesFunciones.getTipoGastoProduEmpresaDescripcion(productoprodugastoAux.getTipoGastoProduEmpresa()));
			productoprodugastoAux.setcuentacontabledebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(productoprodugastoAux.getCuentaContableDebito()));
			productoprodugastoAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(productoprodugastoAux.getCuentaContableCredito()));
			productoprodugastoAux.setclienteproveedor_descripcion(ClienteConstantesFunciones.getClienteDescripcion(productoprodugastoAux.getClienteProveedor()));
			productoprodugastoAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(productoprodugastoAux.getFactura()));
			productoprodugastoAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoprodugastoAux.getUnidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductoProduGasto(List<ProductoProduGasto> productoprodugastosTemp) throws Exception {
		for(ProductoProduGasto productoprodugastoAux:productoprodugastosTemp) {
			
			productoprodugastoAux.setproductodefiprodu_descripcion(ProductoDefiProduConstantesFunciones.getProductoDefiProduDescripcion(productoprodugastoAux.getProductoDefiProdu()));
			productoprodugastoAux.settipogastoproduempresa_descripcion(TipoGastoProduEmpresaConstantesFunciones.getTipoGastoProduEmpresaDescripcion(productoprodugastoAux.getTipoGastoProduEmpresa()));
			productoprodugastoAux.setcuentacontabledebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(productoprodugastoAux.getCuentaContableDebito()));
			productoprodugastoAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(productoprodugastoAux.getCuentaContableCredito()));
			productoprodugastoAux.setclienteproveedor_descripcion(ClienteConstantesFunciones.getClienteDescripcion(productoprodugastoAux.getClienteProveedor()));
			productoprodugastoAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(productoprodugastoAux.getFactura()));
			productoprodugastoAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoprodugastoAux.getUnidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductoProduGasto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ProductoDefiProdu.class));
				classes.add(new Classe(TipoGastoProduEmpresa.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(Unidad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoDefiProdu.class)) {
						classes.add(new Classe(ProductoDefiProdu.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoGastoProduEmpresa.class)) {
						classes.add(new Classe(TipoGastoProduEmpresa.class));
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
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductoProduGasto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoDefiProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoDefiProdu.class)); continue;
					}

					if(TipoGastoProduEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGastoProduEmpresa.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
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

					if(TipoGastoProduEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGastoProduEmpresa.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoProduGasto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoProduGastoConstantesFunciones.getClassesRelationshipsOfProductoProduGasto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoProduGasto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoProduGasto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoProduGastoConstantesFunciones.getClassesRelationshipsFromStringsOfProductoProduGasto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoProduGasto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductoProduGasto productoprodugasto,List<ProductoProduGasto> productoprodugastos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProductoProduGasto productoprodugastoEncontrado=null;
			
			for(ProductoProduGasto productoprodugastoLocal:productoprodugastos) {
				if(productoprodugastoLocal.getId().equals(productoprodugasto.getId())) {
					productoprodugastoEncontrado=productoprodugastoLocal;
					
					productoprodugastoLocal.setIsChanged(productoprodugasto.getIsChanged());
					productoprodugastoLocal.setIsNew(productoprodugasto.getIsNew());
					productoprodugastoLocal.setIsDeleted(productoprodugasto.getIsDeleted());
					
					productoprodugastoLocal.setGeneralEntityOriginal(productoprodugasto.getGeneralEntityOriginal());
					
					productoprodugastoLocal.setId(productoprodugasto.getId());	
					productoprodugastoLocal.setVersionRow(productoprodugasto.getVersionRow());	
					productoprodugastoLocal.setid_producto_defi_produ(productoprodugasto.getid_producto_defi_produ());	
					productoprodugastoLocal.setid_tipo_gasto_produ_empresa(productoprodugasto.getid_tipo_gasto_produ_empresa());	
					productoprodugastoLocal.setid_cuenta_contable_debito(productoprodugasto.getid_cuenta_contable_debito());	
					productoprodugastoLocal.setid_cuenta_contable_credito(productoprodugasto.getid_cuenta_contable_credito());	
					productoprodugastoLocal.setid_cliente_proveedor(productoprodugasto.getid_cliente_proveedor());	
					productoprodugastoLocal.setid_factura(productoprodugasto.getid_factura());	
					productoprodugastoLocal.setid_unidad(productoprodugasto.getid_unidad());	
					productoprodugastoLocal.setcanitdad(productoprodugasto.getcanitdad());	
					productoprodugastoLocal.setcosto(productoprodugasto.getcosto());	
					productoprodugastoLocal.setcosto_total(productoprodugasto.getcosto_total());	
					productoprodugastoLocal.setdescripcion(productoprodugasto.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!productoprodugasto.getIsDeleted()) {
				if(!existe) {
					productoprodugastos.add(productoprodugasto);
				}
			} else {
				if(productoprodugastoEncontrado!=null && permiteQuitar)  {
					productoprodugastos.remove(productoprodugastoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProductoProduGasto productoprodugasto,List<ProductoProduGasto> productoprodugastos) throws Exception {
		try	{			
			for(ProductoProduGasto productoprodugastoLocal:productoprodugastos) {
				if(productoprodugastoLocal.getId().equals(productoprodugasto.getId())) {
					productoprodugastoLocal.setIsSelected(productoprodugasto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductoProduGasto(List<ProductoProduGasto> productoprodugastosAux) throws Exception {
		//this.productoprodugastosAux=productoprodugastosAux;
		
		for(ProductoProduGasto productoprodugastoAux:productoprodugastosAux) {
			if(productoprodugastoAux.getIsChanged()) {
				productoprodugastoAux.setIsChanged(false);
			}		
			
			if(productoprodugastoAux.getIsNew()) {
				productoprodugastoAux.setIsNew(false);
			}	
			
			if(productoprodugastoAux.getIsDeleted()) {
				productoprodugastoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductoProduGasto(ProductoProduGasto productoprodugastoAux) throws Exception {
		//this.productoprodugastoAux=productoprodugastoAux;
		
			if(productoprodugastoAux.getIsChanged()) {
				productoprodugastoAux.setIsChanged(false);
			}		
			
			if(productoprodugastoAux.getIsNew()) {
				productoprodugastoAux.setIsNew(false);
			}	
			
			if(productoprodugastoAux.getIsDeleted()) {
				productoprodugastoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductoProduGasto productoprodugastoAsignar,ProductoProduGasto productoprodugasto) throws Exception {
		productoprodugastoAsignar.setId(productoprodugasto.getId());	
		productoprodugastoAsignar.setVersionRow(productoprodugasto.getVersionRow());	
		productoprodugastoAsignar.setid_producto_defi_produ(productoprodugasto.getid_producto_defi_produ());
		productoprodugastoAsignar.setproductodefiprodu_descripcion(productoprodugasto.getproductodefiprodu_descripcion());	
		productoprodugastoAsignar.setid_tipo_gasto_produ_empresa(productoprodugasto.getid_tipo_gasto_produ_empresa());
		productoprodugastoAsignar.settipogastoproduempresa_descripcion(productoprodugasto.gettipogastoproduempresa_descripcion());	
		productoprodugastoAsignar.setid_cuenta_contable_debito(productoprodugasto.getid_cuenta_contable_debito());
		productoprodugastoAsignar.setcuentacontabledebito_descripcion(productoprodugasto.getcuentacontabledebito_descripcion());	
		productoprodugastoAsignar.setid_cuenta_contable_credito(productoprodugasto.getid_cuenta_contable_credito());
		productoprodugastoAsignar.setcuentacontablecredito_descripcion(productoprodugasto.getcuentacontablecredito_descripcion());	
		productoprodugastoAsignar.setid_cliente_proveedor(productoprodugasto.getid_cliente_proveedor());
		productoprodugastoAsignar.setclienteproveedor_descripcion(productoprodugasto.getclienteproveedor_descripcion());	
		productoprodugastoAsignar.setid_factura(productoprodugasto.getid_factura());
		productoprodugastoAsignar.setfactura_descripcion(productoprodugasto.getfactura_descripcion());	
		productoprodugastoAsignar.setid_unidad(productoprodugasto.getid_unidad());
		productoprodugastoAsignar.setunidad_descripcion(productoprodugasto.getunidad_descripcion());	
		productoprodugastoAsignar.setcanitdad(productoprodugasto.getcanitdad());	
		productoprodugastoAsignar.setcosto(productoprodugasto.getcosto());	
		productoprodugastoAsignar.setcosto_total(productoprodugasto.getcosto_total());	
		productoprodugastoAsignar.setdescripcion(productoprodugasto.getdescripcion());	
	}
	
	public static void inicializarProductoProduGasto(ProductoProduGasto productoprodugasto) throws Exception {
		try {
				productoprodugasto.setId(0L);	
					
				productoprodugasto.setid_producto_defi_produ(-1L);	
				productoprodugasto.setid_tipo_gasto_produ_empresa(-1L);	
				productoprodugasto.setid_cuenta_contable_debito(-1L);	
				productoprodugasto.setid_cuenta_contable_credito(-1L);	
				productoprodugasto.setid_cliente_proveedor(-1L);	
				productoprodugasto.setid_factura(-1L);	
				productoprodugasto.setid_unidad(-1L);	
				productoprodugasto.setcanitdad(0);	
				productoprodugasto.setcosto(0.0);	
				productoprodugasto.setcosto_total(0.0);	
				productoprodugasto.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductoProduGasto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduGastoConstantesFunciones.LABEL_IDPRODUCTODEFIPRODU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduGastoConstantesFunciones.LABEL_IDTIPOGASTOPRODUEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduGastoConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduGastoConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduGastoConstantesFunciones.LABEL_IDCLIENTEPROVEEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduGastoConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduGastoConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduGastoConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduGastoConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduGastoConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoProduGastoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductoProduGasto(String sTipo,Row row,Workbook workbook,ProductoProduGasto productoprodugasto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodugasto.getproductodefiprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodugasto.gettipogastoproduempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodugasto.getcuentacontabledebito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodugasto.getcuentacontablecredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodugasto.getclienteproveedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodugasto.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodugasto.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodugasto.getcanitdad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodugasto.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodugasto.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoprodugasto.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductoProduGasto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProductoProduGasto() {
		return this.sFinalQueryProductoProduGasto;
	}
	
	public void setsFinalQueryProductoProduGasto(String sFinalQueryProductoProduGasto) {
		this.sFinalQueryProductoProduGasto= sFinalQueryProductoProduGasto;
	}
	
	public Border resaltarSeleccionarProductoProduGasto=null;
	
	public Border setResaltarSeleccionarProductoProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduGastoBeanSwingJInternalFrame productoprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productoprodugastoBeanSwingJInternalFrame.jTtoolBarProductoProduGasto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductoProduGasto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductoProduGasto() {
		return this.resaltarSeleccionarProductoProduGasto;
	}
	
	public void setResaltarSeleccionarProductoProduGasto(Border borderResaltarSeleccionarProductoProduGasto) {
		this.resaltarSeleccionarProductoProduGasto= borderResaltarSeleccionarProductoProduGasto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductoProduGasto=null;
	public Boolean mostraridProductoProduGasto=true;
	public Boolean activaridProductoProduGasto=true;

	public Border resaltarid_producto_defi_produProductoProduGasto=null;
	public Boolean mostrarid_producto_defi_produProductoProduGasto=true;
	public Boolean activarid_producto_defi_produProductoProduGasto=true;
	public Boolean cargarid_producto_defi_produProductoProduGasto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_producto_defi_produProductoProduGasto=false;//ConEventDepend=true

	public Border resaltarid_tipo_gasto_produ_empresaProductoProduGasto=null;
	public Boolean mostrarid_tipo_gasto_produ_empresaProductoProduGasto=true;
	public Boolean activarid_tipo_gasto_produ_empresaProductoProduGasto=true;
	public Boolean cargarid_tipo_gasto_produ_empresaProductoProduGasto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_gasto_produ_empresaProductoProduGasto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_debitoProductoProduGasto=null;
	public Boolean mostrarid_cuenta_contable_debitoProductoProduGasto=true;
	public Boolean activarid_cuenta_contable_debitoProductoProduGasto=true;
	public Boolean cargarid_cuenta_contable_debitoProductoProduGasto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_debitoProductoProduGasto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_creditoProductoProduGasto=null;
	public Boolean mostrarid_cuenta_contable_creditoProductoProduGasto=true;
	public Boolean activarid_cuenta_contable_creditoProductoProduGasto=true;
	public Boolean cargarid_cuenta_contable_creditoProductoProduGasto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_creditoProductoProduGasto=false;//ConEventDepend=true

	public Border resaltarid_cliente_proveedorProductoProduGasto=null;
	public Boolean mostrarid_cliente_proveedorProductoProduGasto=true;
	public Boolean activarid_cliente_proveedorProductoProduGasto=true;
	public Boolean cargarid_cliente_proveedorProductoProduGasto=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cliente_proveedorProductoProduGasto=false;//ConEventDepend=true

	public Border resaltarid_facturaProductoProduGasto=null;
	public Boolean mostrarid_facturaProductoProduGasto=true;
	public Boolean activarid_facturaProductoProduGasto=true;
	public Boolean cargarid_facturaProductoProduGasto=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaProductoProduGasto=false;//ConEventDepend=true

	public Border resaltarid_unidadProductoProduGasto=null;
	public Boolean mostrarid_unidadProductoProduGasto=true;
	public Boolean activarid_unidadProductoProduGasto=true;
	public Boolean cargarid_unidadProductoProduGasto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadProductoProduGasto=false;//ConEventDepend=true

	public Border resaltarcanitdadProductoProduGasto=null;
	public Boolean mostrarcanitdadProductoProduGasto=true;
	public Boolean activarcanitdadProductoProduGasto=true;

	public Border resaltarcostoProductoProduGasto=null;
	public Boolean mostrarcostoProductoProduGasto=true;
	public Boolean activarcostoProductoProduGasto=true;

	public Border resaltarcosto_totalProductoProduGasto=null;
	public Boolean mostrarcosto_totalProductoProduGasto=true;
	public Boolean activarcosto_totalProductoProduGasto=true;

	public Border resaltardescripcionProductoProduGasto=null;
	public Boolean mostrardescripcionProductoProduGasto=true;
	public Boolean activardescripcionProductoProduGasto=true;

	
	

	public Border setResaltaridProductoProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduGastoBeanSwingJInternalFrame productoprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodugastoBeanSwingJInternalFrame.jTtoolBarProductoProduGasto.setBorder(borderResaltar);
		
		this.resaltaridProductoProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductoProduGasto() {
		return this.resaltaridProductoProduGasto;
	}

	public void setResaltaridProductoProduGasto(Border borderResaltar) {
		this.resaltaridProductoProduGasto= borderResaltar;
	}

	public Boolean getMostraridProductoProduGasto() {
		return this.mostraridProductoProduGasto;
	}

	public void setMostraridProductoProduGasto(Boolean mostraridProductoProduGasto) {
		this.mostraridProductoProduGasto= mostraridProductoProduGasto;
	}

	public Boolean getActivaridProductoProduGasto() {
		return this.activaridProductoProduGasto;
	}

	public void setActivaridProductoProduGasto(Boolean activaridProductoProduGasto) {
		this.activaridProductoProduGasto= activaridProductoProduGasto;
	}

	public Border setResaltarid_producto_defi_produProductoProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduGastoBeanSwingJInternalFrame productoprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodugastoBeanSwingJInternalFrame.jTtoolBarProductoProduGasto.setBorder(borderResaltar);
		
		this.resaltarid_producto_defi_produProductoProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_producto_defi_produProductoProduGasto() {
		return this.resaltarid_producto_defi_produProductoProduGasto;
	}

	public void setResaltarid_producto_defi_produProductoProduGasto(Border borderResaltar) {
		this.resaltarid_producto_defi_produProductoProduGasto= borderResaltar;
	}

	public Boolean getMostrarid_producto_defi_produProductoProduGasto() {
		return this.mostrarid_producto_defi_produProductoProduGasto;
	}

	public void setMostrarid_producto_defi_produProductoProduGasto(Boolean mostrarid_producto_defi_produProductoProduGasto) {
		this.mostrarid_producto_defi_produProductoProduGasto= mostrarid_producto_defi_produProductoProduGasto;
	}

	public Boolean getActivarid_producto_defi_produProductoProduGasto() {
		return this.activarid_producto_defi_produProductoProduGasto;
	}

	public void setActivarid_producto_defi_produProductoProduGasto(Boolean activarid_producto_defi_produProductoProduGasto) {
		this.activarid_producto_defi_produProductoProduGasto= activarid_producto_defi_produProductoProduGasto;
	}

	public Boolean getCargarid_producto_defi_produProductoProduGasto() {
		return this.cargarid_producto_defi_produProductoProduGasto;
	}

	public void setCargarid_producto_defi_produProductoProduGasto(Boolean cargarid_producto_defi_produProductoProduGasto) {
		this.cargarid_producto_defi_produProductoProduGasto= cargarid_producto_defi_produProductoProduGasto;
	}

	public Border setResaltarid_tipo_gasto_produ_empresaProductoProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduGastoBeanSwingJInternalFrame productoprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodugastoBeanSwingJInternalFrame.jTtoolBarProductoProduGasto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_gasto_produ_empresaProductoProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_gasto_produ_empresaProductoProduGasto() {
		return this.resaltarid_tipo_gasto_produ_empresaProductoProduGasto;
	}

	public void setResaltarid_tipo_gasto_produ_empresaProductoProduGasto(Border borderResaltar) {
		this.resaltarid_tipo_gasto_produ_empresaProductoProduGasto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_gasto_produ_empresaProductoProduGasto() {
		return this.mostrarid_tipo_gasto_produ_empresaProductoProduGasto;
	}

	public void setMostrarid_tipo_gasto_produ_empresaProductoProduGasto(Boolean mostrarid_tipo_gasto_produ_empresaProductoProduGasto) {
		this.mostrarid_tipo_gasto_produ_empresaProductoProduGasto= mostrarid_tipo_gasto_produ_empresaProductoProduGasto;
	}

	public Boolean getActivarid_tipo_gasto_produ_empresaProductoProduGasto() {
		return this.activarid_tipo_gasto_produ_empresaProductoProduGasto;
	}

	public void setActivarid_tipo_gasto_produ_empresaProductoProduGasto(Boolean activarid_tipo_gasto_produ_empresaProductoProduGasto) {
		this.activarid_tipo_gasto_produ_empresaProductoProduGasto= activarid_tipo_gasto_produ_empresaProductoProduGasto;
	}

	public Boolean getCargarid_tipo_gasto_produ_empresaProductoProduGasto() {
		return this.cargarid_tipo_gasto_produ_empresaProductoProduGasto;
	}

	public void setCargarid_tipo_gasto_produ_empresaProductoProduGasto(Boolean cargarid_tipo_gasto_produ_empresaProductoProduGasto) {
		this.cargarid_tipo_gasto_produ_empresaProductoProduGasto= cargarid_tipo_gasto_produ_empresaProductoProduGasto;
	}

	public Border setResaltarid_cuenta_contable_debitoProductoProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduGastoBeanSwingJInternalFrame productoprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodugastoBeanSwingJInternalFrame.jTtoolBarProductoProduGasto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_debitoProductoProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_debitoProductoProduGasto() {
		return this.resaltarid_cuenta_contable_debitoProductoProduGasto;
	}

	public void setResaltarid_cuenta_contable_debitoProductoProduGasto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_debitoProductoProduGasto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_debitoProductoProduGasto() {
		return this.mostrarid_cuenta_contable_debitoProductoProduGasto;
	}

	public void setMostrarid_cuenta_contable_debitoProductoProduGasto(Boolean mostrarid_cuenta_contable_debitoProductoProduGasto) {
		this.mostrarid_cuenta_contable_debitoProductoProduGasto= mostrarid_cuenta_contable_debitoProductoProduGasto;
	}

	public Boolean getActivarid_cuenta_contable_debitoProductoProduGasto() {
		return this.activarid_cuenta_contable_debitoProductoProduGasto;
	}

	public void setActivarid_cuenta_contable_debitoProductoProduGasto(Boolean activarid_cuenta_contable_debitoProductoProduGasto) {
		this.activarid_cuenta_contable_debitoProductoProduGasto= activarid_cuenta_contable_debitoProductoProduGasto;
	}

	public Boolean getCargarid_cuenta_contable_debitoProductoProduGasto() {
		return this.cargarid_cuenta_contable_debitoProductoProduGasto;
	}

	public void setCargarid_cuenta_contable_debitoProductoProduGasto(Boolean cargarid_cuenta_contable_debitoProductoProduGasto) {
		this.cargarid_cuenta_contable_debitoProductoProduGasto= cargarid_cuenta_contable_debitoProductoProduGasto;
	}

	public Border setResaltarid_cuenta_contable_creditoProductoProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduGastoBeanSwingJInternalFrame productoprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodugastoBeanSwingJInternalFrame.jTtoolBarProductoProduGasto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_creditoProductoProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_creditoProductoProduGasto() {
		return this.resaltarid_cuenta_contable_creditoProductoProduGasto;
	}

	public void setResaltarid_cuenta_contable_creditoProductoProduGasto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_creditoProductoProduGasto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_creditoProductoProduGasto() {
		return this.mostrarid_cuenta_contable_creditoProductoProduGasto;
	}

	public void setMostrarid_cuenta_contable_creditoProductoProduGasto(Boolean mostrarid_cuenta_contable_creditoProductoProduGasto) {
		this.mostrarid_cuenta_contable_creditoProductoProduGasto= mostrarid_cuenta_contable_creditoProductoProduGasto;
	}

	public Boolean getActivarid_cuenta_contable_creditoProductoProduGasto() {
		return this.activarid_cuenta_contable_creditoProductoProduGasto;
	}

	public void setActivarid_cuenta_contable_creditoProductoProduGasto(Boolean activarid_cuenta_contable_creditoProductoProduGasto) {
		this.activarid_cuenta_contable_creditoProductoProduGasto= activarid_cuenta_contable_creditoProductoProduGasto;
	}

	public Boolean getCargarid_cuenta_contable_creditoProductoProduGasto() {
		return this.cargarid_cuenta_contable_creditoProductoProduGasto;
	}

	public void setCargarid_cuenta_contable_creditoProductoProduGasto(Boolean cargarid_cuenta_contable_creditoProductoProduGasto) {
		this.cargarid_cuenta_contable_creditoProductoProduGasto= cargarid_cuenta_contable_creditoProductoProduGasto;
	}

	public Border setResaltarid_cliente_proveedorProductoProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduGastoBeanSwingJInternalFrame productoprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodugastoBeanSwingJInternalFrame.jTtoolBarProductoProduGasto.setBorder(borderResaltar);
		
		this.resaltarid_cliente_proveedorProductoProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cliente_proveedorProductoProduGasto() {
		return this.resaltarid_cliente_proveedorProductoProduGasto;
	}

	public void setResaltarid_cliente_proveedorProductoProduGasto(Border borderResaltar) {
		this.resaltarid_cliente_proveedorProductoProduGasto= borderResaltar;
	}

	public Boolean getMostrarid_cliente_proveedorProductoProduGasto() {
		return this.mostrarid_cliente_proveedorProductoProduGasto;
	}

	public void setMostrarid_cliente_proveedorProductoProduGasto(Boolean mostrarid_cliente_proveedorProductoProduGasto) {
		this.mostrarid_cliente_proveedorProductoProduGasto= mostrarid_cliente_proveedorProductoProduGasto;
	}

	public Boolean getActivarid_cliente_proveedorProductoProduGasto() {
		return this.activarid_cliente_proveedorProductoProduGasto;
	}

	public void setActivarid_cliente_proveedorProductoProduGasto(Boolean activarid_cliente_proveedorProductoProduGasto) {
		this.activarid_cliente_proveedorProductoProduGasto= activarid_cliente_proveedorProductoProduGasto;
	}

	public Boolean getCargarid_cliente_proveedorProductoProduGasto() {
		return this.cargarid_cliente_proveedorProductoProduGasto;
	}

	public void setCargarid_cliente_proveedorProductoProduGasto(Boolean cargarid_cliente_proveedorProductoProduGasto) {
		this.cargarid_cliente_proveedorProductoProduGasto= cargarid_cliente_proveedorProductoProduGasto;
	}

	public Border setResaltarid_facturaProductoProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduGastoBeanSwingJInternalFrame productoprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodugastoBeanSwingJInternalFrame.jTtoolBarProductoProduGasto.setBorder(borderResaltar);
		
		this.resaltarid_facturaProductoProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaProductoProduGasto() {
		return this.resaltarid_facturaProductoProduGasto;
	}

	public void setResaltarid_facturaProductoProduGasto(Border borderResaltar) {
		this.resaltarid_facturaProductoProduGasto= borderResaltar;
	}

	public Boolean getMostrarid_facturaProductoProduGasto() {
		return this.mostrarid_facturaProductoProduGasto;
	}

	public void setMostrarid_facturaProductoProduGasto(Boolean mostrarid_facturaProductoProduGasto) {
		this.mostrarid_facturaProductoProduGasto= mostrarid_facturaProductoProduGasto;
	}

	public Boolean getActivarid_facturaProductoProduGasto() {
		return this.activarid_facturaProductoProduGasto;
	}

	public void setActivarid_facturaProductoProduGasto(Boolean activarid_facturaProductoProduGasto) {
		this.activarid_facturaProductoProduGasto= activarid_facturaProductoProduGasto;
	}

	public Boolean getCargarid_facturaProductoProduGasto() {
		return this.cargarid_facturaProductoProduGasto;
	}

	public void setCargarid_facturaProductoProduGasto(Boolean cargarid_facturaProductoProduGasto) {
		this.cargarid_facturaProductoProduGasto= cargarid_facturaProductoProduGasto;
	}

	public Border setResaltarid_unidadProductoProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduGastoBeanSwingJInternalFrame productoprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodugastoBeanSwingJInternalFrame.jTtoolBarProductoProduGasto.setBorder(borderResaltar);
		
		this.resaltarid_unidadProductoProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadProductoProduGasto() {
		return this.resaltarid_unidadProductoProduGasto;
	}

	public void setResaltarid_unidadProductoProduGasto(Border borderResaltar) {
		this.resaltarid_unidadProductoProduGasto= borderResaltar;
	}

	public Boolean getMostrarid_unidadProductoProduGasto() {
		return this.mostrarid_unidadProductoProduGasto;
	}

	public void setMostrarid_unidadProductoProduGasto(Boolean mostrarid_unidadProductoProduGasto) {
		this.mostrarid_unidadProductoProduGasto= mostrarid_unidadProductoProduGasto;
	}

	public Boolean getActivarid_unidadProductoProduGasto() {
		return this.activarid_unidadProductoProduGasto;
	}

	public void setActivarid_unidadProductoProduGasto(Boolean activarid_unidadProductoProduGasto) {
		this.activarid_unidadProductoProduGasto= activarid_unidadProductoProduGasto;
	}

	public Boolean getCargarid_unidadProductoProduGasto() {
		return this.cargarid_unidadProductoProduGasto;
	}

	public void setCargarid_unidadProductoProduGasto(Boolean cargarid_unidadProductoProduGasto) {
		this.cargarid_unidadProductoProduGasto= cargarid_unidadProductoProduGasto;
	}

	public Border setResaltarcanitdadProductoProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduGastoBeanSwingJInternalFrame productoprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodugastoBeanSwingJInternalFrame.jTtoolBarProductoProduGasto.setBorder(borderResaltar);
		
		this.resaltarcanitdadProductoProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcanitdadProductoProduGasto() {
		return this.resaltarcanitdadProductoProduGasto;
	}

	public void setResaltarcanitdadProductoProduGasto(Border borderResaltar) {
		this.resaltarcanitdadProductoProduGasto= borderResaltar;
	}

	public Boolean getMostrarcanitdadProductoProduGasto() {
		return this.mostrarcanitdadProductoProduGasto;
	}

	public void setMostrarcanitdadProductoProduGasto(Boolean mostrarcanitdadProductoProduGasto) {
		this.mostrarcanitdadProductoProduGasto= mostrarcanitdadProductoProduGasto;
	}

	public Boolean getActivarcanitdadProductoProduGasto() {
		return this.activarcanitdadProductoProduGasto;
	}

	public void setActivarcanitdadProductoProduGasto(Boolean activarcanitdadProductoProduGasto) {
		this.activarcanitdadProductoProduGasto= activarcanitdadProductoProduGasto;
	}

	public Border setResaltarcostoProductoProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduGastoBeanSwingJInternalFrame productoprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodugastoBeanSwingJInternalFrame.jTtoolBarProductoProduGasto.setBorder(borderResaltar);
		
		this.resaltarcostoProductoProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoProductoProduGasto() {
		return this.resaltarcostoProductoProduGasto;
	}

	public void setResaltarcostoProductoProduGasto(Border borderResaltar) {
		this.resaltarcostoProductoProduGasto= borderResaltar;
	}

	public Boolean getMostrarcostoProductoProduGasto() {
		return this.mostrarcostoProductoProduGasto;
	}

	public void setMostrarcostoProductoProduGasto(Boolean mostrarcostoProductoProduGasto) {
		this.mostrarcostoProductoProduGasto= mostrarcostoProductoProduGasto;
	}

	public Boolean getActivarcostoProductoProduGasto() {
		return this.activarcostoProductoProduGasto;
	}

	public void setActivarcostoProductoProduGasto(Boolean activarcostoProductoProduGasto) {
		this.activarcostoProductoProduGasto= activarcostoProductoProduGasto;
	}

	public Border setResaltarcosto_totalProductoProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduGastoBeanSwingJInternalFrame productoprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodugastoBeanSwingJInternalFrame.jTtoolBarProductoProduGasto.setBorder(borderResaltar);
		
		this.resaltarcosto_totalProductoProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalProductoProduGasto() {
		return this.resaltarcosto_totalProductoProduGasto;
	}

	public void setResaltarcosto_totalProductoProduGasto(Border borderResaltar) {
		this.resaltarcosto_totalProductoProduGasto= borderResaltar;
	}

	public Boolean getMostrarcosto_totalProductoProduGasto() {
		return this.mostrarcosto_totalProductoProduGasto;
	}

	public void setMostrarcosto_totalProductoProduGasto(Boolean mostrarcosto_totalProductoProduGasto) {
		this.mostrarcosto_totalProductoProduGasto= mostrarcosto_totalProductoProduGasto;
	}

	public Boolean getActivarcosto_totalProductoProduGasto() {
		return this.activarcosto_totalProductoProduGasto;
	}

	public void setActivarcosto_totalProductoProduGasto(Boolean activarcosto_totalProductoProduGasto) {
		this.activarcosto_totalProductoProduGasto= activarcosto_totalProductoProduGasto;
	}

	public Border setResaltardescripcionProductoProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduGastoBeanSwingJInternalFrame productoprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoprodugastoBeanSwingJInternalFrame.jTtoolBarProductoProduGasto.setBorder(borderResaltar);
		
		this.resaltardescripcionProductoProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionProductoProduGasto() {
		return this.resaltardescripcionProductoProduGasto;
	}

	public void setResaltardescripcionProductoProduGasto(Border borderResaltar) {
		this.resaltardescripcionProductoProduGasto= borderResaltar;
	}

	public Boolean getMostrardescripcionProductoProduGasto() {
		return this.mostrardescripcionProductoProduGasto;
	}

	public void setMostrardescripcionProductoProduGasto(Boolean mostrardescripcionProductoProduGasto) {
		this.mostrardescripcionProductoProduGasto= mostrardescripcionProductoProduGasto;
	}

	public Boolean getActivardescripcionProductoProduGasto() {
		return this.activardescripcionProductoProduGasto;
	}

	public void setActivardescripcionProductoProduGasto(Boolean activardescripcionProductoProduGasto) {
		this.activardescripcionProductoProduGasto= activardescripcionProductoProduGasto;
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
		
		
		this.setMostraridProductoProduGasto(esInicial);
		this.setMostrarid_producto_defi_produProductoProduGasto(esInicial);
		this.setMostrarid_tipo_gasto_produ_empresaProductoProduGasto(esInicial);
		this.setMostrarid_cuenta_contable_debitoProductoProduGasto(esInicial);
		this.setMostrarid_cuenta_contable_creditoProductoProduGasto(esInicial);
		this.setMostrarid_cliente_proveedorProductoProduGasto(esInicial);
		this.setMostrarid_facturaProductoProduGasto(esInicial);
		this.setMostrarid_unidadProductoProduGasto(esInicial);
		this.setMostrarcanitdadProductoProduGasto(esInicial);
		this.setMostrarcostoProductoProduGasto(esInicial);
		this.setMostrarcosto_totalProductoProduGasto(esInicial);
		this.setMostrardescripcionProductoProduGasto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.ID)) {
				this.setMostraridProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.IDPRODUCTODEFIPRODU)) {
				this.setMostrarid_producto_defi_produProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA)) {
				this.setMostrarid_tipo_gasto_produ_empresaProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setMostrarid_cuenta_contable_debitoProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setMostrarid_cuenta_contable_creditoProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR)) {
				this.setMostrarid_cliente_proveedorProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.CANTIDAD)) {
				this.setMostrarcanitdadProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.COSTO)) {
				this.setMostrarcostoProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionProductoProduGasto(esAsigna);
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
		
		
		this.setActivaridProductoProduGasto(esInicial);
		this.setActivarid_producto_defi_produProductoProduGasto(esInicial);
		this.setActivarid_tipo_gasto_produ_empresaProductoProduGasto(esInicial);
		this.setActivarid_cuenta_contable_debitoProductoProduGasto(esInicial);
		this.setActivarid_cuenta_contable_creditoProductoProduGasto(esInicial);
		this.setActivarid_cliente_proveedorProductoProduGasto(esInicial);
		this.setActivarid_facturaProductoProduGasto(esInicial);
		this.setActivarid_unidadProductoProduGasto(esInicial);
		this.setActivarcanitdadProductoProduGasto(esInicial);
		this.setActivarcostoProductoProduGasto(esInicial);
		this.setActivarcosto_totalProductoProduGasto(esInicial);
		this.setActivardescripcionProductoProduGasto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.ID)) {
				this.setActivaridProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.IDPRODUCTODEFIPRODU)) {
				this.setActivarid_producto_defi_produProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA)) {
				this.setActivarid_tipo_gasto_produ_empresaProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setActivarid_cuenta_contable_debitoProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setActivarid_cuenta_contable_creditoProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR)) {
				this.setActivarid_cliente_proveedorProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.CANTIDAD)) {
				this.setActivarcanitdadProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.COSTO)) {
				this.setActivarcostoProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionProductoProduGasto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoProduGastoBeanSwingJInternalFrame productoprodugastoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductoProduGasto(esInicial);
		this.setResaltarid_producto_defi_produProductoProduGasto(esInicial);
		this.setResaltarid_tipo_gasto_produ_empresaProductoProduGasto(esInicial);
		this.setResaltarid_cuenta_contable_debitoProductoProduGasto(esInicial);
		this.setResaltarid_cuenta_contable_creditoProductoProduGasto(esInicial);
		this.setResaltarid_cliente_proveedorProductoProduGasto(esInicial);
		this.setResaltarid_facturaProductoProduGasto(esInicial);
		this.setResaltarid_unidadProductoProduGasto(esInicial);
		this.setResaltarcanitdadProductoProduGasto(esInicial);
		this.setResaltarcostoProductoProduGasto(esInicial);
		this.setResaltarcosto_totalProductoProduGasto(esInicial);
		this.setResaltardescripcionProductoProduGasto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.ID)) {
				this.setResaltaridProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.IDPRODUCTODEFIPRODU)) {
				this.setResaltarid_producto_defi_produProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA)) {
				this.setResaltarid_tipo_gasto_produ_empresaProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setResaltarid_cuenta_contable_debitoProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setResaltarid_cuenta_contable_creditoProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR)) {
				this.setResaltarid_cliente_proveedorProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.CANTIDAD)) {
				this.setResaltarcanitdadProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.COSTO)) {
				this.setResaltarcostoProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalProductoProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoProduGastoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionProductoProduGasto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoProduGastoBeanSwingJInternalFrame productoprodugastoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteProveedorProductoProduGasto=true;

	public Boolean getMostrarFK_IdClienteProveedorProductoProduGasto() {
		return this.mostrarFK_IdClienteProveedorProductoProduGasto;
	}

	public void setMostrarFK_IdClienteProveedorProductoProduGasto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteProveedorProductoProduGasto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCreditoProductoProduGasto=true;

	public Boolean getMostrarFK_IdCuentaContableCreditoProductoProduGasto() {
		return this.mostrarFK_IdCuentaContableCreditoProductoProduGasto;
	}

	public void setMostrarFK_IdCuentaContableCreditoProductoProduGasto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCreditoProductoProduGasto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableDebitoProductoProduGasto=true;

	public Boolean getMostrarFK_IdCuentaContableDebitoProductoProduGasto() {
		return this.mostrarFK_IdCuentaContableDebitoProductoProduGasto;
	}

	public void setMostrarFK_IdCuentaContableDebitoProductoProduGasto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableDebitoProductoProduGasto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaProductoProduGasto=true;

	public Boolean getMostrarFK_IdFacturaProductoProduGasto() {
		return this.mostrarFK_IdFacturaProductoProduGasto;
	}

	public void setMostrarFK_IdFacturaProductoProduGasto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaProductoProduGasto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDefiProduProductoProduGasto=true;

	public Boolean getMostrarFK_IdProductoDefiProduProductoProduGasto() {
		return this.mostrarFK_IdProductoDefiProduProductoProduGasto;
	}

	public void setMostrarFK_IdProductoDefiProduProductoProduGasto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDefiProduProductoProduGasto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoGastoProduEmpresaProductoProduGasto=true;

	public Boolean getMostrarFK_IdTipoGastoProduEmpresaProductoProduGasto() {
		return this.mostrarFK_IdTipoGastoProduEmpresaProductoProduGasto;
	}

	public void setMostrarFK_IdTipoGastoProduEmpresaProductoProduGasto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoGastoProduEmpresaProductoProduGasto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadProductoProduGasto=true;

	public Boolean getMostrarFK_IdUnidadProductoProduGasto() {
		return this.mostrarFK_IdUnidadProductoProduGasto;
	}

	public void setMostrarFK_IdUnidadProductoProduGasto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadProductoProduGasto= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteProveedorProductoProduGasto=true;

	public Boolean getActivarFK_IdClienteProveedorProductoProduGasto() {
		return this.activarFK_IdClienteProveedorProductoProduGasto;
	}

	public void setActivarFK_IdClienteProveedorProductoProduGasto(Boolean habilitarResaltar) {
		this.activarFK_IdClienteProveedorProductoProduGasto= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCreditoProductoProduGasto=true;

	public Boolean getActivarFK_IdCuentaContableCreditoProductoProduGasto() {
		return this.activarFK_IdCuentaContableCreditoProductoProduGasto;
	}

	public void setActivarFK_IdCuentaContableCreditoProductoProduGasto(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCreditoProductoProduGasto= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableDebitoProductoProduGasto=true;

	public Boolean getActivarFK_IdCuentaContableDebitoProductoProduGasto() {
		return this.activarFK_IdCuentaContableDebitoProductoProduGasto;
	}

	public void setActivarFK_IdCuentaContableDebitoProductoProduGasto(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableDebitoProductoProduGasto= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaProductoProduGasto=true;

	public Boolean getActivarFK_IdFacturaProductoProduGasto() {
		return this.activarFK_IdFacturaProductoProduGasto;
	}

	public void setActivarFK_IdFacturaProductoProduGasto(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaProductoProduGasto= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDefiProduProductoProduGasto=true;

	public Boolean getActivarFK_IdProductoDefiProduProductoProduGasto() {
		return this.activarFK_IdProductoDefiProduProductoProduGasto;
	}

	public void setActivarFK_IdProductoDefiProduProductoProduGasto(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDefiProduProductoProduGasto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoGastoProduEmpresaProductoProduGasto=true;

	public Boolean getActivarFK_IdTipoGastoProduEmpresaProductoProduGasto() {
		return this.activarFK_IdTipoGastoProduEmpresaProductoProduGasto;
	}

	public void setActivarFK_IdTipoGastoProduEmpresaProductoProduGasto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoGastoProduEmpresaProductoProduGasto= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadProductoProduGasto=true;

	public Boolean getActivarFK_IdUnidadProductoProduGasto() {
		return this.activarFK_IdUnidadProductoProduGasto;
	}

	public void setActivarFK_IdUnidadProductoProduGasto(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadProductoProduGasto= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteProveedorProductoProduGasto=null;

	public Border getResaltarFK_IdClienteProveedorProductoProduGasto() {
		return this.resaltarFK_IdClienteProveedorProductoProduGasto;
	}

	public void setResaltarFK_IdClienteProveedorProductoProduGasto(Border borderResaltar) {
		this.resaltarFK_IdClienteProveedorProductoProduGasto= borderResaltar;
	}

	public void setResaltarFK_IdClienteProveedorProductoProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduGastoBeanSwingJInternalFrame productoprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteProveedorProductoProduGasto= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCreditoProductoProduGasto=null;

	public Border getResaltarFK_IdCuentaContableCreditoProductoProduGasto() {
		return this.resaltarFK_IdCuentaContableCreditoProductoProduGasto;
	}

	public void setResaltarFK_IdCuentaContableCreditoProductoProduGasto(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCreditoProductoProduGasto= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCreditoProductoProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduGastoBeanSwingJInternalFrame productoprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCreditoProductoProduGasto= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableDebitoProductoProduGasto=null;

	public Border getResaltarFK_IdCuentaContableDebitoProductoProduGasto() {
		return this.resaltarFK_IdCuentaContableDebitoProductoProduGasto;
	}

	public void setResaltarFK_IdCuentaContableDebitoProductoProduGasto(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableDebitoProductoProduGasto= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableDebitoProductoProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduGastoBeanSwingJInternalFrame productoprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableDebitoProductoProduGasto= borderResaltar;
	}

	public Border resaltarFK_IdFacturaProductoProduGasto=null;

	public Border getResaltarFK_IdFacturaProductoProduGasto() {
		return this.resaltarFK_IdFacturaProductoProduGasto;
	}

	public void setResaltarFK_IdFacturaProductoProduGasto(Border borderResaltar) {
		this.resaltarFK_IdFacturaProductoProduGasto= borderResaltar;
	}

	public void setResaltarFK_IdFacturaProductoProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduGastoBeanSwingJInternalFrame productoprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaProductoProduGasto= borderResaltar;
	}

	public Border resaltarFK_IdProductoDefiProduProductoProduGasto=null;

	public Border getResaltarFK_IdProductoDefiProduProductoProduGasto() {
		return this.resaltarFK_IdProductoDefiProduProductoProduGasto;
	}

	public void setResaltarFK_IdProductoDefiProduProductoProduGasto(Border borderResaltar) {
		this.resaltarFK_IdProductoDefiProduProductoProduGasto= borderResaltar;
	}

	public void setResaltarFK_IdProductoDefiProduProductoProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduGastoBeanSwingJInternalFrame productoprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDefiProduProductoProduGasto= borderResaltar;
	}

	public Border resaltarFK_IdTipoGastoProduEmpresaProductoProduGasto=null;

	public Border getResaltarFK_IdTipoGastoProduEmpresaProductoProduGasto() {
		return this.resaltarFK_IdTipoGastoProduEmpresaProductoProduGasto;
	}

	public void setResaltarFK_IdTipoGastoProduEmpresaProductoProduGasto(Border borderResaltar) {
		this.resaltarFK_IdTipoGastoProduEmpresaProductoProduGasto= borderResaltar;
	}

	public void setResaltarFK_IdTipoGastoProduEmpresaProductoProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduGastoBeanSwingJInternalFrame productoprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoGastoProduEmpresaProductoProduGasto= borderResaltar;
	}

	public Border resaltarFK_IdUnidadProductoProduGasto=null;

	public Border getResaltarFK_IdUnidadProductoProduGasto() {
		return this.resaltarFK_IdUnidadProductoProduGasto;
	}

	public void setResaltarFK_IdUnidadProductoProduGasto(Border borderResaltar) {
		this.resaltarFK_IdUnidadProductoProduGasto= borderResaltar;
	}

	public void setResaltarFK_IdUnidadProductoProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoProduGastoBeanSwingJInternalFrame productoprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadProductoProduGasto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}