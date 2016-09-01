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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.ParametroCarteraConstantesFunciones;
import com.bydan.erp.cartera.util.ParametroCarteraParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ParametroCarteraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroCarteraConstantesFunciones extends ParametroCarteraConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroCartera";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroCartera"+ParametroCarteraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroCarteraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroCarteraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroCarteraConstantesFunciones.SCHEMA+"_"+ParametroCarteraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroCarteraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroCarteraConstantesFunciones.SCHEMA+"_"+ParametroCarteraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroCarteraConstantesFunciones.SCHEMA+"_"+ParametroCarteraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroCarteraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroCarteraConstantesFunciones.SCHEMA+"_"+ParametroCarteraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroCarteraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroCarteraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroCarteraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroCarteraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroCarteraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroCarteraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroCarteraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroCarteraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroCarteraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroCarteraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Carteras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parametro Cartera";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Cartera";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroCartera";
	public static final String OBJECTNAME="parametrocartera";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="parametro_cartera";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametrocartera from "+ParametroCarteraConstantesFunciones.SPERSISTENCENAME+" parametrocartera";
	public static String QUERYSELECTNATIVE="select "+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".id,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".version_row,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".id_empresa,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".id_transaccion_factura,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".numero_digitos_factura,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".por_lotes,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".id_empleado,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".id_transaccion_deshabilita,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".id_transaccion_habilita,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".id_bodega,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".id_tipo_factura,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".id_tipo_auto_pago,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".numero_orden_pago,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".id_cuenta_contable_credito_fiscal,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".descripcion from "+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME;//+" as "+ParametroCarteraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroCarteraConstantesFuncionesAdditional parametrocarteraConstantesFuncionesAdditional=null;
	
	public ParametroCarteraConstantesFuncionesAdditional getParametroCarteraConstantesFuncionesAdditional() {
		return this.parametrocarteraConstantesFuncionesAdditional;
	}
	
	public void setParametroCarteraConstantesFuncionesAdditional(ParametroCarteraConstantesFuncionesAdditional parametrocarteraConstantesFuncionesAdditional) {
		try {
			this.parametrocarteraConstantesFuncionesAdditional=parametrocarteraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTRANSACCIONFACTURA= "id_transaccion_factura";
    public static final String NUMERODIGITOSFACTURA= "numero_digitos_factura";
    public static final String PORLOTES= "por_lotes";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDTRANSACCIONDESHABILITA= "id_transaccion_deshabilita";
    public static final String IDTRANSACCIONHABILITA= "id_transaccion_habilita";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDTIPOFACTURA= "id_tipo_factura";
    public static final String IDTIPOAUTOPAGO= "id_tipo_auto_pago";
    public static final String NUMEROORDENPAGO= "numero_orden_pago";
    public static final String IDCUENTACONTABLECREDITOFISCAL= "id_cuenta_contable_credito_fiscal";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTRANSACCIONFACTURA= "Transaccion Factura";
		public static final String LABEL_IDTRANSACCIONFACTURA_LOWER= "Transaccion Factura";
    	public static final String LABEL_NUMERODIGITOSFACTURA= "No Digitos Factura";
		public static final String LABEL_NUMERODIGITOSFACTURA_LOWER= "Numero Digitos Factura";
    	public static final String LABEL_PORLOTES= "Por Lotes";
		public static final String LABEL_PORLOTES_LOWER= "Por Lotes";
    	public static final String LABEL_IDEMPLEADO= "Tesorero";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDTRANSACCIONDESHABILITA= "Transaccion Deshabilita";
		public static final String LABEL_IDTRANSACCIONDESHABILITA_LOWER= "Transaccion Deshabilita";
    	public static final String LABEL_IDTRANSACCIONHABILITA= "Transaccion Habilita";
		public static final String LABEL_IDTRANSACCIONHABILITA_LOWER= "Transaccion Habilita";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDTIPOFACTURA= "Tipo Factura";
		public static final String LABEL_IDTIPOFACTURA_LOWER= "Tipo Factura";
    	public static final String LABEL_IDTIPOAUTOPAGO= "Tipo Auto Pago";
		public static final String LABEL_IDTIPOAUTOPAGO_LOWER= "Tipo Auto Pago";
    	public static final String LABEL_NUMEROORDENPAGO= "No Orden Pago";
		public static final String LABEL_NUMEROORDENPAGO_LOWER= "Numero Orden Pago";
    	public static final String LABEL_IDCUENTACONTABLECREDITOFISCAL= "Cuenta Contable Credito Fiscal";
		public static final String LABEL_IDCUENTACONTABLECREDITOFISCAL_LOWER= "Cuenta Contable Credito Fiscal";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_ORDEN_PAGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_ORDEN_PAGO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getParametroCarteraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroCarteraConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroCarteraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroCarteraConstantesFunciones.IDTRANSACCIONFACTURA)) {sLabelColumna=ParametroCarteraConstantesFunciones.LABEL_IDTRANSACCIONFACTURA;}
		if(sNombreColumna.equals(ParametroCarteraConstantesFunciones.NUMERODIGITOSFACTURA)) {sLabelColumna=ParametroCarteraConstantesFunciones.LABEL_NUMERODIGITOSFACTURA;}
		if(sNombreColumna.equals(ParametroCarteraConstantesFunciones.PORLOTES)) {sLabelColumna=ParametroCarteraConstantesFunciones.LABEL_PORLOTES;}
		if(sNombreColumna.equals(ParametroCarteraConstantesFunciones.IDEMPLEADO)) {sLabelColumna=ParametroCarteraConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(ParametroCarteraConstantesFunciones.IDTRANSACCIONDESHABILITA)) {sLabelColumna=ParametroCarteraConstantesFunciones.LABEL_IDTRANSACCIONDESHABILITA;}
		if(sNombreColumna.equals(ParametroCarteraConstantesFunciones.IDTRANSACCIONHABILITA)) {sLabelColumna=ParametroCarteraConstantesFunciones.LABEL_IDTRANSACCIONHABILITA;}
		if(sNombreColumna.equals(ParametroCarteraConstantesFunciones.IDBODEGA)) {sLabelColumna=ParametroCarteraConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ParametroCarteraConstantesFunciones.IDTIPOFACTURA)) {sLabelColumna=ParametroCarteraConstantesFunciones.LABEL_IDTIPOFACTURA;}
		if(sNombreColumna.equals(ParametroCarteraConstantesFunciones.IDTIPOAUTOPAGO)) {sLabelColumna=ParametroCarteraConstantesFunciones.LABEL_IDTIPOAUTOPAGO;}
		if(sNombreColumna.equals(ParametroCarteraConstantesFunciones.NUMEROORDENPAGO)) {sLabelColumna=ParametroCarteraConstantesFunciones.LABEL_NUMEROORDENPAGO;}
		if(sNombreColumna.equals(ParametroCarteraConstantesFunciones.IDCUENTACONTABLECREDITOFISCAL)) {sLabelColumna=ParametroCarteraConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFISCAL;}
		if(sNombreColumna.equals(ParametroCarteraConstantesFunciones.DESCRIPCION)) {sLabelColumna=ParametroCarteraConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
		
	public static String getpor_lotesDescripcion(ParametroCartera parametrocartera) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrocartera.getpor_lotes()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getpor_lotesHtmlDescripcion(ParametroCartera parametrocartera) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrocartera.getId(),parametrocartera.getpor_lotes());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
	
	public static String getParametroCarteraDescripcion(ParametroCartera parametrocartera) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametrocartera !=null/* && parametrocartera.getId()!=0*/) {
			if(parametrocartera.getId()!=null) {
				sDescripcion=parametrocartera.getId().toString();
			}//parametrocarteraparametrocartera.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroCarteraDescripcionDetallado(ParametroCartera parametrocartera) {
		String sDescripcion="";
			
		sDescripcion+=ParametroCarteraConstantesFunciones.ID+"=";
		sDescripcion+=parametrocartera.getId().toString()+",";
		sDescripcion+=ParametroCarteraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametrocartera.getVersionRow().toString()+",";
		sDescripcion+=ParametroCarteraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametrocartera.getid_empresa().toString()+",";
		sDescripcion+=ParametroCarteraConstantesFunciones.IDTRANSACCIONFACTURA+"=";
		sDescripcion+=parametrocartera.getid_transaccion_factura().toString()+",";
		sDescripcion+=ParametroCarteraConstantesFunciones.NUMERODIGITOSFACTURA+"=";
		sDescripcion+=parametrocartera.getnumero_digitos_factura().toString()+",";
		sDescripcion+=ParametroCarteraConstantesFunciones.PORLOTES+"=";
		sDescripcion+=parametrocartera.getpor_lotes().toString()+",";
		sDescripcion+=ParametroCarteraConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=parametrocartera.getid_empleado().toString()+",";
		sDescripcion+=ParametroCarteraConstantesFunciones.IDTRANSACCIONDESHABILITA+"=";
		sDescripcion+=parametrocartera.getid_transaccion_deshabilita().toString()+",";
		sDescripcion+=ParametroCarteraConstantesFunciones.IDTRANSACCIONHABILITA+"=";
		sDescripcion+=parametrocartera.getid_transaccion_habilita().toString()+",";
		sDescripcion+=ParametroCarteraConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=parametrocartera.getid_bodega().toString()+",";
		sDescripcion+=ParametroCarteraConstantesFunciones.IDTIPOFACTURA+"=";
		sDescripcion+=parametrocartera.getid_tipo_factura().toString()+",";
		sDescripcion+=ParametroCarteraConstantesFunciones.IDTIPOAUTOPAGO+"=";
		sDescripcion+=parametrocartera.getid_tipo_auto_pago().toString()+",";
		sDescripcion+=ParametroCarteraConstantesFunciones.NUMEROORDENPAGO+"=";
		sDescripcion+=parametrocartera.getnumero_orden_pago()+",";
		sDescripcion+=ParametroCarteraConstantesFunciones.IDCUENTACONTABLECREDITOFISCAL+"=";
		sDescripcion+=parametrocartera.getid_cuenta_contable_credito_fiscal().toString()+",";
		sDescripcion+=ParametroCarteraConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=parametrocartera.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroCarteraDescripcion(ParametroCartera parametrocartera,String sValor) throws Exception {			
		if(parametrocartera !=null) {
			//parametrocarteraparametrocartera.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getTransaccionDeshabilitaDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccionHabilitaDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
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

	public static String getTipoFacturaDescripcion(TipoFactura tipofactura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipofactura!=null/*&&tipofactura.getId()>0*/) {
			sDescripcion=TipoFacturaConstantesFunciones.getTipoFacturaDescripcion(tipofactura);
		}

		return sDescripcion;
	}

	public static String getTipoAutoPagoDescripcion(TipoAutoPago tipoautopago) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoautopago!=null/*&&tipoautopago.getId()>0*/) {
			sDescripcion=TipoAutoPagoConstantesFunciones.getTipoAutoPagoDescripcion(tipoautopago);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCreditoFiscalDescripcion(CuentaContable cuentacontable) {
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
		} else if(sNombreIndice.equals("FK_IdCuentaContableCreditoFiscal")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Credito Fiscal";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Tesorero";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoAutoPago")) {
			sNombreIndice="Tipo=  Por Tipo Auto Pago";
		} else if(sNombreIndice.equals("FK_IdTipoFactura")) {
			sNombreIndice="Tipo=  Por Tipo Factura";
		} else if(sNombreIndice.equals("FK_IdTransaccionDeshabilita")) {
			sNombreIndice="Tipo=  Por Transaccion Deshabilita";
		} else if(sNombreIndice.equals("FK_IdTransaccionFactura")) {
			sNombreIndice="Tipo=  Por Transaccion Factura";
		} else if(sNombreIndice.equals("FK_IdTransaccionHabilita")) {
			sNombreIndice="Tipo=  Por Transaccion Habilita";
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

	public static String getDetalleIndiceFK_IdCuentaContableCreditoFiscal(Long id_cuenta_contable_credito_fiscal) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_credito_fiscal!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Credito Fiscal="+id_cuenta_contable_credito_fiscal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Tesorero="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoAutoPago(Long id_tipo_auto_pago) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_auto_pago!=null) {sDetalleIndice+=" Codigo Unico De Tipo Auto Pago="+id_tipo_auto_pago.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoFactura(Long id_tipo_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_factura!=null) {sDetalleIndice+=" Codigo Unico De Tipo Factura="+id_tipo_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionDeshabilita(Long id_transaccion_deshabilita) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_deshabilita!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Deshabilita="+id_transaccion_deshabilita.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionFactura(Long id_transaccion_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_factura!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Factura="+id_transaccion_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionHabilita(Long id_transaccion_habilita) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_habilita!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Habilita="+id_transaccion_habilita.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroCartera(ParametroCartera parametrocartera,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		parametrocartera.setnumero_orden_pago(parametrocartera.getnumero_orden_pago().trim());
		parametrocartera.setdescripcion(parametrocartera.getdescripcion().trim());
	}
	
	public static void quitarEspaciosParametroCarteras(List<ParametroCartera> parametrocarteras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroCartera parametrocartera: parametrocarteras) {
			parametrocartera.setnumero_orden_pago(parametrocartera.getnumero_orden_pago().trim());
			parametrocartera.setdescripcion(parametrocartera.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroCartera(ParametroCartera parametrocartera,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametrocartera.getConCambioAuxiliar()) {
			parametrocartera.setIsDeleted(parametrocartera.getIsDeletedAuxiliar());	
			parametrocartera.setIsNew(parametrocartera.getIsNewAuxiliar());	
			parametrocartera.setIsChanged(parametrocartera.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametrocartera.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametrocartera.setIsDeletedAuxiliar(false);	
			parametrocartera.setIsNewAuxiliar(false);	
			parametrocartera.setIsChangedAuxiliar(false);
			
			parametrocartera.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroCarteras(List<ParametroCartera> parametrocarteras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroCartera parametrocartera : parametrocarteras) {
			if(conAsignarBase && parametrocartera.getConCambioAuxiliar()) {
				parametrocartera.setIsDeleted(parametrocartera.getIsDeletedAuxiliar());	
				parametrocartera.setIsNew(parametrocartera.getIsNewAuxiliar());	
				parametrocartera.setIsChanged(parametrocartera.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametrocartera.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametrocartera.setIsDeletedAuxiliar(false);	
				parametrocartera.setIsNewAuxiliar(false);	
				parametrocartera.setIsChangedAuxiliar(false);
				
				parametrocartera.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroCartera(ParametroCartera parametrocartera,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			parametrocartera.setnumero_digitos_factura(0);
		}
	}		
	
	public static void InicializarValoresParametroCarteras(List<ParametroCartera> parametrocarteras,Boolean conEnteros) throws Exception  {
		
		for(ParametroCartera parametrocartera: parametrocarteras) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				parametrocartera.setnumero_digitos_factura(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroCartera(List<ParametroCartera> parametrocarteras,ParametroCartera parametrocarteraAux) throws Exception  {
		ParametroCarteraConstantesFunciones.InicializarValoresParametroCartera(parametrocarteraAux,true);
		
		for(ParametroCartera parametrocartera: parametrocarteras) {
			if(parametrocartera.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			parametrocarteraAux.setnumero_digitos_factura(parametrocarteraAux.getnumero_digitos_factura()+parametrocartera.getnumero_digitos_factura());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroCartera(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroCarteraConstantesFunciones.getArrayColumnasGlobalesParametroCartera(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroCartera(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroCarteraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroCarteraConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroCartera(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroCartera> parametrocarteras,ParametroCartera parametrocartera,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroCartera parametrocarteraAux: parametrocarteras) {
			if(parametrocarteraAux!=null && parametrocartera!=null) {
				if((parametrocarteraAux.getId()==null && parametrocartera.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametrocarteraAux.getId()!=null && parametrocartera.getId()!=null){
					if(parametrocarteraAux.getId().equals(parametrocartera.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroCartera(List<ParametroCartera> parametrocarteras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroCartera parametrocartera: parametrocarteras) {			
			if(parametrocartera.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroCartera() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroCarteraConstantesFunciones.LABEL_ID, ParametroCarteraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraConstantesFunciones.LABEL_VERSIONROW, ParametroCarteraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraConstantesFunciones.LABEL_IDEMPRESA, ParametroCarteraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraConstantesFunciones.LABEL_IDTRANSACCIONFACTURA, ParametroCarteraConstantesFunciones.IDTRANSACCIONFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraConstantesFunciones.LABEL_NUMERODIGITOSFACTURA, ParametroCarteraConstantesFunciones.NUMERODIGITOSFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraConstantesFunciones.LABEL_PORLOTES, ParametroCarteraConstantesFunciones.PORLOTES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraConstantesFunciones.LABEL_IDEMPLEADO, ParametroCarteraConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraConstantesFunciones.LABEL_IDTRANSACCIONDESHABILITA, ParametroCarteraConstantesFunciones.IDTRANSACCIONDESHABILITA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraConstantesFunciones.LABEL_IDTRANSACCIONHABILITA, ParametroCarteraConstantesFunciones.IDTRANSACCIONHABILITA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraConstantesFunciones.LABEL_IDBODEGA, ParametroCarteraConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraConstantesFunciones.LABEL_IDTIPOFACTURA, ParametroCarteraConstantesFunciones.IDTIPOFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraConstantesFunciones.LABEL_IDTIPOAUTOPAGO, ParametroCarteraConstantesFunciones.IDTIPOAUTOPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraConstantesFunciones.LABEL_NUMEROORDENPAGO, ParametroCarteraConstantesFunciones.NUMEROORDENPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFISCAL, ParametroCarteraConstantesFunciones.IDCUENTACONTABLECREDITOFISCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCarteraConstantesFunciones.LABEL_DESCRIPCION, ParametroCarteraConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroCartera() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraConstantesFunciones.IDTRANSACCIONFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraConstantesFunciones.NUMERODIGITOSFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraConstantesFunciones.PORLOTES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraConstantesFunciones.IDTRANSACCIONDESHABILITA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraConstantesFunciones.IDTRANSACCIONHABILITA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraConstantesFunciones.IDTIPOFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraConstantesFunciones.IDTIPOAUTOPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraConstantesFunciones.NUMEROORDENPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraConstantesFunciones.IDCUENTACONTABLECREDITOFISCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCarteraConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroCartera() throws Exception  {
		return ParametroCarteraConstantesFunciones.getTiposSeleccionarParametroCartera(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroCartera(Boolean conFk) throws Exception  {
		return ParametroCarteraConstantesFunciones.getTiposSeleccionarParametroCartera(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroCartera(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroCarteraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraConstantesFunciones.LABEL_IDTRANSACCIONFACTURA);
			reporte.setsDescripcion(ParametroCarteraConstantesFunciones.LABEL_IDTRANSACCIONFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraConstantesFunciones.LABEL_NUMERODIGITOSFACTURA);
			reporte.setsDescripcion(ParametroCarteraConstantesFunciones.LABEL_NUMERODIGITOSFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraConstantesFunciones.LABEL_PORLOTES);
			reporte.setsDescripcion(ParametroCarteraConstantesFunciones.LABEL_PORLOTES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(ParametroCarteraConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraConstantesFunciones.LABEL_IDTRANSACCIONDESHABILITA);
			reporte.setsDescripcion(ParametroCarteraConstantesFunciones.LABEL_IDTRANSACCIONDESHABILITA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraConstantesFunciones.LABEL_IDTRANSACCIONHABILITA);
			reporte.setsDescripcion(ParametroCarteraConstantesFunciones.LABEL_IDTRANSACCIONHABILITA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ParametroCarteraConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraConstantesFunciones.LABEL_IDTIPOFACTURA);
			reporte.setsDescripcion(ParametroCarteraConstantesFunciones.LABEL_IDTIPOFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraConstantesFunciones.LABEL_IDTIPOAUTOPAGO);
			reporte.setsDescripcion(ParametroCarteraConstantesFunciones.LABEL_IDTIPOAUTOPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraConstantesFunciones.LABEL_NUMEROORDENPAGO);
			reporte.setsDescripcion(ParametroCarteraConstantesFunciones.LABEL_NUMEROORDENPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFISCAL);
			reporte.setsDescripcion(ParametroCarteraConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFISCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCarteraConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ParametroCarteraConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroCartera(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroCartera(ParametroCartera parametrocarteraAux) throws Exception {
		
			parametrocarteraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrocarteraAux.getEmpresa()));
			parametrocarteraAux.settransaccionfactura_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrocarteraAux.getTransaccionFactura()));
			parametrocarteraAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(parametrocarteraAux.getEmpleado()));
			parametrocarteraAux.settransacciondeshabilita_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrocarteraAux.getTransaccionDeshabilita()));
			parametrocarteraAux.settransaccionhabilita_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrocarteraAux.getTransaccionHabilita()));
			parametrocarteraAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametrocarteraAux.getBodega()));
			parametrocarteraAux.settipofactura_descripcion(TipoFacturaConstantesFunciones.getTipoFacturaDescripcion(parametrocarteraAux.getTipoFactura()));
			parametrocarteraAux.settipoautopago_descripcion(TipoAutoPagoConstantesFunciones.getTipoAutoPagoDescripcion(parametrocarteraAux.getTipoAutoPago()));
			parametrocarteraAux.setcuentacontablecreditofiscal_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocarteraAux.getCuentaContableCreditoFiscal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroCartera(List<ParametroCartera> parametrocarterasTemp) throws Exception {
		for(ParametroCartera parametrocarteraAux:parametrocarterasTemp) {
			
			parametrocarteraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrocarteraAux.getEmpresa()));
			parametrocarteraAux.settransaccionfactura_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrocarteraAux.getTransaccionFactura()));
			parametrocarteraAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(parametrocarteraAux.getEmpleado()));
			parametrocarteraAux.settransacciondeshabilita_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrocarteraAux.getTransaccionDeshabilita()));
			parametrocarteraAux.settransaccionhabilita_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrocarteraAux.getTransaccionHabilita()));
			parametrocarteraAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametrocarteraAux.getBodega()));
			parametrocarteraAux.settipofactura_descripcion(TipoFacturaConstantesFunciones.getTipoFacturaDescripcion(parametrocarteraAux.getTipoFactura()));
			parametrocarteraAux.settipoautopago_descripcion(TipoAutoPagoConstantesFunciones.getTipoAutoPagoDescripcion(parametrocarteraAux.getTipoAutoPago()));
			parametrocarteraAux.setcuentacontablecreditofiscal_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocarteraAux.getCuentaContableCreditoFiscal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroCartera(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(TipoFactura.class));
				classes.add(new Classe(TipoAutoPago.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
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
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFactura.class)) {
						classes.add(new Classe(TipoFactura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoAutoPago.class)) {
						classes.add(new Classe(TipoAutoPago.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroCartera(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(TipoFactura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFactura.class)); continue;
					}

					if(TipoAutoPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoAutoPago.class)); continue;
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

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(TipoFactura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFactura.class)); continue;
					}

					if(TipoAutoPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoAutoPago.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroCartera(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroCarteraConstantesFunciones.getClassesRelationshipsOfParametroCartera(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroCartera(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroCartera(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroCarteraConstantesFunciones.getClassesRelationshipsFromStringsOfParametroCartera(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroCartera(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParametroCartera parametrocartera,List<ParametroCartera> parametrocarteras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroCartera parametrocarteraEncontrado=null;
			
			for(ParametroCartera parametrocarteraLocal:parametrocarteras) {
				if(parametrocarteraLocal.getId().equals(parametrocartera.getId())) {
					parametrocarteraEncontrado=parametrocarteraLocal;
					
					parametrocarteraLocal.setIsChanged(parametrocartera.getIsChanged());
					parametrocarteraLocal.setIsNew(parametrocartera.getIsNew());
					parametrocarteraLocal.setIsDeleted(parametrocartera.getIsDeleted());
					
					parametrocarteraLocal.setGeneralEntityOriginal(parametrocartera.getGeneralEntityOriginal());
					
					parametrocarteraLocal.setId(parametrocartera.getId());	
					parametrocarteraLocal.setVersionRow(parametrocartera.getVersionRow());	
					parametrocarteraLocal.setid_empresa(parametrocartera.getid_empresa());	
					parametrocarteraLocal.setid_transaccion_factura(parametrocartera.getid_transaccion_factura());	
					parametrocarteraLocal.setnumero_digitos_factura(parametrocartera.getnumero_digitos_factura());	
					parametrocarteraLocal.setpor_lotes(parametrocartera.getpor_lotes());	
					parametrocarteraLocal.setid_empleado(parametrocartera.getid_empleado());	
					parametrocarteraLocal.setid_transaccion_deshabilita(parametrocartera.getid_transaccion_deshabilita());	
					parametrocarteraLocal.setid_transaccion_habilita(parametrocartera.getid_transaccion_habilita());	
					parametrocarteraLocal.setid_bodega(parametrocartera.getid_bodega());	
					parametrocarteraLocal.setid_tipo_factura(parametrocartera.getid_tipo_factura());	
					parametrocarteraLocal.setid_tipo_auto_pago(parametrocartera.getid_tipo_auto_pago());	
					parametrocarteraLocal.setnumero_orden_pago(parametrocartera.getnumero_orden_pago());	
					parametrocarteraLocal.setid_cuenta_contable_credito_fiscal(parametrocartera.getid_cuenta_contable_credito_fiscal());	
					parametrocarteraLocal.setdescripcion(parametrocartera.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametrocartera.getIsDeleted()) {
				if(!existe) {
					parametrocarteras.add(parametrocartera);
				}
			} else {
				if(parametrocarteraEncontrado!=null && permiteQuitar)  {
					parametrocarteras.remove(parametrocarteraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroCartera parametrocartera,List<ParametroCartera> parametrocarteras) throws Exception {
		try	{			
			for(ParametroCartera parametrocarteraLocal:parametrocarteras) {
				if(parametrocarteraLocal.getId().equals(parametrocartera.getId())) {
					parametrocarteraLocal.setIsSelected(parametrocartera.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroCartera(List<ParametroCartera> parametrocarterasAux) throws Exception {
		//this.parametrocarterasAux=parametrocarterasAux;
		
		for(ParametroCartera parametrocarteraAux:parametrocarterasAux) {
			if(parametrocarteraAux.getIsChanged()) {
				parametrocarteraAux.setIsChanged(false);
			}		
			
			if(parametrocarteraAux.getIsNew()) {
				parametrocarteraAux.setIsNew(false);
			}	
			
			if(parametrocarteraAux.getIsDeleted()) {
				parametrocarteraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroCartera(ParametroCartera parametrocarteraAux) throws Exception {
		//this.parametrocarteraAux=parametrocarteraAux;
		
			if(parametrocarteraAux.getIsChanged()) {
				parametrocarteraAux.setIsChanged(false);
			}		
			
			if(parametrocarteraAux.getIsNew()) {
				parametrocarteraAux.setIsNew(false);
			}	
			
			if(parametrocarteraAux.getIsDeleted()) {
				parametrocarteraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroCartera parametrocarteraAsignar,ParametroCartera parametrocartera) throws Exception {
		parametrocarteraAsignar.setId(parametrocartera.getId());	
		parametrocarteraAsignar.setVersionRow(parametrocartera.getVersionRow());	
		parametrocarteraAsignar.setid_empresa(parametrocartera.getid_empresa());
		parametrocarteraAsignar.setempresa_descripcion(parametrocartera.getempresa_descripcion());	
		parametrocarteraAsignar.setid_transaccion_factura(parametrocartera.getid_transaccion_factura());
		parametrocarteraAsignar.settransaccionfactura_descripcion(parametrocartera.gettransaccionfactura_descripcion());	
		parametrocarteraAsignar.setnumero_digitos_factura(parametrocartera.getnumero_digitos_factura());	
		parametrocarteraAsignar.setpor_lotes(parametrocartera.getpor_lotes());	
		parametrocarteraAsignar.setid_empleado(parametrocartera.getid_empleado());
		parametrocarteraAsignar.setempleado_descripcion(parametrocartera.getempleado_descripcion());	
		parametrocarteraAsignar.setid_transaccion_deshabilita(parametrocartera.getid_transaccion_deshabilita());
		parametrocarteraAsignar.settransacciondeshabilita_descripcion(parametrocartera.gettransacciondeshabilita_descripcion());	
		parametrocarteraAsignar.setid_transaccion_habilita(parametrocartera.getid_transaccion_habilita());
		parametrocarteraAsignar.settransaccionhabilita_descripcion(parametrocartera.gettransaccionhabilita_descripcion());	
		parametrocarteraAsignar.setid_bodega(parametrocartera.getid_bodega());
		parametrocarteraAsignar.setbodega_descripcion(parametrocartera.getbodega_descripcion());	
		parametrocarteraAsignar.setid_tipo_factura(parametrocartera.getid_tipo_factura());
		parametrocarteraAsignar.settipofactura_descripcion(parametrocartera.gettipofactura_descripcion());	
		parametrocarteraAsignar.setid_tipo_auto_pago(parametrocartera.getid_tipo_auto_pago());
		parametrocarteraAsignar.settipoautopago_descripcion(parametrocartera.gettipoautopago_descripcion());	
		parametrocarteraAsignar.setnumero_orden_pago(parametrocartera.getnumero_orden_pago());	
		parametrocarteraAsignar.setid_cuenta_contable_credito_fiscal(parametrocartera.getid_cuenta_contable_credito_fiscal());
		parametrocarteraAsignar.setcuentacontablecreditofiscal_descripcion(parametrocartera.getcuentacontablecreditofiscal_descripcion());	
		parametrocarteraAsignar.setdescripcion(parametrocartera.getdescripcion());	
	}
	
	public static void inicializarParametroCartera(ParametroCartera parametrocartera) throws Exception {
		try {
				parametrocartera.setId(0L);	
					
				parametrocartera.setid_empresa(-1L);	
				parametrocartera.setid_transaccion_factura(-1L);	
				parametrocartera.setnumero_digitos_factura(0);	
				parametrocartera.setpor_lotes(false);	
				parametrocartera.setid_empleado(-1L);	
				parametrocartera.setid_transaccion_deshabilita(-1L);	
				parametrocartera.setid_transaccion_habilita(-1L);	
				parametrocartera.setid_bodega(-1L);	
				parametrocartera.setid_tipo_factura(-1L);	
				parametrocartera.setid_tipo_auto_pago(-1L);	
				parametrocartera.setnumero_orden_pago("");	
				parametrocartera.setid_cuenta_contable_credito_fiscal(null);	
				parametrocartera.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroCartera(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraConstantesFunciones.LABEL_IDTRANSACCIONFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraConstantesFunciones.LABEL_NUMERODIGITOSFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraConstantesFunciones.LABEL_PORLOTES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraConstantesFunciones.LABEL_IDTRANSACCIONDESHABILITA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraConstantesFunciones.LABEL_IDTRANSACCIONHABILITA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraConstantesFunciones.LABEL_IDTIPOFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraConstantesFunciones.LABEL_IDTIPOAUTOPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraConstantesFunciones.LABEL_NUMEROORDENPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFISCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCarteraConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroCartera(String sTipo,Row row,Workbook workbook,ParametroCartera parametrocartera,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocartera.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocartera.gettransaccionfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocartera.getnumero_digitos_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrocartera.getpor_lotes()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocartera.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocartera.gettransacciondeshabilita_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocartera.gettransaccionhabilita_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocartera.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocartera.gettipofactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocartera.gettipoautopago_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocartera.getnumero_orden_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocartera.getcuentacontablecreditofiscal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocartera.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroCartera=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroCartera() {
		return this.sFinalQueryParametroCartera;
	}
	
	public void setsFinalQueryParametroCartera(String sFinalQueryParametroCartera) {
		this.sFinalQueryParametroCartera= sFinalQueryParametroCartera;
	}
	
	public Border resaltarSeleccionarParametroCartera=null;
	
	public Border setResaltarSeleccionarParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametrocarteraBeanSwingJInternalFrame.jTtoolBarParametroCartera.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroCartera= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroCartera() {
		return this.resaltarSeleccionarParametroCartera;
	}
	
	public void setResaltarSeleccionarParametroCartera(Border borderResaltarSeleccionarParametroCartera) {
		this.resaltarSeleccionarParametroCartera= borderResaltarSeleccionarParametroCartera;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroCartera=null;
	public Boolean mostraridParametroCartera=true;
	public Boolean activaridParametroCartera=true;

	public Border resaltarid_empresaParametroCartera=null;
	public Boolean mostrarid_empresaParametroCartera=true;
	public Boolean activarid_empresaParametroCartera=true;
	public Boolean cargarid_empresaParametroCartera=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroCartera=false;//ConEventDepend=true

	public Border resaltarid_transaccion_facturaParametroCartera=null;
	public Boolean mostrarid_transaccion_facturaParametroCartera=true;
	public Boolean activarid_transaccion_facturaParametroCartera=true;
	public Boolean cargarid_transaccion_facturaParametroCartera=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_facturaParametroCartera=false;//ConEventDepend=true

	public Border resaltarnumero_digitos_facturaParametroCartera=null;
	public Boolean mostrarnumero_digitos_facturaParametroCartera=true;
	public Boolean activarnumero_digitos_facturaParametroCartera=true;

	public Border resaltarpor_lotesParametroCartera=null;
	public Boolean mostrarpor_lotesParametroCartera=true;
	public Boolean activarpor_lotesParametroCartera=true;

	public Border resaltarid_empleadoParametroCartera=null;
	public Boolean mostrarid_empleadoParametroCartera=true;
	public Boolean activarid_empleadoParametroCartera=true;
	public Boolean cargarid_empleadoParametroCartera=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoParametroCartera=false;//ConEventDepend=true

	public Border resaltarid_transaccion_deshabilitaParametroCartera=null;
	public Boolean mostrarid_transaccion_deshabilitaParametroCartera=true;
	public Boolean activarid_transaccion_deshabilitaParametroCartera=true;
	public Boolean cargarid_transaccion_deshabilitaParametroCartera=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_deshabilitaParametroCartera=false;//ConEventDepend=true

	public Border resaltarid_transaccion_habilitaParametroCartera=null;
	public Boolean mostrarid_transaccion_habilitaParametroCartera=true;
	public Boolean activarid_transaccion_habilitaParametroCartera=true;
	public Boolean cargarid_transaccion_habilitaParametroCartera=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_habilitaParametroCartera=false;//ConEventDepend=true

	public Border resaltarid_bodegaParametroCartera=null;
	public Boolean mostrarid_bodegaParametroCartera=true;
	public Boolean activarid_bodegaParametroCartera=true;
	public Boolean cargarid_bodegaParametroCartera=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaParametroCartera=false;//ConEventDepend=true

	public Border resaltarid_tipo_facturaParametroCartera=null;
	public Boolean mostrarid_tipo_facturaParametroCartera=true;
	public Boolean activarid_tipo_facturaParametroCartera=true;
	public Boolean cargarid_tipo_facturaParametroCartera=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_facturaParametroCartera=false;//ConEventDepend=true

	public Border resaltarid_tipo_auto_pagoParametroCartera=null;
	public Boolean mostrarid_tipo_auto_pagoParametroCartera=true;
	public Boolean activarid_tipo_auto_pagoParametroCartera=true;
	public Boolean cargarid_tipo_auto_pagoParametroCartera=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_auto_pagoParametroCartera=false;//ConEventDepend=true

	public Border resaltarnumero_orden_pagoParametroCartera=null;
	public Boolean mostrarnumero_orden_pagoParametroCartera=true;
	public Boolean activarnumero_orden_pagoParametroCartera=true;

	public Border resaltarid_cuenta_contable_credito_fiscalParametroCartera=null;
	public Boolean mostrarid_cuenta_contable_credito_fiscalParametroCartera=true;
	public Boolean activarid_cuenta_contable_credito_fiscalParametroCartera=true;
	public Boolean cargarid_cuenta_contable_credito_fiscalParametroCartera=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_credito_fiscalParametroCartera=false;//ConEventDepend=true

	public Border resaltardescripcionParametroCartera=null;
	public Boolean mostrardescripcionParametroCartera=true;
	public Boolean activardescripcionParametroCartera=true;

	
	

	public Border setResaltaridParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteraBeanSwingJInternalFrame.jTtoolBarParametroCartera.setBorder(borderResaltar);
		
		this.resaltaridParametroCartera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroCartera() {
		return this.resaltaridParametroCartera;
	}

	public void setResaltaridParametroCartera(Border borderResaltar) {
		this.resaltaridParametroCartera= borderResaltar;
	}

	public Boolean getMostraridParametroCartera() {
		return this.mostraridParametroCartera;
	}

	public void setMostraridParametroCartera(Boolean mostraridParametroCartera) {
		this.mostraridParametroCartera= mostraridParametroCartera;
	}

	public Boolean getActivaridParametroCartera() {
		return this.activaridParametroCartera;
	}

	public void setActivaridParametroCartera(Boolean activaridParametroCartera) {
		this.activaridParametroCartera= activaridParametroCartera;
	}

	public Border setResaltarid_empresaParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteraBeanSwingJInternalFrame.jTtoolBarParametroCartera.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroCartera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroCartera() {
		return this.resaltarid_empresaParametroCartera;
	}

	public void setResaltarid_empresaParametroCartera(Border borderResaltar) {
		this.resaltarid_empresaParametroCartera= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroCartera() {
		return this.mostrarid_empresaParametroCartera;
	}

	public void setMostrarid_empresaParametroCartera(Boolean mostrarid_empresaParametroCartera) {
		this.mostrarid_empresaParametroCartera= mostrarid_empresaParametroCartera;
	}

	public Boolean getActivarid_empresaParametroCartera() {
		return this.activarid_empresaParametroCartera;
	}

	public void setActivarid_empresaParametroCartera(Boolean activarid_empresaParametroCartera) {
		this.activarid_empresaParametroCartera= activarid_empresaParametroCartera;
	}

	public Boolean getCargarid_empresaParametroCartera() {
		return this.cargarid_empresaParametroCartera;
	}

	public void setCargarid_empresaParametroCartera(Boolean cargarid_empresaParametroCartera) {
		this.cargarid_empresaParametroCartera= cargarid_empresaParametroCartera;
	}

	public Border setResaltarid_transaccion_facturaParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteraBeanSwingJInternalFrame.jTtoolBarParametroCartera.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_facturaParametroCartera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_facturaParametroCartera() {
		return this.resaltarid_transaccion_facturaParametroCartera;
	}

	public void setResaltarid_transaccion_facturaParametroCartera(Border borderResaltar) {
		this.resaltarid_transaccion_facturaParametroCartera= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_facturaParametroCartera() {
		return this.mostrarid_transaccion_facturaParametroCartera;
	}

	public void setMostrarid_transaccion_facturaParametroCartera(Boolean mostrarid_transaccion_facturaParametroCartera) {
		this.mostrarid_transaccion_facturaParametroCartera= mostrarid_transaccion_facturaParametroCartera;
	}

	public Boolean getActivarid_transaccion_facturaParametroCartera() {
		return this.activarid_transaccion_facturaParametroCartera;
	}

	public void setActivarid_transaccion_facturaParametroCartera(Boolean activarid_transaccion_facturaParametroCartera) {
		this.activarid_transaccion_facturaParametroCartera= activarid_transaccion_facturaParametroCartera;
	}

	public Boolean getCargarid_transaccion_facturaParametroCartera() {
		return this.cargarid_transaccion_facturaParametroCartera;
	}

	public void setCargarid_transaccion_facturaParametroCartera(Boolean cargarid_transaccion_facturaParametroCartera) {
		this.cargarid_transaccion_facturaParametroCartera= cargarid_transaccion_facturaParametroCartera;
	}

	public Border setResaltarnumero_digitos_facturaParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteraBeanSwingJInternalFrame.jTtoolBarParametroCartera.setBorder(borderResaltar);
		
		this.resaltarnumero_digitos_facturaParametroCartera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_digitos_facturaParametroCartera() {
		return this.resaltarnumero_digitos_facturaParametroCartera;
	}

	public void setResaltarnumero_digitos_facturaParametroCartera(Border borderResaltar) {
		this.resaltarnumero_digitos_facturaParametroCartera= borderResaltar;
	}

	public Boolean getMostrarnumero_digitos_facturaParametroCartera() {
		return this.mostrarnumero_digitos_facturaParametroCartera;
	}

	public void setMostrarnumero_digitos_facturaParametroCartera(Boolean mostrarnumero_digitos_facturaParametroCartera) {
		this.mostrarnumero_digitos_facturaParametroCartera= mostrarnumero_digitos_facturaParametroCartera;
	}

	public Boolean getActivarnumero_digitos_facturaParametroCartera() {
		return this.activarnumero_digitos_facturaParametroCartera;
	}

	public void setActivarnumero_digitos_facturaParametroCartera(Boolean activarnumero_digitos_facturaParametroCartera) {
		this.activarnumero_digitos_facturaParametroCartera= activarnumero_digitos_facturaParametroCartera;
	}

	public Border setResaltarpor_lotesParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteraBeanSwingJInternalFrame.jTtoolBarParametroCartera.setBorder(borderResaltar);
		
		this.resaltarpor_lotesParametroCartera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpor_lotesParametroCartera() {
		return this.resaltarpor_lotesParametroCartera;
	}

	public void setResaltarpor_lotesParametroCartera(Border borderResaltar) {
		this.resaltarpor_lotesParametroCartera= borderResaltar;
	}

	public Boolean getMostrarpor_lotesParametroCartera() {
		return this.mostrarpor_lotesParametroCartera;
	}

	public void setMostrarpor_lotesParametroCartera(Boolean mostrarpor_lotesParametroCartera) {
		this.mostrarpor_lotesParametroCartera= mostrarpor_lotesParametroCartera;
	}

	public Boolean getActivarpor_lotesParametroCartera() {
		return this.activarpor_lotesParametroCartera;
	}

	public void setActivarpor_lotesParametroCartera(Boolean activarpor_lotesParametroCartera) {
		this.activarpor_lotesParametroCartera= activarpor_lotesParametroCartera;
	}

	public Border setResaltarid_empleadoParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteraBeanSwingJInternalFrame.jTtoolBarParametroCartera.setBorder(borderResaltar);
		
		this.resaltarid_empleadoParametroCartera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoParametroCartera() {
		return this.resaltarid_empleadoParametroCartera;
	}

	public void setResaltarid_empleadoParametroCartera(Border borderResaltar) {
		this.resaltarid_empleadoParametroCartera= borderResaltar;
	}

	public Boolean getMostrarid_empleadoParametroCartera() {
		return this.mostrarid_empleadoParametroCartera;
	}

	public void setMostrarid_empleadoParametroCartera(Boolean mostrarid_empleadoParametroCartera) {
		this.mostrarid_empleadoParametroCartera= mostrarid_empleadoParametroCartera;
	}

	public Boolean getActivarid_empleadoParametroCartera() {
		return this.activarid_empleadoParametroCartera;
	}

	public void setActivarid_empleadoParametroCartera(Boolean activarid_empleadoParametroCartera) {
		this.activarid_empleadoParametroCartera= activarid_empleadoParametroCartera;
	}

	public Boolean getCargarid_empleadoParametroCartera() {
		return this.cargarid_empleadoParametroCartera;
	}

	public void setCargarid_empleadoParametroCartera(Boolean cargarid_empleadoParametroCartera) {
		this.cargarid_empleadoParametroCartera= cargarid_empleadoParametroCartera;
	}

	public Border setResaltarid_transaccion_deshabilitaParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteraBeanSwingJInternalFrame.jTtoolBarParametroCartera.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_deshabilitaParametroCartera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_deshabilitaParametroCartera() {
		return this.resaltarid_transaccion_deshabilitaParametroCartera;
	}

	public void setResaltarid_transaccion_deshabilitaParametroCartera(Border borderResaltar) {
		this.resaltarid_transaccion_deshabilitaParametroCartera= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_deshabilitaParametroCartera() {
		return this.mostrarid_transaccion_deshabilitaParametroCartera;
	}

	public void setMostrarid_transaccion_deshabilitaParametroCartera(Boolean mostrarid_transaccion_deshabilitaParametroCartera) {
		this.mostrarid_transaccion_deshabilitaParametroCartera= mostrarid_transaccion_deshabilitaParametroCartera;
	}

	public Boolean getActivarid_transaccion_deshabilitaParametroCartera() {
		return this.activarid_transaccion_deshabilitaParametroCartera;
	}

	public void setActivarid_transaccion_deshabilitaParametroCartera(Boolean activarid_transaccion_deshabilitaParametroCartera) {
		this.activarid_transaccion_deshabilitaParametroCartera= activarid_transaccion_deshabilitaParametroCartera;
	}

	public Boolean getCargarid_transaccion_deshabilitaParametroCartera() {
		return this.cargarid_transaccion_deshabilitaParametroCartera;
	}

	public void setCargarid_transaccion_deshabilitaParametroCartera(Boolean cargarid_transaccion_deshabilitaParametroCartera) {
		this.cargarid_transaccion_deshabilitaParametroCartera= cargarid_transaccion_deshabilitaParametroCartera;
	}

	public Border setResaltarid_transaccion_habilitaParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteraBeanSwingJInternalFrame.jTtoolBarParametroCartera.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_habilitaParametroCartera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_habilitaParametroCartera() {
		return this.resaltarid_transaccion_habilitaParametroCartera;
	}

	public void setResaltarid_transaccion_habilitaParametroCartera(Border borderResaltar) {
		this.resaltarid_transaccion_habilitaParametroCartera= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_habilitaParametroCartera() {
		return this.mostrarid_transaccion_habilitaParametroCartera;
	}

	public void setMostrarid_transaccion_habilitaParametroCartera(Boolean mostrarid_transaccion_habilitaParametroCartera) {
		this.mostrarid_transaccion_habilitaParametroCartera= mostrarid_transaccion_habilitaParametroCartera;
	}

	public Boolean getActivarid_transaccion_habilitaParametroCartera() {
		return this.activarid_transaccion_habilitaParametroCartera;
	}

	public void setActivarid_transaccion_habilitaParametroCartera(Boolean activarid_transaccion_habilitaParametroCartera) {
		this.activarid_transaccion_habilitaParametroCartera= activarid_transaccion_habilitaParametroCartera;
	}

	public Boolean getCargarid_transaccion_habilitaParametroCartera() {
		return this.cargarid_transaccion_habilitaParametroCartera;
	}

	public void setCargarid_transaccion_habilitaParametroCartera(Boolean cargarid_transaccion_habilitaParametroCartera) {
		this.cargarid_transaccion_habilitaParametroCartera= cargarid_transaccion_habilitaParametroCartera;
	}

	public Border setResaltarid_bodegaParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteraBeanSwingJInternalFrame.jTtoolBarParametroCartera.setBorder(borderResaltar);
		
		this.resaltarid_bodegaParametroCartera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaParametroCartera() {
		return this.resaltarid_bodegaParametroCartera;
	}

	public void setResaltarid_bodegaParametroCartera(Border borderResaltar) {
		this.resaltarid_bodegaParametroCartera= borderResaltar;
	}

	public Boolean getMostrarid_bodegaParametroCartera() {
		return this.mostrarid_bodegaParametroCartera;
	}

	public void setMostrarid_bodegaParametroCartera(Boolean mostrarid_bodegaParametroCartera) {
		this.mostrarid_bodegaParametroCartera= mostrarid_bodegaParametroCartera;
	}

	public Boolean getActivarid_bodegaParametroCartera() {
		return this.activarid_bodegaParametroCartera;
	}

	public void setActivarid_bodegaParametroCartera(Boolean activarid_bodegaParametroCartera) {
		this.activarid_bodegaParametroCartera= activarid_bodegaParametroCartera;
	}

	public Boolean getCargarid_bodegaParametroCartera() {
		return this.cargarid_bodegaParametroCartera;
	}

	public void setCargarid_bodegaParametroCartera(Boolean cargarid_bodegaParametroCartera) {
		this.cargarid_bodegaParametroCartera= cargarid_bodegaParametroCartera;
	}

	public Border setResaltarid_tipo_facturaParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteraBeanSwingJInternalFrame.jTtoolBarParametroCartera.setBorder(borderResaltar);
		
		this.resaltarid_tipo_facturaParametroCartera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_facturaParametroCartera() {
		return this.resaltarid_tipo_facturaParametroCartera;
	}

	public void setResaltarid_tipo_facturaParametroCartera(Border borderResaltar) {
		this.resaltarid_tipo_facturaParametroCartera= borderResaltar;
	}

	public Boolean getMostrarid_tipo_facturaParametroCartera() {
		return this.mostrarid_tipo_facturaParametroCartera;
	}

	public void setMostrarid_tipo_facturaParametroCartera(Boolean mostrarid_tipo_facturaParametroCartera) {
		this.mostrarid_tipo_facturaParametroCartera= mostrarid_tipo_facturaParametroCartera;
	}

	public Boolean getActivarid_tipo_facturaParametroCartera() {
		return this.activarid_tipo_facturaParametroCartera;
	}

	public void setActivarid_tipo_facturaParametroCartera(Boolean activarid_tipo_facturaParametroCartera) {
		this.activarid_tipo_facturaParametroCartera= activarid_tipo_facturaParametroCartera;
	}

	public Boolean getCargarid_tipo_facturaParametroCartera() {
		return this.cargarid_tipo_facturaParametroCartera;
	}

	public void setCargarid_tipo_facturaParametroCartera(Boolean cargarid_tipo_facturaParametroCartera) {
		this.cargarid_tipo_facturaParametroCartera= cargarid_tipo_facturaParametroCartera;
	}

	public Border setResaltarid_tipo_auto_pagoParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteraBeanSwingJInternalFrame.jTtoolBarParametroCartera.setBorder(borderResaltar);
		
		this.resaltarid_tipo_auto_pagoParametroCartera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_auto_pagoParametroCartera() {
		return this.resaltarid_tipo_auto_pagoParametroCartera;
	}

	public void setResaltarid_tipo_auto_pagoParametroCartera(Border borderResaltar) {
		this.resaltarid_tipo_auto_pagoParametroCartera= borderResaltar;
	}

	public Boolean getMostrarid_tipo_auto_pagoParametroCartera() {
		return this.mostrarid_tipo_auto_pagoParametroCartera;
	}

	public void setMostrarid_tipo_auto_pagoParametroCartera(Boolean mostrarid_tipo_auto_pagoParametroCartera) {
		this.mostrarid_tipo_auto_pagoParametroCartera= mostrarid_tipo_auto_pagoParametroCartera;
	}

	public Boolean getActivarid_tipo_auto_pagoParametroCartera() {
		return this.activarid_tipo_auto_pagoParametroCartera;
	}

	public void setActivarid_tipo_auto_pagoParametroCartera(Boolean activarid_tipo_auto_pagoParametroCartera) {
		this.activarid_tipo_auto_pagoParametroCartera= activarid_tipo_auto_pagoParametroCartera;
	}

	public Boolean getCargarid_tipo_auto_pagoParametroCartera() {
		return this.cargarid_tipo_auto_pagoParametroCartera;
	}

	public void setCargarid_tipo_auto_pagoParametroCartera(Boolean cargarid_tipo_auto_pagoParametroCartera) {
		this.cargarid_tipo_auto_pagoParametroCartera= cargarid_tipo_auto_pagoParametroCartera;
	}

	public Border setResaltarnumero_orden_pagoParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteraBeanSwingJInternalFrame.jTtoolBarParametroCartera.setBorder(borderResaltar);
		
		this.resaltarnumero_orden_pagoParametroCartera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_orden_pagoParametroCartera() {
		return this.resaltarnumero_orden_pagoParametroCartera;
	}

	public void setResaltarnumero_orden_pagoParametroCartera(Border borderResaltar) {
		this.resaltarnumero_orden_pagoParametroCartera= borderResaltar;
	}

	public Boolean getMostrarnumero_orden_pagoParametroCartera() {
		return this.mostrarnumero_orden_pagoParametroCartera;
	}

	public void setMostrarnumero_orden_pagoParametroCartera(Boolean mostrarnumero_orden_pagoParametroCartera) {
		this.mostrarnumero_orden_pagoParametroCartera= mostrarnumero_orden_pagoParametroCartera;
	}

	public Boolean getActivarnumero_orden_pagoParametroCartera() {
		return this.activarnumero_orden_pagoParametroCartera;
	}

	public void setActivarnumero_orden_pagoParametroCartera(Boolean activarnumero_orden_pagoParametroCartera) {
		this.activarnumero_orden_pagoParametroCartera= activarnumero_orden_pagoParametroCartera;
	}

	public Border setResaltarid_cuenta_contable_credito_fiscalParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteraBeanSwingJInternalFrame.jTtoolBarParametroCartera.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_credito_fiscalParametroCartera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_credito_fiscalParametroCartera() {
		return this.resaltarid_cuenta_contable_credito_fiscalParametroCartera;
	}

	public void setResaltarid_cuenta_contable_credito_fiscalParametroCartera(Border borderResaltar) {
		this.resaltarid_cuenta_contable_credito_fiscalParametroCartera= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_credito_fiscalParametroCartera() {
		return this.mostrarid_cuenta_contable_credito_fiscalParametroCartera;
	}

	public void setMostrarid_cuenta_contable_credito_fiscalParametroCartera(Boolean mostrarid_cuenta_contable_credito_fiscalParametroCartera) {
		this.mostrarid_cuenta_contable_credito_fiscalParametroCartera= mostrarid_cuenta_contable_credito_fiscalParametroCartera;
	}

	public Boolean getActivarid_cuenta_contable_credito_fiscalParametroCartera() {
		return this.activarid_cuenta_contable_credito_fiscalParametroCartera;
	}

	public void setActivarid_cuenta_contable_credito_fiscalParametroCartera(Boolean activarid_cuenta_contable_credito_fiscalParametroCartera) {
		this.activarid_cuenta_contable_credito_fiscalParametroCartera= activarid_cuenta_contable_credito_fiscalParametroCartera;
	}

	public Boolean getCargarid_cuenta_contable_credito_fiscalParametroCartera() {
		return this.cargarid_cuenta_contable_credito_fiscalParametroCartera;
	}

	public void setCargarid_cuenta_contable_credito_fiscalParametroCartera(Boolean cargarid_cuenta_contable_credito_fiscalParametroCartera) {
		this.cargarid_cuenta_contable_credito_fiscalParametroCartera= cargarid_cuenta_contable_credito_fiscalParametroCartera;
	}

	public Border setResaltardescripcionParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocarteraBeanSwingJInternalFrame.jTtoolBarParametroCartera.setBorder(borderResaltar);
		
		this.resaltardescripcionParametroCartera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionParametroCartera() {
		return this.resaltardescripcionParametroCartera;
	}

	public void setResaltardescripcionParametroCartera(Border borderResaltar) {
		this.resaltardescripcionParametroCartera= borderResaltar;
	}

	public Boolean getMostrardescripcionParametroCartera() {
		return this.mostrardescripcionParametroCartera;
	}

	public void setMostrardescripcionParametroCartera(Boolean mostrardescripcionParametroCartera) {
		this.mostrardescripcionParametroCartera= mostrardescripcionParametroCartera;
	}

	public Boolean getActivardescripcionParametroCartera() {
		return this.activardescripcionParametroCartera;
	}

	public void setActivardescripcionParametroCartera(Boolean activardescripcionParametroCartera) {
		this.activardescripcionParametroCartera= activardescripcionParametroCartera;
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
		
		
		this.setMostraridParametroCartera(esInicial);
		this.setMostrarid_empresaParametroCartera(esInicial);
		this.setMostrarid_transaccion_facturaParametroCartera(esInicial);
		this.setMostrarnumero_digitos_facturaParametroCartera(esInicial);
		this.setMostrarpor_lotesParametroCartera(esInicial);
		this.setMostrarid_empleadoParametroCartera(esInicial);
		this.setMostrarid_transaccion_deshabilitaParametroCartera(esInicial);
		this.setMostrarid_transaccion_habilitaParametroCartera(esInicial);
		this.setMostrarid_bodegaParametroCartera(esInicial);
		this.setMostrarid_tipo_facturaParametroCartera(esInicial);
		this.setMostrarid_tipo_auto_pagoParametroCartera(esInicial);
		this.setMostrarnumero_orden_pagoParametroCartera(esInicial);
		this.setMostrarid_cuenta_contable_credito_fiscalParametroCartera(esInicial);
		this.setMostrardescripcionParametroCartera(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.ID)) {
				this.setMostraridParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDTRANSACCIONFACTURA)) {
				this.setMostrarid_transaccion_facturaParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.NUMERODIGITOSFACTURA)) {
				this.setMostrarnumero_digitos_facturaParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.PORLOTES)) {
				this.setMostrarpor_lotesParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDTRANSACCIONDESHABILITA)) {
				this.setMostrarid_transaccion_deshabilitaParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDTRANSACCIONHABILITA)) {
				this.setMostrarid_transaccion_habilitaParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDTIPOFACTURA)) {
				this.setMostrarid_tipo_facturaParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDTIPOAUTOPAGO)) {
				this.setMostrarid_tipo_auto_pagoParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.NUMEROORDENPAGO)) {
				this.setMostrarnumero_orden_pagoParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDCUENTACONTABLECREDITOFISCAL)) {
				this.setMostrarid_cuenta_contable_credito_fiscalParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionParametroCartera(esAsigna);
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
		
		
		this.setActivaridParametroCartera(esInicial);
		this.setActivarid_empresaParametroCartera(esInicial);
		this.setActivarid_transaccion_facturaParametroCartera(esInicial);
		this.setActivarnumero_digitos_facturaParametroCartera(esInicial);
		this.setActivarpor_lotesParametroCartera(esInicial);
		this.setActivarid_empleadoParametroCartera(esInicial);
		this.setActivarid_transaccion_deshabilitaParametroCartera(esInicial);
		this.setActivarid_transaccion_habilitaParametroCartera(esInicial);
		this.setActivarid_bodegaParametroCartera(esInicial);
		this.setActivarid_tipo_facturaParametroCartera(esInicial);
		this.setActivarid_tipo_auto_pagoParametroCartera(esInicial);
		this.setActivarnumero_orden_pagoParametroCartera(esInicial);
		this.setActivarid_cuenta_contable_credito_fiscalParametroCartera(esInicial);
		this.setActivardescripcionParametroCartera(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.ID)) {
				this.setActivaridParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDTRANSACCIONFACTURA)) {
				this.setActivarid_transaccion_facturaParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.NUMERODIGITOSFACTURA)) {
				this.setActivarnumero_digitos_facturaParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.PORLOTES)) {
				this.setActivarpor_lotesParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDTRANSACCIONDESHABILITA)) {
				this.setActivarid_transaccion_deshabilitaParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDTRANSACCIONHABILITA)) {
				this.setActivarid_transaccion_habilitaParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDTIPOFACTURA)) {
				this.setActivarid_tipo_facturaParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDTIPOAUTOPAGO)) {
				this.setActivarid_tipo_auto_pagoParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.NUMEROORDENPAGO)) {
				this.setActivarnumero_orden_pagoParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDCUENTACONTABLECREDITOFISCAL)) {
				this.setActivarid_cuenta_contable_credito_fiscalParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionParametroCartera(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroCartera(esInicial);
		this.setResaltarid_empresaParametroCartera(esInicial);
		this.setResaltarid_transaccion_facturaParametroCartera(esInicial);
		this.setResaltarnumero_digitos_facturaParametroCartera(esInicial);
		this.setResaltarpor_lotesParametroCartera(esInicial);
		this.setResaltarid_empleadoParametroCartera(esInicial);
		this.setResaltarid_transaccion_deshabilitaParametroCartera(esInicial);
		this.setResaltarid_transaccion_habilitaParametroCartera(esInicial);
		this.setResaltarid_bodegaParametroCartera(esInicial);
		this.setResaltarid_tipo_facturaParametroCartera(esInicial);
		this.setResaltarid_tipo_auto_pagoParametroCartera(esInicial);
		this.setResaltarnumero_orden_pagoParametroCartera(esInicial);
		this.setResaltarid_cuenta_contable_credito_fiscalParametroCartera(esInicial);
		this.setResaltardescripcionParametroCartera(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.ID)) {
				this.setResaltaridParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDTRANSACCIONFACTURA)) {
				this.setResaltarid_transaccion_facturaParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.NUMERODIGITOSFACTURA)) {
				this.setResaltarnumero_digitos_facturaParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.PORLOTES)) {
				this.setResaltarpor_lotesParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDTRANSACCIONDESHABILITA)) {
				this.setResaltarid_transaccion_deshabilitaParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDTRANSACCIONHABILITA)) {
				this.setResaltarid_transaccion_habilitaParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDTIPOFACTURA)) {
				this.setResaltarid_tipo_facturaParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDTIPOAUTOPAGO)) {
				this.setResaltarid_tipo_auto_pagoParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.NUMEROORDENPAGO)) {
				this.setResaltarnumero_orden_pagoParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.IDCUENTACONTABLECREDITOFISCAL)) {
				this.setResaltarid_cuenta_contable_credito_fiscalParametroCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCarteraConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionParametroCartera(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaParametroCartera=true;

	public Boolean getMostrarFK_IdBodegaParametroCartera() {
		return this.mostrarFK_IdBodegaParametroCartera;
	}

	public void setMostrarFK_IdBodegaParametroCartera(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaParametroCartera= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCreditoFiscalParametroCartera=true;

	public Boolean getMostrarFK_IdCuentaContableCreditoFiscalParametroCartera() {
		return this.mostrarFK_IdCuentaContableCreditoFiscalParametroCartera;
	}

	public void setMostrarFK_IdCuentaContableCreditoFiscalParametroCartera(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCreditoFiscalParametroCartera= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoParametroCartera=true;

	public Boolean getMostrarFK_IdEmpleadoParametroCartera() {
		return this.mostrarFK_IdEmpleadoParametroCartera;
	}

	public void setMostrarFK_IdEmpleadoParametroCartera(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoParametroCartera= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaParametroCartera=true;

	public Boolean getMostrarFK_IdEmpresaParametroCartera() {
		return this.mostrarFK_IdEmpresaParametroCartera;
	}

	public void setMostrarFK_IdEmpresaParametroCartera(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroCartera= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoAutoPagoParametroCartera=true;

	public Boolean getMostrarFK_IdTipoAutoPagoParametroCartera() {
		return this.mostrarFK_IdTipoAutoPagoParametroCartera;
	}

	public void setMostrarFK_IdTipoAutoPagoParametroCartera(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoAutoPagoParametroCartera= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoFacturaParametroCartera=true;

	public Boolean getMostrarFK_IdTipoFacturaParametroCartera() {
		return this.mostrarFK_IdTipoFacturaParametroCartera;
	}

	public void setMostrarFK_IdTipoFacturaParametroCartera(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoFacturaParametroCartera= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionDeshabilitaParametroCartera=true;

	public Boolean getMostrarFK_IdTransaccionDeshabilitaParametroCartera() {
		return this.mostrarFK_IdTransaccionDeshabilitaParametroCartera;
	}

	public void setMostrarFK_IdTransaccionDeshabilitaParametroCartera(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionDeshabilitaParametroCartera= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionFacturaParametroCartera=true;

	public Boolean getMostrarFK_IdTransaccionFacturaParametroCartera() {
		return this.mostrarFK_IdTransaccionFacturaParametroCartera;
	}

	public void setMostrarFK_IdTransaccionFacturaParametroCartera(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionFacturaParametroCartera= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionHabilitaParametroCartera=true;

	public Boolean getMostrarFK_IdTransaccionHabilitaParametroCartera() {
		return this.mostrarFK_IdTransaccionHabilitaParametroCartera;
	}

	public void setMostrarFK_IdTransaccionHabilitaParametroCartera(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionHabilitaParametroCartera= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaParametroCartera=true;

	public Boolean getActivarFK_IdBodegaParametroCartera() {
		return this.activarFK_IdBodegaParametroCartera;
	}

	public void setActivarFK_IdBodegaParametroCartera(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaParametroCartera= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCreditoFiscalParametroCartera=true;

	public Boolean getActivarFK_IdCuentaContableCreditoFiscalParametroCartera() {
		return this.activarFK_IdCuentaContableCreditoFiscalParametroCartera;
	}

	public void setActivarFK_IdCuentaContableCreditoFiscalParametroCartera(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCreditoFiscalParametroCartera= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoParametroCartera=true;

	public Boolean getActivarFK_IdEmpleadoParametroCartera() {
		return this.activarFK_IdEmpleadoParametroCartera;
	}

	public void setActivarFK_IdEmpleadoParametroCartera(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoParametroCartera= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaParametroCartera=true;

	public Boolean getActivarFK_IdEmpresaParametroCartera() {
		return this.activarFK_IdEmpresaParametroCartera;
	}

	public void setActivarFK_IdEmpresaParametroCartera(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroCartera= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoAutoPagoParametroCartera=true;

	public Boolean getActivarFK_IdTipoAutoPagoParametroCartera() {
		return this.activarFK_IdTipoAutoPagoParametroCartera;
	}

	public void setActivarFK_IdTipoAutoPagoParametroCartera(Boolean habilitarResaltar) {
		this.activarFK_IdTipoAutoPagoParametroCartera= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoFacturaParametroCartera=true;

	public Boolean getActivarFK_IdTipoFacturaParametroCartera() {
		return this.activarFK_IdTipoFacturaParametroCartera;
	}

	public void setActivarFK_IdTipoFacturaParametroCartera(Boolean habilitarResaltar) {
		this.activarFK_IdTipoFacturaParametroCartera= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionDeshabilitaParametroCartera=true;

	public Boolean getActivarFK_IdTransaccionDeshabilitaParametroCartera() {
		return this.activarFK_IdTransaccionDeshabilitaParametroCartera;
	}

	public void setActivarFK_IdTransaccionDeshabilitaParametroCartera(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionDeshabilitaParametroCartera= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionFacturaParametroCartera=true;

	public Boolean getActivarFK_IdTransaccionFacturaParametroCartera() {
		return this.activarFK_IdTransaccionFacturaParametroCartera;
	}

	public void setActivarFK_IdTransaccionFacturaParametroCartera(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionFacturaParametroCartera= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionHabilitaParametroCartera=true;

	public Boolean getActivarFK_IdTransaccionHabilitaParametroCartera() {
		return this.activarFK_IdTransaccionHabilitaParametroCartera;
	}

	public void setActivarFK_IdTransaccionHabilitaParametroCartera(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionHabilitaParametroCartera= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaParametroCartera=null;

	public Border getResaltarFK_IdBodegaParametroCartera() {
		return this.resaltarFK_IdBodegaParametroCartera;
	}

	public void setResaltarFK_IdBodegaParametroCartera(Border borderResaltar) {
		this.resaltarFK_IdBodegaParametroCartera= borderResaltar;
	}

	public void setResaltarFK_IdBodegaParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaParametroCartera= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCreditoFiscalParametroCartera=null;

	public Border getResaltarFK_IdCuentaContableCreditoFiscalParametroCartera() {
		return this.resaltarFK_IdCuentaContableCreditoFiscalParametroCartera;
	}

	public void setResaltarFK_IdCuentaContableCreditoFiscalParametroCartera(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCreditoFiscalParametroCartera= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCreditoFiscalParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCreditoFiscalParametroCartera= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoParametroCartera=null;

	public Border getResaltarFK_IdEmpleadoParametroCartera() {
		return this.resaltarFK_IdEmpleadoParametroCartera;
	}

	public void setResaltarFK_IdEmpleadoParametroCartera(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoParametroCartera= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoParametroCartera= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaParametroCartera=null;

	public Border getResaltarFK_IdEmpresaParametroCartera() {
		return this.resaltarFK_IdEmpresaParametroCartera;
	}

	public void setResaltarFK_IdEmpresaParametroCartera(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroCartera= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroCartera= borderResaltar;
	}

	public Border resaltarFK_IdTipoAutoPagoParametroCartera=null;

	public Border getResaltarFK_IdTipoAutoPagoParametroCartera() {
		return this.resaltarFK_IdTipoAutoPagoParametroCartera;
	}

	public void setResaltarFK_IdTipoAutoPagoParametroCartera(Border borderResaltar) {
		this.resaltarFK_IdTipoAutoPagoParametroCartera= borderResaltar;
	}

	public void setResaltarFK_IdTipoAutoPagoParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoAutoPagoParametroCartera= borderResaltar;
	}

	public Border resaltarFK_IdTipoFacturaParametroCartera=null;

	public Border getResaltarFK_IdTipoFacturaParametroCartera() {
		return this.resaltarFK_IdTipoFacturaParametroCartera;
	}

	public void setResaltarFK_IdTipoFacturaParametroCartera(Border borderResaltar) {
		this.resaltarFK_IdTipoFacturaParametroCartera= borderResaltar;
	}

	public void setResaltarFK_IdTipoFacturaParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoFacturaParametroCartera= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionDeshabilitaParametroCartera=null;

	public Border getResaltarFK_IdTransaccionDeshabilitaParametroCartera() {
		return this.resaltarFK_IdTransaccionDeshabilitaParametroCartera;
	}

	public void setResaltarFK_IdTransaccionDeshabilitaParametroCartera(Border borderResaltar) {
		this.resaltarFK_IdTransaccionDeshabilitaParametroCartera= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionDeshabilitaParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionDeshabilitaParametroCartera= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionFacturaParametroCartera=null;

	public Border getResaltarFK_IdTransaccionFacturaParametroCartera() {
		return this.resaltarFK_IdTransaccionFacturaParametroCartera;
	}

	public void setResaltarFK_IdTransaccionFacturaParametroCartera(Border borderResaltar) {
		this.resaltarFK_IdTransaccionFacturaParametroCartera= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionFacturaParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionFacturaParametroCartera= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionHabilitaParametroCartera=null;

	public Border getResaltarFK_IdTransaccionHabilitaParametroCartera() {
		return this.resaltarFK_IdTransaccionHabilitaParametroCartera;
	}

	public void setResaltarFK_IdTransaccionHabilitaParametroCartera(Border borderResaltar) {
		this.resaltarFK_IdTransaccionHabilitaParametroCartera= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionHabilitaParametroCartera(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCarteraBeanSwingJInternalFrame parametrocarteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionHabilitaParametroCartera= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}