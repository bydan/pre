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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.ParametroFactuConstantesFunciones;
import com.bydan.erp.facturacion.util.ParametroFactuParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ParametroFactuParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroFactuConstantesFunciones extends ParametroFactuConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroFactu";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroFactu"+ParametroFactuConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroFactuHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroFactuHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroFactuConstantesFunciones.SCHEMA+"_"+ParametroFactuConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroFactuHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroFactuConstantesFunciones.SCHEMA+"_"+ParametroFactuConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroFactuConstantesFunciones.SCHEMA+"_"+ParametroFactuConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroFactuHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroFactuConstantesFunciones.SCHEMA+"_"+ParametroFactuConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFactuConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroFactuHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFactuConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFactuConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroFactuHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFactuConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroFactuConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroFactuConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroFactuConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroFactuConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Factus";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parametro Factu";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Factu";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroFactu";
	public static final String OBJECTNAME="parametrofactu";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="parametro_factu";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametrofactu from "+ParametroFactuConstantesFunciones.SPERSISTENCENAME+" parametrofactu";
	public static String QUERYSELECTNATIVE="select "+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".version_row,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id_empresa,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id_cuenta_contable_factu,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id_cuenta_contable_finan,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id_cuenta_contable_otro,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id_formato_proforma,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id_formato_pedido,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id_formato_factura,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id_formato_nota_credito,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".id_formato_inventario,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".secuencial_proforma,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".secuancial_pedido,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".secuencial_factura,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".secuencial_nota_credito,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".item_proforma,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".item_pedido,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".item_factura,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".item_nota_credito,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".item_inventario,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".con_detalle_proforma,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".con_detalle_pedido,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".con_detalle_factura,"+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME+".con_detalle_nota_credito from "+ParametroFactuConstantesFunciones.SCHEMA+"."+ParametroFactuConstantesFunciones.TABLENAME;//+" as "+ParametroFactuConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroFactuConstantesFuncionesAdditional parametrofactuConstantesFuncionesAdditional=null;
	
	public ParametroFactuConstantesFuncionesAdditional getParametroFactuConstantesFuncionesAdditional() {
		return this.parametrofactuConstantesFuncionesAdditional;
	}
	
	public void setParametroFactuConstantesFuncionesAdditional(ParametroFactuConstantesFuncionesAdditional parametrofactuConstantesFuncionesAdditional) {
		try {
			this.parametrofactuConstantesFuncionesAdditional=parametrofactuConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCUENTACONTABLEFACTU= "id_cuenta_contable_factu";
    public static final String IDCUENTACONTABLEFINAN= "id_cuenta_contable_finan";
    public static final String IDCUENTACONTABLEOTRO= "id_cuenta_contable_otro";
    public static final String IDFORMATOPROFORMA= "id_formato_proforma";
    public static final String IDFORMATOPEDIDO= "id_formato_pedido";
    public static final String IDFORMATOFACTURA= "id_formato_factura";
    public static final String IDFORMATONOTACREDITO= "id_formato_nota_credito";
    public static final String IDFORMATOINVENTARIO= "id_formato_inventario";
    public static final String SECUENCIALPROFORMA= "secuencial_proforma";
    public static final String SECUANCIALPEDIDO= "secuancial_pedido";
    public static final String SECUENCIALFACTURA= "secuencial_factura";
    public static final String SECUENCIALNOTACREDITO= "secuencial_nota_credito";
    public static final String ITEMPROFORMA= "item_proforma";
    public static final String ITEMPEDIDO= "item_pedido";
    public static final String ITEMFACTURA= "item_factura";
    public static final String ITEMNOTACREDITO= "item_nota_credito";
    public static final String ITEMINVENTARIO= "item_inventario";
    public static final String CONDETALLEPROFORMA= "con_detalle_proforma";
    public static final String CONDETALLEPEDIDO= "con_detalle_pedido";
    public static final String CONDETALLEFACTURA= "con_detalle_factura";
    public static final String CONDETALLENOTACREDITO= "con_detalle_nota_credito";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCUENTACONTABLEFACTU= "Cuenta Contable Factu";
		public static final String LABEL_IDCUENTACONTABLEFACTU_LOWER= "Cuenta Contable Factu";
    	public static final String LABEL_IDCUENTACONTABLEFINAN= "Cuenta Contable Finan";
		public static final String LABEL_IDCUENTACONTABLEFINAN_LOWER= "Cuenta Contable Finan";
    	public static final String LABEL_IDCUENTACONTABLEOTRO= "Cuenta Contable Otro";
		public static final String LABEL_IDCUENTACONTABLEOTRO_LOWER= "Cuenta Contable Otro";
    	public static final String LABEL_IDFORMATOPROFORMA= "Formato Proforma";
		public static final String LABEL_IDFORMATOPROFORMA_LOWER= "Formato Proforma";
    	public static final String LABEL_IDFORMATOPEDIDO= "Formato Pedo";
		public static final String LABEL_IDFORMATOPEDIDO_LOWER= "Formato Pedido";
    	public static final String LABEL_IDFORMATOFACTURA= "Formato Factura";
		public static final String LABEL_IDFORMATOFACTURA_LOWER= "Formato Factura";
    	public static final String LABEL_IDFORMATONOTACREDITO= "Formato Nota Credito";
		public static final String LABEL_IDFORMATONOTACREDITO_LOWER= "Formato Nota Credito";
    	public static final String LABEL_IDFORMATOINVENTARIO= "Formato Inventario";
		public static final String LABEL_IDFORMATOINVENTARIO_LOWER= "Formato Inventario";
    	public static final String LABEL_SECUENCIALPROFORMA= "Secuencial Proforma";
		public static final String LABEL_SECUENCIALPROFORMA_LOWER= "Secuencial Proforma";
    	public static final String LABEL_SECUANCIALPEDIDO= "Secuancial Pedido";
		public static final String LABEL_SECUANCIALPEDIDO_LOWER= "Secuancial Pedido";
    	public static final String LABEL_SECUENCIALFACTURA= "Secuencial Factura";
		public static final String LABEL_SECUENCIALFACTURA_LOWER= "Secuencial Factura";
    	public static final String LABEL_SECUENCIALNOTACREDITO= "Secuencial Nota Credito";
		public static final String LABEL_SECUENCIALNOTACREDITO_LOWER= "Secuencial Nota Credito";
    	public static final String LABEL_ITEMPROFORMA= "Item Proforma";
		public static final String LABEL_ITEMPROFORMA_LOWER= "Item Proforma";
    	public static final String LABEL_ITEMPEDIDO= "Item Pedido";
		public static final String LABEL_ITEMPEDIDO_LOWER= "Item Pedido";
    	public static final String LABEL_ITEMFACTURA= "Item Factura";
		public static final String LABEL_ITEMFACTURA_LOWER= "Item Factura";
    	public static final String LABEL_ITEMNOTACREDITO= "Item Nota Credito";
		public static final String LABEL_ITEMNOTACREDITO_LOWER= "Item Nota Credito";
    	public static final String LABEL_ITEMINVENTARIO= "Item Inventario";
		public static final String LABEL_ITEMINVENTARIO_LOWER= "Item Inventario";
    	public static final String LABEL_CONDETALLEPROFORMA= "Con Detalle Proforma";
		public static final String LABEL_CONDETALLEPROFORMA_LOWER= "Con Detalle Proforma";
    	public static final String LABEL_CONDETALLEPEDIDO= "Con Detalle Pedido";
		public static final String LABEL_CONDETALLEPEDIDO_LOWER= "Con Detalle Pedido";
    	public static final String LABEL_CONDETALLEFACTURA= "Con Detalle Factura";
		public static final String LABEL_CONDETALLEFACTURA_LOWER= "Con Detalle Factura";
    	public static final String LABEL_CONDETALLENOTACREDITO= "Con Detalle Nota Credito";
		public static final String LABEL_CONDETALLENOTACREDITO_LOWER= "Con Detalle Nota Credito";
	
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXSECUENCIAL_PROFORMA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL_PROFORMA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSECUANCIAL_PEDIDO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUANCIAL_PEDIDO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSECUENCIAL_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSECUENCIAL_NOTA_CREDITO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL_NOTA_CREDITO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
	
	public static String getParametroFactuLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.IDCUENTACONTABLEFACTU)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_IDCUENTACONTABLEFACTU;}
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.IDCUENTACONTABLEFINAN)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_IDCUENTACONTABLEFINAN;}
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.IDCUENTACONTABLEOTRO)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_IDCUENTACONTABLEOTRO;}
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.IDFORMATOPROFORMA)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_IDFORMATOPROFORMA;}
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.IDFORMATOPEDIDO)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_IDFORMATOPEDIDO;}
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.IDFORMATOFACTURA)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_IDFORMATOFACTURA;}
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.IDFORMATONOTACREDITO)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_IDFORMATONOTACREDITO;}
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.IDFORMATOINVENTARIO)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_IDFORMATOINVENTARIO;}
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.SECUENCIALPROFORMA)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_SECUENCIALPROFORMA;}
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.SECUANCIALPEDIDO)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_SECUANCIALPEDIDO;}
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.SECUENCIALFACTURA)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_SECUENCIALFACTURA;}
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.SECUENCIALNOTACREDITO)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_SECUENCIALNOTACREDITO;}
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.ITEMPROFORMA)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_ITEMPROFORMA;}
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.ITEMPEDIDO)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_ITEMPEDIDO;}
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.ITEMFACTURA)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_ITEMFACTURA;}
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.ITEMNOTACREDITO)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_ITEMNOTACREDITO;}
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.ITEMINVENTARIO)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_ITEMINVENTARIO;}
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.CONDETALLEPROFORMA)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_CONDETALLEPROFORMA;}
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.CONDETALLEPEDIDO)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_CONDETALLEPEDIDO;}
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.CONDETALLEFACTURA)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_CONDETALLEFACTURA;}
		if(sNombreColumna.equals(ParametroFactuConstantesFunciones.CONDETALLENOTACREDITO)) {sLabelColumna=ParametroFactuConstantesFunciones.LABEL_CONDETALLENOTACREDITO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_detalle_proformaDescripcion(ParametroFactu parametrofactu) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactu.getcon_detalle_proforma()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_detalle_proformaHtmlDescripcion(ParametroFactu parametrofactu) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactu.getId(),parametrofactu.getcon_detalle_proforma());

		return sDescripcion;
	}	
		
	public static String getcon_detalle_pedidoDescripcion(ParametroFactu parametrofactu) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactu.getcon_detalle_pedido()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_detalle_pedidoHtmlDescripcion(ParametroFactu parametrofactu) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactu.getId(),parametrofactu.getcon_detalle_pedido());

		return sDescripcion;
	}	
		
	public static String getcon_detalle_facturaDescripcion(ParametroFactu parametrofactu) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactu.getcon_detalle_factura()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_detalle_facturaHtmlDescripcion(ParametroFactu parametrofactu) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactu.getId(),parametrofactu.getcon_detalle_factura());

		return sDescripcion;
	}	
		
	public static String getcon_detalle_nota_creditoDescripcion(ParametroFactu parametrofactu) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactu.getcon_detalle_nota_credito()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_detalle_nota_creditoHtmlDescripcion(ParametroFactu parametrofactu) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactu.getId(),parametrofactu.getcon_detalle_nota_credito());

		return sDescripcion;
	}	
	
	public static String getParametroFactuDescripcion(ParametroFactu parametrofactu) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametrofactu !=null/* && parametrofactu.getId()!=0*/) {
			if(parametrofactu.getId()!=null) {
				sDescripcion=parametrofactu.getId().toString();
			}//parametrofactuparametrofactu.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroFactuDescripcionDetallado(ParametroFactu parametrofactu) {
		String sDescripcion="";
			
		sDescripcion+=ParametroFactuConstantesFunciones.ID+"=";
		sDescripcion+=parametrofactu.getId().toString()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametrofactu.getVersionRow().toString()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametrofactu.getid_empresa().toString()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=parametrofactu.getid_sucursal().toString()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.IDCUENTACONTABLEFACTU+"=";
		sDescripcion+=parametrofactu.getid_cuenta_contable_factu().toString()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.IDCUENTACONTABLEFINAN+"=";
		sDescripcion+=parametrofactu.getid_cuenta_contable_finan().toString()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.IDCUENTACONTABLEOTRO+"=";
		sDescripcion+=parametrofactu.getid_cuenta_contable_otro().toString()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.IDFORMATOPROFORMA+"=";
		sDescripcion+=parametrofactu.getid_formato_proforma().toString()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.IDFORMATOPEDIDO+"=";
		sDescripcion+=parametrofactu.getid_formato_pedido().toString()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.IDFORMATOFACTURA+"=";
		sDescripcion+=parametrofactu.getid_formato_factura().toString()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.IDFORMATONOTACREDITO+"=";
		sDescripcion+=parametrofactu.getid_formato_nota_credito().toString()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.IDFORMATOINVENTARIO+"=";
		sDescripcion+=parametrofactu.getid_formato_inventario().toString()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.SECUENCIALPROFORMA+"=";
		sDescripcion+=parametrofactu.getsecuencial_proforma()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.SECUANCIALPEDIDO+"=";
		sDescripcion+=parametrofactu.getsecuancial_pedido()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.SECUENCIALFACTURA+"=";
		sDescripcion+=parametrofactu.getsecuencial_factura()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.SECUENCIALNOTACREDITO+"=";
		sDescripcion+=parametrofactu.getsecuencial_nota_credito()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.ITEMPROFORMA+"=";
		sDescripcion+=parametrofactu.getitem_proforma().toString()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.ITEMPEDIDO+"=";
		sDescripcion+=parametrofactu.getitem_pedido().toString()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.ITEMFACTURA+"=";
		sDescripcion+=parametrofactu.getitem_factura().toString()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.ITEMNOTACREDITO+"=";
		sDescripcion+=parametrofactu.getitem_nota_credito().toString()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.ITEMINVENTARIO+"=";
		sDescripcion+=parametrofactu.getitem_inventario().toString()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.CONDETALLEPROFORMA+"=";
		sDescripcion+=parametrofactu.getcon_detalle_proforma().toString()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.CONDETALLEPEDIDO+"=";
		sDescripcion+=parametrofactu.getcon_detalle_pedido().toString()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.CONDETALLEFACTURA+"=";
		sDescripcion+=parametrofactu.getcon_detalle_factura().toString()+",";
		sDescripcion+=ParametroFactuConstantesFunciones.CONDETALLENOTACREDITO+"=";
		sDescripcion+=parametrofactu.getcon_detalle_nota_credito().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroFactuDescripcion(ParametroFactu parametrofactu,String sValor) throws Exception {			
		if(parametrofactu !=null) {
			//parametrofactuparametrofactu.getId().toString();
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

	public static String getCuentaContableFactuDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableFinanDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableOtroDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getFormatoProformaDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getFormatoPedidoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getFormatoFacturaDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getFormatoNotaCreditoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getFormatoInventarioDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCuentaContableFactu")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Factu";
		} else if(sNombreIndice.equals("FK_IdCuentaContableFinan")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Finan";
		} else if(sNombreIndice.equals("FK_IdCuentaContableOtro")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Otro";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFormatoFactura")) {
			sNombreIndice="Tipo=  Por Formato Factura";
		} else if(sNombreIndice.equals("FK_IdFormatoInventario")) {
			sNombreIndice="Tipo=  Por Formato Inventario";
		} else if(sNombreIndice.equals("FK_IdFormatoNotaCredito")) {
			sNombreIndice="Tipo=  Por Formato Nota Credito";
		} else if(sNombreIndice.equals("FK_IdFormatoPedo")) {
			sNombreIndice="Tipo=  Por Formato Pedo";
		} else if(sNombreIndice.equals("FK_IdFormatoProforma")) {
			sNombreIndice="Tipo=  Por Formato Proforma";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCuentaContableFactu(Long id_cuenta_contable_factu) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_factu!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Factu="+id_cuenta_contable_factu.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableFinan(Long id_cuenta_contable_finan) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_finan!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Finan="+id_cuenta_contable_finan.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableOtro(Long id_cuenta_contable_otro) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_otro!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Otro="+id_cuenta_contable_otro.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoFactura(Long id_formato_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_factura!=null) {sDetalleIndice+=" Codigo Unico De Formato Factura="+id_formato_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoInventario(Long id_formato_inventario) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_inventario!=null) {sDetalleIndice+=" Codigo Unico De Formato Inventario="+id_formato_inventario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoNotaCredito(Long id_formato_nota_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_nota_credito!=null) {sDetalleIndice+=" Codigo Unico De Formato Nota Credito="+id_formato_nota_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoPedo(Long id_formato_pedido) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_pedido!=null) {sDetalleIndice+=" Codigo Unico De Formato Pedo="+id_formato_pedido.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoProforma(Long id_formato_proforma) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_proforma!=null) {sDetalleIndice+=" Codigo Unico De Formato Proforma="+id_formato_proforma.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroFactu(ParametroFactu parametrofactu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		parametrofactu.setsecuencial_proforma(parametrofactu.getsecuencial_proforma().trim());
		parametrofactu.setsecuancial_pedido(parametrofactu.getsecuancial_pedido().trim());
		parametrofactu.setsecuencial_factura(parametrofactu.getsecuencial_factura().trim());
		parametrofactu.setsecuencial_nota_credito(parametrofactu.getsecuencial_nota_credito().trim());
	}
	
	public static void quitarEspaciosParametroFactus(List<ParametroFactu> parametrofactus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroFactu parametrofactu: parametrofactus) {
			parametrofactu.setsecuencial_proforma(parametrofactu.getsecuencial_proforma().trim());
			parametrofactu.setsecuancial_pedido(parametrofactu.getsecuancial_pedido().trim());
			parametrofactu.setsecuencial_factura(parametrofactu.getsecuencial_factura().trim());
			parametrofactu.setsecuencial_nota_credito(parametrofactu.getsecuencial_nota_credito().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroFactu(ParametroFactu parametrofactu,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametrofactu.getConCambioAuxiliar()) {
			parametrofactu.setIsDeleted(parametrofactu.getIsDeletedAuxiliar());	
			parametrofactu.setIsNew(parametrofactu.getIsNewAuxiliar());	
			parametrofactu.setIsChanged(parametrofactu.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametrofactu.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametrofactu.setIsDeletedAuxiliar(false);	
			parametrofactu.setIsNewAuxiliar(false);	
			parametrofactu.setIsChangedAuxiliar(false);
			
			parametrofactu.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroFactus(List<ParametroFactu> parametrofactus,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroFactu parametrofactu : parametrofactus) {
			if(conAsignarBase && parametrofactu.getConCambioAuxiliar()) {
				parametrofactu.setIsDeleted(parametrofactu.getIsDeletedAuxiliar());	
				parametrofactu.setIsNew(parametrofactu.getIsNewAuxiliar());	
				parametrofactu.setIsChanged(parametrofactu.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametrofactu.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametrofactu.setIsDeletedAuxiliar(false);	
				parametrofactu.setIsNewAuxiliar(false);	
				parametrofactu.setIsChangedAuxiliar(false);
				
				parametrofactu.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroFactu(ParametroFactu parametrofactu,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			parametrofactu.setitem_proforma(0);
			parametrofactu.setitem_pedido(0);
			parametrofactu.setitem_factura(0);
			parametrofactu.setitem_nota_credito(0);
			parametrofactu.setitem_inventario(0);
		}
	}		
	
	public static void InicializarValoresParametroFactus(List<ParametroFactu> parametrofactus,Boolean conEnteros) throws Exception  {
		
		for(ParametroFactu parametrofactu: parametrofactus) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				parametrofactu.setitem_proforma(0);
				parametrofactu.setitem_pedido(0);
				parametrofactu.setitem_factura(0);
				parametrofactu.setitem_nota_credito(0);
				parametrofactu.setitem_inventario(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroFactu(List<ParametroFactu> parametrofactus,ParametroFactu parametrofactuAux) throws Exception  {
		ParametroFactuConstantesFunciones.InicializarValoresParametroFactu(parametrofactuAux,true);
		
		for(ParametroFactu parametrofactu: parametrofactus) {
			if(parametrofactu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			parametrofactuAux.setitem_proforma(parametrofactuAux.getitem_proforma()+parametrofactu.getitem_proforma());			
			parametrofactuAux.setitem_pedido(parametrofactuAux.getitem_pedido()+parametrofactu.getitem_pedido());			
			parametrofactuAux.setitem_factura(parametrofactuAux.getitem_factura()+parametrofactu.getitem_factura());			
			parametrofactuAux.setitem_nota_credito(parametrofactuAux.getitem_nota_credito()+parametrofactu.getitem_nota_credito());			
			parametrofactuAux.setitem_inventario(parametrofactuAux.getitem_inventario()+parametrofactu.getitem_inventario());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroFactu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroFactuConstantesFunciones.getArrayColumnasGlobalesParametroFactu(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroFactu(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroFactuConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroFactuConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroFactuConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroFactuConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroFactu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroFactu> parametrofactus,ParametroFactu parametrofactu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroFactu parametrofactuAux: parametrofactus) {
			if(parametrofactuAux!=null && parametrofactu!=null) {
				if((parametrofactuAux.getId()==null && parametrofactu.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametrofactuAux.getId()!=null && parametrofactu.getId()!=null){
					if(parametrofactuAux.getId().equals(parametrofactu.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroFactu(List<ParametroFactu> parametrofactus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroFactu parametrofactu: parametrofactus) {			
			if(parametrofactu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroFactu() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_ID, ParametroFactuConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_VERSIONROW, ParametroFactuConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_IDEMPRESA, ParametroFactuConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_IDSUCURSAL, ParametroFactuConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_IDCUENTACONTABLEFACTU, ParametroFactuConstantesFunciones.IDCUENTACONTABLEFACTU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_IDCUENTACONTABLEFINAN, ParametroFactuConstantesFunciones.IDCUENTACONTABLEFINAN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_IDCUENTACONTABLEOTRO, ParametroFactuConstantesFunciones.IDCUENTACONTABLEOTRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_IDFORMATOPROFORMA, ParametroFactuConstantesFunciones.IDFORMATOPROFORMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_IDFORMATOPEDIDO, ParametroFactuConstantesFunciones.IDFORMATOPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_IDFORMATOFACTURA, ParametroFactuConstantesFunciones.IDFORMATOFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_IDFORMATONOTACREDITO, ParametroFactuConstantesFunciones.IDFORMATONOTACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_IDFORMATOINVENTARIO, ParametroFactuConstantesFunciones.IDFORMATOINVENTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_SECUENCIALPROFORMA, ParametroFactuConstantesFunciones.SECUENCIALPROFORMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_SECUANCIALPEDIDO, ParametroFactuConstantesFunciones.SECUANCIALPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_SECUENCIALFACTURA, ParametroFactuConstantesFunciones.SECUENCIALFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_SECUENCIALNOTACREDITO, ParametroFactuConstantesFunciones.SECUENCIALNOTACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_ITEMPROFORMA, ParametroFactuConstantesFunciones.ITEMPROFORMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_ITEMPEDIDO, ParametroFactuConstantesFunciones.ITEMPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_ITEMFACTURA, ParametroFactuConstantesFunciones.ITEMFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_ITEMNOTACREDITO, ParametroFactuConstantesFunciones.ITEMNOTACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_ITEMINVENTARIO, ParametroFactuConstantesFunciones.ITEMINVENTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_CONDETALLEPROFORMA, ParametroFactuConstantesFunciones.CONDETALLEPROFORMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_CONDETALLEPEDIDO, ParametroFactuConstantesFunciones.CONDETALLEPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_CONDETALLEFACTURA, ParametroFactuConstantesFunciones.CONDETALLEFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuConstantesFunciones.LABEL_CONDETALLENOTACREDITO, ParametroFactuConstantesFunciones.CONDETALLENOTACREDITO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroFactu() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.IDCUENTACONTABLEFACTU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.IDCUENTACONTABLEFINAN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.IDCUENTACONTABLEOTRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.IDFORMATOPROFORMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.IDFORMATOPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.IDFORMATOFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.IDFORMATONOTACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.IDFORMATOINVENTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.SECUENCIALPROFORMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.SECUANCIALPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.SECUENCIALFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.SECUENCIALNOTACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.ITEMPROFORMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.ITEMPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.ITEMFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.ITEMNOTACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.ITEMINVENTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.CONDETALLEPROFORMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.CONDETALLEPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.CONDETALLEFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuConstantesFunciones.CONDETALLENOTACREDITO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFactu() throws Exception  {
		return ParametroFactuConstantesFunciones.getTiposSeleccionarParametroFactu(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFactu(Boolean conFk) throws Exception  {
		return ParametroFactuConstantesFunciones.getTiposSeleccionarParametroFactu(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFactu(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_IDCUENTACONTABLEFACTU);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_IDCUENTACONTABLEFACTU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_IDCUENTACONTABLEFINAN);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_IDCUENTACONTABLEFINAN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_IDCUENTACONTABLEOTRO);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_IDCUENTACONTABLEOTRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_IDFORMATOPROFORMA);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_IDFORMATOPROFORMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_IDFORMATOPEDIDO);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_IDFORMATOPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_IDFORMATOFACTURA);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_IDFORMATOFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_IDFORMATONOTACREDITO);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_IDFORMATONOTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_IDFORMATOINVENTARIO);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_IDFORMATOINVENTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_SECUENCIALPROFORMA);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_SECUENCIALPROFORMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_SECUANCIALPEDIDO);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_SECUANCIALPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_SECUENCIALFACTURA);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_SECUENCIALFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_SECUENCIALNOTACREDITO);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_SECUENCIALNOTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_ITEMPROFORMA);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_ITEMPROFORMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_ITEMPEDIDO);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_ITEMPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_ITEMFACTURA);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_ITEMFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_ITEMNOTACREDITO);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_ITEMNOTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_ITEMINVENTARIO);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_ITEMINVENTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_CONDETALLEPROFORMA);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_CONDETALLEPROFORMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_CONDETALLEPEDIDO);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_CONDETALLEPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_CONDETALLEFACTURA);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_CONDETALLEFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuConstantesFunciones.LABEL_CONDETALLENOTACREDITO);
			reporte.setsDescripcion(ParametroFactuConstantesFunciones.LABEL_CONDETALLENOTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroFactu(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroFactu(ParametroFactu parametrofactuAux) throws Exception {
		
			parametrofactuAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrofactuAux.getEmpresa()));
			parametrofactuAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrofactuAux.getSucursal()));
			parametrofactuAux.setcuentacontablefactu_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrofactuAux.getCuentaContableFactu()));
			parametrofactuAux.setcuentacontablefinan_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrofactuAux.getCuentaContableFinan()));
			parametrofactuAux.setcuentacontableotro_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrofactuAux.getCuentaContableOtro()));
			parametrofactuAux.setformatoproforma_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrofactuAux.getFormatoProforma()));
			parametrofactuAux.setformatopedido_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrofactuAux.getFormatoPedido()));
			parametrofactuAux.setformatofactura_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrofactuAux.getFormatoFactura()));
			parametrofactuAux.setformatonotacredito_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrofactuAux.getFormatoNotaCredito()));
			parametrofactuAux.setformatoinventario_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrofactuAux.getFormatoInventario()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroFactu(List<ParametroFactu> parametrofactusTemp) throws Exception {
		for(ParametroFactu parametrofactuAux:parametrofactusTemp) {
			
			parametrofactuAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrofactuAux.getEmpresa()));
			parametrofactuAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrofactuAux.getSucursal()));
			parametrofactuAux.setcuentacontablefactu_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrofactuAux.getCuentaContableFactu()));
			parametrofactuAux.setcuentacontablefinan_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrofactuAux.getCuentaContableFinan()));
			parametrofactuAux.setcuentacontableotro_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrofactuAux.getCuentaContableOtro()));
			parametrofactuAux.setformatoproforma_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrofactuAux.getFormatoProforma()));
			parametrofactuAux.setformatopedido_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrofactuAux.getFormatoPedido()));
			parametrofactuAux.setformatofactura_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrofactuAux.getFormatoFactura()));
			parametrofactuAux.setformatonotacredito_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrofactuAux.getFormatoNotaCredito()));
			parametrofactuAux.setformatoinventario_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrofactuAux.getFormatoInventario()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroFactu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Formato.class));
				
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
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroFactu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
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

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFactu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroFactuConstantesFunciones.getClassesRelationshipsOfParametroFactu(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFactu(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroFactu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroFactuConstantesFunciones.getClassesRelationshipsFromStringsOfParametroFactu(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroFactu(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParametroFactu parametrofactu,List<ParametroFactu> parametrofactus,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroFactu parametrofactuEncontrado=null;
			
			for(ParametroFactu parametrofactuLocal:parametrofactus) {
				if(parametrofactuLocal.getId().equals(parametrofactu.getId())) {
					parametrofactuEncontrado=parametrofactuLocal;
					
					parametrofactuLocal.setIsChanged(parametrofactu.getIsChanged());
					parametrofactuLocal.setIsNew(parametrofactu.getIsNew());
					parametrofactuLocal.setIsDeleted(parametrofactu.getIsDeleted());
					
					parametrofactuLocal.setGeneralEntityOriginal(parametrofactu.getGeneralEntityOriginal());
					
					parametrofactuLocal.setId(parametrofactu.getId());	
					parametrofactuLocal.setVersionRow(parametrofactu.getVersionRow());	
					parametrofactuLocal.setid_empresa(parametrofactu.getid_empresa());	
					parametrofactuLocal.setid_sucursal(parametrofactu.getid_sucursal());	
					parametrofactuLocal.setid_cuenta_contable_factu(parametrofactu.getid_cuenta_contable_factu());	
					parametrofactuLocal.setid_cuenta_contable_finan(parametrofactu.getid_cuenta_contable_finan());	
					parametrofactuLocal.setid_cuenta_contable_otro(parametrofactu.getid_cuenta_contable_otro());	
					parametrofactuLocal.setid_formato_proforma(parametrofactu.getid_formato_proforma());	
					parametrofactuLocal.setid_formato_pedido(parametrofactu.getid_formato_pedido());	
					parametrofactuLocal.setid_formato_factura(parametrofactu.getid_formato_factura());	
					parametrofactuLocal.setid_formato_nota_credito(parametrofactu.getid_formato_nota_credito());	
					parametrofactuLocal.setid_formato_inventario(parametrofactu.getid_formato_inventario());	
					parametrofactuLocal.setsecuencial_proforma(parametrofactu.getsecuencial_proforma());	
					parametrofactuLocal.setsecuancial_pedido(parametrofactu.getsecuancial_pedido());	
					parametrofactuLocal.setsecuencial_factura(parametrofactu.getsecuencial_factura());	
					parametrofactuLocal.setsecuencial_nota_credito(parametrofactu.getsecuencial_nota_credito());	
					parametrofactuLocal.setitem_proforma(parametrofactu.getitem_proforma());	
					parametrofactuLocal.setitem_pedido(parametrofactu.getitem_pedido());	
					parametrofactuLocal.setitem_factura(parametrofactu.getitem_factura());	
					parametrofactuLocal.setitem_nota_credito(parametrofactu.getitem_nota_credito());	
					parametrofactuLocal.setitem_inventario(parametrofactu.getitem_inventario());	
					parametrofactuLocal.setcon_detalle_proforma(parametrofactu.getcon_detalle_proforma());	
					parametrofactuLocal.setcon_detalle_pedido(parametrofactu.getcon_detalle_pedido());	
					parametrofactuLocal.setcon_detalle_factura(parametrofactu.getcon_detalle_factura());	
					parametrofactuLocal.setcon_detalle_nota_credito(parametrofactu.getcon_detalle_nota_credito());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametrofactu.getIsDeleted()) {
				if(!existe) {
					parametrofactus.add(parametrofactu);
				}
			} else {
				if(parametrofactuEncontrado!=null && permiteQuitar)  {
					parametrofactus.remove(parametrofactuEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroFactu parametrofactu,List<ParametroFactu> parametrofactus) throws Exception {
		try	{			
			for(ParametroFactu parametrofactuLocal:parametrofactus) {
				if(parametrofactuLocal.getId().equals(parametrofactu.getId())) {
					parametrofactuLocal.setIsSelected(parametrofactu.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroFactu(List<ParametroFactu> parametrofactusAux) throws Exception {
		//this.parametrofactusAux=parametrofactusAux;
		
		for(ParametroFactu parametrofactuAux:parametrofactusAux) {
			if(parametrofactuAux.getIsChanged()) {
				parametrofactuAux.setIsChanged(false);
			}		
			
			if(parametrofactuAux.getIsNew()) {
				parametrofactuAux.setIsNew(false);
			}	
			
			if(parametrofactuAux.getIsDeleted()) {
				parametrofactuAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroFactu(ParametroFactu parametrofactuAux) throws Exception {
		//this.parametrofactuAux=parametrofactuAux;
		
			if(parametrofactuAux.getIsChanged()) {
				parametrofactuAux.setIsChanged(false);
			}		
			
			if(parametrofactuAux.getIsNew()) {
				parametrofactuAux.setIsNew(false);
			}	
			
			if(parametrofactuAux.getIsDeleted()) {
				parametrofactuAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroFactu parametrofactuAsignar,ParametroFactu parametrofactu) throws Exception {
		parametrofactuAsignar.setId(parametrofactu.getId());	
		parametrofactuAsignar.setVersionRow(parametrofactu.getVersionRow());	
		parametrofactuAsignar.setid_empresa(parametrofactu.getid_empresa());
		parametrofactuAsignar.setempresa_descripcion(parametrofactu.getempresa_descripcion());	
		parametrofactuAsignar.setid_sucursal(parametrofactu.getid_sucursal());
		parametrofactuAsignar.setsucursal_descripcion(parametrofactu.getsucursal_descripcion());	
		parametrofactuAsignar.setid_cuenta_contable_factu(parametrofactu.getid_cuenta_contable_factu());
		parametrofactuAsignar.setcuentacontablefactu_descripcion(parametrofactu.getcuentacontablefactu_descripcion());	
		parametrofactuAsignar.setid_cuenta_contable_finan(parametrofactu.getid_cuenta_contable_finan());
		parametrofactuAsignar.setcuentacontablefinan_descripcion(parametrofactu.getcuentacontablefinan_descripcion());	
		parametrofactuAsignar.setid_cuenta_contable_otro(parametrofactu.getid_cuenta_contable_otro());
		parametrofactuAsignar.setcuentacontableotro_descripcion(parametrofactu.getcuentacontableotro_descripcion());	
		parametrofactuAsignar.setid_formato_proforma(parametrofactu.getid_formato_proforma());
		parametrofactuAsignar.setformatoproforma_descripcion(parametrofactu.getformatoproforma_descripcion());	
		parametrofactuAsignar.setid_formato_pedido(parametrofactu.getid_formato_pedido());
		parametrofactuAsignar.setformatopedido_descripcion(parametrofactu.getformatopedido_descripcion());	
		parametrofactuAsignar.setid_formato_factura(parametrofactu.getid_formato_factura());
		parametrofactuAsignar.setformatofactura_descripcion(parametrofactu.getformatofactura_descripcion());	
		parametrofactuAsignar.setid_formato_nota_credito(parametrofactu.getid_formato_nota_credito());
		parametrofactuAsignar.setformatonotacredito_descripcion(parametrofactu.getformatonotacredito_descripcion());	
		parametrofactuAsignar.setid_formato_inventario(parametrofactu.getid_formato_inventario());
		parametrofactuAsignar.setformatoinventario_descripcion(parametrofactu.getformatoinventario_descripcion());	
		parametrofactuAsignar.setsecuencial_proforma(parametrofactu.getsecuencial_proforma());	
		parametrofactuAsignar.setsecuancial_pedido(parametrofactu.getsecuancial_pedido());	
		parametrofactuAsignar.setsecuencial_factura(parametrofactu.getsecuencial_factura());	
		parametrofactuAsignar.setsecuencial_nota_credito(parametrofactu.getsecuencial_nota_credito());	
		parametrofactuAsignar.setitem_proforma(parametrofactu.getitem_proforma());	
		parametrofactuAsignar.setitem_pedido(parametrofactu.getitem_pedido());	
		parametrofactuAsignar.setitem_factura(parametrofactu.getitem_factura());	
		parametrofactuAsignar.setitem_nota_credito(parametrofactu.getitem_nota_credito());	
		parametrofactuAsignar.setitem_inventario(parametrofactu.getitem_inventario());	
		parametrofactuAsignar.setcon_detalle_proforma(parametrofactu.getcon_detalle_proforma());	
		parametrofactuAsignar.setcon_detalle_pedido(parametrofactu.getcon_detalle_pedido());	
		parametrofactuAsignar.setcon_detalle_factura(parametrofactu.getcon_detalle_factura());	
		parametrofactuAsignar.setcon_detalle_nota_credito(parametrofactu.getcon_detalle_nota_credito());	
	}
	
	public static void inicializarParametroFactu(ParametroFactu parametrofactu) throws Exception {
		try {
				parametrofactu.setId(0L);	
					
				parametrofactu.setid_empresa(-1L);	
				parametrofactu.setid_sucursal(-1L);	
				parametrofactu.setid_cuenta_contable_factu(-1L);	
				parametrofactu.setid_cuenta_contable_finan(-1L);	
				parametrofactu.setid_cuenta_contable_otro(-1L);	
				parametrofactu.setid_formato_proforma(-1L);	
				parametrofactu.setid_formato_pedido(-1L);	
				parametrofactu.setid_formato_factura(-1L);	
				parametrofactu.setid_formato_nota_credito(-1L);	
				parametrofactu.setid_formato_inventario(-1L);	
				parametrofactu.setsecuencial_proforma("");	
				parametrofactu.setsecuancial_pedido("");	
				parametrofactu.setsecuencial_factura("");	
				parametrofactu.setsecuencial_nota_credito("");	
				parametrofactu.setitem_proforma(0);	
				parametrofactu.setitem_pedido(0);	
				parametrofactu.setitem_factura(0);	
				parametrofactu.setitem_nota_credito(0);	
				parametrofactu.setitem_inventario(0);	
				parametrofactu.setcon_detalle_proforma(false);	
				parametrofactu.setcon_detalle_pedido(false);	
				parametrofactu.setcon_detalle_factura(false);	
				parametrofactu.setcon_detalle_nota_credito(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroFactu(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_IDCUENTACONTABLEFACTU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_IDCUENTACONTABLEFINAN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_IDCUENTACONTABLEOTRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_IDFORMATOPROFORMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_IDFORMATOPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_IDFORMATOFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_IDFORMATONOTACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_IDFORMATOINVENTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_SECUENCIALPROFORMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_SECUANCIALPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_SECUENCIALFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_SECUENCIALNOTACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_ITEMPROFORMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_ITEMPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_ITEMFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_ITEMNOTACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_ITEMINVENTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_CONDETALLEPROFORMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_CONDETALLEPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_CONDETALLEFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuConstantesFunciones.LABEL_CONDETALLENOTACREDITO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroFactu(String sTipo,Row row,Workbook workbook,ParametroFactu parametrofactu,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactu.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactu.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactu.getcuentacontablefactu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactu.getcuentacontablefinan_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactu.getcuentacontableotro_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactu.getformatoproforma_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactu.getformatopedido_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactu.getformatofactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactu.getformatonotacredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactu.getformatoinventario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactu.getsecuencial_proforma());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactu.getsecuancial_pedido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactu.getsecuencial_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactu.getsecuencial_nota_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactu.getitem_proforma());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactu.getitem_pedido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactu.getitem_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactu.getitem_nota_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactu.getitem_inventario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactu.getcon_detalle_proforma()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactu.getcon_detalle_pedido()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactu.getcon_detalle_factura()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactu.getcon_detalle_nota_credito()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroFactu=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroFactu() {
		return this.sFinalQueryParametroFactu;
	}
	
	public void setsFinalQueryParametroFactu(String sFinalQueryParametroFactu) {
		this.sFinalQueryParametroFactu= sFinalQueryParametroFactu;
	}
	
	public Border resaltarSeleccionarParametroFactu=null;
	
	public Border setResaltarSeleccionarParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroFactu= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroFactu() {
		return this.resaltarSeleccionarParametroFactu;
	}
	
	public void setResaltarSeleccionarParametroFactu(Border borderResaltarSeleccionarParametroFactu) {
		this.resaltarSeleccionarParametroFactu= borderResaltarSeleccionarParametroFactu;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroFactu=null;
	public Boolean mostraridParametroFactu=true;
	public Boolean activaridParametroFactu=true;

	public Border resaltarid_empresaParametroFactu=null;
	public Boolean mostrarid_empresaParametroFactu=true;
	public Boolean activarid_empresaParametroFactu=true;
	public Boolean cargarid_empresaParametroFactu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroFactu=false;//ConEventDepend=true

	public Border resaltarid_sucursalParametroFactu=null;
	public Boolean mostrarid_sucursalParametroFactu=true;
	public Boolean activarid_sucursalParametroFactu=true;
	public Boolean cargarid_sucursalParametroFactu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalParametroFactu=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_factuParametroFactu=null;
	public Boolean mostrarid_cuenta_contable_factuParametroFactu=true;
	public Boolean activarid_cuenta_contable_factuParametroFactu=true;
	public Boolean cargarid_cuenta_contable_factuParametroFactu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_factuParametroFactu=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_finanParametroFactu=null;
	public Boolean mostrarid_cuenta_contable_finanParametroFactu=true;
	public Boolean activarid_cuenta_contable_finanParametroFactu=true;
	public Boolean cargarid_cuenta_contable_finanParametroFactu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_finanParametroFactu=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_otroParametroFactu=null;
	public Boolean mostrarid_cuenta_contable_otroParametroFactu=true;
	public Boolean activarid_cuenta_contable_otroParametroFactu=true;
	public Boolean cargarid_cuenta_contable_otroParametroFactu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_otroParametroFactu=false;//ConEventDepend=true

	public Border resaltarid_formato_proformaParametroFactu=null;
	public Boolean mostrarid_formato_proformaParametroFactu=true;
	public Boolean activarid_formato_proformaParametroFactu=true;
	public Boolean cargarid_formato_proformaParametroFactu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_proformaParametroFactu=false;//ConEventDepend=true

	public Border resaltarid_formato_pedidoParametroFactu=null;
	public Boolean mostrarid_formato_pedidoParametroFactu=true;
	public Boolean activarid_formato_pedidoParametroFactu=true;
	public Boolean cargarid_formato_pedidoParametroFactu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_pedidoParametroFactu=false;//ConEventDepend=true

	public Border resaltarid_formato_facturaParametroFactu=null;
	public Boolean mostrarid_formato_facturaParametroFactu=true;
	public Boolean activarid_formato_facturaParametroFactu=true;
	public Boolean cargarid_formato_facturaParametroFactu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_facturaParametroFactu=false;//ConEventDepend=true

	public Border resaltarid_formato_nota_creditoParametroFactu=null;
	public Boolean mostrarid_formato_nota_creditoParametroFactu=true;
	public Boolean activarid_formato_nota_creditoParametroFactu=true;
	public Boolean cargarid_formato_nota_creditoParametroFactu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_nota_creditoParametroFactu=false;//ConEventDepend=true

	public Border resaltarid_formato_inventarioParametroFactu=null;
	public Boolean mostrarid_formato_inventarioParametroFactu=true;
	public Boolean activarid_formato_inventarioParametroFactu=true;
	public Boolean cargarid_formato_inventarioParametroFactu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_inventarioParametroFactu=false;//ConEventDepend=true

	public Border resaltarsecuencial_proformaParametroFactu=null;
	public Boolean mostrarsecuencial_proformaParametroFactu=true;
	public Boolean activarsecuencial_proformaParametroFactu=true;

	public Border resaltarsecuancial_pedidoParametroFactu=null;
	public Boolean mostrarsecuancial_pedidoParametroFactu=true;
	public Boolean activarsecuancial_pedidoParametroFactu=true;

	public Border resaltarsecuencial_facturaParametroFactu=null;
	public Boolean mostrarsecuencial_facturaParametroFactu=true;
	public Boolean activarsecuencial_facturaParametroFactu=true;

	public Border resaltarsecuencial_nota_creditoParametroFactu=null;
	public Boolean mostrarsecuencial_nota_creditoParametroFactu=true;
	public Boolean activarsecuencial_nota_creditoParametroFactu=true;

	public Border resaltaritem_proformaParametroFactu=null;
	public Boolean mostraritem_proformaParametroFactu=true;
	public Boolean activaritem_proformaParametroFactu=true;

	public Border resaltaritem_pedidoParametroFactu=null;
	public Boolean mostraritem_pedidoParametroFactu=true;
	public Boolean activaritem_pedidoParametroFactu=true;

	public Border resaltaritem_facturaParametroFactu=null;
	public Boolean mostraritem_facturaParametroFactu=true;
	public Boolean activaritem_facturaParametroFactu=true;

	public Border resaltaritem_nota_creditoParametroFactu=null;
	public Boolean mostraritem_nota_creditoParametroFactu=true;
	public Boolean activaritem_nota_creditoParametroFactu=true;

	public Border resaltaritem_inventarioParametroFactu=null;
	public Boolean mostraritem_inventarioParametroFactu=true;
	public Boolean activaritem_inventarioParametroFactu=true;

	public Border resaltarcon_detalle_proformaParametroFactu=null;
	public Boolean mostrarcon_detalle_proformaParametroFactu=true;
	public Boolean activarcon_detalle_proformaParametroFactu=true;

	public Border resaltarcon_detalle_pedidoParametroFactu=null;
	public Boolean mostrarcon_detalle_pedidoParametroFactu=true;
	public Boolean activarcon_detalle_pedidoParametroFactu=true;

	public Border resaltarcon_detalle_facturaParametroFactu=null;
	public Boolean mostrarcon_detalle_facturaParametroFactu=true;
	public Boolean activarcon_detalle_facturaParametroFactu=true;

	public Border resaltarcon_detalle_nota_creditoParametroFactu=null;
	public Boolean mostrarcon_detalle_nota_creditoParametroFactu=true;
	public Boolean activarcon_detalle_nota_creditoParametroFactu=true;

	
	

	public Border setResaltaridParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltaridParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroFactu() {
		return this.resaltaridParametroFactu;
	}

	public void setResaltaridParametroFactu(Border borderResaltar) {
		this.resaltaridParametroFactu= borderResaltar;
	}

	public Boolean getMostraridParametroFactu() {
		return this.mostraridParametroFactu;
	}

	public void setMostraridParametroFactu(Boolean mostraridParametroFactu) {
		this.mostraridParametroFactu= mostraridParametroFactu;
	}

	public Boolean getActivaridParametroFactu() {
		return this.activaridParametroFactu;
	}

	public void setActivaridParametroFactu(Boolean activaridParametroFactu) {
		this.activaridParametroFactu= activaridParametroFactu;
	}

	public Border setResaltarid_empresaParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroFactu() {
		return this.resaltarid_empresaParametroFactu;
	}

	public void setResaltarid_empresaParametroFactu(Border borderResaltar) {
		this.resaltarid_empresaParametroFactu= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroFactu() {
		return this.mostrarid_empresaParametroFactu;
	}

	public void setMostrarid_empresaParametroFactu(Boolean mostrarid_empresaParametroFactu) {
		this.mostrarid_empresaParametroFactu= mostrarid_empresaParametroFactu;
	}

	public Boolean getActivarid_empresaParametroFactu() {
		return this.activarid_empresaParametroFactu;
	}

	public void setActivarid_empresaParametroFactu(Boolean activarid_empresaParametroFactu) {
		this.activarid_empresaParametroFactu= activarid_empresaParametroFactu;
	}

	public Boolean getCargarid_empresaParametroFactu() {
		return this.cargarid_empresaParametroFactu;
	}

	public void setCargarid_empresaParametroFactu(Boolean cargarid_empresaParametroFactu) {
		this.cargarid_empresaParametroFactu= cargarid_empresaParametroFactu;
	}

	public Border setResaltarid_sucursalParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltarid_sucursalParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalParametroFactu() {
		return this.resaltarid_sucursalParametroFactu;
	}

	public void setResaltarid_sucursalParametroFactu(Border borderResaltar) {
		this.resaltarid_sucursalParametroFactu= borderResaltar;
	}

	public Boolean getMostrarid_sucursalParametroFactu() {
		return this.mostrarid_sucursalParametroFactu;
	}

	public void setMostrarid_sucursalParametroFactu(Boolean mostrarid_sucursalParametroFactu) {
		this.mostrarid_sucursalParametroFactu= mostrarid_sucursalParametroFactu;
	}

	public Boolean getActivarid_sucursalParametroFactu() {
		return this.activarid_sucursalParametroFactu;
	}

	public void setActivarid_sucursalParametroFactu(Boolean activarid_sucursalParametroFactu) {
		this.activarid_sucursalParametroFactu= activarid_sucursalParametroFactu;
	}

	public Boolean getCargarid_sucursalParametroFactu() {
		return this.cargarid_sucursalParametroFactu;
	}

	public void setCargarid_sucursalParametroFactu(Boolean cargarid_sucursalParametroFactu) {
		this.cargarid_sucursalParametroFactu= cargarid_sucursalParametroFactu;
	}

	public Border setResaltarid_cuenta_contable_factuParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_factuParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_factuParametroFactu() {
		return this.resaltarid_cuenta_contable_factuParametroFactu;
	}

	public void setResaltarid_cuenta_contable_factuParametroFactu(Border borderResaltar) {
		this.resaltarid_cuenta_contable_factuParametroFactu= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_factuParametroFactu() {
		return this.mostrarid_cuenta_contable_factuParametroFactu;
	}

	public void setMostrarid_cuenta_contable_factuParametroFactu(Boolean mostrarid_cuenta_contable_factuParametroFactu) {
		this.mostrarid_cuenta_contable_factuParametroFactu= mostrarid_cuenta_contable_factuParametroFactu;
	}

	public Boolean getActivarid_cuenta_contable_factuParametroFactu() {
		return this.activarid_cuenta_contable_factuParametroFactu;
	}

	public void setActivarid_cuenta_contable_factuParametroFactu(Boolean activarid_cuenta_contable_factuParametroFactu) {
		this.activarid_cuenta_contable_factuParametroFactu= activarid_cuenta_contable_factuParametroFactu;
	}

	public Boolean getCargarid_cuenta_contable_factuParametroFactu() {
		return this.cargarid_cuenta_contable_factuParametroFactu;
	}

	public void setCargarid_cuenta_contable_factuParametroFactu(Boolean cargarid_cuenta_contable_factuParametroFactu) {
		this.cargarid_cuenta_contable_factuParametroFactu= cargarid_cuenta_contable_factuParametroFactu;
	}

	public Border setResaltarid_cuenta_contable_finanParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_finanParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_finanParametroFactu() {
		return this.resaltarid_cuenta_contable_finanParametroFactu;
	}

	public void setResaltarid_cuenta_contable_finanParametroFactu(Border borderResaltar) {
		this.resaltarid_cuenta_contable_finanParametroFactu= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_finanParametroFactu() {
		return this.mostrarid_cuenta_contable_finanParametroFactu;
	}

	public void setMostrarid_cuenta_contable_finanParametroFactu(Boolean mostrarid_cuenta_contable_finanParametroFactu) {
		this.mostrarid_cuenta_contable_finanParametroFactu= mostrarid_cuenta_contable_finanParametroFactu;
	}

	public Boolean getActivarid_cuenta_contable_finanParametroFactu() {
		return this.activarid_cuenta_contable_finanParametroFactu;
	}

	public void setActivarid_cuenta_contable_finanParametroFactu(Boolean activarid_cuenta_contable_finanParametroFactu) {
		this.activarid_cuenta_contable_finanParametroFactu= activarid_cuenta_contable_finanParametroFactu;
	}

	public Boolean getCargarid_cuenta_contable_finanParametroFactu() {
		return this.cargarid_cuenta_contable_finanParametroFactu;
	}

	public void setCargarid_cuenta_contable_finanParametroFactu(Boolean cargarid_cuenta_contable_finanParametroFactu) {
		this.cargarid_cuenta_contable_finanParametroFactu= cargarid_cuenta_contable_finanParametroFactu;
	}

	public Border setResaltarid_cuenta_contable_otroParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_otroParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_otroParametroFactu() {
		return this.resaltarid_cuenta_contable_otroParametroFactu;
	}

	public void setResaltarid_cuenta_contable_otroParametroFactu(Border borderResaltar) {
		this.resaltarid_cuenta_contable_otroParametroFactu= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_otroParametroFactu() {
		return this.mostrarid_cuenta_contable_otroParametroFactu;
	}

	public void setMostrarid_cuenta_contable_otroParametroFactu(Boolean mostrarid_cuenta_contable_otroParametroFactu) {
		this.mostrarid_cuenta_contable_otroParametroFactu= mostrarid_cuenta_contable_otroParametroFactu;
	}

	public Boolean getActivarid_cuenta_contable_otroParametroFactu() {
		return this.activarid_cuenta_contable_otroParametroFactu;
	}

	public void setActivarid_cuenta_contable_otroParametroFactu(Boolean activarid_cuenta_contable_otroParametroFactu) {
		this.activarid_cuenta_contable_otroParametroFactu= activarid_cuenta_contable_otroParametroFactu;
	}

	public Boolean getCargarid_cuenta_contable_otroParametroFactu() {
		return this.cargarid_cuenta_contable_otroParametroFactu;
	}

	public void setCargarid_cuenta_contable_otroParametroFactu(Boolean cargarid_cuenta_contable_otroParametroFactu) {
		this.cargarid_cuenta_contable_otroParametroFactu= cargarid_cuenta_contable_otroParametroFactu;
	}

	public Border setResaltarid_formato_proformaParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltarid_formato_proformaParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_proformaParametroFactu() {
		return this.resaltarid_formato_proformaParametroFactu;
	}

	public void setResaltarid_formato_proformaParametroFactu(Border borderResaltar) {
		this.resaltarid_formato_proformaParametroFactu= borderResaltar;
	}

	public Boolean getMostrarid_formato_proformaParametroFactu() {
		return this.mostrarid_formato_proformaParametroFactu;
	}

	public void setMostrarid_formato_proformaParametroFactu(Boolean mostrarid_formato_proformaParametroFactu) {
		this.mostrarid_formato_proformaParametroFactu= mostrarid_formato_proformaParametroFactu;
	}

	public Boolean getActivarid_formato_proformaParametroFactu() {
		return this.activarid_formato_proformaParametroFactu;
	}

	public void setActivarid_formato_proformaParametroFactu(Boolean activarid_formato_proformaParametroFactu) {
		this.activarid_formato_proformaParametroFactu= activarid_formato_proformaParametroFactu;
	}

	public Boolean getCargarid_formato_proformaParametroFactu() {
		return this.cargarid_formato_proformaParametroFactu;
	}

	public void setCargarid_formato_proformaParametroFactu(Boolean cargarid_formato_proformaParametroFactu) {
		this.cargarid_formato_proformaParametroFactu= cargarid_formato_proformaParametroFactu;
	}

	public Border setResaltarid_formato_pedidoParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltarid_formato_pedidoParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_pedidoParametroFactu() {
		return this.resaltarid_formato_pedidoParametroFactu;
	}

	public void setResaltarid_formato_pedidoParametroFactu(Border borderResaltar) {
		this.resaltarid_formato_pedidoParametroFactu= borderResaltar;
	}

	public Boolean getMostrarid_formato_pedidoParametroFactu() {
		return this.mostrarid_formato_pedidoParametroFactu;
	}

	public void setMostrarid_formato_pedidoParametroFactu(Boolean mostrarid_formato_pedidoParametroFactu) {
		this.mostrarid_formato_pedidoParametroFactu= mostrarid_formato_pedidoParametroFactu;
	}

	public Boolean getActivarid_formato_pedidoParametroFactu() {
		return this.activarid_formato_pedidoParametroFactu;
	}

	public void setActivarid_formato_pedidoParametroFactu(Boolean activarid_formato_pedidoParametroFactu) {
		this.activarid_formato_pedidoParametroFactu= activarid_formato_pedidoParametroFactu;
	}

	public Boolean getCargarid_formato_pedidoParametroFactu() {
		return this.cargarid_formato_pedidoParametroFactu;
	}

	public void setCargarid_formato_pedidoParametroFactu(Boolean cargarid_formato_pedidoParametroFactu) {
		this.cargarid_formato_pedidoParametroFactu= cargarid_formato_pedidoParametroFactu;
	}

	public Border setResaltarid_formato_facturaParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltarid_formato_facturaParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_facturaParametroFactu() {
		return this.resaltarid_formato_facturaParametroFactu;
	}

	public void setResaltarid_formato_facturaParametroFactu(Border borderResaltar) {
		this.resaltarid_formato_facturaParametroFactu= borderResaltar;
	}

	public Boolean getMostrarid_formato_facturaParametroFactu() {
		return this.mostrarid_formato_facturaParametroFactu;
	}

	public void setMostrarid_formato_facturaParametroFactu(Boolean mostrarid_formato_facturaParametroFactu) {
		this.mostrarid_formato_facturaParametroFactu= mostrarid_formato_facturaParametroFactu;
	}

	public Boolean getActivarid_formato_facturaParametroFactu() {
		return this.activarid_formato_facturaParametroFactu;
	}

	public void setActivarid_formato_facturaParametroFactu(Boolean activarid_formato_facturaParametroFactu) {
		this.activarid_formato_facturaParametroFactu= activarid_formato_facturaParametroFactu;
	}

	public Boolean getCargarid_formato_facturaParametroFactu() {
		return this.cargarid_formato_facturaParametroFactu;
	}

	public void setCargarid_formato_facturaParametroFactu(Boolean cargarid_formato_facturaParametroFactu) {
		this.cargarid_formato_facturaParametroFactu= cargarid_formato_facturaParametroFactu;
	}

	public Border setResaltarid_formato_nota_creditoParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltarid_formato_nota_creditoParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_nota_creditoParametroFactu() {
		return this.resaltarid_formato_nota_creditoParametroFactu;
	}

	public void setResaltarid_formato_nota_creditoParametroFactu(Border borderResaltar) {
		this.resaltarid_formato_nota_creditoParametroFactu= borderResaltar;
	}

	public Boolean getMostrarid_formato_nota_creditoParametroFactu() {
		return this.mostrarid_formato_nota_creditoParametroFactu;
	}

	public void setMostrarid_formato_nota_creditoParametroFactu(Boolean mostrarid_formato_nota_creditoParametroFactu) {
		this.mostrarid_formato_nota_creditoParametroFactu= mostrarid_formato_nota_creditoParametroFactu;
	}

	public Boolean getActivarid_formato_nota_creditoParametroFactu() {
		return this.activarid_formato_nota_creditoParametroFactu;
	}

	public void setActivarid_formato_nota_creditoParametroFactu(Boolean activarid_formato_nota_creditoParametroFactu) {
		this.activarid_formato_nota_creditoParametroFactu= activarid_formato_nota_creditoParametroFactu;
	}

	public Boolean getCargarid_formato_nota_creditoParametroFactu() {
		return this.cargarid_formato_nota_creditoParametroFactu;
	}

	public void setCargarid_formato_nota_creditoParametroFactu(Boolean cargarid_formato_nota_creditoParametroFactu) {
		this.cargarid_formato_nota_creditoParametroFactu= cargarid_formato_nota_creditoParametroFactu;
	}

	public Border setResaltarid_formato_inventarioParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltarid_formato_inventarioParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_inventarioParametroFactu() {
		return this.resaltarid_formato_inventarioParametroFactu;
	}

	public void setResaltarid_formato_inventarioParametroFactu(Border borderResaltar) {
		this.resaltarid_formato_inventarioParametroFactu= borderResaltar;
	}

	public Boolean getMostrarid_formato_inventarioParametroFactu() {
		return this.mostrarid_formato_inventarioParametroFactu;
	}

	public void setMostrarid_formato_inventarioParametroFactu(Boolean mostrarid_formato_inventarioParametroFactu) {
		this.mostrarid_formato_inventarioParametroFactu= mostrarid_formato_inventarioParametroFactu;
	}

	public Boolean getActivarid_formato_inventarioParametroFactu() {
		return this.activarid_formato_inventarioParametroFactu;
	}

	public void setActivarid_formato_inventarioParametroFactu(Boolean activarid_formato_inventarioParametroFactu) {
		this.activarid_formato_inventarioParametroFactu= activarid_formato_inventarioParametroFactu;
	}

	public Boolean getCargarid_formato_inventarioParametroFactu() {
		return this.cargarid_formato_inventarioParametroFactu;
	}

	public void setCargarid_formato_inventarioParametroFactu(Boolean cargarid_formato_inventarioParametroFactu) {
		this.cargarid_formato_inventarioParametroFactu= cargarid_formato_inventarioParametroFactu;
	}

	public Border setResaltarsecuencial_proformaParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltarsecuencial_proformaParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencial_proformaParametroFactu() {
		return this.resaltarsecuencial_proformaParametroFactu;
	}

	public void setResaltarsecuencial_proformaParametroFactu(Border borderResaltar) {
		this.resaltarsecuencial_proformaParametroFactu= borderResaltar;
	}

	public Boolean getMostrarsecuencial_proformaParametroFactu() {
		return this.mostrarsecuencial_proformaParametroFactu;
	}

	public void setMostrarsecuencial_proformaParametroFactu(Boolean mostrarsecuencial_proformaParametroFactu) {
		this.mostrarsecuencial_proformaParametroFactu= mostrarsecuencial_proformaParametroFactu;
	}

	public Boolean getActivarsecuencial_proformaParametroFactu() {
		return this.activarsecuencial_proformaParametroFactu;
	}

	public void setActivarsecuencial_proformaParametroFactu(Boolean activarsecuencial_proformaParametroFactu) {
		this.activarsecuencial_proformaParametroFactu= activarsecuencial_proformaParametroFactu;
	}

	public Border setResaltarsecuancial_pedidoParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltarsecuancial_pedidoParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuancial_pedidoParametroFactu() {
		return this.resaltarsecuancial_pedidoParametroFactu;
	}

	public void setResaltarsecuancial_pedidoParametroFactu(Border borderResaltar) {
		this.resaltarsecuancial_pedidoParametroFactu= borderResaltar;
	}

	public Boolean getMostrarsecuancial_pedidoParametroFactu() {
		return this.mostrarsecuancial_pedidoParametroFactu;
	}

	public void setMostrarsecuancial_pedidoParametroFactu(Boolean mostrarsecuancial_pedidoParametroFactu) {
		this.mostrarsecuancial_pedidoParametroFactu= mostrarsecuancial_pedidoParametroFactu;
	}

	public Boolean getActivarsecuancial_pedidoParametroFactu() {
		return this.activarsecuancial_pedidoParametroFactu;
	}

	public void setActivarsecuancial_pedidoParametroFactu(Boolean activarsecuancial_pedidoParametroFactu) {
		this.activarsecuancial_pedidoParametroFactu= activarsecuancial_pedidoParametroFactu;
	}

	public Border setResaltarsecuencial_facturaParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltarsecuencial_facturaParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencial_facturaParametroFactu() {
		return this.resaltarsecuencial_facturaParametroFactu;
	}

	public void setResaltarsecuencial_facturaParametroFactu(Border borderResaltar) {
		this.resaltarsecuencial_facturaParametroFactu= borderResaltar;
	}

	public Boolean getMostrarsecuencial_facturaParametroFactu() {
		return this.mostrarsecuencial_facturaParametroFactu;
	}

	public void setMostrarsecuencial_facturaParametroFactu(Boolean mostrarsecuencial_facturaParametroFactu) {
		this.mostrarsecuencial_facturaParametroFactu= mostrarsecuencial_facturaParametroFactu;
	}

	public Boolean getActivarsecuencial_facturaParametroFactu() {
		return this.activarsecuencial_facturaParametroFactu;
	}

	public void setActivarsecuencial_facturaParametroFactu(Boolean activarsecuencial_facturaParametroFactu) {
		this.activarsecuencial_facturaParametroFactu= activarsecuencial_facturaParametroFactu;
	}

	public Border setResaltarsecuencial_nota_creditoParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltarsecuencial_nota_creditoParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencial_nota_creditoParametroFactu() {
		return this.resaltarsecuencial_nota_creditoParametroFactu;
	}

	public void setResaltarsecuencial_nota_creditoParametroFactu(Border borderResaltar) {
		this.resaltarsecuencial_nota_creditoParametroFactu= borderResaltar;
	}

	public Boolean getMostrarsecuencial_nota_creditoParametroFactu() {
		return this.mostrarsecuencial_nota_creditoParametroFactu;
	}

	public void setMostrarsecuencial_nota_creditoParametroFactu(Boolean mostrarsecuencial_nota_creditoParametroFactu) {
		this.mostrarsecuencial_nota_creditoParametroFactu= mostrarsecuencial_nota_creditoParametroFactu;
	}

	public Boolean getActivarsecuencial_nota_creditoParametroFactu() {
		return this.activarsecuencial_nota_creditoParametroFactu;
	}

	public void setActivarsecuencial_nota_creditoParametroFactu(Boolean activarsecuencial_nota_creditoParametroFactu) {
		this.activarsecuencial_nota_creditoParametroFactu= activarsecuencial_nota_creditoParametroFactu;
	}

	public Border setResaltaritem_proformaParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltaritem_proformaParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaritem_proformaParametroFactu() {
		return this.resaltaritem_proformaParametroFactu;
	}

	public void setResaltaritem_proformaParametroFactu(Border borderResaltar) {
		this.resaltaritem_proformaParametroFactu= borderResaltar;
	}

	public Boolean getMostraritem_proformaParametroFactu() {
		return this.mostraritem_proformaParametroFactu;
	}

	public void setMostraritem_proformaParametroFactu(Boolean mostraritem_proformaParametroFactu) {
		this.mostraritem_proformaParametroFactu= mostraritem_proformaParametroFactu;
	}

	public Boolean getActivaritem_proformaParametroFactu() {
		return this.activaritem_proformaParametroFactu;
	}

	public void setActivaritem_proformaParametroFactu(Boolean activaritem_proformaParametroFactu) {
		this.activaritem_proformaParametroFactu= activaritem_proformaParametroFactu;
	}

	public Border setResaltaritem_pedidoParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltaritem_pedidoParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaritem_pedidoParametroFactu() {
		return this.resaltaritem_pedidoParametroFactu;
	}

	public void setResaltaritem_pedidoParametroFactu(Border borderResaltar) {
		this.resaltaritem_pedidoParametroFactu= borderResaltar;
	}

	public Boolean getMostraritem_pedidoParametroFactu() {
		return this.mostraritem_pedidoParametroFactu;
	}

	public void setMostraritem_pedidoParametroFactu(Boolean mostraritem_pedidoParametroFactu) {
		this.mostraritem_pedidoParametroFactu= mostraritem_pedidoParametroFactu;
	}

	public Boolean getActivaritem_pedidoParametroFactu() {
		return this.activaritem_pedidoParametroFactu;
	}

	public void setActivaritem_pedidoParametroFactu(Boolean activaritem_pedidoParametroFactu) {
		this.activaritem_pedidoParametroFactu= activaritem_pedidoParametroFactu;
	}

	public Border setResaltaritem_facturaParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltaritem_facturaParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaritem_facturaParametroFactu() {
		return this.resaltaritem_facturaParametroFactu;
	}

	public void setResaltaritem_facturaParametroFactu(Border borderResaltar) {
		this.resaltaritem_facturaParametroFactu= borderResaltar;
	}

	public Boolean getMostraritem_facturaParametroFactu() {
		return this.mostraritem_facturaParametroFactu;
	}

	public void setMostraritem_facturaParametroFactu(Boolean mostraritem_facturaParametroFactu) {
		this.mostraritem_facturaParametroFactu= mostraritem_facturaParametroFactu;
	}

	public Boolean getActivaritem_facturaParametroFactu() {
		return this.activaritem_facturaParametroFactu;
	}

	public void setActivaritem_facturaParametroFactu(Boolean activaritem_facturaParametroFactu) {
		this.activaritem_facturaParametroFactu= activaritem_facturaParametroFactu;
	}

	public Border setResaltaritem_nota_creditoParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltaritem_nota_creditoParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaritem_nota_creditoParametroFactu() {
		return this.resaltaritem_nota_creditoParametroFactu;
	}

	public void setResaltaritem_nota_creditoParametroFactu(Border borderResaltar) {
		this.resaltaritem_nota_creditoParametroFactu= borderResaltar;
	}

	public Boolean getMostraritem_nota_creditoParametroFactu() {
		return this.mostraritem_nota_creditoParametroFactu;
	}

	public void setMostraritem_nota_creditoParametroFactu(Boolean mostraritem_nota_creditoParametroFactu) {
		this.mostraritem_nota_creditoParametroFactu= mostraritem_nota_creditoParametroFactu;
	}

	public Boolean getActivaritem_nota_creditoParametroFactu() {
		return this.activaritem_nota_creditoParametroFactu;
	}

	public void setActivaritem_nota_creditoParametroFactu(Boolean activaritem_nota_creditoParametroFactu) {
		this.activaritem_nota_creditoParametroFactu= activaritem_nota_creditoParametroFactu;
	}

	public Border setResaltaritem_inventarioParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltaritem_inventarioParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaritem_inventarioParametroFactu() {
		return this.resaltaritem_inventarioParametroFactu;
	}

	public void setResaltaritem_inventarioParametroFactu(Border borderResaltar) {
		this.resaltaritem_inventarioParametroFactu= borderResaltar;
	}

	public Boolean getMostraritem_inventarioParametroFactu() {
		return this.mostraritem_inventarioParametroFactu;
	}

	public void setMostraritem_inventarioParametroFactu(Boolean mostraritem_inventarioParametroFactu) {
		this.mostraritem_inventarioParametroFactu= mostraritem_inventarioParametroFactu;
	}

	public Boolean getActivaritem_inventarioParametroFactu() {
		return this.activaritem_inventarioParametroFactu;
	}

	public void setActivaritem_inventarioParametroFactu(Boolean activaritem_inventarioParametroFactu) {
		this.activaritem_inventarioParametroFactu= activaritem_inventarioParametroFactu;
	}

	public Border setResaltarcon_detalle_proformaParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltarcon_detalle_proformaParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_detalle_proformaParametroFactu() {
		return this.resaltarcon_detalle_proformaParametroFactu;
	}

	public void setResaltarcon_detalle_proformaParametroFactu(Border borderResaltar) {
		this.resaltarcon_detalle_proformaParametroFactu= borderResaltar;
	}

	public Boolean getMostrarcon_detalle_proformaParametroFactu() {
		return this.mostrarcon_detalle_proformaParametroFactu;
	}

	public void setMostrarcon_detalle_proformaParametroFactu(Boolean mostrarcon_detalle_proformaParametroFactu) {
		this.mostrarcon_detalle_proformaParametroFactu= mostrarcon_detalle_proformaParametroFactu;
	}

	public Boolean getActivarcon_detalle_proformaParametroFactu() {
		return this.activarcon_detalle_proformaParametroFactu;
	}

	public void setActivarcon_detalle_proformaParametroFactu(Boolean activarcon_detalle_proformaParametroFactu) {
		this.activarcon_detalle_proformaParametroFactu= activarcon_detalle_proformaParametroFactu;
	}

	public Border setResaltarcon_detalle_pedidoParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltarcon_detalle_pedidoParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_detalle_pedidoParametroFactu() {
		return this.resaltarcon_detalle_pedidoParametroFactu;
	}

	public void setResaltarcon_detalle_pedidoParametroFactu(Border borderResaltar) {
		this.resaltarcon_detalle_pedidoParametroFactu= borderResaltar;
	}

	public Boolean getMostrarcon_detalle_pedidoParametroFactu() {
		return this.mostrarcon_detalle_pedidoParametroFactu;
	}

	public void setMostrarcon_detalle_pedidoParametroFactu(Boolean mostrarcon_detalle_pedidoParametroFactu) {
		this.mostrarcon_detalle_pedidoParametroFactu= mostrarcon_detalle_pedidoParametroFactu;
	}

	public Boolean getActivarcon_detalle_pedidoParametroFactu() {
		return this.activarcon_detalle_pedidoParametroFactu;
	}

	public void setActivarcon_detalle_pedidoParametroFactu(Boolean activarcon_detalle_pedidoParametroFactu) {
		this.activarcon_detalle_pedidoParametroFactu= activarcon_detalle_pedidoParametroFactu;
	}

	public Border setResaltarcon_detalle_facturaParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltarcon_detalle_facturaParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_detalle_facturaParametroFactu() {
		return this.resaltarcon_detalle_facturaParametroFactu;
	}

	public void setResaltarcon_detalle_facturaParametroFactu(Border borderResaltar) {
		this.resaltarcon_detalle_facturaParametroFactu= borderResaltar;
	}

	public Boolean getMostrarcon_detalle_facturaParametroFactu() {
		return this.mostrarcon_detalle_facturaParametroFactu;
	}

	public void setMostrarcon_detalle_facturaParametroFactu(Boolean mostrarcon_detalle_facturaParametroFactu) {
		this.mostrarcon_detalle_facturaParametroFactu= mostrarcon_detalle_facturaParametroFactu;
	}

	public Boolean getActivarcon_detalle_facturaParametroFactu() {
		return this.activarcon_detalle_facturaParametroFactu;
	}

	public void setActivarcon_detalle_facturaParametroFactu(Boolean activarcon_detalle_facturaParametroFactu) {
		this.activarcon_detalle_facturaParametroFactu= activarcon_detalle_facturaParametroFactu;
	}

	public Border setResaltarcon_detalle_nota_creditoParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuBeanSwingJInternalFrame.jTtoolBarParametroFactu.setBorder(borderResaltar);
		
		this.resaltarcon_detalle_nota_creditoParametroFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_detalle_nota_creditoParametroFactu() {
		return this.resaltarcon_detalle_nota_creditoParametroFactu;
	}

	public void setResaltarcon_detalle_nota_creditoParametroFactu(Border borderResaltar) {
		this.resaltarcon_detalle_nota_creditoParametroFactu= borderResaltar;
	}

	public Boolean getMostrarcon_detalle_nota_creditoParametroFactu() {
		return this.mostrarcon_detalle_nota_creditoParametroFactu;
	}

	public void setMostrarcon_detalle_nota_creditoParametroFactu(Boolean mostrarcon_detalle_nota_creditoParametroFactu) {
		this.mostrarcon_detalle_nota_creditoParametroFactu= mostrarcon_detalle_nota_creditoParametroFactu;
	}

	public Boolean getActivarcon_detalle_nota_creditoParametroFactu() {
		return this.activarcon_detalle_nota_creditoParametroFactu;
	}

	public void setActivarcon_detalle_nota_creditoParametroFactu(Boolean activarcon_detalle_nota_creditoParametroFactu) {
		this.activarcon_detalle_nota_creditoParametroFactu= activarcon_detalle_nota_creditoParametroFactu;
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
		
		
		this.setMostraridParametroFactu(esInicial);
		this.setMostrarid_empresaParametroFactu(esInicial);
		this.setMostrarid_sucursalParametroFactu(esInicial);
		this.setMostrarid_cuenta_contable_factuParametroFactu(esInicial);
		this.setMostrarid_cuenta_contable_finanParametroFactu(esInicial);
		this.setMostrarid_cuenta_contable_otroParametroFactu(esInicial);
		this.setMostrarid_formato_proformaParametroFactu(esInicial);
		this.setMostrarid_formato_pedidoParametroFactu(esInicial);
		this.setMostrarid_formato_facturaParametroFactu(esInicial);
		this.setMostrarid_formato_nota_creditoParametroFactu(esInicial);
		this.setMostrarid_formato_inventarioParametroFactu(esInicial);
		this.setMostrarsecuencial_proformaParametroFactu(esInicial);
		this.setMostrarsecuancial_pedidoParametroFactu(esInicial);
		this.setMostrarsecuencial_facturaParametroFactu(esInicial);
		this.setMostrarsecuencial_nota_creditoParametroFactu(esInicial);
		this.setMostraritem_proformaParametroFactu(esInicial);
		this.setMostraritem_pedidoParametroFactu(esInicial);
		this.setMostraritem_facturaParametroFactu(esInicial);
		this.setMostraritem_nota_creditoParametroFactu(esInicial);
		this.setMostraritem_inventarioParametroFactu(esInicial);
		this.setMostrarcon_detalle_proformaParametroFactu(esInicial);
		this.setMostrarcon_detalle_pedidoParametroFactu(esInicial);
		this.setMostrarcon_detalle_facturaParametroFactu(esInicial);
		this.setMostrarcon_detalle_nota_creditoParametroFactu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFactuConstantesFunciones.ID)) {
				this.setMostraridParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDCUENTACONTABLEFACTU)) {
				this.setMostrarid_cuenta_contable_factuParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDCUENTACONTABLEFINAN)) {
				this.setMostrarid_cuenta_contable_finanParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDCUENTACONTABLEOTRO)) {
				this.setMostrarid_cuenta_contable_otroParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDFORMATOPROFORMA)) {
				this.setMostrarid_formato_proformaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDFORMATOPEDIDO)) {
				this.setMostrarid_formato_pedidoParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDFORMATOFACTURA)) {
				this.setMostrarid_formato_facturaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDFORMATONOTACREDITO)) {
				this.setMostrarid_formato_nota_creditoParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDFORMATOINVENTARIO)) {
				this.setMostrarid_formato_inventarioParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.SECUENCIALPROFORMA)) {
				this.setMostrarsecuencial_proformaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.SECUANCIALPEDIDO)) {
				this.setMostrarsecuancial_pedidoParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.SECUENCIALFACTURA)) {
				this.setMostrarsecuencial_facturaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.SECUENCIALNOTACREDITO)) {
				this.setMostrarsecuencial_nota_creditoParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.ITEMPROFORMA)) {
				this.setMostraritem_proformaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.ITEMPEDIDO)) {
				this.setMostraritem_pedidoParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.ITEMFACTURA)) {
				this.setMostraritem_facturaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.ITEMNOTACREDITO)) {
				this.setMostraritem_nota_creditoParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.ITEMINVENTARIO)) {
				this.setMostraritem_inventarioParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.CONDETALLEPROFORMA)) {
				this.setMostrarcon_detalle_proformaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.CONDETALLEPEDIDO)) {
				this.setMostrarcon_detalle_pedidoParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.CONDETALLEFACTURA)) {
				this.setMostrarcon_detalle_facturaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.CONDETALLENOTACREDITO)) {
				this.setMostrarcon_detalle_nota_creditoParametroFactu(esAsigna);
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
		
		
		this.setActivaridParametroFactu(esInicial);
		this.setActivarid_empresaParametroFactu(esInicial);
		this.setActivarid_sucursalParametroFactu(esInicial);
		this.setActivarid_cuenta_contable_factuParametroFactu(esInicial);
		this.setActivarid_cuenta_contable_finanParametroFactu(esInicial);
		this.setActivarid_cuenta_contable_otroParametroFactu(esInicial);
		this.setActivarid_formato_proformaParametroFactu(esInicial);
		this.setActivarid_formato_pedidoParametroFactu(esInicial);
		this.setActivarid_formato_facturaParametroFactu(esInicial);
		this.setActivarid_formato_nota_creditoParametroFactu(esInicial);
		this.setActivarid_formato_inventarioParametroFactu(esInicial);
		this.setActivarsecuencial_proformaParametroFactu(esInicial);
		this.setActivarsecuancial_pedidoParametroFactu(esInicial);
		this.setActivarsecuencial_facturaParametroFactu(esInicial);
		this.setActivarsecuencial_nota_creditoParametroFactu(esInicial);
		this.setActivaritem_proformaParametroFactu(esInicial);
		this.setActivaritem_pedidoParametroFactu(esInicial);
		this.setActivaritem_facturaParametroFactu(esInicial);
		this.setActivaritem_nota_creditoParametroFactu(esInicial);
		this.setActivaritem_inventarioParametroFactu(esInicial);
		this.setActivarcon_detalle_proformaParametroFactu(esInicial);
		this.setActivarcon_detalle_pedidoParametroFactu(esInicial);
		this.setActivarcon_detalle_facturaParametroFactu(esInicial);
		this.setActivarcon_detalle_nota_creditoParametroFactu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFactuConstantesFunciones.ID)) {
				this.setActivaridParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDCUENTACONTABLEFACTU)) {
				this.setActivarid_cuenta_contable_factuParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDCUENTACONTABLEFINAN)) {
				this.setActivarid_cuenta_contable_finanParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDCUENTACONTABLEOTRO)) {
				this.setActivarid_cuenta_contable_otroParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDFORMATOPROFORMA)) {
				this.setActivarid_formato_proformaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDFORMATOPEDIDO)) {
				this.setActivarid_formato_pedidoParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDFORMATOFACTURA)) {
				this.setActivarid_formato_facturaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDFORMATONOTACREDITO)) {
				this.setActivarid_formato_nota_creditoParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDFORMATOINVENTARIO)) {
				this.setActivarid_formato_inventarioParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.SECUENCIALPROFORMA)) {
				this.setActivarsecuencial_proformaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.SECUANCIALPEDIDO)) {
				this.setActivarsecuancial_pedidoParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.SECUENCIALFACTURA)) {
				this.setActivarsecuencial_facturaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.SECUENCIALNOTACREDITO)) {
				this.setActivarsecuencial_nota_creditoParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.ITEMPROFORMA)) {
				this.setActivaritem_proformaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.ITEMPEDIDO)) {
				this.setActivaritem_pedidoParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.ITEMFACTURA)) {
				this.setActivaritem_facturaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.ITEMNOTACREDITO)) {
				this.setActivaritem_nota_creditoParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.ITEMINVENTARIO)) {
				this.setActivaritem_inventarioParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.CONDETALLEPROFORMA)) {
				this.setActivarcon_detalle_proformaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.CONDETALLEPEDIDO)) {
				this.setActivarcon_detalle_pedidoParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.CONDETALLEFACTURA)) {
				this.setActivarcon_detalle_facturaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.CONDETALLENOTACREDITO)) {
				this.setActivarcon_detalle_nota_creditoParametroFactu(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroFactu(esInicial);
		this.setResaltarid_empresaParametroFactu(esInicial);
		this.setResaltarid_sucursalParametroFactu(esInicial);
		this.setResaltarid_cuenta_contable_factuParametroFactu(esInicial);
		this.setResaltarid_cuenta_contable_finanParametroFactu(esInicial);
		this.setResaltarid_cuenta_contable_otroParametroFactu(esInicial);
		this.setResaltarid_formato_proformaParametroFactu(esInicial);
		this.setResaltarid_formato_pedidoParametroFactu(esInicial);
		this.setResaltarid_formato_facturaParametroFactu(esInicial);
		this.setResaltarid_formato_nota_creditoParametroFactu(esInicial);
		this.setResaltarid_formato_inventarioParametroFactu(esInicial);
		this.setResaltarsecuencial_proformaParametroFactu(esInicial);
		this.setResaltarsecuancial_pedidoParametroFactu(esInicial);
		this.setResaltarsecuencial_facturaParametroFactu(esInicial);
		this.setResaltarsecuencial_nota_creditoParametroFactu(esInicial);
		this.setResaltaritem_proformaParametroFactu(esInicial);
		this.setResaltaritem_pedidoParametroFactu(esInicial);
		this.setResaltaritem_facturaParametroFactu(esInicial);
		this.setResaltaritem_nota_creditoParametroFactu(esInicial);
		this.setResaltaritem_inventarioParametroFactu(esInicial);
		this.setResaltarcon_detalle_proformaParametroFactu(esInicial);
		this.setResaltarcon_detalle_pedidoParametroFactu(esInicial);
		this.setResaltarcon_detalle_facturaParametroFactu(esInicial);
		this.setResaltarcon_detalle_nota_creditoParametroFactu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFactuConstantesFunciones.ID)) {
				this.setResaltaridParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDCUENTACONTABLEFACTU)) {
				this.setResaltarid_cuenta_contable_factuParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDCUENTACONTABLEFINAN)) {
				this.setResaltarid_cuenta_contable_finanParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDCUENTACONTABLEOTRO)) {
				this.setResaltarid_cuenta_contable_otroParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDFORMATOPROFORMA)) {
				this.setResaltarid_formato_proformaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDFORMATOPEDIDO)) {
				this.setResaltarid_formato_pedidoParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDFORMATOFACTURA)) {
				this.setResaltarid_formato_facturaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDFORMATONOTACREDITO)) {
				this.setResaltarid_formato_nota_creditoParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.IDFORMATOINVENTARIO)) {
				this.setResaltarid_formato_inventarioParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.SECUENCIALPROFORMA)) {
				this.setResaltarsecuencial_proformaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.SECUANCIALPEDIDO)) {
				this.setResaltarsecuancial_pedidoParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.SECUENCIALFACTURA)) {
				this.setResaltarsecuencial_facturaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.SECUENCIALNOTACREDITO)) {
				this.setResaltarsecuencial_nota_creditoParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.ITEMPROFORMA)) {
				this.setResaltaritem_proformaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.ITEMPEDIDO)) {
				this.setResaltaritem_pedidoParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.ITEMFACTURA)) {
				this.setResaltaritem_facturaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.ITEMNOTACREDITO)) {
				this.setResaltaritem_nota_creditoParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.ITEMINVENTARIO)) {
				this.setResaltaritem_inventarioParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.CONDETALLEPROFORMA)) {
				this.setResaltarcon_detalle_proformaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.CONDETALLEPEDIDO)) {
				this.setResaltarcon_detalle_pedidoParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.CONDETALLEFACTURA)) {
				this.setResaltarcon_detalle_facturaParametroFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuConstantesFunciones.CONDETALLENOTACREDITO)) {
				this.setResaltarcon_detalle_nota_creditoParametroFactu(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCuentaContableFactuParametroFactu=true;

	public Boolean getMostrarFK_IdCuentaContableFactuParametroFactu() {
		return this.mostrarFK_IdCuentaContableFactuParametroFactu;
	}

	public void setMostrarFK_IdCuentaContableFactuParametroFactu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableFactuParametroFactu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableFinanParametroFactu=true;

	public Boolean getMostrarFK_IdCuentaContableFinanParametroFactu() {
		return this.mostrarFK_IdCuentaContableFinanParametroFactu;
	}

	public void setMostrarFK_IdCuentaContableFinanParametroFactu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableFinanParametroFactu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableOtroParametroFactu=true;

	public Boolean getMostrarFK_IdCuentaContableOtroParametroFactu() {
		return this.mostrarFK_IdCuentaContableOtroParametroFactu;
	}

	public void setMostrarFK_IdCuentaContableOtroParametroFactu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableOtroParametroFactu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaParametroFactu=true;

	public Boolean getMostrarFK_IdEmpresaParametroFactu() {
		return this.mostrarFK_IdEmpresaParametroFactu;
	}

	public void setMostrarFK_IdEmpresaParametroFactu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroFactu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoFacturaParametroFactu=true;

	public Boolean getMostrarFK_IdFormatoFacturaParametroFactu() {
		return this.mostrarFK_IdFormatoFacturaParametroFactu;
	}

	public void setMostrarFK_IdFormatoFacturaParametroFactu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoFacturaParametroFactu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoInventarioParametroFactu=true;

	public Boolean getMostrarFK_IdFormatoInventarioParametroFactu() {
		return this.mostrarFK_IdFormatoInventarioParametroFactu;
	}

	public void setMostrarFK_IdFormatoInventarioParametroFactu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoInventarioParametroFactu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoNotaCreditoParametroFactu=true;

	public Boolean getMostrarFK_IdFormatoNotaCreditoParametroFactu() {
		return this.mostrarFK_IdFormatoNotaCreditoParametroFactu;
	}

	public void setMostrarFK_IdFormatoNotaCreditoParametroFactu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoNotaCreditoParametroFactu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoPedoParametroFactu=true;

	public Boolean getMostrarFK_IdFormatoPedoParametroFactu() {
		return this.mostrarFK_IdFormatoPedoParametroFactu;
	}

	public void setMostrarFK_IdFormatoPedoParametroFactu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoPedoParametroFactu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoProformaParametroFactu=true;

	public Boolean getMostrarFK_IdFormatoProformaParametroFactu() {
		return this.mostrarFK_IdFormatoProformaParametroFactu;
	}

	public void setMostrarFK_IdFormatoProformaParametroFactu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoProformaParametroFactu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalParametroFactu=true;

	public Boolean getMostrarFK_IdSucursalParametroFactu() {
		return this.mostrarFK_IdSucursalParametroFactu;
	}

	public void setMostrarFK_IdSucursalParametroFactu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalParametroFactu= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContableFactuParametroFactu=true;

	public Boolean getActivarFK_IdCuentaContableFactuParametroFactu() {
		return this.activarFK_IdCuentaContableFactuParametroFactu;
	}

	public void setActivarFK_IdCuentaContableFactuParametroFactu(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableFactuParametroFactu= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableFinanParametroFactu=true;

	public Boolean getActivarFK_IdCuentaContableFinanParametroFactu() {
		return this.activarFK_IdCuentaContableFinanParametroFactu;
	}

	public void setActivarFK_IdCuentaContableFinanParametroFactu(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableFinanParametroFactu= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableOtroParametroFactu=true;

	public Boolean getActivarFK_IdCuentaContableOtroParametroFactu() {
		return this.activarFK_IdCuentaContableOtroParametroFactu;
	}

	public void setActivarFK_IdCuentaContableOtroParametroFactu(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableOtroParametroFactu= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaParametroFactu=true;

	public Boolean getActivarFK_IdEmpresaParametroFactu() {
		return this.activarFK_IdEmpresaParametroFactu;
	}

	public void setActivarFK_IdEmpresaParametroFactu(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroFactu= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoFacturaParametroFactu=true;

	public Boolean getActivarFK_IdFormatoFacturaParametroFactu() {
		return this.activarFK_IdFormatoFacturaParametroFactu;
	}

	public void setActivarFK_IdFormatoFacturaParametroFactu(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoFacturaParametroFactu= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoInventarioParametroFactu=true;

	public Boolean getActivarFK_IdFormatoInventarioParametroFactu() {
		return this.activarFK_IdFormatoInventarioParametroFactu;
	}

	public void setActivarFK_IdFormatoInventarioParametroFactu(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoInventarioParametroFactu= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoNotaCreditoParametroFactu=true;

	public Boolean getActivarFK_IdFormatoNotaCreditoParametroFactu() {
		return this.activarFK_IdFormatoNotaCreditoParametroFactu;
	}

	public void setActivarFK_IdFormatoNotaCreditoParametroFactu(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoNotaCreditoParametroFactu= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoPedoParametroFactu=true;

	public Boolean getActivarFK_IdFormatoPedoParametroFactu() {
		return this.activarFK_IdFormatoPedoParametroFactu;
	}

	public void setActivarFK_IdFormatoPedoParametroFactu(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoPedoParametroFactu= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoProformaParametroFactu=true;

	public Boolean getActivarFK_IdFormatoProformaParametroFactu() {
		return this.activarFK_IdFormatoProformaParametroFactu;
	}

	public void setActivarFK_IdFormatoProformaParametroFactu(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoProformaParametroFactu= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalParametroFactu=true;

	public Boolean getActivarFK_IdSucursalParametroFactu() {
		return this.activarFK_IdSucursalParametroFactu;
	}

	public void setActivarFK_IdSucursalParametroFactu(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalParametroFactu= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContableFactuParametroFactu=null;

	public Border getResaltarFK_IdCuentaContableFactuParametroFactu() {
		return this.resaltarFK_IdCuentaContableFactuParametroFactu;
	}

	public void setResaltarFK_IdCuentaContableFactuParametroFactu(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableFactuParametroFactu= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableFactuParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableFactuParametroFactu= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableFinanParametroFactu=null;

	public Border getResaltarFK_IdCuentaContableFinanParametroFactu() {
		return this.resaltarFK_IdCuentaContableFinanParametroFactu;
	}

	public void setResaltarFK_IdCuentaContableFinanParametroFactu(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableFinanParametroFactu= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableFinanParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableFinanParametroFactu= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableOtroParametroFactu=null;

	public Border getResaltarFK_IdCuentaContableOtroParametroFactu() {
		return this.resaltarFK_IdCuentaContableOtroParametroFactu;
	}

	public void setResaltarFK_IdCuentaContableOtroParametroFactu(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableOtroParametroFactu= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableOtroParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableOtroParametroFactu= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaParametroFactu=null;

	public Border getResaltarFK_IdEmpresaParametroFactu() {
		return this.resaltarFK_IdEmpresaParametroFactu;
	}

	public void setResaltarFK_IdEmpresaParametroFactu(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroFactu= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroFactu= borderResaltar;
	}

	public Border resaltarFK_IdFormatoFacturaParametroFactu=null;

	public Border getResaltarFK_IdFormatoFacturaParametroFactu() {
		return this.resaltarFK_IdFormatoFacturaParametroFactu;
	}

	public void setResaltarFK_IdFormatoFacturaParametroFactu(Border borderResaltar) {
		this.resaltarFK_IdFormatoFacturaParametroFactu= borderResaltar;
	}

	public void setResaltarFK_IdFormatoFacturaParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoFacturaParametroFactu= borderResaltar;
	}

	public Border resaltarFK_IdFormatoInventarioParametroFactu=null;

	public Border getResaltarFK_IdFormatoInventarioParametroFactu() {
		return this.resaltarFK_IdFormatoInventarioParametroFactu;
	}

	public void setResaltarFK_IdFormatoInventarioParametroFactu(Border borderResaltar) {
		this.resaltarFK_IdFormatoInventarioParametroFactu= borderResaltar;
	}

	public void setResaltarFK_IdFormatoInventarioParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoInventarioParametroFactu= borderResaltar;
	}

	public Border resaltarFK_IdFormatoNotaCreditoParametroFactu=null;

	public Border getResaltarFK_IdFormatoNotaCreditoParametroFactu() {
		return this.resaltarFK_IdFormatoNotaCreditoParametroFactu;
	}

	public void setResaltarFK_IdFormatoNotaCreditoParametroFactu(Border borderResaltar) {
		this.resaltarFK_IdFormatoNotaCreditoParametroFactu= borderResaltar;
	}

	public void setResaltarFK_IdFormatoNotaCreditoParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoNotaCreditoParametroFactu= borderResaltar;
	}

	public Border resaltarFK_IdFormatoPedoParametroFactu=null;

	public Border getResaltarFK_IdFormatoPedoParametroFactu() {
		return this.resaltarFK_IdFormatoPedoParametroFactu;
	}

	public void setResaltarFK_IdFormatoPedoParametroFactu(Border borderResaltar) {
		this.resaltarFK_IdFormatoPedoParametroFactu= borderResaltar;
	}

	public void setResaltarFK_IdFormatoPedoParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoPedoParametroFactu= borderResaltar;
	}

	public Border resaltarFK_IdFormatoProformaParametroFactu=null;

	public Border getResaltarFK_IdFormatoProformaParametroFactu() {
		return this.resaltarFK_IdFormatoProformaParametroFactu;
	}

	public void setResaltarFK_IdFormatoProformaParametroFactu(Border borderResaltar) {
		this.resaltarFK_IdFormatoProformaParametroFactu= borderResaltar;
	}

	public void setResaltarFK_IdFormatoProformaParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoProformaParametroFactu= borderResaltar;
	}

	public Border resaltarFK_IdSucursalParametroFactu=null;

	public Border getResaltarFK_IdSucursalParametroFactu() {
		return this.resaltarFK_IdSucursalParametroFactu;
	}

	public void setResaltarFK_IdSucursalParametroFactu(Border borderResaltar) {
		this.resaltarFK_IdSucursalParametroFactu= borderResaltar;
	}

	public void setResaltarFK_IdSucursalParametroFactu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuBeanSwingJInternalFrame parametrofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalParametroFactu= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}