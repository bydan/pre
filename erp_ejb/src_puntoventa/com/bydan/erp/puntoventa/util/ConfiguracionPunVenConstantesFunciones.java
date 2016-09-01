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


import com.bydan.erp.puntoventa.util.ConfiguracionPunVenConstantesFunciones;
import com.bydan.erp.puntoventa.util.ConfiguracionPunVenParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.ConfiguracionPunVenParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ConfiguracionPunVenConstantesFunciones extends ConfiguracionPunVenConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ConfiguracionPunVen";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ConfiguracionPunVen"+ConfiguracionPunVenConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ConfiguracionPunVenHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ConfiguracionPunVenHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ConfiguracionPunVenConstantesFunciones.SCHEMA+"_"+ConfiguracionPunVenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ConfiguracionPunVenHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ConfiguracionPunVenConstantesFunciones.SCHEMA+"_"+ConfiguracionPunVenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ConfiguracionPunVenConstantesFunciones.SCHEMA+"_"+ConfiguracionPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ConfiguracionPunVenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ConfiguracionPunVenConstantesFunciones.SCHEMA+"_"+ConfiguracionPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConfiguracionPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConfiguracionPunVenHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConfiguracionPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConfiguracionPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConfiguracionPunVenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConfiguracionPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ConfiguracionPunVenConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ConfiguracionPunVenConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ConfiguracionPunVenConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ConfiguracionPunVenConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Configuracion Pun Venes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Configuracion Pun Ven";
	public static final String SCLASSWEBTITULO_LOWER="Configuracion Pun Ven";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ConfiguracionPunVen";
	public static final String OBJECTNAME="configuracionpunven";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="configuracion_pun_ven";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select configuracionpunven from "+ConfiguracionPunVenConstantesFunciones.SPERSISTENCENAME+" configuracionpunven";
	public static String QUERYSELECTNATIVE="select "+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".version_row,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_empresa,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_sucursal,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_bodega,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_cuenta_contable_efectivo,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_cuenta_contable_ice,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_cuenta_contable_otros,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_cliente_consumidor_final,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_tipo_documento_factura,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_tipo_documento_nota_venta,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_tipo_documento_nota_credito,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_tipo_documento_tarjeta_credito,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_formato_factura,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_formato_nota_venta,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_formato_nota_credito,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_transaccion_factura,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_transaccion_nota_venta,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_transaccion_nota_credito,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_transaccion_cuenta_factura,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_transaccion_cuenta_nota_venta,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_transaccion_cuenta_nota_credito from "+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME;//+" as "+ConfiguracionPunVenConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ConfiguracionPunVenConstantesFuncionesAdditional configuracionpunvenConstantesFuncionesAdditional=null;
	
	public ConfiguracionPunVenConstantesFuncionesAdditional getConfiguracionPunVenConstantesFuncionesAdditional() {
		return this.configuracionpunvenConstantesFuncionesAdditional;
	}
	
	public void setConfiguracionPunVenConstantesFuncionesAdditional(ConfiguracionPunVenConstantesFuncionesAdditional configuracionpunvenConstantesFuncionesAdditional) {
		try {
			this.configuracionpunvenConstantesFuncionesAdditional=configuracionpunvenConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDCUENTACONTABLEEFECTIVO= "id_cuenta_contable_efectivo";
    public static final String IDCUENTACONTABLEICE= "id_cuenta_contable_ice";
    public static final String IDCUENTACONTABLEOTROS= "id_cuenta_contable_otros";
    public static final String IDCLIENTECONSUMIDORFINAL= "id_cliente_consumidor_final";
    public static final String IDTIPODOCUMENTOFACTURA= "id_tipo_documento_factura";
    public static final String IDTIPODOCUMENTONOTAVENTA= "id_tipo_documento_nota_venta";
    public static final String IDTIPODOCUMENTONOTACREDITO= "id_tipo_documento_nota_credito";
    public static final String IDTIPODOCUMENTOTARJETACREDITO= "id_tipo_documento_tarjeta_credito";
    public static final String IDFORMATOFACTURA= "id_formato_factura";
    public static final String IDFORMATONOTAVENTA= "id_formato_nota_venta";
    public static final String IDFORMATONOTACREDITO= "id_formato_nota_credito";
    public static final String IDTRANSACCIONFACTURA= "id_transaccion_factura";
    public static final String IDTRANSACCIONNOTAVENTA= "id_transaccion_nota_venta";
    public static final String IDTRANSACCIONNOTACREDITO= "id_transaccion_nota_credito";
    public static final String IDTRANSACCIONCUENTAFACTURA= "id_transaccion_cuenta_factura";
    public static final String IDTRANSACCIONCUENTANOTAVENTA= "id_transaccion_cuenta_nota_venta";
    public static final String IDTRANSACCIONCUENTANOTACREDITO= "id_transaccion_cuenta_nota_credito";
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
    	public static final String LABEL_IDCUENTACONTABLEEFECTIVO= "Cta Contable Efectivo";
		public static final String LABEL_IDCUENTACONTABLEEFECTIVO_LOWER= "Cuenta Contable Efectivo";
    	public static final String LABEL_IDCUENTACONTABLEICE= "Cta Contable Ice";
		public static final String LABEL_IDCUENTACONTABLEICE_LOWER= "Cuenta Contable Ice";
    	public static final String LABEL_IDCUENTACONTABLEOTROS= "Cta Contable Otros";
		public static final String LABEL_IDCUENTACONTABLEOTROS_LOWER= "Cuenta Contable Otros";
    	public static final String LABEL_IDCLIENTECONSUMIDORFINAL= "Cliente Consumor Final";
		public static final String LABEL_IDCLIENTECONSUMIDORFINAL_LOWER= "Cliente Consumidor Final";
    	public static final String LABEL_IDTIPODOCUMENTOFACTURA= "T Documento Factura";
		public static final String LABEL_IDTIPODOCUMENTOFACTURA_LOWER= "Tipo Documento Factura";
    	public static final String LABEL_IDTIPODOCUMENTONOTAVENTA= "T Documento Nota Venta";
		public static final String LABEL_IDTIPODOCUMENTONOTAVENTA_LOWER= "Tipo Documento Nota Venta";
    	public static final String LABEL_IDTIPODOCUMENTONOTACREDITO= "T Documento Nota Credito";
		public static final String LABEL_IDTIPODOCUMENTONOTACREDITO_LOWER= "Tipo Documento Nota Credito";
    	public static final String LABEL_IDTIPODOCUMENTOTARJETACREDITO= "T Documento Tarjeta Credito";
		public static final String LABEL_IDTIPODOCUMENTOTARJETACREDITO_LOWER= "Tipo Documento Tarjeta Credito";
    	public static final String LABEL_IDFORMATOFACTURA= "Formato Factura";
		public static final String LABEL_IDFORMATOFACTURA_LOWER= "Formato Factura";
    	public static final String LABEL_IDFORMATONOTAVENTA= "Formato Nota Venta";
		public static final String LABEL_IDFORMATONOTAVENTA_LOWER= "Formato Nota Venta";
    	public static final String LABEL_IDFORMATONOTACREDITO= "Formato Nota Credito";
		public static final String LABEL_IDFORMATONOTACREDITO_LOWER= "Formato Nota Credito";
    	public static final String LABEL_IDTRANSACCIONFACTURA= "Transaccion Factura";
		public static final String LABEL_IDTRANSACCIONFACTURA_LOWER= "Transaccion Factura";
    	public static final String LABEL_IDTRANSACCIONNOTAVENTA= "Transaccion Nota Venta";
		public static final String LABEL_IDTRANSACCIONNOTAVENTA_LOWER= "Transaccion Nota Venta";
    	public static final String LABEL_IDTRANSACCIONNOTACREDITO= "Transaccion Nota Credito";
		public static final String LABEL_IDTRANSACCIONNOTACREDITO_LOWER= "Transaccion Nota Credito";
    	public static final String LABEL_IDTRANSACCIONCUENTAFACTURA= "Transaccion Cuenta Factura";
		public static final String LABEL_IDTRANSACCIONCUENTAFACTURA_LOWER= "Transaccion Cuenta Factura";
    	public static final String LABEL_IDTRANSACCIONCUENTANOTAVENTA= "Transaccion Cuenta Nota Venta";
		public static final String LABEL_IDTRANSACCIONCUENTANOTAVENTA_LOWER= "Transaccion Cuenta Nota Venta";
    	public static final String LABEL_IDTRANSACCIONCUENTANOTACREDITO= "Transaccion Cuenta Nota Credito";
		public static final String LABEL_IDTRANSACCIONCUENTANOTACREDITO_LOWER= "Transaccion Cuenta Nota Credito";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getConfiguracionPunVenLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ConfiguracionPunVenConstantesFunciones.IDEMPRESA)) {sLabelColumna=ConfiguracionPunVenConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ConfiguracionPunVenConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ConfiguracionPunVenConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ConfiguracionPunVenConstantesFunciones.IDBODEGA)) {sLabelColumna=ConfiguracionPunVenConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEEFECTIVO)) {sLabelColumna=ConfiguracionPunVenConstantesFunciones.LABEL_IDCUENTACONTABLEEFECTIVO;}
		if(sNombreColumna.equals(ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEICE)) {sLabelColumna=ConfiguracionPunVenConstantesFunciones.LABEL_IDCUENTACONTABLEICE;}
		if(sNombreColumna.equals(ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEOTROS)) {sLabelColumna=ConfiguracionPunVenConstantesFunciones.LABEL_IDCUENTACONTABLEOTROS;}
		if(sNombreColumna.equals(ConfiguracionPunVenConstantesFunciones.IDCLIENTECONSUMIDORFINAL)) {sLabelColumna=ConfiguracionPunVenConstantesFunciones.LABEL_IDCLIENTECONSUMIDORFINAL;}
		if(sNombreColumna.equals(ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOFACTURA)) {sLabelColumna=ConfiguracionPunVenConstantesFunciones.LABEL_IDTIPODOCUMENTOFACTURA;}
		if(sNombreColumna.equals(ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTAVENTA)) {sLabelColumna=ConfiguracionPunVenConstantesFunciones.LABEL_IDTIPODOCUMENTONOTAVENTA;}
		if(sNombreColumna.equals(ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTACREDITO)) {sLabelColumna=ConfiguracionPunVenConstantesFunciones.LABEL_IDTIPODOCUMENTONOTACREDITO;}
		if(sNombreColumna.equals(ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOTARJETACREDITO)) {sLabelColumna=ConfiguracionPunVenConstantesFunciones.LABEL_IDTIPODOCUMENTOTARJETACREDITO;}
		if(sNombreColumna.equals(ConfiguracionPunVenConstantesFunciones.IDFORMATOFACTURA)) {sLabelColumna=ConfiguracionPunVenConstantesFunciones.LABEL_IDFORMATOFACTURA;}
		if(sNombreColumna.equals(ConfiguracionPunVenConstantesFunciones.IDFORMATONOTAVENTA)) {sLabelColumna=ConfiguracionPunVenConstantesFunciones.LABEL_IDFORMATONOTAVENTA;}
		if(sNombreColumna.equals(ConfiguracionPunVenConstantesFunciones.IDFORMATONOTACREDITO)) {sLabelColumna=ConfiguracionPunVenConstantesFunciones.LABEL_IDFORMATONOTACREDITO;}
		if(sNombreColumna.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONFACTURA)) {sLabelColumna=ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONFACTURA;}
		if(sNombreColumna.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTAVENTA)) {sLabelColumna=ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONNOTAVENTA;}
		if(sNombreColumna.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTACREDITO)) {sLabelColumna=ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONNOTACREDITO;}
		if(sNombreColumna.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTAFACTURA)) {sLabelColumna=ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONCUENTAFACTURA;}
		if(sNombreColumna.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTAVENTA)) {sLabelColumna=ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONCUENTANOTAVENTA;}
		if(sNombreColumna.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTACREDITO)) {sLabelColumna=ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONCUENTANOTACREDITO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getConfiguracionPunVenDescripcion(ConfiguracionPunVen configuracionpunven) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(configuracionpunven !=null/* && configuracionpunven.getId()!=0*/) {
			if(configuracionpunven.getId()!=null) {
				sDescripcion=configuracionpunven.getId().toString();
			}//configuracionpunvenconfiguracionpunven.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getConfiguracionPunVenDescripcionDetallado(ConfiguracionPunVen configuracionpunven) {
		String sDescripcion="";
			
		sDescripcion+=ConfiguracionPunVenConstantesFunciones.ID+"=";
		sDescripcion+=configuracionpunven.getId().toString()+",";
		sDescripcion+=ConfiguracionPunVenConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=configuracionpunven.getVersionRow().toString()+",";
		sDescripcion+=ConfiguracionPunVenConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=configuracionpunven.getid_empresa().toString()+",";
		sDescripcion+=ConfiguracionPunVenConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=configuracionpunven.getid_sucursal().toString()+",";
		sDescripcion+=ConfiguracionPunVenConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=configuracionpunven.getid_bodega().toString()+",";
		sDescripcion+=ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEEFECTIVO+"=";
		sDescripcion+=configuracionpunven.getid_cuenta_contable_efectivo().toString()+",";
		sDescripcion+=ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEICE+"=";
		sDescripcion+=configuracionpunven.getid_cuenta_contable_ice().toString()+",";
		sDescripcion+=ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEOTROS+"=";
		sDescripcion+=configuracionpunven.getid_cuenta_contable_otros().toString()+",";
		sDescripcion+=ConfiguracionPunVenConstantesFunciones.IDCLIENTECONSUMIDORFINAL+"=";
		sDescripcion+=configuracionpunven.getid_cliente_consumidor_final().toString()+",";
		sDescripcion+=ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOFACTURA+"=";
		sDescripcion+=configuracionpunven.getid_tipo_documento_factura().toString()+",";
		sDescripcion+=ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTAVENTA+"=";
		sDescripcion+=configuracionpunven.getid_tipo_documento_nota_venta().toString()+",";
		sDescripcion+=ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTACREDITO+"=";
		sDescripcion+=configuracionpunven.getid_tipo_documento_nota_credito().toString()+",";
		sDescripcion+=ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOTARJETACREDITO+"=";
		sDescripcion+=configuracionpunven.getid_tipo_documento_tarjeta_credito().toString()+",";
		sDescripcion+=ConfiguracionPunVenConstantesFunciones.IDFORMATOFACTURA+"=";
		sDescripcion+=configuracionpunven.getid_formato_factura().toString()+",";
		sDescripcion+=ConfiguracionPunVenConstantesFunciones.IDFORMATONOTAVENTA+"=";
		sDescripcion+=configuracionpunven.getid_formato_nota_venta().toString()+",";
		sDescripcion+=ConfiguracionPunVenConstantesFunciones.IDFORMATONOTACREDITO+"=";
		sDescripcion+=configuracionpunven.getid_formato_nota_credito().toString()+",";
		sDescripcion+=ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONFACTURA+"=";
		sDescripcion+=configuracionpunven.getid_transaccion_factura().toString()+",";
		sDescripcion+=ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTAVENTA+"=";
		sDescripcion+=configuracionpunven.getid_transaccion_nota_venta().toString()+",";
		sDescripcion+=ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTACREDITO+"=";
		sDescripcion+=configuracionpunven.getid_transaccion_nota_credito().toString()+",";
		sDescripcion+=ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTAFACTURA+"=";
		sDescripcion+=configuracionpunven.getid_transaccion_cuenta_factura().toString()+",";
		sDescripcion+=ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTAVENTA+"=";
		sDescripcion+=configuracionpunven.getid_transaccion_cuenta_nota_venta().toString()+",";
		sDescripcion+=ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTACREDITO+"=";
		sDescripcion+=configuracionpunven.getid_transaccion_cuenta_nota_credito().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setConfiguracionPunVenDescripcion(ConfiguracionPunVen configuracionpunven,String sValor) throws Exception {			
		if(configuracionpunven !=null) {
			//configuracionpunvenconfiguracionpunven.getId().toString();
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

	public static String getCuentaContableEfectivoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableIceDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableOtrosDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getClienteConsumidorFinalDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getTipoDocumentoFacturaDescripcion(TipoDocumento tipodocumento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodocumento!=null/*&&tipodocumento.getId()>0*/) {
			sDescripcion=TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(tipodocumento);
		}

		return sDescripcion;
	}

	public static String getTipoDocumentoNotaVentaDescripcion(TipoDocumento tipodocumento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodocumento!=null/*&&tipodocumento.getId()>0*/) {
			sDescripcion=TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(tipodocumento);
		}

		return sDescripcion;
	}

	public static String getTipoDocumentoNotaCreditoDescripcion(TipoDocumento tipodocumento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodocumento!=null/*&&tipodocumento.getId()>0*/) {
			sDescripcion=TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(tipodocumento);
		}

		return sDescripcion;
	}

	public static String getTipoDocumentoTarjetaCreditoDescripcion(TipoDocumento tipodocumento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodocumento!=null/*&&tipodocumento.getId()>0*/) {
			sDescripcion=TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(tipodocumento);
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

	public static String getFormatoNotaVentaDescripcion(Formato formato) {
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

	public static String getTransaccionFacturaDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccionNotaVentaDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccionNotaCreditoDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccionCuentaFacturaDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccionCuentaNotaVentaDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccionCuentaNotaCreditoDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
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
		} else if(sNombreIndice.equals("FK_IdClienteConsumidorFinal")) {
			sNombreIndice="Tipo=  Por Cliente Consumor Final";
		} else if(sNombreIndice.equals("FK_IdCuentaContableEfectivo")) {
			sNombreIndice="Tipo=  Por Cta Contable Efectivo";
		} else if(sNombreIndice.equals("FK_IdCuentaContableIce")) {
			sNombreIndice="Tipo=  Por Cta Contable Ice";
		} else if(sNombreIndice.equals("FK_IdCuentaContableOtros")) {
			sNombreIndice="Tipo=  Por Cta Contable Otros";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFormatoFactura")) {
			sNombreIndice="Tipo=  Por Formato Factura";
		} else if(sNombreIndice.equals("FK_IdFormatoNotaCredito")) {
			sNombreIndice="Tipo=  Por Formato Nota Credito";
		} else if(sNombreIndice.equals("FK_IdFormatoNotaVenta")) {
			sNombreIndice="Tipo=  Por Formato Nota Venta";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoDocumentoFactura")) {
			sNombreIndice="Tipo=  Por T Documento Factura";
		} else if(sNombreIndice.equals("FK_IdTipoDocumentoNotaCredito")) {
			sNombreIndice="Tipo=  Por T Documento Nota Credito";
		} else if(sNombreIndice.equals("FK_IdTipoDocumentoNotaVenta")) {
			sNombreIndice="Tipo=  Por T Documento Nota Venta";
		} else if(sNombreIndice.equals("FK_IdTipoDocumentoTarjetaCredito")) {
			sNombreIndice="Tipo=  Por T Documento Tarjeta Credito";
		} else if(sNombreIndice.equals("FK_IdTransaccionCuentaFactura")) {
			sNombreIndice="Tipo=  Por Transaccion Cuenta Factura";
		} else if(sNombreIndice.equals("FK_IdTransaccionCuentaNotaCredito")) {
			sNombreIndice="Tipo=  Por Transaccion Cuenta Nota Credito";
		} else if(sNombreIndice.equals("FK_IdTransaccionCuentaNotaVenta")) {
			sNombreIndice="Tipo=  Por Transaccion Cuenta Nota Venta";
		} else if(sNombreIndice.equals("FK_IdTransaccionFactura")) {
			sNombreIndice="Tipo=  Por Transaccion Factura";
		} else if(sNombreIndice.equals("FK_IdTransaccionNotaCredito")) {
			sNombreIndice="Tipo=  Por Transaccion Nota Credito";
		} else if(sNombreIndice.equals("FK_IdTransaccionNotaVenta")) {
			sNombreIndice="Tipo=  Por Transaccion Nota Venta";
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

	public static String getDetalleIndiceFK_IdClienteConsumidorFinal(Long id_cliente_consumidor_final) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente_consumidor_final!=null) {sDetalleIndice+=" Codigo Unico De Cliente Consumor Final="+id_cliente_consumidor_final.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableEfectivo(Long id_cuenta_contable_efectivo) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_efectivo!=null) {sDetalleIndice+=" Codigo Unico De Cta Contable Efectivo="+id_cuenta_contable_efectivo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableIce(Long id_cuenta_contable_ice) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_ice!=null) {sDetalleIndice+=" Codigo Unico De Cta Contable Ice="+id_cuenta_contable_ice.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableOtros(Long id_cuenta_contable_otros) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_otros!=null) {sDetalleIndice+=" Codigo Unico De Cta Contable Otros="+id_cuenta_contable_otros.toString();} 

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

	public static String getDetalleIndiceFK_IdFormatoNotaCredito(Long id_formato_nota_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_nota_credito!=null) {sDetalleIndice+=" Codigo Unico De Formato Nota Credito="+id_formato_nota_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoNotaVenta(Long id_formato_nota_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_nota_venta!=null) {sDetalleIndice+=" Codigo Unico De Formato Nota Venta="+id_formato_nota_venta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDocumentoFactura(Long id_tipo_documento_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento_factura!=null) {sDetalleIndice+=" Codigo Unico De T Documento Factura="+id_tipo_documento_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDocumentoNotaCredito(Long id_tipo_documento_nota_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento_nota_credito!=null) {sDetalleIndice+=" Codigo Unico De T Documento Nota Credito="+id_tipo_documento_nota_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDocumentoNotaVenta(Long id_tipo_documento_nota_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento_nota_venta!=null) {sDetalleIndice+=" Codigo Unico De T Documento Nota Venta="+id_tipo_documento_nota_venta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDocumentoTarjetaCredito(Long id_tipo_documento_tarjeta_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento_tarjeta_credito!=null) {sDetalleIndice+=" Codigo Unico De T Documento Tarjeta Credito="+id_tipo_documento_tarjeta_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionCuentaFactura(Long id_transaccion_cuenta_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_cuenta_factura!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Cuenta Factura="+id_transaccion_cuenta_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionCuentaNotaCredito(Long id_transaccion_cuenta_nota_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_cuenta_nota_credito!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Cuenta Nota Credito="+id_transaccion_cuenta_nota_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionCuentaNotaVenta(Long id_transaccion_cuenta_nota_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_cuenta_nota_venta!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Cuenta Nota Venta="+id_transaccion_cuenta_nota_venta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionFactura(Long id_transaccion_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_factura!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Factura="+id_transaccion_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionNotaCredito(Long id_transaccion_nota_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_nota_credito!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Nota Credito="+id_transaccion_nota_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionNotaVenta(Long id_transaccion_nota_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_nota_venta!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Nota Venta="+id_transaccion_nota_venta.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosConfiguracionPunVen(ConfiguracionPunVen configuracionpunven,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosConfiguracionPunVens(List<ConfiguracionPunVen> configuracionpunvens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ConfiguracionPunVen configuracionpunven: configuracionpunvens) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConfiguracionPunVen(ConfiguracionPunVen configuracionpunven,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && configuracionpunven.getConCambioAuxiliar()) {
			configuracionpunven.setIsDeleted(configuracionpunven.getIsDeletedAuxiliar());	
			configuracionpunven.setIsNew(configuracionpunven.getIsNewAuxiliar());	
			configuracionpunven.setIsChanged(configuracionpunven.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			configuracionpunven.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			configuracionpunven.setIsDeletedAuxiliar(false);	
			configuracionpunven.setIsNewAuxiliar(false);	
			configuracionpunven.setIsChangedAuxiliar(false);
			
			configuracionpunven.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConfiguracionPunVens(List<ConfiguracionPunVen> configuracionpunvens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ConfiguracionPunVen configuracionpunven : configuracionpunvens) {
			if(conAsignarBase && configuracionpunven.getConCambioAuxiliar()) {
				configuracionpunven.setIsDeleted(configuracionpunven.getIsDeletedAuxiliar());	
				configuracionpunven.setIsNew(configuracionpunven.getIsNewAuxiliar());	
				configuracionpunven.setIsChanged(configuracionpunven.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				configuracionpunven.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				configuracionpunven.setIsDeletedAuxiliar(false);	
				configuracionpunven.setIsNewAuxiliar(false);	
				configuracionpunven.setIsChangedAuxiliar(false);
				
				configuracionpunven.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresConfiguracionPunVen(ConfiguracionPunVen configuracionpunven,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresConfiguracionPunVens(List<ConfiguracionPunVen> configuracionpunvens,Boolean conEnteros) throws Exception  {
		
		for(ConfiguracionPunVen configuracionpunven: configuracionpunvens) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaConfiguracionPunVen(List<ConfiguracionPunVen> configuracionpunvens,ConfiguracionPunVen configuracionpunvenAux) throws Exception  {
		ConfiguracionPunVenConstantesFunciones.InicializarValoresConfiguracionPunVen(configuracionpunvenAux,true);
		
		for(ConfiguracionPunVen configuracionpunven: configuracionpunvens) {
			if(configuracionpunven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesConfiguracionPunVen(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ConfiguracionPunVenConstantesFunciones.getArrayColumnasGlobalesConfiguracionPunVen(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesConfiguracionPunVen(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ConfiguracionPunVenConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ConfiguracionPunVenConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ConfiguracionPunVenConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ConfiguracionPunVenConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoConfiguracionPunVen(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ConfiguracionPunVen> configuracionpunvens,ConfiguracionPunVen configuracionpunven,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ConfiguracionPunVen configuracionpunvenAux: configuracionpunvens) {
			if(configuracionpunvenAux!=null && configuracionpunven!=null) {
				if((configuracionpunvenAux.getId()==null && configuracionpunven.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(configuracionpunvenAux.getId()!=null && configuracionpunven.getId()!=null){
					if(configuracionpunvenAux.getId().equals(configuracionpunven.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaConfiguracionPunVen(List<ConfiguracionPunVen> configuracionpunvens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ConfiguracionPunVen configuracionpunven: configuracionpunvens) {			
			if(configuracionpunven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaConfiguracionPunVen() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ConfiguracionPunVenConstantesFunciones.LABEL_ID, ConfiguracionPunVenConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConfiguracionPunVenConstantesFunciones.LABEL_VERSIONROW, ConfiguracionPunVenConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConfiguracionPunVenConstantesFunciones.LABEL_IDEMPRESA, ConfiguracionPunVenConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConfiguracionPunVenConstantesFunciones.LABEL_IDSUCURSAL, ConfiguracionPunVenConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConfiguracionPunVenConstantesFunciones.LABEL_IDBODEGA, ConfiguracionPunVenConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConfiguracionPunVenConstantesFunciones.LABEL_IDCUENTACONTABLEEFECTIVO, ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEEFECTIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConfiguracionPunVenConstantesFunciones.LABEL_IDCUENTACONTABLEICE, ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConfiguracionPunVenConstantesFunciones.LABEL_IDCUENTACONTABLEOTROS, ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEOTROS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConfiguracionPunVenConstantesFunciones.LABEL_IDCLIENTECONSUMIDORFINAL, ConfiguracionPunVenConstantesFunciones.IDCLIENTECONSUMIDORFINAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConfiguracionPunVenConstantesFunciones.LABEL_IDTIPODOCUMENTOFACTURA, ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConfiguracionPunVenConstantesFunciones.LABEL_IDTIPODOCUMENTONOTAVENTA, ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConfiguracionPunVenConstantesFunciones.LABEL_IDTIPODOCUMENTONOTACREDITO, ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConfiguracionPunVenConstantesFunciones.LABEL_IDTIPODOCUMENTOTARJETACREDITO, ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOTARJETACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConfiguracionPunVenConstantesFunciones.LABEL_IDFORMATOFACTURA, ConfiguracionPunVenConstantesFunciones.IDFORMATOFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConfiguracionPunVenConstantesFunciones.LABEL_IDFORMATONOTAVENTA, ConfiguracionPunVenConstantesFunciones.IDFORMATONOTAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConfiguracionPunVenConstantesFunciones.LABEL_IDFORMATONOTACREDITO, ConfiguracionPunVenConstantesFunciones.IDFORMATONOTACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONFACTURA, ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONNOTAVENTA, ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONNOTACREDITO, ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONCUENTAFACTURA, ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTAFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONCUENTANOTAVENTA, ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONCUENTANOTACREDITO, ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTACREDITO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasConfiguracionPunVen() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ConfiguracionPunVenConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConfiguracionPunVenConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConfiguracionPunVenConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConfiguracionPunVenConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConfiguracionPunVenConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEEFECTIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEOTROS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConfiguracionPunVenConstantesFunciones.IDCLIENTECONSUMIDORFINAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOTARJETACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConfiguracionPunVenConstantesFunciones.IDFORMATOFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConfiguracionPunVenConstantesFunciones.IDFORMATONOTAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConfiguracionPunVenConstantesFunciones.IDFORMATONOTACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTAFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTACREDITO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConfiguracionPunVen() throws Exception  {
		return ConfiguracionPunVenConstantesFunciones.getTiposSeleccionarConfiguracionPunVen(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConfiguracionPunVen(Boolean conFk) throws Exception  {
		return ConfiguracionPunVenConstantesFunciones.getTiposSeleccionarConfiguracionPunVen(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConfiguracionPunVen(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConfiguracionPunVenConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ConfiguracionPunVenConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConfiguracionPunVenConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ConfiguracionPunVenConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConfiguracionPunVenConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ConfiguracionPunVenConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConfiguracionPunVenConstantesFunciones.LABEL_IDCUENTACONTABLEEFECTIVO);
			reporte.setsDescripcion(ConfiguracionPunVenConstantesFunciones.LABEL_IDCUENTACONTABLEEFECTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConfiguracionPunVenConstantesFunciones.LABEL_IDCUENTACONTABLEICE);
			reporte.setsDescripcion(ConfiguracionPunVenConstantesFunciones.LABEL_IDCUENTACONTABLEICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConfiguracionPunVenConstantesFunciones.LABEL_IDCUENTACONTABLEOTROS);
			reporte.setsDescripcion(ConfiguracionPunVenConstantesFunciones.LABEL_IDCUENTACONTABLEOTROS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConfiguracionPunVenConstantesFunciones.LABEL_IDCLIENTECONSUMIDORFINAL);
			reporte.setsDescripcion(ConfiguracionPunVenConstantesFunciones.LABEL_IDCLIENTECONSUMIDORFINAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConfiguracionPunVenConstantesFunciones.LABEL_IDTIPODOCUMENTOFACTURA);
			reporte.setsDescripcion(ConfiguracionPunVenConstantesFunciones.LABEL_IDTIPODOCUMENTOFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConfiguracionPunVenConstantesFunciones.LABEL_IDTIPODOCUMENTONOTAVENTA);
			reporte.setsDescripcion(ConfiguracionPunVenConstantesFunciones.LABEL_IDTIPODOCUMENTONOTAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConfiguracionPunVenConstantesFunciones.LABEL_IDTIPODOCUMENTONOTACREDITO);
			reporte.setsDescripcion(ConfiguracionPunVenConstantesFunciones.LABEL_IDTIPODOCUMENTONOTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConfiguracionPunVenConstantesFunciones.LABEL_IDTIPODOCUMENTOTARJETACREDITO);
			reporte.setsDescripcion(ConfiguracionPunVenConstantesFunciones.LABEL_IDTIPODOCUMENTOTARJETACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConfiguracionPunVenConstantesFunciones.LABEL_IDFORMATOFACTURA);
			reporte.setsDescripcion(ConfiguracionPunVenConstantesFunciones.LABEL_IDFORMATOFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConfiguracionPunVenConstantesFunciones.LABEL_IDFORMATONOTAVENTA);
			reporte.setsDescripcion(ConfiguracionPunVenConstantesFunciones.LABEL_IDFORMATONOTAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConfiguracionPunVenConstantesFunciones.LABEL_IDFORMATONOTACREDITO);
			reporte.setsDescripcion(ConfiguracionPunVenConstantesFunciones.LABEL_IDFORMATONOTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONFACTURA);
			reporte.setsDescripcion(ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONNOTAVENTA);
			reporte.setsDescripcion(ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONNOTAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONNOTACREDITO);
			reporte.setsDescripcion(ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONNOTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONCUENTAFACTURA);
			reporte.setsDescripcion(ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONCUENTAFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONCUENTANOTAVENTA);
			reporte.setsDescripcion(ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONCUENTANOTAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONCUENTANOTACREDITO);
			reporte.setsDescripcion(ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONCUENTANOTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesConfiguracionPunVen(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesConfiguracionPunVen(ConfiguracionPunVen configuracionpunvenAux) throws Exception {
		
			configuracionpunvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(configuracionpunvenAux.getEmpresa()));
			configuracionpunvenAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(configuracionpunvenAux.getSucursal()));
			configuracionpunvenAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(configuracionpunvenAux.getBodega()));
			configuracionpunvenAux.setcuentacontableefectivo_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(configuracionpunvenAux.getCuentaContableEfectivo()));
			configuracionpunvenAux.setcuentacontableice_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(configuracionpunvenAux.getCuentaContableIce()));
			configuracionpunvenAux.setcuentacontableotros_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(configuracionpunvenAux.getCuentaContableOtros()));
			configuracionpunvenAux.setclienteconsumidorfinal_descripcion(ClienteConstantesFunciones.getClienteDescripcion(configuracionpunvenAux.getClienteConsumidorFinal()));
			configuracionpunvenAux.settipodocumentofactura_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(configuracionpunvenAux.getTipoDocumentoFactura()));
			configuracionpunvenAux.settipodocumentonotaventa_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(configuracionpunvenAux.getTipoDocumentoNotaVenta()));
			configuracionpunvenAux.settipodocumentonotacredito_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(configuracionpunvenAux.getTipoDocumentoNotaCredito()));
			configuracionpunvenAux.settipodocumentotarjetacredito_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(configuracionpunvenAux.getTipoDocumentoTarjetaCredito()));
			configuracionpunvenAux.setformatofactura_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(configuracionpunvenAux.getFormatoFactura()));
			configuracionpunvenAux.setformatonotaventa_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(configuracionpunvenAux.getFormatoNotaVenta()));
			configuracionpunvenAux.setformatonotacredito_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(configuracionpunvenAux.getFormatoNotaCredito()));
			configuracionpunvenAux.settransaccionfactura_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(configuracionpunvenAux.getTransaccionFactura()));
			configuracionpunvenAux.settransaccionnotaventa_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(configuracionpunvenAux.getTransaccionNotaVenta()));
			configuracionpunvenAux.settransaccionnotacredito_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(configuracionpunvenAux.getTransaccionNotaCredito()));
			configuracionpunvenAux.settransaccioncuentafactura_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(configuracionpunvenAux.getTransaccionCuentaFactura()));
			configuracionpunvenAux.settransaccioncuentanotaventa_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(configuracionpunvenAux.getTransaccionCuentaNotaVenta()));
			configuracionpunvenAux.settransaccioncuentanotacredito_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(configuracionpunvenAux.getTransaccionCuentaNotaCredito()));		
	}
	
	public static void refrescarForeignKeysDescripcionesConfiguracionPunVen(List<ConfiguracionPunVen> configuracionpunvensTemp) throws Exception {
		for(ConfiguracionPunVen configuracionpunvenAux:configuracionpunvensTemp) {
			
			configuracionpunvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(configuracionpunvenAux.getEmpresa()));
			configuracionpunvenAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(configuracionpunvenAux.getSucursal()));
			configuracionpunvenAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(configuracionpunvenAux.getBodega()));
			configuracionpunvenAux.setcuentacontableefectivo_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(configuracionpunvenAux.getCuentaContableEfectivo()));
			configuracionpunvenAux.setcuentacontableice_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(configuracionpunvenAux.getCuentaContableIce()));
			configuracionpunvenAux.setcuentacontableotros_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(configuracionpunvenAux.getCuentaContableOtros()));
			configuracionpunvenAux.setclienteconsumidorfinal_descripcion(ClienteConstantesFunciones.getClienteDescripcion(configuracionpunvenAux.getClienteConsumidorFinal()));
			configuracionpunvenAux.settipodocumentofactura_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(configuracionpunvenAux.getTipoDocumentoFactura()));
			configuracionpunvenAux.settipodocumentonotaventa_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(configuracionpunvenAux.getTipoDocumentoNotaVenta()));
			configuracionpunvenAux.settipodocumentonotacredito_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(configuracionpunvenAux.getTipoDocumentoNotaCredito()));
			configuracionpunvenAux.settipodocumentotarjetacredito_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(configuracionpunvenAux.getTipoDocumentoTarjetaCredito()));
			configuracionpunvenAux.setformatofactura_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(configuracionpunvenAux.getFormatoFactura()));
			configuracionpunvenAux.setformatonotaventa_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(configuracionpunvenAux.getFormatoNotaVenta()));
			configuracionpunvenAux.setformatonotacredito_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(configuracionpunvenAux.getFormatoNotaCredito()));
			configuracionpunvenAux.settransaccionfactura_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(configuracionpunvenAux.getTransaccionFactura()));
			configuracionpunvenAux.settransaccionnotaventa_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(configuracionpunvenAux.getTransaccionNotaVenta()));
			configuracionpunvenAux.settransaccionnotacredito_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(configuracionpunvenAux.getTransaccionNotaCredito()));
			configuracionpunvenAux.settransaccioncuentafactura_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(configuracionpunvenAux.getTransaccionCuentaFactura()));
			configuracionpunvenAux.settransaccioncuentanotaventa_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(configuracionpunvenAux.getTransaccionCuentaNotaVenta()));
			configuracionpunvenAux.settransaccioncuentanotacredito_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(configuracionpunvenAux.getTransaccionCuentaNotaCredito()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfConfiguracionPunVen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoDocumento.class));
				classes.add(new Classe(TipoDocumento.class));
				classes.add(new Classe(TipoDocumento.class));
				classes.add(new Classe(TipoDocumento.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				
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
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDocumento.class)) {
						classes.add(new Classe(TipoDocumento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDocumento.class)) {
						classes.add(new Classe(TipoDocumento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDocumento.class)) {
						classes.add(new Classe(TipoDocumento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDocumento.class)) {
						classes.add(new Classe(TipoDocumento.class));
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
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfConfiguracionPunVen(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
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

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
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

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
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

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfConfiguracionPunVen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConfiguracionPunVenConstantesFunciones.getClassesRelationshipsOfConfiguracionPunVen(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConfiguracionPunVen(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConfiguracionPunVen(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConfiguracionPunVenConstantesFunciones.getClassesRelationshipsFromStringsOfConfiguracionPunVen(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConfiguracionPunVen(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ConfiguracionPunVen configuracionpunven,List<ConfiguracionPunVen> configuracionpunvens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ConfiguracionPunVen configuracionpunvenEncontrado=null;
			
			for(ConfiguracionPunVen configuracionpunvenLocal:configuracionpunvens) {
				if(configuracionpunvenLocal.getId().equals(configuracionpunven.getId())) {
					configuracionpunvenEncontrado=configuracionpunvenLocal;
					
					configuracionpunvenLocal.setIsChanged(configuracionpunven.getIsChanged());
					configuracionpunvenLocal.setIsNew(configuracionpunven.getIsNew());
					configuracionpunvenLocal.setIsDeleted(configuracionpunven.getIsDeleted());
					
					configuracionpunvenLocal.setGeneralEntityOriginal(configuracionpunven.getGeneralEntityOriginal());
					
					configuracionpunvenLocal.setId(configuracionpunven.getId());	
					configuracionpunvenLocal.setVersionRow(configuracionpunven.getVersionRow());	
					configuracionpunvenLocal.setid_empresa(configuracionpunven.getid_empresa());	
					configuracionpunvenLocal.setid_sucursal(configuracionpunven.getid_sucursal());	
					configuracionpunvenLocal.setid_bodega(configuracionpunven.getid_bodega());	
					configuracionpunvenLocal.setid_cuenta_contable_efectivo(configuracionpunven.getid_cuenta_contable_efectivo());	
					configuracionpunvenLocal.setid_cuenta_contable_ice(configuracionpunven.getid_cuenta_contable_ice());	
					configuracionpunvenLocal.setid_cuenta_contable_otros(configuracionpunven.getid_cuenta_contable_otros());	
					configuracionpunvenLocal.setid_cliente_consumidor_final(configuracionpunven.getid_cliente_consumidor_final());	
					configuracionpunvenLocal.setid_tipo_documento_factura(configuracionpunven.getid_tipo_documento_factura());	
					configuracionpunvenLocal.setid_tipo_documento_nota_venta(configuracionpunven.getid_tipo_documento_nota_venta());	
					configuracionpunvenLocal.setid_tipo_documento_nota_credito(configuracionpunven.getid_tipo_documento_nota_credito());	
					configuracionpunvenLocal.setid_tipo_documento_tarjeta_credito(configuracionpunven.getid_tipo_documento_tarjeta_credito());	
					configuracionpunvenLocal.setid_formato_factura(configuracionpunven.getid_formato_factura());	
					configuracionpunvenLocal.setid_formato_nota_venta(configuracionpunven.getid_formato_nota_venta());	
					configuracionpunvenLocal.setid_formato_nota_credito(configuracionpunven.getid_formato_nota_credito());	
					configuracionpunvenLocal.setid_transaccion_factura(configuracionpunven.getid_transaccion_factura());	
					configuracionpunvenLocal.setid_transaccion_nota_venta(configuracionpunven.getid_transaccion_nota_venta());	
					configuracionpunvenLocal.setid_transaccion_nota_credito(configuracionpunven.getid_transaccion_nota_credito());	
					configuracionpunvenLocal.setid_transaccion_cuenta_factura(configuracionpunven.getid_transaccion_cuenta_factura());	
					configuracionpunvenLocal.setid_transaccion_cuenta_nota_venta(configuracionpunven.getid_transaccion_cuenta_nota_venta());	
					configuracionpunvenLocal.setid_transaccion_cuenta_nota_credito(configuracionpunven.getid_transaccion_cuenta_nota_credito());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!configuracionpunven.getIsDeleted()) {
				if(!existe) {
					configuracionpunvens.add(configuracionpunven);
				}
			} else {
				if(configuracionpunvenEncontrado!=null && permiteQuitar)  {
					configuracionpunvens.remove(configuracionpunvenEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ConfiguracionPunVen configuracionpunven,List<ConfiguracionPunVen> configuracionpunvens) throws Exception {
		try	{			
			for(ConfiguracionPunVen configuracionpunvenLocal:configuracionpunvens) {
				if(configuracionpunvenLocal.getId().equals(configuracionpunven.getId())) {
					configuracionpunvenLocal.setIsSelected(configuracionpunven.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesConfiguracionPunVen(List<ConfiguracionPunVen> configuracionpunvensAux) throws Exception {
		//this.configuracionpunvensAux=configuracionpunvensAux;
		
		for(ConfiguracionPunVen configuracionpunvenAux:configuracionpunvensAux) {
			if(configuracionpunvenAux.getIsChanged()) {
				configuracionpunvenAux.setIsChanged(false);
			}		
			
			if(configuracionpunvenAux.getIsNew()) {
				configuracionpunvenAux.setIsNew(false);
			}	
			
			if(configuracionpunvenAux.getIsDeleted()) {
				configuracionpunvenAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesConfiguracionPunVen(ConfiguracionPunVen configuracionpunvenAux) throws Exception {
		//this.configuracionpunvenAux=configuracionpunvenAux;
		
			if(configuracionpunvenAux.getIsChanged()) {
				configuracionpunvenAux.setIsChanged(false);
			}		
			
			if(configuracionpunvenAux.getIsNew()) {
				configuracionpunvenAux.setIsNew(false);
			}	
			
			if(configuracionpunvenAux.getIsDeleted()) {
				configuracionpunvenAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ConfiguracionPunVen configuracionpunvenAsignar,ConfiguracionPunVen configuracionpunven) throws Exception {
		configuracionpunvenAsignar.setId(configuracionpunven.getId());	
		configuracionpunvenAsignar.setVersionRow(configuracionpunven.getVersionRow());	
		configuracionpunvenAsignar.setid_empresa(configuracionpunven.getid_empresa());
		configuracionpunvenAsignar.setempresa_descripcion(configuracionpunven.getempresa_descripcion());	
		configuracionpunvenAsignar.setid_sucursal(configuracionpunven.getid_sucursal());
		configuracionpunvenAsignar.setsucursal_descripcion(configuracionpunven.getsucursal_descripcion());	
		configuracionpunvenAsignar.setid_bodega(configuracionpunven.getid_bodega());
		configuracionpunvenAsignar.setbodega_descripcion(configuracionpunven.getbodega_descripcion());	
		configuracionpunvenAsignar.setid_cuenta_contable_efectivo(configuracionpunven.getid_cuenta_contable_efectivo());
		configuracionpunvenAsignar.setcuentacontableefectivo_descripcion(configuracionpunven.getcuentacontableefectivo_descripcion());	
		configuracionpunvenAsignar.setid_cuenta_contable_ice(configuracionpunven.getid_cuenta_contable_ice());
		configuracionpunvenAsignar.setcuentacontableice_descripcion(configuracionpunven.getcuentacontableice_descripcion());	
		configuracionpunvenAsignar.setid_cuenta_contable_otros(configuracionpunven.getid_cuenta_contable_otros());
		configuracionpunvenAsignar.setcuentacontableotros_descripcion(configuracionpunven.getcuentacontableotros_descripcion());	
		configuracionpunvenAsignar.setid_cliente_consumidor_final(configuracionpunven.getid_cliente_consumidor_final());
		configuracionpunvenAsignar.setclienteconsumidorfinal_descripcion(configuracionpunven.getclienteconsumidorfinal_descripcion());	
		configuracionpunvenAsignar.setid_tipo_documento_factura(configuracionpunven.getid_tipo_documento_factura());
		configuracionpunvenAsignar.settipodocumentofactura_descripcion(configuracionpunven.gettipodocumentofactura_descripcion());	
		configuracionpunvenAsignar.setid_tipo_documento_nota_venta(configuracionpunven.getid_tipo_documento_nota_venta());
		configuracionpunvenAsignar.settipodocumentonotaventa_descripcion(configuracionpunven.gettipodocumentonotaventa_descripcion());	
		configuracionpunvenAsignar.setid_tipo_documento_nota_credito(configuracionpunven.getid_tipo_documento_nota_credito());
		configuracionpunvenAsignar.settipodocumentonotacredito_descripcion(configuracionpunven.gettipodocumentonotacredito_descripcion());	
		configuracionpunvenAsignar.setid_tipo_documento_tarjeta_credito(configuracionpunven.getid_tipo_documento_tarjeta_credito());
		configuracionpunvenAsignar.settipodocumentotarjetacredito_descripcion(configuracionpunven.gettipodocumentotarjetacredito_descripcion());	
		configuracionpunvenAsignar.setid_formato_factura(configuracionpunven.getid_formato_factura());
		configuracionpunvenAsignar.setformatofactura_descripcion(configuracionpunven.getformatofactura_descripcion());	
		configuracionpunvenAsignar.setid_formato_nota_venta(configuracionpunven.getid_formato_nota_venta());
		configuracionpunvenAsignar.setformatonotaventa_descripcion(configuracionpunven.getformatonotaventa_descripcion());	
		configuracionpunvenAsignar.setid_formato_nota_credito(configuracionpunven.getid_formato_nota_credito());
		configuracionpunvenAsignar.setformatonotacredito_descripcion(configuracionpunven.getformatonotacredito_descripcion());	
		configuracionpunvenAsignar.setid_transaccion_factura(configuracionpunven.getid_transaccion_factura());
		configuracionpunvenAsignar.settransaccionfactura_descripcion(configuracionpunven.gettransaccionfactura_descripcion());	
		configuracionpunvenAsignar.setid_transaccion_nota_venta(configuracionpunven.getid_transaccion_nota_venta());
		configuracionpunvenAsignar.settransaccionnotaventa_descripcion(configuracionpunven.gettransaccionnotaventa_descripcion());	
		configuracionpunvenAsignar.setid_transaccion_nota_credito(configuracionpunven.getid_transaccion_nota_credito());
		configuracionpunvenAsignar.settransaccionnotacredito_descripcion(configuracionpunven.gettransaccionnotacredito_descripcion());	
		configuracionpunvenAsignar.setid_transaccion_cuenta_factura(configuracionpunven.getid_transaccion_cuenta_factura());
		configuracionpunvenAsignar.settransaccioncuentafactura_descripcion(configuracionpunven.gettransaccioncuentafactura_descripcion());	
		configuracionpunvenAsignar.setid_transaccion_cuenta_nota_venta(configuracionpunven.getid_transaccion_cuenta_nota_venta());
		configuracionpunvenAsignar.settransaccioncuentanotaventa_descripcion(configuracionpunven.gettransaccioncuentanotaventa_descripcion());	
		configuracionpunvenAsignar.setid_transaccion_cuenta_nota_credito(configuracionpunven.getid_transaccion_cuenta_nota_credito());
		configuracionpunvenAsignar.settransaccioncuentanotacredito_descripcion(configuracionpunven.gettransaccioncuentanotacredito_descripcion());	
	}
	
	public static void inicializarConfiguracionPunVen(ConfiguracionPunVen configuracionpunven) throws Exception {
		try {
				configuracionpunven.setId(0L);	
					
				configuracionpunven.setid_empresa(-1L);	
				configuracionpunven.setid_sucursal(-1L);	
				configuracionpunven.setid_bodega(-1L);	
				configuracionpunven.setid_cuenta_contable_efectivo(-1L);	
				configuracionpunven.setid_cuenta_contable_ice(-1L);	
				configuracionpunven.setid_cuenta_contable_otros(-1L);	
				configuracionpunven.setid_cliente_consumidor_final(-1L);	
				configuracionpunven.setid_tipo_documento_factura(-1L);	
				configuracionpunven.setid_tipo_documento_nota_venta(-1L);	
				configuracionpunven.setid_tipo_documento_nota_credito(-1L);	
				configuracionpunven.setid_tipo_documento_tarjeta_credito(-1L);	
				configuracionpunven.setid_formato_factura(-1L);	
				configuracionpunven.setid_formato_nota_venta(-1L);	
				configuracionpunven.setid_formato_nota_credito(-1L);	
				configuracionpunven.setid_transaccion_factura(-1L);	
				configuracionpunven.setid_transaccion_nota_venta(-1L);	
				configuracionpunven.setid_transaccion_nota_credito(-1L);	
				configuracionpunven.setid_transaccion_cuenta_factura(-1L);	
				configuracionpunven.setid_transaccion_cuenta_nota_venta(-1L);	
				configuracionpunven.setid_transaccion_cuenta_nota_credito(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderConfiguracionPunVen(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ConfiguracionPunVenConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConfiguracionPunVenConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConfiguracionPunVenConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConfiguracionPunVenConstantesFunciones.LABEL_IDCUENTACONTABLEEFECTIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConfiguracionPunVenConstantesFunciones.LABEL_IDCUENTACONTABLEICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConfiguracionPunVenConstantesFunciones.LABEL_IDCUENTACONTABLEOTROS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConfiguracionPunVenConstantesFunciones.LABEL_IDCLIENTECONSUMIDORFINAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConfiguracionPunVenConstantesFunciones.LABEL_IDTIPODOCUMENTOFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConfiguracionPunVenConstantesFunciones.LABEL_IDTIPODOCUMENTONOTAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConfiguracionPunVenConstantesFunciones.LABEL_IDTIPODOCUMENTONOTACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConfiguracionPunVenConstantesFunciones.LABEL_IDTIPODOCUMENTOTARJETACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConfiguracionPunVenConstantesFunciones.LABEL_IDFORMATOFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConfiguracionPunVenConstantesFunciones.LABEL_IDFORMATONOTAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConfiguracionPunVenConstantesFunciones.LABEL_IDFORMATONOTACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONNOTAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONNOTACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONCUENTAFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONCUENTANOTAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConfiguracionPunVenConstantesFunciones.LABEL_IDTRANSACCIONCUENTANOTACREDITO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataConfiguracionPunVen(String sTipo,Row row,Workbook workbook,ConfiguracionPunVen configuracionpunven,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(configuracionpunven.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(configuracionpunven.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(configuracionpunven.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(configuracionpunven.getcuentacontableefectivo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(configuracionpunven.getcuentacontableice_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(configuracionpunven.getcuentacontableotros_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(configuracionpunven.getclienteconsumidorfinal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(configuracionpunven.gettipodocumentofactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(configuracionpunven.gettipodocumentonotaventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(configuracionpunven.gettipodocumentonotacredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(configuracionpunven.gettipodocumentotarjetacredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(configuracionpunven.getformatofactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(configuracionpunven.getformatonotaventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(configuracionpunven.getformatonotacredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(configuracionpunven.gettransaccionfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(configuracionpunven.gettransaccionnotaventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(configuracionpunven.gettransaccionnotacredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(configuracionpunven.gettransaccioncuentafactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(configuracionpunven.gettransaccioncuentanotaventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(configuracionpunven.gettransaccioncuentanotacredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryConfiguracionPunVen=Constantes.SFINALQUERY;
	
	public String getsFinalQueryConfiguracionPunVen() {
		return this.sFinalQueryConfiguracionPunVen;
	}
	
	public void setsFinalQueryConfiguracionPunVen(String sFinalQueryConfiguracionPunVen) {
		this.sFinalQueryConfiguracionPunVen= sFinalQueryConfiguracionPunVen;
	}
	
	public Border resaltarSeleccionarConfiguracionPunVen=null;
	
	public Border setResaltarSeleccionarConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//configuracionpunvenBeanSwingJInternalFrame.jTtoolBarConfiguracionPunVen.setBorder(borderResaltar);
		
		this.resaltarSeleccionarConfiguracionPunVen= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarConfiguracionPunVen() {
		return this.resaltarSeleccionarConfiguracionPunVen;
	}
	
	public void setResaltarSeleccionarConfiguracionPunVen(Border borderResaltarSeleccionarConfiguracionPunVen) {
		this.resaltarSeleccionarConfiguracionPunVen= borderResaltarSeleccionarConfiguracionPunVen;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridConfiguracionPunVen=null;
	public Boolean mostraridConfiguracionPunVen=true;
	public Boolean activaridConfiguracionPunVen=true;

	public Border resaltarid_empresaConfiguracionPunVen=null;
	public Boolean mostrarid_empresaConfiguracionPunVen=true;
	public Boolean activarid_empresaConfiguracionPunVen=true;
	public Boolean cargarid_empresaConfiguracionPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaConfiguracionPunVen=false;//ConEventDepend=true

	public Border resaltarid_sucursalConfiguracionPunVen=null;
	public Boolean mostrarid_sucursalConfiguracionPunVen=true;
	public Boolean activarid_sucursalConfiguracionPunVen=true;
	public Boolean cargarid_sucursalConfiguracionPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalConfiguracionPunVen=false;//ConEventDepend=true

	public Border resaltarid_bodegaConfiguracionPunVen=null;
	public Boolean mostrarid_bodegaConfiguracionPunVen=true;
	public Boolean activarid_bodegaConfiguracionPunVen=true;
	public Boolean cargarid_bodegaConfiguracionPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaConfiguracionPunVen=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_efectivoConfiguracionPunVen=null;
	public Boolean mostrarid_cuenta_contable_efectivoConfiguracionPunVen=true;
	public Boolean activarid_cuenta_contable_efectivoConfiguracionPunVen=true;
	public Boolean cargarid_cuenta_contable_efectivoConfiguracionPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_efectivoConfiguracionPunVen=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_iceConfiguracionPunVen=null;
	public Boolean mostrarid_cuenta_contable_iceConfiguracionPunVen=true;
	public Boolean activarid_cuenta_contable_iceConfiguracionPunVen=true;
	public Boolean cargarid_cuenta_contable_iceConfiguracionPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_iceConfiguracionPunVen=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_otrosConfiguracionPunVen=null;
	public Boolean mostrarid_cuenta_contable_otrosConfiguracionPunVen=true;
	public Boolean activarid_cuenta_contable_otrosConfiguracionPunVen=true;
	public Boolean cargarid_cuenta_contable_otrosConfiguracionPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_otrosConfiguracionPunVen=false;//ConEventDepend=true

	public Border resaltarid_cliente_consumidor_finalConfiguracionPunVen=null;
	public Boolean mostrarid_cliente_consumidor_finalConfiguracionPunVen=true;
	public Boolean activarid_cliente_consumidor_finalConfiguracionPunVen=true;
	public Boolean cargarid_cliente_consumidor_finalConfiguracionPunVen=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cliente_consumidor_finalConfiguracionPunVen=false;//ConEventDepend=true

	public Border resaltarid_tipo_documento_facturaConfiguracionPunVen=null;
	public Boolean mostrarid_tipo_documento_facturaConfiguracionPunVen=true;
	public Boolean activarid_tipo_documento_facturaConfiguracionPunVen=true;
	public Boolean cargarid_tipo_documento_facturaConfiguracionPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documento_facturaConfiguracionPunVen=false;//ConEventDepend=true

	public Border resaltarid_tipo_documento_nota_ventaConfiguracionPunVen=null;
	public Boolean mostrarid_tipo_documento_nota_ventaConfiguracionPunVen=true;
	public Boolean activarid_tipo_documento_nota_ventaConfiguracionPunVen=true;
	public Boolean cargarid_tipo_documento_nota_ventaConfiguracionPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documento_nota_ventaConfiguracionPunVen=false;//ConEventDepend=true

	public Border resaltarid_tipo_documento_nota_creditoConfiguracionPunVen=null;
	public Boolean mostrarid_tipo_documento_nota_creditoConfiguracionPunVen=true;
	public Boolean activarid_tipo_documento_nota_creditoConfiguracionPunVen=true;
	public Boolean cargarid_tipo_documento_nota_creditoConfiguracionPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documento_nota_creditoConfiguracionPunVen=false;//ConEventDepend=true

	public Border resaltarid_tipo_documento_tarjeta_creditoConfiguracionPunVen=null;
	public Boolean mostrarid_tipo_documento_tarjeta_creditoConfiguracionPunVen=true;
	public Boolean activarid_tipo_documento_tarjeta_creditoConfiguracionPunVen=true;
	public Boolean cargarid_tipo_documento_tarjeta_creditoConfiguracionPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documento_tarjeta_creditoConfiguracionPunVen=false;//ConEventDepend=true

	public Border resaltarid_formato_facturaConfiguracionPunVen=null;
	public Boolean mostrarid_formato_facturaConfiguracionPunVen=true;
	public Boolean activarid_formato_facturaConfiguracionPunVen=true;
	public Boolean cargarid_formato_facturaConfiguracionPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_facturaConfiguracionPunVen=false;//ConEventDepend=true

	public Border resaltarid_formato_nota_ventaConfiguracionPunVen=null;
	public Boolean mostrarid_formato_nota_ventaConfiguracionPunVen=true;
	public Boolean activarid_formato_nota_ventaConfiguracionPunVen=true;
	public Boolean cargarid_formato_nota_ventaConfiguracionPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_nota_ventaConfiguracionPunVen=false;//ConEventDepend=true

	public Border resaltarid_formato_nota_creditoConfiguracionPunVen=null;
	public Boolean mostrarid_formato_nota_creditoConfiguracionPunVen=true;
	public Boolean activarid_formato_nota_creditoConfiguracionPunVen=true;
	public Boolean cargarid_formato_nota_creditoConfiguracionPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_nota_creditoConfiguracionPunVen=false;//ConEventDepend=true

	public Border resaltarid_transaccion_facturaConfiguracionPunVen=null;
	public Boolean mostrarid_transaccion_facturaConfiguracionPunVen=true;
	public Boolean activarid_transaccion_facturaConfiguracionPunVen=true;
	public Boolean cargarid_transaccion_facturaConfiguracionPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_facturaConfiguracionPunVen=false;//ConEventDepend=true

	public Border resaltarid_transaccion_nota_ventaConfiguracionPunVen=null;
	public Boolean mostrarid_transaccion_nota_ventaConfiguracionPunVen=true;
	public Boolean activarid_transaccion_nota_ventaConfiguracionPunVen=true;
	public Boolean cargarid_transaccion_nota_ventaConfiguracionPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_nota_ventaConfiguracionPunVen=false;//ConEventDepend=true

	public Border resaltarid_transaccion_nota_creditoConfiguracionPunVen=null;
	public Boolean mostrarid_transaccion_nota_creditoConfiguracionPunVen=true;
	public Boolean activarid_transaccion_nota_creditoConfiguracionPunVen=true;
	public Boolean cargarid_transaccion_nota_creditoConfiguracionPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_nota_creditoConfiguracionPunVen=false;//ConEventDepend=true

	public Border resaltarid_transaccion_cuenta_facturaConfiguracionPunVen=null;
	public Boolean mostrarid_transaccion_cuenta_facturaConfiguracionPunVen=true;
	public Boolean activarid_transaccion_cuenta_facturaConfiguracionPunVen=true;
	public Boolean cargarid_transaccion_cuenta_facturaConfiguracionPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_cuenta_facturaConfiguracionPunVen=false;//ConEventDepend=true

	public Border resaltarid_transaccion_cuenta_nota_ventaConfiguracionPunVen=null;
	public Boolean mostrarid_transaccion_cuenta_nota_ventaConfiguracionPunVen=true;
	public Boolean activarid_transaccion_cuenta_nota_ventaConfiguracionPunVen=true;
	public Boolean cargarid_transaccion_cuenta_nota_ventaConfiguracionPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_cuenta_nota_ventaConfiguracionPunVen=false;//ConEventDepend=true

	public Border resaltarid_transaccion_cuenta_nota_creditoConfiguracionPunVen=null;
	public Boolean mostrarid_transaccion_cuenta_nota_creditoConfiguracionPunVen=true;
	public Boolean activarid_transaccion_cuenta_nota_creditoConfiguracionPunVen=true;
	public Boolean cargarid_transaccion_cuenta_nota_creditoConfiguracionPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_cuenta_nota_creditoConfiguracionPunVen=false;//ConEventDepend=true

	
	

	public Border setResaltaridConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//configuracionpunvenBeanSwingJInternalFrame.jTtoolBarConfiguracionPunVen.setBorder(borderResaltar);
		
		this.resaltaridConfiguracionPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridConfiguracionPunVen() {
		return this.resaltaridConfiguracionPunVen;
	}

	public void setResaltaridConfiguracionPunVen(Border borderResaltar) {
		this.resaltaridConfiguracionPunVen= borderResaltar;
	}

	public Boolean getMostraridConfiguracionPunVen() {
		return this.mostraridConfiguracionPunVen;
	}

	public void setMostraridConfiguracionPunVen(Boolean mostraridConfiguracionPunVen) {
		this.mostraridConfiguracionPunVen= mostraridConfiguracionPunVen;
	}

	public Boolean getActivaridConfiguracionPunVen() {
		return this.activaridConfiguracionPunVen;
	}

	public void setActivaridConfiguracionPunVen(Boolean activaridConfiguracionPunVen) {
		this.activaridConfiguracionPunVen= activaridConfiguracionPunVen;
	}

	public Border setResaltarid_empresaConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//configuracionpunvenBeanSwingJInternalFrame.jTtoolBarConfiguracionPunVen.setBorder(borderResaltar);
		
		this.resaltarid_empresaConfiguracionPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaConfiguracionPunVen() {
		return this.resaltarid_empresaConfiguracionPunVen;
	}

	public void setResaltarid_empresaConfiguracionPunVen(Border borderResaltar) {
		this.resaltarid_empresaConfiguracionPunVen= borderResaltar;
	}

	public Boolean getMostrarid_empresaConfiguracionPunVen() {
		return this.mostrarid_empresaConfiguracionPunVen;
	}

	public void setMostrarid_empresaConfiguracionPunVen(Boolean mostrarid_empresaConfiguracionPunVen) {
		this.mostrarid_empresaConfiguracionPunVen= mostrarid_empresaConfiguracionPunVen;
	}

	public Boolean getActivarid_empresaConfiguracionPunVen() {
		return this.activarid_empresaConfiguracionPunVen;
	}

	public void setActivarid_empresaConfiguracionPunVen(Boolean activarid_empresaConfiguracionPunVen) {
		this.activarid_empresaConfiguracionPunVen= activarid_empresaConfiguracionPunVen;
	}

	public Boolean getCargarid_empresaConfiguracionPunVen() {
		return this.cargarid_empresaConfiguracionPunVen;
	}

	public void setCargarid_empresaConfiguracionPunVen(Boolean cargarid_empresaConfiguracionPunVen) {
		this.cargarid_empresaConfiguracionPunVen= cargarid_empresaConfiguracionPunVen;
	}

	public Border setResaltarid_sucursalConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//configuracionpunvenBeanSwingJInternalFrame.jTtoolBarConfiguracionPunVen.setBorder(borderResaltar);
		
		this.resaltarid_sucursalConfiguracionPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalConfiguracionPunVen() {
		return this.resaltarid_sucursalConfiguracionPunVen;
	}

	public void setResaltarid_sucursalConfiguracionPunVen(Border borderResaltar) {
		this.resaltarid_sucursalConfiguracionPunVen= borderResaltar;
	}

	public Boolean getMostrarid_sucursalConfiguracionPunVen() {
		return this.mostrarid_sucursalConfiguracionPunVen;
	}

	public void setMostrarid_sucursalConfiguracionPunVen(Boolean mostrarid_sucursalConfiguracionPunVen) {
		this.mostrarid_sucursalConfiguracionPunVen= mostrarid_sucursalConfiguracionPunVen;
	}

	public Boolean getActivarid_sucursalConfiguracionPunVen() {
		return this.activarid_sucursalConfiguracionPunVen;
	}

	public void setActivarid_sucursalConfiguracionPunVen(Boolean activarid_sucursalConfiguracionPunVen) {
		this.activarid_sucursalConfiguracionPunVen= activarid_sucursalConfiguracionPunVen;
	}

	public Boolean getCargarid_sucursalConfiguracionPunVen() {
		return this.cargarid_sucursalConfiguracionPunVen;
	}

	public void setCargarid_sucursalConfiguracionPunVen(Boolean cargarid_sucursalConfiguracionPunVen) {
		this.cargarid_sucursalConfiguracionPunVen= cargarid_sucursalConfiguracionPunVen;
	}

	public Border setResaltarid_bodegaConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//configuracionpunvenBeanSwingJInternalFrame.jTtoolBarConfiguracionPunVen.setBorder(borderResaltar);
		
		this.resaltarid_bodegaConfiguracionPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaConfiguracionPunVen() {
		return this.resaltarid_bodegaConfiguracionPunVen;
	}

	public void setResaltarid_bodegaConfiguracionPunVen(Border borderResaltar) {
		this.resaltarid_bodegaConfiguracionPunVen= borderResaltar;
	}

	public Boolean getMostrarid_bodegaConfiguracionPunVen() {
		return this.mostrarid_bodegaConfiguracionPunVen;
	}

	public void setMostrarid_bodegaConfiguracionPunVen(Boolean mostrarid_bodegaConfiguracionPunVen) {
		this.mostrarid_bodegaConfiguracionPunVen= mostrarid_bodegaConfiguracionPunVen;
	}

	public Boolean getActivarid_bodegaConfiguracionPunVen() {
		return this.activarid_bodegaConfiguracionPunVen;
	}

	public void setActivarid_bodegaConfiguracionPunVen(Boolean activarid_bodegaConfiguracionPunVen) {
		this.activarid_bodegaConfiguracionPunVen= activarid_bodegaConfiguracionPunVen;
	}

	public Boolean getCargarid_bodegaConfiguracionPunVen() {
		return this.cargarid_bodegaConfiguracionPunVen;
	}

	public void setCargarid_bodegaConfiguracionPunVen(Boolean cargarid_bodegaConfiguracionPunVen) {
		this.cargarid_bodegaConfiguracionPunVen= cargarid_bodegaConfiguracionPunVen;
	}

	public Border setResaltarid_cuenta_contable_efectivoConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//configuracionpunvenBeanSwingJInternalFrame.jTtoolBarConfiguracionPunVen.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_efectivoConfiguracionPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_efectivoConfiguracionPunVen() {
		return this.resaltarid_cuenta_contable_efectivoConfiguracionPunVen;
	}

	public void setResaltarid_cuenta_contable_efectivoConfiguracionPunVen(Border borderResaltar) {
		this.resaltarid_cuenta_contable_efectivoConfiguracionPunVen= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_efectivoConfiguracionPunVen() {
		return this.mostrarid_cuenta_contable_efectivoConfiguracionPunVen;
	}

	public void setMostrarid_cuenta_contable_efectivoConfiguracionPunVen(Boolean mostrarid_cuenta_contable_efectivoConfiguracionPunVen) {
		this.mostrarid_cuenta_contable_efectivoConfiguracionPunVen= mostrarid_cuenta_contable_efectivoConfiguracionPunVen;
	}

	public Boolean getActivarid_cuenta_contable_efectivoConfiguracionPunVen() {
		return this.activarid_cuenta_contable_efectivoConfiguracionPunVen;
	}

	public void setActivarid_cuenta_contable_efectivoConfiguracionPunVen(Boolean activarid_cuenta_contable_efectivoConfiguracionPunVen) {
		this.activarid_cuenta_contable_efectivoConfiguracionPunVen= activarid_cuenta_contable_efectivoConfiguracionPunVen;
	}

	public Boolean getCargarid_cuenta_contable_efectivoConfiguracionPunVen() {
		return this.cargarid_cuenta_contable_efectivoConfiguracionPunVen;
	}

	public void setCargarid_cuenta_contable_efectivoConfiguracionPunVen(Boolean cargarid_cuenta_contable_efectivoConfiguracionPunVen) {
		this.cargarid_cuenta_contable_efectivoConfiguracionPunVen= cargarid_cuenta_contable_efectivoConfiguracionPunVen;
	}

	public Border setResaltarid_cuenta_contable_iceConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//configuracionpunvenBeanSwingJInternalFrame.jTtoolBarConfiguracionPunVen.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_iceConfiguracionPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_iceConfiguracionPunVen() {
		return this.resaltarid_cuenta_contable_iceConfiguracionPunVen;
	}

	public void setResaltarid_cuenta_contable_iceConfiguracionPunVen(Border borderResaltar) {
		this.resaltarid_cuenta_contable_iceConfiguracionPunVen= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_iceConfiguracionPunVen() {
		return this.mostrarid_cuenta_contable_iceConfiguracionPunVen;
	}

	public void setMostrarid_cuenta_contable_iceConfiguracionPunVen(Boolean mostrarid_cuenta_contable_iceConfiguracionPunVen) {
		this.mostrarid_cuenta_contable_iceConfiguracionPunVen= mostrarid_cuenta_contable_iceConfiguracionPunVen;
	}

	public Boolean getActivarid_cuenta_contable_iceConfiguracionPunVen() {
		return this.activarid_cuenta_contable_iceConfiguracionPunVen;
	}

	public void setActivarid_cuenta_contable_iceConfiguracionPunVen(Boolean activarid_cuenta_contable_iceConfiguracionPunVen) {
		this.activarid_cuenta_contable_iceConfiguracionPunVen= activarid_cuenta_contable_iceConfiguracionPunVen;
	}

	public Boolean getCargarid_cuenta_contable_iceConfiguracionPunVen() {
		return this.cargarid_cuenta_contable_iceConfiguracionPunVen;
	}

	public void setCargarid_cuenta_contable_iceConfiguracionPunVen(Boolean cargarid_cuenta_contable_iceConfiguracionPunVen) {
		this.cargarid_cuenta_contable_iceConfiguracionPunVen= cargarid_cuenta_contable_iceConfiguracionPunVen;
	}

	public Border setResaltarid_cuenta_contable_otrosConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//configuracionpunvenBeanSwingJInternalFrame.jTtoolBarConfiguracionPunVen.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_otrosConfiguracionPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_otrosConfiguracionPunVen() {
		return this.resaltarid_cuenta_contable_otrosConfiguracionPunVen;
	}

	public void setResaltarid_cuenta_contable_otrosConfiguracionPunVen(Border borderResaltar) {
		this.resaltarid_cuenta_contable_otrosConfiguracionPunVen= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_otrosConfiguracionPunVen() {
		return this.mostrarid_cuenta_contable_otrosConfiguracionPunVen;
	}

	public void setMostrarid_cuenta_contable_otrosConfiguracionPunVen(Boolean mostrarid_cuenta_contable_otrosConfiguracionPunVen) {
		this.mostrarid_cuenta_contable_otrosConfiguracionPunVen= mostrarid_cuenta_contable_otrosConfiguracionPunVen;
	}

	public Boolean getActivarid_cuenta_contable_otrosConfiguracionPunVen() {
		return this.activarid_cuenta_contable_otrosConfiguracionPunVen;
	}

	public void setActivarid_cuenta_contable_otrosConfiguracionPunVen(Boolean activarid_cuenta_contable_otrosConfiguracionPunVen) {
		this.activarid_cuenta_contable_otrosConfiguracionPunVen= activarid_cuenta_contable_otrosConfiguracionPunVen;
	}

	public Boolean getCargarid_cuenta_contable_otrosConfiguracionPunVen() {
		return this.cargarid_cuenta_contable_otrosConfiguracionPunVen;
	}

	public void setCargarid_cuenta_contable_otrosConfiguracionPunVen(Boolean cargarid_cuenta_contable_otrosConfiguracionPunVen) {
		this.cargarid_cuenta_contable_otrosConfiguracionPunVen= cargarid_cuenta_contable_otrosConfiguracionPunVen;
	}

	public Border setResaltarid_cliente_consumidor_finalConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//configuracionpunvenBeanSwingJInternalFrame.jTtoolBarConfiguracionPunVen.setBorder(borderResaltar);
		
		this.resaltarid_cliente_consumidor_finalConfiguracionPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cliente_consumidor_finalConfiguracionPunVen() {
		return this.resaltarid_cliente_consumidor_finalConfiguracionPunVen;
	}

	public void setResaltarid_cliente_consumidor_finalConfiguracionPunVen(Border borderResaltar) {
		this.resaltarid_cliente_consumidor_finalConfiguracionPunVen= borderResaltar;
	}

	public Boolean getMostrarid_cliente_consumidor_finalConfiguracionPunVen() {
		return this.mostrarid_cliente_consumidor_finalConfiguracionPunVen;
	}

	public void setMostrarid_cliente_consumidor_finalConfiguracionPunVen(Boolean mostrarid_cliente_consumidor_finalConfiguracionPunVen) {
		this.mostrarid_cliente_consumidor_finalConfiguracionPunVen= mostrarid_cliente_consumidor_finalConfiguracionPunVen;
	}

	public Boolean getActivarid_cliente_consumidor_finalConfiguracionPunVen() {
		return this.activarid_cliente_consumidor_finalConfiguracionPunVen;
	}

	public void setActivarid_cliente_consumidor_finalConfiguracionPunVen(Boolean activarid_cliente_consumidor_finalConfiguracionPunVen) {
		this.activarid_cliente_consumidor_finalConfiguracionPunVen= activarid_cliente_consumidor_finalConfiguracionPunVen;
	}

	public Boolean getCargarid_cliente_consumidor_finalConfiguracionPunVen() {
		return this.cargarid_cliente_consumidor_finalConfiguracionPunVen;
	}

	public void setCargarid_cliente_consumidor_finalConfiguracionPunVen(Boolean cargarid_cliente_consumidor_finalConfiguracionPunVen) {
		this.cargarid_cliente_consumidor_finalConfiguracionPunVen= cargarid_cliente_consumidor_finalConfiguracionPunVen;
	}

	public Border setResaltarid_tipo_documento_facturaConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//configuracionpunvenBeanSwingJInternalFrame.jTtoolBarConfiguracionPunVen.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documento_facturaConfiguracionPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documento_facturaConfiguracionPunVen() {
		return this.resaltarid_tipo_documento_facturaConfiguracionPunVen;
	}

	public void setResaltarid_tipo_documento_facturaConfiguracionPunVen(Border borderResaltar) {
		this.resaltarid_tipo_documento_facturaConfiguracionPunVen= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documento_facturaConfiguracionPunVen() {
		return this.mostrarid_tipo_documento_facturaConfiguracionPunVen;
	}

	public void setMostrarid_tipo_documento_facturaConfiguracionPunVen(Boolean mostrarid_tipo_documento_facturaConfiguracionPunVen) {
		this.mostrarid_tipo_documento_facturaConfiguracionPunVen= mostrarid_tipo_documento_facturaConfiguracionPunVen;
	}

	public Boolean getActivarid_tipo_documento_facturaConfiguracionPunVen() {
		return this.activarid_tipo_documento_facturaConfiguracionPunVen;
	}

	public void setActivarid_tipo_documento_facturaConfiguracionPunVen(Boolean activarid_tipo_documento_facturaConfiguracionPunVen) {
		this.activarid_tipo_documento_facturaConfiguracionPunVen= activarid_tipo_documento_facturaConfiguracionPunVen;
	}

	public Boolean getCargarid_tipo_documento_facturaConfiguracionPunVen() {
		return this.cargarid_tipo_documento_facturaConfiguracionPunVen;
	}

	public void setCargarid_tipo_documento_facturaConfiguracionPunVen(Boolean cargarid_tipo_documento_facturaConfiguracionPunVen) {
		this.cargarid_tipo_documento_facturaConfiguracionPunVen= cargarid_tipo_documento_facturaConfiguracionPunVen;
	}

	public Border setResaltarid_tipo_documento_nota_ventaConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//configuracionpunvenBeanSwingJInternalFrame.jTtoolBarConfiguracionPunVen.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documento_nota_ventaConfiguracionPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documento_nota_ventaConfiguracionPunVen() {
		return this.resaltarid_tipo_documento_nota_ventaConfiguracionPunVen;
	}

	public void setResaltarid_tipo_documento_nota_ventaConfiguracionPunVen(Border borderResaltar) {
		this.resaltarid_tipo_documento_nota_ventaConfiguracionPunVen= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documento_nota_ventaConfiguracionPunVen() {
		return this.mostrarid_tipo_documento_nota_ventaConfiguracionPunVen;
	}

	public void setMostrarid_tipo_documento_nota_ventaConfiguracionPunVen(Boolean mostrarid_tipo_documento_nota_ventaConfiguracionPunVen) {
		this.mostrarid_tipo_documento_nota_ventaConfiguracionPunVen= mostrarid_tipo_documento_nota_ventaConfiguracionPunVen;
	}

	public Boolean getActivarid_tipo_documento_nota_ventaConfiguracionPunVen() {
		return this.activarid_tipo_documento_nota_ventaConfiguracionPunVen;
	}

	public void setActivarid_tipo_documento_nota_ventaConfiguracionPunVen(Boolean activarid_tipo_documento_nota_ventaConfiguracionPunVen) {
		this.activarid_tipo_documento_nota_ventaConfiguracionPunVen= activarid_tipo_documento_nota_ventaConfiguracionPunVen;
	}

	public Boolean getCargarid_tipo_documento_nota_ventaConfiguracionPunVen() {
		return this.cargarid_tipo_documento_nota_ventaConfiguracionPunVen;
	}

	public void setCargarid_tipo_documento_nota_ventaConfiguracionPunVen(Boolean cargarid_tipo_documento_nota_ventaConfiguracionPunVen) {
		this.cargarid_tipo_documento_nota_ventaConfiguracionPunVen= cargarid_tipo_documento_nota_ventaConfiguracionPunVen;
	}

	public Border setResaltarid_tipo_documento_nota_creditoConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//configuracionpunvenBeanSwingJInternalFrame.jTtoolBarConfiguracionPunVen.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documento_nota_creditoConfiguracionPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documento_nota_creditoConfiguracionPunVen() {
		return this.resaltarid_tipo_documento_nota_creditoConfiguracionPunVen;
	}

	public void setResaltarid_tipo_documento_nota_creditoConfiguracionPunVen(Border borderResaltar) {
		this.resaltarid_tipo_documento_nota_creditoConfiguracionPunVen= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documento_nota_creditoConfiguracionPunVen() {
		return this.mostrarid_tipo_documento_nota_creditoConfiguracionPunVen;
	}

	public void setMostrarid_tipo_documento_nota_creditoConfiguracionPunVen(Boolean mostrarid_tipo_documento_nota_creditoConfiguracionPunVen) {
		this.mostrarid_tipo_documento_nota_creditoConfiguracionPunVen= mostrarid_tipo_documento_nota_creditoConfiguracionPunVen;
	}

	public Boolean getActivarid_tipo_documento_nota_creditoConfiguracionPunVen() {
		return this.activarid_tipo_documento_nota_creditoConfiguracionPunVen;
	}

	public void setActivarid_tipo_documento_nota_creditoConfiguracionPunVen(Boolean activarid_tipo_documento_nota_creditoConfiguracionPunVen) {
		this.activarid_tipo_documento_nota_creditoConfiguracionPunVen= activarid_tipo_documento_nota_creditoConfiguracionPunVen;
	}

	public Boolean getCargarid_tipo_documento_nota_creditoConfiguracionPunVen() {
		return this.cargarid_tipo_documento_nota_creditoConfiguracionPunVen;
	}

	public void setCargarid_tipo_documento_nota_creditoConfiguracionPunVen(Boolean cargarid_tipo_documento_nota_creditoConfiguracionPunVen) {
		this.cargarid_tipo_documento_nota_creditoConfiguracionPunVen= cargarid_tipo_documento_nota_creditoConfiguracionPunVen;
	}

	public Border setResaltarid_tipo_documento_tarjeta_creditoConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//configuracionpunvenBeanSwingJInternalFrame.jTtoolBarConfiguracionPunVen.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documento_tarjeta_creditoConfiguracionPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documento_tarjeta_creditoConfiguracionPunVen() {
		return this.resaltarid_tipo_documento_tarjeta_creditoConfiguracionPunVen;
	}

	public void setResaltarid_tipo_documento_tarjeta_creditoConfiguracionPunVen(Border borderResaltar) {
		this.resaltarid_tipo_documento_tarjeta_creditoConfiguracionPunVen= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documento_tarjeta_creditoConfiguracionPunVen() {
		return this.mostrarid_tipo_documento_tarjeta_creditoConfiguracionPunVen;
	}

	public void setMostrarid_tipo_documento_tarjeta_creditoConfiguracionPunVen(Boolean mostrarid_tipo_documento_tarjeta_creditoConfiguracionPunVen) {
		this.mostrarid_tipo_documento_tarjeta_creditoConfiguracionPunVen= mostrarid_tipo_documento_tarjeta_creditoConfiguracionPunVen;
	}

	public Boolean getActivarid_tipo_documento_tarjeta_creditoConfiguracionPunVen() {
		return this.activarid_tipo_documento_tarjeta_creditoConfiguracionPunVen;
	}

	public void setActivarid_tipo_documento_tarjeta_creditoConfiguracionPunVen(Boolean activarid_tipo_documento_tarjeta_creditoConfiguracionPunVen) {
		this.activarid_tipo_documento_tarjeta_creditoConfiguracionPunVen= activarid_tipo_documento_tarjeta_creditoConfiguracionPunVen;
	}

	public Boolean getCargarid_tipo_documento_tarjeta_creditoConfiguracionPunVen() {
		return this.cargarid_tipo_documento_tarjeta_creditoConfiguracionPunVen;
	}

	public void setCargarid_tipo_documento_tarjeta_creditoConfiguracionPunVen(Boolean cargarid_tipo_documento_tarjeta_creditoConfiguracionPunVen) {
		this.cargarid_tipo_documento_tarjeta_creditoConfiguracionPunVen= cargarid_tipo_documento_tarjeta_creditoConfiguracionPunVen;
	}

	public Border setResaltarid_formato_facturaConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//configuracionpunvenBeanSwingJInternalFrame.jTtoolBarConfiguracionPunVen.setBorder(borderResaltar);
		
		this.resaltarid_formato_facturaConfiguracionPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_facturaConfiguracionPunVen() {
		return this.resaltarid_formato_facturaConfiguracionPunVen;
	}

	public void setResaltarid_formato_facturaConfiguracionPunVen(Border borderResaltar) {
		this.resaltarid_formato_facturaConfiguracionPunVen= borderResaltar;
	}

	public Boolean getMostrarid_formato_facturaConfiguracionPunVen() {
		return this.mostrarid_formato_facturaConfiguracionPunVen;
	}

	public void setMostrarid_formato_facturaConfiguracionPunVen(Boolean mostrarid_formato_facturaConfiguracionPunVen) {
		this.mostrarid_formato_facturaConfiguracionPunVen= mostrarid_formato_facturaConfiguracionPunVen;
	}

	public Boolean getActivarid_formato_facturaConfiguracionPunVen() {
		return this.activarid_formato_facturaConfiguracionPunVen;
	}

	public void setActivarid_formato_facturaConfiguracionPunVen(Boolean activarid_formato_facturaConfiguracionPunVen) {
		this.activarid_formato_facturaConfiguracionPunVen= activarid_formato_facturaConfiguracionPunVen;
	}

	public Boolean getCargarid_formato_facturaConfiguracionPunVen() {
		return this.cargarid_formato_facturaConfiguracionPunVen;
	}

	public void setCargarid_formato_facturaConfiguracionPunVen(Boolean cargarid_formato_facturaConfiguracionPunVen) {
		this.cargarid_formato_facturaConfiguracionPunVen= cargarid_formato_facturaConfiguracionPunVen;
	}

	public Border setResaltarid_formato_nota_ventaConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//configuracionpunvenBeanSwingJInternalFrame.jTtoolBarConfiguracionPunVen.setBorder(borderResaltar);
		
		this.resaltarid_formato_nota_ventaConfiguracionPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_nota_ventaConfiguracionPunVen() {
		return this.resaltarid_formato_nota_ventaConfiguracionPunVen;
	}

	public void setResaltarid_formato_nota_ventaConfiguracionPunVen(Border borderResaltar) {
		this.resaltarid_formato_nota_ventaConfiguracionPunVen= borderResaltar;
	}

	public Boolean getMostrarid_formato_nota_ventaConfiguracionPunVen() {
		return this.mostrarid_formato_nota_ventaConfiguracionPunVen;
	}

	public void setMostrarid_formato_nota_ventaConfiguracionPunVen(Boolean mostrarid_formato_nota_ventaConfiguracionPunVen) {
		this.mostrarid_formato_nota_ventaConfiguracionPunVen= mostrarid_formato_nota_ventaConfiguracionPunVen;
	}

	public Boolean getActivarid_formato_nota_ventaConfiguracionPunVen() {
		return this.activarid_formato_nota_ventaConfiguracionPunVen;
	}

	public void setActivarid_formato_nota_ventaConfiguracionPunVen(Boolean activarid_formato_nota_ventaConfiguracionPunVen) {
		this.activarid_formato_nota_ventaConfiguracionPunVen= activarid_formato_nota_ventaConfiguracionPunVen;
	}

	public Boolean getCargarid_formato_nota_ventaConfiguracionPunVen() {
		return this.cargarid_formato_nota_ventaConfiguracionPunVen;
	}

	public void setCargarid_formato_nota_ventaConfiguracionPunVen(Boolean cargarid_formato_nota_ventaConfiguracionPunVen) {
		this.cargarid_formato_nota_ventaConfiguracionPunVen= cargarid_formato_nota_ventaConfiguracionPunVen;
	}

	public Border setResaltarid_formato_nota_creditoConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//configuracionpunvenBeanSwingJInternalFrame.jTtoolBarConfiguracionPunVen.setBorder(borderResaltar);
		
		this.resaltarid_formato_nota_creditoConfiguracionPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_nota_creditoConfiguracionPunVen() {
		return this.resaltarid_formato_nota_creditoConfiguracionPunVen;
	}

	public void setResaltarid_formato_nota_creditoConfiguracionPunVen(Border borderResaltar) {
		this.resaltarid_formato_nota_creditoConfiguracionPunVen= borderResaltar;
	}

	public Boolean getMostrarid_formato_nota_creditoConfiguracionPunVen() {
		return this.mostrarid_formato_nota_creditoConfiguracionPunVen;
	}

	public void setMostrarid_formato_nota_creditoConfiguracionPunVen(Boolean mostrarid_formato_nota_creditoConfiguracionPunVen) {
		this.mostrarid_formato_nota_creditoConfiguracionPunVen= mostrarid_formato_nota_creditoConfiguracionPunVen;
	}

	public Boolean getActivarid_formato_nota_creditoConfiguracionPunVen() {
		return this.activarid_formato_nota_creditoConfiguracionPunVen;
	}

	public void setActivarid_formato_nota_creditoConfiguracionPunVen(Boolean activarid_formato_nota_creditoConfiguracionPunVen) {
		this.activarid_formato_nota_creditoConfiguracionPunVen= activarid_formato_nota_creditoConfiguracionPunVen;
	}

	public Boolean getCargarid_formato_nota_creditoConfiguracionPunVen() {
		return this.cargarid_formato_nota_creditoConfiguracionPunVen;
	}

	public void setCargarid_formato_nota_creditoConfiguracionPunVen(Boolean cargarid_formato_nota_creditoConfiguracionPunVen) {
		this.cargarid_formato_nota_creditoConfiguracionPunVen= cargarid_formato_nota_creditoConfiguracionPunVen;
	}

	public Border setResaltarid_transaccion_facturaConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//configuracionpunvenBeanSwingJInternalFrame.jTtoolBarConfiguracionPunVen.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_facturaConfiguracionPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_facturaConfiguracionPunVen() {
		return this.resaltarid_transaccion_facturaConfiguracionPunVen;
	}

	public void setResaltarid_transaccion_facturaConfiguracionPunVen(Border borderResaltar) {
		this.resaltarid_transaccion_facturaConfiguracionPunVen= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_facturaConfiguracionPunVen() {
		return this.mostrarid_transaccion_facturaConfiguracionPunVen;
	}

	public void setMostrarid_transaccion_facturaConfiguracionPunVen(Boolean mostrarid_transaccion_facturaConfiguracionPunVen) {
		this.mostrarid_transaccion_facturaConfiguracionPunVen= mostrarid_transaccion_facturaConfiguracionPunVen;
	}

	public Boolean getActivarid_transaccion_facturaConfiguracionPunVen() {
		return this.activarid_transaccion_facturaConfiguracionPunVen;
	}

	public void setActivarid_transaccion_facturaConfiguracionPunVen(Boolean activarid_transaccion_facturaConfiguracionPunVen) {
		this.activarid_transaccion_facturaConfiguracionPunVen= activarid_transaccion_facturaConfiguracionPunVen;
	}

	public Boolean getCargarid_transaccion_facturaConfiguracionPunVen() {
		return this.cargarid_transaccion_facturaConfiguracionPunVen;
	}

	public void setCargarid_transaccion_facturaConfiguracionPunVen(Boolean cargarid_transaccion_facturaConfiguracionPunVen) {
		this.cargarid_transaccion_facturaConfiguracionPunVen= cargarid_transaccion_facturaConfiguracionPunVen;
	}

	public Border setResaltarid_transaccion_nota_ventaConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//configuracionpunvenBeanSwingJInternalFrame.jTtoolBarConfiguracionPunVen.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_nota_ventaConfiguracionPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_nota_ventaConfiguracionPunVen() {
		return this.resaltarid_transaccion_nota_ventaConfiguracionPunVen;
	}

	public void setResaltarid_transaccion_nota_ventaConfiguracionPunVen(Border borderResaltar) {
		this.resaltarid_transaccion_nota_ventaConfiguracionPunVen= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_nota_ventaConfiguracionPunVen() {
		return this.mostrarid_transaccion_nota_ventaConfiguracionPunVen;
	}

	public void setMostrarid_transaccion_nota_ventaConfiguracionPunVen(Boolean mostrarid_transaccion_nota_ventaConfiguracionPunVen) {
		this.mostrarid_transaccion_nota_ventaConfiguracionPunVen= mostrarid_transaccion_nota_ventaConfiguracionPunVen;
	}

	public Boolean getActivarid_transaccion_nota_ventaConfiguracionPunVen() {
		return this.activarid_transaccion_nota_ventaConfiguracionPunVen;
	}

	public void setActivarid_transaccion_nota_ventaConfiguracionPunVen(Boolean activarid_transaccion_nota_ventaConfiguracionPunVen) {
		this.activarid_transaccion_nota_ventaConfiguracionPunVen= activarid_transaccion_nota_ventaConfiguracionPunVen;
	}

	public Boolean getCargarid_transaccion_nota_ventaConfiguracionPunVen() {
		return this.cargarid_transaccion_nota_ventaConfiguracionPunVen;
	}

	public void setCargarid_transaccion_nota_ventaConfiguracionPunVen(Boolean cargarid_transaccion_nota_ventaConfiguracionPunVen) {
		this.cargarid_transaccion_nota_ventaConfiguracionPunVen= cargarid_transaccion_nota_ventaConfiguracionPunVen;
	}

	public Border setResaltarid_transaccion_nota_creditoConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//configuracionpunvenBeanSwingJInternalFrame.jTtoolBarConfiguracionPunVen.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_nota_creditoConfiguracionPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_nota_creditoConfiguracionPunVen() {
		return this.resaltarid_transaccion_nota_creditoConfiguracionPunVen;
	}

	public void setResaltarid_transaccion_nota_creditoConfiguracionPunVen(Border borderResaltar) {
		this.resaltarid_transaccion_nota_creditoConfiguracionPunVen= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_nota_creditoConfiguracionPunVen() {
		return this.mostrarid_transaccion_nota_creditoConfiguracionPunVen;
	}

	public void setMostrarid_transaccion_nota_creditoConfiguracionPunVen(Boolean mostrarid_transaccion_nota_creditoConfiguracionPunVen) {
		this.mostrarid_transaccion_nota_creditoConfiguracionPunVen= mostrarid_transaccion_nota_creditoConfiguracionPunVen;
	}

	public Boolean getActivarid_transaccion_nota_creditoConfiguracionPunVen() {
		return this.activarid_transaccion_nota_creditoConfiguracionPunVen;
	}

	public void setActivarid_transaccion_nota_creditoConfiguracionPunVen(Boolean activarid_transaccion_nota_creditoConfiguracionPunVen) {
		this.activarid_transaccion_nota_creditoConfiguracionPunVen= activarid_transaccion_nota_creditoConfiguracionPunVen;
	}

	public Boolean getCargarid_transaccion_nota_creditoConfiguracionPunVen() {
		return this.cargarid_transaccion_nota_creditoConfiguracionPunVen;
	}

	public void setCargarid_transaccion_nota_creditoConfiguracionPunVen(Boolean cargarid_transaccion_nota_creditoConfiguracionPunVen) {
		this.cargarid_transaccion_nota_creditoConfiguracionPunVen= cargarid_transaccion_nota_creditoConfiguracionPunVen;
	}

	public Border setResaltarid_transaccion_cuenta_facturaConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//configuracionpunvenBeanSwingJInternalFrame.jTtoolBarConfiguracionPunVen.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_cuenta_facturaConfiguracionPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_cuenta_facturaConfiguracionPunVen() {
		return this.resaltarid_transaccion_cuenta_facturaConfiguracionPunVen;
	}

	public void setResaltarid_transaccion_cuenta_facturaConfiguracionPunVen(Border borderResaltar) {
		this.resaltarid_transaccion_cuenta_facturaConfiguracionPunVen= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_cuenta_facturaConfiguracionPunVen() {
		return this.mostrarid_transaccion_cuenta_facturaConfiguracionPunVen;
	}

	public void setMostrarid_transaccion_cuenta_facturaConfiguracionPunVen(Boolean mostrarid_transaccion_cuenta_facturaConfiguracionPunVen) {
		this.mostrarid_transaccion_cuenta_facturaConfiguracionPunVen= mostrarid_transaccion_cuenta_facturaConfiguracionPunVen;
	}

	public Boolean getActivarid_transaccion_cuenta_facturaConfiguracionPunVen() {
		return this.activarid_transaccion_cuenta_facturaConfiguracionPunVen;
	}

	public void setActivarid_transaccion_cuenta_facturaConfiguracionPunVen(Boolean activarid_transaccion_cuenta_facturaConfiguracionPunVen) {
		this.activarid_transaccion_cuenta_facturaConfiguracionPunVen= activarid_transaccion_cuenta_facturaConfiguracionPunVen;
	}

	public Boolean getCargarid_transaccion_cuenta_facturaConfiguracionPunVen() {
		return this.cargarid_transaccion_cuenta_facturaConfiguracionPunVen;
	}

	public void setCargarid_transaccion_cuenta_facturaConfiguracionPunVen(Boolean cargarid_transaccion_cuenta_facturaConfiguracionPunVen) {
		this.cargarid_transaccion_cuenta_facturaConfiguracionPunVen= cargarid_transaccion_cuenta_facturaConfiguracionPunVen;
	}

	public Border setResaltarid_transaccion_cuenta_nota_ventaConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//configuracionpunvenBeanSwingJInternalFrame.jTtoolBarConfiguracionPunVen.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_cuenta_nota_ventaConfiguracionPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_cuenta_nota_ventaConfiguracionPunVen() {
		return this.resaltarid_transaccion_cuenta_nota_ventaConfiguracionPunVen;
	}

	public void setResaltarid_transaccion_cuenta_nota_ventaConfiguracionPunVen(Border borderResaltar) {
		this.resaltarid_transaccion_cuenta_nota_ventaConfiguracionPunVen= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_cuenta_nota_ventaConfiguracionPunVen() {
		return this.mostrarid_transaccion_cuenta_nota_ventaConfiguracionPunVen;
	}

	public void setMostrarid_transaccion_cuenta_nota_ventaConfiguracionPunVen(Boolean mostrarid_transaccion_cuenta_nota_ventaConfiguracionPunVen) {
		this.mostrarid_transaccion_cuenta_nota_ventaConfiguracionPunVen= mostrarid_transaccion_cuenta_nota_ventaConfiguracionPunVen;
	}

	public Boolean getActivarid_transaccion_cuenta_nota_ventaConfiguracionPunVen() {
		return this.activarid_transaccion_cuenta_nota_ventaConfiguracionPunVen;
	}

	public void setActivarid_transaccion_cuenta_nota_ventaConfiguracionPunVen(Boolean activarid_transaccion_cuenta_nota_ventaConfiguracionPunVen) {
		this.activarid_transaccion_cuenta_nota_ventaConfiguracionPunVen= activarid_transaccion_cuenta_nota_ventaConfiguracionPunVen;
	}

	public Boolean getCargarid_transaccion_cuenta_nota_ventaConfiguracionPunVen() {
		return this.cargarid_transaccion_cuenta_nota_ventaConfiguracionPunVen;
	}

	public void setCargarid_transaccion_cuenta_nota_ventaConfiguracionPunVen(Boolean cargarid_transaccion_cuenta_nota_ventaConfiguracionPunVen) {
		this.cargarid_transaccion_cuenta_nota_ventaConfiguracionPunVen= cargarid_transaccion_cuenta_nota_ventaConfiguracionPunVen;
	}

	public Border setResaltarid_transaccion_cuenta_nota_creditoConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//configuracionpunvenBeanSwingJInternalFrame.jTtoolBarConfiguracionPunVen.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_cuenta_nota_creditoConfiguracionPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_cuenta_nota_creditoConfiguracionPunVen() {
		return this.resaltarid_transaccion_cuenta_nota_creditoConfiguracionPunVen;
	}

	public void setResaltarid_transaccion_cuenta_nota_creditoConfiguracionPunVen(Border borderResaltar) {
		this.resaltarid_transaccion_cuenta_nota_creditoConfiguracionPunVen= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_cuenta_nota_creditoConfiguracionPunVen() {
		return this.mostrarid_transaccion_cuenta_nota_creditoConfiguracionPunVen;
	}

	public void setMostrarid_transaccion_cuenta_nota_creditoConfiguracionPunVen(Boolean mostrarid_transaccion_cuenta_nota_creditoConfiguracionPunVen) {
		this.mostrarid_transaccion_cuenta_nota_creditoConfiguracionPunVen= mostrarid_transaccion_cuenta_nota_creditoConfiguracionPunVen;
	}

	public Boolean getActivarid_transaccion_cuenta_nota_creditoConfiguracionPunVen() {
		return this.activarid_transaccion_cuenta_nota_creditoConfiguracionPunVen;
	}

	public void setActivarid_transaccion_cuenta_nota_creditoConfiguracionPunVen(Boolean activarid_transaccion_cuenta_nota_creditoConfiguracionPunVen) {
		this.activarid_transaccion_cuenta_nota_creditoConfiguracionPunVen= activarid_transaccion_cuenta_nota_creditoConfiguracionPunVen;
	}

	public Boolean getCargarid_transaccion_cuenta_nota_creditoConfiguracionPunVen() {
		return this.cargarid_transaccion_cuenta_nota_creditoConfiguracionPunVen;
	}

	public void setCargarid_transaccion_cuenta_nota_creditoConfiguracionPunVen(Boolean cargarid_transaccion_cuenta_nota_creditoConfiguracionPunVen) {
		this.cargarid_transaccion_cuenta_nota_creditoConfiguracionPunVen= cargarid_transaccion_cuenta_nota_creditoConfiguracionPunVen;
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
		
		
		this.setMostraridConfiguracionPunVen(esInicial);
		this.setMostrarid_empresaConfiguracionPunVen(esInicial);
		this.setMostrarid_sucursalConfiguracionPunVen(esInicial);
		this.setMostrarid_bodegaConfiguracionPunVen(esInicial);
		this.setMostrarid_cuenta_contable_efectivoConfiguracionPunVen(esInicial);
		this.setMostrarid_cuenta_contable_iceConfiguracionPunVen(esInicial);
		this.setMostrarid_cuenta_contable_otrosConfiguracionPunVen(esInicial);
		this.setMostrarid_cliente_consumidor_finalConfiguracionPunVen(esInicial);
		this.setMostrarid_tipo_documento_facturaConfiguracionPunVen(esInicial);
		this.setMostrarid_tipo_documento_nota_ventaConfiguracionPunVen(esInicial);
		this.setMostrarid_tipo_documento_nota_creditoConfiguracionPunVen(esInicial);
		this.setMostrarid_tipo_documento_tarjeta_creditoConfiguracionPunVen(esInicial);
		this.setMostrarid_formato_facturaConfiguracionPunVen(esInicial);
		this.setMostrarid_formato_nota_ventaConfiguracionPunVen(esInicial);
		this.setMostrarid_formato_nota_creditoConfiguracionPunVen(esInicial);
		this.setMostrarid_transaccion_facturaConfiguracionPunVen(esInicial);
		this.setMostrarid_transaccion_nota_ventaConfiguracionPunVen(esInicial);
		this.setMostrarid_transaccion_nota_creditoConfiguracionPunVen(esInicial);
		this.setMostrarid_transaccion_cuenta_facturaConfiguracionPunVen(esInicial);
		this.setMostrarid_transaccion_cuenta_nota_ventaConfiguracionPunVen(esInicial);
		this.setMostrarid_transaccion_cuenta_nota_creditoConfiguracionPunVen(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.ID)) {
				this.setMostraridConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEEFECTIVO)) {
				this.setMostrarid_cuenta_contable_efectivoConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEICE)) {
				this.setMostrarid_cuenta_contable_iceConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEOTROS)) {
				this.setMostrarid_cuenta_contable_otrosConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDCLIENTECONSUMIDORFINAL)) {
				this.setMostrarid_cliente_consumidor_finalConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOFACTURA)) {
				this.setMostrarid_tipo_documento_facturaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTAVENTA)) {
				this.setMostrarid_tipo_documento_nota_ventaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTACREDITO)) {
				this.setMostrarid_tipo_documento_nota_creditoConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOTARJETACREDITO)) {
				this.setMostrarid_tipo_documento_tarjeta_creditoConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDFORMATOFACTURA)) {
				this.setMostrarid_formato_facturaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDFORMATONOTAVENTA)) {
				this.setMostrarid_formato_nota_ventaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDFORMATONOTACREDITO)) {
				this.setMostrarid_formato_nota_creditoConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONFACTURA)) {
				this.setMostrarid_transaccion_facturaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTAVENTA)) {
				this.setMostrarid_transaccion_nota_ventaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTACREDITO)) {
				this.setMostrarid_transaccion_nota_creditoConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTAFACTURA)) {
				this.setMostrarid_transaccion_cuenta_facturaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTAVENTA)) {
				this.setMostrarid_transaccion_cuenta_nota_ventaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTACREDITO)) {
				this.setMostrarid_transaccion_cuenta_nota_creditoConfiguracionPunVen(esAsigna);
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
		
		
		this.setActivaridConfiguracionPunVen(esInicial);
		this.setActivarid_empresaConfiguracionPunVen(esInicial);
		this.setActivarid_sucursalConfiguracionPunVen(esInicial);
		this.setActivarid_bodegaConfiguracionPunVen(esInicial);
		this.setActivarid_cuenta_contable_efectivoConfiguracionPunVen(esInicial);
		this.setActivarid_cuenta_contable_iceConfiguracionPunVen(esInicial);
		this.setActivarid_cuenta_contable_otrosConfiguracionPunVen(esInicial);
		this.setActivarid_cliente_consumidor_finalConfiguracionPunVen(esInicial);
		this.setActivarid_tipo_documento_facturaConfiguracionPunVen(esInicial);
		this.setActivarid_tipo_documento_nota_ventaConfiguracionPunVen(esInicial);
		this.setActivarid_tipo_documento_nota_creditoConfiguracionPunVen(esInicial);
		this.setActivarid_tipo_documento_tarjeta_creditoConfiguracionPunVen(esInicial);
		this.setActivarid_formato_facturaConfiguracionPunVen(esInicial);
		this.setActivarid_formato_nota_ventaConfiguracionPunVen(esInicial);
		this.setActivarid_formato_nota_creditoConfiguracionPunVen(esInicial);
		this.setActivarid_transaccion_facturaConfiguracionPunVen(esInicial);
		this.setActivarid_transaccion_nota_ventaConfiguracionPunVen(esInicial);
		this.setActivarid_transaccion_nota_creditoConfiguracionPunVen(esInicial);
		this.setActivarid_transaccion_cuenta_facturaConfiguracionPunVen(esInicial);
		this.setActivarid_transaccion_cuenta_nota_ventaConfiguracionPunVen(esInicial);
		this.setActivarid_transaccion_cuenta_nota_creditoConfiguracionPunVen(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.ID)) {
				this.setActivaridConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEEFECTIVO)) {
				this.setActivarid_cuenta_contable_efectivoConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEICE)) {
				this.setActivarid_cuenta_contable_iceConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEOTROS)) {
				this.setActivarid_cuenta_contable_otrosConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDCLIENTECONSUMIDORFINAL)) {
				this.setActivarid_cliente_consumidor_finalConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOFACTURA)) {
				this.setActivarid_tipo_documento_facturaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTAVENTA)) {
				this.setActivarid_tipo_documento_nota_ventaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTACREDITO)) {
				this.setActivarid_tipo_documento_nota_creditoConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOTARJETACREDITO)) {
				this.setActivarid_tipo_documento_tarjeta_creditoConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDFORMATOFACTURA)) {
				this.setActivarid_formato_facturaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDFORMATONOTAVENTA)) {
				this.setActivarid_formato_nota_ventaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDFORMATONOTACREDITO)) {
				this.setActivarid_formato_nota_creditoConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONFACTURA)) {
				this.setActivarid_transaccion_facturaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTAVENTA)) {
				this.setActivarid_transaccion_nota_ventaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTACREDITO)) {
				this.setActivarid_transaccion_nota_creditoConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTAFACTURA)) {
				this.setActivarid_transaccion_cuenta_facturaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTAVENTA)) {
				this.setActivarid_transaccion_cuenta_nota_ventaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTACREDITO)) {
				this.setActivarid_transaccion_cuenta_nota_creditoConfiguracionPunVen(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridConfiguracionPunVen(esInicial);
		this.setResaltarid_empresaConfiguracionPunVen(esInicial);
		this.setResaltarid_sucursalConfiguracionPunVen(esInicial);
		this.setResaltarid_bodegaConfiguracionPunVen(esInicial);
		this.setResaltarid_cuenta_contable_efectivoConfiguracionPunVen(esInicial);
		this.setResaltarid_cuenta_contable_iceConfiguracionPunVen(esInicial);
		this.setResaltarid_cuenta_contable_otrosConfiguracionPunVen(esInicial);
		this.setResaltarid_cliente_consumidor_finalConfiguracionPunVen(esInicial);
		this.setResaltarid_tipo_documento_facturaConfiguracionPunVen(esInicial);
		this.setResaltarid_tipo_documento_nota_ventaConfiguracionPunVen(esInicial);
		this.setResaltarid_tipo_documento_nota_creditoConfiguracionPunVen(esInicial);
		this.setResaltarid_tipo_documento_tarjeta_creditoConfiguracionPunVen(esInicial);
		this.setResaltarid_formato_facturaConfiguracionPunVen(esInicial);
		this.setResaltarid_formato_nota_ventaConfiguracionPunVen(esInicial);
		this.setResaltarid_formato_nota_creditoConfiguracionPunVen(esInicial);
		this.setResaltarid_transaccion_facturaConfiguracionPunVen(esInicial);
		this.setResaltarid_transaccion_nota_ventaConfiguracionPunVen(esInicial);
		this.setResaltarid_transaccion_nota_creditoConfiguracionPunVen(esInicial);
		this.setResaltarid_transaccion_cuenta_facturaConfiguracionPunVen(esInicial);
		this.setResaltarid_transaccion_cuenta_nota_ventaConfiguracionPunVen(esInicial);
		this.setResaltarid_transaccion_cuenta_nota_creditoConfiguracionPunVen(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.ID)) {
				this.setResaltaridConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEEFECTIVO)) {
				this.setResaltarid_cuenta_contable_efectivoConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEICE)) {
				this.setResaltarid_cuenta_contable_iceConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEOTROS)) {
				this.setResaltarid_cuenta_contable_otrosConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDCLIENTECONSUMIDORFINAL)) {
				this.setResaltarid_cliente_consumidor_finalConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOFACTURA)) {
				this.setResaltarid_tipo_documento_facturaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTAVENTA)) {
				this.setResaltarid_tipo_documento_nota_ventaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTACREDITO)) {
				this.setResaltarid_tipo_documento_nota_creditoConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOTARJETACREDITO)) {
				this.setResaltarid_tipo_documento_tarjeta_creditoConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDFORMATOFACTURA)) {
				this.setResaltarid_formato_facturaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDFORMATONOTAVENTA)) {
				this.setResaltarid_formato_nota_ventaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDFORMATONOTACREDITO)) {
				this.setResaltarid_formato_nota_creditoConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONFACTURA)) {
				this.setResaltarid_transaccion_facturaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTAVENTA)) {
				this.setResaltarid_transaccion_nota_ventaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTACREDITO)) {
				this.setResaltarid_transaccion_nota_creditoConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTAFACTURA)) {
				this.setResaltarid_transaccion_cuenta_facturaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTAVENTA)) {
				this.setResaltarid_transaccion_cuenta_nota_ventaConfiguracionPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTACREDITO)) {
				this.setResaltarid_transaccion_cuenta_nota_creditoConfiguracionPunVen(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaConfiguracionPunVen=true;

	public Boolean getMostrarFK_IdBodegaConfiguracionPunVen() {
		return this.mostrarFK_IdBodegaConfiguracionPunVen;
	}

	public void setMostrarFK_IdBodegaConfiguracionPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaConfiguracionPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteConsumidorFinalConfiguracionPunVen=true;

	public Boolean getMostrarFK_IdClienteConsumidorFinalConfiguracionPunVen() {
		return this.mostrarFK_IdClienteConsumidorFinalConfiguracionPunVen;
	}

	public void setMostrarFK_IdClienteConsumidorFinalConfiguracionPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteConsumidorFinalConfiguracionPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableEfectivoConfiguracionPunVen=true;

	public Boolean getMostrarFK_IdCuentaContableEfectivoConfiguracionPunVen() {
		return this.mostrarFK_IdCuentaContableEfectivoConfiguracionPunVen;
	}

	public void setMostrarFK_IdCuentaContableEfectivoConfiguracionPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableEfectivoConfiguracionPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableIceConfiguracionPunVen=true;

	public Boolean getMostrarFK_IdCuentaContableIceConfiguracionPunVen() {
		return this.mostrarFK_IdCuentaContableIceConfiguracionPunVen;
	}

	public void setMostrarFK_IdCuentaContableIceConfiguracionPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableIceConfiguracionPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableOtrosConfiguracionPunVen=true;

	public Boolean getMostrarFK_IdCuentaContableOtrosConfiguracionPunVen() {
		return this.mostrarFK_IdCuentaContableOtrosConfiguracionPunVen;
	}

	public void setMostrarFK_IdCuentaContableOtrosConfiguracionPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableOtrosConfiguracionPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaConfiguracionPunVen=true;

	public Boolean getMostrarFK_IdEmpresaConfiguracionPunVen() {
		return this.mostrarFK_IdEmpresaConfiguracionPunVen;
	}

	public void setMostrarFK_IdEmpresaConfiguracionPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaConfiguracionPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoFacturaConfiguracionPunVen=true;

	public Boolean getMostrarFK_IdFormatoFacturaConfiguracionPunVen() {
		return this.mostrarFK_IdFormatoFacturaConfiguracionPunVen;
	}

	public void setMostrarFK_IdFormatoFacturaConfiguracionPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoFacturaConfiguracionPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoNotaCreditoConfiguracionPunVen=true;

	public Boolean getMostrarFK_IdFormatoNotaCreditoConfiguracionPunVen() {
		return this.mostrarFK_IdFormatoNotaCreditoConfiguracionPunVen;
	}

	public void setMostrarFK_IdFormatoNotaCreditoConfiguracionPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoNotaCreditoConfiguracionPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoNotaVentaConfiguracionPunVen=true;

	public Boolean getMostrarFK_IdFormatoNotaVentaConfiguracionPunVen() {
		return this.mostrarFK_IdFormatoNotaVentaConfiguracionPunVen;
	}

	public void setMostrarFK_IdFormatoNotaVentaConfiguracionPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoNotaVentaConfiguracionPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalConfiguracionPunVen=true;

	public Boolean getMostrarFK_IdSucursalConfiguracionPunVen() {
		return this.mostrarFK_IdSucursalConfiguracionPunVen;
	}

	public void setMostrarFK_IdSucursalConfiguracionPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalConfiguracionPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDocumentoFacturaConfiguracionPunVen=true;

	public Boolean getMostrarFK_IdTipoDocumentoFacturaConfiguracionPunVen() {
		return this.mostrarFK_IdTipoDocumentoFacturaConfiguracionPunVen;
	}

	public void setMostrarFK_IdTipoDocumentoFacturaConfiguracionPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDocumentoFacturaConfiguracionPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDocumentoNotaCreditoConfiguracionPunVen=true;

	public Boolean getMostrarFK_IdTipoDocumentoNotaCreditoConfiguracionPunVen() {
		return this.mostrarFK_IdTipoDocumentoNotaCreditoConfiguracionPunVen;
	}

	public void setMostrarFK_IdTipoDocumentoNotaCreditoConfiguracionPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDocumentoNotaCreditoConfiguracionPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDocumentoNotaVentaConfiguracionPunVen=true;

	public Boolean getMostrarFK_IdTipoDocumentoNotaVentaConfiguracionPunVen() {
		return this.mostrarFK_IdTipoDocumentoNotaVentaConfiguracionPunVen;
	}

	public void setMostrarFK_IdTipoDocumentoNotaVentaConfiguracionPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDocumentoNotaVentaConfiguracionPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDocumentoTarjetaCreditoConfiguracionPunVen=true;

	public Boolean getMostrarFK_IdTipoDocumentoTarjetaCreditoConfiguracionPunVen() {
		return this.mostrarFK_IdTipoDocumentoTarjetaCreditoConfiguracionPunVen;
	}

	public void setMostrarFK_IdTipoDocumentoTarjetaCreditoConfiguracionPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDocumentoTarjetaCreditoConfiguracionPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionCuentaFacturaConfiguracionPunVen=true;

	public Boolean getMostrarFK_IdTransaccionCuentaFacturaConfiguracionPunVen() {
		return this.mostrarFK_IdTransaccionCuentaFacturaConfiguracionPunVen;
	}

	public void setMostrarFK_IdTransaccionCuentaFacturaConfiguracionPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionCuentaFacturaConfiguracionPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionCuentaNotaCreditoConfiguracionPunVen=true;

	public Boolean getMostrarFK_IdTransaccionCuentaNotaCreditoConfiguracionPunVen() {
		return this.mostrarFK_IdTransaccionCuentaNotaCreditoConfiguracionPunVen;
	}

	public void setMostrarFK_IdTransaccionCuentaNotaCreditoConfiguracionPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionCuentaNotaCreditoConfiguracionPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionCuentaNotaVentaConfiguracionPunVen=true;

	public Boolean getMostrarFK_IdTransaccionCuentaNotaVentaConfiguracionPunVen() {
		return this.mostrarFK_IdTransaccionCuentaNotaVentaConfiguracionPunVen;
	}

	public void setMostrarFK_IdTransaccionCuentaNotaVentaConfiguracionPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionCuentaNotaVentaConfiguracionPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionFacturaConfiguracionPunVen=true;

	public Boolean getMostrarFK_IdTransaccionFacturaConfiguracionPunVen() {
		return this.mostrarFK_IdTransaccionFacturaConfiguracionPunVen;
	}

	public void setMostrarFK_IdTransaccionFacturaConfiguracionPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionFacturaConfiguracionPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionNotaCreditoConfiguracionPunVen=true;

	public Boolean getMostrarFK_IdTransaccionNotaCreditoConfiguracionPunVen() {
		return this.mostrarFK_IdTransaccionNotaCreditoConfiguracionPunVen;
	}

	public void setMostrarFK_IdTransaccionNotaCreditoConfiguracionPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionNotaCreditoConfiguracionPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionNotaVentaConfiguracionPunVen=true;

	public Boolean getMostrarFK_IdTransaccionNotaVentaConfiguracionPunVen() {
		return this.mostrarFK_IdTransaccionNotaVentaConfiguracionPunVen;
	}

	public void setMostrarFK_IdTransaccionNotaVentaConfiguracionPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionNotaVentaConfiguracionPunVen= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaConfiguracionPunVen=true;

	public Boolean getActivarFK_IdBodegaConfiguracionPunVen() {
		return this.activarFK_IdBodegaConfiguracionPunVen;
	}

	public void setActivarFK_IdBodegaConfiguracionPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaConfiguracionPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteConsumidorFinalConfiguracionPunVen=true;

	public Boolean getActivarFK_IdClienteConsumidorFinalConfiguracionPunVen() {
		return this.activarFK_IdClienteConsumidorFinalConfiguracionPunVen;
	}

	public void setActivarFK_IdClienteConsumidorFinalConfiguracionPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdClienteConsumidorFinalConfiguracionPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableEfectivoConfiguracionPunVen=true;

	public Boolean getActivarFK_IdCuentaContableEfectivoConfiguracionPunVen() {
		return this.activarFK_IdCuentaContableEfectivoConfiguracionPunVen;
	}

	public void setActivarFK_IdCuentaContableEfectivoConfiguracionPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableEfectivoConfiguracionPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableIceConfiguracionPunVen=true;

	public Boolean getActivarFK_IdCuentaContableIceConfiguracionPunVen() {
		return this.activarFK_IdCuentaContableIceConfiguracionPunVen;
	}

	public void setActivarFK_IdCuentaContableIceConfiguracionPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableIceConfiguracionPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableOtrosConfiguracionPunVen=true;

	public Boolean getActivarFK_IdCuentaContableOtrosConfiguracionPunVen() {
		return this.activarFK_IdCuentaContableOtrosConfiguracionPunVen;
	}

	public void setActivarFK_IdCuentaContableOtrosConfiguracionPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableOtrosConfiguracionPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaConfiguracionPunVen=true;

	public Boolean getActivarFK_IdEmpresaConfiguracionPunVen() {
		return this.activarFK_IdEmpresaConfiguracionPunVen;
	}

	public void setActivarFK_IdEmpresaConfiguracionPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaConfiguracionPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoFacturaConfiguracionPunVen=true;

	public Boolean getActivarFK_IdFormatoFacturaConfiguracionPunVen() {
		return this.activarFK_IdFormatoFacturaConfiguracionPunVen;
	}

	public void setActivarFK_IdFormatoFacturaConfiguracionPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoFacturaConfiguracionPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoNotaCreditoConfiguracionPunVen=true;

	public Boolean getActivarFK_IdFormatoNotaCreditoConfiguracionPunVen() {
		return this.activarFK_IdFormatoNotaCreditoConfiguracionPunVen;
	}

	public void setActivarFK_IdFormatoNotaCreditoConfiguracionPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoNotaCreditoConfiguracionPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoNotaVentaConfiguracionPunVen=true;

	public Boolean getActivarFK_IdFormatoNotaVentaConfiguracionPunVen() {
		return this.activarFK_IdFormatoNotaVentaConfiguracionPunVen;
	}

	public void setActivarFK_IdFormatoNotaVentaConfiguracionPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoNotaVentaConfiguracionPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalConfiguracionPunVen=true;

	public Boolean getActivarFK_IdSucursalConfiguracionPunVen() {
		return this.activarFK_IdSucursalConfiguracionPunVen;
	}

	public void setActivarFK_IdSucursalConfiguracionPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalConfiguracionPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDocumentoFacturaConfiguracionPunVen=true;

	public Boolean getActivarFK_IdTipoDocumentoFacturaConfiguracionPunVen() {
		return this.activarFK_IdTipoDocumentoFacturaConfiguracionPunVen;
	}

	public void setActivarFK_IdTipoDocumentoFacturaConfiguracionPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDocumentoFacturaConfiguracionPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDocumentoNotaCreditoConfiguracionPunVen=true;

	public Boolean getActivarFK_IdTipoDocumentoNotaCreditoConfiguracionPunVen() {
		return this.activarFK_IdTipoDocumentoNotaCreditoConfiguracionPunVen;
	}

	public void setActivarFK_IdTipoDocumentoNotaCreditoConfiguracionPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDocumentoNotaCreditoConfiguracionPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDocumentoNotaVentaConfiguracionPunVen=true;

	public Boolean getActivarFK_IdTipoDocumentoNotaVentaConfiguracionPunVen() {
		return this.activarFK_IdTipoDocumentoNotaVentaConfiguracionPunVen;
	}

	public void setActivarFK_IdTipoDocumentoNotaVentaConfiguracionPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDocumentoNotaVentaConfiguracionPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDocumentoTarjetaCreditoConfiguracionPunVen=true;

	public Boolean getActivarFK_IdTipoDocumentoTarjetaCreditoConfiguracionPunVen() {
		return this.activarFK_IdTipoDocumentoTarjetaCreditoConfiguracionPunVen;
	}

	public void setActivarFK_IdTipoDocumentoTarjetaCreditoConfiguracionPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDocumentoTarjetaCreditoConfiguracionPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionCuentaFacturaConfiguracionPunVen=true;

	public Boolean getActivarFK_IdTransaccionCuentaFacturaConfiguracionPunVen() {
		return this.activarFK_IdTransaccionCuentaFacturaConfiguracionPunVen;
	}

	public void setActivarFK_IdTransaccionCuentaFacturaConfiguracionPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionCuentaFacturaConfiguracionPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionCuentaNotaCreditoConfiguracionPunVen=true;

	public Boolean getActivarFK_IdTransaccionCuentaNotaCreditoConfiguracionPunVen() {
		return this.activarFK_IdTransaccionCuentaNotaCreditoConfiguracionPunVen;
	}

	public void setActivarFK_IdTransaccionCuentaNotaCreditoConfiguracionPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionCuentaNotaCreditoConfiguracionPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionCuentaNotaVentaConfiguracionPunVen=true;

	public Boolean getActivarFK_IdTransaccionCuentaNotaVentaConfiguracionPunVen() {
		return this.activarFK_IdTransaccionCuentaNotaVentaConfiguracionPunVen;
	}

	public void setActivarFK_IdTransaccionCuentaNotaVentaConfiguracionPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionCuentaNotaVentaConfiguracionPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionFacturaConfiguracionPunVen=true;

	public Boolean getActivarFK_IdTransaccionFacturaConfiguracionPunVen() {
		return this.activarFK_IdTransaccionFacturaConfiguracionPunVen;
	}

	public void setActivarFK_IdTransaccionFacturaConfiguracionPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionFacturaConfiguracionPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionNotaCreditoConfiguracionPunVen=true;

	public Boolean getActivarFK_IdTransaccionNotaCreditoConfiguracionPunVen() {
		return this.activarFK_IdTransaccionNotaCreditoConfiguracionPunVen;
	}

	public void setActivarFK_IdTransaccionNotaCreditoConfiguracionPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionNotaCreditoConfiguracionPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionNotaVentaConfiguracionPunVen=true;

	public Boolean getActivarFK_IdTransaccionNotaVentaConfiguracionPunVen() {
		return this.activarFK_IdTransaccionNotaVentaConfiguracionPunVen;
	}

	public void setActivarFK_IdTransaccionNotaVentaConfiguracionPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionNotaVentaConfiguracionPunVen= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaConfiguracionPunVen=null;

	public Border getResaltarFK_IdBodegaConfiguracionPunVen() {
		return this.resaltarFK_IdBodegaConfiguracionPunVen;
	}

	public void setResaltarFK_IdBodegaConfiguracionPunVen(Border borderResaltar) {
		this.resaltarFK_IdBodegaConfiguracionPunVen= borderResaltar;
	}

	public void setResaltarFK_IdBodegaConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaConfiguracionPunVen= borderResaltar;
	}

	public Border resaltarFK_IdClienteConsumidorFinalConfiguracionPunVen=null;

	public Border getResaltarFK_IdClienteConsumidorFinalConfiguracionPunVen() {
		return this.resaltarFK_IdClienteConsumidorFinalConfiguracionPunVen;
	}

	public void setResaltarFK_IdClienteConsumidorFinalConfiguracionPunVen(Border borderResaltar) {
		this.resaltarFK_IdClienteConsumidorFinalConfiguracionPunVen= borderResaltar;
	}

	public void setResaltarFK_IdClienteConsumidorFinalConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteConsumidorFinalConfiguracionPunVen= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableEfectivoConfiguracionPunVen=null;

	public Border getResaltarFK_IdCuentaContableEfectivoConfiguracionPunVen() {
		return this.resaltarFK_IdCuentaContableEfectivoConfiguracionPunVen;
	}

	public void setResaltarFK_IdCuentaContableEfectivoConfiguracionPunVen(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableEfectivoConfiguracionPunVen= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableEfectivoConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableEfectivoConfiguracionPunVen= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableIceConfiguracionPunVen=null;

	public Border getResaltarFK_IdCuentaContableIceConfiguracionPunVen() {
		return this.resaltarFK_IdCuentaContableIceConfiguracionPunVen;
	}

	public void setResaltarFK_IdCuentaContableIceConfiguracionPunVen(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableIceConfiguracionPunVen= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableIceConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableIceConfiguracionPunVen= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableOtrosConfiguracionPunVen=null;

	public Border getResaltarFK_IdCuentaContableOtrosConfiguracionPunVen() {
		return this.resaltarFK_IdCuentaContableOtrosConfiguracionPunVen;
	}

	public void setResaltarFK_IdCuentaContableOtrosConfiguracionPunVen(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableOtrosConfiguracionPunVen= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableOtrosConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableOtrosConfiguracionPunVen= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaConfiguracionPunVen=null;

	public Border getResaltarFK_IdEmpresaConfiguracionPunVen() {
		return this.resaltarFK_IdEmpresaConfiguracionPunVen;
	}

	public void setResaltarFK_IdEmpresaConfiguracionPunVen(Border borderResaltar) {
		this.resaltarFK_IdEmpresaConfiguracionPunVen= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaConfiguracionPunVen= borderResaltar;
	}

	public Border resaltarFK_IdFormatoFacturaConfiguracionPunVen=null;

	public Border getResaltarFK_IdFormatoFacturaConfiguracionPunVen() {
		return this.resaltarFK_IdFormatoFacturaConfiguracionPunVen;
	}

	public void setResaltarFK_IdFormatoFacturaConfiguracionPunVen(Border borderResaltar) {
		this.resaltarFK_IdFormatoFacturaConfiguracionPunVen= borderResaltar;
	}

	public void setResaltarFK_IdFormatoFacturaConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoFacturaConfiguracionPunVen= borderResaltar;
	}

	public Border resaltarFK_IdFormatoNotaCreditoConfiguracionPunVen=null;

	public Border getResaltarFK_IdFormatoNotaCreditoConfiguracionPunVen() {
		return this.resaltarFK_IdFormatoNotaCreditoConfiguracionPunVen;
	}

	public void setResaltarFK_IdFormatoNotaCreditoConfiguracionPunVen(Border borderResaltar) {
		this.resaltarFK_IdFormatoNotaCreditoConfiguracionPunVen= borderResaltar;
	}

	public void setResaltarFK_IdFormatoNotaCreditoConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoNotaCreditoConfiguracionPunVen= borderResaltar;
	}

	public Border resaltarFK_IdFormatoNotaVentaConfiguracionPunVen=null;

	public Border getResaltarFK_IdFormatoNotaVentaConfiguracionPunVen() {
		return this.resaltarFK_IdFormatoNotaVentaConfiguracionPunVen;
	}

	public void setResaltarFK_IdFormatoNotaVentaConfiguracionPunVen(Border borderResaltar) {
		this.resaltarFK_IdFormatoNotaVentaConfiguracionPunVen= borderResaltar;
	}

	public void setResaltarFK_IdFormatoNotaVentaConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoNotaVentaConfiguracionPunVen= borderResaltar;
	}

	public Border resaltarFK_IdSucursalConfiguracionPunVen=null;

	public Border getResaltarFK_IdSucursalConfiguracionPunVen() {
		return this.resaltarFK_IdSucursalConfiguracionPunVen;
	}

	public void setResaltarFK_IdSucursalConfiguracionPunVen(Border borderResaltar) {
		this.resaltarFK_IdSucursalConfiguracionPunVen= borderResaltar;
	}

	public void setResaltarFK_IdSucursalConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalConfiguracionPunVen= borderResaltar;
	}

	public Border resaltarFK_IdTipoDocumentoFacturaConfiguracionPunVen=null;

	public Border getResaltarFK_IdTipoDocumentoFacturaConfiguracionPunVen() {
		return this.resaltarFK_IdTipoDocumentoFacturaConfiguracionPunVen;
	}

	public void setResaltarFK_IdTipoDocumentoFacturaConfiguracionPunVen(Border borderResaltar) {
		this.resaltarFK_IdTipoDocumentoFacturaConfiguracionPunVen= borderResaltar;
	}

	public void setResaltarFK_IdTipoDocumentoFacturaConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDocumentoFacturaConfiguracionPunVen= borderResaltar;
	}

	public Border resaltarFK_IdTipoDocumentoNotaCreditoConfiguracionPunVen=null;

	public Border getResaltarFK_IdTipoDocumentoNotaCreditoConfiguracionPunVen() {
		return this.resaltarFK_IdTipoDocumentoNotaCreditoConfiguracionPunVen;
	}

	public void setResaltarFK_IdTipoDocumentoNotaCreditoConfiguracionPunVen(Border borderResaltar) {
		this.resaltarFK_IdTipoDocumentoNotaCreditoConfiguracionPunVen= borderResaltar;
	}

	public void setResaltarFK_IdTipoDocumentoNotaCreditoConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDocumentoNotaCreditoConfiguracionPunVen= borderResaltar;
	}

	public Border resaltarFK_IdTipoDocumentoNotaVentaConfiguracionPunVen=null;

	public Border getResaltarFK_IdTipoDocumentoNotaVentaConfiguracionPunVen() {
		return this.resaltarFK_IdTipoDocumentoNotaVentaConfiguracionPunVen;
	}

	public void setResaltarFK_IdTipoDocumentoNotaVentaConfiguracionPunVen(Border borderResaltar) {
		this.resaltarFK_IdTipoDocumentoNotaVentaConfiguracionPunVen= borderResaltar;
	}

	public void setResaltarFK_IdTipoDocumentoNotaVentaConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDocumentoNotaVentaConfiguracionPunVen= borderResaltar;
	}

	public Border resaltarFK_IdTipoDocumentoTarjetaCreditoConfiguracionPunVen=null;

	public Border getResaltarFK_IdTipoDocumentoTarjetaCreditoConfiguracionPunVen() {
		return this.resaltarFK_IdTipoDocumentoTarjetaCreditoConfiguracionPunVen;
	}

	public void setResaltarFK_IdTipoDocumentoTarjetaCreditoConfiguracionPunVen(Border borderResaltar) {
		this.resaltarFK_IdTipoDocumentoTarjetaCreditoConfiguracionPunVen= borderResaltar;
	}

	public void setResaltarFK_IdTipoDocumentoTarjetaCreditoConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDocumentoTarjetaCreditoConfiguracionPunVen= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionCuentaFacturaConfiguracionPunVen=null;

	public Border getResaltarFK_IdTransaccionCuentaFacturaConfiguracionPunVen() {
		return this.resaltarFK_IdTransaccionCuentaFacturaConfiguracionPunVen;
	}

	public void setResaltarFK_IdTransaccionCuentaFacturaConfiguracionPunVen(Border borderResaltar) {
		this.resaltarFK_IdTransaccionCuentaFacturaConfiguracionPunVen= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionCuentaFacturaConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionCuentaFacturaConfiguracionPunVen= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionCuentaNotaCreditoConfiguracionPunVen=null;

	public Border getResaltarFK_IdTransaccionCuentaNotaCreditoConfiguracionPunVen() {
		return this.resaltarFK_IdTransaccionCuentaNotaCreditoConfiguracionPunVen;
	}

	public void setResaltarFK_IdTransaccionCuentaNotaCreditoConfiguracionPunVen(Border borderResaltar) {
		this.resaltarFK_IdTransaccionCuentaNotaCreditoConfiguracionPunVen= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionCuentaNotaCreditoConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionCuentaNotaCreditoConfiguracionPunVen= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionCuentaNotaVentaConfiguracionPunVen=null;

	public Border getResaltarFK_IdTransaccionCuentaNotaVentaConfiguracionPunVen() {
		return this.resaltarFK_IdTransaccionCuentaNotaVentaConfiguracionPunVen;
	}

	public void setResaltarFK_IdTransaccionCuentaNotaVentaConfiguracionPunVen(Border borderResaltar) {
		this.resaltarFK_IdTransaccionCuentaNotaVentaConfiguracionPunVen= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionCuentaNotaVentaConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionCuentaNotaVentaConfiguracionPunVen= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionFacturaConfiguracionPunVen=null;

	public Border getResaltarFK_IdTransaccionFacturaConfiguracionPunVen() {
		return this.resaltarFK_IdTransaccionFacturaConfiguracionPunVen;
	}

	public void setResaltarFK_IdTransaccionFacturaConfiguracionPunVen(Border borderResaltar) {
		this.resaltarFK_IdTransaccionFacturaConfiguracionPunVen= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionFacturaConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionFacturaConfiguracionPunVen= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionNotaCreditoConfiguracionPunVen=null;

	public Border getResaltarFK_IdTransaccionNotaCreditoConfiguracionPunVen() {
		return this.resaltarFK_IdTransaccionNotaCreditoConfiguracionPunVen;
	}

	public void setResaltarFK_IdTransaccionNotaCreditoConfiguracionPunVen(Border borderResaltar) {
		this.resaltarFK_IdTransaccionNotaCreditoConfiguracionPunVen= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionNotaCreditoConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionNotaCreditoConfiguracionPunVen= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionNotaVentaConfiguracionPunVen=null;

	public Border getResaltarFK_IdTransaccionNotaVentaConfiguracionPunVen() {
		return this.resaltarFK_IdTransaccionNotaVentaConfiguracionPunVen;
	}

	public void setResaltarFK_IdTransaccionNotaVentaConfiguracionPunVen(Border borderResaltar) {
		this.resaltarFK_IdTransaccionNotaVentaConfiguracionPunVen= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionNotaVentaConfiguracionPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*ConfiguracionPunVenBeanSwingJInternalFrame configuracionpunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionNotaVentaConfiguracionPunVen= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}