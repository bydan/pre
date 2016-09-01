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


import com.bydan.erp.facturacion.util.ParametroFactuTransaccionConstantesFunciones;
import com.bydan.erp.facturacion.util.ParametroFactuTransaccionParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ParametroFactuTransaccionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroFactuTransaccionConstantesFunciones extends ParametroFactuTransaccionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroFactuTransaccion";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroFactuTransaccion"+ParametroFactuTransaccionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroFactuTransaccionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroFactuTransaccionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroFactuTransaccionConstantesFunciones.SCHEMA+"_"+ParametroFactuTransaccionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroFactuTransaccionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroFactuTransaccionConstantesFunciones.SCHEMA+"_"+ParametroFactuTransaccionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroFactuTransaccionConstantesFunciones.SCHEMA+"_"+ParametroFactuTransaccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroFactuTransaccionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroFactuTransaccionConstantesFunciones.SCHEMA+"_"+ParametroFactuTransaccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFactuTransaccionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroFactuTransaccionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFactuTransaccionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFactuTransaccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroFactuTransaccionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFactuTransaccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroFactuTransaccionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroFactuTransaccionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroFactuTransaccionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroFactuTransaccionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Transaccion s";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parametro Transaccion ";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Factu Transaccion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroFactuTransaccion";
	public static final String OBJECTNAME="parametrofactutransaccion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="parametro_factu_transaccion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametrofactutransaccion from "+ParametroFactuTransaccionConstantesFunciones.SPERSISTENCENAME+" parametrofactutransaccion";
	public static String QUERYSELECTNATIVE="select "+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".version_row,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id_empresa,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id_transaccion_inven_factura,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id_transaccion_inven_nota_credito,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id_transaccion_inven_nota_venta,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id_transaccion_cuenta_co_factura,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id_transaccion_cuenta_co_nota_credito,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id_transaccion_cuenta_co_nota_venta,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id_transaccion_cuenta_co_tarjeta,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id_transaccion_cuenta_pa_factura,"+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME+".id_transaccion_cuenta_pa_nota_credito from "+ParametroFactuTransaccionConstantesFunciones.SCHEMA+"."+ParametroFactuTransaccionConstantesFunciones.TABLENAME;//+" as "+ParametroFactuTransaccionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroFactuTransaccionConstantesFuncionesAdditional parametrofactutransaccionConstantesFuncionesAdditional=null;
	
	public ParametroFactuTransaccionConstantesFuncionesAdditional getParametroFactuTransaccionConstantesFuncionesAdditional() {
		return this.parametrofactutransaccionConstantesFuncionesAdditional;
	}
	
	public void setParametroFactuTransaccionConstantesFuncionesAdditional(ParametroFactuTransaccionConstantesFuncionesAdditional parametrofactutransaccionConstantesFuncionesAdditional) {
		try {
			this.parametrofactutransaccionConstantesFuncionesAdditional=parametrofactutransaccionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDTRANSACCIONINVENFACTURA= "id_transaccion_inven_factura";
    public static final String IDTRANSACCIONINVENNOTACREDITO= "id_transaccion_inven_nota_credito";
    public static final String IDTRANSACCIONINVENNOTAVENTA= "id_transaccion_inven_nota_venta";
    public static final String IDTRANSACCIONCUENTACOFACTURA= "id_transaccion_cuenta_co_factura";
    public static final String IDTRANSACCIONCUENTACONOTACREDITO= "id_transaccion_cuenta_co_nota_credito";
    public static final String IDTRANSACCIONCUENTACONOTAVENTA= "id_transaccion_cuenta_co_nota_venta";
    public static final String IDTRANSACCIONCUENTACOTARJETA= "id_transaccion_cuenta_co_tarjeta";
    public static final String IDTRANSACCIONCUENTAPAFACTURA= "id_transaccion_cuenta_pa_factura";
    public static final String IDTRANSACCIONCUENTAPANOTACREDITO= "id_transaccion_cuenta_pa_nota_credito";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDTRANSACCIONINVENFACTURA= "Facturacion.";
		public static final String LABEL_IDTRANSACCIONINVENFACTURA_LOWER= "Transaccion Inven Factura";
    	public static final String LABEL_IDTRANSACCIONINVENNOTACREDITO= "Nota De Credito.";
		public static final String LABEL_IDTRANSACCIONINVENNOTACREDITO_LOWER= "Transaccion Inven Nota Credito";
    	public static final String LABEL_IDTRANSACCIONINVENNOTAVENTA= "Nota De Venta.";
		public static final String LABEL_IDTRANSACCIONINVENNOTAVENTA_LOWER= "Transaccion Inven Nota Venta";
    	public static final String LABEL_IDTRANSACCIONCUENTACOFACTURA= "Facturacion";
		public static final String LABEL_IDTRANSACCIONCUENTACOFACTURA_LOWER= "Transaccion Cuenta Co Factura";
    	public static final String LABEL_IDTRANSACCIONCUENTACONOTACREDITO= "Nota De Credito";
		public static final String LABEL_IDTRANSACCIONCUENTACONOTACREDITO_LOWER= "Transaccion Cuenta Co Nota Credito";
    	public static final String LABEL_IDTRANSACCIONCUENTACONOTAVENTA= "Nota De Venta";
		public static final String LABEL_IDTRANSACCIONCUENTACONOTAVENTA_LOWER= "Transaccion Cuenta Co Nota Venta";
    	public static final String LABEL_IDTRANSACCIONCUENTACOTARJETA= "Tarjeta De Credito";
		public static final String LABEL_IDTRANSACCIONCUENTACOTARJETA_LOWER= "Transaccion Cuenta Co Tarjeta";
    	public static final String LABEL_IDTRANSACCIONCUENTAPAFACTURA= "Facturacion_";
		public static final String LABEL_IDTRANSACCIONCUENTAPAFACTURA_LOWER= "Transaccion Cuenta Pa Factura";
    	public static final String LABEL_IDTRANSACCIONCUENTAPANOTACREDITO= "Nota De Credito_";
		public static final String LABEL_IDTRANSACCIONCUENTAPANOTACREDITO_LOWER= "Transaccion Cuenta Pa Nota Credito";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getParametroFactuTransaccionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroFactuTransaccionConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroFactuTransaccionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroFactuTransaccionConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ParametroFactuTransaccionConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENFACTURA)) {sLabelColumna=ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONINVENFACTURA;}
		if(sNombreColumna.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTACREDITO)) {sLabelColumna=ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONINVENNOTACREDITO;}
		if(sNombreColumna.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTAVENTA)) {sLabelColumna=ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONINVENNOTAVENTA;}
		if(sNombreColumna.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOFACTURA)) {sLabelColumna=ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTACOFACTURA;}
		if(sNombreColumna.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTACREDITO)) {sLabelColumna=ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTACONOTACREDITO;}
		if(sNombreColumna.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTAVENTA)) {sLabelColumna=ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTACONOTAVENTA;}
		if(sNombreColumna.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOTARJETA)) {sLabelColumna=ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTACOTARJETA;}
		if(sNombreColumna.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPAFACTURA)) {sLabelColumna=ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTAPAFACTURA;}
		if(sNombreColumna.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPANOTACREDITO)) {sLabelColumna=ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTAPANOTACREDITO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getParametroFactuTransaccionDescripcion(ParametroFactuTransaccion parametrofactutransaccion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametrofactutransaccion !=null/* && parametrofactutransaccion.getId()!=0*/) {
			if(parametrofactutransaccion.getId()!=null) {
				sDescripcion=parametrofactutransaccion.getId().toString();
			}//parametrofactutransaccionparametrofactutransaccion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroFactuTransaccionDescripcionDetallado(ParametroFactuTransaccion parametrofactutransaccion) {
		String sDescripcion="";
			
		sDescripcion+=ParametroFactuTransaccionConstantesFunciones.ID+"=";
		sDescripcion+=parametrofactutransaccion.getId().toString()+",";
		sDescripcion+=ParametroFactuTransaccionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametrofactutransaccion.getVersionRow().toString()+",";
		sDescripcion+=ParametroFactuTransaccionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametrofactutransaccion.getid_empresa().toString()+",";
		sDescripcion+=ParametroFactuTransaccionConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=parametrofactutransaccion.getid_sucursal().toString()+",";
		sDescripcion+=ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENFACTURA+"=";
		sDescripcion+=parametrofactutransaccion.getid_transaccion_inven_factura().toString()+",";
		sDescripcion+=ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTACREDITO+"=";
		sDescripcion+=parametrofactutransaccion.getid_transaccion_inven_nota_credito().toString()+",";
		sDescripcion+=ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTAVENTA+"=";
		sDescripcion+=parametrofactutransaccion.getid_transaccion_inven_nota_venta().toString()+",";
		sDescripcion+=ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOFACTURA+"=";
		sDescripcion+=parametrofactutransaccion.getid_transaccion_cuenta_co_factura().toString()+",";
		sDescripcion+=ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTACREDITO+"=";
		sDescripcion+=parametrofactutransaccion.getid_transaccion_cuenta_co_nota_credito().toString()+",";
		sDescripcion+=ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTAVENTA+"=";
		sDescripcion+=parametrofactutransaccion.getid_transaccion_cuenta_co_nota_venta().toString()+",";
		sDescripcion+=ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOTARJETA+"=";
		sDescripcion+=parametrofactutransaccion.getid_transaccion_cuenta_co_tarjeta().toString()+",";
		sDescripcion+=ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPAFACTURA+"=";
		sDescripcion+=parametrofactutransaccion.getid_transaccion_cuenta_pa_factura().toString()+",";
		sDescripcion+=ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPANOTACREDITO+"=";
		sDescripcion+=parametrofactutransaccion.getid_transaccion_cuenta_pa_nota_credito().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroFactuTransaccionDescripcion(ParametroFactuTransaccion parametrofactutransaccion,String sValor) throws Exception {			
		if(parametrofactutransaccion !=null) {
			//parametrofactutransaccionparametrofactutransaccion.getId().toString();
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

	public static String getTransaccionInvenFacturaDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccionInvenNotaCreditoDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccionInvenNotaVentaDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccionCuentaCoFacturaDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccionCuentaCoNotaCreditoDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccionCuentaCoNotaVentaDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccionCuentaCoTarjetaDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccionCuentaPaFacturaDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccionCuentaPaNotaCreditoDescripcion(Transaccion transaccion) {
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTransaccionCuentaCoFactura")) {
			sNombreIndice="Tipo=  Por Facturacion";
		} else if(sNombreIndice.equals("FK_IdTransaccionCuentaCoNotaCredito")) {
			sNombreIndice="Tipo=  Por Nota De Credito";
		} else if(sNombreIndice.equals("FK_IdTransaccionCuentaCoNotaVenta")) {
			sNombreIndice="Tipo=  Por Nota De Venta";
		} else if(sNombreIndice.equals("FK_IdTransaccionCuentaCoTarjeta")) {
			sNombreIndice="Tipo=  Por Tarjeta De Credito";
		} else if(sNombreIndice.equals("FK_IdTransaccionCuentaPaFactura")) {
			sNombreIndice="Tipo=  Por Facturacion_";
		} else if(sNombreIndice.equals("FK_IdTransaccionCuentaPaNotaCredito")) {
			sNombreIndice="Tipo=  Por Nota De Credito_";
		} else if(sNombreIndice.equals("FK_IdTransaccionInvenFactura")) {
			sNombreIndice="Tipo=  Por Facturacion.";
		} else if(sNombreIndice.equals("FK_IdTransaccionInvenNotaCredito")) {
			sNombreIndice="Tipo=  Por Nota De Credito.";
		} else if(sNombreIndice.equals("FK_IdTransaccionInvenNotaVenta")) {
			sNombreIndice="Tipo=  Por Nota De Venta.";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionCuentaCoFactura(Long id_transaccion_cuenta_co_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_cuenta_co_factura!=null) {sDetalleIndice+=" Codigo Unico De Facturacion="+id_transaccion_cuenta_co_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionCuentaCoNotaCredito(Long id_transaccion_cuenta_co_nota_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_cuenta_co_nota_credito!=null) {sDetalleIndice+=" Codigo Unico De Nota De Credito="+id_transaccion_cuenta_co_nota_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionCuentaCoNotaVenta(Long id_transaccion_cuenta_co_nota_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_cuenta_co_nota_venta!=null) {sDetalleIndice+=" Codigo Unico De Nota De Venta="+id_transaccion_cuenta_co_nota_venta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionCuentaCoTarjeta(Long id_transaccion_cuenta_co_tarjeta) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_cuenta_co_tarjeta!=null) {sDetalleIndice+=" Codigo Unico De Tarjeta De Credito="+id_transaccion_cuenta_co_tarjeta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionCuentaPaFactura(Long id_transaccion_cuenta_pa_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_cuenta_pa_factura!=null) {sDetalleIndice+=" Codigo Unico De Facturacion_="+id_transaccion_cuenta_pa_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionCuentaPaNotaCredito(Long id_transaccion_cuenta_pa_nota_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_cuenta_pa_nota_credito!=null) {sDetalleIndice+=" Codigo Unico De Nota De Credito_="+id_transaccion_cuenta_pa_nota_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionInvenFactura(Long id_transaccion_inven_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_inven_factura!=null) {sDetalleIndice+=" Codigo Unico De Facturacion.="+id_transaccion_inven_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionInvenNotaCredito(Long id_transaccion_inven_nota_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_inven_nota_credito!=null) {sDetalleIndice+=" Codigo Unico De Nota De Credito.="+id_transaccion_inven_nota_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionInvenNotaVenta(Long id_transaccion_inven_nota_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_inven_nota_venta!=null) {sDetalleIndice+=" Codigo Unico De Nota De Venta.="+id_transaccion_inven_nota_venta.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroFactuTransaccion(ParametroFactuTransaccion parametrofactutransaccion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosParametroFactuTransaccions(List<ParametroFactuTransaccion> parametrofactutransaccions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroFactuTransaccion parametrofactutransaccion: parametrofactutransaccions) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroFactuTransaccion(ParametroFactuTransaccion parametrofactutransaccion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametrofactutransaccion.getConCambioAuxiliar()) {
			parametrofactutransaccion.setIsDeleted(parametrofactutransaccion.getIsDeletedAuxiliar());	
			parametrofactutransaccion.setIsNew(parametrofactutransaccion.getIsNewAuxiliar());	
			parametrofactutransaccion.setIsChanged(parametrofactutransaccion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametrofactutransaccion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametrofactutransaccion.setIsDeletedAuxiliar(false);	
			parametrofactutransaccion.setIsNewAuxiliar(false);	
			parametrofactutransaccion.setIsChangedAuxiliar(false);
			
			parametrofactutransaccion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroFactuTransaccions(List<ParametroFactuTransaccion> parametrofactutransaccions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroFactuTransaccion parametrofactutransaccion : parametrofactutransaccions) {
			if(conAsignarBase && parametrofactutransaccion.getConCambioAuxiliar()) {
				parametrofactutransaccion.setIsDeleted(parametrofactutransaccion.getIsDeletedAuxiliar());	
				parametrofactutransaccion.setIsNew(parametrofactutransaccion.getIsNewAuxiliar());	
				parametrofactutransaccion.setIsChanged(parametrofactutransaccion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametrofactutransaccion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametrofactutransaccion.setIsDeletedAuxiliar(false);	
				parametrofactutransaccion.setIsNewAuxiliar(false);	
				parametrofactutransaccion.setIsChangedAuxiliar(false);
				
				parametrofactutransaccion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroFactuTransaccion(ParametroFactuTransaccion parametrofactutransaccion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresParametroFactuTransaccions(List<ParametroFactuTransaccion> parametrofactutransaccions,Boolean conEnteros) throws Exception  {
		
		for(ParametroFactuTransaccion parametrofactutransaccion: parametrofactutransaccions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroFactuTransaccion(List<ParametroFactuTransaccion> parametrofactutransaccions,ParametroFactuTransaccion parametrofactutransaccionAux) throws Exception  {
		ParametroFactuTransaccionConstantesFunciones.InicializarValoresParametroFactuTransaccion(parametrofactutransaccionAux,true);
		
		for(ParametroFactuTransaccion parametrofactutransaccion: parametrofactutransaccions) {
			if(parametrofactutransaccion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroFactuTransaccion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroFactuTransaccionConstantesFunciones.getArrayColumnasGlobalesParametroFactuTransaccion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroFactuTransaccion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroFactuTransaccionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroFactuTransaccionConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroFactuTransaccionConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroFactuTransaccionConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroFactuTransaccion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroFactuTransaccion> parametrofactutransaccions,ParametroFactuTransaccion parametrofactutransaccion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroFactuTransaccion parametrofactutransaccionAux: parametrofactutransaccions) {
			if(parametrofactutransaccionAux!=null && parametrofactutransaccion!=null) {
				if((parametrofactutransaccionAux.getId()==null && parametrofactutransaccion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametrofactutransaccionAux.getId()!=null && parametrofactutransaccion.getId()!=null){
					if(parametrofactutransaccionAux.getId().equals(parametrofactutransaccion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroFactuTransaccion(List<ParametroFactuTransaccion> parametrofactutransaccions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroFactuTransaccion parametrofactutransaccion: parametrofactutransaccions) {			
			if(parametrofactutransaccion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroFactuTransaccion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroFactuTransaccionConstantesFunciones.LABEL_ID, ParametroFactuTransaccionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuTransaccionConstantesFunciones.LABEL_VERSIONROW, ParametroFactuTransaccionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuTransaccionConstantesFunciones.LABEL_IDEMPRESA, ParametroFactuTransaccionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuTransaccionConstantesFunciones.LABEL_IDSUCURSAL, ParametroFactuTransaccionConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONINVENFACTURA, ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONINVENNOTACREDITO, ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONINVENNOTAVENTA, ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTACOFACTURA, ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTACONOTACREDITO, ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTACONOTAVENTA, ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTACOTARJETA, ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOTARJETA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTAPAFACTURA, ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPAFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTAPANOTACREDITO, ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPANOTACREDITO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroFactuTransaccion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuTransaccionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuTransaccionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuTransaccionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuTransaccionConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOTARJETA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPAFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPANOTACREDITO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFactuTransaccion() throws Exception  {
		return ParametroFactuTransaccionConstantesFunciones.getTiposSeleccionarParametroFactuTransaccion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFactuTransaccion(Boolean conFk) throws Exception  {
		return ParametroFactuTransaccionConstantesFunciones.getTiposSeleccionarParametroFactuTransaccion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFactuTransaccion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuTransaccionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroFactuTransaccionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuTransaccionConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ParametroFactuTransaccionConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONINVENFACTURA);
			reporte.setsDescripcion(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONINVENFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONINVENNOTACREDITO);
			reporte.setsDescripcion(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONINVENNOTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONINVENNOTAVENTA);
			reporte.setsDescripcion(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONINVENNOTAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTACOFACTURA);
			reporte.setsDescripcion(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTACOFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTACONOTACREDITO);
			reporte.setsDescripcion(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTACONOTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTACONOTAVENTA);
			reporte.setsDescripcion(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTACONOTAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTACOTARJETA);
			reporte.setsDescripcion(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTACOTARJETA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTAPAFACTURA);
			reporte.setsDescripcion(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTAPAFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTAPANOTACREDITO);
			reporte.setsDescripcion(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTAPANOTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroFactuTransaccion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroFactuTransaccion(ParametroFactuTransaccion parametrofactutransaccionAux) throws Exception {
		
			parametrofactutransaccionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrofactutransaccionAux.getEmpresa()));
			parametrofactutransaccionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrofactutransaccionAux.getSucursal()));
			parametrofactutransaccionAux.settransaccioninvenfactura_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactutransaccionAux.getTransaccionInvenFactura()));
			parametrofactutransaccionAux.settransaccioninvennotacredito_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactutransaccionAux.getTransaccionInvenNotaCredito()));
			parametrofactutransaccionAux.settransaccioninvennotaventa_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactutransaccionAux.getTransaccionInvenNotaVenta()));
			parametrofactutransaccionAux.settransaccioncuentacofactura_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactutransaccionAux.getTransaccionCuentaCoFactura()));
			parametrofactutransaccionAux.settransaccioncuentaconotacredito_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactutransaccionAux.getTransaccionCuentaCoNotaCredito()));
			parametrofactutransaccionAux.settransaccioncuentaconotaventa_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactutransaccionAux.getTransaccionCuentaCoNotaVenta()));
			parametrofactutransaccionAux.settransaccioncuentacotarjeta_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactutransaccionAux.getTransaccionCuentaCoTarjeta()));
			parametrofactutransaccionAux.settransaccioncuentapafactura_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactutransaccionAux.getTransaccionCuentaPaFactura()));
			parametrofactutransaccionAux.settransaccioncuentapanotacredito_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactutransaccionAux.getTransaccionCuentaPaNotaCredito()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroFactuTransaccion(List<ParametroFactuTransaccion> parametrofactutransaccionsTemp) throws Exception {
		for(ParametroFactuTransaccion parametrofactutransaccionAux:parametrofactutransaccionsTemp) {
			
			parametrofactutransaccionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrofactutransaccionAux.getEmpresa()));
			parametrofactutransaccionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrofactutransaccionAux.getSucursal()));
			parametrofactutransaccionAux.settransaccioninvenfactura_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactutransaccionAux.getTransaccionInvenFactura()));
			parametrofactutransaccionAux.settransaccioninvennotacredito_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactutransaccionAux.getTransaccionInvenNotaCredito()));
			parametrofactutransaccionAux.settransaccioninvennotaventa_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactutransaccionAux.getTransaccionInvenNotaVenta()));
			parametrofactutransaccionAux.settransaccioncuentacofactura_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactutransaccionAux.getTransaccionCuentaCoFactura()));
			parametrofactutransaccionAux.settransaccioncuentaconotacredito_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactutransaccionAux.getTransaccionCuentaCoNotaCredito()));
			parametrofactutransaccionAux.settransaccioncuentaconotaventa_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactutransaccionAux.getTransaccionCuentaCoNotaVenta()));
			parametrofactutransaccionAux.settransaccioncuentacotarjeta_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactutransaccionAux.getTransaccionCuentaCoTarjeta()));
			parametrofactutransaccionAux.settransaccioncuentapafactura_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactutransaccionAux.getTransaccionCuentaPaFactura()));
			parametrofactutransaccionAux.settransaccioncuentapanotacredito_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactutransaccionAux.getTransaccionCuentaPaNotaCredito()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroFactuTransaccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroFactuTransaccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFactuTransaccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroFactuTransaccionConstantesFunciones.getClassesRelationshipsOfParametroFactuTransaccion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFactuTransaccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroFactuTransaccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroFactuTransaccionConstantesFunciones.getClassesRelationshipsFromStringsOfParametroFactuTransaccion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroFactuTransaccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParametroFactuTransaccion parametrofactutransaccion,List<ParametroFactuTransaccion> parametrofactutransaccions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroFactuTransaccion parametrofactutransaccionEncontrado=null;
			
			for(ParametroFactuTransaccion parametrofactutransaccionLocal:parametrofactutransaccions) {
				if(parametrofactutransaccionLocal.getId().equals(parametrofactutransaccion.getId())) {
					parametrofactutransaccionEncontrado=parametrofactutransaccionLocal;
					
					parametrofactutransaccionLocal.setIsChanged(parametrofactutransaccion.getIsChanged());
					parametrofactutransaccionLocal.setIsNew(parametrofactutransaccion.getIsNew());
					parametrofactutransaccionLocal.setIsDeleted(parametrofactutransaccion.getIsDeleted());
					
					parametrofactutransaccionLocal.setGeneralEntityOriginal(parametrofactutransaccion.getGeneralEntityOriginal());
					
					parametrofactutransaccionLocal.setId(parametrofactutransaccion.getId());	
					parametrofactutransaccionLocal.setVersionRow(parametrofactutransaccion.getVersionRow());	
					parametrofactutransaccionLocal.setid_empresa(parametrofactutransaccion.getid_empresa());	
					parametrofactutransaccionLocal.setid_sucursal(parametrofactutransaccion.getid_sucursal());	
					parametrofactutransaccionLocal.setid_transaccion_inven_factura(parametrofactutransaccion.getid_transaccion_inven_factura());	
					parametrofactutransaccionLocal.setid_transaccion_inven_nota_credito(parametrofactutransaccion.getid_transaccion_inven_nota_credito());	
					parametrofactutransaccionLocal.setid_transaccion_inven_nota_venta(parametrofactutransaccion.getid_transaccion_inven_nota_venta());	
					parametrofactutransaccionLocal.setid_transaccion_cuenta_co_factura(parametrofactutransaccion.getid_transaccion_cuenta_co_factura());	
					parametrofactutransaccionLocal.setid_transaccion_cuenta_co_nota_credito(parametrofactutransaccion.getid_transaccion_cuenta_co_nota_credito());	
					parametrofactutransaccionLocal.setid_transaccion_cuenta_co_nota_venta(parametrofactutransaccion.getid_transaccion_cuenta_co_nota_venta());	
					parametrofactutransaccionLocal.setid_transaccion_cuenta_co_tarjeta(parametrofactutransaccion.getid_transaccion_cuenta_co_tarjeta());	
					parametrofactutransaccionLocal.setid_transaccion_cuenta_pa_factura(parametrofactutransaccion.getid_transaccion_cuenta_pa_factura());	
					parametrofactutransaccionLocal.setid_transaccion_cuenta_pa_nota_credito(parametrofactutransaccion.getid_transaccion_cuenta_pa_nota_credito());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametrofactutransaccion.getIsDeleted()) {
				if(!existe) {
					parametrofactutransaccions.add(parametrofactutransaccion);
				}
			} else {
				if(parametrofactutransaccionEncontrado!=null && permiteQuitar)  {
					parametrofactutransaccions.remove(parametrofactutransaccionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroFactuTransaccion parametrofactutransaccion,List<ParametroFactuTransaccion> parametrofactutransaccions) throws Exception {
		try	{			
			for(ParametroFactuTransaccion parametrofactutransaccionLocal:parametrofactutransaccions) {
				if(parametrofactutransaccionLocal.getId().equals(parametrofactutransaccion.getId())) {
					parametrofactutransaccionLocal.setIsSelected(parametrofactutransaccion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroFactuTransaccion(List<ParametroFactuTransaccion> parametrofactutransaccionsAux) throws Exception {
		//this.parametrofactutransaccionsAux=parametrofactutransaccionsAux;
		
		for(ParametroFactuTransaccion parametrofactutransaccionAux:parametrofactutransaccionsAux) {
			if(parametrofactutransaccionAux.getIsChanged()) {
				parametrofactutransaccionAux.setIsChanged(false);
			}		
			
			if(parametrofactutransaccionAux.getIsNew()) {
				parametrofactutransaccionAux.setIsNew(false);
			}	
			
			if(parametrofactutransaccionAux.getIsDeleted()) {
				parametrofactutransaccionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroFactuTransaccion(ParametroFactuTransaccion parametrofactutransaccionAux) throws Exception {
		//this.parametrofactutransaccionAux=parametrofactutransaccionAux;
		
			if(parametrofactutransaccionAux.getIsChanged()) {
				parametrofactutransaccionAux.setIsChanged(false);
			}		
			
			if(parametrofactutransaccionAux.getIsNew()) {
				parametrofactutransaccionAux.setIsNew(false);
			}	
			
			if(parametrofactutransaccionAux.getIsDeleted()) {
				parametrofactutransaccionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroFactuTransaccion parametrofactutransaccionAsignar,ParametroFactuTransaccion parametrofactutransaccion) throws Exception {
		parametrofactutransaccionAsignar.setId(parametrofactutransaccion.getId());	
		parametrofactutransaccionAsignar.setVersionRow(parametrofactutransaccion.getVersionRow());	
		parametrofactutransaccionAsignar.setid_empresa(parametrofactutransaccion.getid_empresa());
		parametrofactutransaccionAsignar.setempresa_descripcion(parametrofactutransaccion.getempresa_descripcion());	
		parametrofactutransaccionAsignar.setid_sucursal(parametrofactutransaccion.getid_sucursal());
		parametrofactutransaccionAsignar.setsucursal_descripcion(parametrofactutransaccion.getsucursal_descripcion());	
		parametrofactutransaccionAsignar.setid_transaccion_inven_factura(parametrofactutransaccion.getid_transaccion_inven_factura());
		parametrofactutransaccionAsignar.settransaccioninvenfactura_descripcion(parametrofactutransaccion.gettransaccioninvenfactura_descripcion());	
		parametrofactutransaccionAsignar.setid_transaccion_inven_nota_credito(parametrofactutransaccion.getid_transaccion_inven_nota_credito());
		parametrofactutransaccionAsignar.settransaccioninvennotacredito_descripcion(parametrofactutransaccion.gettransaccioninvennotacredito_descripcion());	
		parametrofactutransaccionAsignar.setid_transaccion_inven_nota_venta(parametrofactutransaccion.getid_transaccion_inven_nota_venta());
		parametrofactutransaccionAsignar.settransaccioninvennotaventa_descripcion(parametrofactutransaccion.gettransaccioninvennotaventa_descripcion());	
		parametrofactutransaccionAsignar.setid_transaccion_cuenta_co_factura(parametrofactutransaccion.getid_transaccion_cuenta_co_factura());
		parametrofactutransaccionAsignar.settransaccioncuentacofactura_descripcion(parametrofactutransaccion.gettransaccioncuentacofactura_descripcion());	
		parametrofactutransaccionAsignar.setid_transaccion_cuenta_co_nota_credito(parametrofactutransaccion.getid_transaccion_cuenta_co_nota_credito());
		parametrofactutransaccionAsignar.settransaccioncuentaconotacredito_descripcion(parametrofactutransaccion.gettransaccioncuentaconotacredito_descripcion());	
		parametrofactutransaccionAsignar.setid_transaccion_cuenta_co_nota_venta(parametrofactutransaccion.getid_transaccion_cuenta_co_nota_venta());
		parametrofactutransaccionAsignar.settransaccioncuentaconotaventa_descripcion(parametrofactutransaccion.gettransaccioncuentaconotaventa_descripcion());	
		parametrofactutransaccionAsignar.setid_transaccion_cuenta_co_tarjeta(parametrofactutransaccion.getid_transaccion_cuenta_co_tarjeta());
		parametrofactutransaccionAsignar.settransaccioncuentacotarjeta_descripcion(parametrofactutransaccion.gettransaccioncuentacotarjeta_descripcion());	
		parametrofactutransaccionAsignar.setid_transaccion_cuenta_pa_factura(parametrofactutransaccion.getid_transaccion_cuenta_pa_factura());
		parametrofactutransaccionAsignar.settransaccioncuentapafactura_descripcion(parametrofactutransaccion.gettransaccioncuentapafactura_descripcion());	
		parametrofactutransaccionAsignar.setid_transaccion_cuenta_pa_nota_credito(parametrofactutransaccion.getid_transaccion_cuenta_pa_nota_credito());
		parametrofactutransaccionAsignar.settransaccioncuentapanotacredito_descripcion(parametrofactutransaccion.gettransaccioncuentapanotacredito_descripcion());	
	}
	
	public static void inicializarParametroFactuTransaccion(ParametroFactuTransaccion parametrofactutransaccion) throws Exception {
		try {
				parametrofactutransaccion.setId(0L);	
					
				parametrofactutransaccion.setid_empresa(-1L);	
				parametrofactutransaccion.setid_sucursal(-1L);	
				parametrofactutransaccion.setid_transaccion_inven_factura(-1L);	
				parametrofactutransaccion.setid_transaccion_inven_nota_credito(-1L);	
				parametrofactutransaccion.setid_transaccion_inven_nota_venta(-1L);	
				parametrofactutransaccion.setid_transaccion_cuenta_co_factura(-1L);	
				parametrofactutransaccion.setid_transaccion_cuenta_co_nota_credito(-1L);	
				parametrofactutransaccion.setid_transaccion_cuenta_co_nota_venta(-1L);	
				parametrofactutransaccion.setid_transaccion_cuenta_co_tarjeta(-1L);	
				parametrofactutransaccion.setid_transaccion_cuenta_pa_factura(-1L);	
				parametrofactutransaccion.setid_transaccion_cuenta_pa_nota_credito(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroFactuTransaccion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuTransaccionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuTransaccionConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONINVENFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONINVENNOTACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONINVENNOTAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTACOFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTACONOTACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTACONOTAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTACOTARJETA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTAPAFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuTransaccionConstantesFunciones.LABEL_IDTRANSACCIONCUENTAPANOTACREDITO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroFactuTransaccion(String sTipo,Row row,Workbook workbook,ParametroFactuTransaccion parametrofactutransaccion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactutransaccion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactutransaccion.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactutransaccion.gettransaccioninvenfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactutransaccion.gettransaccioninvennotacredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactutransaccion.gettransaccioninvennotaventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactutransaccion.gettransaccioncuentacofactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactutransaccion.gettransaccioncuentaconotacredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactutransaccion.gettransaccioncuentaconotaventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactutransaccion.gettransaccioncuentacotarjeta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactutransaccion.gettransaccioncuentapafactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactutransaccion.gettransaccioncuentapanotacredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroFactuTransaccion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroFactuTransaccion() {
		return this.sFinalQueryParametroFactuTransaccion;
	}
	
	public void setsFinalQueryParametroFactuTransaccion(String sFinalQueryParametroFactuTransaccion) {
		this.sFinalQueryParametroFactuTransaccion= sFinalQueryParametroFactuTransaccion;
	}
	
	public Border resaltarSeleccionarParametroFactuTransaccion=null;
	
	public Border setResaltarSeleccionarParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametrofactutransaccionBeanSwingJInternalFrame.jTtoolBarParametroFactuTransaccion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroFactuTransaccion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroFactuTransaccion() {
		return this.resaltarSeleccionarParametroFactuTransaccion;
	}
	
	public void setResaltarSeleccionarParametroFactuTransaccion(Border borderResaltarSeleccionarParametroFactuTransaccion) {
		this.resaltarSeleccionarParametroFactuTransaccion= borderResaltarSeleccionarParametroFactuTransaccion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroFactuTransaccion=null;
	public Boolean mostraridParametroFactuTransaccion=true;
	public Boolean activaridParametroFactuTransaccion=true;

	public Border resaltarid_empresaParametroFactuTransaccion=null;
	public Boolean mostrarid_empresaParametroFactuTransaccion=true;
	public Boolean activarid_empresaParametroFactuTransaccion=true;
	public Boolean cargarid_empresaParametroFactuTransaccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroFactuTransaccion=false;//ConEventDepend=true

	public Border resaltarid_sucursalParametroFactuTransaccion=null;
	public Boolean mostrarid_sucursalParametroFactuTransaccion=true;
	public Boolean activarid_sucursalParametroFactuTransaccion=true;
	public Boolean cargarid_sucursalParametroFactuTransaccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalParametroFactuTransaccion=false;//ConEventDepend=true

	public Border resaltarid_transaccion_inven_facturaParametroFactuTransaccion=null;
	public Boolean mostrarid_transaccion_inven_facturaParametroFactuTransaccion=true;
	public Boolean activarid_transaccion_inven_facturaParametroFactuTransaccion=true;
	public Boolean cargarid_transaccion_inven_facturaParametroFactuTransaccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_inven_facturaParametroFactuTransaccion=false;//ConEventDepend=true

	public Border resaltarid_transaccion_inven_nota_creditoParametroFactuTransaccion=null;
	public Boolean mostrarid_transaccion_inven_nota_creditoParametroFactuTransaccion=true;
	public Boolean activarid_transaccion_inven_nota_creditoParametroFactuTransaccion=true;
	public Boolean cargarid_transaccion_inven_nota_creditoParametroFactuTransaccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_inven_nota_creditoParametroFactuTransaccion=false;//ConEventDepend=true

	public Border resaltarid_transaccion_inven_nota_ventaParametroFactuTransaccion=null;
	public Boolean mostrarid_transaccion_inven_nota_ventaParametroFactuTransaccion=true;
	public Boolean activarid_transaccion_inven_nota_ventaParametroFactuTransaccion=true;
	public Boolean cargarid_transaccion_inven_nota_ventaParametroFactuTransaccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_inven_nota_ventaParametroFactuTransaccion=false;//ConEventDepend=true

	public Border resaltarid_transaccion_cuenta_co_facturaParametroFactuTransaccion=null;
	public Boolean mostrarid_transaccion_cuenta_co_facturaParametroFactuTransaccion=true;
	public Boolean activarid_transaccion_cuenta_co_facturaParametroFactuTransaccion=true;
	public Boolean cargarid_transaccion_cuenta_co_facturaParametroFactuTransaccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_cuenta_co_facturaParametroFactuTransaccion=false;//ConEventDepend=true

	public Border resaltarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion=null;
	public Boolean mostrarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion=true;
	public Boolean activarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion=true;
	public Boolean cargarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion=false;//ConEventDepend=true

	public Border resaltarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion=null;
	public Boolean mostrarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion=true;
	public Boolean activarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion=true;
	public Boolean cargarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion=false;//ConEventDepend=true

	public Border resaltarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion=null;
	public Boolean mostrarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion=true;
	public Boolean activarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion=true;
	public Boolean cargarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion=false;//ConEventDepend=true

	public Border resaltarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion=null;
	public Boolean mostrarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion=true;
	public Boolean activarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion=true;
	public Boolean cargarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_cuenta_pa_facturaParametroFactuTransaccion=false;//ConEventDepend=true

	public Border resaltarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion=null;
	public Boolean mostrarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion=true;
	public Boolean activarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion=true;
	public Boolean cargarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion=false;//ConEventDepend=true

	
	

	public Border setResaltaridParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactutransaccionBeanSwingJInternalFrame.jTtoolBarParametroFactuTransaccion.setBorder(borderResaltar);
		
		this.resaltaridParametroFactuTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroFactuTransaccion() {
		return this.resaltaridParametroFactuTransaccion;
	}

	public void setResaltaridParametroFactuTransaccion(Border borderResaltar) {
		this.resaltaridParametroFactuTransaccion= borderResaltar;
	}

	public Boolean getMostraridParametroFactuTransaccion() {
		return this.mostraridParametroFactuTransaccion;
	}

	public void setMostraridParametroFactuTransaccion(Boolean mostraridParametroFactuTransaccion) {
		this.mostraridParametroFactuTransaccion= mostraridParametroFactuTransaccion;
	}

	public Boolean getActivaridParametroFactuTransaccion() {
		return this.activaridParametroFactuTransaccion;
	}

	public void setActivaridParametroFactuTransaccion(Boolean activaridParametroFactuTransaccion) {
		this.activaridParametroFactuTransaccion= activaridParametroFactuTransaccion;
	}

	public Border setResaltarid_empresaParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactutransaccionBeanSwingJInternalFrame.jTtoolBarParametroFactuTransaccion.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroFactuTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroFactuTransaccion() {
		return this.resaltarid_empresaParametroFactuTransaccion;
	}

	public void setResaltarid_empresaParametroFactuTransaccion(Border borderResaltar) {
		this.resaltarid_empresaParametroFactuTransaccion= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroFactuTransaccion() {
		return this.mostrarid_empresaParametroFactuTransaccion;
	}

	public void setMostrarid_empresaParametroFactuTransaccion(Boolean mostrarid_empresaParametroFactuTransaccion) {
		this.mostrarid_empresaParametroFactuTransaccion= mostrarid_empresaParametroFactuTransaccion;
	}

	public Boolean getActivarid_empresaParametroFactuTransaccion() {
		return this.activarid_empresaParametroFactuTransaccion;
	}

	public void setActivarid_empresaParametroFactuTransaccion(Boolean activarid_empresaParametroFactuTransaccion) {
		this.activarid_empresaParametroFactuTransaccion= activarid_empresaParametroFactuTransaccion;
	}

	public Boolean getCargarid_empresaParametroFactuTransaccion() {
		return this.cargarid_empresaParametroFactuTransaccion;
	}

	public void setCargarid_empresaParametroFactuTransaccion(Boolean cargarid_empresaParametroFactuTransaccion) {
		this.cargarid_empresaParametroFactuTransaccion= cargarid_empresaParametroFactuTransaccion;
	}

	public Border setResaltarid_sucursalParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactutransaccionBeanSwingJInternalFrame.jTtoolBarParametroFactuTransaccion.setBorder(borderResaltar);
		
		this.resaltarid_sucursalParametroFactuTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalParametroFactuTransaccion() {
		return this.resaltarid_sucursalParametroFactuTransaccion;
	}

	public void setResaltarid_sucursalParametroFactuTransaccion(Border borderResaltar) {
		this.resaltarid_sucursalParametroFactuTransaccion= borderResaltar;
	}

	public Boolean getMostrarid_sucursalParametroFactuTransaccion() {
		return this.mostrarid_sucursalParametroFactuTransaccion;
	}

	public void setMostrarid_sucursalParametroFactuTransaccion(Boolean mostrarid_sucursalParametroFactuTransaccion) {
		this.mostrarid_sucursalParametroFactuTransaccion= mostrarid_sucursalParametroFactuTransaccion;
	}

	public Boolean getActivarid_sucursalParametroFactuTransaccion() {
		return this.activarid_sucursalParametroFactuTransaccion;
	}

	public void setActivarid_sucursalParametroFactuTransaccion(Boolean activarid_sucursalParametroFactuTransaccion) {
		this.activarid_sucursalParametroFactuTransaccion= activarid_sucursalParametroFactuTransaccion;
	}

	public Boolean getCargarid_sucursalParametroFactuTransaccion() {
		return this.cargarid_sucursalParametroFactuTransaccion;
	}

	public void setCargarid_sucursalParametroFactuTransaccion(Boolean cargarid_sucursalParametroFactuTransaccion) {
		this.cargarid_sucursalParametroFactuTransaccion= cargarid_sucursalParametroFactuTransaccion;
	}

	public Border setResaltarid_transaccion_inven_facturaParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactutransaccionBeanSwingJInternalFrame.jTtoolBarParametroFactuTransaccion.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_inven_facturaParametroFactuTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_inven_facturaParametroFactuTransaccion() {
		return this.resaltarid_transaccion_inven_facturaParametroFactuTransaccion;
	}

	public void setResaltarid_transaccion_inven_facturaParametroFactuTransaccion(Border borderResaltar) {
		this.resaltarid_transaccion_inven_facturaParametroFactuTransaccion= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_inven_facturaParametroFactuTransaccion() {
		return this.mostrarid_transaccion_inven_facturaParametroFactuTransaccion;
	}

	public void setMostrarid_transaccion_inven_facturaParametroFactuTransaccion(Boolean mostrarid_transaccion_inven_facturaParametroFactuTransaccion) {
		this.mostrarid_transaccion_inven_facturaParametroFactuTransaccion= mostrarid_transaccion_inven_facturaParametroFactuTransaccion;
	}

	public Boolean getActivarid_transaccion_inven_facturaParametroFactuTransaccion() {
		return this.activarid_transaccion_inven_facturaParametroFactuTransaccion;
	}

	public void setActivarid_transaccion_inven_facturaParametroFactuTransaccion(Boolean activarid_transaccion_inven_facturaParametroFactuTransaccion) {
		this.activarid_transaccion_inven_facturaParametroFactuTransaccion= activarid_transaccion_inven_facturaParametroFactuTransaccion;
	}

	public Boolean getCargarid_transaccion_inven_facturaParametroFactuTransaccion() {
		return this.cargarid_transaccion_inven_facturaParametroFactuTransaccion;
	}

	public void setCargarid_transaccion_inven_facturaParametroFactuTransaccion(Boolean cargarid_transaccion_inven_facturaParametroFactuTransaccion) {
		this.cargarid_transaccion_inven_facturaParametroFactuTransaccion= cargarid_transaccion_inven_facturaParametroFactuTransaccion;
	}

	public Border setResaltarid_transaccion_inven_nota_creditoParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactutransaccionBeanSwingJInternalFrame.jTtoolBarParametroFactuTransaccion.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_inven_nota_creditoParametroFactuTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_inven_nota_creditoParametroFactuTransaccion() {
		return this.resaltarid_transaccion_inven_nota_creditoParametroFactuTransaccion;
	}

	public void setResaltarid_transaccion_inven_nota_creditoParametroFactuTransaccion(Border borderResaltar) {
		this.resaltarid_transaccion_inven_nota_creditoParametroFactuTransaccion= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_inven_nota_creditoParametroFactuTransaccion() {
		return this.mostrarid_transaccion_inven_nota_creditoParametroFactuTransaccion;
	}

	public void setMostrarid_transaccion_inven_nota_creditoParametroFactuTransaccion(Boolean mostrarid_transaccion_inven_nota_creditoParametroFactuTransaccion) {
		this.mostrarid_transaccion_inven_nota_creditoParametroFactuTransaccion= mostrarid_transaccion_inven_nota_creditoParametroFactuTransaccion;
	}

	public Boolean getActivarid_transaccion_inven_nota_creditoParametroFactuTransaccion() {
		return this.activarid_transaccion_inven_nota_creditoParametroFactuTransaccion;
	}

	public void setActivarid_transaccion_inven_nota_creditoParametroFactuTransaccion(Boolean activarid_transaccion_inven_nota_creditoParametroFactuTransaccion) {
		this.activarid_transaccion_inven_nota_creditoParametroFactuTransaccion= activarid_transaccion_inven_nota_creditoParametroFactuTransaccion;
	}

	public Boolean getCargarid_transaccion_inven_nota_creditoParametroFactuTransaccion() {
		return this.cargarid_transaccion_inven_nota_creditoParametroFactuTransaccion;
	}

	public void setCargarid_transaccion_inven_nota_creditoParametroFactuTransaccion(Boolean cargarid_transaccion_inven_nota_creditoParametroFactuTransaccion) {
		this.cargarid_transaccion_inven_nota_creditoParametroFactuTransaccion= cargarid_transaccion_inven_nota_creditoParametroFactuTransaccion;
	}

	public Border setResaltarid_transaccion_inven_nota_ventaParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactutransaccionBeanSwingJInternalFrame.jTtoolBarParametroFactuTransaccion.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_inven_nota_ventaParametroFactuTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_inven_nota_ventaParametroFactuTransaccion() {
		return this.resaltarid_transaccion_inven_nota_ventaParametroFactuTransaccion;
	}

	public void setResaltarid_transaccion_inven_nota_ventaParametroFactuTransaccion(Border borderResaltar) {
		this.resaltarid_transaccion_inven_nota_ventaParametroFactuTransaccion= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_inven_nota_ventaParametroFactuTransaccion() {
		return this.mostrarid_transaccion_inven_nota_ventaParametroFactuTransaccion;
	}

	public void setMostrarid_transaccion_inven_nota_ventaParametroFactuTransaccion(Boolean mostrarid_transaccion_inven_nota_ventaParametroFactuTransaccion) {
		this.mostrarid_transaccion_inven_nota_ventaParametroFactuTransaccion= mostrarid_transaccion_inven_nota_ventaParametroFactuTransaccion;
	}

	public Boolean getActivarid_transaccion_inven_nota_ventaParametroFactuTransaccion() {
		return this.activarid_transaccion_inven_nota_ventaParametroFactuTransaccion;
	}

	public void setActivarid_transaccion_inven_nota_ventaParametroFactuTransaccion(Boolean activarid_transaccion_inven_nota_ventaParametroFactuTransaccion) {
		this.activarid_transaccion_inven_nota_ventaParametroFactuTransaccion= activarid_transaccion_inven_nota_ventaParametroFactuTransaccion;
	}

	public Boolean getCargarid_transaccion_inven_nota_ventaParametroFactuTransaccion() {
		return this.cargarid_transaccion_inven_nota_ventaParametroFactuTransaccion;
	}

	public void setCargarid_transaccion_inven_nota_ventaParametroFactuTransaccion(Boolean cargarid_transaccion_inven_nota_ventaParametroFactuTransaccion) {
		this.cargarid_transaccion_inven_nota_ventaParametroFactuTransaccion= cargarid_transaccion_inven_nota_ventaParametroFactuTransaccion;
	}

	public Border setResaltarid_transaccion_cuenta_co_facturaParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactutransaccionBeanSwingJInternalFrame.jTtoolBarParametroFactuTransaccion.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_cuenta_co_facturaParametroFactuTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_cuenta_co_facturaParametroFactuTransaccion() {
		return this.resaltarid_transaccion_cuenta_co_facturaParametroFactuTransaccion;
	}

	public void setResaltarid_transaccion_cuenta_co_facturaParametroFactuTransaccion(Border borderResaltar) {
		this.resaltarid_transaccion_cuenta_co_facturaParametroFactuTransaccion= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_cuenta_co_facturaParametroFactuTransaccion() {
		return this.mostrarid_transaccion_cuenta_co_facturaParametroFactuTransaccion;
	}

	public void setMostrarid_transaccion_cuenta_co_facturaParametroFactuTransaccion(Boolean mostrarid_transaccion_cuenta_co_facturaParametroFactuTransaccion) {
		this.mostrarid_transaccion_cuenta_co_facturaParametroFactuTransaccion= mostrarid_transaccion_cuenta_co_facturaParametroFactuTransaccion;
	}

	public Boolean getActivarid_transaccion_cuenta_co_facturaParametroFactuTransaccion() {
		return this.activarid_transaccion_cuenta_co_facturaParametroFactuTransaccion;
	}

	public void setActivarid_transaccion_cuenta_co_facturaParametroFactuTransaccion(Boolean activarid_transaccion_cuenta_co_facturaParametroFactuTransaccion) {
		this.activarid_transaccion_cuenta_co_facturaParametroFactuTransaccion= activarid_transaccion_cuenta_co_facturaParametroFactuTransaccion;
	}

	public Boolean getCargarid_transaccion_cuenta_co_facturaParametroFactuTransaccion() {
		return this.cargarid_transaccion_cuenta_co_facturaParametroFactuTransaccion;
	}

	public void setCargarid_transaccion_cuenta_co_facturaParametroFactuTransaccion(Boolean cargarid_transaccion_cuenta_co_facturaParametroFactuTransaccion) {
		this.cargarid_transaccion_cuenta_co_facturaParametroFactuTransaccion= cargarid_transaccion_cuenta_co_facturaParametroFactuTransaccion;
	}

	public Border setResaltarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactutransaccionBeanSwingJInternalFrame.jTtoolBarParametroFactuTransaccion.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion() {
		return this.resaltarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion;
	}

	public void setResaltarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion(Border borderResaltar) {
		this.resaltarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion() {
		return this.mostrarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion;
	}

	public void setMostrarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion(Boolean mostrarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion) {
		this.mostrarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion= mostrarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion;
	}

	public Boolean getActivarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion() {
		return this.activarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion;
	}

	public void setActivarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion(Boolean activarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion) {
		this.activarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion= activarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion;
	}

	public Boolean getCargarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion() {
		return this.cargarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion;
	}

	public void setCargarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion(Boolean cargarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion) {
		this.cargarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion= cargarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion;
	}

	public Border setResaltarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactutransaccionBeanSwingJInternalFrame.jTtoolBarParametroFactuTransaccion.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion() {
		return this.resaltarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion;
	}

	public void setResaltarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion(Border borderResaltar) {
		this.resaltarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion() {
		return this.mostrarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion;
	}

	public void setMostrarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion(Boolean mostrarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion) {
		this.mostrarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion= mostrarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion;
	}

	public Boolean getActivarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion() {
		return this.activarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion;
	}

	public void setActivarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion(Boolean activarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion) {
		this.activarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion= activarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion;
	}

	public Boolean getCargarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion() {
		return this.cargarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion;
	}

	public void setCargarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion(Boolean cargarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion) {
		this.cargarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion= cargarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion;
	}

	public Border setResaltarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactutransaccionBeanSwingJInternalFrame.jTtoolBarParametroFactuTransaccion.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion() {
		return this.resaltarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion;
	}

	public void setResaltarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion(Border borderResaltar) {
		this.resaltarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion() {
		return this.mostrarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion;
	}

	public void setMostrarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion(Boolean mostrarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion) {
		this.mostrarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion= mostrarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion;
	}

	public Boolean getActivarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion() {
		return this.activarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion;
	}

	public void setActivarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion(Boolean activarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion) {
		this.activarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion= activarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion;
	}

	public Boolean getCargarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion() {
		return this.cargarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion;
	}

	public void setCargarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion(Boolean cargarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion) {
		this.cargarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion= cargarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion;
	}

	public Border setResaltarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactutransaccionBeanSwingJInternalFrame.jTtoolBarParametroFactuTransaccion.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion() {
		return this.resaltarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion;
	}

	public void setResaltarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion(Border borderResaltar) {
		this.resaltarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion() {
		return this.mostrarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion;
	}

	public void setMostrarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion(Boolean mostrarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion) {
		this.mostrarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion= mostrarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion;
	}

	public Boolean getActivarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion() {
		return this.activarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion;
	}

	public void setActivarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion(Boolean activarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion) {
		this.activarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion= activarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion;
	}

	public Boolean getCargarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion() {
		return this.cargarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion;
	}

	public void setCargarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion(Boolean cargarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion) {
		this.cargarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion= cargarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion;
	}

	public Border setResaltarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactutransaccionBeanSwingJInternalFrame.jTtoolBarParametroFactuTransaccion.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion() {
		return this.resaltarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion;
	}

	public void setResaltarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion(Border borderResaltar) {
		this.resaltarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion() {
		return this.mostrarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion;
	}

	public void setMostrarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion(Boolean mostrarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion) {
		this.mostrarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion= mostrarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion;
	}

	public Boolean getActivarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion() {
		return this.activarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion;
	}

	public void setActivarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion(Boolean activarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion) {
		this.activarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion= activarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion;
	}

	public Boolean getCargarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion() {
		return this.cargarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion;
	}

	public void setCargarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion(Boolean cargarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion) {
		this.cargarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion= cargarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion;
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
		
		
		this.setMostraridParametroFactuTransaccion(esInicial);
		this.setMostrarid_empresaParametroFactuTransaccion(esInicial);
		this.setMostrarid_sucursalParametroFactuTransaccion(esInicial);
		this.setMostrarid_transaccion_inven_facturaParametroFactuTransaccion(esInicial);
		this.setMostrarid_transaccion_inven_nota_creditoParametroFactuTransaccion(esInicial);
		this.setMostrarid_transaccion_inven_nota_ventaParametroFactuTransaccion(esInicial);
		this.setMostrarid_transaccion_cuenta_co_facturaParametroFactuTransaccion(esInicial);
		this.setMostrarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion(esInicial);
		this.setMostrarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion(esInicial);
		this.setMostrarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion(esInicial);
		this.setMostrarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion(esInicial);
		this.setMostrarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.ID)) {
				this.setMostraridParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENFACTURA)) {
				this.setMostrarid_transaccion_inven_facturaParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTACREDITO)) {
				this.setMostrarid_transaccion_inven_nota_creditoParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTAVENTA)) {
				this.setMostrarid_transaccion_inven_nota_ventaParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOFACTURA)) {
				this.setMostrarid_transaccion_cuenta_co_facturaParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTACREDITO)) {
				this.setMostrarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTAVENTA)) {
				this.setMostrarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOTARJETA)) {
				this.setMostrarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPAFACTURA)) {
				this.setMostrarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPANOTACREDITO)) {
				this.setMostrarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion(esAsigna);
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
		
		
		this.setActivaridParametroFactuTransaccion(esInicial);
		this.setActivarid_empresaParametroFactuTransaccion(esInicial);
		this.setActivarid_sucursalParametroFactuTransaccion(esInicial);
		this.setActivarid_transaccion_inven_facturaParametroFactuTransaccion(esInicial);
		this.setActivarid_transaccion_inven_nota_creditoParametroFactuTransaccion(esInicial);
		this.setActivarid_transaccion_inven_nota_ventaParametroFactuTransaccion(esInicial);
		this.setActivarid_transaccion_cuenta_co_facturaParametroFactuTransaccion(esInicial);
		this.setActivarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion(esInicial);
		this.setActivarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion(esInicial);
		this.setActivarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion(esInicial);
		this.setActivarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion(esInicial);
		this.setActivarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.ID)) {
				this.setActivaridParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENFACTURA)) {
				this.setActivarid_transaccion_inven_facturaParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTACREDITO)) {
				this.setActivarid_transaccion_inven_nota_creditoParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTAVENTA)) {
				this.setActivarid_transaccion_inven_nota_ventaParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOFACTURA)) {
				this.setActivarid_transaccion_cuenta_co_facturaParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTACREDITO)) {
				this.setActivarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTAVENTA)) {
				this.setActivarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOTARJETA)) {
				this.setActivarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPAFACTURA)) {
				this.setActivarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPANOTACREDITO)) {
				this.setActivarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroFactuTransaccion(esInicial);
		this.setResaltarid_empresaParametroFactuTransaccion(esInicial);
		this.setResaltarid_sucursalParametroFactuTransaccion(esInicial);
		this.setResaltarid_transaccion_inven_facturaParametroFactuTransaccion(esInicial);
		this.setResaltarid_transaccion_inven_nota_creditoParametroFactuTransaccion(esInicial);
		this.setResaltarid_transaccion_inven_nota_ventaParametroFactuTransaccion(esInicial);
		this.setResaltarid_transaccion_cuenta_co_facturaParametroFactuTransaccion(esInicial);
		this.setResaltarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion(esInicial);
		this.setResaltarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion(esInicial);
		this.setResaltarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion(esInicial);
		this.setResaltarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion(esInicial);
		this.setResaltarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.ID)) {
				this.setResaltaridParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENFACTURA)) {
				this.setResaltarid_transaccion_inven_facturaParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTACREDITO)) {
				this.setResaltarid_transaccion_inven_nota_creditoParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTAVENTA)) {
				this.setResaltarid_transaccion_inven_nota_ventaParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOFACTURA)) {
				this.setResaltarid_transaccion_cuenta_co_facturaParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTACREDITO)) {
				this.setResaltarid_transaccion_cuenta_co_nota_creditoParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTAVENTA)) {
				this.setResaltarid_transaccion_cuenta_co_nota_ventaParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOTARJETA)) {
				this.setResaltarid_transaccion_cuenta_co_tarjetaParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPAFACTURA)) {
				this.setResaltarid_transaccion_cuenta_pa_facturaParametroFactuTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPANOTACREDITO)) {
				this.setResaltarid_transaccion_cuenta_pa_nota_creditoParametroFactuTransaccion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaParametroFactuTransaccion=true;

	public Boolean getMostrarFK_IdEmpresaParametroFactuTransaccion() {
		return this.mostrarFK_IdEmpresaParametroFactuTransaccion;
	}

	public void setMostrarFK_IdEmpresaParametroFactuTransaccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroFactuTransaccion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalParametroFactuTransaccion=true;

	public Boolean getMostrarFK_IdSucursalParametroFactuTransaccion() {
		return this.mostrarFK_IdSucursalParametroFactuTransaccion;
	}

	public void setMostrarFK_IdSucursalParametroFactuTransaccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalParametroFactuTransaccion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionCuentaCoFacturaParametroFactuTransaccion=true;

	public Boolean getMostrarFK_IdTransaccionCuentaCoFacturaParametroFactuTransaccion() {
		return this.mostrarFK_IdTransaccionCuentaCoFacturaParametroFactuTransaccion;
	}

	public void setMostrarFK_IdTransaccionCuentaCoFacturaParametroFactuTransaccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionCuentaCoFacturaParametroFactuTransaccion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionCuentaCoNotaCreditoParametroFactuTransaccion=true;

	public Boolean getMostrarFK_IdTransaccionCuentaCoNotaCreditoParametroFactuTransaccion() {
		return this.mostrarFK_IdTransaccionCuentaCoNotaCreditoParametroFactuTransaccion;
	}

	public void setMostrarFK_IdTransaccionCuentaCoNotaCreditoParametroFactuTransaccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionCuentaCoNotaCreditoParametroFactuTransaccion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionCuentaCoNotaVentaParametroFactuTransaccion=true;

	public Boolean getMostrarFK_IdTransaccionCuentaCoNotaVentaParametroFactuTransaccion() {
		return this.mostrarFK_IdTransaccionCuentaCoNotaVentaParametroFactuTransaccion;
	}

	public void setMostrarFK_IdTransaccionCuentaCoNotaVentaParametroFactuTransaccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionCuentaCoNotaVentaParametroFactuTransaccion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionCuentaCoTarjetaParametroFactuTransaccion=true;

	public Boolean getMostrarFK_IdTransaccionCuentaCoTarjetaParametroFactuTransaccion() {
		return this.mostrarFK_IdTransaccionCuentaCoTarjetaParametroFactuTransaccion;
	}

	public void setMostrarFK_IdTransaccionCuentaCoTarjetaParametroFactuTransaccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionCuentaCoTarjetaParametroFactuTransaccion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionCuentaPaFacturaParametroFactuTransaccion=true;

	public Boolean getMostrarFK_IdTransaccionCuentaPaFacturaParametroFactuTransaccion() {
		return this.mostrarFK_IdTransaccionCuentaPaFacturaParametroFactuTransaccion;
	}

	public void setMostrarFK_IdTransaccionCuentaPaFacturaParametroFactuTransaccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionCuentaPaFacturaParametroFactuTransaccion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionCuentaPaNotaCreditoParametroFactuTransaccion=true;

	public Boolean getMostrarFK_IdTransaccionCuentaPaNotaCreditoParametroFactuTransaccion() {
		return this.mostrarFK_IdTransaccionCuentaPaNotaCreditoParametroFactuTransaccion;
	}

	public void setMostrarFK_IdTransaccionCuentaPaNotaCreditoParametroFactuTransaccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionCuentaPaNotaCreditoParametroFactuTransaccion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionInvenFacturaParametroFactuTransaccion=true;

	public Boolean getMostrarFK_IdTransaccionInvenFacturaParametroFactuTransaccion() {
		return this.mostrarFK_IdTransaccionInvenFacturaParametroFactuTransaccion;
	}

	public void setMostrarFK_IdTransaccionInvenFacturaParametroFactuTransaccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionInvenFacturaParametroFactuTransaccion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionInvenNotaCreditoParametroFactuTransaccion=true;

	public Boolean getMostrarFK_IdTransaccionInvenNotaCreditoParametroFactuTransaccion() {
		return this.mostrarFK_IdTransaccionInvenNotaCreditoParametroFactuTransaccion;
	}

	public void setMostrarFK_IdTransaccionInvenNotaCreditoParametroFactuTransaccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionInvenNotaCreditoParametroFactuTransaccion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionInvenNotaVentaParametroFactuTransaccion=true;

	public Boolean getMostrarFK_IdTransaccionInvenNotaVentaParametroFactuTransaccion() {
		return this.mostrarFK_IdTransaccionInvenNotaVentaParametroFactuTransaccion;
	}

	public void setMostrarFK_IdTransaccionInvenNotaVentaParametroFactuTransaccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionInvenNotaVentaParametroFactuTransaccion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaParametroFactuTransaccion=true;

	public Boolean getActivarFK_IdEmpresaParametroFactuTransaccion() {
		return this.activarFK_IdEmpresaParametroFactuTransaccion;
	}

	public void setActivarFK_IdEmpresaParametroFactuTransaccion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroFactuTransaccion= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalParametroFactuTransaccion=true;

	public Boolean getActivarFK_IdSucursalParametroFactuTransaccion() {
		return this.activarFK_IdSucursalParametroFactuTransaccion;
	}

	public void setActivarFK_IdSucursalParametroFactuTransaccion(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalParametroFactuTransaccion= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionCuentaCoFacturaParametroFactuTransaccion=true;

	public Boolean getActivarFK_IdTransaccionCuentaCoFacturaParametroFactuTransaccion() {
		return this.activarFK_IdTransaccionCuentaCoFacturaParametroFactuTransaccion;
	}

	public void setActivarFK_IdTransaccionCuentaCoFacturaParametroFactuTransaccion(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionCuentaCoFacturaParametroFactuTransaccion= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionCuentaCoNotaCreditoParametroFactuTransaccion=true;

	public Boolean getActivarFK_IdTransaccionCuentaCoNotaCreditoParametroFactuTransaccion() {
		return this.activarFK_IdTransaccionCuentaCoNotaCreditoParametroFactuTransaccion;
	}

	public void setActivarFK_IdTransaccionCuentaCoNotaCreditoParametroFactuTransaccion(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionCuentaCoNotaCreditoParametroFactuTransaccion= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionCuentaCoNotaVentaParametroFactuTransaccion=true;

	public Boolean getActivarFK_IdTransaccionCuentaCoNotaVentaParametroFactuTransaccion() {
		return this.activarFK_IdTransaccionCuentaCoNotaVentaParametroFactuTransaccion;
	}

	public void setActivarFK_IdTransaccionCuentaCoNotaVentaParametroFactuTransaccion(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionCuentaCoNotaVentaParametroFactuTransaccion= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionCuentaCoTarjetaParametroFactuTransaccion=true;

	public Boolean getActivarFK_IdTransaccionCuentaCoTarjetaParametroFactuTransaccion() {
		return this.activarFK_IdTransaccionCuentaCoTarjetaParametroFactuTransaccion;
	}

	public void setActivarFK_IdTransaccionCuentaCoTarjetaParametroFactuTransaccion(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionCuentaCoTarjetaParametroFactuTransaccion= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionCuentaPaFacturaParametroFactuTransaccion=true;

	public Boolean getActivarFK_IdTransaccionCuentaPaFacturaParametroFactuTransaccion() {
		return this.activarFK_IdTransaccionCuentaPaFacturaParametroFactuTransaccion;
	}

	public void setActivarFK_IdTransaccionCuentaPaFacturaParametroFactuTransaccion(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionCuentaPaFacturaParametroFactuTransaccion= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionCuentaPaNotaCreditoParametroFactuTransaccion=true;

	public Boolean getActivarFK_IdTransaccionCuentaPaNotaCreditoParametroFactuTransaccion() {
		return this.activarFK_IdTransaccionCuentaPaNotaCreditoParametroFactuTransaccion;
	}

	public void setActivarFK_IdTransaccionCuentaPaNotaCreditoParametroFactuTransaccion(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionCuentaPaNotaCreditoParametroFactuTransaccion= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionInvenFacturaParametroFactuTransaccion=true;

	public Boolean getActivarFK_IdTransaccionInvenFacturaParametroFactuTransaccion() {
		return this.activarFK_IdTransaccionInvenFacturaParametroFactuTransaccion;
	}

	public void setActivarFK_IdTransaccionInvenFacturaParametroFactuTransaccion(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionInvenFacturaParametroFactuTransaccion= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionInvenNotaCreditoParametroFactuTransaccion=true;

	public Boolean getActivarFK_IdTransaccionInvenNotaCreditoParametroFactuTransaccion() {
		return this.activarFK_IdTransaccionInvenNotaCreditoParametroFactuTransaccion;
	}

	public void setActivarFK_IdTransaccionInvenNotaCreditoParametroFactuTransaccion(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionInvenNotaCreditoParametroFactuTransaccion= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionInvenNotaVentaParametroFactuTransaccion=true;

	public Boolean getActivarFK_IdTransaccionInvenNotaVentaParametroFactuTransaccion() {
		return this.activarFK_IdTransaccionInvenNotaVentaParametroFactuTransaccion;
	}

	public void setActivarFK_IdTransaccionInvenNotaVentaParametroFactuTransaccion(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionInvenNotaVentaParametroFactuTransaccion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaParametroFactuTransaccion=null;

	public Border getResaltarFK_IdEmpresaParametroFactuTransaccion() {
		return this.resaltarFK_IdEmpresaParametroFactuTransaccion;
	}

	public void setResaltarFK_IdEmpresaParametroFactuTransaccion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroFactuTransaccion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroFactuTransaccion= borderResaltar;
	}

	public Border resaltarFK_IdSucursalParametroFactuTransaccion=null;

	public Border getResaltarFK_IdSucursalParametroFactuTransaccion() {
		return this.resaltarFK_IdSucursalParametroFactuTransaccion;
	}

	public void setResaltarFK_IdSucursalParametroFactuTransaccion(Border borderResaltar) {
		this.resaltarFK_IdSucursalParametroFactuTransaccion= borderResaltar;
	}

	public void setResaltarFK_IdSucursalParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalParametroFactuTransaccion= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionCuentaCoFacturaParametroFactuTransaccion=null;

	public Border getResaltarFK_IdTransaccionCuentaCoFacturaParametroFactuTransaccion() {
		return this.resaltarFK_IdTransaccionCuentaCoFacturaParametroFactuTransaccion;
	}

	public void setResaltarFK_IdTransaccionCuentaCoFacturaParametroFactuTransaccion(Border borderResaltar) {
		this.resaltarFK_IdTransaccionCuentaCoFacturaParametroFactuTransaccion= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionCuentaCoFacturaParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionCuentaCoFacturaParametroFactuTransaccion= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionCuentaCoNotaCreditoParametroFactuTransaccion=null;

	public Border getResaltarFK_IdTransaccionCuentaCoNotaCreditoParametroFactuTransaccion() {
		return this.resaltarFK_IdTransaccionCuentaCoNotaCreditoParametroFactuTransaccion;
	}

	public void setResaltarFK_IdTransaccionCuentaCoNotaCreditoParametroFactuTransaccion(Border borderResaltar) {
		this.resaltarFK_IdTransaccionCuentaCoNotaCreditoParametroFactuTransaccion= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionCuentaCoNotaCreditoParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionCuentaCoNotaCreditoParametroFactuTransaccion= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionCuentaCoNotaVentaParametroFactuTransaccion=null;

	public Border getResaltarFK_IdTransaccionCuentaCoNotaVentaParametroFactuTransaccion() {
		return this.resaltarFK_IdTransaccionCuentaCoNotaVentaParametroFactuTransaccion;
	}

	public void setResaltarFK_IdTransaccionCuentaCoNotaVentaParametroFactuTransaccion(Border borderResaltar) {
		this.resaltarFK_IdTransaccionCuentaCoNotaVentaParametroFactuTransaccion= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionCuentaCoNotaVentaParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionCuentaCoNotaVentaParametroFactuTransaccion= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionCuentaCoTarjetaParametroFactuTransaccion=null;

	public Border getResaltarFK_IdTransaccionCuentaCoTarjetaParametroFactuTransaccion() {
		return this.resaltarFK_IdTransaccionCuentaCoTarjetaParametroFactuTransaccion;
	}

	public void setResaltarFK_IdTransaccionCuentaCoTarjetaParametroFactuTransaccion(Border borderResaltar) {
		this.resaltarFK_IdTransaccionCuentaCoTarjetaParametroFactuTransaccion= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionCuentaCoTarjetaParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionCuentaCoTarjetaParametroFactuTransaccion= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionCuentaPaFacturaParametroFactuTransaccion=null;

	public Border getResaltarFK_IdTransaccionCuentaPaFacturaParametroFactuTransaccion() {
		return this.resaltarFK_IdTransaccionCuentaPaFacturaParametroFactuTransaccion;
	}

	public void setResaltarFK_IdTransaccionCuentaPaFacturaParametroFactuTransaccion(Border borderResaltar) {
		this.resaltarFK_IdTransaccionCuentaPaFacturaParametroFactuTransaccion= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionCuentaPaFacturaParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionCuentaPaFacturaParametroFactuTransaccion= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionCuentaPaNotaCreditoParametroFactuTransaccion=null;

	public Border getResaltarFK_IdTransaccionCuentaPaNotaCreditoParametroFactuTransaccion() {
		return this.resaltarFK_IdTransaccionCuentaPaNotaCreditoParametroFactuTransaccion;
	}

	public void setResaltarFK_IdTransaccionCuentaPaNotaCreditoParametroFactuTransaccion(Border borderResaltar) {
		this.resaltarFK_IdTransaccionCuentaPaNotaCreditoParametroFactuTransaccion= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionCuentaPaNotaCreditoParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionCuentaPaNotaCreditoParametroFactuTransaccion= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionInvenFacturaParametroFactuTransaccion=null;

	public Border getResaltarFK_IdTransaccionInvenFacturaParametroFactuTransaccion() {
		return this.resaltarFK_IdTransaccionInvenFacturaParametroFactuTransaccion;
	}

	public void setResaltarFK_IdTransaccionInvenFacturaParametroFactuTransaccion(Border borderResaltar) {
		this.resaltarFK_IdTransaccionInvenFacturaParametroFactuTransaccion= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionInvenFacturaParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionInvenFacturaParametroFactuTransaccion= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionInvenNotaCreditoParametroFactuTransaccion=null;

	public Border getResaltarFK_IdTransaccionInvenNotaCreditoParametroFactuTransaccion() {
		return this.resaltarFK_IdTransaccionInvenNotaCreditoParametroFactuTransaccion;
	}

	public void setResaltarFK_IdTransaccionInvenNotaCreditoParametroFactuTransaccion(Border borderResaltar) {
		this.resaltarFK_IdTransaccionInvenNotaCreditoParametroFactuTransaccion= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionInvenNotaCreditoParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionInvenNotaCreditoParametroFactuTransaccion= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionInvenNotaVentaParametroFactuTransaccion=null;

	public Border getResaltarFK_IdTransaccionInvenNotaVentaParametroFactuTransaccion() {
		return this.resaltarFK_IdTransaccionInvenNotaVentaParametroFactuTransaccion;
	}

	public void setResaltarFK_IdTransaccionInvenNotaVentaParametroFactuTransaccion(Border borderResaltar) {
		this.resaltarFK_IdTransaccionInvenNotaVentaParametroFactuTransaccion= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionInvenNotaVentaParametroFactuTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuTransaccionBeanSwingJInternalFrame parametrofactutransaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionInvenNotaVentaParametroFactuTransaccion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}