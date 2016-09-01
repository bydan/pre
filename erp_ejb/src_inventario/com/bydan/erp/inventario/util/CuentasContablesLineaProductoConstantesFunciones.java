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


import com.bydan.erp.inventario.util.CuentasContablesLineaProductoConstantesFunciones;
import com.bydan.erp.inventario.util.CuentasContablesLineaProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.CuentasContablesLineaProductoParameterGeneral;

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
final public class CuentasContablesLineaProductoConstantesFunciones extends CuentasContablesLineaProductoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CuentasContablesLineaProducto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CuentasContablesLineaProducto"+CuentasContablesLineaProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CuentasContablesLineaProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CuentasContablesLineaProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"_"+CuentasContablesLineaProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CuentasContablesLineaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"_"+CuentasContablesLineaProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"_"+CuentasContablesLineaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CuentasContablesLineaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"_"+CuentasContablesLineaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentasContablesLineaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CuentasContablesLineaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentasContablesLineaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentasContablesLineaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CuentasContablesLineaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentasContablesLineaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CuentasContablesLineaProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CuentasContablesLineaProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CuentasContablesLineaProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CuentasContablesLineaProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cuentas Contables Linea Productoes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cuentas Contables Linea Producto";
	public static final String SCLASSWEBTITULO_LOWER="Cuentas Contables Linea Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CuentasContablesLineaProducto";
	public static final String OBJECTNAME="cuentascontableslineaproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="cuentas_contables_linea_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cuentascontableslineaproducto from "+CuentasContablesLineaProductoConstantesFunciones.SPERSISTENCENAME+" cuentascontableslineaproducto";
	public static String QUERYSELECTNATIVE="select "+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".version_row,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_empresa,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_bodega,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_centro_costo,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_linea,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_linea_grupo,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_linea_categoria,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_inventario,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_costo_venta,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_venta,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_descuento,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_produccion,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_devolucion,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_iva_debito,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_iva_credito,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_bonifica,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_costo_bonifica from "+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME;//+" as "+CuentasContablesLineaProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CuentasContablesLineaProductoConstantesFuncionesAdditional cuentascontableslineaproductoConstantesFuncionesAdditional=null;
	
	public CuentasContablesLineaProductoConstantesFuncionesAdditional getCuentasContablesLineaProductoConstantesFuncionesAdditional() {
		return this.cuentascontableslineaproductoConstantesFuncionesAdditional;
	}
	
	public void setCuentasContablesLineaProductoConstantesFuncionesAdditional(CuentasContablesLineaProductoConstantesFuncionesAdditional cuentascontableslineaproductoConstantesFuncionesAdditional) {
		try {
			this.cuentascontableslineaproductoConstantesFuncionesAdditional=cuentascontableslineaproductoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDCUENTACONTABLEINVENTARIO= "id_cuenta_contable_inventario";
    public static final String IDCUENTACONTABLECOSTOVENTA= "id_cuenta_contable_costo_venta";
    public static final String IDCUENTACONTABLEVENTA= "id_cuenta_contable_venta";
    public static final String IDCUENTACONTABLEDESCUENTO= "id_cuenta_contable_descuento";
    public static final String IDCUENTACONTABLEPRODUCCION= "id_cuenta_contable_produccion";
    public static final String IDCUENTACONTABLEDEVOLUCION= "id_cuenta_contable_devolucion";
    public static final String IDCUENTACONTABLEIVADEBITO= "id_cuenta_contable_iva_debito";
    public static final String IDCUENTACONTABLEIVACREDITO= "id_cuenta_contable_iva_credito";
    public static final String IDCUENTACONTABLEBONIFICA= "id_cuenta_contable_bonifica";
    public static final String IDCUENTACONTABLECOSTOBONIFICA= "id_cuenta_contable_costo_bonifica";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDLINEAGRUPO= "Linea Grupo";
		public static final String LABEL_IDLINEAGRUPO_LOWER= "Linea Grupo";
    	public static final String LABEL_IDLINEACATEGORIA= "Linea Categoria";
		public static final String LABEL_IDLINEACATEGORIA_LOWER= "Linea Categoria";
    	public static final String LABEL_IDCUENTACONTABLEINVENTARIO= "Cuenta C. Inventario";
		public static final String LABEL_IDCUENTACONTABLEINVENTARIO_LOWER= "Cuenta Contable Inventario";
    	public static final String LABEL_IDCUENTACONTABLECOSTOVENTA= "Cuenta C. Costo Venta";
		public static final String LABEL_IDCUENTACONTABLECOSTOVENTA_LOWER= "Cuenta Contable Costo Venta";
    	public static final String LABEL_IDCUENTACONTABLEVENTA= "Cuenta C. Venta";
		public static final String LABEL_IDCUENTACONTABLEVENTA_LOWER= "Cuenta Contable Venta";
    	public static final String LABEL_IDCUENTACONTABLEDESCUENTO= "Cuenta C. Descuento";
		public static final String LABEL_IDCUENTACONTABLEDESCUENTO_LOWER= "Cuenta Contable Descuento";
    	public static final String LABEL_IDCUENTACONTABLEPRODUCCION= "Cuenta C. Produccion";
		public static final String LABEL_IDCUENTACONTABLEPRODUCCION_LOWER= "Cuenta Contable Produccion";
    	public static final String LABEL_IDCUENTACONTABLEDEVOLUCION= "Cuenta C. Devolucion";
		public static final String LABEL_IDCUENTACONTABLEDEVOLUCION_LOWER= "Cuenta Contable Devolucion";
    	public static final String LABEL_IDCUENTACONTABLEIVADEBITO= "Cuenta C. Iva Debito";
		public static final String LABEL_IDCUENTACONTABLEIVADEBITO_LOWER= "Cuenta Contable Iva Debito";
    	public static final String LABEL_IDCUENTACONTABLEIVACREDITO= "Cuenta C. Iva Credito";
		public static final String LABEL_IDCUENTACONTABLEIVACREDITO_LOWER= "Cuenta Contable Iva Credito";
    	public static final String LABEL_IDCUENTACONTABLEBONIFICA= "Cuenta C. Bonifica";
		public static final String LABEL_IDCUENTACONTABLEBONIFICA_LOWER= "Cuenta Contable Bonifica";
    	public static final String LABEL_IDCUENTACONTABLECOSTOBONIFICA= "Cuenta C. Costo Bonifica";
		public static final String LABEL_IDCUENTACONTABLECOSTOBONIFICA_LOWER= "Cuenta Contable Costo Bonifica";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getCuentasContablesLineaProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CuentasContablesLineaProductoConstantesFunciones.IDEMPRESA)) {sLabelColumna=CuentasContablesLineaProductoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CuentasContablesLineaProductoConstantesFunciones.IDBODEGA)) {sLabelColumna=CuentasContablesLineaProductoConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(CuentasContablesLineaProductoConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(CuentasContablesLineaProductoConstantesFunciones.IDLINEA)) {sLabelColumna=CuentasContablesLineaProductoConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(CuentasContablesLineaProductoConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=CuentasContablesLineaProductoConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(CuentasContablesLineaProductoConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=CuentasContablesLineaProductoConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {sLabelColumna=CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO;}
		if(sNombreColumna.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA)) {sLabelColumna=CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOVENTA;}
		if(sNombreColumna.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEVENTA)) {sLabelColumna=CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA;}
		if(sNombreColumna.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {sLabelColumna=CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO;}
		if(sNombreColumna.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION)) {sLabelColumna=CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEPRODUCCION;}
		if(sNombreColumna.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {sLabelColumna=CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION;}
		if(sNombreColumna.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVADEBITO)) {sLabelColumna=CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEIVADEBITO;}
		if(sNombreColumna.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVACREDITO)) {sLabelColumna=CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEIVACREDITO;}
		if(sNombreColumna.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEBONIFICA)) {sLabelColumna=CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEBONIFICA;}
		if(sNombreColumna.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA)) {sLabelColumna=CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOBONIFICA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCuentasContablesLineaProductoDescripcion(CuentasContablesLineaProducto cuentascontableslineaproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cuentascontableslineaproducto !=null/* && cuentascontableslineaproducto.getId()!=0*/) {
			if(cuentascontableslineaproducto.getId()!=null) {
				sDescripcion=cuentascontableslineaproducto.getId().toString();
			}//cuentascontableslineaproductocuentascontableslineaproducto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCuentasContablesLineaProductoDescripcionDetallado(CuentasContablesLineaProducto cuentascontableslineaproducto) {
		String sDescripcion="";
			
		sDescripcion+=CuentasContablesLineaProductoConstantesFunciones.ID+"=";
		sDescripcion+=cuentascontableslineaproducto.getId().toString()+",";
		sDescripcion+=CuentasContablesLineaProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cuentascontableslineaproducto.getVersionRow().toString()+",";
		sDescripcion+=CuentasContablesLineaProductoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cuentascontableslineaproducto.getid_empresa().toString()+",";
		sDescripcion+=CuentasContablesLineaProductoConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=cuentascontableslineaproducto.getid_bodega().toString()+",";
		sDescripcion+=CuentasContablesLineaProductoConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=cuentascontableslineaproducto.getid_centro_costo().toString()+",";
		sDescripcion+=CuentasContablesLineaProductoConstantesFunciones.IDLINEA+"=";
		sDescripcion+=cuentascontableslineaproducto.getid_linea().toString()+",";
		sDescripcion+=CuentasContablesLineaProductoConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=cuentascontableslineaproducto.getid_linea_grupo().toString()+",";
		sDescripcion+=CuentasContablesLineaProductoConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=cuentascontableslineaproducto.getid_linea_categoria().toString()+",";
		sDescripcion+=CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO+"=";
		sDescripcion+=cuentascontableslineaproducto.getid_cuenta_contable_inventario().toString()+",";
		sDescripcion+=CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA+"=";
		sDescripcion+=cuentascontableslineaproducto.getid_cuenta_contable_costo_venta().toString()+",";
		sDescripcion+=CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEVENTA+"=";
		sDescripcion+=cuentascontableslineaproducto.getid_cuenta_contable_venta().toString()+",";
		sDescripcion+=CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO+"=";
		sDescripcion+=cuentascontableslineaproducto.getid_cuenta_contable_descuento().toString()+",";
		sDescripcion+=CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION+"=";
		sDescripcion+=cuentascontableslineaproducto.getid_cuenta_contable_produccion().toString()+",";
		sDescripcion+=CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION+"=";
		sDescripcion+=cuentascontableslineaproducto.getid_cuenta_contable_devolucion().toString()+",";
		sDescripcion+=CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVADEBITO+"=";
		sDescripcion+=cuentascontableslineaproducto.getid_cuenta_contable_iva_debito().toString()+",";
		sDescripcion+=CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVACREDITO+"=";
		sDescripcion+=cuentascontableslineaproducto.getid_cuenta_contable_iva_credito().toString()+",";
		sDescripcion+=CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEBONIFICA+"=";
		sDescripcion+=cuentascontableslineaproducto.getid_cuenta_contable_bonifica().toString()+",";
		sDescripcion+=CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA+"=";
		sDescripcion+=cuentascontableslineaproducto.getid_cuenta_contable_costo_bonifica().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCuentasContablesLineaProductoDescripcion(CuentasContablesLineaProducto cuentascontableslineaproducto,String sValor) throws Exception {			
		if(cuentascontableslineaproducto !=null) {
			//cuentascontableslineaproductocuentascontableslineaproducto.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
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

	public static String getCuentaContableInventarioDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCostoVentaDescripcion(CuentaContable cuentacontable) {
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

	public static String getCuentaContableProduccionDescripcion(CuentaContable cuentacontable) {
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

	public static String getCuentaContableIvaDebitoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableIvaCreditoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableBonificaDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCostoBonificaDescripcion(CuentaContable cuentacontable) {
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
		} else if(sNombreIndice.equals("FK_IdCuentaContableBonifica")) {
			sNombreIndice="Tipo=  Por Cuenta C. Bonifica";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCostoBonifica")) {
			sNombreIndice="Tipo=  Por Cuenta C. Costo Bonifica";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCostoVenta")) {
			sNombreIndice="Tipo=  Por Cuenta C. Costo Venta";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDescuento")) {
			sNombreIndice="Tipo=  Por Cuenta C. Descuento";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDevolucion")) {
			sNombreIndice="Tipo=  Por Cuenta C. Devolucion";
		} else if(sNombreIndice.equals("FK_IdCuentaContableInventario")) {
			sNombreIndice="Tipo=  Por Cuenta C. Inventario";
		} else if(sNombreIndice.equals("FK_IdCuentaContableIvaCredito")) {
			sNombreIndice="Tipo=  Por Cuenta C. Iva Credito";
		} else if(sNombreIndice.equals("FK_IdCuentaContableIvaDebito")) {
			sNombreIndice="Tipo=  Por Cuenta C. Iva Debito";
		} else if(sNombreIndice.equals("FK_IdCuentaContableProduccion")) {
			sNombreIndice="Tipo=  Por Cuenta C. Produccion";
		} else if(sNombreIndice.equals("FK_IdCuentaContableVenta")) {
			sNombreIndice="Tipo=  Por Cuenta C. Venta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdLinea")) {
			sNombreIndice="Tipo=  Por Linea";
		} else if(sNombreIndice.equals("FK_IdLineaCategoria")) {
			sNombreIndice="Tipo=  Por Linea Categoria";
		} else if(sNombreIndice.equals("FK_IdLineaGrupo")) {
			sNombreIndice="Tipo=  Por Linea Grupo";
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

	public static String getDetalleIndiceFK_IdCuentaContableBonifica(Long id_cuenta_contable_bonifica) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_bonifica!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Bonifica="+id_cuenta_contable_bonifica.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCostoBonifica(Long id_cuenta_contable_costo_bonifica) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_costo_bonifica!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Costo Bonifica="+id_cuenta_contable_costo_bonifica.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCostoVenta(Long id_cuenta_contable_costo_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_costo_venta!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Costo Venta="+id_cuenta_contable_costo_venta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableDescuento(Long id_cuenta_contable_descuento) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_descuento!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Descuento="+id_cuenta_contable_descuento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableDevolucion(Long id_cuenta_contable_devolucion) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_devolucion!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Devolucion="+id_cuenta_contable_devolucion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableInventario(Long id_cuenta_contable_inventario) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_inventario!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Inventario="+id_cuenta_contable_inventario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableIvaCredito(Long id_cuenta_contable_iva_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_iva_credito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Iva Credito="+id_cuenta_contable_iva_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableIvaDebito(Long id_cuenta_contable_iva_debito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_iva_debito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Iva Debito="+id_cuenta_contable_iva_debito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableProduccion(Long id_cuenta_contable_produccion) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_produccion!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Produccion="+id_cuenta_contable_produccion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableVenta(Long id_cuenta_contable_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_venta!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Venta="+id_cuenta_contable_venta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosCuentasContablesLineaProducto(CuentasContablesLineaProducto cuentascontableslineaproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosCuentasContablesLineaProductos(List<CuentasContablesLineaProducto> cuentascontableslineaproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CuentasContablesLineaProducto cuentascontableslineaproducto: cuentascontableslineaproductos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCuentasContablesLineaProducto(CuentasContablesLineaProducto cuentascontableslineaproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cuentascontableslineaproducto.getConCambioAuxiliar()) {
			cuentascontableslineaproducto.setIsDeleted(cuentascontableslineaproducto.getIsDeletedAuxiliar());	
			cuentascontableslineaproducto.setIsNew(cuentascontableslineaproducto.getIsNewAuxiliar());	
			cuentascontableslineaproducto.setIsChanged(cuentascontableslineaproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cuentascontableslineaproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cuentascontableslineaproducto.setIsDeletedAuxiliar(false);	
			cuentascontableslineaproducto.setIsNewAuxiliar(false);	
			cuentascontableslineaproducto.setIsChangedAuxiliar(false);
			
			cuentascontableslineaproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCuentasContablesLineaProductos(List<CuentasContablesLineaProducto> cuentascontableslineaproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CuentasContablesLineaProducto cuentascontableslineaproducto : cuentascontableslineaproductos) {
			if(conAsignarBase && cuentascontableslineaproducto.getConCambioAuxiliar()) {
				cuentascontableslineaproducto.setIsDeleted(cuentascontableslineaproducto.getIsDeletedAuxiliar());	
				cuentascontableslineaproducto.setIsNew(cuentascontableslineaproducto.getIsNewAuxiliar());	
				cuentascontableslineaproducto.setIsChanged(cuentascontableslineaproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cuentascontableslineaproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cuentascontableslineaproducto.setIsDeletedAuxiliar(false);	
				cuentascontableslineaproducto.setIsNewAuxiliar(false);	
				cuentascontableslineaproducto.setIsChangedAuxiliar(false);
				
				cuentascontableslineaproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCuentasContablesLineaProducto(CuentasContablesLineaProducto cuentascontableslineaproducto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCuentasContablesLineaProductos(List<CuentasContablesLineaProducto> cuentascontableslineaproductos,Boolean conEnteros) throws Exception  {
		
		for(CuentasContablesLineaProducto cuentascontableslineaproducto: cuentascontableslineaproductos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCuentasContablesLineaProducto(List<CuentasContablesLineaProducto> cuentascontableslineaproductos,CuentasContablesLineaProducto cuentascontableslineaproductoAux) throws Exception  {
		CuentasContablesLineaProductoConstantesFunciones.InicializarValoresCuentasContablesLineaProducto(cuentascontableslineaproductoAux,true);
		
		for(CuentasContablesLineaProducto cuentascontableslineaproducto: cuentascontableslineaproductos) {
			if(cuentascontableslineaproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentasContablesLineaProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CuentasContablesLineaProductoConstantesFunciones.getArrayColumnasGlobalesCuentasContablesLineaProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentasContablesLineaProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CuentasContablesLineaProductoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CuentasContablesLineaProductoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCuentasContablesLineaProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CuentasContablesLineaProducto> cuentascontableslineaproductos,CuentasContablesLineaProducto cuentascontableslineaproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CuentasContablesLineaProducto cuentascontableslineaproductoAux: cuentascontableslineaproductos) {
			if(cuentascontableslineaproductoAux!=null && cuentascontableslineaproducto!=null) {
				if((cuentascontableslineaproductoAux.getId()==null && cuentascontableslineaproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cuentascontableslineaproductoAux.getId()!=null && cuentascontableslineaproducto.getId()!=null){
					if(cuentascontableslineaproductoAux.getId().equals(cuentascontableslineaproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCuentasContablesLineaProducto(List<CuentasContablesLineaProducto> cuentascontableslineaproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CuentasContablesLineaProducto cuentascontableslineaproducto: cuentascontableslineaproductos) {			
			if(cuentascontableslineaproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCuentasContablesLineaProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CuentasContablesLineaProductoConstantesFunciones.LABEL_ID, CuentasContablesLineaProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentasContablesLineaProductoConstantesFunciones.LABEL_VERSIONROW, CuentasContablesLineaProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentasContablesLineaProductoConstantesFunciones.LABEL_IDEMPRESA, CuentasContablesLineaProductoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentasContablesLineaProductoConstantesFunciones.LABEL_IDBODEGA, CuentasContablesLineaProductoConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCENTROCOSTO, CuentasContablesLineaProductoConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentasContablesLineaProductoConstantesFunciones.LABEL_IDLINEA, CuentasContablesLineaProductoConstantesFunciones.IDLINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentasContablesLineaProductoConstantesFunciones.LABEL_IDLINEAGRUPO, CuentasContablesLineaProductoConstantesFunciones.IDLINEAGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentasContablesLineaProductoConstantesFunciones.LABEL_IDLINEACATEGORIA, CuentasContablesLineaProductoConstantesFunciones.IDLINEACATEGORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO, CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOVENTA, CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA, CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO, CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEPRODUCCION, CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION, CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEIVADEBITO, CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVADEBITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEIVACREDITO, CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEBONIFICA, CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEBONIFICA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOBONIFICA, CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCuentasContablesLineaProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CuentasContablesLineaProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentasContablesLineaProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentasContablesLineaProductoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentasContablesLineaProductoConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentasContablesLineaProductoConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentasContablesLineaProductoConstantesFunciones.IDLINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentasContablesLineaProductoConstantesFunciones.IDLINEAGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentasContablesLineaProductoConstantesFunciones.IDLINEACATEGORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVADEBITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEBONIFICA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentasContablesLineaProducto() throws Exception  {
		return CuentasContablesLineaProductoConstantesFunciones.getTiposSeleccionarCuentasContablesLineaProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentasContablesLineaProducto(Boolean conFk) throws Exception  {
		return CuentasContablesLineaProductoConstantesFunciones.getTiposSeleccionarCuentasContablesLineaProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentasContablesLineaProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO);
			reporte.setsDescripcion(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOVENTA);
			reporte.setsDescripcion(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA);
			reporte.setsDescripcion(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO);
			reporte.setsDescripcion(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEPRODUCCION);
			reporte.setsDescripcion(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEPRODUCCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION);
			reporte.setsDescripcion(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEIVADEBITO);
			reporte.setsDescripcion(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEIVADEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEIVACREDITO);
			reporte.setsDescripcion(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEIVACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEBONIFICA);
			reporte.setsDescripcion(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEBONIFICA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOBONIFICA);
			reporte.setsDescripcion(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOBONIFICA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCuentasContablesLineaProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(CuentasContablesLineaProducto cuentascontableslineaproductoAux) throws Exception {
		
			cuentascontableslineaproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cuentascontableslineaproductoAux.getEmpresa()));
			cuentascontableslineaproductoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(cuentascontableslineaproductoAux.getBodega()));
			cuentascontableslineaproductoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(cuentascontableslineaproductoAux.getCentroCosto()));
			cuentascontableslineaproductoAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(cuentascontableslineaproductoAux.getLinea()));
			cuentascontableslineaproductoAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(cuentascontableslineaproductoAux.getLineaGrupo()));
			cuentascontableslineaproductoAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(cuentascontableslineaproductoAux.getLineaCategoria()));
			cuentascontableslineaproductoAux.setcuentacontableinventario_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentascontableslineaproductoAux.getCuentaContableInventario()));
			cuentascontableslineaproductoAux.setcuentacontablecostoventa_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentascontableslineaproductoAux.getCuentaContableCostoVenta()));
			cuentascontableslineaproductoAux.setcuentacontableventa_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentascontableslineaproductoAux.getCuentaContableVenta()));
			cuentascontableslineaproductoAux.setcuentacontabledescuento_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentascontableslineaproductoAux.getCuentaContableDescuento()));
			cuentascontableslineaproductoAux.setcuentacontableproduccion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentascontableslineaproductoAux.getCuentaContableProduccion()));
			cuentascontableslineaproductoAux.setcuentacontabledevolucion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentascontableslineaproductoAux.getCuentaContableDevolucion()));
			cuentascontableslineaproductoAux.setcuentacontableivadebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentascontableslineaproductoAux.getCuentaContableIvaDebito()));
			cuentascontableslineaproductoAux.setcuentacontableivacredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentascontableslineaproductoAux.getCuentaContableIvaCredito()));
			cuentascontableslineaproductoAux.setcuentacontablebonifica_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentascontableslineaproductoAux.getCuentaContableBonifica()));
			cuentascontableslineaproductoAux.setcuentacontablecostobonifica_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentascontableslineaproductoAux.getCuentaContableCostoBonifica()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(List<CuentasContablesLineaProducto> cuentascontableslineaproductosTemp) throws Exception {
		for(CuentasContablesLineaProducto cuentascontableslineaproductoAux:cuentascontableslineaproductosTemp) {
			
			cuentascontableslineaproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cuentascontableslineaproductoAux.getEmpresa()));
			cuentascontableslineaproductoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(cuentascontableslineaproductoAux.getBodega()));
			cuentascontableslineaproductoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(cuentascontableslineaproductoAux.getCentroCosto()));
			cuentascontableslineaproductoAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(cuentascontableslineaproductoAux.getLinea()));
			cuentascontableslineaproductoAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(cuentascontableslineaproductoAux.getLineaGrupo()));
			cuentascontableslineaproductoAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(cuentascontableslineaproductoAux.getLineaCategoria()));
			cuentascontableslineaproductoAux.setcuentacontableinventario_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentascontableslineaproductoAux.getCuentaContableInventario()));
			cuentascontableslineaproductoAux.setcuentacontablecostoventa_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentascontableslineaproductoAux.getCuentaContableCostoVenta()));
			cuentascontableslineaproductoAux.setcuentacontableventa_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentascontableslineaproductoAux.getCuentaContableVenta()));
			cuentascontableslineaproductoAux.setcuentacontabledescuento_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentascontableslineaproductoAux.getCuentaContableDescuento()));
			cuentascontableslineaproductoAux.setcuentacontableproduccion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentascontableslineaproductoAux.getCuentaContableProduccion()));
			cuentascontableslineaproductoAux.setcuentacontabledevolucion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentascontableslineaproductoAux.getCuentaContableDevolucion()));
			cuentascontableslineaproductoAux.setcuentacontableivadebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentascontableslineaproductoAux.getCuentaContableIvaDebito()));
			cuentascontableslineaproductoAux.setcuentacontableivacredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentascontableslineaproductoAux.getCuentaContableIvaCredito()));
			cuentascontableslineaproductoAux.setcuentacontablebonifica_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentascontableslineaproductoAux.getCuentaContableBonifica()));
			cuentascontableslineaproductoAux.setcuentacontablecostobonifica_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentascontableslineaproductoAux.getCuentaContableCostoBonifica()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCuentasContablesLineaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
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
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCuentasContablesLineaProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentasContablesLineaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CuentasContablesLineaProductoConstantesFunciones.getClassesRelationshipsOfCuentasContablesLineaProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentasContablesLineaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCuentasContablesLineaProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CuentasContablesLineaProductoConstantesFunciones.getClassesRelationshipsFromStringsOfCuentasContablesLineaProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCuentasContablesLineaProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CuentasContablesLineaProducto cuentascontableslineaproducto,List<CuentasContablesLineaProducto> cuentascontableslineaproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CuentasContablesLineaProducto cuentascontableslineaproductoEncontrado=null;
			
			for(CuentasContablesLineaProducto cuentascontableslineaproductoLocal:cuentascontableslineaproductos) {
				if(cuentascontableslineaproductoLocal.getId().equals(cuentascontableslineaproducto.getId())) {
					cuentascontableslineaproductoEncontrado=cuentascontableslineaproductoLocal;
					
					cuentascontableslineaproductoLocal.setIsChanged(cuentascontableslineaproducto.getIsChanged());
					cuentascontableslineaproductoLocal.setIsNew(cuentascontableslineaproducto.getIsNew());
					cuentascontableslineaproductoLocal.setIsDeleted(cuentascontableslineaproducto.getIsDeleted());
					
					cuentascontableslineaproductoLocal.setGeneralEntityOriginal(cuentascontableslineaproducto.getGeneralEntityOriginal());
					
					cuentascontableslineaproductoLocal.setId(cuentascontableslineaproducto.getId());	
					cuentascontableslineaproductoLocal.setVersionRow(cuentascontableslineaproducto.getVersionRow());	
					cuentascontableslineaproductoLocal.setid_empresa(cuentascontableslineaproducto.getid_empresa());	
					cuentascontableslineaproductoLocal.setid_bodega(cuentascontableslineaproducto.getid_bodega());	
					cuentascontableslineaproductoLocal.setid_centro_costo(cuentascontableslineaproducto.getid_centro_costo());	
					cuentascontableslineaproductoLocal.setid_linea(cuentascontableslineaproducto.getid_linea());	
					cuentascontableslineaproductoLocal.setid_linea_grupo(cuentascontableslineaproducto.getid_linea_grupo());	
					cuentascontableslineaproductoLocal.setid_linea_categoria(cuentascontableslineaproducto.getid_linea_categoria());	
					cuentascontableslineaproductoLocal.setid_cuenta_contable_inventario(cuentascontableslineaproducto.getid_cuenta_contable_inventario());	
					cuentascontableslineaproductoLocal.setid_cuenta_contable_costo_venta(cuentascontableslineaproducto.getid_cuenta_contable_costo_venta());	
					cuentascontableslineaproductoLocal.setid_cuenta_contable_venta(cuentascontableslineaproducto.getid_cuenta_contable_venta());	
					cuentascontableslineaproductoLocal.setid_cuenta_contable_descuento(cuentascontableslineaproducto.getid_cuenta_contable_descuento());	
					cuentascontableslineaproductoLocal.setid_cuenta_contable_produccion(cuentascontableslineaproducto.getid_cuenta_contable_produccion());	
					cuentascontableslineaproductoLocal.setid_cuenta_contable_devolucion(cuentascontableslineaproducto.getid_cuenta_contable_devolucion());	
					cuentascontableslineaproductoLocal.setid_cuenta_contable_iva_debito(cuentascontableslineaproducto.getid_cuenta_contable_iva_debito());	
					cuentascontableslineaproductoLocal.setid_cuenta_contable_iva_credito(cuentascontableslineaproducto.getid_cuenta_contable_iva_credito());	
					cuentascontableslineaproductoLocal.setid_cuenta_contable_bonifica(cuentascontableslineaproducto.getid_cuenta_contable_bonifica());	
					cuentascontableslineaproductoLocal.setid_cuenta_contable_costo_bonifica(cuentascontableslineaproducto.getid_cuenta_contable_costo_bonifica());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!cuentascontableslineaproducto.getIsDeleted()) {
				if(!existe) {
					cuentascontableslineaproductos.add(cuentascontableslineaproducto);
				}
			} else {
				if(cuentascontableslineaproductoEncontrado!=null && permiteQuitar)  {
					cuentascontableslineaproductos.remove(cuentascontableslineaproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CuentasContablesLineaProducto cuentascontableslineaproducto,List<CuentasContablesLineaProducto> cuentascontableslineaproductos) throws Exception {
		try	{			
			for(CuentasContablesLineaProducto cuentascontableslineaproductoLocal:cuentascontableslineaproductos) {
				if(cuentascontableslineaproductoLocal.getId().equals(cuentascontableslineaproducto.getId())) {
					cuentascontableslineaproductoLocal.setIsSelected(cuentascontableslineaproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCuentasContablesLineaProducto(List<CuentasContablesLineaProducto> cuentascontableslineaproductosAux) throws Exception {
		//this.cuentascontableslineaproductosAux=cuentascontableslineaproductosAux;
		
		for(CuentasContablesLineaProducto cuentascontableslineaproductoAux:cuentascontableslineaproductosAux) {
			if(cuentascontableslineaproductoAux.getIsChanged()) {
				cuentascontableslineaproductoAux.setIsChanged(false);
			}		
			
			if(cuentascontableslineaproductoAux.getIsNew()) {
				cuentascontableslineaproductoAux.setIsNew(false);
			}	
			
			if(cuentascontableslineaproductoAux.getIsDeleted()) {
				cuentascontableslineaproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCuentasContablesLineaProducto(CuentasContablesLineaProducto cuentascontableslineaproductoAux) throws Exception {
		//this.cuentascontableslineaproductoAux=cuentascontableslineaproductoAux;
		
			if(cuentascontableslineaproductoAux.getIsChanged()) {
				cuentascontableslineaproductoAux.setIsChanged(false);
			}		
			
			if(cuentascontableslineaproductoAux.getIsNew()) {
				cuentascontableslineaproductoAux.setIsNew(false);
			}	
			
			if(cuentascontableslineaproductoAux.getIsDeleted()) {
				cuentascontableslineaproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CuentasContablesLineaProducto cuentascontableslineaproductoAsignar,CuentasContablesLineaProducto cuentascontableslineaproducto) throws Exception {
		cuentascontableslineaproductoAsignar.setId(cuentascontableslineaproducto.getId());	
		cuentascontableslineaproductoAsignar.setVersionRow(cuentascontableslineaproducto.getVersionRow());	
		cuentascontableslineaproductoAsignar.setid_empresa(cuentascontableslineaproducto.getid_empresa());
		cuentascontableslineaproductoAsignar.setempresa_descripcion(cuentascontableslineaproducto.getempresa_descripcion());	
		cuentascontableslineaproductoAsignar.setid_bodega(cuentascontableslineaproducto.getid_bodega());
		cuentascontableslineaproductoAsignar.setbodega_descripcion(cuentascontableslineaproducto.getbodega_descripcion());	
		cuentascontableslineaproductoAsignar.setid_centro_costo(cuentascontableslineaproducto.getid_centro_costo());
		cuentascontableslineaproductoAsignar.setcentrocosto_descripcion(cuentascontableslineaproducto.getcentrocosto_descripcion());	
		cuentascontableslineaproductoAsignar.setid_linea(cuentascontableslineaproducto.getid_linea());
		cuentascontableslineaproductoAsignar.setlinea_descripcion(cuentascontableslineaproducto.getlinea_descripcion());	
		cuentascontableslineaproductoAsignar.setid_linea_grupo(cuentascontableslineaproducto.getid_linea_grupo());
		cuentascontableslineaproductoAsignar.setlineagrupo_descripcion(cuentascontableslineaproducto.getlineagrupo_descripcion());	
		cuentascontableslineaproductoAsignar.setid_linea_categoria(cuentascontableslineaproducto.getid_linea_categoria());
		cuentascontableslineaproductoAsignar.setlineacategoria_descripcion(cuentascontableslineaproducto.getlineacategoria_descripcion());	
		cuentascontableslineaproductoAsignar.setid_cuenta_contable_inventario(cuentascontableslineaproducto.getid_cuenta_contable_inventario());
		cuentascontableslineaproductoAsignar.setcuentacontableinventario_descripcion(cuentascontableslineaproducto.getcuentacontableinventario_descripcion());	
		cuentascontableslineaproductoAsignar.setid_cuenta_contable_costo_venta(cuentascontableslineaproducto.getid_cuenta_contable_costo_venta());
		cuentascontableslineaproductoAsignar.setcuentacontablecostoventa_descripcion(cuentascontableslineaproducto.getcuentacontablecostoventa_descripcion());	
		cuentascontableslineaproductoAsignar.setid_cuenta_contable_venta(cuentascontableslineaproducto.getid_cuenta_contable_venta());
		cuentascontableslineaproductoAsignar.setcuentacontableventa_descripcion(cuentascontableslineaproducto.getcuentacontableventa_descripcion());	
		cuentascontableslineaproductoAsignar.setid_cuenta_contable_descuento(cuentascontableslineaproducto.getid_cuenta_contable_descuento());
		cuentascontableslineaproductoAsignar.setcuentacontabledescuento_descripcion(cuentascontableslineaproducto.getcuentacontabledescuento_descripcion());	
		cuentascontableslineaproductoAsignar.setid_cuenta_contable_produccion(cuentascontableslineaproducto.getid_cuenta_contable_produccion());
		cuentascontableslineaproductoAsignar.setcuentacontableproduccion_descripcion(cuentascontableslineaproducto.getcuentacontableproduccion_descripcion());	
		cuentascontableslineaproductoAsignar.setid_cuenta_contable_devolucion(cuentascontableslineaproducto.getid_cuenta_contable_devolucion());
		cuentascontableslineaproductoAsignar.setcuentacontabledevolucion_descripcion(cuentascontableslineaproducto.getcuentacontabledevolucion_descripcion());	
		cuentascontableslineaproductoAsignar.setid_cuenta_contable_iva_debito(cuentascontableslineaproducto.getid_cuenta_contable_iva_debito());
		cuentascontableslineaproductoAsignar.setcuentacontableivadebito_descripcion(cuentascontableslineaproducto.getcuentacontableivadebito_descripcion());	
		cuentascontableslineaproductoAsignar.setid_cuenta_contable_iva_credito(cuentascontableslineaproducto.getid_cuenta_contable_iva_credito());
		cuentascontableslineaproductoAsignar.setcuentacontableivacredito_descripcion(cuentascontableslineaproducto.getcuentacontableivacredito_descripcion());	
		cuentascontableslineaproductoAsignar.setid_cuenta_contable_bonifica(cuentascontableslineaproducto.getid_cuenta_contable_bonifica());
		cuentascontableslineaproductoAsignar.setcuentacontablebonifica_descripcion(cuentascontableslineaproducto.getcuentacontablebonifica_descripcion());	
		cuentascontableslineaproductoAsignar.setid_cuenta_contable_costo_bonifica(cuentascontableslineaproducto.getid_cuenta_contable_costo_bonifica());
		cuentascontableslineaproductoAsignar.setcuentacontablecostobonifica_descripcion(cuentascontableslineaproducto.getcuentacontablecostobonifica_descripcion());	
	}
	
	public static void inicializarCuentasContablesLineaProducto(CuentasContablesLineaProducto cuentascontableslineaproducto) throws Exception {
		try {
				cuentascontableslineaproducto.setId(0L);	
					
				cuentascontableslineaproducto.setid_empresa(-1L);	
				cuentascontableslineaproducto.setid_bodega(-1L);	
				cuentascontableslineaproducto.setid_centro_costo(null);	
				cuentascontableslineaproducto.setid_linea(-1L);	
				cuentascontableslineaproducto.setid_linea_grupo(-1L);	
				cuentascontableslineaproducto.setid_linea_categoria(-1L);	
				cuentascontableslineaproducto.setid_cuenta_contable_inventario(-1L);	
				cuentascontableslineaproducto.setid_cuenta_contable_costo_venta(-1L);	
				cuentascontableslineaproducto.setid_cuenta_contable_venta(-1L);	
				cuentascontableslineaproducto.setid_cuenta_contable_descuento(-1L);	
				cuentascontableslineaproducto.setid_cuenta_contable_produccion(-1L);	
				cuentascontableslineaproducto.setid_cuenta_contable_devolucion(-1L);	
				cuentascontableslineaproducto.setid_cuenta_contable_iva_debito(-1L);	
				cuentascontableslineaproducto.setid_cuenta_contable_iva_credito(-1L);	
				cuentascontableslineaproducto.setid_cuenta_contable_bonifica(-1L);	
				cuentascontableslineaproducto.setid_cuenta_contable_costo_bonifica(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCuentasContablesLineaProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEPRODUCCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEIVADEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEIVACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEBONIFICA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentasContablesLineaProductoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOBONIFICA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCuentasContablesLineaProducto(String sTipo,Row row,Workbook workbook,CuentasContablesLineaProducto cuentascontableslineaproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentascontableslineaproducto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentascontableslineaproducto.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentascontableslineaproducto.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentascontableslineaproducto.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentascontableslineaproducto.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentascontableslineaproducto.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentascontableslineaproducto.getcuentacontableinventario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentascontableslineaproducto.getcuentacontablecostoventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentascontableslineaproducto.getcuentacontableventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentascontableslineaproducto.getcuentacontabledescuento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentascontableslineaproducto.getcuentacontableproduccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentascontableslineaproducto.getcuentacontabledevolucion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentascontableslineaproducto.getcuentacontableivadebito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentascontableslineaproducto.getcuentacontableivacredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentascontableslineaproducto.getcuentacontablebonifica_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentascontableslineaproducto.getcuentacontablecostobonifica_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCuentasContablesLineaProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCuentasContablesLineaProducto() {
		return this.sFinalQueryCuentasContablesLineaProducto;
	}
	
	public void setsFinalQueryCuentasContablesLineaProducto(String sFinalQueryCuentasContablesLineaProducto) {
		this.sFinalQueryCuentasContablesLineaProducto= sFinalQueryCuentasContablesLineaProducto;
	}
	
	public Border resaltarSeleccionarCuentasContablesLineaProducto=null;
	
	public Border setResaltarSeleccionarCuentasContablesLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cuentascontableslineaproductoBeanSwingJInternalFrame.jTtoolBarCuentasContablesLineaProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCuentasContablesLineaProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCuentasContablesLineaProducto() {
		return this.resaltarSeleccionarCuentasContablesLineaProducto;
	}
	
	public void setResaltarSeleccionarCuentasContablesLineaProducto(Border borderResaltarSeleccionarCuentasContablesLineaProducto) {
		this.resaltarSeleccionarCuentasContablesLineaProducto= borderResaltarSeleccionarCuentasContablesLineaProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCuentasContablesLineaProducto=null;
	public Boolean mostraridCuentasContablesLineaProducto=true;
	public Boolean activaridCuentasContablesLineaProducto=true;

	public Border resaltarid_empresaCuentasContablesLineaProducto=null;
	public Boolean mostrarid_empresaCuentasContablesLineaProducto=true;
	public Boolean activarid_empresaCuentasContablesLineaProducto=true;
	public Boolean cargarid_empresaCuentasContablesLineaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCuentasContablesLineaProducto=false;//ConEventDepend=true

	public Border resaltarid_bodegaCuentasContablesLineaProducto=null;
	public Boolean mostrarid_bodegaCuentasContablesLineaProducto=true;
	public Boolean activarid_bodegaCuentasContablesLineaProducto=true;
	public Boolean cargarid_bodegaCuentasContablesLineaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaCuentasContablesLineaProducto=false;//ConEventDepend=true

	public Border resaltarid_centro_costoCuentasContablesLineaProducto=null;
	public Boolean mostrarid_centro_costoCuentasContablesLineaProducto=true;
	public Boolean activarid_centro_costoCuentasContablesLineaProducto=true;
	public Boolean cargarid_centro_costoCuentasContablesLineaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoCuentasContablesLineaProducto=false;//ConEventDepend=true

	public Border resaltarid_lineaCuentasContablesLineaProducto=null;
	public Boolean mostrarid_lineaCuentasContablesLineaProducto=true;
	public Boolean activarid_lineaCuentasContablesLineaProducto=true;
	public Boolean cargarid_lineaCuentasContablesLineaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaCuentasContablesLineaProducto=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoCuentasContablesLineaProducto=null;
	public Boolean mostrarid_linea_grupoCuentasContablesLineaProducto=true;
	public Boolean activarid_linea_grupoCuentasContablesLineaProducto=true;
	public Boolean cargarid_linea_grupoCuentasContablesLineaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoCuentasContablesLineaProducto=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaCuentasContablesLineaProducto=null;
	public Boolean mostrarid_linea_categoriaCuentasContablesLineaProducto=true;
	public Boolean activarid_linea_categoriaCuentasContablesLineaProducto=true;
	public Boolean cargarid_linea_categoriaCuentasContablesLineaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaCuentasContablesLineaProducto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_inventarioCuentasContablesLineaProducto=null;
	public Boolean mostrarid_cuenta_contable_inventarioCuentasContablesLineaProducto=true;
	public Boolean activarid_cuenta_contable_inventarioCuentasContablesLineaProducto=true;
	public Boolean cargarid_cuenta_contable_inventarioCuentasContablesLineaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_inventarioCuentasContablesLineaProducto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto=null;
	public Boolean mostrarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto=true;
	public Boolean activarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto=true;
	public Boolean cargarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_costo_ventaCuentasContablesLineaProducto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_ventaCuentasContablesLineaProducto=null;
	public Boolean mostrarid_cuenta_contable_ventaCuentasContablesLineaProducto=true;
	public Boolean activarid_cuenta_contable_ventaCuentasContablesLineaProducto=true;
	public Boolean cargarid_cuenta_contable_ventaCuentasContablesLineaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_ventaCuentasContablesLineaProducto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_descuentoCuentasContablesLineaProducto=null;
	public Boolean mostrarid_cuenta_contable_descuentoCuentasContablesLineaProducto=true;
	public Boolean activarid_cuenta_contable_descuentoCuentasContablesLineaProducto=true;
	public Boolean cargarid_cuenta_contable_descuentoCuentasContablesLineaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_descuentoCuentasContablesLineaProducto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_produccionCuentasContablesLineaProducto=null;
	public Boolean mostrarid_cuenta_contable_produccionCuentasContablesLineaProducto=true;
	public Boolean activarid_cuenta_contable_produccionCuentasContablesLineaProducto=true;
	public Boolean cargarid_cuenta_contable_produccionCuentasContablesLineaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_produccionCuentasContablesLineaProducto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_devolucionCuentasContablesLineaProducto=null;
	public Boolean mostrarid_cuenta_contable_devolucionCuentasContablesLineaProducto=true;
	public Boolean activarid_cuenta_contable_devolucionCuentasContablesLineaProducto=true;
	public Boolean cargarid_cuenta_contable_devolucionCuentasContablesLineaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_devolucionCuentasContablesLineaProducto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto=null;
	public Boolean mostrarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto=true;
	public Boolean activarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto=true;
	public Boolean cargarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_iva_debitoCuentasContablesLineaProducto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto=null;
	public Boolean mostrarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto=true;
	public Boolean activarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto=true;
	public Boolean cargarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_iva_creditoCuentasContablesLineaProducto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_bonificaCuentasContablesLineaProducto=null;
	public Boolean mostrarid_cuenta_contable_bonificaCuentasContablesLineaProducto=true;
	public Boolean activarid_cuenta_contable_bonificaCuentasContablesLineaProducto=true;
	public Boolean cargarid_cuenta_contable_bonificaCuentasContablesLineaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_bonificaCuentasContablesLineaProducto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto=null;
	public Boolean mostrarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto=true;
	public Boolean activarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto=true;
	public Boolean cargarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto=false;//ConEventDepend=true

	
	

	public Border setResaltaridCuentasContablesLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentascontableslineaproductoBeanSwingJInternalFrame.jTtoolBarCuentasContablesLineaProducto.setBorder(borderResaltar);
		
		this.resaltaridCuentasContablesLineaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCuentasContablesLineaProducto() {
		return this.resaltaridCuentasContablesLineaProducto;
	}

	public void setResaltaridCuentasContablesLineaProducto(Border borderResaltar) {
		this.resaltaridCuentasContablesLineaProducto= borderResaltar;
	}

	public Boolean getMostraridCuentasContablesLineaProducto() {
		return this.mostraridCuentasContablesLineaProducto;
	}

	public void setMostraridCuentasContablesLineaProducto(Boolean mostraridCuentasContablesLineaProducto) {
		this.mostraridCuentasContablesLineaProducto= mostraridCuentasContablesLineaProducto;
	}

	public Boolean getActivaridCuentasContablesLineaProducto() {
		return this.activaridCuentasContablesLineaProducto;
	}

	public void setActivaridCuentasContablesLineaProducto(Boolean activaridCuentasContablesLineaProducto) {
		this.activaridCuentasContablesLineaProducto= activaridCuentasContablesLineaProducto;
	}

	public Border setResaltarid_empresaCuentasContablesLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentascontableslineaproductoBeanSwingJInternalFrame.jTtoolBarCuentasContablesLineaProducto.setBorder(borderResaltar);
		
		this.resaltarid_empresaCuentasContablesLineaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCuentasContablesLineaProducto() {
		return this.resaltarid_empresaCuentasContablesLineaProducto;
	}

	public void setResaltarid_empresaCuentasContablesLineaProducto(Border borderResaltar) {
		this.resaltarid_empresaCuentasContablesLineaProducto= borderResaltar;
	}

	public Boolean getMostrarid_empresaCuentasContablesLineaProducto() {
		return this.mostrarid_empresaCuentasContablesLineaProducto;
	}

	public void setMostrarid_empresaCuentasContablesLineaProducto(Boolean mostrarid_empresaCuentasContablesLineaProducto) {
		this.mostrarid_empresaCuentasContablesLineaProducto= mostrarid_empresaCuentasContablesLineaProducto;
	}

	public Boolean getActivarid_empresaCuentasContablesLineaProducto() {
		return this.activarid_empresaCuentasContablesLineaProducto;
	}

	public void setActivarid_empresaCuentasContablesLineaProducto(Boolean activarid_empresaCuentasContablesLineaProducto) {
		this.activarid_empresaCuentasContablesLineaProducto= activarid_empresaCuentasContablesLineaProducto;
	}

	public Boolean getCargarid_empresaCuentasContablesLineaProducto() {
		return this.cargarid_empresaCuentasContablesLineaProducto;
	}

	public void setCargarid_empresaCuentasContablesLineaProducto(Boolean cargarid_empresaCuentasContablesLineaProducto) {
		this.cargarid_empresaCuentasContablesLineaProducto= cargarid_empresaCuentasContablesLineaProducto;
	}

	public Border setResaltarid_bodegaCuentasContablesLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentascontableslineaproductoBeanSwingJInternalFrame.jTtoolBarCuentasContablesLineaProducto.setBorder(borderResaltar);
		
		this.resaltarid_bodegaCuentasContablesLineaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaCuentasContablesLineaProducto() {
		return this.resaltarid_bodegaCuentasContablesLineaProducto;
	}

	public void setResaltarid_bodegaCuentasContablesLineaProducto(Border borderResaltar) {
		this.resaltarid_bodegaCuentasContablesLineaProducto= borderResaltar;
	}

	public Boolean getMostrarid_bodegaCuentasContablesLineaProducto() {
		return this.mostrarid_bodegaCuentasContablesLineaProducto;
	}

	public void setMostrarid_bodegaCuentasContablesLineaProducto(Boolean mostrarid_bodegaCuentasContablesLineaProducto) {
		this.mostrarid_bodegaCuentasContablesLineaProducto= mostrarid_bodegaCuentasContablesLineaProducto;
	}

	public Boolean getActivarid_bodegaCuentasContablesLineaProducto() {
		return this.activarid_bodegaCuentasContablesLineaProducto;
	}

	public void setActivarid_bodegaCuentasContablesLineaProducto(Boolean activarid_bodegaCuentasContablesLineaProducto) {
		this.activarid_bodegaCuentasContablesLineaProducto= activarid_bodegaCuentasContablesLineaProducto;
	}

	public Boolean getCargarid_bodegaCuentasContablesLineaProducto() {
		return this.cargarid_bodegaCuentasContablesLineaProducto;
	}

	public void setCargarid_bodegaCuentasContablesLineaProducto(Boolean cargarid_bodegaCuentasContablesLineaProducto) {
		this.cargarid_bodegaCuentasContablesLineaProducto= cargarid_bodegaCuentasContablesLineaProducto;
	}

	public Border setResaltarid_centro_costoCuentasContablesLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentascontableslineaproductoBeanSwingJInternalFrame.jTtoolBarCuentasContablesLineaProducto.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoCuentasContablesLineaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoCuentasContablesLineaProducto() {
		return this.resaltarid_centro_costoCuentasContablesLineaProducto;
	}

	public void setResaltarid_centro_costoCuentasContablesLineaProducto(Border borderResaltar) {
		this.resaltarid_centro_costoCuentasContablesLineaProducto= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoCuentasContablesLineaProducto() {
		return this.mostrarid_centro_costoCuentasContablesLineaProducto;
	}

	public void setMostrarid_centro_costoCuentasContablesLineaProducto(Boolean mostrarid_centro_costoCuentasContablesLineaProducto) {
		this.mostrarid_centro_costoCuentasContablesLineaProducto= mostrarid_centro_costoCuentasContablesLineaProducto;
	}

	public Boolean getActivarid_centro_costoCuentasContablesLineaProducto() {
		return this.activarid_centro_costoCuentasContablesLineaProducto;
	}

	public void setActivarid_centro_costoCuentasContablesLineaProducto(Boolean activarid_centro_costoCuentasContablesLineaProducto) {
		this.activarid_centro_costoCuentasContablesLineaProducto= activarid_centro_costoCuentasContablesLineaProducto;
	}

	public Boolean getCargarid_centro_costoCuentasContablesLineaProducto() {
		return this.cargarid_centro_costoCuentasContablesLineaProducto;
	}

	public void setCargarid_centro_costoCuentasContablesLineaProducto(Boolean cargarid_centro_costoCuentasContablesLineaProducto) {
		this.cargarid_centro_costoCuentasContablesLineaProducto= cargarid_centro_costoCuentasContablesLineaProducto;
	}

	public Border setResaltarid_lineaCuentasContablesLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentascontableslineaproductoBeanSwingJInternalFrame.jTtoolBarCuentasContablesLineaProducto.setBorder(borderResaltar);
		
		this.resaltarid_lineaCuentasContablesLineaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaCuentasContablesLineaProducto() {
		return this.resaltarid_lineaCuentasContablesLineaProducto;
	}

	public void setResaltarid_lineaCuentasContablesLineaProducto(Border borderResaltar) {
		this.resaltarid_lineaCuentasContablesLineaProducto= borderResaltar;
	}

	public Boolean getMostrarid_lineaCuentasContablesLineaProducto() {
		return this.mostrarid_lineaCuentasContablesLineaProducto;
	}

	public void setMostrarid_lineaCuentasContablesLineaProducto(Boolean mostrarid_lineaCuentasContablesLineaProducto) {
		this.mostrarid_lineaCuentasContablesLineaProducto= mostrarid_lineaCuentasContablesLineaProducto;
	}

	public Boolean getActivarid_lineaCuentasContablesLineaProducto() {
		return this.activarid_lineaCuentasContablesLineaProducto;
	}

	public void setActivarid_lineaCuentasContablesLineaProducto(Boolean activarid_lineaCuentasContablesLineaProducto) {
		this.activarid_lineaCuentasContablesLineaProducto= activarid_lineaCuentasContablesLineaProducto;
	}

	public Boolean getCargarid_lineaCuentasContablesLineaProducto() {
		return this.cargarid_lineaCuentasContablesLineaProducto;
	}

	public void setCargarid_lineaCuentasContablesLineaProducto(Boolean cargarid_lineaCuentasContablesLineaProducto) {
		this.cargarid_lineaCuentasContablesLineaProducto= cargarid_lineaCuentasContablesLineaProducto;
	}

	public Border setResaltarid_linea_grupoCuentasContablesLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentascontableslineaproductoBeanSwingJInternalFrame.jTtoolBarCuentasContablesLineaProducto.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoCuentasContablesLineaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoCuentasContablesLineaProducto() {
		return this.resaltarid_linea_grupoCuentasContablesLineaProducto;
	}

	public void setResaltarid_linea_grupoCuentasContablesLineaProducto(Border borderResaltar) {
		this.resaltarid_linea_grupoCuentasContablesLineaProducto= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoCuentasContablesLineaProducto() {
		return this.mostrarid_linea_grupoCuentasContablesLineaProducto;
	}

	public void setMostrarid_linea_grupoCuentasContablesLineaProducto(Boolean mostrarid_linea_grupoCuentasContablesLineaProducto) {
		this.mostrarid_linea_grupoCuentasContablesLineaProducto= mostrarid_linea_grupoCuentasContablesLineaProducto;
	}

	public Boolean getActivarid_linea_grupoCuentasContablesLineaProducto() {
		return this.activarid_linea_grupoCuentasContablesLineaProducto;
	}

	public void setActivarid_linea_grupoCuentasContablesLineaProducto(Boolean activarid_linea_grupoCuentasContablesLineaProducto) {
		this.activarid_linea_grupoCuentasContablesLineaProducto= activarid_linea_grupoCuentasContablesLineaProducto;
	}

	public Boolean getCargarid_linea_grupoCuentasContablesLineaProducto() {
		return this.cargarid_linea_grupoCuentasContablesLineaProducto;
	}

	public void setCargarid_linea_grupoCuentasContablesLineaProducto(Boolean cargarid_linea_grupoCuentasContablesLineaProducto) {
		this.cargarid_linea_grupoCuentasContablesLineaProducto= cargarid_linea_grupoCuentasContablesLineaProducto;
	}

	public Border setResaltarid_linea_categoriaCuentasContablesLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentascontableslineaproductoBeanSwingJInternalFrame.jTtoolBarCuentasContablesLineaProducto.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaCuentasContablesLineaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaCuentasContablesLineaProducto() {
		return this.resaltarid_linea_categoriaCuentasContablesLineaProducto;
	}

	public void setResaltarid_linea_categoriaCuentasContablesLineaProducto(Border borderResaltar) {
		this.resaltarid_linea_categoriaCuentasContablesLineaProducto= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaCuentasContablesLineaProducto() {
		return this.mostrarid_linea_categoriaCuentasContablesLineaProducto;
	}

	public void setMostrarid_linea_categoriaCuentasContablesLineaProducto(Boolean mostrarid_linea_categoriaCuentasContablesLineaProducto) {
		this.mostrarid_linea_categoriaCuentasContablesLineaProducto= mostrarid_linea_categoriaCuentasContablesLineaProducto;
	}

	public Boolean getActivarid_linea_categoriaCuentasContablesLineaProducto() {
		return this.activarid_linea_categoriaCuentasContablesLineaProducto;
	}

	public void setActivarid_linea_categoriaCuentasContablesLineaProducto(Boolean activarid_linea_categoriaCuentasContablesLineaProducto) {
		this.activarid_linea_categoriaCuentasContablesLineaProducto= activarid_linea_categoriaCuentasContablesLineaProducto;
	}

	public Boolean getCargarid_linea_categoriaCuentasContablesLineaProducto() {
		return this.cargarid_linea_categoriaCuentasContablesLineaProducto;
	}

	public void setCargarid_linea_categoriaCuentasContablesLineaProducto(Boolean cargarid_linea_categoriaCuentasContablesLineaProducto) {
		this.cargarid_linea_categoriaCuentasContablesLineaProducto= cargarid_linea_categoriaCuentasContablesLineaProducto;
	}

	public Border setResaltarid_cuenta_contable_inventarioCuentasContablesLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentascontableslineaproductoBeanSwingJInternalFrame.jTtoolBarCuentasContablesLineaProducto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_inventarioCuentasContablesLineaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_inventarioCuentasContablesLineaProducto() {
		return this.resaltarid_cuenta_contable_inventarioCuentasContablesLineaProducto;
	}

	public void setResaltarid_cuenta_contable_inventarioCuentasContablesLineaProducto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_inventarioCuentasContablesLineaProducto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_inventarioCuentasContablesLineaProducto() {
		return this.mostrarid_cuenta_contable_inventarioCuentasContablesLineaProducto;
	}

	public void setMostrarid_cuenta_contable_inventarioCuentasContablesLineaProducto(Boolean mostrarid_cuenta_contable_inventarioCuentasContablesLineaProducto) {
		this.mostrarid_cuenta_contable_inventarioCuentasContablesLineaProducto= mostrarid_cuenta_contable_inventarioCuentasContablesLineaProducto;
	}

	public Boolean getActivarid_cuenta_contable_inventarioCuentasContablesLineaProducto() {
		return this.activarid_cuenta_contable_inventarioCuentasContablesLineaProducto;
	}

	public void setActivarid_cuenta_contable_inventarioCuentasContablesLineaProducto(Boolean activarid_cuenta_contable_inventarioCuentasContablesLineaProducto) {
		this.activarid_cuenta_contable_inventarioCuentasContablesLineaProducto= activarid_cuenta_contable_inventarioCuentasContablesLineaProducto;
	}

	public Boolean getCargarid_cuenta_contable_inventarioCuentasContablesLineaProducto() {
		return this.cargarid_cuenta_contable_inventarioCuentasContablesLineaProducto;
	}

	public void setCargarid_cuenta_contable_inventarioCuentasContablesLineaProducto(Boolean cargarid_cuenta_contable_inventarioCuentasContablesLineaProducto) {
		this.cargarid_cuenta_contable_inventarioCuentasContablesLineaProducto= cargarid_cuenta_contable_inventarioCuentasContablesLineaProducto;
	}

	public Border setResaltarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentascontableslineaproductoBeanSwingJInternalFrame.jTtoolBarCuentasContablesLineaProducto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto() {
		return this.resaltarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto;
	}

	public void setResaltarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto() {
		return this.mostrarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto;
	}

	public void setMostrarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto(Boolean mostrarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto) {
		this.mostrarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto= mostrarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto;
	}

	public Boolean getActivarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto() {
		return this.activarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto;
	}

	public void setActivarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto(Boolean activarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto) {
		this.activarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto= activarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto;
	}

	public Boolean getCargarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto() {
		return this.cargarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto;
	}

	public void setCargarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto(Boolean cargarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto) {
		this.cargarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto= cargarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto;
	}

	public Border setResaltarid_cuenta_contable_ventaCuentasContablesLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentascontableslineaproductoBeanSwingJInternalFrame.jTtoolBarCuentasContablesLineaProducto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_ventaCuentasContablesLineaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_ventaCuentasContablesLineaProducto() {
		return this.resaltarid_cuenta_contable_ventaCuentasContablesLineaProducto;
	}

	public void setResaltarid_cuenta_contable_ventaCuentasContablesLineaProducto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_ventaCuentasContablesLineaProducto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_ventaCuentasContablesLineaProducto() {
		return this.mostrarid_cuenta_contable_ventaCuentasContablesLineaProducto;
	}

	public void setMostrarid_cuenta_contable_ventaCuentasContablesLineaProducto(Boolean mostrarid_cuenta_contable_ventaCuentasContablesLineaProducto) {
		this.mostrarid_cuenta_contable_ventaCuentasContablesLineaProducto= mostrarid_cuenta_contable_ventaCuentasContablesLineaProducto;
	}

	public Boolean getActivarid_cuenta_contable_ventaCuentasContablesLineaProducto() {
		return this.activarid_cuenta_contable_ventaCuentasContablesLineaProducto;
	}

	public void setActivarid_cuenta_contable_ventaCuentasContablesLineaProducto(Boolean activarid_cuenta_contable_ventaCuentasContablesLineaProducto) {
		this.activarid_cuenta_contable_ventaCuentasContablesLineaProducto= activarid_cuenta_contable_ventaCuentasContablesLineaProducto;
	}

	public Boolean getCargarid_cuenta_contable_ventaCuentasContablesLineaProducto() {
		return this.cargarid_cuenta_contable_ventaCuentasContablesLineaProducto;
	}

	public void setCargarid_cuenta_contable_ventaCuentasContablesLineaProducto(Boolean cargarid_cuenta_contable_ventaCuentasContablesLineaProducto) {
		this.cargarid_cuenta_contable_ventaCuentasContablesLineaProducto= cargarid_cuenta_contable_ventaCuentasContablesLineaProducto;
	}

	public Border setResaltarid_cuenta_contable_descuentoCuentasContablesLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentascontableslineaproductoBeanSwingJInternalFrame.jTtoolBarCuentasContablesLineaProducto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_descuentoCuentasContablesLineaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_descuentoCuentasContablesLineaProducto() {
		return this.resaltarid_cuenta_contable_descuentoCuentasContablesLineaProducto;
	}

	public void setResaltarid_cuenta_contable_descuentoCuentasContablesLineaProducto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_descuentoCuentasContablesLineaProducto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_descuentoCuentasContablesLineaProducto() {
		return this.mostrarid_cuenta_contable_descuentoCuentasContablesLineaProducto;
	}

	public void setMostrarid_cuenta_contable_descuentoCuentasContablesLineaProducto(Boolean mostrarid_cuenta_contable_descuentoCuentasContablesLineaProducto) {
		this.mostrarid_cuenta_contable_descuentoCuentasContablesLineaProducto= mostrarid_cuenta_contable_descuentoCuentasContablesLineaProducto;
	}

	public Boolean getActivarid_cuenta_contable_descuentoCuentasContablesLineaProducto() {
		return this.activarid_cuenta_contable_descuentoCuentasContablesLineaProducto;
	}

	public void setActivarid_cuenta_contable_descuentoCuentasContablesLineaProducto(Boolean activarid_cuenta_contable_descuentoCuentasContablesLineaProducto) {
		this.activarid_cuenta_contable_descuentoCuentasContablesLineaProducto= activarid_cuenta_contable_descuentoCuentasContablesLineaProducto;
	}

	public Boolean getCargarid_cuenta_contable_descuentoCuentasContablesLineaProducto() {
		return this.cargarid_cuenta_contable_descuentoCuentasContablesLineaProducto;
	}

	public void setCargarid_cuenta_contable_descuentoCuentasContablesLineaProducto(Boolean cargarid_cuenta_contable_descuentoCuentasContablesLineaProducto) {
		this.cargarid_cuenta_contable_descuentoCuentasContablesLineaProducto= cargarid_cuenta_contable_descuentoCuentasContablesLineaProducto;
	}

	public Border setResaltarid_cuenta_contable_produccionCuentasContablesLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentascontableslineaproductoBeanSwingJInternalFrame.jTtoolBarCuentasContablesLineaProducto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_produccionCuentasContablesLineaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_produccionCuentasContablesLineaProducto() {
		return this.resaltarid_cuenta_contable_produccionCuentasContablesLineaProducto;
	}

	public void setResaltarid_cuenta_contable_produccionCuentasContablesLineaProducto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_produccionCuentasContablesLineaProducto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_produccionCuentasContablesLineaProducto() {
		return this.mostrarid_cuenta_contable_produccionCuentasContablesLineaProducto;
	}

	public void setMostrarid_cuenta_contable_produccionCuentasContablesLineaProducto(Boolean mostrarid_cuenta_contable_produccionCuentasContablesLineaProducto) {
		this.mostrarid_cuenta_contable_produccionCuentasContablesLineaProducto= mostrarid_cuenta_contable_produccionCuentasContablesLineaProducto;
	}

	public Boolean getActivarid_cuenta_contable_produccionCuentasContablesLineaProducto() {
		return this.activarid_cuenta_contable_produccionCuentasContablesLineaProducto;
	}

	public void setActivarid_cuenta_contable_produccionCuentasContablesLineaProducto(Boolean activarid_cuenta_contable_produccionCuentasContablesLineaProducto) {
		this.activarid_cuenta_contable_produccionCuentasContablesLineaProducto= activarid_cuenta_contable_produccionCuentasContablesLineaProducto;
	}

	public Boolean getCargarid_cuenta_contable_produccionCuentasContablesLineaProducto() {
		return this.cargarid_cuenta_contable_produccionCuentasContablesLineaProducto;
	}

	public void setCargarid_cuenta_contable_produccionCuentasContablesLineaProducto(Boolean cargarid_cuenta_contable_produccionCuentasContablesLineaProducto) {
		this.cargarid_cuenta_contable_produccionCuentasContablesLineaProducto= cargarid_cuenta_contable_produccionCuentasContablesLineaProducto;
	}

	public Border setResaltarid_cuenta_contable_devolucionCuentasContablesLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentascontableslineaproductoBeanSwingJInternalFrame.jTtoolBarCuentasContablesLineaProducto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_devolucionCuentasContablesLineaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_devolucionCuentasContablesLineaProducto() {
		return this.resaltarid_cuenta_contable_devolucionCuentasContablesLineaProducto;
	}

	public void setResaltarid_cuenta_contable_devolucionCuentasContablesLineaProducto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_devolucionCuentasContablesLineaProducto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_devolucionCuentasContablesLineaProducto() {
		return this.mostrarid_cuenta_contable_devolucionCuentasContablesLineaProducto;
	}

	public void setMostrarid_cuenta_contable_devolucionCuentasContablesLineaProducto(Boolean mostrarid_cuenta_contable_devolucionCuentasContablesLineaProducto) {
		this.mostrarid_cuenta_contable_devolucionCuentasContablesLineaProducto= mostrarid_cuenta_contable_devolucionCuentasContablesLineaProducto;
	}

	public Boolean getActivarid_cuenta_contable_devolucionCuentasContablesLineaProducto() {
		return this.activarid_cuenta_contable_devolucionCuentasContablesLineaProducto;
	}

	public void setActivarid_cuenta_contable_devolucionCuentasContablesLineaProducto(Boolean activarid_cuenta_contable_devolucionCuentasContablesLineaProducto) {
		this.activarid_cuenta_contable_devolucionCuentasContablesLineaProducto= activarid_cuenta_contable_devolucionCuentasContablesLineaProducto;
	}

	public Boolean getCargarid_cuenta_contable_devolucionCuentasContablesLineaProducto() {
		return this.cargarid_cuenta_contable_devolucionCuentasContablesLineaProducto;
	}

	public void setCargarid_cuenta_contable_devolucionCuentasContablesLineaProducto(Boolean cargarid_cuenta_contable_devolucionCuentasContablesLineaProducto) {
		this.cargarid_cuenta_contable_devolucionCuentasContablesLineaProducto= cargarid_cuenta_contable_devolucionCuentasContablesLineaProducto;
	}

	public Border setResaltarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentascontableslineaproductoBeanSwingJInternalFrame.jTtoolBarCuentasContablesLineaProducto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto() {
		return this.resaltarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto;
	}

	public void setResaltarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto() {
		return this.mostrarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto;
	}

	public void setMostrarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto(Boolean mostrarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto) {
		this.mostrarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto= mostrarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto;
	}

	public Boolean getActivarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto() {
		return this.activarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto;
	}

	public void setActivarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto(Boolean activarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto) {
		this.activarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto= activarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto;
	}

	public Boolean getCargarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto() {
		return this.cargarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto;
	}

	public void setCargarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto(Boolean cargarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto) {
		this.cargarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto= cargarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto;
	}

	public Border setResaltarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentascontableslineaproductoBeanSwingJInternalFrame.jTtoolBarCuentasContablesLineaProducto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto() {
		return this.resaltarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto;
	}

	public void setResaltarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto() {
		return this.mostrarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto;
	}

	public void setMostrarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto(Boolean mostrarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto) {
		this.mostrarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto= mostrarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto;
	}

	public Boolean getActivarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto() {
		return this.activarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto;
	}

	public void setActivarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto(Boolean activarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto) {
		this.activarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto= activarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto;
	}

	public Boolean getCargarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto() {
		return this.cargarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto;
	}

	public void setCargarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto(Boolean cargarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto) {
		this.cargarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto= cargarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto;
	}

	public Border setResaltarid_cuenta_contable_bonificaCuentasContablesLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentascontableslineaproductoBeanSwingJInternalFrame.jTtoolBarCuentasContablesLineaProducto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_bonificaCuentasContablesLineaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_bonificaCuentasContablesLineaProducto() {
		return this.resaltarid_cuenta_contable_bonificaCuentasContablesLineaProducto;
	}

	public void setResaltarid_cuenta_contable_bonificaCuentasContablesLineaProducto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_bonificaCuentasContablesLineaProducto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_bonificaCuentasContablesLineaProducto() {
		return this.mostrarid_cuenta_contable_bonificaCuentasContablesLineaProducto;
	}

	public void setMostrarid_cuenta_contable_bonificaCuentasContablesLineaProducto(Boolean mostrarid_cuenta_contable_bonificaCuentasContablesLineaProducto) {
		this.mostrarid_cuenta_contable_bonificaCuentasContablesLineaProducto= mostrarid_cuenta_contable_bonificaCuentasContablesLineaProducto;
	}

	public Boolean getActivarid_cuenta_contable_bonificaCuentasContablesLineaProducto() {
		return this.activarid_cuenta_contable_bonificaCuentasContablesLineaProducto;
	}

	public void setActivarid_cuenta_contable_bonificaCuentasContablesLineaProducto(Boolean activarid_cuenta_contable_bonificaCuentasContablesLineaProducto) {
		this.activarid_cuenta_contable_bonificaCuentasContablesLineaProducto= activarid_cuenta_contable_bonificaCuentasContablesLineaProducto;
	}

	public Boolean getCargarid_cuenta_contable_bonificaCuentasContablesLineaProducto() {
		return this.cargarid_cuenta_contable_bonificaCuentasContablesLineaProducto;
	}

	public void setCargarid_cuenta_contable_bonificaCuentasContablesLineaProducto(Boolean cargarid_cuenta_contable_bonificaCuentasContablesLineaProducto) {
		this.cargarid_cuenta_contable_bonificaCuentasContablesLineaProducto= cargarid_cuenta_contable_bonificaCuentasContablesLineaProducto;
	}

	public Border setResaltarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentascontableslineaproductoBeanSwingJInternalFrame.jTtoolBarCuentasContablesLineaProducto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto() {
		return this.resaltarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto;
	}

	public void setResaltarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto() {
		return this.mostrarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto;
	}

	public void setMostrarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto(Boolean mostrarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto) {
		this.mostrarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto= mostrarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto;
	}

	public Boolean getActivarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto() {
		return this.activarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto;
	}

	public void setActivarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto(Boolean activarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto) {
		this.activarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto= activarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto;
	}

	public Boolean getCargarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto() {
		return this.cargarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto;
	}

	public void setCargarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto(Boolean cargarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto) {
		this.cargarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto= cargarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto;
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
		
		
		this.setMostraridCuentasContablesLineaProducto(esInicial);
		this.setMostrarid_empresaCuentasContablesLineaProducto(esInicial);
		this.setMostrarid_bodegaCuentasContablesLineaProducto(esInicial);
		this.setMostrarid_centro_costoCuentasContablesLineaProducto(esInicial);
		this.setMostrarid_lineaCuentasContablesLineaProducto(esInicial);
		this.setMostrarid_linea_grupoCuentasContablesLineaProducto(esInicial);
		this.setMostrarid_linea_categoriaCuentasContablesLineaProducto(esInicial);
		this.setMostrarid_cuenta_contable_inventarioCuentasContablesLineaProducto(esInicial);
		this.setMostrarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto(esInicial);
		this.setMostrarid_cuenta_contable_ventaCuentasContablesLineaProducto(esInicial);
		this.setMostrarid_cuenta_contable_descuentoCuentasContablesLineaProducto(esInicial);
		this.setMostrarid_cuenta_contable_produccionCuentasContablesLineaProducto(esInicial);
		this.setMostrarid_cuenta_contable_devolucionCuentasContablesLineaProducto(esInicial);
		this.setMostrarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto(esInicial);
		this.setMostrarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto(esInicial);
		this.setMostrarid_cuenta_contable_bonificaCuentasContablesLineaProducto(esInicial);
		this.setMostrarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.ID)) {
				this.setMostraridCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {
				this.setMostrarid_cuenta_contable_inventarioCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA)) {
				this.setMostrarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEVENTA)) {
				this.setMostrarid_cuenta_contable_ventaCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {
				this.setMostrarid_cuenta_contable_descuentoCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION)) {
				this.setMostrarid_cuenta_contable_produccionCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {
				this.setMostrarid_cuenta_contable_devolucionCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVADEBITO)) {
				this.setMostrarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVACREDITO)) {
				this.setMostrarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEBONIFICA)) {
				this.setMostrarid_cuenta_contable_bonificaCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA)) {
				this.setMostrarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto(esAsigna);
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
		
		
		this.setActivaridCuentasContablesLineaProducto(esInicial);
		this.setActivarid_empresaCuentasContablesLineaProducto(esInicial);
		this.setActivarid_bodegaCuentasContablesLineaProducto(esInicial);
		this.setActivarid_centro_costoCuentasContablesLineaProducto(esInicial);
		this.setActivarid_lineaCuentasContablesLineaProducto(esInicial);
		this.setActivarid_linea_grupoCuentasContablesLineaProducto(esInicial);
		this.setActivarid_linea_categoriaCuentasContablesLineaProducto(esInicial);
		this.setActivarid_cuenta_contable_inventarioCuentasContablesLineaProducto(esInicial);
		this.setActivarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto(esInicial);
		this.setActivarid_cuenta_contable_ventaCuentasContablesLineaProducto(esInicial);
		this.setActivarid_cuenta_contable_descuentoCuentasContablesLineaProducto(esInicial);
		this.setActivarid_cuenta_contable_produccionCuentasContablesLineaProducto(esInicial);
		this.setActivarid_cuenta_contable_devolucionCuentasContablesLineaProducto(esInicial);
		this.setActivarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto(esInicial);
		this.setActivarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto(esInicial);
		this.setActivarid_cuenta_contable_bonificaCuentasContablesLineaProducto(esInicial);
		this.setActivarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.ID)) {
				this.setActivaridCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {
				this.setActivarid_cuenta_contable_inventarioCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA)) {
				this.setActivarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEVENTA)) {
				this.setActivarid_cuenta_contable_ventaCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {
				this.setActivarid_cuenta_contable_descuentoCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION)) {
				this.setActivarid_cuenta_contable_produccionCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {
				this.setActivarid_cuenta_contable_devolucionCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVADEBITO)) {
				this.setActivarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVACREDITO)) {
				this.setActivarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEBONIFICA)) {
				this.setActivarid_cuenta_contable_bonificaCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA)) {
				this.setActivarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCuentasContablesLineaProducto(esInicial);
		this.setResaltarid_empresaCuentasContablesLineaProducto(esInicial);
		this.setResaltarid_bodegaCuentasContablesLineaProducto(esInicial);
		this.setResaltarid_centro_costoCuentasContablesLineaProducto(esInicial);
		this.setResaltarid_lineaCuentasContablesLineaProducto(esInicial);
		this.setResaltarid_linea_grupoCuentasContablesLineaProducto(esInicial);
		this.setResaltarid_linea_categoriaCuentasContablesLineaProducto(esInicial);
		this.setResaltarid_cuenta_contable_inventarioCuentasContablesLineaProducto(esInicial);
		this.setResaltarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto(esInicial);
		this.setResaltarid_cuenta_contable_ventaCuentasContablesLineaProducto(esInicial);
		this.setResaltarid_cuenta_contable_descuentoCuentasContablesLineaProducto(esInicial);
		this.setResaltarid_cuenta_contable_produccionCuentasContablesLineaProducto(esInicial);
		this.setResaltarid_cuenta_contable_devolucionCuentasContablesLineaProducto(esInicial);
		this.setResaltarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto(esInicial);
		this.setResaltarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto(esInicial);
		this.setResaltarid_cuenta_contable_bonificaCuentasContablesLineaProducto(esInicial);
		this.setResaltarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.ID)) {
				this.setResaltaridCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {
				this.setResaltarid_cuenta_contable_inventarioCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA)) {
				this.setResaltarid_cuenta_contable_costo_ventaCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEVENTA)) {
				this.setResaltarid_cuenta_contable_ventaCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {
				this.setResaltarid_cuenta_contable_descuentoCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION)) {
				this.setResaltarid_cuenta_contable_produccionCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {
				this.setResaltarid_cuenta_contable_devolucionCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVADEBITO)) {
				this.setResaltarid_cuenta_contable_iva_debitoCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVACREDITO)) {
				this.setResaltarid_cuenta_contable_iva_creditoCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEBONIFICA)) {
				this.setResaltarid_cuenta_contable_bonificaCuentasContablesLineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA)) {
				this.setResaltarid_cuenta_contable_costo_bonificaCuentasContablesLineaProducto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaCuentasContablesLineaProducto=true;

	public Boolean getMostrarFK_IdBodegaCuentasContablesLineaProducto() {
		return this.mostrarFK_IdBodegaCuentasContablesLineaProducto;
	}

	public void setMostrarFK_IdBodegaCuentasContablesLineaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaCuentasContablesLineaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoCuentasContablesLineaProducto=true;

	public Boolean getMostrarFK_IdCentroCostoCuentasContablesLineaProducto() {
		return this.mostrarFK_IdCentroCostoCuentasContablesLineaProducto;
	}

	public void setMostrarFK_IdCentroCostoCuentasContablesLineaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoCuentasContablesLineaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCuentasContablesLineaProducto=true;

	public Boolean getMostrarFK_IdEmpresaCuentasContablesLineaProducto() {
		return this.mostrarFK_IdEmpresaCuentasContablesLineaProducto;
	}

	public void setMostrarFK_IdEmpresaCuentasContablesLineaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCuentasContablesLineaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaCuentasContablesLineaProducto=true;

	public Boolean getMostrarFK_IdLineaCuentasContablesLineaProducto() {
		return this.mostrarFK_IdLineaCuentasContablesLineaProducto;
	}

	public void setMostrarFK_IdLineaCuentasContablesLineaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaCuentasContablesLineaProducto= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaCuentasContablesLineaProducto=true;

	public Boolean getActivarFK_IdBodegaCuentasContablesLineaProducto() {
		return this.activarFK_IdBodegaCuentasContablesLineaProducto;
	}

	public void setActivarFK_IdBodegaCuentasContablesLineaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaCuentasContablesLineaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoCuentasContablesLineaProducto=true;

	public Boolean getActivarFK_IdCentroCostoCuentasContablesLineaProducto() {
		return this.activarFK_IdCentroCostoCuentasContablesLineaProducto;
	}

	public void setActivarFK_IdCentroCostoCuentasContablesLineaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoCuentasContablesLineaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCuentasContablesLineaProducto=true;

	public Boolean getActivarFK_IdEmpresaCuentasContablesLineaProducto() {
		return this.activarFK_IdEmpresaCuentasContablesLineaProducto;
	}

	public void setActivarFK_IdEmpresaCuentasContablesLineaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCuentasContablesLineaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaCuentasContablesLineaProducto=true;

	public Boolean getActivarFK_IdLineaCuentasContablesLineaProducto() {
		return this.activarFK_IdLineaCuentasContablesLineaProducto;
	}

	public void setActivarFK_IdLineaCuentasContablesLineaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdLineaCuentasContablesLineaProducto= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaCuentasContablesLineaProducto=null;

	public Border getResaltarFK_IdBodegaCuentasContablesLineaProducto() {
		return this.resaltarFK_IdBodegaCuentasContablesLineaProducto;
	}

	public void setResaltarFK_IdBodegaCuentasContablesLineaProducto(Border borderResaltar) {
		this.resaltarFK_IdBodegaCuentasContablesLineaProducto= borderResaltar;
	}

	public void setResaltarFK_IdBodegaCuentasContablesLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaCuentasContablesLineaProducto= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoCuentasContablesLineaProducto=null;

	public Border getResaltarFK_IdCentroCostoCuentasContablesLineaProducto() {
		return this.resaltarFK_IdCentroCostoCuentasContablesLineaProducto;
	}

	public void setResaltarFK_IdCentroCostoCuentasContablesLineaProducto(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoCuentasContablesLineaProducto= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoCuentasContablesLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoCuentasContablesLineaProducto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCuentasContablesLineaProducto=null;

	public Border getResaltarFK_IdEmpresaCuentasContablesLineaProducto() {
		return this.resaltarFK_IdEmpresaCuentasContablesLineaProducto;
	}

	public void setResaltarFK_IdEmpresaCuentasContablesLineaProducto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCuentasContablesLineaProducto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCuentasContablesLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCuentasContablesLineaProducto= borderResaltar;
	}

	public Border resaltarFK_IdLineaCuentasContablesLineaProducto=null;

	public Border getResaltarFK_IdLineaCuentasContablesLineaProducto() {
		return this.resaltarFK_IdLineaCuentasContablesLineaProducto;
	}

	public void setResaltarFK_IdLineaCuentasContablesLineaProducto(Border borderResaltar) {
		this.resaltarFK_IdLineaCuentasContablesLineaProducto= borderResaltar;
	}

	public void setResaltarFK_IdLineaCuentasContablesLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CuentasContablesLineaProductoBeanSwingJInternalFrame cuentascontableslineaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaCuentasContablesLineaProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}