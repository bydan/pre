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
package com.bydan.erp.tesoreria.util;

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


import com.bydan.erp.tesoreria.util.TransaccionConstantesFunciones;
import com.bydan.erp.tesoreria.util.TransaccionParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TransaccionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.produccion.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.puntoventa.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TransaccionConstantesFunciones extends TransaccionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Transaccion";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Transaccion"+TransaccionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TransaccionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TransaccionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TransaccionConstantesFunciones.SCHEMA+"_"+TransaccionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TransaccionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TransaccionConstantesFunciones.SCHEMA+"_"+TransaccionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TransaccionConstantesFunciones.SCHEMA+"_"+TransaccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TransaccionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TransaccionConstantesFunciones.SCHEMA+"_"+TransaccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransaccionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransaccionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TransaccionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TransaccionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TransaccionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TransaccionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Transacciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Transaccion";
	public static final String SCLASSWEBTITULO_LOWER="Transaccion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Transaccion";
	public static final String OBJECTNAME="transaccion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="transaccion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select transaccion from "+TransaccionConstantesFunciones.SPERSISTENCENAME+" transaccion";
	public static String QUERYSELECTNATIVE="select "+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".id,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".version_row,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".id_empresa,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".id_sucursal,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".codigo,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".nombre,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".id_modulo,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".id_tipo_transa,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".id_tipo_comprobante,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".id_tipo_retencion,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".id_cuenta_contable,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".descripcion from "+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME;//+" as "+TransaccionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TransaccionConstantesFuncionesAdditional transaccionConstantesFuncionesAdditional=null;
	
	public TransaccionConstantesFuncionesAdditional getTransaccionConstantesFuncionesAdditional() {
		return this.transaccionConstantesFuncionesAdditional;
	}
	
	public void setTransaccionConstantesFuncionesAdditional(TransaccionConstantesFuncionesAdditional transaccionConstantesFuncionesAdditional) {
		try {
			this.transaccionConstantesFuncionesAdditional=transaccionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String IDMODULO= "id_modulo";
    public static final String IDTIPOTRANSA= "id_tipo_transa";
    public static final String IDTIPOCOMPROBANTE= "id_tipo_comprobante";
    public static final String IDTIPOTRANSACCIONMODULO= "id_tipo_transaccion_modulo";
    public static final String IDTIPORETENCION= "id_tipo_retencion";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
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
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDTIPOTRANSA= "Movimiento";
		public static final String LABEL_IDTIPOTRANSA_LOWER= "Tipo Transa";
    	public static final String LABEL_IDTIPOCOMPROBANTE= "Tipo Compr.";
		public static final String LABEL_IDTIPOCOMPROBANTE_LOWER= "Tipo Comprobante";
    	public static final String LABEL_IDTIPOTRANSACCIONMODULO= "Tipo Transaccion Modulo";
		public static final String LABEL_IDTIPOTRANSACCIONMODULO_LOWER= "Tipo Transaccion Modulo";
    	public static final String LABEL_IDTIPORETENCION= "Tipo Retencion";
		public static final String LABEL_IDTIPORETENCION_LOWER= "Tipo Retencion";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta C.";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTransaccionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TransaccionConstantesFunciones.IDEMPRESA)) {sLabelColumna=TransaccionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TransaccionConstantesFunciones.IDSUCURSAL)) {sLabelColumna=TransaccionConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(TransaccionConstantesFunciones.CODIGO)) {sLabelColumna=TransaccionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TransaccionConstantesFunciones.NOMBRE)) {sLabelColumna=TransaccionConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TransaccionConstantesFunciones.IDMODULO)) {sLabelColumna=TransaccionConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(TransaccionConstantesFunciones.IDTIPOTRANSA)) {sLabelColumna=TransaccionConstantesFunciones.LABEL_IDTIPOTRANSA;}
		if(sNombreColumna.equals(TransaccionConstantesFunciones.IDTIPOCOMPROBANTE)) {sLabelColumna=TransaccionConstantesFunciones.LABEL_IDTIPOCOMPROBANTE;}
		if(sNombreColumna.equals(TransaccionConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {sLabelColumna=TransaccionConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO;}
		if(sNombreColumna.equals(TransaccionConstantesFunciones.IDTIPORETENCION)) {sLabelColumna=TransaccionConstantesFunciones.LABEL_IDTIPORETENCION;}
		if(sNombreColumna.equals(TransaccionConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=TransaccionConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(TransaccionConstantesFunciones.DESCRIPCION)) {sLabelColumna=TransaccionConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getTransaccionDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(transaccion !=null/* && transaccion.getId()!=0*/) {
			sDescripcion=transaccion.getcodigo()+"-"+transaccion.getnombre();//transacciontransaccion.getcodigo().trim()+"-"+transaccion.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTransaccionDescripcionDetallado(Transaccion transaccion) {
		String sDescripcion="";
			
		sDescripcion+=TransaccionConstantesFunciones.ID+"=";
		sDescripcion+=transaccion.getId().toString()+",";
		sDescripcion+=TransaccionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=transaccion.getVersionRow().toString()+",";
		sDescripcion+=TransaccionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=transaccion.getid_empresa().toString()+",";
		sDescripcion+=TransaccionConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=transaccion.getid_sucursal().toString()+",";
		sDescripcion+=TransaccionConstantesFunciones.CODIGO+"=";
		sDescripcion+=transaccion.getcodigo()+",";
		sDescripcion+=TransaccionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=transaccion.getnombre()+",";
		sDescripcion+=TransaccionConstantesFunciones.IDMODULO+"=";
		sDescripcion+=transaccion.getid_modulo().toString()+",";
		sDescripcion+=TransaccionConstantesFunciones.IDTIPOTRANSA+"=";
		sDescripcion+=transaccion.getid_tipo_transa().toString()+",";
		sDescripcion+=TransaccionConstantesFunciones.IDTIPOCOMPROBANTE+"=";
		sDescripcion+=transaccion.getid_tipo_comprobante().toString()+",";
		sDescripcion+=TransaccionConstantesFunciones.IDTIPOTRANSACCIONMODULO+"=";
		sDescripcion+=transaccion.getid_tipo_transaccion_modulo().toString()+",";
		sDescripcion+=TransaccionConstantesFunciones.IDTIPORETENCION+"=";
		sDescripcion+=transaccion.getid_tipo_retencion().toString()+",";
		sDescripcion+=TransaccionConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=transaccion.getid_cuenta_contable().toString()+",";
		sDescripcion+=TransaccionConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=transaccion.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTransaccionDescripcion(Transaccion transaccion,String sValor) throws Exception {			
		if(transaccion !=null) {
			transaccion.setcodigo(sValor);
transaccion.setnombre(sValor);;//transacciontransaccion.getcodigo().trim()+"-"+transaccion.getnombre().trim();
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

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}

	public static String getTipoTransaDescripcion(TipoTransa tipotransa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotransa!=null/*&&tipotransa.getId()>0*/) {
			sDescripcion=TipoTransaConstantesFunciones.getTipoTransaDescripcion(tipotransa);
		}

		return sDescripcion;
	}

	public static String getTipoComprobanteDescripcion(TipoComprobante tipocomprobante) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocomprobante!=null/*&&tipocomprobante.getId()>0*/) {
			sDescripcion=TipoComprobanteConstantesFunciones.getTipoComprobanteDescripcion(tipocomprobante);
		}

		return sDescripcion;
	}

	public static String getTipoTransaccionModuloDescripcion(TipoTransaccionModulo tipotransaccionmodulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotransaccionmodulo!=null/*&&tipotransaccionmodulo.getId()>0*/) {
			sDescripcion=TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(tipotransaccionmodulo);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionDescripcion(TipoRetencion tiporetencion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencion!=null/*&&tiporetencion.getId()>0*/) {
			sDescripcion=TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tiporetencion);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
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
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorIdModuloPorTipoTransaccion")) {
			sNombreIndice="Tipo=  Por Modulo Por Tipo Transaccion Modulo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta C.";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoComprobante")) {
			sNombreIndice="Tipo=  Por Tipo Compr.";
		} else if(sNombreIndice.equals("FK_IdTipoRetencion")) {
			sNombreIndice="Tipo=  Por Tipo Retencion";
		} else if(sNombreIndice.equals("FK_IdTipoTransa")) {
			sNombreIndice="Tipo=  Por Movimiento";
		} else if(sNombreIndice.equals("FK_IdTipoTransaccionModulo")) {
			sNombreIndice="Tipo=  Por Tipo Transaccion Modulo";
		} else if(sNombreIndice.equals("PorIdPorEmprePorSucuPorModuPorTipoTransa")) {
			sNombreIndice="Tipo=  Por Id Por Empresa Por Sucursal Por Modulo Por Tipo Transaccion Modulo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorIdModuloPorTipoTransaccion(Long id_modulo,Long id_tipo_transaccion_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();}
		if(id_tipo_transaccion_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Transaccion Modulo="+id_tipo_transaccion_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C.="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoComprobante(Long id_tipo_comprobante) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_comprobante!=null) {sDetalleIndice+=" Codigo Unico De Tipo Compr.="+id_tipo_comprobante.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencion(Long id_tipo_retencion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Retencion="+id_tipo_retencion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTransa(Long id_tipo_transa) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_transa!=null) {sDetalleIndice+=" Codigo Unico De Movimiento="+id_tipo_transa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTransaccionModulo(Long id_tipo_transaccion_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_transaccion_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Transaccion Modulo="+id_tipo_transaccion_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdPorEmprePorSucuPorModuPorTipoTransa(Long id,Long id_empresa,Long id_sucursal,Long id_modulo,Long id_tipo_transaccion_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();}
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();}
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();}
		if(id_tipo_transaccion_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Transaccion Modulo="+id_tipo_transaccion_modulo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTransaccion(Transaccion transaccion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		transaccion.setcodigo(transaccion.getcodigo().trim());
		transaccion.setnombre(transaccion.getnombre().trim());
		transaccion.setdescripcion(transaccion.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTransaccions(List<Transaccion> transaccions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Transaccion transaccion: transaccions) {
			transaccion.setcodigo(transaccion.getcodigo().trim());
			transaccion.setnombre(transaccion.getnombre().trim());
			transaccion.setdescripcion(transaccion.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransaccion(Transaccion transaccion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && transaccion.getConCambioAuxiliar()) {
			transaccion.setIsDeleted(transaccion.getIsDeletedAuxiliar());	
			transaccion.setIsNew(transaccion.getIsNewAuxiliar());	
			transaccion.setIsChanged(transaccion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			transaccion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			transaccion.setIsDeletedAuxiliar(false);	
			transaccion.setIsNewAuxiliar(false);	
			transaccion.setIsChangedAuxiliar(false);
			
			transaccion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransaccions(List<Transaccion> transaccions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Transaccion transaccion : transaccions) {
			if(conAsignarBase && transaccion.getConCambioAuxiliar()) {
				transaccion.setIsDeleted(transaccion.getIsDeletedAuxiliar());	
				transaccion.setIsNew(transaccion.getIsNewAuxiliar());	
				transaccion.setIsChanged(transaccion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				transaccion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				transaccion.setIsDeletedAuxiliar(false);	
				transaccion.setIsNewAuxiliar(false);	
				transaccion.setIsChangedAuxiliar(false);
				
				transaccion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTransaccion(Transaccion transaccion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTransaccions(List<Transaccion> transaccions,Boolean conEnteros) throws Exception  {
		
		for(Transaccion transaccion: transaccions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTransaccion(List<Transaccion> transaccions,Transaccion transaccionAux) throws Exception  {
		TransaccionConstantesFunciones.InicializarValoresTransaccion(transaccionAux,true);
		
		for(Transaccion transaccion: transaccions) {
			if(transaccion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTransaccion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TransaccionConstantesFunciones.getArrayColumnasGlobalesTransaccion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTransaccion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransaccionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransaccionConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransaccionConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransaccionConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransaccionConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransaccionConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTransaccion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Transaccion> transaccions,Transaccion transaccion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Transaccion transaccionAux: transaccions) {
			if(transaccionAux!=null && transaccion!=null) {
				if((transaccionAux.getId()==null && transaccion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(transaccionAux.getId()!=null && transaccion.getId()!=null){
					if(transaccionAux.getId().equals(transaccion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTransaccion(List<Transaccion> transaccions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Transaccion transaccion: transaccions) {			
			if(transaccion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTransaccion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TransaccionConstantesFunciones.LABEL_ID, TransaccionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionConstantesFunciones.LABEL_VERSIONROW, TransaccionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionConstantesFunciones.LABEL_IDEMPRESA, TransaccionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionConstantesFunciones.LABEL_IDSUCURSAL, TransaccionConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionConstantesFunciones.LABEL_CODIGO, TransaccionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionConstantesFunciones.LABEL_NOMBRE, TransaccionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionConstantesFunciones.LABEL_IDMODULO, TransaccionConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionConstantesFunciones.LABEL_IDTIPOTRANSA, TransaccionConstantesFunciones.IDTIPOTRANSA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionConstantesFunciones.LABEL_IDTIPOCOMPROBANTE, TransaccionConstantesFunciones.IDTIPOCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO, TransaccionConstantesFunciones.IDTIPOTRANSACCIONMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionConstantesFunciones.LABEL_IDTIPORETENCION, TransaccionConstantesFunciones.IDTIPORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionConstantesFunciones.LABEL_IDCUENTACONTABLE, TransaccionConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionConstantesFunciones.LABEL_DESCRIPCION, TransaccionConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTransaccion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TransaccionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionConstantesFunciones.IDTIPOTRANSA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionConstantesFunciones.IDTIPOCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionConstantesFunciones.IDTIPOTRANSACCIONMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionConstantesFunciones.IDTIPORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransaccion() throws Exception  {
		return TransaccionConstantesFunciones.getTiposSeleccionarTransaccion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransaccion(Boolean conFk) throws Exception  {
		return TransaccionConstantesFunciones.getTiposSeleccionarTransaccion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransaccion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TransaccionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(TransaccionConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TransaccionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TransaccionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(TransaccionConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionConstantesFunciones.LABEL_IDTIPOTRANSA);
			reporte.setsDescripcion(TransaccionConstantesFunciones.LABEL_IDTIPOTRANSA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionConstantesFunciones.LABEL_IDTIPOCOMPROBANTE);
			reporte.setsDescripcion(TransaccionConstantesFunciones.LABEL_IDTIPOCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
			reporte.setsDescripcion(TransaccionConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionConstantesFunciones.LABEL_IDTIPORETENCION);
			reporte.setsDescripcion(TransaccionConstantesFunciones.LABEL_IDTIPORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(TransaccionConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TransaccionConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTransaccion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTransaccion(Transaccion transaccionAux) throws Exception {
		
			transaccionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(transaccionAux.getEmpresa()));
			transaccionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(transaccionAux.getSucursal()));
			transaccionAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(transaccionAux.getModulo()));
			transaccionAux.settipotransa_descripcion(TipoTransaConstantesFunciones.getTipoTransaDescripcion(transaccionAux.getTipoTransa()));
			transaccionAux.settipocomprobante_descripcion(TipoComprobanteConstantesFunciones.getTipoComprobanteDescripcion(transaccionAux.getTipoComprobante()));
			transaccionAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(transaccionAux.getTipoTransaccionModulo()));
			transaccionAux.settiporetencion_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(transaccionAux.getTipoRetencion()));
			transaccionAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(transaccionAux.getCuentaContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTransaccion(List<Transaccion> transaccionsTemp) throws Exception {
		for(Transaccion transaccionAux:transaccionsTemp) {
			
			transaccionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(transaccionAux.getEmpresa()));
			transaccionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(transaccionAux.getSucursal()));
			transaccionAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(transaccionAux.getModulo()));
			transaccionAux.settipotransa_descripcion(TipoTransaConstantesFunciones.getTipoTransaDescripcion(transaccionAux.getTipoTransa()));
			transaccionAux.settipocomprobante_descripcion(TipoComprobanteConstantesFunciones.getTipoComprobanteDescripcion(transaccionAux.getTipoComprobante()));
			transaccionAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(transaccionAux.getTipoTransaccionModulo()));
			transaccionAux.settiporetencion_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(transaccionAux.getTipoRetencion()));
			transaccionAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(transaccionAux.getCuentaContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTransaccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(TipoTransa.class));
				classes.add(new Classe(TipoComprobante.class));
				classes.add(new Classe(TipoTransaccionModulo.class));
				classes.add(new Classe(TipoRetencion.class));
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
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTransa.class)) {
						classes.add(new Classe(TipoTransa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoComprobante.class)) {
						classes.add(new Classe(TipoComprobante.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTransaccionModulo.class)) {
						classes.add(new Classe(TipoTransaccionModulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencion.class)) {
						classes.add(new Classe(TipoRetencion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTransaccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoTransa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransa.class)); continue;
					}

					if(TipoComprobante.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoComprobante.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
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

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoTransa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransa.class)); continue;
					}

					if(TipoComprobante.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoComprobante.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransaccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransaccionConstantesFunciones.getClassesRelationshipsOfTransaccion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransaccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransaccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransaccionConstantesFunciones.getClassesRelationshipsFromStringsOfTransaccion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransaccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(Transaccion transaccion,List<Transaccion> transaccions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Transaccion transaccionEncontrado=null;
			
			for(Transaccion transaccionLocal:transaccions) {
				if(transaccionLocal.getId().equals(transaccion.getId())) {
					transaccionEncontrado=transaccionLocal;
					
					transaccionLocal.setIsChanged(transaccion.getIsChanged());
					transaccionLocal.setIsNew(transaccion.getIsNew());
					transaccionLocal.setIsDeleted(transaccion.getIsDeleted());
					
					transaccionLocal.setGeneralEntityOriginal(transaccion.getGeneralEntityOriginal());
					
					transaccionLocal.setId(transaccion.getId());	
					transaccionLocal.setVersionRow(transaccion.getVersionRow());	
					transaccionLocal.setid_empresa(transaccion.getid_empresa());	
					transaccionLocal.setid_sucursal(transaccion.getid_sucursal());	
					transaccionLocal.setcodigo(transaccion.getcodigo());	
					transaccionLocal.setnombre(transaccion.getnombre());	
					transaccionLocal.setid_modulo(transaccion.getid_modulo());	
					transaccionLocal.setid_tipo_transa(transaccion.getid_tipo_transa());	
					transaccionLocal.setid_tipo_comprobante(transaccion.getid_tipo_comprobante());	
					transaccionLocal.setid_tipo_transaccion_modulo(transaccion.getid_tipo_transaccion_modulo());	
					transaccionLocal.setid_tipo_retencion(transaccion.getid_tipo_retencion());	
					transaccionLocal.setid_cuenta_contable(transaccion.getid_cuenta_contable());	
					transaccionLocal.setdescripcion(transaccion.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!transaccion.getIsDeleted()) {
				if(!existe) {
					transaccions.add(transaccion);
				}
			} else {
				if(transaccionEncontrado!=null && permiteQuitar)  {
					transaccions.remove(transaccionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Transaccion transaccion,List<Transaccion> transaccions) throws Exception {
		try	{			
			for(Transaccion transaccionLocal:transaccions) {
				if(transaccionLocal.getId().equals(transaccion.getId())) {
					transaccionLocal.setIsSelected(transaccion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTransaccion(List<Transaccion> transaccionsAux) throws Exception {
		//this.transaccionsAux=transaccionsAux;
		
		for(Transaccion transaccionAux:transaccionsAux) {
			if(transaccionAux.getIsChanged()) {
				transaccionAux.setIsChanged(false);
			}		
			
			if(transaccionAux.getIsNew()) {
				transaccionAux.setIsNew(false);
			}	
			
			if(transaccionAux.getIsDeleted()) {
				transaccionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTransaccion(Transaccion transaccionAux) throws Exception {
		//this.transaccionAux=transaccionAux;
		
			if(transaccionAux.getIsChanged()) {
				transaccionAux.setIsChanged(false);
			}		
			
			if(transaccionAux.getIsNew()) {
				transaccionAux.setIsNew(false);
			}	
			
			if(transaccionAux.getIsDeleted()) {
				transaccionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Transaccion transaccionAsignar,Transaccion transaccion) throws Exception {
		transaccionAsignar.setId(transaccion.getId());	
		transaccionAsignar.setVersionRow(transaccion.getVersionRow());	
		transaccionAsignar.setid_empresa(transaccion.getid_empresa());
		transaccionAsignar.setempresa_descripcion(transaccion.getempresa_descripcion());	
		transaccionAsignar.setid_sucursal(transaccion.getid_sucursal());
		transaccionAsignar.setsucursal_descripcion(transaccion.getsucursal_descripcion());	
		transaccionAsignar.setcodigo(transaccion.getcodigo());	
		transaccionAsignar.setnombre(transaccion.getnombre());	
		transaccionAsignar.setid_modulo(transaccion.getid_modulo());
		transaccionAsignar.setmodulo_descripcion(transaccion.getmodulo_descripcion());	
		transaccionAsignar.setid_tipo_transa(transaccion.getid_tipo_transa());
		transaccionAsignar.settipotransa_descripcion(transaccion.gettipotransa_descripcion());	
		transaccionAsignar.setid_tipo_comprobante(transaccion.getid_tipo_comprobante());
		transaccionAsignar.settipocomprobante_descripcion(transaccion.gettipocomprobante_descripcion());	
		transaccionAsignar.setid_tipo_transaccion_modulo(transaccion.getid_tipo_transaccion_modulo());
		transaccionAsignar.settipotransaccionmodulo_descripcion(transaccion.gettipotransaccionmodulo_descripcion());	
		transaccionAsignar.setid_tipo_retencion(transaccion.getid_tipo_retencion());
		transaccionAsignar.settiporetencion_descripcion(transaccion.gettiporetencion_descripcion());	
		transaccionAsignar.setid_cuenta_contable(transaccion.getid_cuenta_contable());
		transaccionAsignar.setcuentacontable_descripcion(transaccion.getcuentacontable_descripcion());	
		transaccionAsignar.setdescripcion(transaccion.getdescripcion());	
	}
	
	public static void inicializarTransaccion(Transaccion transaccion) throws Exception {
		try {
				transaccion.setId(0L);	
					
				transaccion.setid_empresa(-1L);	
				transaccion.setid_sucursal(-1L);	
				transaccion.setcodigo("");	
				transaccion.setnombre("");	
				transaccion.setid_modulo(-1L);	
				transaccion.setid_tipo_transa(-1L);	
				transaccion.setid_tipo_comprobante(null);	
				transaccion.setid_tipo_transaccion_modulo(null);	
				transaccion.setid_tipo_retencion(-1L);	
				transaccion.setid_cuenta_contable(null);	
				transaccion.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTransaccion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionConstantesFunciones.LABEL_IDTIPOTRANSA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionConstantesFunciones.LABEL_IDTIPOCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionConstantesFunciones.LABEL_IDTIPORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTransaccion(String sTipo,Row row,Workbook workbook,Transaccion transaccion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccion.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccion.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccion.gettipotransa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccion.gettipocomprobante_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccion.gettipotransaccionmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccion.gettiporetencion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccion.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccion.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTransaccion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTransaccion() {
		return this.sFinalQueryTransaccion;
	}
	
	public void setsFinalQueryTransaccion(String sFinalQueryTransaccion) {
		this.sFinalQueryTransaccion= sFinalQueryTransaccion;
	}
	
	public Border resaltarSeleccionarTransaccion=null;
	
	public Border setResaltarSeleccionarTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//transaccionBeanSwingJInternalFrame.jTtoolBarTransaccion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTransaccion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTransaccion() {
		return this.resaltarSeleccionarTransaccion;
	}
	
	public void setResaltarSeleccionarTransaccion(Border borderResaltarSeleccionarTransaccion) {
		this.resaltarSeleccionarTransaccion= borderResaltarSeleccionarTransaccion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTransaccion=null;
	public Boolean mostraridTransaccion=true;
	public Boolean activaridTransaccion=true;

	public Border resaltarid_empresaTransaccion=null;
	public Boolean mostrarid_empresaTransaccion=true;
	public Boolean activarid_empresaTransaccion=true;
	public Boolean cargarid_empresaTransaccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTransaccion=false;//ConEventDepend=true

	public Border resaltarid_sucursalTransaccion=null;
	public Boolean mostrarid_sucursalTransaccion=true;
	public Boolean activarid_sucursalTransaccion=true;
	public Boolean cargarid_sucursalTransaccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalTransaccion=false;//ConEventDepend=true

	public Border resaltarcodigoTransaccion=null;
	public Boolean mostrarcodigoTransaccion=true;
	public Boolean activarcodigoTransaccion=true;

	public Border resaltarnombreTransaccion=null;
	public Boolean mostrarnombreTransaccion=true;
	public Boolean activarnombreTransaccion=true;

	public Border resaltarid_moduloTransaccion=null;
	public Boolean mostrarid_moduloTransaccion=true;
	public Boolean activarid_moduloTransaccion=true;
	public Boolean cargarid_moduloTransaccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloTransaccion=false;//ConEventDepend=true

	public Border resaltarid_tipo_transaTransaccion=null;
	public Boolean mostrarid_tipo_transaTransaccion=true;
	public Boolean activarid_tipo_transaTransaccion=true;
	public Boolean cargarid_tipo_transaTransaccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_transaTransaccion=false;//ConEventDepend=true

	public Border resaltarid_tipo_comprobanteTransaccion=null;
	public Boolean mostrarid_tipo_comprobanteTransaccion=true;
	public Boolean activarid_tipo_comprobanteTransaccion=true;
	public Boolean cargarid_tipo_comprobanteTransaccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_comprobanteTransaccion=false;//ConEventDepend=true

	public Border resaltarid_tipo_transaccion_moduloTransaccion=null;
	public Boolean mostrarid_tipo_transaccion_moduloTransaccion=true;
	public Boolean activarid_tipo_transaccion_moduloTransaccion=false;
	public Boolean cargarid_tipo_transaccion_moduloTransaccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_transaccion_moduloTransaccion=true;//ConEventDepend=true

	public Border resaltarid_tipo_retencionTransaccion=null;
	public Boolean mostrarid_tipo_retencionTransaccion=true;
	public Boolean activarid_tipo_retencionTransaccion=true;
	public Boolean cargarid_tipo_retencionTransaccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencionTransaccion=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableTransaccion=null;
	public Boolean mostrarid_cuenta_contableTransaccion=true;
	public Boolean activarid_cuenta_contableTransaccion=true;
	public Boolean cargarid_cuenta_contableTransaccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableTransaccion=false;//ConEventDepend=true

	public Border resaltardescripcionTransaccion=null;
	public Boolean mostrardescripcionTransaccion=true;
	public Boolean activardescripcionTransaccion=true;

	
	

	public Border setResaltaridTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionBeanSwingJInternalFrame.jTtoolBarTransaccion.setBorder(borderResaltar);
		
		this.resaltaridTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTransaccion() {
		return this.resaltaridTransaccion;
	}

	public void setResaltaridTransaccion(Border borderResaltar) {
		this.resaltaridTransaccion= borderResaltar;
	}

	public Boolean getMostraridTransaccion() {
		return this.mostraridTransaccion;
	}

	public void setMostraridTransaccion(Boolean mostraridTransaccion) {
		this.mostraridTransaccion= mostraridTransaccion;
	}

	public Boolean getActivaridTransaccion() {
		return this.activaridTransaccion;
	}

	public void setActivaridTransaccion(Boolean activaridTransaccion) {
		this.activaridTransaccion= activaridTransaccion;
	}

	public Border setResaltarid_empresaTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionBeanSwingJInternalFrame.jTtoolBarTransaccion.setBorder(borderResaltar);
		
		this.resaltarid_empresaTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTransaccion() {
		return this.resaltarid_empresaTransaccion;
	}

	public void setResaltarid_empresaTransaccion(Border borderResaltar) {
		this.resaltarid_empresaTransaccion= borderResaltar;
	}

	public Boolean getMostrarid_empresaTransaccion() {
		return this.mostrarid_empresaTransaccion;
	}

	public void setMostrarid_empresaTransaccion(Boolean mostrarid_empresaTransaccion) {
		this.mostrarid_empresaTransaccion= mostrarid_empresaTransaccion;
	}

	public Boolean getActivarid_empresaTransaccion() {
		return this.activarid_empresaTransaccion;
	}

	public void setActivarid_empresaTransaccion(Boolean activarid_empresaTransaccion) {
		this.activarid_empresaTransaccion= activarid_empresaTransaccion;
	}

	public Boolean getCargarid_empresaTransaccion() {
		return this.cargarid_empresaTransaccion;
	}

	public void setCargarid_empresaTransaccion(Boolean cargarid_empresaTransaccion) {
		this.cargarid_empresaTransaccion= cargarid_empresaTransaccion;
	}

	public Border setResaltarid_sucursalTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionBeanSwingJInternalFrame.jTtoolBarTransaccion.setBorder(borderResaltar);
		
		this.resaltarid_sucursalTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalTransaccion() {
		return this.resaltarid_sucursalTransaccion;
	}

	public void setResaltarid_sucursalTransaccion(Border borderResaltar) {
		this.resaltarid_sucursalTransaccion= borderResaltar;
	}

	public Boolean getMostrarid_sucursalTransaccion() {
		return this.mostrarid_sucursalTransaccion;
	}

	public void setMostrarid_sucursalTransaccion(Boolean mostrarid_sucursalTransaccion) {
		this.mostrarid_sucursalTransaccion= mostrarid_sucursalTransaccion;
	}

	public Boolean getActivarid_sucursalTransaccion() {
		return this.activarid_sucursalTransaccion;
	}

	public void setActivarid_sucursalTransaccion(Boolean activarid_sucursalTransaccion) {
		this.activarid_sucursalTransaccion= activarid_sucursalTransaccion;
	}

	public Boolean getCargarid_sucursalTransaccion() {
		return this.cargarid_sucursalTransaccion;
	}

	public void setCargarid_sucursalTransaccion(Boolean cargarid_sucursalTransaccion) {
		this.cargarid_sucursalTransaccion= cargarid_sucursalTransaccion;
	}

	public Border setResaltarcodigoTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionBeanSwingJInternalFrame.jTtoolBarTransaccion.setBorder(borderResaltar);
		
		this.resaltarcodigoTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTransaccion() {
		return this.resaltarcodigoTransaccion;
	}

	public void setResaltarcodigoTransaccion(Border borderResaltar) {
		this.resaltarcodigoTransaccion= borderResaltar;
	}

	public Boolean getMostrarcodigoTransaccion() {
		return this.mostrarcodigoTransaccion;
	}

	public void setMostrarcodigoTransaccion(Boolean mostrarcodigoTransaccion) {
		this.mostrarcodigoTransaccion= mostrarcodigoTransaccion;
	}

	public Boolean getActivarcodigoTransaccion() {
		return this.activarcodigoTransaccion;
	}

	public void setActivarcodigoTransaccion(Boolean activarcodigoTransaccion) {
		this.activarcodigoTransaccion= activarcodigoTransaccion;
	}

	public Border setResaltarnombreTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionBeanSwingJInternalFrame.jTtoolBarTransaccion.setBorder(borderResaltar);
		
		this.resaltarnombreTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTransaccion() {
		return this.resaltarnombreTransaccion;
	}

	public void setResaltarnombreTransaccion(Border borderResaltar) {
		this.resaltarnombreTransaccion= borderResaltar;
	}

	public Boolean getMostrarnombreTransaccion() {
		return this.mostrarnombreTransaccion;
	}

	public void setMostrarnombreTransaccion(Boolean mostrarnombreTransaccion) {
		this.mostrarnombreTransaccion= mostrarnombreTransaccion;
	}

	public Boolean getActivarnombreTransaccion() {
		return this.activarnombreTransaccion;
	}

	public void setActivarnombreTransaccion(Boolean activarnombreTransaccion) {
		this.activarnombreTransaccion= activarnombreTransaccion;
	}

	public Border setResaltarid_moduloTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionBeanSwingJInternalFrame.jTtoolBarTransaccion.setBorder(borderResaltar);
		
		this.resaltarid_moduloTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloTransaccion() {
		return this.resaltarid_moduloTransaccion;
	}

	public void setResaltarid_moduloTransaccion(Border borderResaltar) {
		this.resaltarid_moduloTransaccion= borderResaltar;
	}

	public Boolean getMostrarid_moduloTransaccion() {
		return this.mostrarid_moduloTransaccion;
	}

	public void setMostrarid_moduloTransaccion(Boolean mostrarid_moduloTransaccion) {
		this.mostrarid_moduloTransaccion= mostrarid_moduloTransaccion;
	}

	public Boolean getActivarid_moduloTransaccion() {
		return this.activarid_moduloTransaccion;
	}

	public void setActivarid_moduloTransaccion(Boolean activarid_moduloTransaccion) {
		this.activarid_moduloTransaccion= activarid_moduloTransaccion;
	}

	public Boolean getCargarid_moduloTransaccion() {
		return this.cargarid_moduloTransaccion;
	}

	public void setCargarid_moduloTransaccion(Boolean cargarid_moduloTransaccion) {
		this.cargarid_moduloTransaccion= cargarid_moduloTransaccion;
	}

	public Border setResaltarid_tipo_transaTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionBeanSwingJInternalFrame.jTtoolBarTransaccion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_transaTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_transaTransaccion() {
		return this.resaltarid_tipo_transaTransaccion;
	}

	public void setResaltarid_tipo_transaTransaccion(Border borderResaltar) {
		this.resaltarid_tipo_transaTransaccion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_transaTransaccion() {
		return this.mostrarid_tipo_transaTransaccion;
	}

	public void setMostrarid_tipo_transaTransaccion(Boolean mostrarid_tipo_transaTransaccion) {
		this.mostrarid_tipo_transaTransaccion= mostrarid_tipo_transaTransaccion;
	}

	public Boolean getActivarid_tipo_transaTransaccion() {
		return this.activarid_tipo_transaTransaccion;
	}

	public void setActivarid_tipo_transaTransaccion(Boolean activarid_tipo_transaTransaccion) {
		this.activarid_tipo_transaTransaccion= activarid_tipo_transaTransaccion;
	}

	public Boolean getCargarid_tipo_transaTransaccion() {
		return this.cargarid_tipo_transaTransaccion;
	}

	public void setCargarid_tipo_transaTransaccion(Boolean cargarid_tipo_transaTransaccion) {
		this.cargarid_tipo_transaTransaccion= cargarid_tipo_transaTransaccion;
	}

	public Border setResaltarid_tipo_comprobanteTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionBeanSwingJInternalFrame.jTtoolBarTransaccion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_comprobanteTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_comprobanteTransaccion() {
		return this.resaltarid_tipo_comprobanteTransaccion;
	}

	public void setResaltarid_tipo_comprobanteTransaccion(Border borderResaltar) {
		this.resaltarid_tipo_comprobanteTransaccion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_comprobanteTransaccion() {
		return this.mostrarid_tipo_comprobanteTransaccion;
	}

	public void setMostrarid_tipo_comprobanteTransaccion(Boolean mostrarid_tipo_comprobanteTransaccion) {
		this.mostrarid_tipo_comprobanteTransaccion= mostrarid_tipo_comprobanteTransaccion;
	}

	public Boolean getActivarid_tipo_comprobanteTransaccion() {
		return this.activarid_tipo_comprobanteTransaccion;
	}

	public void setActivarid_tipo_comprobanteTransaccion(Boolean activarid_tipo_comprobanteTransaccion) {
		this.activarid_tipo_comprobanteTransaccion= activarid_tipo_comprobanteTransaccion;
	}

	public Boolean getCargarid_tipo_comprobanteTransaccion() {
		return this.cargarid_tipo_comprobanteTransaccion;
	}

	public void setCargarid_tipo_comprobanteTransaccion(Boolean cargarid_tipo_comprobanteTransaccion) {
		this.cargarid_tipo_comprobanteTransaccion= cargarid_tipo_comprobanteTransaccion;
	}

	public Border setResaltarid_tipo_transaccion_moduloTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionBeanSwingJInternalFrame.jTtoolBarTransaccion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_transaccion_moduloTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_transaccion_moduloTransaccion() {
		return this.resaltarid_tipo_transaccion_moduloTransaccion;
	}

	public void setResaltarid_tipo_transaccion_moduloTransaccion(Border borderResaltar) {
		this.resaltarid_tipo_transaccion_moduloTransaccion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_transaccion_moduloTransaccion() {
		return this.mostrarid_tipo_transaccion_moduloTransaccion;
	}

	public void setMostrarid_tipo_transaccion_moduloTransaccion(Boolean mostrarid_tipo_transaccion_moduloTransaccion) {
		this.mostrarid_tipo_transaccion_moduloTransaccion= mostrarid_tipo_transaccion_moduloTransaccion;
	}

	public Boolean getActivarid_tipo_transaccion_moduloTransaccion() {
		return this.activarid_tipo_transaccion_moduloTransaccion;
	}

	public void setActivarid_tipo_transaccion_moduloTransaccion(Boolean activarid_tipo_transaccion_moduloTransaccion) {
		this.activarid_tipo_transaccion_moduloTransaccion= activarid_tipo_transaccion_moduloTransaccion;
	}

	public Boolean getCargarid_tipo_transaccion_moduloTransaccion() {
		return this.cargarid_tipo_transaccion_moduloTransaccion;
	}

	public void setCargarid_tipo_transaccion_moduloTransaccion(Boolean cargarid_tipo_transaccion_moduloTransaccion) {
		this.cargarid_tipo_transaccion_moduloTransaccion= cargarid_tipo_transaccion_moduloTransaccion;
	}

	public Border setResaltarid_tipo_retencionTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionBeanSwingJInternalFrame.jTtoolBarTransaccion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencionTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencionTransaccion() {
		return this.resaltarid_tipo_retencionTransaccion;
	}

	public void setResaltarid_tipo_retencionTransaccion(Border borderResaltar) {
		this.resaltarid_tipo_retencionTransaccion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencionTransaccion() {
		return this.mostrarid_tipo_retencionTransaccion;
	}

	public void setMostrarid_tipo_retencionTransaccion(Boolean mostrarid_tipo_retencionTransaccion) {
		this.mostrarid_tipo_retencionTransaccion= mostrarid_tipo_retencionTransaccion;
	}

	public Boolean getActivarid_tipo_retencionTransaccion() {
		return this.activarid_tipo_retencionTransaccion;
	}

	public void setActivarid_tipo_retencionTransaccion(Boolean activarid_tipo_retencionTransaccion) {
		this.activarid_tipo_retencionTransaccion= activarid_tipo_retencionTransaccion;
	}

	public Boolean getCargarid_tipo_retencionTransaccion() {
		return this.cargarid_tipo_retencionTransaccion;
	}

	public void setCargarid_tipo_retencionTransaccion(Boolean cargarid_tipo_retencionTransaccion) {
		this.cargarid_tipo_retencionTransaccion= cargarid_tipo_retencionTransaccion;
	}

	public Border setResaltarid_cuenta_contableTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionBeanSwingJInternalFrame.jTtoolBarTransaccion.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableTransaccion() {
		return this.resaltarid_cuenta_contableTransaccion;
	}

	public void setResaltarid_cuenta_contableTransaccion(Border borderResaltar) {
		this.resaltarid_cuenta_contableTransaccion= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableTransaccion() {
		return this.mostrarid_cuenta_contableTransaccion;
	}

	public void setMostrarid_cuenta_contableTransaccion(Boolean mostrarid_cuenta_contableTransaccion) {
		this.mostrarid_cuenta_contableTransaccion= mostrarid_cuenta_contableTransaccion;
	}

	public Boolean getActivarid_cuenta_contableTransaccion() {
		return this.activarid_cuenta_contableTransaccion;
	}

	public void setActivarid_cuenta_contableTransaccion(Boolean activarid_cuenta_contableTransaccion) {
		this.activarid_cuenta_contableTransaccion= activarid_cuenta_contableTransaccion;
	}

	public Boolean getCargarid_cuenta_contableTransaccion() {
		return this.cargarid_cuenta_contableTransaccion;
	}

	public void setCargarid_cuenta_contableTransaccion(Boolean cargarid_cuenta_contableTransaccion) {
		this.cargarid_cuenta_contableTransaccion= cargarid_cuenta_contableTransaccion;
	}

	public Border setResaltardescripcionTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionBeanSwingJInternalFrame.jTtoolBarTransaccion.setBorder(borderResaltar);
		
		this.resaltardescripcionTransaccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTransaccion() {
		return this.resaltardescripcionTransaccion;
	}

	public void setResaltardescripcionTransaccion(Border borderResaltar) {
		this.resaltardescripcionTransaccion= borderResaltar;
	}

	public Boolean getMostrardescripcionTransaccion() {
		return this.mostrardescripcionTransaccion;
	}

	public void setMostrardescripcionTransaccion(Boolean mostrardescripcionTransaccion) {
		this.mostrardescripcionTransaccion= mostrardescripcionTransaccion;
	}

	public Boolean getActivardescripcionTransaccion() {
		return this.activardescripcionTransaccion;
	}

	public void setActivardescripcionTransaccion(Boolean activardescripcionTransaccion) {
		this.activardescripcionTransaccion= activardescripcionTransaccion;
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
		
		
		this.setMostraridTransaccion(esInicial);
		this.setMostrarid_empresaTransaccion(esInicial);
		this.setMostrarid_sucursalTransaccion(esInicial);
		this.setMostrarcodigoTransaccion(esInicial);
		this.setMostrarnombreTransaccion(esInicial);
		this.setMostrarid_moduloTransaccion(esInicial);
		this.setMostrarid_tipo_transaTransaccion(esInicial);
		this.setMostrarid_tipo_comprobanteTransaccion(esInicial);
		this.setMostrarid_tipo_transaccion_moduloTransaccion(esInicial);
		this.setMostrarid_tipo_retencionTransaccion(esInicial);
		this.setMostrarid_cuenta_contableTransaccion(esInicial);
		this.setMostrardescripcionTransaccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransaccionConstantesFunciones.ID)) {
				this.setMostraridTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDTIPOTRANSA)) {
				this.setMostrarid_tipo_transaTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDTIPOCOMPROBANTE)) {
				this.setMostrarid_tipo_comprobanteTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setMostrarid_tipo_transaccion_moduloTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDTIPORETENCION)) {
				this.setMostrarid_tipo_retencionTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTransaccion(esAsigna);
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
		
		
		this.setActivaridTransaccion(esInicial);
		this.setActivarid_empresaTransaccion(esInicial);
		this.setActivarid_sucursalTransaccion(esInicial);
		this.setActivarcodigoTransaccion(esInicial);
		this.setActivarnombreTransaccion(esInicial);
		this.setActivarid_moduloTransaccion(esInicial);
		this.setActivarid_tipo_transaTransaccion(esInicial);
		this.setActivarid_tipo_comprobanteTransaccion(esInicial);
		this.setActivarid_tipo_transaccion_moduloTransaccion(esInicial);
		this.setActivarid_tipo_retencionTransaccion(esInicial);
		this.setActivarid_cuenta_contableTransaccion(esInicial);
		this.setActivardescripcionTransaccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransaccionConstantesFunciones.ID)) {
				this.setActivaridTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDTIPOTRANSA)) {
				this.setActivarid_tipo_transaTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDTIPOCOMPROBANTE)) {
				this.setActivarid_tipo_comprobanteTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setActivarid_tipo_transaccion_moduloTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDTIPORETENCION)) {
				this.setActivarid_tipo_retencionTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTransaccion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTransaccion(esInicial);
		this.setResaltarid_empresaTransaccion(esInicial);
		this.setResaltarid_sucursalTransaccion(esInicial);
		this.setResaltarcodigoTransaccion(esInicial);
		this.setResaltarnombreTransaccion(esInicial);
		this.setResaltarid_moduloTransaccion(esInicial);
		this.setResaltarid_tipo_transaTransaccion(esInicial);
		this.setResaltarid_tipo_comprobanteTransaccion(esInicial);
		this.setResaltarid_tipo_transaccion_moduloTransaccion(esInicial);
		this.setResaltarid_tipo_retencionTransaccion(esInicial);
		this.setResaltarid_cuenta_contableTransaccion(esInicial);
		this.setResaltardescripcionTransaccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransaccionConstantesFunciones.ID)) {
				this.setResaltaridTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDTIPOTRANSA)) {
				this.setResaltarid_tipo_transaTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDTIPOCOMPROBANTE)) {
				this.setResaltarid_tipo_comprobanteTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setResaltarid_tipo_transaccion_moduloTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDTIPORETENCION)) {
				this.setResaltarid_tipo_retencionTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableTransaccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTransaccion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoTransaccion=true;

	public Boolean getMostrarBusquedaPorCodigoTransaccion() {
		return this.mostrarBusquedaPorCodigoTransaccion;
	}

	public void setMostrarBusquedaPorCodigoTransaccion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTransaccion= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorIdModuloPorTipoTransaccionTransaccion=true;

	public Boolean getMostrarBusquedaPorIdModuloPorTipoTransaccionTransaccion() {
		return this.mostrarBusquedaPorIdModuloPorTipoTransaccionTransaccion;
	}

	public void setMostrarBusquedaPorIdModuloPorTipoTransaccionTransaccion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdModuloPorTipoTransaccionTransaccion= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTransaccion=true;

	public Boolean getMostrarBusquedaPorNombreTransaccion() {
		return this.mostrarBusquedaPorNombreTransaccion;
	}

	public void setMostrarBusquedaPorNombreTransaccion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTransaccion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableTransaccion=true;

	public Boolean getMostrarFK_IdCuentaContableTransaccion() {
		return this.mostrarFK_IdCuentaContableTransaccion;
	}

	public void setMostrarFK_IdCuentaContableTransaccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableTransaccion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTransaccion=true;

	public Boolean getMostrarFK_IdEmpresaTransaccion() {
		return this.mostrarFK_IdEmpresaTransaccion;
	}

	public void setMostrarFK_IdEmpresaTransaccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTransaccion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloTransaccion=true;

	public Boolean getMostrarFK_IdModuloTransaccion() {
		return this.mostrarFK_IdModuloTransaccion;
	}

	public void setMostrarFK_IdModuloTransaccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloTransaccion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalTransaccion=true;

	public Boolean getMostrarFK_IdSucursalTransaccion() {
		return this.mostrarFK_IdSucursalTransaccion;
	}

	public void setMostrarFK_IdSucursalTransaccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalTransaccion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoComprobanteTransaccion=true;

	public Boolean getMostrarFK_IdTipoComprobanteTransaccion() {
		return this.mostrarFK_IdTipoComprobanteTransaccion;
	}

	public void setMostrarFK_IdTipoComprobanteTransaccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoComprobanteTransaccion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionTransaccion=true;

	public Boolean getMostrarFK_IdTipoRetencionTransaccion() {
		return this.mostrarFK_IdTipoRetencionTransaccion;
	}

	public void setMostrarFK_IdTipoRetencionTransaccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionTransaccion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTransaTransaccion=true;

	public Boolean getMostrarFK_IdTipoTransaTransaccion() {
		return this.mostrarFK_IdTipoTransaTransaccion;
	}

	public void setMostrarFK_IdTipoTransaTransaccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTransaTransaccion= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTransaccion=true;

	public Boolean getActivarBusquedaPorCodigoTransaccion() {
		return this.activarBusquedaPorCodigoTransaccion;
	}

	public void setActivarBusquedaPorCodigoTransaccion(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTransaccion= habilitarResaltar;
	}

	public Boolean activarBusquedaPorIdModuloPorTipoTransaccionTransaccion=true;

	public Boolean getActivarBusquedaPorIdModuloPorTipoTransaccionTransaccion() {
		return this.activarBusquedaPorIdModuloPorTipoTransaccionTransaccion;
	}

	public void setActivarBusquedaPorIdModuloPorTipoTransaccionTransaccion(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdModuloPorTipoTransaccionTransaccion= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTransaccion=true;

	public Boolean getActivarBusquedaPorNombreTransaccion() {
		return this.activarBusquedaPorNombreTransaccion;
	}

	public void setActivarBusquedaPorNombreTransaccion(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTransaccion= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableTransaccion=true;

	public Boolean getActivarFK_IdCuentaContableTransaccion() {
		return this.activarFK_IdCuentaContableTransaccion;
	}

	public void setActivarFK_IdCuentaContableTransaccion(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableTransaccion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTransaccion=true;

	public Boolean getActivarFK_IdEmpresaTransaccion() {
		return this.activarFK_IdEmpresaTransaccion;
	}

	public void setActivarFK_IdEmpresaTransaccion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTransaccion= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloTransaccion=true;

	public Boolean getActivarFK_IdModuloTransaccion() {
		return this.activarFK_IdModuloTransaccion;
	}

	public void setActivarFK_IdModuloTransaccion(Boolean habilitarResaltar) {
		this.activarFK_IdModuloTransaccion= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalTransaccion=true;

	public Boolean getActivarFK_IdSucursalTransaccion() {
		return this.activarFK_IdSucursalTransaccion;
	}

	public void setActivarFK_IdSucursalTransaccion(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalTransaccion= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoComprobanteTransaccion=true;

	public Boolean getActivarFK_IdTipoComprobanteTransaccion() {
		return this.activarFK_IdTipoComprobanteTransaccion;
	}

	public void setActivarFK_IdTipoComprobanteTransaccion(Boolean habilitarResaltar) {
		this.activarFK_IdTipoComprobanteTransaccion= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionTransaccion=true;

	public Boolean getActivarFK_IdTipoRetencionTransaccion() {
		return this.activarFK_IdTipoRetencionTransaccion;
	}

	public void setActivarFK_IdTipoRetencionTransaccion(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionTransaccion= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTransaTransaccion=true;

	public Boolean getActivarFK_IdTipoTransaTransaccion() {
		return this.activarFK_IdTipoTransaTransaccion;
	}

	public void setActivarFK_IdTipoTransaTransaccion(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTransaTransaccion= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTransaccion=null;

	public Border getResaltarBusquedaPorCodigoTransaccion() {
		return this.resaltarBusquedaPorCodigoTransaccion;
	}

	public void setResaltarBusquedaPorCodigoTransaccion(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTransaccion= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTransaccion= borderResaltar;
	}

	public Border resaltarBusquedaPorIdModuloPorTipoTransaccionTransaccion=null;

	public Border getResaltarBusquedaPorIdModuloPorTipoTransaccionTransaccion() {
		return this.resaltarBusquedaPorIdModuloPorTipoTransaccionTransaccion;
	}

	public void setResaltarBusquedaPorIdModuloPorTipoTransaccionTransaccion(Border borderResaltar) {
		this.resaltarBusquedaPorIdModuloPorTipoTransaccionTransaccion= borderResaltar;
	}

	public void setResaltarBusquedaPorIdModuloPorTipoTransaccionTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdModuloPorTipoTransaccionTransaccion= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTransaccion=null;

	public Border getResaltarBusquedaPorNombreTransaccion() {
		return this.resaltarBusquedaPorNombreTransaccion;
	}

	public void setResaltarBusquedaPorNombreTransaccion(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTransaccion= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTransaccion= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableTransaccion=null;

	public Border getResaltarFK_IdCuentaContableTransaccion() {
		return this.resaltarFK_IdCuentaContableTransaccion;
	}

	public void setResaltarFK_IdCuentaContableTransaccion(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableTransaccion= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableTransaccion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTransaccion=null;

	public Border getResaltarFK_IdEmpresaTransaccion() {
		return this.resaltarFK_IdEmpresaTransaccion;
	}

	public void setResaltarFK_IdEmpresaTransaccion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTransaccion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTransaccion= borderResaltar;
	}

	public Border resaltarFK_IdModuloTransaccion=null;

	public Border getResaltarFK_IdModuloTransaccion() {
		return this.resaltarFK_IdModuloTransaccion;
	}

	public void setResaltarFK_IdModuloTransaccion(Border borderResaltar) {
		this.resaltarFK_IdModuloTransaccion= borderResaltar;
	}

	public void setResaltarFK_IdModuloTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloTransaccion= borderResaltar;
	}

	public Border resaltarFK_IdSucursalTransaccion=null;

	public Border getResaltarFK_IdSucursalTransaccion() {
		return this.resaltarFK_IdSucursalTransaccion;
	}

	public void setResaltarFK_IdSucursalTransaccion(Border borderResaltar) {
		this.resaltarFK_IdSucursalTransaccion= borderResaltar;
	}

	public void setResaltarFK_IdSucursalTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalTransaccion= borderResaltar;
	}

	public Border resaltarFK_IdTipoComprobanteTransaccion=null;

	public Border getResaltarFK_IdTipoComprobanteTransaccion() {
		return this.resaltarFK_IdTipoComprobanteTransaccion;
	}

	public void setResaltarFK_IdTipoComprobanteTransaccion(Border borderResaltar) {
		this.resaltarFK_IdTipoComprobanteTransaccion= borderResaltar;
	}

	public void setResaltarFK_IdTipoComprobanteTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoComprobanteTransaccion= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionTransaccion=null;

	public Border getResaltarFK_IdTipoRetencionTransaccion() {
		return this.resaltarFK_IdTipoRetencionTransaccion;
	}

	public void setResaltarFK_IdTipoRetencionTransaccion(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionTransaccion= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionTransaccion= borderResaltar;
	}

	public Border resaltarFK_IdTipoTransaTransaccion=null;

	public Border getResaltarFK_IdTipoTransaTransaccion() {
		return this.resaltarFK_IdTipoTransaTransaccion;
	}

	public void setResaltarFK_IdTipoTransaTransaccion(Border borderResaltar) {
		this.resaltarFK_IdTipoTransaTransaccion= borderResaltar;
	}

	public void setResaltarFK_IdTipoTransaTransaccion(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionBeanSwingJInternalFrame transaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTransaTransaccion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}