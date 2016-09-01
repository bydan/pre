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


import com.bydan.erp.produccion.util.ProductoOrdenDetaProduGastoConstantesFunciones;
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduGastoParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProductoOrdenDetaProduGastoParameterGeneral;

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
final public class ProductoOrdenDetaProduGastoConstantesFunciones extends ProductoOrdenDetaProduGastoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProductoOrdenDetaProduGasto";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductoOrdenDetaProduGasto"+ProductoOrdenDetaProduGastoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductoOrdenDetaProduGastoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductoOrdenDetaProduGastoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"_"+ProductoOrdenDetaProduGastoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductoOrdenDetaProduGastoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"_"+ProductoOrdenDetaProduGastoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"_"+ProductoOrdenDetaProduGastoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductoOrdenDetaProduGastoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"_"+ProductoOrdenDetaProduGastoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoOrdenDetaProduGastoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoOrdenDetaProduGastoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoOrdenDetaProduGastoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoOrdenDetaProduGastoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoOrdenDetaProduGastoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoOrdenDetaProduGastoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductoOrdenDetaProduGastoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductoOrdenDetaProduGastoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductoOrdenDetaProduGastoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductoOrdenDetaProduGastoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Orden  Gastoes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Orden  Gasto";
	public static final String SCLASSWEBTITULO_LOWER="Producto Orden Deta Produ Gasto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductoOrdenDetaProduGasto";
	public static final String OBJECTNAME="productoordendetaprodugasto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="producto_orden_deta_produ_gasto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productoordendetaprodugasto from "+ProductoOrdenDetaProduGastoConstantesFunciones.SPERSISTENCENAME+" productoordendetaprodugasto";
	public static String QUERYSELECTNATIVE="select "+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".id,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".version_row,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".id_orden_deta_produ,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".id_tipo_gasto_produ_empresa,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".id_cuenta_contable_debito,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".id_cliente_proveedor,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".id_factura,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".id_unidad,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".cantidad,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".costo,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".costo_total,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".descripcion from "+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME;//+" as "+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProductoOrdenDetaProduGastoConstantesFuncionesAdditional productoordendetaprodugastoConstantesFuncionesAdditional=null;
	
	public ProductoOrdenDetaProduGastoConstantesFuncionesAdditional getProductoOrdenDetaProduGastoConstantesFuncionesAdditional() {
		return this.productoordendetaprodugastoConstantesFuncionesAdditional;
	}
	
	public void setProductoOrdenDetaProduGastoConstantesFuncionesAdditional(ProductoOrdenDetaProduGastoConstantesFuncionesAdditional productoordendetaprodugastoConstantesFuncionesAdditional) {
		try {
			this.productoordendetaprodugastoConstantesFuncionesAdditional=productoordendetaprodugastoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDORDENDETAPRODU= "id_orden_deta_produ";
    public static final String IDTIPOGASTOPRODUEMPRESA= "id_tipo_gasto_produ_empresa";
    public static final String IDCUENTACONTABLEDEBITO= "id_cuenta_contable_debito";
    public static final String IDCUENTACONTABLECREDITO= "id_cuenta_contable_credito";
    public static final String IDCLIENTEPROVEEDOR= "id_cliente_proveedor";
    public static final String IDFACTURA= "id_factura";
    public static final String IDUNIDAD= "id_unidad";
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
	
	public static String getProductoOrdenDetaProduGastoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDORDENDETAPRODU)) {sLabelColumna=ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDORDENDETAPRODU;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA)) {sLabelColumna=ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDTIPOGASTOPRODUEMPRESA;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO)) {sLabelColumna=ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO)) {sLabelColumna=ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR)) {sLabelColumna=ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDCLIENTEPROVEEDOR;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDFACTURA)) {sLabelColumna=ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDUNIDAD)) {sLabelColumna=ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduGastoConstantesFunciones.CANTIDAD)) {sLabelColumna=ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduGastoConstantesFunciones.COSTO)) {sLabelColumna=ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduGastoConstantesFunciones.COSTOTOTAL)) {sLabelColumna=ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(ProductoOrdenDetaProduGastoConstantesFunciones.DESCRIPCION)) {sLabelColumna=ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProductoOrdenDetaProduGastoDescripcion(ProductoOrdenDetaProduGasto productoordendetaprodugasto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productoordendetaprodugasto !=null/* && productoordendetaprodugasto.getId()!=0*/) {
			if(productoordendetaprodugasto.getId()!=null) {
				sDescripcion=productoordendetaprodugasto.getId().toString();
			}//productoordendetaprodugastoproductoordendetaprodugasto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductoOrdenDetaProduGastoDescripcionDetallado(ProductoOrdenDetaProduGasto productoordendetaprodugasto) {
		String sDescripcion="";
			
		sDescripcion+=ProductoOrdenDetaProduGastoConstantesFunciones.ID+"=";
		sDescripcion+=productoordendetaprodugasto.getId().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduGastoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productoordendetaprodugasto.getVersionRow().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduGastoConstantesFunciones.IDORDENDETAPRODU+"=";
		sDescripcion+=productoordendetaprodugasto.getid_orden_deta_produ().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA+"=";
		sDescripcion+=productoordendetaprodugasto.getid_tipo_gasto_produ_empresa().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO+"=";
		sDescripcion+=productoordendetaprodugasto.getid_cuenta_contable_debito().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO+"=";
		sDescripcion+=productoordendetaprodugasto.getid_cuenta_contable_credito().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR+"=";
		sDescripcion+=productoordendetaprodugasto.getid_cliente_proveedor().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduGastoConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=productoordendetaprodugasto.getid_factura().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduGastoConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=productoordendetaprodugasto.getid_unidad().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduGastoConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=productoordendetaprodugasto.getcantidad().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduGastoConstantesFunciones.COSTO+"=";
		sDescripcion+=productoordendetaprodugasto.getcosto().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduGastoConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=productoordendetaprodugasto.getcosto_total().toString()+",";
		sDescripcion+=ProductoOrdenDetaProduGastoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=productoordendetaprodugasto.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setProductoOrdenDetaProduGastoDescripcion(ProductoOrdenDetaProduGasto productoordendetaprodugasto,String sValor) throws Exception {			
		if(productoordendetaprodugasto !=null) {
			//productoordendetaprodugastoproductoordendetaprodugasto.getId().toString();
		}		
	}
	
		

	public static String getOrdenDetaProduDescripcion(OrdenDetaProdu ordendetaprodu) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ordendetaprodu!=null/*&&ordendetaprodu.getId()>0*/) {
			sDescripcion=OrdenDetaProduConstantesFunciones.getOrdenDetaProduDescripcion(ordendetaprodu);
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
		} else if(sNombreIndice.equals("FK_IdOrdenDetaProdu")) {
			sNombreIndice="Tipo=  Por Orden Deta Produ";
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

	public static String getDetalleIndiceFK_IdOrdenDetaProdu(Long id_orden_deta_produ) {
		String sDetalleIndice=" Parametros->";
		if(id_orden_deta_produ!=null) {sDetalleIndice+=" Codigo Unico De Orden Deta Produ="+id_orden_deta_produ.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosProductoOrdenDetaProduGasto(ProductoOrdenDetaProduGasto productoordendetaprodugasto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productoordendetaprodugasto.setdescripcion(productoordendetaprodugasto.getdescripcion().trim());
	}
	
	public static void quitarEspaciosProductoOrdenDetaProduGastos(List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoOrdenDetaProduGasto productoordendetaprodugasto: productoordendetaprodugastos) {
			productoordendetaprodugasto.setdescripcion(productoordendetaprodugasto.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoOrdenDetaProduGasto(ProductoOrdenDetaProduGasto productoordendetaprodugasto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productoordendetaprodugasto.getConCambioAuxiliar()) {
			productoordendetaprodugasto.setIsDeleted(productoordendetaprodugasto.getIsDeletedAuxiliar());	
			productoordendetaprodugasto.setIsNew(productoordendetaprodugasto.getIsNewAuxiliar());	
			productoordendetaprodugasto.setIsChanged(productoordendetaprodugasto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productoordendetaprodugasto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productoordendetaprodugasto.setIsDeletedAuxiliar(false);	
			productoordendetaprodugasto.setIsNewAuxiliar(false);	
			productoordendetaprodugasto.setIsChangedAuxiliar(false);
			
			productoordendetaprodugasto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoOrdenDetaProduGastos(List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductoOrdenDetaProduGasto productoordendetaprodugasto : productoordendetaprodugastos) {
			if(conAsignarBase && productoordendetaprodugasto.getConCambioAuxiliar()) {
				productoordendetaprodugasto.setIsDeleted(productoordendetaprodugasto.getIsDeletedAuxiliar());	
				productoordendetaprodugasto.setIsNew(productoordendetaprodugasto.getIsNewAuxiliar());	
				productoordendetaprodugasto.setIsChanged(productoordendetaprodugasto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productoordendetaprodugasto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productoordendetaprodugasto.setIsDeletedAuxiliar(false);	
				productoordendetaprodugasto.setIsNewAuxiliar(false);	
				productoordendetaprodugasto.setIsChangedAuxiliar(false);
				
				productoordendetaprodugasto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductoOrdenDetaProduGasto(ProductoOrdenDetaProduGasto productoordendetaprodugasto,Boolean conEnteros) throws Exception  {
		productoordendetaprodugasto.setcosto(0.0);
		productoordendetaprodugasto.setcosto_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			productoordendetaprodugasto.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresProductoOrdenDetaProduGastos(List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos,Boolean conEnteros) throws Exception  {
		
		for(ProductoOrdenDetaProduGasto productoordendetaprodugasto: productoordendetaprodugastos) {
			productoordendetaprodugasto.setcosto(0.0);
			productoordendetaprodugasto.setcosto_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				productoordendetaprodugasto.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductoOrdenDetaProduGasto(List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos,ProductoOrdenDetaProduGasto productoordendetaprodugastoAux) throws Exception  {
		ProductoOrdenDetaProduGastoConstantesFunciones.InicializarValoresProductoOrdenDetaProduGasto(productoordendetaprodugastoAux,true);
		
		for(ProductoOrdenDetaProduGasto productoordendetaprodugasto: productoordendetaprodugastos) {
			if(productoordendetaprodugasto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productoordendetaprodugastoAux.setcantidad(productoordendetaprodugastoAux.getcantidad()+productoordendetaprodugasto.getcantidad());			
			productoordendetaprodugastoAux.setcosto(productoordendetaprodugastoAux.getcosto()+productoordendetaprodugasto.getcosto());			
			productoordendetaprodugastoAux.setcosto_total(productoordendetaprodugastoAux.getcosto_total()+productoordendetaprodugasto.getcosto_total());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoOrdenDetaProduGasto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductoOrdenDetaProduGastoConstantesFunciones.getArrayColumnasGlobalesProductoOrdenDetaProduGasto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoOrdenDetaProduGasto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductoOrdenDetaProduGasto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos,ProductoOrdenDetaProduGasto productoordendetaprodugasto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoOrdenDetaProduGasto productoordendetaprodugastoAux: productoordendetaprodugastos) {
			if(productoordendetaprodugastoAux!=null && productoordendetaprodugasto!=null) {
				if((productoordendetaprodugastoAux.getId()==null && productoordendetaprodugasto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productoordendetaprodugastoAux.getId()!=null && productoordendetaprodugasto.getId()!=null){
					if(productoordendetaprodugastoAux.getId().equals(productoordendetaprodugasto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoOrdenDetaProduGasto(List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costoTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(ProductoOrdenDetaProduGasto productoordendetaprodugasto: productoordendetaprodugastos) {			
			if(productoordendetaprodugasto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costoTotal+=productoordendetaprodugasto.getcosto();
			costo_totalTotal+=productoordendetaprodugasto.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoOrdenDetaProduGastoConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoOrdenDetaProduGastoConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductoOrdenDetaProduGasto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_ID, ProductoOrdenDetaProduGastoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_VERSIONROW, ProductoOrdenDetaProduGastoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDORDENDETAPRODU, ProductoOrdenDetaProduGastoConstantesFunciones.IDORDENDETAPRODU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDTIPOGASTOPRODUEMPRESA, ProductoOrdenDetaProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO, ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO, ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDCLIENTEPROVEEDOR, ProductoOrdenDetaProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDFACTURA, ProductoOrdenDetaProduGastoConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDUNIDAD, ProductoOrdenDetaProduGastoConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_CANTIDAD, ProductoOrdenDetaProduGastoConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_COSTO, ProductoOrdenDetaProduGastoConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_COSTOTOTAL, ProductoOrdenDetaProduGastoConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_DESCRIPCION, ProductoOrdenDetaProduGastoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductoOrdenDetaProduGasto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduGastoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduGastoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduGastoConstantesFunciones.IDORDENDETAPRODU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduGastoConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduGastoConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduGastoConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduGastoConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduGastoConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoOrdenDetaProduGastoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoOrdenDetaProduGasto() throws Exception  {
		return ProductoOrdenDetaProduGastoConstantesFunciones.getTiposSeleccionarProductoOrdenDetaProduGasto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoOrdenDetaProduGasto(Boolean conFk) throws Exception  {
		return ProductoOrdenDetaProduGastoConstantesFunciones.getTiposSeleccionarProductoOrdenDetaProduGasto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoOrdenDetaProduGasto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDORDENDETAPRODU);
			reporte.setsDescripcion(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDORDENDETAPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDTIPOGASTOPRODUEMPRESA);
			reporte.setsDescripcion(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDTIPOGASTOPRODUEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);
			reporte.setsDescripcion(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
			reporte.setsDescripcion(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDCLIENTEPROVEEDOR);
			reporte.setsDescripcion(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDCLIENTEPROVEEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductoOrdenDetaProduGasto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(ProductoOrdenDetaProduGasto productoordendetaprodugastoAux) throws Exception {
		
			productoordendetaprodugastoAux.setordendetaprodu_descripcion(OrdenDetaProduConstantesFunciones.getOrdenDetaProduDescripcion(productoordendetaprodugastoAux.getOrdenDetaProdu()));
			productoordendetaprodugastoAux.settipogastoproduempresa_descripcion(TipoGastoProduEmpresaConstantesFunciones.getTipoGastoProduEmpresaDescripcion(productoordendetaprodugastoAux.getTipoGastoProduEmpresa()));
			productoordendetaprodugastoAux.setcuentacontabledebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(productoordendetaprodugastoAux.getCuentaContableDebito()));
			productoordendetaprodugastoAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(productoordendetaprodugastoAux.getCuentaContableCredito()));
			productoordendetaprodugastoAux.setclienteproveedor_descripcion(ClienteConstantesFunciones.getClienteDescripcion(productoordendetaprodugastoAux.getClienteProveedor()));
			productoordendetaprodugastoAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(productoordendetaprodugastoAux.getFactura()));
			productoordendetaprodugastoAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoordendetaprodugastoAux.getUnidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(List<ProductoOrdenDetaProduGasto> productoordendetaprodugastosTemp) throws Exception {
		for(ProductoOrdenDetaProduGasto productoordendetaprodugastoAux:productoordendetaprodugastosTemp) {
			
			productoordendetaprodugastoAux.setordendetaprodu_descripcion(OrdenDetaProduConstantesFunciones.getOrdenDetaProduDescripcion(productoordendetaprodugastoAux.getOrdenDetaProdu()));
			productoordendetaprodugastoAux.settipogastoproduempresa_descripcion(TipoGastoProduEmpresaConstantesFunciones.getTipoGastoProduEmpresaDescripcion(productoordendetaprodugastoAux.getTipoGastoProduEmpresa()));
			productoordendetaprodugastoAux.setcuentacontabledebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(productoordendetaprodugastoAux.getCuentaContableDebito()));
			productoordendetaprodugastoAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(productoordendetaprodugastoAux.getCuentaContableCredito()));
			productoordendetaprodugastoAux.setclienteproveedor_descripcion(ClienteConstantesFunciones.getClienteDescripcion(productoordendetaprodugastoAux.getClienteProveedor()));
			productoordendetaprodugastoAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(productoordendetaprodugastoAux.getFactura()));
			productoordendetaprodugastoAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoordendetaprodugastoAux.getUnidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductoOrdenDetaProduGasto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(OrdenDetaProdu.class));
				classes.add(new Classe(TipoGastoProduEmpresa.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(Unidad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(OrdenDetaProdu.class)) {
						classes.add(new Classe(OrdenDetaProdu.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductoOrdenDetaProduGasto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(OrdenDetaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenDetaProdu.class)); continue;
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

					if(OrdenDetaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenDetaProdu.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoOrdenDetaProduGasto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoOrdenDetaProduGastoConstantesFunciones.getClassesRelationshipsOfProductoOrdenDetaProduGasto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoOrdenDetaProduGasto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoOrdenDetaProduGasto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoOrdenDetaProduGastoConstantesFunciones.getClassesRelationshipsFromStringsOfProductoOrdenDetaProduGasto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoOrdenDetaProduGasto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductoOrdenDetaProduGasto productoordendetaprodugasto,List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProductoOrdenDetaProduGasto productoordendetaprodugastoEncontrado=null;
			
			for(ProductoOrdenDetaProduGasto productoordendetaprodugastoLocal:productoordendetaprodugastos) {
				if(productoordendetaprodugastoLocal.getId().equals(productoordendetaprodugasto.getId())) {
					productoordendetaprodugastoEncontrado=productoordendetaprodugastoLocal;
					
					productoordendetaprodugastoLocal.setIsChanged(productoordendetaprodugasto.getIsChanged());
					productoordendetaprodugastoLocal.setIsNew(productoordendetaprodugasto.getIsNew());
					productoordendetaprodugastoLocal.setIsDeleted(productoordendetaprodugasto.getIsDeleted());
					
					productoordendetaprodugastoLocal.setGeneralEntityOriginal(productoordendetaprodugasto.getGeneralEntityOriginal());
					
					productoordendetaprodugastoLocal.setId(productoordendetaprodugasto.getId());	
					productoordendetaprodugastoLocal.setVersionRow(productoordendetaprodugasto.getVersionRow());	
					productoordendetaprodugastoLocal.setid_orden_deta_produ(productoordendetaprodugasto.getid_orden_deta_produ());	
					productoordendetaprodugastoLocal.setid_tipo_gasto_produ_empresa(productoordendetaprodugasto.getid_tipo_gasto_produ_empresa());	
					productoordendetaprodugastoLocal.setid_cuenta_contable_debito(productoordendetaprodugasto.getid_cuenta_contable_debito());	
					productoordendetaprodugastoLocal.setid_cuenta_contable_credito(productoordendetaprodugasto.getid_cuenta_contable_credito());	
					productoordendetaprodugastoLocal.setid_cliente_proveedor(productoordendetaprodugasto.getid_cliente_proveedor());	
					productoordendetaprodugastoLocal.setid_factura(productoordendetaprodugasto.getid_factura());	
					productoordendetaprodugastoLocal.setid_unidad(productoordendetaprodugasto.getid_unidad());	
					productoordendetaprodugastoLocal.setcantidad(productoordendetaprodugasto.getcantidad());	
					productoordendetaprodugastoLocal.setcosto(productoordendetaprodugasto.getcosto());	
					productoordendetaprodugastoLocal.setcosto_total(productoordendetaprodugasto.getcosto_total());	
					productoordendetaprodugastoLocal.setdescripcion(productoordendetaprodugasto.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!productoordendetaprodugasto.getIsDeleted()) {
				if(!existe) {
					productoordendetaprodugastos.add(productoordendetaprodugasto);
				}
			} else {
				if(productoordendetaprodugastoEncontrado!=null && permiteQuitar)  {
					productoordendetaprodugastos.remove(productoordendetaprodugastoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProductoOrdenDetaProduGasto productoordendetaprodugasto,List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos) throws Exception {
		try	{			
			for(ProductoOrdenDetaProduGasto productoordendetaprodugastoLocal:productoordendetaprodugastos) {
				if(productoordendetaprodugastoLocal.getId().equals(productoordendetaprodugasto.getId())) {
					productoordendetaprodugastoLocal.setIsSelected(productoordendetaprodugasto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductoOrdenDetaProduGasto(List<ProductoOrdenDetaProduGasto> productoordendetaprodugastosAux) throws Exception {
		//this.productoordendetaprodugastosAux=productoordendetaprodugastosAux;
		
		for(ProductoOrdenDetaProduGasto productoordendetaprodugastoAux:productoordendetaprodugastosAux) {
			if(productoordendetaprodugastoAux.getIsChanged()) {
				productoordendetaprodugastoAux.setIsChanged(false);
			}		
			
			if(productoordendetaprodugastoAux.getIsNew()) {
				productoordendetaprodugastoAux.setIsNew(false);
			}	
			
			if(productoordendetaprodugastoAux.getIsDeleted()) {
				productoordendetaprodugastoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductoOrdenDetaProduGasto(ProductoOrdenDetaProduGasto productoordendetaprodugastoAux) throws Exception {
		//this.productoordendetaprodugastoAux=productoordendetaprodugastoAux;
		
			if(productoordendetaprodugastoAux.getIsChanged()) {
				productoordendetaprodugastoAux.setIsChanged(false);
			}		
			
			if(productoordendetaprodugastoAux.getIsNew()) {
				productoordendetaprodugastoAux.setIsNew(false);
			}	
			
			if(productoordendetaprodugastoAux.getIsDeleted()) {
				productoordendetaprodugastoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductoOrdenDetaProduGasto productoordendetaprodugastoAsignar,ProductoOrdenDetaProduGasto productoordendetaprodugasto) throws Exception {
		productoordendetaprodugastoAsignar.setId(productoordendetaprodugasto.getId());	
		productoordendetaprodugastoAsignar.setVersionRow(productoordendetaprodugasto.getVersionRow());	
		productoordendetaprodugastoAsignar.setid_orden_deta_produ(productoordendetaprodugasto.getid_orden_deta_produ());
		productoordendetaprodugastoAsignar.setordendetaprodu_descripcion(productoordendetaprodugasto.getordendetaprodu_descripcion());	
		productoordendetaprodugastoAsignar.setid_tipo_gasto_produ_empresa(productoordendetaprodugasto.getid_tipo_gasto_produ_empresa());
		productoordendetaprodugastoAsignar.settipogastoproduempresa_descripcion(productoordendetaprodugasto.gettipogastoproduempresa_descripcion());	
		productoordendetaprodugastoAsignar.setid_cuenta_contable_debito(productoordendetaprodugasto.getid_cuenta_contable_debito());
		productoordendetaprodugastoAsignar.setcuentacontabledebito_descripcion(productoordendetaprodugasto.getcuentacontabledebito_descripcion());	
		productoordendetaprodugastoAsignar.setid_cuenta_contable_credito(productoordendetaprodugasto.getid_cuenta_contable_credito());
		productoordendetaprodugastoAsignar.setcuentacontablecredito_descripcion(productoordendetaprodugasto.getcuentacontablecredito_descripcion());	
		productoordendetaprodugastoAsignar.setid_cliente_proveedor(productoordendetaprodugasto.getid_cliente_proveedor());
		productoordendetaprodugastoAsignar.setclienteproveedor_descripcion(productoordendetaprodugasto.getclienteproveedor_descripcion());	
		productoordendetaprodugastoAsignar.setid_factura(productoordendetaprodugasto.getid_factura());
		productoordendetaprodugastoAsignar.setfactura_descripcion(productoordendetaprodugasto.getfactura_descripcion());	
		productoordendetaprodugastoAsignar.setid_unidad(productoordendetaprodugasto.getid_unidad());
		productoordendetaprodugastoAsignar.setunidad_descripcion(productoordendetaprodugasto.getunidad_descripcion());	
		productoordendetaprodugastoAsignar.setcantidad(productoordendetaprodugasto.getcantidad());	
		productoordendetaprodugastoAsignar.setcosto(productoordendetaprodugasto.getcosto());	
		productoordendetaprodugastoAsignar.setcosto_total(productoordendetaprodugasto.getcosto_total());	
		productoordendetaprodugastoAsignar.setdescripcion(productoordendetaprodugasto.getdescripcion());	
	}
	
	public static void inicializarProductoOrdenDetaProduGasto(ProductoOrdenDetaProduGasto productoordendetaprodugasto) throws Exception {
		try {
				productoordendetaprodugasto.setId(0L);	
					
				productoordendetaprodugasto.setid_orden_deta_produ(-1L);	
				productoordendetaprodugasto.setid_tipo_gasto_produ_empresa(-1L);	
				productoordendetaprodugasto.setid_cuenta_contable_debito(-1L);	
				productoordendetaprodugasto.setid_cuenta_contable_credito(-1L);	
				productoordendetaprodugasto.setid_cliente_proveedor(-1L);	
				productoordendetaprodugasto.setid_factura(-1L);	
				productoordendetaprodugasto.setid_unidad(-1L);	
				productoordendetaprodugasto.setcantidad(0);	
				productoordendetaprodugasto.setcosto(0.0);	
				productoordendetaprodugasto.setcosto_total(0.0);	
				productoordendetaprodugasto.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductoOrdenDetaProduGasto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDORDENDETAPRODU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDTIPOGASTOPRODUEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDCLIENTEPROVEEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductoOrdenDetaProduGasto(String sTipo,Row row,Workbook workbook,ProductoOrdenDetaProduGasto productoordendetaprodugasto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodugasto.getordendetaprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodugasto.gettipogastoproduempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodugasto.getcuentacontabledebito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodugasto.getcuentacontablecredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodugasto.getclienteproveedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodugasto.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodugasto.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodugasto.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodugasto.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodugasto.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoordendetaprodugasto.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductoOrdenDetaProduGasto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProductoOrdenDetaProduGasto() {
		return this.sFinalQueryProductoOrdenDetaProduGasto;
	}
	
	public void setsFinalQueryProductoOrdenDetaProduGasto(String sFinalQueryProductoOrdenDetaProduGasto) {
		this.sFinalQueryProductoOrdenDetaProduGasto= sFinalQueryProductoOrdenDetaProduGasto;
	}
	
	public Border resaltarSeleccionarProductoOrdenDetaProduGasto=null;
	
	public Border setResaltarSeleccionarProductoOrdenDetaProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduGastoBeanSwingJInternalFrame productoordendetaprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productoordendetaprodugastoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduGasto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductoOrdenDetaProduGasto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductoOrdenDetaProduGasto() {
		return this.resaltarSeleccionarProductoOrdenDetaProduGasto;
	}
	
	public void setResaltarSeleccionarProductoOrdenDetaProduGasto(Border borderResaltarSeleccionarProductoOrdenDetaProduGasto) {
		this.resaltarSeleccionarProductoOrdenDetaProduGasto= borderResaltarSeleccionarProductoOrdenDetaProduGasto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductoOrdenDetaProduGasto=null;
	public Boolean mostraridProductoOrdenDetaProduGasto=true;
	public Boolean activaridProductoOrdenDetaProduGasto=true;

	public Border resaltarid_orden_deta_produProductoOrdenDetaProduGasto=null;
	public Boolean mostrarid_orden_deta_produProductoOrdenDetaProduGasto=true;
	public Boolean activarid_orden_deta_produProductoOrdenDetaProduGasto=true;
	public Boolean cargarid_orden_deta_produProductoOrdenDetaProduGasto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_orden_deta_produProductoOrdenDetaProduGasto=false;//ConEventDepend=true

	public Border resaltarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto=null;
	public Boolean mostrarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto=true;
	public Boolean activarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto=true;
	public Boolean cargarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_debitoProductoOrdenDetaProduGasto=null;
	public Boolean mostrarid_cuenta_contable_debitoProductoOrdenDetaProduGasto=true;
	public Boolean activarid_cuenta_contable_debitoProductoOrdenDetaProduGasto=true;
	public Boolean cargarid_cuenta_contable_debitoProductoOrdenDetaProduGasto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_debitoProductoOrdenDetaProduGasto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_creditoProductoOrdenDetaProduGasto=null;
	public Boolean mostrarid_cuenta_contable_creditoProductoOrdenDetaProduGasto=true;
	public Boolean activarid_cuenta_contable_creditoProductoOrdenDetaProduGasto=true;
	public Boolean cargarid_cuenta_contable_creditoProductoOrdenDetaProduGasto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_creditoProductoOrdenDetaProduGasto=false;//ConEventDepend=true

	public Border resaltarid_cliente_proveedorProductoOrdenDetaProduGasto=null;
	public Boolean mostrarid_cliente_proveedorProductoOrdenDetaProduGasto=true;
	public Boolean activarid_cliente_proveedorProductoOrdenDetaProduGasto=true;
	public Boolean cargarid_cliente_proveedorProductoOrdenDetaProduGasto=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cliente_proveedorProductoOrdenDetaProduGasto=false;//ConEventDepend=true

	public Border resaltarid_facturaProductoOrdenDetaProduGasto=null;
	public Boolean mostrarid_facturaProductoOrdenDetaProduGasto=true;
	public Boolean activarid_facturaProductoOrdenDetaProduGasto=true;
	public Boolean cargarid_facturaProductoOrdenDetaProduGasto=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaProductoOrdenDetaProduGasto=false;//ConEventDepend=true

	public Border resaltarid_unidadProductoOrdenDetaProduGasto=null;
	public Boolean mostrarid_unidadProductoOrdenDetaProduGasto=true;
	public Boolean activarid_unidadProductoOrdenDetaProduGasto=true;
	public Boolean cargarid_unidadProductoOrdenDetaProduGasto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadProductoOrdenDetaProduGasto=false;//ConEventDepend=true

	public Border resaltarcantidadProductoOrdenDetaProduGasto=null;
	public Boolean mostrarcantidadProductoOrdenDetaProduGasto=true;
	public Boolean activarcantidadProductoOrdenDetaProduGasto=true;

	public Border resaltarcostoProductoOrdenDetaProduGasto=null;
	public Boolean mostrarcostoProductoOrdenDetaProduGasto=true;
	public Boolean activarcostoProductoOrdenDetaProduGasto=true;

	public Border resaltarcosto_totalProductoOrdenDetaProduGasto=null;
	public Boolean mostrarcosto_totalProductoOrdenDetaProduGasto=true;
	public Boolean activarcosto_totalProductoOrdenDetaProduGasto=true;

	public Border resaltardescripcionProductoOrdenDetaProduGasto=null;
	public Boolean mostrardescripcionProductoOrdenDetaProduGasto=true;
	public Boolean activardescripcionProductoOrdenDetaProduGasto=true;

	
	

	public Border setResaltaridProductoOrdenDetaProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduGastoBeanSwingJInternalFrame productoordendetaprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodugastoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduGasto.setBorder(borderResaltar);
		
		this.resaltaridProductoOrdenDetaProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductoOrdenDetaProduGasto() {
		return this.resaltaridProductoOrdenDetaProduGasto;
	}

	public void setResaltaridProductoOrdenDetaProduGasto(Border borderResaltar) {
		this.resaltaridProductoOrdenDetaProduGasto= borderResaltar;
	}

	public Boolean getMostraridProductoOrdenDetaProduGasto() {
		return this.mostraridProductoOrdenDetaProduGasto;
	}

	public void setMostraridProductoOrdenDetaProduGasto(Boolean mostraridProductoOrdenDetaProduGasto) {
		this.mostraridProductoOrdenDetaProduGasto= mostraridProductoOrdenDetaProduGasto;
	}

	public Boolean getActivaridProductoOrdenDetaProduGasto() {
		return this.activaridProductoOrdenDetaProduGasto;
	}

	public void setActivaridProductoOrdenDetaProduGasto(Boolean activaridProductoOrdenDetaProduGasto) {
		this.activaridProductoOrdenDetaProduGasto= activaridProductoOrdenDetaProduGasto;
	}

	public Border setResaltarid_orden_deta_produProductoOrdenDetaProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduGastoBeanSwingJInternalFrame productoordendetaprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodugastoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduGasto.setBorder(borderResaltar);
		
		this.resaltarid_orden_deta_produProductoOrdenDetaProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_orden_deta_produProductoOrdenDetaProduGasto() {
		return this.resaltarid_orden_deta_produProductoOrdenDetaProduGasto;
	}

	public void setResaltarid_orden_deta_produProductoOrdenDetaProduGasto(Border borderResaltar) {
		this.resaltarid_orden_deta_produProductoOrdenDetaProduGasto= borderResaltar;
	}

	public Boolean getMostrarid_orden_deta_produProductoOrdenDetaProduGasto() {
		return this.mostrarid_orden_deta_produProductoOrdenDetaProduGasto;
	}

	public void setMostrarid_orden_deta_produProductoOrdenDetaProduGasto(Boolean mostrarid_orden_deta_produProductoOrdenDetaProduGasto) {
		this.mostrarid_orden_deta_produProductoOrdenDetaProduGasto= mostrarid_orden_deta_produProductoOrdenDetaProduGasto;
	}

	public Boolean getActivarid_orden_deta_produProductoOrdenDetaProduGasto() {
		return this.activarid_orden_deta_produProductoOrdenDetaProduGasto;
	}

	public void setActivarid_orden_deta_produProductoOrdenDetaProduGasto(Boolean activarid_orden_deta_produProductoOrdenDetaProduGasto) {
		this.activarid_orden_deta_produProductoOrdenDetaProduGasto= activarid_orden_deta_produProductoOrdenDetaProduGasto;
	}

	public Boolean getCargarid_orden_deta_produProductoOrdenDetaProduGasto() {
		return this.cargarid_orden_deta_produProductoOrdenDetaProduGasto;
	}

	public void setCargarid_orden_deta_produProductoOrdenDetaProduGasto(Boolean cargarid_orden_deta_produProductoOrdenDetaProduGasto) {
		this.cargarid_orden_deta_produProductoOrdenDetaProduGasto= cargarid_orden_deta_produProductoOrdenDetaProduGasto;
	}

	public Border setResaltarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduGastoBeanSwingJInternalFrame productoordendetaprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodugastoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduGasto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto() {
		return this.resaltarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto;
	}

	public void setResaltarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto(Border borderResaltar) {
		this.resaltarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto() {
		return this.mostrarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto;
	}

	public void setMostrarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto(Boolean mostrarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto) {
		this.mostrarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto= mostrarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto;
	}

	public Boolean getActivarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto() {
		return this.activarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto;
	}

	public void setActivarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto(Boolean activarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto) {
		this.activarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto= activarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto;
	}

	public Boolean getCargarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto() {
		return this.cargarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto;
	}

	public void setCargarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto(Boolean cargarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto) {
		this.cargarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto= cargarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto;
	}

	public Border setResaltarid_cuenta_contable_debitoProductoOrdenDetaProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduGastoBeanSwingJInternalFrame productoordendetaprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodugastoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduGasto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_debitoProductoOrdenDetaProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_debitoProductoOrdenDetaProduGasto() {
		return this.resaltarid_cuenta_contable_debitoProductoOrdenDetaProduGasto;
	}

	public void setResaltarid_cuenta_contable_debitoProductoOrdenDetaProduGasto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_debitoProductoOrdenDetaProduGasto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_debitoProductoOrdenDetaProduGasto() {
		return this.mostrarid_cuenta_contable_debitoProductoOrdenDetaProduGasto;
	}

	public void setMostrarid_cuenta_contable_debitoProductoOrdenDetaProduGasto(Boolean mostrarid_cuenta_contable_debitoProductoOrdenDetaProduGasto) {
		this.mostrarid_cuenta_contable_debitoProductoOrdenDetaProduGasto= mostrarid_cuenta_contable_debitoProductoOrdenDetaProduGasto;
	}

	public Boolean getActivarid_cuenta_contable_debitoProductoOrdenDetaProduGasto() {
		return this.activarid_cuenta_contable_debitoProductoOrdenDetaProduGasto;
	}

	public void setActivarid_cuenta_contable_debitoProductoOrdenDetaProduGasto(Boolean activarid_cuenta_contable_debitoProductoOrdenDetaProduGasto) {
		this.activarid_cuenta_contable_debitoProductoOrdenDetaProduGasto= activarid_cuenta_contable_debitoProductoOrdenDetaProduGasto;
	}

	public Boolean getCargarid_cuenta_contable_debitoProductoOrdenDetaProduGasto() {
		return this.cargarid_cuenta_contable_debitoProductoOrdenDetaProduGasto;
	}

	public void setCargarid_cuenta_contable_debitoProductoOrdenDetaProduGasto(Boolean cargarid_cuenta_contable_debitoProductoOrdenDetaProduGasto) {
		this.cargarid_cuenta_contable_debitoProductoOrdenDetaProduGasto= cargarid_cuenta_contable_debitoProductoOrdenDetaProduGasto;
	}

	public Border setResaltarid_cuenta_contable_creditoProductoOrdenDetaProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduGastoBeanSwingJInternalFrame productoordendetaprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodugastoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduGasto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_creditoProductoOrdenDetaProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_creditoProductoOrdenDetaProduGasto() {
		return this.resaltarid_cuenta_contable_creditoProductoOrdenDetaProduGasto;
	}

	public void setResaltarid_cuenta_contable_creditoProductoOrdenDetaProduGasto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_creditoProductoOrdenDetaProduGasto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_creditoProductoOrdenDetaProduGasto() {
		return this.mostrarid_cuenta_contable_creditoProductoOrdenDetaProduGasto;
	}

	public void setMostrarid_cuenta_contable_creditoProductoOrdenDetaProduGasto(Boolean mostrarid_cuenta_contable_creditoProductoOrdenDetaProduGasto) {
		this.mostrarid_cuenta_contable_creditoProductoOrdenDetaProduGasto= mostrarid_cuenta_contable_creditoProductoOrdenDetaProduGasto;
	}

	public Boolean getActivarid_cuenta_contable_creditoProductoOrdenDetaProduGasto() {
		return this.activarid_cuenta_contable_creditoProductoOrdenDetaProduGasto;
	}

	public void setActivarid_cuenta_contable_creditoProductoOrdenDetaProduGasto(Boolean activarid_cuenta_contable_creditoProductoOrdenDetaProduGasto) {
		this.activarid_cuenta_contable_creditoProductoOrdenDetaProduGasto= activarid_cuenta_contable_creditoProductoOrdenDetaProduGasto;
	}

	public Boolean getCargarid_cuenta_contable_creditoProductoOrdenDetaProduGasto() {
		return this.cargarid_cuenta_contable_creditoProductoOrdenDetaProduGasto;
	}

	public void setCargarid_cuenta_contable_creditoProductoOrdenDetaProduGasto(Boolean cargarid_cuenta_contable_creditoProductoOrdenDetaProduGasto) {
		this.cargarid_cuenta_contable_creditoProductoOrdenDetaProduGasto= cargarid_cuenta_contable_creditoProductoOrdenDetaProduGasto;
	}

	public Border setResaltarid_cliente_proveedorProductoOrdenDetaProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduGastoBeanSwingJInternalFrame productoordendetaprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodugastoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduGasto.setBorder(borderResaltar);
		
		this.resaltarid_cliente_proveedorProductoOrdenDetaProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cliente_proveedorProductoOrdenDetaProduGasto() {
		return this.resaltarid_cliente_proveedorProductoOrdenDetaProduGasto;
	}

	public void setResaltarid_cliente_proveedorProductoOrdenDetaProduGasto(Border borderResaltar) {
		this.resaltarid_cliente_proveedorProductoOrdenDetaProduGasto= borderResaltar;
	}

	public Boolean getMostrarid_cliente_proveedorProductoOrdenDetaProduGasto() {
		return this.mostrarid_cliente_proveedorProductoOrdenDetaProduGasto;
	}

	public void setMostrarid_cliente_proveedorProductoOrdenDetaProduGasto(Boolean mostrarid_cliente_proveedorProductoOrdenDetaProduGasto) {
		this.mostrarid_cliente_proveedorProductoOrdenDetaProduGasto= mostrarid_cliente_proveedorProductoOrdenDetaProduGasto;
	}

	public Boolean getActivarid_cliente_proveedorProductoOrdenDetaProduGasto() {
		return this.activarid_cliente_proveedorProductoOrdenDetaProduGasto;
	}

	public void setActivarid_cliente_proveedorProductoOrdenDetaProduGasto(Boolean activarid_cliente_proveedorProductoOrdenDetaProduGasto) {
		this.activarid_cliente_proveedorProductoOrdenDetaProduGasto= activarid_cliente_proveedorProductoOrdenDetaProduGasto;
	}

	public Boolean getCargarid_cliente_proveedorProductoOrdenDetaProduGasto() {
		return this.cargarid_cliente_proveedorProductoOrdenDetaProduGasto;
	}

	public void setCargarid_cliente_proveedorProductoOrdenDetaProduGasto(Boolean cargarid_cliente_proveedorProductoOrdenDetaProduGasto) {
		this.cargarid_cliente_proveedorProductoOrdenDetaProduGasto= cargarid_cliente_proveedorProductoOrdenDetaProduGasto;
	}

	public Border setResaltarid_facturaProductoOrdenDetaProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduGastoBeanSwingJInternalFrame productoordendetaprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodugastoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduGasto.setBorder(borderResaltar);
		
		this.resaltarid_facturaProductoOrdenDetaProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaProductoOrdenDetaProduGasto() {
		return this.resaltarid_facturaProductoOrdenDetaProduGasto;
	}

	public void setResaltarid_facturaProductoOrdenDetaProduGasto(Border borderResaltar) {
		this.resaltarid_facturaProductoOrdenDetaProduGasto= borderResaltar;
	}

	public Boolean getMostrarid_facturaProductoOrdenDetaProduGasto() {
		return this.mostrarid_facturaProductoOrdenDetaProduGasto;
	}

	public void setMostrarid_facturaProductoOrdenDetaProduGasto(Boolean mostrarid_facturaProductoOrdenDetaProduGasto) {
		this.mostrarid_facturaProductoOrdenDetaProduGasto= mostrarid_facturaProductoOrdenDetaProduGasto;
	}

	public Boolean getActivarid_facturaProductoOrdenDetaProduGasto() {
		return this.activarid_facturaProductoOrdenDetaProduGasto;
	}

	public void setActivarid_facturaProductoOrdenDetaProduGasto(Boolean activarid_facturaProductoOrdenDetaProduGasto) {
		this.activarid_facturaProductoOrdenDetaProduGasto= activarid_facturaProductoOrdenDetaProduGasto;
	}

	public Boolean getCargarid_facturaProductoOrdenDetaProduGasto() {
		return this.cargarid_facturaProductoOrdenDetaProduGasto;
	}

	public void setCargarid_facturaProductoOrdenDetaProduGasto(Boolean cargarid_facturaProductoOrdenDetaProduGasto) {
		this.cargarid_facturaProductoOrdenDetaProduGasto= cargarid_facturaProductoOrdenDetaProduGasto;
	}

	public Border setResaltarid_unidadProductoOrdenDetaProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduGastoBeanSwingJInternalFrame productoordendetaprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodugastoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduGasto.setBorder(borderResaltar);
		
		this.resaltarid_unidadProductoOrdenDetaProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadProductoOrdenDetaProduGasto() {
		return this.resaltarid_unidadProductoOrdenDetaProduGasto;
	}

	public void setResaltarid_unidadProductoOrdenDetaProduGasto(Border borderResaltar) {
		this.resaltarid_unidadProductoOrdenDetaProduGasto= borderResaltar;
	}

	public Boolean getMostrarid_unidadProductoOrdenDetaProduGasto() {
		return this.mostrarid_unidadProductoOrdenDetaProduGasto;
	}

	public void setMostrarid_unidadProductoOrdenDetaProduGasto(Boolean mostrarid_unidadProductoOrdenDetaProduGasto) {
		this.mostrarid_unidadProductoOrdenDetaProduGasto= mostrarid_unidadProductoOrdenDetaProduGasto;
	}

	public Boolean getActivarid_unidadProductoOrdenDetaProduGasto() {
		return this.activarid_unidadProductoOrdenDetaProduGasto;
	}

	public void setActivarid_unidadProductoOrdenDetaProduGasto(Boolean activarid_unidadProductoOrdenDetaProduGasto) {
		this.activarid_unidadProductoOrdenDetaProduGasto= activarid_unidadProductoOrdenDetaProduGasto;
	}

	public Boolean getCargarid_unidadProductoOrdenDetaProduGasto() {
		return this.cargarid_unidadProductoOrdenDetaProduGasto;
	}

	public void setCargarid_unidadProductoOrdenDetaProduGasto(Boolean cargarid_unidadProductoOrdenDetaProduGasto) {
		this.cargarid_unidadProductoOrdenDetaProduGasto= cargarid_unidadProductoOrdenDetaProduGasto;
	}

	public Border setResaltarcantidadProductoOrdenDetaProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduGastoBeanSwingJInternalFrame productoordendetaprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodugastoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduGasto.setBorder(borderResaltar);
		
		this.resaltarcantidadProductoOrdenDetaProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadProductoOrdenDetaProduGasto() {
		return this.resaltarcantidadProductoOrdenDetaProduGasto;
	}

	public void setResaltarcantidadProductoOrdenDetaProduGasto(Border borderResaltar) {
		this.resaltarcantidadProductoOrdenDetaProduGasto= borderResaltar;
	}

	public Boolean getMostrarcantidadProductoOrdenDetaProduGasto() {
		return this.mostrarcantidadProductoOrdenDetaProduGasto;
	}

	public void setMostrarcantidadProductoOrdenDetaProduGasto(Boolean mostrarcantidadProductoOrdenDetaProduGasto) {
		this.mostrarcantidadProductoOrdenDetaProduGasto= mostrarcantidadProductoOrdenDetaProduGasto;
	}

	public Boolean getActivarcantidadProductoOrdenDetaProduGasto() {
		return this.activarcantidadProductoOrdenDetaProduGasto;
	}

	public void setActivarcantidadProductoOrdenDetaProduGasto(Boolean activarcantidadProductoOrdenDetaProduGasto) {
		this.activarcantidadProductoOrdenDetaProduGasto= activarcantidadProductoOrdenDetaProduGasto;
	}

	public Border setResaltarcostoProductoOrdenDetaProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduGastoBeanSwingJInternalFrame productoordendetaprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodugastoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduGasto.setBorder(borderResaltar);
		
		this.resaltarcostoProductoOrdenDetaProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoProductoOrdenDetaProduGasto() {
		return this.resaltarcostoProductoOrdenDetaProduGasto;
	}

	public void setResaltarcostoProductoOrdenDetaProduGasto(Border borderResaltar) {
		this.resaltarcostoProductoOrdenDetaProduGasto= borderResaltar;
	}

	public Boolean getMostrarcostoProductoOrdenDetaProduGasto() {
		return this.mostrarcostoProductoOrdenDetaProduGasto;
	}

	public void setMostrarcostoProductoOrdenDetaProduGasto(Boolean mostrarcostoProductoOrdenDetaProduGasto) {
		this.mostrarcostoProductoOrdenDetaProduGasto= mostrarcostoProductoOrdenDetaProduGasto;
	}

	public Boolean getActivarcostoProductoOrdenDetaProduGasto() {
		return this.activarcostoProductoOrdenDetaProduGasto;
	}

	public void setActivarcostoProductoOrdenDetaProduGasto(Boolean activarcostoProductoOrdenDetaProduGasto) {
		this.activarcostoProductoOrdenDetaProduGasto= activarcostoProductoOrdenDetaProduGasto;
	}

	public Border setResaltarcosto_totalProductoOrdenDetaProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduGastoBeanSwingJInternalFrame productoordendetaprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodugastoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduGasto.setBorder(borderResaltar);
		
		this.resaltarcosto_totalProductoOrdenDetaProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalProductoOrdenDetaProduGasto() {
		return this.resaltarcosto_totalProductoOrdenDetaProduGasto;
	}

	public void setResaltarcosto_totalProductoOrdenDetaProduGasto(Border borderResaltar) {
		this.resaltarcosto_totalProductoOrdenDetaProduGasto= borderResaltar;
	}

	public Boolean getMostrarcosto_totalProductoOrdenDetaProduGasto() {
		return this.mostrarcosto_totalProductoOrdenDetaProduGasto;
	}

	public void setMostrarcosto_totalProductoOrdenDetaProduGasto(Boolean mostrarcosto_totalProductoOrdenDetaProduGasto) {
		this.mostrarcosto_totalProductoOrdenDetaProduGasto= mostrarcosto_totalProductoOrdenDetaProduGasto;
	}

	public Boolean getActivarcosto_totalProductoOrdenDetaProduGasto() {
		return this.activarcosto_totalProductoOrdenDetaProduGasto;
	}

	public void setActivarcosto_totalProductoOrdenDetaProduGasto(Boolean activarcosto_totalProductoOrdenDetaProduGasto) {
		this.activarcosto_totalProductoOrdenDetaProduGasto= activarcosto_totalProductoOrdenDetaProduGasto;
	}

	public Border setResaltardescripcionProductoOrdenDetaProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduGastoBeanSwingJInternalFrame productoordendetaprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoordendetaprodugastoBeanSwingJInternalFrame.jTtoolBarProductoOrdenDetaProduGasto.setBorder(borderResaltar);
		
		this.resaltardescripcionProductoOrdenDetaProduGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionProductoOrdenDetaProduGasto() {
		return this.resaltardescripcionProductoOrdenDetaProduGasto;
	}

	public void setResaltardescripcionProductoOrdenDetaProduGasto(Border borderResaltar) {
		this.resaltardescripcionProductoOrdenDetaProduGasto= borderResaltar;
	}

	public Boolean getMostrardescripcionProductoOrdenDetaProduGasto() {
		return this.mostrardescripcionProductoOrdenDetaProduGasto;
	}

	public void setMostrardescripcionProductoOrdenDetaProduGasto(Boolean mostrardescripcionProductoOrdenDetaProduGasto) {
		this.mostrardescripcionProductoOrdenDetaProduGasto= mostrardescripcionProductoOrdenDetaProduGasto;
	}

	public Boolean getActivardescripcionProductoOrdenDetaProduGasto() {
		return this.activardescripcionProductoOrdenDetaProduGasto;
	}

	public void setActivardescripcionProductoOrdenDetaProduGasto(Boolean activardescripcionProductoOrdenDetaProduGasto) {
		this.activardescripcionProductoOrdenDetaProduGasto= activardescripcionProductoOrdenDetaProduGasto;
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
		
		
		this.setMostraridProductoOrdenDetaProduGasto(esInicial);
		this.setMostrarid_orden_deta_produProductoOrdenDetaProduGasto(esInicial);
		this.setMostrarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto(esInicial);
		this.setMostrarid_cuenta_contable_debitoProductoOrdenDetaProduGasto(esInicial);
		this.setMostrarid_cuenta_contable_creditoProductoOrdenDetaProduGasto(esInicial);
		this.setMostrarid_cliente_proveedorProductoOrdenDetaProduGasto(esInicial);
		this.setMostrarid_facturaProductoOrdenDetaProduGasto(esInicial);
		this.setMostrarid_unidadProductoOrdenDetaProduGasto(esInicial);
		this.setMostrarcantidadProductoOrdenDetaProduGasto(esInicial);
		this.setMostrarcostoProductoOrdenDetaProduGasto(esInicial);
		this.setMostrarcosto_totalProductoOrdenDetaProduGasto(esInicial);
		this.setMostrardescripcionProductoOrdenDetaProduGasto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.ID)) {
				this.setMostraridProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDORDENDETAPRODU)) {
				this.setMostrarid_orden_deta_produProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA)) {
				this.setMostrarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setMostrarid_cuenta_contable_debitoProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setMostrarid_cuenta_contable_creditoProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR)) {
				this.setMostrarid_cliente_proveedorProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.COSTO)) {
				this.setMostrarcostoProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionProductoOrdenDetaProduGasto(esAsigna);
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
		
		
		this.setActivaridProductoOrdenDetaProduGasto(esInicial);
		this.setActivarid_orden_deta_produProductoOrdenDetaProduGasto(esInicial);
		this.setActivarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto(esInicial);
		this.setActivarid_cuenta_contable_debitoProductoOrdenDetaProduGasto(esInicial);
		this.setActivarid_cuenta_contable_creditoProductoOrdenDetaProduGasto(esInicial);
		this.setActivarid_cliente_proveedorProductoOrdenDetaProduGasto(esInicial);
		this.setActivarid_facturaProductoOrdenDetaProduGasto(esInicial);
		this.setActivarid_unidadProductoOrdenDetaProduGasto(esInicial);
		this.setActivarcantidadProductoOrdenDetaProduGasto(esInicial);
		this.setActivarcostoProductoOrdenDetaProduGasto(esInicial);
		this.setActivarcosto_totalProductoOrdenDetaProduGasto(esInicial);
		this.setActivardescripcionProductoOrdenDetaProduGasto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.ID)) {
				this.setActivaridProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDORDENDETAPRODU)) {
				this.setActivarid_orden_deta_produProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA)) {
				this.setActivarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setActivarid_cuenta_contable_debitoProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setActivarid_cuenta_contable_creditoProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR)) {
				this.setActivarid_cliente_proveedorProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.COSTO)) {
				this.setActivarcostoProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoOrdenDetaProduGastoBeanSwingJInternalFrame productoordendetaprodugastoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductoOrdenDetaProduGasto(esInicial);
		this.setResaltarid_orden_deta_produProductoOrdenDetaProduGasto(esInicial);
		this.setResaltarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto(esInicial);
		this.setResaltarid_cuenta_contable_debitoProductoOrdenDetaProduGasto(esInicial);
		this.setResaltarid_cuenta_contable_creditoProductoOrdenDetaProduGasto(esInicial);
		this.setResaltarid_cliente_proveedorProductoOrdenDetaProduGasto(esInicial);
		this.setResaltarid_facturaProductoOrdenDetaProduGasto(esInicial);
		this.setResaltarid_unidadProductoOrdenDetaProduGasto(esInicial);
		this.setResaltarcantidadProductoOrdenDetaProduGasto(esInicial);
		this.setResaltarcostoProductoOrdenDetaProduGasto(esInicial);
		this.setResaltarcosto_totalProductoOrdenDetaProduGasto(esInicial);
		this.setResaltardescripcionProductoOrdenDetaProduGasto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.ID)) {
				this.setResaltaridProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDORDENDETAPRODU)) {
				this.setResaltarid_orden_deta_produProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA)) {
				this.setResaltarid_tipo_gasto_produ_empresaProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setResaltarid_cuenta_contable_debitoProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setResaltarid_cuenta_contable_creditoProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR)) {
				this.setResaltarid_cliente_proveedorProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.COSTO)) {
				this.setResaltarcostoProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalProductoOrdenDetaProduGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoOrdenDetaProduGastoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionProductoOrdenDetaProduGasto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoOrdenDetaProduGastoBeanSwingJInternalFrame productoordendetaprodugastoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteProveedorProductoOrdenDetaProduGasto=true;

	public Boolean getMostrarFK_IdClienteProveedorProductoOrdenDetaProduGasto() {
		return this.mostrarFK_IdClienteProveedorProductoOrdenDetaProduGasto;
	}

	public void setMostrarFK_IdClienteProveedorProductoOrdenDetaProduGasto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteProveedorProductoOrdenDetaProduGasto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCreditoProductoOrdenDetaProduGasto=true;

	public Boolean getMostrarFK_IdCuentaContableCreditoProductoOrdenDetaProduGasto() {
		return this.mostrarFK_IdCuentaContableCreditoProductoOrdenDetaProduGasto;
	}

	public void setMostrarFK_IdCuentaContableCreditoProductoOrdenDetaProduGasto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCreditoProductoOrdenDetaProduGasto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableDebitoProductoOrdenDetaProduGasto=true;

	public Boolean getMostrarFK_IdCuentaContableDebitoProductoOrdenDetaProduGasto() {
		return this.mostrarFK_IdCuentaContableDebitoProductoOrdenDetaProduGasto;
	}

	public void setMostrarFK_IdCuentaContableDebitoProductoOrdenDetaProduGasto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableDebitoProductoOrdenDetaProduGasto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaProductoOrdenDetaProduGasto=true;

	public Boolean getMostrarFK_IdFacturaProductoOrdenDetaProduGasto() {
		return this.mostrarFK_IdFacturaProductoOrdenDetaProduGasto;
	}

	public void setMostrarFK_IdFacturaProductoOrdenDetaProduGasto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaProductoOrdenDetaProduGasto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdOrdenDetaProduProductoOrdenDetaProduGasto=true;

	public Boolean getMostrarFK_IdOrdenDetaProduProductoOrdenDetaProduGasto() {
		return this.mostrarFK_IdOrdenDetaProduProductoOrdenDetaProduGasto;
	}

	public void setMostrarFK_IdOrdenDetaProduProductoOrdenDetaProduGasto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdOrdenDetaProduProductoOrdenDetaProduGasto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoGastoProduEmpresaProductoOrdenDetaProduGasto=true;

	public Boolean getMostrarFK_IdTipoGastoProduEmpresaProductoOrdenDetaProduGasto() {
		return this.mostrarFK_IdTipoGastoProduEmpresaProductoOrdenDetaProduGasto;
	}

	public void setMostrarFK_IdTipoGastoProduEmpresaProductoOrdenDetaProduGasto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoGastoProduEmpresaProductoOrdenDetaProduGasto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadProductoOrdenDetaProduGasto=true;

	public Boolean getMostrarFK_IdUnidadProductoOrdenDetaProduGasto() {
		return this.mostrarFK_IdUnidadProductoOrdenDetaProduGasto;
	}

	public void setMostrarFK_IdUnidadProductoOrdenDetaProduGasto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadProductoOrdenDetaProduGasto= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteProveedorProductoOrdenDetaProduGasto=true;

	public Boolean getActivarFK_IdClienteProveedorProductoOrdenDetaProduGasto() {
		return this.activarFK_IdClienteProveedorProductoOrdenDetaProduGasto;
	}

	public void setActivarFK_IdClienteProveedorProductoOrdenDetaProduGasto(Boolean habilitarResaltar) {
		this.activarFK_IdClienteProveedorProductoOrdenDetaProduGasto= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCreditoProductoOrdenDetaProduGasto=true;

	public Boolean getActivarFK_IdCuentaContableCreditoProductoOrdenDetaProduGasto() {
		return this.activarFK_IdCuentaContableCreditoProductoOrdenDetaProduGasto;
	}

	public void setActivarFK_IdCuentaContableCreditoProductoOrdenDetaProduGasto(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCreditoProductoOrdenDetaProduGasto= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableDebitoProductoOrdenDetaProduGasto=true;

	public Boolean getActivarFK_IdCuentaContableDebitoProductoOrdenDetaProduGasto() {
		return this.activarFK_IdCuentaContableDebitoProductoOrdenDetaProduGasto;
	}

	public void setActivarFK_IdCuentaContableDebitoProductoOrdenDetaProduGasto(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableDebitoProductoOrdenDetaProduGasto= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaProductoOrdenDetaProduGasto=true;

	public Boolean getActivarFK_IdFacturaProductoOrdenDetaProduGasto() {
		return this.activarFK_IdFacturaProductoOrdenDetaProduGasto;
	}

	public void setActivarFK_IdFacturaProductoOrdenDetaProduGasto(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaProductoOrdenDetaProduGasto= habilitarResaltar;
	}

	public Boolean activarFK_IdOrdenDetaProduProductoOrdenDetaProduGasto=true;

	public Boolean getActivarFK_IdOrdenDetaProduProductoOrdenDetaProduGasto() {
		return this.activarFK_IdOrdenDetaProduProductoOrdenDetaProduGasto;
	}

	public void setActivarFK_IdOrdenDetaProduProductoOrdenDetaProduGasto(Boolean habilitarResaltar) {
		this.activarFK_IdOrdenDetaProduProductoOrdenDetaProduGasto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoGastoProduEmpresaProductoOrdenDetaProduGasto=true;

	public Boolean getActivarFK_IdTipoGastoProduEmpresaProductoOrdenDetaProduGasto() {
		return this.activarFK_IdTipoGastoProduEmpresaProductoOrdenDetaProduGasto;
	}

	public void setActivarFK_IdTipoGastoProduEmpresaProductoOrdenDetaProduGasto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoGastoProduEmpresaProductoOrdenDetaProduGasto= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadProductoOrdenDetaProduGasto=true;

	public Boolean getActivarFK_IdUnidadProductoOrdenDetaProduGasto() {
		return this.activarFK_IdUnidadProductoOrdenDetaProduGasto;
	}

	public void setActivarFK_IdUnidadProductoOrdenDetaProduGasto(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadProductoOrdenDetaProduGasto= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteProveedorProductoOrdenDetaProduGasto=null;

	public Border getResaltarFK_IdClienteProveedorProductoOrdenDetaProduGasto() {
		return this.resaltarFK_IdClienteProveedorProductoOrdenDetaProduGasto;
	}

	public void setResaltarFK_IdClienteProveedorProductoOrdenDetaProduGasto(Border borderResaltar) {
		this.resaltarFK_IdClienteProveedorProductoOrdenDetaProduGasto= borderResaltar;
	}

	public void setResaltarFK_IdClienteProveedorProductoOrdenDetaProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduGastoBeanSwingJInternalFrame productoordendetaprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteProveedorProductoOrdenDetaProduGasto= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCreditoProductoOrdenDetaProduGasto=null;

	public Border getResaltarFK_IdCuentaContableCreditoProductoOrdenDetaProduGasto() {
		return this.resaltarFK_IdCuentaContableCreditoProductoOrdenDetaProduGasto;
	}

	public void setResaltarFK_IdCuentaContableCreditoProductoOrdenDetaProduGasto(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCreditoProductoOrdenDetaProduGasto= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCreditoProductoOrdenDetaProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduGastoBeanSwingJInternalFrame productoordendetaprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCreditoProductoOrdenDetaProduGasto= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableDebitoProductoOrdenDetaProduGasto=null;

	public Border getResaltarFK_IdCuentaContableDebitoProductoOrdenDetaProduGasto() {
		return this.resaltarFK_IdCuentaContableDebitoProductoOrdenDetaProduGasto;
	}

	public void setResaltarFK_IdCuentaContableDebitoProductoOrdenDetaProduGasto(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableDebitoProductoOrdenDetaProduGasto= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableDebitoProductoOrdenDetaProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduGastoBeanSwingJInternalFrame productoordendetaprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableDebitoProductoOrdenDetaProduGasto= borderResaltar;
	}

	public Border resaltarFK_IdFacturaProductoOrdenDetaProduGasto=null;

	public Border getResaltarFK_IdFacturaProductoOrdenDetaProduGasto() {
		return this.resaltarFK_IdFacturaProductoOrdenDetaProduGasto;
	}

	public void setResaltarFK_IdFacturaProductoOrdenDetaProduGasto(Border borderResaltar) {
		this.resaltarFK_IdFacturaProductoOrdenDetaProduGasto= borderResaltar;
	}

	public void setResaltarFK_IdFacturaProductoOrdenDetaProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduGastoBeanSwingJInternalFrame productoordendetaprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaProductoOrdenDetaProduGasto= borderResaltar;
	}

	public Border resaltarFK_IdOrdenDetaProduProductoOrdenDetaProduGasto=null;

	public Border getResaltarFK_IdOrdenDetaProduProductoOrdenDetaProduGasto() {
		return this.resaltarFK_IdOrdenDetaProduProductoOrdenDetaProduGasto;
	}

	public void setResaltarFK_IdOrdenDetaProduProductoOrdenDetaProduGasto(Border borderResaltar) {
		this.resaltarFK_IdOrdenDetaProduProductoOrdenDetaProduGasto= borderResaltar;
	}

	public void setResaltarFK_IdOrdenDetaProduProductoOrdenDetaProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduGastoBeanSwingJInternalFrame productoordendetaprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdOrdenDetaProduProductoOrdenDetaProduGasto= borderResaltar;
	}

	public Border resaltarFK_IdTipoGastoProduEmpresaProductoOrdenDetaProduGasto=null;

	public Border getResaltarFK_IdTipoGastoProduEmpresaProductoOrdenDetaProduGasto() {
		return this.resaltarFK_IdTipoGastoProduEmpresaProductoOrdenDetaProduGasto;
	}

	public void setResaltarFK_IdTipoGastoProduEmpresaProductoOrdenDetaProduGasto(Border borderResaltar) {
		this.resaltarFK_IdTipoGastoProduEmpresaProductoOrdenDetaProduGasto= borderResaltar;
	}

	public void setResaltarFK_IdTipoGastoProduEmpresaProductoOrdenDetaProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduGastoBeanSwingJInternalFrame productoordendetaprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoGastoProduEmpresaProductoOrdenDetaProduGasto= borderResaltar;
	}

	public Border resaltarFK_IdUnidadProductoOrdenDetaProduGasto=null;

	public Border getResaltarFK_IdUnidadProductoOrdenDetaProduGasto() {
		return this.resaltarFK_IdUnidadProductoOrdenDetaProduGasto;
	}

	public void setResaltarFK_IdUnidadProductoOrdenDetaProduGasto(Border borderResaltar) {
		this.resaltarFK_IdUnidadProductoOrdenDetaProduGasto= borderResaltar;
	}

	public void setResaltarFK_IdUnidadProductoOrdenDetaProduGasto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoOrdenDetaProduGastoBeanSwingJInternalFrame productoordendetaprodugastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadProductoOrdenDetaProduGasto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}